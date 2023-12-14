/**
 * 거주자간 주택임차차입금 원리금 상환액
 */
package com.app.exterms.yearendtax.client.form.yeta2016;
  

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta3120BM;
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta3120DTO;
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta3160BM;
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta3160DTO;
import com.app.exterms.yearendtax.client.form.defs.yeta2015.Yeta3120Def;
import com.app.exterms.yearendtax.client.form.defs.yeta2015.Yeta3160Def;
import com.app.exterms.yearendtax.client.service.yeta2016.YetaP13004Service;
import com.app.exterms.yearendtax.client.service.yeta2016.YetaP13004ServiceAsync;
import com.app.exterms.yearendtax.client.utils.YetaUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.app.smrmf.syscom.client.util.SysComComboUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.AggregationRowConfig;
import com.extjs.gxt.ui.client.widget.grid.SummaryType;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public  class YetaP13004   extends MSFFormPanel {  

/**
 *##########################################################################
 * { 시스템 기본설정파일 선언부  시작}
 *##########################################################################
 **/
	    

/**
 *##########################################################################
 * { 시스템 기본설정파일 선언부  종료}
 *##########################################################################
 **/
  
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역변수 선언부  시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
 
	private  ContentPanel cpYeta13004; 
	  
	/**######################################################
	 * { 시스템 기본설정파일 선언부  시작}
	 *#######################################################*/
		 
	//권한 설정 객체 
	private static  GWTAuthorization gwtAuthorization;
	private static  GWTExtAuth gwtExtAuth;
	private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 
		  
	/**######################################################
	 * { 시스템 기본설정파일 선언부  종료}
	 *#######################################################*/

		  
	// -------------- grid 선언 시작  ---------------	  
	private MSFGridPanel yetaP13004GridPanel01;
//	private Yeta0300Def yeta0300Def_09_1  = new Yeta0300Def("YETA0300901");	//금전소비대차계약 그리드 테이블 컬럼 define 
	private Yeta3120Def yetaP13004ToYeta3120Def  = new Yeta3120Def("YETAP03004");	//금전소비대차계약 그리드 테이블 컬럼 define 
	
	private MSFGridPanel yetaP13004GridPanel02;
//	private Yeta0300Def yeta0300Def_09_2  = new Yeta0300Def("YETA0300902");	//임대차계약 그리드 테이블 컬럼 define 
//	private Yeta3130Def yetaP13004ToYeta3130Def  = new Yeta3130Def("YETAP03004");	//임대차계약 그리드 테이블 컬럼 define
	private Yeta3160Def yetaP13004ToYeta3160Def  = new Yeta3160Def("YETAP03004");	//임대차계약 그리드 테이블 컬럼 define 
	// -------------- grid 선언 종료  ---------------			   

		  
	// -------------- DTO 선언 시작 --------------
	private  PrgmComBass0300DTO sysComBass0300Dto; // 공통코드 dto
	private  SysCoCalendarDTO msfCoCalendarDto;
	// -------------- DTO 선언 종료 --------------
	    
    
   /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 상태처리 전역변수
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
  private ActionDatabase actionDatabase;
  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 화면 렌더링 변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
    
  private MSFPanel caller;
  private Boolean  reading = false;
  public  FormBinding formBinding;
  
  private Iterator<Record> records;
  
  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * Button 변수 선언
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
       
  	private  ButtonBar topYeta3120BtnBar = new ButtonBar();
	private  Button btnYeta3120New = new Button();		//신규
	private  Button btnYeta3120Del = new Button();		//삭제
	private  Button btnYeta3120Save = new Button();		//저장
	
	private  ButtonBar topYeta3160BtnBar = new ButtonBar();
	private  Button btnYeta3160New = new Button();		//신규
	private  Button btnYeta3160Del = new Button();		//삭제
	private  Button btnYeta3160Save = new Button();		//저장
	
	
	private  Button btnYetaClose = new Button();		//닫기

  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 검색변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
	// -------------- 검색 조건 시작 --------------
 	private TextField<String> srhEdacRvyy;		// 년도
 	private ComboBox<BaseModel> srhSettGbcd; 	// 정산구분
 	private TextField<String> srhDeptCd; 		// 부서
 	private TextField<String> srhHanNm; 		// 성명
 	
 	private HiddenField<String> systemkey;	/**  column SYSTEMKEY : systemkey */
    private HiddenField<String> dpobCd;		/**  column 사업장코드 : dpobCd */
    private HiddenField<String> edacRvyy;	/** column 정산년도 : edacRvyy */
    private HiddenField<String> settGbcd;	/** column 정산구분코드 : settGbcd */
    private HiddenField<String> deptNm;  	/**  column 부서명 : deptNm */
	private HiddenField<String>	 hanNm;		/**  column 성명 : hanNm */
 	// -------------- 검색 조건 종료 --------------
      
  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 입력 변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */

      
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역변수 선언부  종료
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/	  

      
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역함수 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
   // 검색 폼 바인딩 처리 함수 
      
	   //화면 폼 바인딩 처리 
	    private void setPayr410001FormBinding() {
	 	 
	    // formBinding.addFieldBinding(new FieldBinding(srhPubcHodyCtnt, "srhPubcHodyCtnt"));
	    // formBinding.addFieldBinding(new FieldBinding(degtrResnRegnNum, "degtrResnRegnNum"));
	   
	    }        
   
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역함수 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/	
	  
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	Rpc Service 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/ 
	// -------------- stroe 선언 시작 --------------
	private  ListStore<BaseModel> lsdacRvyyStore = new ListStore<BaseModel>(); 	// 년도
	private  ListStore<BaseModel> lsSettGbcd = new ListStore<BaseModel>(); 		// 정산구분
	// -------------- stroe 선언 종료 --------------
	 	
	// -------------- 서비스 호출 시작 --------------
	private YetaP13004ServiceAsync yetaP13004Service = YetaP13004Service.Util.getInstance();
	// -------------- 서비스 호출 종료 --------------	 	
	 	
	    
	/**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 조회처리부
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */  
 
	     
	/**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 선택된 버튼에 따른 인서트 업데이트 삭제 처리 부
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */ 
	//버튼에 따른 Action
	private void doAction(ActionDatabase actionDatabase, String doActionFlag) {
		switch (actionDatabase) {
		case INSERT:
			this.actionDatabase = ActionDatabase.INSERT;
			
			if("YETA3120".equals(doActionFlag)) {
				yetaP13004ToYeta3120FormSave();
			}else if("YETA3160".equals(doActionFlag)){
				yetaP13004ToYeta3160FormSave();
			}else {
				MessageBox.alert("doAction 오류", actionDatabase.name(), null);
			}
			
			break;
		case UPDATE:
			this.actionDatabase = ActionDatabase.UPDATE;
			
			if("YETA3120".equals(doActionFlag)) {
				yetaP13004ToYeta3120FormSave();
			}else if("YETA3160".equals(doActionFlag)){
				yetaP13004ToYeta3160FormSave();
			}else {
				MessageBox.alert("doAction 오류", actionDatabase.name(), null);
			}
			break;
		case DELETE:
			this.actionDatabase = ActionDatabase.DELETE;
			
			if("YETA3120".equals(doActionFlag)) {
				yetaP13004ToYeta3120FormSave();
			}else if("YETA3160".equals(doActionFlag)){
				yetaP13004ToYeta3160FormSave();
			}else {
				MessageBox.alert("doAction 오류", actionDatabase.name(), null);
			}
			break;
		}
	}
		
		
	private void yetaP13004ToYeta3120FormSave() {  
		if (MSFSharedUtils.paramNotNull(records)) { 
	              
			List<Ye16Ta3120DTO> listYeta3120dto = new ArrayList<Ye16Ta3120DTO>();  
	                
			while (records.hasNext()) {
	              
				Record record = (Record) records.next(); 
				BaseModel bmMapModel = (BaseModel)record.getModel();
	                      
				Ye16Ta3120DTO yeta3120Dto= new Ye16Ta3120DTO();  
	                      
				yeta3120Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));								/** 사업장코드 : dpobCd */
				yeta3120Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    					/** SYSTEMKEY : systemkey */
	                
				yeta3120Dto.setCnclName(MSFSharedUtils.allowNulls(bmMapModel.get("cnclName")));    						/** column 금전소비대차_임대인성명 : cnclName */
				yeta3120Dto.setCnclRsno(MSFSharedUtils.allowNulls(bmMapModel.get("cnclRsno")));    						/** column 금전소비대차_주민번호 : cnclRsno */
				yeta3120Dto.setCnclStdt(GWTUtils.getStringFromDate((Date)bmMapModel.get("cnclStdt"),"yyyyMMdd"));		/** column 금전소비대차_계약시작일자 : cnclStdt */
				yeta3120Dto.setCnclEddt(GWTUtils.getStringFromDate((Date)bmMapModel.get("cnclEddt"),"yyyyMMdd"));    	/** column 금전소비대차_계약종료일자 : cnclEddt */
				yeta3120Dto.setCnclItro((Double) bmMapModel.get("cnclItro"));    										/** column 금전소비대차_차입금이자율 : cnclItro */
				yeta3120Dto.setCnclRdmt((Long) bmMapModel.get("cnclRdmt"));    											/** column 금전소비대차_원리금상환액계 : cnclRdmt */
				yeta3120Dto.setCnclPrpl((Long) bmMapModel.get("cnclPrpl"));    											/** column 금전소비대차_원리금 : cnclPrpl */
				yeta3120Dto.setCnclItrt((Long) bmMapModel.get("cnclItrt"));    											/** column 금전소비대차_이자 : cnclItrt */
				yeta3120Dto.setCnclDuam((Long) bmMapModel.get("cnclDuam"));    											/** column 금전소비대차_공제금액 : cnclDuam */
				yeta3120Dto.setCnclSqno((Long) bmMapModel.get("cnclSqno"));    											/** column 금전소비대차일련번호 : cnclSqno */
				
				yeta3120Dto.setEdacRvyy(MSFSharedUtils.allowNulls(bmMapModel.get("edacRvyy")));   	 					/** column 연말정산귀속년도 : edacRvyy */
				yeta3120Dto.setSettGbcd(MSFSharedUtils.allowNulls(bmMapModel.get("settGbcd")));    						/** column 정산구분코드 : settGbcd */
				
	                
				listYeta3120dto.add(yeta3120Dto);
			}  
	                
			if (listYeta3120dto.size() <= 0) {
				MessageBox.alert(actionDatabase.name() + "저장", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
				return;
			}
	                
			yetaP13004Service.activityOnYetaP13004ToYeta3120(listYeta3120dto, actionDatabase, new AsyncCallback<Long>(){
				public void onFailure(Throwable caught) {
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	                             MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnYetaP13004ToYeta3120(" + actionDatabase.name() + ") : " + caught), null);
				}
				public void onSuccess(Long result) { 
					if (result == 0) {
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
					} else {
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), actionDatabase + "처리가 완료되었습니다.", null);
						reload();
						actionDatabase = ActionDatabase.UPDATE;
					} 
				} 
			}); 
	              
		} else {
			MessageBox.alert(actionDatabase.name() + "선택", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
			return;
		}
	}   	
	
	
	
	private void yetaP13004ToYeta3160FormSave() {  
		if (MSFSharedUtils.paramNotNull(records)) { 
	              
			List<Ye16Ta3160DTO> listYeta3160dto = new ArrayList<Ye16Ta3160DTO>();  
	                
			while (records.hasNext()) {
	              
				Record record = (Record) records.next(); 
				BaseModel bmMapModel = (BaseModel)record.getModel();
	                      
				Ye16Ta3160DTO yeta3160Dto= new Ye16Ta3160DTO();  
	                      
				yeta3160Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));				/** 사업장코드 : dpobCd */
				yeta3160Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    	/** SYSTEMKEY : systemkey */
				yeta3160Dto.setEdacRvyy(MSFSharedUtils.allowNulls(bmMapModel.get("edacRvyy")));    		/** column 연말정산귀속년도 : edacRvyy */
				
				
				if((ActionDatabase.INSERT).equals(actionDatabase)) {
					yeta3160Dto.setSettGbcd(MSFSharedUtils.allowNulls(settGbcd.getValue()));	/** column 정산구분코드 : settGbcd */
				}else{
					yeta3160Dto.setSettGbcd(MSFSharedUtils.allowNulls(bmMapModel.get("settGbcd")));	/** column 정산구분코드 : settGbcd */
				}
				
				yeta3160Dto.setLeasSqno((Long) (bmMapModel.get("leasSqno")));    /** column 임대차일련번호 : leasSqno */
				yeta3160Dto.setLeasName(MSFSharedUtils.allowNulls(bmMapModel.get("leasName")));    /** column 임대차_임대인성명 : leasName */
				yeta3160Dto.setLeasRsno(MSFSharedUtils.allowNulls(bmMapModel.get("leasRsno")));    /** column 임대차_주민번호 : leasRsno */
				yeta3160Dto.setLeasTyhu(MSFSharedUtils.allowNulls(bmMapModel.get("leasTyhu$commCd")));    /** column 임대차_주택유형코드 : leasTyhu */
				yeta3160Dto.setLeasArea(MSFSharedUtils.allowNulls(bmMapModel.get("leasArea")));    /** column 임대차_주책계약면적 : leasArea */
				yeta3160Dto.setLeasAddr(MSFSharedUtils.allowNulls(bmMapModel.get("leasAddr")));    /** column 임대차_계약서상주소 : leasAddr */
				yeta3160Dto.setLeasStdt(GWTUtils.getStringFromDate((Date) bmMapModel.get("leasStdt"),"yyyyMMdd"));/** column 임대차_계약시작일자 : leasStdt */
				yeta3160Dto.setLeasEddt(GWTUtils.getStringFromDate((Date) bmMapModel.get("leasEddt"),"yyyyMMdd"));/** column 임대차_계약종료일자 : leasEddt */
				yeta3160Dto.setLeasDpst((Long) bmMapModel.get("leasDpst"));    /** column 임대차_전세보증금액 : leasDpst */
				
	                
				listYeta3160dto.add(yeta3160Dto);
			}  
	                
			if (listYeta3160dto.size() <= 0) {
				MessageBox.alert(actionDatabase.name() + "저장", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
				return;
			}
	                
			yetaP13004Service.activityOnYetaP13004ToYeta3160(listYeta3160dto, actionDatabase, new AsyncCallback<Long>(){
				public void onFailure(Throwable caught) {
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	                             MSFMainApp.ADMINMESSAGES.ExceptionMessageService("yetaP13004ToYeta3160FormSave(" + actionDatabase.name() + ") : " + caught), null);
				}
				public void onSuccess(Long result) { 
					if (result == 0) {
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
					} else {
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), actionDatabase + "처리가 완료되었습니다.", null);
						reload();
						actionDatabase = ActionDatabase.UPDATE;
					} 
				} 
			}); 
	              
		} else {
			MessageBox.alert(actionDatabase.name() + "선택", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
			return;
		}
	}   	 	
	 	
	 	
 
	/**
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 	Rpc Service 선언부 종료
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 **/
	/**

	/**
	 *############################################################################# 
	 * 프로그램 시작  	  
	 *############################################################################# 
	 **/ 
 
	/**
	 *############################################################################# 
	 * 프로그램 종료  	  
	 *############################################################################# 
	 **/	  

	/**
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 생성자 함수 선언부 시작
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
	 **/ 		    
		/**
		 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 * ++ 권한설정 관련 함수 및 선언 시작 (권한 적용필요시 추가해야함.)
		 * ++++++++++++++++++++++++++++++++++
		 * ++++++++++++++++++++++++++++++++++++++++
		 **/
		/**
		 * 권한설정 처리 체크 AuthAction
		 */
