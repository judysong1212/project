package com.app.smrmf.sysauth.systemmtr.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.sysauth.systemmtr.client.dto.SysMtrCmmn0310BM;
import com.app.smrmf.sysauth.systemmtr.shared.SysmMtrDaoConstants;
import com.app.smrmf.sysauth.systemusr.client.languages.SysmUsrConstants;

public class SysMtrCmmn0310Def extends TableDef implements SysmMtrDaoConstants {
    private int row = 0;
    
    private SysmUsrConstants lblSysmConst = SysmUsrConstants.INSTANCE;
    
    public SysMtrCmmn0310Def(){
    	
    	  setTitle(lblSysmConst.title_Cmmn0310());
          setDaoClass(CLASS_CMMN0310_LIST); 
          setCustomListMethod(CLASS_CMMN0310_LIST);
          
    	  setColumnsDefinition(getAllColumnsList());
          isAutoFillGrid = false;
    	  setAutoFillGrid(false);
          showFilterToolbar = false ; 
          
    }
       
    private List<ColumnDef> getAllColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
         
        /** column 우편번호 : zpcd */
    	listColumnDefs.add(new ColumnDef("우편번호", SysMtrCmmn0310BM.ATTR_ZPCD, ColumnDef.TYPE_STRING, 90, true, false, true){
    		{

    		}
    	});
    	/** column 우편번호일련번호 : zpcdSeilNum */
    	listColumnDefs.add(new ColumnDef("우편번호일련번호", SysMtrCmmn0310BM.ATTR_ZPCDSEILNUM, ColumnDef.TYPE_STRING, 90, true, false, true){
    		{

    		}
    	});
    	/** column 시도 : ctapv */
    	listColumnDefs.add(new ColumnDef("시도", SysMtrCmmn0310BM.ATTR_CTAPV, ColumnDef.TYPE_STRING, 90, true, false, true){
    		{

    		}
    	});
    	/** column 시군구 : ctatgu */
    	listColumnDefs.add(new ColumnDef("시군구", SysMtrCmmn0310BM.ATTR_CTATGU, ColumnDef.TYPE_STRING, 90, true, false, true){
    		{

    		}
    	});
    	/** column 읍면동 : tatd */
    	listColumnDefs.add(new ColumnDef("읍면동", SysMtrCmmn0310BM.ATTR_TATD, ColumnDef.TYPE_STRING, 90, true, false, true){
    		{

    		}
    	});
    	/** column 리 : li */
    	listColumnDefs.add(new ColumnDef("리", SysMtrCmmn0310BM.ATTR_LI, ColumnDef.TYPE_STRING, 90, true, false, true){
    		{

    		}
    	});
    	/** column 도서 : bok */
    	listColumnDefs.add(new ColumnDef("도서", SysMtrCmmn0310BM.ATTR_BOK, ColumnDef.TYPE_STRING, 90, true, false, true){
    		{

    		}
    	});
    	/** column 산번지 : sanHusnum */
    	listColumnDefs.add(new ColumnDef("산번지", SysMtrCmmn0310BM.ATTR_SANHUSNUM, ColumnDef.TYPE_STRING, 90, true, false, true){
    		{

    		}
    	});
    	/** column 시작번지_주 : bgnnMn */
    	listColumnDefs.add(new ColumnDef("시작번지_주", SysMtrCmmn0310BM.ATTR_BGNNMN, ColumnDef.TYPE_STRING, 90, true, false, true){
    		{

    		}
    	});
    	/** column 시작번주_부 : bgnnHusnumSb */
    	listColumnDefs.add(new ColumnDef("시작번주_부", SysMtrCmmn0310BM.ATTR_BGNNHUSNUMSB, ColumnDef.TYPE_STRING, 90, true, false, true){
    		{

    		}
    	});
    	/** column 끝번지_주 : endHusnumMn */
    	listColumnDefs.add(new ColumnDef("끝번지_주", SysMtrCmmn0310BM.ATTR_ENDHUSNUMMN, ColumnDef.TYPE_STRING, 90, true, false, true){
    		{

    		}
    	});
    	/** column 끝번지_부 : endHusnumSb */
    	listColumnDefs.add(new ColumnDef("끝번지_부", SysMtrCmmn0310BM.ATTR_ENDHUSNUMSB, ColumnDef.TYPE_STRING, 90, true, false, true){
    		{

    		}
    	});
    	/** column 건물명 : buildNm */
    	listColumnDefs.add(new ColumnDef("건물명", SysMtrCmmn0310BM.ATTR_BUILDNM, ColumnDef.TYPE_STRING, 90, true, false, true){
    		{

    		}
    	});
    	/** column 건물시작동 : buildBgnnDong */
    	listColumnDefs.add(new ColumnDef("건물시작동", SysMtrCmmn0310BM.ATTR_BUILDBGNNDONG, ColumnDef.TYPE_STRING, 90, true, false, true){
    		{

    		}
    	});
    	/** column 건물끝동 : buildEndDong */
    	listColumnDefs.add(new ColumnDef("건물끝동", SysMtrCmmn0310BM.ATTR_BUILDENDDONG, ColumnDef.TYPE_STRING, 90, true, false, true){
    		{

    		}
    	});
    	/** column 전체주소 : whleAddr */
    	listColumnDefs.add(new ColumnDef("전체주소", SysMtrCmmn0310BM.ATTR_WHLEADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
    		{

    		}
    	});
    	/** column 비고 : note */
    	listColumnDefs.add(new ColumnDef("비고", SysMtrCmmn0310BM.ATTR_NOTE, ColumnDef.TYPE_STRING, 90, true, false, true){
    		{

    		}
    	});
    	/** column 입력자 : kybdr */
    	listColumnDefs.add(new ColumnDef("입력자", SysMtrCmmn0310BM.ATTR_KYBDR, ColumnDef.TYPE_STRING, 90, true, false, true){
    		{

    		}
    	});
    	/** column 입력일자 : inptDt */
    	listColumnDefs.add(new ColumnDef("입력일자", SysMtrCmmn0310BM.ATTR_INPTDT, ColumnDef.TYPE_STRING, 90, true, false, true){
    		{

    		}
    	});
    	/** column 입력주소 : inptAddr */
    	listColumnDefs.add(new ColumnDef("입력주소", SysMtrCmmn0310BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
    		{

    		}
    	});
    	/** column 수정자 : ismt */
    	listColumnDefs.add(new ColumnDef("수정자", SysMtrCmmn0310BM.ATTR_ISMT, ColumnDef.TYPE_STRING, 90, true, false, true){
    		{

    		}
    	});
    	/** column 수정일자 : revnDt */
    	listColumnDefs.add(new ColumnDef("수정일자", SysMtrCmmn0310BM.ATTR_REVNDT, ColumnDef.TYPE_STRING, 90, true, false, true){
    		{

    		}
    	});
    	/** column 수정자주소 : revnAddr */
    	listColumnDefs.add(new ColumnDef("수정자주소", SysMtrCmmn0310BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
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
