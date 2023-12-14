package com.app.smrmf.sysauth.systemusr.client.form;

import java.util.HashMap;
import java.util.List;

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
import com.app.smrmf.infc.sysif.msfpackage.client.form.defs.SysIfBass0100Def;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0100DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0300DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.service.SysIfBass0100Service;
import com.app.smrmf.infc.sysif.msfpackage.client.service.SysIfBass0100ServiceAsync;
import com.app.smrmf.infc.sysif.msfpackage.client.service.SysIfBass0300Service;
import com.app.smrmf.infc.sysif.msfpackage.client.service.SysIfBass0300ServiceAsync;
import com.app.smrmf.infc.sysif.msfpackage.client.utils.SysifComServiceUtils;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.app.smrmf.sysauth.systemusr.client.languages.SysmUsrConstants;
import com.app.smrmf.sysauth.systemusr.client.utils.SysmUsrUtils;
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
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Image;

/**
 * @Class Name : Bass0100.java
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
public class SysmUsr0050 extends MSFPanel {
	
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 전역변수 선언부 시작
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 **/
	
	// -------------- 상단 버튼 시작 --------------
	private ButtonBar topBass0100Bar;
	private Button btnBass0100New; 
	private Button btnBass0100Save;
	private Button btnBass0100Del;
	private Button btnBass0100Sreach;
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
	private MSFComboBox<BaseModel> tplvlDpobCd; 		// 사업장 상위구분
	private MSFTextField dpobCd; 						// 사업장코드
	private MSFTextField dpobNm; 						// 사업장명
	private MSFTextField degtrNm; 						// 대표자성명
	private MSFTextField degtrResnRegnNum; 				// 주민번호
	private HiddenField<String> degtrSecRegnNum; 		// 주민번호원본 
	private static MSFTextField dpobZpcd; 				// 사업장주소
	private static MSFTextField dpobFndtnAddr; 			// 사업장 기본주소
	private static MSFTextField dpobDtlPatrAddr;	 	// 사업장 상세주소
	private MSFTextField dpobPhnNum; 					// 전화번호
	private MSFTextField dpobFaxNum; 					// 팩스번호
	private MSFTextField busoprRgstnNum; 				// 사업자번호
	private MSFTextField corpRgstnNum; 					// 법인번호
	private Image dpobSealFlNm; 						// 직인사진
	private FileUploadField dpobSealFlNmFile;
	private MSFTextField dpobSealWrdNm; 				// 직인문구명
