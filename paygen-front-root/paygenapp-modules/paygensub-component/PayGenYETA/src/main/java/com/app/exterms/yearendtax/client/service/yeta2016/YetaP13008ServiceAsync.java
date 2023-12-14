package com.app.exterms.yearendtax.client.service.yeta2016;

import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta3200DTO;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface YetaP13008ServiceAsync {
	
	/** 비과세 및 감면 조회 **/
	public void getYetaP13008To3200List(Ye16Ta3200DTO yeta3200Dto, AsyncCallback<Ye16Ta3200DTO> callback);

	/** 종전근무지등록 팝업 신규, 삭제, 저장 **/
	public void activityOnYetaP13008ToYeta3200(List<Ye16Ta3200DTO> listYeta3200dto, ActionDatabase actionDatabase, AsyncCallback<Long> callback);
	
}
