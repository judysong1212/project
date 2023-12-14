package com.app.exterms.basis.client.service;

import com.app.exterms.basis.client.dto.Bass0210DTO;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface Bass0210ServiceAsync {
	public void activityOnBass0210(Bass0210DTO bass0210Dto, ActionDatabase actionDatabase, AsyncCallback<Long> callback);
}
