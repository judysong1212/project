package com.app.exterms.payroll.client.service;

import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0410DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("PayrP150003Service.gwt")
public interface PayrP150003Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static PayrP150003ServiceAsync instance;
		public static PayrP150003ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(PayrP150003Service.class);
			}
			return instance;
		}
	}

	public int copyPkgUnitPriceItemsPayrP150003(List<Payr0410DTO> listPayr0410Dto)throws MSFException;
	
}
