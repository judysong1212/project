package com.app.smrmf.sysauth.systemmtr.server.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.sysauth.systemmtr.client.service.SysmMtr0800Service;
import com.app.smrmf.sysauth.systemmtr.shared.SysmMtrDaoConstants;
import com.app.smrmf.sysm.server.service.dao.Sysm0800DAO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0800SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0800VO;

/**
 * @Class Name : Sysm0800ServiceImpl.java
 * @Description : Sysm0800 Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2016.09.09
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("Sysm0800Service")
public class SysmMtr0800ServiceImpl  extends AbstractCustomServiceImpl implements  SysmMtrDaoConstants , SysmMtr0800Service {
    
	private static final Logger logger = LoggerFactory.getLogger(SysmMtr0800ServiceImpl.class);
	private static final String calledClass = SysmMtr0800ServiceImpl.class.getName();
	 
    //private static final Logger LOGGER = LoggerFactory.getLogger(SysmMtr0800ServiceImpl.class);

    @Resource(name="Sysm0800DAO")
    private Sysm0800DAO sysm0800DAO;
    
    /** ID Generation */
    //@Resource(name="{egovSysm0800IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * SYSM0800을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Sysm0800VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertSysm0800(SysIfSysm0800VO vo) throws Exception {
    	//LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	//LOGGER.debug(vo.toString());
    	
    	sysm0800DAO.insertSysm0800(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * SYSM0800을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Sysm0800VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateSysm0800(SysIfSysm0800VO vo) throws Exception {
        sysm0800DAO.updateSysm0800(vo);
    }

    /**
	 * SYSM0800을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Sysm0800VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteSysm0800(SysIfSysm0800VO vo) throws Exception {
        sysm0800DAO.deleteSysm0800(vo);
    }

    /**
	 * SYSM0800을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Sysm0800VO
	 * @return 조회한 SYSM0800
	 * @exception Exception
	 */
    public SysIfSysm0800VO selectSysm0800(SysIfSysm0800VO vo) throws Exception {
        SysIfSysm0800VO resultVO = sysm0800DAO.selectSysm0800(vo);
       // if (resultVO == null)
       //     throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * SYSM0800 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SYSM0800 목록
	 * @exception Exception
	 */
    public List<?> selectSysm0800List(SysIfSysm0800SrhVO searchVO) throws Exception {
        return sysm0800DAO.selectSysm0800List(searchVO);
    }

    /**
	 * SYSM0800 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SYSM0800 총 갯수
	 * @exception
	 */
    public int selectSysm0800ListTotCnt(SysIfSysm0800SrhVO searchVO) {
		return sysm0800DAO.selectSysm0800ListTotCnt(searchVO);
	}
    
}
