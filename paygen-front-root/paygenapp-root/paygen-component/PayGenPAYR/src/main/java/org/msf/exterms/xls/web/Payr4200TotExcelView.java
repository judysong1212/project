package org.msf.exterms.xls.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.msf.exterms.xls.service.Payr4200TotVO;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class Payr4200TotExcelView extends AbstractExcelView {

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

        Boolean boolWrite = true;
        int iCnt = 3;
        
        Long lnSumPymtBaseAmnt = 0l;
        Long lnSumExtpyTotAmnt = 0l;
        Long lnSumDducAmnt = 0l;
        Long lnSumDducTotAmnt = 0l;
        Long lnSumTxTotAmnt = 0l;
        Long lnSumDducHlthAmnt = 0l;
        Long lnSumDducNatAmnt = 0l;
        Long lnSumDducUmytAmnt = 0l;
        Long lnSumPymtTotAmnt = 0l;
        Long lnSumPernPymtSum = 0l;
        
        HSSFSheet sheet = wb.createSheet("월급여내역");
        sheet.setDefaultColumnWidth((short) 20);
 
        // put text in first cell
        cell = getCell(sheet, 0, 0);
        setText(cell, "월급여내역");
         
  
        List<Payr4200TotVO>  listTotPayr4200 = (List<Payr4200TotVO>) model.get("listTotPayr4200");
  
 
        for (int i = 0; i < listTotPayr4200.size(); i++) {
        
              Payr4200TotVO payr4200TotVo = new Payr4200TotVO();
              payr4200TotVo = (Payr4200TotVO)listTotPayr4200.get(i);
              
              if (boolWrite) {

                  // set header information
                  setText(getCell(sheet, 2, 0), "번호");
                  setText(getCell(sheet, 2, 1), "지급년월"); 
                  setText(getCell(sheet, 2, 2), "부서"); 
                  setText(getCell(sheet, 2, 3), "성명");
                  setText(getCell(sheet, 2, 4), "주민등록번호"); 
                  setText(getCell(sheet, 2, 5), "직종/사업");
                  setText(getCell(sheet, 2, 6), "직종세");
                  setText(getCell(sheet, 2, 7), "근속년수"); 
                  setText(getCell(sheet, 2, 8), "기본급");
                  setText(getCell(sheet, 2, 9), "수당");
                  setText(getCell(sheet, 2, 10), "공제(4대보험제외)");
                  setText(getCell(sheet, 2, 11), "공제(4대보험포함)"); 
                  setText(getCell(sheet, 2, 12), "세금");
                  setText(getCell(sheet, 2, 13), "건강보험");
                  setText(getCell(sheet, 2, 14), "국민연금"); 
                  setText(getCell(sheet, 2, 15), "고용보험"); 
                  setText(getCell(sheet, 2, 16), "지급총액"); 
                  setText(getCell(sheet, 2, 17), "실지급액");  
                  
                  boolWrite = false;
              } 
   
                cell = getCell(sheet, 3 + i, 0);
                setText(cell, String.valueOf(i + 1));
                cell = getCell(sheet, 3 + i, 1);
                setText(cell,payr4200TotVo.getPymtYrMnth());  /** 지급년월 */
                cell = getCell(sheet, 3 + i, 2);
                setText(cell, payr4200TotVo.getDeptNm());  /** 부서                 */
                cell = getCell(sheet, 3 + i, 3); 
                setText(cell, payr4200TotVo.getHanNm());  /** 성명 */ 
                cell = getCell(sheet, 3 + i, 4);
                setText(cell, payr4200TotVo.getResnRegnNum());   /** 주민번호 */
                cell = getCell(sheet, 3 + i, 5);
                setText(cell, (payr4200TotVo.getTypOccuNm() == null ? payr4200TotVo.getBusinNm() : payr4200TotVo.getTypOccuNm()) ); /** 직종/사업  */ 
                cell = getCell(sheet, 3 + i, 6);
                setText(cell, payr4200TotVo.getDtilOccuClsDivNm()); /** 직종세 */ 
                cell = getCell(sheet, 3 + i, 7);
                setText(cell, payr4200TotVo.getLogSvcYrNumNm());  /** 근속년수 */ 
                
                lnSumPymtBaseAmnt = lnSumPymtBaseAmnt + payr4200TotVo.getPymtBaseAmnt().longValue(); 
                
                cell = getCell(sheet, 3 + i, 8);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(payr4200TotVo.getPymtBaseAmnt().longValue()); /** 기본급 */ 
                
                lnSumExtpyTotAmnt = lnSumExtpyTotAmnt + payr4200TotVo.getExtpyTotAmnt().longValue();
              
                
                cell = getCell(sheet, 3 + i, 9);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(payr4200TotVo.getExtpyTotAmnt().longValue()); /** 수당 */ 
                
                lnSumDducAmnt = lnSumDducAmnt + payr4200TotVo.getDducAmnt().longValue();
              
                
                cell = getCell(sheet, 3 + i, 10);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(payr4200TotVo.getDducAmnt().longValue()); /** 공제제외 */ 
                
                lnSumDducTotAmnt = lnSumDducTotAmnt + payr4200TotVo.getDducTotAmnt().longValue();
               
                
                cell = getCell(sheet, 3 + i, 11);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(payr4200TotVo.getDducTotAmnt().longValue());  /** 공제포함  */
                
                 lnSumTxTotAmnt = lnSumTxTotAmnt + payr4200TotVo.getTxTotAmnt().longValue();
               
                cell = getCell(sheet, 3 + i, 12);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(payr4200TotVo.getTxTotAmnt().longValue()); /** 세금  */
                
                lnSumDducHlthAmnt = lnSumDducHlthAmnt + payr4200TotVo.getDducHlthAmnt().longValue();
                
                cell = getCell(sheet, 3 + i, 13);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(payr4200TotVo.getDducHlthAmnt().longValue()); /** 건강보험  */ 
                
                lnSumDducNatAmnt = lnSumDducNatAmnt + payr4200TotVo.getDducNatAmnt().longValue();
                
                
                cell = getCell(sheet, 3 + i, 14);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(payr4200TotVo.getDducNatAmnt().longValue()); /** 국민연금  */
                
                lnSumDducUmytAmnt = lnSumDducUmytAmnt + payr4200TotVo.getDducUmytAmnt().longValue();
             
                cell = getCell(sheet, 3 + i, 15);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(payr4200TotVo.getDducUmytAmnt().longValue()); /** 고용보험  */  
                
                lnSumPymtTotAmnt = lnSumPymtTotAmnt + payr4200TotVo.getPymtTotAmnt().longValue();
                 
                
                cell = getCell(sheet, 3 + i, 16);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(payr4200TotVo.getPymtTotAmnt().toString()));  /** 지급총액  */ 
                
                lnSumPernPymtSum = lnSumPernPymtSum + payr4200TotVo.getPernPymtSum().longValue();
                
                cell = getCell(sheet, 3 + i, 17);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(payr4200TotVo.getPernPymtSum().longValue());/** 실지급액  */ 
                 
                //차후 소계추가 
              
        }
        
        HSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setFillForegroundColor(new HSSFColor.BRIGHT_GREEN().getIndex());
           //합계금액 추가 할것.....
        cell = getCell(sheet, iCnt + listTotPayr4200.size() , 0);
        cell.setCellStyle(cellStyle);
        setText(cell, "합계");
       
        cell = getCell(sheet, iCnt + listTotPayr4200.size() , 1);
        cell.setCellStyle(cellStyle);
        setText(cell,"");  /** 지급년월 */
        cell = getCell(sheet, iCnt + listTotPayr4200.size() , 2);
        cell.setCellStyle(cellStyle);
        setText(cell, "");  /** 부서                 */
        cell = getCell(sheet, iCnt + listTotPayr4200.size() , 3); 
        cell.setCellStyle(cellStyle);
        setText(cell, "");  /** 성명 */ 
        cell = getCell(sheet, iCnt + listTotPayr4200.size() , 4);
        cell.setCellStyle(cellStyle);
        setText(cell, "");   /** 주민번호 */
        cell = getCell(sheet, iCnt + listTotPayr4200.size() , 5);
        cell.setCellStyle(cellStyle);
        setText(cell, "" ); /** 직종/사업  */ 
        cell = getCell(sheet, iCnt + listTotPayr4200.size() , 6);
        cell.setCellStyle(cellStyle);
        setText(cell, ""); /** 직종세 */ 
        cell = getCell(sheet, iCnt + listTotPayr4200.size() , 7);
        cell.setCellStyle(cellStyle);
        setText(cell, "");  /** 근속년수 */ 
         
        cell = getCell(sheet, iCnt + listTotPayr4200.size() , 8);
        cell.setCellStyle(cellStyle);
        cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
        cell.setCellValue(lnSumPymtBaseAmnt); /** 기본급 */ 
        cell = getCell(sheet, iCnt + listTotPayr4200.size() , 9);
        cell.setCellStyle(cellStyle);
        cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
        cell.setCellValue(lnSumExtpyTotAmnt); /** 수당 */ 
        cell = getCell(sheet, iCnt + listTotPayr4200.size() , 10);
        cell.setCellStyle(cellStyle);
        cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
        cell.setCellValue(lnSumDducAmnt); /** 공제제외 */ 
        cell = getCell(sheet, iCnt + listTotPayr4200.size() , 11);
        cell.setCellStyle(cellStyle);
        cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
        cell.setCellValue(lnSumDducTotAmnt);  /** 공제포함  */
        cell = getCell(sheet, iCnt + listTotPayr4200.size() , 12);
        cell.setCellStyle(cellStyle);
        cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
        cell.setCellValue(lnSumTxTotAmnt); /** 세금  */
        cell = getCell(sheet, iCnt + listTotPayr4200.size() , 13);
        cell.setCellStyle(cellStyle);
        cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
        cell.setCellValue(lnSumDducHlthAmnt); /** 건강보험  */ 
        cell = getCell(sheet, iCnt + listTotPayr4200.size() , 14);
        cell.setCellStyle(cellStyle);
        cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
        cell.setCellValue(lnSumDducNatAmnt); /** 국민연금  */
        cell = getCell(sheet, iCnt + listTotPayr4200.size() , 15);
        cell.setCellStyle(cellStyle);
        cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
        cell.setCellValue(lnSumDducUmytAmnt); /** 고용보험  */  
        cell = getCell(sheet, iCnt + listTotPayr4200.size() , 16);
        cell.setCellStyle(cellStyle);
        cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
        cell.setCellValue(lnSumPymtTotAmnt);  /** 지급총액  */ 
        cell = getCell(sheet, iCnt + listTotPayr4200.size() , 17);
        cell.setCellStyle(cellStyle);
        cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
        cell.setCellValue(lnSumPernPymtSum);/** 실지급액  */ 
        
        
    }
     
    
}
