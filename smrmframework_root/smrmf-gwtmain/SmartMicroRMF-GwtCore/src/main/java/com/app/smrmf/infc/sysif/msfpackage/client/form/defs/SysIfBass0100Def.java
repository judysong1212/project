/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.infc.sysif.msfpackage.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.languages.MSFConstants;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0100BM;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0300BM;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0300DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.lookup.LookupSysIfBass0300;
import com.app.smrmf.infc.sysif.msfpackage.shared.MSFPkgDaoConstants;

public class SysIfBass0100Def extends TableDef implements MSFPkgDaoConstants {
	
    private int row = 0;
    
    private SysIfBass0300DTO sysComBass0300Dto;
    private MSFConstants lblSysIfConst = MSFConstants.INSTANCE;
    
    
    public SysIfBass0100Def(){
    	
    	  setTitle("");
          setDaoClass(CLASS_SYSMUSR0050TOBASS0100_LIST); 
          setCustomListMethod(CLASS_SYSMUSR0050TOBASS0100_LIST);
          setColumnsDefinition(getAllColumnsList());
          setAutoFillGrid(false);
          setShowFilterToolbar(false);
    }
    
    public SysIfBass0100Def(String chkDef){
    	
    	sysComBass0300Dto = new SysIfBass0300DTO();
    	
    	if ("BASS0100_01".equals(chkDef)) {
	        setTitle("");
	        setDaoClass(CLASS_SYSMUSR0050TOBASS0100_MLIST); 
	        setCustomListMethod(CLASS_SYSMUSR0050TOBASS0100_MLIST);
	        
	        setAutoFillGrid(false);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(false);
	        setEditFieldGrid(false);
//	        setCellModel(true);
	        setColumnsDefinition(getMasterColumnsList());  
	      
    	}else if ("BASS0100_02".equals(chkDef)) {
	        setTitle("");
	        setDaoClass(CLASS_SYSMUSR0050TOBASS0100_SLIST); 
	        setCustomListMethod(CLASS_SYSMUSR0050TOBASS0100_SLIST);
	        
	        setAutoFillGrid(false);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(false);
	        setEditFieldGrid(false);
//	        setCellModel(true);
	        
	        setColumnsDefinition(getServantColumnsList());
	        
		}
	}

    private List<ColumnDef> getAllColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
         
        /** identifier field */
        listColumnDefs.add(new ColumnDef("사업장코드",   SysIfBass0100BM.ATTR_DPOBCD,   ColumnDef.TYPE_STRING , 110, true, true, true));
        
        /** identifier field */
        listColumnDefs.add(new ColumnDef("사업장명",   SysIfBass0100BM.ATTR_DPOBNM,   ColumnDef.TYPE_STRING, 90, true, true, true));
        
        /** identifier field */
        listColumnDefs.add(new ColumnDef("대표자명",   SysIfBass0100BM.ATTR_DEGTRNM,   ColumnDef.TYPE_STRING, 90, true, true, true) );
        
        /** identifier field */
        listColumnDefs.add(new ColumnDef("사업자번호",   SysIfBass0100BM.ATTR_BUSOPRRGSTNNUM,   ColumnDef.TYPE_STRING, 90, true, true, true) );
        
        /** identifier field */
        listColumnDefs.add(new ColumnDef("법인번호",   SysIfBass0100BM.ATTR_CORPRGSTNNUM,   ColumnDef.TYPE_STRING, 90, true, true, true));
        
        /** identifier field */
        listColumnDefs.add(new ColumnDef("법인구분코드",   SysIfBass0100BM.ATTR_CORPDIVCD,   ColumnDef.TYPE_STRING, 90, true, false, true)); 
        
        /** identifier field */
        listColumnDefs.add(new ColumnDef("우편번호",   SysIfBass0100BM.ATTR_DPOBZPCD,   ColumnDef.TYPE_STRING, 90, true, true, true));
        
        /** identifier field */
        listColumnDefs.add(new ColumnDef("도로명기본주소",   SysIfBass0100BM.ATTR_DPOBFNDTNADDR,   ColumnDef.TYPE_STRING, 150, true, true, true));
        
        /** identifier field */
        listColumnDefs.add(new ColumnDef("도로명상세주소",   SysIfBass0100BM.ATTR_DPOBDTLPATRADDR,   ColumnDef.TYPE_STRING, 150, true, true, true));
        
