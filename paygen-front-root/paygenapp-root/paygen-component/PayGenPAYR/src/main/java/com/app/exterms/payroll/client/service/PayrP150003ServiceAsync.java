package com.app.exterms.payroll.client.service;

import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0410DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PayrP150003ServiceAsync {
	
	public void copyPkgUnitPriceItemsPayrP150003(List<Payr0410DTO> listPayr0410Dto, AsyncCallback<Integer> callback)throws MSFException;

}
