/**
 * 가족사항 팝업화면 
 */
package com.app.exterms.prgm.client.form;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComPsnl0115BM;
import com.app.exterms.prgm.client.form.defs.PrgmComPsnl0115Def;
import com.app.exterms.prgm.client.languages.PrgmConstants;
import com.app.exterms.prgm.shared.PrgmComDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnLovDef;
import com.app.smrmf.core.msfmainapp.client.def.LovDef;
import com.app.smrmf.core.msfmainapp.client.generics.Lov;

 
public class PrgmRemtComP2100  extends Lov implements PrgmComDaoConstants { 

	 /**######################################################
		 * { 시스템 기본설정파일 선언부  시작}
		 *#######################################################*/
	 

	     /**######################################################
	 	 * { 시스템 기본설정파일 선언부  종료}
	 	 *#######################################################*/

	  private PrgmConstants SysComLabel = PrgmConstants.INSTANCE;
	  
//	  private static ListStore<BaseModel>   lsDeptCd = new ListStore<BaseModel>();//부서 
//      private static ListStore<BaseModel>     lsUsrDivCd = new ListStore<BaseModel>();//사용자구분 
//      
//      protected static ComboBox<BaseModel> deptCd ;    //부서 
//      protected static ComboBox<BaseModel> usrDivCd;    //사용자구분
//      protected static TextField<String> usrNm;         //성명
//      protected static Button btnUsrSearch;
	    
	    public PrgmRemtComP2100(int width, int height) {
	        this();
	        this.width  = width;
	        this.height = height;
	    }

