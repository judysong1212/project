package com.app.exterms.personal.client.service;

import com.app.exterms.basis.client.dto.InfcPkgBass0360DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @Class Name : Psnl0112Service.java
 * @Description : Psnl0112 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface ComP010001ServiceAsync {
	
	public void selectBass0360List(InfcPkgBass0360DTO infcBass0360Dto, AsyncCallback<Integer> callback)throws MSFException;
	
	public void insertBass0360List(InfcPkgBass0360DTO infcBass0360Dto, AsyncCallback<String> callback)throws MSFException;
}
