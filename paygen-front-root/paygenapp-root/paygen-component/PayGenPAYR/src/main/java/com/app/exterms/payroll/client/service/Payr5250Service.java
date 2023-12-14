/**
* <pre>
* 1. 프로젝트명 : PayGenPAYR-2.0.0
* 2. 패키지명(또는 디렉토리 경로) : com.app.exterms.payroll.client.service
* 3. 파일명 : Payr5250Service.java
* 4. 작성일 : 2016. 12. 13. 오전 1:14:01
* 5. 작성자 : atres-pc
* 6. 설명 :
* </pre>
*/
package com.app.exterms.payroll.client.service;

import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0416DTO;
import com.app.exterms.payroll.client.dto.Payr0417DTO;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * <pre>
 * 1. 패키지명 : com.app.exterms.payroll.client.service
 * 2. 타입명 : Payr5250Service.java
 * 3. 작성일 : 2016. 12. 13. 오전 1:14:01
 * 4. 작성자 : atres-pc
 * 5. 설명 :
 * </pre>
 */
 
@RemoteServiceRelativePath("Payr5250Service.gwt")
public interface Payr5250Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Payr5250ServiceAsync instance;
		public static Payr5250ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Payr5250Service.class);
			}
			return instance;
		}
	}
	
	/** 지급공제직종세 생성 **/
	public Long activityOnPayr5250Insert(Payr0416DTO payr0416Dto, List<BaseModel> listModels, ActionDatabase actionDatabase);
	
	/** 지급공제직종세 삭제 **/
	public Long activityOnPayr5250Delete(List<Payr0416DTO> listPayr0416Dto, ActionDatabase actionDatabase);
	
	/** 지급공제항목 생성 **/
	public Long activityOnPayr0417Insert(Payr0417DTO payr0417Dto, List<BaseModel> listModels, ActionDatabase actionDatabase);
	
	/** 지급공제항목 수정 **/
	public Long activityOnPayr0417DetailFormSave(Payr0417DTO payr0417Dto, ActionDatabase actionDatabase);
	
	
	 

//	public Long activityOnPayr0417Insert(Payr0417DTO payr0415Dto,List<BaseModel> listModels, ActionDatabase actionDatabase);
//	
//	public Long activityOnPayr0410Insert(Payr0410DTO payr0410Dto,List<BaseModel> listModels, ActionDatabase actionDatabase);
//    
//	
//	public Long activityOnPayr5250BfToNew(Payr0417DTO payr0415Dto,List<BaseModel> listModels, ActionDatabase actionDatabase);
//    
//	public Long activityOnPayr0417Save(Payr0417DTO payr0415Dto, ActionDatabase actionDatabase);
	  
	  
	
}