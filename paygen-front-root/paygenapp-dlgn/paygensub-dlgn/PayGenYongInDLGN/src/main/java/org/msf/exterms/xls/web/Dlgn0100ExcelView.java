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

public class Dlgn0100ExcelView extends AbstractExcelView {

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
//        HSSFSheet sheet = wb.createSheet("근무실적관리");
//        sheet.setDefaultColumnWidth((short) 20);
// 
//        // put text in first cell
//        cell = getCell(sheet, 0, 0);
//        setText(cell, "근무실적대상자리스트");
//        
//        cell = getCell(sheet, 1, 0);
//        setText(cell, "대상자 업로드는 다음라인 부터 읽어들여 적용됩니다. 이라인 이전은 삭제하지 마십시요.");
//        
////                =========== 작성시 주의 사항 ===================           
////                1. 1,2번째 행은 타이틀로써 아래 예제문을 따르십시요.            
////                2. 3번째 행부터 입력될 데이터를 작성합니다.          
////                3. '실근무일'에는 근무일수+유급휴가에서 결근일수 제외한 일수를 입력합니다.         
////                4. 시간외수당 '총시간'은 기본시간과 시간외시간의 합을 입력합니다.          
////                5. '작성시 주의사항'은 반드시 삭제후 파일을 업로드 하십시오.    
//        // set header information
//        setText(getCell(sheet, 2, 0), "번호");
//        setText(getCell(sheet, 2, 1), "년월");
//        setText(getCell(sheet, 2, 2), "급여구분");
//        setText(getCell(sheet, 2, 3), "성명");
//        setText(getCell(sheet, 2, 4), "주민등록번호");
//        setText(getCell(sheet, 2, 5), "근무일수");
//        setText(getCell(sheet, 2, 6), "휴가(유급)사용일수");
//        setText(getCell(sheet, 2, 7), "실근무일");
//        setText(getCell(sheet, 2, 8), "특별휴가");
//        setText(getCell(sheet, 2, 9), "결근");
//        setText(getCell(sheet, 2, 10), "결근인정일수");
//        setText(getCell(sheet, 2, 11), "병가");
//        setText(getCell(sheet, 2, 12), "공가");
//        setText(getCell(sheet, 2, 13), "경조사");
//        setText(getCell(sheet, 2, 14), "보건");
//        setText(getCell(sheet, 2, 15), "잔여월차");
//        setText(getCell(sheet, 2, 16), "휴일근무");
//        setText(getCell(sheet, 2, 17), "토요근무");
//        setText(getCell(sheet, 2, 18), "주휴일수");
//        setText(getCell(sheet, 2, 19), "유급(월차)휴일수");
//        setText(getCell(sheet, 2, 20), "잔여연가");
//        setText(getCell(sheet, 2, 21), "교통보조비");
//        setText(getCell(sheet, 2, 22), "급식비");
//        setText(getCell(sheet, 2, 23), "시간외기본시간");
//        setText(getCell(sheet, 2, 24), "시간외시간");
//        setText(getCell(sheet, 2, 25), "시간외총시간");
//        setText(getCell(sheet, 2, 26), "야근수당(시간)");
//         
//        
//  
//        List<Dlgn0100VO> listDlgn0100 = (List<Dlgn0100VO>) model.get("listDlgn0100");
// 
// 
//        for (int i = 0; i < listDlgn0100.size(); i++) {
//            
//                Dlgn0100VO dlgn0100Vo = listDlgn0100.get(i);
// 
//
//                cell = getCell(sheet, 3 + i, 0);
//                setText(cell, Integer.toString(i+1));
//                cell = getCell(sheet, 3 + i, 1);
//                setText(cell, dlgn0100Vo.getDilnlazYrMnth());  /** column 근태년월 : dilnlazYrMnth */
//                cell = getCell(sheet, 3 + i, 2);
//                setText(cell, dlgn0100Vo.getPayCd());   /** column 급여구분코드 : payCd */  
//                cell = getCell(sheet, 3 + i, 3);
//                setText(cell, dlgn0100Vo.getHanNm());    /** 성명                 */
//                cell = getCell(sheet, 3 + i, 4);
//                setText(cell, dlgn0100Vo.getResnRegnNum());  /** 주민등록번호                 */
//                cell = getCell(sheet, 3 + i, 5); 
//                setText(cell, dlgn0100Vo.getDilnlazDutyNumDys());   /** column 근태_근무일수 : dilnlazDutyNumDys */ 
//                cell = getCell(sheet, 3 + i, 6);
//                setText(cell, dlgn0100Vo.getDilnlazPaidHodyNumDys());  /** column 근태_유급휴가일수 : dilnlazPaidHodyNumDys */
//                cell = getCell(sheet, 3 + i, 7);
//                setText(cell, dlgn0100Vo.getDilnlazTotDutyNumDys());   /** column 근태_총근무일수 : dilnlazTotDutyNumDys */
//                cell = getCell(sheet, 3 + i, 8);
//                setText(cell, dlgn0100Vo.getDilnlazSpclHodyNumDys());    /** column 근태_특별휴가일수 : dilnlazSpclHodyNumDys */  
//               // dlgn0100Vo.setDilnlazLvsgNumDys(EgovExcelUtil.getValue(cell2));    /** column 근태_연가일수 : dilnlazLvsgNumDys */
//                cell = getCell(sheet, 3 + i, 9);
//                setText(cell, dlgn0100Vo.getDilnlazAbnceNumDys());   /** column 근태_결근일수 : dilnlazAbnceNumDys */
//                cell = getCell(sheet, 3 + i, 10);
//                setText(cell, dlgn0100Vo.getDilnlazAbnceDutyRcgtnDys());   /** column 근태_결근인정일수 : dilnlazAbnceDutyRcgtnDys */
//                cell = getCell(sheet, 3 + i, 11);
//                setText(cell, dlgn0100Vo.getDilnlazSckleaNumDys());    /** column 근태_병가일수 : dilnlazSckleaNumDys */
//                cell = getCell(sheet, 3 + i, 12);
//                setText(cell, dlgn0100Vo.getDilnlazOffvaNumDys());    /** column 근태_공가일수 : dilnlazOffvaNumDys */
//                cell = getCell(sheet, 3 + i, 13);
//                setText(cell, dlgn0100Vo.getDilnlazFmlyEvntNumDys());     /** column 근태_경조사일수 : dilnlazFmlyEvntNumDys */
//                cell = getCell(sheet, 3 + i, 14);
//                setText(cell, dlgn0100Vo.getDilnlazHlthCreNumDys());    /** column 근태_보건일수 : dilnlazHlthCreNumDys */
//                cell = getCell(sheet, 3 + i, 15);
//                setText(cell, "0");
//                /** 잔여월차 */
//                cell = getCell(sheet, 3 + i, 16);
//                setText(cell, dlgn0100Vo.getDilnlazPubcHodyDutyNumDys());   /** column 총휴일근무일수 : dilnlazPubcHodyDutyNumDys */
//                cell = getCell(sheet, 3 + i, 17);
//                setText(cell, dlgn0100Vo.getDilnlazSatDutyNumDys());   /** column 총토요근무일수 : dilnlazSatDutyNumDys */ 
//                cell = getCell(sheet, 3 + i, 18);
//                setText(cell, dlgn0100Vo.getDilnlazWklyHldyNumDys());   /** column 근태_주휴일수 : dilnlazWklyHldyNumDys */
//                cell = getCell(sheet, 3 + i, 19);
//                setText(cell, dlgn0100Vo.getDilnlazPaidPubcHodyNum());    /** column 근태_유급휴일수 : dilnlazPaidPubcHodyNum */   
//                cell = getCell(sheet, 3 + i, 20);
//                setText(cell, "0");
//                 /** 잔여연가 */
//                cell = getCell(sheet, 3 + i, 21);
//                setText(cell, dlgn0100Vo.getDilnlazTfcAssCstNumDys());   /** column 근태_교통보조비일수 : dilnlazTfcAssCstNumDys */
//              
//                cell = getCell(sheet, 3 + i, 22);
//                setText(cell, dlgn0100Vo.getDilnlazLnchDys());    /** column 근태_급식비일수 : dilnlazLnchDys */
//              
//                
//                cell = getCell(sheet, 3 + i, 23);
//                setText(cell, dlgn0100Vo.getDilnlazFndtnTmRstDutyTm());   /** column 근태_기본시간외근무시간 : dilnlazFndtnTmRstDutyTm */
//                cell = getCell(sheet, 3 + i, 24);
//                setText(cell, dlgn0100Vo.getDilnlazTmRstDutyTm());   /** column 근태_시간외근무시간 : dilnlazTmRstDutyTm */
//                cell = getCell(sheet, 3 + i, 25);
//                setText(cell, dlgn0100Vo.getDilnlazTotTmRstDutyTm());   /** column 근태_총시간외근무시간 : dilnlazTotTmRstDutyTm */ 
//                cell = getCell(sheet, 3 + i, 26);
//                setText(cell, dlgn0100Vo.getDilnlazTotNtotTm());  /** column 근태_총야근시간 : dilnlazTotNtotTm */
//                
//              //  dlgn0100Vo.setDilnlazDdlnePrcsYn(EgovExcelUtil.getValue(cell2));    /** column 근태_마감처리여부 : dilnlazDdlnePrcsYn */
//              //  dlgn0100Vo.setDilnlazNoteCtnt(EgovExcelUtil.getValue(cell2));    /** column 근태_비고내용 : dilnlazNoteCtnt */   
////                dlgn0100Vo.setDilnlazExceDutyYrMnth(EgovExcelUtil.getValue(cell2));    /** column 근태초과근무년월 : dilnlazExceDutyYrMnth */ 
////                dlgn0100Vo.setDilnlazExceDutyBgnnDt(EgovExcelUtil.getValue(cell2));    /** column 근태_초과근무시작일자 : dilnlazExceDutyBgnnDt */
////                dlgn0100Vo.setDilnlazExceDutyEndDt(EgovExcelUtil.getValue(cell2));    /** column 근태_초과근무종료일자 : dilnlazExceDutyEndDt */ 
////                dlgn0100Vo.setDilnlazTotNtotNumDys(EgovExcelUtil.getValue(cell2));    /** column 근태_총야근일수 : dilnlazTotNtotNumDys */
//                
//        }
//        
//    }
    
    
    /**
     * 엑셀파일을 설정하고 생성한다.
     * @param model
     * @param wb
     * @param request
     * @param response
     * @throws Exception
     */
    protected void buildExcelDocument(Map<String, Object> model,
            HSSFWorkbook wb, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
    	
	    final HashMap<String, String> globals = MSFServerUtils.getLocalidedMessages(RemoteServiceUtil.getThreadLocalConfig(), RemoteServiceUtil.getThreadLocalRequest());   
      	
    	XLSTransformer transformer = new XLSTransformer();
        
//      	String realPath = request.getSession().getServletContext().getRealPath(""); 
//      	String xlsRelatvieFilepath =   realPath.concat("/".concat(globals.get("PayGen.XLSTemplateLink")).concat("/DLGN/XLS_DLGN025001.xls"));
//      	String xlsRelatvieFilepath =   realPath.concat("/".concat("/src/main/mncpts/gwangmyeong/GwangMyeong/XlsTemplate/DLGN/XLS_DLGN010001.xls"));
      	
//      	String xlsRelatvieFilepath =   realPath.concat("/".concat(globals.get("PayGen.XLSTemplateLink")).concat("/DLGN/XLS_DLGN025001.xls"));
      	
//      	String xlsRelatvieFilepath =   realPath.concat("/".concat("src/main/mncpts/gwangmyeong/GwangMyeong/XlsTemplate/DLGN/XLS_DLGN010001.xls"));
      	//TODO 경로 다시 재정의 _ 근태관리 지자체별로 엑셀 위치 다름.
//      	String realPathA = "C:/eGovFrameDev-3.5.1-64bit/workspacePayGen/paygen-root/paygen-web/PayGenApp";
//      	String xlsRelatvieFilepath = realPathA.concat("/src/main/mncpts/gwangmyeong/GwangMyeong/XlsTemplate/DLGN/XLS_DLGN010001.xls");
      	
      	String realPath = request.getSession().getServletContext().getRealPath(""); 
      	String xlsRelatvieFilepath =   realPath.concat("/YongIn/".concat(globals.get("PayGen.XLSTemplateLink")).concat("/DLGN/XLS_DLGN010001.xls"));
      	
        String destFileName = "기본근무관리폼";
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
