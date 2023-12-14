package com.app.smrmf.sysauth.systemusr.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.constants.Constants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.utils.RegEx;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.infc.sysif.msfpackage.client.form.SysIfP0990;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0300BM;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0300DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0400BM;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0400DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfSysm0100BM;
import com.app.smrmf.infc.sysif.msfpackage.client.lookup.LookupSysIfBass0300;
import com.app.smrmf.infc.sysif.msfpackage.client.lookup.LookupSysIfBass0400;
import com.app.smrmf.sysauth.systemusr.client.dto.SysmUsr0100BM;
import com.app.smrmf.sysauth.systemusr.client.languages.SysmUsrConstants;
import com.app.smrmf.sysauth.systemusr.shared.SysmUsrDaoConstants;

public class SysUsrSysm0100Def extends TableDef implements SysmUsrDaoConstants {
    private int row = 0;
    
    private SysmUsrConstants lblSysmConst = SysmUsrConstants.INSTANCE;
      
    private SysIfBass0300DTO sysIfBass0300Dto ;
    private SysIfBass0400DTO sysIfBass0400Dto;
    
    public SysUsrSysm0100Def(String chkMenu){
    	 
    	if ("SYSM0500".equals(chkMenu)) {
    		  sysIfBass0300Dto = new SysIfBass0300DTO();
          	  sysIfBass0400Dto = new SysIfBass0400DTO();
          	   
              addColumnFilter("usrDivCd", "D0010070,D0010080", SimpleColumnFilter.OPERATOR_IN); 
	          addColumnFilter("searchKeyword", "N", SimpleColumnFilter.OPERATOR_EQUALS); 
	            
          	  setTitle(lblSysmConst.title_Sysm0100());
              setDaoClass(""); 
              setCustomListMethod(CLASS_SYSM0100_LIST);  
        	  setAutoFillGrid(false);   
          	  setShowFilterToolbar(false);
        	  setColumnsDefinition(getSysm0500DefList()); 
        	
        	  
    	} else if ("SYSM0700".equals(chkMenu)) {
          		  
                setTitle(lblSysmConst.title_Sysm0100());
                setDaoClass(""); 
                setCustomListMethod(CLASS_SYSMUSR0700TOSYSM0100_LIST);  
              	setAutoFillGrid(true);   
                setShowFilterToolbar(false);
              	setColumnsDefinition(getSysm0700DefList()); 
              	 
          
    	} else if ("SYSM0100".equals(chkMenu)) {	// 사용자검색
    		  
    	    sysIfBass0300Dto = new SysIfBass0300DTO();
            sysIfBass0400Dto = new SysIfBass0400DTO();
        	
            setTitle("사용자정보");
            setAutoFillGrid(false);
//            setDaoClass("");
//            setCustomListMethod(CLASS_SYSM0700TOSYSM0100_LIST);  
            setShowFilterToolbar(false);
          	setColumnsDefinition(getSysm0100DefList()); 
          	 
      
    	} else if("SYSMUSR0100".equals(chkMenu)) {
    		
			sysIfBass0300Dto = new SysIfBass0300DTO();
			sysIfBass0400Dto = new SysIfBass0400DTO();

			setTitle(lblSysmConst.title_Sysm0100());

			addColumnFilter("usrDivCd", MSFConfiguration.AUTH_USR_DIV_10,SimpleColumnFilter.OPERATOR_EQUALS);

//			setDaoClass(CLASS_SYSM0100_CUD);
			setCustomListMethod(CLASS_SYSMUSR0100_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);

			setColumnsDefinition(getSysmUsr0100ColumnsList());
    		
    	} else {
			sysIfBass0300Dto = new SysIfBass0300DTO();
			sysIfBass0400Dto = new SysIfBass0400DTO();

			setTitle(lblSysmConst.title_Sysm0100());

			addColumnFilter("usrDivCd", MSFConfiguration.AUTH_USR_DIV_10,SimpleColumnFilter.OPERATOR_EQUALS);

			setDaoClass(CLASS_SYSM0100_CUD);
			setCustomListMethod(CLASS_SYSM0100_LIST);
			setAutoFillGrid(true);
			setShowFilterToolbar(false);

			setColumnsDefinition(getAllColumnsList());
    	 
		}
	}
    
