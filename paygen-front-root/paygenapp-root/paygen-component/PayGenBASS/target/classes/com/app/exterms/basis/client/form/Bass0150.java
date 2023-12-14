package com.app.exterms.basis.client.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.app.exterms.basis.client.dto.Bass0150DTO;
import com.app.exterms.basis.client.form.defs.Bass0150Def;
import com.app.exterms.basis.client.languages.BasisConstants;
import com.app.exterms.basis.client.service.Bass0150Service;
import com.app.exterms.basis.client.service.Bass0150ServiceAsync;
import com.app.exterms.basis.client.utils.BasisUtil;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.service.PrgmComBass0300Service;
import com.app.exterms.prgm.client.service.PrgmComBass0300ServiceAsync;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.utils.PrintUtils;
import com.app.smrmf.core.msfmainapp.client.widget.MSFComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTextField;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldWithButton;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.app.smrmf.syscom.client.util.SysComPopupUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FormEvent;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.CheckBoxGroup;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Encoding;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Method;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Image;

/**
 * @Class Name : Bass0150.java
 * @Description : 단위기관관리
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

/** 
 * =========================================================================
 * 디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다. extends MSFPanel -> extends
 * LayoutContainer implements IMSFWindow { 상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리
 * 해야함. MSFPanel
 * =========================================================================
 **/
public class Bass0150 extends MSFPanel {

	//-- 검색조건 시작
	private TextField<String> srhPayrMangeDeptNm; 			// 단위기관명
	private TextField<String> srhDegtrNm; 					// 대표자명
	//-- 검색조건 끝
	//-- 상세정보 시작
	
	private MSFComboBox<BaseModel> dpobCd; 							//사업장
//	private TextFieldWithButton<String> payrMangDeptCd; 			//단위기관(부서)코드
	private MSFTextField payrMangDeptCd; 							//단위기관(부서)코드
//	private MSFTextField payMangeDeptNm; 							//부서명
	private TextFieldWithButton<String> payMangeDeptNm; 			//부서명
	private MSFTextField degtrNm; 									//대표자성명
	private MSFTextField degtrResnRegnNum; 							//주민번호
	private HiddenField<String> degtrSecRegnNum; 		 			//주민번호원본 
 
	private static MSFTextField payMangeDeptZpcd; 					//사업장주소
	private static MSFTextField payMangeDeptFNdtnAddr; 				//사업장 기본주소
	private static MSFTextField payMangeDeptDtlPatrAddr; 			//사업장 상세주소
	private MSFTextField payMangeDeptPhnNum; 						//전화번호
	private MSFTextField payMangeDeptFaxNum; 						//팩스번호
	private MSFTextField busoprRgstnNum; 							//사업자번호
	private MSFTextField corpRgstnNum; 								//법인번호
	
	private MSFComboBox<BaseModel> corpDivCd; 						//법인구분
	private TextFieldWithButton<String> payMangeDeptWhlePernChrg;	//업무담당자명(총괄담당자)
	private TextFieldWithButton<String> payMangeDeptDivTskOffr; 	//분임지출관
	private MSFComboBox<BaseModel> accCd; 							//회계코드
	
	private MSFComboBox<BaseModel> cllnDebrNm; 						//징수의무자
	//private TextField<String> CLLN_DEBR_NM; 						//징수의무자
	private MSFTextField hmtxId; 									//홈텍스 ID
	private MSFTextField txOffcCd; 									//세무서코드 입력		
	private MSFComboBox<BaseModel> bnkCd; 							//은행코드			
	private MSFTextField groTnsrCd; 								//지로이체코드 입력	
	private CheckBox payMangeDeptFNdtnUseYn;						//급여관리부서기본사용여부
	private CheckBoxGroup payMangeDeptFNdtnUseGrp;					//체크박스 그룹
	
	private Image payMangeDeptSealFlNm; 							//직인사진
	private FileUploadField payMangeDeptSealFlNmFile; 

    //이미지 업로드를 위해 추가  
    private HiddenField<String> frmKey;
    private Boolean picBoolFile;

    //팝업 HiddenField
    private HiddenField<String> deptKey;		//단위기관 키
    private HiddenField<String> pmdPernKey;		//업무담당자 키
    private HiddenField<String> pmdDivKey;		//분임지출관 키
    
	//-- 상세정보 끝
	//-- 사업장 기호 시작
    /**
    private TextField<String> HLTH_INSR_SYM; 				//건강보험 기호
	private TextField<String> NAT_PENN_SYM; 				//국민연금 기호
	private TextField<String> UMYT_INSR_SYM; 				//고용보험 기호
	*/
    
	private MSFTextField hlthInsrSym; 						//건강보험 기호
	private MSFTextField hlthInsrOfceSym;					//건강보험영업소기호
	private MSFTextField natPennSym; 						//국민연금 기호
	private MSFTextField umytInsrSym; 						//고용보험 기호
	private MSFTextField idtlAccdtInsurSym; 				//산재보험 기호
	//-- 사업장 기호 끝
	
	//-- 공통 코드 시작
	private ListStore<BaseModel> listStoreDpobCd = new ListStore<BaseModel>(); 			//사업장 코드
	private ListStore<BaseModel> listStoreAccCd = new ListStore<BaseModel>();			//회계코드
	private ListStore<BaseModel> listStoreBnkCd = new ListStore<BaseModel>();			//은행
	private ListStore<BaseModel> listStoreCorpDivCd = new ListStore<BaseModel>();		//법인코드
	private ListStore<BaseModel> lsRetryCllnDebrDivNm = new ListStore<BaseModel>();  	//징수의무자 
	//-- 공통 코드 끝
	
	//-- 서비스 시작
	private Bass0150ServiceAsync bass0150Service = Bass0150Service.Util.getInstance();
	private PrgmComBass0300ServiceAsync sysComBass0300Service = PrgmComBass0300Service.Util.getInstance();
	//-- 서비스 끝
	
	private BasisConstants lblBasisConst = BasisConstants.INSTANCE;

	private VerticalPanel vp;
	private FormPanel plFrmBass0150;
	
	private String txtForm = ""; 

	public FormBinding formBinding;
	public FormBinding srhFormBinding;

	private Bass0150Def bass0150Def = new Bass0150Def(); // 그리드 테이블 컬럼 define
	private MSFGridPanel msfGridPanel;
	
	private PrgmComBass0300DTO sysComBass0300Dto;
	
	

	
	private ActionDatabase actionDatabase;
	
	// -- 상단 버튼 시작
	private ButtonBar topBass0150Bar;
	private Button btnBass0150New;
	private Button btnBass0150Save;
	private Button btnBass0150Del;
	private Button btnBass0150Sreach;
	// -- 상단 버튼 종료
	
	
	private HiddenField<String> imgKeyCode;

	
	private BaseModel record;

	

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 선택된 버튼에 따른 인서트 업데이트 삭제 처리 부
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	private SelectionListener<ButtonEvent> selectionListener = new SelectionListener<ButtonEvent>() {
		public void componentSelected(ButtonEvent ce) {
			
			
			if (ce.getButton() == btnBass0150Save) {
				doAction(actionDatabase);
//			} else if (ce.getButton() == btnBass0150Save) {
//				doAction(ActionDatabase.UPDATE);
			} else if (ce.getButton() == btnBass0150Del) {
				doAction(ActionDatabase.DELETE);
			} 
			
		}
	};

	private void doAction(ActionDatabase actionDatabase) {
		save(actionDatabase);
	}
	
