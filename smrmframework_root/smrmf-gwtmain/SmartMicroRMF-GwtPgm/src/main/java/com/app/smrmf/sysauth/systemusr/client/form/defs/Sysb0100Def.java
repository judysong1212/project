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
import com.app.smrmf.sysauth.systemusr.client.dto.Sysb0100BM;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Sysb0100Def  extends TableDef implements SysmDaoConstants {

    private int row = 0;
    private SysmConstants lblSysmConst = SysmConstants.INSTANCE;

    
    public Sysb0100Def(String chkDef){
        
        
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
        
        /** column 사용자아이디 : usrId */
        listColumnDefs.add(new ColumnDef("사용자아이디", Sysb0100BM.ATTR_USRID, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사용자정보변경일시 : usrInfoChngDtntm */
        listColumnDefs.add(new ColumnDef("사용자정보변경일시", Sysb0100BM.ATTR_USRINFOCHNGDTNTM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 시스템구분코드 : sysDivCd */
        listColumnDefs.add(new ColumnDef("시스템구분코드", Sysb0100BM.ATTR_SYSDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 권한부여아이디 : authId */
        listColumnDefs.add(new ColumnDef("권한부여아이디", Sysb0100BM.ATTR_AUTHID, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사용자등록구분플래그 : usrRgstnSeptFlag */
        listColumnDefs.add(new ColumnDef("사용자등록구분플래그", Sysb0100BM.ATTR_USRRGSTNSEPTFLAG, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서코드", Sysb0100BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사용자성명 : usrNm */
        listColumnDefs.add(new ColumnDef("사용자성명", Sysb0100BM.ATTR_USRNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사용자권한구분코드 : usrDivCd */
        listColumnDefs.add(new ColumnDef("사용자권한구분코드", Sysb0100BM.ATTR_USRDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 이메일 : email */
        listColumnDefs.add(new ColumnDef("이메일", Sysb0100BM.ATTR_EMAIL, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Sysb0100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 전화번호 : phnNum */
        listColumnDefs.add(new ColumnDef("전화번호", Sysb0100BM.ATTR_PHNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종코드", Sysb0100BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 호봉등급코드 : pyspGrdeCd */
        listColumnDefs.add(new ColumnDef("호봉등급코드", Sysb0100BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종세통합코드 : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세통합코드", Sysb0100BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 권한적용시작일자 : authApptnBgnnDt */
        listColumnDefs.add(new ColumnDef("권한적용시작일자", Sysb0100BM.ATTR_AUTHAPPTNBGNNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 권한적용종료일자 : authApptnEndDt */
        listColumnDefs.add(new ColumnDef("권한적용종료일자", Sysb0100BM.ATTR_AUTHAPPTNENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사용자말소일자 : usrEaueDt */
        listColumnDefs.add(new ColumnDef("사용자말소일자", Sysb0100BM.ATTR_USREAUEDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사용자사용여부 : usrUseYn */
        listColumnDefs.add(new ColumnDef("사용자사용여부", Sysb0100BM.ATTR_USRUSEYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사용자권한제외여부x : usrAuthEepnYn */
        listColumnDefs.add(new ColumnDef("사용자권한제외여부x", Sysb0100BM.ATTR_USRAUTHEEPNYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 호봉제포함여부x : pyspInsnYn */
        listColumnDefs.add(new ColumnDef("호봉제포함여부x", Sysb0100BM.ATTR_PYSPINSNYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 비호봉제포함여부x : notPyspInsnYn */
        listColumnDefs.add(new ColumnDef("비호봉제포함여부x", Sysb0100BM.ATTR_NOTPYSPINSNYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기간제포함여부x : shttmInsnYn */
        listColumnDefs.add(new ColumnDef("기간제포함여부x", Sysb0100BM.ATTR_SHTTMINSNYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 복무입력처리여부 : servcInptPrcsYn */
        listColumnDefs.add(new ColumnDef("복무입력처리여부", Sysb0100BM.ATTR_SERVCINPTPRCSYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산입력처리여부 : yrtxInptPrcsYn */
        listColumnDefs.add(new ColumnDef("연말정산입력처리여부", Sysb0100BM.ATTR_YRTXINPTPRCSYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Sysb0100BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Sysb0100BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Sysb0100BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Sysb0100BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Sysb0100BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Sysb0100BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> usrId;   /** column 사용자아이디 : usrId */
//
//        private TextField<String> usrInfoChngDtntm;   /** column 사용자정보변경일시 : usrInfoChngDtntm */
//
//        private TextField<String> sysDivCd;   /** column 시스템구분코드 : sysDivCd */
//
//        private TextField<String> authId;   /** column 권한부여아이디 : authId */
//
//        private TextField<String> usrRgstnSeptFlag;   /** column 사용자등록구분플래그 : usrRgstnSeptFlag */
//
//        private TextField<String> deptCd;   /** column 부서코드 : deptCd */
//
//        private TextField<String> usrNm;   /** column 사용자성명 : usrNm */
//
//        private TextField<String> usrDivCd;   /** column 사용자권한구분코드 : usrDivCd */
//
//        private TextField<String> email;   /** column 이메일 : email */
//
//        private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//        private TextField<String> phnNum;   /** column 전화번호 : phnNum */
//
//        private TextField<String> typOccuCd;   /** column 직종코드 : typOccuCd */
//
//        private TextField<String> pyspGrdeCd;   /** column 호봉등급코드 : pyspGrdeCd */
//
//        private TextField<String> dtilOccuInttnCd;   /** column 직종세통합코드 : dtilOccuInttnCd */
//
//        private TextField<String> authApptnBgnnDt;   /** column 권한적용시작일자 : authApptnBgnnDt */
//
//        private TextField<String> authApptnEndDt;   /** column 권한적용종료일자 : authApptnEndDt */
//
//        private TextField<String> usrEaueDt;   /** column 사용자말소일자 : usrEaueDt */
//
//        private TextField<String> usrUseYn;   /** column 사용자사용여부 : usrUseYn */
//
//        private TextField<String> usrAuthEepnYn;   /** column 사용자권한제외여부x : usrAuthEepnYn */
//
//        private TextField<String> pyspInsnYn;   /** column 호봉제포함여부x : pyspInsnYn */
//
//        private TextField<String> notPyspInsnYn;   /** column 비호봉제포함여부x : notPyspInsnYn */
//
//        private TextField<String> shttmInsnYn;   /** column 기간제포함여부x : shttmInsnYn */
//
//        private TextField<String> servcInptPrcsYn;   /** column 복무입력처리여부 : servcInptPrcsYn */
//
//        private TextField<String> yrtxInptPrcsYn;   /** column 연말정산입력처리여부 : yrtxInptPrcsYn */
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
