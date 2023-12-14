/**
 * 거주자간 주택임차차입금 원리금 상환액
 */
package com.app.exterms.yearendtax.client.form.yeta2019;
  

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.yearendtax.client.dto.yeta2019.Ye162520BM;
import com.app.exterms.yearendtax.client.dto.yeta2019.Ye162520DTO;
import com.app.exterms.yearendtax.client.dto.yeta2019.Ye162530BM;
import com.app.exterms.yearendtax.client.dto.yeta2019.Ye162530DTO;
import com.app.exterms.yearendtax.client.form.defs.yeta2019.Ye162520Def;
import com.app.exterms.yearendtax.client.form.defs.yeta2019.Ye162530Def;
import com.app.exterms.yearendtax.client.service.yeta2019.YetaP43004Service;
import com.app.exterms.yearendtax.client.service.yeta2019.YetaP43004ServiceAsync;
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
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
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
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public  class YetaP43004   extends MSFFormPanel {  

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
 
	private  ContentPanel cpYeta23004; 
	  
	/**######################################################
	 * { 시스템 기본설정파일 선언부  시작}
	 *#######################################################*/

	// 권한 설정 객체
	private static GWTAuthorization gwtAuthorization;
	private static GWTExtAuth gwtExtAuth;
	private boolean maskTracker = false; // 초기화 로딩 팝업 강제 unmask 처리
		  
	/**######################################################
	 * { 시스템 기본설정파일 선언부  종료}
	 *#######################################################*/

		  
	// -------------- grid 선언 시작  ---------------	  
	private MSFGridPanel YetaP43004GridPanel01;
	private Ye162520Def YetaP43004ToYeta3120Def  = new Ye162520Def("YetaP23004");	//금전소비대차계약 그리드 테이블 컬럼 define 
	
	private MSFGridPanel yetaP13004GridPanel02;
	private Ye162530Def yetaP13004ToYeta3160Def  = new Ye162530Def("YetaP23004");	//금전소비대차계약 그리드 테이블 컬럼 define 
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
	private Boolean reading = false;
	public FormBinding formBinding;
	private Iterator<Record> records;

  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * Button 변수 선언
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
       
  	private  ButtonBar topBtnYe162520Bar = new ButtonBar();
	private  Button btnYe162520New = new Button();		//신규
	private  Button btnYe162520Del = new Button();		//삭제
	private  Button btnYe162520Save = new Button();		//저장
	
	private  ButtonBar topBtnYe162530Bar = new ButtonBar();
	private  Button btnYe162530New = new Button();		//신규
	private  Button btnYe162530Del = new Button();		//삭제
	private  Button btnYe162530Save = new Button();		//저장
	

  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 검색변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
	// -------------- 검색 조건 시작 --------------
 	private TextField<String> srhYrtxBlggYr;	// 년도
 	private ComboBox<BaseModel> srhClutSeptCd; 	// 정산구분 
 	private TextField<String> srhDeptCd; 		// 부서
 	private TextField<String> srhHanNm; 		// 성명
 	
 	private HiddenField<String> systemkey;	/**  column SYSTEMKEY : systemkey */
    private HiddenField<String> dpobCd;		/**  column 사업장코드 : dpobCd */
    private HiddenField<String> yrtxBlggYr;	/** column 정산년도 : yrtxBlggYr */
    private HiddenField<String> clutSeptCd;	/** column 정산구분코드 : clutSeptCd */
    private HiddenField<String> deptNm;  	/**  column 부서명 : deptNm */
	private HiddenField<String>	hanNm;		/**  column 성명 : hanNm */
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
	private  ListStore<BaseModel> lsclutSeptCd = new ListStore<BaseModel>(); 		// 정산구분
	// -------------- stroe 선언 종료 --------------
	 	
	// -------------- 서비스 호출 시작 --------------
	private YetaP43004ServiceAsync yetaP43004Service = YetaP43004Service.Util.getInstance();
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
	// 버튼에 따른 Action
	private void doAction(ActionDatabase actionDatabase, String doActionFlag) {
		switch (actionDatabase) {
		case INSERT:

			if ("YE162520".equals(doActionFlag)) {
				YetaP43004ToYe162520FormSave();
			} else if ("YE162530".equals(doActionFlag)) {
				YetaP43004ToYe162530FormSave();
			} else {
				MessageBox.alert("doAction 오류", actionDatabase.name(), null);
			}

			break;
		case UPDATE:

			if ("YE162520".equals(doActionFlag)) {
				YetaP43004ToYe162520FormSave();
			} else if ("YE162530".equals(doActionFlag)) {
				YetaP43004ToYe162530FormSave();
			} else {
				MessageBox.alert("doAction 오류", actionDatabase.name(), null);
			}
			break;
		case DELETE:

			if ("YE162520".equals(doActionFlag)) {
				YetaP43004ToYe162520FormSave();
			} else if ("YE162530".equals(doActionFlag)) {
				YetaP43004ToYe162530FormSave();
			} else {
				MessageBox.alert("doAction 오류", actionDatabase.name(), null);
			}
			break;
		}
	}
		
		
	private void YetaP43004ToYe162520FormSave() {
		
		if (MSFSharedUtils.paramNotNull(records)) {
	              
			List<Ye162520DTO> listYe162520Dto = new ArrayList<Ye162520DTO>();
			Ye162520DTO ye162520Dto = new Ye162520DTO();
			while (records.hasNext()) {

				Record record = (Record) records.next();
				BaseModel bmMapModel = (BaseModel) record.getModel();

				ye162520Dto = new Ye162520DTO();
				ye162520Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    												/** column 사업장코드 : dpobCd */
				ye162520Dto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));											/** column 연말정산귀속년도 : yrtxBlggYr */
				ye162520Dto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));											/** column 정산구분코드 : clutSeptCd */
				ye162520Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    										/** column SYSTEMKEY : systemkey */
				ye162520Dto.setComrCalnSeilNum((Long) bmMapModel.get("comrCalnSeilNum"));    												/** column 금전소비대차일련번호 : comrCalnSeilNum */
				ye162520Dto.setTaxVvalKrnCd(MSFSharedUtils.allowNulls(bmMapModel.get("taxVvalKrnCd")));    									/** column 국세청자료구분코드 : taxVvalKrnCd */
				ye162520Dto.setComrCdtrNm(MSFSharedUtils.allowNulls(bmMapModel.get("comrCdtrNm")));    										/** column G16_금전소비대차_대주성명 : comrCdtrNm */
				ye162520Dto.setComrCdtrResnRegnNum(MSFSharedUtils.allowNulls(bmMapModel.get("comrCdtrResnRegnNum")).replaceAll("-", ""));	/** column G17_금전소비대차_대주주민등록번호 : comrCdtrResnRegnNum */
				ye162520Dto.setComrCnttPridBgnnDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("comrCnttPridBgnnDt"),"yyyyMMdd"));		/** column G18_금전소비대차_계약기간시작일자 : comrCnttPridBgnnDt */
				ye162520Dto.setComrCnttPridEndDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("comrCnttPridEndDt"),"yyyyMMdd"));			/** column G19_금전소비대차_계약기간종료일자 : comrCnttPridEndDt */
				ye162520Dto.setComrLoanItrtRate((Double) bmMapModel.get("comrLoanItrtRate"));    											/** column G20_금전소비대차_차입금이자율 : comrLoanItrtRate */
				ye162520Dto.setComrPclttAmtftAggr((Long) bmMapModel.get("comrPclttAmtftAggr"));    											/** column G21_금전소비대차_원리금상환액합계 : comrPclttAmtftAggr */
				ye162520Dto.setComrPrnilSum((Long) bmMapModel.get("comrPrnilSum"));    														/** column G22_금전소비대차_원금금액 : comrPrnilSum */
				ye162520Dto.setComrItrtSum((Long) bmMapModel.get("comrItrtSum"));    														/** column G23_금전소비대차_이자금액 : comrItrtSum */
				ye162520Dto.setComrDducSum((Long) bmMapModel.get("comrDducSum"));    														/** column G24_금전소비대차_공제금액 : comrDducSum */