	public void save(final ActionDatabase actionDatabasee){
		final Bass0150DTO dto = new Bass0150DTO();
		
		dto.setDpobCd(BasisUtil.getSelectedComboValue(dpobCd)); 						//사업장
		dto.setPayrMangDeptCd(payrMangDeptCd.getValue()); 								//부서코드
		dto.setPayMangeDeptNm(payMangeDeptNm.getValue()); 								//부서명
		dto.setDegtrNm(degtrNm.getValue());		 										//대표자성명
		dto.setDegtrResnRegnNum(degtrResnRegnNum.getValue()); 							//주민번호
		dto.setBusoprRgstnNum(busoprRgstnNum.getValue()); 								//사업자번호
		dto.setPayMangeDeptZpcd(payMangeDeptZpcd.getValue()); 							//부서주소 우편번호
		dto.setPayMangeDeptFNdtnAddr(payMangeDeptFNdtnAddr.getValue()); 				//부서주소 기본주소
		dto.setPayMangeDeptDtlPatrAddr(payMangeDeptDtlPatrAddr.getValue());				//부서주소 상세주소
		dto.setPayMangeDeptPhnNum(payMangeDeptPhnNum.getValue()); 						//전화번호
		dto.setPayMangeDeptFaxNum(payMangeDeptFaxNum.getValue()); 						//팩스번호
		dto.setCorpRgstnNum(corpRgstnNum.getValue()); 									//법인번호
		dto.setPayMangeDeptWhlePernChrg(pmdPernKey.getValue()); 						//업무담당자ID(총괄담당자)
		dto.setTxOffcCd(txOffcCd.getValue()); 											//세무서코드
		dto.setCorpDivCd(BasisUtil.getSelectedComboValue(corpDivCd)); 					//법인구분
		dto.setAccCd(BasisUtil.getSelectedComboValue(accCd));							//회계코드
		//dto.setCllnDebrNm(CLLN_DEBR_NM.getValue()); 									//징수의무자
		//dto.setCllnDebrNm(BasisUtil.getSelectedComboValue(cllnDebrNm)); 				//징수의무자
		dto.setHmtxId(hmtxId.getValue()); 												//홈텍스아이디
		dto.setPayMangeDeptDivTskOffr(pmdDivKey.getValue()); 							//분임지출관(ID)
		dto.setBnkCd(BasisUtil.getSelectedComboValue(bnkCd));							//은행코드
		dto.setGroTnsrCd(groTnsrCd.getValue()); 										//지로이체코드
		dto.setPayMangeDeptSealRftaNm(MSFMainApp.getMsg("PayGen.ExTermPhoto"));
		dto.setHlthInsrSym(hlthInsrSym.getValue());										//건강보험
		dto.setHlthInsrOfceSym(hlthInsrOfceSym.getValue());								//건강보험영업소기호
		dto.setNatPennSym(natPennSym.getValue());										//국민연금
		dto.setUmytInsrSym(umytInsrSym.getValue());										//고용보험
		dto.setIdtlAccdtInsurSym(idtlAccdtInsurSym.getValue());							//산재보험
		dto.setPayMangeDeptFNdtnUseYn(payMangeDeptFNdtnUseYn.getValue() ? "Y" : "N");	//급여관리부서기본사용여부
		//System.out.println("체크박스 값 확인해보기 "+payMangeDeptFNdtnUseYn.getValue());
		
		if("".equals(dto.getDpobCd()) || dto.getDpobCd() == null){
			MessageBox.info("", "사업장명은 필수 입니다.", null);
			dpobCd.focus();
		}else if("".equals(dto.getPayrMangDeptCd()) || dto.getPayrMangDeptCd() == null){
			MessageBox.info("", "단위기관코드는 필수 입니다.", null);
			payrMangDeptCd.focus();
		}else{
			final String fileName = payMangeDeptSealFlNmFile.getValue();
			if(!"".equals(fileName) && fileName != null){
				dto.setPayMangeDeptSealFlNm(fileName.substring(fileName.lastIndexOf("\\")+1));
			}
			
			MessageBox.confirm("","DELETE".equals(actionDatabasee.name()) ? "삭제 하시겠습니까?" : "저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
				@Override
				public void handleEvent(MessageBoxEvent be) {
					//if("Yes".equals(be.getButtonClicked().getHtml())){
					if(Dialog.YES.equals(be.getButtonClicked().getItemId())){	
						bass0150Service.saveBass0150(dto, actionDatabasee, new AsyncCallback<String>() {
							@Override
							public void onSuccess(String result) {
								if("DELETE".equals(actionDatabase.name())){
									MessageBox.info("", "삭제 되었습니다.", null);
								}else{
									MessageBox.info("", "저장 되었습니다.", null);
								}
								
								if(!"".equals(fileName) && fileName != null){
									payMangeDeptSealFlNmFile.setName("BASS0150"+"_"+payrMangDeptCd.getValue());
									   // dpobCd.setValue(MSFMainApp.get().getUser().getDpobCd());
									imgKeyCode.setValue(payrMangDeptCd.getValue());
	                                frmKey.setValue("BASS0150"); 
	                                 
	                                     plFrmBass0150.mask();  
	                                     plFrmBass0150.setAction(GWT.getHostPageBaseURL() + "upload/ImageFileUpload.do"); 
	                                     plFrmBass0150.submit();
	                                     plFrmBass0150.onFrameLoad(); 
	                                     picBoolFile = true;
	                                      
	                                     plFrmBass0150.addListener(Events.Submit, new Listener<FormEvent>() {
	                                           public void handleEvent(FormEvent evt) {  
	                                               plFrmBass0150.unmask(); 
	                                               if ("success".endsWith(evt.getResultHtml()) && picBoolFile) {
	                                                   //업로드가  성공했으면 인서트 모듈을 태운다.  
//	                                                   dtime.schedule(2000); 
	                                                     picBoolFile = false;
	                                                     evt.setResultHtml("");
	                                               } else {
	                                                   //TODO 처리 할것 실패 메시지나 에러 메시지 처리 .
	                                                   evt.setResultHtml("");
	                                               }
	                                           };
	                                        }); 
								}
								reload();
								actionDatabase = ActionDatabase.UPDATE;
							}
							@Override
							public void onFailure(Throwable caught) {
								caught.printStackTrace();
								MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService()
											, MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnBass0150(" + actionDatabase.name() + ") : " + caught), null);
							}
						});
					}
				}
			});
		}
				
	}


