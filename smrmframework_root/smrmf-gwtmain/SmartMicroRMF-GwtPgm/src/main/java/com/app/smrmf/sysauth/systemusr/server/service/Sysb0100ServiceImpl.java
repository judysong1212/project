package com.app.smrmf.sysauth.systemusr.server.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.sysauth.systemusr.client.service.Sysb0100Service;
import com.app.smrmf.sysauth.systemusr.shared.SysmUsrDaoConstants;
import com.app.smrmf.sysm.server.service.dao.Sysb0100DAO;

/**
 * @Class Name : Sysb0100ServiceImpl.java
 * @Description : Sysb0100 Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("Sysb0100Service")
public class Sysb0100ServiceImpl  extends AbstractCustomServiceImpl implements  SysmUsrDaoConstants ,
        Sysb0100Service {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(Sysb0100ServiceImpl.class);

    @Resource(name="Sysb0100DAO")
    private Sysb0100DAO sysb0100DAO;
    
//    /** ID Generation */
//    //@Resource(name="{egovSysb0100IdGnrService}")    
//    //private EgovIdGnrService egovIdGnrService;
//
//	/**
//	 * SYSB0100?�� ?��록한?��.
//	 * @param vo - ?��록할 ?��보�? ?���? Sysb0100VO
//	 * @return ?���? 결과
//	 * @exception Exception
//	 */
//    public String insertSysb0100(SysIfSysb0100VO vo) throws Exception {
//    	LOGGER.debug(vo.toString());
//    	
//    	/** ID Generation Service */
//    	//TODO ?��?�� ?��?���? ?��?��?�� ?��?�� ID ?��?��?��?��?�� ?��비스 ?��?��
//    	//String id = egovIdGnrService.getNextStringId();
//    	//vo.setId(id);
//    	LOGGER.debug(vo.toString());
//    	
//    	sysb0100DAO.insertSysb0100(vo);
//    	//TODO ?��?�� ?��?���? ?��보에 맞게 ?��?��    	
//        return null;
//    }
//
//    /**
//	 * SYSB0100?�� ?��?��?��?��.
//	 * @param vo - ?��?��?�� ?��보�? ?���? Sysb0100VO
//	 * @return void?��
//	 * @exception Exception
//	 */
//    public void updateSysb0100(SysIfSysb0100VO vo) throws Exception {
//        sysb0100DAO.updateSysb0100(vo);
//    }
//
//    /**
//	 * SYSB0100?�� ?��?��?��?��.
//	 * @param vo - ?��?��?�� ?��보�? ?���? Sysb0100VO
//	 * @return void?�� 
//	 * @exception Exception
//	 */
//    public void deleteSysb0100(SysIfSysb0100VO vo) throws Exception {
//        sysb0100DAO.deleteSysb0100(vo);
//    }
//
//    /**
//	 * SYSB0100?�� 조회?��?��.
//	 * @param vo - 조회?�� ?��보�? ?���? Sysb0100VO
//	 * @return 조회?�� SYSB0100
//	 * @exception Exception
//	 */
//    public SysIfSysb0100VO selectSysb0100(SysIfSysb0100VO vo) throws Exception {
//        SysIfSysb0100VO resultVO = sysb0100DAO.selectSysb0100(vo);
//        if (resultVO == null)
//            throw processException("info.nodata.msg");
//        return resultVO;
//    }
//
//    /**
//	 * SYSB0100 목록?�� 조회?��?��.
//	 * @param searchVO - 조회?�� ?��보�? ?���? VO
//	 * @return SYSB0100 목록
//	 * @exception Exception
//	 */
//    public List<?> selectSysb0100List(Sysb0100DefaultVO searchVO) throws Exception {
//        return sysb0100DAO.selectSysb0100List(searchVO);
//    }
//
//    /**
//	 * SYSB0100 �? �??���? 조회?��?��.
//	 * @param searchVO - 조회?�� ?��보�? ?���? VO
//	 * @return SYSB0100 �? �??��
//	 * @exception
//	 */
//    public int selectSysb0100ListTotCnt(Sysb0100DefaultVO searchVO) {
//		return sysb0100DAO.selectSysb0100ListTotCnt(searchVO);
//	}
    
}
