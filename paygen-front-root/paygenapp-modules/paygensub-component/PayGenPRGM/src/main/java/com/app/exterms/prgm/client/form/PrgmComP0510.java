/**
 * 직종/직종세 팝업 
 */
package com.app.exterms.prgm.client.form;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350BM;
import com.app.exterms.prgm.client.form.defs.PrgmComBass0350Def;
import com.app.exterms.prgm.client.languages.PrgmConstants;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.shared.PrgmComDaoConstants;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.def.ColumnLovDef;
import com.app.smrmf.core.msfmainapp.client.def.LovDef;
import com.app.smrmf.core.msfmainapp.client.generics.Lov;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;

 
public class PrgmComP0510  extends Lov implements PrgmComDaoConstants { 

	 /**######################################################
		 * { 시스템 기본설정파일 선언부  시작}
		 *#######################################################*/
	 

	     /**######################################################
	 	 * { 시스템 기본설정파일 선언부  종료}
	 	 *#######################################################*/

	  private PrgmConstants SysComLabel = PrgmConstants.INSTANCE;
	  
	  private static ListStore<BaseModel>   lsTypOccuCd = new ListStore<BaseModel>();//직종
	  private static ListStore<BaseModel>   lsPyspGrdeCd = new ListStore<BaseModel>();//호봉등급
      
	  private static ComboBox<BaseModel> typOccuCd ;    //직종
	  private static ComboBox<BaseModel> pyspGrdeCd ;    //호봉등급
	  private static TextField<String> dtilOccuClsNm;       //직종세
      public static Button btnUsrSearch;
	   
      
      
   public static ComboBox<BaseModel> getTypOccuCd() {
		return typOccuCd;
	}

	public static void setTypOccuCd(ComboBox<BaseModel> typOccuCd) {
		PrgmComP0510.typOccuCd = typOccuCd;
	}

	public static ComboBox<BaseModel> getPyspGrdeCd() {
		return pyspGrdeCd;
	}

	public static void setPyspGrdeCd(ComboBox<BaseModel> pyspGrdeCd) {
		PrgmComP0510.pyspGrdeCd = pyspGrdeCd;
	}

	public static TextField<String> getDtilOccuClsNm() {
		return dtilOccuClsNm;
	}

	public static void setDtilOccuClsNm(TextField<String> dtilOccuClsNm) {
		PrgmComP0510.dtilOccuClsNm = dtilOccuClsNm;
	}

		public PrgmComP0510(int width, int height) {
	        this();
	        this.width  = width;
	        this.height = height;
	    }

