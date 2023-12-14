package com.app.exterms.yearendtax.client.service.yeta2015;

import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2015.Yeta3210DTO;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface YetaP03009ServiceAsync {	

	/** 종전근무지등록 팝업 신규, 삭제, 저장 **/
	public void activityOnYetaP03009ToYeta3210(List<Yeta3210DTO> listYeta3210dto, ActionDatabase actionDatabase, AsyncCallback<Long> callback);

}
