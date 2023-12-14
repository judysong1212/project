package com.app.exterms.payroll.client.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0600DTO;
import com.app.exterms.payroll.client.dto.Payr0650DTO;
import com.app.exterms.payroll.client.form.defs.Payr0600Def;
import com.app.exterms.payroll.client.form.defs.Payr0650Def;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.client.lookup.LookupPayr0440PayYr;
import com.app.exterms.payroll.client.service.Payr4600Service;
import com.app.exterms.payroll.client.service.Payr4600ServiceAsync;
import com.app.exterms.payroll.client.utils.PayrUtils;
import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.generics.MSFCustomForm;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.utils.PrintUtils;
import com.app.smrmf.core.msfmainapp.client.widget.MSFComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.app.smrmf.syscom.client.util.SysComComboUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.binding.FormBinding;
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
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.ColumnData;
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
import com.google.gwt.user.client.rpc.AsyncCallback;


/**
 * ====================================================
 * 디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
 * extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow {
 * 상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
 * =====================================================
 **/
public class Payr4600 extends MSFPanel {


    /**
     * ##########################################################################
     * { 시스템 기본설정파일 선언부  시작}
     * ##########################################################################
     **/
    //권한 설정 객체
    private GWTAuthorization gwtAuthorization;
    private GWTExtAuth gwtExtAuth;
    private boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리

/**
 *##########################################################################
 * { 시스템 기본설정파일 선언부  종료}
 *##########################################################################
 **/

    /**
     * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     * 전역변수 선언부  시작
     * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     **/
    Date today;

    private PayrConstants lblPayrConst = PayrConstants.INSTANCE;


    private Payr4600ServiceAsync payr4600Service = Payr4600Service.Util.getInstance();


    private VerticalPanel vp;
    private FormPanel plFrmPayr4600;
    private String txtForm = ""; 

    private TabPanel tabsPayr4600Frst;
    private TabPanel tabsPayr4600Two;

    //일용직귀속년도 payr0440 데이타 사용 

    private LookupPayr0440PayYr lkApptnYr = new LookupPayr0440PayYr();  
    private MSFGridPanel payYrGridPanel;
    

    private Payr0600Def payr0600Def = new Payr0600Def();   //그리드 테이블 컬럼 define
    private MSFGridPanel payr0600GridPanel;

    private Payr0650Def payr0650LeftDef = new Payr0650Def("PAYR4600LEFT");   //그리드 테이블 컬럼 define
    private MSFGridPanel payr0650LeftGridPanel;


    private Payr0650Def payr0650RightDef = new Payr0650Def("PAYR4600RIGHT");   //그리드 테이블 컬럼 define
    private MSFGridPanel payr0650RightGridPanel;

    private boolean srhMultiCombo = false;
    private boolean arrgtMultiCombo = false;

    private boolean printAllow = false;

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

    /**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * Button 변수 선언
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */
    private ButtonBar topPayr4600Bar;
    private Button btnPayr4600Sreach;
    private Button btnPayr4600File;
    private Button btnPayr4600Refresh;
    private Button btnPayr4600Delete;
    private Button btnPayr4600Print;

    /**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 검색변수 선언
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */
    private ComboBox<BaseModel> srhDilWrkrIncmBlggYr;              //귀속년도
    private MSFMultiComboBox<ModelData> srhDilWrkrBlggQatrDivCd;   //귀속분기
    private ComboBox<BaseModel> srhPayrMangDeptCd;                 //단위기관
    private MSFComboBox<BaseModel> srhDeptCd;                         //부서
    private MSFComboBox<BaseModel> srhBusinCd;                        //사업
    private HiddenField<String> srhEmymtDivCd;                     //고용구분 - 기간제이므로 고정값처리.
    private TextField<String> srhAimenrNm;                         //성명
    private TextField<String> srhResnRegnNum;                      //주민번호
    private HiddenField<String> srhSystemkey;                      //시스템키
    private ComboBox<BaseModel>  srhMangeDeptCd; 				//관리부서 수정


	private Boolean emptyCheck = false ;
    private ComboBox<BaseModel> arrgtDilWrkrIncmBlggYr;            //귀속년도
    private MSFMultiComboBox<ModelData> arrgtDilWrkrBlggQatrDivCd; //귀속분기
    private ComboBox<BaseModel> arrgtPayrMangDeptCd;               //단위기관
    private MSFComboBox<BaseModel> arrgtDeptCd;                       //부서
    private MSFComboBox<BaseModel> arrgtBusinCd;                      //사업
    private HiddenField<String> arrgtEmymtDivCd;                   //고용구분 - 기간제이므로 고정값처리.
    private TextField<String> arrgtAimenrNm;                       //성명
    private TextField<String> arrgtResnRegnNum;                    //주민번호
    private HiddenField<String> arrgtSystemkey;                    //시스템키
    private MSFComboBox<BaseModel> printMethod;

    /**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 입력 변수 선언
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */

    private ComboBox<BaseModel> crDilWrkrIncmBlggYr;     //귀속년도
    private ComboBox<BaseModel> crDilWrkrBlggQatrDivCd;  //귀속분기 /** set 일용근로소득귀속분기구분코드 : dilWrkrBlggQatrDivCd */
    private ComboBox<BaseModel> crPayrMangDeptCd;        //단위기관 /** set 단위기관코드 : payrMangDeptCd */
    private ComboBox<BaseModel> crDeptCd;                //부서
    private ComboBox<BaseModel> crBusinCd;               //사업
    private HiddenField<String> dpobCd;                  //사업장코드
    private List<ModelData> mDilWrkrBlggQatrDivCd;
    private ListStore<BaseModel> lsDilWrkrBlggQatrDivCd;
    private List<BaseModel> mPrintMethod;
    private ListStore<BaseModel> lsPrintMethod;
    private MSFComboBox<BaseModel>  creMangeDeptCd; 				//관리부서 수정

    private TextField<String> aimenrNm;
    private TextField<String> aimenrResnRegnNum;
    private TextField<String> aimenrPhnNum;
    private TextField<String> aimenrDeptNm;
    private TextField<String> aimenrBusinNm;
    private TextField<String> aimenrZpcd;
    private TextField<String> aimenrRoadNmAddr;

    /**
     * column 일용근로소득귀속분기구분코드 : dilWrkrBlggQatrDivCd
     */
    private HiddenField<String> dilWrkrIncmBlggQatrDivCdArr;

    private HiddenField<String> dilWrkrIncmBlggYr;

    private HiddenField<String> deptCd;

    private HiddenField<String> businCd;

    /**
     * column 대표자성명
     */
    private TextField<String> degtrNm;

    /**
     * column 법인명(상호)
     */
    private TextField<String> corpNmFmnm;

    /**
     * column 사업자등록번호
     */
    private TextField<String> busoprRgstnNum;

    /**
     * column 사업자주민등록번호
     */
    private TextField<String> busoprResnRegnNum;

    /**
     * column 법인번호
     */
    private TextField<String> corpNum;

    /**
     * column 주소
     */
    private TextField<String> incmRegrstDebrZpcd;

    private TextField<String> incmRegrstDebrFndtnAddr;

    private TextField<String> incmRegrstDebrDtlPatrAddr;

    /**
     * column 세무대리인번호 : txDeptyNum
     */
    private TextField<String> txDeptyNum;

    /**
     * column 홈텍스ID : hmtxId
     */
    private TextField<String> hmtxId;

    /**
     * column 담당자부서명 : pernChrgDeptNm
     */
    private TextField<String> pernChrgDeptNm;

    /**
     * column 담당자성명 : pernChrgNm
     */
    private TextField<String> pernChrgNm;

    /**
     * column 담당자전화번호 : pernChrgPhnNum
     */
    private TextField<String> pernChrgPhnNum;

    /**
     * column 전자우편주소
     */
    private TextField<String> ectnMailAddr;

    /* itemTop01 */
    /**
     * 원천징수영수증 - 기본정보 - 소득자성명 AIMENR_NM
     */
    private TextField<String> top01AimenrNm;

    /**
     * 원천징수영수증 - 기본정보 - 소득자주민등록번호 AIMENR_RESN_REGN_NUM
     */
    private TextField<String> top01AimenrResnRegnNum;

    /**
     * 원천징수영수증 - 기본정보 - 부서코드 DEPT_CD
     */
    private TextField<String> top01DeptCd;

    /**
     * 원천징수영수증 - 기본정보 - 사업코드 BUSIN_CD
     */
    private TextField<String> top01BusinCd;
    /* itemTop01 */

/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * 	전역변수 선언부  종료
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 **/

