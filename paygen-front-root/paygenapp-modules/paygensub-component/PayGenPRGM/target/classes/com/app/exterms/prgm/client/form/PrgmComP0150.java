/**
 * 부서사업관리 팝업화면 
 */
package com.app.exterms.prgm.client.form;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.form.defs.PrgmComBass0500Def;
import com.app.exterms.prgm.client.languages.PrgmConstants;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.shared.PrgmComDaoConstants;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnLovDef;
import com.app.smrmf.core.msfmainapp.client.def.LovDef;
import com.app.smrmf.core.msfmainapp.client.generics.Lov;
import com.app.smrmf.core.msfmainapp.client.utils.GWTAuthorization;
import com.app.smrmf.core.msfmainapp.client.utils.GWTExtAuth;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;

 
public class PrgmComP0150  extends Lov implements PrgmComDaoConstants { 

	 /**######################################################
		 * { 시스템 기본설정파일 선언부  시작}
		 *#######################################################*/
	 //권한 설정 객체 
	  private  static GWTAuthorization gwtAuthorization;
	  private  static GWTExtAuth gwtExtAuth;

	     /**######################################################
	 	 * { 시스템 기본설정파일 선언부  종료}
	 	 *#######################################################*/

	  private PrgmConstants PrgmComLabel = PrgmConstants.INSTANCE;
	    
	  private static ListStore<BaseModel>   lsDeptCd = new ListStore<BaseModel>();//부서 
      private static ListStore<BaseModel>     lsBusinApptnYr = new ListStore<BaseModel>();//사용자구분 
      
      private static ComboBox<BaseModel> deptCd ;    //부서 
      private static ComboBox<BaseModel> businApptnYr;    //사업년도
      private static TextField<String> businNm;         //성명
      public static Button btnUsrSearch;
      
      
      
      
	    public static ComboBox<BaseModel> getDeptCd() {
		return deptCd;
	}

	public static void setDeptCd(ComboBox<BaseModel> deptCd) {
		PrgmComP0150.deptCd = deptCd;
	}

	public static ComboBox<BaseModel> getBusinApptnYr() {
		return businApptnYr;
	}

	public static void setBusinApptnYr(ComboBox<BaseModel> businApptnYr) {
		PrgmComP0150.businApptnYr = businApptnYr;
	}

	public static TextField<String> getBusinNm() {
		return businNm;
	}

	public static void setBusinNm(TextField<String> businNm) {
		PrgmComP0150.businNm = businNm;
	}

		public PrgmComP0150(int width, int height) {
	        this();
	        this.width  = width;
	        this.height = height;
	    }

