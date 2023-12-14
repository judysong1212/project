/**
 * 도로명주소 팝업.
 * 자체데이타 베이스 처리 루틴 
 */
package com.app.smrmf.syscom.client.form;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnLovDef;
import com.app.smrmf.core.msfmainapp.client.def.LovDef;
import com.app.smrmf.core.msfmainapp.client.generics.Lov;
import com.app.smrmf.core.msfmainapp.client.widget.MSFComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTextField;
import com.app.smrmf.syscom.client.dto.SysComCmmn0320BM;
import com.app.smrmf.syscom.client.dto.SysComCmmn0320DTO;
import com.app.smrmf.syscom.client.form.defs.SysComCmmn0320Def;
import com.app.smrmf.syscom.client.languages.SysComConstants;
import com.app.smrmf.syscom.client.util.SysComComboUtils;
import com.app.smrmf.syscom.shared.SysComDaoConstants;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;

 
public class SysComP0120  extends Lov implements SysComDaoConstants { 

	 /**######################################################
	  * { 시스템 기본설정파일 선언부  시작}
	  *#######################################################*/
	 

     /**######################################################
 	  * { 시스템 기본설정파일 선언부  종료}
 	  *#######################################################*/

    private SysComConstants SysComLabel = SysComConstants.INSTANCE;
    
    private static MSFTextField searchWord; 
    
    private static ListStore<BaseModel>   lsRoadNmCtapv = new ListStore<BaseModel>();//시도
    private static ListStore<BaseModel>     lsRoadNmCtatgu = new ListStore<BaseModel>();//시군구
    
    
    
    private static RadioGroup rdgrpRadiogroup ;  //출력조건라디오그룹 
    
    private static MSFComboBox<BaseModel> roadNmCtapv ;    //시도
    private static MSFComboBox<BaseModel> roadNmCtatgu;    //시군구
    /** set 도로명읍면 : roadNmTat */
    private static MSFTextField roadNmTat;
    /** set 도로명리 : roadNmLi */
    private static MSFTextField roadNmLi;
    /** set 도로명지번본번 : roadNmLtnumBobn */
    private static MSFTextField roadNmLtnumBobn; 
    /** set 도로명지번부번 : roadNmLtnumBubn */
    private static MSFTextField roadNmLtnumBubn;
    
    /** set 도로명 : roadNm */
    private static MSFTextField roadNm;
 
    /** set 건물번호본번 : buildNumBobn */
    private static MSFTextField buildNumBobn;

    /** set 건물번호부본 : buildNumBubn */
    private static MSFTextField buildNumBubn;
    
    /** set 건물명 : buildNm */
    private static MSFTextField buildNm;
          
    public static Button btnUsrSearch01;
    public static Button btnUsrSearch02;
    public static Button btnUsrSearch03;
    public static Button btnUsrSearch04;
    public static String valueAttribute;
    
    
    
    public static MSFTextField getSearchWord() {
		return searchWord;
	}

	public static void setSearchWord(MSFTextField searchWord) {
		SysComP0120.searchWord = searchWord;
	}

	public static MSFComboBox<BaseModel> getRoadNmCtapv() {
		return roadNmCtapv;
	}

	public static void setRoadNmCtapv(MSFComboBox<BaseModel> roadNmCtapv) {
		SysComP0120.roadNmCtapv = roadNmCtapv;
	}

	public static MSFComboBox<BaseModel> getRoadNmCtatgu() {
		return roadNmCtatgu;
	}

	public static void setRoadNmCtatgu(MSFComboBox<BaseModel> roadNmCtatgu) {
		SysComP0120.roadNmCtatgu = roadNmCtatgu;
	}

	public static MSFTextField getRoadNmTat() {
		return roadNmTat;
	}

	public static void setRoadNmTat(MSFTextField roadNmTat) {
		SysComP0120.roadNmTat = roadNmTat;
	}

	public static MSFTextField getRoadNmLi() {
		return roadNmLi;
	}

	public static void setRoadNmLi(MSFTextField roadNmLi) {
		SysComP0120.roadNmLi = roadNmLi;
	}

	public static MSFTextField getRoadNmLtnumBobn() {
		return roadNmLtnumBobn;
	}

	public static void setRoadNmLtnumBobn(MSFTextField roadNmLtnumBobn) {
		SysComP0120.roadNmLtnumBobn = roadNmLtnumBobn;
	}

	public static MSFTextField getRoadNmLtnumBubn() {
		return roadNmLtnumBubn;
	}

	public static void setRoadNmLtnumBubn(MSFTextField roadNmLtnumBubn) {
		SysComP0120.roadNmLtnumBubn = roadNmLtnumBubn;
	}

