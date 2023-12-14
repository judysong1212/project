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

import com.app.smrmf.core.msfmainapp.client.service.Bord0100Service;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.sysm.server.service.dao.Bord0100DAO;
@Service("Bord0100Service")
public class Bord0100ServiceImpl  extends AbstractCustomServiceImpl implements Bord0100Service {

	private static final Logger logger = LoggerFactory.getLogger(Bord0100ServiceImpl.class);
	private static final String calledClass = Bord0100ServiceImpl.class.getName();
	
	@Autowired
	@Resource(name="Bord0100DAO")
    private Bord0100DAO bord0100DAO;
    
    /** ID Generation */
    //@Resource(name="{egovBord0100IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

//	/**
//	 * BORD0100을 등록한다.
//	 * @param vo - 등록할 정보가 담긴 Bord0100VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//    public String insertBord0100(Bord0100VO vo) throws Exception {
//    	log.debug(vo.toString());
//    	
//    	/** ID Generation Service */
//    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
//    	//String id = egovIdGnrService.getNextStringId();
//    	//vo.setId(id);
//    	log.debug(vo.toString());
//    	
//    	bord0100DAO.insertBord0100(vo);
//    	//TODO 해당 테이블 정보에 맞게 수정    	
//        return null;
//    }
//
//    /**
//	 * BORD0100을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 Bord0100VO
//	 * @return void형
//	 * @exception Exception
//	 */
//    public void updateBord0100(Bord0100VO vo) throws Exception {
//        bord0100DAO.updateBord0100(vo);
//    }
//
//    /**
//	 * BORD0100을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 Bord0100VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//    public void deleteBord0100(Bord0100VO vo) throws Exception {
//        bord0100DAO.deleteBord0100(vo);
//    }
//
//    /**
//	 * BORD0100을 조회한다.
//	 * @param vo - 조회할 정보가 담긴 Bord0100VO
//	 * @return 조회한 BORD0100
//	 * @exception Exception
//	 */
//    public Bord0100VO selectBord0100(Bord0100VO vo) throws Exception {
//        Bord0100VO resultVO = bord0100DAO.selectBord0100(vo);
//        if (resultVO == null)
//            throw processException("info.nodata.msg");
//        return resultVO;
//    }
//
//    /**
//	 * BORD0100 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return BORD0100 목록
//	 * @exception Exception
//	 */
//    public List selectBord0100List(Bord0100DefaultVO searchVO) throws Exception {
//        return bord0100DAO.selectBord0100List(searchVO);
//    }
//
//    /**
//	 * BORD0100 총 갯수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return BORD0100 총 갯수
//	 * @exception
//	 */
//    public int selectBord0100ListTotCnt(Bord0100DefaultVO searchVO) {
//		return bord0100DAO.selectBord0100ListTotCnt(searchVO);
//	}
     
}
