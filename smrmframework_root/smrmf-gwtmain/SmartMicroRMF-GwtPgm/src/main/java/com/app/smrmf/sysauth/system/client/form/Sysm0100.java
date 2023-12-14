/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.sysauth.system.client.form;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.core.resources.client.Resources;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0300DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0400DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.utils.SysifComServiceUtils;
import com.app.smrmf.sysauth.system.client.form.defs.Sysm0100Def;
import com.app.smrmf.sysauth.system.client.languages.SysmConstants;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.event.dom.client.KeyCodes;


/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Sysm0100  extends MSFPanel { 
	
	 /**######################################################
		 * { 시스템 기본설정파일 선언부  시작}
		 *#######################################################*/
	 

	     /**######################################################
	 	 * { 시스템 기본설정파일 선언부  종료}
	 	 *#######################################################*/
	
	  private SysmConstants lblSysmConst = SysmConstants.INSTANCE;
	
	  private VerticalPanel vp; 
	  private FormPanel plFrmSysm0100;
	  private MSFGridPanel msfGridPanel;
	  
	   
      private ComboBox<BaseModel> deptCd ;    //부서 
      private ComboBox<BaseModel> usrDivCd;    //사용자구분
      private TextField<String> usrNm;         //성명 
     
      private ListStore<BaseModel>   lsDeptCd = new ListStore<BaseModel>();//부서 
  	  private ListStore<BaseModel>   lsUsrDivCd = new ListStore<BaseModel>();//사용자구분 
  	 
  	  private SysIfBass0300DTO sysIfBass0300Dto; //공통코드 dto
  	  private SysIfBass0400DTO sysIfBass0400Dto; //부서코드
	    
	  

//  	private TextField<String> sysDivCd   /** column 시스템구분코드 : sysDivCd */
//
//  	private TextField<String> usrId   /** column 사용자아이디 : usrId */
//
//  	private TextField<String> usrNm   /** column 사용자성명 : usrNm */
//
//  	private TextField<String> usrDivCd   /** column 사용자구분코드 : usrDivCd */
//
//  	private TextField<String> systemkey   /** column SYSTEMKEY : systemkey */
//
//  	private TextField<String> deptCd   /** column 부서코드 : deptCd */
//
//  	private TextField<String> usrTel   /** column null : usrTel */
//
//  	private TextField<String> email   /** column 이메일 : email */
//
//  	private TextField<String> pwd   /** column 패스워드 : pwd */
//
//  	private TextField<String> useYn   /** column 사용자사용여부 : useYn */
//
//  	private TextField<String> kybdr   /** column 입력자 : kybdr */
//
//  	private TextField<String> inptDt   /** column 입력일자 : inptDt */
//
//  	private TextField<String> inptAddr   /** column 입력주소 : inptAddr */
//
//  	private TextField<String> ismt   /** column 수정자 : ismt */
//
//  	private TextField<String> revnDt   /** column 수정일자 : revnDt */
//
//  	private TextField<String> revnAddr   /** column 수정주소 : revnAddr */
  	
	   
	  public ContentPanel getViewPanel(){
			if(panel == null){
				  
				panel = new ContentPanel();
			//	panel.setLayout(new FitLayout());  
		        panel.setBodyBorder(false);
		        panel.setBorders(false);
		        panel.setScrollMode(Scroll.AUTO); 
		        panel.setHeaderVisible(false); 
		        
			    vp = new VerticalPanel();
			    vp.setSpacing(10);
			    vp.setSize("1010px", "700px");
			    
			    createPsnl0100Form();  //화면 기본정보를 설정
			  
		        panel.add(vp);
		        
		   	  
			}
			return panel;
		}
	  
	  /**
	   * @wbp.parser.constructor
	   */
	  public Sysm0100() {
		  
			setSize("1010px", "700px");  
	  } 
	
	  public Sysm0100(String txtForm) {
			 
	  }
	  
	  private void createPsnl0100Form() {
		
		  plFrmSysm0100 = new FormPanel();
		  plFrmSysm0100.setHeadingText("ExTerms Ver1.0 - " + lblSysmConst.main_TitleSysm0100());
		  plFrmSysm0100.setIcon(Resources.APP_ICONS.text());
		  plFrmSysm0100.setBodyStyleName("pad-text");
		  plFrmSysm0100.setFrame(false);  
        
		  Sysm0100Def  admSysm0100 = new Sysm0100Def(""); 
		 
		 // admSysm0100.setReadOnly(true); 
          msfGridPanel = new MSFGridPanel(admSysm0100, true, true, true);  
	        
          msfGridPanel.setHeaderVisible(false);
          msfGridPanel.setSize("965px", "630px");
         // Grid grid = msfGridPanel.getMsfGrid().getGrid();
         // grid.addListener(Events.CellClick, new Listener<BaseEvent>() {
         //   public void handleEvent(BaseEvent be) {
		       //  treePanel.mask(ExTerms.MSFMESSAGES.LoadingData());
		       //  usr = new UtenteBM();
		       //  usr.setId(new Long(edpGridPanel.getEdpGrid().getCurrentlySelectedItem().get("identnr").toString()));
		       //  clearTree();
		       //  readVociMenuUtente(usr); 
          //   }
        // });
          
         sysIfBass0300Dto = new SysIfBass0300DTO();
     	 sysIfBass0400Dto = new SysIfBass0400DTO();
        //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
     	 //고용구분
     	 sysIfBass0300Dto.setRpsttvCd("D001");
     	 lsUsrDivCd = SysifComServiceUtils.getSingleBass0300ComboData( sysIfBass0300Dto);
     	 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
         sysIfBass0400Dto.setDeptDspyYn("Y");
     	//--------------------부서 불러 오는 함수 ------------------------------------------------
		 lsDeptCd = SysifComServiceUtils.getDeptBass0400ComboData(sysIfBass0400Dto);
		 //--------------------부서 불러 오는 함수 ------------------------------------------------
		   
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
		  //  usrDivCd.setAllowBlank(true);
		    usrDivCd.setEmptyText("--사용자구분선택--");
		    usrDivCd.setSelectOnFocus(true); 
		    usrDivCd.setReadOnly(false);
		    usrDivCd.setEnabled(true); 
		    usrDivCd.setStore(lsUsrDivCd);
		    usrDivCd.setFieldLabel("사용자구분"); 
		    usrDivCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
	            public void handleEvent(StoreEvent<BaseModel> be) {  

	              //  usrDivCd.setValue(lsUsrDivCd.getAt(0));
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
	   	    usrNm.getElement().setAttribute("autocorrect", "off"); 
	        usrNm.getElement().setAttribute("autocomplete", "off");
	   	    usrNm.addKeyListener(new KeyListener() {
               public void componentKeyUp(ComponentEvent event) {
                   super.componentKeyUp(event);
                   usrNm.validate();
                   if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
                       reload(); 
                   }
               }
            });

	   	    layoutContainer_13.add(usrNm, new FormData("100%")); 
	   	    layoutContainer_13.setBorders(false);
	   	
	   	    Button btnUsrSearch = new Button("검색");
	   	    btnUsrSearch.setIcon(MSFMainApp.ICONS.search());
	    	    btnUsrSearch.addListener(Events.Select, new Listener<ButtonEvent>() {
	   	    	public void handleEvent(ButtonEvent e) {
	   	    		  
	   	    		reload(); 
	   	    	}
	   	    });
	 	    
	   	    layoutContainer_12.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
	   	    layoutContainer_12.add(btnUsrSearch );
	   	    lycSreach.add(layoutContainer_12);
   	     
	   	 msfGridPanel.setTopComponent(lycSreach);
          
        plFrmSysm0100.add(msfGridPanel); 
	 	vp.add(plFrmSysm0100);
		plFrmSysm0100.setSize("990px", "680px");
	  }
	   
	  @Override
	    public void reload() {
	    	
//	    	if ( MSFSharedUtils.paramNull(usrNm.getValue())) {
//	    		 MessageBox.alert("검색오류", 
//	    				 MSFMainApp.ADMINMESSAGES.ExceptionMessageService("성명을 선택하십시요."), null); 
//	    		usrNm.focus();
//	    	} else {
	    		IColumnFilter filters = null;
	        	msfGridPanel.getTableDef().setTableColumnFilters(filters);
	    		 
	        	msfGridPanel.getTableDef().addColumnFilter("deptCd", MSFSharedUtils.getSelectedComboValue(deptCd,"deptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
	        	msfGridPanel.getTableDef().addColumnFilter("usrDivCd", MSFSharedUtils.getSelectedComboValue(usrDivCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
	        	msfGridPanel.getTableDef().addColumnFilter("usrNm", MSFSharedUtils.defaultNulls(usrNm.getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
	        	msfGridPanel.getTableDef().addColumnFilter("searchKeyword", "Y", SimpleColumnFilter.OPERATOR_EQUALS); 
	            msfGridPanel.reload();
//	    	}
	    
	    }

	    private Sysm0100 getThis(){
	        return this;
	    } 
		    

}
