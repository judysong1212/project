package org.msf.exterms.xls.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.msf.exterms.xls.service.Payr1100ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.payroll.client.dto.Payr0100DTO_XLS;
import com.app.exterms.payroll.server.service.dao.Payr0100DAO;
import com.app.exterms.payroll.server.vo.Payr0100SrhVO;
import com.app.exterms.payroll.server.vo.Payr0100VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("payr1100ExcelService")
public class Payr1100ExcelServiceImpl extends AbstractServiceImpl implements Payr1100ExcelService {
	
	private static final Logger logger = LoggerFactory.getLogger(Payr1100ExcelServiceImpl.class);
	private static final String calledClass = Payr1100ExcelService.class.getName();
    
    @Autowired 
    @Resource(name="Payr0100DAO")
    private Payr0100DAO payr0100DAO;

//    
//  public List<payr0100Vo> selectXlspayr0100List(Psnl0126SrhVO psnl0126SrhVO) throws Exception {
//      return psnl0126DAO.selectXlspayr0100List(psnl0126SrhVO);
//  } 
//  
    
    //엑셀파일 저장_jxls(양식)
	public List  selectXlsFilePayr0100List(Payr0100SrhVO payr0100SrhVo) throws Exception {
		return payr0100DAO.selectXlsPayr0100List(payr0100SrhVo);
	}
	
	 /**
	  *  엑셀파일을 등록한다._jxls
	  * @param  hMap
	  * @throws Exception
	  */

	@Override
	public Long insertXlsPayr0100(List<Payr0100DTO_XLS> payr0100List, HttpServletRequest request, HashMap<String, String> param)throws MSFException {
		
		// TODO Auto-generated method stub
		Long result = new Long(0);
		Long iCnt = new Long(0);
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		int monthS = 1;
		int monthE = 12;
		int maxDays = 0;
		
		try {  
			
            /** ++++++++++++++++++++++  기존 간이세액표 마감 처리를 위한 ++++++++++++++++++++++ **/

//            payr0100SrhVo.setApptnStdEndDt("99991231");
            
//            int iResult = payr0100DAO.selectPayr0100ListTotCnt(payr0100SrhVo);
//            if(iResult > 0) {
			
            	Payr0100SrhVO payr0100SrhVo = new Payr0100SrhVO();
            	Payr0100VO payr0100Vo = new Payr0100VO();  
            
            	payr0100SrhVo.setDpobCd(sessionUser.getDpobCd());
            	payr0100SrhVo.setApptnYr(String.valueOf(param.get("createApptnYr")));
            	payr0100SrhVo.setApptnStdEndDt(String.valueOf(param.get("createApptnStdBgnnDt")));
            	
            	/** 화면에서 선택한 적용일자 보다 
            	 * 적용기준시작일자가 작은 데이터의 년도와 기준시작일자를 가져옴
            	 *  -> 직전의 데이터를 가져옴. **/
//            	List payr0100YrList = payr0100DAO.getPayr0100ApptnYrList(payr0100SrhVo);
//				infcBass0360Vo = infcBass0360DAO.getPayrMangDeptCd(infcBass0360SrhVo);
				
//            	if(payr0100YrList.size() <= 0 ) {
//            		
//            	}else {
            	    payr0100Vo.setDpobCd(sessionUser.getDpobCd());
            	    payr0100Vo.setApptnYr(String.valueOf(param.get("createApptnYr")));
//            	    payr0100Vo.setEandIncmBaseDt(MSFSharedUtils.allowNulls(String.valueOf(param.get("createApptnStdBgnnDt"))));    /** column null : eandIncmBaseDt */
//            	    payr0100Vo.setApptnStdBgnnDt(MSFSharedUtils.allowNulls(String.valueOf(param.get("createApptnStdBgnnDt"))));			/** column 적용기준시작일자 : apptnStdBgnnDt */
            	    payr0100Vo.setApptnStdEndDt(String.valueOf(param.get("createApptnStdBgnnDt")));		/** column 적용기준종료일자 : apptnStdEndDt */
//            	    payr0100Vo.setApptnStdEndDt("99991231");
//            	    payr0100Vo.setEandIncmBaseYn(MSFSharedUtils.allowNulls("N"));    		/** column null : eandIncmBaseYn */
    				payr0100Vo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));	/** column 수정자 : ismt */
    				payr0100Vo.setRevnAddr(MSFSharedUtils.allowNulls(request.getRemoteHost()));    /** column 수정주소 : revnAddr */
            		//////////////
//            		for (int i = 0; i < payr0100YrList.size(); i++) {
//    					EgovMap egovMap = (EgovMap) payr0100YrList.get(i);
//    					payr0100Vo.setApptnYr(String.valueOf(egovMap.get("apptnYr")));
//    					payr0100Vo.setApptnStdBgnnDt(String.valueOf(egovMap.get("apptnStdBgnnDt")));	/** column 적용기준시작일자 : apptnStdBgnnDt */
//    				}
//            		
//            		payr0100Vo.setEandIncmBaseDt(MSFSharedUtils.allowNulls(payr0100Vo.getApptnStdBgnnDt()));    /** column null : eandIncmBaseDt */
//    				
//            	    payr0100Vo.setDpobCd(sessionUser.getDpobCd());
//            	    payr0100Vo.setApptnStdEndDt(String.valueOf(param.get("createApptnStdBgnnDt")));		/** column 적용기준종료일자 : apptnStdEndDt */
//            	    payr0100Vo.setEandIncmBaseYn(MSFSharedUtils.allowNulls("N"));    /** column null : eandIncmBaseYn */
    			
