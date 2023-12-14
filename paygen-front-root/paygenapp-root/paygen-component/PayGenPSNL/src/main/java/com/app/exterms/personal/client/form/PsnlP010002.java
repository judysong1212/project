/**
 * 신규고용일괄등록
 */
package com.app.exterms.personal.client.form;
  

import java.util.HashMap;

import com.app.exterms.personal.client.dto.Psnl010002DTO;
import com.app.exterms.personal.client.dto.Psnl0100DTO;
import com.app.exterms.personal.client.dto.Psnl0110DTO;
import com.app.exterms.personal.client.service.PsnlP010002Service;
import com.app.exterms.personal.client.service.PsnlP010002ServiceAsync;
import com.app.exterms.personal.client.utils.PersonalUtil;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.form.ShowMessageForm;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormWindows;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.utils.PrintUtils;
import com.app.smrmf.core.msfmainapp.client.utils.RegEx;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.MSFComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFDateField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTextField;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldWithButton;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.app.smrmf.syscom.client.util.SysComPopupUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.CheckBoxGroup;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.Validator;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Image;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public  class PsnlP010002   extends MSFFormPanel {  

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
 
//	private  FormPanel cpPsnl0100; 
	private  ContentPanel cpPsnl0100; 

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
  
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * Button 변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 검색변수 선언 
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
      
      
      
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 입력 변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
 		
	private HiddenField<String> formId;
	private HiddenField<String> systemkey;
	
	
 	// --	기 본	-- >	
	private Image picImg; 							// 사진 이미지
	private FileUploadField picFile; 				// 사진이미지 파일업로드

	private Button btnMangeDeptCd; 					// 관리부서 팝업 버튼
	private Button btnCurrAffnDeptCd; 				// 소속부서 팝업 버튼

	private TextField<String> mangeDeptCd; 			// 관리부서코드
	private TextField<String> mangeDeptNm; 			// 관리부서명

	private MSFTextField currAffnDeptCd; 		// 소속부서코드
	private MSFTextField currAffnDeptNm; 		// 소속부서명

	private MSFTextField hanNm; 				// 한글 이름
	private MSFTextField resnRegnNum; 			// 주민등록번호
	private HiddenField<String> resnRegnNumStr;

	private TextField<String> engNm; 				// 영문이름
	private TextField<String> chinCharNm; 			// 한자이름

	// private static ComboBox<BaseModel> typOccuCd; // 직종코드
	// private static ComboBox<BaseModel> dtilOccuInttnCd; // 직종세 구분

	private TextField<String> repbtyBusinNm; 		// 담당업무
	private ComboBox<BaseModel> repbtyBusinDivCd; 	// 호봉제 구분

	private TextFieldWithButton<String> natnNm; 	// 국가코드
	private TextField<String> natnItem; 			// 국가코드 두자리
	private HiddenField<String> natnCd; 			// 국가코드 키

	private MSFComboBox<BaseModel> hdofcCodtnCd;	 	// 재직 구분
	private ComboBox<BaseModel> pyspCd; 			// 호봉
	private CheckBox unnMbspSttYn; 					// 노조가입여부
 		
	//이미지 업로드를 위해 추가 
	private HiddenField<String> imgKeyCode;
	private HiddenField<String> frmKey;
	
	private Boolean picBoolFile;
	// 	<--  기본		--
	
	
 	// --	인 적	-- >
	private static MSFTextField husRoadNmZpcd; 				// 도로명 주소 우편번호
//	private static TextField<String> psnl0111HusRoadNmZpcd; 		// 도로명 주소 우편번호
	private static MSFTextField husRoadNmFndtnAddr; 		// 도로명 주소 기본주소
//	private static TextField<String> psnl0111HusRoadNmFndtnAddr; 	// 도로명 기본주소
//	private static TextField<String> psnl0111HusRoadNmDtlPatrAddr; 	// 도로명 상세 주소
	private static TextField<String> husRoadNmDtlPatrAddr; 	// 도로명 상세 주소
	
	
	private TextField<String> psnl0111HusZpcd;						// 생활 근거지 우편
	private TextField<String> psnl0111BthcAddr;						// 생활 근거지 주소
	private TextField<String> psnl0111HfmlyNm; 						// 호주
	private ComboBox<BaseModel> psnl0111HfmlyRelaCd; 				// 호주관계
	
	private MSFTextField psnl0111CellPhneNum; 					// 휴대폰번호
	private TextField<String> psnl0111HusPhnNum; 					// 전화번호
	private TextField<String> psnl0111EmailAddr; 					// 이메일
	
	private DateField styBgnnDt;									// 체류시작일자
	private DateField styEndDt;										// 체류종료일자
	private ComboBox<BaseModel> frgnrDivCd;							// 외국인구분코드
	private TextField<String> psptNum;								// 여권번호
	
	private TextArea pernNoteCtnt; 									// 비고

	// 	<--  인 적	--
	
	
 	// --	고 용	-- >
	
	private HiddenField<String> emymtSeilNum;			// 고용일련번호
	
	private LayoutContainer lcStd3Right02_01 = new LayoutContainer(new ColumnLayout());
	private LayoutContainer lcStd3Right02_02 = new LayoutContainer();
	
	private MSFComboBox<BaseModel> emymtDivCd;				// 고용구분
	private MSFComboBox<BaseModel> emymtTypCd;				// 고용유형
	private MSFDateField emymtBgnnDt;						// 시작일자
	private MSFDateField emymtEndDt;						// 종료일자
	private Button btnDeptCd; 							// 부서 팝업 버튼
	private MSFTextField deptCd; 					// 부서 코드
	private MSFTextField deptNm; 					// 부서 명
	private TextField<String> currPaeWorkNm;			// 현근무지
	private MSFComboBox<BaseModel> typOccuCd;				// 직종
	private MSFComboBox<BaseModel> dtilOccuInttnCd;		// 직종세
	private MSFComboBox<BaseModel> businCd;				// 사업
	private ComboBox<BaseModel> odtyCd;					// 직책
	private ComboBox<BaseModel> retryDivCd;				// 퇴직사유구분
	private TextField<String> retryReasCtnt;			// 퇴직사유내용
	private TextField<String> emymtReasCtnt;			// 비고
	// 	<--  고 용	--
	
	
	
	// 	<--  병 역	--
	private DateField psnl0112EnrlntDt;						// 입대일자
	private DateField psnl0112DsageDt;						// 제대일자
	private ComboBox<BaseModel> psnl0112ServcRcgtnPridCd;	// 복무인정기간
	private ComboBox<BaseModel> psnl0112SrvssCd;			// 역종
	private ComboBox<BaseModel> psnl0112BaggrpCd;			// 군별
	private ComboBox<BaseModel> psnl0112AbotsCd;			// 병과
	private ComboBox<BaseModel> psnl0112ClsCd;				// 계급
	private TextField<String> psnl0112MitySilnum;			// 군번
	private TextField<String> psnl0112Mos;					// mos
	private ComboBox<BaseModel> psnl0112DsageDivCd;			// 제대구분
	private ComboBox<BaseModel> psnl0112ExmtnReasCd;		// 미필사유
 	// --	병 역	-- >	
	
	
 	// --	신 상	-- >
	private TextField<String> psnl0113Sttur;				// 신장
	private TextField<String> psnl0113Wei;					// 체중
	private ComboBox<BaseModel> psnl0113BldtpDivCd;			// 혈액형 콤보
	private RadioGroup psnl0113PrmtsaYn;					// 색맹(radio)
	private TextField<String> psnl0113TnkeeVsnLf;			// 나안시력 좌
	private TextField<String> psnl0113TnkeeVsnRght;			// 나인시력 우
	private TextField<String> psnl0113CorrVsnLf;			// 교정시력 좌
	private TextField<String> psnl0113CorrVsnRght;			// 교정시력 우
	private ComboBox<BaseModel> psnl0113RelnFrmCd;			// 종교 콤보
	private TextField<String> psnl0113HbbyCtnt;				// 취미
	private TextField<String> psnl0113SpityCtnt;			// 특기
	private TextField<String> psnl0113HlthCodtnCtnt;		// 건강상태
	private MSFComboBox<BaseModel> psnl0113DabtyDivCd;			// 장애구분
	private ComboBox<BaseModel> psnl0113DabtyGrdeCd;		// 장애등급
	private DateField psnl0113DabtyAjmtDt;					// 장애판정일자
	private ComboBox<BaseModel> psnl0113PattVetnsDivCd;		// 보훈구분
	private TextField<String> psnl0113PattVetnsNum;			// 보훈번호
	private ComboBox<BaseModel> psnl0113AmomRelaDivCd;		// 유공자와관계
	private CheckBoxGroup psnl0113PattVetnsYn;				// 보훈여부 (checkbox)
	private MSFComboBox<BaseModel> sxDivCd;					// 성별
	private MSFDateField yoobhMnthDay;							// 생년월일
	private String strYoobhMnthDay = ""; 					// 생년월일 가져오는
	
	private RadioGroup sclcDivCd;							// 음양구분
	private Radio birLun;									// 음력
	private Radio birSol;									// 양력
	// 	<--  신 상	--
	
	
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
 
	    private PsnlP010002ServiceAsync psnlP010002Service = PsnlP010002Service.Util.getInstance();
	    
	    private ListStore<BaseModel> listStoreA003 		= new ListStore<BaseModel>();	// 재직구분
	    private ListStore<BaseModel> listStoreA005 		= new ListStore<BaseModel>();	// 호봉
		private ListStore<BaseModel> listStoreA048 		= new ListStore<BaseModel>();   // 호봉제
		
		private ListStore<BaseModel> listStoreI004 		= new ListStore<BaseModel>(); 	// 외국인구분 
		private ListStore<BaseModel> listStoreA019 		= new ListStore<BaseModel>();	// 관계
		
		private ListStore<BaseModel> listStoreA029 		= new ListStore<BaseModel>(); 	// 복무인정기간	
		private ListStore<BaseModel> listStoreA022 		= new ListStore<BaseModel>(); 	// 역종
		private ListStore<BaseModel> listStoreA023 		= new ListStore<BaseModel>(); 	// 군별
		private ListStore<BaseModel> listStoreA024 		= new ListStore<BaseModel>(); 	// 병과	
		private ListStore<BaseModel> listStoreA045 		= new ListStore<BaseModel>(); 	// 계급 	
		private ListStore<BaseModel> listStoreA025 		= new ListStore<BaseModel>(); 	// 제대구분
		private ListStore<BaseModel> listStoreA021 		= new ListStore<BaseModel>(); 	// 미필사유
		
		private ListStore<BaseModel> listStoreA013 		= new ListStore<BaseModel>(); 	// 혈액형
		private ListStore<BaseModel> listStoreA020 		= new ListStore<BaseModel>(); 	// 종교
		private ListStore<BaseModel> listStoreA036 		= new ListStore<BaseModel>(); 	// 장애등급
		private ListStore<BaseModel> listStoreA047 		= new ListStore<BaseModel>(); 	// 장애여부
		private ListStore<BaseModel> listStoreA037 		= new ListStore<BaseModel>(); 	// 장애유형	
		
		private ListStore<BaseModel> listStoreA002 		= new ListStore<BaseModel>(); 	// 고용구분
		private ListStore<BaseModel> listStoreA042 		= new ListStore<BaseModel>(); 	// 고용유형
		private ListStore<BaseModel> listStoreA041 		= new ListStore<BaseModel>(); 	// 직종
		private ListStore<BaseModel> listStoreBass0350 	= new ListStore<BaseModel>(); 	// 직종세
		private ListStore<BaseModel> lsBusinCd 			= new ListStore<BaseModel>();	// 부서
		private ListStore<BaseModel> listStoreA015 		= new ListStore<BaseModel>(); 	// 직책
		private ListStore<BaseModel> listStoreA050 		= new ListStore<BaseModel>(); 	// 퇴직사유구분
		
	    
  		private PrgmComBass0300DTO sysComBass0300Dto; // 공통코드  
  		private PrgmComBass0320DTO sysComBass0320Dto; // 직종코드  
  		private PrgmComBass0350DTO sysComBass0350Dto; // 직종세코드  
  		private PrgmComBass0500DTO sysComBass0500Dto; // 부서코드
  		
  		private SysCoCalendarDTO msfCoCalendarDto;   
  		
  		private Psnl0100DTO psnl0100Dto;
  		private Psnl0110DTO psnl0110Dto;
  		private Psnl010002DTO psnl010002Dto;
  		
	    
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
  		
  		
	private void doAction(ActionDatabase actionDatabase) {

		switch (actionDatabase) {
		case INSERT:
			this.actionDatabase = ActionDatabase.INSERT;
//			savePsnlAll();
			
			psnl0100Dto = new Psnl0100DTO();
			psnl0100Dto.setResnRegnNum(resnRegnNum.getValue());
			
			// 주민번호 체크 후 있으면 저장 로직 태우고 없으면 태우지 않는다.
			psnlP010002Service.psnl0100Check(psnl0100Dto, new AsyncCallback<Long>() {
				
				@Override
				public void onSuccess(Long result) {
					
					if(result > 0) {
						
						MessageBox.alert("알림", "현재 입력된 주민등록번호는 이미 등록된 근로자 입니다. ", null);
						
					}else {
						// 데이터 저장 시작
						savePsnlAll();
					}
				}
				
				
				@Override
				public void onFailure(Throwable caught) {
					
					caught.printStackTrace();
					MessageBox.alert("오류", "근로자 등록 확인 중 오류가 발생하였습니다. </br> 관리자에게 문의해 주세요. + " + caught, null);
				}
			});
			
			break;
		case UPDATE:
			this.actionDatabase = ActionDatabase.UPDATE;
			savePsnlAll();
			
			// 주민번호 수정할 경우 해당 주민번호가 이미 등록된 주민등록번호 있지 확인
			if(!(resnRegnNumStr.getValue().replaceAll("-", "")).equals(resnRegnNum.getValue().replaceAll("-", ""))) {
				
				psnl0100Dto = new Psnl0100DTO();
				psnl0100Dto.setResnRegnNum(resnRegnNum.getValue().replaceAll("-", ""));
				
				
				// 주민번호 체크 후 있으면 저장 로직 태우고 없으면 태우지 않는다.
				psnlP010002Service.psnl0100Check(psnl0100Dto, new AsyncCallback<Long>() {
					
					@Override
					public void onSuccess(Long result) {
						
						if(result > 0) {
							
							MessageBox.alert("알림", "현재 수정하고자하는 주민등록번호는 이미 등록된 근로자 입니다. ", null);
							
						}else {
							// 데이터 저장 시작
							savePsnlAll();
						}
					}
					
					
					@Override
					public void onFailure(Throwable caught) {
						
						caught.printStackTrace();
						MessageBox.alert("오류", "근로자 등록 확인 중 오류가 발생하였습니다. </br> 관리자에게 문의해 주세요. + " + caught, null);
					}
				});
				
			}else {
				// 데이터 저장 시작
				savePsnlAll();
			}
			
			break;
//		case DELETE:
//			this.actionDatabase = ActionDatabase.DELETE;
//			savePsnl0100();
//			break;
		}

	}
 
	/**
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 	Rpc Service 선언부 종료
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 **/
	/**
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 	print Service 선언부 시작
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 **/

	/**
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 	print Service 선언부 시작
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 **/
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
  		 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
  		 * 	file upload  선언부 시작
  		 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
  		 **/
  	 
//  	  FlowPanel panelImages = new FlowPanel();
//  	  OnLoadPreloadedImageHandler showImage = new OnLoadPreloadedImageHandler() {
//  	    public void onLoad(PreloadedImage img) {
//  	      img.setWidth("75px");
//  	      panelImages.add(img);
//  	    }
//  	  };
//
//  	  protected UploaderConstants i18nStrs;;
//
//  	  private IUploader.OnFinishUploaderHandler onFinishUploaderHandler = new IUploader.OnFinishUploaderHandler() {
//  	    public void onFinish(IUploader uploader) {
//  	      if (uploader.getStatus() == Status.SUCCESS) {
//  	        for (String url : uploader.getServerMessage().getUploadedFileUrls()) {
//  	          new PreloadedImage(url, showImage);
//  	        }
//  	      }
//  	    }
//  	  };
		/**
		 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
		 * 	file upload  선언부 닫기
		 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
		 **/  
	
	
	/**************************************************************/
	/** 우편번호 로직 추가    												*/
	/**************************************************************/		  
	  public static native void closeFunction() /*-{
			   $wnd.closeFunction =
			      $entry(@com.app.exterms.personal.client.form.PsnlP010002::onCloseGwtFunction(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;));
	  }-*/;
	 public static void onCloseGwtFunction(String zpcd,String fnDtnAddr,String dtlPatrAddr )
	  { 
		  // your gwt code tobe executed 
		// Window.alert(postId);
		 husRoadNmZpcd.setValue(MSFSharedUtils.allowNulls(zpcd));
		// husRoadNmZpcd.fireEvent(Events.Add);
		 husRoadNmFndtnAddr.setValue(MSFSharedUtils.allowNulls(fnDtnAddr)); // 앞주소
		 husRoadNmDtlPatrAddr.setValue(MSFSharedUtils.allowNulls(dtlPatrAddr)); // 뒷주소
		    
	  }
	 /**************************************************************/
	 /** 우편번호 로직 추가    												*/
	 /**************************************************************/	
	
	
	/**
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 생성자 함수 선언부 시작
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
	 **/ 		    
	public PsnlP010002(final ActionDatabase ad, final MSFPanel caller) {
		
		GWTUtils.popupDoroWndClose(); 
		closeFunction();
		    
 
		this.setFrame(false);
		this.setBodyBorder(false);
		this.setBorders(false);
		this.setHeaderVisible(false);
		// FormLayout layout = new FormLayout();
		// layout.setDefaultWidth(600);
		// layout.setLabelWidth(0);
		// this.setLayout(layout);
		this.setAutoHeight(true);
		this.actionDatabase = ad;
		this.caller = caller;

		cpPsnl0100 = new ContentPanel();
		
		
		createStandardForm(); 		

		cpPsnl0100.setBodyBorder(false);
		cpPsnl0100.setScrollMode(Scroll.AUTO);
		cpPsnl0100.setBorders(false);
		cpPsnl0100.setHeaderVisible(false);
//		cpPsnl0100.setSize("780px", "800px");
		cpPsnl0100.setSize("780px", "700px");
		// cpPsnl0100.add(single1);
		this.add(cpPsnl0100);
		formBinding = new FormBinding(this, true);

//		this.setSize("800px", "820px");
		this.setSize("800px", "720px");
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
	 
	private void createStandardForm() {
		
		sysComBass0300Dto = new PrgmComBass0300DTO();
  		sysComBass0320Dto = new PrgmComBass0320DTO();  
  		sysComBass0350Dto = new PrgmComBass0350DTO(); 
  		sysComBass0500Dto = new PrgmComBass0500DTO();
		
        //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
        sysComBass0300Dto.setRpsttvCd("A003");	
        listStoreA003 = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
        
        sysComBass0300Dto.setRpsttvCd("A005");	
        listStoreA005 = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
        
        sysComBass0300Dto.setRpsttvCd("A048");	
        listStoreA048 = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
        
        sysComBass0300Dto.setRpsttvCd("I004");	
        listStoreI004 = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
        
        sysComBass0300Dto.setRpsttvCd("A019");	
        listStoreA019 = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
        
        
        sysComBass0300Dto.setRpsttvCd("A029");	
        listStoreA029 = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
        
        sysComBass0300Dto.setRpsttvCd("A022");	
        listStoreA022 = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
        
        sysComBass0300Dto.setRpsttvCd("A023");	
        listStoreA023 = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
        
        sysComBass0300Dto.setRpsttvCd("A024");	
        listStoreA024 = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
        
        sysComBass0300Dto.setRpsttvCd("A045");	
        listStoreA045 = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
        
        sysComBass0300Dto.setRpsttvCd("A025");	
        listStoreA025 = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
        
        sysComBass0300Dto.setRpsttvCd("A021");	
        listStoreA021 = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
        
        
        
        sysComBass0300Dto.setRpsttvCd("A013");	
        listStoreA013 = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
        
        sysComBass0300Dto.setRpsttvCd("A020");	
        listStoreA020 = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
        
        sysComBass0300Dto.setRpsttvCd("A036");	
        listStoreA036 = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
        
        sysComBass0300Dto.setRpsttvCd("A047");	
        listStoreA047 = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
        
        sysComBass0300Dto.setRpsttvCd("A037");	
        listStoreA037 = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
        
        sysComBass0300Dto.setRpsttvCd("A002");	
    	sysComBass0300Dto.setCommUseYn("A");  	//조건을 넣으면 사용여부 구분처리를 한 후 보여줌 
        listStoreA002 = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
        sysComBass0300Dto.setCommUseYn("");  	//조건을 넣으면 사용여부 구분처리를 한 후 보여줌 
        
        sysComBass0300Dto.setRpsttvCd("A042");	
        listStoreA042 = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
        
		sysComBass0300Dto.setRpsttvCd("A015");	
		listStoreA015 = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
		
		sysComBass0300Dto.setRpsttvCd("A050");	
		listStoreA050 = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
        //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
        
		
		sysComBass0320Dto.setTypOccuUseYn("A");
		listStoreA041 =  PrgmComComboUtils.getSingleNonBass0320ComboData(sysComBass0320Dto);
		sysComBass0320Dto.setTypOccuUseYn("");
		
		sysComBass0350Dto.setDtilOccuClsUseYn("A");
		listStoreBass0350 = PrgmComComboUtils.getSingleNonBass0350ComboData(sysComBass0350Dto); 
		sysComBass0350Dto.setDtilOccuClsUseYn("");
		lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
		
		
		
		formId = new HiddenField<String>();
		formId.setName("formId");
		cpPsnl0100.add(formId);
		
		imgKeyCode = new HiddenField<String>();
		imgKeyCode.setName("imgKeyCode");
		cpPsnl0100.add(imgKeyCode);
		
        frmKey  = new HiddenField<String>();
        frmKey.setName("frmKey");
        cpPsnl0100.add(frmKey);
        
        
        systemkey  = new HiddenField<String>();
        systemkey.setName("systemkey");
        cpPsnl0100.add(systemkey);
        
        
        
        resnRegnNumStr  = new HiddenField<String>();
        resnRegnNumStr.setName("resnRegnNumStr");
        cpPsnl0100.add(resnRegnNumStr);
        
        
        emymtSeilNum  = new HiddenField<String>();
        emymtSeilNum.setName("emymtSeilNum");
        cpPsnl0100.add(emymtSeilNum);
        
        
		LayoutContainer layoutContainer111 = new LayoutContainer();

		FieldSet fieldSet1 = new FieldSet();
		fieldSet1.setHeadingHtml("기 본");
		
		
		LayoutContainer lcFieldSet1 = new LayoutContainer(new ColumnLayout());
		
		
		LayoutContainer lcImg = new LayoutContainer();
		lcImg.setStyleAttribute("paddingLeft", "5px");
		lcImg.setStyleAttribute("paddingRight", "5px");
		
		//picImg = new Image(GWT.getHostPageBaseURL()+MSFConfiguration.NON_EXTERM_PHOTO);
		picImg = new Image();
		picImg.setUrl(GWT.getHostPageBaseURL()+MSFMainApp.getMsg("PayGen.NonExTermPhoto"));
		picImg.setSize("125px", "125px");
		picImg.setVisible(true);
		picImg.setTitle("사진");
		
		lcImg.add(picImg, new FormData("100%"));
		
		
		// 파일업로드 처리
		picFile = new FileUploadField();
	    picFile.setName("picFile");
		picFile.setLabelSeparator("");
		picFile.setStyleAttribute("paddingLeft", "0px");
		picFile.addListener(Events.Change, new Listener<FieldEvent>() {
			public void handleEvent(FieldEvent e) {
				
			}
		});
		// file.setAllowBlank(false);
		lcImg.add(picFile, new FormData("90%"));

//		lcFieldSet1.add(lcImg, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		
		
		
		
		LayoutContainer lcInfo = new LayoutContainer(new ColumnLayout());
		
		
		LayoutContainer lcInfoLeft = new LayoutContainer();
		
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcInfoLeft.setLayout(frmlytStd);
		
		
		//관리부서 코드 처리  
	    LayoutContainer lccmMangeDeptNm = new LayoutContainer();
	    lccmMangeDeptNm.setLayout(new ColumnLayout());
	        
	    //부서 
	    mangeDeptCd = new TextField<String>();
 	    mangeDeptCd.setName("mangeDeptCd");
 	    mangeDeptCd.setVisible(false);
 	    cpPsnl0100.add(mangeDeptCd);	 
 	    
 	    
	    LayoutContainer lcMangeDeptNm = new LayoutContainer(); 
	    FormLayout frmlytSch = new FormLayout();
	    frmlytSch.setLabelWidth(100);
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);
	    lcMangeDeptNm.setLayout(frmlytSch);
	      
	    mangeDeptNm = new TextField<String>(); 
	    mangeDeptNm.setName("mangeDeptNm");
	    mangeDeptNm.setFieldLabel("관리부서");
	         //mangeDeptNm.setLabelSeparator("");
	    mangeDeptNm.addKeyListener(new KeyListener() {
	    	@Override
	    	public void componentKeyDown(ComponentEvent event) {
	    		
	    		if (MSFSharedUtils.allowNulls(mangeDeptNm.getValue()).trim().equals("")) {
    				mangeDeptCd.setValue("");
    				}
    	    	if (MSFSharedUtils.paramNull(MSFSharedUtils.allowNulls(mangeDeptNm.getValue()))) {
                	mangeDeptCd.setValue("");
                	}   
    			 
	    		if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
	    			//if (MSFSharedUtils.allowNulls(mangeDeptNm.getValue()).trim().equals("")) {
	    				mangeDeptCd.setValue("");
	    				//}
	    			fnPopupCommP150_Mange(mangeDeptNm.getValue());
	    			}
	    		super.componentKeyDown(event); 
	    		}
	    	});
	    lcMangeDeptNm.add(mangeDeptNm, new FormData("100%"));  
	         
	    btnMangeDeptCd = new Button();
	    btnMangeDeptCd.setIcon(MSFMainApp.ICONS.search()); 
	    btnMangeDeptCd.addListener(Events.Select, new Listener<ButtonEvent>() {
	    	public void handleEvent(ButtonEvent e) { 
	    		if (MSFSharedUtils.allowNulls(mangeDeptNm.getValue()).trim().equals("")) {
	    				mangeDeptCd.setValue("");
	    		}
	    		fnPopupCommP150_Mange(mangeDeptNm.getValue()); 
	    	}
	    });
	            
	           //lccmMangeDeptNm.add(lcMangeDeptCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.55));  
	    lccmMangeDeptNm.add(lcMangeDeptNm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.91));
	    lccmMangeDeptNm.add(btnMangeDeptCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));
	  
	    lcInfoLeft.add(lccmMangeDeptNm, new FormData("100%"));
	    
	    
	    LayoutContainer lc1 = new LayoutContainer(new ColumnLayout());
	    
	    LayoutContainer lcHanNm = new LayoutContainer();
	    
	    frmlytSch = new FormLayout();
	    frmlytSch.setLabelWidth(100);
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcHanNm.setLayout(frmlytSch);
		
		hanNm = new MSFTextField();
        hanNm.setFieldLabel("성명/주민번호");
	    lcHanNm.add(hanNm, new FormData("100%"));
	    
	    lc1.add(lcHanNm, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
	   
	    
	 
	    
	    LayoutContainer lcRegn = new LayoutContainer();
	    
	    frmlytSch = new FormLayout();
	    frmlytSch.setLabelWidth(0);
		lcRegn.setLayout(frmlytSch);
	    
		resnRegnNum = new MSFTextField();
	    resnRegnNum.setName("resnRegnNum");
	    new TextFieldMask<String>(resnRegnNum, "999999-9999999");  
	    resnRegnNum.setLabelSeparator("");
	    
        lcRegn.add(resnRegnNum, new FormData("100%"));
	    
	    lc1.add(lcRegn, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
	    
	    lcInfoLeft.add(lc1);
	    
	    
		repbtyBusinNm = new TextField<String>();
		repbtyBusinNm.setFieldLabel("담당업무");
//		repbtyBusinNm.setReadOnly(false);
//		repbtyBusinNm.setEnabled(false);
		lcInfoLeft.add(repbtyBusinNm, new FormData("100%"));
		
		
		
		
		LayoutContainer lucnNatn = new LayoutContainer(new ColumnLayout());
		
		natnCd = new HiddenField<String>();
//		natnCdKey.setName("pmdPernKey");
//		natnCdKey.setFieldLabel("pmdPernKey");
		natnCd.setName("natnCd");
        cpPsnl0100.add(natnCd);
		
		
		LayoutContainer lucnNatn1_1 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lucnNatn1_1.setLayout(frmlytSch);
		
		
		Button btnNatnCd = new Button();
		btnNatnCd.setIcon(MSFMainApp.ICONS.search());
		btnNatnCd.addListener(Events.Select, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent e) {
            	if (MSFSharedUtils.allowNulls(natnNm.getValue()).trim().equals("")) {
            		natnCd.setValue("");
                }
            	fnPopupBass0300("A001");
            }
        });
			
		
		natnNm = new TextFieldWithButton<String>(btnNatnCd);
		natnNm.setFieldLabel("국가코드");
		natnNm.addKeyListener(new KeyListener() {
			@Override
            public void componentKeyDown(ComponentEvent event) {
                
                natnCd.validate();
                if (MSFSharedUtils.allowNulls(natnNm.getValue()).trim().equals("")) {
                	natnCd.setValue("");
                }
                
                if (MSFSharedUtils.paramNull(natnNm.getValue())) {
                	natnCd.setValue("");
                }
                
                if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
                	//if (MSFSharedUtils.allowNulls(natnNm.getValue()).trim().equals("")) {
                		natnNm.setValue("");
                		natnItem.setValue("");
                    	//}
                	fnPopupBass0300("A001");
                }
                
                super.componentKeyDown(event);
                
			}
		});
		lucnNatn1_1.add(natnNm, new FormData("100%"));
		
		
		LayoutContainer lucnNatn1_2 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(0);
		lucnNatn1_2.setLayout(frmlytSch);
		
		natnItem = new TextField<String>();
		natnItem.setReadOnly(true);
		natnItem.setLabelSeparator("");
		
		lucnNatn1_2.add(natnItem, new FormData("100%"));
		
		lucnNatn.add(lucnNatn1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		lucnNatn.add(lucnNatn1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		lcInfoLeft.add(lucnNatn);
		
		
//		hdofcCodtnCd = new ComboBox<BaseModel>();
//		hdofcCodtnCd.setFieldLabel("재직구분");
//		hdofcCodtnCd.setForceSelection(true);
//		hdofcCodtnCd.setMinChars(1);
//		hdofcCodtnCd.setDisplayField("commCdNm");
//		hdofcCodtnCd.setValueField("commCd");
//		hdofcCodtnCd.setTriggerAction(TriggerAction.ALL);
//		hdofcCodtnCd.setEmptyText("--재직구분선택--");
//		hdofcCodtnCd.setSelectOnFocus(true);
//		hdofcCodtnCd.setStore(listStoreA003);
//		hdofcCodtnCd.setReadOnly(false);
//		hdofcCodtnCd.setEnabled(true);
//		lcInfoLeft.add(hdofcCodtnCd, new FormData("100%"));
		
		
		
		LayoutContainer layoutContainer22 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer layoutContainer_111 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_111.setLayout(frmlytSch);
		
		pyspCd = new ComboBox<BaseModel>();
		pyspCd.setFieldLabel("호 봉");
		pyspCd.setForceSelection(true);
		pyspCd.setMinChars(1);
		pyspCd.setDisplayField("commCdNm");
		pyspCd.setValueField("commCd");
		pyspCd.setTriggerAction(TriggerAction.ALL);
		pyspCd.setEmptyText("--호봉선택--");
		pyspCd.setSelectOnFocus(true);
		pyspCd.setStore(listStoreA005);
		pyspCd.setReadOnly(false);
		layoutContainer_111.add(pyspCd, new FormData("100%"));
		layoutContainer22.add(layoutContainer_111, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		
		
		LayoutContainer layoutContainer_2221 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(10);
		layoutContainer_2221.setLayout(frmlytSch);
		
		unnMbspSttYn = new CheckBox();
		unnMbspSttYn.setHideLabel(true);
		unnMbspSttYn.setValue(false);
		unnMbspSttYn.setBoxLabel("노조");
		unnMbspSttYn.setHideLabel(true);
		unnMbspSttYn.setValueAttribute("Y");
		
		layoutContainer_2221.add(unnMbspSttYn, new FormData("100%"));
		layoutContainer22.add(layoutContainer_2221, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		lcInfoLeft.add(layoutContainer22);
		
	    
		lcInfo.add(lcInfoLeft, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		// --
		
		
		
		// -- 
		LayoutContainer lcInfoRight = new LayoutContainer();
		
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcInfoRight.setLayout(frmlytStd);
		
		
		//부서 코드 처리  
	    LayoutContainer lccmCurrAffnDeptNm = new LayoutContainer();
	    lccmCurrAffnDeptNm.setLayout(new ColumnLayout());
        
	    //부서 
        currAffnDeptCd = new MSFTextField();
        currAffnDeptCd.setName("currAffnDeptCd");
        currAffnDeptCd.setVisible(false);
        cpPsnl0100.add(currAffnDeptCd);
        
         
        LayoutContainer lcCurrAffnDeptNm = new LayoutContainer(); 
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(100);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        lcCurrAffnDeptNm.setLayout(frmlytSch);
      
        currAffnDeptNm = new MSFTextField(); 
        currAffnDeptNm.setName("currAffnDeptNm");
        currAffnDeptNm.setFieldLabel("소속부서");
        //currAffnDeptNm.setLabelSeparator("");
        currAffnDeptNm.addKeyListener(new KeyListener() {
        	@Override
        	public void componentKeyDown(ComponentEvent event) {
        		
        		if (MSFSharedUtils.allowNulls(currAffnDeptNm.getValue()).trim().equals("")) {
    				currAffnDeptCd.setValue("");
	    		}
	    		if (MSFSharedUtils.paramNull(currAffnDeptNm.getValue())) {
	    			currAffnDeptCd.setValue("");
	    		}  
        		if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
        			//if (MSFSharedUtils.allowNulls(currAffnDeptNm.getValue()).trim().equals("")) {
        				currAffnDeptCd.setValue("");
        				//}
        			fnPopupCommP150_Curr(currAffnDeptNm.getValue());
        		}
        		super.componentKeyDown(event); 
        	}
        });
         
        lcCurrAffnDeptNm.add(currAffnDeptNm, new FormData("100%"));  
          
		btnCurrAffnDeptCd = new Button();
		btnCurrAffnDeptCd.setIcon(MSFMainApp.ICONS.search());
		btnCurrAffnDeptCd.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) { 
				if (MSFSharedUtils.allowNulls(currAffnDeptNm.getValue()).trim().equals("")) {
        			 currAffnDeptCd.setValue("");
				}
				
				fnPopupCommP150_Curr(currAffnDeptNm.getValue()); 
			}
		});
            
		lccmCurrAffnDeptNm.add(lcCurrAffnDeptNm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.91));
		lccmCurrAffnDeptNm.add(btnCurrAffnDeptCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));
		lcInfoRight.add(lccmCurrAffnDeptNm);
		
		
		LayoutContainer lc2 = new LayoutContainer(new ColumnLayout());
 		
		LayoutContainer lcEngNm = new LayoutContainer();

		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcEngNm.setLayout(frmlytSch);

		engNm = new TextField<String>();
		engNm.setFieldLabel("영문명/한문명");
		lcEngNm.add(engNm, new FormData("100%"));
 	    
		lc2.add(lcEngNm, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.65));
         
         
 	    LayoutContainer lcChanNm = new LayoutContainer();
 	    
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(0);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		lcChanNm.setLayout(frmlytSch);
 		
 		chinCharNm = new TextField<String>();
 		chinCharNm.setLabelSeparator("");
 		lcChanNm.add(chinCharNm, new FormData("100%"));
 	    
 		lc2.add(lcChanNm, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		
 		lcInfoRight.add(lc2);
 		
		
		hdofcCodtnCd = new MSFComboBox<BaseModel>();
		hdofcCodtnCd.setFieldLabel("재직구분");
		hdofcCodtnCd.setForceSelection(true);
		hdofcCodtnCd.setMinChars(1);
		hdofcCodtnCd.setDisplayField("commCdNm");
		hdofcCodtnCd.setValueField("commCd");
		hdofcCodtnCd.setTriggerAction(TriggerAction.ALL);
		hdofcCodtnCd.setEmptyText("--재직구분선택--");
		hdofcCodtnCd.setSelectOnFocus(true);
		hdofcCodtnCd.setStore(listStoreA003);
		hdofcCodtnCd.setReadOnly(false);
		hdofcCodtnCd.setEnabled(true);
		lcInfoRight.add(hdofcCodtnCd, new FormData("100%"));
		
		repbtyBusinDivCd = new ComboBox<BaseModel>(); 
		repbtyBusinDivCd.setName("repbtyBusinDivCd");
		repbtyBusinDivCd.setForceSelection(true);
		repbtyBusinDivCd.setMinChars(1);
		repbtyBusinDivCd.setDisplayField("commCdNm");
		repbtyBusinDivCd.setValueField("commCd");
		repbtyBusinDivCd.setTriggerAction(TriggerAction.ALL);
		repbtyBusinDivCd.setEmptyText("--호봉제선택--");
		repbtyBusinDivCd.setSelectOnFocus(true); 
		repbtyBusinDivCd.setReadOnly(false);
		repbtyBusinDivCd.setEnabled(true); 
		repbtyBusinDivCd.setStore(listStoreA048); 
		repbtyBusinDivCd.setFieldLabel("호봉제");  
 		
		lcInfoRight.add(repbtyBusinDivCd, new FormData("100%"));
		
		
		lcInfo.add(lcInfoRight, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		
		lcFieldSet1.add(lcInfo, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		
		fieldSet1.add(lcFieldSet1);
		layoutContainer111.add(fieldSet1);
		
		
		FieldSet fieldSet2 = new FieldSet();
		fieldSet2.setHeadingHtml("인 적");
		
		LayoutContainer lcFieldSet2 = new LayoutContainer();
		
		LayoutContainer lcStd01 = new LayoutContainer();

		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		layoutContainer_1.setStyleAttribute("paddingRight", "5px");
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1.setLayout(frmlytSch);

		husRoadNmZpcd = new MSFTextField();
		husRoadNmZpcd.setRegex("^[0-9]+$");
		husRoadNmZpcd.setId("husRoadNmZpcd");
		husRoadNmZpcd.setMaxLength(6);
		husRoadNmZpcd.setFieldLabel("도로명주소");
		husRoadNmZpcd.addKeyListener(new KeyListener() {
            public void componentKeyDown(ComponentEvent event) {
              
                if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
                	fnPopupCmmn0320();
                }
                super.componentKeyDown(event);
            }
         });
		layoutContainer_1.add(husRoadNmZpcd, new FormData("100%"));
		layoutContainer.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.205));
		
		
 /**
   * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   * 우편번호 팝업   -- 팝업호출을 위해 추가한 부분으로 임시로 공통팝업을 호출하는예시 넣음. 우편번호 완성후 변경처리  시작
   * 추후 메서드 형태로 지원하도록 수정 
   * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   */       
  		Button btnHusRoadNmZpcd =  new Button(MSFMainApp.MSFCONSTANTS.BtnSearch());
		btnHusRoadNmZpcd.setIcon(MSFMainApp.ICONS.search());
		btnHusRoadNmZpcd.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				
				GWTUtils.popupDoroWndClose(); 
				closeFunction();
				
				//우편번호 호출에 따른 변경 처리 루틴 추가  
				String postSystemkey = MSFMainApp.getMsg("PayGen.PostSystemkey");
				HashMap<String, String> params = new HashMap<String, String>();  
			
				if (!"NONE".equals(postSystemkey))  {
					//우편모아 호출 
				 //params.put("confmKey", postSystemkey);    //승인키-사용안함. 
					PrintUtils.setPostCall(true);
					PrintUtils.postPopUp(postSystemkey, params);
				} else {
					//일반자체호출 인경우 처리 
				 	fnPopupCmmn0320();
				}
			}
         });
		
		layoutContainer.add(btnHusRoadNmZpcd); 
		 
 /**
   * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   * 우편번호 팝업 -- 팝업호출을 위해 추가한 부분으로 임시로 공통팝업을 호출하는예시 넣음. 우편번호 완성후 변경처리  끝
   * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
   */ 
		LayoutContainer layoutContainer_2 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(0);
		layoutContainer_2.setLayout(frmlytSch);

		husRoadNmFndtnAddr = new MSFTextField();
		husRoadNmFndtnAddr.setId("husRoadNmFndtnAddr");
		// txtfldNewTextfield_1.setFieldLabel("New TextField");
		husRoadNmFndtnAddr.setLabelSeparator("");
		layoutContainer_2.add(husRoadNmFndtnAddr, new FormData("100%"));
		layoutContainer.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));

		LayoutContainer layoutContainer_3 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(0);
		layoutContainer_3.setLayout(frmlytSch);

		husRoadNmDtlPatrAddr = new TextField<String>();
		husRoadNmDtlPatrAddr.setId("husRoadNmDtlPatrAddr");
		husRoadNmDtlPatrAddr.setLabelSeparator("");
		layoutContainer_3.add(husRoadNmDtlPatrAddr, new FormData("100%"));
		layoutContainer.add(layoutContainer_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		
		lcStd01.add(layoutContainer);
		
		
		// LayoutContainer lcTabCol01 = new LayoutContainer(new ColumnLayout());
		LayoutContainer lcTab1Col02 = new LayoutContainer(new ColumnLayout());
		LayoutContainer lcTab1Col03 = new LayoutContainer(new ColumnLayout());
		LayoutContainer lcTab1Col04 = new LayoutContainer(new ColumnLayout());

		LayoutContainer lcStd1Left01 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStd1Left01.setLayout(frmlytStd);

		LayoutContainer lcStd1Left02 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStd1Left02.setLayout(frmlytStd);

		LayoutContainer lcStd1Center02 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStd1Center02.setLayout(frmlytStd);

		LayoutContainer lcStd1Left03 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStd1Left03.setLayout(frmlytStd);
		

		LayoutContainer layoutContainer_9 = new LayoutContainer();
		layoutContainer_9.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_10 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_10.setLayout(frmlytStd);

		psnl0111HusZpcd = new TextField<String>();
		psnl0111HusZpcd.setRegex("^[0-9]+$");
		//final TextField<String> txtfldNewTextfield_8 = new TextField<String>();
		psnl0111HusZpcd.setFieldLabel("생활근거지");
		layoutContainer_10.add(psnl0111HusZpcd, new FormData("100%"));
		
		layoutContainer_9.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		layoutContainer_10.setBorders(false);

		LayoutContainer layoutContainer_8 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(0);
		layoutContainer_8.setLayout(frmlytStd);

		psnl0111BthcAddr = new TextField<String>();
		// txtfldNewTextfield_2.setFieldLabel("New TextField");
		psnl0111BthcAddr.setLabelSeparator("");
		layoutContainer_8.add(psnl0111BthcAddr, new FormData("100%"));
		layoutContainer_9.add(layoutContainer_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.8));
		layoutContainer_8.setBorders(false);
		lcStd01.add(layoutContainer_9, new FormData("99.5%"));
		layoutContainer_9.setBorders(false);

		psnl0111HfmlyNm = new TextField<String>();
		psnl0111HfmlyNm.setFieldLabel("세대주");
		lcStd1Left03.add(psnl0111HfmlyNm, new FormData("95%"));
		
		psnl0111HusPhnNum = new TextField<String>();
		psnl0111HusPhnNum.setFieldLabel("전화번호");
		lcStd1Left03.add(psnl0111HusPhnNum, new FormData("95%"));
		
		LayoutContainer lcStd1Center03 = new LayoutContainer();
		//lcStdCenter03.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStd1Center03.setLayout(frmlytStd);
		
		psnl0111HfmlyRelaCd = new ComboBox<BaseModel>();
		psnl0111HfmlyRelaCd.setFieldLabel("관 계");
		psnl0111HfmlyRelaCd.setForceSelection(true);
		psnl0111HfmlyRelaCd.setMinChars(1);
		psnl0111HfmlyRelaCd.setDisplayField("commCdNm");
		psnl0111HfmlyRelaCd.setValueField("commCd");
		psnl0111HfmlyRelaCd.setTriggerAction(TriggerAction.ALL);
		psnl0111HfmlyRelaCd.setEmptyText("--관계선택--");
		psnl0111HfmlyRelaCd.setSelectOnFocus(true);
		psnl0111HfmlyRelaCd.setStore(listStoreA019);
		lcStd1Center03.add(psnl0111HfmlyRelaCd, new FormData("50%"));

		LayoutContainer lcStd1Center03_0 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lcStd1Center03_1 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStd1Center03_1.setLayout(frmlytStd);
		
		psnl0111CellPhneNum = new MSFTextField();
		psnl0111CellPhneNum.setFieldLabel("핸드폰");