//	private MSFComboBox<BaseModel> retryCllnDebrDivCd; 	// 징수의무자 
	private MSFComboBox<BaseModel> mtstBusinDivCd; 		// 주종사업장구분 
	
	private MSFComboBox<BaseModel> sysDivCd; 			// 적용시스템
	private CheckBoxGroup chkgrpBass0100;   			// 체크 그룹
	private CheckBox dpobFndtnUseYn;					// 기본사용여부
	private MSFComboBox<BaseModel> sysDpobCd; 			// 시스템사업장코드

	// 이미지 업로드를 위해 추가
	private HiddenField<String> frmKey;
	private HiddenField<String> imgKeyCode;
	
	private Boolean picBoolFile;
	private int iFlag = 0;
	// -------------- 상세정보 종료--------------
	
	// -------------- 사업장 관리번호 시작--------------
	private MSFTextField hlthInsrSym; 					// 건강보험 기호
	private MSFTextField natPennSym; 					// 국민연금 기호
	private MSFTextField umytInsrSym; 					// 고용보험 기호
	private MSFTextField idtlAccdtInsurSym; 			// 산재보험 기호
	private MSFTextField hlthInsrOfceSym;				// 건강보험영업소기호
	
	private MSFTextField insurPrvaffAgcyIstutNum; 		// 보험사무대행기관번호
	private MSFTextField insurPrvaffAgcyIstutNm; 		// 보험사무대행기관명
	// -------------- 사업장 관리번호 종료--------------

	// -------------- Store 시작 --------------
	private ListStore<BaseModel> listStoreParentDpobCd 	= new ListStore<BaseModel>(); 	// 상위사업장 코드
	private ListStore<BaseModel> lsSysDivNm 			= new ListStore<BaseModel>(); 	// 적용시스템 코드
	private ListStore<BaseModel> lsRetryCllnDebrDivCd 	= new ListStore<BaseModel>(); 	// 징수의무자 코드
	private ListStore<BaseModel> lsMtstBusinDivCd		= new ListStore<BaseModel>(); 	// 주종사업장구분 코드
	private ListStore<BaseModel> lsSysDpobCd 			= new ListStore<BaseModel>(); 	// 시스템사업장 코드
	// -------------- Store 종료 --------------

	
	// -------------- 서비스 호출 시작 -------------- 
	//private InfcBass0100ServiceAsync infcBass0100Service = InfcBass0100Service.Util.getInstance();
	private SysIfBass0100ServiceAsync bass0100Service = SysIfBass0100Service.Util.getInstance();
	private SysIfBass0300ServiceAsync sysComBass0300Service = SysIfBass0300Service.Util.getInstance();
	// -------------- 서비스 호출 종료 -------------- 
	
	
	// -------------- grid 시작 -------------- 
	private SysIfBass0100Def bass0100Def = new SysIfBass0100Def(); // 그리드 테이블 컬럼 define
	private MSFGridPanel msfGridPanel;
	
	
	private SysIfBass0100Def mBass0100Def = new SysIfBass0100Def("BASS0100_01"); // 주 그리드 테이블 컬럼 define
	private MSFGridPanel msfGridPanel01;
	
	private SysIfBass0100Def sBass0100Def = new SysIfBass0100Def("BASS0100_02"); // 종 그리드 테이블 컬럼 define
	private MSFGridPanel msfGridPanel02;
	// -------------- grid 끝 --------------  

	// -------------- 상태처리 전역변수  -------------- 
	private ActionDatabase actionDatabase;
	// -------------- 상태처리 전역변수  -------------- 
	
	// -------------- DTO 선언 시작  -------------- 
	private SysIfBass0300DTO sysComBass0300Dto;
	// private PrgmComBass0100DTO sysComBass0100Dto;
	// -------------- DTO 선언 종료  -------------- 

	private SysmUsrConstants lblSysmConst = SysmUsrConstants.INSTANCE;

	private VerticalPanel vp;
	private FormPanel plFrmBass0100;

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
				if (ce.getButton() == btnBass0100Save) {
					doAction(ActionDatabase.INSERT);
				}
			} else if (ce.getButton() == btnBass0100Save) {
				doAction(ActionDatabase.UPDATE);
				actionDatabase = null;
			} else if (ce.getButton() == btnBass0100Del) {
				doAction(ActionDatabase.DELETE);
			}
		}
	};

	private void doAction(ActionDatabase actionDatabase) {
		save(actionDatabase);

	}

	//저장
	public void save(final ActionDatabase actionDatabase) {
		
		if("C0030020" == MSFSharedUtils.allowNulls(SysmUsrUtils.getSelectedComboValue(mtstBusinDivCd, "commCd"))
			|| "C0030020".equals(SysmUsrUtils.getSelectedComboValue(mtstBusinDivCd, "commCd"))
			|| MSFSharedUtils.paramNull(SysmUsrUtils.getSelectedComboValue(mtstBusinDivCd, "commCd"))
		   ) {
			MessageBox.alert("오류", "주종사업장구분은 현재 주사업장만 가능합니다. <br> 주사업장으로 변경 후 저장해주세요.", null);
			return;
		}
		
		
		// final InfcBass0100DTO dto = new InfcBass0100DTO();
		final SysIfBass0100DTO dto = new SysIfBass0100DTO();
		


		dto.setTplvlDpobCd(MSFSharedUtils.allowNulls(SysmUsrUtils.getSelectedComboValue(tplvlDpobCd))); 			// 사업장 상위구분
		dto.setDpobCd(MSFSharedUtils.allowNulls(dpobCd.getValue())); 											// 사업장코드
		dto.setDpobNm(MSFSharedUtils.allowNulls(dpobNm.getValue())); 											// 사업장명
		dto.setDegtrNm(MSFSharedUtils.allowNulls(degtrNm.getValue())); 											// 대표자성명
		dto.setDegtrResnRegnNum(MSFSharedUtils.allowNulls(degtrResnRegnNum.getValue())); 						// 주민번호
		dto.setBusoprRgstnNum(MSFSharedUtils.allowNulls(busoprRgstnNum.getValue())); 							// 사업자번호
		dto.setDpobZpcd(MSFSharedUtils.allowNulls(dpobZpcd.getValue())); 										// 사업장주소
		dto.setDpobFndtnAddr(MSFSharedUtils.allowNulls(dpobFndtnAddr.getValue())); 								// 사업장 기본주소
		dto.setDpobDtlPatrAddr(MSFSharedUtils.allowNulls(dpobDtlPatrAddr.getValue())); 							// 사업장 상세주소
		dto.setDpobPhnNum(MSFSharedUtils.allowNulls(dpobPhnNum.getValue())); 									// 전화번호
		dto.setDpobFaxNum(MSFSharedUtils.allowNulls(dpobFaxNum.getValue()));	 								// 팩스번호
		dto.setCorpRgstnNum(MSFSharedUtils.allowNulls(corpRgstnNum.getValue())); 								// 법인번호
		dto.setDpobSealWrdNm(MSFSharedUtils.allowNulls(dpobSealWrdNm.getValue())); 								// 직인문구명
		dto.setSysDivCd("EXTERM00"); 																			// 적용시스템
//		dto.setRetryCllnDebrDivCd(SysmUsrUtils.getSelectedComboValue(retryCllnDebrDivCd));	// 징수의무자
		dto.setMtstBusinDivCd(MSFSharedUtils.allowNulls(
										SysmUsrUtils.getSelectedComboValue(mtstBusinDivCd, "commCd")));			// 주종사업장구분
		dto.setSysDpobCd(MSFSharedUtils.allowNulls(
				SysmUsrUtils.getSelectedComboValue(sysDpobCd, "commCd")));											// 시스템사업장코드
		dto.setDpobSealRftaNm(MSFSharedUtils.allowNulls(MSFMainApp.getMsg("PayGen.ExTermPhoto"))); 				// 직인이미지
		dto.setDpobFndtnUseYn(dpobFndtnUseYn.getValue() ? "Y" : "N");					// 사용여부
//		dto.setHlthInsrSym(hlthInsrSym.getValue()); 									// 건강보험 기호
//		dto.setHlthInsrOfceSym(hlthInsrOfceSym.getValue());								// 건강보험영업소기호
//		dto.setNatPennSym(natPennSym.getValue()); 										// 국민연금 기호
//		dto.setUmytInsrSym(umytInsrSym.getValue()); 									// 고용보험 기호
//		dto.setIdtlAccdtInsurSym(idtlAccdtInsurSym.getValue()); 						// 산재보험 기호
//		dto.setInsurPrvaffAgcyIstutNum(insurPrvaffAgcyIstutNum.getValue()); 			// 보험사무대행기관번호
//		dto.setInsurPrvaffAgcyIstutNm(insurPrvaffAgcyIstutNm.getValue()); 				// 보험사무대행기관명
		
//		dto.setTplvlDpobCd(SysmUsrUtils.getSelectedComboValue(tplvlDpobCd)); // 사업장 상위구분
//		dto.setDpobCd(dpobCd.getValue()); // 사업장코드
//		dto.setDpobNm(dpobNm.getValue()); // 사업장명
//		dto.setDegtrNm(degtrNm.getValue()); // 대표자성명
//		dto.setDegtrResnRegnNum(degtrResnRegnNum.getValue()); // 주민번호
//		dto.setBusoprRgstnNum(busoprRgstnNum.getValue()); // 사업자번호
//		dto.setDpobZpcd(dpobZpcd.getValue()); // 사업장주소
//		dto.setDpobFndtnAddr(dpobFndtnAddr.getValue()); // 사업장 기본주소
//		dto.setDpobDtlPatrAddr(dpobDtlPatrAddr.getValue()); // 사업장 상세주소
//		dto.setDpobPhnNum(dpobPhnNum.getValue()); // 전화번호
//		dto.setDpobFaxNum(dpobFaxNum.getValue()); // 팩스번호
//		dto.setCorpRgstnNum(corpRgstnNum.getValue()); // 법인번호
//		dto.setDpobSealWrdNm(dpobSealWrdNm.getValue()); // 직인문구명
//		dto.setSysDivCd(SysmUsrUtils.getSelectedComboValue(sysDivCd)); // 적용시스템
//		dto.setDpobSealRftaNm(MSFMainApp.getMsg("PayGen.ExTermPhoto")); // 직인이미지
//		dto.setHlthInsrSym(hlthInsrSym.getValue()); // 건강보험 기호
//		dto.setNatPennSym(natPennSym.getValue()); // 국민연금 기호
//		dto.setUmytInsrSym(umytInsrSym.getValue()); // 고용보험 기호
//		dto.setIdtlAccdtInsurSym(idtlAccdtInsurSym.getValue()); // 산재보험 기호
//		dto.setInsurPrvaffAgcyIstutNum(insurPrvaffAgcyIstutNum.getValue()); // 보험사무대행기관번호
//		dto.setInsurPrvaffAgcyIstutNm(insurPrvaffAgcyIstutNm.getValue()); // 보험사무대행기관명


		if ("".equals(dto.getDpobCd()) || dto.getDpobCd() == null) {
			MessageBox.info("", "사업장코드는 필수 입니다.", null);
			dpobCd.focus();
		} else if ("".equals(dto.getDpobNm()) || dto.getDpobNm() == null) {
			MessageBox.info("", "사업장명은 필수 입니다.", null);
			dpobNm.focus();
		} else if ("".equals(dto.getDegtrNm()) || dto.getDegtrNm() == null) {
			MessageBox.info("", "대표자성명은 필수 입니다.", null);
			degtrNm.focus();
		} else if ("".equals(dto.getBusoprRgstnNum())
				|| dto.getBusoprRgstnNum() == null) {
			MessageBox.info("", "사업자번호는 필수 입니다.", null);
			busoprRgstnNum.focus();
		} else if ("".equals(dto.getDpobZpcd()) || dto.getDpobZpcd() == null
				&& "".equals(dto.getDpobFndtnAddr())
				|| dto.getDpobFndtnAddr() == null) {
			MessageBox.info("", "사업장주소는 필수 입니다.", null);
			dpobZpcd.focus();
		} else if ("".equals(dto.getDpobPhnNum())
				|| dto.getDpobPhnNum() == null) {
			MessageBox.info("", "사업장전화번호는 필수 입니다.", null);
			dpobPhnNum.focus();
		} else if ("".equals(dto.getDpobFaxNum())
				|| dto.getDpobFaxNum() == null) {
			MessageBox.info("", "사업장팩스번호는 필수 입니다.", null);
			dpobFaxNum.focus();
		} else {
			final String fileName = dpobSealFlNmFile.getValue();
			if (!"".equals(fileName) && fileName != null) {
				// dto.setDpobSealFlNm(fileName.substring(fileName.lastIndexOf("\\")+1));
				// //사진 이미지 파일명
				dto.setDpobSealFlNm(dpobCd.getValue() + fileName.substring(fileName.lastIndexOf("."))); // 직인 이미지 저장시 사업자 코드로.확장자로 처리
			}
			MessageBox.confirm("", "DELETE".equals(actionDatabase.name()) ? "삭제 하시겠습니까?": "저장 하시겠습니까?", new Listener<MessageBoxEvent>() {
				@Override
				public void handleEvent(MessageBoxEvent be) {
					
//					iFlag = 0;
					//if ("Yes".equals(be.getButtonClicked().getText())) {
					if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
						// 주사업장일 경우 한 건만 저장할 수 있게끔 해준다.
						if(dto.getMtstBusinDivCd() == "C0030010" || "C0030010".equals(dto.getMtstBusinDivCd())) {
							
							bass0100Service.chkBass0100(dto, actionDatabase, new AsyncCallback<Integer>() {

								@Override
								public void onFailure(Throwable caught) {
									// TODO Auto-generated method stub
									MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),
											MSFMainApp.ADMINMESSAGES.ExceptionMessageService("chkBass0100("+ actionDatabase.name()+ ") : "+ caught),null);
								}

								@Override
								public void onSuccess(Integer result) {
									// TODO Auto-generated method stub
									if(result == 1) {
										MessageBox.info("경고","주사업장은 1곳만 입력할 수 있습니다.</br>데이터를 확인해주세요.", null);
									}else {
										// 저장 처리
										saveBass0100(dto, actionDatabase, fileName);
									}
								}
							});
						}else {
							// 저장 처리
							saveBass0100(dto, actionDatabase, fileName);
						}
						
//						if(iFlag == 1) {
//							MessageBox.info("경고","주사업장은 1곳만 입력할 수 있습니다.</br>데이터를 확인해주세요.", null);
//							return;
//						}else {
//							// 저장 처리
//							saveBass0100(dto, actionDatabase, fileName);
//						}
						
//						bass0100Service.saveBass0100(dto, actionDatabase, new AsyncCallback<String>() {
//							@Override
//							public void onSuccess(String result) {
//								if ("DELETE".equals(actionDatabase.name())) {
//									MessageBox.info("","삭제 되었습니다.", null);
//						} else {
//							MessageBox.info("","저장 되었습니다.", null);
//						}
//						if (!"".equals(fileName) && fileName != null) {
//							dpobSealFlNmFile.setName("BASS0100" + "_" + dpobCd.getValue());
//							imgKeyCode.setValue(dpobCd.getValue());
//							frmKey.setValue("BASS0100");
//							plFrmBass0100.mask();
//							plFrmBass0100.setAction(GWT.getHostPageBaseURL() + "upload/ImageFileUpload.do"); 
////							plFrmBass0100.setAction(GWT.getHostPageBaseURL() + MSFMainApp.getMsg("Globals.ExTermPhoto")+ "/");
//							plFrmBass0100.submit();
//							plFrmBass0100.onFrameLoad();
//							picBoolFile = true;
//							plFrmBass0100.addListener(Events.Submit, new Listener<FormEvent>() {
//								public void handleEvent(FormEvent evt) {
//									plFrmBass0100.unmask();
//									if ("success".endsWith(evt.getResultHtml())&& picBoolFile) {
//										// 업로드가 성공했으면 인서트 모듈을 태운다.
//										// dtime.schedule(2000);
//										picBoolFile = false;
//										evt.setResultHtml("");
//									} else {
//										// TODO 처리  할것 실패 메시지나 에러 메시지 처리
//										evt.setResultHtml("");
//									}
//								};
//							});
//						}
//						
//						//상세정보 초기화
//						formBass0100Init();
//						mReload();
//						sReload();
////						reload();
//						}
//
//						@Override
//						public void onFailure(Throwable caught) {
//							caught.printStackTrace();
//							MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),
//							MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnBass0100("+ actionDatabase.name()+ ") : "+ caught),null);
//							}
//						});
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
			      $entry(@com.app.exterms.basis.client.form.Bass0100::onCloseGwtFunction(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;));
	  }-*/;
	 public static void onCloseGwtFunction(String zpcd,String fnDtnAddr,String dtlPatrAddr )
	  { 
		  // your gwt code tobe executed 
		// Window.alert(postId);
		 dpobZpcd.setValue(MSFSharedUtils.allowNulls(zpcd)); 
		 dpobFndtnAddr.setValue(MSFSharedUtils.allowNulls(fnDtnAddr)); // 앞주소
		 dpobDtlPatrAddr.setValue(MSFSharedUtils.allowNulls(dtlPatrAddr)); // 뒷주소
		    
	  }
	 /**************************************************************/
	 /** 우편번호 로직 추가    												*/
	 /**************************************************************/
		
	 

	public ContentPanel getViewPanel() {
		
		sysComBass0300Dto = new SysIfBass0300DTO();
		
		// --------------------공통 코드 불러 오는 함수----------------------------------------------------
		sysComBass0300Dto = new SysIfBass0300DTO();
		sysComBass0300Dto.setRpsttvCd("R005");
		lsRetryCllnDebrDivCd = SysifComServiceUtils.getSingleBass0300ComboData(sysComBass0300Dto);
		// -------------------------------------------------------------------------------------------
		
		
		// --------------------공통 코드 불러 오는 함수----------------------------------------------------
		sysComBass0300Dto = new SysIfBass0300DTO();
		sysComBass0300Dto.setRpsttvCd("C003");
		lsMtstBusinDivCd = SysifComServiceUtils.getSingleBass0300ComboData(sysComBass0300Dto);
		// -------------------------------------------------------------------------------------------
		
		if (panel == null) {
			GWTUtils.popupDoroWndClose(); 
			closeFunction();
			
			// 상위 사업장
			bass0100Service.getParentDpobCd(new AsyncCallback<List<BaseModel>>() {
				@Override
				public void onSuccess(List<BaseModel> result) {
					listStoreParentDpobCd.add(result);
				}

				@Override
				public void onFailure(Throwable caught) {
					MessageBox.alert("", "상위사업장코드 에러!", null);
				}
			});

			// 적용시스템
			bass0100Service.getBass0100sysDivCdList(new AsyncCallback<List<BaseModel>>() {
				@Override
				public void onSuccess(List<BaseModel> result) {
					// TODO Auto-generated method stub
					lsSysDivNm.add(result);
				}

				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					MessageBox.alert("", "적용시스템 에러!".concat(caught.toString()) , null);
				}
			});
			
			
			// 시스템사업장
			bass0100Service.getSysDpobCd(new AsyncCallback<List<BaseModel>>() {
				@Override
				public void onSuccess(List<BaseModel> result) {
					// TODO Auto-generated method stub
					lsSysDpobCd.add(result);
				}

				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
						MessageBox.alert("", "시스템사업장 에러!".concat(caught.toString()) , null);
				}
			});
			
			
			
			detailTp = XTemplate.create(getDetailTemplate());

			// formData = new FormData("-650");
			vp = new VerticalPanel();
			vp.setSpacing(10);
			createBass0100Form(); 		// 화면 기본정보를 설정
			createSearchForm(); 		// 검색필드를 적용
//			createListGrid(); 			// 사업장정보 그리드
			createStandardForm(); 		// 사업장 상세 정보
//			createStdSubFrom(); 		// 사업장 관리번호
			vp.setSize("1010px", "700px");
			/**
			 * -------------------------------------------------------------------
			 * 폼 바인딩 및 공통 콤보 로딩시 처리 선언부 시작
			 * -------------------------------------------------------------------
			 */
			// 폼데이터를 바인딩
			formBinding = new FormBinding(this.plFrmBass0100, true);

			// setBass0100FormBinding(); //폼바인딩처리 - 입력필드
			// bindMsfComBass0400(formBinding.getModel()); //부서코드
			// bindMsfComBass0500(formBinding.getModel()); //사업코드
			// bindMsfComBass0300(formBinding.getModel(),"A003"); //재직상태구분코드
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

			// final FormBinding formBinding = msfCustomForm.getFormBinding();
			// formBinding.addListener(Events.Bind, new Listener<BaseEvent>() {
			// public void handleEvent(BaseEvent be) {
			// bass0100Def.refreshObjectLinked((BaseModel)
			// formBinding.getModel());
			// }
			// });

			// formBinding.getBinding(dpobCd).getField().setValue("dddddd");
			// dpobCd.setValue(String.valueOf(formBinding.getBinding(dpobCd).getField().getValue()));
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
	public SysmUsr0050() {
		setSize("1010px", "700px");
	}

	// 생성자 함수에 변수을 받아 처리
	public SysmUsr0050(String txtForm) {
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
	private void createBass0100Form() {

		plFrmBass0100 = new FormPanel();
		plFrmBass0100.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - " + lblSysmConst.title_Sysm0050()));
		plFrmBass0100.setIcon(MSFMainApp.ICONS.text());
		plFrmBass0100.setBodyStyleName("pad-text");
		
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage(lblSysmConst.title_Sysm0050(),"SysmUsr0050");
				}
			});
		plFrmBass0100.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmBass0100.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/
		
		plFrmBass0100.setPadding(2);
		plFrmBass0100.setFrame(true);
		plFrmBass0100.setLayout(new FormLayout());

		degtrSecRegnNum = new HiddenField<String>();
		imgKeyCode = new HiddenField<String>();
		imgKeyCode.setName("imgKeyCode");
		plFrmBass0100.add(imgKeyCode);
		frmKey = new HiddenField<String>();
		frmKey.setName("frmKey");
		plFrmBass0100.add(frmKey);

		// formBinding
		// msfCustomForm = new MSFCustomForm(bass0100Def, 600, 150, false, true,
		// true);

		topBass0100Bar = new ButtonBar();
		topBass0100Bar.setAlignment(HorizontalAlignment.RIGHT);

		btnBass0100New = new Button("신규");
		btnBass0100New.setIcon(MSFMainApp.ICONS.new16());
		topBass0100Bar.add(btnBass0100New);
		btnBass0100New.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				// 신규 버튼 클릭시 처리
				formBass0100Init();
				
				actionDatabase = ActionDatabase.INSERT;
			}
		});


		btnBass0100Save = new Button("저장");
		btnBass0100Save.setIcon(MSFMainApp.ICONS.save16());
