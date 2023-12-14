/**
 * 부서관리 팝업화면 
 */
package com.app.exterms.prgm.client.form;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0400BM;
import com.app.exterms.prgm.client.form.defs.PrgmComBass0400Def;
import com.app.exterms.prgm.client.languages.PrgmConstants;
import com.app.exterms.prgm.shared.PrgmComDaoConstants;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnLovDef;
import com.app.smrmf.core.msfmainapp.client.def.LovDef;
import com.app.smrmf.core.msfmainapp.client.generics.Lov;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
 
public class PrgmComP0140  extends Lov implements PrgmComDaoConstants { 
  
	 /**######################################################
	 * { 시스템 기본설정파일 선언부  시작}
	 *#######################################################*/
 

     /**######################################################
 	 * { 시스템 기본설정파일 선언부  종료}
 	 *#######################################################*/

    private PrgmConstants SysComLabel = PrgmConstants.INSTANCE;
    
    private static TextField<String> deptNm ; 
    public static Button btnUsrSearch;
     
    
    public static TextField<String> getDeptNm() {
		return deptNm;
	}

	public static void setDeptNm(TextField<String> deptNm) {
		PrgmComP0140.deptNm = deptNm;
	}

	public PrgmComP0140(int width, int height) {
        this();
        this.width  = width;
        this.height = height;
    }

    public PrgmComP0140() {

        lovDef = new LovDef();
        lovDef.setTitle(SysComLabel.titleSysComPopUpBass0400());  //팝업상단의 타이틀 
        lovDef.setDaoClass(CLASS_SYSCOM_BASS0400VO);
        lovDef.setAutoFillGrid(true);
        lovDef.setFilterForm(false);  
        lovDef.setCustomListMethod(PRGMCOM_METHOD_POPUP_BASS0400_List);
       
        List<ColumnLovDef> listColumnDefs = new ArrayList<ColumnLovDef>();
      
        
        /** DPOB_CD */
        listColumnDefs.add(new ColumnLovDef("사업장코드", PrgmComBass0400BM.ATTR_DPOBCD,  PrgmComBass0400BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 100){
            {
            	  setIsVisibleInGrid(false);
            }
        });
        listColumnDefs.add(new ColumnLovDef("부서코드", PrgmComBass0400BM.ATTR_DEPTCD, PrgmComBass0400BM.ATTR_DEPTCD,ColumnDef.TYPE_STRING, 80) );
          
        /** DEPT_NM_HAN */
        listColumnDefs.add(new ColumnLovDef("부서명", PrgmComBass0400BM.ATTR_DEPTNMHAN,PrgmComBass0400BM.ATTR_DEPTNMHAN,  ColumnDef.TYPE_STRING, 200){
            {
            	// setIsVisibleInGrid(false);
            }
        });
        /** DEPT_NM_RTCHNT */
        listColumnDefs.add(new ColumnLovDef("부서명", PrgmComBass0400BM.ATTR_DEPTNMRTCHNT,PrgmComBass0400BM.ATTR_DEPTNMRTCHNT,  ColumnDef.TYPE_STRING, 150) );
        /** DEPT_NM_ENG */
        listColumnDefs.add(new ColumnLovDef("부서영문명", PrgmComBass0400BM.ATTR_DEPTNMENG, PrgmComBass0400BM.ATTR_DEPTNMENG, ColumnDef.TYPE_STRING, 80){
            {
            	 setIsVisibleInGrid(false);
            }
        });
        /** TPLVL_DEPT_CD */
        listColumnDefs.add(new ColumnLovDef("최상위부서", PrgmComBass0400BM.ATTR_TPLVLDEPTCD,  PrgmComBass0400BM.ATTR_TPLVLDEPTCD, ColumnDef.TYPE_STRING, 80){
            {
            	 setIsVisibleInGrid(false);
            }
        });
        /** HHRK_DEPT_CD */
        listColumnDefs.add(new ColumnLovDef("상위부서", PrgmComBass0400BM.ATTR_HHRKDEPTCD,PrgmComBass0400BM.ATTR_HHRKDEPTCD, ColumnDef.TYPE_STRING, 80){
            {
            	 setIsVisibleInGrid(false);
            }
        });
        /** DEPT_USE_YN */
        listColumnDefs.add(new ColumnLovDef("사용여부", PrgmComBass0400BM.ATTR_DEPTUSEYN, PrgmComBass0400BM.ATTR_DEPTUSEYN, ColumnDef.TYPE_STRING, 50){
            {
            	// setIsVisibleInGrid(false);
            }
        });
        /** NAT_PENN_SYM */
        listColumnDefs.add(new ColumnLovDef("국민연금기호", PrgmComBass0400BM.ATTR_NATPENNSYM, PrgmComBass0400BM.ATTR_NATPENNSYM, ColumnDef.TYPE_STRING, 80){
            {
            	 setIsVisibleInGrid(false);
            }
        });
        /** HLTH_INSR_SYM */
        listColumnDefs.add(new ColumnLovDef("건강보험기호", PrgmComBass0400BM.ATTR_HLTHINSRSYM,PrgmComBass0400BM.ATTR_HLTHINSRSYM,  ColumnDef.TYPE_STRING, 80){
            {
            	 setIsVisibleInGrid(false);
            }
        });
        /** UMYT_INSR_SYM */
        listColumnDefs.add(new ColumnLovDef("고용보험기호", PrgmComBass0400BM.ATTR_UMYTINSRSYM,PrgmComBass0400BM.ATTR_UMYTINSRSYM,  ColumnDef.TYPE_STRING, 80){
            {
            	 setIsVisibleInGrid(false);
            }
        });
        /** IDTL_ACCDT_INSUR_SYM */
        listColumnDefs.add(new ColumnLovDef("산재보험기호", PrgmComBass0400BM.ATTR_IDTLACCDTINSURSYM,PrgmComBass0400BM.ATTR_IDTLACCDTINSURSYM,  ColumnDef.TYPE_STRING, 80){
            {
            	 setIsVisibleInGrid(false);
            }
        });
        /** DEPT_NOTE_CTNT */
        listColumnDefs.add(new ColumnLovDef("비고", PrgmComBass0400BM.ATTR_DEPTNOTECTNT, PrgmComBass0400BM.ATTR_DEPTNOTECTNT, ColumnDef.TYPE_STRING, 80){
            {
            	 setIsVisibleInGrid(false);
            }
        });

        /** DEPT_DSPY_YN 부서출력여부*/
        listColumnDefs.add(new ColumnLovDef("부서출력여부", PrgmComBass0400BM.ATTR_DEPTDSPYYN,PrgmComBass0400BM.ATTR_DEPTDSPYYN,  ColumnDef.TYPE_STRING, 80){
            {
            	 setIsVisibleInGrid(false); 
            }
        });
        /** column 단위기관코드 : payrMangDeptCd */
        listColumnDefs.add(new ColumnLovDef("단위기관코드", PrgmComBass0400BM.ATTR_PAYRMANGDEPTCD, PrgmComBass0400BM.ATTR_PAYRMANGDEPTCD,ColumnDef.TYPE_STRING, 90){
        	{
        		 setIsVisibleInGrid(false); 
        	}
        });
        
        /** column 단위기관 : payrMangDept */
        listColumnDefs.add(new ColumnLovDef("단위기관", PrgmComBass0400BM.ATTR_PAYRMANGDEPTNM,  PrgmComBass0400BM.ATTR_PAYRMANGDEPTNM, ColumnDef.TYPE_STRING , 90){
        	{
        		 setIsVisibleInGrid(false); 
        	}
        });
        /** MANGE_DEPT_CD 관리부서코드 */
        listColumnDefs.add(new ColumnLovDef("관리부서코드", PrgmComBass0400BM.ATTR_MANGEDEPTCD,  PrgmComBass0400BM.ATTR_MANGEDEPTCD, ColumnDef.TYPE_STRING, 80) {
            {
           	 setIsVisibleInGrid(false); 
           }
       });
        /** MANGE_DEPT_NM 관리부서명 */
        listColumnDefs.add(new ColumnLovDef("관리부서명", PrgmComBass0400BM.ATTR_MANGEDEPTNM, PrgmComBass0400BM.ATTR_MANGEDEPTNM, ColumnDef.TYPE_STRING, 80){
            {
            	 setIsVisibleInGrid(false);
            }
        });
        /** MANGE_DEPT_NM 관리부서약어명 */
        listColumnDefs.add(new ColumnLovDef("관리부서", PrgmComBass0400BM.ATTR_MANGEDEPTNMRTCHNT,PrgmComBass0400BM.ATTR_MANGEDEPTNMRTCHNT, ColumnDef.TYPE_STRING, 80) {
            {
           	 setIsVisibleInGrid(false); 
           }
       });
        
        
        lovDef.setListColumns(listColumnDefs); 

        lovDef.addHiddenColumn(new PrgmComBass0400Def().getColumnsDefinition()); 
        lovDef.setCustomLayoutContainer(getMsfComP0140Filter()); 
    } 


