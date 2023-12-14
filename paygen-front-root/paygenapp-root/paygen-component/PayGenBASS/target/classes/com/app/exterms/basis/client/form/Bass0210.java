package com.app.exterms.basis.client.form;

import java.util.Date;

import com.app.exterms.basis.client.dto.Bass0210DTO;
import com.app.exterms.basis.client.form.defs.Bass0210Def;
import com.app.exterms.basis.client.languages.BasisConstants;
import com.app.exterms.basis.client.service.Bass0210Service;
import com.app.exterms.basis.client.service.Bass0210ServiceAsync;
import com.app.exterms.basis.client.utils.BasisUtil;
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
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.MSFComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFDateField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTextField;
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
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.CheckBoxGroup;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class Bass0210 extends MSFPanel {

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
	  private BasisConstants lblBasisConst = BasisConstants.INSTANCE;
	 
	  private VerticalPanel vp;
	  private FormPanel plFrmBass0210;
	 // private FormData formData; 
	  private String txtForm = "";
	  private XTemplate detailTp; 
	 
	  public Bass0210DTO  bass0210Dto = new Bass0210DTO(); 
	//  public FormBinding srhFormBinding;  
	//  public FormBinding formBinding ;
	   
      private Bass0210Def bass0210Def  = new Bass0210Def();   //그리드 테이블 컬럼 define  
     // private MSFCustomForm msfCustomForm; 
      private MSFGridPanel msfBass0210GridPanel;
      
      
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 상태처리 전역변수
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
      private ActionDatabase actionDatabase;
    //  private ActionDatabase actionStatus;
      
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 화면 렌더링 변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
      
       private FieldSet fieldSetFrm;
       private FieldSet fieldSetStdFrm;
      
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * Button 변수 선언
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
      private ButtonBar topBass0210Bar;
      private Button btnBass0210New;
      private Button btnBass0210Save;
      private Button btnBass0210Del;
      private Button btnBass0210Sreach;
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 검색변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
      private TextField<String> srhPubcHodyCtnt;   //휴일명
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 입력 변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
      private MSFDateField pubcHodyDt; 		//휴일일자
      private HiddenField<String> dpobCd;  		//사업장코드 
      private MSFTextField pubcHodyCtnt;   		//휴일명 
      private MSFComboBox<BaseModel> dotwCd;    //요일코드  
      private CheckBoxGroup chkgrpBass021001;   //체크 그룹
      private CheckBox pubcHodyYn;              //휴일유무
      private CheckBox paidPubcHodyYn;          //유급휴일여부         
      
      private Date today = new Date(); 
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
	    private void setBass0210FormBinding() {
	 	 
	    // formBinding.addFieldBinding(new FieldBinding(srhPubcHodyCtnt, "srhPubcHodyCtnt"));
	    // formBinding.addFieldBinding(new FieldBinding(degtrResnRegnNum, "degtrResnRegnNum"));
	   
	    }        
   
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
	//입력수정삭제처리 rpc 처리부     
	private Bass0210ServiceAsync bass0210Service = Bass0210Service.Util.getInstance();	    
	  //공통 코드 - 요일코드   
	private ListStore<BaseModel>  dotwListStore = new ListStore<BaseModel>();
	private PrgmComBass0300DTO sysComBass0300Dto; 
	//private Bass0200DTO bass0200Dto; 
   
	private BaseModel record;
    
	/**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 조회처리부
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */  
//    private void readBass0200(){
//    	msfBass0200GridPanel.mask(MSFMainApp.MSFMESSAGES.LoadingData());
//    	
//    	//검색조건 넘김 
//    	bass0200Dto.setPubcHodyCtnt(srhPubcHodyCtnt.getValue());
//        //LOOP QUESTIONARI
//    	bass0200Service.selectBass0200List(bass0200Dto, new AsyncCallback<List<Bass0200BM>>(){
//            public void onFailure(Throwable caught) {
//                MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("selectBass0200(): "+caught), null);
//                msfBass0200GridPanel.unmask(); 
//            }
//
//            public void onSuccess(List<Bass0200BM> result) {
//            	composedBass0200List(result);
//            }
//        });
//    }
//    
//    //조회처리부
//    private void composedBass0200List(List<Bass0200BM> listaMenu) {
////        Iterator<Sysm0200BM> iter = listaMenu.iterator();
////        BaseTreeModel folder = new BaseTreeModel();
////        BaseTreeModel category = null;
////        while ( iter.hasNext() ) {
////        	Sysm0200BM mnu = iter.next();
////            Integer ord = new Integer(mnu.getMnuPrntOrd().intValue());
////            BaseTreeModel bm = new BaseTreeModel();
////            bm.set("sysDivCd", mnu.getSysDivCd());
////            bm.set("mnuCd", mnu.getMnuCd());
////            bm.set("hhrkMnuCd", mnu.getHhrkMnuCd());
////            bm.set("mnuNm", mnu.getMnuNm());
////            bm.set("mnuIcn", mnu.getMnuIcn()); 
////            bm.set("mnuTmbl", mnu.getMnuTmbl());
////            bm.set("mnuAuthFrmCd", mnu.getMnuAuthFrmCd());
////            bm.set("mnuTipNm", mnu.getMnuTipNm());
////            bm.set("mnuScnFrmPkgNm", mnu.getMnuScnFrmPkgNm());
////            bm.set("mnuPrntYn", mnu.getMnuPrntYn());
////            bm.set("mnuPrntOrd", ord);
////            bm.set("useYn", mnu.getUseYn());
////            bm.set("mnuEpln", mnu.getMnuEpln());
////             
////            if (mnu.getHhrkMnuCd() == null) {
////                category = new BaseTreeModel();
////                category.setProperties(bm.getProperties());
////                folder.add(category);
////            } else {
////                if (category != null) {
////                    category.add(bm);
////                }
////            }
////        } 
//        msfBass0200GridPanel.unmask();  
//    }
     
    /**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 선택된 버튼에 따른 인서트 업데이트 삭제 처리 부
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */  
    private SelectionListener<ButtonEvent> selectionListener = new SelectionListener<ButtonEvent>() {
	        public void componentSelected(ButtonEvent ce) { 
	            if (ce.getButton() == btnBass0210Save) {
	            	if (ActionDatabase.INSERT.equals(actionDatabase)) { 	            		
	            			doAction(ActionDatabase.INSERT);
	            	} else if (ActionDatabase.UPDATE.equals(actionDatabase) ){ 
	            	        doAction(ActionDatabase.UPDATE);
	            	}
	            } else if (ce.getButton() == btnBass0210Del) {
	            	
	            	// 선택한 대상이 없을 경우 
	        		if (MSFSharedUtils.paramNull(pubcHodyCtnt.getValue())) {
	        			MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
            					"[알림] 삭제할 데이터의 행을 더블클릭하여 선택해주세요.", null);
            			return;
	        		}
	                doAction(ActionDatabase.DELETE);
	            }
	        }  
	    };
	  
    private void doAction(ActionDatabase atnDatabase) {
        switch (atnDatabase) {
        case INSERT:
        	MessageBox.confirm("INSERT", "저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
				@Override
				public void handleEvent(MessageBoxEvent be) {
					if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
						actionDatabase = ActionDatabase.INSERT;
						save();
					}
				}
			});
