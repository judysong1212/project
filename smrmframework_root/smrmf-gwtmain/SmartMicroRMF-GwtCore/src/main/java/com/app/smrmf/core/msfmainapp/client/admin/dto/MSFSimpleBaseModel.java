/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.admin.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MSFSimpleBaseModel implements Serializable {

    private static final long serialVersionUID = 1L;
    protected HashMap<String, Object> values;

    public MSFSimpleBaseModel() {
        init();
    }

    private void init() {
        if ( values==null ) {
            values = new HashMap<String, Object>();
        }
    }

    public Object get(String key) {
        Object value = values!=null ? values.get(key) : null;
        return value;
    }

    public void set(String key, Object value) {
        init();
        values.put(key, value);
    }

    public Collection<String> getPropertyNames() {
        Set<String> set = new HashSet<String>();
        if (values != null) {
            set.addAll(values.keySet());
        }
        return set;
    }

    public HashMap<String, Object> getProperties() {
        return values;
    }

    public void setProperties(HashMap<String, Object> values) {
        this.values = values;
    }
     
    public void setProperties(Map<String, Object> properties) {
      for (String property : properties.keySet()) {
        set(property, properties.get(property));
      }
    }

}
