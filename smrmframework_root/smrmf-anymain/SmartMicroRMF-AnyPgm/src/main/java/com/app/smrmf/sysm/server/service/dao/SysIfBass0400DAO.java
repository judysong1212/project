package com.app.smrmf.sysm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.sysm.server.service.vo.SysIfBass0400SrhVO;
import com.app.smrmf.sysm.server.service.vo.SysIfBass0400VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass0400DAO.java
 * @Description : Bass0400 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.11.12
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("SysIfBass0400DAO")
public class SysIfBass0400DAO extends EgovAbstractDAO {

	/**
	 * BASS0400을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Bass0400VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertBass0400(SysIfBass0400VO vo) throws Exception {
        return (String)insert("sysIfBass0400DAO.insertBass0400_S", vo);
    }

    /**
	 * BASS0400을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Bass0400VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateBass0400(SysIfBass0400VO vo) throws Exception {
        update("sysIfBass0400DAO.updateBass0400_S", vo);
    }

    /**
	 * BASS0400을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Bass0400VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteBass0400(SysIfBass0400VO vo) throws Exception {
        delete("sysIfBass0400DAO.deleteBass0400_S", vo);
    }

    /**
	 * BASS0400을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Bass0400VO
	 * @return 조회한 BASS0400
	 * @exception Exception
	 */
    public SysIfBass0400VO selectBass0400(SysIfBass0400VO vo) throws Exception {
        return (SysIfBass0400VO) selectByPk("sysIfBass0400DAO.selectBass0400_S", vo);
    }

    /**
	 * BASS0400 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0400 목록
	 * @exception Exception
	 */
    public List<?> selectBass0400List(SysIfBass0400SrhVO searchVO) throws Exception {
        return list("sysIfBass0400DAO.selectBass0400List_D", searchVO);
    }

    /**
	 * BASS0400 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0400 총 갯수
	 * @exception
	 */
    public int selectBass0400ListTotCnt(SysIfBass0400SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sysIfBass0400DAO.selectBass0400ListTotCnt_S", searchVO);
    }
    

	@SuppressWarnings("rawtypes")
	public List selectSysmUsr0400ToBass0400List(SysIfBass0400SrhVO Srhvo) throws Exception {
		return list("sysIfBass0400DAO.selectSysmUsr0400ToBass0400List", Srhvo);
	}	
	public int selectSysmUsr0400ToBass0400ListTotCnt(SysIfBass0400SrhVO Srhvo) {
		return (Integer) getSqlMapClientTemplate().queryForObject("sysIfBass0400DAO.selectSysmUsr0400ToBass0400ListTotCnt", Srhvo);
	}
	
	@SuppressWarnings("rawtypes")
	public List selectSysmUsr0400List_Right_Up(SysIfBass0400SrhVO Srhvo) throws Exception {
		return list("sysIfBass0400DAO.selectBass0450List", Srhvo);
	}   

}
