package com.app.exterms.basis.client.form;

import java.util.HashMap;
import java.util.List;

import com.app.exterms.basis.client.dto.Bass0120DTO;
import com.app.exterms.basis.client.form.defs.Bass0120Def;
import com.app.exterms.basis.client.languages.BasisConstants;
import com.app.exterms.basis.client.service.Bass0120Service;
import com.app.exterms.basis.client.service.Bass0120ServiceAsync;
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
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.app.smrmf.syscom.client.util.SysComPopupUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FormEvent;
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
import com.extjs.gxt.ui.client.widget.layout.ColumnData;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Image;

/**
 * @Class Name : Bass0120.java
 * @Description : 사업장관리
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 **/

/**
 * =========================================================================
 * 디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다. extends MSFPanel -> extends
 * LayoutContainer implements IMSFWindow { 상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리
 * 해야함. MSFPanel
 * =========================================================================
 **/
public class Bass0120 extends MSFPanel {
	
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 전역변수 선언부 시작
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 **/
	
	// -------------- 상단 버튼 시작 --------------
	private ButtonBar topBass0120Bar;
	private Button btnBass0120New; 
	private Button btnBass0120Save;
	private Button btnBass0120Del;
	private Button btnBass0120Sreach;
	// -------------- 상단 버튼 종료 --------------
	
	// -------------- 검색조건 시작 -------------- 
	private TextField<String> srhDpobNm;	// 사업장명
	private TextField<String> srhDegtrNm; 	// 대표자명
	// -------------- 검색조건 종료 -------------- 

	// private ComboBox<BaseModel> tplvlDpobCd; //사업장 상위구분
	// private TextField<String> DPOB_CD; //사업장코드
	// private TextField<String> DPOB_NM; //사업장명
	// private TextField<String> DEGTR_NM; //대표자성명
	// private TextField<String> DEGTR_RESN_REGN_NUM; //주민번호
	// private TextField<String> DPOB_ZPCD; //사업장주소
	// private TextField<String> DPOB_FNDTN_ADDR; //사업장 기본주소
	// private TextField<String> DPOB_DTL_PATR_ADDR; //사업장 상세주소
	// private TextField<String> DPOB_PHN_NUM; //전화번호
	// private TextField<String> DPOB_FAX_NUM; //팩스번호
	// private TextField<String> BUSOPR_RGSTN_NUM; //사업자번호
	// private TextField<String> CORP_RGSTN_NUM; //법인번호
	// private Image DPOB_SEAL_FL_NM; //직인사진
	// private FileUploadField DPOB_SEAL_FL_NM_FILE;
	// private TextField<String> DPOB_SEAL_WRD_NM; //직인문구명
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 입력변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	
	// -------------- 상세정보 시작-------------- 
	private MSFComboBox<BaseModel> hhrkUntDpobCd; 	// 상위 단위사업장 코드
	private MSFTextField dpobCd; 										// 사업장코드
	private MSFTextField utDpobCd; 									// 단위사업장코드
	private MSFTextField utDpobNm; 									// 단위사업장명
	private MSFTextField degtrNm; 									// 대표자성명
	private MSFTextField degtrResnRegnNum; 					// 주민번호
	private HiddenField<String> degtrSecRegnNum; 			// 주민번호원본 
	private static MSFTextField untDpobZpcd; 					// 사업장주소
	private static MSFTextField untDpobFndtnAddr; 			// 사업장 기본주소
	private static MSFTextField untDpobDtlPatrAddr;	 		// 사업장 상세주소
	private MSFTextField untDpobPhnNum; 						// 단위사업장전화번호
	private MSFTextField untDpobFaxNum; 						// 단위사업장팩스번호
	private MSFTextField untDpobEctnMailAddr;					// 단위사업장팩스번호
	
	private MSFTextField untDpobBncdsNm;						// 업태
	private MSFTextField untDpobItemNm;							// 종목명
	private MSFTextField untDpobMnPrdt;							// 주생산품
	
	private MSFTextField busoprRgstnNum; 						// 사업자번호
	private MSFTextField corpRgstnNum; 							// 법인번호
	private MSFTextField untDpobSealWrdNm; 					// 단위사업장직인문구명
	private Image untDpobSealRfta; 									// 단위사업장직인경로
	private FileUploadField untDpobSealFlNm;						// 단위사업장직인파일명
	private MSFComboBox<BaseModel> mtstBusinDivCd; 	// 주종사업장구분 
	
	private CheckBoxGroup chkgrpBass0120;   					// 체크 그룹
	private CheckBox untDpobFndtnUseYn;							// 기본사용여부

	private MSFTextField upDpobCmpNo;							// 단위사업장승인번호
	private CheckBox upDpobUtynC171;								// C171_사업자단위과세자여부
	private MSFTextField mtstDpobSeilNumC172;				// C172_종사업장일련번호
	private MSFTextField mnbhDivCd;								// 본지점구분코드
	private MSFTextField whdgTxCtypDivCd;						// 원천세신고유형구분코드
	// 이미지 업로드를 위해 추가
	private HiddenField<String> frmKey;
	private HiddenField<String> imgKeyCode;
	
	private Boolean picBoolFile;
	private int iFlag = 0;
	// -------------- 상세정보 종료--------------
	
	// -------------- Store 시작 --------------
	private ListStore<BaseModel> listStoreParentDpobCd 	= new ListStore<BaseModel>(); 	// 상위사업장 코드
	private ListStore<BaseModel> lsMtstBusinDivCd		= new ListStore<BaseModel>(); 	// 주종사업장구분 코드
	// -------------- Store 종료 --------------

	
	// -------------- 서비스 호출 시작 -------------- 
	//private InfcBass0120ServiceAsync infcBass0120Service = InfcBass0120Service.Util.getInstance();
	private Bass0120ServiceAsync bass0120Service = Bass0120Service.Util.getInstance();
	private PrgmComBass0300ServiceAsync sysComBass0300Service = PrgmComBass0300Service.Util.getInstance();
	// -------------- 서비스 호출 종료 -------------- 
	
	
	// -------------- grid 시작 -------------- 
	private Bass0120Def bass0120Def = new Bass0120Def(); // 그리드 테이블 컬럼 define
	private MSFGridPanel msfGridPanel;
	
	
	private Bass0120Def mBass0120Def = new Bass0120Def("BASS0120_01"); // 주 그리드 테이블 컬럼 define
	private MSFGridPanel msfGridPanel01;
	
	private Bass0120Def sBass0120Def = new Bass0120Def("BASS0120_02"); // 종 그리드 테이블 컬럼 define
	private MSFGridPanel msfGridPanel02;
	// -------------- grid 끝 --------------  

	// -------------- 상태처리 전역변수  -------------- 
	private ActionDatabase actionDatabase;
	// -------------- 상태처리 전역변수  -------------- 
	
	// -------------- DTO 선언 시작  -------------- 
	private PrgmComBass0300DTO sysComBass0300Dto;
	// private PrgmComBass0120DTO sysComBass0120Dto;
	// -------------- DTO 선언 종료  -------------- 

	private BasisConstants lblBasisConst = BasisConstants.INSTANCE;

	private VerticalPanel vp;
	private FormPanel plFrmBass0120;

	private String txtForm = "";
	private XTemplate detailTp;

	public FormBinding formBinding;
	public FormBinding srhFormBinding;


	private BaseModel record;
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 전역변수 선언부 종료
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 **/
	
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 선택된 버튼에 따른 인서트 업데이트 삭제 처리 부
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	private SelectionListener<ButtonEvent> selectionListener = new SelectionListener<ButtonEvent>() {
		public void componentSelected(ButtonEvent ce) {
			if (ActionDatabase.INSERT.equals(actionDatabase)) {
				actionDatabase = null;
				if (ce.getButton() == btnBass0120Save) {
					doAction(ActionDatabase.INSERT);
				}
			} else if (ce.getButton() == btnBass0120Save) {
				doAction(ActionDatabase.UPDATE);
				actionDatabase = null;
			} else if (ce.getButton() == btnBass0120Del) {
				doAction(ActionDatabase.DELETE);
			}
		}
	};

	private void doAction(ActionDatabase actionDatabase) {
		save(actionDatabase);

	}

