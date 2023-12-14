package com.app.exterms.payroll.client.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0450DTO;
import com.app.exterms.payroll.client.form.defs.Payr0450Def;
import com.app.exterms.payroll.client.form.defs.Payr0480Def;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.client.lookup.LookupPayr0415PayYr;
import com.app.exterms.payroll.client.service.Payr5600Service;
import com.app.exterms.payroll.client.service.Payr5600ServiceAsync;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.def.RelationDef;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.generics.MSFCustomForm;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTextField;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.core.XTemplate;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.store.Store;
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
import com.extjs.gxt.ui.client.widget.form.FormPanel.Encoding;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.FormPanel.Method;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr5600  extends MSFPanel { 




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
		  private FormPanel plFrmPayr5600;
		  //private FormData formData; 
		  private String txtForm = "";
		  private XTemplate detailTp; 
		   
		  
		  private Payr0450Def payr0450To0480Def  = new Payr0450Def("PAYR0480");   //그리드 테이블 컬럼 define  
		      // private MSFCustomForm msfCustomForm; 
		  private MSFGridPanel payr0450To0480GridPanel;

		  
		  private Payr0450Def payr0450Def  = new Payr0450Def("PAYR0450");   //그리드 테이블 컬럼 define  
		  private MSFCustomForm msfCustomForm; 
		  private MSFGridPanel payr0450GridPanel;


	      private LookupPayr0415PayYr lkApptnYr = new LookupPayr0415PayYr();  
	      private MSFGridPanel payYrGridPanel;
	      

		  private Payr0480Def lkPayr0480Def  = new Payr0480Def("PAYR5600");   //공제 그리드 테이블 컬럼 define  
	      // private MSFCustomForm msfCustomForm; 
	      private MSFGridPanel payr0480GridPanel;
	      
	      //권한 설정 객체 
		  private GWTAuthorization gwtAuthorization;
		  private GWTExtAuth gwtExtAuth;
		  private  boolean maskTracker = false;  //초기화 로딩 팝업 강제 unmask 처리 
	      
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
      private ButtonBar topPayr5600Bar;
      private Button btnPayr5600Init;
   //   private Button btnPayr5600Save;
   //   private Button btnPayr5600Del;
      private Button btnPayr5600Sreach;
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 검색변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
      /** column  년도 : payYr */
      private ComboBox<BaseModel> srhPayYr;
      private ComboBox<BaseModel> srhPayExtpyCd;   //수당 
      /**
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       * 입력 변수 선언 
       * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
       */
      private HiddenField<String> dpobCd;  //사업장코드 
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역변수 선언부  종료
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/	  
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
		  private void checkPayr5600Auth( String authAction, ListStore<BaseModel> bm) {   
	    	   //MSFMainApp.maskMainPage("[화면로딩] 초기화 진행 중"); 
			 
			  if (MSFSharedUtils.paramNotNull(gwtExtAuth.getCheckMapDef()) && gwtExtAuth.checkExtAuth(authAction, bm )) {
			   
				  if (!maskTracker) { unmask(); }  
	                //MSFMainApp.unmaskMainPage();
				   //----------------------------------------------------
		          // Field<?>[] fldArrField = {};
				  authExecEnabled() ;
				  // gwtAuthorization.formAuthFieldConfig(fldArrField);
		           gwtExtAuth.setCheckMapDef(null); //로딩완료 후 초기화      
		     
			   }
		  }
		  private void authExecEnabled() { 
			   //------------------
			    
	           Date today = new Date(); 
       	     // A custom date format
       	       DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy"); 
       	
     	      srhPayYr.setValue(lsPayYrStore.findModel("payYr", fmt.format(today) ));
                
			 }

		   final Timer tmMask = new Timer()
		     {
		           public void run()
		           {
		              // if (maskTracker)
		              // { 
		        	   if (lsPayYrStore.getCount() > 0 ) {
		        		   
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
				  
				 gwtExtAuth.setCheckMapDef(authMapDef);
		        
		        if (Boolean.FALSE.equals(gwtExtAuth.getLoadCheck())) {
		        	  //권한 검색조건처리를 위해 추가된 부분 
					  mask("[화면로딩] 초기화 진행 중!");
	        	}
		        tmMask.scheduleRepeating(3000);
		  }
	       
	     
	  /**
	   *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	   * 	권한설정 관련 함수 및 선언 종료 (권한 적용필요시 추가해야함.)
	   *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
	   **/	
/**
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 * 	전역함수 선언부 시작
 *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
 **/
   // 검색 폼 바인딩 처리 함수 
      
	   //화면 폼 바인딩 처리 
	    private void setPayr5600FormBinding() {
	 	 
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
	private Payr5600ServiceAsync payr5600Service = Payr5600Service.Util.getInstance();	    
	private ListStore<BaseModel> lsPayYrStore = new ListStore<BaseModel>();
	  
	private ListStore<BaseModel>  lsPayExtpyCd = new ListStore<BaseModel>(); //수당 
	
	private BaseModel record; 

    private Iterator<Record> records;
    
	/**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 조회처리부
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */  
//    private void readPayr5600(){
//    	payr0301GridPanel.mask(MSFMainApp.MSFMESSAGES.LoadingData());
//    	
//    	//검색조건 넘김 
//    	bass0200Dto.setPubcHodyCtnt(srhPubcHodyCtnt.getValue());
//        //LOOP QUESTIONARI
//    	bass0200Service.selectPayr5600List(bass0200Dto, new AsyncCallback<List<Payr5600BM>>(){
//            public void onFailure(Throwable caught) {
//                MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("selectPayr5600(): "+caught), null);
//                msfPayr5600GridPanel.unmask(); 
//            }
//
//            public void onSuccess(List<Payr5600BM> result) {
//            	composedPayr5600List(result);
//            }
//        });
//    }
    
    //조회처리부
//    private void composedPayr5600List(List<Payr5600BM> listaMenu) {
//        Iterator<Sysm0200BM> iter = listaMenu.iterator();
//        BaseTreeModel folder = new BaseTreeModel();
//        BaseTreeModel category = null;
//        while ( iter.hasNext() ) {
//        	Sysm0200BM mnu = iter.next();
//            Integer ord = new Integer(mnu.getMnuPrntOrd().intValue());
//            BaseTreeModel bm = new BaseTreeModel();
//            bm.set("sysDivCd", mnu.getSysDivCd());
//            bm.set("mnuCd", mnu.getMnuCd());
//            bm.set("hhrkMnuCd", mnu.getHhrkMnuCd());
//            bm.set("mnuNm", mnu.getMnuNm());
//            bm.set("mnuIcn", mnu.getMnuIcn()); 
//            bm.set("mnuTmbl", mnu.getMnuTmbl());
//            bm.set("mnuAuthFrmCd", mnu.getMnuAuthFrmCd());
//            bm.set("mnuTipNm", mnu.getMnuTipNm());
//            bm.set("mnuScnFrmPkgNm", mnu.getMnuScnFrmPkgNm());
//            bm.set("mnuPrntYn", mnu.getMnuPrntYn());
//            bm.set("mnuPrntOrd", ord);
//            bm.set("useYn", mnu.getUseYn());
//            bm.set("mnuEpln", mnu.getMnuEpln());
//             
//            if (mnu.getHhrkMnuCd() == null) {
//                category = new BaseTreeModel();
//                category.setProperties(bm.getProperties());
//                folder.add(category);
//            } else {
//                if (category != null) {
//                    category.add(bm);
//                }
//            }
//        } 
//        msfPayr5600GridPanel.unmask();  
//    }
     
    /**
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * 선택된 버튼에 따른 인서트 업데이트 삭제 처리 부
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     */  
//    private SelectionListener<ButtonEvent> selectionListener = 
//	        new SelectionListener<ButtonEvent>() {
//	        public void componentSelected(ButtonEvent ce) { 
//	            if (ce.getButton() == btnPayr5600Save) {
//	                doAction(ActionDatabase.INSERT);
//	            } else if (ce.getButton() == btnPayr5600Save) {
//	                doAction(ActionDatabase.UPDATE);
//	            } else if (ce.getButton() == btnPayr5600Del) {
//	                doAction(ActionDatabase.DELETE);
//	            }
//
//	        }  
//	    };
	  
    private void doAction(ActionDatabase actionDatabase) {
        switch (actionDatabase) {
        case INSERT: 
            this.actionDatabase = ActionDatabase.INSERT;
            savePayr5600();
            break;
        case UPDATE:
            this.actionDatabase = ActionDatabase.UPDATE; 
            savePayr5600();
            break;
        case DELETE:
            this.actionDatabase = ActionDatabase.DELETE;
			MessageBox.confirm("경고", "해당 수당 정보를 삭제하겠습니까?</br> (삭제된 데이터는 복구되지 않습니다.)",new Listener<MessageBoxEvent>(){
				@Override
				public void handleEvent(MessageBoxEvent be) {
					//if("Yes".equals(be.getButtonClicked().getText())){
					if(Dialog.YES.equals(be.getButtonClicked().getItemId())){
						 savePayr5600(); 
					}
				}
			});
            break;
        }
    } 

    private void savePayr5600() { 
        
        if (MSFSharedUtils.paramNotNull(records))  { 
            
            List<Payr0450DTO> listPayr0450dto = new ArrayList<Payr0450DTO>();  
            
            while (records.hasNext()) {
          
                Record record = (Record) records.next(); 
                BaseModel bmMapModel = (BaseModel)record.getModel();
                  
                Payr0450DTO payr0450Dto = new Payr0450DTO();  
            
                
                payr0450Dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
                payr0450Dto.setPayYr(MSFSharedUtils.allowNulls(bmMapModel.get("payYr")));    /** column 급여년도 : payYr */
                payr0450Dto.setPayItemCd(MSFSharedUtils.allowNulls(bmMapModel.get("payItemCd")));    /** column 급여항목코드 : payItemCd */
                payr0450Dto.setPayPymtItemListSeilNum((Long)bmMapModel.get("payPymtItemListSeilNum"));    /** column 항목수당일련번호 : payPymtItemListSeilNum */
                payr0450Dto.setItemExtpyDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("itemExtpyDivCd")));    /** column 항목수당구분코드 : itemExtpyDivCd */
                payr0450Dto.setStyrNum((Long)bmMapModel.get("styrNum"));    /** column 시작년수 : styrNum */
                payr0450Dto.setEdyrNum((Long)bmMapModel.get("edyrNum"));    /** column 종료년수 : edyrNum */
                payr0450Dto.setPymtDducRate((Double)bmMapModel.get("pymtDducRate"));    /** column 지급공제율 : pymtDducRate */
                payr0450Dto.setPymtDducSum((Long)bmMapModel.get("pymtDducSum"));    /** column 지급공제금액 : pymtDducSum */
                payr0450Dto.setItemListExtpyDelYn((Boolean)bmMapModel.get("itemListExtpyDelYn"));    /** column 항목별수당삭제여부 : itemListExtpyDelYn */
                payr0450Dto.setRmak(MSFSharedUtils.allowNulls(bmMapModel.get("rmak")));    /** column 항목별수당비고내용 : rmak */
//                payr0450Dto.setKybdr(MSFSharedUtils.allowNulls(bmMapModel.get("kybdr")));    /** column 입력자 : kybdr */
//                payr0450Dto.setInptDt(MSFSharedUtils.allowNulls(bmMapModel.get("inptDt")));    /** column 입력일자 : inptDt */
//                payr0450Dto.setInptAddr(MSFSharedUtils.allowNulls(bmMapModel.get("inptAddr")));    /** column 입력주소 : inptAddr */
//                payr0450Dto.setIsmt(MSFSharedUtils.allowNulls(bmMapModel.get("ismt")));    /** column 수정자 : ismt */
//                payr0450Dto.setRevnDt(MSFSharedUtils.allowNulls(bmMapModel.get("revnDt")));    /** column 수정일자 : revnDt */
//                payr0450Dto.setRevnAddr(MSFSharedUtils.allowNulls(bmMapModel.get("revnAddr")));    /** column 수정주소 : revnAddr */

                 
                listPayr0450dto.add(payr0450Dto);
              
            }  
            
            payr5600Service.activityOnPayr5600(listPayr0450dto, actionDatabase, new AsyncCallback<Long>(){
                public void onFailure(Throwable caught) {
                    MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                            MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnPayr5600(" + actionDatabase.name() + ") : " + caught), null);
                }
                public void onSuccess(Long result) { 
                   if (result == 0) {
                       MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
                               actionDatabase + "처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
                   } else {
                       MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), 
                               actionDatabase + "처리가 완료되었습니다.", null);
                       reload();
                       actionDatabase = ActionDatabase.UPDATE;
                   } 
                } 
                 
            }); 
        } else {
            MessageBox.alert(actionDatabase.name() + "선택", actionDatabase.name() +  "처리할 데이타가 존재하지 않습니다.", null);
            return;
        }

}   
	
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
//	private void Payr5600Print(String fileName) {
// 
//		// 출력물 디렉토리 패스경로 인사 : PSNL
//		String strDirPath = "PAYR";
//		// mrd 출력물
//		String rdaFileName = fileName+".mrd";
//		// 보낼 파라미터
//		
//		
//		//검색조건
// 	String serarchParam = "";
////		
////		String name = searchName.getValue() == null ? "" : searchName.getValue();
////		String resn = searchResnRegnNum.getValue() == null ? "" : searchResnRegnNum.getValue();
////		String hdofcCodtnCd = PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchHdofcCodtnCd, "commCd"); //재직구분
////		//String manageDeptCd = PersonalUtil.getSelectedComboValue(searchManageDeptCd, "mangeDeptCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchManageDeptCd, "mangeDeptCd"); //관리부서
////		String deptCd = PersonalUtil.getSelectedComboValue(searchDeptCd, "deptCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchDeptCd, "deptCd"); //소속부서
////		String typOccuCd = PersonalUtil.getSelectedComboValue(searchTypOccuCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchTypOccuCd, "commCd"); //직종
////		String emymtDivCd = PersonalUtil.getSelectedComboValue(searchEmymtDivCd, "commCd") == null ? "" : PersonalUtil.getSelectedComboValue(searchEmymtDivCd, "commCd"); //고용구분
////		
////		serarchParam += "["+name+"]";
////		serarchParam += "["+resn+"]";
////		serarchParam += "["+hdofcCodtnCd+"]";
////		serarchParam += "[]";
////		//serarchParam += "["+manageDeptCd+"]";
////		serarchParam += "["+deptCd+"]";
////		serarchParam += "["+emymtDivCd+"]";
////		serarchParam += "["+typOccuCd+"]";
//		
//		List<BaseModel> list = payr0301GridPanel.getGrid().getSelectionModel().getSelectedItems();
//		String checkedSystemKeys = "";
//		if(list != null && list.size() > 0){
//			String chkkey = "";
//			for(BaseModel bm : list){
//				chkkey += "'"+bm.get("systemkey")+"',";
//			}
//			
//			checkedSystemKeys = chkkey.substring(0,chkkey.length()-1);
//			
//		}
//		String strParam = "/rp " + serarchParam+"["+checkedSystemKeys+"]";
//		
//		//System.out.println(strParam);
//		
//		//String strParam = "/rp " + "[" + "20080311" + "]";
//		// + "[" + cmbxNewCombobox.getSelectedText() + "]";
//		
//		//GWT 타입으로 팝업 호출시  postCall true 설정
//		PrintUtils.setPostCall(true);
//		PrintUtils.rdaPrint(strDirPath, rdaFileName, strParam);
//
//	}

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
//	  @Override
//	  protected void onRender(Element parent, int index) {
//	    super.onRender(parent, index);
//	    
//	    detailTp = XTemplate.create(getDetailTemplate());
//	    
//	   // formData = new FormData("-650");
//	    vp = new VerticalPanel();
//	    vp.setSpacing(10);
//	    createPayr5600Form();  //화면 기본정보를 설정
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
			    createPayr5600Form();  //화면 기본정보를 설정
			    createSearchForm();    //검색필드를 적용
			    createStandardForm();    //기본정보필드  
			    vp.setSize("1010px", "700px");
			    
			    /**
		          * Create the relations 
		          */
				   final RelationDef  relPayr0450To0480 = new RelationDef(payr0450To0480Def,false);
				   relPayr0450To0480.addJoinDef("payYr", "payYr");
				   relPayr0450To0480.addJoinDef("payExtpyCd", "payExtpyCd"); 
				   relPayr0450To0480.setLinkedObject(payr0450To0480GridPanel);
				   payr0450Def.addRelation(relPayr0450To0480); 
		           
		 
		           // DETAILS 
		           final Grid payr0450To0480Grid = payr0450To0480GridPanel.getMsfGrid().getGrid();
		           payr0450To0480Grid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {
		              public void handleEvent(BaseEvent be) {  
		            	  if (payr0450To0480GridPanel.getCurrentlySelectedItem() != null) { 
		            		 
		            	      setRecord(payr0450To0480GridPanel.getCurrentlySelectedItem());
		            	        
		            	      MSFTextField itemField   = (MSFTextField) GWTUtils.findField(payr0450GridPanel.getMSFFormPanel(), Payr0450Def.FIELD_ID_CD);  
		            	      payr0450Def.setitemChange(itemField,record.get("payExtpyCd"));
		            		  payr0450Def.synchronizeGridDetail(
		            				  payr0450To0480GridPanel.getCurrentlySelectedItem(),
		            				  payr0450GridPanel );
		            		  
		            		//  payr0450GridPanel.reload(); 
		            		  actionDatabase = ActionDatabase.UPDATE; 
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
	  public Payr5600() {
		    
			setSize("1010px", "700px");  
	  } 
	
	  public Payr5600(String txtForm) {
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
	  private void createPayr5600Form() {
		  
		  initLoad();
		  
			plFrmPayr5600 = new FormPanel();
			plFrmPayr5600.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" -  ") + lblPayrConst.title_Payr5600());
			//plFrmPayr5600.setHeadingText(PayGenConst.PAYGEN_VERSION.concat(" - 항목별수당관리");
			plFrmPayr5600.setIcon(MSFMainApp.ICONS.text());
			plFrmPayr5600.setBodyStyleName("pad-text");
			plFrmPayr5600.setPadding(2);
			plFrmPayr5600.setFrame(true); 
			
			/************************************************************************
			 * 화면 에러 처리시 필요한 부분으로 추가 -funcLogMessage 호출 
			 ************************************************************************/
			final Button btnlogView = new Button("로그");   
			
			btnlogView.setHeight("10px"); //로그등 헤더 버튼 적용시 사용함.
			btnlogView.addListener(Events.Select, new Listener<ButtonEvent>() {
				public void handleEvent(ButtonEvent e) {
					 //로그 뷰화면 호출 메서드 
					  funcLogMessage(lblPayrConst.title_Payr5600(),"PAYR5600");
					}
				});
			plFrmPayr5600.getHeader().setStyleAttribute("padding", "5px 0 2px 0");
			plFrmPayr5600.getHeader().addTool(btnlogView); 
			/************************************************************************
			 * 화면 에러 처리시 필요한 부분으로 추가 
			 ************************************************************************/

			 LayoutContainer layoutContainer = new LayoutContainer();
			 layoutContainer.setLayout(new ColumnLayout());
			  
			 LayoutContainer layoutContainer_1 = new LayoutContainer(); 
			 layoutContainer_1.setLayout(new FlowLayout());
			  
			  ButtonBar buttonBar_1 = new ButtonBar();
			  
			  Button btnNewButton_2 = new Button("");
			 // btnNewButton_2.setIcon(MSFMainApp.ICONS.text());
			  buttonBar_1.add(btnNewButton_2);
			  layoutContainer_1.add(buttonBar_1);
			  layoutContainer.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
			  layoutContainer_1.setBorders(false);
			  
			  LayoutContainer layoutContainer_2 = new LayoutContainer();
			  layoutContainer_2.setLayout(new FlowLayout());
			  
			   
			   topPayr5600Bar = new ButtonBar();    
			   layoutContainer_2.add(topPayr5600Bar);
			   topPayr5600Bar.setAlignment(HorizontalAlignment.RIGHT);
		 
		  	
			   btnPayr5600Init = new Button("초기화");  
			   btnPayr5600Init.setIcon(MSFMainApp.ICONS.new16());
			  	topPayr5600Bar.add(btnPayr5600Init);
			  	btnPayr5600Init.addListener(Events.Select, new Listener<ButtonEvent>() {
		    		public void handleEvent(ButtonEvent e) {
		    			 //초기화 
		    			formInit();
		    		}
		      });
			  	 
			  	 
			  	btnPayr5600Sreach = new Button("조회"); 
			  	btnPayr5600Sreach.setIcon(MSFMainApp.ICONS.search16());
			  	topPayr5600Bar.add(btnPayr5600Sreach);
			  	btnPayr5600Sreach.addListener(Events.Select, new Listener<ButtonEvent>() {
		    		public void handleEvent(ButtonEvent e) {
		    			//조회버튼 클릭시 처리 
		    		    reload();  
		    		}
		    	});
			  	
		    layoutContainer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
		    layoutContainer_2.setBorders(false); 
		    layoutContainer.setBorders(false);
		  	
		    plFrmPayr5600.add(layoutContainer);    
		  	  
		  	
			//파일업로드 처리
			plFrmPayr5600.setAction("bizform");
			plFrmPayr5600.setEncoding(Encoding.MULTIPART);
			plFrmPayr5600.setMethod(Method.POST);
			
		
			vp.add(plFrmPayr5600);
			plFrmPayr5600.setSize("990px", "680px");
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
	  
	 /**
      * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      * 년도 콤보박스 처리  시작
      * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		  
      */
     		    ContentPanel payYrGrid = new ContentPanel();  
     		     payYrGrid.setVisible(false);
     		    
     		    //년도 콤보처리 
     		   payYrGridPanel = new MSFGridPanel(lkApptnYr, false, false, false, true); 
     		   payYrGridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
     			       public void handleEvent(ComponentEvent be) {  
     			    	 payYrGridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
     			          public void handleEvent(StoreEvent<BaseModel> be) {  
     			        	 lsPayYrStore.add(payYrGridPanel.getMsfGrid().getStore().getModels()); 
     			        	 
     			        	 
     			          }  
     			        });  
     			       
     			      }  
     			    });  
     	  
     		payYrGrid.add(payYrGridPanel); 
     		plFrmPayr5600.add(payYrGrid);
     	    
     		 
   		 /**
   	   * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   	   * 수당   콤보박스 처리  시작
   	   * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		  
   	   */
   	  		   ContentPanel payExtpyCdGrid = new ContentPanel();  
   	  		   payExtpyCdGrid.setVisible(false);
   	  		    
   	  		   //년도 콤보처리 
   	  		   payr0480GridPanel = new MSFGridPanel(lkPayr0480Def, false, false, false, true); 
   	  		   payr0480GridPanel.getGrid().addListener(Events.ViewReady, new Listener<ComponentEvent>() {  
   	  			       public void handleEvent(ComponentEvent be) {  
   	  			    	 payr0480GridPanel.getGrid().getStore().addListener(Store.DataChanged, new Listener<StoreEvent<BaseModel>>() {  
   	  			          public void handleEvent(StoreEvent<BaseModel> be) {  
   	  			        	lsPayExtpyCd.add(payr0480GridPanel.getMsfGrid().getStore().getModels()); 
   	  			        	 
   	  			        	  
   	  			          }  
   	  			        });  
   	  			       
   	  			      }  
   	  			    });  
   	  	  
   	  		payExtpyCdGrid.add(payr0480GridPanel); 
   	  	plFrmPayr5600.add(payExtpyCdGrid); 
     	    
	  plFrmPayr5600.setLayout(new FlowLayout());
	    
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
	  

	    
	    LayoutContainer layoutContainer_14 = new LayoutContainer();
	    FormLayout frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(80); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT);  
	    layoutContainer_14.setLayout(frmlytSch);
	    
	    srhPayExtpyCd = new ComboBox<BaseModel>();
	    srhPayExtpyCd.setName("srhPayExtpyCd");
	    srhPayExtpyCd.setForceSelection(true);
	    srhPayExtpyCd.setMinChars(1);
        srhPayExtpyCd.setDisplayField("payExtpyNm");
        srhPayExtpyCd.setValueField("payExtpyCd");
	    srhPayExtpyCd.setTriggerAction(TriggerAction.ALL);
	    srhPayExtpyCd.setEmptyText("--수당선택--");
	    srhPayExtpyCd.setSelectOnFocus(true); 
	    srhPayExtpyCd.setReadOnly(false);
	    srhPayExtpyCd.setEnabled(true); 
	    srhPayExtpyCd.setStore(lsPayExtpyCd);  
	    srhPayExtpyCd.setFieldLabel("수당"); 
	    layoutContainer_14.add(srhPayExtpyCd, new FormData("100%"));
	   
	    layoutContainer_14.setBorders(false);
	    
	    LayoutContainer layoutContainer_10 = new LayoutContainer();
	    lcSchCol.add(layoutContainer_10);
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(80); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_10.setLayout(frmlytSch);
	    