    private List<ColumnDef> getSysm0100DefList() {
    	
        row = 0;
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        
        /** column 부서코드 : deptCd */
    	listColumnDefs.add(new ColumnListDef("부서", SysIfSysm0100BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, false, true, false,new LookupSysIfBass0400(sysIfBass0400Dto),SysIfBass0400BM.ATTR_DEPTCD,SysIfBass0400BM.ATTR_DEPTNMRTCHNT){
    		{

    		}
    	});
    	
    	sysIfBass0300Dto.setRpsttvCd("D001");
    	/** column 사용자구분코드 : usrDivCd */
    	listColumnDefs.add(new ColumnListDef("사용자구분", SysIfSysm0100BM.ATTR_USRDIVCD, ColumnDef.TYPE_STRING , 90, true, true, true,new LookupSysIfBass0300(sysIfBass0300Dto),SysIfBass0300BM.ATTR_COMMCD,SysIfBass0300BM.ATTR_COMMCDNM){
    		{

    		}
    	}); 
    	/** column 사용자성명 : usrNm */
    	listColumnDefs.add(new ColumnDef("성명", SysIfSysm0100BM.ATTR_USRNM, ColumnDef.TYPE_STRING , 90, false, true, false){
    		{
    			 
    		}
    	});
    	/** column 사용자아이디 : usrId */
    	listColumnDefs.add(new ColumnDef("아이디", SysIfSysm0100BM.ATTR_USRID, ColumnDef.TYPE_STRING , 90, false, true, false){
    		{
    			 
    		}
    	});
    	
    	/** column 내선번호 : usrTel */
    	listColumnDefs.add(new ColumnDef("내선번호", SysIfSysm0100BM.ATTR_USRTEL, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{

    		}
    	});
        
    	return listColumnDefs;
        
    	
    }
    

    private List<ColumnDef> getAllColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 


    	/** column 시스템구분코드 : sysDivCd */
    	listColumnDefs.add(new ColumnDef("시스템구분코드", SysIfSysm0100BM.ATTR_SYSDIVCD, ColumnDef.TYPE_STRING , 90, false, false, false){
    		{

    		}
    	});
    	sysIfBass0400Dto.setDeptDspyYn("Y");
    	/** column 부서코드 : deptCd */
    	listColumnDefs.add(new ColumnListDef("부서", SysIfSysm0100BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, true, true,new LookupSysIfBass0400(sysIfBass0400Dto),SysIfBass0400BM.ATTR_DEPTCD,SysIfBass0400BM.ATTR_DEPTNMRTCHNT){
    		{

    		}
    	}); 
//    	  /** column 직종코드 : typOccuCd */
//        listColumnDefs.add(new ColumnListDef("직종", SysIfSysm0100BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, false, true, true,new LookupSysIfBass0350TypOccuCd(),SysIfBass0350BM.ATTR_TYPOCCUCD,SysIfBass0350BM.ATTR_TYPOCCUNM){
//            {
//
//            }
//        });
//        /** column 직종 : typOccuNm */
//        listColumnDefs.add(new ColumnDef("직종", SysIfSysm0100BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 90, false, false, false){
//            {
//
//            }
//        });
//        /** column 호봉등급코드 : pyspGrdeCd */
//        listColumnDefs.add(new ColumnDef("호봉등급코드", SysIfSysm0100BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, false, false, false){
//            {
//
//            }
//        });
//        
//        /** column 호봉등급 : pyspGrdeNm */
//        listColumnDefs.add(new ColumnDef("호봉등급", SysIfSysm0100BM.ATTR_PYSPGRDENM, ColumnDef.TYPE_STRING, 90, false, false, false){
//            {
//
//            }
//        }); 
    	/** column 사용자성명 : usrNm */
    	listColumnDefs.add(new ColumnDef("성명", SysIfSysm0100BM.ATTR_USRNM, ColumnDef.TYPE_STRING , 90, true, true, true){
    		{
    			 if (Constants.SSO_USE_TYPE.equals(MSFMainApp.getMsg("PayGen.SsoUseType"))) { 
    				setLov(new SysIfP0990(600, 500));
    			 }
    			setTypeTextField(ColumnDef.TEXTFIELD);
    		}
    	});
    	/** column 사용자아이디 : usrId */
    	listColumnDefs.add(new ColumnDef("아이디", SysIfSysm0100BM.ATTR_USRID, ColumnDef.TYPE_STRING , 90, true, true, true){
    		{
    			setTypeTextField(ColumnDef.TEXTFIELD);
    		}
    	});
    	/** column 패스워드 : pwd */
    	listColumnDefs.add(new ColumnDef("패스워드", SysIfSysm0100BM.ATTR_PWD, ColumnDef.TYPE_STRING , 90, true, true, true){
    		{
    			setTypeTextField(ColumnDef.TEXTFIELD);  
    			setPassword(true);
    		}
    	});
    	/** column 패스워드 : tmpPwd */
    	listColumnDefs.add(new ColumnDef("패스워드", SysIfSysm0100BM.ATTR_TMPPWD, ColumnDef.TYPE_STRING , 90, true, false, false){
    		{
    			setTypeTextField(ColumnDef.TEXTFIELD);
    		 
    		}
    	});
    	 sysIfBass0300Dto.setRpsttvCd("D001"); 
    	/** column 사용자구분코드 : usrDivCd */
    	listColumnDefs.add(new ColumnListDef("사용자구분", SysIfSysm0100BM.ATTR_USRDIVCD, ColumnDef.TYPE_STRING , 90, true, true, true,  new LookupSysIfBass0300(sysIfBass0300Dto),SysIfBass0300BM.ATTR_COMMCD,SysIfBass0300BM.ATTR_COMMCDNM){
    		{

    		}
    	});
    	/** column SYSTEMKEY : systemkey */
    	listColumnDefs.add(new ColumnDef("SYSTEMKEY", SysIfSysm0100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, false, false, false){
    		{
    		     setTypeTextField(ColumnDef.TEXTFIELD);
    			
    		}
    	});
    	
