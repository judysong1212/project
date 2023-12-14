/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.listner;

import com.extjs.gxt.ui.client.widget.form.Field;


public interface ColumnDefListener {

	void run(Field field, Object valueField);

    void initialize(Field f);

}
