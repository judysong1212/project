package com.app.exterms.yearendtax.client.service.yeta2021;

import com.app.exterms.yearendtax.client.dto.yeta2021.Ye160405DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("YetaP630010Service.gwt")
public interface YetaP630010Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static YetaP630010ServiceAsync instance;
		public static YetaP630010ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(YetaP630010Service.class);
			}
			return instance;
		}
	}
	
	/** 현근무지비과세_비과세 감면소득 조회 **/
	public Ye160405DTO getYetaP630010ToYe160405List(Ye160405DTO ye160405Dto) throws MSFException;


	/** 현근무지비과세_감면소득 팝업 저장 **/
	public int activityOnYetaP630010ToYe160405(Ye160405DTO ye160405Dto, ActionDatabase actionDatabase) throws MSFException;
	
}