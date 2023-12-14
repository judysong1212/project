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

 
public class PrgmComP0160  extends Lov implements PrgmComDaoConstants { 

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
	    
	    public PrgmComP0160(int width, int height) {
	        this();
	        this.width  = width;
	        this.height = height;
	    }

	    public PrgmComP0160() {

	        lovDef = new LovDef();
	        lovDef.setTitle("가족사항");  //팝업상단의 타이틀 
	        lovDef.setDaoClass("");
	        lovDef.setAutoFillGrid(true);
	        lovDef.setFilterForm(false);  
	        lovDef.setCustomListMethod(PRGMCOM_METHOD_POPUP_PSNL0115_List);
	        lovDef.setCheckBoxOnGridRows(true);
	        
	        List<ColumnLovDef> listColumnLovDefs = new ArrayList<ColumnLovDef>();
	       
	        
	        /** column 사업장코드 : dpobCd */
	        listColumnLovDefs.add(new ColumnLovDef("사업장코드", PrgmComPsnl0115BM.ATTR_DPOBCD, PrgmComPsnl0115BM.ATTR_DPOBCD, ColumnLovDef.TYPE_STRING , 90){
	            {
	                setIsVisibleInGrid(false);
	            }
	        });
	        /** column SYSTEMKEY : systemkey */
	        listColumnLovDefs.add(new ColumnLovDef("SYSTEMKEY", PrgmComPsnl0115BM.ATTR_SYSTEMKEY, PrgmComPsnl0115BM.ATTR_SYSTEMKEY, ColumnLovDef.TYPE_STRING , 90){
	            {
	                setIsVisibleInGrid(false);
	            }
	        });
	        /** column 가족일련번호 : famySeilNum */
	        listColumnLovDefs.add(new ColumnLovDef("번호", PrgmComPsnl0115BM.ATTR_FAMYSEILNUM,PrgmComPsnl0115BM.ATTR_FAMYSEILNUM, ColumnLovDef.TYPE_LONG , 40){
	            {

	            }
	        });
	        /** column 가족관계구분코드 : famyRelaDivCd */
	        listColumnLovDefs.add(new ColumnLovDef("가족관계코드", PrgmComPsnl0115BM.ATTR_FAMYRELADIVCD,PrgmComPsnl0115BM.ATTR_FAMYRELADIVCD, ColumnLovDef.TYPE_STRING , 90){
	            {
	                setIsVisibleInGrid(false);
	            }
	        });
	        /** column 가족관계 : famyRelaDivNm */
	        listColumnLovDefs.add(new ColumnLovDef("가족관계", PrgmComPsnl0115BM.ATTR_FAMYRELADIVNM, PrgmComPsnl0115BM.ATTR_FAMYRELADIVNM,ColumnLovDef.TYPE_STRING , 90){
	            {

	            }
	        });
	        /** column 가족성명 : famyNm */
	        listColumnLovDefs.add(new ColumnLovDef("성명", PrgmComPsnl0115BM.ATTR_FAMYNM, PrgmComPsnl0115BM.ATTR_FAMYNM, ColumnLovDef.TYPE_STRING , 90){
	            {

	            }
	        });
	        /** column 가족주민등록번호 : famyResnRegnNum */
	        listColumnLovDefs.add(new ColumnLovDef("주민등록번호", PrgmComPsnl0115BM.ATTR_FAMYRESNREGNNUM, PrgmComPsnl0115BM.ATTR_FAMYRESNREGNNUM, ColumnLovDef.TYPE_STRING , 90){
	            {

	            }
	        });
	        /** column 생년월일 : yoobhMnthDay */
	        listColumnLovDefs.add(new ColumnLovDef("생년월일", PrgmComPsnl0115BM.ATTR_YOOBHMNTHDAY,PrgmComPsnl0115BM.ATTR_YOOBHMNTHDAY, ColumnLovDef.TYPE_STRING , 90){
	            {
	                setIsVisibleInGrid(false);
	            }
	        });
	        /** column 음양구분코드 : sclcDivCd */
	        listColumnLovDefs.add(new ColumnLovDef("음양구분코드", PrgmComPsnl0115BM.ATTR_SCLCDIVCD,PrgmComPsnl0115BM.ATTR_SCLCDIVCD, ColumnLovDef.TYPE_STRING , 90){
	            {
	                setIsVisibleInGrid(false);
	            }
	        });
	        /** column 음양구분코드 : sclcDivNm  */
	        listColumnLovDefs.add(new ColumnLovDef("음양구분", PrgmComPsnl0115BM.ATTR_SCLCDIVNM, PrgmComPsnl0115BM.ATTR_SCLCDIVNM, ColumnLovDef.TYPE_STRING , 90){
	            {
	                setIsVisibleInGrid(false);
	            }
	        });
	        /** column 학력구분코드 : acadAbtyDivCd */
	        listColumnLovDefs.add(new ColumnLovDef("학력구분코드", PrgmComPsnl0115BM.ATTR_ACADABTYDIVCD,PrgmComPsnl0115BM.ATTR_ACADABTYDIVCD, ColumnLovDef.TYPE_STRING , 90){
	            {
	                setIsVisibleInGrid(false);
	            }
	        });
	        /** column 학력구분코드 : acadAbtyDivNm */
	        listColumnLovDefs.add(new ColumnLovDef("학력구분", PrgmComPsnl0115BM.ATTR_ACADABTYDIVNM, PrgmComPsnl0115BM.ATTR_ACADABTYDIVNM,ColumnLovDef.TYPE_STRING , 90){
	            {
	                setIsVisibleInGrid(false);
	            }
	        });
	        /** column 학교명 : schlNm */
	        listColumnLovDefs.add(new ColumnLovDef("학교명", PrgmComPsnl0115BM.ATTR_SCHLNM, PrgmComPsnl0115BM.ATTR_SCHLNM,  ColumnLovDef.TYPE_STRING , 90){
	            {
	                setIsVisibleInGrid(false);
	            }
	        });
	        /** column 직업명 : crrCd */
	        listColumnLovDefs.add(new ColumnLovDef("직업명", PrgmComPsnl0115BM.ATTR_CRRCD, PrgmComPsnl0115BM.ATTR_CRRCD, ColumnLovDef.TYPE_STRING , 90){
	            {
	                setIsVisibleInGrid(false);
	            }
	        });
	        /** column 직업명 : crrNm */
	        listColumnLovDefs.add(new ColumnLovDef("직업", PrgmComPsnl0115BM.ATTR_CRRNM,PrgmComPsnl0115BM.ATTR_CRRNM, ColumnLovDef.TYPE_STRING , 90){
	            {

	            }
	        });
	        /** column 직장명 : wkOfcNm */
	        listColumnLovDefs.add(new ColumnLovDef("직장명", PrgmComPsnl0115BM.ATTR_WKOFCNM,PrgmComPsnl0115BM.ATTR_WKOFCNM, ColumnLovDef.TYPE_STRING , 90){
	            {

	            }
	        });
	        /** column 직위명 : inbyNm */
	        listColumnLovDefs.add(new ColumnLovDef("직위명", PrgmComPsnl0115BM.ATTR_INBYNM,PrgmComPsnl0115BM.ATTR_INBYNM, ColumnLovDef.TYPE_STRING , 90){
	            {
	                setIsVisibleInGrid(false);
	            }
	        });
	        /** column 외국인여부 : frgnrYn */
	        listColumnLovDefs.add(new ColumnLovDef("외국인", PrgmComPsnl0115BM.ATTR_FRGNRYN, PrgmComPsnl0115BM.ATTR_FRGNRYN, ColumnLovDef.TYPE_BOOLEAN , 90){
	            {

	            }
	        });
	        /** column 장애구분코드 : dabtyDivCd */
	        listColumnLovDefs.add(new ColumnLovDef("장애구분코드", PrgmComPsnl0115BM.ATTR_DABTYDIVCD,  PrgmComPsnl0115BM.ATTR_DABTYDIVCD,ColumnLovDef.TYPE_STRING , 90){
	            {
	                setIsVisibleInGrid(false);
	            }
	        });
	        /** column 장애구분 : dabtyDivNm */
	        listColumnLovDefs.add(new ColumnLovDef("장애구분", PrgmComPsnl0115BM.ATTR_DABTYDIVNM, PrgmComPsnl0115BM.ATTR_DABTYDIVNM,ColumnLovDef.TYPE_STRING , 90){
	            {

	            }
	        });
	        /** column 장애등급코드 : dabtyGrdeCd */
	        listColumnLovDefs.add(new ColumnLovDef("장애등급코드", PrgmComPsnl0115BM.ATTR_DABTYGRDECD, PrgmComPsnl0115BM.ATTR_DABTYGRDECD, ColumnLovDef.TYPE_STRING , 90){
	            {
	                setIsVisibleInGrid(false);
	            }
	        });
	        /** column 장애등급 : dabtyGrdeNm */
	        listColumnLovDefs.add(new ColumnLovDef("장애등급", PrgmComPsnl0115BM.ATTR_DABTYGRDENM, PrgmComPsnl0115BM.ATTR_DABTYGRDENM, ColumnLovDef.TYPE_STRING , 90){
	            {

	            }
	        });
	        /** column 가족사항비고내용 : famyPartNoteCtnt */
	        listColumnLovDefs.add(new ColumnLovDef("가족사항비고내용", PrgmComPsnl0115BM.ATTR_FAMYPARTNOTECTNT, PrgmComPsnl0115BM.ATTR_FAMYPARTNOTECTNT, ColumnLovDef.TYPE_STRING , 90){
	            {
	                setIsVisibleInGrid(false);
	            }
	        });
	        /** column 국가코드 : natnCd */
	        listColumnLovDefs.add(new ColumnLovDef("국가코드", PrgmComPsnl0115BM.ATTR_NATNCD, PrgmComPsnl0115BM.ATTR_NATNCD, ColumnLovDef.TYPE_STRING , 90){
	            {
	                setIsVisibleInGrid(false);
	            }
	        });
	        /** column 국가 : natnNm */
	        listColumnLovDefs.add(new ColumnLovDef("국가", PrgmComPsnl0115BM.ATTR_NATNNM, PrgmComPsnl0115BM.ATTR_NATNNM, ColumnLovDef.TYPE_STRING , 90){
	            {
	                setIsVisibleInGrid(false);
	            }
	        });
	        
	        /** column 가족동거여부 : famyChbttYn */
	        listColumnLovDefs.add(new ColumnLovDef("가족동거여부", PrgmComPsnl0115BM.ATTR_FAMYCHBTTYN,PrgmComPsnl0115BM.ATTR_FAMYCHBTTYN, ColumnLovDef.TYPE_STRING , 90){
	            {
	                setIsVisibleInGrid(false);
	            }
	        });
	        /** column 가족수당여부 : famyAllwYn */
	        listColumnLovDefs.add(new ColumnLovDef("가족수당여부", PrgmComPsnl0115BM.ATTR_FAMYALLWYN,PrgmComPsnl0115BM.ATTR_FAMYALLWYN, ColumnLovDef.TYPE_STRING , 90){
	            {
	                setIsVisibleInGrid(false);
	            }
	        });
	        /** column 학비보조여부 : schlExpnAdmclYn */
	        listColumnLovDefs.add(new ColumnLovDef("학비보조여부", PrgmComPsnl0115BM.ATTR_SCHLEXPNADMCLYN, PrgmComPsnl0115BM.ATTR_SCHLEXPNADMCLYN, ColumnLovDef.TYPE_STRING , 90){
	            {
	                setIsVisibleInGrid(false);
	            }
	        });
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