        /** identifier field */
        listColumnDefs.add(new ColumnDef("전화번호",   SysIfBass0100BM.ATTR_DPOBPHNNUM,   ColumnDef.TYPE_STRING, 90, true, true, true));
        
        /** identifier field */
        listColumnDefs.add(new ColumnDef("팩스",   SysIfBass0100BM.ATTR_DPOBFAXNUM,   ColumnDef.TYPE_STRING, 90, true, true, true));
        
        /** identifier field */
        listColumnDefs.add(new ColumnDef("직인문구명",   SysIfBass0100BM.ATTR_DPOBSEALWRDNM,   ColumnDef.TYPE_STRING, 90, true, false, true) );
        
        /** identifier field */
        listColumnDefs.add(new ColumnDef("직인경로명",   SysIfBass0100BM.ATTR_DPOBSEALRFTANM,   ColumnDef.TYPE_STRING, 90, true, false, true) );
        
        /** identifier field */
        listColumnDefs.add(new ColumnDef("직인파일명",   SysIfBass0100BM.ATTR_DPOBSEALFLNM,   ColumnDef.TYPE_STRING, 90, true, false, true) );
        
        /** identifier field */
        listColumnDefs.add(new ColumnDef("사용여부",   SysIfBass0100BM.ATTR_DPOBFNDTNUSEYN,   ColumnDef.TYPE_STRING, 90, true, true, true));
        
        /** identifier field */
        listColumnDefs.add(new ColumnDef("건강보험기호",   SysIfBass0100BM.ATTR_HLTHINSRSYM,   ColumnDef.TYPE_STRING, 90, true, true, true));
        
        /** identifier field */
        listColumnDefs.add(new ColumnDef("국민연금기호",   SysIfBass0100BM.ATTR_NATPENNSYM,   ColumnDef.TYPE_STRING, 90, true, true, true));
        
        /** identifier field */
        listColumnDefs.add(new ColumnDef("고용보험기호",   SysIfBass0100BM.ATTR_UMYTINSRSYM,   ColumnDef.TYPE_STRING, 90, true, true, true));
        
        /** identifier field */
        listColumnDefs.add(new ColumnDef("산재보험기호",   SysIfBass0100BM.ATTR_IDTLACCDTINSURSYM,   ColumnDef.TYPE_STRING, 90, true, true, true));
         
        /** identifier field */
        listColumnDefs.add(new ColumnDef("주민등록번호",   SysIfBass0100BM.ATTR_DEGTRRESNREGNNUM,   ColumnDef.TYPE_STRING, 90, true, false, false)); 
        
        /** identifier field */
        listColumnDefs.add(new ColumnDef("주민등록번호원본",   SysIfBass0100BM.ATTR_DEGTRSECREGNNUM,   ColumnDef.TYPE_STRING, 90, true, false, false)); 
         
        /** 시스템코드 */
        listColumnDefs.add(new ColumnDef("시스템코드",   SysIfBass0100BM.ATTR_SYSDIVCD,   ColumnDef.TYPE_STRING, 90, true, false, false) );
       
        /** 건강보험영업소기호 */
        listColumnDefs.add(new ColumnDef("건강보험영업소기호",   SysIfBass0100BM.ATTR_HLTHINSROFCESYM,   ColumnDef.TYPE_STRING, 90, true, false, false) );
        
        /** 상위 사업장 코드*/
        listColumnDefs.add(new ColumnDef("상위사업장코드",   SysIfBass0100BM.ATTR_TPLVLDPOBCD,   ColumnDef.TYPE_STRING , 110, true, false, false));
        
        /** 징수의무자 구분코드 */
        listColumnDefs.add(new ColumnDef("징수의무자 구분코드",   SysIfBass0100BM.ATTR_RETRYCLLNDEBRDIVCD,   ColumnDef.TYPE_STRING , 110, true, false, false));
        
        /**  보험사무대행기관번호 */
        listColumnDefs.add(new ColumnDef("보험사무대행기관번호",   SysIfBass0100BM.ATTR_INSURPRVAFFAGCYISTUTNUM,   ColumnDef.TYPE_STRING , 110, true, false, false));
        
