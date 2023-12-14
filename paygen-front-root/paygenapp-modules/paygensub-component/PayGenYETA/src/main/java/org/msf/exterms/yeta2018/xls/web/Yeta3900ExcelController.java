package org.msf.exterms.yeta2018.xls.web;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.jxls.reader.ReaderBuilder;
import net.sf.jxls.reader.XLSReadStatus;
import net.sf.jxls.reader.XLSReader;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.IOUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.gwtrpcspring.RemoteServiceUtil;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.msf.exterms.yeta2018.xls.service.Yeta3900ExcelService;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.xml.sax.SAXException;

import com.app.exterms.yearendtax.server.vo.Payr0485Srh_2018_VO;
import com.app.exterms.yearendtax.server.vo.Payr0485_2018_VO;
import com.app.exterms.yearendtax.server.vo.Pyyt0302Exl_2018_VO;
import com.app.exterms.yearendtax.server.vo.Pyyt0302_2018_VO;
import com.app.exterms.yearendtax.server.vo.Pyyt0304Srh_2018_VO;
import com.app.exterms.yearendtax.server.vo.Pyyt0304_2018_VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0485SrhVO;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class Yeta3900ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(Yeta3900ExcelController.class);  
    private static final String calledClass = Yeta3900ExcelController.class.getName();
 
    
    @Resource(name = "yeta3900ExcelService")
    private Yeta3900ExcelService yeta3900ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    
    private List<Pyyt0302_2018_VO> errPyyt0302List = new ArrayList<Pyyt0302_2018_VO>();

    
    /**
     * 엑셀파일로 출력한다. (양식1 : 가변)
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsTemYeta390001Export.do")
    public ModelAndView xlsYeta3900Export01(@ModelAttribute("Payr0485Srh_2018_VO") Payr0485Srh_2018_VO Payr0485SrhVO, HttpServletRequest request ,ModelMap model) 
                    throws Exception {  
    	
    	String method = calledClass + ".xlsYeta3900Export01";
    	
    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
    	InfcPkgPayr0485SrhVO payr0485SrhVo = new InfcPkgPayr0485SrhVO();
//    	List<String> listDeptCd = new ArrayList<String>();
    	Map<String, Object> map = new HashMap<String, Object>();
    	
    	String windowNm = "급여내역(정산용)관리";
		String windowId = "YETA3900";
    	
		
    	// 1. 암호화 객체 생성
    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(), RemoteServiceUtil.getThreadLocalRequest());
    	
    	
		try{
	        /** 조건절 */
			payr0485SrhVo.setDpobCd(sessionUser.getDpobCd());  										//사업장코드
			payr0485SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(Payr0485SrhVO.getEmymtDivCd()));	//고용구분코드
			payr0485SrhVo.setExtptDducDspyYn("Y");													// 출력여부
			payr0485SrhVo.setExtptDducUseYn("Y");													// 사용여부
        
    		
    		List listYeta2900 = yeta3900ExcelService.selectXlsPayr0485List(payr0485SrhVo);
    		
    		map = new HashMap<String, Object>();
    		
			String strPayItemCd = "";
			String strPayItemNm = "";
			
			ArrayList<Payr0485_2018_VO> cols = new ArrayList<Payr0485_2018_VO>();	
//			for (int j = 0; j < 5; j++) {
				
			    for(int i=0; i<listYeta2900.size(); i++){
		    		EgovMap eMap  = new EgovMap();
		    		eMap = (EgovMap) listYeta2900.get(i);
		    		
		    		strPayItemCd = MSFSharedUtils.allowNulls(eMap.get("payItemCd"));
		    		strPayItemNm = MSFSharedUtils.allowNulls(eMap.get("payItemNm"));
		    		
		    		cols.add(new Payr0485_2018_VO(strPayItemCd,strPayItemNm, "0"));
		    	} 		
				
