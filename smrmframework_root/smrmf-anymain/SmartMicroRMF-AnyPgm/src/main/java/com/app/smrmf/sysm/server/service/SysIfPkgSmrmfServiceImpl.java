package com.app.smrmf.sysm.server.service;
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


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.smrmf.core.msfmainapp.server.utils.AnyWebServerUtils;
import com.app.smrmf.infc.sysif.msfpackage.server.service.dao.SysIfSsoSmrmfDAO;
import com.app.smrmf.sysm.server.service.dao.SysIfPkgSmrmfDAO;
import com.app.smrmf.sysm.server.service.vo.SysComSearchVO;
import com.app.smrmf.sysm.server.service.vo.SysIfBass0320VO;
import com.app.smrmf.sysm.server.service.vo.SysIfBass0350VO;
import com.app.smrmf.sysm.server.service.vo.SysIfBass0400VO;
import com.app.smrmf.sysm.server.vo.system.MSFUserInfoVO;


/**
 * <pre>
 * com.app.smrmf.sysauth.system.server.service 
 *    |_ MSFPkgSmrmfServiceImpl.java
 * 
 * </pre>
 * @date : Nov 11, 2015 1:22:12 PM
 * @version : 
 * @author : leeheuisung
 */
@Service("SysIfPkgSmrmfService") 
public   class SysIfPkgSmrmfServiceImpl  extends AbstractAnyServiceImpl implements   SysIfPkgSmrmfService  {

	private static final Logger logger = LoggerFactory.getLogger(SysIfPkgSmrmfServiceImpl.class);
	private static final String calledClass = SysIfPkgSmrmfServiceImpl.class.getName();
	
	@Autowired 
	@Resource(name="SysIfPkgSmrmfDAO")
	private SysIfPkgSmrmfDAO msfPkgSmrmfDAO;
	
	
	@Autowired 
	@Resource(name="SysIfSsoSmrmfDAO")
	private SysIfSsoSmrmfDAO msfPkgSsoSmrmfDAO;
	 
  
    /**
     * 
     * <pre>
     * 1. 개요 : 
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : getFuncBeforComboBass0400List
     * @date : 2017. 1. 25.
     * @author : atres-pc
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2017. 1. 25.		atres-pc				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @see com.app.smrmf.infc.sysif.msfpackage.server.service.SysIfPkgSmrmfService#getFuncBeforComboBass0400List(com.app.smrmf.infc.sysif.msfpackage.server.vo.SysIfBass0400VO)
     * @param sysIfBass0400Vo
     * @return
     * @throws MSFException
     */
    public SysIfBass0400VO getFuncBeforComboBass0400List(SysIfBass0400VO sysIfBass0400Vo) throws Exception { 
     
        SysComSearchVO  msfPkgSrhVo = new SysComSearchVO(); 
       
        List<String> bmResult = new ArrayList<String>();
        MSFUserInfoVO sessionUser = AnyWebServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
  
        
        if  (SmrmfUtils.paramNull(msfPkgSmrmfDAO)) {
            
            WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

            msfPkgSmrmfDAO = (SysIfPkgSmrmfDAO) wac.getBean("SysIfPkgSmrmfDAO" ); 
        }
        
        try {
             
            /** 조건절 */
        	msfPkgSrhVo.setYmdGb(sysIfBass0400Vo.getYmdGb());
            msfPkgSrhVo.setStrDate(sysIfBass0400Vo.getStrDate());
            msfPkgSrhVo.setDpobCd(sessionUser.getDpobCd());
            msfPkgSrhVo.setDeptCd(sysIfBass0400Vo.getDeptCd());
            msfPkgSrhVo.setDeptCdArr(sysIfBass0400Vo.getDeptCdArr());
            msfPkgSrhVo.setDeptDspyYn("Y"); 

            List list = msfPkgSmrmfDAO.setFuncBeforComboBass0400List(msfPkgSrhVo); 
            
            if (list.size() > 0) {
            	bmResult.addAll(sysIfBass0400Vo.getDeptCdArr());
            	 for(int ic=0;ic < list.size();ic++) {
	                	Map mapList = (Map)list.get(ic);
	                	bmResult.add(String.valueOf(mapList.get("dtilOccuInttnCd")));
	                }
            	 sysIfBass0400Vo.setRtnDeptCdArr(bmResult);
            }  
	       
        }
        catch (Exception ex) {
            //Return operation exception
        	ex.getStackTrace();
        }

        return sysIfBass0400Vo;
    }
    
