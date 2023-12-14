/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.service.system;

import java.util.List;

import com.app.smrmf.core.msfmainapp.client.admin.dto.ElementoMenu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

@RemoteServiceRelativePath("InitSysService.gwt")
public interface InitSysService extends RemoteService {
    /**
     * Utility class for simplifying access to the instance of async service.
     */
    public static class Util {
        private static InitSysServiceAsync instance;
        public static InitSysServiceAsync getInstance(){
            if (instance == null) {
                instance = (InitSysServiceAsync) GWT.create(InitSysService.class);
                ServiceDefTarget target = (ServiceDefTarget) instance;
                target.setServiceEntryPoint(GWT.getModuleBaseURL() + "InitSysService.gwt");   //GWT.getModuleBaseURL() + 
            }
            return instance;
        }
    }
    public String getInitialization();
}
