package org.msf.exterms.xls.service.impl;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.gwtrpcspring.RemoteServiceUtil;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.app.exterms.diligence.server.vo.Dlgn0250VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.excel.EgovExcelMapping;
import egovframework.rte.fdl.excel.util.EgovExcelUtil;

public class xlsDlgn0250Mapping  extends EgovExcelMapping {
 
        @SuppressWarnings("deprecation")
        @Override
        public Object mappingColumn(HSSFRow row) {
        	
        	 ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();  
        	 MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(attr.getRequest());
        	 
        	 
        	 // 1. 암호화 객체 생성
        	 String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        	 
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

            Dlgn0250VO dlgn0250Vo = new Dlgn0250VO(); 
             
         
          //  dlgn0250Vo.setDpobCd(" " );  //용인 userInfo.getUser().getDpobCd()
 //          dlgn0250Vo.setDpobCd("20155350000001" );	//김해
//            dlgn0250Vo.setDpobCd("20163900000001" );	//광명
//           dlgn0250Vo.setDpobCd("20155370000001" );	//거제 
           dlgn0250Vo.setDpobCd(sessionUser.getDpobCd());  
        //    dlgn0250Vo.setDpobCd("20153730000001" );  //
            
            
            dlgn0250Vo.setDilnlazYrMnth(EgovExcelUtil.getValue(cell1));    /** column 근태년월 : dilnlazYrMnth */
            dlgn0250Vo.setPayCd(EgovExcelUtil.getValue(cell2));    /** column 급여구분코드 : payCd */ 
            dlgn0250Vo.setHanNm(EgovExcelUtil.getValue(cell3));    /** 성명 */
//            dlgn0250Vo.setResnRegnNum(EgovExcelUtil.getValue(cell4).replace("-", ""));    /** 주민등록번호 */
            

			// 암호화
            dlgn0250Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(EgovExcelUtil.getValue(cell4).replace("-", "")),AnyCryptUtils.SEC_RRNUMC));
            
            dlgn0250Vo.setDilnlazDutyNumDys(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell5),"0"));    /** column 근태_근무일수 : dilnlazDutyNumDys */
            dlgn0250Vo.setDilnlazPaidHodyNumDys(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell6),"0"));    /** column 근태_유급휴가일수 : dilnlazPaidHodyNumDys */
            dlgn0250Vo.setDilnlazTotDutyNumDys(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell7),"0"));    /** column 근태_총근무일수 : dilnlazTotDutyNumDys */
            dlgn0250Vo.setDilnlazSpclHodyNumDys(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell8),"0"));    /** column 근태_특별휴가일수 : dilnlazSpclHodyNumDys */
            dlgn0250Vo.setDilnlazAbnceNumDys(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell9),"0"));    /** column 근태_결근일수 : dilnlazAbnceNumDys */
            dlgn0250Vo.setDilnlazAbnceDutyRcgtnDys(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell10),"0"));    /** column 근태_결근인정일수 : dilnlazAbnceDutyRcgtnDys */
            dlgn0250Vo.setDilnlazSckleaNumDys(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell11),"0"));    /** column 근태_병가일수 : dilnlazSckleaNumDys */
            dlgn0250Vo.setDilnlazOffvaNumDys(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell12),"0"));    /** column 근태_공가일수 : dilnlazOffvaNumDys */
            dlgn0250Vo.setDilnlazFmlyEvntNumDys(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell13),"0"));    /** column 근태_경조사일수 : dilnlazFmlyEvntNumDys */
            dlgn0250Vo.setDilnlazHlthCreNumDys(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell14),"0"));    /** column 근태_보건일수 : dilnlazHlthCreNumDys */
            /** 잔여월차 */
            dlgn0250Vo.setDilnlazPubcHodyDutyNumDys(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell16),"0"));    /** column 총휴일근무일수 : dilnlazPubcHodyDutyNumDys */
            dlgn0250Vo.setDilnlazSatDutyNumDys(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell17),"0"));    /** column 총토요근무일수 : dilnlazSatDutyNumDys */
            dlgn0250Vo.setDilnlazWklyHldyNumDys(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell18),"0"));    /** column 근태_주휴일수 : dilnlazWklyHldyNumDys */
            dlgn0250Vo.setDilnlazPaidPubcHodyNum(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell19),"0"));    /** column 근태_유급휴일수 : dilnlazPaidPubcHodyNum */
            /** 잔여연가 */
            dlgn0250Vo.setDilnlazLvsgNumDys(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell20),"0"));    /** column 근태_연가일수 : dilnlazLvsgNumDys */
            dlgn0250Vo.setDilnlazTfcAssCstNumDys(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell21),"0"));    /** column 근태_교통보조비일수 : dilnlazTfcAssCstNumDys */
            dlgn0250Vo.setDilnlazFndtnTmRstDutyTm(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell22),"0"));    /** column 근태_기본시간외근무시간 : dilnlazFndtnTmRstDutyTm */
            dlgn0250Vo.setDilnlazTmRstDutyTm(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell23),"0"));    /** column 근태_시간외근무시간 : dilnlazTmRstDutyTm */
            dlgn0250Vo.setDilnlazTotTmRstDutyTm(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell24),"0"));    /** column 근태_총시간외근무시간 : dilnlazTotTmRstDutyTm */ 
            dlgn0250Vo.setDilnlazTotNtotTm(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell25),"0"));    /** column 근태_총야근시간 : dilnlazTotNtotTm */
             
            dlgn0250Vo.setDilnlazExceDutyYrMnth(MSFSharedUtils.defaultNulls(EgovExcelUtil.getValue(cell1),"0"));    /** column 근태초과근무년월 : dilnlazExceDutyYrMnth */  
            dlgn0250Vo.setDilnlazTotDutyTm("0");    /** column 근태_총근무시간 : dilnlazTotDutyTm */ 
            dlgn0250Vo.setDilnlazDdlnePrcsYn("N");    /** column 근태_마감처리여부 : dilnlazDdlnePrcsYn */
            dlgn0250Vo.setDilnlazNoteCtnt("");    /** column 근태_비고내용 : dilnlazNoteCtnt */   
          
        
