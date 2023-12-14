package com.app.exterms.yearendtax.client.service.yeta2016;

import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta3210DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("YetaP13009Service.gwt")
public interface YetaP13009Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static YetaP13009ServiceAsync instance;
		public static YetaP13009ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(YetaP13009Service.class);
			}
			return instance;
		}
	}
	
	/** 주현근무지등록 팝업 신규, 삭제, 저장 **/
	public Long activityOnYetaP13009ToYeta3210(List<Ye16Ta3210DTO> listYeta3210dto, ActionDatabase actionDatabase) throws MSFException;
	
}