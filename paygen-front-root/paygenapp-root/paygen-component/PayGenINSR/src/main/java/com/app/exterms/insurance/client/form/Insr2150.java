package com.app.exterms.insurance.client.form;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.insurance.client.dto.Insr1550DTO;
import com.app.exterms.insurance.client.form.defs.Insr1100Def;
import com.app.exterms.insurance.client.form.defs.Insr1500Def;
import com.app.exterms.insurance.client.service.Insr2100Service;
import com.app.exterms.insurance.client.service.Insr2100ServiceAsync;
import com.app.exterms.insurance.client.utils.InsrUtils;
import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.dto.PrgmComPsnl0115DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.utils.PrintUtils;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.MSFCheckBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFDateField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTextField;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldWithButton;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.app.smrmf.syscom.client.util.SysComComboUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
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
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Encoding;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Method;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.HeaderGroupConfig;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Insr2150    extends MSFPanel {  
	private VerticalPanel vp;
	private FormPanel plFrmInsr2150;
	private String txtForm = "";
	private XTemplate detailTp;
    
	// 권한 설정 객체
	private GWTAuthorization gwtAuthorization;
	private GWTExtAuth gwtExtAuth;
	private boolean maskTracker = false; // 초기화 로딩 팝업 강제 unmask 처리
	  
	// 대상자 정보
	private Insr1100Def insr1100Def = new Insr1100Def("INSR2150"); // 그리드 테이블 컬럼 define
	private MSFGridPanel insr1100GridPanel;
	
	// 피부양자 정보
	private Insr1500Def insr1500Def = new Insr1500Def("INSR2150"); // 그리드 테이블 컬럼 define
	private MSFGridPanel insr1500GridPanel;
	private ActionDatabase actionDatabase;
	
	private ButtonBar topInsr2150Bar;
	private Button btnInsr2150Init;
	private Button btnInsr2150Sreach;
	private Button btnInsr2150ExcelFile;	//피부양자 전자파일
	private Button btnInsr2150Print;
	private Button btnInsr2150Excel;

	private DateField srhSoctyInsurCmptnDt01;
	private DateField srhSoctyInsurCmptnDt02;
     
	private MSFMultiComboBox<ModelData> srhHdofcCodtnCd;	// 재직상태
	private ComboBox<BaseModel> srhPayrMangDeptCd; 			// 단위기관
	private TextField<String> srhHanNm; 					// 성명
	private TextField<String> srhResnRegnNum; 				// 주민번호
	private HiddenField<String> srhSystemkey; 				// 시스템키
	private ComboBox<BaseModel> srhAqtnLssDivCd; 			// 취득상실
	
	private ComboBox<BaseModel> srhEmymtDivCd; 				// 고용구분
	private MSFMultiComboBox<ModelData> srhDeptCd; 			// 부서
	private MSFMultiComboBox<ModelData> srhTypOccuCd; 		// 직종
	private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; // 직종세
	private ComboBox<BaseModel> srhBusinCd; 				// 사업
	private ComboBox<BaseModel>  srhMangeDeptCd; 				//관리부서 수정
 
	private Boolean emptyCheck = false ;
	private ComboBox<BaseModel> srhRepbtyBusinDivCd; //호봉제구분코드 
	private ComboBox<BaseModel> srhDeptGpCd; //부서직종그룹코드
	
	private List<ModelData> mDtalistHdofcCodtnCd;
	private List<ModelData> mDtalistDeptCd;
	private List<ModelData> mDtalistTypOccuCd;
	private List<ModelData> mDtalistDtilOccuInttnCd;

	private boolean mutilCombo = false;
	
	private HiddenField<String> dpobCd;				/** column 사업장코드 : dpobCd */
	private HiddenField<String> systemkey;			/** column SYSTEMKEY : systemkey */
	private HiddenField<Long> socInsrAqtnEmymtNum;	/** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
	private MSFTextField socInsrAqtnEmymtNumV; //일련번호
	private HiddenField<String> socnsrAqtnRegVal04;	/** column 국적 : socnsrAqtnRegVal04 popup */
      
	private MSFDateField soctyInsurCmptnDt;		/** column 사회보험작성일자 : soctyInsurCmptnDt */	
	private HiddenField<Date> soctyInsurCmptnDtV;	/** column 국적 : soctyInsurCmptnDt popup */
 	private MSFTextField socnsrAqtnRegVal02;    /** column 성명 : socnsrAqtnRegVal02 */
 	private MSFTextField socnsrAqtnRegVal03;    /** column 주민등록번호 : socnsrAqtnRegVal03 */
	private MSFTextField emymtDivNm;			// 고용구분
	private MSFTextField deptNm;		 		// 부서
	private MSFTextField typOccuNm; 			// 직종
	private MSFTextField DtilOccuClsDivNm; 		// 직종세
	private TextFieldWithButton<String> socnsrAqtnRegVal04D;/** column 국적 : socnsrAqtnRegVal04 popup */
 	private MSFComboBox<BaseModel> socnsrAqtnRegVal05;    	/** TextFieldWithButton* column 체류자격 : socnsrAqtnRegVal05 */
 	private MSFCheckBox socnsrAqtnRegVal06;   				/** column 대표자여부 : socnsrAqtnRegVal06 1 예 / 2아니오 */
 	
 	private MSFTextField tempComPunNm; 			// 전화번호(사업장)
 	private MSFTextField tempHuPunNm; 			// 전화번호(가입)
 	
	private MSFCheckBox aqtnYn = new MSFCheckBox(); //취득
	private MSFCheckBox lssYn = new MSFCheckBox();    //상실
	private String systemKeys;
	private String printFileName;
	
	private ComboBox<BaseModel> applyYn;          //신고여부
	
	private void checkInsr2100Auth(String authAction, ListStore<BaseModel> bm) {
		if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef())
				&& gwtExtAuth.checkExtAuth(authAction, bm)) {
			if (!maskTracker) {
				unmask();
			}
			authExecEnabled();
			gwtExtAuth.setCheckMapDef(null); // 로딩완료 후 초기화
		}
	}
			  
	private void authExecEnabled() {
		Field<?>[] fldArrField = { srhPayrMangDeptCd, srhEmymtDivCd, srhDeptCd,srhTypOccuCd, srhDtilOccuInttnCd, srhBusinCd, srhAqtnLssDivCd };

		gwtAuthorization.formAuthFieldConfig(fldArrField);

		setInitDate();
		srhHdofcCodtnCd.getListView().setChecked(mDtalistHdofcCodtnCd.get(0),true);
		srhHdofcCodtnCd.setValue(mDtalistHdofcCodtnCd.get(0).get("commCdNm").toString());

		srhDeptCd.getListView().fireEvent(Events.CheckChanged);
	}
			   
	final Timer tmMask = new Timer() {
		public void run() {
			if (lsEmymtDivCd.getCount() > 0 && lsPayYrStore.getCount() > 0) {

				cancel();
				unmask();
				authExecEnabled();
				maskTracker = true;

			} else {
				tmMask.scheduleRepeating(2000);
			}
		}
	};
			      
	private void initLoad() {

		gwtAuthorization = GWTAuthorization.getInstance();
		gwtExtAuth = GWTExtAuth.getInstance();

		HashMap<String, Boolean> authMapDef = new HashMap<String, Boolean>();
		authMapDef.put("srhHdofcCodtnCd", Boolean.FALSE);
		authMapDef.put("PayrMangDeptCd", Boolean.FALSE);
		authMapDef.put("EmymtDivCd", Boolean.FALSE);
		authMapDef.put("DeptCd", Boolean.FALSE);
		authMapDef.put("AqtnLssDivCd", Boolean.FALSE);

		gwtExtAuth.setCheckMapDef(authMapDef);

		if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
			mask("[화면로딩] 초기화 진행 중!");
		}
		tmMask.scheduleRepeating(5000);
	}
	
	//입력수정삭제처리 rpc 처리부     
	private Insr2100ServiceAsync insr2100Service = Insr2100Service.Util.getInstance();	    
		
	private ListStore<BaseModel> lsPayYrStore = new ListStore<BaseModel>();			// 년도 
	private ListStore<BaseModel> lsPayMonth = new ListStore<BaseModel>();  			// 급여월   
  		
	private ListStore<BaseModel>  lsEmymtDivCd = new ListStore<BaseModel>();		//고용구분 
	private ListStore<BaseModel>  lsAqtnLssDivCd = new ListStore<BaseModel>();		//고용구분 
  		
	private ListStore<BaseModel>  applyCd = new ListStore<BaseModel>();		//고용구분 

	private ListStore<BaseModel> lsMangeDeptCd 	= new ListStore<BaseModel>();	//관리부서
	
	//--------------------부서 불러 오는 함수 ------------------------------------------------
	private ListStore<BaseModel> lsDeptCd  = new ListStore<BaseModel>();			// 부서콤보
	//--------------------부서 불러 오는 함수 ------------------------------------------------
  		   
	//--------------------사업 불러 오는 함수 -------------------------------------------------
	private ListStore<BaseModel> lsBusinCd  = new ListStore<BaseModel>();			// 사업콤보   
	//--------------------사업 불러 오는 함수 -------------------------------------------------
	
	private ListStore<BaseModel> lsPayrMangDeptCd = new ListStore<BaseModel>();		// 단위기관 
	private ListStore<BaseModel> lsTypOccuCd = new ListStore<BaseModel>();			// 직종 
	private ListStore<BaseModel> lsDtilOccuInttnCd = new ListStore<BaseModel>();	// 직종세
	private ListStore<BaseModel> lsHdofcCodtnCd = new ListStore<BaseModel>(); 		// 재직상태 
  		 
	private ListStore<BaseModel>  lsRepbtyBusinDivCd = new ListStore<BaseModel>();//호봉제구분코드 
	private ListStore<BaseModel>  lsDeptGpCd = new ListStore<BaseModel>();//부서직종그룹코드  


	
 	private ListStore<BaseModel> lsSocnsrAqtnRegVal05 = new ListStore<BaseModel>();	/** column 체류자격 : socnsrAqtnRegVal05 */
  	private ListStore<BaseModel> lsSocnsrAqtnRegVal09 = new ListStore<BaseModel>();	/** column 연금_취득부호 : socnsrAqtnRegVal09 */
  	private ListStore<BaseModel> lsSocnsrAqtnRegVal11 = new ListStore<BaseModel>();	/** column 연금_특수직종 : socnsrAqtnRegVal11 */
  	private ListStore<BaseModel> lsSocnsrAqtnRegVal12 = new ListStore<BaseModel>();	/** column 연금_직역연금부호 : socnsrAqtnRegVal12 */
  	private ListStore<BaseModel> lsSocnsrAqtnRegVal16 = new ListStore<BaseModel>(); /** column 건강_취득부호 : socnsrAqtnRegVal16 */
  	private ListStore<BaseModel> lsSocnsrAqtnRegVal18 = new ListStore<BaseModel>(); /** column 건강_감면 : socnsrAqtnRegVal18 */
  	private ListStore<BaseModel> lsSocnsrAqtnRegVal20 = new ListStore<BaseModel>(); /** column 건강_회계 : socnsrAqtnRegVal20 */
  	private ListStore<BaseModel> lsSocnsrAqtnRegVal21 = new ListStore<BaseModel>(); /** column 건강_직종 : socnsrAqtnRegVal21 */
  	private ListStore<BaseModel> lsSocnsrAqtnRegVal28 = new ListStore<BaseModel>(); /** column 고용_비고 : socnsrAqtnRegVal28 */
  	private ListStore<BaseModel> lsSocnsrAqtnRegVal29 = new ListStore<BaseModel>(); /** column 고용_보험료부과구분부호 : socnsrAqtnRegVal29 */
  	private ListStore<BaseModel> lsSocnsrAqtnRegVal30 = new ListStore<BaseModel>(); /** column 고용_보험료부과사유 : socnsrAqtnRegVal30 */
  	private ListStore<BaseModel> lsSocnsrAqtnRegVal37 = new ListStore<BaseModel>(); /** column 산재_비고 : socnsrAqtnRegVal37 */
  	private ListStore<BaseModel> lsSocnsrAqtnRegVal38 = new ListStore<BaseModel>(); /** column 산재_보험료부과구분부호 : socnsrAqtnRegVal38 */
  	private ListStore<BaseModel> lsSocnsrAqtnRegVal39 = new ListStore<BaseModel>(); /** column 산재_보험료부과구분사유 : socnsrAqtnRegVal39 */
  		
	private PrgmComBass0300DTO sysComBass0300Dto; // 공통코드 dto
	private PrgmComBass0400DTO sysComBass0400Dto; // 부서코드
	private PrgmComBass0500DTO sysComBass0500Dto; // 사업코드
	private PrgmComBass0150DTO sysComBass0150Dto; // 단위기관
	private SysCoCalendarDTO msfCoCalendarDto;
	private PrgmComBass0350DTO sysComBass0350Dto; // 직종세
	private PrgmComBass0320DTO sysComBass0320Dto; // 직종
  		 
	private BaseModel record;
	private Iterator<Record> records;
	private BaseModel ppRecord; // 팝업에 넘길 레코드 값

	private void doAction(ActionDatabase actionDatabase) {
		switch (actionDatabase) {
		case INSERT:
			break;
		case UPDATE:
			insr15501600FormSave();
			break;
		case DELETE:
			insr15501600FormSave();
			break;
		}
	}

	
	private void readDtailData() {

		if (MSFSharedUtils.paramNull(systemkey.getValue())) {
			return;
		}

		Insr1550DTO insr1550Dto = new Insr1550DTO(); 

		insr1550Dto.setDpobCd(dpobCd.getValue());                           /** column 사업장코드 : dpobCd */
		insr1550Dto.setSystemkey(systemkey.getValue());                     /** column SYSTEMKEY : systemkey */
		insr1550Dto.setSoctyInsurCmptnDt(GWTUtils.getStringFromDate(soctyInsurCmptnDtV.getValue(),"yyyyMMdd"));     /** column 사회보험작성일자 : soctyInsurCmptnDt */ 
		insr1550Dto.setSocInsrAqtnEmymtNum(socInsrAqtnEmymtNum.getValue()); /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
		//insr1550Dto.setFamyQuftDivCd(MSFSharedUtils.getSelectedComboValue(srhAqtnLssDivCd,"commCd"));

		insr2100Service.activityOnReadInsr1500(insr1550Dto ,
				new AsyncCallback<Insr1550DTO>() {
			public void onFailure(Throwable caught) {
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
						MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnReadInsr1500 : " + caught), null);
			}
			public void onSuccess(Insr1550DTO result) { 

				if( !"".equals(result.getSystemkey()) && result.getSystemkey() != null ) { 

					soctyInsurCmptnDt.setValue(soctyInsurCmptnDtV.getValue());
					emymtDivNm.setValue(result.getEmymtDivNm());    /** column 고용구분 : emymtDivNm */
					deptNm.setValue(result.getDeptNm());    /** column 부서 : deptNm */

					if (!MSFSharedUtils.paramNull(result.getTypOccuNm())) {
						typOccuNm.setValue(result.getTypOccuNm());    /** column 직종 : typOccuNm */
					} else {
						typOccuNm.setValue(result.getBusinNm());    /** column 직종 : typOccuNm */
					}

					socInsrAqtnEmymtNumV.setValue(result.getFamyAqtnLssNum().toString());    /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
					socnsrAqtnRegVal02.setValue(result.getHanNm());    /** column 성명 : socnsrAqtnRegVal02 */
					socnsrAqtnRegVal03.setValue(result.getResnRegnNum());    /** column 주민등록번호 : socnsrAqtnRegVal03 */
					socnsrAqtnRegVal04.setValue(result.getNatnNm());    /** column 국적 : socnsrAqtnRegVal04 */
					tempComPunNm.setValue(result.getInsrDpobPhnNum());    /** 전화번호(사업장) */
					tempHuPunNm.setValue(result.getInsrUsePhnNum());    /** 전화번호(가입자) */

					boolean boolAqtnYn = false;
					boolean boolLssYn = false;

					if ( "I0100001".equals(result.getFamyQuftDivCdAqtn())) {
						boolAqtnYn = true;
					}
					if ( "I0100002".equals(result.getFamyQuftDivCdLss())) {
						boolLssYn = true ;
					}


					aqtnYn.setValue( boolAqtnYn );
					lssYn.setValue( boolLssYn );

					if(boolAqtnYn == false && boolLssYn == false){
						lssYn.setEnabled(false);					
					}else{
						lssYn.setEnabled(true);
					}				
				}else{
					BaseModel bm = (BaseModel)record;
					soctyInsurCmptnDt.setValue(InsrUtils.getConvertStringToDate((String) bm.get("socnsrAqtnRegVal17"), "yyyyMMdd"));   /** column 사회보험작성일자 : soctyInsurCmptnDt */                    
					emymtDivNm.setValue(MSFSharedUtils.allowNulls(bm.get("emymtDivNm")));    /** column 고용구분 : emymtDivNm */
					deptNm.setValue(MSFSharedUtils.allowNulls(bm.get("deptNm")));    /** column 부서 : deptNm */

					if (!MSFSharedUtils.paramNull(MSFSharedUtils.allowNulls(bm.get("typOccuNm")))) {
						typOccuNm.setValue(MSFSharedUtils.allowNulls(bm.get("typOccuNm")));    /** column 직종 : typOccuNm */
					} else {
						typOccuNm.setValue(MSFSharedUtils.allowNulls(bm.get("businNm")));    /** column 직종 : typOccuNm */
					}

					socInsrAqtnEmymtNumV.setValue(MSFSharedUtils.allowNulls(bm.get("socInsrAqtnEmymtNum")));  
					socnsrAqtnRegVal02.setValue(MSFSharedUtils.allowNulls(bm.get("hanNm")));
					socnsrAqtnRegVal03.setValue(MSFSharedUtils.allowNulls(bm.get("resnRegnNum")));    /** column 주민등록번호 : socnsrAqtnRegVal03 */
					lssYn.setEnabled(false);
				} 
			}
		});
	}
    
	
	private void readDtailData2() {

		if (MSFSharedUtils.paramNull(systemkey.getValue())) {
			return;
		}
            
        Insr1550DTO insr1550Dto = new Insr1550DTO(); 
        
        if(aqtnYn.getValue()) insr1550Dto.setFamyQuftDivCd("I0100001");
        else if(lssYn.getValue())	insr1550Dto.setFamyQuftDivCd("I0100002");

        
        //Window.alert(""+insr1550Dto.getFamyQuftDivCd());
        
        insr1550Dto.setDpobCd(dpobCd.getValue());                           /** column 사업장코드 : dpobCd */
        insr1550Dto.setSystemkey(systemkey.getValue());                     /** column SYSTEMKEY : systemkey */
        insr1550Dto.setSoctyInsurCmptnDt(GWTUtils.getStringFromDate(soctyInsurCmptnDtV.getValue(),"yyyyMMdd"));     /** column 사회보험작성일자 : soctyInsurCmptnDt */ 
        insr1550Dto.setSocInsrAqtnEmymtNum(socInsrAqtnEmymtNum.getValue()); /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
        
 		insr2100Service.activityOnReadInsr1500(insr1550Dto ,
                new AsyncCallback<Insr1550DTO>() {
        public void onFailure(Throwable caught) {
        MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnReadInsr1500 : " + caught), null);
        }
        public void onSuccess(Insr1550DTO result) { 
        	
        	if( !"".equals(result.getSystemkey()) && result.getSystemkey() != null ) { 
        	
        		soctyInsurCmptnDt.setValue(soctyInsurCmptnDtV.getValue());
				emymtDivNm.setValue(result.getEmymtDivNm());    /** column 고용구분 : emymtDivNm */
				deptNm.setValue(result.getDeptNm());    /** column 부서 : deptNm */
	
				if (!MSFSharedUtils.paramNull(result.getTypOccuNm())) {
					typOccuNm.setValue(result.getTypOccuNm());    /** column 직종 : typOccuNm */
				} else {
					typOccuNm.setValue(result.getBusinNm());    /** column 직종 : typOccuNm */
				}
				
				socInsrAqtnEmymtNumV.setValue(result.getFamyAqtnLssNum().toString());    /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
				socnsrAqtnRegVal02.setValue(result.getHanNm());    /** column 성명 : socnsrAqtnRegVal02 */
				socnsrAqtnRegVal03.setValue(result.getResnRegnNum());    /** column 주민등록번호 : socnsrAqtnRegVal03 */
				socnsrAqtnRegVal04.setValue(result.getNatnNm());    /** column 국적 : socnsrAqtnRegVal04 */
				tempComPunNm.setValue(result.getInsrDpobPhnNum());    /** 전화번호(사업장) */
				tempHuPunNm.setValue(result.getInsrUsePhnNum());    /** 전화번호(가입자) */
				
				boolean boolAqtnYn = false;
				boolean boolLssYn = false;

				if ( "I0100001".equals(result.getFamyQuftDivCdAqtn())) {
					boolAqtnYn = true;
				}
				if ( "I0100002".equals(result.getFamyQuftDivCdLss())) {
					boolLssYn = true ;
				}
				if(boolAqtnYn == false && boolLssYn == false){
					lssYn.setEnabled(false);					
				}else{
					lssYn.setEnabled(true);
				}	
        	}else{
                 BaseModel bm = (BaseModel)record;
                 soctyInsurCmptnDt.setValue(InsrUtils.getConvertStringToDate((String) bm.get("socnsrAqtnRegVal17"), "yyyyMMdd"));   /** column 사회보험작성일자 : soctyInsurCmptnDt */
                     
                 emymtDivNm.setValue(MSFSharedUtils.allowNulls(bm.get("emymtDivNm")));    /** column 고용구분 : emymtDivNm */
                 deptNm.setValue(MSFSharedUtils.allowNulls(bm.get("deptNm")));    /** column 부서 : deptNm */

                 if (!MSFSharedUtils.paramNull(MSFSharedUtils.allowNulls(bm.get("typOccuNm")))) {
                	 typOccuNm.setValue(MSFSharedUtils.allowNulls(bm.get("typOccuNm")));    /** column 직종 : typOccuNm */
                 } else {
                	 typOccuNm.setValue(MSFSharedUtils.allowNulls(bm.get("businNm")));    /** column 직종 : typOccuNm */
                 }
                 socInsrAqtnEmymtNumV.setValue(MSFSharedUtils.allowNulls(bm.get("socInsrAqtnEmymtNum")));  
                 socnsrAqtnRegVal02.setValue(MSFSharedUtils.allowNulls(bm.get("hanNm")));
                 socnsrAqtnRegVal03.setValue(MSFSharedUtils.allowNulls(bm.get("resnRegnNum")));    /** column 주민등록번호 : socnsrAqtnRegVal03 */
                 //socnsrAqtnRegVal04.setValue(result.getNatnNm());    /** column 국적 : socnsrAqtnRegVal04 */
                 //tempComPunNm.setValue(result.getInsrDpobPhnNum());    /** 전화번호(사업장) */
                 //tempHuPunNm.setValue(result.getInsrUsePhnNum());    /** 전화번호(가입자) */
        	} 
        }
 		});
	}
	
	private void Insr2100Print(String fileName,String repType) {

		if (PayGenConst.REPORT_DIV_TYPE02.equals(repType)) {

			Window.alert("지원예정!" + repType);
			// RdaPrint( fileName);

		} else if (PayGenConst.REPORT_DIV_TYPE01.equals(repType)) {

			RexPrint(fileName);

		} else {
			Window.alert("출력 타입 오류(프로퍼티설정확인)!" + repType);
		}

	}

	private void RdaPrint(String fileName) {

	
	}
	

	
  
	public ContentPanel getViewPanel() {
		if (panel == null) {

			initLoad();

			detailTp = XTemplate.create(getDetailTemplate());

			vp = new VerticalPanel();
			vp.setSpacing(10);
			createInsr2100Form(); 	// 화면 기본정보를 설정
			createSearchForm(); 	// 검색조건 적용
			createForm(); 			// 피부양자 정보
			//엣지변환
			//vp.setSize("1010px", "800px");
			vp.setSize("1010px", "850px");

			panel = new ContentPanel();
			panel.setBodyBorder(false);
			panel.setBorders(false);
			panel.setHeaderVisible(false);
			panel.setScrollMode(Scroll.AUTO);
			panel.add(vp);

		}
		return panel;
	}
	 
	public Insr2150() {
		//엣지변환
		//setSize("1010px", "800px");
		setSize("1010px", "850px");
	}

	public Insr2150(String txtForm) {
		this.txtForm = txtForm;
	}
	  
	private void createInsr2100Form() {
    
		
		
		
		plFrmInsr2150 = new FormPanel();
   
		plFrmInsr2150.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 피부양자취득/상실신고"));
		plFrmInsr2150.setIcon(MSFMainApp.ICONS.text());
		plFrmInsr2150.setPadding(2);
		plFrmInsr2150.setFrame(true);
		
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage("피부양자취득/상실신고","INSR2150");
				}
			});
		plFrmInsr2150.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmInsr2150.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/

    
		//멀티콤보박스 닫기 
		plFrmInsr2150.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
			@Override
			public void handleEvent(ComponentEvent ce) { 
				if (mutilCombo) {
					if ( srhDeptCd.getCheckBoxListHolder().isVisible() ) {
	        			srhDeptCd.showClose(ce);
	        			mutilCombo = false;
	        			} else if ( srhHdofcCodtnCd.getCheckBoxListHolder().isVisible() ) {
	        			srhHdofcCodtnCd.showClose(ce);
	        			mutilCombo = false;
	        			} else if (srhTypOccuCd.getCheckBoxListHolder().isVisible() ) {
	        			//직종
	        			srhTypOccuCd.showClose(ce);
	        			mutilCombo = false;
	        			//  srhTypOccuCd.getListView().fireEvent(Events.CheckChanged);
	        			} else if ( srhDtilOccuInttnCd.getCheckBoxListHolder().isVisible() ) {
	        			//직종세
	        			srhDtilOccuInttnCd.showClose(ce);
	        			mutilCombo = false;
        			}  
        		}
        	} 
		});
    
    
		topInsr2150Bar = new ButtonBar();
		topInsr2150Bar.setAlignment(HorizontalAlignment.RIGHT);

		// 초기화
		btnInsr2150Init = new Button("초기화");
		btnInsr2150Init.setIcon(MSFMainApp.ICONS.new16());
		topInsr2150Bar.add(btnInsr2150Init);
		btnInsr2150Init.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				// 초기화 버튼 클릭시 처리
				formInit();
			}
		});

		btnInsr2150Sreach = new Button("조회"); 
		btnInsr2150Sreach.setIcon(MSFMainApp.ICONS.search16());
		topInsr2150Bar.add(btnInsr2150Sreach);
		btnInsr2150Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
