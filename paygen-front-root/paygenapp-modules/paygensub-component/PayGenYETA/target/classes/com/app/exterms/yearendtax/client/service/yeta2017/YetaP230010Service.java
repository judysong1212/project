package com.app.exterms.yearendtax.client.service.yeta2017;

import com.app.exterms.yearendtax.client.dto.yeta2017.Ye160405DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("YetaP230010Service.gwt")
public interface YetaP230010Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static YetaP230010ServiceAsync instance;
		public static YetaP230010ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(YetaP230010Service.class);
			}
			return instance;
		}
	}
	
	/** 현근무지비과세_비과세 감면소득 조회 **/
	public Ye160405DTO getYetaP230010ToYe160405List(Ye160405DTO ye160405Dto) throws MSFException;


	/** 현근무지비과세_감면소득 팝업 저장 **/
	public int activityOnYetaP230010ToYe160405(Ye160405DTO ye160405Dto, ActionDatabase actionDatabase) throws MSFException;
	
}