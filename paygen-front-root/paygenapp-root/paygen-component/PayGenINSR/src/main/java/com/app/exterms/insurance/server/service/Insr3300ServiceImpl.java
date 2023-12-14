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
package com.app.exterms.insurance.server.service;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.exterms.insurance.client.dto.Insr4300DTO;
import com.app.exterms.insurance.client.service.Insr3300Service;
import com.app.exterms.insurance.server.service.dao.Insr4300DAO;
import com.app.exterms.insurance.server.vo.Insr4300VO;
import com.app.exterms.insurance.shared.InsrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.payroll.server.service.dao.InfcPkgPayr0500DAO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0500VO;
import com.app.smrmf.infc.personal.server.service.dao.InfcPkgPsnl0127DAO;
import com.app.smrmf.infc.personal.server.vo.InfcPkgPsnl0127VO;


 
@Service("Insr3300Service")
public class Insr3300ServiceImpl extends AbstractCustomServiceImpl implements Insr3300Service ,InsrDaoConstants{	
	
		private static final Logger logger = LoggerFactory.getLogger(Insr3300ServiceImpl.class);
		private static final String calledClass = Insr3300ServiceImpl.class.getName();
		
		@Autowired
	    @Resource(name="Insr4300DAO")
	    private Insr4300DAO insr4300DAO;
		
		 @Autowired 
		    @Resource(name="InfcPkgPsnl0127DAO")
		    private InfcPkgPsnl0127DAO infcPsnl0127DAO;
		    
		    @Autowired 
		    @Resource(name="InfcPkgPayr0500DAO")
		    private InfcPkgPayr0500DAO infcPayr0500DAO;
		
		 
		@Override
		public Long insr3300MnthUpdate(List<Insr4300DTO> listInsr4300dto,
				ActionDatabase actionDatabase) throws MSFException {			
			
			    Long result = new Long(0);
		        Long iCnt = new Long(0);
		        
		        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		        
		        try {  
		            
		        	   if  (MSFSharedUtils.paramNull(insr4300DAO)) {
		       	        
		   	        	WebApplicationContext wac = WebApplicationContextUtils.
		   	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

		   	        	insr4300DAO = (Insr4300DAO) wac.getBean("Insr4300DAO" ); 
		   	        }
		            
		        	   if  (MSFSharedUtils.paramNull(infcPsnl0127DAO)) {
			       	        
			   	        	WebApplicationContext wac = WebApplicationContextUtils.
			   	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

			   	        	infcPsnl0127DAO = (InfcPkgPsnl0127DAO) wac.getBean("InfcPkgPsnl0127DAO" ); 
			   	        }
			            
		        	   if  (MSFSharedUtils.paramNull(infcPayr0500DAO)) {
			       	        
			   	        	WebApplicationContext wac = WebApplicationContextUtils.
			   	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

			   	        	infcPayr0500DAO = (InfcPkgPayr0500DAO) wac.getBean("InfcPkgPayr0500DAO" ); 
			   	        }
			            
		            for(int iPayrCnt=0;iPayrCnt < listInsr4300dto.size();iPayrCnt++) {
		                
		            	  Insr4300DTO insr4300Dto = new Insr4300DTO();  
		            	  InfcPkgPsnl0127VO psnl0127Vo = new InfcPkgPsnl0127VO();  
		                  InfcPkgPayr0500VO payr0500Vo = new InfcPkgPayr0500VO();
		                  
		                  
		            	  insr4300Dto = listInsr4300dto.get(iPayrCnt);
		                 
		            	  Insr4300VO insr4300Vo = new Insr4300VO();  

		            	  insr4300Vo.setDpobCd(insr4300Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
		            	  insr4300Vo.setSystemkey(insr4300Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
		            	  insr4300Vo.setEmymtSeilNum(insr4300Dto.getEmymtSeilNum());    /** column 고용일련번호 : emymtSeilNum */
		            	  insr4300Vo.setAntyDeinYr(insr4300Dto.getAntyDeinYr());    /** column 연금결정년도 : antyDeinYr */
		            	     
		            	 // insr4300Vo.setAntyStdIncmMnthAmnt(new BigDecimal(insr4300Dto.getAntyStdIncmMnthAmnt()));    /** column 연금기준소득월액 : antyStdIncmMnthAmnt */
		            	   
		            	  insr4300Vo.setAntyPayRflctnYn("Y");    /** column 연금급여반영여부 : antyPayRflctnYn */
		            	 
		            	 // insr4300Vo.setNatApptnYrMnth(infcYeta2000VO.getNatApptnYrMnth());    /** column 국민연금급여적용년월 : natApptnYrMnth */
		            	 // insr4300Vo.setNatPrcsDt(infcYeta2000VO.getNatPrcsDt());    /** column 국민연금급여적용일자 : natPrcsDt */ 
		            	  
		            	  //국민연금급여적용년월, 국민연금급여처리여부 처리 
		            	  Calendar  intiCal =  Calendar.getInstance();
		            	  int year = intiCal.get(Calendar.YEAR);
		            	  int month = intiCal.get(Calendar.MONTH) + 1;
		            	  
		            	  insr4300Vo.setNatApptnYrMnth(year+"07"); //국민연금급여적용년월

		            	  //7월 이전
		            	  insr4300Vo.setNatPrcsYn("N"); //국민연금급여처리여부
		            	  //7월 이후
		            	  if ( month - 7 > 0 ) {
		            		  insr4300Vo.setNatPrcsYn("Y"); //국민연금급여처리여부 
		            		   
		            		  //TODO 변경 
		            		  //7월인경우 업데이트 123번에 적용 한다. 
//		            			psnl0127Vo.setDpobCd(insr4300Dto.getDpobCd());
//		            			psnl0127Vo.setSystemkey(insr4300Dto.getSystemkey());
//		                        psnl0127Vo.setNatPennApptnYn("Y");
//		                      //  psnl0127Vo.setResnRegnNum(MSFSharedUtils.allowNulls(insr4300Vo.getResnRegnNum()));
//		                        psnl0127Vo.setNatPennStdIncmMnthAmnt(new BigDecimal(insr4300Dto.getAntyStdIncmMnthAmnt()));
//		                        psnl0127Vo.setIsmt(sessionUser.getUsrId());                                                              
//		                        psnl0127Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());                                                  
//		                                        
//		                        payr0500Vo.setDpobCd(insr4300Dto.getDpobCd());
//		                    	payr0500Vo.setSystemkey(insr4300Dto.getSystemkey());
//		                        payr0500Vo.setNatPennApptnYn("Y");
//		                      //  payr0500Vo.setResnRegnNum(MSFSharedUtils.allowNulls(insr4300Vo.getResnRegnNum()));
//		                        payr0500Vo.setIsmt(sessionUser.getUsrId());
//		                        payr0500Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//		            		  
//		                        infcPsnl0127DAO.updateXlsInsr3100ToPsnl0127(psnl0127Vo); 
//		    	                infcPayr0500DAO.updateXlsInsr3100ToPayr0500(payr0500Vo);
		            		  
		            	  }
		            	  
		            	  insr4300Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
		            	  insr4300Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
							
		                  insr4300DAO.insr3300MnthUpdate(insr4300Vo); 
		                  iCnt = iCnt + 1; 
		                    
		               } 
		                result = iCnt;
		          
		        }
		        catch (Exception ex) {
		            logger.error("EXCEPTION calling insr3300MnthUpdate(): "+ex); 
		            
		            result = new Long(0);
		            throw MSFServerUtils.getOperationException("insr3300MnthUpdate", ex, logger);
		        }
		        finally {
		          
		        }
		        
		        return result;
		}
}
