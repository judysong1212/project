package org.msf.exterms.xls.web;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.utils.SmrmfUtils;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;

import net.sf.jxls.transformer.XLSTransformer;

public class Insr5200TempExcelView extends AbstractExcelView {

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
        
//        HSSFCell cell = null;
//         
//        HSSFSheet sheet = wb.createSheet("고용보험업로드샘플");
//        sheet.setDefaultColumnWidth((short) 20);
//  	 	 			 	 
//        // put text in first cell
//        cell = getCell(sheet, 0, 0);
//        setText(cell, "주의사항 절대지우지말것.: 일련번호, 성명, 주민등록번호는 필수 입력사항입니다. 2번째 줄 다음로우부터 업데이트 합니다.");
//         
//        setText(getCell(sheet, 1, 0), "일련번호");
//        setText(getCell(sheet, 1, 1), "성명");
//        setText(getCell(sheet, 1, 2), "주민등록번호");
//        setText(getCell(sheet, 1, 3), "고용보험보수총액");
//        setText(getCell(sheet, 1, 4), "고용보수월액"); 
//        setText(getCell(sheet, 1, 5), "취득일자"); 
//         
//            /** column 사업 : businNm */ 
//	        /** column 고용구분 : emymtDivNm */ 
//	        /** column 부서코드 : deptNm */ 
//	    	/** column SYSTEMKEY : systemkey */ 
//	        /** column 성명 : hanNm */ 
//	        /** column 주민등록번호 : resnRegnNum */ 
//	    	/** column 건강보험일련번호 : hlthInsrSeilNum */ 
//	    	/** column 고용일련번호 : emymtSeilNum */ 
//	    	/** column 사대보험공제방식 : socInsrDducEthdNm */ 
//	    	/** column 건강보험변동일자 : hlthInsurFlucDt */ 
//	    	/** column 건강보험보수총액 : hlthInsrPayTotAmnt */ 
//	    	/** column 건강보험등급 : hlthInsrGrde */ 
//	    	/** column 보수월액 : hlthInsrMnthRuntnAmnt */ 
//	    	/** column 보험료[건강] : hlthInsrMnthAmnt */ 
//	    	/** column 감면금액[건강] : exptnPrcsPymtSum01 */ 
//	        /** column 감면율[건강]: exptnPrcsPymtRto01 */ 
//	        /** column 면제사유[건강] : exptnDivNm01 */ 
//	        /** column 보험료[장기요양] : hlthInsrMnthAmnt */ 
//	        /** 감면금액[장기요양] : exptnPrcsPymtSum02 */ 
//	        /** 감면율[장기요양]: exptnPrcsPymtRto02 */ 
//	        /** 면제사유[장기요양] : exptnDivNm02 */ 
//	    	/** column 건강보험증번호 : hlthInsrCertNum */ 
//	    	/** column 건강보험적용여부 : hlthInsrApptnYn */ 
//	    	/** column 건강보험취득일자 : hlthInsrAqtnDt */ 
//	    	/** column 건강보험상실일자 : hlthInsrLssDt */ 
//	        /** column 직종 : typOccuNm */ 
//	        /** column 호봉등급 : pyspGrdeNm */ 
//	        /** column 직종세구분 : dtilOccuClsDivNm*/ 
//	        /** column 사업 : businNm */
//        
//        cell = getCell(sheet, 2, 0);
//        setText(cell, "1");
//        cell = getCell(sheet, 2, 1);
//        setText(cell, "김명수");  /** column 성명  */
//        cell = getCell(sheet, 2, 2);
//        setText(cell, "7601131111111");  /** column 주민등록번호  */
//        cell = getCell(sheet, 2, 3);
//        setText(cell, "36000000");   /** column 건강보험보수총액 */  
//        cell = getCell(sheet, 2, 4);
//        setText(cell, "3000000");    /** 보수월액             */
//        cell = getCell(sheet, 2, 5);
//        setText(cell, "20150101");    /** 취득일자            */
        
        
  	   final HashMap<String, String> globals = MSFServerUtils.getLocalidedMessages(RemoteServiceUtil.getThreadLocalConfig(), RemoteServiceUtil.getThreadLocalRequest());   
      	
    	XLSTransformer transformer = new XLSTransformer();
        
 
    	    	
      	String realPath = request.getSession().getServletContext().getRealPath(""); 
      	String xlsRelatvieFilepath = realPath.concat("/".concat(globals.get("PayGen.XLSTemplateLink")).concat("/INSR/XlsInsr5200TempExport.xls"));
		String destFileName = "고용보험업로드양식"; 
		
		Workbook resultWorkbook = transformer.transformXLS(new FileInputStream(xlsRelatvieFilepath), model);

		StringBuffer contentDisposition = new StringBuffer();
		contentDisposition.append("attachment;fileName=\"");
		contentDisposition.append(SmrmfUtils.encodeFileName(destFileName + ".xls"));
		contentDisposition.append("\";");
		 
		response.setHeader("Content-Disposition", contentDisposition.toString());
	 	response.setContentType("application/x-msexcel");
		resultWorkbook.write(response.getOutputStream());
         
    }
     
    
}