    	/** column 전화번호 : usrTel */
    	listColumnDefs.add(new ColumnDef("내선번호", SysIfSysm0100BM.ATTR_USRTEL, ColumnDef.TYPE_STRING , 90, false, true, true){
    		{
    			setTypeTextField(ColumnDef.TEXTFIELD);
    		}
    	});
    	/** column 이메일 : email */
    	listColumnDefs.add(new ColumnDef("이메일", SysIfSysm0100BM.ATTR_EMAIL, ColumnDef.TYPE_STRING , 90, false, true, true){
    		{
    			setTypeTextField(ColumnDef.TEXTFIELD);
    			setRegEx(RegEx.EMAIL);
    		}
    	});
    	
    	/** column 계정잠금여부 : lockat hieju_추가_06.15 */
    	listColumnDefs.add(new ColumnDef("계정잠금", SysIfSysm0100BM.ATTR_LOCKAT, ColumnDef.TYPE_BOOLEAN , 90, false, true, true){
    		{
    			
    		}
    	});
    	
    	/** column 사용자사용여부 : useYn */
    	listColumnDefs.add(new ColumnDef("사용", SysIfSysm0100BM.ATTR_USEYN, ColumnDef.TYPE_BOOLEAN , 90, false, true, true){
    		{
    			setIsFakeAttribute(true);
    		}
    	});
//    	/** column 입력자 : kybdr */
//    	listColumnDefs.add(new ColumnDef("입력자", SysIfSysm0100BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//    		{
//
//    		}
//    	});
//    	/** column 입력일자 : inptDt */
//    	listColumnDefs.add(new ColumnDef("입력일자", SysIfSysm0100BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//    		{
//
//    		}
//    	});
//    	/** column 입력주소 : inptAddr */
//    	listColumnDefs.add(new ColumnDef("입력주소", SysIfSysm0100BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//    		{
//
//    		}
//    	});
//    	/** column 수정자 : ismt */
//    	listColumnDefs.add(new ColumnDef("수정자", SysIfSysm0100BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
//    		{
//
//    		}
//    	});
//    	/** column 수정일자 : revnDt */
//    	listColumnDefs.add(new ColumnDef("수정일자", SysIfSysm0100BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//    		{
//
//    		}
//    	});
//    	/** column 수정주소 : revnAddr */
//    	listColumnDefs.add(new ColumnDef("수정주소", SysIfSysm0100BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//    		{
//
//    		}
//    	});


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
    private List<ColumnDef> getSysm0500DefList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 


