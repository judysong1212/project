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

public class Insr320001ExcelView extends AbstractExcelView {

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
         
        HSSFSheet sheet = wb.createSheet("보수총액결정통보");
        sheet.setDefaultColumnWidth((short) 20);
  	 	 			 	 
        // put text in first cell
        cell = getCell(sheet, 0, 0);
        setText(cell, "");
        
//                =========== 작성시 주의 사항 ===================           
//                1. 1,2번째 행은 타이틀로써 아래 예제문을 따르십시요.            
//                2. 3번째 행부터 입력될 데이터를 작성합니다.          
//                3. '실근무일'에는 근무일수+유급휴가에서 결근일수 제외한 일수를 입력합니다.         
//                4. 시간외수당 '총시간'은 기본시간과 시간외시간의 합을 입력합니다.          
//                5. '작성시 주의사항'은 반드시 삭제후 파일을 업로드 하십시오.    
        // set header information
        
        					
        setText(getCell(sheet, 1, 0), "결정년도");  	/** column 연금결정년도 : antyDeinYr */
        setText(getCell(sheet, 1, 1), "부서"); 		/** column 부서 : deptNm */
        setText(getCell(sheet, 1, 2), "성명");		/** column 한글성명 : hanNm */
        setText(getCell(sheet, 1, 3), "주민등록번호");	/** column 주민등록번호 : resnRegnNum */
        setText(getCell(sheet, 1, 4), "총근무일수");	/** column 연금총근무일수 : antyTotDutyNumDys */
        setText(getCell(sheet, 1, 5), "소득총액");		/** column 연금소득총액 : antyIncmTotAmnt */
        
        					
        
        setText(getCell(sheet, 1, 6), "기준소득월액");   /** column 연금기준소득월액 : antyStdIncmMnthAmnt */
        setText(getCell(sheet, 1, 7), "월보험료");     /** column 연금월보험료 : antyMnthPrmm */
        setText(getCell(sheet, 1, 8), "종전기준소득월액");  /** column 종전기준소득월액 : bfrStdIncmMnthAmnt */
        setText(getCell(sheet, 1, 9), "과세자료결정여부");  /** column 과세자료결정여부 : txtnDataDeinYn */
        setText(getCell(sheet, 1, 10), "공단직권결정여부"); /** column 공단직권결정여부 : pbcorpOautyDeinYn */
        setText(getCell(sheet, 1, 11), "고용구분");  /** column 고용구분 : emymtDivNm */
         
        
        setText(getCell(sheet, 1, 12), "직종");    /** column 직종 : typOccuNm */
        setText(getCell(sheet, 1, 13), "직종세");   /** column 직종세구분 : dtilOccuClsDivNm */
        setText(getCell(sheet, 1, 14), "사업");     /** column 사업 : businNm */
         
        
  
        List listInsr4300 = (List) model.get("listInsr4300");
      
        Iterator<Map<String, Object>> iter =  listInsr4300.iterator();
        
        while ( iter.hasNext() ) {
             Map<String, Object> lstMap = (Map<String, Object>) iter.next(); 
                cell = getCell(sheet, 2, 0);
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("antyDeinYr")));        	/** column 연금결정년도 : antyDeinYr */
                cell = getCell(sheet, 2, 1);
                setText(cell,  MSFSharedUtils.allowNulls(lstMap.get("deptNm")));  /** column 부서 : deptNm */
                cell = getCell(sheet, 2, 2);
                setText(cell,  MSFSharedUtils.allowNulls(lstMap.get("hanNm")));   /** column 한글성명 : hanNm */
                cell = getCell(sheet, 2, 3);
                setText(cell,  MSFSharedUtils.allowNulls(lstMap.get("resnRegnNum")));   	/** column 주민등록번호 : resnRegnNum */
                cell = getCell(sheet, 2, 4);
                setText(cell,  MSFSharedUtils.allowNulls(lstMap.get("antyTotDutyNumDys"))); /** column 연금총근무일수 : antyTotDutyNumDys */
                cell = getCell(sheet, 2, 5); 
                setText(cell,  MSFSharedUtils.allowNulls(lstMap.get("antyIncmTotAmnt")));   /** column 연금소득총액 : antyIncmTotAmnt */
               
                cell = getCell(sheet, 2, 6);
                setText(cell,  MSFSharedUtils.allowNulls(lstMap.get("antyStdIncmMnthAmnt")));  /** column 연금기준소득월액 : antyStdIncmMnthAmnt */
                cell = getCell(sheet, 2, 7);
                setText(cell,  MSFSharedUtils.allowNulls(lstMap.get("antyMnthPrmm")));   /** column 연금월보험료 : antyMnthPrmm */
                cell = getCell(sheet, 2, 8);
                setText(cell,  MSFSharedUtils.allowNulls(lstMap.get("bfrStdIncmMnthAmnt")));    /** column 종전기준소득월액 : bfrStdIncmMnthAmnt */  
                cell = getCell(sheet, 2, 9);
                setText(cell,  MSFSharedUtils.allowNulls(lstMap.get("txtnDataDeinYn")));   /** column 과세자료결정여부 : txtnDataDeinYn */
                cell = getCell(sheet, 2, 10);
                setText(cell,  MSFSharedUtils.allowNulls(lstMap.get("pbcorpOautyDeinYn")));   /** column 공단직권결정여부 : pbcorpOautyDeinYn */
                cell = getCell(sheet, 2, 11);
                setText(cell,  MSFSharedUtils.allowNulls(lstMap.get("emymtDivNm")));    /** column 고용구분 : emymtDivNm */
                
                
                cell = getCell(sheet, 2, 12);
                setText(cell,  MSFSharedUtils.allowNulls(lstMap.get("typOccuNm")));    /** column 직종 : typOccuNm */
                cell = getCell(sheet, 2, 13);
                setText(cell,  MSFSharedUtils.allowNulls(lstMap.get("dtilOccuClsDivNm")));      /** column 직종세구분 : dtilOccuClsDivNm */
                cell = getCell(sheet, 2, 14);
                setText(cell,  MSFSharedUtils.allowNulls(lstMap.get("businNm")));   /** column 사업 : businNm */
                
         }
        
    }
     
    
}
