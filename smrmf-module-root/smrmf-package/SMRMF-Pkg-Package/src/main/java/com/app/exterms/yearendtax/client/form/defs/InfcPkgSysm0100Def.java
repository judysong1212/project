package com.app.exterms.yearendtax.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.InfcPkgSysm0100BM;
import com.app.exterms.yearendtax.shared.InfcPkgSysmDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0300BM;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0300DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0400BM;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0400DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.lookup.LookupSysIfBass0300;
import com.app.smrmf.infc.sysif.msfpackage.client.lookup.LookupSysIfBass0400;
import com.app.smrmf.sysauth.system.client.languages.SysmConstants;

public class InfcPkgSysm0100Def extends TableDef implements InfcPkgSysmDaoConstants {
	
	public int row = 0;
	public SysmConstants lblSysmConst = SysmConstants.INSTANCE;
	
	final SysIfBass0300DTO sysIfBass0300Dto ;
	final SysIfBass0400DTO sysIfBass0400Dto;
    
    public InfcPkgSysm0100Def(String chkMenu){
    	
    	sysIfBass0300Dto = new SysIfBass0300DTO();
    	sysIfBass0400Dto = new SysIfBass0400DTO();
    	
    	if("yeta2080ToSysm0100On".equals(chkMenu)) {
    		
			setTitle("선택된 사용자");
    		setDaoClass(""); 
            setCustomListMethod(CLASS_YETA2080_TO_SYSM0100_ON_LIST);
    		setAutoFillGrid(true);
    		setShowFilterToolbar(false);   
    		setEditFieldGrid(false);
   	      	setColumnsDefinition(getYeta2080ToSys0100OnColumnsList()); 
    	 
		}else if("yeta2080ToSysm0100Off".equals(chkMenu)) {
    		
			setTitle("미선택된 사용자");
    		setDaoClass(""); 
            setCustomListMethod(CLASS_YETA2080_TO_SYSM0100_OFF_LIST);
    		setAutoFillGrid(true);
    		setShowFilterToolbar(false);   
    		setEditFieldGrid(false);
   	      	setColumnsDefinition(getYeta2080ToSys0100OffColumnsList()); 
    	 
		}   	
		else if("yeta3080ToSysm0100On".equals(chkMenu)) {
    		
			setTitle("선택된 사용자");
    		setDaoClass(""); 
            setCustomListMethod(CLASS_YETA3080_TO_SYSM0100_ON_LIST);
    		setAutoFillGrid(true);
    		setShowFilterToolbar(false);   
    		setEditFieldGrid(false);
   	      	setColumnsDefinition(getYeta2080ToSys0100OnColumnsList()); 
    	 
		}else if("yeta3080ToSysm0100Off".equals(chkMenu)) {
    		
			setTitle("미선택된 사용자");
    		setDaoClass(""); 
            setCustomListMethod(CLASS_YETA3080_TO_SYSM0100_OFF_LIST);
    		setAutoFillGrid(true);
    		setShowFilterToolbar(false);   
    		setEditFieldGrid(false);
   	      	setColumnsDefinition(getYeta2080ToSys0100OffColumnsList()); 
    	 
		} else if("yeta4080ToSysm0100On".equals(chkMenu)) {
    		
			setTitle("선택된 사용자");
    		setDaoClass(""); 
            setCustomListMethod(CLASS_YETA4080_TO_SYSM0100_ON_LIST);
    		setAutoFillGrid(true);
    		setShowFilterToolbar(false);   
    		setEditFieldGrid(false);
   	      	setColumnsDefinition(getYeta2080ToSys0100OnColumnsList()); 
    	 
		}else if("yeta4080ToSysm0100Off".equals(chkMenu)) {
    		
			setTitle("미선택된 사용자");
    		setDaoClass(""); 
            setCustomListMethod(CLASS_YETA4080_TO_SYSM0100_OFF_LIST);
    		setAutoFillGrid(true);
    		setShowFilterToolbar(false);   
    		setEditFieldGrid(false);
   	      	setColumnsDefinition(getYeta2080ToSys0100OffColumnsList()); 
    	 
		}else if("yeta5080ToSysm0100On".equals(chkMenu)) {
    		
			setTitle("선택된 사용자");
    		setDaoClass(""); 
            setCustomListMethod(CLASS_YETA5080_TO_SYSM0100_ON_LIST);
    		setAutoFillGrid(true);
    		setShowFilterToolbar(false);   
    		setEditFieldGrid(false);
   	      	setColumnsDefinition(getYeta2080ToSys0100OnColumnsList()); 
    	 
		}else if("yeta5080ToSysm0100Off".equals(chkMenu)) {
    		
			setTitle("미선택된 사용자");
    		setDaoClass(""); 
            setCustomListMethod(CLASS_YETA5080_TO_SYSM0100_OFF_LIST);
    		setAutoFillGrid(true);
    		setShowFilterToolbar(false);   
    		setEditFieldGrid(false);
   	      	setColumnsDefinition(getYeta2080ToSys0100OffColumnsList()); 
    	 
		}else if("yeta6080ToSysm0100On".equals(chkMenu)) {
    		
			setTitle("선택된 사용자");
    		setDaoClass(""); 
            setCustomListMethod(CLASS_YETA6080_TO_SYSM0100_ON_LIST);
    		setAutoFillGrid(true);
    		setShowFilterToolbar(false);   
    		setEditFieldGrid(false);
   	      	setColumnsDefinition(getYeta2080ToSys0100OnColumnsList()); 
    	 
		}else if("yeta6080ToSysm0100Off".equals(chkMenu)) {
    		
			setTitle("미선택된 사용자");
    		setDaoClass(""); 
            setCustomListMethod(CLASS_YETA6080_TO_SYSM0100_OFF_LIST);
    		setAutoFillGrid(true);
    		setShowFilterToolbar(false);   
    		setEditFieldGrid(false);
   	      	setColumnsDefinition(getYeta2080ToSys0100OffColumnsList()); 
    	 
		}else if("yeta7080ToSysm0100On".equals(chkMenu)) {
    		
			setTitle("선택된 사용자");
    		setDaoClass(""); 
            setCustomListMethod(CLASS_YETA7080_TO_SYSM0100_ON_LIST);
    		setAutoFillGrid(true);
    		setShowFilterToolbar(false);   
    		setEditFieldGrid(false);
   	      	setColumnsDefinition(getYeta2080ToSys0100OnColumnsList()); 
    	 
		}else if("yeta7080ToSysm0100Off".equals(chkMenu)) {
    		
			setTitle("미선택된 사용자");
    		setDaoClass(""); 
            setCustomListMethod(CLASS_YETA7080_TO_SYSM0100_OFF_LIST);
    		setAutoFillGrid(true);
    		setShowFilterToolbar(false);   
    		setEditFieldGrid(false);
   	      	setColumnsDefinition(getYeta2080ToSys0100OffColumnsList()); 
    	 
		}else if("yeta8080ToSysm0100On".equals(chkMenu)) {
    		
			setTitle("선택된 사용자");
    		setDaoClass(""); 
            setCustomListMethod(CLASS_YETA8080_TO_SYSM0100_ON_LIST);
    		setAutoFillGrid(true);
    		setShowFilterToolbar(false);   
    		setEditFieldGrid(false);
   	      	setColumnsDefinition(getYeta2080ToSys0100OnColumnsList()); 
    	 
		}else if("yeta8080ToSysm0100Off".equals(chkMenu)) {
    		
			setTitle("미선택된 사용자");
    		setDaoClass(""); 
            setCustomListMethod(CLASS_YETA8080_TO_SYSM0100_OFF_LIST);
    		setAutoFillGrid(true);
    		setShowFilterToolbar(false);   
    		setEditFieldGrid(false);
   	      	setColumnsDefinition(getYeta2080ToSys0100OffColumnsList()); 
    	 
		} 	
    	
    }