/**************************************************************/
/** 우편번호 로직 추가    												*/
/**************************************************************/		  
  public static native void closeFunction() /*-{
		   $wnd.closeFunction =
		      $entry(@com.app.exterms.basis.client.form.Bass0150::onCloseGwtFunction(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;));
  }-*/;
 public static void onCloseGwtFunction(String zpcd,String fnDtnAddr,String dtlPatrAddr )
  { 
	// Window.alert(postId);
		payMangeDeptZpcd.setValue(MSFSharedUtils.allowNulls(zpcd));
		payMangeDeptFNdtnAddr.setValue(MSFSharedUtils.allowNulls(fnDtnAddr)); // 앞주소
		payMangeDeptDtlPatrAddr.setValue(MSFSharedUtils.allowNulls(dtlPatrAddr)); // 뒷주소
	    
  }
 /**************************************************************/
 /** 우편번호 로직 추가    												*/
 /**************************************************************/
	
 
	public ContentPanel getViewPanel() {
		 
		if (panel == null) {
			
			GWTUtils.popupDoroWndClose(); 
			closeFunction();
			

			 
			// formData = new FormData("-650");
			vp = new VerticalPanel();
			vp.setSpacing(10);
			createBass0150Form(); 		// 화면 기본정보를 설정
			

			//--------------------공통 코드 불러 오는 함수 ------------------------------------------------------
			PrgmComBass0300DTO sysComBass0300Dto = new PrgmComBass0300DTO(); 
			sysComBass0300Dto.setRpsttvCd("R005");
			lsRetryCllnDebrDivNm = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);	
			//-------------------------------------------------------------------------------------------
			
			List<String> arrRpsttvCd = new ArrayList<String>();
			arrRpsttvCd.add("B002");
			arrRpsttvCd.add("B001");
			arrRpsttvCd.add("A040");
			sysComBass0300Dto = new PrgmComBass0300DTO(); 
			sysComBass0300Dto.setArrRpsttvCd(arrRpsttvCd);
			sysComBass0300Service.getPrgmComMultiComboBass0300List(sysComBass0300Dto, new AsyncCallback<HashMap<String,List<BaseModel>>>() {
				
				@Override
				public void onSuccess(HashMap<String, List<BaseModel>> result) {
					// TODO 콤보 데이터 저장하는곳
					if(result != null && result.size() > 0){
						listStoreAccCd.add(result.get("B002"));
						listStoreBnkCd.add(result.get("B001"));
						listStoreCorpDivCd.add(result.get("A040"));
					}
				}
				@Override
				public void onFailure(Throwable caught) {
					MessageBox.alert("", "공통코드 에러!", null);
				}
			});
			
			//상위 사업장 코드
			bass0150Service.getDpobCd(new AsyncCallback<List<BaseModel>>() {
				@Override
				public void onSuccess(List<BaseModel> result) {
					listStoreDpobCd.add(result);
				}
				
				@Override
				public void onFailure(Throwable caught) {
					MessageBox.alert("", "상위사업장명코드 에러!", null);
				}
			});
			
			
			
			createSearchForm(); 		// 검색필드를 적용
			createListGrid(); 			// 사업장 정보 그리드 
			createStandardForm(); 		// 사업장 상세정보
			createStdSubFrom(); 		// 사업장 관리번호
			//엣지변환
			//vp.setSize("1010px", "700px");
			vp.setSize("1010px", "750px");
			/*
			 * --------------------------------------------------------------------- 
			 * 폼 바인딩 및 공통 콤보 로딩시 처리 선언부 시작
			 * ---------------------------------------------------------------------
			 */
			// 폼데이터를 바인딩
			formBinding = new FormBinding(this.plFrmBass0150, true);

			// setBass0150FormBinding(); //폼바인딩처리 - 입력필드
			// bindMsfComBass0400(formBinding.getModel()); //부서코드
			// bindMsfComBass0500(formBinding.getModel()); //사업코드
			// bindMsfComBass0300(formBinding.getModel(),"A003"); //재직상태구분코드
			/**
			 * -------------------------------------------------------------------- 
			 * 폼 바인딩 및 공통 콤보 로딩시 처리 선언부 종료
			 * --------------------------------------------------------------------
			 */

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
	 * ############################################################################# 
	 * 프로그램 종료
	 * #############################################################################
	 **/

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 생성자 함수 선언부 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	/**
	 * @wbp.parser.constructor
	 */
	public Bass0150() {
		//엣지변환
		//setSize("1010px", "700px");
		setSize("1010px", "750px");
	}

	// 생성자 함수에 변수을 받아 처리
	public Bass0150(String txtForm) {
		this.txtForm = txtForm;
	}

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 생성자 함수 선언부 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 폼 생성시 기본 처리 함수 선언부 시작 1. 폼 생성 선언 2. 공통 버튼 처리 선언
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	private void createBass0150Form() {
		
		actionDatabase = ActionDatabase.UPDATE;

		plFrmBass0150 = new FormPanel();
		plFrmBass0150.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - " + lblBasisConst.title_Bass0150()));
		plFrmBass0150.setIcon(MSFMainApp.ICONS.text());
		plFrmBass0150.setBodyStyleName("pad-text");
		plFrmBass0150.setFrame(true);
		plFrmBass0150.setLayout(new FormLayout());
		

        /************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage(lblBasisConst.title_Bass0150(),"BASS0150");
				}
			});
		plFrmBass0150.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmBass0150.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/
		
		plFrmBass0150.setPadding(2);


		imgKeyCode  = new HiddenField<String>();
        imgKeyCode.setName("imgKeyCode");
        plFrmBass0150.add(imgKeyCode);
        frmKey  = new HiddenField<String>();
        frmKey.setName("frmKey");
        plFrmBass0150.add(frmKey);
        
		// formBinding
		// msfCustomForm = new MSFCustomForm(bass0150Def, 600, 150, false, true,
		// true);

		topBass0150Bar = new ButtonBar();
		topBass0150Bar.setAlignment(HorizontalAlignment.RIGHT);
		// buttonBar.add(new Button("신규", new SelectionListener<ButtonEvent>() {
		// public void componentSelected(ButtonEvent ce) {
		//
		// }
		// }));
		// buttonBar.add(new Button("저장", new SelectionListener<ButtonEvent>() {
		// public void componentSelected(ButtonEvent ce) {
		//
		// }
		// }));

		btnBass0150New = new Button("신규");
		btnBass0150New.setIcon(MSFMainApp.ICONS.new16());
		btnBass0150New.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				payrMangDeptCd.setReadOnly(false);		//단위기관(부서)코드
				dpobCd.setValue(new BaseModel());		//사업장
				payrMangDeptCd.setValue("");			//단위기관(부서)코드
				payMangeDeptNm.setValue("");			//부서명		
				degtrNm.setValue("");					//대표자성명
				degtrResnRegnNum.setValue("");			//주민번호
				payMangeDeptZpcd.setValue("");			//사업장주소	
				payMangeDeptFNdtnAddr.setValue("");		//사업장 기본주소
				payMangeDeptDtlPatrAddr.setValue("");	//사업장 상세주소
				payMangeDeptPhnNum.setValue("");		//전화번호
				payMangeDeptFaxNum.setValue("");		//팩스번호
				busoprRgstnNum.setValue("");			//사업자번호
				corpRgstnNum.setValue("");				//법인번호
				payMangeDeptSealFlNm.setUrl(GWT.getHostPageBaseURL()+MSFMainApp.getMsg("PayGen.NonExTermPhoto"));
				frmKey.setValue("");					//이미지
				payMangeDeptSealFlNmFile.setValue("");	//직인사진
				hlthInsrSym.setValue("");				//건강보험 기호
				hlthInsrOfceSym.setValue("");			//건강보험영업소기호
				natPennSym.setValue("");				//국민연금 기호
				umytInsrSym.setValue("");				//고용보험 기호
				idtlAccdtInsurSym.setValue("");			//산재보험 기호
				corpDivCd.setValue(new BaseModel());	//법인구분
				payMangeDeptWhlePernChrg.setValue("");	//총괄담당자
				pmdPernKey.setValue("");
				payMangeDeptDivTskOffr.setValue("");	//분임지출관
				pmdDivKey.setValue("");
				accCd.setValue(new BaseModel());		//회계코드
				//CLLN_DEBR_NM.setValue("");
				cllnDebrNm.setValue(new BaseModel());	//징수의무자
				hmtxId.setValue("");					//홈텍스 ID
				txOffcCd.setValue("");					//세무서코드 입력
				bnkCd.setValue(new BaseModel());		//은행코드				
				groTnsrCd.setValue("");					//지로이체코드 입력
				payMangeDeptFNdtnUseYn.setValue(false);	//급여관리부서기본사용여부
				
				actionDatabase = ActionDatabase.INSERT;
				
			}
		});
		topBass0150Bar.add(btnBass0150New);

		btnBass0150Save = new Button("저장");
		btnBass0150Save.setIcon(MSFMainApp.ICONS.save16());
		btnBass0150Save.addSelectionListener(selectionListener);
		topBass0150Bar.add(btnBass0150Save);

		btnBass0150Del = new Button("삭제");
		btnBass0150Del.setIcon(MSFMainApp.ICONS.delete16());
		btnBass0150Del.addSelectionListener(selectionListener);
		topBass0150Bar.add(btnBass0150Del);

		btnBass0150Sreach = new Button("조회");
		btnBass0150Sreach.setIcon(MSFMainApp.ICONS.search16());
		topBass0150Bar.add(btnBass0150Sreach);
		btnBass0150Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				payrMangDeptCd.setReadOnly(false);
				dpobCd.setValue(new BaseModel());
				payrMangDeptCd.setValue("");
				payMangeDeptNm.setValue("");
				degtrNm.setValue("");
				degtrResnRegnNum.setValue("");
				payMangeDeptZpcd.setValue("");
				payMangeDeptFNdtnAddr.setValue("");
				payMangeDeptDtlPatrAddr.setValue("");
				payMangeDeptPhnNum.setValue("");
				payMangeDeptFaxNum.setValue("");
				busoprRgstnNum.setValue("");
				corpRgstnNum.setValue("");
				payMangeDeptSealFlNm.setUrl(GWT.getHostPageBaseURL()+MSFMainApp.getMsg("PayGen.NonExTermPhoto"));
				payMangeDeptSealFlNmFile.setValue("");
				hlthInsrSym.setValue("");
				hlthInsrOfceSym.setValue("");
				natPennSym.setValue("");
				umytInsrSym.setValue("");
				idtlAccdtInsurSym.setValue("");
				payMangeDeptFNdtnUseYn.setValue(false);
				
				corpDivCd.setValue(new BaseModel());
				payMangeDeptWhlePernChrg.setValue("");
				payMangeDeptDivTskOffr.setValue("");
				accCd.setValue(new BaseModel());
				
				//CLLN_DEBR_NM.setValue("");
				cllnDebrNm.setValue(new BaseModel());
				hmtxId.setValue("");
				txOffcCd.setValue("");		
				bnkCd.setValue(new BaseModel());			
				groTnsrCd.setValue("");	
				// 조회버튼 클릭시 처리
				reload();
			}
		});

		plFrmBass0150.add(topBass0150Bar);

		// 파일업로드 처리 - 사업장 직인 정보
		plFrmBass0150.setAction("myurl"); // url 정보 추가 할것.
		plFrmBass0150.setEncoding(Encoding.MULTIPART);
		plFrmBass0150.setMethod(Method.POST);


		vp.add(plFrmBass0150);
		//엣지변환
		//plFrmBass0150.setSize("990px", "680px");
		plFrmBass0150.setSize("990px", "730px");
	}

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 검색 함수 선언부 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	private void createSearchForm() {

		LayoutContainer lcSchCol = new LayoutContainer();
		lcSchCol.setLayout(new ColumnLayout());

		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("검색조건");
		/****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 시작
		 ****************************************************************/
		fieldSet.addStyleName("x-fieldset-serarch-back-color");
		/****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 끝
		 ****************************************************************/
		LayoutContainer lcSchLeft = new LayoutContainer();
		lcSchLeft.setStyleAttribute("paddingRight", "100px");
		FormLayout frmlytSchLeft = new FormLayout();
		frmlytSchLeft.setLabelWidth(85);
		frmlytSchLeft.setLabelAlign(LabelAlign.RIGHT);
		frmlytSchLeft.setDefaultWidth(100);
		lcSchLeft.setLayout(frmlytSchLeft);

		LayoutContainer lcSchRight = new LayoutContainer();
		lcSchRight.setStyleAttribute("paddingRight", "100px");
		FormLayout frmlytSchRight = new FormLayout();
		frmlytSchRight.setLabelWidth(85);
		frmlytSchRight.setLabelAlign(LabelAlign.RIGHT);
		lcSchRight.setLayout(frmlytSchRight);

		srhPayrMangeDeptNm = new TextField<String>();
		srhPayrMangeDeptNm.setName("srhPayrMangeDeptNm");
		srhPayrMangeDeptNm.setFieldLabel("부서명");
		//srhDpobNm.setAllowBlank(false);
		lcSchLeft.add(srhPayrMangeDeptNm, new FormData("90%"));

		srhDegtrNm = new TextField<String>();
		srhDegtrNm.setName("srhDegtrNm");
		srhDegtrNm.setFieldLabel("대표자명");
		lcSchRight.add(srhDegtrNm, new FormData("90%"));

		lcSchCol.add(lcSchLeft, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		lcSchCol.add(lcSchRight, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		fieldSet.add(lcSchCol, new FormData("90%"));

		plFrmBass0150.add(fieldSet);

	}

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 검색 함수 선언부 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 기본등록화면 입력 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	
	private void fnPopupCmmn0320() {

		MSFFormPanel popCom0120 = SysComPopupUtils.lovPopUpMsfCom0120Form(); // 인사

		final FormBinding popBindingCom0120 = popCom0120.getFormBinding();

		popBindingCom0120.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				BaseModel mapModel = (BaseModel) be.getSource();
				if (!"".equals(mapModel.get("zpcd"))) {

					payMangeDeptZpcd.setValue(MSFSharedUtils.allowNulls(mapModel.get("zpcd")));
					payMangeDeptFNdtnAddr.setValue(MSFSharedUtils.allowNulls(mapModel.get("fnDtnAddr"))); 		// 앞주소
					payMangeDeptDtlPatrAddr.setValue(MSFSharedUtils.allowNulls(mapModel.get("dtlPatrAddr"))); 	// 뒷주소
				}

			}
		});
	}
	
	private void createStandardForm() {
		
		FieldSet fieldSetStdForm = new FieldSet();
		fieldSetStdForm.setHeadingHtml("상세정보");
		
		LayoutContainer lcTop = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lcTop1 = new LayoutContainer();
		LayoutContainer lcTop2 = new LayoutContainer();
		LayoutContainer lcTop3 = new LayoutContainer();
		LayoutContainer lcTop4 = new LayoutContainer();
		
		
		LayoutContainer lc1 = new LayoutContainer();
		//lc1.setStyleAttribute("paddingRight", "10px");
		FormLayout fl1 = new FormLayout();
		fl1.setLabelWidth(100);
		fl1.setLabelAlign(LabelAlign.RIGHT);
		lc1.setLayout(fl1);
		
		dpobCd = new MSFComboBox<BaseModel>();
		dpobCd.setFieldLabel("사업장명");
		dpobCd.setForceSelection(true);
		dpobCd.setMinChars(1);
		dpobCd.setDisplayField("commCdNm");
		dpobCd.setValueField("commCd");
		dpobCd.setTriggerAction(TriggerAction.ALL);
		dpobCd.setEmptyText("--사업장명선택--");  
		dpobCd.setSelectOnFocus(true);
		dpobCd.setStore(listStoreDpobCd);
		
		lc1.add(dpobCd, new FormData("90%"));
		lcTop1.add(lc1);
		
		LayoutContainer lc2 = new LayoutContainer();
		FormLayout fl2 = new FormLayout();
		fl2.setLabelWidth(100);
		fl2.setLabelAlign(LabelAlign.RIGHT);
		lc2.setLayout(fl2);
		
		degtrNm = new MSFTextField();
		degtrNm.setFieldLabel("대표자 성명");
		degtrNm.setMaxLength(30);
		lc2.add(degtrNm, new FormData("90%"));
		lcTop1.add(lc2);
		
		
		LayoutContainer lc4 = new LayoutContainer(new ColumnLayout());
		LayoutContainer lc3 = new LayoutContainer();
		FormLayout fl3 = new FormLayout();
		fl3.setLabelWidth(100);
		fl3.setLabelAlign(LabelAlign.RIGHT);
		lc3.setLayout(fl3);
		payMangeDeptZpcd = new MSFTextField(); 
		payMangeDeptZpcd.setFieldLabel("주소");
		//PAY_MANGE_DEPT_ZPCD.setMaxLength(6);
		lc3.add(payMangeDeptZpcd, new FormData("90%"));
		
		LayoutContainer lc5 = new LayoutContainer();
		Button btn = new Button("검색");
		btn.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				/**
				   * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				   * 우편번호 팝업   -- 팝업호출을 위해 추가한 부분으로 임시로 공통팝업을 호출하는예시 넣음. 우편번호 완성후 변경처리  시작
				   * 추후 메서드 형태로 지원하도록 수정 
				   * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				   */       
		 
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

						/**
				   * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				   * 우편번호 팝업 -- 팝업호출을 위해 추가한 부분으로 임시로 공통팝업을 호출하는예시 넣음. 우편번호 완성후 변경처리  끝
				   * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				   */ 
            }  
        });
		lc5.add(btn, new FormData("90%"));
		
		lc4.add(lc3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.75));
		lc4.add(lc5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		
		lcTop1.add(lc4);
		
		LayoutContainer lc6 = new LayoutContainer();
		FormLayout fl6 = new FormLayout();
		fl6.setLabelWidth(100);
		fl6.setLabelAlign(LabelAlign.RIGHT);
		lc6.setLayout(fl6);
		payMangeDeptPhnNum = new MSFTextField(); 
		payMangeDeptPhnNum.setFieldLabel("전화번호");
		payMangeDeptPhnNum.setMaxLength(20);
		lc6.add(payMangeDeptPhnNum, new FormData("90%"));
		lcTop1.add(lc6);
		
		LayoutContainer lc17 = new LayoutContainer(new ColumnLayout());
		FormLayout fl17 = new FormLayout();
		fl17.setLabelWidth(100);
		fl17.setLabelAlign(LabelAlign.RIGHT);
		lc17.setLayout(fl17);
		
		pmdPernKey = new HiddenField<String>();
		pmdPernKey.setName("pmdPernKey");
		pmdPernKey.setFieldLabel("pmdPernKey");
		
		Button btnpayMangeDeptWhlePernChrg = new Button();
		btnpayMangeDeptWhlePernChrg.setIcon(MSFMainApp.ICONS.search());
		btnpayMangeDeptWhlePernChrg.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				if (MSFSharedUtils.allowNulls(payMangeDeptWhlePernChrg.getValue()).trim().equals("")) {
					pmdPernKey.setValue("");
				}
				fnPopupCommP980(payMangeDeptWhlePernChrg.getValue(), "Chrg");
			}
		});
		
		payMangeDeptWhlePernChrg = new TextFieldWithButton<String>(btnpayMangeDeptWhlePernChrg); 
		payMangeDeptWhlePernChrg.setFieldLabel("업무담당자");
		payMangeDeptWhlePernChrg.setMaxLength(20);
		payMangeDeptWhlePernChrg.addKeyListener(new KeyListener() {
			public void componentKeyDown(ComponentEvent event) {
				pmdPernKey.validate();
				
				if (MSFSharedUtils.allowNulls(payMangeDeptWhlePernChrg.getValue()).trim().equals("")) {
					pmdPernKey.setValue("");
				}if (MSFSharedUtils.paramNull(payMangeDeptWhlePernChrg.getValue())) {
					pmdPernKey.setValue("");
				}
 			 	if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
			 		fnPopupCommP980(payMangeDeptWhlePernChrg.getValue(), "Chrg");
				}
				super.componentKeyDown(event);
			}
		});
	
