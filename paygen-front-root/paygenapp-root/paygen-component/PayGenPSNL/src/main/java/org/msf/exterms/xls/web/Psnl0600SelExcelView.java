package org.msf.exterms.xls.web;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.msf.utils.SmrmfUtils;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.clipsoft.org.apache.poi.hssf.util.HSSFColor;

import egovframework.rte.psl.dataaccess.util.EgovMap;

public class Psnl0600SelExcelView extends AbstractExcelView {

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
        
    	Boolean styleChk = true;
    	
        HSSFCell cell = null;
       
        HSSFSheet sheet = wb.createSheet("인사통합정보");
        CellStyle style = wb.createCellStyle(); 
        Font font = wb.createFont();
        sheet.setDefaultColumnWidth((short) 20);
 
        // put text in first cell
        cell = getCell(sheet, 0, 0);
        // 								int rowFrom, short colFrom, int rowTo, short colTo
//        sheet.addMergedRegion(new Region(0	,(short)0	,0	,(short)6)); //가로병합
//        font.setBoldweight(Font.BOLDWEIGHT_BOLD);  //글씨 bold
        style.setAlignment(CellStyle.ALIGN_CENTER);
//        style.setAlignment(CellStyle.VERTICAL_CENTER);
//        cell.setCellStyle(style);
//        cell.getRow().setHeight((short)645);
        setText(cell, "인사통합리스트");
        cell.setCellStyle(style);
//       
//        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        
//        64.5 CellStyle style = wb.createCellStyle();

//        style.setBorderBottom(CellStyle.BORDER_THIN); //테두리 두껍게 
//        style.setBorderLeft(CellStyle.BORDER_THIN);
//        style.setBorderRight(CellStyle.BORDER_THIN);
//        style.setBorderTop(CellStyle.BORDER_THIN);
//        style.setAlignment(CellStyle.ALIGN_CENTER);  //가운데 정렬
//        Font font = wb.createFont();
//        font.setBoldweight(Font.BOLDWEIGHT_BOLD);  //글씨 bold

        style = wb.createCellStyle(); 
        style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        
		List listPsnl0600 = (List) model.get("listPsnl0600");
		

		for (int i = 0; i < listPsnl0600.size(); i++) {
			
			EgovMap tempMap = (EgovMap)listPsnl0600.get(i);
			Iterator<String> keys = tempMap.keySet().iterator();
			
			int y = 0;
			
			while( keys.hasNext() ){
              String key = keys.next();
              
              
//              //형 타입이 숫자형일경우 형변환 해준다.
//              if(tempMap.get(key) instanceof java.math.BigDecimal){
            	  
            	  if(i == 0 && y == 0) {
            		  
            			  
                		  cell = getCell(sheet, 2 + i, y);
                		  setText(cell, "순번");
                		  
                		  if(i == 0) {
                			  cell.setCellStyle(style);
                		  }
            			  
            		  
            	  }else {
            		  
            		  cell = getCell(sheet, 2 + i, y);
            		  setText(cell, String.valueOf(MSFSharedUtils.allowNulls(tempMap.get(key))));
            		  
            		  if(i == 0) {
            			  cell.setCellStyle(style);
            		  }
                	  	
            	  }
                  
//              }else{
//            	  cell = getCell(sheet, 2 + i, y);
//            	  setText(cell, String.valueOf(MSFSharedUtils.allowNulls(tempMap.get(key))));
//              }
              
              y++ ;
          }
			
		}
		
		String destFileName = "인사통합정보";
		StringBuffer contentDisposition = new StringBuffer();
		contentDisposition.append("attachment;fileName=\"");
		contentDisposition.append(SmrmfUtils.encodeFileName(destFileName + ".xls"));
		contentDisposition.append("\";");
		
	 	response.setContentType("application/x-msexcel");
		response.setHeader("Content-Disposition", contentDisposition.toString());

        
    }
    
    
}
