/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.utils;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.Button;

public class MSFFormWindows extends com.extjs.gxt.ui.client.widget.Window {

	 public MSFFormWindows(final String title, final ContentPanel contentPanel, final String btTitleCancel,String width,String height,Boolean bModel) {
	        super();
	       // setHeading(title);
	        setHeadingText(title);
	        setIcon(MSFMainApp.ICONS.form());
	        setMaximizable(false);
	        setResizable(false);
	        setWidth(width);
	       //setAutoWidth(true);
	        setAutoHeight(true);
	        setModal(bModel);
	        add(contentPanel);
	        
	        Button b1 = new Button(btTitleCancel);
	        b1.addSelectionListener(new SelectionListener<ButtonEvent>() {
	            public void componentSelected(ButtonEvent ce) {
	                hide();
	            }
	        });
	        addButton(b1);
	    }
	
    public MSFFormWindows(final String title, final ContentPanel contentPanel, final String btTitleCancel) {
        super();
        //setHeading(title);
        setHeadingText(title);
        setIcon(MSFMainApp.ICONS.form());
        setMaximizable(false);
        setResizable(false);
       // setWidth(490);
        setAutoWidth(true);
        setAutoHeight(true);
        setModal(true);
        add(contentPanel);
        
        Button b1 = new Button(btTitleCancel);
        b1.addSelectionListener(new SelectionListener<ButtonEvent>() {
            public void componentSelected(ButtonEvent ce) {
                hide();
            }
        });
        addButton(b1);
    }

    public MSFFormWindows(final String title, final MSFFormPanel formPanel, final String btTitleSave,final String btTitleCancel) {
        super();
      //  setHeading(title);
        setHeadingText(title);
        setIcon(MSFMainApp.ICONS.form());
        setMaximizable(false);
        setResizable(false);
       // setWidth(490);
        setAutoWidth(true);
        setAutoHeight(true);
        setModal(true);
        add(formPanel);

        Button b1 = new Button(btTitleSave);
        b1.addSelectionListener(new SelectionListener<ButtonEvent>() {
            public void componentSelected(ButtonEvent ce) {
                saveForm(formPanel);
            }
        });
        addButton(b1);

        Button b2 = new Button(btTitleCancel);
        b2.addSelectionListener(new SelectionListener<ButtonEvent>() {
            public void componentSelected(ButtonEvent ce) {
                hideForm(formPanel);
            }
        });
        addButton(b2);
    }
     
    
    protected void saveForm(MSFFormPanel formPanel) {
        formPanel.save();
    }

    protected void hideForm(MSFFormPanel formPanel) {
        formPanel.restoreValues();
        hide();
    }

}
