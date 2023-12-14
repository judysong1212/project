/**
 * 공통화면 팝업 
 */
package com.app.smrmf.sysauth.system.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfHist0200BM;
import com.app.smrmf.sysauth.system.client.languages.SysmConstants;
import com.app.smrmf.sysauth.system.shared.SysmDaoConstants;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class SysmHist0200Def  extends TableDef implements SysmDaoConstants {

    private int row = 0;
    private SysmConstants lblSysmConst = SysmConstants.INSTANCE;

    
    public SysmHist0200Def(String chkDef){
        
        
        if ("".equals(chkDef)) {
	        setTitle("");
//	        setDaoClass("CLASS_PSNL0126_DATA_LIST");
	        setCustomListMethod(CLASS_HIST0200_DATA_LIST);
	        
	        setAutoFillGrid(false);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
	        setEditFieldGrid(false);
//	        setCellModel(true);
	        setColumnsDefinition(getHist0200ColumnsList());  
	      
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
    
	private List<ColumnDef> getHist0200ColumnsList(){
    	
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        
        row = 0;
        
        /** column 사용자접속구분코드 : usrConnectDivCd */
        listColumnDefs.add(new ColumnDef("구분", SysIfHist0200BM.ATTR_USRCONNECTDIVCD, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{

        	}
        });

        /** column 사용자작업년도 : usrJobYr */
        listColumnDefs.add(new ColumnDef("년도", SysIfHist0200BM.ATTR_USRJOBYR, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        
        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서코드", SysIfHist0200BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서", SysIfHist0200BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 150, true, true, true){
        	{

        	}
        });
        
        /** column 사용자아이디 : usrId */
        listColumnDefs.add(new ColumnDef("아이디", SysIfHist0200BM.ATTR_USRID, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        
        /** column 사용자성명 : usrNm */
        listColumnDefs.add(new ColumnDef("성명", SysIfHist0200BM.ATTR_USRNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        
        /** column 사용자작업일시 : usrJobDtntm */
        listColumnDefs.add(new ColumnDef("작업일시", SysIfHist0200BM.ATTR_USRJOBDTNTM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 사용자작업구분코드 : usrJobSeptDivCd */
        listColumnDefs.add(new ColumnDef("작업구분코드", SysIfHist0200BM.ATTR_USRJOBSEPTDIVCD, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        /** column 사용자작업메소드명 : usrJobEthdNm */
        listColumnDefs.add(new ColumnDef("사용자작업메소드명", SysIfHist0200BM.ATTR_USRJOBETHDNM, ColumnDef.TYPE_STRING , 400, true, true, true){
        	{

        	}
        });
        /** column 사용자작업시작일시 : usrJobBgnnTm */
        listColumnDefs.add(new ColumnDef("작업시작일시", SysIfHist0200BM.ATTR_USRJOBBGNNTM, ColumnDef.TYPE_STRING , 150, true, true, true){
        	{

        	}
        });
        /** column 사용자작업종료일시 : usrJobEndTm */
        listColumnDefs.add(new ColumnDef("작업종료일시", SysIfHist0200BM.ATTR_USRJOBENDTM, ColumnDef.TYPE_STRING , 150, true, true, true){
        	{

        	}
        });
        
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", SysIfHist0200BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", SysIfHist0200BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        
        
        // ---------------
        
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", SysIfHist0200BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        

        /** column 사용자작업일련번호 : usrJobSeilNum */
        listColumnDefs.add(new ColumnDef("사용자작업일련번호", SysIfHist0200BM.ATTR_USRJOBSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });


        /** column 사용자구분코드 : usrDivCd */
        listColumnDefs.add(new ColumnDef("사용자구분코드", SysIfHist0200BM.ATTR_USRDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", SysIfHist0200BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", SysIfHist0200BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", SysIfHist0200BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", SysIfHist0200BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", SysIfHist0200BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

       
		return listColumnDefs;
    }
}