    /**
     * 
     * <pre>
     * 1. 개요 : 
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : getFuncBeforComboBass0320List
     * @date : 2017. 1. 25.
     * @author : atres-pc
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2017. 1. 25.		atres-pc				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @see com.app.smrmf.infc.sysif.msfpackage.server.service.SysIfPkgSmrmfService#getFuncBeforComboBass0320List(com.app.smrmf.infc.sysif.msfpackage.server.vo.SysIfBass0320VO)
     * @param sysComBass0320Vo
     * @return
     * @throws MSFException
     */
	 public SysIfBass0320VO getFuncBeforComboBass0320List(SysIfBass0320VO sysComBass0320Vo) throws Exception {
		  //   PagingLoadResult<BaseModel> retval = null; 
		 SysComSearchVO  msfPkgSrhVo = new SysComSearchVO(); 
	       
	        List<String> bmResult = new ArrayList<String>();
	        MSFUserInfoVO sessionUser = AnyWebServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	  
	        
	        if  (SmrmfUtils.paramNull(msfPkgSmrmfDAO)) {
	            
	            WebApplicationContext wac = WebApplicationContextUtils.
	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	            msfPkgSmrmfDAO = (SysIfPkgSmrmfDAO) wac.getBean("SysIfPkgSmrmfDAO" ); 
	        }
	        
	        try {
	             
	            /** 조건절 */
	        	msfPkgSrhVo.setYmdGb(sysComBass0320Vo.getYmdGb());
	            msfPkgSrhVo.setStrDate(sysComBass0320Vo.getStrDate());
	            msfPkgSrhVo.setDpobCd(sessionUser.getDpobCd());
	         //   msfPkgSrhVo.setDeptCd(sysComBass0320Vo.getDeptCd());
	         //   msfPkgSrhVo.setDeptCdArr(sysComBass0320Vo.getDeptCdArr());
	            msfPkgSrhVo.setTypOccuCd(sysComBass0320Vo.getTypOccuCd());
	            msfPkgSrhVo.setTypOccuCdArr(sysComBass0320Vo.getTypOccuCdArr());

	            List list = msfPkgSmrmfDAO.setFuncBeforComboBass0320List(msfPkgSrhVo); 
	            
	            if (list.size() > 0) {
	            	bmResult.addAll(sysComBass0320Vo.getTypOccuCdArr());
	            	 for(int ic=0;ic < list.size();ic++) {
		                	Map mapList = (Map)list.get(ic);
		                	bmResult.add(String.valueOf(mapList.get("dtilOccuInttnCd")));
		                }
	            	 sysComBass0320Vo.setRtnTypOccuCdArr(bmResult);
	            }  
		       
	        }
	        catch (Exception ex) {
	            //Return operation exception
	        	ex.getStackTrace();
	        }

	        return sysComBass0320Vo;
	 }
	
	 
	/**
	 *  
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : getFuncBeforComboBass0350List
	 * @date : 2017. 1. 25.
	 * @author : atres-pc
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 1. 25.		atres-pc				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @see com.app.smrmf.infc.sysif.msfpackage.server.service.SysIfPkgSmrmfService#getFuncBeforComboBass0350List(com.app.smrmf.infc.sysif.msfpackage.server.vo.SysIfBass0350VO)
	 * @param sysIfBass0350Vo
	 * @return
	 * @throws MSFException
	 */
	public SysIfBass0350VO  getFuncBeforComboBass0350List(SysIfBass0350VO sysIfBass0350Vo) throws Exception {
		 SysComSearchVO  msfPkgSrhVo = new SysComSearchVO(); 
	       
	        List<String>  bmResult = new ArrayList<String>();
	        List<String>  bmResultInttn = new  ArrayList<String>();
	        MSFUserInfoVO sessionUser = AnyWebServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	  
	        
	        if  (SmrmfUtils.paramNull(msfPkgSmrmfDAO)) {
	            
	            WebApplicationContext wac = WebApplicationContextUtils.
	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	            msfPkgSmrmfDAO = (SysIfPkgSmrmfDAO) wac.getBean("SysIfPkgSmrmfDAO" ); 
	        }
	        
	        try {
	             
	            /** 조건절 */
	        	msfPkgSrhVo.setYmdGb(sysIfBass0350Vo.getYmdGb());
	            msfPkgSrhVo.setStrDate(sysIfBass0350Vo.getStrDate());
	            msfPkgSrhVo.setDpobCd(sessionUser.getDpobCd());
	            //msfPkgSrhVo.setDeptCd(sysIfBass0350Vo.getDeptCd());
	            //msfPkgSrhVo.setDeptCdArr(sysIfBass0350Vo.getDeptCdArr()); 
	            msfPkgSrhVo.setTypOccuCd(sysIfBass0350Vo.getTypOccuCd());
	            msfPkgSrhVo.setTypOccuCdArr(sysIfBass0350Vo.getTypOccuCdArr());
	            msfPkgSrhVo.setDtilOccuInttnCd(sysIfBass0350Vo.getDtilOccuInttnCd());
	            msfPkgSrhVo.setDtilOccuInttnCdArr(sysIfBass0350Vo.getDtilOccuInttnCdArr());
	            
	            List list = msfPkgSmrmfDAO.setFuncBeforComboBass0350List(msfPkgSrhVo); 
	            
	            if (list.size() > 0) {
	            	
	            	bmResult.addAll(sysIfBass0350Vo.getTypOccuCdArr());
		           	 for(int ic=0;ic < list.size();ic++) {
		                	Map mapList = (Map)list.get(ic);
		                	bmResult.add(String.valueOf(mapList.get("typOccuCd")));
		                }
		           	sysIfBass0350Vo.setRtnTypOccuCdArr(bmResult);
		           	  
		           	bmResultInttn.addAll(sysIfBass0350Vo.getDtilOccuInttnCdArr());
	           	 for(int ic=0;ic < list.size();ic++) {
	                	Map mapList = (Map)list.get(ic);
	                	bmResultInttn.add(String.valueOf(mapList.get("dtilOccuInttnCd")));
	                }
	           	sysIfBass0350Vo.setRtnDtilOccuInttnCdArr(bmResultInttn);
	            }  
	           
	        }
	        catch (Exception ex) {
	            //Return operation exception
	             ex.getStackTrace();
	        }

	        return sysIfBass0350Vo;
	 }
 
}
