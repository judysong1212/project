/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.form;

import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;

import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;

public class MessageDialog extends MSFFormPanel {
  

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
	  public  FormBinding formBinding;
	   
   /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 상태처리 전역변수
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
  private ActionDatabase actionDatabase;
  private ShowMessageBM showMessagePlrlt;
  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 화면 렌더링 변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
    
  private MSFPanel caller; 
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
    
	private TextField<String> strWindowNm; 			// 화면명
	private TextField<String> strWindowId;				// 화면아이디 
	private TextField<String> strMessageDttm;	// 에러발생일시  
	private TextArea strMessageNm;						// 에러명
	private TextArea strMessageCtnt;					// 에러내용 
	private String strMessageTrace;
      
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
   // 검색 폼 바인딩 처리 함수 
      
	   //화면 폼 바인딩 처리 
	 //   private void setPayr410002FormBinding() {
	 	 
	    // formBinding.addFieldBinding(new FieldBinding(srhPubcHodyCtnt, "srhPubcHodyCtnt"));
	    // formBinding.addFieldBinding(new FieldBinding(degtrResnRegnNum, "degtrResnRegnNum"));
	   
	 //   }        
   
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
 
	  
	  public MessageDialog(final ShowMessageBM retval,final ActionDatabase actionDatabase, final MSFPanel caller) {
		    
 
		  
		    this.setFrame(false);
	        this.setBodyBorder(false);
	        this.setBorders(false);
	        this.setHeaderVisible(false);
	         
	        this.setAutoHeight(true);
	        this.actionDatabase = actionDatabase;
	      
	        this.showMessagePlrlt = new ShowMessageBM();
	        
	        this.showMessagePlrlt = retval;
	        this.caller = caller;
	        
	        
	        cpMessageFrm = new ContentPanel();
		    createMessageForm();  //화면 기본정보를 설정 
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
	  private  void createMessageForm() {  
	 
		  cpMessageFrm.setSize("590px", "440px");
	  }
	   
 
 
	 
	  private  void createStandardForm() {
		  
		  
	 	   ContentPanel cp01 = new ContentPanel();   
	 	   cp01.setBodyBorder(false); 
	 	   cp01.setHeaderVisible(false);   
	 	   cp01.setLayout(new FitLayout());      
	 	   cp01.setSize(590, 440);  
	 	   
	 	  
	 		LayoutContainer  lcSchCol = new LayoutContainer();
			
			
			LayoutContainer  lcSchCol1 = new LayoutContainer(new ColumnLayout());
			
			LayoutContainer  lcSchCol1_1 = new LayoutContainer();
			
			FormLayout frmlytSch = new FormLayout();  
			frmlytSch.setLabelWidth(80); 
			frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
			lcSchCol1_1.setLayout(frmlytSch);
	        
			strWindowNm = new TextField<String>();
			strWindowNm.setName("strWindowNm");
			strWindowNm.setFieldLabel("화면명");
			strWindowNm.setReadOnly(true);
			lcSchCol1_1.add(strWindowNm, new FormData("100%"));
			
			lcSchCol1.add(lcSchCol1_1,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
			
			LayoutContainer  lcSchCol1_2 = new LayoutContainer();
			
			frmlytSch = new FormLayout();  
			frmlytSch.setLabelWidth(80); 
			frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
			lcSchCol1_2.setLayout(frmlytSch);
	        
			strWindowId = new TextField<String>();
			strWindowId.setName("strWindowId");
			strWindowId.setFieldLabel("화면id");
			strWindowId.setReadOnly(true);
			lcSchCol1_2.add(strWindowId, new FormData("100%"));
			
			lcSchCol1.add(lcSchCol1_2,  new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
			
			lcSchCol.add(lcSchCol1);
			 
			
			LayoutContainer  lcSchCol3 = new LayoutContainer();
			
			frmlytSch = new FormLayout();  
			frmlytSch.setLabelWidth(80); 
			frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
			lcSchCol3.setLayout(frmlytSch);
			
			strMessageDttm = new TextField<String>();
			strMessageDttm.setName("strMessageDttm");
			strMessageDttm.setReadOnly(true);
			strMessageDttm.setFieldLabel("발생일시");
//			strMessageNm.setSize(940, 40);
			lcSchCol3.add(strMessageDttm, new FormData("100%"));
			
			lcSchCol.add(lcSchCol3);
			
			LayoutContainer  lcSchCol4 = new LayoutContainer();
			
			frmlytSch = new FormLayout();  
			frmlytSch.setLabelWidth(80); 
			frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
			lcSchCol4.setLayout(frmlytSch);
			
			strMessageNm = new TextArea();
			strMessageNm.setName("strMessageNm");
			strMessageNm.setFieldLabel("메시지명");
			strMessageNm.setReadOnly(true);
			strMessageNm.setHeight(100);
//			strMessageNm.setSize(940, 40);
			lcSchCol4.add(strMessageNm, new FormData("100%"));
			
			lcSchCol.add(lcSchCol4);
			
			LayoutContainer  lcSchCol5 = new LayoutContainer();
			
			frmlytSch = new FormLayout();  
			frmlytSch.setLabelWidth(80); 
			frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
			lcSchCol5.setLayout(frmlytSch);
			
			strMessageCtnt = new TextArea();
			strMessageCtnt.setName("strMessageCtnt");
			strMessageCtnt.setFieldLabel("메시지내용");
			strMessageCtnt.setHeight(280);
			strMessageCtnt.setReadOnly(true); 
			lcSchCol5.add(strMessageCtnt, new FormData("100%"));
			
			lcSchCol.add(lcSchCol5); 
	 	   
	 	    cp01.add(lcSchCol);   
	 	     
	 	    strWindowNm.setValue(showMessagePlrlt.getWindowNm()); 			// 화면명
	     	strWindowId.setValue(showMessagePlrlt.getWindowId());				// 화면아이디 
	     	strMessageDttm.setValue(showMessagePlrlt.getMessageDttm());	// 에러발생일시  
	     	strMessageNm.setValue(showMessagePlrlt.getMessage());						// 에러명
	     	 
	   		strMessageTrace = strMessageTrace + showMessagePlrlt.getStackTraceContent() + "\n"; 
	     	strMessageTrace =strMessageTrace + showMessagePlrlt.getContent();	
	     	strMessageCtnt.setValue(strMessageTrace);	 // 에러내용 
	     	  
			cpMessageFrm.add(cp01);  
			
     	 
     	  
			    
	 }  
		  
		  
			//폼초기화 검색조건포함 
		   private void formInit() { 
			  
			   actionDatabase = ActionDatabase.READ; 
			   
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
