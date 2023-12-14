package com.app.exterms.basis.client.form;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.basis.client.dto.Bass5530DTO;
import com.app.exterms.basis.client.form.defs.Bass5530Def;
import com.app.exterms.basis.client.languages.BasisConstants;
import com.app.exterms.basis.client.service.Bass5530Service;
import com.app.exterms.basis.client.service.Bass5530ServiceAsync;
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
import com.extjs.gxt.ui.client.event.BaseEvent;
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
import com.extjs.gxt.ui.client.widget.grid.Grid;
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
public class Bass5530  extends MSFPanel { 


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
	  private BasisConstants lblPayrConst = BasisConstants.INSTANCE;
	
	  private BaseModel bmData; //팝업에 넘길 레코드 값 
	  private VerticalPanel vp;
	  private FormPanel plFrmPayr1300;
	 // private FormData formData; 
	  private String txtForm = "";
	  private XTemplate detailTp; 
	  
	  private Bass5530Def payr0480Def  = new Bass5530Def();   //그리드 테이블 컬럼 define  
	//  private MSFCustomForm msfCustomForm; 
	  private MSFGridPanel payr0480GridPanel;
 

	   
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
      private ButtonBar topPayr1300Bar;
      private Button btnPayr1300New;
      private Button btnPayr1300Save;
      private Button btnPayr1300Del;
      private Button btnPayr1300Sreach;
      private Button btnPayr1300Excel;
      
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 검색변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
       
      private ComboBox<BaseModel> srhPayExtpyGrpCd;   //급여수당그룹코드
      private TextField<String> srhPayExtpyNm;  //급여수당명 
 
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 입력 변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */ 
      
