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

public class Insr3150ExcelView extends AbstractExcelView {

    
//	protected void buildExcelDocument(	Map<String, Object> model
//			  ,	HSSFWorkbook wb
//			  , HttpServletRequest request
//			  , HttpServletResponse response
//			 ) throws Exception {
//final HashMap<String, String> globals = MSFServerUtils.getLocalidedMessages(  RemoteServiceUtil.getThreadLocalConfig()
//															, RemoteServiceUtil.getThreadLocalRequest()
//														   );
//
//		XLSTransformer transformer = new XLSTransformer();
//		
//		String realPath = request.getSession().getServletContext().getRealPath("");
//		String xlsRelatvieFilepath =   realPath.concat("/".concat(globals.get("PayGen.XLSTemplateLink")).concat("/INSR/UPXLS_INSR3150.xls"));
//		
//		String destFileName = "국민연금월별대사";
//		Workbook resultWorkbook = transformer.transformXLS(new FileInputStream(xlsRelatvieFilepath), model);
//		
//		StringBuffer contentDisposition = new StringBuffer();
//		contentDisposition.append("attachment;fileName=\"");
//		contentDisposition.append(SmrmfUtils.encodeFileName(destFileName + ".xls"));
//		contentDisposition.append("\";");
//		
//		response.setHeader("Content-Disposition", contentDisposition.toString());
//		response.setContentType("application/x-msexcel");
//		resultWorkbook.write(response.getOutputStream());
//	
//}
	
	/**
     * 엑셀파일을 설정하고 생성한다.
     * @param model
     * @param wb
     * @param request
     * @param response
     * @throws Exception
     */
 /*   @Override
    protected void buildExcelDocument(Map<String, Object> model,
            HSSFWorkbook wb, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        HSSFCell cell = null;
        int i = 0; 
        HSSFSheet sheet = wb.createSheet("국민연금월별대사");
        sheet.setDefaultColumnWidth((short) 20);
  	 	 			 	 
        // put text in first cell
        cell = getCell(sheet, 0, 0);
        setText(cell, "국민연금월별대사");
         
        setText(getCell(sheet, 1, 0), "일련번호");
        setText(getCell(sheet, 1, 1), "고용구분");
        setText(getCell(sheet, 1, 2), "부서");
        setText(getCell(sheet, 1, 3), "성명");
        setText(getCell(sheet, 1, 4), "주민등록번호"); 
        setText(getCell(sheet, 1, 5), "국민연금공제년월");
        setText(getCell(sheet, 1, 6), "반영여부");
        setText(getCell(sheet, 1, 7), "국민연금번호");
        setText(getCell(sheet, 1, 8), "국민연금급여산출금액");
        setText(getCell(sheet, 1, 9), "공단연금산출금액");
        setText(getCell(sheet, 1, 10), "산출금액차액");
        
         
       
        List listInsr4200 = (List) model.get("listInsr4200");
        
        System.out.println("listInsr4100========================"+listInsr4200);
        
        Iterator<Map<String, Object>> iter =  listInsr4200.iterator();
        
         while ( iter.hasNext() ) {
              Map<String, Object> lstMap = (Map<String, Object>) iter.next();
            

  
                cell = getCell(sheet, 2 + i, 0);
                setText(cell, Integer.toString(i+1));
                cell = getCell(sheet, 2 + i, 1);
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("emymtDivNm")) );  *//** column 고용구분 : emymtDivNm *//*
                cell = getCell(sheet, 2 + i, 2);
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("deptNm")));   *//** column 부서 : deptNm *//*
                cell = getCell(sheet, 2 + i, 3);
                setText(cell,MSFSharedUtils.allowNulls(lstMap.get("hanNm")) );    *//** column 성명 : nm *//*
                cell = getCell(sheet, 2 + i, 4);
                setText(cell,MSFSharedUtils.allowNulls(lstMap.get("resnRegnNum")));  *//** column 주민등록번호 : resnRegnNum *//*
                cell = getCell(sheet, 2 + i, 5); 
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("natPayrDducYrMnth")));  *//** column 국민연금급여공제년월	natPayrDducYrMnth *//*
                cell = getCell(sheet, 2 + i, 6);
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("natInsrPrcsYn")));  *//** column 반영여부 : natInsrPrcsYn *//* 
                cell = getCell(sheet, 2 + i, 7);
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("natPennSymNum")));   *//** column 국민연금번호 : natPennSymNum *//*
                cell = getCell(sheet, 2 + i, 8);
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("natPennPayCalcSum")));   *//** column 연금급여산출보험금액 : natPennPayCalcSum *//* 
                cell = getCell(sheet, 2 + i, 9);
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("aggr")));  *//** column 공단연금산출금액 : aggr *//*
                cell = getCell(sheet, 2 + i, 10);
                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("natInsrPrmmSrd")));  *//** column 산출금액차액 : natInsrPrmmSrd *//*

              
                i = i + 1;
        }
        
    } */
     

	@Override
	protected void buildExcelDocument(	Map<String, Object> model
									  ,	HSSFWorkbook wb
									  , HttpServletRequest request
									  , HttpServletResponse response
									 ) throws Exception {
		final HashMap<String, String> globals = MSFServerUtils.getLocalidedMessages(  RemoteServiceUtil.getThreadLocalConfig()
																					, RemoteServiceUtil.getThreadLocalRequest()
																				   );

		XLSTransformer transformer = new XLSTransformer();

		String realPath = request.getSession().getServletContext().getRealPath("");
		String xlsRelatvieFilepath =   realPath.concat("/".concat(globals.get("PayGen.XLSTemplateLink")).concat("/INSR/UPXLS_INSR3150.xls"));
		
		String destFileName = "월정산대사리스트";
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
