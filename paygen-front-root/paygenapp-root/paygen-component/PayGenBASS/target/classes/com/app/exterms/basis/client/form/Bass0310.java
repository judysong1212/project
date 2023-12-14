/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 *
 * http://visionit.kr
 *
 */
package com.app.exterms.basis.client.form;


import java.util.Date;
import java.util.HashMap;

import com.app.exterms.basis.client.dto.Psnl2100DTO;
import com.app.exterms.basis.client.form.defs.Psnl2100Def;
import com.app.exterms.basis.client.languages.BasisConstants;
import com.app.exterms.basis.client.service.Bass0310Service;
import com.app.exterms.basis.client.service.Bass0310ServiceAsync;
import com.app.exterms.basis.client.utils.BasisUtil;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.GregorianCalendar;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormWindows;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.MSFComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFDateField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFNumberField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTextField;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FormEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
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
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Encoding;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Method;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.Validator;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;


/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow {
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
/**
* <pre>
* 1. 패키지명 : com.app.exterms.basis.client.form
* 2. 타입명 : Bass0310.java
* 3. 작성일 : Nov 22, 2015 9:12:30 AM
* 4. 작성자 : leeheuisung
* 5. 설명 :
* </pre>
*/
public class Bass0310  extends MSFPanel {
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * 	전역변수 선언부  시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 **/
	private BasisConstants lblBasisConst = BasisConstants.INSTANCE;

	private VerticalPanel vp;
	private FormPanel plFrmBass0310;
	private String txtForm = "";
	private XTemplate detailTp;
	private BaseModel record;
	// private MSFCustomForm msfCustomForm;

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
    private FieldSet fieldSetStdFrm; 
    private FieldSet copyFieldset;
    
    /**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 입력 변수 선언
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */
    //---------------상세정보 시작----------------
    private HiddenField<String> dpobCd;   				//사업장코드
    private MSFNumberField hodyNumDysSeilNum;    		//휴가일수일련번호
    private HiddenField<String>	pyspGrdeCd;				/** column 호봉등급코드 : pyspGrdeCd */
    private HiddenField<String>	hodyNumDysFrmCd;		/** column 휴가일수유형코드 : hodyNumDysFrmCd */
    private HiddenField<String> dtilOccuInttnCd;    	//직종세 통합코드
    private MSFComboBox<BaseModel> dtilOccuClsDivCd;	// 직종세구분코드
    private MSFComboBox<BaseModel> typOccuCd; 			//직종코드
    private MSFNumberField hodyNumDys;					//휴가일수
    private MSFDateField hodyNumDysBgnnDt;				//시작일자
    private MSFDateField hodyNumDysEndDt;				//종료일자
    private CheckBoxGroup dtilOccuClsUseGrp; 			//체크박스그룹
    private CheckBox hodyNumDysUseYn;             	 	//휴가일수 사용여부
    private MSFNumberField hodyNumDysOvr;    			//근속년수 이상
    private MSFNumberField hodyNumDysUdr;   			//근속년수 미만
    private MSFTextField hodyNumDysNoteCtnt;			//휴가일수 비고내용
    // -------------- 상세정보 종료 --------------
    
    // -------------- 직종세 복사 시작 --------------
    private ComboBox<BaseModel> basicDtilOccuClsDivCd;	// 기본직종세구분코드
    private ComboBox<BaseModel> basicTypOccuCd; 			// 기본직종코드
    private ComboBox<BaseModel> targetDtilOccuClsDivCd;	// 대상직종세구분코드
    private ComboBox<BaseModel> targetTypOccuCd; 		//대상직종코드
    private DateField applicationDate;				//적용일자
    private Button btnBass0310Copy;		// 복사 버튼
    private Button btnBass0310CopyPkg;	// 일관 복사 버튼
    // -------------- 직종세 복사 종료 --------------

    private Date today = new Date();		// 오늘 날짜 가져오는 코드
    private BaseModel bmData = new BaseModel();	//외부에서 사용하기 위하여 bmData를 선언한다. RowClick에서 사용되며 상세조건 이벤트에서도 적용된다. 

 // -------------- grid 선언 시작 --------------
  	private Psnl2100Def psnl2100Def  = new Psnl2100Def();   //그리드 테이블 컬럼 define
    private MSFGridPanel psnl2100GridPanel;					//그리드 판넬
    
    //파일업로드처리 부분  
    private FileUploadField bass0310flUp;
    private Boolean picBoolFile;
    // -------------- grid 선언 종료 --------------

    // -------------- 상위 버튼 선언 시작 --------------
    private ButtonBar topBass0310Bar;	 
    private Button btnBass0310New;		// 생성 버튼
    private Button btnBass0310Save;		// 수정 버튼
    private Button btnBass0310Del;		// 삭제 버튼
    private Button btnBass0310Sreach;	// 조회 버튼
    // -------------- 상위 버튼 선언 종료 --------------

    // -------------- store 선언 시작 --------------
    private ListStore<BaseModel>  lsTypOccuCd = new ListStore<BaseModel>();			//직종 검색
    private ListStore<BaseModel>  lsDtilOccuInttnCd = new ListStore<BaseModel>();	//직종세 검색
    private ListStore<BaseModel>  stTypOccuCd = new ListStore<BaseModel>();			//직종 상세
    private ListStore<BaseModel>  stDtilOccuInttnCd = new ListStore<BaseModel>();	//직종세 상세
    private ListStore<BaseModel>  lsPyspGrdeCd = new ListStore<BaseModel>();		//호봉등급
    // -------------- store 선언 종료 --------------

  	// -------------- 공통코드 선언 시작 --------------
    private PrgmComBass0300DTO sysComBass0300Dto;
    private PrgmComBass0320DTO sysComBass0320Dto;
    private PrgmComBass0350DTO sysComBass0350Dto;
    // -------------- 공통코드 선언 종료--------------


  	// -------------- 검색조건 시작 --------------
  	private ComboBox<BaseModel> srhTypOccuCd;   		//직종
  	private ComboBox<BaseModel> srhDtilOccuInttnCd;		//직종세통합코드
  	private CheckBoxGroup srhHodyNumDysUseGrp; 			//체크박스그룹
    private CheckBox srhHodyNumDysUseYn;             	//휴가일수 사용여부
  	
  	// -------------- 검색조건 종료 --------------
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * 	전역변수 선언부 끝
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 **/


/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * 	Rpc Service 선언부 시작 
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 **/

    
  	private Bass0310ServiceAsync bass0310Service = Bass0310Service.Util.getInstance();	//Service 싱크



  	/**
  	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
  	 * 선택된 버튼에 따른 인서트 업데이트 삭제 처리 부
  	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
  	 */
  	
  	/** 버튼 이벤트 */
  	private SelectionListener<ButtonEvent> selectionListener = new SelectionListener<ButtonEvent>() {
  		public void componentSelected(ButtonEvent ce) {
  			if (ce.getButton() == btnBass0310Save) {
				if((ActionDatabase.INSERT).equals(actionDatabase)) {
					doAction(ActionDatabase.INSERT);
					actionDatabase = ActionDatabase.UPDATE;
				}else {
					doAction(ActionDatabase.UPDATE);
				}
				//actionDatabase = null;
			}else if (ce.getButton() == btnBass0310Del) {
				doAction(ActionDatabase.DELETE);
			}
        }
	};
	
	/** ComboBox 선택 이벤트_검색조건 */
	private SelectionChangedListener<BaseModel> selectionChangeListener = new SelectionChangedListener<BaseModel>() {
        public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
        	//직종변경에 따른 직종세 값 가져오기
        	String strTypOccuCd =  MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd") ;
            if (MSFSharedUtils.paramNotNull(strTypOccuCd)) { 
                  sysComBass0350Dto.setTypOccuCd(strTypOccuCd);	
                  sysComBass0350Dto.setDtilOccuClsUseYn("Y");
					if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {	
						lsDtilOccuInttnCd = PrgmComComboUtils.getSingleNonBass0350ComboData(sysComBass0350Dto);
						srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd);
                }
            }
        }
    };
    
    /** ComboBox 선택 이벤트_상세조건 */
    private SelectionChangedListener<BaseModel> selectionChangeListener2 = new SelectionChangedListener<BaseModel>() {
        public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
        	//직종변경에 따른 직종세 값 가져오기
        	String strTypOccuCd2 =  MSFSharedUtils.getSelectedComboValue(typOccuCd,"typOccuCd") ;
            if (MSFSharedUtils.paramNotNull(strTypOccuCd2)) { 
                  sysComBass0350Dto.setTypOccuCd(strTypOccuCd2);	
                  sysComBass0350Dto.setDtilOccuClsUseYn("Y");
                  if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {	
                	  stDtilOccuInttnCd = PrgmComComboUtils.getSingleNonBass0350ComboData(sysComBass0350Dto);
                	  dtilOccuClsDivCd.setStore(stDtilOccuInttnCd);	
                	  /** 이벤트를 묶어서 직종세를 바로 불러오지 못하는 경우를 없애는 방법 */                	  
                	  stDtilOccuInttnCd.addStoreListener( new StoreListener<BaseModel>() { 							
                		  public void handleEvent(StoreEvent<BaseModel> be) {  
                			  EventType type = be.getType();
                			  if (type == Store.Add) { 
                				  /** UPDATA일 경우에만 진행하고 bmData가 null인 경우 실행하지 않는다. */
						    	  if((ActionDatabase.UPDATE).equals(actionDatabase)){
						    		  if(bmData == null){
						    			  MessageBox.info("", "Data를 불러오지 못합니다. 다시 확인해 주세요.", null);
						    		  	}else{
						    		  		BasisUtil.setSelectedComboValue(dtilOccuClsDivCd, (String)bmData.get("dtilOccuInttnCd$dtilOccuInttnCd"),"dtilOccuInttnCd"); /** column 직종세구분코드 : dtilOccuClsDivCd */
						    			}
						    	  }
						      }
                		  }
                	  }); 					
                  }
            }
        }
    };
    
    /** ComboBox 선택 이벤트_기본직종 */
    private SelectionChangedListener<BaseModel> selectionChangeListener3 = new SelectionChangedListener<BaseModel>() {
        public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
        	//직종변경에 따른 직종세 값 가져오기
        	String strTypOccuCd3 =  MSFSharedUtils.getSelectedComboValue(basicTypOccuCd,"typOccuCd") ;
            if (MSFSharedUtils.paramNotNull(strTypOccuCd3)) { 
                  sysComBass0350Dto.setTypOccuCd(strTypOccuCd3);
                  sysComBass0350Dto.setDtilOccuClsUseYn("Y");
                  if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {	
                	  lsDtilOccuInttnCd = PrgmComComboUtils.getSingleNonBass0350ComboData(sysComBass0350Dto);
                	  basicDtilOccuClsDivCd.setStore(lsDtilOccuInttnCd);					
                  }
            }
        }
    };  
    
    /** ComboBox 선택 이벤트_대상직종 */
    private SelectionChangedListener<BaseModel> selectionChangeListener4 = new SelectionChangedListener<BaseModel>() {
        public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
        	//직종변경에 따른 직종세 값 가져오기
        	String strTypOccuCd4 =  MSFSharedUtils.getSelectedComboValue(targetTypOccuCd,"typOccuCd") ;
            if (MSFSharedUtils.paramNotNull(strTypOccuCd4)) { 
                  sysComBass0350Dto.setTypOccuCd(strTypOccuCd4);
                  sysComBass0350Dto.setDtilOccuClsUseYn("Y");
                  if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {	
                	  lsDtilOccuInttnCd = PrgmComComboUtils.getSingleNonBass0350ComboData(sysComBass0350Dto);
                	  targetDtilOccuClsDivCd.setStore(lsDtilOccuInttnCd);					
                  }
            }
        }
    };
    
	private void doAction(ActionDatabase actionDatabase) {
		save(actionDatabase);
	}

	public void save(final ActionDatabase actionDatabase){

		final Psnl2100DTO  dto = new Psnl2100DTO();

    	if( "".equals(BasisUtil.getSelectedComboValue(typOccuCd,"typOccuCd")) ){
			MessageBox.info("", "직종을 선택하여 주세요.", null);
		}else if(GregorianCalendar.compareDate(hodyNumDysBgnnDt.getValue(), hodyNumDysEndDt.getValue()) < 0){
			MessageBox.info("", "기간 설정이 잘못되었습니다. 확인하십시요.", null);  
		}else if((Long)hodyNumDys.getValue() < 0 || (Long)hodyNumDysOvr.getValue() < 0 || (Long)hodyNumDysUdr.getValue() < 0 ){
			MessageBox.info("", "잘 못 입력하셨습니다. 다시 입력해 주세요.", null);
		}else{

			dto.setDpobCd(MSFMainApp.get().getUser().getDpobCd());						//사업장코드
			dto.setTypOccuCd(BasisUtil.getSelectedComboValue(typOccuCd,"typOccuCd"));	//직종코드
			//dto.setPyspGrdeCd((String)pyspGrdeCd.getValue());		//호봉등급
			//dto.setHodyNumDysFrmCd((String)hodyNumDysFrmCd.getValue());		//휴가일수코드
			//dto.setDtilOccuInttnCd((String)dtilOccuInttnCd.getValue());		//직종세 통합코드
			dto.setDtilOccuClsDivCd(BasisUtil.getSelectedComboValue(dtilOccuClsDivCd,"dtilOccuInttnCd"));	//직종세구분코드
			dto.setHodyNumDysBgnnDt(BasisUtil.getConvertDateToString(hodyNumDysBgnnDt, "yyyyMMdd"));	//시작일자
			dto.setHodyNumDysEndDt(BasisUtil.getConvertDateToString(hodyNumDysEndDt, "yyyyMMdd"));	//종료일자

			dto.setHodyNumDys((Long)hodyNumDys.getValue()); //휴가일수
			//Window.alert(""+hodyNumDysSeilNum.getValue());
			dto.setHodyNumDysSeilNum((Long)hodyNumDysSeilNum.getValue());	//휴가일수일련번호
			dto.setHodyNumDysUseYn((Boolean)hodyNumDysUseYn.getValue());		//사용여부
			dto.setHodyNumDysOvr((Long)hodyNumDysOvr.getValue());	//휴가일수이상
			dto.setHodyNumDysUdr((Long)hodyNumDysUdr.getValue());	//휴가일수미만
			dto.setHodyNumDysNoteCtnt(hodyNumDysNoteCtnt.getValue());

			MessageBox.confirm("","DELETE".equals(actionDatabase.name()) ? "삭제 하시겠습니까?" : "저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
				@Override
				public void handleEvent(MessageBoxEvent be) {
					
					if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
						bass0310Service.saveBass0310(dto, actionDatabase, new AsyncCallback<Long>() {
							@Override
							public void onSuccess(Long result) {
								if("DELETE".equals(actionDatabase.name())){
									MessageBox.info("", "삭제 되었습니다.", null);
								}else{
									MessageBox.info("", "저장 되었습니다.", null);
								}
								reload();
							}
							@Override
							public void onFailure(Throwable caught) {
								caught.printStackTrace();
								MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),
				                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnBass0310(" + actionDatabase.name() + ") : " + caught)
				                        , null);
							}
						});
					}
				}
			});
		}



	}
	
	public void copy(final ActionDatabase actionDatabase){

		final Psnl2100DTO  dto = new Psnl2100DTO();

    	if( "".equals(BasisUtil.getSelectedComboValue(basicTypOccuCd,"typOccuCd")) || 
    			"".equals(BasisUtil.getSelectedComboValue(targetTypOccuCd,"typOccuCd")) ){
			MessageBox.info("", "직종을 선택하여 주세요.", null);
		}else if("".equals(BasisUtil.getSelectedComboValue(basicDtilOccuClsDivCd,"dtilOccuInttnCd")) || 
				"".equals(BasisUtil.getSelectedComboValue(targetDtilOccuClsDivCd,"dtilOccuInttnCd"))){
			MessageBox.info("", "직종세를 선택하여 주세요.", null);  
		}else{
			dto.setDpobCd(MSFMainApp.get().getUser().getDpobCd());						//사업장코드
			dto.setBasicTypOccuCd(BasisUtil.getSelectedComboValue(basicTypOccuCd,"typOccuCd"));	//기본 직종코드
			dto.setBasicDtilOccuClsDivCd(BasisUtil.getSelectedComboValue(basicDtilOccuClsDivCd,"dtilOccuInttnCd"));	//기본 직종세구분코드
			dto.setTargetTypOccuCd(BasisUtil.getSelectedComboValue(targetTypOccuCd,"typOccuCd"));	//대상 직종코드	
			dto.setTargetDtilOccuClsDivCd(BasisUtil.getSelectedComboValue(targetDtilOccuClsDivCd,"dtilOccuInttnCd"));	//대상 직종세코드
			dto.setApplicationDate(BasisUtil.getConvertDateToString(applicationDate, "yyyyMMdd"));
			
			MessageBox.confirm("","복사 하시겠습니까?",new Listener<MessageBoxEvent>(){
				@Override
				public void handleEvent(MessageBoxEvent be) {
					
					if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
						bass0310Service.copyBass0310(dto, actionDatabase, new AsyncCallback<Long>() {
							@Override
							public void onSuccess(Long result) {								
								MessageBox.info("", "복사 되었습니다.", null);								
								reload();
							}
							@Override
							public void onFailure(Throwable caught) {
								caught.printStackTrace();
								MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),
				                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnBass0310(" + actionDatabase.name() + ") : " + caught)
				                        , null);
							}
						});
					}
				}
			});
		}

	}