//				ye162520Dto.setEctnFlTrnrCtlYn( ((Boolean) bmMapModel.get("ectnFlTrnrCtlYn")) ? "Y" : "N"  );								/** column 전자파일이관여부 : ectnFlTrnrCtlYn */
	                
				
				if("".equals(ye162520Dto.getComrCdtrNm()) || ye162520Dto.getComrCdtrNm() == null) {
					MessageBox.alert("경고","[금전소비대차계약]의 임대인성명을 입력해주세요.(필수)", null);
					return;
				}else if("".equals(ye162520Dto.getComrCdtrResnRegnNum()) || ye162520Dto.getComrCdtrResnRegnNum() == null) {
					MessageBox.alert("경고","[금전소비대차계약]의 주민번호를 입력해주세요.(필수)", null);
					return;
				}else if(ye162520Dto.getComrCdtrResnRegnNum().length() != 13) {
					MessageBox.alert("경고","[금전소비대차계약]의 주민번호는  13자리입니다.(필수)", null);
					return;
				}else if("Y0140000".equals(ye162520Dto.getTaxVvalKrnCd())) {
					MessageBox.alert("경고","[금전소비대차계약]의 국세청 자료는 수정 불가 합니다.", null);
					return;
				}
	                
				listYe162520Dto.add(ye162520Dto);
			}  
	                
			if (listYe162520Dto.size() <= 0) {
				MessageBox.alert(actionDatabase.name() + "저장", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
				return;
			}
	                
			yetaP43004Service.activityOnYetaP43004ToYe162520(listYe162520Dto, actionDatabase, new AsyncCallback<Long>(){
				public void onFailure(Throwable caught) {
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	                             MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnYetaP43004ToYe162520(" + actionDatabase.name() + ") : " + caught), null);
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
	
	
	private void YetaP43004ToYe162530FormSave() {  
		if (MSFSharedUtils.paramNotNull(records)) { 
	              
			List<Ye162530DTO> listYe162530Dto = new ArrayList<Ye162530DTO>();  
			Ye162530DTO ye162530Dto= new Ye162530DTO();  

			while (records.hasNext()) {

				Record record = (Record) records.next();
				BaseModel bmMapModel = (BaseModel) record.getModel();

				ye162530Dto = new Ye162530DTO();
				 
				 
				ye162530Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    												/** column 사업장코드 : dpobCd */
				ye162530Dto.setYrtxBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxBlggYr")));    										/** column 연말정산귀속년도 : yrtxBlggYr */
				ye162530Dto.setClutSeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("clutSeptCd")));    										/** column 정산구분코드 : clutSeptCd */
				ye162530Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    										/** column SYSTEMKEY : systemkey */
				ye162530Dto.setRntlCttSeilNum((Long) bmMapModel.get("rntlCttSeilNum"));    													/** column 임대차계약 일련번호 : rntlCttSeilNum */
				ye162530Dto.setTaxVvalKrnCd(MSFSharedUtils.allowNulls(bmMapModel.get("taxVvalKrnCd")));    									/** column 국세청자료구분코드 : taxVvalKrnCd */
				ye162530Dto.setRntlCttLehdrNm(MSFSharedUtils.allowNulls(bmMapModel.get("rntlCttLehdrNm")));    								/** column G25_임대차계약_임대인성명_상호명 : rntlCttLehdrNm */
				ye162530Dto.setRntlCttBusoprRgstnum(MSFSharedUtils.allowNulls(bmMapModel.get("rntlCttBusoprRgstnum")).replaceAll("-", ""));	/** column G26_임대차계약_주민_사업자등록번호 : rntlCttBusoprRgstnum */
				ye162530Dto.setRntlCttHusFrmCd(MSFSharedUtils.allowNulls(bmMapModel.get("rntlCttHusFrmCd$commCd")));    					/** column G27_임대차계약_주택유형코드 : rntlCttHusFrmCd */
				ye162530Dto.setRntlCttHusCnttArea((Long) bmMapModel.get("rntlCttHusCnttArea"));    											/** column G28_임대차계약_주택계약면적 : rntlCttHusCnttArea */
				ye162530Dto.setRntlCttAddr(MSFSharedUtils.allowNulls(bmMapModel.get("rntlCttAddr")));    									/** column G29_임대차계약_임대차계약서상주소지 : rntlCttAddr */
				ye162530Dto.setRntlCttPridBgnnDt(GWTUtils.getStringFromDate((Date) bmMapModel.get("rntlCttPridBgnnDt"),"yyyyMMdd"));		/** column G30_임대차계약_임대차계약기간시작일자 : rntlCttPridBgnnDt */
				ye162530Dto.setRntlCttPridEndDt(GWTUtils.getStringFromDate((Date) bmMapModel.get("rntlCttPridEndDt"),"yyyyMMdd"));    		/** column G31_임대차계약_임대차계약기간종료일자 : rntlCttPridEndDt */
				ye162530Dto.setRntlCttChrtrGrnteSum((Long) bmMapModel.get("rntlCttChrtrGrnteSum"));    										/** column G32_임대차계약_전세보증금액 : rntlCttChrtrGrnteSum */
//				ye162530Dto.setEctnFlTrnrCtlYn(( (Boolean)bmMapModel.get("ectnFlTrnrCtlYn")) ? "Y" : "N");   								/** column 전자파일이관여부 : ectnFlTrnrCtlYn */				 
	                
				
				if("".equals(ye162530Dto.getRntlCttLehdrNm()) || ye162530Dto.getRntlCttLehdrNm() == null) {
					MessageBox.alert("경고","[임대차계약]의 임대인성명을 입력해주세요.(필수)", null);
					return;
				}else if("".equals(ye162530Dto.getRntlCttBusoprRgstnum()) || ye162530Dto.getRntlCttBusoprRgstnum() == null) {
					MessageBox.alert("경고","[임대차계약]의 주민(사업자번호)번호를 입력해주세요.(필수)", null);
					return;
				}else if(ye162530Dto.getRntlCttBusoprRgstnum().length() != 13 && ye162530Dto.getRntlCttBusoprRgstnum().length() != 10) {
					MessageBox.alert("경고","[임대차계약]의 주민(사업자번호)번호는 10자리 또는 13자리 이여야 합니다.(필수)", null);
					return;
				}
//				else if(ye162530Dto.getRntlCttHusCnttArea() > 4 ) {
//					MessageBox.alert("경고","[임대차계약]의 계약면적은 4자리 이하여야 합니다.(필수)", null);
//					return;
//				}
				else if("Y0140000".equals(ye162530Dto.getTaxVvalKrnCd()) ) {
					MessageBox.alert("경고","[임대차계약]의 국세청 자료는 수정 불가 합니다.", null);
					return;
				}
				
				listYe162530Dto.add(ye162530Dto);
			}  
	                
			if (listYe162530Dto.size() <= 0) {
				MessageBox.alert(actionDatabase.name() + "저장", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
				return;
			}
	                
			yetaP43004Service.activityOnYetaP43004ToYe162530(listYe162530Dto, actionDatabase, new AsyncCallback<Long>(){
				public void onFailure(Throwable caught) {
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	                             MSFMainApp.ADMINMESSAGES.ExceptionMessageService("YetaP43004ToYe162530FormSave(" + actionDatabase.name() + ") : " + caught), null);
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
	  
	  public YetaP43004(final ActionDatabase actionDatabase, final MSFPanel caller) {
		  
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
		   
	        cpYeta23004 = new ContentPanel();  

		    createSearchForm();			//검색필드를 적용
	        createMsfGridForm1();		//금전소비대차계약
	        createMsfGridForm2();		//임대차계약
	           
	        cpYeta23004.setBodyBorder(false);
	        cpYeta23004.setBorders(false);
	        cpYeta23004.setHeaderVisible(false);
	        cpYeta23004.setSize("790px", "570px");
		   
	        this.add(cpYeta23004);
	        formBinding = new FormBinding(this, true);
		    
	        this.setSize("810px", "600px");  
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
		cpYeta23004.add(systemkey);
		
	    dpobCd = new HiddenField<String>();		/**  column 사업장코드 : dpobCd */
	    dpobCd.setName("dpobCd");
	    cpYeta23004.add(dpobCd);
	    
	    yrtxBlggYr = new HiddenField<String>();	/** column 정산년도 : yrtxBlggYr */
	    yrtxBlggYr.setName("yrtxBlggYr");
	    cpYeta23004.add(yrtxBlggYr);
	    
	    clutSeptCd = new HiddenField<String>();	/** column 정산구분코드 : clutSeptCd */
	    clutSeptCd.setName("clutSeptCd");
	    cpYeta23004.add(clutSeptCd);
	    
	    deptNm = new HiddenField<String>();		/** column 부서명 : deptNm */
	    deptNm.setName("deptNm");
	    cpYeta23004.add(deptNm);
	    
	    hanNm = new HiddenField<String>();		/** column 성명 : hanNm */
	    hanNm.setName("hanNm");
	    cpYeta23004.add(hanNm);

		sysComBass0300Dto = new PrgmComBass0300DTO();
		msfCoCalendarDto = new SysCoCalendarDTO();
			     
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		sysComBass0300Dto.setRpsttvCd("Y002");
		lsclutSeptCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);	//정산구분
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
			     
			     
		//--------------------급여년도 불러 오는 함수 ------------------------------------------------
		lsdacRvyyStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);		//급여년도
		//--------------------급여부서 불러 오는 함수 ------------------------------------------------ 

		cpYeta23004.setLayout(new FlowLayout());

		LayoutContainer lcSchCol = new LayoutContainer();
		lcSchCol.setLayout(new ColumnLayout());

		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("기본정보");

		LayoutContainer lcSchCol01 = new LayoutContainer();

		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol01.setLayout(frmlytSch);
				
		srhYrtxBlggYr = new TextField<String>();
		srhYrtxBlggYr.setName("yrtxBlggYr");
//		srhyrtxBlggYr.setForceSelection(true);
//		srhyrtxBlggYr.setMinChars(1);
//		srhyrtxBlggYr.setDisplayField("yearDisp");
//		srhyrtxBlggYr.setValueField("year");
//		srhyrtxBlggYr.setTriggerAction(TriggerAction.ALL);
		// srhyrtxBlggYr.setEmptyText("--년도선택--");
		srhYrtxBlggYr.setSelectOnFocus(true);
		srhYrtxBlggYr.setReadOnly(true);
		srhYrtxBlggYr.setEnabled(true);
//		srhyrtxBlggYr.setStore(lsdacRvyyStore);
		srhYrtxBlggYr.setFieldLabel("년도");
//		srhyrtxBlggYr.getStore().addStoreListener(new StoreListener<BaseModel>() {
//			public void handleEvent(StoreEvent<BaseModel> be) {
//				srhyrtxBlggYr.setValue(lsdacRvyyStore.findModel("year",DateTimeFormat.getFormat("yyyy").format(new Date())));
//			}
//		});
				
		lcSchCol01.add(srhYrtxBlggYr, new FormData("100%"));

		LayoutContainer lcSchCol02 = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcSchCol02.setLayout(frmlytSch);

		srhClutSeptCd = new ComboBox<BaseModel>();
		srhClutSeptCd.setName("srhclutSeptCd");
		srhClutSeptCd.setForceSelection(true);
		srhClutSeptCd.setMinChars(1);
		srhClutSeptCd.setDisplayField("commCdNm");
		srhClutSeptCd.setValueField("commCd");
		srhClutSeptCd.setTriggerAction(TriggerAction.ALL);
		srhClutSeptCd.setEmptyText("--정산구분선택--");
		srhClutSeptCd.setSelectOnFocus(true);
		srhClutSeptCd.setReadOnly(true);
		srhClutSeptCd.setEnabled(true);
		srhClutSeptCd.setStore(lsclutSeptCd);
		srhClutSeptCd.setFieldLabel("정산구분");
		srhClutSeptCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				YetaUtils.setSelectedComboValue(srhClutSeptCd, clutSeptCd.getValue(), "commCd");
				
				reload(); 
			}
		});
		lcSchCol02.add(srhClutSeptCd, new FormData("100%"));

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

		cpYeta23004.add(fieldSet);
			// vp.add(panel);
		
		}  
	 	 
			
   	
	@Override
	public void bind(final ModelData model) {
		formBinding.bind(model);
		formBinding.addListener(Events.Bind, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				
				srhDeptCd.setValue(deptNm.getValue());
				srhHanNm.setValue(hanNm.getValue());

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

		topBtnYe162520Bar = new ButtonBar();
		topBtnYe162520Bar.setAlignment(HorizontalAlignment.RIGHT);

		btnYe162520New = new Button("신규");
		btnYe162520New.setIcon(MSFMainApp.ICONS.new16());
		btnYe162520New.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {

				if (MSFSharedUtils.paramNull(systemkey.getValue())) {
					return;
				}
					 
				YetaP43004GridPanel01.getMsfGrid().clearData();

				BaseModel bmData = YetaP43004GridPanel01.getTableDef().getDefaultValues();
			              
			    bmData.set("dpobCd"					, dpobCd.getValue()); 							/** column 사업장코드 : dpobCd */
			    bmData.set("systemkey"				, systemkey.getValue()); 						/** column SYSTEMKEY : systemkey */
			    bmData.set("yrtxBlggYr"				, yrtxBlggYr.getValue());						/** column 연말정산귀속년도 : yrtxBlggYr */
			    bmData.set("clutSeptCd"				, clutSeptCd.getValue());						/** column 정산구분코드 : clutSeptCd */
			    bmData.set("taxVvalKrnCd"			, "Y0140001");   								/** column 국세청자료구분코드 : taxVvalKrnCd */
			    bmData.set("taxVvalKrnNm"			, "기타자료");   									/** column 국세청자료구분코드 : taxVvalKrnCd */
			    
			    bmData.set("comrCalnSeilNum"		, 0L);   										/** column 금전소비대차일련번호 : comrCalnSeilNum */
			    bmData.set("comrCdtrNm"				, "");    										/** column G16_금전소비대차_대주성명 : comrCdtrNm */
			    bmData.set("comrCdtrResnRegnNum"	, "");   										/** column G17_금전소비대차_대주주민등록번호 : comrCdtrResnRegnNum */
			    bmData.set("comrCnttPridBgnnDt"		, GWTUtils.getDateFromString("", "yyyyMMdd"));	/** column G18_금전소비대차_계약기간시작일자 : comrCnttPridBgnnDt */
			    bmData.set("comrCnttPridEndDt"		, GWTUtils.getDateFromString("", "yyyyMMdd")); 	/** column G19_금전소비대차_계약기간종료일자 : comrCnttPridEndDt */
			    bmData.set("comrLoanItrtRate"		, 0.0);    										/** column G20_금전소비대차_차입금이자율 : comrLoanItrtRate */
			    bmData.set("comrPclttAmtftAggr"		, 0L);    										/** column G21_금전소비대차_원리금상환액합계 : comrPclttAmtftAggr */
			    bmData.set("comrPrnilSum"			, 0L);   										/** column G22_금전소비대차_원금금액 : comrPrnilSum */
			    bmData.set("comrItrtSum"			, 0L);    										/** column G23_금전소비대차_이자금액 : comrItrtSum */
			    bmData.set("comrDducSum"			, 0L);    										/** column G24_금전소비대차_공제금액 : comrDducSum */
//			    bmData.set("ectnFlTrnrCtlYn"		, false);    									/** column 전자파일이관여부 : ectnFlTrnrCtlYn */			    
			    
			    YetaP43004GridPanel01.getMsfGrid().getGrid().stopEditing();      
			    YetaP43004GridPanel01.getMsfGrid().getGrid().getStore().insert(bmData,0);   
			    YetaP43004GridPanel01.getMsfGrid().getGrid().startEditing(YetaP43004GridPanel01.getMsfGrid().getGrid().getStore().indexOf(bmData), 0);   
			         
			    actionDatabase = ActionDatabase.INSERT;
			    
			}
		});

		topBtnYe162520Bar.add(btnYe162520New);

		btnYe162520Del = new Button("삭제");
		btnYe162520Del.setIcon(MSFMainApp.ICONS.save16());
		btnYe162520Del.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				MessageBox.confirm("삭제", "선택하신 금전소비대차계약 내용을 삭제하시겠습니까?",new Listener<MessageBoxEvent>(){
					
					@Override
					public void handleEvent(MessageBoxEvent be) {
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							
							Iterator<BaseModel> itBm  = YetaP43004GridPanel01.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
				            List<Record>  lsRec  = new ArrayList<Record>();
				                
				            actionDatabase = ActionDatabase.DELETE;
							while (itBm.hasNext()) {
								Record rec = new Record(itBm.next());
								lsRec.add(rec);
							}
							setListRecord(lsRec.iterator());
							doAction(actionDatabase, "YE162520");
							
						}
					}
				});
				
			}
		});
	                
		topBtnYe162520Bar.add(btnYe162520Del);

		btnYe162520Save = new Button("저장");
		btnYe162520Save.setIcon(MSFMainApp.ICONS.save16());
		btnYe162520Save.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				setListRecord(YetaP43004GridPanel01.getMsfGrid().getStore().getModifiedRecords().iterator());

				if ((ActionDatabase.INSERT).equals(actionDatabase)) {
					actionDatabase = ActionDatabase.INSERT;
				} else {
					actionDatabase = ActionDatabase.UPDATE;
				}

				doAction(actionDatabase, "YE162520");
			}
		});
		topBtnYe162520Bar.add(btnYe162520Save);
				
				
		cpYeta23004.add(topBtnYe162520Bar);

		FieldSet gridFieldSet = new FieldSet();
		gridFieldSet.setHeadingHtml("금전소비대차계약");
		gridFieldSet.setBorders(true);

		YetaP43004GridPanel01 = new MSFGridPanel(YetaP43004ToYeta3120Def,false, false, false, false, false);
		YetaP43004GridPanel01.setSize("790px", "190px");
		YetaP43004GridPanel01.setBorders(false);
		YetaP43004GridPanel01.setHeaderVisible(false);
		YetaP43004GridPanel01.getBottomComponent().setVisible(true);
		
			
			
		/** --- 그리드 합계 부분  시작 --- **/
		AggregationRowConfig<BaseModel> payrSummaryRow = new AggregationRowConfig<BaseModel>();  
			