//		 private void checkYetaP13001Auth( String authAction, ListStore<BaseModel>bm) {
//			 if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {
//				   
//				  if (!maskTracker) { unmask(); }  
//				 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//					 * 권한설정을 위한 콤보처리를 위한 메서드 시작
//					 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 직종세 ,사업 순으로 없으면 ""
//					 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
//				 //----------------------------------------------------
//				 Field<?>[] fldArrField = {srhPayrMangDeptCd,srhEmymtDivCd,srhDeptCd,srhTypOccuCd,srhDtilOccuInttnCd,srhBusinCd};
//				 gwtAuthorization.formAuthFieldConfig(fldArrField);
//				 
//				 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//				  	* 권한설정을 위한 콤보처리를 위한 메서드 종료
//				 	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
//				 srhDeptCd.getListView().fireEvent(Events.CheckChanged);
//			 }
//		 }
//
//		   final Timer tmMask = new Timer()
//		     {
//		           public void run()
//		           {
//		              // if (maskTracker)
//		              // { 
//		           	    cancel();
//		               	unmask(); 
//		               	maskTracker  = true;
//		              // }
//		           }
//		     }; 
//		     
//		 private void initLoad() {
//		
//			 // 권한처리 부분 추가 전역이 아니 각 화면별로 객체 생성시 처리를 위해 변경함.
//			 gwtAuthorization = GWTAuthorization.getInstance();
//			 gwtExtAuth = GWTExtAuth.getInstance();
//			
//			
//			 HashMap<String,Boolean> authMapDef = new HashMap<String,Boolean>();
//				 authMapDef.put("srhPayrMangDeptCd",Boolean.FALSE);
//				 authMapDef.put("srhEmymtDivCd",Boolean.FALSE);
//				 authMapDef.put("srhDeptCd",Boolean.FALSE);
//				 // authMapDef.put("srhTypOccuCd",Boolean.FALSE);
//			
//			 gwtExtAuth.setCheckMapDef(authMapDef);
//			
//			 if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
//				 //권한 검색조건처리를 위해 추가된 부분
//				 mask("[화면로딩] 초기화 진행 중!");
//			 }	
//			 tmMask.scheduleRepeating(5000);
//		 }
		/**
		 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
		 * 권한설정 관련 함수 및 선언 종료 (권한 적용필요시 추가해야함.)
		 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 **/	   
	  
	  public YetaP13004(final ActionDatabase actionDatabase, final MSFPanel caller) {
		  
			//콤보 권한초기화
//			initLoad(); 
			
		    
		    this.setFrame(false);
	        this.setBodyBorder(false);
	        this.setBorders(false);
	        this.setHeaderVisible(false);
	        //FormLayout layout = new FormLayout();
	        //layout.setDefaultWidth(600);
	       // layout.setLabelWidth(0);  
	       // this.setLayout(layout);   
	        this.setAutoHeight(true);
	        this.actionDatabase = actionDatabase;
	        this.caller = caller;
		   
	        cpYeta13004 = new ContentPanel();  

		    createSearchForm();			//검색필드를 적용
	        createMsfGridForm1();		//금전소비대차계약
	        createMsfGridForm2();		//임대차계약
	           
	        cpYeta13004.setBodyBorder(false);
	        cpYeta13004.setBorders(false);
	        cpYeta13004.setHeaderVisible(false);
	        cpYeta13004.setSize("790px", "640px");
		   
	        this.add(cpYeta13004);
	        formBinding = new FormBinding(this, true);
		    
	        this.setSize("810px", "710px");  
	  } 
	    
	  /**
	   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	   * 생성자 함수 선언부 종료
	   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
	   **/		 
	    
	  /**
	   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	   * 폼 생성시 기본 처리 함수 선언부 시작
	   * 1. 폼 생성 선언
	   * 2. 공통 버튼 처리 선언
	   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
	   **/	
	  

	   

	  /**
	   * 기본정보 설정
	   */
	private void createSearchForm() {
		  
		actionDatabase = ActionDatabase.UPDATE;

	    systemkey = new HiddenField<String>();	/**  column SYSTEMKEY : systemkey */
		systemkey.setName("systemkey");
		cpYeta13004.add(systemkey);
		
	    dpobCd = new HiddenField<String>();		/**  column 사업장코드 : dpobCd */
	    dpobCd.setName("dpobCd");
	    cpYeta13004.add(dpobCd);
	    
	    edacRvyy = new HiddenField<String>();	/** column 정산년도 : edacRvyy */
	    edacRvyy.setName("edacRvyy");
	    cpYeta13004.add(edacRvyy);
	    
	    settGbcd = new HiddenField<String>();	/** column 정산구분코드 : settGbcd */
	    settGbcd.setName("settGbcd");
	    cpYeta13004.add(settGbcd);
	    
	    deptNm = new HiddenField<String>();		/** column 부서명 : deptNm */
	    deptNm.setName("deptNm");
	    cpYeta13004.add(deptNm);
	    
	    hanNm = new HiddenField<String>();		/** column 성명 : hanNm */
	    hanNm.setName("hanNm");
	    cpYeta13004.add(hanNm);

		sysComBass0300Dto = new PrgmComBass0300DTO();
		msfCoCalendarDto = new SysCoCalendarDTO();
			     
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		sysComBass0300Dto.setRpsttvCd("Y002");
		lsSettGbcd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);	//정산구분
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
			     
			     
		//--------------------급여년도 불러 오는 함수 ------------------------------------------------
		lsdacRvyyStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);		//급여년도
		//--------------------급여부서 불러 오는 함수 ------------------------------------------------ 

		cpYeta13004.setLayout(new FlowLayout());

		LayoutContainer lcSchCol = new LayoutContainer();
		lcSchCol.setLayout(new ColumnLayout());

		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("기본정보");

		LayoutContainer lcSchCol01 = new LayoutContainer();

		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol01.setLayout(frmlytSch);
				
		srhEdacRvyy = new TextField<String>();
		srhEdacRvyy.setName("edacRvyy");
