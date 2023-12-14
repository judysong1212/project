package com.app.exterms.payroll.client.service;

import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0417DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("PayrP525003Service.gwt")
public interface PayrP525003Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static PayrP525003ServiceAsync instance;
		public static PayrP525003ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(PayrP525003Service.class);
			}
			return instance;
		}
	}

	public int copyPkgUnitPriceItemsPayrP525003(List<Payr0417DTO> listPayr0417Dto)throws MSFException;
	
}
