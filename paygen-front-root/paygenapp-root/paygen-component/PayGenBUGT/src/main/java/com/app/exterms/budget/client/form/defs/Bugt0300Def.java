/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.exterms.budget.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.budget.client.dto.Bugt0200BM;
import com.app.exterms.budget.client.languages.BugtConstants;
import com.app.exterms.budget.shared.BugtDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class Bugt0300Def extends TableDef implements BugtDaoConstants {
    private int row = 0;
    
    private BugtConstants lblBugtConst = BugtConstants.INSTANCE;
    
    public Bugt0300Def(){
    	
    	  setTitle(lblBugtConst.title_Bugt0300());
          setDaoClass(CLASS_BUGT0300_LIST); 
          setCustomListMethod(CLASS_BUGT0300_LIST);
          
    	  setColumnsDefinition(getAllColumnsList());
          isAutoFillGrid = false;
    	  setAutoFillGrid(false);
          showFilterToolbar = false ; 
          
    }
       
    private List<ColumnDef> getAllColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서코드", Bugt0200BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 사업코드 : businCd */
        listColumnDefs.add(new ColumnDef("사업코드", Bugt0200BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Bugt0200BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 회계단위코드 : accUntCd */
        listColumnDefs.add(new ColumnDef("회계단위코드", Bugt0200BM.ATTR_ACCUNTCD, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 회계년도 : accYr */
        listColumnDefs.add(new ColumnDef("회계년도", Bugt0200BM.ATTR_ACCYR, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 회계단위_세목코드 : accUntTxItemCd */
        listColumnDefs.add(new ColumnDef("회계단위_세목코드", Bugt0200BM.ATTR_ACCUNTTXITEMCD, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 부서_사업예산금액 : deptBusinBugtSum */
        listColumnDefs.add(new ColumnDef("부서_사업예산금액", Bugt0200BM.ATTR_DEPTBUSINBUGTSUM, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 부서_사업잔액 : deptBusinBaln */
        listColumnDefs.add(new ColumnDef("부서_사업잔액", Bugt0200BM.ATTR_DEPTBUSINBALN, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Bugt0200BM.ATTR_KYBDR, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Bugt0200BM.ATTR_INPTDT, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Bugt0200BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Bugt0200BM.ATTR_ISMT, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Bugt0200BM.ATTR_REVNDT, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column IP주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("IP주소", Bugt0200BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING, 90, true, false, true));



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
}
