/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.server.internationalization;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

import org.apache.tapestry.util.text.LocalizedPropertiesLoader;

import com.google.gwt.i18n.client.Constants;
import com.google.gwt.i18n.client.ConstantsWithLookup;
import com.google.gwt.i18n.client.Localizable;
import com.google.gwt.i18n.client.LocalizableResource;
import com.google.gwt.i18n.client.Messages;
import com.google.gwt.i18n.rebind.keygen.KeyGenerator;
import com.google.gwt.i18n.shared.GwtLocale;

public final class I18nFactory {
    /**
     * A map from class to locale-ref(Proxy or Class) map. This type is ugly, but it helps ensure type safety.
     */
    private static final Map<Class<? extends Localizable>, Map<String, ? extends Reference<?>>> instances = new WeakHashMap<Class<? extends Localizable>, Map<String, ? extends Reference<?>>>();

    /**
     * Create a localized object for a given locale. The search order for locale-specific instances is determined by {@link GwtLocale#getCompleteSearchList()}. If the class is an instance of
     * {@link Constants}, {@link ConstantsWithLookup}, or {@link Messages}, properties files will be used as with GWT compiltion rules. Other classes will use the concrete type search rules defined in
     * the javadoc for {@link Localizable}, and will return a new instance (using the no-arg constructor) on every call.
     * 
     * @param cls type of {@link Localizable} class
     * @param locale locale for which an instance is desired
     * @return instance of localized class
     */
    public static <T extends Localizable> T create(Class<T> cls, GwtLocale locale) {
        if (LocalizableResource.class.isAssignableFrom(cls)) {
            // LocalizableResource subinterfaces are markers for interfaces that provide proxies only.
            if (!cls.isInterface())
                throw new IllegalArgumentException(cls.getName() + " is not an interface");

            // We only support trees rooted at Constants or Messages.
            if (!Constants.class.isAssignableFrom(cls) && !Messages.class.isAssignableFrom(cls))
                throw new IllegalArgumentException(cls.getName() + " extends neither Constants nor Messages");

            return createResource(cls, locale);
        }

        // If not a LocalizableResource, then we are looking for a concrete Class.
        return createInstance(cls, locale);
    }

