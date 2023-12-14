package com.app.smrmf.pkg.sche.sysm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.app.smrmf.pkg.sche.sysm.service.CmmanldsydtlService;
import com.app.smrmf.pkg.sche.sysm.service.vo.CmmanldsydtlSrhVO;
import com.app.smrmf.pkg.sche.sysm.service.vo.CmmanldsydtlVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

/**
 * @Class Name : CmmanldsydtlServiceImpl.java
 * @Description : Cmmanldsydtl Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2018.01.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("CmmanldsydtlService")
public class CmmanldsydtlServiceImpl extends AbstractServiceImpl implements
        CmmanldsydtlService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(CmmanldsydtlServiceImpl.class);

    @Resource(name="CmmanldsydtlDAO")
    private CmmanldsydtlDAO cmmanldsydtlDAO;
    
    /** ID Generation */
    //@Resource(name="{egovCmmanldsydtlIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * CMMANLDSYDTL?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? CmmanldsydtlVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertCmmanldsydtl(CmmanldsydtlVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO ?��?�� ?��?���? ?��?��?�� ?��?�� ID ?��?��?��?��?�� ?��비스 ?��?��
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	cmmanldsydtlDAO.insertCmmanldsydtl(vo);
    	//TODO ?��?�� ?��?���? ?��보에 맞게 ?��?��    	
        return null;
    }

    /**
	 * CMMANLDSYDTL?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? CmmanldsydtlVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateCmmanldsydtl(CmmanldsydtlVO vo) throws Exception {
        cmmanldsydtlDAO.updateCmmanldsydtl(vo);
    }

    /**
	 * CMMANLDSYDTL?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? CmmanldsydtlVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteCmmanldsydtl(CmmanldsydtlVO vo) throws Exception {
        cmmanldsydtlDAO.deleteCmmanldsydtl(vo);
    }

    /**
	 * CMMANLDSYDTL?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? CmmanldsydtlVO
	 * @return 조회?�� CMMANLDSYDTL
	 * @exception Exception
	 */
    public CmmanldsydtlVO selectCmmanldsydtl(CmmanldsydtlVO vo) throws Exception {
        CmmanldsydtlVO resultVO = cmmanldsydtlDAO.selectCmmanldsydtl(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * CMMANLDSYDTL 목록?�� 조회?��?��.
	 * @param searchVO - 조회?�� ?��보�? ?���? VO
	 * @return CMMANLDSYDTL 목록
	 * @exception Exception
	 */
    public List<?> selectCmmanldsydtlList(CmmanldsydtlSrhVO searchVO) throws Exception {
        return cmmanldsydtlDAO.selectCmmanldsydtlList(searchVO);
    }

    /**
	 * CMMANLDSYDTL �? �??���? 조회?��?��.
	 * @param searchVO - 조회?�� ?��보�? ?���? VO
	 * @return CMMANLDSYDTL �? �??��
	 * @exception
	 */
    public int selectCmmanldsydtlListTotCnt(CmmanldsydtlSrhVO searchVO) {
		return cmmanldsydtlDAO.selectCmmanldsydtlListTotCnt(searchVO);
	}
    
}
