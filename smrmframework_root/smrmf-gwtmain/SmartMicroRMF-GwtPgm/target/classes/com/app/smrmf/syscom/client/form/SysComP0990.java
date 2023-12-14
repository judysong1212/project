/**
 * sso 사용자 팝업화면 
 */
package com.app.smrmf.syscom.client.form;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnLovDef;
import com.app.smrmf.core.msfmainapp.client.def.LovDef;
import com.app.smrmf.core.msfmainapp.client.generics.Lov;
import com.app.smrmf.syscom.client.dto.SsoxUserBM;
import com.app.smrmf.syscom.client.form.defs.SsoxUserDef;
import com.app.smrmf.syscom.client.languages.SysComConstants;
import com.app.smrmf.syscom.shared.SysComDaoConstants;

 
public class SysComP0990  extends Lov implements SysComDaoConstants { 

	/**######################################################
	 * { 시스템 기본설정파일 선언부  시작}
	 *#######################################################*/
	 

	     /**######################################################
	 	 * { 시스템 기본설정파일 선언부  종료}
	 	 *#######################################################*/

	  private SysComConstants SysComLabel = SysComConstants.INSTANCE;
	    
	    public SysComP0990(int width, int height) {
	        this();
	        this.width  = width;
	        this.height = height;
	    }

