package com.app.exterms.basis.client.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.basis.client.dto.Bass5540DTO;
import com.app.exterms.basis.client.form.defs.Bass5540Def;
import com.app.exterms.basis.client.languages.BasisConstants;
import com.app.exterms.basis.client.service.Bass5540Service;
import com.app.exterms.basis.client.service.Bass5540ServiceAsync;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Encoding;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Method;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Bass5540  extends MSFPanel { 
	


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
	  private BasisConstants lblBassConst = BasisConstants.INSTANCE;
		
	  private VerticalPanel vp;
	  private FormPanel plFrmPayr1400;
	 // private FormData formData; 
	  private String txtForm = "";
	  private XTemplate detailTp; 
	  
	  private Bass5540Def bass5540Def  = new Bass5540Def();   //그리드 테이블 컬럼 define  
	      // private MSFCustomForm msfCustomForm; 
	  private MSFGridPanel bass5540GridPanel;
 
	   
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
	       
	      
	      /**
	       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	       * Button 변수 선언
	       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	       */
	      private ButtonBar topPayr1400Bar;
	      private Button btnPayr1400New;
	      private Button btnPayr1400Save;
	      private Button btnPayr1400Del;
	      private Button btnPayr1400Sreach;
	      private Button btnPayr1400Excel;
	      
	      /**
	       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	       * 검색변수 선언 
	       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	       */
	      /** column 급여공제그룹코드 : payDducGrpCd */
	      private ComboBox<BaseModel> srhPayDducGrpCd;   //급여공제그룹코드
	      /** column 급여공제명 : payDducNm */
	      private TextField<String> srhPayDducNm;  //급여공제명 
 
	      /**
	       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	       * 입력 변수 선언 
	       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	       */ 
	      
          private HiddenField<String> dpobCd;   /** column 사업장코드 : dpobCd */
 
//        private TextField<String> payDducCd   /** column 급여공제코드 : payDducCd */
//
//        private TextField<String> payDducGrpCd   /** column 급여공제그룹코드 : payDducGrpCd */
//
//        private TextField<String> payDducNm   /** column 급여공제명 : payDducNm */
//
//        private TextField<String> payDducUseYn   /** column 급여공제사용여부 : payDducUseYn */
//
//        private TextField<String> payDducSum   /** column 급여공제금액 : payDducSum */
//
//        private TextField<String> payDducRto   /** column 급여공제비율 : payDducRto */
//
//        private TextField<String> yrtxDducDivCd   /** column 연말정산_공제구분코드 : yrtxDducDivCd */
//
//        private TextField<String> grpApptnDivCd   /** column 그룹적용구분코드 : grpApptnDivCd */
//
//        private TextField<String> payDducBgnnDt   /** column 급여공제시작일자 : payDducBgnnDt */
//
//        private TextField<String> payDducEndDt   /** column 급여공제종료일자 : payDducEndDt */
//
//        private TextField<String> kybdr   /** column 입력자 : kybdr */
//
//        private TextField<String> inptDt     /** column 입력일자 : inptDt */
//
//        private TextField<String> inptAddr   /** column 입력주소 : inptAddr */
//
//        private TextField<String> ismt      /** column 수정자 : ismt */
//
//        private TextField<String> revnDt   /** column 수정일자 : revnDt */
//
//        private TextField<String> revnAddr   /** column 수정주소 : revnAddr */
	      
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
	      private Bass5540ServiceAsync payr1400Service = Bass5540Service.Util.getInstance();  
		   //공통 코드  
			private ListStore<BaseModel>  lsPayDducGrpCd = new ListStore<BaseModel>(); //급여수당그룹코드
			private PrgmComBass0300DTO sysComBass0300Dto; 
			//private Bass0200DTO bass0200Dto; 
		   
			private BaseModel record;
			
			private List<Record> records;
		    
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
		    private SelectionListener<ButtonEvent> selectionListener = 
			        new SelectionListener<ButtonEvent>() {
			        public void componentSelected(ButtonEvent ce) { 
			            if (ce.getButton() == btnPayr1400Save) {
			            	if (ActionDatabase.INSERT.equals(actionDatabase)) { 
			            			doAction(ActionDatabase.INSERT);
			            	} else if (ActionDatabase.UPDATE.equals(actionDatabase) ){ 
			            	        doAction(ActionDatabase.UPDATE);
			            	}
			            } else if (ce.getButton() == btnPayr1400Del) {
			            	MessageBox.confirm("경고", "급여공제내역을 삭제하겠습니까?</br> (삭제된 데이터는 복구되지 않습니다.)",new Listener<MessageBoxEvent>(){
			            		@Override
			            		public void handleEvent(MessageBoxEvent be) {
			            			//if("Yes".equals(be.getButtonClicked().getText())){
			            			if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
			            				 doAction(ActionDatabase.DELETE);
			            			}
			            		}
			            	});
			            }

			        }  
			    };
			  
		    private void doAction(ActionDatabase actionDatabase) {
		        switch (actionDatabase) {
		        case INSERT:
		        	save();
		            break;
		        case UPDATE: 
		        	save();
		            break;
		        case DELETE:
		            actionDatabase = ActionDatabase.DELETE;
	                payr1400Delete();
		            break;
		        }
		    }
		    
		    
	        public void save() {
//	        if (isValid()) {
	            
	          
	            if (bass5540GridPanel.getMsfGrid().getGrid().getStore().getModifiedRecords().size() <= 0) {
	                
	                MessageBox.alert("공제", "저장할 공제데이타가 존재하지 않습니다.", null);
	                return;
	            }
	            
	              
	            MessageBox.confirm("저장", "데이터를 저장하시겠습니까?",new Listener<MessageBoxEvent>(){
	                @Override
	                public void handleEvent(MessageBoxEvent be) {
	                    //if("Yes".equals(be.getButtonClicked().getText())){
	                	if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
	                        
	                          
	                        Iterator<Record> iterRecords = bass5540GridPanel.getMsfGrid().getGrid().getStore().getModifiedRecords().iterator();
	                           
                            List<Bass5540DTO> listPayr0470dto = new ArrayList<Bass5540DTO>();  
                            
                            while (iterRecords.hasNext()) {
                          
                                Record record = (Record) iterRecords.next(); 
                                BaseModel bmMapModel = (BaseModel)record.getModel();
                                  
                                Bass5540DTO bass5540Dto = new Bass5540DTO();  
                                

                                bass5540Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
                                bass5540Dto.setPayDducCd(MSFSharedUtils.allowNulls(bmMapModel.get("payDducCd")));    /** column 급여공제코드 : payDducCd */
                                bass5540Dto.setPymtDducDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("pymtDducDivCd$commCd")));    /** column 지급공제구분코드 : pymtDducDivCd */
                                bass5540Dto.setPayDducGrpCd(MSFSharedUtils.allowNulls(bmMapModel.get("payDducGrpCd$commCd")));    /** column 급여공제그룹코드 : payDducGrpCd */
                                bass5540Dto.setPayDducNm(MSFSharedUtils.allowNulls(bmMapModel.get("payDducNm")));    /** column 급여공제명 : payDducNm */
                                bass5540Dto.setPayrTermDducYn((Boolean)bmMapModel.get("payrTermDducYn"));    /** column 기간제공제사용여부 : payrTermDducYn */
                                bass5540Dto.setPayDducUseYn((Boolean)bmMapModel.get("payDducUseYn"));    /** column 급여공제사용여부 : payDducUseYn */
                                bass5540Dto.setPayDducSum((Long)bmMapModel.get("payDducSum"));    /** column 급여공제금액 : payDducSum */
                                bass5540Dto.setPayDducRto((Double)bmMapModel.get("payDducRto"));    /** column 급여공제비율 : payDducRto */
                                bass5540Dto.setYrtxDducDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxDducDivCd$commCd")));    /** column 연말정산_공제구분코드 : yrtxDducDivCd */
                                bass5540Dto.setGrpApptnDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("grpApptnDivCd$commCd")));    /** column 그룹적용구분코드 : grpApptnDivCd */
                                bass5540Dto.setPayDducBgnnDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("payDducBgnnDt"),"yyyyMMdd"));    /** column 급여공제시작일자 : payDducBgnnDt */
                                bass5540Dto.setPayDducEndDt(GWTUtils.getStringFromDate((Date)bmMapModel.get("payDducEndDt"),"yyyyMMdd"));    /** column 급여공제종료일자 : payDducEndDt */
