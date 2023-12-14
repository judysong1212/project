package com.app.smrmf.sysauth.systemusr.server.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.sysauth.systemusr.client.service.SysmUsr0850Service;
import com.app.smrmf.sysm.server.service.dao.Sysm0850DAO;

/**
 * @Class Name : Sysm0850ServiceImpl.java
 * @Description : Sysm0850 Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2016.09.09
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("SysmUsr0850Service")
public class SysmUsr0850ServiceImpl extends AbstractCustomServiceImpl implements  SysmUsr0850Service {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(SysmUsr0850ServiceImpl.class);

    @Resource(name="Sysm0850DAO")
    private Sysm0850DAO sysm0850DAO;
    
    /** ID Generation */
    //@Resource(name="{egovSysm0850IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

//	/**
//	 * SYSM0850을 등록한다.
//	 * @param vo - 등록할 정보가 담긴 Sysm0850VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//    public String insertSysm0850(Sysm0850VO vo) throws Exception {
//    	LOGGER.debug(vo.toString());
//    	
//    	/** ID Generation Service */
//    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
//    	//String id = egovIdGnrService.getNextStringId();
//    	//vo.setId(id);
//    	LOGGER.debug(vo.toString());
//    	
//    	sysm0850DAO.insertSysm0850(vo);
//    	//TODO 해당 테이블 정보에 맞게 수정    	
//        return null;
//    }
//
//    /**
//	 * SYSM0850을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 Sysm0850VO
//	 * @return void형
//	 * @exception Exception
//	 */
//    public void updateSysm0850(Sysm0850VO vo) throws Exception {
//        sysm0850DAO.updateSysm0850(vo);
//    }
//
//    /**
//	 * SYSM0850을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 Sysm0850VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//    public void deleteSysm0850(Sysm0850VO vo) throws Exception {
//        sysm0850DAO.deleteSysm0850(vo);
//    }
//
//    /**
//	 * SYSM0850을 조회한다.
//	 * @param vo - 조회할 정보가 담긴 Sysm0850VO
//	 * @return 조회한 SYSM0850
//	 * @exception Exception
//	 */
//    public Sysm0850VO selectSysm0850(Sysm0850VO vo) throws Exception {
//        Sysm0850VO resultVO = sysm0850DAO.selectSysm0850(vo);
//        if (resultVO == null)
//            throw processException("info.nodata.msg");
//        return resultVO;
//    }
//
//    /**
//	 * SYSM0850 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return SYSM0850 목록
//	 * @exception Exception
//	 */
//    public List<?> selectSysm0850List(Sysm0850SrhVO searchVO) throws Exception {
//        return sysm0850DAO.selectSysm0850List(searchVO);
//    }
//
//    /**
//	 * SYSM0850 총 갯수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return SYSM0850 총 갯수
//	 * @exception
//	 */
//    public int selectSysm0850ListTotCnt(Sysm0850SrhVO searchVO) {
//		return sysm0850DAO.selectSysm0850ListTotCnt(searchVO);
//	}
    
}
