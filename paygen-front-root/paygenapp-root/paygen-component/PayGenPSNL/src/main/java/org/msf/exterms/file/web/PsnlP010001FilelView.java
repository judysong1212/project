package org.msf.exterms.file.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

public class PsnlP010001FilelView extends AbstractView{
	

	/**
     * 엑셀파일을 설정하고 생성한다.
     * @param model
     * @param wb
     * @param request
     * @param response
     * @throws Exception
     */
//    @Override
//    protected void buildExcelDocument(Map<String, Object> model,HttpServletRequest request,HttpServletResponse response) throws Exception {
//        
//    	
//	    final HashMap<String, String> globals = MSFServerUtils.getLocalidedMessages(RemoteServiceUtil.getThreadLocalConfig(), RemoteServiceUtil.getThreadLocalRequest());   
//      	
//    	XLSTransformer transformer = new XLSTransformer();
//        
//      	String realPath = request.getSession().getServletContext().getRealPath(""); 
//      	String xlsRelatvieFilepath =   realPath.concat("/".concat(globals.get("PayGen.XLSTemplateLink")).concat("/PSNL/UPXLS_PSNL012601.xls"));
//      
//		String destFileName = "휴가일수산정내역폼";
//		Workbook resultWorkbook = transformer.transformXLS(new FileInputStream(xlsRelatvieFilepath), model);
//
//		StringBuffer contentDisposition = new StringBuffer();
//		contentDisposition.append("attachment;fileName=\"");
//		contentDisposition.append(SmrmfUtils.encodeFileName(destFileName + ".xls"));
//		contentDisposition.append("\";");
//		 
//		response.setHeader("Content-Disposition", contentDisposition.toString());
//	 	response.setContentType("application/x-msexcel");
//		resultWorkbook.write(response.getOutputStream());
//              
//        
//    }
	/**
     * 파일을 다운로드 받는다.
     * @param model
     * @param wb
     * @param request
     * @param response
     * @throws Exception
     */
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
	    
		
		String userAgent = request.getHeader("User-Agent");
        boolean ie = userAgent.indexOf("MSIE") > -1;


	
		Map<String, Object> fileInfo = (Map<String, Object>) model.get("fileInfo");		// 넘겨받은 파일 정보
		
		String fileUploadPath = MSFSharedUtils.allowNulls(fileInfo.get("refeFlcos"));	// 파일 업로드 경로
		String fileLogicFlNm = MSFSharedUtils.allowNulls(fileInfo.get("refeOrgFlnm"));	// 파일 논리명(원본파일명)
		String filePhysiclNm = MSFSharedUtils.allowNulls(fileInfo.get("refeFlnm"));		// 파일 물리명(저장된파일명)	
		
		int pst = fileLogicFlNm.lastIndexOf(".");
		filePhysiclNm = filePhysiclNm + "." + fileLogicFlNm.substring(pst + 1);
		
		String fileName = "";
		// TODO 파일경로 못가져왔을 때 넣어주는 로직 필요
		
		
		File file = new File(fileUploadPath, filePhysiclNm);
		
		// 한글 깨짐 현상 방지
		if(userAgent.contains("MSIE") || userAgent.contains("Trident")) {
			fileName = URLEncoder.encode(fileLogicFlNm, "UTF-8").replaceAll("\\\\", "%20");
			response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ";");
		} else {
			fileName = new String(fileLogicFlNm.getBytes("UTF-8"),"ISO-8859-1" );
			response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
			
		}
		
//		 if(ie) {
//	            fileName = URLEncoder.encode(fileLogicFlNm, "UTF-8");
//		 } else {
//	            fileName = new String(fileLogicFlNm.getBytes("UTF-8"), "iso-8859-1");
//		 }

		
		response.setContentType(getContentType());
		response.setContentLength((int) file.length());
//		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");

		
		OutputStream out = response.getOutputStream();
		 
        FileInputStream fis = null;
 
        try {
            fis = new FileInputStream(file);
            FileCopyUtils.copy(fis, out);
        } finally {
            if(fis != null)
                try {
                    fis.close();
                    
                } catch(IOException ex) {
                	
                }
        }
        
        out.flush();

	}
     
    
}
