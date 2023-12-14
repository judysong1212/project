package com.app.exterms.insurance.client.form;
  
import java.util.HashMap;
import java.util.List;

import com.app.exterms.insurance.client.form.defs.Insr1100Def;
import com.app.exterms.insurance.client.service.Insr2100Service;
import com.app.exterms.insurance.client.service.Insr2100ServiceAsync;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.utils.PrintUtils;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldMask;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.core.resources.client.Resources;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.HeaderGroupConfig;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public  class InsrP210005   extends MSFFormPanel { 
 
	  private ContentPanel cpInsr2101; 
	  //4대보험취득
	  private Insr1100Def insr1100Def  = new Insr1100Def("INSR210005");   //그리드 테이블 컬럼 define  
	  //private MSFCustomForm msfCustomForm; 
      private MSFGridPanel insr1100GridPanel;
	  private ActionDatabase actionDatabase;
	  private MSFPanel caller;
	  public  FormBinding formBinding;
	  //private TextField<String> srhHanNm;         //성명
	  //private TextField<String> srhResnRegnNum;   //주민번호 
	  //private HiddenField<String> srhSystemkey;   //시스템키  
	  private ButtonBar topInsrP210005Bar;
	  private Button btnInsrP210005Init;
	  private Button btnInsrP210005New;
	  private Button btnInsrP210005Print;
	  private Button btnInsrP210005Del;
	  private Button btnInsrP210005Sreach;
	  //private Button btnInsrP210005Print;
	  private Button btnInsrP210005Excel;
  
      private HiddenField<String> dpobCd;  //사업장코드
      private HiddenField<String> systemkey;    /** column SYSTEMKEY : systemkey */ 
      private HiddenField<String> payrMangDeptCd;   /** column 단위기관코드 : payrMangDeptCd */
      private TextField<String> payrMangDeptNm;   /** column 단위기관 : payrMangDeptNm */
      private HiddenField<Long> payrSeilNum;   /** column 급여일련번호 : payrSeilNum */
      private HiddenField<String> emymtDivCd;   /** column 고용구분코드 : emymtDivCd */
      private HiddenField<String> hanNm ;  /** column 한글성명 : hanNm */
      private HiddenField<String> resnRegnNum;   /** column 주민등록번호 : resnRegnNum */
      private HiddenField<String> secRegnNum;   /** column 주민등록번호 : secRegnNum */
      private HiddenField<String> deptCd ;  /** column 부서코드 : deptCd */
      private TextField<String> deptNm ;  /** column 부서 : deptNm */
      private HiddenField<String> businCd;   /** column 사업코드 : businCd */
      private TextField<String> businNm;   /** column 사업코드 : businNm */
      private HiddenField<String> typOccuCd;   /** column 직종코드 : typOccuCd */
      private TextField<String> typOccuNm ;  /** column 직종코드 : typOccuNm */ 
      private HiddenField<String> dtilOccuInttnCd  ;           /**  column 직종세구분코드 : dtilOccuInttnCd */
      //private HiddenField<String>  pyspGrdeCd;  /** column 호봉등급코 : pyspGrdeCd */
      private TextField<String> dtilOccuClsDivNm  ;           /**  column 직종세구분코드 : dtilOccuClsDivNm */
      private TextField<String> emymtDivNm ;                  /**  column 고용구분 : emymtDivNm */
      private TextField<String> soctyInsurCmptnDt01 ;                  /**  column 시작일자 : soctyInsurCmptnDt01 */
      private TextField<String> soctyInsurCmptnDt02 ;                  /**  column 종료일자 : soctyInsurCmptnDt02 */
      private HiddenField<String>  hdofcCodtnCd;                /** column 재직구분코드 : hdofcCodtnCd */
      private TextField<String> hdofcCodtnNm ;                  /**  column 재직구분 : hdofcCodtnNm */
      private String systemKeys;
      private String printFileName;
      
      private HiddenField<String> srhRepbtyBusinDivCd; //호봉제구분코드 
      private HiddenField<String> srhDeptGpCd; //부서직종그룹코드
      
      private TextField<String> srhRepbtyBusinDivNm; //호봉제구분코드 
      private TextField<String> srhDeptGpNm; //부서직종그룹코드
      
      private TextField<String> srhHanNm;
      private TextField<String> srhResnRegnNum;
      
      private HiddenField<String> deptCdAuth;
      private HiddenField<String> dtilOccuInttnCdAuth;
      
      private Insr2100ServiceAsync insr2100Service = Insr2100Service.Util.getInstance();	 
      
      //화면 폼 바인딩 처리 
      public InsrP210005(final ActionDatabase actionDatabase, final MSFPanel caller) {
 
    	  this.setBorders(false);
    	  this.setHeaderVisible(false);
    	  this.setAutoHeight(true);
    	  this.actionDatabase = actionDatabase;
    	  this.caller = caller;

    	  cpInsr2101 = new ContentPanel();
    	  createPayrP410002Form();  //화면 기본정보를 설정
    	  createInfoForm();    //검색기본필드를 적용
    	  createStandardForm();    //grid form
    	  
    	  cpInsr2101.setBodyBorder(false);
    	  cpInsr2101.setBorders(false);
    	  cpInsr2101.setHeaderVisible(false);
	    
    	  this.add(cpInsr2101);
    	  formBinding = new FormBinding(this, true);
    	  this.setSize("996px", "640px");
	  } 
	    
      private  void createPayrP410002Form() { 
		    
		  topInsrP210005Bar = new ButtonBar();    
		  topInsrP210005Bar.setAlignment(HorizontalAlignment.RIGHT);
		  	
		  btnInsrP210005Print = new Button("인쇄"); 
		  btnInsrP210005Print.setIcon(MSFMainApp.ICONS.print16());
		  btnInsrP210005Print.addListener(Events.Select, new Listener<ButtonEvent>() {
	          public void handleEvent(ButtonEvent e) {	        	 
	        	  Insr2100Print("INSRT2100",MSFMainApp.getMsg("PayGen.ReportDivisionType"));
	          }
	      });
		  topInsrP210005Bar.add(btnInsrP210005Print);
		  	
		  btnInsrP210005Excel = new Button("엑셀"); 
		  btnInsrP210005Excel.setIcon(Resources.APP_ICONS.excel16());
		  btnInsrP210005Excel.addListener(Events.Select, new Listener<ButtonEvent>() {
	          public void handleEvent(ButtonEvent e) {
	        	  excelFileExport();
	          }
	      });
		  topInsrP210005Bar.add(btnInsrP210005Excel);  
		  	
		  cpInsr2101.add(topInsrP210005Bar);    			   
		  cpInsr2101.setSize("976px", "640px"); 
	  }
      
      //Insr2100Print	   
      private void Insr2100Print(String fileName, String repType) {

    	  if (PayGenConst.REPORT_DIV_TYPE02.equals(repType)) {
    		 // RdaPrint(fileName);
    	  } else  if (PayGenConst.REPORT_DIV_TYPE01.equals(repType)) {
    		  RexPrint(fileName);
    	  } else {
    		  com.google.gwt.user.client.Window.alert("출력 타입 오류(프로퍼티설정확인)!" + repType);
    	  }
      }


      private void RexPrint(String fileName) {

    	  printFileName = new String();
    	  printFileName = fileName;
    	  systemKeys = new String();
    	  systemKeys = MSFSharedUtils.allowNulls(systemkey.getValue());
    	  
    	  if(payrMangDeptCd.getValue() != null && !payrMangDeptCd.getValue().equals("") && emymtDivCd.getValue() != null && !emymtDivCd.getValue().equals("")){
				if(emymtDivCd.getValue().equals("A0020010")){
				}else if(emymtDivCd.getValue().equals("A0020020")){
					if(deptCd.getValue() == null || deptCd.getValue().equals("")){
						com.google.gwt.user.client.Window.alert("부서를 선택해 주세요");
						return;
					}	
					if(businCd.getValue() == null || businCd.getValue().equals("")){	
						com.google.gwt.user.client.Window.alert("사업을 선택해 주세요");
						return;
					}
				}else{
					com.google.gwt.user.client.Window.alert("고용구분을 선택해 주세요");
					return;
				}
			}else{
				com.google.gwt.user.client.Window.alert("단위기관/고용구분을 선택해 주세요");
				return;
			}


    	  //그리드 선택 데이터 출력
    	  String checkedSystemKeys = "";
    	  int keyCnt = 0;
    	  List<BaseModel> list = insr1100GridPanel.getGrid().getSelectionModel().getSelectedItems();
    	  
    	  if(list != null && list.size() > 0){
    		  String chkSysKey = "";
    		  int iCnt = 0;

    		  for(BaseModel bm : list){
    			  chkSysKey += bm.get("systemkey")+",";					
    			  iCnt = iCnt + 1;
    		  }
    		  keyCnt = iCnt;
    		  checkedSystemKeys = chkSysKey.substring(0,chkSysKey.length()-1); //$10 시스템키   

    		  //시스템키는 넘기지 않고 검색조건만 넘김	
    		  if(keyCnt > 200) {
    			  MessageBox.confirm("알림", "대상자를 200명 이상 선택할 경우 전체출력합니다.",new Listener<MessageBoxEvent>(){
    				  @Override
    				  public void handleEvent(MessageBoxEvent be) {
    					 // if("Yes".equals(be.getButtonClicked().getText())){
    					  if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
    						  systemKeys = "";
    					  }else {
    						  return;
    					  }
    				  }
    			  });
    			  //선택한 시스템키 넘김
    		  }else {
    			  systemKeys = checkedSystemKeys;
    		  }

    	  }else{
    		  systemKeys = "";
    	  }    	  

    	  BaseModel baseModel = new BaseModel();
    	  baseModel.set("soctyInsurCmptnDt01", MSFSharedUtils.allowNulls(soctyInsurCmptnDt01.getValue()));
    	  baseModel.set("soctyInsurCmptnDt02", MSFSharedUtils.allowNulls(soctyInsurCmptnDt02.getValue()));
    	  baseModel.set("payrMangDeptCd", MSFSharedUtils.allowNulls(payrMangDeptCd.getValue()));
    	  baseModel.set("emymtDivCd", MSFSharedUtils.allowNulls(emymtDivCd.getValue()));
    	  baseModel.set("deptCd", MSFSharedUtils.allowNulls(deptCd.getValue()));
    	  baseModel.set("typOccuCd", MSFSharedUtils.allowNulls(typOccuCd.getValue()));
    	  baseModel.set("dtilOccuInttnCd", MSFSharedUtils.allowNulls(dtilOccuInttnCd.getValue()));
    	  baseModel.set("businCd", MSFSharedUtils.allowNulls(businCd.getValue()));
    	  baseModel.set("systemkey", MSFSharedUtils.allowNulls(systemKeys));
    	  baseModel.set("hanNm", MSFSharedUtils.allowNulls(hanNm.getValue()));
    	  baseModel.set("resnRegnNum", MSFSharedUtils.allowNulls(resnRegnNum.getValue()));		   
    	  baseModel.set("hdofcCodtnCd", MSFSharedUtils.allowNulls(hdofcCodtnCd.getValue())); 


    	  actionDatabase = ActionDatabase.UPDATE;
    	  insr2100Service.activityOnUpdateInsr1200(baseModel,  new AsyncCallback<Long>() {

    		  public void onFailure(Throwable caught) {
    			  MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
    					  MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnUpdateInsr2100(Save) : " + caught), null);
    		  }
    		  public void onSuccess(Long result) {  
    			  if (result == 0) {
    				  MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
    			  } else {
    				  //MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), actionDatabase + "처리가 완료되었습니다.", null);
    				  RexPrint2(printFileName);

    			  } 
    		  } 
    	  });

    	  RexPrint2(printFileName);
      }

      //rex 
      private void RexPrint2(String fileName) {

    	  // 출력물 디렉토리 패스경로 인사 : PSNL  //  급여 : PAYR // 보험 : INSR
    	  String strDirPath = "INSR";
    	  // mrd 출력물
    	  String rexFileName = fileName+".crf";
    	  // 보낼 파라미터  
    	  // 검색조건
    	  String serarchParam = "";


    	  if(soctyInsurCmptnDt01 != null && !"".equals(soctyInsurCmptnDt01)){

    		  //도장 출력을 위해 추가 2014-11-06 //$9
    		  String myImgUrl = MSFMainApp.getMsg("PayGen.MyPhotoUrl");
    		  if(MSFSharedUtils.paramNull(myImgUrl)) {
    			  // myImgUrl = "http://105.19.10.32:8080";
    			  //경로오류 출력 
    		  }	

    		  serarchParam += ""+MSFSharedUtils.allowNulls( MSFMainApp.get().getUser().getDpobCd())+"⊥";//$1
    		  serarchParam += ""+MSFSharedUtils.allowNulls(soctyInsurCmptnDt01.getValue())+"⊥";	//$2			
    		  serarchParam += ""+MSFSharedUtils.allowNulls(soctyInsurCmptnDt02.getValue())+"⊥";	//$3			
    		  serarchParam += ""+MSFSharedUtils.allowNulls(payrMangDeptCd.getValue())+"⊥";		//$4
    		  serarchParam += ""+MSFSharedUtils.allowNulls(emymtDivCd.getValue())+"⊥";		//$5
    		  serarchParam += ""+MSFSharedUtils.allowNulls(deptCd.getValue())+"⊥";			//$6	
    		  serarchParam += ""+MSFSharedUtils.allowNulls(typOccuCd.getValue())+"⊥";			//$7
    		  serarchParam += ""+MSFSharedUtils.allowNulls(dtilOccuInttnCd.getValue())+"⊥";			 //$8
    		  serarchParam += ""+MSFSharedUtils.allowNulls(businCd.getValue())+"⊥";   //$9

    		  serarchParam += ""+MSFSharedUtils.allowNulls(systemKeys)+"⊥";	//$10
    		  serarchParam += ""+MSFSharedUtils.allowNulls(hanNm.getValue())+"⊥";		//$11
    		  serarchParam += ""+MSFSharedUtils.allowNulls(resnRegnNum.getValue())+"⊥";		//$12	
    		  serarchParam += ""+MSFSharedUtils.allowNulls(hdofcCodtnCd.getValue())+"⊥";		//$13				 			        

    		  //20151212-변경추가 시작 
    		  serarchParam += ""+MSFMainApp.get().getUser().getUsrId()+"⊥";  //$14 //유우져 아이디 넘김 
    		  serarchParam += ""+MSFMainApp.get().getUser().getPayrMangDeptYn()+"⊥"; //$15

    		  //권한처리를위해 넘기는 변수 2개추가 
    		  serarchParam += ""+MSFSharedUtils.allowNulls(deptCdAuth.getValue())+"⊥"; //$16 부서 
    		  serarchParam += ""+MSFSharedUtils.allowNulls(dtilOccuInttnCdAuth.getValue())+"⊥"; //$17 직종세 
    		  //20151212-추가 끝 
    		  serarchParam += ""+MSFSharedUtils.allowNulls(myImgUrl)+"⊥"; //$18

    		  String strParam = "" + serarchParam; //+"["+checkedSystemKeys+"]"; 

    		  //GWT 타입으로 팝업 호출시  postCall true 설정
    		  PrintUtils.setPostCall(true);
    		  PrintUtils.rexPrint(strDirPath, rexFileName, strParam);
    	  }else{
    		  MessageBox.alert("", "작성기간 시작일을 선택하여 주세요.", null);
    	  }
      }

    //엑셀 저장
      private void excelFileExport() {
    	  HashMap<String, String> param = new HashMap<String, String>(); 
			
			
			systemKeys = new String();
			systemKeys = MSFSharedUtils.allowNulls(systemkey.getValue());
			
			//그리드 선택 데이터 출력
			String checkedSystemKeys = "";
			int keyCnt = 0;
			List<BaseModel> list = insr1100GridPanel.getGrid().getSelectionModel().getSelectedItems();

			if(list != null && list.size() > 0){
				String chkSysKey = "";
				int iCnt = 0;

				for(BaseModel bm : list){
					chkSysKey += bm.get("systemkey")+",";
					iCnt = iCnt + 1;
				}
				keyCnt = iCnt;
				checkedSystemKeys = chkSysKey.substring(0,chkSysKey.length()-1); //$10 시스템키   

				//시스템키는 넘기지 않고 검색조건만 넘김	
				if(keyCnt > 200) {
					MessageBox.confirm("알림", "대상자를 200명 이상 선택할 경우 전체출력합니다.",new Listener<MessageBoxEvent>(){
						@Override
						public void handleEvent(MessageBoxEvent be) {
							// TODO Auto-generated method stub
							//if("Yes".equals(be.getButtonClicked().getText())){
							if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
								systemKeys = "";
							}else {
								return;
							}
						}
					});
					//선택한 시스템키 넘김
				}else {
					systemKeys = checkedSystemKeys;
				}

			}
    	  
    	  
    	 
    	  
    	  param.put("soctyInsurCmptnDt01",  soctyInsurCmptnDt01.getValue());
    	  param.put("soctyInsurCmptnDt02",  soctyInsurCmptnDt02.getValue());
    	  param.put("hdofcCodtnCd", hdofcCodtnCd.getValue()); //재직상태 
    	  param.put("payrMangDeptCd", payrMangDeptCd.getValue());		//단위기관
    	  param.put("hanNm", hanNm.getValue()); //성명
    	  param.put("resnRegnNum", resnRegnNum.getValue()); //주민번호    
    	  param.put("emymtDivCd", emymtDivCd.getValue()); //고용구분
    	  param.put("deptCd", deptCd.getValue()); //부서

    	  if(null == typOccuCd.getValue())
    		  param.put("typOccuCd", "");
    	  else
    		  param.put("typOccuCd", typOccuCd.getValue());


    	  if(null == dtilOccuInttnCd.getValue())
    		  param.put("dtilOccuInttnCd", "");
    	  else
    		  param.put("dtilOccuInttnCd", dtilOccuInttnCd.getValue());

    	  param.put("businCd", businCd.getValue()); //사업
    	  param.put("systemkey", MSFSharedUtils.allowNulls(systemKeys));
    	  param.put("valDiv", "all"); // 엑셀 출력 구분자 (all, 1, 2, 3, 4 >> 전체, 국민, 건강, 고용, 산재)
    	  //insr1100GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsFileInsrP210005Export.do","extgwtFrame" ,param);

    	  insr1100GridPanel.callXlsExportServlet(GWT.getHostPageBaseURL() + "exp/XlsFileInsr2100Export.do","extgwtFrame" ,param);
	  }

      //검색기본정보 	  
      private  void createInfoForm() {   
	  
    	  dpobCd = new HiddenField<String>();  //사업장코드 
    	  dpobCd.setName("dpobCd");
    	  cpInsr2101.add(dpobCd);
	   
    	  payrMangDeptCd = new  HiddenField<String>(); 
    	  payrMangDeptCd.setName("payrMangDeptCd");
    	  cpInsr2101.add(payrMangDeptCd); 
      
    	  emymtDivCd = new HiddenField<String>();
    	  emymtDivCd.setName("emymtDivCd");
    	  cpInsr2101.add(emymtDivCd);
	         
    	  deptCd = new HiddenField<String>();  //시스템키 
    	  deptCd.setName("deptCd");
    	  cpInsr2101.add(deptCd);
	   
    	  typOccuCd = new HiddenField<String>();  /**  column 직종코드 : typOccuCd */
    	  typOccuCd.setName("typOccuCd");
    	  cpInsr2101.add(typOccuCd);
       
    	  //pyspGrdeCd = new HiddenField<String>();  //사업장코드 
    	  //pyspGrdeCd.setName("pyspGrdeCd");
    	  //cpInsr2101.add(pyspGrdeCd);
     
    	  businCd = new  HiddenField<String>(); 
    	  businCd.setName("businCd");
    	  cpInsr2101.add(businCd);
       
    	  dtilOccuInttnCd = new HiddenField<String>();  //사업장코드 
    	  dtilOccuInttnCd.setName("dtilOccuInttnCd");
    	  cpInsr2101.add(dtilOccuInttnCd);
       
    	  hdofcCodtnCd = new HiddenField<String>();  //재직구분코드 
    	  hdofcCodtnCd.setName("hdofcCodtnCd");
    	  cpInsr2101.add(hdofcCodtnCd);
       
    	  //idtlAccdtInsurApptnYn = new HiddenField<Boolean>() ; 
    	  //logSvcExtpyApptnYn =  new HiddenField<Boolean>() ;

    	  businCd = new HiddenField<String>();  //사업장코드 
    	  businCd.setName("businCd");
    	  cpInsr2101.add(businCd);
       
    	  systemkey = new HiddenField<String>();  //시스템키 
    	  systemkey.setName("systemkey");
    	  cpInsr2101.add(systemkey);
       
    	  hanNm = new HiddenField<String>();  //시스템키 
    	  hanNm.setName("hanNm");
    	  cpInsr2101.add(hanNm);
      
    	  resnRegnNum = new HiddenField<String>();  //시스템키 
    	  resnRegnNum.setName("resnRegnNum");
    	  cpInsr2101.add(resnRegnNum); 
    	  
    	  secRegnNum = new HiddenField<String>();  //시스템키 
    	  secRegnNum.setName("secRegnNum");
    	  cpInsr2101.add(secRegnNum); 

    	  deptCdAuth = new HiddenField<String>();
    	  deptCdAuth.setName("deptCdAuth");
    	  cpInsr2101.add(deptCdAuth);

    	  dtilOccuInttnCdAuth = new HiddenField<String>();
    	  dtilOccuInttnCdAuth.setName("dtilOccuInttnCdAuth");
    	  cpInsr2101.add(dtilOccuInttnCdAuth);

    	  srhRepbtyBusinDivCd = new HiddenField<String>();  //시스템키 
    	  srhRepbtyBusinDivCd.setName("srhRepbtyBusinDivCd");
    	  cpInsr2101.add(srhRepbtyBusinDivCd); 
    	  
    	  srhDeptGpCd = new HiddenField<String>();  //시스템키 
    	  srhDeptGpCd.setName("srhDeptGpCd");
    	  cpInsr2101.add(srhDeptGpCd); 
    	  
    	  
    	  FieldSet fieldSet1 = new FieldSet();  
    	  fieldSet1.setHeadingHtml("기본정보");
	    
    	  LayoutContainer lcSchCol1 = new LayoutContainer();
    	  lcSchCol1.setLayout(new ColumnLayout()); 
	   
    	
    	  LayoutContainer layoutContainer_6 = new LayoutContainer(); 
    	  layoutContainer_6.setLayout(new ColumnLayout()); 
    	 
	   
    	  LayoutContainer layoutContainer1_6 = new LayoutContainer(); 
    	  FormLayout frmlytStd = new FormLayout();  
    	  frmlytStd.setLabelWidth(60); 
    	  frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    	  layoutContainer1_6.setLayout(frmlytStd);
	   
    	  soctyInsurCmptnDt01 = new TextField<String>(); 
    	  soctyInsurCmptnDt01.setName("soctyInsurCmptnDt01");
    	  soctyInsurCmptnDt01.setReadOnly(true);
    	  soctyInsurCmptnDt01.setFieldLabel("취득기간"); 
    	  layoutContainer1_6.add(soctyInsurCmptnDt01, new FormData("100%"));
    	  layoutContainer1_6.setBorders(false);

		  
    	  LayoutContainer layoutContainer2_6 = new LayoutContainer(); 
    	  frmlytStd = new FormLayout();  
    	  frmlytStd.setLabelWidth(0); 
    	  frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    	  layoutContainer2_6.setLayout(frmlytStd);
    	  
    	  soctyInsurCmptnDt02 = new TextField<String>(); 
    	  soctyInsurCmptnDt02.setName("soctyInsurCmptnDt02");
    	  soctyInsurCmptnDt02.setReadOnly(true);
    	  soctyInsurCmptnDt02.setHideLabel(true);
    	  layoutContainer2_6.add(soctyInsurCmptnDt02, new FormData("100%"));
    	  layoutContainer2_6.setBorders(false);
    	  
    	  layoutContainer_6.setBorders(false);
    	  
    	  layoutContainer_6.add(layoutContainer1_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.65));
    	  layoutContainer_6.add(layoutContainer2_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.35));
    	  
    	  

    	  
    	  LayoutContainer layoutContainer_8 = new LayoutContainer();
    	  frmlytStd = new FormLayout();  
    	  frmlytStd.setLabelWidth(60); 
    	  frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    	  layoutContainer_8.setLayout(frmlytStd);
    	  
    	  payrMangDeptNm = new TextField<String>();
    	  payrMangDeptNm.setName("payrMangDeptNm");
    	  payrMangDeptNm.setReadOnly(true);
    	  payrMangDeptNm.setFieldLabel("단위기관"); 
    	  layoutContainer_8.add(payrMangDeptNm, new FormData("100%"));
    	  layoutContainer_8.setBorders(false);
    	  
    	  
    	  
    	  LayoutContainer layoutContainer_10 = new LayoutContainer();
    	  layoutContainer_10.setLayout(new ColumnLayout());
    	  
    	  
    	  LayoutContainer layoutContainer_101 = new LayoutContainer();
    	  frmlytStd = new FormLayout();  
    	  frmlytStd.setLabelWidth(60); 
    	  frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    	  layoutContainer_101.setLayout(frmlytStd);
    	  
    	  emymtDivNm = new TextField<String>(); 
    	  emymtDivNm.setName("emymtDivNm");
    	  emymtDivNm.setReadOnly(true);
    	  emymtDivNm.setFieldLabel("고용구분"); 
    	  layoutContainer_101.add(emymtDivNm, new FormData("100%"));
    	  layoutContainer_101.setBorders(false);
    	  
    	  LayoutContainer layoutContainer_102 = new LayoutContainer();
    	  frmlytStd = new FormLayout();  
    	  frmlytStd.setLabelWidth(0); 
    	  frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    	  layoutContainer_102.setLayout(frmlytStd);
    	  
    	  srhRepbtyBusinDivNm = new TextField<String>(); 
    	  srhRepbtyBusinDivNm.setName("srhRepbtyBusinDivNm");
    	  srhRepbtyBusinDivNm.setReadOnly(true);
    	  srhRepbtyBusinDivNm.setHideLabel(true);
    	  //emymtDivNm.setFieldLabel("고용구분"); 
    	  layoutContainer_102.add(srhRepbtyBusinDivNm, new FormData("100%"));
    	  layoutContainer_102.setBorders(false);
    	  
    	  
    	  layoutContainer_10.add(layoutContainer_101, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
    	  layoutContainer_10.add(layoutContainer_102, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
    	  layoutContainer_10.setBorders(false); 
    	  
    	  fieldSet1.add(lcSchCol1);
    	  lcSchCol1.setBorders(false);
    	  
    	  lcSchCol1.add(layoutContainer_6,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
    	  lcSchCol1.add(layoutContainer_8, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
    	  lcSchCol1.add(layoutContainer_10, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));
    	  
    	 
    	  
    	  
    	  
    	  
    	  
    	  
    	 
    	  
		  LayoutContainer layoutContainer_5 = new LayoutContainer();
    	  layoutContainer_5.setLayout(new ColumnLayout());

		  
    	  LayoutContainer layoutContainer_007 = new LayoutContainer();
    	  frmlytStd = new FormLayout();  
    	  frmlytStd.setLabelWidth(60); 
    	  frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    	  layoutContainer_007.setLayout(frmlytStd);
    	  
    	  hdofcCodtnNm = new TextField<String>();
    	  hdofcCodtnNm.setName("hdofcCodtnNm");
    	  hdofcCodtnNm.setReadOnly(true);
    	  hdofcCodtnNm.setFieldLabel("재직구분"); 
    	  layoutContainer_007.add(hdofcCodtnNm, new FormData("100%"));
    	  layoutContainer_007.setBorders(false);
    	  
    	  
    	  
    	  LayoutContainer layoutContainer_11 = new LayoutContainer();
    	  frmlytStd = new FormLayout();  
    	  frmlytStd.setLabelWidth(60); 
    	  frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    	  layoutContainer_11.setLayout(frmlytStd);
    	  
    	  deptNm = new TextField<String>();
    	  deptNm.setName("deptNm");
    	  deptNm.setReadOnly(true);
    	  deptNm.setFieldLabel("부서"); 
    	  layoutContainer_11.add(deptNm, new FormData("100%"));
    	  layoutContainer_11.setBorders(false);
    	  
    	  
    	  
    	  LayoutContainer layoutContainer_100 = new LayoutContainer();
    	  layoutContainer_100.setLayout(new ColumnLayout()); 
    	  
    	  LayoutContainer layoutContainer_170 = new LayoutContainer();
    	  frmlytStd = new FormLayout();  
    	  frmlytStd.setLabelWidth(60); 
    	  frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    	  layoutContainer_170.setLayout(frmlytStd);
    	  
    	  srhDeptGpNm = new TextField<String>();
    	  srhDeptGpNm.setName("srhDeptGpNm");
    	  srhDeptGpNm.setReadOnly(true);
    	  srhDeptGpNm.setFieldLabel("직종"); 
    	  layoutContainer_170.add(srhDeptGpNm, new FormData("100%"));
    	  layoutContainer_170.setBorders(false);
    	  
    	  LayoutContainer layoutContainer_17 = new LayoutContainer();
    	  frmlytStd = new FormLayout();  
    	  frmlytStd.setLabelWidth(0); 
    	  frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    	  layoutContainer_17.setLayout(frmlytStd);
    	  
    	  typOccuNm = new TextField<String>();
    	  typOccuNm.setName("typOccuNm");
    	  typOccuNm.setReadOnly(true);
    	  typOccuNm.setHideLabel(true);
    	  //typOccuNm.setFieldLabel("직종"); 
    	  layoutContainer_17.add(typOccuNm, new FormData("100%"));
    	  layoutContainer_17.setBorders(false);
    	  
    	  LayoutContainer layoutContainer_12 = new LayoutContainer();
    	  frmlytStd = new FormLayout();  
    	  frmlytStd.setLabelWidth(0); 
    	  frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    	  layoutContainer_12.setLayout(frmlytStd);
    	  
    	  dtilOccuClsDivNm = new TextField<String>();
    	  dtilOccuClsDivNm.setName("dtilOccuClsDivNm");
    	  dtilOccuClsDivNm.setReadOnly(true);
    	  dtilOccuClsDivNm.setHideLabel(true);
    	  //dtilOccuClsDivNm.setFieldLabel("직종세"); 
    	  layoutContainer_12.add(dtilOccuClsDivNm, new FormData("100%"));
    	  layoutContainer_12.setBorders(false);
    	  
    	  layoutContainer_100.add(layoutContainer_170,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.31));
    	  layoutContainer_100.add(layoutContainer_17,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.32));
    	  layoutContainer_100.add(layoutContainer_12,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.37));

    	  fieldSet1.add(layoutContainer_5); 
    	  layoutContainer_5.setBorders(false);
    	  
    	  layoutContainer_5.add(layoutContainer_007, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
    	  layoutContainer_5.add(layoutContainer_11, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
    	  layoutContainer_5.add(layoutContainer_100,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.43));
    	  
    	
    	  
    	  
    	  
    	  
    	  
    	  LayoutContainer lcSchCol3 = new LayoutContainer();
		  lcSchCol3.setLayout(new ColumnLayout());

    	  LayoutContainer layoutContainer_3_1 = new LayoutContainer();
    	  frmlytStd = new FormLayout();  
    	  frmlytStd.setLabelWidth(60); 
    	  frmlytStd.setLabelAlign(LabelAlign.RIGHT);
    	  layoutContainer_3_1.setLayout(frmlytStd);
    	  
    	  businNm = new TextField<String>();
    	  businNm.setName("businNm"); 
    	  dtilOccuClsDivNm.setReadOnly(true);
    	  businNm.setFieldLabel("사업");   
    	  layoutContainer_3_1.add(businNm, new FormData("100%"));


    	  LayoutContainer layoutContainer_50 = new LayoutContainer();
    	  layoutContainer_50.setLayout(new ColumnLayout());

    	  
    	  
    	  
    	  LayoutContainer layoutContainer_60 = new LayoutContainer();
    	  frmlytStd = new FormLayout();  
    	  frmlytStd.setLabelWidth(60); 
    	  frmlytStd.setLabelAlign(LabelAlign.RIGHT); 
    	  layoutContainer_60.setLayout(frmlytStd);

    	  srhHanNm = new TextField<String>();
    	  srhHanNm.setName("hanNm");
    	  srhHanNm.setFieldLabel("성명");
    	  srhHanNm.setReadOnly(true);
    	  layoutContainer_60.add(srhHanNm, new FormData("100%"));
    	  layoutContainer_60.setBorders(false);


    	  LayoutContainer layoutContainer_70 = new LayoutContainer();
    	  frmlytStd = new FormLayout();  
    	  frmlytStd.setLabelWidth(0); 
    	  frmlytStd.setLabelAlign(LabelAlign.RIGHT); 
    	  layoutContainer_70.setLayout(frmlytStd);

    	  /** column 주민등록번호 : resnRegnNum */
    	  srhResnRegnNum = new TextField<String>();
    	  srhResnRegnNum.setName("resnRegnNum");
    	  new TextFieldMask<String>(srhResnRegnNum, "999999-9999999");
    	  srhResnRegnNum.setHideLabel(true);
    	  srhResnRegnNum.setReadOnly(true);
    	  layoutContainer_70.add(srhResnRegnNum, new FormData("100%"));
    	  layoutContainer_70.setBorders(false); 
    	  
    	  layoutContainer_50.setBorders(false);

    	  layoutContainer_50.add(layoutContainer_60,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
    	  layoutContainer_50.add(layoutContainer_70,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
    	  
    	  
    	  fieldSet1.add(lcSchCol3);
    	  lcSchCol3.setBorders(false);
		    
		  lcSchCol3.add(layoutContainer_3_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
		  lcSchCol3.add(layoutContainer_50,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.27));
		  
    	  
    	  cpInsr2101.add(fieldSet1);  
      }
      
      // grid form
      //4대보험금액산정내역
      private  void createStandardForm() {
			LayoutContainer layoutContainer = new LayoutContainer();
			layoutContainer.setLayout(new ColumnLayout());
			
			LayoutContainer layoutContainer_2 = new LayoutContainer();
			FormLayout frmlytStd = new FormLayout();  
			frmlytStd.setLabelWidth(0); 
			frmlytStd.setLabelAlign(LabelAlign.RIGHT);
			layoutContainer_2.setLayout(frmlytStd);
			
			FieldSet fldstNewFieldset_2 = new FieldSet();
			layoutContainer_2.add(fldstNewFieldset_2);
			fldstNewFieldset_2.setHeadingHtml("4대보험금액산정내역");
			fldstNewFieldset_2.setCollapsible(false);
			fldstNewFieldset_2.add(createCheckBoxGrid(),new FormData("100%"));
			
			layoutContainer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
			layoutContainer_2.setBorders(false);
			    
			cpInsr2101.add(layoutContainer);
			layoutContainer.setBorders(false); 
		  } 
	  
      //grid
      //헤더
	  private LayoutContainer createCheckBoxGrid() {
		  LayoutContainer lcStdGrid = new LayoutContainer();
		  
		  ContentPanel cp01 = new ContentPanel();
		  cp01.setBodyBorder(false);
		  cp01.setHeaderVisible(false);
		  cp01.setLayout(new FitLayout());
		  cp01.setSize(960, 500);  
		  
		  insr1100GridPanel = new MSFGridPanel(insr1100Def, false, false, false, false, false);
		  insr1100GridPanel.setHeaderVisible(false);
		  insr1100GridPanel.setBodyBorder(true);
		  insr1100GridPanel.setBorders(true);
		  //insr1100GridPanel.setAutoSelectFirstRecord(true);
		  insr1100GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 1, new HeaderGroupConfig("", 1, 9));
		  insr1100GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 10, new HeaderGroupConfig("국민", 1, 6));
		  insr1100GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 16, new HeaderGroupConfig("건강", 1, 9));
		  insr1100GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 25, new HeaderGroupConfig("고용", 1, 9));
		  insr1100GridPanel.getGrid().getColumnModel().addHeaderGroup(0, 34, new HeaderGroupConfig("산재", 1, 9));
		  
		  final Grid<?> insr1100Grid = insr1100GridPanel.getMsfGrid().getGrid(); 
		  insr1100Grid.addListener(Events.RowClick,  new Listener<BaseEvent>() {
			  public void handleEvent(BaseEvent be) {
				  if (insr1100GridPanel.getCurrentlySelectedItem() != null) {
				  }
			  }
		  });  
		  cp01.add(insr1100GridPanel);
		  
		  lcStdGrid.add(cp01);
		  return lcStdGrid;
		  }   
	  
	  //bind
	  public void bind(final ModelData model) { 
	        formBinding.bind(model);
	        formBinding.addListener(Events.Bind, new Listener<BaseEvent>() {
	            //@Override
	            public void handleEvent(BaseEvent be) {
	            	reload();
	            }
	        });
	  }
	  
	  //reload
	  public void reload() {
		  
		  IColumnFilter filters = null;
		  //insr1100GridPanel.getGrid().clearState();
		  insr1100GridPanel.getTableDef().setTableColumnFilters(filters);
		  
		  insr1100GridPanel.getTableDef().addColumnFilter("soctyInsurCmptnDt01", MSFSharedUtils.allowNulls(soctyInsurCmptnDt01.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		  insr1100GridPanel.getTableDef().addColumnFilter("soctyInsurCmptnDt02", MSFSharedUtils.allowNulls(soctyInsurCmptnDt02.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		  insr1100GridPanel.getTableDef().addColumnFilter("payrMangDeptCd", MSFSharedUtils.allowNulls(payrMangDeptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		  insr1100GridPanel.getTableDef().addColumnFilter("emymtDivCd", MSFSharedUtils.allowNulls(emymtDivCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		  insr1100GridPanel.getTableDef().addColumnFilter("deptCd", MSFSharedUtils.allowNulls(deptCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		  insr1100GridPanel.getTableDef().addColumnFilter("typOccuCd", MSFSharedUtils.allowNulls(typOccuCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		  insr1100GridPanel.getTableDef().addColumnFilter("dtilOccuInttnCd", MSFSharedUtils.allowNulls(dtilOccuInttnCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		  insr1100GridPanel.getTableDef().addColumnFilter("businCd", MSFSharedUtils.allowNulls(businCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		  insr1100GridPanel.getTableDef().addColumnFilter("systemkey", MSFSharedUtils.allowNulls(systemkey.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		  insr1100GridPanel.getTableDef().addColumnFilter("hanNm", MSFSharedUtils.allowNulls(hanNm.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		  insr1100GridPanel.getTableDef().addColumnFilter("resnRegnNum", MSFSharedUtils.allowNulls(resnRegnNum.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		  insr1100GridPanel.getTableDef().addColumnFilter("hdofcCodtnCd", MSFSharedUtils.allowNulls(hdofcCodtnCd.getValue()), SimpleColumnFilter.OPERATOR_EQUALS);
		  
          insr1100GridPanel.reload();
			
          
          
          //actionDatabase = ActionDatabase.READ; 
	  }
	  
	  
	  
	  
	  
	  private  LayoutContainer occupationalTop() {

		  LayoutContainer lcTabFormLayer = new LayoutContainer();

		  ContentPanel cp01 = new ContentPanel();   
	  	  cp01.setBodyBorder(false); 
	  	  cp01.setHeaderVisible(false);   
	  	  cp01.setLayout(new FitLayout());      
	  	  cp01.setSize(864, 140);   
	  	  
	  	  lcTabFormLayer.add(cp01); 
	 	      
	  	  return lcTabFormLayer;
	  } 
	  
			
	  //폼초기화 검색조건포함 
	  private void formInit() {
		  subformInit();
		  //  insr1100GridPanel.getMsfGrid().clearData();
		  actionDatabase = ActionDatabase.READ;
	  }
	  
		   
	  private void subformInit() {
		  //grid init 
		  //payr0302ExtpyGridPanel.getMsfGrid().clearData();
		  //payr0302DducGridPanel.getMsfGrid().clearData(); 
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
