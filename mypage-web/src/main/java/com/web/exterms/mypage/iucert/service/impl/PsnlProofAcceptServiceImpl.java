package com.web.exterms.mypage.iucert.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import com.web.exterms.mypage.iucert.service.PsnlProofAcceptService;
import com.web.exterms.mypage.iucert.service.PsnlProofAcceptDefaultVO;
import com.web.exterms.mypage.iucert.service.PsnlProofAcceptVO;
import com.web.exterms.mypage.iucert.service.impl.PsnlProofAcceptDAO;

/**
 * @Class Name : Psnl0550ServiceImpl.java
 * @Description : Psnl0550 Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("psnl0550Service")
public class PsnlProofAcceptServiceImpl extends AbstractServiceImpl implements
        PsnlProofAcceptService {

    @Resource(name="psnl0550DAO")
    private PsnlProofAcceptDAO psnl0550DAO;
    
    /** ID Generation */
    //@Resource(name="{egovPsnl0550IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * PSNL0550을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Psnl0550VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertPsnl0550(PsnlProofAcceptVO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	log.debug(vo.toString());
    	
    	psnl0550DAO.insertPsnl0550(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * PSNL0550을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Psnl0550VO
	 * @return void형
	 * @exception Exception
	 */
    public void updatePsnl0550(PsnlProofAcceptVO vo) throws Exception {
        psnl0550DAO.updatePsnl0550(vo);
    }

    /**
	 * PSNL0550을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Psnl0550VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deletePsnl0550(PsnlProofAcceptVO vo) throws Exception {
        psnl0550DAO.deletePsnl0550(vo);
    }

    /**
	 * PSNL0550을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Psnl0550VO
	 * @return 조회한 PSNL0550
	 * @exception Exception
	 */
    public PsnlProofAcceptVO selectPsnl0550(PsnlProofAcceptVO vo) throws Exception {
        PsnlProofAcceptVO resultVO = psnl0550DAO.selectPsnl0550(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * PSNL0550 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return PSNL0550 목록
	 * @exception Exception
	 */
    public List selectPsnl0550List(PsnlProofAcceptDefaultVO searchVO) throws Exception {
        return psnl0550DAO.selectPsnl0550List(searchVO);
    }

    /**
	 * PSNL0550 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return PSNL0550 총 갯수
	 * @exception
	 */
    public int selectPsnl0550ListTotCnt(PsnlProofAcceptDefaultVO searchVO) {
		return psnl0550DAO.selectPsnl0550ListTotCnt(searchVO);
	}
    
}
