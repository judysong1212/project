package org.msf.exterms.xls.service.impl;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.infc.diligence.server.vo.InfcPkgDlgn0250VO;

import egovframework.rte.fdl.excel.EgovExcelMapping;
import egovframework.rte.fdl.excel.util.EgovExcelUtil;

public class xlsInsr320001Mapping  extends EgovExcelMapping {

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
            HSSFCell cell19 = row.getCell((int) 19);
            HSSFCell cell20 = row.getCell((int) 20);
            HSSFCell cell21 = row.getCell((int) 21);
            HSSFCell cell22 = row.getCell((int) 22);
            HSSFCell cell23 = row.getCell((int) 23);
            HSSFCell cell24 = row.getCell((int) 24);
            HSSFCell cell25 = row.getCell((int) 25);

            InfcPkgDlgn0250VO infclgn0250Vo = new InfcPkgDlgn0250VO(); 
            
//            infclgn0250Vo.setDpobCd(" " );  //userInfo.getUser().getDpobCd()
//            infclgn0250Vo.setDpobCd("20155350000001" );	//김해
//            infclgn0250Vo.setDpobCd("20163900000001" );	//광명
//            infclgn0250Vo.setDpobCd("20155370000001" );	//거제 
            infclgn0250Vo.setDpobCd(sessionUser.getDpobCd());  //userInfo.getUser().getDpobCd()
          //  infclgn0250Vo.setDpobCd("20153730000001" );
            
            infclgn0250Vo.setDilnlazYrMnth(EgovExcelUtil.getValue(cell1));    /** column 근태년월 : dilnlazYrMnth */
            infclgn0250Vo.setPayCd(EgovExcelUtil.getValue(cell2));    /** column 급여구분코드 : payCd */ 
            infclgn0250Vo.setHanNm(EgovExcelUtil.getValue(cell3));    /** 성명 */
            infclgn0250Vo.setResnRegnNum(EgovExcelUtil.getValue(cell4).replace("-", ""));    /** 주민등록번호 */
            
            infclgn0250Vo.setDilnlazDutyNumDys(EgovExcelUtil.getValue(cell5));    /** column 근태_근무일수 : dilnlazDutyNumDys */
            infclgn0250Vo.setDilnlazPaidHodyNumDys(EgovExcelUtil.getValue(cell6));    /** column 근태_유급휴가일수 : dilnlazPaidHodyNumDys */
            infclgn0250Vo.setDilnlazTotDutyNumDys(EgovExcelUtil.getValue(cell7));    /** column 근태_총근무일수 : dilnlazTotDutyNumDys */
            infclgn0250Vo.setDilnlazSpclHodyNumDys(EgovExcelUtil.getValue(cell8));    /** column 근태_특별휴가일수 : dilnlazSpclHodyNumDys */
            infclgn0250Vo.setDilnlazAbnceNumDys(EgovExcelUtil.getValue(cell9));    /** column 근태_결근일수 : dilnlazAbnceNumDys */
            infclgn0250Vo.setDilnlazAbnceDutyRcgtnDys(EgovExcelUtil.getValue(cell10));    /** column 근태_결근인정일수 : dilnlazAbnceDutyRcgtnDys */
            infclgn0250Vo.setDilnlazSckleaNumDys(EgovExcelUtil.getValue(cell11));    /** column 근태_병가일수 : dilnlazSckleaNumDys */
            infclgn0250Vo.setDilnlazOffvaNumDys(EgovExcelUtil.getValue(cell12));    /** column 근태_공가일수 : dilnlazOffvaNumDys */
            infclgn0250Vo.setDilnlazFmlyEvntNumDys(EgovExcelUtil.getValue(cell13));    /** column 근태_경조사일수 : dilnlazFmlyEvntNumDys */
            infclgn0250Vo.setDilnlazHlthCreNumDys(EgovExcelUtil.getValue(cell14));    /** column 근태_보건일수 : dilnlazHlthCreNumDys */
            /** 잔여월차 */
            infclgn0250Vo.setDilnlazPubcHodyDutyNumDys(EgovExcelUtil.getValue(cell16));    /** column 총휴일근무일수 : dilnlazPubcHodyDutyNumDys */
            infclgn0250Vo.setDilnlazSatDutyNumDys(EgovExcelUtil.getValue(cell17));    /** column 총토요근무일수 : dilnlazSatDutyNumDys */
            infclgn0250Vo.setDilnlazWklyHldyNumDys(EgovExcelUtil.getValue(cell18));    /** column 근태_주휴일수 : dilnlazWklyHldyNumDys */
            infclgn0250Vo.setDilnlazPaidPubcHodyNum(EgovExcelUtil.getValue(cell19));    /** column 근태_유급휴일수 : dilnlazPaidPubcHodyNum */
            /** 잔여연가 */
            infclgn0250Vo.setDilnlazLvsgNumDys(EgovExcelUtil.getValue(cell20));    /** column 근태_연가일수 : dilnlazLvsgNumDys */
            infclgn0250Vo.setDilnlazTfcAssCstNumDys(EgovExcelUtil.getValue(cell21));    /** column 근태_교통보조비일수 : dilnlazTfcAssCstNumDys */
            infclgn0250Vo.setDilnlazFndtnTmRstDutyTm(EgovExcelUtil.getValue(cell22));    /** column 근태_기본시간외근무시간 : dilnlazFndtnTmRstDutyTm */
            infclgn0250Vo.setDilnlazTmRstDutyTm(EgovExcelUtil.getValue(cell23));    /** column 근태_시간외근무시간 : dilnlazTmRstDutyTm */
            infclgn0250Vo.setDilnlazTotTmRstDutyTm(EgovExcelUtil.getValue(cell24));    /** column 근태_총시간외근무시간 : dilnlazTotTmRstDutyTm */ 
            infclgn0250Vo.setDilnlazTotNtotTm(EgovExcelUtil.getValue(cell25));    /** column 근태_총야근시간 : dilnlazTotNtotTm */
             