//		lcStdCenter03.add(psnl0111CellPhneNum, new FormData("100%"));
		lcStd1Center03_1.add(psnl0111CellPhneNum, new FormData("100%"));
		lcStd1Center03_0.add(lcStd1Center03_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		

		LabelField company07 = new LabelField();
		lcStd1Center02.add(company07, new FormData("100%"));

		LayoutContainer lcStdCenter03_2 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdCenter03_2.setLayout(frmlytStd);
		
		
		psnl0111EmailAddr = new TextField<String>();

		psnl0111EmailAddr.setFieldLabel("이메일");
		psnl0111EmailAddr.setValidator(new Validator() {
			@Override
			public String validate(Field<?> field, String value) {
				return value.matches(RegEx.EMAIL) ? null : "이메일 체크!";
			}
		});
		//psnl0111EmailAddr.setRegex(RegEx.EMAIL);
		lcStdCenter03_2.add(psnl0111EmailAddr, new FormData("99.5%"));
//		lcStdCenter02.add(psnl0111EmailAddr, new FormData("90%"));
		lcStd1Center03_0.add(lcStdCenter03_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		lcStd1Center03.add(lcStd1Center03_0, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		lcTab1Col03.add(lcStd1Left03, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		lcTab1Col03.add(lcStd1Center03, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		
		

		lcStd1Left02.add(lcTab1Col03, new FormData("100%"));
		
		lcTab1Col02.add(lcStd1Left02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));

		lcStd01.add(lcTab1Col02, new FormData("100%"));
		
		
		LayoutContainer layoutContainer11 = new LayoutContainer(new ColumnLayout());
		layoutContainer11.setBorders(false);
		
		LayoutContainer lcTabLeft = new LayoutContainer(new ColumnLayout());
		LayoutContainer lcTabCenter = new LayoutContainer();
		LayoutContainer lcTabRight = new LayoutContainer();
		
		
		LayoutContainer lcTabLeft1_1 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcTabLeft1_1.setLayout(frmlytStd);
		
		
		styBgnnDt = new DateField();
		new DateFieldMask(styBgnnDt, "9999.99.99");
		styBgnnDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		styBgnnDt.setFieldLabel("체류기간");
		lcTabLeft1_1.add(styBgnnDt, new FormData("100%"));
		lcTabLeft.add(lcTabLeft1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.65));
		
		LayoutContainer lcTabLeft1_2 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(10);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcTabLeft1_2.setLayout(frmlytStd);
		
		styEndDt = new DateField();
		new DateFieldMask(styEndDt, "9999.99.99");
		styEndDt.setLabelSeparator("");
		styEndDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		styEndDt.setFieldLabel("~");
		lcTabLeft1_2.add(styEndDt, new FormData("90%"));
		lcTabLeft.add(lcTabLeft1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		
		
		
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcTabCenter.setLayout(frmlytStd);
		
		frgnrDivCd = new ComboBox<BaseModel>();
		frgnrDivCd.setFieldLabel("외국인구분");
		frgnrDivCd.setName("socnsrAqtnRegVal05");
		frgnrDivCd.setForceSelection(true);
		frgnrDivCd.setMinChars(1);
		frgnrDivCd.setDisplayField("commCdNm");
		frgnrDivCd.setValueField("commCd");
		frgnrDivCd.setTriggerAction(TriggerAction.ALL);
		frgnrDivCd.setEmptyText("--외국인구분--");
		frgnrDivCd.setSelectOnFocus(true); 
		frgnrDivCd.setStore(listStoreI004);  
		lcTabCenter.add(frgnrDivCd, new FormData("100%"));
		
		
		
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcTabRight.setLayout(frmlytStd);
		
		psptNum = new TextField<String>();
		psptNum.setFieldLabel("여권번호");
		lcTabRight.add(psptNum, new FormData("100%"));
		
		
		layoutContainer11.add(lcTabLeft, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer11.add(lcTabCenter, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		layoutContainer11.add(lcTabRight, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.28));
		lcStd01.add(layoutContainer11);
		
		
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStd01.setLayout(frmlytStd);

		pernNoteCtnt = new TextArea();
		pernNoteCtnt.setFieldLabel("비고");
		pernNoteCtnt.setSize(940, 40);
		
		lcStd01.add(pernNoteCtnt, new FormData("100%"));

		lcFieldSet2.add(lcStd01);
		fieldSet2.add(lcFieldSet2);
		
		
		layoutContainer111.add(fieldSet2);	
		
		
		FieldSet fieldSet3 = new FieldSet();
		fieldSet3.setHeadingHtml("고 용");
		
		LayoutContainer lcFieldSet3 = new LayoutContainer();
		
		LayoutContainer lcTab3Col01 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lcStd3Left01 = new LayoutContainer();
//		lcStd3Left01.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStd3Left01.setLayout(frmlytStd);
		
		
		emymtDivCd = new MSFComboBox<BaseModel>();
		emymtDivCd.setFieldLabel("고용구분");
		emymtDivCd.setForceSelection(true);
		emymtDivCd.setMinChars(1);
		emymtDivCd.setDisplayField("commCdNm");
		emymtDivCd.setValueField("commCd");
		emymtDivCd.setTriggerAction(TriggerAction.ALL);
		emymtDivCd.setEmptyText("--고용구분--");
		emymtDivCd.setSelectOnFocus(true);
		emymtDivCd.setStore(listStoreA002);
		emymtDivCd.setReadOnly(true);
		lcStd3Left01.add(emymtDivCd, new FormData("100%"));
		lcTab3Col01.add(lcStd3Left01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		
		
		
		LayoutContainer lcStd3Center01 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStd3Center01.setLayout(frmlytStd);
		
		emymtTypCd = new MSFComboBox<BaseModel>();
		emymtTypCd.setFieldLabel("고용유형");
		emymtTypCd.setForceSelection(true);
		emymtTypCd.setMinChars(1);
		emymtTypCd.setDisplayField("commCdNm");
		emymtTypCd.setValueField("commCd");
		emymtTypCd.setTriggerAction(TriggerAction.ALL);
		emymtTypCd.setEmptyText("--고용유형--");
		emymtTypCd.setSelectOnFocus(true);
		emymtTypCd.setStore(listStoreA042);
		lcStd3Center01.add(emymtTypCd, new FormData("100%"));
		lcTab3Col01.add(lcStd3Center01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		
		
		
		LayoutContainer lcStd3Right01 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lcStd3RightDate01 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStd3RightDate01.setLayout(frmlytStd);
		
		
		emymtBgnnDt = new MSFDateField();
		new DateFieldMask(emymtBgnnDt, "9999.99.99");
		emymtBgnnDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		emymtBgnnDt.setFieldLabel("고용기간");
		lcStd3RightDate01.add(emymtBgnnDt, new FormData("100%"));
		lcStd3Right01.add(lcStd3RightDate01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		
		LayoutContainer lcStd3RightDate02 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(10);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStd3RightDate02.setLayout(frmlytStd);
		
		emymtEndDt = new MSFDateField();
		new DateFieldMask(emymtEndDt, "9999.99.99");
		emymtEndDt.setLabelSeparator("");
		emymtEndDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		emymtEndDt.setFieldLabel("~");
		lcStd3RightDate02.add(emymtEndDt, new FormData("100%"));
		lcStd3Right01.add(lcStd3RightDate02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		
		lcTab3Col01.add(lcStd3Right01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));
		
		lcFieldSet3.add(lcTab3Col01);
		
		
		
		
		LayoutContainer lcTab3Col02 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lcStd3Left02 = new LayoutContainer(new ColumnLayout());
		
        
	    //부서 
        deptCd = new MSFTextField();
        deptCd.setName("deptCd");
        deptCd.setVisible(false);
        cpPsnl0100.add(deptCd);
        
         
        LayoutContainer lcDeptNm = new LayoutContainer(); 
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(100);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        lcDeptNm.setLayout(frmlytSch);
      
        deptNm = new MSFTextField(); 
        deptNm.setName("deptNm");
        deptNm.setFieldLabel("부 서"); 
        //currAffnDeptNm.setLabelSeparator("");
        deptNm.addKeyListener(new KeyListener() {
        	@Override
        	public void componentKeyDown(ComponentEvent event) {
        		
        		if (MSFSharedUtils.allowNulls(deptNm.getValue()).trim().equals("")) {
        			deptCd.setValue("");
	    		}
	    		if (MSFSharedUtils.paramNull(deptNm.getValue())) {
	    			deptCd.setValue("");
	    		}  
        		if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
        			//if (MSFSharedUtils.allowNulls(currAffnDeptNm.getValue()).trim().equals("")) {
        			deptCd.setValue("");
        				//}
        			fnPopupCommP145(deptNm.getValue());
        		}
        		super.componentKeyDown(event); 
        	}
        });
         
        lcDeptNm.add(deptNm, new FormData("100%"));  
          
		btnDeptCd = new Button();
		btnDeptCd.setIcon(MSFMainApp.ICONS.search());
		btnDeptCd.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) { 
				if (MSFSharedUtils.allowNulls(deptNm.getValue()).trim().equals("")) {
					deptCd.setValue("");
				}
				
				fnPopupCommP145(deptNm.getValue()); 
			}
		});
            
		lcStd3Left02.add(lcDeptNm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.91));
		lcStd3Left02.add(btnDeptCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));
		
		lcTab3Col02.add(lcStd3Left02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		
		
		LayoutContainer lcStd3Center02 = new LayoutContainer();
//		lcStd3Left01.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStd3Center02.setLayout(frmlytStd);
		
		
		currPaeWorkNm = new TextField<String>();
		currPaeWorkNm.setFieldLabel("현근무지");
		lcStd3Center02.add(currPaeWorkNm, new FormData("100%"));
		lcTab3Col02.add(lcStd3Center02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		
		
		
		LayoutContainer lcStd3Right02 = new LayoutContainer();
//		lcStd3Left01.setStyleAttribute("paddingRight", "10px");
//		frmlytStd = new FormLayout();
//		frmlytStd.setLabelWidth(100);
//		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
//		lcStd3Right02.setLayout(frmlytStd);
		
		
		lcStd3Right02_01 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lcStd3Right02_typ = new LayoutContainer();
		
//		lcStd3Left01.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStd3Right02_typ.setLayout(frmlytStd);
		
		typOccuCd = new MSFComboBox<BaseModel>();
		typOccuCd.setFieldLabel("직 종");
		typOccuCd.setForceSelection(true);
		typOccuCd.setMinChars(1);
		typOccuCd.setDisplayField("typOccuNm");
		typOccuCd.setValueField("typOccuCd");
		typOccuCd.setTriggerAction(TriggerAction.ALL);
		typOccuCd.setEmptyText("--직종선택--");
		typOccuCd.setSelectOnFocus(true);
		typOccuCd.setStore(listStoreA041);
		typOccuCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			@Override
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				
//				if("".equals(deptCd.getValue()) || deptCd.getValue() == null) {
//					MessageBox.alert("경고", "부서를 먼저 검색해 주세요.", null);
//					typOccuCd.setValue(new BaseModel());
//        			return;
//				}else {
					
//					String deptCdStr = deptCd.getValue();
					String typOccuCdStr =  MSFSharedUtils.getSelectedComboValue(typOccuCd, "typOccuCd");
					
	                
					//--------------------직종세 불러 오는 함수 -------------------------------------------------
			        listStoreBass0350.removeAll();
			        dtilOccuInttnCd.setStore(new ListStore<BaseModel>());
			        dtilOccuInttnCd.setValue(new BaseModel());
			        
			        sysComBass0350Dto = new PrgmComBass0350DTO();
//			        sysComBass0350Dto.setDeptCd(deptCdStr);
			        sysComBass0350Dto.setTypOccuCd(typOccuCdStr);
			        sysComBass0350Dto.setDtilOccuClsUseYn("A");
			        listStoreBass0350 = PrgmComComboUtils.getSingleNonBass0350ComboData(sysComBass0350Dto);
			        dtilOccuInttnCd.setStore(listStoreBass0350);
			        sysComBass0350Dto.setDtilOccuClsUseYn("");
	                //--------------------직종세 불러 오는 함수 -------------------------------------------------
					
//				}
			}
		});
		lcStd3Right02_typ.add(typOccuCd, new FormData("100%"));
		
		lcStd3Right02_01.add(lcStd3Right02_typ, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		
		LayoutContainer lcStd3Right02_dtil = new LayoutContainer();
		
//		lcStd3Left01.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(0);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStd3Right02_dtil.setLayout(frmlytStd);
		
		dtilOccuInttnCd = new MSFComboBox<BaseModel>();
//		typOccuCd.setFieldLabel("직 종");
		dtilOccuInttnCd.setLabelSeparator("");
		dtilOccuInttnCd.setForceSelection(true);
		dtilOccuInttnCd.setMinChars(1);
		dtilOccuInttnCd.setDisplayField("dtilOccuClsNm");
		dtilOccuInttnCd.setValueField("dtilOccuInttnCd");
		dtilOccuInttnCd.setTriggerAction(TriggerAction.ALL);
		dtilOccuInttnCd.setEmptyText("--직종세선택--");
		dtilOccuInttnCd.setSelectOnFocus(true);
		dtilOccuInttnCd.setStore(new ListStore<BaseModel>());
		dtilOccuInttnCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				 dtilOccuInttnCd.setStore(listStoreBass0350);
			}
		});