//		payMangeDeptWhlePernChrg.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//			@Override
//			public void handleEvent(BaseEvent be) {  
//				
//				if (MSFSharedUtils.allowNulls(payMangeDeptWhlePernChrg.getValue()).trim().equals("")) {
//					pmdPernKey.setValue("");
//				}if (MSFSharedUtils.paramNull(payMangeDeptWhlePernChrg.getValue())) {
//					pmdPernKey.setValue("");
//				}   
//			} 
//		}); 
		lc17.add(payMangeDeptWhlePernChrg, new FormData("90%"));
		
		lcTop1.add(lc17);
		
		LayoutContainer lc18 = new LayoutContainer();
		FormLayout fl18 = new FormLayout();
		fl18.setLabelWidth(100);
		fl18.setLabelAlign(LabelAlign.RIGHT);
		lc18.setLayout(fl18);
		
		accCd = new MSFComboBox<BaseModel>();
		accCd.setFieldLabel("회계코드");
		accCd.setForceSelection(true);
		accCd.setMinChars(1);
		accCd.setDisplayField("commCdNm");
		accCd.setValueField("commCd");
		accCd.setTriggerAction(TriggerAction.ALL);
		accCd.setEmptyText("--회계코드선택--");  
		accCd.setSelectOnFocus(true);
		accCd.setStore(listStoreAccCd);
		lc18.add(accCd, new FormData("90%"));
		lcTop1.add(lc18);
		
		LayoutContainer lc19 = new LayoutContainer();
		FormLayout fl19 = new FormLayout();
		fl19.setLabelWidth(100);
		fl19.setLabelAlign(LabelAlign.RIGHT);
		lc19.setLayout(fl19);
		
		txOffcCd = new MSFTextField(); 
		txOffcCd.setFieldLabel("세무서코드");
		txOffcCd.setMaxLength(6);
		lc19.add(txOffcCd, new FormData("90%"));
		lcTop1.add(lc19);
		
		LayoutContainer lc26 = new LayoutContainer();
		payMangeDeptFNdtnUseGrp = new CheckBoxGroup();
		payMangeDeptFNdtnUseGrp.setName("payMangeDeptFNdtnUseGrp");
		payMangeDeptFNdtnUseGrp.setLabelSeparator("");
		FormLayout fl26 = new FormLayout();
		fl26.setLabelWidth(100);
		fl26.setLabelAlign(LabelAlign.RIGHT);
		lc26.setLayout(fl26);
		payMangeDeptFNdtnUseYn = new CheckBox();
		payMangeDeptFNdtnUseYn.setName("payMangeDeptFNdtnUseYn");
		payMangeDeptFNdtnUseYn.setBoxLabel("기본사용여부");
		payMangeDeptFNdtnUseYn.setHideLabel(true);
		payMangeDeptFNdtnUseGrp.add(payMangeDeptFNdtnUseYn);
		lc26.add(payMangeDeptFNdtnUseGrp, new FormData("100%"));
		lcTop1.add(lc26);
		
		LayoutContainer lc7 = new LayoutContainer();
