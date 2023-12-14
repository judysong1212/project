package com.app.exterms.yearendtax.client.service.yeta2015;

import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2015.Yeta3200DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("YetaP03008Service.gwt")
public interface YetaP03008Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static YetaP03008ServiceAsync instance;
		public static YetaP03008ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(YetaP03008Service.class);
			}
			return instance;
		}
	}
	/** 비과세 및 감면소득 조회 **/
	public Yeta3200DTO getYetaP03008To3200List(Yeta3200DTO yeta3200Dto) throws MSFException;


	/** 비과세_감면소득 팝업 저장 **/
	public Long activityOnYetaP03008ToYeta3200(List<Yeta3200DTO> listYeta3200dto, ActionDatabase actionDatabase) throws MSFException;
	
}