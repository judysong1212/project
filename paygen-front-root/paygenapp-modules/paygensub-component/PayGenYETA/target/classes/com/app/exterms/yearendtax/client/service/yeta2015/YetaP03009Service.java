package com.app.exterms.yearendtax.client.service.yeta2015;

import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2015.Yeta3210DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("YetaP03009Service.gwt")
public interface YetaP03009Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static YetaP03009ServiceAsync instance;
		public static YetaP03009ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(YetaP03009Service.class);
			}
			return instance;
		}
	}
	
	/** 주현근무지등록 팝업 신규, 삭제, 저장 **/
	public Long activityOnYetaP03009ToYeta3210(List<Yeta3210DTO> listYeta3210dto, ActionDatabase actionDatabase) throws MSFException;
	
}