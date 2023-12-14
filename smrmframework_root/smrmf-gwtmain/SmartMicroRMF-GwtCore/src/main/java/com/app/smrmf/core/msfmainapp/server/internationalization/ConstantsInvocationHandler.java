/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.server.internationalization;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gwt.i18n.client.Constants;
import com.google.gwt.i18n.client.ConstantsWithLookup;
import com.google.gwt.i18n.client.LocalizableResource;
import com.google.gwt.i18n.rebind.keygen.KeyGenerator;

final class ConstantsInvocationHandler implements ConstantsWithLookup, InvocationHandler {

    private static final Logger logger = LoggerFactory.getLogger(ConstantsInvocationHandler.class);

    private static String buildDefaultText(String[] vals, int skip) {
        if (vals == null)
            return null;

        StringBuilder buf = new StringBuilder();
        boolean first = true;

        for (int i = 0; i < vals.length; i += skip) {
            if (first)
                first = false;
            else
                buf.append(',');

            buf.append(vals[i].replace("\\", "\\\\").replace(",", "\\,"));
        }

        return buf.toString();
    }

    private static String generateKey(KeyGenerator kg, String className, Method m, Object defaultValue) {
        if (kg == null)
            return m.getName();

        String meaningText = null;
        LocalizableResource.Meaning meaning = m.getAnnotation(LocalizableResource.Meaning.class);
        if (meaning != null)
            meaningText = meaning.value();

        return kg.generateKey(className, m.getName(), (defaultValue != null ? defaultValue.toString() : null), meaningText);
    }

    private static String[] split(String target) {
        // This is the same split logic as in ConstantsStringArrayMethodCreator.split().
        //
        // We add an artificial end character to avoid the odd split() behavior
        // that drops the last item if it is only whitespace.
        target = target + "~";

        // Do not split on escaped commas.
        String[] args = target.split("(?<![\\\\]),");

        // Now remove the artificial ending we added above.
        // We have to do it before we escape and trim because otherwise
        // the artificial trailing '~' would prevent the last item from being
        // properly trimmed.
        if (args.length > 0) {
            int last = args.length - 1;
            args[last] = args[last].substring(0, args[last].length() - 1);
        }

        for (int i = 0; i < args.length; i++)
            args[i] = args[i].replaceAll("\\\\,", ",").trim();

        return args;
    }

    private final Class<?> cls;
    private final boolean hasLookups;

    private final Map<Method, Object> values = new HashMap<Method, Object>();

