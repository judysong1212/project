/**
 * 공통화면 팝업 
 */
package com.app.smrmf.sysauth.systemusr.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfHist0100BM;
import com.app.smrmf.sysauth.system.client.languages.SysmConstants;
import com.app.smrmf.sysauth.system.shared.SysmDaoConstants;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class SysUsrHist0100Def  extends TableDef implements SysmDaoConstants {

    private int row = 0;
    private SysmConstants lblSysmConst = SysmConstants.INSTANCE;

    
    public SysUsrHist0100Def(String chkDef){
        
        
        if ("".equals(chkDef)) {
	        setTitle("");
//	        setDaoClass("CLASS_PSNL0126_DATA_LIST");
	        setCustomListMethod(CLASS_HIST0100_DATA_LIST);
	        
	        setAutoFillGrid(true);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
	        setEditFieldGrid(false);
//	        setCellModel(true);
	        setColumnsDefinition(getHist0100ColumnsList());  
	      
    	}else if ("S0020010_02".equals(chkDef)) {
	        setTitle("");
//	        setDaoClass("CLASS_PSNL0126_DATA_LIST");
//	        setCustomListMethod(CLASS_PSNL0126_DATA_LIST);
//	        setColumnsDefinition(getStts0100005ColumnsList());
	        setAutoFillGrid(false);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(false);
	        setEditFieldGrid(false);
//	        setCellModel(true);
    	}
    }
    
	private List<ColumnDef> getHist0100ColumnsList(){
    	
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        
        row = 0;
        
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", SysIfHist0100BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사용자접속구분코드 : usrConnectDivCd */
        listColumnDefs.add(new ColumnDef("구분", SysIfHist0100BM.ATTR_USRCONNECTDIVCD, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{

        	}
        });
        /** column 사용자접속년도 : usrConnectYr */
        listColumnDefs.add(new ColumnDef("년도", SysIfHist0100BM.ATTR_USRCONNECTYR, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        
        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서코드", SysIfHist0100BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서", SysIfHist0100BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 150, true, true, true){
        	{

        	}
        });
        
        
        /** column 사용자아이디 : usrId */
        listColumnDefs.add(new ColumnDef("아이디", SysIfHist0100BM.ATTR_USRID, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        
        listColumnDefs.add(new ColumnDef("성명", SysIfHist0100BM.ATTR_USRNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 사용자접속시작일시 : usrConnectBgnnDtntm */
        listColumnDefs.add(new ColumnDef("접속시작일시", SysIfHist0100BM.ATTR_USRCONNECTBGNNDTNTM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        /** column 사용자접속종료일시 : usrConnectEndDtntm */
        listColumnDefs.add(new ColumnDef("접속종료일시", SysIfHist0100BM.ATTR_USRCONNECTENDDTNTM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        
        
        //-------------------------
        /** column 사용자접속일련번호 : usrConnectSeilNum */
        listColumnDefs.add(new ColumnDef("사용자접속일련번호", SysIfHist0100BM.ATTR_USRCONNECTSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });


        /** column 사용자구분코드 : usrDivCd */
        listColumnDefs.add(new ColumnDef("사용자구분코드", SysIfHist0100BM.ATTR_USRDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사용자성명 : usrNm */


        /** column SESSIONKEY : sessionkey */
        listColumnDefs.add(new ColumnDef("SESSIONKEY", SysIfHist0100BM.ATTR_SESSIONKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", SysIfHist0100BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", SysIfHist0100BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", SysIfHist0100BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", SysIfHist0100BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", SysIfHist0100BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", SysIfHist0100BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
       
		return listColumnDefs;
    }
}