    	/** column 시스템구분코드 : sysDivCd */
    	listColumnDefs.add(new ColumnDef("시스템구분코드", SysIfSysm0100BM.ATTR_SYSDIVCD, ColumnDef.TYPE_STRING , 90, false, false, false){
    		{

    		}
    	});
    	/** column 부서코드 : deptCd */
    	listColumnDefs.add(new ColumnListDef("부서", SysIfSysm0100BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 130, true, true, true,new LookupSysIfBass0400(sysIfBass0400Dto),SysIfBass0400BM.ATTR_DEPTCD,SysIfBass0400BM.ATTR_DEPTNMRTCHNT){
    		{

    		}
    	}); 
     
     	/** column 사용자아이디 : usrId */
    	listColumnDefs.add(new ColumnDef("아이디", SysIfSysm0100BM.ATTR_USRID, ColumnDef.TYPE_STRING , 70, true, true, false){
    		{
    			setTypeTextField(ColumnDef.TEXTFIELD);
    		}
    	});
    	/** column 사용자성명 : usrNm */
    	listColumnDefs.add(new ColumnDef("성명", SysIfSysm0100BM.ATTR_USRNM, ColumnDef.TYPE_STRING , 70, true, true, true){
    		{
    			setTypeTextField(ColumnDef.TEXTFIELD);
    		}
    	});
    	
	   	 sysIfBass0300Dto.setRpsttvCd("D001"); 
	  	/** column 사용자구분코드 : usrDivCd */
	  	listColumnDefs.add(new ColumnListDef("사용자구분", SysIfSysm0100BM.ATTR_USRDIVCD, ColumnDef.TYPE_STRING , 100, true, true, false,  new LookupSysIfBass0300(sysIfBass0300Dto),SysIfBass0300BM.ATTR_COMMCD,SysIfBass0300BM.ATTR_COMMCDNM){
	  		{
	
	  		}
	  	});
	  	
//	      /** column 직종코드 : typOccuCd */
//        listColumnDefs.add(new ColumnListDef("직종", SysIfSysm0100BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 100, true, true, true,new LookupSysIfBass0350TypOccuCd(),SysIfBass0350BM.ATTR_TYPOCCUCD,SysIfBass0350BM.ATTR_TYPOCCUNM){
//            {
//
//            }
//        });
//        /** column 직종 : typOccuNm */
//        listColumnDefs.add(new ColumnDef("직종", SysIfSysm0100BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 90, false, false, false){
//            {
//
//            }
//        });
//        /** column 호봉등급코드 : pyspGrdeCd */
//        listColumnDefs.add(new ColumnDef("호봉등급코드", SysIfSysm0100BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, false, false, false){
//            {
//
//            }
//        });
//        
//        /** column 호봉등급 : pyspGrdeNm */
//        listColumnDefs.add(new ColumnDef("호봉등급", SysIfSysm0100BM.ATTR_PYSPGRDENM, ColumnDef.TYPE_STRING, 90, false, false, true){
//            {
//
//            }
//        }); 
    	
    	/** column 패스워드 : pwd */
    	listColumnDefs.add(new ColumnDef("패스워드", SysIfSysm0100BM.ATTR_PWD, ColumnDef.TYPE_STRING , 90, false, false, false){
    		{
    			setTypeTextField(ColumnDef.TEXTFIELD);
    			setPassword(true);
    		}
    	});
    	
    	/** column SYSTEMKEY : systemkey */
    	listColumnDefs.add(new ColumnDef("SYSTEMKEY", SysIfSysm0100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, false, false, false){
    		{
    			setTypeTextField(ColumnDef.TEXTFIELD);
    		}
    	});
    	
    	/** column 전화번호 : usrTel */
    	listColumnDefs.add(new ColumnDef("내선번호", SysIfSysm0100BM.ATTR_USRTEL, ColumnDef.TYPE_STRING , 90, false, false, false){
    		{
    			setTypeTextField(ColumnDef.TEXTFIELD);
    		}
    	});
    	/** column 이메일 : email */
    	listColumnDefs.add(new ColumnDef("이메일", SysIfSysm0100BM.ATTR_EMAIL, ColumnDef.TYPE_STRING , 90, false, false, false){
    		{
    			setTypeTextField(ColumnDef.TEXTFIELD);
    			setRegEx(RegEx.EMAIL);
    		}
    	});
    	