    				payr0100DAO.updatePayr0100_apptnStdEndDt(payr0100Vo);
//            	}
//            }
            /** ++++++++++++++++++++++  기존 간이세액표 마감 처리를 위한 ++++++++++++++++++++++ **/
			
			
            /** ++++++++++++++++++++++  간이세액소득표 업로드 부분 ++++++++++++++++++++++ **/
            // 기존 데이터가 있을 경우 삭제하고 insert
            payr0100Vo = new Payr0100VO(); 
            
            
			
			payr0100Vo.setDpobCd(sessionUser.getDpobCd());	/** column 사업장코드 : dpobCd */
			payr0100Vo.setApptnYr(MSFSharedUtils.allowNulls(String.valueOf(param.get("createApptnYr"))));  	/** column 적용년도 : apptnYr */
			payr0100Vo.setApptnStdBgnnDt(String.valueOf(param.get("createApptnStdBgnnDt")));/** column 적용기준시작일자 : apptnStdBgnnDt */

			payr0100DAO.deleteXlsPayr0100(payr0100Vo);
            
			for(int iPsnlCnt=0;iPsnlCnt < payr0100List.size();iPsnlCnt++) {
				
				payr0100Vo = new Payr0100VO();  
				
				Payr0100DTO_XLS payr0100DtoXls = new Payr0100DTO_XLS();
				payr0100DtoXls = payr0100List.get(iPsnlCnt);
				
				BigDecimal bdcl1000 = new BigDecimal("1000");
				
				payr0100Vo.setDpobCd(sessionUser.getDpobCd());    /** column 사업장코드 : dpobCd */
				payr0100Vo.setApptnYr(MSFSharedUtils.allowNulls(String.valueOf(param.get("createApptnYr"))));  /** column 적용년도 : apptnYr */
				payr0100Vo.setEandIncmBaseDt(MSFSharedUtils.allowNulls(String.valueOf(param.get("createApptnStdBgnnDt"))));		/** column null : eandIncmBaseDt */
				payr0100Vo.setApptnStdBgnnDt(MSFSharedUtils.allowNulls(String.valueOf(param.get("createApptnStdBgnnDt"))));		/** column 적용기준시작일자 : apptnStdBgnnDt */
				payr0100Vo.setApptnStdEndDt("99991231");	/** column 적용기준종료일자 : apptnStdEndDt */
				
				//========= 시작일자 계산하여 mapping ========	
//				Calendar  intiCal =  Calendar.getInstance();
//            	SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
//            	
//            	intiCal.set(Integer.parseInt(payr0100Vo.getApptnYr()), monthS -1, 1);
//            	payr0100Vo.setApptnStdBgnnDt(format.format(intiCal.getTime()));	/** column 적용기준시작일자 : apptnStdBgnnDt */
//            	
//            	payr0100Vo.setApptnStdEndDt("99991231");	/** column 적용기준종료일자 : apptnStdEndDt */
//        		
//        		maxDays = intiCal.getActualMaximum (intiCal.DAY_OF_MONTH); 
//        		Calendar  intieCal =   Calendar.getInstance();
//        	    intieCal.set(Integer.parseInt(payr0100Vo.getApptnYr()), monthE - 1, maxDays); 
//        	    payr0100Vo.setApptnStdEndDt(format.format(intiCal.getTime()));	/** column 적용기준종료일자 : apptnStdEndDt */
        	    //========= 시작일자 계산하여 mapping ========	
				
				payr0100Vo.setEandIncmTxtbSimfTxsNum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0100DtoXls.getEandIncmTxtbSimfTxsNum(), "0"))); /** column 근로소득간이세액표일련번호 : eandIncmTxtbSimfTxsNum */
				payr0100Vo.setOvr(new BigDecimal(MSFSharedUtils.defaultNulls(payr0100DtoXls.getOvr(), "0")).multiply(bdcl1000));    /** column 이상 : ovr */
				payr0100Vo.setUdr(new BigDecimal(MSFSharedUtils.defaultNulls(payr0100DtoXls.getUdr(), "0")).multiply(bdcl1000));    /** column 미만 : udr */
				payr0100Vo.setOneOfPepl(new BigDecimal(MSFSharedUtils.defaultNulls(payr0100DtoXls.getOneOfPepl(), "0")));	/** column 1인 : oneOfPepl */
				payr0100Vo.setTwoOfPepl(new BigDecimal(MSFSharedUtils.defaultNulls(payr0100DtoXls.getTwoOfPepl(), "0")));   /** column 2인 : twoOfPepl */
				payr0100Vo.setTreOfGerl(new BigDecimal(MSFSharedUtils.defaultNulls(payr0100DtoXls.getFurOfGerl(), "0")));   /** column 4인일반 : furOfGerl */
				payr0100Vo.setFveOfGerl(new BigDecimal(MSFSharedUtils.defaultNulls(payr0100DtoXls.getFveOfGerl(), "0")));   /** column 5인일반 : fveOfGerl */
				payr0100Vo.setSixOfGerl(new BigDecimal(MSFSharedUtils.defaultNulls(payr0100DtoXls.getSixOfGerl(), "0")));   /** column 6인일반 : sixOfGerl */
				payr0100Vo.setSvnOfGerl(new BigDecimal(MSFSharedUtils.defaultNulls(payr0100DtoXls.getSvnOfGerl(), "0")));   /** column 7인일반 : svnOfGerl */
				payr0100Vo.setEgtOfGerl(new BigDecimal(MSFSharedUtils.defaultNulls(payr0100DtoXls.getEgtOfGerl(), "0")));	/** column 8인일반 : egtOfGerl */
				payr0100Vo.setNineOfGerl(new BigDecimal(MSFSharedUtils.defaultNulls(payr0100DtoXls.getNineOfGerl(), "0")));	/** column 9인일반 : nineOfGerl */
				payr0100Vo.setTenOfGerl(new BigDecimal(MSFSharedUtils.defaultNulls(payr0100DtoXls.getTenOfGerl(), "0")));	/** column 10인일반 : tenOfGerl */
				payr0100Vo.setEvthOfGerl(new BigDecimal(MSFSharedUtils.defaultNulls(payr0100DtoXls.getEvthOfGerl(), "0")));	/** column 11인일반 : evthOfGerl */
				payr0100Vo.setEandIncmBaseYn(MSFSharedUtils.allowNulls("Y"));    /** column null : eandIncmBaseYn */
				payr0100Vo.setKybdr(sessionUser.getUsrId());		/** column 입력자 : kybdr */
				payr0100Vo.setInptAddr(request.getRemoteHost());	/** column 입력주소 : inptAddr */
				payr0100Vo.setIsmt(sessionUser.getUsrId());    		/** column 수정자 : ismt */
				payr0100Vo.setRevnAddr(request.getRemoteHost());    /** column 수정주소 : revnAddr */  