/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * 	Rpc Service 선언부 끝
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 **/


/**
 *#############################################################################
 * 프로그램 시작
 *#############################################################################
 **/

	public ContentPanel getViewPanel(){
		if(panel == null){

			detailTp = XTemplate.create(getDetailTemplate());
			
			vp = new VerticalPanel();
			vp.setSpacing(10);
			//엣지변환
			//vp.setSize("1010px", "700px"); 
			vp.setSize("1010px", "750px"); 
			createBass0310Form();  	//화면 기본정보를 설정
			createSearchForm();    	//검색필드를 적용
			createCopyGrid();		//휴가일수 복사
			createListGrid();		//휴가일수정보 그리드
			createStandardForm();    //기본정보필드	
			createExcelForm();		//엑셀업로드

			panel = new ContentPanel();
		    panel.setBodyBorder(false);
		    panel.setBorders(false);
		    panel.setHeaderVisible(false);
		    panel.setScrollMode(Scroll.AUTO);
		    panel.add(vp);
		}
		return panel;
	}

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
	  * @wbp.parser.constructor
	  */
	public Bass0310() {
		//엣지변환
		//setSize("1010px", "700px");
		setSize("1010px", "750px");
	}

 	public Bass0310(String txtForm) {
		this.txtForm = txtForm;
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

	private void createBass0310Form() {

		plFrmBass0310 = new FormPanel();
		plFrmBass0310.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 휴가일수관리"));
		plFrmBass0310.setIcon(MSFMainApp.ICONS.text());
		plFrmBass0310.setBodyStyleName("pad-text");
		plFrmBass0310.setFrame(true); 				
		//plFrmBass0310.setSize("990px", "680px");
		//엣지변환
		plFrmBass0310.setSize("990px", "730px");

		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출
		 ************************************************************************/
		final Button btnlogView = new Button("로그");
	
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드
				  funcLogMessage("휴가일수관리","BASS0310");
				}
			});
		plFrmBass0310.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmBass0310.getHeader().addTool(btnlogView);
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가
		 ************************************************************************/
	
	
		plFrmBass0310.setPadding(2);
		
	
		topBass0310Bar = new ButtonBar();
		topBass0310Bar.setAlignment(HorizontalAlignment.RIGHT);
	
		
		//신규
		btnBass0310New = new Button("신규");
		btnBass0310New.setIcon(MSFMainApp.ICONS.new16());
		topBass0310Bar.add(btnBass0310New);
		btnBass0310New.addListener(Events.Select, new Listener<ButtonEvent>() {
	    	public void handleEvent(ButtonEvent e) {
	    		//초기화 버튼 클릭시 처리
	    		formBass0310Init();
	    		actionDatabase = ActionDatabase.INSERT;
	    		}
	    });
		//저장 -신규/수정 동시 처리 부분으로 나뉨
		btnBass0310Save = new Button("저장");
		btnBass0310Save.setIcon(MSFMainApp.ICONS.save16());
		topBass0310Bar.add(btnBass0310Save);
		btnBass0310Save.addSelectionListener(selectionListener);
	
		//삭제
		btnBass0310Del = new Button("삭제");
		btnBass0310Del.setIcon(MSFMainApp.ICONS.delete16());
		topBass0310Bar.add(btnBass0310Del);
		//btnBass0310Del.addSelectionListener(selectionListener);
		btnBass0310Del.addListener(Events.Select, new Listener<ButtonEvent>() {
	        public void handleEvent(ButtonEvent e) {
	            //조회버튼 클릭시 처리
	            actionDatabase = ActionDatabase.DELETE;
	            save(actionDatabase);
	        }
	    });
	
	
		//검색
		btnBass0310Sreach = new Button("조회");
		btnBass0310Sreach.setIcon(MSFMainApp.ICONS.search16());
		topBass0310Bar.add(btnBass0310Sreach);
		btnBass0310Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
	        public void handleEvent(ButtonEvent e) {
	            //조회버튼 클릭시 처리
	            reload();
	        }
	    });
	
	
		plFrmBass0310.add(topBass0310Bar);
	
		//파일업로드 처리
	//	plFrmBass0310.setAction("myurl");
	//	plFrmBass0310.setEncoding(Encoding.MULTIPART);
	//	plFrmBass0310.setMethod(Method.POST);
	
		vp.add(plFrmBass0310);
		//plFrmBass0310.setSize("990px", "680px"); 
	}


