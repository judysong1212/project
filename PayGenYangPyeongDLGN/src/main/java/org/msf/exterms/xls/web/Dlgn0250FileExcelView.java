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

public class Dlgn0250FileExcelView extends AbstractExcelView {

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
      	String xlsRelatvieFilepath =   realPath.concat("/".concat(globals.get("PayGen.XLSTemplateLink")).concat("/DLGN/XLS_DLGN025001.xls"));
      
		String destFileName = "근무실적내역_".concat(rndName) ;
		Workbook resultWorkbook = transformer.transformXLS(new FileInputStream(xlsRelatvieFilepath), model);

		StringBuffer contentDisposition = new StringBuffer();
		contentDisposition.append("attachment;fileName=\"");
		contentDisposition.append(SmrmfUtils.encodeFileName(destFileName + ".xls"));
		contentDisposition.append("\";");
		 
		response.setHeader("Content-Disposition", contentDisposition.toString());
	 	response.setContentType("application/x-msexcel");
		resultWorkbook.write(response.getOutputStream());
    }
        
//        HSSFCell cell = null;
//         int i = 0;
//        HSSFSheet sheet = wb.createSheet("근무실적내역");
//        sheet.setDefaultColumnWidth((short) 20);
// 
//        // put text in first cell
//        cell = getCell(sheet, 0, 0);
//        setText(cell, "근무실적리스트");
//        
//        cell = getCell(sheet, 1, 0);
//        setText(cell, "");
//         
//        // set header information
//        setText(getCell(sheet, 2, 0), "번호");
//        setText(getCell(sheet, 2, 1), "년월");
//        setText(getCell(sheet, 2, 2), "급여구분");
//        setText(getCell(sheet, 2, 3), "부서");
//        setText(getCell(sheet, 2, 4), "성명");
//        setText(getCell(sheet, 2, 5), "주민등록번호");
//        setText(getCell(sheet, 2, 6), "근무일수");
//        setText(getCell(sheet, 2, 7), "휴가(유급)사용일수");
//        setText(getCell(sheet, 2, 8), "실근무일수");
//        setText(getCell(sheet, 2, 9), "특별휴가");
//        setText(getCell(sheet, 2, 10), "결근");
//        setText(getCell(sheet, 2, 11), "결근인정일수");
//        setText(getCell(sheet, 2, 12), "병가");
//        setText(getCell(sheet, 2, 13), "공가");
//        setText(getCell(sheet, 2, 14), "경조사");
//        setText(getCell(sheet, 2, 15), "보건");
//        setText(getCell(sheet, 2, 16), "잔여월차");
//        setText(getCell(sheet, 2, 17), "휴일근무");
//        setText(getCell(sheet, 2, 18), "토요근무");
//        setText(getCell(sheet, 2, 19), "주휴일수");
//        setText(getCell(sheet, 2, 20), "유급(월차)휴일수");
//        setText(getCell(sheet, 2, 21), "잔여연가");
//        setText(getCell(sheet, 2, 22), "교통보조비");
//        setText(getCell(sheet, 2, 23), "시간외기본시간");
//        setText(getCell(sheet, 2, 24), "시간외시간");
//        setText(getCell(sheet, 2, 25), "시간외총시간");
//        setText(getCell(sheet, 2, 26), "야근수당(시간)"); 
//  
//        List listDlgn0250 = (List) model.get("listFileDlgn0250");
//  
//        
//        Iterator<Map<String, Object>> iter =  listDlgn0250.iterator();
//        
//         while ( iter.hasNext() ) {
//              Map<String, Object> lstMap = (Map<String, Object>) iter.next();
//            
//                cell = getCell(sheet, 3 + i, 0);
//                setText(cell, Integer.toString(i+1));
//                cell = getCell(sheet, 3 + i, 1);
//                setText(cell,MSFSharedUtils.allowNulls(lstMap.get("dilnlazYrMnth")));  /** column 근태년월 : dilnlazYrMnth */
//                cell = getCell(sheet, 3 + i, 2);
//                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("payNm")));   /** column 급여구분 : payCd */  
//                cell = getCell(sheet, 3 + i, 3);
//                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("deptNm")));    /** 부서       deptNm          */ 
//                cell = getCell(sheet, 3 + i, 4);
//                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("hanNm")));    /** 성명       hanNm          */
//                cell = getCell(sheet, 3 + i, 5);
//                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("resnRegnNum")));  /** 주민등록번호   resnRegnNum              */
//                cell = getCell(sheet, 3 + i, 6); 
//                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("dilnlazDutyNumDys")));   /** column 근태_근무일수 : dilnlazDutyNumDys */ 
//                cell = getCell(sheet, 3 + i, 7);
//                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("dilnlazPaidHodyNumDys")));  /** column 근태_유급휴가일수 : dilnlazPaidHodyNumDys */
//                cell = getCell(sheet, 3 + i, 8);
//                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("dilnlazTotDutyNumDys")));   /** column 근태_총근무일수 : dilnlazTotDutyNumDys */
//                cell = getCell(sheet, 3 + i, 9);
//                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("dilnlazSpclHodyNumDys")));    /** column 근태_특별휴가일수 : dilnlazSpclHodyNumDys */  
//               // dlgn0250Vo.setDilnlazLvsgNumDys(EgovExcelUtil.getValue(cell2));    /** column 근태_연가일수 : dilnlazLvsgNumDys */
//                cell = getCell(sheet, 3 + i, 10);
//                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("dilnlazAbnceNumDys")));   /** column 근태_결근일수 : dilnlazAbnceNumDys */
//                cell = getCell(sheet, 3 + i, 11);
//                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("dilnlazAbnceDutyRcgtnDys")));   /** column 근태_결근인정일수 : dilnlazAbnceDutyRcgtnDys */
//                cell = getCell(sheet, 3 + i, 12);
//                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("dilnlazSckleaNumDys")));    /** column 근태_병가일수 : dilnlazSckleaNumDys */
//                cell = getCell(sheet, 3 + i, 13);
//                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("dilnlazOffvaNumDys")));    /** column 근태_공가일수 : dilnlazOffvaNumDys */
//                cell = getCell(sheet, 3 + i, 14);
//                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("dilnlazFmlyEvntNumDys")));     /** column 근태_경조사일수 : dilnlazFmlyEvntNumDys */
//                cell = getCell(sheet, 3 + i, 15);
//                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("dilnlazHlthCreNumDys")));    /** column 근태_보건일수 : dilnlazHlthCreNumDys */
//                cell = getCell(sheet, 3 + i, 16);
//                setText(cell, "0");
//                /** 잔여월차 */
//                cell = getCell(sheet, 3 + i, 17);
//                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("dilnlazPubcHodyDutyNumDys")));   /** column 총휴일근무일수 : dilnlazPubcHodyDutyNumDys */
//                cell = getCell(sheet, 3 + i, 18);
//                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("dilnlazSatDutyNumDys")));   /** column 총토요근무일수 : dilnlazSatDutyNumDys */ 
//                cell = getCell(sheet, 3 + i, 19);
//                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("dilnlazWklyHldyNumDys")));   /** column 근태_주휴일수 : dilnlazWklyHldyNumDys */
//                cell = getCell(sheet, 3 + i, 20);
//                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("dilnlazPaidPubcHodyNum")));    /** column 근태_유급휴일수 : dilnlazPaidPubcHodyNum */   
//                cell = getCell(sheet, 3 + i, 21);
//                setText(cell, "0");
//                 /** 잔여연가 */
//                cell = getCell(sheet, 3 + i, 22);
//                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("dilnlazTfcAssCstNumDys")));   /** column 근태_교통보조비일수 : dilnlazTfcAssCstNumDys */
//                cell = getCell(sheet, 3 + i, 23);
//                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("dilnlazFndtnTmRstDutyTm")));   /** column 근태_기본시간외근무시간 : dilnlazFndtnTmRstDutyTm */
//                cell = getCell(sheet, 3 + i, 24);
//                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("dilnlazTmRstDutyTm")));   /** column 근태_시간외근무시간 : dilnlazTmRstDutyTm */
//                cell = getCell(sheet, 3 + i, 25);
//                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("dilnlazTotTmRstDutyTm")));   /** column 근태_총시간외근무시간 : dilnlazTotTmRstDutyTm */ 
//                cell = getCell(sheet, 3 + i, 26);
//                setText(cell, MSFSharedUtils.allowNulls(lstMap.get("dilnlazTotNtotTm")));  /** column 근태_총야근시간 : dilnlazTotNtotTm */
//                
//              //  dlgn0250Vo.setDilnlazDdlnePrcsYn(EgovExcelUtil.getValue(cell2));    /** column 근태_마감처리여부 : dilnlazDdlnePrcsYn */
//              //  dlgn0250Vo.setDilnlazNoteCtnt(EgovExcelUtil.getValue(cell2));    /** column 근태_비고내용 : dilnlazNoteCtnt */   
////                dlgn0250Vo.setDilnlazExceDutyYrMnth(EgovExcelUtil.getValue(cell2));    /** column 근태초과근무년월 : dilnlazExceDutyYrMnth */ 
////                dlgn0250Vo.setDilnlazExceDutyBgnnDt(EgovExcelUtil.getValue(cell2));    /** column 근태_초과근무시작일자 : dilnlazExceDutyBgnnDt */
////                dlgn0250Vo.setDilnlazExceDutyEndDt(EgovExcelUtil.getValue(cell2));    /** column 근태_초과근무종료일자 : dilnlazExceDutyEndDt */ 
////                dlgn0250Vo.setDilnlazTotNtotNumDys(EgovExcelUtil.getValue(cell2));    /** column 근태_총야근일수 : dilnlazTotNtotNumDys */
//                 
//                i = i + 1;
//        }
        
    }