    	/** column 계정잠금여부 : lockat hieju_추가 */
    	listColumnDefs.add(new ColumnDef("계정잠금", SysIfSysm0100BM.ATTR_LOCKAT, ColumnDef.TYPE_BOOLEAN , 50, false, true, false){
    		{
    			
    		}
    	});
    	
    	/** column 사용자사용여부 : useYn */
    	listColumnDefs.add(new ColumnDef("사용", SysIfSysm0100BM.ATTR_USEYN, ColumnDef.TYPE_BOOLEAN , 50, false, true, false){
    		{

    		}
    	});
 
        return listColumnDefs;
        
      
    }
    
    private List<ColumnDef> getSysm0700DefList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 


    	/** column 시스템구분코드 : sysDivCd */
    	listColumnDefs.add(new ColumnDef("시스템구분코드", SysIfSysm0100BM.ATTR_SYSDIVCD, ColumnDef.TYPE_STRING , 90, false, false, false){
    		{

    		}
    	});
    	/** column 부서코드 : deptCd */
    	listColumnDefs.add(new ColumnDef("부서", SysIfSysm0100BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 130, true, false, true){
    		{

    		}
    	}); 
    	
    	/** column 부서코드 : deptNm */
    	listColumnDefs.add(new ColumnDef("부서", SysIfSysm0100BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 130, true, true, true ){
    		{

    		}
    	}); 
     
     	/** column 사용자아이디 : usrId */
    	listColumnDefs.add(new ColumnDef("아이디", SysIfSysm0100BM.ATTR_USRID, ColumnDef.TYPE_STRING , 70, true, true, false){
    		{
    			setTypeTextField(ColumnDef.TEXTFIELD);
    		}
    	});
    	/** column 사용자성명 : usrNm */
    	listColumnDefs.add(new ColumnDef("성명", SysIfSysm0100BM.ATTR_USRNM, ColumnDef.TYPE_STRING , 70, true, true, true){
    		{
    			setTypeTextField(ColumnDef.TEXTFIELD);
    		}
    	});
    	
	   
	  	/** column 사용자구분코드 : usrDivCd */
	  	listColumnDefs.add(new ColumnDef("사용자구분코드", SysIfSysm0100BM.ATTR_USRDIVCD, ColumnDef.TYPE_STRING , 100, true, false, false){
	  		{
	
	  		}
	  	});
	  	
		/** column 사용자구분코드 : usrDivCd */
	  	listColumnDefs.add(new ColumnDef("사용자구분", SysIfSysm0100BM.ATTR_USRDIVNM, ColumnDef.TYPE_STRING , 100, true, true, false){
	  		{
	
	  		}
	  	});
	  	