//        	save();
            break;
        case UPDATE: 
        	MessageBox.confirm("UPDATE", "저장 하시겠습니까?",new Listener<MessageBoxEvent>(){
				@Override
				public void handleEvent(MessageBoxEvent be) {
					if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
						actionDatabase = ActionDatabase.UPDATE;
						save();
					}
				}
			});
//        	save();
            break;
        case DELETE:
        	MessageBox.confirm("DELETE", "삭제 하시겠습니까?",new Listener<MessageBoxEvent>(){
				@Override
				public void handleEvent(MessageBoxEvent be) {
					if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
						actionDatabase = ActionDatabase.DELETE;
						save();
					}
				}
			});
            break;
        }
    }
    
    
    public void save() {
      if (isValid()) {
    	  
    	  Bass0210DTO bass0210Dto = new Bass0210DTO(); 
    	 
    	  bass0210Dto.setDpobCd(dpobCd.getValue()==null?null:dpobCd.getValue());    //사업장코드 
    	  bass0210Dto.setPubcHodyDt(BasisUtil.getConvertDateToString(pubcHodyDt,"yyyyMMdd"));
//    	  DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy"); 
//    	  bass0200Dto.setYear(fmt.format(pubcHodyDt.getValue()));					//휴일일자
//    	  fmt = DateTimeFormat.getFormat("MM"); 
//  		  bass0200Dto.setMnth(fmt.format(pubcHodyDt.getValue()));
//  		  fmt = DateTimeFormat.getFormat("dd"); 
//  		  bass0200Dto.setDay(fmt.format(pubcHodyDt.getValue()));         
    	  bass0210Dto.setDotwCd((String)dotwCd.getValue().get("commCd"));  			//요일코드  
    	  bass0210Dto.setPubcHodyCtnt(pubcHodyCtnt.getValue());  					//휴일명 
    	  bass0210Dto.setPubcHodyYn(pubcHodyYn.getValue()) ;   						//휴일유무
    	  bass0210Dto.setPaidPubcHodyYn(paidPubcHodyYn.getValue());  				//유급휴일여부   
    	   
    	  
    	    bass0210Service.activityOnBass0210(bass0210Dto, actionDatabase, new AsyncCallback<Long>() {
              public void onFailure(Throwable caught) {
                  MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                          MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnBass0210(" + actionDatabase.name() + ") : " + caught), null);
              }
              public void onSuccess(Long result) { 
            	  if(result == 1L){
            		  //            		  Info.display("휴일관리", "{0}가 정상처리되었습니다.",new Params(actionDatabase.name()));  
            		  if("DELETE".equals(actionDatabase.name())){
            			  MessageBox.info("", "삭제 되었습니다.", null);
            		  }else{
            			  MessageBox.info("", "저장 되었습니다.", null);
            		  }            		  
            		  formBass0210Init();
            		  reload();
            	  }else if(result == 2L){
            		  MessageBox.info("", "법정 휴무일은 등록할 수 없습니다.", null);
            		  formBass0210Init();
            		  reload();
            	  }else {
            		  if("DELETE".equals(actionDatabase.name())){
            			  MessageBox.info("", "삭제 처리가 정상적으로 이루어지지 않았습니다.", null);
            		  }else{
            			  MessageBox.info("", "저장 처리가 정상적으로 이루어지지 않았습니다.", null);
            		  }
            		  formBass0210Init();
            		  reload();
            	  }
            	  
              }	
          });
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
//		  @Override
//		  protected void onRender(Element parent, int index) {
//		    super.onRender(parent, index);
//		    
//		    detailTp = XTemplate.create(getDetailTemplate());
//		    
//		    //formData = new FormData("-650");
//		    vp = new VerticalPanel();
//		    vp.setSpacing(10);
//		    createPsnl0100Form();  //화면 기본정보를 설정
//		    createSearchForm();    //검색필드를 적용
//		    createListGrdForm();
//		    createStandardForm();    //기본정보필드  
//		    add(vp);
//		    vp.setSize("1010px", "700px");
//		  }
	  public ContentPanel getViewPanel(){
			if(panel == null){
				
			    detailTp = XTemplate.create(getDetailTemplate());
			     
			    vp = new VerticalPanel();
			    vp.setSpacing(10);
			    createBass0210Form();  //화면 기본정보를 설정
			    createSearchForm();    //검색필드를 적용
			    createListGrdForm();
			    createStandardForm();    //기본정보필드  
			    
			    //  formBinding = new FormBinding(plFrmBass0200, true);  
				// formBass0200Init();  //form init
			    
			    actionDatabase = ActionDatabase.INSERT;
			 
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
	  public Bass0210() { 
	        
			setSize("1010px", "700px");  
	  } 
	
	  public Bass0210(String txtForm) {
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
	  //private void createPsnl0100Form()
	  private void createBass0210Form() {
		  
		plFrmBass0210 = new FormPanel();
		plFrmBass0210.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - " + lblBasisConst.title_Bass0200()));
		plFrmBass0210.setIcon(MSFMainApp.ICONS.text());
		plFrmBass0210.setBodyStyleName("pad-text");
		plFrmBass0210.setFrame(true); 
		plFrmBass0210.setSize("990px", "680px");
		
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
		 ************************************************************************/
		final Button btnlogView = new Button("로그");   
		
		btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
		btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
			public void handleEvent(ButtonEvent e) {
				 //로그 뷰화면 호출 메서드 
				  funcLogMessage(lblBasisConst.title_Bass0200(),"BASS0210");
				}
			});
		plFrmBass0210.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
		plFrmBass0210.getHeader().addTool(btnlogView); 
		/************************************************************************
		 * 화면 에러 처리시 필요한 부분으로 추가 
		 ************************************************************************/
		plFrmBass0210.setPadding(2);
		
		topBass0210Bar = new ButtonBar();    
		topBass0210Bar.setAlignment(HorizontalAlignment.RIGHT);
	
		 
	     //신규 
	    btnBass0210New = new Button("신규");  
	    btnBass0210New.setIcon(MSFMainApp.ICONS.new16());
	    topBass0210Bar.add(btnBass0210New);
	  	btnBass0210New.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			//초기화 버튼 클릭시 처리     
    			formBass0210Init();   
    		}
    	});
		//저장 -신규/수정 동시 처리 부분으로 나뉨 
	  	btnBass0210Save = new Button("저장");  
	  	btnBass0210Save.setIcon(MSFMainApp.ICONS.save16());
	  	topBass0210Bar.add(btnBass0210Save); 
	  	btnBass0210Save.addSelectionListener(selectionListener);
       
	  	//삭제	   
	  	btnBass0210Del = new Button("삭제");  
	  	btnBass0210Del.setIcon(MSFMainApp.ICONS.delete16());
	  	topBass0210Bar.add(btnBass0210Del);
	  	btnBass0210Del.addSelectionListener(selectionListener);
	  	
	  	//검색 
	  	btnBass0210Sreach = new Button("조회"); 
	  	btnBass0210Sreach.setIcon(MSFMainApp.ICONS.search16());
	  	topBass0210Bar.add(btnBass0210Sreach);
	  	btnBass0210Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
    		public void handleEvent(ButtonEvent e) {
    			reload();  
    		}
    	});
	  	
 
	  	plFrmBass0210.add(topBass0210Bar);  
		 
		vp.add(plFrmBass0210);
		
		
	  } 
