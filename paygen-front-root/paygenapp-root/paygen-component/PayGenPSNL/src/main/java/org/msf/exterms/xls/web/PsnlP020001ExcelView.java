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

public class PsnlP020001ExcelView extends AbstractExcelView {

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
        
    	
	    final HashMap<String, String> globals = MSFServerUtils.getLocalidedMessages(RemoteServiceUtil.getThreadLocalConfig(), RemoteServiceUtil.getThreadLocalRequest());   
      	
    	XLSTransformer transformer = new XLSTransformer();
        
      	String realPath = request.getSession().getServletContext().getRealPath(""); 
      	String xlsRelatvieFilepath =   realPath.concat("/".concat(globals.get("PayGen.XLSTemplateLink")).concat("/PSNL/XLS_PSNLP020001.xls"));
      
		String destFileName = "기간제신규고용업로드데이터";
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
