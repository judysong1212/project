package com.app.exterms.personal.client.form;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.app.exterms.payroll.client.form.PayrP410001;
import com.app.exterms.personal.client.dto.Psnl0100DTO;
import com.app.exterms.personal.client.dto.Psnl0110DTO;
import com.app.exterms.personal.client.dto.Psnl0111DTO;
import com.app.exterms.personal.client.dto.Psnl0112DTO;
import com.app.exterms.personal.client.dto.Psnl0113DTO;
import com.app.exterms.personal.client.dto.Psnl0114DTO;
import com.app.exterms.personal.client.dto.Psnl0115DTO;
import com.app.exterms.personal.client.dto.Psnl0116DTO;
import com.app.exterms.personal.client.dto.Psnl0118DTO;
import com.app.exterms.personal.client.dto.Psnl0119DTO;
import com.app.exterms.personal.client.dto.Psnl0120DTO;
import com.app.exterms.personal.client.dto.Psnl0121DTO;
import com.app.exterms.personal.client.dto.Psnl0122DTO;
import com.app.exterms.personal.client.dto.Psnl0123DTO;
import com.app.exterms.personal.client.dto.Psnl0127DTO;
import com.app.exterms.personal.client.dto.Psnl0131DTO;
import com.app.exterms.personal.client.dto.Psnl0133DTO;
import com.app.exterms.personal.client.dto.Psnl0134DTO;
import com.app.exterms.personal.client.service.Psnl0100Service;
import com.app.exterms.personal.client.service.Psnl0100ServiceAsync;
import com.app.exterms.personal.client.service.Psnl0110Service;
import com.app.exterms.personal.client.service.Psnl0110ServiceAsync;
import com.app.exterms.personal.client.service.Psnl0111Service;
import com.app.exterms.personal.client.service.Psnl0111ServiceAsync;
import com.app.exterms.personal.client.service.Psnl0112Service;
import com.app.exterms.personal.client.service.Psnl0112ServiceAsync;
import com.app.exterms.personal.client.service.Psnl0113Service;
import com.app.exterms.personal.client.service.Psnl0113ServiceAsync;
import com.app.exterms.personal.client.service.Psnl0114Service;
import com.app.exterms.personal.client.service.Psnl0114ServiceAsync;
import com.app.exterms.personal.client.service.Psnl0115Service;
import com.app.exterms.personal.client.service.Psnl0115ServiceAsync;
import com.app.exterms.personal.client.service.Psnl0116Service;
import com.app.exterms.personal.client.service.Psnl0116ServiceAsync;
import com.app.exterms.personal.client.service.Psnl0118Service;
import com.app.exterms.personal.client.service.Psnl0118ServiceAsync;
import com.app.exterms.personal.client.service.Psnl0119Service;
import com.app.exterms.personal.client.service.Psnl0119ServiceAsync;
import com.app.exterms.personal.client.service.Psnl0120Service;
import com.app.exterms.personal.client.service.Psnl0120ServiceAsync;
import com.app.exterms.personal.client.service.Psnl0121Service;
import com.app.exterms.personal.client.service.Psnl0121ServiceAsync;
import com.app.exterms.personal.client.service.Psnl0122Service;
import com.app.exterms.personal.client.service.Psnl0122ServiceAsync;
import com.app.exterms.personal.client.service.Psnl0123Service;
import com.app.exterms.personal.client.service.Psnl0123ServiceAsync;
import com.app.exterms.personal.client.service.Psnl0127Service;
import com.app.exterms.personal.client.service.Psnl0127ServiceAsync;
import com.app.exterms.personal.client.service.Psnl0133Service;
import com.app.exterms.personal.client.service.Psnl0133ServiceAsync;
import com.app.exterms.personal.client.service.Psnl0134Service;
import com.app.exterms.personal.client.service.Psnl0134ServiceAsync;
import com.app.exterms.personal.client.service.PsnlP010001Service;
import com.app.exterms.personal.client.service.PsnlP010001ServiceAsync;
import com.app.exterms.personal.client.utils.PersonalUtil;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.service.PrgmComBass0300Service;
import com.app.exterms.prgm.client.service.PrgmComBass0300ServiceAsync;
import com.app.exterms.prgm.client.service.PrgmComBass0350Service;
import com.app.exterms.prgm.client.service.PrgmComBass0350ServiceAsync;
import com.app.exterms.prgm.client.service.PrgmComBass0500Service;
import com.app.exterms.prgm.client.service.PrgmComBass0500ServiceAsync;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.exterms.prgm.client.widget.PrgmCommFieldButton;
import com.app.exterms.prgm.client.widget.PrgmDeptFieldButton;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormWindows;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.utils.PrintUtils;
import com.app.smrmf.core.msfmainapp.client.utils.RegEx;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.MSFComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFDateField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTextArea;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTextField;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldWithButton;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.app.smrmf.syscom.client.util.SysComPopupUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.extjs.gxt.ui.client.data.BaseListLoader;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.data.BasePagingLoadConfig;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.LoadEvent;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoader;
import com.extjs.gxt.ui.client.data.RpcProxy;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.FormEvent;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.LoadListener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.event.TabPanelEvent;
import com.extjs.gxt.ui.client.js.JsUtil;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
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
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.Validator;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.grid.CheckColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.grid.HeaderGroupConfig;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.toolbar.PagingToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Image;

 

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/

public class Psnl0200 extends MSFPanel {   

	  //권한 설정 객체 
	  private  GWTAuthorization gwtAuthorization;
	  private  GWTExtAuth gwtExtAuth;
	  private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 
/**
* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
* 콤보박스 처리를 위한 메서드 호출을 위한  rpc 서비스 선언 시작
* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
*/
	private PrgmComBass0300ServiceAsync sysComBass0300Service = PrgmComBass0300Service.Util.getInstance();	// 공통코드 호출
	private PrgmComBass0500ServiceAsync sysComBass0500Service = PrgmComBass0500Service.Util.getInstance();	// 사업코드 호출
	private PrgmComBass0350ServiceAsync sysComBass0350Service = PrgmComBass0350Service.Util.getInstance();
	// ListStore<BaseModel> storeSchHdofcCodtnCd; //검색조건 재직구분 store

	// ListStore<BaseModel> stTypeOccuCd; //직종코드 store

	// 부서코드 호출
//	private PrgmComBass0400ServiceAsync sysComBass0400Service = PrgmComBass0400Service.Util.getInstance();

//	private ListStore<BaseModel> storeSchDept; // 검색에 부서코드
//	private ComboBox<BaseModel> cmbxNewCombobox_3;
	public FormBinding formBinding;
  private BaseModel ppRecord; //팝업에 넘길 레코드 값 
  
/**
* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
* 콤보박스 처리를 위한 메서드 호출을 위한 rpc 서비스 선언 종료 
* ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
*/  
	private VerticalPanel vp;
	private FormPanel plFrmPsnl0200;
	// private FormData formData;
	private String txtForm = "";
	private XTemplate detailTp;
	
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * 상태처리 전역변수
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
	private ActionDatabase actionDatabase;

	private HashMap<String, String> param = new HashMap<String, String>(); // 파라메터  전달용
	private static String autoLoadFlag;	//마스터 업데이트 여부
	private int totalLength;		//고용 grid 데이터 건수
//	private int iResult;
//	private int iFlag;

	// -- 검색조건 시작
	private TextField<String> searchName; 				//이름
	private TextField<String> searchResnRegnNum; 		//주민번호 
	//private ComboBox<BaseModel> cmbxNewCombobox; 		//관리부서
	private ComboBox<BaseModel> searchYearBusinCd; 		//사업명 코드
	private TextField<String> searchMangeDeptCd; 		//관리부서 수정
  private TextField<String> searchMangeDeptNm; 		//관리부서 수정 
  private TextField<String> srhCurrAffnDeptCd; 		//부서코드
  private TextField<String> srhCurrAffnDeptNm; 		//부서명 
//  private ComboBox<BaseModel> cmbxSchHdofcCodtnCd; 	//재직구분 
  private MSFMultiComboBox<ModelData> srhHdofcCodtnCd;//재직 
  
  private ListStore<BaseModel>  lsHdofcCodtnCd 	= new ListStore<BaseModel>(); 	//재직상태 
  // -- 검색조건 종료
  
  // -- 그리드 시작
  private Grid<Psnl0100DTO> psnl0100Grid; // 메인 근로자 정보 그리드
  
//	private Psnl0100View01Def psnl0100ViewDef  = new Psnl0100View01Def();   //그리드 테이블 컬럼 define  
//	private MSFGridPanel psnl0100GridViewPanel;
  // -- 그리드 종료
	
	//------------------------------------------------------- 기본사항 컴포넌트   시작
	//private ComboBox<BaseModel> deptCd; //기본사항 관리부서
	//private ComboBox<BaseModel> currAffnDeptCd; //기본사항  부서
  //private ComboBox<BaseModel> currAffnDeptCd; //기본사항  부서
  
  // -- 기본사항 시작
  private MSFTextField mangeDeptCd; 				//부서코드
  private MSFTextField mangeDeptNm; 				//부서명 
  private MSFTextField currAffnDeptCd; 			//부서코드
  private MSFTextField currAffnDeptNm; 			//부서명  
	private MSFTextField resnRegnNum; 				//주민등록번호 
  private HiddenField<String> resnRegnNumStr;
	private MSFTextField hanNm; 					//한글 이름
	private TextField<String> chinCharNm; 				//한자이름
	private MSFTextField currPaeWorkNm; 			//현근무지
//	private MSFComboBox<BaseModel> typOccuCd; 		//직종코드
	private MSFComboBox<BaseModel> emymtDivCd; 		//고용구분코드
	private	MSFDateField frstEmymtDt;  				//최초 고용일자
	private MSFDateField emymtEndDt; 				//고용 해제일자
	private MSFTextField logSvcYrNum; 				//근속년수
	private TextField<String> engNm; 					//영문이름
	private MSFTextField businNm;	 				//사업명
//	private MSFComboBox<BaseModel> tempComboBox; 	//직종세 구분
//	private MSFComboBox<BaseModel> dtilOccuInttnCd; //직종세 구분
	
	private MSFComboBox<BaseModel> hdofcCodtnCd; 	//재직 구분
	private MSFDateField currDeptAppmtDt; 			//현부서 발령일자
	private MSFTextField retryReasCtnt; 			//고용 해제 사유
	private MSFTextField tempTextField; 			//상태정보
	private Image picImg;							//사진 이미지
	private FileUploadField picFile; 				//사진이미지 파일업로드
	private MSFComboBox<BaseModel> odtyCd;			//직책구분코드
	
	private TextFieldWithButton<String> natnNm; 	//국가명
	private MSFTextField natnItem; 					//국가코드 두자리
	private Boolean picBoolFile;
	private MSFComboBox<BaseModel> repbtyBusinDivCd;//전환대상
  //  private MSFTextField memoInfo;					//기타사항
	// -- 기본사항 종료
	
	// --  버튼 시작
	private Button btnSrhCurrAffnDeptCd;		//검색조건 - 소속부서 검색버튼	 
  private Button btnSrhMangeDeptCd;			//검색조건 - 관리부서 검색버튼
	private Button btnCurrAffnDeptCd;  			//기본사항 - 소속부서 검색버튼
	private Button btnMangeDeptCd; 				//기본사항 - 관리부서 검색버튼
	private Button btnNatnCd;					//기본사항 - 국가코드 검색버튼
	// --  버튼 종료
  
  
	// --  HiddenField 시작
  // private HiddenField<String> dpobCd;
  private HiddenField<String> imgKeyCode;	//이미지 업로드를 위해 추가 
	private HiddenField<String> natnCd;	//국가코드 키
	private HiddenField<String> frmKey;
  // -- HiddenField 종료
  
	//-------------------------------------------------------- 하위 탭 시작
	private TabPanel tabsPsnl; // 하위 탭 정보
//	private TabPanel tabsPsnl2; // 하위 탭 정보
	private TabPanel tabsCtlPsnl; // 중간위치 탭추가 20171014
	
	//인적 시작
	private static MSFTextField psnl0111HusRoadNmZpcd; 		//도로명 주소 우편번호
	private static MSFTextField psnl0111HusRoadNmFndtnAddr; 	//도로명 기본주소
	private static TextField<String> psnl0111HusRoadNmDtlPatrAddr; 	//도로명 상세 주소
	private TextField<String> psnl0111BthcAddr;				//생활 근거지 주소
	private TextField<String> psnl0111HfmlyNm; 				//호주
	private ComboBox<BaseModel> psnl0111HfmlyRelaCd; //호주관계
	private MSFTextField psnl0111CellPhneNum; 			//휴대폰번호
	private TextField<String> psnl0111HusPhnNum; 			//전화번호
	private TextField<String> psnl0111EmailAddr; 			//이메일
	private MSFTextArea pernNoteCtnt; 					//비고
	private DateField styBgnnDt;						//체류시작일자
	private DateField styEndDt;						//체류종료일자
	private ComboBox<BaseModel> frgnrDivCd;			//외국인구분코드
	private TextField<String> psptNum;						//여권번호
	private TextField<String> repbtyBusinNm;					//담당업무명
	//인적 끝

	//고용 시작
	private EditorGrid<Psnl0110DTO> psnl0110Grid; //고용탭 그리드
	//private ComboBox<BaseModel> dtilOccuInttnCdCombo;   // 직종세 콤보
	private ComboBox<BaseModel> businCdCombo;
	//고용 끝
	private EditorGrid<Psnl0116DTO> psnl0116Grid;
	
	//병역 시작
	private DateField psnl0112EnrlntDt;					//입대일자
	private DateField psnl0112DsageDt;					//제대일자
	private ComboBox<BaseModel> psnl0112ServcRcgtnPridCd;//복무인정기간
	private ComboBox<BaseModel> psnl0112SrvssCd;			//역종
	private ComboBox<BaseModel> psnl0112BaggrpCd;		//군별
	private ComboBox<BaseModel> psnl0112AbotsCd;			//병과
	private ComboBox<BaseModel> psnl0112ClsCd;			//계급
	private TextField<String> psnl0112MitySilnum;				//군번
	private TextField<String> psnl0112Mos;						//mos
	private ComboBox<BaseModel> psnl0112DsageDivCd;		//제대구분
	private ComboBox<BaseModel> psnl0112ExmtnReasCd;		//미필사유
	//병역 끝
	
	//신상 시작
	private TextField<String> psnl0113Sttur;						//신장
	private TextField<String> psnl0113Wei;						//체중
	private ComboBox<BaseModel> psnl0113BldtpDivCd;		//혈액형 콤보
	private RadioGroup psnl0113PrmtsaYn;					//색맹(radio)
	private TextField<String> psnl0113TnkeeVsnLf;				//나안시력 좌
	private TextField<String> psnl0113TnkeeVsnRght;				//나인시력 우
	private TextField<String> psnl0113CorrVsnLf;					//교정시력 좌
	private TextField<String> psnl0113CorrVsnRght;				//교정시력 우
	private ComboBox<BaseModel> psnl0113RelnFrmCd;		//종교 콤보
	private TextField<String> psnl0113HbbyCtnt;					//취미
	private TextField<String> psnl0113SpityCtnt;					//특기
	private TextField<String> psnl0113HlthCodtnCtnt;				//건강상태
	private MSFComboBox<BaseModel> psnl0113DabtyDivCd;		//장애구분
	private ComboBox<BaseModel> psnl0113DabtyGrdeCd;		//장애등급
	private DateField psnl0113DabtyAjmtDt;				//장애판정일자
	private ComboBox<BaseModel> psnl0113PattVetnsDivCd;	//보훈구분
	private TextField<String> psnl0113PattVetnsNum;				//보훈번호
	private ComboBox<BaseModel> psnl0113AmomRelaDivCd;	//유공자와관계
	private CheckBoxGroup psnl0113PattVetnsYn;				//보훈여부 (checkbox)
//	private MSFComboBox<BaseModel> resnRegnSex;				//성별
//	private MSFTextField psnl0113ResnRegnYMD;				//생년월일
	private MSFComboBox<BaseModel> sxDivCd;					//성별
	private MSFTextField yoobhMnthDay;						//생년월일
	private String strYoobhMnthDay = ""; 					//생년월일 가져오는
	private RadioGroup sclcDivCd;							//음양구분
	private Radio birLun;									//음력
	private Radio birSol;									//양력
	//신상 끝
	
	// 관련근거 시작
	private Grid<Psnl0131DTO> psnl0131Grid; 				//관련근거 그리드
	// 관련근거 종료
	
	//근무상황 시작
	private EditorGrid<Psnl0133DTO> psnl0133Grid; 			//근무상황 탭 그리드
	//근무상황 끝
	
	//시찰(수행) 시작
	private Grid<Psnl0134DTO> psnl0134Grid_01; 				// 해외시찰 탭 그리드
	private Grid<Psnl0134DTO> psnl0134Grid_02; 				// 해외시찰 탭 그리드
	private HiddenField<String> acmpInspnDivCd;
	//시찰(수행) 끝
	
	//-------------------------------------------------------- 하위 탭 끝
	//List<String> arrRpsttvCd = PersonalUtil.getComboList();
	private PrgmComBass0300DTO sysComBass0300Dto; //공통코드 dto
  private Psnl0131DTO psnl0131Dto = new Psnl0131DTO();
	// -------------- store 선언 시작 --------------
	private ListStore<BaseModel> listStoreBass0400 = new ListStore<BaseModel>();
	private ListStore<BaseModel> listStoreBass0350 = new ListStore<BaseModel>();
	
	private ListStore<BaseModel> listStoreA002 = new ListStore<BaseModel>(); //PersonalUtil.setSotreComboData("A002","A0020020");
	private ListStore<BaseModel> listStoreA003 = new ListStore<BaseModel>(); //PersonalUtil.setSotreComboData("A003","");
	private ListStore<BaseModel> listStoreA006 = new ListStore<BaseModel>(); //PersonalUtil.setSotreComboData("A006","");
	private ListStore<BaseModel> listStoreA009 = new ListStore<BaseModel>(); //PersonalUtil.setSotreComboData("A009","");
	
	private ListStore<BaseModel> listStoreA010 = new ListStore<BaseModel>(); //PersonalUtil.setSotreComboData("A010","");
	private ListStore<BaseModel> listStoreA011 = new ListStore<BaseModel>(); //PersonalUtil.setSotreComboData("A011","");
	private ListStore<BaseModel> listStoreA012 = new ListStore<BaseModel>(); //PersonalUtil.setSotreComboData("A012","");
	
	private ListStore<BaseModel> listStoreA013 = new ListStore<BaseModel>(); //PersonalUtil.setSotreComboData("A013","");
	private ListStore<BaseModel> listStoreA015 = new ListStore<BaseModel>(); //PersonalUtil.setSotreComboData("A015","");
	private ListStore<BaseModel> listStoreA019 = new ListStore<BaseModel>(); //PersonalUtil.setSotreComboData("A019","");
	
	private ListStore<BaseModel> listStoreA020 = new ListStore<BaseModel>(); //PersonalUtil.setSotreComboData("A020","");
	private ListStore<BaseModel> listStoreA021 = new ListStore<BaseModel>(); //PersonalUtil.setSotreComboData("A021","");
	private ListStore<BaseModel> listStoreA022 = new ListStore<BaseModel>(); //PersonalUtil.setSotreComboData("A022","");
	private ListStore<BaseModel> listStoreA023 = new ListStore<BaseModel>(); //PersonalUtil.setSotreComboData("A023","");
	private ListStore<BaseModel> listStoreA024 = new ListStore<BaseModel>(); //PersonalUtil.setSotreComboData("A024","");
	private ListStore<BaseModel> listStoreA025 = new ListStore<BaseModel>(); //PersonalUtil.setSotreComboData("A025","");
	private ListStore<BaseModel> listStoreA026 = new ListStore<BaseModel>(); //PersonalUtil.setSotreComboData("A026","");
	private ListStore<BaseModel> listStoreA028 = new ListStore<BaseModel>(); //PersonalUtil.setSotreComboData("A043",""); //학위구분
	private ListStore<BaseModel> listStoreA029 = new ListStore<BaseModel>(); //PersonalUtil.setSotreComboData("A029","");
	
	private ListStore<BaseModel> listStoreA030 = new ListStore<BaseModel>(); //PersonalUtil.setSotreComboData("A030","");
	private ListStore<BaseModel> listStoreA031 = new ListStore<BaseModel>(); //PersonalUtil.setSotreComboData("A031",""); //학교
	private ListStore<BaseModel> listStoreA036 = new ListStore<BaseModel>(); //PersonalUtil.setSotreComboData("A036","");
	private ListStore<BaseModel> listStoreA037 = new ListStore<BaseModel>();
	
	private ListStore<BaseModel> listStoreA041 = new ListStore<BaseModel>(); //PersonalUtil.setSotreComboData("A041","");
	private ListStore<BaseModel> listStoreA042 = new ListStore<BaseModel>(); //고용유형
	private ListStore<BaseModel> listStoreA043 = new ListStore<BaseModel>(); //PersonalUtil.setSotreComboData("A043",""); //수업년수
	private ListStore<BaseModel> listStoreA044 = new ListStore<BaseModel>(); //PersonalUtil.setSotreComboData("A044","");
	private ListStore<BaseModel> listStoreA045 = new ListStore<BaseModel>(); //PersonalUtil.setSotreComboData("A045","");
	private ListStore<BaseModel> listStoreA047 = new ListStore<BaseModel>(); //PersonalUtil.setSotreComboData("A047","");
	
	//TODO 임시.. 
	private ListStore<BaseModel> listStoreA049 = new ListStore<BaseModel>(); //경력인정
	
	private ListStore<BaseModel> listStoreA050 = new ListStore<BaseModel>(); //퇴직이직사유구분 
	private ListStore<BaseModel> listStoreA051 = new ListStore<BaseModel>(); //관련근거구분코드
	private ListStore<BaseModel> listStoreY012 = new ListStore<BaseModel>(); 	// 연말정산부양관계

  private ListStore<BaseModel> listStoreYearBusin = new ListStore<BaseModel>(); //사업명 코드 
	private ListStore<BaseModel> lsBusinCd = new ListStore<BaseModel>();
	private ListStore<BaseModel> tempListStore01;
	private ListStore<BaseModel>  lsSocnsrAqtnRegVal05 = new ListStore<BaseModel>(); //외국인구분 
//private ListStore<BaseModel> listStoreBass0400All = new ListStore<BaseModel>(); // 소속부서 전체 데이타
//	private ListStore<BaseModel> listStoreBass0400All2 = new ListStore<BaseModel>(); // 소속부서 전체 데이타
//	private   ListStore<BaseModel> tempListStore;
	private ListStore<BaseModel>  lsTypOccuCd = new ListStore<BaseModel>(); //직종세
	// -------------- store 선언 종료 --------------	
	
	private List<ModelData> mDtalistHdofcCodtnCd;
	private boolean mutilCombo = false;
	
	private static  int psnl0200RowIndex = -1;
	private static  int psnl0200ColIndex = -1;
	

	private String gsSelectedTabItem = "itemPsnlStd01"; 					//탭 아이디 저장
	    
	//-------------------------------------------------------- 서비스 시작
	
	//######## PSNL0100 시작
	private Psnl0100ServiceAsync psnl0100Service = Psnl0100Service.Util.getInstance();
	
	private RpcProxy<PagingLoadResult<Psnl0100DTO>> proxyPaging = new RpcProxy<PagingLoadResult<Psnl0100DTO>>() {

		@Override
		protected void load(Object loadConfig, AsyncCallback<PagingLoadResult<Psnl0100DTO>> callback) {
			
			param.put("type", "search");
			param.put("className", "PSNL0200");//기간제
			param.put("srhName", searchName.getValue()); //성명
			param.put("srhResnRegnNum", searchResnRegnNum.getValue()); //주민번호
//			param.put("srhHdofcCodtnCd",PersonalUtil.getSelectedComboValue(cmbxSchHdofcCodtnCd) ); //재직구분
			String strHdofcCodtnCd = MSFSharedUtils.allowNulls(srhHdofcCodtnCd.getValue());
			if (MSFSharedUtils.paramNotNull(srhHdofcCodtnCd.getValue())) {
				String[] ray = strHdofcCodtnCd.substring(0, strHdofcCodtnCd.length()).split(",");
				String chkkey = "";
	    		for (int i=0; i<ray.length; i++){ 
	    			BaseModel bmData = lsHdofcCodtnCd.findModel("commCdNm", ray[i]);
	    			chkkey += bmData.get("commCd")+","; 
	    			}
	    		strHdofcCodtnCd = chkkey.substring(0,chkkey.length()-1);
			} 
			param.put("srhHdofcCodtnCd", strHdofcCodtnCd);//재직
			
			//param.put("searchMangeDeptCd", PersonalUtil.getSelectedComboValue(cmbxNewCombobox,"mangeDeptCd") ); //관리부서
//			param.put("srhMangeDeptCd", searchMangeDeptCd.getValue() );
//			//param.put("searchDeptCd", PersonalUtil.getSelectedComboValue(cmbxNewCombobox_3,"deptCd") ); //부서
//			param.put("srhDeptCd", srhCurrAffnDeptCd.getValue() ); //부서
			
			param.put("srhMangeDeptCd", searchMangeDeptCd.getValue()); //관리부서
			param.put("srhCurrAffnDeptCd", srhCurrAffnDeptCd.getValue()); //부서
			
			
			//param.put("searchTypOccuCd",PersonalUtil.getSelectedComboValue(searchTypOccuCd)); //직종
			param.put("srhBusinCd" , PersonalUtil.getSelectedComboValue(searchYearBusinCd, "businCd"));

			psnl0100Service.selectPsnl0100Paging((PagingLoadConfig) loadConfig,	param, callback);
			param = new HashMap<String, String>();
		}
	};
	private PagingLoader<PagingLoadResult<ModelData>> loaderPaging = new BasePagingLoader<PagingLoadResult<ModelData>>(	proxyPaging);
	private ListStore<Psnl0100DTO> storePaging = new ListStore<Psnl0100DTO>(loaderPaging);
	//######## PSNL0100 끝
	
	//######## PSNL0111 시작
	private List<HashMap<String, String>> psnl0111List = new ArrayList<HashMap<String,String>>();
	
	private Psnl0111ServiceAsync psnl0111Service = Psnl0111Service.Util.getInstance();
	private RpcProxy<List<HashMap<String, String>>> psnl0111Proxy = new RpcProxy<List<HashMap<String,String>>>() {
		
		@Override
		protected void load(Object loadConfig, AsyncCallback<List<HashMap<String, String>>> callBack) {
			
			psnl0111List = new ArrayList<HashMap<String,String>>();
			
			param = new HashMap<String, String>();
			param.put("dpobCd", psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
			param.put("systemkey", psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
			param.put("windowNm", "PSNL0200");
			
			psnl0111Service.selectPsnl0111(param, new AsyncCallback<List<HashMap<String,String>>>() {
				@Override
				public void onSuccess(List<HashMap<String, String>> result) {
					
					if(result.size() > 0){
						psnl0111HusRoadNmZpcd.setValue(result.get(0).get("HUS_ROAD_NM_ZPCD")); //도로명 주소 우편번호
						psnl0111HusRoadNmZpcd.fireEvent(Events.Add);
						psnl0111HusRoadNmFndtnAddr.setValue(result.get(0).get("HUS_ROAD_NM_FNDTN_ADDR")); // 도로명 기본주소
						psnl0111HusRoadNmDtlPatrAddr.setValue(result.get(0).get("HUS_ROAD_NM_DTL_PATR_ADDR")); //도로명 상세 주소
						psnl0111BthcAddr.setValue(result.get(0).get("HUS_FNDTN_ADDR"));//생활 근거지 주소 BTHC_ADDR 
						psnl0111HfmlyNm.setValue(result.get(0).get("HFMLY_NM")); //호주
						PersonalUtil.setSelectedComboValue(psnl0111HfmlyRelaCd, result.get(0).get("HFMLY_RELA_CD"),"commCd");//호주와의 관계
						psnl0111CellPhneNum.setValue(result.get(0).get("CELL_PHNE_NUM")); //휴대폰번호
						psnl0111HusPhnNum.setValue(result.get(0).get("HUS_PHN_NUM")); //전화번호
						psnl0111EmailAddr.setValue(result.get(0).get("EMAIL_ADDR")); //이메일
						pernNoteCtnt.setValue(result.get(0).get("PERN_NOTE_CTNT"));	//비고
						styBgnnDt.setValue(PersonalUtil.getConvertStringToDate(result.get(0).get("STY_BGNN_DT"), "yyyyMMdd"));	//체류시작일자
						styEndDt.setValue(PersonalUtil.getConvertStringToDate(result.get(0).get("STY_END_DT"), "yyyyMMdd"));	//체류종료일자
						PersonalUtil.setSelectedComboValue(frgnrDivCd, result.get(0).get("FRGNR_DIV_CD"),"commCd");	// 외국인구분
						psptNum.setValue(result.get(0).get("PSPT_NUM"));//여권번호
					}else{
						resetPsnl0111Form();
					}
				}
				
				@Override
				public void onFailure(Throwable caught) {
					
				}
			});
			param = new HashMap<String, String>();
		}
	};
	
	private BaseListLoader<BaseListLoadResult<ModelData>> psnl0111Loader = new BaseListLoader<BaseListLoadResult<ModelData>>(psnl0111Proxy);
	
	//######## PSNL0111 끝  
	
	//######## PSNL0110 시작 ( 고 용 )
	private Psnl0110ServiceAsync psnl0110Service = Psnl0110Service.Util.getInstance();

	private RpcProxy<BaseListLoadResult<Psnl0110DTO>> psnl0110Proxy = new RpcProxy<BaseListLoadResult<Psnl0110DTO>>() {

		@Override
		protected void load(Object loadConfig, AsyncCallback<BaseListLoadResult<Psnl0110DTO>> callback) {
			
			param.put("systemkey", psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
			param.put("dpobCd", psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
			param.put("emymtDivCd", psnl0100Grid.getSelectionModel().getSelectedItem().getEmymtDivCd());
			
			//20210520_양평 근무시간 조회시 적용
			psnl0110Service.selectPsnl0110((BaseListLoadConfig) loadConfig,	param, callback);
			
			param = new HashMap<String, String>();
		}
	};
	
	private BaseListLoader<BaseListLoadResult<ModelData>> psnl0110Loader = new BaseListLoader<BaseListLoadResult<ModelData>>(psnl0110Proxy);
	//TODO 리스너추가
	
	
	private ListStore<Psnl0110DTO> psnl0110Store = new ListStore<Psnl0110DTO>(psnl0110Loader);
	
	//######## PSNL0110 끝
	
	
	//######## psnl0112, psnl0113
	
	private Psnl0112ServiceAsync psnl0112Service = Psnl0112Service.Util.getInstance();
	private Psnl0113ServiceAsync psnl0113Service = Psnl0113Service.Util.getInstance();
	
	
	
	private Psnl0114ServiceAsync psnl0114Service = Psnl0114Service.Util.getInstance(); //단체
	private RpcProxy<BaseListLoadResult<Psnl0114DTO>> psnl0114Proxy = new RpcProxy<BaseListLoadResult<Psnl0114DTO>>() {

		@Override
		protected void load(Object loadConfig, AsyncCallback<BaseListLoadResult<Psnl0114DTO>> callback) {
			
			param.put("systemkey", psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
			param.put("dpobCd", psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
			
			psnl0114Service.selectPsnl0114((BaseListLoadConfig) loadConfig,	param, callback);
			
			param = new HashMap<String, String>();
		}
	};
	private BaseListLoader<BaseListLoadResult<ModelData>> psnl0114Loader = new BaseListLoader<BaseListLoadResult<ModelData>>(psnl0114Proxy);
	private ListStore<Psnl0114DTO> psnl0114Store = new ListStore<Psnl0114DTO>(psnl0114Loader);
	
	private Psnl0115ServiceAsync psnl0115Service = Psnl0115Service.Util.getInstance(); //가족
	private RpcProxy<BaseListLoadResult<Psnl0115DTO>> psnl0115Proxy = new RpcProxy<BaseListLoadResult<Psnl0115DTO>>() {

		@Override
		protected void load(Object loadConfig, AsyncCallback<BaseListLoadResult<Psnl0115DTO>> callback) {
			
			param.put("systemkey", psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
			param.put("dpobCd", psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
			
			psnl0115Service.selectPsnl0115((BaseListLoadConfig) loadConfig,	param, callback);
			
			param = new HashMap<String, String>();
		}
	};
	private BaseListLoader<BaseListLoadResult<ModelData>> psnl0115Loader = new BaseListLoader<BaseListLoadResult<ModelData>>(psnl0115Proxy);
	private ListStore<Psnl0115DTO> psnl0115Store = new ListStore<Psnl0115DTO>(psnl0115Loader);
	
	private Psnl0116ServiceAsync psnl0116Service = Psnl0116Service.Util.getInstance(); //학력
	private RpcProxy<BaseListLoadResult<Psnl0116DTO>> psnl0116Proxy = new RpcProxy<BaseListLoadResult<Psnl0116DTO>>() {

		@Override
		protected void load(Object loadConfig, AsyncCallback<BaseListLoadResult<Psnl0116DTO>> callback) {
			
			param.put("systemkey", psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
			param.put("dpobCd", psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
			
			psnl0116Service.selectPsnl0116((BaseListLoadConfig) loadConfig,	param, callback);
			
			param = new HashMap<String, String>();
		}
	};
	private BaseListLoader<BaseListLoadResult<ModelData>> psnl0116Loader = new BaseListLoader<BaseListLoadResult<ModelData>>(psnl0116Proxy);
	private ListStore<Psnl0116DTO> psnl0116Store = new ListStore<Psnl0116DTO>(psnl0116Loader);
	
	/*
	private Psnl0117ServiceAsync psnl0117Service = Psnl0117Service.Util.getInstance(); //전력
	private RpcProxy<BaseListLoadResult<Psnl0117DTO>> psnl0117Proxy = new RpcProxy<BaseListLoadResult<Psnl0117DTO>>() {

		@Override
		protected void load(Object loadConfig,
				AsyncCallback<BaseListLoadResult<Psnl0117DTO>> callback) {
			
			
			param.put("systemkey", psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
			param.put("dpobCd", psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
			
			psnl0117Service.selectPsnl0117((BaseListLoadConfig) loadConfig,	param, callback);
			
			param = new HashMap<String, String>();
		}
	};
	private BaseListLoader<BaseListLoadResult<ModelData>> psnl0117Loader = new BaseListLoader<BaseListLoadResult<ModelData>>(psnl0117Proxy);
	private ListStore<Psnl0117DTO> psnl0117Store = new ListStore<Psnl0117DTO>(psnl0117Loader);
	*/
	
	private Psnl0118ServiceAsync psnl0118Service = Psnl0118Service.Util.getInstance(); //자격
	private RpcProxy<BaseListLoadResult<Psnl0118DTO>> psnl0118Proxy = new RpcProxy<BaseListLoadResult<Psnl0118DTO>>() {

		@Override
		protected void load(Object loadConfig, AsyncCallback<BaseListLoadResult<Psnl0118DTO>> callback) {
			
			param.put("systemkey", psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
			param.put("dpobCd", psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
			
			psnl0118Service.selectPsnl0118((BaseListLoadConfig) loadConfig,	param, callback);
			
			param = new HashMap<String, String>();
		}
	};
	private BaseListLoader<BaseListLoadResult<ModelData>> psnl0118Loader = new BaseListLoader<BaseListLoadResult<ModelData>>(psnl0118Proxy);
	private ListStore<Psnl0118DTO> psnl0118Store = new ListStore<Psnl0118DTO>(psnl0118Loader);
	
	private Psnl0119ServiceAsync psnl0119Service = Psnl0119Service.Util.getInstance(); //경력
	private RpcProxy<BaseListLoadResult<Psnl0119DTO>> psnl0119Proxy = new RpcProxy<BaseListLoadResult<Psnl0119DTO>>() {

		@Override
		protected void load(Object loadConfig, AsyncCallback<BaseListLoadResult<Psnl0119DTO>> callback) {
			
			param.put("systemkey", psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
			param.put("dpobCd", psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
			
			psnl0119Service.selectPsnl0119((BaseListLoadConfig) loadConfig,	param, callback);
			
			param = new HashMap<String, String>();
		}
	};
	private BaseListLoader<BaseListLoadResult<ModelData>> psnl0119Loader = new BaseListLoader<BaseListLoadResult<ModelData>>(psnl0119Proxy);
	private ListStore<Psnl0119DTO> psnl0119Store = new ListStore<Psnl0119DTO>(psnl0119Loader);
	
	private Psnl0120ServiceAsync psnl0120Service = Psnl0120Service.Util.getInstance(); //교육
	private RpcProxy<BaseListLoadResult<Psnl0120DTO>> psnl0120Proxy = new RpcProxy<BaseListLoadResult<Psnl0120DTO>>() {

		@Override
		protected void load(Object loadConfig, AsyncCallback<BaseListLoadResult<Psnl0120DTO>> callback) {
			
			param.put("systemkey", psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
			param.put("dpobCd", psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
			
			psnl0120Service.selectPsnl0120((BaseListLoadConfig) loadConfig,	param, callback);
			
			param = new HashMap<String, String>();
		}
	};
	private BaseListLoader<BaseListLoadResult<ModelData>> psnl0120Loader = new BaseListLoader<BaseListLoadResult<ModelData>>(psnl0120Proxy);
	private ListStore<Psnl0120DTO> psnl0120Store = new ListStore<Psnl0120DTO>(psnl0120Loader);
	
	private Psnl0121ServiceAsync psnl0121Service = Psnl0121Service.Util.getInstance(); //포상
	private RpcProxy<BaseListLoadResult<Psnl0121DTO>> psnl0121Proxy = new RpcProxy<BaseListLoadResult<Psnl0121DTO>>() {

		@Override
		protected void load(Object loadConfig, AsyncCallback<BaseListLoadResult<Psnl0121DTO>> callback) {
			
			param.put("systemkey", psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
			param.put("dpobCd", psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
			
			psnl0121Service.selectPsnl0121((BaseListLoadConfig) loadConfig,	param, callback);
			
			param = new HashMap<String, String>();
		}
	};
	private BaseListLoader<BaseListLoadResult<ModelData>> psnl0121Loader = new BaseListLoader<BaseListLoadResult<ModelData>>(psnl0121Proxy);
	private ListStore<Psnl0121DTO> psnl0121Store = new ListStore<Psnl0121DTO>(psnl0121Loader);
	
	private Psnl0122ServiceAsync psnl0122Service = Psnl0122Service.Util.getInstance(); //징계
	private RpcProxy<BaseListLoadResult<Psnl0122DTO>> psnl0122Proxy = new RpcProxy<BaseListLoadResult<Psnl0122DTO>>() {

		@Override
		protected void load(Object loadConfig, AsyncCallback<BaseListLoadResult<Psnl0122DTO>> callback) {
			
			
			param.put("systemkey", psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
			param.put("dpobCd", psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
			
			psnl0122Service.selectPsnl0122((BaseListLoadConfig) loadConfig,	param, callback);
			
			param = new HashMap<String, String>();
		}
	};
	private BaseListLoader<BaseListLoadResult<ModelData>> psnl0122Loader = new BaseListLoader<BaseListLoadResult<ModelData>>(psnl0122Proxy);
	private ListStore<Psnl0122DTO> psnl0122Store = new ListStore<Psnl0122DTO>(psnl0122Loader);
	
	private Psnl0123ServiceAsync psnl0123Service = Psnl0123Service.Util.getInstance(); //휴직관리
	private RpcProxy<BaseListLoadResult<Psnl0123DTO>> psnl0123Proxy = new RpcProxy<BaseListLoadResult<Psnl0123DTO>>() {

		@Override
		protected void load(Object loadConfig, AsyncCallback<BaseListLoadResult<Psnl0123DTO>> callback) {
			
			param.put("systemkey", psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
			param.put("dpobCd", psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
			
			psnl0123Service.selectPsnl0123((BaseListLoadConfig) loadConfig,	param, callback);
			
			param = new HashMap<String, String>();
		}
	};
	private BaseListLoader<BaseListLoadResult<ModelData>> psnl0123Loader = new BaseListLoader<BaseListLoadResult<ModelData>>(psnl0123Proxy);
	private ListStore<Psnl0123DTO> psnl0123Store = new ListStore<Psnl0123DTO>(psnl0123Loader);
	
	private Psnl0127ServiceAsync psnl0127Service = Psnl0127Service.Util.getInstance(); //사회보험
	private RpcProxy<BaseListLoadResult<Psnl0127DTO>> psnl0127Proxy = new RpcProxy<BaseListLoadResult<Psnl0127DTO>>() {

		@Override
		protected void load(Object loadConfig, AsyncCallback<BaseListLoadResult<Psnl0127DTO>> callback) {

			param.put("systemkey", psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
			param.put("dpobCd", psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
			
			psnl0127Service.selectPsnl0127((BaseListLoadConfig) loadConfig,	param, callback);
			
			param = new HashMap<String, String>();
		}
	};
	private BaseListLoader<BaseListLoadResult<ModelData>> psnl0127Loader = new BaseListLoader<BaseListLoadResult<ModelData>>(psnl0127Proxy);
	private ListStore<Psnl0127DTO> psnl0127Store = new ListStore<Psnl0127DTO>(psnl0127Loader);
	
	
	//######## PSNL0131 시작 ( 관련근거 )
	private PsnlP010001ServiceAsync psnl0131Service = PsnlP010001Service.Util.getInstance();

	private RpcProxy<BaseListLoadResult<Psnl0131DTO>> psnl0131Proxy = new RpcProxy<BaseListLoadResult<Psnl0131DTO>>() {

		@Override
		protected void load(Object loadConfig, AsyncCallback<BaseListLoadResult<Psnl0131DTO>> callback) {
			// TODO Auto-generated method stub
			
			psnl0131Dto = new Psnl0131DTO();
			
			psnl0131Dto.setDpobCd(psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
			psnl0131Dto.setSystemkey(psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
			
			psnl0131Service.selectPsnl0131((BaseListLoadConfig) loadConfig,	psnl0131Dto, callback);
			
		}
	};

	private BaseListLoader<BaseListLoadResult<ModelData>> psnl0131Loader = new BaseListLoader<BaseListLoadResult<ModelData>>(psnl0131Proxy);
	private ListStore<Psnl0131DTO> psnl0131Store = new ListStore<Psnl0131DTO>(psnl0131Loader);
	//######## PSNL0131 끝
	
	
	//######## PSNL0133 시작 ( 근무상황 )
	private Psnl0133ServiceAsync psnl0133Service = Psnl0133Service.Util.getInstance();

	private RpcProxy<BaseListLoadResult<Psnl0133DTO>> psnl0133Proxy = new RpcProxy<BaseListLoadResult<Psnl0133DTO>>() {

		@Override
		protected void load(Object loadConfig, AsyncCallback<BaseListLoadResult<Psnl0133DTO>> callback) {
			// TODO Auto-generated method stub
			
			param.put("systemkey", psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
			param.put("dpobCd", psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
			psnl0133Service.selectPsnl0133((BaseListLoadConfig) loadConfig,	param, callback);
			param = new HashMap<String, String>();

		}
	};

	private BaseListLoader<BaseListLoadResult<ModelData>> psnl0133Loader = new BaseListLoader<BaseListLoadResult<ModelData>>(psnl0133Proxy);
	private ListStore<Psnl0133DTO> psnl0133Store = new ListStore<Psnl0133DTO>(psnl0133Loader);
	//######## PSNL0133 끝
	
	
	
	//######## PSNL0134 시작 ( 시찰(수행) )
	private Psnl0134ServiceAsync psnl0134Service = Psnl0134Service.Util.getInstance();

	private RpcProxy<BaseListLoadResult<Psnl0134DTO>> psnl0134Proxy = new RpcProxy<BaseListLoadResult<Psnl0134DTO>>() {

		@Override
		protected void load(Object loadConfig, AsyncCallback<BaseListLoadResult<Psnl0134DTO>> callback) {
			// TODO Auto-generated method stub
			
			param.put("systemkey", psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
			param.put("dpobCd", psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
			param.put("acmpInspnDivCd", acmpInspnDivCd.getValue());
			psnl0134Service.selectPsnl0134((BaseListLoadConfig) loadConfig,	param, callback);
			param = new HashMap<String, String>();

		}
	};

	private BaseListLoader<BaseListLoadResult<ModelData>> psnl0134Loader = new BaseListLoader<BaseListLoadResult<ModelData>>(psnl0134Proxy);
	private ListStore<Psnl0134DTO> psnl0134Store = new ListStore<Psnl0134DTO>(psnl0134Loader);
	//######## PSNL0134 끝
	
	  /**
	   *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	   * 	권한설정 관련 함수 및 선언 시작 (권한 적용필요시 추가해야함.)
	   *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	   **/
	   // 검색 폼 바인딩 처리 함수 
	 // private AuthAction authAction;  
	//  private Boolean boolChkAuth;  
	//  private static MessageBox authBox = MessageBox.wait("화면로딩", "설정 초기화 작업 진행 중입니다....", "설정 작업 진행 중..."); 
	  /**
	   * 권한설정 처리 체크 
	   * AuthAction 
	   */
	  private void checkPsnl0200Auth( String authAction, ListStore<BaseModel> bm) {   
  	   //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
		 
		  //2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
		   if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {
		   
			   //----------------------------------------------------
			   if (!maskTracker) { unmask(); }  
			   authExecEnabled() ;
			 
               
		   }
	  }
	  
		 private void authExecEnabled() { 
			   //------------------
//			  Field<?>[] fldArrField = {searchMangeDeptCd,searchMangeDeptNm,srhCurrAffnDeptCd,srhCurrAffnDeptNm};
			 Field<?>[] fldArrField = {srhCurrAffnDeptCd,srhCurrAffnDeptNm};
			   
			   gwtAuthorization.formAuthFieldConfig(fldArrField);
			   
			   gwtExtAuth.setCheckMapDef(null); //로딩완료 후 초기화 
             //MSFMainApp.unmaskMainPage();
            /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
             * 권한설정을 위한 콤보처리를 위한 메서드 시작 
             * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
             ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//              String[] strArrDeptCd = {"searchMangeDeptCd","searchMangeDeptNm","srhCurrAffnDeptCd","srhCurrAffnDeptNm"};
//              gwtAuthorization.formAuthPopConfig(plFrmPsnl0200, "","",strArrDeptCd,"searchTypOccuCd","");
//              gwtAuthorization.formAuthBtnConfig(btnSrhMangeDeptCd);
//              gwtAuthorization.formAuthBtnConfig(btnSrhCurrAffnDeptCd); 
			   	//TODO 권한 소속부서만
//			   	String[] strArrDeptCd = {"srhCurrAffnDeptCd","srhCurrAffnDeptNm"};
            /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
             * 권한설정을 위한 콤보처리를 위한 메서드 종료
             ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
			 
			 }
			 
	  
//		  private AuthAction authAction;
//		  private int checkCntDef = 1;   //체크 값 갯수 
//		//  private static MessageBox authBox = MessageBox.wait("화면로딩", "설정 초기화 작업 진행 중입니다....", "설정 작업 진행 중..."); 
//		  /**
//		   * 권한설정 처리 체크 
//		   * AuthAction 
//		   */
//		  private void checkPsnl0200Auth( AuthAction authAction, ListStore<BaseModel> bm, int authChk) {   
//	    	   //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
//			 
//			   if (GWTExtAuth.checkExtAuth(authAction, bm, authChk)) {
//			   
//		           
//	                
//	                //----------------------------------------------------
//	                unmask(); 
//	                //MSFMainApp.unmaskMainPage();
//	                 
//			   }
//		  }

	   final Timer tmMask = new Timer()
	     {
	           public void run()
	           {
	              // if (maskTracker)
	              // { 
	        	   if (listStoreA003.getCount() > 0 ) {
	        		   
		           	    cancel();
		               	unmask(); 
		               	authExecEnabled() ;
		                maskTracker  = true;
		        	
		        	   } else {
		        		   tmMask.scheduleRepeating(2000);
		        	   }
	              // }
	           }
	     }; 
	     
		  private void initLoad() { 
			// 권한처리 부분 추가 전역이 아니 각 화면별로 객체 생성시 처리를 위해 변경함.
			     gwtAuthorization = GWTAuthorization.getInstance();
			     gwtExtAuth = GWTExtAuth.getInstance();
			     
			     HashMap<String,Boolean> authMapDef = new HashMap<String,Boolean>(); 
			     
			     authMapDef.put("cmbxSchHdofcCodtnCd",Boolean.FALSE); 
				 
			     gwtExtAuth.setCheckMapDef(authMapDef);
		        
		        if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
		        	  //권한 검색조건처리를 위해 추가된 부분 
					  mask("[화면로딩] 초기화 진행 중!");
	        	}
		        tmMask.scheduleRepeating(5000);
		  }  
	  /**
	   *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	   * 	권한설정 관련 함수 및 선언 종료 (권한 적용필요시 추가해야함.)
	   *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	   **/	
	  
		  
	//------------------------------------------------------- 서비스 끝
	
	/*
	@Override
	protected void onRender(Element parent, int index) {
		super.onRender(parent, index);

		detailTp = XTemplate.create(getDetailTemplate());
		// formData = new FormData("-650");
		vp = new VerticalPanel();
		vp.setSpacing(5);
		createPsnl0100Form(); // 화면 기본정보를 설정
		createSearchForm(); // 검색필드를 적용
		createStandardForm(); // 기본정보필드
		createTabForm(); // 탭구성
		add(vp);
		vp.setSize("1010px", "700px");
	}
	*/
	
	
	

/**************************************************************/
/** 우편번호 로직 추가    												*/
/**************************************************************/		  
public static native void closeFunction() /*-{
		   $wnd.closeFunction =
		      $entry(@com.app.exterms.personal.client.form.Psnl0200::onCloseGwtFunction(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;));
}-*/;
public static void onCloseGwtFunction(String zpcd,String fnDtnAddr,String dtlPatrAddr )
{ 
	  // your gwt code tobe executed 
	// Window.alert(postId);
	 psnl0111HusRoadNmZpcd.setValue(MSFSharedUtils.allowNulls(zpcd));
	// psnl0111HusRoadNmZpcd.fireEvent(Events.Add);
	 psnl0111HusRoadNmFndtnAddr.setValue(MSFSharedUtils.allowNulls(fnDtnAddr)); // 앞주소
	 psnl0111HusRoadNmDtlPatrAddr.setValue(MSFSharedUtils.allowNulls(dtlPatrAddr)); // 뒷주소
	    
}
/**************************************************************/
/** 우편번호 로직 추가    												*/
/**************************************************************/
	
	public ContentPanel getViewPanel(){
		if(panel == null){
			GWTUtils.popupDoroWndClose(); 
			closeFunction();
			initLoad();
			//관리부서 코드 가져오기
			//listStoreBass0400 = PrgmComComboUtils.getMangDeptBass0400ComboData(new PrgmComBass0400DTO());
			//listStoreBass0350 = PrgmComComboUtils.getSingleBass0350ComboData(new PrgmComBass0350DTO());
			
//			sysComBass0400Service.getPrgmComDeptBass0400List(new PrgmComBass0400DTO(),new AsyncCallback<List<BaseModel>>() {
//				@Override
//				public void onSuccess(List<BaseModel> result) {
//					listStoreBass0400All.add(result);
//					listStoreBass0400All2.add(result);
//				}
//				@Override
//				public void onFailure(Throwable caught) {
//					caught.printStackTrace();
//				}
//			});
			
			//사업명코드 가져오기
//			psnl0100Service.getBusinList(new PrgmComBass0500DTO(), new AsyncCallback<List<BaseModel>>() {
//				
//				@Override
//				public void onSuccess(List<BaseModel> result) {
//					
//					listStoreYearBusin.add(result);
//				}
//				
//				@Override
//				public void onFailure(Throwable caught) {
//					
//					MessageBox.alert("", "사업명코드 에러!", null);
//				}
//			});
		    
		    //--------------------사업 불러 오는 함수 -------------------------------------------------
		    listStoreYearBusin = PrgmComComboUtils.getDeptWithBass0500ComboData(new PrgmComBass0500DTO());
         //--------------------사업 불러 오는 함수 -------------------------------------------------
//		    new PrgmComBass0500DTO().addStoreListener( new StoreListener<BaseModel>() {   
//            public void handleEvent(StoreEvent<BaseModel> be) {  
//                businCdCombo.setStore(tempListStore); 
//            }
//         });
			
			//공통 코드 가져오기
			sysComBass0300Service.getPrgmComMultiComboBass0300List(PersonalUtil.getComboList(), new AsyncCallback<HashMap<String,List<BaseModel>>>() {
				@Override
				public void onSuccess(HashMap<String, List<BaseModel>> result) {
					if(result != null && result.size() > 0){
						 
						listStoreA003.add(result.get("A003"));
						listStoreA006.add(result.get("A006"));						
						listStoreA009.add(result.get("A009"));
						
						listStoreA010.add(result.get("A010"));
						listStoreA011.add(result.get("A011"));
						listStoreA012.add(result.get("A012"));
						
						listStoreA013.add(result.get("A013"));
						listStoreA015.add(result.get("A015"));
						listStoreA019.add(result.get("A019")); //관계
						
						listStoreA020.add(result.get("A020")); 
						listStoreA021.add(result.get("A021"));
						listStoreA022.add(result.get("A022"));
						listStoreA023.add(result.get("A023")); //군별
						listStoreA024.add(result.get("A024"));
						listStoreA025.add(result.get("A025"));
						listStoreA026.add(result.get("A026")); //학교구분
						listStoreA028.add(result.get("A028"));
						listStoreA029.add(result.get("A029"));
						
						listStoreA030.add(result.get("A030"));
						listStoreA036.add(result.get("A036")); //장애등급
						
						listStoreA041.add(result.get("A041")); //직종세
//						listStoreA042.add(result.get("A042"));
						listStoreA043.add(result.get("A043")); //수업년수
						listStoreA044.add(result.get("A044"));
						listStoreA045.add(result.get("A045"));
						listStoreA047.add(result.get("A047")); //보훈구분
						listStoreA049.add(result.get("A049")); //보훈구분
						
						listStoreA037.add(result.get("A037"));
//						if(listStoreA003.getCount()>0){
////							cmbxSchHdofcCodtnCd.setValue(listStoreA003.getAt(0));
//							srhHdofcCodtnCd.getStore().getAt(0); 
//						}
//						
//						 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
//	                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//	                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
//	                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//	                	checkPsnl0200Auth("cmbxSchHdofcCodtnCd", listStoreA003); 
					}
				}
				
				@Override
				public void onFailure(Throwable caught) {
					 unmask(); 
					MessageBox.alert("", "공통코드 에러!", null);
				}
			});
			
			// -------------------------------- 공통코드 가져옴 --------------------------------
			sysComBass0300Dto = new PrgmComBass0300DTO();
			sysComBass0300Dto.setRpsttvCd("A042");
			sysComBass0300Dto.setMangeItem01("Y");
			listStoreA042 = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto); // 고용유형
			
			sysComBass0300Dto = new PrgmComBass0300DTO();
			sysComBass0300Dto.setRpsttvCd("Y012");
			listStoreY012 = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);	// 가족관계
			
			sysComBass0300Dto = new PrgmComBass0300DTO();
	    	sysComBass0300Dto.setRpsttvCd("A050");
	    	listStoreA050= PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto); 		//퇴직이직사유구분
	    	
	    	sysComBass0300Dto.setRpsttvCd("A051");
	    	listStoreA051= PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto); 		//관련근거구분코드
			// -------------------------------- 공통코드 가져옴 --------------------------------
				 
//	     	고용구분 이전자료를 가져오기 위해 처리 함. listStoreA002.add(result.get("A002")); 
	    	sysComBass0300Dto.setRpsttvCd("A002");
	    	sysComBass0300Dto.setCommUseYn("A");  //조건을 넣으면 사용여부 구분처리를 한 후 보여줌 
	    	listStoreA002= PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto); 		// 고용구분
	    	sysComBass0300Dto.setCommUseYn("");  //조건을 넣으면 사용여부 구분처리를 한 후 보여줌 
	    	
			detailTp = XTemplate.create(getDetailTemplate());
			
			vp = new VerticalPanel();
			
			acmpInspnDivCd = new HiddenField<String>();
			
			createPsnl0200Form(); 		// 화면 기본정보를 설정
			createSearchForm(); 		// 검색필드를 적용
			createStandardForm(); 		// 기본정보필드
			createTabForm(); 			// 탭구성
			vp.setSize("1010px", "700px");  
			 
        
         /**
          * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
          * 폼 바인딩 및 공통 콤보 선언부 시작
          * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
          */
          //폼데이터를 바인딩 
          formBinding = new FormBinding(this.plFrmPsnl0200, false); 
          //bindMsfComBass0400(formBinding.getModel());    //부서코드
          //bindMsfComBass0500(formBinding.getModel());    //사업코드 
          //bindMsfComBass0300(formBinding.getModel(),"A003");  //재직상태구분코드
          /**
           * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
           * 폼 바인딩 및 공통 콤보 선언부 종료
           * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
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
	 * @wbp.parser.constructor
	 */
	public Psnl0200() {
		setSize("1010px", "700px");
	}

	public Psnl0200(String txtForm) {
		this.txtForm = txtForm;
	}

	private void createPsnl0200Form() {
	

		plFrmPsnl0200 = new FormPanel();
		plFrmPsnl0200.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 인사기본(기간제근로자)"));
		plFrmPsnl0200.setIcon(MSFMainApp.ICONS.text());
//		plFrmPsnl0200.setBodyStyleName("pad-text");
		plFrmPsnl0200.setPadding(2);
		plFrmPsnl0200.setFrame(true); 
		
		
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage("인사기본(기간제근로자)","PSNL0200");
				}
			});
		plFrmPsnl0200.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmPsnl0200.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/

		sysComBass0300Dto = new PrgmComBass0300DTO();
		// 콤보박스 ----------------------------------------------------------------------------------------
		sysComBass0300Dto.setRpsttvCd("I004");	//외국인구분 
		lsSocnsrAqtnRegVal05 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);	
		// ----------------------------------------------------------------------------------------------
		
		
		//---------------------멀티콤보박스 닫기 -------------------------------------------------
		plFrmPsnl0200.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
          @Override
          public void handleEvent(ComponentEvent ce) { 
          	if (mutilCombo) {
          		if ( srhHdofcCodtnCd.getCheckBoxListHolder().isVisible()) {
          			///재직
          			srhHdofcCodtnCd.showClose(ce);
          			mutilCombo = false;
          		}   
          	}
          } 
      });
      //---------------------멀티콤보박스 닫기 -------------------------------------------------

		imgKeyCode = new HiddenField<String>();
		imgKeyCode.setName("imgKeyCode");
      plFrmPsnl0200.add(imgKeyCode);
//      dpobCd  = new HiddenField<String>();
//      dpobCd.setName("dpobCd");
//      plFrmPsnl0200.add(dpobCd);
      frmKey  = new HiddenField<String>();
      frmKey.setName("frmKey");
      plFrmPsnl0200.add(frmKey);
      
      resnRegnNumStr  = new HiddenField<String>();
      resnRegnNumStr.setName("resnRegnNumStr");
      plFrmPsnl0200.add(resnRegnNumStr);
      
      
		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		layoutContainer_1.setLayout(new FlowLayout());

		ButtonBar buttonBar_1 = new ButtonBar();
		
	
		Button btnNewButton_2 = new Button("신규고용업로드");
		
		btnNewButton_2.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				
				PsnlP020001 psnlP020002Form = new PsnlP020001(ActionDatabase.READ, getThis());
				MSFFormWindows msFwPsnlP020002 = new MSFFormWindows("고용일괄등록",psnlP020002Form, "닫기", "920px", "710px", true);
				msFwPsnlP020002.show();
				psnlP020002Form.setMSFFormWindows(msFwPsnlP020002);
				
//				MessageBox.info("알림", "준비중입니다.", null);
//	      		return;
				
			}
		});
		//btnNewButton_2.setIcon(MSFMainApp.ICONS.accordion());
		buttonBar_1.add(btnNewButton_2);
		layoutContainer_1.add(buttonBar_1);
		layoutContainer.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_1.setBorders(false);

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new FlowLayout());

		ButtonBar buttonBar = new ButtonBar();
		layoutContainer_2.add(buttonBar);
		buttonBar.setAlignment(HorizontalAlignment.RIGHT);
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
		
		Button topBtn = new Button("초기화");
		topBtn.setIcon(MSFMainApp.ICONS.new16());
		buttonBar.add(topBtn); 
		
		
		topBtn.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				//storePaging.insert(new Psnl0100DTO(), 0);
				
				//검색조건 초기화
				resetSearchForm();
				
				//그리드 선택 없애기
				psnl0100Grid.getSelectionModel().deselectAll();
				
				//기본사항 폼 초기화
				resetMainForm();
				
				//조회시 탭부분 초기화
				tabsPsnl.setSelection(tabsPsnl.getItem(0));
				
				//인적탭 초기화
				resetPsnl0111Form();
			}
		});
		
		topBtn = new Button("신규");
		topBtn.setIcon(MSFMainApp.ICONS.new16());
		buttonBar.add(topBtn);
		
		topBtn.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				PsnlP010002 psnlP010002Form = new PsnlP010002(ActionDatabase.INSERT, getThis());
				MSFFormWindows msFwPsnlP020002 = new MSFFormWindows("인사신규등록", psnlP010002Form, "닫기", "800px", "820px", true);
				msFwPsnlP020002.show();
				psnlP010002Form.setScrollMode(Scroll.AUTO);
				psnlP010002Form.setMSFFormWindows(msFwPsnlP020002);
				
				
				BaseModel bmRecord = new BaseModel();

				bmRecord.set("formId", "PSNL0200");
				
				setPPRecord(bmRecord); 
				psnlP010002Form.bind(ppRecord);
				
				
//				//그리드 선택 없애기
//				psnl0100Grid.getSelectionModel().deselectAll();
//				//기본사항 폼 초기화
//				resetMainForm();
//				
////				dtilOccuInttnCd.setEnabled(true);
//				
//				//조회시 탭부분 초기화
//				tabsPsnl.setSelection(tabsPsnl.getItem(0));
//				
//				resetPsnl0111Form();
			}
		});
		
		//TODO 
		topBtn = new Button("저장");
		topBtn.setIcon(MSFMainApp.ICONS.save16());
		buttonBar.add(topBtn);
		
		topBtn.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				//주민번호, 성명, 관리부서, 소속부서
				if(resnRegnNum.getValue() == null || resnRegnNum.getValue() == ""){
					MessageBox.info("", "주민번호는 필수입니다.", null);
				}else if(hanNm.getValue() == null || hanNm.getValue() == ""){
					MessageBox.info("", "한글성명은 필수입니다.", null);
				//}else if(PersonalUtil.getSelectedComboValue(deptCd, "mangeDeptCd") == null || "".equals(PersonalUtil.getSelectedComboValue(deptCd, "mangeDeptCd"))){
				}else if(mangeDeptCd.getValue() == null || "".equals(mangeDeptCd.getValue())){
                  MessageBox.info("", "관리부서는 필수입니다.", null);
              //}else if(PersonalUtil.getSelectedComboValue(currAffnDeptCd, "deptCd") == null || "".equals(PersonalUtil.getSelectedComboValue(currAffnDeptCd, "deptCd"))){
              }else if(currAffnDeptCd.getValue() == null || "".equals(currAffnDeptCd.getValue())){
					MessageBox.info("", "소속부서는 필수입니다.", null);
				}else if(resnRegnNum.getValue() != null || resnRegnNum.getValue() != ""){
					//저장할시 신규인지 그리드를 선택한 수정인치 체크
					if(psnl0100Grid.getSelectionModel().getSelectedItem() != null ) {
						
						//수정
						MessageBox.confirm("기본사항 수정", "기본사항정보를 수정하시겠습니까?",new Listener<MessageBoxEvent>(){
							
							@Override
							public void handleEvent(MessageBoxEvent be) {
								
								//if("Yes".equals(be.getButtonClicked().getText())){
								if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
									final Psnl0100DTO updateForm = new Psnl0100DTO();
									
									updateForm.setDpobCd(psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
									updateForm.setSystemkey(psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
									
									updateForm.setDeptCd(mangeDeptCd.getValue());											//관리부서코드
									updateForm.setCurrAffnDeptCd(currAffnDeptCd.getValue());								//소속부서코드
									updateForm.setResnRegnNum(MSFSharedUtils.allowNulls(resnRegnNum.getValue()));			//주민등록번호
									updateForm.setHanNm(hanNm.getValue());													//한글이름
									updateForm.setChinCharNm(chinCharNm.getValue());										//한자이름
									updateForm.setEngNm(engNm.getValue());													//영문이름
									updateForm.setEmymtDivCd(MSFConfiguration.EMYMT_DIVCD02);  								//"A0020020" 고용구분코드
									updateForm.setHdofcCodtnCd(PersonalUtil.getSelectedComboValue(hdofcCodtnCd));			//재직구분
									
									//updateForm.setDeptCd(PersonalUtil.getSelectedComboValue(deptCd, "mangeDeptCd"));
									//updateForm.setCurrAffnDeptCd(PersonalUtil.getSelectedComboValue(currAffnDeptCd, "deptCd"));
									updateForm.setRepbtyBusinNm(repbtyBusinNm.getValue());									//담당업무
									updateForm.setFrstEmymtDt(PersonalUtil.getConvertDateToString(frstEmymtDt, "yyyyMMdd"));//최초고용일자
									updateForm.setOdtyCd(MSFSharedUtils.allowNulls(PersonalUtil.getSelectedComboValue(odtyCd)));		//직책
									updateForm.setNatnCd(MSFSharedUtils.allowNulls(natnCd.getValue()));									//국가코드
									
									//사진 명
									final String fileName = picFile.getValue();
									if(!"".equals(fileName) && fileName != null){
										updateForm.setPicFlnm(fileName.substring(fileName.lastIndexOf("\\")+1));
									}
									
									/***
									 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++
									 * 주민등록번호 수정할 경우 중복체크 처리하여 반영 시작
									 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++
									 * */
									
									// 기존 입력된 주민등록번호가 없을 경우를 위한 null 체크
									if(!"".equals(MSFSharedUtils.defaultNulls(resnRegnNumStr.getValue(), "")) ) {
										resnRegnNumStr.setValue(resnRegnNumStr.getValue().replaceAll("-", ""));
										
									}else {
										resnRegnNumStr.setValue("");
									}
									
									
									// 주민번호 수정할 경우 해당 주민번호가 이미 등록된 주민등록번호 있지 확인
									if(!(resnRegnNumStr.getValue()).equals(resnRegnNum.getValue().replaceAll("-", ""))) {
										updateForm.setResnRegnNum(resnRegnNum.getValue().replaceAll("-", ""));
										psnl0100Service.selectPsnl0100Check(updateForm, new AsyncCallback<List<Psnl0100DTO>>() {
											@Override
											public void onFailure(Throwable caught) {
												// TODO Auto-generated method stub
												MessageBox.alert("실패!", "주민등록번호 중복체크 오류!", null);
											}

											@Override
											public void onSuccess(List<Psnl0100DTO> result) {
												// TODO Auto-generated method stub
												if(result != null && result.size() > 0){
													final Psnl0100DTO dto = result.get(0);
													if(!"".equals(dto.getSystemkey())) {
														MessageBox.alert("오류!", "수정하고자 하는 주민등록번호가 </br> 이미 존재합니다.", null);
													}else {
														updatePsnl0100(updateForm, fileName);
													}
												}else {
													updatePsnl0100(updateForm, fileName);
												}
											}
										});
										
									}else {
										updatePsnl0100(updateForm, fileName);
									}
									/***
									 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++
									 * 주민등록번호 수정할 경우 중복체크 처리하여 반영 종료
									 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++
									 * */
									/***/
									
									
									/***/
//									psnl0100Service.updatePsnl0100(updateForm, new AsyncCallback<Integer>(){
//
//											@Override
//											public void onFailure(Throwable caught) {
//												
//												MessageBox.alert("실패!", "수정실패!", null);
//											}
//
//											@Override
//											public void onSuccess(Integer result) {
//												 
//                                              
//												if(!"".equals(fileName) && fileName != null){
//													//사진 등록처리 servlet 시작
//												    imgKeyCode.setValue(psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
//	                                               // dpobCd.setValue(psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
//	                                                frmKey.setValue("PSNL0125"); 
//	                                            
//	                                                plFrmPsnl0200.mask();  
//	                                                plFrmPsnl0200.setAction(GWT.getHostPageBaseURL() + "upload/ImageFileUpload.do"); 
//	                                                plFrmPsnl0200.submit();
//	                                                plFrmPsnl0200.onFrameLoad(); 
//	                                                picBoolFile = true;
//	                                               
//	                                                //사진 등록처리 servlet 끝 
//	                                                
//	                                                  // reset and unmask the form 
//	                                                  // after file upload 
//	                                                plFrmPsnl0200.addListener(Events.Submit, new Listener<FormEvent>() {
//	                                                      public void handleEvent(FormEvent evt) {  
//	                                                          plFrmPsnl0200.unmask(); 
//	                                                          if ("success".endsWith(evt.getResultHtml()) && picBoolFile) {
//	                                                              //업로드가  성공했으면 인서트 모듈을 태운다. 
//  	                                                              MessageBox.info("성공!", "수정되었습니다.", null);
//  	                                                              resetMainForm();
//  	                                                              final PagingLoadConfig config = new BasePagingLoadConfig();
//  	                                                              config.setOffset(0);
//  	                                                              config.setLimit(50);
//  	                                                          
//	                                                                // loaderPaging.load(config);
//	                                                                
////	                                                              //GWT 스케쥴 처리 (사진 정보 로드 문제로 인해 1초 딜레이를 준다.)2014.09.24 jungmin
//	                                                              Timer dtime = new Timer() {
//	                                                                  @Override
//	                                                                  public void run() {
//	                                                                      loaderPaging.load(config);
//	                                                                  }
//	                                                              };
//	                                                              dtime.schedule(2000); 
//	                                                                picBoolFile = false;
//	                                                                evt.setResultHtml("");
//	                                                          } else {
//	                                                              //TODO 처리 할것 실패 메시지나 에러 메시지 처리 .
//	                                                              evt.setResultHtml("");
//	                                                          }
//	                                                      };
//	                                                   });
//												} else {
//													if(result == -1){
//														 MessageBox.info("실패!", "2017년도 고용시작일 대상자는 재직구분을 변경할수 없습니다. \n 고용탭에서 고용종료일을 입력해주세요.", null);
////	                                                     resetMainForm();
////	                                                     final PagingLoadConfig config = new BasePagingLoadConfig();
////	                                                     config.setOffset(0);
////	                                                     config.setLimit(50);
////	                                                     loaderPaging.load(config);
//													}else{
//													    MessageBox.info("성공!", "수정되었습니다.", null);
//	                                                    resetMainForm();
//	                                                    final PagingLoadConfig config = new BasePagingLoadConfig();
//	                                                    config.setOffset(0);
//	                                                    config.setLimit(50);
//                                                
//	                                                    loaderPaging.load(config);
//													}
//												}
//											}
//										});
									/***/
									
									
									}
								}
							});
					}else{
						//신규등록
						
						MessageBox.confirm("기본사항 등록", "기본사항정보를 등록하시겠습니까?",new Listener<MessageBoxEvent>(){

							@Override
							public void handleEvent(MessageBoxEvent be) {
								
								
							//	if("Yes".equals(be.getButtonClicked().getText())){
								if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
									final Psnl0100DTO insertForm = new Psnl0100DTO();
									
									insertForm.setDeptCd(mangeDeptCd.getValue());				//관리부서
                                  insertForm.setCurrAffnDeptCd(currAffnDeptCd.getValue());	//소속부서
									insertForm.setResnRegnNum(resnRegnNum.getValue()); 			//주민번호
									insertForm.setHanNm(hanNm.getValue());						//한글이름
									insertForm.setChinCharNm(chinCharNm.getValue());			//한자이름
									insertForm.setEngNm(engNm.getValue());						//영문이름
									insertForm.setHdofcCodtnCd(PayGenConst.HDOFC_CODTN_CD_01);	//"A0030010" 재직구분
									insertForm.setEmymtDivCd(MSFConfiguration.EMYMT_DIVCD02);  		//"A0020020"	고용상태
//									insertForm.setDeptCd(PersonalUtil.getSelectedComboValue(deptCd, "mangeDeptCd"));
//									insertForm.setCurrAffnDeptCd(PersonalUtil.getSelectedComboValue(currAffnDeptCd, "deptCd"));
									insertForm.setRepbtyBusinNm(repbtyBusinNm.getValue());	//담당업무
									insertForm.setNatnCd(natnCd.getValue());				//국가코드
									
                                  // ---- 주민등록번호를 이용하여 생년월일을 가져온다. ---- 
                                  String strResnRegnNum = "";
                                  strResnRegnNum = resnRegnNum.getValue();
                                  getStrYoobhMnthDay(strResnRegnNum);
                                  insertForm.setYoobhMnthDay(strYoobhMnthDay);
                                  // ----------------------------------------
                                  
                                  // ---- 주민등록번호를 이용하여 성별을 가져온다. ----
                                  String sxDivCdTemp = "";
                                  sxDivCdTemp = strResnRegnNum.substring(7,8);
                                  if("1".equals(sxDivCdTemp) || "3".equals(sxDivCdTemp)) {
                                  	insertForm.setSxDivCd("A0040010");	//성별
                                  }else if("2".equals(sxDivCdTemp) || "4".equals(sxDivCdTemp)) {
                                  	insertForm.setSxDivCd("A0040020");	//성별
                                  }
                                  // -------------------------------------
									
									psnl0100Service.selectPsnl0100Check(insertForm, new AsyncCallback<List<Psnl0100DTO>>() {
										
										@Override
										public void onSuccess(List<Psnl0100DTO> result) {
											if(result != null && result.size() > 0){
												final Psnl0100DTO dto = result.get(0);
												if("A0030020".equals(dto.getHdofcCodtnCd())  && "A0020020".equals(dto.getEmymtDivCd())){
													MessageBox.confirm(null, "현재 사용자는 퇴직처리 되었습니다.기본 정보를 불러오시겠습니까?", new Listener<MessageBoxEvent>(){

														@Override
														public void handleEvent(
																MessageBoxEvent be) {
															//if("Yes".equals(be.getButtonClicked().getText())){
															if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
																searchName.setValue("");
																//cmbxNewCombobox.setValue(new BaseModel());
																searchMangeDeptCd.setValue("");
																searchMangeDeptNm.setValue("");
																searchResnRegnNum.setValue(insertForm.getResnRegnNum());
																//cmbxNewCombobox_3.setValue(new BaseModel());
																srhCurrAffnDeptCd.setValue("");
                                                              srhCurrAffnDeptNm.setValue("");
//																cmbxSchHdofcCodtnCd.setValue(new BaseModel());
																srhHdofcCodtnCd.setValue("");
																searchYearBusinCd.setValue(new BaseModel());
																
																
																loaderPaging.load();
															}
														}
													});
												}else if("A0030020".equals(dto.getHdofcCodtnCd()) && "A0020010".equals(dto.getEmymtDivCd())) {
													
													//퇴직자이면서 공무직인 데이터가 있을 경우 공무직으로 전환할 것인지 체크하여 등록한다.
													// 고용구분 전환 메소드 호출
													psnl0100Status(dto);
													
//													//퇴직자이면서 공무직인 데이터가 있을 경우 공무직으로 전환할 것인지 체크하여 등록한다.
//													MessageBox.confirm(null, "퇴직한 공무직근로자 정보가 존재! <br> 기존 정보로 기간제근로자(으)로  <br>  전환하시겠습니까?", new Listener<MessageBoxEvent>(){
//														@Override
//														public void handleEvent(MessageBoxEvent be) {
//															if("Yes".equals(be.getButtonClicked().getText())){
//																
//																searchName.setValue("");
//																//cmbxNewCombobox.setValue(new BaseModel());
//																searchMangeDeptCd.setValue("");
//																searchMangeDeptNm.setValue("");
//																searchResnRegnNum.setValue(insertForm.getResnRegnNum());
//																//cmbxNewCombobox_3.setValue(new BaseModel());
//																srhCurrAffnDeptCd.setValue("");
//                                                              srhCurrAffnDeptNm.setValue("");
////																cmbxSchHdofcCodtnCd.setValue(new BaseModel());
//																srhHdofcCodtnCd.setValue("");
//																searchYearBusinCd.setValue(new BaseModel());
//															
//																psnl0100Service.updatePsnl0100Status(dto, new AsyncCallback<Integer>() {
//
//																	@Override
//																	public void onFailure(Throwable caught) {
//																		// TODO Auto-generated method stub
//																		MessageBox.info("", "전환 실패", null);
//																	}
//
//																	@Override
//																	public void onSuccess(Integer result) {
//																		// TODO Auto-generated method stub
//																		if(result == 1) {
//																			MessageBox.info("", "전환 완료", null);
//																		}else {
//																			MessageBox.info("", "전환 실패", null);
//																		}
//																	}
//																});
//																loaderPaging.load();
//															}
//														}
//													});
												}else if("A0030010".equals(dto.getHdofcCodtnCd())){
													MessageBox.info("", "현재 사용자는 재직중입니다.", null);
												}else {
													// 재직 구분이 없는 경우
													MessageBox.info("", "등록된 사용자가 존재합니다.", null);
												}
												
											}else { //주민번호가 등록되어있지 않을때 등록처리
												//사진 명
												final String fileName = picFile.getValue();
												if(!"".equals(fileName) && fileName != null){
													insertForm.setPicFlnm(fileName.substring(fileName.lastIndexOf("\\")+1));
												}
												
												psnl0100Service.insertPsnl0100(insertForm, new AsyncCallback<String>() {
													
													@Override
													public void onSuccess(String result) {
														
														
														if(!"".equals(fileName) && fileName != null){
														 
														  //사진 등록처리 servlet 시작
														    frmKey.setValue("PSNL0125"); 
                                                         // dpobCd.setValue(MSFMainApp.get().getUser().getDpobCd());
                                                          imgKeyCode.setValue(result);
		                                                
		                                                    plFrmPsnl0200.mask();  
		                                                    plFrmPsnl0200.setAction(GWT.getHostPageBaseURL() + "upload/ImageFileUpload.do"); 
		                                                    plFrmPsnl0200.submit();
		                                                    plFrmPsnl0200.onFrameLoad(); 
		                                                    picBoolFile = true;
		                                                   
		                                                    //사진 등록처리 servlet 끝 
		                                                    
		                                                      // reset and unmask the form 
		                                                      // after file upload 
		                                                    plFrmPsnl0200.addListener(Events.Submit, new Listener<FormEvent>() {
		                                                          public void handleEvent(FormEvent evt) {  
		                                                              plFrmPsnl0200.unmask(); 
		                                                              if ("success".endsWith(evt.getResultHtml()) && picBoolFile) {
		                                                                  //업로드가  성공했으면 인서트 모듈을 태운다. 
		                                                                  MessageBox.info("성공!", "정상등록되었습니다.", null);
		                                                                  resetMainForm();
		                                                                  PagingLoadConfig config = new BasePagingLoadConfig();
		                                                                  config.setOffset(0);
		                                                                  config.setLimit(50);
		                                                                  
		                                                                  loaderPaging.load(config);
		                                                                
		                                                                  picBoolFile = false;
		                                                                  evt.setResultHtml("");
		                                                              } else {
		                                                                  //TODO 처리 할것 실패 메시지나 에러 메시지 처리 .
		                                                                  evt.setResultHtml("");
		                                                              }
		                                                          };
		                                                       }); 
														}  else  {
                                                          
                                                         // if (!"".equals(result))  {
                                                                 
                                                              //업로드가  성공했으면 인서트 모듈을 태운다. 
                                                              MessageBox.info("성공!", "정상등록되었습니다.", null);
                                                              resetMainForm();
                                                              PagingLoadConfig config = new BasePagingLoadConfig();
                                                              config.setOffset(0);
                                                              config.setLimit(50);
                                                              
                                                              loaderPaging.load(config);
                                                          //   }
                                                      }
													}
													
													
													@Override
													public void onFailure(Throwable caught) {
														caught.printStackTrace();
														MessageBox.alert("실패!", "등록실패!", null);
													}
												});
											}
										}
										
										@Override
										public void onFailure(Throwable caught) {
											// TODO Auto-generated method stub
											// 주민등록 번호 체크 오류
											MessageBox.info("", "주민등록번호  체크 오류 발생", null);
										}
									});
								}
							}
						});
					}
				}
              
//				else{
//					//저장할시 신규인지 그리드를 선택한 수정인치 체크
//					if(psnl0100Grid.getSelectionModel().getSelectedItem() != null ) {
//						
//						//수정
//						MessageBox.confirm("기본사항 수정", "기본사항정보를 수정하시겠습니까?",new Listener<MessageBoxEvent>(){
//							
//							@Override
//							public void handleEvent(MessageBoxEvent be) {
//								
//								if("Yes".equals(be.getButtonClicked().getText())){
//									Psnl0100DTO updateForm = new Psnl0100DTO();
//									
//									updateForm.setDpobCd(psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
//									updateForm.setSystemkey(psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
//									
//									updateForm.setDeptCd(mangeDeptCd.getValue());				//관리부서코드
//                                  updateForm.setCurrAffnDeptCd(currAffnDeptCd.getValue());	//소속부서코드
//									updateForm.setResnRegnNum(resnRegnNum.getValue());			//주민등록번호
//									updateForm.setHanNm(hanNm.getValue());						//한글이름
//									updateForm.setChinCharNm(chinCharNm.getValue());			//한자이름
//									updateForm.setEngNm(engNm.getValue());						//영문이름
//									updateForm.setEmymtDivCd(MSFConfiguration.EMYMT_DIVCD02);  		//"A0020020" 고용구분코드
//									updateForm.setHdofcCodtnCd(PersonalUtil.getSelectedComboValue(cmbxSchHdofcCodtnCd));//재직구분
//									
//									//updateForm.setDeptCd(PersonalUtil.getSelectedComboValue(deptCd, "mangeDeptCd"));
//									//updateForm.setCurrAffnDeptCd(PersonalUtil.getSelectedComboValue(currAffnDeptCd, "deptCd"));
//									
//									
//									//사진 명
//									final String fileName = picFile.getValue();
//									if(!"".equals(fileName) && fileName != null){
//										updateForm.setPicFlnm(fileName.substring(fileName.lastIndexOf("\\")+1));
//									}
//									
//									psnl0100Service.updatePsnl0100(updateForm, new AsyncCallback<Integer>(){
//
//											@Override
//											public void onFailure(Throwable caught) {
//												
//												MessageBox.alert("실패!", "수정실패!", null);
//											}
//
//											@Override
//											public void onSuccess(Integer result) {
//												 
//                                              
//												if(!"".equals(fileName) && fileName != null){
//													//사진 등록처리 servlet 시작
//												    imgKeyCode.setValue(psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
//	                                               // dpobCd.setValue(psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
//	                                                frmKey.setValue("PSNL0125"); 
//	                                            
//	                                                plFrmPsnl0200.mask();  
//	                                                plFrmPsnl0200.setAction(GWT.getHostPageBaseURL() + "upload/ImageFileUpload.do"); 
//	                                                plFrmPsnl0200.submit();
//	                                                plFrmPsnl0200.onFrameLoad(); 
//	                                                picBoolFile = true;
//	                                               
//	                                                //사진 등록처리 servlet 끝 
//	                                                
//	                                                  // reset and unmask the form 
//	                                                  // after file upload 
//	                                                plFrmPsnl0200.addListener(Events.Submit, new Listener<FormEvent>() {
//	                                                      public void handleEvent(FormEvent evt) {  
//	                                                          plFrmPsnl0200.unmask(); 
//	                                                          if ("success".endsWith(evt.getResultHtml()) && picBoolFile) {
//	                                                              //업로드가  성공했으면 인서트 모듈을 태운다. 
//  	                                                              MessageBox.info("성공!", "수정되었습니다.", null);
//  	                                                              resetMainForm();
//  	                                                              final PagingLoadConfig config = new BasePagingLoadConfig();
//  	                                                              config.setOffset(0);
//  	                                                              config.setLimit(50);
//  	                                                          
//	                                                                // loaderPaging.load(config);
//	                                                                
////	                                                              //GWT 스케쥴 처리 (사진 정보 로드 문제로 인해 1초 딜레이를 준다.)2014.09.24 jungmin
//	                                                              Timer dtime = new Timer() {
//	                                                                  @Override
//	                                                                  public void run() {
//	                                                                      loaderPaging.load(config);
//	                                                                  }
//	                                                              };
//	                                                              dtime.schedule(2000); 
//	                                                                picBoolFile = false;
//	                                                                evt.setResultHtml("");
//	                                                          } else {
//	                                                              //TODO 처리 할것 실패 메시지나 에러 메시지 처리 .
//	                                                              evt.setResultHtml("");
//	                                                          }
//	                                                      };
//	                                                   });
//												} else {
//												    
//												    MessageBox.info("성공!", "수정되었습니다.", null);
//                                                  resetMainForm();
//                                                  final PagingLoadConfig config = new BasePagingLoadConfig();
//                                                  config.setOffset(0);
//                                                  config.setLimit(50);
//                                                
//                                                  loaderPaging.load(config);
//												}
//											}
//										});
//									}
//								}
//							});
//					}else{
//						//신규등록
//						
//						MessageBox.confirm("기본사항 등록", "기본사항정보를 등록하시겠습니까?",new Listener<MessageBoxEvent>(){
//
//							@Override
//							public void handleEvent(MessageBoxEvent be) {
//								
//								
//								if("Yes".equals(be.getButtonClicked().getText())){
//									final Psnl0100DTO insertForm = new Psnl0100DTO();
//									
//									insertForm.setDeptCd(mangeDeptCd.getValue());				//관리부서
//                                  insertForm.setCurrAffnDeptCd(currAffnDeptCd.getValue());	//소속부서
//									insertForm.setResnRegnNum(resnRegnNum.getValue()); 			//주민번호
//									insertForm.setHanNm(hanNm.getValue());						//한글이름
//									insertForm.setChinCharNm(chinCharNm.getValue());			//한자이름
//									insertForm.setEngNm(engNm.getValue());						//영문이름
//									insertForm.setHdofcCodtnCd(PayGenConst.HDOFC_CODTN_CD_01);	//"A0030010" 재직구분
//									insertForm.setEmymtDivCd(MSFConfiguration.EMYMT_DIVCD02);  		//"A0020020"	고용상태
////									insertForm.setDeptCd(PersonalUtil.getSelectedComboValue(deptCd, "mangeDeptCd"));
////									insertForm.setCurrAffnDeptCd(PersonalUtil.getSelectedComboValue(currAffnDeptCd, "deptCd"));
//									
//									
//									psnl0100Service.selectPsnl0100Check(insertForm, new AsyncCallback<List<Psnl0100DTO>>() {
//										
//										@Override
//										public void onSuccess(List<Psnl0100DTO> result) {
//											if(result != null && result.size() > 0){
//												Psnl0100DTO dto = result.get(0);
//												if("A0030020".equals(dto.getHdofcCodtnCd())){
//													MessageBox.confirm(null, "현재 사용자는 퇴직처리 되었습니다.기본 정보를 불러오시겠습니까?", new Listener<MessageBoxEvent>(){
//
//														@Override
//														public void handleEvent(
//																MessageBoxEvent be) {
//															if("Yes".equals(be.getButtonClicked().getText())){
//																searchName.setValue("");
//																//cmbxNewCombobox.setValue(new BaseModel());
//																searchMangeDeptCd.setValue("");
//																searchMangeDeptNm.setValue("");
//																searchResnRegnNum.setValue(insertForm.getResnRegnNum());
//																//cmbxNewCombobox_3.setValue(new BaseModel());
//																srhCurrAffnDeptCd.setValue("");
//                                                              srhCurrAffnDeptNm.setValue("");
//																cmbxSchHdofcCodtnCd.setValue(new BaseModel());
//																searchYearBusinCd.setValue(new BaseModel());
//																loaderPaging.load();
//															}
//														}
//													});
//												}else if("A0030010".equals(dto.getHdofcCodtnCd())){
//													MessageBox.info("", "현재 사용자는 재직중입니다.", null);
//												}
//												
//											}else { //주민번호가 등록되어있지 않을때 등록처리
//												//사진 명
//												final String fileName = picFile.getValue();
//												if(!"".equals(fileName) && fileName != null){
//													insertForm.setPicFlnm(fileName.substring(fileName.lastIndexOf("\\")+1));
//												}
//												
//												psnl0100Service.insertPsnl0100(insertForm, new AsyncCallback<String>() {
//													
//													@Override
//													public void onSuccess(String result) {
//														
//														
//														if(!"".equals(fileName) && fileName != null){
//														 
//														  //사진 등록처리 servlet 시작
//														    frmKey.setValue("PSNL0125"); 
//                                                         // dpobCd.setValue(MSFMainApp.get().getUser().getDpobCd());
//                                                          imgKeyCode.setValue(result);
//		                                                
//		                                                    plFrmPsnl0200.mask();  
//		                                                    plFrmPsnl0200.setAction(GWT.getHostPageBaseURL() + "upload/ImageFileUpload.do"); 
//		                                                    plFrmPsnl0200.submit();
//		                                                    plFrmPsnl0200.onFrameLoad(); 
//		                                                    picBoolFile = true;
//		                                                   
//		                                                    //사진 등록처리 servlet 끝 
//		                                                    
//		                                                      // reset and unmask the form 
//		                                                      // after file upload 
//		                                                    plFrmPsnl0200.addListener(Events.Submit, new Listener<FormEvent>() {
//		                                                          public void handleEvent(FormEvent evt) {  
//		                                                              plFrmPsnl0200.unmask(); 
//		                                                              if ("success".endsWith(evt.getResultHtml()) && picBoolFile) {
//		                                                                  //업로드가  성공했으면 인서트 모듈을 태운다. 
//		                                                                  MessageBox.info("성공!", "정상등록되었습니다.", null);
//		                                                                  resetMainForm();
//		                                                                  PagingLoadConfig config = new BasePagingLoadConfig();
//		                                                                  config.setOffset(0);
//		                                                                  config.setLimit(50);
//		                                                                  
//		                                                                  loaderPaging.load(config);
//		                                                                
//		                                                                  picBoolFile = false;
//		                                                                  evt.setResultHtml("");
//		                                                              } else {
//		                                                                  //TODO 처리 할것 실패 메시지나 에러 메시지 처리 .
//		                                                                  evt.setResultHtml("");
//		                                                              }
//		                                                          };
//		                                                       }); 
//														}  else  {
//                                                          
//                                                         // if (!"".equals(result))  {
//                                                                 
//                                                              //업로드가  성공했으면 인서트 모듈을 태운다. 
//                                                              MessageBox.info("성공!", "정상등록되었습니다.", null);
//                                                              resetMainForm();
//                                                              PagingLoadConfig config = new BasePagingLoadConfig();
//                                                              config.setOffset(0);
//                                                              config.setLimit(50);
//                                                              
//                                                              loaderPaging.load(config);
//                                                          //   }
//                                                      }
//													}
//													
//													
//													@Override
//													public void onFailure(Throwable caught) {
//														caught.printStackTrace();
//														MessageBox.alert("실패!", "등록실패!", null);
//													}
//												});
//											}
//										}
//										
//										@Override
//										public void onFailure(Throwable caught) {
//											// TODO Auto-generated method stub
//											// 주민등록 번호 체크 오류
//											MessageBox.info("", "주민등록번호  체크 오류 발생", null);
//										}
//									});
//								}
//							}
//						});
//					}
//				}
			}
		}); 
		
		topBtn = new Button("삭제");
		topBtn.setIcon(MSFMainApp.ICONS.delete16());
		buttonBar.add(topBtn);
		
		topBtn.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				if(psnl0100Grid.getSelectionModel().getSelectedItem() != null ) {
					MessageBox.confirm("기본사항 삭제", "기본사항정보를 삭제하시겠습니까?",new Listener<MessageBoxEvent>(){

						@Override
						public void handleEvent(MessageBoxEvent be) {
							
							//if("Yes".equals(be.getButtonClicked().getText())){
							if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
								String dpobCd = psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd();
								String systemkey = psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey();
								String mangeCd = psnl0100Grid.getSelectionModel().getSelectedItem().getDeptCd();
								String currAffnDeptCd = psnl0100Grid.getSelectionModel().getSelectedItem().getCurrAffnDeptCd();
								String resnRegnNum = psnl0100Grid.getSelectionModel().getSelectedItem().getResnRegnNum();
								String hanNm = psnl0100Grid.getSelectionModel().getSelectedItem().getHanNm();
								String chinCharNm = psnl0100Grid.getSelectionModel().getSelectedItem().getChinCharNm();
								String engNm = psnl0100Grid.getSelectionModel().getSelectedItem().getEngNm();
								String emymtDivCd = psnl0100Grid.getSelectionModel().getSelectedItem().getEmymtDivCd();
								
								HashMap<String,String> map = new HashMap<String, String>();
								map.put("dpobCd", dpobCd);					//사업장코드
								map.put("systemkey", systemkey);			//시스템키
								map.put("deptCd", mangeCd);  				//관리부서코드
								map.put("currAffnDeptCd", currAffnDeptCd);	//소속부서코드
								map.put("resnRegnNum", resnRegnNum); 		//주민등록번호
								map.put("hanNm", hanNm);					//한글이름
								map.put("chinCharNm", chinCharNm); 			//한자이름
								map.put("engNm", engNm); 					//영문이름
								map.put("emymtDivCd", emymtDivCd);			//"A0020020" 고용구분코드
								
								psnl0100Service.deletePsnl0100(map, new AsyncCallback<Integer>(){

											@Override
											public void onFailure(Throwable caught) {
												  MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
					                                         MSFMainApp.ADMINMESSAGES.ExceptionMessageService("삭제실패 : " + caught), null);	
											}

											@Override
											public void onSuccess(Integer result) {
												
												if(result == 0) {
													MessageBox.info("오류", "삭제된 데이터가 없습니다.", null);
												}else if(result == 1) {
													MessageBox.info("알림", "정상삭제되었습니다.", null);
													
												}else if(result == 3) {
													MessageBox.info("경고", "고용/급여/사대보험 데이터 이력이 존재하는 근로자는 삭제할 수 없습니다.", null);
													
												}else {
													MessageBox.info("알림", "정상삭제되었습니다.", null);
												}
												
//												MessageBox.info("성공!", "정상삭제되었습니다.", null);
												resetMainForm();
												PagingLoadConfig config = new BasePagingLoadConfig();
												config.setOffset(0);
												config.setLimit(50);
												
												loaderPaging.load(config);
											}
								});
								resetMainForm();
							}
						}
						
					});
				}
			}
		});
		
		
		
		   topBtn = new Button("조회");
		   topBtn.setIcon(MSFMainApp.ICONS.search16());
		    buttonBar.add(topBtn);
		
		    topBtn.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				//그리드 선택 없애기
				psnl0100Grid.getSelectionModel().deselectAll();
				//기본사항 폼 초기화
				
				//조회시 탭부분 초기화
				tabsPsnl.setSelection(tabsPsnl.getItem(0));
				resetMainForm();
				resetPsnl0111Form();
				
				PagingLoadConfig config = new BasePagingLoadConfig();
				config.setOffset(0);
				config.setLimit(50);
				
				loaderPaging.load(config);
				
				/*
				psnl0111HusRoadNmZpcd.setValue(""); //도로명 주소 우편번호
				psnl0111HusRoadNmFndtnAddr.setValue(""); // 도로명 기본주소
				psnl0111HusRoadNmDtlPatrAddr.setValue(""); //도로명 상세 주소
				psnl0111BthcAddr.setValue("");//생활 근거지 주소
				psnl0111HfmlyNm.setValue(""); //호주
				//private ComboBox<ModelData> psnl0111HfmlyRelaCd; //호주관계
				psnl0111CellPhneNum.setValue(""); //휴대폰번호
				psnl0111HusPhnNum.setValue(""); //전화번호
				psnl0111EmailAddr.setValue(""); //이메일
				pernNoteCtnt.setValue(""); //비고 초기화
				
				resetMainForm();
				resetPsnl0111Form();
				*/
			}
		});
		

		topBtn = new Button("인쇄", psnl0200ButtonListener);
		topBtn.setIcon(MSFMainApp.ICONS.print16());
//		topBtn.addListener(Events.Select, new Listener<ButtonEvent>() {
//			public void handleEvent(ButtonEvent e) {
//				if(psnl0100Grid.getSelectionModel().getSelectedItem() != null){
//					
//					Psnl0100DTO dto = psnl0100Grid.getSelectionModel().getSelectedItem();
//					String serarchParam = "";
//					String name = dto.getHanNm() == null ? "" : dto.getHanNm();
//					String resn = dto.getResnRegnNum() == null ? "" : dto.getResnRegnNum().replaceAll("-", "");
//					String hdofcCodtnCd = dto.getHdofcCodtnCd() == null ? "" : dto.getHdofcCodtnCd();
//					String manageDeptCd = dto.getDeptCd() == null ? "" : dto.getDeptCd();
//					String deptCd = dto.getCurrAffnDeptCd() == null ? "" : dto.getCurrAffnDeptCd(); 
//					String typOccuCd = dto.getTypOccuCd() == null ? "" : dto.getTypOccuCd();
//					String emymtDivCd = dto.getEmymtDivCd() == null ? "" : dto.getEmymtDivCd();
//					String systemkey = dto.getSystemkey() == null ? "" : dto.getSystemkey();
//					
//					serarchParam += "["+name+"]";
//					serarchParam += "["+resn+"]";
//					serarchParam += "["+hdofcCodtnCd+"]";
//					serarchParam += "["+manageDeptCd+"]";
//					serarchParam += "["+deptCd+"]";
//					serarchParam += "["+emymtDivCd+"]";
//					serarchParam += "["+typOccuCd+"]";
//					
//					String strParam = "/rp " + serarchParam+"['"+systemkey+"']";
//					//System.out.println("신상 = "+strParam);
//					PrintUtils.setPostCall(true);
//					PrintUtils.rdaPrint("PSNL", "PSNLT0253.mrd", strParam);
//					
//				}else{
//					MessageBox.alert("", "근로자 정보를 선택하여 주세요.", null);
//				}
//			}
//		});
		buttonBar.add(topBtn);
		layoutContainer.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_2.setBorders(false);
		plFrmPsnl0200.add(layoutContainer);
		layoutContainer.setBorders(false);

		// 파일업로드 처리 
		
		plFrmPsnl0200.setAction("myurl");
		plFrmPsnl0200.setEncoding(Encoding.MULTIPART);
		plFrmPsnl0200.setMethod(Method.POST);  
		//("multipart/form-data; charset=UTF-8"); 
//	    FormElement frmEl=FormElement.as(plFrmPsnl0200.getElement()); 
//	    frmEl.setAcceptCharset("UTF-8");  
		vp.add(plFrmPsnl0200); 
		plFrmPsnl0200.setSize("990px", "690px");
	}
	
	private SelectionListener<ButtonEvent> psnl0200ButtonListener = new SelectionListener<ButtonEvent>() {
		public void componentSelected(ButtonEvent ce) {
			//TODO 환경미화원은 데이터 안나와서 출력물은 기존의 것으로 사용. 
			//인사기본출력에서는 권한 추가해서 환경미화원이 안나옴. 그래서 출력물 따로 만들어서 사용함
			Psnl0200Print("PSNLT025301", MSFMainApp.getMsg("PayGen.ReportDivisionType"));
		}
	};	
	
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 인쇄 처리를 위해 추가된 부분 시작
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */
	/**
   *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
   * 	print Service 선언부 시작
   *  rex 추가로 리포트 타입변경
   *  fileName : 출력파일명 
   *  repType : 출력물 타입 RDA -M2SOFT , REX - CLIPSOFT 
   *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
   **/
	private void Psnl0200Print(String fileName, String repType) {
		   if (PayGenConst.REPORT_DIV_TYPE02.equals(repType)) {
			   RdaPrint(fileName);
		   } else  if (PayGenConst.REPORT_DIV_TYPE01.equals(repType)) {
			   RexPrint(fileName);
		   } else {
			   Window.alert("출력 타입 오류(프로퍼티설정확인)!" + repType);
		   }
	    }	
	
	
	//rda
	private void RdaPrint(String fileName) {
		
		// 출력물 디렉토리 패스경로 인사 : PSNL
		String strDirPath = "PSNL";
		
		// mrd 출력물
		String rdaFileName = fileName+".mrd";
				
		// 보낼 파라미터
		
		//검색조건
		String serarchParam = "";
		
		if(psnl0100Grid.getSelectionModel().getSelectedItem() != null){
			Psnl0100DTO dto = psnl0100Grid.getSelectionModel().getSelectedItem();
	
			String name = dto.getHanNm() == null ? "" : dto.getHanNm();	//성명
			String resn = dto.getResnRegnNum() == null ? "" : dto.getResnRegnNum().replaceAll("-", "");	//주민번호
			String hdofcCodtnCd = dto.getHdofcCodtnCd() == null ? "" : dto.getHdofcCodtnCd();	//재직구분
			String manageDeptCd = dto.getDeptCd() == null ? "" : dto.getDeptCd();	//관리부서
			String deptCd = dto.getCurrAffnDeptCd() == null ? "" : dto.getCurrAffnDeptCd();	//소속부서 
			String typOccuCd = dto.getTypOccuCd() == null ? "" : dto.getTypOccuCd();	//직종
			String dtilOccuInttnCd = dto.getDtilOccuInttnCd() == null ? "" : dto.getDtilOccuInttnCd();	//직종세
			String emymtDivCd = dto.getEmymtDivCd() == null ? "" : dto.getEmymtDivCd();	//고용구분
			String systemkey = dto.getSystemkey() == null ? "" : dto.getSystemkey();	//시스템키
			
			//TODO---
//			serarchParam += "["+name+"]";
//			serarchParam += "["+resn+"]";
//			serarchParam += "["+hdofcCodtnCd+"]";
//			serarchParam += "["+manageDeptCd+"]";
//			serarchParam += "["+deptCd+"]";
//			serarchParam += "["+emymtDivCd+"]";
//			serarchParam += "["+typOccuCd+"]";
//			serarchParam += "["+dtilOccuInttnCd+"]"; 
//			serarchParam += "['"+systemkey+"']";
//			
//			String strParam = "/rp " + serarchParam+"['"+systemkey+"']";
			
			//도장 출력을 위해 추가 2014-11-06 
	        String myImgUrl = MSFMainApp.getMsg("PayGen.MyPhotoUrl");
	        if(MSFSharedUtils.paramNull(myImgUrl)) {
	           // myImgUrl = "http://105.19.10.32:8080";
			//경로오류 출력 
	        }
			
			serarchParam += "["+name+"]";				//$1 
			serarchParam += "["+""+"]";					//$2
			serarchParam += "["+hdofcCodtnCd+"]";		//$3
			serarchParam += "["+manageDeptCd+"]";		//$4
			serarchParam += "["+deptCd+"]";				//$5
			serarchParam += "["+emymtDivCd+"]";			//$6
			serarchParam += "["+typOccuCd+"]";			//$7
			serarchParam += "["+dtilOccuInttnCd+"]";    //$8
			serarchParam += "["+"'"+systemkey+"'"+"]";	//$9
			serarchParam += "[" + myImgUrl + "]";		//$10
			
			
			String strParam = "/rp " + serarchParam;
			
			
			PrintUtils.setPostCall(true);
			PrintUtils.rdaPrint(strDirPath, rdaFileName, strParam);
		}else{
			MessageBox.alert("", "근로자 정보를 선택하여 주세요.", null);
		}
	}
	
	//rex 
	private void RexPrint(String fileName) {
		
		// 출력물 디렉토리 패스경로 인사 : PSNL  //  급여 : PAYR
		String strDirPath = "PSNL";
		
		// reb 출력물
		String rexFileName = fileName+".crf";
		
		// 보낼 파라미터  
		
      // 검색조건
   	String serarchParam = "";

		if(psnl0100Grid.getSelectionModel().getSelectedItem() != null){
				
			Psnl0100DTO dto = psnl0100Grid.getSelectionModel().getSelectedItem();

			String name = dto.getHanNm() == null ? "" : dto.getHanNm();	//성명
			String resn = dto.getResnRegnNum() == null ? "" : dto.getResnRegnNum().replaceAll("-", "");	//주민번호
			String hdofcCodtnCd = dto.getHdofcCodtnCd() == null ? "" : dto.getHdofcCodtnCd();	//재직구분
			String manageDeptCd = dto.getDeptCd() == null ? "" : dto.getDeptCd();	//관리부서
			String deptCd = dto.getCurrAffnDeptCd() == null ? "" : dto.getCurrAffnDeptCd();	//소속부서 
			String typOccuCd = dto.getTypOccuCd() == null ? "" : dto.getTypOccuCd();	//직종
			String dtilOccuInttnCd = dto.getDtilOccuInttnCd() == null ? "" : dto.getDtilOccuInttnCd();	//직종세
			String emymtDivCd = dto.getEmymtDivCd() == null ? "" : dto.getEmymtDivCd();	//고용구분
			String systemkey = dto.getSystemkey() == null ? "" : dto.getSystemkey();	//시스템키
			
			//도장 출력을 위해 추가 2014-11-06 //$9
	        String myImgUrl = MSFMainApp.getMsg("PayGen.MyPhotoUrl");
	        if(MSFSharedUtils.paramNull(myImgUrl)) {
	           // myImgUrl = "http://105.19.10.32:8080";
			//경로오류 출력 
	        }
				
			serarchParam += ""+name+"⊥";				//$1
			serarchParam += ""+""+"⊥";					//$2
			serarchParam += ""+hdofcCodtnCd+"⊥";		//$3
			serarchParam += ""+manageDeptCd+"⊥";		//$4
			serarchParam += ""+deptCd+"⊥";				//$5
			serarchParam += ""+emymtDivCd+"⊥";			//$6
			serarchParam += ""+typOccuCd+"⊥";			//$7
			serarchParam += ""+dtilOccuInttnCd+"⊥";     //$8
			serarchParam += ""+"'"+systemkey+"'"+"⊥";	//$9
			serarchParam += "" + myImgUrl + "⊥";		//$10 
			
//			String strParam = "" + serarchParam+"'"+systemkey+"'⊥";
			String strParam = "" + serarchParam + "⊥" ;
			
			
			//GWT 타입으로 팝업 호출시  postCall true 설정
			PrintUtils.setPostCall(true);
			PrintUtils.rexPrint(strDirPath, rexFileName, strParam);
				
			}else{
				MessageBox.alert("", "근로자 정보를 선택하여 주세요.", null);
			}
	}		
	
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 인쇄 처리를 위해 추가된 부분 종료
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */		 
	
	// 인적
	private LayoutContainer PersonalData01() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		//ButtonBar buttonBar01 = new ButtonBar();

		LayoutContainer lcStd01 = new LayoutContainer();
		//lcStd01.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStd01.setLayout(frmlytStd);

		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		FormLayout frmlytStd1 = new FormLayout();
		frmlytStd1.setLabelWidth(100);
		frmlytStd1.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1.setLayout(frmlytStd1);

		psnl0111HusRoadNmZpcd = new MSFTextField();
		//psnl0111HusRoadNmZpcd = new TextField<String>();
		psnl0111HusRoadNmZpcd.setId("psnl0111HusRoadNmZpcd");
		psnl0111HusRoadNmZpcd.setMaxLength(6);
		psnl0111HusRoadNmZpcd.setRegex("^[0-9]+$");
		//new TextFieldMask<String>(psnl0111HusRoadNmZpcd, "99999");
		layoutContainer_1.add(psnl0111HusRoadNmZpcd, new FormData("100%"));
		psnl0111HusRoadNmZpcd.setFieldLabel("도로명주소");
		layoutContainer.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		layoutContainer_1.setBorders(false);


      
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
		FormLayout frmLay = new FormLayout();
		frmLay.setLabelWidth(0);
		layoutContainer_2.setLayout(frmLay);
		layoutContainer.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.42));
		layoutContainer_2.setBorders(false);

		psnl0111HusRoadNmFndtnAddr = new MSFTextField();
		layoutContainer_2.add(psnl0111HusRoadNmFndtnAddr, new FormData("100%"));
		// txtfldNewTextfield_1.setFieldLabel("New TextField");
		psnl0111HusRoadNmFndtnAddr.setLabelSeparator("");

		LayoutContainer layoutContainer_3 = new LayoutContainer();
		frmLay = new FormLayout();
		frmLay.setLabelWidth(0);
		layoutContainer_3.setLayout(frmLay);

		psnl0111HusRoadNmDtlPatrAddr = new TextField<String>();
		layoutContainer_3.add(psnl0111HusRoadNmDtlPatrAddr, new FormData("100%"));
		psnl0111HusRoadNmDtlPatrAddr.setLabelSeparator("");
		layoutContainer.add(layoutContainer_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		layoutContainer_3.setBorders(false);

		// LayoutContainer lcTabCol01 = new LayoutContainer(new ColumnLayout());
		LayoutContainer lcTabCol02 = new LayoutContainer(new ColumnLayout());
		LayoutContainer lcTabCol03 = new LayoutContainer(new ColumnLayout());
		//LayoutContainer lcTabCol04 = new LayoutContainer(new ColumnLayout());

		LayoutContainer lcStdLeft01 = new LayoutContainer();
		//lcStdLeft01.setStyleAttribute("paddingRight", "0px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdLeft01.setLayout(frmlytStd);

		LayoutContainer lcStdLeft02 = new LayoutContainer();
		//lcStdLeft02.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdLeft02.setLayout(frmlytStd);

		LayoutContainer lcStdCenter02 = new LayoutContainer();
		//lcStdCenter02.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdCenter02.setLayout(frmlytStd);

		LayoutContainer lcStdLeft03 = new LayoutContainer();
		//lcStdLeft03.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdLeft03.setLayout(frmlytStd);

		LayoutContainer lcStdCenter03 = new LayoutContainer();
		//lcStdCenter03.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdCenter03.setLayout(frmlytStd);

		// Button topBtn = new Button("조회");
		// topBtn.setIcon(PayGenApp.ICONS.accordion());

		ContentPanel cp01 = new ContentPanel();
		cp01.setHeaderVisible(false);
		cp01.setFrame(true);
		cp01.setSize(968, 213);
		cp01.setLayout(new FitLayout());

		// buttonBar01.setAlignment(HorizontalAlignment.LEFT);
		// buttonBar01.add(topBtn);

		// lcRowCol01.add(lcStdLeft01, new RowData(.5, 1));
		// lcRowCol01.add(buttonBar01, new RowData(.5, 1));

		// lcTabCol01.add(lcStdLeft01,new
		// com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		// lcTabCol01.add(lcStdCenter01,new
		// com.extjs.gxt.ui.client.widget.layout.ColumnData(-1));

		cp01.add(lcStd01);

		lcStd01.add(layoutContainer, new FormData("100%"));
		layoutContainer.setBorders(false);

		LayoutContainer layoutContainer_9 = new LayoutContainer();
		layoutContainer_9.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_10 = new LayoutContainer();
		layoutContainer_10.setLayout(new FormLayout());

		final TextField<String> txtfldNewTextfield_8 = new TextField<String>();
		txtfldNewTextfield_8.setRegex("^[0-9]+$");
		layoutContainer_10.add(txtfldNewTextfield_8, new FormData("100%"));
		txtfldNewTextfield_8.setFieldLabel("생활근거지");
		layoutContainer_9.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		layoutContainer_10.setBorders(false);

		LayoutContainer layoutContainer_8 = new LayoutContainer();
		frmLay = new FormLayout();
		frmLay.setLabelWidth(0);
		layoutContainer_8.setLayout(frmLay);

		psnl0111BthcAddr = new TextField<String>();
		layoutContainer_8.add(psnl0111BthcAddr, new FormData("100%"));
		// txtfldNewTextfield_2.setFieldLabel("New TextField");
		psnl0111BthcAddr.setLabelSeparator("");
		layoutContainer_9.add(layoutContainer_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.8));
		layoutContainer_8.setBorders(false);
		lcStd01.add(layoutContainer_9, new FormData("99.5%"));
		layoutContainer_9.setBorders(false);

		psnl0111HfmlyNm = new TextField<String>();
		psnl0111HfmlyNm.setFieldLabel("세대주");
		lcStdLeft03.add(psnl0111HfmlyNm, new FormData("95%"));
		
		psnl0111HusPhnNum = new TextField<String>();
		psnl0111HusPhnNum.setFieldLabel("전화번호");
		lcStdLeft03.add(psnl0111HusPhnNum, new FormData("95%"));
		
		LayoutContainer layoutContainer11 = new LayoutContainer(new ColumnLayout());
		layoutContainer11.setBorders(false);
		
		LayoutContainer lcTabLeft = new LayoutContainer(new ColumnLayout());
		LayoutContainer lcTabCenter = new LayoutContainer();
		LayoutContainer lcTabRight = new LayoutContainer();
		
		
		LayoutContainer lcTabLeft1_1 = new LayoutContainer();
		styBgnnDt = new DateField();
		new DateFieldMask(styBgnnDt, "9999.99.99");
		styBgnnDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		FormLayout frmlytStd1_1 = new FormLayout();
		frmlytStd1_1.setLabelWidth(100);
		frmlytStd1_1.setLabelAlign(LabelAlign.RIGHT);
		lcTabLeft1_1.setLayout(frmlytStd1_1);
		styBgnnDt.setFieldLabel("체류기간");
		lcTabLeft1_1.add(styBgnnDt, new FormData("100%"));
		lcTabLeft.add(lcTabLeft1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		
		LayoutContainer lcTabLeft1_2 = new LayoutContainer();
		styEndDt = new DateField();
		new DateFieldMask(styEndDt, "9999.99.99");
		styEndDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		FormLayout frmlytStd1_2 = new FormLayout();
		frmlytStd1_2.setLabelWidth(10);
		frmlytStd1_2.setLabelAlign(LabelAlign.RIGHT);
		lcTabLeft1_2.setLayout(frmlytStd1_2);
//		styEndDt.setFieldLabel("~");
		styEndDt.setLabelSeparator("~");
		lcTabLeft1_2.add(styEndDt, new FormData("90%"));
		lcTabLeft.add(lcTabLeft1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));


		psnl0111HfmlyRelaCd = new ComboBox<BaseModel>();
		FormLayout frmlytStd1_3 = new FormLayout();
		frmlytStd1_3.setLabelWidth(80);
		frmlytStd1_3.setLabelAlign(LabelAlign.RIGHT);
		lcStdCenter03.setLayout(frmlytStd1_3);
		psnl0111HfmlyRelaCd.setFieldLabel("관 계");
		psnl0111HfmlyRelaCd.setForceSelection(true);
		psnl0111HfmlyRelaCd.setMinChars(1);
		psnl0111HfmlyRelaCd.setDisplayField("commCdNm");
		psnl0111HfmlyRelaCd.setValueField("commCd");
		psnl0111HfmlyRelaCd.setTriggerAction(TriggerAction.ALL);
		psnl0111HfmlyRelaCd.setEmptyText("--관계선택--");
		psnl0111HfmlyRelaCd.setSelectOnFocus(true);
		psnl0111HfmlyRelaCd.setStore(listStoreA019);
		lcStdCenter03.add(psnl0111HfmlyRelaCd, new FormData("50%"));
		
		
		LayoutContainer lcStdCenter03_0 = new LayoutContainer(new ColumnLayout());
		
		LayoutContainer lcStdCenter03_1 = new LayoutContainer();
		psnl0111CellPhneNum = new MSFTextField();
		FormLayout frmlytStd03_1 = new FormLayout();
		frmlytStd03_1.setLabelWidth(80);
		frmlytStd03_1.setLabelAlign(LabelAlign.RIGHT);
		lcStdCenter03_1.setLayout(frmlytStd03_1);
		psnl0111CellPhneNum.setFieldLabel("핸드폰");
//		lcStdCenter03.add(psnl0111CellPhneNum, new FormData("100%"));
		lcStdCenter03_1.add(psnl0111CellPhneNum, new FormData("100%"));
		lcStdCenter03_0.add(lcStdCenter03_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		

//		psnl0111CellPhneNum = new MSFTextField();
//		psnl0111CellPhneNum.setFieldLabel("핸드폰");
//		lcStdCenter03.add(psnl0111CellPhneNum, new FormData("100%"));

		LabelField company07 = new LabelField();
		lcStdCenter02.add(company07, new FormData("100%"));

		LayoutContainer lcStdCenter03_2 = new LayoutContainer();
		psnl0111EmailAddr = new TextField<String>();
		FormLayout frmlytStd1_4 = new FormLayout();
		frmlytStd1_4.setLabelWidth(80);
		frmlytStd1_4.setLabelAlign(LabelAlign.RIGHT);
		lcStdCenter03_2.setLayout(frmlytStd1_4);
		psnl0111EmailAddr.setFieldLabel("이메일");
//		psnl0111EmailAddr = new MSFTextField();
//		psnl0111EmailAddr.setFieldLabel("이메일");
		psnl0111EmailAddr.setValidator(new Validator() {
			@Override
			public String validate(Field<?> field, String value) {
				return value.matches(RegEx.EMAIL) ? null : "이메일 체크!";
			}
		});
		//psnl0111EmailAddr.setRegex(RegEx.EMAIL);
		lcStdCenter03_2.add(psnl0111EmailAddr, new FormData("99.5%"));
//		lcStdCenter02.add(psnl0111EmailAddr, new FormData("90%"));
		lcStdCenter03_0.add(lcStdCenter03_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		lcStdCenter03.add(lcStdCenter03_0, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		lcTabCol03.add(lcStdLeft03, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		lcTabCol03.add(lcStdCenter03, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
//		lcTabCol03.add(lcStdLeft03, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
//		lcTabCol03.add(lcStdCenter03, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		lcStdLeft02.add(lcTabCol03, new FormData("100%"));

//		lcTabCol02.add(lcStdLeft02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.65));
		lcTabCol02.add(lcStdLeft02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
//		lcTabCol02.add(lcStdCenter02, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));

		lcStd01.add(lcTabCol02, new FormData("100%"));
		
		
		
		
		frgnrDivCd = new ComboBox<BaseModel>();
		FormLayout frmlytStd1_5 = new FormLayout();
		frmlytStd1_5.setLabelWidth(80);
		frmlytStd1_5.setLabelAlign(LabelAlign.RIGHT);
		lcTabCenter.setLayout(frmlytStd1_5);
		frgnrDivCd.setFieldLabel("외국인구분");
		frgnrDivCd.setName("socnsrAqtnRegVal05");
		frgnrDivCd.setForceSelection(true);
		frgnrDivCd.setMinChars(1);
		frgnrDivCd.setDisplayField("commCdNm");
		frgnrDivCd.setValueField("commCd");
		frgnrDivCd.setTriggerAction(TriggerAction.ALL);
		frgnrDivCd.setEmptyText("--외국인구분--");
		frgnrDivCd.setSelectOnFocus(true); 
		frgnrDivCd.setStore(lsSocnsrAqtnRegVal05);  
		lcTabCenter.add(frgnrDivCd, new FormData("100%"));
		
		
		psptNum = new TextField<String>();
		FormLayout frmlytStd1_6 = new FormLayout();
		frmlytStd1_6.setLabelWidth(80);
		frmlytStd1_6.setLabelAlign(LabelAlign.RIGHT);
		lcTabRight.setLayout(frmlytStd1_6);
		psptNum.setFieldLabel("여권번호");
		lcTabRight.add(psptNum, new FormData("99.5%"));
		
		
		layoutContainer11.add(lcTabLeft, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer11.add(lcTabCenter, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		layoutContainer11.add(lcTabRight, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		lcStd01.add(layoutContainer11, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));

		pernNoteCtnt = new MSFTextArea();
		pernNoteCtnt.setFieldLabel("비고");
		pernNoteCtnt.setSize(940, 40);
		lcStd01.add(pernNoteCtnt, new FormData("99.5%"));

		cp01.addButton(new Button("저장", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				if(psnl0100Grid.getSelectionModel().getSelectedItem() != null ) {
					
//					if(!psnl0111EmailAddr.isValid()){
//						return;
//					}
					if(!psnl0111HusRoadNmZpcd.isValid()){
						MessageBox.info("입력필수사항 확인", "우편번호는 필수입니다.", null);
						return;
					}
					if(!psnl0111HusRoadNmFndtnAddr.isValid()){
						MessageBox.info("입력필수사항 확인", "도로명주소는 필수입니다.", null);
						return;
					}
					if(!psnl0111CellPhneNum.isValid()){
						MessageBox.info("입력필수사항 확인", "핸드폰번호는 필수입니다.", null);
						return;
					}
					if(psnl0100Grid.getSelectionModel().getSelectedItem() != null ) {
						MessageBox.confirm("인적 저장", "인적정보를 저장하시겠습니까?",new Listener<MessageBoxEvent>(){
							
							@Override
							public void handleEvent(MessageBoxEvent be) {
								
								
								//인적 저장 처리
								//도로명주소1
								//로도명주소2
								//도로명주소3
								//생활근거지1
								//생활근거지2
								
								//if("Yes".equals(be.getButtonClicked().getText())){
								if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
									Psnl0111DTO saveForm = new Psnl0111DTO();
									
									saveForm.setWindowNm("PSNL0200");
									
									saveForm.setDpobCd(psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
									saveForm.setSystemkey(psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
									
									
									saveForm.setHusRoadNmZpcd(psnl0111HusRoadNmZpcd.getValue());					//도로명주소1
									if (MSFSharedUtils.paramNotNull(psnl0111HusRoadNmZpcd.getValue())) {
										if (MSFSharedUtils.paramNotNull(psnl0111HusRoadNmZpcd.getValue())) {
						            		if(psnl0111HusRoadNmZpcd.getValue().length() > 6) {
						            			MessageBox.alert("오류", "도로명주소(우편번호) 입력범위를 초과하였습니다.(최대 5자 이내)", null);
						            			return;
						            		}
					            		}
									}
									saveForm.setHusRoadNmFndtnAddr(psnl0111HusRoadNmFndtnAddr.getValue());			//도로명주소2
									saveForm.setHusRoadNmDtlPatrAddr(psnl0111HusRoadNmDtlPatrAddr.getValue());		//도로명주소3
									
				            		saveForm.setHusZpcd(txtfldNewTextfield_8.getValue());							//생활근거지1 HUS_ZPCD
				            		if (MSFSharedUtils.paramNotNull(txtfldNewTextfield_8.getValue())) {
				            			
				            			String strData = txtfldNewTextfield_8.getValue();
				            			
				            			// 숫자만 입력할 수 있게끔
				            			if(!typeCheck(strData)) {	// 리턴값이 false 일 경우(문자가 포함되어 있음)
				            				MessageBox.alert("오류", "생활근거지(우편번호) 숫자만 입력해주세요.(최대 6자 이내)", null);
					            			return;
				            			}
				            			
					            		if(txtfldNewTextfield_8.getValue().length() > 6) {
					            			MessageBox.alert("오류", "생활근거지(우편번호) 입력범위를 초과하였습니다.(최대 6자 이내)", null);
					            			return;
					            		}
				            		}
				            		saveForm.setHusFndtnAddr(psnl0111BthcAddr.getValue());							//생활근거지2 HUS_FNDTN_ADDR
				            		
				            		saveForm.setHfmlyNm(psnl0111HfmlyNm.getValue()); 									//호주
									saveForm.setHfmlyRelaCd(PersonalUtil.getSelectedComboValue(psnl0111HfmlyRelaCd)); 	//호주와의 관계
									
									saveForm.setHusPhnNum(psnl0111HusPhnNum.getValue()); 								//집전화번호
									saveForm.setCellPhneNum(psnl0111CellPhneNum.getValue()); 							//핸드폰
									saveForm.setEmailAddr(psnl0111EmailAddr.getValue()); 								//이메일
									
//									saveForm.setStyBgnnDt(PersonalUtil.getConvertDateToString(styBgnnDt, "yyyyMMdd"));//체류시작일자
//									saveForm.setStyEndDt(PersonalUtil.getConvertDateToString(styEndDt, "yyyyMMdd"));//체류종료일자
									saveForm.setStyBgnnDt(GWTUtils.getStringFromDate(styBgnnDt.getValue(), "yyyyMMdd"));//체류시작일자
									saveForm.setStyEndDt(GWTUtils.getStringFromDate(styEndDt.getValue(), "yyyyMMdd"));	//체류종료일자
									saveForm.setFrgnrDivCd(PersonalUtil.getSelectedComboValue(frgnrDivCd));				//외국인구분코드
									saveForm.setPsptNum(psptNum.getValue());											//여권번호
									
									saveForm.setPernNoteCtnt(pernNoteCtnt.getValue()); 									//비고
									
									psnl0111Service.savePsnl0111(saveForm, new AsyncCallback<Integer>() {
										
										@Override
										public void onSuccess(Integer result) {
											
											MessageBox.info("성공!", "저장되었습니다.", null);
										}
										
										@Override
										public void onFailure(Throwable caught) {
											
											MessageBox.alert("실패!", "저장실패! \n" + caught.getMessage(), null);
										}
									});
									
								}
							}
						});
					}
				}
			}
		}));

		lcTabFormLayer.add(cp01);
		return lcTabFormLayer;
	}

	// 고용
	private LayoutContainer Employment01() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();


		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		
		/*
		RowNumberer rn = new RowNumberer();
		rn.setHeader("순번");
		rn.setAlignment(HorizontalAlignment.CENTER);
		rn.setWidth(30);
		rn.setSortable(false);
		rn.setMenuDisabled(true);
		configs.add(rn);
		*/
		
		
		CheckColumnConfig checkColumn = new CheckColumnConfig();
		checkColumn.setId("delChk");
		checkColumn.setHeaderText("삭제");
		checkColumn.setWidth(40);
		CellEditor checkBoxEditor = new CellEditor(new CheckBox());  
		checkColumn.setEditor(checkBoxEditor);
	    checkColumn.setMenuDisabled(true);
	   // checkColumn.setFixed(true);
	    configs.add(checkColumn); 
		
	    
		/**
		공무직 화면으로 무조건 무기계약근로자만 선택하게 처리
		A0020020 : 기간제근로자
		A0020010 : 무기계약근로자
		**/
		final ComboBox<BaseModel> emymtDivCdCombo = new ComboBox<BaseModel>();  
		emymtDivCdCombo.setForceSelection(true);
		emymtDivCdCombo.setMinChars(1);
		emymtDivCdCombo.setDisplayField("commCdNm");
		emymtDivCdCombo.setValueField("commCd");
		emymtDivCdCombo.setForceSelection(true);  
		emymtDivCdCombo.setTriggerAction(TriggerAction.ALL);
		emymtDivCdCombo.setStore(listStoreA002);
		
	    CellEditor emymtDivCdEditor = new CellEditor(emymtDivCdCombo){
	    	@Override  
			public Object preProcessValue(Object value) {
				if (value == null) {
					return value;
				}
				return emymtDivCdCombo.getStore().findModel(PersonalUtil.getBaseModelComboDataCd(emymtDivCdCombo, String.valueOf(value)));
			}
	    
			@Override
			public Object postProcessValue(Object value) {
				if (value == null) {
					return value;
				}
				return ((BaseModel) value).get("commCd");
			}
	    };
	    
		
		ColumnConfig column = new ColumnConfig();
		column.setId("emymtDivCd");
		column.setHeaderText("고용구분");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(emymtDivCdEditor);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setRenderer(new GridCellRenderer<BaseModelData>() {
			@Override
			public Object render(BaseModelData model, String property,
					ColumnData config, int rowIndex, int colIndex,
					ListStore<BaseModelData> store, Grid<BaseModelData> grid) {
				
				if(emymtDivCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("emymtDivCd"))!= null){
					return emymtDivCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("emymtDivCd")).get("commCdNm");
				}else{
					return "";
				}
			}
		});
		configs.add(column);
		
		final ComboBox<BaseModel> emymtTypCdCombo = new ComboBox<BaseModel>();  
		emymtTypCdCombo.setForceSelection(true);
		emymtTypCdCombo.setMinChars(1);
		emymtTypCdCombo.setDisplayField("commCdNm");
		emymtTypCdCombo.setValueField("commCd");
		emymtTypCdCombo.setForceSelection(true);  
		emymtTypCdCombo.setTriggerAction(TriggerAction.ALL);
		emymtTypCdCombo.setStore(listStoreA042);
		CellEditor emymtTypCdEditor = new CellEditor(emymtTypCdCombo){
	    	@Override  
			public Object preProcessValue(Object value) {
				if (value == null) {
					return value;
				}
				return emymtTypCdCombo.getStore().findModel(PersonalUtil.getBaseModelComboDataCd(emymtTypCdCombo, String.valueOf(value)));
			}
	    
			@Override
			public Object postProcessValue(Object value) {
				if (value == null) {
					return value;
				}
				return ((BaseModel) value).get("commCd");
			}
	    };
		column = new ColumnConfig();
		column.setId("emymtTypCd");
		column.setHeaderText("고용유형");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setEditor(emymtTypCdEditor);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setRenderer(new GridCellRenderer<BaseModelData>() {
			@Override
			public Object render(BaseModelData model, String property,
					ColumnData config, int rowIndex, int colIndex,
					ListStore<BaseModelData> store, Grid<BaseModelData> grid) {
				
				if(emymtTypCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("emymtTypCd"))!= null){
					
//                  psnl0110Grid.getSelectionModel().getSelectedItem().setEmymtTypCd(emymtTypCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("emymtTypCd")).toString());
                  
					return emymtTypCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("emymtTypCd")).get("commCdNm");
				}else{
					return "";
				}
			}
		});
		configs.add(column);
		
		DateField emymtBgnnDtDateField = new DateField();
		new DateFieldMask(emymtBgnnDtDateField, "9999.99.99"); 
		emymtBgnnDtDateField.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		
		column = new ColumnConfig();
		column.setId("emymtBgnnDt");
		column.setHeaderText("시작일자");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setEditor(new CellEditor(emymtBgnnDtDateField));
	    column.setDateTimeFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
	    column.setSortable(false);
	    column.setMenuDisabled(true);
	    configs.add(column);

	    
	    DateField emymtEndDtDateField = new DateField();
	    new DateFieldMask(emymtEndDtDateField, "9999.99.99"); 
	    emymtEndDtDateField.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		
	    column = new ColumnConfig();
		column.setId("emymtEndDt");
		column.setHeaderText("종료일자");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setEditor(new CellEditor(emymtEndDtDateField));
	    column.setDateTimeFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
	    column.setSortable(false);
	    column.setMenuDisabled(true);
	    configs.add(column);
	    
//	    final ComboBox<BaseModel> deptCdCombo = new ComboBox<BaseModel>();  
//	    deptCdCombo.setForceSelection(true);
//	    deptCdCombo.setMinChars(1);
//	    deptCdCombo.setDisplayField("deptNmRtchnt");
//		deptCdCombo.setValueField("deptCd");
//		deptCdCombo.setForceSelection(true);  
//		deptCdCombo.setTriggerAction(TriggerAction.ALL);
//		deptCdCombo.setStore(listStoreBass0400All); 
//	    CellEditor deptCdEditor = new CellEditor(deptCdCombo){  
//	        @Override  
//	        public Object preProcessValue(Object value) {  
//	          if (value == null) {  
//	            return value;  
//	          }  
//	          return deptCdCombo.getStore().findModel(PersonalUtil.getBaseModelComboDataCd(deptCdCombo, String.valueOf(value), "deptCd"));  
//	        }  
//	    
//	        @Override  
//	        public Object postProcessValue(Object value) {  
//	          if (value == null) {  
//	            return value;  
//	          }  
//	          return ((BaseModel) value).get("deptCd");
//	        }  
//	    };
//	    
//	    
//	    column = new ColumnConfig();
//		column.setId("deptCd");
//		column.setHeaderText("부서");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(140);
//		column.setEditor(deptCdEditor);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		column.setRenderer(new GridCellRenderer<BaseModelData>() {
//
//			@Override
//			public Object render(BaseModelData model, String property,
//					ColumnData config, int rowIndex, int colIndex,
//					ListStore<BaseModelData> store, Grid<BaseModelData> grid) {
//				
//				if(deptCdCombo.getStore().findModel("deptCd",store.getModels().get(rowIndex).get("deptCd"))!= null){
//					return deptCdCombo.getStore().findModel("deptCd",store.getModels().get(rowIndex).get("deptCd")).get("deptNmRtchnt");
//				}else{
//					return "";
//				}
//			}
//		});
	    
	    column = new ColumnConfig();
      column.setId("deptCd");
      column.setHeaderText("");
      column.setAlignment(HorizontalAlignment.CENTER);
      column.setWidth(0);
      column.setEditor(new CellEditor(new TextField<String>())); 
      column.setSortable(false);
      column.setHidden(true);
      column.setMenuDisabled(false);  
      column.setRenderer(new GridCellRenderer<BaseModelData>() {

        @Override
        public Object render(BaseModelData model, String property,
                ColumnData config, int rowIndex, int colIndex,
                ListStore<BaseModelData> store, Grid<BaseModelData> grid) {
            
              String btnText = model.get(property) == null ? "" : (String)model.get(property);
               
              return btnText;  
        }
    });
      configs.add(column);
      
	    
	        Button btnDeptCd = new Button("");
	       
	        btnDeptCd.setIcon(MSFMainApp.ICONS.search());
	       
	        //final MSFTextFieldButton<String> msfDeptTxtBtn = new MSFTextFieldButton<String>(btnDeptCd);
	        final PrgmDeptFieldButton<String> msfDeptTxtBtn = new PrgmDeptFieldButton<String>(); 
	      
	        column = new ColumnConfig();
	        column.setId("deptNm");
	        column.setHeaderText("부서");
	        column.setAlignment(HorizontalAlignment.LEFT);
	        column.setWidth(150);
	        column.setEditor(new CellEditor(msfDeptTxtBtn)); 
	        column.setSortable(false);
	        column.setMenuDisabled(true);
	        column.setRenderer(new GridCellRenderer<BaseModelData>() {
	//-------------------------
	            @Override
	            public Object render(final BaseModelData model, String property,
	                    final ColumnData config, final int rowIndex, final int colIndex,
	                    final ListStore<BaseModelData> store,  Grid<BaseModelData> grid) {
	                  
	                String btnText = model.get(property) == null ? "" : (String)model.get(property);
	              //  if("".equals(btnText)){
	              //      return "";
	               // }else{
	                    msfDeptTxtBtn.addListener(Events.Change, new Listener<BaseEvent>() { 
	                        public void handleEvent(BaseEvent be) {
	                             
	                            BaseModel mapModel = (BaseModel)be.getSource(); 
	                            if (!"".equals(mapModel.get("deptCd"))) {   
	                                if (psnl0200RowIndex == rowIndex) { 
	                                   // String htmlAttr = "'background-color:yellow; background-image: url(gray_gradient.gif);background-repeat: no-repeat;background-position:50%;'";
	                                    //  String changeStyle = "<span style='font-weight: bold;color:red'>√</span>";  
	                                    //  store.getAt(rowIndex).set("schlCd",String.valueOf(popBindingInner.getModel().get("commCd")));
	                                   // config.style = "background-color: silver;";
	                                    store.getAt(rowIndex).set("deptCd",String.valueOf(mapModel.get("deptCd"))); 
	                                    store.getAt(rowIndex).set("deptNm",String.valueOf(mapModel.get("deptNmRtchnt"))); 
	                                    store.update(store.getAt(rowIndex));
	                                    store.getRecord(store.getAt(rowIndex)).setDirty(true);  
	                                    psnl0200RowIndex = -1;
	                                    psnl0200ColIndex = -1;
	                                    psnl0110Grid.getSelectionModel().getSelectedItem().setBusinCd("");
	                                    
//	                                   if (MSFSharedUtils.paramNotNull(mapModel.get("deptCd"))) { 
//  	                                    PrgmComBass0500DTO sysComBass0500Dto = new PrgmComBass0500DTO();
//                                          sysComBass0500Dto.setBusinApptnYr("");  //DateTimeFormat.getFormat("yyyy").format(new Date())
//                                          sysComBass0500Dto.setDeptCd(String.valueOf(mapModel.get("deptCd")));
//  	                                    //사업명코드 가져오기
//  	                                    psnl0100Service.getBusinList(sysComBass0500Dto, new AsyncCallback<List<BaseModel>>() {
//  	                                        
//  	                                        @Override
//  	                                        public void onSuccess(List<BaseModel> result) {
//  	                                            
//  	                                            listStoreYearBusin.add(result);
//  	                                            businCdCombo.setStore(listStoreYearBusin); 
//  	                                        }
//  	                                        
//  	                                        @Override
//  	                                        public void onFailure(Throwable caught) {
//  	                                            
//  	                                            MessageBox.alert("", "사업명코드 에러!", null);
//  	                                        }
//  	                                    });
//	                                   }
	                                
	                                }
	                            }
	                        }
	                    }); 
	                    
	                    msfDeptTxtBtn.addKeyListener(new KeyListener(){
	        				@Override
	        				public void componentKeyDown(ComponentEvent event) {
	        					if(event.getKeyCode() == KeyCodes.KEY_ENTER){  
	        						
	        						 msfDeptTxtBtn.addListener(Events.Select, new Listener<BaseEvent>() { 
	        		                        public void handleEvent(BaseEvent be) {
	        		                             
	        		                            BaseModel mapModel = (BaseModel)be.getSource(); 
	        						 
	        		                            if (!"".equals(mapModel.get("deptCd")) && "".equals(mapModel.get("businCd"))) {   
	        		                                
	        		                                if (psnl0200RowIndex == rowIndex) { 
	        		                                	
	        		                                    store.getAt(rowIndex).set("deptCd",String.valueOf(mapModel.get("deptCd"))); 
	        		                                    store.getAt(rowIndex).set("deptNm",String.valueOf(mapModel.get("deptNmRtchnt"))); 
	        		                                    store.update(store.getAt(rowIndex));
	        		                                    store.getRecord(store.getAt(rowIndex)).setDirty(true);  
	        		                                    psnl0200RowIndex = -1;
	        		                                    psnl0200ColIndex = -1;
	        		                                    psnl0110Grid.getSelectionModel().getSelectedItem().setBusinCd("");
	        		                                }
	        		                            }
	        		                        }
	        		                    }); 
//	        						 store.getModels().get(index)
	        					}
//	        					else if(event.getKeyCode() == KeyCodes.KEY_SHIFT){
//	        					onFocus(c);
//	        					}
	        				}
	        			});
	                    
	                    return btnText;
	               // } 
	 
	            }
	            
	        });
		configs.add(column); 
		
		businCdCombo = new ComboBox<BaseModel>();  
		businCdCombo.setForceSelection(true);
		businCdCombo.setMinChars(1);
		businCdCombo.setDisplayField("businNm");
		businCdCombo.setValueField("businCd");
		businCdCombo.setForceSelection(true);  
		businCdCombo.setTriggerAction(TriggerAction.ALL);
		businCdCombo.setStore(listStoreYearBusin);
		
	    CellEditor businCdEditor = new CellEditor(businCdCombo){  
	        @Override  
	        public Object preProcessValue(Object value) {  
	            
	            String deptCd = psnl0110Grid.getSelectionModel().getSelectedItem().getDeptCd() == null ? "" : psnl0110Grid.getSelectionModel().getSelectedItem().getDeptCd();
	            String businApptnYr = psnl0110Grid.getSelectionModel().getSelectedItem().getEmymtBgnnDt() == null ? "" 
	                    : GWTUtils.getStringFromDate(psnl0110Grid.getSelectionModel().getSelectedItem().getEmymtBgnnDt(), "yyyyMMdd").substring(0, 4);
//	            		: psnl0110Grid.getSelectionModel().getSelectedItem().getEmymtBgnnDt();
	            final String businCd = String.valueOf(psnl0110Grid.getSelectionModel().getSelectedItem().getBusinCd());
	            
//	            MessageBox.info("처음 진입", businCd + " > 이다.", null);
	            
	            
	            if( deptCd != null && !"".equals(deptCd) && businCd == null || "".equals(businCd)){
	            	
//	            	MessageBox.info("", "기존 조건", null);
//	            	MessageBox.info("사업코드 <", businCd + " > 이다.", null);
	            	
                  //관련된 사업 넣기위한 템프 스토어리스트
	                tempListStore01 = new ListStore<BaseModel>();
              //  String typComboOccuCd =  psnl0110Grid.getSelectionModel().getSelectedItem().getTypOccuCd();
                  for(int i = 0; i < listStoreYearBusin.getCount(); i++){
                      //TODO 주의할것...구분자반드시처리..
                      if(deptCd.equals(String.valueOf(listStoreYearBusin.getAt(i).get("deptCd"))) && businApptnYr.equals(String.valueOf(listStoreYearBusin.getAt(i).get("businApptnYr")) )){ 
                      	tempListStore01.add(listStoreYearBusin.getAt(i));
                      } 
                  }
                  final PrgmComBass0500DTO dto = new PrgmComBass0500DTO();
                  dto.setBusinApptnYr(businApptnYr);  //DateTimeFormat.getFormat("yyyy").format(new Date())
                  dto.setDeptCd(deptCd); 
              
                //--------------------사업 불러 오는 함수 -------------------------------------------------
                  tempListStore01 = PrgmComComboUtils.getDeptWithBass0500ComboData(dto);
                 //--------------------사업 불러 오는 함수 -------------------------------------------------
                  tempListStore01.addStoreListener( new StoreListener<BaseModel>() {   
                      public void handleEvent(StoreEvent<BaseModel> be) {  

                          businCdCombo.setStore(tempListStore01);
                          
                          for(int i = 0; i < tempListStore01.getCount(); i++){
                      		//TODO 주의할것...구분자반드시처리..
                      		businCdCombo.setStore(tempListStore01);
                           }
//                          listStoreYearBusin = PrgmComComboUtils.getDeptWithBass0500ComboData(dto);
//						    businCdCombo.setStore(listStoreYearBusin);
                      }
                  });
              }else if(deptCd != null && !"".equals(deptCd) && businCd != null || !"".equals(businCd)) {
              	
//              	MessageBox.info("부서코드가 있다. < ", businCd + " >", null);
              	
              	 //관련된 사업 넣기위한 템프 스토어리스트
	                tempListStore01 = new ListStore<BaseModel>();
              //  String typComboOccuCd =  psnl0110Grid.getSelectionModel().getSelectedItem().getTypOccuCd();
                  for(int i = 0; i < listStoreYearBusin.getCount(); i++){
                      //TODO 주의할것...구분자반드시처리..
                      if(deptCd.equals(String.valueOf(listStoreYearBusin.getAt(i).get("deptCd"))) && businApptnYr.equals(String.valueOf(listStoreYearBusin.getAt(i).get("businApptnYr")) )){ 
                      	tempListStore01.add(listStoreYearBusin.getAt(i));
                      } 
                  }
                  final PrgmComBass0500DTO dto = new PrgmComBass0500DTO();
                  dto.setBusinApptnYr(businApptnYr);  //DateTimeFormat.getFormat("yyyy").format(new Date())
                  dto.setDeptCd(deptCd); 
              
                //--------------------사업 불러 오는 함수 -------------------------------------------------
                  tempListStore01 = PrgmComComboUtils.getDeptWithBass0500ComboData(dto);
                 //--------------------사업 불러 오는 함수 -------------------------------------------------
                  tempListStore01.addStoreListener( new StoreListener<BaseModel>() {   
                      public void handleEvent(StoreEvent<BaseModel> be) {  
                      	
                          businCdCombo.setStore(tempListStore01);
                          
                          for(int i = 0; i < tempListStore01.getCount(); i++){
                      		//TODO 주의할것...구분자반드시처리..
                      		businCdCombo.setStore(tempListStore01);
                           }
                          PersonalUtil.setSelectedComboValue(businCdCombo, businCd, "businCd");
                      }
                  });
              }else{
//              	MessageBox.info("", "CellEditor 안탔다.", null);
	            	
	            	businCdCombo.setStore(new ListStore<BaseModel>());
                  businCdCombo.setValue(new BaseModel());
              }
              
	            if (value == null) {  
//	            	MessageBox.info("널 일때 <", String.valueOf(value) + ">", null);
	            	return value;  
	            }else {
//	        		MessageBox.info("아닐때 <", String.valueOf(value) + ">", null);
	        		value = psnl0110Grid.getSelectionModel().getSelectedItem().getBusinCd();
	        	}
	            
	            return businCdCombo.getStore().findModel(PersonalUtil.getBaseModelComboDataCd(businCdCombo, String.valueOf(value),"businCd"));  
	        }  
	    
	        @Override  
	        public Object postProcessValue(Object value) {  
	        	if (value == null) {  
	        		return value;  
	        	}
	        	return ((BaseModel) value).get("businCd");
	        }  
	    };
	    
	    
	    column = new ColumnConfig();
		column.setId("businCd");
		column.setHeaderText("사업명");
		column.setAlignment(HorizontalAlignment.LEFT);
		column.setWidth(200);
		column.setEditor(businCdEditor);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setRenderer(new GridCellRenderer<BaseModelData>() { 
			@Override
			public Object render(BaseModelData model, String property,
					ColumnData config, int rowIndex, int colIndex,
					ListStore<BaseModelData> store, Grid<BaseModelData> grid) {
				 
				//if(businCdCombo.getStore().findModel("businCd",store.getModels().get(rowIndex).get("businCd"))!= null){
				if((store.getModels().get(rowIndex).get("deptCd")!= null) && (store.getModels().get(rowIndex).get("businCd")!= null)){
				    
				    String deptCd = store.getModels().get(rowIndex).get("deptCd") == null ? "" : String.valueOf(store.getModels().get(rowIndex).get("deptCd"));
	                String businApptnYr = store.getModels().get(rowIndex).get("emymtBgnnDt") == null ? "" 
	                        : GWTUtils.getStringFromDate((Date)store.getModels().get(rowIndex).get("emymtBgnnDt"), "yyyyMMdd").substring(0, 4);
	                
	                String businCd = store.getModels().get(rowIndex).get("businCd") == null ? "" : String.valueOf(store.getModels().get(rowIndex).get("businCd"));
	                   
	                if( deptCd != null && !"".equals(deptCd)){
	                	
	                	//TODO 초기화
	                	businCdCombo.setStore(new ListStore<BaseModel>());
	                    businCdCombo.setValue(new BaseModel());
	                    
	                    //관련된 사업을 넣기위한 템프 스토어리스트
	                    ListStore<BaseModel> tempListStore = new ListStore<BaseModel>(); 
	                    for(int i = 0; i < listStoreYearBusin.getCount(); i++){
	                     
	                        if(deptCd.equals(String.valueOf(listStoreYearBusin.getAt(i).get("deptCd"))) && businApptnYr.equals(String.valueOf(listStoreYearBusin.getAt(i).get("businApptnYr")) )){ 
	                              tempListStore.add(listStoreYearBusin.getAt(i));
	                        } 
	                    }
	                    
	                    
	                    
//	                    PrgmComBass0500DTO dto = new PrgmComBass0500DTO();
//	                    dto.setBusinApptnYr(businApptnYr);  //DateTimeFormat.getFormat("yyyy").format(new Date())
//	                    dto.setDeptCd(deptCd); 
	                
	                  //--------------------사업 불러 오는 함수 -------------------------------------------------
//	                    tempListStore = PrgmComComboUtils.getDeptWithBass0500ComboData(dto);
	                   //--------------------사업 불러 오는 함수 -------------------------------------------------
//	                    tempListStore.addStoreListener( new StoreListener<BaseModel>() {   
//	                        public void handleEvent(StoreEvent<BaseModel> be) {  
//	                            businCdCombo.setStore(tempListStore); 
//	                        }
//	                    });
	                    businCdCombo.setStore(tempListStore); 
	                    if (businCdCombo.getStore().findModel("businCd",store.getModels().get(rowIndex).get("businCd")) != null) {
	                        return businCdCombo.getStore().findModel("businCd",store.getModels().get(rowIndex).get("businCd")).get("businNm");
	                    } else {
	                        return "";
	                    }
	                   
	                }else{
	                    businCdCombo.setStore(new ListStore<BaseModel>());
	                    businCdCombo.setValue(new BaseModel());
	                    return "";
	                }  
				}else{
					return "";
				}
			}
		});
		configs.add(column);
	   
		
		
		column = new ColumnConfig();
		column.setId("currPaeWorkNm");
		column.setHeaderText("현근무지");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		TextField<String> currPaeWorkNmText = new TextField<String>();
		//currPaeWorkNmText.setAllowBlank(false); //필드값을 빈값으로 설정가능한지 체크
		column.setEditor(new CellEditor(currPaeWorkNmText));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);

		
		final ComboBox<BaseModel> odtyCdCombo = new ComboBox<BaseModel>();  
		odtyCdCombo.setForceSelection(true);
		odtyCdCombo.setMinChars(1);
		odtyCdCombo.setDisplayField("commCdNm");
		odtyCdCombo.setValueField("commCd");
		odtyCdCombo.setForceSelection(true);  
		odtyCdCombo.setTriggerAction(TriggerAction.ALL);
		odtyCdCombo.setStore(listStoreA015);
	    
	    
	    CellEditor odtyCdEditor = new CellEditor(odtyCdCombo){  
	        @Override  
	        public Object preProcessValue(Object value) {  
	          if (value == null) {  
	            return value;  
	          }  
	          return odtyCdCombo.getStore().findModel(PersonalUtil.getBaseModelComboDataCd(odtyCdCombo, String.valueOf(value)));  
	        }  
	    
	        @Override  
	        public Object postProcessValue(Object value) {  
	          if (value == null) {  
	            return value;  
	          }  
	          return ((BaseModel) value).get("commCd");
	        }  
	    };
		
		column = new ColumnConfig();
		column.setId("odtyCd");
		column.setHeaderText("직 책");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setEditor(odtyCdEditor);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setRenderer(new GridCellRenderer<BaseModelData>() {

			@Override
			public Object render(BaseModelData model, String property,
					ColumnData config, int rowIndex, int colIndex,
					ListStore<BaseModelData> store, Grid<BaseModelData> grid) {
				
				if(odtyCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("odtyCd"))!= null){
					return odtyCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("odtyCd")).get("commCdNm");
				}else{
					return "";
				}
			}
		});
		configs.add(column);


		column = new ColumnConfig();
		column.setId("workHourStandard");
		column.setHeaderText("일근무시간");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		TextField<String> workHourStandardText = new TextField<String>();
		//currPaeWorkNmText.setAllowBlank(false); //필드값을 빈값으로 설정가능한지 체크
		column.setEditor(new CellEditor(workHourStandardText));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);

		
		final ComboBox<BaseModel> retryDivCombo = new ComboBox<BaseModel>();  
		retryDivCombo.setForceSelection(true);
		retryDivCombo.setMinChars(1);
		retryDivCombo.setDisplayField("commCdNm");
		retryDivCombo.setValueField("commCd");
		retryDivCombo.setForceSelection(true);  
		retryDivCombo.setTriggerAction(TriggerAction.ALL);
		retryDivCombo.setStore(listStoreA050);
	    
	    CellEditor retryDivEditor = new CellEditor(retryDivCombo){  
	        @Override  
	        public Object preProcessValue(Object value) {  
	          if (value == null) {  
	            return value;  
	          }  
	          return retryDivCombo.getStore().findModel(PersonalUtil.getBaseModelComboDataCd(retryDivCombo, String.valueOf(value)));  
	        }  
	    
	        @Override  
	        public Object postProcessValue(Object value) {  
	          if (value == null) {  
	            return value;  
	          }  
	          return ((BaseModel) value).get("commCd");
	        }  
	    };
		
		
		
		column = new ColumnConfig();
		column.setId("retryDivCd");
		column.setHeaderText("퇴직사유구분");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setEditor(retryDivEditor);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setRenderer(new GridCellRenderer<BaseModelData>() {
			@Override
			public Object render(BaseModelData model, String property,
					ColumnData config, int rowIndex, int colIndex,
					ListStore<BaseModelData> store, Grid<BaseModelData> grid) {
				
				if(retryDivCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("retryDivCd"))!= null){
					return retryDivCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("retryDivCd")).get("commCdNm");
				}else{
					return "";
				}
			}
		});
		configs.add(column);
		
		
		column = new ColumnConfig();
		column.setId("retryReasCtnt");
		column.setHeaderText("퇴직사유내용");
		column.setAlignment(HorizontalAlignment.LEFT);
		column.setWidth(150);
		TextField<String> retryReasCtntText = new TextField<String>();
		//emymtReasCtntText.setAllowBlank(false); //필드값을 빈값으로 설정가능한지 체크
		column.setEditor(new CellEditor(retryReasCtntText));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);
		
		
		column = new ColumnConfig();
		column.setId("emymtReasCtnt");
		column.setHeaderText("비고");
		column.setAlignment(HorizontalAlignment.LEFT);
		column.setWidth(150);
		TextField<String> emymtReasCtntText = new TextField<String>();
		//emymtReasCtntText.setAllowBlank(false); //필드값을 빈값으로 설정가능한지 체크
		column.setEditor(new CellEditor(emymtReasCtntText));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);
		
		ColumnModel cm = new ColumnModel(configs);
		
		
		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(968, 213);

		psnl0110Grid = new EditorGrid<Psnl0110DTO>(psnl0110Store, cm);
		
		psnl0110Grid.setStateId("psnl0110Grid");
		psnl0110Grid.setStateful(false);
		psnl0110Grid.setLoadMask(true); // 작업중표시
		//psnl0110Grid.setAutoExpandColumn("emymtReasCtnt");;
		psnl0110Grid.setBorders(true);
		psnl0110Grid.addPlugin(checkColumn);
		//psnl0110Grid.setAutoWidth(true);
		psnl0110Grid.setColumnResize(true);
		
		psnl0110Grid.addListener(Events.CellMouseUp, new Listener<GridEvent<Psnl0110DTO>>() {

			@Override
			public void handleEvent(GridEvent<Psnl0110DTO> be) {
				
				
				if(be.getColIndex() == 0){
					if(be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())).getDelChk()){
						if(be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())).getDpobCd() == null){ //dpobCd데이터가 없으면 신규추가이므로 해당 로우를 삭제처리
							be.getGrid().getStore().remove(be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())));
						}
					}
				}
			}
			
		});
		
		  psnl0110Grid.addListener(Events.CellMouseDown, new Listener<GridEvent<Psnl0110DTO>>() {

	            @Override
	            public void handleEvent(GridEvent<Psnl0110DTO> be) {
	               String colId =   be.getGrid().getColumnModel().getColumnId(be.getColIndex());
	               if ("deptNm".equals(colId)) {
	                   psnl0200RowIndex = be.getRowIndex();
	                   psnl0200ColIndex = be.getColIndex();
	               } else {
	                   psnl0200RowIndex = -1;
	                   psnl0200ColIndex = -1;
	               }
	               
	                
	            }
	            
	        });
		
		
		cp01.add(psnl0110Grid);
		//psnl0110Grid.setWidth("40px");

		cp01.addButton(new Button("신규", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				Psnl0110DTO tempData = new Psnl0110DTO();
				tempData.setEmymtDivCd("A0020020");
				
				if(psnl0110Store.getCount() > 0 && psnl0110Store.getAt(0).getDpobCd() == null){ //이미 등록을 하기위한 데이터가 있을경우
					MessageBox.info("", "먼저 추가한 데이터를 저장후 추가해주세요.", null);
				}else{
					psnl0110Grid.stopEditing();
					tempData.setDelChk(false);
					psnl0110Store.insert(tempData, 0);
					psnl0110Grid.startEditing(psnl0110Store.indexOf(tempData), 2); 
				}
				
				
			}
		}));

		cp01.addButton(new Button("저장", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				
				if(psnl0100Grid.getSelectionModel().getSelectedItem() != null ) {
				    
				    
					MessageBox.confirm("고용 저장", "고용정보를 저장하시겠습니까?",new Listener<MessageBoxEvent>(){

						@Override
						public void handleEvent(MessageBoxEvent be) { 
						//	if("Yes".equals(be.getButtonClicked().getText())){
							if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
								if(psnl0110Grid.getSelectionModel().getSelectedItem().getDelChk() == true) {
									MessageBox.confirm("고용 삭제", "삭제가 체크되어있습니다. 계속 진행하시겠습니까?<br>(삭제된 데이터는 복구되지 않습니다.)",new Listener<MessageBoxEvent>(){
										@Override
										public void handleEvent(MessageBoxEvent be) {
											// TODO Auto-generated method stub
										//	if("No".equals(be.getButtonClicked().getText())){
											if(Dialog.NO.equals(be.getButtonClicked().getItemId())){
												return;
											}else if(Dialog.YES.equals(be.getButtonClicked().getItemId())){ 
											//	if("Yes".equals(be.getButtonClicked().getText())){
												savePsnl0110();
											}
										}
									});
								}else {
									savePsnl0110();
								}
								
//							    boolean checkRow = false;
//								//변경된 데이터 담기
//								ArrayList<Psnl0110DTO>changePsnl0110List = new ArrayList<Psnl0110DTO>();
//								for ( int i = 0; i < psnl0110Store.getCount(); i++){ //고용 그리드에 연결된 STORE
//									if(psnl0110Store.getRecord(psnl0110Store.getAt(i)).isDirty()){ //변경된 정보가 있을경우
//										psnl0110Store.getAt(i).setDpobCd(psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
//										psnl0110Store.getAt(i).setSystemkey(psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
//										
//										//고용구분이 기간제 근로자일 경우만 null체크
//										if("A0020020".equals(psnl0110Grid.getSelectionModel().getSelectedItem().getEmymtDivCd())) {
//											//고용 저장시 null값 안들어가게끔 체크
//											if(MSFSharedUtils.paramNull(psnl0110Grid.getSelectionModel().getSelectedItem().getEmymtDivCd())) {
//												MessageBox.alert("", "고용구분을 선택하여주세요.", null);
//												return;
//											}else if(MSFSharedUtils.paramNull(psnl0110Grid.getSelectionModel().getSelectedItem().getEmymtTypCd())) {
//												MessageBox.alert("", "고용유형을 선택하여주세요.", null);
//												return;
//											}else if(MSFSharedUtils.paramNull(psnl0110Grid.getSelectionModel().getSelectedItem().getEmymtBgnnDt())) {
//												MessageBox.alert("", "시작일자를 선택하여주세요.", null);
//												return;
//											}else if(MSFSharedUtils.paramNull(psnl0110Grid.getSelectionModel().getSelectedItem().getDeptCd())) {
//												MessageBox.alert("", "부서를 선택하여주세요.", null);
//												return;
//											}else if(MSFSharedUtils.paramNull(psnl0110Grid.getSelectionModel().getSelectedItem().getBusinCd())) {
//												MessageBox.alert("", "사업을 선택하여주세요.", null);
//												return;
//											}
//										}
//										
//										changePsnl0110List.add(psnl0110Store.getAt(i));
//										checkRow = true;
//									}
//								}
//								
//								if (!checkRow) {
//								    MessageBox.info("저장", "저장할 고용 정보가 없습니다.", null); 
//								    return;
//								}
//								
//								//저장시작
//								psnl0110Service.savePsnl0110(changePsnl0110List, new AsyncCallback<String>(){
//									@Override
//									public void onFailure(Throwable caught) {
//										
//										MessageBox.info("저장실패", "고용 정보 저장이 실패 하였습니다.", null);
//									}
//
//									@Override
//									public void onSuccess(String result) {
//										
//										final String strReust = result;
//										
////										MessageBox.info("저장완료", "고용 정보("+result+")가 저장되었습니다.", null);
//										
//										//dtilOccuInttnCdCombo.setStore(listStoreBass0350);
//										
//										
//										// 고용 저장시 master 업데이트를 위해..
//										final Psnl0100DTO dto = new Psnl0100DTO();
//										
//										dto.setDpobCd(psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());			//사업장
//										dto.setSystemkey(psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());	//시스템키
//										dto.setEmymtDivCd(psnl0110Grid.getSelectionModel().getSelectedItem().getEmymtDivCd());	//고용구분
//										dto.setEmymtTypCd(psnl0110Grid.getSelectionModel().getSelectedItem().getEmymtTypCd());	//고용유형
//										dto.setCurrAffnDeptCd(psnl0110Grid.getSelectionModel().getSelectedItem().getDeptCd());	//부서
//										dto.setOdtyCd(psnl0110Grid.getSelectionModel().getSelectedItem().getOdtyCd());			//직책
//										dto.setBusinCd(psnl0110Grid.getSelectionModel().getSelectedItem().getBusinCd());		//사업
//										dto.setEmymtDivCdFlag(psnl0110Grid.getSelectionModel().getSelectedItem().getEmymtDivCd());
////										dto.setCurrPaeWorkNm(psnl0110Grid.getSelectionModel().getSelectedItem().getCurrPaeWorkNm());//현근무지
////										dto.setAutoLoadFlag(autoLoadFlag);
//										
////										 PrgmComBass0500DTO sys0500dto = new PrgmComBass0500DTO();
////										 String businApptnYr = psnl0110Grid.getSelectionModel().getSelectedItem().getEmymtBgnnDt() == null ? "" 
////								                    : GWTUtils.getStringFromDate(psnl0110Grid.getSelectionModel().getSelectedItem().getEmymtBgnnDt(), "yyyyMMdd").substring(0, 4);
////										 sys0500dto.setBusinApptnYr(businApptnYr);  //DateTimeFormat.getFormat("yyyy").format(new Date())
////										 sys0500dto.setDeptCd(psnl0110Grid.getSelectionModel().getSelectedItem().getDeptCd()); 
////										
////										listStoreYearBusin = PrgmComComboUtils.getDeptWithBass0500ComboData(sys0500dto);
////										businCdCombo.setStore(listStoreYearBusin);
//										 
//										psnl0110Loader.load();
//										
//										//TODO 고용데이터가 전부 삭제해서 0건일 경우 마스터 업데이트시 데이터 구분하여 저장.
//											psnl0110Loader.addLoadListener(new LoadListener(){
//												@Override
//												public void loaderLoad(LoadEvent le) {
//													// TODO Auto-generated method stub
//													super.loaderLoad(le);
//													
//													
//													try{
//														BaseListLoadResult<ModelData> data = le.getData();
//														totalLength = data.getData().size();
////														int totalLength = data.getTotalLength();
//														
//														autoLoadFlag = new String();
//														
//														if(totalLength <= 0) {
//															autoLoadFlag = "true";
//														}else {
//															autoLoadFlag = "false";
//														}
//														
//														dto.setAutoLoadFlag(autoLoadFlag);
//
//														psnl0100Service.updateProcPsnl0100Return(dto, new AsyncCallback<Psnl0100DTO>() {
//															@Override
//															public void onSuccess(Psnl0100DTO result) {
//																
//																// 2014.08.25 고용 업데이트 후 그리드 데이터도 업데이트 처리
//																psnl0100Grid.getStore().update(result);
//																
//																//TODO 저장
//																//PersonalUtil.setSelectedComboValue(deptCd, result.getDeptCd(),"mangeDeptCd"); //기본사항 관리부서
//				                                                //deptCd.fireEvent(Events.Change, new BaseEvent(result));
//				                                                mangeDeptCd.setValue( result.getDeptCd());
//				                                                mangeDeptNm.setValue(result.getDeptNm());  
//				                                                //PersonalUtil.setSelectedComboValue(currAffnDeptCd, result.getCurrAffnDeptCd(),"deptCd"); //기본사항 부서
//				                                                currAffnDeptCd.setValue( result.getCurrAffnDeptCd());
//				                                                currAffnDeptNm.setValue(result.getCurrAffnDeptNm()); 
////																PersonalUtil.setSelectedComboValue(typOccuCd, result.getTypOccuCd()); //직종
////																typOccuCd.fireEvent(Events.Change, new BaseEvent(result));
////																PersonalUtil.setSelectedComboValue(tempComboBox, result.getDtilOccuInttnCd(), "dtilOccuInttnCd"); //직종세
//																PersonalUtil.setSelectedComboValue(emymtDivCd, result.getEmymtDivCd()); //고용구분코드
//																PersonalUtil.setSelectedComboValue(hdofcCodtnCd, result.getHdofcCodtnCd()); //재직구분
//																resnRegnNum.setValue(result.getResnRegnNum());	//주민등록번호
//																hanNm.setValue(result.getHanNm());	//한글이름
//																chinCharNm.setValue(result.getChinCharNm());	//한자이름
//																currPaeWorkNm.setValue(result.getCurrPaeWorkNm());	//현근무지
//																
//																
//																DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyyMMdd");
//																if(result.getFrstEmymtDt() != null && result.getFrstEmymtDt().length() == 8){
//																	frstEmymtDt.setValue(dateTimeFormat.parse(result.getFrstEmymtDt()));
//																}else{
//																	frstEmymtDt.reset();
//																}
//																
//																if(result.getEmymtEndDt() != null && result.getEmymtEndDt().length() == 8){
//																	emymtEndDt.setValue(dateTimeFormat.parse(result.getEmymtEndDt()));
//																}else{
//																	emymtEndDt.reset();
//																}
//																
//																logSvcYrNum.setValue(result.getWorkym());
//																engNm.setValue(result.getEngNm());
//																
//																if(result.getCurrDeptAppmtDt() != null && result.getCurrDeptAppmtDt().length() == 8){
//																	currDeptAppmtDt.setValue(dateTimeFormat.parse(result.getCurrDeptAppmtDt()));
//																}else{
//																	currDeptAppmtDt.reset();
//																}
//																
//																retryReasCtnt.setValue(result.getRetryReasCtnt());
//																
//																businNm.setValue(result.getBusinNm());
//																
////																MessageBox.info("저장완료", "고용 정보("+strReust+")가 저장되었습니다.", null);
//																// 고용데이터 신규 입력시 고용구분에 따른 전환작업
//																MessageBox.info("저장완료", "고용 정보("+strReust+")가 저장되었습니다.", new Listener<MessageBoxEvent>(){
//																	@Override
//																	public void handleEvent( MessageBoxEvent be) {
//																		
//																		
//																		// TODO Auto-generated method stub
//																		if("OK".equals(be.getButtonClicked().getText())) {
//																			// 고용구분 전환 메소드 호출
//																			psnl0100Status(dto);
//																		}
//																	}
//																});
//																
//																//기본값으로 초기화
//																autoLoadFlag = "false";
//																
//																//마스터 업데이트 후 조회
//																loaderPaging.load();
//															}
//															@Override
//															public void onFailure(Throwable caught) {
//															}
//														});
//														
//													}catch(Exception e){
//														e.printStackTrace();
//													}
//													//TODO 리스너 제거
//													psnl0110Loader.removeLoadListener(this);
//												}
//											});
//										}
//								});
							}
						}
					});
				}
			}
		}));

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;
	}
	
	
	/***********************************************************************************
	 * 발령추가 20171117 
	 * @return
	 ************************************************************************************/
	private LayoutContainer Employment0300() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();


//		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
//	 
//		CheckColumnConfig checkColumn = new CheckColumnConfig();
//		checkColumn.setId("delChk");
//		checkColumn.setHeaderText("삭제");
//		checkColumn.setWidth(40);
//		CellEditor checkBoxEditor = new CellEditor(new CheckBox());  
//		checkColumn.setEditor(checkBoxEditor);
//	    checkColumn.setMenuDisabled(true);
//	   // checkColumn.setFixed(true);
//	    configs.add(checkColumn); 
//		
//	    
//		/**
//		공무직 화면으로 무조건 무기계약근로자만 선택하게 처리
//		A0020020 : 기간제근로자
//		A0020010 : 무기계약근로자
//		**/
//		final ComboBox<BaseModel> emymtDivCdCombo = new ComboBox<BaseModel>();  
//		emymtDivCdCombo.setForceSelection(true);
//		emymtDivCdCombo.setMinChars(1);
//		emymtDivCdCombo.setDisplayField("commCdNm");
//		emymtDivCdCombo.setValueField("commCd");
//		emymtDivCdCombo.setForceSelection(true);  
//		emymtDivCdCombo.setTriggerAction(TriggerAction.ALL);
//		emymtDivCdCombo.setStore(listStoreA002);
//		
//	    CellEditor emymtDivCdEditor = new CellEditor(emymtDivCdCombo){
//	    	@Override  
//			public Object preProcessValue(Object value) {
//				if (value == null) {
//					return value;
//				}
//				return emymtDivCdCombo.getStore().findModel(PersonalUtil.getBaseModelComboDataCd(emymtDivCdCombo, String.valueOf(value)));
//			}
//	    
//			@Override
//			public Object postProcessValue(Object value) {
//				if (value == null) {
//					return value;
//				}
//				return ((BaseModel) value).get("commCd");
//			}
//	    };
//	    
//		
//		ColumnConfig column = new ColumnConfig();
//		column.setId("emymtDivCd");
//		column.setHeaderText("고용구분");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setEditor(emymtDivCdEditor);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		column.setRenderer(new GridCellRenderer<BaseModelData>() {
//			@Override
//			public Object render(BaseModelData model, String property,
//					ColumnData config, int rowIndex, int colIndex,
//					ListStore<BaseModelData> store, Grid<BaseModelData> grid) {
//				
//				if(emymtDivCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("emymtDivCd"))!= null){
//					return emymtDivCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("emymtDivCd")).get("commCdNm");
//				}else{
//					return "";
//				}
//			}
//		});
//		configs.add(column);
//		
//		final ComboBox<BaseModel> emymtTypCdCombo = new ComboBox<BaseModel>();  
//		emymtTypCdCombo.setForceSelection(true);
//		emymtTypCdCombo.setMinChars(1);
//		emymtTypCdCombo.setDisplayField("commCdNm");
//		emymtTypCdCombo.setValueField("commCd");
//		emymtTypCdCombo.setForceSelection(true);  
//		emymtTypCdCombo.setTriggerAction(TriggerAction.ALL);
//		emymtTypCdCombo.setStore(listStoreA042);
//		CellEditor emymtTypCdEditor = new CellEditor(emymtTypCdCombo){
//	    	@Override  
//			public Object preProcessValue(Object value) {
//				if (value == null) {
//					return value;
//				}
//				return emymtTypCdCombo.getStore().findModel(PersonalUtil.getBaseModelComboDataCd(emymtTypCdCombo, String.valueOf(value)));
//			}
//	    
//			@Override
//			public Object postProcessValue(Object value) {
//				if (value == null) {
//					return value;
//				}
//				return ((BaseModel) value).get("commCd");
//			}
//	    };
//		column = new ColumnConfig();
//		column.setId("emymtTypCd");
//		column.setHeaderText("고용유형");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setEditor(emymtTypCdEditor);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		column.setRenderer(new GridCellRenderer<BaseModelData>() {
//			@Override
//			public Object render(BaseModelData model, String property,
//					ColumnData config, int rowIndex, int colIndex,
//					ListStore<BaseModelData> store, Grid<BaseModelData> grid) {
//				
//				if(emymtTypCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("emymtTypCd"))!= null){
//					
////                  psnl0110Grid.getSelectionModel().getSelectedItem().setEmymtTypCd(emymtTypCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("emymtTypCd")).toString());
//                  
//					return emymtTypCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("emymtTypCd")).get("commCdNm");
//				}else{
//					return "";
//				}
//			}
//		});
//		configs.add(column);
//		
//		DateField emymtBgnnDtDateField = new DateField();
//		new DateFieldMask(emymtBgnnDtDateField, "9999.99.99"); 
//		emymtBgnnDtDateField.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
//		
//		column = new ColumnConfig();
//		column.setId("emymtBgnnDt");
//		column.setHeaderText("시작일자");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setEditor(new CellEditor(emymtBgnnDtDateField));
//	    column.setDateTimeFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
//	    column.setSortable(false);
//	    column.setMenuDisabled(true);
//	    configs.add(column);
//
//	    
//	    DateField emymtEndDtDateField = new DateField();
//	    new DateFieldMask(emymtEndDtDateField, "9999.99.99"); 
//	    emymtEndDtDateField.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
//		
//	    column = new ColumnConfig();
//		column.setId("emymtEndDt");
//		column.setHeaderText("종료일자");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setEditor(new CellEditor(emymtEndDtDateField));
//	    column.setDateTimeFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
//	    column.setSortable(false);
//	    column.setMenuDisabled(true);
//	    configs.add(column);
//	    
////	    final ComboBox<BaseModel> deptCdCombo = new ComboBox<BaseModel>();  
////	    deptCdCombo.setForceSelection(true);
////	    deptCdCombo.setMinChars(1);
////	    deptCdCombo.setDisplayField("deptNmRtchnt");
////		deptCdCombo.setValueField("deptCd");
////		deptCdCombo.setForceSelection(true);  
////		deptCdCombo.setTriggerAction(TriggerAction.ALL);
////		deptCdCombo.setStore(listStoreBass0400All); 
////	    CellEditor deptCdEditor = new CellEditor(deptCdCombo){  
////	        @Override  
////	        public Object preProcessValue(Object value) {  
////	          if (value == null) {  
////	            return value;  
////	          }  
////	          return deptCdCombo.getStore().findModel(PersonalUtil.getBaseModelComboDataCd(deptCdCombo, String.valueOf(value), "deptCd"));  
////	        }  
////	    
////	        @Override  
////	        public Object postProcessValue(Object value) {  
////	          if (value == null) {  
////	            return value;  
////	          }  
////	          return ((BaseModel) value).get("deptCd");
////	        }  
////	    };
////	    
////	    
////	    column = new ColumnConfig();
////		column.setId("deptCd");
////		column.setHeaderText("부서");
////		column.setAlignment(HorizontalAlignment.CENTER);
////		column.setWidth(140);
////		column.setEditor(deptCdEditor);
////		column.setSortable(false);
////		column.setMenuDisabled(true);
////		column.setRenderer(new GridCellRenderer<BaseModelData>() {
////
////			@Override
////			public Object render(BaseModelData model, String property,
////					ColumnData config, int rowIndex, int colIndex,
////					ListStore<BaseModelData> store, Grid<BaseModelData> grid) {
////				
////				if(deptCdCombo.getStore().findModel("deptCd",store.getModels().get(rowIndex).get("deptCd"))!= null){
////					return deptCdCombo.getStore().findModel("deptCd",store.getModels().get(rowIndex).get("deptCd")).get("deptNmRtchnt");
////				}else{
////					return "";
////				}
////			}
////		});
//	    
//	    column = new ColumnConfig();
//      column.setId("deptCd");
//      column.setHeaderText("");
//      column.setAlignment(HorizontalAlignment.CENTER);
//      column.setWidth(0);
//      column.setEditor(new CellEditor(new TextField<String>())); 
//      column.setSortable(false);
//      column.setHidden(true);
//      column.setMenuDisabled(false);  
//      column.setRenderer(new GridCellRenderer<BaseModelData>() {
//
//        @Override
//        public Object render(BaseModelData model, String property,
//                ColumnData config, int rowIndex, int colIndex,
//                ListStore<BaseModelData> store, Grid<BaseModelData> grid) {
//            
//              String btnText = model.get(property) == null ? "" : (String)model.get(property);
//               
//              return btnText;  
//        }
//    });
//      configs.add(column);
//      
//	    
//	        Button btnDeptCd = new Button("");
//	       
//	        btnDeptCd.setIcon(MSFMainApp.ICONS.search());
//	       
//	        //final MSFTextFieldButton<String> msfDeptTxtBtn = new MSFTextFieldButton<String>(btnDeptCd);
//	        final PrgmDeptFieldButton<String> msfDeptTxtBtn = new PrgmDeptFieldButton<String>(); 
//	      
//	        column = new ColumnConfig();
//	        column.setId("deptNm");
//	        column.setHeaderText("부서");
//	        column.setAlignment(HorizontalAlignment.LEFT);
//	        column.setWidth(150);
//	        column.setEditor(new CellEditor(msfDeptTxtBtn)); 
//	        column.setSortable(false);
//	        column.setMenuDisabled(true);
//	        column.setRenderer(new GridCellRenderer<BaseModelData>() {
//	//-------------------------
//	            @Override
//	            public Object render(final BaseModelData model, String property,
//	                    final ColumnData config, final int rowIndex, final int colIndex,
//	                    final ListStore<BaseModelData> store,  Grid<BaseModelData> grid) {
//	                  
//	                String btnText = model.get(property) == null ? "" : (String)model.get(property);
//	              //  if("".equals(btnText)){
//	              //      return "";
//	               // }else{
//	                    msfDeptTxtBtn.addListener(Events.Change, new Listener<BaseEvent>() { 
//	                        public void handleEvent(BaseEvent be) {
//	                             
//	                            BaseModel mapModel = (BaseModel)be.getSource(); 
//	                            if (!"".equals(mapModel.get("deptCd"))) {   
//	                                if (psnl0200RowIndex == rowIndex) { 
//	                                   // String htmlAttr = "'background-color:yellow; background-image: url(gray_gradient.gif);background-repeat: no-repeat;background-position:50%;'";
//	                                    //  String changeStyle = "<span style='font-weight: bold;color:red'>√</span>";  
//	                                    //  store.getAt(rowIndex).set("schlCd",String.valueOf(popBindingInner.getModel().get("commCd")));
//	                                   // config.style = "background-color: silver;";
//	                                    store.getAt(rowIndex).set("deptCd",String.valueOf(mapModel.get("deptCd"))); 
//	                                    store.getAt(rowIndex).set("deptNm",String.valueOf(mapModel.get("deptNmRtchnt"))); 
//	                                    store.update(store.getAt(rowIndex));
//	                                    store.getRecord(store.getAt(rowIndex)).setDirty(true);  
//	                                    psnl0200RowIndex = -1;
//	                                    psnl0200ColIndex = -1;
//	                                    psnl0110Grid.getSelectionModel().getSelectedItem().setBusinCd("");
//	                                    
////	                                   if (MSFSharedUtils.paramNotNull(mapModel.get("deptCd"))) { 
////  	                                    PrgmComBass0500DTO sysComBass0500Dto = new PrgmComBass0500DTO();
////                                          sysComBass0500Dto.setBusinApptnYr("");  //DateTimeFormat.getFormat("yyyy").format(new Date())
////                                          sysComBass0500Dto.setDeptCd(String.valueOf(mapModel.get("deptCd")));
////  	                                    //사업명코드 가져오기
////  	                                    psnl0100Service.getBusinList(sysComBass0500Dto, new AsyncCallback<List<BaseModel>>() {
////  	                                        
////  	                                        @Override
////  	                                        public void onSuccess(List<BaseModel> result) {
////  	                                            
////  	                                            listStoreYearBusin.add(result);
////  	                                            businCdCombo.setStore(listStoreYearBusin); 
////  	                                        }
////  	                                        
////  	                                        @Override
////  	                                        public void onFailure(Throwable caught) {
////  	                                            
////  	                                            MessageBox.alert("", "사업명코드 에러!", null);
////  	                                        }
////  	                                    });
////	                                   }
//	                                
//	                                }
//	                            }
//	                        }
//	                    }); 
//	                    
//	                    msfDeptTxtBtn.addKeyListener(new KeyListener(){
//	        				@Override
//	        				public void componentKeyDown(ComponentEvent event) {
//	        					if(event.getKeyCode() == KeyCodes.KEY_ENTER){  
//	        						
//	        						 msfDeptTxtBtn.addListener(Events.Select, new Listener<BaseEvent>() { 
//	        		                        public void handleEvent(BaseEvent be) {
//	        		                             
//	        		                            BaseModel mapModel = (BaseModel)be.getSource(); 
//	        						 
//	        		                            if (!"".equals(mapModel.get("deptCd")) && "".equals(mapModel.get("businCd"))) {   
//	        		                                
//	        		                                if (psnl0200RowIndex == rowIndex) { 
//	        		                                	
//	        		                                    store.getAt(rowIndex).set("deptCd",String.valueOf(mapModel.get("deptCd"))); 
//	        		                                    store.getAt(rowIndex).set("deptNm",String.valueOf(mapModel.get("deptNmRtchnt"))); 
//	        		                                    store.update(store.getAt(rowIndex));
//	        		                                    store.getRecord(store.getAt(rowIndex)).setDirty(true);  
//	        		                                    psnl0200RowIndex = -1;
//	        		                                    psnl0200ColIndex = -1;
//	        		                                    psnl0110Grid.getSelectionModel().getSelectedItem().setBusinCd("");
//	        		                                }
//	        		                            }
//	        		                        }
//	        		                    }); 
////	        						 store.getModels().get(index)
//	        					}
////	        					else if(event.getKeyCode() == KeyCodes.KEY_SHIFT){
////	        					onFocus(c);
////	        					}
//	        				}
//	        			});
//	                    
//	                    return btnText;
//	               // } 
//	 
//	            }
//	            
//	        });
//		configs.add(column); 
//		
//		businCdCombo = new ComboBox<BaseModel>();  
//		businCdCombo.setForceSelection(true);
//		businCdCombo.setMinChars(1);
//		businCdCombo.setDisplayField("businNm");
//		businCdCombo.setValueField("businCd");
//		businCdCombo.setForceSelection(true);  
//		businCdCombo.setTriggerAction(TriggerAction.ALL);
//		businCdCombo.setStore(listStoreYearBusin);
//		
//	    CellEditor businCdEditor = new CellEditor(businCdCombo){  
//	        @Override  
//	        public Object preProcessValue(Object value) {  
//	            
//	            String deptCd = psnl0110Grid.getSelectionModel().getSelectedItem().getDeptCd() == null ? "" : psnl0110Grid.getSelectionModel().getSelectedItem().getDeptCd();
//	            String businApptnYr = psnl0110Grid.getSelectionModel().getSelectedItem().getEmymtBgnnDt() == null ? "" 
//	                    : GWTUtils.getStringFromDate(psnl0110Grid.getSelectionModel().getSelectedItem().getEmymtBgnnDt(), "yyyyMMdd").substring(0, 4);
////	            		: psnl0110Grid.getSelectionModel().getSelectedItem().getEmymtBgnnDt();
//	            final String businCd = String.valueOf(psnl0110Grid.getSelectionModel().getSelectedItem().getBusinCd());
//	            
////	            MessageBox.info("처음 진입", businCd + " > 이다.", null);
//	            
//	            
//	            if( deptCd != null && !"".equals(deptCd) && businCd == null || "".equals(businCd)){
//	            	
////	            	MessageBox.info("", "기존 조건", null);
////	            	MessageBox.info("사업코드 <", businCd + " > 이다.", null);
//	            	
//                  //관련된 사업 넣기위한 템프 스토어리스트
//	                tempListStore01 = new ListStore<BaseModel>();
//              //  String typComboOccuCd =  psnl0110Grid.getSelectionModel().getSelectedItem().getTypOccuCd();
//                  for(int i = 0; i < listStoreYearBusin.getCount(); i++){
//                      //TODO 주의할것...구분자반드시처리..
//                      if(deptCd.equals(String.valueOf(listStoreYearBusin.getAt(i).get("deptCd"))) && businApptnYr.equals(String.valueOf(listStoreYearBusin.getAt(i).get("businApptnYr")) )){ 
//                      	tempListStore01.add(listStoreYearBusin.getAt(i));
//                      } 
//                  }
//                  final PrgmComBass0500DTO dto = new PrgmComBass0500DTO();
//                  dto.setBusinApptnYr(businApptnYr);  //DateTimeFormat.getFormat("yyyy").format(new Date())
//                  dto.setDeptCd(deptCd); 
//              
//                //--------------------사업 불러 오는 함수 -------------------------------------------------
//                  tempListStore01 = PrgmComComboUtils.getDeptWithBass0500ComboData(dto);
//                 //--------------------사업 불러 오는 함수 -------------------------------------------------
//                  tempListStore01.addStoreListener( new StoreListener<BaseModel>() {   
//                      public void handleEvent(StoreEvent<BaseModel> be) {  
//
//                          businCdCombo.setStore(tempListStore01);
//                          
//                          for(int i = 0; i < tempListStore01.getCount(); i++){
//                      		//TODO 주의할것...구분자반드시처리..
//                      		businCdCombo.setStore(tempListStore01);
//                           }
////                          listStoreYearBusin = PrgmComComboUtils.getDeptWithBass0500ComboData(dto);
////						    businCdCombo.setStore(listStoreYearBusin);
//                      }
//                  });
//              }else if(deptCd != null && !"".equals(deptCd) && businCd != null || !"".equals(businCd)) {
//              	
////              	MessageBox.info("부서코드가 있다. < ", businCd + " >", null);
//              	
//              	 //관련된 사업 넣기위한 템프 스토어리스트
//	                tempListStore01 = new ListStore<BaseModel>();
//              //  String typComboOccuCd =  psnl0110Grid.getSelectionModel().getSelectedItem().getTypOccuCd();
//                  for(int i = 0; i < listStoreYearBusin.getCount(); i++){
//                      //TODO 주의할것...구분자반드시처리..
//                      if(deptCd.equals(String.valueOf(listStoreYearBusin.getAt(i).get("deptCd"))) && businApptnYr.equals(String.valueOf(listStoreYearBusin.getAt(i).get("businApptnYr")) )){ 
//                      	tempListStore01.add(listStoreYearBusin.getAt(i));
//                      } 
//                  }
//                  final PrgmComBass0500DTO dto = new PrgmComBass0500DTO();
//                  dto.setBusinApptnYr(businApptnYr);  //DateTimeFormat.getFormat("yyyy").format(new Date())
//                  dto.setDeptCd(deptCd); 
//              
//                //--------------------사업 불러 오는 함수 -------------------------------------------------
//                  tempListStore01 = PrgmComComboUtils.getDeptWithBass0500ComboData(dto);
//                 //--------------------사업 불러 오는 함수 -------------------------------------------------
//                  tempListStore01.addStoreListener( new StoreListener<BaseModel>() {   
//                      public void handleEvent(StoreEvent<BaseModel> be) {  
//                      	
//                          businCdCombo.setStore(tempListStore01);
//                          
//                          for(int i = 0; i < tempListStore01.getCount(); i++){
//                      		//TODO 주의할것...구분자반드시처리..
//                      		businCdCombo.setStore(tempListStore01);
//                           }
//                          PersonalUtil.setSelectedComboValue(businCdCombo, businCd, "businCd");
//                      }
//                  });
//              }else{
////              	MessageBox.info("", "CellEditor 안탔다.", null);
//	            	
//	            	businCdCombo.setStore(new ListStore<BaseModel>());
//                  businCdCombo.setValue(new BaseModel());
//              }
//              
//	            if (value == null) {  
////	            	MessageBox.info("널 일때 <", String.valueOf(value) + ">", null);
//	            	return value;  
//	            }else {
////	        		MessageBox.info("아닐때 <", String.valueOf(value) + ">", null);
//	        		value = psnl0110Grid.getSelectionModel().getSelectedItem().getBusinCd();
//	        	}
//	            
//	            return businCdCombo.getStore().findModel(PersonalUtil.getBaseModelComboDataCd(businCdCombo, String.valueOf(value),"businCd"));  
//	        }  
//	    
//	        @Override  
//	        public Object postProcessValue(Object value) {  
//	        	if (value == null) {  
//	        		return value;  
//	        	}
//	        	return ((BaseModel) value).get("businCd");
//	        }  
//	    };
//	    
//	    
//	    column = new ColumnConfig();
//		column.setId("businCd");
//		column.setHeaderText("사업명");
//		column.setAlignment(HorizontalAlignment.LEFT);
//		column.setWidth(200);
//		column.setEditor(businCdEditor);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		column.setRenderer(new GridCellRenderer<BaseModelData>() { 
//			@Override
//			public Object render(BaseModelData model, String property,
//					ColumnData config, int rowIndex, int colIndex,
//					ListStore<BaseModelData> store, Grid<BaseModelData> grid) {
//				 
//				//if(businCdCombo.getStore().findModel("businCd",store.getModels().get(rowIndex).get("businCd"))!= null){
//				if((store.getModels().get(rowIndex).get("deptCd")!= null) && (store.getModels().get(rowIndex).get("businCd")!= null)){
//				    
//				    String deptCd = store.getModels().get(rowIndex).get("deptCd") == null ? "" : String.valueOf(store.getModels().get(rowIndex).get("deptCd"));
//	                String businApptnYr = store.getModels().get(rowIndex).get("emymtBgnnDt") == null ? "" 
//	                        : GWTUtils.getStringFromDate((Date)store.getModels().get(rowIndex).get("emymtBgnnDt"), "yyyyMMdd").substring(0, 4);
//	                
//	                String businCd = store.getModels().get(rowIndex).get("businCd") == null ? "" : String.valueOf(store.getModels().get(rowIndex).get("businCd"));
//	                   
//	                if( deptCd != null && !"".equals(deptCd)){
//	                	
//	                	//TODO 초기화
//	                	businCdCombo.setStore(new ListStore<BaseModel>());
//	                    businCdCombo.setValue(new BaseModel());
//	                    
//	                    //관련된 사업을 넣기위한 템프 스토어리스트
//	                    ListStore<BaseModel> tempListStore = new ListStore<BaseModel>(); 
//	                    for(int i = 0; i < listStoreYearBusin.getCount(); i++){
//	                     
//	                        if(deptCd.equals(String.valueOf(listStoreYearBusin.getAt(i).get("deptCd"))) && businApptnYr.equals(String.valueOf(listStoreYearBusin.getAt(i).get("businApptnYr")) )){ 
//	                              tempListStore.add(listStoreYearBusin.getAt(i));
//	                        } 
//	                    }
//	                    
//	                    
//	                    
////	                    PrgmComBass0500DTO dto = new PrgmComBass0500DTO();
////	                    dto.setBusinApptnYr(businApptnYr);  //DateTimeFormat.getFormat("yyyy").format(new Date())
////	                    dto.setDeptCd(deptCd); 
//	                
//	                  //--------------------사업 불러 오는 함수 -------------------------------------------------
////	                    tempListStore = PrgmComComboUtils.getDeptWithBass0500ComboData(dto);
//	                   //--------------------사업 불러 오는 함수 -------------------------------------------------
////	                    tempListStore.addStoreListener( new StoreListener<BaseModel>() {   
////	                        public void handleEvent(StoreEvent<BaseModel> be) {  
////	                            businCdCombo.setStore(tempListStore); 
////	                        }
////	                    });
//	                    businCdCombo.setStore(tempListStore); 
//	                    if (businCdCombo.getStore().findModel("businCd",store.getModels().get(rowIndex).get("businCd")) != null) {
//	                        return businCdCombo.getStore().findModel("businCd",store.getModels().get(rowIndex).get("businCd")).get("businNm");
//	                    } else {
//	                        return "";
//	                    }
//	                   
//	                }else{
//	                    businCdCombo.setStore(new ListStore<BaseModel>());
//	                    businCdCombo.setValue(new BaseModel());
//	                    return "";
//	                }  
//				}else{
//					return "";
//				}
//			}
//		});
//		configs.add(column);
//	   
//		
//		
//		column = new ColumnConfig();
//		column.setId("currPaeWorkNm");
//		column.setHeaderText("현근무지");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		TextField<String> currPaeWorkNmText = new TextField<String>();
//		//currPaeWorkNmText.setAllowBlank(false); //필드값을 빈값으로 설정가능한지 체크
//		column.setEditor(new CellEditor(currPaeWorkNmText));
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//
//		
//		final ComboBox<BaseModel> odtyCdCombo = new ComboBox<BaseModel>();  
//		odtyCdCombo.setForceSelection(true);
//		odtyCdCombo.setMinChars(1);
//		odtyCdCombo.setDisplayField("commCdNm");
//		odtyCdCombo.setValueField("commCd");
//		odtyCdCombo.setForceSelection(true);  
//		odtyCdCombo.setTriggerAction(TriggerAction.ALL);
//		odtyCdCombo.setStore(listStoreA015);
//	    
//	    
//	    CellEditor odtyCdEditor = new CellEditor(odtyCdCombo){  
//	        @Override  
//	        public Object preProcessValue(Object value) {  
//	          if (value == null) {  
//	            return value;  
//	          }  
//	          return odtyCdCombo.getStore().findModel(PersonalUtil.getBaseModelComboDataCd(odtyCdCombo, String.valueOf(value)));  
//	        }  
//	    
//	        @Override  
//	        public Object postProcessValue(Object value) {  
//	          if (value == null) {  
//	            return value;  
//	          }  
//	          return ((BaseModel) value).get("commCd");
//	        }  
//	    };
//		
//		column = new ColumnConfig();
//		column.setId("odtyCd");
//		column.setHeaderText("직 책");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setEditor(odtyCdEditor);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		column.setRenderer(new GridCellRenderer<BaseModelData>() {
//
//			@Override
//			public Object render(BaseModelData model, String property,
//					ColumnData config, int rowIndex, int colIndex,
//					ListStore<BaseModelData> store, Grid<BaseModelData> grid) {
//				
//				if(odtyCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("odtyCd"))!= null){
//					return odtyCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("odtyCd")).get("commCdNm");
//				}else{
//					return "";
//				}
//			}
//		});
//		configs.add(column);
//
//		
//		final ComboBox<BaseModel> retryDivCombo = new ComboBox<BaseModel>();  
//		retryDivCombo.setForceSelection(true);
//		retryDivCombo.setMinChars(1);
//		retryDivCombo.setDisplayField("commCdNm");
//		retryDivCombo.setValueField("commCd");
//		retryDivCombo.setForceSelection(true);  
//		retryDivCombo.setTriggerAction(TriggerAction.ALL);
//		retryDivCombo.setStore(listStoreA050);
//	    
//	    CellEditor retryDivEditor = new CellEditor(retryDivCombo){  
//	        @Override  
//	        public Object preProcessValue(Object value) {  
//	          if (value == null) {  
//	            return value;  
//	          }  
//	          return retryDivCombo.getStore().findModel(PersonalUtil.getBaseModelComboDataCd(retryDivCombo, String.valueOf(value)));  
//	        }  
//	    
//	        @Override  
//	        public Object postProcessValue(Object value) {  
//	          if (value == null) {  
//	            return value;  
//	          }  
//	          return ((BaseModel) value).get("commCd");
//	        }  
//	    };
//		
//		
//		
//		column = new ColumnConfig();
//		column.setId("retryDivCd");
//		column.setHeaderText("퇴직사유구분");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setEditor(retryDivEditor);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		column.setRenderer(new GridCellRenderer<BaseModelData>() {
//			@Override
//			public Object render(BaseModelData model, String property,
//					ColumnData config, int rowIndex, int colIndex,
//					ListStore<BaseModelData> store, Grid<BaseModelData> grid) {
//				
//				if(retryDivCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("retryDivCd"))!= null){
//					return retryDivCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("retryDivCd")).get("commCdNm");
//				}else{
//					return "";
//				}
//			}
//		});
//		configs.add(column);
//		
//		
//		column = new ColumnConfig();
//		column.setId("retryReasCtnt");
//		column.setHeaderText("퇴직사유내용");
//		column.setAlignment(HorizontalAlignment.LEFT);
//		column.setWidth(150);
//		TextField<String> retryReasCtntText = new TextField<String>();
//		//emymtReasCtntText.setAllowBlank(false); //필드값을 빈값으로 설정가능한지 체크
//		column.setEditor(new CellEditor(retryReasCtntText));
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//		
//		
//		column = new ColumnConfig();
//		column.setId("emymtReasCtnt");
//		column.setHeaderText("비고");
//		column.setAlignment(HorizontalAlignment.LEFT);
//		column.setWidth(150);
//		TextField<String> emymtReasCtntText = new TextField<String>();
//		//emymtReasCtntText.setAllowBlank(false); //필드값을 빈값으로 설정가능한지 체크
//		column.setEditor(new CellEditor(emymtReasCtntText));
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//		
//		ColumnModel cm = new ColumnModel(configs);
//		
//		
//		ContentPanel cp01 = new ContentPanel();
//		cp01.setBodyBorder(false);
//		cp01.setHeaderVisible(false);
//		cp01.setLayout(new FitLayout());
//		cp01.setSize(968, 213);
//
//		psnl0110Grid = new EditorGrid<Psnl0110DTO>(psnl0110Store, cm);
//		
//		psnl0110Grid.setStateId("psnl0110Grid");
//		psnl0110Grid.setStateful(false);
//		psnl0110Grid.setLoadMask(true); // 작업중표시
//		//psnl0110Grid.setAutoExpandColumn("emymtReasCtnt");;
//		psnl0110Grid.setBorders(true);
//		psnl0110Grid.addPlugin(checkColumn);
//		//psnl0110Grid.setAutoWidth(true);
//		psnl0110Grid.setColumnResize(true);
//		
//		psnl0110Grid.addListener(Events.CellMouseUp, new Listener<GridEvent<Psnl0110DTO>>() {
//
//			@Override
//			public void handleEvent(GridEvent<Psnl0110DTO> be) {
//				
//				
//				if(be.getColIndex() == 0){
//					if(be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())).getDelChk()){
//						if(be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())).getDpobCd() == null){ //dpobCd데이터가 없으면 신규추가이므로 해당 로우를 삭제처리
//							be.getGrid().getStore().remove(be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())));
//						}
//					}
//				}
//			}
//			
//		});
//		
//		  psnl0110Grid.addListener(Events.CellMouseDown, new Listener<GridEvent<Psnl0110DTO>>() {
//
//	            @Override
//	            public void handleEvent(GridEvent<Psnl0110DTO> be) {
//	               String colId =   be.getGrid().getColumnModel().getColumnId(be.getColIndex());
//	               if ("deptNm".equals(colId)) {
//	                   psnl0200RowIndex = be.getRowIndex();
//	                   psnl0200ColIndex = be.getColIndex();
//	               } else {
//	                   psnl0200RowIndex = -1;
//	                   psnl0200ColIndex = -1;
//	               }
//	               
//	                
//	            }
//	            
//	        });
//		
//		
//		cp01.add(psnl0110Grid);
//		//psnl0110Grid.setWidth("40px");
//
//		cp01.addButton(new Button("신규", new SelectionListener<ButtonEvent>() {
//			@Override
//			public void componentSelected(ButtonEvent ce) {
//				Psnl0110DTO tempData = new Psnl0110DTO();
//				tempData.setEmymtDivCd("A0020020");
//				
//				if(psnl0110Store.getCount() > 0 && psnl0110Store.getAt(0).getDpobCd() == null){ //이미 등록을 하기위한 데이터가 있을경우
//					MessageBox.info("", "먼저 추가한 데이터를 저장후 추가해주세요.", null);
//				}else{
//					psnl0110Grid.stopEditing();
//					tempData.setDelChk(false);
//					psnl0110Store.insert(tempData, 0);
//					psnl0110Grid.startEditing(psnl0110Store.indexOf(tempData), 2); 
//				}
//				
//				
//			}
//		}));
//
//		cp01.addButton(new Button("저장", new SelectionListener<ButtonEvent>() {
//			@Override
//			public void componentSelected(ButtonEvent ce) {
//				
//				if(psnl0100Grid.getSelectionModel().getSelectedItem() != null ) {
//				    
//				    
//					MessageBox.confirm("고용 저장", "고용정보를 저장하시겠습니까?",new Listener<MessageBoxEvent>(){
//
//						@Override
//						public void handleEvent(MessageBoxEvent be) { 
//						//	if("Yes".equals(be.getButtonClicked().getText())){
//							if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
//								if(psnl0110Grid.getSelectionModel().getSelectedItem().getDelChk() == true) {
//									MessageBox.confirm("고용 삭제", "삭제가 체크되어있습니다. 계속 진행하시겠습니까?<br>(삭제된 데이터는 복구되지 않습니다.)",new Listener<MessageBoxEvent>(){
//										@Override
//										public void handleEvent(MessageBoxEvent be) {
//											// TODO Auto-generated method stub
//										//	if("No".equals(be.getButtonClicked().getText())){
//											if(Dialog.NO.equals(be.getButtonClicked().getItemId())){
//												return;
//											}else if(Dialog.YES.equals(be.getButtonClicked().getItemId())){ 
//											//	if("Yes".equals(be.getButtonClicked().getText())){
//												savePsnl0110();
//											}
//										}
//									});
//								}else {
//									savePsnl0110();
//								}
//								
////							    boolean checkRow = false;
////								//변경된 데이터 담기
////								ArrayList<Psnl0110DTO>changePsnl0110List = new ArrayList<Psnl0110DTO>();
////								for ( int i = 0; i < psnl0110Store.getCount(); i++){ //고용 그리드에 연결된 STORE
////									if(psnl0110Store.getRecord(psnl0110Store.getAt(i)).isDirty()){ //변경된 정보가 있을경우
////										psnl0110Store.getAt(i).setDpobCd(psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
////										psnl0110Store.getAt(i).setSystemkey(psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
////										
////										//고용구분이 기간제 근로자일 경우만 null체크
////										if("A0020020".equals(psnl0110Grid.getSelectionModel().getSelectedItem().getEmymtDivCd())) {
////											//고용 저장시 null값 안들어가게끔 체크
////											if(MSFSharedUtils.paramNull(psnl0110Grid.getSelectionModel().getSelectedItem().getEmymtDivCd())) {
////												MessageBox.alert("", "고용구분을 선택하여주세요.", null);
////												return;
////											}else if(MSFSharedUtils.paramNull(psnl0110Grid.getSelectionModel().getSelectedItem().getEmymtTypCd())) {
////												MessageBox.alert("", "고용유형을 선택하여주세요.", null);
////												return;
////											}else if(MSFSharedUtils.paramNull(psnl0110Grid.getSelectionModel().getSelectedItem().getEmymtBgnnDt())) {
////												MessageBox.alert("", "시작일자를 선택하여주세요.", null);
////												return;
////											}else if(MSFSharedUtils.paramNull(psnl0110Grid.getSelectionModel().getSelectedItem().getDeptCd())) {
////												MessageBox.alert("", "부서를 선택하여주세요.", null);
////												return;
////											}else if(MSFSharedUtils.paramNull(psnl0110Grid.getSelectionModel().getSelectedItem().getBusinCd())) {
////												MessageBox.alert("", "사업을 선택하여주세요.", null);
////												return;
////											}
////										}
////										
////										changePsnl0110List.add(psnl0110Store.getAt(i));
////										checkRow = true;
////									}
////								}
////								
////								if (!checkRow) {
////								    MessageBox.info("저장", "저장할 고용 정보가 없습니다.", null); 
////								    return;
////								}
////								
////								//저장시작
////								psnl0110Service.savePsnl0110(changePsnl0110List, new AsyncCallback<String>(){
////									@Override
////									public void onFailure(Throwable caught) {
////										
////										MessageBox.info("저장실패", "고용 정보 저장이 실패 하였습니다.", null);
////									}
////
////									@Override
////									public void onSuccess(String result) {
////										
////										final String strReust = result;
////										
//////										MessageBox.info("저장완료", "고용 정보("+result+")가 저장되었습니다.", null);
////										
////										//dtilOccuInttnCdCombo.setStore(listStoreBass0350);
////										
////										
////										// 고용 저장시 master 업데이트를 위해..
////										final Psnl0100DTO dto = new Psnl0100DTO();
////										
////										dto.setDpobCd(psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());			//사업장
////										dto.setSystemkey(psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());	//시스템키
////										dto.setEmymtDivCd(psnl0110Grid.getSelectionModel().getSelectedItem().getEmymtDivCd());	//고용구분
////										dto.setEmymtTypCd(psnl0110Grid.getSelectionModel().getSelectedItem().getEmymtTypCd());	//고용유형
////										dto.setCurrAffnDeptCd(psnl0110Grid.getSelectionModel().getSelectedItem().getDeptCd());	//부서
////										dto.setOdtyCd(psnl0110Grid.getSelectionModel().getSelectedItem().getOdtyCd());			//직책
////										dto.setBusinCd(psnl0110Grid.getSelectionModel().getSelectedItem().getBusinCd());		//사업
////										dto.setEmymtDivCdFlag(psnl0110Grid.getSelectionModel().getSelectedItem().getEmymtDivCd());
//////										dto.setCurrPaeWorkNm(psnl0110Grid.getSelectionModel().getSelectedItem().getCurrPaeWorkNm());//현근무지
//////										dto.setAutoLoadFlag(autoLoadFlag);
////										
//////										 PrgmComBass0500DTO sys0500dto = new PrgmComBass0500DTO();
//////										 String businApptnYr = psnl0110Grid.getSelectionModel().getSelectedItem().getEmymtBgnnDt() == null ? "" 
//////								                    : GWTUtils.getStringFromDate(psnl0110Grid.getSelectionModel().getSelectedItem().getEmymtBgnnDt(), "yyyyMMdd").substring(0, 4);
//////										 sys0500dto.setBusinApptnYr(businApptnYr);  //DateTimeFormat.getFormat("yyyy").format(new Date())
//////										 sys0500dto.setDeptCd(psnl0110Grid.getSelectionModel().getSelectedItem().getDeptCd()); 
//////										
//////										listStoreYearBusin = PrgmComComboUtils.getDeptWithBass0500ComboData(sys0500dto);
//////										businCdCombo.setStore(listStoreYearBusin);
////										 
////										psnl0110Loader.load();
////										
////										//TODO 고용데이터가 전부 삭제해서 0건일 경우 마스터 업데이트시 데이터 구분하여 저장.
////											psnl0110Loader.addLoadListener(new LoadListener(){
////												@Override
////												public void loaderLoad(LoadEvent le) {
////													// TODO Auto-generated method stub
////													super.loaderLoad(le);
////													
////													
////													try{
////														BaseListLoadResult<ModelData> data = le.getData();
////														totalLength = data.getData().size();
//////														int totalLength = data.getTotalLength();
////														
////														autoLoadFlag = new String();
////														
////														if(totalLength <= 0) {
////															autoLoadFlag = "true";
////														}else {
////															autoLoadFlag = "false";
////														}
////														
////														dto.setAutoLoadFlag(autoLoadFlag);
////
////														psnl0100Service.updateProcPsnl0100Return(dto, new AsyncCallback<Psnl0100DTO>() {
////															@Override
////															public void onSuccess(Psnl0100DTO result) {
////																
////																// 2014.08.25 고용 업데이트 후 그리드 데이터도 업데이트 처리
////																psnl0100Grid.getStore().update(result);
////																
////																//TODO 저장
////																//PersonalUtil.setSelectedComboValue(deptCd, result.getDeptCd(),"mangeDeptCd"); //기본사항 관리부서
////				                                                //deptCd.fireEvent(Events.Change, new BaseEvent(result));
////				                                                mangeDeptCd.setValue( result.getDeptCd());
////				                                                mangeDeptNm.setValue(result.getDeptNm());  
////				                                                //PersonalUtil.setSelectedComboValue(currAffnDeptCd, result.getCurrAffnDeptCd(),"deptCd"); //기본사항 부서
////				                                                currAffnDeptCd.setValue( result.getCurrAffnDeptCd());
////				                                                currAffnDeptNm.setValue(result.getCurrAffnDeptNm()); 
//////																PersonalUtil.setSelectedComboValue(typOccuCd, result.getTypOccuCd()); //직종
//////																typOccuCd.fireEvent(Events.Change, new BaseEvent(result));
//////																PersonalUtil.setSelectedComboValue(tempComboBox, result.getDtilOccuInttnCd(), "dtilOccuInttnCd"); //직종세
////																PersonalUtil.setSelectedComboValue(emymtDivCd, result.getEmymtDivCd()); //고용구분코드
////																PersonalUtil.setSelectedComboValue(hdofcCodtnCd, result.getHdofcCodtnCd()); //재직구분
////																resnRegnNum.setValue(result.getResnRegnNum());	//주민등록번호
////																hanNm.setValue(result.getHanNm());	//한글이름
////																chinCharNm.setValue(result.getChinCharNm());	//한자이름
////																currPaeWorkNm.setValue(result.getCurrPaeWorkNm());	//현근무지
////																
////																
////																DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyyMMdd");
////																if(result.getFrstEmymtDt() != null && result.getFrstEmymtDt().length() == 8){
////																	frstEmymtDt.setValue(dateTimeFormat.parse(result.getFrstEmymtDt()));
////																}else{
////																	frstEmymtDt.reset();
////																}
////																
////																if(result.getEmymtEndDt() != null && result.getEmymtEndDt().length() == 8){
////																	emymtEndDt.setValue(dateTimeFormat.parse(result.getEmymtEndDt()));
////																}else{
////																	emymtEndDt.reset();
////																}
////																
////																logSvcYrNum.setValue(result.getWorkym());
////																engNm.setValue(result.getEngNm());
////																
////																if(result.getCurrDeptAppmtDt() != null && result.getCurrDeptAppmtDt().length() == 8){
////																	currDeptAppmtDt.setValue(dateTimeFormat.parse(result.getCurrDeptAppmtDt()));
////																}else{
////																	currDeptAppmtDt.reset();
////																}
////																
////																retryReasCtnt.setValue(result.getRetryReasCtnt());
////																
////																businNm.setValue(result.getBusinNm());
////																
//////																MessageBox.info("저장완료", "고용 정보("+strReust+")가 저장되었습니다.", null);
////																// 고용데이터 신규 입력시 고용구분에 따른 전환작업
////																MessageBox.info("저장완료", "고용 정보("+strReust+")가 저장되었습니다.", new Listener<MessageBoxEvent>(){
////																	@Override
////																	public void handleEvent( MessageBoxEvent be) {
////																		
////																		
////																		// TODO Auto-generated method stub
////																		if("OK".equals(be.getButtonClicked().getText())) {
////																			// 고용구분 전환 메소드 호출
////																			psnl0100Status(dto);
////																		}
////																	}
////																});
////																
////																//기본값으로 초기화
////																autoLoadFlag = "false";
////																
////																//마스터 업데이트 후 조회
////																loaderPaging.load();
////															}
////															@Override
////															public void onFailure(Throwable caught) {
////															}
////														});
////														
////													}catch(Exception e){
////														e.printStackTrace();
////													}
////													//TODO 리스너 제거
////													psnl0110Loader.removeLoadListener(this);
////												}
////											});
////										}
////								});
//							}
//						}
//					});
//				}
//			}
//		}));
//
//		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;
	}

	// 병역
	private LayoutContainer PersonalMilitary01() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		//ButtonBar buttonBar01 = new ButtonBar();

		// LayoutContainer lcRowCol01 = new LayoutContainer(new
		// RowLayout(Orientation.HORIZONTAL));

		LayoutContainer lcTabCol01 = new LayoutContainer(new ColumnLayout());
		LayoutContainer lcTabCol02 = new LayoutContainer(new ColumnLayout());
		//LayoutContainer lcTabCol03 = new LayoutContainer(new ColumnLayout());
		//LayoutContainer lcTabCol04 = new LayoutContainer(new ColumnLayout());

		LayoutContainer lcStdLeft01 = new LayoutContainer();
		lcStdLeft01.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdLeft01.setLayout(frmlytStd);

		LayoutContainer lcStdCenter01 = new LayoutContainer();
		lcStdCenter01.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdCenter01.setLayout(frmlytStd);

		LayoutContainer lcStdLeft02 = new LayoutContainer();
		lcStdLeft02.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdLeft02.setLayout(frmlytStd);

		LayoutContainer lcStdCenter02 = new LayoutContainer();
		lcStdCenter02.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdCenter02.setLayout(frmlytStd);

		LayoutContainer lcStdLeft03 = new LayoutContainer();
		lcStdLeft03.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdLeft03.setLayout(frmlytStd);

		LayoutContainer lcStdCenter03 = new LayoutContainer();
		lcStdCenter03.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdCenter03.setLayout(frmlytStd);

		// Button topBtn = new Button("조회");
		// topBtn.setIcon(PayGenApp.ICONS.accordion());

		ContentPanel cp01 = new ContentPanel();
		cp01.setHeaderVisible(false);
		cp01.setFrame(true);
//		cp01.setSize(948, 195);
		cp01.setSize(968, 213);
		cp01.setLayout(new FitLayout());

		psnl0112EnrlntDt = new DateField();
		new DateFieldMask(psnl0112EnrlntDt, "9999.99.99");
		psnl0112EnrlntDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		psnl0112EnrlntDt.setFieldLabel("입대일자");
		lcStdLeft01.add(psnl0112EnrlntDt, new FormData("100%"));

		psnl0112DsageDt = new DateField();
		new DateFieldMask(psnl0112DsageDt, "9999.99.99");
		psnl0112DsageDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		psnl0112DsageDt.setFieldLabel("제대일자");
		lcStdCenter01.add(psnl0112DsageDt, new FormData("100%"));

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
		lcStdLeft01.add(psnl0112SrvssCd, new FormData("100%"));
		
		

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
		lcStdCenter01.add(psnl0112BaggrpCd, new FormData("100%"));
		
		
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
		lcStdLeft01.add(psnl0112AbotsCd, new FormData("100%"));

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
		lcStdCenter01.add(psnl0112ClsCd, new FormData("100%"));

		psnl0112MitySilnum = new TextField<String>();
		psnl0112MitySilnum.setFieldLabel("군번");
		lcStdLeft01.add(psnl0112MitySilnum, new FormData("100%"));

		psnl0112Mos = new TextField<String>();
		psnl0112Mos.setFieldLabel("MOS");
		lcStdCenter01.add(psnl0112Mos, new FormData("100%"));

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
		lcStdLeft01.add(psnl0112DsageDivCd, new FormData("100%"));
		
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
		lcStdCenter01.add(psnl0112ExmtnReasCd, new FormData("100%"));

		psnl0112ServcRcgtnPridCd = new ComboBox<BaseModel>();
		psnl0112ServcRcgtnPridCd.setFieldLabel("복무인정기간");
		psnl0112ServcRcgtnPridCd.setForceSelection(true);
		psnl0112ServcRcgtnPridCd.setMinChars(1);
		psnl0112ServcRcgtnPridCd.setDisplayField("commCdNm");
		psnl0112ServcRcgtnPridCd.setValueField("commCd");
		psnl0112ServcRcgtnPridCd.setTriggerAction(TriggerAction.ALL);
		psnl0112ServcRcgtnPridCd.setEmptyText("--복무인정기간선택--");
		psnl0112ServcRcgtnPridCd.setSelectOnFocus(true);
		psnl0112ServcRcgtnPridCd.setEnabled(false);
		psnl0112ServcRcgtnPridCd.setStore(listStoreA029);
		lcStdCenter02.add(psnl0112ServcRcgtnPridCd, new FormData("100%"));

		lcTabCol01.add(lcStdLeft01,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		lcTabCol01.add(lcStdCenter01,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		lcStdLeft02.add(lcTabCol01, new FormData("100%"));

		lcTabCol02.add(lcStdLeft02,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.65));
		lcTabCol02.add(lcStdCenter02,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));

		cp01.add(lcTabCol02);

		cp01.addButton(new Button("저장", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				if(psnl0100Grid.getSelectionModel().getSelectedItem() != null ) {
					MessageBox.confirm("병역 저장", "병역정보를 저장하시겠습니까?",new Listener<MessageBoxEvent>(){
		
						@Override
						public void handleEvent(MessageBoxEvent be) {
							
						//	if("Yes".equals(be.getButtonClicked().getText())){
							if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
								Psnl0112DTO saveForm = new Psnl0112DTO();
								saveForm.setDpobCd(psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
								saveForm.setSystemkey(psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
								
//								saveForm.setEnrlntDt(PersonalUtil.getConvertDateToString(psnl0112EnrlntDt, "yyyyMMdd"));//입대일자
//								saveForm.setDsageDt(PersonalUtil.getConvertDateToString(psnl0112DsageDt, "yyyyMMdd"));//제대일자
								saveForm.setEnrlntDt(GWTUtils.getStringFromDate(psnl0112EnrlntDt.getValue(), "yyyyMMdd"));//입대일자
								saveForm.setDsageDt(GWTUtils.getStringFromDate(psnl0112DsageDt.getValue(), "yyyyMMdd"));//제대일자
								saveForm.setServcRcgtnPridCd(PersonalUtil.getSelectedComboValue(psnl0112ServcRcgtnPridCd));//복무인정기간
								saveForm.setSrvssCd(PersonalUtil.getSelectedComboValue(psnl0112SrvssCd));//역종
								saveForm.setBaggrpCd(PersonalUtil.getSelectedComboValue(psnl0112BaggrpCd));//군별
								saveForm.setAbotsCd(PersonalUtil.getSelectedComboValue(psnl0112AbotsCd));//병과
								saveForm.setClsCd(PersonalUtil.getSelectedComboValue(psnl0112ClsCd));//계급
								saveForm.setMitySilnum(psnl0112MitySilnum.getValue());//군번
								saveForm.setMos(psnl0112Mos.getValue());//MOS
								saveForm.setDsageDivCd(PersonalUtil.getSelectedComboValue(psnl0112DsageDivCd));//제대구분
								saveForm.setExmtnReasCd(PersonalUtil.getSelectedComboValue(psnl0112ExmtnReasCd));//미필사유
								
								psnl0112Service.savePsnl0112(saveForm, new AsyncCallback<Integer>() {
									
									@Override
									public void onSuccess(Integer result) {
										
										MessageBox.info("성공!", "저장되었습니다.", null);
									}
									
									@Override
									public void onFailure(Throwable caught) {
										
										MessageBox.alert("실패!", "저장실패! \n" + caught.getMessage(), null);
									}
								});
							}
						}
					});
				}
			}
		}));

		lcTabFormLayer.add(cp01);
		return lcTabFormLayer;
	}

	// 신상
	private LayoutContainer PersonalData02() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		//ButtonBar buttonBar01 = new ButtonBar();
		LayoutContainer lcTabCol02 = new LayoutContainer(new ColumnLayout());
		lcTabCol02.setLayout(new FormLayout());
		
		LayoutContainer layoutContainer9 = new LayoutContainer();
		layoutContainer9.setLayout(new ColumnLayout());
		layoutContainer9.setBorders(false);
		
		LayoutContainer layoutContainer9_1 = new LayoutContainer();
		layoutContainer9_1.setBorders(false);
		FormLayout frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(80);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer9_1.setLayout(frmlytSbStd);

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
		layoutContainer9_1.add(sxDivCd, new FormData("100%"));
		
		layoutContainer9.add(layoutContainer9_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		
		
		LayoutContainer layoutContainer9_2 = new LayoutContainer();
		layoutContainer9_2.setBorders(false);
		frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(80);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer9_2.setLayout(frmlytSbStd);

		yoobhMnthDay = new MSFTextField();
		yoobhMnthDay.setFieldLabel("생년월일");
		layoutContainer9_2.add(yoobhMnthDay, new FormData("100%"));
		
		layoutContainer9.add(layoutContainer9_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		
		
		LayoutContainer layoutContainer9_3 = new LayoutContainer();
		layoutContainer9_3.setBorders(false);
		frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(80);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer9_3.setLayout(frmlytSbStd);

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
		layoutContainer9_3.add(sclcDivCd, new FormData("100%"));
		
		layoutContainer9.add(layoutContainer9_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		
		
		
		
		lcTabCol02.add(layoutContainer9, new FormData("100%"));
		
		
		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(80);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1.setLayout(frmlytSbStd);

		psnl0113Sttur = new TextField<String>();
		psnl0113Sttur.setFieldLabel("신 장");
		layoutContainer_1.add(psnl0113Sttur, new FormData("100%"));
		
		layoutContainer.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer_1.setBorders(false);

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(80);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2.setLayout(frmlytSbStd);

		psnl0113Wei = new TextField<String>();
		psnl0113Wei.setFieldLabel("체 중");
		layoutContainer_2.add(psnl0113Wei, new FormData("100%"));
		
		layoutContainer.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer_2.setBorders(false);

		LayoutContainer layoutContainer_3 = new LayoutContainer();
		frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(80);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_3.setLayout(frmlytSbStd);

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
		layoutContainer_3.add(psnl0113BldtpDivCd, new FormData("100%"));
		
		
		layoutContainer.add(layoutContainer_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer_3.setBorders(false);

		LayoutContainer layoutContainer_4 = new LayoutContainer();
		frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(80);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_4.setLayout(frmlytSbStd);

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
		layoutContainer_4.add(psnl0113PrmtsaYn, new FormData("100%"));
		
		
		layoutContainer.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer_4.setBorders(false);
		lcTabCol02.add(layoutContainer, new FormData("100%"));
		layoutContainer.setBorders(false);
		

		LayoutContainer layoutContainer_5 = new LayoutContainer();
		layoutContainer_5.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_6 = new LayoutContainer();
		layoutContainer_6.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_7 = new LayoutContainer();
		frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(80);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_7.setLayout(frmlytSbStd);

		psnl0113TnkeeVsnLf = new TextField<String>();
		psnl0113TnkeeVsnLf.setFieldLabel("나안시력(좌)");
		layoutContainer_7.add(psnl0113TnkeeVsnLf, new FormData("100%"));
		
		layoutContainer_6.add(layoutContainer_7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		layoutContainer_7.setBorders(false);

		LayoutContainer layoutContainer_12 = new LayoutContainer();
		frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(30);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_12.setLayout(frmlytSbStd);

		psnl0113TnkeeVsnRght = new TextField<String>();
		psnl0113TnkeeVsnRght.setFieldLabel("(우)");
		layoutContainer_12.add(psnl0113TnkeeVsnRght, new FormData("100%"));
		
		layoutContainer_6.add(layoutContainer_12, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_12.setBorders(false);
		layoutContainer_5.add(layoutContainer_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer_6.setBorders(false);

		LayoutContainer layoutContainer_8 = new LayoutContainer();
		layoutContainer_8.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_9 = new LayoutContainer();
		frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(80);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_9.setLayout(frmlytSbStd);

		psnl0113CorrVsnLf = new TextField<String>();
		psnl0113CorrVsnLf.setFieldLabel("교정시력(좌)");
		layoutContainer_9.add(psnl0113CorrVsnLf, new FormData("100%"));
		
		layoutContainer_8.add(layoutContainer_9, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		layoutContainer_9.setBorders(false);

		LayoutContainer layoutContainer_13 = new LayoutContainer();
		frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(30);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_13.setLayout(frmlytSbStd);

		psnl0113CorrVsnRght = new TextField<String>();
		psnl0113CorrVsnRght.setFieldLabel("(우)");
		layoutContainer_13.add(psnl0113CorrVsnRght, new FormData("100%"));
		
		layoutContainer_8.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_13.setBorders(false);
		layoutContainer_5.add(layoutContainer_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer_8.setBorders(false);

		LayoutContainer layoutContainer_10 = new LayoutContainer();
		frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(80);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_10.setLayout(frmlytSbStd);
		
		
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
		layoutContainer_10.add(psnl0113RelnFrmCd, new FormData("100%"));
		
		layoutContainer_5.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer_10.setBorders(false);

		LayoutContainer layoutContainer_11 = new LayoutContainer();
		frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(80);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_11.setLayout(frmlytSbStd);

		psnl0113HbbyCtnt = new TextField<String>();
		psnl0113HbbyCtnt.setFieldLabel("취 미");
		layoutContainer_11.add(psnl0113HbbyCtnt, new FormData("100%"));
		
		layoutContainer_5.add(layoutContainer_11, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer_11.setBorders(false);
		lcTabCol02.add(layoutContainer_5, new FormData("100%"));
		layoutContainer_5.setBorders(false);

		LayoutContainer layoutContainer_14 = new LayoutContainer();
		layoutContainer_14.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_15 = new LayoutContainer();
		frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(80);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_15.setLayout(frmlytSbStd);

		psnl0113SpityCtnt = new TextField<String>();
		psnl0113SpityCtnt.setFieldLabel("특 기");
		layoutContainer_15.add(psnl0113SpityCtnt, new FormData("100%"));
		
		layoutContainer_14.add(layoutContainer_15, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_15.setBorders(false);

		LayoutContainer layoutContainer_16 = new LayoutContainer();
		frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(80);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_16.setLayout(frmlytSbStd);

		psnl0113HlthCodtnCtnt = new TextField<String>();
		psnl0113HlthCodtnCtnt.setFieldLabel("건강상태");
		layoutContainer_16.add(psnl0113HlthCodtnCtnt, new FormData("100%"));
		
		layoutContainer_14.add(layoutContainer_16, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_16.setBorders(false);
		lcTabCol02.add(layoutContainer_14, new FormData("100%"));
		layoutContainer_14.setBorders(false);

		LayoutContainer layoutContainer_17 = new LayoutContainer();
		layoutContainer_17.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_18 = new LayoutContainer();
		frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(80);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_18.setLayout(frmlytSbStd);
		
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
		layoutContainer_18.add(psnl0113DabtyDivCd, new FormData("100%"));
		
		
		layoutContainer_17.add(layoutContainer_18,
				new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer_18.setBorders(false);

		LayoutContainer layoutContainer_19 = new LayoutContainer();
		frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(80);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_19.setLayout(frmlytSbStd);
		
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
		layoutContainer_19.add(psnl0113DabtyGrdeCd, new FormData("100%"));
		
		layoutContainer_17.add(layoutContainer_19, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer_19.setBorders(false);

		LayoutContainer layoutContainer_20 = new LayoutContainer();
		frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(80);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_20.setLayout(frmlytSbStd);

		psnl0113DabtyAjmtDt = new DateField();
		psnl0113DabtyAjmtDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		psnl0113DabtyAjmtDt.setFieldLabel("장애판정일자");
		layoutContainer_20.add(psnl0113DabtyAjmtDt, new FormData("100%"));
		
		layoutContainer_17.add(layoutContainer_20,
				new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer_20.setBorders(false);

		LayoutContainer layoutContainer_21 = new LayoutContainer();
		frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(80);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_21.setLayout(frmlytSbStd);
		layoutContainer_17.add(layoutContainer_21, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer_21.setBorders(false);
		lcTabCol02.add(layoutContainer_17, new FormData("100%"));
		layoutContainer_17.setBorders(false);

		LayoutContainer layoutContainer_22 = new LayoutContainer();
		layoutContainer_22.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_23 = new LayoutContainer();
		frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(80);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_23.setLayout(frmlytSbStd);
		
		
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
		layoutContainer_23.add(psnl0113PattVetnsDivCd, new FormData("100%"));
		
		layoutContainer_22.add(layoutContainer_23, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer_23.setBorders(false);

		LayoutContainer layoutContainer_24 = new LayoutContainer();
		frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(80);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_24.setLayout(frmlytSbStd);

		psnl0113PattVetnsNum = new TextField<String>();
		psnl0113PattVetnsNum.setFieldLabel("보훈번호");
		layoutContainer_24.add(psnl0113PattVetnsNum, new FormData("100%"));
		
		layoutContainer_22.add(layoutContainer_24, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer_24.setBorders(false);

		LayoutContainer layoutContainer_25 = new LayoutContainer();
		frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(80);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_25.setLayout(frmlytSbStd);
		
		
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
		layoutContainer_25.add(psnl0113AmomRelaDivCd, new FormData("100%"));
		
		layoutContainer_22.add(layoutContainer_25, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer_25.setBorders(false);

		LayoutContainer layoutContainer_26 = new LayoutContainer();
		frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(80);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_26.setLayout(frmlytSbStd);

		
		psnl0113PattVetnsYn = new CheckBoxGroup();
		psnl0113PattVetnsYn.setHideLabel(true);
		CheckBox checkBox = new CheckBox();
		checkBox.setBoxLabel("보훈여부");
		checkBox.setHideLabel(true);
		checkBox.setValueAttribute("Y");
		psnl0113PattVetnsYn.add(checkBox);
		layoutContainer_26.add(psnl0113PattVetnsYn, new FormData("100%"));
		
		
		// chckbxgrpNewCheckboxgroup.setFieldLabel("");
		layoutContainer_22.add(layoutContainer_26, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		layoutContainer_26.setBorders(false);
		lcTabCol02.add(layoutContainer_22, new FormData("100%"));
		layoutContainer_22.setBorders(false);

		//LayoutContainer lcTabCol03 = new LayoutContainer(new ColumnLayout());
		//LayoutContainer lcTabCol04 = new LayoutContainer(new ColumnLayout());

		LayoutContainer lcStdLeft03 = new LayoutContainer();
		lcStdLeft03.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdLeft03.setLayout(frmlytStd);

		LayoutContainer lcStdCenter03 = new LayoutContainer();
		lcStdCenter03.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(80);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdCenter03.setLayout(frmlytStd);

		// Button topBtn = new Button("조회");
		// topBtn.setIcon(PayGenApp.ICONS.accordion());

		ContentPanel cp01 = new ContentPanel();
		cp01.setHeaderVisible(false);
		cp01.setFrame(true);
		cp01.setSize(968, 213);
		cp01.setLayout(new FitLayout());

		// buttonBar01.setAlignment(HorizontalAlignment.LEFT);
		// buttonBar01.add(topBtn);

		// lcRowCol01.add(lcStdLeft01, new RowData(.5, 1));
		// lcRowCol01.add(buttonBar01, new RowData(.5, 1));

//		List<Stock> stocks = null; //TestData.getStocks();
//		Collections.sort(stocks, new Comparator<Stock>() {
//			public int compare(Stock arg0, Stock arg1) {
//				return arg0.getName().compareTo(arg1.getName());
//			}
//		});
//		ListStore<Stock> store = new ListStore<Stock>();
//		store.add(stocks);

		cp01.add(lcTabCol02);

		cp01.addButton(new Button("저장", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				if(!sxDivCd.isValid()){
					MessageBox.info("입력필수사항 확인", "성별은 필수입니다.", null);
					return;
				}
				if(!yoobhMnthDay.isValid()){
					MessageBox.info("입력필수사항 확인", "생년월일은 필수입니다.", null);
					return;
				}
				if(!psnl0113DabtyDivCd.isValid()){
					MessageBox.info("입력필수사항 확인", "장애유형은 필수입니다.", null);
					return;
				}
				if(psnl0100Grid.getSelectionModel().getSelectedItem() != null ) {
					MessageBox.confirm("신상 저장", "신상정보를 저장하시겠습니까?",new Listener<MessageBoxEvent>(){

						@Override
						public void handleEvent(MessageBoxEvent be) {
							
						//	if("Yes".equals(be.getButtonClicked().getText())){
							if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
								Psnl0113DTO saveForm = new Psnl0113DTO();
								saveForm.setDpobCd(psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
								saveForm.setSystemkey(psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
								
								saveForm.setSxDivCd(PersonalUtil.getSelectedComboValue(sxDivCd));	//성별
								saveForm.setYoobhMnthDay(yoobhMnthDay.getValue());	//생년월일
								
								saveForm.setSttur(psnl0113Sttur.getValue());//신장
								saveForm.setWei(psnl0113Wei.getValue());//체중
								saveForm.setBldtpDivCd(PersonalUtil.getSelectedComboValue(psnl0113BldtpDivCd));	//혈액형
//								saveForm.setPrmtsaYn(PersonalUtil.getCheckedRadioValue(sclcDivCd));				//음양
								saveForm.setPrmtsaYn(PersonalUtil.getCheckedRadioValue(psnl0113PrmtsaYn));		//색맹
								saveForm.setTnkeeVsnLf(psnl0113TnkeeVsnLf.getValue());//나안시력좌
								saveForm.setTnkeeVsnRght(psnl0113TnkeeVsnRght.getValue());//나안시력우
								saveForm.setCorrVsnLf(psnl0113CorrVsnLf.getValue());//교정시력좌
								saveForm.setCorrVsnRght(psnl0113CorrVsnRght.getValue());//교정시력우
								saveForm.setRelnFrmCd(PersonalUtil.getSelectedComboValue(psnl0113RelnFrmCd));//종교
								saveForm.setHbbyCtnt(psnl0113HbbyCtnt.getValue());//취미
								saveForm.setSpityCtnt(psnl0113SpityCtnt.getValue());//특기
								saveForm.setHlthCodtnCtnt(psnl0113HlthCodtnCtnt.getValue());//건강상태
								saveForm.setDabtyDivCd(PersonalUtil.getSelectedComboValue(psnl0113DabtyDivCd));//장애구분
								saveForm.setDabtyGrdeCd(PersonalUtil.getSelectedComboValue(psnl0113DabtyGrdeCd));//장애등급
//								saveForm.setDabtyAjmtDt(PersonalUtil.getConvertDateToString(psnl0113DabtyAjmtDt,"yyyyMMdd"));//장애판정일자
								saveForm.setDabtyAjmtDt(GWTUtils.getStringFromDate(psnl0113DabtyAjmtDt.getValue(),"yyyyMMdd"));//장애판정일자
								//보훈구분
								saveForm.setPattVetnsNum(psnl0113PattVetnsNum.getValue());//보훈번호
								saveForm.setAmomRelaDivCd(PersonalUtil.getSelectedComboValue(psnl0113AmomRelaDivCd));//유공자와관계
								saveForm.setPattVetnsYn(PersonalUtil.getCheckedCheckBoxValue(psnl0113PattVetnsYn));//보훈여부
								
								psnl0113Service.savePsnl0113(saveForm, new AsyncCallback<Integer>() {

									@Override
									public void onFailure(Throwable caught) {
										MessageBox.alert("실패!", "저장실패! \n" + caught.getMessage(), null);
									}

									@Override
									public void onSuccess(Integer result) {
										MessageBox.info("성공!", "저장되었습니다.", null);
									}
								});
							}
						}
					});
				}
			}
		}));

		lcTabFormLayer.add(cp01);
		return lcTabFormLayer;
	}

	
	//가족-하위탭
	private LayoutContainer PersonalFamily01() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		
		
		CheckColumnConfig checkColumn = new CheckColumnConfig();
		checkColumn.setFixed(true);
		checkColumn.setId("delChk");
		checkColumn.setHeaderText("삭제");
		checkColumn.setWidth(40);
		CellEditor checkBoxEditor = new CellEditor(new CheckBox());  
		checkColumn.setEditor(checkBoxEditor);
	    checkColumn.setMenuDisabled(true);
	    configs.add(checkColumn);
	    
	    final ComboBox<BaseModel> famyRelaDivCdCombo = new ComboBox<BaseModel>();  
	    famyRelaDivCdCombo.setForceSelection(true);
	    famyRelaDivCdCombo.setMinChars(1);
	    famyRelaDivCdCombo.setDisplayField("commCdNm");
	    famyRelaDivCdCombo.setValueField("commCd");
	    famyRelaDivCdCombo.setForceSelection(true);  
	    famyRelaDivCdCombo.setTriggerAction(TriggerAction.ALL);
	    famyRelaDivCdCombo.setStore(listStoreA019);
	    
	    CellEditor famyRelaDivCdEditor = new CellEditor(famyRelaDivCdCombo){  
	        @Override  
	        public Object preProcessValue(Object value) {  
	          if (value == null) {  
	            return value;  
	          }  
	          return famyRelaDivCdCombo.getStore().findModel(PersonalUtil.getBaseModelComboDataCd(famyRelaDivCdCombo, String.valueOf(value)));  
	        }  
	    
	        @Override  
	        public Object postProcessValue(Object value) {  
	          if (value == null) {  
	            return value;  
	          }  
	          return ((BaseModel) value).get("commCd");  
	        }  
	    };
	    
	    ColumnConfig column = new ColumnConfig();
		column.setId("famyRelaDivCd");
		column.setHeaderText("관계");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(40);
		column.setEditor(famyRelaDivCdEditor);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setRenderer(new GridCellRenderer<BaseModelData>() {

			@Override
			public Object render(BaseModelData model, String property,
					ColumnData config, int rowIndex, int colIndex,
					ListStore<BaseModelData> store, Grid<BaseModelData> grid) {
				
				if(famyRelaDivCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("famyRelaDivCd"))!= null){
					return famyRelaDivCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("famyRelaDivCd")).get("commCdNm");
				}else{
					return "";
				}
			}
		});
		configs.add(column);
		

		column = new ColumnConfig();
		column.setId("famyNm");
		column.setHeaderText("성명");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);
		
		final TextField<String> famyResnRegnNum =  new TextField<String>();
      new TextFieldMask<String>(famyResnRegnNum, "999999-9999999");  
		column = new ColumnConfig();
		column.setId("famyResnRegnNum");
		column.setHeaderText("주민번호");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setEditor(new CellEditor(famyResnRegnNum));
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setWidth(100);
		column.setRenderer(new GridCellRenderer<BaseModelData>() {
	            //-------------------------
	                        @Override
	                        public Object render(final BaseModelData model, String property,
	                                final ColumnData config, final int rowIndex, final int colIndex,
	                                final ListStore<BaseModelData> store,  Grid<BaseModelData> grid) {
	                               
	                            String btnText = model.get(property) == null ? "" : (String)model.get(property);
	                             if("".equals(btnText)){
	                                 return "";
	                             }else{
	                              //  if (famyResnRegnNum.fireEvent(Events.Add))  {
	                                  //  return famyResnRegnNum.getValue();
	                               // } else {
	                                    return btnText;
	                               // }
	                           } 
	                        }
	                    });
		configs.add(column);
		
		
		final ComboBox<BaseModel> famySupptRelaDivCdCombo = new ComboBox<BaseModel>();  
		famySupptRelaDivCdCombo.setForceSelection(true);
		famySupptRelaDivCdCombo.setMinChars(1);
		famySupptRelaDivCdCombo.setDisplayField("commCdNm");
		famySupptRelaDivCdCombo.setValueField("commCd");
		famySupptRelaDivCdCombo.setForceSelection(true);  
		famySupptRelaDivCdCombo.setTriggerAction(TriggerAction.ALL);
		famySupptRelaDivCdCombo.setStore(listStoreY012);
		
		CellEditor famySupptRelaDivCdEditor = new CellEditor(famySupptRelaDivCdCombo){  
	        @Override  
	        public Object preProcessValue(Object value) {  
	          if (value == null) {  
	            return value;  
	          }  
	          return famySupptRelaDivCdCombo.getStore().findModel(PersonalUtil.getBaseModelComboDataCd(famySupptRelaDivCdCombo, String.valueOf(value)));  
	        }  
	    
	        @Override  
	        public Object postProcessValue(Object value) {  
	          if (value == null) {  
	            return value;  
	          }  
	          return ((BaseModel) value).get("commCd");  
	        }  
	    };
		column = new ColumnConfig();
		column.setId("famySupptRelaDivCd");
		column.setHeaderText("부양관계");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(110);
		column.setEditor(famySupptRelaDivCdEditor);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setRenderer(new GridCellRenderer<BaseModelData>() {

			@Override
			public Object render(BaseModelData model, String property,
					ColumnData config, int rowIndex, int colIndex,
					ListStore<BaseModelData> store, Grid<BaseModelData> grid) {
				
				if(famySupptRelaDivCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("famySupptRelaDivCd"))!= null){
					return famySupptRelaDivCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("famySupptRelaDivCd")).get("commCdNm");
				}else{
					return "";
				}
			}
		});
		configs.add(column);
		
		
		/*
		column = new ColumnConfig();
		column.setId("yoobhMnthDay");
		column.setHeaderText("생년월일");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);
		*/
		
		final ComboBox<BaseModel> acadAbtyDivCdCombo = new ComboBox<BaseModel>();  
		acadAbtyDivCdCombo.setForceSelection(true);
		acadAbtyDivCdCombo.setMinChars(1);
		acadAbtyDivCdCombo.setDisplayField("commCdNm");
		acadAbtyDivCdCombo.setValueField("commCd");
		acadAbtyDivCdCombo.setForceSelection(true);  
		acadAbtyDivCdCombo.setTriggerAction(TriggerAction.ALL);
		acadAbtyDivCdCombo.setStore(listStoreA026);
		CellEditor acadAbtyDivCdEditor = new CellEditor(acadAbtyDivCdCombo){  
	        @Override  
	        public Object preProcessValue(Object value) {  
	          if (value == null) {  
	            return value;  
	          }  
	          return acadAbtyDivCdCombo.getStore().findModel(PersonalUtil.getBaseModelComboDataCd(acadAbtyDivCdCombo, String.valueOf(value)));  
	        }  
	    
	        @Override  
	        public Object postProcessValue(Object value) {  
	          if (value == null) {  
	            return value;  
	          }  
	          return ((BaseModel) value).get("commCd");  
	        }  
	    };
		column = new ColumnConfig();
		column.setId("acadAbtyDivCd");
		column.setHeaderText("학력");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(110);
		column.setEditor(acadAbtyDivCdEditor);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setRenderer(new GridCellRenderer<BaseModelData>() {

			@Override
			public Object render(BaseModelData model, String property,
					ColumnData config, int rowIndex, int colIndex,
					ListStore<BaseModelData> store, Grid<BaseModelData> grid) {
				
				if(acadAbtyDivCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("acadAbtyDivCd"))!= null){
					return acadAbtyDivCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("acadAbtyDivCd")).get("commCdNm");
				}else{
					return "";
				}
			}
		});
		configs.add(column);
		
		
		final ComboBox<BaseModel> crrCdCombo = new ComboBox<BaseModel>();  
		crrCdCombo.setForceSelection(true);
		crrCdCombo.setMinChars(1);
		crrCdCombo.setDisplayField("commCdNm");
		crrCdCombo.setValueField("commCd");
		crrCdCombo.setForceSelection(true);  
		crrCdCombo.setTriggerAction(TriggerAction.ALL);
		crrCdCombo.setStore(listStoreA044);
		
	    CellEditor crrCdEditor = new CellEditor(crrCdCombo){  
	        @Override  
	        public Object preProcessValue(Object value) {  
	          if (value == null) {  
	            return value;  
	          }  
	          return crrCdCombo.getStore().findModel(PersonalUtil.getBaseModelComboDataCd(crrCdCombo, String.valueOf(value)));  
	        }  
	    
	        @Override  
	        public Object postProcessValue(Object value) {  
	          if (value == null) {  
	            return value;  
	          }  
	          return ((BaseModel) value).get("commCd");  
	        }  
	    };
		column = new ColumnConfig();
		column.setId("crrCd");
		column.setHeaderText("직업");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setEditor(crrCdEditor);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setWidth(110);
		column.setRenderer(new GridCellRenderer<BaseModelData>() {

			@Override
			public Object render(BaseModelData model, String property,
					ColumnData config, int rowIndex, int colIndex,
					ListStore<BaseModelData> store, Grid<BaseModelData> grid) {
				
				if(crrCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("crrCd"))!= null){
					return crrCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("crrCd")).get("commCdNm");
				}else{
					return "";
				}
			}
		});
		configs.add(column);

		column = new ColumnConfig();
		column.setId("wkOfcNm");
		column.setHeaderText("직장명");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setWidth(100);
		configs.add(column);
		
		
		
		column = new ColumnConfig();
		column.setId("inbyNm");
		column.setHeaderText("직위명");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setWidth(110);
		configs.add(column);

		
		final ComboBox<BaseModel> frgnrYnCombo = new ComboBox<BaseModel>();  
		frgnrYnCombo.setForceSelection(true);
		frgnrYnCombo.setMinChars(1);
		frgnrYnCombo.setDisplayField("commCdNm");
		frgnrYnCombo.setValueField("commCd");
		frgnrYnCombo.setForceSelection(true);  
		frgnrYnCombo.setTriggerAction(TriggerAction.ALL);
		ListStore<BaseModel> listStoreYN = new ListStore<BaseModel>();
		BaseModel tempBaseModel = new BaseModel();
		tempBaseModel.set("commCd", "Y");
		tempBaseModel.set("commCdNm", "예");
		listStoreYN.add(tempBaseModel);
		tempBaseModel = new BaseModel();
		tempBaseModel.set("commCd", "N");
		tempBaseModel.set("commCdNm", "아니오");
		listStoreYN.add(tempBaseModel);
		frgnrYnCombo.setStore(listStoreYN);
		
		CellEditor frgnrYnEditor = new CellEditor(frgnrYnCombo){  
	        @Override  
	        public Object preProcessValue(Object value) {  
	          if (value == null) {  
	            return value;  
	          }  
	          return frgnrYnCombo.getStore().findModel(PersonalUtil.getBaseModelComboDataCd(frgnrYnCombo, String.valueOf(value)));  
	        }  
	    
	        @Override  
	        public Object postProcessValue(Object value) {  
	          if (value == null) {  
	            return value;  
	          }  
	          return ((BaseModel) value).get("commCd");  
	        }  
	    };
		
		column = new ColumnConfig();
		column.setId("frgnrYn");
		column.setHeaderText("외국인");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setEditor(frgnrYnEditor);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setRenderer(new GridCellRenderer<BaseModelData>() {

			@Override
			public Object render(BaseModelData model, String property,
					ColumnData config, int rowIndex, int colIndex,
					ListStore<BaseModelData> store, Grid<BaseModelData> grid) {
				
				if(frgnrYnCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("frgnrYn"))!= null){
					return frgnrYnCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("frgnrYn")).get("commCdNm");
				}else{
					return "";
				}
			}
		});
		configs.add(column);
		
		final ComboBox<BaseModel> dabtyDivCdCombo = new ComboBox<BaseModel>();  
		dabtyDivCdCombo.setForceSelection(true);
		dabtyDivCdCombo.setMinChars(1);
		dabtyDivCdCombo.setDisplayField("commCdNm");
		dabtyDivCdCombo.setValueField("commCd");
		dabtyDivCdCombo.setForceSelection(true);  
		dabtyDivCdCombo.setTriggerAction(TriggerAction.ALL);
		dabtyDivCdCombo.setStore(listStoreA037);
		CellEditor dabtyDivCdEditor = new CellEditor(dabtyDivCdCombo){  
	        @Override  
	        public Object preProcessValue(Object value) {  
	          if (value == null) {  
	            return value;  
	          }  
	          return dabtyDivCdCombo.getStore().findModel(PersonalUtil.getBaseModelComboDataCd(dabtyDivCdCombo, String.valueOf(value)));  
	        }  
	    
	        @Override  
	        public Object postProcessValue(Object value) {  
	          if (value == null) {  
	            return value;  
	          }  
	          return ((BaseModel) value).get("commCd");  
	        }  
	    };
		column = new ColumnConfig();
		column.setId("dabtyDivCd");
		column.setHeaderText("장애구분");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setEditor(dabtyDivCdEditor);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setWidth(80);
		column.setRenderer(new GridCellRenderer<BaseModelData>() {

			@Override
			public Object render(BaseModelData model, String property,
					ColumnData config, int rowIndex, int colIndex,
					ListStore<BaseModelData> store, Grid<BaseModelData> grid) {
				
				if(dabtyDivCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("dabtyDivCd"))!= null){
					return dabtyDivCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("dabtyDivCd")).get("commCdNm");
				}else{
					return "";
				}
			}
		});
		configs.add(column);
		
		final ComboBox<BaseModel> dabtyGrdeCdCombo = new ComboBox<BaseModel>();  
		dabtyGrdeCdCombo.setForceSelection(true);
		dabtyGrdeCdCombo.setMinChars(1);
		dabtyGrdeCdCombo.setDisplayField("commCdNm");
		dabtyGrdeCdCombo.setValueField("commCd");
		dabtyGrdeCdCombo.setForceSelection(true);  
		dabtyGrdeCdCombo.setTriggerAction(TriggerAction.ALL);
		dabtyGrdeCdCombo.setStore(listStoreA036);
		
		CellEditor dabtyGrdeCdEditor = new CellEditor(dabtyGrdeCdCombo){  
	        @Override  
	        public Object preProcessValue(Object value) {  
	          if (value == null) {  
	            return value;  
	          }  
	          return dabtyGrdeCdCombo.getStore().findModel(PersonalUtil.getBaseModelComboDataCd(dabtyGrdeCdCombo, String.valueOf(value)));  
	        }  
	    
	        @Override  
	        public Object postProcessValue(Object value) {  
	          if (value == null) {  
	            return value;  
	          }  
	          return ((BaseModel) value).get("commCd");  
	        }  
	    };
		
		column = new ColumnConfig();
		column.setId("dabtyGrdeCd");
		column.setHeaderText("장애등급");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setEditor(dabtyGrdeCdEditor);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setRenderer(new GridCellRenderer<BaseModelData>() {

			@Override
			public Object render(BaseModelData model, String property,
					ColumnData config, int rowIndex, int colIndex,
					ListStore<BaseModelData> store, Grid<BaseModelData> grid) {
				
				if(dabtyGrdeCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("dabtyGrdeCd"))!= null){
					return dabtyGrdeCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("dabtyGrdeCd")).get("commCdNm");
				}else{
					return "";
				}
			}
		});
		configs.add(column);
		
		checkColumn = new CheckColumnConfig();
		checkColumn.setFixed(true);
		checkColumn.setId("famySupptYnChk");
		checkColumn.setHeaderText("부양여부");
		checkColumn.setWidth(80);
		checkBoxEditor = new CellEditor(new CheckBox());  
		checkColumn.setEditor(checkBoxEditor);
	    checkColumn.setMenuDisabled(true);
	    configs.add(checkColumn);		
	    
		checkColumn = new CheckColumnConfig();
		checkColumn.setFixed(true);
		checkColumn.setId("yrtxYnChk");
		checkColumn.setHeaderText("연말정산");
		checkColumn.setWidth(80);
		checkBoxEditor = new CellEditor(new CheckBox());  
		checkColumn.setEditor(checkBoxEditor);
	    checkColumn.setMenuDisabled(true);
	    configs.add(checkColumn);	

		ColumnModel cm = new ColumnModel(configs);

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(968, 213);

		final EditorGrid<Psnl0115DTO> psnl0115Grid = new EditorGrid<Psnl0115DTO>(psnl0115Store, cm);
		psnl0115Grid.setStateful(true);
		psnl0115Grid.setLoadMask(true); // 작업중표시
		//psnl0115Grid.setAutoExpandColumn("famyResnRegnNum");;
		psnl0115Grid.setBorders(true);
		psnl0115Grid.addPlugin(checkColumn);
		
		psnl0115Grid.addListener(Events.CellMouseUp, new Listener<GridEvent<Psnl0115DTO>>() {

			@Override
			public void handleEvent(GridEvent<Psnl0115DTO> be) {
				
				
				if(be.getColIndex() == 0){
					if(be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())).getDelChk()){
						if(be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())).getDpobCd() == null){ //dpobCd데이터가 없으면 신규추가이므로 해당 로우를 삭제처리
							be.getGrid().getStore().remove(be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())));
						}
					}
					
					
				}
			}
			
		});
		
		cp01.add(psnl0115Grid);

		cp01.addButton(new Button("신규", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				Psnl0115DTO tempData = new Psnl0115DTO();
				
				if(psnl0115Store.getCount() > 0 && psnl0115Store.getAt(0).getDpobCd() == null){ //이미 등록을 하기위한 데이터가 있을경우
					MessageBox.info("", "먼저 추가한 데이터를 저장후 추가해주세요.", null);
				}else{
					psnl0115Grid.stopEditing();
					tempData.setDelChk(false);
					tempData.setYrtxYnChk(false);
					tempData.setFamySupptYnChk(false);
					psnl0115Store.insert(tempData, 0);
					psnl0115Grid.startEditing(psnl0115Store.indexOf(tempData), 1); 
				}
			}
		}));

		cp01.addButton(new Button("저장", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				if(psnl0100Grid.getSelectionModel().getSelectedItem() != null ) {
					MessageBox.confirm("가족 저장", "가족정보를 저장하시겠습니까?",new Listener<MessageBoxEvent>(){
						@Override
						public void handleEvent(MessageBoxEvent be) {
						//	if("Yes".equals(be.getButtonClicked().getText())){
							if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
								if(psnl0115Grid.getSelectionModel().getSelectedItem().getDelChk() == true) {
									MessageBox.confirm("가족 삭제", "삭제가 체크되어있습니다. 계속 진행하시겠습니까?<br>(삭제된 데이터는 복구되지 않습니다.)",new Listener<MessageBoxEvent>(){
										@Override
										public void handleEvent(MessageBoxEvent be) {
											// TODO Auto-generated method stub
										//	if("No".equals(be.getButtonClicked().getText())){
											if(Dialog.NO.equals(be.getButtonClicked().getItemId())){
												return;
											}else  if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
												
											//	if("Yes".equals(be.getButtonClicked().getText())){
												savePsnl0115();
											}
										}
									});
								}else {
									savePsnl0115();
								}
								
//								ArrayList<Psnl0115DTO>changePsnl0115List = new ArrayList<Psnl0115DTO>();
//								for ( int i = 0; i < psnl0115Store.getCount(); i++){
//									if(psnl0115Store.getRecord(psnl0115Store.getAt(i)).isDirty()){ //변경된 로우가 있을경우
//										psnl0115Store.getAt(i).setDpobCd(psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
//										psnl0115Store.getAt(i).setSystemkey(psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
//										changePsnl0115List.add(psnl0115Store.getAt(i));
//									}
//								}
//								//저장 시작
//								psnl0115Service.savePsnl0115(changePsnl0115List, new AsyncCallback<String>(){
//
//									@Override
//									public void onFailure(Throwable caught) {
//										
//										MessageBox.info("저장실패", "가족 정보 저장이 실패 하였습니다.", null);
//									}
//
//									@Override
//									public void onSuccess(String result) {
//										
//										MessageBox.info("저장완료", "가족 정보("+result+")가 저장되었습니다.", null);
//										psnl0115Loader.load();
//									}
//								});
							}
						}
					});
				}
				
			}
		}));

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;
	}
	
	// 자격
	private LayoutContainer PersonalTemp02() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		
		CheckColumnConfig checkColumn = new CheckColumnConfig();
		checkColumn.setFixed(true);
		checkColumn.setId("delChk");
		checkColumn.setHeaderText("삭제");
		checkColumn.setWidth(40);
		CellEditor checkBoxEditor = new CellEditor(new CheckBox());  
		checkColumn.setEditor(checkBoxEditor);
	    checkColumn.setMenuDisabled(true);
	    configs.add(checkColumn);
	    
	    DateField aqtnDtDateField = new DateField();
	    new DateFieldMask(aqtnDtDateField, "9999.99.99");
	    aqtnDtDateField.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		
	    
		ColumnConfig column = new ColumnConfig();
		column.setId("aqtnDt");
		column.setHeaderText("취득일자");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(aqtnDtDateField));
	    column.setDateTimeFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
	    column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);
		
		/*final ComboBox<BaseModel> qftntLicnsCdCombo = new ComboBox<BaseModel>();  
		qftntLicnsCdCombo.setForceSelection(true);
		qftntLicnsCdCombo.setMinChars(1);
		qftntLicnsCdCombo.setDisplayField("commCdNm");
		qftntLicnsCdCombo.setValueField("commCd");
		qftntLicnsCdCombo.setForceSelection(true);  
		qftntLicnsCdCombo.setTriggerAction(TriggerAction.ALL);
		qftntLicnsCdCombo.setStore(listStoreA014);
	    CellEditor qftntLicnsCdEditor = new CellEditor(qftntLicnsCdCombo){  
	        @Override  
	        public Object preProcessValue(Object value) {  
	          if (value == null) {  
	            return value;  
	          }  
	          return qftntLicnsCdCombo.getStore().findModel(PersonalUtil.getBaseModelComboDataCd(qftntLicnsCdCombo, String.valueOf(value)));  
	        }  
	    
	        @Override  
	        public Object postProcessValue(Object value) {  
	          if (value == null) {  
	            return value;  
	          }  
	          return ((BaseModel) value).get("commCd");
	        }  
	    };*/
		
		
		final PrgmCommFieldButton<String> msfQftntLicnsCdTxtBtn = new PrgmCommFieldButton<String>(); 
		
		column = new ColumnConfig();
		column.setId("qftntLicnsCd");
		column.setWidth(0);
		column.setHidden(true);
		configs.add(column);
		
		column = new ColumnConfig();
		column.setId("qftntLicnsCdNm");
		column.setHeaderText("자격면허");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(150);
	    column.setEditor(new CellEditor(msfQftntLicnsCdTxtBtn));
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setRenderer(new GridCellRenderer<BaseModelData>() {
	            
	            @Override
	            public Object render(final BaseModelData model, String property,
	                    final ColumnData config, final int rowIndex, final int colIndex,
	                    final ListStore<BaseModelData> store,  Grid<BaseModelData> grid) {
	                  
	                String btnText = model.get(property) == null ? "" : (String)model.get(property);
	              //  if("".equals(btnText)){
	              //      return "";
	               // }else{
	                msfQftntLicnsCdTxtBtn.addListener(Events.Change, new Listener<BaseEvent>() { 
	                        public void handleEvent(BaseEvent be) {
	                             
	                            BaseModel mapModel = (BaseModel)be.getSource(); 
	                            if (!"".equals(mapModel.get("commCd"))) {  
	                                if (psnl0200RowIndex == rowIndex) { 
	                                    // String htmlAttr = "'background-color:yellow; background-image: url(gray_gradient.gif);background-repeat: no-repeat;background-position:50%;'";
	                                    // String changeStyle = "<span style='font-weight: bold;color:red'>√</span>";  
	                                    // store.getAt(rowIndex).set("schlCd",String.valueOf(popBindingInner.getModel().get("commCd")));
	                                    // config.style = "background-color: silver;";
	                                    store.getAt(rowIndex).set("qftntLicnsCd",String.valueOf(mapModel.get("commCd")));
	                                    store.getAt(rowIndex).set("qftntLicnsCdNm",String.valueOf(mapModel.get("commCdNm"))); 
	                                    store.getAt(rowIndex).set("qftntLicnsPovncCtnt",String.valueOf(mapModel.get("commCdNm")));
	                                    store.update(store.getAt(rowIndex));
	                                    store.getRecord(store.getAt(rowIndex)).setDirty(true);
	                                    msfQftntLicnsCdTxtBtn.setAcadAbtyDivCd(""); 
	                                    msfQftntLicnsCdTxtBtn.setRpsttvCd(""); 
	                                    psnl0200RowIndex = -1;
	                                    psnl0200ColIndex = -1; 
	                                }
	                            }     
	                        }
	                    }); 
	                    return btnText;
	               // } 
	            }
	        });
		  
//		column.setRenderer(new GridCellRenderer<BaseModelData>() {
//
//			@Override
//			public Object render(BaseModelData model, String property,
//					ColumnData config, final int rowIndex, int colIndex,
//					final ListStore<BaseModelData> store, final Grid<BaseModelData> grid) {
//				
//				String btnText = model.get(property) == null ? "--자격면허--" : (String)model.get(property);
//				Button b = new Button(btnText, new SelectionListener<ButtonEvent>() {
//					
//					@Override
//					public void componentSelected(ButtonEvent ce) {
//						
//						Lov lov;     
//						LovLiveGeneric lovWindow; 
//						MSFPanelCustomForm customForm  = new MSFPanelCustomForm(new PrgmComBass0300Def(), 900, 50);
//						MSFCustomForm sysCom0130Form = customForm.getCustomForm();       
//						MSFFormPanel comform = (MSFFormPanel)sysCom0130Form;
//						final FormBinding popBindingInner = comform.getFormBinding();
//						
//						customForm.setLov(new SysComP0130());
//						lov = customForm.getLov();   
//						
//						customForm.getLov().getLovDef().addColumnFilter("rpsttvCd", "A014", SimpleColumnFilter.OPERATOR_EQUALS);
//		            	
//						popBindingInner.addListener(Events.Change, new Listener<BaseEvent>() {
//				            public void handleEvent(BaseEvent be) {
//				            	if ("A014".equals(popBindingInner.getModel().get("rpsttvCd"))) {
//				            		//코드값 및 버튼 텍스트 변경.
//				            		String changeStyle = "<span style='font-weight: bold;color:red'>√</span>";  
//				            		store.getAt(rowIndex).set("qftntLicnsCd",String.valueOf(popBindingInner.getModel().get("commCd")));
//				            		store.getAt(rowIndex).set("qftntLicnsCdNm",changeStyle+String.valueOf(popBindingInner.getModel().get("commCdNm")));
//				            		//store.getAt(rowIndex).set("qftntLicnsPovncCtnt",String.valueOf(popBindingInner.getModel().get("commCdNm")));
//				            		store.update(store.getAt(rowIndex));
//				            		store.getRecord(store.getAt(rowIndex)).setDirty(true);
//				            	}  
//				            }
//				        });
//						
//		                if (lov != null) {
//		                		lovWindow = new LovLiveGeneric(customForm.getLov().getLovDef());
//		                        lovWindow.setInitialForm(sysCom0130Form);   //formPanel을적어준다.
//		                        lovWindow.showButtonNew(true);
//		                        lovWindow.setSize(lov.getWidth(),lov.getHeight());  //팝업화면 사이즈
//		                        lovWindow.show();
//		                        lov.fixAttributeFormNames(); 
//		                }
//					}
//				});
//				
//				b.setWidth(grid.getColumnModel().getColumnWidth(colIndex)-10);
//				b.setHeight(21);
//				return b;
//			}
//		});
		configs.add(column);

		column = new ColumnConfig("qftntLicnsPovncCtnt", "자격면허분야", 200);
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("efmnIstutNm");
		column.setHeaderText("시행기관명");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(150);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("qftntLicnsNum");
		column.setHeaderText("자격면허번호");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(150);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);

		
		ColumnModel cm = new ColumnModel(configs);

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(968, 213);

		final EditorGrid<Psnl0118DTO> psnl0118Grid = new EditorGrid<Psnl0118DTO>(psnl0118Store, cm);
		psnl0118Grid.setStateful(true);
		psnl0118Grid.setLoadMask(true); // 작업중표시
		//psnl0118Grid.setAutoExpandColumn("qftntLicnsNum");;
		psnl0118Grid.setBorders(true);
		psnl0118Grid.addPlugin(checkColumn);
		
		psnl0118Grid.addListener(Events.CellMouseUp, new Listener<GridEvent<Psnl0118DTO>>() {

			@Override
			public void handleEvent(GridEvent<Psnl0118DTO> be) {
				if(be.getColIndex() == 0){
					if(be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())).getDelChk()){
						if(be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())).getDpobCd() == null){ //dpobCd데이터가 없으면 신규추가이므로 해당 로우를 삭제처리
							be.getGrid().getStore().remove(be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())));
						}
					}
				}
			}
			
		});
		

      psnl0118Grid.addListener(Events.CellMouseDown, new Listener<GridEvent<Psnl0118DTO>>() {

          @Override
          public void handleEvent(GridEvent<Psnl0118DTO> be) {
             String colId =   be.getGrid().getColumnModel().getColumnId(be.getColIndex());
              
             if ("qftntLicnsCdNm".equals(colId)) {
                 
                 psnl0200RowIndex = be.getRowIndex();
                 psnl0200ColIndex = be.getColIndex();
                 msfQftntLicnsCdTxtBtn.setAcadAbtyDivCd(""); 
                 msfQftntLicnsCdTxtBtn.setRpsttvCd("A014");  
             } else {    
                 psnl0200RowIndex = -1;
                 psnl0200ColIndex = -1; 
                 msfQftntLicnsCdTxtBtn.setAcadAbtyDivCd(""); 
                 msfQftntLicnsCdTxtBtn.setRpsttvCd("");  
             }
          }
      });
		
		
		cp01.add(psnl0118Grid);

		cp01.addButton(new Button("신규", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				Psnl0118DTO tempData = new Psnl0118DTO();
				
				if(psnl0118Store.getCount() > 0 && psnl0118Store.getAt(0).getDpobCd() == null){ //이미 등록을 하기위한 데이터가 있을경우
					MessageBox.info("", "먼저 추가한 데이터를 저장후 추가해주세요.", null);
				}else{
					psnl0118Grid.stopEditing();
					tempData.setDelChk(false);
					psnl0118Store.insert(tempData, 0);
					psnl0118Grid.startEditing(psnl0118Store.indexOf(tempData), 1); 
				}
			}
		}));

		cp01.addButton(new Button("저장", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				
				if(psnl0100Grid.getSelectionModel().getSelectedItem() != null ) {
					MessageBox.confirm("자격 저장", "자격정보를 저장하시겠습니까?",new Listener<MessageBoxEvent>(){
						@Override
						public void handleEvent(MessageBoxEvent be) {
							//if("Yes".equals(be.getButtonClicked().getText())){
							if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
								if(psnl0118Grid.getSelectionModel().getSelectedItem().getDelChk() == true) {
									MessageBox.confirm("자격 삭제", "삭제가 체크되어있습니다. 계속 진행하시겠습니까?<br>(삭제된 데이터는 복구되지 않습니다.)",new Listener<MessageBoxEvent>(){
										@Override
										public void handleEvent(MessageBoxEvent be) {
											// TODO Auto-generated method stub
											//if("No".equals(be.getButtonClicked().getText())){
											if(Dialog.NO.equals(be.getButtonClicked().getItemId())){
												return;
											}else if(Dialog.YES.equals(be.getButtonClicked().getItemId())){ 
												//if("Yes".equals(be.getButtonClicked().getText())){
												savePsnl0118();
											}
										}
									});
								}else {
									savePsnl0118();
								}
								
//								//변경된 데이터 담기
//								ArrayList<Psnl0118DTO>changePsnl0118List = new ArrayList<Psnl0118DTO>();
//								for ( int i = 0; i < psnl0118Store.getCount(); i++){
//									if(psnl0118Store.getRecord(psnl0118Store.getAt(i)).isDirty()){ //변경된 로우가 있을경우
//										psnl0118Store.getAt(i).setDpobCd(psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
//										psnl0118Store.getAt(i).setSystemkey(psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
//										changePsnl0118List.add(psnl0118Store.getAt(i));
//									}
//								}
//								//저장 시작
//								psnl0118Service.savePsnl0118(changePsnl0118List, new AsyncCallback<String>(){
//
//									@Override
//									public void onFailure(Throwable caught) {
//										MessageBox.info("저장실패", "자격 정보 저장이 실패 하였습니다.", null);
//									}
//
//									@Override
//									public void onSuccess(String result) {
//										MessageBox.info("저장완료", "자격 정보("+result+")가 저장되었습니다.", null);
//										psnl0118Loader.load();
//									}
//								});
							}
						}
					});
				}
			}
		}));

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;
	}

	// 학력
	private LayoutContainer PersonalAcademicAbility01() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		
		CheckColumnConfig checkColumn = new CheckColumnConfig();
		checkColumn.setFixed(true);
		checkColumn.setId("delChk");
		checkColumn.setHeaderText("삭제");
		checkColumn.setWidth(40);
		CellEditor checkBoxEditor = new CellEditor(new CheckBox());  
		checkColumn.setEditor(checkBoxEditor);
	    checkColumn.setMenuDisabled(true);
	    configs.add(checkColumn);
		
		
		DateField etncItshlDtDateField = new DateField();
		new DateFieldMask(etncItshlDtDateField, "9999.99.99");
		etncItshlDtDateField.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		
		
		ColumnConfig column = new ColumnConfig();
		column.setId("etncItshlDt");
		column.setHeaderText("입학일자");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(etncItshlDtDateField));
	    column.setDateTimeFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
	    column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		DateField grdtnDtField = new DateField();
		new DateFieldMask(grdtnDtField, "9999.99.99");
		grdtnDtField.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		
		
		column = new ColumnConfig();
		column.setId("grdtnDt");
		column.setHeaderText("졸업일자");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(grdtnDtField));
	    column.setDateTimeFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
	    column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);
		
		final ComboBox<BaseModel> acadAbtyDivCdCombo = new ComboBox<BaseModel>();  
		acadAbtyDivCdCombo.setForceSelection(true);
		acadAbtyDivCdCombo.setMinChars(1);
		acadAbtyDivCdCombo.setDisplayField("commCdNm");
		acadAbtyDivCdCombo.setValueField("commCd");
		acadAbtyDivCdCombo.setForceSelection(true);  
		acadAbtyDivCdCombo.setTriggerAction(TriggerAction.ALL);
		acadAbtyDivCdCombo.setStore(listStoreA026);
	    CellEditor acadAbtyDivCdEditor = new CellEditor(acadAbtyDivCdCombo){  
	        @Override  
	        public Object preProcessValue(Object value) {  
	          if (value == null) {  
	            return value;  
	          }  
	          return acadAbtyDivCdCombo.getStore().findModel(PersonalUtil.getBaseModelComboDataCd(acadAbtyDivCdCombo, String.valueOf(value)));  
	        }  
	    
	        @Override  
			public Object postProcessValue(final Object value) {
	            psnl0116Grid.getSelectionModel().getSelectedItem().setSchlCd("");
              psnl0116Grid.getSelectionModel().getSelectedItem().setSchlCdNm(""); 
				if (value == null) {
					return value;
				}
				return ((BaseModel) value).get("commCd");
			}
	    };
	    

		column = new ColumnConfig();
		column.setId("acadAbtyDivCd");
		column.setHeaderText("학력구분");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(120);
		column.setEditor(acadAbtyDivCdEditor);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setRenderer(new GridCellRenderer<BaseModelData>() {
			
			//String returnValue = "";
			
			@Override
			public Object render(BaseModelData model, String property,
					ColumnData config, final int rowIndex, int colIndex,
					final ListStore<BaseModelData> store, Grid<BaseModelData> grid) {
				
				if(acadAbtyDivCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("acadAbtyDivCd"))!= null){
					 
					return acadAbtyDivCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("acadAbtyDivCd")).get("commCdNm");
				}else{
				 
					return "";
				}
	 	
			}
		});
		configs.add(column);
		

      final PrgmCommFieldButton<String> sysCommTxtBtn = new PrgmCommFieldButton<String>(); 
        
		
		column = new ColumnConfig();
		column.setId("schlCd");
		column.setWidth(0);
		column.setHidden(true);
		configs.add(column);
		
		column = new ColumnConfig();
		column.setId("schlCdNm");
		column.setHeaderText("학교명");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(120);
		  column.setEditor(new CellEditor(sysCommTxtBtn));
	        
	        column.setRenderer(new GridCellRenderer<BaseModelData>() {
	         
	                      @Override
	                      public Object render(final BaseModelData model, String property,
	                              final ColumnData config, final int rowIndex, final int colIndex,
	                              final ListStore<BaseModelData> store,  Grid<BaseModelData> grid) {
	                            
	                          String btnText = model.get(property) == null ? "" : (String)model.get(property);
	                        //  if("".equals(btnText)){
	                        //      return "";
	                         // }else{
	                          sysCommTxtBtn.addListener(Events.Change, new Listener<BaseEvent>() { 
	                                  public void handleEvent(BaseEvent be) {
	                                       
	                                      BaseModel mapModel = (BaseModel)be.getSource(); 
	                                      if (!"".equals(mapModel.get("commCd"))) {   
	                                          
	                                          if (psnl0200RowIndex == rowIndex) {
	                                              
	                                              // String htmlAttr = "'background-color:yellow; background-image: url(gray_gradient.gif);background-repeat: no-repeat;background-position:50%;'";
	                                              //  String changeStyle = "<span style='font-weight: bold;color:red'>√</span>";  
	                                              //  store.getAt(rowIndex).set("schlCd",String.valueOf(popBindingInner.getModel().get("commCd")));
	                                             // config.style = "background-color: silver;";
	                                              store.getAt(rowIndex).set("schlCd",String.valueOf(mapModel.get("commCd")));
	                                              store.getAt(rowIndex).set("schlCdNm",String.valueOf(mapModel.get("commCdNm"))); 
	                                              store.update(store.getAt(rowIndex));
	                                              store.getRecord(store.getAt(rowIndex)).setDirty(true);
	                                              sysCommTxtBtn.setAcadAbtyDivCd(""); 
	                                              sysCommTxtBtn.setRpsttvCd(""); 
	                                              psnl0200RowIndex = -1;
	                                              psnl0200ColIndex = -1;
	                                          
	                                          }
	                                      }     
	                                  }
	                              }); 
	                              
	                              return btnText;
	                         // } 
	           
	                      }
	                      
	                  });
//		column.setRenderer(new GridCellRenderer<BaseModelData>() {
//			@Override
//			public Object render(BaseModelData model, String property,
//					ColumnData config,final int rowIndex, int colIndex,
//					final ListStore<BaseModelData> store, Grid<BaseModelData> grid) {
//				
//				
//				
//				
//				String btnText = model.get(property) == null ? "--학교명선택--" : (String)model.get(property);
//				if("--학교명선택--".equals(btnText) || "".equals(btnText)){
//					return "";
//				}else{
//					Button b = new Button(btnText, new SelectionListener<ButtonEvent>() {
//						
//						@Override
//						public void componentSelected(ButtonEvent ce) {
//							
//							
//							Lov lov;     
//							LovLiveGeneric lovWindow; 
//							MSFPanelCustomForm customForm  = new MSFPanelCustomForm(new PrgmComBass0300Def(), 900, 50);
//							MSFCustomForm sysCom0130Form = customForm.getCustomForm();    
//							MSFFormPanel comform = (MSFFormPanel)sysCom0130Form;
//							final FormBinding popBindingInner = comform.getFormBinding();
//							
//							customForm.setLov(new SysComP0130());
//							lov = customForm.getLov();   
//							
//							//학교구분의 선택에 따라..
//							String schType= store.getAt(rowIndex).get("acadAbtyDivCd");
//							
//							if(schType != null && !"".equals(schType))
//							{
//								String sch = schType.substring(schType.length()-2,schType.length()-1);
//								if("2".equals(sch)){
//									customForm.getLov().getLovDef().addColumnFilter("rpsttvCd", "A031", SimpleColumnFilter.OPERATOR_EQUALS);
//								}else if("3".equals(sch)){
//									customForm.getLov().getLovDef().addColumnFilter("rpsttvCd", "A032", SimpleColumnFilter.OPERATOR_EQUALS);
//								}else if("4".equals(sch)){
//									customForm.getLov().getLovDef().addColumnFilter("rpsttvCd", "A033", SimpleColumnFilter.OPERATOR_EQUALS);
//								}else if("5".equals(sch)){
//									customForm.getLov().getLovDef().addColumnFilter("rpsttvCd", "A034", SimpleColumnFilter.OPERATOR_EQUALS);
//								}else if("6".equals(sch)){
//									customForm.getLov().getLovDef().addColumnFilter("rpsttvCd", "A035", SimpleColumnFilter.OPERATOR_EQUALS);
//								}else{
//									lov = null;
//								}
//								
//								popBindingInner.addListener(Events.Change, new Listener<BaseEvent>() {
//						            public void handleEvent(BaseEvent be) {
//						            	if (!"".equals(popBindingInner.getModel().get("rpsttvCd"))) {
//						            		//코드값 및 버튼 텍스트 변경.
//						            		String changeStyle = "<span style='font-weight: bold;color:red'>√</span>";  
//						            		store.getAt(rowIndex).set("schlCd",String.valueOf(popBindingInner.getModel().get("commCd")));
//						            		store.getAt(rowIndex).set("schlCdNm",changeStyle+String.valueOf(popBindingInner.getModel().get("commCdNm")));
//						            		//store.getAt(rowIndex).set("qftntLicnsPovncCtnt",String.valueOf(popBindingInner.getModel().get("commCdNm")));
//						            		store.update(store.getAt(rowIndex));
//						            		store.getRecord(store.getAt(rowIndex)).setDirty(true);
//						            	}  
//						            }
//						        });
//								
//				                if (lov != null) {
//			                		lovWindow = new LovLiveGeneric(customForm.getLov().getLovDef());
//			                        lovWindow.setInitialForm(sysCom0130Form);   //formPanel을적어준다.
//			                        lovWindow.showButtonNew(true);
//			                        lovWindow.setSize(lov.getWidth(),lov.getHeight());  //팝업화면 사이즈
//			                        lovWindow.show();
//			                        lov.fixAttributeFormNames(); 
//			               
//			                	} 
//							}else{
//								MessageBox.alert("", "학력구분을 선택하여주세요.", null);
//							}
//							 
//			                   
//			                
//							
//						}
//					});
//					b.setWidth(grid.getColumnModel().getColumnWidth(colIndex)-10);
//					b.setHeight(21);
//					return b;
//				}
//				
//			}
//		});
		column.setSortable(false);
		column.setMenuDisabled(true);
		
		configs.add(column);
		
		
		  final PrgmCommFieldButton<String> msfDeprMajrCdTxtBtn = new PrgmCommFieldButton<String>(); 
	         
	        column = new ColumnConfig();
	        column.setId("deprMajrCd"); 
	        column.setWidth(0); 
	        column.setHidden(true); 
	        configs.add(column);
	            
	        column = new ColumnConfig();
	        column.setId("deprMajrNm");
	        column.setHeaderText("학과");
	        column.setAlignment(HorizontalAlignment.CENTER);
	        column.setWidth(120);
	        column.setEditor(new CellEditor(msfDeprMajrCdTxtBtn));
	        column.setSortable(false); 
	        column.setMenuDisabled(true);
	        column.setRenderer(new GridCellRenderer<BaseModelData>() {
	            
	            @Override
	            public Object render(final BaseModelData model, String property,
	                    final ColumnData config, final int rowIndex, final int colIndex,
	                    final ListStore<BaseModelData> store,  Grid<BaseModelData> grid) {
	                  
	                String btnText = model.get(property) == null ? "" : (String)model.get(property);
	              //  if("".equals(btnText)){
	              //      return "";
	               // }else{
	                msfDeprMajrCdTxtBtn.addListener(Events.Change, new Listener<BaseEvent>() { 
	                        public void handleEvent(BaseEvent be) {
	                             
	                            BaseModel mapModel = (BaseModel)be.getSource(); 
	                            if (!"".equals(mapModel.get("commCd"))) {   
	                                
	                                if (psnl0200RowIndex == rowIndex) { 
	                                    // String htmlAttr = "'background-color:yellow; background-image: url(gray_gradient.gif);background-repeat: no-repeat;background-position:50%;'";
	                                    //  String changeStyle = "<span style='font-weight: bold;color:red'>√</span>";  
	                                    //  store.getAt(rowIndex).set("schlCd",String.valueOf(popBindingInner.getModel().get("commCd")));
	                                   // config.style = "background-color: silver;";
	                                    store.getAt(rowIndex).set("deprMajrCd",String.valueOf(mapModel.get("commCd")));
	                                    store.getAt(rowIndex).set("deprMajrNm",String.valueOf(mapModel.get("commCdNm"))); 
	                                    store.update(store.getAt(rowIndex));
	                                    store.getRecord(store.getAt(rowIndex)).setDirty(true);
	                                    msfDeprMajrCdTxtBtn.setAcadAbtyDivCd(""); 
	                                    msfDeprMajrCdTxtBtn.setRpsttvCd(""); 
	                                    psnl0200RowIndex = -1;
	                                    psnl0200ColIndex = -1;
	                                
	                                }
	                            }     
	                        }
	                    }); 
	                    
	                    return btnText;
	               // } 
	 
	            }
	            
	        });
	        
	        configs.add(column);
	        
		column = new ColumnConfig();
		column.setId("mjrSpctyNm");
		column.setHeaderText("전공명");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(120);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setHidden(true);
		column.setMenuDisabled(true);
		configs.add(column);
		
		
		final ComboBox<BaseModel> degrDivCdCombo = new ComboBox<BaseModel>();  
		degrDivCdCombo.setForceSelection(true);
		degrDivCdCombo.setMinChars(1);
		degrDivCdCombo.setDisplayField("commCdNm");
		degrDivCdCombo.setValueField("commCd");
		degrDivCdCombo.setForceSelection(true);  
		degrDivCdCombo.setTriggerAction(TriggerAction.ALL);
		degrDivCdCombo.setStore(listStoreA028);
	    CellEditor degrDivCdEditor = new CellEditor(degrDivCdCombo){  
	        @Override  
	        public Object preProcessValue(Object value) {  
	          if (value == null) {  
	            return value;  
	          }  
	          return degrDivCdCombo.getStore().findModel(PersonalUtil.getBaseModelComboDataCd(degrDivCdCombo, String.valueOf(value)));  
	        }  
	    
	        @Override  
	        public Object postProcessValue(Object value) {  
	          if (value == null) {  
	            return value;  
	          }  
	          return ((BaseModel) value).get("commCd");
	        }  
	    };
		column = new ColumnConfig();
		column.setId("degrDivCd");
		column.setHeaderText("학위구분");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(degrDivCdEditor);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setRenderer(new GridCellRenderer<BaseModelData>() {

			@Override
			public Object render(BaseModelData model, String property,
					ColumnData config, int rowIndex, int colIndex,
					ListStore<BaseModelData> store, Grid<BaseModelData> grid) {
				
				if(degrDivCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("degrDivCd"))!= null){
					grid.getStore().findModel(model).set("degrNm", degrDivCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("degrDivCd")).get("commCdNm"));
					return degrDivCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("degrDivCd")).get("commCdNm");
				}else{
					grid.getStore().findModel(model).set("degrNm", "");
					return "";
				}
			}
		});
		configs.add(column);
		
		/*
		column = new ColumnConfig();
		column.setId("degrNm");
		column.setHeaderText("학위명");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(120);
		//column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);
		*/
		final ComboBox<BaseModel> lesnYrNumCdCombo = new ComboBox<BaseModel>();  
		lesnYrNumCdCombo.setForceSelection(true);
		lesnYrNumCdCombo.setMinChars(1);
		lesnYrNumCdCombo.setDisplayField("commCdNm");
		lesnYrNumCdCombo.setValueField("commCd");
		lesnYrNumCdCombo.setForceSelection(true);  
		lesnYrNumCdCombo.setTriggerAction(TriggerAction.ALL);
		lesnYrNumCdCombo.setStore(listStoreA043);
	    CellEditor lesnYrNumCdEditor = new CellEditor(lesnYrNumCdCombo){  
	        @Override  
	        public Object preProcessValue(Object value) {  
	          if (value == null) {  
	            return value;  
	          }  
	          return lesnYrNumCdCombo.getStore().findModel(PersonalUtil.getBaseModelComboDataCd(lesnYrNumCdCombo, String.valueOf(value)));  
	        }  
	    
	        @Override  
	        public Object postProcessValue(Object value) {  
	          if (value == null) {  
	            return value;  
	          }  
	          return ((BaseModel) value).get("commCd");
	        }  
	    };
		column = new ColumnConfig();
		column.setId("lesnYrNumCd");
		column.setHeaderText("수업년수");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(lesnYrNumCdEditor);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setRenderer(new GridCellRenderer<BaseModelData>() {

			@Override
			public Object render(BaseModelData model, String property,
					ColumnData config, int rowIndex, int colIndex,
					ListStore<BaseModelData> store, Grid<BaseModelData> grid) {
				
				if(lesnYrNumCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("lesnYrNumCd"))!= null){
					return lesnYrNumCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("lesnYrNumCd")).get("commCdNm");
				}else{
					return "";
				}
			}
		});
		configs.add(column);

		column = new ColumnConfig();
		column.setId("acadAbtyNoteCtnt");
		column.setHeaderText("비 고");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(150);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);


		ColumnModel cm = new ColumnModel(configs);

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(968, 213);

		psnl0116Grid = new EditorGrid<Psnl0116DTO>(psnl0116Store, cm);
		psnl0116Grid.setStateful(true);
		psnl0116Grid.setLoadMask(true); // 작업중표시
		//psnl0116Grid.setAutoExpandColumn("acadAbtyNoteCtnt");;
		psnl0116Grid.setBorders(true);
		psnl0116Grid.addPlugin(checkColumn);
		
		psnl0116Grid.addListener(Events.CellMouseUp, new Listener<GridEvent<Psnl0116DTO>>() {

			@Override
			public void handleEvent(GridEvent<Psnl0116DTO> be) {
				
				if(be.getColIndex() == 0){
					if(be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())).getDelChk()){
						if(be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())).getDpobCd() == null){ //dpobCd데이터가 없으면 신규추가이므로 해당 로우를 삭제처리
							be.getGrid().getStore().remove(be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())));
						}
					}
					
					
				}
			}
			
		});
//		psnl0116Grid.addListener(Events.CellClick, new Listener<GridEvent<Psnl0116DTO>>(){ //학교명 클릭시
//
//			@Override
//			public void handleEvent(final GridEvent<Psnl0116DTO> be) {
//				//System.out.println("CellClick = " + be.getColIndex());
//				if(be.getColIndex() == 5){
//					String schType= be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())).get("acadAbtyDivCd") == null ? "" : String.valueOf(be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())).get("acadAbtyDivCd"));
//					
//					if("".equals(schType)){
//						MessageBox.info("", "학력구분을 선택하여주세요.", null);
//					}else{
//						Lov lov;     
//						LovLiveGeneric lovWindow; 
//						MSFPanelCustomForm customForm  = new MSFPanelCustomForm(new PrgmComBass0300Def(), 900, 50);
//						MSFCustomForm sysCom0130Form = customForm.getCustomForm();    
//						MSFFormPanel comform = (MSFFormPanel)sysCom0130Form;
//						final FormBinding popBindingInner = comform.getFormBinding();
//						
//						customForm.setLov(new SysComP0130());
//						lov = customForm.getLov();   
//						String sch = schType.substring(schType.length()-2,schType.length()-1);
//						//학교구분의 선택에 따라..
//						if("2".equals(sch)){
//							customForm.getLov().getLovDef().addColumnFilter("rpsttvCd", "A031", SimpleColumnFilter.OPERATOR_EQUALS);
//						}else if("3".equals(sch)){
//							customForm.getLov().getLovDef().addColumnFilter("rpsttvCd", "A032", SimpleColumnFilter.OPERATOR_EQUALS);
//						}else if("4".equals(sch)){
//							customForm.getLov().getLovDef().addColumnFilter("rpsttvCd", "A033", SimpleColumnFilter.OPERATOR_EQUALS);
//						}else if("5".equals(sch)){
//							customForm.getLov().getLovDef().addColumnFilter("rpsttvCd", "A034", SimpleColumnFilter.OPERATOR_EQUALS);
//						}else if("6".equals(sch)){
//							customForm.getLov().getLovDef().addColumnFilter("rpsttvCd", "A035", SimpleColumnFilter.OPERATOR_EQUALS);
//						}else{
//							lov = null;
//							be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())).set("schlCd"," ");
//							be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())).set("schlCdNm","");
//		            		//store.getAt(rowIndex).set("qftntLicnsPovncCtnt",String.valueOf(popBindingInner.getModel().get("commCdNm")));
//							be.getGrid().getStore().update(be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())));
//							be.getGrid().getStore().getRecord(be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem()))).setDirty(true);
//						}
//						popBindingInner.addListener(Events.Change, new Listener<BaseEvent>() {
//
//							@Override
//							public void handleEvent(BaseEvent inbe) {
//								
//								if (!"".equals(popBindingInner.getModel().get("rpsttvCd"))) {
//									//코드값 및 버튼 텍스트 변경.
//									String changeStyle = "<span style='font-weight: bold;color:red'>√</span>";  
//				            		be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())).set("schlCd",String.valueOf(popBindingInner.getModel().get("commCd")));
//				            		be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())).set("schlCdNm",changeStyle+String.valueOf(popBindingInner.getModel().get("commCdNm")));
//				            		//store.getAt(rowIndex).set("qftntLicnsPovncCtnt",String.valueOf(popBindingInner.getModel().get("commCdNm")));
//				            		be.getGrid().getStore().update(be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())));
//				            		be.getGrid().getStore().getRecord(be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem()))).setDirty(true);
//								}
//							}
//							
//						});
//						if (lov != null) {
//		            		lovWindow = new LovLiveGeneric(customForm.getLov().getLovDef());
//		                    lovWindow.setInitialForm(sysCom0130Form);   //formPanel을적어준다.
//		                    lovWindow.showButtonNew(true);
//		                    lovWindow.setSize(lov.getWidth(),lov.getHeight());  //팝업화면 사이즈
//		                    lovWindow.show();
//		                    lov.fixAttributeFormNames(); 
//		                    
//		                }  
//					}
//				}
//			}
//			
//		});
//		psnl0116Grid.addListener(Events.AfterEdit, new Listener<GridEvent<Psnl0116DTO>>() {
//			String returnValue = "";
//			@Override
//			public void handleEvent(final GridEvent<Psnl0116DTO> be) {
//				
//				
//				if(be.getColIndex() == 3 && be.getValue() != null && !returnValue.equals(String.valueOf(be.getValue()))){ //학력구분 변경시
//					returnValue = String.valueOf(be.getValue());
//					// 팝업 시작
//					Lov lov;     
//					LovLiveGeneric lovWindow; 
//					MSFPanelCustomForm customForm  = new MSFPanelCustomForm(new PrgmComBass0300Def(), 900, 50);
//					MSFCustomForm sysCom0130Form = customForm.getCustomForm();    
//					MSFFormPanel comform = (MSFFormPanel)sysCom0130Form;
//					final FormBinding popBindingInner = comform.getFormBinding();
//					
//					customForm.setLov(new SysComP0130());
//					lov = customForm.getLov();   
//					
//					//학교구분의 선택에 따라..
//					String schType= be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())).get("acadAbtyDivCd") == null ? "" : String.valueOf(be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())).get("acadAbtyDivCd"));
//					String sch = schType.substring(schType.length()-2,schType.length()-1);
//					if("2".equals(sch)){
//						customForm.getLov().getLovDef().addColumnFilter("rpsttvCd", "A031", SimpleColumnFilter.OPERATOR_EQUALS);
//					}else if("3".equals(sch)){
//						customForm.getLov().getLovDef().addColumnFilter("rpsttvCd", "A032", SimpleColumnFilter.OPERATOR_EQUALS);
//					}else if("4".equals(sch)){
//						customForm.getLov().getLovDef().addColumnFilter("rpsttvCd", "A033", SimpleColumnFilter.OPERATOR_EQUALS);
//					}else if("5".equals(sch)){
//						customForm.getLov().getLovDef().addColumnFilter("rpsttvCd", "A034", SimpleColumnFilter.OPERATOR_EQUALS);
//					}else if("6".equals(sch)){
//						customForm.getLov().getLovDef().addColumnFilter("rpsttvCd", "A035", SimpleColumnFilter.OPERATOR_EQUALS);
//					}else{
//						lov = null;
//						be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())).set("schlCd"," ");
//						be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())).set("schlCdNm","");
//	            		//store.getAt(rowIndex).set("qftntLicnsPovncCtnt",String.valueOf(popBindingInner.getModel().get("commCdNm")));
//						be.getGrid().getStore().update(be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())));
//						be.getGrid().getStore().getRecord(be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem()))).setDirty(true);
//					}
//					popBindingInner.addListener(Events.Change, new Listener<BaseEvent>() {
//
//						@Override
//						public void handleEvent(BaseEvent inbe) {
//							
//							if (!"".equals(popBindingInner.getModel().get("rpsttvCd"))) {
//								//코드값 및 버튼 텍스트 변경.
//								String changeStyle = "<span style='font-weight: bold;color:red'>√</span>";  
//			            		be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())).set("schlCd",String.valueOf(popBindingInner.getModel().get("commCd")));
//			            		be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())).set("schlCdNm",changeStyle+String.valueOf(popBindingInner.getModel().get("commCdNm")));
//			            		//store.getAt(rowIndex).set("qftntLicnsPovncCtnt",String.valueOf(popBindingInner.getModel().get("commCdNm")));
//			            		be.getGrid().getStore().update(be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())));
//			            		be.getGrid().getStore().getRecord(be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem()))).setDirty(true);
//							}
//						}
//						
//					});
//					if (lov != null) {
//	            		lovWindow = new LovLiveGeneric(customForm.getLov().getLovDef());
//	                    lovWindow.setInitialForm(sysCom0130Form);   //formPanel을적어준다.
//	                    lovWindow.showButtonNew(true);
//	                    lovWindow.setSize(lov.getWidth(),lov.getHeight());  //팝업화면 사이즈
//	                    lovWindow.show();
//	                    lov.fixAttributeFormNames(); 
//	                    
//	                }  
//					// 팝업 끝
//				}
//				
//			}
//		});
		
		  psnl0116Grid.addListener(Events.CellMouseDown, new Listener<GridEvent<Psnl0116DTO>>() {

	            @Override
	            public void handleEvent(GridEvent<Psnl0116DTO> be) {
	               String colId =   be.getGrid().getColumnModel().getColumnId(be.getColIndex());
	                
	               if ("schlCdNm".equals(colId)) {
	                   
	                   if (MSFSharedUtils.paramNull(be.getGrid().getStore().getAt(be.getRowIndex()).get("acadAbtyDivCd"))) {
	                       MessageBox.alert("", "학력구분을 선택하여주세요.", null);
	                       return;
	                   }  
	                   
	                   psnl0200RowIndex = be.getRowIndex();
	                   psnl0200ColIndex = be.getColIndex();
	                   sysCommTxtBtn.setAcadAbtyDivCd(String.valueOf(be.getGrid().getStore().getAt(be.getRowIndex()).get("acadAbtyDivCd"))); 
	               } else if ("deprMajrNm".equals(colId)) {
	                
	                   if (MSFSharedUtils.paramNull(be.getGrid().getStore().getAt(be.getRowIndex()).get("schlCd"))) {
	                       MessageBox.alert("", "학교를 선택하여주세요.", null);
	                       return;
	                   }  
	                   psnl0200RowIndex = be.getRowIndex();
	                   psnl0200ColIndex = be.getColIndex();
	                   msfDeprMajrCdTxtBtn.setAcadAbtyDivCd(String.valueOf(be.getGrid().getStore().getAt(be.getRowIndex()).get("acadAbtyDivCd"))); 
	                   msfDeprMajrCdTxtBtn.setRpsttvCd("A027");  
	                   
	               } else {    
	                   psnl0200RowIndex = -1;
	                   psnl0200ColIndex = -1;
	                   sysCommTxtBtn.setAcadAbtyDivCd(""); 
	                   sysCommTxtBtn.setRpsttvCd("");  
	                   msfDeprMajrCdTxtBtn.setAcadAbtyDivCd(""); 
	                   msfDeprMajrCdTxtBtn.setRpsttvCd("");  
	               }
	               
	                
	            }
	            
	        });
		
		cp01.add(psnl0116Grid);

		cp01.addButton(new Button("신규", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				Psnl0116DTO tempData = new Psnl0116DTO();
				
				if(psnl0116Store.getCount() > 0 && psnl0116Store.getAt(0).getDpobCd() == null){ //이미 등록을 하기위한 데이터가 있을경우
					MessageBox.info("", "먼저 추가한 데이터를 저장후 추가해주세요.", null);
				}else{
					psnl0116Grid.stopEditing();
					tempData.setDelChk(false);
					psnl0116Store.insert(tempData, 0);
					psnl0116Grid.startEditing(psnl0116Store.indexOf(tempData), 1); 
				}
			}
		}));

		cp01.addButton(new Button("저장", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				if(psnl0100Grid.getSelectionModel().getSelectedItem() != null ) {
					MessageBox.confirm("학력 저장", "학력정보를 저장하시겠습니까?",new Listener<MessageBoxEvent>(){
						@Override
						public void handleEvent(MessageBoxEvent be) {
							//if("Yes".equals(be.getButtonClicked().getText())){
							if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
								if(psnl0116Grid.getSelectionModel().getSelectedItem().getDelChk() == true) {
									MessageBox.confirm("학력", "삭제가 체크되어있습니다. 계속 진행하시겠습니까?<br>(삭제된 데이터는 복구되지 않습니다.)",new Listener<MessageBoxEvent>(){
										@Override
										public void handleEvent(MessageBoxEvent be) {
											// TODO Auto-generated method stub
											//if("No".equals(be.getButtonClicked().getText())){
											if(Dialog.NO.equals(be.getButtonClicked().getItemId())){
												return;
											}else if(Dialog.YES.equals(be.getButtonClicked().getItemId())){ 
											//	if("Yes".equals(be.getButtonClicked().getText())){
												savePsnl0116();
											}
										}
									});
								}else {
									savePsnl0116();
								}
//								ArrayList<Psnl0116DTO>changePsnl0116List = new ArrayList<Psnl0116DTO>();
//								for ( int i = 0; i < psnl0116Store.getCount(); i++){
//									if(psnl0116Store.getRecord(psnl0116Store.getAt(i)).isDirty()){ //변경된 로우가 있을경우
//										psnl0116Store.getAt(i).setDpobCd(psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
//										psnl0116Store.getAt(i).setSystemkey(psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
//										changePsnl0116List.add(psnl0116Store.getAt(i));
//									}
//								}
//								//저장 시작
//								psnl0116Service.savePsnl0116(changePsnl0116List, new AsyncCallback<String>(){
//
//									@Override
//									public void onFailure(Throwable caught) {
//										
//										MessageBox.info("저장실패", "학력 정보 저장이 실패 하였습니다.", null);
//									}
//
//									@Override
//									public void onSuccess(String result) {
//										
//										MessageBox.info("저장완료", "학력 정보("+result+")가 저장되었습니다.", null);
//										psnl0116Loader.load();
//										
//										Psnl0100DTO dto = new Psnl0100DTO();
//										dto.setDpobCd(psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
//										dto.setSystemkey(psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
//										psnl0100Service.updateProcPsnl0100(dto, new AsyncCallback<String>() {
//											@Override
//											public void onSuccess(String result) {}
//											@Override
//											public void onFailure(Throwable caught) {}
//										});
//									}
//								});
							}
						}
					});
				}
				
			}
		}));

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;
	}
	
	
	// 경력
	private LayoutContainer PersonalTemp03() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		
		CheckColumnConfig checkColumn = new CheckColumnConfig();
		checkColumn.setFixed(true);
		checkColumn.setId("delChk");
		checkColumn.setHeaderText("삭제");
		checkColumn.setWidth(40);
		CellEditor checkBoxEditor = new CellEditor(new CheckBox());  
		checkColumn.setEditor(checkBoxEditor);
	    checkColumn.setMenuDisabled(true);
	    configs.add(checkColumn);
	    
	    DateField carrBgnnDtDateField = new DateField();
	    new DateFieldMask(carrBgnnDtDateField, "9999.99.99");
	    carrBgnnDtDateField.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		
	    
		ColumnConfig column = new ColumnConfig();
		column.setId("carrBgnnDt");
		column.setHeaderText("근무시작일자");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(90);
		column.setEditor(new CellEditor(carrBgnnDtDateField));
		
	    column.setDateTimeFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
	    column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		DateField carrEndDtDateField = new DateField();
		 new DateFieldMask(carrEndDtDateField, "9999.99.99");
		carrEndDtDateField.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		
		
		column = new ColumnConfig();
		column.setId("carrEndDt");
		column.setHeaderText("근무종료일자");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(90);
		column.setEditor(new CellEditor(carrEndDtDateField));
	    column.setDateTimeFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
	    column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig("dutyDeptNm", "부서명", 150);
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);
		
		final ComboBox<BaseModel> carrDivCdCombo = new ComboBox<BaseModel>();  
		carrDivCdCombo.setForceSelection(true);
		carrDivCdCombo.setMinChars(1);
		carrDivCdCombo.setDisplayField("commCdNm");
		carrDivCdCombo.setValueField("commCd");
		carrDivCdCombo.setForceSelection(true);  
		carrDivCdCombo.setTriggerAction(TriggerAction.ALL);
		carrDivCdCombo.setStore(listStoreA030);
	    CellEditor carrDivCdEditor = new CellEditor(carrDivCdCombo){  
	        @Override  
	        public Object preProcessValue(Object value) {  
	          if (value == null) {  
	            return value;  
	          }  
	          return carrDivCdCombo.getStore().findModel(PersonalUtil.getBaseModelComboDataCd(carrDivCdCombo, String.valueOf(value)));  
	        }  
	    
	        @Override  
	        public Object postProcessValue(Object value) {  
	          if (value == null) {  
	            return value;  
	          }  
	          return ((BaseModel) value).get("commCd");
	        }  
	    };
		column = new ColumnConfig();
		column.setId("carrDivCd");
		column.setHeaderText("경력구분");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(carrDivCdEditor);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setRenderer(new GridCellRenderer<BaseModelData>() {

			@Override
			public Object render(BaseModelData model, String property,
					ColumnData config, int rowIndex, int colIndex,
					ListStore<BaseModelData> store, Grid<BaseModelData> grid) {
				
				if(carrDivCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("carrDivCd"))!= null){
					return carrDivCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("carrDivCd")).get("commCdNm");
				}else{
					return "";
				}
			}
		});
		configs.add(column);

		column = new ColumnConfig();
		column.setId("repbtyBusinNm");
		column.setHeaderText("담당업무");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(150);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("odtyNm");
		column.setHeaderText("직책명");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(110);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);
		
		
		final ComboBox<BaseModel> cvsnRtoDivCdCombo = new ComboBox<BaseModel>();  
		cvsnRtoDivCdCombo.setForceSelection(true);
		cvsnRtoDivCdCombo.setMinChars(1);
		cvsnRtoDivCdCombo.setDisplayField("commCdNm");
		cvsnRtoDivCdCombo.setValueField("commCd");
		cvsnRtoDivCdCombo.setForceSelection(true);  
		cvsnRtoDivCdCombo.setTriggerAction(TriggerAction.ALL);
		cvsnRtoDivCdCombo.setStore(listStoreA049);
	    CellEditor cvsnRtoDivCdEditor = new CellEditor(cvsnRtoDivCdCombo){  
	        @Override  
	        public Object preProcessValue(Object value) {  
	          if (value == null) {  
	            return value;  
	          }  
	          return cvsnRtoDivCdCombo.getStore().findModel(PersonalUtil.getBaseModelComboDataCd(cvsnRtoDivCdCombo, String.valueOf(value)));  
	        }  
	    
	        @Override  
	        public Object postProcessValue(Object value) {  
	          if (value == null) {  
	            return value;  
	          }  
	          return ((BaseModel) value).get("commCd");
	        }  
	    };
		column = new ColumnConfig();
		column.setId("cvsnRtoDivCd");
		column.setHeaderText("경력인정");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(cvsnRtoDivCdEditor);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setRenderer(new GridCellRenderer<BaseModelData>() {

			@Override
			public Object render(BaseModelData model, String property,
					ColumnData config, int rowIndex, int colIndex,
					ListStore<BaseModelData> store, Grid<BaseModelData> grid) {
				
				if(cvsnRtoDivCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("cvsnRtoDivCd"))!= null){
					return cvsnRtoDivCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("cvsnRtoDivCd")).get("commCdNm");
				}else{
					return "";
				}
			}
		});
		configs.add(column);		
		
		final TextField<String> dutyYrNumTxt = new TextField<String>(); 
		dutyYrNumTxt.setReadOnly(true);
		dutyYrNumTxt.setEnabled(false);

		column = new ColumnConfig();
		column.setId("dutyYrNum");
		column.setHeaderText("근무년수");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(70);
		column.setEditor(new CellEditor(dutyYrNumTxt));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);
		
		final TextField<String> dutyMnthIcmTxt = new TextField<String>(); 
		dutyMnthIcmTxt.setReadOnly(true);
		dutyMnthIcmTxt.setEnabled(false);

		column = new ColumnConfig();
		column.setId("dutyMnthIcm");
		column.setHeaderText("근무월수");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(70);
		column.setEditor(new CellEditor(dutyMnthIcmTxt));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);
		
		final TextField<String> dutyDayNumTxt = new TextField<String>(); 
		dutyDayNumTxt.setReadOnly(true);
		dutyDayNumTxt.setEnabled(false);
		
		column = new ColumnConfig();
		column.setId("dutyDayNum");
		column.setHeaderText("근무일수");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(70);
		column.setEditor(new CellEditor(dutyDayNumTxt));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("ajmtMnthNum");
		column.setHeaderText("가감월수");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(70);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("rcgtnMnthNum");
		column.setHeaderText("인정월수");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(70);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("carrNoteCtnt");
		column.setHeaderText("비고");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(150);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);


		ColumnModel cm = new ColumnModel(configs);

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(968, 213);

		final EditorGrid<Psnl0119DTO> psnl0119Grid = new EditorGrid<Psnl0119DTO>(psnl0119Store, cm);
		psnl0119Grid.setStateful(true);
		psnl0119Grid.setLoadMask(true); // 작업중표시
		//psnl0119Grid.setAutoExpandColumn("carrNoteCtnt");;
		psnl0119Grid.setBorders(true);
		psnl0119Grid.addPlugin(checkColumn);
		
		psnl0119Grid.addListener(Events.CellMouseUp, new Listener<GridEvent<Psnl0119DTO>>() {

			@Override
			public void handleEvent(GridEvent<Psnl0119DTO> be) {
				
				if(be.getColIndex() == 0){
					if(be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())).getDelChk()){
						if(be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())).getDpobCd() == null){ //dpobCd데이터가 없으면 신규추가이므로 해당 로우를 삭제처리
							be.getGrid().getStore().remove(be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())));
						}
					}
					
					
				}
			}
			
		});
		
		cp01.add(psnl0119Grid);

		cp01.addButton(new Button("신규", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				Psnl0119DTO tempData = new Psnl0119DTO();
				
				if(psnl0119Store.getCount() > 0 && psnl0119Store.getAt(0).getDpobCd() == null){ //이미 등록을 하기위한 데이터가 있을경우
					MessageBox.info("", "먼저 추가한 데이터를 저장후 추가해주세요.", null);
				}else{
					psnl0119Grid.stopEditing();
					tempData.setDelChk(false);
					psnl0119Store.insert(tempData, 0);
					psnl0119Grid.startEditing(psnl0119Store.indexOf(tempData), 1); 
				}
			}
		}));

		cp01.addButton(new Button("저장", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				
				if(psnl0100Grid.getSelectionModel().getSelectedItem() != null ) {
					MessageBox.confirm("경력 저장", "경력정보를 저장하시겠습니까?",new Listener<MessageBoxEvent>(){
						public void handleEvent(MessageBoxEvent be) {
							//if("Yes".equals(be.getButtonClicked().getText())){
							if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
								if(psnl0119Grid.getSelectionModel().getSelectedItem().getDelChk() == true) {
									MessageBox.confirm("경력 삭제", "삭제가 체크되어있습니다. 계속 진행하시겠습니까?<br>(삭제된 데이터는 복구되지 않습니다.)",new Listener<MessageBoxEvent>(){
										@Override
										public void handleEvent(MessageBoxEvent be) {
											// TODO Auto-generated method stub
											//if("No".equals(be.getButtonClicked().getText())){
											if(Dialog.NO.equals(be.getButtonClicked().getItemId())){
												return;
											}else if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
											//	if("Yes".equals(be.getButtonClicked().getText())){
												savePsnl0119();
											}
										}
									});
								}else {
									savePsnl0119();
								}
								
//								ArrayList<Psnl0119DTO>changePsnl0119List = new ArrayList<Psnl0119DTO>();
//								for ( int i = 0; i < psnl0119Store.getCount(); i++){
//									if(psnl0119Store.getRecord(psnl0119Store.getAt(i)).isDirty()){ //변경된 로우가 있을경우
//										psnl0119Store.getAt(i).setDpobCd(psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
//										psnl0119Store.getAt(i).setSystemkey(psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
//										changePsnl0119List.add(psnl0119Store.getAt(i));
//									}
//								}
//								//저장 시작
//								psnl0119Service.savePsnl0119(changePsnl0119List, new AsyncCallback<String>(){
//
//									@Override
//									public void onFailure(Throwable caught) {
//										
//										MessageBox.info("저장실패", "경력 정보 저장이 실패 하였습니다.", null);
//									}
//
//									@Override
//									public void onSuccess(String result) {
//										
//										MessageBox.info("저장완료", "경력 정보("+result+")가 저장되었습니다.", null);
//										psnl0119Loader.load();
//									}
//								});
							}
						}
					});
				}
				
				
				
			}
		}));

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;
	}

	// 교육
	private LayoutContainer PersonalTemp04() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		
		CheckColumnConfig checkColumn = new CheckColumnConfig();
		checkColumn.setFixed(true);
		checkColumn.setId("delChk");
		checkColumn.setHeaderText("삭제");
		checkColumn.setWidth(40);
		CellEditor checkBoxEditor = new CellEditor(new CheckBox());  
		checkColumn.setEditor(checkBoxEditor);
	    checkColumn.setMenuDisabled(true);
	    configs.add(checkColumn);
	    
		ColumnConfig column = new ColumnConfig();
		column.setId("rnum");
		column.setHeaderText("번호");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(40);
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);
		
	    DateField eduBgnnDtDateField = new DateField();
	    new DateFieldMask(eduBgnnDtDateField, "9999.99.99");
	    eduBgnnDtDateField.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		
		column = new ColumnConfig();
		column.setId("eduBgnnDt");
		column.setHeaderText("일자");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setEditor(new CellEditor(eduBgnnDtDateField));
	    column.setDateTimeFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
	    column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);
		
		DateField eduEndDtDateField = new DateField();
		new DateFieldMask(eduEndDtDateField, "9999.99.99");
		eduEndDtDateField.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		
		TextField<String>  eduBgnnTm = new TextField<String>();
		new TextFieldMask<String>(eduBgnnTm, "99:99");  
		
		column = new ColumnConfig();
		column.setId("eduBgnnTm");
		column.setHeaderText("시간");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(60);
		column.setEditor(new CellEditor(eduBgnnTm));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);
		

		
		column = new ColumnConfig();
		column.setId("eduEndDt");
		column.setHeaderText("일자");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setEditor(new CellEditor(eduEndDtDateField));
	    column.setDateTimeFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
	    column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);
		
		TextField<String>  eduEndTm = new TextField<String>();
		new TextFieldMask<String>(eduEndTm, "99:99");  
		
		column = new ColumnConfig();
		column.setId("eduEndTm");
		column.setHeaderText("시간");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(60);
		column.setEditor(new CellEditor(eduEndTm));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);
		
		
		TextField<String>  kybdr = new TextField<String>();
		kybdr.setEnabled(true);
		kybdr.setReadOnly(true);
		        
		column = new ColumnConfig();
		column.setId("kybdr");
		column.setHeaderText("작성자");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(kybdr));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig("eduCmpteTm", "이수시간", 100);
		column.setAlignment(HorizontalAlignment.CENTER);
		
		
		TextField<String> numberText = new TextField<String>();
		CellEditor NumberOnlyEditor = new CellEditor(numberText){  
			@Override  
	        public Object preProcessValue(Object value) {  
	          if (value == null) {  
	            return value;  
	          }  
	          return String.valueOf(value);  
	        }  
	    
	        @Override  
	        public Object postProcessValue(Object value) {  
	          if (value == null) {  
	            return value;  
	          } 
	          
	          if(String.valueOf(value).matches("^[0-9]+$")){
	        	  return String.valueOf(value);
	          }else{
	        	  MessageBox.info("입력오류", "숫자만 입력하여주세요.", null);
	        	  return "";
	          }
	        }  
	    };
	    
	    
		column.setEditor(NumberOnlyEditor);
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("eduKndNm");
		column.setHeaderText("교육명");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(150);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("eduIstutNm");
		column.setHeaderText("주관부서");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setWidth(100);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("eduNoteCtnt");
		column.setHeaderText("비 고");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(150);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);

	
		ColumnModel cm = new ColumnModel(configs);

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(968, 213);

		final EditorGrid<Psnl0120DTO> psnl0120Grid = new EditorGrid<Psnl0120DTO>(psnl0120Store, cm);
		psnl0120Grid.setStateful(true);
		psnl0120Grid.setLoadMask(true); // 작업중표시
		psnl0120Grid.setAutoExpandColumn("eduCmpteTm");
		psnl0120Grid.setBorders(true);
		psnl0120Grid.addPlugin(checkColumn);
		
		psnl0120Grid.addListener(Events.CellMouseUp, new Listener<GridEvent<Psnl0120DTO>>() {
			@Override
			public void handleEvent(GridEvent<Psnl0120DTO> be) {
				
				if(be.getColIndex() == 0){
					if(be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())).getDelChk()){
						if(be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())).getDpobCd() == null){ //dpobCd데이터가 없으면 신규추가이므로 해당 로우를 삭제처리
							be.getGrid().getStore().remove(be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())));
						}
					}
				}
			}
		});
		
		cp01.add(psnl0120Grid);

		cp01.addButton(new Button("신규", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				Psnl0120DTO tempData = new Psnl0120DTO();
				
				if(psnl0120Store.getCount() > 0 && psnl0120Store.getAt(0).getDpobCd() == null){ //이미 등록을 하기위한 데이터가 있을경우
					MessageBox.info("", "먼저 추가한 데이터를 저장후 추가해주세요.", null);
				}else{
					psnl0120Grid.stopEditing();
					tempData.setDelChk(false);
					tempData.setKybdr(MSFMainApp.get().getUser().getUsrId());
					psnl0120Store.insert(tempData, 0);
					psnl0120Grid.startEditing(psnl0120Store.indexOf(tempData), 1); 
				}
			}
		}));

		cp01.addButton(new Button("저장", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				
				if(psnl0100Grid.getSelectionModel().getSelectedItem() != null ) {
					MessageBox.confirm("교육 저장", "교육정보를 저장하시겠습니까?",new Listener<MessageBoxEvent>(){
						@Override
						public void handleEvent(MessageBoxEvent be) {
							//if("Yes".equals(be.getButtonClicked().getText())){
							if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
								if(psnl0120Grid.getSelectionModel().getSelectedItem().getDelChk() == true) {
									MessageBox.confirm("교육 삭제", "삭제가 체크되어있습니다. 계속 진행하시겠습니까?<br>(삭제된 데이터는 복구되지 않습니다.)",new Listener<MessageBoxEvent>(){
										@Override
										public void handleEvent(MessageBoxEvent be) {
											// TODO Auto-generated method stub
											//if("No".equals(be.getButtonClicked().getText())){
											if(Dialog.NO.equals(be.getButtonClicked().getItemId())){
												return;
											}else if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
												//if("Yes".equals(be.getButtonClicked().getText())){
												savePsnl0120();
											}
										}
									});
								}else {
									savePsnl0120();
								}
							}
						}
					});
				}
			}
		}));
		
		psnl0120Grid.getColumnModel().addHeaderGroup(0, 2, new HeaderGroupConfig("교육시작", 1, 2));
		psnl0120Grid.getColumnModel().addHeaderGroup(0, 4, new HeaderGroupConfig("교육종료", 1, 2));

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;
	}

	
	
	// 포상
	private LayoutContainer PersonalTemp05() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();

		CheckColumnConfig checkColumn = new CheckColumnConfig();
		checkColumn.setFixed(true);
		checkColumn.setId("delChk");
		checkColumn.setHeaderText("삭제");
		checkColumn.setWidth(40);
		CellEditor checkBoxEditor = new CellEditor(new CheckBox());
		checkColumn.setEditor(checkBoxEditor);
		checkColumn.setMenuDisabled(true);
		configs.add(checkColumn);
			/*
		    DateField accldYrDateField = new DateField();
		    accldYrDateField.getPropertyEditor().setFormat(DateTimeFormat.getFormat("yyyy"));
			
		    
			ColumnConfig column = new ColumnConfig();
			column.setId("accldYr");
			column.setHeaderText("포상년도");
			column.setAlignment(HorizontalAlignment.CENTER);
			column.setWidth(60);
			column.setEditor(new CellEditor(accldYrDateField));
		    column.setDateTimeFormat(DateTimeFormat.getFormat("yyyy"));
		    column.setSortable(false);
		    column.setMenuDisabled(true);
			configs.add(column);
			*/
		DateField accldPrttDtDateField = new DateField();
		new DateFieldMask(accldPrttDtDateField, "9999.99.99");
		accldPrttDtDateField.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));

		ColumnConfig column = new ColumnConfig();
		column.setId("accldPrttDt");
		column.setHeaderText("포상일자");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setEditor(new CellEditor(accldPrttDtDateField));
		column.setDateTimeFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);
			
		final ComboBox<BaseModel> accldKndCdCombo = new ComboBox<BaseModel>();
		accldKndCdCombo.setForceSelection(true);
		accldKndCdCombo.setMinChars(1);
		accldKndCdCombo.setDisplayField("commCdNm");
		accldKndCdCombo.setValueField("commCd");
		accldKndCdCombo.setForceSelection(true);
		accldKndCdCombo.setTriggerAction(TriggerAction.ALL);
		accldKndCdCombo.setStore(listStoreA009);
		CellEditor accldKndCdEditor = new CellEditor(accldKndCdCombo){  
			@Override
			public Object preProcessValue(Object value) {
				if (value == null) {
					return value;
				}
				return accldKndCdCombo.getStore().findModel(PersonalUtil.getBaseModelComboDataCd(accldKndCdCombo,String.valueOf(value)));
			}

			@Override
			public Object postProcessValue(Object value) {
				if (value == null) {
					return value;
				}
				return ((BaseModel) value).get("commCd");
			}
		};
		
		column = new ColumnConfig();
		column.setId("accldKndCd");
		column.setHeaderText("포상종류");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(accldKndCdEditor);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setRenderer(new GridCellRenderer<BaseModelData>() {
			@Override
			public Object render(BaseModelData model, String property,
					ColumnData config, int rowIndex, int colIndex,
					ListStore<BaseModelData> store, Grid<BaseModelData> grid) {

				if (accldKndCdCombo.getStore().findModel("commCd",
						store.getModels().get(rowIndex).get("accldKndCd")) != null) {
					return accldKndCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("accldKndCd")).get("commCdNm");
				} else {
					return "";
				}
			}
		});
		configs.add(column);
			
		final ComboBox<BaseModel> accldDivCdCombo = new ComboBox<BaseModel>();
		accldDivCdCombo.setForceSelection(true);
		accldDivCdCombo.setMinChars(1);
		accldDivCdCombo.setDisplayField("commCdNm");
		accldDivCdCombo.setValueField("commCd");
		accldDivCdCombo.setForceSelection(true);
		accldDivCdCombo.setTriggerAction(TriggerAction.ALL);
		accldDivCdCombo.setStore(listStoreA010);

		CellEditor accldDivCdEditor = new CellEditor(accldDivCdCombo) { 
			@Override
			public Object preProcessValue(Object value) {
				if (value == null) {
					return value;
				}
				return accldDivCdCombo.getStore().findModel(PersonalUtil.getBaseModelComboDataCd(accldDivCdCombo,String.valueOf(value)));
			}
		    
			@Override
			public Object postProcessValue(Object value) {
				if (value == null) {
					return value;
				}
				return ((BaseModel) value).get("commCd");
			}
		};
		column = new ColumnConfig();
		column.setId("accldDivCd");
		column.setHeaderText("포상구분");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setEditor(accldDivCdEditor);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setRenderer(new GridCellRenderer<BaseModelData>() {

			@Override
			public Object render(BaseModelData model, String property,
					ColumnData config, int rowIndex, int colIndex,
					ListStore<BaseModelData> store, Grid<BaseModelData> grid) {

				if (accldDivCdCombo.getStore().findModel("commCd",
						store.getModels().get(rowIndex).get("accldDivCd")) != null) {
					return accldDivCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("accldDivCd")).get("commCdNm");
				} else {
					return "";
				}
			}
		});
		configs.add(column);

		column = new ColumnConfig("accldNm", "포상명", 200);
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig("accldCfmntNum", "포상서훈번호", 100);
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("efmnIstutNm");
		column.setHeaderText("시행기관");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("accldMnantCtnt");
		column.setHeaderText("포상주체");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(150);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("accldNoteCtnt");
		column.setHeaderText("비 고");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(200);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);

		
		ColumnModel cm = new ColumnModel(configs);

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(968, 213);

		final EditorGrid<Psnl0121DTO> psnl0121Grid = new EditorGrid<Psnl0121DTO>(
				psnl0121Store, cm);
		psnl0121Grid.setStateful(true);
		psnl0121Grid.setLoadMask(true); // 작업중표시
		// psnl0121Grid.setAutoExpandColumn("accldNoteCtnt");;
		psnl0121Grid.setBorders(true);
		psnl0121Grid.addPlugin(checkColumn);

			psnl0121Grid.addListener(Events.CellMouseUp, new Listener<GridEvent<Psnl0121DTO>>() {

				@Override
				public void handleEvent(GridEvent<Psnl0121DTO> be) {
					
					if(be.getColIndex() == 0){
						if(be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())).getDelChk()){
							if(be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())).getDpobCd() == null){ //dpobCd데이터가 없으면 신규추가이므로 해당 로우를 삭제처리
								be.getGrid().getStore().remove(be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())));
							}
						}
					}
				}
			});
			
			cp01.add(psnl0121Grid);

			cp01.addButton(new Button("신규", new SelectionListener<ButtonEvent>() {
				@Override
				public void componentSelected(ButtonEvent ce) {
					Psnl0121DTO tempData = new Psnl0121DTO();
					
					if(psnl0121Store.getCount() > 0 && psnl0121Store.getAt(0).getDpobCd() == null){ //이미 등록을 하기위한 데이터가 있을경우
						MessageBox.info("", "먼저 추가한 데이터를 저장후 추가해주세요.", null);
					}else{
						psnl0121Grid.stopEditing();
						tempData.setDelChk(false);
						psnl0121Store.insert(tempData, 0);
						psnl0121Grid.startEditing(psnl0121Store.indexOf(tempData), 1); 
					}
				}
			}));

			cp01.addButton(new Button("저장", new SelectionListener<ButtonEvent>() {
				@Override
				public void componentSelected(ButtonEvent ce) {
					if(psnl0100Grid.getSelectionModel().getSelectedItem() != null ) {
						MessageBox.confirm("포상 저장", "포상정보를 저장하시겠습니까?",new Listener<MessageBoxEvent>(){
							@Override
							public void handleEvent(MessageBoxEvent be) {
								//if("Yes".equals(be.getButtonClicked().getText())){
								if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
									if(psnl0121Grid.getSelectionModel().getSelectedItem().getDelChk() == true) {
										MessageBox.confirm("포상 삭제", "삭제가 체크되어있습니다. 계속 진행하시겠습니까?<br>(삭제된 데이터는 복구되지 않습니다.)",new Listener<MessageBoxEvent>(){
											@Override
											public void handleEvent(MessageBoxEvent be) {
												// TODO Auto-generated method stub
												//if("No".equals(be.getButtonClicked().getText())){
												if(Dialog.NO.equals(be.getButtonClicked().getItemId())){
													return;
												}else if(Dialog.YES.equals(be.getButtonClicked().getItemId())){ 
													//if("Yes".equals(be.getButtonClicked().getText())){
													savePsnl0121();
												}
											}
										});
									}else {
										savePsnl0121();
									}
//									ArrayList<Psnl0121DTO>changePsnl0121List = new ArrayList<Psnl0121DTO>();
//									for ( int i = 0; i < psnl0121Store.getCount(); i++){
//										if(psnl0121Store.getRecord(psnl0121Store.getAt(i)).isDirty()){ //변경된 로우가 있을경우
//											psnl0121Store.getAt(i).setDpobCd(psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
//											psnl0121Store.getAt(i).setSystemkey(psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
//											changePsnl0121List.add(psnl0121Store.getAt(i));
//										}
//									}
//									//저장 시작
//									psnl0121Service.savePsnl0121(changePsnl0121List, new AsyncCallback<String>(){
	//
//										@Override
//										public void onFailure(Throwable caught) {
//											MessageBox.info("저장실패", "포상 정보 저장이 실패 하였습니다.", null);
//										}
	//
//										@Override
//										public void onSuccess(String result) {
//											
//											MessageBox.info("저장완료", "포상 정보("+result+")가 저장되었습니다.", null);
//											psnl0121Loader.load();
//										}
//									});
								}
							}
						});
					}
				}
			}));

			lcTabFormLayer.add(cp01);

			return lcTabFormLayer;
		}

		// 징계
		private LayoutContainer PersonalTemp06() {

			LayoutContainer lcTabFormLayer = new LayoutContainer();
			List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
			
			CheckColumnConfig checkColumn = new CheckColumnConfig();
			checkColumn.setFixed(true);
			checkColumn.setId("delChk");
			checkColumn.setHeaderText("삭제");
			checkColumn.setWidth(40);
			CellEditor checkBoxEditor = new CellEditor(new CheckBox());  
			checkColumn.setEditor(checkBoxEditor);
		    checkColumn.setMenuDisabled(true);
		    configs.add(checkColumn);
			
		    DateField dsnyActDsplDtDateField = new DateField();
		    new DateFieldMask(dsnyActDsplDtDateField, "9999.99.99");
		    dsnyActDsplDtDateField.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
			
		    
		    ColumnConfig column = new ColumnConfig();
			column.setId("dsnyActDsplDt");
			column.setHeaderText("징계처분일자");
			column.setAlignment(HorizontalAlignment.CENTER);
			column.setWidth(80);
			column.setEditor(new CellEditor(dsnyActDsplDtDateField));
		    column.setDateTimeFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		    column.setSortable(false);
		    column.setMenuDisabled(true);
			configs.add(column);
			
			final ComboBox<BaseModel> dsnyActDivCdCombo = new ComboBox<BaseModel>();  
			dsnyActDivCdCombo.setForceSelection(true);
			dsnyActDivCdCombo.setMinChars(1);
			dsnyActDivCdCombo.setDisplayField("commCdNm");
			dsnyActDivCdCombo.setValueField("commCd");
			dsnyActDivCdCombo.setForceSelection(true);  
			dsnyActDivCdCombo.setTriggerAction(TriggerAction.ALL);
			dsnyActDivCdCombo.setStore(listStoreA011);
		    
		    
		    CellEditor dsnyActDivCdEditor = new CellEditor(dsnyActDivCdCombo){  
		        @Override  
		        public Object preProcessValue(Object value) {  
		          if (value == null) {  
		            return value;  
		          }  
		          return dsnyActDivCdCombo.getStore().findModel(PersonalUtil.getBaseModelComboDataCd(dsnyActDivCdCombo, String.valueOf(value)));  
		        }  
		    
		        @Override  
		        public Object postProcessValue(Object value) {  
		          if (value == null) {  
		            return value;  
		          }  
		          return ((BaseModel) value).get("commCd");
		        }  
		    };
			column = new ColumnConfig();
			column.setId("dsnyActDivCd");
			column.setHeaderText("징계구분");
			column.setAlignment(HorizontalAlignment.CENTER);
			column.setWidth(100);
			column.setEditor(dsnyActDivCdEditor);
			column.setSortable(false);
			column.setMenuDisabled(true);
			column.setRenderer(new GridCellRenderer<BaseModelData>() {

				@Override
				public Object render(BaseModelData model, String property,
						ColumnData config, int rowIndex, int colIndex,
						ListStore<BaseModelData> store, Grid<BaseModelData> grid) {
					
					if(dsnyActDivCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("dsnyActDivCd"))!= null){
						return dsnyActDivCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("dsnyActDivCd")).get("commCdNm");
					}else{
						return "";
					}
				}
			});
			configs.add(column);

			column = new ColumnConfig("dsnyActNm", "징계명", 150);
			column.setAlignment(HorizontalAlignment.CENTER);
			column.setEditor(new CellEditor(new TextField<String>()));
			column.setSortable(false);
			column.setMenuDisabled(true);
			configs.add(column);

			column = new ColumnConfig();
			column.setId("dsnyActReasCtnt");
			column.setHeaderText("징계사유");
			column.setAlignment(HorizontalAlignment.CENTER);
			column.setWidth(200);
			column.setEditor(new CellEditor(new TextField<String>()));
			column.setSortable(false);
			column.setMenuDisabled(true);
			configs.add(column);

			column = new ColumnConfig();
			column.setId("dsnyActEctgOrgn");
			column.setHeaderText("시행기관");
			column.setAlignment(HorizontalAlignment.CENTER);
			column.setWidth(100);
			column.setEditor(new CellEditor(new TextField<String>()));
			column.setSortable(false);
			column.setMenuDisabled(true);
			configs.add(column);

			DateField dsnyActBgnnDtField = new DateField();
			new DateFieldMask(dsnyActBgnnDtField, "9999.99.99");
			dsnyActBgnnDtField.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
			
			column = new ColumnConfig();
			column.setId("dsnyActBgnnDt");
			column.setHeaderText("징계시작일");
			column.setAlignment(HorizontalAlignment.CENTER);
			column.setEditor(new CellEditor(dsnyActBgnnDtField));
		    column.setDateTimeFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		    column.setSortable(false);
		    column.setMenuDisabled(true);
			column.setWidth(80);
			configs.add(column);

			DateField dsnyActEndDtField = new DateField();
			new DateFieldMask(dsnyActEndDtField, "9999.99.99");
			dsnyActEndDtField.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
			
			column = new ColumnConfig();
			column.setId("dsnyActEndDt");
			column.setHeaderText("징계종료일");
			column.setAlignment(HorizontalAlignment.CENTER);
			column.setWidth(80);
			column.setEditor(new CellEditor(dsnyActEndDtField));
		    column.setDateTimeFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		    column.setSortable(false);
		    column.setMenuDisabled(true);
			configs.add(column);

			DateField dsnyActAnstyDtField = new DateField();
			new DateFieldMask(dsnyActAnstyDtField, "9999.99.99");
			dsnyActAnstyDtField.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
			
			column = new ColumnConfig();
			column.setId("dsnyActAnstyDt");
			column.setHeaderText("징계사면일");
			column.setAlignment(HorizontalAlignment.CENTER);
			column.setWidth(80);
			column.setEditor(new CellEditor(dsnyActAnstyDtField));
		    column.setDateTimeFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		    column.setSortable(false);
		    column.setMenuDisabled(true);
			configs.add(column);
			
			final ComboBox<BaseModel> dsnyActAnstyDivCdCombo = new ComboBox<BaseModel>();  
			dsnyActAnstyDivCdCombo.setForceSelection(true);
			dsnyActAnstyDivCdCombo.setMinChars(1);
			dsnyActAnstyDivCdCombo.setDisplayField("commCdNm");
			dsnyActAnstyDivCdCombo.setValueField("commCd");
			dsnyActAnstyDivCdCombo.setForceSelection(true);  
			dsnyActAnstyDivCdCombo.setTriggerAction(TriggerAction.ALL);
			dsnyActAnstyDivCdCombo.setStore(listStoreA012);
		    
		    
		    CellEditor dsnyActAnstyDivCdEditor = new CellEditor(dsnyActAnstyDivCdCombo){  
		        @Override  
		        public Object preProcessValue(Object value) {  
		          if (value == null) {  
		            return value;  
		          }  
		          return dsnyActAnstyDivCdCombo.getStore().findModel(PersonalUtil.getBaseModelComboDataCd(dsnyActAnstyDivCdCombo, String.valueOf(value)));  
		        }  
		    
		        @Override  
		        public Object postProcessValue(Object value) {  
		          if (value == null) {  
		            return value;  
		          }  
		          return ((BaseModel) value).get("commCd");
		        }  
		    };
			column = new ColumnConfig();
			column.setId("dsnyActAnstyDivCd");
			column.setHeaderText("사면구분");
			column.setAlignment(HorizontalAlignment.CENTER);
			column.setWidth(150);
			column.setEditor(dsnyActAnstyDivCdEditor);
			column.setSortable(false);
			column.setMenuDisabled(true);
			column.setRenderer(new GridCellRenderer<BaseModelData>() {

				@Override
				public Object render(BaseModelData model, String property,
						ColumnData config, int rowIndex, int colIndex,
						ListStore<BaseModelData> store, Grid<BaseModelData> grid) {
					
					if(dsnyActAnstyDivCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("dsnyActAnstyDivCd"))!= null){
						return dsnyActAnstyDivCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("dsnyActAnstyDivCd")).get("commCdNm");
					}else{
						return "";
					}
				}
			});
			configs.add(column);

			column = new ColumnConfig();
			column.setId("dsnyActCtwpMnthIcm");
			column.setHeaderText("감봉월수");
			column.setAlignment(HorizontalAlignment.CENTER);
			column.setWidth(100);
			column.setEditor(new CellEditor(new TextField<String>()));
			column.setSortable(false);
			column.setMenuDisabled(true);
			configs.add(column);

			column = new ColumnConfig();
			column.setId("dsnyActNoteCtnt");
			column.setHeaderText("비 고");
			column.setAlignment(HorizontalAlignment.CENTER);
			column.setWidth(150);
			column.setEditor(new CellEditor(new TextField<String>()));
			column.setSortable(false);
			column.setMenuDisabled(true);
			configs.add(column);

			
			
			ColumnModel cm = new ColumnModel(configs);

			ContentPanel cp01 = new ContentPanel();
			cp01.setBodyBorder(false);
			cp01.setHeaderVisible(false);
			cp01.setLayout(new FitLayout());
			cp01.setSize(968, 213);

			final EditorGrid<Psnl0122DTO> psnl0122Grid = new EditorGrid<Psnl0122DTO>(psnl0122Store, cm);
			
			psnl0122Grid.setStateful(true);
			psnl0122Grid.setLoadMask(true); // 작업중표시
			//psnl0122Grid.setAutoExpandColumn("dsnyActNoteCtnt");;
			psnl0122Grid.setBorders(true);
			psnl0122Grid.addPlugin(checkColumn);
			
			psnl0122Grid.addListener(Events.CellMouseUp, new Listener<GridEvent<Psnl0122DTO>>() {

				@Override
				public void handleEvent(GridEvent<Psnl0122DTO> be) {
					
					if(be.getColIndex() == 0){
						if(be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())).getDelChk()){
							if(be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())).getDpobCd() == null){ //dpobCd데이터가 없으면 신규추가이므로 해당 로우를 삭제처리
								be.getGrid().getStore().remove(be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())));
							}
						}
					}
				}
			});

			cp01.add(psnl0122Grid);

			cp01.addButton(new Button("신규", new SelectionListener<ButtonEvent>() {
				@Override
				public void componentSelected(ButtonEvent ce) {
					Psnl0122DTO tempData = new Psnl0122DTO();
					
					if(psnl0122Store.getCount() > 0 && psnl0122Store.getAt(0).getDpobCd() == null){ //이미 등록을 하기위한 데이터가 있을경우
						MessageBox.info("", "먼저 추가한 데이터를 저장후 추가해주세요.", null);
					}else{
						psnl0122Grid.stopEditing();
						tempData.setDelChk(false);
						psnl0122Store.insert(tempData, 0);
						psnl0122Grid.startEditing(psnl0122Store.indexOf(tempData), 1); 
					}
				}
			}));

			cp01.addButton(new Button("저장", new SelectionListener<ButtonEvent>() {
				@Override
				public void componentSelected(ButtonEvent ce) {
					
					if(psnl0100Grid.getSelectionModel().getSelectedItem() != null ) {
						MessageBox.confirm("징계 저장", "징계정보를 저장하시겠습니까?",new Listener<MessageBoxEvent>(){

							@Override
							public void handleEvent(MessageBoxEvent be) {
								//if("Yes".equals(be.getButtonClicked().getText())){
								if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
									if(psnl0122Grid.getSelectionModel().getSelectedItem().getDelChk() == true) {
										MessageBox.confirm("징계", "삭제가 체크되어있습니다. 계속 진행하시겠습니까?<br>(삭제된 데이터는 복구되지 않습니다.)",new Listener<MessageBoxEvent>(){
											@Override
											public void handleEvent(MessageBoxEvent be) {
												// TODO Auto-generated method stub
												//if("No".equals(be.getButtonClicked().getText())){
												if(Dialog.NO.equals(be.getButtonClicked().getItemId())){
													return;
												}else if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
													//if("Yes".equals(be.getButtonClicked().getText())){
													savePsnl0122();
												}
											}
										});
									}else {
										savePsnl0122();
									}
									
//									ArrayList<Psnl0122DTO>changePsnl0122List = new ArrayList<Psnl0122DTO>();
//									for ( int i = 0; i < psnl0122Store.getCount(); i++){
//										if(psnl0122Store.getRecord(psnl0122Store.getAt(i)).isDirty()){ //변경된 로우가 있을경우
//											psnl0122Store.getAt(i).setDpobCd(psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
//											psnl0122Store.getAt(i).setSystemkey(psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
//											changePsnl0122List.add(psnl0122Store.getAt(i));
//										}
//									}
//									//저장 시작
//									psnl0122Service.savePsnl0122(changePsnl0122List, new AsyncCallback<String>(){
	//
//										@Override
//										public void onFailure(Throwable caught) {
//											MessageBox.info("저장실패", "징계 정보 저장이 실패 하였습니다.", null);
//										}
	//
//										@Override
//										public void onSuccess(String result) {
//											MessageBox.info("저장완료", "징계 정보("+result+")가 저장되었습니다.", null);
//											psnl0122Loader.load();
//										}
//									});
								}
							}
						});
					}
				}
			}));

			lcTabFormLayer.add(cp01);

			return lcTabFormLayer;
		}



	// 사회보험이력
//	private LayoutContainer InsuranceData01() {
//
//		LayoutContainer lcTabFormLayer = new LayoutContainer();
//		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
//		
//			    
///*		ColumnConfig column = new ColumnConfig();
//		column.setId("soctyInsurYr");
//		column.setHeaderText("사회보험년도");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//	    column.setMenuDisabled(true);
//		configs.add(column);
//		
//		
//		column = new ColumnConfig();
//		column.setId("hlthInsurFlucDt");
//		column.setHeaderText("사회보험변동일자");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(100);
//		column.setSortable(false);
//	    column.setMenuDisabled(true);
//		configs.add(column);
//*/
//		ColumnConfig column = new ColumnConfig("hlthInsrPayTotAmnt", "건강보험보수총액", 120);
//		column.setAlignment(HorizontalAlignment.RIGHT);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		column.setRenderer(new GridCellRenderer<Psnl0127DTO>(){
//			@Override
//			public Object render(Psnl0127DTO model, String property,
//					ColumnData config, int rowIndex, int colIndex,
//					ListStore<Psnl0127DTO> store, Grid<Psnl0127DTO> grid) {
//				return NumberFormat.getFormat("#,##0").format(Integer.parseInt(model.get(property).toString()));
//			}
//		});
//		configs.add(column);
//
//		column = new ColumnConfig("hlthInsrMnthRuntnAmnt", "건강보험보수월액", 120);
//		column.setAlignment(HorizontalAlignment.RIGHT);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		column.setRenderer(new GridCellRenderer<Psnl0127DTO>(){
//			@Override
//			public Object render(Psnl0127DTO model, String property,
//					ColumnData config, int rowIndex, int colIndex,
//					ListStore<Psnl0127DTO> store, Grid<Psnl0127DTO> grid) {
//				return NumberFormat.getFormat("#,##0").format(Integer.parseInt(model.get(property).toString()));
//			}
//		});
//		configs.add(column);
//
//		column = new ColumnConfig("natPennStdIncmMnthAmnt", "국민기준소득월액", 120);
//		column.setAlignment(HorizontalAlignment.RIGHT);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		column.setRenderer(new GridCellRenderer<Psnl0127DTO>(){
//			@Override
//			public Object render(Psnl0127DTO model, String property,
//					ColumnData config, int rowIndex, int colIndex,
//					ListStore<Psnl0127DTO> store, Grid<Psnl0127DTO> grid) {
//				return NumberFormat.getFormat("#,##0").format(Integer.parseInt(model.get(property).toString()));
//			}
//		});
//		configs.add(column);
//		
//		column = new ColumnConfig("umytInsrPayMnthAmnt", "고용보험보수월액", 120);
//		column.setAlignment(HorizontalAlignment.RIGHT);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		column.setRenderer(new GridCellRenderer<Psnl0127DTO>(){
//			@Override
//			public Object render(Psnl0127DTO model, String property,
//					ColumnData config, int rowIndex, int colIndex,
//					ListStore<Psnl0127DTO> store, Grid<Psnl0127DTO> grid) {
//				return NumberFormat.getFormat("#,##0").format(Integer.parseInt(model.get(property).toString()));
//			}
//		});
//		configs.add(column);
//		
//		column = new ColumnConfig("idtlAccdtPayMnthAmnt", "산재보험보수월액", 120);
//		column.setAlignment(HorizontalAlignment.RIGHT);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		column.setRenderer(new GridCellRenderer<Psnl0127DTO>(){
//			@Override
//			public Object render(Psnl0127DTO model, String property,
//					ColumnData config, int rowIndex, int colIndex,
//					ListStore<Psnl0127DTO> store, Grid<Psnl0127DTO> grid) {
//				return NumberFormat.getFormat("#,##0").format(Integer.parseInt(model.get(property).toString()));
//			}
//		});
//		configs.add(column);
//		
//		CheckColumnConfig ckColumn = new CheckColumnConfig("hlthInsrApptnChk", "건강보험", 90);
//		ckColumn.setAlignment(HorizontalAlignment.CENTER);
//		ckColumn.setSortable(false);
//		ckColumn.setMenuDisabled(true);
//		configs.add(ckColumn);
//		
//		ckColumn = new CheckColumnConfig("natPennApptnChk", "국민연금", 90);
//		ckColumn.setAlignment(HorizontalAlignment.CENTER);
//		ckColumn.setSortable(false);
//		ckColumn.setMenuDisabled(true);
//		configs.add(ckColumn);
//		
//		ckColumn = new CheckColumnConfig("umytInsrApptnChk", "고용보험", 90);
//		ckColumn.setAlignment(HorizontalAlignment.CENTER);
//		ckColumn.setSortable(false);
//		ckColumn.setMenuDisabled(true);
//		configs.add(ckColumn);
//		
//		ckColumn = new CheckColumnConfig("idtlAccdtInsurApptnChk", "산재보험", 90);
//		ckColumn.setAlignment(HorizontalAlignment.CENTER);
//		ckColumn.setSortable(false);
//		ckColumn.setMenuDisabled(true);
//		configs.add(ckColumn);
//		
////		final ComboBox<BaseModel> apptnYnCombo = new ComboBox<BaseModel>();  
////		apptnYnCombo.setForceSelection(true);
////		apptnYnCombo.setMinChars(1);
////		apptnYnCombo.setDisplayField("commCdNm");
////		apptnYnCombo.setValueField("commCd");
////		apptnYnCombo.setForceSelection(true);  
////		apptnYnCombo.setTriggerAction(TriggerAction.ALL);
////		ListStore<BaseModel> lsApptnYnComboYN = new ListStore<BaseModel>();
////		BaseModel apptnYnBaseModel = new BaseModel();
////		apptnYnBaseModel.set("commCd", "Y");
////		apptnYnBaseModel.set("commCdNm", "Y");
////		lsApptnYnComboYN.add(apptnYnBaseModel);
////		apptnYnBaseModel = new BaseModel();
////		apptnYnBaseModel.set("commCd", "N");
////		apptnYnBaseModel.set("commCdNm", "N");
////		lsApptnYnComboYN.add(apptnYnBaseModel);
////		apptnYnCombo.setStore(lsApptnYnComboYN);
////		
////		CellEditor apptnYnEditor = new CellEditor(apptnYnCombo){  
////	        @Override  
////	        public Object preProcessValue(Object value) {  
////	          if (value == null) {  
////	            return value;  
////	          }  
////	          return apptnYnCombo.getStore().findModel(PersonalUtil.getBaseModelComboDataCd(apptnYnCombo, String.valueOf(value)));  
////	        }  
////	    
////	        @Override  
////	        public Object postProcessValue(Object value) {  
////	          if (value == null) {  
////	            return value;  
////	          }  
////	          return ((BaseModel) value).get("commCd");  
////	        }  
////	    };
////		
////		
//////		column = new ColumnConfig("hlthInsrApptnYn", "건강보험", 90);
////	    column = new ColumnConfig();
////		column.setId("hlthInsrApptnYn");
////		column.setHeaderText("건강보험");
////		column.setAlignment(HorizontalAlignment.CENTER);
////		column.setWidth(90);
////		column.setEditor(apptnYnEditor);
////		column.setSortable(false);
////		column.setMenuDisabled(true);
////		column.setRenderer(new GridCellRenderer<BaseModelData>() {
////			@Override
////			public Object render(BaseModelData model, String property,
////					ColumnData config, int rowIndex, int colIndex,
////					ListStore<BaseModelData> store, Grid<BaseModelData> grid) {
////				
////				if(apptnYnCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("hlthInsrApptnYn"))!= null){
////					return apptnYnCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("hlthInsrApptnYn")).get("commCdNm");
////				}else{
////					return "";
////				}
////			}
////		});
////		configs.add(column);
////		
////		column = new ColumnConfig("natPennApptnYn", "국민연금", 90);
////		column.setAlignment(HorizontalAlignment.CENTER);
////		column.setSortable(false);
////		column.setMenuDisabled(true);
////		configs.add(column);
////		
////		
////		column = new ColumnConfig("umytInsrApptnYn", "고용보험", 90);
////		column.setAlignment(HorizontalAlignment.CENTER);
////		column.setSortable(false);
////		column.setMenuDisabled(true);
////		configs.add(column);
////		
////		column = new ColumnConfig("idtlAccdtInsurApptnYn", "산재보험", 90);
////		column.setAlignment(HorizontalAlignment.CENTER);
////		column.setSortable(false);
////		column.setMenuDisabled(true);
////		configs.add(column);
//
//		
//		ColumnModel cm = new ColumnModel(configs);
//
//		ContentPanel cp01 = new ContentPanel();
//		cp01.setBodyBorder(false);
//		cp01.setHeaderVisible(false);
//		cp01.setLayout(new FitLayout());
//		cp01.setSize(968, 213);
//		
//		
//		final Grid<Psnl0127DTO> psnl0127Grid = new Grid<Psnl0127DTO>(psnl0127Store, cm);
//		psnl0127Grid.setStateful(true);
//		psnl0127Grid.setLoadMask(true); // 작업중표시
//		psnl0127Grid.setAutoExpandColumn("hlthInsrPayTotAmnt");;
//		psnl0127Grid.setBorders(true);
//		 
//
//		cp01.add(psnl0127Grid);
//
//		
//		
//		lcTabFormLayer.add(cp01);
//
//		return lcTabFormLayer;
//	}
	
	
	// 관련근거
	private LayoutContainer RefeData01() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		
		
		CheckColumnConfig checkColumn = new CheckColumnConfig();
		checkColumn.setId("delChk");
		checkColumn.setHeaderText("삭제");
		checkColumn.setWidth(40);
		CellEditor checkBoxEditor = new CellEditor(new CheckBox());  
		checkColumn.setEditor(checkBoxEditor);
	    checkColumn.setMenuDisabled(true);
	   // checkColumn.setFixed(true);
//	    configs.add(checkColumn);
	    
		
		ColumnConfig column = new ColumnConfig();
		column.setId("rnum");
		column.setHeaderText("번호");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(40);
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);
		
//		column = new ColumnConfig();
//		column.setId("refeSeilNum");
//		column.setHeaderText("관련근거일련번호");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setEditor(new CellEditor(new TextField<String>()));
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		column.setHidden(false);
//		configs.add(column);
		
		DateField emymtBgnnDtDateField = new DateField();
		 
		emymtBgnnDtDateField.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		new DateFieldMask(emymtBgnnDtDateField, "9999.99.99"); 
		
		column = new ColumnConfig();
		column.setId("refeIndt");
		column.setHeaderText("시작일자");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setEditor(new CellEditor(emymtBgnnDtDateField));
	    column.setDateTimeFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
	    column.setSortable(false);
	    column.setMenuDisabled(true);
	    configs.add(column);
		
//		DateField dateField = new DateField();
//		dateField.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
//		new DateFieldMask(dateField, "9999.99.99"); 
//		
//		column = new ColumnConfig();
//		column.setId("refeIndt");
//		column.setHeaderText("등록(계약)일자");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(150);
//		column.setEditor(new CellEditor(dateField));
//	    column.setDateTimeFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
//	    column.setSortable(false);
//	    column.setMenuDisabled(true);
//	    configs.add(column);
	    
	    
		final ComboBox<BaseModel> refeDivCdCombo = new ComboBox<BaseModel>();  
		refeDivCdCombo.setForceSelection(true);
		refeDivCdCombo.setMinChars(1);
		refeDivCdCombo.setDisplayField("commCdNm");
		refeDivCdCombo.setValueField("commCd");
		refeDivCdCombo.setForceSelection(true);  
		refeDivCdCombo.setTriggerAction(TriggerAction.ALL);
		refeDivCdCombo.setStore(listStoreA051);
	    
	    CellEditor refeDivCdEditor = new CellEditor(refeDivCdCombo){  
	        @Override  
	        public Object preProcessValue(Object value) {  
	          if (value == null) {  
	            return value;  
	          }  
	          return refeDivCdCombo.getStore().findModel(PersonalUtil.getBaseModelComboDataCd(refeDivCdCombo, String.valueOf(value)));  
	        }  
	    
	        @Override  
	        public Object postProcessValue(Object value) {  
	          if (value == null) {  
	            return value;  
	          }  
	          return ((BaseModel) value).get("commCd");
	        }  
	    };
		
		
		
		column = new ColumnConfig();
		column.setId("refeDivCd");
		column.setHeaderText("구분");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setEditor(refeDivCdEditor);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setRenderer(new GridCellRenderer<BaseModelData>() {
			@Override
			public Object render(BaseModelData model, String property,
					ColumnData config, int rowIndex, int colIndex,
					ListStore<BaseModelData> store, Grid<BaseModelData> grid) {
				
				if(refeDivCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("refeDivCd"))!= null){
					return refeDivCdCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("refeDivCd")).get("commCdNm");
				}else{
					return "";
				}
			}
		});
		configs.add(column);
		
		column = new ColumnConfig();
		column.setId("refeTitl");
		column.setHeaderText("관련근거제목");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(200);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);
		
		column = new ColumnConfig();
		column.setId("refePrchNmTitl");
		column.setHeaderText("담당자(전화번호)");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(150);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);
		
//      GridCellRenderer buttonRenderer1 = new GridCellRenderer() {
//
//      	private boolean init;
//
////          public Object render(final Stock model, String property, ColumnData config, final int rowIndex,
////              final int colIndex, ListStore<Stock> store, Grid grid) {
////            if (!init) {
////              init = true;
////              grid.addListener(Events.Change, new Listener<GridEvent<Stock>>() {
////                public void handleEvent(GridEvent<Stock> be) {
////              	  
////              	  Window.alert("발생");
////              	  
////                  for (int i = 0; i < be.getGrid().getStore().getCount(); i++) {
////                    if (be.getGrid().getView().getWidget(i, be.getColIndex()) != null
////                        && be.getGrid().getView().getWidget(i, be.getColIndex()) instanceof BoxComponent) {
////                      ((BoxComponent) be.getGrid().getView().getWidget(i, be.getColIndex())).setWidth(be.getWidth() - 10);
////                    }
////                  }
////                }
////              });
////            }
////
////            Button b = new Button((String) model.get(property), new SelectionListener<ButtonEvent>() {
////              @Override
////              public void componentSelected(ButtonEvent ce) {
////                Info.display(model.getName(), "<ul><li>" + model.getSymbol() + "</li></ul>");
////              }
////            });
////            b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
////            b.setToolTip("Click for more information");
////
////            return b;
////          }
//
//			@Override
//			public Object render(final ModelData model, String property, ColumnData config, int rowIndex, int colIndex, ListStore store, Grid grid) {
//				if (!init) {
//					
//					init = true;
//		        	grid.addListener(Events.CellDoubleClick, new Listener<GridEvent<Stock>>() {
//		        		public void handleEvent(GridEvent<Stock> be) {
//		        			
//		        			
//		                	  
////		        			for (int i = 0; i < be.getGrid().getStore().getCount(); i++) {
////		        				if (be.getGrid().getView().getWidget(i, be.getColIndex()) != null 
////		        						&& be.getGrid().getView().getWidget(i, be.getColIndex()) instanceof BoxComponent) {
////		        					((BoxComponent) be.getGrid().getView().getWidget(i, be.getColIndex())).setWidth(be.getWidth() - 10);
////		        				}
////		                    }
//		                  }
//		        	});
//		         }
//
//				Button b = new Button("다운", new SelectionListener<ButtonEvent>() {
//					@Override
//					public void componentSelected(ButtonEvent ce) {
//						
//						Window.alert("파일 다운로드 구현");
//		         	}
//				});
//				b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
////				b.setStyleName("buttonStyle");
////				x-form-trigger-arrow
////				b.setAutoHeight(true);
////				b.setToolTip("Click for more information");
//				
//				if(((BaseModelData) store.getModels().get(rowIndex)).get("refeFlSeilNum1") == "0"  ) {
//					b.hide();	
//				}
//
//				return b;
//				
//				}
//        };
        
    
      column = new ColumnConfig();
      column.setId("refeFlSeilNum1");
//      column.setStyle("padding : 0px");
      column.setHeaderText("첨부1");
      column.setAlignment(HorizontalAlignment.LEFT);
      column.setWidth(80);
      column.setSortable(false);
      column.setMenuDisabled(true);
		column.setRenderer(new GridCellRenderer<Psnl0131DTO>() {
			@Override
			public Object render(Psnl0131DTO model, String property,
					ColumnData config, final int rowIndex, int colIndex,
					final ListStore<Psnl0131DTO> store, final Grid<Psnl0131DTO> grid) {
				
				if(!"0".equals(store.getAt(rowIndex).getRefeFlSeilNum1())){
					Button b = new Button("다운", new SelectionListener<ButtonEvent>() {
						@Override
						public void componentSelected(ButtonEvent ce) {
							
							final HashMap<String, String> downParam = new HashMap<String, String>();
							 
							downParam.put("dpobCd"			, psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
							downParam.put("systemkey"		, psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
							downParam.put("refeSeilNum"		, store.getModels().get(rowIndex).get("refeSeilNum").toString());
							downParam.put("refeFlSeilNum"	, store.getModels().get(rowIndex).get("refeFlSeilNum1").toString());
							
							MessageBox.confirm("알림", "해당 파일을 다운로드 받으시겠습니까?",new Listener<MessageBoxEvent>(){
								@Override
								public void handleEvent(MessageBoxEvent be) {
									//if("Yes".equals(be.getButtonClicked().getText())){
									if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
										
										GWTUtils.xlsExportData(GWT.getHostPageBaseURL() + "download/downloadFile.do","extgwtFrame", JsUtil.toJavaScriptObject(downParam));
									}
								}
							});
						}
					});
					b.setWidth(grid.getColumnModel().getColumnWidth(colIndex)-10);
					b.setHeight(19);
					return b;
				}else{
					return "";
				}
			}
		});       
      
      
      
//		column.setRenderer(buttonRenderer1);
      configs.add(column); 
      
      
      column = new ColumnConfig();
      column.setId("refeFlSeilNum2");
//      column.setStyle("padding : 0px");
      column.setHeaderText("첨부2");
      column.setAlignment(HorizontalAlignment.LEFT);
      column.setWidth(80);
      column.setSortable(false);
      column.setMenuDisabled(true);
		column.setRenderer(new GridCellRenderer<Psnl0131DTO>() {
			@Override
			public Object render(Psnl0131DTO model, String property,
					ColumnData config, final int rowIndex, int colIndex,
					final ListStore<Psnl0131DTO> store, Grid<Psnl0131DTO> grid) {
				
				if(!"0".equals(store.getAt(rowIndex).getRefeFlSeilNum2())){
					Button b = new Button("다운", new SelectionListener<ButtonEvent>() {
						@Override
						public void componentSelected(ButtonEvent ce) {
							
							final HashMap<String, String> downParam = new HashMap<String, String>();
							 
							downParam.put("dpobCd"			, psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
							downParam.put("systemkey"		, psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
							downParam.put("refeSeilNum"		, store.getModels().get(rowIndex).get("refeSeilNum").toString());
							downParam.put("refeFlSeilNum"	, store.getModels().get(rowIndex).get("refeFlSeilNum2").toString());
							
							MessageBox.confirm("알림", "해당 파일을 다운로드 받으시겠습니까?",new Listener<MessageBoxEvent>(){
								@Override
								public void handleEvent(MessageBoxEvent be) {
									//if("Yes".equals(be.getButtonClicked().getText())){
									if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
										
										GWTUtils.xlsExportData(GWT.getHostPageBaseURL() + "download/downloadFile.do","extgwtFrame", JsUtil.toJavaScriptObject(downParam));
									}
								}
							});
						}
					});
					b.setWidth(grid.getColumnModel().getColumnWidth(colIndex)-10);
					b.setHeight(19);
					return b;
				}else{
					return "";
				}
			}
		});     
      configs.add(column); 
      
      column = new ColumnConfig();
      column.setId("refeFlSeilNum3");
//      column.setStyle("padding : 0px");
      column.setHeaderText("첨부3");
      column.setAlignment(HorizontalAlignment.LEFT);
      column.setWidth(80);
      column.setSortable(false);
      column.setMenuDisabled(true);
		column.setRenderer(new GridCellRenderer<Psnl0131DTO>() {
			@Override
			public Object render(Psnl0131DTO model, String property,
					ColumnData config, final int rowIndex, int colIndex,
					final ListStore<Psnl0131DTO> store, Grid<Psnl0131DTO> grid) {
				
				if(!"0".equals(store.getAt(rowIndex).getRefeFlSeilNum3())){
					Button b = new Button("다운", new SelectionListener<ButtonEvent>() {
						@Override
						public void componentSelected(ButtonEvent ce) {
							final HashMap<String, String> downParam = new HashMap<String, String>();
							 
							downParam.put("dpobCd"			, psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
							downParam.put("systemkey"		, psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
							downParam.put("refeSeilNum"		, store.getModels().get(rowIndex).get("refeSeilNum").toString());
							downParam.put("refeFlSeilNum"	, store.getModels().get(rowIndex).get("refeFlSeilNum3").toString());
							
							MessageBox.confirm("알림", "해당 파일을 다운로드 받으시겠습니까?",new Listener<MessageBoxEvent>(){
								@Override
								public void handleEvent(MessageBoxEvent be) {
									//if("Yes".equals(be.getButtonClicked().getText())){
									if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
										GWTUtils.xlsExportData(GWT.getHostPageBaseURL() + "download/downloadFile.do","extgwtFrame", JsUtil.toJavaScriptObject(downParam)); 
//											psnl0110GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "download/downloadFile.do","extgwtFrame", downParam);  
									}
								}
							});
						}
					});
					b.setWidth(grid.getColumnModel().getColumnWidth(colIndex)-10);
					b.setHeight(19);
					return b;
				}else{
					return "";
				}
			}
		});     
      configs.add(column); 
		
		
		column = new ColumnConfig();
		column.setId("kybdr");
		column.setHeaderText("등록자");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);
		
		
		column = new ColumnConfig();
		column.setId("refeCtnt");
		column.setHeaderText("근거내용");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setHidden(true);
		configs.add(column);

		
		ColumnModel cm = new ColumnModel(configs);

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(968, 213);
		
		
		psnl0131Grid = new Grid<Psnl0131DTO>(psnl0131Store, cm);
		psnl0131Grid.setStateId("psnl0131Grid");
		psnl0131Grid.setStateful(true);
//		psnl0131Grid.setLoadMask(true); // 작업중표시
		//psnl0110Grid.setAutoExpandColumn("emymtReasCtnt");;
		psnl0131Grid.setBorders(true);
//		psnl0131Grid.addPlugin(checkColumn);
		//psnl0110Grid.setAutoWidth(true);
		psnl0131Grid.setColumnResize(true);
		psnl0131Grid.addListener(Events.RowDoubleClick,	new Listener<GridEvent<Psnl0100DTO>>() {
			public void handleEvent(GridEvent<Psnl0100DTO> be) {

				PsnlP010001 psnlP010001Form = new PsnlP010001(ActionDatabase.UPDATE, getThis());
				MSFFormWindows msFwPsnlP010001 = new MSFFormWindows("관련근거",psnlP010001Form, "닫기", "700px", "550px", true);
				msFwPsnlP010001.show();
				psnlP010001Form.setMSFFormWindows(msFwPsnlP010001);
//				param.put("dpobCd", psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
//				param.put("systemkey", psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
				BaseModel bmRecord = new BaseModel();

				bmRecord.set("dpobCd"			, psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
				bmRecord.set("systemkey"		, psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
				bmRecord.set("refePrchNm"		, MSFMainApp.get().getUser().getUsrNm());
				
				bmRecord.set("refeSeilNum"		, psnl0131Grid.getSelectionModel().getSelectedItem().getRefeSeilNum());
				bmRecord.set("refeFlSeilNum1"	, psnl0131Grid.getSelectionModel().getSelectedItem().getRefeFlSeilNum1());
				bmRecord.set("refeFlSeilNum2"	, psnl0131Grid.getSelectionModel().getSelectedItem().getRefeFlSeilNum2());
				bmRecord.set("refeFlSeilNum3"	, psnl0131Grid.getSelectionModel().getSelectedItem().getRefeFlSeilNum3());

				setPPRecord(bmRecord); 
				psnlP010001Form.bind(ppRecord);
				
				// 팝업이 닫히면 탭을 다시 조회한다.
				msFwPsnlP010001.addListener(Events.Hide,new Listener<BaseEvent>() { 
		    		@Override
		    		public void handleEvent(BaseEvent be) { 
		    			psnl0131Loader.load();
		    		}
				});
			}
		});
		
		cp01.addButton(new Button("신규", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				
				PsnlP010001 psnlP010001Form = new PsnlP010001(ActionDatabase.INSERT, getThis());
				MSFFormWindows msFwPsnlP010001 = new MSFFormWindows("관련근거",psnlP010001Form, "닫기", "700px", "550px", true);
				msFwPsnlP010001.show();
				psnlP010001Form.setMSFFormWindows(msFwPsnlP010001);
				param.put("dpobCd", psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
				param.put("systemkey", psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
				BaseModel bmRecord = new BaseModel();

				bmRecord.set("dpobCd", psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
				bmRecord.set("systemkey", psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
				bmRecord.set("refeSeilNum", "0");
				
				bmRecord.set("refeFlSeilNum1", "0");
				bmRecord.set("refeFlSeilNum2", "0");
				bmRecord.set("refeFlSeilNum3", "0");

				setPPRecord(bmRecord); 
				psnlP010001Form.bind(ppRecord);
				
				// 팝업이 닫히면 탭을 다시 조회한다.
				msFwPsnlP010001.addListener(Events.Hide,new Listener<BaseEvent>() { 
		    		@Override
		    		public void handleEvent(BaseEvent be) { 
		    			psnl0131Loader.load();
		    		}
				});
			}
		}));

		cp01.add(psnl0131Grid);
		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;
	}
	
	
	
	// 근무상황
	private LayoutContainer PersonalTemp08() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		
		CheckColumnConfig checkColumn = new CheckColumnConfig();
		checkColumn.setFixed(true);
		checkColumn.setId("delChk");
		checkColumn.setHeaderText("삭제");
		checkColumn.setWidth(40);
		CellEditor checkBoxEditor = new CellEditor(new CheckBox());  
		checkColumn.setEditor(checkBoxEditor);
	    checkColumn.setMenuDisabled(true);
	    configs.add(checkColumn);
	    
	    ColumnConfig column = new ColumnConfig();
		column.setId("rnum");
		column.setHeaderText("번호");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(40);
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);
		
		TextField<String> dutyDeptCd = new TextField<String>();
		dutyDeptCd.setReadOnly(true);
		dutyDeptCd.setEnabled(true);
		
		column = new ColumnConfig();
		column.setId("dutyDeptCd");
		column.setHeaderText("부서코드");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(200);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setHidden(true);
		configs.add(column);
		
		column = new ColumnConfig();
		column.setId("dutyDeptNm");
		column.setHeaderText("부서명");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(120);
		column.setEditor(new CellEditor(dutyDeptCd));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);
		
		TextField<String>  dutySittnPpgPern = new TextField<String>();
		dutySittnPpgPern.setEnabled(true);
		dutySittnPpgPern.setReadOnly(true);
		        
		column = new ColumnConfig();
		column.setId("dutySittnPpgPern");
		column.setHeaderText("작성자");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(180);
		column.setEditor(new CellEditor(dutySittnPpgPern));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);
		
		column = new ColumnConfig();
		column.setId("dutySittnCtnt");
		column.setHeaderText("내 용");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(150);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);
		
		DateField dutySittnCmptnDtDateField = new DateField();
	    new DateFieldMask(dutySittnCmptnDtDateField, "9999.99.99");
	    dutySittnCmptnDtDateField.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		
	    column = new ColumnConfig();
		column.setId("dutySittnCmptnDt");
		column.setHeaderText("작성일자");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setEditor(new CellEditor(dutySittnCmptnDtDateField));
	    column.setDateTimeFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
	    column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);
		
		column = new ColumnConfig();
		column.setId("dutySittnSgctrt");
		column.setHeaderText("비 고");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);
		
		
		
		column = new ColumnConfig();
		column.setId("dutySittnTtl");
		column.setHeaderText("제 목");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(200);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
//		configs.add(column);

		


		
		ColumnModel cm = new ColumnModel(configs);

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(968, 213);

		psnl0133Grid = new EditorGrid<Psnl0133DTO>(psnl0133Store, cm);
		
		psnl0133Grid.setStateful(true);
		psnl0133Grid.setLoadMask(true); // 작업중표시
		psnl0133Grid.setAutoExpandColumn("dutySittnSgctrt");
		psnl0133Grid.setBorders(true);
		psnl0133Grid.addPlugin(checkColumn);
		
		psnl0133Grid.addListener(Events.CellMouseUp, new Listener<GridEvent<Psnl0122DTO>>() {

			@Override
			public void handleEvent(GridEvent<Psnl0122DTO> be) {
				
				if(be.getColIndex() == 0){
					if(be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())).getDelChk()){
						if(be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())).getDpobCd() == null){ //dpobCd데이터가 없으면 신규추가이므로 해당 로우를 삭제처리
							be.getGrid().getStore().remove(be.getGrid().getStore().getAt(be.getGrid().getStore().indexOf(be.getGrid().getSelectionModel().getSelectedItem())));
						}
					}
				}
			}
		});

		cp01.add(psnl0133Grid);

		cp01.addButton(new Button("신규", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				Psnl0133DTO tempData = new Psnl0133DTO();
				
				if(psnl0133Store.getCount() > 0 && psnl0133Store.getAt(0).getDpobCd() == null){ //이미 등록을 하기위한 데이터가 있을경우
					MessageBox.info("", "먼저 추가한 데이터를 저장후 추가해주세요.", null);
				}else{
					psnl0133Grid.stopEditing();
					
					tempData.setDelChk(false);
					tempData.setDutyDeptCd(MSFMainApp.get().getUser().getDeptCd());
					tempData.setDutyDeptNm(MSFMainApp.get().getUser().getDeptNm());
					tempData.setDutySittnPpgPern(MSFMainApp.get().getUser().getUsrId());
					Calendar  intiCal =  Calendar.getInstance(); 
					tempData.setDutySittnCmptnDt(intiCal.getTime());
					
					psnl0133Store.insert(tempData, 0);
					psnl0133Grid.startEditing(psnl0133Store.indexOf(tempData), 1); 
					
				}
			}
		}));

		cp01.addButton(new Button("저장", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				
				if(psnl0133Grid.getSelectionModel().getSelectedItem() != null ) {
					MessageBox.confirm("근무상황", "근무상황 정보를 저장하시겠습니까?",new Listener<MessageBoxEvent>(){

						@Override
						public void handleEvent(MessageBoxEvent be) {
							//if("Yes".equals(be.getButtonClicked().getText())){
							if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
								if(psnl0133Grid.getSelectionModel().getSelectedItem().getDelChk() == true) {
									MessageBox.confirm("근무상황", "삭제가 체크되어있습니다. 계속 진행하시겠습니까?<br>(삭제된 데이터는 복구되지 않습니다.)",new Listener<MessageBoxEvent>(){
										@Override
										public void handleEvent(MessageBoxEvent be) {
											// TODO Auto-generated method stub
											//if("No".equals(be.getButtonClicked().getText())){
											if(Dialog.NO.equals(be.getButtonClicked().getItemId())){
												return;
											}else if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
												//if("Yes".equals(be.getButtonClicked().getText())){
												savePsnl0133();
											}
										}
									});
								}else {
									savePsnl0133();
								}
								
							}
						}
					});
				}
			}
		}));

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;
	}
	// 교육/시찰(수행)
//	private LayoutContainer PersonalTemp09() {
//
//		LayoutContainer lcTabFormLayer = new LayoutContainer();
//		
////		ContentPanel cp01 = new ContentPanel();
////		cp01.setBodyBorder(false);
////		cp01.setHeaderVisible(false);
////		cp01.setLayout(new FitLayout());
////		cp01.setSize(968, 213);
//		
//		tabsPsnl2 = new TabPanel();
//		
//		//하위탭을 선택하였을 경우 관련된 정보를 가져온다.
//		tabsPsnl2.addListener(Events.Select, new Listener<TabPanelEvent>() {
//			public void handleEvent(TabPanelEvent e) {
//						
//				if(psnl0100Grid.getSelectionModel().getSelectedItem() != null){// 근로자 정보를 선택 하였을 경우만...
//					//탭선택
//					getTabData(tabsPsnl2.getSelectedItem().getId());
//							
//				}else{
//					resetPsnl0111Form();//인적 
//					tabsPsnl2.setSelection(tabsPsnl2.findItem("itemPsnl0111", true));
//					psnl0110Store.removeAll(); //고용그리드 초기화
//					resetPsnl0112Form();
//					resetPsnl0113Form();
//				}
//			}
//		});
//		
//		
//		// tabsPsnl.setMinTabWidth(80);
//		tabsPsnl2.setAutoWidth(false);
//		// tabsPsnl.setResizeTabs(true);
//		tabsPsnl2.setAnimScroll(true);
//		tabsPsnl2.setTabScroll(true);
//		tabsPsnl2.setPlain(true);
//		tabsPsnl2.setSize(970, 240);
//
//		TabItem itemPsnl0120 = new TabItem();
//		//itemPsnl0120.setStyleAttribute("padding", "10px");
//		itemPsnl0120.setId("itemPsnl0120");
//		itemPsnl0120.setText(" 교 육 ");
//		itemPsnl0120.setLayout(new FormLayout());
//		itemPsnl0120.add(PersonalTemp04(), new FormData("100%"));
//		tabsPsnl2.add(itemPsnl0120);
//		
//		
//		TabItem itemPsnl0134 = new TabItem();
//		//itemPsnl0120.setStyleAttribute("padding", "10px");
//		itemPsnl0134.setId("itemPsnl0134_02");
//		itemPsnl0134.setText(" 시찰 ");
//		itemPsnl0134.setLayout(new FormLayout());
//		itemPsnl0134.add(PersonalTemp10(), new FormData("100%"));
//		tabsPsnl2.add(itemPsnl0134);
//		
////		cp01.add(tabsPsnl2, new FormData("100%"));
//		
//		lcTabFormLayer.add(tabsPsnl2);
//
//		return lcTabFormLayer;
//	}
//	
	
	// 해외시찰
	private LayoutContainer PersonalTemp10() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		
		
		CheckColumnConfig checkColumn = new CheckColumnConfig();
		checkColumn.setId("delChk");
		checkColumn.setHeaderText("삭제");
		checkColumn.setWidth(40);
		CellEditor checkBoxEditor = new CellEditor(new CheckBox());  
		checkColumn.setEditor(checkBoxEditor);
	    checkColumn.setMenuDisabled(true);
	   // checkColumn.setFixed(true);
//	    configs.add(checkColumn);
	    
		
		ColumnConfig column = new ColumnConfig();
		column.setId("rnum");
		column.setHeaderText("번호");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(40);
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);
		
		DateField acmpInspnBgnnDtDateField = new DateField();
		 
		acmpInspnBgnnDtDateField.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		new DateFieldMask(acmpInspnBgnnDtDateField, "9999.99.99"); 
		
		column = new ColumnConfig();
		column.setId("acmpInspnBgnnDt");
		column.setHeaderText("시작일");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(120);
		column.setEditor(new CellEditor(acmpInspnBgnnDtDateField));
	    column.setDateTimeFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
	    column.setSortable(false);
	    column.setMenuDisabled(true);
	    configs.add(column);
	    
	    
	    
		DateField acmpInspnEndDtDateField = new DateField();
		 
		acmpInspnEndDtDateField.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		new DateFieldMask(acmpInspnEndDtDateField, "9999.99.99"); 
		
		column = new ColumnConfig();
		column.setId("acmpInspnEndDt");
		column.setHeaderText("종료일");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(120);
		column.setEditor(new CellEditor(acmpInspnEndDtDateField));
	    column.setDateTimeFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
	    column.setSortable(false);
	    column.setMenuDisabled(true);
	    configs.add(column);
	    
	    
	    
		column = new ColumnConfig();
		column.setId("acmpInspnDys");
		column.setHeaderText("기 간");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(60);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);
	    
		
		
		column = new ColumnConfig();
		column.setId("acmpInspnTtl");
		column.setHeaderText("제 목");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(200);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setHidden(true);
		configs.add(column);
		
		column = new ColumnConfig();
		column.setId("acmpInspnNmCty");
		column.setHeaderText("국가명");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);
		
		
		
		column = new ColumnConfig();
		column.setId("acmpInspnPurCtnt");
		column.setHeaderText("방문목적");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(130);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);
		
		
		column = new ColumnConfig();
		column.setId("acmpInspnDivNm");
		column.setHeaderText("구 분");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(200);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setHidden(true);
		configs.add(column);

		
		column = new ColumnConfig();
		column.setId("kybdr");
		column.setHeaderText("작성자");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(180);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);
		
		column = new ColumnConfig();
		column.setId("acmpInspnEtcCtnt");
		column.setHeaderText("비 고");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(180);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);
		
		column = new ColumnConfig();
		column.setId("acmpInspnSeilNum");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setHidden(true);
		configs.add(column);
		
		
		ColumnModel cm = new ColumnModel(configs);

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(968, 213);
		
		
		psnl0134Grid_01 = new Grid<Psnl0134DTO>(psnl0134Store, cm);
		psnl0134Grid_01.setStateId("psnl0134Grid_01");
		psnl0134Grid_01.setStateful(true);
//		psnl0131Grid.setLoadMask(true); // 작업중표시
		psnl0134Grid_01.setAutoExpandColumn("acmpInspnEtcCtnt");
		psnl0134Grid_01.setBorders(true);
//		psnl0131Grid.addPlugin(checkColumn);
		//psnl0110Grid.setAutoWidth(true);
		psnl0134Grid_01.setColumnResize(true);
		psnl0134Grid_01.addListener(Events.RowDoubleClick,	new Listener<GridEvent<Psnl0134DTO>>() {
			public void handleEvent(GridEvent<Psnl0134DTO> be) {
				

				PsnlP010003 psnlP010003Form = new PsnlP010003(ActionDatabase.UPDATE, getThis());
				MSFFormWindows msFwPsnlP010003 = new MSFFormWindows("해외시찰",psnlP010003Form, "닫기", "480px", "220px", true);
				msFwPsnlP010003.show();
				psnlP010003Form.setMSFFormWindows(msFwPsnlP010003);
				BaseModel bmRecord = new BaseModel();

				bmRecord.set("dpobCd"			, psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
				bmRecord.set("systemkey"		, psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
				bmRecord.set("acmpInspnSeilNum"	, psnl0134Grid_01.getSelectionModel().getSelectedItem().getAcmpInspnSeilNum());
				bmRecord.set("acmpInspnDivCdFld","A0520010");
				
				setPPRecord(bmRecord); 
				psnlP010003Form.bind(ppRecord);
				
				
				// 팝업이 닫히면 탭을 다시 조회한다.
				msFwPsnlP010003.addListener(Events.Hide,new Listener<BaseEvent>() { 
		    		@Override
		    		public void handleEvent(BaseEvent be) { 
		    			acmpInspnDivCd.setValue("A0520010");
		    			psnl0134Loader.load();
		    		}
				});
			}
		});
		
		cp01.addButton(new Button("신규", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				
				
				PsnlP010003 psnlP010003Form = new PsnlP010003(ActionDatabase.INSERT, getThis());
				MSFFormWindows msFwPsnlP010003 = new MSFFormWindows("해외시찰", psnlP010003Form, "닫기", "480px", "220px", true);
				msFwPsnlP010003.show();
				psnlP010003Form.setMSFFormWindows(msFwPsnlP010003);
				
				BaseModel bmRecord = new BaseModel();

				bmRecord.set("dpobCd"			, psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
				bmRecord.set("systemkey"		, psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
//				bmRecord.set("acmpInspnSeilNum"	, psnl0134Grid.getSelectionModel().getSelectedItem().getAcmpInspnSeilNum());
				bmRecord.set("acmpInspnDivCdFld","A0520010");

				setPPRecord(bmRecord); 
				psnlP010003Form.bind(ppRecord);
				
				// 팝업이 닫히면 탭을 다시 조회한다.
				msFwPsnlP010003.addListener(Events.Hide,new Listener<BaseEvent>() { 
		    		@Override
		    		public void handleEvent(BaseEvent be) { 
		    			acmpInspnDivCd.setValue("A0520010");
		    			psnl0134Loader.load();
		    		}
				});
			}
		}));

		
		
		
		cp01.add(psnl0134Grid_01);
		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;
	}
	

	// 국내시찰
	private LayoutContainer PersonalTemp11() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		
		
		CheckColumnConfig checkColumn = new CheckColumnConfig();
		checkColumn.setId("delChk");
		checkColumn.setHeaderText("삭제");
		checkColumn.setWidth(40);
		CellEditor checkBoxEditor = new CellEditor(new CheckBox());  
		checkColumn.setEditor(checkBoxEditor);
	    checkColumn.setMenuDisabled(true);
	   // checkColumn.setFixed(true);
//	    configs.add(checkColumn);
	    
		
		ColumnConfig column = new ColumnConfig();
		column.setId("rnum");
		column.setHeaderText("번호");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(40);
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);
		
		DateField acmpInspnBgnnDtDateField = new DateField();
		 
		acmpInspnBgnnDtDateField.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		new DateFieldMask(acmpInspnBgnnDtDateField, "9999.99.99"); 
		
		column = new ColumnConfig();
		column.setId("acmpInspnBgnnDt");
		column.setHeaderText("시작일");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(120);
		column.setEditor(new CellEditor(acmpInspnBgnnDtDateField));
	    column.setDateTimeFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
	    column.setSortable(false);
	    column.setMenuDisabled(true);
	    configs.add(column);
	    
	    
	    
		DateField acmpInspnEndDtDateField = new DateField();
		 
		acmpInspnEndDtDateField.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		new DateFieldMask(acmpInspnEndDtDateField, "9999.99.99"); 
		
		column = new ColumnConfig();
		column.setId("acmpInspnEndDt");
		column.setHeaderText("종료일");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(120);
		column.setEditor(new CellEditor(acmpInspnEndDtDateField));
	    column.setDateTimeFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
	    column.setSortable(false);
	    column.setMenuDisabled(true);
	    configs.add(column);
	    
	    
	    
		column = new ColumnConfig();
		column.setId("acmpInspnDys");
		column.setHeaderText("기 간");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(60);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);
	    
		
		
		column = new ColumnConfig();
		column.setId("acmpInspnTtl");
		column.setHeaderText("제 목");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(200);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setHidden(true);
		configs.add(column);
		
		column = new ColumnConfig();
		column.setId("acmpInspnNmCty");
		column.setHeaderText("도시명");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);
		
		
		
		column = new ColumnConfig();
		column.setId("acmpInspnPurCtnt");
		column.setHeaderText("방문목적");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(130);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);
		
		
		column = new ColumnConfig();
		column.setId("acmpInspnDivNm");
		column.setHeaderText("구 분");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(200);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setHidden(true);
		configs.add(column);

		
		column = new ColumnConfig();
		column.setId("kybdr");
		column.setHeaderText("작성자");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(180);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);
		
		column = new ColumnConfig();
		column.setId("acmpInspnEtcCtnt");
		column.setHeaderText("비 고");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(180);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		configs.add(column);
		
		column = new ColumnConfig();
		column.setId("acmpInspnSeilNum");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setEditor(new CellEditor(new TextField<String>()));
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setHidden(true);
		configs.add(column);
		
		
		ColumnModel cm = new ColumnModel(configs);

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(968, 213);
		
		
		psnl0134Grid_02 = new Grid<Psnl0134DTO>(psnl0134Store, cm);
		psnl0134Grid_02.setStateId("psnl0134Grid_02");
		psnl0134Grid_02.setStateful(true);
//		psnl0131Grid.setLoadMask(true); // 작업중표시
		psnl0134Grid_02.setAutoExpandColumn("acmpInspnEtcCtnt");
		psnl0134Grid_02.setBorders(true);
//		psnl0131Grid.addPlugin(checkColumn);
		//psnl0110Grid.setAutoWidth(true);
		psnl0134Grid_02.setColumnResize(true);
		psnl0134Grid_02.addListener(Events.RowDoubleClick,	new Listener<GridEvent<Psnl0100DTO>>() {
			public void handleEvent(GridEvent<Psnl0100DTO> be) {
				

				PsnlP010003 psnlP010003Form = new PsnlP010003(ActionDatabase.UPDATE, getThis());
				MSFFormWindows msFwPsnlP010003 = new MSFFormWindows("국내시찰",psnlP010003Form, "닫기", "480px", "220px", true);
				msFwPsnlP010003.show();
				psnlP010003Form.setMSFFormWindows(msFwPsnlP010003);
				BaseModel bmRecord = new BaseModel();

				bmRecord.set("dpobCd"			, psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
				bmRecord.set("systemkey"		, psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
				bmRecord.set("acmpInspnSeilNum"	, psnl0134Grid_02.getSelectionModel().getSelectedItem().getAcmpInspnSeilNum());
				bmRecord.set("acmpInspnDivCdFld","A0520020");
				

				setPPRecord(bmRecord); 
				psnlP010003Form.bind(ppRecord);
				
				// 팝업이 닫히면 탭을 다시 조회한다.
				msFwPsnlP010003.addListener(Events.Hide,new Listener<BaseEvent>() { 
		    		@Override
		    		public void handleEvent(BaseEvent be) { 
		    			acmpInspnDivCd.setValue("A0520020");
		    			psnl0134Loader.load();
		    		}
				});
			}
		});
		
		cp01.addButton(new Button("신규", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				
				
				PsnlP010003 psnlP010003Form = new PsnlP010003(ActionDatabase.INSERT, getThis());
				MSFFormWindows msFwPsnlP010003 = new MSFFormWindows("국내시찰", psnlP010003Form, "닫기", "480px", "220px", true);
				msFwPsnlP010003.show();
				psnlP010003Form.setMSFFormWindows(msFwPsnlP010003);
				
				BaseModel bmRecord = new BaseModel();

				bmRecord.set("dpobCd"			, psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
				bmRecord.set("systemkey"		, psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
//				bmRecord.set("acmpInspnSeilNum"	, psnl0134Grid.getSelectionModel().getSelectedItem().getAcmpInspnSeilNum());
				bmRecord.set("acmpInspnDivCdFld","A0520020");

				setPPRecord(bmRecord); 
				psnlP010003Form.bind(ppRecord);
				
				// 팝업이 닫히면 탭을 다시 조회한다.
				msFwPsnlP010003.addListener(Events.Hide,new Listener<BaseEvent>() { 
		    		@Override
		    		public void handleEvent(BaseEvent be) { 
		    			acmpInspnDivCd.setValue("A0520020");
		    			psnl0134Loader.load();
		    		}
				});
			}
		}));

		
		
		
		cp01.add(psnl0134Grid_02);
		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;
	}
	

	
	private void getTabData(String tabId){
		if("itemPsnl0111".equals(tabId)){//인적탭을 선택하였을 경우
			
			//인적 데이터 가져와서 폼 세팅
			param = new HashMap<String, String>();
			param.put("dpobCd", psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
			param.put("systemkey", psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
			
			psnl0111Loader.load();
			
		}else if("itemPsnl0110".equals(tabId)){ //고용
			psnl0110Loader.load();
		}else if("itemPsnl0112".equals(tabId)){ //병역
			Psnl0112DTO dto = new Psnl0112DTO();
			dto.setDpobCd(psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
			dto.setSystemkey(psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
			
			psnl0112Service.selectPsnl0112(dto, new AsyncCallback<Psnl0112DTO>() {
				
				@Override
				public void onSuccess(Psnl0112DTO result) {
					
					
					if(result.getEnrlntDt()!= null && result.getEnrlntDt().length() == 8){
						psnl0112EnrlntDt.setValue(PersonalUtil.getConvertStringToDate(result.getEnrlntDt(), "yyyyMMdd")); //입대일자
					}
					if(result.getDsageDt() != null && result.getDsageDt().length() == 8){
						psnl0112DsageDt.setValue(PersonalUtil.getConvertStringToDate(result.getDsageDt(), "yyyyMMdd")); //제대일자
					}
					
					psnl0112ServcRcgtnPridCd.setValue(PersonalUtil.getBaseModelComboDataCd(psnl0112ServcRcgtnPridCd,"A0290000" ));//복무인정기간result.getServcRcgtnPridCd()
					psnl0112SrvssCd.setValue(PersonalUtil.getBaseModelComboDataCd(psnl0112SrvssCd, result.getSrvssCd())); //역종
					psnl0112BaggrpCd.setValue(PersonalUtil.getBaseModelComboDataCd(psnl0112BaggrpCd, result.getBaggrpCd()));//군별
					psnl0112AbotsCd.setValue(PersonalUtil.getBaseModelComboDataCd(psnl0112AbotsCd, result.getAbotsCd()));//병과
					psnl0112ClsCd.setValue(PersonalUtil.getBaseModelComboDataCd(psnl0112ClsCd, result.getClsCd()));//계급
					
					psnl0112DsageDivCd.setValue(PersonalUtil.getBaseModelComboDataCd(psnl0112DsageDivCd, result.getDsageDivCd()));//제대구분
					psnl0112ExmtnReasCd.setValue(PersonalUtil.getBaseModelComboDataCd(psnl0112ExmtnReasCd, result.getExmtnReasCd()));//미필사유
					
					psnl0112MitySilnum.setValue(result.getMitySilnum()); //군번
					psnl0112Mos.setValue(result.getMos()); //mos
					
					
				}
				
				@Override
				public void onFailure(Throwable caught) {
					
					caught.printStackTrace();
					
					
				}
			});
			
			
		}else if("itemPsnl0113".equals(tabId)){ //신상
			
			Psnl0113DTO dto = new Psnl0113DTO();
			dto.setDpobCd(psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
			dto.setSystemkey(psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
			
			psnl0113Service.selectPsnl0113(dto, new AsyncCallback<Psnl0113DTO>() {
				@Override
				public void onSuccess(Psnl0113DTO result) {
					
					
					/*
					    private RadioGroup psnl0113PrmtsaYn;//색맹(radio)
						private CheckBoxGroup psnl0113PattVetnsYn;//보훈여부 (checkbox)
						
					 */
			    	sxDivCd.setValue(PersonalUtil.getBaseModelComboDataCd(sxDivCd, result.getSxDivCd()));	//성별
			    	yoobhMnthDay.setValue(result.getYoobhMnthDay());			//생년월일
//					String temp = new String();
//			    	temp = result.getResnRegnNum().substring(7, 8);
//			    	if("1".equals(temp) || "3".equals(temp)) {
//			    		resnRegnSex.setValue(PersonalUtil.getBaseModelComboDataCd(resnRegnSex, "1"));
//			    	}else if("2".equals(temp) || "4".equals(temp)){
//			    		resnRegnSex.setValue(PersonalUtil.getBaseModelComboDataCd(resnRegnSex, "2"));
//			    	}	//성별
//			    	psnl0113ResnRegnYMD.setValue(result.getResnRegnNum().substring(0, 2) + "." + result.getResnRegnNum().substring(2, 4) + "." + result.getResnRegnNum().substring(4, 6));	//생년월일
					psnl0113Sttur.setValue(result.getSttur()); //신장
					psnl0113Wei.setValue(result.getWei()); //체중
					psnl0113TnkeeVsnLf.setValue(result.getTnkeeVsnLf()); //나안시력 좌
					psnl0113TnkeeVsnRght.setValue(result.getTnkeeVsnRght()); //나안시력 우
					psnl0113CorrVsnLf.setValue(result.getCorrVsnLf()); //교정시력 좌
					psnl0113CorrVsnRght.setValue(result.getCorrVsnRght()); //교정시력 우
					psnl0113HbbyCtnt.setValue(result.getHbbyCtnt()); //취미
					psnl0113SpityCtnt.setValue(result.getSpityCtnt()); //특기
					psnl0113HlthCodtnCtnt.setValue(result.getHlthCodtnCtnt()); //건강상태
					psnl0113PattVetnsNum.setValue(result.getPattVetnsNum()); //보훈번호
					psnl0113BldtpDivCd.setValue(PersonalUtil.getBaseModelComboDataCd(psnl0113BldtpDivCd, result.getBldtpDivCd()));//혈액형콤보
					psnl0113RelnFrmCd.setValue(PersonalUtil.getBaseModelComboDataCd(psnl0113RelnFrmCd, result.getRelnFrmCd()));//종교
					psnl0113DabtyDivCd.setValue(PersonalUtil.getBaseModelComboDataCd(psnl0113DabtyDivCd, result.getDabtyDivCd()));//장애구분
					psnl0113DabtyGrdeCd.setValue(PersonalUtil.getBaseModelComboDataCd(psnl0113DabtyGrdeCd, result.getDabtyGrdeCd()));//장애등급
					psnl0113PattVetnsDivCd.setValue(PersonalUtil.getBaseModelComboDataCd(psnl0113PattVetnsDivCd, result.getPattVetnsDivCd()));//보훈구분
					psnl0113AmomRelaDivCd.setValue(PersonalUtil.getBaseModelComboDataCd(psnl0113AmomRelaDivCd, result.getAmomRelaDivCd()));//유공자와관계
					
					psnl0113DabtyAjmtDt.setValue(PersonalUtil.getConvertStringToDate(result.getDabtyAjmtDt(), "yyyyMMdd"));//장애판정일자
					
					PersonalUtil.setCheckedRadioValue(psnl0113PrmtsaYn, result.getPrmtsaYn());
					PersonalUtil.setCheckedCheckBoxValue(psnl0113PattVetnsYn, result.getPattVetnsYn());
					//psnl0113PrmtsaYn.setValue(value)
					//psnl0113PattVetnsYn.setValue(value);
				}
				
				@Override
				public void onFailure(Throwable caught) {
					
					
				}
			});
			
			
			
		}else if("itemPsnl0115".equals(tabId)){ //가족
			psnl0115Loader.load();
		}else if("itemPsnl0116".equals(tabId)){ //학력
			psnl0116Loader.load();
		}else if("itemPsnl0118".equals(tabId)){ //지격
			psnl0118Loader.load();
		}else if("itemPsnl0119".equals(tabId)){ //경력
			psnl0119Loader.load();
		}else if("itemPsnl0120".equals(tabId)){ //교육
			psnl0120Loader.load();
		}else if("itemPsnl0121".equals(tabId)){ //포상
			psnl0121Loader.load();
		}else if("itemPsnl0122".equals(tabId)){ //징계
			psnl0122Loader.load();
		//}else if("itemPsnl0127".equals(tabId)){ //사회보험
		//	psnl0127Loader.load();
		}else if("itemPsnl0131".equals(tabId)){//인적탭을 선택하였을 경우
			
			//인적 데이터 가져와서 폼 세팅
			
			psnl0131Dto = new Psnl0131DTO();
			param = new HashMap<String, String>();
			param.put("dpobCd", psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
			param.put("systemkey", psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
			
			psnl0131Loader.load();
			
		}else if("itemPsnl0133".equals(tabId)){	//근무상황 
			psnl0133Loader.load();
		}else if("itemPsnl0134_01".equals(tabId)){	 // 해외시찰
			acmpInspnDivCd.setValue("A0520010");
			psnl0134Loader.load();
		}else if("itemPsnl0134_02".equals(tabId)){	 // 국내시찰
			acmpInspnDivCd.setValue("A0520020");
			psnl0134Loader.load();
		}
	}

	/**
	 *  메인등록 화면에 서브탭 조회처리시 여기서 활용 
	 * @param tabId
	 */
	public void getMainSubTabData(String tabId){
		
		 if("itemPsnlStd03".equals(tabId)){ //사회보험
			psnl0127Loader.load(); 
		} 
		
	}
	
	private void createTabForm() {

		tabsPsnl = new TabPanel(); // 인사탭정보설정을 위한 tab
		
		
		//하위탭을 선택하였을 경우 관련된 정보를 가져온다.
		tabsPsnl.addListener(Events.Select, new Listener<TabPanelEvent>() {
			public void handleEvent(TabPanelEvent e) {
				
				if(psnl0100Grid.getSelectionModel().getSelectedItem() != null){// 근로자 정보를 선택 하였을 경우만...
					//탭선택
					getTabData(tabsPsnl.getSelectedItem().getId());
					
				}else{
					resetPsnl0111Form();//인적 
					tabsPsnl.setSelection(tabsPsnl.findItem("itemPsnl0111", true));
					psnl0110Store.removeAll(); //고용그리드 초기화
				}
				
				
				
				
				//MessageBox.info(tabsPsnl.getSelectedItem().getId(), tabsPsnl.getSelectedItem().getText(), null);
			}
		});
		// tabsPsnl.setMinTabWidth(80);
		tabsPsnl.setAutoWidth(false);
		// tabsPsnl.setResizeTabs(true);
		tabsPsnl.setAnimScroll(true);
		tabsPsnl.setTabScroll(true);
		tabsPsnl.setPlain(true);
		tabsPsnl.setSize(970, 240);

		TabItem itemPsnl0111 = new TabItem();
		itemPsnl0111.setId("itemPsnl0111");
//		itemPsnl0111.setStyleAttribute("padding", "1"); 
		itemPsnl0111.setText(" 인 적 ");
//		itemPsnl0111.addStyleName("pad-text");
		itemPsnl0111.setLayout(new FormLayout());
		itemPsnl0111.add(PersonalData01(), new FormData("100%"));
		tabsPsnl.add(itemPsnl0111);

		TabItem itemPsnl0110 = new TabItem();
		//itemPsnl0110.setStyleAttribute("padding", "10px");
		itemPsnl0110.setId("itemPsnl0110");
		itemPsnl0110.setText(" 고 용 ");
		itemPsnl0110.setLayout(new FormLayout());
		itemPsnl0110.add(Employment01(), new FormData("100%"));
		tabsPsnl.add(itemPsnl0110);
		
		TabItem itemPsnl0300 = new TabItem();
		//itemPsnl0300.setStyleAttribute("padding", "10px");
		itemPsnl0300.setId("itemPsnl0300");
		itemPsnl0300.setText(" 발 령 ");
		itemPsnl0300.setLayout(new FormLayout());
		itemPsnl0300.add(Employment0300(), new FormData("100%"));
//		tabsPsnl.add(itemPsnl0300);

		TabItem itemPsnl0112 = new TabItem();
		//itemPsnl0112.setStyleAttribute("padding", "10px");
		itemPsnl0112.setId("itemPsnl0112");
		itemPsnl0112.setText(" 병 역 ");
		itemPsnl0112.setLayout(new FormLayout());
		itemPsnl0112.add(PersonalMilitary01(), new FormData("100%"));
		tabsPsnl.add(itemPsnl0112);

		TabItem itemPsnl0113 = new TabItem();
		//itemPsnl0113.setStyleAttribute("padding", "10px");
		itemPsnl0113.setId("itemPsnl0113");
		itemPsnl0113.setText(" 신 상 ");
		itemPsnl0113.setLayout(new FormLayout());
		itemPsnl0113.add(PersonalData02(), new FormData("100%"));
		tabsPsnl.add(itemPsnl0113);
		
		
		TabItem itemPsnl0115 = new TabItem();
		//itemPsnl0115.setStyleAttribute("padding", "10px");
		itemPsnl0115.setId("itemPsnl0115");
		itemPsnl0115.setText(" 가 족 ");
		itemPsnl0115.setLayout(new FormLayout());
		itemPsnl0115.add(PersonalFamily01(), new FormData("100%"));
		tabsPsnl.add(itemPsnl0115);

		TabItem itemPsnl0116 = new TabItem();
		//itemPsnl0116.setStyleAttribute("padding", "10px");
		itemPsnl0116.setId("itemPsnl0116");
		itemPsnl0116.setText(" 학 력 ");
		itemPsnl0116.setLayout(new FormLayout());
		itemPsnl0116.add(PersonalAcademicAbility01(), new FormData("100%"));
		tabsPsnl.add(itemPsnl0116);
		
		TabItem itemPsnl0118 = new TabItem();
		//itemPsnl0118.setStyleAttribute("padding", "10px");
		itemPsnl0118.setId("itemPsnl0118");
		itemPsnl0118.setText(" 자 격 ");
		itemPsnl0118.setLayout(new FormLayout());
		itemPsnl0118.add(PersonalTemp02(), new FormData("100%"));
		tabsPsnl.add(itemPsnl0118);
		
		
		TabItem itemPsnl0119 = new TabItem();
		//itemPsnl0119.setStyleAttribute("padding", "10px");
		itemPsnl0119.setId("itemPsnl0119");
		itemPsnl0119.setText(" 경 력 ");
		itemPsnl0119.add(PersonalTemp03(), new FormData("100%"));
		itemPsnl0119.setLayout(new FormLayout());
		tabsPsnl.add(itemPsnl0119);

		TabItem itemPsnl0120 = new TabItem();
		//itemPsnl0120.setStyleAttribute("padding", "10px");
		itemPsnl0120.setId("itemPsnl0120");
		itemPsnl0120.setText(" 교 육 ");
		itemPsnl0120.setLayout(new FormLayout());
		itemPsnl0120.add(PersonalTemp04(), new FormData("100%"));
		tabsPsnl.add(itemPsnl0120);

		TabItem itemPsnl0121 = new TabItem();
		//itemPsnl0121.setStyleAttribute("padding", "10px");
		itemPsnl0121.setId("itemPsnl0121");
		itemPsnl0121.setText(" 포 상 ");
		itemPsnl0121.setLayout(new FormLayout());
		itemPsnl0121.add(PersonalTemp05(), new FormData("100%"));
		tabsPsnl.add(itemPsnl0121);

		TabItem itemPsnl0122 = new TabItem();
		//itemPsnl0122.setStyleAttribute("padding", "10px");
		itemPsnl0122.setId("itemPsnl0122");
		itemPsnl0122.setText(" 징 계 ");
		itemPsnl0122.setLayout(new FormLayout());
		itemPsnl0122.add(PersonalTemp06(), new FormData("100%"));
		tabsPsnl.add(itemPsnl0122);
		
//		TabItem itemPsnl0127 = new TabItem();
//		//itemPsnl0127.setStyleAttribute("padding", "10px");
//		itemPsnl0127.setId("itemPsnl0127");
//		itemPsnl0127.setText(" 사회보험 ");
//		itemPsnl0127.setLayout(new FormLayout());
//		itemPsnl0127.add(InsuranceData01(), new FormData("100%"));
//		tabsPsnl.add(itemPsnl0127);
		
		TabItem itemPsnl0131 = new TabItem();
		//itemPsnl0127.setStyleAttribute("padding", "10px");
		itemPsnl0131.setId("itemPsnl0131");
		itemPsnl0131.setText(" 관련근거 ");
		itemPsnl0131.setLayout(new FormLayout());
		itemPsnl0131.add(RefeData01(), new FormData("100%"));
		tabsPsnl.add(itemPsnl0131);
		
		TabItem itemPsnl0133 = new TabItem();
		//itemPsnl0127.setStyleAttribute("padding", "10px");
		itemPsnl0133.setId("itemPsnl0133");
		itemPsnl0133.setText(" 성향 ");
		itemPsnl0133.setLayout(new FormLayout());
		itemPsnl0133.add(PersonalTemp08(), new FormData("100%"));
		tabsPsnl.add(itemPsnl0133);
		
		
		TabItem itemPsnl0134_01 = new TabItem();
		//itemPsnl0127.setStyleAttribute("padding", "10px");
		itemPsnl0134_01.setId("itemPsnl0134_01");
		itemPsnl0134_01.setText("해외시찰");
		itemPsnl0134_01.setLayout(new FormLayout());
		itemPsnl0134_01.add(PersonalTemp10(), new FormData("100%"));
		tabsPsnl.add(itemPsnl0134_01);
		
		TabItem itemPsnl0134_02 = new TabItem();
		//itemPsnl0127.setStyleAttribute("padding", "10px");
		itemPsnl0134_02.setId("itemPsnl0134_02");
		itemPsnl0134_02.setText("국내시찰");
		itemPsnl0134_02.setLayout(new FormLayout());
		itemPsnl0134_02.add(PersonalTemp11(), new FormData("100%"));
		tabsPsnl.add(itemPsnl0134_02);

		plFrmPsnl0200.add(tabsPsnl, new FormData("100%"));
	}

	// TODO 검색필드 설정
	private void createSearchForm() {
		// FormPanel panel = new FormPanel();
		// panel.setFrame(true);
		// panel.setHeaderVisible(false);
		// panel.setIcon(Resources.ICONS.form());
		// panel.setHeadingText("FormPanel");
		// panel.setSize(600, -1);
		// panel.setLabelAlign(LabelAlign.TOP);
		// panel.setButtonAlign(HorizontalAlignment.CENTER);

		// FormPanel form2 = new FormPanel();
		// form2.setFrame(true);
		// form2.setHeadingHtml("Simple Form with FieldSets");
		// form2.setWidth(350);
		
		sysComBass0300Dto = new PrgmComBass0300DTO();
		
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		//재직상태  
		sysComBass0300Dto.setRpsttvCd("A003");
		lsHdofcCodtnCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		lsHdofcCodtnCd.addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {  
				mDtalistHdofcCodtnCd = PersonalUtil.getLstComboModelData(lsHdofcCodtnCd) ; 
              srhHdofcCodtnCd.getInitStore().add(mDtalistHdofcCodtnCd);
          }
		});   
		
		if(lsHdofcCodtnCd.getCount()>0){
//			cmbxSchHdofcCodtnCd.setValue(listStoreA003.getAt(0));
			srhHdofcCodtnCd.getStore().getAt(0) ; 
		}
		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
       * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
       * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
       * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
       ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		checkPsnl0200Auth("srhHdofcCodtnCd", lsHdofcCodtnCd);		
		//--------------------공통코드 가져옴 -----------------------------------------------------
		
		plFrmPsnl0200.setLayout(new FlowLayout());

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
		// fieldSet.setCheckboxToggle(false);

		LayoutContainer lcSchLeft = new LayoutContainer();
		lcSchLeft.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(100);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		// fieldSet.setLayout(layout);
		lcSchLeft.setLayout(frmlytSch);

		LayoutContainer lcSchRight = new LayoutContainer();
		lcSchRight.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytSchRight = new FormLayout();
		frmlytSchRight.setLabelWidth(100);
		frmlytSchRight.setLabelAlign(LabelAlign.RIGHT);
		lcSchRight.setLayout(frmlytSchRight);

		searchName = new TextField<String>();
		searchName.setFieldLabel("성 명");
		//searchName.setAllowBlank(false);
		lcSchLeft.add(searchName, new FormData("100%"));
		
		
		searchName.addKeyListener(new KeyListener(){
			@Override
			public void componentKeyDown(ComponentEvent event) {
				if(event.getKeyCode() == KeyCodes.KEY_ENTER){
					//그리드 선택 없애기
					psnl0100Grid.getSelectionModel().deselectAll();
					//기본사항 폼 초기화
					
					//조회시 탭부분 초기화
					tabsPsnl.setSelection(tabsPsnl.getItem(0));
					resetMainForm();
					resetPsnl0111Form();
					
					PagingLoadConfig config = new BasePagingLoadConfig();
					config.setOffset(0);
					config.setLimit(50);
					
					loaderPaging.load(config);
				}
			}
		});
		
//		cmbxNewCombobox = new ComboBox<BaseModel>();
//		cmbxNewCombobox.setFieldLabel("관리부서");
//		cmbxNewCombobox.setForceSelection(true);
//		cmbxNewCombobox.setMinChars(1);
//		cmbxNewCombobox.setDisplayField("deptNmRtchnt");
//		cmbxNewCombobox.setValueField("mangeDeptCd");
//		cmbxNewCombobox.setTriggerAction(TriggerAction.ALL);
//		cmbxNewCombobox.setEmptyText("--관리부서선택--");
//		cmbxNewCombobox.setSelectOnFocus(true);
//		cmbxNewCombobox.setStore(listStoreBass0400);
//		
//		cmbxNewCombobox.addListener(Events.Change, new Listener<BaseEvent>() {
//
//			@Override
//			public void handleEvent(BaseEvent be) {
//				
//				PrgmComBass0400DTO sysComBass0400Dto = new PrgmComBass0400DTO();
//				
//				if(cmbxNewCombobox.getValue() != null){
//					sysComBass0400Dto.setMangeDeptCd(cmbxNewCombobox.getValue().get("mangeDeptCd")+"");
//				}
//				
//				cmbxNewCombobox_3.getStore().removeAll();
//				
//				sysComBass0400Service.getPrgmComDeptBass0400List(sysComBass0400Dto,new AsyncCallback<List<BaseModel>>() {
//					
//					@Override
//					public void onSuccess(List<BaseModel> result) {
//						
//						ListStore<BaseModel> ls = new ListStore<BaseModel>();
//						ls.add(result);
//						cmbxNewCombobox_3.setStore(ls);
//						cmbxNewCombobox_3.setEmptyText("--부서선택--");
//						cmbxNewCombobox_3.setValue(new BaseModel());
//						
//						searchYearBusinCd.setStore(new ListStore<BaseModel>());
//						searchYearBusinCd.setEmptyText("--부서선택--");
//						searchYearBusinCd.setValue(new BaseModel());
//						
//					}
//					@Override
//					public void onFailure(Throwable caught) {
//						
//						caught.printStackTrace();
//					}
//				});
//
//				
//				/*if(cmbxNewCombobox.getValue() != null){
//					PrgmComBass0400DTO sysComBass0400Dto = new PrgmComBass0400DTO();
//					sysComBass0400Dto.setMangeDeptCd(cmbxNewCombobox.getValue().get("mangeDeptCd")+"");
//					cmbxNewCombobox_3.getStore().removeAll();
//					
//					
//					sysComBass0400Service.getPrgmComDeptBass0400List(sysComBass0400Dto,new AsyncCallback<List<BaseModel>>() {
//						
//						@Override
//						public void onSuccess(List<BaseModel> result) {
//							
//							ListStore<BaseModel> ls = new ListStore<BaseModel>();
//							ls.add(result);
//							cmbxNewCombobox_3.setStore(ls);
//							cmbxNewCombobox_3.setEmptyText("--부서선택--");
//							cmbxNewCombobox_3.setValue(new BaseModel());
//						}
//						@Override
//						public void onFailure(Throwable caught) {
//							
//							caught.printStackTrace();
//						}
//					});
//				}else{
//					cmbxNewCombobox_3.setStore(new ListStore<BaseModel>());
//					cmbxNewCombobox_3.setEmptyText("--관리부서선택--");
//					cmbxNewCombobox_3.setValue(new BaseModel());
//					
//					searchYearBusinCd.setStore(new ListStore<BaseModel>());
//					searchYearBusinCd.setEmptyText("--소속부서선택--");
//					searchYearBusinCd.setValue(new BaseModel());
//				}*/
//				
//				
//			}
//		
//		});
		LayoutContainer lccmMangeDeptNm = new LayoutContainer();
      lccmMangeDeptNm.setLayout(new ColumnLayout());
      
//      LayoutContainer lcMangeDeptCd = new LayoutContainer(); 
//      frmlytSch = new FormLayout();
//      frmlytSch.setLabelWidth(100);
//      frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//      lcMangeDeptCd.setLayout(frmlytSch);
          
      //관리부서 
      searchMangeDeptCd = new TextField<String>();
      searchMangeDeptCd.setName("searchMangeDeptCd");
      searchMangeDeptCd.setVisible(false);
      plFrmPsnl0200.add(searchMangeDeptCd);
//      searchMangeDeptCd.setReadOnly(true);
//      searchMangeDeptCd.setFieldLabel("관리부서");   
//      lcMangeDeptCd.add(searchMangeDeptCd, new FormData("100%"));  
//      searchMangeDeptCd.addListener(Events.Change, new Listener<BaseEvent>() { 
//        @Override
//        public void handleEvent(BaseEvent be) {  
//                    searchYearBusinCd.setStore(new ListStore<BaseModel>());
//                    searchYearBusinCd.setEmptyText("--사업선택--");
//                    searchYearBusinCd.setValue(new BaseModel()); 
//            
//        }
//    
//    });
       
       LayoutContainer lcMangeDeptNm = new LayoutContainer(); 
       frmlytSch = new FormLayout();
       frmlytSch.setLabelWidth(100);
       frmlytSch.setLabelAlign(LabelAlign.RIGHT);
       lcMangeDeptNm.setLayout(frmlytSch);
    
       searchMangeDeptNm = new TextField<String>();
       searchMangeDeptNm.setName("searchMangeDeptNm");
       searchMangeDeptNm.setFieldLabel("관리부서");   
      // searchMangeDeptNm.setLabelSeparator("");
//       searchMangeDeptNm.setReadOnly(gwtExtAuth.getReadOnlyPayrMangDeptCd());
//       searchMangeDeptNm.setEnabled(gwtExtAuth.getEnablePayrMangDeptCd());
       searchMangeDeptNm.addKeyListener(new KeyListener() {
            public void componentKeyDown(ComponentEvent event) {
               
          	  if (MSFSharedUtils.allowNulls(searchMangeDeptNm.getValue()).trim().equals("")) {
      			  searchMangeDeptCd.setValue("");
      		  }
      		  if (MSFSharedUtils.paramNull(searchMangeDeptNm.getValue())) {
      			  searchMangeDeptCd.setValue("");
      		  }  
      		  
                if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
                  //  if (MSFSharedUtils.allowNulls(searchMangeDeptNm.getValue()).trim().equals("")) {
                        searchMangeDeptCd.setValue("");
                   //  }
                    fnPopupCommP145_Mange(searchMangeDeptNm.getValue());
                }
                super.componentKeyDown(event); 
            }
        });
        
//        searchMangeDeptNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//      	  @Override
//      	  public void handleEvent(BaseEvent be) { 
//      		  if (MSFSharedUtils.allowNulls(searchMangeDeptNm.getValue()).trim().equals("")) {
//      			  searchMangeDeptCd.setValue("");
//      		  }
//      		  if (MSFSharedUtils.paramNull(searchMangeDeptNm.getValue())) {
//      			  searchMangeDeptCd.setValue("");
//      		  }  
//      	  } 
//         });        
        lcMangeDeptNm.add(searchMangeDeptNm, new FormData("100%"));  
        
         btnSrhMangeDeptCd = new Button(); 
         btnSrhMangeDeptCd.setIcon(MSFMainApp.ICONS.search()); 
         btnSrhMangeDeptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
         btnSrhMangeDeptCd.addListener(Events.Select, new Listener<ButtonEvent>() {
             public void handleEvent(ButtonEvent e) { 
                 if (MSFSharedUtils.allowNulls(searchMangeDeptNm.getValue()).trim().equals("")) {
                     searchMangeDeptCd.setValue("");
                  }
                 fnPopupCommP145_Mange(searchMangeDeptNm.getValue()); 
             }
         });
          
        // lccmMangeDeptNm.add(lcMangeDeptCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));  
         lccmMangeDeptNm.add(lcMangeDeptNm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.91));
         lccmMangeDeptNm.add(btnSrhMangeDeptCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));
       
		
		lcSchLeft.add(lccmMangeDeptNm, new FormData("100%"));
		
		
		LayoutContainer layoutContainer = new LayoutContainer();

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		frmlytSchRight = new FormLayout();
		frmlytSchRight.setLabelWidth(100);
		frmlytSchRight.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1.setLayout(frmlytSchRight);

		searchResnRegnNum = new TextField<String>();
		new TextFieldMask<String>(searchResnRegnNum, "999999-9999999");  
		searchResnRegnNum.setFieldLabel("주민등록번호");
		
		layoutContainer_1.add(searchResnRegnNum, new FormData("100%"));

//		//검색 소속부서 코드 처리   
//		cmbxNewCombobox_3 = new ComboBox<BaseModel>();
//		cmbxNewCombobox_3.setFieldLabel("부서");
//		cmbxNewCombobox_3.setForceSelection(true);
//		cmbxNewCombobox_3.setMinChars(1);
//		cmbxNewCombobox_3.setDisplayField("deptNmRtchnt");
//		cmbxNewCombobox_3.setValueField("deptCd");
//		cmbxNewCombobox_3.setTriggerAction(TriggerAction.ALL);
//		cmbxNewCombobox_3.setEmptyText("--부서선택--");  //MSFMainApp.ADMINCONSTANTS.InserireCategoria()
//		cmbxNewCombobox_3.setSelectOnFocus(true);
//		cmbxNewCombobox_3.setStore(listStoreBass0400All);
//		cmbxNewCombobox_3.setName("cmbxNewCombobox_3");
//		cmbxNewCombobox_3.addListener(Events.Change, new Listener<BaseEvent>() {
//			@Override
//			public void handleEvent(BaseEvent be) {
//				
//				if(cmbxNewCombobox_3.getValue() != null){
//					PrgmComBass0500DTO dto = new PrgmComBass0500DTO();
//					dto.setBusinApptnYr(DateTimeFormat.getFormat("yyyy").format(new Date()));
//					dto.setDeptCd(String.valueOf(cmbxNewCombobox_3.getValue().get("deptCd")));
//					
//					psnl0100Service.getBusinList(dto, new AsyncCallback<List<BaseModel>>() {
//						
//						@Override
//						public void onSuccess(List<BaseModel> result) {
//							
//							ListStore<BaseModel> ls = new ListStore<BaseModel>();
//							ls.add(result);
//							searchYearBusinCd.setStore(ls);
//							searchYearBusinCd.setEmptyText("--사업명선택--");
//							searchYearBusinCd.setValue(new BaseModel());
//						}
//						
//						@Override
//						public void onFailure(Throwable caught) {
//							
//							caught.printStackTrace();
//							MessageBox.alert("", "사업코드 에러!", null);
//						}
//					});
//					
//				}else{
//					searchYearBusinCd.setStore(new ListStore<BaseModel>());
//					searchYearBusinCd.setEmptyText("--부서선택--");
//					searchYearBusinCd.setValue(new BaseModel());
//				}
//			}
//		});
//		cmbxNewCombobox_3.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//		    public void handleEvent(StoreEvent<BaseModel> be) {  
//
//		        /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//		         * 권한설정을 위한 콤보처리를 위한 메서드 시작 
//		         * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//		         ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//		        GWTAuthorization.formAuthConfig(plFrmPsnl0200, "","","cmbxNewCombobox_3","","searchYearBusinCd");
//		        /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//		         * 권한설정을 위한 콤보처리를 위한 메서드 종료
//		         ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
//		        
//		    }
//		});    
		
		  //검색 소속부서 코드 처리  
      LayoutContainer lccmlcCurrAffnDeptNm = new LayoutContainer();
      lccmlcCurrAffnDeptNm.setLayout(new ColumnLayout());
      
//      LayoutContainer lcCurrAffnDeptCd = new LayoutContainer(); 
//      frmlytSch = new FormLayout();
//      frmlytSch.setLabelWidth(100);
//      frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//      lcCurrAffnDeptCd.setLayout(frmlytSch);
          
      //부서 
      srhCurrAffnDeptCd = new TextField<String>();
      srhCurrAffnDeptCd.setName("srhCurrAffnDeptCd");
      srhCurrAffnDeptCd.setVisible(false);
      plFrmPsnl0200.add(srhCurrAffnDeptCd);
//      srhCurrAffnDeptCd.setReadOnly(true);
//      srhCurrAffnDeptCd.setFieldLabel("소속부서");  
      
      srhCurrAffnDeptCd.addListener(Events.Add, new Listener<BaseEvent>() {
      @Override
      public void handleEvent(BaseEvent be) { 
          
        if(srhCurrAffnDeptCd.getValue() != null){
            PrgmComBass0500DTO dto = new PrgmComBass0500DTO();
            dto.setBusinApptnYr("");  //DateTimeFormat.getFormat("yyyy").format(new Date())
            dto.setDeptCd(srhCurrAffnDeptCd.getValue()); 
        
          //--------------------사업 불러 오는 함수 -------------------------------------------------
            lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(dto);
           //--------------------사업 불러 오는 함수 -------------------------------------------------
            searchYearBusinCd.setStore(lsBusinCd); 
            searchYearBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
                public void handleEvent(StoreEvent<BaseModel> be) {  
                   // searchYearBusinCd.setValue(lsBusinCd.getAt(0));  
                }
            });    
//            psnl0100Service.getBusinList(dto, new AsyncCallback<List<BaseModel>>() {
//                
//                @Override
//                public void onSuccess(List<BaseModel> result) {
//                    
//                    ListStore<BaseModel> ls = new ListStore<BaseModel>();
//                    ls.add(result);
//                    searchYearBusinCd.setStore(ls);
//                    searchYearBusinCd.setEmptyText("--사업선택--");
//                    searchYearBusinCd.setValue(new BaseModel());
//                }
//                
//                @Override
//                public void onFailure(Throwable caught) {
//                    
//                    caught.printStackTrace();
//                    MessageBox.alert("", "사업코드 에러!", null);
//                }
//            });
            
        } 
      }
   });
 
      
//      lcCurrAffnDeptCd.add(srhCurrAffnDeptCd, new FormData("100%"));    
       
       LayoutContainer lcCurrAffnDeptNm = new LayoutContainer(); 
       frmlytSch = new FormLayout();
       frmlytSch.setLabelWidth(100);
       frmlytSch.setLabelAlign(LabelAlign.RIGHT);
       lcCurrAffnDeptNm.setLayout(frmlytSch);
    
       srhCurrAffnDeptNm = new TextField<String>();
       srhCurrAffnDeptNm.setName("srhCurrAffnDeptNm");
       srhCurrAffnDeptNm.setFieldLabel("소속부서");
       srhCurrAffnDeptNm.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
       srhCurrAffnDeptNm.setEnabled(gwtExtAuth.getEnableDeptCd());
     // srhCurrAffnDeptNm.setLabelSeparator("");
       srhCurrAffnDeptNm.addKeyListener(new KeyListener() {
            public void componentKeyDown(ComponentEvent event) {
             
          	  if (MSFSharedUtils.allowNulls(srhCurrAffnDeptNm.getValue()).trim().equals("")) {
                    srhCurrAffnDeptCd.setValue("");
                }
                  if (MSFSharedUtils.paramNull(searchMangeDeptNm.getValue())) {
                      srhCurrAffnDeptCd.setValue("");
                  }  
               
                if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
                    if (MSFSharedUtils.allowNulls(srhCurrAffnDeptNm.getValue()).trim().equals("")) {
                        srhCurrAffnDeptCd.setValue(""); 
                    }
                    fnPopupCommP140_Curr(srhCurrAffnDeptNm.getValue());
                }
                
                super.componentKeyDown(event); 
            }
        });
      
//       srhCurrAffnDeptNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//                  @Override
//                  public void handleEvent(BaseEvent be) { 
//                       
//                   if (MSFSharedUtils.allowNulls(srhCurrAffnDeptNm.getValue()).trim().equals("")) {
//                       srhCurrAffnDeptCd.setValue("");
//                   }
//                     if (MSFSharedUtils.paramNull(searchMangeDeptNm.getValue())) {
//                         srhCurrAffnDeptCd.setValue("");
//                     }  
//                  } 
//         });        
        lcCurrAffnDeptNm.add(srhCurrAffnDeptNm, new FormData("100%"));  
        
         btnSrhCurrAffnDeptCd = new Button();
         btnSrhCurrAffnDeptCd.setIcon(MSFMainApp.ICONS.search()); 
         btnSrhCurrAffnDeptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
         btnSrhCurrAffnDeptCd.addListener(Events.Select, new Listener<ButtonEvent>() {
             public void handleEvent(ButtonEvent e) { 
                 if (MSFSharedUtils.allowNulls(srhCurrAffnDeptNm.getValue()).trim().equals("")) {
                     srhCurrAffnDeptCd.setValue(""); 
                 }
                 fnPopupCommP140_Curr(srhCurrAffnDeptNm.getValue()); 
             }
         });
        //  lccmlcCurrAffnDeptNm.add(lcCurrAffnDeptCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.55));  
      lccmlcCurrAffnDeptNm.add(lcCurrAffnDeptNm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.91));
      lccmlcCurrAffnDeptNm.add(btnSrhCurrAffnDeptCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));
           
         
		layoutContainer_1.add(lccmlcCurrAffnDeptNm, new FormData("100%"));
		 
		
		layoutContainer.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer_1.setBorders(false);

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		frmlytSchRight = new FormLayout();
		frmlytSchRight.setLabelWidth(100);
		frmlytSchRight.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2.setLayout(frmlytSchRight);
		
		LayoutContainer lc1 = new LayoutContainer();
		
		FormLayout fl1 = new FormLayout();
		fl1.setLabelAlign(LabelAlign.RIGHT);
		fl1.setLabelWidth(100);
		
		lc1.setLayout(fl1);
		lc1.setBorders(false);

		//재직구분 검색콤보
		//--
      srhHdofcCodtnCd = new MSFMultiComboBox<ModelData>();
      srhHdofcCodtnCd.setName("srhHdofcCodtnCd");
      srhHdofcCodtnCd.setEmptyText("--재직선택--");
      srhHdofcCodtnCd.setReadOnly(true);
      srhHdofcCodtnCd.setEnabled(true); 
      srhHdofcCodtnCd.getListView().setDisplayProperty("commCdNm");
      srhHdofcCodtnCd.getStore().add(mDtalistHdofcCodtnCd);
      srhHdofcCodtnCd.setFieldLabel("재 직");
      srhHdofcCodtnCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
          public void handleEvent(StoreEvent<ModelData> be) {  
//              srhHdofcCodtnCd.getListView().setChecked(mDtalistHdofcCodtnCd.get(0), true); 
//              srhHdofcCodtnCd.setValue(mDtalistHdofcCodtnCd.get(0).get("commCdNm").toString());
          }
      }); 
      srhHdofcCodtnCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
          @Override
          public void handleEvent(ComponentEvent ce) {   
              if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
                  mutilCombo = true;
              } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
                  mutilCombo = true;
              } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
                  mutilCombo = false;
              }  
          } 
      });
      lc1.add(srhHdofcCodtnCd, new FormData("100%"));
		 
//		cmbxSchHdofcCodtnCd = new ComboBox<BaseModel>();
//		cmbxSchHdofcCodtnCd.setFieldLabel("재직구분");
//		//cmbxSchHdofcCodtnCd.setEditable(false);
//		cmbxSchHdofcCodtnCd.setForceSelection(true);
//		cmbxSchHdofcCodtnCd.setMinChars(1);
//		cmbxSchHdofcCodtnCd.setDisplayField("commCdNm");
//		cmbxSchHdofcCodtnCd.setValueField("commCd");
//		cmbxSchHdofcCodtnCd.setTriggerAction(TriggerAction.ALL);
//		cmbxSchHdofcCodtnCd.setEmptyText("--재직구분선택--");
//		cmbxSchHdofcCodtnCd.setSelectOnFocus(true);
//		cmbxSchHdofcCodtnCd.setStore(listStoreA003);   
//		cmbxSchHdofcCodtnCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//			public void handleEvent(StoreEvent<BaseModel> be) {  
//				EventType type = be.getType();
//				if (type == Store.Add) { 
//            		
//            	 }
//			}
//		});
		
		
		
		
		//LayoutContainer lc = new LayoutContainer(new ColumnLayout());
		

		
		
		/*
		searchTypOccuCd = new ComboBox<BaseModel>();
		searchTypOccuCd.setFieldLabel("직종");
		searchTypOccuCd.setForceSelection(true);
		searchTypOccuCd.setMinChars(1);
		searchTypOccuCd.setDisplayField("commCdNm");
		searchTypOccuCd.setValueField("commCd");
		searchTypOccuCd.setTriggerAction(TriggerAction.ALL);
		searchTypOccuCd.setEmptyText("--직종선택--");
		searchTypOccuCd.setSelectOnFocus(true);
		searchTypOccuCd.setStore(listStoreA041);
		

		LayoutContainer lc2 = new LayoutContainer();
		FormLayout fl2 = new FormLayout();
		fl2.setLabelAlign(LabelAlign.RIGHT);
		fl2.setLabelWidth(50);
		lc2.setLayout(fl2);
		lc2.setBorders(false);
		lc2.add(searchTypOccuCd, new FormData("100%"));
		*/
		//lc.add(lc1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		//lc.add(lc2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		layoutContainer_2.add(lc1);
		
		/*
		cmbxSchHdofcCodtnCd = new ComboBox<BaseModel>();
		cmbxSchHdofcCodtnCd.setFieldLabel("재직");
		//cmbxSchHdofcCodtnCd.setEditable(false);
		cmbxSchHdofcCodtnCd.setForceSelection(true);
		cmbxSchHdofcCodtnCd.setMinChars(1);
		cmbxSchHdofcCodtnCd.setDisplayField("commCdNm");
		cmbxSchHdofcCodtnCd.setValueField("commCd");
		cmbxSchHdofcCodtnCd.setTriggerAction(TriggerAction.ALL);
		cmbxSchHdofcCodtnCd.setEmptyText("--재직구분선택--");
		cmbxSchHdofcCodtnCd.setSelectOnFocus(true);
		cmbxSchHdofcCodtnCd.setStore(listStoreA003);   
		
		layoutContainer_2.add(cmbxSchHdofcCodtnCd, new FormData("100%")); 

		
		searchTypOccuCd = new ComboBox<BaseModel>();
		searchTypOccuCd.setFieldLabel("직종");
		searchTypOccuCd.setForceSelection(true);
		searchTypOccuCd.setMinChars(1);
		searchTypOccuCd.setDisplayField("commCdNm");
		searchTypOccuCd.setValueField("commCd");
		searchTypOccuCd.setTriggerAction(TriggerAction.ALL);
		searchTypOccuCd.setEmptyText("--직종선택--");
		searchTypOccuCd.setSelectOnFocus(true);
		searchTypOccuCd.setStore(listStoreA041);
		
		layoutContainer_2.add(searchTypOccuCd, new FormData("100%"));
		*/
		
		searchYearBusinCd = new ComboBox<BaseModel>();
		searchYearBusinCd.setFieldLabel("사업명");
		searchYearBusinCd.setForceSelection(true);
		searchYearBusinCd.setMinChars(1);
		searchYearBusinCd.setDisplayField("businNm");
		searchYearBusinCd.setValueField("businCd");
		searchYearBusinCd.setTriggerAction(TriggerAction.ALL);
		searchYearBusinCd.setEmptyText("--사업선택--");
		searchYearBusinCd.setSelectOnFocus(true);
		searchYearBusinCd.setName("searchYearBusinCd");
		searchYearBusinCd.setStore(new ListStore<BaseModel>());
		layoutContainer_2.add(searchYearBusinCd, new FormData("100%"));
		
		layoutContainer_2.setBorders(false);
		layoutContainer.add(layoutContainer_2,	new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		
		
		lcSchRight.add(layoutContainer, new FormData("100%"));
		layoutContainer.setLayout(new ColumnLayout());
		layoutContainer.setBorders(false);

		// TextField<String> company = new TextField<String>();
		// company.setFieldLabel("주민등록번호");
		// fieldSet.add(company, new FormData("100%"));
		//
		// TextField<String> email = new TextField<String>();
		// email.setFieldLabel("Email");
		// fieldSet.add(email, new FormData("100%"));

		lcSchCol.add(lcSchLeft, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		lcSchCol.add(lcSchRight, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));

		fieldSet.add(lcSchCol, new FormData("100%"));

		plFrmPsnl0200.add(fieldSet);
		// vp.add(panel);
	}
	
	
	/**
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * 콤보 박스 처리 을 위한 메서드 시작
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */

	/**
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * 콤보 박스 처리 을 위한 메서드 종료
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */
  // TODO 기본사항
	private void createStandardForm() {

		 
		LayoutContainer lcMTRCol = new LayoutContainer(new ColumnLayout());

		LayoutContainer lcMTRLeft = new LayoutContainer();
		lcMTRLeft.setStyleAttribute("paddingRight", "0px");
		FormLayout frmlytStd1 = new FormLayout();
		frmlytStd1.setLabelWidth(0);
		frmlytStd1.setLabelAlign(LabelAlign.LEFT);
		lcMTRLeft.setLayout(frmlytStd1);

		LayoutContainer lcMTRCenter = new LayoutContainer();
		lcMTRCenter.setStyleAttribute("paddingRight", "0px");
		lcMTRCenter.setStyleAttribute("padding-top", "8px");
		frmlytStd1 = new FormLayout();
		frmlytStd1.setLabelWidth(0);
		frmlytStd1.setLabelAlign(LabelAlign.RIGHT);
		
		lcMTRCenter.setLayout(frmlytStd1);

		lcMTRCenter.add(PsnlList01(), new FormData("100%"));
		
		
		
		lcMTRCol.add(lcMTRLeft,				new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
		// lcMTRCol.add(lcMTRCenter,new
		// com.extjs.gxt.ui.client.widget.layout.ColumnData(.20));

		LayoutContainer lcStdCol = new LayoutContainer();
		lcStdCol.setLayout(new ColumnLayout());

		lcMTRLeft.add(lcStdCol, new FormData("100%"));

		LayoutContainer lcStdSbCol = new LayoutContainer(new ColumnLayout());

		FieldSet fieldSet = new FieldSet();
		fieldSet.setHeadingHtml("기본사항");

		LayoutContainer lcStdLeft = new LayoutContainer();
		lcStdLeft.setStyleAttribute("paddingRight", "5px");
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(0);
		frmlytStd.setLabelAlign(LabelAlign.LEFT);
		lcStdLeft.setLayout(frmlytStd);
		// plFrmPsnl0100.add(fieldSet, new FormData("100% -515"));

		LayoutContainer lcStdCenter = new LayoutContainer();
		lcStdCenter.setStyleAttribute("paddingRight", "10px");
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdCenter.setLayout(frmlytStd);

		LayoutContainer lcStdSbLeft = new LayoutContainer();
		lcStdSbLeft.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(100);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdSbLeft.setLayout(frmlytSbStd);

		LayoutContainer lcStdSbCenter = new LayoutContainer();
		lcStdSbCenter.setStyleAttribute("paddingRight", "10px");
		frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(100);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdSbCenter.setLayout(frmlytSbStd);

//		deptCd = new ComboBox<BaseModel>();
//		deptCd.setFieldLabel("관리부서");
//		deptCd.setForceSelection(true);
//		deptCd.setMinChars(1);
//		deptCd.setDisplayField("deptNmRtchnt");
//		deptCd.setValueField("mangeDeptCd");
//		deptCd.setTriggerAction(TriggerAction.ALL);
//		deptCd.setEmptyText("--관리부서선택--");
//		deptCd.setSelectOnFocus(true);
//		deptCd.setStore(listStoreBass0400);
//		
//		deptCd.addListener(Events.Change, new Listener<BaseEvent>() {
//
//			@Override
//			public void handleEvent(final BaseEvent be) {
//				
//				
//				
//				
//				//if(deptCd.getValue() != null){
//					PrgmComBass0400DTO sysComBass0400Dto = new PrgmComBass0400DTO();
//					if(deptCd.getValue() != null){
//						sysComBass0400Dto.setMangeDeptCd(PersonalUtil.getSelectedComboValue(deptCd, "mangeDeptCd"));
//					}
//					currAffnDeptCd.getStore().removeAll();
//					
//					
//					sysComBass0400Service.getPrgmComDeptBass0400List(sysComBass0400Dto,new AsyncCallback<List<BaseModel>>() {
//						
//						@Override
//						public void onSuccess(List<BaseModel> result) {
//							
//							ListStore<BaseModel> ls = new ListStore<BaseModel>();
//							ls.add(result);
//							currAffnDeptCd.setStore(ls);
//							currAffnDeptCd.setEmptyText("--부서선택--");
//							
//							if(be.getSource() instanceof GridSelectionModel){
//								@SuppressWarnings("unchecked")
//								GridSelectionModel<BaseModel> gsm = (GridSelectionModel<BaseModel>) be.getSource();
//								PersonalUtil.setSelectedComboValue(currAffnDeptCd, String.valueOf(gsm.getSelectedItem().get("currAffnDeptCd")),"deptCd"); //기본사항 부서
//							}else if(be.getSource() instanceof Psnl0100DTO){
//								Psnl0100DTO dto = (Psnl0100DTO)be.getSource();
//								PersonalUtil.setSelectedComboValue(currAffnDeptCd, dto.getCurrAffnDeptCd(),"deptCd"); //기본사항 부서
//							}else{
//								currAffnDeptCd.setValue(new BaseModel());
//							}
//						}
//						@Override
//						public void onFailure(Throwable caught) {
//							
//							caught.printStackTrace();
//						}
//					});
//				//}else{
//				//	currAffnDeptCd.setStore(listStoreBass0400All);
//				//	currAffnDeptCd.setEmptyText("--관리부서선택--");
//				//	currAffnDeptCd.setValue(new BaseModel());
//				//}
//				
//				
//			}
//		
//		});
	    //관리부서 코드 처리  
      LayoutContainer lccmMangeDeptNm = new LayoutContainer();
      lccmMangeDeptNm.setLayout(new ColumnLayout());
      
//      LayoutContainer lcMangeDeptCd = new LayoutContainer(); 
//      FormLayout frmlytSch = new FormLayout();
//      frmlytSch.setLabelWidth(100);
//      frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//      lcMangeDeptCd.setLayout(frmlytSch);
          
      //부서 
      mangeDeptCd = new MSFTextField();
      mangeDeptCd.setName("mangeDeptCd");
      mangeDeptCd.setVisible(false);
      plFrmPsnl0200.add(mangeDeptCd);
//      mangeDeptCd.setReadOnly(true);
//      mangeDeptCd.setFieldLabel("소속부서");   
    //  lcMangeDeptCd.add(mangeDeptCd, new FormData("100%"));    
       
       LayoutContainer lcMangeDeptNm = new LayoutContainer(); 
       FormLayout frmlytSch = new FormLayout();
       frmlytSch.setLabelWidth(100);
       frmlytSch.setLabelAlign(LabelAlign.RIGHT);
       lcMangeDeptNm.setLayout(frmlytSch);
    
       mangeDeptNm = new MSFTextField(); 
       mangeDeptNm.setName("mangeDeptNm");
       mangeDeptNm.setFieldLabel("관리부서");  
      // mangeDeptNm.setLabelSeparator("");
       mangeDeptNm.addKeyListener(new KeyListener() {
            public void componentKeyDown(ComponentEvent event) {
          	  if (MSFSharedUtils.allowNulls(mangeDeptNm.getValue()).trim().equals("")) {
                    mangeDeptCd.setValue("");
                }
                  if (MSFSharedUtils.paramNull(mangeDeptNm.getValue())) {
                      mangeDeptCd.setValue("");
                  } 
                if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
                   // if (MSFSharedUtils.allowNulls(mangeDeptNm.getValue()).trim().equals("")) {
                        mangeDeptCd.setValue("");
                   // }
                    fnPopupCommP150_Mange(mangeDeptNm.getValue());
                }
                
                super.componentKeyDown(event);
            }
        });
       
//       mangeDeptNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//                  @Override
//                  public void handleEvent(BaseEvent be) { 
//                       
//                   if (MSFSharedUtils.allowNulls(mangeDeptNm.getValue()).trim().equals("")) {
//                       mangeDeptCd.setValue("");
//                   }
//                     if (MSFSharedUtils.paramNull(mangeDeptNm.getValue())) {
//                         mangeDeptCd.setValue("");
//                     }  
//                  } 
//         });        
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
          
       //  lccmMangeDeptNm.add(lcMangeDeptCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.55));  
         lccmMangeDeptNm.add(lcMangeDeptNm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.91));
         lccmMangeDeptNm.add(btnMangeDeptCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));
           
		lcStdSbLeft.add(lccmMangeDeptNm, new FormData("100%"));
		
		
	    LayoutContainer lc1 = new LayoutContainer(new ColumnLayout());
	    
	    LayoutContainer lcHanNm = new LayoutContainer();
	    
	    frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(100);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		lcHanNm.setLayout(frmlytSbStd);
		
		hanNm = new MSFTextField();
      hanNm.setFieldLabel("성명/주민번호");
	    lcHanNm.add(hanNm, new FormData("100%"));
	    
	    lc1.add(lcHanNm, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
	   
	    
	    LayoutContainer lcRegn = new LayoutContainer();
	    
	    frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(0);
		lcRegn.setLayout(frmlytSbStd);
	    
		resnRegnNum = new MSFTextField();
	    resnRegnNum.setName("resnRegnNum");
	    new TextFieldMask<String>(resnRegnNum, "999999-9999999");  
	    resnRegnNum.setLabelSeparator("");
	    
      lcRegn.add(resnRegnNum, new FormData("100%"));
	    
	    lc1.add(lcRegn, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
	    
      lcStdSbLeft.add(lc1, new FormData("100%"));
		
		

//		currAffnDeptCd = new ComboBox<BaseModel>();
//		currAffnDeptCd.setFieldLabel("부서");
//		currAffnDeptCd.setForceSelection(true);
//		currAffnDeptCd.setMinChars(1);
//		currAffnDeptCd.setDisplayField("deptNmRtchnt");
//		currAffnDeptCd.setValueField("deptCd");
//		currAffnDeptCd.setTriggerAction(TriggerAction.ALL);
//		currAffnDeptCd.setEmptyText("--관리부서선택--");  //MSFMainApp.ADMINCONSTANTS.InserireCategoria()
//		currAffnDeptCd.setSelectOnFocus(true);
//		currAffnDeptCd.setStore(listStoreBass0400All2);
		 //부서 코드 처리  
      LayoutContainer lccmCurrAffnDeptNm = new LayoutContainer();
      lccmCurrAffnDeptNm.setLayout(new ColumnLayout());
      
//      LayoutContainer lcCurrAffnDeptCd = new LayoutContainer(); 
//      frmlytSch = new FormLayout();
//      frmlytSch.setLabelWidth(100);
//      frmlytSch.setLabelAlign(LabelAlign.RIGHT);
//      lcCurrAffnDeptCd.setLayout(frmlytSch);
          
      //부서 
      currAffnDeptCd = new MSFTextField();
      currAffnDeptCd.setName("currAffnDeptCd");
      currAffnDeptCd.setVisible(false);
      plFrmPsnl0200.add(currAffnDeptCd);
//      currAffnDeptCd.setReadOnly(true);
//      currAffnDeptCd.setFieldLabel("소속부서");   
//      lcCurrAffnDeptCd.add(currAffnDeptCd, new FormData("100%"));    
       
       LayoutContainer lcCurrAffnDeptNm = new LayoutContainer(); 
       frmlytSch = new FormLayout();
       frmlytSch.setLabelWidth(100);
       frmlytSch.setLabelAlign(LabelAlign.RIGHT);
       lcCurrAffnDeptNm.setLayout(frmlytSch);
    
       currAffnDeptNm = new MSFTextField(); 
       currAffnDeptNm.setName("currAffnDeptNm");
       currAffnDeptNm.setFieldLabel("소속부서");   
     //  currAffnDeptNm.setLabelSeparator("");
       currAffnDeptNm.addKeyListener(new KeyListener() {
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
       
//       currAffnDeptNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//                  @Override
//                  public void handleEvent(BaseEvent be) { 
//                       
//                   if (MSFSharedUtils.allowNulls(currAffnDeptNm.getValue()).trim().equals("")) {
//                       currAffnDeptCd.setValue("");
//                   }
//                     if (MSFSharedUtils.paramNull(currAffnDeptNm.getValue())) {
//                         currAffnDeptCd.setValue("");
//                     }   
//                  } 
//         });        
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
          
       //  lccmCurrAffnDeptNm.add(lcCurrAffnDeptCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.55));  
         lccmCurrAffnDeptNm.add(lcCurrAffnDeptNm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.91));
         lccmCurrAffnDeptNm.add(btnCurrAffnDeptCd,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.09));
           
         
		lcStdSbCenter.add(lccmCurrAffnDeptNm, new FormData("100%"));

		LayoutContainer lc2 = new LayoutContainer(new ColumnLayout());
		
	    LayoutContainer lcEngNm = new LayoutContainer();
	    
	    frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(100);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		lcEngNm.setLayout(frmlytSbStd);
		
		engNm = new MSFTextField();
		engNm.setFieldLabel("영문명/한문명");
      lcEngNm.add(engNm, new FormData("100%"));
	    
      lc2.add(lcEngNm, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.65));
      
      
	    LayoutContainer lcChanNm = new LayoutContainer();
	    
	    frmlytSbStd = new FormLayout();
		frmlytSbStd.setLabelWidth(0);
		frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
		lcChanNm.setLayout(frmlytSbStd);
		
		chinCharNm = new MSFTextField();
		chinCharNm.setLabelSeparator("");
		lcChanNm.add(chinCharNm, new FormData("100%"));
	    
      lc2.add(lcChanNm, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
	    
	    lcStdSbCenter.add(lc2);

//		chinCharNm = new MSFTextField();
//		chinCharNm.setFieldLabel("성명(한자)");
//		//chinCharNm.setAllowBlank(false);
//		lcStdSbLeft.add(chinCharNm, new FormData("100%"));

		currPaeWorkNm = new MSFTextField();
		currPaeWorkNm.setFieldLabel("현근무지");
		currPaeWorkNm.setReadOnly(true);
//		currPaeWorkNm.setEnabled(false);
		lcStdSbLeft.add(currPaeWorkNm, new FormData("100%"));

		repbtyBusinNm = new MSFTextField();
		repbtyBusinNm.setFieldLabel("담당업무");
//		repbtyBusinNm.setReadOnly(true);
//		repbtyBusinNm.setEnabled(false);
		repbtyBusinNm.setEmptyText("--담당업무명--");
		
		lcStdSbLeft.add(repbtyBusinNm, new FormData("100%"));

      //---------------------------- 좌측 데이타 끝 부분  ------------------------------
		
		 //---------------------------- 우측ㄷ이타 시작   ------------------------------

//		engNm = new MSFTextField();
//		engNm.setFieldLabel("성명(영문)");
//		lcStdSbCenter.add(engNm, new FormData("100%"));

		businNm = new MSFTextField();
		businNm.setFieldLabel("사업명");
		businNm.setReadOnly(true);
//		businNm.setEnabled(false);
		lcStdSbCenter.add(businNm, new FormData("100%"));
		
		
//		dtilOccuInttnCd = new MSFComboBox<BaseModel>();
//		dtilOccuInttnCd.setFieldLabel("직종세구분");
//		dtilOccuInttnCd.setForceSelection(true);
//		dtilOccuInttnCd.setMinChars(1);
//		dtilOccuInttnCd.setDisplayField("dtilOccuClsNm");
//		dtilOccuInttnCd.setValueField("dtilOccuInttnCd");
//		dtilOccuInttnCd.setTriggerAction(TriggerAction.ALL);
//		dtilOccuInttnCd.setEmptyText("--직종세선택--");
//		dtilOccuInttnCd.setSelectOnFocus(true);
//		dtilOccuInttnCd.setReadOnly(true);
//		dtilOccuInttnCd.disable();
////		tempComboBox.setEnabled(false);
////		dtilOccuInttnCd.setStore(lsTypOccuCd);
//		dtilOccuInttnCd.setStore(listStoreA041);
//		lcStdSbCenter.add(dtilOccuInttnCd, new FormData("100%"));

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
//		hdofcCodtnCd.setEnabled(false);
		lcStdSbCenter.add(hdofcCodtnCd, new FormData("100%"));
		
       //------------------------- 우측 데이타 끝 ---------------------------------------
		
		lcStdSbCol.add(lcStdSbLeft,	new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		lcStdSbCol.add(lcStdSbCenter,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		lcStdCenter.add(lcStdSbCol, new FormData("100%"));
		
		
		LayoutContainer lcEtc = new LayoutContainer();
		FormLayout frmlytEtc = new FormLayout();
		frmlytEtc.setLabelWidth(0);
		lcEtc.setLayout(frmlytEtc);
		
//		memoInfo = new MSFTextField();
//		memoInfo.setLabelSeparator("");
//		//memoInfo.setEnabled(false);
//		memoInfo.setReadOnly(true);
		//여기에 탭 추가 함.  
		lcEtc.add(PsnlCtrTab(), new FormData("100%"));
		lcStdCenter.add(lcEtc);

		lcStdCol.add(lcStdLeft,	new com.extjs.gxt.ui.client.widget.layout.ColumnData(.18));
		lcStdCol.add(lcStdCenter,	new com.extjs.gxt.ui.client.widget.layout.ColumnData(.82));
		

		fieldSet.add(lcMTRCol, new FormData("100%"));
		
		
		LayoutContainer layoutContainer_3 = new LayoutContainer();
		layoutContainer_3.setStyleAttribute("paddingLeft", "0px");

		layoutContainer_3.setLayout(new FitLayout());
		ContentPanel contentPanel = new ContentPanel();
		contentPanel.setHeaderVisible(false);
		contentPanel.setHeadingText("");
		contentPanel.setSize(120, 150);
		
		//picImg = new Image(GWT.getHostPageBaseURL()+MSFConfiguration.NON_EXTERM_PHOTO);
		picImg = new Image();
		picImg.setUrl(GWT.getHostPageBaseURL()+MSFMainApp.getMsg("PayGen.NonExTermPhoto"));
		picImg.setSize("136px", "150px");
		picImg.setVisible(true);
		picImg.setTitle("사진");
		contentPanel.add(picImg);
		
		
		layoutContainer_3.add(contentPanel);
		lcStdLeft.add(layoutContainer_3, new FormData("100%"));
		
		
		// 파일업로드 처리
		picFile = new FileUploadField();
	    picFile.setName("picFile");
		picFile.setLabelSeparator("");
		picFile.setStyleAttribute("paddingLeft", "0px");
		picFile.addListener(Events.Change, new Listener<FieldEvent>() {
			public void handleEvent(FieldEvent e) {
				
				// normally would submit the form but for example no server set
				// up to
				// handle the post
				// panel.submit();
				
				
				//파일업로드 서블릿 호출
				/*
				if(psnl0100Grid.getSelectionModel().getSelectedItem() != null){
					String dpobCd = "dpobCd"; //세팅 필요함
					String systemkey = "systemkey"; //세팅 필요함
					picFile.setName("PSNL0125"+"_"+dpobCd+"_"+systemkey);
					plFrmPsnl0100.setAction("paygenapp/ImageUpload");
					plFrmPsnl0100.submit();
				}
				*/
			}
		});
		// file.setAllowBlank(false);
		lcStdLeft.add(picFile, new FormData("100%"));
		
		
//		LayoutContainer lcGrid = new LayoutContainer();
//
//		lcGrid.setLayout(new FitLayout());
//		ContentPanel gridPanel = new ContentPanel();
//		gridPanel.setBodyBorder(false); 
//		gridPanel.setHeaderVisible(false);   
//		gridPanel.setSize(130, 150);
		
//	    MSFCustomForm msfCustomForm = new MSFCustomForm(psnl0100ViewDef, 0, 0, false, false, false);
//	    msfCustomForm.setHeaderVisible(false);
		
//	    psnl0100GridViewPanel = new MSFGridPanel(psnl0100ViewDef, false, false, false, false, false);
//	    psnl0100GridViewPanel.setHeaderVisible(false);  
//	    psnl0100GridViewPanel.setBodyBorder(false);
//	    psnl0100GridViewPanel.setSize(130, 150);
//	    psnl0100GridViewPanel.getBottomComponent().setVisible(false);
//	    psnl0100GridViewPanel.setBorders(true);
//		final Grid psnl010Grid = psnl0100GridViewPanel.getMsfGrid().getGrid();
//		psnl010Grid.addListener(Events.RowClick, new Listener<BaseEvent>() {
//			public void handleEvent(BaseEvent be) {  
//				if (psnl0110GridPanel.getCurrentlySelectedItem() != null) {    
////					setRecord(psnl0110GridPanel.getCurrentlySelectedItem());
//					// changeValueListenerAdapter 사용하려면
//					psnl0110GridPanel.getMSFFormPanel().bind(psnl0110GridPanel.getCurrentlySelectedItem());
//	   			} 
//	   		}
//		}); 
//	    psnl0100GridViewPanel.setMSFFormPanel(msfCustomForm);
//	    gridPanel.add(psnl0100GridViewPanel); 
//		
//		
//		lcGrid.add(gridPanel);
//		lcStdLeft.add(lcGrid, new FormData("100%"));
		
		
//		// 파일업로드 처리
//		picFile = new FileUploadField();
//
//		picFile.addListener(Events.Change, new Listener<FieldEvent>() {
//			public void handleEvent(FieldEvent e) {
//				
//				// normally would submit the form but for example no server set
//				// up to
//				// handle the post
//				// panel.submit();
//				
//				
//				//파일업로드 서블릿 호출
//				/*
//				if(psnl0100Grid.getSelectionModel().getSelectedItem() != null){
//					String dpobCd = "dpobCd"; //세팅 필요함
//					String systemkey = "systemkey"; //세팅 필요함
//					picFile.setName("PSNL0125"+"_"+dpobCd+"_"+systemkey);
//					plFrmPsnl0100.setAction("paygenapp/ImageUpload");
//					plFrmPsnl0100.submit();
//				}
//				*/
//				
//				
//				
//				
//			}
//		});
//		// file.setAllowBlank(false);
//		picFile.setName("파일");
//		picFile.setLabelSeparator("");
//		picFile.setStyleAttribute("paddingLeft", "0px");
//
//		LayoutContainer layoutContainer_3 = new LayoutContainer();
//		layoutContainer_3.setStyleAttribute("paddingLeft", "0px");
//
//		layoutContainer_3.setLayout(new FitLayout());
//		ContentPanel contentPanel = new ContentPanel();
//		contentPanel.setHeaderVisible(false);
//		contentPanel.setHeadingText("");
//		contentPanel.setSize(120, 150);
//		
//		//picImg = new Image(GWT.getHostPageBaseURL()+MSFConfiguration.NON_EXTERM_PHOTO);
//		picImg = new Image();
//		picImg.setUrl(GWT.getHostPageBaseURL()+MSFMainApp.getMsg("PayGen.NonExTermPhoto"));
//		picImg.setSize("136px", "150px");
//		picImg.setVisible(true);
//		picImg.setTitle("사진");
//		contentPanel.add(picImg);
//		
//		
//		layoutContainer_3.add(contentPanel);
//		lcStdLeft.add(layoutContainer_3, new FormData("100%"));
//		layoutContainer_3.setBorders(false);
//
//		lcStdLeft.add(picFile, new FormData("100%"));
		
     	LayoutContainer layoutContainer_4 = new LayoutContainer();
		layoutContainer_4.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_5 = new LayoutContainer();
		layoutContainer_5.setLayout(new FormLayout());
		layoutContainer_5.add(fieldSet, new FormData("100% 0"));
		layoutContainer_4.add(layoutContainer_5, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.8));
		layoutContainer_5.setSize("774", "290");
		layoutContainer_5.setBorders(false);

		LayoutContainer layoutContainer_6 = new LayoutContainer();
		layoutContainer_6.setLayout(new FormLayout());
		layoutContainer_6.add(lcMTRCenter, new FormData("100%"));
		layoutContainer_4.add(layoutContainer_6, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		layoutContainer_6.setBorders(false);
		plFrmPsnl0200.add(layoutContainer_4);
		layoutContainer_4.setBorders(false);

		// vp.add(panel);
	}

	// 탭정보 기본, 호봉획정, 급여,사대보험으로 구분하여 처리 하는 루틴 추가  
	private LayoutContainer PsnlCtrTab() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		
//		ContentPanel cp01 = new ContentPanel();
//		cp01.setBodyBorder(false);
//		cp01.setHeaderVisible(false);
//		cp01.setLayout(new FitLayout());
//		cp01.setSize(968, 213);
		
		tabsCtlPsnl = new TabPanel();
		
		//하위탭을 선택하였을 경우 관련된 정보를 가져온다.
		tabsCtlPsnl.addListener(Events.Select, new Listener<TabPanelEvent>() {
			public void handleEvent(TabPanelEvent e) {
						
				if(psnl0100Grid.getSelectionModel().getSelectedItem() != null){// 근로자 정보를 선택 하였을 경우만...

					if(tabsCtlPsnl.getSelectedItem().getId() == "itemPsnlStd03") {

			    		String dpobCd = "";
			    		String systemkey = "";
			    		systemkey = psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey();
			    		dpobCd = psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd();
			    		
			        	if (MSFSharedUtils.paramNull(systemkey)) {
				            return;
				        }

						BaseModel paramKey = new BaseModel();
						
						paramKey.set("dpobCd", dpobCd);
						paramKey.set("systemkey", systemkey);

			    		//급여내역  
					   PayrP410001 payrP41001Form = new PayrP410001(ActionDatabase.READ, getThis());   
					    
				       MSFFormWindows msFwPayr41001 = new MSFFormWindows("월별급여내역",payrP41001Form,"닫기","820px", "710px",true);
				       msFwPayr41001.show();
				       payrP41001Form.setMSFFormWindows(msFwPayr41001);
				       payrP41001Form.bind(paramKey); 

				       tabsCtlPsnl.setSelection(tabsCtlPsnl.findItem(gsSelectedTabItem, true));
					}
					else
					{
						//탭선택
						getMainSubTabData(tabsCtlPsnl.getSelectedItem().getId());
						gsSelectedTabItem = tabsCtlPsnl.getSelectedItem().getId();
					}
//					//탭선택
//					getMainSubTabData(tabsCtlPsnl.getSelectedItem().getId());
							
				}else{
					//resetPsnl0111Form();//인적 
					//tabsCtlPsnl.setSelection(tabsCtlPsnl.findItem("itemPsnl0111", true));
					//psnl0110Store.removeAll(); //고용그리드 초기화
					//resetPsnl0112Form();
					//resetPsnl0113Form();
				}
			}
		});
		
		
		// tabsPsnl.setMinTabWidth(80);
		tabsCtlPsnl.setAutoWidth(false);
		// tabsPsnl.setResizeTabs(true);
		tabsCtlPsnl.setAnimScroll(true);
		tabsCtlPsnl.setTabScroll(true);
		tabsCtlPsnl.setPlain(true);
		tabsCtlPsnl.setSize(630, 170);

		TabItem itemPsnlStd01 = new TabItem();
		//itemPsnlStd01.setStyleAttribute("padding", "10px");
		itemPsnlStd01.setId("itemPsnlStd01");
		itemPsnlStd01.setText(" 기 본 ");
		itemPsnlStd01.setLayout(new FormLayout());
		itemPsnlStd01.add(itemPsnlStd01(), new FormData("100%"));
		tabsCtlPsnl.add(itemPsnlStd01);
		
		
		TabItem itemPsnlStd02 = new TabItem();
		//itemPsnlStd02.setStyleAttribute("padding", "10px");
		itemPsnlStd02.setId("itemPsnlStd02");
		itemPsnlStd02.setText(" 호봉획정 ");
		itemPsnlStd02.setLayout(new FormLayout());
		itemPsnlStd02.add(itemPsnlStd02(), new FormData("100%"));
		tabsCtlPsnl.add(itemPsnlStd02);
		
		TabItem itemPsnlStd03 = new TabItem();
		//itemPsnlStd03.setStyleAttribute("padding", "10px");
		itemPsnlStd03.setId("itemPsnlStd03");
		itemPsnlStd03.setText(" 급 여 ");
		itemPsnlStd03.setLayout(new FormLayout());
		itemPsnlStd03.add(itemPsnlStd03(), new FormData("100%"));
		tabsCtlPsnl.add(itemPsnlStd03);
		
		TabItem itemPsnlStd04 = new TabItem();
		//itemPsnlStd04.setStyleAttribute("padding", "10px");
		itemPsnlStd04.setId("itemPsnlStd03");
		itemPsnlStd04.setText(" 사회보험 ");
		itemPsnlStd04.setLayout(new FormLayout());
		itemPsnlStd04.add(itemPsnlStd04(), new FormData("100%"));
		tabsCtlPsnl.add(itemPsnlStd04);
		
//		cp01.add(tabsCtlPsnl, new FormData("100%"));
		
		lcTabFormLayer.add(tabsCtlPsnl);

		return lcTabFormLayer;
	}
	

private LayoutContainer itemPsnlStd01() {		
	 
	LayoutContainer lcTabFormLayer = new LayoutContainer(); 
	lcTabFormLayer.setLayout(new FormLayout()); 
	lcTabFormLayer.setBorders(false);
	// 상단에 원래 메뉴 놓기 

	ContentPanel cp01 = new ContentPanel();
	cp01.setBodyBorder(false);
	cp01.setHeaderVisible(false);
	cp01.setFrame(true);
	cp01.setSize(630, 170);
	cp01.setLayout(new FitLayout()); 
	
	LayoutContainer lcStdSbCol01 = new LayoutContainer(new ColumnLayout());  
	
	lcStdSbCol01.setBorders(false);
	
	LayoutContainer lcStdSbLeft01 = new LayoutContainer();
	lcStdSbLeft01.setStyleAttribute("paddingTop", "3px");
	lcStdSbLeft01.setStyleAttribute("paddingRight", "10px");
	FormLayout frmlytSbStd = new FormLayout();
	frmlytSbStd.setLabelWidth(95);
	frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
	lcStdSbLeft01.setLayout(frmlytSbStd);

	LayoutContainer lcStdSbRight01 = new LayoutContainer();
	lcStdSbRight01.setStyleAttribute("paddingTop", "3px");
	lcStdSbRight01.setStyleAttribute("paddingRight", "10px");
	frmlytSbStd = new FormLayout();
	frmlytSbStd.setLabelWidth(95);
	frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
	lcStdSbRight01.setLayout(frmlytSbStd);

	//---------------------- 좌측 ----------------------------------------------------
	
	emymtDivCd = new MSFComboBox<BaseModel>();
	emymtDivCd.setFieldLabel("고용구분");
	emymtDivCd.setForceSelection(true);
	emymtDivCd.setMinChars(1);
	emymtDivCd.setDisplayField("commCdNm");
	emymtDivCd.setValueField("commCd");
	emymtDivCd.setTriggerAction(TriggerAction.ALL);
	emymtDivCd.setEmptyText("--고용구분선택--");
	emymtDivCd.setSelectOnFocus(true);
	emymtDivCd.setStore(listStoreA002);
	emymtDivCd.setReadOnly(true);
//	emymtDivCd.setEnabled(false);
	lcStdSbLeft01.add(emymtDivCd, new FormData("100%"));
	
//	odtyCd = new MSFComboBox<BaseModel>();
//	odtyCd.setFieldLabel("직 책");
//	odtyCd.setForceSelection(true);
//	odtyCd.setMinChars(1);
//	odtyCd.setDisplayField("commCdNm");
//	odtyCd.setValueField("commCd");
//	odtyCd.setTriggerAction(TriggerAction.ALL);
//	odtyCd.setEmptyText("--직책선택--");
//	odtyCd.setSelectOnFocus(true);
//	odtyCd.setStore(listStoreA015);
//	lcStdSbLeft.add(odtyCd, new FormData("100%"));

	frstEmymtDt = new MSFDateField();
	frstEmymtDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
	frstEmymtDt.setFieldLabel("입사일자");
	frstEmymtDt.setReadOnly(true);
//	frstEmymtDt.setEnabled(false);
	lcStdSbLeft01.add(frstEmymtDt, new FormData("100%"));

	emymtEndDt = new MSFDateField();
	emymtEndDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
	emymtEndDt.setFieldLabel("퇴사일자");
	emymtEndDt.setReadOnly(true);
//	emymtEndDt.setEnabled(false);
	lcStdSbLeft01.add(emymtEndDt, new FormData("100%"));

	logSvcYrNum = new MSFTextField();
	logSvcYrNum.setFieldLabel("고용개월수");
	logSvcYrNum.setReadOnly(true);
//	logSvcYrNum.setEnabled(false);
	lcStdSbLeft01.add(logSvcYrNum, new FormData("100%"));
	
	LayoutContainer lucnNatn = new LayoutContainer(new ColumnLayout());
	LayoutContainer lucnNatn1_1 = new LayoutContainer();
	
	btnNatnCd = new Button();
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
	FormLayout frmlytSch2 = new FormLayout();
	frmlytSch2.setLabelWidth(95);
	frmlytSch2.setLabelAlign(LabelAlign.RIGHT);
	lucnNatn1_1.setLayout(frmlytSch2);
	natnNm.setFieldLabel("국  가");
	
	natnCd = new HiddenField<String>();
	natnCd.setName("natnCd");
	natnCd.setFieldLabel("natnCd");
	natnNm.addKeyListener(new KeyListener() {
      public void componentKeyDown(ComponentEvent event) {
          
          natnCd.validate();
          if (MSFSharedUtils.allowNulls(natnNm.getValue()).trim().equals("")) {
          	natnCd.setValue("");
          }
          if (MSFSharedUtils.paramNull(natnNm.getValue())) {
          	natnCd.setValue("");
          }   
          if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
          	if (MSFSharedUtils.allowNulls(natnNm.getValue()).trim().equals("")) {
          		natnNm.setValue("");
          		natnCd.setValue("");
              }
          	fnPopupBass0300("A001");
          }
          
          super.componentKeyDown(event);
      }
   });
	lucnNatn1_1.add(natnNm, new FormData("100%"));
	
	
	LayoutContainer lucnNatn1_2 = new LayoutContainer();
	FormLayout frmlytSch3 = new FormLayout();
	frmlytSch3.setLabelWidth(0);
	lucnNatn1_2.setLayout(frmlytSch3);
	natnItem = new MSFTextField();
	natnItem.setReadOnly(true);
	natnItem.setLabelSeparator("");
	
	lucnNatn1_2.add(natnItem, new FormData("100%"));
	
	lucnNatn.add(lucnNatn1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
	lucnNatn.add(lucnNatn1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
	
	lcStdSbLeft01.add(lucnNatn, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
	
   // ----------------------------------------- 우측 ---------------------------------------------------------------
	//데이터 추가 후 수정...
	repbtyBusinDivCd = new MSFComboBox<BaseModel>();
	//repbtyBusinDivCd.setFieldLabel("전환대상");
	repbtyBusinDivCd.setLabelSeparator("");
	repbtyBusinDivCd.setForceSelection(true);
	repbtyBusinDivCd.setMinChars(1);
	repbtyBusinDivCd.setTriggerAction(TriggerAction.ALL);
	repbtyBusinDivCd.setEmptyText("--전환대상--");
	repbtyBusinDivCd.setSelectOnFocus(true);
	repbtyBusinDivCd.setReadOnly(true);
	repbtyBusinDivCd.setEnabled(false);
	repbtyBusinDivCd.setStore(new ListStore<BaseModel>());
	lcStdSbRight01.add(repbtyBusinDivCd, new FormData("100%"));

	currDeptAppmtDt = new MSFDateField();
	currDeptAppmtDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
	currDeptAppmtDt.setFieldLabel("현부서고용일자");
	currDeptAppmtDt.setReadOnly(true);
//	currDeptAppmtDt.setEnabled(false);
	lcStdSbRight01.add(currDeptAppmtDt, new FormData("100%"));

	retryReasCtnt = new MSFTextField();
	retryReasCtnt.setFieldLabel("퇴사사유");
	retryReasCtnt.setReadOnly(true);
//	retryReasCtnt.setEnabled(false);
	lcStdSbRight01.add(retryReasCtnt, new FormData("100%"));
	
	
	odtyCd = new MSFComboBox<BaseModel>();
	odtyCd.setFieldLabel("직 책");
	odtyCd.setForceSelection(true);
	odtyCd.setMinChars(1);
	odtyCd.setDisplayField("commCdNm");
	odtyCd.setValueField("commCd");
	odtyCd.setTriggerAction(TriggerAction.ALL);
	odtyCd.setEmptyText("--직책선택--");
	odtyCd.setSelectOnFocus(true);
	odtyCd.setStore(listStoreA015);
	lcStdSbRight01.add(odtyCd, new FormData("100%"));

//	tempTextField = new MSFTextField();
//	tempTextField.setFieldLabel("상태정보");
////	tempTextField.setEnabled(false);
//	tempTextField.setReadOnly(true);
//	lcStdSbCenter.add(tempTextField, new FormData("100%"));
	
//	LayoutContainer lucnNatn = new LayoutContainer(new ColumnLayout());
//	LayoutContainer lucnNatn1_1 = new LayoutContainer();
//	
//	btnNatnCd = new Button();
//	btnNatnCd.setIcon(MSFMainApp.ICONS.search());
//	btnNatnCd.addListener(Events.Select, new Listener<ButtonEvent>() {
//      public void handleEvent(ButtonEvent e) {
//      	if (MSFSharedUtils.allowNulls(natnNm.getValue()).trim().equals("")) {
//      		natnCd.setValue("");
//          }
//      	fnPopupBass0300("A001");
//      }
//  });
//		
//	
//	natnNm = new TextFieldWithButton<String>(btnNatnCd);
//	FormLayout frmlytSch2 = new FormLayout();
//	frmlytSch2.setLabelWidth(100);
//	frmlytSch2.setLabelAlign(LabelAlign.RIGHT);
//	lucnNatn1_1.setLayout(frmlytSch2);
//	natnNm.setFieldLabel("국가코드");
//	
//	natnCd = new HiddenField<String>();
//	natnCd.setName("natnCd");
//	natnCd.setFieldLabel("natnCd");
//	natnNm.addKeyListener(new KeyListener() {
//      public void componentKeyDown(ComponentEvent event) {
//          
//          natnCd.validate();
//          if (MSFSharedUtils.allowNulls(natnNm.getValue()).trim().equals("")) {
//          	natnCd.setValue("");
//          }
//          if (MSFSharedUtils.paramNull(natnNm.getValue())) {
//          	natnCd.setValue("");
//          }   
//          if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
//          	if (MSFSharedUtils.allowNulls(natnNm.getValue()).trim().equals("")) {
//          		natnNm.setValue("");
//          		natnCd.setValue("");
//              }
//          	fnPopupBass0300("A001");
//          }
//          
//          super.componentKeyDown(event);
//      }
//   });
//	lucnNatn1_1.add(natnNm, new FormData("100%"));
//	
//	
//	LayoutContainer lucnNatn1_2 = new LayoutContainer();
//	FormLayout frmlytSch3 = new FormLayout();
//	frmlytSch3.setLabelWidth(0);
//	lucnNatn1_2.setLayout(frmlytSch3);
//	natnItem = new MSFTextField();
//	natnItem.setReadOnly(true);
//	natnItem.setLabelSeparator("");
//	
//	lucnNatn1_2.add(natnItem, new FormData("100%"));
//	
//	lucnNatn.add(lucnNatn1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
//	lucnNatn.add(lucnNatn1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
//	
//	lcStdSbCenter.add(lucnNatn, new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
	  
	
	lcStdSbCol01.add(lcStdSbLeft01,	new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	lcStdSbCol01.add(lcStdSbRight01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	
	lcStdSbLeft01.setBorders(false);
	lcStdSbRight01.setBorders(false);
	lcStdSbCol01.setBorders(false);
	
	cp01.add(lcStdSbCol01);
	
	lcTabFormLayer.add(cp01, new FormData("100%")); 
	
	return lcTabFormLayer;
}

private LayoutContainer itemPsnlStd02() {		

	LayoutContainer lcTabFormLayer = new LayoutContainer(); 
	lcTabFormLayer.setLayout(new FormLayout()); 
	lcTabFormLayer.setBorders(false);
	// 상단에 원래 메뉴 놓기 

	ContentPanel cp01 = new ContentPanel();
	cp01.setBodyBorder(false);
	cp01.setHeaderVisible(false);
	cp01.setFrame(true);
	cp01.setSize(630, 170);
	cp01.setLayout(new FitLayout()); 
	
	LayoutContainer lcStdSbCol01 = new LayoutContainer(new ColumnLayout());  
	
	lcStdSbCol01.setBorders(false);
	
	LayoutContainer lcStdSbLeft01 = new LayoutContainer();
	lcStdSbLeft01.setStyleAttribute("paddingTop", "3px");
	lcStdSbLeft01.setStyleAttribute("paddingRight", "10px");
	FormLayout frmlytSbStd = new FormLayout();
	frmlytSbStd.setLabelWidth(95);
	frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
	lcStdSbLeft01.setLayout(frmlytSbStd);

	LayoutContainer lcStdSbRight01 = new LayoutContainer();
	lcStdSbRight01.setStyleAttribute("paddingTop", "3px");
	lcStdSbRight01.setStyleAttribute("paddingRight", "10px");
	frmlytSbStd = new FormLayout();
	frmlytSbStd.setLabelWidth(95);
	frmlytSbStd.setLabelAlign(LabelAlign.RIGHT);
	lcStdSbRight01.setLayout(frmlytSbStd);

	//---------------------- 좌측 ----------------------------------------------------
	 
	 
	
	
	
   // ----------------------------------------- 우측 ---------------------------------------------------------------

 
	
	
	lcStdSbCol01.add(lcStdSbLeft01,	new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	lcStdSbCol01.add(lcStdSbRight01, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
	
	lcStdSbLeft01.setBorders(false);
	lcStdSbRight01.setBorders(false);
	lcStdSbCol01.setBorders(false);
	
	cp01.add(lcStdSbCol01);
	
	lcTabFormLayer.add(cp01, new FormData("100%")); 
	
	return lcTabFormLayer;
}
		 
private LayoutContainer itemPsnlStd03() {		
	LayoutContainer lcTabFormLayer = new LayoutContainer();
	
	return lcTabFormLayer;
 }
/******************************************************************
 * 사회보험 중간에 위치하는 부분 처리 		
 * @return
 ******************************************************************/
 private LayoutContainer itemPsnlStd04() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		
			    
/*		ColumnConfig column = new ColumnConfig();
		column.setId("soctyInsurYr");
		column.setHeaderText("사회보험년도");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);
		
		
		column = new ColumnConfig();
		column.setId("hlthInsurFlucDt");
		column.setHeaderText("사회보험변동일자");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(100);
		column.setSortable(false);
	    column.setMenuDisabled(true);
		configs.add(column);
*/
		ColumnConfig column = new ColumnConfig("hlthInsrPayTotAmnt", "건강보험보수총액", 120);
		column.setAlignment(HorizontalAlignment.RIGHT);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setRenderer(new GridCellRenderer<Psnl0127DTO>(){
			@Override
			public Object render(Psnl0127DTO model, String property,
					ColumnData config, int rowIndex, int colIndex,
					ListStore<Psnl0127DTO> store, Grid<Psnl0127DTO> grid) {
				return NumberFormat.getFormat("#,##0").format(Integer.parseInt(model.get(property).toString()));
			}
		});
		configs.add(column);

		column = new ColumnConfig("hlthInsrMnthRuntnAmnt", "건강보험보수월액", 120);
		column.setAlignment(HorizontalAlignment.RIGHT);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setRenderer(new GridCellRenderer<Psnl0127DTO>(){
			@Override
			public Object render(Psnl0127DTO model, String property,
					ColumnData config, int rowIndex, int colIndex,
					ListStore<Psnl0127DTO> store, Grid<Psnl0127DTO> grid) {
				return NumberFormat.getFormat("#,##0").format(Integer.parseInt(model.get(property).toString()));
			}
		});
		configs.add(column);

		column = new ColumnConfig("natPennStdIncmMnthAmnt", "국민기준소득월액", 120);
		column.setAlignment(HorizontalAlignment.RIGHT);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setRenderer(new GridCellRenderer<Psnl0127DTO>(){
			@Override
			public Object render(Psnl0127DTO model, String property,
					ColumnData config, int rowIndex, int colIndex,
					ListStore<Psnl0127DTO> store, Grid<Psnl0127DTO> grid) {
				return NumberFormat.getFormat("#,##0").format(Integer.parseInt(model.get(property).toString()));
			}
		});
		configs.add(column);
		
		column = new ColumnConfig("umytInsrPayMnthAmnt", "고용보험보수월액", 120);
		column.setAlignment(HorizontalAlignment.RIGHT);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setRenderer(new GridCellRenderer<Psnl0127DTO>(){
			@Override
			public Object render(Psnl0127DTO model, String property,
					ColumnData config, int rowIndex, int colIndex,
					ListStore<Psnl0127DTO> store, Grid<Psnl0127DTO> grid) {
				return NumberFormat.getFormat("#,##0").format(Integer.parseInt(model.get(property).toString()));
			}
		});
		configs.add(column);
		
		column = new ColumnConfig("idtlAccdtPayMnthAmnt", "산재보험보수월액", 120);
		column.setAlignment(HorizontalAlignment.RIGHT);
		column.setSortable(false);
		column.setMenuDisabled(true);
		column.setRenderer(new GridCellRenderer<Psnl0127DTO>(){
			@Override
			public Object render(Psnl0127DTO model, String property,
					ColumnData config, int rowIndex, int colIndex,
					ListStore<Psnl0127DTO> store, Grid<Psnl0127DTO> grid) {
				return NumberFormat.getFormat("#,##0").format(Integer.parseInt(model.get(property).toString()));
			}
		});
		configs.add(column);
		
		CheckColumnConfig ckColumn = new CheckColumnConfig("hlthInsrApptnChk", "건강보험", 90);
		ckColumn.setAlignment(HorizontalAlignment.CENTER);
		ckColumn.setSortable(false);
		ckColumn.setMenuDisabled(true);
		configs.add(ckColumn);
		
		ckColumn = new CheckColumnConfig("natPennApptnChk", "국민연금", 90);
		ckColumn.setAlignment(HorizontalAlignment.CENTER);
		ckColumn.setSortable(false);
		ckColumn.setMenuDisabled(true);
		configs.add(ckColumn);
		
		ckColumn = new CheckColumnConfig("umytInsrApptnChk", "고용보험", 90);
		ckColumn.setAlignment(HorizontalAlignment.CENTER);
		ckColumn.setSortable(false);
		ckColumn.setMenuDisabled(true);
		configs.add(ckColumn);
		
		ckColumn = new CheckColumnConfig("idtlAccdtInsurApptnChk", "산재보험", 90);
		ckColumn.setAlignment(HorizontalAlignment.CENTER);
		ckColumn.setSortable(false);
		ckColumn.setMenuDisabled(true);
		configs.add(ckColumn);
		
//		final ComboBox<BaseModel> apptnYnCombo = new ComboBox<BaseModel>();  
//		apptnYnCombo.setForceSelection(true);
//		apptnYnCombo.setMinChars(1);
//		apptnYnCombo.setDisplayField("commCdNm");
//		apptnYnCombo.setValueField("commCd");
//		apptnYnCombo.setForceSelection(true);  
//		apptnYnCombo.setTriggerAction(TriggerAction.ALL);
//		ListStore<BaseModel> lsApptnYnComboYN = new ListStore<BaseModel>();
//		BaseModel apptnYnBaseModel = new BaseModel();
//		apptnYnBaseModel.set("commCd", "Y");
//		apptnYnBaseModel.set("commCdNm", "Y");
//		lsApptnYnComboYN.add(apptnYnBaseModel);
//		apptnYnBaseModel = new BaseModel();
//		apptnYnBaseModel.set("commCd", "N");
//		apptnYnBaseModel.set("commCdNm", "N");
//		lsApptnYnComboYN.add(apptnYnBaseModel);
//		apptnYnCombo.setStore(lsApptnYnComboYN);
//		
//		CellEditor apptnYnEditor = new CellEditor(apptnYnCombo){  
//	        @Override  
//	        public Object preProcessValue(Object value) {  
//	          if (value == null) {  
//	            return value;  
//	          }  
//	          return apptnYnCombo.getStore().findModel(PersonalUtil.getBaseModelComboDataCd(apptnYnCombo, String.valueOf(value)));  
//	        }  
//	    
//	        @Override  
//	        public Object postProcessValue(Object value) {  
//	          if (value == null) {  
//	            return value;  
//	          }  
//	          return ((BaseModel) value).get("commCd");  
//	        }  
//	    };
//		
//		
////		column = new ColumnConfig("hlthInsrApptnYn", "건강보험", 90);
//	    column = new ColumnConfig();
//		column.setId("hlthInsrApptnYn");
//		column.setHeaderText("건강보험");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(90);
//		column.setEditor(apptnYnEditor);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		column.setRenderer(new GridCellRenderer<BaseModelData>() {
//			@Override
//			public Object render(BaseModelData model, String property,
//					ColumnData config, int rowIndex, int colIndex,
//					ListStore<BaseModelData> store, Grid<BaseModelData> grid) {
//				
//				if(apptnYnCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("hlthInsrApptnYn"))!= null){
//					return apptnYnCombo.getStore().findModel("commCd",store.getModels().get(rowIndex).get("hlthInsrApptnYn")).get("commCdNm");
//				}else{
//					return "";
//				}
//			}
//		});
//		configs.add(column);
//		
//		column = new ColumnConfig("natPennApptnYn", "국민연금", 90);
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//		
//		
//		column = new ColumnConfig("umytInsrApptnYn", "고용보험", 90);
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);
//		
//		column = new ColumnConfig("idtlAccdtInsurApptnYn", "산재보험", 90);
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		configs.add(column);

		
		ColumnModel cm = new ColumnModel(configs);

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(625, 140);
		
		
		final Grid<Psnl0127DTO> psnl0127Grid = new Grid<Psnl0127DTO>(psnl0127Store, cm);
		psnl0127Grid.setStateful(true);
		psnl0127Grid.setLoadMask(true); // 작업중표시
//		psnl0127Grid.setAutoExpandColumn("hlthInsrPayTotAmnt");
		psnl0127Grid.setColumnResize(true);
		psnl0127Grid.setBorders(true);
		 

		cp01.add(psnl0127Grid);
 
		
		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;
}		
		
		
	// 인사리스트
	private LayoutContainer PsnlList01() {

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		loaderPaging.setRemoteSort(true);
		PagingToolBar toolBar = new PagingToolBar(50);
		toolBar.bind(loaderPaging);

		List<ColumnConfig> columns = new ArrayList<ColumnConfig>();
		
		/*
		RowNumberer rn = new RowNumberer();
		rn.setHeader("순번");
		rn.setAlignment(HorizontalAlignment.CENTER);
		rn.setWidth(30);
		rn.setSortable(false);
		columns.add(rn);
		*/
		ColumnConfig column = new ColumnConfig();
		column.setId("rnum");
		column.setHeaderText("순번");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(40);
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);
		
		
		column = new ColumnConfig();
		column.setId("resnRegnNum");
		column.setHeaderText("주민번호");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(80);
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);

		column = new ColumnConfig();
		column.setId("hanNm");
		column.setHeaderText("성명");
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setWidth(90);
		column.setSortable(false);
		column.setMenuDisabled(true);
		columns.add(column);
		
		
		// 정의된 컬럼을 이용해 컬럼모델을 생성한다.
		ColumnModel cm = new ColumnModel(columns);
		// Store객체와 컬럼모델을 통해 Grid를 생성한다.
		psnl0100Grid = new Grid<Psnl0100DTO>(storePaging, cm); // 페이징 처리시 // 전체
																// 로드시 new
																// Grid<Psnl0100VO>(store,
																// cm);
		psnl0100Grid.setStateId("psnl0100GridId");
		psnl0100Grid.setStateful(true);
		
		//조회시 데이터 선택을 기본으로 0번째로 세팅한다.
		psnl0100Grid.getStore().addStoreListener(new StoreListener<Psnl0100DTO>(){
			@Override
			public void storeDataChanged(StoreEvent<Psnl0100DTO> se) {
				super.storeDataChanged(se);
				if(se.getStore().getModels().size() > 0){
					psnl0100Grid.getSelectionModel().select(0, false);
				}
			}
		});
		
		//그리드 로우 선택시
		psnl0100Grid.getSelectionModel().addSelectionChangedListener(new SelectionChangedListener<Psnl0100DTO>() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent<Psnl0100DTO> se) {
				if(se.getSelection().size() > 0){
					/*
					///아래의 데이터들 세팅 해야함 Jungmin
					private TextField<String> dpobNm; //사업명
					private TextField<String> tempTextField; //상태정보 
					*/
					
					//PersonalUtil.setSelectedComboValue(deptCd, se.getSelectedItem().getDeptCd(),"mangeDeptCd"); //기본사항 관리부서
                  //deptCd.fireEvent(Events.Change, se );
					//PersonalUtil.setSelectedComboValue(currAffnDeptCd, se.getSelectedItem().getCurrAffnDeptCd(),"deptCd"); //기본사항 부서
					
					//이미지 세팅
					if(se.getSelectedItem().getPicFlnm() != null && !"".equals(se.getSelectedItem().getPicFlnm()) ){
						picImg.setUrl(GWT.getHostPageBaseURL()+MSFMainApp.getMsg("PayGen.ExTermPhoto")+"/"+se.getSelectedItem().getPicFlnm() );
//						picImg.setUrl(GWT.getHostPageBaseURL()+MSFMainApp.getMsg("Globals.ExTermPhoto")+"/"+se.getSelectedItem().getPicFlnm() );
					}else{
						picImg.setUrl(GWT.getHostPageBaseURL()+MSFMainApp.getMsg("PayGen.NonExTermPhoto"));
					}
					mangeDeptCd.setValue(se.getSelectedItem().getDeptCd());				//관리부서코드
                  mangeDeptNm.setValue(se.getSelectedItem().getDeptNm());				//관리부서명
                  currAffnDeptCd.setValue(se.getSelectedItem().getCurrAffnDeptCd());	//소속부서코드
                  currAffnDeptNm.setValue(se.getSelectedItem().getCurrAffnDeptNm()); 	//소속부서명
                  resnRegnNum.setValue(se.getSelectedItem().getResnRegnNum());		//주민등록번호
                  resnRegnNumStr.setValue(se.getSelectedItem().getResnRegnNum());
                  resnRegnNum.fireEvent(Events.Add);
                  hanNm.setValue(se.getSelectedItem().getHanNm());					//한글이름
					chinCharNm.setValue(se.getSelectedItem().getChinCharNm());			//한자이름
					engNm.setValue(se.getSelectedItem().getEngNm());					//영문이름
					currPaeWorkNm.setValue(se.getSelectedItem().getCurrPaeWorkNm());	//현근무지
					businNm.setValue(se.getSelectedItem().getBusinNm()); 				//사업명 
					repbtyBusinNm.setValue(se.getSelectedItem().getRepbtyBusinNm());	//담당업무
					PersonalUtil.setSelectedComboValue(emymtDivCd, se.getSelectedItem().getEmymtDivCd()); 		//고용구분코드
					PersonalUtil.setSelectedComboValue(hdofcCodtnCd, se.getSelectedItem().getHdofcCodtnCd());	//재직구분
					PersonalUtil.setSelectedComboValue(odtyCd, se.getSelectedItem().getOdtyCd()); 				//직책
					DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyyMMdd");
					if(se.getSelectedItem().getFrstEmymtDt() != null && se.getSelectedItem().getFrstEmymtDt().length() == 8){
						frstEmymtDt.setValue(dateTimeFormat.parse(se.getSelectedItem().getFrstEmymtDt()));
					}else{
						frstEmymtDt.reset();
					}	//최초고용일자
					if(se.getSelectedItem().getEmymtBgnnDt() != null && se.getSelectedItem().getEmymtBgnnDt().length() == 8){
						currDeptAppmtDt.setValue(dateTimeFormat.parse(se.getSelectedItem().getEmymtBgnnDt()));
					}else{
						currDeptAppmtDt.reset();
					}	//현부서고용일자
					
					// TODO 고용해제일자는 퇴직일자
					if(se.getSelectedItem().getRetryDt() != null && se.getSelectedItem().getRetryDt().length() == 8){
						emymtEndDt.setValue(dateTimeFormat.parse(se.getSelectedItem().getRetryDt()));
					}else{
						emymtEndDt.reset();
					}	//고용해제일자
					
//					if(se.getSelectedItem().getEmymtEndDt() != null && se.getSelectedItem().getEmymtEndDt().length() == 8){
//						emymtEndDt.setValue(dateTimeFormat.parse(se.getSelectedItem().getEmymtEndDt()));
//					}else{
//						emymtEndDt.reset();
//					}	//고용해제일자
					retryReasCtnt.setValue(se.getSelectedItem().getRetryReasCtnt());	//고용 해제 사유
					logSvcYrNum.setValue(se.getSelectedItem().getWorkym());				//근속년수
					natnCd.setValue(se.getSelectedItem().getNatnCd());					//국가구분코드
					natnNm.setValue(se.getSelectedItem().getNatnNm());					//국가명
					natnItem.setValue(se.getSelectedItem().getNatnItem());				//국가코드 Item
//					PersonalUtil.setSelectedComboValue(typOccuCd, se.getSelectedItem().getTypOccuCd()); //직종
//					typOccuCd.fireEvent(Events.Change, se);
					
//					PersonalUtil.setSelectedComboValue(dtilOccuInttnCd, se.getSelectedItem().getDtilOccuInttnCd(), "dtilOccuInttnCd"); //직종세
					
					getTabData(tabsPsnl.getSelectedItem().getId());
					/*
					//그리드 선택시 탭선택을 처음탭으로 설정함.(인적)
					tabsPsnl.setSelection(tabsPsnl.getItem(0));
					
					//인적 데이터 가져와서 폼 세팅
					psnl0111Loader.load();
					//인적의 비고 세팅
					pernNoteCtnt.setValue(psnl0100Grid.getSelectionModel().getSelectedItem().getPernNoteCtnt());
					*/
				}
			}
		});
		 
		
		//그리드 그릴때 이벤트
		/*psnl0100Grid.addListener(Events.Attach,	new Listener<GridEvent<Psnl0100DTO>>() {
			public void handleEvent(GridEvent<Psnl0100DTO> be) {

				// 페이징 처리시 시작
				PagingLoadConfig config = new BasePagingLoadConfig();
				config.setOffset(0);
				config.setLimit(50);

				Map<String, Object> state = psnl0100Grid.getState();
				if (state.containsKey("offset")) {
					int offset = (Integer) state.get("offset");
					int limit = (Integer) state.get("limit");
					config.setOffset(offset);
					config.setLimit(limit);
				}
				if (state.containsKey("sortField")) {
					config.setSortField((String) state.get("sortField"));
					config.setSortDir(SortDir.valueOf((String) state
							.get("sortDir")));
				}
				loaderPaging.setSortDir(SortDir.ASC);
				loaderPaging.setSortField("hanNm");
				loaderPaging.setRemoteSort(true);
				loaderPaging.load(config);
				// 페이징 처리시 끝

			}
		});*/

		// 보여질 Grid의 로우를 하나를 선택할 것인지 복수개를 선택할 것인지 설정.
		psnl0100Grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		psnl0100Grid.setLoadMask(true);
		psnl0100Grid.setBorders(true);
		// 컬럼좌우폭에 대해 가변적으로 늘어나고 줄어들고 할 컬럼을 정해준다. 필수 사항암.
		psnl0100Grid.setAutoExpandColumn("hanNm");
		psnl0100Grid.setStateful(false);
		psnl0100Grid.setHeight(188); // Grid의 높이를 지정해준다.
		// ContentPanel에 그리드를 추가한다.
		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(true);
		cp01.setHeadingText("근로자정보");
		cp01.setLayout(new FitLayout());
		cp01.setSize(193, 280);
		cp01.add(psnl0100Grid); 
		
		// 페이징 처리시 시작
		cp01.setBottomComponent(toolBar);
		psnl0100Grid.getAriaSupport().setLabelledBy(cp01.getId());
		// 페이징 처리시 끝

		lcTabFormLayer.add(cp01);

		//lcTabFormLayer.setPosition(0, 100);
		
		return lcTabFormLayer;
	}
	
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 화면 초기화 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	//검색조건 초기화
	public void resetSearchForm() {
		searchName.setValue("");						//성명
		searchResnRegnNum.setValue("");					//주민등록번호
//		cmbxSchHdofcCodtnCd.setValue(new BaseModel());	//재직구분
		srhHdofcCodtnCd.setValue("");					//재직구분
		searchMangeDeptCd.setValue("");					//관리부서 코드
		searchMangeDeptNm.setValue("");					//관리부서 명
		searchYearBusinCd.setValue(new BaseModel());	//사업명
	}	
	
	//메인 화면 초기화
	public void resetMainForm(){
//		deptCd.setValue(new BaseModel());
//		currAffnDeptCd.setValue(new BaseModel());
	    if ( (MSFConfiguration.AUTH_USR_DIV_20.equals(MSFMainApp.get().getUser().getUsrDivCd())) || (MSFConfiguration.AUTH_USR_DIV_40.equals(MSFMainApp.get().getUser().getUsrDivCd()))) {
	        mangeDeptCd.setValue(MSFMainApp.get().getUser().getMangeDeptCd());
	        mangeDeptNm.setValue(MSFMainApp.get().getUser().getMangeDeptNm());
	        currAffnDeptCd.setValue(MSFMainApp.get().getUser().getDeptCd()); 
	        currAffnDeptNm.setValue(MSFMainApp.get().getUser().getDeptNm()); 
	    }  else {
	        mangeDeptCd.setValue("");
	        mangeDeptNm.setValue("");
	        currAffnDeptCd.setValue(""); 
	        currAffnDeptNm.setValue("");
	    }  
	   
	 
//		typOccuCd.setValue(new BaseModel());
//		dtilOccuInttnCd.setValue(new BaseModel());
		
		repbtyBusinNm.setValue("");					//담당업무명
		odtyCd.setValue(new BaseModel());			//직책
		
		emymtDivCd.setValue(new BaseModel());
		hdofcCodtnCd.setValue(new BaseModel());
		
		resnRegnNum.setValue("");
		hanNm.setValue("");		
		chinCharNm.setValue("");
		engNm.setValue("");
		currPaeWorkNm.setValue("");
		//businCd.setValue(new BaseModel());
		businNm.setValue("");
		frstEmymtDt.reset();
		emymtEndDt.reset();
		logSvcYrNum.setValue("");
		
		currDeptAppmtDt.reset();
		retryReasCtnt.setValue("");
		pernNoteCtnt.setValue("");
		picFile.setValue("");
		picImg.setUrl(GWT.getHostPageBaseURL()+MSFMainApp.getMsg("PayGen.NonExTermPhoto"));
		natnNm.setValue(""); 					//국가명
		natnItem.setValue("");					//국가코드 두자리
	}
	
	//인적 탭 초기화
	public void resetPsnl0111Form(){
		psnl0111HusRoadNmZpcd.setValue("");				//도로명 주소 우편번호
		psnl0111HusRoadNmFndtnAddr.setValue("");		//도로명 기본주소
		psnl0111HusRoadNmDtlPatrAddr.setValue(""); 		//도로명 상세 주소
		psnl0111BthcAddr.setValue("");					//생활 근거지 주소
		psnl0111HfmlyNm.setValue(""); 					//호주
		psnl0111HfmlyRelaCd.setValue(null); 			//호주관계
		psnl0111CellPhneNum.setValue(""); 				//휴대폰번호
		psnl0111HusPhnNum.setValue(""); 				//전화번호
		psnl0111EmailAddr.setValue(""); 				//이메일
		styBgnnDt.reset();								//체류기간(시작)
		styEndDt.reset();								//체류기간(종료)
		frgnrDivCd.setValue(new BaseModel());			//외국인구분
		pernNoteCtnt.setValue(""); 						//비고 초기화
	}
	
	//병역 탭 초기화
  public void resetPsnl0112Form(){
      
    //병역 시작
      psnl0112EnrlntDt.reset();							//입대일자
      psnl0112DsageDt.reset();							//제대일자
      psnl0112ServcRcgtnPridCd.setValue(new BaseModel());	//복무인정기간
      psnl0112SrvssCd.setValue(new BaseModel());			//역종
      psnl0112BaggrpCd.setValue(new BaseModel());			//군별
      psnl0112AbotsCd.setValue(new BaseModel());			//병과
      psnl0112ClsCd.setValue(new BaseModel());			//계급
      psnl0112MitySilnum.setValue("");					//군번
      psnl0112Mos.setValue("");							//mos
      psnl0112DsageDivCd.setValue(new BaseModel());		//제대구분
      psnl0112ExmtnReasCd.setValue(new BaseModel());		//미필사유
      //병역 끝
      
  }
  
  //신상 탭 초기화
public void resetPsnl0113Form(){
   //신상 시작
   psnl0113Sttur.setValue("");//신장
   psnl0113Wei.setValue("");//체중
   psnl0113BldtpDivCd.setValue(new BaseModel());//혈액형 콤보 
   psnl0113TnkeeVsnLf.setValue("");//나안시력 좌
   psnl0113TnkeeVsnRght.setValue("");//나인시력 우
   psnl0113CorrVsnLf.setValue("");//교정시력 좌
   psnl0113CorrVsnRght.setValue("");//교정시력 우
   psnl0113RelnFrmCd.setValue(new BaseModel());//종교 콤보
   psnl0113HbbyCtnt.setValue("");//취미
   psnl0113SpityCtnt.setValue("");//특기
   psnl0113HlthCodtnCtnt.setValue("");//건강상태
   psnl0113DabtyDivCd.setValue(new BaseModel());//장애구분
   psnl0113DabtyGrdeCd.setValue(new BaseModel());//장애등급
   psnl0113DabtyAjmtDt.reset();//장애판정일자
   psnl0113PattVetnsDivCd.setValue(new BaseModel());//보훈구분
   psnl0113PattVetnsNum.setValue("");//보훈번호
   psnl0113AmomRelaDivCd.setValue(new BaseModel());//유공자와관계 
   //신상 끝
	}
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 화면 초기화 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/

	 private void getStrYoobhMnthDay(String strResnRegnNum) {
	 	
		 
		 String strResnYoobhMnth = "";
		 if("1".equals(strResnRegnNum.substring(7,8)) || "2".equals(strResnRegnNum.substring(7,8))) {
			 strResnYoobhMnth = strResnRegnNum.substring(0, 6);
			 strYoobhMnthDay = "19" + strResnYoobhMnth;
	     }else if("3".equals(strResnRegnNum.substring(7,8)) || "4".equals(strResnRegnNum.substring(7,8))) {
	    	 strResnYoobhMnth = strResnRegnNum.substring(0, 6);
	    	 strYoobhMnthDay = "20" + strResnYoobhMnth;
	     }else {
	    	 MessageBox.alert("", "생년월일을 가져올 수 없습니다.", null);  
	     }
	}

	// 주민번호 체크 루틴 추가  시작 ---------------------------------------------------------
	private boolean checkJumin(String strJuminNum) {
	    	
//	    	int key = 11;		//키값 11
//	    	int checkSum = 0;	//가중치 곱하여 합산한 값
//	    	int reg = strJuminNum.charAt(strJuminNum.length() - 1) - 48;	//주민번호 마지막 값
//	    	
//	    	int checkReg = 0;	//체크할 값
//	    	
//	    	int[] weight = {2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5};			//가중치 배열
//	    	
//	    	
//	    	//가중치와 곱해서 합산
//	    	for( int i = 0 ; i < weight.length ; i++){
//	    		checkSum += (strJuminNum.charAt(i) - 48) * weight[i];
//	    	}
//	    	
//	    	checkReg = key - (checkSum%key);
//	    	
//	    	if(checkReg == 10){
//	 		   checkReg = 0; 		// 검사값이 10으로 나오면 0으로 반환
//	 	   	}
//	 	   	if (checkReg == reg){
//	 	   		return true;
//	 	   		
//	 	   	}else if(strJuminNum.length() != 13) {
//	 	   		MessageBox.alert("", "주민등록번호를 확인해주세요.", null); 
//	 	   		return false;
//	 	   	}else {
//	 	   		MessageBox.alert("", "주민등록번호를 확인해주세요.", null); 
//	 	   		return true;
//	 	   	}
	    	
		/** 2016.01.10 주민번호 체크 루틴 변경 **/
		String strJumin = strJuminNum.replace("-", "");
		int[] checkBit = {2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5};
	    int num7  = strJumin.charAt(6)  - 48;
	    int num13 = strJumin.charAt(12)  - 48;
	    int total = 0;
	    	 
	    if (strJumin.length() == 13 ) {
	    	for (int i=0; i<checkBit.length; i++) { // 주민번호 12자리를 키값을 곱하여 합산한다.
	    		total += strJumin.charAt(i)*checkBit[i];
	    	}
	    		 
	    	// 외국인 구분 체크
	    	//내국인 ( 1800년대 9: 남자, 0:여자)
	    	if (num7 == 0 || num7 == 9) { 
	    		total = (11-(total%11)) % 10;
	    			 
	    	//외국인 ( 1900년대 5:남자 6:여자  2000년대 7:남자, 8:여자)	 
	    	}else if (num7 > 4) {  
	    		total = ( 13 - (total%11) ) % 10;
	    		
	    	//내국인 ( 1900년대 1:남자 2:여자  2000년대 3:남자, 4:여자)
	    	}else {
	    		total = ( 11 - ( total%11 ) ) % 10;
	    	}
	    	 
//	    		 if(total != num13) {
//	    			 MessageBox.alert("", "주민등록번호를 확인해주세요.", null); 
//	    			 return true;
//	    		 }
	    		 
	    	return true;
		} else{
			MessageBox.alert("", "주민등록번호를 확인해주세요.", null); 
			return false;
		}
	}
	// 주민번호 체크 루틴 추가  종료 ---------------------------------------------------------
	
	
  /** 근로자 고용 전환 **/
  private void psnl0100Status(final Psnl0100DTO dto) {
  	
//  	iResult = 0;	// 0 : 실패 1: 성공 2 : 전환작업 안함
		//TODO 고용 저장시 고용구분 전환할 수 있도록 추가.
		/**************************************************************************************/
		//고용구분이 '기간제근로자' 일 경우 무기->기간제로 전환할지 여부를 물어서 전환할 수 있도록 한다.
  	//2016.05.27 데이터 건 수 상관없이 고용구분 변경 시 전환 여부 확인 후 처리.
		if("A0020010".equals(dto.getEmymtDivCdFlag())) {
//		if((totalLength ==  1) && "A0020010".equals(dto.getEmymtDivCdFlag())) {
			
			MessageBox.confirm("공무직 근로자 선택!", "기존 정보로 공무직근로자(으)로 전환하시겠습니까?", new Listener<MessageBoxEvent>(){
				@Override
				public void handleEvent(MessageBoxEvent be) {
				//	if("Yes".equals(be.getButtonClicked().getText())){
					if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
						
						searchName.setValue("");
						//cmbxNewCombobox.setValue(new BaseModel());
						searchMangeDeptCd.setValue("");
						searchMangeDeptNm.setValue("");
						searchResnRegnNum.setValue(dto.getResnRegnNum());
						//cmbxNewCombobox_3.setValue(new BaseModel());
						srhCurrAffnDeptCd.setValue("");
                      srhCurrAffnDeptNm.setValue("");
//						cmbxSchHdofcCodtnCd.setValue(new BaseModel());
						srhHdofcCodtnCd.setValue("");
						searchYearBusinCd.setValue(new BaseModel());
						
						//기간제 근로자로 전환시 고용구분을 공무직 코드로 넣는다. impl에서 무기->기간제로 전환함.
						dto.setEmymtDivCd("A0020020");
						
						psnl0100Service.updatePsnl0100Status(dto, new AsyncCallback<Integer>() {
								@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub
//									iResult = 0;
								MessageBox.info("", "전환 실패", null);
								
							}
								@Override
							public void onSuccess(Integer result) {
								// TODO Auto-generated method stub
								if(result == 1) {
//									iResult = 1;
									MessageBox.info("", "전환 성공 ", null);
									loaderPaging.load();
								}else {
//									iResult = 0;
									MessageBox.info("", "전환 실패", null);
//										return;
								}
							}
						});
						//loaderPaging.load();
					}
				}
			});
		}else if("A0030020".equals(dto.getHdofcCodtnCd()) && "A0020010".equals(dto.getEmymtDivCd())) {
			//퇴직자이면서 공무직인 데이터가 있을 경우 공무직으로 전환할 것인지 체크하여 등록한다.
			MessageBox.confirm(null, "퇴직한 공무직근로자 정보가 존재! <br> 기존 정보로 기간제근로자(으)로  <br>  전환하시겠습니까?", new Listener<MessageBoxEvent>(){
				@Override
				public void handleEvent(MessageBoxEvent be) {
				//	if("Yes".equals(be.getButtonClicked().getText())){
					if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
						
						searchName.setValue("");
						//cmbxNewCombobox.setValue(new BaseModel());
						searchMangeDeptCd.setValue("");
						searchMangeDeptNm.setValue("");
						searchResnRegnNum.setValue(dto.getResnRegnNum());
						//cmbxNewCombobox_3.setValue(new BaseModel());
						srhCurrAffnDeptCd.setValue("");
                      srhCurrAffnDeptNm.setValue("");
//						cmbxSchHdofcCodtnCd.setValue(new BaseModel());
						srhHdofcCodtnCd.setValue("");
						searchYearBusinCd.setValue(new BaseModel());
					
						psnl0100Service.updatePsnl0100Status(dto, new AsyncCallback<Integer>() {

							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub
								MessageBox.info("", "전환 실패", null);
							}

							@Override
							public void onSuccess(Integer result) {
								// TODO Auto-generated method stub
								if(result == 1) {
									MessageBox.info("", "전환 성공", null);
//									iResult = 1;
								}else {
									MessageBox.info("", "전환 실패", null);
								}
							}
						});
//						loaderPaging.load();
					}
				}
			});			
		}else {
			
//			iResult = 2;
		}
		/**************************************************************************************/
//		return iResult;
  }
  
  /**
   * ~~~~~~~~~~~~~~~~~ 탭 저장 메소드 구현 시작 ~~~~~~~~~~~~~~~~~ 
   */
  /** 고용 저장 **/
  private void savePsnl0110() {
  	
	    boolean checkRow = false;
	    
		//변경된 데이터 담기
		ArrayList<Psnl0110DTO>changePsnl0110List = new ArrayList<Psnl0110DTO>();
		for ( int i = 0; i < psnl0110Store.getCount(); i++){ //고용 그리드에 연결된 STORE
			if(psnl0110Store.getRecord(psnl0110Store.getAt(i)).isDirty()){ //변경된 정보가 있을경우
				psnl0110Store.getAt(i).setDpobCd(psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
				psnl0110Store.getAt(i).setSystemkey(psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
				
				//고용구분이 기간제 근로자일 경우만 null체크
				if("A0020020".equals(psnl0110Grid.getSelectionModel().getSelectedItem().getEmymtDivCd())) {
					
					// 고용 저장시 필수 입력사항 누락 방어 로직 부분
					if(MSFSharedUtils.paramNull(psnl0110Grid.getSelectionModel().getSelectedItem().getEmymtDivCd())) {
						MessageBox.alert("", "고용구분을 선택하여주세요.", null);
						return;
					}else if(MSFSharedUtils.paramNull(psnl0110Grid.getSelectionModel().getSelectedItem().getEmymtTypCd())) {
						MessageBox.alert("", "고용유형을 선택하여주세요.", null);
						return;
					}else if(MSFSharedUtils.paramNull(psnl0110Grid.getSelectionModel().getSelectedItem().getEmymtBgnnDt())) {
						MessageBox.alert("", "시작일자를 선택하여주세요.", null);
						return;
					}else if(MSFSharedUtils.paramNull(psnl0110Grid.getSelectionModel().getSelectedItem().getEmymtEndDt())) {
						// 휴직, 퇴직, 복직일 경우를 제외하고는 종료일자를 입력하도록 한다.
						if("A0420040".equals(psnl0110Grid.getSelectionModel().getSelectedItem().getEmymtTypCd())		// 휴직
							|| "A0420990".equals(psnl0110Grid.getSelectionModel().getSelectedItem().getEmymtTypCd())	// 퇴직
							|| "A0420070".equals(psnl0110Grid.getSelectionModel().getSelectedItem().getEmymtTypCd())) {	// 복직
						
						}else {
							MessageBox.alert("", "종료일자를 선택하여주세요.", null);
							return;
						}
					}else if(MSFSharedUtils.paramNull(psnl0110Grid.getSelectionModel().getSelectedItem().getDeptCd())) {
						MessageBox.alert("", "부서를 선택하여주세요.", null);
						return;
					}else if(MSFSharedUtils.paramNull(psnl0110Grid.getSelectionModel().getSelectedItem().getBusinCd())) {
						MessageBox.alert("", "사업을 선택하여주세요.", null);
						return;
					}
					
				}
				
//				// 회계연도 기준으로 당해연도까지만 입력할 수 있도록 방어 로직 구현 - 삭제 처리 데이터는 제외
//				if(!psnl0110Grid.getSelectionModel().getSelectedItem().getDelChk()) {
//					
//					// 휴직, 퇴직, 복직일 경우를 제외하고는 시작일자와, 종료일자 값에 대해서 체크한다.
//					if(!"A0420040".equals(psnl0110Grid.getSelectionModel().getSelectedItem().getEmymtTypCd())		// 휴직
//						|| !"A0420990".equals(psnl0110Grid.getSelectionModel().getSelectedItem().getEmymtTypCd())	// 퇴직
//						|| !"A0420070".equals(psnl0110Grid.getSelectionModel().getSelectedItem().getEmymtTypCd())) {	// 복직
//						
//						int yearNow = Integer.parseInt(DateTimeFormat.getFormat("yyyy").format(new Date()));	// 현재 년도
//						int yearBgnnDt = Integer.parseInt(DateTimeFormat.getFormat("yyyy")
//								.format(psnl0110Grid.getSelectionModel().getSelectedItem().getEmymtBgnnDt()));	// 시작 년도
//						int yearEngDt =  Integer.parseInt(DateTimeFormat.getFormat("yyyy")
//								.format(psnl0110Grid.getSelectionModel().getSelectedItem().getEmymtEndDt()));	// 종료 년도
//						// 입력한 년도가 당해연도보다 클 경우
//						if(yearNow < yearBgnnDt || yearNow < yearEngDt) {
//							MessageBox.alert("", "회계연도 기준으로 당해연도까지만 입력 가능합니다.", null);
//							return;
//						// 시작년도와 종료년도가 다를 경우	
//						}else 
//						if(yearBgnnDt != yearEngDt) {
//							MessageBox.alert("", "회계연도 단위로 입력가능합니다. 시작일자, 종료일자의 년도를 맞춰주세요.", null);
//							return;
//						}
//					
//					}
//					
//				}
				
				changePsnl0110List.add(psnl0110Store.getAt(i));
				checkRow = true;
			}
		}
		
		if (!checkRow) {
		    MessageBox.info("저장", "저장할 고용 정보가 없습니다.", null); 
		    return;
		}
		
		//저장시작
		psnl0110Service.savePsnl0110(changePsnl0110List, new AsyncCallback<String>(){
			@Override
			public void onFailure(Throwable caught) {
				
//				MessageBox.info("저장실패", "고용 정보 저장이 실패 하였습니다. \n" + caught.getMessage(), null);
				MessageBox.info("저장실패", "고용 정보 저장이 실패 하였습니다. 관리자에게 문의해주세요. </br>" + caught.getMessage(), null);
				
			}

			@Override
			public void onSuccess(String result) {
				
				String[] arrResult = result.split(";");
				
				
				String strPayrDeptCd = "";
				String strReturn = "";
				
				
				if(arrResult.length == 1) {
					strReturn = arrResult[0];
					
				}else {
					
					for(int i = 0; i < arrResult.length; i ++) {
						
						
						if(i == arrResult.length -1) {
							strPayrDeptCd = arrResult[i];
						}else {
							strReturn = arrResult[i];
						}
					}
				}
				
				final String strReust = strReturn;
				
//				MessageBox.info("저장완료", "고용 정보("+result+")가 저장되었습니다.", null);
				
				//dtilOccuInttnCdCombo.setStore(listStoreBass0350);
				
				
				// 고용 저장시 master 업데이트를 위해..
				final Psnl0100DTO dto = new Psnl0100DTO();
				
				dto.setDpobCd(psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());			//사업장
				dto.setSystemkey(psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());	//시스템키
				dto.setEmymtDivCd(psnl0110Grid.getSelectionModel().getSelectedItem().getEmymtDivCd());	//고용구분
				dto.setEmymtTypCd(psnl0110Grid.getSelectionModel().getSelectedItem().getEmymtTypCd());	//고용유형
				dto.setCurrAffnDeptCd(psnl0110Grid.getSelectionModel().getSelectedItem().getDeptCd());	//부서
				dto.setOdtyCd(psnl0110Grid.getSelectionModel().getSelectedItem().getOdtyCd());			//직책
				dto.setBusinCd(psnl0110Grid.getSelectionModel().getSelectedItem().getBusinCd());		//사업
				dto.setEmymtDivCdFlag(psnl0110Grid.getSelectionModel().getSelectedItem().getEmymtDivCd());
				dto.setEmymtBgnnDt(GWTUtils.getStringFromDate(psnl0110Grid.getSelectionModel().getSelectedItem().getEmymtBgnnDt(), "yyyyMMdd"));
//				dto.setCurrPaeWorkNm(psnl0110Grid.getSelectionModel().getSelectedItem().getCurrPaeWorkNm());//현근무지
//				dto.setAutoLoadFlag(autoLoadFlag);
				
//				 PrgmComBass0500DTO sys0500dto = new PrgmComBass0500DTO();
//				 String businApptnYr = psnl0110Grid.getSelectionModel().getSelectedItem().getEmymtBgnnDt() == null ? "" 
//		                    : GWTUtils.getStringFromDate(psnl0110Grid.getSelectionModel().getSelectedItem().getEmymtBgnnDt(), "yyyyMMdd").substring(0, 4);
//				 sys0500dto.setBusinApptnYr(businApptnYr);  //DateTimeFormat.getFormat("yyyy").format(new Date())
//				 sys0500dto.setDeptCd(psnl0110Grid.getSelectionModel().getSelectedItem().getDeptCd()); 
//				
//				listStoreYearBusin = PrgmComComboUtils.getDeptWithBass0500ComboData(sys0500dto);
//				businCdCombo.setStore(listStoreYearBusin);
				 
				psnl0110Loader.load();
				
				//TODO 고용데이터가 전부 삭제해서 0건일 경우 마스터 업데이트시 데이터 구분하여 저장.
					psnl0110Loader.addLoadListener(new LoadListener(){
						@Override
						public void loaderLoad(LoadEvent le) {
							// TODO Auto-generated method stub
							super.loaderLoad(le);
							
							
							try{
								BaseListLoadResult<ModelData> data = le.getData();
								totalLength = data.getData().size();
//								int totalLength = data.getTotalLength();
								
								autoLoadFlag = new String();
								
								if(totalLength <= 0) {
									autoLoadFlag = "true";
								}else {
									autoLoadFlag = "false";
								}
								
								dto.setAutoLoadFlag(autoLoadFlag);
								dto.setWindowNm("PSNL0100");
								psnl0100Service.updateProcPsnl0100Return(dto, new AsyncCallback<Psnl0100DTO>() {
									@Override
									public void onSuccess(Psnl0100DTO result) {
										
										// 2014.08.25 고용 업데이트 후 그리드 데이터도 업데이트 처리
										psnl0100Grid.getStore().update(result);
										
										//TODO 저장
										//PersonalUtil.setSelectedComboValue(deptCd, result.getDeptCd(),"mangeDeptCd"); //기본사항 관리부서
                                      //deptCd.fireEvent(Events.Change, new BaseEvent(result));
                                      mangeDeptCd.setValue( result.getDeptCd());
                                      mangeDeptNm.setValue(result.getDeptNm());  
                                      //PersonalUtil.setSelectedComboValue(currAffnDeptCd, result.getCurrAffnDeptCd(),"deptCd"); //기본사항 부서
                                      currAffnDeptCd.setValue( result.getCurrAffnDeptCd());
                                      currAffnDeptNm.setValue(result.getCurrAffnDeptNm()); 
//										PersonalUtil.setSelectedComboValue(typOccuCd, result.getTypOccuCd()); //직종
//										typOccuCd.fireEvent(Events.Change, new BaseEvent(result));
//										PersonalUtil.setSelectedComboValue(tempComboBox, result.getDtilOccuInttnCd(), "dtilOccuInttnCd"); //직종세
										PersonalUtil.setSelectedComboValue(emymtDivCd, result.getEmymtDivCd()); //고용구분코드
										PersonalUtil.setSelectedComboValue(hdofcCodtnCd, result.getHdofcCodtnCd()); //재직구분
										resnRegnNum.setValue(result.getResnRegnNum());	//주민등록번호
										hanNm.setValue(result.getHanNm());	//한글이름
										chinCharNm.setValue(result.getChinCharNm());	//한자이름
										currPaeWorkNm.setValue(result.getCurrPaeWorkNm());	//현근무지
										
										
										DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyyMMdd");
										if(result.getFrstEmymtDt() != null && result.getFrstEmymtDt().length() == 8){
											frstEmymtDt.setValue(dateTimeFormat.parse(result.getFrstEmymtDt()));
										}else{
											frstEmymtDt.reset();
										}
										
										if(result.getEmymtEndDt() != null && result.getEmymtEndDt().length() == 8){
											emymtEndDt.setValue(dateTimeFormat.parse(result.getEmymtEndDt()));
										}else{
											emymtEndDt.reset();
										}
										
										logSvcYrNum.setValue(result.getWorkym());
										engNm.setValue(result.getEngNm());
										
										if(result.getEmymtBgnnDt() != null && result.getEmymtBgnnDt().length() == 8){
											currDeptAppmtDt.setValue(dateTimeFormat.parse(result.getEmymtBgnnDt()));
										}else{
											currDeptAppmtDt.reset();
										}
										
										retryReasCtnt.setValue(result.getRetryReasCtnt());
										
										businNm.setValue(result.getBusinNm());
										
//										MessageBox.info("저장완료", "고용 정보("+strReust+")가 저장되었습니다.", null);
										// 고용데이터 신규 입력시 고용구분에 따른 전환작업
										MessageBox.info("저장완료", "고용 정보("+strReust+")가 저장되었습니다.", new Listener<MessageBoxEvent>(){
											@Override
											public void handleEvent( MessageBoxEvent be) {
												
												
												// TODO Auto-generated method stub
												//if("OK".equals(be.getButtonClicked().getText())) {
												if(Dialog.OK.equals(be.getButtonClicked().getItemId())){
													// 고용구분 전환 메소드 호출
													psnl0100Status(dto);
												}
											}
										});
										
										//기본값으로 초기화
										autoLoadFlag = "false";
										
										//마스터 업데이트 후 조회
										loaderPaging.load();
									}
									@Override
									public void onFailure(Throwable caught) {
									}
								});
								
							}catch(Exception e){
								e.printStackTrace();
							}
							//TODO 리스너 제거
							psnl0110Loader.removeLoadListener(this);
						}
					});
				}
		});    	
  }
  
  /** 가족 저장 **/
  private void savePsnl0115() {
  	
		ArrayList<Psnl0115DTO>changePsnl0115List = new ArrayList<Psnl0115DTO>();
		
		for ( int i = 0; i < psnl0115Store.getCount(); i++){
			if(psnl0115Store.getRecord(psnl0115Store.getAt(i)).isDirty()){ //변경된 로우가 있을경우
				psnl0115Store.getAt(i).setDpobCd(psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
				psnl0115Store.getAt(i).setSystemkey(psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
				psnl0115Store.getAt(i).setFrgnrYn(MSFSharedUtils.defaultNulls(psnl0115Store.getAt(i).getFrgnrYn(),"N"));
				changePsnl0115List.add(psnl0115Store.getAt(i));
			}
		}
		//저장 시작
		psnl0115Service.savePsnl0115(changePsnl0115List, new AsyncCallback<String>(){

			@Override
			public void onFailure(Throwable caught) {
				
				MessageBox.info("저장실패", "가족 정보 저장이 실패 하였습니다.\n" + caught.getMessage(), null);
			}

			@Override
			public void onSuccess(String result) {
				
				MessageBox.info("저장완료", "가족 정보("+result+")가 저장되었습니다.", null);
				psnl0115Loader.load();
			}
		});
  }
  
  /** 학력 저장 **/
  private void savePsnl0116() {
  	
		ArrayList<Psnl0116DTO>changePsnl0116List = new ArrayList<Psnl0116DTO>();
		
		for ( int i = 0; i < psnl0116Store.getCount(); i++){
			if(psnl0116Store.getRecord(psnl0116Store.getAt(i)).isDirty()){ //변경된 로우가 있을경우
				psnl0116Store.getAt(i).setDpobCd(psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
				psnl0116Store.getAt(i).setSystemkey(psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
				changePsnl0116List.add(psnl0116Store.getAt(i));
			}
		}
		//저장 시작
		psnl0116Service.savePsnl0116(changePsnl0116List, new AsyncCallback<String>(){

			@Override
			public void onFailure(Throwable caught) {
				
				MessageBox.info("저장실패", "학력 정보 저장이 실패 하였습니다.\n" + caught.getMessage(), null);
			}

			@Override
			public void onSuccess(String result) {
				
				MessageBox.info("저장완료", "학력 정보("+result+")가 저장되었습니다.", null);
				psnl0116Loader.load();
				
				Psnl0100DTO dto = new Psnl0100DTO();
				dto.setDpobCd(psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
				dto.setSystemkey(psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
				dto.setWindowNm("PSNL0200");
				psnl0100Service.updateProcPsnl0100(dto, new AsyncCallback<String>() {
					@Override
					public void onSuccess(String result) {}
					@Override
					public void onFailure(Throwable caught) {}
				});
			}
		});
  }
  
  /** 자격 저장 **/
  private void savePsnl0118() {
		//변경된 데이터 담기
		ArrayList<Psnl0118DTO>changePsnl0118List = new ArrayList<Psnl0118DTO>();
		for ( int i = 0; i < psnl0118Store.getCount(); i++){
			if(psnl0118Store.getRecord(psnl0118Store.getAt(i)).isDirty()){ //변경된 로우가 있을경우
				psnl0118Store.getAt(i).setDpobCd(psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
				psnl0118Store.getAt(i).setSystemkey(psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
				changePsnl0118List.add(psnl0118Store.getAt(i));
			}
		}
		//저장 시작
		psnl0118Service.savePsnl0118(changePsnl0118List, new AsyncCallback<String>(){

			@Override
			public void onFailure(Throwable caught) {
				MessageBox.info("저장실패", "자격 정보 저장이 실패 하였습니다. \n" + caught.getMessage(), null);
			}

			@Override
			public void onSuccess(String result) {
				MessageBox.info("저장완료", "자격 정보("+result+")가 저장되었습니다.", null);
				psnl0118Loader.load();
			}
		});
  }
  
  /** 경력 저장 **/
  private void savePsnl0119() {
  	
		ArrayList<Psnl0119DTO>changePsnl0119List = new ArrayList<Psnl0119DTO>();
		
		for ( int i = 0; i < psnl0119Store.getCount(); i++){
			if(psnl0119Store.getRecord(psnl0119Store.getAt(i)).isDirty()){ //변경된 로우가 있을경우
				psnl0119Store.getAt(i).setDpobCd(psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
				psnl0119Store.getAt(i).setSystemkey(psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
				changePsnl0119List.add(psnl0119Store.getAt(i));
			}
		}
		//저장 시작
		psnl0119Service.savePsnl0119(changePsnl0119List, new AsyncCallback<String>(){

			@Override
			public void onFailure(Throwable caught) {
				
				MessageBox.info("저장실패", "경력 정보 저장이 실패 하였습니다. \n" + caught.getMessage(), null);
			}

			@Override
			public void onSuccess(String result) {
				
				MessageBox.info("저장완료", "경력 정보("+result+")가 저장되었습니다.", null);
				psnl0119Loader.load();
			}
		});
  }
  /** 교육 저장 **/
  private void savePsnl0120() {
  	
		ArrayList<Psnl0120DTO>changePsnl0120List = new ArrayList<Psnl0120DTO>();
		
		for ( int i = 0; i < psnl0120Store.getCount(); i++){
			if(psnl0120Store.getRecord(psnl0120Store.getAt(i)).isDirty()){ //변경된 로우가 있을경우
				psnl0120Store.getAt(i).setDpobCd(psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
				psnl0120Store.getAt(i).setSystemkey(psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
				changePsnl0120List.add(psnl0120Store.getAt(i));
			}
		}
		//저장 시작
		psnl0120Service.savePsnl0120(changePsnl0120List, new AsyncCallback<String>(){

			@Override
			public void onFailure(Throwable caught) {
				MessageBox.info("저장실패", "교육 정보 저장이 실패 하였습니다. \n" + caught.getMessage(), null);
			}

			@Override
			public void onSuccess(String result) {
				MessageBox.info("저장완료", "교육 정보("+result+")가 저장되었습니다.", null);
				psnl0120Loader.load();
			}
		});
  }
  
  
  /** 포장 저장 **/
  private void savePsnl0121() {
  	
		ArrayList<Psnl0121DTO>changePsnl0121List = new ArrayList<Psnl0121DTO>();
		
		for ( int i = 0; i < psnl0121Store.getCount(); i++){
			if(psnl0121Store.getRecord(psnl0121Store.getAt(i)).isDirty()){ //변경된 로우가 있을경우
				psnl0121Store.getAt(i).setDpobCd(psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
				psnl0121Store.getAt(i).setSystemkey(psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
				changePsnl0121List.add(psnl0121Store.getAt(i));
			}
		}
		//저장 시작
		psnl0121Service.savePsnl0121(changePsnl0121List, new AsyncCallback<String>(){

			@Override
			public void onFailure(Throwable caught) {
				MessageBox.info("저장실패", "포상 정보 저장이 실패 하였습니다.\n" + caught.getMessage(), null);
			}

			@Override
			public void onSuccess(String result) {
				
				MessageBox.info("저장완료", "포상 정보("+result+")가 저장되었습니다.", null);
				psnl0121Loader.load();
			}
		});
  }
  
  /** 징계 저장 **/
  private void savePsnl0122() {
		ArrayList<Psnl0122DTO>changePsnl0122List = new ArrayList<Psnl0122DTO>();
		for ( int i = 0; i < psnl0122Store.getCount(); i++){
			if(psnl0122Store.getRecord(psnl0122Store.getAt(i)).isDirty()){ //변경된 로우가 있을경우
				psnl0122Store.getAt(i).setDpobCd(psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
				psnl0122Store.getAt(i).setSystemkey(psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
				changePsnl0122List.add(psnl0122Store.getAt(i));
			}
		}
		//저장 시작
		psnl0122Service.savePsnl0122(changePsnl0122List, new AsyncCallback<String>(){

			@Override
			public void onFailure(Throwable caught) {
				MessageBox.info("저장실패", "징계 정보 저장이 실패 하였습니다.\n" + caught.getMessage(), null);
			}

			@Override
			public void onSuccess(String result) {
				MessageBox.info("저장완료", "징계 정보("+result+")가 저장되었습니다.", null);
				psnl0122Loader.load();
			}
		});
  	
  }
  
  /** 근무상황 저장 **/
  private void savePsnl0133() {
		ArrayList<Psnl0133DTO>changePsnl0133List = new ArrayList<Psnl0133DTO>();
		for ( int i = 0; i < psnl0133Store.getCount(); i++){
			if(psnl0133Store.getRecord(psnl0133Store.getAt(i)).isDirty()){ //변경된 로우가 있을경우
				psnl0133Store.getAt(i).setDpobCd(psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
				psnl0133Store.getAt(i).setSystemkey(psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
				changePsnl0133List.add(psnl0133Store.getAt(i));
			}
		}
		//저장 시작
		psnl0133Service.savePsnl0133(changePsnl0133List, new AsyncCallback<String>(){

			@Override
			public void onFailure(Throwable caught) {
				MessageBox.info("저장실패", "근무상황 정보 저장이 실패 하였습니다.\n" + caught.getMessage(), null);
			}

			@Override
			public void onSuccess(String result) {
				MessageBox.info("저장완료", "근무상황 정보("+result+")가 저장되었습니다.", null);
				psnl0133Loader.load();
			}
		});
  	
  }
  

  
  /**
   * ~~~~~~~~~~~~~~~~~ 탭 저장 메소드 구현 종료 ~~~~~~~~~~~~~~~~~ 
   */
  
  
  /***
   * 숫자, 문자 판단
   * **/
  private Boolean typeCheck(String data) {
  	
  	String strData = data;
  	Boolean boolRtn = true;
  	
  	for(int i=0; i < strData.length(); i++) {
  		char c = strData.charAt(i);
  		
  		if(c < 48 || c > 57) {	//숫자가 아닌 경우
  			boolRtn = false;
  			break;
  		}else {
  			boolRtn = true;
  		}
  	}
  	
  	return boolRtn;
  }
	    
	    
	private void onMyThing(LoadEvent event) {
//	    /* do your thing */
//	    reg.removeHandler();
//	  }
	 };    
	    
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
					psnl0111HusRoadNmZpcd.setValue(MSFSharedUtils.allowNulls(mapModel.get("zpcd")));
					psnl0111HusRoadNmFndtnAddr.setValue(MSFSharedUtils.allowNulls(mapModel.get("fnDtnAddr"))); // 앞주소
					psnl0111HusRoadNmDtlPatrAddr.setValue(MSFSharedUtils.allowNulls(mapModel.get("dtlPatrAddr"))); // 뒷주소
				}
			}
		});
	}
	//관리부서 
	private void fnPopupCommP145_Mange(String deptCd) {
		//검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
		//넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
		//검색.처리하면됨.
	       
		MSFFormPanel popCom0145 = PrgmComPopupUtils.lovPopUpPrgmCom0145Form(deptCd,"Y");  //부서
	       
		final FormBinding popBindingCom0145 = popCom0145.getFormBinding();
	      
		popBindingCom0145.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				BaseModel mapModel = (BaseModel)be.getSource();
				if (!"".equals(mapModel.get("mangeDeptCd"))) { 
	                if("".equals(srhCurrAffnDeptCd.getValue()) || "".equals(srhCurrAffnDeptNm.getValue())
                  		|| srhCurrAffnDeptCd.getValue() == null || srhCurrAffnDeptNm.getValue() == null) {
	                	searchMangeDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
	                	searchMangeDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt"))); 
	                	srhCurrAffnDeptCd.setValue("");
	                	srhCurrAffnDeptNm.setValue(""); 
              	}else {
              		searchMangeDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
              		searchMangeDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt"))); 
              	}
				} 
			}
		});
	}
	
	//소속부서 
	private void fnPopupCommP140_Curr(String deptCd) {
		//검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
		//넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
		//검색.처리하면됨.
	       
		MSFFormPanel popCom0140 = PrgmComPopupUtils.lovPopUpPrgmCom0140Form(deptCd);  //부서
	       
		final FormBinding popBindingCom0140 = popCom0140.getFormBinding();
	      
		popBindingCom0140.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				BaseModel mapModel = (BaseModel)be.getSource();
				if (!"".equals(mapModel.get("mangeDeptCd"))) { 
	                if("".equals(searchMangeDeptCd.getValue()) || "".equals(searchMangeDeptNm.getValue())
							|| searchMangeDeptCd.getValue() == null || searchMangeDeptNm.getValue() == null) {
	                	searchMangeDeptCd.setValue("");
						searchMangeDeptNm.setValue(""); 
						srhCurrAffnDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
						srhCurrAffnDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt"))); 
                      
                  }else {
                  	srhCurrAffnDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
                  	srhCurrAffnDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt"))); 
                  }
	                
	                srhCurrAffnDeptCd.fireEvent(Events.Add);
				} 
			}
		});
	}	 	
	
	
//	//관리부서 
//  private void fnPopupCommP140(String deptCd) {
//      //검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
//      //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
//      //검색.처리하면됨.
//      
//      MSFFormPanel popCom0140 = PrgmComPopupUtils.lovPopUpPrgmCom0140Form(deptCd);  //부서
//      
//      final FormBinding popBindingCom0140 = popCom0140.getFormBinding();
//     
//      popBindingCom0140.addListener(Events.Change, new Listener<BaseEvent>() {
//          public void handleEvent(BaseEvent be) {
//              BaseModel mapModel = (BaseModel)be.getSource();
//              if (!"".equals(mapModel.get("mangeDeptCd"))) { 
//              	
//              	if("".equals(mangeDeptCd.getValue()) || "".equals(mangeDeptNm.getValue())) {
//             		 	mangeDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
//                      mangeDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt"))); 
//              	}
//              	
//              	if("".equals(currAffnDeptCd.getValue()) || "".equals(currAffnDeptNm.getValue())) {
//              		currAffnDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
//                      currAffnDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt"))); 
//              	}
//                   
////                  searchMangeDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeDeptCd")));
////                  searchMangeDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeDeptNm")));  
////                  srhCurrAffnDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
////                  srhCurrAffnDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt"))); 
//                  srhCurrAffnDeptCd.fireEvent(Events.Add);
//              }  
//          }
//      });
//  }
  
  //관리부서
  private void fnPopupCommP150_Mange(String deptCd) {
      //검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
      //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
      //검색.처리하면됨. 
      MSFFormPanel popCom0145 = PrgmComPopupUtils.lovPopUpPrgmCom0145Form(deptCd,"Y");  //부서
      
      final FormBinding popBindingCom0145 = popCom0145.getFormBinding();
     
      popBindingCom0145.addListener(Events.Change, new Listener<BaseEvent>() {
          public void handleEvent(BaseEvent be) {
              BaseModel mapModel = (BaseModel)be.getSource();
              if (!"".equals(mapModel.get("deptCd"))) {  
              	if("".equals(currAffnDeptCd.getValue()) || "".equals(currAffnDeptNm.getValue())
              		|| currAffnDeptCd.getValue() == null || currAffnDeptNm.getValue() == null){
              		 mangeDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
                       mangeDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt"))); 
                       currAffnDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
                       currAffnDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt")));
              		
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
              		|| mangeDeptCd.getValue() == null || mangeDeptNm.getValue() == null){
             		 	mangeDeptCd.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptCd")));
                      mangeDeptNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("deptNmRtchnt"))); 
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
  
	//국가코드
	private void fnPopupBass0300(final String itemValue) {
		//검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
		//넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
		//검색.처리하면됨.
		MSFFormPanel popCom0130 = PrgmComPopupUtils.lovPopUpPrgmCom0130Form(itemValue);  //공통  
	       
		final FormBinding popBindingCom0130 = popCom0130.getFormBinding();
	      
		popBindingCom0130.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				BaseModel mapModel = (BaseModel)be.getSource();
				if (!"".equals(mapModel.get("commCd"))) { 
					if ("A001".equals(itemValue)) {
						//국적
						natnCd.setValue( MSFSharedUtils.allowNulls(mapModel.get("commCd")));
						natnNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("commCdNm")));
						natnItem.setValue(MSFSharedUtils.allowNulls(mapModel.get("mangeItem12")));
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
	
	public void setPPRecord(BaseModel ppRecord) {
		this.ppRecord = ppRecord;
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
	
	
	private Psnl0200 getThis() {
		return this;
	}
	
  private void updatePsnl0100(Psnl0100DTO updateForm, final String fileName) {
	  
	  	updateForm.setWindowNm("PSNL0200");
		psnl0100Service.updatePsnl0100(updateForm, new AsyncCallback<Integer>(){

				@Override
				public void onFailure(Throwable caught) {
					
					MessageBox.alert("실패!", "수정실패!", null);
				}

				@Override
				public void onSuccess(Integer result) {
					 
                  
					if(!"".equals(fileName) && fileName != null){
						//사진 등록처리 servlet 시작
					    imgKeyCode.setValue(psnl0100Grid.getSelectionModel().getSelectedItem().getSystemkey());
                     // dpobCd.setValue(psnl0100Grid.getSelectionModel().getSelectedItem().getDpobCd());
                      frmKey.setValue("PSNL0125"); 
                  
                      plFrmPsnl0200.mask();  
                      plFrmPsnl0200.setAction(GWT.getHostPageBaseURL() + "upload/ImageFileUpload.do"); 
                      plFrmPsnl0200.submit();
                      plFrmPsnl0200.onFrameLoad(); 
                      picBoolFile = true;
                     
                      //사진 등록처리 servlet 끝 
                      
                        // reset and unmask the form 
                        // after file upload 
                      plFrmPsnl0200.addListener(Events.Submit, new Listener<FormEvent>() {
                            public void handleEvent(FormEvent evt) {  
                                plFrmPsnl0200.unmask(); 
                                if ("success".endsWith(evt.getResultHtml()) && picBoolFile) {
                                    //업로드가  성공했으면 인서트 모듈을 태운다. 
                                        MessageBox.info("성공!", "수정되었습니다.", null);
                                        resetMainForm();
                                        final PagingLoadConfig config = new BasePagingLoadConfig();
                                        config.setOffset(0);
                                        config.setLimit(50);
                                    
                                      // loaderPaging.load(config);
                                      
//                                    //GWT 스케쥴 처리 (사진 정보 로드 문제로 인해 1초 딜레이를 준다.)2014.09.24 jungmin
                                    Timer dtime = new Timer() {
                                        @Override
                                        public void run() {
                                            loaderPaging.load(config);
                                        }
                                    };
                                    dtime.schedule(2000); 
                                      picBoolFile = false;
                                      evt.setResultHtml("");
                                } else {
                                    //TODO 처리 할것 실패 메시지나 에러 메시지 처리 .
                                    evt.setResultHtml("");
                                }
                            };
                         });
					} else {
						if(result == -1){
							 MessageBox.info("실패!", "2017년도 고용시작일 대상자는 재직구분을 변경할수 없습니다. \n 고용탭에서 고용종료일을 입력해주세요.", null);
//                           resetMainForm();
//                           final PagingLoadConfig config = new BasePagingLoadConfig();
//                           config.setOffset(0);
//                           config.setLimit(50);
//                           loaderPaging.load(config);
						}else{
						    MessageBox.info("성공!", "수정되었습니다.", null);
                          resetMainForm();
                          final PagingLoadConfig config = new BasePagingLoadConfig();
                          config.setOffset(0);
                          config.setLimit(50);
                    
                          loaderPaging.load(config);
						}
					}
				}
			});
  }

}