	    public PrgmComP0510() {

	        lovDef = new LovDef();
	        lovDef.setTitle("직종/직종세검색");  //팝업상단의 타이틀 
	        lovDef.setDaoClass("");
	        lovDef.setAutoFillGrid(true);
	        lovDef.setFilterForm(false);  
	        lovDef.setCustomListMethod(PRGMCOM_METHOD_POPUP_BASS0350_List);
	        lovDef.setCheckBoxOnGridRows(true);
	        
	        List<ColumnLovDef> listColumnLovDefs = new ArrayList<ColumnLovDef>();
	        
	     

	        /** column 사업장코드 : dpobCd */
	        listColumnLovDefs.add(new ColumnLovDef("사업장코드", PrgmComBass0350BM.ATTR_DPOBCD, PrgmComBass0350BM.ATTR_DPOBCD, ColumnLovDef.TYPE_STRING , 90){
	            {
	                setIsVisibleInGrid(false);
	            }
	        });
	        /** column 직종코드 : typOccuCd */
	        listColumnLovDefs.add(new ColumnLovDef("직종코드", PrgmComBass0350BM.ATTR_TYPOCCUCD, PrgmComBass0350BM.ATTR_TYPOCCUCD, ColumnLovDef.TYPE_STRING , 90){
	            {
	                setIsVisibleInGrid(false);
	            }
	        });
	        
	        /** column 직종 : typOccuNm */
	        listColumnLovDefs.add(new ColumnLovDef("직종", PrgmComBass0350BM.ATTR_TYPOCCUNM,PrgmComBass0350BM.ATTR_TYPOCCUNM, ColumnLovDef.TYPE_STRING , 100){
	            {

	            }
	        });
	        /** column 직종세통합코드 : dtilOccuInttnCd */
	        listColumnLovDefs.add(new ColumnLovDef("직종세코드", PrgmComBass0350BM.ATTR_DTILOCCUINTTNCD,PrgmComBass0350BM.ATTR_DTILOCCUINTTNCD, ColumnLovDef.TYPE_STRING , 100){
	            {
	            	
	            }
	        });
	       
	        /** column 호봉등급코드 : pyspGrdeCd */
	        listColumnLovDefs.add(new ColumnLovDef("호봉등급코드", PrgmComBass0350BM.ATTR_PYSPGRDECD,PrgmComBass0350BM.ATTR_PYSPGRDECD, ColumnLovDef.TYPE_STRING , 90 ){
	            {
	                setIsVisibleInGrid(false);
	            }
	        });
	        
	        /** column 호봉등급 : pyspGrdeNm */
	        listColumnLovDefs.add(new ColumnLovDef("등급", PrgmComBass0350BM.ATTR_PYSPGRDENM,PrgmComBass0350BM.ATTR_PYSPGRDENM, ColumnLovDef.TYPE_STRING , 100 ){
	            {

	            }
	        });
	        
	        /** column 직종세구분코드 : dtilOccuClsDivCd */
	        listColumnLovDefs.add(new ColumnLovDef("직종세구분코드", PrgmComBass0350BM.ATTR_DTILOCCUCLSDIVCD,PrgmComBass0350BM.ATTR_DTILOCCUCLSDIVCD, ColumnLovDef.TYPE_STRING , 90 ){
	            {
	                setIsVisibleInGrid(false);
	            }
	        });
	      
	        /** column 직종세명 : dtilOccuClsNm */
	        listColumnLovDefs.add(new ColumnLovDef("직종세명", PrgmComBass0350BM.ATTR_DTILOCCUCLSNM,PrgmComBass0350BM.ATTR_DTILOCCUCLSNM, ColumnLovDef.TYPE_STRING , 100){
	            {

	            }
	        });
	        /** column 직종세내용 : dtilOccuClsCtnt */
	        listColumnLovDefs.add(new ColumnLovDef("직종세내용", PrgmComBass0350BM.ATTR_DTILOCCUCLSCTNT,PrgmComBass0350BM.ATTR_DTILOCCUCLSCTNT, ColumnLovDef.TYPE_STRING , 90 ){
	            {
	                setIsVisibleInGrid(false);
	            }
	        });
	       
	        /** column 전환대상여부 : chngTgtYn */
	        listColumnLovDefs.add(new ColumnLovDef("전환대상", PrgmComBass0350BM.ATTR_CHNGTGTYN, PrgmComBass0350BM.ATTR_CHNGTGTYN, ColumnLovDef.TYPE_BOOLEAN , 50){
	            {

	            }
	        });
 
	        
	        lovDef.setListColumns(listColumnLovDefs); 

	        lovDef.addHiddenColumn(new PrgmComBass0350Def().getColumnsDefinition()); 
	        lovDef.setCustomLayoutContainer(getMsfComP0500Filter()); 
	       
	    } 
	    