	public static MSFTextField getRoadNm() {
		return roadNm;
	}

	public static void setRoadNm(MSFTextField roadNm) {
		SysComP0120.roadNm = roadNm;
	}

	public static MSFTextField getBuildNumBobn() {
		return buildNumBobn;
	}

	public static void setBuildNumBobn(MSFTextField buildNumBobn) {
		SysComP0120.buildNumBobn = buildNumBobn;
	}

	public static MSFTextField getBuildNumBubn() {
		return buildNumBubn;
	}

	public static void setBuildNumBubn(MSFTextField buildNumBubn) {
		SysComP0120.buildNumBubn = buildNumBubn;
	}

	public static MSFTextField getBuildNm() {
		return buildNm;
	}

	public static void setBuildNm(MSFTextField buildNm) {
		SysComP0120.buildNm = buildNm;
	}

	public SysComP0120(int width, int height) {
        this();
        this.width  = width;
        this.height = height;
    }

    public SysComP0120() {

        lovDef = new LovDef();
        lovDef.setTitle(SysComLabel.titleSysComPopUpCmmn0320());  //팝업상단의 타이틀 
        lovDef.setDaoClass(CLASS_SYSCOM_CMMN0320VO);
       
        lovDef.setAutoFillGrid(true);
        lovDef.setFilterForm(false);  
        lovDef.setCustomListMethod(MSFCOM_METHOD_POPUP_CMMN0320_List);
       
        List<ColumnLovDef> listColumnDefs = new ArrayList<ColumnLovDef>();
        
        listColumnDefs.add(new ColumnLovDef("우편번호", SysComCmmn0320BM.ATTR_ZPCD,SysComCmmn0320BM.ATTR_ZPCD,  ColumnDef.TYPE_STRING, 100 ) );
        listColumnDefs.add(new ColumnLovDef("일련번호", SysComCmmn0320BM.ATTR_ZPCDSEILNUM,SysComCmmn0320BM.ATTR_ZPCDSEILNUM, ColumnDef.TYPE_STRING, 80 ){
            {
            	  setIsVisibleInGrid(false);
            }
        });
        listColumnDefs.add(new ColumnLovDef("건물번호본번", SysComCmmn0320BM.ATTR_BUILDNUMBOBN,SysComCmmn0320BM.ATTR_BUILDNUMBOBN, ColumnDef.TYPE_STRING, 80 ){
            {
            	  setIsVisibleInGrid(false);
            }
        });
        listColumnDefs.add(new ColumnLovDef("건물번호부본", SysComCmmn0320BM.ATTR_BUILDNUMBUBN,SysComCmmn0320BM.ATTR_BUILDNUMBUBN, ColumnDef.TYPE_STRING, 80 ){
            {
            	  setIsVisibleInGrid(false);
            }
        });
        listColumnDefs.add(new ColumnLovDef("시도", SysComCmmn0320BM.ATTR_ROADNMCTAPV,SysComCmmn0320BM.ATTR_ROADNMCTAPV, ColumnDef.TYPE_STRING, 200 ){
            {
            	  setIsVisibleInGrid(false);
            }
        }); 
        
       
        /** CTATGU */
        listColumnDefs.add(new ColumnLovDef("시군구", SysComCmmn0320BM.ATTR_ROADNMCTATGU, SysComCmmn0320BM.ATTR_ROADNMCTATGU, ColumnDef.TYPE_STRING, 200 ){
            {
            	  setIsVisibleInGrid(false);
            }
        });
        
        /** TAT */
        listColumnDefs.add(new ColumnLovDef("읍면", SysComCmmn0320BM.ATTR_ROADNMTAT,SysComCmmn0320BM.ATTR_ROADNMTAT, ColumnDef.TYPE_STRING, 200 ){
            {
            	setIsVisibleInGrid(false);
            }
        });
       
        /** ROAD_NM_CD */
        listColumnDefs.add(new ColumnLovDef("도로명코드", SysComCmmn0320BM.ATTR_ROADNMCD,SysComCmmn0320BM.ATTR_ROADNMCD, ColumnDef.TYPE_STRING, 200 ){
            {
            	setIsVisibleInGrid(false);
            }
        });
        /** ROAD_NM */
        listColumnDefs.add(new ColumnLovDef("도로명", SysComCmmn0320BM.ATTR_ROADNM,SysComCmmn0320BM.ATTR_ROADNM,  ColumnDef.TYPE_STRING, 200 ){
            {
            	setIsVisibleInGrid(false);
            }
        });
       
        /** UNGR_YN */
        listColumnDefs.add(new ColumnLovDef("지하여부", SysComCmmn0320BM.ATTR_ROADNMUNGR,SysComCmmn0320BM.ATTR_ROADNMUNGR, ColumnDef.TYPE_STRING, 200 ){
            {
            	setIsVisibleInGrid(false);
            }
        });
        /** LOT_DSTTN_NM */
        listColumnDefs.add(new ColumnLovDef("다량배달처명", SysComCmmn0320BM.ATTR_LOTDSTTNNM,SysComCmmn0320BM.ATTR_LOTDSTTNNM, ColumnDef.TYPE_STRING, 200 ){
            {
            	setIsVisibleInGrid(false);
            }
        });
        /** CUTDOG_CD */
        listColumnDefs.add(new ColumnLovDef("법정동코드", SysComCmmn0320BM.ATTR_CUTDOGCD,SysComCmmn0320BM.ATTR_CUTDOGCD, ColumnDef.TYPE_STRING, 200){
            {
            	setIsVisibleInGrid(false);
            }
        });
        /** CUTDOG_NM */
        listColumnDefs.add(new ColumnLovDef("법정동명", SysComCmmn0320BM.ATTR_ADSTTDONGNM,SysComCmmn0320BM.ATTR_ADSTTDONGNM, ColumnDef.TYPE_STRING, 200 ){
            {
            	setIsVisibleInGrid(false);
            }
        });
        listColumnDefs.add(new ColumnLovDef("건물관리번호", SysComCmmn0320BM.ATTR_BUILDMANGENUM, SysComCmmn0320BM.ATTR_BUILDMANGENUM,ColumnDef.TYPE_STRING, 200 ){
            {
            	setIsVisibleInGrid(false);
            }
        });
        
        /** column 기초구역번호 : baseArNum */
        listColumnDefs.add(new ColumnLovDef("기초구역번호", SysComCmmn0320BM.ATTR_BASEARNUM, SysComCmmn0320BM.ATTR_BASEARNUM,ColumnDef.TYPE_STRING , 90 ){
        	{
        		setIsVisibleInGrid(false);
        	}
        });
        /** column 상세주소여부 : dtlAddrYn */
        listColumnDefs.add(new ColumnLovDef("상세주소여부", SysComCmmn0320BM.ATTR_DTLADDRYN,SysComCmmn0320BM.ATTR_DTLADDRYN, ColumnDef.TYPE_STRING , 90 ){
        	{
        		setIsVisibleInGrid(false);
        	}
        });
        /** column 비고1 : postCtnt01 */
        listColumnDefs.add(new ColumnLovDef("비고1", SysComCmmn0320BM.ATTR_POSTCTNT01,SysComCmmn0320BM.ATTR_POSTCTNT01, ColumnDef.TYPE_STRING , 90 ){
        	{
        		setIsVisibleInGrid(false);
        	}
        });
        /** column 비고2 : postCtnt02 */
        listColumnDefs.add(new ColumnLovDef("비고2", SysComCmmn0320BM.ATTR_POSTCTNT02, SysComCmmn0320BM.ATTR_POSTCTNT02, ColumnDef.TYPE_STRING , 90 ){
        	{
        		setIsVisibleInGrid(false);
        	}
        });
        
        /** 도로명주소  fnDtnAddrView*/
        listColumnDefs.add(new ColumnLovDef("도로명주소", SysComCmmn0320BM.ATTR_FNDTNADDRVIEW,SysComCmmn0320BM.ATTR_FNDTNADDR, ColumnDef.TYPE_STRING, 300 ){
            {
                
            }
        });
        
        /** 도로명주소  fnDtnAddr*/
        listColumnDefs.add(new ColumnLovDef("도로명주소", SysComCmmn0320BM.ATTR_FNDTNADDR,SysComCmmn0320BM.ATTR_FNDTNADDR, ColumnDef.TYPE_STRING, 300 ){
            {
            	setIsVisibleInGrid(false);
            }
        });
        
        /** 상세주소 dtlPatrAddr */
        listColumnDefs.add(new ColumnLovDef("참고항목", SysComCmmn0320BM.ATTR_DTLPATRADDR,SysComCmmn0320BM.ATTR_DTLPATRADDR,  ColumnDef.TYPE_STRING, 200 ){
            {
            	setIsVisibleInGrid(false);
            }
        }); 
        
        lovDef.setListColumns(listColumnDefs); 

        lovDef.addHiddenColumn(new SysComCmmn0320Def().getColumnsDefinition()); 
        lovDef.setCustomLayoutContainer(getMsfComP0120Filter()); 
        
//        private MSFTextField zpcdNum   /** column null : zpcdNum */
//
//        private MSFTextField zpcd   /** column 우편번호 : zpcd */
//
//        private MSFTextField zpcdSeilNum   /** column 우편번호일련번호 : zpcdSeilNum */
//
//        private MSFTextField buildMangeNum   /** column 건물관리번호 : buildMangeNum */
//
//        private MSFTextField cutdogCd   /** column 법정동코드 : cutdogCd */
//
//        private MSFTextField roadNmCtapv   /** column 도로명시도 : roadNmCtapv */
//
//        private MSFTextField roadNmCtatgu   /** column 도로명시군구 : roadNmCtatgu */
//
//        private MSFTextField roadNmTat   /** column 도로명읍면 : roadNmTat */
//
//        private MSFTextField roadNmLi   /** column 도로명리 : roadNmLi */
//
//        private MSFTextField roadNmSan   /** column 도로명산구분 : roadNmSan */
//
//        private MSFTextField roadNmLtnumBobn   /** column 도로명지번본번 : roadNmLtnumBobn */
//
//        private MSFTextField roadNmLtnumBubn   /** column 도로명지번부번 : roadNmLtnumBubn */
//
//        private MSFTextField roadNmCd   /** column 도로명코드 : roadNmCd */
//
//        private MSFTextField roadNm   /** column 도로명 : roadNm */
//
//        private MSFTextField roadNmUngr   /** column 도로명지하구분 : roadNmUngr */
//
//        private MSFTextField buildNumBobn   /** column 건물번호본번 : buildNumBobn */
//
//        private MSFTextField buildNumBubn   /** column 건물번호부본 : buildNumBubn */
//
//        private MSFTextField buildNm   /** column 건물명 : buildNm */
//
//        private MSFTextField dtlPatrBuildNm   /** column 상세건물명 : dtlPatrBuildNm */
//
//        private MSFTextField tatdSeilNum   /** column 읍면동일련번호 : tatdSeilNum */
//
//        private MSFTextField adsttDongCd   /** column 행정동코드 : adsttDongCd */
//
//        private MSFTextField adsttDongNm   /** column 행정동명 : adsttDongNm */
//
//        private MSFTextField lotDsttnNm   /** column 다량배달처명 : lotDsttnNm */
//
//        private MSFTextField mvReasCd   /** column 이동사유코드 : mvReasCd */
//
//        private MSFTextField chngDt   /** column 변경일자 : chngDt */
//
//        private MSFTextField chngBfrRoadNmAddr   /** column 변경전도로명주소 : chngBfrRoadNmAddr */
//
//        private MSFTextField ctatguBuildNm   /** column 시군구용건물명 : ctatguBuildNm */
//
//        private MSFTextField jonHus   /** column 공동주택구분 : jonHus */
 
       
    } 


