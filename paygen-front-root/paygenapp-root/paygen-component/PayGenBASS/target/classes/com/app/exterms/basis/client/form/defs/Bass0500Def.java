/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.exterms.basis.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.basis.client.dto.Bass0150BM;
import com.app.exterms.basis.client.dto.Bass0500BM;
import com.app.exterms.basis.client.languages.BasisConstants;
import com.app.exterms.basis.shared.BasisDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class Bass0500Def extends TableDef implements BasisDaoConstants {
    private int row = 0;
    
    private BasisConstants lblBasisConst = BasisConstants.INSTANCE;
    
    public Bass0500Def(){
    	
    	  setTitle(lblBasisConst.title_Bass0500());
          setDaoClass(CLASS_BASS0500_LIST); 
          setCustomListMethod(CLASS_BASS0500_LIST);
          
    	  setColumnsDefinition(getAllColumnsList());
          isAutoFillGrid = false;
    	  setAutoFillGrid(false);
          showFilterToolbar = false ; 
          
    }
    
    public Bass0500Def(String chkDef){
    	if ("BASS0500_BEF".equals(chkDef)) {
	        setTitle("");
	        setDaoClass("");
	        setCustomListMethod(CLASS_BASS0500_LIST);
	        
	        setAutoFillGrid(false);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
	        setEditFieldGrid(true);
//	        setCellModel(true);
	        
	        setColumnsDefinition(getBass0500List());  
	      
    	}else if ("BASS0500_CRE".equals(chkDef)) {
	        setTitle("");
	        setDaoClass("");
	        setCustomListMethod(CLASS_BASS0500_LIST);
	        
	        setAutoFillGrid(false);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(false);
	        setEditFieldGrid(false);
//	        setCellModel(true);
	       
	        setColumnsDefinition(getBass0500List());
	        
    	}
    }
    
    
    private List<ColumnDef> getAllColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
         
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Bass0500BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 100, true, true, true));
        
        listColumnDefs.add(new ColumnDef("사업장명",  Bass0150BM.ATTR_DPOBNM, ColumnDef.TYPE_STRING, 100, true, true, true));
        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서코드", Bass0500BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 90, true, true, true));
        listColumnDefs.add(new ColumnDef("부서명", Bass0500BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 150, true, true, true));
        
        /** column 사업적용년도 : businApptnYr */
        listColumnDefs.add(new ColumnDef("사업적용년도", Bass0500BM.ATTR_BUSINAPPTNYR, ColumnDef.TYPE_STRING, 90, true, true, true));
        
        /** column 사업코드 : businCd */
        listColumnDefs.add(new ColumnDef("사업코드", Bass0500BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING, 90, true, true, true));
        
        /** column 사업명 : businNm */
        listColumnDefs.add(new ColumnDef("사업명", Bass0500BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING, 250, true, true, true));
        
        /** column 사업고용직종코드 : businEmymtTypOccuCd */
        listColumnDefs.add(new ColumnDef("사업고용직종코드", Bass0500BM.ATTR_BUSINEMYMTTYPOCCUCD, ColumnDef.TYPE_STRING, 90, true, true, true));
        listColumnDefs.add(new ColumnDef("직종명", Bass0500BM.ATTR_BUSINEMYMTTYPOCCUNM, ColumnDef.TYPE_STRING, 130, true, true, true));
        
        /** column 사업담당직원번호 : businRepbtyEmpNum */
        listColumnDefs.add(new ColumnDef("사업담당직원번호", Bass0500BM.ATTR_BUSINREPBTYEMPNUM, ColumnDef.TYPE_STRING, 90, true, true, true));

        /** column 산재보험요율 : idtlAccdtInsurApmrt */
        listColumnDefs.add(new ColumnDef("산재보험요율", Bass0500BM.ATTR_IDTLACCDTINSURAPMRT, ColumnDef.TYPE_BIGDECIMAL, 90, true, true, true));

        /** column 특기사항내용 : spityCtnt */
        listColumnDefs.add(new ColumnDef("특기사항내용", Bass0500BM.ATTR_SPITYCTNT, ColumnDef.TYPE_STRING, 90, true, true, true));
        
        listColumnDefs.add(new ColumnDef("사업시작일자", Bass0500BM.BUSIN_STDT, ColumnDef.TYPE_STRING, 90, true, false, true));
        
        listColumnDefs.add(new ColumnDef("사업종료일자", Bass0500BM.BUSIN_EDDT, ColumnDef.TYPE_STRING, 90, true, false, true));
        
        //개발_시간외근무 최대 인정시간_20201026
        listColumnDefs.add(new ColumnDef("시간외근무 최대인정시간", Bass0500BM.DILNLAZ_TM_RST_DUTY_TM, ColumnDef.TYPE_STRING, 90, true, false, true));
        
        /** column 국민연금기호 : natPennSym */
        listColumnDefs.add(new ColumnDef("국민연금기호", Bass0500BM.ATTR_NATPENNSYM, ColumnDef.TYPE_STRING, 90, true, true, true));

        /** column 건강보험기호 : hlthInsrSym */
        listColumnDefs.add(new ColumnDef("건강보험기호", Bass0500BM.ATTR_HLTHINSRSYM, ColumnDef.TYPE_STRING, 90, true, true, true));

        /** column 고용보험기호 : umytInsrSym */
        listColumnDefs.add(new ColumnDef("고용보험기호", Bass0500BM.ATTR_UMYTINSRSYM, ColumnDef.TYPE_STRING, 90, true, true, true));

        /** column 산재보험기호 : idtlAccdtInsurSym */
        listColumnDefs.add(new ColumnDef("산재보험기호", Bass0500BM.ATTR_IDTLACCDTINSURSYM, ColumnDef.TYPE_STRING, 90, true, true, true));
        
        /** set 건강보험영업소기호 : hlthInsrOfceSym */
        listColumnDefs.add(new ColumnDef("건강보험영업소기호",   Bass0500BM.ATTR_HLTHINSROFCESYM,   ColumnDef.TYPE_STRING , 110, true, false, false));
        
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
 //        setRegEx(RegEx.EMAIL);
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
    
    
    
   private List<ColumnDef> getBass0500List(){
    	
        row = 0;
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
         
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Bass0500BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 100, true, false, true));
        
        listColumnDefs.add(new ColumnDef("사업장명",  Bass0150BM.ATTR_DPOBNM, ColumnDef.TYPE_STRING, 100, true, false, true));
        
        /** column 사업적용년도 : businApptnYr */
        listColumnDefs.add(new ColumnDef("년도", Bass0500BM.ATTR_BUSINAPPTNYR, ColumnDef.TYPE_STRING, 90, true, true, true));
        
        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서코드", Bass0500BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 90, true, false, true));
        listColumnDefs.add(new ColumnDef("부서", Bass0500BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 150, true, true, true));
        

        /** column 사업코드 : businCd */
        listColumnDefs.add(new ColumnDef("사업코드", Bass0500BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING, 90, true, false, true));
        
        /** column 사업명 : businNm */
        listColumnDefs.add(new ColumnDef("사업명", Bass0500BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING, 250, true, true, true));
        
        /** column 사업고용직종코드 : businEmymtTypOccuCd */
        listColumnDefs.add(new ColumnDef("사업고용직종코드", Bass0500BM.ATTR_BUSINEMYMTTYPOCCUCD, ColumnDef.TYPE_STRING, 90, true, false, true));
        listColumnDefs.add(new ColumnDef("직종명", Bass0500BM.ATTR_BUSINEMYMTTYPOCCUNM, ColumnDef.TYPE_STRING, 130, true, false, true));
        
        /** column 사업담당직원번호 : businRepbtyEmpNum */
        listColumnDefs.add(new ColumnDef("사업담당직원번호", Bass0500BM.ATTR_BUSINREPBTYEMPNUM, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 산재보험요율 : idtlAccdtInsurApmrt */
        listColumnDefs.add(new ColumnDef("산재보험요율", Bass0500BM.ATTR_IDTLACCDTINSURAPMRT, ColumnDef.TYPE_BIGDECIMAL, 90, true, false, true));

        /** column 특기사항내용 : spityCtnt */
        listColumnDefs.add(new ColumnDef("특기사항내용", Bass0500BM.ATTR_SPITYCTNT, ColumnDef.TYPE_STRING, 90, true, false, true));
        
        listColumnDefs.add(new ColumnDef("사업시작일자", Bass0500BM.BUSIN_STDT, ColumnDef.TYPE_STRING, 90, true, false, true));
        
        listColumnDefs.add(new ColumnDef("사업종료일자", Bass0500BM.BUSIN_EDDT, ColumnDef.TYPE_STRING, 90, true, false, true));
        
        /** column 국민연금기호 : natPennSym */
        listColumnDefs.add(new ColumnDef("국민연금기호", Bass0500BM.ATTR_NATPENNSYM, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 건강보험기호 : hlthInsrSym */
        listColumnDefs.add(new ColumnDef("건강보험기호", Bass0500BM.ATTR_HLTHINSRSYM, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 고용보험기호 : umytInsrSym */
        listColumnDefs.add(new ColumnDef("고용보험기호", Bass0500BM.ATTR_UMYTINSRSYM, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 산재보험기호 : idtlAccdtInsurSym */
        listColumnDefs.add(new ColumnDef("산재보험기호", Bass0500BM.ATTR_IDTLACCDTINSURSYM, ColumnDef.TYPE_STRING, 90, true, false, true));
        
        /** set 건강보험영업소기호 : hlthInsrOfceSym */
        listColumnDefs.add(new ColumnDef("건강보험영업소기호",   Bass0500BM.ATTR_HLTHINSROFCESYM,   ColumnDef.TYPE_STRING , 110, true, false, false));
        

        return listColumnDefs;
    }
}