//			}
			
			map.put("cols", cols);
		    
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return new ModelAndView("yeta390001TemExcelView", map);
         
    }
    
    
    
    
    /**
     * 엑셀파일로 출력한다. (양식2 : 고정)
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsTemYeta390002Export.do")
    public ModelAndView xlsYeta3900Export02(@ModelAttribute("Payr0485Srh_2018_VO") Payr0485Srh_2018_VO Payr0485SrhVO, HttpServletRequest request ,ModelMap model) 
                    throws Exception {  
    	
    	String method = calledClass + ".xlsYeta3900Export02";
    	
    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
    	InfcPkgPayr0485SrhVO payr0485SrhVo = new InfcPkgPayr0485SrhVO();
//    	List<String> listDeptCd = new ArrayList<String>();
    	Map<String, Object> map = new HashMap<String, Object>();
    	
    	String windowNm = "급여내역(정산용)관리";
		String windowId = "YETA3900";
    	
    	
    	// 1. 암호화 객체 생성
    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(), RemoteServiceUtil.getThreadLocalRequest());
    	
		try{
	        /** 조건절 */
			payr0485SrhVo.setDpobCd(sessionUser.getDpobCd());  										// 사업장코드
			payr0485SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(Payr0485SrhVO.getEmymtDivCd()));	// 고용구분코드
			payr0485SrhVo.setExtptDducDspyYn("Y");													// 출력여부
			payr0485SrhVo.setExtptDducUseYn("Y");													// 사용여부
        
    		
    		List listYeta3900 = yeta3900ExcelService.selectXlsPayr0485List(payr0485SrhVo);
    		
			map = new HashMap<String, Object>();
			map.put("listYeta3900", listYeta3900);
			
    	}catch(Exception e) {
    		e.printStackTrace();
    	}

		
    	return new ModelAndView("yeta390002TemExcelView", map);
         
    }   
    

    
    
    /**
     * 엑셀파일을 업로드한다. (양식1 : 가변)
     * @param MultipartFile, Model, HttpServletRequest
     * @return sResult
     * @throws InvalidFormatException, IOException, SAXException
     */
    @RequestMapping(value = "/imp/XlsReadYeta390001Import.do", method = RequestMethod.POST)
    public String handleFormUpload01(@RequestParam("yeta3900flUp") MultipartFile file,
			Model model, final HttpServletRequest request) throws InvalidFormatException, IOException, SAXException {
    	
    	
    	String realPath = request.getSession().getServletContext().getRealPath(""); 
    	String xmlConfig2 = "/upXmlConfig/YETA/Yeta390001Mapping.xml";
    	
    	String sResult = "ssss";			//결과 상태값
    	InputStream inputXML = null;		//XML
		InputStream inputXLS = null;		//엑셀파일
		
		
		
		// 맵핑할 엑셀 컬럼을 미리 정의해둔다.
		ArrayList<String> colStr = new ArrayList<String>();
		colStr.add("pyytYrMnth");
		colStr.add("resnRegnNum");
		colStr.add("juminCk");
		colStr.add("hanNm");
		colStr.add("pyytItemCd");
		colStr.add("pyytPymtDducSum");
		
		List<Pyyt0302_2018_VO> pyyt0302List = new ArrayList<Pyyt0302_2018_VO>();
		List<Pyyt0302_2018_VO> unionPyyt0302List = new ArrayList<Pyyt0302_2018_VO>();
		Collection<Pyyt0302_2018_VO> sumPyyt0302List = new ArrayList<Pyyt0302_2018_VO>();
		
		Pyyt0302_2018_VO pyyt302Vo = new Pyyt0302_2018_VO();
		int iCol = 0;
		
		try {
			
			Map<String, List> beans = new HashMap<String, List>();
		    beans.put("pyyt0302List", pyyt0302List);
			
			inputXML = new BufferedInputStream(new FileInputStream(realPath.concat("/WEB-INF" + xmlConfig2)));
			XLSReader mainReader = ReaderBuilder.buildFromXML(inputXML);
			inputXLS = new BufferedInputStream(file.getInputStream());
//			System.out.println("xml경로 " + realPath.concat("/WEB-INF" + xmlConfig));
			
			
			// 1. 엑셀 컬럼(수당공제항목)의 수를 가져온다.
			XLSReadStatus xlsReadStatus = mainReader.read(inputXLS, beans);
			if(xlsReadStatus.isStatusOK()) {
				
				iCol = pyyt0302List.size();
				
				System.out.println(iCol);
				
				
				// 수당공제항목코드를 vo에 담는다.
				for(int i = 0; i <  pyyt0302List.size(); i ++) {
					pyyt302Vo = new Pyyt0302_2018_VO();
					pyyt302Vo.setPyytItemCd(pyyt0302List.get(i).getPyytItemCd()); 
				}
				
			
			}else {
				sResult =  "error";
			}
			
		}finally {
			IOUtils.closeQuietly(inputXML);
			IOUtils.closeQuietly(inputXLS);
 		}
			
			
		// 3. 수당공제항목의 수만큼 반복해서 엑셀파일을 읽어와 데이터 처리를 한다.
//		pyyt0302List = new ArrayList<Pyyt0302VO>();
		for (int i = 0; i < iCol; i++) {
					
			try {
				
				Map<String, List> beans = new HashMap<String, List>();
				
			    beans.put("pyyt0302List", pyyt0302List);

				// 파일 이름 중복 방지
				SimpleDateFormat sdf = new SimpleDateFormat("yyyymmddhhmmss");
				String rndName = sdf.format(new java.util.Date());
				String xmlConfig = "/upXmlConfig/YETA/Yeta290002Mapping_".concat(rndName).concat(".xml");

				writeXml(realPath, xmlConfig, i, colStr);

				inputXML = new BufferedInputStream(new FileInputStream(realPath.concat("/WEB-INF" + xmlConfig)));
				XLSReader mainReader = ReaderBuilder.buildFromXML(inputXML);
				inputXLS = new BufferedInputStream(file.getInputStream());

				XLSReadStatus xlsReadStatus = mainReader.read(inputXLS, beans);
				
				// 4. xml파일 사용후 삭제
				File f = new File(realPath.concat("/WEB-INF" + xmlConfig));
				f.delete();

				if (xlsReadStatus.isStatusOK()) {
					
					sumPyyt0302List = CollectionUtils.union(sumPyyt0302List, pyyt0302List);
					

				} else {
					sResult = "error";
				}

			} finally {
				IOUtils.closeQuietly(inputXML);
				IOUtils.closeQuietly(inputXLS);
			}
			
		}
			
		errPyyt0302List = new ArrayList<Pyyt0302_2018_VO>();
		// 엑셀 업로드 서비스 호출
		errPyyt0302List = yeta3900ExcelService.updateXlsYeta390001(sumPyyt0302List, request);
		sResult = "/excelPopup/excelYetaList";
		

		return sResult;
	}  
    
    
    
    /**
     * 엑셀파일을 업로드한다. (양식2 : 고정)
     * @param MultipartFile, Model, HttpServletRequest
     * @return sResult
     * @throws InvalidFormatException, IOException, SAXException
     */
    @RequestMapping(value = "/imp/XlsReadYeta390002Import.do", method = RequestMethod.POST)
    public String handleFormUpload02(@RequestParam("yeta3900flUp") MultipartFile file,
			Model model, final HttpServletRequest request) throws InvalidFormatException, IOException, SAXException {
    	
    	String realPath = request.getSession().getServletContext().getRealPath(""); 
    	String xmlConfig = "/upXmlConfig/YETA/Yeta390002Mapping.xml";
    	
    	String sResult = "";			//결과 상태값
    	InputStream inputXML = null;	//XML
		InputStream inputXLS = null;	//엑셀파일
		
		List<Pyyt0302Exl_2018_VO> pyyt0302List = new ArrayList<Pyyt0302Exl_2018_VO>();
		Map<String, List> beans = new HashMap<String, List>();
		
	    beans.put("pyyt0302List", pyyt0302List);
		
		try {
			
			inputXML = new BufferedInputStream(new FileInputStream(realPath.concat("/WEB-INF" + xmlConfig)));
			XLSReader mainReader = ReaderBuilder.buildFromXML(inputXML);
			inputXLS = new BufferedInputStream(file.getInputStream());
//			System.out.println("xml경로 " + realPath.concat("/WEB-INF" + xmlConfig));
			
			XLSReadStatus xlsReadStatus = mainReader.read(inputXLS, beans);
			if(xlsReadStatus.isStatusOK()) {
				
				errPyyt0302List = new ArrayList<Pyyt0302_2018_VO>();
				//엑셀 업로드 서비스 호출
				errPyyt0302List = yeta3900ExcelService.updateXlsYeta390002(pyyt0302List, request);
				sResult =  "/excelPopup/excelYetaList";
			
			}else {
				sResult =  "error";
			}
		}finally {
			IOUtils.closeQuietly(inputXML);
			IOUtils.closeQuietly(inputXLS);
 		}

		return sResult;
	}  
    
    
    
	/**
	 * 팝업창 실행
	 * @param 
	 * @param ModelAndView
	 * @return
	 * @throws Exception
	 */
    @RequestMapping(value="/yeta/excelYeta2018List.do")
    public ModelAndView openSampleBoardList() throws Exception{
    	
        ModelAndView mv = new ModelAndView("/excelPopup/excelPopup");
        
		List excelList = new ArrayList();
		Pyyt0302_2018_VO pyyt0302Vo = new Pyyt0302_2018_VO();
        
		for(int i=0; i < errPyyt0302List.size(); i++) {

			pyyt0302Vo = new Pyyt0302_2018_VO();
			pyyt0302Vo = errPyyt0302List.get(i);

//			System.out.println(pyyt0302Vo.getHanNm());

			excelList.add(pyyt0302Vo);

		}
		System.out.println(excelList.size());

		mv.addObject("pyyt0302List", errPyyt0302List);

		return mv;
	}
    
    
    
    
    
    private void writeXml(String realPath, String xmlConfig, int iCol, ArrayList<String> colStr) {
    	
    	Boolean flag = true;
    	
    	// 2. 가져온 컬럼의 수로 mapping.xml 파일을 생성한다.
    	try { 
    		// 1. Document 생성
    		Document doc = new Document();
    		         
    		// 2. Root Element 생성
    		Element workbook = new Element("workbook");
    		doc.setContent(workbook);
    		 
    		// 3. Child Element 생성
    		Element worksheet = new Element("worksheet");
    		worksheet.setAttribute("name", "Sheet1");
    		workbook.addContent(worksheet);
    		
    		Element section = new Element("section");
    		section.setAttribute("startRow", "0");
    		section.setAttribute("endRow", "3");
    		worksheet.addContent(section); 	
    		
    		Element mapping_s = new Element("mapping");
    		mapping_s.setAttribute("row", "2");
    		mapping_s.setAttribute("col", String.valueOf(iCol + 5));
    		mapping_s.setText("pyyt0302Vo.pyytItemCd");
    		section.addContent(mapping_s); 	
    		
    		
    		Element loop = new Element("loop");
    		loop.setAttribute("startRow", "4");
    		loop.setAttribute("endRow", "4");
    		loop.setAttribute("items", "pyyt0302List");
    		loop.setAttribute("var", "pyyt0302Vo");
    		loop.setAttribute("varType", "com.app.exterms.yearendtax.server.vo.Pyyt0302VO");
    		worksheet.addContent(loop); 
    		
    		Element section_c = new Element("section");
    		section_c.setAttribute("startRow", "4");
    		section_c.setAttribute("endRow", "4");
//     		<mapping row="3" col="0">pyyt0302Vo.pyytYrMnth</mapping>				<!-- 지급년월 -->
//     		<mapping row="3" col="1">pyyt0302Vo.resnRegnNum</mapping>				<!-- 주민등록번호 -->
//     		<mapping row="3" col="2">pyyt0302Vo.juminCk</mapping>					<!-- 구분 -->
//     	    <mapping row="3" col="3">pyyt0302Vo.hanNm</mapping>						<!-- 성명 -->
//            <mapping row="3" col="4">pyyt0302Vo.pyytItemCd</mapping>				<!-- 급여항목코드 -->
//            <mapping row="3" col="5">pyyt0302Vo.pyytPymtDducSum</mapping>			<!-- 금액 -->
    		
    		for( int i = 0; i <= 5; i++ ) {
    		    Element mapping = new Element("mapping");
    		    
    		    // 4번째 열은 가져올 데이터 없음.
    		    if(i == 4) {
    		    	
    		    }else {
    		    	
    		    	if(i == 5) {
    		    		flag = false;
    		    	}
    		    	
    		        mapping.setAttribute("row", "4");
        		    mapping.setAttribute("col", String.valueOf(i));
        			mapping.setText("pyyt0302Vo." + colStr.get(i));
        			
//        			System.out.println("급여항목?????? " + colStr.get(i));
        		    
        		    section_c.addContent(mapping);
    		    }
    		
    		}
    		
    		
    		loop.addContent(section_c); 	
    		
    		
    		Element loopbreakcondition = new Element("loopbreakcondition");
    		loop.addContent(loopbreakcondition); 
    		
    		Element rowcheck = new Element("rowcheck");
    		rowcheck.setAttribute("offset", "4");
    		loopbreakcondition.addContent(rowcheck); 
    		
    		Element cellcheck = new Element("cellcheck");
    		cellcheck.setAttribute("offset", "1");
    		rowcheck.addContent(cellcheck); 
    		
//    		worksheet.addContent(loop); 
    		 
    		// 4. 파일에 출력
    		FileWriter writer = new FileWriter(realPath.concat("/WEB-INF" + xmlConfig));
    		new XMLOutputter().output(doc, writer);
    		writer.close();
    		 
    		// 5. 문자열 출력 (Default Format : Format.getCompactFormat())
    		String xml = new XMLOutputter().outputString(doc);
//    		System.out.println(xml);
    		         
    		// 6. 출력 포맷결정
    		// 6-1. XML형식 이쁜 포맷
    		xml = new XMLOutputter(Format.getPrettyFormat()).outputString(doc);
    		System.out.println(xml);
    		
//    		// 사용후 삭제
//    		 File f = new File(realPath.concat("/WEB-INF" + xmlConfig));
//    		 f.delete();
    	} catch (IOException e) {                                         
    	      System.err.println(e);                                        
    	}
    }
    
    
    
    /**
     * 엑셀파일로 출력한다.(급여대장) 공무직
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsYeta3900Export01.do")
    public ModelAndView XlsYeta3900Export01(@ModelAttribute("Pyyt0304Srh_2018_VO") Pyyt0304Srh_2018_VO pyyt0304SrhVo,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
      
    	
    	String method = calledClass + ".XlsYeta3900Export2";
    	
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        List<String> listDeptCd = new ArrayList<String>();
        //Payr0304SrhVO   pyyt0304SrhVo = new Payr0304SrhVO();
        Map<String, Object> map = new HashMap<String, Object>();
        

    	String windowNm = "급여내역(정산용)관리";
		String windowId = "YETA3900";
        
        String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
		try{
        
	        /** 조건절 */
	        pyyt0304SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	        pyyt0304SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	        pyyt0304SrhVo.setUsrId(sessionUser.getUsrId());  
	        /******************************** 권한 ************************************************************************/
	        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	        if ("FALSE".equals(chkDeptCd)) {
	        	
	    	    if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(pyyt0304SrhVo.getDeptCd(),sessionUser.getDeptCd()))) {
	   			 

		        	pyyt0304SrhVo.setDeptCd(sessionUser.getDeptCd()); 
		           listDeptCd.add(sessionUser.getDeptCd());
		           pyyt0304SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
	        	   } else {
	        		 
	        		   pyyt0304SrhVo.setDeptCd(MSFSharedUtils.allowNulls(pyyt0304SrhVo.getDeptCd()));
	                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(pyyt0304SrhVo.getDeptCd()));  
	                      pyyt0304SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	        	  }  
	    	    
	           pyyt0304SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	        } else {
	        	    
	        	pyyt0304SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(pyyt0304SrhVo.getPayrMangDeptCd())) ;   //단위기관코드
	                 if (pyyt0304SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(pyyt0304SrhVo.getDeptCd()))) { 
	                 	 listDeptCd = null; 
	                 	pyyt0304SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	                 	pyyt0304SrhVo.setDeptCd("");  //부서코드
	                 } else {
	                	 pyyt0304SrhVo.setDeptCd(MSFSharedUtils.allowNulls(pyyt0304SrhVo.getDeptCd()));
	                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(pyyt0304SrhVo.getDeptCd()));  
	                      pyyt0304SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	                 } 
	        }
	        
	
	        pyyt0304SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(pyyt0304SrhVo.getDeptCd()).replace(",", ""));  //권한처리를위해 추가  
	        pyyt0304SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(pyyt0304SrhVo.getDtilOccuInttnCd()).replace(",", ""));      
	         
	       /******************************** 권한 ************************************************************************/
	        pyyt0304SrhVo.setPayCd(MSFSharedUtils.allowNulls(pyyt0304SrhVo.getPayCd()));  			//급여구분코드 
	        
	        pyyt0304SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(pyyt0304SrhVo.getEmymtDivCd()));	//고용구분코드
	        
	        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(pyyt0304SrhVo.getTypOccuCd())); 
	        pyyt0304SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
	        pyyt0304SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(pyyt0304SrhVo.getTypOccuCd()));  	//직종
	       
	//        List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("pyspGrdeCd"))); 
	//        payr0304SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
	//        payr0304SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(param.get("pyspGrdeCd"))); //호봉등급코드
	         
	        List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(pyyt0304SrhVo.getDtilOccuInttnCd())); 
	        pyyt0304SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	        pyyt0304SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(pyyt0304SrhVo.getDtilOccuInttnCd())); //직종세
	        
	        pyyt0304SrhVo.setBusinCd(MSFSharedUtils.allowNulls(pyyt0304SrhVo.getBusinCd()));   			//사업코드 
	        pyyt0304SrhVo.setPyytYrMnth(MSFSharedUtils.allowNulls(pyyt0304SrhVo.getPyytYrMnth())); 		//지급년월
	        pyyt0304SrhVo.setSystemkey(MSFSharedUtils.allowNulls(pyyt0304SrhVo.getSystemkey()));  			//시스템키
	        pyyt0304SrhVo.setHanNm(MSFSharedUtils.allowNulls(pyyt0304SrhVo.getHanNm()));   		 		//한글성명 
	       // pyyt0304SrhVo.setPymtDducDivCd(MSFSharedUtils.allowNulls(pyyt0304SrhVo.getPymtDducDivCd()));	//지급공제구분
	        // pyyt0304SrhVo.setPayDducExtpyCd(MSFSharedUtils.allowNulls(pyyt0304SrhVo.get("payDducExtpyCd")));	//지급공제항목
	       
	        
	        List<Pyyt0304_2018_VO> listYeta3900 = yeta3900ExcelService.selectXlsPyyt0304List01(pyyt0304SrhVo);
	        List listYeta3900Str = new ArrayList<String>();
	        
