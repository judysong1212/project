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

public class Insr2300ExcelView extends AbstractExcelView {

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
        
    	String gubun = (String) model.get("gubun");
    	    	
      	String realPath = request.getSession().getServletContext().getRealPath(""); 
      	String xlsRelatvieFilepath = realPath.concat("/".concat(globals.get("PayGen.XLSTemplateLink")).concat("/INSR/XLS_INSR2300.xls"));
		String destFileName = "사회보험자격상실신고"; 
		
		if(null != gubun && !gubun.equals("")){
			if(gubun.equals("natPennRegrst")){
				destFileName = "사회보험(국민연금)자격상실신고" ;
				xlsRelatvieFilepath =   realPath.concat("/".concat(globals.get("PayGen.XLSTemplateLink")).concat("/INSR/XLS_INSR2300_NAT.xls"));
			}else if(gubun.equals("hlthInsrRegrst")){
				destFileName = "사회보험(건강보험)자격상실신고" ;
				xlsRelatvieFilepath =   realPath.concat("/".concat(globals.get("PayGen.XLSTemplateLink")).concat("/INSR/XLS_INSR2300_HLTH.xls"));
			}else if(gubun.equals("umytInsrRegrst")){
				destFileName = "사회보험(고용보험)자격상실신고" ;
				xlsRelatvieFilepath =   realPath.concat("/".concat(globals.get("PayGen.XLSTemplateLink")).concat("/INSR/XLS_INSR2300_UMYT.xls"));
			}else if(gubun.equals("idtlAccdtRegrst")){
				destFileName = "사회보험(산재보험)자격상실신고" ;
				xlsRelatvieFilepath =   realPath.concat("/".concat(globals.get("PayGen.XLSTemplateLink")).concat("/INSR/XLS_INSR2300_IDTL.xls"));
			}else{
				destFileName = "사회보험자격상실신고" ;
				xlsRelatvieFilepath =   realPath.concat("/".concat(globals.get("PayGen.XLSTemplateLink")).concat("/INSR/XLS_INSR2300.xls"));
			}
		}
		
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
