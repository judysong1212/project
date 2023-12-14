package org.msf.exterms.xls.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class Insr1100AqtnExcelView extends AbstractExcelView {

    /**
     * 엑셀파일을 설정하고 생성한다.
     * @param model
     * @param wb
     * @param request
     * @param response
     * @throws Exception
     */
    @Override
    protected void buildExcelDocument(Map<String, Object> model,
            HSSFWorkbook wb, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        HSSFCell cell = null;
         
        HSSFSheet sheet = wb.createSheet("사대보험EDI연계");
        sheet.setDefaultColumnWidth((short) 20);
  	 	 			 	 
        // put text in first cell
        cell = getCell(sheet, 0, 0);
        setText(cell, "주의사항 : 이 파일을 파일송신함에서 가져오기 메뉴로 등록 할 때 주의사항줄과 아래 필드명 삭제 후 (줄을 전체 삭제) 신고 내용만 저장하여 신고 해 주시기 바랍니다.");
        
//                =========== 작성시 주의 사항 ===================           
//                1. 1,2번째 행은 타이틀로써 아래 예제문을 따르십시요.            
//                2. 3번째 행부터 입력될 데이터를 작성합니다.          
//                3. '실근무일'에는 근무일수+유급휴가에서 결근일수 제외한 일수를 입력합니다.         
//                4. 시간외수당 '총시간'은 기본시간과 시간외시간의 합을 입력합니다.          
//                5. '작성시 주의사항'은 반드시 삭제후 파일을 업로드 하십시오.    
        // set header information
        
        					
        setText(getCell(sheet, 1, 0), "공단구분");
        setText(getCell(sheet, 1, 1), "성명");
        setText(getCell(sheet, 1, 2), "주민등록번호");
        setText(getCell(sheet, 1, 3), "국적");
        setText(getCell(sheet, 1, 4), "체류자격");
        setText(getCell(sheet, 1, 5), "대표자여부");
        
        					
        
        setText(getCell(sheet, 1, 6), "연금소득월액");
        setText(getCell(sheet, 1, 7), "연금취득월납부여부");
        setText(getCell(sheet, 1, 8), "연금취득부호");
        setText(getCell(sheet, 1, 9), "연금자격취득일");
        setText(getCell(sheet, 1, 10), "연금특수직종");
        setText(getCell(sheet, 1, 11), "연금직역연금부호");
         
        
        setText(getCell(sheet, 1, 12), "건강단위사업장기호");
        setText(getCell(sheet, 1, 13), "건강단위사업장명칭");
        setText(getCell(sheet, 1, 14), "건강보수월액");
        setText(getCell(sheet, 1, 15), "건강취득부호");
        setText(getCell(sheet, 1, 16), "건강자격취득일");
        setText(getCell(sheet, 1, 17), "건강감면");
        setText(getCell(sheet, 1, 18), "건강보험증사업장발송여부");
        setText(getCell(sheet, 1, 19), "건강회계");
        setText(getCell(sheet, 1, 20), "건강직종");
         
        
        setText(getCell(sheet, 1, 21), "고용자격취득일");
        setText(getCell(sheet, 1, 22), "고용직종");
        setText(getCell(sheet, 1, 23), "고용주소정근로시간");
        setText(getCell(sheet, 1, 24), "고용계약직여부");
        setText(getCell(sheet, 1, 25), "고용계약직종료년월");
        setText(getCell(sheet, 1, 26), "고용월평균보수"); 
        setText(getCell(sheet, 1, 27), "고용비고");
        setText(getCell(sheet, 1, 28), "고용보험료부과구분부호");
        setText(getCell(sheet, 1, 29), "고용보험료부과구분사유");
        
        setText(getCell(sheet, 1, 30), "산재자격취득일");
        setText(getCell(sheet, 1, 31), "산재직종");
        setText(getCell(sheet, 1, 32), "산재주소정근로시간");
        setText(getCell(sheet, 1, 33), "산재계약직여부");
        setText(getCell(sheet, 1, 34), "산재계약직종료년월");
        setText(getCell(sheet, 1, 35), "산재월평균보수"); 
        setText(getCell(sheet, 1, 36), "산재비고");
        setText(getCell(sheet, 1, 37), "산재보험료부과구분부호");
        setText(getCell(sheet, 1, 38), "산재보험료부과구분사유");
         
        
  
//        List<Dlgn0250VO> listDlgn0250 = (List<Dlgn0250VO>) model.get("insr1100AqtnExcelView");
// 
// 
//        for (int i = 0; i < listDlgn0250.size(); i++) {
//            
//                Dlgn0250VO dlgn0250Vo = listDlgn0250.get(i); 
//
                cell = getCell(sheet, 2, 0);
                setText(cell, "YYYY");
                cell = getCell(sheet, 2, 1);
                setText(cell, "김명수");  /** column 근태년월 : dilnlazYrMnth */
                cell = getCell(sheet, 2, 2);
                setText(cell, "7601131389914");   /** column 급여구분코드 : payCd */  
                cell = getCell(sheet, 2, 3);
                setText(cell, "");    /** 성명                 */
                cell = getCell(sheet, 2, 4);
                setText(cell, "");  /** 주민등록번호                 */
                cell = getCell(sheet, 2, 5); 
                setText(cell, "2");   /** column 근태_근무일수 : dilnlazDutyNumDys */
               
                cell = getCell(sheet, 2, 6);
                setText(cell, "3012920");  /** column 근태_유급휴가일수 : dilnlazPaidHodyNumDys */
                cell = getCell(sheet, 2, 7);
                setText(cell, "2");   /** column 근태_총근무일수 : dilnlazTotDutyNumDys */
                cell = getCell(sheet, 2, 8);
                setText(cell, "01");    /** column 근태_특별휴가일수 : dilnlazSpclHodyNumDys */  
               // dlgn0250Vo.setDilnlazLvsgNumDys(EgovExcelUtil.getValue(cell2));    /** column 근태_연가일수 : dilnlazLvsgNumDys */
                cell = getCell(sheet, 2, 9);
                setText(cell, "20101231");   /** column 근태_결근일수 : dilnlazAbnceNumDys */
                cell = getCell(sheet, 2, 10);
                setText(cell, "0");   /** column 근태_결근인정일수 : dilnlazAbnceDutyRcgtnDys */
                cell = getCell(sheet, 2, 11);
                setText(cell, "0");    /** column 근태_병가일수 : dilnlazSckleaNumDys */
                
                
                cell = getCell(sheet, 2, 12);
                setText(cell, "000");    /** column 근태_공가일수 : dilnlazOffvaNumDys */
                cell = getCell(sheet, 2, 13);
                setText(cell, "용인시청");     /** column 근태_경조사일수 : dilnlazFmlyEvntNumDys */
                cell = getCell(sheet, 2, 14);
                setText(cell, "2971000");    /** column 근태_보건일수 : dilnlazHlthCreNumDys */
                cell = getCell(sheet, 2, 15);
                setText(cell, "07"); 
                cell = getCell(sheet, 2, 16);
                setText(cell, "20101231");   /** column 총휴일근무일수 : dilnlazPubcHodyDutyNumDys */
                cell = getCell(sheet, 2, 17);
                setText(cell, "");   /** column 총토요근무일수 : dilnlazSatDutyNumDys */ 
                cell = getCell(sheet, 2, 18);
                setText(cell, "2");   /** column 근태_주휴일수 : dilnlazWklyHldyNumDys */
                cell = getCell(sheet, 2, 19);
                setText(cell, "");    /** column 근태_유급휴일수 : dilnlazPaidPubcHodyNum */   
                cell = getCell(sheet, 2, 20);
                setText(cell, "");
                
                
                cell = getCell(sheet, 2, 21);
                setText(cell, "20101231");   /** column 근태_교통보조비일수 : dilnlazTfcAssCstNumDys */
                cell = getCell(sheet, 2, 22);
                setText(cell, "024");   /** column 근태_기본시간외근무시간 : dilnlazFndtnTmRstDutyTm */
                cell = getCell(sheet, 2, 23);
                setText(cell, "45");   /** column 근태_시간외근무시간 : dilnlazTmRstDutyTm */
                cell = getCell(sheet, 2, 24);
                setText(cell, "1");   /** column 근태_총시간외근무시간 : dilnlazTotTmRstDutyTm */ 
                cell = getCell(sheet, 2, 25);
                setText(cell, "");  /** column 근태_총야근시간 : dilnlazTotNtotTm */
                cell = getCell(sheet, 2, 26);
                setText(cell, "3012920");  /** column 근태_총야근시간 : dilnlazTotNtotTm */
                cell = getCell(sheet, 2, 27);
                setText(cell, "01");  /** column 근태_총야근시간 : dilnlazTotNtotTm */
                cell = getCell(sheet, 2, 28);
                setText(cell, "51");  /** column 근태_총야근시간 : dilnlazTotNtotTm */
                cell = getCell(sheet, 2, 29);
                setText(cell, "09");  /** column 근태_총야근시간 : dilnlazTotNtotTm */
                
                cell = getCell(sheet, 2, 30);
                setText(cell, "20101231");   /** column 근태_교통보조비일수 : dilnlazTfcAssCstNumDys */
                cell = getCell(sheet, 2, 31);
                setText(cell, "024");   /** column 근태_기본시간외근무시간 : dilnlazFndtnTmRstDutyTm */
                cell = getCell(sheet, 2, 32);
                setText(cell, "45");   /** column 근태_시간외근무시간 : dilnlazTmRstDutyTm */
                cell = getCell(sheet, 2, 33);
                setText(cell, "1");   /** column 근태_총시간외근무시간 : dilnlazTotTmRstDutyTm */ 
                cell = getCell(sheet, 2, 34);
                setText(cell, "");  /** column 근태_총야근시간 : dilnlazTotNtotTm */
                cell = getCell(sheet, 2, 35);
                setText(cell, "3012920");  /** column 근태_총야근시간 : dilnlazTotNtotTm */
                cell = getCell(sheet, 2, 36);
                setText(cell, "01");  /** column 근태_총야근시간 : dilnlazTotNtotTm */
                cell = getCell(sheet, 2, 37);
                setText(cell, "51");  /** column 근태_총야근시간 : dilnlazTotNtotTm */
                cell = getCell(sheet, 2, 38);
                setText(cell, "09");  /** column 근태_총야근시간 : dilnlazTotNtotTm */
                 
//              //  dlgn0250Vo.setDilnlazDdlnePrcsYn(EgovExcelUtil.getValue(cell2));    /** column 근태_마감처리여부 : dilnlazDdlnePrcsYn */
//              //  dlgn0250Vo.setDilnlazNoteCtnt(EgovExcelUtil.getValue(cell2));    /** column 근태_비고내용 : dilnlazNoteCtnt */   
////                dlgn0250Vo.setDilnlazExceDutyYrMnth(EgovExcelUtil.getValue(cell2));    /** column 근태초과근무년월 : dilnlazExceDutyYrMnth */ 
////                dlgn0250Vo.setDilnlazExceDutyBgnnDt(EgovExcelUtil.getValue(cell2));    /** column 근태_초과근무시작일자 : dilnlazExceDutyBgnnDt */
////                dlgn0250Vo.setDilnlazExceDutyEndDt(EgovExcelUtil.getValue(cell2));    /** column 근태_초과근무종료일자 : dilnlazExceDutyEndDt */ 
////                dlgn0250Vo.setDilnlazTotNtotNumDys(EgovExcelUtil.getValue(cell2));    /** column 근태_총야근일수 : dilnlazTotNtotNumDys */
//                
//        }
        
    }
     
    
}
