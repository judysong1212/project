package org.msf.exterms.xls.service.impl;


import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.app.exterms.personal.server.vo.Psnl0126VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.excel.EgovExcelMapping;
import egovframework.rte.fdl.excel.util.EgovExcelUtil;

public class xlsPsnl0290Mapping  extends EgovExcelMapping {
	
	
//	private static final Logger LOGGER = Logger.getLogger(xlsPsnl0290Mapping.class);

//	MSFUserInfo userInfo = MSFUserInfoManager.getUserInfo();
	
	
	/**휴가일수 엑셀파일 맵핑 */
 	@SuppressWarnings("deprecation")
	@Override
	public Object mappingColumn(HSSFRow row) {
 		
 		 ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();  
    	 MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(attr.getRequest());
    	 
 		HSSFCell cell0 = row.getCell((int) 0);
     	HSSFCell cell1 = row.getCell((int) 1);
    	HSSFCell cell2 = row.getCell((int) 2);
        HSSFCell cell3 = row.getCell((int) 3);
        HSSFCell cell4 = row.getCell((int) 4);
        HSSFCell cell5 = row.getCell((int) 5);
        HSSFCell cell6 = row.getCell((int) 6);
        HSSFCell cell7 = row.getCell((int) 7);
        HSSFCell cell8 = row.getCell((int) 8);
        HSSFCell cell9 = row.getCell((int) 9);
        HSSFCell cell10 = row.getCell((int) 10);
        HSSFCell cell11 = row.getCell((int) 11);
        HSSFCell cell12 = row.getCell((int) 12);
        HSSFCell cell13 = row.getCell((int) 13);
        HSSFCell cell14 = row.getCell((int) 14);
        
        Psnl0126VO Psnl0126Vo = new Psnl0126VO(); 
        
        int monthS = 1;
		int monthE = 12;
		int maxDays = 0;
		   
		

        Psnl0126Vo = new Psnl0126VO();
        
        if(EgovExcelUtil.getValue(cell5).replace("-", "") == null || EgovExcelUtil.getValue(cell5).replace("-", "").equals("")) {
        	return Psnl0126Vo;
        }else {
          
        	
        	Psnl0126Vo.setDpobCd(sessionUser.getDpobCd());  
 //       Psnl0126Vo.setDpobCd(" ");  //userInfo.getUser().getDpobCd()
 //     Psnl0126Vo.setDpobCd("20155350000001" );	//김해
//       	Psnl0126Vo.setDpobCd("20155370000001" );	//거제 
     //	Psnl0126Vo.setDpobCd("20153730000001" );	//울주
     	
     	
     	
        Psnl0126Vo.setHodyApptnYr(EgovExcelUtil.getValue(cell1));	/** 휴가적용년도 HODY_APPTN_YR */
        
        //=========휴가 시작일자 계산하여 mapping========
        
        Calendar  intiCal =  Calendar.getInstance();
        
        
        if(Psnl0126Vo.getHodyApptnYr() == null || Psnl0126Vo.getHodyApptnYr().equals("")) {
        	Psnl0126Vo.setHodyBgnnDt("");	/** 휴가시작일자 HODY_BGNN_DT */
        	Psnl0126Vo.setHodyEndDt("");	/** 휴가종료일자 HODY_BGNN_DT */
        }else {
        	SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        	
        	intiCal.set(Integer.parseInt(Psnl0126Vo.getHodyApptnYr()), monthS -1, 1);
    		Psnl0126Vo.setHodyBgnnDt(format.format(intiCal.getTime()));	/** 휴가시작일자 HODY_BGNN_DT */
    		
    		maxDays = intiCal.getActualMaximum (intiCal.DAY_OF_MONTH); 
    	       
    		Calendar  intieCal =   Calendar.getInstance();
    	    intieCal.set(Integer.parseInt(Psnl0126Vo.getHodyApptnYr()), monthE - 1, maxDays); 
    	    Psnl0126Vo.setHodyEndDt(format.format(intiCal.getTime()));	/** 휴가종료일자 HODY_BGNN_DT */
    	  //=========휴가 시작일자 계산하여 mapping========	
        }
       
	    
	    
        Psnl0126Vo.setHanNm(EgovExcelUtil.getValue(cell2));    		/** 부서코드 : deptCd */
        Psnl0126Vo.setTypOccuCd(EgovExcelUtil.getValue(cell3));     /** 직종코드 : typOccuCd */
        Psnl0126Vo.setHanNm(EgovExcelUtil.getValue(cell4));    		/** 한글성명 : hanNm */
        Psnl0126Vo.setResnRegnNum(EgovExcelUtil.getValue(cell5).replace("-", ""));	/** 주민등록번호 */ 
        Psnl0126Vo.setLogSvcYrNumCd(EgovExcelUtil.getValue(cell6)); /** 근속년수코드 : logSvcYrNumCd */ 
            
        Psnl0126Vo.setLvsgCoptnCstApptnYn(EgovExcelUtil.getValue(cell7));/** 연가보상비적용여부 LVSG_COPTN_CST_APPTN_YN */ 
        Psnl0126Vo.setHodyNumDysSysCalc(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell8),"0"));/** 휴가일수_시스템 계산 HODY_NUM_DYS_SYS_CALC */
        Psnl0126Vo.setHodyApptnNumDys(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell9),"0")); 	/** 휴가적용일수 HODY_APPTN_NUM_DYS */
        Psnl0126Vo.setHodyUseNumDys(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell10),"0"));	/** 휴가사용일수 HODY_USE_NUM_DYS */
        Psnl0126Vo.setHodyRstNumDys(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell11),"0"));	/** 휴가잔여일수 HODY_RST_NUM_DYS */
        Psnl0126Vo.setHodyNoteCtnt(MSFSharedUtils.allowNulls(EgovExcelUtil.getValue(cell12)));   		/** 휴가비고내용 HODY_NOTE_CTNT */
        Psnl0126Vo.setHodyFixYn("N");								/** 휴가확정여부 HODY_FIX_YN */
        Psnl0126Vo.setBusinCd(MSFSharedUtils.allowNulls(EgovExcelUtil.getValue(cell14)));    			/** 사업코드 : businCd */
        

