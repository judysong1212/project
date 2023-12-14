package org.msf.exterms.remt.xls.web;

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

public class Remt0300ExcelView extends AbstractExcelView {

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
      	String xlsRelatvieFilepath =   realPath.concat("/".concat(globals.get("PayGen.XLSTemplateLink")).concat("/REMT/XLS_REMT0300.xls"));
      
		String destFileName = "퇴직금지급내역" ;
		Workbook resultWorkbook = transformer.transformXLS(new FileInputStream(xlsRelatvieFilepath), model);

		StringBuffer contentDisposition = new StringBuffer();
		contentDisposition.append("attachment;fileName=\"");
		contentDisposition.append(SmrmfUtils.encodeFileName(destFileName + ".xls"));
		contentDisposition.append("\";");
		 
		response.setHeader("Content-Disposition", contentDisposition.toString());
	 	response.setContentType("application/x-msexcel");
		resultWorkbook.write(response.getOutputStream());
		
//        HSSFCell cell = null;
//         
//        HSSFSheet sheet = wb.createSheet("퇴직금지급내역");
//        sheet.setDefaultColumnWidth((short) 20);
// 
//        // put text in first cell
//        cell = getCell(sheet, 0, 0);
//        setText(cell, "퇴직금지급내역");
//         
//        // set header information
//        setText(getCell(sheet, 2, 0), "번호");
//        setText(getCell(sheet, 2, 1), "귀속년월");
//        setText(getCell(sheet, 2, 2), "정산구분"); 
//        setText(getCell(sheet, 2, 3), "부서"); 
//        setText(getCell(sheet, 2, 4), "성명");
//        setText(getCell(sheet, 2, 5), "주민등록번호"); 
//        setText(getCell(sheet, 2, 6), "과세퇴직금");
//        setText(getCell(sheet, 2, 7), "비과세퇴직금"); 
//        setText(getCell(sheet, 2, 8), "입사일자");
//        setText(getCell(sheet, 2, 9), "기산일자");
//        setText(getCell(sheet, 2, 10), "퇴사일자");
//        setText(getCell(sheet, 2, 11), "지급일자");
//        setText(getCell(sheet, 2, 12), "소득세");
//        setText(getCell(sheet, 2, 13), "지방소득세"); 
//  
//        List  listRemt0300 = (List) model.get("listRemt0300");
//   
//        for (int i = 0; i < listRemt0300.size(); i++) {
//       
//        	Remt3100BM bmRemt3100 = new Remt3100BM();
//              Map tempMap = (Map)listRemt0300.get(i);
//              Iterator<String> keys = tempMap.keySet().iterator();
//              while( keys.hasNext() ){
//                  String key = keys.next();
//                  //형 타입이 숫자형일경우 형변환 해준다.
//                  if(tempMap.get(key) instanceof java.math.BigDecimal){
//                	  bmRemt3100.set(key, String.valueOf(tempMap.get(key)));
//                  }else{
//                	  bmRemt3100.set(key, tempMap.get(key));
//                  }
//              }
//   
//              
//                cell = getCell(sheet, 3 + i, 0);
//                setText(cell, String.valueOf(i + 1));
//                cell = getCell(sheet, 3 + i, 1);
//                setText(cell,bmRemt3100.getCalcSevePsnBlggYrMnth()); /* 귀속년월 */ 
//                cell = getCell(sheet, 3 + i, 2);
//                setText(cell,bmRemt3100.getCalcSevePayPsnDivNm());  /** 정산구분 */
//                cell = getCell(sheet, 3 + i, 3);
//                setText(cell, bmRemt3100.getDeptNm());  /** 부서                 */
//                cell = getCell(sheet, 3 + i, 4);
//                setText(cell, bmRemt3100.getHanNm() );  /** 성명                 */
//                cell = getCell(sheet, 3 + i, 5); 
//                setText(cell, bmRemt3100.getResnRegnNum());  /** 주민등록번호  */ 
//                
//                cell = getCell(sheet, 3 + i, 6);
//                setText(cell, String.valueOf( bmRemt3100.getClutRetryPayQnty()) ); 
////                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
////                cell.setCellValue(bmRemt3100.getClutRetryPayQnty()); /**  퇴직금액 */ 
//                
//                cell = getCell(sheet, 3 + i, 7);
//                setText(cell, String.valueOf(bmRemt3100.getClutTxtnTgtRetryPayQnty() ) ); 
////                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
////                cell.setCellValue(bmRemt3100.getClutTxtnTgtRetryPayQnty()); /**  비과세금액 */ 
//                
//                
//                cell = getCell(sheet, 3 + i, 8);
//                setText(cell, bmRemt3100.getEndIcncDt());   /** 입사일자 */
//
//                cell = getCell(sheet, 3 + i, 9);
//                setText(cell, bmRemt3100.getClutRkfcdDt());   /** 기산일자 */  
//              
//                
//                cell = getCell(sheet, 3 + i, 10);
//                setText(cell, bmRemt3100.getClutRsgtnDt());   /** 퇴직일자 */  
//              
//
//                cell = getCell(sheet, 3 + i, 11);
//                setText(cell, bmRemt3100.getEndPymtDt());   /** 지급일자 */  
//              
//                cell = getCell(sheet, 3 + i, 12);
//                setText(cell, String.valueOf(bmRemt3100.getPymtRegTgtIncmTxQnty() ) ); 
////                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
////                cell.setCellValue(bmRemt3100.getPymtRegTgtIncmTxQnty()); /**  소득세 */ 
//                
//                cell = getCell(sheet, 3 + i, 13);
//                setText(cell, String.valueOf(bmRemt3100.getPymtRegTgtRgonIncmQnty() ) ); 
////                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
////                cell.setCellValue(bmRemt3100.getPymtRegTgtRgonIncmQnty()); /**  지방소득세 */ 
//                
//               
//              
//        }
        
    }
     
    
}