//				String aqtnLssDivCd = MSFSharedUtils.getSelectedComboValue(srhAqtnLssDivCd,"commCd");
//				
//				if(aqtnLssDivCd == null || aqtnLssDivCd.equals("")){
//					Window.alert("취득상실을 선택해 주세요.");
//					return;
//				}
				
				//조회버튼 클릭시 처리 
				insr1100GridPanel.getMsfGrid().clearData();
				insr1500GridPanel.getMsfGrid().clearData();
				detailClear();
				reload();  
			}
		});
  	
  	
		btnInsr2150Print = new Button("인쇄");
		btnInsr2150Print.setIcon(MSFMainApp.ICONS.print16());
		topInsr2150Bar.add(btnInsr2150Print);
		btnInsr2150Print.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				Insr2100Print("INSRT2150",MSFMainApp.getMsg("PayGen.ReportDivisionType"));
			}
		});
  	
		btnInsr2150ExcelFile = new Button("피부양자");
		btnInsr2150ExcelFile.setIcon(MSFMainApp.ICONS.excel16());
		topInsr2150Bar.add(btnInsr2150ExcelFile);
		btnInsr2150ExcelFile.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				excelFileExport();
			}
		});
  	
		plFrmInsr2150.add(topInsr2150Bar);

		// 파일업로드 처리
		plFrmInsr2150.setAction("myurl");
		plFrmInsr2150.setEncoding(Encoding.MULTIPART);
		plFrmInsr2150.setMethod(Method.POST);

		vp.add(plFrmInsr2150);
		//엣지변환
		//plFrmInsr2150.setSize("990px", "760px");
		plFrmInsr2150.setSize("990px", "810px");
	}

	private void createSearchForm() {   
     
		srhSystemkey = new HiddenField<String>();  //시스템키 
		sysComBass0150Dto = new PrgmComBass0150DTO();
		sysComBass0300Dto = new PrgmComBass0300DTO();
		sysComBass0400Dto = new PrgmComBass0400DTO();
		sysComBass0500Dto = new PrgmComBass0500DTO();
		msfCoCalendarDto = new SysCoCalendarDTO();
		sysComBass0350Dto = new PrgmComBass0350DTO();
		sysComBass0320Dto = new PrgmComBass0320DTO();
	 
		//--------------------단위기관 불러 오는 함수 ------------------------------------------------
		lsPayrMangDeptCd = PrgmComComboUtils.getDeptBass0150ComboData(sysComBass0150Dto);
		//--------------------단위기관 불러 오는 함수 ------------------------------------------------
	 
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		//재직상태  
		sysComBass0300Dto.setRpsttvCd("A003");
		lsHdofcCodtnCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		lsHdofcCodtnCd.addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {  
				mDtalistHdofcCodtnCd = InsrUtils.getLstComboModelData(lsHdofcCodtnCd) ; 
				srhHdofcCodtnCd.getStore().add(mDtalistHdofcCodtnCd);
			}
		});  
		
		//취득상실구분
		sysComBass0300Dto.setRpsttvCd("I010"); 
		lsAqtnLssDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	 
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		//고용구분
		sysComBass0300Dto.setRpsttvCd("A002");
		lsEmymtDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
	 
		//--------------------급여년도 불러 오는 함수 ------------------------------------------------
		lsPayYrStore = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
		//--------------------급여년도 불러 오는 함수 ------------------------------------------------ 
    
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------
		//월 
		lsPayMonth = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);
		//--------------------공통 코드 불러 오는 함수 --------------------------------------------------

  		 //-------------------관리부서 추가  
  		sysComBass0400Dto.setDeptDspyYn("Y");
  		sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd()); 
  		lsMangeDeptCd = PrgmComComboUtils.getMangDeptBass0400ComboData (sysComBass0400Dto);

		//--------------------급여부서 불러 오는 함수 ------------------------------------------------  
		sysComBass0400Dto.setDeptDspyYn("Y");
		sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept()); 
		sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
    
		lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
    
		lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {  
				mDtalistDeptCd = InsrUtils.getDeptCdModelData(lsDeptCd) ; 
				srhDeptCd.getInitStore().add(mDtalistDeptCd);
			}
		});     
		
		sysComBass0300Dto.setRpsttvCd("A048");
		  lsRepbtyBusinDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);

		
		plFrmInsr2150.setLayout(new FlowLayout());

		srhSystemkey = new HiddenField<String>();
     
		LayoutContainer lcSchCol = new LayoutContainer();
		// lcSchCol.setStyleAttribute("background-color","red");
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
		// lcSchLeft.setStyleAttribute("paddingRight", "10px");
		lcSchLeft.setLayout(new ColumnLayout());

		fieldSet.add(lcSchCol, new FormData("100%"));

		LayoutContainer layoutContainer_8 = new LayoutContainer();
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_8.setLayout(frmlytSch);
     
		srhSoctyInsurCmptnDt01 = new DateField();
		srhSoctyInsurCmptnDt01.setName("soctyInsurCmptnDt01");
		new DateFieldMask(srhSoctyInsurCmptnDt01, "9999.99.99");
		srhSoctyInsurCmptnDt01.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		srhSoctyInsurCmptnDt01.setFieldLabel("취득기간");
   
		layoutContainer_8.add(srhSoctyInsurCmptnDt01, new FormData("100%"));
		lcSchLeft.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		layoutContainer_8.setBorders(false);

		LayoutContainer layoutContainer_9 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(10);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_9.setLayout(frmlytSch);
   
		srhSoctyInsurCmptnDt02 = new DateField();
		srhSoctyInsurCmptnDt02.setName("srhSoctyInsurCmptnDt02");
		new DateFieldMask(srhSoctyInsurCmptnDt02, "9999.99.99");
		srhSoctyInsurCmptnDt02.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		srhSoctyInsurCmptnDt02.setLabelSeparator("~");
   
		layoutContainer_9.add(srhSoctyInsurCmptnDt02, new FormData("100%"));
		lcSchLeft.add(layoutContainer_9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_9.setBorders(false);

		
		
		
		
		
		LayoutContainer layoutContainer_14 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_14.setLayout(frmlytSch);

		
		
		
		
		
		
	/*	srhHdofcCodtnCd = new MSFMultiComboBox<ModelData>();
		srhHdofcCodtnCd.setName("srhHdofcCodtnCd");
		srhHdofcCodtnCd.setEmptyText("--재직선택--");
		srhHdofcCodtnCd.setReadOnly(true);
		srhHdofcCodtnCd.setEnabled(true);
		srhHdofcCodtnCd.getListView().setDisplayProperty("commCdNm");
		srhHdofcCodtnCd.getStore().add(mDtalistHdofcCodtnCd);
		srhHdofcCodtnCd.setWidth(100);
		srhHdofcCodtnCd.setFieldLabel("재직상태");
		srhHdofcCodtnCd.getStore().addStoreListener(new StoreListener<ModelData>() {
			public void handleEvent(StoreEvent<ModelData> be) {
				checkInsr2100Auth("srhHdofcCodtnCd", lsHdofcCodtnCd);
			}
		});
		srhHdofcCodtnCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
			@Override
			public void handleEvent(ComponentEvent ce) {   
				if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
					// GWT.log(" a" + ce.getEvent().getType());
					mutilCombo = true;
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
					mutilCombo = true;
					//  GWT.log(" b" + ce.getEvent().getType());
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
					mutilCombo = false;
					//  GWT.log(" b" + ce.getEvent().getType());
				}  
			} 
		});*/
		
		
		srhAqtnLssDivCd = new ComboBox<BaseModel>();
		srhAqtnLssDivCd.setName("srhAqtnLssDivCd");
		srhAqtnLssDivCd.setForceSelection(true);
		srhAqtnLssDivCd.setMinChars(1);
		srhAqtnLssDivCd.setDisplayField("commCdNm");
		srhAqtnLssDivCd.setValueField("commCd");
		srhAqtnLssDivCd.setTriggerAction(TriggerAction.ALL);
		srhAqtnLssDivCd.setEmptyText("--취득상실선택--");
		srhAqtnLssDivCd.setSelectOnFocus(true);
		//srhAqtnLssDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
		//srhAqtnLssDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd());
		srhAqtnLssDivCd.setStore(lsAqtnLssDivCd);
		srhAqtnLssDivCd.setFieldLabel("취득상실");
		lsAqtnLssDivCd.addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {  
				EventType type = be.getType();
				if (type == Store.Add) { 
					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 
                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
                     * "srhPayrMangDeptCd","srhAqtnLssDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
                	checkInsr2100Auth("AqtnLssDivCd", lsAqtnLssDivCd ); 
				}
			}
		}); 
		
		
		
		layoutContainer_14.add(srhAqtnLssDivCd, new FormData("100%"));
		layoutContainer_14.setBorders(false); 
		
		
		
		
		LayoutContainer layoutContainer = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer.setLayout(frmlytSch);
   
		/** column 단위기관 : payrMangDeptCd */
		srhPayrMangDeptCd = new ComboBox<BaseModel>();
		srhPayrMangDeptCd.setName("srhPayrMangDeptCd");
		srhPayrMangDeptCd.setForceSelection(true);
		srhPayrMangDeptCd.setMinChars(1);
		srhPayrMangDeptCd.setDisplayField("payrMangDeptNm");
		srhPayrMangDeptCd.setValueField("payrMangDeptCd");
		srhPayrMangDeptCd.setTriggerAction(TriggerAction.ALL);
		srhPayrMangDeptCd.setEmptyText("--단위기관선택--");
		srhPayrMangDeptCd.setSelectOnFocus(true);
		srhPayrMangDeptCd.setReadOnly(gwtExtAuth.getReadOnlyPayrMangDeptCd());
		srhPayrMangDeptCd.setEnabled(gwtExtAuth.getEnablePayrMangDeptCd());
		srhPayrMangDeptCd.setStore(lsPayrMangDeptCd);
		srhPayrMangDeptCd.setFieldLabel("단위기관");
		lsPayrMangDeptCd.addStoreListener(new StoreListener<BaseModel>() {
			public void handleEvent(StoreEvent<BaseModel> be) {  
				EventType type = be.getType();
				if (type == Store.Add) { 
					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 
                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
                	checkInsr2100Auth("PayrMangDeptCd", lsPayrMangDeptCd ); 
				} 
			}
		});    
		srhPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {

				sysComBass0400Dto = new PrgmComBass0400DTO();
		  		 
				srhDeptCd.reset();
				sysComBass0400Dto.setDeptDspyYn("Y");
				sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")); 
		  		sysComBass0400Dto.setMangeDeptCd(MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd")); 

				//--------------------부서 불러 오는 함수 ------------------------------------------------
				lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
				//--------------------부서 불러 오는 함수 ------------------------------------------------
				lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
					public void handleEvent(StoreEvent<BaseModel> be) {  
						mDtalistDeptCd = InsrUtils.getDeptCdModelData(lsDeptCd) ; 
						srhDeptCd.getInitStore().add(mDtalistDeptCd);
					}
				});  
			} 
		});
		layoutContainer.add(srhPayrMangDeptCd, new FormData("100%"));
		layoutContainer.setBorders(false);
   
   

		//관리부서 
		LayoutContainer lcSch2_1 = new LayoutContainer();
		FormLayout frmlytSch2_1 = new FormLayout();
		frmlytSch2_1.setLabelWidth(60);
		frmlytSch2_1.setLabelAlign(LabelAlign.RIGHT);
		lcSch2_1.setLayout(frmlytSch2_1);
		
		srhMangeDeptCd = new ComboBox<BaseModel>();
		srhMangeDeptCd.setName("srhMangeDeptCd"); 
		srhMangeDeptCd.setEmptyText("--관리부서선택--");
		srhMangeDeptCd.setDisplayField("deptNmRtchnt");
		srhMangeDeptCd.setStore(lsMangeDeptCd); 
		srhMangeDeptCd.setWidth(100);
		srhMangeDeptCd.setFieldLabel("관리부서");
		srhMangeDeptCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
        srhMangeDeptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
        srhMangeDeptCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  
            	EventType type = be.getType();
            	if (type == Store.Add) { 
            		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            		 * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
            		 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
            		 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
		     			++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
            		//	checkPsnl0250Auth("srhDeptCd", lsDeptCd); 
            	}
            }
        });  
        srhMangeDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
	    		//단위기관가 변경되는 경우 해당하는 부서변경처리를 위한 이벤트처리 
	    		sysComBass0400Dto = new PrgmComBass0400DTO();
  	    		sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd")); 
  	    		sysComBass0400Dto.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"))); 
  	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
  	    		lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
  	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
  	    		
  	    		lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
  	    			public void handleEvent(StoreEvent<BaseModel> be) {  
  	    				mDtalistDeptCd = InsrUtils.getDeptCdModelData(lsDeptCd) ; 
  	    				srhDeptCd.getInitStore().add(mDtalistDeptCd);
  	    			}
  	    		});  
  	    		emptyCheck = true;
	    	} 
	    });
        srhMangeDeptCd.addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
            @Override
            public void handleEvent(ComponentEvent ce) {    
            	
                if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {  
                	
                	if (emptyCheck && "".equals(MSFSharedUtils.allowNulls(srhMangeDeptCd.getRawValue()))) {
	                	sysComBass0400Dto = new PrgmComBass0400DTO();
	      	    		sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));  
	      	    	    sysComBass0400Dto.setMangeDeptCd(MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd")); 
	      	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
	      	    		lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
	      	    		//--------------------부서 불러 오는 함수 ------------------------------------------------
	      	    		
	      	    		lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
	      	    			public void handleEvent(StoreEvent<BaseModel> be) {  
	      	    				mDtalistDeptCd = InsrUtils.getDeptCdModelData(lsDeptCd) ; 
	      	    				srhDeptCd.getInitStore().add(mDtalistDeptCd);
	      	    			} 
	      	    			
	      	    		}); 
	      	    		emptyCheck = false;
                	}
                 }  
            } 
        });   
       
        lcSch2_1.add(srhMangeDeptCd, new FormData("100%"));
   
		lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.26)); 
		lcSchCol.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.28));
		lcSchCol.add(lcSch2_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.26));
   
		LayoutContainer layoutContainer_13 = new LayoutContainer();
		layoutContainer_13.setLayout(new ColumnLayout());
   
		LayoutContainer layoutContainer_1 = new LayoutContainer();
		layoutContainer_1.setLayout(new ColumnLayout());
		
		LayoutContainer layoutContainer_101 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_101.setLayout(frmlytSch);
   
		srhEmymtDivCd = new ComboBox<BaseModel>();
		srhEmymtDivCd.setName("srhEmymtDivCd");
		srhEmymtDivCd.setForceSelection(true);
		srhEmymtDivCd.setMinChars(1);
		srhEmymtDivCd.setDisplayField("commCdNm");
		srhEmymtDivCd.setValueField("commCd");
		srhEmymtDivCd.setTriggerAction(TriggerAction.ALL);
		srhEmymtDivCd.setEmptyText("--고용구분선택--");
		srhEmymtDivCd.setSelectOnFocus(true);
		srhEmymtDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
		srhEmymtDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd());
		srhEmymtDivCd.setStore(lsEmymtDivCd);
		srhEmymtDivCd.setFieldLabel("고용구분");
		lsEmymtDivCd.addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {  
				EventType type = be.getType();
				if (type == Store.Add) { 
					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 
                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
                	checkInsr2100Auth("EmymtDivCd", lsEmymtDivCd ); 
				}
			}
		});    
		srhEmymtDivCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
			public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
				//부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
				BaseModel bmPayCd =  se.getSelectedItem(); 
				
				if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD02.equals(bmPayCd.get("commCd"))) {
					srhDeptCd.getListView().fireEvent(Events.CheckChanged); 
					srhBusinCd.setEnabled(true);
					srhTypOccuCd.reset();
					srhTypOccuCd.setEnabled(false);
					srhDtilOccuInttnCd.reset();
					srhDtilOccuInttnCd.setEnabled(false);
				} else {
					
					//20151130 추가 수정 
					srhDeptCd.getListView().fireEvent(Events.CheckChanged);
					srhBusinCd.reset();
					srhBusinCd.setEnabled(false);   
					
					if (gwtExtAuth.getEnableTypOccuCd()) {
						srhTypOccuCd.setEnabled(true);
						srhDtilOccuInttnCd.setEnabled(true); 
					} else {
						srhTypOccuCd.setEnabled(false);
						srhDtilOccuInttnCd.setEnabled(false);
					}
				}  
			} 
		});
		layoutContainer_101.add(srhEmymtDivCd, new FormData("100%"));
		layoutContainer_1.setBorders(false); 
   
		LayoutContainer layoutContainer_102 = new LayoutContainer();
		   frmlytSch = new FormLayout();  
		   frmlytSch.setLabelWidth(1); 
		   frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
		   frmlytSch.setDefaultWidth(0);
		   layoutContainer_102.setLayout(frmlytSch);
		   
		   
		   
		   srhRepbtyBusinDivCd  =  new ComboBox<BaseModel>(); 
		   srhRepbtyBusinDivCd.setName("srhRepbtyBusinDivCd");
		   srhRepbtyBusinDivCd.setForceSelection(true);
		   srhRepbtyBusinDivCd.setAllowBlank(false);
		   srhRepbtyBusinDivCd.setMinChars(1);
		   srhRepbtyBusinDivCd.setDisplayField("commCdNm");
		   srhRepbtyBusinDivCd.setValueField("commCd");
		   srhRepbtyBusinDivCd.setTriggerAction(TriggerAction.ALL);
		   srhRepbtyBusinDivCd.setEmptyText("--호봉제--");
		   srhRepbtyBusinDivCd.setSelectOnFocus(true); 
		   srhRepbtyBusinDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
		   srhRepbtyBusinDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
		   srhRepbtyBusinDivCd.setStore(lsRepbtyBusinDivCd);
		   srhRepbtyBusinDivCd.setHideLabel(true);
		   //srhRepbtyBusinDivCd.setLabelSeparator("");
		  // srhRepbtyBusinDivCd.setFieldLabel("고용구분");  
		   lsRepbtyBusinDivCd.addStoreListener( new StoreListener<BaseModel>() {   
		       public void handleEvent(StoreEvent<BaseModel> be) {  

//		       	  EventType type = be.getType();
//			    	   if (type == Store.Add) { 
//		           		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//			                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
//			                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//			                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
//			                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//			    		   checkPayr4050Auth("EmymtDivCd", lsEmymtDivCd); 
//		           	 }  
		         
		       }
		   });  
		   
		   layoutContainer_102.add(srhRepbtyBusinDivCd, new FormData("100%"));
		   layoutContainer_102.setBorders(false); 
		   
		   
		   layoutContainer_1.add(layoutContainer_101, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		   layoutContainer_1.add(layoutContainer_102, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		   layoutContainer_1.setBorders(false); 
		
		LayoutContainer layoutContainer_2 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2.setLayout(frmlytSch);
   
		srhDeptCd = new MSFMultiComboBox<ModelData>();
		srhDeptCd.setName("srhDeptCd");
		// srhDeptCd.setForceSelection(true);
		// srhDeptCd.setMinChars(1);
		// srhDeptCd.setDisplayField("deptNmRtchnt");
		// srhDeptCd.setValueField("deptCd");
		// srhDeptCd.setTriggerAction(TriggerAction.ALL);
		srhDeptCd.setEmptyText("--부서선택--");
		// srhDeptCd.setSelectOnFocus(true);
		// srhDeptCd.setReadOnly(false);
		// srhDeptCd.setEnabled(true);
		// srhDeptCd.setStore(lsDeptCd );
		// srhDeptCd.setMinListWidth(MSFConfiguration.FRM_COMBO_WIDTH_200);
		srhDeptCd.getListView().setDisplayProperty("deptNmRtchnt");
		srhDeptCd.getStore().add(mDtalistDeptCd);
		srhDeptCd.setWidth(100);
		srhDeptCd.setFieldLabel("부서");
		srhDeptCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
		srhDeptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
		srhDeptCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
			public void handleEvent(StoreEvent<ModelData> be) {  

				// srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(0)); 
				EventType type = be.getType();
				if (type == Store.Add) { 
					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 
                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
                	checkInsr2100Auth("DeptCd", lsDeptCd ); 
				}
			}
		});    
		srhDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) { 
              
				if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
					if (srhDeptCd.getListView().getChecked().size() > 0) {  
						sysComBass0500Dto.setBusinApptnYr(GWTUtils.getStringFromDate(srhSoctyInsurCmptnDt01.getValue(),"yyyy"));    
                         List<ModelData> mdListSelect =  srhDeptCd.getListView().getChecked(); 
                         sysComBass0500Dto.setDeptCd( MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd"))); 
                     }      
                  
					//--------------------사업 불러 오는 함수 -------------------------------------------------
					lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
					//--------------------사업 불러 오는 함수 -------------------------------------------------
					srhBusinCd.setStore(lsBusinCd); 
					srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
                           public void handleEvent(StoreEvent<BaseModel> be) {  
                            //   searchBusinCd.setValue(lsBusinCd.getAt(0));  
                           }
					}); 
				} else if ((srhDeptCd.getListView().getChecked().size() > 0) && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
			            		 
					//2015.11.30 권한 직종가져오기  추가 
					sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
		          	String strDeptCd = InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
		          	sysComBass0320Dto.setDeptCd(strDeptCd);
		          	lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
		          	lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
		          		public void handleEvent(StoreEvent<BaseModel> be) {  
		          			mDtalistTypOccuCd = InsrUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
		          			srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
		          		}
		          	});  
				} else {
					sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
					String strDeptCd = InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
					sysComBass0320Dto.setDeptCd(strDeptCd);
		       	   	lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
		       	   	lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
		       	   		public void handleEvent(StoreEvent<BaseModel> be) {  
		       	   			mDtalistTypOccuCd = InsrUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
		       	   			srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
		       	   		}
		       	   	});   
				}
			}  
		});  
		srhDeptCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
			@Override
			public void handleEvent(ComponentEvent ce) {   
           
				if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
					// GWT.log(" a" + ce.getEvent().getType());
					mutilCombo = true;
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
					mutilCombo = true;
					//  GWT.log(" b" + ce.getEvent().getType());
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
					mutilCombo = false;
					//  GWT.log(" b" + ce.getEvent().getType());
				} 
			} 
		});
        
		layoutContainer_2.add(srhDeptCd, new FormData("100%"));
		layoutContainer_2.setBorders(false);

		LayoutContainer layoutContainer_10 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_10.setLayout(frmlytSch);
   
		
		
		
		
		// 직종 직종세처리
		LayoutContainer lcTypOccuCd = new LayoutContainer();
		lcTypOccuCd.setLayout(new ColumnLayout());

		   
		   LayoutContainer layoutContainer_19 = new LayoutContainer();
		   frmlytSch = new FormLayout();  
		   frmlytSch.setLabelWidth(60); 
		   frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		   layoutContainer_19.setLayout(frmlytSch); 
		
		   srhDeptGpCd  =  new ComboBox<BaseModel>(); 
		   srhDeptGpCd.setName("srhDeptGpCd");
		   srhDeptGpCd.setForceSelection(true);
		   srhDeptGpCd.setAllowBlank(false);
		   srhDeptGpCd.setMinChars(1);
		   srhDeptGpCd.setDisplayField("commCdNm");
		   srhDeptGpCd.setValueField("commCd");
		   srhDeptGpCd.setTriggerAction(TriggerAction.ALL);
		   srhDeptGpCd.setEmptyText("--그룹--");
		   srhDeptGpCd.setSelectOnFocus(true); 
		   srhDeptGpCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
		   srhDeptGpCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
		   srhDeptGpCd.setStore(lsDeptGpCd);
		   srhDeptGpCd.setFieldLabel("직종"); 
		   
		   layoutContainer_19.add(srhDeptGpCd, new FormData("100%")); 
		   
		   
		LayoutContainer layoutContainer_21 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_21.setLayout(frmlytSch);
   
		srhTypOccuCd = new MSFMultiComboBox<ModelData>();
		srhTypOccuCd.setName("srhTypOccuCd");
		srhTypOccuCd.setEmptyText("--직종선택--");
		srhTypOccuCd.getListView().setDisplayProperty("typOccuNm");
		srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
		srhTypOccuCd.setWidth(100);
		   srhTypOccuCd.setHideLabel(true);
		srhTypOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
		srhTypOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd());
		srhTypOccuCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
			public void handleEvent(StoreEvent<ModelData> be) {  
    	  
				EventType type = be.getType();
				if (type == Store.Add) { 
					//2015.11.30 추가 
					if (!MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
						if (!gwtExtAuth.getEnableTypOccuCd()) {
							ModelData  mdSelect  = srhTypOccuCd.getStore().getAt(0) ; 
                   
							srhTypOccuCd.getListView().setChecked(mdSelect, true); 
							srhTypOccuCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("typOccuNm")));
                    
						}  
						// srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(0)); 
						/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
						 * 권한설정을 위한 콤보처리를 위한 메서드 시작 
						 * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
						 * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
                     	++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
						//checkInsr2100Auth("TypOccuCd", lsTypOccuCd ); 
					}
    		   }
			}
		});     
   
		srhTypOccuCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent ce) {
				// 2015.11.30 추가
				displayDtilOccuInttnCd();
				}
		}); 
    
		srhTypOccuCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
			@Override
			public void handleEvent(ComponentEvent ce) {   
           
				if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
					// GWT.log(" a" + ce.getEvent().getType());
					mutilCombo = true;
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
					mutilCombo = true;
					//  GWT.log(" b" + ce.getEvent().getType());
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
					mutilCombo = false;
					//  GWT.log(" b" + ce.getEvent().getType());
				}  
			} 
		});
		//2015.11.30 추가 
		srhTypOccuCd.addListener(Events.Add,new Listener<BaseEvent>() { 
			@Override
			public void handleEvent(BaseEvent ce) {   
				displayDtilOccuInttnCd();
			} 
		}); 
		layoutContainer_21.add(srhTypOccuCd, new FormData("100%")); 
   
		LayoutContainer lcSchRight = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(1);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		frmlytSch.setDefaultWidth(0);
		lcSchRight.setLayout(frmlytSch);
   
		/** column 직종세코드 : dtilOccuInttnCd */
		srhDtilOccuInttnCd = new MSFMultiComboBox<ModelData>();
		srhDtilOccuInttnCd.setName("srhDtilOccuInttnCd");
		srhDtilOccuInttnCd.setEmptyText("--직종세선택--");
		srhDtilOccuInttnCd.getListView().setDisplayProperty("dtilOccuClsNm");
		srhDtilOccuInttnCd.getStore().add(mDtalistDtilOccuInttnCd);
		srhDtilOccuInttnCd.setWidth(100);
		srhDtilOccuInttnCd.setHideLabel(true);
		srhDtilOccuInttnCd.setReadOnly(gwtExtAuth.getReadOnlyDtilOccuInttnCd());
		srhDtilOccuInttnCd.setEnabled(gwtExtAuth.getEnableDtilOccuInttnCd());
		srhDtilOccuInttnCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
			@Override
			public void handleEvent(ComponentEvent ce) {    
				if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) { 
					mutilCombo = true;
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
					mutilCombo = true;
					//  GWT.log(" b" + ce.getEvent().getType());
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
					mutilCombo = false;
					//  GWT.log(" b" + ce.getEvent().getType());
				} else {
              
				}  
			} 
		});
		lcSchRight.add(srhDtilOccuInttnCd, new FormData("100%"));

		   lcTypOccuCd.add(layoutContainer_19,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.31));
		   lcTypOccuCd.add(layoutContainer_21,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
		   lcTypOccuCd.add(lcSchRight,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.37)); 
		layoutContainer_21.setBorders(false);
   
		layoutContainer_10.add(lcTypOccuCd, new FormData("100%"));
		layoutContainer_10.setBorders(false);

		
		
		
		fieldSet.add(layoutContainer_13);
		layoutContainer_13.setBorders(false);
		
		
		layoutContainer_13.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.26));
		layoutContainer_13.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		layoutContainer_13.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.54));
		
		
		LayoutContainer layoutContainer_15 = new LayoutContainer();
		layoutContainer_15.setLayout(new ColumnLayout());
   
		
		
		LayoutContainer layoutContainer_33 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_33.setLayout(frmlytSch);
		
		
		
		
   
		srhBusinCd = new ComboBox<BaseModel>();
		srhBusinCd.setName("srhBusinCd");
		srhBusinCd.setForceSelection(true);
		srhBusinCd.setMinChars(1);
		srhBusinCd.setDisplayField("businNm");
		srhBusinCd.setValueField("businCd");
		srhBusinCd.setTriggerAction(TriggerAction.ALL);
		srhBusinCd.setEmptyText("--사업선택--");
		srhBusinCd.setSelectOnFocus(true);
		srhBusinCd.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
		srhBusinCd.setEnabled(gwtExtAuth.getEnableBusinCd());
		srhBusinCd.setStore(lsBusinCd);
		srhBusinCd.setFieldLabel("사업");
		layoutContainer_33.add(srhBusinCd, new FormData("100%"));
		layoutContainer_33.setBorders(false);
		
		
		
		
		
		
		
		
		LayoutContainer layoutContainer_3 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_3.setLayout(frmlytSch);
   
		
		
		/*srhAqtnLssDivCd = new ComboBox<BaseModel>();
		srhAqtnLssDivCd.setName("srhAqtnLssDivCd");
		srhAqtnLssDivCd.setForceSelection(true);
		srhAqtnLssDivCd.setMinChars(1);
		srhAqtnLssDivCd.setDisplayField("commCdNm");
		srhAqtnLssDivCd.setValueField("commCd");
		srhAqtnLssDivCd.setTriggerAction(TriggerAction.ALL);
		srhAqtnLssDivCd.setEmptyText("--취득상실선택--");
		srhAqtnLssDivCd.setSelectOnFocus(true);
		//srhAqtnLssDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
		//srhAqtnLssDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd());
		srhAqtnLssDivCd.setStore(lsAqtnLssDivCd);
		srhAqtnLssDivCd.setFieldLabel("취득상실");
		lsAqtnLssDivCd.addStoreListener( new StoreListener<BaseModel>() {   
			public void handleEvent(StoreEvent<BaseModel> be) {  
				EventType type = be.getType();
				if (type == Store.Add) { 
					*//**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 
                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
                     * "srhPayrMangDeptCd","srhAqtnLssDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*//* 
                	checkInsr2100Auth("AqtnLssDivCd", lsAqtnLssDivCd ); 
				}
			}
		}); */
		
		srhHdofcCodtnCd = new MSFMultiComboBox<ModelData>();
		srhHdofcCodtnCd.setName("srhHdofcCodtnCd");
		srhHdofcCodtnCd.setEmptyText("--재직선택--");
		srhHdofcCodtnCd.setReadOnly(true);
		srhHdofcCodtnCd.setEnabled(true);
		srhHdofcCodtnCd.getListView().setDisplayProperty("commCdNm");
		srhHdofcCodtnCd.getStore().add(mDtalistHdofcCodtnCd);
		srhHdofcCodtnCd.setWidth(100);
		srhHdofcCodtnCd.setFieldLabel("재직상태");
		srhHdofcCodtnCd.getStore().addStoreListener(new StoreListener<ModelData>() {
			public void handleEvent(StoreEvent<ModelData> be) {
				checkInsr2100Auth("srhHdofcCodtnCd", lsHdofcCodtnCd);
			}
		});
		srhHdofcCodtnCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
			@Override
			public void handleEvent(ComponentEvent ce) {   
				if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
					// GWT.log(" a" + ce.getEvent().getType());
					mutilCombo = true;
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
					mutilCombo = true;
					//  GWT.log(" b" + ce.getEvent().getType());
				} else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
					mutilCombo = false;
					//  GWT.log(" b" + ce.getEvent().getType());
				}  
			} 
		});
		
		
		
		layoutContainer_3.add(srhHdofcCodtnCd, new FormData("100%"));
		layoutContainer_3.setBorders(false); 


		BaseModel bm  = new BaseModel();
		bm.set("commCd", "Z001");
		bm.set("commCdNm", "신고");
		
		applyCd.add(bm);
		
		BaseModel bm1  = new BaseModel();
		bm1.set("commCd", "Z002");
		bm1.set("commCdNm", "미신고");
		applyCd.add(bm1);
		
		LayoutContainer layoutContainer_20 = new LayoutContainer();
		
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_20.setLayout(frmlytSch);
		
		
	    applyYn = new ComboBox<BaseModel>();
		applyYn.setName("applyYn");
		applyYn.setForceSelection(true);
		applyYn.setMinChars(1);
		applyYn.setDisplayField("commCdNm");
		applyYn.setValueField("commCd");
		applyYn.setTriggerAction(TriggerAction.ALL);
		applyYn.setEmptyText("--선택--");
		applyYn.setSelectOnFocus(true);
		//srhAqtnLssDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
		//srhAqtnLssDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd());
		applyYn.setStore(applyCd);
		applyYn.setFieldLabel("신고여부");
		

		layoutContainer_20.add(applyYn, new FormData("100%"));
		layoutContainer_20.setBorders(false); 
		
		LayoutContainer layoutContainer_5 = new LayoutContainer();
		layoutContainer_5.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_6 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_6.setLayout(frmlytSch);
   
		srhHanNm = new TextField<String>();
		srhHanNm.setName("srhHanNm");
		srhHanNm.setFieldLabel("성명");
		layoutContainer_6.add(srhHanNm, new FormData("100%"));
		srhHanNm.addKeyListener(new KeyListener() {
			@Override
			public void componentKeyDown(ComponentEvent event) {
				
				srhHanNm.validate();
				if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim()
						.equals("")) {
					srhSystemkey.setValue("");
					srhResnRegnNum.setValue("");
				}
				if (event.getKeyCode() == KeyCodes.KEY_ENTER) {
					srhSystemkey.setValue("");
					srhResnRegnNum.setValue("");
					fnPopupPsnl0100();
				}
				super.componentKeyDown(event);
			}
		});
