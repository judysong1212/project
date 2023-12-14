package com.app.exterms.basis.client.service;

import com.app.exterms.basis.client.dto.Bass0210DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Bass0210Service.gwt")
public interface Bass0210Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Bass0210ServiceAsync instance;
		public static Bass0210ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Bass0200Service.class);
			}
			return instance;
		}
	}
	
	public Long activityOnBass0210(Bass0210DTO bass0210Dto, ActionDatabase actionDatabase) throws MSFException;
}
