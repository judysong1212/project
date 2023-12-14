package com.app.exterms.payroll.client.form;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.app.exterms.payroll.client.lookup.LookupPayr0300PayYr;
import com.app.exterms.payroll.client.service.Payr4200Service;
import com.app.exterms.payroll.client.service.Payr4200ServiceAsync;
import com.app.exterms.payroll.client.utils.PayrUtils;
import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.MSFMultiComboBox;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Timer;

public class PayrP4200 extends MSFPanel  {
	
	/**
	 *##########################################################################
	 * { 시스템 기본설정파일 선언부  시작}
	 *##########################################################################
	 **/
		//권한 설정 객체 
		private GWTAuthorization gwtAuthorization;
		private GWTExtAuth gwtExtAuth;
		private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 

	/**
	 *##########################################################################
	 * { 시스템 기본설정파일 선언부  종료}
	 *##########################################################################
	 **/
		  
    /**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 검색변수 선언 
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */
    
	    private ComboBox<BaseModel> srhPayYr;						// 급여년
	    private ComboBox<BaseModel> srhPayMonth;					// 급여월
	    
	    private ComboBox<BaseModel> srhPayCd;     					// 급여구분
	    private ComboBox<BaseModel> srhEmymtDivCd; 					// 고용구분 
	    private ComboBox<BaseModel> srhPayrMangDeptCd;				// 단위기관
	    
	    private MSFMultiComboBox<ModelData> srhDeptCd ;   			// 부서 
	    
	    private MSFMultiComboBox<ModelData> srhTypOccuCd; 			// 직종  
	    private MSFMultiComboBox<ModelData> srhDtilOccuInttnCd;		// 직종세
	    
	    private ComboBox<BaseModel> srhBusinCd;    					// 사업
	    private TextField<String> srhHanNm;         				// 성명
	    private TextField<String> srhResnRegnNum;   				// 주민번호 
	    private HiddenField<String> srhSystemkey;   				//시스템키
    
    
	    private ComboBox<BaseModel> srhPymtDducDivCd;	/** column 지급공제구분코드 : pymtDducDivCd */
	    private ComboBox<BaseModel> srhPayDducExtpyCd;
	    
	    
	    private List<ModelData> mDtalistHdofcCodtnCd ;
	    private List<ModelData> mDtalistDeptCd ;
	    private List<ModelData> mDtalistTypOccuCd ;
	    private List<ModelData> mDtalistDtilOccuInttnCd ;
	    
	    private boolean mutilCombo = false;
    
    
    /**
     *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
     * 	Rpc Service 선언부 시작
     *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
     **/
         	//입력수정삭제처리 rpc 처리부     
    	    private Payr4200ServiceAsync payr4200Service = Payr4200Service.Util.getInstance();
    	    
    	    private ListStore<BaseModel> lsPayYrStore = new ListStore<BaseModel>();  //년도 
      		private ListStore<BaseModel> lsPayMonth = new ListStore<BaseModel>();  //급여월   
      		
      		private ListStore<BaseModel>  lsEmymtDivCd = new ListStore<BaseModel>();//고용구분 
      		
      		 //--------------------부서 불러 오는 함수 ------------------------------------------------
      		private ListStore<BaseModel> lsDeptCd  = new ListStore<BaseModel>();// 부서콤보
      		 //--------------------부서 불러 오는 함수 ------------------------------------------------
      		   
      		//--------------------사업 불러 오는 함수 -------------------------------------------------
      		private ListStore<BaseModel> lsBusinCd  = new ListStore<BaseModel>();// 사업콤보   
      	   //--------------------사업 불러 오는 함수 -------------------------------------------------
      		private ListStore<BaseModel>   lsPayrMangDeptCd = new ListStore<BaseModel>();//단위기관 
      		private ListStore<BaseModel>  lsTypOccuCd = new ListStore<BaseModel>();//직종 
      		private ListStore<BaseModel>  lsPayCd = new ListStore<BaseModel>(); //급여구분
      		
      		
      		private ListStore<BaseModel>  lsPymtDducDivCd = new ListStore<BaseModel>(); 	//지급공제구분코드 
      		private ListStore<BaseModel>  lsPayDducExtpyCd = new ListStore<BaseModel>(); 	//지급공제항목
      		private ListStore<BaseModel>  lsDtilOccuInttnCd = new ListStore<BaseModel>();	//직종세
      		
      		private PrgmComBass0300DTO sysComBass0300Dto; //공통코드 dto
      		private PrgmComBass0400DTO sysComBass0400Dto; //부서코드
      		private PrgmComBass0500DTO sysComBass0500Dto; //사업코드 
      		private PrgmComBass0150DTO sysComBass0150Dto; //단위기관 
      		private SysCoCalendarDTO msfCoCalendarDto;  
      		private PrgmComBass0350DTO sysComBass0350Dto;  //직종세
      		private PrgmComBass0320DTO sysComBass0320Dto;	//직종
      		
            //지급년도 
            private LookupPayr0300PayYr lkPayYr = new LookupPayr0300PayYr();  
            private MSFGridPanel payYrGridPanel;
            
     	   private FormPanel plFrmPayrP4200;
     	   
           /**
            *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
            * 	권한설정 관련 함수 및 선언 시작 (권한 적용필요시 추가해야함.)
            *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
            **/
            // 검색 폼 바인딩 처리 함수 
          
           // private AuthAction authAction;  
     		//  private Boolean boolChkAuth;  
     		//  private static MessageBox authBox = MessageBox.wait("화면로딩", "설정 초기화 작업 진행 중입니다....", "설정 작업 진행 중..."); 
     		  /**
     		   * 권한설정 처리 체크 
     		   * AuthAction 
     		   */
     		  private void checkPayrP4200Auth( String authAction, ListStore<BaseModel> bm) {   
     	    	   //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
     			 
     			  //2015.12.08 권한초기화 및 날짜처리 추가 초기화 처리
     			   if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {
     			   
     				   //MSFMainApp.unmaskMainPage();
                        //----------------------------------------------------
                        
     				   if (!maskTracker) { unmask(); }  
     				   authExecEnabled() ;
     				   
     				   gwtExtAuth.setCheckMapDef(null); //로딩완료 후 초기화 
     	              
     	                 
     			   }
     		  }
     		  
     			 private void authExecEnabled() { 
     				   //------------------
     				   Field<?>[] fldArrField = {srhPayrMangDeptCd, srhEmymtDivCd, srhDeptCd, srhTypOccuCd, srhDtilOccuInttnCd, srhBusinCd};
                 	  	gwtAuthorization.formAuthFieldConfig(fldArrField);
                 	  
                 	   
                 	   srhPayYr.setValue(lsPayYrStore.findModel("payYr",DateTimeFormat.getFormat("yyyy").format(new Date())));
                 	   srhPayMonth.setValue(lsPayMonth.findModel("month",DateTimeFormat.getFormat("MM").format(new Date())));
                 	   srhPayCd.setValue(lsPayCd.getAt(0));
                 	  
                 	   /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                        * 권한설정을 위한 콤보처리를 위한 메서드 시작 
                        * 값순서 : 단위기관 ,고용구분, 부서, 직종, 직종세 ,사업 순으로  없으면 ""
                        ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
                        // String[] strArrDeptCd = {"srhMangeDeptCd","srhMangeDeptNm","srhDeptCd","srhDeptNm"};
                        // GWTAuthorization.formAuthPopConfig(plFrmPayr4200, "srhPayrMangDeptCd","srhEmymtDivCd",strArrDeptCd,"srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd");
                        // GWTAuthorization.formAuthBtnConfig(btnSrhDeptCd); 
     				  // gwtAuthorization.formAuthConfig(plFrmPayr4200, "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhDtilOccuInttnCd","srhBusinCd"); 
                       /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                        * 권한설정을 위한 콤보처리를 위한 메서드 종료
                        ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
                       //  srhDeptCd.fireEvent(Events.Add); 
                         srhDeptCd.getListView().fireEvent(Events.CheckChanged);     
     		              
     				 }
     				 
