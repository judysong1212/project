package com.app.exterms.payroll.client.form;

import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0400DTO;
import com.app.exterms.payroll.client.form.defs.Payr0400Def;
import com.app.exterms.payroll.client.form.defs.Payr0430Def;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.client.service.Payr1200Service;
import com.app.exterms.payroll.client.service.Payr1200ServiceAsync;
import com.app.exterms.payroll.client.utils.PayrUtils;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.def.RelationDef;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
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
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr1200  extends MSFPanel { 

	 
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
	
	private PayrConstants lblPayrConst = PayrConstants.INSTANCE;
	
	 
	private VerticalPanel vp;
	private FormPanel plFrmPayr1200;
	// private FormData formData;
	private String txtForm = "";
	private XTemplate detailTp;
	  
	private Payr0400Def payr0400Def  = new Payr0400Def();   //그리드 테이블 컬럼 define  
	      // private MSFCustomForm msfCustomForm; 
	private MSFGridPanel payr0400GridPanel;
	    
	private Payr0430Def payr0430Def  = new Payr0430Def();   //그리드 테이블 컬럼 define  
	      // private MSFCustomForm msfCustomForm; 
	private MSFGridPanel payr0430GridPanel;
	  
	  
	   
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
		private ButtonBar topPayr1200Bar;
		private Button btnPayr1200New;
		private Button btnPayr1200Save;
		private Button btnPayr1200Del;
		private Button btnPayr1200Sreach;
	
	
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * 검색변수 선언 
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */
		private ComboBox<BaseModel> srhTypOccuCd; 				// 직종
		// private ComboBox<BaseModel> srhPyspGrdeCd; //호봉등급
		private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd; // 직종세
	
		private List<ModelData> mDtalistDtilOccuInttnCd;
		private boolean mutilCombo = false;
      
	
	/**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 입력 변수 선언 
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */ 
      
		private HiddenField<String> dpobCd;					/** column 사업장코드 : dpobCd */ 
		private HiddenField<Long> typOccuGrdeMppgSeilNum;   /** column 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */ 
		private HiddenField<Boolean> typOccuGrdeMppgDelYn; 	/** column 직종_등급맵핑삭제여부 : typOccuGrdeMppgDelYn */
    
		private ComboBox<BaseModel> typOccuCd;			/** column 직종코드 : typOccuCd */
		private ComboBox<BaseModel> dtilOccuInttnCd;	/** column 직종세코드 : dtilOccuInttnCd */
		
		private ComboBox<BaseModel> bggLogSvcYrNumCd;			/** column 직종코드 : typOccuCd */
		
		private TextArea  typOccuGrdeMppgCtnt;  		/** column 직종_등급맵핑내용 : typOccuGrdeMppgCtnt */

   // private ComboBox<BaseModel> pyspGrdeCd;  /** column 호봉등급코드 : pyspGrdeCd */

   
      /** 430 */
//    private TextField<String> dpobCd   /** column 사업장코드 : dpobCd */
//    private TextField<String> typOccuCd   /** column 직종코드 : typOccuCd */
//    private TextField<String> pyspGrdeCd   /** column 호봉등급코드 : pyspGrdeCd */
//    private TextField<String> pyspLogSvcYrNumCd   /** column 호봉근속년수코드 : pyspLogSvcYrNumCd */
//    private TextField<String> dtilOccuInttnCd   /** column 직종세코드 : dtilOccuInttnCd */
//    private TextField<String> logSvcYrNumOvr   /** column 근속년수_이상 : logSvcYrNumOvr */
//    private TextField<String> logSvcYrNumUdr   /** column 근속년수_미만 : logSvcYrNumUdr */
//    private TextField<String> kybdr   /** column 입력자 : kybdr */
//    private TextField<String> inptDt   /** column 입력일자 : inptDt */
//    private TextField<String> inptAddr   /** column 입력주소 : inptAddr */
//    private TextField<String> ismt   /** column 수정자 : ismt */
//    private TextField<String> revnDt   /** column 수정일자 : revnDt */
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
 * 	전역함수 선언부 종료
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/	
	  
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	Rpc Service 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
    
	private Payr1200ServiceAsync payr1200Service = Payr1200Service.Util.getInstance();  
      
	private ListStore<BaseModel>  LsTypOccuCd01 = new ListStore<BaseModel>();//직종 
	private ListStore<BaseModel>  LsTypOccuCd02 = new ListStore<BaseModel>();//직종 
      
	
	
    //  private ListStore<BaseModel>  LsPyspGrdeCd01 = new ListStore<BaseModel>();//호봉등급
    //  private ListStore<BaseModel>  LsPyspGrdeCd02 = new ListStore<BaseModel>();//호봉등급
	
	private ListStore<BaseModel>  bggLogSvcYrNumCd01 = new ListStore<BaseModel>();
	
      
	private ListStore<BaseModel>  LsDtilOccuInttnCd01 = new ListStore<BaseModel>();//직종세
	private ListStore<BaseModel>  LsDtilOccuInttnCd02 = new ListStore<BaseModel>();//직종세
      
      
	private PrgmComBass0320DTO sysComBass0320Dto; //공통코드 dto
	private PrgmComBass0350DTO sysComBass0350Dto;  //직종세
	private PrgmComBass0300DTO sysComBass0300Dto;  //근속년수
      
	private BaseModel record;
	private List<BaseModel> records;
      
	/**
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * 선택된 버튼에 따른 인서트 업데이트 삭제 처리 부
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 */  
	private SelectionListener<ButtonEvent> selectionListener = new SelectionListener<ButtonEvent>() {
		public void componentSelected(ButtonEvent ce) {
			if (ce.getButton() == btnPayr1200Save) {
				if (ActionDatabase.INSERT.equals(actionDatabase)) {
					doAction(ActionDatabase.INSERT);
				} else if (ActionDatabase.UPDATE.equals(actionDatabase)) {
					doAction(ActionDatabase.UPDATE);
				}
			} else if (ce.getButton() == btnPayr1200Del) {
				doAction(ActionDatabase.DELETE);
			}

		}
	};

	private void doAction(ActionDatabase actionDatabase) {
		switch (actionDatabase) {
		case INSERT:
			doInsert();
			break;
		case UPDATE:
			save();
			break;
		case DELETE:
			actionDatabase = ActionDatabase.DELETE;
			save();
			break;
		}
	}
      
     
	public void doInsert() {
		
		
		
		
		
		
		payr1200Service.activityOnPayr0400Insert(records, actionDatabase, new AsyncCallback<Long>() {
			public void onFailure(Throwable caught) {
				MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),
						MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr0400Insert("+ actionDatabase.name()+ ") : " + caught), null);
			}
			public void onSuccess(Long result) {
				if (result == 0) {
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
				} else {
					MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), actionDatabase + "처리가 완료되었습니다.", null);
					reload();
				}
			}
		});
	} 
      
	public void save() {
//      if (isValid()) {
		if (typOccuGrdeMppgSeilNum.getValue() <= 0 ) {
			MessageBox.alert("직종세등급맵핑", "직종세등급맵핑을 위한 데이타가 존재하지 않습니다.", null);
			return;
		}
          
		Payr0400DTO payr0400Dto = new Payr0400DTO();  
          
        payr0400Dto.setDpobCd(MSFSharedUtils.allowNulls(dpobCd.getValue()));
        payr0400Dto.setTypOccuGrdeMppgSeilNum(typOccuGrdeMppgSeilNum.getValue());
        payr0400Dto.setTypOccuCd(MSFSharedUtils.allowNulls(typOccuCd.getValue().get("commCd"))) ;
        payr0400Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(dtilOccuInttnCd.getValue().get("dtilOccuInttnCd"))) ;
         // payr0400Dto.setPyspGrdeCd(MSFSharedUtils.allowNulls(pyspGrdeCd.getValue().get("commCd"))); 
          
        payr0400Dto.setTypOccuGrdeMppgCtnt(MSFSharedUtils.allowNulls(typOccuGrdeMppgCtnt.getValue())); 
        if (ActionDatabase.DELETE.equals(actionDatabase)) {
        	payr0400Dto.setTypOccuGrdeMppgDelYn("Y"); 
        } else {
        	payr0400Dto.setTypOccuGrdeMppgDelYn("N"); 
        }
        
        payr1200Service.activityOnPayr0400Save(payr0400Dto, actionDatabase, new AsyncCallback<Long>() {
        	public void onFailure(Throwable caught) {
                  MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                          MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr0400Save(" + actionDatabase.name() + ") : " + caught), null);
        	}
        	public void onSuccess(Long result) { 
        		if (result == 0) {
        			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
                             actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
        		} else {
        			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(),  actionDatabase + "처리가 완료되었습니다.", null);
        			reload();
        		} 
        	} 
        });
     // }
	}     
      
	/**
	 * 직종-직종세 근속년수 맵핑을 위한 함수 호출 
	 */
	public void createPyspLogSvcYrMumCd() {
//       if (isValid()) { 
		if (MSFSharedUtils.paramNull(MSFSharedUtils.allowNulls(record.get("pyspGrdeCd")))) {
			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "근속년수와 맵핑할 직종세를 선택하십시요.", null);
			return;
		}
            
		MessageBox.confirm("근속년수생성", "근속년수을 생성하시면 기존 생성된 근속년수 데이타를 삭제 후 다시 생성합니다.\n 근속년수를 생성하시겠습니까?",new Listener<MessageBoxEvent>(){
			@Override
			public void handleEvent(MessageBoxEvent be) {
				//if("Yes".equals(be.getButtonClicked().getText())){
				if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
                      
					Payr0400DTO payr0400Dto = new Payr0400DTO(); 
                         
                    payr0400Dto.setDpobCd(MSFSharedUtils.allowNulls(record.get("dpobCd")));
                    payr0400Dto.setTypOccuGrdeMppgSeilNum((Long)record.get("typOccuGrdeMppgSeilNum"));
                    payr0400Dto.setTypOccuCd(MSFSharedUtils.allowNulls(record.get("typOccuCd"))) ;
                    payr0400Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(record.get("dtilOccuInttnCd"))) ;
                        // payr0400Dto.setPyspGrdeCd(MSFSharedUtils.allowNulls(record.get("pyspGrdeCd"))); 
                           
                    
                    
                    
                    payr0400Dto.setCommCd(MSFSharedUtils.allowNulls(record.get("bggLogSvcYrNumCd")));
                    
                    payr1200Service.createPyspLogSvcYrNumCd(payr0400Dto ,  new AsyncCallback<Long>() {
                    	public void onFailure(Throwable caught) {
                    		MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                    				MSFMainApp.ADMINMESSAGES.ExceptionMessageService("createPyspLogSvcYrMumCd() : " + caught), null);
                    	}
                    	public void onSuccess(Long result) { 
                    		if (result == 0) {
                    			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
                    					"직종세 -> 근속년수 맵핑 처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
                    		} else {
                    			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
                    					"직종세 -> 근속년수 맵핑  처리가 완료되었습니다.", null);
                    			payr0430GridPanel.reload();
                    		} 
                    	} 
                    });
				}
			}
		});    
        // }
	}    
      
        
	private void deletePayr0430() {
            
		if(payr0430GridPanel.getGrid().getSelectionModel().getSelectedItems().size() > 0){
			MessageBox.confirm("삭제", "선택하신 근속년수를 삭제하시겠습니까?",new Listener<MessageBoxEvent>(){
				@Override
				public void handleEvent(MessageBoxEvent be) {
					//if("Yes".equals(be.getButtonClicked().getText())){
					if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
                            
						payr1200Service.deletePayr0430(payr0430GridPanel.getGrid().getSelectionModel().getSelectedItems(), new AsyncCallback<Long>() {
                                
							@Override
							public void onSuccess(Long result) {
								MessageBox.alert("삭제완료", "선택하신 근속년수("+result+")가 삭제되었습니다.", null);
								payr0430GridPanel.reload();
							}
                                
							@Override
							public void onFailure(Throwable caught) {
								MessageBox.alert("삭제실패", "선택하신 근속년수을 삭제하지 못했습니다.데이타를 확인 하십시요.", null);
							}
						});
					}
				}
			});
		} else {
			MessageBox.alert("근속년수선택", "삭제할 근속년수를 선택하십시요.", null);
		}
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

	  
//	  @Override
//	  protected void onRender(Element parent, int index) {
//	    super.onRender(parent, index);
//	    
//	    detailTp = XTemplate.create(getDetailTemplate());
//	    
//	   // formData = new FormData("-650");
//	    vp = new VerticalPanel();
//	    vp.setSpacing(10);
//	    createPayr1200Form();  //화면 기본정보를 설정
//	    createSearchForm();    //검색필드를 적용
//	    createStandardForm();    //기본정보필드  
//	    add(vp);
//	    vp.setSize("1010px", "700px");
//	  }
	public ContentPanel getViewPanel(){
		
		if(panel == null){

			detailTp = XTemplate.create(getDetailTemplate());
			    
			// formData = new FormData("-650");
			vp = new VerticalPanel();
			vp.setSpacing(10);
			createPayr1200Form(); // 화면 기본정보를 설정
			createSearchForm(); // 검색필드를 적용
			createStandardForm(); // 기본정보필드
			vp.setSize("1010px", "700px");
				    
			/**
	          * Create the relations 
	          */
			final RelationDef  relPayr0400 = new RelationDef(payr0400Def,false);
			relPayr0400.addJoinDef("dpobCd", "dpobCd");
	        relPayr0400.addJoinDef("typOccuGrdeMppgSeilNum", "typOccuGrdeMppgSeilNum"); 
	        relPayr0400.setLinkedObject(payr0400GridPanel);
	        payr0430Def.addRelation(relPayr0400);  
	 
	        // DETAILS 
	        final Grid payr0400Grid = payr0400GridPanel.getMsfGrid().getGrid();
	        payr0400Grid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {
	        	public void handleEvent(BaseEvent be) {  
	        		if (payr0400GridPanel.getCurrentlySelectedItem() != null) { 
	            		 
	        			//선택된 값을 가지고 있는 레코드 
	        			setRecord(payr0400GridPanel.getCurrentlySelectedItem());
	            	      
	        			payr0430Def.synchronizeGridDetail(payr0400GridPanel.getCurrentlySelectedItem(),payr0430GridPanel ); 
	        			
	        			setFormData();
		        		//payr0430GridPanel.reload(); 
		        		
	        		}
	        	
	        	}
	        });
			           
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
	public Payr1200() {
		setSize("1010px", "700px");
	}

	public Payr1200(String txtForm) {
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
	private void createPayr1200Form() {
		  
		plFrmPayr1200 = new FormPanel();
		plFrmPayr1200.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" -  ")+ lblPayrConst.title_Payr1200());
		// plFrmPayr1200.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 직종-등급관리");
		plFrmPayr1200.setIcon(MSFMainApp.ICONS.text());
		plFrmPayr1200.setBodyStyleName("pad-text");
		plFrmPayr1200.setPadding(2);
		plFrmPayr1200.setFrame(true);
		 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage(lblPayrConst.title_Payr1200(),"PAYR1200");
				}
			});
		plFrmPayr1200.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmPayr1200.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/

		//멀티콤보박스 닫기 
		plFrmPayr1200.addListener(Events.OnClick,new Listener<ComponentEvent>() { 
			@Override
			public void handleEvent(ComponentEvent ce) { 
        		if (mutilCombo) {
        			if ( srhDtilOccuInttnCd.getCheckBoxListHolder().isVisible() ) {
        				//직종세
        				srhDtilOccuInttnCd.showClose(ce);
        				mutilCombo = false;
        			}  
        		}
			} 
		}); 

		ButtonBar topPayr1200Bar = new ButtonBar();
		topPayr1200Bar.setAlignment(HorizontalAlignment.RIGHT);

		btnPayr1200New = new Button("신규");
		btnPayr1200New.setIcon(MSFMainApp.ICONS.new16());
		topPayr1200Bar.add(btnPayr1200New);
		btnPayr1200New.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				
				
				//payr0400GridPanel.getMsfGrid().getGrid().getStore().getModels().size();
				
				formNew(); // 직종/직종세 팝업만들기
			}
		});
           
	  
	  	btnPayr1200Sreach = new Button("조회"); 
	  	btnPayr1200Sreach.setIcon(MSFMainApp.ICONS.search16());
	  	topPayr1200Bar.add(btnPayr1200Sreach);
	  	btnPayr1200Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			//조회버튼 클릭시 처리 
    		    reload();  
    		}
    	});
 
		plFrmPayr1200.add(topPayr1200Bar);

		vp.add(plFrmPayr1200);
		plFrmPayr1200.setSize("990px", "680px");
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
	  
		sysComBass0320Dto = new PrgmComBass0320DTO();
		sysComBass0350Dto = new PrgmComBass0350DTO();
		sysComBass0300Dto = new PrgmComBass0300DTO();
		
		
		//--------------------직종 불러 오는 함수 -------------------------------------------
		LsTypOccuCd01 = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData( sysComBass0320Dto);
		LsTypOccuCd02 = LsTypOccuCd01; 
		//--------------------직종 불러 오는 함수 -------------------------------------------
			
		 
		 //--------------------공통 코드 불러 오는 함수 -------------------------------------------
		 sysComBass0300Dto.setRpsttvCd("A007");
		 bggLogSvcYrNumCd01 = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
		
	   //--------------------공통 코드 불러 오는 함수 -------------------------------------------
			 
			 
		plFrmPayr1200.setLayout(new FlowLayout());

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
		// fieldSet.setCheckboxToggle(false);
	    
		LayoutContainer lcSchLeft = new LayoutContainer();
		lcSchLeft.setStyleAttribute("paddingRight", "10px");
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(85);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		frmlytSch.setDefaultWidth(100);
		// fieldSet.setLayout(layout);
		lcSchLeft.setLayout(frmlytSch);
	    
		/** column 직종 : typOccuCd */
		srhTypOccuCd = new ComboBox<BaseModel>();
		srhTypOccuCd.setName("srhTypOccuCd");
		srhTypOccuCd.setForceSelection(true);
		srhTypOccuCd.setMinChars(1);
		srhTypOccuCd.setDisplayField("typOccuNm");
		srhTypOccuCd.setValueField("typOccuCd");
		srhTypOccuCd.setTriggerAction(TriggerAction.ALL);
		srhTypOccuCd.setEmptyText("--직종선택--");
		srhTypOccuCd.setSelectOnFocus(true);
		srhTypOccuCd.setReadOnly(false);
		srhTypOccuCd.setEnabled(true);
		srhTypOccuCd.setStore(LsTypOccuCd01);
		srhTypOccuCd.setFieldLabel("직 종");
	    srhTypOccuCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
                //직종변경에 따른 직종세 값 가져오기
                String strTypOccuCd =  MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd") ;
                
                if (MSFSharedUtils.paramNotNull(strTypOccuCd)) {
                	
                    sysComBass0350Dto.setTypOccuCd(strTypOccuCd);
                    
                   //sysComBass0350Dto.setPyspGrdeCd(MSFSharedUtils.getSelectedComboValue(srhPyspGrdeCd,"commCd"));
//                    if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getPyspGrdeCd())) {
                    	
                    	
//                        LsDtilOccuInttnCd01 = PrgmComComboUtils.getSingleBass0350ComboData(sysComBass0350Dto);
                    	//직종세 초기화
                    	srhDtilOccuInttnCd.getInitStore(); 
                    	srhDtilOccuInttnCd.setValue("");
                        LsDtilOccuInttnCd01 = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto);
                        
                        LsDtilOccuInttnCd01.addStoreListener( new StoreListener<BaseModel>() {   
                            public void handleEvent(StoreEvent<BaseModel> be) {  
                                mDtalistDtilOccuInttnCd = PayrUtils.getDtilOccuInttnCdModelData(LsDtilOccuInttnCd01) ; 
                                srhDtilOccuInttnCd.getInitStore().add(mDtalistDtilOccuInttnCd); 
                            }
                        });    
