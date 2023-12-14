package com.app.exterms.basis.server.service;

import java.util.List;

import javax.annotation.Resource;

import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.basis.client.dto.Bass0350DTO;
import com.app.exterms.basis.client.service.BassP035001Service;
import com.app.exterms.basis.server.service.dao.Bass0320DAO;
import com.app.exterms.basis.server.service.dao.Bass0350DAO;
import com.app.exterms.basis.server.vo.Bass0320VO;
import com.app.exterms.basis.server.vo.Bass0350VO;
import com.app.exterms.basis.shared.BasisDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFErrorMessage;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.psl.dataaccess.util.EgovMap;

@Service("BassP035001Service")
public class BassP035001ServiceImpl extends AbstractCustomServiceImpl implements BasisDaoConstants, BassP035001Service {
	
	private static final Logger logger = LoggerFactory.getLogger(BassP035001ServiceImpl.class);
	private static final String calledClass = BassP035001ServiceImpl.class.getName();
	
	
	@Autowired
	@Resource(name = "Bass0350DAO")
	private Bass0350DAO bass0350DAO;
	
	@Autowired
	@Resource(name = "Bass0320DAO")
	private Bass0320DAO bass0320DAO;


	/** 개편전 직종세 이관 **/
	@Override
	public int trnrBeDtilOccuClsDivBass0350(List<Bass0350DTO> listBass0350Dto)throws MSFException {
		
		String method = calledClass + ".trnrDtilOccuClsDivBass0350";
		
		String windowNm = "개편 직종-직종세 이관";
		String windowId = "BASSP035001";
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		Bass0350VO  bass0350Vo = new Bass0350VO();
		Bass0320VO  bass0320Vo = new Bass0320VO();
		
		int result = 0;
		
		try{
			
            for(int iBassCnt=0; iBassCnt < listBass0350Dto.size(); iBassCnt++) {
                
            	/** 개편전 직종에서 개편후 직종으로 이관 */
            	Bass0350DTO bass0350Dto = new Bass0350DTO();  
            	bass0350Dto = listBass0350Dto.get(iBassCnt);               	
            	bass0350Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));    					/** column 사업장코드 : dpobCd */
            	bass0350Vo.setTypOccuCd(MSFSharedUtils.allowNulls(bass0350Dto.getChngTypOccuCdBe()));  			/** column 개편전 직종코드 : chngTypOccuCdBe */ 	
            	bass0350Vo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bass0350Dto.getDtilOccuInttnCd()));		/** column 직종세코드: dtilOccuClsDivCd */ 	
            	bass0350Vo.setDtilOccuClsNm(MSFSharedUtils.allowNulls(bass0350Dto.getDtilOccuClsNm()));			/** column 직종세명: dtilOccuClsDivNm */ 
            	
            	int iCnt = bass0350DAO.selectBassP035001ListTotCnt(bass0350Vo);
            	
            	/** 개편적 직종과 개편후 직종의 관계 조건 시작 */
        		Bass0320VO bass0320VoChk = new Bass0320VO();
        		bass0320Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
            	bass0320Vo.setTypOccuCd(MSFSharedUtils.allowNulls(bass0350Dto.getChngTypOccuCdAf()));            	
            	bass0320VoChk= bass0320DAO.selectBass0320(bass0320Vo);

            	if(bass0320VoChk.getChngTypOccuCd() == null){
        			MSFErrorMessage errMsg1 = new MSFErrorMessage("","", 2,"개편후 직종 : "+ bass0350Dto.getChngTypOccuCdAf()+"에 개편전 직종이 존재하지 않습니다. 다시 확인해주세요."); 
        			throw MSFServerUtils.getValidationException("trnrBeDtilOccuClsDivBass0350_bass0320DAO.selectBass0320(bass0320Vo)", errMsg1, logger) ;
        		}else if(!bass0320VoChk.getChngTypOccuCd().equals(bass0350Dto.getChngTypOccuCdBe())){
            		MSFErrorMessage errMsg1 = new MSFErrorMessage("", "", 2, "개편후 직종과 개편전 직종이 정확하지 않습니다.<br>다시 확인해주세요."); 
        			throw MSFServerUtils.getValidationException("trnrBeDtilOccuClsDivBass0350_bass0320DAO.selectBass0320(bass0320Vo)", errMsg1, logger) ; 
        		}
            	/** 개편적 직종과 개편후 직종의 관계 조건 종료 */
            	
            	// 개편전 직종에 동일한 직종세가 존재할 경우
            	if(iCnt == 1) {
            		
            		// 이관하려는 직종에 동일한 직종세가 있는지 체크한다.
            		bass0350Vo = new Bass0350VO();
            		bass0350Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));    					/** column 사업장코드 : dpobCd */
                	bass0350Vo.setTypOccuCd(MSFSharedUtils.allowNulls(bass0350Dto.getChngTypOccuCdAf()));  			/** column 개편후 직종코드 : chngTypOccuCdAf */ 	
                	bass0350Vo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bass0350Dto.getDtilOccuInttnCd()));	/** column 직종세코드: dtilOccuClsDivCd */ 	
                	bass0350Vo.setDtilOccuClsNm(MSFSharedUtils.allowNulls(bass0350Dto.getDtilOccuClsNm()));			/** column 직종세명: dtilOccuClsDivNm */
            		
            		iCnt = 0;
            		iCnt = bass0350DAO.selectBassP035001ListTotCnt(bass0350Vo);
            		            		
            		if(iCnt == 1) {
            			MSFErrorMessage errMsg1 = new MSFErrorMessage("", "", 2, "이미 존재하는 직종세입니다.<br>해당 직종세 내역을 확인해주세요."); 
            			throw MSFServerUtils.getValidationException("trnrBeDtilOccuClsDivBass0350_bass0350DAO.selectBassP035001ListTotCnt(bass0350Vo)", errMsg1, logger) ; 
            		}
            		
            		// 동일한 사업이 없을 경우 vo에 담는다.
            		bass0350Vo = new Bass0350VO();
            		
            		bass0350Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));    					/** column 사업장코드 : dpobCd */
                	bass0350Vo.setTypOccuCd(MSFSharedUtils.allowNulls(bass0350Dto.getChngTypOccuCdBe()));  			/** column 개편전 직종코드 : chngTypOccuCdBe */ 	
                	bass0350Vo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bass0350Dto.getDtilOccuInttnCd()));	/** column 직종세코드: dtilOccuClsDivCd */ 	
                	bass0350Vo.setDtilOccuClsNm(MSFSharedUtils.allowNulls(bass0350Dto.getDtilOccuClsNm()));			/** column 직종세명: dtilOccuClsDivNm */

        	        //조회하여 이전 사업 정보를 가져옴
        			List bass0350ChngList = bass0350DAO.selectBassP035001List(bass0350Vo);
        			
        			if(bass0350ChngList.size() == 0) {
            			MSFErrorMessage errMsg1 = new MSFErrorMessage("", "", 2, bass0350Dto.getChngTypOccuCdBe() + "에 해당 직종세가 존재하지 않습니다." + "<br>해당 직종의 직종세를 확인해주세요."); 
            			throw MSFServerUtils.getValidationException("trnrBeDtilOccuClsDivBass0350_bass0350DAO.selectBassP035001List(bass0350Vo)", errMsg1, logger) ; 
        			}
        			
        			// 이전년도 사업 정보를 담아 insert 해준다.
        			for (int i = 0; i < bass0350ChngList.size(); i++) {
        			
	            		EgovMap egovMap = (EgovMap) bass0350ChngList.get(i);
	            		
	            		bass0350Vo = new Bass0350VO();
	            		
	            		bass0350Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));    					/** column 사업장코드 : dpobCd */
	            		bass0350Vo.setTypOccuCd(MSFSharedUtils.allowNulls(bass0350Dto.getChngTypOccuCdAf()));											/** column 개편전 직종코드 : chngTypOccuCdBe */          		
	            		bass0350Vo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bass0350Dto.getDtilOccuInttnCd()));
	            		
	            		bass0350Vo.setKybdr(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 입력자 : kybdr */
	            		bass0350Vo.setInptAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));  					/** column 입력주소 : inptAddr */
	            		bass0350Vo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 수정자 : ismt */
	            		bass0350Vo.setRevnAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));    				/** column 수정주소 : revnAddr */
	            		           		
	            		bass0350DAO.updateBassP035001(bass0350Vo);
        			}
        			
	    			/** 로그반영
	    			 * CRUDSBLO
	    			 * C:create		R:read		U:update
	    	    	 * D:delete		S:select	B:배치 
	    	    	 * L:로그인		O:로그아웃
	    	    	 */
	    			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S:C");
            		
            		result = result + 1;
            		
            	}else if(iCnt > 1){
            	
            		
            		MSFErrorMessage errMsg2 = new MSFErrorMessage("", "", 2, "동일한 직종세가 두 건 이상 존재합니다.<br>해당 직종세 내역을 확인해주세요."); 
            		throw MSFServerUtils.getValidationException("trnrBeDtilOccuClsDivBass0350_bass0350DAO.selectBassP035001ListTotCnt(bass0350Vo)", errMsg2, logger) ;            		
            		
            	}
            }	
			
		}catch(Exception e){
			
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S:C",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName() + " " + "직종세 이전 중 오류 발생 <br> 관리자에게 문의해 주세요.", e, logger);
			
		}		
		
		return result;
	}
	
	/** 개편후 직종세 이관 **/
	@Override
	public int trnrAfDtilOccuClsDivBass0350(List<Bass0350DTO> listBass0350Dto)throws MSFException {
		
		String method = calledClass + ".trnrAfDtilOccuClsDivBass0350";
		
		String windowNm = "개편 직종-직종세 이관";
		String windowId = "BASSP035001";
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		Bass0350VO  bass0350Vo = new Bass0350VO();
		Bass0320VO  bass0320Vo = new Bass0320VO();
		
		int result = 0;
		
		try{
			
            for(int iBassCnt=0; iBassCnt < listBass0350Dto.size(); iBassCnt++) {
                            
            	/** 개편전 직종에서 개편후 직종으로 이관 */
            	Bass0350DTO bass0350Dto = new Bass0350DTO();  
            	bass0350Dto = listBass0350Dto.get(iBassCnt);               	
            	bass0350Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));    					/** column 사업장코드 : dpobCd */
            	bass0350Vo.setTypOccuCd(MSFSharedUtils.allowNulls(bass0350Dto.getChngTypOccuCdAf()));  			/** column 개편후 직종코드 : chngTypOccuCdAf */	
            	bass0350Vo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bass0350Dto.getDtilOccuInttnCd()));	/** column 직종세코드: dtilOccuClsDivCd */ 	
            	bass0350Vo.setDtilOccuClsNm(MSFSharedUtils.allowNulls(bass0350Dto.getDtilOccuClsNm()));			/** column 직종세명: dtilOccuClsDivNm */ 
            	
            	int iCnt = bass0350DAO.selectBassP035001ListTotCnt(bass0350Vo);
            	 

            	/** 개편적 직종과 개편후 직종의 관계 조건 시작*/
        		Bass0320VO bass0320VoChk = new Bass0320VO();
        		bass0320Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
            	bass0320Vo.setTypOccuCd(MSFSharedUtils.allowNulls(bass0350Dto.getChngTypOccuCdAf()));            	
            	bass0320VoChk= bass0320DAO.selectBass0320(bass0320Vo);
            	 
            	if(bass0320VoChk.getChngTypOccuCd() == null){
            		MSFErrorMessage errMsg1 = new MSFErrorMessage("","", 2,"개편후 직종 : "+ bass0350Dto.getChngTypOccuCdAf()+"에 개편전 직종이 존재하지 않습니다. 다시 확인해주세요."); 
        			throw MSFServerUtils.getValidationException("trnrBeDtilOccuClsDivBass0350_bass0320DAO.selectBass0320(bass0320Vo)", errMsg1, logger) ;
        		}else if(!bass0320VoChk.getChngTypOccuCd().equals(bass0350Dto.getChngTypOccuCdBe())){
            		MSFErrorMessage errMsg1 = new MSFErrorMessage("", "", 2, "개편후 직종과 개편전 직종이 정확하지 않습니다.<br>다시 확인해주세요."); 
        			throw MSFServerUtils.getValidationException("trnrBeDtilOccuClsDivBass0350_bass0320DAO.selectBass0320(bass0320Vo)", errMsg1, logger) ; 
        		}
            	/** 개편적 직종과 개편후 직종의 관계 조건 종료*/
            	
            	// 개편전 직종에 동일한 직종세가 존재할 경우
            	if(iCnt == 1) {
            		
            		// 이관하려는 직종에 동일한 직종세가 있는지 체크한다.
            		bass0350Vo = new Bass0350VO();
            		bass0350Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));    					/** column 사업장코드 : dpobCd */
                	bass0350Vo.setTypOccuCd(MSFSharedUtils.allowNulls(bass0350Dto.getChngTypOccuCdBe()));  			/** column 개편전 직종코드 : chngTypOccuCdBe */ 	
                	bass0350Vo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bass0350Dto.getDtilOccuInttnCd()));	/** column 직종세코드: dtilOccuClsDivCd */ 	
                	bass0350Vo.setDtilOccuClsNm(MSFSharedUtils.allowNulls(bass0350Dto.getDtilOccuClsNm()));			/** column 직종세명: dtilOccuClsDivNm */
                	
            		iCnt = 0;
            		iCnt = bass0350DAO.selectBassP035001ListTotCnt(bass0350Vo);    
            		                	
            		if(iCnt == 1) {
            			MSFErrorMessage errMsg1 = new MSFErrorMessage("", "", 2, "이미 존재하는 직종세입니다.<br>해당 직종세 내역을 확인해주세요."); 
            			throw MSFServerUtils.getValidationException("trnrAfDtilOccuClsDivBass0350_bass0350DAO.selectBassP035001ListTotCnt(bass0350Vo)", errMsg1, logger) ; 
            		}
            		
            		// 동일한 사업이 없을 경우 vo에 담는다.
            		bass0350Vo = new Bass0350VO();
            		
            		bass0350Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));    					/** column 사업장코드 : dpobCd */
                	bass0350Vo.setTypOccuCd(MSFSharedUtils.allowNulls(bass0350Dto.getChngTypOccuCdAf()));  			/** column 개편후 직종코드 : chngTypOccuCdAf */ 	
                	bass0350Vo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bass0350Dto.getDtilOccuInttnCd()));	/** column 직종세코드: dtilOccuClsDivCd */ 	
                	bass0350Vo.setDtilOccuClsNm(MSFSharedUtils.allowNulls(bass0350Dto.getDtilOccuClsNm()));			/** column 직종세명: dtilOccuClsDivNm */

        	        //조회하여 이전 사업 정보를 가져옴
        			List bass0350ChngList = bass0350DAO.selectBassP035001List(bass0350Vo);
        			
        			if(bass0350ChngList.size() == 0) {
            			MSFErrorMessage errMsg1 = new MSFErrorMessage("", "", 2, bass0350Dto.getChngTypOccuCdBe() + "에 해당 직종세가 존재하지 않습니다." + "<br>해당 직종의 직종세를 확인해주세요."); 
            			throw MSFServerUtils.getValidationException("trnrAfDtilOccuClsDivBass0350_bass0350DAO.selectBassP035001List(bass0350Vo)", errMsg1, logger) ; 
        			}
        			
        			// 이전년도 사업 정보를 담아 insert 해준다.
        			for (int i = 0; i < bass0350ChngList.size(); i++) {
        			
	            		EgovMap egovMap = (EgovMap) bass0350ChngList.get(i);
	            		
	            		bass0350Vo = new Bass0350VO();
	            		
	            		bass0350Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));    					/** column 사업장코드 : dpobCd */
	            		bass0350Vo.setTypOccuCd(MSFSharedUtils.allowNulls(bass0350Dto.getChngTypOccuCdBe()));											/** column 개편전 직종코드 : chngTypOccuCdBe */          		
	            		bass0350Vo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bass0350Dto.getDtilOccuInttnCd()));
	            		
	            		bass0350Vo.setKybdr(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 입력자 : kybdr */
	            		bass0350Vo.setInptAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));  					/** column 입력주소 : inptAddr */
	            		bass0350Vo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 수정자 : ismt */
	            		bass0350Vo.setRevnAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));    				/** column 수정주소 : revnAddr */
	            		           		
	            		bass0350DAO.updateBassP035001(bass0350Vo);
        			}
        			
	    			/** 로그반영
	    			 * CRUDSBLO
	    			 * C:create		R:read		U:update
	    	    	 * D:delete		S:select	B:배치 
	    	    	 * L:로그인		O:로그아웃
	    	    	 */
	    			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S:C");
            		
            		result = result + 1;
            		
            	}else if(iCnt > 1){
            	
            		
            		MSFErrorMessage errMsg2 = new MSFErrorMessage("", "", 2, "동일한 직종세가 두 건 이상 존재합니다.<br>해당 직종세 내역을 확인해주세요."); 
            		throw MSFServerUtils.getValidationException("trnrAfDtilOccuClsDivBass0350_bass0350DAO.selectBassP035001ListTotCnt(bass0350Vo)", errMsg2, logger) ;            		
            		
            	}
            }	
			
		}catch(Exception e){
			
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S:C",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName() + " " + "직종세 이전 중 오류 발생 <br> 관리자에게 문의해 주세요.", e, logger);
			
		}		
		
		return result;
	}

}
