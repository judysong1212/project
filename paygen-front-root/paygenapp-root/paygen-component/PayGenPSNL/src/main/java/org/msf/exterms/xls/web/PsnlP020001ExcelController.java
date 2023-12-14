package org.msf.exterms.xls.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.msf.exterms.xls.service.PsnlP020001ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.exterms.personal.server.vo.Psnl0110VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.property.EgovPropertyService;

@Controller
public class PsnlP020001ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(PsnlP020001ExcelController.class);  
    private static final String calledClass = PsnlP020001ExcelController.class.getName();

 
    @Resource(name = "psnlP020002ExcelService")
    private PsnlP020001ExcelService psnlP020002ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;

    /**
     * 엑셀파일로 출력한다.(양식)
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsPsnlP020002Export.do")
    public ModelAndView xlsPsnlP020002Export(@ModelAttribute("Psnl0110VO") Psnl0110VO psnl0110Vo,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
    	
    	String method = calledClass + ".xlsPsnlP020002Export";
    	

		String windowNm = "신규고용일괄등록";
		String windowId = "PsnlP020001";
    	
    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
    	
//    	Payr0304SrhVO   payr0304rhVo = new Payr0304SrhVO();
    	
    	List<String> listDeptCd = new ArrayList<String>();
    	Map<String, Object> map = new HashMap<String, Object>();
    	
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
    	
    	
		try{
	        
	        /** 조건절 */
			psnl0110Vo.setEmymtNewTypCd(psnl0110Vo.getEmymtNewTypCd());  	//신규구분
	       
	        List<Psnl0110VO> listPsnl0110 = new ArrayList<Psnl0110VO>();
	        
	        listPsnl0110.add(psnl0110Vo);
	        
	        map = new HashMap<String, Object>();
	        map.put("listPsnl0110", listPsnl0110);
	        
	             
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
       
        return new ModelAndView("psnlP020002ExcelView", map);
         
    }
    
    /**
     * 엑셀파일로 출력한다. (데이터)
     * @param 
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsPsnl0200Export.do")
    public ModelAndView xlsPsnl0200Export(@ModelAttribute("Psnl0110VO") Psnl0110VO psnl0110Vo, HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
    	
//       model.get("dataList");
//    	System.out.println("데이터 사이즈 : " +  psnl0110Vo.getDataList().length());
    	
    	
    	String method = calledClass + ".XlsPsnl0200Export";
    	
    	String windowNm = "";
		String windowId = "PSNL0200";
		
    	
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        Map<String, Object> map = new HashMap<String, Object>();
        
        
        
        Map<String, Object> colMap = new HashMap<String, Object>();
        Map<Integer, Object> rowMap = new HashMap<Integer, Object>();
        List<Psnl0110VO> excelList = new ArrayList<Psnl0110VO>();
        Psnl0110VO returnPsnl0110Vo = new Psnl0110VO();
        
        
		try{
			
			if(psnl0110Vo.getDataList() == null || "".equals(psnl0110Vo.getDataList())) {			
//			if(param.get("dataList") == null) {
				
				excelList = new ArrayList<Psnl0110VO>();
				
				returnPsnl0110Vo.setDataChk("엑셀 저장 오류 및 저장할 데이터가 없습니다.");
				
				excelList.add(returnPsnl0110Vo);
				
			}else {
				
				// 전체 데이터를 배열로 담는다.
				String excelDataStr = psnl0110Vo.getDataList();	// ex : ( col1=temp1, col2=temp2... |  col3=temp1, col4=temp2 )		
//				String excelDataStr = psnl0110Vo.getDataList().toString();
				String[] excelDataArr = excelDataStr.split(";"); // ex : ( col1=temp1, col2=temp2... )			
				
				// 데이터를 한 행씩 만든다.
				for (int i = 0; i < excelDataArr.length; i++) {
					

					String dataListStr = excelDataArr[i];			// 데이터의 한 행, ex : ( col1=temp1, col2=temp2... )			
					String[] dataListArr = dataListStr.split(",");  // 데이터 한 행의 열의 배열 ex : ( col1=temp1 )
					
					// 데이터를 한 열씩 잘라준다.
					
					colMap = new HashMap<String, Object>();
					returnPsnl0110Vo = new Psnl0110VO();
					
					for (int j = 0; j < dataListArr.length; j++) {
						
						String dataStr = dataListArr[j];			// 데이터 한 행의 한 열
						String[] dataArr = dataStr.split("=");		// 데이터의 한 행의 한 열의 배열, ex : ( col1, temp1 )
						
						// 컬럼의 값을 map에 담아준다.
						colMap.put(dataArr[0], dataArr[1]);
						
//						System.out.println(dataArr[0] + " : " + dataArr[1]);
						
						if(colMap.size() == dataListArr.length) {	
							
							returnPsnl0110Vo.setDataChk(MSFSharedUtils.allowNulls(colMap.get("dataChk")));
							returnPsnl0110Vo.setEmymtNewTypCd(MSFSharedUtils.allowNulls(colMap.get("emymtNewTypCd")));
							returnPsnl0110Vo.setEmymtNewTypNm(MSFSharedUtils.allowNulls(colMap.get("emymtNewTypNm")));
							returnPsnl0110Vo.setEmymtTypCd(MSFSharedUtils.allowNulls(colMap.get("emymtTypCd")));
							returnPsnl0110Vo.setEmymtTypNm(MSFSharedUtils.allowNulls(colMap.get("emymtTypNm")));
							returnPsnl0110Vo.setMangeDeptCd(MSFSharedUtils.allowNulls(colMap.get("mangeDeptCd")));
							returnPsnl0110Vo.setMangeDeptNm(MSFSharedUtils.allowNulls(colMap.get("mangeDeptNm")));
							returnPsnl0110Vo.setResnRegnNum(MSFSharedUtils.allowNulls(colMap.get("resnRegnNum")));
							returnPsnl0110Vo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(colMap.get("currAffnDeptCd")));
							returnPsnl0110Vo.setCurrAffnDeptNm(MSFSharedUtils.allowNulls(colMap.get("currAffnDeptNm")));
							returnPsnl0110Vo.setHanNm(MSFSharedUtils.allowNulls(colMap.get("hanNm")));
							returnPsnl0110Vo.setChinCharNm(MSFSharedUtils.allowNulls(colMap.get("chinCharNm")));
							returnPsnl0110Vo.setEmymtBgnnDt(MSFSharedUtils.allowNulls(colMap.get("emymtBgnnDt")));
							returnPsnl0110Vo.setEmymtEndDt(MSFSharedUtils.allowNulls(colMap.get("emymtEndDt")));
							returnPsnl0110Vo.setBusinApptnYr(MSFSharedUtils.allowNulls(colMap.get("businApptnYr")));
							returnPsnl0110Vo.setBusinCd(MSFSharedUtils.allowNulls(colMap.get("businCd")));
							returnPsnl0110Vo.setBusinNm(MSFSharedUtils.allowNulls(colMap.get("businNm")));
							returnPsnl0110Vo.setCurrPaeWorkNm(MSFSharedUtils.allowNulls(colMap.get("currPaeWorkNm")));
							
							
							returnPsnl0110Vo.setHusRoadNmZpcd(MSFSharedUtils.allowNulls(colMap.get("husRoadNmZpcd")));            
							returnPsnl0110Vo.setHusRoadNmFndtnAddr(MSFSharedUtils.allowNulls(colMap.get("husRoadNmFndtnAddr")));       
							returnPsnl0110Vo.setHusRoadNmDtlPatrAddr(MSFSharedUtils.allowNulls(colMap.get("husRoadNmDtlPatrAddr")));     
							returnPsnl0110Vo.setHusPhnNum(MSFSharedUtils.allowNulls(colMap.get("husPhnNum")));                
							returnPsnl0110Vo.setCellPhneNum(MSFSharedUtils.allowNulls(colMap.get("cellPhneNum")));              
							                                                                                          
							returnPsnl0110Vo.setDabtyDivCd(MSFSharedUtils.allowNulls(colMap.get("dabtyDivCd")));               
							returnPsnl0110Vo.setDabtyGrdeCd(MSFSharedUtils.allowNulls(colMap.get("dabtyGrdeCd")));              
							returnPsnl0110Vo.setDabtyAjmtDt(MSFSharedUtils.allowNulls(colMap.get("dabtyAjmtDt")));              

							returnPsnl0110Vo.setEmymtReasCtnt(MSFSharedUtils.allowNulls(colMap.get("emymtReasCtnt")));
							
							excelList.add(returnPsnl0110Vo);
//							colMap = new HashMap<String, Object>();
//							returnPsnl0110Vo = new Psnl0110VO();
						}
					}
				}
			}
			

			
	        map = new HashMap<String, Object>();
	        map.put("listFilePsnl", excelList);
	        
	        
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
        
        return new ModelAndView("psnlP020001ExcelView", map);
         
    }
      
    
    
    
    
    
    
    /**
     * 엑셀파일로 출력한다. (데이터)
     * @param 
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsPsnl0200TestExport.do")
    public ModelAndView xlsPsnl0200Exporttt(@ModelAttribute("exlDatList") List<HashMap<String, String>> exlDatList, HttpServletRequest request , ModelMap model) 
                    throws Exception { 
    	
    	
    	
    	String method = calledClass + ".XlsPsnl0200Export";
    	
    	String windowNm = "";
		String windowId = "PSNL0200";
		
    	
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        Map<String, Object> map = new HashMap<String, Object>();
        
        
        
        Map<String, Object> colMap = new HashMap<String, Object>();
        Map<Integer, Object> rowMap = new HashMap<Integer, Object>();
        List<Psnl0110VO> excelList = new ArrayList<Psnl0110VO>();
        Psnl0110VO returnPsnl0110Vo = new Psnl0110VO();
        
        
		try{
			
			System.out.println(exlDatList.iterator());
		
        }catch(Exception e) {
        	e.printStackTrace();
        	
	    	/** 에러 로그 **/			
	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);
        	
        }
        
        return new ModelAndView("psnlP020001ExcelView", map);
         
    }
      
  
    
    
    
    
    
    
    
}
