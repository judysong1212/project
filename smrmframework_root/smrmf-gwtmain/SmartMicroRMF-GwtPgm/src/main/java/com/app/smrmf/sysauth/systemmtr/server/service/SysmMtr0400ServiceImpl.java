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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfSysm0300DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfSysm0400BM;
import com.app.smrmf.sysauth.systemmtr.client.service.SysmMtr0400Service;
import com.app.smrmf.sysauth.systemmtr.shared.SysmMtrDaoConstants;
import com.app.smrmf.sysm.server.service.dao.Sysm0400DAO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0400SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0400VO;

@Service("SysmMtr0400Service")
public class SysmMtr0400ServiceImpl extends AbstractCustomServiceImpl implements  SysmMtrDaoConstants ,SysmMtr0400Service {
	
	private static final Logger logger = LoggerFactory.getLogger(SysmMtr0400ServiceImpl.class);
	private static final String calledClass = SysmMtr0400ServiceImpl.class.getName();
	
	@Autowired 
	@Resource(name="Sysm0400DAO")
    private Sysm0400DAO sysm0400DAO;
    
    /** ID Generation */
    //@Resource(name="{egovSysm0400IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	
	   public List<SysIfSysm0400BM> getListaVociMenuProfile(SysIfSysm0300DTO profile){
	       
	        List<SysIfSysm0400BM> retval = new ArrayList<SysIfSysm0400BM>();
	        MSFSysm0100BM user = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        if (user!=null) {
	            try {
	               // session = SessionManager.currentSession();
	                retval = getVoceMenuProfiles ("", null, profile);
	            }
	            catch (Exception ex) {
	                logger.error("EXCEPTION calling getListaVociMenuProfile(): "+ex);
	            }
	            finally {
	              //  SessionManager.closeSession();
	            }
	        }
	        return retval;		
	    }	
	   
	   public String activityOnVoceMenuProfile(SysIfSysm0400BM voceMenuProfile, ActionDatabase actionDatabase) {
	       
	        String result = "1";  
	        try {
	             
	        	SysIfSysm0400VO prf = new SysIfSysm0400VO();
	        	
	        	prf.setSysDivCd(voceMenuProfile.getSysDivCd());
	        	prf.setAuthGrpSeilNum(voceMenuProfile.getAuthGrpSeilNum());
	        	prf.setMnuCd(voceMenuProfile.getMnuCd());
	        	 
//	            Sysm0200VO instMenu = new Sysm0200VO();
//	            instMenu.setMnuCd(voceMenuProfile.getIdMnu());
//
//	            Sysm0300VO instProfiles = new Sysm0300VO();
//	            instProfiles.setAuthGrpSeilNum(voceMenuProfile.getIdPrf());

	            String sePScnInqy = "0";  
	            if (voceMenuProfile.getMnuAuthGrPScnInqyYn()) sePScnInqy = "1";
	            String sePScnInpt = "0";
	            if (voceMenuProfile.getMnuAuthGrPScnInptYn()) sePScnInpt = "1";
	            String sePScnRevn = "0";
	            if (voceMenuProfile.getMnuAuthGrPScnRevnYn()) sePScnRevn = "1";
	            String sePScnDel = "0";
	            if (voceMenuProfile.getMnuAuthGrPScnDelYn())  sePScnDel = "1";
	            String sePScnPrt = "0";
	            if (voceMenuProfile.getMnuAuthGrPScnPrtYn())  sePScnPrt = "1";
	         
	            prf.setMnuAuthGrPScnInqyYn(sePScnInqy);
	            prf.setMnuAuthGrPScnInptYn(sePScnInpt);
	            prf.setMnuAuthGrPScnRevnYn(sePScnRevn);
	            prf.setMnuAuthGrPScnDelYn(sePScnDel);
	            prf.setMnuAuthGrPScnPrtYn(sePScnPrt);

//	            SysIfSysm0400VO prf = new SysIfSysm0400VO(
//	                    instMenu, 
//	                    instProfiles,
//	                    seIns, 
//	                    seUpd, 
//	                    seDel,
//	                    seSch,
//	                    seprt
//	            );
	           
	            switch (actionDatabase) {
	            case INSERT: 
	            	sysm0400DAO.insertSysm0400(prf); 
	            	break;
	            case UPDATE:  
	                sysm0400DAO.updateSysm0400(prf); 
	                break;
	            case DELETE: 
	                sysm0400DAO.deleteSysm0400(prf);
	                break;
	            } 
	            result = prf.getMnuCd();
	        }
	        catch (Exception ex) {
	            logger.error("EXCEPTION calling activityOnVoceMenuUser(): "+ex); 
	            result = "0";
	        }
	        finally {
	          
	        }
	        return result;
	    }
	   
