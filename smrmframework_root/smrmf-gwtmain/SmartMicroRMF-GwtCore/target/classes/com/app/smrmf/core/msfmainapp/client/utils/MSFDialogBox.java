/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.utils;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;


public class MSFDialogBox extends Window {

    public MSFDialogBox(final int width, final int height, final String title, ContentPanel content) {

        setTitle(title);  
        setIconStyle("paste-icon");  
        setMaximizable(true);  
        setResizable(true);  
        setLayout(new FitLayout());  
        setWidth(width);  
        setHeight(height);  
        setModal(false);  

        //another way to add button
        Button btnClose = new Button("닫기");
        addButton(btnClose);
        btnClose.addSelectionListener(new SelectionListener<ButtonEvent>() {
            public void componentSelected(ButtonEvent ce) {
                hide();
            }
        });

        add(content);

    }

}
