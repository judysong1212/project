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

import com.app.exterms.basis.client.dto.Bass0600BM;
import com.app.exterms.basis.client.languages.BasisConstants;
import com.app.exterms.basis.shared.BasisDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class Bass0600Def extends TableDef implements BasisDaoConstants {
    private int row = 0;
    
    private BasisConstants lblBasisConst = BasisConstants.INSTANCE;
    
    public Bass0600Def(){
    	
    	  setTitle(lblBasisConst.title_Bass0600());
          setDaoClass(CLASS_BASS0600_LIST); 
          setCustomListMethod(CLASS_BASS0600_LIST);
          
    	  setColumnsDefinition(getAllColumnsList());
          isAutoFillGrid = false;
    	  setAutoFillGrid(false);
          showFilterToolbar = false ; 
          
    }
       
    private List<ColumnDef> getAllColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
         
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Bass0600BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 이관작업구분코드 : trnrCtlJobDivCd */
        listColumnDefs.add(new ColumnDef("이관작업구분코드", Bass0600BM.ATTR_TRNRCTLJOBDIVCD, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 이관작업일련번호 : trnrCtlJobSeilNum */
        listColumnDefs.add(new ColumnDef("이관작업일련번호", Bass0600BM.ATTR_TRNRCTLJOBSEILNUM, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 이관작업일자 : trnrCtlJobDt */
        listColumnDefs.add(new ColumnDef("이관작업일자", Bass0600BM.ATTR_TRNRCTLJOBDT, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 이관작업시작일시 : trnrCtlJobBgnnDtntm */
        listColumnDefs.add(new ColumnDef("이관작업시작일시", Bass0600BM.ATTR_TRNRCTLJOBBGNNDTNTM, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 이관작업종료일시 : trnrCtlJobEndDtntm */
        listColumnDefs.add(new ColumnDef("이관작업종료일시", Bass0600BM.ATTR_TRNRCTLJOBENDDTNTM, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 이관작업내용 : trnrCtlJobCtnt */
        listColumnDefs.add(new ColumnDef("이관작업내용", Bass0600BM.ATTR_TRNRCTLJOBCTNT, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 이관작업완료여부 : trnrCtlJobCmpltnYn */
        listColumnDefs.add(new ColumnDef("이관작업완료여부", Bass0600BM.ATTR_TRNRCTLJOBCMPLTNYN, ColumnDef.TYPE_STRING, 90, true, false, true));
  
        
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
