/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.app.smrmf.core.resources.client;

import com.app.smrmf.core.resources.client.icons.ApplicazioneIcons;
import com.app.smrmf.core.resources.client.icons.CustomIcons;
import com.app.smrmf.core.resources.client.images.ApplicazioneImages;

import com.google.gwt.core.client.GWT;

public class Resources {

  public static final ApplicazioneImages APP_IMAGES = GWT.create(ApplicazioneImages.class);
  public static final ApplicazioneIcons APP_ICONS = GWT.create(ApplicazioneIcons.class);
  public static final CustomIcons CUST_ICONS = GWT.create(CustomIcons.class); 

}
