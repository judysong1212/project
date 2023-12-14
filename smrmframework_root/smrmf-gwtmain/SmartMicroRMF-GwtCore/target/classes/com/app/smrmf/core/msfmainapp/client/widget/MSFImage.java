/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.widget;

import java.util.Map;

import com.extjs.gxt.ui.client.core.FastMap;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;

public class MSFImage extends Image {
    private Map<String, Object> dataMap;
    private String id;

    public MSFImage(){
        super();
    }
    
    public void setToolTip(String tooltip) {
        setTitle(tooltip);
    }
    
    public void setIcon(ImageResource imageResource){
        setResource(imageResource);
    }

    public void setData(String key, Object data) {
        if (dataMap == null) dataMap = new FastMap<Object>();
        dataMap.put(key, data);
    }

    /**
     * Returns the application defined property for the given name, or
     * <code>null</code> if it has not been set.
     * 
     * @param key the name of the property
     * @return the value or <code>null</code> if it has not been set
     */
    @SuppressWarnings("unchecked")
    public <X> X getData(String key) {
        if (dataMap == null) return null;
        return (X) dataMap.get(key);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

}