//        System.out.println("============================맵핑 작업 결과=================================");
//        System.out.println("엑셀 업로드 Psnl0126vo is {}" + Psnl0126Vo.getHodyApptnYr());			/** 휴가적용년도 HODY_APPTN_YR */
//        System.out.println("엑셀 업로드 Psnl0126vo is {}" + Psnl0126Vo.getHanNm());    			/** 부서코드 : deptCd */
//        System.out.println("엑셀 업로드 Psnl0126vo is {}" + Psnl0126Vo.getTypOccuCd());     		/** 직종코드 : typOccuCd */
//        System.out.println("엑셀 업로드 Psnl0126vo is {}" + Psnl0126Vo.getHanNm());    			/** 한글성명 : hanNm */
//        System.out.println("엑셀 업로드 Psnl0126vo is {}" + Psnl0126Vo.getResnRegnNum());			/** 주민등록번호 */ 
//        System.out.println("엑셀 업로드 Psnl0126vo is {}" + Psnl0126Vo.getLogSvcYrNumCd()); 		/** 근속년수코드 : logSvcYrNumCd */ 
//        System.out.println("엑셀 업로드 Psnl0126vo is {}" + Psnl0126Vo.getLvsgCoptnCstApptnYn());	/** 연가보상비적용여부 LVSG_COPTN_CST_APPTN_YN */ 
//        System.out.println("엑셀 업로드 Psnl0126vo is {}" + Psnl0126Vo.getHodyNumDysSysCalc());	/** 휴가일수_시스템 계산 HODY_NUM_DYS_SYS_CALC */
//        System.out.println("엑셀 업로드 Psnl0126vo is {}" + Psnl0126Vo.getHodyApptnNumDys()); 		/** 휴가적용일수 HODY_APPTN_NUM_DYS */
//        System.out.println("엑셀 업로드 Psnl0126vo is {}" + Psnl0126Vo.getHodyUseNumDys());		/** 휴가사용일수 HODY_USE_NUM_DYS */
//        System.out.println("엑셀 업로드 Psnl0126vo is {}" + Psnl0126Vo.getHodyRstNumDys());		/** 휴가잔여일수 HODY_RST_NUM_DYS */
//        System.out.println("엑셀 업로드 Psnl0126vo is {}" + Psnl0126Vo.getHodyNoteCtnt());    		/** 휴가비고내용 HODY_NOTE_CTNT */
//        System.out.println("엑셀 업로드 Psnl0126vo is {}" + Psnl0126Vo.getHodyFixYn());			/** 휴가확정여부 HODY_FIX_YN */
//        System.out.println("엑셀 업로드 Psnl0126vo is {}" + Psnl0126Vo.getBusinCd());    			/** 사업코드 : businCd */
//        System.out.println("============================맵핑 작업 결과=================================");
        
        	return Psnl0126Vo;
        	}
        }
}
