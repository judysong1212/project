package com.app.smrmf.pkg.sche.sysm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.app.smrmf.pkg.sche.sysm.service.CmmanldlastwrkService;
import com.app.smrmf.pkg.sche.sysm.service.vo.CmmanldlastwrkSrhVO;
import com.app.smrmf.pkg.sche.sysm.service.vo.CmmanldlastwrkVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

/**
 * @Class Name : CmmanldlastwrkServiceImpl.java
 * @Description : Cmmanldlastwrk Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2018.0123
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("CmmanldlastwrkService")
public class CmmanldlastwrkServiceImpl extends AbstractServiceImpl implements
        CmmanldlastwrkService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(CmmanldlastwrkServiceImpl.class);

    @Resource(name="CmmanldlastwrkDAO")
    private CmmanldlastwrkDAO cmmanldlastwrkDAO;
    
    /** ID Generation */
    //@Resource(name="{egovCmmanldlastwrkIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * CMMANLDLASTWRK?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? CmmanldlastwrkVO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertCmmanldlastwrk(CmmanldlastwrkVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO ?��?�� ?��?���? ?��?��?�� ?��?�� ID ?��?��?��?��?�� ?��비스 ?��?��
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	cmmanldlastwrkDAO.insertCmmanldlastwrk(vo);
    	//TODO ?��?�� ?��?���? ?��보에 맞게 ?��?��    	
        return null;
    }

    /**
	 * CMMANLDLASTWRK?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? CmmanldlastwrkVO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateCmmanldlastwrk(CmmanldlastwrkVO vo) throws Exception {
        cmmanldlastwrkDAO.updateCmmanldlastwrk(vo);
    }

    /**
	 * CMMANLDLASTWRK?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? CmmanldlastwrkVO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteCmmanldlastwrk(CmmanldlastwrkVO vo) throws Exception {
        cmmanldlastwrkDAO.deleteCmmanldlastwrk(vo);
    }

    /**
	 * CMMANLDLASTWRK?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? CmmanldlastwrkVO
	 * @return 조회?�� CMMANLDLASTWRK
	 * @exception Exception
	 */
    public CmmanldlastwrkVO selectCmmanldlastwrk(CmmanldlastwrkVO vo) throws Exception {
        CmmanldlastwrkVO resultVO = cmmanldlastwrkDAO.selectCmmanldlastwrk(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * CMMANLDLASTWRK 목록?�� 조회?��?��.
	 * @param searchVO - 조회?�� ?��보�? ?���? VO
	 * @return CMMANLDLASTWRK 목록
	 * @exception Exception
	 */
    public List<?> selectCmmanldlastwrkList(CmmanldlastwrkSrhVO searchVO) throws Exception {
        return cmmanldlastwrkDAO.selectCmmanldlastwrkList(searchVO);
    }

    /**
	 * CMMANLDLASTWRK �? �??���? 조회?��?��.
	 * @param searchVO - 조회?�� ?��보�? ?���? VO
	 * @return CMMANLDLASTWRK �? �??��
	 * @exception
	 */
    public int selectCmmanldlastwrkListTotCnt(CmmanldlastwrkSrhVO searchVO) {
		return cmmanldlastwrkDAO.selectCmmanldlastwrkListTotCnt(searchVO);
	}
    
}
