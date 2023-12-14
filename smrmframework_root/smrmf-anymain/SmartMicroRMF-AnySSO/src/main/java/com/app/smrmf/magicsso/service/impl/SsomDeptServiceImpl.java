package com.app.smrmf.magicsso.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.app.smrmf.infc.sysif.msfpackage.server.service.dao.SysIfSsomDeptDAO;
import com.app.smrmf.magicsso.service.SsomDeptService;
import com.app.smrmf.sysm.server.vo.system.SsomDeptSrhVO;
import com.app.smrmf.sysm.server.vo.system.SsomDeptVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

/**
 * @Class Name : SsomDeptServiceImpl.java
 * @Description : SsomDept Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2018.01.24
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("SsomDeptService")
public class SsomDeptServiceImpl extends AbstractServiceImpl implements
        SsomDeptService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(SsomDeptServiceImpl.class);

    @Resource(name="SysIfSsomDeptDAO")
    private SysIfSsomDeptDAO ssomDeptDAO;
    
    /** ID Generation */
    //@Resource(name="{egovSsomDeptIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * SSOM_DEPT?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? SsomDeptVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertSsomDept(SsomDeptVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO ?��?�� ?��?���? ?��?��?�� ?��?�� ID ?��?��?��?��?�� ?��비스 ?��?��
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	ssomDeptDAO.insertSsomDept(vo);
    	//TODO ?��?�� ?��?���? ?��보에 맞게 ?��?��    	
        return null;
    }

    /**
	 * SSOM_DEPT?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? SsomDeptVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateSsomDept(SsomDeptVO vo) throws Exception {
        ssomDeptDAO.updateSsomDept(vo);
    }

    /**
	 * SSOM_DEPT?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? SsomDeptVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteSsomDept(SsomDeptVO vo) throws Exception {
        ssomDeptDAO.deleteSsomDept(vo);
    }

    /**
	 * SSOM_DEPT?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? SsomDeptVO
	 * @return 조회?�� SSOM_DEPT
	 * @exception Exception
	 */
    public SsomDeptVO selectSsomDept(SsomDeptVO vo) throws Exception {
        SsomDeptVO resultVO = ssomDeptDAO.selectSsomDept(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * SSOM_DEPT 목록?�� 조회?��?��.
	 * @param searchVO - 조회?�� ?��보�? ?���? VO
	 * @return SSOM_DEPT 목록
	 * @exception Exception
	 */
    public List<?> selectSsomDeptList(SsomDeptSrhVO searchVO) throws Exception {
        return ssomDeptDAO.selectSsomDeptList(searchVO);
    }

    /**
	 * SSOM_DEPT �? �??���? 조회?��?��.
	 * @param searchVO - 조회?�� ?��보�? ?���? VO
	 * @return SSOM_DEPT �? �??��
	 * @exception
	 */
    public int selectSsomDeptListTotCnt(SsomDeptSrhVO searchVO) {
		return ssomDeptDAO.selectSsomDeptListTotCnt(searchVO);
	}
    
}