//	        String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	    	for(int i=0; i<listYeta3900.size(); i++){
	    		
	    		Pyyt0304_2018_VO pyyt0304Vo = new Pyyt0304_2018_VO();
	    		
	    		pyyt0304Vo = (Pyyt0304_2018_VO) listYeta3900.get(i);
	    		
	    		
	    		String resnRegnNumStr = "";
	    		
	    		// TODO 주민번호
	    		nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	    		resnRegnNumStr = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(pyyt0304Vo.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	    		pyyt0304Vo.setResnRegnNum(resnRegnNumStr);
	    		
	    		listYeta3900Str.add(pyyt0304Vo);
	    		
	    	}
	    	
	        
//	        Map<String, Object> map = new HashMap<String, Object>();
	        map = new HashMap<String, Object>();
	        map.put("listYeta3900", listYeta3900Str);
	             
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
		
        }catch(Exception e) {
        	e.printStackTrace();
        	
	    	/** 에러 로그 **/			
	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);
        	
        }
       
        return new ModelAndView("yeta390001ExcelView", map);
    }
    
    
    
    /**
     * 엑셀파일로 출력한다.(급여대장) 기간제
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsYeta3900Export02.do")
    public ModelAndView XlsYeta3900Export02(@ModelAttribute("Pyyt0304Srh_2018_VO") Pyyt0304Srh_2018_VO pyyt0304SrhVO,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
    	
    	String method = calledClass + ".xlsPayr42001Export";
    	
    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
//    	Pyyt0304SrhVO   pyyt0304SrhVO = new Pyyt0304SrhVO();
    	List<String> listDeptCd = new ArrayList<String>();
    	Map<String, Object> map = new HashMap<String, Object>();
    	
    	
    	String windowNm = "급여내역(정산용)관리";
		String windowId = "YETA3900";
    	
    	
    	// 1. 암호화 객체 생성
    	
		try{
			
			 String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			 
	        /** 조건절 */
	        pyyt0304SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	        pyyt0304SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	        
	        pyyt0304SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(pyyt0304SrhVO.getEmymtDivCd()));       //고용구분코드
	        
	
	        pyyt0304SrhVO.setUsrId(sessionUser.getUsrId());  
	        /******************************** 권한 ************************************************************************/
	        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	        if ("FALSE".equals(chkDeptCd)) {
	    	    if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(pyyt0304SrhVO.getDeptCd(),sessionUser.getDeptCd()))) {
	   			 

		        	pyyt0304SrhVO.setDeptCd(sessionUser.getDeptCd()); 
		           listDeptCd.add(sessionUser.getDeptCd());
		           pyyt0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드    
	        	   } else {
	        		 
	        		   pyyt0304SrhVO.setDeptCd(MSFSharedUtils.allowNulls(pyyt0304SrhVO.getDeptCd()));
	                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(pyyt0304SrhVO.getDeptCd()));  
	                      pyyt0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
	        	  }  
	    	    
	           pyyt0304SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	        } else {
	        	    
	        	     pyyt0304SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(pyyt0304SrhVO.getPayrMangDeptCd())) ;   //단위기관코드 
	                 if (pyyt0304SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(pyyt0304SrhVO.getDeptCd()))) { 
	                 	 listDeptCd = null; 
	                 	pyyt0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
	                 	pyyt0304SrhVO.setDeptCd("");  //부서코드
	                 } else {
	                	 pyyt0304SrhVO.setDeptCd(MSFSharedUtils.allowNulls(pyyt0304SrhVO.getDeptCd()));
	                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(pyyt0304SrhVO.getDeptCd()));  
	                      pyyt0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
	                 } 
	              
	        }
	        
	
	        pyyt0304SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(pyyt0304SrhVO.getDeptCd().replace(",", "")));  //권한처리를위해 추가  
	        pyyt0304SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(pyyt0304SrhVO.getDtilOccuInttnCd()).replace(",", ""));      
        