//		srhEdacRvyy.setForceSelection(true);
//		srhEdacRvyy.setMinChars(1);
//		srhEdacRvyy.setDisplayField("yearDisp");
//		srhEdacRvyy.setValueField("year");
//		srhEdacRvyy.setTriggerAction(TriggerAction.ALL);
		// srhEdacRvyy.setEmptyText("--년도선택--");
		srhEdacRvyy.setSelectOnFocus(true);
		srhEdacRvyy.setReadOnly(true);
		srhEdacRvyy.setEnabled(true);
//		srhEdacRvyy.setStore(lsdacRvyyStore);
		srhEdacRvyy.setFieldLabel("년도");
//		srhEdacRvyy.getStore().addStoreListener(new StoreListener<BaseModel>() {
//			public void handleEvent(StoreEvent<BaseModel> be) {
//				srhEdacRvyy.setValue(lsdacRvyyStore.findModel("year",DateTimeFormat.getFormat("yyyy").format(new Date())));
//			}
//		});
				
		lcSchCol01.add(srhEdacRvyy, new FormData("100%"));

		LayoutContainer lcSchCol02 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol02.setLayout(frmlytSch);

		srhSettGbcd = new ComboBox<BaseModel>();
		srhSettGbcd.setName("srhSettGbcd");
		srhSettGbcd.setForceSelection(true);
		srhSettGbcd.setMinChars(1);
		srhSettGbcd.setDisplayField("commCdNm");
		srhSettGbcd.setValueField("commCd");
		srhSettGbcd.setTriggerAction(TriggerAction.ALL);
		srhSettGbcd.setEmptyText("--정산구분선택--");
		srhSettGbcd.setSelectOnFocus(true);
		srhSettGbcd.setReadOnly(true);
		srhSettGbcd.setEnabled(true);
		srhSettGbcd.setStore(lsSettGbcd);
		srhSettGbcd.setFieldLabel("정산구분");
		srhSettGbcd.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				YetaUtils.setSelectedComboValue(srhSettGbcd, settGbcd.getValue(), "commCd");
