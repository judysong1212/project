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
package com.app.smrmf.sysauth.systemmtr.server.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.management.Query;

import org.apache.commons.beanutils.BeanUtils;
import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.smrmf.core.msfmainapp.client.admin.dto.ProfileUser;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfSysm0100BM;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfSysm0300DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfSysm0500DTO;
import com.app.smrmf.sysauth.systemmtr.client.service.SysmMtr0600Service;
import com.app.smrmf.sysauth.systemmtr.shared.SysmMtrDaoConstants;
import com.app.smrmf.sysm.server.service.dao.Sysm0300DAO;
import com.app.smrmf.sysm.server.service.dao.Sysm0500DAO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0100VO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0300SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0300VO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0500SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0500VO;
@Service("SysmMtr0600Service")
public class SysmMtr0600ServiceImpl extends AbstractCustomServiceImpl implements SysmMtrDaoConstants, SysmMtr0600Service {  
	
	private static final Logger logger = LoggerFactory.getLogger(SysmMtr0600ServiceImpl.class);
	private static final String calledClass = SysmMtr0600ServiceImpl.class.getName();

	@Autowired 
    @Resource(name="Sysm0500DAO")
    private Sysm0500DAO sysm0500DAO;
	
	@Autowired 
    @Resource(name="Sysm0300DAO")
    private Sysm0300DAO sysm0300DAO;
    
    /** ID Generation */
    //@Resource(name="{egovSysm0500IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;
 
    public Long activitySysm0300User(SysIfSysm0300DTO sysm0300Dto, ActionDatabase actionDatabase)   throws MSFException {
        
        Long result = new Long(1);
        try { 
          
            SysIfSysm0300VO sysm0300Vo = new SysIfSysm0300VO(); 
            SysIfSysm0500VO sysm0500Vo = new SysIfSysm0500VO(); 
            
            sysm0300Vo.setAuthGrpUseYn("true".equals(sysm0300Vo.getAuthGrpUseYn()) ? "Y" : "N");
            
            BeanUtils.copyProperties(sysm0300Vo, sysm0300Dto); 
            BeanUtils.copyProperties(sysm0500Vo, sysm0300Vo); 
            
            sysm0500Vo.setUsrAuthUseYn("Y");
            sysm0500Vo.setUsrId(sysm0300Dto.getUsrId());
            // sysm0300Vo.setUsrAuthUseYn("true".equals(sysm0300Vo.getUsrAuthUseYn()) ? "Y" : "N");
            //prf300.setAuthGrpSeilNum(new BigDecimal(sysm0300Dto.getAuthGrpSeilNum()));
          
            SysIfSysm0100VO usr100 = new SysIfSysm0100VO();
            
            usr100.setUsrId(sysm0300Dto.getUsrId());

            SysIfSysm0500VO sysm0500Input = new SysIfSysm0500VO(
            		usr100,
            		sysm0300Vo
            );

            switch (actionDatabase) {
            case INSERT:
            	sysm0500DAO.insertSysm0500(sysm0500Vo);
            	 
            	break;
          //  case UPDATE: 
          //  	sysm0500DAO.updateSysm0500(sysm0500Vo); 
            	 
          //      break;
          //  case DELETE: 
           //     sysm0500DAO.deleteSysm0500(sysm0500Vo);
               
           //     break;
            }
            
        }
        catch (Exception ex) {
            logger.error("EXCEPTION calling activitySysm0300User(): "+ex); 
            result = new Long(0);
        }
        finally {
          
        }
        return result;
    }
    