	    public PrgmComP0150() {
	        // 권한처리 부분 추가 전역이 아니 각 화면별로 객체 생성시 처리를 위해 변경함.
		     gwtAuthorization =   GWTAuthorization.getInstance();
		     gwtExtAuth =   GWTExtAuth.getInstance();
		    
	        lovDef = new LovDef();
	        lovDef.setTitle("");  //팝업상단의 타이틀 
	        lovDef.setDaoClass(CLASS_SYSCOM_BASS0500VO);
	        lovDef.setAutoFillGrid(false);
	        
	        lovDef.setFilterForm(false);  
	        lovDef.setCustomListMethod(PRGMCOM_METHOD_POPUP_BASS0500_List);
	       
	        List<ColumnLovDef> listColumnDefs = new ArrayList<ColumnLovDef>();
	       
	        listColumnDefs.add(new ColumnLovDef("사업장코드", PrgmComBass0500BM.ATTR_DPOBCD,PrgmComBass0500BM.ATTR_DPOBCD,  ColumnDef.TYPE_STRING, 100 ){
	            {
	            	 setIsVisibleInGrid(false);
	            }
	        });
	        /** BUSIN_APPTN_YR */
	        listColumnDefs.add(new ColumnLovDef("사업년도", PrgmComBass0500BM.ATTR_BUSINAPPTNYR,PrgmComBass0500BM.ATTR_BUSINAPPTNYR, ColumnDef.TYPE_STRING, 80 ){
	            { 
	            }
	        });
	        /** BUSIN_REPBTY_EMP_NUM == businRepbtyEmpNum*/
            listColumnDefs.add(new ColumnLovDef("직원번호", PrgmComBass0500BM.ATTR_BUSINREPBTYEMPNUM,PrgmComBass0500BM.ATTR_BUSINREPBTYEMPNUM,   ColumnDef.TYPE_STRING, 80 ){
                {
                	 setIsVisibleInGrid(false);
                }
            });
            /** DEPT_CD */
	        listColumnDefs.add(new ColumnLovDef("부서코드", PrgmComBass0500BM.ATTR_DEPTCD,  PrgmComBass0500BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 80 ){
	            {
	            	setIsVisibleInGrid(false);
	            }
	        }); 
	        
	        /** DEPT_NM_HAN == deptNmHan*/
	        listColumnDefs.add(new ColumnLovDef("부서명", PrgmComBass0500BM.ATTR_DEPTNMHAN,PrgmComBass0500BM.ATTR_DEPTNMHAN,   ColumnDef.TYPE_STRING, 80 ){
	            {
	            	setIsVisibleInGrid(false);
	            }
	        });
	        /** DEPT_NM_RTCHNT == deptNmRtchnt*/
	        listColumnDefs.add(new ColumnLovDef("부서명", PrgmComBass0500BM.ATTR_DEPTNMRTCHNT,PrgmComBass0500BM.ATTR_DEPTNMRTCHNT,   ColumnDef.TYPE_STRING, 80 ){
	            {
	            }
	        });
	      
            /** BUSIN_CD == businCd*/
            listColumnDefs.add(new ColumnLovDef("사업코드", PrgmComBass0500BM.ATTR_BUSINCD,PrgmComBass0500BM.ATTR_BUSINCD,   ColumnDef.TYPE_STRING, 80 ){
                {
                }
            });
            /** BUSIN_NM  == businNm*/
            listColumnDefs.add(new ColumnLovDef("사업명", PrgmComBass0500BM.ATTR_BUSINNM,PrgmComBass0500BM.ATTR_BUSINNM,    ColumnDef.TYPE_STRING, 80 ){
                {
                }
            });
	      
	        /** EMYMT_TYP_OCCU_CD == emymtTypOccuCd*/
	        listColumnDefs.add(new ColumnLovDef("사업고용직종코드", PrgmComBass0500BM.ATTR_EMYMTTYPOCCUCD, PrgmComBass0500BM.ATTR_EMYMTTYPOCCUCD,   ColumnDef.TYPE_STRING, 80 ){
	            {
	            	setIsVisibleInGrid(false);
	            }
	        });
	        /** EMYMT_TYP_OCCU_NM == emymtTypOccuNm*/
	        listColumnDefs.add(new ColumnLovDef("직종명", PrgmComBass0500BM.ATTR_EMYMTTYPOCCUNM, PrgmComBass0500BM.ATTR_EMYMTTYPOCCUNM,  ColumnDef.TYPE_STRING, 80 ){
	            {
	            }
	        });
	       
	        /** IDTL_ACCDT_INSUR_APMRT = idtlAccdtInsurApmrt */
	        listColumnDefs.add(new ColumnLovDef("산재보험요율", PrgmComBass0500BM.ATTR_IDTLACCDTINSURAPMRT,PrgmComBass0500BM.ATTR_IDTLACCDTINSURAPMRT,   ColumnDef.TYPE_DOUBLE, 80 ){
	            {
	            	setIsVisibleInGrid(false);
	            }
	        });
	        /** SPITY_CTNT */
	        listColumnDefs.add(new ColumnLovDef("특기사항", PrgmComBass0500BM.ATTR_SPITYCTNT, PrgmComBass0500BM.ATTR_SPITYCTNT,  ColumnDef.TYPE_STRING, 80 ){
	            {
	                setIsVisibleInGrid(false);
	            }
	        });
	        /** NAT_PENN_SYM */
	        listColumnDefs.add(new ColumnLovDef("국민연금기호", PrgmComBass0500BM.ATTR_NATPENNSYM, PrgmComBass0500BM.ATTR_NATPENNSYM,  ColumnDef.TYPE_STRING, 80 ){
	            {
	            	setIsVisibleInGrid(false);
	            }
	        });
	        /** HLTH_INSR_SYM */
	        listColumnDefs.add(new ColumnLovDef("건강보험기호", PrgmComBass0500BM.ATTR_HLTHINSRSYM,  PrgmComBass0500BM.ATTR_HLTHINSRSYM, ColumnDef.TYPE_STRING, 80 ){
	            {
	            	setIsVisibleInGrid(false);
	            }
	        });
	        /** UMYT_INSR_SYM */
	        listColumnDefs.add(new ColumnLovDef("고용보험기호", PrgmComBass0500BM.ATTR_UMYTINSRSYM, PrgmComBass0500BM.ATTR_UMYTINSRSYM,   ColumnDef.TYPE_STRING, 80 ){
	            {
	            	setIsVisibleInGrid(false);
	            }
	        });
	        /** IDTL_ACCDT_INSUR_SYM */
	        listColumnDefs.add(new ColumnLovDef("산재보험기호", PrgmComBass0500BM.ATTR_IDTLACCDTINSURSYM,PrgmComBass0500BM.ATTR_IDTLACCDTINSURSYM,   ColumnDef.TYPE_STRING, 80 ){
	            {
	            	setIsVisibleInGrid(false);
	            }
	        });
	        /** column 사업기간시작일자 : businStdt */
	        listColumnDefs.add(new ColumnLovDef("시작일자", PrgmComBass0500BM.ATTR_BUSINSTDT, PrgmComBass0500BM.ATTR_BUSINSTDT, ColumnDef.TYPE_DATE , 90){
	            {

	            }
	        });
	        /** column 사업기간종료일자 : businEddt */
	        listColumnDefs.add(new ColumnLovDef("종료일자", PrgmComBass0500BM.ATTR_BUSINEDDT, PrgmComBass0500BM.ATTR_BUSINEDDT, ColumnDef.TYPE_DATE , 90){
	            {

	            }
	        });

	        
	        lovDef.setListColumns(listColumnDefs); 

	        lovDef.addHiddenColumn(new PrgmComBass0500Def("").getColumnsDefinition()); 
	        lovDef.setCustomLayoutContainer(getMsfComP0150Filter()); 
	    } 
	    