    public static final LayoutContainer getMsfComP0120Filter() {
         
        final SysComCmmn0320DTO sysComCmmn0320Dto; // dto 
           
        sysComCmmn0320Dto = new SysComCmmn0320DTO(); 
       //--------------------시도 불러 오는 함수 --------------------------------------------------
        //시도
        lsRoadNmCtapv = SysComComboUtils.getSysComComboRoadNmCtapv( sysComCmmn0320Dto);
        //--------------------시도 불러 오는 함수 --------------------------------------------------
        
        
            ContentPanel cp03 = new ContentPanel();   
            cp03.setBodyBorder(false); 
            cp03.setHeaderVisible(false);   
            cp03.setLayout(new FlowLayout(2));      
            //cp03.setSize(830, 200);  
            cp03.setSize(830, 130);  
             
            /************************** 전체검색 시작 **************************************/
            
            LayoutContainer layoutContainer_b_1 = new LayoutContainer();
            layoutContainer_b_1.setLayout(new ColumnLayout());
            layoutContainer_b_1.setStyleAttribute("paddingTop", "10px");
            
            // 검색어   
            final LayoutContainer layoutContainer_b_3 = new LayoutContainer();
            FormLayout frmlytStd = new FormLayout();  
            frmlytStd.setLabelWidth(70); 
            frmlytStd.setLabelAlign(LabelAlign.RIGHT);
            layoutContainer_b_3.setLayout(frmlytStd);
           
            searchWord = new MSFTextField(); 
            searchWord.setFieldLabel("검색어"); 
            searchWord.setEmptyText("서울시 종로구 세종로 175 또는 세종문화회관");
            layoutContainer_b_3.add(searchWord, new FormData("100%")); 
             
            layoutContainer_b_3.setBorders(false);  
            

             
           
            final LayoutContainer layoutContainer_a_1 = new LayoutContainer(); 
            FormLayout frmlytSch = new FormLayout();  
            frmlytSch.setLabelWidth(70); 
            frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
            layoutContainer_a_1.setLayout(frmlytSch);
           
            btnUsrSearch04 = new Button("검색");
            btnUsrSearch04.setIcon(MSFMainApp.ICONS.search());
            layoutContainer_a_1.add(btnUsrSearch04 ); 
          
            layoutContainer_a_1.setBorders(false);  
           
           
            layoutContainer_b_1.add(layoutContainer_b_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.9)); 
            layoutContainer_b_1.add(layoutContainer_a_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.1));
            
            
          final LayoutContainer layoutContainer_a_3 = new LayoutContainer();
          
          frmlytSch = new FormLayout();  
          frmlytSch.setLabelWidth(20); 
          frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
          layoutContainer_a_3.setLayout(frmlytSch);
           
          LabelField hidfLabel = new LabelField("도로명,건물명,지번에 대한 통합검색이 가능 (예: 반포대로 58, 국립중앙박물관, 삼성동 25");  
          hidfLabel.setStyleAttribute("padding-top", "5px");
          hidfLabel.setStyleAttribute("padding-top", "10px");
          layoutContainer_a_3.add(hidfLabel, new FormData("100%"));  
          
          layoutContainer_a_3.setBorders(false);
           
          layoutContainer_b_1.add(layoutContainer_a_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
          
        //   cp03.add(layoutContainer_b_1);
          
           /************************** 전체검색 종료**************************************/  
            
             FieldSet fieldSet = new FieldSet();  
	        // fieldSet.setHeading("상세검색");
	         fieldSet.setHeadingHtml("상세검색");
	         fieldSet.setExpanded(true);
             LayoutContainer frmSearchLayer = new LayoutContainer();
             FormLayout layout = new FormLayout();
             layout.setDefaultWidth(850);
             layout.setLabelWidth(100);   
             frmSearchLayer.setLayout(layout);  
            
             
             //검색조건 
             rdgrpRadiogroup = new RadioGroup();
             
             LayoutContainer  lycSreach = new LayoutContainer(); 
              frmlytStd = new FormLayout();  
             frmlytStd.setLabelWidth(0);  
             lycSreach.setLayout(frmlytStd);
            // lycSreach.setHeight(30); 

             LayoutContainer layoutContainer = new LayoutContainer();
             
             Radio  rdRadio01 = new Radio(); 
             rdRadio01.setValueAttribute("01");
             rdgrpRadiogroup.add(rdRadio01);
             rdRadio01.setBoxLabel("동(읍/면)+리+지번");
             rdRadio01.setHideLabel(true); 
             
             Radio rdRadio02 = new Radio();
             rdRadio02.setValueAttribute("02");
             rdgrpRadiogroup.add(rdRadio02);
             rdRadio02.setBoxLabel("도로명주소+건물번호");
             rdRadio02.setHideLabel(true);
             rdRadio02.setValue(true);
             
             Radio rdRadio03 = new Radio();
             rdRadio03.setValueAttribute("03");
             rdgrpRadiogroup.add(rdRadio03);
             rdRadio03.setBoxLabel("건물명(아파트명)");
             rdRadio03.setHideLabel(true);
              
             layoutContainer.add(rdgrpRadiogroup);
             rdgrpRadiogroup.setFieldLabel("도로명주소"); 
             layoutContainer.setLayout(new FlowLayout(5));
             layoutContainer.setBorders(true); 
             
             lycSreach.add(layoutContainer);
             
 //            검색방법 : 시/도 및 시/군/구 선택 후 동(읍/면) + 지번 입력
//             예) 역삼동 737 → 서울특별시 선택 후 역삼동 (동명) + 737 (지번)
//
//             * 도로명 주소가 검색되지 않는 경우는 행정안전부 새주소안내시스템
//             (http://www.juso.go.kr) 에서 확인하시기 바랍니다.
//
//             검색방법 : 시/도 및 시/군/구 선택 후 도로명과 건물번호 입력
//             예) 테헤란로(도로명) + 152 (건물번호)
//
//             * 도로명 주소가 검색되지 않는 경우는 행정안전부 새주소안내시스템
//             (http://www.juso.go.kr) 에서 확인하시기 바랍니다.
//
//             검색방법 : 시/도 및 시/군/구 선택 후 건물명 입력
//             예) 강남파이낸스센터 (건물명)
//
//             * 도로명 주소가 검색되지 않는 경우는 행정안전부 새주소안내시스템
//             (http://www.juso.go.kr) 에서 확인하시기 바랍니다.
 
             LayoutContainer layoutContainer_12 = new LayoutContainer();
             layoutContainer_12.setLayout(new ColumnLayout());
             layoutContainer_12.setStyleAttribute("paddingTop", "5px");
            
             LayoutContainer layoutContainer_13 = new LayoutContainer();
             frmlytStd = new FormLayout();  
             frmlytStd.setLabelWidth(70); 
             frmlytStd.setLabelAlign(LabelAlign.RIGHT);
             layoutContainer_13.setLayout(frmlytStd);
            
             roadNmCtapv = new MSFComboBox<BaseModel>();
             roadNmCtapv.setForceSelection(true);
             roadNmCtapv.setMinChars(1);
             roadNmCtapv.setDisplayField("roadNmCtapvDisp");
             roadNmCtapv.setValueField("roadNmCtapv");
             roadNmCtapv.setTriggerAction(TriggerAction.ALL);
             roadNmCtapv.setEmptyText("--시도선택--");
             roadNmCtapv.setSelectOnFocus(true); 
             roadNmCtapv.setReadOnly(false);
             roadNmCtapv.setEnabled(true); 
             roadNmCtapv.setStore(lsRoadNmCtapv );
             roadNmCtapv.setFieldLabel("시도");
             roadNmCtapv.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
                 public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
                  
                   roadNmCtatgu.reset();
                     //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
                  BaseModel bmRoadNmCtapv =  se.getSelectedItem(); 
                  if (bmRoadNmCtapv != null) {
                      sysComCmmn0320Dto.setRoadNmCtapv((String)bmRoadNmCtapv.get("roadNmCtapv")); 
                   }      
                  //시군구
                  //--------------------시군구 불러 오는 함수 ------------------------------------------------
                   lsRoadNmCtatgu = SysComComboUtils.getSysComComboRoadNmCtatgu(sysComCmmn0320Dto);
                   //--------------------시군구 불러 오는 함수 ------------------------------------------------
                    roadNmCtatgu.setStore(lsRoadNmCtatgu);  
                 } 
             });
             
             layoutContainer_13.add(roadNmCtapv, new FormData("100%")); 
             layoutContainer_13.setBorders(false); 
             layoutContainer_12.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
             
             
             LayoutContainer layoutContainer_2 = new LayoutContainer();
             layoutContainer_12.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
             frmlytSch = new FormLayout();  
             frmlytSch.setLabelWidth(70); 
             frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
             layoutContainer_2.setLayout(frmlytSch);
             
             roadNmCtatgu =  new MSFComboBox<BaseModel>(); 
             roadNmCtatgu.setForceSelection(true);
             roadNmCtatgu.setMinChars(1);
             roadNmCtatgu.setDisplayField("roadNmCtatguDisp");
             roadNmCtatgu.setValueField("roadNmCtatgu");
             roadNmCtatgu.setTriggerAction(TriggerAction.ALL);
             roadNmCtatgu.setEmptyText("--시군구선택--");
             roadNmCtatgu.setSelectOnFocus(true); 
             roadNmCtatgu.setReadOnly(false);
             roadNmCtatgu.setEnabled(true); 
             roadNmCtatgu.setStore(lsRoadNmCtatgu);
             roadNmCtatgu.setFieldLabel("시군구"); 
            
             layoutContainer_2.add(roadNmCtatgu, new FormData("100%")); 
             layoutContainer_2.setBorders(false);
             
             LayoutContainer layoutContainer_1 = new LayoutContainer();
             layoutContainer_12.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
             frmlytSch = new FormLayout();  
             frmlytSch.setLabelWidth(70); 
             frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
             layoutContainer_1.setLayout(frmlytSch);
              
             layoutContainer_1.setBorders(false);   
             lycSreach.add(layoutContainer_12);
             
          
             LayoutContainer layoutContainer_12_1 = new LayoutContainer();
             layoutContainer_12_1.setLayout(new ColumnLayout());
             layoutContainer_12_1.setStyleAttribute("paddingTop", "5px");
            
             // 검색어  동(읍/면) + 리 + 지번 
             final LayoutContainer layoutContainer_13_1 = new LayoutContainer();
             frmlytStd = new FormLayout();  
             frmlytStd.setLabelWidth(70); 
             frmlytStd.setLabelAlign(LabelAlign.RIGHT);
             layoutContainer_13_1.setLayout(frmlytStd);
            
             roadNmTat = new MSFTextField(); 
             roadNmTat.setFieldLabel("검색어");  
             layoutContainer_13_1.add(roadNmTat, new FormData("100%")); 
        
             layoutContainer_13_1.setBorders(false);  
             
             final LayoutContainer layoutContainer_2_1_1 = new LayoutContainer();
             
             frmlytSch = new FormLayout();  
             frmlytSch.setLabelWidth(20); 
             frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
             layoutContainer_2_1_1.setLayout(frmlytSch);
              
             roadNmLi = new MSFTextField(); 
             roadNmLi.setFieldLabel(" + "); 
             roadNmLi.setLabelSeparator("");
             layoutContainer_2_1_1.add(roadNmLi, new FormData("100%"));
             
             layoutContainer_2_1_1.setBorders(false);
              
             final LayoutContainer layoutContainer_2_1 = new LayoutContainer();
             
             frmlytSch = new FormLayout();  
             frmlytSch.setLabelWidth(20); 
             frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
             layoutContainer_2_1.setLayout(frmlytSch);
              
             roadNmLtnumBobn = new MSFTextField(); 
             roadNmLtnumBobn.setFieldLabel(" + "); 
             roadNmLtnumBobn.setLabelSeparator("");
             layoutContainer_2_1.add(roadNmLtnumBobn, new FormData("100%"));
             
              layoutContainer_2_1.setBorders(false);
              
              // 검색어   도로명 + 건물번호 
             final LayoutContainer layoutContainer_13_2 = new LayoutContainer();
             frmlytStd = new FormLayout();  
             frmlytStd.setLabelWidth(70); 
             frmlytStd.setLabelAlign(LabelAlign.RIGHT);
             layoutContainer_13_2.setLayout(frmlytStd);
            
             roadNm = new MSFTextField(); 
             roadNm.setFieldLabel("검색어"); 
             layoutContainer_13_2.add(roadNm, new FormData("100%"));  
             layoutContainer_13_2.setBorders(false);  
             
             final LayoutContainer layoutContainer_2_2 = new LayoutContainer();
             
             frmlytSch = new FormLayout();  
             frmlytSch.setLabelWidth(20); 
             frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
             layoutContainer_2_2.setLayout(frmlytSch);
              
              buildNumBobn = new MSFTextField(); 
              buildNumBobn.setFieldLabel(" + "); 
              buildNumBobn.setLabelSeparator("");
              layoutContainer_2_2.add(buildNumBobn, new FormData("100%"));  
             
              layoutContainer_2_2.setBorders(false);
              
              
              // 검색어   건물명(아파트명)
              final LayoutContainer layoutContainer_13_3 = new LayoutContainer();
              frmlytStd = new FormLayout();  
              frmlytStd.setLabelWidth(70); 
              frmlytStd.setLabelAlign(LabelAlign.RIGHT);
              layoutContainer_13_3.setLayout(frmlytStd);
             
              buildNm = new MSFTextField(); 
              buildNm.setFieldLabel("검색어"); 
              layoutContainer_13_3.add(buildNm, new FormData("100%")); 
               
              layoutContainer_13_3.setBorders(false);  
              
              final LayoutContainer layoutContainer_2_3 = new LayoutContainer();
              
              frmlytSch = new FormLayout();  
              frmlytSch.setLabelWidth(20); 
              frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
              layoutContainer_2_3.setLayout(frmlytSch);
               
              HiddenField<String> hidText = new HiddenField<String>(); 
              hidText.setFieldLabel(""); 
              layoutContainer_2_3.add(hidText, new FormData("100%"));  
              
              layoutContainer_2_3.setBorders(false);
               
             
              final LayoutContainer layoutContainer_1_1 = new LayoutContainer(); 
             frmlytSch = new FormLayout();  
             frmlytSch.setLabelWidth(70); 
             frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
             layoutContainer_1_1.setLayout(frmlytSch);
             
             btnUsrSearch01 = new Button("검색");
             btnUsrSearch01.setIcon(MSFMainApp.ICONS.search());
             layoutContainer_1_1.add(btnUsrSearch01 ); 
            
             layoutContainer_1_1.setBorders(false);  
             
             final LayoutContainer layoutContainer_1_2 = new LayoutContainer(); 
             frmlytSch = new FormLayout();  
             frmlytSch.setLabelWidth(70); 
             frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
             layoutContainer_1_2.setLayout(frmlytSch);
             
             btnUsrSearch02 = new Button("검색");
             btnUsrSearch02.setIcon(MSFMainApp.ICONS.search());
             layoutContainer_1_2.add(btnUsrSearch02 ); 
            
             layoutContainer_1_2.setBorders(false);  
             
             final LayoutContainer layoutContainer_1_3 = new LayoutContainer(); 
             frmlytSch = new FormLayout();  
             frmlytSch.setLabelWidth(70); 
             frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
             layoutContainer_1_3.setLayout(frmlytSch);
             
             btnUsrSearch03 = new Button("검색");
             btnUsrSearch03.setIcon(MSFMainApp.ICONS.search());
             layoutContainer_1_3.add(btnUsrSearch03 ); 
            
             layoutContainer_1_3.setBorders(false);  
             
          
             layoutContainer_13_1.setVisible(false);
             layoutContainer_2_1_1.setVisible(false);
             layoutContainer_2_1.setVisible(false); 
             layoutContainer_1_1.setVisible(false);
             layoutContainer_12_1.add(layoutContainer_13_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 
             layoutContainer_12_1.add(layoutContainer_2_1_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25)); 
             layoutContainer_12_1.add(layoutContainer_2_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25)); 
             layoutContainer_12_1.add(layoutContainer_1_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
             
             layoutContainer_12_1.add(layoutContainer_13_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
             layoutContainer_12_1.add(layoutContainer_2_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3)); 
             layoutContainer_12_1.add(layoutContainer_1_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
             
             layoutContainer_13_3.setVisible(false);
             layoutContainer_2_3.setVisible(false);
             layoutContainer_1_3.setVisible(false);
             layoutContainer_12_1.add(layoutContainer_13_3, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
             layoutContainer_12_1.add(layoutContainer_2_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
             layoutContainer_12_1.add(layoutContainer_1_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
             
             rdgrpRadiogroup.addListener(Events.Change, new Listener<BaseEvent>() {
                 @Override
                 public void handleEvent(BaseEvent be) 
                 {
                   final RadioGroup radioGroup = (RadioGroup)be.getSource();

                   final Radio clickedRadioBtn = radioGroup.getValue();

                   valueAttribute = clickedRadioBtn.getValueAttribute();  
                  
                   if ("01".equals(valueAttribute)) { 
                       
                       layoutContainer_13_1.setVisible(true);
                       layoutContainer_2_1_1.setVisible(true);
                       layoutContainer_2_1.setVisible(true);
                       layoutContainer_1_1.setVisible(true);
                       layoutContainer_13_2.setVisible(false);
                       layoutContainer_2_2.setVisible(false);
                       layoutContainer_1_2.setVisible(false);
                       layoutContainer_13_3.setVisible(false);
                       layoutContainer_2_3.setVisible(false);
                       layoutContainer_1_3.setVisible(false);
                       
                   } else if ("02".equals(valueAttribute)) {
                       
                       layoutContainer_13_1.setVisible(false);
                       layoutContainer_2_1_1.setVisible(false);
                       layoutContainer_2_1.setVisible(false);
                       layoutContainer_1_1.setVisible(false);
                       layoutContainer_13_2.setVisible(true);
                       layoutContainer_2_2.setVisible(true);
                       layoutContainer_1_2.setVisible(true);
                       layoutContainer_13_3.setVisible(false);
                       layoutContainer_2_3.setVisible(false);
                       layoutContainer_1_3.setVisible(false);
                       
                   }  else if ("03".equals(valueAttribute)) {
                       
                       layoutContainer_13_1.setVisible(false);
                       layoutContainer_2_1_1.setVisible(false);
                       layoutContainer_2_1.setVisible(false);
                       layoutContainer_1_1.setVisible(false);
                       layoutContainer_13_2.setVisible(false);
                       layoutContainer_2_2.setVisible(false);
                       layoutContainer_1_2.setVisible(false);
                       layoutContainer_13_3.setVisible(true);
                       layoutContainer_2_3.setVisible(true);
                       layoutContainer_1_3.setVisible(true);
                       
                   } else {
                       
                       layoutContainer_13_1.setVisible(false);
                       layoutContainer_2_1_1.setVisible(false);
                       layoutContainer_2_1.setVisible(false);
                       layoutContainer_1_1.setVisible(false);
                       layoutContainer_13_2.setVisible(true);
                       layoutContainer_2_2.setVisible(true);
                       layoutContainer_1_2.setVisible(true);
                       layoutContainer_13_3.setVisible(false);
                       layoutContainer_2_3.setVisible(false);
                       layoutContainer_1_3.setVisible(false);
                      
                   }
                 }
               }); 

            lycSreach.add(layoutContainer_12_1);
             
            fieldSet.add(lycSreach);
            
            cp03.add(fieldSet);
            
            final LayoutContainer layoutContainer_s_3 = new LayoutContainer();
            
            frmlytSch = new FormLayout();  
            frmlytSch.setLabelWidth(20); 
            frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
            layoutContainer_s_3.setLayout(frmlytSch);
             
            LabelField bottomLabel = new LabelField("도로명,건물명,지번에 대한 통합검색이 가능 (예: 반포대로 58, 국립중앙박물관, 삼성동 25");  
            bottomLabel.setStyleAttribute("padding-top", "5px");
            bottomLabel.setStyleAttribute("padding-top", "5px");
            layoutContainer_s_3.add(bottomLabel, new FormData("100%"));  
            
            layoutContainer_s_3.setBorders(false);
            cp03.add(layoutContainer_s_3);
             
            frmSearchLayer.add(cp03);
          
            return frmSearchLayer ;
      }
}
