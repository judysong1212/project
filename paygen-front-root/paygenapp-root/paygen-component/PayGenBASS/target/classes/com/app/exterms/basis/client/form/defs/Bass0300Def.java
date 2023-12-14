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

import com.app.exterms.basis.client.dto.Bass0300BM;
import com.app.exterms.basis.client.languages.BasisConstants;
import com.app.exterms.basis.shared.BasisDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class Bass0300Def extends TableDef implements BasisDaoConstants {
    private int row = 0;
    
    private BasisConstants lblBasisConst = BasisConstants.INSTANCE;
    
    public Bass0300Def(){
    	
    	  setTitle(lblBasisConst.title_Bass0300());
          setDaoClass(CLASS_BASS0300_LIST); 
          setCustomListMethod(CLASS_BASS0300_LIST);
          
    	  setColumnsDefinition(getAllColumnsList());
          isAutoFillGrid = false;
    	  setAutoFillGrid(false);
          showFilterToolbar = false ; 
          
    }
       
    private List<ColumnDef> getAllColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
         
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Bass0300BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 공통코드 : commCd */
        listColumnDefs.add(new ColumnDef("공통코드", Bass0300BM.ATTR_COMMCD, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 대표코드 : rpsttvCd */
        listColumnDefs.add(new ColumnDef("대표코드", Bass0300BM.ATTR_RPSTTVCD, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 세부코드 : dtlCd */
        listColumnDefs.add(new ColumnDef("세부코드", Bass0300BM.ATTR_DTLCD, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 공통코드명 : commCdNm */
        listColumnDefs.add(new ColumnDef("공통코드명", Bass0300BM.ATTR_COMMCDNM, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 약어명 : abbrNm */
        listColumnDefs.add(new ColumnDef("약어명", Bass0300BM.ATTR_ABBRNM, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 영문명 : engNm */
        listColumnDefs.add(new ColumnDef("영문명", Bass0300BM.ATTR_ENGNM, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 관리항목01 : mangeItem01 */
        listColumnDefs.add(new ColumnDef("관리항목01", Bass0300BM.ATTR_MANGEITEM01, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 관리항목02 : mangeItem02 */
        listColumnDefs.add(new ColumnDef("관리항목02", Bass0300BM.ATTR_MANGEITEM02, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 관리항목03 : mangeItem03 */
        listColumnDefs.add(new ColumnDef("관리항목03", Bass0300BM.ATTR_MANGEITEM03, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 관리항목04 : mangeItem04 */
        listColumnDefs.add(new ColumnDef("관리항목04", Bass0300BM.ATTR_MANGEITEM04, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 관리항목05 : mangeItem05 */
        listColumnDefs.add(new ColumnDef("관리항목05", Bass0300BM.ATTR_MANGEITEM05, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 관리항목06 : mangeItem06 */
        listColumnDefs.add(new ColumnDef("관리항목06", Bass0300BM.ATTR_MANGEITEM06, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 관리항목07 : mangeItem07 */
        listColumnDefs.add(new ColumnDef("관리항목07", Bass0300BM.ATTR_MANGEITEM07, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 관리항목08 : mangeItem08 */
        listColumnDefs.add(new ColumnDef("관리항목08", Bass0300BM.ATTR_MANGEITEM08, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 관리항목09 : mangeItem09 */
        listColumnDefs.add(new ColumnDef("관리항목09", Bass0300BM.ATTR_MANGEITEM09, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 관리항목10 : mangeItem10 */
        listColumnDefs.add(new ColumnDef("관리항목10", Bass0300BM.ATTR_MANGEITEM10, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 관리항목11 : mangeItem11 */
        listColumnDefs.add(new ColumnDef("관리항목11", Bass0300BM.ATTR_MANGEITEM11, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 관리항목12 : mangeItem12 */
        listColumnDefs.add(new ColumnDef("관리항목12", Bass0300BM.ATTR_MANGEITEM12, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 관리항목13 : mangeItem13 */
        listColumnDefs.add(new ColumnDef("관리항목13", Bass0300BM.ATTR_MANGEITEM13, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 관리항목14 : mangeItem14 */
        listColumnDefs.add(new ColumnDef("관리항목14", Bass0300BM.ATTR_MANGEITEM14, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 관리항목15 : mangeItem15 */
        listColumnDefs.add(new ColumnDef("관리항목15", Bass0300BM.ATTR_MANGEITEM15, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 관리항목16 : mangeItem16 */
        listColumnDefs.add(new ColumnDef("관리항목16", Bass0300BM.ATTR_MANGEITEM16, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 관리항목17 : mangeItem17 */
        listColumnDefs.add(new ColumnDef("관리항목17", Bass0300BM.ATTR_MANGEITEM17, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 관리항목18 : mangeItem18 */
        listColumnDefs.add(new ColumnDef("관리항목18", Bass0300BM.ATTR_MANGEITEM18, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 관리항목19 : mangeItem19 */
        listColumnDefs.add(new ColumnDef("관리항목19", Bass0300BM.ATTR_MANGEITEM19, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 관리항목20 : mangeItem20 */
        listColumnDefs.add(new ColumnDef("관리항목20", Bass0300BM.ATTR_MANGEITEM20, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 코드TREE레벨 : cdTreeLvl */
        listColumnDefs.add(new ColumnDef("코드TREE레벨", Bass0300BM.ATTR_CDTREELVL, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 순서 : ord */
        listColumnDefs.add(new ColumnDef("순서", Bass0300BM.ATTR_ORD, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 오픈여부 : opnYn */
        listColumnDefs.add(new ColumnDef("오픈여부", Bass0300BM.ATTR_OPNYN, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 사용여부 : useYn */
        listColumnDefs.add(new ColumnDef("사용여부", Bass0300BM.ATTR_USEYN, ColumnDef.TYPE_STRING, 90, true, false, true));

        /** column 비고 : note */
        listColumnDefs.add(new ColumnDef("비고", Bass0300BM.ATTR_NOTE, ColumnDef.TYPE_STRING, 90, true, false, true)); 

        
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
