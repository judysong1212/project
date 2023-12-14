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

public class Insr3100ExcelView extends AbstractExcelView {

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
        setText(cell, "국민연금리스트");
         
        setText(getCell(sheet, 1, 0), "일련번호");
        setText(getCell(sheet, 1, 1), "고용구분");
        setText(getCell(sheet, 1, 2), "부서");
        setText(getCell(sheet, 1, 3), "성명");
        setText(getCell(sheet, 1, 4), "주민등록번호"); 
        setText(getCell(sheet, 1, 5), "등급");
        setText(getCell(sheet, 1, 6), "보험료[등급]");
        setText(getCell(sheet, 1, 7), "기준소득월액");
        setText(getCell(sheet, 1, 8), "보험료[기준소득월액]");
        setText(getCell(sheet, 1, 9), "취득일자");
        setText(getCell(sheet, 1, 10), "상실일자");
        setText(getCell(sheet, 1, 11), "직종"); 
        setText(getCell(sheet, 1, 12), "호봉등급"); 
        setText(getCell(sheet, 1, 13), "직종세"); 
        setText(getCell(sheet, 1, 14), "사업"); 
         
       
        List listInsr4100 = (List) model.get("listInsr4100");
        
        Iterator<Map<String, Object>> iter =  listInsr4100.iterator();
        
         while ( iter.hasNext() ) {
              Map<String, Object> lstMap = (Map<String, Object>) iter.next();
            
        	//  Insr4100VO insr4100Vo =  new Insr4100VO(); 
        	//  insr4100Vo = (Insr4100VO)ReflectionUtils.convertMapToObject(lstMap,Insr4100VO.class);
  
                cell = getCell(sheet, 2 + i, 0);
                setText(cell, Integer.toString(i+1));
                cell = getCell(sheet, 2 + i, 1);
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("emymtDivNm")) );  /** column 고용구분 : emymtDivNm */
                cell = getCell(sheet, 2 + i, 2);
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("deptNm")));   /** column 부서 : deptNm */
                cell = getCell(sheet, 2 + i, 3);
                setText(cell,MSFSharedUtils.allowNulls(lstMap.get("hanNm")) );    /** column 성명 : nm */
                cell = getCell(sheet, 2 + i, 4);
                setText(cell,MSFSharedUtils.allowNulls(lstMap.get("resnRegnNum")));  /** column 주민등록번호 : resnRegnNum */
                cell = getCell(sheet, 2 + i, 5); 
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("natPennGrde")));  /** column 등급 : natPennGrde */
                cell = getCell(sheet, 2 + i, 6);
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("natPennGrdeAmnt")));  /** column 보험료[등급] : natPennGrdeAmnt */ 
                cell = getCell(sheet, 2 + i, 7);
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("natPennStdIncmMnthAmnt")));   /** column 기준소득월액 : natPennStdIncmMnthAmnt */
                cell = getCell(sheet, 2 + i, 8);
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("natPennMnthAmnt")));   /** column 보험료[기준소득월액] : natPennMnthAmnt */ 
                cell = getCell(sheet, 2 + i, 9);
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("natPennAqtnDt")));  /** column 취득일자 : natPennAqtnDt */
                cell = getCell(sheet, 2 + i, 10);
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("natPennLssDt")));  /** column 상실일자 : natPennLssDt */
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
     
//    cell = getCell(sheet, 2+ i, 0);
//    setText(cell, Integer.toString(i+1));
//    cell = getCell(sheet, 2+ i, 1);
//    setText(cell,insr4100Vo.getEmymtDivNm());  /** column 고용구분 : emymtDivNm */
//    cell = getCell(sheet, 2+ i, 2);
//    setText(cell, insr4100Vo.getDeptNm());   /** column 부서 : deptNm */
//    cell = getCell(sheet, 2+ i, 3);
//    setText(cell,insr4100Vo.getHanNm() );    /** column 성명 : hanNm */
//    cell = getCell(sheet, 2+ i, 4);
//    setText(cell, insr4100Vo.getResnRegnNum());  /** column 주민등록번호 : resnRegnNum */
//    cell = getCell(sheet, 2+ i, 5); 
//    setText(cell, insr4100Vo.getNatPennGrde());  /** column 등급 : natPennGrde */
//    cell = getCell(sheet, 2+ i, 6);
//    setText(cell, String.valueOf(insr4100Vo.getNatPennGrdeAmnt()));  /** column 보험료[등급] : natPennGrdeAmnt */ 
//    cell = getCell(sheet, 2+ i, 7);
//    setText(cell, String.valueOf(insr4100Vo.getNatPennStdIncmMnthAmnt()));   /** column 기준소득월액 : natPennStdIncmMnthAmnt */
//    cell = getCell(sheet, 2+ i, 8);
//    setText(cell, String.valueOf(insr4100Vo.getNatPennMnthAmnt()));   /** column 보험료[기준소득월액] : natPennMnthAmnt */ 
//    cell = getCell(sheet, 2+ i, 9);
//    setText(cell, insr4100Vo.getNatPennAqtnDt());  /** column 취득일자 : natPennAqtnDt */
//    cell = getCell(sheet, 2+ i, 10);
//    setText(cell, insr4100Vo.getNatPennLssDt());  /** column 상실일자 : natPennLssDt */
//    cell = getCell(sheet, 2+ i, 11);
//    setText(cell, insr4100Vo.getTypOccuNm());    /** column 직종 : typOccuNm */
//    cell = getCell(sheet, 2+ i, 12);
//    setText(cell, insr4100Vo.getPyspGrdeNm());            /** column 등급 : pyspGrdeNm */
//    cell = getCell(sheet, 2+ i, 13);
//    setText(cell, insr4100Vo.getDtilOccuClsDivNm());        /** column 직종세 : dtilOccuClsDivNm */
//    cell = getCell(sheet, 2+ i, 14);
//    setText(cell, insr4100Vo.getBusinNm());      /** column 사업 : businNm */ 
    
}