/**
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * 검색 함수 선언부 시작
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
 **/ 
	  private void createSearchForm() {   
			
		    fieldSetFrm = new FieldSet();  
		    fieldSetFrm.setHeadingHtml("검색조건");   
		    /****************************************************************
			 * 검색조건 배경 변경 스타일시트 추가 시작
			 ****************************************************************/
		    fieldSetFrm.addStyleName("x-fieldset-serarch-back-color");
			/****************************************************************
			 * 검색조건 배경 변경 스타일시트 추가 끝
			 ****************************************************************/
		    plFrmBass0210.setLayout(new FlowLayout());
		    
		    LayoutContainer lcSchColFrm = new LayoutContainer();
		    lcSchColFrm.setLayout(new ColumnLayout()); 
		     
		    
		    LayoutContainer lcSchLeftFrm = new LayoutContainer();
		    lcSchLeftFrm.setStyleAttribute("paddingRight", "200px");
		    FormLayout frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(85); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
		    frmlytSch.setDefaultWidth(100); 
		    lcSchLeftFrm.setLayout(frmlytSch);
		    
		   
		    srhPubcHodyCtnt = new TextField<String>();  
		    srhPubcHodyCtnt.setFieldLabel("휴일명");  
		    srhPubcHodyCtnt.setAllowBlank(false);   
		    lcSchLeftFrm.add(srhPubcHodyCtnt,  new FormData("100%"));
		   
		    
		    lcSchColFrm.add(lcSchLeftFrm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5)); 
		    fieldSetFrm.add(lcSchColFrm,  new FormData("100%"));  
			
		    
		    
		    plFrmBass0210.add(fieldSetFrm); 
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
   
		   /**
		    * 지역변수 선언부
		    */
		    sysComBass0300Dto = new PrgmComBass0300DTO();
		  
		  
		    fieldSetStdFrm = new FieldSet();  
		    fieldSetStdFrm.setHeadingHtml("상세정보");
		    
		    LayoutContainer lcStdColStdFrm = new LayoutContainer();
		    lcStdColStdFrm.setLayout(new ColumnLayout()); 
 		    
		    LayoutContainer lcStdLeftStdFrm = new LayoutContainer();
		    lcStdLeftStdFrm.setStyleAttribute("paddingRight", "10px");
		    FormLayout frmlytStd = new FormLayout();  
		    frmlytStd.setLabelWidth(85); 
		    frmlytStd.setLabelAlign(LabelAlign.RIGHT);   
		    lcStdLeftStdFrm.setLayout(frmlytStd);
			  
		    /** set 년월일 : yearMnthDay */
		    //yearMnthDay = new DateField();
		    pubcHodyDt = new MSFDateField();
		    pubcHodyDt.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
		    pubcHodyDt.setName("pubcHodyDt");
		    lcStdLeftStdFrm.add(pubcHodyDt, new FormData("100%"));
		    new DateFieldMask(pubcHodyDt, "9999.99.99");
		    //new DateFieldMask(yearMnthDay, "____-__-__");
			pubcHodyDt.setFieldLabel("휴일일자");
			pubcHodyDt.setMinLength(10);
			pubcHodyDt.setMaxLength(10);
			  
			/** set 사업장코드 : dpobCd */
			dpobCd  = new HiddenField<String>();
			dpobCd.setName("dpobCd");
			  
			 /** set 휴일내용 : pubcHodyCtnt */
			 //pubcHodyCtnt = new TextField<String>(); 
			 pubcHodyCtnt = new MSFTextField(); 
			 pubcHodyCtnt.setName("pubcHodyCtnt");
			 lcStdLeftStdFrm.add(pubcHodyCtnt, new FormData("100%"));
			 pubcHodyCtnt.setFieldLabel("휴일명");
			 
			 LayoutContainer lcStdCenterStdFrm = new LayoutContainer();
			 lcStdCenterStdFrm.setStyleAttribute("paddingRight", "10px");
			  
			 frmlytStd = new FormLayout();  
			 frmlytStd.setLabelWidth(85); 
			 frmlytStd.setLabelAlign(LabelAlign.RIGHT);   
			 lcStdCenterStdFrm.setLayout(frmlytStd);
		  
			 //--------------------공통 코드 불러 오는 함수 -------------------------------------------
			 sysComBass0300Dto.setRpsttvCd("C001");
			 dotwListStore = PrgmComComboUtils.getSingleBass0300ComboData(sysComBass0300Dto);
			 //--------------------공통 코드 불러 오는 함수 -------------------------------------------
			 
			 //dotwCd = new ComboBox<BaseModel>();
			 dotwCd = new MSFComboBox<BaseModel>();
			 dotwCd.setName("dotwCd");
			 dotwCd.setForceSelection(true);
			 dotwCd.setMinChars(1);
			 dotwCd.setDisplayField("commCdNm");
			 dotwCd.setValueField("commCd");
			 dotwCd.setTriggerAction(TriggerAction.ALL);
			 dotwCd.setEmptyText("--요일선택--");
			 dotwCd.setSelectOnFocus(true); 
			 dotwCd.setReadOnly(false);
			 dotwCd.setEnabled(true); 
			 dotwCd.setStore(dotwListStore); 
			 dotwCd.setFieldLabel("요일"); 
			 lcStdCenterStdFrm.add(dotwCd,  new FormData("100%"));
		    
		     chkgrpBass021001 = new CheckBoxGroup();
		     chkgrpBass021001.setLabelSeparator("");
		     
		     /** set 휴일유무 : pubcHodyYn */
		    pubcHodyYn = new CheckBox();
		    pubcHodyYn.setName("pubcHodyYn");
		    chkgrpBass021001.add(pubcHodyYn);
		    pubcHodyYn.setBoxLabel("휴일");
		    pubcHodyYn.setHideLabel(true);
		    pubcHodyYn.setValue(true);
		    
		    /** set 유급휴일여부 : paidPubcHodyYn */
		    paidPubcHodyYn = new CheckBox();
		    paidPubcHodyYn.setName("paidPubcHodyYn");
		    chkgrpBass021001.add(paidPubcHodyYn );
		    paidPubcHodyYn.setBoxLabel("유급휴일");
		    paidPubcHodyYn.setHideLabel(true);
		    paidPubcHodyYn.setValue(true);
		    lcStdCenterStdFrm.add(chkgrpBass021001, new FormData("100%"));
		  
		    lcStdColStdFrm.add(lcStdLeftStdFrm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5)); 
		    lcStdColStdFrm.add(lcStdCenterStdFrm,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5)); 
		    fieldSetStdFrm.add(lcStdColStdFrm,  new FormData("100%"));  
		      
		    plFrmBass0210.add(fieldSetStdFrm);  
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
	  private void createListGrdForm() {
		    
		    FieldSet fieldSetGrd = new FieldSet();  
		    fieldSetGrd.setHeadingHtml("휴일정보");
		    
		    LayoutContainer lcStdGrid = new LayoutContainer();
		    lcStdGrid.setStyleAttribute("paddingLeft", "5px");
			lcStdGrid.setStyleAttribute("paddingRight", "5px");
		    FormLayout frmlytStd = new FormLayout();  
		  //  frmlytStd.setLabelWidth(85); 
		   // frmlytStd.setLabelAlign(LabelAlign.RIGHT);   
		    lcStdGrid.setLayout(frmlytStd);  
		    
		    ContentPanel cpGrid = new ContentPanel();   
		    cpGrid.setBodyBorder(false); 
		    cpGrid.setHeaderVisible(false);   
		    cpGrid.setLayout(new FitLayout());      
		    cpGrid.setSize(940, 465);  
		    
		    //  msfCustomForm.setHeaderVisible(false);
	        //Instantiate the GridPanel
		    msfBass0210GridPanel = new MSFGridPanel(bass0210Def, false, false, false, true);
		    msfBass0210GridPanel.setHeaderVisible(false);  
	     //   msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.
		    final Grid bass0210Grid = msfBass0210GridPanel.getMsfGrid().getGrid();
		    bass0210Grid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() { 
				public void handleEvent(BaseEvent be) {  
	            	  
	            	  BaseModel itemBass0210 = msfBass0210GridPanel.getCurrentlySelectedItem();
	            	  
	            	  if (itemBass0210 != null) { 
			        	 // A custom date format
			        	 // DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy.MM.dd"); 
			        	   actionDatabase = ActionDatabase.UPDATE;  
	            		   pubcHodyDt.setReadOnly(true);
	            		   pubcHodyDt.setValue((Date)itemBass0210.get("pubcHodyDt")); 	//휴일일자
	            		   dpobCd.setValue((String)itemBass0210.get("dpobCd"));   			//사업장코드 
	            		   pubcHodyCtnt.setValue((String)itemBass0210.get("pubcHodyCtnt")); //휴일명 
	            		   
	            		   BaseModel  bm  =  dotwCd.getStore().findModel("dotwCd", (String)itemBass0210.get("dotwCd") ); //요일코드  
	            		   dotwCd.setValue(bm); 
	            		 //  String valueCheck = (String)itemBass0200.get("pubcHodyYn"); 
	            		  // if (valueCheck.equals("Y")) {
	            		//	   basisUtil.setCheckedCheckBoxValue(chkgrpBass020001,(String)itemBass0200.get("pubcHodyYn"));
	            		 //  } else {
	            			   
	            		//   }
	            		   pubcHodyYn.setValue((Boolean)itemBass0210.get("pubcHodyYn"));//휴일유무
	            		   paidPubcHodyYn.setValue((Boolean)itemBass0210.get("paidPubcHodyYn"));//유급휴일여부
	            		  // pubcHodyYn.setValue((valueCheck.equals("Y") ? true : false ));
	            		  // valueCheck = (String)itemBass0200.get("paidPubcHodyYn");
	            		  // paidPubcHodyYn.setValue((valueCheck.equals("Y") ? true : false ));//유급휴일여부      
	            	   }
	             	}
	          });
	           
		    cpGrid.add(msfBass0210GridPanel); 
		  //  grid.setHeight("147px");
		    lcStdGrid.add(cpGrid);   
		    fieldSetGrd.add(lcStdGrid);   
		      
		    plFrmBass0210.add(fieldSetGrd, new FormData("0% -475"));
	  }
  /**
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
   * 그리드 처리 함수 종료
   *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 		
   **/ 	
	  
 	public void reload() {
			// TODO Auto-generated method stub
		    /**  IColumnFilter filters = getTableDef().getColumnFilters(fieldFilter.getRawValue());
			       ServiceParameters params = ServiceParameters.getListParameters(
			               getTableDef().getTable(),
			               ActionDatabase.LIST,
			               tableDef.getTableAttributes(),
			               filters,
			               tableDef.getColumnOrders(),
			               null,
			               tableDef.getCustomListMethod());
		     */ 
		   //readBass0200();
			IColumnFilter filters = null;
			msfBass0210GridPanel.getTableDef().setTableColumnFilters(filters);
			
			msfBass0210GridPanel.getTableDef().addColumnFilter("pubcHodyCtnt", srhPubcHodyCtnt.getRawValue(), SimpleColumnFilter.OPERATOR_LIKE); 
		  
		    msfBass0210GridPanel.reload();
		}
  
	public void setRecord(BaseModel record) {
		this.record = record;
	}

	private Bass0210 getThis() {
		return this;
	}
   
	private void formBass0210Init() {

		pubcHodyDt.setReadOnly(false);
		pubcHodyDt.setValue(today); 		// 휴일일자
		dpobCd.setValue(""); 				// 사업장코드
		pubcHodyCtnt.setValue("");	 		// 휴일명

		dotwCd.setValue(new BaseModel());
		pubcHodyYn.setValue(true); 			// 휴일유무
		paidPubcHodyYn.setValue(true); 		// 유급휴일여부
		
		actionDatabase = ActionDatabase.INSERT;
	}
   
	public boolean isValid() {
		boolean result = true;
		if (!pubcHodyDt.isValid()) {
			pubcHodyDt.focus();
			result = false;
		}
		// if (!pubcHodyCtnt.isValid()) {
		if (MSFSharedUtils.paramNull(pubcHodyCtnt.getValue())) {
			pubcHodyCtnt.focus();
			result = false;
		}
		// if (dotwCd.getValue() != null && !pubcHodyCtnt.isValid()) {
		if (MSFSharedUtils.getSelectedComboValue(dotwCd, "commCd") == null
				|| "".equals(MSFSharedUtils.getSelectedComboValue(dotwCd, "commCd"))) {
			dotwCd.focus();
			result = false;
		}
		return result;
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