//            dlgn0250Vo.setDilnlazExceDutyBgnnDt(EgovExcelUtil.getValue(cell2));    /** column 근태_초과근무시작일자 : dilnlazExceDutyBgnnDt */
//            dlgn0250Vo.setDilnlazExceDutyEndDt(EgovExcelUtil.getValue(cell2));    /** column 근태_초과근무종료일자 : dilnlazExceDutyEndDt */ 
            dlgn0250Vo.setDilnlazTotNtotNumDys("0");    /** column 근태_총야근일수 : dilnlazTotNtotNumDys */
         
        
//            dlgn0250Vo.setKybdr(EgovExcelUtil.getValue(cell2));    /** column 입력자 : kybdr */
//            dlgn0250Vo.setInptDt(EgovExcelUtil.getValue(cell2));    /** column 입력일자 : inptDt */
//            dlgn0250Vo.setInptAddr(EgovExcelUtil.getValue(cell2));    /** column 입력주소 : inptAddr */
//            dlgn0250Vo.setIsmt(EgovExcelUtil.getValue(cell2));    /** column 수정자 : ismt */
//            dlgn0250Vo.setRevnDt(EgovExcelUtil.getValue(cell2));    /** column 수정일자 : revnDt */
//            dlgn0250Vo.setRevnAddr(EgovExcelUtil.getValue(cell2));    /** column 수정주소 : revnAddr */
            
        
//            vo.setSn             (Integer.parseInt(EgovExcelUtil.getValue(cell1)));  
//            if (cell5 != null) {vo.setLiBuldNm   (EgovExcelUtil.getValue(cell5));}
//            if (cell6 != null) {vo.setLnbrDongHo (EgovExcelUtil.getValue(cell6));}
            
            
            return dlgn0250Vo;
        }
}
