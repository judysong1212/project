/**
 * 단위사업장 검색 
 */
package com.app.exterms.prgm.client.form;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0120BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComP0500BM;
import com.app.exterms.prgm.client.form.defs.PrgmComBass0400Def;
import com.app.exterms.prgm.client.languages.PrgmConstants;
import com.app.exterms.prgm.client.util.PrgmComComboUtils;
import com.app.exterms.prgm.shared.PrgmComDaoConstants;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.def.ColumnLovDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnLovDef;
import com.app.smrmf.core.msfmainapp.client.def.LovDef;
import com.app.smrmf.core.msfmainapp.client.generics.Lov;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;

 
public class PrgmComPBass120001  extends Lov implements PrgmComDaoConstants { 

	 /**######################################################
		 * { 시스템 기본설정파일 선언부  시작}
		 *#######################################################*/
	 

	     /**######################################################
	 	 * { 시스템 기본설정파일 선언부  종료}
	 	 *#######################################################*/

	  private PrgmConstants SysComLabel = PrgmConstants.INSTANCE;
	  
	 
	 
	  private static TextField<String> utDpobNm;       //단위 사업장명 
      public static Button btnUsrSearch;
	     
      
	public static TextField<String> getUtDpobNm() {
		return utDpobNm;
	}

	public static void setUtDpobNm(TextField<String> utDpobNm) {
		PrgmComPBass120001.utDpobNm = utDpobNm;
	}

		public PrgmComPBass120001(int width, int height) {
	        this();
	        this.width  = width;
	        this.height = height;
	    }