//		dtilOccuInttnCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
//			@Override
//			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
//				
//				if("".equals(deptCd.getValue()) || deptCd.getValue() == null) {
//					MessageBox.alert("경고", "부서를 먼저 검색해 주세요.", null);
//        			return;
//				}else if("".equals(MSFSharedUtils.getSelectedComboValue(typOccuCd, "typOccuCd")) || MSFSharedUtils.getSelectedComboValue(typOccuCd, "typOccuCd") == null) {
//					MessageBox.alert("경고", "직종을 먼저 선택해 주세요.", null);
//        			return;
//				}else {
//					
//				}
//			}
//		});

		lcStd3Right02_dtil.add(dtilOccuInttnCd, new FormData("100%"));
		lcStd3Right02_01.add(lcStd3Right02_dtil, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		
		lcStd3Right02.add(lcStd3Right02_01);
		
		
		
		lcStd3Right02_02 = new LayoutContainer();
		
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStd3Right02_02.setLayout(frmlytStd);
		
		businCd = new MSFComboBox<BaseModel>();
		businCd.setFieldLabel("사 업");
		businCd.setForceSelection(true);
		businCd.setMinChars(1);
		businCd.setDisplayField("businNm");
		businCd.setValueField("businCd");
		businCd.setTriggerAction(TriggerAction.ALL);
		businCd.setEmptyText("--사업선택--");
		businCd.setSelectOnFocus(true);
		businCd.setStore(lsBusinCd);
//		businCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
//			@Override
//			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
//				
////				if("".equals(deptCd.getValue()) || deptCd.getValue() == null) {
////					MessageBox.alert("경고", "부서를 먼저 검색해 주세요.", null);
////        			return;
////				}else if("".equals(emymtBgnnDt.getValue()) || emymtBgnnDt.getValue() == null) {
////					MessageBox.alert("경고", "고용기간을 먼저 입력해 주세요.", null);
////        			return;
////				}else {
//			
//					 String deptCdStr = deptCd.getValue();
//			         String businApptnYr =  PersonalUtil.getConvertDateToString(emymtBgnnDt, "yyyy");
//			     	MessageBox.alert("경고", deptCdStr + " | " + businApptnYr, null);
//					
//					sysComBass0500Dto = new PrgmComBass0500DTO();
//					sysComBass0500Dto.setBusinApptnYr(businApptnYr);  //DateTimeFormat.getFormat("yyyy").format(new Date())
//					sysComBass0500Dto.setDeptCd(deptCdStr); 
//	                
//					//--------------------사업 불러 오는 함수 -------------------------------------------------
//					lsBusinCd.removeAll();
//					businCd.setStore(new ListStore<BaseModel>());
//					businCd.setValue(new BaseModel());
//					lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
//					businCd.setStore(lsBusinCd);
//	                //--------------------사업 불러 오는 함수 -------------------------------------------------
//					
////				}
//			}
//		});
//		businCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
//			public void handleEvent(StoreEvent<BaseModel> be) {
//				businCd.setStore(lsBusinCd);
//			}
//		});
		
		
		lcStd3Right02_02.add(businCd, new FormData("100%"));
		lcStd3Right02.add(lcStd3Right02_02);
		
		lcTab3Col02.add(lcStd3Right02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));
		
		
		lcFieldSet3.add(lcTab3Col02);
		
		
		
		LayoutContainer lcTab3Col03 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lcStd3Left03 = new LayoutContainer();
