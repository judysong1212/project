/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.exceptions;

import java.util.ArrayList;
import java.util.List;

/**
 * An Exception that can be used as failure return parameter for GWT RPC services.
 * To get an instance of this class, use static methods on MSFServerUtils:
 *   getUserExpiredException(), getValidationException(), etc...
 *
 */
public abstract class MSFException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private List<MSFErrorMessage> messages;

    public MSFException() {
        super();
    }

    private void initMessages() {
        if (messages==null) {
            messages = new ArrayList<MSFErrorMessage>();
        }
    }

    public void addMessage(MSFErrorMessage message) {
        initMessages();
        if ( message!=null ) {
            messages.add(message);
        }
    }

    public void addMessages(List<MSFErrorMessage> messageList) {
        initMessages();
        if ( messageList!=null && messageList.size()>0 ) {
            messages.addAll(messageList);
        }
    }

    public List<MSFErrorMessage> getMessages() {
        return messages;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for ( int i=0 ; messages!=null && i<messages.size() ; i++ ) {
            sb.append(messages.get(i)).append("\n");
        }
        return sb.toString();
    }
}
