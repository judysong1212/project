/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.widget;

import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.widget.ComponentHelper;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;

@SuppressWarnings("deprecation")
public class TextFieldWithButton<D> extends TextField<D> {    

    private El wrap;
    private El input;
    private final Button button;
    private final int buttonOffset = 3;

    public TextFieldWithButton(Button button) {
        this.button = button;
    }

    @Override
    protected void doAttachChildren() {
        super.doAttachChildren();
        ComponentHelper.doAttach(button);
    }

    @Override
    protected void doDetachChildren() {
        super.doDetachChildren();
        ComponentHelper.doDetach(button);
    }

    @Override
    protected El getInputEl() {
        return input;
    }

    @Override
    protected void onAttach() {
        super.onAttach();
        wrap.removeStyleName(fieldStyle);
        if (GXT.isIE) {
            int y1, y2;
            if ((y1 = input.getY()) != (y2 = el().getParent().getY())) {
                int dif = y2 - y1;
                input.setTop(dif);
            }
        }
    }

    @Override
    protected void onRender(Element target, int index) {
        wrap = new El(DOM.createDiv());
        wrap.addStyleName("x-form-field-wrap");
        wrap.addStyleName("x-form-file-wrap");

        input = new El(DOM.createInputText());
        input.addStyleName(fieldStyle);
        input.addStyleName("x-form-file-text");
        input.setStyleAttribute("color", "#000000");

        wrap.appendChild(input.dom);

        setElement(wrap.dom, target, index);
        super.onRender(target, index);
        GWTUtils.setCustomStyles(this);
        button.addStyleName("x-form-file-btn");
        button.render(wrap.dom);

        if (width == null) {
            setWidth(150);
        }
    }

    @Override
    protected void onResize(int width, int height) {
        super.onResize(width, height);
        input.setWidth(wrap.getWidth() - button.el().getWidth() - buttonOffset);
    }
}


// EXAMPLE
//public void onModuleLoad() {
//
//    FormPanel form = new FormPanel();
//
//    TextFieldWithButton<String> field = new TextFieldWithButton<String>(new Button("button"));
//    field.setFieldLabel("field");
//
//    TextField<String> t = new TextField<String>();
//    t.setFieldLabel("other field");
//
//    form.add(field);
//    form.add(t);
//
//    RootPanel.get().add(form);
//}