//		LayoutContainer lc7_1 = new LayoutContainer();
//		FormLayout fl7_1 = new FormLayout();
//		fl7_1.setLabelWidth(80);
//		fl7_1.setLabelAlign(LabelAlign.RIGHT);
//		lc7_1.setLayout(fl7_1);
		//LayoutContainer lc7 = new LayoutContainer();
		FormLayout fl7 = new FormLayout();
		fl7.setLabelWidth(95);
		fl7.setLabelAlign(LabelAlign.RIGHT);
		lc7.setLayout(fl7);
		
		deptKey = new HiddenField<String>();
		deptKey.setName("deptKey");
		deptKey.setFieldLabel("deptKey");
		
		payrMangDeptCd = new MSFTextField(); 
		payrMangDeptCd.setFieldLabel("단위기관코드");
		payrMangDeptCd.setMaxLength(14);
		payrMangDeptCd.setReadOnly(true);
		lc7.add(payrMangDeptCd, new FormData("90%"));
		
		
//		Button btnPayrMangDeptCd = new Button();
//		btnPayrMangDeptCd.setIcon(MSFMainApp.ICONS.search());
//		btnPayrMangDeptCd.addListener(Events.Select, new Listener<ButtonEvent>() {
//            public void handleEvent(ButtonEvent e) { 
//                if (MSFSharedUtils.allowNulls(payrMangDeptCd.getValue()).trim().equals("")) {
//                	deptKey.setValue("");
//                }
//                fnPopupCommP140(payrMangDeptCd.getValue()); 
//            }
//        });
//
//		payrMangDeptCd = new TextFieldWithButton<String>(btnPayrMangDeptCd); 
//		payrMangDeptCd.setFieldLabel("단위기관코드");
//		payrMangDeptCd.setMaxLength(14);
//		payrMangDeptCd.setReadOnly(true);
//		payrMangDeptCd.addKeyListener(new KeyListener() {
//            public void componentKeyUp(ComponentEvent event) {
//                super.componentKeyUp(event); 
//                if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
//                    if (MSFSharedUtils.allowNulls(payrMangDeptCd.getValue()).trim().equals("")) {
//                    	deptKey.setValue("");
//                    }
//                    fnPopupCommP140(payrMangDeptCd.getValue());
//                }
//            }
//        });
//		payrMangDeptCd.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//            @Override
//            public void handleEvent(BaseEvent be) { 
//             if (MSFSharedUtils.allowNulls(payrMangDeptCd.getValue()).trim().equals("")) {
//            	 deptKey.setValue("");
//             }
//               if (MSFSharedUtils.paramNull(payrMangDeptCd.getValue())) {
//            	   deptKey.setValue("");
//               }   
//            } 
//		}); 
//		lc7.add(payrMangDeptCd, new FormData("90%"));
		 
		lcTop2.add(lc7);
		
		LayoutContainer lc8 = new LayoutContainer();
		FormLayout fl8 = new FormLayout();
		fl8.setLabelWidth(95);
		fl8.setLabelAlign(LabelAlign.RIGHT);
		lc8.setLayout(fl8);
		degtrSecRegnNum = new HiddenField<String>();
		degtrResnRegnNum = new MSFTextField(); 
		degtrResnRegnNum.setFieldLabel("대표자주민번호");
		new TextFieldMask<String>(degtrResnRegnNum, "999999-9999999");
		degtrResnRegnNum.setMaxLength(14);
		lc8.add(degtrResnRegnNum, new FormData("90%"));
		lcTop2.add(lc8);
		
		LayoutContainer lc9 = new LayoutContainer();
		payMangeDeptFNdtnAddr = new MSFTextField();
		payMangeDeptFNdtnAddr.setWidth(215);
		payMangeDeptFNdtnAddr.setMaxLength(300);
		lc9.add(payMangeDeptFNdtnAddr, new FormData("100%"));
		lcTop2.add(lc9, new FormData("90%"));
		
		LayoutContainer lc10 = new LayoutContainer();
		FormLayout fl10 = new FormLayout();
		fl10.setLabelWidth(95);
		fl10.setLabelAlign(LabelAlign.RIGHT);
		lc10.setLayout(fl10);
		payMangeDeptFaxNum = new MSFTextField(); 
		payMangeDeptFaxNum.setFieldLabel("사업장팩스번호");
		payMangeDeptFaxNum.setMaxLength(20);
		lc10.add(payMangeDeptFaxNum, new FormData("90%"));
		lcTop2.add(lc10);
		
		LayoutContainer lc20 = new LayoutContainer();
		FormLayout fl20 = new FormLayout();
		fl20.setLabelWidth(95);
		fl20.setLabelAlign(LabelAlign.RIGHT);
		lc20.setLayout(fl20);
		pmdDivKey = new HiddenField<String>();
		pmdDivKey.setName("pmdDivKey");
		pmdDivKey.setFieldLabel("pmdDivKey");
		Button btnPayMangeDeptDivTskOffr = new Button();
		btnPayMangeDeptDivTskOffr.setIcon(MSFMainApp.ICONS.search());
		btnPayMangeDeptDivTskOffr.addListener(Events.Select, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent e) { 
                if (MSFSharedUtils.allowNulls(payMangeDeptDivTskOffr.getValue()).trim().equals("")) {
                	pmdDivKey.setValue("");
                }
                fnPopupCommP980(payMangeDeptDivTskOffr.getValue(), "Offr") ; 
            }
        });
		payMangeDeptDivTskOffr = new TextFieldWithButton<String>(btnPayMangeDeptDivTskOffr); 
		payMangeDeptDivTskOffr.setFieldLabel("분임지출관");
		payMangeDeptDivTskOffr.setMaxLength(20);
 		payMangeDeptDivTskOffr.addKeyListener(new KeyListener() {
            public void componentKeyDown(ComponentEvent event) {
               
                pmdDivKey.validate();
                
                if (MSFSharedUtils.allowNulls(payMangeDeptDivTskOffr.getValue()).trim().equals("")) {
                	pmdDivKey.setValue("");
                }if (MSFSharedUtils.paramNull(payMangeDeptDivTskOffr.getValue())) {
                	pmdDivKey.setValue("");
                }
                
                if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
                	
                	fnPopupCommP980(payMangeDeptDivTskOffr.getValue(), "Offr");
                }
                super.componentKeyDown(event);
            }
         });
//		payMangeDeptDivTskOffr.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//            @Override
//            public void handleEvent(BaseEvent be) {  
//                if (MSFSharedUtils.allowNulls(payMangeDeptDivTskOffr.getValue()).trim().equals("")) {
//                	pmdDivKey.setValue("");
//                }if (MSFSharedUtils.paramNull(payMangeDeptDivTskOffr.getValue())) {
//                	pmdDivKey.setValue("");
//                }  
//            } 
//      }); 
		lc20.add(payMangeDeptDivTskOffr, new FormData("90%"));
		
		lcTop2.add(lc20);
		
		LayoutContainer lc21 = new LayoutContainer();
		FormLayout fl21 = new FormLayout();
		fl21.setLabelWidth(95);
		fl21.setLabelAlign(LabelAlign.RIGHT);
		lc21.setLayout(fl21);
		//CLLN_DEBR_NM = new TextField<String>(); 
		cllnDebrNm = new MSFComboBox<BaseModel>();
		cllnDebrNm.setFieldLabel("징수의무자");
		//CLLN_DEBR_NM.setMaxLength(40);
		cllnDebrNm.setForceSelection(true);
		cllnDebrNm.setMinChars(1);
		cllnDebrNm.setDisplayField("commCdNm");
		cllnDebrNm.setValueField("commCd");
		//cllnDebrNm.setTriggerAction(TriggerAction.ALL);
		cllnDebrNm.setEmptyText("--징수의무자선택--");  
		cllnDebrNm.setSelectOnFocus(true);
		cllnDebrNm.setStore(lsRetryCllnDebrDivNm);
		lc21.add(cllnDebrNm, new FormData("90%"));
		lcTop2.add(lc21);
		
		LayoutContainer lc22 = new LayoutContainer();
		FormLayout fl22 = new FormLayout();
		fl22.setLabelWidth(95);
		fl22.setLabelAlign(LabelAlign.RIGHT);
		lc22.setLayout(fl22);
		bnkCd = new MSFComboBox<BaseModel>();
		bnkCd.setFieldLabel("은행코드");
		bnkCd.setForceSelection(true);
		bnkCd.setMinChars(1);
		bnkCd.setDisplayField("commCdNm");
		bnkCd.setValueField("commCd");
		bnkCd.setTriggerAction(TriggerAction.ALL);
		bnkCd.setEmptyText("--은행코드선택--");  
		bnkCd.setSelectOnFocus(true);
		bnkCd.setStore(listStoreBnkCd);
		lc22.add(bnkCd, new FormData("90%"));
		lcTop2.add(lc22);
		
		LayoutContainer lc11 = new LayoutContainer();
		FormLayout fl11 = new FormLayout();
		fl11.setLabelWidth(80);
		fl11.setLabelAlign(LabelAlign.RIGHT);
		lc11.setLayout(fl11);
		
		
