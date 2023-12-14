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

public class Insr3300TempExcelView extends AbstractExcelView {

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
//        HSSFSheet sheet = wb.createSheet("국민연금결정내역 업로드샘플");
//  	 	 			 	 
//        // put text in first cell
//        cell = getCell(sheet, 0, 0);
//        setText(cell, "주의사항 절대지우지말것.: 일련번호, 결정년도, 성명, 주민등록번호는 필수 입력사항입니다. 2번째 줄 다음로우부터 업데이트 합니다.");
//
//        setText(getCell(sheet, 1, 0), "결정년도");
//        setText(getCell(sheet, 1, 1), "한글성명");
//        setText(getCell(sheet, 1, 2), "주민등록번호"); 
//        setText(getCell(sheet, 1, 3), "총근무일수");
//        setText(getCell(sheet, 1, 4), "소득총액");
//        setText(getCell(sheet, 1, 5), "기준소득월액");
//        setText(getCell(sheet, 1, 6), "월보험료");
//        
//        /*
//        setText(getCell(sheet, 1, 7), "종전기준소득월액");
//        setText(getCell(sheet, 1, 8), "과세자료결정여부");
//        setText(getCell(sheet, 1, 9), "공단직권결정여부");
//        setText(getCell(sheet, 1, 10), "연금급여반영여부");
//        setText(getCell(sheet, 1, 11), "국민연금취득일자");
//        
//        setText(getCell(sheet, 1, 12), "국민연금 급여적용년월");
//        setText(getCell(sheet, 1, 13), "국민연금 급여적용일자");
//        setText(getCell(sheet, 1, 14), "국민연금 급여처리여부");
//        */
//        
//        cell = getCell(sheet, 2, 0);
//        setText(cell, "2016"); //결정년도
//        cell = getCell(sheet, 2, 1);
//        setText(cell, "강구희");   //한글성명  
//        cell = getCell(sheet, 2, 2);
//        setText(cell, "830530-2222222");    //주민등록번호
//        cell = getCell(sheet, 2, 3);
//        setText(cell, "200");    //총근무일수
//        cell = getCell(sheet, 2, 4);
//        setText(cell, "");    //소득총액
//        cell = getCell(sheet, 2, 5);
//        setText(cell, "1784000");    //기준소득월액
//        cell = getCell(sheet, 2, 6);
//        setText(cell, "160560");    //월보험료
        
    	
  	   final HashMap<String, String> globals = MSFServerUtils.getLocalidedMessages(RemoteServiceUtil.getThreadLocalConfig(), RemoteServiceUtil.getThreadLocalRequest());   
      	
    	XLSTransformer transformer = new XLSTransformer();
        
 
    	    	
      	String realPath = request.getSession().getServletContext().getRealPath(""); 
      	String xlsRelatvieFilepath = realPath.concat("/".concat(globals.get("PayGen.XLSTemplateLink")).concat("/INSR/XlsInsr3300TempExport.xls"));
		String destFileName = "국민연금결정내역업로드양식"; 
		
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
