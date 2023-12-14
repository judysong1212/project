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

import org.apache.commons.beanutils.BeanUtils;
import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.payroll.client.dto.InfcPkgPayr0400DTO;
import com.app.exterms.payroll.client.service.InfcPkgPayr0400Service;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.basis.server.service.dao.InfcPkgBass0500DAO;
import com.app.smrmf.infc.payroll.server.service.dao.InfcPkgPayr0400DAO;
import com.app.smrmf.infc.payroll.server.service.dao.InfcPkgPayr0430DAO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0400SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0400VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0430VO;

import egovframework.rte.psl.dataaccess.util.EgovMap;

@Service("InfcPkgPayr0400Service")
public class InfcPkgPayr0400ServiceImpl extends AbstractCustomServiceImpl implements InfcPkgPayr0400Service {
	
	private static final Logger logger = LoggerFactory.getLogger(InfcPkgPayr0400ServiceImpl.class);
	private static final String calledClass = InfcPkgPayr0400ServiceImpl.class.getName();
	
	@Autowired
	@Resource(name = "InfcPkgBass0500DAO")
	private InfcPkgBass0500DAO bass0500DAO;
	
	@Autowired
	@Resource(name = "InfcPkgPayr0400DAO")
	private InfcPkgPayr0400DAO payr0400DAO;
	
	@Autowired
	@Resource(name = "InfcPkgPayr0430DAO")
	private InfcPkgPayr0430DAO payr0430DAO;
 
    @Override
    public InfcPkgPayr0400DTO createPyspLogSvcYrNumCd(InfcPkgPayr0400DTO infcPayr0400Dto) {
        // TODO Auto-generated method stub
        Long result = new Long(1);
        
    	String method = calledClass + ".createPyspLogSvcYrNumCd";
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
		String windowNm = "인터페이스";
		String windowId = "INFC_PAYR0400";
        
        try { 
          
            InfcPkgPayr0400VO payr0400Vo = new InfcPkgPayr0400VO();
            InfcPkgPayr0430VO payr0430Vo = new InfcPkgPayr0430VO();
            
            InfcPkgPayr0400SrhVO infcPayr0400SrhVo = new InfcPkgPayr0400SrhVO();
            
            infcPayr0400SrhVo.setDpobCd(MSFSharedUtils.allowNulls(infcPayr0400Dto.getDpobCd()));
            infcPayr0400SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(infcPayr0400Dto.getDtilOccuInttnCd()));
            
            int iResult = payr0400DAO.selectPayr0400MappingListTotCnt(infcPayr0400SrhVo);
            
            //직종, 직종세 맵핑 내역이 없을 경우
            if(iResult <= 0) {
            	
            	payr0400Vo.setDpobCd(MSFSharedUtils.allowNulls(infcPayr0400Dto.getDpobCd()));
            	payr0400Vo.setTypOccuCd(MSFSharedUtils.allowNulls(infcPayr0400Dto.getTypOccuCd()));
            	payr0400Vo.setPyspGrdeCd(MSFSharedUtils.allowNulls(infcPayr0400Dto.getPyspGrdeCd()));
            	payr0400Vo.setTypOccuGrdeMppgSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(infcPayr0400Dto.getTypOccuGrdeMppgSeilNum(), "0")));
            	payr0400Vo.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(infcPayr0400Dto.getDtilOccuClsDivCd()));
            	payr0400Vo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(infcPayr0400Dto.getDtilOccuInttnCd()));
            	payr0400Vo.setTypOccuGrdeMppgDelYn("N");
            	payr0400Vo.setKybdr(sessionUser.getUsrId());
            	payr0400Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
            	payr0400Vo.setIsmt(sessionUser.getUsrId());
            	payr0400Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */     
            	
            	// 직종, 직종세 insert
            	payr0400DAO.insertInfcPayr0400(payr0400Vo);
            	
            	
            	/********************** 데이터 insert 후 일련번호를 가져오기 위한 **********************/
            	infcPayr0400SrhVo = new InfcPkgPayr0400SrhVO();
                
                infcPayr0400SrhVo.setDpobCd(infcPayr0400Dto.getDpobCd());
                infcPayr0400SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(infcPayr0400Dto.getTypOccuCd()));
                infcPayr0400SrhVo.setDtilOccuInttnCd(infcPayr0400Dto.getDtilOccuInttnCd());
                infcPayr0400SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(infcPayr0400Dto.getPyspGrdeCd()));
                
				List payr0400List = payr0400DAO.getTypOccuGrdeMppgSeilNum(infcPayr0400SrhVo);
