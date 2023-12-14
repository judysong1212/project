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

public class Psnl0600ExcelView06 extends AbstractExcelView {

    /**
     * 엑셀파일을 설정하고 생성한다.
     * @param model
     * @param wb
     * @param request
     * @param response
     * @throws Exception
     */
//    @Override
//    protected void buildExcelDocument(Map<String, Object> model,
//            HSSFWorkbook wb, HttpServletRequest request,
//            HttpServletResponse response) throws Exception {
//        
//        HSSFCell cell = null;
//         
//        HSSFSheet sheet = wb.createSheet("인사통합기본정보");
//        sheet.setDefaultColumnWidth((short) 20);
// 
//        // put text in first cell
//        cell = getCell(sheet, 0, 0);
//        setText(cell, "인사통합기본리스트");
//         
//        // set header information
//        setText(getCell(sheet, 2, 0), "번호");
//        setText(getCell(sheet, 2, 1), "소속부서");
//        setText(getCell(sheet, 2, 2), "관리부서");
//        setText(getCell(sheet, 2, 3), "고용구분");
//        setText(getCell(sheet, 2, 4), "성명");
//        setText(getCell(sheet, 2, 5), "주민등록번호");
//        setText(getCell(sheet, 2, 6), "직종");
//        setText(getCell(sheet, 2, 7), "직종세");
//        setText(getCell(sheet, 2, 8), "사업");
//        setText(getCell(sheet, 2, 9), "재직");
//        setText(getCell(sheet, 2, 10), "최초고용일자");
//        setText(getCell(sheet, 2, 11), "현부서발령일자");
//        setText(getCell(sheet, 2, 12), "퇴직일자");
//        setText(getCell(sheet, 2, 13), "근무년수");
//        setText(getCell(sheet, 2, 14), "근무월수");
//        setText(getCell(sheet, 2, 15), "장애구분");
//        setText(getCell(sheet, 2, 16), "도로명주소");
//        setText(getCell(sheet, 2, 17), "전화번호");
//        setText(getCell(sheet, 2, 18), "핸드폰");
//        setText(getCell(sheet, 2, 19), "이메일");
//        setText(getCell(sheet, 2, 20), "비 고");  
//  
//        List  listPsnl0600 = (List) model.get("listPsnl0600");
//  
// 
//        for (int i = 0; i < listPsnl0600.size(); i++) {
//       
//              Psnl0600DTO dto = new Psnl0600DTO();
//              Map tempMap = (Map)listPsnl0600.get(i);
//              Iterator<String> keys = tempMap.keySet().iterator();
//              while( keys.hasNext() ){
//                  String key = keys.next();
//                  //형 타입이 숫자형일경우 형변환 해준다.
//                  if(tempMap.get(key) instanceof java.math.BigDecimal){
//                      dto.set(key, String.valueOf(tempMap.get(key)));
//                  }else{
//                      dto.set(key, tempMap.get(key));
//                  }
//              }
//  
//                cell = getCell(sheet, 3 + i, 0);
//                setText(cell, dto.getRnum());
//                cell = getCell(sheet, 3 + i, 1);
//                setText(cell,dto.getCurrDeptNm());  /** 소속부서 */
//                cell = getCell(sheet, 3 + i, 2);
//                setText(cell, dto.getDeptNm());   /** 관리부서 */  
//                cell = getCell(sheet, 3 + i, 3);
//                setText(cell,dto.getEmymtDivNm() );    /** 고용구분                 */
//                cell = getCell(sheet, 3 + i, 4);
//                setText(cell, dto.getHanNm());  /** 성명                 */
//                cell = getCell(sheet, 3 + i, 5); 
//                setText(cell, dto.getResnRegnNum());   /** 주민등록번호 */
//               
//                cell = getCell(sheet, 3 + i, 6);
//                setText(cell, dto.getTypeOccuNm());  /** 직종 */
//                cell = getCell(sheet, 3 + i, 7);
//                setText(cell, dto.getDtilOccuClsDivNm());   /** 직종세 */
//                cell = getCell(sheet, 3 + i, 8);
//                setText(cell, dto.getBusinNm());    /** 사업 */   
//                cell = getCell(sheet, 3 + i, 9);
//                setText(cell, dto.getHdofcCodtnNm());   /** 재직구분 */
//                cell = getCell(sheet, 3 + i, 10);
//                setText(cell, dto.getFrstEmymtDt());   /** 최초고용일자 */
//                cell = getCell(sheet, 3 + i, 11);
//                setText(cell, dto.getCurrDeptAppmtDt());    /** 현부서발령일자 */
//                cell = getCell(sheet, 3 + i, 12);
//                setText(cell, dto.getRetryDt());            /** 퇴직일자 */
//                cell = getCell(sheet, 3 + i, 13);
//                setText(cell, dto.getLogSvcYrNumNm());        /** 근무년수 */
//                cell = getCell(sheet, 3 + i, 14);
//                setText(cell, dto.getLogSvcMnthIcmNm());     /** 근무월수 */
//                cell = getCell(sheet, 3 + i, 15);
//                setText(cell, dto.getDabtyDivNm());    /** 장애구분 */
//                cell = getCell(sheet, 3 + i, 16);
//                setText(cell, dto.getAddr());        /** 도로명주소 */
//                cell = getCell(sheet, 3 + i, 17);
//                setText(cell, dto.getHusPhnNum());   /** 전화번호 */
//                cell = getCell(sheet, 3 + i, 18);
//                setText(cell, dto.getCellPhneNum());   /** 핸드폰 */ 
//                cell = getCell(sheet, 3 + i, 19);
//                setText(cell, dto.getEmailAddr());   /** 이메일 */
//                cell = getCell(sheet, 3 + i, 20);
//                setText(cell, dto.getPernNoteCtnt());    /** 비고 */    
//              
//        }
//        
//    }
    
    
    /**
     * 엑셀파일을 설정하고 생성한다._jxls
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
      	String xlsRelatvieFilepath =   realPath.concat("/".concat(globals.get("PayGen.XLSTemplateLink")).concat("/PSNL/XLS_PSNL060006.xls"));
      
		String destFileName = "인사통합자격정보";
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
