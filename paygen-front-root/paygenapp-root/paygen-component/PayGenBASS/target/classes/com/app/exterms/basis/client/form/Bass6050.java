package com.app.exterms.basis.client.form;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.basis.client.dto.Bass6050DTO;
import com.app.exterms.basis.client.form.defs.Bass6050Def;
import com.app.exterms.basis.client.languages.BasisConstants;
import com.app.exterms.basis.client.service.Bass6050Service;
import com.app.exterms.basis.client.service.Bass6050ServiceAsync;
import com.app.exterms.basis.client.utils.BasisUtil;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.GregorianCalendar;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.MSFComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFDateField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFNumberField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTextArea;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FormEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
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
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
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
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class Bass6050 extends MSFPanel {
    /**
     * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     * 전역변수 선언부  시작
     * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     **/
    private BasisConstants lblRemtConst = BasisConstants.INSTANCE;

    private VerticalPanel vp;
    private FormPanel plFrmRemt0050;
    private String txtForm = "";
    private XTemplate detailTp;

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
    //권한 설정 객체
//	  private GWTAuthorization gwtAuthorization;
//	  private GWTExtAuth gwtExtAuth;
//	  private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 

    /**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 입력 변수 선언
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */


    //---------------상세정보 시작----------------
    /**
     * column 사업장코드 : dpobCd
     */
    private HiddenField<String> dpobCd;
    /**
     * column 퇴직금가산율일련번호 : sevePayAddRateSeilNum
     */
    private MSFNumberField sevePayAddRateSeilNum;
    /**
     * column 직종코드 : typOccuCd
     */
    private MSFComboBox<BaseModel> typOccuCd;
    /**
     * column  직종세통합코드 : dtilOccuInttnCd
     */
    private MSFComboBox<BaseModel> dtilOccuInttnCd;
    /**
     * column 호봉등급코드 : pyspGrdeCd
     */
    private HiddenField<String> pyspGrdeCd;
    /**
     * column 퇴직금가산율유형코드 : dtSevePayAddRateFrmCd
     */
    private MSFComboBox<BaseModel> dtSevePayAddRateFrmCd;
    /**
     * column 퇴직금가산이상 : sevePayAddOvr
     */
    private MSFNumberField sevePayAddOvr;
    /**
     * column 퇴직금가산미만 : sevePayAddUdr
     */
    private MSFNumberField sevePayAddUdr;
    /**
     * column 퇴직금가산금액 : sevePayAddSum
     */
    private MSFNumberField sevePayAddSum;
    /**
     * column 퇴직금가산율 : sevePayAddRate
     */
    private MSFNumberField sevePayAddRate;
    /**
     * column 퇴직금가산시작일자 : sevePayAddBgnnDt
     */
    private MSFDateField sevePayAddBgnnDt;
    /**
     * column 퇴직금가산종료일자 : sevePayAddEndDt
     */
    private MSFDateField sevePayAddEndDt;
    /**
     *  column 사용여부 : sevePayAddUseYn
     */
    private CheckBox sevePayAddUseYn;
    /**
     *  column 비고 : sevePayNoteCtnt
     */
    private MSFTextArea sevePayNoteCtnt;
    private CheckBoxGroup dtilOccuClsUseGrp;
    /**
     * column 퇴직금비고내용 : sevePayNoteCtnt
     */
    // -------------- 상세정보 종료 --------------

    Date today = new Date();        // 오늘 날짜 가져오는 코드
    private BaseModel bmData = new BaseModel();    //외부에서 사용하기 위하여 bmData를 선언한다. RowClick에서 사용되며 상세조건 이벤트에서도 적용된다.

    // -------------- grid 선언 시작 --------------
    private Bass6050Def remt1000Def = new Bass6050Def();   //그리드 테이블 컬럼 define
    // private MSFCustomForm msfCustomForm;
    private MSFGridPanel remt1000GridPanel;
    // -------------- grid 선언 종료 --------------


    // -------------- 상위 버튼 선언 시작 --------------
    private ButtonBar topRemt0050Bar;
    private Button btnRemt0050New;
    private Button btnRemt0050Save;
    private Button btnRemt0050Del;
    private Button btnRemt0050Sreach;
    // -------------- 상위 버튼 선언 종료 --------------

    private List<ModelData> mDtalistDtilOccuInttnCd;

    //파일업로드처리 부분
    private FileUploadField remt0050flUp;
    private Boolean picBoolFile;

    private boolean mutilCombo = false;


    private Bass6050ServiceAsync remt0050Service = Bass6050Service.Util.getInstance();

    private ListStore<BaseModel> lsTypOccuCd = new ListStore<BaseModel>();            //직종 검색
    private ListStore<BaseModel> lsDtilOccuInttnCd = new ListStore<BaseModel>();    //직종세 검색
    private ListStore<BaseModel> stTypOccuCd = new ListStore<BaseModel>();            //직종 상세
    private ListStore<BaseModel> stDtilOccuClsDivCd = new ListStore<BaseModel>();    //직종세 상세
    private ListStore<BaseModel> lsSevePayAddRateFrmCd = new ListStore<BaseModel>();//퇴직금가산율유형코드 검색

    private PrgmComBass0300DTO sysComBass0300Dto; //공통코드 dto
    private PrgmComBass0320DTO sysComBass0320Dto; //공통코드 dto
    private PrgmComBass0350DTO sysComBass0350Dto; //직종세


    private BaseModel record;

    private ComboBox<BaseModel> srhTypOccuCd;   //직종
    // private HiddenField<String> srhPyspGrdeCd;  //호봉등급
    private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; //직종세
    private ComboBox<BaseModel> dtDtilOccuClsDivCd;        //직종세 상세
    private ComboBox<BaseModel> srhSevePayAddRateFrmCd; //퇴직금가산율유형코드
    private ComboBox<BaseModel> dtilSevePayAddRateFrmCd; //퇴직금가산율유형코드 상세

    /**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 선택된 버튼에 따른 인서트 업데이트 삭제 처리 부
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */
    private SelectionListener<ButtonEvent> selectionListener = new SelectionListener<ButtonEvent>() {
        public void componentSelected(ButtonEvent ce) {
            if (ce.getButton() == btnRemt0050Save) {
                if (ActionDatabase.INSERT.equals(actionDatabase)) {
                    doAction(ActionDatabase.INSERT);
                } else if (ActionDatabase.UPDATE.equals(actionDatabase)) {
                    doAction(ActionDatabase.UPDATE);
                }
            } else if (ce.getButton() == btnRemt0050Del) {

                // 선택한 대상이 없을 경우
                if (MSFSharedUtils.paramNull(BasisUtil.getSelectedComboValue(typOccuCd, "typOccuCd"))) {
                    MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),
                            "[알림] 삭제할 데이터의 행을 더블클릭하여 선택해주세요.", null);
                    return;
                }
                doAction(ActionDatabase.DELETE);
            }
        }
    };

    private void doAction(ActionDatabase actionDatabase) {
        save(actionDatabase);
    }

    public void save(final ActionDatabase actionDatabase) {

        final Bass6050DTO dto = new Bass6050DTO();

        if ("".equals(BasisUtil.getSelectedComboValue(typOccuCd, "typOccuCd"))) {
            MessageBox.info("", "직종을 선택하여 주세요.", null);
        } else if (GregorianCalendar.compareDate(sevePayAddBgnnDt.getValue(), sevePayAddEndDt.getValue()) < 0) {
            MessageBox.info("", "기간 설정이 잘못되었습니다. 확인하십시요.", null);
        } else {

            dto.setDpobCd(MSFMainApp.get().getUser().getDpobCd());                                                            // 사업장코드
            dto.setSevePayAddRateSeilNum((Long) sevePayAddRateSeilNum.getValue());                                            // 퇴직금가산율일련번호
            dto.setTypOccuCd(BasisUtil.getSelectedComboValue(typOccuCd, "typOccuCd"));                                // 직종코드
            dto.setDtilOccuInttnCd(BasisUtil.getSelectedComboValue(dtilOccuInttnCd, "dtilOccuInttnCd"));                // 직종세통합코드
            dto.setSevePayAddRateFrmCd(BasisUtil.getSelectedComboValue(dtSevePayAddRateFrmCd));                                // 퇴직금가산율유형코드
            dto.setSevePayAddOvr((Long) sevePayAddOvr.getValue());                                                            // 퇴직금가산이상
            dto.setSevePayAddUdr((Long) sevePayAddUdr.getValue());                                                            // 퇴직금가산미만
            dto.setSevePayAddSum((Long) sevePayAddSum.getValue());                                                            // 퇴직금가산금액
            dto.setSevePayAddRate((Long) sevePayAddRate.getValue());                                                            // 퇴직금가산율
            dto.setSevePayAddBgnnDt(BasisUtil.getConvertDateToString(sevePayAddBgnnDt, "yyyyMMdd"));                // 퇴직금가산시작일자
            dto.setSevePayAddEndDt(BasisUtil.getConvertDateToString(sevePayAddEndDt, "yyyyMMdd"));                    // 퇴직금가산종료일자
            dto.setSevePayAddUseYn(sevePayAddUseYn.getValue());                                                                // 퇴직금가산사용여부
            dto.setSevePayNoteCtnt(sevePayNoteCtnt.getValue());                                                                // 퇴직금비고내용
            MessageBox.confirm("", "DELETE".equals(actionDatabase.name()) ? "삭제 하시겠습니까?" : "저장 하시겠습니까?", new Listener<MessageBoxEvent>() {
                @Override
                public void handleEvent(MessageBoxEvent be) {

                    if (Dialog.YES.equals(be.getButtonClicked().getItemId())) {
                        remt0050Service.saveBass6050Save(dto, actionDatabase, new AsyncCallback<Long>() {
                            @Override
                            public void onSuccess(Long result) {
                                if ("DELETE".equals(actionDatabase.name())) {
                                    MessageBox.info("", "삭제 되었습니다.", null);
                                } else {
                                    MessageBox.info("", "저장 되었습니다.", null);
                                }
                                reload();
                            }

                            @Override
                            public void onFailure(Throwable caught) {
                                caught.printStackTrace();
                                MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),
                                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("saveBass6050Save(" + actionDatabase.name() + ") : " + caught)
                                        , null);
                            }
                        });
                    }
                }
            });
        }
    }

    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * 기본등록화면 입력 시작
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     **/
    private void createStandardForm() {
        /**
         * 지역변수 선언부
         */
        sysComBass0300Dto = new PrgmComBass0300DTO();
        sysComBass0350Dto = new PrgmComBass0350DTO();
        sysComBass0320Dto = new PrgmComBass0320DTO();

        stTypOccuCd = new ListStore<BaseModel>();    //직종
        stTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto);

        stDtilOccuClsDivCd = new ListStore<BaseModel>();    //직종세
        stDtilOccuClsDivCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto);    //직종콤보공통

        sysComBass0300Dto.setRpsttvCd("R001");    //가산율유형
        lsSevePayAddRateFrmCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);


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

        sevePayAddRateSeilNum = new MSFNumberField();
        sevePayAddRateSeilNum.setReadOnly(true);
        sevePayAddRateSeilNum.setName("sevePayAddRateSeilNum");
        sevePayAddRateSeilNum.setFieldLabel("번호");
        /**TextField를 사용하기 위한 선언*/
        sevePayAddRateSeilNum.setAllowDecimals(true);
        sevePayAddRateSeilNum.setPropertyEditorType(Long.class);
        sevePayAddRateSeilNum.setFormat(NumberFormat.getDecimalFormat());
        /**TextField를 사용하기 위한 선언 끝*/
        lcStdLeftFrm.add(sevePayAddRateSeilNum, new FormData("100%"));

        typOccuCd = new MSFComboBox<BaseModel>();
        typOccuCd.setName("typOccuCd");
        typOccuCd.setFieldLabel("직종");
        typOccuCd.setForceSelection(true);
        typOccuCd.setMinChars(1);
        typOccuCd.setDisplayField("typOccuNm");
        typOccuCd.setValueField("typOccuCd");
        typOccuCd.setTriggerAction(TriggerAction.ALL);
        typOccuCd.setEmptyText("== 직종 선택 ==");
        typOccuCd.setSelectOnFocus(true);
        typOccuCd.setReadOnly(false);
        typOccuCd.setEnabled(false);
        typOccuCd.setStore(lsTypOccuCd);

        typOccuCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
                sysComBass0350Dto.setTypOccuCd(MSFSharedUtils.getSelectedComboValue(typOccuCd, "typOccuCd"));
                if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
                    stDtilOccuClsDivCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto);
                    stDtilOccuClsDivCd.addStoreListener(new StoreListener<BaseModel>() {
                        public void handleEvent(StoreEvent<BaseModel> be) {
                            lsDtilOccuInttnCd = stDtilOccuClsDivCd;
                            dtilOccuInttnCd.setStore(lsDtilOccuInttnCd);
                            dtilOccuInttnCd.reloadData();
                            BasisUtil.setSelectedComboValue(dtilOccuInttnCd, (String) bmData.get("dtilOccuInttnCd$dtilOccuInttnCd"), "dtilOccuInttnCd");
                        }
                    });
                }
            }
        });
        lcStdCenterFrm.add(typOccuCd, new FormData("100%"));

        dtilOccuInttnCd = new MSFComboBox<BaseModel>();
        dtilOccuInttnCd.setName("dtilOccuInttnCd");
        dtilOccuInttnCd.setFieldLabel("직종세");
        dtilOccuInttnCd.setForceSelection(true);
        dtilOccuInttnCd.setMinChars(1);
        dtilOccuInttnCd.setDisplayField("dtilOccuClsNm");
        dtilOccuInttnCd.setValueField("dtilOccuInttnCd");
        dtilOccuInttnCd.setTriggerAction(TriggerAction.ALL);
        dtilOccuInttnCd.setEmptyText("== 직종세 선택 ==");
        dtilOccuInttnCd.setSelectOnFocus(true);
        dtilOccuInttnCd.setReadOnly(false);
        dtilOccuInttnCd.setEnabled(false);
        dtilOccuInttnCd.setStore(lsDtilOccuInttnCd);
        lcStdRightFrm.add(dtilOccuInttnCd, new FormData("100%"));


        dtSevePayAddRateFrmCd = new MSFComboBox<BaseModel>();
        dtSevePayAddRateFrmCd.setName("dtSevePayAddRateFrmCd");
        dtSevePayAddRateFrmCd.setFieldLabel("가산율유형");
        dtSevePayAddRateFrmCd.setForceSelection(true);
        dtSevePayAddRateFrmCd.setMinChars(1);
        dtSevePayAddRateFrmCd.setDisplayField("commCdNm");
        dtSevePayAddRateFrmCd.setValueField("commCd");
        dtSevePayAddRateFrmCd.setTriggerAction(TriggerAction.ALL);
        dtSevePayAddRateFrmCd.setEmptyText("== 가산율유형 선택 ==");
        dtSevePayAddRateFrmCd.setSelectOnFocus(true);
        dtSevePayAddRateFrmCd.setReadOnly(false);
        dtSevePayAddRateFrmCd.setEnabled(false);
        dtSevePayAddRateFrmCd.setStore(lsSevePayAddRateFrmCd);
        lcStdLeftFrm.add(dtSevePayAddRateFrmCd, new FormData("100%"));

        sevePayAddOvr = new MSFNumberField();
        sevePayAddOvr.setName("sevePayAddOvr");
        sevePayAddOvr.setFieldLabel("가산이상");
        sevePayAddOvr.setAllowDecimals(true);
        sevePayAddOvr.setPropertyEditorType(Long.class);
        sevePayAddOvr.setFormat(NumberFormat.getDecimalFormat());
        sevePayAddOvr.setEnabled(false);
        lcStdCenterFrm.add(sevePayAddOvr, new FormData("100%"));

        sevePayAddUdr = new MSFNumberField();
        sevePayAddUdr.setName("sevePayAddUdr");
        sevePayAddUdr.setFieldLabel("가산미만");
        sevePayAddUdr.setAllowDecimals(true);
        sevePayAddUdr.setPropertyEditorType(Long.class);
        sevePayAddUdr.setFormat(NumberFormat.getDecimalFormat());
        sevePayAddUdr.setEnabled(false);
        lcStdRightFrm.add(sevePayAddUdr, new FormData("100%"));

        sevePayAddSum = new MSFNumberField();
        sevePayAddSum.setName("sevePayAddSum");
        sevePayAddSum.setFieldLabel("가산금액");
        sevePayAddSum.setAllowDecimals(true);
        sevePayAddSum.setPropertyEditorType(Long.class);
        sevePayAddSum.setFormat(NumberFormat.getDecimalFormat());
        sevePayAddSum.setEnabled(false);
        lcStdLeftFrm.add(sevePayAddSum, new FormData("100%"));

        sevePayAddRate = new MSFNumberField();
        sevePayAddRate.setName("sevePayAddRate");
        sevePayAddRate.setFieldLabel("가산율");
        sevePayAddRate.setAllowDecimals(true);
        sevePayAddRate.setPropertyEditorType(Long.class);
        sevePayAddRate.setFormat(NumberFormat.getDecimalFormat());
        sevePayAddRate.setEnabled(false);
        lcStdCenterFrm.add(sevePayAddRate, new FormData("100%"));

        dtilOccuClsUseGrp = new CheckBoxGroup();
        dtilOccuClsUseGrp.setName("dtilOccuClsUseGrp");
        dtilOccuClsUseGrp.setLabelSeparator("");

        sevePayAddUseYn = new CheckBox();
        sevePayAddUseYn.setName("sevePayAddUseYn");
        dtilOccuClsUseGrp.add(sevePayAddUseYn);
        sevePayAddUseYn.setBoxLabel("사용");
        sevePayAddUseYn.setHideLabel(true);
        sevePayAddUseYn.setEnabled(false);
        lcStdRightFrm.add(dtilOccuClsUseGrp, new FormData("100%"));

        sevePayAddBgnnDt = new MSFDateField();
        sevePayAddBgnnDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
        sevePayAddBgnnDt.setName("sevePayAddBgnnDt");
        new DateFieldMask(sevePayAddBgnnDt, "9999.99.99");
        sevePayAddBgnnDt.setFieldLabel("시작일자");
        sevePayAddBgnnDt.setMinLength(10);
        sevePayAddBgnnDt.setMaxLength(10);
        sevePayAddBgnnDt.setEnabled(false);
        lcStdLeftFrm.add(sevePayAddBgnnDt, new FormData("100%"));

        sevePayAddEndDt = new MSFDateField();
        sevePayAddEndDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
        sevePayAddEndDt.setName("sevePayAddEndDt");
        new DateFieldMask(sevePayAddEndDt, "9999.99.99");
        sevePayAddEndDt.setFieldLabel("종료일자");
        sevePayAddEndDt.setMinLength(10);
        sevePayAddEndDt.setMaxLength(10);
        sevePayAddEndDt.setEnabled(false);
        lcStdCenterFrm.add(sevePayAddEndDt, new FormData("100%"));

        sevePayNoteCtnt = new MSFTextArea();
        sevePayNoteCtnt.setFieldLabel("비고");
        sevePayNoteCtnt.setSize(208, 25);
        sevePayNoteCtnt.setEnabled(false);
        lcStdRightFrm.add(sevePayNoteCtnt, new FormData("99.5%"));

        lcStdColStdFrm.add(lcStdLeftFrm, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
        lcStdColStdFrm.add(lcStdCenterFrm, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
        lcStdColStdFrm.add(lcStdRightFrm, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
        fieldSetStdFrm.add(lcStdColStdFrm, new FormData("100%"));

        plFrmRemt0050.add(fieldSetStdFrm);

    }

    private void createSubForm() {

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
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(0);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        layoutContainer_4.setLayout(frmlytSch);
        layoutContainer_4.setBorders(false);

        remt0050flUp = new FileUploadField();
        remt0050flUp.setName("remt0050flUp");
        remt0050flUp.setValidator(new Validator() {
            @Override
            public String validate(Field<?> field, String value) {
                value = value.toLowerCase();
                String result = "xls 파일이 아닙니다., 다시선택하십시요.";
                if (value.endsWith(".xls") || value.endsWith(".xlsx")) {
                    result = null;
                }
                return result;
            }
        });
        layoutContainer_2_1.add(remt0050flUp, new FormData("100%"));
        remt0050flUp.setFieldLabel("직종세");

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

        layoutContainer_2.add(layoutContainer_2_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
        layoutContainer_2.add(layoutContainer_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
        layoutContainer_2.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));

        layoutContainer.add(layoutContainer_2);
        layoutContainer_2.setBorders(false);
        fldstNewFieldset.add(layoutContainer);
        layoutContainer.setBorders(false);

        plFrmRemt0050.add(fldstNewFieldset);

    }


    /**
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * 기본등록화면 입력 종료
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     **/
    public ContentPanel getViewPanel() {
        if (panel == null) {

            detailTp = XTemplate.create(getDetailTemplate());

            vp = new VerticalPanel();
            vp.setSpacing(10);
            createPsnl0100Form();  // 화면 기본정보를 설정
            createSearchForm();    // 검색필드를 적용
            createListGrid();
            createStandardForm();  // 기본정보필드
            createSubForm();       // 엑셀업로드

            vp.setSize("1010px", "700px");
            stDtilOccuClsDivCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto);

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
    public Bass6050() {

        setSize("1010px", "700px");
    }

    public void dtilToggle(boolean to) {
        typOccuCd.setEnabled(to);
        dtilOccuInttnCd.setEnabled(to);
        dtSevePayAddRateFrmCd.setEnabled(to);
        sevePayAddSum.setEnabled(to);
        sevePayAddRate.setEnabled(to);
        sevePayAddUseYn.setEnabled(to);
        sevePayAddBgnnDt.setEnabled(to);
        sevePayAddOvr.setEnabled(to);
        sevePayAddUdr.setEnabled(to);
        sevePayAddEndDt.setEnabled(to);
        sevePayNoteCtnt.setEnabled(to);
    }

    public Bass6050(String txtForm) {
        this.txtForm = txtForm;
    }

    private void createPsnl0100Form() {

        plFrmRemt0050 = new FormPanel();
        //	plFrmRemt0050.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" -  " + lblRemtConst.title_Bugt0050());
        plFrmRemt0050.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 가산율관리"));
        plFrmRemt0050.setIcon(MSFMainApp.ICONS.text());
        plFrmRemt0050.setBodyStyleName("pad-text");
        plFrmRemt0050.setPadding(2);
        plFrmRemt0050.setFrame(true);

        /************************************************************************
         * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출
         ************************************************************************/
        final Button btnlogView = new Button("로그");

        btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
        btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent e) {
                //로그 뷰화면 호출 메서드
                funcLogMessage("가산율관리", "REMT0050");
            }
        });
        plFrmRemt0050.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
        plFrmRemt0050.getHeader().addTool(btnlogView);
        /************************************************************************
         * 화면 에러 처리시 필요한 부분으로 추가
         ************************************************************************/

        //멀티콤보박스 닫기
        plFrmRemt0050.addListener(Events.OnClick, new Listener<ComponentEvent>() {
            @Override
            public void handleEvent(ComponentEvent ce) {
                if (mutilCombo) {
                    if (srhDtilOccuInttnCd.getCheckBoxListHolder().isVisible()) {
                        //직종세
                        srhDtilOccuInttnCd.showClose(ce);
                        mutilCombo = false;
                    }
                }
            }
        });

        topRemt0050Bar = new ButtonBar();
        topRemt0050Bar.setAlignment(HorizontalAlignment.RIGHT);

        btnRemt0050New = new Button("신규");
        btnRemt0050New.setIcon(MSFMainApp.ICONS.new16());
        topRemt0050Bar.add(btnRemt0050New);
        btnRemt0050New.addListener(Events.Select, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent e) {
                //초기화 버튼 클릭시 처리
                formRemt0050Init();
                actionDatabase = ActionDatabase.INSERT;
            }
        });


        btnRemt0050Save = new Button("저장");
        btnRemt0050Save.setIcon(MSFMainApp.ICONS.save16());
        topRemt0050Bar.add(btnRemt0050Save);
        btnRemt0050Save.addSelectionListener(selectionListener);

        btnRemt0050Del = new Button("삭제");
        btnRemt0050Del.setIcon(MSFMainApp.ICONS.delete16());
        topRemt0050Bar.add(btnRemt0050Del);
        btnRemt0050Del.addSelectionListener(selectionListener);


        btnRemt0050Sreach = new Button("조회");
        btnRemt0050Sreach.setIcon(MSFMainApp.ICONS.search16());
        topRemt0050Bar.add(btnRemt0050Sreach);
        btnRemt0050Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
            public void handleEvent(ButtonEvent e) {
                //조회버튼 클릭시 처리 
                reload();
            }
        });
