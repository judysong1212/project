package org.msf.exterms.yeta2022.xls.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.app.exterms.yearendtax.server.vo.Pyyt0304_2022_VO;

public class Yeta790001ExcelView extends AbstractExcelView {

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
        
        HSSFCell cell = null;

        Boolean boolWrite = true;
        
        HSSFSheet sheet = wb.createSheet("급여지급명세서(개인별)");
        sheet.setDefaultColumnWidth((short) 20);
 
        // put text in first cell
        cell = getCell(sheet, 0, 0);
        setText(cell, "급여지급명세서(개인별)");
         
  
        List<Pyyt0304_2022_VO>  listYeta1900 = (List<Pyyt0304_2022_VO>) model.get("listYeta7900");
  
 
        for (int i = 0; i < listYeta1900.size(); i++) {
        
        	  Pyyt0304_2022_VO pyyt0304Vo = new Pyyt0304_2022_VO();
              pyyt0304Vo = (Pyyt0304_2022_VO)listYeta1900.get(i);
              
              if (boolWrite) {

                  // set header information
                  setText(getCell(sheet, 2, 0), "번호");
                  setText(getCell(sheet, 2, 1), "지급년월"); 
                  setText(getCell(sheet, 2, 2), "부서"); 
                  setText(getCell(sheet, 2, 3), "성명");
                  setText(getCell(sheet, 2, 4), "주민등록번호");
                  setText(getCell(sheet, 2, 5), pyyt0304Vo.getPayItemNm01());
                  setText(getCell(sheet, 2, 6), pyyt0304Vo.getPayItemNm02());
                  setText(getCell(sheet, 2, 7), pyyt0304Vo.getPayItemNm03()); 
                  setText(getCell(sheet, 2, 8), pyyt0304Vo.getPayItemNm04());
                  setText(getCell(sheet, 2, 9), pyyt0304Vo.getPayItemNm05());
                  setText(getCell(sheet, 2, 10), pyyt0304Vo.getPayItemNm06());
                  setText(getCell(sheet, 2, 11), pyyt0304Vo.getPayItemNm07()); 
                  setText(getCell(sheet, 2, 12), pyyt0304Vo.getPayItemNm08());
                  setText(getCell(sheet, 2, 13), pyyt0304Vo.getPayItemNm09());
                  setText(getCell(sheet, 2, 14), pyyt0304Vo.getPayItemNm10());
                  setText(getCell(sheet, 2, 15), pyyt0304Vo.getPayItemNm11()); 
                  setText(getCell(sheet, 2, 16), pyyt0304Vo.getPayItemNm12());
                  setText(getCell(sheet, 2, 17), pyyt0304Vo.getPayItemNm13());
                  setText(getCell(sheet, 2, 18), pyyt0304Vo.getPayItemNm14());
                  setText(getCell(sheet, 2, 19), pyyt0304Vo.getPayItemNm15()); 
                  setText(getCell(sheet, 2, 20), pyyt0304Vo.getPayItemNm16());
                  setText(getCell(sheet, 2, 21), pyyt0304Vo.getPayItemNm17());
                  setText(getCell(sheet, 2, 22), pyyt0304Vo.getPayItemNm18());
                  setText(getCell(sheet, 2, 23), pyyt0304Vo.getPayItemNm19()); 
                  setText(getCell(sheet, 2, 24), pyyt0304Vo.getPayItemNm20());
                  setText(getCell(sheet, 2, 25), pyyt0304Vo.getPayItemNm21());
                  setText(getCell(sheet, 2, 26), pyyt0304Vo.getPayItemNm22());
                  setText(getCell(sheet, 2, 27), pyyt0304Vo.getPayItemNm23()); 
                  setText(getCell(sheet, 2, 28), pyyt0304Vo.getPayItemNm24());
                  setText(getCell(sheet, 2, 29), pyyt0304Vo.getPayItemNm25());
                  setText(getCell(sheet, 2, 30), pyyt0304Vo.getPayItemNm26());
                  setText(getCell(sheet, 2, 31), pyyt0304Vo.getPayItemNm27()); 
                  setText(getCell(sheet, 2, 32), pyyt0304Vo.getPayItemNm28());
                  setText(getCell(sheet, 2, 33), pyyt0304Vo.getPayItemNm29());
                  setText(getCell(sheet, 2, 34), pyyt0304Vo.getPayItemNm30());
                  setText(getCell(sheet, 2, 35), pyyt0304Vo.getPayItemNm31()); 
                  setText(getCell(sheet, 2, 36), pyyt0304Vo.getPayItemNm32());
                  setText(getCell(sheet, 2, 37), pyyt0304Vo.getPayItemNm33());
                  setText(getCell(sheet, 2, 38), pyyt0304Vo.getPayItemNm34());
                  setText(getCell(sheet, 2, 39), pyyt0304Vo.getPayItemNm35()); 
                  setText(getCell(sheet, 2, 40), pyyt0304Vo.getPayItemNm36());
                  setText(getCell(sheet, 2, 41), pyyt0304Vo.getPayItemNm37());
                  setText(getCell(sheet, 2, 42), pyyt0304Vo.getPayItemNm38());
                  setText(getCell(sheet, 2, 43), pyyt0304Vo.getPayItemNm39()); 
                  setText(getCell(sheet, 2, 44), pyyt0304Vo.getPayItemNm40());
                  setText(getCell(sheet, 2, 45), pyyt0304Vo.getPayItemNm41());
                  setText(getCell(sheet, 2, 46), pyyt0304Vo.getPayItemNm42());
                  setText(getCell(sheet, 2, 47), pyyt0304Vo.getPayItemNm43()); 
                  setText(getCell(sheet, 2, 48), pyyt0304Vo.getPayItemNm44());
                  setText(getCell(sheet, 2, 49), pyyt0304Vo.getPayItemNm45());
                  setText(getCell(sheet, 2, 50), pyyt0304Vo.getPayItemNm46());
                  setText(getCell(sheet, 2, 51), pyyt0304Vo.getPayItemNm47()); 
                  setText(getCell(sheet, 2, 52), pyyt0304Vo.getPayItemNm48());
                  setText(getCell(sheet, 2, 53), pyyt0304Vo.getPayItemNm49());
                  setText(getCell(sheet, 2, 54), pyyt0304Vo.getPayItemNm50());
                  setText(getCell(sheet, 2, 55), pyyt0304Vo.getPayItemNm51()); 
                  setText(getCell(sheet, 2, 56), pyyt0304Vo.getPayItemNm52());
                  setText(getCell(sheet, 2, 57), pyyt0304Vo.getPayItemNm53());
                  setText(getCell(sheet, 2, 58), pyyt0304Vo.getPayItemNm54());
                  setText(getCell(sheet, 2, 59), pyyt0304Vo.getPayItemNm55()); 
                  setText(getCell(sheet, 2, 60), pyyt0304Vo.getPayItemNm56());
                  setText(getCell(sheet, 2, 61), pyyt0304Vo.getPayItemNm57());
                  setText(getCell(sheet, 2, 62), pyyt0304Vo.getPayItemNm58());
                  setText(getCell(sheet, 2, 63), pyyt0304Vo.getPayItemNm59()); 
                  setText(getCell(sheet, 2, 64), pyyt0304Vo.getPayItemNm60());
                  setText(getCell(sheet, 2, 65), pyyt0304Vo.getPayItemNm61());
                  setText(getCell(sheet, 2, 66), pyyt0304Vo.getPayItemNm62());
                  setText(getCell(sheet, 2, 67), pyyt0304Vo.getPayItemNm63()); 
                  setText(getCell(sheet, 2, 68), pyyt0304Vo.getPayItemNm64());
                  setText(getCell(sheet, 2, 69), pyyt0304Vo.getPayItemNm65());
                  setText(getCell(sheet, 2, 70), pyyt0304Vo.getPayItemNm66());
                  setText(getCell(sheet, 2, 71), pyyt0304Vo.getPayItemNm67()); 
                  setText(getCell(sheet, 2, 72), pyyt0304Vo.getPayItemNm68());
                  setText(getCell(sheet, 2, 73), pyyt0304Vo.getPayItemNm69());
                  setText(getCell(sheet, 2, 74), pyyt0304Vo.getPayItemNm70());
                  setText(getCell(sheet, 2, 75), pyyt0304Vo.getPayItemNm71()); 
                  setText(getCell(sheet, 2, 76), pyyt0304Vo.getPayItemNm72());
                  setText(getCell(sheet, 2, 77), pyyt0304Vo.getPayItemNm73());
                  setText(getCell(sheet, 2, 78), pyyt0304Vo.getPayItemNm74());
                  setText(getCell(sheet, 2, 79), pyyt0304Vo.getPayItemNm75()); 
                  setText(getCell(sheet, 2, 80), pyyt0304Vo.getPayItemNm76());
                  setText(getCell(sheet, 2, 81), pyyt0304Vo.getPayItemNm77());
                  setText(getCell(sheet, 2, 82), pyyt0304Vo.getPayItemNm78());
                  setText(getCell(sheet, 2, 83), pyyt0304Vo.getPayItemNm79());  
                  setText(getCell(sheet, 2, 84), "급여계");  
                  setText(getCell(sheet, 2, 85), "공제액계");  
                  setText(getCell(sheet, 2, 86), "차인지급액");  
                  
                  boolWrite = false;
              } 
   
                cell = getCell(sheet, 3 + i, 0);
                setText(cell, String.valueOf(i + 1));
                cell = getCell(sheet, 3 + i, 1);
                setText(cell,pyyt0304Vo.getPyytYrMnth());  /** 지급년월 */
                cell = getCell(sheet, 3 + i, 2);
                setText(cell, pyyt0304Vo.getDeptNm());  /** 부서                 */
                cell = getCell(sheet, 3 + i, 3); 
                setText(cell, pyyt0304Vo.getHanNm());  /** 성명 */ 
                cell = getCell(sheet, 3 + i, 4);
                setText(cell, pyyt0304Vo.getResnRegnNum());   /** 주민번호 */
                cell = getCell(sheet, 3 + i, 5);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum01().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 6);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum02().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 7);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum03().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 8);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum04().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 9);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum05().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 10);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum06().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 11);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum07().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 12);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum08().toString())); /** 금액 */
                cell = getCell(sheet, 3 + i, 13);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum09().toString())); /** 금액 */
                cell = getCell(sheet, 3 + i, 14);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum10().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 15);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum11().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 16);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum12().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 17);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum13().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 18);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum14().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 19);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum15().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 20);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum16().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 21);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum17().toString())); /** 금액 */
                cell = getCell(sheet, 3 + i, 22);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum18().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 23);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum19().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 24);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum20().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 25);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum21().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 26);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum22().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 27);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum23().toString())); /** 금액 */
                cell = getCell(sheet, 3 + i, 28);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum24().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 29);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum25().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 30);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum26().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 31);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum27().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 32);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum28().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 33);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum29().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 34);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum30().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 35);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum31().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 36);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum32().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 37);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum33().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 38);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum34().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 39);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum35().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 40);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum36().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 41);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum37().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 42);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum38().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 43);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum39().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 44);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum40().toString())); /** 금액 */
                cell = getCell(sheet, 3 + i, 45);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum41().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 46);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum42().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 47);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum43().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 48);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum44().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 49);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum45().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 50);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum46().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 51);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum47().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 52);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum48().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 53);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum49().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 54);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum50().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 55);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum51().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 56);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum52().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 57);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum53().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 58);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum54().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 59);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum55().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 60);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum56().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 61);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum57().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 62);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum58().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 63);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum59().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 64);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum60().toString())); /** 금액 */
                cell = getCell(sheet, 3 + i, 65);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum61().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 66);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum62().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 67);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum63().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 68);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum64().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 69);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum65().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 70);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum66().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 71);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum67().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 72);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum68().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 73);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum69().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 74);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum70().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 75);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum71().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 76);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum72().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 77);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum73().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 78);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum74().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 79);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum75().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 80);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum76().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 81);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum77().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 82);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum78().toString())); /** 금액 */ 
                cell = getCell(sheet, 3 + i, 83);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtDducSum79().toString())); /** 금액 */ 
                 
                cell = getCell(sheet, 3 + i, 84);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPymtTotAmnt().toString())); /** 지급액 */ 
                
                cell = getCell(sheet, 3 + i, 85);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytDducTotAmnt().toString())); /** 공제액 */ 
                
                cell = getCell(sheet, 3 + i, 86);
                cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
                cell.setCellValue(Long.parseLong(pyyt0304Vo.getPyytPernPymtSum().toString())); /** 차인지급액 */ 
             
              
        }
        
    }
     
    
}
