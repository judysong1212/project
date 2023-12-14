/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.form;
 
import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.def.ShowMessageDef;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;

import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;

public class ShowMessageForm extends MSFFormPanel {
  

/**
 *##########################################################################
 * { 시스템 기본설정파일 선언부  시작}
 *##########################################################################
 **/
	    

/**
 *##########################################################################
 * { 시스템 기본설정파일 선언부  종료}
 *##########################################################################
 **/
  
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역변수 선언부  시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
 
	  private  ContentPanel cpMessageFrm; 
	  
	  private ShowMessageDef showMessageDef  = new ShowMessageDef();   //그리드 테이블 컬럼 define  
      // private MSFCustomForm msfCustomForm; 
      private MSFGridPanel showMessageGridPanel;
 
   /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 상태처리 전역변수
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
  private ActionDatabase actionDatabase;
  private PagingLoadResult<ShowMessageBM> showMessagePlrlt;
  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 화면 렌더링 변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
    
  private MSFPanel caller;
  private MSFFormPanel caller2;
  private Boolean reading = false;
  public  FormBinding formBinding;
  
  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * Button 변수 선언
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
       
 

  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 검색변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
     
      
  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 입력 변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
      private ListStore<BaseModel> storePrf;
      
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역변수 선언부  종료
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/	  

      
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역함수 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
 
   
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역함수 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/	
	  
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	Rpc Service 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/ 
 
	  //  private Payr4200ServiceAsync payr4200Service = Payr4200Service.Util.getInstance();
	    
	    private ListStore<BaseModel> lsPayYrStore = new ListStore<BaseModel>();  //년도 
  		   
	    
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
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 * 	print Service 선언부 시작
	 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	 **/
	/**
	 *############################################################################# 
	 * 프로그램 시작  	  
	 *############################################################################# 
	 **/ 
 
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
	    
	public ShowMessageForm(final PagingLoadResult<ShowMessageBM> retval,
			final ActionDatabase actionDatabase, final MSFFormPanel caller2) {

		this.setFrame(false);
		this.setBodyBorder(false);
		this.setBorders(false);
		this.setHeaderVisible(false);

		this.setAutoHeight(true);
		this.actionDatabase = actionDatabase;
		this.showMessagePlrlt = retval;
		this.caller2 = caller2;
		this.storePrf = new ListStore<BaseModel>();

		cpMessageFrm = new ContentPanel();
		createPayrP410002Form(); // 화면 기본정보를 설정
		createSearchForm(); // 검색필드를 적용
		createStandardForm(); // 기본정보필드

		cpMessageFrm.setBodyBorder(false);
		cpMessageFrm.setBorders(false);
		cpMessageFrm.setHeaderVisible(false);
		// cpMessageFrm.setSize("810px", "710px");

		this.add(cpMessageFrm);
		formBinding = new FormBinding(this, true);
		this.setSize("610px", "510px"); // setSize("790px", "610px");
	}    
 
	  
	  public ShowMessageForm(final PagingLoadResult<ShowMessageBM> retval,final ActionDatabase actionDatabase, final MSFPanel caller) {
		    
 
		    this.setFrame(false);
	        this.setBodyBorder(false);
	        this.setBorders(false);
	        this.setHeaderVisible(false);
	         
	        this.setAutoHeight(true);
	        this.actionDatabase = actionDatabase;
	        this.showMessagePlrlt = retval;
	        this.caller = caller;
	        this.storePrf = new ListStore<BaseModel>();  
	        
	        cpMessageFrm = new ContentPanel();
		    createPayrP410002Form();  //화면 기본정보를 설정
		    createSearchForm();    //검색필드를 적용 
		    createStandardForm();    //기본정보필드    
		    
		   
		   cpMessageFrm.setBodyBorder(false);
		   cpMessageFrm.setBorders(false);
		   cpMessageFrm.setHeaderVisible(false);
		  //cpMessageFrm.setSize("810px", "710px");  
		    
		    this.add(cpMessageFrm);
		    formBinding = new FormBinding(this, true);
			this.setSize("610px", "510px");  //setSize("790px", "610px");  
	  } 
	    
	  /**
	   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	   * 생성자 함수 선언부 종료
	   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
	   **/		 
	    
	  /**
	   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	   * 폼 생성시 기본 처리 함수 선언부 시작
	   * 1. 폼 생성 선언
	   * 2. 공통 버튼 처리 선언
	   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
	   **/	  
	  private  void createPayrP410002Form() {  
	 
		  cpMessageFrm.setSize("590px", "440px");
	  }
	   

	  /**
	   * 검색필드 설정
	   */
	  private  void createSearchForm() {   

		   
	  }  
	  
 
	 
