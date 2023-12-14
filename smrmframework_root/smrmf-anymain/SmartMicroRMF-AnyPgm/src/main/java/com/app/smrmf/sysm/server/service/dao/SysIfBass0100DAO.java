package com.app.smrmf.sysm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.sysm.server.service.vo.SysIfBass0100SrhVO;
import com.app.smrmf.sysm.server.service.vo.SysIfBass0100VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass0100DAO.java
 * @Description : Bass0100 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("SysIfBass0100DAO")
public class SysIfBass0100DAO extends EgovAbstractDAO {
	
	@SuppressWarnings("rawtypes")
	public List getParentDpobCd() throws Exception{
		return list("sysIfBass0100DAO.getParentDpobCd", null);
	}
	
	
	
	// 시스템 사업장 코드를 가져옴
	@SuppressWarnings("rawtypes")
	public List getSysDpobCd() throws Exception{
		return list("sysIfBass0100DAO.getSysDpobCd", null);
	}
	
	@SuppressWarnings("rawtypes")
	public List getParentRetryCllnDebrDivCd() throws Exception{
		return list("sysIfBass0100DAO.selectBass0100RetryCllnDebrDivCdList", null);
	}

	// 사용 시스템 구분 코드를 가져옴
	@SuppressWarnings("rawtypes")
	public List selectBass0100sysDivCdList() throws Exception{
		return list("sysIfBass0100DAO.getUseSysDivCd", null);
	}
	/**		
	@Transactional
	public int saveBass0100(InfcSysIfBass0100VO vo) throws Exception{
		return update("sysIfBass0100DAO.saveBass0100", vo);
	}
	 */	
	
	@Transactional
	public int saveBass0100(SysIfBass0100VO vo) throws Exception{
		return update("sysIfBass0100DAO.saveBass0100", vo);
	}
	/**
	 * BASS0100을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Bass0100VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	@Transactional
    public String insertBass0100(SysIfBass0100VO vo) throws Exception {
        return (String)insert("sysIfBass0100DAO.insertBass0100_S", vo);
    }

    /**
	 * BASS0100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Bass0100VO
	 * @return void형
	 * @exception Exception
	 */
	@Transactional
    public void updateBass0100(SysIfBass0100VO vo) throws Exception {
        update("sysIfBass0100DAO.updateBass0100_S", vo);
    }

    /**
	 * BASS0100을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Bass0100VO
	 * @return void형 
	 * @exception Exception
	 */
	/**
	@Transactional
    public int deleteBass0100(InfcSysIfBass0100VO vo) throws Exception {
        return delete("sysIfBass0100DAO.deleteBass0100_S", vo);
    }
	*/
	@Transactional
    public int deleteBass0100(SysIfBass0100VO vo) throws Exception {
        return delete("sysIfBass0100DAO.deleteBass0100_S", vo);
    }

    /**
	 * BASS0100을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Bass0100VO
	 * @return 조회한 BASS0100
	 * @exception Exception
	 */
    public SysIfBass0100VO selectBass0100(SysIfBass0100VO vo) throws Exception {
        return (SysIfBass0100VO) selectByPk("sysIfBass0100DAO.selectBass0100_S", vo);
    }

    /**
	 * BASS0100 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0100 목록
	 * @exception Exception
	 */
    public List selectBass0100List(SysIfBass0100SrhVO searchVO) throws Exception {
        return list("sysIfBass0100DAO.selectBass0100List_D", searchVO);
    }

    /**
	 * BASS0100 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0100 총 갯수
	 * @exception
	 */
    public int selectBass0100ListTotCnt(SysIfBass0100SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sysIfBass0100DAO.selectBass0100ListTotCnt_S", searchVO);
    }

}
