/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.service.system;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFAuthCheckBM;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100DTO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0300BM;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.SysIfSysm0100DTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoginServiceAsync {
	
	// public void changePassword(MSFSysm0100BM user1, String newPwd, AsyncCallback<Long> callback);
	public void changePassword( String userId, String oldPwd, String newPwd, AsyncCallback<Long> callback);

    // public void checkPassword(String password, AsyncCallback<Long> callback);

    public void checkUsr(String userId, String userPwd, String language, AsyncCallback<MSFSysm0100DTO> callback);
    
    public void checkSSOUsr(String dpobCd,String sysDivCd,String userId, String language, AsyncCallback<MSFSysm0100DTO> callback);

    public void checkSession(AsyncCallback<MSFSysm0100DTO> callback);
    
    public void checkSSOSession(AsyncCallback<MSFSysm0100DTO> callback);

    public void clearSession(AsyncCallback<Void> callback);

    public void saveUser(SysIfSysm0100DTO utenteBM, AsyncCallback<Long> callback);

    public void readProfilesByUser(MSFSysm0100BM user, AsyncCallback<List<MSFSysm0300BM>> callback);
    
    public void readAuthByUser(MSFSysm0100BM user, AsyncCallback<MSFAuthCheckBM> callback);

    public void getServerMessages(AsyncCallback<HashMap<String, String>> callback);

    
   public void isPasswordChangeRequired(String userId, String userPwd, AsyncCallback<Long> callback);


}