//		lcStd3Left01.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStd3Left03.setLayout(frmlytStd);
		
		
		odtyCd = new ComboBox<BaseModel>();
		odtyCd.setFieldLabel("직 책");
		odtyCd.setForceSelection(true);
		odtyCd.setMinChars(1);
		odtyCd.setDisplayField("commCdNm");
		odtyCd.setValueField("commCd");
		odtyCd.setTriggerAction(TriggerAction.ALL);
		odtyCd.setEmptyText("--직책선택--");
		odtyCd.setSelectOnFocus(true);
		odtyCd.setStore(listStoreA015);
		odtyCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
//				odtyCd.setValue(listStoreA015.getAt(0));
			}
		});
		lcStd3Left03.add(odtyCd, new FormData("100%"));
		lcTab3Col03.add(lcStd3Left03, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		
		
		LayoutContainer lcStd3Center03 = new LayoutContainer();
//		lcStd3Left01.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStd3Center03.setLayout(frmlytStd);
		
		
		retryDivCd = new ComboBox<BaseModel>();
		retryDivCd.setFieldLabel("퇴직사유구분");
		retryDivCd.setForceSelection(true);
		retryDivCd.setMinChars(1);
		retryDivCd.setDisplayField("commCdNm");
		retryDivCd.setValueField("commCd");
		retryDivCd.setTriggerAction(TriggerAction.ALL);
		retryDivCd.setEmptyText("--퇴직사유선택--");
		retryDivCd.setSelectOnFocus(true);
		retryDivCd.setStore(listStoreA050);
		lcStd3Center03.add(retryDivCd, new FormData("100%"));
		lcTab3Col03.add(lcStd3Center03, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		
		
		
		LayoutContainer lcStd3Right03 = new LayoutContainer();
//		lcStd3Left01.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStd3Right03.setLayout(frmlytStd);
		
		retryReasCtnt = new TextField<String>();
		retryReasCtnt.setFieldLabel("퇴직사유내용");
		lcStd3Right03.add(retryReasCtnt, new FormData("100%"));
		lcTab3Col03.add(lcStd3Right03, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.42));
		lcFieldSet3.add(lcTab3Col03);
		
		
		
		LayoutContainer lcTab3Col04 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lcStd3Left04 = new LayoutContainer();
//		lcStd3Left01.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStd3Left04.setLayout(frmlytStd);
		
		emymtReasCtnt = new TextField<String>();
		emymtReasCtnt.setFieldLabel("비 고");
		lcStd3Left04.add(emymtReasCtnt, new FormData("100%"));
		lcTab3Col04.add(lcStd3Left04, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		
		
		lcFieldSet3.add(lcTab3Col04);
		
		
		
		fieldSet3.add(lcFieldSet3);
		layoutContainer111.add(fieldSet3);		
		
		
		
		
		
		
		FieldSet fieldSet4 = new FieldSet();
		fieldSet4.setHeadingHtml("병 역");
		
		LayoutContainer lcFieldSet4 = new LayoutContainer();

		LayoutContainer lcTab2Col01 = new LayoutContainer(new ColumnLayout());
		LayoutContainer lcTab2Col02 = new LayoutContainer(new ColumnLayout());
		LayoutContainer lcTab2Col03 = new LayoutContainer(new ColumnLayout());
		LayoutContainer lcTab2Col04 = new LayoutContainer(new ColumnLayout());

		LayoutContainer lcStd2Left01 = new LayoutContainer();
		lcStd2Left01.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStd2Left01.setLayout(frmlytStd);

		LayoutContainer lcStd2Center01 = new LayoutContainer();
		lcStd2Center01.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStd2Center01.setLayout(frmlytStd);

		LayoutContainer lcStd2Left02 = new LayoutContainer();
		lcStd2Left02.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStd2Left02.setLayout(frmlytStd);

		LayoutContainer lcStd2Center02 = new LayoutContainer();
		lcStd2Center02.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStd2Center02.setLayout(frmlytStd);

		LayoutContainer lcStd2Left03 = new LayoutContainer();
		lcStd2Left03.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStd2Left03.setLayout(frmlytStd);

		LayoutContainer lcStd2Center03 = new LayoutContainer();
		lcStd2Center03.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStd2Center03.setLayout(frmlytStd);

		// Button topBtn = new Button("조회");
		// topBtn.setIcon(PayGenApp.ICONS.accordion());

//		ContentPanel cp01 = new ContentPanel();
//		cp01.setHeaderVisible(false);
//		cp01.setFrame(true);
//		cp01.setSize(968, 213);
//		cp01.setLayout(new FitLayout());
 
		psnl0112EnrlntDt = new DateField();
		new DateFieldMask(psnl0112EnrlntDt, "9999.99.99"); 
		psnl0112EnrlntDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		psnl0112EnrlntDt.setFieldLabel("입대일자");
		lcStd2Left01.add(psnl0112EnrlntDt, new FormData("100%"));

		psnl0112DsageDt = new DateField();
		new DateFieldMask(psnl0112DsageDt, "9999.99.99"); 
		psnl0112DsageDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		psnl0112DsageDt.setFieldLabel("제대일자");
		lcStd2Center01.add(psnl0112DsageDt, new FormData("100%"));

		// buttonBar01.setAlignment(HorizontalAlignment.LEFT);
		// buttonBar01.add(topBtn);

		// lcRowCol01.add(lcStdLeft01, new RowData(.5, 1));
		// lcRowCol01.add(buttonBar01, new RowData(.5, 1));
		
		psnl0112SrvssCd = new ComboBox<BaseModel>();
		psnl0112SrvssCd.setFieldLabel("역종");
		psnl0112SrvssCd.setForceSelection(true);
		psnl0112SrvssCd.setMinChars(1);
		psnl0112SrvssCd.setDisplayField("commCdNm");
		psnl0112SrvssCd.setValueField("commCd");
		psnl0112SrvssCd.setTriggerAction(TriggerAction.ALL);
		psnl0112SrvssCd.setEmptyText("--역종선택--");
		psnl0112SrvssCd.setSelectOnFocus(true);
		psnl0112SrvssCd.setStore(listStoreA022);
		psnl0112SrvssCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				psnl0112SrvssCd.setValue(listStoreA022.getAt(0));
			}
		});
		lcStd2Left01.add(psnl0112SrvssCd, new FormData("100%"));

		
		psnl0112BaggrpCd = new ComboBox<BaseModel>();
		psnl0112BaggrpCd.setFieldLabel("군별");
		psnl0112BaggrpCd.setForceSelection(true);
		psnl0112BaggrpCd.setMinChars(1);
		psnl0112BaggrpCd.setDisplayField("commCdNm");
		psnl0112BaggrpCd.setValueField("commCd");
		psnl0112BaggrpCd.setTriggerAction(TriggerAction.ALL);
		psnl0112BaggrpCd.setEmptyText("--군별선택--");
		psnl0112BaggrpCd.setSelectOnFocus(true);
		psnl0112BaggrpCd.setStore(listStoreA023);
		psnl0112BaggrpCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				psnl0112BaggrpCd.setValue(listStoreA023.getAt(0));
			}
		});
		lcStd2Center01.add(psnl0112BaggrpCd, new FormData("100%"));
		
		
		psnl0112AbotsCd = new ComboBox<BaseModel>();
		psnl0112AbotsCd.setFieldLabel("병과");
		psnl0112AbotsCd.setForceSelection(true);
		psnl0112AbotsCd.setMinChars(1);
		psnl0112AbotsCd.setDisplayField("commCdNm");
		psnl0112AbotsCd.setValueField("commCd");
		psnl0112AbotsCd.setTriggerAction(TriggerAction.ALL);
		psnl0112AbotsCd.setEmptyText("--병과선택--");
		psnl0112AbotsCd.setSelectOnFocus(true);
		psnl0112AbotsCd.setStore(listStoreA024);
		psnl0112AbotsCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				psnl0112AbotsCd.setValue(listStoreA024.getAt(0));
			}
		});
		lcStd2Left01.add(psnl0112AbotsCd, new FormData("100%"));

		
		psnl0112ClsCd = new ComboBox<BaseModel>();
		psnl0112ClsCd.setFieldLabel("계급");
		psnl0112ClsCd.setForceSelection(true);
		psnl0112ClsCd.setMinChars(1);
		psnl0112ClsCd.setDisplayField("commCdNm");
		psnl0112ClsCd.setValueField("commCd");
		psnl0112ClsCd.setTriggerAction(TriggerAction.ALL);
		psnl0112ClsCd.setEmptyText("--계급선택--");
		psnl0112ClsCd.setSelectOnFocus(true);
		psnl0112ClsCd.setStore(listStoreA045);
		lcStd2Center01.add(psnl0112ClsCd, new FormData("100%"));

		
		psnl0112MitySilnum = new TextField<String>();
		psnl0112MitySilnum.setFieldLabel("군번");
		lcStd2Left01.add(psnl0112MitySilnum, new FormData("100%"));

		
		psnl0112Mos = new TextField<String>();
		psnl0112Mos.setFieldLabel("MOS");
		lcStd2Center01.add(psnl0112Mos, new FormData("100%"));

		
		psnl0112DsageDivCd = new ComboBox<BaseModel>();
		psnl0112DsageDivCd.setFieldLabel("제대구분");
		psnl0112DsageDivCd.setForceSelection(true);
		psnl0112DsageDivCd.setMinChars(1);
		psnl0112DsageDivCd.setDisplayField("commCdNm");
		psnl0112DsageDivCd.setValueField("commCd");
		psnl0112DsageDivCd.setTriggerAction(TriggerAction.ALL);
		psnl0112DsageDivCd.setEmptyText("--제대구분선택--");
		psnl0112DsageDivCd.setSelectOnFocus(true);
		psnl0112DsageDivCd.setStore(listStoreA025);
		psnl0112DsageDivCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				psnl0112DsageDivCd.setValue(listStoreA025.getAt(0));
			}
		});
		lcStd2Left01.add(psnl0112DsageDivCd, new FormData("100%"));
		
		psnl0112ExmtnReasCd = new ComboBox<BaseModel>();
		psnl0112ExmtnReasCd.setFieldLabel("미필사유");
		psnl0112ExmtnReasCd.setForceSelection(true);
		psnl0112ExmtnReasCd.setMinChars(1);
		psnl0112ExmtnReasCd.setDisplayField("commCdNm");
		psnl0112ExmtnReasCd.setValueField("commCd");
		psnl0112ExmtnReasCd.setTriggerAction(TriggerAction.ALL);
		psnl0112ExmtnReasCd.setEmptyText("--미필사유선택--");
		psnl0112ExmtnReasCd.setSelectOnFocus(true);
		psnl0112ExmtnReasCd.setStore(listStoreA021);
		psnl0112ExmtnReasCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				psnl0112ExmtnReasCd.setValue(listStoreA021.getAt(0));
			}
		});
		lcStd2Center01.add(psnl0112ExmtnReasCd, new FormData("100%"));

		
		psnl0112ServcRcgtnPridCd = new ComboBox<BaseModel>();
		psnl0112ServcRcgtnPridCd.setFieldLabel("복무인정기간");
		psnl0112ServcRcgtnPridCd.setForceSelection(true);
		psnl0112ServcRcgtnPridCd.setMinChars(1);
		psnl0112ServcRcgtnPridCd.setDisplayField("commCdNm");
		psnl0112ServcRcgtnPridCd.setValueField("commCd");
		psnl0112ServcRcgtnPridCd.setTriggerAction(TriggerAction.ALL);
		psnl0112ServcRcgtnPridCd.setEmptyText("--복무인정기간선택--");
		psnl0112ServcRcgtnPridCd.setSelectOnFocus(true);
		psnl0112ServcRcgtnPridCd.setStore(listStoreA029);
		psnl0112ServcRcgtnPridCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				psnl0112ServcRcgtnPridCd.setValue(listStoreA029.getAt(0));
			}
		});
		lcStd2Center02.add(psnl0112ServcRcgtnPridCd, new FormData("100%"));

		lcTab2Col01.add(lcStd2Left01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		lcTab2Col01.add(lcStd2Center01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		lcStd2Left02.add(lcTab2Col01, new FormData("100%"));

		lcTab2Col02.add(lcStd2Left02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.65));
		lcTab2Col02.add(lcStd2Center02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));

		lcFieldSet4.add(lcTab2Col02);
		
		fieldSet4.add(lcFieldSet4);

		layoutContainer111.add(fieldSet4);
		
		
		
		FieldSet fieldSet5 = new FieldSet();
		fieldSet5.setHeadingHtml("신 상");
		
		LayoutContainer lcFieldSet5 = new LayoutContainer();

		LayoutContainer lcTabCol02 = new LayoutContainer(new ColumnLayout());
		lcTabCol02.setLayout(new FormLayout());
		
		LayoutContainer layoutCtn = new LayoutContainer(new ColumnLayout());

		
		LayoutContainer layoutLeft = new LayoutContainer();
		FormLayout frmlytSbStd1 = new FormLayout();
		frmlytSbStd1.setLabelWidth(80);
		frmlytSbStd1.setLabelAlign(LabelAlign.RIGHT);
		layoutLeft.setLayout(frmlytSbStd1);
		
		sxDivCd = new MSFComboBox<BaseModel>();
		sxDivCd.setFieldLabel("성 별");
		sxDivCd.setForceSelection(true);
		
		sxDivCd.setDisplayField("commNm");
		sxDivCd.setValueField("commCd");
		sxDivCd.setMinChars(1);
		sxDivCd.setTriggerAction(TriggerAction.ALL);
		sxDivCd.setEmptyText("--성별--");
		
		ListStore<BaseModel> lsSxDivCd = new ListStore<BaseModel>();
		BaseModel sxDivCdBaseModel = new BaseModel();
		sxDivCdBaseModel.set("commCd", "A0040010");
		sxDivCdBaseModel.set("commNm", "남");
		
		lsSxDivCd.add(sxDivCdBaseModel);
		sxDivCdBaseModel = new BaseModel();
		sxDivCdBaseModel.set("commCd", "A0040020");
		sxDivCdBaseModel.set("commNm", "여");
		lsSxDivCd.add(sxDivCdBaseModel);
		sxDivCd.setStore(lsSxDivCd);
		sxDivCd.setSelectOnFocus(true);
		layoutLeft.add(sxDivCd, new FormData("100%"));
		
		LayoutContainer layoutCenter = new LayoutContainer();
		FormLayout frmlytSbStd2 = new FormLayout();
		frmlytSbStd2.setLabelWidth(80);
		frmlytSbStd2.setLabelAlign(LabelAlign.RIGHT);
		layoutCenter.setLayout(frmlytSbStd2);
		