//                    }
                }    
            } 
        });
	    
		lcSchLeft.add(srhTypOccuCd, new FormData("100%"));
	   
	    
//	    LayoutContainer lcSchCenter = new LayoutContainer();
//	    lcSchCenter.setStyleAttribute("paddingRight", "10px");
//	    frmlytSch = new FormLayout();  
//	    frmlytSch.setLabelWidth(85); 
//	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
//	    frmlytSch.setDefaultWidth(100);
//	   // fieldSet.setLayout(layout);  
//	    lcSchCenter.setLayout(frmlytSch);
//	    
//	    /** column 호봉등급코드 : pyspGrdeCd */
//	    srhPyspGrdeCd = new ComboBox<BaseModel>(); 
//	    srhPyspGrdeCd.setName("srhPyspGrdeCd");
//	    srhPyspGrdeCd.setForceSelection(true);
//	    srhPyspGrdeCd.setMinChars(1);
//	    srhPyspGrdeCd.setDisplayField("commCdNm");
//	    srhPyspGrdeCd.setValueField("commCd");
//	    srhPyspGrdeCd.setTriggerAction(TriggerAction.ALL);
//	    srhPyspGrdeCd.setEmptyText("--호봉등급선택--");
//	    srhPyspGrdeCd.setSelectOnFocus(true); 
//	    srhPyspGrdeCd.setReadOnly(false);
//	    srhPyspGrdeCd.setEnabled(true); 
//	    srhPyspGrdeCd.setStore(LsPyspGrdeCd01); 
//	    srhPyspGrdeCd.setFieldLabel("호봉등급");  
//	    srhPyspGrdeCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
//            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
//                //직종변경에 따른 직종세 값 가져오기
//                String strTypOccuCd =  MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"commCd") ;
//                sysComBass0350Dto.setTypOccuCd(strTypOccuCd);
//                sysComBass0350Dto.setPyspGrdeCd(MSFSharedUtils.getSelectedComboValue(srhPyspGrdeCd,"commCd"));
//                if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
//                    LsDtilOccuInttnCd01 = PrgmComComboUtils.getSingleBass0350ComboData(sysComBass0350Dto);
//                    srhDtilOccuInttnCd.setStore(LsDtilOccuInttnCd01); 
//                }
//            } 
//        });
//	    lcSchCenter.add(srhPyspGrdeCd, new FormData("100%")); 
	    
		LayoutContainer lcSchRight = new LayoutContainer();
		lcSchRight.setStyleAttribute("paddingRight", "10px");
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(85);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		frmlytSch.setDefaultWidth(100);
		// fieldSet.setLayout(layout);
		lcSchRight.setLayout(frmlytSch);
	    
	    /** column 직종세코드 : dtilOccuInttnCd */
