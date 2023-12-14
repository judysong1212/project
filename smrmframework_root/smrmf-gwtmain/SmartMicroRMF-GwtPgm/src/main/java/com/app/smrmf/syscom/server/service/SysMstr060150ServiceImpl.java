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
import com.app.smrmf.syscom.client.service.SysMstr060150Service;
import com.app.smrmf.syscom.server.service.dao.SysMstr060150DAO;

@Service("SysMstr060150Service")
public class SysMstr060150ServiceImpl extends AbstractCustomServiceImpl  implements SysMstr060150Service {

	private static final Logger logger = LoggerFactory.getLogger(SysMstr060150ServiceImpl.class);
	private static final String calledClass =  SysMstr060150ServiceImpl.class.getName();
	
	@Autowired
	@Resource(name="SysMstr060150DAO")
    private SysMstr060150DAO mstr060150DAO;
    
    /** ID Generation */
    //@Resource(name="{egovSysMstr060150IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * MSTR_06_0150을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SysMstr060150VO
	 * @return 등록 결과
	 * @exception Exception
	 */
//    public String insertSysMstr060150(SysMstr060150VO vo) throws Exception {
//    	log.debug(vo.toString());
//    	
//    	/** ID Generation Service */
//    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
//    	//String id = egovIdGnrService.getNextStringId();
//    	//vo.setId(id);
//    	log.debug(vo.toString());
//    	
//    	mstr060150DAO.insertSysMstr060150(vo);
//    	//TODO 해당 테이블 정보에 맞게 수정    	
//        return null;
//    }
//
//    /**
//	 * MSTR_06_0150을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 SysMstr060150VO
//	 * @return void형
//	 * @exception Exception
//	 */
//    public void updateSysMstr060150(SysMstr060150VO vo) throws Exception {
//        mstr060150DAO.updateSysMstr060150(vo);
//    }
//
//    /**
//	 * MSTR_06_0150을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 SysMstr060150VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//    public void deleteSysMstr060150(SysMstr060150VO vo) throws Exception {
//        mstr060150DAO.deleteSysMstr060150(vo);
//    }
//
//    /**
//	 * MSTR_06_0150을 조회한다.
//	 * @param vo - 조회할 정보가 담긴 SysMstr060150VO
//	 * @return 조회한 MSTR_06_0150
//	 * @exception Exception
//	 */
//    public SysMstr060150VO selectSysMstr060150(SysMstr060150VO vo) throws Exception {
//        SysMstr060150VO resultVO = mstr060150DAO.selectSysMstr060150(vo);
//        if (resultVO == null)
//            throw processException("info.nodata.msg");
//        return resultVO;
//    }
//
//    /**
//	 * MSTR_06_0150 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return MSTR_06_0150 목록
//	 * @exception Exception
//	 */
//    public List selectSysMstr060150List(SysMstr060150DefaultVO searchVO) throws Exception {
//        return mstr060150DAO.selectSysMstr060150List(searchVO);
//    }
//
//    /**
//	 * MSTR_06_0150 총 갯수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return MSTR_06_0150 총 갯수
//	 * @exception
//	 */
//    public int selectSysMstr060150ListTotCnt(SysMstr060150DefaultVO searchVO) {
//		return mstr060150DAO.selectSysMstr060150ListTotCnt(searchVO);
//	}
   
}
