/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.app.exterms.resm.server.service;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.resm.client.dto.Bass0500DTO;
import com.app.exterms.resm.client.service.ResmP320001Service;
import com.app.exterms.resm.server.service.dao.ResmIfBass0500DAO;
import com.app.exterms.resm.server.vo.Bass0500VO;
import com.app.exterms.resm.shared.ResmDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFErrorMessage;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.psl.dataaccess.util.EgovMap;

@Service("ResmP320001Service")
public class ResmP320001ServiceImpl extends AbstractCustomServiceImpl implements
		ResmDaoConstants, ResmP320001Service {
	
	private static final Logger logger = LoggerFactory.getLogger(ResmP320001ServiceImpl.class);
	private static final String calledClass = ResmP320001ServiceImpl.class.getName();
	
	@Autowired
	@Resource(name = "ResmIfBass0500DAO")
	private ResmIfBass0500DAO bass0500DAO;

	
	/** 사업 이관 **/
	@Override
	public int trnrBusinBass0500(List<Bass0500DTO> listBass0500Dto)throws MSFException {
		
		String method = calledClass + ".trnrBusinBass0500";
		
		String windowNm = "이전사업이관";
		String windowId = "RESMP320001";
		
		
    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		Bass0500VO  bass0500Vo = new Bass0500VO();
		
		int result = 0;
		
		
		try{
			
            for(int iBassCnt=0; iBassCnt < listBass0500Dto.size(); iBassCnt++) {
                
            	Bass0500DTO bass0500Dto = new Bass0500DTO();  
            	bass0500Dto = listBass0500Dto.get(iBassCnt);   
            	
            	bass0500Vo.setDpobCd(MSFSharedUtils.allowNulls(bass0500Dto.getDpobCd()));    				/** column 사업장코드 : dpobCd */
            	bass0500Vo.setDeptCd(MSFSharedUtils.allowNulls(bass0500Dto.getDeptCd()));    				/** column 부서코드 : deptCd */
            	bass0500Vo.setBusinApptnYr(MSFSharedUtils.allowNulls(bass0500Dto.getBusinBfrApptnYr()));	/** column 사업적용년도 : businApptnYr */ //이전
            	bass0500Vo.setBusinCd(MSFSharedUtils.allowNulls(bass0500Dto.getBusinCd()));    				/** column 사업코드 : businCd */
            	bass0500Vo.setBusinNm(MSFSharedUtils.allowNulls(bass0500Dto.getBusinNm().trim()));    		/** column 사업명 : businNm */
            	
            	int iCnt = bass0500DAO.selectBass0500BfrBusinYrListCnt(bass0500Vo);
            	
            	
            	// 이전년도에 동일한 사업이 존재할 경우
            	if(iCnt == 1) {
            		
            		// 이관하려는 년도에 동일한 사업이 있는지 체크한다.
            		bass0500Vo = new Bass0500VO();
            		
                	bass0500Vo.setDpobCd(MSFSharedUtils.allowNulls(bass0500Dto.getDpobCd()));    				/** column 사업장코드 : dpobCd */
                	bass0500Vo.setDeptCd(MSFSharedUtils.allowNulls(bass0500Dto.getCreDeptCd()));    			/** column 생성 부서코드 : deptCd */
                	bass0500Vo.setBusinApptnYr(MSFSharedUtils.allowNulls(bass0500Dto.getBusinCreApptnYr())); 	/** column 사업적용년도 : businApptnYr */ //이관
                	bass0500Vo.setBusinNm(MSFSharedUtils.allowNulls(bass0500Dto.getBusinNm().trim()));    		/** column 사업명 : businNm */
            		
            		iCnt = 0;
            		iCnt =	bass0500DAO.selectBass0500BfrBusinYrListCnt(bass0500Vo);
            		
            		if(iCnt == 1) {
            			MSFErrorMessage errMsg1 = new MSFErrorMessage("", "", 2, "이미 존재하는 사업입니다.<br>해당 년도 사업 내역을 확인해주세요."); 
            			throw MSFServerUtils.getValidationException("trnrBusinBass0500_bass0500DAO.selectBass0500BfrBusinYrListCnt(bass0500Vo)", errMsg1, logger) ; 
            		}
            		
            		
            		// 동일한 사업이 없을 경우 vo에 담는다.
            		bass0500Vo = new Bass0500VO();
            		
                	bass0500Vo.setDpobCd(MSFSharedUtils.allowNulls(bass0500Dto.getDpobCd()));    				/** column 사업장코드 : dpobCd */
                	bass0500Vo.setDeptCd(MSFSharedUtils.allowNulls(bass0500Dto.getBrfDeptCd()));    			/** column 부서코드 : deptCd */
                	bass0500Vo.setBusinApptnYr(MSFSharedUtils.allowNulls(bass0500Dto.getBusinBfrApptnYr()));  	/** column 사업적용년도 : businApptnYr */ //이전
                	bass0500Vo.setBusinCd(MSFSharedUtils.allowNulls(bass0500Dto.getBusinCd()));    				/** column 사업코드 : businCd */
                	bass0500Vo.setBusinNm(MSFSharedUtils.allowNulls(bass0500Dto.getBusinNm().trim()));    		/** column 사업명 : businNm */

        	        //조회하여 이전 사업 정보를 가져옴
        			List bass0500BusinList = bass0500DAO.selectBass0500BfrBusinYrList(bass0500Vo);
        			
        			if(bass0500BusinList.size() == 0) {
            			MSFErrorMessage errMsg1 = new MSFErrorMessage("", "", 2, bass0500Dto.getBusinBfrApptnYr() + "년도에 해당 사업이 존재하지 않습니다." + "<br>해당 년도 사업 내역을 확인해주세요."); 
            			throw MSFServerUtils.getValidationException("trnrBusinBass0500_bass0500DAO.selectBass0500BfrBusinYrListCnt(bass0500Vo)", errMsg1, logger) ; 
        			}
        			
        			// 이전년도 사업 정보를 담아 insert 해준다.
        			for (int i = 0; i < bass0500BusinList.size(); i++) {
        			
	            		EgovMap egovMap = (EgovMap) bass0500BusinList.get(i);
	            		
	            		bass0500Vo.setDpobCd(MSFSharedUtils.allowNulls(egovMap.get("dpobCd")));    														/** column 사업장코드 : dpobCd */
	            		bass0500Vo.setDeptCd(MSFSharedUtils.allowNulls(bass0500Dto.getCreDeptCd()));    												/** column 부서코드 : deptCd */
	            		bass0500Vo.setBusinApptnYr(MSFSharedUtils.allowNulls(bass0500Dto.getBusinCreApptnYr()));    									/** column 사업적용년도 : businApptnYr */ //생성
	            		bass0500Vo.setBusinCd(MSFSharedUtils.allowNulls(egovMap.get("businCd")));    													/** column 사업코드 : businCd */
	            		bass0500Vo.setBusinNm(MSFSharedUtils.allowNulls(egovMap.get("businNm")));   													/** column 사업명 : businNm */
	            		bass0500Vo.setBusinEmymtTypOccuCd(MSFSharedUtils.allowNulls(egovMap.get("businEmymtTypOccuCd"))); 								/** column 사업고용직종코드 : businEmymtTypOccuCd */
	            		bass0500Vo.setBusinRepbtyEmpNum(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    											/** column 사업담당직원번호 : businRepbtyEmpNum */
	            		bass0500Vo.setIdtlAccdtInsurApmrt(new BigDecimal(MSFSharedUtils.defaultNulls(egovMap.get("idtlAccdtInsurApmrt"), "0")));    	/** column 산재보험요율 : idtlAccdtInsurApmrt */
	            		bass0500Vo.setSpityCtnt(MSFSharedUtils.allowNulls(egovMap.get("spityCtnt")));    												/** column 특기사항내용 : spityCtnt */
	            		bass0500Vo.setNatPennSym(MSFSharedUtils.allowNulls(egovMap.get("natPennSym")));   							 					/** column 국민연금기호 : natPennSym */
	            		bass0500Vo.setHlthInsrSym(MSFSharedUtils.allowNulls(egovMap.get("hlthInsrSym")));   								 			/** column 건강보험기호 : hlthInsrSym */
	            		bass0500Vo.setUmytInsrSym(MSFSharedUtils.allowNulls(egovMap.get("umytInsrSym")));    											/** column 고용보험기호 : umytInsrSym */
	            		bass0500Vo.setIdtlAccdtInsurSym(MSFSharedUtils.allowNulls(egovMap.get("idtlAccdtInsurSym")));    								/** column 산재보험기호 : idtlAccdtInsurSym */
	            	
//	            		bass0500Vo.setBusinStdt(MSFSharedUtils.allowNulls(egovMap.get("businStdt")));    															/** column null : businStdt */
//	            		bass0500Vo.setBusinEddt(MSFSharedUtils.allowNulls(egovMap.get("businEddt")));    															/** column null : businEddt */
	            		
	            		bass0500Vo.setBusinStdt(MSFSharedUtils.allowNulls(bass0500Dto.getBusinStdt()));    												/** column null : businStdt */
	            		bass0500Vo.setBusinEddt(MSFSharedUtils.allowNulls(bass0500Dto.getBusinEddt()));    												/** column null : businEddt */
	            		
	            		bass0500Vo.setHlthInsrOfceSym(MSFSharedUtils.allowNulls(egovMap.get("hlthInsrOfceSym")));    									/** column 건강보험영업소기호 : hlthInsrOfceSym */
	            		bass0500Vo.setBusinDutyNumDys(new BigDecimal(MSFSharedUtils.defaultNulls(egovMap.get("businDutyNumDys"), "0")));    			/** column 근무일수 : businDutyNumDys */
	            		
	            		bass0500Vo.setKybdr(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 입력자 : kybdr */
	            		bass0500Vo.setInptAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));  					/** column 입력주소 : inptAddr */
	            		bass0500Vo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    														/** column 수정자 : ismt */
	            		bass0500Vo.setRevnAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));    				/** column 수정주소 : revnAddr */
	            		
	            		bass0500DAO.insertBass0500(bass0500Vo);
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
            		
            		MSFErrorMessage errMsg2 = new MSFErrorMessage("", "", 2, "동일한 사업이 두 건 이상 존재합니다.<br>해당 년도 사업 내역을 확인해주세요."); 
            		throw MSFServerUtils.getValidationException("trnrBusinBass0500_bass0500DAO.selectBass0500BfrBusinYrListCnt(bass0500Vo)", errMsg2, logger) ;            		
            		
            	}
            }
			
		}catch(Exception e){
			
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S:C",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName() + " " + "사업 이전 중 오류 발생 <br> 관리자에게 문의해 주세요.", e, logger);
			
		}		
		
		return result;
	}
	
	
	
	
	
	
  
}