	    private HiddenField<String> dpobCd;   /** column 사업장코드 : dpobCd */
		
//	    private TextField<String> payExtpyCd;   /** column 급여수당코드 : payExtpyCd */
//	
//	    private TextField<String> payExtpyGrpCd;   /** column 급여수당그룹코드 : payExtpyGrpCd */
//	
//	    private TextField<String> payExtpyNm;   /** column 급여수당명 : payExtpyNm */
//	
//	    private TextField<String> payExtpyPymtPrdDivCd;   /** column 급여수당지급시기구분코드 : payExtpyPymtPrdDivCd */
//	
//	    private TextField<String> payExtpyUseYn;   /** column 급여수당사용여부 : payExtpyUseYn */
//	
//	    private TextField<String> payRevnPsbyYn;   /** column 급여수정가능여부 : payRevnPsbyYn */
//	
//	    private TextField<String> accAccCd ;  /** column 회계계정코드 : accAccCd */

//      private TextField<String> sevePayYn;   /** column 퇴직적용여부 : sevePayYn */
 
//	    private TextField<String> yrtxFreeDtyReduCd;   /** column 연말정산_비과세감면코드 : yrtxFreeDtyReduCd */
	//
	//    private TextField<String> kybdr   /** column 입력자 : kybdr */
	//
	//    private TextField<String> inptDt   /** column 입력일자 : inptDt */
	//
	//    private TextField<String> inptAddr   /** column 입력주소 : inptAddr */
	//
	//    private TextField<String> ismt   /** column 수정자 : ismt */
	//
	//    private TextField<String> revnDt   /** column 수정일자 : revnDt */
	//
	//    private TextField<String> revnAddr   /** column 수정주소 : revnAddr */
	    
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
	    private Bass5530ServiceAsync payr1300Service = Bass5530Service.Util.getInstance();  
	   //공통 코드  
		private ListStore<BaseModel>  lsPayExtpyGrpCd = new ListStore<BaseModel>(); //급여수당그룹코드
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
		            if (ce.getButton() == btnPayr1300Save) {
		                
		            	if (ActionDatabase.INSERT.equals(actionDatabase)) { 
		            			doAction(ActionDatabase.INSERT);
		            	} else if (ActionDatabase.UPDATE.equals(actionDatabase) ){ 
		            	        doAction(ActionDatabase.UPDATE);
		            	}
		            } else if (ce.getButton() == btnPayr1300Del) {
		            	MessageBox.confirm("경고", "급여수당내역을 삭제하겠습니까?</br> (삭제된 데이터는 복구되지 않습니다.)",new Listener<MessageBoxEvent>(){
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
	            payr1300Delete();
	            break;
	        }
	    }
	    
	    
	    public void save() {
//	      if (isValid()) {
	        
	        
	        if (payr0480GridPanel.getMsfGrid().getGrid().getStore().getModifiedRecords().size() <= 0) {
	            
	            MessageBox.alert("수당", "저장할 수당데이타가 존재하지 않습니다.", null);
	            return;
	        }

	        MessageBox.confirm("저장", "데이터를 저장하시겠습니까?",new Listener<MessageBoxEvent>(){
                @Override
                public void handleEvent(MessageBoxEvent be) {
                   // if("Yes".equals(be.getButtonClicked().getText())){
                	if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
                        
                            Iterator<Record> iterRecords = payr0480GridPanel.getMsfGrid().getGrid().getStore().getModifiedRecords().iterator();
                           
                            List<Bass5530DTO> listPayr0480dto = new ArrayList<Bass5530DTO>();  
                	        
                            while (iterRecords.hasNext()) {
                          
                                Record record = (Record) iterRecords.next(); 
                                BaseModel bmMapModel = (BaseModel)record.getModel();
                                  
                                Bass5530DTO payr0480dto = new Bass5530DTO();  
                                  
                                payr0480dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
                                payr0480dto.setPayExtpyCd(MSFSharedUtils.allowNulls(bmMapModel.get("payExtpyCd")));    /** column 급여수당코드 : payExtpyCd */
                                payr0480dto.setPayExtpyGrpCd(MSFSharedUtils.allowNulls(bmMapModel.get("payExtpyGrpCd$commCd")));    /** column 급여수당그룹코드 : payExtpyGrpCd */ 
                                payr0480dto.setPayExtpyNm(MSFSharedUtils.allowNulls(bmMapModel.get("payExtpyNm")));    /** column 급여수당명 : payExtpyNm */
                                payr0480dto.setPayExtpyPymtPrdDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("payExtpyPymtPrdDivCd$commCd")));   /** column 급여수당지급시기구분코드 : payExtpyPymtPrdDivCd */
                                payr0480dto.setPayExtpyUseYn((Boolean)bmMapModel.get("payExtpyUseYn")) ;   /** column 급여수당사용여부 : payExtpyUseYn */
                                payr0480dto.setPayrTermUseYn((Boolean)bmMapModel.get("payrTermUseYn"));    /** column 기간제수당사용여부 : payrTermUseYn */
                                payr0480dto.setUsalyAmntYn((Boolean)bmMapModel.get("usalyAmntYn"));    /** column 통상임금여부 : usalyAmntYn */
                                payr0480dto.setPayRevnPsbyYn(false);    /** column 급여수정가능여부 : payRevnPsbyYn */
                                payr0480dto.setSevePayYn((Boolean)bmMapModel.get("sevePayYn"));   /** 퇴직정산여부 sevePayYn*/
                                payr0480dto.setAccAccCd(MSFSharedUtils.allowNulls(bmMapModel.get("accAccCd"))) ;   /** column 회계계정코드 : accAccCd */
                                payr0480dto.setYrtxFreeDtyReduCd(MSFSharedUtils.allowNulls(bmMapModel.get("yrtxFreeDtyReduCd")));    /** column 연말정산_비과세감면코드 : yrtxFreeDtyReduCd */
                                payr0480dto.setPymtDducDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("pymtDducDivCd$commCd")));    /** column 지급공제구분코드 : pymtDducDivCd */
                //                setKybdr(kybdr)    /** column 입력자 : kybdr */
                //                setInptDt(inptDt)    /** column 입력일자 : inptDt */
                //                setInptAddr(inptAddr)    /** column 입력주소 : inptAddr */
                //                setIsmt(ismt)    /** column 수정자 : ismt */
                //                setRevnDt(revnDt)    /** column 수정일자 : revnDt */
                //                setRevnAddr(revnAddr)    /** column 수정주소 : revnAddr */ 
                               
                                listPayr0480dto.add(payr0480dto);
                              
                            }   
                	          
                	        payr1300Service.activityOnBass5530Save(listPayr0480dto ,  
                                                new AsyncCallback<Long>() {
                            public void onFailure(Throwable caught) {
                                MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr1300Save(save) : " + caught), null);
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
//	      }
	  }
		 
	    
        public void payr1300Delete() {
//        if (isValid()) { 
            
            if(payr0480GridPanel.getGrid().getSelectionModel().getSelectedItems().size() > 0){
                MessageBox.confirm("삭제", "선택하신 수당을 삭제하시겠습니까?",new Listener<MessageBoxEvent>(){
                    @Override
                    public void handleEvent(MessageBoxEvent be) {
                       // if("Yes".equals(be.getButtonClicked().getText())){
                    	if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
                            
                            payr1300Service.activityOnBass5530Delete(payr0480GridPanel.getGrid().getSelectionModel().getSelectedItems() , new AsyncCallback<Long>() {
                                
                                @Override
                                public void onSuccess(Long result) {
                                 
                                    if (result == 0) {
                                        MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
                                                "삭제가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
                                    } else {
                                        MessageBox.alert("삭제완료", "선택하신 수당("+result+")이 삭제되었습니다.", null);
                                        reload();
                                    } 
                                   
                                }
                                
                                @Override
                                public void onFailure(Throwable caught) {
                                    MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                                            MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr1300Delete(delete) : " + caught), null);
                                    
                                }
                            });
                        }
                    }
                });
            } else {
                MessageBox.alert("수당선택", "삭제할 수당을 선택하십시요.", null);
            }
             
//        }
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
					    createPayr1300Form();  //화면 기본정보를 설정
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
		  public Bass5530() {
			   
				setSize("1010px", "700px");  
		  } 
		
		  public Bass5530(String txtForm) {
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
		  private void createPayr1300Form() {
			  
				plFrmPayr1300 = new FormPanel();
				plFrmPayr1300.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" -  ") + lblPayrConst.title_Bass5530());
				//plFrmPayr1300.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 수당관리");
				plFrmPayr1300.setIcon(MSFMainApp.ICONS.text());
				plFrmPayr1300.setBodyStyleName("pad-text");
				plFrmPayr1300.setPadding(2);
				plFrmPayr1300.setFrame(true);  
				
				/************************************************************************
				 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
				 ************************************************************************/
				final Button btnlogView = new Button("로그");   
				
				btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
				btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
					public void handleEvent(ButtonEvent e) {
						 //로그 뷰화면 호출 메서드 
						  funcLogMessage(lblPayrConst.title_Bass5530(),"PAYR1300");
						}
					});
				plFrmPayr1300.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
				plFrmPayr1300.getHeader().addTool(btnlogView); 
				/************************************************************************
				 * 화면 에러 처리시 필요한 부분으로 추가 
				 ************************************************************************/

				
			    plFrmPayr1300.setLayout(new FormLayout());
				
				 topPayr1300Bar = new ButtonBar();    
				 topPayr1300Bar.setAlignment(HorizontalAlignment.RIGHT);
 
			    btnPayr1300New = new Button("신규");  
			    btnPayr1300New.setIcon(MSFMainApp.ICONS.new16());
			  	topPayr1300Bar.add(btnPayr1300New);
			  	btnPayr1300New.addListener(Events.Select, new Listener<ButtonEvent>() {
		    		public void handleEvent(ButtonEvent e) {
		    		    formNewRows();
		    		}
		    	});
			  	 
			  	btnPayr1300Save = new Button("저장");  
			  	btnPayr1300Save.setIcon(MSFMainApp.ICONS.save16());
			  	topPayr1300Bar.add(btnPayr1300Save); 
			  	btnPayr1300Save.addSelectionListener(selectionListener);
			   
			  	btnPayr1300Del = new Button("삭제");  
			  	btnPayr1300Del.setIcon(MSFMainApp.ICONS.delete16());
			  	topPayr1300Bar.add(btnPayr1300Del);
			  	btnPayr1300Del.addSelectionListener(selectionListener);
			  	 
			  	btnPayr1300Sreach = new Button("조회"); 
			  	btnPayr1300Sreach.setIcon(MSFMainApp.ICONS.search16());
			  	topPayr1300Bar.add(btnPayr1300Sreach);
			  	btnPayr1300Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
		    		public void handleEvent(ButtonEvent e) {
		    			//조회버튼 클릭시 처리 
		    		    reload();  
		    		}
		    	});
			  	
			  	btnPayr1300Excel = new Button("엑셀"); 
			  	btnPayr1300Excel.setIcon(MSFMainApp.ICONS.excel16()); 
			  	topPayr1300Bar.add(btnPayr1300Excel);  
			  	btnPayr1300Excel.addListener(Events.Select, new Listener<ButtonEvent>() {
		    		public void handleEvent(ButtonEvent e) {
		    		   payr0480GridPanel.callExportServlet(""); 
		    		}
		    	});
			  	
			  	plFrmPayr1300.add(topPayr1300Bar);  
			  	
				//파일업로드 처리 - 사업장 직인 정보 
			  	plFrmPayr1300.setAction("myurl");  //url 정보 추가 할것.
			  	plFrmPayr1300.setEncoding(Encoding.MULTIPART);
			  	plFrmPayr1300.setMethod(Method.POST);
			  	 
			  	
				vp.add(plFrmPayr1300);
				plFrmPayr1300.setSize("990px", "680px");
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

		  private void createSearchForm() {
		    
			  sysComBass0300Dto = new PrgmComBass0300DTO(); 
			  
		  //--------------------공통 코드 불러 오는 함수 -------------------------------------------
			 sysComBass0300Dto.setRpsttvCd("B025");
			 sysComBass0300Dto.setMangeItem01("C");
			 lsPayExtpyGrpCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
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
		    
		    srhPayExtpyGrpCd = new ComboBox<BaseModel>(); 
		    srhPayExtpyGrpCd.setName("srhPayExtpyGrpCd");
		    srhPayExtpyGrpCd.setForceSelection(true);
		    srhPayExtpyGrpCd.setMinChars(1);
		    srhPayExtpyGrpCd.setDisplayField("commCdNm");
		    srhPayExtpyGrpCd.setValueField("commCd");
		    srhPayExtpyGrpCd.setTriggerAction(TriggerAction.ALL);
		    srhPayExtpyGrpCd.setEmptyText("--수당그룹선택--");
		    srhPayExtpyGrpCd.setAllowBlank(true);
		    srhPayExtpyGrpCd.setSelectOnFocus(true); 
		    srhPayExtpyGrpCd.setReadOnly(false);
		    srhPayExtpyGrpCd.setEnabled(true); 
		    srhPayExtpyGrpCd.setStore(lsPayExtpyGrpCd); 
		    srhPayExtpyGrpCd.setFieldLabel("수당그룹");  
		   
		    
		    lcSchLeft.add(srhPayExtpyGrpCd, new FormData("100%"));
		   
		    LayoutContainer lcSchRight = new LayoutContainer();
		    lcSchRight.setStyleAttribute("paddingRight", "200px");
		    FormLayout frmlytSchRight = new FormLayout();  
		    frmlytSchRight.setLabelWidth(85); 
		    frmlytSchRight.setLabelAlign(LabelAlign.RIGHT);    
		    lcSchRight.setLayout(frmlytSchRight);
		  
		    srhPayExtpyNm = new TextField<String>(); 
		    srhPayExtpyNm.setName("srhPayExtpyNm");
		    srhPayExtpyNm.setFieldLabel("수당명");  
		    lcSchRight.add(srhPayExtpyNm, new FormData("100%"));  
		   
		    lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5)); 
		    lcSchCol.add(lcSchRight,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5)); 
		    
		    fieldSet.add(lcSchCol, new FormData("100%"));  
			
		    plFrmPayr1300.add(fieldSet);  
		    
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
			    fieldSet.setHeadingHtml("수당정보");
			    
			    LayoutContainer lcStdGrid = new LayoutContainer();
			  //  lcStdGrid.setStyleAttribute("paddingRight", "10px");
			    FormLayout frmlytStd = new FormLayout();  
			  //  frmlytStd.setLabelWidth(85); 
			   // frmlytStd.setLabelAlign(LabelAlign.RIGHT);   
			    lcStdGrid.setLayout(frmlytStd);  
			    
			    ContentPanel cpGrid  = new ContentPanel();   
			    cpGrid.setBodyBorder(false); 
			    cpGrid.setHeaderVisible(false);   
			    cpGrid.setLayout(new FitLayout());      
			    cpGrid.setSize(950, 525);  
			    
			  //  msfCustomForm = new MSFCustomForm(payr0480Def, 600, 150, false, true, false);
			 //   msfCustomForm.setHeaderVisible(false);
			    
		        //Instantiate the GridPanel
			    
