package com.app.exterms.yearendtax.client.form.yeta2019;

import java.util.HashMap;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.service.PrgmComBass0300Service;
import com.app.exterms.prgm.client.service.PrgmComBass0300ServiceAsync;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.exterms.yearendtax.client.dto.yeta2019.Yeta4060DTO;
import com.app.exterms.yearendtax.client.form.defs.yeta2019.Yeta4060Def;
import com.app.exterms.yearendtax.client.service.yeta2019.Yeta4060Service;
import com.app.exterms.yearendtax.client.service.yeta2019.Yeta4060ServiceAsync;
import com.app.exterms.yearendtax.client.utils.YetaUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormWindows;
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
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.ColumnData;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Image;

/**
 * @Class Name : Yeta4060.java
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
public class Yeta4060 extends MSFPanel {

	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 전역변수 선언부 시작
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 **/

	// -------------- 상단 버튼 시작 --------------
	private ButtonBar topYeta4060Bar;
	private Button btnYeta4060Dpob; 
	private Button btnYeta4060New; 
	private Button btnYeta4060Save;
	private Button btnYeta4060Del;
	private Button btnYeta4060Sreach;
	// -------------- 상단 버튼 종료 --------------

	// -------------- 검색조건 시작 -------------- 
	private TextField<String> srhDpobNm;	// 사업장명
	private TextField<String> srhDegtrNm; 	// 대표자명
	// -------------- 검색조건 종료 -------------- 

	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 
	 * 입력변수 선언
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */

	// -------------- 상세정보 시작-------------- 
