package org.msf.exterms.xls.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.xls.service.Stts0100ExcelService;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.exterms.statistics.server.vo.Stts0100SrhVO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class Stts0100ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(Stts0100ExcelController.class);  
    private static final String calledClass = Stts0100ExcelController.class.getName();
 
    
    @Resource(name = "stts0100ExcelService")
    private Stts0100ExcelService stts0100ExcelService;
	
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    

    /**
     * 엑셀파일로 출력한다. (상단버튼)
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
	@RequestMapping(value="/exp/XlsStts0100Export.do")
	public ModelAndView XlsStts0100Export(@ModelAttribute("Stts0100SrhVO") Stts0100SrhVO stts0100SrhVo, HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
		
		String method = calledClass + ".XlsStts0100Export"; 
		
		String windowNm = "휴가일수산정";
		String windowId = "PSNL0290";
       
       
//        dlgn0250SrhVo.setTypOccucdIn("");
//        dlgn0250SrhVo.setPyspGrdeCdIn("");
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        List<String> listDeptCd = new ArrayList<String>();  
        Map<String, Object> map = new HashMap<String, Object>();
        
		try{
        
			stts0100SrhVo.setDpobCd(sessionUser.getDpobCd());  										//사업장코드
			stts0100SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(stts0100SrhVo.getEmymtDivCd()));	//고용구분코드
			stts0100SrhVo.setPymtYrMnth(stts0100SrhVo.getPymtYrMnth());	 							//작업년월
	        listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(stts0100SrhVo.getDeptCd()));  
	        stts0100SrhVo.setDeptCd(MSFSharedUtils.allowNulls(stts0100SrhVo.getDeptCd()));
	        stts0100SrhVo.setDeptCdArr(listDeptCd);     														//부서코드  
	        stts0100SrhVo.setBusinCd(MSFSharedUtils.allowNulls(stts0100SrhVo.getBusinCd()));   		//사업코드 
			
//	        psnl0126SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
//	        
//	        psnl0126SrhVO.setSystemkey(MSFSharedUtils.allowNulls(psnl0126SrhVO.getSystemkey()));	//시스템키
//	        psnl0126SrhVO.setHanNm(MSFSharedUtils.allowNulls(psnl0126SrhVO.getHanNm()));			//성명
////	        psnl0126SrhVO.setResnRegnNum(MSFSharedUtils.allowNulls(psnl0126SrhVO.getResnRegnNum()));//주민번호
//	    	// 2. 파라미터 보낼 때(암호화)
//	    	psnl0126SrhVO.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(psnl0126SrhVO.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
//	        
//	        
//	        
//	        psnl0126SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(psnl0126SrhVO.getEmymtDivCd()));	//고용구분코드
//	        
//	      	List<String> lsHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(psnl0126SrhVO.getHdofcCodtnCd())); 
//	      	psnl0126SrhVO.setHdofcCodtnCdArr(lsHdofcCodtnCd);  
//	        
//	        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(psnl0126SrhVO.getTypOccuCd())); 
//	     	psnl0126SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
//	     
//	//      List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(psnl0126SrhVO.getPyspGrdeCd())); 
//	//      psnl0126SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
//	       
//	     	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(psnl0126SrhVO.getDtilOccuInttnCd())); 
//	     	psnl0126SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
//	      
//	     	psnl0126SrhVO.setBusinCd(MSFSharedUtils.allowNulls(psnl0126SrhVO.getBusinCd()));   //사업코드 
//	        psnl0126SrhVO.setHodyFixYn(psnl0126SrhVO.getHodyFixYn()); 							//확정여부
//	        
//	        psnl0126SrhVO.setUsrId(sessionUser.getUsrId());   
//	        
//	        
//	        /******************************** 권한 ************************************************************************/
//	        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
//	        
//	     	if ("FALSE".equals(chkDeptCd)) {
//	     		psnl0126SrhVO.setDeptCd(sessionUser.getDeptCd()); 
//	     		listDeptCd.add(MSFSharedUtils.allowNulls(sessionUser.getDeptCd()));
//	     		psnl0126SrhVO.setDeptCdArr(listDeptCd);     //부서코드    
//	     		psnl0126SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
//	     	} else {
//	     		psnl0126SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(psnl0126SrhVO.getPayrMangDeptCd()));    
//	     		
//	     		if (psnl0126SrhVO.getPayrMangDeptCd().equals(psnl0126SrhVO.getDeptCd())) { 
//	     			listDeptCd = null; 
//	               	psnl0126SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
//	               	psnl0126SrhVO.setDeptCd("");  //부서코드
//	     		} else {
//	     			psnl0126SrhVO.setDeptCd(MSFSharedUtils.allowNulls(psnl0126SrhVO.getDeptCd()));
//	     			listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(psnl0126SrhVO.getDeptCd()));  
//	     			psnl0126SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
//	     		} 
//	     	}
//	      
//	      
//	     	psnl0126SrhVO.setDeptCdAuth(psnl0126SrhVO.getDeptCd().replace(",", ""));  //권한처리를위해 추가  
//	     	psnl0126SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(psnl0126SrhVO.getDtilOccuInttnCd()).replace(",", ""));
//	       
//	     	/******************************** 권한 ************************************************************************/
//	        
	     	
//	        if((detailYmKubn.compareTo(dto.getDilnlazYrMnth().replaceAll("\\.", "")) >= 0 )){ //기준일 전
//            	//삭제처리 후 
//                dlgn0100Dao.deleteDlgn0110(dto);
//	            dlgn0100Dao.deleteDlgn0100(dto);  
//                
//                //인서트 처리 
//	            dlgn0100Dao.insertDlgn0100(dto);
//            	dlgn0100Dao.insertDlgn0110Pre(dto);
//            }else{ //기준일 후
//            	//삭제처리 후 
//                dlgn0100Dao.deleteDlgn0110(dto);
//	            dlgn0100Dao.deleteDlgn0100(dto);  
//                
//                //인서트 처리 
//	            dlgn0100Dao.insertDlgn0100(dto);
//            	dlgn0100Dao.insertDlgn0110(dto);
//            }
//	     	
//	         
	     	List  listStts0100 = stts0100ExcelService.selectStts0100List(stts0100SrhVo);
	     	
			String strValue = "";
			List<EgovMap> excelList = new ArrayList<EgovMap>();

		    for(int i=0; i<listStts0100.size(); i++){
	    		EgovMap eMap  = new EgovMap();
	    		Iterator<String> keys = eMap.keySet().iterator();
	    		eMap = (EgovMap) listStts0100.get(i);
	    		
	    		// 복호화	
	    		strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	    		eMap.put("resnRegnNum", strValue);
		    		
	    		excelList.add(eMap);
	    	}
	     	
	        map = new HashMap<String, Object>();
	        map.put("year", stts0100SrhVo.getPymtYrMnth().substring(0, 4));
	        map.put("month",stts0100SrhVo.getPymtYrMnth().substring(4));
	        map.put("listStts0100", excelList);
        
        }catch(Exception e) {
        	e.printStackTrace();
        	
	    	/** 에러 로그 **/			
	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);
        	
        }
        
        
        return new ModelAndView("stts0100ExcelView", map);
         
	}
    
    
}