//                                payr0470Dto.setKybdr(MSFSharedUtils.allowNulls(bmMapModel.get("kybdr")));    /** column 입력자 : kybdr */
//                                payr0470Dto.setInptDt(MSFSharedUtils.allowNulls(bmMapModel.get("inptDt")));    /** column 입력일자 : inptDt */
//                                payr0470Dto.setInptAddr(MSFSharedUtils.allowNulls(bmMapModel.get("inptAddr")));    /** column 입력주소 : inptAddr */
//                                payr0470Dto.setIsmt(MSFSharedUtils.allowNulls(bmMapModel.get("ismt")));    /** column 수정자 : ismt */
//                                payr0470Dto.setRevnDt(MSFSharedUtils.allowNulls(bmMapModel.get("revnDt")));    /** column 수정일자 : revnDt */
//                                payr0470Dto.setRevnAddr(MSFSharedUtils.allowNulls(bmMapModel.get("revnAddr")));    /** column 수정주소 : revnAddr */
 
                                listPayr0470dto.add(bass5540Dto);
                              
                            }   
                            
	                         payr1400Service.activityOnBass5540Save(listPayr0470dto,  
                                    new AsyncCallback<Long>() {
                                public void onFailure(Throwable caught) {
                                    MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                                            MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr1400Save(save) : " + caught), null);
                                }
                                public void onSuccess(Long result) { 
                                    if (result == 0) {
                                        MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
                                                "저장이 완료되지 않았습니다. 데이타를 확인하십시요.", null);
                                    } else {
                                        MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "저장이 완료되었습니다.", null);
                                        reload();
                                    } 
                                } 
                                });
	                      }
	                    }
	                });
	           
