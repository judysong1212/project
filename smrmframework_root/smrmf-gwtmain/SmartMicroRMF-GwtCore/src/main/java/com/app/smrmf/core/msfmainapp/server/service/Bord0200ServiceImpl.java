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
package com.app.smrmf.core.msfmainapp.server.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.smrmf.core.msfmainapp.client.service.Bord0200Service;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.sysm.server.service.dao.Bord0200DAO;
@Service("Bord0200Service")
public class Bord0200ServiceImpl extends AbstractCustomServiceImpl implements Bord0200Service {

	private static final Logger logger = LoggerFactory.getLogger(Bord0200ServiceImpl.class);
	private static final String calledClass = Bord0200ServiceImpl.class.getName();
	
	@Autowired

    @Resource(name="Bord0200DAO")
    private Bord0200DAO bord0200DAO;
    
    /** ID Generation */
    //@Resource(name="{egovBord0200IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * BORD0200을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Bord0200VO
	 * @return 등록 결과
	 * @exception Exception
	 */
//    public String insertBord0200(Bord0200VO vo) throws Exception {
//    	log.debug(vo.toString());
//    	
//    	/** ID Generation Service */
//    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
//    	//String id = egovIdGnrService.getNextStringId();
//    	//vo.setId(id);
//    	log.debug(vo.toString());
//    	
//    	bord0200DAO.insertBord0200(vo);
//    	//TODO 해당 테이블 정보에 맞게 수정    	
//        return null;
//    }
//
//    /**
//	 * BORD0200을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 Bord0200VO
//	 * @return void형
//	 * @exception Exception
//	 */
//    public void updateBord0200(Bord0200VO vo) throws Exception {
//        bord0200DAO.updateBord0200(vo);
//    }
//
//    /**
//	 * BORD0200을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 Bord0200VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//    public void deleteBord0200(Bord0200VO vo) throws Exception {
//        bord0200DAO.deleteBord0200(vo);
//    }
//
//    /**
//	 * BORD0200을 조회한다.
//	 * @param vo - 조회할 정보가 담긴 Bord0200VO
//	 * @return 조회한 BORD0200
//	 * @exception Exception
//	 */
//    public Bord0200VO selectBord0200(Bord0200VO vo) throws Exception {
//        Bord0200VO resultVO = bord0200DAO.selectBord0200(vo);
//        if (resultVO == null)
//            throw processException("info.nodata.msg");
//        return resultVO;
//    }
//
//    /**
//	 * BORD0200 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return BORD0200 목록
//	 * @exception Exception
//	 */
//    public List selectBord0200List(Bord0200DefaultVO searchVO) throws Exception {
//        return bord0200DAO.selectBord0200List(searchVO);
//    }
//
//    /**
//	 * BORD0200 총 갯수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return BORD0200 총 갯수
//	 * @exception
//	 */
//    public int selectBord0200ListTotCnt(Bord0200DefaultVO searchVO) {
//		return bord0200DAO.selectBord0200ListTotCnt(searchVO);
//	}
    
	 
}