//	    srhDtilOccuInttnCd = new ComboBox<BaseModel>(); 
//	    srhDtilOccuInttnCd.setName("srhDtilOccuInttnCd");
//	    srhDtilOccuInttnCd.setForceSelection(true);
//	    srhDtilOccuInttnCd.setMinChars(1);
//	    srhDtilOccuInttnCd.setDisplayField("dtilOccuClsNm");
//	    srhDtilOccuInttnCd.setValueField("dtilOccuInttnCd");
//	    srhDtilOccuInttnCd.setTriggerAction(TriggerAction.ALL);
//	    srhDtilOccuInttnCd.setEmptyText("--직종세선택--");
//	    srhDtilOccuInttnCd.setSelectOnFocus(true); 
//	    srhDtilOccuInttnCd.setReadOnly(false);
//	    srhDtilOccuInttnCd.setEnabled(true);  
//	    srhDtilOccuInttnCd.setStore(LsDtilOccuInttnCd01); 
//	    srhDtilOccuInttnCd.setFieldLabel("직종세");
	   
		srhDtilOccuInttnCd = new MSFMultiComboBox<ModelData>();
		srhDtilOccuInttnCd.setName("srhDtilOccuInttnCd");
		srhDtilOccuInttnCd.setEmptyText("--직종세선택--");
		srhDtilOccuInttnCd.getListView().setDisplayProperty("dtilOccuClsNm");
		srhDtilOccuInttnCd.getStore().add(mDtalistDtilOccuInttnCd);
		srhDtilOccuInttnCd.setWidth(100);
		srhDtilOccuInttnCd.setFieldLabel("직종세");
		srhDtilOccuInttnCd.setReadOnly(false);
		srhDtilOccuInttnCd.setEnabled(true);
       // srhDtilOccuInttnCd.setReadOnly(gwtExtAuth.getReadOnlyDtilOccuInttnCd());
       // srhDtilOccuInttnCd.setEnabled(gwtExtAuth.getEnableDtilOccuInttnCd());
        srhDtilOccuInttnCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
            @Override
            public void handleEvent(ComponentEvent ce) {    
               
                if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) { 
                    mutilCombo = true;
                } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
                    mutilCombo = true;
                  //  GWT.log(" b" + ce.getEvent().getType());
                } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
                    mutilCombo = false;
                  //  GWT.log(" b" + ce.getEvent().getType());
                } else {
                   
                }  
            
            } 
        });
	    lcSchRight.add(srhDtilOccuInttnCd, new FormData("100%")); 
	    
	    lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
	   // lcSchCol.add(lcSchCenter,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
	    lcSchCol.add(lcSchRight,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34)); 
	    fieldSet.add(lcSchCol, new FormData("100%"));  
		
		plFrmPayr1200.add(fieldSet);
		//vp.add(panel);   
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
	private void createStandardForm() {
		  
		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		layoutContainer_1.setLayout(new FormLayout());

		FieldSet fldstNewFieldset = new FieldSet();
		fldstNewFieldset.setSize("380px", "550px");
		layoutContainer_1.add(fldstNewFieldset);
		fldstNewFieldset.setHeadingHtml("직종정보");
		fldstNewFieldset.setCollapsible(false);
		layoutContainer.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		layoutContainer_1.setBorders(false);

		fldstNewFieldset.add(occupationalLeft(), new FormData("100%"));

		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new FormLayout());

		FieldSet fldstNewFieldset_1 = new FieldSet();
		fldstNewFieldset_1.setSize(578, 140);
		layoutContainer_2.add(fldstNewFieldset_1);
		fldstNewFieldset_1.setHeadingHtml("직종-등급상세");
		fldstNewFieldset_1.setCollapsible(false);
			
		fldstNewFieldset_1.add(occupationalRTop(), new FormData("100%"));

		FieldSet fldstNewFieldset_2 = new FieldSet();
		fldstNewFieldset_2.setSize(578, 390);
		layoutContainer_2.add(fldstNewFieldset_2);
		fldstNewFieldset_2.setHeadingHtml("직종별근속년수");
		fldstNewFieldset_2.setCollapsible(false);
		fldstNewFieldset_2.setStyleAttribute("marginTop", "20px");

		fldstNewFieldset_2.add(occupationalRBottom(), new FormData("100%"));
			
		layoutContainer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		layoutContainer_2.setBorders(false);

		plFrmPayr1200.add(layoutContainer);
		layoutContainer.setBorders(false);
	} 
	
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
	private LayoutContainer occupationalRTop() {
	    	 
		dpobCd = new HiddenField<String>();
		typOccuGrdeMppgSeilNum = new HiddenField<Long>();
		typOccuGrdeMppgDelYn = new HiddenField<Boolean>();

		sysComBass0320Dto = new PrgmComBass0320DTO();
		sysComBass0350Dto = new PrgmComBass0350DTO();

		LayoutContainer lcTabFormLayer = new LayoutContainer();

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(550, 120);
		  	   
		LayoutContainer layoutContainer01 = new LayoutContainer();
		layoutContainer01.setLayout(new FlowLayout());

		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new ColumnLayout());

		LayoutContainer layoutContainer_1 = new LayoutContainer();
		FormLayout frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1.setLayout(frmlytSch);
		  	   
		/** column 직종 : typOccuCd */
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
		typOccuCd.setStore(LsTypOccuCd02);
		typOccuCd.setFieldLabel("직 종");
		typOccuCd.setReadOnly(true);
			

		layoutContainer_1.add(typOccuCd, new FormData("100%"));
		layoutContainer_1.setBorders(false);
		layoutContainer.add(layoutContainer_1);

		
		
		

		
		
		
		
		
		
		
		
		LayoutContainer layoutContainer_2 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2.setLayout(frmlytSch);
		
		
		
		
		
		
		
		  	   