//				srhSettGbcd.setValue(lsSettGbcd.getAt(0));
			}
		});
		lcSchCol02.add(srhSettGbcd, new FormData("100%"));

		LayoutContainer lcSchCol03 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol03.setLayout(frmlytSch);

		srhDeptCd = new TextField<String>();
		srhDeptCd.setReadOnly(true);
		srhDeptCd.setName("srhDeptCd");
		srhDeptCd.setWidth(100);
		srhDeptCd.setFieldLabel("부서");

		lcSchCol03.add(srhDeptCd, new FormData("100%"));

		LayoutContainer lcSchCol04 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol04.setLayout(frmlytSch);

		srhHanNm = new TextField<String>();
		srhHanNm.setReadOnly(true);
		srhHanNm.setName("srhHanNm");
		srhHanNm.setFieldLabel("성명");

		lcSchCol04.add(srhHanNm, new FormData("100%"));

		lcSchCol.add(lcSchCol01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		lcSchCol.add(lcSchCol02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		lcSchCol.add(lcSchCol03, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		lcSchCol.add(lcSchCol04, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));

		fieldSet.add(lcSchCol, new FormData("100%"));

		cpYeta13004.add(fieldSet);
			// vp.add(panel);
		
		}  
	 	 
			
   	
	  @Override	
	   public void bind(final ModelData model) { 
	        formBinding.bind(model);
	        formBinding.addListener(Events.Bind, new Listener<BaseEvent>() {
	            @Override
	            public void handleEvent(BaseEvent be) {
	            	 Timer timer = new Timer() {
							@Override
							public void run() {
								

				            	srhDeptCd.setValue(deptNm.getValue());
				    			srhHanNm.setValue(hanNm.getValue());
							}
						};
						
						timer.schedule(3000);
	            
	    			
	            	reload();    
	            }
	        });
	    }
		       
		@Override
		public boolean isValid() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void onSuccessSave() {
			// TODO Auto-generated method stub
			
		} 
		
		private void createMsfGridForm1() {
//		private LayoutContainer createMsfGridForm1() {	
			
//			LayoutContainer lcTabFormLayer = new LayoutContainer();
//			
//			ContentPanel cp01 = new ContentPanel();   
//			cp01.setBodyBorder(false);
//			cp01.setHeaderVisible(false);
//			cp01.setLayout(new FitLayout());
//			cp01.setSize(790, 440);

			
			topYeta3120BtnBar  = new ButtonBar();
			topYeta3120BtnBar .setAlignment(HorizontalAlignment.RIGHT);

			btnYeta3120New   = new Button("신규");
			btnYeta3120New.setIcon(MSFMainApp.ICONS.new16());
			btnYeta3120New.addListener(Events.Select, new Listener<ButtonEvent>() {
	            public void handleEvent(ButtonEvent e) {
	            	
	            	//테스트용
//					dpobCd.setValue(" ");
//					systemkey.setValue("20080013");
					
					if (MSFSharedUtils.paramNull(systemkey.getValue())) {
		 	    		 return;
		      	     }
					 
					yetaP13004GridPanel01.getMsfGrid().clearData();
					 
					 BaseModel bmData = yetaP13004GridPanel01.getTableDef().getDefaultValues();  
			              
//			         bmData.set("dpobCd",  MSFMainApp.get().getUser().getDpobCd()); /** column 사업장코드 : dpobCd */
			         bmData.set("dpobCd",  dpobCd.getValue()); 		/** column 사업장코드 : dpobCd */
			         bmData.set("systemkey", systemkey.getValue()); /** column SYSTEMKEY : systemkey */
			         bmData.set("edacRvyy", edacRvyy.getValue());	/** column 연말정산귀속년도 : edacRvyy */
			         bmData.set("settGbcd", settGbcd.getValue());	/** column 정산구분코드 : settGbcd */
			         
			         bmData.set("cnclSqno", 0L);    /** column 금전소비대차일련번호 : cnclSqno */
			         bmData.set("cnclName", "");    /** column 금전소비대차_임대인성명 : cnclName */
			         bmData.set("cnclRsno", "");    /** column 금전소비대차_주민번호 : cnclRsno */
			         bmData.set("cnclStdt", GWTUtils.getDateFromString("", "yyyyMMdd"));    /** column 금전소비대차_계약시작일자 : cnclStdt */
			         bmData.set("cnclEddt", GWTUtils.getDateFromString("", "yyyyMMdd"));    /** column 금전소비대차_계약종료일자 : cnclEddt */
			         bmData.set("cnclItro", 0.0);    /** column 금전소비대차_차입금이자율 : cnclItro */
			         bmData.set("cnclRdmt", 0L);    /** column 금전소비대차_원리금상환액계 : cnclRdmt */
			         bmData.set("cnclPrpl", 0L);    /** column 금전소비대차_원리금 : cnclPrpl */
			         bmData.set("cnclItrt", 0L);    /** column 금전소비대차_이자 : cnclItrt */
			         bmData.set("cnclDuam", 0L);    /** column 금전소비대차_공제금액 : cnclDuam */
			         
			         yetaP13004GridPanel01.getMsfGrid().getGrid().stopEditing();      
			         yetaP13004GridPanel01.getMsfGrid().getGrid().getStore().insert(bmData,0);   
			         yetaP13004GridPanel01.getMsfGrid().getGrid().startEditing(yetaP13004GridPanel01.getMsfGrid().getGrid().getStore().indexOf(bmData), 0);   
			         
	            	actionDatabase = ActionDatabase.INSERT;
//	            	doAction(actionDatabase, "YETA3120");
	            }
	        });
			
			topYeta3120BtnBar.add(btnYeta3120New);

			btnYeta3120Del  = new Button("삭제");
			btnYeta3120Del.setIcon(MSFMainApp.ICONS.save16());
			btnYeta3120Del.addListener(Events.Select, new Listener<ButtonEvent>() {
				public void handleEvent(ButtonEvent e) {
					Iterator<BaseModel> itBm  = yetaP13004GridPanel01.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
	                List<Record>  lsRec  = new ArrayList<Record>();
	                
	                if((ActionDatabase.INSERT).equals(actionDatabase)) {
	                	yetaP13004GridPanel01.getMsfGrid().clearData();
	                	
	                	actionDatabase = ActionDatabase.DELETE;
	                	
					}else {
						while(itBm.hasNext()) {
		                	Record rec  = new Record(itBm.next()); 
		                    lsRec.add(rec);
		                } 
		                setListRecord(lsRec.iterator()); 
		                  
		                actionDatabase = ActionDatabase.DELETE;
		                doAction(actionDatabase, "YETA3120");
					}
				}
			});
	                
			topYeta3120BtnBar.add(btnYeta3120Del);
				
			btnYeta3120Save = new Button("저장");
			btnYeta3120Save.setIcon(MSFMainApp.ICONS.save16());
			btnYeta3120Save.addListener(Events.Select, new Listener<ButtonEvent>() {
	            public void handleEvent(ButtonEvent e) {
	                setListRecord(yetaP13004GridPanel01.getMsfGrid().getStore().getModifiedRecords().iterator()); 
	                
	                if((ActionDatabase.INSERT).equals(actionDatabase)) {
	                	actionDatabase = ActionDatabase.INSERT;
	                }else {
	                	actionDatabase = ActionDatabase.UPDATE;
	                }
	                
	                doAction(actionDatabase, "YETA3120");
	            }
	        });

			topYeta3120BtnBar.add(btnYeta3120Save);
				
//			btnYetaClose  = new Button("닫기");
//			topYetaBtnBar.add(btnYetaClose);
				
			cpYeta13004.add(topYeta3120BtnBar);
//			cp01.add(topYeta3120BtnBar);
			
			FieldSet gridFieldSet = new FieldSet();
			gridFieldSet.setHeadingHtml("금전소비대차계약");
			gridFieldSet.setBorders(true);
			
			yetaP13004GridPanel01 = new MSFGridPanel(yetaP13004ToYeta3120Def, false, false, false, false, false);
			yetaP13004GridPanel01.setSize("790px", "190px");
			yetaP13004GridPanel01.setBorders(true);
			yetaP13004GridPanel01.setHeaderVisible(false);  
			yetaP13004GridPanel01.getBottomComponent().setVisible(false);
			
			
			/** --- 그리드 합계 부분  시작 --- **/
			AggregationRowConfig<BaseModel> payrSummaryRow = new AggregationRowConfig<BaseModel>();  
			
			payrSummaryRow.setHtml(Ye16Ta3120BM.ATTR_CNCLNAME, "합 계"); 
			 
			payrSummaryRow.setCellStyle(Ye16Ta3120BM.ATTR_CNCLITRO,"summary_color");	/** set 금전소비대차_차입금이자율 : cnclItro */
			payrSummaryRow.setCellStyle(Ye16Ta3120BM.ATTR_CNCLRDMT,"summary_color");	/** set 금전소비대차_원리금상환액계 : cnclRdmt */
			payrSummaryRow.setCellStyle(Ye16Ta3120BM.ATTR_CNCLPRPL,"summary_color");	/** set 금전소비대차_원리금 : cnclPrpl */
			payrSummaryRow.setCellStyle(Ye16Ta3120BM.ATTR_CNCLITRT,"summary_color");	/** set 금전소비대차_이자 : cnclItrt */
								    
			payrSummaryRow.setSummaryType(Ye16Ta3120BM.ATTR_CNCLITRO, SummaryType.SUM);   
			payrSummaryRow.setSummaryFormat(Ye16Ta3120BM.ATTR_CNCLITRO, NumberFormat.getFormat("#,##0;(#,##0)"));  
								    
			payrSummaryRow.setSummaryType(Ye16Ta3120BM.ATTR_CNCLRDMT, SummaryType.SUM);   
			payrSummaryRow.setSummaryFormat(Ye16Ta3120BM.ATTR_CNCLRDMT, NumberFormat.getFormat("#,##0;(#,##0)"));  
			
			payrSummaryRow.setSummaryType(Ye16Ta3120BM.ATTR_CNCLPRPL, SummaryType.SUM);   
			payrSummaryRow.setSummaryFormat(Ye16Ta3120BM.ATTR_CNCLPRPL, NumberFormat.getFormat("#,##0;(#,##0)"));  
			
			payrSummaryRow.setSummaryType(Ye16Ta3120BM.ATTR_CNCLITRT, SummaryType.SUM);   
			payrSummaryRow.setSummaryFormat(Ye16Ta3120BM.ATTR_CNCLITRT, NumberFormat.getFormat("#,##0;(#,##0)"));  
			
			yetaP13004GridPanel01.getGrid().getColumnModel().addAggregationRow(payrSummaryRow);  
			/** --- 그리드 합계 부분  종료 --- **/
			
			gridFieldSet.add(yetaP13004GridPanel01);
			cpYeta13004.add(gridFieldSet);
			
//			cp01.add(gridFieldSet);
//			
//			lcTabFormLayer.add(cp01);
//			
//			return lcTabFormLayer;
//			
		}
		
		
		
		private void createMsfGridForm2() {
			
			topYeta3160BtnBar  = new ButtonBar();
			topYeta3160BtnBar .setAlignment(HorizontalAlignment.RIGHT);

			btnYeta3160New   = new Button("신규");
			btnYeta3160New.setIcon(MSFMainApp.ICONS.new16());
			btnYeta3160New.addListener(Events.Select, new Listener<ButtonEvent>() {
	            public void handleEvent(ButtonEvent e) {
	            	//테스트용
//					dpobCd.setValue(" ");
//					systemkey.setValue("20080013");
					
					if (MSFSharedUtils.paramNull(systemkey.getValue())) {
		 	    		 return;
		      	     }
					 
					yetaP13004GridPanel02.getMsfGrid().clearData();
					 
					BaseModel bmData = yetaP13004GridPanel02.getTableDef().getDefaultValues();  
			              
//			         bmData.set("dpobCd",  MSFMainApp.get().getUser().getDpobCd()); /** column 사업장코드 : dpobCd */
					bmData.set("dpobCd",  dpobCd.getValue()); /** column 사업장코드 : dpobCd */
			        bmData.set("systemkey", systemkey.getValue()); /** column SYSTEMKEY : systemkey */
			        bmData.set("edacRvyy", srhEdacRvyy.getValue());/** column 연말정산귀속년도 : edacRvyy */
			        bmData.set("settGbcd", srhSettGbcd.getValue());/** column 정산구분코드 : settGbcd */
			         
			        bmData.set("mnrnSqno", 0L);    /** column 월세일련번호 : mnrnSqno */
			        bmData.set("mnrnRsno", "");    /** column 월세_주민번호 : mnrnRsno */
			        bmData.set("mnrnTyhu", "");    /** column 월세_주택유형코드 : mnrnTyhu */
			        bmData.set("mnrnArea", "");    /** column 월세주택계약면적 : mnrnArea */
			        bmData.set("mnrnAddr", "");    /** column 월세_계약서상주소 : mnrnAddr */
			        bmData.set("mnrnStdt", GWTUtils.getDateFromString("", "yyyyMMdd"));    /** column 월세_임대차계약시작일자 : mnrnStdt */
			        bmData.set("mnrnEddt", GWTUtils.getDateFromString("", "yyyyMMdd"));    /** column 월세_임대차계약종료일자 : mnrnEddt */
			        bmData.set("mnrnAmnt", 0L);    /** column 월세_연간월세금액 : mnrnAmnt */
			        bmData.set("mnrnDuam", 0L);    /** column 월세_월세세액공제금액 : mnrnDuam */
			         
			        yetaP13004GridPanel02.getMsfGrid().getGrid().stopEditing();      
			        yetaP13004GridPanel02.getMsfGrid().getGrid().getStore().insert(bmData,0);   
			        yetaP13004GridPanel02.getMsfGrid().getGrid().startEditing(yetaP13004GridPanel02.getMsfGrid().getGrid().getStore().indexOf(bmData), 0);   
			         
			        actionDatabase = ActionDatabase.INSERT;
			         //	            	doAction(actionDatabase, "YETA3130");
	            }
	        });
			
			topYeta3160BtnBar.add(btnYeta3160New);

			btnYeta3160Del  = new Button("삭제");
			btnYeta3160Del.setIcon(MSFMainApp.ICONS.save16());
			btnYeta3160Del.addListener(Events.Select, new Listener<ButtonEvent>() {
				public void handleEvent(ButtonEvent e) {
					Iterator<BaseModel> itBm  = yetaP13004GridPanel02.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
	                List<Record>  lsRec  = new ArrayList<Record>();
	                
	                if((ActionDatabase.INSERT).equals(actionDatabase)) {
	                	
	                	yetaP13004GridPanel02.getMsfGrid().clearData();
	                	
	                	actionDatabase = ActionDatabase.DELETE;
	                }else {
						while(itBm.hasNext()) {
		                	Record rec  = new Record(itBm.next()); 
		                    lsRec.add(rec);
		                } 
		                setListRecord(lsRec.iterator()); 
		                  
		                actionDatabase = ActionDatabase.DELETE;
		                doAction(actionDatabase, "YETA3160");
					}
				}
			});
			topYeta3160BtnBar.add(btnYeta3160Del);
				
			btnYeta3160Save = new Button("저장");
			btnYeta3160Save.setIcon(MSFMainApp.ICONS.save16());
			btnYeta3160Save.addListener(Events.Select, new Listener<ButtonEvent>() {
	            public void handleEvent(ButtonEvent e) {
	                setListRecord(yetaP13004GridPanel02.getMsfGrid().getStore().getModifiedRecords().iterator()); 
	                
	                if((ActionDatabase.INSERT).equals(actionDatabase)) {
	                	actionDatabase = ActionDatabase.INSERT;
	                }else {
	                	actionDatabase = ActionDatabase.UPDATE;
	                }
	                
	                doAction(actionDatabase, "YETA3160");
	                
	            }
	        });

			topYeta3160BtnBar.add(btnYeta3160Save);
				
			cpYeta13004.add(topYeta3160BtnBar);
			
			FieldSet gridFieldSet = new FieldSet();
			gridFieldSet.setHeadingHtml("임대차계약");
			gridFieldSet.setBorders(true);

			yetaP13004GridPanel02 = new MSFGridPanel(yetaP13004ToYeta3160Def, false, false, false, false, false);
			yetaP13004GridPanel02.setSize("790px", "200px");
			yetaP13004GridPanel02.setBorders(false);
			yetaP13004GridPanel02.setHeaderVisible(false);  
			yetaP13004GridPanel02.getBottomComponent().setVisible(false);
			
			
			/** --- 그리드 합계 부분  시작 --- **/
			AggregationRowConfig<BaseModel> payrSummaryRow = new AggregationRowConfig<BaseModel>();  
			
			payrSummaryRow.setHtml(Ye16Ta3160BM.ATTR_LEASNAME, "합 계"); 
			 
			payrSummaryRow.setCellStyle(Ye16Ta3160BM.ATTR_LEASDPST,"summary_color");	/** set 금전소비대차_차입금이자율 : cnclItro */
								    
			payrSummaryRow.setSummaryType(Ye16Ta3160BM.ATTR_LEASDPST, SummaryType.SUM);   
			payrSummaryRow.setSummaryFormat(Ye16Ta3160BM.ATTR_LEASDPST, NumberFormat.getFormat("#,##0;(#,##0)"));  
								    
			
			yetaP13004GridPanel02.getGrid().getColumnModel().addAggregationRow(payrSummaryRow);  
			/** --- 그리드 합계 부분  종료 --- **/			
			
			
			
			
			gridFieldSet.add(yetaP13004GridPanel02);
			cpYeta13004.add(gridFieldSet);
		}	
		
		public void setListRecord(Iterator<Record> records) {
		    this.records = records;
		} 
		
		@Override
		public void reload() {
			
			reloadYeta3120();
			reloadYeta3160();
			
//				IColumnFilter filters = null;
//				
//				yetaP13004GridPanel01.getTableDef().setTableColumnFilters(filters);
//				yetaP13004GridPanel01.getTableDef().addColumnFilter("edacRvyy", MSFSharedUtils.allowNulls(srhEdacRvyy.getValue())
//						, SimpleColumnFilter.OPERATOR_EQUALS);//연말정산귀속년도 
////				yetaP13001GridPanel.getTableDef().addColumnFilter("edacRvyy", MSFSharedUtils.getSelectedComboValue(srhEdacRvyy, "year")
////						, SimpleColumnFilter.OPERATOR_EQUALS);//연말정산귀속년도
//				yetaP13004GridPanel01.getTableDef().addColumnFilter("settGbcd", MSFSharedUtils.getSelectedComboValue(srhSettGbcd,"commCd")
//						, SimpleColumnFilter.OPERATOR_EQUALS);//정산구분
//				yetaP13004GridPanel01.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue())
//						, SimpleColumnFilter.OPERATOR_EQUALS);//시스템키
//			 
//				yetaP13004GridPanel01.reload();
//				
//				// TODO Auto-generated method stub
//				filters = null;
//				
//				yetaP13004GridPanel02.getTableDef().setTableColumnFilters(filters);
//				yetaP13004GridPanel02.getTableDef().addColumnFilter("edacRvyy", MSFSharedUtils.allowNulls(srhEdacRvyy.getValue())
//						, SimpleColumnFilter.OPERATOR_EQUALS);//연말정산귀속년도 
////				yetaP13001GridPanel.getTableDef().addColumnFilter("edacRvyy", MSFSharedUtils.getSelectedComboValue(srhEdacRvyy, "year")
////						, SimpleColumnFilter.OPERATOR_EQUALS);//연말정산귀속년도
//				yetaP13004GridPanel02.getTableDef().addColumnFilter("settGbcd", MSFSharedUtils.getSelectedComboValue(srhSettGbcd,"commCd")
//						, SimpleColumnFilter.OPERATOR_EQUALS);//정산구분
//				yetaP13004GridPanel02.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue())
//						, SimpleColumnFilter.OPERATOR_EQUALS);//시스템키
//			 
//				yetaP13004GridPanel02.reload();

//			actionDatabase = ActionDatabase.READ;
	}
		
		
	public void reloadYeta3120() {
			
		IColumnFilter filters = null;
			
		yetaP13004GridPanel01.getTableDef().setTableColumnFilters(filters);
		yetaP13004GridPanel01.getTableDef().addColumnFilter("edacRvyy", MSFSharedUtils.allowNulls(srhEdacRvyy.getValue())
				, SimpleColumnFilter.OPERATOR_EQUALS);//연말정산귀속년도 
//			yetaP13001GridPanel.getTableDef().addColumnFilter("edacRvyy", MSFSharedUtils.getSelectedComboValue(srhEdacRvyy, "year")
//					, SimpleColumnFilter.OPERATOR_EQUALS);//연말정산귀속년도
		yetaP13004GridPanel01.getTableDef().addColumnFilter("settGbcd", MSFSharedUtils.getSelectedComboValue(srhSettGbcd,"commCd")
				, SimpleColumnFilter.OPERATOR_EQUALS);//정산구분
		yetaP13004GridPanel01.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue())
				, SimpleColumnFilter.OPERATOR_EQUALS);//시스템키
		 
		yetaP13004GridPanel01.reload();
	}
	
	public void reloadYeta3160() {
		
		// TODO Auto-generated method stub
		IColumnFilter filters = null;
		
		yetaP13004GridPanel02.getTableDef().setTableColumnFilters(filters);
		yetaP13004GridPanel02.getTableDef().addColumnFilter("edacRvyy", MSFSharedUtils.allowNulls(srhEdacRvyy.getValue())
				, SimpleColumnFilter.OPERATOR_EQUALS);//연말정산귀속년도 
//		yetaP13001GridPanel.getTableDef().addColumnFilter("edacRvyy", MSFSharedUtils.getSelectedComboValue(srhEdacRvyy, "year")
//				, SimpleColumnFilter.OPERATOR_EQUALS);//연말정산귀속년도
		yetaP13004GridPanel02.getTableDef().addColumnFilter("settGbcd", MSFSharedUtils.getSelectedComboValue(srhSettGbcd,"commCd")
				, SimpleColumnFilter.OPERATOR_EQUALS);//정산구분
		yetaP13004GridPanel02.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue())
				, SimpleColumnFilter.OPERATOR_EQUALS);//시스템키
	 
		yetaP13004GridPanel02.reload();
	}
	
		
		
//		public void reloadYeta3130() {
//			
//				
//				
//		
////			actionDatabase = ActionDatabase.READ;
//		}	 
		/**
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
		 * 팝업화면 시작
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		 **/
		/**
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
		 * 팝업화면 종료
		 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		 **/		
}