//		yoobhMnthDay = new TextField<String>();
//		yoobhMnthDay.setFieldLabel("생년월일");
		yoobhMnthDay = new MSFDateField();
		new DateFieldMask(yoobhMnthDay, "9999.99.99");
		yoobhMnthDay.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		yoobhMnthDay.setFieldLabel("생년월일");
		layoutCenter.add(yoobhMnthDay, new FormData("100%"));

		
		LayoutContainer layoutRight = new LayoutContainer();
		FormLayout frmlytSbStd3 = new FormLayout();
		frmlytSbStd3.setLabelWidth(80);
		frmlytSbStd3.setLabelAlign(LabelAlign.RIGHT);
		layoutRight.setLayout(frmlytSbStd3);
		
		sclcDivCd = new RadioGroup();
		sclcDivCd.setFieldLabel("음양구분");
		birLun = new Radio();
		birLun.setBoxLabel("음력");
		birLun.setHideLabel(true);
		birLun.setValueAttribute("N");
		sclcDivCd.add(birLun);
		birSol = new Radio();
		birSol.setBoxLabel("양력");
		birSol.setHideLabel(true);
		birSol.setValueAttribute("Y");
		birSol.setValue(true);
		sclcDivCd.add(birSol);
		layoutRight.add(sclcDivCd, new FormData("100%"));
		
			
		
		layoutCtn.add(layoutLeft, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutCtn.add(layoutCenter, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutCtn.add(layoutRight, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		
		lcTabCol02.add(layoutCtn, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		

		LayoutContainer layoutContainers = new LayoutContainer(new ColumnLayout());

		LayoutContainer layoutContainer4_1 = new LayoutContainer();
		FormLayout frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(80);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer4_1.setLayout(frmlytSbStd);

		psnl0113Sttur = new TextField<String>();
		psnl0113Sttur.setFieldLabel("신 장");
		layoutContainer4_1.add(psnl0113Sttur, new FormData("100%"));
		layoutContainers.add(layoutContainer4_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));

		LayoutContainer layoutContainer4_2 = new LayoutContainer();
		frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(80);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer4_2.setLayout(frmlytSbStd);

		psnl0113Wei = new TextField<String>();
		psnl0113Wei.setFieldLabel("체 중");
		layoutContainer4_2.add(psnl0113Wei, new FormData("100%"));
		layoutContainers.add(layoutContainer4_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));

		LayoutContainer layoutContainer4_3 = new LayoutContainer();
		frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(80);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer4_3.setLayout(frmlytSbStd);

		psnl0113BldtpDivCd = new ComboBox<BaseModel>();
		psnl0113BldtpDivCd.setFieldLabel("혈액형");
		psnl0113BldtpDivCd.setForceSelection(true);
		psnl0113BldtpDivCd.setMinChars(1);
		psnl0113BldtpDivCd.setDisplayField("commCdNm");
		psnl0113BldtpDivCd.setValueField("commCd");
		psnl0113BldtpDivCd.setTriggerAction(TriggerAction.ALL);
		psnl0113BldtpDivCd.setEmptyText("--혈액형선택--");
		psnl0113BldtpDivCd.setSelectOnFocus(true);
		psnl0113BldtpDivCd.setStore(listStoreA013);
		psnl0113BldtpDivCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				psnl0113BldtpDivCd.setValue(listStoreA013.getAt(0));
			}
		});
		layoutContainer4_3.add(psnl0113BldtpDivCd, new FormData("100%"));
		layoutContainers.add(layoutContainer4_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));

		LayoutContainer layoutContainer4_4 = new LayoutContainer();
		frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(80);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer4_4.setLayout(frmlytSbStd);

		psnl0113PrmtsaYn = new RadioGroup();
		psnl0113PrmtsaYn.setFieldLabel("색 맹");
		Radio radio = new Radio();
		radio.setBoxLabel("유");
		radio.setHideLabel(true);
		radio.setValueAttribute("Y");
		psnl0113PrmtsaYn.add(radio);
		radio = new Radio();
		radio.setBoxLabel("무");
		radio.setHideLabel(true);
		radio.setValueAttribute("N");
		radio.setValue(true);
		psnl0113PrmtsaYn.add(radio);
		layoutContainer4_4.add(psnl0113PrmtsaYn, new FormData("100%"));
		layoutContainers.add(layoutContainer4_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		lcTabCol02.add(layoutContainers, new FormData("100%"));

		LayoutContainer layoutContainer4_5 = new LayoutContainer();
		layoutContainer4_5.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer4_6 = new LayoutContainer();
		layoutContainer4_6.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_7 = new LayoutContainer();
		frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(80);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_7.setLayout(frmlytSbStd);

		psnl0113TnkeeVsnLf = new TextField<String>();
		psnl0113TnkeeVsnLf.setFieldLabel("나안시력(좌)");
		layoutContainer_7.add(psnl0113TnkeeVsnLf, new FormData("100%"));
		
		layoutContainer4_6.add(layoutContainer_7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		layoutContainer_7.setBorders(false);

		LayoutContainer layoutContainer_12 = new LayoutContainer();
		frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(30);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_12.setLayout(frmlytSbStd);

		psnl0113TnkeeVsnRght = new TextField<String>();
		psnl0113TnkeeVsnRght.setFieldLabel("(우)");
		layoutContainer_12.add(psnl0113TnkeeVsnRght, new FormData("100%"));
		
		layoutContainer4_6.add(layoutContainer_12, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer4_5.add(layoutContainer4_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));

		LayoutContainer layoutContainer4_8 = new LayoutContainer();
		layoutContainer4_8.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer4_9 = new LayoutContainer();
		frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(80);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer4_9.setLayout(frmlytSbStd);

		psnl0113CorrVsnLf = new TextField<String>();
		psnl0113CorrVsnLf.setFieldLabel("교정시력(좌)");
		layoutContainer4_9.add(psnl0113CorrVsnLf, new FormData("100%"));
		
		layoutContainer4_8.add(layoutContainer4_9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		layoutContainer4_9.setBorders(false);

		LayoutContainer layoutContainer4_13 = new LayoutContainer();
		frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(30);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer4_13.setLayout(frmlytSbStd);

		psnl0113CorrVsnRght = new TextField<String>();
		psnl0113CorrVsnRght.setFieldLabel("(우)");
		layoutContainer4_13.add(psnl0113CorrVsnRght, new FormData("100%"));
		
		layoutContainer4_8.add(layoutContainer4_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer4_5.add(layoutContainer4_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));

		LayoutContainer layoutContainer4_10 = new LayoutContainer();
		frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(80);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer4_10.setLayout(frmlytSbStd);
		
		
		psnl0113RelnFrmCd = new ComboBox<BaseModel>();
		psnl0113RelnFrmCd.setFieldLabel("종 교");
		psnl0113RelnFrmCd.setForceSelection(true);
		psnl0113RelnFrmCd.setMinChars(1);
		psnl0113RelnFrmCd.setDisplayField("commCdNm");
		psnl0113RelnFrmCd.setValueField("commCd");
		psnl0113RelnFrmCd.setTriggerAction(TriggerAction.ALL);
		psnl0113RelnFrmCd.setEmptyText("--종료선택--");
		psnl0113RelnFrmCd.setSelectOnFocus(true);
		psnl0113RelnFrmCd.setStore(listStoreA020);
		layoutContainer4_10.add(psnl0113RelnFrmCd, new FormData("100%"));
		
		layoutContainer4_5.add(layoutContainer4_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));

		LayoutContainer layoutContainer4_11 = new LayoutContainer();
		frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(80);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer4_11.setLayout(frmlytSbStd);

		psnl0113HbbyCtnt = new TextField<String>();
		psnl0113HbbyCtnt.setFieldLabel("취 미");
		layoutContainer4_11.add(psnl0113HbbyCtnt, new FormData("100%"));
		
		layoutContainer4_5.add(layoutContainer4_11, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		lcTabCol02.add(layoutContainer4_5, new FormData("100%"));

		LayoutContainer layoutContainer4_14 = new LayoutContainer();
		layoutContainer4_14.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_15 = new LayoutContainer();
		frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(80);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_15.setLayout(frmlytSbStd);

		psnl0113SpityCtnt = new TextField<String>();
		psnl0113SpityCtnt.setFieldLabel("특 기");
		layoutContainer_15.add(psnl0113SpityCtnt, new FormData("100%"));
		
		layoutContainer4_14.add(layoutContainer_15, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_15.setBorders(false);

		LayoutContainer layoutContainer4_16 = new LayoutContainer();
		frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(80);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer4_16.setLayout(frmlytSbStd);

		psnl0113HlthCodtnCtnt = new TextField<String>();
		psnl0113HlthCodtnCtnt.setFieldLabel("건강상태");
		layoutContainer4_16.add(psnl0113HlthCodtnCtnt, new FormData("100%"));
		
		layoutContainer4_14.add(layoutContainer4_16, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		lcTabCol02.add(layoutContainer4_14, new FormData("100%"));

		LayoutContainer layoutContainer4_17 = new LayoutContainer();
		layoutContainer4_17.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer4_18 = new LayoutContainer();
		frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(80);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer4_18.setLayout(frmlytSbStd);
		
		psnl0113DabtyDivCd = new MSFComboBox<BaseModel>();
		psnl0113DabtyDivCd.setFieldLabel("장애유형");
		psnl0113DabtyDivCd.setForceSelection(true);
		psnl0113DabtyDivCd.setMinChars(1);
		psnl0113DabtyDivCd.setDisplayField("commCdNm");
		psnl0113DabtyDivCd.setValueField("commCd");
		psnl0113DabtyDivCd.setTriggerAction(TriggerAction.ALL);
		psnl0113DabtyDivCd.setEmptyText("--장애유형선택--");
		psnl0113DabtyDivCd.setSelectOnFocus(true);
		psnl0113DabtyDivCd.setStore(listStoreA037);
		psnl0113DabtyDivCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				psnl0113DabtyDivCd.setValue(listStoreA037.getAt(0));
			}
		});
		layoutContainer4_18.add(psnl0113DabtyDivCd, new FormData("100%"));
		
		
		layoutContainer4_17.add(layoutContainer4_18, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));

		LayoutContainer layoutContainer4_19 = new LayoutContainer();
		frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(80);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer4_19.setLayout(frmlytSbStd);
		
		psnl0113DabtyGrdeCd = new ComboBox<BaseModel>();
		psnl0113DabtyGrdeCd.setFieldLabel("장애등급");
		psnl0113DabtyGrdeCd.setForceSelection(true);
		psnl0113DabtyGrdeCd.setMinChars(1);
		psnl0113DabtyGrdeCd.setDisplayField("commCdNm");
		psnl0113DabtyGrdeCd.setValueField("commCd");
		psnl0113DabtyGrdeCd.setTriggerAction(TriggerAction.ALL);
		psnl0113DabtyGrdeCd.setEmptyText("--장애등급선택--");
		psnl0113DabtyGrdeCd.setSelectOnFocus(true);
		psnl0113DabtyGrdeCd.setStore(listStoreA036);
		psnl0113DabtyGrdeCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {
				psnl0113DabtyGrdeCd.setValue(listStoreA036.getAt(0));
			}
		});
		layoutContainer4_19.add(psnl0113DabtyGrdeCd, new FormData("100%"));
		
		layoutContainer4_17.add(layoutContainer4_19, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));

		LayoutContainer layoutContainer4_20 = new LayoutContainer();
		frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(80);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer4_20.setLayout(frmlytSbStd);

		psnl0113DabtyAjmtDt = new DateField();
		new DateFieldMask(psnl0113DabtyAjmtDt, "9999.99.99");
		psnl0113DabtyAjmtDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		psnl0113DabtyAjmtDt.setFieldLabel("장애판정일자");
		layoutContainer4_20.add(psnl0113DabtyAjmtDt, new FormData("100%"));
		
		layoutContainer4_17.add(layoutContainer4_20, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));

		LayoutContainer layoutContainer4_21 = new LayoutContainer();
		frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(80);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer4_21.setLayout(frmlytSbStd);
		layoutContainer4_17.add(layoutContainer4_21, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		lcTabCol02.add(layoutContainer4_17, new FormData("100%"));

		LayoutContainer layoutContainer4_22 = new LayoutContainer();
		layoutContainer4_22.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer4_23 = new LayoutContainer();
		frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(80);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer4_23.setLayout(frmlytSbStd);
		
		psnl0113PattVetnsDivCd = new ComboBox<BaseModel>();
		psnl0113PattVetnsDivCd.setFieldLabel("보훈구분");
		psnl0113PattVetnsDivCd.setForceSelection(true);
		psnl0113PattVetnsDivCd.setMinChars(1);
		psnl0113PattVetnsDivCd.setDisplayField("commCdNm");
		psnl0113PattVetnsDivCd.setValueField("commCd");
		psnl0113PattVetnsDivCd.setTriggerAction(TriggerAction.ALL);
		psnl0113PattVetnsDivCd.setEmptyText("--보훈구분선택--");
		psnl0113PattVetnsDivCd.setSelectOnFocus(true);
		psnl0113PattVetnsDivCd.setStore(listStoreA047);
		layoutContainer4_23.add(psnl0113PattVetnsDivCd, new FormData("100%"));
		layoutContainer4_22.add(layoutContainer4_23, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));

		LayoutContainer layoutContainer4_24 = new LayoutContainer();
		frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(80);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer4_24.setLayout(frmlytSbStd);

		psnl0113PattVetnsNum = new TextField<String>();
		psnl0113PattVetnsNum.setFieldLabel("보훈번호");
		layoutContainer4_24.add(psnl0113PattVetnsNum, new FormData("100%"));
		
		layoutContainer4_22.add(layoutContainer4_24, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer4_24.setBorders(false);

		LayoutContainer layoutContainer4_25 = new LayoutContainer();
		frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(80);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer4_25.setLayout(frmlytSbStd);
		
		
		psnl0113AmomRelaDivCd = new ComboBox<BaseModel>();
		psnl0113AmomRelaDivCd.setFieldLabel("유공자와관계");
		psnl0113AmomRelaDivCd.setForceSelection(true);
		psnl0113AmomRelaDivCd.setMinChars(1);
		psnl0113AmomRelaDivCd.setDisplayField("commCdNm");
		psnl0113AmomRelaDivCd.setValueField("commCd");
		psnl0113AmomRelaDivCd.setTriggerAction(TriggerAction.ALL);
		psnl0113AmomRelaDivCd.setEmptyText("--유공자와관계선택--");
		psnl0113AmomRelaDivCd.setSelectOnFocus(true);
		psnl0113AmomRelaDivCd.setStore(listStoreA019);
		layoutContainer4_25.add(psnl0113AmomRelaDivCd, new FormData("100%"));
		layoutContainer4_22.add(layoutContainer4_25, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));

		LayoutContainer layoutContainer4_26 = new LayoutContainer();
		frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(80);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer4_26.setLayout(frmlytSbStd);

		psnl0113PattVetnsYn = new CheckBoxGroup();
		psnl0113PattVetnsYn.setHideLabel(true);
		CheckBox checkBox = new CheckBox();
		checkBox.setBoxLabel("보훈여부");
		checkBox.setHideLabel(true);
		checkBox.setValueAttribute("Y");
		psnl0113PattVetnsYn.add(checkBox);
		layoutContainer4_26.add(psnl0113PattVetnsYn, new FormData("100%"));
		
		
		// chckbxgrpNewCheckboxgroup.setFieldLabel("");
		layoutContainer4_22.add(layoutContainer4_26, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		lcTabCol02.add(layoutContainer4_22, new FormData("100%"));

		LayoutContainer lcTabCol03 = new LayoutContainer(new ColumnLayout());
		LayoutContainer lcTabCol04 = new LayoutContainer(new ColumnLayout());

		LayoutContainer lcStdLeft03 = new LayoutContainer();
		lcStdLeft03.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdLeft03.setLayout(frmlytStd);

		LayoutContainer lcStdCenter03 = new LayoutContainer();
		lcStdCenter03.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdCenter03.setLayout(frmlytStd);


		lcFieldSet5.add(lcTabCol02);
		fieldSet5.add(lcFieldSet5);
		layoutContainer111.add(fieldSet5);
		
		
		ButtonBar btnBar = new ButtonBar();
		btnBar.setAlignment(HorizontalAlignment.RIGHT);
		
		
		Button btnInit = new Button("초기화");
		btnInit.setWidth(80);
		btnInit.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				psnl0100Init();	// 인사 기본 초기화
				psnl0111Init();	// 인사 인적 초기화
				psnl0110Init();	// 인사 고용 초기화
				psnl0112Init();	// 인사 병역 초기화
				psnl0113Init();	// 인사 신상 초기화
				
				
				actionDatabase = ActionDatabase.INSERT;
				
			}
		}); 
		btnBar.add(btnInit);
		
		
		Button btnSave = new Button("저 장");
		btnSave.setWidth(80);
		btnSave.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				
				if(psnl0100CheckVal() && psnl0110CheckVal() && psnl0111CheckVal()) {
					doAction(actionDatabase);
				}

			}
		}); 
		btnBar.add(btnSave);
		
		
		layoutContainer111.add(btnBar);

		
		
		ContentPanel panel = new ContentPanel();
		panel.setBodyBorder(false);
		panel.setBorders(false);
		panel.setHeaderVisible(false);
		panel.setScrollMode(Scroll.AUTO);
		panel.add(layoutContainer111);
		
		cpPsnl0100.add(panel);
		
	}
	  
			
	// 폼초기화 검색조건포함
	private void formInit() {

		actionDatabase = ActionDatabase.READ;

	}
	
	
	@Override
	public void bind(final ModelData model) {
		formBinding.bind(model);
		formBinding.addListener(Events.Bind, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				
//				Timer timer = new Timer() {
//					@Override
//					public void run() {
//					
//					}
//				};
//				timer.schedule(2500);
				
				
				emymtDivCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
					public void handleEvent(StoreEvent<BaseModel> be) {
//						psnl0112SrvssCd.setValue(listStoreA022.getAt(0));
						
						// -- 화면에 따른 고용구분, 등 셋팅
						if("PSNL0100".equals(formId.getValue()) || formId.getValue() == "PSNL0100") {
							
							PersonalUtil.setSelectedComboValue(emymtDivCd, MSFConfiguration.EMYMT_DIVCD01, "commCd");
							lcStd3Right02_01.show();
							lcStd3Right02_02.hide();
							
						}else if("PSNL0200".equals(formId.getValue()) || formId.getValue() == "PSNL0200"){
							
					       	PersonalUtil.setSelectedComboValue(emymtDivCd, MSFConfiguration.EMYMT_DIVCD02, "commCd");
					    	lcStd3Right02_01.hide();
							lcStd3Right02_02.show();
					       	
						}else {
							
					       	PersonalUtil.setSelectedComboValue(emymtDivCd, MSFConfiguration.EMYMT_DIVCD01, "commCd");
					       	lcStd3Right02_01.show();
							lcStd3Right02_02.hide();
					       	
						}
						
					}
				});
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
	
	class Tracker 
	{
	    public boolean status = false;
	    public boolean getStatus(){return status;}
	    public void setStatus(boolean stat){status = stat;}
	}  
	
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	
	
	//관리부서
	private void fnPopupCommP150_Mange(String deptCd) {
		// 검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
		// 넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
		// 검색.처리하면됨.
		MSFFormPanel popCom0145 = PrgmComPopupUtils.lovPopUpPrgmCom0145Form(deptCd,"Y");  //부서
	           
		final FormBinding popBindingCom0145 = popCom0145.getFormBinding();
	          
		popBindingCom0145.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				BaseModel mapModel = (BaseModel)be.getSource();
					
				if (!"".equals(mapModel.get("deptCd"))) {  
	                    
					if("".equals(currAffnDeptCd.getValue()) || "".equals(currAffnDeptNm.getValue())
							|| currAffnDeptCd.getValue() == null || currAffnDeptNm.getValue() == null) {
						
						mangeDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
	                    mangeDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt"))); 
	                    currAffnDeptCd.setValue("");
	                    currAffnDeptNm.setValue(""); 
	                    
					}else {
						
	                      mangeDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
	                      mangeDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt"))); 
	                      
					}
				}
			}
		});
	}
	
	
	//소속부서
	private void fnPopupCommP150_Curr(String deptCd) {
		//검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
        //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
        //검색.처리하면됨. 
		MSFFormPanel popCom0140 = PrgmComPopupUtils.lovPopUpPrgmCom0140Form(deptCd);  //부서
           
		final FormBinding popBindingCom0140 = popCom0140.getFormBinding();
          
		popBindingCom0140.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				BaseModel mapModel = (BaseModel)be.getSource();
				
				if (!"".equals(mapModel.get("deptCd"))) {  
                        
					if("".equals(mangeDeptCd.getValue()) || "".equals(mangeDeptNm.getValue())
							|| mangeDeptCd.getValue() == null || mangeDeptNm.getValue() == null) {
						
						mangeDeptCd.setValue("");
						mangeDeptNm.setValue(""); 
                        currAffnDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
                        currAffnDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt"))); 
                        
                    	}else {
                    		currAffnDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
                            currAffnDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt"))); 
                    	}
				}
			}
		});
	}
	
	
	//소속부서
	private void fnPopupCommP145(String deptNmStr) {
		//검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
        //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
        //검색.처리하면됨. 
		MSFFormPanel popCom0140 = PrgmComPopupUtils.lovPopUpNonPrgmCom0145Form(deptNmStr);  //부서
           
		final FormBinding popBindingCom0140 = popCom0140.getFormBinding();
          
		popBindingCom0140.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				BaseModel mapModel = (BaseModel)be.getSource();
				
				if (!"".equals(mapModel.get("deptCd"))) {  
                        
                   	deptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
                   	deptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt"))); 
                   	
                   	if(MSFConfiguration.EMYMT_DIVCD02.equals(PersonalUtil.getSelectedComboValue(emymtDivCd, "commCd")) 
                   			|| MSFConfiguration.EMYMT_DIVCD02 == PersonalUtil.getSelectedComboValue(emymtDivCd, "commCd")) {
                   		
                   		String deptCdStr = deptCd.getValue();
                   		String businApptnYr =  PersonalUtil.getConvertDateToString(emymtBgnnDt, "yyyy");
					
                   		sysComBass0500Dto = new PrgmComBass0500DTO();
                   		sysComBass0500Dto.setBusinApptnYr(businApptnYr);  //DateTimeFormat.getFormat("yyyy").format(new Date())
                   		sysComBass0500Dto.setDeptCd(deptCdStr); 
	                
                   		//--------------------사업 불러 오는 함수 -------------------------------------------------
                   		lsBusinCd.removeAll();
                   		businCd.setStore(new ListStore<BaseModel>());
                   		businCd.setValue(new BaseModel());
                   		lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
                   		businCd.setStore(lsBusinCd);
                   		//--------------------사업 불러 오는 함수 -------------------------------------------------
                   		
                   	}
				}
			}
		});
	}
	
	
	
	
	
	
	//우편번호
	private void fnPopupCmmn0320() {
		MSFFormPanel popCom0120 = SysComPopupUtils.lovPopUpMsfCom0120Form(); // 인사
		final FormBinding popBindingCom0120 = popCom0120.getFormBinding();
		popBindingCom0120.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				BaseModel mapModel = (BaseModel) be.getSource();
				if (!"".equals(mapModel.get("zpcd"))) {
					husRoadNmZpcd.setValue(MSFSharedUtils.allowNulls(mapModel.get("zpcd")));
					husRoadNmZpcd.fireEvent(Events.Add);
					husRoadNmFndtnAddr.setValue(MSFSharedUtils.allowNulls(mapModel.get("fnDtnAddr"))); // 앞주소
					husRoadNmDtlPatrAddr.setValue(MSFSharedUtils.allowNulls(mapModel.get("dtlPatrAddr"))); // 뒷주소
				}
			}
		});
	}
	
	//국가코드
	private void fnPopupBass0300(final String itemValue) {
		MSFFormPanel popCom0130 = PrgmComPopupUtils.lovPopUpPrgmCom0130Form(itemValue);  //공통  
	       
		final FormBinding popBindingCom0130 = popCom0130.getFormBinding();
	      
		popBindingCom0130.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				BaseModel mapModel = (BaseModel)be.getSource();
				if (!"".equals(mapModel.get("commCd"))) { 
					if ("A001".equals(itemValue)) {
						//국적
	                	natnCd.setValue( MSFSharedUtils.allowNulls(mapModel.get("commCd")));		//국가코드(Hidden)
	                	natnNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("commCdNm")));		//국가명
	                	natnItem.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeItem12")));	//국가코드Item
					} 
				}   
			}
		});
	}