//        String chkTypOccuCd = sessionUser.getAuthCheck().getAuthCheck04();
//        if ("FALSE".equals(chkTypOccuCd)) {
//        	//sysComSrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
//        	//sysComSrhVo.setUsrId(sessionUser.getUsrId());
//        } else {
//        	
//        }
        
       /******************************** 권한 ************************************************************************/
        
//        if (pyyt0304SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(param.get("deptCd")))) {
//        	pyyt0304SrhVO.setPayrMangDeptYn("Y");  //단위기관담당자여부 
//        	List<String> listDeptCd = null; 
//        	pyyt0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
//        	pyyt0304SrhVO.setDeptCd("");     //부서코드
//        } else {
//
//            List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("deptCd")));  
//            pyyt0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드  
//            pyyt0304SrhVO.setDeptCd(MSFSharedUtils.allowNulls(param.get("deptCd")));     //부서코드 
 //       }
        
        
        
	        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(pyyt0304SrhVO.getTypOccuCd())); 
	        pyyt0304SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
	        pyyt0304SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(pyyt0304SrhVO.getTypOccuCd()));  //직종
	       
	//        List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("pyspGrdeCd"))); 
	//        pyyt0304SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
	//        pyyt0304SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(param.get("pyspGrdeCd"))); //호봉등급코드
	         
	        List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(pyyt0304SrhVO.getDtilOccuInttnCd())); 
	        pyyt0304SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	        pyyt0304SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(pyyt0304SrhVO.getDtilOccuInttnCd())); //직종세
	        
	        pyyt0304SrhVO.setBusinCd(MSFSharedUtils.allowNulls(pyyt0304SrhVO.getBusinCd()));   //사업코드 
	        
