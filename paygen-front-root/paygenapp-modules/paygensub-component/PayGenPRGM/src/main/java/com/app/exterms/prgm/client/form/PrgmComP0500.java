/**
 * 지급공제팝업.
 */
package com.app.exterms.prgm.client.form;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComP0500BM;
import com.app.exterms.prgm.client.form.defs.PrgmComBass0400Def;
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

 
public class PrgmComP0500  extends Lov implements PrgmComDaoConstants { 

	 /**######################################################
		 * { 시스템 기본설정파일 선언부  시작}
		 *#######################################################*/
	 

	     /**######################################################
	 	 * { 시스템 기본설정파일 선언부  종료}
	 	 *#######################################################*/

	  private PrgmConstants SysComLabel = PrgmConstants.INSTANCE;
	  
	  private static ListStore<BaseModel>   lsPymtDducDivCd = new ListStore<BaseModel>();//지급공제구분코드  
      
	  private static ComboBox<BaseModel> pymtDducDivCd ;    //지급공제구분코드 
	 
	  private static TextField<String> payExtpyNm;       //지급공제명
      public static Button btnUsrSearch;
	    
      
    public static ComboBox<BaseModel> getPymtDducDivCd() {
		return pymtDducDivCd;
	}

	public static void setPymtDducDivCd(ComboBox<BaseModel> pymtDducDivCd) {
		PrgmComP0500.pymtDducDivCd = pymtDducDivCd;
	} 
	 
	public static TextField<String> getPayExtpyNm() {
		return payExtpyNm;
	}

	public static void setPayExtpyNm(TextField<String> payExtpyNm) {
		PrgmComP0500.payExtpyNm = payExtpyNm;
	}

		public PrgmComP0500(int width, int height) {
	        this();
	        this.width  = width;
	        this.height = height;
	    }

	    public PrgmComP0500() {

	        lovDef = new LovDef();
	        lovDef.setTitle("지급공제항목");  //팝업상단의 타이틀 
	        lovDef.setDaoClass("");
	        lovDef.setAutoFillGrid(true);
	        lovDef.setFilterForm(false);  
	        lovDef.setCustomListMethod(PRGMCOM_METHOD_COMP0500TOPAYR0480_List);
	        lovDef.setCheckBoxOnGridRows(true);
	        
	        List<ColumnLovDef> listColumnLovDefs = new ArrayList<ColumnLovDef>();
	        
	        /** column 사업장코드 : dpobCd */
	        listColumnLovDefs.add(new ColumnLovDef("사업장코드", PrgmComP0500BM.ATTR_DPOBCD,PrgmComP0500BM.ATTR_DPOBCD, ColumnLovDef.TYPE_STRING , 90){
	            {
	                setIsVisibleInGrid(false);
	            }
	        });
	        
	        /** column 지급공제구분코드  : pymtDducDivCd */
	        listColumnLovDefs.add(new ColumnLovDef("지급공제구분코드", PrgmComP0500BM.ATTR_PYMTDDUCDIVCD,PrgmComP0500BM.ATTR_PYMTDDUCDIVCD, ColumnLovDef.TYPE_STRING , 90){
	            {
	                setIsVisibleInGrid(false);
	            }
	        });
	        
	        /** column 지급공제구분  : pymtDducDivNm */
	        listColumnLovDefs.add(new ColumnLovDef("지급공제", PrgmComP0500BM.ATTR_PYMTDDUCDIVNM,PrgmComP0500BM.ATTR_PYMTDDUCDIVNM, ColumnLovDef.TYPE_STRING , 90){
	            {

	            }
	        });
	        
	        /** column 급여수당코드 : payExtpyCd */
	        listColumnLovDefs.add(new ColumnLovDef("수당코드", PrgmComP0500BM.ATTR_PAYEXTPYCD,PrgmComP0500BM.ATTR_PAYEXTPYCD, ColumnLovDef.TYPE_STRING , 90){
	            {
	                
	            }
	        });
	        /** column 급여수당명 : payExtpyNm */
	        listColumnLovDefs.add(new ColumnLovDef("수당명", PrgmComP0500BM.ATTR_PAYEXTPYNM,PrgmComP0500BM.ATTR_PAYEXTPYNM, ColumnLovDef.TYPE_STRING , 90){
	            {

	            }
	        });
	        /** column 급여수당그룹코드 : payExtpyGrpCd */
	        listColumnLovDefs.add(new ColumnLovDef("그룹코드", PrgmComP0500BM.ATTR_PAYEXTPYGRPCD,PrgmComP0500BM.ATTR_PAYEXTPYGRPCD, ColumnLovDef.TYPE_STRING , 90){
	            {
	                setIsVisibleInGrid(false);
	            }
	        });
	        /** column 수당그룹 : payExtpyGrpCd */
	        listColumnLovDefs.add(new ColumnLovDef("수당그룹", PrgmComP0500BM.ATTR_PAYEXTPYGRPNM,PrgmComP0500BM.ATTR_PAYEXTPYGRPNM, ColumnLovDef.TYPE_STRING , 90){
	            {

	            }
	        });
	        
	        /** column 급여수당공제금액 : payExtpySum */
	        listColumnLovDefs.add(new ColumnLovDef("수당공제금액", PrgmComP0500BM.ATTR_PAYEXTPYSUM,PrgmComP0500BM.ATTR_PAYEXTPYSUM, ColumnLovDef.TYPE_LONG , 90){
	            {

	            }
	        });
	        /** column 급여수당공제비율 : payExtpyRto */
	        listColumnLovDefs.add(new ColumnLovDef("수당공제비율", PrgmComP0500BM.ATTR_PAYEXTPYRTO,PrgmComP0500BM.ATTR_PAYEXTPYRTO, ColumnLovDef.TYPE_DOUBLE , 90){
	            {

	            }
	        });
	      
	        /** column 사용여부 : payExtpyUseYn */
	        listColumnLovDefs.add(new ColumnLovDef("사용여부", PrgmComP0500BM.ATTR_PAYEXTPYUSEYN,PrgmComP0500BM.ATTR_PAYEXTPYUSEYN, ColumnLovDef.TYPE_BOOLEAN , 90){
	            {

	            }
	        });
	        
	       
	        
	        lovDef.setListColumns(listColumnLovDefs); 

	        lovDef.addHiddenColumn(new PrgmComBass0400Def().getColumnsDefinition()); 
	        lovDef.setCustomLayoutContainer(getMsfComP0500Filter()); 
	       
	    } 
	    
