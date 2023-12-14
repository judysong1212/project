package com.app.exterms.payroll.client.service;

import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0490DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PayrP530002ServiceAsync {
	
	public void copyPkgUnitPriceItemsPayrP530002(List<Payr0490DTO> listPayr0490Dto, AsyncCallback<Integer> callback)throws MSFException;

}