//	        pyyt0304SrhVO.setPayCd(MSFSharedUtils.allowNulls(pyyt0304SrhVO.getPayCd()));  //급여구분코드 
	        pyyt0304SrhVO.setPyytYrMnth(MSFSharedUtils.allowNulls(pyyt0304SrhVO.getPyytYrMnth())); //지급년월
	        pyyt0304SrhVO.setSystemkey(MSFSharedUtils.allowNulls(pyyt0304SrhVO.getSystemkey()));  //시스템키
	        pyyt0304SrhVO.setHanNm(MSFSharedUtils.allowNulls(pyyt0304SrhVO.getHanNm()));    //한글성명 
	        pyyt0304SrhVO.setPayYr(MSFSharedUtils.allowNulls(pyyt0304SrhVO.getPayYr()));
	       
	        
	        
//	        EgovMap listPayr42001 = yeta2900ExcelService.selectXlsPyyt0304List1(pyyt0304SrhVO);
	        List<EgovMap> listPayr4200 = yeta3900ExcelService.selectXlsPyyt0304List2(pyyt0304SrhVO);
	        
	        
	        
	    	List<EgovMap> excelList = new ArrayList<EgovMap>();

			for(int i=0; i<listPayr4200.size(); i++){
				EgovMap eMap  = new EgovMap();
				eMap = (EgovMap) listPayr4200.get(i);
				// TODO 주민번호
				String strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
				eMap.put("resnRegnNum", strValue);
				excelList.add(eMap);
			}
	    	
	        