//	        }
	      }
	         
	        
	        public void payr1400Delete() {
//	        if (isValid()) { 
	            
	            if(bass5540GridPanel.getGrid().getSelectionModel().getSelectedItems().size() > 0){
	                MessageBox.confirm("삭제", "선택하신 공제을 삭제하시겠습니까?",new Listener<MessageBoxEvent>(){
	                    @Override
	                    public void handleEvent(MessageBoxEvent be) {
	                     //   if("Yes".equals(be.getButtonClicked().getText())){
	                    	if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
	                            
	                            payr1400Service.activityOnBass5540Delete(bass5540GridPanel.getGrid().getSelectionModel().getSelectedItems() , new AsyncCallback<Long>() {
	                                
	                                @Override
	                                public void onSuccess(Long result) {
	                                    if (result == 0) {
	                                        MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
	                                                "삭제가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
	                                    } else {
	                                        MessageBox.alert("삭제완료", "선택하신 공제("+result+")이 삭제되었습니다.", null);
	                                        reload();
	                                    } 
	                                    
	                                  
	                                    
	                                }
	                                
	                                @Override
	                                public void onFailure(Throwable caught) {
	                                    MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	                                            MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr1400Delete(delete) : " + caught), null);
	                                    
	                                }
	                            });
	                        }
	                    }
	                });
	            } else {
	                MessageBox.alert("공제선택", "삭제할 공제을 선택하십시요.", null);
	            }
	             
//	        }
	      } 
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	Rpc Service 선언부 종료
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/

