package com.app.exterms.yearendtax.client.service.yeta2020;

import com.app.exterms.yearendtax.client.dto.yeta2020.Ye160403DTO;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface YetaP53008ServiceAsync {
	
	/** 현근무지비과세_비과세 감면소득 조회 **/
	public void getYetaP53008ToYe160403List(Ye160403DTO ye160403Dto, AsyncCallback<Ye160403DTO> callback);

	/** 현근무지비과세_감면소득 팝업 저장 **/
	public void activityOnYetaP53008ToYe160403(Ye160403DTO ye160403Dto, ActionDatabase actionDatabase, AsyncCallback<Long> callback);
	
}
