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

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface AdminServiceAsync {
    public void getListUsers(AsyncCallback<List<MSFSysm0100BM>> callback);

    public void activityOnUser(MSFSysm0100BM user, ActionDatabase actionDatabase, AsyncCallback<Long> callback);

    public void getListaProfiles(AsyncCallback<List<MSFSysm0300DTO>> callback);

    public void activityOnProfiles(MSFSysm0300DTO profilo, ActionDatabase actionDatabase, AsyncCallback<Long> callback);
 
     
    public void activityOnVoceMenu(ElementoMenu elementoMenu, ActionDatabase actionDatabase, AsyncCallback<Long> callback);

    
    public void getCategories(AsyncCallback<List<ElementoMenu>> callback);
    
    public void getDatabaseObjects(AsyncCallback<List<DatabaseObject>> callback);

    public void getDatabaseObjectsConsidered(AsyncCallback<List<DatabaseObject>> callback);

    public void activityOnDBObject(DatabaseObject databaseObject, ActionDatabase actionDatabase, AsyncCallback<Long> callback);

}
