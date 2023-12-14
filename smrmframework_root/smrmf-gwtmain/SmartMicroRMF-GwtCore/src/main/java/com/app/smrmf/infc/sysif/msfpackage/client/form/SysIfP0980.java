/**
 * sso 사용자 팝업화면 
 */
package com.app.smrmf.infc.sysif.msfpackage.client.form;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnLovDef;
import com.app.smrmf.core.msfmainapp.client.def.LovDef;
import com.app.smrmf.core.msfmainapp.client.generics.Lov;
import com.app.smrmf.infc.sysif.msfpackage.client.form.defs.SysIfBass0400Def;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0300DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0400DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfSysm0100BM;
import com.app.smrmf.infc.sysif.msfpackage.client.languages.SysIfConstants;
import com.app.smrmf.infc.sysif.msfpackage.client.utils.SysifComServiceUtils;
import com.app.smrmf.infc.sysif.msfpackage.shared.MSFPkgDaoConstants;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
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

 
public class SysIfP0980  extends Lov implements MSFPkgDaoConstants { 

	/**
	 * ###################################################### 
	 * { 시스템 기본설정파일 선언부 시작} 
	 * #######################################################
	 */

	/**
	 * ###################################################### 
	 * { 시스템 기본설정파일 선언부 종료} 
	 * #######################################################
	 */

	private SysIfConstants SysIfLabel = SysIfConstants.INSTANCE;
  
	private static SysIfBass0300DTO sysIfBass0300Dto; 		//공통코드 dto
	private static SysIfBass0400DTO sysIfBass0400Dto; 		//부서코드

	private static ListStore<BaseModel> lsDeptCd = new ListStore<BaseModel>();// 부서
	private static ListStore<BaseModel> lsUsrDivCd = new ListStore<BaseModel>();// 사용자구분

	private static ComboBox<BaseModel> deptCd; // 부서
	private static ComboBox<BaseModel> usrDivCd; // 사용자구분
	private static TextField<String> usrNm; // 성명

	public static Button btnUsrSearch;
  
  
  
    public static ComboBox<BaseModel> getDeptCd() {
    	return deptCd;
    }

	public static void setDeptCd(ComboBox<BaseModel> deptCd) {
		SysIfP0980.deptCd = deptCd;
	}

	public static ComboBox<BaseModel> getUsrDivCd() {
		return usrDivCd;
	}

	public static void setUsrDivCd(ComboBox<BaseModel> usrDivCd) {
		SysIfP0980.usrDivCd = usrDivCd;
	}

	public static TextField<String> getUsrNm() {
		return usrNm;
	}

	public static void setUsrNm(TextField<String> usrNm) {
		SysIfP0980.usrNm = usrNm;
	}

	public SysIfP0980(int width, int height) {
        this();
        this.width  = width;
        this.height = height;
    }

    public SysIfP0980() {

        lovDef = new LovDef();
        lovDef.setTitle("사용자검색");  //팝업상단의 타이틀 
        lovDef.setDaoClass("");
        lovDef.setAutoFillGrid(true);
        lovDef.setFilterForm(false);  
        lovDef.setCustomListMethod(CLASS_SYSM0100_LIST);
       // lovDef.setCheckBoxOnGridRows(true); 
        List<ColumnLovDef> listColumnLovDefs = new ArrayList<ColumnLovDef>();
        
     
    	/** column 부서코드 : deptCd */
        listColumnLovDefs.add(new ColumnLovDef("부서코드", SysIfSysm0100BM.ATTR_DEPTCD	, SysIfSysm0100BM.ATTR_DEPTCD	, ColumnDef.TYPE_STRING , 90 ){
    		{
    			setIsVisibleInGrid(false);
    		}
    	});
    	/** column 부서 : deptNm */
        listColumnLovDefs.add(new ColumnLovDef("부서", SysIfSysm0100BM.ATTR_DEPTNM, SysIfSysm0100BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 90  ){
    		{
    			setIsVisibleInGrid(true);
    		}
    	});
    	/** column 사용자구분코드 : usrDivCd */
    	listColumnLovDefs.add(new ColumnLovDef("사용자구분", SysIfSysm0100BM.ATTR_USRDIVCD, SysIfSysm0100BM.ATTR_USRDIVCD, ColumnDef.TYPE_STRING , 90 ){
    		{
    			setIsVisibleInGrid(false);
    		}
    	}); 
    	/** column 사용자성명 : usrNm */
    	listColumnLovDefs.add(new ColumnLovDef("성명", SysIfSysm0100BM.ATTR_USRNM, SysIfSysm0100BM.ATTR_USRNM, ColumnDef.TYPE_STRING , 90 ){
    		{
    			setIsVisibleInGrid(true);
    		}
    	});
    	/** column 사용자아이디 : usrId */
    	listColumnLovDefs.add(new ColumnLovDef("아이디", SysIfSysm0100BM.ATTR_USRID, SysIfSysm0100BM.ATTR_USRID, ColumnDef.TYPE_STRING , 90 ){
    		{
    			setIsVisibleInGrid(true);
    		}
    	});
    	
    	/** column 내선번호 : usrTel */
    	listColumnLovDefs.add(new ColumnLovDef("내선번호", SysIfSysm0100BM.ATTR_USRTEL,SysIfSysm0100BM.ATTR_USRTEL, ColumnDef.TYPE_STRING , 90 ){
    		{
    			setIsVisibleInGrid(true);
    		}
    	});

       
        
        lovDef.setListColumns(listColumnLovDefs); 

        lovDef.addHiddenColumn(new SysIfBass0400Def().getColumnsDefinition()); 
        lovDef.setCustomLayoutContainer(getMsfComP0500Filter()); 
       
    } 
    