 public Long activityOnSysmMtr0600User(SysIfSysm0500DTO sysm0500Dto, ActionDatabase actionDatabase)   throws MSFException {
        
        Long result = new Long(1);
        try { 
          
            SysIfSysm0500VO sys0500Vo = new SysIfSysm0500VO(); 
            BeanUtils.copyProperties(sys0500Vo, sysm0500Dto);
            
            sys0500Vo.setUsrAuthUseYn("true".equals(sys0500Vo.getUsrAuthUseYn()) ? "Y" : "N");
            
            SysIfSysm0300VO sysm0300Vo = new SysIfSysm0300VO(); 
            sysm0300Vo.setAuthGrpSeilNum(sysm0500Dto.getAuthGrpSeilNum());
          
            SysIfSysm0100VO usr100 = new SysIfSysm0100VO();
            usr100.setUsrId(sysm0500Dto.getUsrId());

            SysIfSysm0500VO prfUsr = new SysIfSysm0500VO(
            		usr100,
            		sysm0300Vo
            );

            switch (actionDatabase) {
            //case INSERT:
            //	sysm0500DAO.insertSysm0500(sys0500Vo);
            	 
            //	break;
            //case UPDATE: 
            //	sysm0500DAO.updateSysm0500(sys0500Vo); 
            	 
             //   break;
            case DELETE: 
                sysm0500DAO.deleteSysm0500(sys0500Vo);
               
                break;
            }
            
        }
        catch (Exception ex) {
            logger.error("EXCEPTION calling activityOnProfilesUser(): "+ex); 
            result = new Long(0);
        }
        finally {
          
        }
        return result;
    }

	public List<SysIfSysm0500DTO> getListaSysmMtr0600User(MSFSysm0100BM utente) {
		// TODO Auto-generated method stub
		  //  Session session = null;
	        List<SysIfSysm0500DTO> retval = new ArrayList<SysIfSysm0500DTO>();
	        SysIfSysm0500SrhVO  sysm0500SrhVo = new SysIfSysm0500SrhVO();
	        MSFSysm0100BM user = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	     
	       
	        if (user!=null) {
	            try {
	           
	            	sysm0500SrhVo.setUsrId(utente.getUsrId()) ;
	            	sysm0500SrhVo.setDpobCd(user.getDpobCd());
	                sysm0500SrhVo.setLastIndex(-1);

	                List list = sysm0500DAO.selectSysm0500List(sysm0500SrhVo);
	                
	                Iterator iter = list.iterator();
	                while ( iter.hasNext() ) {
	                    Map<String, Object> map = (Map<String, Object>) iter.next();
	                    //Object[] prf = (Object[]) iter.next();
	                    if ( map!=null ) {
	                        Long yesNo = Long.parseLong(MSFSharedUtils.defaultNulls(map.get("usrAuthUseCnt"),"0"));
	                        Boolean yesNoBoolean = false;
	                        if (yesNo != null) {
	                            if (yesNo.compareTo(Long.valueOf(1)) == 0) {
	                                yesNoBoolean = true;
	                            }
	                        } 
	                       //yesNoBoolean
	                        SysIfSysm0500DTO profileUsr = new SysIfSysm0500DTO(
	                        		 MSFSharedUtils.allowNulls(map.get("sysDivCd")), 
	                                 Long.parseLong(MSFSharedUtils.defaultNulls(map.get("authGrpSeilNum"),"0")),
	                                 MSFSharedUtils.allowNulls(map.get("authGrpNm")), 
	                                 MSFSharedUtils.defaultNulls(map.get("usrId"),""), 
	                                 MSFSharedUtils.defaultNulls(map.get("usrNm"),""), 
	                                  false
	                        );
	                        retval.add(profileUsr);
	                    }
	                }
	            }
	            catch (Exception ex) {
	                logger.error("EXCEPTION calling getListaSysmMtr0600User(): "+ex);
	              //  throw MSFServerUtils.getOperationException("getListaProfilesUser", ex, logger);
	            }
	           finally { 
	           }
	        }
	        return retval;	
	}
	

