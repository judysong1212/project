package com.app.smrmf.sysm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.sysm.server.service.vo.SysIfBass0350SrhVO;
import com.app.smrmf.sysm.server.service.vo.SysIfBass0350VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass0350DAO.java
 * @Description : Bass0350 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.11.12
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("SysIfBass0350DAO")
public class SysIfBass0350DAO extends EgovAbstractDAO {

	/**
	 * BASS0350을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Bass0350VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertBass0350(SysIfBass0350VO vo) throws Exception {
        return (String)insert("sysIfBass0350DAO.insertBass0350_S", vo);
    }

    /**
	 * BASS0350을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Bass0350VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateBass0350(SysIfBass0350VO vo) throws Exception {
        update("sysIfBass0350DAO.updateBass0350_S", vo);
    }

    /**
	 * BASS0350을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Bass0350VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteBass0350(SysIfBass0350VO vo) throws Exception {
        delete("sysIfBass0350DAO.deleteBass0350_S", vo);
    }

    /**
	 * BASS0350을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Bass0350VO
	 * @return 조회한 BASS0350
	 * @exception Exception
	 */
    public SysIfBass0350VO selectBass0350(SysIfBass0350VO vo) throws Exception {
        return (SysIfBass0350VO) selectByPk("sysIfBass0350DAO.selectBass0350_S", vo);
    }

    /**
	 * BASS0350 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0350 목록
	 * @exception Exception
	 */
    public List<?> selectBass0350List(SysIfBass0350SrhVO searchVO) throws Exception {
        return list("sysIfBass0350DAO.selectBass0350List_D", searchVO);
    }

    /**
	 * BASS0350 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0350 총 갯수
	 * @exception
	 */
    public int selectBass0350ListTotCnt(SysIfBass0350SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sysIfBass0350DAO.selectBass0350ListTotCnt_S", searchVO);
    }
    

	@SuppressWarnings("rawtypes")
	public List selectSysmUsr0400ToBass0350List(SysIfBass0350SrhVO srhVo) throws Exception {
		return list("sysIfBass0350DAO.selectSysmUsr0400ToBass0350List_D", srhVo);
	}
	
	public int selectSysmUsr0400ToBass0350ListTotCnt(SysIfBass0350SrhVO srhVo) {
		return (Integer) getSqlMapClientTemplate().queryForObject("sysIfBass0350DAO.selectSysmUsr0400ToBass0350ListTotCnt_S", srhVo);
	}	
	
	 

}