	    public static final LayoutContainer getMsfComP0150Filter() {
             
            final PrgmComBass0400DTO sysComBass0400Dto; //부서코드  
            final PrgmComBass0500DTO sysComBass0500Dto; //사업년도
            
            sysComBass0400Dto = new PrgmComBass0400DTO();  
            sysComBass0500Dto = new PrgmComBass0500DTO();  
           
           //--------------------급여년도 불러 오는 함수 ------------------------------------------------
            lsBusinApptnYr = PrgmComComboUtils.getPrgmComWithBusinApptnYr(sysComBass0500Dto);
           //--------------------급여년도 불러 오는 함수 ------------------------------------------------
           
           
            //--------------------부서 불러 오는 함수 ------------------------------------------------
            lsDeptCd = PrgmComComboUtils.getDeptBass0400ComboData(sysComBass0400Dto);
            //--------------------부서 불러 오는 함수 ------------------------------------------------
              
            
                final FormPanel fp03 = new FormPanel();   
                fp03.setBodyBorder(false); 
                fp03.setHeaderVisible(false);   
                fp03.setLayout(new FlowLayout(2));      
                fp03.setSize(800, 30);  
              
                 LayoutContainer frmSearchLayer = new LayoutContainer();
                 FormLayout layout = new FormLayout();
                 layout.setDefaultWidth(800);
                 layout.setLabelWidth(30);   
                 frmSearchLayer.setLayout(layout);  
                
                 
                 //검색조건 
                 
                 LayoutContainer  lycSreach = new LayoutContainer(); 
                 FormLayout frmlytStd = new FormLayout();  
                 frmlytStd.setLabelWidth(0);  
                 lycSreach.setLayout(frmlytStd);
                 lycSreach.setHeight(30); 
                 
                 LayoutContainer layoutContainer_12 = new LayoutContainer();
                 layoutContainer_12.setLayout(new ColumnLayout());
                 layoutContainer_12.setStyleAttribute("paddingTop", "5px");
                 
                 LayoutContainer layoutContainer_2 = new LayoutContainer();
                 layoutContainer_12.add(layoutContainer_2,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
                 FormLayout frmlytSch = new FormLayout();  
                 frmlytSch.setLabelWidth(70); 
                 frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
                 layoutContainer_2.setLayout(frmlytSch);
                 
                 businApptnYr =  new ComboBox<BaseModel>(); 
                 businApptnYr.setForceSelection(true);
                 businApptnYr.setMinChars(1);
                 businApptnYr.setDisplayField("businApptnYrDisp");
                 businApptnYr.setValueField("businApptnYr");
                 businApptnYr.setTriggerAction(TriggerAction.ALL);
                 businApptnYr.setEmptyText("--사업년도선택--");
                 businApptnYr.setSelectOnFocus(true); 
                 businApptnYr.setReadOnly(false);
                 businApptnYr.setEnabled(true); 
                 businApptnYr.setStore(lsBusinApptnYr);
                 businApptnYr.setFieldLabel("사업년도"); 
                 lsBusinApptnYr.addListener(Events.Change, new Listener<BaseEvent>() {
                     public void handleEvent(BaseEvent be) {  
//                         Date today = new Date(); 
//                         // A custom date format
//                         DateTimeFormat fmt = DateTimeFormat.getFormat("yyyy"); 
//                     
//                         BaseModel  bm  =  businApptnYr.getStore().findModel("year", fmt.format(today) ); 
                         businApptnYr.setValue(lsBusinApptnYr.getAt(0)); 
                     }
                 });
                 
                 layoutContainer_2.add(businApptnYr, new FormData("100%")); 
                 layoutContainer_2.setBorders(false);
                 
                 LayoutContainer layoutContainer_1 = new LayoutContainer();
                 layoutContainer_12.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.3));
                 frmlytSch = new FormLayout();  
                 frmlytSch.setLabelWidth(70); 
                 frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
                 layoutContainer_1.setLayout(frmlytSch);
                 
