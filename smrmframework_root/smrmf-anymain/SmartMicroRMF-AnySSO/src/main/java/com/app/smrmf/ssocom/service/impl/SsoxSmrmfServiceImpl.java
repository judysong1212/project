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
package com.app.smrmf.ssocom.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.smrmf.ssocom.service.SsoxSmrmfService;
import com.app.smrmf.sysm.server.vo.system.SsoxUserSrhVO;
import com.app.smrmf.sysm.server.vo.system.SsoxUserVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("SsoxSmrmfService")
public  class SsoxSmrmfServiceImpl extends AbstractServiceImpl implements SsoxSmrmfService   {

	private static final Logger logger = LoggerFactory.getLogger(SsoxSmrmfServiceImpl.class);
  
	@Autowired 
    @Resource(name="SsoxSmrmfDAO")
    private SsoxSmrmfDAO ssoxUserDAO;
    
    /** ID Generation */
    //@Resource(name="{egovSsoxUserIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;


	/**
	 * SSOX_USER을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SsoxUserVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertSsoxUser(SsoxUserVO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	log.debug(vo.toString());
    	
    	ssoxUserDAO.insertSsoxUser(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * SSOX_USER을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SsoxUserVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateSsoxUser(SsoxUserVO vo) throws Exception {
        ssoxUserDAO.updateSsoxUser(vo);
    }

    /**
	 * SSOX_USER을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SsoxUserVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteSsoxUser(SsoxUserVO vo) throws Exception {
        ssoxUserDAO.deleteSsoxUser(vo);
    }

    /**
	 * SSOX_USER을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SsoxUserVO
	 * @return 조회한 SSOX_USER
	 * @exception Exception
	 */
    public SsoxUserVO selectSsoxUser(SsoxUserVO vo) throws Exception {
        SsoxUserVO resultVO = ssoxUserDAO.selectSsoxUser(vo);
        //if (resultVO == null)
        //    throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
   	 * SSOX_USER 목록을 조회한다.
   	 * @param searchVO - 조회할 정보가 담긴 VO
   	 * @return SSOX_USER 목록
   	 * @exception Exception
   	 */
       public List<?> selectSsoxUserList(SsoxUserSrhVO searchVO) throws Exception {
           return ssoxUserDAO.selectSsoxUserList(searchVO);
       }

       /**
   	 * SSOX_USER 총 갯수를 조회한다.
   	 * @param searchVO - 조회할 정보가 담긴 VO
   	 * @return SSOX_USER 총 갯수
   	 * @exception
   	 */
       public int selectSsoxUserListTotCnt(SsoxUserSrhVO searchVO) {
   		return ssoxUserDAO.selectSsoxUserListTotCnt(searchVO);
   	}
     
       /**
      	 * SSOX_USER 목록을 조회한다.
      	 * @param searchVO - 조회할 정보가 담긴 VO
      	 * @return SSOX_USER 목록
      	 * @exception Exception
      	 */
          public List<?> selectMagicSsoUserList(SsoxUserSrhVO searchVO) throws Exception {
              return ssoxUserDAO.selectMagicSsoUserList(searchVO);
          }

          /**
      	 * SSOX_USER 총 갯수를 조회한다.
      	 * @param searchVO - 조회할 정보가 담긴 VO
      	 * @return SSOX_USER 총 갯수
      	 * @exception
      	 */
          public int selectMagicSsoUserListTotCnt(SsoxUserSrhVO searchVO) {
      		return ssoxUserDAO.selectMagicSsoUserListTotCnt(searchVO);
      	}
            
	
}
