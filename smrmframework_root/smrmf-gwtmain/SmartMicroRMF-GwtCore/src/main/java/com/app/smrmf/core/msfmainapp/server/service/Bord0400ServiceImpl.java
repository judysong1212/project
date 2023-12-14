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

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.smrmf.core.msfmainapp.client.admin.dto.Bord0400DTO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.service.Bord0400Service;
import com.app.smrmf.core.msfmainapp.client.service.system.LoginService;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.MSFDaoConstants;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.sysm.server.service.dao.Bord0400DAO;
import com.app.smrmf.sysm.server.service.vo.Bord0400VO;

@Service("Bord0400Service")
public class Bord0400ServiceImpl extends AbstractCustomServiceImpl  implements Bord0400Service  ,MSFDaoConstants {

	private static final Logger logger = LoggerFactory.getLogger(Bord0400ServiceImpl.class);
	private static final String calledClass = Bord0400ServiceImpl.class.getName();
	
	@Autowired
	@Resource(name="Bord0400DAO")
	private Bord0400DAO bord0400DAO;
	
	@Autowired
	@Resource(name="LoginService")
	private LoginService loginService;

    @Override
    public Bord0400DTO activityOnBoard0400(Bord0400DTO bord0400Dto, ActionDatabase actionDatabase) {
        

        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        if  (MSFSharedUtils.paramNull(bord0400DAO)) {
            
            WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

            bord0400DAO = (Bord0400DAO) wac.getBean("Bord0400DAO" ); 
        }
        
        
        try { 
            
            Bord0400VO bord0400Vo = new Bord0400VO(); 
             
            
            bord0400Vo.setSysDivCd(bord0400Dto.getSysDivCd());    /** column 시스템구분코드 : sysDivCd */
            bord0400Vo.setBullBordMsgeAttcFlNum(new BigDecimal(bord0400Dto.getBullBordMsgeAttcFlNum()));    /** column 게시글첨부파일일련번호 : bullBordMsgeAttcFlNum */
            bord0400Vo.setBullBordMsgeSeilNum(new BigDecimal(bord0400Dto.getBullBordMsgeSeilNum()));    /** column 게시글일련번호 : bullBordMsgeSeilNum */
            bord0400Vo.setBullBordUid(bord0400Dto.getBullBordUid());    /** column 게시판_UID : bullBordUid */
            bord0400Vo.setBullBordGrpId(new BigDecimal(bord0400Dto.getBullBordGrpId()));    /** column 게시판그룹ID : bullBordGrpId */
            bord0400Vo.setFlNm(bord0400Dto.getFlNm());    /** column 파일 이름 : flNm */
            bord0400Vo.setFlSz(bord0400Dto.getFlSz());    /** column 파일 크기 : flSz */
            bord0400Vo.setCtntTyp(bord0400Dto.getCtntTyp());    /** column 콘텐트 타입 : ctntTyp */
            bord0400Vo.setDwldNum(new BigDecimal(bord0400Dto.getDwldNum()));    /** column 다운로드 수 : dwldNum */
            bord0400Vo.setImgSzEtt(new BigDecimal(bord0400Dto.getImgSzEtt()));    /** column 이미지 크기 넓이 : imgSzEtt */
            bord0400Vo.setImgSzHeit(new BigDecimal(bord0400Dto.getImgSzHeit()));    /** column 이미지 크기 높이 : imgSzHeit */
            bord0400Vo.setFlRfta(loginService.getServerMessages().get("PayGen.ExTermUpload"));    /** column 게시글파일경로 : flRfta Globals.EXTERM_UPLOAD */
            bord0400Vo.setKybdr(bord0400Dto.getKybdr());    /** column 입력자 : kybdr */
            bord0400Vo.setInptDt(bord0400Dto.getInptDt());    /** column 입력일자 : inptDt */
            bord0400Vo.setInptAddr(bord0400Dto.getInptAddr());    /** column 입력주소 : inptAddr */
            bord0400Vo.setIsmt(bord0400Dto.getIsmt());    /** column 수정자 : ismt */
            bord0400Vo.setRevnDt(bord0400Dto.getRevnDt());    /** column 수정일자 : revnDt */
            bord0400Vo.setRevnAddr(bord0400Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
           
       
            switch (actionDatabase) {
            case INSERT:
                bord0400DAO.insertBord0400(bord0400Vo); 
               break;
            case UPDATE: 
                bord0400DAO.updateBord0400(bord0400Vo); 
                break;
            case DELETE:  
                bord0400DAO.deleteBord0400(bord0400Vo);  
                break;
            } 
            
            bord0400Vo =  bord0400DAO.selectBord0400(bord0400Vo); 
            
            if  (bord0400Vo != null) {
                bord0400Dto.setBullBordMsgeSeilNum(bord0400Vo.getBullBordMsgeSeilNum().longValue());
            }
            
            
        }
        catch (Exception ex) {
            logger.error("EXCEPTION calling activityOnBoard0400(): "+ex);  
        }
        finally {
          
        }
        
        return bord0400Dto; 
    }
	    
	    /** ID Generation */
	    //@Resource(name="{egovBord0400IdGnrService}")    
	    //private EgovIdGnrService egovIdGnrService;

		/**
		 * BORD0400을 등록한다.
		 * @param vo - 등록할 정보가 담긴 Bord0400VO
		 * @return 등록 결과
		 * @exception Exception
		 */
//	    public String insertBord0400(Bord0400VO vo) throws Exception {
//	    	log.debug(vo.toString());
//	    	
//	    	/** ID Generation Service */
//	    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
//	    	//String id = egovIdGnrService.getNextStringId();
//	    	//vo.setId(id);
//	    	log.debug(vo.toString());
//	    	
//	    	bord0400DAO.insertBord0400(vo);
//	    	//TODO 해당 테이블 정보에 맞게 수정    	
//	        return null;
//	    }
//
//	    /**
//		 * BORD0400을 수정한다.
//		 * @param vo - 수정할 정보가 담긴 Bord0400VO
//		 * @return void형
//		 * @exception Exception
//		 */
//	    public void updateBord0400(Bord0400VO vo) throws Exception {
//	        bord0400DAO.updateBord0400(vo);
//	    }
//
//	    /**
//		 * BORD0400을 삭제한다.
//		 * @param vo - 삭제할 정보가 담긴 Bord0400VO
//		 * @return void형 
//		 * @exception Exception
//		 */
//	    public void deleteBord0400(Bord0400VO vo) throws Exception {
//	        bord0400DAO.deleteBord0400(vo);
//	    }
//
//	    /**
//		 * BORD0400을 조회한다.
//		 * @param vo - 조회할 정보가 담긴 Bord0400VO
//		 * @return 조회한 BORD0400
//		 * @exception Exception
//		 */
//	    public Bord0400VO selectBord0400(Bord0400VO vo) throws Exception {
//	        Bord0400VO resultVO = bord0400DAO.selectBord0400(vo);
//	        if (resultVO == null)
//	            throw processException("info.nodata.msg");
//	        return resultVO;
//	    }
//
//	    /**
//		 * BORD0400 목록을 조회한다.
//		 * @param searchVO - 조회할 정보가 담긴 VO
//		 * @return BORD0400 목록
//		 * @exception Exception
//		 */
//	    public List selectBord0400List(Bord0400DefaultVO searchVO) throws Exception {
//	        return bord0400DAO.selectBord0400List(searchVO);
//	    }
//
//	    /**
//		 * BORD0400 총 갯수를 조회한다.
//		 * @param searchVO - 조회할 정보가 담긴 VO
//		 * @return BORD0400 총 갯수
//		 * @exception
//		 */
//	    public int selectBord0400ListTotCnt(Bord0400DefaultVO searchVO) {
//			return bord0400DAO.selectBord0400ListTotCnt(searchVO);
//		}
	 
}
