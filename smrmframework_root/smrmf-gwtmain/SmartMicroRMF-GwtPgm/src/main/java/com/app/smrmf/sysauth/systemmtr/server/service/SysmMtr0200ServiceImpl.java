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

import javax.annotation.Resource;

import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfSysm0200BM;
import com.app.smrmf.sysauth.systemmtr.client.service.SysmMtr0200Service;
import com.app.smrmf.sysauth.systemmtr.shared.SysmMtrDaoConstants;
import com.app.smrmf.sysm.server.service.dao.Sysm0200DAO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0200SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0200VO;
@Service("SysmMtr0200Service") 
public class SysmMtr0200ServiceImpl extends AbstractCustomServiceImpl implements  SysmMtrDaoConstants , SysmMtr0200Service {
	  
	private static final Logger logger = LoggerFactory.getLogger(SysmMtr0200ServiceImpl.class);
	private static final String calledClass = SysmMtr0200ServiceImpl.class.getName();
	
	@Autowired 
	@Resource(name="Sysm0200DAO")
	private Sysm0200DAO sysm0200DAO;
 
	 
    /** ID Generation */
    //@Resource(name="{egovSysm0200IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;
	@Override
	public List<SysIfSysm0200BM> getListSysmMtr0200Menu() {
		// TODO Auto-generated method stub
		  
	        List<SysIfSysm0200BM> retval = new ArrayList<SysIfSysm0200BM>();
	        SysIfSysm0200SrhVO sysm0200SrhVo = new SysIfSysm0200SrhVO();
	         
	        MSFSysm0100BM sessUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	        if (sessUser!=null) {
	            try { 
	            	sysm0200SrhVo.setLastIndex(-1);
	            	List<SysIfSysm0200VO> list = sysm0200DAO.selectMenuSysm0200List(sysm0200SrhVo); 
	            	
	                Iterator<SysIfSysm0200VO> iter = list.iterator();
	                putValuesIntoList(iter, retval);
	            }
	            catch (Exception ex) {
	                logger.error("EXCEPTION calling getListaVociMenu(): "+ex);
	            } 
	        }
	        return retval;		
	}
	
    private void putValuesIntoList(Iterator<SysIfSysm0200VO> iter, List<SysIfSysm0200BM> retval) {
        while (iter.hasNext()) {
        	SysIfSysm0200VO mnu =  iter.next();
            if ( mnu!=null ) {
//                String category = null;
//                if (mnu.getAdmMenu() != null) {
//                    category = mnu.getAdmMenu().getMnuCd();
//                }
                SysIfSysm0200BM menu = new SysIfSysm0200BM( 
                          mnu.getSysDivCd() 
                        , mnu.getMnuCd() 
                        , mnu.getHhrkMnuCd()  //category
                        , mnu.getMnuNm() 
                        , mnu.getMnuIcn()  
                        , mnu.getMnuTmbl() 
                        , mnu.getMnuAuthFrmCd() 
                        , mnu.getMnuTipNm() 
                        , mnu.getMnuScnFrmPkgNm() 
                      //  , MSFSharedUtils.convertStringToBoolean(mnu.getMnuPrntYn()) 
                        ,  mnu.getMnuPrntYn()  
                        , String.valueOf(mnu.getMnuPrntOrd())   
                       // , MSFSharedUtils.convertStringToBoolean(mnu.getUseYn()) 
                       , mnu.getUseYn() 
                        , mnu.getMnuEpln()          
               		  //  ,false, false, false,false,false 
                		); 
                
                retval.add(menu);
//                Set listDetails = mnu.getAdmMenus();
//                if (listDetails != null) {
//                    putValuesIntoList(listDetails.iterator(), retval);
//                }
            }
        }
    }
    
 
    
}


