
package com.app.exterms.insurance.client.form;
  

import java.util.Iterator;

import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.HorizontalPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class InsrP210004   extends MSFFormPanel {  

/**
 *##########################################################################
 * { 시스템 기본설정파일 선언부  시작}
 *##########################################################################
 **/
	    

/**0
 *##########################################################################
 * { 시스템 기본설정파일 선언부  종료}
 *##########################################################################
 **/
  
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역변수 선언부  시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
 
	  private  ContentPanel cpInsr2104; 

	    //직종콤보
//		  private LookupPrgmComBass0320 lkTypOccuCd = new LookupPrgmComBass0320();  
//		  private MSFGridPanel typOccuCdGridPanel;
//		   
//		  private GridCellRenderer<Stock> gridNumber;   
//		  private GridCellRenderer<Stock> change;
		 
 
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
    
  private MSFPanel caller;
  private Boolean reading = false;
  public  FormBinding formBinding;
  
  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * Button 변수 선언
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
  private ButtonBar topPayr4100Bar;
  private Button btnPayr4100Init;
 // private Button btnPayr4100Save;
 // private Button btnPayr4100Del;
  private Button btnPayr4100Sreach;
  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 검색변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */ 
  
  private HiddenField<String> srhEmymtDivCd; //고용구분 
  private TextField<String> srhEmymtDivNm; //고용구분명 
  private HiddenField<String> srhPayrMangDeptCd; //단위기관
  private TextField<String> srhPayrMangDeptNm; //단위기관명
  
 
  private HiddenField<String> srhDeptCd; //부서코드
  private TextField<String> srhDeptNm; //부서명  
  
 // private HiddenField<String> srhPyspGrdeCd; //호봉등급 
   
  
  private HiddenField<String> srhTypOccuCd; //직종  
  private HiddenField<String> srhDtilOccuInttnCd; //직종세
  private TextField<String> srhTypOccuNm; //직종  
  private TextField<String> srhDtilOccuClsDivNm; //직종세
  
  private HiddenField<String> srhBusinCd;    //사업
  private TextField<String>  srhBusinNm;    //사업
  
  
  
  /**
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   * 입력 변수 선언 
   * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
   */
 
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
 
	  //  private Payr4200ServiceAsync payr4200Service = Payr4200Service.Util.getInstance();
		    
	    private BaseModel record;
    
	    private  Iterator<Record> records;
  		   
	    
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
//		private void Payr4100Print(String fileName) {
	// 
//			// 출력물 디렉토리 패스경로 인사 : PSNL
//			String strDirPath = "PAYR";
//			// mrd 출력물
//			String rdaFileName = fileName+".mrd";
//			// 보낼 파라미터
//			
//			
//			//검색조건
//	 	String serarchParam = "";
////			
////			String name = searchName.getValue() == null ? "" : searchName.getValue();
////			String resn = searchResnRegnNum.getValue() == null ? "" : searchResnRegnNum.getValue();
////			String hdofcCodtnCd = PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd, "commCd"); //재직구분
////			//String manageDeptCd = PersonalUtil.getSelectedComboValue(searchManageDeptCd, "mangeDeptCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchManageDeptCd, "mangeDeptCd"); //관리부서
////			String deptCd = PersonalUtil.getSelectedComboValue(searchDeptCd, "deptCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchDeptCd, "deptCd"); //소속부서
////			String typOccuCd = PersonalUtil.getSelectedComboValue(searchTypOccuCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchTypOccuCd, "commCd"); //직종
////			String emymtDivCd = PersonalUtil.getSelectedComboValue(searchEmymtDivCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchEmymtDivCd, "commCd"); //고용구분
////			
////			serarchParam += "["+name+"]";
////			serarchParam += "["+resn+"]";
////			serarchParam += "["+hdofcCodtnCd+"]";
////			serarchParam += "[]";
////			//serarchParam += "["+manageDeptCd+"]";
////			serarchParam += "["+deptCd+"]";
////			serarchParam += "["+emymtDivCd+"]";
////			serarchParam += "["+typOccuCd+"]";
//			
//			List<BaseModel> list = payr0301GridPanel.getGrid().getSelectionModel().getSelectedItems();
//			String checkedSystemKeys = "";
//			if(list != null && list.size() > 0){
//				String chkkey = "";
//				for(BaseModel bm : list){
//					chkkey += "'"+bm.get("systemkey")+"',";
//				}
//				
//				checkedSystemKeys = chkkey.substring(0,chkkey.length()-1);
//				
//			}
//			String strParam = "/rp " + serarchParam+"["+checkedSystemKeys+"]";
//			
//			
//			//GWT 타입으로 팝업 호출시  postCall true 설정
//			PrintUtils.setPostCall(true);
//			PrintUtils.rdaPrint(strDirPath, rdaFileName, strParam);
	//
//		}

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
 
	     
	  
	  public InsrP210004(final ActionDatabase actionDatabase, final MSFPanel caller) {
		    
 
		   // this.setFrame(false);
	       // this.setBodyBorder(false);
	        this.setBorders(false);
	       // this.setHeaderVisible(false);
	         
	        this.setAutoHeight(true);
	        this.actionDatabase = actionDatabase;
	        this.caller = caller;
		  
	        cpInsr2104 = new ContentPanel();
		    createInsrP210004Form();  //화면 기본정보를 설정 
		    createSearchForm();    //검색필드를 적용 
		    createStandardForm();    //기본정보필드   
		    
		   
		   cpInsr2104.setBodyBorder(false);
		   cpInsr2104.setBorders(false);
		   cpInsr2104.setHeaderVisible(false);
		  //cpInsr2104.setSize("810px", "710px");  
		    
		    this.add(cpInsr2104);
		  //  formBinding = new FormBinding(this, true);
			this.setSize("996px", "640px"); 
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
	  private  void createInsrP210004Form() { 
		    
		  cpInsr2104.setSize("976px", "640px");
	  }
	   

	  /**
	   * 검색필드 설정
	   */
	  private  void createSearchForm() {   
		      
		  
		  srhEmymtDivCd = new HiddenField<String>(); //고용구분 
		  srhPayrMangDeptCd  = new HiddenField<String>(); //단위기관
		  srhDeptCd  = new HiddenField<String>(); //부서코드
		  
		//  srhPyspGrdeCd  = new HiddenField<String>(); //호봉등급  
		  
		  srhTypOccuCd  = new HiddenField<String>(); //직종  
		  srhDtilOccuInttnCd  = new HiddenField<String>(); //직종세
		  
		  srhBusinCd  = new HiddenField<String>();    //사업 
		  
		  
		    LayoutContainer lcSchCol = new LayoutContainer();
		    //lcSchCol.setStyleAttribute("background-color","red");
		    lcSchCol.setLayout(new ColumnLayout());  
		    FieldSet fieldSet = new FieldSet();  
		    fieldSet.setHeadingHtml("검색조건");
		   
		  
		    
		    LayoutContainer layoutContainer_13 = new LayoutContainer();
		    layoutContainer_13.setLayout(new ColumnLayout());
		    
		    LayoutContainer layoutContainer = new LayoutContainer();
		    FormLayout frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(60); 
	        frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	        layoutContainer.setLayout(frmlytSch);
	        
	        /** column 단위기관 : payrMangDeptCd */
	        srhPayrMangDeptNm = new TextField<String>(); 
	        srhPayrMangDeptNm.setReadOnly(true); 
	        srhPayrMangDeptNm.setFieldLabel("단위기관"); 
	        
	        layoutContainer.add(srhPayrMangDeptNm, new FormData("100%"));
	        layoutContainer.setBorders(false);
	        layoutContainer_13.add(layoutContainer,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
	        
	        
		    LayoutContainer layoutContainer_1 = new LayoutContainer();
		    layoutContainer_13.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(60); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_1.setLayout(frmlytSch);
		    
		    srhEmymtDivNm = new TextField<String>(); 
		    srhEmymtDivNm.setReadOnly(true); 
		    srhEmymtDivNm.setFieldLabel("고용구분"); 
		    
		    layoutContainer_1.add(srhEmymtDivNm, new FormData("100%"));
		    layoutContainer_1.setBorders(false); 
		    
		    LayoutContainer layoutContainer_2 = new LayoutContainer();
		    layoutContainer_13.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(60); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_2.setLayout(frmlytSch);
		    
		    srhDeptNm = new TextField<String>(); 
		    srhDeptNm.setReadOnly(true); 
		    srhDeptNm.setFieldLabel("부서"); 
		    layoutContainer_2.add(srhDeptNm, new FormData("100%"));
		    layoutContainer_2.setBorders(false);
		    
		    LayoutContainer layoutContainer_10 = new LayoutContainer();
		    layoutContainer_13.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
	        frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(70); 
	        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	        layoutContainer_10.setLayout(frmlytSch);
	        
 
	        //직종 직종세처리  
	        LayoutContainer lcTypOccuCd = new LayoutContainer();
	        lcTypOccuCd.setLayout(new ColumnLayout());
	           
	        LayoutContainer layoutContainer_21 = new LayoutContainer();
	        frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(70); 
	        frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	        layoutContainer_21.setLayout(frmlytSch); 
	        
	        srhTypOccuNm = new TextField<String>(); 
	        srhTypOccuNm.setReadOnly(true); 
	        srhTypOccuNm.setFieldLabel("직종"); 
	         
	        layoutContainer_21.add(srhTypOccuNm, new FormData("100%")); 
	        
	        LayoutContainer lcSchRight = new LayoutContainer();
	      //  lcSchRight.setStyleAttribute("paddingRight", "10px");
	        frmlytSch = new FormLayout();  
	        frmlytSch.setLabelWidth(1); 
	        frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	        frmlytSch.setDefaultWidth(0);
	       // fieldSet.setLayout(layout);  
	        lcSchRight.setLayout(frmlytSch);
	         
	        srhDtilOccuClsDivNm = new TextField<String>(); 
	        srhDtilOccuClsDivNm.setReadOnly(true); 
	        srhDtilOccuClsDivNm.setFieldLabel("직종"); 
	          
	        lcSchRight.add(srhDtilOccuClsDivNm, new FormData("100%")); 
	        
	        lcTypOccuCd.add(layoutContainer_21,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
	        lcTypOccuCd.add(lcSchRight,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4)); 
	        layoutContainer_21.setBorders(false);
	        
	        layoutContainer_10.add(lcTypOccuCd, new FormData("100%"));
	        layoutContainer_10.setBorders(false);
	        
		    LayoutContainer layoutContainer_4 = new LayoutContainer();
		    layoutContainer_13.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(55); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_4.setLayout(frmlytSch);
		    
		    srhBusinNm = new TextField<String>(); 
		    srhBusinNm.setReadOnly(true); 
		    srhBusinNm.setFieldLabel("사업"); 
	        
		    
		    layoutContainer_4.add(srhBusinNm, new FormData("100%"));
		    layoutContainer_4.setBorders(false);
		    fieldSet.add(layoutContainer_13);
		    layoutContainer_13.setBorders(false);
		     
		    cpInsr2104.add(fieldSet); 
		 
	    //vp.add(panel);   
		   
	  }  
	   
	 
	  private  void createStandardForm() {
		  
		    LayoutContainer layoutContainer = new LayoutContainer();
			layoutContainer.setLayout(new ColumnLayout());
			
			LayoutContainer layoutContainer_2 = new LayoutContainer();
			FormLayout frmlytStd = new FormLayout();  
			frmlytStd.setLabelWidth(0); 
			frmlytStd.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_2.setLayout(frmlytStd);
			
			FieldSet fldstNewFieldset_2 = new FieldSet();
		//	fldstNewFieldset_2.setSize(528, 120);
			layoutContainer_2.add(fldstNewFieldset_2);
			fldstNewFieldset_2.setHeadingHtml("사업장정보");
			fldstNewFieldset_2.setCollapsible(false);
			
			fldstNewFieldset_2.add(createFormData(),new FormData("100%"));
			
			layoutContainer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_2.setBorders(false);
			 
			    
			cpInsr2104.add(layoutContainer);
			layoutContainer.setBorders(false); 
			    
		  } 
	   

	  private LayoutContainer createFormData() {    
	  	    
		    LayoutContainer lcStdGrid = new LayoutContainer();
		 //   lcStdGrid.setStyleAttribute("paddingRight", "10px");
		  //  FormLayout frmlytStd = new FormLayout();  
		  //  frmlytStd.setLabelWidth(85); 
		   // frmlytStd.setLabelAlign(LabelAlign.RIGHT);   
		   // lcStdGrid.setLayout(frmlytStd);  
		    
		    ContentPanel cpGrid = new ContentPanel();   
		    cpGrid.setBodyBorder(false); 
		    cpGrid.setHeaderVisible(false);   
		    cpGrid.setLayout(new FlowLayout());      
		    cpGrid.setSize(768, 175);
		    
		    HorizontalPanel horizontalPanel = new HorizontalPanel();
		    
		    LayoutContainer layoutContainer = new LayoutContainer();
		    layoutContainer.setSize("120px","56px");
		    LabelField lblfldNewLabelfield = new LabelField("사업장관리번호");
		    layoutContainer.add(lblfldNewLabelfield);
		    horizontalPanel.add(layoutContainer);
		    layoutContainer.setBorders(true);
		    
		    LayoutContainer layoutContainer_9 = new LayoutContainer();
		    layoutContainer_9.setWidth("646px");
		    FormLayout frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(0); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_9.setLayout(frmlytSch);
		    layoutContainer_9.setBorders(false);
		    
		    horizontalPanel.add(layoutContainer_9); 
		   
		    
		    LayoutContainer layoutContainer_1 = new LayoutContainer();
		    layoutContainer_1.setLayout(new ColumnLayout());
		    layoutContainer_9.add(layoutContainer_1, new FormData("100%"));
		    
		    
		    LayoutContainer layoutContainer_2 = new LayoutContainer();
		    layoutContainer_2.setLayout(new ColumnLayout());
		    
		    LayoutContainer layoutContainer_4 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(60); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_4.setLayout(frmlytSch); 
		    
		    TextField textField = new TextField();
		    layoutContainer_4.add(textField, new FormData("100%"));
		    textField.setFieldLabel("건강보험");
		    layoutContainer_2.add(layoutContainer_4,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		    layoutContainer_4.setBorders(false);
		    
		    LayoutContainer layoutContainer_6 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(0); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_6.setLayout(frmlytSch); 
		    
		    TextField txtfldNewTextfield_1 = new TextField();
		    layoutContainer_6.add(txtfldNewTextfield_1, new FormData("100%"));
		    txtfldNewTextfield_1.setFieldLabel("");
		    txtfldNewTextfield_1.setLabelSeparator("");
		    layoutContainer_2.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.2));
		    layoutContainer_6.setBorders(false);
		    
		    LayoutContainer layoutContainer_7 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(0); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_7.setLayout(frmlytSch); 
		    
		    TextField txtfldNewTextfield_2 = new TextField();
		    layoutContainer_7.add(txtfldNewTextfield_2, new FormData("100%"));
		    txtfldNewTextfield_2.setFieldLabel("");
		    txtfldNewTextfield_2.setLabelSeparator("");
		    layoutContainer_2.add(layoutContainer_7,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		    layoutContainer_7.setBorders(false);
		    layoutContainer_1.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		    layoutContainer_2.setBorders(false);
		    
		    LayoutContainer layoutContainer_3 = new LayoutContainer();
		    layoutContainer_3.setLayout(new ColumnLayout());
		    
		    LayoutContainer layoutContainer_5 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(60); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_5.setLayout(frmlytSch); 
		    
		    TextField txtfldNewTextfield = new TextField();
		    layoutContainer_5.add(txtfldNewTextfield, new FormData("100%"));
		    txtfldNewTextfield.setFieldLabel("국민연금");
		    layoutContainer_3.add(layoutContainer_5,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		    layoutContainer_5.setBorders(false);
		    
		    LayoutContainer layoutContainer_8 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(0); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_8.setLayout(frmlytSch); 
		    
		    TextField txtfldNewTextfield_3 = new TextField();
		    layoutContainer_8.add(txtfldNewTextfield_3, new FormData("100%"));
		    txtfldNewTextfield_3.setFieldLabel("");
		    txtfldNewTextfield_3.setLabelSeparator("");
		    layoutContainer_3.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		    layoutContainer_8.setBorders(false);
		    layoutContainer_1.add(layoutContainer_3,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		    layoutContainer_3.setBorders(false); 
		    layoutContainer_1.setBorders(false);
		   
		    
		    LayoutContainer layoutContainer_10 = new LayoutContainer();
		    layoutContainer_10.setLayout(new ColumnLayout());
		    
		    LayoutContainer layoutContainer_11 = new LayoutContainer();
		    layoutContainer_11.setLayout(new ColumnLayout());
		    
		    LayoutContainer layoutContainer_12 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(60); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_12.setLayout(frmlytSch); 
		    
		    ComboBox cmbxNewCombobox = new ComboBox();
		    cmbxNewCombobox.setStore(new ListStore());
		    layoutContainer_12.add(cmbxNewCombobox, new FormData("100%"));
		    cmbxNewCombobox.setFieldLabel("고용보험");
		    layoutContainer_11.add(layoutContainer_12,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		    layoutContainer_12.setBorders(false);
		    
		    LayoutContainer layoutContainer_13 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(0); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_13.setLayout(frmlytSch); 
		    layoutContainer_13.setBorders(false);
		    
		    TextField txtfldNewTextfield_4 = new TextField();
		    layoutContainer_13.add(txtfldNewTextfield_4, new FormData("100%"));
		    txtfldNewTextfield_4.setFieldLabel("");
		    txtfldNewTextfield_4.setLabelSeparator(""); 
		    layoutContainer_11.add(layoutContainer_13,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		   
		    layoutContainer_10.add(layoutContainer_11,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		    layoutContainer_11.setBorders(false);
		    
		    LayoutContainer layoutContainer_14 = new LayoutContainer();
		    layoutContainer_14.setLayout(new ColumnLayout());
		    
		    LayoutContainer layoutContainer_15 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(60); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_15.setLayout(frmlytSch); 
		    
		    ComboBox cmbxNewCombobox_1 = new ComboBox();
		    cmbxNewCombobox_1.setStore(new ListStore());
		    layoutContainer_15.add(cmbxNewCombobox_1, new FormData("100%"));
		    cmbxNewCombobox_1.setFieldLabel("산재보험");
		    layoutContainer_14.add(layoutContainer_15,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		    layoutContainer_15.setBorders(false);
		    
		    LayoutContainer layoutContainer_16 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(0); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_16.setLayout(frmlytSch); 
		    
		    TextField txtfldNewTextfield_5 = new TextField();
		    layoutContainer_16.add(txtfldNewTextfield_5, new FormData("100%"));
		    txtfldNewTextfield_5.setFieldLabel("");
		    txtfldNewTextfield_5.setLabelSeparator("");
		    layoutContainer_14.add(layoutContainer_16,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		    layoutContainer_16.setBorders(false);
		    layoutContainer_10.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		    layoutContainer_14.setBorders(false);
		    layoutContainer_9.add(layoutContainer_10, new FormData("100%"));
		    layoutContainer_10.setBorders(false);
		    
		    cpGrid.add(horizontalPanel);
		    
		    LayoutContainer layoutContainer_17 = new LayoutContainer();
		    layoutContainer_17.setLayout(new ColumnLayout());
		    
		    LayoutContainer layoutContainer_18 = new LayoutContainer();
		    
		    LabelField lblfldNewLabelfield_1 = new LabelField("보험사무 대행기관");
		    layoutContainer_18.add(lblfldNewLabelfield_1);
		    layoutContainer_17.add(layoutContainer_18,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
		    layoutContainer_18.setBorders(false);
		    
		    LayoutContainer layoutContainer_19 = new LayoutContainer();
		    layoutContainer_19.setLayout(new ColumnLayout());
		    
		    LayoutContainer layoutContainer_20 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(40); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_20.setLayout(frmlytSch); 
		    
		    TextField txtfldNewTextfield_6 = new TextField();
		    layoutContainer_20.add(txtfldNewTextfield_6, new FormData("100%"));
		    txtfldNewTextfield_6.setFieldLabel("번 호");
		    layoutContainer_19.add(layoutContainer_20,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		    layoutContainer_20.setBorders(false);
		    
		    LayoutContainer layoutContainer_21 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(40); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_21.setLayout(frmlytSch);
		    
		    TextField txtfldNewTextfield_7 = new TextField();
		    layoutContainer_21.add(txtfldNewTextfield_7, new FormData("100%"));
		    txtfldNewTextfield_7.setFieldLabel("명 칭");
		    layoutContainer_19.add(layoutContainer_21,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		    layoutContainer_21.setBorders(false);
		    layoutContainer_17.add(layoutContainer_19,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		    layoutContainer_19.setBorders(false);
		    
		    LayoutContainer layoutContainer_22 = new LayoutContainer();
		    
		    LabelField lblfldNewLabelfield_2 = new LabelField("단위기관(영업소)");
		    layoutContainer_22.add(lblfldNewLabelfield_2);
		    layoutContainer_17.add(layoutContainer_22,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.15));
		    layoutContainer_22.setBorders(false);
		    
		    LayoutContainer layoutContainer_23 = new LayoutContainer();
		    layoutContainer_23.setLayout(new ColumnLayout());
		    
		    LayoutContainer layoutContainer_24 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(40); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_24.setLayout(frmlytSch);
		    
		    TextField txtfldNewTextfield_8 = new TextField();
		    layoutContainer_24.add(txtfldNewTextfield_8, new FormData("100%"));
		    txtfldNewTextfield_8.setFieldLabel("기 호");
		    layoutContainer_23.add(layoutContainer_24,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		    layoutContainer_24.setBorders(false);
		    
		    LayoutContainer layoutContainer_25 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(40); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_25.setLayout(frmlytSch);
		    
		    TextField txtfldNewTextfield_9 = new TextField();
		    layoutContainer_25.add(txtfldNewTextfield_9, new FormData("100%"));
		    txtfldNewTextfield_9.setFieldLabel("명 칭");
		    layoutContainer_23.add(layoutContainer_25,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		    layoutContainer_25.setBorders(false);
		    layoutContainer_17.add(layoutContainer_23,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
		    layoutContainer_23.setBorders(false);
		    cpGrid.add(layoutContainer_17);
		    layoutContainer_17.setBorders(false);
		    
		    LayoutContainer layoutContainer_26 = new LayoutContainer();
		    layoutContainer_26.setLayout(new ColumnLayout());
		    
		    LayoutContainer layoutContainer_27 = new LayoutContainer();
		    layoutContainer_27.setLayout(new ColumnLayout());
		    layoutContainer_27.setBorders(false);
		    
		    
		    LayoutContainer layoutContainer_28 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(60); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_28.setLayout(frmlytSch);
		    
		    TextField txtfldNewTextfield_10 = new TextField();
		    layoutContainer_28.add(txtfldNewTextfield_10, new FormData("100%"));
		    txtfldNewTextfield_10.setFieldLabel("전화번호");
		    layoutContainer_27.add(layoutContainer_28,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		    layoutContainer_28.setBorders(false);
		    layoutContainer_26.add(layoutContainer_27);
		    
		    
		    LayoutContainer layoutContainer_29 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(60); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_29.setLayout(frmlytSch);
		    
		    TextField txtfldNewTextfield_11 = new TextField();
		    layoutContainer_29.add(txtfldNewTextfield_11, new FormData("100%"));
		    txtfldNewTextfield_11.setFieldLabel("팩스번호");
		    layoutContainer_26.add(layoutContainer_29,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		    layoutContainer_29.setBorders(false);
		    cpGrid.add(layoutContainer_26);
		    layoutContainer_26.setBorders(false);
		    
		    LayoutContainer layoutContainer_30 = new LayoutContainer();
		    layoutContainer_30.setLayout(new ColumnLayout());
		    
		    LayoutContainer layoutContainer_31 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(60); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_31.setLayout(frmlytSch);
		    
		    TextField txtfldNewTextfield_12 = new TextField();
		    layoutContainer_31.add(txtfldNewTextfield_12, new FormData("100%"));
		    txtfldNewTextfield_12.setFieldLabel("주 소");
		    layoutContainer_30.add(layoutContainer_31,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		    layoutContainer_31.setBorders(false);
		    
		    LayoutContainer layoutContainer_32 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(0); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_32.setLayout(frmlytSch);
		    
		    TextField txtfldNewTextfield_13 = new TextField();
		    layoutContainer_32.add(txtfldNewTextfield_13, new FormData("100%"));
		    txtfldNewTextfield_13.setFieldLabel("");
		    txtfldNewTextfield_13.setLabelSeparator("");
		    layoutContainer_30.add(layoutContainer_32,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
		    layoutContainer_32.setBorders(false);
		    cpGrid.add(layoutContainer_30);
		    layoutContainer_30.setBorders(false);
		    
		    LayoutContainer layoutContainer_33 = new LayoutContainer();
		    layoutContainer_33.setLayout(new ColumnLayout());
		    
		    LayoutContainer layoutContainer_34 = new LayoutContainer();
		    frmlytSch = new FormLayout();  
		    frmlytSch.setLabelWidth(160); 
		    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
		    layoutContainer_34.setLayout(frmlytSch);
		    
		    
		    TextField txtfldNewTextfield_14 = new TextField();
		    layoutContainer_34.add(txtfldNewTextfield_14, new FormData("100%"));
		    txtfldNewTextfield_14.setFieldLabel("고용보험 하수급인관리번호");
		    layoutContainer_33.add(layoutContainer_34,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
		    layoutContainer_34.setBorders(false);
		    
		    LayoutContainer layoutContainer_35 = new LayoutContainer();
		    
		    LabelField lblfldNewLabelfield_3 = new LabelField("(건설공사등의 미승인 하수급인에 한함)");
		    layoutContainer_35.add(lblfldNewLabelfield_3);
		    layoutContainer_33.add(layoutContainer_35,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.4));
		    layoutContainer_35.setBorders(false);
		    cpGrid.add(layoutContainer_33);
		    layoutContainer_33.setBorders(false);
		    lcStdGrid.add(cpGrid);   
		 
		    return lcStdGrid;
		     
		  }  
		   
			public void reload() {
				// TODO Auto-generated method stub
				formInit(); 
				IColumnFilter filters = null;
//				payr0304GridPanel.getTableDef().setTableColumnFilters(filters); 
 
//			 	payr0304GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS); 
//			 
//				payr0304GridPanel.reload();
				
				actionDatabase = ActionDatabase.READ; 
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