//	      /** column 직종코드 : typOccuCd */
//        listColumnDefs.add(new ColumnListDef("직종", SysIfSysm0100BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 100, true, true, true,new LookupSysIfBass0350TypOccuCd(),SysIfBass0350BM.ATTR_TYPOCCUCD,SysIfBass0350BM.ATTR_TYPOCCUNM){
//            {
//
//            }
//        });
//        /** column 직종 : typOccuNm */
//        listColumnDefs.add(new ColumnDef("직종", SysIfSysm0100BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 90, false, false, false){
//            {
//
//            }
//        });
//        /** column 호봉등급코드 : pyspGrdeCd */
//        listColumnDefs.add(new ColumnDef("호봉등급코드", SysIfSysm0100BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, false, false, false){
//            {
//
//            }
//        });
//        
//        /** column 호봉등급 : pyspGrdeNm */
//        listColumnDefs.add(new ColumnDef("호봉등급", SysIfSysm0100BM.ATTR_PYSPGRDENM, ColumnDef.TYPE_STRING, 90, false, false, true){
//            {
//
//            }
//        }); 
    	
    	/** column 패스워드 : pwd */
    	listColumnDefs.add(new ColumnDef("패스워드", SysIfSysm0100BM.ATTR_PWD, ColumnDef.TYPE_STRING , 90, false, false, false){
    		{
    			setTypeTextField(ColumnDef.TEXTFIELD);
    			setPassword(true);
    		}
    	});
    	
    	/** column SYSTEMKEY : systemkey */
    	listColumnDefs.add(new ColumnDef("SYSTEMKEY", SysIfSysm0100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, false, false, false){
    		{
    			setTypeTextField(ColumnDef.TEXTFIELD);
    		}
    	});
    	
    	/** column 전화번호 : usrTel */
    	listColumnDefs.add(new ColumnDef("내선번호", SysIfSysm0100BM.ATTR_USRTEL, ColumnDef.TYPE_STRING , 90, false, false, false){
    		{
    			setTypeTextField(ColumnDef.TEXTFIELD);
    		}
    	});
    	/** column 이메일 : email */
    	listColumnDefs.add(new ColumnDef("이메일", SysIfSysm0100BM.ATTR_EMAIL, ColumnDef.TYPE_STRING , 90, false, false, false){
    		{
    			setTypeTextField(ColumnDef.TEXTFIELD);
    			setRegEx(RegEx.EMAIL);
    		}
    	});
    	
    	/** column 계정잠금여부 : lockat hieju_추가 */
    	listColumnDefs.add(new ColumnDef("계정잠금", SysIfSysm0100BM.ATTR_LOCKAT, ColumnDef.TYPE_BOOLEAN , 50, false, true, false){
    		{
    			
    		}
    	});
    	
    	/** column 사용자사용여부 : useYn */
    	listColumnDefs.add(new ColumnDef("사용", SysIfSysm0100BM.ATTR_USEYN, ColumnDef.TYPE_BOOLEAN , 50, false, true, false){
    		{

    		}
    	});
 
        return listColumnDefs;
        
      
    }
    
    
    
    
    
    
    
    
    
    private List<ColumnDef> getSysmUsr0100ColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 


    	/** column 시스템구분코드 : sysDivCd */
    	listColumnDefs.add(new ColumnDef("시스템구분코드", SysmUsr0100BM.ATTR_SYSDIVCD, ColumnDef.TYPE_STRING , 90, false, false, false){
    		{

    		}
    	});
    	sysIfBass0400Dto.setDeptDspyYn("Y");
    	/** column 부서코드 : deptCd */
    	listColumnDefs.add(new ColumnListDef("부서", SysmUsr0100BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 120, true, true, true,new LookupSysIfBass0400(sysIfBass0400Dto),SysIfBass0400BM.ATTR_DEPTCD,SysIfBass0400BM.ATTR_DEPTNMRTCHNT){
    		{

    		}
    	}); 
    	/** column 사용자성명 : usrNm */
    	listColumnDefs.add(new ColumnDef("성명", SysmUsr0100BM.ATTR_USRNM, ColumnDef.TYPE_STRING , 100, true, true, true){
    		{
//    			 if (Constants.SSO_USE_TYPE.equals(MSFMainApp.getMsg("PayGen.SsoUseType"))) { 
//    				setLov(new SysIfP0990(600, 500));
//    			 }
//    			setTypeTextField(ColumnDef.TEXTFIELD);
    		}
    	});
    	/** column 사용자아이디 : usrId */
    	listColumnDefs.add(new ColumnDef("아이디", SysmUsr0100BM.ATTR_USRID, ColumnDef.TYPE_STRING , 100, true, true, true){
    		{
    			setTypeTextField(ColumnDef.TEXTFIELD);
    		}
    	});
    	/** column 패스워드 : pwd *//*
    	listColumnDefs.add(new ColumnDef("패스워드", SysmUsr0100BM.ATTR_PWD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			setTypeTextField(ColumnDef.TEXTFIELD);  
    			setPassword(true);
    		}
    	});
    	*//** column 패스워드 : tmpPwd *//*
    	listColumnDefs.add(new ColumnDef("패스워드", SysmUsr0100BM.ATTR_TMPPWD, ColumnDef.TYPE_STRING , 90, true, false, false){
    		{
    			setTypeTextField(ColumnDef.TEXTFIELD);
    		 
    		}
    	});*/
    	 sysIfBass0300Dto.setRpsttvCd("D001"); 
    	/** column 사용자구분코드 : usrDivCd */
    	listColumnDefs.add(new ColumnListDef("사용자구분", SysmUsr0100BM.ATTR_USRDIVCD, ColumnDef.TYPE_STRING , 100, true, true, true,  new LookupSysIfBass0300(sysIfBass0300Dto),SysIfBass0300BM.ATTR_COMMCD,SysIfBass0300BM.ATTR_COMMCDNM){
    		{

    		}
    	});
    	/** column SYSTEMKEY : systemkey */
    	listColumnDefs.add(new ColumnDef("SYSTEMKEY", SysmUsr0100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, false, false, false){
    		{
    		     setTypeTextField(ColumnDef.TEXTFIELD);
    			
    		}
    	});
    	
    	/** column 전화번호 : usrTel */
    	listColumnDefs.add(new ColumnDef("내선번호", SysmUsr0100BM.ATTR_USRTEL, ColumnDef.TYPE_STRING , 90, false, false, true){
    		{
    			setTypeTextField(ColumnDef.TEXTFIELD);
    		}
    	});
    	/** column 이메일 : email */
    	listColumnDefs.add(new ColumnDef("이메일", SysmUsr0100BM.ATTR_EMAIL, ColumnDef.TYPE_STRING , 90, false, false, true){
    		{
    			setTypeTextField(ColumnDef.TEXTFIELD);
    			setRegEx(RegEx.EMAIL);
    		}
    	});
    	
    	/** column 계정잠금여부 : lockat hieju_추가 */
    	listColumnDefs.add(new ColumnDef("계정잠금", SysmUsr0100BM.ATTR_LOCKAT, ColumnDef.TYPE_BOOLEAN , 50, false, true, true){
    		{
    			
    		}
    	});
    	
    	/** column 사용자사용여부 : useYn */
    	listColumnDefs.add(new ColumnDef("사용", SysmUsr0100BM.ATTR_USEYN, ColumnDef.TYPE_BOOLEAN , 50, false, true, true){
    		{
    			setIsFakeAttribute(true);
    		}
    	});
    	
    	
