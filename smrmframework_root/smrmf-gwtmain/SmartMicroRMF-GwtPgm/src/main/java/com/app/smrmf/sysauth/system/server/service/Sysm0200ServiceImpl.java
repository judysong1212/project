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
package com.app.smrmf.sysauth.system.server.service;

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
import com.app.smrmf.sysauth.system.client.service.Sysm0200Service;
import com.app.smrmf.sysauth.system.shared.SysmDaoConstants;
import com.app.smrmf.sysm.server.service.dao.Sysm0200DAO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0200SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0200VO;
@Service("Sysm0200Service") 
public class Sysm0200ServiceImpl extends AbstractCustomServiceImpl implements  SysmDaoConstants , Sysm0200Service {
	  
	private static final Logger logger = LoggerFactory.getLogger(Sysm0200ServiceImpl.class);
	private static final String calledClass = Sysm0200ServiceImpl.class.getName();
	
	@Autowired 
	@Resource(name="Sysm0200DAO")
	private Sysm0200DAO sysm0200DAO;
	 
    /** ID Generation */
    //@Resource(name="{egovSysm0200IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;
	  
	public List<SysIfSysm0200BM> getListSysm0200Menu() {
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
    
    
	/**
	 * SYSM0200을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SysIfSysm0200VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertSysm0200(SysIfSysm0200VO vo) throws Exception {
    	logger.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	logger.debug(vo.toString());
    	
    	sysm0200DAO.insertSysm0200(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * SYSM0200을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SysIfSysm0200VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateSysm0200(SysIfSysm0200VO vo) throws Exception {
        sysm0200DAO.updateSysm0200(vo);
    }

    /**
	 * SYSM0200을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SysIfSysm0200VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteSysm0200(SysIfSysm0200VO vo) throws Exception {
        sysm0200DAO.deleteSysm0200(vo);
    }

    /**
	 * SYSM0200을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SysIfSysm0200VO
	 * @return 조회한 SYSM0200
	 * @exception Exception
	 */
    public SysIfSysm0200VO selectSysm0200(SysIfSysm0200VO vo) throws Exception {
        SysIfSysm0200VO resultVO = sysm0200DAO.selectSysm0200(vo);
       // if (resultVO == null)
       //     throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * SYSM0200 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SYSM0200 목록
	 * @exception Exception
	 */
    public List selectSysm0200List(SysIfSysm0200SrhVO searchVO) throws Exception {
        return sysm0200DAO.selectSysm0200List(searchVO);
    }

    /**
	 * SYSM0200 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SYSM0200 총 갯수
	 * @exception
	 */
    public int selectSysm0200ListTotCnt(SysIfSysm0200SrhVO searchVO) {
		return sysm0200DAO.selectSysm0200ListTotCnt(searchVO);
	}
 
    
}