    private static <T extends Localizable> T createInstance(Class<T> cls, GwtLocale locale) {
        Map<String, Reference<Class<? extends T>>> classMap;

        synchronized (instances) {
            // We relax type safety for a moment to create a more strict map type.
            @SuppressWarnings("unchecked")
            Map<String, Reference<Class<? extends T>>> cmap = (Map)instances.get(cls);

            if (cmap == null)
                instances.put(cls, cmap = new HashMap<String, Reference<Class<? extends T>>>());

            classMap = cmap;
        }

        String localeStr = locale.toString();

        synchronized (classMap) {
            Class<? extends T> concreteClass = null;

            for (GwtLocale l : locale.getCompleteSearchList()) {
                String lstr = l.toString();
                Reference<Class<? extends T>> ref = classMap.get(lstr);

                // If we have a pre-existing instance, stop here.
                if (ref != null) {
                    concreteClass = ref.get();

                    if (concreteClass != null) {
                        // If the locale searched is not the locale requested, cache the reference at the more specific level.
                        if (!lstr.equals(localeStr))
                            classMap.put(localeStr, ref);

                        break;
                    }
                }

                // No pre-existing instance, so try a concrete implementation.
                if (lstr.equals(GwtLocale.DEFAULT_LOCALE)) {
                    if (cls.isInterface()) {
                        // Interface: concrete class is name of interface plus a single '_'.
                        try {
                            // (isolate the unchecked warning here)
                            @SuppressWarnings("unchecked")
                            Class<? extends T> c = (Class<? extends T>)Class.forName(cls.getName() + '_', false, cls.getClassLoader());

                            if (!cls.isAssignableFrom(c))
                                throw new ClassCastException("concrete class " + c.getName() + " does not implement class " + cls.getName());

                            concreteClass = c;
                        } catch (ClassNotFoundException ignored) {
                            // concreteClass remains null
                        }
                    } else {
                        // It already is a concrete class: use as-is.
                        concreteClass = cls;
                    }
                } else {
                    // Look for class name with locale string appended after a '_'.
                    try {
                        // (isolate the unchecked warning here)
                        @SuppressWarnings("unchecked")
                        Class<? extends T> c = (Class<? extends T>)Class.forName(cls.getName() + '_' + lstr, false, cls.getClassLoader());

                        if (!cls.isAssignableFrom(c))
                            throw new ClassCastException("concrete class " + c.getName() + " does not implement class " + cls.getName());

                        concreteClass = c;
                    } catch (ClassNotFoundException ignored) {
                        // concreteClass remains null; checking the next one
                    }
                }

                if (concreteClass != null) {
                    ref = new SoftReference<Class<? extends T>>(concreteClass);

                    // stash both at the actual locale's name (for future lookups)...
                    classMap.put(lstr, ref);

                    // ...and at the more specific locale's name.
                    if (!lstr.equals(localeStr))
                        classMap.put(localeStr, ref);

                    break;
                }
            }

            // Don't ever return null; throw if we could not create an instance.
            if (concreteClass == null)
                throw new RuntimeException("could not create " + cls.getName() + " instance for locale " + localeStr);

            try {
                return concreteClass.newInstance();
            } catch (RuntimeException e) {
                throw e; // don't wrap
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static <T extends Localizable> T createResource(Class<T> cls, GwtLocale locale) {
        Map<String, Reference<T>> resourceMap;

        synchronized (instances) {
            // We relax type safety for a moment to create a more strict map type.
            @SuppressWarnings("unchecked")
            Map<String, Reference<T>> resMap = (Map)instances.get(cls);

            if (resMap == null)
                instances.put(cls, resMap = new HashMap<String, Reference<T>>());

            resourceMap = resMap;
        }

        String localeStr = locale.toString();

        synchronized (resourceMap) {
            T proxy = null;

            for (GwtLocale l : locale.getCompleteSearchList()) {
                String lstr = l.toString();
                Reference<T> ref = resourceMap.get(lstr);

                // If we have a pre-existing instance, stop here.
                if (ref != null) {
                    proxy = ref.get();

                    if (proxy != null) {
                        // If the locale searched is not the locale requested, cache the reference at the more specific level.
                        if (!lstr.equals(localeStr))
                            resourceMap.put(localeStr, ref);

                        break;
                    }
                }

                // No pre-existing instance, so attempt a lookup of a properties file.
                InputStream in = null;
                in = cls.getResourceAsStream(cls.getSimpleName() + '_' + lstr + ".properties");
                if ( in == null ) {
                    //Use fallback property file
                    in = cls.getResourceAsStream(cls.getSimpleName() + ".properties");
                }

                try {
                    if (in != null)
                        proxy = createResourceProxy(cls, in);

                    // If that failed, and this is the default locale, use reflection on annotations.
                    if (proxy == null && lstr.equals(GwtLocale.DEFAULT_LOCALE))
                        proxy = createResourceProxy(cls, null);
                } catch (IOException e) {
                    throw new TypeNotPresentException(cls.getName(), e);
                }

                // If either of the above created an instance, stash it and stop here.
                if (proxy != null) {
                    ref = new SoftReference<T>(proxy);

                    // stash both at the actual locale's name (for future lookups)...
                    resourceMap.put(lstr, ref);

                    // ...and at the more specific locale's name.
                    if (!lstr.equals(localeStr))
                        resourceMap.put(localeStr, ref);

                    break;
                }
            }

            // Don't ever return null; throw if we could not create an instance.
            if (proxy == null)
                throw new RuntimeException("could not create " + cls.getName() + " instance for locale " + localeStr);

            return proxy;
        }
    }

    private static <T extends Localizable> T createResourceProxy(Class<T> cls, InputStream in) throws IOException {
        Map<String, String> properties = null;

        // only initialize the properties map if one was found
        // (otherwise, this is basically the default locale)
        if (in != null) {
            properties = new HashMap<String, String>();
            new LocalizedPropertiesLoader(in, "utf8").load(properties);
            in.close();
        }

        KeyGenerator kg = null;
        LocalizableResource.GenerateKeys kgannot = cls.getAnnotation(LocalizableResource.GenerateKeys.class);
        String kgname = (kgannot != null ? kgannot.value() : null);

        if (kgname != null)
            try {
                // (isolate the unchecked warning here)
                @SuppressWarnings("unchecked")
                Class<? extends KeyGenerator> kgclass = (Class<? extends KeyGenerator>)Class.forName(kgname, true, cls.getClassLoader());

                kg = kgclass.newInstance();
            } catch (Exception e) {
                // yes, wrap runtime exceptions too (e.g., ClassCastException) for uniformity here
                throw new TypeNotPresentException(kgname, e);
            }

        InvocationHandler h;

        if (Constants.class.isAssignableFrom(cls))
            h = new ConstantsInvocationHandler(cls, kg, properties);
        else
            h = new MessagesInvocationHandler(cls, kg, properties);

        @SuppressWarnings("unchecked")
        T proxy = (T)Proxy.newProxyInstance(cls.getClassLoader(), new Class[] {
            cls
        }, h);

        return proxy;
    }

    private I18nFactory() {
    }
}