/**
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 검색 함수 선언부 시작
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 **/
	private void createSearchForm() {

       sysComBass0300Dto = new PrgmComBass0300DTO();
       sysComBass0320Dto = new PrgmComBass0320DTO();
       sysComBass0350Dto = new PrgmComBass0350DTO();
       //--------------------공통 코드 불러 오는 함수 -------------------------------------------

       lsTypOccuCd = new ListStore<BaseModel>();
       lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto);

       lsDtilOccuInttnCd = new ListStore<BaseModel>();
       lsDtilOccuInttnCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto);
       
       sysComBass0300Dto.setRpsttvCd("A006");
       sysComBass0300Dto.setMangeItem03("Y");

	   //--------------------공통 코드 불러 오는 함수 -------------------------------------------


        plFrmBass0310.setLayout(new FlowLayout());

        FieldSet fieldSet = new FieldSet();
        fieldSet.setHeadingHtml("검색조건");
        /****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 시작
		 ****************************************************************/
		fieldSet.addStyleName("x-fieldset-serarch-back-color");
		/****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 끝
		 ****************************************************************/

        LayoutContainer lcSchCol = new LayoutContainer();
        lcSchCol.setLayout(new ColumnLayout());

        LayoutContainer  lcSchColLeft= new LayoutContainer();
        FormLayout frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(70);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        lcSchColLeft.setLayout(frmlytSch);
        
        LayoutContainer lcSchColCenter= new LayoutContainer();
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(70);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        lcSchColCenter.setLayout(frmlytSch);
        
        LayoutContainer lcSchColRight= new LayoutContainer();
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(70);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        lcSchColRight.setLayout(frmlytSch);

        /** column 직종 : typOccuCd */
        srhTypOccuCd = new ComboBox<BaseModel>();
        srhTypOccuCd.setName("srhTypOccuCd");
        srhTypOccuCd.setForceSelection(true);
        srhTypOccuCd.setMinChars(1);
        srhTypOccuCd.setDisplayField("typOccuNm");
        srhTypOccuCd.setValueField("typOccuCd");
        srhTypOccuCd.setTriggerAction(TriggerAction.ALL);
        srhTypOccuCd.setEmptyText("--직종선택--");
        srhTypOccuCd.setSelectOnFocus(true);
        srhTypOccuCd.setReadOnly(false);
        srhTypOccuCd.setEnabled(true);
        srhTypOccuCd.setStore(lsTypOccuCd);
        srhTypOccuCd.setFieldLabel("직 종");
        srhTypOccuCd.addSelectionChangedListener(selectionChangeListener);
        lcSchColLeft.add(srhTypOccuCd, new FormData("100%"));
        lcSchColLeft.setBorders(false);

        srhDtilOccuInttnCd = new ComboBox<BaseModel>();
        srhDtilOccuInttnCd.setName("srhDtilOccuInttnCd");
        srhDtilOccuInttnCd.setForceSelection(true);
        srhDtilOccuInttnCd.setMinChars(1);
        srhDtilOccuInttnCd.setDisplayField("dtilOccuClsNm");
        srhDtilOccuInttnCd.setValueField("dtilOccuInttnCd");
        srhDtilOccuInttnCd.setTriggerAction(TriggerAction.ALL);
        srhDtilOccuInttnCd.setEmptyText("--직종세선택--");
        srhDtilOccuInttnCd.setSelectOnFocus(true);
        srhDtilOccuInttnCd.setReadOnly(false);
        srhDtilOccuInttnCd.setEnabled(true);
        srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd);
        srhDtilOccuInttnCd.setFieldLabel("직종세");
        lcSchColCenter.add(srhDtilOccuInttnCd, new FormData("100%"));
        lcSchColCenter.setBorders(false);

        srhHodyNumDysUseGrp = new CheckBoxGroup();
        srhHodyNumDysUseGrp.setName("srhHodyNumDysUseGrp");
        srhHodyNumDysUseGrp.setLabelSeparator("");
		
        srhHodyNumDysUseYn = new CheckBox();
        srhHodyNumDysUseYn.setName("srhHodyNumDysUseYn");
        srhHodyNumDysUseYn.setBoxLabel("사용여부");
        srhHodyNumDysUseYn.setValue(true);
        srhHodyNumDysUseGrp.add(srhHodyNumDysUseYn);
		srhHodyNumDysUseYn.setHideLabel(true);
		lcSchColRight.add(srhHodyNumDysUseGrp, new FormData("100%"));
        lcSchColRight.setBorders(false);

        lcSchCol.add(lcSchColLeft, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
        lcSchCol.add(lcSchColCenter, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
        lcSchCol.add(lcSchColRight, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));

        fieldSet.add(lcSchCol);

        plFrmBass0310.add(fieldSet);
        //vp.add(panel);
      }
