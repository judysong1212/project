package com.app.smrmf.sysauth.system.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfSysm0500BM;
import com.app.smrmf.sysauth.system.client.languages.SysmConstants;
import com.app.smrmf.sysauth.system.shared.SysmDaoConstants;

public class Sysm0500Def extends TableDef implements SysmDaoConstants {
    private int row = 0;
    
    private SysmConstants lblSysmConst = SysmConstants.INSTANCE;
    
    public Sysm0500Def(){
    	
    	  setTitle(lblSysmConst.title_Sysm0500());
          setDaoClass(CLASS_SYSM0500_LIST); 
          setCustomListMethod(CLASS_SYSM0500_LIST);
          
    	  setColumnsDefinition(getAllColumnsList());
          isAutoFillGrid = false;
    	  setAutoFillGrid(false);
          showFilterToolbar = false ; 
          
    }
       
    private List<ColumnDef> getAllColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
         
        /** column 시스템구분코드 : sysDivCd */
    	listColumnDefs.add(new ColumnDef("시스템구분코드", SysIfSysm0500BM.ATTR_SYSDIVCD, ColumnDef.TYPE_STRING, 90, true, false, true){
    		{

    		}
    	});
    	/** column 권한그룹일련번호 : authGrpSeilNum */
    	listColumnDefs.add(new ColumnDef("권한그룹일련번호", SysIfSysm0500BM.ATTR_AUTHGRPSEILNUM, ColumnDef.TYPE_STRING, 90, true, false, true){
    		{

    		}
    	});
    	/** column 사용자아이디 : usrId */
    	listColumnDefs.add(new ColumnDef("사용자아이디", SysIfSysm0500BM.ATTR_USRID, ColumnDef.TYPE_STRING, 90, true, false, true){
    		{

    		}
    	});
    	/** column 사용자권한사용여부 : usrAuthUseYn */
    	listColumnDefs.add(new ColumnDef("사용자권한사용여부", SysIfSysm0500BM.ATTR_USRAUTHUSEYN, ColumnDef.TYPE_STRING, 90, true, false, true){
    		{

    		}
    	});
    	/** column 입력자 : kybdr */
    	listColumnDefs.add(new ColumnDef("입력자", SysIfSysm0500BM.ATTR_KYBDR, ColumnDef.TYPE_STRING, 90, true, false, true){
    		{

    		}
    	});
    	/** column 입력일자 : inptDt */
    	listColumnDefs.add(new ColumnDef("입력일자", SysIfSysm0500BM.ATTR_INPTDT, ColumnDef.TYPE_STRING, 90, true, false, true){
    		{

    		}
    	});
    	/** column 수정자 : ismt */
    	listColumnDefs.add(new ColumnDef("수정자", SysIfSysm0500BM.ATTR_ISMT, ColumnDef.TYPE_STRING, 90, true, false, true){
    		{

    		}
    	});
    	/** column 수정일자 : revnDt */
    	listColumnDefs.add(new ColumnDef("수정일자", SysIfSysm0500BM.ATTR_REVNDT, ColumnDef.TYPE_STRING, 90, true, false, true){
    		{

    		}
    	});
    	/** column 수정주소 : revnAddr */
    	listColumnDefs.add(new ColumnDef("수정주소", SysIfSysm0500BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
    		{

    		}
    	});
    	/** column 입력주소 : inptAddr */
    	listColumnDefs.add(new ColumnDef("입력주소", SysIfSysm0500BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
    		{

    		}
    	});

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