//		btnBass0100Save.addSelectionListener(selectionListener);
		btnBass0100Save.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				if(ActionDatabase.INSERT.equals(actionDatabase)) {
					
					doAction(actionDatabase);
				}else {
					actionDatabase = ActionDatabase.UPDATE;
					doAction(actionDatabase);
				}
			}
		});
		topBass0100Bar.add(btnBass0100Save);

		btnBass0100Del = new Button("삭제");
		btnBass0100Del.setIcon(MSFMainApp.ICONS.delete16());
		btnBass0100Del.addSelectionListener(selectionListener);
		topBass0100Bar.add(btnBass0100Del);

		btnBass0100Sreach = new Button("조회");
		btnBass0100Sreach.setIcon(MSFMainApp.ICONS.search16());
		topBass0100Bar.add(btnBass0100Sreach);
		btnBass0100Sreach.addListener(Events.Select,
				new Listener<ButtonEvent>() {
					public void handleEvent(ButtonEvent e) {
						/**
						dpobCd.setReadOnly(false); // 사업장코드
						tplvlDpobCd.setValue(new BaseModel()); // 사업장 상위구분
						dpobCd.setValue(""); // 사업장코드
						dpobNm.setValue(""); // 사업장명
						degtrNm.setValue(""); // 대표자성명
						dpobSealWrdNm.setValue(""); // 직인문구명
						degtrResnRegnNum.setValue(""); // 주민번호
						dpobZpcd.setValue(""); // 사업장주소
						dpobFndtnAddr.setValue(""); // 사업장 기본주소
						dpobDtlPatrAddr.setValue(""); // 사업장 상세주소
						dpobPhnNum.setValue(""); // 전화번호
						dpobFaxNum.setValue(""); // 팩스번호
						busoprRgstnNum.setValue(""); // 사업자번호
						corpRgstnNum.setValue(""); // 법인번호
						dpobSealFlNm.setUrl(GWT.getHostPageBaseURL() + MSFMainApp.getMsg("PayGen.NonExTermPhoto")); // 직인사진
						dpobSealFlNmFile.setValue("");
						 */
						// 조회버튼 클릭시 처리
						mReload();
						sReload();
					}
				});

		plFrmBass0100.add(topBass0100Bar);

		// 파일업로드 처리 - 사업장 직인 정보
		plFrmBass0100.setAction("myurl"); // url 정보 추가 할것.
		plFrmBass0100.setEncoding(Encoding.MULTIPART);
		plFrmBass0100.setMethod(Method.POST);

		vp.add(plFrmBass0100);
		plFrmBass0100.setSize("990px", "680px");
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
		// srhDpobNm.setAllowBlank(false);
		lcSchLeft.add(srhDpobNm, new FormData("90%"));

		srhDegtrNm = new TextField<String>();
		srhDegtrNm.setName("srhDegtrNm");
		srhDegtrNm.setFieldLabel("대표자명");
		lcSchRight.add(srhDegtrNm, new FormData("90%"));

		lcSchCol.add(lcSchLeft, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		lcSchCol.add(lcSchRight, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		fieldSet.add(lcSchCol, new FormData("90%"));

		plFrmBass0100.add(fieldSet);
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
	
	
	private void createStandardForm() {
		
		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer01 = new LayoutContainer();
//		layoutContainer01.setStyleAttribute("paddingLeft", "10px");
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
		
		plFrmBass0100.add(layoutContainer);
		
	}
	
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
		
		tplvlDpobCd = new MSFComboBox<BaseModel>();
		tplvlDpobCd.setFieldLabel("상위사업장");
		tplvlDpobCd.setForceSelection(true);
		tplvlDpobCd.setMinChars(1);
		tplvlDpobCd.setDisplayField("commCdNm");
		tplvlDpobCd.setValueField("commCd");
		tplvlDpobCd.setTriggerAction(TriggerAction.ALL);
		tplvlDpobCd.setEmptyText("--상위사업장선택--");
		tplvlDpobCd.setSelectOnFocus(true);
		tplvlDpobCd.setStore(listStoreParentDpobCd);

		lcRow01Col02.add(tplvlDpobCd, new FormData("100%"));
		
		lcRow01.add(lcRow01Col02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		
		
		LayoutContainer lcRow02 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lcRow02Col01 = new LayoutContainer();
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow02Col01.setLayout(frmlytStd);
		
		dpobCd = new MSFTextField();
		dpobCd.setMaxLength(14);
		// DPOB_CD.getMessages().setMaxLengthText("한글7자 영어숫자 14자");
		dpobCd.setFieldLabel("사업장 코드");
		//dpobCd.setReadOnly(false);
		lcRow02Col01.add(dpobCd, new FormData("100%"));   
		
		lcRow02.add(lcRow02Col01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		LayoutContainer lcRow02Col02 = new LayoutContainer();
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow02Col02.setLayout(frmlytStd);
		
		dpobNm = new MSFTextField();
		dpobNm.setFieldLabel("사업장명");
		dpobNm.setMaxLength(300);
		lcRow02Col02.add(dpobNm, new FormData("100%"));
		
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
		// busoprRgstnNum.setEmptyText("___-__-_____");
		// BUSOPR_RGSTN_NUM.setMaxLength(10);
		lcRow03Col01.add(busoprRgstnNum, new FormData("100%"));
		
		lcRow03.add(lcRow03Col01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		LayoutContainer lcRow03Col02 = new LayoutContainer();
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow03Col02.setLayout(frmlytStd);
		
		corpRgstnNum = new MSFTextField();
		corpRgstnNum.setFieldLabel("법인번호");
		// CORP_RGSTN_NUM.setMaxLength(14);
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
		
		dpobZpcd = new MSFTextField();
		dpobZpcd.setFieldLabel("사업장 주소");
		lcRow05Col01Fld.add(dpobZpcd, new FormData("100%"));
		
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
		
//		frmlytStd = new FormLayout();  
//		frmlytStd.setLabelWidth(0); 
//		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
//		lcRow05Col02.setLayout(frmlytStd);
//		
//		dpobFndtnAddr = new MSFTextField();
//		dpobFndtnAddr.setLabelSeparator("");
//		// dpobFndtnAddr.setWidth(210);
////		dpobFndtnAddr.setWidth("90%");
//		dpobFndtnAddr.setMaxLength(300);
//		lcRow05Col02.add(dpobFndtnAddr, new FormData("100%"));
		
		lcRow05.add(lcRow05Col02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		
		LayoutContainer lcRow06 = new LayoutContainer();
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow06.setLayout(frmlytStd);
		
		dpobFndtnAddr = new MSFTextField();
		dpobFndtnAddr.setFieldLabel("도로명 기본");
//		dpobFndtnAddr.setLabelSeparator("");
		// dpobFndtnAddr.setWidth(210);
//		dpobFndtnAddr.setWidth("90%");
		dpobFndtnAddr.setMaxLength(300);
		lcRow06.add(dpobFndtnAddr, new FormData("100%"));
		
		
		LayoutContainer lcRow07 = new LayoutContainer();
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow07.setLayout(frmlytStd);
		
		dpobDtlPatrAddr = new MSFTextField();
		dpobDtlPatrAddr.setFieldLabel("도로명 상세");
		// dpobDtlPatrAddr.setWidth(210);
//		dpobDtlPatrAddr.setWidth("90%");
		dpobDtlPatrAddr.setMaxLength(300);
		lcRow07.add(dpobDtlPatrAddr, new FormData("100%"));
		
		
		LayoutContainer lcRow08 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lcRow08Col01 = new LayoutContainer();
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow08Col01.setLayout(frmlytStd);
		
		dpobPhnNum = new MSFTextField();
		dpobPhnNum.setFieldLabel("사업장전화번호");
		lcRow08Col01.add(dpobPhnNum, new FormData("100%"));
		lcRow08.add(lcRow08Col01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		
		LayoutContainer lcRow08Col02 = new LayoutContainer();
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow08Col02.setLayout(frmlytStd);
		
		dpobFaxNum = new MSFTextField();
		dpobFaxNum.setFieldLabel("사업장팩스번호");
		dpobFaxNum.setMaxLength(20);
		lcRow08Col02.add(dpobFaxNum, new FormData("100%"));
		lcRow08.add(lcRow08Col02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));	
		
		
		LayoutContainer lcRow09 = new LayoutContainer(new ColumnLayout());
		
		
		LayoutContainer lcRow09Col01 = new LayoutContainer(new ColumnLayout());
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow09Col01.setLayout(frmlytStd);
		
		chkgrpBass0100 = new CheckBoxGroup();
		chkgrpBass0100.setLabelSeparator("");
	     
		dpobFndtnUseYn = new CheckBox();
		dpobFndtnUseYn.setName("dpobFndtnUseYn");
		chkgrpBass0100.add(dpobFndtnUseYn);
		dpobFndtnUseYn.setBoxLabel("사용여부");
		dpobFndtnUseYn.setHideLabel(true);
		dpobFndtnUseYn.setValue(false);
		lcRow09Col01.add(chkgrpBass0100, new FormData("100%"));
		
		lcRow09.add(lcRow09Col01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		
		LayoutContainer lcRow09Col02 = new LayoutContainer(new ColumnLayout());
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow09Col02.setLayout(frmlytStd);
		
		sysDpobCd = new MSFComboBox<BaseModel>();
		sysDpobCd.setFieldLabel("시스템사업장");
		sysDpobCd.setForceSelection(true);
		sysDpobCd.setMinChars(1);
		sysDpobCd.setDisplayField("commCdNm");
		sysDpobCd.setValueField("commCd");
		sysDpobCd.setTriggerAction(TriggerAction.ALL);
		sysDpobCd.setEmptyText("--시스템사업장선택--");
		sysDpobCd.setSelectOnFocus(true);
		sysDpobCd.setStore(lsSysDpobCd);

		lcRow09Col02.add(sysDpobCd, new FormData("100%"));
		lcRow09.add(lcRow09Col02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));		
		
		
		
		FieldSet fieldEtcSst = new FieldSet();
		fieldEtcSst.setHeadingHtml("추가정보");
		
		LayoutContainer fldLc01 = new LayoutContainer();
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		fldLc01.setLayout(frmlytStd);
		
		dpobSealWrdNm = new MSFTextField();
		dpobSealWrdNm.setFieldLabel("직인문구명");
		fldLc01.add(dpobSealWrdNm, new FormData("100%"));
		fieldEtcSst.add(fldLc01, new FormData("100%"));
		
		
		LayoutContainer fldLc02 = new LayoutContainer(new ColumnLayout());
		
		
		LayoutContainer lbLc = new LayoutContainer();
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lbLc.setLayout(frmlytStd);
		
		TextField<String> lbFld = new TextField<String>();
		lbFld.setFieldLabel("직인이미지");
//		LabelField lbFld = new LabelField( "직인이미지 : " );
		lbLc.add(lbFld, new FormData("0%"));
		fldLc02.add(lbLc, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.22));
		
		
		
		LayoutContainer imgLc = new LayoutContainer();
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		imgLc.setLayout(frmlytStd);
		
		imgLc.setStyleAttribute("paddingLeft", "5px");
//		fldLc02.setStyleAttribute("paddingBottom", "4px");
		
		dpobSealFlNm = new Image();
		dpobSealFlNm.setUrl(GWT.getHostPageBaseURL() + MSFMainApp.getMsg("PayGen.NonExTermPhoto"));
		dpobSealFlNm.setSize("120px", "130px");
		dpobSealFlNm.setVisible(true);
		dpobSealFlNm.setTitle("직인이미지");
		
		imgLc.add(dpobSealFlNm);
		fldLc02.add(imgLc);
		
		fieldEtcSst.add(fldLc02, new FormData("100%"));
		
		
		LayoutContainer fldLc03 = new LayoutContainer();
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(100); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		fldLc03.setLayout(frmlytStd);
		
		dpobSealFlNmFile = new FileUploadField();
		dpobSealFlNmFile.setLabelSeparator("");
//		dpobSealFlNmFile.setWidth(120);
		fldLc03.add(dpobSealFlNmFile, new FormData("100%"));
		
		
		fieldEtcSst.add(fldLc03, new FormData("100%"));
		
		
		
		LayoutContainer lcRow11 = new LayoutContainer();
		
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(0); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcRow11.setLayout(frmlytStd);
		
//		dpobSealFlNmFile = new FileUploadField();
//		dpobSealFlNmFile.setLabelSeparator("");
////		dpobSealFlNmFile.setWidth(120);
//		lcRow11.add(dpobSealFlNmFile, new FormData("50%"));
		
		
		lcTop.add(lcRow01, new FormData("100%"));
		lcTop.add(lcRow02, new FormData("100%"));
		lcTop.add(lcRow03, new FormData("100%"));
		lcTop.add(lcRow04, new FormData("100%"));
		lcTop.add(lcRow05, new FormData("100%"));
		lcTop.add(lcRow06, new FormData("100%"));
		lcTop.add(lcRow07, new FormData("100%"));
		lcTop.add(lcRow08, new FormData("100%"));
		lcTop.add(lcRow09, new FormData("100%"));
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
		// lc1.setStyleAttribute("paddingRight", "10px");
		FormLayout fl1 = new FormLayout();
		fl1.setLabelWidth(100);
		fl1.setLabelAlign(LabelAlign.RIGHT);
		lc1.setLayout(fl1);

		// tplvlDpobCd = new ComboBox<BaseModel>();
		tplvlDpobCd = new MSFComboBox<BaseModel>();
		tplvlDpobCd.setFieldLabel("상위사업장");
		tplvlDpobCd.setForceSelection(true);
		tplvlDpobCd.setMinChars(1);
		tplvlDpobCd.setDisplayField("commCdNm");
		tplvlDpobCd.setValueField("commCd");
		tplvlDpobCd.setTriggerAction(TriggerAction.ALL);
		tplvlDpobCd.setEmptyText("--상위사업장선택--");
		tplvlDpobCd.setSelectOnFocus(true);
		tplvlDpobCd.setStore(listStoreParentDpobCd);

		lc1.add(tplvlDpobCd, new FormData("90%"));
		lcTop1.add(lc1);

		LayoutContainer lc2 = new LayoutContainer();
		FormLayout fl2 = new FormLayout();
		fl2.setLabelWidth(100);
		fl2.setLabelAlign(LabelAlign.RIGHT);
		lc2.setLayout(fl2);

		// DEGTR_NM = new TextField<String>();
		degtrNm = new MSFTextField();
		degtrNm.setFieldLabel("대표자 성명");

		lc2.add(degtrNm, new FormData("90%"));
		lcTop1.add(lc2);

		LayoutContainer lc3 = new LayoutContainer();
		FormLayout fl3 = new FormLayout();
		fl3.setLabelWidth(100);
		fl3.setLabelAlign(LabelAlign.RIGHT);
		lc3.setLayout(fl3);

		// DPOB_ZPCD = new TextField<String>();
		dpobZpcd = new MSFTextField();
		dpobZpcd.setFieldLabel("사업장 주소");
		lc3.add(dpobZpcd, new FormData("90%"));

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

		// DPOB_PHN_NUM = new TextField<String>();
		dpobPhnNum = new MSFTextField();
		dpobPhnNum.setFieldLabel("사업장전화번호");
		lc6.add(dpobPhnNum, new FormData("90%"));
		lcTop1.add(lc6);

		LayoutContainer lc6_1 = new LayoutContainer();
		FormLayout fl6_1 = new FormLayout();
		fl6_1.setLabelWidth(100);
		fl6_1.setLabelAlign(LabelAlign.RIGHT);
		lc6_1.setLayout(fl6_1);

		// dpobSealWrdNm = new TextField<String>();
		dpobSealWrdNm = new MSFTextField();
		dpobSealWrdNm.setFieldLabel("직인문구명");
		lc6_1.add(dpobSealWrdNm, new FormData("90%"));
		lcTop1.add(lc6_1);
		
		LayoutContainer lc35 = new LayoutContainer();
		FormLayout fl35 = new FormLayout();
		fl35.setLabelWidth(95);
		fl35.setLabelAlign(LabelAlign.RIGHT);
		lc35.setLayout(fl35);
		
		chkgrpBass0100 = new CheckBoxGroup();
		chkgrpBass0100.setLabelSeparator("");
	     
		dpobFndtnUseYn = new CheckBox();
		dpobFndtnUseYn.setName("dpobFndtnUseYn");
		chkgrpBass0100.add(dpobFndtnUseYn);
		dpobFndtnUseYn.setBoxLabel("사용여부");
		dpobFndtnUseYn.setHideLabel(true);
		dpobFndtnUseYn.setValue(false);
		lc35.add(chkgrpBass0100, new FormData("90%"));
		lcTop1.add(lc35);
	    

		LayoutContainer lc7 = new LayoutContainer();
		FormLayout fl7 = new FormLayout();
		fl7.setLabelWidth(95);
		fl7.setLabelAlign(LabelAlign.RIGHT);
		lc7.setLayout(fl7);

		// DPOB_CD = new TextField<String>();
		dpobCd = new MSFTextField();
		dpobCd.setMaxLength(14);
		// DPOB_CD.getMessages().setMaxLengthText("한글7자 영어숫자 14자");
		dpobCd.setFieldLabel("사업장 코드");
		//dpobCd.setReadOnly(false);
		lc7.add(dpobCd, new FormData("90%"));   
		lcTop2.add(lc7);
		

		LayoutContainer lc8 = new LayoutContainer();
		FormLayout fl8 = new FormLayout();
		fl8.setLabelWidth(95);
		fl8.setLabelAlign(LabelAlign.RIGHT);
		lc8.setLayout(fl8);
 
		// DEGTR_RESN_REGN_NUM = new TextField<String>();
		degtrResnRegnNum = new MSFTextField();
		degtrResnRegnNum.setFieldLabel("대표자주민번호");
		new TextFieldMask<String>(degtrResnRegnNum, "999999-9999999");

		// DEGTR_RESN_REGN_NUM.setMaxLength(14);
		lc8.add(degtrResnRegnNum, new FormData("90%"));
		lcTop2.add(lc8);

		LayoutContainer lc9 = new LayoutContainer();
		// DPOB_FNDTN_ADDR = new TextField<String>();
		dpobFndtnAddr = new MSFTextField();
		// dpobFndtnAddr.setWidth(210);
		dpobFndtnAddr.setWidth("90%");
		dpobFndtnAddr.setMaxLength(300);
		lc9.add(dpobFndtnAddr, new FormData("100%"));
		lcTop2.add(lc9, new FormData("90%"));

		LayoutContainer lc10 = new LayoutContainer();
		FormLayout fl10 = new FormLayout();
		fl10.setLabelWidth(95);
		fl10.setLabelAlign(LabelAlign.RIGHT);
		lc10.setLayout(fl10);
		// DPOB_FAX_NUM = new TextField<String>();
		dpobFaxNum = new MSFTextField();
		dpobFaxNum.setFieldLabel("사업장팩스번호");
		dpobFaxNum.setMaxLength(20);
		lc10.add(dpobFaxNum, new FormData("90%"));
		lcTop2.add(lc10);

		LayoutContainer lc20 = new LayoutContainer();
		// lc1.setStyleAttribute("paddingRight", "10px");
		FormLayout fl20 = new FormLayout();
		fl20.setLabelWidth(95);
		fl20.setLabelAlign(LabelAlign.RIGHT);
		lc20.setLayout(fl20);

		sysDivCd = new MSFComboBox<BaseModel>();
		sysDivCd.setName("sysDivCd");
		sysDivCd.setFieldLabel("적용시스템");
		sysDivCd.setForceSelection(true);
		sysDivCd.setDisplayField("commCdNm");
		sysDivCd.setValueField("commCd");
		sysDivCd.setTriggerAction(TriggerAction.ALL);
		sysDivCd.setEmptyText("--적용시스템--");
		sysDivCd.setSelectOnFocus(true);
		sysDivCd.setStore(lsSysDivNm);

		lc20.add(sysDivCd, new FormData("90%"));
		lcTop2.add(lc20);

		LayoutContainer lc11 = new LayoutContainer();
		FormLayout fl11 = new FormLayout();
		fl11.setLabelWidth(80);
		fl11.setLabelAlign(LabelAlign.RIGHT);
		lc11.setLayout(fl11);

		// DPOB_NM = new TextField<String>();
		dpobNm = new MSFTextField();
		dpobNm.setFieldLabel("사업장명");
		dpobNm.setMaxLength(300);
		lc11.add(dpobNm, new FormData("90%"));
		lcTop3.add(lc11);

		LayoutContainer lc12 = new LayoutContainer();
		FormLayout fl12 = new FormLayout();
		fl12.setLabelWidth(80);
		fl12.setLabelAlign(LabelAlign.RIGHT);
		lc12.setLayout(fl12);

		// BUSOPR_RGSTN_NUM = new TextField<String>();
		busoprRgstnNum = new MSFTextField();
		busoprRgstnNum.setFieldLabel("사업자번호");
		new TextFieldMask<String>(busoprRgstnNum, "999-99-99999");
		// busoprRgstnNum.setEmptyText("___-__-_____");
		// BUSOPR_RGSTN_NUM.setMaxLength(10);
		lc12.add(busoprRgstnNum, new FormData("90%"));
		lcTop3.add(lc12);

		LayoutContainer lc13 = new LayoutContainer();
		// DPOB_DTL_PATR_ADDR = new TextField<String>();
		dpobDtlPatrAddr = new MSFTextField();
		// dpobDtlPatrAddr.setWidth(210);
		dpobDtlPatrAddr.setWidth("90%");
		dpobDtlPatrAddr.setMaxLength(300);
		lc13.add(dpobDtlPatrAddr, new FormData("100%"));
		lcTop3.add(lc13, new FormData("90%"));

		LayoutContainer lc14 = new LayoutContainer();
		FormLayout fl14 = new FormLayout();
		fl14.setLabelWidth(80);
		fl14.setLabelAlign(LabelAlign.RIGHT);
		lc14.setLayout(fl14);

		// CORP_RGSTN_NUM = new TextField<String>();
		corpRgstnNum = new MSFTextField();
		corpRgstnNum.setFieldLabel("법인번호");
		// CORP_RGSTN_NUM.setMaxLength(14);
		lc14.add(corpRgstnNum, new FormData("90%"));
		lcTop3.add(lc14);

		LayoutContainer lc17 = new LayoutContainer();
		// lc1.setStyleAttribute("paddingRight", "10px");
		FormLayout fl17 = new FormLayout();
		fl17.setLabelWidth(80);
		fl17.setLabelAlign(LabelAlign.RIGHT);
		lc17.setLayout(fl17);

		// retryCllnDebrDivCd = new ComboBox<BaseModel>();
//		retryCllnDebrDivCd = new MSFComboBox<BaseModel>();
//		retryCllnDebrDivCd.setFieldLabel("징수의무자");
//		retryCllnDebrDivCd.setForceSelection(true);
//		retryCllnDebrDivCd.setMinChars(1);
//		retryCllnDebrDivCd.setDisplayField("commCdNm");
//		retryCllnDebrDivCd.setValueField("commCd");
//		// retryCllnDebrDivCd.setTriggerAction(TriggerAction.ALL);
//		retryCllnDebrDivCd.setEmptyText("--징수의무자선택--");
//		retryCllnDebrDivCd.setSelectOnFocus(true);
//		retryCllnDebrDivCd.setStore(lsRetryCllnDebrDivCd);
//
//		lc17.add(retryCllnDebrDivCd, new FormData("90%"));
//		lcTop3.add(lc17);

		LayoutContainer lc15 = new LayoutContainer();
		lc15.setStyleAttribute("paddingLeft", "15px");
		lc15.setStyleAttribute("paddingBottom", "4px");
		dpobSealFlNm = new Image();
		dpobSealFlNm.setUrl(GWT.getHostPageBaseURL()
				+ MSFMainApp.getMsg("PayGen.NonExTermPhoto"));
		dpobSealFlNm.setSize("120px", "130px");
		dpobSealFlNm.setVisible(true);
		dpobSealFlNm.setTitle("사진");
		lc15.add(dpobSealFlNm);
		lcTop4.add(lc15);

		LayoutContainer lc16 = new LayoutContainer();
		lc16.setStyleAttribute("paddingLeft", "15px");
		dpobSealFlNmFile = new FileUploadField();
		dpobSealFlNmFile.setWidth(120);
		lc16.add(dpobSealFlNmFile, new FormData("90%"));
		lcTop4.add(lc16);

		lcTop.add(lcTop1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		lcTop.add(lcTop2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		lcTop.add(lcTop3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		lcTop.add(lcTop4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));

		fieldSetStdForm.add(lcTop);

		plFrmBass0100.add(fieldSetStdForm);

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
		// fieldSetSub.setHeading("사업장기호");
		fieldSetSub.setHeadingHtml("사업장 관리번호");//.setHeading("사업장 관리번호");
		fieldSetSub.setCollapsible(false);

		LayoutContainer lc = new LayoutContainer(new ColumnLayout());

		LayoutContainer lc1 = new LayoutContainer();
		FormLayout fl1 = new FormLayout();
		fl1.setLabelWidth(60);
		fl1.setLabelAlign(LabelAlign.RIGHT);
		lc1.setLayout(fl1);

		// HLTH_INSR_SYM = new TextField<String>();
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

		// NAT_PENN_SYM = new TextField<String>();
		natPennSym = new MSFTextField();
		natPennSym.setFieldLabel("국민연금");
		natPennSym.setMaxLength(20);
		lc2.add(natPennSym, new FormData("100%"));

		LayoutContainer lc3 = new LayoutContainer();
		FormLayout fl3 = new FormLayout();
		fl3.setLabelWidth(70);
		fl3.setLabelAlign(LabelAlign.RIGHT);
		lc3.setLayout(fl3);

		// UMYT_INSR_SYM = new TextField<String>();
		umytInsrSym = new MSFTextField();
		umytInsrSym.setFieldLabel("고용보험");
		umytInsrSym.setMaxLength(20);
		lc3.add(umytInsrSym, new FormData("100%"));

		LayoutContainer lc4 = new LayoutContainer();
		FormLayout fl4 = new FormLayout();
		fl4.setLabelWidth(70);
		fl4.setLabelAlign(LabelAlign.RIGHT);
		lc4.setLayout(fl4);

		// IDTL_ACCDT_INSUR_SYM = new TextField<String>();
		idtlAccdtInsurSym = new MSFTextField();
		idtlAccdtInsurSym.setFieldLabel("산재보험");
		idtlAccdtInsurSym.setMaxLength(20);
		lc4.add(idtlAccdtInsurSym, new FormData("100%"));

		LayoutContainer lc_2 = new LayoutContainer(new ColumnLayout());

		LayoutContainer lc6 = new LayoutContainer();
		FormLayout fl6 = new FormLayout();
		fl6.setLabelWidth(130);
		fl6.setLabelAlign(LabelAlign.RIGHT);
		lc6.setLayout(fl6);

		insurPrvaffAgcyIstutNum = new MSFTextField();
		insurPrvaffAgcyIstutNum.setFieldLabel("보험사무대행기관번호");
		insurPrvaffAgcyIstutNum.setMaxLength(20);
		lc6.add(insurPrvaffAgcyIstutNum, new FormData("77.5%"));

		LayoutContainer lc7 = new LayoutContainer();
		FormLayout fl7 = new FormLayout();
		fl7.setLabelWidth(202);
		fl7.setLabelAlign(LabelAlign.RIGHT);
		lc7.setLayout(fl7);

		insurPrvaffAgcyIstutNm = new MSFTextField();
		insurPrvaffAgcyIstutNm.setFieldLabel("보험사무대행기관명");
		insurPrvaffAgcyIstutNm.setMaxLength(20);
		lc7.add(insurPrvaffAgcyIstutNm, new FormData("100%"));

		lc.add(lc1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.19));
		lc.add(lc5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.12));
		lc.add(lc2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.23));
		lc.add(lc3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.23));
		lc.add(lc4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.23));

		lc_2.add(lc6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		lc_2.add(lc7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));

		fieldSetSub.add(lc);
		fieldSetSub.add(lc_2);

		plFrmBass0100.add(fieldSetSub, new FormData("100%"));
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
		msfGridPanel01 = new MSFGridPanel(mBass0100Def, false, false, false, false,false);
		msfGridPanel01.setHeaderVisible(false);
		msfGridPanel01.setBodyBorder(true);
		msfGridPanel01.setBorders(true);
		
        final Grid bass0100MGrid = msfGridPanel01.getMsfGrid().getGrid();
        bass0100MGrid.addListener(Events.RowDoubleClick, new Listener<BaseEvent>() {
           public void handleEvent(BaseEvent be) {  
        	   if (msfGridPanel01.getCurrentlySelectedItem() != null) { 
         		  
         		 formBass0100Init();
         		 
         		 //선택된 값을 우측 그리드에 넣기 위한 메서드 호출 
         		 leftBass0100Detail(msfGridPanel01.getCurrentlySelectedItem());
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
		msfGridPanel02 = new MSFGridPanel(sBass0100Def, false, false, false, false, false);
		msfGridPanel02.setHeaderVisible(false);
		msfGridPanel02.setBodyBorder(true);
		msfGridPanel02.setBorders(true);
		
        final Grid bass0100MGrid = msfGridPanel02.getMsfGrid().getGrid();
        bass0100MGrid.addListener(Events.RowDoubleClick, new Listener<BaseEvent>() {
           public void handleEvent(BaseEvent be) {  
         	  if (msfGridPanel02.getCurrentlySelectedItem() != null) { 
         		  
//         		  formBass0100Init();
         		  
         		  //선택된 값을 우측 그리드에 넣기 위한 메서드 호출 
         		  leftBass0100Detail(msfGridPanel02.getCurrentlySelectedItem());
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

		msfGridPanel = new MSFGridPanel(bass0100Def, false, false, false, true, true);
		msfGridPanel.setHeaderVisible(false);
		msfGridPanel.setBodyBorder(true);
		msfGridPanel.setBorders(true);
		
//		//그리드 선택시
//		final Grid<BaseModel> grid = msfGridPanel.getMsfGrid().getGrid();
//		grid.addListener(Events.RowClick, new Listener<GridEvent<BaseModel>>() {
//			@Override
//			public void handleEvent(GridEvent<BaseModel> be) {
//				dpobNm.focus();
//				// dpobCd.setReadOnly(true);
//				dpobCd.setReadOnly(true);
//				SysmUsrUtils.setSelectedComboValue(tplvlDpobCd, grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("tplvlDpobCd")+ ""); // 사업자 상위구분
//				dpobCd.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("dpobCd") == null 
//								? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("dpobCd")+ ""); // 사업장코드
//				dpobNm.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("dpobNm") == null 
//								? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("dpobNm")+ ""); // 사업장명
//				degtrNm.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("degtrNm") == null 
//								? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("degtrNm")+ ""); // 대표자성명
//				degtrResnRegnNum.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("degtrResnRegnNum") == null 
//								? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("degtrResnRegnNum")+ ""); // 주민번호
//				dpobZpcd.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("dpobZpcd") == null 
//								? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("dpobZpcd")+ ""); // 사업장주소
//				dpobFndtnAddr.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("dpobFndtnAddr") == null 
//								? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("dpobFndtnAddr")+ ""); // 사업장 기본주소
//				dpobDtlPatrAddr.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("dpobDtlPatrAddr") == null 
//								? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("dpobDtlPatrAddr")+ ""); // 사업장 상세주소
//				dpobPhnNum.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("dpobPhnNum") == null 
//								? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("dpobPhnNum")+ ""); // 전화번호
//				dpobFaxNum.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("dpobFaxNum") == null 
//								? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("dpobFaxNum")+ ""); // 팩스번호
//				busoprRgstnNum.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("busoprRgstnNum") == null 
//								? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("busoprRgstnNum")+ ""); // 사업자번호
//				corpRgstnNum.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("corpRgstnNum") == null 
//								? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("corpRgstnNum")+ ""); // 직인사진
//				if (grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("dpobSealFlNm") != null
//						&& !"".equals(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("dpobSealFlNm"))) {
//								dpobSealFlNm.setUrl(GWT.getHostPageBaseURL()+ MSFMainApp.getMsg("PayGen.ExTermPhoto")+ "/"
//								+ grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("dpobSealFlNm") + "");
//				} else {
//					dpobSealFlNm.setUrl(GWT.getHostPageBaseURL()+ MSFMainApp.getMsg("PayGen.NonExTermPhoto"));
//				}
//				
//				SysmUsrUtils.setSelectedComboValue(sysDivCd, grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("sysDivCd") + "", "sysDivNm"); // 적용시스템
//				
//				dpobSealWrdNm.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("dpobSealWrdNm") == null 
//						? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("dpobSealWrdNm") + ""); 		// 직인문구명
//				hlthInsrSym.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("hlthInsrSym") == null 
//						? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("hlthInsrSym") + ""); 		// 건강보험
//				hlthInsrOfceSym.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("hlthInsrOfceSym") == null 
//						? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("hlthInsrOfceSym") + ""); 	// 건강보험영업소기호 
//				natPennSym.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("natPennSym") == null 
//						? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("natPennSym") + ""); 			// 국민연금
//				umytInsrSym.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("umytInsrSym") == null 
//						? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("umytInsrSym") + ""); 		// 고용보험
//				idtlAccdtInsurSym.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("idtlAccdtInsurSym") == null 
//						? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("idtlAccdtInsurSym") + ""); 	// 산재보험
//				insurPrvaffAgcyIstutNum.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("insurPrvaffAgcyIstutNum") == null 
//						? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("insurPrvaffAgcyIstutNum") + ""); 	// 보험사무대행기관번호
////				insurPrvaffAgcyIstutNm.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("insurPrvaffAgcyIstutNm") == null 
////						? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("insurPrvaffAgcyIstutNm") + ""); 	// 보험사무대행기관명
////				SysmUsrUtils.setSelectedComboValue(retryCllnDebrDivCd, grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("retryCllnDebrDivCd") + "");	//징수의무자
//				dpobFndtnUseYn.setValue("Y".equals(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("dpobFndtnUseYn")) ? true : false); //사용여부
//			}
//		});

		/*
		 * grid.getSelectionModel().addSelectionChangedListener(new
		 * SelectionChangedListener<BaseModel>() {
		 * 
		 * @Override public void
		 * selectionChanged(SelectionChangedEvent<BaseModel> se) {
		 * 
		 * private ComboBox<BaseModel> tplvlDpobCd; //사업장 상위구분 private
		 * TextField<String> DPOB_CD; //사업장코드 private TextField<String> DPOB_NM;
		 * //사업장명 private TextField<String> DEGTR_NM; //대표자성명 private
		 * TextField<String> DEGTR_RESN_REGN_NUM; //주민번호 private
		 * TextField<String> DPOB_ZPCD; //사업장주소 private TextField<String>
		 * DPOB_FNDTN_ADDR; //사업장 기본주소 private TextField<String>
		 * DPOB_DTL_PATR_ADDR; //사업장 상세주소 private TextField<String>
		 * DPOB_PHN_NUM; //전화번호 private TextField<String> DPOB_FAX_NUM; //팩스번호
		 * private TextField<String> BUSOPR_RGSTN_NUM; //사업자번호 private
		 * TextField<String> CORP_RGSTN_NUM; //법인번호 private Image
		 * DPOB_SEAL_FL_NM; //직인사진 private FileUploadField DPOB_SEAL_FL_NM_FILE;
		 * 
		 * DPOB_CD.setReadOnly(true);
		 * 
		 * SysmUsrUtils.setSelectedComboValue(tplvlDpobCd,
		 * se.getSelectedItem().get("tplvlDpobCd")+"");
		 * DPOB_CD.setValue(se.getSelectedItem().get("dpobCd") == null ? "" :
		 * se.getSelectedItem().get("dpobCd")+"");
		 * DPOB_NM.setValue(se.getSelectedItem().get("dpobNm") == null ? "" :
		 * se.getSelectedItem().get("dpobNm")+"");
		 * DEGTR_NM.setValue(se.getSelectedItem().get("degtrNm") == null ? "" :
		 * se.getSelectedItem().get("degtrNm")+"");
		 * DEGTR_RESN_REGN_NUM.setValue(
		 * se.getSelectedItem().get("degtrResnRegnNum") == null ? "" :
		 * se.getSelectedItem().get("degtrResnRegnNum")+"");
		 * DPOB_ZPCD.setValue(se.getSelectedItem().get("dpobZpcd") == null ? ""
		 * : se.getSelectedItem().get("dpobZpcd")+"");
		 * DPOB_FNDTN_ADDR.setValue(se.getSelectedItem().get("dpobFndtnAddr") ==
		 * null ? "" : se.getSelectedItem().get("dpobFndtnAddr")+"");
		 * DPOB_DTL_PATR_ADDR
		 * .setValue(se.getSelectedItem().get("dpobDtlPatrAddr") == null ? "" :
		 * se.getSelectedItem().get("dpobDtlPatrAddr")+"");
		 * DPOB_PHN_NUM.setValue(se.getSelectedItem().get("dpobPhnNum") == null
		 * ? "" : se.getSelectedItem().get("dpobPhnNum")+"");
		 * DPOB_FAX_NUM.setValue(se.getSelectedItem().get("dpobFaxNum") == null
		 * ? "" : se.getSelectedItem().get("dpobFaxNum")+"");
		 * BUSOPR_RGSTN_NUM.setValue(se.getSelectedItem().get("busoprRgstnNum")
		 * == null ? "": se.getSelectedItem().get("busoprRgstnNum")+"");
		 * CORP_RGSTN_NUM.setValue(se.getSelectedItem().get("corpRgstnNum") ==
		 * null ? "" : se.getSelectedItem().get("corpRgstnNum")+"");
		 * 
		 * if( se.getSelectedItem().get("dpobSealFlNm") != null &&
		 * !"".equals(se.getSelectedItem().get("dpobSealFlNm")) ){
		 * DPOB_SEAL_FL_NM
		 * .setUrl(GWT.getHostPageBaseURL()+MSFMainApp.getMsg("PayGen.ExTermUpload"
		 * )
		 * +"/"+se.getSelectedItem().get("dpobSealRftaNm")+"/"+se.getSelectedItem
		 * ().get("dpobSealFlNm")+""); }else{
		 * DPOB_SEAL_FL_NM.setUrl(GWT.getHostPageBaseURL
		 * ()+MSFMainApp.getMsg("PayGen.NonExTermPhoto")); } } });
		 */
		cpGrid.add(msfGridPanel);
		lcStdGrid.add(cpGrid);
		FieldSetGrid.add(lcStdGrid);

		plFrmBass0100.add(FieldSetGrid);

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
	private void fnPopupCmmn0320() {

		MSFFormPanel popCom0120 = SysComPopupUtils.lovPopUpMsfCom0120Form(); // 인사

		final FormBinding popBindingCom0120 = popCom0120.getFormBinding();

		popBindingCom0120.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				BaseModel mapModel = (BaseModel) be.getSource();
				if (!"".equals(mapModel.get("zpcd"))) {
					dpobZpcd.setValue(MSFSharedUtils.allowNulls(mapModel.get("zpcd"))); 				// 우편번호
					dpobFndtnAddr.setValue(MSFSharedUtils.allowNulls(mapModel.get("fnDtnAddr"))); 		// 앞주소
					dpobDtlPatrAddr.setValue(MSFSharedUtils.allowNulls(mapModel.get("dtlPatrAddr"))); 	// 뒷주소
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
//		msfGridPanel.getTableDef().setTableColumnFilters(filters);
//		msfGridPanel.getTableDef().addColumnFilter("srhDpobNm",srhDpobNm.getValue(), SimpleColumnFilter.OPERATOR_LIKE);
//		msfGridPanel.getTableDef().addColumnFilter("srhDegtrNm",srhDegtrNm.getValue(), SimpleColumnFilter.OPERATOR_LIKE);
//		msfGridPanel.reload();
		
		msfGridPanel01.getTableDef().setTableColumnFilters(filters);
		msfGridPanel01.getTableDef().addColumnFilter("srhDpobNm",srhDpobNm.getValue(), SimpleColumnFilter.OPERATOR_LIKE);
		msfGridPanel01.getTableDef().addColumnFilter("srhDegtrNm",srhDegtrNm.getValue(), SimpleColumnFilter.OPERATOR_LIKE);
		msfGridPanel01.reload();
		
//		//상세정보 초기화
//		formBass0100Init();
		
//		dpobCd.setReadOnly(false);
//		tplvlDpobCd.setValue(new BaseModel()); 		// 상위사업장
//		dpobCd.setValue(""); 						// 사업장코드
//		dpobNm.setValue(""); 						// 사업장명
//		degtrNm.setValue(""); 						// 대표자서명
//		degtrResnRegnNum.setValue(""); 				// 주민번호
//		degtrSecRegnNum.setValue(""); 				// 주민번호
//		dpobZpcd.setValue(""); 						// 사업장주소
//		dpobFndtnAddr.setValue(""); 				// 사업장 기본주소
//		dpobDtlPatrAddr.setValue(""); 				// 사업장 상세주소
//		dpobPhnNum.setValue(""); 					// 전화번호
//		dpobFaxNum.setValue(""); 					// 팩스번호
//		busoprRgstnNum.setValue(""); 				// 사업자번호
//		corpRgstnNum.setValue(""); 					// 법인번호
//		dpobSealFlNm.setUrl(GWT.getHostPageBaseURL() + MSFMainApp.getMsg("PayGen.NonExTermPhoto"));
//		dpobSealFlNmFile.setValue("");
//		hlthInsrSym.setValue(""); 					// 건강보험
//		hlthInsrOfceSym.setValue("");				// 건강보험영업소기호
//		natPennSym.setValue(""); 					// 국민연금
//		umytInsrSym.setValue(""); 					// 고용보험
//		idtlAccdtInsurSym.setValue(""); 			// 산재보험
//		dpobSealWrdNm.setValue(""); 				// 직인문구명
//		sysDivCd.setValue(new BaseModel()); 		// 적용시스템
//		insurPrvaffAgcyIstutNum.setValue(""); 		// 보험사무대행기관번호
//		insurPrvaffAgcyIstutNm.setValue(""); 		// 보험사무대행기관명
//		dpobFndtnUseYn.setValue(false);				// 급여관리부서기본사용여부
////		retryCllnDebrDivCd.setValue(new BaseModel());//징수의무자
//		mtstBusinDivCd.setValue(new BaseModel());	// 주종사업장구분
		

		// payr0301GridPanel.getTableDef().setTableColumnFilters(filters);
		// payr0301GridPanel.getTableDef().addColumnFilter("pubcHodyCtnt",
		// srhPubcHodyCtnt.getRawValue(), SimpleColumnFilter.OPERATOR_LIKE);
		// payr0301GridPanel.reload();
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

	private SysmUsr0050 getThis() {
		return this;
	}
	
    private void leftBass0100Detail(BaseModel selRecord) {
    	
        
		dpobNm.focus();
		// dpobCd.setReadOnly(true);
		dpobCd.setReadOnly(true); 
		
//		Window.alert("적용시스템 코드 -> " + (String)selRecord.get("sysDivCd"));
		SysmUsrUtils.setSelectedComboValue(mtstBusinDivCd 
								, (String)selRecord.get("mtstBusinDivCd$commCd"), "commCd");  	// 주종사업장구분
		SysmUsrUtils.setSelectedComboValue(tplvlDpobCd
								, (String)selRecord.get("dpobCd"), "commCd");  					// 사업자 상위구분
		dpobCd.setValue((String)selRecord.get("dpobCd")); 										// 사업장코드
		dpobNm.setValue((String)selRecord.get("dpobNm")); 										// 사업장명
		busoprRgstnNum.setValue((String)selRecord.get("busoprRgstnNum")); 						// 사업자번호
		corpRgstnNum.setValue((String)selRecord.get("corpRgstnNum")); 							// 법인번호
		degtrNm.setValue((String)selRecord.get("degtrNm")); 									// 대표자성명
		degtrResnRegnNum.setValue((String)selRecord.get("degtrResnRegnNum")); 					// 주민번호
		dpobZpcd.setValue((String)selRecord.get("dpobZpcd"));									// 사업장주소
		dpobFndtnAddr.setValue((String)selRecord.get("dpobFndtnAddr"));				 			// 사업장 기본주소
		dpobDtlPatrAddr.setValue((String)selRecord.get("dpobDtlPatrAddr")); 					// 사업장 상세주소
		dpobPhnNum.setValue((String)selRecord.get("dpobPhnNum")); 								// 전화번호
		dpobFaxNum.setValue((String)selRecord.get("dpobFaxNum")); 								// 팩스번호
//		SysmUsrUtils.setSelectedComboValue(sysDivCd,(String)selRecord.get("commCd"),"commCd");		// 적용시스템
		dpobSealWrdNm.setValue((String)selRecord.get("dpobSealWrdNm")); 						// 직인문구명
		dpobFndtnUseYn.setValue((Boolean) selRecord.get("dpobFndtnUseYn"));						// 사용여부
		SysmUsrUtils.setSelectedComboValue(sysDpobCd 
								, (String)selRecord.get("sysDpobCd"), "commCd");  				// 시스템사업장코드
		
		if(MSFSharedUtils.paramNotNull( (String)selRecord.get("dpobSealFlNm"))) {
			dpobSealFlNm.setUrl(GWT.getHostPageBaseURL()
								+ MSFMainApp.getMsg("PayGen.ExTermPhoto")+ "/"
								+ (String)selRecord.get("dpobSealFlNm")
								+ "");
		}else {
			dpobSealFlNm.setUrl(GWT.getHostPageBaseURL()+ MSFMainApp.getMsg("PayGen.NonExTermPhoto"));
		}
		
		
		
		
		
//		hlthInsrSym.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("hlthInsrSym") == null 
//				? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("hlthInsrSym") + ""); 		// 건강보험
//		hlthInsrOfceSym.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("hlthInsrOfceSym") == null 
//				? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("hlthInsrOfceSym") + ""); 	// 건강보험영업소기호 
//		natPennSym.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("natPennSym") == null 
//				? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("natPennSym") + ""); 			// 국민연금
//		umytInsrSym.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("umytInsrSym") == null 
//				? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("umytInsrSym") + ""); 		// 고용보험
//		idtlAccdtInsurSym.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("idtlAccdtInsurSym") == null 
//				? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("idtlAccdtInsurSym") + ""); 	// 산재보험
//		insurPrvaffAgcyIstutNum.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("insurPrvaffAgcyIstutNum") == null 
//				? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("insurPrvaffAgcyIstutNum") + ""); 	// 보험사무대행기관번호
//		insurPrvaffAgcyIstutNm.setValue(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("insurPrvaffAgcyIstutNm") == null 
//				? "" : grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("insurPrvaffAgcyIstutNm") + ""); 	// 보험사무대행기관명
//		SysmUsrUtils.setSelectedComboValue(retryCllnDebrDivCd, grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("retryCllnDebrDivCd") + "");	//징수의무자
//		dpobFndtnUseYn.setValue("Y".eq?uals(grid.getStore().getAt(grid.getStore().indexOf(grid.getSelectionModel().getSelectedItem())).get("dpobFndtnUseYn")) ? true : false); //사용여부
		
    
    }
    
    private void saveBass0100(SysIfBass0100DTO dto, final ActionDatabase actionDatabase, final String fileName) {
    	
    	
		bass0100Service.saveBass0100(dto, actionDatabase, new AsyncCallback<String>() {
			@Override
			public void onSuccess(String result) {
				if ("DELETE".equals(actionDatabase.name())) {
					MessageBox.info("","삭제 되었습니다.", null);
		} else {
			MessageBox.info("","저장 되었습니다.", null);
		}
		if (!"".equals(fileName) && fileName != null) {
			dpobSealFlNmFile.setName("BASS0100" + "_" + dpobCd.getValue());
			imgKeyCode.setValue(dpobCd.getValue());
			frmKey.setValue("BASS0100");
			plFrmBass0100.mask();
			plFrmBass0100.setAction(GWT.getHostPageBaseURL() + "upload/ImageFileUpload.do"); 
//			plFrmBass0100.setAction(GWT.getHostPageBaseURL() + MSFMainApp.getMsg("Globals.ExTermPhoto")+ "/");
			plFrmBass0100.submit();
			plFrmBass0100.onFrameLoad();
			picBoolFile = true;
			plFrmBass0100.addListener(Events.Submit, new Listener<FormEvent>() {
				public void handleEvent(FormEvent evt) {
					plFrmBass0100.unmask();
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
		formBass0100Init();
		mReload();
		sReload();
//		reload();
		}

		@Override
		public void onFailure(Throwable caught) {
			caught.printStackTrace();
			MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),
			MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnBass0100("+ actionDatabase.name()+ ") : "+ caught),null);
			}
		});
    	
    }

	private void formBass0100Init() {
		tplvlDpobCd.setValue(new BaseModel()); 			// 상위사업장
		dpobCd.setValue(""); 							// 사업장코드
		dpobCd.setReadOnly(false);
		dpobNm.setValue(""); 							// 사업장명
		degtrNm.setValue(""); 							// 대표자성명
		degtrResnRegnNum.setValue(""); 					// 주민번호
		degtrSecRegnNum.setValue(""); 					// 주민번호
		busoprRgstnNum.setValue(""); 					// 사업자번호
		dpobZpcd.setValue(""); 							// 사업장주소
		dpobFndtnAddr.setValue(""); 					// 사업장 기본주소
		dpobDtlPatrAddr.setValue(""); 					// 사업장 상세주소
		dpobPhnNum.setValue(""); 						// 전화번호
		dpobFaxNum.setValue(""); 						// 팩스번호
		corpRgstnNum.setValue(""); 						// 법인번호
		dpobSealWrdNm.setValue("");			 			// 직인문구명
//		sysDivCd.setValue(new BaseModel()); 			// 적용시스템
		mtstBusinDivCd.setValue(new BaseModel()); 		// 주종사업장구분
//		retryCllnDebrDivCd.setValue(new BaseModel()); 	// 징수의무자
		dpobSealFlNm.setUrl(GWT.getHostPageBaseURL() + MSFMainApp.getMsg("PayGen.NonExTermPhoto"));
		dpobSealFlNmFile.setValue("");
		dpobFndtnUseYn.setValue(false);					// 사용여부
		sysDpobCd.setValue(new BaseModel());			// 시스템사업장
//		hlthInsrSym.setValue(""); 						// 건강보험 기호
//		natPennSym.setValue(""); 						// 국민연금 기호
//		umytInsrSym.setValue("");					 	// 고용보험 기호
//		idtlAccdtInsurSym.setValue(""); 				// 산재보험 기호
//		insurPrvaffAgcyIstutNum.setValue(""); 			// 보험사무대행기관번호
//		insurPrvaffAgcyIstutNm.setValue(""); 			// 보험사무대행기관명

//		actionDatabase = ActionDatabase.INSERT;
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