//	        Map<String, Object> map = new HashMap<String, Object>();
	        map = new HashMap<String, Object>();
	        map.put("listYeta3900", excelList);
	        map.put("year", pyyt0304SrhVO.getPayYr());
	        map.put("month",  pyyt0304SrhVO.getPayMonth());
	        map.put("deptNm", pyyt0304SrhVO.getDeptNm());
//	        map.put("rflctnEndDt", listPayr42001.get("rflctnEndDt"));
//	        map.put("rflctnBgnnDt", listPayr42001.get("rflctnBgnnDt"));
	        
	        
	             
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
		
        }catch(Exception e) {
        	e.printStackTrace();
        	
	    	/** 에러 로그 **/			
	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);
        	
        }
       
        return new ModelAndView("yeta390002ExcelView", map);
         
    }
    
//    /**
//     * 엑셀파일로 출력한다.(급여내역)
//     * @param searchVO 검색조건
//     * @return 엑셀파일
//     * @throws Exception
//     */
//    @RequestMapping(value="/exp/XlsYeta2900Export03.do")
//    public ModelAndView xlsPayr4200TotExport(@RequestParam HashMap<String, String> param, HttpServletRequest request ,ModelMap model) 
//                    throws Exception { 
//    	
//    	String method = calledClass + ".xlsPayr4200TotExport";
//    	
//    	String windowNm = "급여(조정)내역관리";
//		String windowId = "PAYR4200";
//    	
//    	Payr0304SrhVO   payr0304SrhVO = new Payr0304SrhVO();
//        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
//        Map<String, Object> map = new HashMap<String, Object>();
//        
//        String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
//    	
//
////    	param.put("payrMangDeptYn",sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
////    	
////        
////        if (MSFSharedUtils.allowNulls(param.get("payrMangDeptCd")).equals(MSFSharedUtils.allowNulls(param.get("deptCd")))) {
////    		 param.put("payrMangDeptYn","Y");  //단위기관담당자여부  
////        	 param.put("deptCdArr","");  
////        	 param.put("deptCd","");  
////        } else { 
////
////       	    // List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("deptCd")));  
////       	     param.put("deptCdArr",MSFSharedUtils.allowNulls(param.get("deptCd")));    
////        }
////    	  
////    	
////         
////        // List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("typOccuCd"))); 
////         param.put("typOccuCdArr",MSFSharedUtils.allowNulls(param.get("typOccuCd")));   
////        
////        // List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("pyspGrdeCd"))); 
////         param.put("pyspGrdeCdArr",MSFSharedUtils.allowNulls(param.get("pyspGrdeCd")));  
////        
////          
////        // List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd"))); 
////         param.put("dtilOccuInttnCdArr",MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd")));  
//        List<String> listDeptCd = new ArrayList<String>();
//        
//		try{
//			
//	        /** 조건절 */
//	        payr0304SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드
//	        payr0304SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
//	       
//	        payr0304SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(param.get("emymtDivCd")));       //고용구분코드
//	        
//
//	        payr0304SrhVO.setUsrId(sessionUser.getUsrId());  
//	        /******************************** 권한 ************************************************************************/
//	        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
//	        if ("FALSE".equals(chkDeptCd)) {
//	        	payr0304SrhVO.setDeptCd(sessionUser.getDeptCd()); 
//	           listDeptCd.add(sessionUser.getDeptCd());
//	           payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드    
//	           payr0304SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
//	        } else {
//	        	    
//	        	 payr0304SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(param.get("payrMangDeptCd"))) ;   //단위기관코드
//	                 if (payr0304SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(param.get("deptCd")))) { 
//	                 	 listDeptCd = null; 
//	                 	payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
//	                 	payr0304SrhVO.setDeptCd("");  //부서코드
//	                 } else {
//	                	 payr0304SrhVO.setDeptCd(MSFSharedUtils.allowNulls(param.get("deptCd")));
//	                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("deptCd")));  
//	                      payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
//	                 } 
//	              
//	        }
//	        
//
//	        payr0304SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(param.get("deptCd")).replace(",", ""));  //권한처리를위해 추가  
//	        payr0304SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd")).replace(",", ""));      
//	         
//	       /******************************** 권한 ************************************************************************/
//	        
////	        if (payr0304SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(param.get("deptCd")))) {
////	        	payr0304SrhVO.setPayrMangDeptYn("Y");  //단위기관담당자여부 
////	        	List<String> listDeptCd = null; 
////	        	payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
////	        	payr0304SrhVO.setDeptCd("");     //부서코드
////	        } else {
//	//
////	            List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("deptCd")));  
////	            payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드  
////	            payr0304SrhVO.setDeptCd(MSFSharedUtils.allowNulls(param.get("deptCd")));     //부서코드 
////	        }
//	        
//	        
//	        
//	        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("typOccuCd"))); 
//	        payr0304SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
//	        payr0304SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(param.get("typOccuCd")));  //직종
//	       
//	        List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("pyspGrdeCd"))); 
//	        payr0304SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
//	        payr0304SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(param.get("pyspGrdeCd"))); //호봉등급코드
//	         
//	        List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd"))); 
//	        payr0304SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
//	        payr0304SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd"))); //직종세
//	        
//	        payr0304SrhVO.setBusinCd(MSFSharedUtils.allowNulls(param.get("businCd")));   //사업코드 
//	        
//	        payr0304SrhVO.setPayCd(MSFSharedUtils.allowNulls(param.get("payCd")));  //급여구분코드 
//	        payr0304SrhVO.setPymtYrMnth(MSFSharedUtils.allowNulls(param.get("pymtYrMnth"))); //지급년월
//	        payr0304SrhVO.setSystemkey(MSFSharedUtils.allowNulls(param.get("systemkey")));  //시스템키
//	        payr0304SrhVO.setHanNm(MSFSharedUtils.allowNulls(param.get("hanNm")));    //한글성명 
//	         
//	        List<Payr4200TotVO> listTotPayr4200Vo = payr4200ExcelService.selectXlsTotPayr4200List(payr0304SrhVO);
//	        
//	        List listTotPayr4200 = new ArrayList<String>();
//	        
//	    	for(int i=0; i<listTotPayr4200Vo.size(); i++){
//	    		
//	    		Payr4200TotVO payr4200TotVo = new Payr4200TotVO();
//	    		
//	    		payr4200TotVo = (Payr4200TotVO) listTotPayr4200Vo.get(i);
//	    		
//	    		
//	    		// TODO 주민번호
//	    		nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
//	    		payr4200TotVo.setResnRegnNum(AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(payr4200TotVo.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC));
//	    		
//	    		listTotPayr4200.add(payr4200TotVo);
//	    		
//	    	}
//	    	
//	        
////	        Map<String, Object> map = new HashMap<String, Object>();
//	        map = new HashMap<String, Object>();
//	        map.put("listTotPayr4200", listTotPayr4200);  
//	        
//			/** 로그반영
//			 * CRUDSBLO
//			 * C:create		R:read		U:update
//	    	 * D:delete		S:select	B:배치 
//	    	 * L:로그인		O:로그아웃
//	    	 */
//			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
//        	
//        }catch(Exception e) {
//        	e.printStackTrace();
//        	
//	    	/** 에러 로그 **/			
//	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);
//        	
//        }
//       
//        return new ModelAndView("payr4200TotExcelView", map);
//         
//    }  
    
    
    
    
}