	  private  void createStandardForm() {
		  
	      
	 	   ContentPanel cp01 = new ContentPanel();   
	 	   cp01.setBodyBorder(false); 
	 	   cp01.setHeaderVisible(false);   
	 	   cp01.setLayout(new FitLayout());      
	 	   cp01.setSize(590, 440);  
	 	   
	 	   List<ShowMessageBM> list = showMessagePlrlt.getData();
	 	   List<BaseModel> listBm = new ArrayList<BaseModel>();
    
//        storePrf.removeAll();
//        storePrf.add(listBm);  
//        storePrf.commitChanges();  
        
	 	  //msfCustomForm.setHeaderVisible(false);
	        //Instantiate the GridPanel
	 	   showMessageGridPanel = new MSFGridPanel(showMessageDef, false, false, false, false,false);
	 	   showMessageGridPanel.setHeaderVisible(false);  
	 	   showMessageGridPanel.setBodyBorder(true);
	 	   showMessageGridPanel.setBorders(true);
	 	   showMessageGridPanel.getBottomComponent().setVisible(false);
	 	  
	       GWTUtils.setGridCellRenderer(showMessageGridPanel, "content", cellRender);
	 	 
		  //   payr0100GridPanel.setFrame(true);
		  //  payr0100GridPanel.setSize(935, 400);  
		 //   payr0100GridPanel.showExportButton(true); 
	     //   msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.
	 	  showMessageGridPanel.getMsfGrid().clearData();
	 	    for ( int i=0 ; i<list.size() ; i++ ) {
	        	ShowMessageBM rowSmBm = list.get(i); 
	        	
	        
	        	BaseModel bm = showMessageGridPanel.getTableDef().getDefaultValues();  
	  	 	  //  BaseModel bm = new BaseModel();
	        	if (showMessageDef.PAYGEN_ERROR.equals(rowSmBm.getDivision())) {
	        		
	        		bm.set(rowSmBm.ATTR_DIVISION, "<div style=\"color: #ffffff; background-color: #ff0000\">"+ rowSmBm.getDivision() +"</div>");
	        		 
	        	} else {
	        		bm.set(rowSmBm.ATTR_DIVISION, rowSmBm.getDivision());
	        	}
	            bm.set(rowSmBm.ATTR_MENU, rowSmBm.getMenu());
	            bm.set(rowSmBm.ATTR_PHASE, rowSmBm.getPhase());
	            bm.set(rowSmBm.ATTR_MESSAGE, rowSmBm.getMessage());
	            bm.set(rowSmBm.ATTR_CONTENT, rowSmBm.getContent());
	          //  listBm.add(bm);  
	           
	            showMessageGridPanel.getMsfGrid().getGrid().getStore().insert(bm,i); 
		 	   // showMessageGridPanel.getMsfGrid().setStore(storePrf);
		 	   // showMessageGridPanel.getMsfGrid().getStore().commitChanges();
		 	   
	        }  
	 	    
	 	    showMessageGridPanel.getMsfGrid().getGrid().repaint();
	 	    
	 	    cp01.add(showMessageGridPanel);  
	 	    
		    
			cpMessageFrm.add(cp01);  
			    
		  }  
		 
	   private GridCellRenderer<BaseModel> cellRender = new GridCellRenderer<BaseModel>() {  
	        public Object render(final BaseModel model, String property, ColumnData config, final int rowIndex,  
	                final int colIndex, ListStore<BaseModel> store, Grid<BaseModel> grid) {
	        	 
	             String val = (String) model.get(property);
	             return "<div style=\"overflow: visible; white-space:normal !important;\">"+ val +" </div>"; 
	             
	        }  
	    };
			public void reload() {
				// TODO Auto-generated method stub
				formInit(); 
				IColumnFilter filters = null;
//				payr0304GridPanel.getTableDef().setTableColumnFilters(filters); 
//				 
//				payr0304GridPanel.getTableDef().addColumnFilter("pymtYrMnth", MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr"), SimpleColumnFilter.OPERATOR_EQUALS); 
//			 	payr0304GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
//			 
//				payr0304GridPanel.reload();
				
				actionDatabase = ActionDatabase.READ; 
			}
			
			
			//폼초기화 검색조건포함 
		   private void formInit() {
			     
			   subformInit(); 
			   
			 //  payr0304GridPanel.getMsfGrid().clearData();
			  
			   actionDatabase = ActionDatabase.READ;
			   
			   
		   }
		   
		   private void subformInit() { 
			      
			   //grid init 
//			   payr0302ExtpyGridPanel.getMsfGrid().clearData();
//			   payr0302DducGridPanel.getMsfGrid().clearData(); 
			     
		   }
	
	   @Override	
	   public void bind(final ModelData model) { 
	        formBinding.bind(model);
	        formBinding.addListener(Events.Bind, new Listener<BaseEvent>() {
	            //@Override
	            public void handleEvent(BaseEvent be) {
	                 
	            }
	        });
	    }
		       
		@Override
		public boolean isValid() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void onSuccessSave() {
			// TODO Auto-generated method stub  
		} 
		
		
	  

}

