/**
 * 도로명주소 팝업.
 * 연계팝업 처리를 위한 루틴 
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
import com.app.smrmf.syscom.client.form.defs.SysComCmmn0600Def;
import com.app.smrmf.syscom.client.languages.SysComConstants;
import com.app.smrmf.syscom.shared.SysComDaoConstants;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;

 
public class SysComPostDoro  extends Lov implements SysComDaoConstants { 

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
		SysComPostDoro.searchWord = searchWord;
	}

	public static MSFComboBox<BaseModel> getRoadNmCtapv() {
		return roadNmCtapv;
	}

	public static void setRoadNmCtapv(MSFComboBox<BaseModel> roadNmCtapv) {
		SysComPostDoro.roadNmCtapv = roadNmCtapv;
	}

	public static MSFComboBox<BaseModel> getRoadNmCtatgu() {
		return roadNmCtatgu;
	}

	public static void setRoadNmCtatgu(MSFComboBox<BaseModel> roadNmCtatgu) {
		SysComPostDoro.roadNmCtatgu = roadNmCtatgu;
	}

	public static MSFTextField getRoadNmTat() {
		return roadNmTat;
	}

	public static void setRoadNmTat(MSFTextField roadNmTat) {
		SysComPostDoro.roadNmTat = roadNmTat;
	}

	public static MSFTextField getRoadNmLi() {
		return roadNmLi;
	}

	public static void setRoadNmLi(MSFTextField roadNmLi) {
		SysComPostDoro.roadNmLi = roadNmLi;
	}

	public static MSFTextField getRoadNmLtnumBobn() {
		return roadNmLtnumBobn;
	}

	public static void setRoadNmLtnumBobn(MSFTextField roadNmLtnumBobn) {
		SysComPostDoro.roadNmLtnumBobn = roadNmLtnumBobn;
	}

	public static MSFTextField getRoadNmLtnumBubn() {
		return roadNmLtnumBubn;
	}

	public static void setRoadNmLtnumBubn(MSFTextField roadNmLtnumBubn) {
		SysComPostDoro.roadNmLtnumBubn = roadNmLtnumBubn;
	}

	public static MSFTextField getRoadNm() {
		return roadNm;
	}

	public static void setRoadNm(MSFTextField roadNm) {
		SysComPostDoro.roadNm = roadNm;
	}

	public static MSFTextField getBuildNumBobn() {
		return buildNumBobn;
	}

	public static void setBuildNumBobn(MSFTextField buildNumBobn) {
		SysComPostDoro.buildNumBobn = buildNumBobn;
	}

	public static MSFTextField getBuildNumBubn() {
		return buildNumBubn;
	}

	public static void setBuildNumBubn(MSFTextField buildNumBubn) {
		SysComPostDoro.buildNumBubn = buildNumBubn;
	}

	public static MSFTextField getBuildNm() {
		return buildNm;
	}

	public static void setBuildNm(MSFTextField buildNm) {
		SysComPostDoro.buildNm = buildNm;
	}

	public SysComPostDoro(int width, int height) {
        this();
        this.width  = width;
        this.height = height;
    }

    public SysComPostDoro() {

        lovDef = new LovDef();
        lovDef.setTitle(SysComLabel.titleSysComPopUpCmmn0320());  //팝업상단의 타이틀 
        lovDef.setDaoClass(CLASS_SYSCOM_ADDRLINK_DORO);
       
        lovDef.setAutoFillGrid(true);
        lovDef.setFilterForm(false);  
        lovDef.setCustomListMethod(CLASS_SYSCOM_ADDRLINK_DORO);
       
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

        lovDef.addHiddenColumn(new SysComCmmn0600Def().getColumnsDefinition()); 
        lovDef.setCustomLayoutContainer(getMsfComPDoroFilter()); 
         
       
    } 


    public static final LayoutContainer getMsfComPDoroFilter() {
     
    
         LayoutContainer frmSearchLayer = new LayoutContainer();
         FormLayout layout = new FormLayout();
         layout.setDefaultWidth(850);
         layout.setLabelWidth(100);   
         frmSearchLayer.setLayout(layout);  
         
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
          
           cp03.add(layoutContainer_b_1);
          
           /************************** 전체검색 종료**************************************/  
            
             
             frmSearchLayer.add(cp03);
          
            return frmSearchLayer ;
      }
}
