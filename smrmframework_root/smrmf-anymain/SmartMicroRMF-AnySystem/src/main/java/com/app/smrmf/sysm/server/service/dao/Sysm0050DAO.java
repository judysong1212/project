package com.app.smrmf.sysm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.sysm.server.vo.SysIfSysm0050SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0050VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Sysm0050DAO.java
 * @Description : Sysm0050 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2016.09.09
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Sysm0050DAO")
public class Sysm0050DAO extends EgovAbstractDAO {

	/**
	 * SYSM0050을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Sysm0050VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertSysm0050(SysIfSysm0050VO vo) throws Exception {
        return (String)insert("sysm0050DAO.insertSysm0050_S", vo);
    }

    /**
	 * SYSM0050을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Sysm0050VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateSysm0050(SysIfSysm0050VO vo) throws Exception {
        update("sysm0050DAO.updateSysm0050_S", vo);
    }

    /**
	 * SYSM0050을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Sysm0050VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteSysm0050(SysIfSysm0050VO vo) throws Exception {
        delete("sysm0050DAO.deleteSysm0050_S", vo);
    }

    /**
	 * SYSM0050을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Sysm0050VO
	 * @return 조회한 SYSM0050
	 * @exception Exception
	 */
    public SysIfSysm0050VO selectSysm0050(SysIfSysm0050VO vo) throws Exception {
        return (SysIfSysm0050VO) selectByPk("sysm0050DAO.selectSysm0050_S", vo);
    }

    /**
	 * SYSM0050 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYSM0050 목록
	 * @exception Exception
	 */
    public List selectSysm0050List(SysIfSysm0050SrhVO searchVO) throws Exception {
        return list("sysm0050DAO.selectSysm0050List_D", searchVO);
    }

    /**
	 * SYSM0050 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYSM0050 총 갯수
	 * @exception
	 */
    public int selectSysm0050ListTotCnt(SysIfSysm0050SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sysm0050DAO.selectSysm0050ListTotCnt_S", searchVO);
    }
    
    /**
	 * SYSM0050 상위사업장
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYSM0050 총 갯수
	 * @exception
	 */  
	@SuppressWarnings("rawtypes")
	public List getHhrkSysDpobCd() throws Exception{
		return list("sysm0050DAO.getHhrkSysDpobCd", null);
	}
	
    /**
	 * BASS0100 적용시스템
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0100 목록
	 * @exception Exception
	 */  
	@SuppressWarnings("rawtypes")
	public List getUseSysDivCd() throws Exception{
		return list("sysm0050DAO.selectBass0100sysDivCdList", null);
	}
	
    /**
	 * BASS0100 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYSM0050 총 갯수
	 * @exception
	 */
    public int selectSysmMtrToBass0100ListTotCnt(SysIfSysm0050SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sysm0050DAO.selectBass0100ListTotCnt_S", searchVO);
    }
	
	
	

}