	    public PrgmComPBass120001() {

	        lovDef = new LovDef();
	        lovDef.setTitle("단위사업장검색");  //팝업상단의 타이틀 
	        lovDef.setDaoClass("");
	        lovDef.setAutoFillGrid(false);
	        lovDef.setFilterForm(false);  
	        lovDef.setCustomListMethod(PRGMCOM_METHOD_BASS0120_LIST);
	        lovDef.setCheckBoxOnGridRows(true);
	        
	        List<ColumnLovDef> listColumnLovDefs = new ArrayList<ColumnLovDef>();
	        
	        /** column 사업장코드 : dpobCd */
	        listColumnLovDefs.add(new ColumnLovDef("사업장코드", PrgmComP0500BM.ATTR_DPOBCD,PrgmComP0500BM.ATTR_DPOBCD, ColumnLovDef.TYPE_STRING , 90){
	            {
	                setIsVisibleInGrid(false);
	            }
	        });
	        
	       
	        /** column 단위사업장코드 : utDpobCd */
	        listColumnLovDefs.add(new ColumnLovDef("단위사업장코드", PrgmComBass0120BM.ATTR_UTDPOBCD,  PrgmComBass0120BM.ATTR_UTDPOBCD, ColumnLovDef.TYPE_STRING , 90 ){
	        	{
	        		 setIsVisibleInGrid(false);
	        	}
	        });
	        /** column 단위사업장명 : utDpobNm */
	        listColumnLovDefs.add(new ColumnLovDef("단위사업장명", PrgmComBass0120BM.ATTR_UTDPOBNM,PrgmComBass0120BM.ATTR_UTDPOBNM, ColumnLovDef.TYPE_STRING , 90){
	        	{

	        	}
	        });
	        
	        
	        /** column 상위단위사업장코드 : hhrkUntDpobCd */
	        listColumnLovDefs.add(new ColumnLovDef("상위단위사업장코드", PrgmComBass0120BM.ATTR_HHRKUNTDPOBCD, PrgmComBass0120BM.ATTR_HHRKUNTDPOBCD, ColumnLovDef.TYPE_STRING , 90 ){
	        	{
	        		   setIsVisibleInGrid(false);
	        	}
	        });
	        
	        /** column 사업자등록번호 : busoprRgstnNum */
	        listColumnLovDefs.add(new ColumnLovDef("사업자등록번호", PrgmComBass0120BM.ATTR_BUSOPRRGSTNNUM, PrgmComBass0120BM.ATTR_BUSOPRRGSTNNUM, ColumnLovDef.TYPE_STRING , 90 ){
	        	{

	        	}
	        });
	        
	        /** column 대표자주민번호 : degtrResnRegnNum */
	        listColumnLovDefs.add(new ColumnLovDef("대표자주민번호", PrgmComBass0120BM.ATTR_DEGTRRESNREGNNUM,  PrgmComBass0120BM.ATTR_DEGTRRESNREGNNUM, ColumnLovDef.TYPE_STRING , 90 ){
	        	{
	        		 setIsVisibleInGrid(false);
	        	}
	        });
	        /** column 대표자명 : degtrNm */
	        listColumnLovDefs.add(new ColumnLovDef("대표자명", PrgmComBass0120BM.ATTR_DEGTRNM,PrgmComBass0120BM.ATTR_DEGTRNM, ColumnLovDef.TYPE_STRING , 90 ){
	        	{

	        	}
	        });
	        
	        /** column 주종사업장코드 : mtstBusinDivCd */
	        listColumnLovDefs.add(new ColumnLovDef("주종사업장코드", PrgmComBass0120BM.ATTR_MTSTBUSINDIVCD,PrgmComBass0120BM.ATTR_MTSTBUSINDIVCD,  ColumnLovDef.TYPE_STRING , 90 ){
	        	{
	        		 setIsVisibleInGrid(false);
	        	}
	        });
	        
	        /** column 주종사업장코드 : mtstBusinDivCd */
	        listColumnLovDefs.add(new ColumnLovDef("주종사업장", PrgmComBass0120BM.ATTR_MTSTBUSINDIVNM, PrgmComBass0120BM.ATTR_MTSTBUSINDIVNM, ColumnLovDef.TYPE_STRING , 90 ){
	        	{
	        	 
	        	}
	        });
	        /** column C171_사업자단위과세자여부 : upDpobUtynC171 */
	        listColumnLovDefs.add(new ColumnLovDef("C171_사업자단위과세자여부", PrgmComBass0120BM.ATTR_UPDPOBUTYNC171,  PrgmComBass0120BM.ATTR_UPDPOBUTYNC171, ColumnLovDef.TYPE_STRING , 90 ){
	        	{
	        		   setIsVisibleInGrid(false);
	        	}
	        });
	        /** column C172_종사업장일련번호 : mtstDpobSeilNumC172 */
	        listColumnLovDefs.add(new ColumnLovDef("주종사업장번호", PrgmComBass0120BM.ATTR_MTSTDPOBSEILNUMC172, PrgmComBass0120BM.ATTR_MTSTDPOBSEILNUMC172, ColumnLovDef.TYPE_STRING , 90 ){
	        	{
	        	 
	        	}
	        });
	        /** column 본지점구분코드 : mnbhDivCd */
	        listColumnLovDefs.add(new ColumnLovDef("본지점구분코드", PrgmComBass0120BM.ATTR_MNBHDIVCD,  PrgmComBass0120BM.ATTR_MNBHDIVCD, ColumnLovDef.TYPE_STRING , 90 ){
	        	{
	        		   setIsVisibleInGrid(false);
	        	}
	        });
	        /** column 원천세신고유형구분코드 : whdgTxCtypDivCd */
	        listColumnLovDefs.add(new ColumnLovDef("원천세신고유형구분코드", PrgmComBass0120BM.ATTR_WHDGTXCTYPDIVCD,PrgmComBass0120BM.ATTR_WHDGTXCTYPDIVCD, ColumnLovDef.TYPE_STRING , 90 ){
	        	{
	        		 setIsVisibleInGrid(false);
	        	}
	        });
	        /** column 원천세신고유형구분코드 : whdgTxCtypDivNm */
	        listColumnLovDefs.add(new ColumnLovDef("원천세신고유형", PrgmComBass0120BM.ATTR_WHDGTXCTYPDIVNM,PrgmComBass0120BM.ATTR_WHDGTXCTYPDIVNM, ColumnLovDef.TYPE_STRING , 90 ){
	        	{
	        		   
	        	}
	        });
	        
	        
	        /** column 내외국인구분코드 : frgnrDivCd */
	        listColumnLovDefs.add(new ColumnLovDef("내외국인구분코드", PrgmComBass0120BM.ATTR_FRGNRDIVCD, PrgmComBass0120BM.ATTR_FRGNRDIVCD, ColumnLovDef.TYPE_STRING , 90 ){
	        	{
	        		   setIsVisibleInGrid(false);
	        	}
	        });
	     
	        /** column 법인등록번호 : corpRgstnNum */
	        listColumnLovDefs.add(new ColumnLovDef("법인등록번호", PrgmComBass0120BM.ATTR_CORPRGSTNNUM, PrgmComBass0120BM.ATTR_CORPRGSTNNUM, ColumnLovDef.TYPE_STRING , 90 ){
	        	{
	        		   setIsVisibleInGrid(false);
	        	}
	        });
	        /** column 법인구분코드 : corpDivCd */
	        listColumnLovDefs.add(new ColumnLovDef("법인구분코드", PrgmComBass0120BM.ATTR_CORPDIVCD,PrgmComBass0120BM.ATTR_CORPDIVCD, ColumnLovDef.TYPE_STRING , 90 ){
	        	{
	        		   setIsVisibleInGrid(false);
	        	}
	        });
	        /** column 단위사업장우편번호 : untDpobZpcd */
	        listColumnLovDefs.add(new ColumnLovDef("우편번호", PrgmComBass0120BM.ATTR_UNTDPOBZPCD,PrgmComBass0120BM.ATTR_UNTDPOBZPCD, ColumnLovDef.TYPE_STRING , 90 ){
	        	{

	        	}
	        });
	        /** column 단위사업장기본주소 : untDpobFndtnAddr */
	        listColumnLovDefs.add(new ColumnLovDef("기본주소", PrgmComBass0120BM.ATTR_UNTDPOBFNDTNADDR, PrgmComBass0120BM.ATTR_UNTDPOBFNDTNADDR, ColumnLovDef.TYPE_STRING , 90 ){
	        	{

	        	}
	        });
	        /** column 단위사업장상세주소 : untDpobDtlPatrAddr */
	        listColumnLovDefs.add(new ColumnLovDef("상세주소", PrgmComBass0120BM.ATTR_UNTDPOBDTLPATRADDR,PrgmComBass0120BM.ATTR_UNTDPOBDTLPATRADDR, ColumnLovDef.TYPE_STRING , 90 ){
	        	{

	        	}
	        });
	        /** column 단위사업장전화번호 : untDpobPhnNum */
	        listColumnLovDefs.add(new ColumnLovDef("전화번호", PrgmComBass0120BM.ATTR_UNTDPOBPHNNUM, PrgmComBass0120BM.ATTR_UNTDPOBPHNNUM, ColumnLovDef.TYPE_STRING , 90 ){
	        	{

	        	}
	        });
	        /** column 단위사업장팩스번호 : untDpobFaxNum */
	        listColumnLovDefs.add(new ColumnLovDef("팩스번호", PrgmComBass0120BM.ATTR_UNTDPOBFAXNUM,PrgmComBass0120BM.ATTR_UNTDPOBFAXNUM,  ColumnLovDef.TYPE_STRING , 90 ){
	        	{

	        	}
	        });
	        /** column 단위사업장전자우편주소 : untDpobEctnMailAddr */
	        listColumnLovDefs.add(new ColumnLovDef("전자우편주소", PrgmComBass0120BM.ATTR_UNTDPOBECTNMAILADDR,  PrgmComBass0120BM.ATTR_UNTDPOBECTNMAILADDR, ColumnLovDef.TYPE_STRING , 90 ){
	        	{

	        	}
	        });
	       
	        /** column 단위사업장설립일자 : untDpobEsbmDt */
	        listColumnLovDefs.add(new ColumnLovDef("설립일자", PrgmComBass0120BM.ATTR_UNTDPOBESBMDT, PrgmComBass0120BM.ATTR_UNTDPOBESBMDT, ColumnLovDef.TYPE_STRING , 90 ){
	        	{

	        	}
	        });
	        /** column 단위사업장개업일자 : untDpobIngnDt */
	        listColumnLovDefs.add(new ColumnLovDef("개업일자", PrgmComBass0120BM.ATTR_UNTDPOBINGNDT, PrgmComBass0120BM.ATTR_UNTDPOBINGNDT, ColumnLovDef.TYPE_STRING , 90 ){
	        	{

	        	}
	        });
	        /** column 단위사업장폐업일자 : untDpobEobDt */
	        listColumnLovDefs.add(new ColumnLovDef("폐업일자", PrgmComBass0120BM.ATTR_UNTDPOBEOBDT,PrgmComBass0120BM.ATTR_UNTDPOBEOBDT, ColumnLovDef.TYPE_STRING , 90 ){
	        	{

	        	}
	        });
	       
	        /** column 단위사업장기본사용여부 : untDpobFndtnUseYn */
	        listColumnLovDefs.add(new ColumnLovDef("사용여부", PrgmComBass0120BM.ATTR_UNTDPOBFNDTNUSEYN, PrgmComBass0120BM.ATTR_UNTDPOBFNDTNUSEYN, ColumnLovDef.TYPE_STRING , 90 ){
	        	{

	        	}
	        });
	      
	    
	        /** column 단위사업장승인번호 : upDpobCmpNo */
	        listColumnLovDefs.add(new ColumnLovDef("단위사업장승인번호", PrgmComBass0120BM.ATTR_UPDPOBCMPNO,  PrgmComBass0120BM.ATTR_UPDPOBCMPNO, ColumnLovDef.TYPE_STRING , 90 ){
	        	{
	        		   setIsVisibleInGrid(false);
	        	}
	        });
	   
	        lovDef.setListColumns(listColumnLovDefs); 

	        lovDef.addHiddenColumn(new PrgmComBass0400Def().getColumnsDefinition()); 
	        lovDef.setCustomLayoutContainer(getPrgmComPBass120001Filter()); 
	       
	    } 
	    