    /**
     *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     * 	권한설정 관련 함수 및 선언 시작 (권한 적용필요시 추가해야함.)
     *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     **/
    /**
     * 권한설정 처리 체크
     * AuthAction
     */
    private void checkPayr4600Auth(String authAction, ListStore<BaseModel> bm) {
        //2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
        if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm)) {


            if (!maskTracker) {
                unmask();
            }

            authExecEnabled();

            gwtExtAuth.setCheckMapDef(null); //로딩완료 후 초기화

        }
    }

    private void authExecEnabled() {
        //------------------
        //----------------------------------------------------
        Field<?>[] fldArrField = {srhPayrMangDeptCd, srhDeptCd, srhBusinCd};

        gwtAuthorization.formAuthFieldConfig(fldArrField);

        srhDilWrkrIncmBlggYr.setValue(lsDilWrkrIncmBlggYr.findModel("year", DateTimeFormat.getFormat("yyyy").format(new Date())));

    }

    final Timer tmMask = new Timer() {
        public void run() {

            if (lsDilWrkrIncmBlggYr.getCount() > 0) {

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
        // 권한처리 부분 추가 전역이 아니 각 화면별로 객체 생성시 처리를 위해 변경함.
        gwtAuthorization = GWTAuthorization.getInstance();
        gwtExtAuth = GWTExtAuth.getInstance();

        HashMap<String, Boolean> authMapDef = new HashMap();

        authMapDef.put("srhDilWrkrIncmBlggYr", Boolean.FALSE);
        authMapDef.put("srhPayrMangDeptCd", Boolean.FALSE);
        authMapDef.put("srhDeptCd", Boolean.FALSE);

        gwtExtAuth.setCheckMapDef(authMapDef);

        if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
            //권한 검색조건처리를 위해 추가된 부분
            //mask("[화면로딩] 초기화 진행 중!");
        }
        tmMask.scheduleRepeating(5000);
    }


    /**
     *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     * 	권한설정 관련 함수 및 선언 종료 (권한 적용필요시 추가해야함.)
     *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     **/

    /**
     * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     * 전역함수 선언부 시작
     * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     **/
    // 검색 폼 바인딩 처리 함수

    //화면 폼 바인딩 처리
    private void setPayr4600FormBinding() {

    }

/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * 	전역함수 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 **/

    /**
     * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     * Rpc Service 선언부 시작
     * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     **/
    //입력수정삭제처리 rpc 처리부
    // -------------- store 선언 시작 --------------
    private ListStore<BaseModel> lsDilWrkrIncmBlggYr = new ListStore();  //귀속년도
    private ListStore<BaseModel> lsPayrMangDeptCd = new ListStore();  //단위기관
    private ListStore<BaseModel> lsDeptCd = new ListStore();  //부서
    private ListStore<BaseModel> lsBusinCd = new ListStore();  //사업
    private ListStore<BaseModel> lscrDilWrkrIncmBlggYr = new ListStore();
    private ListStore<BaseModel> lscrDilWrkrBlggQatrDivCd = new ListStore();
    private ListStore<BaseModel> lsMangeDeptCd 	= new ListStore<BaseModel>();	//관리부서
    private ListStore<BaseModel> lscrDeptCd = new ListStore();  //부서
    private ListStore<BaseModel> lscreMangeDeptCd 	= new ListStore<BaseModel>();	//관리부서
    // -------------- store 선언 종료 --------------


    // -------------- DTO 선언 시작 --------------
    private PrgmComBass0150DTO sysComBass0150Dto;    //단위기관
    private PrgmComBass0300DTO sysComBass0300Dto;
    private PrgmComBass0400DTO sysComBass0400Dto;    //부서코드
    private PrgmComBass0500DTO sysComBass0500Dto;    //사업코드
    private SysCoCalendarDTO msfCoCalendarDto;
    // -------------- DTO 선언 종료 --------------

    private BaseModel record;

    private BaseModel bmData = new BaseModel();    //외부에서 사용하기 위하여 bmData를 선언한다. RowClick에서 사용되며 상세조건 이벤트에서도 적용된다.

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
    private SelectionListener<ButtonEvent> selectionListener =
            new SelectionListener<ButtonEvent>() {
                public void componentSelected(ButtonEvent ce) {
                }
            };

    private void doAction(ActionDatabase actionDatabase) {

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
     * #############################################################################
     * 프로그램 시작
     * #############################################################################
     **/

    public ContentPanel getViewPanel() {
        if (panel == null) {

            //콤보 권한초기화
            initLoad();
 

            // formData = new FormData("-650");
            vp = new VerticalPanel();
            vp.setSpacing(10);

            //단위기관 data set
            lsPayrMangDeptCd = PrgmComComboUtils.getDeptBass0150ComboData(sysComBass0150Dto);

            //귀속년도 data set
            lsDilWrkrIncmBlggYr = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);

            //귀속분기 data set
            mDilWrkrBlggQatrDivCd = new ArrayList();
            lsDilWrkrBlggQatrDivCd = new ListStore();
            ModelData m = new BaseModel();
            m.set("commCd", "1");
            m.set("commCdNm", "1분기");
            mDilWrkrBlggQatrDivCd.add(m);
            lsDilWrkrBlggQatrDivCd.add((BaseModel) m);
            m = new BaseModel();
            m.set("commCd", "2");
            m.set("commCdNm", "2분기");
            mDilWrkrBlggQatrDivCd.add(m);
            lsDilWrkrBlggQatrDivCd.add((BaseModel) m);
            m = new BaseModel();
            m.set("commCd", "3");
            m.set("commCdNm", "3분기");
            mDilWrkrBlggQatrDivCd.add(m);
            lsDilWrkrBlggQatrDivCd.add((BaseModel) m);
            m = new BaseModel();
            m.set("commCd", "4");
            m.set("commCdNm", "4분기");
            mDilWrkrBlggQatrDivCd.add(m);
            lsDilWrkrBlggQatrDivCd.add((BaseModel) m);

            mPrintMethod = new ArrayList();
            lsPrintMethod = new ListStore();
            BaseModel md = new BaseModel();
            md.set("commCd", "1");
            md.set("commCdNm", "분기별제출집계표");
            mPrintMethod.add(md);

            md = new BaseModel();
            md.set("commCd", "2");
            md.set("commCdNm", "지급자보관용");
            mPrintMethod.add(md);

            md = new BaseModel();
            md.set("commCd", "3");
            md.set("commCdNm", "소득자보관용");
            mPrintMethod.add(md);
            lsPrintMethod.add(mPrintMethod);

            createPayr4600Form();  //화면 기본정보를 설정
            createSearchForm();    //검색필드를 적용
            createArrgtForm();
            createForm();
            createFormDetail();
            //엣지변환
            //vp.setSize("1010px", "700px");
            vp.setSize("1010px", "750px");


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
    public Payr4600() {

    	//엣지변환
    	//setSize("1010px", "700px");
        setSize("1010px", "750px");
    }

    public Payr4600(String txtForm) {
        this.txtForm = txtForm;
    }

/**
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 생성자 함수 선언부 종료
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 **/

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * 폼 생성시 기본 처리 함수 선언부 시작
     * 1. 폼 생성 선언
     * 2. 공통 버튼 처리 선언
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     **/

    private void createPayr4600Form() {

        this.plFrmPayr4600 = new FormPanel();
        this.plFrmPayr4600.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" -  " + lblPayrConst.title_Payr4600()));
        this.plFrmPayr4600.setIcon(MSFMainApp.ICONS.text());
        this.plFrmPayr4600.setBodyStyleName("pad-text");
        this.plFrmPayr4600.setPadding(2);
        this.plFrmPayr4600.setFrame(true);
        this.plFrmPayr4600.addListener(Events.OnClick, new Listener<ComponentEvent>() {
            public void handleEvent(ComponentEvent ce) {
                if (srhMultiCombo) {
                    if (srhDilWrkrBlggQatrDivCd.getCheckBoxListHolder().isVisible()) {
                        srhDilWrkrBlggQatrDivCd.showClose(ce);
                    }
                    srhMultiCombo = false;
                } else if (arrgtMultiCombo) {
                    if (arrgtDilWrkrBlggQatrDivCd.getCheckBoxListHolder().isVisible()) {
                        arrgtDilWrkrBlggQatrDivCd.showClose(ce);
                    }
                    arrgtMultiCombo = false;
                }
            }
        });
        /************************************************************************
         * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출
         ************************************************************************/
        final Button btnlogView = new Button("로그");

        btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
        btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent e) {
                //로그 뷰화면 호출 메서드
                funcLogMessage(lblPayrConst.title_Payr4600(), "PAYR4600");
            }
        });
        plFrmPayr4600.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
        plFrmPayr4600.getHeader().addTool(btnlogView);
        /************************************************************************
         * 화면 에러 처리시 필요한 부분으로 추가
         ************************************************************************/

        LayoutContainer layoutContainer = new LayoutContainer();
        layoutContainer.setLayout(new ColumnLayout());

        LayoutContainer layoutContainer_1 = new LayoutContainer();
        layoutContainer_1.setLayout(new FlowLayout());

        ButtonBar buttonBar_1 = new ButtonBar();

        Button btnNewButton_2 = new Button("");
        buttonBar_1.add(btnNewButton_2);
        layoutContainer_1.add(buttonBar_1);
        layoutContainer.add(layoutContainer_1, new ColumnData(.5));
        layoutContainer_1.setBorders(false);

        LayoutContainer layoutContainer_2 = new LayoutContainer();
        layoutContainer_2.setLayout(new FlowLayout());


        topPayr4600Bar = new ButtonBar();
        layoutContainer_2.add(topPayr4600Bar);
        topPayr4600Bar.setAlignment(HorizontalAlignment.RIGHT);


        btnPayr4600Refresh = new Button("초기화");
        btnPayr4600Refresh.setIcon(MSFMainApp.ICONS.refresh16());
        topPayr4600Bar.add(btnPayr4600Refresh);
        btnPayr4600Refresh.addListener(Events.Select, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent e) {
                //TODO
                formInit();
                printAllow = false;
            }
        });

        btnPayr4600Sreach = new Button("조회");
        btnPayr4600Sreach.setIcon(MSFMainApp.ICONS.search16());
        topPayr4600Bar.add(btnPayr4600Sreach);
        btnPayr4600Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent e) {
                //조회버튼 클릭시 처리
                reload();
            }
        });

        btnPayr4600Delete = new Button("삭제");
        btnPayr4600Delete.setIcon(MSFMainApp.ICONS.delete16());
        topPayr4600Bar.add(btnPayr4600Delete);
        btnPayr4600Delete.addListener(Events.Select, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent e) {
                actionDatabase = ActionDatabase.CUSTOM;

                // 선택한 데이터만 담고 싶을 때
                Iterator<BaseModel> iterBaseModel = payr0650LeftGridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();

                List<Record>  listRecord  = new ArrayList();

                while(iterBaseModel.hasNext()) {
                    Record rec  = new Record(iterBaseModel.next());
                    listRecord.add(rec);
                }

                Iterator<Record> iterRecords = listRecord.iterator() ;

                final List<Payr0650DTO> listDto = new ArrayList();


                Payr0650DTO payr0650DTO;

                while (iterRecords.hasNext()) {

                    payr0650DTO = new Payr0650DTO();
                    Record recData = iterRecords.next();
                    BaseModel bmMapModel = (BaseModel) recData.getModel();

                    payr0650DTO.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));
                    payr0650DTO.setDilWrkrIncmBlggQatrDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("dilWrkrIncmBlggQatrDivCd")));
                    payr0650DTO.setDilWrkrIncmBlggYr(MSFSharedUtils.allowNulls(bmMapModel.get("dilWrkrIncmBlggYr")));
                    payr0650DTO.setDilWrkrIncmSeilNum(MSFSharedUtils.allowNulls(bmMapModel.get("dilWrkrIncmSeilNum")));
                    payr0650DTO.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));

                    listDto.add(payr0650DTO);
                }

                if (listDto.size() == 0) {
                    MessageBox.info("삭제", "선택된 행이 없습니다.", null);
                } else {
                    MessageBox.confirm("삭제", "선택된 행을 삭제하시겠습니까?.", new Listener<MessageBoxEvent>() {
                        public void handleEvent(MessageBoxEvent be) {
                            payr4600Service.deletePayr4600(listDto, actionDatabase, new AsyncCallback<Long>() {
                                public void onSuccess(Long result) {
                                    MessageBox.info("삭제", "완료되었습니다.", null);
                                    reload();
                                }

                                public void onFailure(Throwable caught) {
                                    MessageBox.info("삭제", "오류가 발생하였습니다.", null);
                                    caught.printStackTrace();
                                    MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), MSFMainApp.ADMINMESSAGES.ExceptionMessageService("deletePayr4600(" + actionDatabase.name() + ") : " + caught), (Listener) null);
                                }
                            });
                        }
                    });
                }
            }
        });

        btnPayr4600File = new Button("전자파일생성");
        btnPayr4600File.setIcon(MSFMainApp.ICONS.text());
        topPayr4600Bar.add(btnPayr4600File);
        btnPayr4600File.addListener(Events.Select, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent e) {
                if (printAllow) {
                    xlsExportData();
                }
            }
        });

        layoutContainer.add(layoutContainer_2, new ColumnData(.5));
        layoutContainer_2.setBorders(false);
        layoutContainer.setBorders(false);

        plFrmPayr4600.add(layoutContainer);

        vp.add(plFrmPayr4600);
        //엣지변환
        //plFrmPayr4600.setSize("990px", "680px");
        plFrmPayr4600.setSize("990px", "730px");
    }

    /**
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * 폼 생성시 기본 처리 함수 선언부 종료
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     **/