//	
//	
//	// 사업 검색
//	private void fnPopupBass0500(final PrgmComBass0500DTO bass0500DTO) {
//		//검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
//		//넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
//		//검색.처리하면됨.
//		MSFFormPanel popComP0150 = PrgmComPopupUtils.lovPopUpPrgmCom0150Form(bass0500DTO);  //공통  
//	       
//		final FormBinding popBindingCom0150 = popComP0150.getFormBinding();
//	      
//		popBindingCom0150.addListener(Events.Change, new Listener<BaseEvent>() {
//			public void handleEvent(BaseEvent be) {
//				BaseModel mapModel = (BaseModel)be.getSource();
//				if (!"".equals(mapModel.get("businCd"))) {
//					businNm.setValue( MSFSharedUtils.allowNulls(mapModel.get("businCd")));
//				}
//			}
//		});
//	}
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	
	// 인사 기본 초기화
	private void psnl0100Init() {

		mangeDeptCd.setValue(""); 					// 관리부서코드
		mangeDeptNm.setValue(""); 					// 관리부서명
		currAffnDeptCd.setValue(""); 				// 소속부서코드
		currAffnDeptNm.setValue(""); 				// 소속부서명
		hanNm.setValue(""); 						// 한글 이름
		resnRegnNum.setValue(""); 					// 주민등록번호
		resnRegnNumStr.setValue("");
		engNm.setValue(""); 						// 영문이름
		chinCharNm.setValue(""); 					// 한자이름
		repbtyBusinNm.setValue(""); 				// 담당업무
		repbtyBusinDivCd.setValue(new BaseModel()); // 호봉제 구분
		natnNm.setValue(""); 						// 국가코드
		natnItem.setValue(""); 						// 국가코드 두자리
		natnCd.setValue(""); 						// 국가코드 키
		hdofcCodtnCd.setValue(new BaseModel());	 	// 재직 구분
		pyspCd.setValue(new BaseModel()); 			// 호봉
		unnMbspSttYn.setValue(false);				// 노조가입여부
		
	}
	
	
	// 인사 인적 초기화
	private void psnl0111Init() {
		
		husRoadNmZpcd.setValue(""); 			// 도로명 주소 우편번호
		husRoadNmFndtnAddr.setValue(""); 		// 도로명 기본주소
		husRoadNmDtlPatrAddr.setValue(""); 		// 도로명 상세 주소
		psnl0111HusZpcd.setValue("");					// 생활 근거지 우편
		psnl0111BthcAddr.setValue("");					// 생활 근거지 주소
		psnl0111HfmlyNm.setValue(""); 					// 호주
		psnl0111HfmlyRelaCd.setValue(new BaseModel()); 	// 호주관계
		
		psnl0111CellPhneNum.setValue(""); 				// 휴대폰번호
		psnl0111HusPhnNum.setValue(""); 				// 전화번호
		psnl0111EmailAddr.setValue(""); 				// 이메일
		
		styBgnnDt.reset();								// 체류시작일자
		styEndDt.reset();								// 체류종료일자
		frgnrDivCd.setValue(new BaseModel());			// 외국인구분코드
		psptNum.setValue("");							// 여권번호
		
		pernNoteCtnt.reset(); 							// 비고
		
	}
	
	// 인사 고용 초기화
	private void psnl0110Init() {
		
//		emymtDivCd.setValue(new BaseModel());			// 고용구분
		if("PSNL0100".equals(formId.getValue()) || formId.getValue() == "PSNL0100") {
			
			PersonalUtil.setSelectedComboValue(emymtDivCd, MSFConfiguration.EMYMT_DIVCD01, "commCd");
			lcStd3Right02_01.show();
			lcStd3Right02_02.hide();
			
		}else if("PSNL0200".equals(formId.getValue()) || formId.getValue() == "PSNL0200"){
			
	       	PersonalUtil.setSelectedComboValue(emymtDivCd, MSFConfiguration.EMYMT_DIVCD02, "commCd");
	       	
	       	lcStd3Right02_01.hide();
			lcStd3Right02_02.show();
			
		}else {
			lcStd3Right02_01.show();
			lcStd3Right02_02.hide();
			
			
	       	PersonalUtil.setSelectedComboValue(emymtDivCd, MSFConfiguration.EMYMT_DIVCD01, "commCd");
	       	
		}
		
		emymtTypCd.setValue(new BaseModel());						// 고용유형
		emymtBgnnDt.reset();										// 시작일자
		emymtEndDt.reset();											// 종료일자
		deptCd.setValue(""); 										// 부서 코드
		deptNm.setValue(""); 										// 부서 명
		currPaeWorkNm.setValue("");									// 현근무지
		typOccuCd.setValue(new BaseModel());						// 직종
		dtilOccuInttnCd.setValue(new BaseModel());					// 직종세
		businCd.setValue(new BaseModel());							// 사업
		odtyCd.setValue(listStoreA015.getAt(0));					// 직책
		retryDivCd.setValue(new BaseModel());						// 퇴직사유구분
		retryReasCtnt.setValue("");									// 퇴직사유내용
		emymtReasCtnt.setValue("");									// 비고
		
	}
	
	
	
	// 인사 병역 초기화
	private void psnl0112Init() {
			
		psnl0112DsageDt.reset();									// 제대일자
		psnl0112ServcRcgtnPridCd.setValue(listStoreA029.getAt(0));	// 복무인정기간
		psnl0112SrvssCd.setValue(listStoreA022.getAt(0));			// 역종
		psnl0112BaggrpCd.setValue(listStoreA023.getAt(0));			// 군별
		psnl0112AbotsCd.setValue(listStoreA024.getAt(0));			// 병과
		psnl0112ClsCd.setValue(new BaseModel());					// 계급
		psnl0112MitySilnum.setValue("");							// 군번
		psnl0112Mos.setValue("");									// mos
		psnl0112DsageDivCd.setValue(listStoreA025.getAt(0));		// 제대구분
		psnl0112ExmtnReasCd.setValue(listStoreA021.getAt(0));		// 미필사유
		
	}
	
	
	// 인사 신상 초기화
	private void psnl0113Init() {
				
		psnl0113Sttur.setValue("");									// 신장
		psnl0113Wei.setValue("");									// 체중
		psnl0113BldtpDivCd.setValue(listStoreA013.getAt(0));		// 혈액형 콤보
		psnl0113PrmtsaYn.reset();									// 색맹(radio)
		psnl0113TnkeeVsnLf.setValue("");							// 나안시력 좌
		psnl0113TnkeeVsnRght.setValue("");							// 나인시력 우
		psnl0113CorrVsnLf.setValue("");								// 교정시력 좌
		psnl0113CorrVsnRght.setValue("");							// 교정시력 우
		psnl0113RelnFrmCd.setValue(new BaseModel());				// 종교 콤보
		psnl0113HbbyCtnt.setValue("");								// 취미
		psnl0113SpityCtnt.setValue("");								// 특기
		psnl0113HlthCodtnCtnt.setValue("");							// 건강상태
		psnl0113DabtyDivCd.setValue(listStoreA037.getAt(0));		// 장애구분
		psnl0113DabtyGrdeCd.setValue(listStoreA036.getAt(0));		// 장애등급
		psnl0113DabtyAjmtDt.reset();								// 장애판정일자
		psnl0113PattVetnsDivCd.setValue(new BaseModel());			// 보훈구분
		psnl0113PattVetnsNum.setValue("");							// 보훈번호
		psnl0113AmomRelaDivCd.setValue(new BaseModel());			// 유공자와관계
		psnl0113PattVetnsYn.reset();								// 보훈여부 (checkbox)
		sxDivCd.setValue(new BaseModel());							// 성별
		yoobhMnthDay.reset();										// 생년월일
		strYoobhMnthDay = ""; 										// 생년월일 가져오는
		birLun.setValue(false);										// 음력
		birSol.setValue(true);										// 양력
				
	}
	
	
	
    /** 저장  **/
    private void savePsnlAll() {
    	
		final Tracker tracker = new Tracker();
  	  	tracker.setStatus(false);
    	
  		psnl010002Dto = new Psnl010002DTO();
//    	psnl0100Dto = new Psnl0100DTO();
  		psnl010002Dto.setSystemkey(systemkey.getValue()); 																						/** column SYSTEMKEY : systemkey */
    	
    	// -- 인사 기본
  		psnl010002Dto.setDeptCd(MSFSharedUtils.allowNulls(mangeDeptCd.getValue()));    															/** column 부서코드 : deptCd */
  		psnl010002Dto.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(currAffnDeptCd.getValue()));													/** column 현소속부서코드 : currAffnDeptCd */
  		psnl010002Dto.setHanNm(MSFSharedUtils.allowNulls(hanNm.getValue()));    																/** column 한글성명 : hanNm */
  		psnl010002Dto.setResnRegnNum(MSFSharedUtils.allowNulls(resnRegnNum.getValue().replaceAll("-", ""))); 									/** column 주민등록번호 : resnRegnNum */
  		psnl010002Dto.setEngNm(MSFSharedUtils.allowNulls(engNm.getValue()));    																/** column 영문성명 : engNm */
  		psnl010002Dto.setChinCharNm(MSFSharedUtils.allowNulls(chinCharNm.getValue()));    														/** column 한문성명 : chinCharNm */  	
  		psnl010002Dto.setRepbtyBusinNm(MSFSharedUtils.allowNulls(repbtyBusinNm.getValue()));    												/** column 담당업무명 : repbtyBusinNm */
  		psnl010002Dto.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(hdofcCodtnCd, "commCd")));					/** column 재직상태코드 : hdofcCodtnCd */
  		psnl010002Dto.setNatnCd(MSFSharedUtils.allowNulls(natnCd.getValue()));    																/** column 국가코드 : natnCd */
  		psnl010002Dto.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(repbtyBusinDivCd, "commCd")));			/** column 호봉제구분코드 : repbtyBusinDivCd */
  		psnl010002Dto.setPyspCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(pyspCd, "commCd")));    							/** column 호봉코드 : pyspCd */	
  		psnl010002Dto.setUnnMbspSttYn(MSFSharedUtils.allowNulls(PersonalUtil.getCheckedCheckBoxYnValue(unnMbspSttYn)));    						/** column 노조가입여부 : unnMbspSttYn */
  		
  		
  		// -- 인사 인적
  		psnl010002Dto.setHusRoadNmZpcd(MSFSharedUtils.allowNulls(husRoadNmZpcd.getValue()));    										/** column 집도로명우편번호 : husRoadNmZpcd */
  		psnl010002Dto.setHusRoadNmFndtnAddr(MSFSharedUtils.allowNulls(husRoadNmFndtnAddr.getValue()));    								/** column 집도로명기본주소 : husRoadNmFndtnAddr */
  		psnl010002Dto.setHusRoadNmDtlPatrAddr(MSFSharedUtils.allowNulls(husRoadNmDtlPatrAddr.getValue()));    							/** column 집도로명상세주소 : husRoadNmDtlPatrAddr */
  		psnl010002Dto.setHusZpcd(MSFSharedUtils.allowNulls(psnl0111HusZpcd.getValue()));    													/** column 집우편번호 : husZpcd */
  		psnl010002Dto.setBthcAddr(MSFSharedUtils.allowNulls(psnl0111BthcAddr.getValue()));   			 										/** column 출생지주소 : bthcAddr */
  		psnl010002Dto.setHfmlyNm(MSFSharedUtils.allowNulls(psnl0111HfmlyNm.getValue()));    													/** column 호주성명 : hfmlyNm */
  		psnl010002Dto.setHfmlyRelaCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(psnl0111HfmlyRelaCd, "commCd")));   		/** column 호주와의관계코드 : hfmlyRelaCd */
  		psnl010002Dto.setCellPhneNum(MSFSharedUtils.allowNulls(psnl0111CellPhneNum.getValue()));    											/** column 핸드폰번호 : cellPhneNum */
  		psnl010002Dto.setHusPhnNum(MSFSharedUtils.allowNulls(psnl0111HusPhnNum.getValue()));    												/** column 집전화번호 : husPhnNum */
  		psnl010002Dto.setEmailAddr(MSFSharedUtils.allowNulls(psnl0111EmailAddr.getValue()));    												/** column 이메일주소 : emailAddr */
  		
  			// -- psnl0100 update
  		psnl010002Dto.setStyBgnnDt(MSFSharedUtils.allowNulls(GWTUtils.getStringFromDate(styBgnnDt.getValue(), "yyyyMMdd")));    				/** column 체류시작일자 : styBgnnDt */
  		psnl010002Dto.setStyEndDt(MSFSharedUtils.allowNulls(GWTUtils.getStringFromDate(styEndDt.getValue(), "yyyyMMdd")));    					/** column 체류종료일자 : styEndDt */
  		psnl010002Dto.setFrgnrDivCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(frgnrDivCd, "commCd")));    					/** column 외국인구분코드 : frgnrDivCd */
  		psnl010002Dto.setPsptNum(MSFSharedUtils.allowNulls(psptNum.getValue()));    															/** column 여권번호 : psptNum */
    	psnl010002Dto.setPernNoteCtnt(MSFSharedUtils.allowNulls(pernNoteCtnt.getValue()));    													/** column 인사비고내용 : pernNoteCtnt */
    		// ---
    	
    	
    	// -- 인사 고용
    	psnl010002Dto.setEmymtSeilNum(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(emymtSeilNum.getValue(), "0")));			/** column 고용일련번호 : emymtSeilNum */
    	psnl010002Dto.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(emymtDivCd, "commCd")));    					/** column 고용구분코드 : emymtDivCd */
    	psnl010002Dto.setEmymtTypCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(emymtTypCd, "commCd")));    					/** column 고용유형코드 : emymtTypCd */
    	psnl010002Dto.setEmymtBgnnDt(MSFSharedUtils.allowNulls(GWTUtils.getStringFromDate(emymtBgnnDt.getValue(), "yyyyMMdd")));    			/** column 고용시작일자 : emymtBgnnDt */
    	psnl010002Dto.setEmymtEndDt(MSFSharedUtils.allowNulls(GWTUtils.getStringFromDate(emymtEndDt.getValue(), "yyyyMMdd")));    				/** column 고용종료일자 : emymtEndDt */
    	psnl010002Dto.setDeptCd(MSFSharedUtils.allowNulls(deptCd.getValue()));    																/** column 부서코드 : deptCd */
    	psnl010002Dto.setCurrPaeWorkNm(MSFSharedUtils.allowNulls(currPaeWorkNm.getValue()));    												/** column 현근무지명 : currPaeWorkNm */
    	psnl010002Dto.setBusinCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(businCd, "businCd")));    						/** column 사업코드 : businCd */
    	psnl010002Dto.setTypOccuCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(typOccuCd, "typOccuCd")));    				/** column 직종코드 : typOccuCd */
    	psnl010002Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(dtilOccuInttnCd, "dtilOccuInttnCd")));	/** column 직종통합코드 : dtilOccuInttnCd */
    	psnl010002Dto.setOdtyCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(odtyCd, "commCd")));    							/** column 직책코드 : odtyCd */
    	psnl010002Dto.setRetryDivCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(retryDivCd, "commCd")));    					/** column 퇴직이직사유구분코드 : retryDivCd */   
    	psnl010002Dto.setRetryReasCtnt(MSFSharedUtils.allowNulls(retryReasCtnt.getValue()));    												/** column 퇴직사유내용 : retryReasCtnt */

    	// -- 인사 병역
    	psnl010002Dto.setEnrlntDt(MSFSharedUtils.allowNulls(GWTUtils.getStringFromDate(psnl0112EnrlntDt.getValue(), "yyyyMMdd")));    			/** column 입대일자 : enrlntDt */
    	psnl010002Dto.setDsageDt(MSFSharedUtils.allowNulls(GWTUtils.getStringFromDate(psnl0112DsageDt.getValue(), "yyyyMMdd")));    			/** column 제대일자 : dsageDt */
    	psnl010002Dto.setServcRcgtnPridCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(psnl0112ServcRcgtnPridCd, "commCd")));	/** column 복무인정기간코드 : servcRcgtnPridCd */
    	psnl010002Dto.setSrvssCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(psnl0112SrvssCd, "commCd")));    				/** column 역종코드 : srvssCd */
    	psnl010002Dto.setBaggrpCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(psnl0112BaggrpCd, "commCd")));    				/** column 군별코드 : baggrpCd */
    	psnl010002Dto.setAbotsCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(psnl0112AbotsCd, "commCd")));    				/** column 병과코드 : abotsCd */
    	psnl010002Dto.setClsCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(psnl0112ClsCd, "commCd")));    					/** column 계급코드 : clsCd */
    	psnl010002Dto.setMitySilnum(MSFSharedUtils.allowNulls(psnl0112MitySilnum.getValue()));    												/** column 군번 : mitySilnum */
    	psnl010002Dto.setMos(MSFSharedUtils.allowNulls(psnl0112Mos.getValue()));    															/** column MOS : mos */
    	psnl010002Dto.setDsageDivCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(psnl0112DsageDivCd, "commCd")));    			/** column 제대구분코드 : dsageDivCd */
    	psnl010002Dto.setExmtnReasCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(psnl0112ExmtnReasCd, "commCd")));    		/** column 면제사유코드 : exmtnReasCd */ 	
    	
    	
    	// -- 인사 신상
    		// -- psnl0100 update
    	psnl010002Dto.setSxDivCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(sxDivCd, "commCd")));    						/** column 성별구분코드 : sxDivCd */
    	psnl010002Dto.setYoobhMnthDay(MSFSharedUtils.allowNulls(GWTUtils.getStringFromDate(yoobhMnthDay.getValue(), "yyyyMMdd")));   		 	/** column 생년월일 : yoobhMnthDay */
