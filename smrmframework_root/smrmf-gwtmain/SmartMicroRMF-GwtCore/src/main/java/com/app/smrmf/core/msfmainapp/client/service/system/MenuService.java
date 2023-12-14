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

@RemoteServiceRelativePath("MenuService.gwt")
public interface MenuService extends RemoteService {
    /**
     * Utility class for simplifying access to the instance of async service.
     */
    public static class Util {
        private static MenuServiceAsync instance;
        public static MenuServiceAsync getInstance(){
            if (instance == null) {
                instance = (MenuServiceAsync) GWT.create(MenuService.class);
                ServiceDefTarget target = (ServiceDefTarget) instance;
                target.setServiceEntryPoint(GWT.getModuleBaseURL() + "MenuService.gwt");   //GWT.getModuleBaseURL() + 
            }
            return instance;
        }
    }
    public List<ElementoMenu> getMenu();
}