//		  	   /** column 호봉등급코드 : pyspGrdeCd */
//		  	    pyspGrdeCd = new ComboBox<BaseModel>(); 
//		    	pyspGrdeCd.setForceSelection(true);
//		     	pyspGrdeCd.setMinChars(1);
//		  	    pyspGrdeCd.setDisplayField("commCdNm");
//			    pyspGrdeCd.setValueField("commCd");
//			    pyspGrdeCd.setTriggerAction(TriggerAction.ALL);
//			    pyspGrdeCd.setEmptyText("--호봉등급선택--");
//			    pyspGrdeCd.setSelectOnFocus(true); 
//			    pyspGrdeCd.setReadOnly(false);
//			    pyspGrdeCd.setEnabled(true); 
//			    pyspGrdeCd.setStore(LsPyspGrdeCd02); 
//			    pyspGrdeCd.setFieldLabel("호봉등급");  
//			    pyspGrdeCd.setReadOnly(true); 
		/*****************************************************************************************/
		LsDtilOccuInttnCd02 = PrgmComComboUtils.getSingleBass0350ComboData(sysComBass0350Dto); 
		/*****************************************************************************************/
		
		/** column 직종세코드 : dtilOccuInttnCd */
		dtilOccuInttnCd = new ComboBox<BaseModel>();
		dtilOccuInttnCd.setForceSelection(true);
		dtilOccuInttnCd.setMinChars(1);
		dtilOccuInttnCd.setDisplayField("dtilOccuClsNm");
		dtilOccuInttnCd.setValueField("dtilOccuInttnCd");
		dtilOccuInttnCd.setTriggerAction(TriggerAction.ALL);
		dtilOccuInttnCd.setEmptyText("--직종세선택--");
		dtilOccuInttnCd.setSelectOnFocus(true);
		dtilOccuInttnCd.setReadOnly(false);
		dtilOccuInttnCd.setEnabled(true);
		dtilOccuInttnCd.setStore(LsDtilOccuInttnCd02);
		dtilOccuInttnCd.setFieldLabel("직종세");
		dtilOccuInttnCd.setReadOnly(true);
			   
		layoutContainer_2.add(dtilOccuInttnCd, new FormData("100%"));
		layoutContainer_2.setBorders(false);
		layoutContainer.add(layoutContainer_2);
		  	  
		  	   
		layoutContainer.add(layoutContainer_1, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer.add(layoutContainer_2, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		layoutContainer.setBorders(false);
		  	    
//		  	   LayoutContainer layoutContainer2 = new LayoutContainer();
//			   frmlytSch = new FormLayout();  
//			   frmlytSch.setLabelWidth(60); 
//			   frmlytSch.setLabelAlign(LabelAlign.RIGHT);   
//			   layoutContainer2.setLayout(frmlytSch);
//			   
//			  
//			   layoutContainer2.add(dtilOccuInttnCd, new FormData("100%"));
//			   layoutContainer2.setBorders(false);
			   
		
		
		
		LayoutContainer layoutContainer2 = new LayoutContainer();
	    frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer2.setLayout(frmlytSch);
		  	   
		/** column 직종 : typOccuCd */
		bggLogSvcYrNumCd = new ComboBox<BaseModel>();
		bggLogSvcYrNumCd.setForceSelection(true);
		bggLogSvcYrNumCd.setMinChars(1);
		bggLogSvcYrNumCd.setDisplayField("commCdNm");
		bggLogSvcYrNumCd.setValueField("commCd");
		bggLogSvcYrNumCd.setTriggerAction(TriggerAction.ALL);
		bggLogSvcYrNumCd.setEmptyText("--직종선택--");
		bggLogSvcYrNumCd.setSelectOnFocus(true);
		bggLogSvcYrNumCd.setReadOnly(false);
		bggLogSvcYrNumCd.setEnabled(true);
		bggLogSvcYrNumCd.setStore(bggLogSvcYrNumCd01);
		bggLogSvcYrNumCd.setFieldLabel("근속년수");
		bggLogSvcYrNumCd.setReadOnly(true);
			

		layoutContainer2.add(bggLogSvcYrNumCd, new FormData("100%"));
		layoutContainer2.setBorders(false);
		
		
		
		LayoutContainer layoutContainer3 = new LayoutContainer();
		frmlytSch = new FormLayout();
		frmlytSch.setLabelWidth(60);
		frmlytSch.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer3.setLayout(frmlytSch);

		/** column 직종_등급맵핑내용 : typOccuGrdeMppgCtnt */
		typOccuGrdeMppgCtnt = new TextArea();
		typOccuGrdeMppgCtnt.setPreventScrollbars(true);
		typOccuGrdeMppgCtnt.setFieldLabel("비 고");
		layoutContainer3.add(typOccuGrdeMppgCtnt, new FormData("100%"));
		layoutContainer3.setBorders(false);
			    
		layoutContainer01.add(layoutContainer);
	    layoutContainer01.add(layoutContainer2);
		layoutContainer01.add(layoutContainer3);

		cp01.add(layoutContainer01);
		  	    
		  	   
		cp01.addButton(new Button("저장", MSFMainApp.ICONS.save16(),new SelectionListener<ButtonEvent>() {   
			@Override  
			public void componentSelected(ButtonEvent ce) { 
				actionDatabase = ActionDatabase.UPDATE;
				doAction(actionDatabase);
			}
		}));   
	             
		cp01.addButton(new Button("삭제", MSFMainApp.ICONS.delete16(), new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				MessageBox.confirm("경고 수정", "직종 등급상세 내역을 삭제하겠습니까?</br> (삭제된 데이터는 복구되지 않습니다.)",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							actionDatabase = ActionDatabase.DELETE;
							doAction(actionDatabase);
						}
					}
				});
			}
		}));
               
	               
		cp01.addButton(new Button("근속년수생성", new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				// 맵핑 스케줄링 호출 처리.
				createPyspLogSvcYrMumCd();
			}
		}));
			  	    
		 	    
		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;

	}
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
	 
	private LayoutContainer occupationalLeft() {

		LayoutContainer lcTabFormLayer = new LayoutContainer(new FitLayout());

		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(358, 490);
        
		// msfCustomForm.setHeaderVisible(false);
		// Instantiate the GridPanel
		payr0400GridPanel = new MSFGridPanel(payr0400Def, false, false, false, true, false);
		payr0400GridPanel.setHeaderVisible(false);
		payr0400GridPanel.setBodyBorder(true);
		payr0400GridPanel.setBorders(true);
		payr0400GridPanel.setSize(358, 525);
		// msfGridPanel.setMSFFormPanel(msfCustomForm); //폼을 그리드에 넣은다.

		cp01.add(payr0400GridPanel);

		lcTabFormLayer.add(payr0400GridPanel);

		return lcTabFormLayer;

	   }
	   
	// 호봉등급별 근속년수 결과
	private LayoutContainer occupationalRBottom() {

		LayoutContainer lcTabFormLayer = new LayoutContainer(new FitLayout());

		//
		ContentPanel cp01 = new ContentPanel();
		cp01.setBodyBorder(false);
		cp01.setHeaderVisible(false);
		cp01.setLayout(new FitLayout());
		cp01.setSize(550, 370);
  
	         
		// msfCustomForm.setHeaderVisible(false);
		// Instantiate the GridPanel
		payr0430GridPanel = new MSFGridPanel(payr0430Def, false, false, false, false, false);
		payr0430GridPanel.setHeaderVisible(false);
		payr0430GridPanel.setBodyBorder(true);
		payr0430GridPanel.setBorders(true);
		payr0430GridPanel.setSize(550, 370);
		// msfGridPanel.setMSFFormPanel(msfCustomForm); //폼을 그리드에 넣은다.
	     
		cp01.add(payr0430GridPanel);

		cp01.addButton(new Button("삭제", MSFMainApp.ICONS.delete16(), new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				MessageBox.confirm("경고", "직종별근속년수를 삭제하겠습니까?</br> (삭제된 데이터는 복구되지 않습니다.)",new Listener<MessageBoxEvent>(){
					@Override
					public void handleEvent(MessageBoxEvent be) {
						//if("Yes".equals(be.getButtonClicked().getText())){
						if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
							deletePayr0430();
						}
					}
				});
			}
		}));

		lcTabFormLayer.add(cp01);

		return lcTabFormLayer;
	}

  /**
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
   * 그리드 처리 함수 종료
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/ 	  
	   
	public void reload() {
		// TODO Auto-generated method stub
		//payr0400GridPanel.getMsfGrid().clearData(); 
		payr0430GridPanel.getMsfGrid().clearData();
	            
		IColumnFilter filters = null;
		payr0400GridPanel.getTableDef().setTableColumnFilters(filters);
				 
        payr0400GridPanel.getTableDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(srhTypOccuCd,"typOccuCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		//payr0400GridPanel.getTableDef().addColumnFilter("pyspGrdeCd", MSFSharedUtils.getSelectedComboValue(srhPyspGrdeCd,"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
        String strDtilOccuInttnCd = PayrUtils.getStrValToBMMultiCombo(LsDtilOccuInttnCd01,srhDtilOccuInttnCd.getValue(),"dtilOccuClsNm","dtilOccuInttnCd");  
        payr0400GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", strDtilOccuInttnCd, SimpleColumnFilter.OPERATOR_EQUALS); 
		//payr0400GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", MSFSharedUtils.getSelectedComboValue(srhDtilOccuInttnCd,"dtilOccuInttnCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
		payr0400GridPanel.reload();
	}
	 
	/**
	 * 직종에 대한 직종세를 신규로 처리한다.
	 */
	private void formNew() {
		// 팝업호출을 통해 처리 한다.
		fnPopupCommP510();
	}
	  
	   
	private  void setFormData() {
		dpobCd.setValue(MSFSharedUtils.allowNulls(record.get("dpobCd")));    /** column 사업장코드 : dpobCd */
	       
		typOccuGrdeMppgSeilNum.setValue((Long)record.get("typOccuGrdeMppgSeilNum"));    /** column 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
		typOccuCd.setValue(LsTypOccuCd02.findModel("typOccuCd",MSFSharedUtils.allowNulls(record.get("typOccuCd"))));    /** column 직종코드 : typOccuCd */
	     // pyspGrdeCd.setValue(LsPyspGrdeCd02.findModel("commCd",MSFSharedUtils.allowNulls(record.get("pyspGrdeCd"))));    /** column 호봉등급코드 : pyspGrdeCd */
		
		bggLogSvcYrNumCd.setValue(bggLogSvcYrNumCd01.findModel("commCd",MSFSharedUtils.allowNulls(record.get("bggLogSvcYrNumCd"))));
		
		
		
		
		
		dtilOccuInttnCd.setValue(LsDtilOccuInttnCd02.findModel("dtilOccuInttnCd",MSFSharedUtils.allowNulls(record.get("dtilOccuInttnCd"))));    /** column 직종세코드 : dtilOccuInttnCd */
		typOccuGrdeMppgCtnt.setValue(MSFSharedUtils.allowNulls(record.get("typOccuGrdeMppgCtnt")));    /** column 직종_등급맵핑내용 : typOccuGrdeMppgCtnt */
		typOccuGrdeMppgDelYn.setValue((Boolean)record.get("typOccuGrdeMppgDelYn"));    /** column 직종_등급맵핑삭제여부 : typOccuGrdeMppgDelYn */
	}
	 
	   
	public void setRecord(BaseModel record) {
		this.record = record;
	}

	public void setListRecord(List<BaseModel> records) {
		this.records = records;
	}

	private Payr1200 getThis() {
		return this;
	}
	   
	   
	   
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 시작
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/
	
	/** 신규직종 맵핑생성 **/
	private void fnPopupCommP510() {

		MSFFormPanel popCom0510 = PrgmComPopupUtils.lovPopUpPrgmCom0510Form(); // 직종

		final FormBinding popBindingCom0510 = popCom0510.getFormBinding();

		popBindingCom0510.addListener(Events.Change, new Listener<BaseEvent>() {
			public void handleEvent(BaseEvent be) {
				List<BaseModel> mapModels = (List<BaseModel>) be.getSource();

				if (mapModels != null) {
					
					String dtilOccuClsDivNm = "";
					boolean dtilOccuInttnCdYn = false;

					List<BaseModel> list = payr0400GridPanel.getMsfGrid().getGrid().getStore().getModels();
					for(BaseModel bm : list){
						for(BaseModel bm2 : mapModels){

							String dtilOccuInttnCdStr = MSFSharedUtils.allowNulls(bm2.get("dtilOccuClsDivCd"))+MSFSharedUtils.allowNulls(bm2.get("pyspGrdeCd"));

							if(bm.get("dtilOccuInttnCd").equals(dtilOccuInttnCdStr)){
								dtilOccuInttnCdYn = true;
								dtilOccuClsDivNm = bm.get("dtilOccuClsDivNm");
							}
						}
					}

					if(dtilOccuInttnCdYn){	            			
						MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
								"직종세 ("+ dtilOccuClsDivNm + ") 이(가) 이미 존재 합니다.", null);	        					 
					}else{
						setListRecord(mapModels);
						actionDatabase = ActionDatabase.INSERT;
						doAction(ActionDatabase.INSERT);
					}
				}
			}
		});
	}	
	/**
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
	 * 팝업화면 종료
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 **/	 	
	    
	   
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
