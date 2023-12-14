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
package com.app.smrmf.syscom.server.service;

import javax.annotation.Resource;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.syscom.client.service.SysMstr060300Service;
import com.app.smrmf.syscom.server.service.dao.SysMstr060300DAO;

@Service("SysMstr060300Service")
public class SysMstr060300ServiceImpl extends AbstractCustomServiceImpl  implements SysMstr060300Service {

	private static final Logger logger = LoggerFactory.getLogger(SysMstr060300ServiceImpl.class);
	private static final String calledClass =  SysMstr060300ServiceImpl.class.getName();
	
	@Autowired
    @Resource(name="SysMstr060300DAO")
    private SysMstr060300DAO mstr060300DAO;
    
    /** ID Generation */
    //@Resource(name="{egovSysMstr060300IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * MSTR_06_0300을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SysMstr060300VO
	 * @return 등록 결과
	 * @exception Exception
	 */
//    public String insertSysMstr060300(SysMstr060300VO vo) throws Exception {
//    	log.debug(vo.toString());
//    	
//    	/** ID Generation Service */
//    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
//    	//String id = egovIdGnrService.getNextStringId();
//    	//vo.setId(id);
//    	log.debug(vo.toString());
//    	
//    	mstr060300DAO.insertSysMstr060300(vo);
//    	//TODO 해당 테이블 정보에 맞게 수정    	
//        return null;
//    }
//
//    /**
//	 * MSTR_06_0300을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 SysMstr060300VO
//	 * @return void형
//	 * @exception Exception
//	 */
//    public void updateSysMstr060300(SysMstr060300VO vo) throws Exception {
//        mstr060300DAO.updateSysMstr060300(vo);
//    }
//
//    /**
//	 * MSTR_06_0300을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 SysMstr060300VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//    public void deleteSysMstr060300(SysMstr060300VO vo) throws Exception {
//        mstr060300DAO.deleteSysMstr060300(vo);
//    }
//
//    /**
//	 * MSTR_06_0300을 조회한다.
//	 * @param vo - 조회할 정보가 담긴 SysMstr060300VO
//	 * @return 조회한 MSTR_06_0300
//	 * @exception Exception
//	 */
//    public SysMstr060300VO selectSysMstr060300(SysMstr060300VO vo) throws Exception {
//        SysMstr060300VO resultVO = mstr060300DAO.selectSysMstr060300(vo);
//        if (resultVO == null)
//            throw processException("info.nodata.msg");
//        return resultVO;
//    }
//
//    /**
//	 * MSTR_06_0300 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return MSTR_06_0300 목록
//	 * @exception Exception
//	 */
//    public List selectSysMstr060300List(SysMstr060300DefaultVO searchVO) throws Exception {
//        return mstr060300DAO.selectSysMstr060300List(searchVO);
//    }
//
//    /**
//	 * MSTR_06_0300 총 갯수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return MSTR_06_0300 총 갯수
//	 * @exception
//	 */
//    public int selectSysMstr060300ListTotCnt(SysMstr060300DefaultVO searchVO) {
//		return mstr060300DAO.selectSysMstr060300ListTotCnt(searchVO);
//	}
     
}