	public List<SysIfSysm0300DTO> getListaSysm0300User(MSFSysm0100BM utente) {
		// TODO Auto-generated method stub
		  //  Session session = null;
	        List<SysIfSysm0300DTO> retval = new ArrayList<SysIfSysm0300DTO>();
	        SysIfSysm0300SrhVO  sysm0300SrhVo = new SysIfSysm0300SrhVO();
	        MSFSysm0100BM user = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	     
	       
	        if (user!=null) {
	            try {
	            	sysm0300SrhVo.setDpobCd(user.getDpobCd());
	            	sysm0300SrhVo.setUsrId(utente.getUsrId()) ;
	                sysm0300SrhVo.setLastIndex(-1);

	                List list = sysm0300DAO.selectSysm0500ToSysm0300List(sysm0300SrhVo);
	                
	                Iterator iter = list.iterator();
	                while ( iter.hasNext() ) {
	                    Map<String, Object> map = (Map<String, Object>) iter.next();
	                    //Object[] prf = (Object[]) iter.next();
	                    if ( map!=null ) {
//	                        Long yesNo = Long.parseLong(MSFSharedUtils.defaultNulls(map.get("usrAuthUseCnt"),"0"));
//	                        Boolean yesNoBoolean = false;
//	                        if (yesNo != null) {
//	                            if (yesNo.compareTo(Long.valueOf(1)) == 0) {
//	                                yesNoBoolean = true;
//	                            }
//	                        } 
	                       //MSFSharedUtils.defaultNulls(map.get("usrAuthUseYn"),"N").equals("Y")?true:
	                        SysIfSysm0300DTO sysm0300Dto = new SysIfSysm0300DTO( 
	                        		MSFSharedUtils.allowNulls(map.get("sysDivCd")),
	                		        Long.parseLong(MSFSharedUtils.defaultNulls(map.get("authGrpSeilNum"),"0")), 
	                		        MSFSharedUtils.allowNulls(map.get("businDivCd")), 
	                		        		MSFSharedUtils.allowNulls(map.get("authGrpNm")),
	                		        				MSFSharedUtils.allowNulls(map.get("grde")), 
	                		        						false,
	                		        								MSFSharedUtils.allowNulls(map.get("grpEpln")), 		
	                		        		"");
	                         
	                        retval.add(sysm0300Dto);
	                    }
	                }
	            }
	            catch (Exception ex) {
	                logger.error("EXCEPTION calling getListaSysm0300User(): "+ex);
	              //  throw MSFServerUtils.getOperationException("getListaProfilesUser", ex, logger);
	            }
	           finally { 
	           }
	        }
	        return retval;	
	}
 
    public List<ProfileUser> getListaProfilesUser(SysIfSysm0100BM sysm0100)  throws MSFException{
      //  Session session = null;
        List<ProfileUser> retval = new ArrayList<ProfileUser>();
        MSFSysm0100BM user = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        if (user!=null) {
            try {
             //   session = SessionManager.currentSession();
                Query query = null;
//                query = session.createQuery(
//                        " SELECT "
//                        +   " (SELECT put.id FROM " + SysIfSysm0500VO.class.getName() +" as put "
//                        +   "   WHERE prf.id = put.admProfiles.id "
//                        +   "     AND put.admUser.identnr = :usr) as ID, " 
//                        +   " prf.id as ID_PROFILO," 
//                        +   " prf.description as DESCRIPTION," 
//                        +   " (SELECT count(*) FROM " + MSFSysIfSysm0500VO.class.getName() +" as put "
//                        +   "   WHERE prf.id = put.admProfiles.id "
//                        +   "     AND put.admUser.identnr = :usr) as SINO" 
//                        +   " FROM " + SysIfSysm0300VO.class.getName() + " as prf"
//                );
//                query.setString("usr", sysm0100.getUsrId());
//
//                List list = (List)query.list();
//                Iterator iter = list.iterator();
//                while ( iter.hasNext() ) {
//                    Object[] prf = (Object[]) iter.next();
//                    if ( prf!=null ) {
//                        Long yesNo = (Long)prf[3];
//                        Boolean yesNoBoolean = false;
//                        if (yesNo != null) {
//                            if (yesNo.compareTo(Long.valueOf(1)) == 0) {
//                                yesNoBoolean = true;
//                            }
//                        }
//                        ProfileUser profileUsr = new ProfileUser(
//                                (BigDecimal)prf[0], 
//                                sysm0100.getUsrId(),
//                                (BigDecimal)prf[1], 
//                                (String)prf[2],
//                                yesNoBoolean
//                        );
//                        retval.add(profileUsr);
//                    }
//                }
            }
            catch (Exception ex) {
                logger.error("EXCEPTION calling getListaProfilesUser(): "+ex);
            }
            finally {
              //  SessionManager.closeSession();
            }
        }
        return retval;		
    }
 
	
}