        /**  보험사무대행기관명 */
        listColumnDefs.add(new ColumnDef("보험사무대행기관명",   SysIfBass0100BM.ATTR_INSURPRVAFFAGCYISTUTNM,   ColumnDef.TYPE_STRING , 110, true, false, false));

//      listColumnDefs.add(new ColumnDef(lblBasisConst.lastName(),     ATTR_Employees_lastName,     ColumnDef.TYPE_STRING, 150, true, true, true){
//      {
//          setAttributeCustomForm(new AttributeCustomForm(0, row++));
//          setTypeTextField(ColumnDef.TEXTFIELD);
//      }
//  });
//  listColumnDefs.add(new ColumnDef(lblBasisConst.firstName(),    ATTR_Employees_firstName,    ColumnDef.TYPE_STRING, 150, true, true, true){
//      {
//          setAttributeCustomForm(new AttributeCustomForm(0, row++));
//          setTypeTextField(ColumnDef.TEXTFIELD);
//      }
//  });
//  listColumnDefs.add(new ColumnDef(lblBasisConst.hireDate(),     ATTR_Employees_hireDate,     ColumnDef.TYPE_DATE, 100, true, true, true){
//      {
//          setAttributeCustomForm(new AttributeCustomForm(0, row, 100));
//      }
//  });
//  listColumnDefs.add(new ColumnListStaticDef(lblBasisConst.sex(), ATTR_Employees_sex,         ColumnDef.TYPE_STRING, 40, true, true, true, StaticGroup.SEX.getList()){
//      {
//          setAttributeCustomForm(new AttributeCustomForm(1, row++, 40, 40));
//      }
//  });
//  listColumnDefs.add(new ColumnDef(lblBasisConst.email(),         ATTR_Employees_email,       ColumnDef.TYPE_STRING, true, true, new AttributeCustomForm(0, row++)){
//      {
//          setRegEx(RegEx.EMAIL);
//      }
//  });
//  listColumnDefs.add(new ColumnDef(lblBasisConst.phoneNumber(),   ATTR_Employees_phoneNumber, ColumnDef.TYPE_STRING, false, true, new AttributeCustomForm(0, row, 150)));
//  listColumnDefs.add(new ColumnDef(lblBasisConst.personalPhoneNumber(), ATTR_Employees_personalPhoneNumber, ColumnDef.TYPE_BOOLEAN, false, true, new AttributeCustomForm(1, row++, 40, 100)));
//
//  
//  listColumnDefs.add(new ColumnDef(lblBasisConst.salary(),        ATTR_Employees_salary,      ColumnDef.TYPE_DOUBLE, false, true, new AttributeCustomForm(0, row, 150)){
//      {
//          setFormatNumeric(NumberFormat.getCurrencyFormat("EUR"));
//      }
//  });
//  listColumnDefs.add(new ColumnDef(lblBasisConst.commissionPct(), ATTR_Employees_commissionPct, ColumnDef.TYPE_DOUBLE, false, true, new AttributeCustomForm(1, row++, 100, 50)){
//      {
//          setFormatNumeric(NumberFormat.getPercentFormat());
//      }
//  });
//  listColumnDefs.add(new ColumnListDef(lblBasisConst.departments(), ATTR_Employees_departments, ColumnDef.TYPE_LONG, 100, false, false, true, new LookupDepartments(), "departmentId", "departmentName"){
//      {
//          setAttributeCustomForm(new AttributeCustomForm(0, row++));
//      }
//  });
//  listColumnDefs.add(new ColumnListDef("Manager",         ATTR_Employees_employees,   ColumnDef.TYPE_LONG, 100, false, false, true, new LookupEmployees(), "employeeId", "lastName"){
//      {
//          setAttributeCustomForm(new AttributeCustomForm(0, row++));
//      }
//  });
//  listColumnDefs.add(new ColumnListDef(lblBasisConst.jobs(),        ATTR_Employees_jobs,        ColumnDef.TYPE_STRING, 100, false, false, true, new LookupJobs(), "jobId", "jobTitle"){
//      {
//          setAttributeCustomForm(new AttributeCustomForm(0, row++));
//      }
//  });
//
//  listColumnDefs.add(new ColumnDef(lblBasisConst.fullTime(),        ATTR_Employees_fullTime,    ColumnDef.TYPE_BOOLEAN, 50, false, true, true){
//      {
//          setAttributeCustomForm(new AttributeCustomForm(0, row++, 50));
//      }
//  });
//  listColumnDefs.add(new ColumnDef(lblBasisConst.personalInformations() , ATTR_Employees_personalInformations, ColumnDef.TYPE_STRING, false, true, new AttributeCustomForm(0, row++, 0)){
//      {
//          setTypeTextField(ColumnDef.HTMLEDITOR);
//      }
//  });
        return listColumnDefs;
    }
    
    // 주 사업장 그리드
    private List<ColumnDef> getMasterColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        /** column 주종사업장구분코드 : mtstBusinDivCd */
        listColumnDefs.add(new ColumnDef("주종사업장구분코드", SysIfBass0100BM.ATTR_MTSTBUSINDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        sysComBass0300Dto.setRpsttvCd("C003");
        listColumnDefs.add(new ColumnListDef("주종구분",   SysIfBass0100BM.ATTR_MTSTBUSINDIVCD,   ColumnDef.TYPE_STRING, 100, true, true, true,  new LookupSysIfBass0300(sysComBass0300Dto),SysIfBass0300BM.ATTR_COMMCD,SysIfBass0300BM.ATTR_COMMCDNM){
        	{

            }
        });
         

        /** column 사업장명 : dpobNm */
        listColumnDefs.add(new ColumnDef("사업장명", SysIfBass0100BM.ATTR_DPOBNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        
        /** column 대표자명 : degtrNm */
        listColumnDefs.add(new ColumnDef("대표자명", SysIfBass0100BM.ATTR_DEGTRNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        
        /** column 사업자등록번호 : busoprRgstnNum */
        listColumnDefs.add(new ColumnDef("사업자등록번호", SysIfBass0100BM.ATTR_BUSOPRRGSTNNUM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        
        /** column 사업장기본사용여부 : dpobFndtnUseYn */
        listColumnDefs.add(new ColumnDef("사용여부", SysIfBass0100BM.ATTR_DPOBFNDTNUSEYN, ColumnDef.TYPE_BOOLEAN , 90, true, true, true){
        	{

        	}
        });

        
        // ===============
        
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", SysIfBass0100BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 대표자주민번호 : degtrResnRegnNum */
        listColumnDefs.add(new ColumnDef("대표자주민번호", SysIfBass0100BM.ATTR_DEGTRRESNREGNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : tplvlDpobCd */
        listColumnDefs.add(new ColumnDef("상위사업장코드", SysIfBass0100BM.ATTR_TPLVLDPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });


        /** column 법인등록번호 : corpRgstnNum */
        listColumnDefs.add(new ColumnDef("법인등록번호", SysIfBass0100BM.ATTR_CORPRGSTNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 법인구분코드 : corpDivCd */
        listColumnDefs.add(new ColumnDef("법인구분코드", SysIfBass0100BM.ATTR_CORPDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업장우편번호 : dpobZpcd */
        listColumnDefs.add(new ColumnDef("사업장우편번호", SysIfBass0100BM.ATTR_DPOBZPCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업장기본주소 : dpobFndtnAddr */
        listColumnDefs.add(new ColumnDef("사업장기본주소", SysIfBass0100BM.ATTR_DPOBFNDTNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업장상세주소 : dpobDtlPatrAddr */
        listColumnDefs.add(new ColumnDef("사업장상세주소", SysIfBass0100BM.ATTR_DPOBDTLPATRADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업장전화번호 : dpobPhnNum */
        listColumnDefs.add(new ColumnDef("사업장전화번호", SysIfBass0100BM.ATTR_DPOBPHNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업장팩스번호 : dpobFaxNum */
        listColumnDefs.add(new ColumnDef("사업장팩스번호", SysIfBass0100BM.ATTR_DPOBFAXNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업장직인문구명 : dpobSealWrdNm */
        listColumnDefs.add(new ColumnDef("사업장직인문구명", SysIfBass0100BM.ATTR_DPOBSEALWRDNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업장직인경로 : dpobSealRftaNm */
        listColumnDefs.add(new ColumnDef("사업장직인경로", SysIfBass0100BM.ATTR_DPOBSEALRFTANM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업장직인파일명 : dpobSealFlNm */
        listColumnDefs.add(new ColumnDef("사업장직인파일명", SysIfBass0100BM.ATTR_DPOBSEALFLNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

        /** column 건강보험기호 : hlthInsrSym */
        listColumnDefs.add(new ColumnDef("건강보험기호", SysIfBass0100BM.ATTR_HLTHINSRSYM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 국민연금기호 : natPennSym */
        listColumnDefs.add(new ColumnDef("국민연금기호", SysIfBass0100BM.ATTR_NATPENNSYM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 고용보험기호 : umytInsrSym */
        listColumnDefs.add(new ColumnDef("고용보험기호", SysIfBass0100BM.ATTR_UMYTINSRSYM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 시스템플래그 : sysDivCd */
        listColumnDefs.add(new ColumnDef("시스템플래그", SysIfBass0100BM.ATTR_SYSDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 시스템사업장코드 : sysDpobCd */
        listColumnDefs.add(new ColumnDef("시스템사업장코드", SysIfBass0100BM.ATTR_SYSDPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", SysIfBass0100BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", SysIfBass0100BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", SysIfBass0100BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", SysIfBass0100BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", SysIfBass0100BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정자주소", SysIfBass0100BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 퇴직징수의무자구분코드 : retryCllnDebrDivCd */
        listColumnDefs.add(new ColumnDef("퇴직징수의무자구분코드", SysIfBass0100BM.ATTR_RETRYCLLNDEBRDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 보험사무대행기관번호 : insurPrvaffAgcyIstutNum */
        listColumnDefs.add(new ColumnDef("보험사무대행기관번호", SysIfBass0100BM.ATTR_INSURPRVAFFAGCYISTUTNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 보험사무대행기관명 : insurPrvaffAgcyIstutNm */
        listColumnDefs.add(new ColumnDef("보험사무대행기관명", SysIfBass0100BM.ATTR_INSURPRVAFFAGCYISTUTNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 건강보험영업소기호 : hlthInsrOfceSym */
        listColumnDefs.add(new ColumnDef("건강보험영업소기호", SysIfBass0100BM.ATTR_HLTHINSROFCESYM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 산재보험기호 : idtlAccdtInsurSym */
        listColumnDefs.add(new ColumnDef("산재보험기호", SysIfBass0100BM.ATTR_IDTLACCDTINSURSYM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

        return listColumnDefs;
    }
    
    // 종 사업장 그리드
    private List<ColumnDef> getServantColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
         
        /** column 주종사업장구분코드 : mtstBusinDivCd */
        listColumnDefs.add(new ColumnDef("주종사업장구분코드", SysIfBass0100BM.ATTR_MTSTBUSINDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        sysComBass0300Dto.setRpsttvCd("C003");
        listColumnDefs.add(new ColumnListDef("주종구분",   SysIfBass0100BM.ATTR_MTSTBUSINDIVCD,   ColumnDef.TYPE_STRING, 100, true, true, true,  new LookupSysIfBass0300(sysComBass0300Dto),SysIfBass0300BM.ATTR_COMMCD,SysIfBass0300BM.ATTR_COMMCDNM){
        	{

            }
        });
         

        /** column 사업장명 : dpobNm */
        listColumnDefs.add(new ColumnDef("사업장명", SysIfBass0100BM.ATTR_DPOBNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        
        /** column 대표자명 : degtrNm */
        listColumnDefs.add(new ColumnDef("대표자명", SysIfBass0100BM.ATTR_DEGTRNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        
        /** column 사업자등록번호 : busoprRgstnNum */
        listColumnDefs.add(new ColumnDef("사업자등록번호", SysIfBass0100BM.ATTR_BUSOPRRGSTNNUM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        
        /** column 사업장기본사용여부 : dpobFndtnUseYn */
        listColumnDefs.add(new ColumnDef("사용여부", SysIfBass0100BM.ATTR_DPOBFNDTNUSEYN, ColumnDef.TYPE_BOOLEAN , 90, true, true, true){
        	{

        	}
        });

        
        // ===============
        
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", SysIfBass0100BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 대표자주민번호 : degtrResnRegnNum */
        listColumnDefs.add(new ColumnDef("대표자주민번호", SysIfBass0100BM.ATTR_DEGTRRESNREGNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column null : tplvlDpobCd */
        listColumnDefs.add(new ColumnDef("상위사업장코드", SysIfBass0100BM.ATTR_TPLVLDPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });


        /** column 법인등록번호 : corpRgstnNum */
        listColumnDefs.add(new ColumnDef("법인등록번호", SysIfBass0100BM.ATTR_CORPRGSTNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 법인구분코드 : corpDivCd */
        listColumnDefs.add(new ColumnDef("법인구분코드", SysIfBass0100BM.ATTR_CORPDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업장우편번호 : dpobZpcd */
        listColumnDefs.add(new ColumnDef("사업장우편번호", SysIfBass0100BM.ATTR_DPOBZPCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업장기본주소 : dpobFndtnAddr */
        listColumnDefs.add(new ColumnDef("사업장기본주소", SysIfBass0100BM.ATTR_DPOBFNDTNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업장상세주소 : dpobDtlPatrAddr */
        listColumnDefs.add(new ColumnDef("사업장상세주소", SysIfBass0100BM.ATTR_DPOBDTLPATRADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업장전화번호 : dpobPhnNum */
        listColumnDefs.add(new ColumnDef("사업장전화번호", SysIfBass0100BM.ATTR_DPOBPHNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업장팩스번호 : dpobFaxNum */
        listColumnDefs.add(new ColumnDef("사업장팩스번호", SysIfBass0100BM.ATTR_DPOBFAXNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업장직인문구명 : dpobSealWrdNm */
        listColumnDefs.add(new ColumnDef("사업장직인문구명", SysIfBass0100BM.ATTR_DPOBSEALWRDNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업장직인경로 : dpobSealRftaNm */
        listColumnDefs.add(new ColumnDef("사업장직인경로", SysIfBass0100BM.ATTR_DPOBSEALRFTANM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업장직인파일명 : dpobSealFlNm */
        listColumnDefs.add(new ColumnDef("사업장직인파일명", SysIfBass0100BM.ATTR_DPOBSEALFLNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 시스템사업장코드 : sysDpobCd */
        listColumnDefs.add(new ColumnDef("시스템사업장코드", SysIfBass0100BM.ATTR_SYSDPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

        /** column 건강보험기호 : hlthInsrSym */
        listColumnDefs.add(new ColumnDef("건강보험기호", SysIfBass0100BM.ATTR_HLTHINSRSYM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 국민연금기호 : natPennSym */
        listColumnDefs.add(new ColumnDef("국민연금기호", SysIfBass0100BM.ATTR_NATPENNSYM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 고용보험기호 : umytInsrSym */
        listColumnDefs.add(new ColumnDef("고용보험기호", SysIfBass0100BM.ATTR_UMYTINSRSYM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 시스템플래그 : sysDivCd */
        listColumnDefs.add(new ColumnDef("시스템플래그", SysIfBass0100BM.ATTR_SYSDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", SysIfBass0100BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", SysIfBass0100BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", SysIfBass0100BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", SysIfBass0100BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", SysIfBass0100BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정자주소", SysIfBass0100BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 퇴직징수의무자구분코드 : retryCllnDebrDivCd */
        listColumnDefs.add(new ColumnDef("퇴직징수의무자구분코드", SysIfBass0100BM.ATTR_RETRYCLLNDEBRDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 보험사무대행기관번호 : insurPrvaffAgcyIstutNum */
        listColumnDefs.add(new ColumnDef("보험사무대행기관번호", SysIfBass0100BM.ATTR_INSURPRVAFFAGCYISTUTNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 보험사무대행기관명 : insurPrvaffAgcyIstutNm */
        listColumnDefs.add(new ColumnDef("보험사무대행기관명", SysIfBass0100BM.ATTR_INSURPRVAFFAGCYISTUTNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 건강보험영업소기호 : hlthInsrOfceSym */
        listColumnDefs.add(new ColumnDef("건강보험영업소기호", SysIfBass0100BM.ATTR_HLTHINSROFCESYM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 산재보험기호 : idtlAccdtInsurSym */
        listColumnDefs.add(new ColumnDef("산재보험기호", SysIfBass0100BM.ATTR_IDTLACCDTINSURSYM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        return listColumnDefs;
        
    }
    
}