//		srhHanNm.addListener(Events.KeyUp, new Listener<BaseEvent>() {
//			@Override
//			public void handleEvent(BaseEvent be) {
//				if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim()
//						.equals("")) {
//					srhSystemkey.setValue("");
//					srhResnRegnNum.setValue("");
//				}
//			}
//		});
		layoutContainer_5.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
		layoutContainer_6.setBorders(false);
   
		Button btnHanNm = new Button("검색");
		layoutContainer_5.add(btnHanNm);
		btnHanNm.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				srhSystemkey.setValue("");
				srhResnRegnNum.setValue("");
				fnPopupPsnl0100();

			}
		});
   
		LayoutContainer layoutContainer_7 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(0);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_7.setLayout(frmlytSch);
   
		/** column 주민등록번호 : resnRegnNum */
		srhResnRegnNum = new TextField<String>();
		srhResnRegnNum.setName("srhResnRegnNum");
		new TextFieldMask<String>(srhResnRegnNum, "999999-9999999");
		srhResnRegnNum.setHideLabel(true);
		srhResnRegnNum.addListener(Events.KeyUp, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {
				if (MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()).trim()
						.equals("")) {
					srhSystemkey.setValue("");
					srhHanNm.setValue("");
				}
			}
		});
		layoutContainer_7.add(srhResnRegnNum, new FormData("100%"));
		layoutContainer_5.add(layoutContainer_7, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_7.setBorders(false);
		layoutContainer_5.setBorders(false);
		
		layoutContainer_15.add(layoutContainer_33, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.26));
		layoutContainer_15.add(layoutContainer_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		layoutContainer_15.add(layoutContainer_20, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.28));		
		layoutContainer_15.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.26));
		
		fieldSet.add(layoutContainer_15);
		
		
		plFrmInsr2150.add(fieldSet);
		// vp.add(panel);
	}

	private void  displayDtilOccuInttnCd() {
	  
		if ((srhTypOccuCd.getListView().getChecked().size() > 0)  && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
        
			//2015.11.30 권한 추가 직종변경에 따른 직종세 값 가져오기 
            sysComBass0350Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
            List<ModelData> mdDeptCdSelect =  srhDeptCd.getListView().getChecked();  
            String strDeptCd = InsrUtils.getStrValToMDMultiCombo(mdDeptCdSelect,"deptCd"); 
            sysComBass0350Dto.setDeptCd(strDeptCd);
            List<ModelData> mdListSelect =  srhTypOccuCd.getListView().getChecked(); 
            String strTypOccuCd = InsrUtils.getStrValToMDMultiCombo(mdListSelect,"typOccuCd"); 
            sysComBass0350Dto.setTypOccuCd(strTypOccuCd); 
            
           // sysComBass0350Dto.setPyspGrdeCd(PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
            
            if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
                
            	lsDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto); 
              //  srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 
                
                lsDtilOccuInttnCd.addStoreListener( new StoreListener<BaseModel>() {   
                	public void handleEvent(StoreEvent<BaseModel> be) {  
                        mDtalistDtilOccuInttnCd = InsrUtils.getDtilOccuInttnCdModelData(lsDtilOccuInttnCd) ; 
                        srhDtilOccuInttnCd.getInitStore().add(mDtalistDtilOccuInttnCd);
                        
                        if (!gwtExtAuth.getEnableDtilOccuInttnCd()) {
                    	    ModelData  mdSelect  = srhDtilOccuInttnCd.getStore().getAt(0) ;
	  		                   
                    	    srhDtilOccuInttnCd.getListView().setChecked(mdSelect, true); 
                    	    srhDtilOccuInttnCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("dtilOccuClsNm")));
                        } 
                    }
                });     
            } 
         
		} else {
			
		} 
	}
	 
	private void createForm() {
	
		dpobCd = new HiddenField<String>();   			/** column 사업장코드 : dpobCd */
		systemkey = new HiddenField<String>();  		/** column SYSTEMKEY : systemkey */ 
		socInsrAqtnEmymtNum = new HiddenField<Long>();	/** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
		socnsrAqtnRegVal04 = new HiddenField<String>(); /** column 국적 : socnsrAqtnRegVal04 popup */
		soctyInsurCmptnDtV = new HiddenField<Date>();
		
		sysComBass0300Dto.setRpsttvCd("I004"); 
		lsSocnsrAqtnRegVal05 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);    /** column 체류자격 : socnsrAqtnRegVal05 */
		sysComBass0300Dto.setRpsttvCd("I015"); 
		lsSocnsrAqtnRegVal09 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);    /** column 연금_취득부호 : socnsrAqtnRegVal09 */
		sysComBass0300Dto.setRpsttvCd("I016"); 
		lsSocnsrAqtnRegVal11 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);   /** column 연금_특수직종 : socnsrAqtnRegVal11 */
		sysComBass0300Dto.setRpsttvCd("I025"); 
		lsSocnsrAqtnRegVal12 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);    /** column 연금_직역연금부호 : socnsrAqtnRegVal12 */
		sysComBass0300Dto.setRpsttvCd("I005"); 
		lsSocnsrAqtnRegVal16 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);    /** column 건강_취득부호 : socnsrAqtnRegVal16 */
		sysComBass0300Dto.setRpsttvCd("I007"); 
		lsSocnsrAqtnRegVal18 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);   /** column 건강_감면 : socnsrAqtnRegVal18 */
		sysComBass0300Dto.setRpsttvCd("I008"); 
		lsSocnsrAqtnRegVal20 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);    /** column 건강_회계 : socnsrAqtnRegVal20 */
		sysComBass0300Dto.setRpsttvCd("I009"); 
		lsSocnsrAqtnRegVal21 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);    /** column 건강_직종 : socnsrAqtnRegVal21 */
		// sysComBass0300Dto.setRpsttvCd("A002"); 
		// lsSocnsrAqtnRegVal28 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);    /** column 고용_비고 : socnsrAqtnRegVal28 */
		sysComBass0300Dto.setRpsttvCd("I017"); 
		lsSocnsrAqtnRegVal29 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);    /** column 고용_보험료부과구분부호 : socnsrAqtnRegVal29 */
		sysComBass0300Dto.setRpsttvCd("I018"); 
		lsSocnsrAqtnRegVal30 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);   /** column 고용_보험료부과사유 : socnsrAqtnRegVal30 */