/**
 *############################################################################# 
 * 프로그램 시작  	  
 *############################################################################# 
 **/
	
  
	  public ContentPanel getViewPanel(){
			if(panel == null){

				
			    detailTp = XTemplate.create(getDetailTemplate());
			    
			    //formData = new FormData("-650");
			    vp = new VerticalPanel();
			    vp.setSpacing(10);
			    createPayr1400Form();  //화면 기본정보를 설정
			    createSearchForm();    //검색필드를 적용
			    createListGrid();    //그리드 정보   
			    
			    vp.setSize("1010px", "700px");
			    
			    actionDatabase = ActionDatabase.UPDATE;
				            
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
 *############################################################################# 
 * 프로그램 종료  	  
 *############################################################################# 
 **/	  

/**
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * 생성자 함수 선언부 시작
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
 **/ 	
	  /**
	   * @wbp.parser.constructor
	   */
	  public Bass5540() {
		  
		    
			setSize("1010px", "700px");  
	  } 
	
	  public Bass5540(String txtForm) {
			this.txtForm = txtForm;
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
	  private void createPayr1400Form() {
		  
			plFrmPayr1400 = new FormPanel();
			plFrmPayr1400.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" -  ") + lblBassConst.title_Bass5540());
			//plFrmPayr1400.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 공제관리");
			plFrmPayr1400.setIcon(MSFMainApp.ICONS.text());
			plFrmPayr1400.setBodyStyleName("pad-text");
			plFrmPayr1400.setPadding(2);
			plFrmPayr1400.setFrame(true);  
			
			/************************************************************************
			 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
			 ************************************************************************/
			final Button btnlogView = new Button("로그");   
			
			btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
			btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
				public void handleEvent(ButtonEvent e) {
					 //로그 뷰화면 호출 메서드 
					  funcLogMessage(lblBassConst.title_Bass5540(),"PAYR1400");
					}
				});
			plFrmPayr1400.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
			plFrmPayr1400.getHeader().addTool(btnlogView); 
			/************************************************************************
			 * 화면 에러 처리시 필요한 부분으로 추가 
			 ************************************************************************/

			
			  plFrmPayr1400.setLayout(new FormLayout());
			
			  topPayr1400Bar = new ButtonBar();    
			  topPayr1400Bar.setAlignment(HorizontalAlignment.RIGHT);
   
		  
			  btnPayr1400New = new Button("신규");  
			  btnPayr1400New.setIcon(MSFMainApp.ICONS.new16());
		  	  topPayr1400Bar.add(btnPayr1400New);
		  	btnPayr1400New.addListener(Events.Select, new Listener<ButtonEvent>() {
	    		public void handleEvent(ButtonEvent e) {
	    		    formNewRows();
	    		}
	    	});
		   	
		  	btnPayr1400Save = new Button("저장");  
		  	btnPayr1400Save.setIcon(MSFMainApp.ICONS.save16());
		  	topPayr1400Bar.add(btnPayr1400Save); 
		  	btnPayr1400Save.addSelectionListener(selectionListener);
		  	
		  	btnPayr1400Del = new Button("삭제");  
		  	btnPayr1400Del.setIcon(MSFMainApp.ICONS.delete16());
		  	topPayr1400Bar.add(btnPayr1400Del);
		  	btnPayr1400Del.addSelectionListener(selectionListener);
		  	
		  	btnPayr1400Sreach = new Button("조회"); 
		  	btnPayr1400Sreach.setIcon(MSFMainApp.ICONS.search16());
		  	topPayr1400Bar.add(btnPayr1400Sreach);
		  	btnPayr1400Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
	    		public void handleEvent(ButtonEvent e) {
	    			//조회버튼 클릭시 처리 
	    		    reload();  
	    		}
	    	});
//		  	topBtn = new Button("인쇄"); 
//		  	topBtn.setIcon(MSFMainApp.ICONS.print16()); 
//		  	topPayr1400Bar.add(topBtn);  
		  	
		  	btnPayr1400Excel = new Button("엑셀");  
		  	btnPayr1400Excel.setIcon(MSFMainApp.ICONS.excel16()); 
		  	topPayr1400Bar.add(btnPayr1400Excel);  
			btnPayr1400Excel.addSelectionListener(new SelectionListener<ButtonEvent>() {
		  		public void componentSelected(ButtonEvent ce) {
		  		  bass5540GridPanel.callExportServlet(""); 
		  		}
		  	});
		  	
		  	plFrmPayr1400.add(topPayr1400Bar);  
		  	
			//파일업로드 처리 - 사업장 직인 정보 
		  	plFrmPayr1400.setAction("myurl");  //url 정보 추가 할것.
		  	plFrmPayr1400.setEncoding(Encoding.MULTIPART);
		  	plFrmPayr1400.setMethod(Method.POST);
		  	 
		  	
			vp.add(plFrmPayr1400);
			plFrmPayr1400.setSize("990px", "680px");
		  }
 /**
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * 폼 생성시 기본 처리 함수 선언부 종료
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
 **/

