package com.app.exterms.yearendtax.client.service.yeta2016;

import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta3210DTO;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface YetaP13009ServiceAsync {	

	/** 종전근무지등록 팝업 신규, 삭제, 저장 **/
	public void activityOnYetaP13009ToYeta3210(List<Ye16Ta3210DTO> listYeta3210dto, ActionDatabase actionDatabase, AsyncCallback<Long> callback);

}
