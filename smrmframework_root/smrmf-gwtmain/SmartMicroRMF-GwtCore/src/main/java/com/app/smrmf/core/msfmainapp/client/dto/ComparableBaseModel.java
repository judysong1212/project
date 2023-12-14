/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.dto;

import java.util.Iterator;

import com.extjs.gxt.ui.client.data.BaseModel;

public class ComparableBaseModel extends BaseModel {

    private static final long serialVersionUID = 1L;

    public ComparableBaseModel() {
        super();
    }

    @Override
    public boolean equals(Object obj) {
        if ( obj!=null && obj instanceof BaseModel && 
             this.map!=null && this.map.keySet()!=null && this.map.keySet().iterator()!=null ) {
            Iterator<String> keyIterator = this.map.keySet().iterator();
            boolean sameValue = true;
            while ( keyIterator.hasNext() && sameValue ) {
                String key = keyIterator.next();
                Object thisValue = this.get(key);
                Object objValue  = ((BaseModel)obj).get(key);
                sameValue =
                    (thisValue==null && objValue==null) ||
                    (thisValue!=null && thisValue.equals(objValue));
            }
            return sameValue;
        }
        return false;
    }

}