//	  	topBtn = new Button("엑셀"); 
//	  	topBtn.setIcon(MSFMainApp.ICONS.text()); 
//	  	buttonBar.add(topBtn);  


        plFrmRemt0050.add(topRemt0050Bar);

        //파일업로드 처리
//		plFrmRemt0050.setAction("myurl");
//		plFrmRemt0050.setEncoding(Encoding.MULTIPART);
//		plFrmRemt0050.setMethod(Method.POST);

        vp.add(plFrmRemt0050);
        plFrmRemt0050.setSize("990px", "680px");
    }


    /**
     * 검색필드 설정
     */
    private void createSearchForm() {

        // srhPyspGrdeCd = new HiddenField<String>();  //호봉등급

        sysComBass0300Dto = new PrgmComBass0300DTO();
        sysComBass0320Dto = new PrgmComBass0320DTO();
        sysComBass0350Dto = new PrgmComBass0350DTO();
        //--------------------공통 코드 불러 오는 함수 -------------------------------------------
        sysComBass0300Dto.setRpsttvCd("R001");
        lsSevePayAddRateFrmCd = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
        //--------------------공통 코드 불러 오는 함수 -------------------------------------------

        //--------------------공통 코드 불러 오는 함수 -------------------------------------------
        lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto);

        //--------------------공통 코드 불러 오는 함수 -------------------------------------------


        plFrmRemt0050.setLayout(new FlowLayout());

        FieldSet fieldSet = new FieldSet();
        fieldSet.setHeadingHtml("검색조건");
        /****************************************************************
         * 검색조건 배경 변경 스타일시트 추가 시작
         ****************************************************************/
        fieldSet.addStyleName("x-fieldset-serarch-back-color");
        /****************************************************************
         * 검색조건 배경 변경 스타일시트 추가 끝
         ****************************************************************/

        LayoutContainer layoutContainer = new LayoutContainer();
        layoutContainer.setLayout(new FlowLayout(1));

        LayoutContainer layoutContainer_1 = new LayoutContainer();
        layoutContainer_1.setLayout(new ColumnLayout());


        LayoutContainer layoutContainer_3 = new LayoutContainer();
        FormLayout frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(70);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        layoutContainer_3.setLayout(frmlytSch);

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
        srhTypOccuCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
                sysComBass0350Dto.setTypOccuCd(MSFSharedUtils.getSelectedComboValue(srhTypOccuCd, "typOccuCd"));
                if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
                    lsDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto);
                    lsDtilOccuInttnCd.addStoreListener(new StoreListener<BaseModel>() {
                        public void handleEvent(StoreEvent<BaseModel> be) {
                            mDtalistDtilOccuInttnCd = BasisUtil.getDtilOccuInttnCdModelData(lsDtilOccuInttnCd);
                            srhDtilOccuInttnCd.getInitStore().add(mDtalistDtilOccuInttnCd);
                        }
                    });
                }
            }
        });
        layoutContainer_3.add(srhTypOccuCd, new FormData("100%"));
        layoutContainer_1.add(layoutContainer_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
        layoutContainer_3.setBorders(false);

        LayoutContainer lcSchRight = new LayoutContainer();
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(70);
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
        srhDtilOccuInttnCd.setFieldLabel("직종세");
        srhDtilOccuInttnCd.getListView().addListener(Events.BrowserEvent, new Listener<ComponentEvent>() {
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
        layoutContainer_1.add(lcSchRight, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));

        LayoutContainer layoutContainer_4 = new LayoutContainer();
        frmlytSch = new FormLayout();
        frmlytSch.setLabelWidth(70);
        frmlytSch.setLabelAlign(LabelAlign.RIGHT);
        layoutContainer_4.setLayout(frmlytSch);

        srhSevePayAddRateFrmCd = new ComboBox<BaseModel>();
        srhSevePayAddRateFrmCd.setName("srhSevePayAddRateFrmCd");
        srhSevePayAddRateFrmCd.setForceSelection(true);
        srhSevePayAddRateFrmCd.setMinChars(1);
        srhSevePayAddRateFrmCd.setDisplayField("commCdNm");
        srhSevePayAddRateFrmCd.setValueField("commCd");
        srhSevePayAddRateFrmCd.setTriggerAction(TriggerAction.ALL);
        srhSevePayAddRateFrmCd.setEmptyText("--가산율유형선택--");
        srhSevePayAddRateFrmCd.setSelectOnFocus(true);
        srhSevePayAddRateFrmCd.setReadOnly(false);
        srhSevePayAddRateFrmCd.setEnabled(true);
        srhSevePayAddRateFrmCd.setStore(lsSevePayAddRateFrmCd);
        srhSevePayAddRateFrmCd.setFieldLabel("가산율유형");
        layoutContainer_4.add(srhSevePayAddRateFrmCd, new FormData("100%"));
        layoutContainer_1.add(layoutContainer_4, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
        layoutContainer_4.setBorders(false);
        layoutContainer.add(layoutContainer_1);
        layoutContainer_1.setBorders(false);
        fieldSet.add(layoutContainer);
        layoutContainer.setBorders(false);

        plFrmRemt0050.add(fieldSet);
        //vp.add(panel);   
    }


    private void createListGrid() {
        FieldSet fldstNewFieldset = new FieldSet();
        fldstNewFieldset.setHeadingHtml("퇴직금 가산율");
        fldstNewFieldset.setCollapsible(false);

        LayoutContainer lcStdGrid = new LayoutContainer();
        FormLayout frmlytStd = new FormLayout();

        lcStdGrid.setLayout(frmlytStd);

        ContentPanel cpGrid = new ContentPanel();
        cpGrid.setBodyBorder(true);
        cpGrid.setHeaderVisible(false);
        cpGrid.setLayout(new FitLayout());
        cpGrid.setSize(935, 380);

        //Instantiate the GridPanel
        remt1000GridPanel = new MSFGridPanel(remt1000Def, false, false, false, true);
        remt1000GridPanel.setHeaderVisible(false);
        remt1000GridPanel.setBodyBorder(true);
        remt1000GridPanel.setBorders(true);

        final Grid<BaseModel> remt1000Grid = remt1000GridPanel.getMsfGrid().getGrid();
        remt1000Grid.addListener(Events.RowClick, new Listener<BaseEvent>() {
            public void handleEvent(BaseEvent be) {
                if (remt1000GridPanel.getCurrentlySelectedItem() != null) {

                    bmData = new BaseModel();
                    bmData = remt1000GridPanel.getCurrentlySelectedItem();

                    actionDatabase = ActionDatabase.UPDATE;        // DB 저장/신규 구분

                    /** column 사업장코드 : dpobCd */
                    dpobCd.setValue(MSFSharedUtils.allowNulls(bmData.get("dpobCd")));

                    /** column 퇴직금가산율일련번호 : sevePayAddRateSeilNum */
                    sevePayAddRateSeilNum.setValue((Long) bmData.get("sevePayAddRateSeilNum"));

                    /** column 직종코드 : typOccuCd */
                    BasisUtil.setSelectedComboValue(typOccuCd, (String) bmData.get("typOccuCd$typOccuCd"), "typOccuCd");

                    /** column 직종세통합코드 : dtilOccuInttnCd */
                    BasisUtil.setSelectedComboValue(dtilOccuInttnCd, (String) bmData.get("dtilOccuInttnCd$dtilOccuInttnCd"), "dtilOccuInttnCd");

                    /** column 퇴직금가산율유형코드 : sevePayAddRateFrmCd */
                    BasisUtil.setSelectedComboValue(dtSevePayAddRateFrmCd, (String) bmData.get("sevePayAddRateFrmCd$commCd"), "commCd");

                    /** column 퇴직금가산이상 : sevePayAddOvr */
                    sevePayAddOvr.setValue((Long) bmData.get("sevePayAddOvr"));

                    /** column 퇴직금가산미만 : sevePayAddUdr */
                    sevePayAddUdr.setValue((Long) bmData.get("sevePayAddUdr"));

                    /** column 퇴직금가산금액 : sevePayAddSum */
                    sevePayAddSum.setValue((Long) bmData.get("sevePayAddSum"));

                    /** column 퇴직금가산율 :  sevePayAddRate */
                    sevePayAddRate.setValue((Double) bmData.get("sevePayAddRate"));

                    /** column 퇴직금가산시작일자 : sevePayAddBgnnDt */
                    sevePayAddBgnnDt.setValue((Date) bmData.get("sevePayAddBgnnDt"));

                    /** column 퇴직금가산종료일자 : sevePayAddEndDt */
                    sevePayAddEndDt.setValue((Date) bmData.get("sevePayAddEndDt"));

                    /** column 사용여부 : sevePayAddUseYn */
                    sevePayAddUseYn.setValue((Boolean) bmData.get("sevePayAddUseYn"));

                    /** column 퇴직금비고내용 : sevePayNoteCtnt */
                    sevePayNoteCtnt.setValue((String) bmData.get("sevePayNoteCtnt"));

                    dtilToggle(true);    //componentObj.setEnable(true)
                }
            }
        });
        cpGrid.add(remt1000GridPanel);


        lcStdGrid.add(cpGrid);
        fldstNewFieldset.add(lcStdGrid);

        plFrmRemt0050.add(fldstNewFieldset, new FormData("100%"));

    }

    public void reload() {
        // TODO Auto-generated method stub
        //선택된 데이터가 있는지 여부를 체크 함. 년도는 필수 선택임
//	            if ( MSFSharedUtils.paramNull(srhApptnYr.getRawValue()) ) {
//	                  MessageBox.alert("데이터 오류", "년도는 필수 선택사항입니다.", null);
//	                  srhApptnYr.focus();
//	                  return;
//	            }
//	            
//	            if ( MSFSharedUtils.paramNull(srhApptnStdBgnnDt.getRawValue()) ) {
//	                  MessageBox.alert("데이터 오류", "기준일자는 필수 선택사항입니다.", null);
//	                  srhApptnStdBgnnDt.focus();
//	                  return;
//	            }


        IColumnFilter filters = null;
        remt1000GridPanel.getTableDef().setTableColumnFilters(filters);


        remt1000GridPanel.getTableDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(srhTypOccuCd, "typOccuCd"), SimpleColumnFilter.OPERATOR_EQUALS);
        String strDtilOccuInttnCd = BasisUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(), "dtilOccuClsNm", "dtilOccuInttnCd");
        remt1000GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS);
        // remt1000GridPanel.getTableDef().addColumnFilter("pyspGrdeCd", MSFSharedUtils.defaultNulls(srhPyspGrdeCd.getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS);
        remt1000GridPanel.getTableDef().addColumnFilter("sevePayAddRateFrmCd", MSFSharedUtils.getSelectedComboValue(srhSevePayAddRateFrmCd, "commCd"), SimpleColumnFilter.OPERATOR_EQUALS);

        remt1000GridPanel.reload();
        dtilToggle(false);
    }

    public void setRecord(BaseModel record) {
        this.record = record;
    }


    /* 엑셀 업로드 */
    private void xlsImportData() {
        MessageBox.confirm("퇴직가산율관리", "퇴직가산율을 생성하시겠습니까?<br>", new Listener<MessageBoxEvent>() {
            @Override
            public void handleEvent(MessageBoxEvent be) {
                //if("Yes".equals(be.getButtonClicked().getText())){
                if (Dialog.YES.equals(be.getButtonClicked().getItemId())) {

                    String filename = MSFSharedUtils.allowNulls(remt0050flUp.getValue());
                    if (filename.length() == 0) {
                        Window.alert("선택된 파일이 없습니다.");
                        return;
                    } else {
                        //submit the form
                        plFrmRemt0050.mask("엑셀 데이타 업데이트 중입니다. 업로드 중...");
                        //파일업로드 처리
                        plFrmRemt0050.setAction(GWT.getHostPageBaseURL() + "imp/XlsReadRemt0050Import.do");
                        plFrmRemt0050.setEncoding(FormPanel.Encoding.MULTIPART);
                        plFrmRemt0050.setMethod(FormPanel.Method.POST);
                        plFrmRemt0050.submit();
                        plFrmRemt0050.onFrameLoad();
                        picBoolFile = true;

                    }
                    // reset and unmask the form
                    // after file upload
                    plFrmRemt0050.addListener(Events.Submit, new Listener<FormEvent>() {
                        public void handleEvent(FormEvent evt) {
                            if ("success".endsWith(evt.getResultHtml()) && picBoolFile) {

                                //업로드가  성공했으면 인서트 모듈을 태운다.
                                plFrmRemt0050.unmask();
//                                MessageBox.alert("", "엑셀 업로드가 정상적으로 완료되었습니다.", null);
                                picBoolFile = false;
                                evt.setResultHtml("");
                            } else {
                                if ("error".endsWith(evt.getResultHtml()) && picBoolFile) {
                                    plFrmRemt0050.unmask();
                                    MessageBox.alert("", "엑셀 업로드가 비정상적으로 종료되었습니다.", null);
                                    picBoolFile = false;
                                    evt.setResultHtml("");
                                } else {
                                    //실패 메시지나 에러 메시지 처리 .
                                    evt.setResultHtml("");
                                }
                            }
                        }

                        ;
                    });

                }
            }
        });
    }

    /* 엑셀 다운로드 */
    private void xlsExportData() {

        HashMap<String, String> param = new HashMap<String, String>();

        param.put("dpobCd", MSFSharedUtils.allowNulls(dpobCd.getValue()));    //사업장코드
        param.put("typOccuCd", BasisUtil.getSelectedComboValue(srhTypOccuCd, "typOccuCd"));    //직종코드
        param.put("dtilOccuInttnCd", BasisUtil.getStrValToBMMultiCombo(lsDtilOccuInttnCd, srhDtilOccuInttnCd.getValue(), "dtilOccuClsNm", "dtilOccuInttnCd"));  //직종세
        param.put("sevePayAddRateFrmCd", BasisUtil.getSelectedComboValue(dtSevePayAddRateFrmCd, "dtSevePayAddRateFrmCd"));    //직종세사용여부

        remt1000GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsFileRemt0050Export.do", "extgwtFrame", param);
    }

    private Bass6050 getThis() {
        return this;
    }

    private void formRemt0050Init() {

        sevePayAddRateSeilNum.reset();                 // 퇴직금가산율일련번호
        typOccuCd.setValue(new BaseModel());             // 직종코드
        dtilOccuInttnCd.setValue(new BaseModel());     // 직종세통합코드
        dtSevePayAddRateFrmCd.setValue(new BaseModel()); // 퇴직금가산율유형코드
        sevePayAddOvr.reset();                         // 퇴직금가산이상
        sevePayAddUdr.reset();                         // 퇴직금가산미만
        sevePayAddSum.reset();                         // 퇴직금가산금액
        sevePayAddRate.reset();                        // 퇴직금가산율
        sevePayAddBgnnDt.setReadOnly(false);             // 퇴직금가산시작일자
        sevePayAddBgnnDt.setValue(today);             // 퇴직금가산시작일자
        sevePayAddEndDt.setReadOnly(false);            // 퇴직금가산종료일자
        sevePayAddEndDt.setValue(today);                 // 퇴직금가산종료일자
        sevePayAddUseYn.setValue(false);               // 사용여부
        sevePayNoteCtnt.reset();                       // 퇴직금비고내용
        dtilToggle(true);    //setEnabled true
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
