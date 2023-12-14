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
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;

import com.google.gwt.i18n.client.LocalizableResource;
import com.google.gwt.i18n.client.Messages;
import com.google.gwt.i18n.rebind.keygen.KeyGenerator;

final class MessagesInvocationHandler implements InvocationHandler {
    private final Class<?> cls;
    private final Map<Method, MessageFormat> fmts = new HashMap<Method, MessageFormat>();

    MessagesInvocationHandler(Class<?> cls, KeyGenerator kg, Map<String, String> properties) {
        this.cls = cls;

        for (Method m : cls.getMethods()) {
            String methodKey = null;
            LocalizableResource.Key key = m.getAnnotation(LocalizableResource.Key.class);
            if (key != null)
                methodKey = key.value();

            String defaultMessageText = null;
            Messages.DefaultMessage defaultMessage = m.getAnnotation(Messages.DefaultMessage.class);
            if (defaultMessage != null)
                defaultMessageText = defaultMessage.value();

            if (methodKey == null) {
                if (kg != null) {
                    String meaningText = null;
                    LocalizableResource.Meaning meaning = m.getAnnotation(LocalizableResource.Meaning.class);
                    if (meaning != null)
                        meaningText = meaning.value();

                    methodKey = kg.generateKey(cls.getName(), m.getName(), defaultMessageText, meaningText);
                } else
                    methodKey = m.getName();
            }

            String translatedMessageText = null;
            if (properties != null)
                translatedMessageText = properties.get(methodKey);

            if (translatedMessageText != null)
                fmts.put(m, new MessageFormat(translatedMessageText));
            else if (defaultMessageText != null)
                fmts.put(m, new MessageFormat(defaultMessageText));
        }
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MessageFormat fmt = fmts.get(method);

        if (fmt == null)
            throw new MissingResourceException("missing resource: " + method, cls.getName(), method.getName());

        return fmt.format(args);
    }
}
