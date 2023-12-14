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

public class Remt0150ExcelView extends AbstractExcelView {

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
      	String xlsRelatvieFilepath =   realPath.concat("/".concat(globals.get("PayGen.XLSTemplateLink")).concat("/REMT/XLS_REMT0150.xls"));
      
		String destFileName = "퇴직금산정내역" ;
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
//        HSSFSheet sheet = wb.createSheet("퇴직금산정내역");
//        sheet.setDefaultColumnWidth((short) 20);
// 
//        // put text in first cell
//        cell = getCell(sheet, 0, 0);
//        setText(cell, "퇴직금산정내역");
//         
//        // set header information
//        setText(getCell(sheet, 2, 0), "번호");
//        setText(getCell(sheet, 2, 1), "정산년월");
//        setText(getCell(sheet, 2, 2), "정산구분"); 
//        setText(getCell(sheet, 2, 3), "부서"); 
//        setText(getCell(sheet, 2, 4), "직종");
//        setText(getCell(sheet, 2, 5), "성명");
//        setText(getCell(sheet, 2, 6), "입사일자");
//        setText(getCell(sheet, 2, 7), "퇴직일자"); 
//        setText(getCell(sheet, 2, 8), "총근속일수");
//        setText(getCell(sheet, 2, 9), "퇴직금액");
//        setText(getCell(sheet, 2, 10), "비과세금액");
//        setText(getCell(sheet, 2, 11), "소득세");
//        setText(getCell(sheet, 2, 12), "지방소득세");
//        setText(getCell(sheet, 2, 13), "공제금액");
//        setText(getCell(sheet, 2, 14), "실지금액");
//  
//        List  listRemt0150 = (List) model.get("listRemt0150");
//   
//        for (int i = 0; i < listRemt0150.size(); i++) {
//       
//        	  Remt2000BM bmRemt2000 = new Remt2000BM();
//              Map tempMap = (Map)listRemt0150.get(i);
//              Iterator<String> keys = tempMap.keySet().iterator();
//              while( keys.hasNext() ){
//                  String key = keys.next();
//                  //형 타입이 숫자형일경우 형변환 해준다.
//                  if(tempMap.get(key) instanceof java.math.BigDecimal){
//                	  bmRemt2000.set(key, String.valueOf(tempMap.get(key)));
//                  }else{
//                	  bmRemt2000.set(key, tempMap.get(key));
//                  }
//              }
//   
//              
//                cell = getCell(sheet, 3 + i, 0);
//                setText(cell, String.valueOf(i + 1));
//                cell = getCell(sheet, 3 + i, 1);
//                setText(cell,bmRemt2000.getClutYrMnth()); /* 정산년월 */ 
//                cell = getCell(sheet, 3 + i, 2);
//                setText(cell,bmRemt2000.getCalcSevePayPsnDivNm());  /** 정산구분 */
//                cell = getCell(sheet, 3 + i, 3);
//                setText(cell, bmRemt2000.getDeptNm());  /** 부서                 */
//                cell = getCell(sheet, 3 + i, 4);
//                setText(cell, bmRemt2000.getTypOccuNm() );  /** 직종                 */
//                cell = getCell(sheet, 3 + i, 5); 
//                setText(cell, bmRemt2000.getNm());  /** 성명 */ 
//                cell = getCell(sheet, 3 + i, 6);
//                setText(cell, bmRemt2000.getIcncDt());   /** 입사일자 */
//                
//                
//                cell = getCell(sheet, 3 + i, 7);
//                setText(cell, bmRemt2000.getRetryDt());   /** 퇴직일자 */  
//              
//
//                cell = getCell(sheet, 3 + i, 8);
//                setText(cell, String.valueOf(bmRemt2000.getTotLogSvcNumDys()) );  
////                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
////                cell.setCellValue(bmRemt2000.getTotLogSvcNumDys()); /**  총근속일수 */ 
//                
//                cell = getCell(sheet, 3 + i, 9);
//                setText(cell, String.valueOf(bmRemt2000.getSevePayPymtSum()) ); 
////                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
////                cell.setCellValue(bmRemt2000.getSevePayPymtSum()); /**  퇴직금액 */ 
//                
//                cell = getCell(sheet, 3 + i, 10);
//                setText(cell, String.valueOf(bmRemt2000.getSevePayCmpttnFreeDtySum()) ); 
////                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
////                cell.setCellValue(bmRemt2000.getSevePayCmpttnFreeDtySum()); /**  비과세금액 */ 
//                
//                cell = getCell(sheet, 3 + i, 11);
//                setText(cell,String.valueOf(bmRemt2000.getPymtSubtnIncmTxQnty())  ); 
////                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
////                cell.setCellValue(bmRemt2000.getPymtSubtnIncmTxQnty()); /**  소득세 */ 
//                
//                cell = getCell(sheet, 3 + i, 12);
//                setText(cell, String.valueOf(bmRemt2000.getPymtSubtnRgonIncmTxQnty()) ); 
////                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
////                cell.setCellValue(bmRemt2000.getPymtSubtnRgonIncmTxQnty()); /**  지방소득세 */ 
//                
//                cell = getCell(sheet, 3 + i, 13);
//                setText(cell, String.valueOf(bmRemt2000.getSevePayPymtDducSum()) ); 
////                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
////                cell.setCellValue(bmRemt2000.getSevePayPymtDducSum()); /**  공제금액 */ 
//                
//                cell = getCell(sheet, 3 + i, 14);
//                setText(cell, String.valueOf(bmRemt2000.getSevePayTurtyPymtSum()) ); 
////                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
////                cell.setCellValue(bmRemt2000.getSevePayTurtyPymtSum()); /**  실지금액 */ 
//                
////                cell = getCell(sheet, 3 + i, 8);
////                setText(cell, dto.getBusinNm());    /** 사업 */   
////                cell = getCell(sheet, 3 + i, 9);
////                setText(cell, dto.getHdofcCodtnNm());   /** 재직구분 */
////                cell = getCell(sheet, 3 + i, 10);
////                setText(cell, dto.getFrstEmymtDt());   /** 최초고용일자 */
////                cell = getCell(sheet, 3 + i, 11);
////                setText(cell, dto.getCurrDeptAppmtDt());    /** 현부서발령일자 */
////                cell = getCell(sheet, 3 + i, 12);
////                setText(cell, dto.getRetryDt());    /** 퇴직일자 */
////                cell = getCell(sheet, 3 + i, 13);
////                setText(cell, dto.getLogSvcYrNumNm());     /** 근무년수 */
////                cell = getCell(sheet, 3 + i, 14);
////                setText(cell, dto.getDabtyDivNm());    /** 장애구분 */
////                cell = getCell(sheet, 3 + i, 15);
////                setText(cell, dto.getAddr());                                     /** 도로명주소 */
////                cell = getCell(sheet, 3 + i, 16);
////                setText(cell, dto.getHusPhnNum());   /** 전화번호 */
////                cell = getCell(sheet, 3 + i, 17);
////                setText(cell, dto.getCellPhneNum());   /** 핸드폰 */ 
////                cell = getCell(sheet, 3 + i, 18);
////                setText(cell, dto.getEmailAddr());   /** 이메일 */
////                cell = getCell(sheet, 3 + i, 19);
////                setText(cell, dto.getPernNoteCtnt());    /** 비고 */    
//              
//        }
        
    } 
  
}