/**
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 검색 함수 선언부 시작
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 **/

    /**
     * 검색필드 설정
     */
    private void createSearchForm() {

        srhSystemkey = new HiddenField();  //시스템키

        sysComBass0150Dto = new PrgmComBass0150DTO();
        sysComBass0300Dto = new PrgmComBass0300DTO();
        sysComBass0400Dto = new PrgmComBass0400DTO();
        sysComBass0500Dto = new PrgmComBass0500DTO();


        /**
        * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        * 년도 콤보박스 처리  시작
        * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		  
        */
        		   ContentPanel payYrGrid = new ContentPanel();  
        		   payYrGrid.setVisible(false);
        		    
        		   //년도 콤보처리 
        		   payYrGridPanel = new MSFGridPanel(lkApptnYr, false, false, false, true); 
        		   payYrGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
        			       public void handleEvent(ComponentEvent be) {  
        			    	 payYrGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
        			          public void handleEvent(StoreEvent<BaseModel> be) {  
        			        	  lsDilWrkrIncmBlggYr.add(payYrGridPanel.getMsfGrid().getStore().getModels()); 
        			        	 
        			       
        			          }  
        			        });  
        			       
        			      }  
        			    });  
        	  
        		payYrGrid.add(payYrGridPanel); 
        		plFrmPayr4600.add(payYrGrid); 
 
        sysComBass0400Dto.setDeptDspyYn("Y");
        		 //-------------------관리부서 추가  
        sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd()); 
        lsMangeDeptCd = PrgmComComboUtils.getMangDeptBass0400ComboData (sysComBass0400Dto);
        		
        sysComBass0400Dto.setDeptDspyYn("Y");
        sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept());
        sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());

        plFrmPayr4600.setLayout(new FlowLayout());

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

        fieldSet.setStyleAttribute("marginTop", "10px");

        LayoutContainer lcSchLeft = new LayoutContainer();
        lcSchLeft.setStyleAttribute("paddingRight", "10px");
        lcSchLeft.setLayout(new ColumnLayout());

        LayoutContainer layoutContainer_8 = new LayoutContainer();
        FormLayout frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(70);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        layoutContainer_8.setLayout(frmlytSch);

        srhDilWrkrIncmBlggYr = new ComboBox();
        srhDilWrkrIncmBlggYr.setName("srhDilWrkrIncmBlggYr");
        srhDilWrkrIncmBlggYr.setForceSelection(true);
        srhDilWrkrIncmBlggYr.setMinChars(1);
        srhDilWrkrIncmBlggYr.setDisplayField("yearDisp");
        srhDilWrkrIncmBlggYr.setValueField("year");
        srhDilWrkrIncmBlggYr.setTriggerAction(TriggerAction.ALL);
        srhDilWrkrIncmBlggYr.setAllowBlank(false);
        srhDilWrkrIncmBlggYr.setEmptyText("--귀속년도선택--");
        srhDilWrkrIncmBlggYr.setSelectOnFocus(true);
        srhDilWrkrIncmBlggYr.setReadOnly(false);
        srhDilWrkrIncmBlggYr.setEnabled(true);
        srhDilWrkrIncmBlggYr.setStore(lsDilWrkrIncmBlggYr);
        srhDilWrkrIncmBlggYr.setFieldLabel("귀속년도");
        srhDilWrkrIncmBlggYr.getStore().addStoreListener(new StoreListener<BaseModel>() {
            public void handleEvent(StoreEvent<BaseModel> be) {
                checkPayr4600Auth("srhDilWrkrIncmBlggYr", lsDilWrkrIncmBlggYr);

            }
        });
        srhDilWrkrIncmBlggYr.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
                printAllow = false;  //조회 완료 시, 프린트 출력 가능 플래그
            }
        });

        layoutContainer_8.add(srhDilWrkrIncmBlggYr, new FormData("100%"));
        lcSchLeft.add(layoutContainer_8, new ColumnData(.5));
        layoutContainer_8.setBorders(false);

        LayoutContainer layoutContainer_11 = new LayoutContainer();
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(70);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        layoutContainer_11.setLayout(frmlytSch);

        srhDilWrkrBlggQatrDivCd = new MSFMultiComboBox();
        srhDilWrkrBlggQatrDivCd.setName("srhDilWrkrBlggQatrDivCd");
        srhDilWrkrBlggQatrDivCd.setEmptyText("--귀속분기선택--");
        srhDilWrkrBlggQatrDivCd.getListView().setDisplayProperty("commCdNm");
        srhDilWrkrBlggQatrDivCd.getStore().add(this.mDilWrkrBlggQatrDivCd);
        srhDilWrkrBlggQatrDivCd.setWidth(100);
        srhDilWrkrBlggQatrDivCd.setFieldLabel("귀속분기");
        srhDilWrkrBlggQatrDivCd.getListView().addListener(Events.BrowserEvent, new Listener<ComponentEvent>() {
            public void handleEvent(ComponentEvent ce) {
                if (DOM.eventGetType(ce.getEvent()) == 4096) {
                    srhMultiCombo = true;
                } else if (DOM.eventGetType(ce.getEvent()) == 32) {
                    srhMultiCombo = true;
                } else if (DOM.eventGetType(ce.getEvent()) == 16) {
                    srhMultiCombo = false;
                }
            }
        });


        layoutContainer_11.add(srhDilWrkrBlggQatrDivCd, new FormData("100%"));
        lcSchLeft.add(layoutContainer_11, new ColumnData(.5));
        layoutContainer_11.setBorders(false);

        LayoutContainer layoutContainer_14 = new LayoutContainer();
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(60);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        layoutContainer_14.setLayout(frmlytSch);


        /** column 단위기관 : payrMangDeptCd */
        srhPayrMangDeptCd = new ComboBox();
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
        srhPayrMangDeptCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
            public void handleEvent(StoreEvent<BaseModel> be) {

                EventType type = be.getType();
                if (type == Store.Add) {
                    /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
                    checkPayr4600Auth("srhPayrMangDeptCd", lsPayrMangDeptCd);
                }

            }
        });
        srhPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {

            	sysComBass0400Dto = new PrgmComBass0400DTO();
              	 
                sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd, "payrMangDeptCd"));
                sysComBass0400Dto.setMangeDeptCd(MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd")); 
                
                lsDeptCd = PrgmComComboUtils.getDeptBass0400ComboData(sysComBass0400Dto);

                srhDeptCd.setStore(lsDeptCd);
                srhDeptCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
                    public void handleEvent(StoreEvent<BaseModel> be) {
                        srhDeptCd.reloadData();
                        srhDeptCd.setValue(lsDeptCd.getAt(0));
                        printAllow = false;  //조회 완료 시, 프린트 출력 가능 플래그
                    }
                });

            }
        });

        layoutContainer_14.add(srhPayrMangDeptCd, new FormData("100%"));
        layoutContainer_14.setBorders(false);


        LayoutContainer layoutContainer_5 = new LayoutContainer();
        layoutContainer_5.setLayout(new ColumnLayout());

        LayoutContainer layoutContainer_6 = new LayoutContainer();
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(40);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        layoutContainer_6.setLayout(frmlytSch);

        srhAimenrNm = new TextField();
        srhAimenrNm.setName("srhAimenrNm");
        srhAimenrNm.setFieldLabel("성명");
        layoutContainer_6.add(srhAimenrNm, new FormData("100%"));
        srhAimenrNm.addKeyListener(new KeyListener() {
            public void componentKeyDown(ComponentEvent event) {

                srhAimenrNm.validate();
                if (MSFSharedUtils.allowNulls(srhAimenrNm.getValue()).trim().equals("")) {
                    srhSystemkey.setValue("");
                    srhResnRegnNum.setValue("");
                }
                if (event.getKeyCode() == KeyCodes.KEY_ENTER) {
                    srhSystemkey.setValue("");
                    srhResnRegnNum.setValue("");
                    fnPopupPsnl0100("srh");
                }
                super.componentKeyDown(event);
            }
        });

        layoutContainer_5.add(layoutContainer_6, new ColumnData(.4));
        layoutContainer_6.setBorders(false);

        Button btnHanNm = new Button("검색");
        layoutContainer_5.add(btnHanNm);
        btnHanNm.addListener(Events.Select, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent e) {

                fnPopupPsnl0100("srh");

            }
        });

        LayoutContainer layoutContainer_7 = new LayoutContainer();
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(5);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        layoutContainer_7.setLayout(frmlytSch);

        srhResnRegnNum = new TextField();
        srhResnRegnNum.setName("srhResnRegnNum");
        srhResnRegnNum.setLabelSeparator("");
        layoutContainer_7.add(srhResnRegnNum, new FormData("100%"));
        layoutContainer_7.setBorders(false);
        layoutContainer_5.add(layoutContainer_7, new ColumnData(.46));
        layoutContainer_5.setBorders(false);

        lcSchCol.add(lcSchLeft, new ColumnData(.45));
        lcSchCol.add(layoutContainer_14, new ColumnData(.25));
        lcSchCol.add(layoutContainer_5, new ColumnData(.3));

        fieldSet.add(lcSchCol, new FormData("100%"));

        LayoutContainer layoutContainer_13 = new LayoutContainer();
        layoutContainer_13.setLayout(new ColumnLayout());


		//관리부서 
		LayoutContainer lcSch2_1 = new LayoutContainer();
		FormLayout frmlytSch2_1 = new FormLayout();
		frmlytSch2_1.setLabelWidth(70);
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
  	    		  
               srhDeptCd.setStore(lsDeptCd);
               srhDeptCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
                   public void handleEvent(StoreEvent<BaseModel> be) {
                       srhDeptCd.reloadData();
                       srhDeptCd.setValue(lsDeptCd.getAt(0));
                       printAllow = false;  //조회 완료 시, 프린트 출력 가능 플래그
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
	      	    		
	      	    		 srhDeptCd.setStore(lsDeptCd);
	                     srhDeptCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
	                         public void handleEvent(StoreEvent<BaseModel> be) {
	                             srhDeptCd.reloadData();
	                             srhDeptCd.setValue(lsDeptCd.getAt(0));
	                             printAllow = false;  //조회 완료 시, 프린트 출력 가능 플래그
	                         }
	                     });
	      	    		emptyCheck = false;
                	}
                 }  
            } 
        });   
       
        lcSch2_1.add(srhMangeDeptCd, new FormData("100%"));
        
        LayoutContainer layoutContainer_4 = new LayoutContainer();
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(70);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        layoutContainer_4.setLayout(frmlytSch);
        layoutContainer_4.setBorders(false);

        
        LayoutContainer layoutContainer = new LayoutContainer();
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(70);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        layoutContainer.setLayout(frmlytSch);
        layoutContainer_4.add(layoutContainer, new FormData("100%"));


        srhDeptCd = new MSFComboBox();
        srhDeptCd.setName("srhDeptCd");
        srhDeptCd.setForceSelection(true);
        srhDeptCd.setMinChars(1);
        srhDeptCd.setDisplayField("deptNmHan");
        srhDeptCd.setValueField("deptCd");
        srhDeptCd.setTriggerAction(TriggerAction.ALL);
        srhDeptCd.setEmptyText("--부서선택--");
        srhDeptCd.setSelectOnFocus(true);
        srhDeptCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
        srhDeptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
        srhDeptCd.setStore(lsDeptCd);
        srhDeptCd.setMinListWidth(PayGenConst.FRM_COMBO_WIDTH_200);
        srhDeptCd.setFieldLabel("부서");
        srhDeptCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
            public void handleEvent(StoreEvent<BaseModel> be) {
                EventType type = be.getType();
                if (type == Store.Add) {
                    /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
                    checkPayr4600Auth("srhDeptCd", lsDeptCd);
                }

            }
        });
        srhDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
                //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리
                sysComBass0500Dto.setDeptCd(MSFSharedUtils.getSelectedComboValue(srhDeptCd, "deptCd"));
                sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhDilWrkrIncmBlggYr, "year"));

                //--------------------사업 불러 오는 함수 -------------------------------------------------
                lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
                //--------------------사업 불러 오는 함수 -------------------------------------------------
                srhBusinCd.setStore(lsBusinCd);
                srhBusinCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
                    public void handleEvent(StoreEvent<BaseModel> be) {
                        srhBusinCd.reloadData();
                        srhBusinCd.setValue(lsBusinCd.getAt(0));
                        printAllow = false;  //조회 완료 시, 프린트 출력 가능 플래그
                    }
                });
            }
        });

        layoutContainer.add(srhDeptCd, new FormData("100%"));
        layoutContainer.setBorders(false);

        LayoutContainer layoutContainer_2 = new LayoutContainer();
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(70);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        layoutContainer_2.setLayout(frmlytSch);

        srhBusinCd = new MSFComboBox();
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
        srhBusinCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
                printAllow = false;  //조회 완료 시, 프린트 출력 가능 플래그
            }
        });

        layoutContainer_2.add(srhBusinCd, new FormData("100%"));
        layoutContainer_2.setBorders(false);
        
        layoutContainer_13.add(lcSch2_1 , new ColumnData(.22));
        layoutContainer_13.add(layoutContainer_4, new ColumnData(.22));
        layoutContainer_13.add(layoutContainer_2, new ColumnData(.555));

        fieldSet.add(layoutContainer_13);
        layoutContainer_13.setBorders(false);

        plFrmPayr4600.add(fieldSet);
        //vp.add(panel);
    }