//    	listColumnDefs.add(new ColumnDef("주민번호앞자리", SysmUsr0100BM.ATTR_YOOBHMNTHDAY, ColumnDef.TYPE_STRING , 50, false, false, false){
//    		{
//    			setIsFakeAttribute(true);
//    		}
//    	});
    	
    	
    	listColumnDefs.add(new ColumnDef("사용자권한제외여부", SysmUsr0100BM.ATTR_USRAUTHEEPNYN, ColumnDef.TYPE_BOOLEAN , 50, false, false, false){
			{
				
			}
    	});
    	
    	listColumnDefs.add(new ColumnDef("호봉제포함여부", SysmUsr0100BM.ATTR_PYSPINSNYN, ColumnDef.TYPE_BOOLEAN , 50, false, false, false){
			{
				
			}
    	});
    	
    	listColumnDefs.add(new ColumnDef("비호봉제포함여부", SysmUsr0100BM.ATTR_NOTPYSPINSNYN, ColumnDef.TYPE_BOOLEAN , 50, false, false, false){
			{
				
			}
    	});
    	
    	listColumnDefs.add(new ColumnDef("복무입력처리여부", SysmUsr0100BM.ATTR_SERVCINPTPRCSYN, ColumnDef.TYPE_BOOLEAN , 50, false, false, false){
			{
				
			}
    	});
    	
    	listColumnDefs.add(new ColumnDef("연말정산입력처리여부", SysmUsr0100BM.ATTR_YRTXINPTPRCSYN, ColumnDef.TYPE_BOOLEAN , 50, false, false, false){
			{
				
			}
    	});
    	
    	listColumnDefs.add(new ColumnDef("기간제포함여부", SysmUsr0100BM.ATTR_SHTTMINSNYN, ColumnDef.TYPE_BOOLEAN , 50, false, false, false){
			{
				
			}
    	});
    	
    	listColumnDefs.add(new ColumnDef("사용자권한구분코드", SysmUsr0100BM.ATTR_USRAUTHDIVCD, ColumnDef.TYPE_STRING , 50, false, false, false){
			{
				
			}
    	});
    	
        return listColumnDefs;
    }
    
    
    
    
    
    
}