     		   final Timer tmMask = new Timer()
     		     {
     		           public void run()
     		           {
     		              // if (maskTracker)
     		              // { 
     		        	   if (lsEmymtDivCd.getCount() > 0 ) {
     		        		   
     			           	    cancel();
     			               	unmask(); 
     			               	authExecEnabled() ;
     			                maskTracker  = true;
     			        	
     			        	   } else {
     			        		   tmMask.scheduleRepeating(2000);
     			        	   }
     		              // }
     		           }
     		     }; 
     		     
     		  private void initLoad() { 
     			// 권한처리 부분 추가 전역이 아니 각 화면별로 객체 생성시 처리를 위해 변경함.
     			     gwtAuthorization = GWTAuthorization.getInstance();
     			     gwtExtAuth = GWTExtAuth.getInstance();
     			     
     			     
     			     HashMap<String,Boolean> authMapDef = new HashMap<String,Boolean>(); 
     			     
     			     authMapDef.put("srhPayYr",Boolean.FALSE);
     			     authMapDef.put("srhPayMonth",Boolean.FALSE);
     			     authMapDef.put("srhPayrMangDeptCd",Boolean.FALSE); 
     			     authMapDef.put("srhPayCd",Boolean.FALSE);
     			     authMapDef.put("srhEmymtDivCd",Boolean.FALSE);  
     			      authMapDef.put("srhDeptCd",Boolean.FALSE);  
     			     //  authMapDef.put("srhTypOccuCd",Boolean.FALSE);  
     				 
     			       gwtExtAuth.setCheckMapDef(authMapDef);
     		        
     		        if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
     		        	  //권한 검색조건처리를 위해 추가된 부분 
     					 mask("[화면로딩] 초기화 진행 중!");
     	        	}
     		        tmMask.scheduleRepeating(5000);
     		  }
     	        
                
              
           /**
            *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
            * 	권한설정 관련 함수 및 선언 종료 (권한 적용필요시 추가해야함.)
            *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
            **/	    	   
     	   
     	   
     	   
	
//	private static Payr4200ServiceAsync payr4200Service = Payr4200Service.Util.getInstance();
//	private static Psnl0120ServiceAsync psnl0120Service = Psnl0120Service.Util.getInstance(); 
//	private static EditorGrid<Payr0307DTO> excelGrid;
//	
//	public static Dialog getExcelUploadForm(){
//		Dialog complex = new Dialog();
//		complex.setBodyBorder(false);
//		//complex.setHeadingHtml("교육일괄등록");
//		complex.setWidth(800);  
//	    complex.setHeight(600);  
//	    complex.setHideOnButtonClick(true); 
//	    complex.setButtons("저장");
//	    
//	    
//	    BorderLayout layout = new BorderLayout();
//	    
//	    complex.setLayout(layout); 
//	    
//	    
//	    BorderLayoutData data = new BorderLayoutData(LayoutRegion.CENTER);  
//	    
//	    ContentPanel panel = new ContentPanel(); 
//	    //panel.setHeaderVisible(false);
//	    panel.setHeadingHtml("급여 조정 내역 일괄 등록");
//	    
//	    
//	    
//	    
////	    createSearchForm();
//	    
//	    
//	    final FileUploadField excelFile = new FileUploadField(){
//	    	// this is to resolve the "fakepath" issue
//	    	/*@Override 
//	    	protected void onChange(ComponentEvent ce) {
//		    	final String fullPath = getFileInput().getValue();
//		    	final int lastIndex = fullPath.lastIndexOf('\\');
//		    	final String fileName = fullPath.substring(lastIndex + 1);
//		    	setValue(fileName);
//	    	}*/
//	    };
//	    excelFile.setTitle("조정내역 일괄 엑셀");
//	    excelFile.setFieldLabel("조정내역 일괄 엑셀");
//	   // excelFile.setLabelSeparator("ddd");
//	    excelFile.setEmptyText("급여 조정내역 엑셀 파일을 선택하여주세요.");
//	    //excelFile.setName("aaaaa");
//	    excelFile.setWidth(770);
//	    
////	    excelFile.addListener(Events.Change, new Listener<FieldEvent>() {
////			public void handleEvent(FieldEvent e) {
////				
////				psnl0100Service.getExcelData(String.valueOf(excelFile.getValue()), new AsyncCallback<List<HashMap<String,String>>>() {
////
////					@Override
////					public void onFailure(Throwable caught) {
////						// TODO Auto-generated method stub
////						MessageBox.alert("", "Excel파일이 아니거나 양식이 잘못되었습니다.", null);
////					}
////
////					@Override
////					public void onSuccess(List<HashMap<String, String>> result) {
////						// TODO Auto-generated method stub
////						if(result.size() > 0){
////							excelGrid.getStore().removeAll();
////							//Info.display("REMOVE = excelGrid.getStore().getCount()", excelGrid.getStore().getCount()+"");
////							DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat());
////							excelGrid.stopEditing(false);
////							for(int i = 0; i < result.size(); i++){
////								Payr0307DTO dto = new Payr0307DTO();
//////								dto.setRnum(result.get(i).get("rnum"));
//////								dto.setRrn(result.get(i).get("rrn"));
//////								dto.setEduBgnnDt(dateTimeFormat.parse(result.get(i).get("bgnnDt")));
//////								dto.setEduEndDt(dateTimeFormat.parse(result.get(i).get("endDt")));
//////								dto.setEduCmpteTm(result.get(i).get("cmpteTm"));
//////								dto.setEduKndNm(result.get(i).get("kndNm"));
//////								dto.setEduIstutNm(result.get(i).get("istutNm"));
//////								dto.setEduNoteCtnt(result.get(i).get("noteCtnt"));
////								
////								excelGrid.getStore().insert(dto, i);
////								
////								
////							}
////							excelGrid.getStore().commitChanges();
////						}else{
////							MessageBox.alert("", "Excel파일이 아니거나 양식이 잘못되었습니다.", null);
////							excelFile.setValue("");
////						}
////					}
////				
////				});
////				
////			}
////	    });
//	    panel.add(excelFile, new BorderLayoutData(LayoutRegion.CENTER));
//	    
//	    
//	    
//	 
//	    //그리드 작업
//	    List<ColumnConfig> columns = new ArrayList<ColumnConfig>();
//	    
//	    ColumnConfig column = new ColumnConfig();
//		column.setId("rnum");
//		column.setHeaderText("순번");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(40);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		columns.add(column);
//		
//		column = new ColumnConfig();
//		column.setId("rrn");
//		column.setHeaderText("주민등록번호");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		columns.add(column);
//		
//		DateField dateField = new DateField();
//		dateField.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
//		//dateField.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
//		
//		column = new ColumnConfig();
//		column.setId("eduBgnnDt");
//		column.setHeaderText("교육시작일자");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(80);
//		column.setEditor(new CellEditor(dateField));
//	    column.setDateTimeFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		columns.add(column);
//		
//		DateField dateField2 = new DateField();
//		dateField2.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
//		//dateField2.getPropertyEditor().setFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
//		
//		column = new ColumnConfig();
//		column.setId("eduEndDt");
//		column.setHeaderText("교육종료일자");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(90);
//		column.setEditor(new CellEditor(dateField2));
//	    column.setDateTimeFormat(DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat()));
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		columns.add(column);
//		
//		column = new ColumnConfig();
//		column.setId("eduCmpteTm");
//		column.setHeaderText("교육이수시간");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(90);
//		column.setEditor(new CellEditor(new TextField<String>()));
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		columns.add(column);
//		
//		column = new ColumnConfig();
//		column.setId("eduKndNm");
//		column.setHeaderText("교육종류명");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(90);
//		column.setEditor(new CellEditor(new TextField<String>()));
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		columns.add(column);
//		
//		column = new ColumnConfig();
//		column.setId("eduIstutNm");
//		column.setHeaderText("교육기관명");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setWidth(90);
//		column.setEditor(new CellEditor(new TextField<String>()));
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		columns.add(column);
//		
//		column = new ColumnConfig();
//		column.setId("eduNoteCtnt");
//		column.setHeaderText("비고");
//		column.setAlignment(HorizontalAlignment.CENTER);
//		column.setEditor(new CellEditor(new TextField<String>()));
//		column.setWidth(90);
//		column.setSortable(false);
//		column.setMenuDisabled(true);
//		columns.add(column);
//		
//		
//		ColumnModel cm = new ColumnModel(columns);
//		excelGrid = new EditorGrid<Payr0307DTO>(new ListStore<Payr0307DTO>(), cm);
//		excelGrid.setLoadMask(true);
//		excelGrid.setBorders(true);
//		excelGrid.setStateful(false);
//		excelGrid.setAutoExpandColumn("eduNoteCtnt");
//		excelGrid.setHeight(485);
//		//excelGrid.getView().setAutoFill(true);
//		
//		panel.add(excelGrid);
//		
//		Button b = new Button("저장",new SelectionListener<ButtonEvent>() {
//			
//			@Override
//			public void componentSelected(ButtonEvent ce) {
//				// TODO Auto-generated method stub
//				Info.display("", excelGrid.getStore().getCount()+"");
//				ArrayList<Payr0307DTO> insertPsnl0120List = new ArrayList<Payr0307DTO>();
//				for ( int i = 0; i < excelGrid.getStore().getCount(); i++){
//					insertPsnl0120List.add(excelGrid.getStore().getAt(i));
//				}
//				
////				psnl0120Service.insert0120List(insertPsnl0120List, new AsyncCallback<String>() {
////					
////					@Override
////					public void onSuccess(String result) {
////						// TODO Auto-generated method stub
////						if("0".equals(result)){
////							MessageBox.info("저장실패", "교육사항 정보 저장이 실패 하였습니다.", null);
////						}else{
////							MessageBox.info("저장완료", "교육사항 정보("+result+")가 저장되었습니다.", null);
////						}
////						
////					}
////					
////					@Override
////					public void onFailure(Throwable caught) {
////						// TODO Auto-generated method stub
////						MessageBox.info("저장실패", "교육사항 정보 저장이 실패 하였습니다.", null);
////					}
////				});
//				
//			}
//		});
//		
//		panel.addButton(b);
//		
//		complex.add(panel, data);
//		
//		return complex;
//	}
	
	
	
	 /**
	  * 검색필드 설정
	  */