    public static final LayoutContainer getMsfComP0500Filter() {
        
          
    	sysIfBass0300Dto = new SysIfBass0300DTO();
    	sysIfBass0400Dto = new SysIfBass0400DTO();
        
        //고용구분
    	sysIfBass0300Dto.setRpsttvCd("D001");
    	 lsUsrDivCd = SysifComServiceUtils.getSingleBass0300ComboData( sysIfBass0300Dto);
    	 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
    	
    	//--------------------부서 불러 오는 함수 ------------------------------------------------
		 lsDeptCd = SysifComServiceUtils.getDeptBass0400ComboData(sysIfBass0400Dto);
		 //--------------------부서 불러 오는 함수 ------------------------------------------------
		 
         
        
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
             
             deptCd = new ComboBox<BaseModel>();
 		     deptCd.setForceSelection(true);
 		     deptCd.setMinChars(1);
 		     deptCd.setDisplayField("deptNmRtchnt");
 		     deptCd.setValueField("deptCd");
 		     deptCd.setTriggerAction(TriggerAction.ALL);
 		     deptCd.setEmptyText("--부서선택--");
 		     deptCd.setSelectOnFocus(true); 
 		     deptCd.setReadOnly(false);
 		     deptCd.setEnabled(true); 
 		     deptCd.setStore(lsDeptCd );
 		     deptCd.setFieldLabel("부서");
            
             layoutContainer_2.add(deptCd, new FormData("100%")); 
             layoutContainer_2.setBorders(false);
             
             LayoutContainer layoutContainer_1 = new LayoutContainer();
             layoutContainer_12.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
             frmlytSch = new FormLayout();  
             frmlytSch.setLabelWidth(70); 
             frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
             layoutContainer_1.setLayout(frmlytSch);
              
             usrDivCd =  new ComboBox<BaseModel>(); 
 		    usrDivCd.setForceSelection(true);
 		    usrDivCd.setMinChars(1);
 		    usrDivCd.setDisplayField("commCdNm");
 		    usrDivCd.setValueField("commCd");
 		    usrDivCd.setTriggerAction(TriggerAction.ALL);
 		    usrDivCd.setAllowBlank(false);
 		    //usrDivCd.setEmptyText("--사용자구분선택--");
 		    usrDivCd.setSelectOnFocus(true); 
 		    usrDivCd.setReadOnly(false);
 		    usrDivCd.setEnabled(true); 
 		    usrDivCd.setStore(lsUsrDivCd);
 		    usrDivCd.setFieldLabel("사용자구분"); 
 		    usrDivCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
 	            public void handleEvent(StoreEvent<BaseModel> be) {  

 	                usrDivCd.setValue(lsUsrDivCd.getAt(0));
 	            }
 	        }); 
           
             
             layoutContainer_1.add(usrDivCd, new FormData("100%"));
             layoutContainer_1.setBorders(false);  
           
             LayoutContainer layoutContainer_13 = new LayoutContainer();
             frmlytStd = new FormLayout();  
             frmlytStd.setLabelWidth(60); 
             frmlytStd.setLabelAlign(LabelAlign.RIGHT);
             layoutContainer_13.setLayout(frmlytStd);
           

             usrNm = new TextField<String>(); 
 	   	     usrNm.setFieldLabel("성 명");
             layoutContainer_13.add(usrNm, new FormData("100%")); 
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
