package org.msf.exterms.xls.service.impl;

import java.math.BigDecimal;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.app.exterms.insurance.server.vo.Insr3000VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.excel.EgovExcelMapping;
import egovframework.rte.fdl.excel.util.EgovExcelUtil;

public class xlsInsr5100Mapping  extends EgovExcelMapping {

//	ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes(); 
	//MSFUserInfo userInfo = MSFUserInfoManager.getUserInfo();
//	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(attr.getRequest());
        /**
         * edi연 엑셀파일 맵핑
         */
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

            Insr3000VO insr3000Vo = new Insr3000VO(); 
             
    	    	
            
 //           insr3000Vo.setDpobCd(" " );  /** column 사업장코드 : dpobCd */  
//            insr3000Vo.setDpobCd("20155350000001");	//김해
//            insr3000Vo.setDpobCd("20163900000001" );	//광명
//            insr3000Vo.setDpobCd("20155370000001" );	//거제 
            insr3000Vo.setDpobCd(sessionUser.getDpobCd());  
         //   insr3000Vo.setDpobCd("20153730000001" );
            
            
			//insr3000Vo.setDpobSCd(EgovExcelUtil.getValue(cell));    /** column 사업장코드 : dpobCd */
			//insr3000Vo.setSystemkey(EgovExcelUtil.getValue(cell));    /** column SYSTEMKEY : systemkey */
			//insr3000Vo.setNatPennSeilNum(new BigDecimal(EgovExcelUtil.getValue(cell0)));    /** column 일련번호 :   */
			insr3000Vo.setHanNm(EgovExcelUtil.getValue(cell1));    /** column 한글성명 : hanNm */
			insr3000Vo.setResnRegnNum(EgovExcelUtil.getValue(cell2));    /** column 주민등록번호 : resnRegnNum */
			insr3000Vo.setHlthInsrPayTotAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell3),"0")));   	/** column 건강보험보수총액 : hlthInsrPayTotAmnt */ 
			insr3000Vo.setHlthInsrGrde(EgovExcelUtil.getValue(cell4));   /** column 건강보험등급 : hlthInsrGrde */ 
			insr3000Vo.setHlthInsrMnthRuntnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell5),"0")));   /** column 보수월액 : hlthInsrMnthRuntnAmnt */  
			insr3000Vo.setHlthInsrCertNum(EgovExcelUtil.getValue(cell6));    /** column 건강보험증번호 : hlthInsrCertNum */  
			insr3000Vo.setHlthInsrAqtnDt(EgovExcelUtil.getValue(cell7));    /** column 건강보험취득일자 : hlthInsrAqtnDt */  
			insr3000Vo.setKybdr("Batch");    /** column 입력자 : kybdr */
			//insr3000Vo.setInptDt(EgovExcelUtil.getValue(cell));    /** column 입력일자 : inptDt */
			//insr3000Vo.setInptAddr(EgovExcelUtil.getValue(cell));    /** column 입력주소 : inptAddr */
			//insr3000Vo.setIsmt(EgovExcelUtil.getValue(cell));    /** column 수정자 : ismt */
			//insr3000Vo.setRevnDt(EgovExcelUtil.getValue(cell));    /** column 수정일자 : revnDt */
			//insr3000Vo.setRevnAddr(EgovExcelUtil.getValue(cell));    /** column 수정주소 : revnAddr */

            return insr3000Vo;
        }
}