	//저장
	public void save(final ActionDatabase actionDatabase) {
		
		if("C0030020" == MSFSharedUtils.allowNulls(BasisUtil.getSelectedComboValue(mtstBusinDivCd, "commCd"))
			|| "C0030020".equals(BasisUtil.getSelectedComboValue(mtstBusinDivCd, "commCd"))
			|| MSFSharedUtils.paramNull(BasisUtil.getSelectedComboValue(mtstBusinDivCd, "commCd"))
		   ) {
			MessageBox.alert("오류", "주종사업장구분은 현재 주사업장만 가능합니다. <br> 주사업장으로 변경 후 저장해주세요.", null);
			return;
		}
		
		final Bass0120DTO dto = new Bass0120DTO();

		dto.setHhrkUntDpobCd(MSFSharedUtils.allowNulls(BasisUtil.getSelectedComboValue(hhrkUntDpobCd)));// 사업장 상위구분
		dto.setDpobCd(MSFSharedUtils.allowNulls(dpobCd.getValue())); 									// 단위사업장코드
		dto.setUtDpobNm(MSFSharedUtils.allowNulls(utDpobNm.getValue())); 								// 단위사업장명
		dto.setDegtrNm(MSFSharedUtils.allowNulls(degtrNm.getValue())); 									// 대표자성명
		dto.setDegtrResnRegnNum(MSFSharedUtils.allowNulls(degtrResnRegnNum.getValue())); 				// 주민번호
		dto.setBusoprRgstnNum(MSFSharedUtils.allowNulls(busoprRgstnNum.getValue())); 					// 사업자번호
		dto.setUntDpobZpcd(MSFSharedUtils.allowNulls(untDpobZpcd.getValue())); 							// 사업장주소
		dto.setUntDpobFndtnAddr(MSFSharedUtils.allowNulls(untDpobFndtnAddr.getValue())); 				// 사업장 기본주소
		dto.setUntDpobDtlPatrAddr(MSFSharedUtils.allowNulls(untDpobDtlPatrAddr.getValue())); 			// 사업장 상세주소
		dto.setUntDpobPhnNum(MSFSharedUtils.allowNulls(untDpobPhnNum.getValue())); 						// 전화번호
		dto.setUntDpobFaxNum(MSFSharedUtils.allowNulls(untDpobFaxNum.getValue()));	 					// 팩스번호
		dto.setCorpRgstnNum(MSFSharedUtils.allowNulls(corpRgstnNum.getValue())); 						// 법인번호
		dto.setCorpDivCd("");
		dto.setUntDpobSealWrdNm(MSFSharedUtils.allowNulls(untDpobSealWrdNm.getValue())); 				// 직인문구명
		dto.setSysDivCd("EXTERM00"); 																	// 적용시스템
		dto.setMtstBusinDivCd(MSFSharedUtils.allowNulls(
										BasisUtil.getSelectedComboValue(mtstBusinDivCd, "commCd")));	// 주종사업장구분

		dto.setUntDpobSealRfta(MSFSharedUtils.allowNulls(MSFMainApp.getMsg("PayGen.ExTermPhoto"))); 	//직인경로
		dto.setUntDpobFndtnUseYn(untDpobFndtnUseYn.getValue() ? "Y" : "N");								// 사용여부

		dto.setUntDpobEctnMailAddr(MSFSharedUtils.allowNulls(untDpobEctnMailAddr.getValue()));	// 전자우편주소
		dto.setUntDpobBncdsNm(MSFSharedUtils.allowNulls(untDpobBncdsNm.getValue()));	// 업태
		dto.setUntDpobItemNm(MSFSharedUtils.allowNulls(untDpobItemNm.getValue()));	// 종목명
		dto.setUntDpobMnPrdt(MSFSharedUtils.allowNulls(untDpobMnPrdt.getValue()));	// 주생산품
		
		dto.setUpDpobCmpNo(MSFSharedUtils.allowNulls(upDpobCmpNo.getValue()));    /** column 단위사업장승인번호 : upDpobCmpNo */
		dto.setUpDpobUtynC171(upDpobUtynC171.getValue() ? "Y" : "N");    /** column C171_사업자단위과세자여부 : upDpobUtynC171 */
		dto.setMtstDpobSeilNumC172(MSFSharedUtils.allowNulls(mtstDpobSeilNumC172.getValue()));    /** column C172_종사업장일련번호 : mtstDpobSeilNumC172 */
		dto.setMnbhDivCd(MSFSharedUtils.allowNulls(mnbhDivCd.getValue()));    /** column 본지점구분코드 : mnbhDivCd */
		dto.setWhdgTxCtypDivCd(MSFSharedUtils.allowNulls(whdgTxCtypDivCd.getValue()));    /** column 원천세신고유형구분코드 : whdgTxCtypDivCd */
		
		if ("".equals(dto.getUtDpobNm()) || dto.getUtDpobNm() == null) {
			MessageBox.info("", "사업장명은 필수 입니다.", null);
			utDpobNm.focus();
		} else if ("".equals(dto.getDegtrNm()) || dto.getDegtrNm() == null) {
			MessageBox.info("", "대표자성명은 필수 입니다.", null);
			degtrNm.focus();
		} else if ("".equals(dto.getBusoprRgstnNum())
				|| dto.getBusoprRgstnNum() == null) {
			MessageBox.info("", "사업자번호는 필수 입니다.", null);
			busoprRgstnNum.focus();
		} else if ("".equals(dto.getUntDpobZpcd()) || dto.getUntDpobZpcd() == null
				&& "".equals(dto.getUntDpobFndtnAddr())
				|| dto.getUntDpobFndtnAddr() == null) {
			MessageBox.info("", "사업장주소는 필수 입니다.", null);
			untDpobZpcd.focus();
		} else if ("".equals(dto.getUntDpobPhnNum())
				|| dto.getUntDpobPhnNum() == null) {
			MessageBox.info("", "사업장전화번호는 필수 입니다.", null);
			untDpobPhnNum.focus();
		} else if ("".equals(dto.getUntDpobFaxNum())
				|| dto.getUntDpobFaxNum() == null) {
			MessageBox.info("", "사업장팩스번호는 필수 입니다.", null);
			untDpobFaxNum.focus();
		} else {
			final String fileName = untDpobSealFlNm.getValue();
			if (!"".equals(fileName) && fileName != null) {
				// dto.setDpobSealFlNm(fileName.substring(fileName.lastIndexOf("\\")+1));
				// //사진 이미지 파일명
				dto.setUntDpobSealFlnm(dpobCd.getValue() + fileName.substring(fileName.lastIndexOf("."))); // 직인 이미지 저장시 사업자 코드로.확장자로 처리
			}
			MessageBox.confirm("", "DELETE".equals(actionDatabase.name()) ? "삭제 하시겠습니까?": "저장 하시겠습니까?", new Listener<MessageBoxEvent>() {
				@Override
				public void handleEvent(MessageBoxEvent be) {
					
					if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
						// 주사업장일 경우 한 건만 저장할 수 있게끔 해준다.
						if(dto.getMtstBusinDivCd() == "C0030010" || "C0030010".equals(dto.getMtstBusinDivCd())) {
							
							bass0120Service.chkBass0120(dto, actionDatabase, new AsyncCallback<Integer>() {

								@Override
								public void onFailure(Throwable caught) {
									// TODO Auto-generated method stub
									MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),
											MSFMainApp.ADMINMESSAGES.ExceptionMessageService("chkBass0120("+ actionDatabase.name()+ ") : "+ caught),null);
								}

								@Override
								public void onSuccess(Integer result) {
									// TODO Auto-generated method stub
									if(result == 1) {
										MessageBox.info("경고","주사업장은 1곳만 입력할 수 있습니다.</br>데이터를 확인해주세요.", null);
									}else {
										// 저장 처리
										saveBass0120(dto, actionDatabase, fileName);
									}
								}
							});
						}else {
							// 저장 처리
							saveBass0120(dto, actionDatabase, fileName);
						}
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
			      $entry(@com.app.exterms.basis.client.form.Bass0120::onCloseGwtFunction(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;));
	  }-*/;
	 public static void onCloseGwtFunction(String zpcd,String fnDtnAddr,String dtlPatrAddr )
	  { 
		  // your gwt code tobe executed 
		// Window.alert(postId);
		 untDpobZpcd.setValue(MSFSharedUtils.allowNulls(zpcd)); 
		 untDpobFndtnAddr.setValue(MSFSharedUtils.allowNulls(fnDtnAddr)); // 앞주소
		 untDpobDtlPatrAddr.setValue(MSFSharedUtils.allowNulls(dtlPatrAddr)); // 뒷주소
		    
	  }
	 /**************************************************************/
	 /** 우편번호 로직 추가    												*/
	 /**************************************************************/
		
	public ContentPanel getViewPanel() {
		
		sysComBass0300Dto = new PrgmComBass0300DTO();
		
		// --------------------공통 코드 불러 오는 함수----------------------------------------------------
		sysComBass0300Dto = new PrgmComBass0300DTO();
		sysComBass0300Dto.setRpsttvCd("C003");
		lsMtstBusinDivCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
		// -------------------------------------------------------------------------------------------
		
		if (panel == null) {
			GWTUtils.popupDoroWndClose(); 
			closeFunction();
			
			// 상위 사업장
			bass0120Service.getParentDpobCd(new AsyncCallback<List<BaseModel>>() {
				@Override
				public void onSuccess(List<BaseModel> result) {
					listStoreParentDpobCd.add(result);
				}

				@Override
				public void onFailure(Throwable caught) {
					MessageBox.alert("", "상위사업장코드 에러!", null);
				}
			});

			detailTp = XTemplate.create(getDetailTemplate());

			// formData = new FormData("-650");
			vp = new VerticalPanel();
			vp.setSpacing(10);
			createBass0120Form(); 		// 화면 기본정보를 설정
			createSearchForm(); 		// 검색필드를 적용
//			createListGrid(); 			// 사업장정보 그리드
			createStandardForm(); 		// 사업장 상세 정보
			vp.setSize("1010px", "700px");
			/**
			 * -------------------------------------------------------------------
			 * 폼 바인딩 및 공통 콤보 로딩시 처리 선언부 시작
			 * -------------------------------------------------------------------
			 */
			// 폼데이터를 바인딩
			formBinding = new FormBinding(this.plFrmBass0120, true);

			/**
			 * -------------------------------------------------------------------
			 * 폼 바인딩 및 공통 콤보 로딩시 처리 선언부 종료
			 * -------------------------------------------------------------------
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
	public Bass0120() {
		setSize("1010px", "700px");
	}

	// 생성자 함수에 변수을 받아 처리
	public Bass0120(String txtForm) {
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
	private void createBass0120Form() {

		plFrmBass0120 = new FormPanel();
		plFrmBass0120.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - " + lblBasisConst.title_Bass0120()));
		plFrmBass0120.setIcon(MSFMainApp.ICONS.text());
		plFrmBass0120.setBodyStyleName("pad-text");
		
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage(lblBasisConst.title_Bass0120(),"BASS01200");
				}
			});
		plFrmBass0120.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmBass0120.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/
		
		plFrmBass0120.setPadding(2);
		plFrmBass0120.setFrame(true);
		plFrmBass0120.setLayout(new FormLayout());

		degtrSecRegnNum = new HiddenField<String>();
		imgKeyCode = new HiddenField<String>();
		imgKeyCode.setName("imgKeyCode");
		plFrmBass0120.add(imgKeyCode);
		frmKey = new HiddenField<String>();
		frmKey.setName("frmKey");
		plFrmBass0120.add(frmKey);

		topBass0120Bar = new ButtonBar();
		topBass0120Bar.setAlignment(HorizontalAlignment.RIGHT);

		btnBass0120New = new Button("신규");
		btnBass0120New.setIcon(MSFMainApp.ICONS.new16());
		topBass0120Bar.add(btnBass0120New);
		btnBass0120New.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				// 신규 버튼 클릭시 처리
				formBass0120Init();
				actionDatabase = ActionDatabase.INSERT;
			}
		});


		btnBass0120Save = new Button("저장");
		btnBass0120Save.setIcon(MSFMainApp.ICONS.save16());
//		btnBass0120Save.addSelectionListener(selectionListener);
		btnBass0120Save.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				if(ActionDatabase.INSERT.equals(actionDatabase)) {
					
					doAction(actionDatabase);
				}else {
					actionDatabase = ActionDatabase.UPDATE;
					doAction(actionDatabase);
				}
			}
		});
		topBass0120Bar.add(btnBass0120Save);

		btnBass0120Del = new Button("삭제");
		btnBass0120Del.setIcon(MSFMainApp.ICONS.delete16());
		btnBass0120Del.addSelectionListener(selectionListener);
		topBass0120Bar.add(btnBass0120Del);

		btnBass0120Sreach = new Button("조회");
		btnBass0120Sreach.setIcon(MSFMainApp.ICONS.search16());
		topBass0120Bar.add(btnBass0120Sreach);
		btnBass0120Sreach.addListener(Events.Select,
				new Listener<ButtonEvent>() {
					public void handleEvent(ButtonEvent e) {
						// 조회버튼 클릭시 처리
						mReload();
						sReload();
					}
				});

		plFrmBass0120.add(topBass0120Bar);

		// 파일업로드 처리 - 사업장 직인 정보
		plFrmBass0120.setAction("myurl"); // url 정보 추가 할것.
		plFrmBass0120.setEncoding(Encoding.MULTIPART);
		plFrmBass0120.setMethod(Method.POST);

		vp.add(plFrmBass0120);
		plFrmBass0120.setSize("990px", "680px");
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
		fieldSet.setHeadingHtml("검색조건");//.setHeading("검색조건");
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

		srhDpobNm = new TextField<String>();
		srhDpobNm.setName("srhDpobNm");
		srhDpobNm.setFieldLabel("사업장명"); 
		lcSchLeft.add(srhDpobNm, new FormData("90%"));

		srhDegtrNm = new TextField<String>();
		srhDegtrNm.setName("srhDegtrNm");
		srhDegtrNm.setFieldLabel("대표자명");
		lcSchRight.add(srhDegtrNm, new FormData("90%"));

		lcSchCol.add(lcSchLeft, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		lcSchCol.add(lcSchRight, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		fieldSet.add(lcSchCol, new FormData("90%"));

		plFrmBass0120.add(fieldSet);
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
	/**
	 * 전체 Layout CREATE
	 */
	private void createStandardForm() {
		
		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer01 = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(0); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer01.setLayout(frmlytStd);
		
		LayoutContainer gridLayoutContainer01 = new LayoutContainer();
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(0); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		gridLayoutContainer01.setLayout(frmlytStd);
		
		FieldSet fldstNewFieldset1 = new FieldSet();
		fldstNewFieldset1.setHeadingHtml("주 사업장");
		fldstNewFieldset1.setSize("470px", "277px");
		fldstNewFieldset1.add(createMasterGrid(), new FormData("100%"));
		layoutContainer01.add(fldstNewFieldset1);
		
		FieldSet fldstNewFieldset2 = new FieldSet();
		fldstNewFieldset2.setHeadingHtml("종 사업장");
		fldstNewFieldset2.setSize("470px", "277px");
		fldstNewFieldset2.add(createServantGrid(), new FormData("100%"));
		layoutContainer01.add(fldstNewFieldset2);
		layoutContainer01.setTabIndex(1);
		layoutContainer01.setVScrollPosition(1);
		layoutContainer.add(layoutContainer01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		LayoutContainer layoutContainer02 = new LayoutContainer();
		layoutContainer02.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(0); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer02.setLayout(frmlytStd);
		
		FieldSet fldstNewFieldset3 = new FieldSet();
		fldstNewFieldset3.setHeadingHtml("상세정보");
		fldstNewFieldset3.setSize("480px", "560px");
		fldstNewFieldset3.add(createInfoForm(), new FormData("100%"));
		layoutContainer02.add(fldstNewFieldset3);
		
		layoutContainer.add(layoutContainer02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		plFrmBass0120.add(layoutContainer);
		
	}
	
	/**
	 * 입력부분 CREATE
	 */
	private LayoutContainer createInfoForm() {
		FieldSet fieldSetStdForm = new FieldSet();
		fieldSetStdForm.setHeadingHtml("상세정보");//.setHeading("상세정보");

		LayoutContainer lcTop = new LayoutContainer();
		
		LayoutContainer lcRow01 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lcRow01Col01 = new LayoutContainer();
		
		FormLayout frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow01Col01.setLayout(frmlytStd);
		
		mtstBusinDivCd = new MSFComboBox<BaseModel>();
		mtstBusinDivCd.setFieldLabel("주종사업장구분");
		mtstBusinDivCd.setForceSelection(true);
		mtstBusinDivCd.setMinChars(1);
		mtstBusinDivCd.setDisplayField("commCdNm");
		mtstBusinDivCd.setValueField("commCd");
		// retryCllnDebrDivCd.setTriggerAction(TriggerAction.ALL);
		mtstBusinDivCd.setEmptyText("--주종선택--");
		mtstBusinDivCd.setSelectOnFocus(true);
		mtstBusinDivCd.setStore(lsMtstBusinDivCd);
		lcRow01Col01.add(mtstBusinDivCd, new FormData("100%"));
		
		lcRow01.add(lcRow01Col01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		LayoutContainer lcRow01Col02 = new LayoutContainer();
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow01Col02.setLayout(frmlytStd);
		
		utDpobNm = new MSFTextField();
		utDpobNm.setFieldLabel("사업장명");
		utDpobNm.setMaxLength(300);
		lcRow01Col02.add(utDpobNm, new FormData("100%"));
		
		lcRow01.add(lcRow01Col02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		LayoutContainer lcRow02 = new LayoutContainer(new ColumnLayout());
		LayoutContainer lcRow02Col01 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lcRow02Col01Fld = new LayoutContainer();
		
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow02Col01Fld.setLayout(frmlytStd);
		
		dpobCd = new MSFTextField();
		dpobCd.setMaxLength(14);
		dpobCd.setFieldLabel("사업장 코드");
		dpobCd.setReadOnly(true);
		lcRow02Col01Fld.add(dpobCd, new FormData("100%"));   
		
		lcRow02Col01.add(lcRow02Col01Fld, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.75));
		
		LayoutContainer lcRow02Col01Btn = new LayoutContainer();
		
		Button button = new Button("부서검색");
		button.addListener(Events.Select, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent e) {
            	fnPopupDeptCd();
            }
        });
		lcRow02Col01Btn.add(button, new FormData("100%"));
		lcRow02Col01.add(lcRow02Col01Btn, new ColumnData(.25));
		lcRow02.add(lcRow02Col01, new ColumnData(.5));
		
		LayoutContainer lcRow02Col02 = new LayoutContainer();
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow02Col02.setLayout(frmlytStd);
		
		hhrkUntDpobCd = new MSFComboBox<BaseModel>();
		hhrkUntDpobCd.setFieldLabel("상위사업장");
		hhrkUntDpobCd.setForceSelection(true);
		hhrkUntDpobCd.setMinChars(1);
		hhrkUntDpobCd.setDisplayField("commCdNm");
		hhrkUntDpobCd.setValueField("commCd");
		hhrkUntDpobCd.setTriggerAction(TriggerAction.ALL);
		hhrkUntDpobCd.setEmptyText("--상위사업장선택--");
		hhrkUntDpobCd.setSelectOnFocus(true);
		hhrkUntDpobCd.setStore(listStoreParentDpobCd);

		lcRow02Col02.add(hhrkUntDpobCd, new FormData("100%"));
		lcRow02.add(lcRow02Col02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		LayoutContainer lcRow03 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lcRow03Col01 = new LayoutContainer();
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow03Col01.setLayout(frmlytStd);
		
		busoprRgstnNum = new MSFTextField();
		busoprRgstnNum.setFieldLabel("사업자번호");
		new TextFieldMask<String>(busoprRgstnNum, "999-99-99999");
		lcRow03Col01.add(busoprRgstnNum, new FormData("100%"));
		
		lcRow03.add(lcRow03Col01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		LayoutContainer lcRow03Col02 = new LayoutContainer();
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow03Col02.setLayout(frmlytStd);
		
		corpRgstnNum = new MSFTextField();
		corpRgstnNum.setFieldLabel("법인번호");
		lcRow03Col02.add(corpRgstnNum, new FormData("100%"));
		
		lcRow03.add(lcRow03Col02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		LayoutContainer lcRow04 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lcRow04Col01 = new LayoutContainer();
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow04Col01.setLayout(frmlytStd);
		
		degtrNm = new MSFTextField();
		degtrNm.setFieldLabel("대표자 성명");
		lcRow04Col01.add(degtrNm, new FormData("100%"));
		
		lcRow04.add(lcRow04Col01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		LayoutContainer lcRow04Col02 = new LayoutContainer();
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow04Col02.setLayout(frmlytStd);
		
		degtrResnRegnNum = new MSFTextField();
		degtrResnRegnNum.setFieldLabel("대표자주민번호");
		new TextFieldMask<String>(degtrResnRegnNum, "999999-9999999");
		lcRow04Col02.add(degtrResnRegnNum, new FormData("100%"));
		
		lcRow04.add(lcRow04Col02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		LayoutContainer lcRow05 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lcRow05Col01 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lcRow05Col01Fld = new LayoutContainer();
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow05Col01Fld.setLayout(frmlytStd);
		
		untDpobZpcd = new MSFTextField();
		untDpobZpcd.setFieldLabel("사업장 주소");
		lcRow05Col01Fld.add(untDpobZpcd, new FormData("100%"));
		
		lcRow05Col01.add(lcRow05Col01Fld, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.82));
		
		LayoutContainer lcRow05Col01Btn = new LayoutContainer();
		
		Button btn = new Button("검색");
		btn.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				
				/**
				 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				 * 우편번호 팝업   -- 팝업호출을 위해 추가한 부분으로 임시로 공통팝업을 호출하는예시 넣음. 우편번호 완성후 변경처리  시작
				 * 추후 메서드 형태로 지원하도록 수정 
				 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				 */       
		 
					// 우편번호 호출에 따른 변경 처리 루틴 추가
					String postSystemkey = MSFMainApp.getMsg("PayGen.PostSystemkey");
					HashMap<String, String> params = new HashMap<String, String>();

					if (!"NONE".equals(postSystemkey)) {
						// 우편모아 호출
						// params.put("confmKey", postSystemkey); //승인키-사용안함.
						PrintUtils.setPostCall(true);
						PrintUtils.postPopUp(postSystemkey, params);
					} else {
						// 일반자체호출 인경우 처리
						fnPopupCmmn0320();
					}

				/**
				 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				* 우편번호 팝업 -- 팝업호출을 위해 추가한 부분으로 임시로 공통팝업을 호출하는예시 넣음. 우편번호 완성후 변경처리  끝
				* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				*/ 
			}
		});
		lcRow05Col01Btn.add(btn, new FormData("100%"));
		lcRow05Col01.add(lcRow05Col01Btn, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18));
		
		lcRow05.add(lcRow05Col01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		LayoutContainer lcRow05Col02 = new LayoutContainer();
		
		lcRow05.add(lcRow05Col02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		LayoutContainer lcRow06 = new LayoutContainer();
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow06.setLayout(frmlytStd);
		
		untDpobFndtnAddr = new MSFTextField();
		untDpobFndtnAddr.setFieldLabel("도로명 기본");
		untDpobFndtnAddr.setMaxLength(300);
		lcRow06.add(untDpobFndtnAddr, new FormData("100%"));
		
		LayoutContainer lcRow07 = new LayoutContainer();
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow07.setLayout(frmlytStd);
		
		untDpobDtlPatrAddr = new MSFTextField();
		untDpobDtlPatrAddr.setFieldLabel("도로명 상세");
		// dpobDtlPatrAddr.setWidth(210);
//		dpobDtlPatrAddr.setWidth("90%");
		untDpobDtlPatrAddr.setMaxLength(300);
		lcRow07.add(untDpobDtlPatrAddr, new FormData("100%"));
		
		LayoutContainer lcRow08 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lcRow08Col01 = new LayoutContainer();
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow08Col01.setLayout(frmlytStd);
		
		untDpobPhnNum = new MSFTextField();
		untDpobPhnNum.setFieldLabel("사업장전화번호");
		lcRow08Col01.add(untDpobPhnNum, new FormData("100%"));
		lcRow08.add(lcRow08Col01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		LayoutContainer lcRow08Col02 = new LayoutContainer();
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow08Col02.setLayout(frmlytStd);
		
		untDpobFaxNum = new MSFTextField();
		untDpobFaxNum.setFieldLabel("사업장팩스번호");
		untDpobFaxNum.setMaxLength(20);
		lcRow08Col02.add(untDpobFaxNum, new FormData("100%"));
		lcRow08.add(lcRow08Col02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));	
		
		LayoutContainer lcRow09 = new LayoutContainer(new ColumnLayout());
		LayoutContainer lcRow09Col01 = new LayoutContainer(new ColumnLayout());
		LayoutContainer lcRow09Col02 = new LayoutContainer(new ColumnLayout());
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow09Col01.setLayout(frmlytStd);
		
		chkgrpBass0120 = new CheckBoxGroup();
		chkgrpBass0120.setLabelSeparator("");
	     
		untDpobFndtnUseYn = new CheckBox();
		untDpobFndtnUseYn.setName("dpobFndtnUseYn");
		chkgrpBass0120.add(untDpobFndtnUseYn);
		untDpobFndtnUseYn.setBoxLabel("사용여부");
		untDpobFndtnUseYn.setHideLabel(true);
		untDpobFndtnUseYn.setValue(false);
		lcRow09Col01.add(chkgrpBass0120, new FormData("100%"));
		
		lcRow09.add(lcRow09Col01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow09Col02.setLayout(frmlytStd);
		
		chkgrpBass0120 = new CheckBoxGroup();
		chkgrpBass0120.setLabelSeparator("");
		
		upDpobUtynC171 = new CheckBox();
		upDpobUtynC171.setName("upDpobUtynC171");
		chkgrpBass0120.add(upDpobUtynC171);
		upDpobUtynC171.setBoxLabel("과세자여부");
		upDpobUtynC171.setHideLabel(true);
		upDpobUtynC171.setValue(false);
		lcRow09Col02.add(chkgrpBass0120, new FormData("100%"));
		
		lcRow09.add(lcRow09Col02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		//추가 10라인
		LayoutContainer lcRow10 = new LayoutContainer(new ColumnLayout());
		LayoutContainer lcRow10Col01 = new LayoutContainer(new ColumnLayout());
		LayoutContainer lcRow10Col02 = new LayoutContainer(new ColumnLayout());
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow10Col01.setLayout(frmlytStd);
		
		untDpobEctnMailAddr = new MSFTextField();
		untDpobEctnMailAddr.setFieldLabel("전자우편주소");
		untDpobEctnMailAddr.setMaxLength(20);
		
		lcRow10Col01.add(untDpobEctnMailAddr, new FormData("100%"));
		lcRow10.add(lcRow10Col01, new ColumnData(.5));	

		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow10Col02.setLayout(frmlytStd);

		untDpobBncdsNm = new MSFTextField();
		untDpobBncdsNm.setFieldLabel("업태");
		untDpobBncdsNm.setMaxLength(20);
		
		lcRow10Col02.add(untDpobBncdsNm, new FormData("100%"));
		lcRow10.add(lcRow10Col02, new ColumnData(.5));	
		
		// 11라인
		LayoutContainer lcRow11 = new LayoutContainer(new ColumnLayout());
		LayoutContainer lcRow11Col01 = new LayoutContainer(new ColumnLayout());
		LayoutContainer lcRow11Col02 = new LayoutContainer(new ColumnLayout());
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow11Col01.setLayout(frmlytStd);
		
		untDpobItemNm = new MSFTextField();
		untDpobItemNm.setFieldLabel("종목명");
		untDpobItemNm.setMaxLength(20);
		
		lcRow11Col01.add(untDpobItemNm, new FormData("100%"));
		lcRow11.add(lcRow11Col01, new ColumnData(.5));	

		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow11Col02.setLayout(frmlytStd);
		
		untDpobMnPrdt = new MSFTextField();
		untDpobMnPrdt.setFieldLabel("주생산품");
		untDpobMnPrdt.setMaxLength(20);
		
		lcRow11Col02.add(untDpobMnPrdt, new FormData("100%"));
		lcRow11.add(lcRow11Col02, new ColumnData(.5));	
		
		// 12라인
		LayoutContainer lcRow12 = new LayoutContainer(new ColumnLayout());
		LayoutContainer lcRow12Col01 = new LayoutContainer(new ColumnLayout());
		LayoutContainer lcRow12Col02 = new LayoutContainer(new ColumnLayout());
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow12Col01.setLayout(frmlytStd);
		
		upDpobCmpNo = new MSFTextField();
		upDpobCmpNo.setFieldLabel("승인번호");
		upDpobCmpNo.setMaxLength(20);
		
		lcRow12Col01.add(upDpobCmpNo, new FormData("100%"));
		lcRow12.add(lcRow12Col01, new ColumnData(.5));	

		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow12Col02.setLayout(frmlytStd);
		
		mtstDpobSeilNumC172 = new MSFTextField();
		mtstDpobSeilNumC172.setFieldLabel("일련번호");
		mtstDpobSeilNumC172.setMaxLength(20);
		
		lcRow12Col02.add(mtstDpobSeilNumC172, new FormData("100%"));
		lcRow12.add(lcRow12Col02, new ColumnData(.5));	
		
		// 13라인
		LayoutContainer lcRow13 = new LayoutContainer(new ColumnLayout());
		LayoutContainer lcRow13Col01 = new LayoutContainer(new ColumnLayout());
		LayoutContainer lcRow13Col02 = new LayoutContainer(new ColumnLayout());
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow13Col01.setLayout(frmlytStd);
		
		mnbhDivCd = new MSFTextField();
		mnbhDivCd.setFieldLabel("본지점구분코드");
		mnbhDivCd.setMaxLength(20);
		
		lcRow13Col01.add(mnbhDivCd, new FormData("100%"));
		lcRow13.add(lcRow13Col01, new ColumnData(.5));	
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow13Col02.setLayout(frmlytStd);
		
		whdgTxCtypDivCd = new MSFTextField();
		whdgTxCtypDivCd.setFieldLabel("원천세징수유형구분코드");
		whdgTxCtypDivCd.setMaxLength(20);
		
		lcRow13Col02.add(whdgTxCtypDivCd, new FormData("100%"));
		lcRow13.add(lcRow13Col02, new ColumnData(.5));	
		
		
		/**********************************************************/
		/********************** 추가정보 입력 **************************/
		
		FieldSet fieldEtcSst = new FieldSet();
		fieldEtcSst.setHeadingHtml("추가정보");
		
		LayoutContainer fldLc01 = new LayoutContainer();
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		fldLc01.setLayout(frmlytStd);
		
		untDpobSealWrdNm = new MSFTextField();
		untDpobSealWrdNm.setFieldLabel("직인문구명");
		fldLc01.add(untDpobSealWrdNm, new FormData("100%"));
		fieldEtcSst.add(fldLc01, new FormData("100%"));
		
		LayoutContainer fldLc02 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lbLc = new LayoutContainer();
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lbLc.setLayout(frmlytStd);
		
		TextField<String> lbFld = new TextField<String>();
		lbFld.setFieldLabel("직인이미지");
		lbLc.add(lbFld, new FormData("0%"));
		fldLc02.add(lbLc, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));
		
		LayoutContainer imgLc = new LayoutContainer();
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		imgLc.setLayout(frmlytStd);
		
		imgLc.setStyleAttribute("paddingLeft", "5px");
		
		untDpobSealRfta = new Image();
		untDpobSealRfta.setUrl(GWT.getHostPageBaseURL() + MSFMainApp.getMsg("PayGen.NonExTermPhoto"));
		untDpobSealRfta.setSize("120px", "130px");
		untDpobSealRfta.setVisible(true);
		untDpobSealRfta.setTitle("직인이미지");
		
		imgLc.add(untDpobSealRfta);
		fldLc02.add(imgLc);
		
		fieldEtcSst.add(fldLc02, new FormData("100%"));
		
		LayoutContainer fldLc03 = new LayoutContainer();
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		fldLc03.setLayout(frmlytStd);
		
		untDpobSealFlNm = new FileUploadField();
		untDpobSealFlNm.setLabelSeparator("");
		fldLc03.add(untDpobSealFlNm, new FormData("100%"));
		fieldEtcSst.add(fldLc03, new FormData("100%"));
		
		LayoutContainer lcRow14 = new LayoutContainer();
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(0); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow14.setLayout(frmlytStd);
		
		lcTop.add(lcRow01, new FormData("100%"));
		lcTop.add(lcRow02, new FormData("100%"));
		lcTop.add(lcRow03, new FormData("100%"));
		lcTop.add(lcRow04, new FormData("100%"));
		lcTop.add(lcRow05, new FormData("100%"));
		lcTop.add(lcRow06, new FormData("100%"));
		lcTop.add(lcRow07, new FormData("100%"));
		lcTop.add(lcRow08, new FormData("100%"));
		lcTop.add(lcRow09, new FormData("100%"));
		lcTop.add(lcRow10, new FormData("100%"));
		lcTop.add(lcRow11, new FormData("100%"));
		lcTop.add(lcRow12, new FormData("100%"));
		lcTop.add(lcRow13, new FormData("100%"));
		lcTop.add(fieldEtcSst, new FormData("100%"));

		return lcTop;
	}
	

	private void createStandardBForm() {

		FieldSet fieldSetStdForm = new FieldSet();
		fieldSetStdForm.setHeadingHtml("상세정보");//.setHeading("상세정보");

		LayoutContainer lcTop = new LayoutContainer(new ColumnLayout());

		LayoutContainer lcTop1 = new LayoutContainer();
		LayoutContainer lcTop2 = new LayoutContainer();
		LayoutContainer lcTop3 = new LayoutContainer();
		LayoutContainer lcTop4 = new LayoutContainer();

		LayoutContainer lc1 = new LayoutContainer();
		FormLayout fl1 = new FormLayout();
		fl1.setLabelWidth(100);
		fl1.setLabelAlign(LabelAlign.RIGHT);
		lc1.setLayout(fl1);

		hhrkUntDpobCd = new MSFComboBox<BaseModel>();
		hhrkUntDpobCd.setFieldLabel("상위사업장");
		hhrkUntDpobCd.setForceSelection(true);
		hhrkUntDpobCd.setMinChars(1);
		hhrkUntDpobCd.setDisplayField("commCdNm");
		hhrkUntDpobCd.setValueField("commCd");
		hhrkUntDpobCd.setTriggerAction(TriggerAction.ALL);
		hhrkUntDpobCd.setEmptyText("--상위사업장선택--");
		hhrkUntDpobCd.setSelectOnFocus(true);
		hhrkUntDpobCd.setStore(listStoreParentDpobCd);

		lc1.add(hhrkUntDpobCd, new FormData("90%"));
		lcTop1.add(lc1);

		LayoutContainer lc2 = new LayoutContainer();
		FormLayout fl2 = new FormLayout();
		fl2.setLabelWidth(100);
		fl2.setLabelAlign(LabelAlign.RIGHT);
		lc2.setLayout(fl2);

		degtrNm = new MSFTextField();
		degtrNm.setFieldLabel("대표자 성명");

		lc2.add(degtrNm, new FormData("90%"));
		lcTop1.add(lc2);

		LayoutContainer lc3 = new LayoutContainer();
		FormLayout fl3 = new FormLayout();
		fl3.setLabelWidth(100);
		fl3.setLabelAlign(LabelAlign.RIGHT);
		lc3.setLayout(fl3);

		untDpobZpcd = new MSFTextField();
		untDpobZpcd.setFieldLabel("사업장 주소");
		lc3.add(untDpobZpcd, new FormData("90%"));

		LayoutContainer lc4 = new LayoutContainer(new ColumnLayout());

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

		untDpobPhnNum = new MSFTextField();
		untDpobPhnNum.setFieldLabel("사업장전화번호");
		lc6.add(untDpobPhnNum, new FormData("90%"));
		lcTop1.add(lc6);

		LayoutContainer lc6_1 = new LayoutContainer();
		FormLayout fl6_1 = new FormLayout();
		fl6_1.setLabelWidth(100);
		fl6_1.setLabelAlign(LabelAlign.RIGHT);
		lc6_1.setLayout(fl6_1);

		untDpobSealWrdNm = new MSFTextField();
		untDpobSealWrdNm.setFieldLabel("직인문구명");
		lc6_1.add(untDpobSealWrdNm, new FormData("90%"));
		lcTop1.add(lc6_1);
		
		LayoutContainer lc35 = new LayoutContainer();
		FormLayout fl35 = new FormLayout();
		fl35.setLabelWidth(95);
		fl35.setLabelAlign(LabelAlign.RIGHT);
		lc35.setLayout(fl35);
		
		chkgrpBass0120 = new CheckBoxGroup();
		chkgrpBass0120.setLabelSeparator("");
	     
		untDpobFndtnUseYn = new CheckBox();
		untDpobFndtnUseYn.setName("dpobFndtnUseYn");
		chkgrpBass0120.add(untDpobFndtnUseYn);
		untDpobFndtnUseYn.setBoxLabel("사용여부");
		untDpobFndtnUseYn.setHideLabel(true);
		untDpobFndtnUseYn.setValue(false);
		lc35.add(chkgrpBass0120, new FormData("90%"));
		lcTop1.add(lc35);
	    

		LayoutContainer lc7 = new LayoutContainer();
		FormLayout fl7 = new FormLayout();
		fl7.setLabelWidth(95);
		fl7.setLabelAlign(LabelAlign.RIGHT);
		lc7.setLayout(fl7);

		dpobCd = new MSFTextField();
		dpobCd.setMaxLength(14);
		dpobCd.setFieldLabel("사업장 코드");
		dpobCd.setReadOnly(true);
		lc7.add(dpobCd, new FormData("90%"));   
		lcTop2.add(lc7);
		

		LayoutContainer lc8 = new LayoutContainer();
		FormLayout fl8 = new FormLayout();
		fl8.setLabelWidth(95);
		fl8.setLabelAlign(LabelAlign.RIGHT);
		lc8.setLayout(fl8);
 
		degtrResnRegnNum = new MSFTextField();
		degtrResnRegnNum.setFieldLabel("대표자주민번호");
		new TextFieldMask<String>(degtrResnRegnNum, "999999-9999999");

		lc8.add(degtrResnRegnNum, new FormData("90%"));
		lcTop2.add(lc8);

		LayoutContainer lc9 = new LayoutContainer();
		untDpobFndtnAddr = new MSFTextField();
		untDpobFndtnAddr.setWidth("90%");
		untDpobFndtnAddr.setMaxLength(300);
		lc9.add(untDpobFndtnAddr, new FormData("100%"));
		lcTop2.add(lc9, new FormData("90%"));

		LayoutContainer lc10 = new LayoutContainer();
		FormLayout fl10 = new FormLayout();
		fl10.setLabelWidth(95);
		fl10.setLabelAlign(LabelAlign.RIGHT);
		lc10.setLayout(fl10);
		untDpobFaxNum = new MSFTextField();
		untDpobFaxNum.setFieldLabel("사업장팩스번호");
		untDpobFaxNum.setMaxLength(20);
		lc10.add(untDpobFaxNum, new FormData("90%"));
		lcTop2.add(lc10);

		LayoutContainer lc11 = new LayoutContainer();
		FormLayout fl11 = new FormLayout();
		fl11.setLabelWidth(80);
		fl11.setLabelAlign(LabelAlign.RIGHT);
		lc11.setLayout(fl11);

		utDpobNm = new MSFTextField();
		utDpobNm.setFieldLabel("사업장명");
		utDpobNm.setMaxLength(300);
		lc11.add(utDpobNm, new FormData("90%"));
		lcTop3.add(lc11);

		LayoutContainer lc12 = new LayoutContainer();
		FormLayout fl12 = new FormLayout();
		fl12.setLabelWidth(80);
		fl12.setLabelAlign(LabelAlign.RIGHT);
		lc12.setLayout(fl12);

		busoprRgstnNum = new MSFTextField();
		busoprRgstnNum.setFieldLabel("사업자번호");
		new TextFieldMask<String>(busoprRgstnNum, "999-99-99999");
		lc12.add(busoprRgstnNum, new FormData("90%"));
		lcTop3.add(lc12);

		LayoutContainer lc13 = new LayoutContainer();
		untDpobDtlPatrAddr = new MSFTextField();
		untDpobDtlPatrAddr.setWidth("90%");
		untDpobDtlPatrAddr.setMaxLength(300);
		lc13.add(untDpobDtlPatrAddr, new FormData("100%"));
		lcTop3.add(lc13, new FormData("90%"));

		LayoutContainer lc14 = new LayoutContainer();
		FormLayout fl14 = new FormLayout();
		fl14.setLabelWidth(80);
		fl14.setLabelAlign(LabelAlign.RIGHT);
		lc14.setLayout(fl14);

		corpRgstnNum = new MSFTextField();
		corpRgstnNum.setFieldLabel("법인번호");
		lc14.add(corpRgstnNum, new FormData("90%"));
		lcTop3.add(lc14);

		LayoutContainer lc17 = new LayoutContainer();
		FormLayout fl17 = new FormLayout();
		fl17.setLabelWidth(80);
		fl17.setLabelAlign(LabelAlign.RIGHT);
		lc17.setLayout(fl17);

		LayoutContainer lc15 = new LayoutContainer();
		lc15.setStyleAttribute("paddingLeft", "15px");
		lc15.setStyleAttribute("paddingBottom", "4px");
		untDpobSealRfta = new Image();
		untDpobSealRfta.setUrl(GWT.getHostPageBaseURL()
				+ MSFMainApp.getMsg("PayGen.NonExTermPhoto"));
		untDpobSealRfta.setSize("120px", "130px");
		untDpobSealRfta.setVisible(true);
		untDpobSealRfta.setTitle("사진");
		lc15.add(untDpobSealRfta);
		lcTop4.add(lc15);

		LayoutContainer lc16 = new LayoutContainer();
		lc16.setStyleAttribute("paddingLeft", "15px");
		untDpobSealFlNm = new FileUploadField();
		untDpobSealFlNm.setWidth(120);
		lc16.add(untDpobSealFlNm, new FormData("90%"));
		lcTop4.add(lc16);

		lcTop.add(lcTop1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		lcTop.add(lcTop2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		lcTop.add(lcTop3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		lcTop.add(lcTop4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));

		fieldSetStdForm.add(lcTop);

		plFrmBass0120.add(fieldSetStdForm);

	}
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 기본등록화면 입력 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 그리드 처리 함수 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	
	private LayoutContainer createMasterGrid() {
		
		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		lcTabFormLayer.setStyleAttribute("paddingRight", "5px");
		//
		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(450, 255);

	      //msfCustomForm.setHeaderVisible(false);
	      //Instantiate the GridPanel
		msfGridPanel01 = new MSFGridPanel(mBass0120Def, false, false, false, false,false);
		msfGridPanel01.setHeaderVisible(false);
		msfGridPanel01.setBodyBorder(true);
		msfGridPanel01.setBorders(true);
		
        final Grid bass0120MGrid = msfGridPanel01.getMsfGrid().getGrid();
        bass0120MGrid.addListener(Events.RowDoubleClick, new Listener<BaseEvent>() {
           public void handleEvent(BaseEvent be) {  
        	   if (msfGridPanel01.getCurrentlySelectedItem() != null) { 
         		  
         		 formBass0120Init();
         		 
         		 //선택된 값을 우측 그리드에 넣기 위한 메서드 호출 
         		 leftBass0120Detail(msfGridPanel01.getCurrentlySelectedItem());
        	   }
         	  
        	   actionDatabase = ActionDatabase.UPDATE;
           }
        }); 	
	     
		cp01.add(msfGridPanel01);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;
	}
	
	private LayoutContainer createServantGrid() {
		
		LayoutContainer lcTabFormLayer = new LayoutContainer();
		lcTabFormLayer.setStyleAttribute("paddingLeft", "5px");
		lcTabFormLayer.setStyleAttribute("paddingRight", "5px");

		//
		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(450, 255);

	      //msfCustomForm.setHeaderVisible(false);
	      //Instantiate the GridPanel
		msfGridPanel02 = new MSFGridPanel(sBass0120Def, false, false, false, false, false);
		msfGridPanel02.setHeaderVisible(false);
		msfGridPanel02.setBodyBorder(true);
		msfGridPanel02.setBorders(true);
		
        final Grid bass0120MGrid = msfGridPanel02.getMsfGrid().getGrid();
        bass0120MGrid.addListener(Events.RowDoubleClick, new Listener<BaseEvent>() {
           public void handleEvent(BaseEvent be) {  
         	  if (msfGridPanel02.getCurrentlySelectedItem() != null) { 
         		  
//         		  formBass0120Init();
         		  
         		  //선택된 값을 우측 그리드에 넣기 위한 메서드 호출 
         		  leftBass0120Detail(msfGridPanel02.getCurrentlySelectedItem());
         	  }
         	  actionDatabase = ActionDatabase.UPDATE;
           }
        }); 	
	     
		cp01.add(msfGridPanel02);

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;
	}
	
	
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

		msfGridPanel = new MSFGridPanel(bass0120Def, false, false, false, true, true);
		msfGridPanel.setHeaderVisible(false);
		msfGridPanel.setBodyBorder(true);
		msfGridPanel.setBorders(true);
		
		cpGrid.add(msfGridPanel);
		lcStdGrid.add(cpGrid);
		FieldSetGrid.add(lcStdGrid);

		plFrmBass0120.add(FieldSetGrid);

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
	
	/**
	 *  부서 검색 팝업
	 */
	private void fnPopupDeptCd() {
       //검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
       //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
       //검색.처리하면됨.
       
       MSFFormPanel popCom0140 = PrgmComPopupUtils.lovPopUpPrgmCom0140Form();  //인사  
       
       final FormBinding popBindingCom0140 = popCom0140.getFormBinding();
       popBindingCom0140.addListener(Events.Change, new Listener<BaseEvent>() {
           public void handleEvent(BaseEvent be) {
               BaseModel mapModel = (BaseModel)be.getSource();
               if (!"".equals(mapModel.get("deptCd"))) { 
            	   //사업장 코드
            	   dpobCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
            	   //사업장명
//            	   utDpobNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt"))); 
               }  

           }
       });
   }
	
	private void fnPopupCmmn0320() {

		MSFFormPanel popCom0120 = SysComPopupUtils.lovPopUpMsfCom0120Form(); // 인사

		final FormBinding popBindingCom0120 = popCom0120.getFormBinding();

		popBindingCom0120.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				BaseModel mapModel = (BaseModel) be.getSource();
				if (!"".equals(mapModel.get("zpcd"))) {
					untDpobZpcd.setValue(MSFSharedUtils.allowNulls(mapModel.get("zpcd"))); 				// 우편번호
					untDpobFndtnAddr.setValue(MSFSharedUtils.allowNulls(mapModel.get("fnDtnAddr"))); 		// 앞주소
					untDpobDtlPatrAddr.setValue(MSFSharedUtils.allowNulls(mapModel.get("dtlPatrAddr"))); 	// 뒷주소
				}
			}
		});
	}
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/

	public void mReload() {
		
		IColumnFilter filters = null;
		
		msfGridPanel01.getTableDef().setTableColumnFilters(filters);
		msfGridPanel01.getTableDef().addColumnFilter("srhDpobNm",srhDpobNm.getValue(), SimpleColumnFilter.OPERATOR_LIKE);
		msfGridPanel01.getTableDef().addColumnFilter("srhDegtrNm",srhDegtrNm.getValue(), SimpleColumnFilter.OPERATOR_LIKE);
		msfGridPanel01.reload();
		
	}
	
	
	public void sReload() {
		
		IColumnFilter filters = null;
		
		msfGridPanel02.getTableDef().setTableColumnFilters(filters);
		msfGridPanel02.getTableDef().addColumnFilter("srhDpobNm",srhDpobNm.getValue(), SimpleColumnFilter.OPERATOR_LIKE);
		msfGridPanel02.getTableDef().addColumnFilter("srhDegtrNm",srhDegtrNm.getValue(), SimpleColumnFilter.OPERATOR_LIKE);
		msfGridPanel02.reload();
		
	}

	public void setRecord(BaseModel record) {
		this.record = record;
	}

	private Bass0120 getThis() {
		return this;
	}
	
    private void leftBass0120Detail(BaseModel selRecord) {
    	
		utDpobNm.focus();
		// dpobCd.setReadOnly(true);
		dpobCd.setReadOnly(true); 
		
//		Window.alert("적용시스템 코드 -> " + (String)selRecord.get("sysDivCd"));
		BasisUtil.setSelectedComboValue(mtstBusinDivCd 
								, (String)selRecord.get("mtstBusinDivCd"), "commCd");  	// 주종사업장구분
//								, (String)selRecord.get("mtstBusinDivCd$commCd"), "commCd");  	// 주종사업장구분
		BasisUtil.setSelectedComboValue(hhrkUntDpobCd
								, (String)selRecord.get("hhrkUntDpobCd"), "commCd");  					// 사업자 상위구분
//	readonly변경으로 인해	dpobCd.setValue((String)selRecord.get("dpobCd")); 										// 사업장코드
		
		dpobCd.setValue((String)selRecord.get("dpobCd")); 										// 사업장명
		utDpobNm.setValue((String)selRecord.get("utDpobNm")); 										// 사업장명
		busoprRgstnNum.setValue((String)selRecord.get("busoprRgstnNum")); 						// 사업자번호
		corpRgstnNum.setValue((String)selRecord.get("corpRgstnNum")); 							// 법인번호
		degtrNm.setValue((String)selRecord.get("degtrNm")); 												// 대표자성명
		degtrResnRegnNum.setValue((String)selRecord.get("degtrResnRegnNum")); 				// 주민번호
		untDpobZpcd.setValue((String)selRecord.get("untDpobZpcd"));									// 사업장주소
		untDpobFndtnAddr.setValue((String)selRecord.get("untDpobFndtnAddr"));				 	// 사업장 기본주소
		untDpobDtlPatrAddr.setValue((String)selRecord.get("untDpobDtlPatrAddr")); 				// 사업장 상세주소
		untDpobPhnNum.setValue((String)selRecord.get("untDpobPhnNum")); 						// 전화번호
		untDpobFaxNum.setValue((String)selRecord.get("untDpobFaxNum")); 						// 팩스번호
		untDpobSealWrdNm.setValue((String)selRecord.get("untDpobSealWrdNm")); 				// 직인문구명
		untDpobFndtnUseYn.setValue((Boolean) selRecord.get("untDpobFndtnUseYn"));			// 사용여부
		
		untDpobEctnMailAddr.setValue((String)selRecord.get("untDpobEctnMailAddr")); 		// 전자우편주소
		untDpobBncdsNm.setValue((String)selRecord.get("untDpobBncdsNm")); 				// 업태
		untDpobItemNm.setValue((String)selRecord.get("untDpobItemNm")); 					// 종목명
		untDpobMnPrdt.setValue((String)selRecord.get("untDpobMnPrdt")); 						// 주생산품
		upDpobCmpNo.setValue((String)selRecord.get("upDpobCmpNo")); 						// 승인번호
		upDpobUtynC171.setValue((Boolean)selRecord.get("upDpobUtynC171"));				// C171_사업자단위과세자여부
		mtstDpobSeilNumC172.setValue((String)selRecord.get("mtstDpobSeilNumC172"));	// C172_종사업장일련번호
		mnbhDivCd.setValue((String)selRecord.get("mnbhDivCd"));									// 본지점구분코드
		whdgTxCtypDivCd.setValue((String)selRecord.get("whdgTxCtypDivCd"));				// 원천세신고유형구분코드		
		
		if(MSFSharedUtils.paramNotNull( (String)selRecord.get("untDpobSealFlNm"))) {
			untDpobSealRfta.setUrl(GWT.getHostPageBaseURL()
								+ MSFMainApp.getMsg("PayGen.ExTermPhoto")+ "/"
								+ (String)selRecord.get("untDpobSealFlNm")
								+ "");
		}else {
			untDpobSealRfta.setUrl(GWT.getHostPageBaseURL()+ MSFMainApp.getMsg("PayGen.NonExTermPhoto"));
		}
		
    }
    
    /**
     * 저장
     */
    private void saveBass0120(Bass0120DTO dto, final ActionDatabase actionDatabase, final String fileName) {
		
    	bass0120Service.saveBass0120(dto, actionDatabase, new AsyncCallback<String>() {
			@Override
			public void onSuccess(String result) {
				if ("DELETE".equals(actionDatabase.name())) {
					MessageBox.info("","삭제 되었습니다.", null);
				}else{
					MessageBox.info("","저장 되었습니다.", null);
				}
				
				if (!"".equals(fileName) && fileName != null) {
					untDpobSealFlNm.setName("BASS0120" + "_" + dpobCd.getValue());
					imgKeyCode.setValue(dpobCd.getValue());
					frmKey.setValue("BASS0120");
					plFrmBass0120.mask();
					plFrmBass0120.setAction(GWT.getHostPageBaseURL() + "upload/ImageFileUpload.do"); 
					plFrmBass0120.submit();
					plFrmBass0120.onFrameLoad();
					picBoolFile = true;
					plFrmBass0120.addListener(Events.Submit, new Listener<FormEvent>() {
						public void handleEvent(FormEvent evt) {
							plFrmBass0120.unmask();
							if ("success".endsWith(evt.getResultHtml())&& picBoolFile) {
								// 업로드가 성공했으면 인서트 모듈을 태운다.
								// dtime.schedule(2000);
								picBoolFile = false;
								evt.setResultHtml("");
							} else {
								// TODO 처리  할것 실패 메시지나 에러 메시지 처리
								evt.setResultHtml("");
							}
						};
					});
				}
		
				//상세정보 초기화
				formBass0120Init();
				mReload();
				sReload();
			}

		@Override
		public void onFailure(Throwable caught) {
			caught.printStackTrace();
			MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),
			MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnBass0120("+ actionDatabase.name()+ ") : "+ caught),null);
			}
		});
    	
    }

	/**
	 * 초기화
	 */
	private void formBass0120Init() {
		hhrkUntDpobCd.setValue(new BaseModel()); 		// 상위사업장
		dpobCd.setValue(""); 										// 사업장코드
		utDpobNm.setValue(""); 									// 사업장명
		degtrNm.setValue(""); 										// 대표자성명
		degtrResnRegnNum.setValue(""); 						// 주민번호
		degtrSecRegnNum.setValue(""); 						// 주민번호
		busoprRgstnNum.setValue(""); 							// 사업자번호
		untDpobZpcd.setValue(""); 								// 사업장주소
		untDpobFndtnAddr.setValue(""); 						// 사업장 기본주소
		untDpobDtlPatrAddr.setValue(""); 						// 사업장 상세주소
		untDpobPhnNum.setValue(""); 							// 전화번호
		untDpobFaxNum.setValue(""); 							// 팩스번호
		corpRgstnNum.setValue(""); 							// 법인등록번호
		untDpobSealWrdNm.setValue("");			 			// 직인문구명
		mtstBusinDivCd.setValue(new BaseModel()); 		// 주종사업장구분
		untDpobSealRfta.setUrl(GWT.getHostPageBaseURL() + MSFMainApp.getMsg("PayGen.NonExTermPhoto"));
		untDpobSealFlNm.setValue("");
		untDpobFndtnUseYn.setValue(false);					// 사용여부

		untDpobEctnMailAddr.setValue("");					// 전자우편
		untDpobBncdsNm.setValue("");							// 업태
		untDpobItemNm.setValue("");							// 종목명
		untDpobMnPrdt.setValue("");							// 주생산품

		upDpobCmpNo.setValue("");								// 단위사업장승인번호
		upDpobUtynC171.setValue(false);						// C171_사업자단위과세자여부
		mtstDpobSeilNumC172.setValue("");					// C172_종사업장일련번호
		mnbhDivCd.setValue("");									// 본지점구분코드
		whdgTxCtypDivCd.setValue("");						// 원천세신고유형구분코드		
	}

	public native String getDetailTemplate() /*-{
		return [ '<div class="details">', '<tpl for=".">',
		'<img src="{modPath}"><div class="details-info">',
		'<b>Image Name:</b>', '<span>{name}</span>', '<b>Size:</b>',
		'<span>{sizeString}</span>', '<b>Last Modified:</b>',
		'<span>{dateString}</span></div>', '</tpl>', '</div>' ]
		.join("");
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