    public static final LayoutContainer getMsfComP0140Filter() {
          
         
          LayoutContainer frmSearchLayer = new LayoutContainer();
          FormLayout layout = new FormLayout();
          layout.setDefaultWidth(600);
          layout.setLabelWidth(40);   
          frmSearchLayer.setLayout(layout);  
          
          ContentPanel cp03 = new ContentPanel();   
          cp03.setBodyBorder(false); 
          cp03.setHeaderVisible(false);   
          cp03.setLayout(new FlowLayout(2));      
          cp03.setSize(600, 38);
          /** 여기화면 추가 */ 
            
            FieldSet fieldSet = new FieldSet();  
           // fieldSet.setHeading("");  
            fieldSet.setHeadingHtml("");
            //검색조건  
            LayoutContainer  lycSreach = new LayoutContainer(); 
            FormLayout frmlytStd = new FormLayout();  
            frmlytStd.setLabelWidth(0);  
            lycSreach.setLayout(frmlytStd);
         //   lycSreach.setHeight(30); 
            
            LayoutContainer layoutContainer_12 = new LayoutContainer();
            layoutContainer_12.setLayout(new ColumnLayout());
          //  layoutContainer_12.setStyleAttribute("paddingTop", "5px");
            LayoutContainer layoutContainer_13 = new LayoutContainer();
            frmlytStd = new FormLayout();  
            frmlytStd.setLabelWidth(60); 
            frmlytStd.setLabelAlign(LabelAlign.RIGHT);
            layoutContainer_13.setLayout(frmlytStd);
           
            deptNm = new TextField<String>();
            deptNm.setFieldLabel("부 서"); 

            
            layoutContainer_13.add(deptNm, new FormData("100%")); 
            layoutContainer_13.setBorders(false);
        
            btnUsrSearch = new Button("검색");
            btnUsrSearch.setIcon(MSFMainApp.ICONS.search());
            
        
            layoutContainer_12.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.5));
            layoutContainer_12.add(btnUsrSearch );
            lycSreach.add(layoutContainer_12);

            fieldSet.add(lycSreach,  new FormData("100%"));     
            
            cp03.add(fieldSet);
            
            frmSearchLayer.add(cp03);
          
            return frmSearchLayer ;
      }
}
