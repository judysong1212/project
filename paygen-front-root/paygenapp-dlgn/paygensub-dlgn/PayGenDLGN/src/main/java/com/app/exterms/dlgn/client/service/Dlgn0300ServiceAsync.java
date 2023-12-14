package com.app.exterms.dlgn.client.service;

import com.app.exterms.dlgn.client.dto.Dlgn0300DTO;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface Dlgn0300ServiceAsync {
	public void selectDlgn0300(BaseListLoadConfig config, Dlgn0300DTO dto, AsyncCallback<BaseListLoadResult<Dlgn0300DTO>> callback) ;
	
	
}
