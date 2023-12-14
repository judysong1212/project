/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.widget;


//  import com.extjs.gxt.ui.client.GXT;
//  import com.extjs.gxt.ui.client.core.El;
//  import com.extjs.gxt.ui.client.widget.ComponentHelper;
//  import com.extjs.gxt.ui.client.widget.button.Button;
//  import com.extjs.gxt.ui.client.widget.form.TextField;
//  import com.google.gwt.user.client.DOM;
//  import com.google.gwt.user.client.Element;
//  public class TextFieldWithButton extends TextField 
//  private El wrap;
//  private El input;
//  private final Button button;
//  private final int buttonOffset = 3;
//  public TextFieldWithButtonButton button this.button = button;
//  Override
//  protected void doAttachChildren super.doAttachChildren;ComponentHelper.doAttachbutton;Overrideprotected void doDetachChildren super.doDetachChildren;ComponentHelper.doDetachbutton;Overrideprotected El getInputEl return input;Overrideprotected void onAttach super.onAttach;wrap.removeStyleNamefieldStyle;if GXT.isIE int y1, y2;if y1 = input.getY = y2 = el.getParent.getY int dif = y2 - y1;input.setTopdif;Overrideprotected void onRenderElement target, int index wrap = new ElDOM.createDiv;wrap.addStyleName"x-form-field-wrap";wrap.addStyleName"x-form-file-wrap";input = new ElDOM.createInputText;input.addStyleNamefieldStyle;input.addStyleName"x-form-file-text";input.setStyleAttribute"color", "#000000";wrap.appendChildinput.dom;setElementwrap.dom, target, index;super.onRendertarget, index;button.addStyleName"x-form-file-btn";button.renderwrap.dom;if width == null setWidth150;Overrideprotected void onResizeint width, int height super.onResizewidth, height;input.setWidthwrap.getWidth - button.el.getWidth - buttonOffset;
// 
