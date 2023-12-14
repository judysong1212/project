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

public class Payr4220ExcelView extends AbstractExcelView {

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
      	String xlsRelatvieFilepath =   realPath.concat("/".concat(globals.get("PayGen.XLSTemplateLink")).concat("/REMT/XLS_PAYR4220.xls"));
      
		String destFileName = "월별급여소급내역상세" ;
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
//        Boolean boolWrite = true;
//        
//        HSSFSheet sheet = wb.createSheet("급여지급명세서(개인별)");
//        sheet.setDefaultColumnWidth((short) 20);
// 
//        // put text in first cell
//        cell = getCell(sheet, 0, 0);
//        setText(cell, "급여지급명세서(개인별)");
//         
//  
//        List<Payr4200VO>  listPayr4200 = (List<Payr4200VO>) model.get("listPayr4200");
//  
// 
//        for (int i = 0; i < listPayr4200.size(); i++) {
//        
//              Payr4200VO payr4200Vo = new Payr4200VO();
//              payr4200Vo = (Payr4200VO)listPayr4200.get(i);
//              
//              if (boolWrite) {
//
//                  // set header information
//                  setText(getCell(sheet, 2, 0), "번호");
//                  setText(getCell(sheet, 2, 1), "지급년월"); 
//                  setText(getCell(sheet, 2, 2), "부서"); 
//                  setText(getCell(sheet, 2, 3), "성명");
//                  setText(getCell(sheet, 2, 4), "주민등록번호");
//                  setText(getCell(sheet, 2, 5), payr4200Vo.getPayItemNm01());
//                  setText(getCell(sheet, 2, 6), payr4200Vo.getPayItemNm02());
//                  setText(getCell(sheet, 2, 7), payr4200Vo.getPayItemNm03()); 
//                  setText(getCell(sheet, 2, 8), payr4200Vo.getPayItemNm04());
//                  setText(getCell(sheet, 2, 9), payr4200Vo.getPayItemNm05());
//                  setText(getCell(sheet, 2, 10), payr4200Vo.getPayItemNm06());
//                  setText(getCell(sheet, 2, 11), payr4200Vo.getPayItemNm07()); 
//                  setText(getCell(sheet, 2, 12), payr4200Vo.getPayItemNm08());
//                  setText(getCell(sheet, 2, 13), payr4200Vo.getPayItemNm09());
//                  setText(getCell(sheet, 2, 14), payr4200Vo.getPayItemNm10());
//                  setText(getCell(sheet, 2, 15), payr4200Vo.getPayItemNm11()); 
//                  setText(getCell(sheet, 2, 16), payr4200Vo.getPayItemNm12());
//                  setText(getCell(sheet, 2, 17), payr4200Vo.getPayItemNm13());
//                  setText(getCell(sheet, 2, 18), payr4200Vo.getPayItemNm14());
//                  setText(getCell(sheet, 2, 19), payr4200Vo.getPayItemNm15()); 
//                  setText(getCell(sheet, 2, 20), payr4200Vo.getPayItemNm16());
//                  setText(getCell(sheet, 2, 21), payr4200Vo.getPayItemNm17());
//                  setText(getCell(sheet, 2, 22), payr4200Vo.getPayItemNm18());
//                  setText(getCell(sheet, 2, 23), payr4200Vo.getPayItemNm19()); 
//                  setText(getCell(sheet, 2, 24), payr4200Vo.getPayItemNm20());
//                  setText(getCell(sheet, 2, 25), payr4200Vo.getPayItemNm21());
//                  setText(getCell(sheet, 2, 26), payr4200Vo.getPayItemNm22());
//                  setText(getCell(sheet, 2, 27), payr4200Vo.getPayItemNm23()); 
//                  setText(getCell(sheet, 2, 28), payr4200Vo.getPayItemNm24());
//                  setText(getCell(sheet, 2, 29), payr4200Vo.getPayItemNm25());
//                  setText(getCell(sheet, 2, 30), payr4200Vo.getPayItemNm26());
//                  setText(getCell(sheet, 2, 31), payr4200Vo.getPayItemNm27()); 
//                  setText(getCell(sheet, 2, 32), payr4200Vo.getPayItemNm28());
//                  setText(getCell(sheet, 2, 33), payr4200Vo.getPayItemNm29());
//                  setText(getCell(sheet, 2, 34), payr4200Vo.getPayItemNm30());
//                  setText(getCell(sheet, 2, 35), payr4200Vo.getPayItemNm31()); 
//                  setText(getCell(sheet, 2, 36), payr4200Vo.getPayItemNm32());
//                  setText(getCell(sheet, 2, 37), payr4200Vo.getPayItemNm33());
//                  setText(getCell(sheet, 2, 38), payr4200Vo.getPayItemNm34());
//                  setText(getCell(sheet, 2, 39), payr4200Vo.getPayItemNm35()); 
//                  setText(getCell(sheet, 2, 40), payr4200Vo.getPayItemNm36());
//                  setText(getCell(sheet, 2, 41), payr4200Vo.getPayItemNm37());
//                  setText(getCell(sheet, 2, 42), payr4200Vo.getPayItemNm38());
//                  setText(getCell(sheet, 2, 43), payr4200Vo.getPayItemNm39()); 
//                  setText(getCell(sheet, 2, 44), payr4200Vo.getPayItemNm40());
//                  setText(getCell(sheet, 2, 45), payr4200Vo.getPayItemNm41());
//                  setText(getCell(sheet, 2, 46), payr4200Vo.getPayItemNm42());
//                  setText(getCell(sheet, 2, 47), payr4200Vo.getPayItemNm43()); 
//                  setText(getCell(sheet, 2, 48), payr4200Vo.getPayItemNm44());
//                  setText(getCell(sheet, 2, 49), payr4200Vo.getPayItemNm45());
//                  setText(getCell(sheet, 2, 50), payr4200Vo.getPayItemNm46());
//                  setText(getCell(sheet, 2, 51), payr4200Vo.getPayItemNm47()); 
//                  setText(getCell(sheet, 2, 52), payr4200Vo.getPayItemNm48());
//                  setText(getCell(sheet, 2, 53), payr4200Vo.getPayItemNm49());
//                  setText(getCell(sheet, 2, 54), payr4200Vo.getPayItemNm50());
//                  setText(getCell(sheet, 2, 55), payr4200Vo.getPayItemNm51()); 
//                  setText(getCell(sheet, 2, 56), payr4200Vo.getPayItemNm52());
//                  setText(getCell(sheet, 2, 57), payr4200Vo.getPayItemNm53());
//                  setText(getCell(sheet, 2, 58), payr4200Vo.getPayItemNm54());
//                  setText(getCell(sheet, 2, 59), payr4200Vo.getPayItemNm55()); 
//                  setText(getCell(sheet, 2, 60), payr4200Vo.getPayItemNm56());
//                  setText(getCell(sheet, 2, 61), payr4200Vo.getPayItemNm57());
//                  setText(getCell(sheet, 2, 62), payr4200Vo.getPayItemNm58());
//                  setText(getCell(sheet, 2, 63), payr4200Vo.getPayItemNm59()); 
//                  setText(getCell(sheet, 2, 64), payr4200Vo.getPayItemNm60());
//                  setText(getCell(sheet, 2, 65), payr4200Vo.getPayItemNm61());
//                  setText(getCell(sheet, 2, 66), payr4200Vo.getPayItemNm62());
//                  setText(getCell(sheet, 2, 67), payr4200Vo.getPayItemNm63()); 
//                  setText(getCell(sheet, 2, 68), payr4200Vo.getPayItemNm64());
//                  setText(getCell(sheet, 2, 69), payr4200Vo.getPayItemNm65());
//                  setText(getCell(sheet, 2, 70), payr4200Vo.getPayItemNm66());
//                  setText(getCell(sheet, 2, 71), payr4200Vo.getPayItemNm67()); 
//                  setText(getCell(sheet, 2, 72), payr4200Vo.getPayItemNm68());
//                  setText(getCell(sheet, 2, 73), payr4200Vo.getPayItemNm69());
//                  setText(getCell(sheet, 2, 74), payr4200Vo.getPayItemNm70());
//                  setText(getCell(sheet, 2, 75), payr4200Vo.getPayItemNm71()); 
//                  setText(getCell(sheet, 2, 76), payr4200Vo.getPayItemNm72());
//                  setText(getCell(sheet, 2, 77), payr4200Vo.getPayItemNm73());
//                  setText(getCell(sheet, 2, 78), payr4200Vo.getPayItemNm74());
//                  setText(getCell(sheet, 2, 79), payr4200Vo.getPayItemNm75()); 
//                  setText(getCell(sheet, 2, 80), payr4200Vo.getPayItemNm76());
//                  setText(getCell(sheet, 2, 81), payr4200Vo.getPayItemNm77());
//                  setText(getCell(sheet, 2, 82), payr4200Vo.getPayItemNm78());
//                  setText(getCell(sheet, 2, 83), payr4200Vo.getPayItemNm79());  
//                  setText(getCell(sheet, 2, 84), "급여계");  
//                  setText(getCell(sheet, 2, 85), "공제액계");  
//                  setText(getCell(sheet, 2, 86), "차인지급액");  
//                  
//                  boolWrite = false;
//              } 
//   
//                cell = getCell(sheet, 3 + i, 0);
//                setText(cell, String.valueOf(i + 1));
//                cell = getCell(sheet, 3 + i, 1);
//                setText(cell,payr4200Vo.getPymtYrMnth());  /** 지급년월 */
//                cell = getCell(sheet, 3 + i, 2);
//                setText(cell, payr4200Vo.getDeptNm());  /** 부서                 */
//                cell = getCell(sheet, 3 + i, 3); 
//                setText(cell, payr4200Vo.getHanNm());  /** 성명 */ 
//                cell = getCell(sheet, 3 + i, 4);
//                setText(cell, payr4200Vo.getResnRegnNum());   /** 주민번호 */
//                cell = getCell(sheet, 3 + i, 5);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum01().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 6);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum02().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 7);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum03().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 8);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum04().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 9);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum05().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 10);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum06().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 11);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum07().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 12);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum08().toString())); /** 금액 */
//                cell = getCell(sheet, 3 + i, 13);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum09().toString())); /** 금액 */
//                cell = getCell(sheet, 3 + i, 14);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum10().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 15);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum11().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 16);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum12().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 17);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum13().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 18);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum14().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 19);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum15().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 20);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum16().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 21);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum17().toString())); /** 금액 */
//                cell = getCell(sheet, 3 + i, 22);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum18().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 23);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum19().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 24);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum20().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 25);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum21().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 26);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum22().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 27);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum23().toString())); /** 금액 */
//                cell = getCell(sheet, 3 + i, 28);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum24().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 29);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum25().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 30);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum26().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 31);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum27().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 32);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum28().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 33);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum29().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 34);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum30().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 35);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum31().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 36);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum32().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 37);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum33().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 38);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum34().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 39);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum35().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 40);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum36().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 41);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum37().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 42);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum38().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 43);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum39().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 44);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum40().toString())); /** 금액 */
//                cell = getCell(sheet, 3 + i, 45);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum41().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 46);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum42().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 47);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum43().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 48);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum44().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 49);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum45().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 50);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum46().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 51);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum47().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 52);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum48().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 53);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum49().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 54);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum50().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 55);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum51().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 56);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum52().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 57);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum53().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 58);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum54().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 59);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum55().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 60);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum56().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 61);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum57().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 62);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum58().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 63);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum59().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 64);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum60().toString())); /** 금액 */
//                cell = getCell(sheet, 3 + i, 65);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum61().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 66);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum62().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 67);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum63().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 68);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum64().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 69);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum65().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 70);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum66().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 71);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum67().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 72);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum68().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 73);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum69().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 74);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum70().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 75);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum71().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 76);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum72().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 77);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum73().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 78);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum74().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 79);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum75().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 80);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum76().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 81);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum77().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 82);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum78().toString())); /** 금액 */ 
//                cell = getCell(sheet, 3 + i, 83);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtDducSum79().toString())); /** 금액 */ 
//                 
//                cell = getCell(sheet, 3 + i, 84);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPymtTotAmnt().toString())); /** 지급액 */ 
//                
//                cell = getCell(sheet, 3 + i, 85);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getDducTotAmnt().toString())); /** 공제액 */ 
//                
//                cell = getCell(sheet, 3 + i, 86);
//                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
//                cell.setCellValue(Long.parseLong(payr4200Vo.getPernPymtSum().toString())); /** 차인지급액 */ 
//             
//              
//        }
        
    }
     
    
}
