package org.msf.exterms.xls.web;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
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

public class PayrHoJo4400ExcelView extends AbstractExcelView {

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
        
    	// 파일 이름 중복 방지
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    	String rndName = sdf.format(new java.util.Date()); 
    	
	    final HashMap<String, String> globals = MSFServerUtils.getLocalidedMessages(RemoteServiceUtil.getThreadLocalConfig(), RemoteServiceUtil.getThreadLocalRequest());   
      	
    	XLSTransformer transformer = new XLSTransformer();
        
      	String realPath = request.getSession().getServletContext().getRealPath(""); 
      	String xlsRelatvieFilepath =   realPath.concat("/".concat(globals.get("PayGen.XLSTemplateLink")).concat("/PAYR/XLS_PAYR4400.xls"));
      
		String destFileName = "거래처입력폼연계파일_".concat(rndName) ;
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
//        HSSFSheet sheet = wb.createSheet("급여지로이체명세");
//        sheet.setDefaultColumnWidth((short) 20);
// 
//        // put text in first cell
//      //  cell = getCell(sheet, 0, 0);
//      //  setText(cell, "급여지로이체명세");
//         
//        // set header information
//        setText(getCell(sheet, 2, 0), "번호");
//        setText(getCell(sheet, 2, 1), "소속부서"); 
//        setText(getCell(sheet, 2, 2), "부서"); 
//        setText(getCell(sheet, 2, 3), "은행코드");
//        setText(getCell(sheet, 2, 4), "은행명");
//        setText(getCell(sheet, 2, 5), "예금주");
//        setText(getCell(sheet, 2, 6), "계좌번호"); 
//        setText(getCell(sheet, 2, 7), "입금액");
//        setText(getCell(sheet, 2, 8), "성명");
//        setText(getCell(sheet, 2, 9), "주민등록번호");
// 
//  
//        List  listHoJoPayr4400 = (List) model.get("listHoJoPayr4400");
//   
//        for (int i = 0; i < listHoJoPayr4400.size(); i++) {
//       
//              Payr0301BM bmpayr0301 = new Payr0301BM();
//              Map tempMap = (Map)listHoJoPayr4400.get(i);
//              Iterator<String> keys = tempMap.keySet().iterator();
//              while( keys.hasNext() ){
//                  String key = keys.next();
//                  //형 타입이 숫자형일경우 형변환 해준다.
//                  if(tempMap.get(key) instanceof java.math.BigDecimal){
//                      bmpayr0301.set(key, String.valueOf(tempMap.get(key)));
//                  }else{
//                      bmpayr0301.set(key, tempMap.get(key));
//                  }
//              }
//  
//                cell = getCell(sheet, 3 + i, 0);
//                setText(cell, String.valueOf(i + 1));
//                cell = getCell(sheet, 3 + i, 1);
//                setText(cell,bmpayr0301.getPayrMangDeptNm()); /*PAYR_MANG_DEPT_NM 소속부서 */ 
//                cell = getCell(sheet, 3 + i, 2);
//                setText(cell,bmpayr0301.getDeptNm());  /** 부서 */
//                cell = getCell(sheet, 3 + i, 3);
//                setText(cell, bmpayr0301.getBnkCd());  /** 은행코드                 */
//                cell = getCell(sheet, 3 + i, 4);
//                setText(cell, bmpayr0301.getBnkNm());  /** 은행명                 */
//                cell = getCell(sheet, 3 + i, 5); 
//                setText(cell, bmpayr0301.getAcntHodrNm());  /** 예금주 */ 
//                cell = getCell(sheet, 3 + i, 6);
//                setText(cell, bmpayr0301.getBnkAccuNum());   /** 계좌번호 */
//                
//                cell = getCell(sheet, 3 + i, 7);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(bmpayr0301.getPernPymtSum()); /** 입금액 */ 
//                
//                cell = getCell(sheet, 3 + i, 8);
//                setText(cell, bmpayr0301.getHanNm());   /** 성명 */  
//                cell = getCell(sheet, 3 + i, 9);
//                setText(cell,bmpayr0301.getResnRegnNum() );    /** 주민등록번호                 */
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
