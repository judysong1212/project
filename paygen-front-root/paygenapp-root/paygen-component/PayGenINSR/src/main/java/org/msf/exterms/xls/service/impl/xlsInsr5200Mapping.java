package org.msf.exterms.xls.service.impl;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.app.exterms.insurance.server.vo.Insr5200VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.excel.EgovExcelMapping;
import egovframework.rte.fdl.excel.util.EgovExcelUtil;

public class xlsInsr5200Mapping  extends EgovExcelMapping {

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
            HSSFCell cell8 = row.getCell((int) 8); 
            HSSFCell cell9 = row.getCell((int) 9); 
            HSSFCell cell10 = row.getCell((int) 10); 
            HSSFCell cell11 = row.getCell((int) 11); 
            HSSFCell cell12 = row.getCell((int) 12); 
            HSSFCell cell13 = row.getCell((int) 13); 
            HSSFCell cell14 = row.getCell((int) 14); 
            HSSFCell cell15 = row.getCell((int) 15); 
            HSSFCell cell16 = row.getCell((int) 16); 
            HSSFCell cell17 = row.getCell((int) 17); 
            HSSFCell cell18 = row.getCell((int) 18); 
             

            Insr5200VO insr5200Vo = new Insr5200VO(); 

            insr5200Vo.setDpobCd(sessionUser.getDpobCd());  
            insr5200Vo.setHanNm(EgovExcelUtil.getValue(cell1));     /** column 한글성명 : hanNm */
            insr5200Vo.setResnRegnNum(EgovExcelUtil.getValue(cell2));     /** column 주민등록번호 : resnRegnNum */
            insr5200Vo.setUmytInsrBgnnDt(EgovExcelUtil.getValue(cell3));     /** column 고용시작일자 : umytInsrBgnnDt */
            insr5200Vo.setUmytInsrEndDt(EgovExcelUtil.getValue(cell4));     /** column 고용종료일자 : umytInsrEndDt */
            insr5200Vo.setMnthAvgPayMnthAmnt(new Long(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell5),"0")));     /** column 월평균보수월액 : mnthAvgPayMnthAmnt */
            insr5200Vo.setCmpttnWkppUneplrtSum(new Long(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell6),"0")));     /** column 산정_근로자실업급여보험금액 : cmpttnWkppUneplrtSum */
            insr5200Vo.setCmpttnEplrUneplrtSum(new Long(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell7),"0")));     /** column 산정_사업주실업급여보험금액 : cmpttnEplrUneplrtSum */
            insr5200Vo.setCmpttnEplrFncdsnInsurSum(new Long(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell8),"0")));     /** column 산정_사업주고안직능보험금액 : cmpttnEplrFncdsnInsurSum */
            insr5200Vo.setRecpttnWkppUneplrtSum(new Long(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell9),"0")));     /** column 재산정_근로자실업급여보험금액 : recpttnWkppUneplrtSum */
            insr5200Vo.setRecpttnEplrUneplrtSum(new Long(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell10),"0")));     /** column 재산정_사업주실럽급여보험금액 : recpttnEplrUneplrtSum */
            insr5200Vo.setRecpttnEplrFncdsnSum(new Long(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell11),"0")));     /** column 재산정_사업주고안직능보험금액 : recpttnEplrFncdsnSum */
            insr5200Vo.setClutPayTotAmnt(new Long(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell12),"0")));     /** column 정산보수총액 : clutPayTotAmnt */
            insr5200Vo.setClutWkppUneplrtSum(new Long(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell13),"0")));     /** column 정산_근로자실업급여보험금액 : clutWkppUneplrtSum */
            insr5200Vo.setClutEplrUneplrtSum(new Long(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell14),"0")));     /** column 정산_사업주실업급여보험금액 : clutEplrUneplrtSum */
            insr5200Vo.setClutEplrFncdsnSum(new Long(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell15),"0")));     /** column 정산_사업주실업고안직능보험금액 : clutEplrFncdsnSum */
            insr5200Vo.setIndvUneplrtPymtAggrSum(new Long(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell16),"0")));     /** column 개인실업급여납부보헙합계금액 : indvUneplrtPymtAggrSum */
            insr5200Vo.setEplrUneplrtPymtAggrSum(new Long(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell17),"0")));     /** column 사업주실업급여보험합계금액 : eplrUneplrtPymtAggrSum */
            insr5200Vo.setEplrFncdsnAggrSum(new Long(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell18),"0")));     /** column 사업주고안직능보험합계금액 : eplrFncdsnAggrSum */
            
            
//            insr5200Vo.setSystemkey(EgovExcelUtil.getValue(cell));     /** column SYSTEMKEY : systemkey */
//            insr5200Vo.setDducYrMnth(EgovExcelUtil.getValue(cell));     /** column 납부년월 : dducYrMnth */
//            insr5200Vo.setEmymtSeilNum(EgovExcelUtil.getValue(cell));     /** column 고용일련번호 : emymtSeilNum */
//            insr5200Vo.setIposYrMnth(EgovExcelUtil.getValue(cell));     /** column 부과년월 : iposYrMnth */
//            
//
//
//            insr5200Vo.setUmytInsrApmrt(EgovExcelUtil.getValue(cell));     /** column 고용보험요율 : umytInsrApmrt */
//            insr5200Vo.setPayCalcEmymtInsurSum(EgovExcelUtil.getValue(cell));     /** column 급여산출고용보험금액 : payCalcEmymtInsurSum */
//
//            insr5200Vo.setUmytPayrDducYrMnth(EgovExcelUtil.getValue(cell));     /** column 고용보험급여공제년월 : umytPayrDducYrMnth */
//            insr5200Vo.setUmytInsrPrcsDt(EgovExcelUtil.getValue(cell));     /** column 고용보험처리일자 : umytInsrPrcsDt */
//            insr5200Vo.setUmytInsrPrcsYn(EgovExcelUtil.getValue(cell));     /** column 고용보험처리여부 : umytInsrPrcsYn */
//            insr5200Vo.setUmytInsrPrmmSrd(EgovExcelUtil.getValue(cell));     /** column 개인실업급여고용보험차액 : umytInsrPrmmSrd */
//            insr5200Vo.setDivdPymtDivCd(EgovExcelUtil.getValue(cell));     /** column 분할납부구분코드 : divdPymtDivCd */
//            insr5200Vo.setDivdPymt(EgovExcelUtil.getValue(cell));     /** column 분할납부횟수 : divdPymt */
//            insr5200Vo.setKybdr(EgovExcelUtil.getValue(cell));     /** column 입력자 : kybdr */
//            insr5200Vo.setInptDt(EgovExcelUtil.getValue(cell));     /** column 입력일자 : inptDt */
//            insr5200Vo.setInptAddr(EgovExcelUtil.getValue(cell));     /** column 입력주소 : inptAddr */
//            insr5200Vo.setIsmt(EgovExcelUtil.getValue(cell));     /** column 수정자 : ismt */
//            insr5200Vo.setRevnDt(EgovExcelUtil.getValue(cell));     /** column 수정일자 : revnDt */
//            insr5200Vo.setRevnAddr(EgovExcelUtil.getValue(cell));     /** column 수정주소 : revnAddr */

            return insr5200Vo;
        }
}
