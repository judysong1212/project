package com.web.exterms.mypage.board.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;

import com.web.exterms.mypage.board.service.Bord0400Service;
import com.web.exterms.mypage.board.service.BoardPageDefaultVO;
import com.web.exterms.mypage.board.service.Bord0400VO;
import com.web.exterms.mypage.board.service.impl.Bord0400DAO;

/**
 * @Class Name : Bord0400ServiceImpl.java
 * @Description : Bord0400 Business Implement class
 * @Modification Information
 *
 * @author boardsubmit
 * @since boardsubmit
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("bord0400Service")
public class Bord0400ServiceImpl extends AbstractServiceImpl implements
        Bord0400Service {

    @Resource(name="bord0400DAO")
    private Bord0400DAO bord0400DAO;
    
    /** ID Generation */
    //@Resource(name="{egovBord0400IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * BORD0400을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Bord0400VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertBoardPage1(Bord0400VO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	
    	bord0400DAO.insertBoardPage1(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * BORD0400을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Bord0400VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateBord0400(Bord0400VO vo) throws Exception {
        bord0400DAO.updateBord0400(vo);
    }

    /**
	 * BORD0400을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Bord0400VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteBord0400(Bord0400VO vo) throws Exception {
        bord0400DAO.deleteBord0400(vo);
    }

    /**
	 * BORD0400을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Bord0400VO
	 * @return 조회한 BORD0400
	 * @exception Exception
	 */
    public Bord0400VO selectBord0400(Bord0400VO vo) throws Exception {
        //Bord0400VO resultVO = bord0400DAO.selectBord0400(vo);
        //if (resultVO == null) 
            //throw processException("info.nodata.msg");
        //return resultVO;
    	return bord0400DAO.selectBord0400(vo);
      }
    
    /**
	 * BORD0400 파일 유무를 조회한다
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return BORD0400 목록
	 * @exception Exception
	 */
    public List selectCheckBord0400(Bord0400VO vo) throws Exception {
        return bord0400DAO.selectCheckBord0400(vo);
    }
    
    /**
	 * BORD0400 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return BORD0400 목록
	 * @exception Exception
	 */
    public List selectBord0400List(BoardPageDefaultVO searchVO) throws Exception {
        return bord0400DAO.selectBord0400List(searchVO);
    }

    /**
	 * BORD0400 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return BORD0400 총 갯수
	 * @exception
	 */
    public int selectBord0400ListTotCnt(BoardPageDefaultVO searchVO) {
		return bord0400DAO.selectBord0400ListTotCnt(searchVO);
	}
    
}
