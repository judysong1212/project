package org.msf.exterms.xls.web;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

public class InsrP410003ExcelView_20160518 extends AbstractExcelView {

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
        int i = 0; 
        HSSFSheet sheet = wb.createSheet("국민연금");
        sheet.setDefaultColumnWidth((short) 20);
  	 	 			 	 
        // put text in first cell
        cell = getCell(sheet, 0, 0);
        setText(cell, "국민연금-월별납부실적");
         
        setText(getCell(sheet, 1, 0), "일련번호");
        setText(getCell(sheet, 1, 1), "고용구분");
        setText(getCell(sheet, 1, 2), "부서");
        setText(getCell(sheet, 1, 3), "성명");
        setText(getCell(sheet, 1, 4), "주민등록번호"); 
        setText(getCell(sheet, 1, 5), "등급"); 
        setText(getCell(sheet, 1, 6), "기준소득월액");
        setText(getCell(sheet, 1, 7), "연금보험료");
        setText(getCell(sheet, 1, 8), "정산보험료");
        setText(getCell(sheet, 1, 9), "소급보험료");
        setText(getCell(sheet, 1, 10), "합계");
        setText(getCell(sheet, 1, 11), "직종"); 
        setText(getCell(sheet, 1, 12), "호봉등급"); 
        setText(getCell(sheet, 1, 13), "직종세"); 
        setText(getCell(sheet, 1, 14), "사업"); 
         
       
        List listInsrP3000 = (List) model.get("listInsrP3000");
        
        Iterator<Map<String, Object>> iter =  listInsrP3000.iterator();
        
         while ( iter.hasNext() ) {
        
        	 Map<String, Object> lstMap = (Map<String, Object>) iter.next();
            
        	  
                cell = getCell(sheet, 2 + i, 0);
                setText(cell, Integer.toString(i+1));
                cell = getCell(sheet, 2 + i, 1);
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("emymtDivNm")) );  /** column 고용구분 : emymtDivNm */
                cell = getCell(sheet, 2 + i, 2);
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("deptNm")));   /** column 부서 : deptNm */
                cell = getCell(sheet, 2 + i, 3);
                setText(cell,MSFSharedUtils.allowNulls(lstMap.get("hanNm")) );    /** column 성명 : hanNm */
                cell = getCell(sheet, 2 + i, 4);
                setText(cell,MSFSharedUtils.allowNulls(lstMap.get("resnRegnNum")));  /** column 주민등록번호 : resnRegnNum */
                cell = getCell(sheet, 2 + i, 5); 
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("natPennGrde")));  /** column 등급 : natPennGrde */
                cell = getCell(sheet, 2 + i, 6);
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("natPennStdIncmMnthAmnt"))); /** column 국민연금기준소득월액 : natPennStdIncmMnthAmnt */ 
                cell = getCell(sheet, 2 + i, 7);
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("pymtDducD0150100")));  /** set 연금보험료 : pymtDducD0150100 */ 
                cell = getCell(sheet, 2 + i, 8);
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("pymtDducD0150200")));   /** set 정산보험료 : pymtDducD0150200 */ 
                cell = getCell(sheet, 2 + i, 9);
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("pymtDducD0150300"))); /** set 소급보험료 : pymtDducD0150300 */ 
                cell = getCell(sheet, 2 + i, 10);
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("pymtDducSum")));  /** set 합계 : pymtDducSum */ 
                cell = getCell(sheet, 2 + i, 11);
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("typOccuNm")));    /** column 직종 : typOccuNm */
                cell = getCell(sheet, 2 + i, 12);
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("pyspGrdeNm")));            /** column 등급 : pyspGrdeNm */
                cell = getCell(sheet, 2 + i, 13);
                setText(cell,MSFSharedUtils.allowNulls(lstMap.get("dtilOccuClsDivNm")));        /** column 직종세 : dtilOccuClsDivNm */
                cell = getCell(sheet, 2 + i, 14);
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("businNm")));      /** column 사업 : businNm */ 
              
                i = i + 1;
        }
        
    } 
      
    
}
