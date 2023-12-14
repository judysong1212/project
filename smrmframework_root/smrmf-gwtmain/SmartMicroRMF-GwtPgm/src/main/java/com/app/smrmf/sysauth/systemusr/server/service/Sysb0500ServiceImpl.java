package com.app.smrmf.sysauth.systemusr.server.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.sysauth.systemusr.client.service.Sysb0500Service;
import com.app.smrmf.sysauth.systemusr.shared.SysmUsrDaoConstants;
import com.app.smrmf.sysm.server.service.dao.Sysb0500DAO;

/**
 * @Class Name : Sysb0500ServiceImpl.java
 * @Description : Sysb0500 Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2017.11.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("Sysb0500Service")
public class Sysb0500ServiceImpl  extends AbstractCustomServiceImpl implements  SysmUsrDaoConstants , 
        Sysb0500Service {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(Sysb0500ServiceImpl.class);

    @Resource(name="Sysb0500DAO")
    private Sysb0500DAO sysb0500DAO;
    
    /** ID Generation */
    //@Resource(name="{egovSysb0500IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

//	/**
//	 * SYSB0500?�� ?��록한?��.
//	 * @param vo - ?��록할 ?��보�? ?���? Sysb0500VO
//	 * @return ?���? 결과
//	 * @exception Exception
//	 */
//    public String insertSysb0500(SysIfSysb0500VO vo) throws Exception {
//    	LOGGER.debug(vo.toString());
//    	
//    	/** ID Generation Service */
//    	//TODO ?��?�� ?��?���? ?��?��?�� ?��?�� ID ?��?��?��?��?�� ?��비스 ?��?��
//    	//String id = egovIdGnrService.getNextStringId();
//    	//vo.setId(id);
//    	LOGGER.debug(vo.toString());
//    	
//    	sysb0500DAO.insertSysb0500(vo);
//    	//TODO ?��?�� ?��?���? ?��보에 맞게 ?��?��    	
//        return null;
//    }
//
//    /**
//	 * SYSB0500?�� ?��?��?��?��.
//	 * @param vo - ?��?��?�� ?��보�? ?���? Sysb0500VO
//	 * @return void?��
//	 * @exception Exception
//	 */
//    public void updateSysb0500(SysIfSysb0500VO vo) throws Exception {
//        sysb0500DAO.updateSysb0500(vo);
//    }
//
//    /**
//	 * SYSB0500?�� ?��?��?��?��.
//	 * @param vo - ?��?��?�� ?��보�? ?���? Sysb0500VO
//	 * @return void?�� 
//	 * @exception Exception
//	 */
//    public void deleteSysb0500(SysIfSysb0500VO vo) throws Exception {
//        sysb0500DAO.deleteSysb0500(vo);
//    }
//
//    /**
//	 * SYSB0500?�� 조회?��?��.
//	 * @param vo - 조회?�� ?��보�? ?���? Sysb0500VO
//	 * @return 조회?�� SYSB0500
//	 * @exception Exception
//	 */
//    public SysIfSysb0500VO selectSysb0500(SysIfSysb0500VO vo) throws Exception {
//        SysIfSysb0500VO resultVO = sysb0500DAO.selectSysb0500(vo);
//        if (resultVO == null)
//            throw processException("info.nodata.msg");
//        return resultVO;
//    }
//
//    /**
//	 * SYSB0500 목록?�� 조회?��?��.
//	 * @param searchVO - 조회?�� ?��보�? ?���? VO
//	 * @return SYSB0500 목록
//	 * @exception Exception
//	 */
//    public List<?> selectSysb0500List(SysIfSysb0500SrhVO searchVO) throws Exception {
//        return sysb0500DAO.selectSysb0500List(searchVO);
//    }
//
//    /**
//	 * SYSB0500 �? �??���? 조회?��?��.
//	 * @param searchVO - 조회?�� ?��보�? ?���? VO
//	 * @return SYSB0500 �? �??��
//	 * @exception
//	 */
//    public int selectSysb0500ListTotCnt(SysIfSysb0500SrhVO searchVO) {
//		return sysb0500DAO.selectSysb0500ListTotCnt(searchVO);
//	}
    
}
