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

import org.springframework.security.userdetails.User;

import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFAuthCheckBM;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100DTO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0300BM;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.SysIfSysm0100DTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

@RemoteServiceRelativePath("LoginService.gwt")
public interface LoginService extends RemoteService {
    /**
     * Utility class for simplifying access to the instance of async service.
     */
    public static class Util {
        private static LoginServiceAsync instance;
        public static LoginServiceAsync getInstance(){
            if (instance == null) {
                instance = (LoginServiceAsync) GWT.create(LoginService.class);
                ServiceDefTarget target = (ServiceDefTarget) instance;
                target.setServiceEntryPoint(GWT.getModuleBaseURL() + "LoginService.gwt");  //GWT.getModuleBaseURL() + 
            }
            return instance;
        }
    }
  
    
    public Long changePassword( String userId, String oldPwd, String newPwd);

   // public Long checkPassword(String password);

    public MSFSysm0100DTO checkUsr(String userId, String userPwd, String language);
    
     public MSFSysm0100DTO checkSSOUsr(String dpobCd,String sysDivCd,String userId, String language);

    public MSFSysm0100DTO checkSession();
    
     public MSFSysm0100DTO checkSSOSession();

    public void clearSession();

    public Long saveUser(SysIfSysm0100DTO utenteBM);

    public List<MSFSysm0300BM> readProfilesByUser(MSFSysm0100BM user);

    public  MSFAuthCheckBM  readAuthByUser(MSFSysm0100BM user);
    
    public HashMap<String, String> getServerMessages();
    
    public Long isPasswordChangeRequired(String userId, String userPwd); // 메소드 추가_hieju/06.14
    
//	public String insertHist0100(Psnl0100DTO psnl0100Dto) throws Exception {
    
}