	    private List<SysIfSysm0400BM> getVoceMenuProfiles (String session, Long idCategory, SysIfSysm0300DTO profile){
	    	
	    	String method = calledClass + ".getVoceMenuProfiles";
	    	
	        List<SysIfSysm0400BM> retval = new ArrayList<SysIfSysm0400BM>();
	        SysIfSysm0400SrhVO sysm0400SrhVo = new SysIfSysm0400SrhVO();
	        
			MSFSysm0100BM sessionUser;
			
			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}
			
	        try {
	            
	        	
	            sysm0400SrhVo.setSysDivCd(MSFSharedUtils.defaultNulls(profile.getSysDivCd(),"EXTERM00"));
	            sysm0400SrhVo.setAuthGrpSeilNum(new BigDecimal(profile.getAuthGrpSeilNum()));
	            
	            List list = sysm0400DAO.selectSysm0400List(sysm0400SrhVo); 
	            
				/** 로그반영
				 * CRUDSBLO
				 * C   //create  
		    	 * R   //read
		    	 * U   //update
		    	 * D   //delete
		    	 * S   //select
		    	 * B   //배치 
		    	 * L   //로그인 
		    	 * O   //로그아웃
		    	 */
				MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
				
	            Iterator iter = list.iterator();
	            while ( iter.hasNext() ) {
	                Map<String, Object> map = (Map<String, Object>) iter.next();
	               
	                if ( map!=null ) {
	                    Long yesNo = MSFSharedUtils.convertStringToLong(map.get("mnuCnt").toString());
	                    Boolean yesNoBoolean = false;
	                    if (yesNo != null) {
	                        if (yesNo.compareTo(Long.valueOf(1)) == 0) {
	                            yesNoBoolean = true;
	                        }
	                    } 
	                   
	                    SysIfSysm0400BM vmu = new SysIfSysm0400BM(
	                    		MSFSharedUtils.allowNulls(map.get("sysDivCd")), 
	                    		Long.valueOf(MSFSharedUtils.defaultNulls(map.get("authGrpSeilNum"),"0")), 
	                    		MSFSharedUtils.allowNulls(map.get("mnuCd")),
	                    	    MSFSharedUtils.allowNulls(map.get("mnuNm")),
	                    		MSFSharedUtils.allowNulls(map.get("hhrkMnuCd")),
	                            yesNoBoolean,
	                            MSFSharedUtils.convertLongToBoolean(MSFSharedUtils.paramNull(map.get("mnuAuthGrPScnInqyYn"))?Long.valueOf(0):Long.valueOf(map.get("mnuAuthGrPScnInqyYn").toString())) ,
	                            MSFSharedUtils.convertLongToBoolean(MSFSharedUtils.paramNull(map.get("mnuAuthGrPScnInptYn"))?Long.valueOf(0):Long.valueOf(map.get("mnuAuthGrPScnInptYn").toString())),
	                            MSFSharedUtils.convertLongToBoolean(MSFSharedUtils.paramNull(map.get("mnuAuthGrPScnRevnYn"))?Long.valueOf(0):Long.valueOf(map.get("mnuAuthGrPScnRevnYn").toString())),
	                            MSFSharedUtils.convertLongToBoolean(MSFSharedUtils.paramNull(map.get("mnuAuthGrPScnDelYn"))?Long.valueOf(0):Long.valueOf(map.get("mnuAuthGrPScnDelYn").toString())),
	                            MSFSharedUtils.convertLongToBoolean(MSFSharedUtils.paramNull(map.get("mnuAuthGrPScnPrtYn"))?Long.valueOf(0):Long.valueOf(map.get("mnuAuthGrPScnPrtYn").toString()))
	                    );
	                    retval.add(vmu);
	                   //retval.addAll(getVoceMenuProfiles(session, MSFSharedUtils.allowNulls(map.get("mnuCd")), profile));
	                }  
	            }
	            
	            
	        } catch (Exception e) {
	            // TODO: handle exception
	        	e.printStackTrace();
	        }
	        return retval;
	    }
 
  
	 
}
