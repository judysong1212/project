/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.def;

import com.extjs.gxt.ui.client.Registry;

/**
 * It's a content to client variables, to use between panel (grid, form, etc). 
 * Can set global variables, they will never be deleted. Only by calling the remove method,
 * you can remove them.
 * The others type are the simple variable and they will died, when use the get method
 */
public class ClientSession {
    
    public ClientSession(){
        
    }

    /**
     * Adds a global variable
     * @param name  Name of the variable
     * @param value Generic object
     */
    public void addGlobalAttribute(String name, Object value) {
        Registry.register("$"+name, value);
    }

    /**
     * Adds a simple variable, it will died when call the get method
     * @param name  Name of the variable
     * @param value Generic object
     */
    public void addAttribute(String name, Object value) {
        Registry.register(name, value);
    }

    /**
     * Returns the value of the variable with the specified name
     * @param name Name of the variable
     * @return The value as Object
     */
    public Object get(String name) {
        Object o = null;
        if (Registry.get("$"+name) != null) {
            o = Registry.get("$"+name);
        } else if (Registry.get(name) != null) {
            o = Registry.get(name);
            Registry.unregister(name);
        }
        return o;
    }

    /**
     * Removes the variable with the specified name
     * @param name Name of the variable
     */
    public void remove(String name) {
        Registry.unregister(name);
    }
    
    public Long getLong(String name) {
        Object o = get(name);
        if (o != null && o instanceof Long) {
            return (Long)o;
        }
        return null;
    }

    public String getString(String name) {
        Object o = get(name);
        if (o != null && o instanceof String) {
            return (String)o;
        }
        return null;
    }
}
