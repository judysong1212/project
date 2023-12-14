package com.app.exterms.yearendtax.client.service.yeta2015;

import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2015.Yeta3200DTO;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface YetaP03008ServiceAsync {
	
	/** 비과세 및 감면 조회 **/
	public void getYetaP03008To3200List(Yeta3200DTO yeta3200Dto, AsyncCallback<Yeta3200DTO> callback);

	/** 종전근무지등록 팝업 신규, 삭제, 저장 **/
	public void activityOnYetaP03008ToYeta3200(List<Yeta3200DTO> listYeta3200dto, ActionDatabase actionDatabase, AsyncCallback<Long> callback);
	
}