//	 sysComBass0300Dto.setRpsttvCd("A002"); 
//	 lsSocnsrAqtnRegVal37 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);    /** column 산재_비고 : socnsrAqtnRegVal37 */
		sysComBass0300Dto.setRpsttvCd("I017"); 
		lsSocnsrAqtnRegVal38 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);    /** column 산재_보험료부과구분부호 : socnsrAqtnRegVal38 */
		sysComBass0300Dto.setRpsttvCd("I018"); 
		lsSocnsrAqtnRegVal39 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);   /** column 산재_보험료부과구분사유 : socnsrAqtnRegVal39 */
	 
		LayoutContainer layoutContainer = new LayoutContainer();

		ContentPanel cp01 = new ContentPanel();
		cp01.setHeaderVisible(false);
		//엣지변환
		//cp01.setSize(975, 680);
		cp01.setSize(975, 710);
		cp01.setLayout(new FitLayout());
    
		LayoutContainer layoutContainer_16 = new LayoutContainer();

		layoutContainer_16.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(0);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1.setLayout(frmlytStd);
    
		FieldSet fldstNewFieldset = new FieldSet();

		layoutContainer_1.add(fldstNewFieldset, new FormData("100%"));

		fldstNewFieldset.setHeadingHtml("대상자정보");
		fldstNewFieldset.setCollapsible(false);
		fldstNewFieldset.add(leftGrid01(), new FormData("100%"));
		layoutContainer_16.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
    
		LayoutContainer layoutContainer_2 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(0);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2.setLayout(frmlytStd);
    
		FieldSet fldstNewFieldset_1 = new FieldSet();
		fldstNewFieldset_1.setHeadingHtml("기본정보");
		fldstNewFieldset_1.setCollapsible(false);
		fldstNewFieldset_1.add(rightForm01(), new FormData("100%"));

		layoutContainer_2.add(fldstNewFieldset_1, new FormData("100%")); 
   
		layoutContainer_16.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.65)); 
		
		LabelField lb_1 = new LabelField("취득상실 구분");
		lb_1.setStyleAttribute("padding-top", "5px");
		lb_1.setStyleAttribute("text-align", "center");
		lb_1.setStyleAttribute("vertical-align", "middle");

		LabelField lb_1_1 = new LabelField("취득");
		lb_1_1.setStyleAttribute("padding-top", "5px");
		LabelField lb_1_2 = new LabelField("상실");
		lb_1_2.setStyleAttribute("padding-top", "5px");

		aqtnYn = new MSFCheckBox();
		//aqtnYn.setReadOnly(true);
		aqtnYn.addListener(Events.OnClick, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {			
				if(lssYn.getValue()){						
					lssYn.setValue(false);	
					aqtnYn.setValue(true);
				}
				checkSelect();
			}
		});
		lssYn = new MSFCheckBox();
		//lssYn.setReadOnly(true);
		lssYn.addListener(Events.OnClick, new Listener<BaseEvent>() {
			@Override
			public void handleEvent(BaseEvent be) {			
				if(aqtnYn.getValue()){
					aqtnYn.setValue(false);	
					lssYn.setValue(true);	
				}
				checkSelect();
			}
		});
	
		FieldSet fldstNewFieldset_21 = new FieldSet();

		layoutContainer_2.add(fldstNewFieldset_21);
		fldstNewFieldset_21.setHeadingHtml("");
		fldstNewFieldset_21.setCollapsible(false);
	    
		LayoutContainer layoutContainer_14= new LayoutContainer(new ColumnLayout());
		layoutContainer_14.setStyleAttribute("vertical-align", "middle");  
		layoutContainer_14.add(lb_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.20) ); 

		layoutContainer_14.add(aqtnYn, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.06));
		layoutContainer_14.add(lb_1_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1) ); 
		layoutContainer_14.add(lssYn, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.06));
		layoutContainer_14.add(lb_1_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1) );
	
		layoutContainer_14.setBorders(true);
		fldstNewFieldset_21.add(layoutContainer_14, new FormData("100%"));
		
		LayoutContainer layoutContainer_17 = new LayoutContainer();
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(0);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_17.setLayout(frmlytStd);
    
		FieldSet fldstNewFieldset3 = new FieldSet();
		fldstNewFieldset3.setHeadingHtml("피부양자정보");
		fldstNewFieldset3.setCollapsible(false);
		fldstNewFieldset3.add(rightGrid01(), new FormData("100%"));

		layoutContainer_2.add(fldstNewFieldset3, new FormData("100%"));
		
		cp01.add(layoutContainer_16);
		
		layoutContainer.add(cp01);

		plFrmInsr2150.add(layoutContainer);
	}
	//TODO
	private void checkSelect(){
		
		if(aqtnYn.getValue()){
			readDtailData2();
			reloadRightGrid2("I0100001");
		}
		
		if(lssYn.getValue()){
			readDtailData2();
			reloadRightGrid2("I0100002");			
		}
	}
	
 
	/** 기본정보 **/
	private LayoutContainer rightForm01() { 
     
		LayoutContainer layoutContainer = new LayoutContainer();   
    
		ContentPanel cp02 = new ContentPanel();
		cp02.setHeaderVisible(false);
		//엣지변환
		//cp02.setSize(610, 70);
		cp02.setSize(610, 100);
		cp02.setLayout(new FlowLayout());
     
		LayoutContainer layoutContainer_6 = new LayoutContainer(new ColumnLayout());

		LayoutContainer layoutContainer_2_1 = new LayoutContainer();
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2_1.setLayout(frmlytSch);
     
		soctyInsurCmptnDt = new MSFDateField();   
		soctyInsurCmptnDt.setReadOnly(true);
		new DateFieldMask(soctyInsurCmptnDt, "9999.99.99");
		soctyInsurCmptnDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		soctyInsurCmptnDt.setName("soctyInsurCmptnDt");
		layoutContainer_2_1.add(soctyInsurCmptnDt, new FormData("100%"));
		soctyInsurCmptnDt.setFieldLabel("취득일자");
		layoutContainer_6.add(layoutContainer_2_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.31));
		layoutContainer_2_1.setBorders(false);
     
		LayoutContainer layoutContainer_3 = new LayoutContainer();
		layoutContainer_3.setBorders(false);
		// layoutContainer_3.setBorders(true);
		FormLayout frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_3.setLayout(frmlytStd);
     
		socnsrAqtnRegVal02 = new MSFTextField();
		socnsrAqtnRegVal02.setReadOnly(true);
		layoutContainer_3.add(socnsrAqtnRegVal02, new FormData("100%"));
		socnsrAqtnRegVal02.setFieldLabel("성명");
		layoutContainer_6.add(layoutContainer_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.23));

		LayoutContainer layoutContainer_4 = new LayoutContainer();
		layoutContainer_4.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(0);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_4.setLayout(frmlytStd);

		socnsrAqtnRegVal03 = new MSFTextField();
		socnsrAqtnRegVal03.setReadOnly(true);
		layoutContainer_4.add(socnsrAqtnRegVal03, new FormData("100%"));
		socnsrAqtnRegVal03.setHideLabel(true);
		layoutContainer_6.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.16));
     
		/** 고용구분 */
		LayoutContainer layoutContaineri_4 = new LayoutContainer();
		layoutContaineri_4.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContaineri_4.setLayout(frmlytStd);

		emymtDivNm = new MSFTextField();
		emymtDivNm.setReadOnly(true);
		layoutContaineri_4.add(emymtDivNm, new FormData("100%"));
		emymtDivNm.setFieldLabel("고용구분");
		layoutContainer_6.add(layoutContaineri_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
    
		cp02.add(layoutContainer_6, new FormData("100%"));

		LayoutContainer layoutContainera7 = new LayoutContainer();
		layoutContainera7.setLayout(new ColumnLayout());

		LayoutContainer layoutContainera_1 = new LayoutContainer();
		layoutContainera_1.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainera_1.setLayout(frmlytStd);

		socInsrAqtnEmymtNumV  = new MSFTextField();
		 layoutContainera_1.add(socInsrAqtnEmymtNumV, new FormData("100%"));
		 socInsrAqtnEmymtNumV.setReadOnly(true);
		 socInsrAqtnEmymtNumV.setFieldLabel("일련번호");
		 layoutContainera7.add(layoutContainera_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.31));
     
		LayoutContainer layoutContainera_2 = new LayoutContainer();
		layoutContainera_2.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainera_2.setLayout(frmlytStd);

		deptNm = new MSFTextField();
		deptNm.setReadOnly(true);
		layoutContainera_2.add(deptNm, new FormData("100%"));
		deptNm.setFieldLabel("부서");

		layoutContainera7.add(layoutContainera_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.39));
     

		LayoutContainer layoutContainerb_2 = new LayoutContainer();
		layoutContainerb_2.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(60);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainerb_2.setLayout(frmlytStd);

		typOccuNm = new MSFTextField();
		typOccuNm.setReadOnly(true);
		layoutContainerb_2.add(typOccuNm, new FormData("100%"));
		typOccuNm.setFieldLabel("직종");

		layoutContainera7.add(layoutContainerb_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));

		cp02.add(layoutContainera7, new FormData("100%"));

		LayoutContainer layoutContainer18 = new LayoutContainer();
		layoutContainer18.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer18_1 = new LayoutContainer();
		layoutContainer18_1.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer18_1.setLayout(frmlytStd);
     
		tempComPunNm = new MSFTextField();
		layoutContainer18_1.add(tempComPunNm, new FormData("100%"));
		tempComPunNm.setFieldLabel("전화번호(사업장)");
		
		tempComPunNm.setReadOnly(true);
		
		layoutContainer18.add(layoutContainer18_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		LayoutContainer layoutContainer18_2 = new LayoutContainer();
		layoutContainer18_2.setBorders(false);
		frmlytStd = new FormLayout();
		frmlytStd.setLabelWidth(100);
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer18_2.setLayout(frmlytStd);
     
		tempHuPunNm = new MSFTextField();
		layoutContainer18_2.add(tempHuPunNm, new FormData("100%"));
		tempHuPunNm.setFieldLabel("전화번호(가입)");
		
		tempHuPunNm.setReadOnly(true);
		
		layoutContainer18.add(layoutContainer18_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));

		cp02.add(layoutContainer18, new FormData("100%"));

		layoutContainer.add(cp02);

		return layoutContainer;
	}

	private  LayoutContainer leftGrid01() {
	   
		LayoutContainer lcStdGrid = new LayoutContainer();
		// lcStdGrid.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytStd = new FormLayout();
		// frmlytStd.setLabelWidth(85);
		// frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		lcStdGrid.setLayout(frmlytStd);

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		//엣지변환
		//cp01.setSize(327, 570);
		cp01.setSize(327, 600);
		   
		insr1100GridPanel = new MSFGridPanel(insr1100Def, false, false, false,false, false);
		insr1100GridPanel.setHeaderVisible(false);
		insr1100GridPanel.setBodyBorder(true);
		insr1100GridPanel.setBorders(true);
		final Grid<?> insr1100Grid = insr1100GridPanel.getMsfGrid().getGrid();
		insr1100Grid.addListener(Events.CellDoubleClick,new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				
				detailClear();
				if (insr1100GridPanel.getCurrentlySelectedItem() != null) {
					setRecord(insr1100GridPanel.getCurrentlySelectedItem());

					dpobCd.setValue(MSFSharedUtils.allowNulls(insr1100GridPanel.getCurrentlySelectedItem().get("dpobCd")));					/** column 사업장코드 : dpobCd */
					systemkey.setValue(MSFSharedUtils.allowNulls(insr1100GridPanel.getCurrentlySelectedItem().get("systemkey")));				/** column SYSTEMKEY : systemkey */
					
					
					soctyInsurCmptnDtV.setValue(InsrUtils.getConvertStringToDate((String) insr1100GridPanel.getCurrentlySelectedItem().get("socnsrAqtnRegVal17"), "yyyyMMdd"));			/** column 사회보험작성일자 : soctyInsurCmptnDt */
					socInsrAqtnEmymtNum.setValue(Long.parseLong(MSFSharedUtils.defaultNulls(insr1100GridPanel.getCurrentlySelectedItem().get("socInsrAqtnEmymtNum"),"0")));	/** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */

					readDtailData();
					reloadRightGrid();

					actionDatabase = ActionDatabase.UPDATE;
				}
			}
		});

		cp01.add(insr1100GridPanel);

		lcStdGrid.add(cp01);

		return lcStdGrid;  
	}
	
	/** 피부양자정보 정보 그리드 **/
	private  LayoutContainer rightGrid01() {
	   
		LayoutContainer lcStdGrid = new LayoutContainer();
		FormLayout frmlytStd = new FormLayout();
		lcStdGrid.setLayout(frmlytStd);

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(620, 400);

		insr1500GridPanel = new MSFGridPanel(insr1500Def, false, false, false,false, false);
		insr1500GridPanel.setHeaderVisible(false);
		insr1500GridPanel.setBodyBorder(true);
		insr1500GridPanel.setBorders(true);
		
		insr1500GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 2, new HeaderGroupConfig("가입자", 1, 4));
		insr1500GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 5, new HeaderGroupConfig("대상자", 1, 14));
		//insr1500GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 18, new HeaderGroupConfig("신고여부", 1, 2));
		insr1500GridPanel.getGrid().getColumnModel().addHeaderGroup(1, 4, new HeaderGroupConfig("전화번호", 1, 2));
		insr1500GridPanel.getGrid().getColumnModel().addHeaderGroup(1, 9, new HeaderGroupConfig("취득/상실", 1, 3));
		insr1500GridPanel.getGrid().getColumnModel().addHeaderGroup(1, 12, new HeaderGroupConfig("장애인,국가유공자(대상자)", 1, 3));
		insr1500GridPanel.getGrid().getColumnModel().addHeaderGroup(1, 15, new HeaderGroupConfig("외국인(대상자)", 1, 5));
		/*
		insr1500GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 1, new HeaderGroupConfig("", 1, 7));
		insr1500GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 8, new HeaderGroupConfig("장애인", 1, 3));
		insr1500GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 11, new HeaderGroupConfig("외국인", 1, 3));
		*/
		final Grid<?> insr1500Grid = insr1500GridPanel.getMsfGrid().getGrid();
		insr1500Grid.addListener(Events.CellDoubleClick,new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
			}
		});

		cp01.add(insr1500Grid);

		lcStdGrid.add(cp01);
		
		ButtonBar btnGridBar = new ButtonBar();
		btnGridBar.setAlignment(HorizontalAlignment.RIGHT);
		
		Button btnFmlSel = new Button("가족선택");
		btnFmlSel.setIcon(MSFMainApp.ICONS.new16());
		btnGridBar.add(btnFmlSel);
		btnFmlSel.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				insertInsr1550();
			}
		});
		
		Button topBtn = new Button("저장");
		topBtn.setIcon(MSFMainApp.ICONS.save16());
		btnGridBar.add(topBtn);
		topBtn.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {

				if(aqtnYn.getValue() == true && lssYn.getValue() == true){
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "취득상실 구분을 중복 선택할 수 없습니다.", null);
					return;
				}	

				int panelSize = insr1500GridPanel.getMsfGrid().getStore().getModifiedRecords().size();
				if (panelSize <1) {
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), "데이타를 확인해 주세요.", null);
				}
				else {

					MessageBox.confirm("피부양자취득상실신고 저장", "선택하신 대상자를 저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
						@Override
						public void handleEvent(MessageBoxEvent be) {
							//if("Yes".equals(be.getButtonClicked().getText())){
							if(Dialog.YES.equals(be.getButtonClicked().getItemId())){

								setListRecord(insr1500GridPanel.getMsfGrid().getStore().getModifiedRecords().iterator()); 
								actionDatabase = ActionDatabase.UPDATE;
								doAction(actionDatabase);

							}
						}

					});


				}
			}
		});

		Button btnFmlDel = new Button("삭제");
		btnFmlDel.setIcon(MSFMainApp.ICONS.new16());
		btnGridBar.add(btnFmlDel);
		btnFmlDel.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {

				if(0 < insr1500GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().size()){

					MessageBox.confirm("피부양자취득상실신고 삭제", "선택하신 대상자를 삭제 하시겠습니까?",new Listener<MessageBoxEvent>(){
						@Override
						public void handleEvent(MessageBoxEvent be) {
							//if("Yes".equals(be.getButtonClicked().getText())){
							if(Dialog.YES.equals(be.getButtonClicked().getItemId())){


								Iterator<BaseModel> itBm  = insr1500GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();

								List<Record>  lsRec  = new ArrayList<Record>();

								while(itBm.hasNext()) {
									Record rec  = new Record(itBm.next()); 
									lsRec.add(rec);
								} 
								setListRecord(lsRec.iterator()); 

								actionDatabase = ActionDatabase.DELETE;
								doAction(actionDatabase);


							}
						}

					});


				}else{
					MessageBox.alert(actionDatabase.name() + "선택", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
					return;
				}
			}
		});
		
		lcStdGrid.add(btnGridBar);

		return lcStdGrid;  
	}

	public void reload() {
		   
		IColumnFilter filters = null;
			
		insr1100GridPanel.getTableDef().setTableColumnFilters(filters);
			
		insr1100GridPanel.getTableDef().addColumnFilter("soctyInsurCmptnDt01",  InsrUtils.getConvertDateToString(srhSoctyInsurCmptnDt01, "yyyyMMdd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		insr1100GridPanel.getTableDef().addColumnFilter("soctyInsurCmptnDt02",  InsrUtils.getConvertDateToString(srhSoctyInsurCmptnDt02, "yyyyMMdd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			
		insr1100GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);
		insr1100GridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		//insr1100GridPanel.getTableDef().addColumnFilter("payCd", MSFSharedUtils.getSelectedComboValue(srhPayCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			 
		//20180305추가 
		insr1100GridPanel.getTableDef().addColumnFilter("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
				
		String strDeptCd = InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
		insr1100GridPanel.getTableDef().addColumnFilter("deptCd", strDeptCd , SimpleColumnFilter.OPERATOR_EQUALS);
           
		String strTypOccuCd = InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"); 
		insr1100GridPanel.getTableDef().addColumnFilter("typOccuCd", strTypOccuCd, SimpleColumnFilter.OPERATOR_EQUALS); 
//            String strPyspGrdeCd = InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd");  
//            insr1100GridPanel.getTableDef().addColumnFilter("pyspGrdeCd", strPyspGrdeCd, SimpleColumnFilter.OPERATOR_EQUALS);  
		String strDtilOccuInttnCd = InsrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
		insr1100GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
          
			//insr1100GridPanel.getTableDef().addColumnFilter("deptCd", MSFSharedUtils.allowNulls(srhDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
			//insr1100GridPanel.getTableDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			//insr1100GridPanel.getTableDef().addColumnFilter("pyspGrdeCd",  MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"pyspGrdeCd") , SimpleColumnFilter.OPERATOR_EQUALS); 
			//insr1100GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", MSFSharedUtils.getSelectedComboValue(srhDtilOccuInttnCd,"dtilOccuInttnCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
          
		insr1100GridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		insr1100GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
		insr1100GridPanel.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS);    
		insr1100GridPanel.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS);  
			 
		String famyQuftDivCdStr = MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhAqtnLssDivCd,"commCd"));
		
		insr1100GridPanel.getTableDef().addColumnFilter("famyQuftDivCd",famyQuftDivCdStr,SimpleColumnFilter.OPERATOR_EQUALS); /** column 취득상실 구분 */
		
		 
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
		
		insr1100GridPanel.getTableDef().addColumnFilter("hdofcCodtnCd", strHdofcCodtnCd, SimpleColumnFilter.OPERATOR_EQUALS);
		
		
		
		String applyStr = MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(applyYn,"commCd"));
		
		
		if(famyQuftDivCdStr.equals("")){
			if(applyStr.equals("Z001")){
				insr1100GridPanel.getTableDef().addColumnFilter("applyAqtnLssYn", "Y", SimpleColumnFilter.OPERATOR_EQUALS);  
			}
			if(applyStr.equals("Z002")){
				insr1100GridPanel.getTableDef().addColumnFilter("applyAqtnLssYn", "N", SimpleColumnFilter.OPERATOR_EQUALS);  
			}
		}
		
		if(famyQuftDivCdStr.equals("I0100001")){  
			if(applyStr.equals("Z001")){
				insr1100GridPanel.getTableDef().addColumnFilter("applyAqtnYn", "Y", SimpleColumnFilter.OPERATOR_EQUALS);  
			}
			if(applyStr.equals("Z002")){
				insr1100GridPanel.getTableDef().addColumnFilter("applyAqtnYn", "N", SimpleColumnFilter.OPERATOR_EQUALS);  
			}
		}	
		if(famyQuftDivCdStr.equals("I0100002")){
			if(applyStr.equals("Z001")){
				insr1100GridPanel.getTableDef().addColumnFilter("applyLssYn", "Y", SimpleColumnFilter.OPERATOR_EQUALS);  
			}
			if(applyStr.equals("Z002")){
				insr1100GridPanel.getTableDef().addColumnFilter("applyLssYn", "N", SimpleColumnFilter.OPERATOR_EQUALS);  
			}
		}
		
		
		//Window.alert(applyStr);
		
		
		
		
		
		
		insr1100GridPanel.reload();
			
		actionDatabase = ActionDatabase.UPDATE;
	}
	
	public void reloadRightGrid() {
		   
		IColumnFilter filters = null;
		insr1500GridPanel.getTableDef().setTableColumnFilters(filters);

		insr1500GridPanel.getTableDef().addColumnFilter("dpobCd",MSFSharedUtils.allowNulls(dpobCd.getValue()),SimpleColumnFilter.OPERATOR_EQUALS); // 사업장코드
		insr1500GridPanel.getTableDef().addColumnFilter("systemkey",MSFSharedUtils.allowNulls(systemkey.getValue()),SimpleColumnFilter.OPERATOR_EQUALS); /** column SYSTEMKEY : systemkey */
		insr1500GridPanel.getTableDef().addColumnFilter("famyAqtnLssNum",MSFSharedUtils.allowNulls(socInsrAqtnEmymtNum.getValue()),SimpleColumnFilter.OPERATOR_EQUALS); /** column 사회보험취득_고용_일련번호 : famyAqtnLssNum */
		
		if(aqtnYn.getValue() == true && lssYn.getValue() == true){
			insr1500GridPanel.getTableDef().addColumnFilter("aqtnDivCd","",SimpleColumnFilter.OPERATOR_EQUALS); /** column 취득상실 구분 */
		}else{
			if(aqtnYn.getValue()){
				insr1500GridPanel.getTableDef().addColumnFilter("aqtnDivCd","I0100001",SimpleColumnFilter.OPERATOR_EQUALS); /** column 취득상실 구분 */
			}else if(lssYn.getValue()){
				insr1500GridPanel.getTableDef().addColumnFilter("aqtnDivCd","I0100002",SimpleColumnFilter.OPERATOR_EQUALS); /** column 취득상실 구분 */
			}
		}
		insr1500GridPanel.reload();

	}
	
	public void reloadRightGrid2(String aqtnDivCd) {
		   
		IColumnFilter filters = null;
		insr1500GridPanel.getTableDef().setTableColumnFilters(filters);

		insr1500GridPanel.getTableDef().addColumnFilter("dpobCd",MSFSharedUtils.allowNulls(dpobCd.getValue()),SimpleColumnFilter.OPERATOR_EQUALS); // 사업장코드
		insr1500GridPanel.getTableDef().addColumnFilter("systemkey",MSFSharedUtils.allowNulls(systemkey.getValue()),SimpleColumnFilter.OPERATOR_EQUALS); /** column SYSTEMKEY : systemkey */
		insr1500GridPanel.getTableDef().addColumnFilter("famyAqtnLssNum",MSFSharedUtils.allowNulls(socInsrAqtnEmymtNum.getValue()),SimpleColumnFilter.OPERATOR_EQUALS); /** column 사회보험취득_고용_일련번호 : famyAqtnLssNum */
		insr1500GridPanel.getTableDef().addColumnFilter("aqtnDivCd",aqtnDivCd,SimpleColumnFilter.OPERATOR_EQUALS); /** column 취득상실 구분 */

		insr1500GridPanel.reload();
	}
	
	//폼초기화 검색조건포함 
	private void formInit() {
//		setInitDate();
//		srhHdofcCodtnCd.setValue("");					//재직상태
//		srhPayrMangDeptCd.setValue(new BaseModel());	//단위기간
//		srhHanNm.setValue("");							//성명
//		srhResnRegnNum.setValue("");					//주민번호
//		srhEmymtDivCd.setValue(new BaseModel());		// 고용구분
//		srhDeptCd.setValue("");							//부서
//		srhTypOccuCd.setValue(""); 						//직종
//		srhDtilOccuInttnCd.setValue("");				//직종세	
//		srhBusinCd.setValue(new BaseModel());			//사업
//		srhAqtnLssDivCd.setValue(new BaseModel()); //취득상실
		
		//그리드 삭제
		insr1100GridPanel.getMsfGrid().clearData();
		insr1500GridPanel.getMsfGrid().clearData();
		//디테일 값 초기화
		detailClear();
	}
	
	//디테일 값 초기화
	private void detailClear() {
		systemkey.clear(); 
		soctyInsurCmptnDt.clear();
		socnsrAqtnRegVal02.clear(); 
		socnsrAqtnRegVal03.clear(); 
		emymtDivNm.clear(); 
		deptNm.clear();
		typOccuNm.clear();
		socInsrAqtnEmymtNumV.clear();
		tempComPunNm.clear();
		tempHuPunNm.clear();
		aqtnYn.clear();
		lssYn.clear();
	}

	public void setRecord(BaseModel record) {
		this.record = record;
	}

	public void setListRecord(Iterator<Record> records) {
		this.records = records;
	}

	public Iterator<Record> getListRecord() {
		return this.records;
	}

	private Insr2150 getThis() {
		return this;
	}
	   
	private void fnPopupPsnl0100() {
		// 검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
		// 넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
		// 검색.처리하면됨.
		MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpPrgmCom0100Form(srhHanNm.getValue()); // 인사
		// MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpMsfCom0120Form();
		// //우편번호

		final FormBinding popBindingCom0100 = popCom0100.getFormBinding();

		popBindingCom0100.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				BaseModel mapModel = (BaseModel) be.getSource();
				if (!"".equals(mapModel.get("systemkey"))) {
					srhSystemkey.setValue(MSFSharedUtils.allowNulls(mapModel.get("systemkey"))); // 시스템키
					srhHanNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("hanNm")));
					srhResnRegnNum.setValue(MSFSharedUtils.allowNulls(mapModel.get("resnRegnNum"))); // 주민번호
				}
			}
		});
	}
	
	public void setPPRecord(BaseModel ppRecord) {
		this.ppRecord = ppRecord;
	}   		   
    	
	private void setInitDate() {

		Date today = new Date();
		int maxDays = 0;
		Calendar intiCal = Calendar.getInstance();
		intiCal.set(Integer.parseInt(GWTUtils.getStringFromDate(today, "yyyy")),
				Integer.parseInt(GWTUtils.getStringFromDate(today, "MM")) - 1,
				1);
		srhSoctyInsurCmptnDt01.setValue(intiCal.getTime());
		maxDays = intiCal.getActualMaximum(intiCal.DAY_OF_MONTH);

		if ("02".equals(GWTUtils.getStringFromDate(today, "MM")) && maxDays != 28) {
			maxDays = 28;
		} else if ("04".equals(GWTUtils.getStringFromDate(today, "MM")) && maxDays != 30) {
			maxDays = 30;
		} else if ("06".equals(GWTUtils.getStringFromDate(today, "MM")) && maxDays != 30) {
			maxDays = 30;
		} else if ("09".equals(GWTUtils.getStringFromDate(today, "MM")) && maxDays != 30) {
			maxDays = 30;
		} else if ("11".equals(GWTUtils.getStringFromDate(today, "MM")) && maxDays != 30) {
			maxDays = 30;
		}
		Calendar intieCal = Calendar.getInstance();
		intieCal.set(
				Integer.parseInt(GWTUtils.getStringFromDate(today, "yyyy")),
				Integer.parseInt(GWTUtils.getStringFromDate(today, "MM")) - 1,
				maxDays);
		// intiCal.add(Calendar.DATE, maxDays - 1);
		// GWT.log("일수" +
		// DateTimeFormat.getFormat("yyyy.MM.dd").format(intiCal.getTime()));
		srhSoctyInsurCmptnDt02.setValue(intieCal.getTime());
	}
	
	//excelFileExport
	private void excelFileExport() {
		
		//if (insr1100GridPanel.getCurrentlySelectedItem() != null) {  
			
		String famyQuftDivCdStr = MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhAqtnLssDivCd,"commCd"));
		
		if(famyQuftDivCdStr == null || famyQuftDivCdStr.equals("")){
			Window.alert("취득상실을 선택하세요.");
			return;
		}
		
		
			HashMap<String, String> param = new HashMap<String, String>(); 
			
			//그리드 선택 데이터 출력
			String checkedSystemKeys = "";
			int keyCnt = 0;
			List<BaseModel> list = insr1100GridPanel.getGrid().getSelectionModel().getSelectedItems();

			if(list != null && list.size() > 0){
				String chkSysKey = "";
				int iCnt = 0;

				for(BaseModel bm : list){
					chkSysKey += bm.get("systemkey")+",";
					iCnt = iCnt + 1;
				}
				keyCnt = iCnt;
				checkedSystemKeys = chkSysKey.substring(0,chkSysKey.length()-1); //$10 시스템키   

				//시스템키는 넘기지 않고 검색조건만 넘김	
				if(keyCnt > 200) {
					MessageBox.confirm("알림", "대상자를 200명 이상 선택할 경우 전체출력합니다.",new Listener<MessageBoxEvent>(){
						@Override
						public void handleEvent(MessageBoxEvent be) {
							
							//if("Yes".equals(be.getButtonClicked().getText())){
							if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
								systemKeys = "";
							}else {
								return;
							}
						}
					});
					//선택한 시스템키 넘김
				}else {
					systemKeys = checkedSystemKeys;
				}
			}
			
			if (insr1100GridPanel.getCurrentlySelectedItem() == null) {  
				systemKeys = "";
			}
			
			//param.put("dpobCd", dpobCd.getValue());
			//param.put("socInsrAqtnEmymtNum", String.valueOf(socInsrAqtnEmymtNum.getValue()));
			//param.put("systemkey", systemkey.getValue()); 
			//param.put("systemkey", MSFSharedUtils.allowNulls(systemKeys));
			
			
			param.put("soctyInsurCmptnDt01",  GWTUtils.getStringFromDate(srhSoctyInsurCmptnDt01.getValue(),"yyyyMMdd")); 
			param.put("soctyInsurCmptnDt02",  GWTUtils.getStringFromDate(srhSoctyInsurCmptnDt02.getValue(),"yyyyMMdd")); 			
			param.put("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));		//단위기관
			param.put("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"));
		    param.put("deptCd", InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd"));
			param.put("typOccuCd", InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"));
			param.put("dtilOccuInttnCd", InsrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));
			param.put("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"));
			param.put("systemkey", MSFSharedUtils.allowNulls(systemKeys));
			param.put("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()));
			param.put("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()));    
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
		    param.put("hdofcCodtnCd", strHdofcCodtnCd); 
			param.put("famyQuftDivCd", famyQuftDivCdStr);

			String applyStr = MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(applyYn,"commCd"));

			if(famyQuftDivCdStr == null || famyQuftDivCdStr.equals("")){
				if(applyStr.equals("Z001")){
					param.put("applyAqtnLssYn", "Y");
				}else if(applyStr.equals("Z002")){
					param.put("applyAqtnLssYn", "N");
				}
				//param.put("applyAqtnYn", "");
				//param.put("applyLssYn", "");
			}else{				 
			   if(famyQuftDivCdStr.equals("I0100001")){
					if(applyStr.equals("Z001")){
						param.put("applyAqtnYn", "Y");
					}else if(applyStr.equals("Z002")){
						param.put("applyAqtnYn", "N");
					}else{
						//param.put("applyAqtnYn", "");
					}
					//param.put("applyLssYn", "");
				}else if(famyQuftDivCdStr.equals("I0100002")){
					if(applyStr.equals("Z001")){
						param.put("applyLssYn", "Y");
					}else if(applyStr.equals("Z002")){
						param.put("applyLssYn", "N");
					}else{
						//param.put("applyLssYn", "");
					}
					//param.put("applyAqtnYn", "");
				}
			   //param.put("applyAqtnLssYn", "");
			}
			
			insr1100GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsFileInsr2100_1550Export.do","extgwtFrame" ,param);
		//}
		//else{ 
		//	MessageBox.info("", "대상자를 선택해주세요.", null);  
		//}
	}	 


	private void RexPrint(String fileName) {

		
		
		
		printFileName = new String();
		printFileName = fileName;

		String payrMangDeptCd = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd");
		String emymtDivCd = MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd");
		String deptCd = InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");		
		String businCd = MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd");

		systemKeys = new String();
		systemKeys = MSFSharedUtils.allowNulls(systemkey.getValue());
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
		
		
		
		if(payrMangDeptCd != null && !payrMangDeptCd.equals("") && emymtDivCd != null && !emymtDivCd.equals("")){
			if(emymtDivCd.equals("A0020010")){
			}else if(emymtDivCd.equals("A0020020")){
				if(deptCd == null || deptCd.equals("")){
					Window.alert("부서를 선택해 주세요");
					return;
				}	
				if(businCd == null || businCd.equals("")){	
					Window.alert("사업을 선택해 주세요");
					return;
				}
			}else{
				Window.alert("고용구분을 선택해 주세요");
				return;
			}
		}else{
			Window.alert("단위기관/고용구분을 선택해 주세요");
			return;
		}

		String famyQuftDivCdStr = MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhAqtnLssDivCd,"commCd"));
		
		if(famyQuftDivCdStr == null || famyQuftDivCdStr.equals("")){
			Window.alert("취득상실을 선택하세요.");
			return;
		}
		

		//그리드 선택 데이터 출력
		String checkedSystemKeys = "";
		int keyCnt = 0;
		List<BaseModel> list = insr1100GridPanel.getGrid().getSelectionModel().getSelectedItems();


		if(list != null && list.size() > 0){
			String chkSysKey = "";
			int iCnt = 0;

			for(BaseModel bm : list){
				chkSysKey += bm.get("systemkey")+",";					
				iCnt = iCnt + 1;
			}
			keyCnt = iCnt;
			checkedSystemKeys = chkSysKey.substring(0,chkSysKey.length()-1); //$10 시스템키   

			//시스템키는 넘기지 않고 검색조건만 넘김	
			if(keyCnt > 200) {
				MessageBox.confirm("알림", "대상자를 200명 이상 선택할 경우 전체출력합니다.",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							systemKeys = "";
						}else {
							return;
						}
					}
				});
				//선택한 시스템키 넘김
			}else {
				systemKeys = checkedSystemKeys;
			}

		}else{
			systemKeys = "";
		}

		//인쇄시 마스터 업데이트

		BaseModel baseModel = new BaseModel();

		baseModel.set("soctyInsurCmptnDt01", GWTUtils.getStringFromDate(srhSoctyInsurCmptnDt01.getValue(),"yyyyMMdd"));
		baseModel.set("soctyInsurCmptnDt02", GWTUtils.getStringFromDate(srhSoctyInsurCmptnDt02.getValue(),"yyyyMMdd"));
		baseModel.set("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
		baseModel.set("emymtDivCd", MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"));
		baseModel.set("deptCd", InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd"));
		baseModel.set("typOccuCd", InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd"));
		baseModel.set("dtilOccuInttnCd", InsrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd"));
		baseModel.set("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd"));
		baseModel.set("systemkey", MSFSharedUtils.allowNulls(systemKeys));
		baseModel.set("hanNm", MSFSharedUtils.allowNulls(srhHanNm.getValue()));
		baseModel.set("resnRegnNum", MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()));		   
		baseModel.set("hdofcCodtnCd", strHdofcCodtnCd); 

		baseModel.set("famyQuftDivCd", famyQuftDivCdStr);
		
		
		String applyStr = MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(applyYn,"commCd"));

		if(famyQuftDivCdStr == null || famyQuftDivCdStr.equals("")){
			if(applyStr.equals("Z001")){
				baseModel.set("applyAqtnLssYn", "Y");
			}else if(applyStr.equals("Z002")){
				baseModel.set("applyAqtnLssYn", "N");
			}
		}else{				 
		   if(famyQuftDivCdStr.equals("I0100001")){
				if(applyStr.equals("Z001")){
					baseModel.set("applyAqtnYn", "Y");
				}else if(applyStr.equals("Z002")){
					baseModel.set("applyAqtnYn", "N");
				}
			}else if(famyQuftDivCdStr.equals("I0100002")){
				if(applyStr.equals("Z001")){
					baseModel.set("applyLssYn", "Y");
				}else if(applyStr.equals("Z002")){
					baseModel.set("applyLssYn", "N");
				}
			}
		}

		
		
		actionDatabase = ActionDatabase.UPDATE;
		insr2100Service.activityOnUpdateInsr1550AndInsr1600(baseModel,  new AsyncCallback<Long>() {

			public void onFailure(Throwable caught) {
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
						MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnUpdateInsr2100(Save) : " + caught), null);
			}
			public void onSuccess(Long result) {  
				if (result == 0) {
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
				} else {
					//MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), actionDatabase + "처리가 완료되었습니다.", null);
					RexPrint2(printFileName);
					
				} 
			} 
		
		});
		//TODO 추후 신고여부 업데이트 후 주석처리
		//RexPrint2(printFileName);
	}

    	
	private void RexPrint2(String fileName) {
		
		// 출력물 디렉토리 패스경로 인사 : PSNL  //  급여 : PAYR // 보험 : INSR
		String strDirPath = "INSR";
		// mrd 출력물
		String rexFileName = fileName+".crf";
		// 보낼 파라미터  
		// 검색조건
		String serarchParam = "";

		String soctyInsurCmptnDt01 = GWTUtils.getStringFromDate(srhSoctyInsurCmptnDt01.getValue(),"yyyyMMdd");
		String soctyInsurCmptnDt02 = GWTUtils.getStringFromDate(srhSoctyInsurCmptnDt02.getValue(),"yyyyMMdd");
		String payrMangDeptCd = MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd");
		String emymtDivCd = MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd");
		String deptCd = InsrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");
		String typOccuCd = InsrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","typOccuCd");
		String dtilOccuInttnCd = InsrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");
		String businCd = MSFSharedUtils.getSelectedComboValue(srhBusinCd,"businCd");
		String hanNm = MSFSharedUtils.allowNulls(srhHanNm.getValue());
		String resnRegnNum = MSFSharedUtils.allowNulls(srhResnRegnNum.getValue());
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

		String deptCdAuth = MSFSharedUtils.allowNulls(InsrUtils.getStrValToBMMultiCombo(lsDeptCd,MSFSharedUtils.allowNulls(srhDeptCd.getValue()),"deptNmRtchnt","deptCd")).replace(",", ""); 
		String dtilOccuInttnCdAuth =  MSFSharedUtils.allowNulls(InsrUtils.getStrValToBMMultiCombo(lsDtilOccuInttnCd,MSFSharedUtils.allowNulls(srhDtilOccuInttnCd.getValue()),"dtilOccuClsNm","dtilOccuInttnCd")).replace(",", "");
		//String aqtnDivCd = MSFSharedUtils.getSelectedComboValue(srhAqtnLssDivCd,"commCd");
		String famyQuftDivCdStr = MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(srhAqtnLssDivCd,"commCd"));


		if(soctyInsurCmptnDt01 != null && !"".equals(soctyInsurCmptnDt01)){

			//도장 출력을 위해 추가 2014-11-06 //$9
			String myImgUrl = MSFMainApp.getMsg("PayGen.MyPhotoUrl");
			if(MSFSharedUtils.paramNull(myImgUrl)) {
				// myImgUrl = "http://105.19.10.32:8080";
				//경로오류 출력 
			}	


			serarchParam += ""+MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd())+"⊥";//$1
			serarchParam += ""+MSFSharedUtils.allowNulls(soctyInsurCmptnDt01)+"⊥";	//$2			
			serarchParam += ""+MSFSharedUtils.allowNulls(soctyInsurCmptnDt02)+"⊥";	//$3			
			serarchParam += ""+MSFSharedUtils.allowNulls(payrMangDeptCd)+"⊥";		//$4
			serarchParam += ""+MSFSharedUtils.allowNulls(emymtDivCd)+"⊥";		//$5
			serarchParam += ""+MSFSharedUtils.allowNulls(deptCd)+"⊥";			//$6	
			serarchParam += ""+MSFSharedUtils.allowNulls(typOccuCd)+"⊥";			//$7
			serarchParam += ""+MSFSharedUtils.allowNulls(dtilOccuInttnCd)+"⊥";			 //$8
			serarchParam += ""+MSFSharedUtils.allowNulls(businCd)+"⊥";   //$9

			serarchParam += ""+MSFSharedUtils.allowNulls(systemKeys)+"⊥";	//$10
			serarchParam += ""+MSFSharedUtils.allowNulls(hanNm)+"⊥";		//$11
			serarchParam += ""+MSFSharedUtils.allowNulls(resnRegnNum)+"⊥";		//$12	
			serarchParam += ""+MSFSharedUtils.allowNulls(strHdofcCodtnCd)+"⊥";		//$13				 			        

			//20151212-변경추가 시작 
			serarchParam += ""+MSFMainApp.get().getUser().getUsrId()+"⊥";  //$14 //유우져 아이디 넘김 
			serarchParam += ""+MSFMainApp.get().getUser().getPayrMangDeptYn()+"⊥"; //$15

			//권한처리를위해 넘기는 변수 2개추가 
			serarchParam += ""+deptCdAuth+"⊥"; //$16 부서 
			serarchParam += ""+dtilOccuInttnCdAuth+"⊥"; //$17 직종세 
			//20151212-추가 끝 
			serarchParam += ""+MSFSharedUtils.allowNulls(myImgUrl)+"⊥"; //$18

			serarchParam += ""+famyQuftDivCdStr+"⊥"; //$19 취득/상실 구분

			if(famyQuftDivCdStr.equals("I0100001")){
				serarchParam += ""+famyQuftDivCdStr+"⊥"; //$20 취득 파라메터
			}else{
				serarchParam += "⊥"; 
			}

			if(famyQuftDivCdStr.equals("I0100002")){
				serarchParam += ""+famyQuftDivCdStr+"⊥"; //$21 상실 파라메터
			}else{
				serarchParam += "⊥"; 
			}

			String applyStr = MSFSharedUtils.allowNulls(MSFSharedUtils.getSelectedComboValue(applyYn,"commCd"));

			if(famyQuftDivCdStr.equals("I0100001")){
				if(applyStr.equals("Z001")){						
					serarchParam += "Y⊥";               //$22 취득 신고여부
				}else if(applyStr.equals("Z002")){
					serarchParam += "N⊥"; 
				}else{
					serarchParam += "⊥"; 
				}
			}else{
				serarchParam += "⊥"; 
			}
			
			if(famyQuftDivCdStr.equals("I0100002")){
				if(applyStr.equals("Z001")){
					serarchParam += "Y⊥";               //$23 상실 신고여부
				}else if(applyStr.equals("Z002")){
					serarchParam += "N⊥";              
				}else{
					serarchParam += "⊥"; 
				}
			}else{
				serarchParam += "⊥"; 
			}

			String strParam = "" + serarchParam; //+"["+checkedSystemKeys+"]"; 

			//GWT 타입으로 팝업 호출시  postCall true 설정
			PrintUtils.setPostCall(true);
			PrintUtils.rexPrint(strDirPath, rexFileName, strParam);
		}else{
			MessageBox.alert("", "작성기간 시작일을 선택하여 주세요.", null);
		}
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
	
	
	
	
	
	//대상자 선택(insert)
	private void insertInsr1550() {
	       
		if (MSFSharedUtils.paramNull(systemkey.getValue())) {
            return;
        }
	//	if( MSFSharedUtils.paramNull(MSFSharedUtils.getSelectedComboValue(srhAqtnLssDivCd,"commCd")) ){
	//		MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "검색 조건에서 취득상실을 선택해 주세요.", null);
	//		return;
	//	}
		
//		if(tempComPunNm.getValue() == null || tempComPunNm.getValue().equals("")){
//			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "전화번호(사업장) 를 입력하세요.", null);
//			return;
//			
//		}
//		
//		if(tempHuPunNm.getValue() == null || tempHuPunNm.getValue().equals("")){
//			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "전화번호(가입) 를 입력하세요.", null);
//			return;
//			
//		}
		
		if(aqtnYn.getValue() == true && lssYn.getValue() == true){
			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "취득상실 구분을 중복 선택할 수 없습니다.", null);
			return;
		}
		
		PrgmComPsnl0115DTO sysComPsnl0115Dto = new PrgmComPsnl0115DTO();
		sysComPsnl0115Dto.setDpobCd(dpobCd.getValue());
		sysComPsnl0115Dto.setSystemkey(systemkey.getValue());

		MSFFormPanel popCom0160 = PrgmComPopupUtils.lovPopUpPrgmCom0160Form(sysComPsnl0115Dto);  //인사  
		
		final FormBinding popBindingCom0160 = popCom0160.getFormBinding();
		
		popBindingCom0160.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				List<BaseModel> mapModels = (List<BaseModel>)be.getSource();
				if (mapModels != null) { 
					Iterator<BaseModel> iterRecords = (Iterator<BaseModel>)mapModels.iterator();
					List<Insr1550DTO> listInsr1550dto = new ArrayList<Insr1550DTO>();  
					
					while (iterRecords.hasNext()) {
						BaseModel bmMapModel = (BaseModel) iterRecords.next();
						
						Insr1550DTO insr1550Dto = new Insr1550DTO();  
						
						//insr1550Dto.setSocInsrAqtnEmymtNum((long)socInsrAqtnEmymtNum.getValue());
						//insr1550Dto.setSoctyInsurCmptnDt(GWTUtils.getStringFromDate(soctyInsurCmptnDtV.getValue(),"yyyyMMdd")); //사회보험취득작성일자
						//insr1550Dto.setSocInsrLssCmptnDt("");//부양자가 상실될경우 피부양자는 자동으로 상실 되므로 다시 상실될경우가 없음으로 빈값을 셋팅한다.          
						//insr1550Dto.setSocInsrLssEmymtNum((long)socInsrAqtnEmymtNum.getValue());
						
						insr1550Dto.setFamyAqtnLssNum((long)socInsrAqtnEmymtNum.getValue()); // 취득일련번호
						insr1550Dto.setFamyAqtnLssDt(GWTUtils.getStringFromDate(soctyInsurCmptnDtV.getValue(),"yyyyMMdd"));//사회보험 취득일자
						insr1550Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
						insr1550Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
						insr1550Dto.setFamySeilNum((Long)bmMapModel.get("famySeilNum"));    /** column 급여가족사항일련번호 : famySeilNum */
						insr1550Dto.setFamyResnRegnNum(MSFSharedUtils.allowNulls(bmMapModel.get("famyResnRegnNum")));    /** column 급여가족주민번호 : famyResnRegnNum */
						insr1550Dto.setFamySecRegnNum(MSFSharedUtils.allowNulls(bmMapModel.get("famySecRegnNum")));    /** column 원본 급여가족주민번호 : famySecRegnNum */
						insr1550Dto.setFamyNm(MSFSharedUtils.allowNulls(bmMapModel.get("famyNm")));    /** column 한글성명 : hanNm */
						insr1550Dto.setFamyRelaDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("famyRelaDivCd")));    /** column 가족관계구분코드 : famyRelaDivCd */
						insr1550Dto.setDbpsnAssttnSgnCd(MSFSharedUtils.allowNulls(bmMapModel.get("dabtyDivCd"))); //장애인 구분코드
						insr1550Dto.setDbpsnGrdeCd(MSFSharedUtils.allowNulls(bmMapModel.get("dabtyGrdeCd"))); //장애인 등급코드
						insr1550Dto.setDbpsnNatnCd(MSFSharedUtils.allowNulls(bmMapModel.get("natnCd"))); //국적코드
						insr1550Dto.setAqtnDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("aqtnDt"),"yyyyMMdd"));    /** column 피부양자취득일자 : aqtnDt */
						
						
						insr1550Dto.setInsrDpobPhnNum(tempComPunNm.getValue());
						insr1550Dto.setInsrUsePhnNum(tempHuPunNm.getValue());
									
						
						//if ("I0100001".equals(MSFSharedUtils.getSelectedComboValue(srhAqtnLssDivCd,"commCd"))) {
						if(aqtnYn.getValue()){	
							insr1550Dto.setAqtnDivCd("I0100001"); //취득구분 > 취득
							insr1550Dto.setAqtnReasCd("I0110005"); //취득사유 
						}else
						//}
						//else if ( "I0100002".equals(MSFSharedUtils.getSelectedComboValue(srhAqtnLssDivCd,"commCd")) ) {
						if(lssYn.getValue()){	
							insr1550Dto.setAqtnDivCd("I0100002"); //취득구분 > 상실
							insr1550Dto.setAqtnReasCd("I0110006"); //취득사유 
						}
						//}
						
						listInsr1550dto.add(insr1550Dto);
					}
					
					actionDatabase = ActionDatabase.INSERT;
					insr2100Service.activityOnInsr1500(listInsr1550dto, actionDatabase, new AsyncCallback<Long>() {
						public void onFailure(Throwable caught) {
							MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
									MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnInsr1500(" + actionDatabase.name() + ") : " + caught), null);
                        }
                        public void onSuccess(Long result) {  
                        	//insr1100GridPanel.reload();
                        	//insr1500GridPanel.reload();
                        	readDtailData2();
        					reloadRightGrid();
                        	actionDatabase = ActionDatabase.UPDATE;
                        }
                    });
					   
				}  
			}
		});
	}
	
	//insr15501600FormSave
	private void insr15501600FormSave() {
		
		boolean doActionYn = true;
		
		if (MSFSharedUtils.paramNotNull(records)) {
	         
            List<Insr1550DTO> listInsr1550dto = new ArrayList<Insr1550DTO>();  
             
             while (records.hasNext()) {
            	 
                 Record record = (Record) records.next(); 
                 BaseModel bmMapModel = (BaseModel)record.getModel();
                   
                 Insr1550DTO insr1550Dto = new Insr1550DTO();
                 
                 insr1550Dto.setFamySeilNum((Long)bmMapModel.get("famySeilNum"));    /** column 급여가족사항일련번호 : famySeilNum */
                 insr1550Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
                 insr1550Dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
                 insr1550Dto.setFamyAqtnLssDt(MSFSharedUtils.allowNulls(bmMapModel.get("famyAqtnLssDt")));    /** column 피부양자취득상실신고작성일자 : famyAqtnLssDt */
                 insr1550Dto.setFamyAqtnLssNum((Long)bmMapModel.get("famyAqtnLssNum"));    /** column 피부양자취득상실_고용일련번호 : famyAqtnLssNum */
                 
                 insr1550Dto.setAqtnDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("aqtnDt"),"yyyyMMdd"));    /** column 피부양자취득일자 : aqtnDt */
                 insr1550Dto.setAqtnReasCd(MSFSharedUtils.allowNulls(bmMapModel.get("aqtnReasCd$commCd")));    /** column 피부양자취득사유코드 : aqtnReasCd */
                 insr1550Dto.setDbpsnAssttnSgnCd(MSFSharedUtils.allowNulls(bmMapModel.get("dbpsnAssttnSgnCd$commCd")));    /** column 장애인_종별부호코드 : dbpsnAssttnSgnCd */
                 insr1550Dto.setDbpsnGrdeCd(MSFSharedUtils.allowNulls(bmMapModel.get("dbpsnGrdeCd$commCd")));    /** column 장애인_등급코드 : dbpsnGrdeCd */
                 insr1550Dto.setDbpsnRgstnDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("dbpsnRgstnDt"),"yyyyMMdd"));    /** column 장애인_등록일자 : dbpsnRgstnDt */                 
                 insr1550Dto.setFrgnrStyQftntCd(MSFSharedUtils.allowNulls(bmMapModel.get("frgnrStyQftntCd$commCd")));    /** column 외국인_체류자격코드 : frgnrStyQftntCd */
                 insr1550Dto.setFrgnrStyBgnnDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("frgnrStyBgnnDt"),"yyyyMMdd"));    /** column 외국인_체류시작일자 : frgnrStyBgnnDt */
                 insr1550Dto.setFrgnrStyEndDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("frgnrStyEndDt"),"yyyyMMdd"));    /** column 외국인_체류종료일자 : frgnrStyEndDt */
                 
                 insr1550Dto.setAqtnDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("aqtnDivCd$commCd"))); //취득구분 > 취득
                 
                 insr1550Dto.setSocrAqtnFamyYn(MSFSharedUtils.allowNulls(bmMapModel.get("socrAqtnFamyYn"))); //취득신고 여부
                 insr1550Dto.setSocrLssFamyYn(MSFSharedUtils.allowNulls(bmMapModel.get("socrLssFamyYn"))); //상실신고 여부
                 
                 insr1550Dto.setInsrDpobPhnNum(tempComPunNm.getValue());
				 insr1550Dto.setInsrUsePhnNum(tempHuPunNm.getValue());
                 
                 
                 //취득/상실 신고가 완료된 데이터는 수정/삭제 불가
                 if( "I0100001".equals(insr1550Dto.getAqtnDivCd()) ) {
                	 if( "Y".equals(insr1550Dto.getSocrAqtnFamyYn()) ) {
                	//	 doActionYn = false;
                		 insr1550Dto.setSocrAqtnFamyYn("N");
                	 }
                 }
                 else if( "I0100002".equals(insr1550Dto.getAqtnDivCd()) ) {
                	 if( "Y".equals(insr1550Dto.getSocrLssFamyYn()) ) {
                	//	 doActionYn = false;
                		 insr1550Dto.setSocrLssFamyYn("N");
                	 }                	 
                 }

                 listInsr1550dto.add(insr1550Dto);
             }  
           
           //  BaseModel bm = new BaseModel();           
           //  bm.set("insrDpobPhnNum", tempComPunNm.getValue());
           //  bm.set("insrUsePhnNum", tempHuPunNm.getValue());
             
           if (doActionYn) {

        	   insr2100Service.activityOnInsr1500(listInsr1550dto,actionDatabase, new AsyncCallback<Long>(){
        		   public void onFailure(Throwable caught) {
        			   MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
        					   MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnInsr1500(" + actionDatabase.name() + ") : " + caught), null);
        		   }
        		   public void onSuccess(Long result) { 
        			   if (result == 0) {
        				   MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
        						   actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
        			   } else {
		        		   MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
		        		   actionDatabase + "처리가 "+result+"건 완료 되었습니다.", null);
		        		   //insr1100GridPanel.reload();
		        		   //insr1500GridPanel.reload();
		        		   readDtailData2();
       					   reloadRightGrid();
		        		   actionDatabase = ActionDatabase.UPDATE;
        			   } 
        		   } 
    		   }); 
           }
           else {
        	   MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), "신고 완료된 데이터는 수정/삭제를 할수없습니다. 데이타를 확인하십시요.", null);
        	   insr1500GridPanel.reload();
           }
       }
       else {
           MessageBox.alert(actionDatabase.name() + "선택", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
           return;
       }
		        
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