/**
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 검색 함수 선언부 종료
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 **/

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * 기본등록화면 입력 시작
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     **/

    /**
     * 자료생성필드 설정
     */
    private void createArrgtForm() {

        arrgtSystemkey = new HiddenField();  //시스템키

        sysComBass0150Dto = new PrgmComBass0150DTO();
        sysComBass0300Dto = new PrgmComBass0300DTO();
        sysComBass0400Dto = new PrgmComBass0400DTO();
        sysComBass0500Dto = new PrgmComBass0500DTO();

        /**
         * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
         * 년도 콤보박스 처리  시작
         * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
         */
        
        ContentPanel payYrGrid = new ContentPanel();  
		   payYrGrid.setVisible(false);
		    
		   //년도 콤보처리 
		   payYrGridPanel = new MSFGridPanel(lkApptnYr, false, false, false, true); 
		   payYrGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
			       public void handleEvent(ComponentEvent be) {  
			    	 payYrGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
			          public void handleEvent(StoreEvent<BaseModel> be) {  
			        	  lsDilWrkrIncmBlggYr.add(payYrGridPanel.getMsfGrid().getStore().getModels());  
			          }  
			        });  
			       
			      }  
		  });   
	 

		   //-------------------관리부서 추가  
		   sysComBass0400Dto.setDeptDspyYn("Y");
		   sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd()); 
		   lscreMangeDeptCd = PrgmComComboUtils.getMangDeptBass0400ComboData (sysComBass0400Dto);
		   
        sysComBass0400Dto.setDeptDspyYn("Y");
        sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept());
        sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
        //--------------------부서 불러 오는 함수 ------------------------------------------------
        lscrDeptCd = PrgmComComboUtils.getDeptBass0400ComboData(sysComBass0400Dto);
        //--------------------부서 불러 오는 함수 ------------------------------------------------


        plFrmPayr4600.setLayout(new FlowLayout());

        LayoutContainer lcArrgtCol = new LayoutContainer();
        lcArrgtCol.setLayout(new ColumnLayout());

        FieldSet fieldSet = new FieldSet();
        fieldSet.setHeadingHtml("자료생성");

        fieldSet.setStyleAttribute("marginTop", "10px");
        // fieldSet.setCheckboxToggle(false);

        LayoutContainer lcSchLeft = new LayoutContainer();
        lcSchLeft.setStyleAttribute("paddingRight", "10px");
        lcSchLeft.setLayout(new ColumnLayout());

        LayoutContainer layoutContainer_8 = new LayoutContainer();
        FormLayout frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(70);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        layoutContainer_8.setLayout(frmlytSch);

        arrgtDilWrkrIncmBlggYr = new ComboBox();
        arrgtDilWrkrIncmBlggYr.setName("arrgtDilWrkrIncmBlggYr");
        arrgtDilWrkrIncmBlggYr.setForceSelection(true);
        arrgtDilWrkrIncmBlggYr.setMinChars(1);
        arrgtDilWrkrIncmBlggYr.setDisplayField("yearDisp");
        arrgtDilWrkrIncmBlggYr.setValueField("year");
        arrgtDilWrkrIncmBlggYr.setTriggerAction(TriggerAction.ALL);
        arrgtDilWrkrIncmBlggYr.setAllowBlank(false);
        arrgtDilWrkrIncmBlggYr.setEmptyText("--귀속년도선택--");
        arrgtDilWrkrIncmBlggYr.setSelectOnFocus(true);
        arrgtDilWrkrIncmBlggYr.setReadOnly(false);
        arrgtDilWrkrIncmBlggYr.setEnabled(true);
        arrgtDilWrkrIncmBlggYr.setStore(lsDilWrkrIncmBlggYr);
        arrgtDilWrkrIncmBlggYr.setFieldLabel("귀속년도");
        arrgtDilWrkrIncmBlggYr.getStore().addStoreListener(new StoreListener<BaseModel>() {
            public void handleEvent(StoreEvent<BaseModel> be) {
                checkPayr4600Auth("arrgtDilWrkrIncmBlggYr", lsDilWrkrIncmBlggYr);

            }
        });
        layoutContainer_8.add(arrgtDilWrkrIncmBlggYr, new FormData("100%"));
        lcSchLeft.add(layoutContainer_8, new ColumnData(.5));
        layoutContainer_8.setBorders(false);

        LayoutContainer layoutContainer_11 = new LayoutContainer();
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(70);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);        layoutContainer_11.setLayout(frmlytSch);

        arrgtDilWrkrBlggQatrDivCd = new MSFMultiComboBox();
        arrgtDilWrkrBlggQatrDivCd.setName("arrgtDilWrkrBlggQatrDivCd");
        arrgtDilWrkrBlggQatrDivCd.setEmptyText("--귀속분기선택--");
        arrgtDilWrkrBlggQatrDivCd.getListView().setDisplayProperty("commCdNm");
        arrgtDilWrkrBlggQatrDivCd.getStore().add(this.mDilWrkrBlggQatrDivCd);
        arrgtDilWrkrBlggQatrDivCd.setWidth(100);
        arrgtDilWrkrBlggQatrDivCd.setFieldLabel("귀속분기");
        arrgtDilWrkrBlggQatrDivCd.getListView().addListener(Events.BrowserEvent, new Listener<ComponentEvent>() {
            public void handleEvent(ComponentEvent ce) {
                if (DOM.eventGetType(ce.getEvent()) == 4096) {
                    arrgtMultiCombo = true;
                } else if (DOM.eventGetType(ce.getEvent()) == 32) {
                    arrgtMultiCombo = true;
                } else if (DOM.eventGetType(ce.getEvent()) == 16) {
                    arrgtMultiCombo = false;
                }
            }
        });


        layoutContainer_11.add(arrgtDilWrkrBlggQatrDivCd, new FormData("100%"));
        lcSchLeft.add(layoutContainer_11, new ColumnData(.5));
        layoutContainer_11.setBorders(false);

        LayoutContainer layoutContainer_14 = new LayoutContainer();
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(60);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        layoutContainer_14.setLayout(frmlytSch);


        /** column 단위기관 : payrMangDeptCd */
        arrgtPayrMangDeptCd = new ComboBox();
        arrgtPayrMangDeptCd.setName("arrgtPayrMangDeptCd");
        arrgtPayrMangDeptCd.setForceSelection(true);
        arrgtPayrMangDeptCd.setMinChars(1);
        arrgtPayrMangDeptCd.setDisplayField("payrMangDeptNm");
        arrgtPayrMangDeptCd.setValueField("payrMangDeptCd");
        arrgtPayrMangDeptCd.setTriggerAction(TriggerAction.ALL);
        arrgtPayrMangDeptCd.setEmptyText("--단위기관선택--");
        arrgtPayrMangDeptCd.setSelectOnFocus(true);
        arrgtPayrMangDeptCd.setReadOnly(gwtExtAuth.getReadOnlyPayrMangDeptCd());
        arrgtPayrMangDeptCd.setEnabled(gwtExtAuth.getEnablePayrMangDeptCd());
        arrgtPayrMangDeptCd.setStore(lsPayrMangDeptCd);
        arrgtPayrMangDeptCd.setFieldLabel("단위기관");
        arrgtPayrMangDeptCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
            public void handleEvent(StoreEvent<BaseModel> be) {
                EventType type = be.getType();
                if (type == Store.Add) {
                    /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
                    checkPayr4600Auth("arrgtPayrMangDeptCd", lsPayrMangDeptCd);
                }
            }
        });

        arrgtPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
            	sysComBass0400Dto = new PrgmComBass0400DTO();  
			 
                sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(arrgtPayrMangDeptCd, "arrgtPayrMangDeptCd"));
  	    		sysComBass0400Dto.setMangeDeptCd(MSFSharedUtils.getSelectedComboValue(creMangeDeptCd,"mangeDeptCd")); 
  	    		
                lscrDeptCd = PrgmComComboUtils.getDeptBass0400ComboData(sysComBass0400Dto);

                arrgtDeptCd.setStore(lscrDeptCd);
                arrgtDeptCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
                    public void handleEvent(StoreEvent<BaseModel> be) {
                        arrgtDeptCd.reloadData();
                        arrgtDeptCd.setValue(lscrDeptCd.getAt(0));
                    }
                });

            }
        });

        layoutContainer_14.add(arrgtPayrMangDeptCd, new FormData("100%"));
        layoutContainer_14.setBorders(false);


        LayoutContainer layoutContainer_5 = new LayoutContainer();
        layoutContainer_5.setLayout(new ColumnLayout());

        LayoutContainer layoutContainer_6 = new LayoutContainer();
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(40);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        layoutContainer_6.setLayout(frmlytSch);

        arrgtAimenrNm = new TextField();
        arrgtAimenrNm.setName("srhAimenrNm");
        arrgtAimenrNm.setFieldLabel("성명");
        layoutContainer_6.add(arrgtAimenrNm, new FormData("100%"));
        arrgtAimenrNm.addKeyListener(new KeyListener() {
            public void componentKeyDown(ComponentEvent event) {
                super.componentKeyDown(event);
                srhAimenrNm.validate();
                if (event.getKeyCode() == KeyCodes.KEY_ENTER) {
                    fnPopupPsnl0100("arrgt");
                }
            }
        });

        layoutContainer_5.add(layoutContainer_6, new ColumnData(.4));
        layoutContainer_6.setBorders(false);

        Button btnHanNm = new Button("검색");
        layoutContainer_5.add(btnHanNm);
        btnHanNm.addListener(Events.Select, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent e) {
                fnPopupPsnl0100("arrgt");

            }
        });

        LayoutContainer layoutContainer_7 = new LayoutContainer();
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(5);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        layoutContainer_7.setLayout(frmlytSch);

        arrgtResnRegnNum = new TextField<String>();
        arrgtResnRegnNum.setName("arrgtResnRegnNum");
        arrgtResnRegnNum.setLabelSeparator("");
        //arrgtResnRegnNum.setFieldLabel("주민번호");
        layoutContainer_7.add(arrgtResnRegnNum, new FormData("100%"));
        layoutContainer_7.setBorders(false);
        layoutContainer_5.add(layoutContainer_7, new ColumnData(.46));
        layoutContainer_5.setBorders(false);

        lcArrgtCol.add(lcSchLeft, new ColumnData(.45));
        lcArrgtCol.add(layoutContainer_14, new ColumnData(.25));
        lcArrgtCol.add(layoutContainer_5, new ColumnData(.3));

        fieldSet.add(lcArrgtCol, new FormData("100%"));

        LayoutContainer layoutContainer_13 = new LayoutContainer();
        layoutContainer_13.setLayout(new ColumnLayout());

        
      //관리부서 
      		LayoutContainer lcSch2_1 = new LayoutContainer();
      		FormLayout frmlytSch2_1 = new FormLayout();
      		frmlytSch2_1.setLabelWidth(70);
      		frmlytSch2_1.setLabelAlign(LabelAlign.RIGHT);
      		lcSch2_1.setLayout(frmlytSch2_1);
      		
      		creMangeDeptCd = new MSFComboBox<BaseModel>();
      		creMangeDeptCd.setName("creMangeDeptCd"); 
      		creMangeDeptCd.setEmptyText("--관리부서선택--");
      		creMangeDeptCd.setDisplayField("deptNmRtchnt");
      		creMangeDeptCd.setStore(lscreMangeDeptCd); 
      		creMangeDeptCd.setWidth(100);
      		creMangeDeptCd.setFieldLabel("관리부서");
      		creMangeDeptCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
      		creMangeDeptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
      		creMangeDeptCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
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
      		creMangeDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
      	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
      	    		//단위기관가 변경되는 경우 해당하는 부서변경처리를 위한 이벤트처리 
      	    		sysComBass0400Dto = new PrgmComBass0400DTO();
      	    		sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(arrgtPayrMangDeptCd, "arrgtPayrMangDeptCd"));
    	    		sysComBass0400Dto.setMangeDeptCd(MSFSharedUtils.getSelectedComboValue(creMangeDeptCd,"mangeDeptCd")); 
    	    		
    	    		lscrDeptCd = PrgmComComboUtils.getDeptBass0400ComboData(sysComBass0400Dto);

    	    		arrgtDeptCd.setStore(lscrDeptCd);
    	    		arrgtDeptCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
                      public void handleEvent(StoreEvent<BaseModel> be) {
                          arrgtDeptCd.reloadData();
                          arrgtDeptCd.setValue(lscrDeptCd.getAt(0));
                      }
    	    		});
        	    	emptyCheck = true;
      	    	} 
      	    });
      		creMangeDeptCd.addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
                  @Override
                  public void handleEvent(ComponentEvent ce) {    
                  	
                      if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {  
                      	
                      	if (emptyCheck && "".equals(MSFSharedUtils.allowNulls(srhMangeDeptCd.getRawValue()))) {
      	                	sysComBass0400Dto = new PrgmComBass0400DTO();
      	                	sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(arrgtPayrMangDeptCd, "arrgtPayrMangDeptCd"));
	      	  	    		sysComBass0400Dto.setMangeDeptCd(MSFSharedUtils.getSelectedComboValue(creMangeDeptCd,"mangeDeptCd")); 
	      	  	    		
	      	                lscrDeptCd = PrgmComComboUtils.getDeptBass0400ComboData(sysComBass0400Dto);
	
	      	                arrgtDeptCd.setStore(lscrDeptCd);
	      	                arrgtDeptCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
	      	                    public void handleEvent(StoreEvent<BaseModel> be) {
	      	                        arrgtDeptCd.reloadData();
	      	                        arrgtDeptCd.setValue(lscrDeptCd.getAt(0));
	      	                    }
	      	                });
      	      	    		emptyCheck = false;
                      	}
                       }  
                  } 
              });   
             
              lcSch2_1.add(creMangeDeptCd, new FormData("100%")); 
        
        
        LayoutContainer layoutContainer_4 = new LayoutContainer();
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(70);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        layoutContainer_4.setLayout(frmlytSch);
        layoutContainer_4.setBorders(false);

        LayoutContainer layoutContainer = new LayoutContainer();
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(70);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        layoutContainer.setLayout(frmlytSch);
        layoutContainer_4.add(layoutContainer, new FormData("100%"));


        arrgtDeptCd = new MSFComboBox();
        arrgtDeptCd.setName("arrgtDeptCd");
        arrgtDeptCd.setForceSelection(true);
        arrgtDeptCd.setMinChars(1);
        arrgtDeptCd.setDisplayField("deptNmHan");
        arrgtDeptCd.setValueField("deptCd");
        arrgtDeptCd.setTriggerAction(TriggerAction.ALL);
        arrgtDeptCd.setEmptyText("--부서선택--");
        arrgtDeptCd.setSelectOnFocus(true);
        arrgtDeptCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
        arrgtDeptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
        arrgtDeptCd.setStore(lscrDeptCd);
        arrgtDeptCd.setMinListWidth(PayGenConst.FRM_COMBO_WIDTH_200);
        arrgtDeptCd.setFieldLabel("부서");
        arrgtDeptCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
            public void handleEvent(StoreEvent<BaseModel> be) {
                EventType type = be.getType();
                if (type == Store.Add) {
                    /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
                    checkPayr4600Auth("arrgtDeptCd", lscrDeptCd);
                }

            }
        });
        arrgtDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
                //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리

                sysComBass0500Dto.setDeptCd(MSFSharedUtils.getSelectedComboValue(arrgtDeptCd, "deptCd"));
                sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(arrgtDilWrkrIncmBlggYr, "year"));


                lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);

                arrgtBusinCd.setStore(lsBusinCd);
                arrgtBusinCd.getStore().addStoreListener(new StoreListener<BaseModel>() {
                    public void handleEvent(StoreEvent<BaseModel> be) {
                        arrgtBusinCd.reloadData();
                        arrgtBusinCd.setValue(lsBusinCd.getAt(0));
                    }
                });
            }
        });

        layoutContainer.add(arrgtDeptCd, new FormData("100%"));
        layoutContainer.setBorders(false);

        LayoutContainer layoutContainer_2 = new LayoutContainer();
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(70);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        layoutContainer_2.setLayout(frmlytSch);

        arrgtBusinCd = new MSFComboBox();
        arrgtBusinCd.setName("arrgtBusinCd");
        arrgtBusinCd.setForceSelection(true);
        arrgtBusinCd.setMinChars(1);
        arrgtBusinCd.setDisplayField("businNm");
        arrgtBusinCd.setValueField("businCd");
        arrgtBusinCd.setTriggerAction(TriggerAction.ALL);
        arrgtBusinCd.setEmptyText("--사업선택--");
        arrgtBusinCd.setSelectOnFocus(true);
        arrgtBusinCd.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
        arrgtBusinCd.setEnabled(gwtExtAuth.getEnableBusinCd());
        arrgtBusinCd.setStore(lsBusinCd);
        arrgtBusinCd.setFieldLabel("사업");

        layoutContainer_2.add(arrgtBusinCd, new FormData("100%"));
        layoutContainer_2.setBorders(false);

        LayoutContainer layoutContainer_15 = new LayoutContainer();
        Button btnPayr4600Arrgt = new Button("지급내역정리");
        btnPayr4600Arrgt.setStyleAttribute("marginLeft", "5px");
        layoutContainer_15.add(btnPayr4600Arrgt);
        btnPayr4600Arrgt.addListener(Events.Select, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent e) {
                final Payr0600DTO payr0600DTO = new Payr0600DTO();
                final String dilWrkrIncmBlggYr = MSFSharedUtils.getSelectedComboValue(arrgtDilWrkrIncmBlggYr, "year");
                final String dilWrkrIncmBlggQatrDivCd = PayrUtils.getStrValToBMMultiCombo(lsDilWrkrBlggQatrDivCd, arrgtDilWrkrBlggQatrDivCd.getValue(), "commCdNm", "commCd");
                final String deptCd = MSFSharedUtils.getSelectedComboValue(arrgtDeptCd, "deptCd");
                final String businCd = MSFSharedUtils.getSelectedComboValue(arrgtBusinCd, "businCd");
                final String systemkey = arrgtSystemkey.getValue();
                if ("".equals(dilWrkrIncmBlggYr)) {
                    MessageBox.info("지급내역정리", "귀속년도를 선택해주세요", null);

                } else if ("".equals(dilWrkrIncmBlggQatrDivCd)) {
                    MessageBox.info("지급내역정리", "귀속분기를 선택해주세요", null);

                } else if ("".equals(deptCd)) {
                    MessageBox.info("지급내역정리", "부서를 선택해주세요", null);

                } else if ("".equals(businCd)) {
                    MessageBox.info("지급내역정리", "사업을 선택해주세요", null);
                } else {
                    MessageBox.confirm("지급내역정리", "지급내역정리를 하시겠습니까?", new Listener<MessageBoxEvent>() {
                        public void handleEvent(MessageBoxEvent be) {
                            if ("yes".equals(be.getButtonClicked().getItemId())) {
                                actionDatabase = ActionDatabase.CUSTOM;

                                payr0600DTO.setDilWrkrIncmBlggYr(dilWrkrIncmBlggYr);
                                payr0600DTO.setDilWrkrIncmBlggQatrDivCd(dilWrkrIncmBlggQatrDivCd);
                                payr0600DTO.setDeptCd(deptCd);
                                payr0600DTO.setBusinCd(businCd);
                                payr0600DTO.setSystemkey(systemkey);

                                payr4600Service.savePayr4600(payr0600DTO, actionDatabase, new AsyncCallback<Long>() {
                                    public void onSuccess(Long result) {
                                        MessageBox.info("", "완료되었습니다.", null);
                                        /*
                                        srhDilWrkrIncmBlggYr.setValueField(dilWrkrIncmBlggYr);
                                        srhDilWrkrBlggQatrDivCd.setValue(dilWrkrIncmBlggQatrDivCd);
                                        srhDeptCd.setValueField(deptCd);
                                        srhBusinCd.setValueField(businCd);
                                        srhSystemkey.setValue(systemkey);
                                        srhAimenrNm.setValue(arrgtAimenrNm.getValue());
                                        srhResnRegnNum.setValue(arrgtResnRegnNum.getValue());
                                        reload(); */
                                    }

                                    public void onFailure(Throwable caught) {
                                        MessageBox.info("", "오류가 발생하였습니다.", null);
                                        caught.printStackTrace();
                                        MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), MSFMainApp.ADMINMESSAGES.ExceptionMessageService("savePayr4600(" + actionDatabase.name() + ") : " + caught), (Listener) null);
                                    }
                                });
                            }
                        }
                    });
                }
            }
        });
        
        layoutContainer_13.add(lcSch2_1, new ColumnData(.22));
        layoutContainer_13.add(layoutContainer_4, new ColumnData(.22));
        layoutContainer_13.add(layoutContainer_2, new ColumnData(.46));
        layoutContainer_13.add(layoutContainer_15, new ColumnData(.1));

        fieldSet.add(layoutContainer_13);
        layoutContainer_13.setBorders(false);

        plFrmPayr4600.add(fieldSet);
    }

    private void createForm() {

        msfCoCalendarDto = new SysCoCalendarDTO();
        sysComBass0300Dto = new PrgmComBass0300DTO();
        sysComBass0400Dto = new PrgmComBass0400DTO();
        sysComBass0500Dto = new PrgmComBass0500DTO();

        //--------------------급여년도 불러 오는 함수 ------------------------------------------------
        lscrDilWrkrIncmBlggYr = SysComComboUtils.getSysComComboYearData(msfCoCalendarDto);
        //--------------------급여년도 불러 오는 함수 ------------------------------------------------

        sysComBass0400Dto.setDeptDspyYn("Y");
        sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept());
        sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
        //--------------------부서 불러 오는 함수 ------------------------------------------------
        lscrDeptCd = PrgmComComboUtils.getDeptBass0400ComboData(sysComBass0400Dto);
        //--------------------부서 불러 오는 함수 ------------------------------------------------

        LayoutContainer layoutContainer_outer = new LayoutContainer();
        layoutContainer_outer.setStyleAttribute("text-align", "right");
        layoutContainer_outer.setLayout(new ColumnLayout());

        LayoutContainer layoutContainer_dummy = new LayoutContainer(); /* dummy */
        FormLayout frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(577);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        layoutContainer_dummy.setLayout(frmlytSch);
        layoutContainer_outer.add(layoutContainer_dummy, new ColumnData(.7));
        layoutContainer_dummy.setBorders(false);

        LayoutContainer layoutContainer_inner = new LayoutContainer();
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(120);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        layoutContainer_inner.setLayout(frmlytSch);
//        출력구분코드은 출력물에 대한 구분자로 출력된다.
        /**
         * 3.소득자보관용
         * 2.지급자보관용
         * 1.분기별제출집계표
         */
        printMethod = new MSFComboBox();
        layoutContainer_inner.add(printMethod, new FormData("100%"));
        printMethod.setFieldLabel("출력구분");
        printMethod.setDisplayField("commCdNm");
        printMethod.setValueField("commCd");
        printMethod.setStore(lsPrintMethod);
        printMethod.setValue(lsPrintMethod.getAt(0));
        layoutContainer_outer.add(layoutContainer_inner, new ColumnData(.3));
        layoutContainer_inner.setBorders(false);

        btnPayr4600Print = new Button("지급명세서출력");
        btnPayr4600Print.setStyleAttribute("marginLeft", "5px");
        layoutContainer_outer.add(btnPayr4600Print, new ColumnData(.1));
        btnPayr4600Print.addListener(Events.Select, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent e) {
                //Print버튼 클릭시 처리
                String printType = "PAYR4600";

                if (printAllow) {
                    Payr4600Print();
                } else {
                    MessageBox.alert("확인", "출력 전에 데이터를 조회해주세요.", null);
                }

            }
        });



        layoutContainer_outer.setBorders(false);

        plFrmPayr4600.add(layoutContainer_outer);

    }

    private void createFormDetail() {

        FieldSet fieldSet = new FieldSet();
        fieldSet.setSize("960px", "410px");
        fieldSet.setHeadingHtml("지급명세서내역");
        fieldSet.setStyleAttribute("marginTop", "10px");
        tabsPayr4600Frst = new TabPanel();
        //tabsPsnl.setMinTabWidth(80);
        // tabsPayr4600Frst.setResizeTabs(true);
        tabsPayr4600Frst.setAnimScroll(true);
        tabsPayr4600Frst.setTabScroll(true);
        tabsPayr4600Frst.setPlain(true);
        tabsPayr4600Frst.setSize(940, 455);

        TabItem itemTop01 = new TabItem();
        itemTop01.setStyleAttribute("padding", "5px");
        itemTop01.setText("원천징수영수증");
        // itemTop01.addStyleName("pad-text");
        itemTop01.setLayout(new FormLayout());
        itemTop01.add(DataTop01(), new FormData("100%"));
        tabsPayr4600Frst.add(itemTop01);

        TabItem itemTop02 = new TabItem();
        itemTop02.setStyleAttribute("padding", "5px");
        itemTop02.setText("징수의무자(지급자)");
        itemTop02.setLayout(new FormLayout());
        itemTop02.add(DataTop02(), new FormData("100%"));

        tabsPayr4600Frst.add(itemTop02);


        fieldSet.add(tabsPayr4600Frst, new FormData("100%"));


        plFrmPayr4600.add(fieldSet);

    }


    private LayoutContainer DataTop01() {

        LayoutContainer layoutContainer = new LayoutContainer();

        ContentPanel cp01 = new ContentPanel();
        cp01.setHeaderVisible(false);
        cp01.setSize(934, 350);
        cp01.setLayout(new FitLayout());

        LayoutContainer layoutContainer_16 = new LayoutContainer();
        layoutContainer_16.setLayout(new ColumnLayout());
        //  layoutContainer_16.setBorders(false);

        LayoutContainer layoutContainer_1 = new LayoutContainer();
        FormLayout frmlytStd = new FormLayout();
        frmlytStd.setLabelWidth(0);
        frmlytStd.setLabelAlign(LabelAlign.RIGHT);
        layoutContainer_1.setLayout(frmlytStd);

        FieldSet fldstNewFieldset = new FieldSet();
        fldstNewFieldset.setSize("320px", "350px");

        ContentPanel cntntpnlNewContentpanel = new ContentPanel();
        cntntpnlNewContentpanel.setHeaderVisible(false);
        cntntpnlNewContentpanel.setCollapsible(true);
        fldstNewFieldset.add(cntntpnlNewContentpanel);


        layoutContainer_1.add(fldstNewFieldset);
        fldstNewFieldset.setHeadingHtml("대상자정보");
        fldstNewFieldset.setCollapsible(false);
        layoutContainer_16.add(layoutContainer_1, new ColumnData(.35));

        fldstNewFieldset.add(CheckBoxLeftGrid(), new FormData("100%"));

        LayoutContainer layoutContainer_2 = new LayoutContainer();
        frmlytStd = new FormLayout();
        frmlytStd.setLabelWidth(0);
        frmlytStd.setLabelAlign(LabelAlign.RIGHT);
        layoutContainer_2.setLayout(frmlytStd);

        FieldSet fldstNewFieldset_1 = new FieldSet();
        fldstNewFieldset_1.setSize("598px", "100px");
        fldstNewFieldset_1.setHeadingHtml("기본정보");
        fldstNewFieldset_1.setCollapsible(false);

        fldstNewFieldset_1.add(rightForm01());

        layoutContainer_2.add(fldstNewFieldset_1);

        layoutContainer_16.add(layoutContainer_2, new ColumnData(.65));

        FieldSet fldstNewFieldset_2 = new FieldSet();

        ContentPanel cntntpnlNewContentpanel_1 = new ContentPanel();
        cntntpnlNewContentpanel_1.setHeaderVisible(false);
        cntntpnlNewContentpanel_1.setCollapsible(true);
        fldstNewFieldset_2.add(cntntpnlNewContentpanel_1);
        layoutContainer_2.add(fldstNewFieldset_2);
        fldstNewFieldset_2.setSize("598px", "245px");
        fldstNewFieldset_2.setHeadingHtml("소득내역정보");
        fldstNewFieldset_2.setCollapsible(false);
        fldstNewFieldset_2.add(rightGrid(), new FormData("100%"));

        layoutContainer_16.add(layoutContainer_2, new ColumnData(.65));

        cp01.add(layoutContainer_16);
        layoutContainer.add(cp01);
        return layoutContainer;


    }

    private LayoutContainer rightForm01() {

        LayoutContainer layoutContainer = new LayoutContainer();

        ContentPanel cp02 = new ContentPanel();
        cp02.setHeaderVisible(false);
        cp02.setSize(576, 230);
        cp02.setLayout(new FlowLayout());

        LayoutContainer layoutContainer_6 = new LayoutContainer(new ColumnLayout());

        LayoutContainer layoutContainer_3 = new LayoutContainer();
        //   layoutContainer_3.setBorders(true);
        FormLayout frmlytStd = new FormLayout();
        frmlytStd.setLabelWidth(70);
        frmlytStd.setLabelAlign(LabelAlign.RIGHT);
        layoutContainer_3.setLayout(frmlytStd);

        aimenrNm = new TextField();
        layoutContainer_3.add(aimenrNm, new FormData("100%"));
        aimenrNm.setFieldLabel("성명");
        aimenrNm.setReadOnly(true);
        layoutContainer_6.add(layoutContainer_3, new ColumnData(.33));

        LayoutContainer layoutContainer_4 = new LayoutContainer();
        frmlytStd = new FormLayout();
        frmlytStd.setLabelWidth(70);
        frmlytStd.setLabelAlign(LabelAlign.RIGHT);
        layoutContainer_4.setLayout(frmlytStd);

        aimenrResnRegnNum = new TextField();
        layoutContainer_4.add(aimenrResnRegnNum, new FormData("100%"));
        aimenrResnRegnNum.setFieldLabel("주민번호");
        aimenrResnRegnNum.setReadOnly(true);
        layoutContainer_6.add(layoutContainer_4, new ColumnData(.33));

        LayoutContainer layoutContainer_5 = new LayoutContainer();
        frmlytStd = new FormLayout();
        frmlytStd.setLabelWidth(70);
        frmlytStd.setLabelAlign(LabelAlign.RIGHT);
        layoutContainer_5.setLayout(frmlytStd);

        aimenrPhnNum = new TextField();
        layoutContainer_5.add(aimenrPhnNum, new FormData("100%"));
        aimenrPhnNum.setFieldLabel("전화번호");
        aimenrPhnNum.setReadOnly(true);
        layoutContainer_6.add(layoutContainer_5, new ColumnData(.34));
        cp02.add(layoutContainer_6);

        LayoutContainer layoutContainer7 = new LayoutContainer();
        layoutContainer7.setLayout(new ColumnLayout());

        LayoutContainer layoutContainer_1 = new LayoutContainer();
        frmlytStd = new FormLayout();
        frmlytStd.setLabelWidth(70);
        frmlytStd.setLabelAlign(LabelAlign.RIGHT);
        layoutContainer_1.setLayout(frmlytStd);

        aimenrDeptNm = new TextField();
        layoutContainer_1.add(aimenrDeptNm, new FormData("100%"));
        aimenrDeptNm.setFieldLabel("부서");
        aimenrDeptNm.setReadOnly(true);
        layoutContainer7.add(layoutContainer_1, new ColumnData(.5));

        LayoutContainer layoutContainer_2 = new LayoutContainer();
        frmlytStd = new FormLayout();
        frmlytStd.setLabelWidth(70);
        frmlytStd.setLabelAlign(LabelAlign.RIGHT);
        layoutContainer_2.setLayout(frmlytStd);

        aimenrBusinNm = new TextField();
        layoutContainer_2.add(aimenrBusinNm, new FormData("100%"));
        aimenrBusinNm.setFieldLabel("사업");
        aimenrBusinNm.setReadOnly(true);
        layoutContainer7.add(layoutContainer_2, new ColumnData(.5));
        cp02.add(layoutContainer7);


        LayoutContainer layoutContainer8 = new LayoutContainer();
        layoutContainer8.setLayout(new ColumnLayout());

        LayoutContainer layoutContainer_7 = new LayoutContainer();
        frmlytStd = new FormLayout();
        frmlytStd.setLabelWidth(70);
        frmlytStd.setLabelAlign(LabelAlign.RIGHT);
        layoutContainer_7.setLayout(frmlytStd);

        aimenrZpcd = new TextField();
        layoutContainer_7.add(aimenrZpcd, new FormData("100%"));
        aimenrZpcd.setFieldLabel("도로명주소");
        aimenrZpcd.setReadOnly(true);
        layoutContainer8.add(layoutContainer_7, new ColumnData(.3));

        LayoutContainer layoutContainer_8 = new LayoutContainer();
        frmlytStd = new FormLayout();
        frmlytStd.setLabelWidth(5);
        frmlytStd.setLabelAlign(LabelAlign.RIGHT);
        layoutContainer_8.setLayout(frmlytStd);

        aimenrRoadNmAddr = new TextField();
        aimenrRoadNmAddr.setLabelSeparator("");
        aimenrRoadNmAddr.setReadOnly(true);
        layoutContainer_8.add(aimenrRoadNmAddr, new FormData("100%"));
        layoutContainer8.add(layoutContainer_8, new ColumnData(.7));
        cp02.add(layoutContainer8);

        layoutContainer.add(cp02);

        return layoutContainer;

    }

    private LayoutContainer DataTop02() {


        LayoutContainer layoutContainer = new LayoutContainer();

        ContentPanel cp02 = new ContentPanel();
        cp02.setHeaderVisible(false);
        cp02.setSize(934, 350);
        cp02.setLayout(new FlowLayout());


        /* ------------------- 1 line start ----------------*/
        LayoutContainer line1_layoutContainer_outer = new LayoutContainer();
        line1_layoutContainer_outer.setLayout(new ColumnLayout());


        LayoutContainer line1_layoutContainer_inner_1 = new LayoutContainer();
        FormLayout frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(80);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        line1_layoutContainer_inner_1.setLayout(frmlytSch);


        degtrNm = new TextField();
        degtrNm.setFieldLabel("대표자성명");
        line1_layoutContainer_inner_1.add(degtrNm, new FormData("100%"));
        line1_layoutContainer_inner_1.setBorders(false);
        line1_layoutContainer_outer.add(line1_layoutContainer_inner_1, new ColumnData(.33));


        LayoutContainer line1_layoutContainer_inner_2 = new LayoutContainer();
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(80);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        line1_layoutContainer_inner_2.setLayout(frmlytSch);

        corpNmFmnm = new TextField();
        corpNmFmnm.setFieldLabel("법인명(상호)");
        line1_layoutContainer_inner_2.add(corpNmFmnm, new FormData("100%"));
        line1_layoutContainer_inner_2.setBorders(false);
        line1_layoutContainer_outer.add(line1_layoutContainer_inner_2, new ColumnData(.33));


        LayoutContainer line1_layoutContainer_inner_3 = new LayoutContainer();
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(80);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        line1_layoutContainer_inner_3.setLayout(frmlytSch);

        busoprRgstnNum = new TextField();
        busoprRgstnNum.setFieldLabel("사업자번호");
        line1_layoutContainer_inner_3.add(busoprRgstnNum, new FormData("100%"));
        line1_layoutContainer_inner_3.setBorders(false);
        line1_layoutContainer_outer.add(line1_layoutContainer_inner_3, new ColumnData(.33));

        cp02.add(line1_layoutContainer_outer);

        /* ------------------- 1 line end ------------------*/
        /* ------------------- 2 line start ----------------*/

        LayoutContainer line2_layoutContainer_outer = new LayoutContainer();
        line2_layoutContainer_outer.setLayout(new ColumnLayout());
        line2_layoutContainer_outer.setBorders(false);

        LayoutContainer line2_layoutContainer_inner_1 = new LayoutContainer();
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(80);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        line2_layoutContainer_inner_1.setLayout(frmlytSch);

        ectnMailAddr = new TextField();
        ectnMailAddr.setFieldLabel("전자우편주소");
        line2_layoutContainer_inner_1.add(ectnMailAddr, new FormData("100%"));
        line2_layoutContainer_inner_1.setBorders(false);
        line2_layoutContainer_outer.add(line2_layoutContainer_inner_1, new ColumnData(.33));


        LayoutContainer line2_layoutContainer_inner_2 = new LayoutContainer();
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(80);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        line2_layoutContainer_inner_2.setLayout(frmlytSch);

        corpNum = new TextField();
        corpNum.setFieldLabel("법인번호");
        line2_layoutContainer_inner_2.add(corpNum, new FormData("100%"));
        line2_layoutContainer_inner_2.setBorders(false);
        line2_layoutContainer_outer.add(line2_layoutContainer_inner_2, new ColumnData(.33));


        LayoutContainer line2_layoutContainer_inner_3 = new LayoutContainer();
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(80);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        line2_layoutContainer_inner_3.setLayout(frmlytSch);
        busoprResnRegnNum = new TextField();
        busoprResnRegnNum.setFieldLabel("사업자주민등록번호");
        line2_layoutContainer_inner_3.add(busoprResnRegnNum, new FormData("100%"));
        line2_layoutContainer_inner_3.setBorders(false);
        line2_layoutContainer_outer.add(line2_layoutContainer_inner_3, new ColumnData(.33));

        cp02.add(line2_layoutContainer_outer);

        /* ------------------- 2 line end ------------------*/
        /* ------------------- 3 line start ----------------*/

        LayoutContainer line3_layoutContainer_outer = new LayoutContainer();
        line3_layoutContainer_outer.setLayout(new ColumnLayout());
        line3_layoutContainer_outer.setBorders(false);

        LayoutContainer line3_layoutContainer_inner_1 = new LayoutContainer();
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(80);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        line3_layoutContainer_inner_1.setLayout(frmlytSch);

        incmRegrstDebrZpcd = new TextField();
        incmRegrstDebrZpcd.setFieldLabel("도로명주소");
        line3_layoutContainer_inner_1.add(incmRegrstDebrZpcd, new FormData("100%"));
        line3_layoutContainer_inner_1.setBorders(false);
        line3_layoutContainer_outer.add(line3_layoutContainer_inner_1, new ColumnData(.25));

        LayoutContainer line3_layoutContainer_inner_2 = new LayoutContainer();
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(5);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        line3_layoutContainer_inner_2.setLayout(frmlytSch);

        incmRegrstDebrFndtnAddr = new TextField();
        incmRegrstDebrFndtnAddr.setLabelSeparator("");
        incmRegrstDebrFndtnAddr.setFieldLabel("");
        line3_layoutContainer_inner_2.add(incmRegrstDebrFndtnAddr, new FormData("100%"));
        line3_layoutContainer_inner_2.setBorders(false);
        line3_layoutContainer_outer.add(line3_layoutContainer_inner_2, new ColumnData(.35));



        LayoutContainer line3_layoutContainer_inner_3 = new LayoutContainer();
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(5);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        line3_layoutContainer_inner_3.setLayout(frmlytSch);

        incmRegrstDebrDtlPatrAddr = new TextField();
        incmRegrstDebrDtlPatrAddr.setLabelSeparator("");
        incmRegrstDebrDtlPatrAddr.setFieldLabel("");
        line3_layoutContainer_inner_3.add(incmRegrstDebrDtlPatrAddr, new FormData("100%"));
        line3_layoutContainer_inner_3.setBorders(false);
        line3_layoutContainer_outer.add(line3_layoutContainer_inner_3, new ColumnData(.4));
        cp02.add(line3_layoutContainer_outer);

        /* ------------------- 3 line end ------------------*/
        /* ------------------- 4 line start ----------------*/

        LayoutContainer line4_layoutContainer_outer = new LayoutContainer();
        line4_layoutContainer_outer.setLayout(new ColumnLayout());

        LayoutContainer line4_layoutContainer_inner_1 = new LayoutContainer();
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(80);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        line4_layoutContainer_inner_1.setLayout(frmlytSch);

        pernChrgDeptNm = new TextField();
        pernChrgDeptNm.setFieldLabel("부서명");
        line4_layoutContainer_inner_1.add(pernChrgDeptNm, new FormData("100%"));
        line4_layoutContainer_inner_1.setBorders(false);
        line4_layoutContainer_outer.add(line4_layoutContainer_inner_1, new ColumnData(.33));


        LayoutContainer line4_layoutContainer_inner_2 = new LayoutContainer();
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(80);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        line4_layoutContainer_inner_2.setLayout(frmlytSch);

        pernChrgPhnNum = new TextField();
        pernChrgPhnNum.setFieldLabel("전화번호");
        line4_layoutContainer_inner_2.add(pernChrgPhnNum, new FormData("100%"));
        line4_layoutContainer_inner_2.setBorders(false);
        line4_layoutContainer_outer.add(line4_layoutContainer_inner_2, new ColumnData(.33));

        LayoutContainer line4_layoutContainer_inner_3 = new LayoutContainer();
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(80);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        line4_layoutContainer_inner_3.setLayout(frmlytSch);

        pernChrgNm = new TextField();
        pernChrgNm.setFieldLabel("담당자성명");
        line4_layoutContainer_inner_3.add(pernChrgNm, new FormData("100%"));
        line4_layoutContainer_inner_3.setBorders(false);
        line4_layoutContainer_outer.add(line4_layoutContainer_inner_3, new ColumnData(.33));

        cp02.add(line4_layoutContainer_outer);

        cp02.addButton(new Button("저장", new SelectionListener<ButtonEvent>() {
            @Override
            public void componentSelected(ButtonEvent ce) {

                final Payr0600DTO payr0600DTO = new Payr0600DTO();

                payr0600DTO.setDegtrNm(degtrNm.getValue());
                payr0600DTO.setCorpNmFmnm(corpNmFmnm.getValue());
                payr0600DTO.setBusoprRgstnNum(busoprRgstnNum.getValue());
                payr0600DTO.setBusoprResnRegnNum(busoprResnRegnNum.getValue());
                payr0600DTO.setCorpNum(corpNum.getValue());
                payr0600DTO.setIncmRegrstDebrZpcd(incmRegrstDebrZpcd.getValue());
                payr0600DTO.setIncmRegrstDebrFndtnAddr(incmRegrstDebrFndtnAddr.getValue());
                payr0600DTO.setIncmRegrstDebrDtlPatrAddr(incmRegrstDebrDtlPatrAddr.getValue());
                payr0600DTO.setPernChrgDeptNm(pernChrgDeptNm.getValue());
                payr0600DTO.setPernChrgPhnNum(pernChrgPhnNum.getValue());
                payr0600DTO.setPernChrgNm(pernChrgNm.getValue());
                payr0600DTO.setEctnMailAddr(ectnMailAddr.getValue());
                payr0600DTO.setDilWrkrIncmBlggYr(dilWrkrIncmBlggYr.getValue());
                payr0600DTO.setDeptCd(deptCd.getValue());
                payr0600DTO.setBusinCd(businCd.getValue());
                payr0600DTO.setDilWrkrIncmBlggQatrDivCd(dilWrkrIncmBlggQatrDivCdArr.getValue());

                MessageBox.confirm("저장", "제출자(대리인) 정보를 저장하시겠습니까?", new Listener<MessageBoxEvent>() {
                    public void handleEvent(MessageBoxEvent be) {
                        actionDatabase = ActionDatabase.CUSTOM;
                        payr4600Service.savePayr0600PentrInfo(payr0600DTO, actionDatabase, new AsyncCallback<Long>() {
                            public void onSuccess(Long result) {
                                MessageBox.info("저장", "완료되었습니다.", null);

                            }

                            public void onFailure(Throwable caught) {
                                MessageBox.info("저장", "오류가 발생하였습니다.", null);
                                caught.printStackTrace();
                                MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), MSFMainApp.ADMINMESSAGES.ExceptionMessageService("savePayr0600PentrInfo(" + actionDatabase.name() + ") : " + caught), (Listener) null);
                            }
                        });
                        reload();
                    }
                });

            }
        }));

        layoutContainer.add(cp02);

        return layoutContainer;

    }


    /**
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * 기본등록화면 입력 종료
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     **/

    /**
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * 서브 입력 폼 시작
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     **/

    /**
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * 서브 입력 폼 종료
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     **/
    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * 그리드 처리 함수 시작
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     **/

    private LayoutContainer CheckBoxLeftGrid() {

        LayoutContainer lcStdGrid = new LayoutContainer();
        lcStdGrid.setStyleAttribute("paddingRight", "10px");
        FormLayout frmlytStd = new FormLayout();


        //  frmlytStd.setLabelWidth(85);
        // frmlytStd.setLabelAlign(LabelAlign.RIGHT);
        lcStdGrid.setLayout(frmlytStd);


        ContentPanel cpGrid = new ContentPanel();
        cpGrid.setBodyBorder(false);
        cpGrid.setHeaderVisible(false);
        cpGrid.setLayout(new FitLayout());
        cpGrid.setSize(312, 330);

        MSFCustomForm msfCustomForm = new MSFCustomForm(payr0650LeftDef, 0, 0, false, false, false);
        msfCustomForm.setHeaderVisible(false);
        payr0650LeftGridPanel = new MSFGridPanel(this.payr0650LeftDef, false, false, false, false, false);
        payr0650LeftGridPanel.setHeaderVisible(false);
        payr0650LeftGridPanel.setBodyBorder(true);
        payr0650LeftGridPanel.setBorders(true);
        payr0650LeftGridPanel.setMSFFormPanel(msfCustomForm);

        Grid payr0650LeftGrid = payr0650LeftGridPanel.getMsfGrid().getGrid();
        payr0650LeftGrid.addListener(Events.RowClick, new Listener<BaseEvent>() {
            public void handleEvent(BaseEvent be) {
                if (payr0650LeftGridPanel.getCurrentlySelectedItem() != null) {
                    bmData = new BaseModel();
                    bmData = payr0650LeftGridPanel.getCurrentlySelectedItem();

                    aimenrNm.setValue((String) bmData.get("aimenrNm"));                     //이름
                    aimenrResnRegnNum.setValue((String) bmData.get("aimenrResnRegnNum"));            //주민번호
                    aimenrZpcd.setValue((String) bmData.get("aimenrZpcd"));                   //우편번호
                    aimenrDeptNm.setValue((String) bmData.get("deptNm"));                       //부서
                    aimenrBusinNm.setValue((String) bmData.get("businNm"));                      //사업
                    aimenrRoadNmAddr.setValue((String) bmData.get("aimenrRoadNmAddr"));             //주소
                    aimenrPhnNum.setValue((String) bmData.get("aimenrPhnNum"));                 //전화번호
                    degtrNm.setValue((String)bmData.get("degtrNm"));
                    corpNmFmnm.setValue((String)bmData.get("corpNmFmnm"));
                    busoprRgstnNum.setValue((String)bmData.get("busoprRgstnNum"));
                    busoprResnRegnNum.setValue((String)bmData.get("busoprResnRegnNum"));
                    corpNum.setValue((String)bmData.get("corpNum"));
                    incmRegrstDebrZpcd.setValue((String)bmData.get("incmRegrstDebrZpcd"));
                    incmRegrstDebrFndtnAddr.setValue((String)bmData.get("incmRegrstDebrFndtnAddr"));
                    incmRegrstDebrDtlPatrAddr.setValue((String)bmData.get("incmRegrstDebrDtlPatrAddr"));
                    pernChrgDeptNm.setValue((String)bmData.get("pernChrgDeptNm"));
                    pernChrgPhnNum.setValue((String)bmData.get("pernChrgPhnNum"));
                    pernChrgNm.setValue((String)bmData.get("pernChrgNm"));
                    ectnMailAddr.setValue((String)bmData.get("ectnMailAddr"));
                    rightGridReload(bmData);
                }
            }
        });

        cpGrid.add(payr0650LeftGridPanel);

        //  cpGrid.add(grid);
        //  grid.setHeight("395px");
        lcStdGrid.add(cpGrid);

        return lcStdGrid;

    }

    private LayoutContainer rightGrid() {

        LayoutContainer lcStdGrid = new LayoutContainer();
        lcStdGrid.setStyleAttribute("paddingRight", "10px");
        FormLayout frmlytStd = new FormLayout();


        //  frmlytStd.setLabelWidth(85);
        // frmlytStd.setLabelAlign(LabelAlign.RIGHT);
        lcStdGrid.setLayout(frmlytStd);


        ContentPanel cpGrid = new ContentPanel();
        cpGrid.setBodyBorder(false);
        cpGrid.setHeaderVisible(false);
        cpGrid.setLayout(new FitLayout());
        cpGrid.setSize(590, 225);

        MSFCustomForm msfCustomForm = new MSFCustomForm(payr0650RightDef, 0, 0, false, false, false);
        msfCustomForm.setHeaderVisible(false);
        payr0650RightGridPanel = new MSFGridPanel(this.payr0650RightDef, false, false, false, false, false);
        payr0650RightGridPanel.setHeaderVisible(false);
        payr0650RightGridPanel.setBodyBorder(true);
        payr0650RightGridPanel.setBorders(true);
        payr0650RightGridPanel.setMSFFormPanel(msfCustomForm);

        cpGrid.add(payr0650RightGridPanel);

        //  cpGrid.add(grid);
        //  grid.setHeight("395px");
        lcStdGrid.add(cpGrid);

        return lcStdGrid;

    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * 그리드 처리 함수 종료
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     **/

    public void formInit() {
        // grid init
        payr0650LeftGridPanel.getMsfGrid().clearData();
        payr0650RightGridPanel.getMsfGrid().clearData();

        srhDilWrkrIncmBlggYr.reset();
        srhDilWrkrBlggQatrDivCd.reset();
        srhAimenrNm.reset();
        srhResnRegnNum.reset();
        srhSystemkey.reset();
        srhDeptCd.reset();
        srhBusinCd.reset();
        srhPayrMangDeptCd.reset();

        arrgtDilWrkrIncmBlggYr.reset();
        arrgtDilWrkrBlggQatrDivCd.reset();
        arrgtAimenrNm.reset();
        arrgtResnRegnNum.reset();
        arrgtSystemkey.reset();
        arrgtDeptCd.reset();
        arrgtBusinCd.reset();
        arrgtPayrMangDeptCd.reset();

        aimenrNm.reset();
        aimenrResnRegnNum.reset();
        aimenrZpcd.reset();
        aimenrDeptNm.reset();
        aimenrBusinNm.reset();
        aimenrRoadNmAddr.reset();
        aimenrPhnNum.reset();

        printMethod.reset();


        actionDatabase = ActionDatabase.READ;
    }

    public void reload() {
        // TODO Auto-generated method stub

        IColumnFilter filters = null;

        this.payr0650LeftGridPanel.getTableDef().setTableColumnFilters(filters);

        /* 귀속년도 */
        this.payr0650LeftGridPanel.getTableDef().addColumnFilter("dilWrkrIncmBlggYr", MSFSharedUtils.getSelectedComboValue(srhDilWrkrIncmBlggYr, "year"), SimpleColumnFilter.OPERATOR_EQUALS);

        /* 귀속분기 */
        String srhDilWrkrIncmBlggQatrDivCdArr = PayrUtils.getStrValToBMMultiCombo(lsDilWrkrBlggQatrDivCd, srhDilWrkrBlggQatrDivCd.getValue(), "commCdNm", "commCd");
        this.payr0650LeftGridPanel.getTableDef().addColumnFilter("dilWrkrIncmBlggQatrDivCdArr", srhDilWrkrIncmBlggQatrDivCdArr, SimpleColumnFilter.OPERATOR_EQUALS);

        /* 단위기관 */
        this.payr0650LeftGridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd, "payrMangDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS);

      //20180305추가 
        this. payr0650LeftGridPanel.getTableDef().addColumnFilter("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
      		
        /* 소득자성명 */
//        this.payr0650LeftGridPanel.getTableDef().addColumnFilter("aimenrNm", MSFSharedUtils.allowNulls(srhAimenrNm.getRawValue()), SimpleColumnFilter.OPERATOR_EQUALS);

        /* systemkey */
        this.payr0650LeftGridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(srhSystemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);

        /* 부서 */
        this.payr0650LeftGridPanel.getTableDef().addColumnFilter("deptCd", MSFSharedUtils.getSelectedComboValue(srhDeptCd, "deptCd"), SimpleColumnFilter.OPERATOR_EQUALS);

        /* 사업 */
        this.payr0650LeftGridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd, "businCd"), SimpleColumnFilter.OPERATOR_EQUALS);

        if ("".equals(MSFSharedUtils.getSelectedComboValue(srhDilWrkrIncmBlggYr, "year"))) {
            MessageBox.info("지급내역정리", "귀속년도를 선택해주세요", null);

        } else if ("".equals(srhDilWrkrIncmBlggQatrDivCdArr)) {
            MessageBox.info("지급내역정리", "귀속분기를 선택해주세요", null);

        } else if ("".equals(MSFSharedUtils.getSelectedComboValue(srhDeptCd, "deptCd"))) {
            MessageBox.info("지급내역정리", "부서를 선택해주세요", null);

        } else if ("".equals(MSFSharedUtils.getSelectedComboValue(srhBusinCd, "businCd"))) {
            MessageBox.info("지급내역정리", "사업을 선택해주세요", null);
        } else {
            dilWrkrIncmBlggYr = new HiddenField();
            deptCd = new HiddenField();
            businCd = new HiddenField();
            dilWrkrIncmBlggQatrDivCdArr = new HiddenField();
            dilWrkrIncmBlggYr.setValue(MSFSharedUtils.getSelectedComboValue(srhDilWrkrIncmBlggYr, "year"));
            deptCd.setValue(MSFSharedUtils.getSelectedComboValue(srhDeptCd, "deptCd"));
            businCd.setValue(MSFSharedUtils.getSelectedComboValue(srhBusinCd, "businCd"));
            dilWrkrIncmBlggQatrDivCdArr.setValue(srhDilWrkrIncmBlggQatrDivCdArr);

            this.payr0650LeftGridPanel.reload();

            printAllow = true;  //조회 완료 시, 프린트 출력 가능 플래그
        }
    }

    public void rightGridReload(BaseModel bmData) {

        IColumnFilter filters = null;
        payr0650RightGridPanel.getTableDef().setTableColumnFilters(filters);

        /** SYSTEMKEY */
        payr0650RightGridPanel.getTableDef().addColumnFilter("systemkey", (String) bmData.get("systemkey"), SimpleColumnFilter.OPERATOR_EQUALS);

        payr0650RightGridPanel.reload();
    }

    public void setRecord(BaseModel record) {
        this.record = record;
    }


    private Payr4600 getThis() {
        return this;
    }

    private void fnPopupPsnl0100(String tg) {
        //검색폼을 만들어 팝업으로 넘김. msfgrigpanel 내용을 이용함.
        //넘긴데이터는 폼에 검색조건을 필터링에 넣은 작업을한다.
        //검색.처리하면됨.
        MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpPrgmCom0100Form(srhAimenrNm.getValue());  //인사
        //  MSFFormPanel popCom0100 = PrgmComPopupUtils.lovPopUpMsfCom0120Form();  //우편번호

        final FormBinding popBindingCom0100 = popCom0100.getFormBinding();
        final String target = tg;
        popBindingCom0100.addListener(Events.Change, new Listener<BaseEvent>() {
            public void handleEvent(BaseEvent be) {
                BaseModel mapModel = (BaseModel) be.getSource();
                if (!"".equals(mapModel.get("systemkey"))) {
                    if ("srh".equals(target)) {
                        srhSystemkey.setValue(MSFSharedUtils.allowNulls(mapModel.get("systemkey")));   //시스템키
                        srhAimenrNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("hanNm")));
                        srhResnRegnNum.setValue(MSFSharedUtils.allowNulls(mapModel.get("resnRegnNum")));   //주민번호
                    } else if ("arrgt".equals(target)) {
                        arrgtSystemkey.setValue(MSFSharedUtils.allowNulls(mapModel.get("systemkey")));   //시스템키
                        arrgtAimenrNm.setValue(MSFSharedUtils.allowNulls(mapModel.get("hanNm")));
                        arrgtResnRegnNum.setValue(MSFSharedUtils.allowNulls(mapModel.get("resnRegnNum")));   //주민번호
                    }
                }

            }
        });
    }


    private void Payr4600Print() {
        String strDirPath = "PAYR";

        // 보낼 파라미터
        String dilWrkrIncmBlggYr = MSFSharedUtils.getSelectedComboValue(srhDilWrkrIncmBlggYr, "year");
        String dilWrkrIncmBlggQatrDivCd = PayrUtils.getStrValToBMMultiCombo(lsDilWrkrBlggQatrDivCd, srhDilWrkrBlggQatrDivCd.getValue(), "commCdNm", "commCd");
        String deptCd = MSFSharedUtils.getSelectedComboValue(srhDeptCd, "deptCd");
        String mangeDeptCd = MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd") ;
        
        String businCd = MSFSharedUtils.getSelectedComboValue(srhBusinCd, "businCd");
        String printTo = MSFSharedUtils.getSelectedComboValue(printMethod, "commCd");

        String searchParam = "";

        String fileName = "PAYR4600_" + ("1".equals(printTo) ? "A" : "B") + ".crf";

        /* 분기별제출집계표 */
        if ("1".equals(printTo)) {

            String systemkey = MSFSharedUtils.allowNulls(srhSystemkey.getValue()); //

            searchParam = "";
            searchParam += "" + dilWrkrIncmBlggYr + "⊥";
            searchParam += "" + dilWrkrIncmBlggQatrDivCd + "⊥";
            searchParam += "" + deptCd + "⊥";
            searchParam += "" + businCd + "⊥";
            searchParam += "" + systemkey + "⊥";

            System.out.println("searchParam :: [" + searchParam + "]");

            //GWT 타입으로 팝업 호출시  postCall true 설정
            PrintUtils.setPostCall(true);
            PrintUtils.rexPrint(strDirPath, fileName, searchParam);


        } else { /* 보관용 */
            /* 전체데이터를 가져온다 */
            Iterator<BaseModel> itBm = payr0650LeftGridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator();
            List<Record> lsRec = new ArrayList();
            while (itBm.hasNext()) {
                Record rec = new Record(itBm.next());
                lsRec.add(rec);
            }

            Iterator<Record> iterRecords = lsRec.iterator();
            String systemkey = "";
            while (iterRecords.hasNext()) {

                Record recData = iterRecords.next();
                BaseModel bmMapModel = (BaseModel) recData.getModel();
                systemkey += bmMapModel.get("systemkey") + ",";

            }
            /* printTo 2 - 지급자보관용
               printTo 3 - 소득자보관용
             */

            systemkey = systemkey.substring(0, systemkey.length() - 1); // 마지막 콤마 제거

            searchParam = "";
            searchParam += "" + dilWrkrIncmBlggYr + "⊥";
            searchParam += "" + dilWrkrIncmBlggQatrDivCd + "⊥";
            searchParam += "" + deptCd + "⊥";
            searchParam += "" + businCd + "⊥";
            searchParam += "" + systemkey + "⊥";
            searchParam += "" + printTo + "⊥";

            System.out.println("searchParam :: [" + searchParam + "]");

            PrintUtils.setPostCall(true);
            PrintUtils.rexPrint(strDirPath, fileName, searchParam);
        }

        // reb 출력물

    }

    //엑셀 양식 저장
    private void xlsExportData() {

        HashMap<String, String> param = new HashMap();

        /* 귀속년도 */
        param.put("dilWrkrIncmBlggYr", MSFSharedUtils.getSelectedComboValue(srhDilWrkrIncmBlggYr, "year"));

        /* 귀속분기 */
        String srhDilWrkrIncmBlggQatrDivCdArr = PayrUtils.getStrValToBMMultiCombo(lsDilWrkrBlggQatrDivCd, srhDilWrkrBlggQatrDivCd.getValue(), "commCdNm", "commCd");
        param.put("srhDilWrkrIncmBlggQatrDivCdArr", srhDilWrkrIncmBlggQatrDivCdArr);

        /* 단위기관 */
        param.put("payrMangDeptCd", MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd, "payrMangDeptCd"));

        param.put("mangeDeptCd", MSFSharedUtils.getSelectedComboValue(srhMangeDeptCd,"mangeDeptCd"));
		
        /* 전체데이터를 가져온다 */
        Iterator<BaseModel> itBm = payr0650LeftGridPanel.getMsfGrid().getGrid().getStore().getModels().listIterator();
        List<Record> lsRec = new ArrayList();
        while (itBm.hasNext()) {
            Record rec = new Record(itBm.next());
            lsRec.add(rec);
        }

        Iterator<Record> iterRecords = lsRec.iterator();
        String systemkey = "";
        while (iterRecords.hasNext()) {

            Record recData = iterRecords.next();
            BaseModel bmMapModel = (BaseModel) recData.getModel();
            systemkey += bmMapModel.get("systemkey") + ",";

        }

        systemkey = systemkey.substring(0, systemkey.length() - 1); // 마지막 콤마 제거

        /* systemkey */
        param.put("systemkeyArr", systemkey);

        /* 부서 */
        param.put("deptCd", MSFSharedUtils.getSelectedComboValue(srhDeptCd, "deptCd"));

        /* 사업 */
        param.put("businCd", MSFSharedUtils.getSelectedComboValue(srhBusinCd, "businCd"));

        payr0650RightGridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsPayr4600Export.do", "extgwtFrame", param);

    }
 

    /************************************************************************
     * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출
     ************************************************************************/
    /**
     * <pre>
     * 1. 개요 : 화면별 에러로그 확인 처리 를위해 추가 된 부분....
     * 2. 처리내용 :
     * </pre>
     *
     * @param wndName
     * @param wndId
     * @Method Name : funcLogMessage
     * @date : 2016. 9. 2.
     * @author : Administrator
     * @history :
     * -----------------------------------------------------------------------
     * 변경일				작성자						변경내용
     * ----------- ------------------- ---------------------------------------
     * 2016. 9. 2.		Administrator				최초 작성
     * -----------------------------------------------------------------------
     */
    public void funcLogMessage(String wndName, String wndId) {

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
