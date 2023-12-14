/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.service.system;

import java.util.List;

import com.app.smrmf.core.msfmainapp.client.admin.dto.DatabaseObject;
import com.app.smrmf.core.msfmainapp.client.admin.dto.ElementoMenu;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0300DTO;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("AdminService.gwt")
public interface AdminService extends RemoteService {
    /**
     * Utility class for simplifying access to the instance of async service.
     */
    public static class Util {
        private static AdminServiceAsync instance;
        public static AdminServiceAsync getInstance(){
            if (instance == null) {
                instance = GWT.create(AdminService.class);
            }
            return instance;
        }
    }

    public List<MSFSysm0100BM> getListUsers();

    public Long activityOnUser(MSFSysm0100BM user, ActionDatabase actionDatabase);

    public List<MSFSysm0300DTO> getListaProfiles();

    public Long activityOnProfiles(MSFSysm0300DTO profilo, ActionDatabase actionDatabase);
 
     
    public Long activityOnVoceMenu(ElementoMenu elementoMenu, ActionDatabase actionDatabase);

    
    public List<ElementoMenu> getCategories();
    
    public List<DatabaseObject> getDatabaseObjects();

    public List<DatabaseObject> getDatabaseObjectsConsidered();

    public Long activityOnDBObject(DatabaseObject databaseObject, ActionDatabase actionDatabase);

}