//				payr0100Vo.setKybdr(payr0100Vo.getKybdr());    /** column 입력자 : kybdr */
//				payr0100Vo.setInptDt(payr0100Vo.getInptDt());    /** column 입력일자 : inptDt */
//				payr0100Vo.setInptAddr(payr0100Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//				payr0100Vo.setIsmt(payr0100Vo.getIsmt());    /** column 수정자 : ismt */
//				payr0100Vo.setRevnDt(payr0100Vo.getRevnDt());    /** column 수정일자 : revnDt */
//				payr0100Vo.setRevnAddr(payr0100Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
//				payr0100Vo.setApptnStdBgnnDt(payr0100Vo.getApptnStdBgnnDt());	/** column 적용기준시작일자 : apptnStdBgnnDt */
//				payr0100Vo.setApptnStdEndDt(payr0100Vo.getApptnStdEndDt());    	/** column 적용기준종료일자 : apptnStdEndDt */
				
				
	            payr0100DAO.insertXlsPayr0100(payr0100Vo); 
	            
	            iCnt = iCnt + 1;
	            /** ++++++++++++++++++++++  간이세액소득표 업로드 부분 ++++++++++++++++++++++ **/
			} 
			result = new Long(1);
	          
	        } catch (Exception ex) {
	        	
	            logger.error("EXCEPTION calling insertXlsPayr0100(): "+ex); 
	            
	            result = new Long(0);
	            throw MSFServerUtils.getOperationException("insertXlsPayr0100", ex, logger);
	        }
	        finally {
	          
	        }
		return iCnt;
	}

	 
//	@Override
//	public List updateXlsFilepayr0100List(List<payr0100Vo> listpsnl0126)
//			throws Exception {
//		// TODO Auto-generated method stub
////		return psnl0126DAO.updatePsnl0126(listpsnl0126); 
//	}


  
}