//			    MSFCustomForm msfCustomForm = new MSFCustomForm(payr0480Def, 0, 0, false, false, false);
//			    msfCustomForm.setHeaderVisible(false);
			    
			    payr0480GridPanel = new MSFGridPanel(payr0480Def, false, false, false, false,false);
			    payr0480GridPanel.setHeaderVisible(false);  
			    payr0480GridPanel.setBodyBorder(true);
			    payr0480GridPanel.setBorders(true); 
			   
//			    payr0480GridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.
			    
  			    final Grid payr0480Grid = payr0480GridPanel.getMsfGrid().getGrid();
			    payr0480Grid.addListener(Events.RowClick, new Listener<BaseEvent>() {
		            public void handleEvent(BaseEvent be) {  
		             if (payr0480GridPanel.getCurrentlySelectedItem() != null) {      
		            	 
		            	 payr0480GridPanel.setGridRowFormBind(payr0480GridPanel.getCurrentlySelectedItem());
		            	 setRecord(payr0480GridPanel.getCurrentlySelectedItem());		          	   	
		              } 
		            }
		        }); 
			    
			    cpGrid.add(payr0480GridPanel); 
			   
		 
			   // cpGrid.add(grid);
			   // grid.setHeight("480px");
			    lcStdGrid.add(cpGrid);   
			    fieldSet.add(lcStdGrid);   
			      
			    plFrmPayr1300.add(fieldSet, new FormData("100%"));
			     
			  }
			    
  /**
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
   * 그리드 처리 함수 종료
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/ 	
		  
			public void reload() {
				// TODO Auto-generated method stub
			    
				IColumnFilter filters = null;
				payr0480GridPanel.getTableDef().setTableColumnFilters(filters);
			 
				payr0480GridPanel.getTableDef().addColumnFilter("payExtpyGrpCd", MSFSharedUtils.getSelectedComboValue(srhPayExtpyGrpCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
				payr0480GridPanel.getTableDef().addColumnFilter("payExtpyNm", MSFSharedUtils.allowNulls(srhPayExtpyNm.getRawValue()), SimpleColumnFilter.OPERATOR_LIKE);
				payr0480GridPanel.reload();
			}
	  
	   public void setRecord(BaseModel record) {
	       this.record = record;
	   }
	   
		public void setPPRecord(BaseModel bmData) {
			this.bmData = bmData;
		}
	 
	   
       public void setListRecord(List<Record> records) {
           this.records = records;
       }

	   private Bass5530 getThis(){
	       return this;
	   }
	   
	   private void formPayr1300Init() {
		    
			   actionDatabase = ActionDatabase.UPDATE;
			   payr0480GridPanel.getMsfGrid().clearData();
			   
	   }
	   
	   /**
        * 신규로우를 생성한다.
        */
       public void formNewRows() {
           
           //TODO 그리드를 초기화 한후  ROW을 인서트 한다. 
            payr0480GridPanel.getMsfGrid().clearData();
           
            BaseModel bmData = payr0480GridPanel.getTableDef().getDefaultValues();
             
            bmData.set("dpobCd", MSFMainApp.get().getUser().getDpobCd());/** column 사업장코드 : dpobCd */
            bmData.set("payExtpyUseYn",true);/** column 수당사용 : payExtpyUseYn */  
            bmData.set("pymtDducDivCd", PayGenConst.PYMT_DDUC_DIV_CD_02); /** set 지급공제구분코드 : pymtDducDivCd */
            bmData.set("sevePayYn",false);   /** column 퇴직적용여부 : sevePayYn */
            

//            upDlgn0200Vo.setDpobCd(dlgn0200Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//            upDlgn0200Vo.setPayExtpyCd(dlgn0200Vo.getPayExtpyCd());    /** column 급여수당코드 : payExtpyCd */
//            upDlgn0200Vo.setPymtDducDivCd(dlgn0200Vo.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */
//            upDlgn0200Vo.setPayExtpyGrpCd(dlgn0200Vo.getPayExtpyGrpCd());    /** column 급여수당그룹코드 : payExtpyGrpCd */
//            upDlgn0200Vo.setPayExtpyNm(dlgn0200Vo.getPayExtpyNm());    /** column 급여수당명 : payExtpyNm */
//            upDlgn0200Vo.setPayExtpyPymtPrdDivCd(dlgn0200Vo.getPayExtpyPymtPrdDivCd());    /** column 급여수당지급시기구분코드 : payExtpyPymtPrdDivCd */
//            upDlgn0200Vo.setPayExtpyUseYn(dlgn0200Vo.getPayExtpyUseYn());    /** column 급여수당사용여부 : payExtpyUseYn */
//            upDlgn0200Vo.setPayRevnPsbyYn(dlgn0200Vo.getPayRevnPsbyYn());    /** column 급여수정가능여부 : payRevnPsbyYn */
//            upDlgn0200Vo.setAccAccCd(dlgn0200Vo.getAccAccCd());    /** column 회계계정코드 : accAccCd */
//            upDlgn0200Vo.setSevePayYn(dlgn0200Vo.getSevePayYn());    /** column 퇴직적용여부 : sevePayYn */
//            upDlgn0200Vo.setYrtxFreeDtyReduCd(dlgn0200Vo.getYrtxFreeDtyReduCd());    /** column 연말정산_비과세감면코드 : yrtxFreeDtyReduCd */ 
            
            payr0480GridPanel.getMsfGrid().getGrid().stopEditing();      
            payr0480GridPanel.getMsfGrid().getGrid().getStore().insert(bmData,0);   
            payr0480GridPanel.getMsfGrid().getGrid().startEditing(payr0480GridPanel.getMsfGrid().getGrid().getStore().indexOf(bmData), 0);   
            payr0480GridPanel.setSize(935, 490); 
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
