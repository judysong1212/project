package com.app.exterms.yearendtax.client.service.yeta2017;

import com.app.exterms.yearendtax.client.dto.yeta2017.Ye160403DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("YetaP23008Service.gwt")
public interface YetaP23008Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static YetaP23008ServiceAsync instance;
		public static YetaP23008ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(YetaP23008Service.class);
			}
			return instance;
		}
	}
	
	/** 현근무지비과세_비과세 감면소득 조회 **/
	public Ye160403DTO getYetaP23008ToYe160403List(Ye160403DTO ye160403Dto) throws MSFException;


	/** 현근무지비과세_감면소득 팝업 저장 **/
	public Long activityOnYetaP23008ToYe160403(Ye160403DTO ye160403Dto, ActionDatabase actionDatabase) throws MSFException;
	
}