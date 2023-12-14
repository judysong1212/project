/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.login;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;

import com.extjs.gxt.ui.client.widget.Window;

public class LoginDialog extends Window implements Login {

    protected LoginForm loginForm;
    protected LoginListener loginListener;
    protected boolean active;

    private static LoginDialog singleton;

    /**
     * We open only one LoginDialog, it will be activated and deactivated using show() and hide() methods. 
     * In case dialog is not active, we can override the title;
     * @param titolo
     * @return
     */
    public static LoginDialog get(String title) {
        if ( singleton == null ) {
            singleton = new LoginDialog(title);
        } else {
            if ( !singleton.active ) {
               // singleton.setHeading(title);
            	 singleton.setHeadingText(title);
            }
        }
        return singleton;
    }

    private LoginDialog(String title) {

        super();

        loginForm = new LoginForm(this);
        active = false;

       // setHeading(title);
        setHeadingText(title);
        setIcon(MSFMainApp.ICONS.form());
        setMaximizable(false);
        setResizable(false);
        setAutoWidth(true);
        setAutoHeight(true);
        setModal(true);
        add(loginForm);

    }

    public void addLoginListener(LoginListener loginListener) {
        this.loginListener = loginListener;
    }

    public LoginListener getLoginListener() {
        return loginListener;
    }

    public void show() {
        if ( !active ) {
            super.show();
            active = true;
        }
    }

    public void hide() {
        super.hide();
        active = false;
        loginForm.clearFormFields();
    }

}