//	    ComboBox comboBox_6 = new ComboBox();
//	    comboBox_6.setStore(new ListStore());
//	    layoutContainer_10.add(comboBox_6, new FormData("100%"));
//	    comboBox_6.setFieldLabel("직 종");
//	    layoutContainer_10.setBorders(false);
	 
	    fieldSet.add(lcSchCol, new FormData("100%"));  
	    lcSchLeft.setLayout(new ColumnLayout());
	    
	    LayoutContainer layoutContainer_8 = new LayoutContainer();
	    frmlytSch = new FormLayout();  
	    frmlytSch.setLabelWidth(80); 
	    frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
	    layoutContainer_8.setLayout(frmlytSch);
	    
	    srhPayYr = new ComboBox<BaseModel>(); 
	    srhPayYr.setName("srhPayYr");
	    srhPayYr.setForceSelection(true);
	    srhPayYr.setMinChars(1);
	    srhPayYr.setDisplayField("payYrDisp");
	    srhPayYr.setValueField("payYr");
	    srhPayYr.setTriggerAction(TriggerAction.ALL);
	    srhPayYr.setEmptyText("--년도선택--");
	    srhPayYr.setSelectOnFocus(true); 
	    srhPayYr.setReadOnly(false);
	    srhPayYr.setEnabled(true); 
	    srhPayYr.setStore(lsPayYrStore); 
	    srhPayYr.setFieldLabel("급여년도");   
	    srhPayYr.getStore().addStoreListener( new StoreListener<BaseModel>() {   
            public void handleEvent(StoreEvent<BaseModel> be) {  

            	checkPayr5600Auth("srhPayYr",lsPayYrStore);   
            }
        }); 
	    layoutContainer_8.add(srhPayYr, new FormData("100%"));
	    lcSchLeft.add(layoutContainer_8,new com.extjs.gxt.ui.client.widget.layout.ColumnData(1));
	    layoutContainer_8.setBorders(false);
	    
	    lcSchCol.add(lcSchLeft,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33)); 
	    lcSchCol.add(layoutContainer_14,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33)); 
	    lcSchCol.add(layoutContainer_10,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.34));
	     
	    
		
	    plFrmPayr5600.add(fieldSet); 
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
		FormLayout frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(0); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_1.setLayout(frmlytStd);
		
		FieldSet fldstNewFieldset = new FieldSet();
		fldstNewFieldset.setSize("320px", "540px");
		
		
		layoutContainer_1.add(fldstNewFieldset);
		fldstNewFieldset.setHeadingHtml("지급공제항목정보");
		fldstNewFieldset.setCollapsible(false);
		layoutContainer.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.33));
		layoutContainer_1.setBorders(false);
		layoutContainer_1.setStyleAttribute("marginTop", "10px");
		fldstNewFieldset.add(occupationalLeft(),new FormData("100%"));
		
		LayoutContainer layoutContainer_2 = new LayoutContainer();
		frmlytStd = new FormLayout();  
		frmlytStd.setLabelWidth(0); 
		frmlytStd.setLabelAlign(LabelAlign.RIGHT);
		layoutContainer_2.setLayout(frmlytStd);
		
		FieldSet fldstNewFieldset_2 = new FieldSet();
		fldstNewFieldset_2.setSize(641, 540);
		layoutContainer_2.add(fldstNewFieldset_2);
		fldstNewFieldset_2.setHeadingHtml("항목별정보");
		fldstNewFieldset_2.setCollapsible(false);
		fldstNewFieldset_2.setStyleAttribute("marginTop", "10px");
		fldstNewFieldset_2.add(occupationalRBottom(),new FormData("100%"));
		
		layoutContainer.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.67));
		layoutContainer_2.setBorders(false);
		 
		    
		plFrmPayr5600.add(layoutContainer);
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
   
   LayoutContainer lcTabFormLayer = new LayoutContainer();
   
        
       ContentPanel cp01 = new ContentPanel();   
       cp01.setBodyBorder(false); 
       cp01.setHeaderVisible(false);   
       cp01.setLayout(new FitLayout());      
       cp01.setSize(298, 510);  
       
       //msfCustomForm.setHeaderVisible(false);
       //Instantiate the GridPanel
       payr0450To0480GridPanel = new MSFGridPanel(payr0450To0480Def, false, false, false, false);
       payr0450To0480GridPanel.setHeaderVisible(false);  
       payr0450To0480GridPanel.setBodyBorder(true);
       payr0450To0480GridPanel.setBorders(true);
       payr0450To0480GridPanel.setSize(298, 510); 
         //   msfGridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.
        
         cp01.add(payr0450To0480GridPanel); 
       
    
    lcTabFormLayer.add(cp01); 
     
    return lcTabFormLayer;  
   
}  

 private LayoutContainer occupationalRBottom() {
	   

     LayoutContainer lcTabFormLayer = new LayoutContainer();

 
	   ContentPanel cp01 = new ContentPanel();   
	   cp01.setBodyBorder(false); 
	   cp01.setHeaderVisible(false);   
	   cp01.setLayout(new FitLayout());      
	   cp01.setSize(619, 520);  
	   
	  msfCustomForm = new MSFCustomForm(payr0450Def, 600, 150, false, false, false);
      msfCustomForm.setHeaderVisible(false);
        //Instantiate the GridPanel
	  payr0450GridPanel = new MSFGridPanel(payr0450Def, false, false, false, false);
	  payr0450GridPanel.setHeaderVisible(false);  
	  payr0450GridPanel.setBodyBorder(true);
	  payr0450GridPanel.setBorders(true);
	  payr0450GridPanel.setSize(619, 520);  
	  payr0450GridPanel.setMSFFormPanel(msfCustomForm);  //폼을 그리드에 넣은다.
    
	   cp01.add(payr0450GridPanel);  
		 
	   cp01.addButton(new Button("신 규", new SelectionListener<ButtonEvent>() {   
	      @Override  
	      public void componentSelected(ButtonEvent ce) {   
	          formNew();
	      }   
	    }));  
	    
	    cp01.addButton(new Button("저 장", new SelectionListener<ButtonEvent>() {   
	      @Override  
	      public void componentSelected(ButtonEvent ce) {   
	          setListRecord(payr0450GridPanel.getMsfGrid().getStore().getModifiedRecords().iterator()); 
              doAction(actionDatabase); 
	      }   
	    })); 
	    
	    cp01.addButton(new Button("삭 제", new SelectionListener<ButtonEvent>() {   
		      @Override  
		      public void componentSelected(ButtonEvent ce) {   
		          //삭제처리 
		          
	                  Iterator<BaseModel> itBm  = payr0450GridPanel.getMsfGrid().getGrid().getSelectionModel().getSelectedItems().listIterator();
	                  
	                  List<Record>  lsRec  = new ArrayList<Record>();
	                  
	                  while(itBm.hasNext()) {
	     
	                      Record rec  = new Record(itBm.next()); 
	                      lsRec.add(rec);
	                      
	                  } 
	                   setListRecord(lsRec.iterator()); 
	                   
                    actionDatabase = ActionDatabase.DELETE;
                    doAction(actionDatabase);
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
	        payr0450GridPanel.getMsfGrid().clearData();
			IColumnFilter filters = null;
			payr0450To0480GridPanel.getTableDef().setTableColumnFilters(filters);
			
			payr0450To0480GridPanel.getTableDef().addColumnFilter("payYr", MSFSharedUtils.getSelectedComboValue(srhPayYr,"payYr"), SimpleColumnFilter.OPERATOR_EQUALS);
			payr0450To0480GridPanel.getTableDef().addColumnFilter("payExtpyCd", MSFSharedUtils.getSelectedComboValue(srhPayExtpyCd,"payExtpyCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
			
		  
			payr0450To0480GridPanel.reload();
		}
	  
	 
	 //폼초기화 검색조건포함 
	   private void formInit() {
	      
	       payr0450To0480GridPanel.getMsfGrid().clearData();
	       payr0450GridPanel.getMsfGrid().clearData();
	   }
	   
	   
	   private void formNew() {
	          
	       if (payr0450To0480GridPanel.getMsfGrid().getStore().getCount() <= 0)  {
	              return;
	       }  
	         
	         
	       
	       BaseModel bmData = payr0450GridPanel.getTableDef().getDefaultValues();  
	         
           bmData.set("dpobCd", MSFMainApp.get().getUser().getDpobCd());/** column 사업장코드 : dpobCd */ 
           bmData.set("payYr", MSFSharedUtils.allowNulls(record.get("payYr")));   /** column 급여년도 : payYr */
           bmData.set("setPayPymtItemListSeilNum",0);   
           bmData.set("payItemCd", MSFSharedUtils.allowNulls(record.get("payExtpyCd"))); /** column 급여항목코드 : payItemCd */
           bmData.set("payItemNm", MSFSharedUtils.allowNulls(record.get("payExtpyNm"))); /** column 급여항목 : payItemNm */
          
           bmData.set("styrNum",0); /** column 시작년수 : styrNum */ 
           bmData.set("edyrNum",0); /** column 종료년수 : edyrNum */ 
           bmData.set("pymtDducRate",0); /** column 지급공제율 : pymtDducRate */ 
           bmData.set("pymtDducSum",0); /** column 지급공제금액 : pymtDducSum */ 
           bmData.set("itemListExtpyDelYn", false); /** column 항목별수당삭제여부 : itemListExtpyDelYn */ 
           bmData.set("rmak", "");  /** column 항목별수당비고내용 : rmak */ 
             
               
           payr0450GridPanel.getMsfGrid().getGrid().stopEditing();      
           payr0450GridPanel.getMsfGrid().getGrid().getStore().insert(bmData,0);   
           payr0450GridPanel.getMsfGrid().getGrid().startEditing(payr0450GridPanel.getMsfGrid().getGrid().getStore().indexOf(bmData), 0);   
           payr0450GridPanel.setSize(619, 490); 
           
           actionDatabase = ActionDatabase.INSERT;
       }
          
		  
	   
	   
	   
	   public void setRecord(BaseModel record) {
	       this.record = record;
	   }
	 
	    public void setListRecord(Iterator<Record> records) {
            this.records = records;
        }

  

	   private Payr5600 getThis(){
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