	    public SysComP0990() {

	        lovDef = new LovDef();
	        lovDef.setTitle("사용자정보");  //팝업상단의 타이틀 
	        lovDef.setDaoClass("");
	        lovDef.setAutoFillGrid(true);
	        lovDef.setFilterForm(false);  
	        lovDef.setCustomListMethod(CLASS_SSOXUSER_LIST);
	       
	        List<ColumnLovDef> listColumnDefs = new ArrayList<ColumnLovDef>();
	        
	        /** column 부서코드 : deptId */
	        listColumnDefs.add(new ColumnLovDef("부서코드", SsoxUserBM.ATTR_DEPTID, SsoxUserBM.ATTR_DEPTID, ColumnDef.TYPE_STRING , 90){
	        	{
	        		 setIsVisibleInGrid(false);
	        	}
	        });
	        /** column 부서 : deptName */
	        listColumnDefs.add(new ColumnLovDef("부서", SsoxUserBM.ATTR_DEPTNAME,SsoxUserBM.ATTR_DEPTNAME, ColumnDef.TYPE_STRING , 140){
	        	{

	        	}
	        }); 
	        
	        /** column 고용형태 : classId */
	        listColumnDefs.add(new ColumnLovDef("고용형태", SsoxUserBM.ATTR_CLASSID,SsoxUserBM.ATTR_CLASSID, ColumnDef.TYPE_STRING , 90){
	        	{
	        		 setIsVisibleInGrid(false);
	        	}
	        });
	        /** column 고용형태 : className */
	        listColumnDefs.add(new ColumnLovDef("고용형태", SsoxUserBM.ATTR_CLASSNAME,SsoxUserBM.ATTR_CLASSNAME, ColumnDef.TYPE_STRING , 120){
	        	{

	        	}
	        });

	        /** column 아이디 : userId */
	        listColumnDefs.add(new ColumnLovDef("아이디", SsoxUserBM.ATTR_USERID,SsoxUserBM.ATTR_USERID, ColumnDef.TYPE_STRING , 100){
	        	{

	        	}
	        });
	        /** column 성명 : userName */
	        listColumnDefs.add(new ColumnLovDef("성명", SsoxUserBM.ATTR_USERNAME, SsoxUserBM.ATTR_USERNAME, ColumnDef.TYPE_STRING , 100){
	        	{

	        	}
	        });
	        /** column 주민번호 : userSn */
	        listColumnDefs.add(new ColumnLovDef("주민번호", SsoxUserBM.ATTR_USERSN,  SsoxUserBM.ATTR_USERSN, ColumnDef.TYPE_STRING , 90){
	        	{
	        		 setIsVisibleInGrid(false);
	        	}
	        });
	        /** column 상태 : userStat */
	        listColumnDefs.add(new ColumnLovDef("상태", SsoxUserBM.ATTR_USERSTAT,SsoxUserBM.ATTR_USERSTAT, ColumnDef.TYPE_STRING , 90){
	        	{
	        		 setIsVisibleInGrid(false);
	        	}
	        }); 
	        
	      
//	       
//	        listColumnDefs.add(new ColumnLovDef("사업장코드", SysComBass0500BM.ATTR_DPOBCD,SysComBass0500BM.ATTR_DPOBCD,  ColumnDef.TYPE_STRING, 100 ){
//	            {
//	            	 setIsVisibleInGrid(false);
//	            }
//	        });
//	        /** BUSIN_APPTN_YR */
//	        listColumnDefs.add(new ColumnLovDef("사업년도", SysComBass0500BM.ATTR_BUSINAPPTNYR,SysComBass0500BM.ATTR_BUSINAPPTNYR, ColumnDef.TYPE_STRING, 80 ){
//	            { 
//	            }
//	        });
//	        /** DEPT_CD */
//	        listColumnDefs.add(new ColumnLovDef("부서코드", SysComBass0500BM.ATTR_DEPTCD,  SysComBass0500BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 80 ){
//	            {
//	            	setIsVisibleInGrid(false);
//	            }
//	        }); 
//	        
//	        /** DEPT_NM_HAN == deptNmHan*/
//	        listColumnDefs.add(new ColumnLovDef("부서명", SysComBass0500BM.ATTR_DEPTNMHAN,SysComBass0500BM.ATTR_DEPTNMHAN,   ColumnDef.TYPE_STRING, 80 ){
//	            {
//	            	setIsVisibleInGrid(false);
//	            }
//	        });
//	        /** DEPT_NM_RTCHNT == deptNmRtchnt*/
//	        listColumnDefs.add(new ColumnLovDef("부서명", SysComBass0500BM.ATTR_DEPTNMRTCHNT,SysComBass0500BM.ATTR_DEPTNMRTCHNT,   ColumnDef.TYPE_STRING, 80 ){
//	            {
//	            }
//	        });
//	        /** BUSIN_CD == businCd*/
//	        listColumnDefs.add(new ColumnLovDef("사업코드", SysComBass0500BM.ATTR_BUSINCD,SysComBass0500BM.ATTR_BUSINCD,   ColumnDef.TYPE_STRING, 80 ){
//	            {
//	            }
//	        });
//	        /** BUSIN_NM  == businNm*/
//	        listColumnDefs.add(new ColumnLovDef("사업명", SysComBass0500BM.ATTR_BUSINNM,SysComBass0500BM.ATTR_BUSINNM,    ColumnDef.TYPE_STRING, 80 ){
//	            {
//	            }
//	        });
//	        /** EMYMT_TYP_OCCU_CD == emymtTypOccuCd*/
//	        listColumnDefs.add(new ColumnLovDef("사업고용직종코드", SysComBass0500BM.ATTR_EMYMTTYPOCCUCD, SysComBass0500BM.ATTR_EMYMTTYPOCCUCD,   ColumnDef.TYPE_STRING, 80 ){
//	            {
//	            	setIsVisibleInGrid(false);
//	            }
//	        });
//	        /** EMYMT_TYP_OCCU_NM == emymtTypOccuNm*/
//	        listColumnDefs.add(new ColumnLovDef("사업고용직종명", SysComBass0500BM.ATTR_EMYMTTYPOCCUNM, SysComBass0500BM.ATTR_EMYMTTYPOCCUNM,  ColumnDef.TYPE_STRING, 80 ){
//	            {
//	            }
//	        });
//	        /** BUSIN_REPBTY_EMP_NUM == businRepbtyEmpNum*/
//	        listColumnDefs.add(new ColumnLovDef("사업담당직원번호", SysComBass0500BM.ATTR_BUSINREPBTYEMPNUM,SysComBass0500BM.ATTR_BUSINREPBTYEMPNUM,   ColumnDef.TYPE_STRING, 80 ){
//	            {
//	            	 
//	            }
//	        });
//	        /** IDTL_ACCDT_INSUR_APMRT = idtlAccdtInsurApmrt */
//	        listColumnDefs.add(new ColumnLovDef("산재보험요율", SysComBass0500BM.ATTR_IDTLACCDTINSURAPMRT,SysComBass0500BM.ATTR_IDTLACCDTINSURAPMRT,   ColumnDef.TYPE_STRING, 80 ){
//	            {
//	            	setIsVisibleInGrid(false);
//	            }
//	        });
//	        /** SPITY_CTNT */
//	        listColumnDefs.add(new ColumnLovDef("특기사항", SysComBass0500BM.ATTR_SPITYCTNT, SysComBass0500BM.ATTR_SPITYCTNT,  ColumnDef.TYPE_STRING, 80 ){
//	            {
//	            }
//	        });
//	        /** NAT_PENN_SYM */
//	        listColumnDefs.add(new ColumnLovDef("국민연금기호", SysComBass0500BM.ATTR_NATPENNSYM, SysComBass0500BM.ATTR_NATPENNSYM,  ColumnDef.TYPE_STRING, 80 ){
//	            {
//	            	setIsVisibleInGrid(false);
//	            }
//	        });
//	        /** HLTH_INSR_SYM */
//	        listColumnDefs.add(new ColumnLovDef("건강보험기호", SysComBass0500BM.ATTR_HLTHINSRSYM,  SysComBass0500BM.ATTR_HLTHINSRSYM, ColumnDef.TYPE_STRING, 80 ){
//	            {
//	            	setIsVisibleInGrid(false);
//	            }
//	        });
//	        /** UMYT_INSR_SYM */
//	        listColumnDefs.add(new ColumnLovDef("고용보험기호", SysComBass0500BM.ATTR_UMYTINSRSYM, SysComBass0500BM.ATTR_UMYTINSRSYM,   ColumnDef.TYPE_STRING, 80 ){
//	            {
//	            	setIsVisibleInGrid(false);
//	            }
//	        });
//	        /** IDTL_ACCDT_INSUR_SYM */
//	        listColumnDefs.add(new ColumnLovDef("산재보험기호", SysComBass0500BM.ATTR_IDTLACCDTINSURSYM,SysComBass0500BM.ATTR_IDTLACCDTINSURSYM,   ColumnDef.TYPE_STRING, 80 ){
//	            {
//	            	setIsVisibleInGrid(false);
//	            }
//	        });
	        
	        lovDef.setListColumns(listColumnDefs); 

	        lovDef.addHiddenColumn(new SsoxUserDef().getColumnsDefinition()); 
	       
	    } 

}