	    public static final LayoutContainer getMsfComP0500Filter() {
            
            final PrgmComBass0300DTO sysComBass0300Dto; //공통코드 dto 
             
            sysComBass0300Dto = new PrgmComBass0300DTO(); 
           //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
            //고용구분
            sysComBass0300Dto.setRpsttvCd("B008");
            lsPymtDducDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
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
                 
                 pymtDducDivCd = new ComboBox<BaseModel>();
                 pymtDducDivCd.setForceSelection(true);
                 pymtDducDivCd.setMinChars(1);
                 pymtDducDivCd.setDisplayField("commCdNm");
                 pymtDducDivCd.setValueField("commCd");
                 pymtDducDivCd.setTriggerAction(TriggerAction.ALL);
                 pymtDducDivCd.setEmptyText("--지급공제선택--");
                 pymtDducDivCd.setSelectOnFocus(true); 
                 pymtDducDivCd.setReadOnly(false);
                 pymtDducDivCd.setEnabled(true); 
                 pymtDducDivCd.setStore(lsPymtDducDivCd );
                 pymtDducDivCd.setFieldLabel("지급공제");
                
                 layoutContainer_2.add(pymtDducDivCd, new FormData("100%")); 
                 layoutContainer_2.setBorders(false);
                 
                 LayoutContainer layoutContainer_1 = new LayoutContainer();
                 layoutContainer_12.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
                 frmlytSch = new FormLayout();  
                 frmlytSch.setLabelWidth(70); 
                 frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
                 layoutContainer_1.setLayout(frmlytSch);
                  
                 
                 payExtpyNm = new TextField<String>(); 
                 payExtpyNm.setFieldLabel("지급공제명"); 
                 
                 layoutContainer_1.add(payExtpyNm, new FormData("100%"));
                 layoutContainer_1.setBorders(false);  
               
                 LayoutContainer layoutContainer_13 = new LayoutContainer();
                 frmlytStd = new FormLayout();  
                 frmlytStd.setLabelWidth(60); 
                 frmlytStd.setLabelAlign(LabelAlign.RIGHT);
                 layoutContainer_13.setLayout(frmlytStd);
               

               //  layoutContainer_13.add(payExtpyNm, new FormData("100%")); 
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
