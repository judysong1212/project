/**
 * 공통화면 팝업 
 */
package com.app.exterms.prgm.client.form;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.form.defs.PrgmComBass0300Def;
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

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class PrgmComP0130  extends Lov implements PrgmComDaoConstants { 

	    /**######################################################
		 * { 시스템 기본설정파일 선언부  시작}
		 *#######################################################*/
	 

	     /**######################################################
	 	 * { 시스템 기본설정파일 선언부  종료}
	 	 *#######################################################*/
 
	    private PrgmConstants SysComLabel = PrgmConstants.INSTANCE;
	    

	    private static TextField<String> commCdNm ;
	    public static Button btnUsrSearch;
	     
	    
	    public TextField<String> getCommCdNm() {
			return commCdNm;
		}

		public void setCommCdNm(TextField<String> commCdNm) {
			PrgmComP0130.commCdNm = commCdNm;
		}

		public PrgmComP0130(int width, int height) {
	        this();
	        this.width  = width;
	        this.height = height;
	    }

	    public PrgmComP0130() {

	        lovDef = new LovDef();
	        lovDef.setTitle(SysComLabel.titleSysComPopUpBass0300());  //팝업상단의 타이틀 
	        lovDef.setDaoClass("");
	        lovDef.setAutoFillGrid(false);
	        lovDef.setCustomListMethod(PRGMCOM_METHOD_POPUP_BASS0300_List);
	       
	         
	        List<ColumnLovDef> listColumnDefs = new ArrayList<ColumnLovDef>();
	        listColumnDefs.add(new ColumnLovDef("사업장코드", "dpobCd", "dpobCd", ColumnDef.TYPE_STRING, 100){
	            {
	                setIsVisibleInGrid(false);
	            }
	        }); 
	        listColumnDefs.add(new ColumnLovDef("코드", "commCd", "commCd", ColumnDef.TYPE_STRING, 80));  
	        listColumnDefs.add(new ColumnLovDef("대표코드", "rpsttvCd", "rpsttvCd", ColumnDef.TYPE_STRING, 80){
	        	{
	        		setIsVisibleInGrid(false);
	        	}
	        });  
	        listColumnDefs.add(new ColumnLovDef("세부코드", "dtlCd", "dtlCd", ColumnDef.TYPE_STRING, 80){
	        	{
	        		setIsVisibleInGrid(false);
	        	}
	        });  
	        listColumnDefs.add(new ColumnLovDef("코드명", "commCdNm", "commCdNm", ColumnDef.TYPE_STRING, 200));
	         
	        
	        lovDef.setListColumns(listColumnDefs); 

	        lovDef.addHiddenColumn(new PrgmComBass0300Def().getColumnsDefinition()); 
	        lovDef.setCustomLayoutContainer(getMsfComP0130Filter()); 
	    } 


	    public static final LayoutContainer getMsfComP0130Filter() {
	          
	         
	          LayoutContainer frmSearchLayer = new LayoutContainer();
	          FormLayout layout = new FormLayout();
	          layout.setDefaultWidth(350);
	          layout.setLabelWidth(40);   
	          frmSearchLayer.setLayout(layout);  
	          
	          ContentPanel cp03 = new ContentPanel();   
	          cp03.setBodyBorder(false); 
	          cp03.setHeaderVisible(false);   
	          cp03.setLayout(new FlowLayout(2));      
	          cp03.setSize(350, 38);
	          /** 여기화면 추가 */ 
	            
	            FieldSet fieldSet = new FieldSet();  
	            //fieldSet.setHeading("");  
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
	           
	            commCdNm = new TextField<String>();
	            commCdNm.setFieldLabel("검색조건"); 

	            
	            layoutContainer_13.add(commCdNm, new FormData("100%")); 
	            layoutContainer_13.setBorders(false);
	        
	            btnUsrSearch = new Button("검색");
	            btnUsrSearch.setIcon(MSFMainApp.ICONS.search());
	            
	        
	            layoutContainer_12.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.7));
	            layoutContainer_12.add(btnUsrSearch );
	            lycSreach.add(layoutContainer_12);

	            fieldSet.add(lycSreach,  new FormData("100%"));     
	            
	            cp03.add(fieldSet);
	            
	            frmSearchLayer.add(cp03);
	          
	            return frmSearchLayer ;
	      }   
	    

	    
}