//		payMangeDeptNm = new MSFTextField(); 
//		payMangeDeptNm.setFieldLabel("단위기관");
//		payMangeDeptNm.setMaxLength(200);
		
		Button btnPayrMangDeptCd = new Button();
		btnPayrMangDeptCd.setIcon(MSFMainApp.ICONS.search());
		btnPayrMangDeptCd.addListener(Events.Select, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent e) { 
                if (MSFSharedUtils.allowNulls(payMangeDeptNm.getValue()).trim().equals("")) {
                	deptKey.setValue("");
                	payrMangDeptCd.setValue("");
                }
                fnPopupCommP140(payMangeDeptNm.getValue()); 
            }
        });
		
		payMangeDeptNm = new TextFieldWithButton<String>(btnPayrMangDeptCd); 
		payMangeDeptNm.setFieldLabel("단위기관");
		payMangeDeptNm.setMaxLength(200);  
		payMangeDeptNm.addKeyListener(new KeyListener() {
            public void componentKeyDown(ComponentEvent event) {
                if (MSFSharedUtils.allowNulls(payMangeDeptNm.getValue()).trim().equals("")) {
               	 deptKey.setValue("");
               	 payrMangDeptCd.setValue("");
                } else if (MSFSharedUtils.paramNull(payMangeDeptNm.getValue())) {
               	   deptKey.setValue("");
               	   payrMangDeptCd.setValue("");
                } 
                
                if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
                    
                    fnPopupCommP140(payMangeDeptNm.getValue());
                }
                
                super.componentKeyDown(event);
            }
        });
