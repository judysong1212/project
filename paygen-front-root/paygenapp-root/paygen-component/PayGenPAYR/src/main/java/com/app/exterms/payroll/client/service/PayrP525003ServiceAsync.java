package com.app.exterms.payroll.client.service;

import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0417DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PayrP525003ServiceAsync {
	
	public void copyPkgUnitPriceItemsPayrP525003(List<Payr0417DTO> listPayr0417Dto, AsyncCallback<Integer> callback)throws MSFException;

}
