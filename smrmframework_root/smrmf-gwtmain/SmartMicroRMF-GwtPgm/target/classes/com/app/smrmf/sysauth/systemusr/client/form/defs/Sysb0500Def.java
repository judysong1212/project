/**
 * 공통화면 팝업 
 */
package com.app.smrmf.sysauth.systemusr.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.sysauth.system.client.languages.SysmConstants;
import com.app.smrmf.sysauth.system.shared.SysmDaoConstants;
import com.app.smrmf.sysauth.systemusr.client.dto.Sysb0500BM;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Sysb0500Def  extends TableDef implements SysmDaoConstants {

    private int row = 0;
    private SysmConstants lblSysmConst = SysmConstants.INSTANCE;

    
    public Sysb0500Def(String chkDef){
        
        
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
        listColumnDefs.add(new ColumnDef("사업장코드", Sysb0500BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사용자열람일사 : usrRdgDtntm */
        listColumnDefs.add(new ColumnDef("사용자열람일사", Sysb0500BM.ATTR_USRRDGDTNTM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사용자열람일련번호 : usrRdgSeilNum */
        listColumnDefs.add(new ColumnDef("사용자열람일련번호", Sysb0500BM.ATTR_USRRDGSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 사용자열람구분코드 : usrRdgDivCd */
        listColumnDefs.add(new ColumnDef("사용자열람구분코드", Sysb0500BM.ATTR_USRRDGDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서코드", Sysb0500BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사용자아이디 : usrId */
        listColumnDefs.add(new ColumnDef("사용자아이디", Sysb0500BM.ATTR_USRID, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사용자접속아이피 : usrConnId */
        listColumnDefs.add(new ColumnDef("사용자접속아이피", Sysb0500BM.ATTR_USRCONNID, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사용자열람메서드명 : usrRdgEthdNm */
        listColumnDefs.add(new ColumnDef("사용자열람메서드명", Sysb0500BM.ATTR_USRRDGETHDNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사용자열람작업구분코드 : usrRdgJobDivCd */
        listColumnDefs.add(new ColumnDef("사용자열람작업구분코드", Sysb0500BM.ATTR_USRRDGJOBDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사용자특정대상자SYSTEMKEY_VAL : usrSpfcRcptSmkeyVal */
        listColumnDefs.add(new ColumnDef("사용자특정대상자SYSTEMKEY_VAL", Sysb0500BM.ATTR_USRSPFCRCPTSMKEYVAL, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사용자열람비고내용 : usrRdgNoteCtnt */
        listColumnDefs.add(new ColumnDef("사용자열람비고내용", Sysb0500BM.ATTR_USRRDGNOTECTNT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Sysb0500BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Sysb0500BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Sysb0500BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Sysb0500BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Sysb0500BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Sysb0500BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> usrRdgDtntm;   /** column 사용자열람일사 : usrRdgDtntm */
//
//        private TextField<String> usrRdgSeilNum;   /** column 사용자열람일련번호 : usrRdgSeilNum */
//
//        private TextField<String> usrRdgDivCd;   /** column 사용자열람구분코드 : usrRdgDivCd */
//
//        private TextField<String> deptCd;   /** column 부서코드 : deptCd */
//
//        private TextField<String> usrId;   /** column 사용자아이디 : usrId */
//
//        private TextField<String> usrConnId;   /** column 사용자접속아이피 : usrConnId */
//
//        private TextField<String> usrRdgEthdNm;   /** column 사용자열람메서드명 : usrRdgEthdNm */
//
//        private TextField<String> usrRdgJobDivCd;   /** column 사용자열람작업구분코드 : usrRdgJobDivCd */
//
//        private TextField<String> usrSpfcRcptSmkeyVal;   /** column 사용자특정대상자SYSTEMKEY_VAL : usrSpfcRcptSmkeyVal */
//
//        private TextField<String> usrRdgNoteCtnt;   /** column 사용자열람비고내용 : usrRdgNoteCtnt */
//
//        private TextField<String> kybdr;   /** column 입력자 : kybdr */
//
//        private TextField<String> inptDt;   /** column 입력일자 : inptDt */
//
//        private TextField<String> inptAddr;   /** column 입력주소 : inptAddr */
//
//        private TextField<String> ismt;   /** column 수정자 : ismt */
//
//        private TextField<String> revnDt;   /** column 수정일자 : revnDt */
//
//        private TextField<String> revnAddr;   /** column 수정주소 : revnAddr */
        
       
		return listColumnDefs;
    }
}