/**
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * 검색 함수 선언부 시작
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
 **/ 
	    
	  /**
	   * 검색필드 설정
	   */
	  private void createSearchForm() {
		  
		    sysComBass0300Dto = new PrgmComBass0300DTO(); 
		  
		  //--------------------공통 코드 불러 오는 함수 -------------------------------------------
			 sysComBass0300Dto.setRpsttvCd("B025");
			 sysComBass0300Dto.setMangeItem01("D");
			 lsPayDducGrpCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		 //--------------------공통 코드 불러 오는 함수 -------------------------------------------
			  
	    
	    LayoutContainer lcSchCol = new LayoutContainer();
	    lcSchCol.setLayout(new ColumnLayout()); 
	    
	    FieldSet fieldSet = new FieldSet();  
	    fieldSet.setHeadingHtml("검색조건");   
        /****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 시작
		 ****************************************************************/
		fieldSet.addStyleName("x-fieldset-serarch-back-color");
		/****************************************************************
		 * 검색조건 배경 변경 스타일시트 추가 끝
		 ****************************************************************/
	    
	    LayoutContainer lcSchLeft = new LayoutContainer();
	    lcSchLeft.setStyleAttribute("paddingRight", "200px");
	    FormLayout frmlytSchLeft = new FormLayout();  
	    frmlytSchLeft.setLabelWidth(85); 
	    frmlytSchLeft.setLabelAlign(LabelAlign.RIGHT);  
	    frmlytSchLeft.setDefaultWidth(100); 
	    lcSchLeft.setLayout(frmlytSchLeft);
	    
	    
	    /** column 급여공제그룹코드 : payDducGrpCd */
	    srhPayDducGrpCd = new ComboBox<BaseModel>(); 
	    srhPayDducGrpCd.setName("srhPayDducGrpCd");
	    srhPayDducGrpCd.setForceSelection(true);
	    srhPayDducGrpCd.setMinChars(1);
	    srhPayDducGrpCd.setDisplayField("commCdNm");
	    srhPayDducGrpCd.setValueField("commCd");
	    srhPayDducGrpCd.setTriggerAction(TriggerAction.ALL);
	    srhPayDducGrpCd.setEmptyText("--공제그룹선택--");
	    srhPayDducGrpCd.setSelectOnFocus(true); 
	    srhPayDducGrpCd.setReadOnly(false);
	    srhPayDducGrpCd.setEnabled(true); 
	    srhPayDducGrpCd.setStore(lsPayDducGrpCd); 
	    srhPayDducGrpCd.setFieldLabel("공제그룹");  
	     
	    lcSchLeft.add(srhPayDducGrpCd, new FormData("100%"));
	   
	    
	    LayoutContainer lcSchRight = new LayoutContainer();
	    lcSchRight.setStyleAttribute("paddingRight", "200px");
	    FormLayout frmlytSchRight = new FormLayout();  
	    frmlytSchRight.setLabelWidth(85); 
	    frmlytSchRight.setLabelAlign(LabelAlign.RIGHT);    
	    lcSchRight.setLayout(frmlytSchRight);
	  
	    srhPayDducNm = new TextField<String>();  
	    srhPayDducNm.setName("srhPayDducNm");
	    srhPayDducNm.setFieldLabel("공제명");  
	    lcSchRight.add(srhPayDducNm, new FormData("100%"));  
	   
	    lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5)); 
	    lcSchCol.add(lcSchRight,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5)); 
	    
	    fieldSet.add(lcSchCol, new FormData("100%"));  
		
	    plFrmPayr1400.add(fieldSet);  
	    
	  }     