//	private MSFComboBox<BaseModel> hhrkUntDpobCd; 					// 상위 단위사업장 코드
	private MSFTextField utDpobCd; 									// 단위사업장코드
	private MSFTextField utDpobNm; 									// 단위사업장명
	private MSFTextField degtrNm; 									// 대표자성명
	private MSFTextField degtrResnRegnNum; 							// 주민번호
	private HiddenField<String> degtrSecRegnNum; 					// 주민번호원본 
	private static MSFTextField untDpobZpcd; 						// 사업장주소
	private static MSFTextField untDpobFndtnAddr; 					// 사업장 기본주소
	private static MSFTextField untDpobDtlPatrAddr;	 				// 사업장 상세주소
	private MSFTextField untDpobPhnNum; 							// 단위사업장전화번호
	private MSFTextField untDpobFaxNum; 							// 단위사업장팩스번호
	private MSFTextField untDpobEctnMailAddr;						// 단위사업장팩스번호

	private MSFTextField busoprRgstnNum; 							// 사업자번호
	private MSFTextField corpRgstnNum; 								// 법인번호
	private MSFComboBox<BaseModel> mtstBusinDivCd; 					// 주종사업장구분 

	private CheckBoxGroup chkgrpYeta4060;   						// 체크 그룹
	private CheckBox untDpobFndtnUseYn;								// 기본사용여부

	private MSFTextField upDpobCmpNo;								// 단위사업장승인번호
	
	private RadioGroup upDpobUtynC171Group;							// 인적공제항목변동여부
    private Radio upDpobUtynC171N;
    private Radio upDpobUtynC171Y;
	
	private MSFTextField mtstDpobSeilNumC172;						// C172_종사업장일련번호
	private MSFComboBox<BaseModel> mnbhDivCd;						// 본지점구분코드
	private MSFComboBox<BaseModel> whdgTxCtypDivCd;					// 원천세신고유형구분코드
	// 이미지 업로드를 위해 추가
	private HiddenField<String> frmKey;
	private HiddenField<String> whdgTxRegrstDeptCd;
	private HiddenField<String> imgKeyCode;
	
	private MSFTextField untDpobSealWrdNm; 							// 단위사업장직인문구명
	private Image untDpobSealRfta; 									// 단위사업장직인경로
	private FileUploadField untDpobSealFlnm;						// 단위사업장직인파일명
	private MSFTextField taxaCode; 							// 관할세무서코드

	private Boolean picBoolFile;
	private int iFlag = 0;
	// -------------- 상세정보 종료--------------

	// -------------- Store 시작 --------------
	private ListStore<BaseModel> listStoreParentDpobCd 	= new ListStore<BaseModel>(); 	// 상위사업장 코드
	private ListStore<BaseModel> lsMtstBusinDivCd		= new ListStore<BaseModel>(); 	// 주종사업장구분 코드
	private ListStore<BaseModel> lsMnbhDivCd			= new ListStore<BaseModel>(); 	// 본지접구분 코드
	private ListStore<BaseModel> lsWhdgTxCtypDivCd		= new ListStore<BaseModel>(); 	// 주종사업장구분 코드
	// -------------- Store 종료 --------------


	// -------------- 서비스 호출 시작 -------------- 
	//private InfcYeta4060ServiceAsync infcYeta4060Service = InfcYeta4060Service.Util.getInstance();
	private Yeta4060ServiceAsync yeta4060Service = Yeta4060Service.Util.getInstance();
	private PrgmComBass0300ServiceAsync sysComBass0300Service = PrgmComBass0300Service.Util.getInstance();
	// -------------- 서비스 호출 종료 -------------- 


	// -------------- grid 시작 -------------- 
	private Yeta4060Def Yeta4060Def = new Yeta4060Def(); // 그리드 테이블 컬럼 define
	private MSFGridPanel msfGridPanel;


	private Yeta4060Def mYeta4060Def = new Yeta4060Def("Yeta4060_01"); // 주 그리드 테이블 컬럼 define
	private MSFGridPanel msfGridPanel01;

	// -------------- grid 끝 --------------  

	// -------------- 상태처리 전역변수  -------------- 
	private ActionDatabase actionDatabase;
	// -------------- 상태처리 전역변수  -------------- 

	// -------------- DTO 선언 시작  -------------- 
	private PrgmComBass0300DTO sysComBass0300Dto;
	// private PrgmComYeta4060DTO sysComYeta4060Dto;
	// -------------- DTO 선언 종료  -------------- 

	private VerticalPanel vp;
	private FormPanel plFrmYeta4060;

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
				if (ce.getButton() == btnYeta4060Save) {
					doAction(ActionDatabase.INSERT);
				}
			} else if (ce.getButton() == btnYeta4060Save) {
				doAction(ActionDatabase.UPDATE);
				actionDatabase = null;
			} else if (ce.getButton() == btnYeta4060Del) {
				doAction(ActionDatabase.DELETE);
			}
		}
	};

	private void doAction(ActionDatabase actionDatabase) {
		save(actionDatabase);

	}

	//저장
	public void save(final ActionDatabase actionDatabase) {

		final Yeta4060DTO dto = new Yeta4060DTO();
		dto.setWhdgTxRegrstDeptCd(MSFSharedUtils.allowNulls(utDpobCd.getValue())); 						// ye161005
		
		dto.setUtDpobCd(MSFSharedUtils.allowNulls(utDpobCd.getValue())); 								// 단위사업장코드
		dto.setUtDpobNm(MSFSharedUtils.allowNulls(utDpobNm.getValue())); 								// 단위사업장명
		dto.setMtstBusinDivCd(MSFSharedUtils.allowNulls(YetaUtils.getSelectedComboValue(mtstBusinDivCd, "commCd")));	// 주종사업장구분
		dto.setBusoprRgstnNum(MSFSharedUtils.allowNulls(busoprRgstnNum.getValue())); 					// 사업자번호
		dto.setCorpRgstnNum(MSFSharedUtils.allowNulls(corpRgstnNum.getValue()).replaceAll("-", "")); 	// 법인번호
		
		dto.setDegtrNm(MSFSharedUtils.allowNulls(degtrNm.getValue())); 									// 대표자성명
		dto.setDegtrResnRegnNum(MSFSharedUtils.allowNulls(degtrResnRegnNum.getValue())); 				// 주민번호
		dto.setUntDpobZpcd(MSFSharedUtils.allowNulls(untDpobZpcd.getValue())); 							// 사업장주소
		dto.setUntDpobFndtnAddr(MSFSharedUtils.allowNulls(untDpobFndtnAddr.getValue())); 				// 사업장 기본주소
		dto.setUntDpobDtlPatrAddr(MSFSharedUtils.allowNulls(untDpobDtlPatrAddr.getValue())); 			// 사업장 상세주소
		
		dto.setUntDpobPhnNum(MSFSharedUtils.allowNulls(untDpobPhnNum.getValue())); 						// 전화번호
		dto.setUntDpobFaxNum(MSFSharedUtils.allowNulls(untDpobFaxNum.getValue()));	 					// 팩스번호		
		dto.setUntDpobEctnMailAddr(MSFSharedUtils.allowNulls(untDpobEctnMailAddr.getValue()));			// 전자우편주소
		dto.setUpDpobCmpNo(MSFSharedUtils.allowNulls(upDpobCmpNo.getValue()));    						/** column 단위사업장승인번호 : upDpobCmpNo */
		dto.setMtstDpobSeilNumC172(MSFSharedUtils.allowNulls(mtstDpobSeilNumC172.getValue()));    		/** column C172_종사업장일련번호 : mtstDpobSeilNumC172 */
		
		dto.setMnbhDivCd(MSFSharedUtils.allowNulls(YetaUtils.getSelectedComboValue(mnbhDivCd,"commCd")));    /** column 본지점구분코드 : mnbhDivCd */
		dto.setWhdgTxCtypDivCd(MSFSharedUtils.allowNulls(YetaUtils.getSelectedComboValue(whdgTxCtypDivCd,"commCd")));    /** column 원천세신고유형구분코드 : whdgTxCtypDivCd */
		dto.setUntDpobFndtnUseYn(untDpobFndtnUseYn.getValue() ? "Y" : "N");								// 사용여부
		dto.setUpDpobUtynC171(YetaUtils.getCheckedRadioValue(upDpobUtynC171Group));    					/** column C171_사업자단위과세자여부 : upDpobUtynC171 */
		
		dto.setCorpDivCd("");		
		dto.setSysDivCd("EXTERM00"); 																	// 적용시스템
		dto.setUntDpobSealRfta(MSFSharedUtils.allowNulls(MSFMainApp.getMsg("PayGen.ExTermPhoto"))); 	// 직인경로
		dto.setUntDpobSealWrdNm(MSFSharedUtils.allowNulls(untDpobSealWrdNm.getValue())); 				// 직인문구명
		
		
		// 삭제처리가 아닐 경우에만  필수값 체크 
		if(!"DELETE".equals(actionDatabase.name())) {
			
			if ("".equals(dto.getUtDpobCd()) || dto.getUtDpobCd() == null) {
				MessageBox.info("", "사업장코드는 필수 입니다.", null);
				utDpobCd.focus();
			}else if ("".equals(dto.getUtDpobNm()) || dto.getUtDpobNm() == null) {
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
			} else if ("".equals(dto.getUpDpobUtynC171())
					|| dto.getUpDpobUtynC171() == null) {
				MessageBox.info("", "사업자단위과세자여부는 필수 입니다.", null);
				upDpobUtynC171Group.focus();
			}	
				
		} 
				
		final String fileName = untDpobSealFlnm.getValue();
		
//		if(!"".equals(fileName) && fileName != null){
//			dto.setUntDpobSealFlnm(fileName.substring(fileName.lastIndexOf("\\")+1));
//		}
			if (!"".equals(fileName) && fileName != null) {
				 //사진 이미지 파일명
				dto.setUntDpobSealFlnm(utDpobCd.getValue() + fileName.substring(fileName.lastIndexOf("."))); // 직인 이미지 저장시 단위사업자 코드로.확장자로 처리
			}
		
		MessageBox.confirm("", "DELETE".equals(actionDatabase.name()) ? "삭제 하시겠습니까?": "저장 하시겠습니까?", new Listener<MessageBoxEvent>() {
			@Override
			public void handleEvent(MessageBoxEvent be) {

				if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
					if("DELETE".equals(actionDatabase.name())) {
					
						yeta4060Service.delChkYeta4060(dto, actionDatabase, new AsyncCallback<Integer>() {
							@Override
							public void onSuccess(Integer result) {
										
								if (result == 1) {
									MessageBox.info("경고","해당 단위사업장으로 설정되어 있는 근로자가 존재. 삭제 불가.", null);
								}else{
									// 저장 처리
									saveYeta4060(dto, actionDatabase, fileName);
								}
							}

							@Override
							public void onFailure(Throwable caught) {
								caught.printStackTrace();
								MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),
										MSFMainApp.ADMINMESSAGES.ExceptionMessageService("delChkYeta4060("+ actionDatabase.name()+ ") : "+ caught),null);
							}
						});
					}else {
						// 저장 처리
						saveYeta4060(dto, actionDatabase, fileName);
					}
				}
			}
		});
	}
	
	final Timer tmMask = new Timer() {
		public void run() {
			// if (maskTracker) {
				authExecEnabled();
				tmMask.scheduleRepeating(2000);
			// }
		}
	};

	private void authExecEnabled() { 
		//------------------
		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 * 권한설정을 위한 콤보처리를 위한 메서드 시작
		 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 직종세 ,사업 순으로 없으면 ""
				 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		//----------------------------------------------------
		mtstBusinDivCd.setValue(lsMtstBusinDivCd.getAt(0));
		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		 * 권한설정을 위한 콤보처리를 위한 메서드 종료
		 *	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
		//			 creDeptCd.getListView().fireEvent(Events.CheckChanged); 

	}

	/**************************************************************/
	/** 우편번호 로직 추가    												*/
	/**************************************************************/		  
	public static native void closeFunction() /*-{
			   $wnd.closeFunction =
			      $entry(@com.app.exterms.yearendtax.client.form.yeta2019.Yeta4060::onCloseGwtFunction(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;));
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
		
		if (panel == null) {
			GWTUtils.popupDoroWndClose(); 
			closeFunction();

			// 상위 사업장
			yeta4060Service.getParentDpobCd(new AsyncCallback<List<BaseModel>>() {
				@Override
				public void onSuccess(List<BaseModel> result) {
					listStoreParentDpobCd.add(result);
				}

				@Override
				public void onFailure(Throwable caught) {
					MessageBox.alert("", "상위사업장코드 에러!", null);
				}
			});
			
			tmMask.scheduleRepeating(2000);

			detailTp = XTemplate.create(getDetailTemplate());

			// formData = new FormData("-650");
			vp = new VerticalPanel();
			vp.setSpacing(10);
			createYeta4060Form(); 		// 화면 기본정보를 설정
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
			formBinding = new FormBinding(this.plFrmYeta4060, true);

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
	public Yeta4060() {
		setSize("1010px", "700px");
	}

	// 생성자 함수에 변수을 받아 처리
	public Yeta4060(String txtForm) {
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
	private void createYeta4060Form() {

		plFrmYeta4060 = new FormPanel();
		plFrmYeta4060.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 단위사업장등록관리"));
		plFrmYeta4060.setIcon(MSFMainApp.ICONS.text());
		plFrmYeta4060.setBodyStyleName("pad-text");

		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   

		btnlogView.setHeight("10px"); //.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				//로그 뷰화면 호출 메서드 
				funcLogMessage("단위사업장등록관리","Yeta4060");
			}
		});
		plFrmYeta4060.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmYeta4060.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/

		plFrmYeta4060.setPadding(2);
		plFrmYeta4060.setFrame(true);
		plFrmYeta4060.setLayout(new FormLayout());

		degtrSecRegnNum = new HiddenField<String>();
		imgKeyCode = new HiddenField<String>();
		imgKeyCode.setName("imgKeyCode");
		plFrmYeta4060.add(imgKeyCode);
		frmKey = new HiddenField<String>();
		frmKey.setName("frmKey");
		plFrmYeta4060.add(frmKey);
		whdgTxRegrstDeptCd = new HiddenField<String>();
		whdgTxRegrstDeptCd.setName("whdgTxRegrstDeptCd");
		plFrmYeta4060.add(whdgTxRegrstDeptCd);

		topYeta4060Bar = new ButtonBar();
		topYeta4060Bar.setAlignment(HorizontalAlignment.RIGHT);
		
		btnYeta4060Dpob = new Button("주(총괄납부)사업장관리");
		topYeta4060Bar.add(btnYeta4060Dpob);
		btnYeta4060Dpob.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				YetaP406001 yetaP406001Form = new YetaP406001(ActionDatabase.READ, getThis());

				MSFFormWindows msFwYeta406001 = new MSFFormWindows("주(총괄납부)사업장 관리",yetaP406001Form, "닫기", "820px", "710px", false);
				msFwYeta406001.show();
				yetaP406001Form.setMSFFormWindows(msFwYeta406001);
			}
		});

		btnYeta4060New = new Button("신규");
		btnYeta4060New.setIcon(MSFMainApp.ICONS.new16());
		topYeta4060Bar.add(btnYeta4060New);
		btnYeta4060New.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				// 신규 버튼 클릭시 처리
				formYeta4060Init();
				actionDatabase = ActionDatabase.INSERT;
			}
		});


		btnYeta4060Save = new Button("저장");
		btnYeta4060Save.setIcon(MSFMainApp.ICONS.save16());
		//		btnYeta4060Save.addSelectionListener(selectionListener);
		btnYeta4060Save.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {

				if(ActionDatabase.INSERT.equals(actionDatabase)) {

					doAction(actionDatabase);
				}else {
					actionDatabase = ActionDatabase.UPDATE;
					doAction(actionDatabase);
				}
			}
		});
		topYeta4060Bar.add(btnYeta4060Save);

		btnYeta4060Del = new Button("삭제");
		btnYeta4060Del.setIcon(MSFMainApp.ICONS.delete16());
		btnYeta4060Del.addSelectionListener(selectionListener);
		topYeta4060Bar.add(btnYeta4060Del);

		btnYeta4060Sreach = new Button("조회");
		btnYeta4060Sreach.setIcon(MSFMainApp.ICONS.search16());
		topYeta4060Bar.add(btnYeta4060Sreach);
		btnYeta4060Sreach.addListener(Events.Select,
				new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				// 조회버튼 클릭시 처리
				formYeta4060Init();
				mReload();
			}
		});

		plFrmYeta4060.add(topYeta4060Bar);

		// 파일업로드 처리 - 사업장 직인 정보
		plFrmYeta4060.setAction("myurl"); // url 정보 추가 할것.
		plFrmYeta4060.setEncoding(Encoding.MULTIPART);
		plFrmYeta4060.setMethod(Method.POST);

		vp.add(plFrmYeta4060);
		plFrmYeta4060.setSize("990px", "680px");
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

		plFrmYeta4060.add(fieldSet);
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
		fldstNewFieldset1.setHeadingHtml("사업장정보");
		fldstNewFieldset1.setSize("470px", "554px");
		fldstNewFieldset1.add(createMasterGrid(), new FormData("100%"));
		layoutContainer01.add(fldstNewFieldset1);

		//		FieldSet fldstNewFieldset2 = new FieldSet();
		//		fldstNewFieldset2.setHeadingHtml("종 사업장");
		//		fldstNewFieldset2.setSize("470px", "277px");
		//		fldstNewFieldset2.add(createServantGrid(), new FormData("100%"));
		//		layoutContainer01.add(fldstNewFieldset2);
		//		layoutContainer01.setTabIndex(1);
		//		layoutContainer01.setVScrollPosition(1);
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

		plFrmYeta4060.add(layoutContainer);

	}

	/**
	 * 입력부분 CREATE
	 */
	private LayoutContainer createInfoForm() {
		sysComBass0300Dto = new PrgmComBass0300DTO();

		// --------------------공통 코드 불러 오는 함수----------------------------------------------------
		sysComBass0300Dto = new PrgmComBass0300DTO();
		sysComBass0300Dto.setRpsttvCd("C003");
		lsMtstBusinDivCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
		// -------------------------------------------------------------------------------------------
		sysComBass0300Dto = new PrgmComBass0300DTO();
		sysComBass0300Dto.setRpsttvCd("C004");
		lsWhdgTxCtypDivCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
		
		sysComBass0300Dto = new PrgmComBass0300DTO();
		sysComBass0300Dto.setRpsttvCd("C005");
		lsMnbhDivCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
		
		FieldSet fieldSetStdForm = new FieldSet();
		fieldSetStdForm.setHeadingHtml("상세정보");//.setHeading("상세정보");

		LayoutContainer lcTop = new LayoutContainer();

		// 01라인
		LayoutContainer lcRow01 = new LayoutContainer(new ColumnLayout());

		LayoutContainer lcRow01Col01 = new LayoutContainer();

		FormLayout frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow01Col01.setLayout(new ColumnLayout());

		LayoutContainer lcRow01Col01Fld = new LayoutContainer();

		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow01Col01Fld.setLayout(frmlytStd);

		utDpobCd = new MSFTextField();
		utDpobCd.setMaxLength(14);
		utDpobCd.setFieldLabel("단위사업장 코드");
		utDpobCd.setReadOnly(true);
		lcRow01Col01Fld.add(utDpobCd, new FormData("100%"));   

		lcRow01Col01.add(lcRow01Col01Fld, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.75));

		LayoutContainer lcRow01Col01Btn = new LayoutContainer();

		Button button = new Button("부서검색");
		button.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				fnPopupDeptCd();
			}
		});
		lcRow01Col01Btn.add(button, new FormData("100%"));
		lcRow01Col01.add(lcRow01Col01Btn, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
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
		
		// 02라인
		LayoutContainer lcRow02 = new LayoutContainer(new ColumnLayout());

		LayoutContainer lcRow02Col01 = new LayoutContainer();
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow02Col01.setLayout(frmlytStd);

		mtstBusinDivCd = new MSFComboBox<BaseModel>();
		mtstBusinDivCd.setFieldLabel("주종사업장구분");
		mtstBusinDivCd.setForceSelection(true);
		mtstBusinDivCd.setMinChars(1);
		mtstBusinDivCd.setDisplayField("commCdNm");
		mtstBusinDivCd.setValueField("commCd");
		mtstBusinDivCd.setTriggerAction(TriggerAction.ALL);
		mtstBusinDivCd.setEmptyText("--주종선택--");
		mtstBusinDivCd.setReadOnly(true);
		mtstBusinDivCd.setSelectOnFocus(true);
		mtstBusinDivCd.setStore(lsMtstBusinDivCd);
		lcRow02Col01.add(mtstBusinDivCd, new FormData("100%"));
		lcRow02.add(lcRow02Col01, new ColumnData(.5));

		LayoutContainer lcRow02Col02 = new LayoutContainer();
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow02Col02.setLayout(frmlytStd);

		lcRow02.add(lcRow02Col02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		// 03라인
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
		new TextFieldMask<String>(corpRgstnNum, "999999-9999999");
		lcRow03Col02.add(corpRgstnNum, new FormData("100%"));

		lcRow03.add(lcRow03Col02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		// 04라인
		LayoutContainer lcRow04 = new LayoutContainer(new ColumnLayout());

		LayoutContainer lcRow04Col01 = new LayoutContainer();

		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow04Col01.setLayout(frmlytStd);

		degtrNm = new MSFTextField();
		degtrNm.setFieldLabel("성명");
		lcRow04Col01.add(degtrNm, new FormData("100%"));

		lcRow04.add(lcRow04Col01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		LayoutContainer lcRow04Col02 = new LayoutContainer();

		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow04Col02.setLayout(frmlytStd);

		degtrResnRegnNum = new MSFTextField();
		degtrResnRegnNum.setFieldLabel("주민번호");
		new TextFieldMask<String>(degtrResnRegnNum, "999999-9999999");
		lcRow04Col02.add(degtrResnRegnNum, new FormData("100%"));

		lcRow04.add(lcRow04Col02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		// 05라인		
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

		// 06라인
		LayoutContainer lcRow06 = new LayoutContainer();

		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow06.setLayout(frmlytStd);

		untDpobFndtnAddr = new MSFTextField();
		untDpobFndtnAddr.setFieldLabel("도로명 기본");
		untDpobFndtnAddr.setMaxLength(300);
		lcRow06.add(untDpobFndtnAddr, new FormData("100%"));

		// 07라인
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

		// 08라인
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

		//추가 9라인
		LayoutContainer lcRow09 = new LayoutContainer(new ColumnLayout());
		LayoutContainer lcRow09Col01 = new LayoutContainer(new ColumnLayout());
		LayoutContainer lcRow09Col02 = new LayoutContainer(new ColumnLayout());

		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow09Col01.setLayout(frmlytStd);

		untDpobEctnMailAddr = new MSFTextField();
		untDpobEctnMailAddr.setFieldLabel("전자우편주소");
		untDpobEctnMailAddr.setMaxLength(20);

		lcRow09Col01.add(untDpobEctnMailAddr, new FormData("100%"));
		lcRow09.add(lcRow09Col01, new ColumnData(.5));	

		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow09Col02.setLayout(frmlytStd);

		lcRow09.add(lcRow09Col02, new ColumnData(.5));	

		// 10라인
		LayoutContainer lcRow10 = new LayoutContainer(new ColumnLayout());
		LayoutContainer lcRow10Col01 = new LayoutContainer(new ColumnLayout());
		LayoutContainer lcRow10Col02 = new LayoutContainer(new ColumnLayout());

		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow10Col01.setLayout(frmlytStd);

		upDpobCmpNo = new MSFTextField();
		upDpobCmpNo.setFieldLabel("승인번호");
		upDpobCmpNo.setReadOnly(true);
		upDpobCmpNo.setMaxLength(20);

		lcRow10Col01.add(upDpobCmpNo, new FormData("100%"));
		lcRow10.add(lcRow10Col01, new ColumnData(.5));	

		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow10Col02.setLayout(frmlytStd);

		mtstDpobSeilNumC172 = new MSFTextField();
		mtstDpobSeilNumC172.setFieldLabel("일련번호");
		mtstDpobSeilNumC172.setReadOnly(true);
		mtstDpobSeilNumC172.setMaxLength(20);

		lcRow10Col02.add(mtstDpobSeilNumC172, new FormData("100%"));
		lcRow10.add(lcRow10Col02, new ColumnData(.5));	

		// 11라인
		LayoutContainer lcRow11 = new LayoutContainer(new ColumnLayout());
		LayoutContainer lcRow11Col01 = new LayoutContainer(new ColumnLayout());
		LayoutContainer lcRow11Col02 = new LayoutContainer(new ColumnLayout());

		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow11Col01.setLayout(frmlytStd);

		mnbhDivCd = new MSFComboBox<BaseModel>();
		mnbhDivCd.setFieldLabel("본지점");
		mnbhDivCd.setForceSelection(true);
		mnbhDivCd.setMinChars(1);
		mnbhDivCd.setDisplayField("commCdNm");
		mnbhDivCd.setValueField("commCd");
		mnbhDivCd.setTriggerAction(TriggerAction.ALL);
		mnbhDivCd.setEmptyText("--지점선택--");
		mnbhDivCd.setReadOnly(false);
		mnbhDivCd.setSelectOnFocus(true);
		mnbhDivCd.setStore(lsMnbhDivCd);

		lcRow11Col01.add(mnbhDivCd, new FormData("100%"));
		lcRow11.add(lcRow11Col01, new ColumnData(.5));	

		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow11Col02.setLayout(frmlytStd);

		whdgTxCtypDivCd = new MSFComboBox<BaseModel>();
		whdgTxCtypDivCd.setFieldLabel("원천세징수유형");
		whdgTxCtypDivCd.setForceSelection(true);
		whdgTxCtypDivCd.setMinChars(1);
		whdgTxCtypDivCd.setDisplayField("commCdNm");
		whdgTxCtypDivCd.setValueField("commCd");
		whdgTxCtypDivCd.setTriggerAction(TriggerAction.ALL);
		whdgTxCtypDivCd.setEmptyText("--유형선택--");
		whdgTxCtypDivCd.setReadOnly(false);
		whdgTxCtypDivCd.setSelectOnFocus(true);
		whdgTxCtypDivCd.setStore(lsWhdgTxCtypDivCd);
		
		lcRow11Col02.add(whdgTxCtypDivCd, new FormData("100%"));
		lcRow11.add(lcRow11Col02, new ColumnData(.5));	
		
		// 12라인
		LayoutContainer lcRow12 = new LayoutContainer(new ColumnLayout());
		LayoutContainer lcRow12Col01 = new LayoutContainer(new ColumnLayout());
		LayoutContainer lcRow12Col02 = new LayoutContainer(new ColumnLayout());

		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow12Col01.setLayout(frmlytStd);

		lcRow12.add(lcRow12Col01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow12Col02.setLayout(frmlytStd);

		taxaCode = new MSFTextField();
		taxaCode.setName("taxaCode");
		taxaCode.setFieldLabel("관할세무서");
		taxaCode.setSelectOnFocus(true);

		lcRow12Col02.add(taxaCode, new FormData("100%"));

		lcRow12.add(lcRow12Col02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		// 13라인
		LayoutContainer lcRow13 = new LayoutContainer(new ColumnLayout());
		LayoutContainer lcRow13Col01 = new LayoutContainer(new ColumnLayout());
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow13Col01.setLayout(frmlytStd);
		
		chkgrpYeta4060 = new CheckBoxGroup();
		chkgrpYeta4060.setLabelSeparator("");
		
		untDpobFndtnUseYn = new CheckBox();
		untDpobFndtnUseYn.setName("dpobFndtnUseYn");
		chkgrpYeta4060.add(untDpobFndtnUseYn);
		untDpobFndtnUseYn.setBoxLabel("사용여부");
		untDpobFndtnUseYn.setHideLabel(true);
		untDpobFndtnUseYn.setValue(false);
		lcRow13Col01.add(chkgrpYeta4060, new FormData("100%"));
		
		lcRow13.add(lcRow13Col01, new FormData("100%"));
		
		LayoutContainer lcRow14 = new LayoutContainer(new ColumnLayout());
		LayoutContainer lcRow14Col01 = new LayoutContainer(new ColumnLayout());
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow14Col01.setLayout(frmlytStd);
		
		upDpobUtynC171Group = new RadioGroup();
		upDpobUtynC171Group.setLabelSeparator("");

		upDpobUtynC171Y = new Radio();
		upDpobUtynC171Group.add(upDpobUtynC171Y);
		upDpobUtynC171Y.setBoxLabel("사업자단위과세자(여)");
		upDpobUtynC171Y.setHideLabel(true);
		upDpobUtynC171Y.setValueAttribute("Y");
		
		upDpobUtynC171N = new Radio();
		upDpobUtynC171Group.add(upDpobUtynC171N);
		upDpobUtynC171N.setBoxLabel("사업자단위과세자(부)");
		upDpobUtynC171N.setHideLabel(true);
		upDpobUtynC171N.setValueAttribute("N");

		lcRow14Col01.add(upDpobUtynC171Group, new FormData("100%"));
		
		lcRow14.add(lcRow14Col01, new FormData("100%"));

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
		lcTop.add(lcRow14, new FormData("100%"));
		
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
		
		untDpobSealFlnm = new FileUploadField();
		untDpobSealFlnm.setName("untDpobSealFlnm");
		untDpobSealFlnm.setLabelSeparator("");
		fldLc03.add(untDpobSealFlnm, new FormData("100%"));
		fieldEtcSst.add(fldLc03, new FormData("100%"));
		lcTop.add(fieldEtcSst, new FormData("100%"));
		
		

		return lcTop;
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
		cp01.setSize(450, 540);

		//msfCustomForm.setHeaderVisible(false);
		//Instantiate the GridPanel
		msfGridPanel01 = new MSFGridPanel(mYeta4060Def, false, false, false, false,false);
		msfGridPanel01.setHeaderVisible(false);
		msfGridPanel01.setBodyBorder(true);
		msfGridPanel01.setBorders(true);

		final Grid Yeta4060MGrid = msfGridPanel01.getMsfGrid().getGrid();
		Yeta4060MGrid.addListener(Events.RowDoubleClick, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {  
				if (msfGridPanel01.getCurrentlySelectedItem() != null) { 
					formYeta4060Init();
					//선택된 값을 우측 그리드에 넣기 위한 메서드 호출 
					leftYeta4060Detail(msfGridPanel01.getCurrentlySelectedItem());
				}

				actionDatabase = ActionDatabase.UPDATE;
			}
		}); 	

		cp01.add(msfGridPanel01);

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

		msfGridPanel = new MSFGridPanel(Yeta4060Def, false, false, false, true, true);
		msfGridPanel.setHeaderVisible(false);
		msfGridPanel.setBodyBorder(true);
		msfGridPanel.setBorders(true);

		cpGrid.add(msfGridPanel);
		lcStdGrid.add(cpGrid);
		FieldSetGrid.add(lcStdGrid);

		plFrmYeta4060.add(FieldSetGrid);

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
					utDpobCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
					//사업장명
					//            	   utDpobNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt"))); 
				}  

			}
		});
	}

	private void fnPopupCmmn0320() {

		MSFFormPanel popCom012001 = SysComPopupUtils.lovPopUpMsfCom0120Form(); // 인사

		final FormBinding popBindingCom012001 = popCom012001.getFormBinding();

		popBindingCom012001.addListener(Events.Change, new Listener<BaseEvent>() {
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

	public void setRecord(BaseModel record) {
		this.record = record;
	}

	private Yeta4060 getThis() {
		return this;
	}

	private void leftYeta4060Detail(BaseModel selRecord) {

		utDpobNm.focus();
		utDpobCd.setReadOnly(true); 
		
		YetaUtils.setSelectedComboValue(mtstBusinDivCd, (String)selRecord.get("mtstBusinDivCd"), "commCd");  	// 주종사업장구분

		whdgTxRegrstDeptCd.setValue((String)selRecord.get("utDpobCd"));
		utDpobCd.setValue((String)selRecord.get("utDpobCd")); 										// 사업장코드
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
		untDpobFndtnUseYn.setValue((Boolean) selRecord.get("untDpobFndtnUseYn"));			// 사용여부

		untDpobEctnMailAddr.setValue((String)selRecord.get("untDpobEctnMailAddr")); 		// 전자우편주소
		upDpobCmpNo.setValue((String)selRecord.get("upDpobCmpNo")); 						// 승인번호
		YetaUtils.setCheckedRadioValue(upDpobUtynC171Group, (Boolean)selRecord.get("upDpobUtynC171")? "Y":"N");
		
		mtstDpobSeilNumC172.setValue((String)selRecord.get("mtstDpobSeilNumC172"));	// C172_종사업장일련번호
		YetaUtils.setSelectedComboValue(mnbhDivCd, (String)selRecord.get("mnbhDivCd"), "commCd");	// 본지점구분코드
		YetaUtils.setSelectedComboValue(whdgTxCtypDivCd, (String)selRecord.get("whdgTxCtypDivCd"), "commCd");	// 원천세신고유형구분코드	
		
		untDpobSealWrdNm.setValue((String)selRecord.get("untDpobSealWrdNm")); 						// 직인문구명
		
		if(MSFSharedUtils.paramNotNull( (String)selRecord.get("untDpobSealFlnm"))) {
			untDpobSealRfta.setUrl(GWT.getHostPageBaseURL()
								+ MSFMainApp.getMsg("PayGen.ExTermPhoto")+ "/"
								+ (String)selRecord.get("untDpobSealFlnm")
								+ "");
		}else {
			untDpobSealRfta.setUrl(GWT.getHostPageBaseURL()+ MSFMainApp.getMsg("PayGen.NonExTermPhoto"));
		}
		
		
	}

	/**
	 * 저장
	 */
	private void saveYeta4060(final Yeta4060DTO dto, final ActionDatabase actionDatabase, final String fileName) {
			
		yeta4060Service.saveYeta4060(dto, actionDatabase, new AsyncCallback<String>() {
			@Override
			public void onSuccess(String result) {
				
				if ("DELETE".equals(actionDatabase.name())) {
					
					MessageBox.info("", "삭제 되었습니다.", null);
					
				} else {
					
					if(!"".equals(fileName) && fileName != null){
						//사진 등록처리 servlet 시작
						
					    frmKey.setValue("BASS0120"); 
					    imgKeyCode.setValue(dto.getUtDpobCd());
					    
					    plFrmYeta4060.mask();  
					    plFrmYeta4060.setAction(GWT.getHostPageBaseURL() + "upload/ImageFileUpload.do"); 
	                    plFrmYeta4060.submit();
	                    plFrmYeta4060.onFrameLoad(); 
	                    picBoolFile = true;
						//사진 등록처리 servlet 끝 
	                    
						// reset and unmask the form
						// after file upload
	                    plFrmYeta4060.addListener(Events.Submit, new Listener<FormEvent>() {
				              public void handleEvent(FormEvent evt) {  
				                  plFrmYeta4060.unmask(); 
				                  if ("success".endsWith(evt.getResultHtml()) && picBoolFile) {
				                	  MessageBox.info("알림", "저장 되었습니다.", null);
				                	  picBoolFile = false;
				                  } else {
				                      //TODO 처리 할것 실패 메시지나 에러 메시지 처리 .
				                      evt.setResultHtml("");
				                  }
				              };
				           });
	                    
					}else {
						 MessageBox.info("알림", "저장 되었습니다.", null);
					}
					
				}

				// 상세정보 초기화
				formYeta4060Init();
				mReload();
			}

			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),
						MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnYeta4060("+ actionDatabase.name()+ ") : "+ caught),null);
			}
		});
	}

	/**
	 * 초기화
	 */
	private void formYeta4060Init() {
		utDpobCd.setValue(""); 										// 사업장코드
		utDpobNm.setValue(""); 										// 사업장명
		degtrNm.setValue(""); 										// 대표자성명
		degtrResnRegnNum.setValue(""); 								// 주민번호
		degtrSecRegnNum.setValue(""); 								// 주민번호
		busoprRgstnNum.setValue(""); 								// 사업자번호
		untDpobZpcd.setValue(""); 									// 사업장주소
		untDpobFndtnAddr.setValue(""); 								// 사업장 기본주소
		untDpobDtlPatrAddr.setValue(""); 							// 사업장 상세주소
		untDpobPhnNum.setValue(""); 								// 전화번호
		untDpobFaxNum.setValue(""); 								// 팩스번호
		corpRgstnNum.setValue(""); 									// 법인등록번호
		mtstBusinDivCd.setValue(new BaseModel()); 					// 주종사업장구분
		untDpobFndtnUseYn.setValue(false);							// 사용여부
		untDpobEctnMailAddr.setValue("");							// 전자우편
		upDpobCmpNo.setValue("");									// 단위사업장승인번호
		((Radio)upDpobUtynC171Group.get(0)).setValue(false);
		mtstDpobSeilNumC172.setValue("");							// C172_종사업장일련번호
		mnbhDivCd.setValue(new BaseModel());						// 본지점구분코드
		whdgTxCtypDivCd.setValue(new BaseModel());					// 원천세신고유형구분코드	
		untDpobSealRfta.setUrl(GWT.getHostPageBaseURL() + MSFMainApp.getMsg("PayGen.NonExTermPhoto"));
		untDpobSealFlnm.setValue("");
		untDpobSealWrdNm.setValue("");
		
		
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