//		payrSummaryRow.setHtml(Ye162520BM.ATTR_CNCLNAME, "합 계"); 
		payrSummaryRow.setHtml(Ye162520BM.ATTR_COMRCDTRNM, "합 계"); 
			 
//		payrSummaryRow.setCellStyle(Ye162520BM.ATTR_CNCLITRO,"summary_color");	/** set 금전소비대차_차입금이자율 : cnclItro */
		payrSummaryRow.setCellStyle(Ye162520BM.ATTR_COMRPCLTTAMTFTAGGR,"summary_color");/** column G21_금전소비대차_원리금상환액합계 : comrPclttAmtftAggr */
		payrSummaryRow.setCellStyle(Ye162520BM.ATTR_COMRPRNILSUM,"summary_color");		/** column G22_금전소비대차_원금금액 : comrPrnilSum */
		payrSummaryRow.setCellStyle(Ye162520BM.ATTR_COMRITRTSUM,"summary_color");		/** column G23_금전소비대차_이자금액 : comrItrtSum */
							    
//		payrSummaryRow.setSummaryType(Ye162520BM.ATTR_CNCLITRO, SummaryType.SUM);   
//		payrSummaryRow.setSummaryFormat(Ye162520BM.ATTR_CNCLITRO, NumberFormat.getFormat("#,##0;(#,##0)"));  
								    
		payrSummaryRow.setSummaryType(Ye162520BM.ATTR_COMRPCLTTAMTFTAGGR, SummaryType.SUM);   
		payrSummaryRow.setSummaryFormat(Ye162520BM.ATTR_COMRPCLTTAMTFTAGGR, NumberFormat.getFormat("#,##0;(#,##0)"));  
		
		payrSummaryRow.setSummaryType(Ye162520BM.ATTR_COMRPRNILSUM, SummaryType.SUM);   
		payrSummaryRow.setSummaryFormat(Ye162520BM.ATTR_COMRPRNILSUM, NumberFormat.getFormat("#,##0;(#,##0)"));  
		
		payrSummaryRow.setSummaryType(Ye162520BM.ATTR_COMRITRTSUM, SummaryType.SUM);   
		payrSummaryRow.setSummaryFormat(Ye162520BM.ATTR_COMRITRTSUM, NumberFormat.getFormat("#,##0;(#,##0)"));  
			
		YetaP43004GridPanel01.getGrid().getColumnModel().addAggregationRow(payrSummaryRow);  
		/** --- 그리드 합계 부분  종료 --- **/
			
		gridFieldSet.add(YetaP43004GridPanel01);
		cpYeta23004.add(gridFieldSet);
	}
		
		
	private void createMsfGridForm2() {

		topBtnYe162530Bar = new ButtonBar();
		topBtnYe162530Bar.setAlignment(HorizontalAlignment.RIGHT);

		btnYe162530New = new Button("신규");
		btnYe162530New.setIcon(MSFMainApp.ICONS.new16());
		btnYe162530New.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {

				if (MSFSharedUtils.paramNull(systemkey.getValue())) {
					return;
				}
					 
				yetaP13004GridPanel02.getMsfGrid().clearData();
					 
				BaseModel bmData = yetaP13004GridPanel02.getTableDef().getDefaultValues();  
			              
				bmData.set("dpobCd"					, dpobCd.getValue()); 							/** column 사업장코드 : dpobCd */
			    bmData.set("systemkey"				, systemkey.getValue()); 						/** column SYSTEMKEY : systemkey */
			    bmData.set("yrtxBlggYr"				, yrtxBlggYr.getValue());						/** column 연말정산귀속년도 : yrtxBlggYr */
			    bmData.set("clutSeptCd"				, clutSeptCd.getValue());						/** column 정산구분코드 : clutSeptCd */
			    bmData.set("taxVvalKrnCd"			, "Y0140001");   								/** column 국세청자료구분코드 : taxVvalKrnCd */
			    bmData.set("taxVvalKrnNm"			, "기타자료");   									/** column 국세청자료구분코드 : taxVvalKrnCd */
			    
			    bmData.set("rntlCttSeilNum"			, 0L);    										/** column 임대차계약 일련번호 : rntlCttSeilNum */
			    bmData.set("rntlCttLehdrNm"			, "");    										/** column G25_임대차계약_임대인성명_상호명 : rntlCttLehdrNm */
			    bmData.set("rntlCttBusoprRgstnum"	, "");   										/** column G26_임대차계약_주민_사업자등록번호 : rntlCttBusoprRgstnum */
			    bmData.set("rntlCttHusFrmCd"		, "");    										/** column G27_임대차계약_주택유형코드 : rntlCttHusFrmCd */
			    bmData.set("rntlCttHusCnttArea"		, 0L);   										/** column G28_임대차계약_주택계약면적 : rntlCttHusCnttArea */
			    bmData.set("rntlCttAddr"			, "");   										/** column G29_임대차계약_임대차계약서상주소지 : rntlCttAddr */
			    bmData.set("rntlCttPridBgnnDt"		, GWTUtils.getDateFromString("", "yyyyMMdd"));	/** column G30_임대차계약_임대차계약기간시작일자 : rntlCttPridBgnnDt */
			    bmData.set("rntlCttPridEndDt" 		, GWTUtils.getDateFromString("", "yyyyMMdd"));	/** column G31_임대차계약_임대차계약기간종료일자 : rntlCttPridEndDt */
			    bmData.set("rntlCttChrtrGrnteSum"	, 0L);   										/** column G32_임대차계약_전세보증금액 : rntlCttChrtrGrnteSum */
//			    bmData.set("ectnFlTrnrCtlYn"		, false);    									/** column 전자파일이관여부 : ectnFlTrnrCtlYn */			    
			    
			    yetaP13004GridPanel02.getMsfGrid().getGrid().stopEditing();      
			    yetaP13004GridPanel02.getMsfGrid().getGrid().getStore().insert(bmData,0);   
			    yetaP13004GridPanel02.getMsfGrid().getGrid().startEditing(yetaP13004GridPanel02.getMsfGrid().getGrid().getStore().indexOf(bmData), 0);   
			         
				actionDatabase = ActionDatabase.INSERT;
			}
		});
		topBtnYe162530Bar.add(btnYe162530New);

		btnYe162530Del = new Button("삭제");
		btnYe162530Del.setIcon(MSFMainApp.ICONS.save16());
		btnYe162530Del.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				MessageBox.confirm("삭제", "선택하신 임대차계약 내용을 삭제하시겠습니까?",new Listener<MessageBoxEvent>(){
					
					@Override
					public void handleEvent(MessageBoxEvent be) {
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							
							Iterator<BaseModel> itBm  = yetaP13004GridPanel02.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
							List<Record> lsRec = new ArrayList<Record>();

							actionDatabase = ActionDatabase.DELETE;
							while (itBm.hasNext()) {
								Record rec = new Record(itBm.next());
								lsRec.add(rec);
							}
							setListRecord(lsRec.iterator());

							doAction(actionDatabase, "YE162530");
							
						}
					}
				});
			}
		});
		topBtnYe162530Bar.add(btnYe162530Del);

		btnYe162530Save = new Button("저장");
		btnYe162530Save.setIcon(MSFMainApp.ICONS.save16());
		btnYe162530Save.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				setListRecord(yetaP13004GridPanel02.getMsfGrid().getStore().getModifiedRecords().iterator());

				if ((ActionDatabase.INSERT).equals(actionDatabase)) {
					actionDatabase = ActionDatabase.INSERT;
				} else {
					actionDatabase = ActionDatabase.UPDATE;
				}

				doAction(actionDatabase, "YE162530");
			}
		});

		topBtnYe162530Bar.add(btnYe162530Save);

		cpYeta23004.add(topBtnYe162530Bar);

		FieldSet gridFieldSet = new FieldSet();
		gridFieldSet.setHeadingHtml("임대차계약");
		gridFieldSet.setBorders(true);

		yetaP13004GridPanel02 = new MSFGridPanel(yetaP13004ToYeta3160Def, false, false, false, false, false);
		yetaP13004GridPanel02.setSize("790px", "200px");
		yetaP13004GridPanel02.setBorders(false);
		yetaP13004GridPanel02.setHeaderVisible(false);  
		yetaP13004GridPanel02.getBottomComponent().setVisible(true);
			
			
		/** --- 그리드 합계 부분  시작 --- **/
		AggregationRowConfig<BaseModel> payrSummaryRow = new AggregationRowConfig<BaseModel>();  
			
		payrSummaryRow.setHtml(Ye162530BM.ATTR_RNTLCTTLEHDRNM, "합 계"); 
		 
		payrSummaryRow.setCellStyle(Ye162530BM.ATTR_RNTLCTTCHRTRGRNTESUM,"summary_color");	 /** column G32_임대차계약_전세보증금액 : rntlCttChrtrGrnteSum */
		payrSummaryRow.setSummaryType(Ye162530BM.ATTR_RNTLCTTCHRTRGRNTESUM, SummaryType.SUM);   
		payrSummaryRow.setSummaryFormat(Ye162530BM.ATTR_RNTLCTTCHRTRGRNTESUM, NumberFormat.getFormat("#,##0;(#,##0)"));  
								    
			
		yetaP13004GridPanel02.getGrid().getColumnModel().addAggregationRow(payrSummaryRow);  
		/** --- 그리드 합계 부분  종료 --- **/			
			
		gridFieldSet.add(yetaP13004GridPanel02);
		cpYeta23004.add(gridFieldSet);
		
	}

	public void setListRecord(Iterator<Record> records) {
		this.records = records;
	}

	@Override
	public void reload() {

		reloadYeta3120();
		reloadYeta3160();
	}
		
	public void reloadYeta3120() {
			
		IColumnFilter filters = null;
			
		YetaP43004GridPanel01.getTableDef().setTableColumnFilters(filters);
		YetaP43004GridPanel01.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.allowNulls(srhYrtxBlggYr.getValue())
				, SimpleColumnFilter.OPERATOR_EQUALS);//연말정산귀속년도 
		YetaP43004GridPanel01.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.getSelectedComboValue(srhClutSeptCd,"commCd")
				, SimpleColumnFilter.OPERATOR_EQUALS);//정산구분
		YetaP43004GridPanel01.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue())
				, SimpleColumnFilter.OPERATOR_EQUALS);//시스템키
		 
		YetaP43004GridPanel01.reload();
	}
	
	public void reloadYeta3160() {
		
		// TODO Auto-generated method stub
		IColumnFilter filters = null;
		
		yetaP13004GridPanel02.getTableDef().setTableColumnFilters(filters);
		yetaP13004GridPanel02.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.allowNulls(srhYrtxBlggYr.getValue())
				, SimpleColumnFilter.OPERATOR_EQUALS);//연말정산귀속년도 
//		yetaP13001GridPanel.getTableDef().addColumnFilter("yrtxBlggYr", MSFSharedUtils.getSelectedComboValue(srhyrtxBlggYr, "year")
//				, SimpleColumnFilter.OPERATOR_EQUALS);//연말정산귀속년도
		yetaP13004GridPanel02.getTableDef().addColumnFilter("clutSeptCd", MSFSharedUtils.getSelectedComboValue(srhClutSeptCd,"commCd")
				, SimpleColumnFilter.OPERATOR_EQUALS);//정산구분
		yetaP13004GridPanel02.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue())
				, SimpleColumnFilter.OPERATOR_EQUALS);//시스템키
	 
		yetaP13004GridPanel02.reload();
	}
	
		
		
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