	    public static final LayoutContainer getMsfComP0500Filter() {
            
            final PrgmComBass0300DTO sysComBass0300Dto; //공통코드 dto 
            final PrgmComBass0320DTO sysComBass0320Dto;
             
            sysComBass0300Dto = new PrgmComBass0300DTO(); 
            sysComBass0320Dto = new PrgmComBass0320DTO();
           //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
          //2020-12-08 직종 여부 변경
            sysComBass0320Dto.setTypOccuUseYn("Y");
            lsTypOccuCd = PrgmComComboUtils.getSingleNonBass0320ComboData(sysComBass0320Dto);
            //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
              
            //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
            //호봉등급
            sysComBass0300Dto.setRpsttvCd("A006");
            lsPyspGrdeCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
            //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
              
             
            
                ContentPanel cp03 = new ContentPanel();   
                cp03.setBodyBorder(false); 
                cp03.setHeaderVisible(false);   
                cp03.setLayout(new FlowLayout(2));      
                cp03.setSize(600, 30);  
              
                LayoutContainer frmSearchLayer = new LayoutContainer();
                 FormLayout layout = new FormLayout();
                 layout.setDefaultWidth(600);
                 layout.setLabelWidth(30);   
                 frmSearchLayer.setLayout(layout);  
                 
                 //검색조건 
                 
                 LayoutContainer  lycSreach = new LayoutContainer(); 
                 FormLayout frmlytStd = new FormLayout();  
                 frmlytStd.setLabelWidth(0);  
                 lycSreach.setLayout(frmlytStd);
                 lycSreach.setHeight(30); 
                 
                 LayoutContainer layoutContainer_12 = new LayoutContainer();
                 layoutContainer_12.setLayout(new ColumnLayout());
                 layoutContainer_12.setStyleAttribute("paddingTop", "5px");
                 
                 LayoutContainer layoutContainer_2 = new LayoutContainer();
                 layoutContainer_12.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
                 FormLayout frmlytSch = new FormLayout();  
                 frmlytSch.setLabelWidth(70); 
                 frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
                 layoutContainer_2.setLayout(frmlytSch);
                 
               //2020-12-08 DisplayField, setValueField 변경 
                 typOccuCd = new ComboBox<BaseModel>();
                 typOccuCd.setForceSelection(true);
                 typOccuCd.setMinChars(1);
                 typOccuCd.setDisplayField("typOccuNm");
                 typOccuCd.setValueField("typOccuCd");
                 typOccuCd.setTriggerAction(TriggerAction.ALL);
                 typOccuCd.setEmptyText("--직종선택--");
                 typOccuCd.setSelectOnFocus(true); 
                 typOccuCd.setReadOnly(false);
                 typOccuCd.setEnabled(true); 
                 typOccuCd.setStore(lsTypOccuCd );
                 typOccuCd.setFieldLabel("직종");

                
                 layoutContainer_2.add(typOccuCd, new FormData("100%")); 
                 layoutContainer_2.setBorders(false);
                 
                 LayoutContainer layoutContainer_1 = new LayoutContainer();
                 layoutContainer_12.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
                 frmlytSch = new FormLayout();  
                 frmlytSch.setLabelWidth(70); 
                 frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
                 layoutContainer_1.setLayout(frmlytSch);
                  
                 pyspGrdeCd = new ComboBox<BaseModel>();
                 pyspGrdeCd.setForceSelection(true);
                 pyspGrdeCd.setMinChars(1);
                 pyspGrdeCd.setDisplayField("commCdNm");
                 pyspGrdeCd.setValueField("commCd");
                 pyspGrdeCd.setTriggerAction(TriggerAction.ALL);
                 pyspGrdeCd.setEmptyText("--등급선택--");
                 pyspGrdeCd.setSelectOnFocus(true); 
                 pyspGrdeCd.setReadOnly(false);
                 pyspGrdeCd.setEnabled(true); 
                 pyspGrdeCd.setStore(lsPyspGrdeCd );
                 pyspGrdeCd.setFieldLabel("등급"); 
               
                 
                 layoutContainer_1.add(pyspGrdeCd, new FormData("100%"));
                 layoutContainer_1.setBorders(false);  
               
                 LayoutContainer layoutContainer_13 = new LayoutContainer();
                 frmlytStd = new FormLayout();  
                 frmlytStd.setLabelWidth(60); 
                 frmlytStd.setLabelAlign(LabelAlign.RIGHT);
                 layoutContainer_13.setLayout(frmlytStd);
               

                 dtilOccuClsNm = new TextField<String>(); 
                 dtilOccuClsNm.setFieldLabel("직종세"); 
                 layoutContainer_13.add(dtilOccuClsNm, new FormData("100%")); 
                 layoutContainer_13.setBorders(false);
             
                 btnUsrSearch = new Button("검색");
                 btnUsrSearch.setIcon(MSFMainApp.ICONS.search()); 
                 
                 layoutContainer_12.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
                 layoutContainer_12.add(btnUsrSearch );
                 lycSreach.add(layoutContainer_12);
                
                cp03.add(lycSreach);
                
                frmSearchLayer.add(cp03);
              
                return frmSearchLayer ;
          }

}
