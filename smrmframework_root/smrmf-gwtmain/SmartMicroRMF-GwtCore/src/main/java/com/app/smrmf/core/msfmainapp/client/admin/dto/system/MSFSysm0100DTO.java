/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.admin.dto.system;

import java.util.Date;

import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;
 
/**
 * @Class Name : Sysm0100VO.java
 * @Description : Sysm0100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.19
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class MSFSysm0100DTO extends BaseModel implements IsSerializable {
	
	 
    private static final long serialVersionUID = 1L;
    
    
    @SuppressWarnings("unused")
    private MSFSysm0100BM msfSysm0100;
    
    private ShowMessageBM messageBm; 
    

    public MSFSysm0100DTO() {
    }

    public MSFSysm0100DTO(
    		MSFSysm0100BM msfSysm0100, 
            String error, 
            String descriptionError,
            Date dataLogin,
            ShowMessageBM messageBm) {
        set("msfSysm0100",msfSysm0100);
        set("error",error);
        set("descriptionError",descriptionError);
        set("dataLogin",dataLogin);
        set("dataLogin",dataLogin);
        set("messageBm",messageBm);  
        setMessageBm((ShowMessageBM)get("messageBm"));
    }

    public MSFSysm0100BM getMsfSysm0100() {
        return get("msfSysm0100");
    }

    public String getError() {
        return get("error");
    }

    public String getDescriptionError() {
        return get("descriptionError");
    }

    public Date getDataLogin() {
        return get("dataLogin");
    }

    public ShowMessageBM getMsgBmLogin() { 
		 return get("messageBm");  
	}
    
	public ShowMessageBM getMessageBm() {
		return messageBm;
	} 
	
	public void setMessageBm(ShowMessageBM messageBm) {
		this.messageBm = messageBm;
	} 
    
    
    
}
