/**
 * sso 사용자 팝업화면 
 */
package com.app.smrmf.infc.sysif.msfpackage.client.form;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnLovDef;
import com.app.smrmf.core.msfmainapp.client.def.LovDef;
import com.app.smrmf.core.msfmainapp.client.generics.Lov;
import com.app.smrmf.core.msfmainapp.client.languages.MSFConstants;
import com.app.smrmf.infc.sysif.msfpackage.client.form.defs.SsoxIfUserDef;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SsoxIfUserBM;
import com.app.smrmf.infc.sysif.msfpackage.shared.MSFPkgDaoConstants;

 
public class SysIfP0910  extends Lov implements MSFPkgDaoConstants { 

	/**######################################################
	 * { 시스템 기본설정파일 선언부  시작}
	 *#######################################################*/
	 

	     /**######################################################
	 	 * { 시스템 기본설정파일 선언부  종료}
	 	 *#######################################################*/

	 private MSFConstants SysIfLabel = MSFConstants.INSTANCE;
	    
	    public SysIfP0910(int width, int height) {
	        this();
	        this.width  = width;
	        this.height = height;
	    }

	    public SysIfP0910() {

	        lovDef = new LovDef();
	        lovDef.setTitle("사용자정보");  //팝업상단의 타이틀 
	        lovDef.setDaoClass("");
	        lovDef.setAutoFillGrid(true);
	        lovDef.setFilterForm(false);  
	        lovDef.setCustomListMethod(MSFPKG_SSOMUSER_LIST);
	       
	        List<ColumnLovDef> listColumnDefs = new ArrayList<ColumnLovDef>();
	        
	        /** column 부서코드 : deptId */
	        listColumnDefs.add(new ColumnLovDef("부서코드", SsoxIfUserBM.ATTR_DEPTID, SsoxIfUserBM.ATTR_DEPTID, ColumnDef.TYPE_STRING , 90){
	        	{
	        		 setIsVisibleInGrid(false);
	        	}
	        });
	        /** column 부서 : deptName */
	        listColumnDefs.add(new ColumnLovDef("부서", SsoxIfUserBM.ATTR_DEPTNAME,SsoxIfUserBM.ATTR_DEPTNAME, ColumnDef.TYPE_STRING , 140){
	        	{

	        	}
	        }); 
	        
	        /** column 고용형태 : classId */
	        listColumnDefs.add(new ColumnLovDef("직급코드", SsoxIfUserBM.ATTR_CLASSID,SsoxIfUserBM.ATTR_CLASSID, ColumnDef.TYPE_STRING , 90){
	        	{
	        		 setIsVisibleInGrid(false);
	        	}
	        });
	        /** column 고용형태 : className */
	        listColumnDefs.add(new ColumnLovDef("직급", SsoxIfUserBM.ATTR_CLASSNAME,SsoxIfUserBM.ATTR_CLASSNAME, ColumnDef.TYPE_STRING , 120){
	        	{

	        	}
	        });

	        /** column 아이디 : userId */
	        listColumnDefs.add(new ColumnLovDef("아이디", SsoxIfUserBM.ATTR_USERID,SsoxIfUserBM.ATTR_USERID, ColumnDef.TYPE_STRING , 100){
	        	{

	        	}
	        });
	        /** column 성명 : userName */
	        listColumnDefs.add(new ColumnLovDef("성명", SsoxIfUserBM.ATTR_USERNAME, SsoxIfUserBM.ATTR_USERNAME, ColumnDef.TYPE_STRING , 100){
	        	{

	        	}
	        });
	        /** column 주민번호 : userSn */
	        listColumnDefs.add(new ColumnLovDef("주민번호", SsoxIfUserBM.ATTR_USERSN,  SsoxIfUserBM.ATTR_USERSN, ColumnDef.TYPE_STRING , 90){
	        	{
	        		 setIsVisibleInGrid(false);
	        	}
	        });
	        /** column 상태 : userStat */
	        listColumnDefs.add(new ColumnLovDef("상태", SsoxIfUserBM.ATTR_USERSTAT,SsoxIfUserBM.ATTR_USERSTAT, ColumnDef.TYPE_STRING , 90){
	        	{
	        		 setIsVisibleInGrid(false);
	        	}
	        }); 
	        
	 
	        
	        lovDef.setListColumns(listColumnDefs); 

	        lovDef.addHiddenColumn(new SsoxIfUserDef().getColumnsDefinition()); 
	       
	    } 

}