//    	psnl0100Dto.setSclcDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("sclcDivCd")));    /** column 음양구분코드 : sclcDivCd */
    		// -- psnl0100 update
    	psnl010002Dto.setSttur(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(psnl0113Sttur.getValue(), "0")));    				/** column 신장 : sttur */
    	psnl010002Dto.setWei(MSFSharedUtils.convertStringToLong(MSFSharedUtils.defaultNulls(psnl0113Wei.getValue(), "0")));   	 				/** column 체중 : wei */
    	psnl010002Dto.setBldtpDivCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(psnl0113BldtpDivCd, "commCd")));    			/** column 혈액형구분코드 : bldtpDivCd */
    	psnl010002Dto.setPrmtsaYn(MSFSharedUtils.allowNulls(PersonalUtil.getCheckedRadioValue(psnl0113PrmtsaYn)));    							/** column 색맹여부 : prmtsaYn */
    	psnl010002Dto.setTnkeeVsnLf(MSFSharedUtils.allowNulls(psnl0113Wei.getValue()));    														/** column 나안시력_좌 : tnkeeVsnLf */
    	psnl010002Dto.setTnkeeVsnRght(MSFSharedUtils.allowNulls(psnl0113TnkeeVsnRght.getValue()));    											/** column 나안시력_우 : tnkeeVsnRght */
    	psnl010002Dto.setCorrVsnLf(MSFSharedUtils.allowNulls(psnl0113CorrVsnLf.getValue()));    												/** column 교정시력_좌 : corrVsnLf */
    	psnl010002Dto.setCorrVsnRght(MSFSharedUtils.allowNulls(psnl0113CorrVsnRght.getValue()));    											/** column 교정시력_우 : corrVsnRght */
    	psnl010002Dto.setRelnFrmCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(psnl0113RelnFrmCd, "commCd")));    			/** column 종교유형코드 : relnFrmCd */
    	psnl010002Dto.setHbbyCtnt(MSFSharedUtils.allowNulls(psnl0113HbbyCtnt.getValue()));    													/** column 취미내용 : hbbyCtnt */
    	psnl010002Dto.setSpityCtnt(MSFSharedUtils.allowNulls(psnl0113SpityCtnt.getValue()));    												/** column 특기내용 : spityCtnt */	
    	psnl010002Dto.setHlthCodtnCtnt(MSFSharedUtils.allowNulls(psnl0113HlthCodtnCtnt.getValue()));   										 	/** column 건강상태내용 : hlthCodtnCtnt */
    	psnl010002Dto.setDabtyDivCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(psnl0113DabtyDivCd, "commCd")));    			/** column 장애구분코드 : dabtyDivCd */
    	psnl010002Dto.setDabtyGrdeCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(psnl0113DabtyGrdeCd, "commCd")));    		/** column 장애등급코드 : dabtyGrdeCd */
    	psnl010002Dto.setDabtyAjmtDt(MSFSharedUtils.allowNulls(GWTUtils.getStringFromDate(psnl0113DabtyAjmtDt.getValue(), "yyyyMMdd")));    	/** column 장애판정일자 : dabtyAjmtDt */
    	psnl010002Dto.setPattVetnsDivCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(psnl0113PattVetnsDivCd, "commCd")));    	/** column 보훈구분코드 : pattVetnsDivCd */
    	psnl010002Dto.setPattVetnsNum(MSFSharedUtils.allowNulls(psnl0113PattVetnsNum.getValue()));    											/** column 보훈번호 : pattVetnsNum */
    	psnl010002Dto.setAmomRelaDivCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(psnl0113AmomRelaDivCd, "commCd")));    	/** column 유공자와의관계구분코드 : amomRelaDivCd */
    	psnl010002Dto.setPattVetnsYn(MSFSharedUtils.allowNulls(PersonalUtil.getCheckedCheckBoxValue(psnl0113PattVetnsYn)));    					/** column 보훈여부 : pattVetnsYn */
    	
    	
    	final MessageBox box = MessageBox.wait("인사등록", "인사 정보 저장 처리 중 입니다...", "인사 정보 저장 중...");
        final Timer t = new Timer()
        {
            public void run()
            {
                if (tracker.getStatus())
                {
                    cancel();
                    box.close();
                }
            }
        };
        t.scheduleRepeating(500);
    	
    	
    	psnlP010002Service.savePsnlAll(psnl010002Dto, actionDatabase, new AsyncCallback<PagingLoadResult<ShowMessageBM>>() {	
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
				tracker.setStatus(true);
				
				ShowMessageBM smForm = new ShowMessageBM();
				smForm.setWindowId("PsnlP010002");
				smForm.setWindowNm("인사신규등록");
	            GWTUtils.messageExcepDlgEx(caught,smForm);
					
			}

			@Override
			public void onSuccess(PagingLoadResult<ShowMessageBM> result) {
				// TODO Auto-generated method stub
				
				tracker.setStatus(true);
				ShowMessageForm showMessageForm = new ShowMessageForm(result,ActionDatabase.READ, getThis());   
			    
				MSFFormWindows msFwMessage = new MSFFormWindows("메시지정보",showMessageForm,"닫기","620px", "510px",true);
				msFwMessage.show();
				showMessageForm.setMSFFormWindows(msFwMessage);	
				
				resnRegnNumStr.setValue(resnRegnNum.getValue());
//				MessageBox.info("알림",  (actionDatabase  ==  ActionDatabase.DELETE ? "삭제처리가 " : "저장처리가 " ) +  "가 완료되었습니다." , null);	
//				dataReLoad();
				
				
				
				// 인사정보 저장 후 시스템키 값을 가져온다.
				psnl010002Dto = new Psnl010002DTO();
				psnl010002Dto.setResnRegnNum(resnRegnNum.getValue().replaceAll("-", ""));
		    	psnlP010002Service.getSystemkey(psnl010002Dto, new AsyncCallback<String>() {	
					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
							
					}

					@Override
					public void onSuccess(String result) {
						// TODO Auto-generated method stub
						
						systemkey.setValue(result);
						
						actionDatabase = ActionDatabase.UPDATE;
					}
		    	});
			}
    	});
    	
  		
//    	psnl0100Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
//    	psnl0100Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
//    	psnl0100Dto.setResnRegnNum(MSFSharedUtils.allowNulls(bmMapModel.get("resnRegnNum")));    /** column 주민등록번호 : resnRegnNum */
//    	psnl0100Dto.setBusinCd(MSFSharedUtils.allowNulls(bmMapModel.get("businCd")));    /** column 사업코드 : businCd */
//    	psnl0100Dto.setTypOccuCd(MSFSharedUtils.allowNulls(bmMapModel.get("typOccuCd")));    /** column 직종코드 : typOccuCd */
//    	psnl0100Dto.setOdtyCd(MSFSharedUtils.allowNulls(bmMapModel.get("odtyCd")));    /** column 직책코드 : odtyCd */
//    	psnl0100Dto.setFrstEmymtDt(MSFSharedUtils.allowNulls(bmMapModel.get("frstEmymtDt")));    /** column 최초고용일자 : frstEmymtDt */
//    	psnl0100Dto.setEmymtDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("emymtDivCd")));    /** column 고용구분코드 : emymtDivCd */
//    	psnl0100Dto.setEmymtBgnnDt(MSFSharedUtils.allowNulls(bmMapModel.get("emymtBgnnDt")));    /** column 고용시작일자 : emymtBgnnDt */
//    	psnl0100Dto.setEmymtEndDt(MSFSharedUtils.allowNulls(bmMapModel.get("emymtEndDt")));    /** column 고용종료일자 : emymtEndDt */
//    	psnl0100Dto.setRetryDt(MSFSharedUtils.allowNulls(bmMapModel.get("retryDt")));    /** column 퇴직일자 : retryDt */
//    	psnl0100Dto.setEndSchl(MSFSharedUtils.allowNulls(bmMapModel.get("endSchl")));    /** column 최종학교 : endSchl */
//    	psnl0100Dto.setEndDegrDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("endDegrDivCd")));    /** column 최종학위구분코드 : endDegrDivCd */
//    	psnl0100Dto.setPmtnScduDt(MSFSharedUtils.allowNulls(bmMapModel.get("pmtnScduDt")));    /** column 승진예정일자 : pmtnScduDt */
//    	psnl0100Dto.setPyspPrmtnScduDt(MSFSharedUtils.allowNulls(bmMapModel.get("pyspPrmtnScduDt")));    /** column 호봉승급예정일자 : pyspPrmtnScduDt */
//    	psnl0100Dto.setReymnScduDt(MSFSharedUtils.allowNulls(bmMapModel.get("reymnScduDt")));    /** column 재고용예정일자 : reymnScduDt */
//    	psnl0100Dto.setLogSvcYrNumCd(MSFSharedUtils.allowNulls(bmMapModel.get("logSvcYrNumCd")));    /** column 근속년수코드 : logSvcYrNumCd */
//    	psnl0100Dto.setLogSvcMnthIcmCd(MSFSharedUtils.allowNulls(bmMapModel.get("logSvcMnthIcmCd")));    /** column 근속월수코드 : logSvcMnthIcmCd */
//    	psnl0100Dto.setCurrPyspAppmtDt(MSFSharedUtils.allowNulls(bmMapModel.get("currPyspAppmtDt")));    /** column 현_호봉발령일자 : currPyspAppmtDt */
//    	psnl0100Dto.setCurrDeptAppmtDt(MSFSharedUtils.allowNulls(bmMapModel.get("currDeptAppmtDt")));    /** column 현_부서발령일자 : currDeptAppmtDt */
//    	psnl0100Dto.setPyspGrdeCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyspGrdeCd")));    /** column 호봉등급코드 : pyspGrdeCd */
//    	psnl0100Dto.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuClsDivCd")));    /** column 직종세구분코드 : dtilOccuClsDivCd */
//    	psnl0100Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuInttnCd")));    /** column 직종세통합코드 : dtilOccuInttnCd */
//    	psnl0100Dto.setSecResnNum(MSFSharedUtils.allowNulls(bmMapModel.get("secResnNum")));    /** column 메인키 : secResnNum */
//    	psnl0100Dto.setLogSvcDys(MSFSharedUtils.allowNulls(bmMapModel.get("logSvcDys")));    /** column 근속일수 : logSvcDys */
//    	psnl0100Dto.setOrgLogSvcYrCd(MSFSharedUtils.allowNulls(bmMapModel.get("orgLogSvcYrCd")));    /** column 원근속년수코드 : orgLogSvcYrCd */
//    	psnl0100Dto.setOrgLogSvcMnthCd(MSFSharedUtils.allowNulls(bmMapModel.get("orgLogSvcMnthCd")));    /** column 원근속월수코드 : orgLogSvcMnthCd */
//    	psnl0100Dto.setOrgLogSvcDys(MSFSharedUtils.allowNulls(bmMapModel.get("orgLogSvcDys")));    /** column 원근속일수 : orgLogSvcDys */
//    	psnl0100Dto.setReMrkDt(MSFSharedUtils.allowNulls(bmMapModel.get("reMrkDt")));    /** column 재획정일자 : reMrkDt */
//    	psnl0100Dto.setLogStdDt(MSFSharedUtils.allowNulls(bmMapModel.get("logStdDt")));    /** column 근속기준일자 : logStdDt */
//    	psnl0100Dto.setTotLogSvcDys(MSFSharedUtils.allowNulls(bmMapModel.get("totLogSvcDys")));    /** column 총근속일수 : totLogSvcDys */
//    	psnl0100Dto.setOrgTotLogSvcDys(MSFSharedUtils.allowNulls(bmMapModel.get("orgTotLogSvcDys")));    /** column 원총근속일수 : orgTotLogSvcDys */
  		
  		
  		
//  		psnl0111Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
//  		psnl0111Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
//  		psnl0111Dto.setHusZpcd(MSFSharedUtils.allowNulls(bmMapModel.get("husZpcd")));    /** column 집우편번호 : husZpcd */
//  		psnl0111Dto.setHusFndtnAddr(MSFSharedUtils.allowNulls(bmMapModel.get("husFndtnAddr")));    /** column 집기본주소 : husFndtnAddr */
//  		psnl0111Dto.setHusDtlPatrAddr(MSFSharedUtils.allowNulls(bmMapModel.get("husDtlPatrAddr")));    /** column 집상세주소 : husDtlPatrAddr */
//  		psnl0111Dto.setHusRoadNmEngAddr(MSFSharedUtils.allowNulls(bmMapModel.get("husRoadNmEngAddr")));    /** column 집도로명영문주소 : husRoadNmEngAddr */
//  		psnl0111Dto.setWkOfcZpcd(MSFSharedUtils.allowNulls(bmMapModel.get("wkOfcZpcd")));    /** column 직장우편번호 : wkOfcZpcd */
//  		psnl0111Dto.setWkOfcFndtnAddr(MSFSharedUtils.allowNulls(bmMapModel.get("wkOfcFndtnAddr")));    /** column 직장기본주소 : wkOfcFndtnAddr */
//  		psnl0111Dto.setWkOfcDtlPatrAddr(MSFSharedUtils.allowNulls(bmMapModel.get("wkOfcDtlPatrAddr")));    /** column 직장상세주소 : wkOfcDtlPatrAddr */
//  		psnl0111Dto.setCmpyPhnNum(MSFSharedUtils.allowNulls(bmMapModel.get("cmpyPhnNum")));    /** column 회사전화번호 : cmpyPhnNum */
//  		psnl0111Dto.setCmpyFaxNum(MSFSharedUtils.allowNulls(bmMapModel.get("cmpyFaxNum")));    /** column 회사팩스번호 : cmpyFaxNum */
//  		psnl0111Dto.setCarNum(MSFSharedUtils.allowNulls(bmMapModel.get("carNum")));    /** column 차량번호 : carNum */
//  		psnl0111Dto.setCarMdl(MSFSharedUtils.allowNulls(bmMapModel.get("carMdl")));    /** column 차종 : carMdl */
//  		psnl0111Dto.setKybdr(MSFSharedUtils.allowNulls(bmMapModel.get("kybdr")));    /** column 입력자 : kybdr */
//  		psnl0111Dto.setInptDt(MSFSharedUtils.allowNulls(bmMapModel.get("inptDt")));    /** column 입력일자 : inptDt */
//  		psnl0111Dto.setInptAddr(MSFSharedUtils.allowNulls(bmMapModel.get("inptAddr")));    /** column 입력주소 : inptAddr */
//  		psnl0111Dto.setIsmt(MSFSharedUtils.allowNulls(bmMapModel.get("ismt")));    /** column 수정자 : ismt */
//  		psnl0111Dto.setRevnDt(MSFSharedUtils.allowNulls(bmMapModel.get("revnDt")));    /** column 수정일자 : revnDt */
//  		psnl0111Dto.setRevnAddr(MSFSharedUtils.allowNulls(bmMapModel.get("revnAddr")));    /** column 수정주소 : revnAddr */
//  		psnl0111Dto.setOldWkOfcZpcd(MSFSharedUtils.allowNulls(bmMapModel.get("oldWkOfcZpcd")));    /** column 직장변경전우편번호 : oldWkOfcZpcd */
    	
    	
    	
