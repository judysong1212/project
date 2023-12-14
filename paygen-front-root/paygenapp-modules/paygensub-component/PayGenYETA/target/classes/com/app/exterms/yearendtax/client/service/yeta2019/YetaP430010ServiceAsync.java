package com.app.exterms.yearendtax.client.service.yeta2019;

import com.app.exterms.yearendtax.client.dto.yeta2019.Ye160405DTO;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface YetaP430010ServiceAsync {
	
	/** 현근무지비과세_비과세 감면소득 조회 **/
	public void getYetaP430010ToYe160405List(Ye160405DTO ye160405Dto, AsyncCallback<Ye160405DTO> callback);

	/** 현근무지비과세_감면소득 팝업 저장 **/
	public void activityOnYetaP430010ToYe160405(Ye160405DTO ye160405Dto, ActionDatabase actionDatabase, AsyncCallback<Integer> callback);
	
}