            infclgn0250Vo.setDilnlazExceDutyYrMnth(EgovExcelUtil.getValue(cell1));    /** column 근태초과근무년월 : dilnlazExceDutyYrMnth */  
            infclgn0250Vo.setDilnlazTotDutyTm("0");    /** column 근태_총근무시간 : dilnlazTotDutyTm */ 
            infclgn0250Vo.setDilnlazDdlnePrcsYn("N");    /** column 근태_마감처리여부 : dilnlazDdlnePrcsYn */
            infclgn0250Vo.setDilnlazNoteCtnt("");    /** column 근태_비고내용 : dilnlazNoteCtnt */   
          
        
//            infclgn0250Vo.setDilnlazExceDutyBgnnDt(EgovExcelUtil.getValue(cell2));    /** column 근태_초과근무시작일자 : dilnlazExceDutyBgnnDt */
//            infclgn0250Vo.setDilnlazExceDutyEndDt(EgovExcelUtil.getValue(cell2));    /** column 근태_초과근무종료일자 : dilnlazExceDutyEndDt */ 
            infclgn0250Vo.setDilnlazTotNtotNumDys("0");    /** column 근태_총야근일수 : dilnlazTotNtotNumDys */
         
        
//            infclgn0250Vo.setKybdr(EgovExcelUtil.getValue(cell2));    /** column 입력자 : kybdr */
//            infclgn0250Vo.setInptDt(EgovExcelUtil.getValue(cell2));    /** column 입력일자 : inptDt */
//            infclgn0250Vo.setInptAddr(EgovExcelUtil.getValue(cell2));    /** column 입력주소 : inptAddr */
//            infclgn0250Vo.setIsmt(EgovExcelUtil.getValue(cell2));    /** column 수정자 : ismt */
//            infclgn0250Vo.setRevnDt(EgovExcelUtil.getValue(cell2));    /** column 수정일자 : revnDt */
//            infclgn0250Vo.setRevnAddr(EgovExcelUtil.getValue(cell2));    /** column 수정주소 : revnAddr */
            
        
//            vo.setSn             (Integer.parseInt(EgovExcelUtil.getValue(cell1)));  
//            if (cell5 != null) {vo.setLiBuldNm   (EgovExcelUtil.getValue(cell5));}
//            if (cell6 != null) {vo.setLnbrDongHo (EgovExcelUtil.getValue(cell6));}
            
            
            return infclgn0250Vo;
        }
}
