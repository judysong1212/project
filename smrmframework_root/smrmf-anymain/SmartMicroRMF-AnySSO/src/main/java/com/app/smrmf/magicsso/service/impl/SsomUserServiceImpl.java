package com.app.smrmf.magicsso.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.app.smrmf.infc.sysif.msfpackage.server.service.dao.SysIfSsomUserDAO;
import com.app.smrmf.magicsso.service.SsomUserService;
import com.app.smrmf.sysm.server.vo.system.SsomUserSrhVO;
import com.app.smrmf.sysm.server.vo.system.SsomUserVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

/**
 * @Class Name : SsomUserServiceImpl.java
 * @Description : SsomUser Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2018.01.24
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("SsomUserService")
public class SsomUserServiceImpl extends AbstractServiceImpl implements
        SsomUserService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(SsomUserServiceImpl.class);

    @Resource(name="SysIfSsomUserDAO")
    private SysIfSsomUserDAO ssomUserDAO;
    
    /** ID Generation */
    //@Resource(name="{egovSsomUserIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * SSOM_USER?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? SsomUserVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertSsomUser(SsomUserVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO ?��?�� ?��?���? ?��?��?�� ?��?�� ID ?��?��?��?��?�� ?��비스 ?��?��
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	ssomUserDAO.insertSsomUser(vo);
    	//TODO ?��?�� ?��?���? ?��보에 맞게 ?��?��    	
        return null;
    }

    /**
	 * SSOM_USER?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? SsomUserVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateSsomUser(SsomUserVO vo) throws Exception {
        ssomUserDAO.updateSsomUser(vo);
    }

    /**
	 * SSOM_USER?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? SsomUserVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteSsomUser(SsomUserVO vo) throws Exception {
        ssomUserDAO.deleteSsomUser(vo);
    }

    /**
	 * SSOM_USER?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? SsomUserVO
	 * @return 조회?�� SSOM_USER
	 * @exception Exception
	 */
    public SsomUserVO selectSsomUser(SsomUserVO vo) throws Exception {
        SsomUserVO resultVO = ssomUserDAO.selectSsomUser(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * SSOM_USER 목록?�� 조회?��?��.
	 * @param searchVO - 조회?�� ?��보�? ?���? VO
	 * @return SSOM_USER 목록
	 * @exception Exception
	 */
    public List<?> selectSsomUserList(SsomUserSrhVO searchVO) throws Exception {
        return ssomUserDAO.selectSsomUserList(searchVO);
    }

    /**
	 * SSOM_USER �? �??���? 조회?��?��.
	 * @param searchVO - 조회?�� ?��보�? ?���? VO
	 * @return SSOM_USER �? �??��
	 * @exception
	 */
    public int selectSsomUserListTotCnt(SsomUserSrhVO searchVO) {
		return ssomUserDAO.selectSsomUserListTotCnt(searchVO);
	}
    
}
