package com.app.exterms.yearendtax.client.service.yeta2016;

import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta3200DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("YetaP13008Service.gwt")
public interface YetaP13008Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static YetaP13008ServiceAsync instance;
		public static YetaP13008ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(YetaP13008Service.class);
			}
			return instance;
		}
	}
	/** 비과세 및 감면소득 조회 **/
	public Ye16Ta3200DTO getYetaP13008To3200List(Ye16Ta3200DTO yeta3200Dto) throws MSFException;


	/** 비과세_감면소득 팝업 저장 **/
	public Long activityOnYetaP13008ToYeta3200(List<Ye16Ta3200DTO> listYeta3200dto, ActionDatabase actionDatabase) throws MSFException;
	
}