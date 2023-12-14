package com.app.exterms.payroll.client.service;

import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0490DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("PayrP530002Service.gwt")
public interface PayrP530002Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static PayrP530002ServiceAsync instance;
		public static PayrP530002ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(PayrP530002Service.class);
			}
			return instance;
		}
	}

	public int copyPkgUnitPriceItemsPayrP530002(List<Payr0490DTO> listPayr0490Dto)throws MSFException;
	
}
