package com.app.smrmf.pkg.sche.sysm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.app.smrmf.pkg.sche.sysm.service.CmmanldsyinfService;
import com.app.smrmf.pkg.sche.sysm.service.vo.CmmanldsyinfSrhVO;
import com.app.smrmf.pkg.sche.sysm.service.vo.CmmanldsyinfVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

/**
 * @Class Name : CmmanldsyinfServiceImpl.java
 * @Description : Cmmanldsyinf Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2018.01.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("CmmanldsyinfService")
public class CmmanldsyinfServiceImpl extends AbstractServiceImpl implements
        CmmanldsyinfService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(CmmanldsyinfServiceImpl.class);

    @Resource(name="CmmanldsyinfDAO")
    private CmmanldsyinfDAO cmmanldsyinfDAO;
    
    /** ID Generation */
    //@Resource(name="{egovCmmanldsyinfIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * CMMANLDSYINF?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? CmmanldsyinfVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertCmmanldsyinf(CmmanldsyinfVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO ?��?�� ?��?���? ?��?��?�� ?��?�� ID ?��?��?��?��?�� ?��비스 ?��?��
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	cmmanldsyinfDAO.insertCmmanldsyinf(vo);
    	//TODO ?��?�� ?��?���? ?��보에 맞게 ?��?��    	
        return null;
    }

    /**
	 * CMMANLDSYINF?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? CmmanldsyinfVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateCmmanldsyinf(CmmanldsyinfVO vo) throws Exception {
        cmmanldsyinfDAO.updateCmmanldsyinf(vo);
    }

    /**
	 * CMMANLDSYINF?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? CmmanldsyinfVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteCmmanldsyinf(CmmanldsyinfVO vo) throws Exception {
        cmmanldsyinfDAO.deleteCmmanldsyinf(vo);
    }

    /**
	 * CMMANLDSYINF?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? CmmanldsyinfVO
	 * @return 조회?�� CMMANLDSYINF
	 * @exception Exception
	 */
    public CmmanldsyinfVO selectCmmanldsyinf(CmmanldsyinfVO vo) throws Exception {
        CmmanldsyinfVO resultVO = cmmanldsyinfDAO.selectCmmanldsyinf(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * CMMANLDSYINF 목록?�� 조회?��?��.
	 * @param searchVO - 조회?�� ?��보�? ?���? VO
	 * @return CMMANLDSYINF 목록
	 * @exception Exception
	 */
    public List<?> selectCmmanldsyinfList(CmmanldsyinfSrhVO searchVO) throws Exception {
        return cmmanldsyinfDAO.selectCmmanldsyinfList(searchVO);
    }

    /**
	 * CMMANLDSYINF �? �??���? 조회?��?��.
	 * @param searchVO - 조회?�� ?��보�? ?���? VO
	 * @return CMMANLDSYINF �? �??��
	 * @exception
	 */
    public int selectCmmanldsyinfListTotCnt(CmmanldsyinfSrhVO searchVO) {
		return cmmanldsyinfDAO.selectCmmanldsyinfListTotCnt(searchVO);
	}
    
}
