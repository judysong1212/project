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

public class Insr5100ExcelView_20160525 extends AbstractExcelView {

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
        HSSFSheet sheet = wb.createSheet("고용보험");
        sheet.setDefaultColumnWidth((short) 20);
  	 	 			 	 
        // put text in first cell
        cell = getCell(sheet, 0, 0);
        setText(cell, "고용보험리스트");
         
        setText(getCell(sheet, 1, 0), "일련번호");
        setText(getCell(sheet, 1, 1), "고용구분");
        setText(getCell(sheet, 1, 2), "부서");
        setText(getCell(sheet, 1, 3), "성명");
        setText(getCell(sheet, 1, 4), "주민등록번호"); 
        setText(getCell(sheet, 1, 5), "사대보험공제방식");
        setText(getCell(sheet, 1, 6), "건강보험보수총액"); 
        setText(getCell(sheet, 1, 7), "건강보험등급");
        setText(getCell(sheet, 1, 8), "보수월액"); 
        setText(getCell(sheet, 1, 9), "보험료[건강]");
        setText(getCell(sheet, 1, 10), "감면율[건강]");
        setText(getCell(sheet, 1, 11), "면제사유[건강]");
        setText(getCell(sheet, 1, 12), "보험료[장기요양]");
        setText(getCell(sheet, 1, 13), "감면율[장기요양]");
        setText(getCell(sheet, 1, 14), "면제사유[장기요양] ");
        setText(getCell(sheet, 1, 15), "건강보험증번호"); 
        setText(getCell(sheet, 1, 16), "취득일자");
        setText(getCell(sheet, 1, 17), "상실일자");
        setText(getCell(sheet, 1, 18), "직종"); 
        setText(getCell(sheet, 1, 19), "호봉등급"); 
        setText(getCell(sheet, 1, 20), "직종세"); 
        setText(getCell(sheet, 1, 21), "사업");  
       
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
                setText(cell,MSFSharedUtils.allowNulls(lstMap.get("hanNm")) );    /** column 성명 : hanNm */
                cell = getCell(sheet, 2 + i, 4);
                setText(cell,MSFSharedUtils.allowNulls(lstMap.get("resnRegnNum")));  /** column 주민등록번호 : resnRegnNum */ 
                cell = getCell(sheet, 2 + i, 5); 
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("socInsrDducEthdNm")));  /** column 사대보험공제방식 : socInsrDducEthdNm */ 
                cell = getCell(sheet, 2 + i, 6); 
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("hlthInsrPayTotAmnt"))); /** column 건강보험보수총액 : hlthInsrPayTotAmnt */ 
                cell = getCell(sheet, 2 + i, 7); 
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("hlthInsrGrde")));  /** column 건강보험등급 : hlthInsrGrde */  
                cell = getCell(sheet, 2 + i, 8); 
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("hlthInsrMnthRuntnAmnt")));  /** column 보수월액 : hlthInsrMnthRuntnAmnt */ 
                cell = getCell(sheet, 2 + i, 9); 
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("hlthInsrMnthAmnt")));  /** column 보험료[건강] : hlthInsrMnthAmnt */  
                cell = getCell(sheet, 2 + i, 10); 
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("exptnPrcsPymtRto01"))); /** column 감면율[건강]: exptnPrcsPymtRto01 */
                cell = getCell(sheet, 2 + i, 11); 
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("exptnDivNm01")));  /** column 면제사유[건강] : exptnDivNm01 */ 
                cell = getCell(sheet, 2 + i, 12); 
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("hlthInsrMnthAmnt")));  /** column 보험료[장기요양] : hlthInsrMnthAmnt */  
                cell = getCell(sheet, 2 + i, 13); 
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("exptnPrcsPymtRto02")));   /** 감면율[장기요양]: exptnPrcsPymtRto02 */  
                cell = getCell(sheet, 2 + i, 14); 
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("exptnDivNm02")));   /** 면제사유[장기요양] : exptnDivNm02 */ 
                cell = getCell(sheet, 2 + i, 15); 
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("hlthInsrCertNum")));   /** column 건강보험증번호 : hlthInsrCertNum */  
                cell = getCell(sheet, 2 + i, 16); 
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("hlthInsrAqtnDt")));   /** column 건강보험취득일자 : hlthInsrAqtnDt */ 
                cell = getCell(sheet, 2 + i, 17); 
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("hlthInsrLssDt")));   /** column 건강보험상실일자 : hlthInsrLssDt */  
                cell = getCell(sheet, 2 + i, 18);
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("typOccuNm")));    /** column 직종 : typOccuNm */
                cell = getCell(sheet, 2 + i, 19);
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("pyspGrdeNm")));            /** column 호봉등급 : pyspGrdeNm */
                cell = getCell(sheet, 2 + i, 20);
                setText(cell,MSFSharedUtils.allowNulls(lstMap.get("dtilOccuClsDivNm")));        /** column 직종세 : dtilOccuClsDivNm */
                cell = getCell(sheet, 2 + i, 21);
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("businNm")));      /** column 사업 : businNm */ 
              
                i = i + 1;
        }
        
    } 
     

      /** column 사업 : businNm */ 
      /** column 고용구분 : emymtDivNm */ 
      /** column 부서코드 : deptNm */ 
  	/** column SYSTEMKEY : systemkey */ 
      /** column 성명 : hanNm */ 
      /** column 주민등록번호 : resnRegnNum */ 
  	/** column 건강보험일련번호 : hlthInsrSeilNum */ 
  	/** column 고용일련번호 : emymtSeilNum */ 
  	/** column 사대보험공제방식 : socInsrDducEthdNm */ 
  	/** column 건강보험변동일자 : hlthInsurFlucDt */ 
  	/** column 건강보험보수총액 : hlthInsrPayTotAmnt */ 
  	/** column 건강보험등급 : hlthInsrGrde */ 
  	/** column 보수월액 : hlthInsrMnthRuntnAmnt */ 
  	/** column 보험료[건강] : hlthInsrMnthAmnt */ 
  	/** column 감면금액[건강] : exptnPrcsPymtSum01 */ 
      /** column 감면율[건강]: exptnPrcsPymtRto01 */ 
      /** column 면제사유[건강] : exptnDivNm01 */ 
      /** column 보험료[장기요양] : hlthInsrMnthAmnt */ 
      /** 감면금액[장기요양] : exptnPrcsPymtSum02 */ 
      /** 감면율[장기요양]: exptnPrcsPymtRto02 */ 
      /** 면제사유[장기요양] : exptnDivNm02 */ 
  	/** column 건강보험증번호 : hlthInsrCertNum */ 
  	/** column 건강보험적용여부 : hlthInsrApptnYn */ 
  	/** column 건강보험취득일자 : hlthInsrAqtnDt */ 
  	/** column 건강보험상실일자 : hlthInsrLssDt */ 
      /** column 직종 : typOccuNm */ 
      /** column 호봉등급 : pyspGrdeNm */ 
      /** column 직종세구분 : dtilOccuClsDivNm*/ 
      /** column 사업 : businNm */
      
    
}