//		payMangeDeptNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//            @Override
//            public void handleEvent(BaseEvent be) { 
//             if (MSFSharedUtils.allowNulls(payMangeDeptNm.getValue()).trim().equals("")) {
//            	 deptKey.setValue("");
//            	 payrMangDeptCd.setValue("");
//             } else if (MSFSharedUtils.paramNull(payMangeDeptNm.getValue())) {
//            	   deptKey.setValue("");
//            	   payrMangDeptCd.setValue("");
//             }   
//            } 
//		}); 
		lc11.add(payMangeDeptNm, new FormData("90%"));
		lcTop3.add(lc11);
		
		LayoutContainer lc12 = new LayoutContainer();
		FormLayout fl12 = new FormLayout();
		fl12.setLabelWidth(80);
		fl12.setLabelAlign(LabelAlign.RIGHT);
		lc12.setLayout(fl12);
		busoprRgstnNum = new MSFTextField(); 
		busoprRgstnNum.setFieldLabel("사업자번호");
		new TextFieldMask<String>(busoprRgstnNum, "999-99-99999");
		//BUSOPR_RGSTN_NUM.setMaxLength(10);
		lc12.add(busoprRgstnNum, new FormData("90%"));
		lcTop3.add(lc12);
		
		LayoutContainer lc13 = new LayoutContainer();
		payMangeDeptDtlPatrAddr = new MSFTextField();
		payMangeDeptDtlPatrAddr.setWidth(215);
		payMangeDeptDtlPatrAddr.setMaxLength(300);
		lc13.add(payMangeDeptDtlPatrAddr, new FormData("100%"));
		lcTop3.add(lc13, new FormData("90%"));
		
		LayoutContainer lc14 = new LayoutContainer();
		FormLayout fl14 = new FormLayout();
		fl14.setLabelWidth(80);
		fl14.setLabelAlign(LabelAlign.RIGHT);
		lc14.setLayout(fl14);
		corpRgstnNum = new MSFTextField(); 
		corpRgstnNum.setFieldLabel("법인번호");
		corpRgstnNum.setMaxLength(14);
		lc14.add(corpRgstnNum, new FormData("90%"));
		lcTop3.add(lc14);
		
		LayoutContainer lc23 = new LayoutContainer();
		FormLayout fl23 = new FormLayout();
		fl23.setLabelWidth(80);
		fl23.setLabelAlign(LabelAlign.RIGHT);
		lc23.setLayout(fl23);
		corpDivCd = new MSFComboBox<BaseModel>();
		corpDivCd.setFieldLabel("법인구분");
		corpDivCd.setForceSelection(true);
		corpDivCd.setMinChars(1);
		corpDivCd.setDisplayField("commCdNm");
		corpDivCd.setValueField("commCd");
		corpDivCd.setTriggerAction(TriggerAction.ALL);
		corpDivCd.setEmptyText("--법인구분선택--");  
		corpDivCd.setSelectOnFocus(true);
		corpDivCd.setStore(listStoreCorpDivCd);
		lc23.add(corpDivCd, new FormData("90%"));
		lcTop3.add(lc23);
		
		
		LayoutContainer lc24 = new LayoutContainer();
		FormLayout fl24 = new FormLayout();
		fl24.setLabelWidth(80);
		fl24.setLabelAlign(LabelAlign.RIGHT);
		lc24.setLayout(fl24);
		hmtxId = new MSFTextField(); 
		hmtxId.setFieldLabel("홈텍스ID");
		hmtxId.setMaxLength(20);
		lc24.add(hmtxId, new FormData("90%"));
		lcTop3.add(lc24);
		
		LayoutContainer lc25 = new LayoutContainer();
		FormLayout fl25 = new FormLayout();
		fl25.setLabelWidth(80);
		fl25.setLabelAlign(LabelAlign.RIGHT);
		lc25.setLayout(fl25);
		groTnsrCd = new MSFTextField(); 
		groTnsrCd.setFieldLabel("지로이체코드");
		groTnsrCd.setMaxLength(16);
		lc25.add(groTnsrCd, new FormData("90%"));
		lcTop3.add(lc25);
		
		
		LayoutContainer lc15 = new LayoutContainer();
		lc15.setStyleAttribute("paddingLeft", "15px");
		lc15.setStyleAttribute("paddingBottom", "4px");
		payMangeDeptSealFlNm = new Image();
		payMangeDeptSealFlNm.setUrl(GWT.getHostPageBaseURL()+MSFMainApp.getMsg("PayGen.NonExTermPhoto"));
		payMangeDeptSealFlNm.setSize("120px", "130px");
		payMangeDeptSealFlNm.setVisible(true);
		payMangeDeptSealFlNm.setTitle("사진");
		lc15.add(payMangeDeptSealFlNm);
		lcTop4.add(lc15);
		
		LayoutContainer lc16 = new LayoutContainer();
		lc16.setStyleAttribute("paddingLeft", "15px");
		payMangeDeptSealFlNmFile = new FileUploadField();
		payMangeDeptSealFlNmFile.setWidth(120);
		lc16.add(payMangeDeptSealFlNmFile, new FormData("90%"));
		lcTop4.add(lc16);
		
		
		
		
		
		//private TextField<String> PAY_MANGE_DEPT_WHLE_PERN_CHRG; //총괄담당자
		//private TextField<String> PAY_MANGE_DEPT_DIV_TSK_OFFR; //분임지출관
		//private ComboBox<BaseModel> CORP_DIV_CD; //법인구분
		
		//private ComboBox<BaseModel> ACC_CD; //회계코드
		//private TextField<String> CLLN_DEBR_NM; //징수의무자명
		//private TextField<String> HMTX_ID; //홈텍스 ID
		
		//private TextField<String> TX_OFFC_CD; //세무서코드 입력		
		//private ComboBox<BaseModel> BNK_CD; //은행코드			
		//private TextField<String> GRO_TNSR_CD; //지로이체코드	입력		
		
		
		
		
		lcTop.add(lcTop1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		lcTop.add(lcTop2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		lcTop.add(lcTop3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		lcTop.add(lcTop4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		
		fieldSetStdForm.add(lcTop);
		
		plFrmBass0150.add(fieldSetStdForm);
		
	}

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 기본등록화면 입력 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 서브 입력 폼 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	private void createStdSubFrom() {

		FieldSet fieldSetSub = new FieldSet();
		fieldSetSub.setHeadingHtml("사업장 관리번호");
		fieldSetSub.setCollapsible(false);
		
		LayoutContainer lc = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lc1 = new LayoutContainer();
		FormLayout fl1 = new FormLayout();
		fl1.setLabelWidth(60);
		fl1.setLabelAlign(LabelAlign.RIGHT);
		lc1.setLayout(fl1);
		hlthInsrSym = new MSFTextField(); 
		hlthInsrSym.setFieldLabel("건강보험");
		hlthInsrSym.setMaxLength(20);
		lc1.add(hlthInsrSym, new FormData("100%"));
		
		LayoutContainer lc5 = new LayoutContainer();
		hlthInsrOfceSym = new MSFTextField();
		hlthInsrOfceSym.setMaxLength(20);
		hlthInsrOfceSym.setWidth("100%");
		lc5.add(hlthInsrOfceSym);
		
		LayoutContainer lc2 = new LayoutContainer();
		FormLayout fl2 = new FormLayout();
		fl2.setLabelWidth(70);
		fl2.setLabelAlign(LabelAlign.RIGHT);
		lc2.setLayout(fl2);
		natPennSym = new MSFTextField(); 
		natPennSym.setFieldLabel("국민연금");
		natPennSym.setMaxLength(20);
		lc2.add(natPennSym, new FormData("100%"));
		
		LayoutContainer lc3 = new LayoutContainer();
		FormLayout fl3 = new FormLayout();
		fl3.setLabelWidth(70);
		fl3.setLabelAlign(LabelAlign.RIGHT);
		lc3.setLayout(fl3);
		umytInsrSym = new MSFTextField(); 
		umytInsrSym.setFieldLabel("고용보험");
		umytInsrSym.setMaxLength(20);
		lc3.add(umytInsrSym, new FormData("100%"));
		
		LayoutContainer lc4 = new LayoutContainer();
		FormLayout fl4 = new FormLayout();
		fl4.setLabelWidth(70);
		fl4.setLabelAlign(LabelAlign.RIGHT);
		lc4.setLayout(fl4);
		idtlAccdtInsurSym = new MSFTextField(); 
		idtlAccdtInsurSym.setFieldLabel("산재보험");
		idtlAccdtInsurSym.setMaxLength(20);
		lc4.add(idtlAccdtInsurSym, new FormData("100%"));
		
		lc.add(lc1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.19));
		lc.add(lc5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.12));
		lc.add(lc2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.23));
		lc.add(lc3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.23));
		lc.add(lc4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.23));
		
		fieldSetSub.add(lc);
		
		plFrmBass0150.add(fieldSetSub, new FormData("100%"));
	}

	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 서브 입력 폼 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 그리드 처리 함수 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	private void createListGrid() {

		FieldSet FieldSetGrid = new FieldSet();
		FieldSetGrid.setHeadingHtml("사업장정보");

		LayoutContainer lcStdGrid = new LayoutContainer();
		lcStdGrid.setStyleAttribute("paddingLeft", "5px");
		lcStdGrid.setStyleAttribute("paddingRight", "5px");
		FormLayout frmlytStd = new FormLayout();
		lcStdGrid.setLayout(frmlytStd);

		ContentPanel cpGrid = new ContentPanel();
		cpGrid.setBodyBorder(false);
		cpGrid.setHeaderVisible(false);
		cpGrid.setLayout(new FitLayout());
		cpGrid.setSize(940, 280);

		msfGridPanel = new MSFGridPanel(bass0150Def, false, false, false, true);
		msfGridPanel.setHeaderVisible(false);
		//msfGridPanel.setBodyBorder(true);
		//msfGridPanel.setBorders(true);
		
		final Grid<BaseModel> grid = msfGridPanel.getMsfGrid().getGrid();
//		
//		GridView gv = new GridView();
	
	
		//
		grid.addListener(Events.RowClick, new Listener<GridEvent<BaseModel>>() {
			@Override
			public void handleEvent(GridEvent<BaseModel> be) {
				payMangeDeptNm.focus();
				payrMangDeptCd.setReadOnly(true);
				
				BasisUtil.setSelectedComboValue(dpobCd, grid.getSelectionModel().getSelectedItem().get("dpobCd")+"");
				payrMangDeptCd.setValue(grid.getSelectionModel().getSelectedItem().get("payrMangDeptCd") == null ? "" : grid.getSelectionModel().getSelectedItem().get("payrMangDeptCd")+"");
				payMangeDeptNm.setValue(grid.getSelectionModel().getSelectedItem().get("payMangeDeptNm") == null ? "" : grid.getSelectionModel().getSelectedItem().get("payMangeDeptNm")+"");
				degtrNm.setValue(grid.getSelectionModel().getSelectedItem().get("degtrNm") == null ? "" : grid.getSelectionModel().getSelectedItem().get("degtrNm")+"");
				degtrResnRegnNum.setValue(grid.getSelectionModel().getSelectedItem().get("degtrResnRegnNum") == null ? "" : grid.getSelectionModel().getSelectedItem().get("degtrResnRegnNum")+"");
				payMangeDeptZpcd.setValue(grid.getSelectionModel().getSelectedItem().get("payMangeDeptZpcd") == null ? "" : grid.getSelectionModel().getSelectedItem().get("payMangeDeptZpcd")+"");
				payMangeDeptFNdtnAddr.setValue(grid.getSelectionModel().getSelectedItem().get("payMangeDeptFNdtnAddr") == null ? "" : grid.getSelectionModel().getSelectedItem().get("payMangeDeptFNdtnAddr")+"");
				payMangeDeptDtlPatrAddr.setValue(grid.getSelectionModel().getSelectedItem().get("payMangeDeptDtlPatrAddr") == null ? "" : grid.getSelectionModel().getSelectedItem().get("payMangeDeptDtlPatrAddr")+"");
				payMangeDeptPhnNum.setValue(grid.getSelectionModel().getSelectedItem().get("payMangeDeptPhnNum") == null ? "" : grid.getSelectionModel().getSelectedItem().get("payMangeDeptPhnNum")+"");
				payMangeDeptFaxNum.setValue(grid.getSelectionModel().getSelectedItem().get("payMangeDeptFaxNum") == null ? "" : grid.getSelectionModel().getSelectedItem().get("payMangeDeptFaxNum")+"");
				busoprRgstnNum.setValue(grid.getSelectionModel().getSelectedItem().get("busoprRgstnNum") == null ? "": grid.getSelectionModel().getSelectedItem().get("busoprRgstnNum")+"");
				corpRgstnNum.setValue(grid.getSelectionModel().getSelectedItem().get("corpRgstnNum") == null ? "" : grid.getSelectionModel().getSelectedItem().get("corpRgstnNum")+"");
				
				if( grid.getSelectionModel().getSelectedItem().get("payMangeDeptSealFlNm") != null && !"".equals(grid.getSelectionModel().getSelectedItem().get("payMangeDeptSealFlNm")) ){
					payMangeDeptSealFlNm.setUrl(GWT.getHostPageBaseURL()+MSFMainApp.getMsg("PayGen.ExTermPhoto")+"/"+grid.getSelectionModel().getSelectedItem().get("payMangeDeptSealFlNm")+"");
				}else{
					payMangeDeptSealFlNm.setUrl(GWT.getHostPageBaseURL()+MSFMainApp.getMsg("PayGen.NonExTermPhoto"));
				}
				
				hlthInsrSym.setValue(grid.getSelectionModel().getSelectedItem().get("hlthInsrSym") == null ? "" : grid.getSelectionModel().getSelectedItem().get("hlthInsrSym")+"");
				hlthInsrOfceSym.setValue(grid.getSelectionModel().getSelectedItem().get("hlthInsrOfceSym") == null ? "" : grid.getSelectionModel().getSelectedItem().get("hlthInsrOfceSym")+"");
				natPennSym.setValue(grid.getSelectionModel().getSelectedItem().get("natPennSym") == null ? "" : grid.getSelectionModel().getSelectedItem().get("natPennSym")+"");
				umytInsrSym.setValue(grid.getSelectionModel().getSelectedItem().get("umytInsrSym") == null ? "" : grid.getSelectionModel().getSelectedItem().get("umytInsrSym")+"");
				idtlAccdtInsurSym.setValue(grid.getSelectionModel().getSelectedItem().get("idtlAccdtInsurSym") == null ? "" : grid.getSelectionModel().getSelectedItem().get("idtlAccdtInsurSym")+"");
				
				payMangeDeptFNdtnUseYn.setValue("Y".equals(grid.getSelectionModel().getSelectedItem().get("payMangeDeptFNdtnUseYn")) ? true : false); //사용여부
				
				BasisUtil.setSelectedComboValue(corpDivCd, grid.getSelectionModel().getSelectedItem().get("corpDivCd")+"");
				payMangeDeptWhlePernChrg.setValue(grid.getSelectionModel().getSelectedItem().get("payMangeDeptWhlePernNm") == null ? "" : grid.getSelectionModel().getSelectedItem().get("payMangeDeptWhlePernNm")+"");
				pmdPernKey.setValue(grid.getSelectionModel().getSelectedItem().get("payMangeDeptWhlePernChrg") == null ? "" : grid.getSelectionModel().getSelectedItem().get("payMangeDeptWhlePernChrg")+"");
				
				payMangeDeptDivTskOffr.setValue(grid.getSelectionModel().getSelectedItem().get("payMangeDeptDivTskNm") == null ? "" : grid.getSelectionModel().getSelectedItem().get("payMangeDeptDivTskNm")+"");
				pmdDivKey.setValue(grid.getSelectionModel().getSelectedItem().get("payMangeDeptDivTskOffr") == null ? "" : grid.getSelectionModel().getSelectedItem().get("payMangeDeptDivTskOffr")+"");
				BasisUtil.setSelectedComboValue(accCd, grid.getSelectionModel().getSelectedItem().get("accCd")+"");
				//CLLN_DEBR_NM.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("cllnDebrNm") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("cllnDebrNm")+"");
				BasisUtil.setSelectedComboValue(cllnDebrNm, grid.getSelectionModel().getSelectedItem().get("cllnDebrNm")+"");
				hmtxId.setValue(grid.getSelectionModel().getSelectedItem().get("hmtxId") == null ? "" : grid.getSelectionModel().getSelectedItem().get("hmtxId")+"");
				
				txOffcCd.setValue(grid.getSelectionModel().getSelectedItem().get("txOffcCd") == null ? "" : grid.getSelectionModel().getSelectedItem().get("txOffcCd")+"");		
				BasisUtil.setSelectedComboValue(bnkCd, grid.getSelectionModel().getSelectedItem().get("bnkCd")+"");
				groTnsrCd.setValue(grid.getSelectionModel().getSelectedItem().get("groTnsrCd") == null ? "" : grid.getSelectionModel().getSelectedItem().get("groTnsrCd")+"");	
				
				
				actionDatabase = ActionDatabase.UPDATE;
//				BasisUtil.setSelectedComboValue(dpobCd, grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("dpobCd")+"");
//				payrMangDeptCd.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("payrMangDeptCd") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("payrMangDeptCd")+"");
//				payMangeDeptNm.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("payMangeDeptNm") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("payMangeDeptNm")+"");
//				degtrNm.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("degtrNm") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("degtrNm")+"");
//				degtrResnRegnNum.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("degtrResnRegnNum") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("degtrResnRegnNum")+"");
//				payMangeDeptZpcd.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("payMangeDeptZpcd") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("payMangeDeptZpcd")+"");
//				payMangeDeptFNdtnAddr.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("payMangeDeptFNdtnAddr") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("payMangeDeptFNdtnAddr")+"");
//				payMangeDeptDtlPatrAddr.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("payMangeDeptDtlPatrAddr") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("payMangeDeptDtlPatrAddr")+"");
//				payMangeDeptPhnNum.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("payMangeDeptPhnNum") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("payMangeDeptPhnNum")+"");
//				payMangeDeptFaxNum.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("payMangeDeptFaxNum") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("payMangeDeptFaxNum")+"");
//				busoprRgstnNum.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("busoprRgstnNum") == null ? "": grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("busoprRgstnNum")+"");
//				corpRgstnNum.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("corpRgstnNum") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("corpRgstnNum")+"");
//				
//				if( grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("payMangeDeptSealFlNm") != null && !"".equals(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("payMangeDeptSealFlNm")) ){
//					payMangeDeptSealFlNm.setUrl(GWT.getHostPageBaseURL()+MSFMainApp.getMsg("PayGen.ExTermPhoto")+"/"+grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("payMangeDeptSealFlNm")+"");
//				}else{
//					payMangeDeptSealFlNm.setUrl(GWT.getHostPageBaseURL()+MSFMainApp.getMsg("PayGen.NonExTermPhoto"));
//				}
//				
//				hlthInsrSym.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("hlthInsrSym") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("hlthInsrSym")+"");
//				hlthInsrOfceSym.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("hlthInsrSym") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("hlthInsrOfceSym")+"");
//				natPennSym.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("natPennSym") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("natPennSym")+"");
//				umytInsrSym.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("umytInsrSym") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("umytInsrSym")+"");
//				idtlAccdtInsurSym.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("idtlAccdtInsurSym") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("idtlAccdtInsurSym")+"");
//				
//				payMangeDeptFNdtnUseYn.setValue("Y".equals(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("payMangeDeptFNdtnUseYn")) ? true : false); //사용여부
//				
//				BasisUtil.setSelectedComboValue(corpDivCd, grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("corpDivCd")+"");
//				payMangeDeptWhlePernChrg.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("payMangeDeptWhlePernChrg") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("payMangeDeptWhlePernChrg")+"");
//				
//				payMangeDeptDivTskOffr.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("payMangeDeptDivTskOffr") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("payMangeDeptDivTskOffr")+"");
//				
//				BasisUtil.setSelectedComboValue(accCd, grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("accCd")+"");
//				//CLLN_DEBR_NM.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("cllnDebrNm") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("cllnDebrNm")+"");
//				BasisUtil.setSelectedComboValue(cllnDebrNm, grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("cllnDebrNm")+"");
//				hmtxId.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("hmtxId") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("hmtxId")+"");
//				
//				txOffcCd.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("txOffcCd") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("txOffcCd")+"");		
//				BasisUtil.setSelectedComboValue(bnkCd, grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("bnkCd")+"");
//				groTnsrCd.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("groTnsrCd") == null ? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("groTnsrCd")+"");	
			}
		});
		
		cpGrid.add(msfGridPanel);
		lcStdGrid.add(cpGrid);
		FieldSetGrid.add(lcStdGrid);

		plFrmBass0150.add(FieldSetGrid);
	}
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 그리드 처리 함수 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	//단위기관코드
    private void fnPopupCommP140(String deptCd) {
        //검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
        //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
        MSFFormPanel popCom0140 = PrgmComPopupUtils.lovPopUpPrgmCom0140Form(deptCd);  //부서
        
        final FormBinding popBindingCom0140 = popCom0140.getFormBinding();
        
        popBindingCom0140.addListener(Events.Change, new Listener<BaseEvent>() {
        public void handleEvent(BaseEvent be) {
            BaseModel mapModel = (BaseModel)be.getSource();
            if (!"".equals(mapModel.get("deptCd"))) {  
            	payrMangDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
            	payMangeDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt"))); 
            	}
           	}
        });
    }
    //담당자, 분임지출관
    private void fnPopupCommP980(String usrNm, final String flag) {
        MSFFormPanel popCom0980 = SysComPopupUtils.lovPopUpMsfSysComP0980Form(usrNm);  //부서
        
        final FormBinding popBindingCom0980 = popCom0980.getFormBinding();
        popBindingCom0980.addListener(Events.Change, new Listener<BaseEvent>() {
        public void handleEvent(BaseEvent be) {
            BaseModel mapModel = (BaseModel)be.getSource();
            if (!"".equals(mapModel.get("usrId"))) {
            	if("Chrg".equals(flag)) {
            		payMangeDeptWhlePernChrg.setValue(MSFSharedUtils.allowNulls(mapModel.get("usrNm")));
            		pmdPernKey.setValue(MSFSharedUtils.allowNulls(mapModel.get("usrId")));
            	}else if("Offr".equals(flag)){
            		payMangeDeptDivTskOffr.setValue(MSFSharedUtils.allowNulls(mapModel.get("usrNm")));
            		pmdDivKey.setValue(MSFSharedUtils.allowNulls(mapModel.get("usrId")));
            		}
            	}
           	}
        });
    }
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/

	public void reload() {
		
		dpobCd.setValue(new BaseModel());		//사업장
		payrMangDeptCd.setValue("");			//부서코드
		payrMangDeptCd.setReadOnly(true);		//단위기관코드
		payMangeDeptNm.setValue("");			//부서명
		degtrNm.setValue("");					//대표자성명
		degtrResnRegnNum.setValue("");			//주민번호
		payMangeDeptZpcd.setValue("");			//사업장주소
		payMangeDeptFNdtnAddr.setValue("");		//사업장 기본주소
		payMangeDeptDtlPatrAddr.setValue("");	//사업장 상세주소
		payMangeDeptPhnNum.setValue("");		//전화번호
		payMangeDeptFaxNum.setValue("");		//팩스번호
		busoprRgstnNum.setValue("");			//사업자번호
		corpRgstnNum.setValue("");				//법인번호
		payMangeDeptSealFlNm.setUrl(GWT.getHostPageBaseURL()+MSFMainApp.getMsg("PayGen.NonExTermPhoto"));
		payMangeDeptSealFlNmFile.setValue("");	
		hlthInsrSym.setValue("");				//건강보험 기호
		hlthInsrOfceSym.setValue("");			//건강보험영업소기호
		natPennSym.setValue("");				//국민연금 기호
		umytInsrSym.setValue("");				//고용보험 기호
		idtlAccdtInsurSym.setValue("");			//산재보험 기호
		payMangeDeptFNdtnUseYn.setValue(false);	//급여관리부서기본사용여부
		corpDivCd.setValue(new BaseModel());	//법인구분
		payMangeDeptWhlePernChrg.setValue("");	//총괄담당자
		payMangeDeptDivTskOffr.setValue("");	//분임지출관
		accCd.setValue(new BaseModel());		//회계코드
		cllnDebrNm.setValue(new BaseModel());	//징수의무자
		hmtxId.setValue("");					//홈텍스 ID
		txOffcCd.setValue("");					//세무서코드 입력		
		bnkCd.setValue(new BaseModel());		//은행코드					
		groTnsrCd.setValue("");					//지로이체코드 입력		
		
		IColumnFilter filters = null;
		msfGridPanel.getTableDef().setTableColumnFilters(filters);
		msfGridPanel.getTableDef().addColumnFilter("srhPayrMangeDeptNm", srhPayrMangeDeptNm.getValue(), SimpleColumnFilter.OPERATOR_LIKE);	// 단위기관명
		msfGridPanel.getTableDef().addColumnFilter("srhDegtrNm", srhDegtrNm.getValue(), SimpleColumnFilter.OPERATOR_LIKE);					// 대표자명
		
		msfGridPanel.reload();
		// payr0301GridPanel.getTableDef().setTableColumnFilters(filters);

		// payr0301GridPanel.getTableDef().addColumnFilter("pubcHodyCtnt",
		// srhPubcHodyCtnt.getRawValue(), SimpleColumnFilter.OPERATOR_LIKE);

		// payr0301GridPanel.reload();
	}

	public void setRecord(BaseModel record) {
		this.record = record;
	}

	private Bass0150 getThis() {
		return this;
	}
	 
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