    ConstantsInvocationHandler(Class<?> cls, KeyGenerator kg, Map<String, String> properties) {
        this.cls = cls;
        this.hasLookups = ConstantsWithLookup.class.isAssignableFrom(cls);

        String className = cls.getName();

        for (Method m : cls.getMethods()) {
            if (hasLookups && m.getDeclaringClass().equals(ConstantsWithLookup.class))
                continue; // skip lookup methods

            if (m.getParameterTypes().length > 0)
                throw new IllegalArgumentException(className + '.' + m.getName() + "() must not take an argument");

            Object defaultValue = null;
            Object translatedValue = null;

            String methodKey = null;
            LocalizableResource.Key key = m.getAnnotation(LocalizableResource.Key.class);
            if (key != null)
                methodKey = key.value();

            Class<?> returnType = m.getReturnType();

            if (returnType.equals(String.class)) { // === String ===

                Constants.DefaultStringValue dv = m.getAnnotation(Constants.DefaultStringValue.class);
                if (dv != null)
                    defaultValue = dv.value();

                if (methodKey == null)
                    methodKey = generateKey(kg, className, m, defaultValue);

                if (properties != null)
                    translatedValue = properties.get(methodKey);

            } else if (returnType.equals(int.class)) { // === primitive int ===

                Constants.DefaultIntValue dv = m.getAnnotation(Constants.DefaultIntValue.class);
                if (dv != null)
                    defaultValue = dv.value();

                if (methodKey == null)
                    methodKey = generateKey(kg, className, m, defaultValue);

                if (properties != null) {
                    String translatedText = properties.get(methodKey);
                    if (translatedText != null)
                        translatedValue = Integer.valueOf(translatedText);
                }

            } else if (returnType.equals(float.class)) { // === primitive float ===

                Constants.DefaultFloatValue dv = m.getAnnotation(Constants.DefaultFloatValue.class);
                if (dv != null)
                    defaultValue = dv.value();

                if (methodKey == null)
                    methodKey = generateKey(kg, className, m, defaultValue);

                if (properties != null) {
                    String translatedText = properties.get(methodKey);
                    if (translatedText != null)
                        translatedValue = Float.valueOf(translatedText);
                }

            } else if (returnType.equals(double.class)) { // === primitive double ===

                Constants.DefaultDoubleValue dv = m.getAnnotation(Constants.DefaultDoubleValue.class);
                if (dv != null)
                    defaultValue = dv.value();

                if (methodKey == null)
                    methodKey = generateKey(kg, className, m, defaultValue);

                if (properties != null) {
                    String translatedText = properties.get(methodKey);
                    if (translatedText != null)
                        translatedValue = Double.valueOf(translatedText);
                }

            } else if (returnType.equals(boolean.class)) { // === primitive boolean ===

                Constants.DefaultBooleanValue dv = m.getAnnotation(Constants.DefaultBooleanValue.class);
                if (dv != null)
                    defaultValue = dv.value();

                if (methodKey == null)
                    methodKey = generateKey(kg, className, m, defaultValue);

                if (properties != null) {
                    String translatedText = properties.get(methodKey);
                    if (translatedText != null)
                        translatedValue = Boolean.valueOf(translatedText);
                }

            } else if (returnType.equals(String[].class)) { // === String[] ===

                Constants.DefaultStringArrayValue dv = m.getAnnotation(Constants.DefaultStringArrayValue.class);
                if (dv != null)
                    defaultValue = dv.value();

                if (methodKey == null) {
                    // short-circuit by avoiding default value creation if unneeded
                    if (kg != null) {
                        String defaultValueText = buildDefaultText((String[])defaultValue, 1);
                        methodKey = generateKey(kg, className, m, defaultValueText);
                    } else
                        methodKey = m.getName();
                }

                if (properties != null) {
                    String translatedValueText = properties.get(methodKey);
                    if (translatedValueText != null)
                        translatedValue = split(translatedValueText);
                }

            } else if (returnType.equals(Map.class)) { // === Map (actually Map<String, String>) ===

                String[] defaultValueArray = null;
                Constants.DefaultStringMapValue dv = m.getAnnotation(Constants.DefaultStringMapValue.class);
                if (dv != null)
                    defaultValueArray = dv.value();

                Map<String, String> defaultValueMap = new HashMap<String, String>();
                for (int i = 0; i < defaultValueArray.length; i += 2)
                    defaultValueMap.put(defaultValueArray[i], defaultValueArray[i + 1]);

                defaultValue = Collections.unmodifiableMap(defaultValueMap);

                if (methodKey == null) {
                    // short-circuit by avoiding default value creation if unneeded
                    if (kg != null) {
                        String defaultValueText = buildDefaultText(defaultValueArray, 2);
                        methodKey = generateKey(kg, className, m, defaultValueText);
                    } else
                        methodKey = m.getName();
                }

                if (properties != null) {
                    String translatedValueText = properties.get(methodKey);
                    if (translatedValueText != null) {
                        String[] translatedKeys = split(translatedValueText);
                        Map<String, String> translatedValueMap = new HashMap<String, String>();

                        for (String tk : translatedKeys)
                            translatedValueMap.put(tk, properties.get(tk));

                        translatedValue = Collections.unmodifiableMap(translatedValueMap);
                    }
                }

            } else
                throw new IllegalArgumentException(className + '.' + m.getName() + "() returns unsupported type " + returnType);

            if (translatedValue != null)
                values.put(m, translatedValue);
            else if (defaultValue != null)
                values.put(m, defaultValue);
        }
    }

    private Object get(String methodName) throws MissingResourceException {
        for (Map.Entry<Method, Object> e : values.entrySet())
            if (e.getKey().getName().equals(methodName))
                return e.getValue();

        throw new MissingResourceException("missing resource: " + methodName, cls.getName(), methodName);
    }

    public boolean getBoolean(String methodName) throws MissingResourceException {
        return (Boolean)get(methodName);
    }

    public double getDouble(String methodName) throws MissingResourceException {
        return (Double)get(methodName);
    }

    public float getFloat(String methodName) throws MissingResourceException {
        return (Float)get(methodName);
    }

    public int getInt(String methodName) throws MissingResourceException {
        return (Integer)get(methodName);
    }

    @SuppressWarnings("unchecked")
    public Map<String, String> getMap(String methodName) throws MissingResourceException {
        return (Map<String, String>)get(methodName);
    }

    public String getString(String methodName) throws MissingResourceException {
        return (String)get(methodName);
    }

    public String[] getStringArray(String methodName) throws MissingResourceException {
        return (String[])get(methodName);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (hasLookups && method.getDeclaringClass().equals(ConstantsWithLookup.class)) {
            return method.invoke(this, args);
        }

        if (!values.containsKey(method)) {
            logger.debug("missing resource: " + method + " " + cls.getName() + " " + method.getName());
            return null;
        }

        return values.get(method);
    }
}