	    public PrgmRemtComP2100() {

	        lovDef = new LovDef();
	        lovDef.setTitle("중간지급등 반영 선택");  //팝업상단의 타이틀 
	        lovDef.setDaoClass("");
	        lovDef.setAutoFillGrid(true);
	        lovDef.setFilterForm(false);  
	        lovDef.setCustomListMethod(PRGMCOM_METHOD_POPUP_REMTCOMP2100_List);
	        lovDef.setCheckBoxOnGridRows(true);
	        
	        List<ColumnLovDef> listColumnLovDefs = new ArrayList<ColumnLovDef>();
	       
	        
	        
//	        /** column 사업장코드 : dpobCd */
//	        listColumnDefs.add(new ColumnDef("사업장코드", Remt9000BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//	            {
//	 
//	            }
//	        });
//
//	        /** column 퇴직금정산관리번호 : sevePayClutMangeNum */
//	        listColumnDefs.add(new ColumnDef("관리번호", Remt9000BM.ATTR_SEVEPAYCLUTMANGENUM, ColumnDef.TYPE_STRING , 90, false, true, true){
//	            {
//	                setReadOnly(true);
//	            }
//	        });
//	        
//	        /** column 퇴직정산귀속년도 : calcSevePayPsnBlggYr */
//	        listColumnDefs.add(new ColumnDef("귀속년도", Remt9000BM.ATTR_CALCSEVEPAYPSNBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
//	            {
//
//	            }
//	        });
//	        /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
//	        listColumnDefs.add(new ColumnDef("퇴직정산구분코드", Remt9000BM.ATTR_CALCSEVEPAYPSNDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//	            {
//
//	            }
//	        }); 
//	   
//	         
//	        
//	        /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
//	        listColumnDefs.add(new ColumnDef("정산구분", Remt9000BM.ATTR_CALCSEVEPAYPSNDIVNM, ColumnDef.TYPE_STRING , 90, false, true, true){
//	            {
//
//	            }
//	        });
//	        /** column 입사일자 : icncDt */
//	        listColumnDefs.add(new ColumnDef("입사일자", Remt9000BM.ATTR_ICNCDT, ColumnDef.TYPE_DATE , 90, false, false, true){
//	            {
//	                setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));   
//	            }
//	        });
//	        /** column 지급일자 : pymtDt */
//	        listColumnDefs.add(new ColumnDef("지급일자", Remt9000BM.ATTR_PYMTDT, ColumnDef.TYPE_DATE , 90, false, true, true){
//	            {
//	                setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));   
//	            }
//	        });
//	        
//	        /** column 기산일자 : rkfcdDt */
//	        listColumnDefs.add(new ColumnDef("기산일자", Remt9000BM.ATTR_RKFCDDT, ColumnDef.TYPE_DATE , 90, false, true, true){
//	            {
//	                setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));   
//	            }
//	        });
//	        /** column 퇴사일자 : rsgtnDt */
//	        listColumnDefs.add(new ColumnDef("퇴사일자", Remt9000BM.ATTR_RSGTNDT, ColumnDef.TYPE_DATE , 90, false, true, true){
//	            {
//	                setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));   
//	            }
//	        });
//	       
//	        /** column 제외월수_2012이전 : eepnMnthIcm2012Bfr */
//	        listColumnDefs.add(new ColumnDef("제외2012이전", Remt9000BM.ATTR_EEPNMNTHICM2012BFR, ColumnDef.TYPE_LONG , 90, false, false, true){
//	            {
//
//	            }
//	        });
//	        /** column 제외월수_2013이후 : eepnMnthIcm2013Aft */
//	        listColumnDefs.add(new ColumnDef("제외2013이후", Remt9000BM.ATTR_EEPNMNTHICM2013AFT, ColumnDef.TYPE_LONG , 90, false, false, true){
//	            {
//
//	            }
//	        });
//	        /** column 가산월수_2012이전 : addMnthIcm2012Bfr */
//	        listColumnDefs.add(new ColumnDef("가산2012이전", Remt9000BM.ATTR_ADDMNTHICM2012BFR, ColumnDef.TYPE_LONG , 90, false, false, true){
//	            {
//
//	            }
//	        });
//	        /** column 가산월수_2013이후 : addMnthIcm2013Aft */
//	        listColumnDefs.add(new ColumnDef("가산2013이후", Remt9000BM.ATTR_ADDMNTHICM2013AFT, ColumnDef.TYPE_LONG , 90, false, false, true){
//	            {
//
//	            }
//	        });
//	        
//	        /** column 퇴직금가산율 : sevePayAddRate */
//	        listColumnDefs.add(new ColumnDef("가산율", Remt9000BM.ATTR_SEVEPAYADDRATE, ColumnDef.TYPE_DOUBLE , 80, false, true, true){
//	            {
//
//	            }
//	        });
//	        
//	        
//	        /** column 군경력정산포함여부 : amcrrClutInsnYn */
//	        listColumnDefs.add(new ColumnDef("군경력", InfcRemt9000BM.ATTR_AMCRRCLUTINSNYN, ColumnDef.TYPE_BOOLEAN , 60, false, true, true){
//	        	{
//
//	        	}
//	        });
//	      
//	        
//	        /** column 퇴직급여액 : retryPayQnty */
//	        listColumnDefs.add(new ColumnDef("퇴직금액", Remt9000BM.ATTR_RETRYPAYQNTY, ColumnDef.TYPE_LONG , 90, false, true, true){
//	            {
//
//	            }
//	        });
//	        /** column 비과세퇴직급여액 : freeDtyRetryPayQnty */
//	        listColumnDefs.add(new ColumnDef("비과세", Remt9000BM.ATTR_FREEDTYRETRYPAYQNTY, ColumnDef.TYPE_LONG , 90, false, true, true){
//	            {
//
//	            }
//	        });
//	        /** column 기납부세액 : alpayTxAmnt */
//	        listColumnDefs.add(new ColumnDef("소득세", Remt9000BM.ATTR_ALPAYTXAMNT, ColumnDef.TYPE_LONG , 90, false, true, true){
//	            {
//
//	            }
//	        });
//	      
//	        
//	        /** column 지방소득세 : locIncmTxAmt */
//	        listColumnDefs.add(new ColumnDef("지방소득세", Remt9000BM.ATTR_LOCINCMTXAMT, ColumnDef.TYPE_LONG , 90, false, true, true){
//	        	{
//
//	        	}
//	        });
//	        /** column 차인지급액 : pernPymtSum */
//	        listColumnDefs.add(new ColumnDef("지급액", Remt9000BM.ATTR_PERNPYMTSUM, ColumnDef.TYPE_LONG , 90, false, true, true){
//	        	{
//
//	        	}
//	        });
//	      
//	        /** column 퇴직금중간정산비고내용 : sevePayCtrClutNoteCtnt */
//	        listColumnDefs.add(new ColumnDef("비고내용", Remt9000BM.ATTR_SEVEPAYCTRCLUTNOTECTNT, ColumnDef.TYPE_STRING , 150, false, true, true){
//	            {
//	                setTypeTextField(ColumnDef.TEXTAREA); 
//	            }
//	        });
	  
	        /** column 연말정산여부 : yrtxYn */
	        listColumnLovDefs.add(new ColumnLovDef("연말정산여부", PrgmComPsnl0115BM.ATTR_YRTXYN,  PrgmComPsnl0115BM.ATTR_YRTXYN,ColumnLovDef.TYPE_STRING , 90){
	            {
	                setIsVisibleInGrid(false);
	            }
	        });
	         
	        
	        lovDef.setListColumns(listColumnLovDefs); 

	        lovDef.addHiddenColumn(new PrgmComPsnl0115Def().getColumnsDefinition()); 
	       
	    } 
	    
//	    public static final LayoutContainer getMsfComP0100Filter() {
//            
//            final PrgmComBass0300DTO sysComBass0300Dto; //공통코드 dto
//            final PrgmComBass0400DTO sysComBass0400Dto; //부서코드
//            
//               
//            sysComBass0300Dto = new PrgmComBass0300DTO();
//            sysComBass0400Dto = new PrgmComBass0400DTO();
//           //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
//            //고용구분
//            sysComBass0300Dto.setRpsttvCd("D001");
//            lsUsrDivCd = PrgmComComboUtils.getSingleBass0300ComboData( sysComBass0300Dto);
//            //--------------------공통 코드 불러 오는 함수 --------------------------------------------------
//           
//           //--------------------부서 불러 오는 함수 ------------------------------------------------
//            lsDeptCd = PrgmComComboUtils.getDeptBass0400ComboData(sysComBass0400Dto);
//            //--------------------부서 불러 오는 함수 ------------------------------------------------
//              
//            
//                ContentPanel cp03 = new ContentPanel();   
//                cp03.setBodyBorder(false); 
//                cp03.setHeaderVisible(false);   
//                cp03.setLayout(new FlowLayout(2));      
//                cp03.setSize(800, 80);  
//              
//                 LayoutContainer frmSearchLayer = new LayoutContainer();
//                 FormLayout layout = new FormLayout();
//                 layout.setDefaultWidth(300);
//                 layout.setLabelWidth(80);   
//                 frmSearchLayer.setLayout(layout);  
//                
//                 
//                 //검색조건 
//                 
//                 LayoutContainer  lycSreach = new LayoutContainer(); 
//                 FormLayout frmlytStd = new FormLayout();  
//                 frmlytStd.setLabelWidth(0);  
//                 lycSreach.setLayout(frmlytStd);
//                 lycSreach.setHeight(30); 
//                 
//                 LayoutContainer layoutContainer_12 = new LayoutContainer();
//                 layoutContainer_12.setLayout(new ColumnLayout());
//                 layoutContainer_12.setStyleAttribute("paddingTop", "5px");
//                 
//                 LayoutContainer layoutContainer_2 = new LayoutContainer();
//                 layoutContainer_12.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
//                 FormLayout frmlytSch = new FormLayout();  
//                 frmlytSch.setLabelWidth(70); 
//                 frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//                 layoutContainer_2.setLayout(frmlytSch);
//                 
//                 deptCd = new ComboBox<BaseModel>();
//                 deptCd.setForceSelection(true);
//                 deptCd.setMinChars(1);
//                 deptCd.setDisplayField("deptNmRtchnt");
//                 deptCd.setValueField("deptCd");
//                 deptCd.setTriggerAction(TriggerAction.ALL);
//                 deptCd.setEmptyText("--부서선택--");
//                 deptCd.setSelectOnFocus(true); 
//                 deptCd.setReadOnly(false);
//                 deptCd.setEnabled(true); 
//                 deptCd.setStore(lsDeptCd );
//                 deptCd.setFieldLabel("부서");
//                
//                 layoutContainer_2.add(deptCd, new FormData("100%")); 
//                 layoutContainer_2.setBorders(false);
//                 
//                 LayoutContainer layoutContainer_1 = new LayoutContainer();
//                 layoutContainer_12.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
//                 frmlytSch = new FormLayout();  
//                 frmlytSch.setLabelWidth(70); 
//                 frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
//                 layoutContainer_1.setLayout(frmlytSch);
//                 
//                 usrDivCd =  new ComboBox<BaseModel>(); 
//                 usrDivCd.setForceSelection(true);
//                 usrDivCd.setMinChars(1);
//                 usrDivCd.setDisplayField("commCdNm");
//                 usrDivCd.setValueField("commCd");
//                 usrDivCd.setTriggerAction(TriggerAction.ALL);
//                 usrDivCd.setEmptyText("--사용자구분선택--");
//                 usrDivCd.setSelectOnFocus(true); 
//                 usrDivCd.setReadOnly(false);
//                 usrDivCd.setEnabled(true); 
//                 usrDivCd.setStore(lsUsrDivCd);
//                 usrDivCd.setFieldLabel("사용자구분"); 
//               
//                 layoutContainer_1.add(usrDivCd, new FormData("100%"));
//                 layoutContainer_1.setBorders(false);  
//               
//                 LayoutContainer layoutContainer_13 = new LayoutContainer();
//                 frmlytStd = new FormLayout();  
//                 frmlytStd.setLabelWidth(60); 
//                 frmlytStd.setLabelAlign(LabelAlign.RIGHT);
//                 layoutContainer_13.setLayout(frmlytStd);
//                
//                 usrNm = new TextField<String>(); 
//                 usrNm.setFieldLabel("성 명");
////                 usrNm.addKeyListener(new KeyListener() {
////                    public void componentKeyUp(ComponentEvent event) {
////                        super.componentKeyUp(event);
////                        usrNm.validate();
////                        if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
////                          
////                       
////                        }
////                    }
////                 });
//
//                 layoutContainer_13.add(usrNm, new FormData("100%")); 
//                 layoutContainer_13.setBorders(false);
//             
//                 btnUsrSearch = new Button("검색");
//                 btnUsrSearch.setIcon(MSFMainApp.ICONS.search());
////                     btnUsrSearch.addListener(Events.Select, new Listener<ButtonEvent>() {
////                     public void handleEvent(ButtonEvent e) {
////                           
////                        // reload(); 
////                     }
////                 });
//                 
//                 layoutContainer_12.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
//                 layoutContainer_12.add(btnUsrSearch );
//                 lycSreach.add(layoutContainer_12);
//                
//                cp03.add(lycSreach);
//                
//                frmSearchLayer.add(cp03);
//              
//                return frmSearchLayer ;
//          }

}
