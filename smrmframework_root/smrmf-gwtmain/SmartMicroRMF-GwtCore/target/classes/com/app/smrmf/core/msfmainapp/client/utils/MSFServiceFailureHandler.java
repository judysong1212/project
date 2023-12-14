/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.utils;

import java.util.Iterator;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFErrorMessage;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFOperationException;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFSimpleMessageException;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFUserExpiredException;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFValidationException;
import com.app.smrmf.core.msfmainapp.client.login.LoginDialog;
import com.app.smrmf.core.msfmainapp.client.login.LoginListenerAdapter;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.form.Field;

public class MSFServiceFailureHandler {

    protected LayoutContainer container;
    protected ActionDatabase actionDatabase;
    protected String activity;

    public MSFServiceFailureHandler() {
        this(null, null);
    }
    public MSFServiceFailureHandler(LayoutContainer container) {
        this(container, null);
    }
    public MSFServiceFailureHandler(LayoutContainer container, String activity) {
        this(container, null, null);
    }
    public MSFServiceFailureHandler(LayoutContainer container, String activity, ActionDatabase actionDatabase) {
        this.container = container;
        this.actionDatabase = actionDatabase;
        this.activity = activity;
    }

    public void handleServiceFailure(Throwable caught) {
        if ( caught instanceof MSFUserExpiredException ) {
            handleUserExpiredException();
        } else if ( caught instanceof MSFValidationException ) {
            handleValidationException((MSFException)caught);
        } else if ( caught instanceof MSFSimpleMessageException ) {
            handleSimpleMessageException((MSFException)caught);
        } else if ( caught instanceof MSFOperationException ) {
            handleGenericException(caught);
        } else {
            handleGenericException(caught);
        }
        if ( container instanceof MSFFormPanel ) {
            MSFFormPanel formPanel = (MSFFormPanel) container;
            formPanel.onFailureSave();
        }
    }

    protected String getTitleException() {
        String title = MSFMainApp.MSFCONSTANTS.ExceptionTitleService();
        return title;
    }
    protected String getTitleError() {
        String title = MSFMainApp.MSFCONSTANTS.msgErrorServiceInvocationTitoloService();
        return title;
    }

    protected String getActivityName() {
        String activityName = MSFSharedUtils.paramNotNull(activity) ? activity : "";
        return activityName;
    }

    protected String getActionName() {
        String actionName   = actionDatabase!=null ? actionDatabase.name() : "";
        return actionName;
    }

    protected void handleUserExpiredException() {
        final String msg = MSFMainApp.MSFMESSAGES.msgUserExpired();
        final LoginDialog login = LoginDialog.get(msg);
        login.addLoginListener(new LoginListenerAdapter(){
            public void handleLoginEvent(String utente, String password, final boolean seRicorda) {
                MSFMainApp.get().checkLogin(utente, password, seRicorda, login);
            }
        });
        //login.show();
        MessageBox.alert("세션종료", msg, null);
    }

    protected void handleValidationException(MSFException caught) {
        if ( caught==null || caught.getMessages()==null || caught.getMessages().size()==0 ) {
            handleGenericException(caught);
            return;
        }
        List<MSFErrorMessage> messages = caught.getMessages();
        StringBuffer fullMsg = new StringBuffer();
        for (Iterator<MSFErrorMessage> iterator = messages.iterator(); iterator.hasNext();) {
            MSFErrorMessage msfErrorMessage = iterator.next();
            Field field = GWTUtils.findField(container, msfErrorMessage.attributeName);
            String fieldName = 
                field!=null ? field.getFieldLabel() :
                MSFSharedUtils.paramNotNull(msfErrorMessage.attributeName) ? msfErrorMessage.attributeName :
                msfErrorMessage.errorMessage;
            String fieldValue = 
                MSFSharedUtils.paramNotNull(msfErrorMessage.attributeValue) ? msfErrorMessage.attributeValue : "";
            String msg = null;
            switch (msfErrorMessage.errorCode) {
                case MSFErrorMessage.ERRCODE_EXCEPTION:
                    msg = MSFMainApp.MSFMESSAGES.msgExceptionOccurred(fieldName);
                    break;
                case MSFErrorMessage.ERRCODE_NULL:
                    msg = MSFMainApp.MSFMESSAGES.msgPropertyNull(fieldName);
                    break;
                case MSFErrorMessage.ERRCODE_TOO_LARGE:
                    msg = MSFMainApp.MSFMESSAGES.msgPropertyTooLarge(fieldName);
                    break;
                case MSFErrorMessage.ERRCODE_WRONG_TYPE:
                    msg = MSFMainApp.MSFMESSAGES.msgPropertyWrongType(fieldName);
                    break;
                case MSFErrorMessage.ERRCODE_DUPLICATE_KEY:
                    msg = MSFMainApp.MSFMESSAGES.msgDuplicateKey(fieldValue);
                    break;
                case MSFErrorMessage.ERRCODE_NOT_FOUND:
                    msg = MSFMainApp.MSFMESSAGES.msgNoRecordFound(fieldValue);
                    break;
                case MSFErrorMessage.ERRCODE_ID_NULL:
                    msg = MSFMainApp.MSFMESSAGES.msgIdNull();
                    break;
                case MSFErrorMessage.ERRCODE_CONSTR_VIOLATION:
                    msg = MSFMainApp.MSFMESSAGES.msgDatabaseConstraintViolation(fieldName);
                    break;
                default:
                    msg = msfErrorMessage.errorMessage;
            }
            if ( field!=null ) {
                field.markInvalid(msg);
            }
            fullMsg.append( (fullMsg.length()>0?"<br>":"") + msg);
        }
        MessageBox.alert(getTitleError(), fullMsg.toString(), null);
    }

    protected void handleSimpleMessageException(MSFException caught) {
        handleValidationException(caught);
    }

    protected void handleGenericException(Throwable caught) {
        String msgParam = getActivityName() + " (" + getActionName() + "):";
        String msg = MSFMainApp.MSFMESSAGES.msgExceptionOccurred(msgParam) + "\n" + caught;
        MessageBox.alert(getTitleException(), msg, null);
    }

}