/**
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * 검색 함수 선언부 종료
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
 **/   
  
/**
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * 기본등록화면 입력 시작
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
 **/  
   
  /**
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
   * 기본등록화면 입력 종료
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/   
  
  /**
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
   * 서브 입력 폼 시작 
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/ 
	 
  /**
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
   * 서브 입력 폼 종료
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/ 	  
  /**
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
   * 그리드 처리 함수 시작 
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/ 	 
	  private void createListGrid() { 
		   
		  
		    FieldSet fieldSet = new FieldSet();  
		    fieldSet.setHeadingHtml("공제정보");
		    
		    LayoutContainer lcStdGrid = new LayoutContainer();
		   // lcStdGrid.setStyleAttribute("paddingRight", "10px");
		    FormLayout frmlytStd = new FormLayout();  
		  //  frmlytStd.setLabelWidth(85); 
		   // frmlytStd.setLabelAlign(LabelAlign.RIGHT);   
		    lcStdGrid.setLayout(frmlytStd);  
		    
		    ContentPanel cpGrid = new ContentPanel();   
		    cpGrid.setBodyBorder(false); 
		    cpGrid.setHeaderVisible(false);   
		    cpGrid.setLayout(new FitLayout());      
		    cpGrid.setSize(950, 525);  
		    
		    //msfCustomForm.setHeaderVisible(false);
	        //Instantiate the GridPanel
		    bass5540GridPanel = new MSFGridPanel(bass5540Def, false, false, false, false,false);
		    bass5540GridPanel.setHeaderVisible(false);  
		    bass5540GridPanel.setBodyBorder(true);
		    bass5540GridPanel.setBorders(true);
	     //   msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.
	    
		    cpGrid.add(bass5540GridPanel); 
		   // cpGrid.add(grid);
		   // grid.setHeight("480px");
		    lcStdGrid.add(cpGrid);   
		    fieldSet.add(lcStdGrid);   
		      
		    plFrmPayr1400.add(fieldSet, new FormData("100%"));
		     
		  }
		    
  /**
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
   * 그리드 처리 함수 종료
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/ 	  
	public void reload() {
			// TODO Auto-generated method stub
		    
			IColumnFilter filters = null;
			bass5540GridPanel.getTableDef().setTableColumnFilters(filters);
			
			bass5540GridPanel.getTableDef().addColumnFilter("payDducGrpCd", MSFSharedUtils.getSelectedComboValue(srhPayDducGrpCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			bass5540GridPanel.getTableDef().addColumnFilter("payDducNm", MSFSharedUtils.defaultNulls(srhPayDducNm.getRawValue(),""), SimpleColumnFilter.OPERATOR_LIKE);
			bass5540GridPanel.reload();
		}
  
   public void setRecord(BaseModel record) {
       this.record = record;
   }
 
   
   public void setListRecord(List<Record> records) {
       this.records = records;
   }

   private Bass5540 getThis(){
       return this;
   }
   
   private void formPayr1400Init() {
	   
	     
		   actionDatabase = ActionDatabase.INSERT;
		   bass5540GridPanel.getMsfGrid().clearData();
   }
   
   /**
    * 신규로우를 생성한다.
    */
   public void formNewRows() {
       
       //TODO 그리드를 초기화 한후  ROW을 인서트 한다. 
        bass5540GridPanel.getMsfGrid().clearData();
      
       
        BaseModel bmData = bass5540GridPanel.getTableDef().getDefaultValues(); 
        
        bmData.set("dpobCd", MSFMainApp.get().getUser().getDpobCd());/** column 사업장코드 : dpobCd */
        bmData.set("payDducUseYn",true);/** column 공제사용 : payDducUseYn */  
        bmData.set("pymtDducDivCd", PayGenConst.PYMT_DDUC_DIV_CD_03); /** set 지급공제구분코드 : pymtDducDivCd */

//payr0470Dto.setDpobCd(MSFSharedUtils.allowNulls(record.get("dpobCd")));    /** column 사업장코드 : dpobCd */
//payr0470Dto.setPayDducCd(MSFSharedUtils.allowNulls(record.get("payDducCd")));    /** column 급여공제코드 : payDducCd */
//payr0470Dto.setPymtDducDivCd(MSFSharedUtils.allowNulls(record.get("pymtDducDivCd")));    /** column 지급공제구분코드 : pymtDducDivCd */
//payr0470Dto.setPayDducGrpCd(MSFSharedUtils.allowNulls(record.get("payDducGrpCd")));    /** column 급여공제그룹코드 : payDducGrpCd */
//payr0470Dto.setPayDducNm(MSFSharedUtils.allowNulls(record.get("payDducNm")));    /** column 급여공제명 : payDducNm */
//payr0470Dto.setPayDducUseYn(MSFSharedUtils.allowNulls(record.get("payDducUseYn")));    /** column 급여공제사용여부 : payDducUseYn */
//payr0470Dto.setPayDducSum(MSFSharedUtils.allowNulls(record.get("payDducSum")));    /** column 급여공제금액 : payDducSum */
//payr0470Dto.setPayDducRto(MSFSharedUtils.allowNulls(record.get("payDducRto")));    /** column 급여공제비율 : payDducRto */
//payr0470Dto.setYrtxDducDivCd(MSFSharedUtils.allowNulls(record.get("yrtxDducDivCd")));    /** column 연말정산_공제구분코드 : yrtxDducDivCd */
//payr0470Dto.setGrpApptnDivCd(MSFSharedUtils.allowNulls(record.get("grpApptnDivCd")));    /** column 그룹적용구분코드 : grpApptnDivCd */
//payr0470Dto.setPayDducBgnnDt(MSFSharedUtils.allowNulls(record.get("payDducBgnnDt")));    /** column 급여공제시작일자 : payDducBgnnDt */
//payr0470Dto.setPayDducEndDt(MSFSharedUtils.allowNulls(record.get("payDducEndDt")));    /** column 급여공제종료일자 : payDducEndDt */
//payr0470Dto.setKybdr(MSFSharedUtils.allowNulls(record.get("kybdr")));    /** column 입력자 : kybdr */
//payr0470Dto.setInptDt(MSFSharedUtils.allowNulls(record.get("inptDt")));    /** column 입력일자 : inptDt */
//payr0470Dto.setInptAddr(MSFSharedUtils.allowNulls(record.get("inptAddr")));    /** column 입력주소 : inptAddr */
//payr0470Dto.setIsmt(MSFSharedUtils.allowNulls(record.get("ismt")));    /** column 수정자 : ismt */
//payr0470Dto.setRevnDt(MSFSharedUtils.allowNulls(record.get("revnDt")));    /** column 수정일자 : revnDt */
//payr0470Dto.setRevnAddr(MSFSharedUtils.allowNulls(record.get("revnAddr")));    /** column 수정주소 : revnAddr */
        
        bass5540GridPanel.getMsfGrid().getGrid().stopEditing();      
        bass5540GridPanel.getMsfGrid().getGrid().getStore().insert(bmData,0);   
        bass5540GridPanel.getMsfGrid().getGrid().startEditing(bass5540GridPanel.getMsfGrid().getGrid().getStore().indexOf(bmData), 0);   
        bass5540GridPanel.setSize(935, 490);
        
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
		 * 
		 * <pre>
		 * 1. 개요 : 화면별 에러로그 확인 처리 를위해 추가 된 부분....
		 * 2. 처리내용 : 
		 * </pre>
		 * @Method Name : funcLogMessage
		 * @date : 2016. 9. 2.
		 * @author : Administrator
		 * @history : 
		 *	-----------------------------------------------------------------------
		 *	변경일				작성자						변경내용  
		 *	----------- ------------------- ---------------------------------------
		 *	2016. 9. 2.		Administrator				최초 작성 
		 *	-----------------------------------------------------------------------
		 * 
		 * @param wndName
		 * @param wndId
		 */
		public void funcLogMessage(String wndName, String wndId){
		
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