/**
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 검색 함수 선언부 종료
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 **/
	
/**
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 휴가일수 복사 함수 선언부 시작
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * **/
	private void createCopyGrid() {
		
        
		sysComBass0320Dto = new PrgmComBass0320DTO();
	
		lsTypOccuCd = new ListStore<BaseModel>();
		lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto);

		lsDtilOccuInttnCd = new ListStore<BaseModel>();
		lsDtilOccuInttnCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto);
    
		copyFieldset = new FieldSet();	
		copyFieldset.setHeadingHtml("생성");
		copyFieldset.setStyleAttribute("marginTop", "10px");
		
		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new ColumnLayout());
				
		LayoutContainer layoutLeftContainer = new LayoutContainer();
		layoutLeftContainer.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(60); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
		layoutLeftContainer.setLayout(frmlytSch);
		layoutLeftContainer.setBorders(false);
		
		LayoutContainer layoutCenterContainer = new LayoutContainer();
		layoutCenterContainer.setStyleAttribute("paddingRight", "10px");
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(70); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
		layoutCenterContainer.setLayout(frmlytSch);
		layoutCenterContainer.setBorders(false);
		
		LayoutContainer layoutCenterContainer2 = new LayoutContainer();
		layoutCenterContainer2.setStyleAttribute("paddingRight", "10px");
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(70); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
		layoutCenterContainer2.setLayout(frmlytSch);
		layoutCenterContainer2.setBorders(false);
		
		LayoutContainer layoutRightContainer = new LayoutContainer();
		layoutRightContainer.setStyleAttribute("paddingRight", "10px");
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(70); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
		layoutRightContainer.setLayout(frmlytSch);
		layoutRightContainer.setBorders(false);
				
		basicTypOccuCd = new ComboBox<BaseModel>();
		basicTypOccuCd.setName("basicTypOccuCd");
		basicTypOccuCd.setFieldLabel("기본직종");
		basicTypOccuCd.setForceSelection(true);				 
		basicTypOccuCd.setMinChars(1);
		basicTypOccuCd.setDisplayField("typOccuNm");
		basicTypOccuCd.setValueField("typOccuCd");
		basicTypOccuCd.setTriggerAction(TriggerAction.ALL);
		basicTypOccuCd.setEmptyText("--직종선택--");
		basicTypOccuCd.setSelectOnFocus(true);
		basicTypOccuCd.setReadOnly(false);
		basicTypOccuCd.setEnabled(true);
		basicTypOccuCd.setStore(lsTypOccuCd);
		basicTypOccuCd.addSelectionChangedListener(selectionChangeListener3);
		layoutLeftContainer.add(basicTypOccuCd, new FormData("100%"));
				 
		basicDtilOccuClsDivCd = new ComboBox<BaseModel>();
		basicDtilOccuClsDivCd.setName("basicDtilOccuClsDivCd");
		basicDtilOccuClsDivCd.setFieldLabel("기본직종세");
		basicDtilOccuClsDivCd.setForceSelection(true);
		basicDtilOccuClsDivCd.setMinChars(1);
		basicDtilOccuClsDivCd.setDisplayField("dtilOccuClsNm");
		basicDtilOccuClsDivCd.setValueField("dtilOccuInttnCd");
		basicDtilOccuClsDivCd.setTriggerAction(TriggerAction.ALL);
		basicDtilOccuClsDivCd.setEmptyText("--직종세선택--");
		basicDtilOccuClsDivCd.setSelectOnFocus(true);
		basicDtilOccuClsDivCd.setReadOnly(false);
		basicDtilOccuClsDivCd.setEnabled(true);
		basicDtilOccuClsDivCd.setStore(lsDtilOccuInttnCd);	//효율적인 방안 셍각  new ListStore<BaseModel>()
		layoutCenterContainer.add(basicDtilOccuClsDivCd, new FormData("100%"));
		
		targetTypOccuCd = new ComboBox<BaseModel>();
		targetTypOccuCd.setName("targetTypOccuCd");
		targetTypOccuCd.setFieldLabel("-> 대상직종");
		targetTypOccuCd.setForceSelection(true);				 
		targetTypOccuCd.setMinChars(1);
		targetTypOccuCd.setDisplayField("typOccuNm");
		targetTypOccuCd.setValueField("typOccuCd");
		targetTypOccuCd.setTriggerAction(TriggerAction.ALL);
		targetTypOccuCd.setEmptyText("--직종선택--");
		targetTypOccuCd.setSelectOnFocus(true);
		targetTypOccuCd.setReadOnly(false);
		targetTypOccuCd.setEnabled(true);
		targetTypOccuCd.setStore(lsTypOccuCd);
		targetTypOccuCd.addSelectionChangedListener(selectionChangeListener4);
		layoutCenterContainer2.add(targetTypOccuCd, new FormData("100%"));
		
		targetDtilOccuClsDivCd = new ComboBox<BaseModel>();
		targetDtilOccuClsDivCd.setName("targetDtilOccuClsDivCd");
		targetDtilOccuClsDivCd.setFieldLabel("대상직종세");
		targetDtilOccuClsDivCd.setForceSelection(true);
		targetDtilOccuClsDivCd.setMinChars(1);
		targetDtilOccuClsDivCd.setDisplayField("dtilOccuClsNm");
		targetDtilOccuClsDivCd.setValueField("dtilOccuInttnCd");
		targetDtilOccuClsDivCd.setTriggerAction(TriggerAction.ALL);
		targetDtilOccuClsDivCd.setEmptyText("--직종세선택--");
		targetDtilOccuClsDivCd.setSelectOnFocus(true);
		targetDtilOccuClsDivCd.setReadOnly(false);
		targetDtilOccuClsDivCd.setEnabled(true);
		targetDtilOccuClsDivCd.setStore(lsDtilOccuInttnCd);	//효율적인 방안 셍각  new ListStore<BaseModel>()
		layoutRightContainer.add(targetDtilOccuClsDivCd, new FormData("100%"));
		
		applicationDate = new DateField();
		applicationDate.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		applicationDate.setName("applicationDate");				 
		new DateFieldMask(applicationDate, "9999.99.99");
		applicationDate.setFieldLabel("적용일자");
		applicationDate.setMinLength(10);
		applicationDate.setMaxLength(10);
		layoutLeftContainer.add(applicationDate, new FormData("100%"));
		
		ButtonBar btnBar = new ButtonBar();
		
		btnBass0310Copy = new Button("휴가일수 복사");
		btnBass0310Copy.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			copy(ActionDatabase.INSERT);
    		}
    	});
		
		btnBass0310CopyPkg = new Button("일괄복사");
		btnBass0310CopyPkg.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			BassP031002 bassP03102Form = new BassP031002(ActionDatabase.READ, getThis());   
			    
				MSFFormWindows msFwBass03102 = new MSFFormWindows("휴가일수 일괄 복사", bassP03102Form, "닫기", "900px", "600px", true);
				msFwBass03102.show();
				bassP03102Form.setMSFFormWindows(msFwBass03102);
    		}
    	});		
		
		btnBar.add(btnBass0310Copy);
		btnBar.add(btnBass0310CopyPkg);
		layoutCenterContainer.add(btnBar);
		
		layoutContainer.add(layoutLeftContainer, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer.add(layoutCenterContainer, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer.add(layoutCenterContainer2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer.add(layoutRightContainer, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		
		
		copyFieldset.add(layoutContainer, new FormData("100%"));
		
		plFrmBass0310.add(copyFieldset);
	}
	
/**
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 휴가일수 복사 함수 선언부 종료
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 **/
	
/**
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 그리드 처리 함수 시작
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 **/
	private void createListGrid() {
		
		FieldSet fldstNewFieldset = new FieldSet();
	    fldstNewFieldset.setHeadingHtml("휴가일수정보");
	    	   
		LayoutContainer lcStdGrid = new LayoutContainer();
		lcStdGrid.setStyleAttribute("paddingLeft", "5px");
		lcStdGrid.setStyleAttribute("paddingRight", "5px");
		FormLayout frmlytStd = new FormLayout();		
		lcStdGrid.setLayout(frmlytStd);
//		frmlytStd.setLabelWidth(85);
//		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
//		fldstNewFieldset.setCollapsible(false); 

		ContentPanel cpGrid = new ContentPanel();
		cpGrid.setBodyBorder(false); 
		cpGrid.setHeaderVisible(false);
		cpGrid.setLayout(new FitLayout());
		cpGrid.setSize(940, 290);	

		psnl2100GridPanel = new MSFGridPanel(psnl2100Def, false, false, false, false);
		psnl2100GridPanel.setHeaderVisible(false);
		psnl2100GridPanel.setBodyBorder(true);
		psnl2100GridPanel.setBorders(true);
		final Grid<BaseModel> bass0310Grid = psnl2100GridPanel.getMsfGrid().getGrid();
		bass0310Grid.addListener(Events.RowClick, new Listener<BaseEvent>() {
	        public void handleEvent(BaseEvent be) {
	        	if (psnl2100GridPanel.getCurrentlySelectedItem() != null) {
	        		
	        		bmData = new BaseModel();
	        		bmData = psnl2100GridPanel.getCurrentlySelectedItem();
//		        	    Timer tmMask = new Timer() {
//	  						public void run() {
//	  							BaseModel bmData = new BaseModel();
//	  							bmData = psnl2100GridPanel.getCurrentlySelectedItem();
//	  							BasisUtil.setSelectedComboValue(dtilOccuClsDivCd, (String)bmData.get("dtilOccuInttnCd$dtilOccuInttnCd"),"dtilOccuInttnCd"); 	/** column 직종세구분코드 : dtilOccuClsDivCd */
//	  						}
//	  					};
	        		
	    			actionDatabase = ActionDatabase.UPDATE;		// DB 저장/신규 구분
	        		/** 252 line에서 잡아주는 이벤트에서 생기는 select 문제를 해결해주기 위해서 넣어준다.*/
	    			BasisUtil.setSelectedComboValue(dtilOccuClsDivCd, (String)bmData.get("dtilOccuInttnCd$dtilOccuInttnCd"),"dtilOccuInttnCd"); /** column 직종세구분코드 : dtilOccuClsDivCd */
	    			/** ----------------------------------------------------------- */
	    			dpobCd.setValue(MSFSharedUtils.allowNulls(bmData.get("dpobCd")));	 /** column 사업장코드 : dpobCd */
	  				hodyNumDysSeilNum.setValue((Long)bmData.get("hodyNumDysSeilNum"));	/** column 휴가일수일련번호 : hodyNumDysSeilNum */
	  				BasisUtil.setSelectedComboValue(typOccuCd, (String)bmData.get("typOccuCd$typOccuCd"),"typOccuCd");   /** column 직종코드 : typOccuCd */
	  				typOccuCd.setEnabled(true);
	  				//pyspGrdeCd.setValue(MSFSharedUtils.allowNulls(bmData.get("pyspGrdeCd")));	/** column 호봉등급코드 : pyspGrdeCd */	  				
	  				dtilOccuClsDivCd.setEnabled(true);
	  				hodyNumDysOvr.setValue((Long)bmData.get("hodyNumDysOvr"));	/** column 휴가일수이상 : hodyNumDysOvr */
	  				hodyNumDysUdr.setValue((Long)bmData.get("hodyNumDysUdr"));	/** column 휴가일수미만 : hodyNumDysUdr */
	  				hodyNumDys.setValue((Long)bmData.get("hodyNumDys"));			/** column 휴가일수 : hodyNumDys */
	  				hodyNumDysBgnnDt.setValue((Date)bmData.get("hodyNumDysBgnnDt"));		/** column 휴가일수시작일자 : hodyNumDysBgnnDt */
	  				hodyNumDysEndDt.setValue((Date)bmData.get("hodyNumDysEndDt"));		/** column 휴가일수종료일자 : hodyNumDysEndDt */
	  				hodyNumDysUseYn.setValue((Boolean)bmData.get("hodyNumDysUseYn"));    /** column 휴가일수사용여부 : hodyNumDysUseYn */
	  				hodyNumDysNoteCtnt.setValue(MSFSharedUtils.allowNulls(bmData.get("hodyNumDysNoteCtnt")));	//휴가일수 비고내용
//	  				stDtilOccuInttnCd.fireEvent(Events.Add);	/**	강제 호출, 밖으로 빼서 사용한다.	*/
	  				
	  				
	  				
	    		}


			}
		});
	    cpGrid.add(psnl2100GridPanel);

		lcStdGrid.add(cpGrid);
		fldstNewFieldset.add(lcStdGrid);

	    plFrmBass0310.add(fldstNewFieldset, new FormData("0% -475"));
	}


/**
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 그리드 처리 함수 종료
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 **/

/**
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 기본등록화면 입력 시작
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 **/
	private void createStandardForm() {

		/**
		 * 지역변수 선언부
		 */
		sysComBass0300Dto = new PrgmComBass0300DTO();		        
		sysComBass0350Dto = new PrgmComBass0350DTO();
		sysComBass0320Dto = new PrgmComBass0320DTO();

		stTypOccuCd = new ListStore<BaseModel>();
		stTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto);
		    
		stDtilOccuInttnCd = new ListStore<BaseModel>();
		stDtilOccuInttnCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto);
							 
			
		fieldSetStdFrm = new FieldSet();
		fieldSetStdFrm.setHeadingHtml("상세정보");
		dpobCd = new HiddenField<String>();

		LayoutContainer lcStdColStdFrm = new LayoutContainer();
		lcStdColStdFrm.setLayout(new ColumnLayout());

		LayoutContainer lcStdLeftFrm = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdLeftFrm.setLayout(frmlytStd);

		LayoutContainer lcStdCenterFrm = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdCenterFrm.setLayout(frmlytStd);

		LayoutContainer lcStdRightFrm = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdRightFrm.setLayout(frmlytStd);

		LayoutContainer lcStdRightFrm2 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(70);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdRightFrm2.setLayout(frmlytStd);

		//--------------------공통 코드 불러 오는 함수 -------------------------------------------
		//sysComBass0300Dto.setRpsttvCd("C001");
		//dotwListStore = SysComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
		//--------------------공통 코드 불러 오는 함수 -------------------------------------------

		hodyNumDysSeilNum = new MSFNumberField();
		hodyNumDysSeilNum.setReadOnly(true);
		hodyNumDysSeilNum.setName("hodyNumDysSeilNum");
		hodyNumDysSeilNum.setFieldLabel("번호");
		/**TextField를 사용하기 위한 선언*/
		hodyNumDysSeilNum.setAllowDecimals(true);
		hodyNumDysSeilNum.setPropertyEditorType(Long.class);
		hodyNumDysSeilNum.setFormat(NumberFormat.getDecimalFormat());
		/**TextField를 사용하기 위한 선언 끝*/
		lcStdLeftFrm.add(hodyNumDysSeilNum, new FormData("100%"));
				 
		typOccuCd = new MSFComboBox<BaseModel>();
		typOccuCd.setName("typOccuCd");
		typOccuCd.setFieldLabel("직종");
		typOccuCd.setForceSelection(true);				 
		typOccuCd.setMinChars(1);
		typOccuCd.setDisplayField("typOccuNm");
		typOccuCd.setValueField("typOccuCd");
		typOccuCd.setTriggerAction(TriggerAction.ALL);
		typOccuCd.setEmptyText("--직종선택--");
		typOccuCd.setSelectOnFocus(true);
		typOccuCd.setReadOnly(false);
		typOccuCd.setEnabled(true);
		typOccuCd.setStore(stTypOccuCd);
		typOccuCd.addSelectionChangedListener(selectionChangeListener2);
		lcStdCenterFrm.add(typOccuCd, new FormData("100%"));
				 
		dtilOccuClsDivCd = new MSFComboBox<BaseModel>();
		dtilOccuClsDivCd.setName("dtilOccuClsDivCd");
		dtilOccuClsDivCd.setFieldLabel("직종세");
		dtilOccuClsDivCd.setForceSelection(true);
		dtilOccuClsDivCd.setMinChars(1);
		dtilOccuClsDivCd.setDisplayField("dtilOccuClsNm");
		dtilOccuClsDivCd.setValueField("dtilOccuInttnCd");
		dtilOccuClsDivCd.setTriggerAction(TriggerAction.ALL);
		dtilOccuClsDivCd.setEmptyText("--직종세선택--");
		dtilOccuClsDivCd.setSelectOnFocus(true);
		dtilOccuClsDivCd.setReadOnly(false);
		dtilOccuClsDivCd.setEnabled(true);
		dtilOccuClsDivCd.setStore(stDtilOccuInttnCd);	//효율적인 방안 셍각  new ListStore<BaseModel>()
		lcStdRightFrm.add(dtilOccuClsDivCd, new FormData("100%"));
				 
		hodyNumDysOvr= new MSFNumberField();
		hodyNumDysOvr.setName("hodyNumDysOvr");
		hodyNumDysOvr.setFieldLabel("이상");
		hodyNumDysOvr.setAllowDecimals(true);
		hodyNumDysOvr.setPropertyEditorType(Long.class);
		hodyNumDysOvr.setFormat(NumberFormat.getDecimalFormat());
		lcStdLeftFrm.add(hodyNumDysOvr, new FormData("100%"));

	 	hodyNumDysUdr= new MSFNumberField();
		hodyNumDysUdr.setName("hodyNumDysUdr");
		hodyNumDysUdr.setFieldLabel("미만");
		hodyNumDysUdr.setAllowDecimals(true);
		hodyNumDysUdr.setPropertyEditorType(Long.class);
		hodyNumDysUdr.setFormat(NumberFormat.getDecimalFormat());
		lcStdCenterFrm.add(hodyNumDysUdr, new FormData("100%"));

		hodyNumDys = new MSFNumberField();
		hodyNumDys.setName("hodyNumDys");
		hodyNumDys.setFieldLabel("휴가일수");
		hodyNumDys.setAllowDecimals(true);
		hodyNumDys.setPropertyEditorType(Long.class);
		hodyNumDys.setFormat(NumberFormat.getDecimalFormat());
		lcStdRightFrm.add(hodyNumDys, new FormData("100%"));


		hodyNumDysBgnnDt = new MSFDateField();
		hodyNumDysBgnnDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		hodyNumDysBgnnDt.setName("hodyNumDysBgnnDt");				 
		new DateFieldMask(hodyNumDysBgnnDt, "9999.99.99");
		hodyNumDysBgnnDt.setFieldLabel("시작일자");
		hodyNumDysBgnnDt.setMinLength(10);
		hodyNumDysBgnnDt.setMaxLength(10);
		lcStdLeftFrm.add(hodyNumDysBgnnDt, new FormData("100%"));

		hodyNumDysEndDt = new MSFDateField();
		hodyNumDysEndDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		hodyNumDysEndDt.setName("hodyNumDysEndDt");				 
		new DateFieldMask(hodyNumDysEndDt, "9999.99.99");
		hodyNumDysEndDt.setFieldLabel("종료일자");
		hodyNumDysEndDt.setMinLength(10);
		hodyNumDysEndDt.setMaxLength(10);
		lcStdCenterFrm.add(hodyNumDysEndDt, new FormData("100%"));

		dtilOccuClsUseGrp = new CheckBoxGroup();
		dtilOccuClsUseGrp.setName("dtilOccuClsUseGrp");
		dtilOccuClsUseGrp.setLabelSeparator("");

		hodyNumDysUseYn = new CheckBox();
		hodyNumDysUseYn.setName("hodyNumDysUseYn");
		dtilOccuClsUseGrp.add(hodyNumDysUseYn);
		hodyNumDysUseYn.setBoxLabel("사용 여부");
		hodyNumDysUseYn.setHideLabel(true);
		lcStdRightFrm.add(dtilOccuClsUseGrp, new FormData("100%"));
		
		hodyNumDysNoteCtnt = new MSFTextField();
		hodyNumDysNoteCtnt.setName("hodyNumDysNoteCtnt");
		hodyNumDysNoteCtnt.setFieldLabel("비고내용");
		lcStdRightFrm2.add(hodyNumDysNoteCtnt, new FormData("100%"));

		
		//lcStdCenterFrm.add(dtilOccuClsUseGrp, new FormData("100%"));

		lcStdColStdFrm.add(lcStdLeftFrm, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		lcStdColStdFrm.add(lcStdCenterFrm, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		lcStdColStdFrm.add(lcStdRightFrm, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		
		fieldSetStdFrm.add(lcStdColStdFrm, new FormData("100%"));
		fieldSetStdFrm.add(lcStdRightFrm2, new FormData("100%"));


		plFrmBass0310.add(fieldSetStdFrm);


	}
/**
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 기본등록화면 입력 종료 
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 **/
	/** Excel */
	private void createExcelForm(){
		FieldSet fldstNewFieldset = new FieldSet();	
		fldstNewFieldset.setHeadingHtml("");
		fldstNewFieldset.setStyleAttribute("marginTop", "10px");
		  
		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new FlowLayout());
			
		LayoutContainer layoutContainer_1 = new LayoutContainer();
		layoutContainer_1.setLayout(new HBoxLayout()); 
			
		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new ColumnLayout());
		layoutContainer_2.setBorders(false);
			    
		LayoutContainer layoutContainer_2_1 = new LayoutContainer();
		layoutContainer_2_1.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(60); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
		layoutContainer_2_1.setLayout(frmlytSch);
		layoutContainer_2_1.setBorders(false);
		
		LayoutContainer layoutContainer_3 = new LayoutContainer(); 
		layoutContainer_3.setStyleAttribute("paddingRight", "10px");
		frmlytSch = new FormLayout();  
		frmlytSch.setLabelWidth(0); 
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
		layoutContainer_3.setLayout(frmlytSch);
		layoutContainer_3.setBorders(false);
		
		LayoutContainer layoutContainer_4 = new LayoutContainer(); 
		layoutContainer_4.setStyleAttribute("paddingRight", "10px");
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(0); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
	    layoutContainer_4.setLayout(frmlytSch);
	    layoutContainer_4.setBorders(false);
	    
	    LayoutContainer layoutContainer_5 = new LayoutContainer(); 
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(0); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
	    layoutContainer_5.setLayout(frmlytSch);
	    layoutContainer_5.setBorders(false);
	    
	    bass0310flUp = new FileUploadField();
	    bass0310flUp.setName("bass0310flUp");
	    bass0310flUp.setValidator(new Validator() {  
                @Override  public String validate(Field<?> field, String value) { 
                    value = value.toLowerCase();        
                    String result = "xls 파일이 아닙니다., 다시선택하십시요.";        
                    if(value.endsWith(".xls") || value.endsWith(".xlsx") ){           
                        result = null;        
                        }        
                    return result;  
                    } 
                });
		layoutContainer_2_1.add(bass0310flUp, new FormData("100%"));
		bass0310flUp.setFieldLabel("휴가일수");
		
		Button btnButton01 = new Button("양식업로드");
		btnButton01.addListener(Events.Select, new Listener<ButtonEvent>() {
              public void handleEvent(ButtonEvent e) {
                  
              	xlsImportData(); 
              	
                    
              }
          });
		layoutContainer_3.add(btnButton01, new FormData("100%"));
		

		Button btnButton02 = new Button("양식다운");
		btnButton02.addListener(Events.Select, new Listener<ButtonEvent>() {
              public void handleEvent(ButtonEvent e) {
                  
                xlsExportData();
                    
              }
          }); 		
		layoutContainer_4.add(btnButton02, new FormData("100%"));
		
		Button btnBass0310ExcelPkg = new Button("일괄 엑셀 업로드");
		btnBass0310ExcelPkg.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			BassP031001 bassP03101Form = new BassP031001(ActionDatabase.READ, getThis());   
			    
				MSFFormWindows msFwBass03101 = new MSFFormWindows("휴가일수 일괄 엑셀 업로드", bassP03101Form, "닫기", "820px", "710px", true);
				msFwBass03101.show();
				bassP03101Form.setMSFFormWindows(msFwBass03101);
    		}
    	});
		layoutContainer_5.add(btnBass0310ExcelPkg, new FormData("100%"));
		
		layoutContainer_2.add(layoutContainer_2_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_2.add(layoutContainer_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
		layoutContainer_2.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
		layoutContainer_2.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		
		layoutContainer.add(layoutContainer_2);
		layoutContainer_2.setBorders(false);
		fldstNewFieldset.add(layoutContainer);
		layoutContainer.setBorders(false);
		
		plFrmBass0310.add(fldstNewFieldset);
		
		reload();
	}
	/* 엑셀 업로드 */
	private void xlsImportData() {
		MessageBox.confirm("휴가일수 생성", "휴가일수를 생성하시겠습니까?<br>",new Listener<MessageBoxEvent>(){
			@Override
			public void handleEvent(MessageBoxEvent be) {
				//if("Yes".equals(be.getButtonClicked().getText())){
				if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
					
					String filename = MSFSharedUtils.allowNulls(bass0310flUp.getValue());
					if (filename.length() == 0) {
						Window.alert("선택된 파일이 없습니다.");
						return;
						} else {
							//submit the form
							plFrmBass0310.mask("엑셀 데이타 업데이트 중입니다. 업로드 중..."); 
							//파일업로드 처리
							plFrmBass0310.setAction(GWT.getHostPageBaseURL() + "imp/XlsReadBass0310Import.do");
							plFrmBass0310.setEncoding(Encoding.MULTIPART);
							plFrmBass0310.setMethod(Method.POST);   
							plFrmBass0310.submit();  
	                		plFrmBass0310.onFrameLoad();  
	                		picBoolFile = true;	 
	                    	
	                	}
	              		// reset and unmask the form 
	              		// after file upload 
	              		plFrmBass0310.addListener(Events.Submit, new Listener<FormEvent>() {
                  		public void handleEvent(FormEvent evt) {   
                  			if ("success".endsWith(evt.getResultHtml()) && picBoolFile) {                  			
                  				//업로드가  성공했으면 인서트 모듈을 태운다. 
                  				plFrmBass0310.unmask();  
//                              MessageBox.alert("", "엑셀 업로드가 정상적으로 완료되었습니다.", null); 
                  				reload();
                              	picBoolFile = false;
                              	evt.setResultHtml("");                              	
                          	} else {
                          		if ("error".endsWith(evt.getResultHtml()) && picBoolFile) {
                          			plFrmBass0310.unmask();  
                          			MessageBox.alert("", "엑셀 업로드가 비정상적으로 종료되었습니다.", null);
                                  	picBoolFile = false;
                                	evt.setResultHtml("");
                          		} else {
                          			//실패 메시지나 에러 메시지 처리 . 
                          			evt.setResultHtml("");
                          		} 
                          	}
                  		};
                  	});               		
	              		
		      	}  
		      }		      	
		  }); 	     	 
	} 
	    
	/* 엑셀 다운로드 */
	private void xlsExportData() {
		  
		HashMap<String, String> param = new HashMap<String, String>();
		psnl2100GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsFileBass0310Export.do","extgwtFrame" ,param);  
	}
	  
	public void reload() {

		formBass0310Init();

		IColumnFilter filters = null;
		dtilOccuClsDivCd.setEnabled(false);//직종코드
		typOccuCd.setEnabled(false);
	    psnl2100GridPanel.getTableDef().setTableColumnFilters(filters);
	    /**★★★sql.xml과 매칭을 잘하여 입력해줘야 한다!!*/
	    psnl2100GridPanel.getTableDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd"), SimpleColumnFilter.OPERATOR_EQUALS);
	    psnl2100GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", MSFSharedUtils.getSelectedComboValue(srhDtilOccuInttnCd, "dtilOccuInttnCd"), SimpleColumnFilter.OPERATOR_EQUALS);
	    psnl2100GridPanel.getTableDef().addColumnFilter("srhHodyNumDysUseYn", srhHodyNumDysUseYn.getValue()? "Y" : "N", SimpleColumnFilter.OPERATOR_EQUALS);
	    psnl2100GridPanel.reload();

	}

	public void setRecord(BaseModel record) {
		this.record = record;
	}

	private Bass0310 getThis(){
		return this;
	}
	
	private void formBass0310Init() {
		
		hodyNumDysBgnnDt.setReadOnly(false);
		hodyNumDysBgnnDt.setValue(today); 		// 시작일자
		hodyNumDysEndDt.setReadOnly(false);
		hodyNumDysEndDt.setValue(today); 		// 종료일
		hodyNumDys.reset();		//휴가 일수
		hodyNumDysOvr.reset();		//휴가 일수 이상
		hodyNumDysUdr.reset();		//휴가 일수 미만
		hodyNumDysUseYn.setValue(false);		//사용여부
		dtilOccuClsDivCd.setValue(new BaseModel());	//직종세구분코드
		dtilOccuClsDivCd.setEnabled(true);//직종코드
		typOccuCd.setValue(new BaseModel());
		typOccuCd.setEnabled(true);//직종코드
		basicTypOccuCd.setValue(new BaseModel());
		basicDtilOccuClsDivCd.setValue(new BaseModel());
		targetTypOccuCd.setValue(new BaseModel());
		targetDtilOccuClsDivCd.setValue(new BaseModel());
		applicationDate.setValue(today);
		hodyNumDysSeilNum.reset();	//휴가일수 일련번호
		hodyNumDysNoteCtnt.setValue("");
		actionDatabase = ActionDatabase.INSERT;
	}
	

	public native String getDetailTemplate() /*-{
	    return ['<div class="details">',
	    '<tpl for=".">',
	    '<img src="{modPath}"><div class="details-info">',
	    '<b>Image Name:</b>',
	    '<span>{name}</span>',
	    '<b>Size:</b>',
	    '<span>{sizeString}</span>',
	    '<b>Last Modified:</b>',
	    '<span>{dateString}</span></div>',
	    '</tpl>',
	    '</div>'].join("");
	  }-*/;



	/************************************************************************
	 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출
	 ************************************************************************/
	/**
	 *
	 * <pre>
	 * 1. 개요 : 화면별 에러로그 확인 처리 를위해 추가 된 부분....
	 * 2. 처리내용 :
	 * </pre>
	 * @Method Name : funcLogMessage
	 * @date : 2016. 9. 2.
	 * @author : Administrator
	 * @history :
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용
	 *	----------- ------------------- ---------------------------------------
	 *	2016. 9. 2.		Administrator				최초 작성
	 *	-----------------------------------------------------------------------
	 *
	 * @param wndName
	 * @param wndId
	 */
	public void funcLogMessage(String wndName, String wndId){

		 ShowMessageBM smForm = new ShowMessageBM();
		 smForm.setWindowId(wndId);
		 smForm.setWindowNm(wndName);
		//개별 화면 에러메시지 검색 팝업
		GWTUtils.funcLogMessage(smForm);
	}
	/************************************************************************
	 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출
	 ************************************************************************/


}