    /** 연말정산등록담당자관리 **/
    private List<ColumnDef> getYeta2080ToSys0100OnColumnsList() {
    	
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        
        
        /** column 선택 : select */
         listColumnDefs.add(new ColumnDef("선택", InfcPkgSysm0100BM.ATTR_SELECT, ColumnDef.TYPE_BOOLEAN, 55, false, true, true){
      	  {      	
      		 
      	  }        	  
         });  
        
        /** column 부서코드 : deptCd */
    	listColumnDefs.add(new ColumnListDef("부서", InfcPkgSysm0100BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 120, false, true, false,new LookupSysIfBass0400(sysIfBass0400Dto),SysIfBass0400BM.ATTR_DEPTCD,SysIfBass0400BM.ATTR_DEPTNMRTCHNT){
    		{

    		}
    	});
    	
    	sysIfBass0300Dto.setRpsttvCd("D001");
    	/** column 사용자구분코드 : usrDivCd */
    	listColumnDefs.add(new ColumnListDef("사용자구분", InfcPkgSysm0100BM.ATTR_USRDIVCD, ColumnDef.TYPE_STRING , 90, true, true, true,new LookupSysIfBass0300(sysIfBass0300Dto),SysIfBass0300BM.ATTR_COMMCD,SysIfBass0300BM.ATTR_COMMCDNM){
    		{

    		}
    	}); 
    	
    	
    	/** column 사용자아이디 : usrId */
    	listColumnDefs.add(new ColumnDef("아이디", InfcPkgSysm0100BM.ATTR_USRID, ColumnDef.TYPE_STRING , 70, false, true, false){
    		{
    			 
    		}
    	});
    	
    	/** column 사용자성명 : usrNm */
    	listColumnDefs.add(new ColumnDef("성명", InfcPkgSysm0100BM.ATTR_USRNM, ColumnDef.TYPE_STRING , 70, false, true, false){
    		{
    			 
    		}
    	});
    	

    	/** column 내선번호 : usrTel */
    	listColumnDefs.add(new ColumnDef("연말정산", InfcPkgSysm0100BM.ATTR_YRTXINPTPRCSYN, ColumnDef.TYPE_BOOLEAN , 50, false, true, false){
    		{

    		}
    	});
    	
    	
    	
    	//--- 
    	
        /** column 부서코드 : deptCd */
//    	listColumnDefs.add(new ColumnDef("부서", InfcPkgSysm0100BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, false, false, false){
//    		{
//
//    		}
//    	});
    	
        /** set 시스템구분코드 : sysDivCd */
    	listColumnDefs.add(new ColumnDef("시스템구분코드", InfcPkgSysm0100BM.ATTR_SYSDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	
    	/** column 입력자 : kybdr */
    	listColumnDefs.add(new ColumnDef("입력자", InfcPkgSysm0100BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 입력일자 : inptDt */
    	listColumnDefs.add(new ColumnDef("입력일자", InfcPkgSysm0100BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 입력주소 : inptAddr */
    	listColumnDefs.add(new ColumnDef("입력주소", InfcPkgSysm0100BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 수정자 : ismt */
    	listColumnDefs.add(new ColumnDef("수정자", InfcPkgSysm0100BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 수정일자 : revnDt */
    	listColumnDefs.add(new ColumnDef("수정일자", InfcPkgSysm0100BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 수정주소 : revnAddr */
    	listColumnDefs.add(new ColumnDef("수정주소", InfcPkgSysm0100BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 직종코드 : typOccuCd */
    	listColumnDefs.add(new ColumnDef("직종코드", InfcPkgSysm0100BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 호봉등급코드 : pyspGrdeCd */
    	listColumnDefs.add(new ColumnDef("호봉등급코드", InfcPkgSysm0100BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 사용자권한제외여부 : usrAuthEepnYn */
    	listColumnDefs.add(new ColumnDef("사용자권한제외여부", InfcPkgSysm0100BM.ATTR_USRAUTHEEPNYN, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 호봉제포함여부 : pyspInsnYn */
    	listColumnDefs.add(new ColumnDef("호봉제포함여부", InfcPkgSysm0100BM.ATTR_PYSPINSNYN, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 비호봉제포함여부 : notPyspInsnYn */
    	listColumnDefs.add(new ColumnDef("비호봉제포함여부", InfcPkgSysm0100BM.ATTR_NOTPYSPINSNYN, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 복무입력처리여부 : servcInptPrcsYn */
    	listColumnDefs.add(new ColumnDef("복무입력처리여부", InfcPkgSysm0100BM.ATTR_SERVCINPTPRCSYN, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 기간제포함여부 : shttmInsnYn */
    	listColumnDefs.add(new ColumnDef("기간제포함여부", InfcPkgSysm0100BM.ATTR_SHTTMINSNYN, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 사용자권한구분코드 : usrAuthDivCd */
    	listColumnDefs.add(new ColumnDef("사용자권한구분코드", InfcPkgSysm0100BM.ATTR_USRAUTHDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 직종세코드 : dtilOccuInttnCd */
    	listColumnDefs.add(new ColumnDef("직종세코드", InfcPkgSysm0100BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 권한적용시작일자 : authInStdt */
    	listColumnDefs.add(new ColumnDef("권한적용시작일자", InfcPkgSysm0100BM.ATTR_AUTHINSTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 권한적용종료일자 : authInEddt */
    	listColumnDefs.add(new ColumnDef("권한적용종료일자", InfcPkgSysm0100BM.ATTR_AUTHINEDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 사용자계정잠김여부 : usrLgnAccLckYn */
    	listColumnDefs.add(new ColumnDef("사용자계정잠김여부", InfcPkgSysm0100BM.ATTR_USRLGNACCLCKYN, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 단위사업장코드 : untDpobCd */
    	listColumnDefs.add(new ColumnDef("단위사업장코드", InfcPkgSysm0100BM.ATTR_UNTDPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 단위기관코드 : payMangeDeptCd */
    	listColumnDefs.add(new ColumnDef("단위기관코드", InfcPkgSysm0100BM.ATTR_PAYMANGEDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	
    	/** column 사용자권한구분코드 : usrDivCd */
    	listColumnDefs.add(new ColumnDef("사용자권한구분코드", InfcPkgSysm0100BM.ATTR_USRDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column SYSTEMKEY : systemkey */
    	listColumnDefs.add(new ColumnDef("SYSTEMKEY", InfcPkgSysm0100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 부서코드 : deptCd */
    	listColumnDefs.add(new ColumnDef("부서코드", InfcPkgSysm0100BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 전화번호 : usrTel */
    	listColumnDefs.add(new ColumnDef("전화번호", InfcPkgSysm0100BM.ATTR_USRTEL, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 이메일 : email */
    	listColumnDefs.add(new ColumnDef("이메일", InfcPkgSysm0100BM.ATTR_EMAIL, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 패스워드 : pwd */
    	listColumnDefs.add(new ColumnDef("패스워드", InfcPkgSysm0100BM.ATTR_PWD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
	    	
    	
    	return listColumnDefs;
        
    	
    }


    private List<ColumnDef> getYeta2080ToSys0100OffColumnsList() {
    	
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        
        
        /** column 선택 : select */
         listColumnDefs.add(new ColumnDef("선택", InfcPkgSysm0100BM.ATTR_SELECT, ColumnDef.TYPE_BOOLEAN, 55, false, true, true){
      	  {      	
      		 
      	  }        	  
         });  
        
        /** column 부서코드 : deptCd */
    	listColumnDefs.add(new ColumnListDef("부서", InfcPkgSysm0100BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 120, false, true, false,new LookupSysIfBass0400(sysIfBass0400Dto),SysIfBass0400BM.ATTR_DEPTCD,SysIfBass0400BM.ATTR_DEPTNMRTCHNT){
    		{

    		}
    	});
    	
    	sysIfBass0300Dto.setRpsttvCd("D001");
    	/** column 사용자구분코드 : usrDivCd */
    	listColumnDefs.add(new ColumnListDef("사용자구분", InfcPkgSysm0100BM.ATTR_USRDIVCD, ColumnDef.TYPE_STRING , 90, true, true, true,new LookupSysIfBass0300(sysIfBass0300Dto),SysIfBass0300BM.ATTR_COMMCD,SysIfBass0300BM.ATTR_COMMCDNM){
    		{

    		}
    	}); 
    	
    	
    	/** column 사용자아이디 : usrId */
    	listColumnDefs.add(new ColumnDef("아이디", InfcPkgSysm0100BM.ATTR_USRID, ColumnDef.TYPE_STRING , 70, false, true, false){
    		{
    			 
    		}
    	});
    	
    	/** column 사용자성명 : usrNm */
    	listColumnDefs.add(new ColumnDef("성명", InfcPkgSysm0100BM.ATTR_USRNM, ColumnDef.TYPE_STRING , 70, false, true, false){
    		{
    			 
    		}
    	});
    	

    	/** column 내선번호 : usrTel */
    	listColumnDefs.add(new ColumnDef("연말정산", InfcPkgSysm0100BM.ATTR_YRTXINPTPRCSYN, ColumnDef.TYPE_BOOLEAN , 50, false, true, false){
    		{

    		}
    	});
    	
    	
    	
    	//--- 
    	
        /** column 부서코드 : deptCd */
//    	listColumnDefs.add(new ColumnDef("부서", InfcPkgSysm0100BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, false, false, false){
//    		{
//
//    		}
//    	});
    	
        /** set 시스템구분코드 : sysDivCd */
    	listColumnDefs.add(new ColumnDef("시스템구분코드", InfcPkgSysm0100BM.ATTR_SYSDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	
    	/** column 입력자 : kybdr */
    	listColumnDefs.add(new ColumnDef("입력자", InfcPkgSysm0100BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 입력일자 : inptDt */
    	listColumnDefs.add(new ColumnDef("입력일자", InfcPkgSysm0100BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 입력주소 : inptAddr */
    	listColumnDefs.add(new ColumnDef("입력주소", InfcPkgSysm0100BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 수정자 : ismt */
    	listColumnDefs.add(new ColumnDef("수정자", InfcPkgSysm0100BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 수정일자 : revnDt */
    	listColumnDefs.add(new ColumnDef("수정일자", InfcPkgSysm0100BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 수정주소 : revnAddr */
    	listColumnDefs.add(new ColumnDef("수정주소", InfcPkgSysm0100BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 직종코드 : typOccuCd */
    	listColumnDefs.add(new ColumnDef("직종코드", InfcPkgSysm0100BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 호봉등급코드 : pyspGrdeCd */
    	listColumnDefs.add(new ColumnDef("호봉등급코드", InfcPkgSysm0100BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 사용자권한제외여부 : usrAuthEepnYn */
    	listColumnDefs.add(new ColumnDef("사용자권한제외여부", InfcPkgSysm0100BM.ATTR_USRAUTHEEPNYN, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 호봉제포함여부 : pyspInsnYn */
    	listColumnDefs.add(new ColumnDef("호봉제포함여부", InfcPkgSysm0100BM.ATTR_PYSPINSNYN, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 비호봉제포함여부 : notPyspInsnYn */
    	listColumnDefs.add(new ColumnDef("비호봉제포함여부", InfcPkgSysm0100BM.ATTR_NOTPYSPINSNYN, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 복무입력처리여부 : servcInptPrcsYn */
    	listColumnDefs.add(new ColumnDef("복무입력처리여부", InfcPkgSysm0100BM.ATTR_SERVCINPTPRCSYN, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 기간제포함여부 : shttmInsnYn */
    	listColumnDefs.add(new ColumnDef("기간제포함여부", InfcPkgSysm0100BM.ATTR_SHTTMINSNYN, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 사용자권한구분코드 : usrAuthDivCd */
    	listColumnDefs.add(new ColumnDef("사용자권한구분코드", InfcPkgSysm0100BM.ATTR_USRAUTHDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 직종세코드 : dtilOccuInttnCd */
    	listColumnDefs.add(new ColumnDef("직종세코드", InfcPkgSysm0100BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 권한적용시작일자 : authInStdt */
    	listColumnDefs.add(new ColumnDef("권한적용시작일자", InfcPkgSysm0100BM.ATTR_AUTHINSTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 권한적용종료일자 : authInEddt */
    	listColumnDefs.add(new ColumnDef("권한적용종료일자", InfcPkgSysm0100BM.ATTR_AUTHINEDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 사용자계정잠김여부 : usrLgnAccLckYn */
    	listColumnDefs.add(new ColumnDef("사용자계정잠김여부", InfcPkgSysm0100BM.ATTR_USRLGNACCLCKYN, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 단위사업장코드 : untDpobCd */
    	listColumnDefs.add(new ColumnDef("단위사업장코드", InfcPkgSysm0100BM.ATTR_UNTDPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 단위기관코드 : payMangeDeptCd */
    	listColumnDefs.add(new ColumnDef("단위기관코드", InfcPkgSysm0100BM.ATTR_PAYMANGEDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	
    	/** column 사용자권한구분코드 : usrDivCd */
    	listColumnDefs.add(new ColumnDef("사용자권한구분코드", InfcPkgSysm0100BM.ATTR_USRDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column SYSTEMKEY : systemkey */
    	listColumnDefs.add(new ColumnDef("SYSTEMKEY", InfcPkgSysm0100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 부서코드 : deptCd */
    	listColumnDefs.add(new ColumnDef("부서코드", InfcPkgSysm0100BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 전화번호 : usrTel */
    	listColumnDefs.add(new ColumnDef("전화번호", InfcPkgSysm0100BM.ATTR_USRTEL, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 이메일 : email */
    	listColumnDefs.add(new ColumnDef("이메일", InfcPkgSysm0100BM.ATTR_EMAIL, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
    	/** column 패스워드 : pwd */
    	listColumnDefs.add(new ColumnDef("패스워드", InfcPkgSysm0100BM.ATTR_PWD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
	    	
    	
    	return listColumnDefs;
        
    	
    }

}