                 deptCd = new ComboBox<BaseModel>();
                 deptCd.setForceSelection(true);
                 deptCd.setMinChars(1);
                 deptCd.setDisplayField("deptNmRtchnt");
                 deptCd.setValueField("deptCd");
                 deptCd.setTriggerAction(TriggerAction.ALL);
                 deptCd.setEmptyText("--부서선택--");
                 deptCd.setSelectOnFocus(true); 
                 deptCd.setReadOnly(gwtExtAuth.getReadOnlyDeptCd());
                 deptCd.setEnabled(gwtExtAuth.getEnableDeptCd()); 
                 deptCd.setStore(lsDeptCd );
                 deptCd.setFieldLabel("부서");
                 deptCd.getStore().addStoreListener( new StoreListener<BaseModel>() {   
                     public void handleEvent(StoreEvent<BaseModel> be) {  

                         /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                          * 권한설정을 위한 콤보처리를 위한 메서드 시작 
                          * 값순서 : 단위기관 ,고용구분, 부서, 직종, 사업 순으로  없으면 ""
                          ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
                    	// gwtAuthorization.formAuthConfig(fp03, "","","deptCd","","");
                         /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                          * 권한설정을 위한 콤보처리를 위한 메서드 종료
                          ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
                         
                     }
                 });    
               
                 layoutContainer_1.add(deptCd, new FormData("100%"));
                 layoutContainer_1.setBorders(false);  
               
                 LayoutContainer layoutContainer_13 = new LayoutContainer();
                 frmlytStd = new FormLayout();  
                 frmlytStd.setLabelWidth(60); 
                 frmlytStd.setLabelAlign(LabelAlign.RIGHT);
                 layoutContainer_13.setLayout(frmlytStd);
                
                 businNm = new TextField<String>(); 
                 businNm.setFieldLabel("사 업");
//                 usrNm.addKeyListener(new KeyListener() {
//                    public void componentKeyUp(ComponentEvent event) {
//                        super.componentKeyUp(event);
//                        usrNm.validate();
//                        if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
//                          
//                       
//                        }
//                    }
//                 });

                 layoutContainer_13.add(businNm, new FormData("100%")); 
                 layoutContainer_13.setBorders(false);
             
                 btnUsrSearch = new Button("검색");
                 btnUsrSearch.setIcon(MSFMainApp.ICONS.search());
//                     btnUsrSearch.addListener(Events.Select, new Listener<ButtonEvent>() {
//                     public void handleEvent(ButtonEvent e) {
//                           
//                        // reload(); 
//                     }
//                 });
                 
                 layoutContainer_12.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
                 layoutContainer_12.add(btnUsrSearch );
                 lycSreach.add(layoutContainer_12);
                
                fp03.add(lycSreach);
                
                frmSearchLayer.add(fp03);
              
                return frmSearchLayer ;
          }

}