//	 private LayoutContainer createSearchForm() {   
//		 
//		     sysComBass0150Dto = new PrgmComBass0150DTO();
//			 sysComBass0300Dto = new PrgmComBass0300DTO();
//			 sysComBass0400Dto = new PrgmComBass0400DTO();
//			 sysComBass0500Dto = new PrgmComBass0500DTO();
//			 msfCoCalendarDto = new SysCoCalendarDTO();
//			 sysComBass0350Dto = new PrgmComBass0350DTO();
//			 sysComBass0320Dto = new PrgmComBass0320DTO();
//			 //--------------------단위기관 불러 오는 함수 ------------------------------------------------
//			 lsPayrMangDeptCd = PrgmComComboUtils.getDeptBass0150ComboData(sysComBass0150Dto);
//			 //--------------------단위기관 불러 오는 함수 ------------------------------------------------
//			 
//			 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
//			 //급여구분 
//			 sysComBass0300Dto.setRpsttvCd("B015");
//			 lsPayCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
//			 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
//			 
//			 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
//			 //고용구분
//			 sysComBass0300Dto.setRpsttvCd("A002");
//			 lsEmymtDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
//			 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
//			 
//			 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
//			 //월 
//			 
//			 lsPayMonth = SysComComboUtils.getSysComComboMonthData(msfCoCalendarDto);
//			 //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
//
//			   //--------------------급여부서 불러 오는 함수 ------------------------------------------------  
//	          sysComBass0400Dto.setDeptDspyYn("Y");
//	          sysComBass0400Dto.setDeptCd(gwtAuthorization.getStrGWTAuthDept()); 
//	          sysComBass0400Dto.setPayrMangDeptCd(MSFMainApp.get().getUser().getPayrMangDeptCd());
//	         
//	          lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
//	         
//	          lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
//	              public void handleEvent(StoreEvent<BaseModel> be) {  
//	                  mDtalistDeptCd = PayrUtils.getDeptCdModelData(lsDeptCd) ; 
//	                  srhDeptCd.getInitStore().add(mDtalistDeptCd);
//	                  
//	              }
//	          });     
//	          //--------------------급여부서 불러 오는 함수 ------------------------------------------------
//	          
//			// sysComBass0400Dto.setDeptDspyYn("Y");
//			 //--------------------부서 불러 오는 함수 ------------------------------------------------
//			// lsDeptCd = PrgmComComboUtils.getDeptBass0400ComboData(sysComBass0400Dto);
//			 //--------------------부서 불러 오는 함수 ------------------------------------------------
//			// sysComBass0400Dto.setDeptDspyYn("");
//				
//		   /**
//		      * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//		      * 직종 콤보박스 처리  시작
//		      * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		  
//		      */
////		     		  ContentPanel typOccuCdGrid = new ContentPanel();  
////		     		  typOccuCdGrid.setVisible(false);
////		     		    
////		     		    //직종 콤보처리 
////		     		   typOccuCdGridPanel = new MSFGridPanel(lkTypOccuCd, false, false, false, true); 
////		     		   typOccuCdGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
////		     			       public void handleEvent(ComponentEvent be) {  
////		     			    	 typOccuCdGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
////		     			          public void handleEvent(StoreEvent<BaseModel> be) {  
////		     			        	  
////		     			        	lsTypOccuCd.add(typOccuCdGridPanel.getMsfGrid().getStore().getModels());
////		     			        	mDtalistTypOccuCd = PayrUtils.getTypOccuCdModelData(typOccuCdGridPanel.getMsfGrid().getStore()) ;  
////	                                srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
////		     			          }  
////		     			        });  
////		     			       
////		     			      }  
////		     			    });  
////		     	  
////		     		 typOccuCdGrid.add(typOccuCdGridPanel); 
////		     		plFrmPayrP4200.add(typOccuCdGrid);
//		     	    
//	          lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
//			   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
//		            public void handleEvent(StoreEvent<BaseModel> be) {  
//		             
//	                 mDtalistTypOccuCd = PayrUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
//	                 srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
//	                  
//	               }
//	           });  
//				 
//			 /**
//		   * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//		   * 년도 콤보박스 처리  시작
//		   * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		  
//		   */
//		  		   ContentPanel payYrGrid = new ContentPanel();  
//		  		   payYrGrid.setVisible(false);
//		  		    
//		  		   //년도 콤보처리 
//		  		   payYrGridPanel = new MSFGridPanel(lkPayYr, false, false, false, true); 
//		  		   payYrGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
//		  			       public void handleEvent(ComponentEvent be) {  
//		  			    	 payYrGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
//		  			          public void handleEvent(StoreEvent<BaseModel> be) {  
//		  			        	 lsPayYrStore.add(payYrGridPanel.getMsfGrid().getStore().getModels()); 
//		  			        	 
//		  			        	//  Date today = new Date(); 
//		  			        	    // A custom date format
//		  			        	//  DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy"); 
//		  			        	 
//		  			      	     // BaseModel  bm  =  srhPayYr.getStore().findModel("apptnYr", fmt.format(today) ); 
//		  			      	     // srhPayYr.setValue(bm);
//		  			        	//srhPayYr.setValue(lsPayYrStore.getAt(0));
//		  			        	//Date today = new Date(); 
//	                            //DateTimeFormat fmt = DateTimeFormat.getFormat("MM");  
//	                            //srhPayMonth.setValue(lsPayMonth.getAt(Integer.parseInt(fmt.format(today)) - 1));
//	                       
//		  			          }  
//		  			        });  
//		  			       
//		  			      }  
//		  			    });  
//		  	  
//		  		payYrGrid.add(payYrGridPanel); 
//		  		plFrmPayrP4200.add(payYrGrid); 
//
//		  
//		    plFrmPayrP4200.setLayout(new FlowLayout());
//		    
//		    srhSystemkey = new HiddenField<String>(); 
//		      
//		    LayoutContainer lcSchCol = new LayoutContainer();
//		    //lcSchCol.setStyleAttribute("background-color","red");
//		    lcSchCol.setLayout(new ColumnLayout());  
//		    FieldSet fieldSet = new FieldSet();  
//		    fieldSet.setHeadingHtml("검색조건");
//		    fieldSet.setStyleAttribute("marginTop", "10px");
//		   
//		   // fieldSet.setCheckboxToggle(false); 
//		    
//		    LayoutContainer lcSchLeft = new LayoutContainer();
//	 
//		    fieldSet.add(lcSchCol, new FormData("100%"));  
//		    lcSchLeft.setLayout(new ColumnLayout());
//		    
//		    LayoutContainer layoutContainer_8 = new LayoutContainer();
//		    FormLayout frmlytSch = new FormLayout();  
//		    frmlytSch.setLabelWidth(70); 
//		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//		    layoutContainer_8.setLayout(frmlytSch);
//		    
//		    srhPayYr = new ComboBox<BaseModel>();
//		    srhPayYr.setName("srhPayYr");
//		    srhPayYr.setForceSelection(true);
//		    srhPayYr.setMinChars(1);
//		    srhPayYr.setDisplayField("payYrDisp");
//		    srhPayYr.setValueField("payYr");
//		    srhPayYr.setTriggerAction(TriggerAction.ALL);
//		   // srhPayYr.setEmptyText("--년도선택--");
//		    srhPayYr.setSelectOnFocus(true); 
//		    srhPayYr.setReadOnly(false);
//		    srhPayYr.setEnabled(true); 
//		    srhPayYr.setStore(lsPayYrStore);
//		    srhPayYr.setFieldLabel("지급년월"); 
//		    lsPayYrStore.addStoreListener( new StoreListener<BaseModel>() {   
//	            public void handleEvent(StoreEvent<BaseModel> be) {  
//
//	            	 EventType type = be.getType();
//			    	   if (type == Store.Add) { 
//	              		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//			                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
//			                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//			                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
//			                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//			                	checkPayrP4200Auth("srhPayYr", lsPayYrStore); 
//	              	 }
//	              
//	                
//	            }
//	        });    
//		    srhPayYr.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
//		          public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
//		              //부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
//		           BaseModel bmPayYr =  se.getSelectedItem(); 
//		           if (bmPayYr != null) {
//		               
//		               if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
//	                       
//	                       if (srhDeptCd.getListView().getChecked().size() > 0) {  
//	                          
//	                           sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr"));
//	                           List<ModelData> mdListSelect =  srhDeptCd.getListView().getChecked(); 
//	                           sysComBass0500Dto.setDeptCd( MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd"))); 
//	                       }      
//	                    
//	                       //--------------------사업 불러 오는 함수 -------------------------------------------------
//	                         lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
//	                        //--------------------사업 불러 오는 함수 -------------------------------------------------
//	                         srhBusinCd.setStore(lsBusinCd); 
//	                         srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//	                             public void handleEvent(StoreEvent<BaseModel> be) {  
//	                              //   searchBusinCd.setValue(lsBusinCd.getAt(0));  
//	                             }
//	                         });    
//	                         
//	                   } else {
//	                      // MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
//	                      //         "사업명을 검색하시려면 부서를 선택하셔야 합니다.", null);
//	                      // return;
//	                   } 
//	   
//		              
//		           }       
//		          } 
//		      });   
//		    layoutContainer_8.add(srhPayYr, new FormData("100%"));
//		    lcSchLeft.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
//		    layoutContainer_8.setBorders(false);
//		    
//		    LayoutContainer layoutContainer_9 = new LayoutContainer();
//		    frmlytSch = new FormLayout();  
//		    frmlytSch.setLabelWidth(0); 
//		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//		    layoutContainer_9.setLayout(frmlytSch);
//		    
//		    /** column 지급년월 : Mnth */ 
//		    srhPayMonth = new ComboBox<BaseModel>();
//		    srhPayMonth.setName("srhPayMonth");
//		    srhPayMonth.setForceSelection(true);
//		    srhPayMonth.setMinChars(1);
//		    srhPayMonth.setDisplayField("monthDisp");
//		    srhPayMonth.setValueField("month");
//		    srhPayMonth.setTriggerAction(TriggerAction.ALL);
//		   // srhPayMonth.setEmptyText("--월선택--");
//		    srhPayMonth.setSelectOnFocus(true); 
//		    srhPayMonth.setReadOnly(false);
//		    srhPayMonth.setEnabled(true); 
//		    srhPayMonth.setStore(lsPayMonth);
//		    srhPayMonth.setHideLabel(true);  
//		    lsPayMonth.addStoreListener( new StoreListener<BaseModel>() {   
//	            public void handleEvent(StoreEvent<BaseModel> be) {  
//
//	            	 EventType type = be.getType();
//			    	   if (type == Store.Add) { 
//	              		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//			                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
//			                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//			                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
//			                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//			                	checkPayrP4200Auth("srhPayMonth", lsPayMonth); 
//	              	 }
//	              
//	                
//	            }
//	        });    
//		    layoutContainer_9.add(srhPayMonth, new FormData("100%"));
//		    lcSchLeft.add(layoutContainer_9,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
//		    layoutContainer_9.setBorders(false);
//		    
//		    
//		    LayoutContainer layoutContainer = new LayoutContainer();
//	        frmlytSch = new FormLayout();  
//	        frmlytSch.setLabelWidth(70); 
//	        frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
//	        layoutContainer.setLayout(frmlytSch);
//	        
//	        /** column 단위기관 : payrMangDeptCd */
//	        srhPayrMangDeptCd = new ComboBox<BaseModel>();
//	        srhPayrMangDeptCd.setName("srhPayrMangDeptCd");
//	        srhPayrMangDeptCd.setForceSelection(true);
//	        srhPayrMangDeptCd.setMinChars(1);
//	        srhPayrMangDeptCd.setDisplayField("payrMangDeptNm");
//	        srhPayrMangDeptCd.setValueField("payrMangDeptCd");
//	        srhPayrMangDeptCd.setTriggerAction(TriggerAction.ALL);
//	        srhPayrMangDeptCd.setEmptyText("--단위기관선택--");
//	        srhPayrMangDeptCd.setSelectOnFocus(true); 
//	        srhPayrMangDeptCd.setReadOnly(gwtExtAuth.getReadOnlyPayrMangDeptCd());
//	        srhPayrMangDeptCd.setEnabled(gwtExtAuth.getEnablePayrMangDeptCd()); 
//	        srhPayrMangDeptCd.setStore(lsPayrMangDeptCd);  
//	        srhPayrMangDeptCd.setFieldLabel("단위기관"); 
//	        lsPayrMangDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
//	            public void handleEvent(StoreEvent<BaseModel> be) {  
//
//	            	 EventType type = be.getType();
//			    	   if (type == Store.Add) { 
//	              		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//			                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
//			                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//			                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
//			                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//			                	checkPayrP4200Auth("srhPayrMangDeptCd", lsPayrMangDeptCd); 
//	              	 }
//	              
//	                
//	            }
//	        });    
//	        srhPayrMangDeptCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
//	            public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
//	                sysComBass0400Dto.setDeptDspyYn("Y");
//	                sysComBass0400Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
//	                //--------------------부서 불러 오는 함수 ------------------------------------------------
//	                lsDeptCd = PrgmComComboUtils.getPayrBass0400ComboData (sysComBass0400Dto);
//	                //--------------------부서 불러 오는 함수 ------------------------------------------------
//	                lsDeptCd.addStoreListener( new StoreListener<BaseModel>() {   
//	                   public void handleEvent(StoreEvent<BaseModel> be) {  
//	                     mDtalistDeptCd = PayrUtils.getDeptCdModelData(lsDeptCd) ; 
//	                     srhDeptCd.getInitStore().add(mDtalistDeptCd);
//	                       
//	                   }
//	                });  
//	            } 
//	        });
//	        layoutContainer.add(srhPayrMangDeptCd, new FormData("100%"));
//	        layoutContainer.setBorders(false);
//	        
//	        LayoutContainer layoutContainer_14 = new LayoutContainer();
//	        frmlytSch = new FormLayout();  
//	        frmlytSch.setLabelWidth(70); 
//	        frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
//	        layoutContainer_14.setLayout(frmlytSch);
//	        
//	        srhPayCd =  new ComboBox<BaseModel>(); 
//	        srhPayCd.setName("srhPayCd");
//	        srhPayCd.setForceSelection(true);
//	        srhPayCd.setMinChars(1);
//	        srhPayCd.setDisplayField("commCdNm");
//	        srhPayCd.setValueField("commCd");
//	        srhPayCd.setTriggerAction(TriggerAction.ALL);
//	        srhPayCd.setEmptyText("--급여구분선택--");
//	        srhPayCd.setSelectOnFocus(true); 
//	        srhPayCd.setReadOnly(false);
//	        srhPayCd.setEnabled(true); 
//	        srhPayCd.setStore(lsPayCd);
//	        srhPayCd.setFieldLabel("급여구분");
//	        srhPayCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//	            public void handleEvent(StoreEvent<BaseModel> be) {  
//	 
//	            	checkPayrP4200Auth("srhPayCd",lsPayCd);   
//	            }
//	        });    
//	       
//	        
//	        layoutContainer_14.add(srhPayCd, new FormData("100%"));
//	       
//	        layoutContainer_14.setBorders(false);
//	        
//		    LayoutContainer layoutContainer_5 = new LayoutContainer();
//	        layoutContainer_5.setLayout(new ColumnLayout());
//	        
//	        LayoutContainer layoutContainer_6 = new LayoutContainer();
//	        frmlytSch = new FormLayout();  
//	        frmlytSch.setLabelWidth(70); 
//	        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//	        layoutContainer_6.setLayout(frmlytSch);
//	        
//	        srhHanNm = new TextField<String>();
//	        srhHanNm.setName("srhHanNm");
//	        srhHanNm.setFieldLabel("성명");
//	        layoutContainer_6.add(srhHanNm, new FormData("100%"));
//	        srhHanNm.addKeyListener(new KeyListener() {
//     		   @Override
//	            public void componentKeyUp(ComponentEvent event) {
//	                
//	                srhHanNm.validate();
//              if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
//              srhSystemkey.setValue("");
//              srhResnRegnNum.setValue("");
//               }     		  
//	                if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
//	                    srhSystemkey.setValue("");
//	                    srhResnRegnNum.setValue(""); 
////	                    fnPopupPsnl0100() ;
//	                }
//     		 super.componentKeyUp(event);
//	            }
//	         });
//	        srhHanNm.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//	            @Override
//	            public void handleEvent(BaseEvent be) {  
//	                if (MSFSharedUtils.allowNulls(srhHanNm.getValue()).trim().equals("")) {
//	                    srhSystemkey.setValue("");
//	                    srhResnRegnNum.setValue("");
//	                }
//	             
//	            } 
//	       }); 
//	        layoutContainer_5.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.46));
//	        layoutContainer_6.setBorders(false);
//	        
//	        Button btnHanNm = new Button("검색");
//	        layoutContainer_5.add(btnHanNm);
//	        btnHanNm.addListener(Events.Select, new Listener<ButtonEvent>() {
//	            public void handleEvent(ButtonEvent e) {
//	                srhSystemkey.setValue("");
//	                srhResnRegnNum.setValue("");   
////	              fnPopupPsnl0100() ;
//	                  
//	            }
//	        });
//	        
//	        LayoutContainer layoutContainer_7 = new LayoutContainer();
//	        frmlytSch = new FormLayout();  
//	        frmlytSch.setLabelWidth(0); 
//	        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//	        layoutContainer_7.setLayout(frmlytSch);
//	        
//	         
//	        
//	        
//	        /** column 주민등록번호 : resnRegnNum */
//	        srhResnRegnNum = new TextField<String>();
//	        srhResnRegnNum.setName("srhResnRegnNum");
//	        new TextFieldMask<String>(srhResnRegnNum, "999999-9999999");
//	        srhResnRegnNum.setLabelSeparator("");
//	     //   srhResnRegnNum.setFieldLabel("주민번호");
//	        srhResnRegnNum.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
//	            @Override
//	            public void handleEvent(BaseEvent be) {  
//	                if (MSFSharedUtils.allowNulls(srhResnRegnNum.getValue()).trim().equals("")) {
//	                    srhSystemkey.setValue("");
//	                    srhHanNm.setValue("");
//	                }
//	             
//	            } 
//	      }); 
//	        layoutContainer_7.add(srhResnRegnNum, new FormData("100%"));
//	        layoutContainer_5.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.42));
//	        layoutContainer_7.setBorders(false); 
//	        layoutContainer_5.setBorders(false);
//	        
//		    lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2)); 
//		    lcSchCol.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
//		    lcSchCol.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
//		    lcSchCol.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
//		    
//		    LayoutContainer layoutContainer_13 = new LayoutContainer();
//		    layoutContainer_13.setLayout(new ColumnLayout());
//		    
//		    LayoutContainer layoutContainer_1 = new LayoutContainer();
//		    layoutContainer_13.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
//		    frmlytSch = new FormLayout();  
//		    frmlytSch.setLabelWidth(70); 
//		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//		    layoutContainer_1.setLayout(frmlytSch);
//		    
//		    srhEmymtDivCd =  new ComboBox<BaseModel>(); 
//		    srhEmymtDivCd.setName("srhEmymtDivCd");
//		    srhEmymtDivCd.setForceSelection(true);
//		    srhEmymtDivCd.setMinChars(1);
//		    srhEmymtDivCd.setDisplayField("commCdNm");
//		    srhEmymtDivCd.setValueField("commCd");
//		    srhEmymtDivCd.setTriggerAction(TriggerAction.ALL);
//		    srhEmymtDivCd.setEmptyText("--고용구분선택--");
//		    srhEmymtDivCd.setSelectOnFocus(true); 
//		    srhEmymtDivCd.setReadOnly(gwtExtAuth.getReadOnlyEmymtDivCd());
//		    srhEmymtDivCd.setEnabled(gwtExtAuth.getEnableEmymtDivCd()); 
//		    srhEmymtDivCd.setStore(lsEmymtDivCd);
//		    srhEmymtDivCd.setFieldLabel("고용구분");
//		    lsEmymtDivCd.addStoreListener( new StoreListener<BaseModel>() {   
//	            public void handleEvent(StoreEvent<BaseModel> be) {  
//	            	 EventType type = be.getType();
//			    	   if (type == Store.Add) { 
//	              		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//			                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
//			                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//			                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
//			                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//			                	checkPayrP4200Auth("srhEmymtDivCd", lsEmymtDivCd ); 
//	              	 }
//	           
//	            }
//	        });    
//		    srhEmymtDivCd.addSelectionChangedListener(new SelectionChangedListener<BaseModel>() {
//	  	    	public void selectionChanged(SelectionChangedEvent<BaseModel> se) {
//	  	    		//부서가 변경되는 경우 해당하는 사업직종관련처리를 위한 이벤트처리 
//	  	    	 BaseModel bmPayCd =  se.getSelectedItem(); 
//	  	    	 if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD02.equals(bmPayCd.get("commCd"))) {
//	  	    		srhDeptCd.getListView().fireEvent(Events.CheckChanged);
//	               srhBusinCd.setEnabled(true);
//	               srhTypOccuCd.reset();
//	               srhTypOccuCd.setEnabled(false);
//	               srhDtilOccuInttnCd.reset();
//	               srhDtilOccuInttnCd.setEnabled(false);
//	  	    	} else  if (bmPayCd != null && MSFConfiguration.EMYMT_DIVCD01.equals(bmPayCd.get("commCd"))) {
//	           	 //20151130 추가 수정 
//	       	     srhDeptCd.getListView().fireEvent(Events.CheckChanged);
//	           	 srhBusinCd.reset();
//	                srhBusinCd.setEnabled(false);   
//	                if (gwtExtAuth.getEnableTypOccuCd()) {
//	               	 srhTypOccuCd.setEnabled(true);
//	                    srhDtilOccuInttnCd.setEnabled(true); 
//	                } else {
//	               	 srhTypOccuCd.setEnabled(false);
//	                 srhDtilOccuInttnCd.setEnabled(false);
//	                    
//	                }
//	       	     
//	  	    	}  
//	  	    	 
//	  	    	} 
//	  	    });
//		    layoutContainer_1.add(srhEmymtDivCd, new FormData("100%"));
//		    layoutContainer_1.setBorders(false); 
//		    
//		    LayoutContainer layoutContainer_2 = new LayoutContainer();
//		    layoutContainer_13.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
//		    frmlytSch = new FormLayout();  
//		    frmlytSch.setLabelWidth(70); 
//		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//		    layoutContainer_2.setLayout(frmlytSch);
//		    
//		    srhDeptCd = new MSFMultiComboBox<ModelData>();
//	        srhDeptCd.setName("srhDeptCd");
//	       // srhDeptCd.setForceSelection(true);
//	       // srhDeptCd.setMinChars(1);
//	        //srhDeptCd.setDisplayField("deptNmRtchnt");
//	        //srhDeptCd.setValueField("deptCd");
//	       // srhDeptCd.setTriggerAction(TriggerAction.ALL);
//	        srhDeptCd.setEmptyText("--부서선택--");
//	       // srhDeptCd.setSelectOnFocus(true); 
//	       // srhDeptCd.setReadOnly(false);
//	      //  srhDeptCd.setEnabled(true); 
//	        //srhDeptCd.setStore(lsDeptCd );
//	        //srhDeptCd.setMinListWidth(Constants.FRM_COMBO_WIDTH_200);
//	        srhDeptCd.getListView().setDisplayProperty("deptNmRtchnt");
//	        srhDeptCd.getStore().add(mDtalistDeptCd);
//	        srhDeptCd.setWidth(80);
//	        srhDeptCd.setFieldLabel("부서");
//	        srhDeptCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
//	        srhDeptCd.setEnabled(gwtExtAuth.getEnableDeptCd());
//	        srhDeptCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
//	            public void handleEvent(StoreEvent<ModelData> be) {  
//	            	 EventType type = be.getType();
//			    	   if (type == Store.Add) { 
//	              		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//			                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
//			                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//			                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
//			                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//			                	checkPayrP4200Auth("srhDeptCd", lsDeptCd); 
//	              	 }
//	           
//	            }
//	        });    
//	 
//	        srhDeptCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
//	           @Override
//	          public void handleEvent(ComponentEvent ce) { 
//	                   
//	                      if ((srhDeptCd.getListView().getChecked().size() == 1)  && (MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
//	                         
//	                          if (srhDeptCd.getListView().getChecked().size() > 0) {  
//	                             
//	                              sysComBass0500Dto.setBusinApptnYr(MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr"));    
//	                              List<ModelData> mdListSelect =  srhDeptCd.getListView().getChecked(); 
//	                              sysComBass0500Dto.setDeptCd( MSFSharedUtils.allowNulls(mdListSelect.get(0).get("deptCd"))); 
//	                          }      
//	                       
//	                          //--------------------사업 불러 오는 함수 -------------------------------------------------
//	                            lsBusinCd = PrgmComComboUtils.getDeptWithBass0500ComboData(sysComBass0500Dto);
//	                           //--------------------사업 불러 오는 함수 -------------------------------------------------
//	                            srhBusinCd.setStore(lsBusinCd); 
//	                            srhBusinCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
//	                                public void handleEvent(StoreEvent<BaseModel> be) {  
//	                                 //   searchBusinCd.setValue(lsBusinCd.getAt(0));  
//	                                }
//	                            }); 
//	                            
//	                      } else if ((srhDeptCd.getListView().getChecked().size() > 0) && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
//	   	            		 
//	                    	  //2015.11.30 권한 직종가져오기  추가 
//		            		   sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
//		            		   String strDeptCd = PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
//		            		   sysComBass0320Dto.setDeptCd(strDeptCd);
//		            		   lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
//		            		   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
//		           	            public void handleEvent(StoreEvent<BaseModel> be) {  
//		           	             
//		                             mDtalistTypOccuCd = PayrUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
//		                             srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
//		                              
//		                           }
//		                       });  
//	            	    
//			              } else {
//			            	  
//			            	   sysComBass0320Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
//			           		   String strDeptCd = PayrUtils.getStrValToBMMultiCombo(lsDeptCd,srhDeptCd.getValue(),"deptNmRtchnt","deptCd");  
//			           		   sysComBass0320Dto.setDeptCd(strDeptCd);
//			            	   lsTypOccuCd = PrgmComComboUtils.getSingleTypOccuCdBass0320ComboData(sysComBass0320Dto); 
//			         		   lsTypOccuCd.addStoreListener( new StoreListener<BaseModel>() {   
//			        	            public void handleEvent(StoreEvent<BaseModel> be) {  
//			        	             
//			                          mDtalistTypOccuCd = PayrUtils.getTypOccuCdModelData(lsTypOccuCd) ;  
//			                          srhTypOccuCd.getInitStore().add(mDtalistTypOccuCd);
//			                           
//			                        }
//			                    });   
//			              }
//	                      
//	                  }  
//	          
//	                });  
//	         
//	        srhDeptCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
//	            @Override
//	            public void handleEvent(ComponentEvent ce) {   
//	                
//	                if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
//	                   // GWT.log(" a" + ce.getEvent().getType());
//	                    mutilCombo = true;
//	                } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
//	                    mutilCombo = true;
//	                  //  GWT.log(" b" + ce.getEvent().getType());
//	                } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
//	                    mutilCombo = false;
//	                  //  GWT.log(" b" + ce.getEvent().getType());
//	                } 
//	            } 
//	        });
//	             
//		    layoutContainer_2.add(srhDeptCd, new FormData("100%"));
//		    layoutContainer_2.setBorders(false);
//		    
//		    LayoutContainer layoutContainer_10 = new LayoutContainer();
//		    layoutContainer_13.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
//	        frmlytSch = new FormLayout();  
//	        frmlytSch.setLabelWidth(70); 
//	        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//	        layoutContainer_10.setLayout(frmlytSch);
//	        
//	        //직종 직종세처리  
//	        LayoutContainer lcTypOccuCd = new LayoutContainer();
//	        lcTypOccuCd.setLayout(new ColumnLayout());
//	           
//	        LayoutContainer layoutContainer_21 = new LayoutContainer();
//	        frmlytSch = new FormLayout();  
//	        frmlytSch.setLabelWidth(70); 
//	        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//	        layoutContainer_21.setLayout(frmlytSch); 
//	        
//	        srhTypOccuCd = new MSFMultiComboBox<ModelData>();
//	        srhTypOccuCd.setName("srhTypOccuCd"); 
//	        srhTypOccuCd.setEmptyText("--직종선택--"); 
//	        srhTypOccuCd.getListView().setDisplayProperty("typOccuNm");
//	        srhTypOccuCd.getStore().add(mDtalistTypOccuCd);
//	        srhTypOccuCd.setWidth(100);
//	        srhTypOccuCd.setFieldLabel("직종");
//	        srhTypOccuCd.setReadOnly(gwtExtAuth.getReadOnlyTypOccuCd());
//	        srhTypOccuCd.setEnabled(gwtExtAuth.getEnableTypOccuCd());
//	        srhTypOccuCd.getStore().addStoreListener( new StoreListener<ModelData>() {   
//	            public void handleEvent(StoreEvent<ModelData> be) {  
//	            	
//	            	   EventType type = be.getType();
//			    	   if (type == Store.Add) { 
//			    		   if (!MSFConfiguration.EMYMT_DIVCD02.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd"))) {
//				    		   //2015.11.30 추가 
//				    		   if (!gwtExtAuth.getEnableTypOccuCd()) {
//			         	       ModelData  mdSelect  = srhTypOccuCd.getStore().getAt(0) ; 
//				                   // if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
//				                    //   for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
//				                     //      ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
//				                        //   if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
//				                      //         mdSelect = tpMdSelect;
//				                         //  } 
//				                     //  }  
//				                   
//				                       srhTypOccuCd.getListView().setChecked(mdSelect, true); 
//				                       srhTypOccuCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("typOccuNm")));
//				                   // }  
//				                    
//			                }  
//			    		   }	   
//		            // srhEmymtDivCd.setValue(lsEmymtDivCd.getAt(0)); 
//	              		 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//			                     * 권한설정을 위한 콤보처리를 위한 메서드 시작 lsTypOccuCd
//			                     * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
//			                     * "srhPayrMangDeptCd","srhEmymtDivCd","srhDeptCd","srhTypOccuCd","srhBusinCd"
//			                     ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//			                	//checkPayrP4200Auth("srhTypOccuCd", lsTypOccuCd); 
//	              	 }
//	                
//	            }
//	        });     
//	        
//	        srhTypOccuCd.getListView().addListener(Events.CheckChanged,new Listener<ComponentEvent>() {
//	           @Override
//	          public void handleEvent(ComponentEvent ce) { 
//	        	   //2015.11.30 추가 
//	          	 displayDtilOccuInttnCd(); 
//	                  }  
//	          
//	                });  
//	         
//	        srhTypOccuCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
//	            @Override
//	            public void handleEvent(ComponentEvent ce) {   
//	                
//	                if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) {
//	                   // GWT.log(" a" + ce.getEvent().getType());
//	                    mutilCombo = true;
//	                } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
//	                    mutilCombo = true;
//	                  //  GWT.log(" b" + ce.getEvent().getType());
//	                } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
//	                    mutilCombo = false;
//	                  //  GWT.log(" b" + ce.getEvent().getType());
//	                }  
//	            
//	            } 
//	        });
//	        
//		      //2015.11.30 추가 
//		        srhTypOccuCd.addListener(Events.Add,new Listener<BaseEvent>() { 
//		            @Override
//		            public void handleEvent(BaseEvent ce) {   
//		            	
//		            	displayDtilOccuInttnCd();
//		            } 
//		        }); 
//	        layoutContainer_21.add(srhTypOccuCd, new FormData("100%")); 
//	        
//	        LayoutContainer lcSchRight = new LayoutContainer();
//	      //  lcSchRight.setStyleAttribute("paddingRight", "10px");
//	        frmlytSch = new FormLayout();  
//	        frmlytSch.setLabelWidth(1); 
//	        frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
//	        frmlytSch.setDefaultWidth(0);
//	       // fieldSet.setLayout(layout);  
//	        lcSchRight.setLayout(frmlytSch);
//	        
//	        /** column 직종세코드 : dtilOccuInttnCd */
//	        srhDtilOccuInttnCd = new MSFMultiComboBox<ModelData>();
//	        srhDtilOccuInttnCd.setName("srhDtilOccuInttnCd"); 
//	        srhDtilOccuInttnCd.setEmptyText("--직종세선택--"); 
//	        srhDtilOccuInttnCd.getListView().setDisplayProperty("dtilOccuClsNm"); 
//	        srhDtilOccuInttnCd.getStore().add(mDtalistDtilOccuInttnCd);
//	        srhDtilOccuInttnCd.setWidth(100);
//	        srhDtilOccuInttnCd.setHideLabel(true); 
//	        srhDtilOccuInttnCd.setReadOnly(gwtExtAuth.getReadOnlyDtilOccuInttnCd());
//	        srhDtilOccuInttnCd.setEnabled(gwtExtAuth.getEnableDtilOccuInttnCd());
//	        srhDtilOccuInttnCd.getListView().addListener(Events.BrowserEvent,new Listener<ComponentEvent>() { 
//	            @Override
//	            public void handleEvent(ComponentEvent ce) {    
//	               
//	                if (DOM.eventGetType(ce.getEvent()) == Event.ONBLUR) { 
//	                    mutilCombo = true;
//	                } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOUT) {
//	                    mutilCombo = true;
//	                  //  GWT.log(" b" + ce.getEvent().getType());
//	                } else if (DOM.eventGetType(ce.getEvent()) == Event.ONMOUSEOVER) {
//	                    mutilCombo = false;
//	                  //  GWT.log(" b" + ce.getEvent().getType());
//	                } else {
//	                   
//	                }  
//	            
//	            } 
//	        });
//	        
//	        lcSchRight.add(srhDtilOccuInttnCd, new FormData("100%")); 
//	        
//	        lcTypOccuCd.add(layoutContainer_21,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.65));
//	        lcTypOccuCd.add(lcSchRight,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35)); 
//	        layoutContainer_21.setBorders(false);
//	        
//	        layoutContainer_10.add(lcTypOccuCd, new FormData("100%"));
//	        layoutContainer_10.setBorders(false);
//	        
//		    LayoutContainer layoutContainer_4 = new LayoutContainer();
//		    layoutContainer_13.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
//		    frmlytSch = new FormLayout();  
//		    frmlytSch.setLabelWidth(70); 
//		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//		    layoutContainer_4.setLayout(frmlytSch);
//		    
//		    srhBusinCd = new ComboBox<BaseModel>();
//		    srhBusinCd.setName("srhBusinCd");
//		    srhBusinCd.setForceSelection(true);
//		    srhBusinCd.setMinChars(1);
//		    srhBusinCd.setDisplayField("businNm");
//		    srhBusinCd.setValueField("businCd");
//		    srhBusinCd.setTriggerAction(TriggerAction.ALL);
//		    srhBusinCd.setEmptyText("--사업선택--");
//		    srhBusinCd.setSelectOnFocus(true); 
//		    srhBusinCd.setReadOnly(gwtExtAuth.getReadOnlyBusinCd());
//		    srhBusinCd.setEnabled(gwtExtAuth.getEnableBusinCd()); 
//		    srhBusinCd.setEnabled(true); 
//		    srhBusinCd.setStore(lsBusinCd);
//		    srhBusinCd.setFieldLabel("사업");
//		    layoutContainer_4.add(srhBusinCd, new FormData("100%"));
//		    layoutContainer_4.setBorders(false);
//		    fieldSet.add(layoutContainer_13);
//		    layoutContainer_13.setBorders(false);
//		    
//			
//		    plFrmPayrP4200.add(fieldSet); 
//		    
//	 } 
	 
	 
	 private void  displayDtilOccuInttnCd() {
		  
		   if ((srhTypOccuCd.getListView().getChecked().size() > 0)  && (MSFConfiguration.EMYMT_DIVCD01.equals(MSFSharedUtils.getSelectedComboValue(srhEmymtDivCd,"commCd")))) {
	         
	         //2015.11.30 권한 추가 직종변경에 따른 직종세 값 가져오기 
	             
	             sysComBass0350Dto.setPayrMangDeptCd(MSFSharedUtils.getSelectedComboValue(srhPayrMangDeptCd,"payrMangDeptCd"));
	             List<ModelData> mdDeptCdSelect =  srhDeptCd.getListView().getChecked();  
	             String strDeptCd = PayrUtils.getStrValToMDMultiCombo(mdDeptCdSelect,"deptCd"); 
	             sysComBass0350Dto.setDeptCd(strDeptCd);
	             List<ModelData> mdListSelect =  srhTypOccuCd.getListView().getChecked(); 
	             String strTypOccuCd = PayrUtils.getStrValToMDMultiCombo(mdListSelect,"typOccuCd"); 
	             sysComBass0350Dto.setTypOccuCd(strTypOccuCd); 
	             
	            // sysComBass0350Dto.setPyspGrdeCd(PayrUtils.getStrValToBMMultiCombo(lsTypOccuCd,srhTypOccuCd.getValue(),"typOccuNm","pyspGrdeCd")); 
	             
	             if (MSFSharedUtils.paramNotNull(sysComBass0350Dto.getTypOccuCd())) {
	                 
	                 lsDtilOccuInttnCd = PrgmComComboUtils.getSinglePayrBass0350ComboData(sysComBass0350Dto); 
	               //  srhDtilOccuInttnCd.setStore(lsDtilOccuInttnCd); 
	                 
	                 lsDtilOccuInttnCd.addStoreListener( new StoreListener<BaseModel>() {   
	                     public void handleEvent(StoreEvent<BaseModel> be) {  
	                         mDtalistDtilOccuInttnCd = PayrUtils.getDtilOccuInttnCdModelData(lsDtilOccuInttnCd) ; 
	                         srhDtilOccuInttnCd.getInitStore().add(mDtalistDtilOccuInttnCd);
	                         
	                         if (!gwtExtAuth.getEnableDtilOccuInttnCd()) {
	                     	    ModelData  mdSelect  = srhDtilOccuInttnCd.getStore().getAt(0) ;
		  		                   
		  		                   // if (MSFSharedUtils.paramNotNull(lsMdSelect) &&  (lsMdSelect.size() > 0) ) {
		  		                    //   for(int iTyCnt = 0;iTyCnt < lsMdSelect.size();iTyCnt++){
		  		                     //      ModelData tpMdSelect = lsMdSelect.get(iTyCnt);
		  		                        //   if (tpMdSelect.get("pyspGrdeCd").equals(MSFMainApp.get().getUser().getPyspGrdeCd())) {
		  		                      //         mdSelect = tpMdSelect;
		  		                         //  } 
		  		                     //  }  	
		  		                   
	                     	    srhDtilOccuInttnCd.getListView().setChecked(mdSelect, true); 
	                     	    srhDtilOccuInttnCd.setValue(MSFSharedUtils.allowNulls(mdSelect.get("dtilOccuClsNm")));
		  		                   // }  
	 	                 } 
	                     }
	                 });     
	                 
	             } 
	          
	       } else {
	        
	       } 
	 }
	
	
}