	    public static final LayoutContainer getPrgmComPBass120001Filter() {
            
          
            
                ContentPanel cp03 = new ContentPanel();   
                cp03.setBodyBorder(false); 
                cp03.setHeaderVisible(false);   
                cp03.setLayout(new FlowLayout(2));      
                cp03.setSize(800, 30);  
              
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
                  
                 
                 LayoutContainer layoutContainer_1 = new LayoutContainer();
                 layoutContainer_12.add(layoutContainer_1,new com.extjs.gxt.ui.client.widget.layout.ColumnData(.6));
                 FormLayout frmlytSch = new FormLayout();  
                 frmlytSch.setLabelWidth(70); 
                 frmlytSch.setLabelAlign(LabelAlign.RIGHT); 
                 layoutContainer_1.setLayout(frmlytSch);
                  
                 
                 utDpobNm = new TextField<String>(); 
                 utDpobNm.setFieldLabel("단위사업장"); 
                 
                 layoutContainer_1.add(utDpobNm, new FormData("100%"));
                 layoutContainer_1.setBorders(false);  
               
                 LayoutContainer layoutContainer_13 = new LayoutContainer();
                 frmlytStd = new FormLayout();  
                 frmlytStd.setLabelWidth(60); 
                 frmlytStd.setLabelAlign(LabelAlign.RIGHT);
                 layoutContainer_13.setLayout(frmlytStd);
               

               //  layoutContainer_13.add(payExtpyNm, new FormData("100%")); 
                 layoutContainer_13.setBorders(false);
             
                 btnUsrSearch = new Button("검색");
                 btnUsrSearch.setIcon(MSFMainApp.ICONS.search()); 
                 
                 layoutContainer_12.add(layoutContainer_13, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.25));
                 layoutContainer_12.add(btnUsrSearch );
                 lycSreach.add(layoutContainer_12);
                
                cp03.add(lycSreach);
                
                frmSearchLayer.add(cp03);
              
                return frmSearchLayer ;
          }

}
