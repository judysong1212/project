package com.web.exterms.mypage.board.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import com.web.exterms.mypage.board.service.BoardPageService;
import com.web.exterms.mypage.board.service.BoardPageDefaultVO;
import com.web.exterms.mypage.board.service.BoardPageVO;
import com.web.exterms.mypage.board.service.impl.BoardPageDAO;

/**
 * @Class Name : Bord0300ServiceImpl.java
 * @Description : Bord0300 Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("boardPageService")
public class BoardPageServiceImpl extends AbstractServiceImpl implements
        BoardPageService {

    @Resource(name="boardPageDAO")
    private BoardPageDAO boardPageDAO;
    
    /** ID Generation */
    //@Resource(name="{egovBord0300IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * BORD0300을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Bord0300VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertBoardPage(BoardPageVO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	//log.debug(vo.toString());
    	boardPageDAO.insertBoardPage(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }
   
    /**
	 * BORD0300을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Bord0300VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateBoardPage(BoardPageVO vo) throws Exception {
        boardPageDAO.updateBoardPage(vo);
    }

    /**
	 * BORD0300을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Bord0300VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteBoardPage(BoardPageVO vo) throws Exception {
        boardPageDAO.deleteBoardPage(vo);
    }

    /**
	 * BORD0300을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Bord0300VO
	 * @return 조회한 BORD0300
	 * @exception Exception
	 */
    public BoardPageVO selectBoardPage(BoardPageVO vo) throws Exception {
        BoardPageVO resultVO = boardPageDAO.selectBoardPage(vo);
       if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * BORD0300 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return BORD0300 목록
	 * @exception Exception
	 */
    public List selectBoardPageList(BoardPageDefaultVO searchVO) throws Exception {
        return boardPageDAO.selectBoardPageList(searchVO);
    }

    /**
	 * BORD0300 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return BORD0300 총 갯수
	 * @exception
	 */
    public int selectBoardPageListTotCnt(BoardPageDefaultVO searchVO) {
		return boardPageDAO.selectBoardPageListTotCnt(searchVO);
	}

    
   
    
}
