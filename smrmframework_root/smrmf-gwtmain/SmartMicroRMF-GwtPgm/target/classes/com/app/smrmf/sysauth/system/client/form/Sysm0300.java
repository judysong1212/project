package com.app.smrmf.sysauth.system.client.form;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.core.resources.client.Resources;
import com.app.smrmf.sysauth.system.client.form.defs.Sysm0300Def;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Encoding;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Method;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;


/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Sysm0300  extends MSFPanel { 
	
	 /**######################################################
		 * { 시스템 기본설정파일 선언부  시작}
		 *#######################################################*/
	 

	     /**######################################################
	 	 * { 시스템 기본설정파일 선언부  종료}
	 	 *#######################################################*/
	
	  private VerticalPanel vp;
	  private FormPanel plFrmSysm0300;
	  private FormData formData; 
	  private String txtForm = "";
	  private XTemplate detailTp; 
	  private MSFGridPanel msfGridPanel;
	  

      private TextField<String> authGrpNm;         //권한그룹명
      
	   
	  public ContentPanel getViewPanel(){
			if(panel == null){
				 
			    detailTp = XTemplate.create(getDetailTemplate());
			    
			    formData = new FormData("-650");
			    vp = new VerticalPanel();
			    vp.setSpacing(10);
			    createSysm0300Form();  //화면 기본정보를 설정
			 //   createSearchForm();    //검색필드를 적용
			 //   createStandardForm();    //기본정보필드 
			 //   createTabForm();       //탭구성
			    vp.setSize("1010px", "700px");	
				            
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
	  public Sysm0300() {
			setSize("1010px", "700px");  
	  } 
	
	  public Sysm0300(String txtForm) {
			this.txtForm = txtForm;
	  }
	  
	  private void createSysm0300Form() {
		  
		plFrmSysm0300 = new FormPanel();
		plFrmSysm0300.setHeadingText("ExTerms Ver1.0 - 사용자권한관리");
		plFrmSysm0300.setIcon(Resources.APP_ICONS.text());
		plFrmSysm0300.setBodyStyleName("pad-text");
		plFrmSysm0300.setFrame(true); 
		
		//파일업로드 처리
		plFrmSysm0300.setAction("myurl");
		plFrmSysm0300.setEncoding(Encoding.MULTIPART);
		plFrmSysm0300.setMethod(Method.POST);
		    
		      Sysm0300Def  admSysm0300 = new Sysm0300Def(); 
			 // admSysm0100.setReadOnly(true);
	          msfGridPanel = new MSFGridPanel(admSysm0300, true, true, true);  
	          msfGridPanel.setBodyBorder(true);
	          msfGridPanel.setBorders(true);
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
	          
	          //검색조건 
	            
	            LayoutContainer  lycSreach = new LayoutContainer(); 
	            FormLayout frmlytStd = new FormLayout();  
		   	    frmlytStd.setLabelWidth(0);  
		   	    lycSreach.setLayout(frmlytStd);
		        lycSreach.setHeight(30); 
		  	    
		        LayoutContainer layoutContainer_12 = new LayoutContainer();
		   	    layoutContainer_12.setLayout(new ColumnLayout());
		   	    layoutContainer_12.setStyleAttribute("paddingTop", "5px");
		   	    
		      
		   	    LayoutContainer layoutContainer_13 = new LayoutContainer();
		   	    frmlytStd = new FormLayout();  
		   	    frmlytStd.setLabelWidth(80); 
		   	    frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		   	    layoutContainer_13.setLayout(frmlytStd);
		   	   
		     	 authGrpNm = new TextField<String>(); 
		     	authGrpNm.setFieldLabel("권한그룹명");
		   	    layoutContainer_13.add(authGrpNm, new FormData("100%")); 
		   	    layoutContainer_13.setBorders(false);
		   	
		   	    Button btnUsrSearch = new Button("검색");
		   	    btnUsrSearch.setIcon(MSFMainApp.ICONS.search());
		    	    btnUsrSearch.addListener(Events.Select, new Listener<ButtonEvent>() {
		   	    	public void handleEvent(ButtonEvent e) {
		   	    		  
		   	    		reload(); 
		   	    	}
		   	    });
		 	    
		   	    layoutContainer_12.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		   	    layoutContainer_12.add(btnUsrSearch );
		   	    lycSreach.add(layoutContainer_12);
	   	     
		    	 msfGridPanel.setTopComponent(lycSreach);
	          
	          plFrmSysm0300.add(msfGridPanel); 
	        
		vp.add(plFrmSysm0300);
		plFrmSysm0300.setSize("990px", "680px");
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
	    		 
	        	msfGridPanel.getTableDef().addColumnFilter("authGrpNm", MSFSharedUtils.defaultNulls(authGrpNm.getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
	            msfGridPanel.reload();
//	    	}
	    
	    }

	    private Sysm0300 getThis(){
	        return this;
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


}
