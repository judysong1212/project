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
import com.app.smrmf.syscom.client.service.SysMstr050100Service;
import com.app.smrmf.syscom.server.service.dao.SysMstr050100DAO;

@Service("SysMstr050100Service")
public class SysMstr050100ServiceImpl extends AbstractCustomServiceImpl  implements SysMstr050100Service {

	private static final Logger logger = LoggerFactory.getLogger(SysMstr050100ServiceImpl.class);
	private static final String calledClass =  SysMstr050100ServiceImpl.class.getName();
	
	@Autowired
    @Resource(name="SysMstr050100DAO")
    private SysMstr050100DAO mstr050100DAO;
    
    /** ID Generation */
    //@Resource(name="{egovSysMstr050100IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * MSTR_05_0100을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SysMstr050100VO
	 * @return 등록 결과
	 * @exception Exception
	 */
//    public String insertSysMstr050100(SysMstr050100VO vo) throws Exception {
//    	log.debug(vo.toString());
//    	
//    	/** ID Generation Service */
//    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
//    	//String id = egovIdGnrService.getNextStringId();
//    	//vo.setId(id);
//    	log.debug(vo.toString());
//    	
//    	mstr050100DAO.insertSysMstr050100(vo);
//    	//TODO 해당 테이블 정보에 맞게 수정    	
//        return null;
//    }
//
//    /**
//	 * MSTR_05_0100을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 SysMstr050100VO
//	 * @return void형
//	 * @exception Exception
//	 */
//    public void updateSysMstr050100(SysMstr050100VO vo) throws Exception {
//        mstr050100DAO.updateSysMstr050100(vo);
//    }
//
//    /**
//	 * MSTR_05_0100을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 SysMstr050100VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//    public void deleteSysMstr050100(SysMstr050100VO vo) throws Exception {
//        mstr050100DAO.deleteSysMstr050100(vo);
//    }
//
//    /**
//	 * MSTR_05_0100을 조회한다.
//	 * @param vo - 조회할 정보가 담긴 SysMstr050100VO
//	 * @return 조회한 MSTR_05_0100
//	 * @exception Exception
//	 */
//    public SysMstr050100VO selectSysMstr050100(SysMstr050100VO vo) throws Exception {
//        SysMstr050100VO resultVO = mstr050100DAO.selectSysMstr050100(vo);
//        if (resultVO == null)
//            throw processException("info.nodata.msg");
//        return resultVO;
//    }
//
//    /**
//	 * MSTR_05_0100 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return MSTR_05_0100 목록
//	 * @exception Exception
//	 */
//    public List selectSysMstr050100List(SysMstr050100DefaultVO searchVO) throws Exception {
//        return mstr050100DAO.selectSysMstr050100List(searchVO);
//    }
//
//    /**
//	 * MSTR_05_0100 총 갯수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return MSTR_05_0100 총 갯수
//	 * @exception
//	 */
//    public int selectSysMstr050100ListTotCnt(SysMstr050100DefaultVO searchVO) {
//		return mstr050100DAO.selectSysMstr050100ListTotCnt(searchVO);
//	}
    
	 
}
