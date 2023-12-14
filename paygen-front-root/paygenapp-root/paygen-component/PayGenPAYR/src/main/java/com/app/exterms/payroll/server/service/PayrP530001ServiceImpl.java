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
package com.app.exterms.payroll.server.service;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.payroll.client.dto.Payr0490DTO;
import com.app.exterms.payroll.client.service.PayrP530001Service;
import com.app.exterms.payroll.server.service.dao.Payr0490DAO;
import com.app.exterms.payroll.server.vo.Payr0490SrhVO;
import com.app.exterms.payroll.server.vo.Payr0490VO;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFErrorMessage;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.psl.dataaccess.util.EgovMap;

@Service("PayrP530001Service")
public class PayrP530001ServiceImpl extends AbstractCustomServiceImpl implements
		PayrDaoConstants, PayrP530001Service {
	
	private static final Logger logger = LoggerFactory.getLogger(PayrP530001ServiceImpl.class);
	private static final String calledClass = PayrP530001ServiceImpl.class.getName();
	
	@Autowired
	@Resource(name = "Payr0490DAO")
	private Payr0490DAO payr0490DAO;

	
	/** 사업 이관 **/
	@Override
	public int trnrPayr0490(Payr0490DTO payr0490Dto)throws MSFException {
		
		Payr0490VO      payr0490Vo			= new Payr0490VO();
		Payr0490SrhVO  payr0490SrhVo  	= new Payr0490SrhVO();
		
		String windowNm = "지급(공제)항목단가관리(기간제)";
		String windowId = "PAYRP530001";
		
    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		String method = calledClass + ".trnrPayr0490";

    	int result = 0;
    	
    	
		try{
			
			payr0490SrhVo = new Payr0490SrhVO();
			
			payr0490SrhVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));		/** column 사업장코드 : dpobCd */
			payr0490SrhVo.setPayYr(MSFSharedUtils.allowNulls(payr0490Dto.getPayBfrYr()));    	/** column 급여년도 : payYr */
			payr0490SrhVo.setBusinCd(MSFSharedUtils.allowNulls(payr0490Dto.getBfrBusinCd()));	/** column 사업코드 : businCd */
			payr0490SrhVo.setDeptCd(MSFSharedUtils.allowNulls(payr0490Dto.getBfrDeptCd()));    	/** column 부서코드 : deptCd */
            	
            	int iCnt = payr0490DAO.selectPayr0490ListTotCnt(payr0490SrhVo);
            	
            	// 지급공제항목 데이터가 존재할 경우
            	if(iCnt >= 1) {
            		
            		// 이관하려는 부서에 이미 등록된 지급공제항목이 있을 경우 전부 지워준다.
            		payr0490SrhVo.setPayYr(MSFSharedUtils.allowNulls(payr0490Dto.getPayCreYr()));    	/** column 급여년도 : payYr */
            		payr0490SrhVo.setDeptCd(MSFSharedUtils.allowNulls(payr0490Dto.getCreDeptCd()));    	/** column 부서코드 : deptCd */
            		payr0490SrhVo.setBusinCd(MSFSharedUtils.allowNulls(payr0490Dto.getCreBusinCd()));	/** column 사업코드 : businCd */
            		payr0490DAO.deletePayr0490List(payr0490SrhVo);
            		
            		
         	        //이전 사업을 가져옴
            		payr0490SrhVo.setPayYr(MSFSharedUtils.allowNulls(payr0490Dto.getPayBfrYr()));    	/** column 급여년도 : payYr */
            		payr0490SrhVo.setDeptCd(MSFSharedUtils.allowNulls(payr0490Dto.getBfrDeptCd()));    	/** column 부서코드 : deptCd */
            		payr0490SrhVo.setBusinCd(MSFSharedUtils.allowNulls(payr0490Dto.getBfrBusinCd()));	/** column 사업코드 : businCd */
            		payr0490SrhVo.setCreBusinCd(MSFSharedUtils.allowNulls(payr0490Dto.getCreBusinCd()));/** column 사업코드 : businCd */
            		List payr0490List = payr0490DAO.selectBfrPayr0490List(payr0490SrhVo);
            		
            		
        			for (int i = 0; i < payr0490List.size(); i++) {
            			
	            		EgovMap egovMap = (EgovMap) payr0490List.get(i);
            		
	            		payr0490Vo	= new Payr0490VO();
	            		
	            		payr0490Vo.setDpobCd(MSFSharedUtils.allowNulls(egovMap.get("dpobCd")));    		/** column 사업장코드 : dpobCd */
	            		payr0490Vo.setPayYr(MSFSharedUtils.allowNulls(payr0490Dto.getPayCreYr()));    	/** column 급여년도 : payYr */
	            		payr0490Vo.setBusinCd(MSFSharedUtils.allowNulls(payr0490Dto.getCreBusinCd()));  /** column 사업코드 : businCd */
	            		payr0490Vo.setDeptCd(MSFSharedUtils.allowNulls(payr0490Dto.getCreDeptCd()));    /** column 부서코드 : deptCd */
	            		payr0490Vo.setPayrUcstDgmSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(egovMap.get("payrUcstDgmSeilNum"), "0")));	/** column 급여단가표일련번호 : payrUcstDgmSeilNum */
	            	
	            		payr0490Vo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(egovMap.get("payrMangDeptCd")));   								/** column 급여관리부서코드 : payrMangDeptCd */
	            		payr0490Vo.setPayCd(MSFSharedUtils.allowNulls(egovMap.get("payCd")));   	 											/** column 급여구분코드 : payCd */
	            		payr0490Vo.setPayItemCd(MSFSharedUtils.allowNulls(egovMap.get("payItemCd")));    										/** column 급여항목코드 : payItemCd */
	            		payr0490Vo.setItemNm(MSFSharedUtils.allowNulls(egovMap.get("itemNm")));    												/** column 항목명 : itemNm */
	            		payr0490Vo.setPymtDducDivCd(MSFSharedUtils.allowNulls(egovMap.get("pymtDducDivCd")));    								/** column 지급공제구분코드 : pymtDducDivCd */
	            		payr0490Vo.setPymtDducFrmCd(MSFSharedUtils.allowNulls(egovMap.get("pymtDducFrmCd")));   								/** column 지급공제유형코드 : pymtDducFrmCd */
	            	
	            		payr0490Vo.setPymtDducRate(new BigDecimal(MSFSharedUtils.defaultNulls(egovMap.get("pymtDducRate"), "0")));				/** column 지급공제율 : pymtDducRate */
	            		payr0490Vo.setPymtDducSum(new BigDecimal(MSFSharedUtils.defaultNulls(egovMap.get("pymtDducSum"), "0")));    			/** column 지급공제액 : pymtDducSum */
	            		payr0490Vo.setTxtnDivCd(MSFSharedUtils.allowNulls(egovMap.get("txtnDivCd")));    										/** column 과세구분코드 : txtnDivCd */
	            		payr0490Vo.setFreeDtyRate(new BigDecimal(MSFSharedUtils.defaultNulls(egovMap.get("freeDtyRate"), "0")));    			/** column 비과세율 : freeDtyRate */
	            		payr0490Vo.setFreeDtySum(new BigDecimal(MSFSharedUtils.defaultNulls(egovMap.get("freeDtySum"), "0")));    				/** column 비과세금액 : freeDtySum */
	            		
	            		payr0490Vo.setJan(MSFSharedUtils.allowNulls(egovMap.get("jan")));    	/** column 1월 : jan */
	            		payr0490Vo.setFeb(MSFSharedUtils.allowNulls(egovMap.get("feb")));    	/** column 2월 : feb */
	            		payr0490Vo.setMar(MSFSharedUtils.allowNulls(egovMap.get("mar")));    	/** column 3월 : mar */
	            		payr0490Vo.setApr(MSFSharedUtils.allowNulls(egovMap.get("apr")));    	/** column 4월 : apr */
	            		payr0490Vo.setMay(MSFSharedUtils.allowNulls(egovMap.get("may")));   	/** column 5월 : may */
	            		payr0490Vo.setJun(MSFSharedUtils.allowNulls(egovMap.get("jun")));    	/** column 6월 : jun */
	            		payr0490Vo.setJul(MSFSharedUtils.allowNulls(egovMap.get("jul")));    	/** column 7월 : jul */
	            		payr0490Vo.setAug(MSFSharedUtils.allowNulls(egovMap.get("aug")));    	/** column 8월 : aug */
	            		payr0490Vo.setSep(MSFSharedUtils.allowNulls(egovMap.get("sep")));    	/** column 9월 : sep */
	            		payr0490Vo.setOct(MSFSharedUtils.allowNulls(egovMap.get("oct")));    	/** column 10월 : oct */
	            		payr0490Vo.setNov(MSFSharedUtils.allowNulls(egovMap.get("nov")));    	/** column 11월 : nov */
	            		payr0490Vo.setDec(MSFSharedUtils.allowNulls(egovMap.get("dec")));    	/** column 12월 : dec */
	            		
	            		payr0490Vo.setRngeOrd(new BigDecimal(MSFSharedUtils.defaultNulls(egovMap.get("rngeOrd"), "0")));/** column 정렬순서 : rngeOrd */
	            		payr0490Vo.setPayItemUseYn(MSFSharedUtils.allowNulls(egovMap.get("payItemUseYn")));   			/** column 급여항목사용여부 : payItemUseYn */
	            		payr0490Vo.setItemApptnBgnnDt(MSFSharedUtils.allowNulls(egovMap.get("itemApptnBgnnDt")));   	/** column 항목적용시작일자 : itemApptnBgnnDt */
	            		payr0490Vo.setItemApptnEndDt(MSFSharedUtils.allowNulls(egovMap.get("itemApptnEndDt")));    		/** column 항목적용종료일자 : itemApptnEndDt */
	            		payr0490Vo.setDayMnthAmntDivCd(MSFSharedUtils.allowNulls(egovMap.get("dayMnthAmntDivCd")));   	/** column 일월액구분코드 : dayMnthAmntDivCd */
	            		payr0490Vo.setCalcStdDivCd(MSFSharedUtils.allowNulls(egovMap.get("calcStdDivCd")));    			/** column 계산기준구분코드 : calcStdDivCd */
	            		payr0490Vo.setEmymtDivCd(MSFSharedUtils.allowNulls(egovMap.get("emymtDivCd")));    				/** column 고용구분코드 : emymtDivCd */
	            		payr0490Vo.setUsalyAmntYn(MSFSharedUtils.allowNulls(egovMap.get("usalyAmntYn")));    			/** column 통상임금여부 : usalyAmntYn */
	            		payr0490Vo.setPayItemNoteCtnt(MSFSharedUtils.allowNulls(egovMap.get("payItemNoteCtnt")));    	/** column 급여항목비고내용 : payItemNoteCtnt */
	            		
	            		payr0490Vo.setKybdr(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    										/** column 입력자 : kybdr */
	            		payr0490Vo.setInptAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));  	/** column 입력주소 : inptAddr */
	            		payr0490Vo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    										/** column 수정자 : ismt */
	            		payr0490Vo.setRevnAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));  	/** column 수정주소 : revnAddr */
	            		
	            		payr0490DAO.trurInsertPayr0490(payr0490Vo);
	            		
	            		result = 1;
        			}
        			
            	}else if(iCnt <= 0) {
            		
          			 MSFErrorMessage errMsg = new MSFErrorMessage("", "", 2, "해당 년도에 지급공제항목이 존재하지 않습니다. <br> 이전 사업년도 데이터를 확인해 주세요."); 
                     throw MSFServerUtils.getValidationException("trnrPayr0490.selectPayr0490ListTotCnt(payr0490SrhVo)", errMsg, logger) ;    
                     
            	}
		}catch(Exception e){
			
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S:C",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName() + " " + "지급공제항목 생성 중 오류 발생 <br> 관리자에게 문의해 주세요.", e, logger);
			
		}	
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S:C");
		
		return result;
	}
	
	
	
  
}
