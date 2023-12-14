/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.form;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.admin.dto.ElementoMenu;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Label;
import com.msfgwt.reflection.client.ClassType;
import com.msfgwt.reflection.client.Constructor;
import com.msfgwt.reflection.client.TypeOracle;


/**
 * This class holds all information to create a new LayoutContainer using the method createWindow().
 * It is used by the menu Entry to hold all information, but creation of the Window is done
 * only when menu item is clicked.
 * 
 */
public class WindowFactory {

    protected String windowClassName;
    protected ElementoMenu elementoMenu;

    /**
     * Empty constructor
     */
//    public WindowFactory() {
//    }

    /**
     * Constructor with initialization of all parameters.
     * @param windowClassName
     *              the name of the class that extends LayoutContainer
     * @param elementoMenu
     *              the ElementoMenu that holds all information of the menu entry
     */
//    public WindowFactory(String windowClassName, ElementoMenu elementoMenu) {
//        this.windowClassName = windowClassName;
//        this.elementoMenu = elementoMenu;
//    }

    /**
     * Static method to get a WindowFactory already initialized with its windowClassName.
     * This is useful if the Window is a simple LayoutContainer not initialized using a Menu Item.
     * @param windowClassName
     * @return
     */
    public static WindowFactory get(String windowClassName) {
        if ( MSFSharedUtils.paramNotNull(windowClassName) ) {
            WindowFactory factory = (WindowFactory)GWT.create(WindowFactory.class);
            factory.setWindowClassName(windowClassName);
            return factory;
        }
        return null;
    }

    /**
     * Static method to get a WindowFactory already initialized with its elementoMenu.
     * This is useful if the Window is LayoutContainer or an MSFPanel activated by a Menu Item.
     * The windowClassName is initialized from given elementoMenu.getScreen().
     * @param elementoMenu
     * @return
     */
    public static WindowFactory get(ElementoMenu elementoMenu) {
        if ( elementoMenu!=null && MSFSharedUtils.paramNotNull(elementoMenu.getMnuScnFrmPkgNm()) ) {
            String screen = elementoMenu.getMnuScnFrmPkgNm();
            WindowFactory factory = (WindowFactory)GWT.create(WindowFactory.class);
            factory.setWindowClassName(screen);
            factory.setElementoMenu(elementoMenu);
            return factory;
        }
        return null;
    }

    /**
     * Returns an instance of the LayoutContainer using information stored in windowClassName and elementoMenu.
     * The LayoutContainer is created only when this method is called and not when WindowFactory class is instantiated.
     * @return
     */
    public LayoutContainer createWindow() {

        LayoutContainer window = null;

        try {
            //Create a new instance of the window from its class name
            ClassType classType = TypeOracle.Instance.getClassType(windowClassName);
            Constructor constructor = classType.findConstructor(new String[]{});
            Object obj = constructor.newInstance();
            Boolean seInsert = elementoMenu!=null ? elementoMenu.getMnuAuthGrPScnInptYn() : Boolean.TRUE;
            Boolean seUpdate = elementoMenu!=null ? elementoMenu.getMnuAuthGrPScnRevnYn(): Boolean.TRUE;
            Boolean seDelete = elementoMenu!=null ? elementoMenu.getMnuAuthGrPScnDelYn() : Boolean.TRUE;
          //  Boolean seSearch = elementoMenu!=null ? elementoMenu.getMnuAuthGrPScnInqyYn() : Boolean.TRUE;
          //  Boolean sePrint = elementoMenu!=null ? elementoMenu.getMnuAuthGrPScnPrtYn() : Boolean.TRUE;

            if (obj instanceof TableDef) {
                //In case we have a TableDef, we create a new MSFPanel for a CRUD operation
                MSFPanel MSFPanel = new MSFPanel();
                MSFPanel.setViewPanel(new MSFGridPanel(
                        (TableDef)obj,
                        seInsert, 
                        seUpdate, 
                        seDelete,false)); 
                MSFPanel.setGrant(seInsert, seUpdate, seDelete); 
                window = MSFPanel;
            } else if (obj instanceof MSFPanel) {
                //In case we have an MSFPanel, we must only set the correct grants
                MSFPanel MSFPanel = (MSFPanel)obj;
                MSFPanel.setGrant(seInsert, seUpdate, seDelete);
                window = MSFPanel;
            } else {
                //In all other cases we have a simple LayoutContainer and we pass out the object as it is
                window = (LayoutContainer)obj;
            }
        } catch (Exception ex) {
            //In case of exceptions creating the Window via reflection, return a default error page
            ContentPanel cmp = new ContentPanel();
            VerticalPanel content = new VerticalPanel();
            cmp.setWidth("100%");
            content.setWidth("100%");
            content.setSpacing(5);
            content.setScrollMode(Scroll.AUTO);
            content.add(new Label(MSFMainApp.ADMINMESSAGES.ExceptionCreatingWindow(windowClassName)));
            content.add(new Label("EXCEPTION: "+MSFSharedUtils.extractStackTrace(ex)));
            cmp.add(content);
            MSFPanel MSFPanel = new MSFPanel();
            MSFPanel.setViewPanel(cmp);
            window = MSFPanel;
        }
        return window;
    }

    private void setWindowClassName(String windowClassName) {
        this.windowClassName = windowClassName;
    }

    public String getWindowClassName() {
        return this.windowClassName;
    }
    
    private void setElementoMenu(ElementoMenu elementoMenu) {
        this.elementoMenu = elementoMenu;
    }

}