//    	psnl0110Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
//    	psnl0110Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
//    	psnl010002Dto.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuClsDivCd")));    /** column 직종세구분코드 : dtilOccuClsDivCd */
//    	psnl0110Dto.setEmymtSeilNum(MSFSharedUtils.allowNulls(bmMapModel.get("emymtSeilNum")));    /** column 고용일련번호 : emymtSeilNum */
//    	psnl0110Dto.setPayPymtDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("payPymtDivCd")));    /** column 급여지급구분코드 : payPymtDivCd */
//    	psnl0110Dto.setEmymtSum(MSFSharedUtils.allowNulls(bmMapModel.get("emymtSum")));    /** column 고용금액 : emymtSum */
//    	psnl0110Dto.setEmymtReasCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("emymtReasCtnt")));    /** column 비고내용 : emymtReasCtnt */
//    	psnl0110Dto.setCertNumHuhd(MSFSharedUtils.allowNulls(bmMapModel.get("certNumHuhd")));    /** column 증번호 : certNumHuhd */
//    	psnl0110Dto.setRducBgnnDt(MSFSharedUtils.allowNulls(bmMapModel.get("rducBgnnDt")));    /** column 경감시작일자 : rducBgnnDt */
//    	psnl0110Dto.setKybdr(MSFSharedUtils.allowNulls(bmMapModel.get("kybdr")));    /** column 입력자 : kybdr */
//    	psnl0110Dto.setInptDt(MSFSharedUtils.allowNulls(bmMapModel.get("inptDt")));    /** column 입력일자 : inptDt */
//    	psnl0110Dto.setInptAddr(MSFSharedUtils.allowNulls(bmMapModel.get("inptAddr")));    /** column 입력주소 : inptAddr */
//    	psnl0110Dto.setIsmt(MSFSharedUtils.allowNulls(bmMapModel.get("ismt")));    /** column 수정자 : ismt */
//    	psnl0110Dto.setRevnDt(MSFSharedUtils.allowNulls(bmMapModel.get("revnDt")));    /** column 수정일자 : revnDt */
//    	psnl0110Dto.setRevnAddr(MSFSharedUtils.allowNulls(bmMapModel.get("revnAddr")));    /** column 수정주소 : revnAddr */
//    	psnl0110Dto.setRducEndDt(MSFSharedUtils.allowNulls(bmMapModel.get("rducEndDt")));    /** column 경감종료일자 : rducEndDt */
//    	psnl0110Dto.setPyspGrdeCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyspGrdeCd")));    /** column 호봉등급코드 : pyspGrdeCd */

//    	psnl0110Dto.setCvsnRtoDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("cvsnRtoDivCd")));    /** column 환산비율구분코드 : cvsnRtoDivCd */
//    	psnl0110Dto.setDutyYrNum(MSFSharedUtils.allowNulls(bmMapModel.get("dutyYrNum")));    /** column 근속년수 : dutyYrNum */
//    	psnl0110Dto.setDutyMnthIcm(MSFSharedUtils.allowNulls(bmMapModel.get("dutyMnthIcm")));    /** column 근속월수 : dutyMnthIcm */
//    	psnl0110Dto.setDutyDayNum(MSFSharedUtils.allowNulls(bmMapModel.get("dutyDayNum")));    /** column 근속일수 : dutyDayNum */
//    	psnl0110Dto.setDutyTotDayNum(MSFSharedUtils.allowNulls(bmMapModel.get("dutyTotDayNum")));    /** column 근속전체일수 : dutyTotDayNum */
    	
    	
    	
//    	psnl0112Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
//    	psnl0112Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
//    	psnl0112Dto.setExmtnReasCtnt(MSFSharedUtils.allowNulls(bmMapModel.get("exmtnReasCtnt")));    /** column 면제사유내용 : exmtnReasCtnt */
//    	psnl0112Dto.setKybdr(MSFSharedUtils.allowNulls(bmMapModel.get("kybdr")));    /** column 입력자 : kybdr */
//    	psnl0112Dto.setInptDt(MSFSharedUtils.allowNulls(bmMapModel.get("inptDt")));    /** column 입력일자 : inptDt */
//    	psnl0112Dto.setInptAddr(MSFSharedUtils.allowNulls(bmMapModel.get("inptAddr")));    /** column 입력주소 : inptAddr */
//    	psnl0112Dto.setIsmt(MSFSharedUtils.allowNulls(bmMapModel.get("ismt")));    /** column 수정자 : ismt */
//    	psnl0112Dto.setRevnDt(MSFSharedUtils.allowNulls(bmMapModel.get("revnDt")));    /** column 수정일자 : revnDt */
//    	psnl0112Dto.setRevnAddr(MSFSharedUtils.allowNulls(bmMapModel.get("revnAddr")));    /** column 수정주소 : revnAddr */
//    	psnl0112Dto.setMityCarrLogSvcYrNumCd(MSFSharedUtils.allowNulls(bmMapModel.get("mityCarrLogSvcYrNumCd")));    /** column 군경력근속년수코드 : mityCarrLogSvcYrNumCd */
//    	psnl0112Dto.setMityCarrLogSvcMnthNumCd(MSFSharedUtils.allowNulls(bmMapModel.get("mityCarrLogSvcMnthNumCd")));    /** column 군경력근속월수코드 : mityCarrLogSvcMnthNumCd */
//    	psnl0112Dto.setMityCarrLogSvcDys(MSFSharedUtils.allowNulls(bmMapModel.get("mityCarrLogSvcDys")));    /** column 군경력근속일수 : mityCarrLogSvcDys */
//    	psnl0112Dto.setMityCarrTotLogSvcDys(MSFSharedUtils.allowNulls(bmMapModel.get("mityCarrTotLogSvcDys")));    /** column 군경력총근속일수 : mityCarrTotLogSvcDys */
//    	psnl0112Dto.setMityCarrTotSvcDys(MSFSharedUtils.allowNulls(bmMapModel.get("mityCarrTotSvcDys")));    /** column 군경력인정총일수 : mityCarrTotSvcDys */
//    	psnl0112Dto.setBefPyspCd(MSFSharedUtils.allowNulls(bmMapModel.get("befPyspCd")));    /** column 이전호봉코드 : befPyspCd */
//    	psnl0112Dto.setBefLogSvcYrCd(MSFSharedUtils.allowNulls(bmMapModel.get("befLogSvcYrCd")));    /** column 이전근속년수코드 : befLogSvcYrCd */
//    	psnl0112Dto.setBefLogSvcMnthCd(MSFSharedUtils.allowNulls(bmMapModel.get("befLogSvcMnthCd")));    /** column 이전근속월수코드 : befLogSvcMnthCd */
    	
    	
    	
//    	psnl0113Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
//    	psnl0113Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
//    	psnl0113Dto.setHusDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("husDivCd")));    /** column 주택구분코드 : husDivCd */
//    	psnl0113Dto.setHusSum(MSFSharedUtils.allowNulls(bmMapModel.get("husSum")));    /** column 주택금액 : husSum */
//    	psnl0113Dto.setRstPptySum(MSFSharedUtils.allowNulls(bmMapModel.get("rstPptySum")));    /** column 그외부동산금액 : rstPptySum */
//    	psnl0113Dto.setMvasstSum(MSFSharedUtils.allowNulls(bmMapModel.get("mvasstSum")));    /** column 동산금액 : mvasstSum */
//    	psnl0113Dto.setRidnDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("ridnDivCd")));    /** column 거주구분코드 : ridnDivCd */
//    	psnl0113Dto.setFamyAllwApptnYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("famyAllwApptnYrMnth")));    /** column 가족수당적용년월 : famyAllwApptnYrMnth */
//    	psnl0113Dto.setHlthInsrRegrstFlag(MSFSharedUtils.allowNulls(bmMapModel.get("hlthInsrRegrstFlag")));    /** column 건강보험신고_FLAG : hlthInsrRegrstFlag */
//    	psnl0113Dto.setNatPennRegrstFlag(MSFSharedUtils.allowNulls(bmMapModel.get("natPennRegrstFlag")));    /** column 국민연금신고_FLAG : natPennRegrstFlag */
//    	psnl0113Dto.setIdtlAccdtInsurRegrstFlag(MSFSharedUtils.allowNulls(bmMapModel.get("idtlAccdtInsurRegrstFlag")));    /** column 산재보험신고FLAG : idtlAccdtInsurRegrstFlag */
//    	psnl0113Dto.setUmytInsrRegrstFlag(MSFSharedUtils.allowNulls(bmMapModel.get("umytInsrRegrstFlag")));    /** column 고용보험신고FLAG : umytInsrRegrstFlag */
//    	psnl0113Dto.setKybdr(MSFSharedUtils.allowNulls(bmMapModel.get("kybdr")));    /** column 입력자 : kybdr */
//    	psnl0113Dto.setInptDt(MSFSharedUtils.allowNulls(bmMapModel.get("inptDt")));    /** column 입력일자 : inptDt */
//    	psnl0113Dto.setInptAddr(MSFSharedUtils.allowNulls(bmMapModel.get("inptAddr")));    /** column 입력주소 : inptAddr */
//    	psnl0113Dto.setIsmt(MSFSharedUtils.allowNulls(bmMapModel.get("ismt")));    /** column 수정자 : ismt */
//    	psnl0113Dto.setRevnDt(MSFSharedUtils.allowNulls(bmMapModel.get("revnDt")));    /** column 수정일자 : revnDt */
//    	psnl0113Dto.setRevnAddr(MSFSharedUtils.allowNulls(bmMapModel.get("revnAddr")));    /** column 수정주소 : revnAddr */
    	
   
	
		
	}
    
    private PsnlP010002 getThis() {
		return this;
	}
	
    
	/** 인사 기본 체크 **/
	private Boolean psnl0100CheckVal() {
		
		Boolean boolVal = true;

		if("".equals(mangeDeptCd.getValue()) || mangeDeptCd.getValue() == null) {
			MessageBox.alert("입력필수사항 확인", "관리부서를 입력해 주세요.", null);
			mangeDeptNm.focus();
			boolVal = false;
		}
		if("".equals(currAffnDeptCd.getValue()) || currAffnDeptCd.getValue() == null) {
			MessageBox.alert("입력필수사항 확인", "소속부서를 입력해 주세요.", null);
			currAffnDeptNm.focus();
			boolVal = false;
		}
		if("".equals(hanNm.getValue()) || hanNm.getValue() == null) {
			MessageBox.alert("입력필수사항 확인", "성명을 입력해 주세요.", null);
			hanNm.focus();
			boolVal = false;
		}
		if("".equals(resnRegnNum.getValue()) || resnRegnNum.getValue() == null) {
			MessageBox.alert("입력필수사항 확인", "주민등록번호를 입력해 주세요.", null);
			resnRegnNum.focus();
			boolVal = false;
		}
		if("".equals(hdofcCodtnCd.getValue()) || hdofcCodtnCd.getValue() == null) {
			MessageBox.alert("입력필수사항 확인", "재직구분을 입력해 주세요.", null);
			hdofcCodtnCd.focus();
			boolVal = false;
		}
		if("".equals(natnNm.getValue()) || natnNm.getValue() == null) {
			MessageBox.alert("입력필수사항 확인", "국가를 입력해 주세요.", null);
			natnNm.focus();
			boolVal = false;
		}
		
		return boolVal;
		
	}
	
	
	/** 인사 인적 체크 **/
	private Boolean psnl0111CheckVal() {
		
		Boolean boolVal = true;

		if("".equals(husRoadNmZpcd.getValue()) || husRoadNmZpcd.getValue() == null) {
			MessageBox.alert("입력필수사항 확인", "우편번호를 입력해 주세요.", null);
    		husRoadNmZpcd.focus();
    		boolVal = false;
		}
		if(MSFSharedUtils.paramNotNull(husRoadNmZpcd.getValue())) {
			if(husRoadNmZpcd.getValue().length() > 6) {
    			MessageBox.alert("오류", "도로명주소(우편번호) 입력범위를 초과하였습니다.(최대 5자 이내)", null);
    			husRoadNmZpcd.focus();
    			boolVal = false;
    		}
		}
		if("".equals(husRoadNmFndtnAddr.getValue()) || husRoadNmFndtnAddr.getValue() == null) {
			MessageBox.alert("입력필수사항 확인", "도로명주소를 입력해 주세요.", null);
			husRoadNmFndtnAddr.focus();
    		boolVal = false;
		}
		if(MSFSharedUtils.paramNotNull(psnl0111HusZpcd.getValue())) {
			if(psnl0111HusZpcd.getValue().length() > 7) {
    			MessageBox.alert("오류", "생활근거지(우편번호) 입력범위를 초과하였습니다.(최대 6자 이내)", null);
    			psnl0111HusZpcd.focus();
    			boolVal = false;
    		}
		}
		
		return boolVal;
		
	}
	
	
	/** 인사 고용 체크 **/
	private Boolean psnl0110CheckVal() {
		
		Boolean boolVal = true;
		
		
		String emymtDivCdStr = MSFSharedUtils.getSelectedComboValue(emymtDivCd, "commCd");
		String emymtTypCdStr = MSFSharedUtils.getSelectedComboValue(emymtTypCd, "commCd");
		String emymtBgnnDtStr = GWTUtils.getStringFromDate(emymtBgnnDt.getValue(), "yyyyMMdd");
		String emymtEndDtStr = GWTUtils.getStringFromDate(emymtEndDt.getValue(), "yyyyMMdd");
		
		String deptCdStr = deptCd.getValue();
		String typOccuCdStr = MSFSharedUtils.getSelectedComboValue(typOccuCd, "typOccuCd");	
		String dtilOccuInttnCdStr = MSFSharedUtils.getSelectedComboValue(dtilOccuInttnCd, "dtilOccuInttnCd");		
		String businCdStr = MSFSharedUtils.getSelectedComboValue(businCd, "businCd");
		
		String retryReasCtntStr = retryReasCtnt.getValue();
		
		
		
		if("PSNL0100".equals(formId.getValue()) || formId.getValue() == "PSNL0100") {
			
			
			//고용 저장시 null값 안들어가게끔 체크
			if(MSFSharedUtils.paramNull(emymtDivCdStr)) {
				MessageBox.alert("입력필수사항 확인", "고용구분을 선택하여주세요.", null);
				emymtDivCd.focus();
				boolVal = false;
			}
			if(MSFSharedUtils.paramNull(emymtTypCdStr)) {
				MessageBox.alert("입력필수사항 확인", "고용유형을 선택하여주세요.", null);
				emymtTypCd.focus();
				boolVal = false;
			}
			if(MSFSharedUtils.paramNull(emymtBgnnDtStr)) {
				MessageBox.alert("입력필수사항 확인", "시작일자를 선택하여주세요.", null);
				emymtBgnnDt.focus();
				boolVal = false;
			}
			if(MSFSharedUtils.paramNull(deptCdStr)) {
				MessageBox.alert("입력필수사항 확인", "부서를 선택하여주세요.", null);
				deptNm.focus();
				boolVal = false;
			}
				
			// 신규A0420010, 직제개편A0420050, 전보A0420060, 복직A0420070
			if("A0420010".equals(emymtTypCdStr) || 
				"A0420050".equals(emymtTypCdStr) ||
				"A0420060".equals(emymtTypCdStr) ||
				"A0420070".equals(emymtTypCdStr)) {
				
				if(MSFSharedUtils.paramNull(typOccuCdStr)) {
					MessageBox.alert("입력필수사항 확인", "직종을 선택하여주세요.", null);
					typOccuCd.focus();
					boolVal = false;
				}else if(MSFSharedUtils.paramNull(dtilOccuInttnCdStr)) {
					MessageBox.alert("입력필수사항 확인", "직종세를 선택하여주세요.", null);
					dtilOccuInttnCd.focus();
					boolVal = false;
				}
			}
			
			// 퇴직 A0420990
			if("A0420990".equals(emymtTypCdStr) ) {
					
				if(MSFSharedUtils.paramNull(retryReasCtntStr)) {
					MessageBox.alert("입력필수사항 확인", "퇴직시에 퇴직사유내용을 입력해주세요.", null);
					retryReasCtnt.focus();
					boolVal = false;
				}else if(MSFSharedUtils.paramNull(retryReasCtntStr)) {
					MessageBox.alert("입력필수사항 확인", "퇴직시에 퇴직사유구분을 선택하여주세요.", null);
					retryReasCtnt.focus();
					boolVal = false;
				}
			}else{
				
				if(!MSFSharedUtils.paramNull(retryReasCtntStr)) {
					MessageBox.alert("경고", "퇴직외에 퇴직사유내용을 입력불가합니다.", null);
					retryReasCtnt.focus();
					boolVal = false;
				}else if(!MSFSharedUtils.paramNull(retryReasCtntStr)) {
					MessageBox.alert("경고", "퇴직외에 퇴직사유구분을 선택불가합니다.", null);
					retryReasCtnt.focus();
					boolVal = false;
				}
			}
			
		}else{
			
			// 고용 저장시 필수 입력사항 누락 방어 로직 부분
			if(MSFSharedUtils.paramNull(emymtDivCdStr)) {
				MessageBox.alert("입력필수사항 확인", "고용구분을 선택하여주세요.", null);
				emymtDivCd.focus();
				boolVal = false;
			}else if(MSFSharedUtils.paramNull(emymtTypCdStr)) {
				MessageBox.alert("입력필수사항 확인", "고용유형을 선택하여주세요.", null);
				emymtTypCd.focus();
				boolVal = false;
			}else if(MSFSharedUtils.paramNull(emymtBgnnDtStr)) {
				emymtBgnnDt.focus();
				MessageBox.alert("입력필수사항 확인", "시작일자를 선택하여주세요.", null);
				boolVal = false;
			}else if(MSFSharedUtils.paramNull(emymtEndDtStr)) {
				// 휴직, 퇴직, 복직일 경우를 제외하고는 종료일자를 입력하도록 한다.
				if("A0420040".equals(emymtTypCdStr)		// 휴직
					|| "A0420990".equals(emymtTypCdStr)	// 퇴직
					|| "A0420070".equals(emymtTypCdStr)) {	// 복직
				
				}else {
					MessageBox.alert("입력필수사항 확인", "종료일자를 선택하여주세요.", null);
					emymtEndDt.focus();
					boolVal = false;
				}
			}else if(MSFSharedUtils.paramNull(deptCdStr)) {
				MessageBox.alert("입력필수사항 확인", "부서를 선택하여주세요.", null);
				deptCd.focus();
				boolVal = false;
			}else if(MSFSharedUtils.paramNull(businCdStr)) {
				MessageBox.alert("입력필수사항 확인", "사업을 선택하여주세요.", null);
				businCd.focus();
				boolVal = false;
			}
			
		}
		
		
		return boolVal;
		
	}
	
	
	
	
	
	
	
}