//				infcBass0360Vo = infcBass0360DAO.getPayrMangDeptCd(infcBass0360SrhVo);
				
				for (int i = 0; i < payr0400List.size(); i++) {
					EgovMap egovMap = (EgovMap) payr0400List.get(i);
					infcPayr0400Dto.setTypOccuGrdeMppgSeilNum(Long.parseLong(MSFSharedUtils.defaultNulls(String.valueOf(egovMap.get("typOccuGrdeMppgSeilNum")), "1")));
					payr0400Vo.setTypOccuGrdeMppgSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(String.valueOf(egovMap.get("typOccuGrdeMppgSeilNum")), "1")));
				}
				/********************** 데이터 insert 후 일련번호를 가져오기 위한 **********************/
            	
                BeanUtils.copyProperties(payr0430Vo, infcPayr0400Dto); 
                BeanUtils.copyProperties(payr0400Vo, infcPayr0400Dto); 
                //근속년수 맵핑 처리를 하는 메서드 호출 
                result = deleteOnPayr0430(payr0430Vo,ActionDatabase.DELETE);
                
                infcPayr0400Dto.setiPayrAdapter(0);
                
                if (result > 0) {
                	infcPayr0400Dto.setiPayrAdapter(1);
                 //   PayrListnerAdapter payrAdapter = new PayrListnerAdapter(); 
                 //   result = (long) payrAdapter.createPyspLogSvcYrNumCd(RemoteServiceUtil.getThreadLocalRequest(),payr0400Vo);
                } 
                
                
                
                //리턴하기 위해
                infcPayr0400Dto = new InfcPkgPayr0400DTO();
                infcPayr0400Dto.setiPayrAdapter(1);
                
                infcPayr0400Dto.setDpobCd(MSFSharedUtils.allowNulls(payr0400Vo.getDpobCd()));
                infcPayr0400Dto.setTypOccuCd(MSFSharedUtils.allowNulls(payr0400Vo.getTypOccuCd()));
                infcPayr0400Dto.setPyspGrdeCd(MSFSharedUtils.allowNulls(payr0400Vo.getPyspGrdeCd()));
                infcPayr0400Dto.setTypOccuGrdeMppgSeilNum(Long.parseLong(MSFSharedUtils.defaultNulls(payr0400Vo.getTypOccuGrdeMppgSeilNum(), "1")));
                infcPayr0400Dto.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(payr0400Vo.getDtilOccuClsDivCd()));
                infcPayr0400Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(payr0400Vo.getDtilOccuInttnCd()));
                infcPayr0400Dto.setTypOccuGrdeMppgDelYn("N");
                infcPayr0400Dto.setKybdr(sessionUser.getUsrId());
            	infcPayr0400Dto.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
            	infcPayr0400Dto.setIsmt(sessionUser.getUsrId());
            	infcPayr0400Dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */     
            }
            
        } catch (Exception ex) {
            logger.error("EXCEPTION calling createPyspLogSvcYrMumCd(): "+ex); 
            infcPayr0400Dto.setStrResult("fail");
            
            /** 에러 로그 **/			
            MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S:C:D",ex, windowNm , windowId);
            
            throw MSFServerUtils.getOperationException("createPyspLogSvcYrNumCd()", ex, logger);
        }
        finally {
          
        }
        
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S:C:D");    
		
        return infcPayr0400Dto;
    }
    
    
    private Long deleteOnPayr0430(InfcPkgPayr0430VO payr0430Vo, ActionDatabase actionDatabase) throws MSFException  {
        // TODO Auto-generated method stub
        Long result = new Long(1);
        try { 
           
            switch (actionDatabase) {
            case INSERT:
               break;
            case UPDATE: 
                break;
            case DELETE: 
                payr0430DAO.deletePayr0430(payr0430Vo);
                break;
            }
            
        }
        catch (Exception ex) {
            logger.error("EXCEPTION calling activityOnPayr0400Save(): "+ex); 
            result = new Long(0);
            throw MSFServerUtils.getOperationException("deleteOnPayr0430()", ex, logger);
        }
        finally {
          
        }
        return result;
    }
	

	 
  
}
