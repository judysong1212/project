/**
 * 
 */
package com.app.exterms.prgm.server.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.exterms.prgm.server.service.dao.PrgmComBass0200DAO;
import com.app.exterms.prgm.server.vo.PrgmComBass0200VO;
import com.app.exterms.prgm.server.vo.PrgmComSearchVO;
import com.app.exterms.prgm.shared.PrgmComDaoConstants;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;

/**
 * @Class Name : Bass0200ServiceImpl.java
 * @Description : Bass0200 Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.03
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

public class PrgmComBass0200ServiceImpl extends AbstractCustomServiceImpl implements PrgmComDaoConstants {

	private static final Logger logger = LoggerFactory.getLogger(PrgmComBass0200ServiceImpl.class);

	public PrgmComBass0200ServiceImpl() {
	
	}
	    
	@Autowired
    @Resource(name="PrgmComBass0200DAO")
    private PrgmComBass0200DAO bass0200DAO;
      
	/**
	 * BASS0200을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Bass0200VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertBass0200(PrgmComBass0200VO vo) throws Exception {
		logger.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
		logger.debug(vo.toString());
    	
    	bass0200DAO.insertBass0200(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * BASS0200을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Bass0200VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateBass0200(PrgmComBass0200VO vo) throws Exception {
        bass0200DAO.updateBass0200(vo);
    }

    /**
	 * BASS0200을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Bass0200VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteBass0200(PrgmComBass0200VO vo) throws Exception {
        bass0200DAO.deleteBass0200(vo);
    }

    /**
	 * BASS0200을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Bass0200VO
	 * @return 조회한 BASS0200
	 * @exception Exception
	 */
    public PrgmComBass0200VO selectBass0200(PrgmComBass0200VO vo) throws Exception {
        PrgmComBass0200VO resultVO = bass0200DAO.selectBass0200(vo);
        if (resultVO == null)
        	throw MSFServerUtils.getSimpleMessageException("no data","데이타 없음.",logger); 
        return resultVO;
    }

    /**
	 * BASS0200 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return BASS0200 목록
	 * @exception Exception
	 */
    public List selectBass0200List(PrgmComSearchVO searchVO) throws Exception {
        return bass0200DAO.selectBass0200List(searchVO);
    }

    /**
	 * BASS0200 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return BASS0200 총 갯수
	 * @exception
	 */
    public int selectBass0200ListTotCnt(PrgmComSearchVO searchVO) {
		return bass0200DAO.selectBass0200ListTotCnt(searchVO);
	}
    
}
