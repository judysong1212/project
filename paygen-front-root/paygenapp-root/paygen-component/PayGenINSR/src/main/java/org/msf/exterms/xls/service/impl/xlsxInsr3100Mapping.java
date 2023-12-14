package org.msf.exterms.xls.service.impl;

import java.math.BigDecimal;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.app.exterms.insurance.server.vo.Insr4300VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.excel.EgovExcelXSSFMapping;
import egovframework.rte.fdl.excel.util.EgovExcelUtil;

public class xlsxInsr3100Mapping  extends EgovExcelXSSFMapping {

//	ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes(); 
	//MSFUserInfo userInfo = MSFUserInfoManager.getUserInfo();
//	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(attr.getRequest());
        /**
         * 우편번호 엑셀파일 맵핑
         */
        @SuppressWarnings("deprecation")
        @Override
        public Object mappingColumn(XSSFRow row) {
        	
        	 ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();  
        	 MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(attr.getRequest());
        	 
            XSSFCell cell0 = row.getCell((int) 0);
            XSSFCell cell1 = row.getCell((int) 1);
            XSSFCell cell2 = row.getCell((int) 2);
            XSSFCell cell3 = row.getCell((int) 3);
            XSSFCell cell4 = row.getCell((int) 4);
            XSSFCell cell5 = row.getCell((int) 5);
            XSSFCell cell6 = row.getCell((int) 6);
            XSSFCell cell7 = row.getCell((int) 7);
            XSSFCell cell8 = row.getCell((int) 8);
            XSSFCell cell9 = row.getCell((int) 9);
            XSSFCell cell10 = row.getCell((int) 10);
            XSSFCell cell11 = row.getCell((int) 11);
            XSSFCell cell12 = row.getCell((int) 12);
           

            Insr4300VO insr4300Vo = new Insr4300VO(); 
            
 //           insr4300Vo.setDpobCd(" " );  /** column 사업장코드 : dpobCd */ 
 //          insr4300Vo.setDpobCd("20155350000001" );	//김해
//            insr4300Vo.setDpobCd("20163900000001" );	//광명
//            insr4300Vo.setDpobCd("20155370000001" );	//거제 
            insr4300Vo.setDpobCd(sessionUser.getDpobCd());  
          //  insr4300Vo.setDpobCd("20153730000001" );
            
            
			//insr4300Vo.setDpobCd(EgovExcelUtil.getValue(cell));    /** column 사업장코드 : dpobCd */
			//insr4300Vo.setSystemkey(EgovExcelUtil.getValue(cell));    /** column SYSTEMKEY : systemkey */
			//insr4300Vo.setNatPennSeilNum(new BigDecimal(EgovExcelUtil.getValue(cell0)));    /** column 국민연금일련번호 : natPennSeilNum */
			insr4300Vo.setAntyDeinYr(EgovExcelUtil.getValue(cell1));    /** column 연금결정년도 : antyDeinYr */
			insr4300Vo.setHanNm(EgovExcelUtil.getValue(cell2));    /** column 한글성명 : hanNm */
			insr4300Vo.setResnRegnNum(EgovExcelUtil.getValue(cell3));    /** column 주민등록번호 : resnRegnNum */
			insr4300Vo.setNatPennGrde(EgovExcelUtil.getValue(cell4));    /** set 연금보험등급 : hlthInsrGrde */
			insr4300Vo.setAntyTotDutyNumDys(new BigDecimal(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell5),"0")));    /** column 연금총근무일수 : antyTotDutyNumDys */
			insr4300Vo.setAntyIncmTotAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell6),"0")));    /** column 연금소득총액 : antyIncmTotAmnt */
			insr4300Vo.setAntyStdIncmMnthAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell7),"0")));    /** column 연금기준소득월액 : antyStdIncmMnthAmnt */
			insr4300Vo.setNatPennStdIncmMnthAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell7),"0")));    /** column 연금기준소득월액 : antyStdIncmMnthAmnt */
			insr4300Vo.setAntyMnthPrmm(new BigDecimal(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell8),"0")));    /** column 연금월보험료 : antyMnthPrmm */
			insr4300Vo.setBfrStdIncmMnthAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell9),"0")));    /** column 종전기준소득월액 : bfrStdIncmMnthAmnt */
			insr4300Vo.setTxtnDataDeinYn(EgovExcelUtil.getValue(cell10));    /** column 과세자료결정여부 : txtnDataDeinYn */
			insr4300Vo.setPbcorpOautyDeinYn(EgovExcelUtil.getValue(cell11));    /** column 공단직권결정여부 : pbcorpOautyDeinYn */
			insr4300Vo.setAntyPayRflctnYn("Y");    /** column 연금급여반영여부 : antyPayRflctnYn */
			insr4300Vo.setNatPennAqtnDt(EgovExcelUtil.getValue(cell12));    /** column 취득일자 : natPennAqtnDt */
			insr4300Vo.setKybdr("Batch");    /** column 입력자 : kybdr */
			//insr4300Vo.setInptDt(EgovExcelUtil.getValue(cell));    /** column 입력일자 : inptDt */
			//insr4300Vo.setInptAddr(EgovExcelUtil.getValue(cell));    /** column 입력주소 : inptAddr */
			//insr4300Vo.setIsmt(EgovExcelUtil.getValue(cell));    /** column 수정자 : ismt */
			//insr4300Vo.setRevnDt(EgovExcelUtil.getValue(cell));    /** column 수정일자 : revnDt */
			//insr4300Vo.setRevnAddr(EgovExcelUtil.getValue(cell));    /** column 수정주소 : revnAddr */

            return insr4300Vo;
        }
}
