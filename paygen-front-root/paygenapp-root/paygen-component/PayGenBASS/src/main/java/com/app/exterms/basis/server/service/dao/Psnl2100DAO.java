package com.app.exterms.basis.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.basis.server.vo.Psnl2100SrhVO;
import com.app.exterms.basis.server.vo.Psnl2100VO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Psnl2100DAO.java
 * @Description : Psnl2100 DAO Class
 * @Modification Information
 *
 * @author 다은
 * @since 2015.10.13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Psnl2100DAO")
public class Psnl2100DAO extends EgovAbstractDAO {

	/**
	 * PSNL2100을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Psnl2100VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertPsnl2100(Psnl2100VO vo) throws Exception {
        return (String)insert("psnl2100DAO.insertPsnl2100_S", vo);
    }

    /**
	 * PSNL2100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Psnl2100VO
	 * @return void형
	 * @exception Exception
	 */
    public void updatePsnl2100(Psnl2100VO vo) throws Exception {
        update("psnl2100DAO.updatePsnl2100_S", vo);
    }

    /**
	 * PSNL2100을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Psnl2100VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deletePsnl2100(Psnl2100VO vo) throws Exception {
        delete("psnl2100DAO.deletePsnl2100_S", vo);
    }

    /**
	 * PSNL2100을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Psnl2100VO
	 * @return 조회한 PSNL2100
	 * @exception Exception
	 */
    public Psnl2100VO selectPsnl2100(Psnl2100VO vo) throws Exception {
        return (Psnl2100VO) selectByPk("psnl2100DAO.selectPsnl2100_S", vo);
    }

    /**
	 * PSNL2100 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PSNL2100 목록
	 * @exception Exception
	 */
    public List selectPsnl2100List(Psnl2100SrhVO searchVO) throws Exception {
        return list("psnl2100DAO.selectPsnl2100List_D", searchVO);
    }

    /**
	 * PSNL2100 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PSNL2100 총 갯수
	 * @exception
	 */
    public int selectPsnl2100ListTotCnt(Psnl2100SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("psnl2100DAO.selectPsnl2100ListTotCnt_S", searchVO);
    }
    
    /**
	 * PSNL2100 Excel 데이터를 입력한다.
	 * @param vo - 등록할 정보가 담긴 Psnl2100VO
	 * @return PSNL2100 Excel 등록
	 * @exception
	 */
	public String insertXlsPsnl2100(Psnl2100VO psnl2100vo)throws Exception {
		
		return (String)insert("psnl2100DAO.insertXlsPsnl2100_S",psnl2100vo);
	}
	
	/**
	 * PSNL2100을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Psnl2100VO
	 * @return 조회한 PSNL2100
	 * @exception Exception
	 */
    public List selectCopyPsnl2100_D(Psnl2100VO vo) throws MSFException {
        return list("psnl2100DAO.selectCopyPsnl2100_D", vo);
    }
	
    public String insertCopyPsnl2100(Psnl2100VO psnl2100vo)throws Exception {
		
		return (String)insert("psnl2100DAO.insertCopyPsnl2100_S",psnl2100vo);
	}

	public void updateCopyPsnl2100(Psnl2100VO psnl2100vo)throws Exception {
		
		update("psnl2100DAO.updateCopyPsnl2100_S",psnl2100vo);
	}

	/**
	 * PSNL2100 AND BASS0310 JOIN 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PSNL2100 AND BASS0310 JOIN 목록
	 * @exception Exception
	 */
	public List selectBass031001ToPsnl2100List(Psnl2100SrhVO psnl2100SrhVo) {
		
		return list("psnl2100DAO.selectBass031001ToPsnl2100List_D", psnl2100SrhVo);
	}
	
	/**
	 * PSNL2100 AND BASS0310 JOIN 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PSNL2100 AND BASS0310 JOIN 총 갯수
	 * @exception
	 */
	public int selectBass031001ToPsnl2100ListTotCnt(Psnl2100SrhVO psnl2100SrhVo) {
		
		return (Integer)getSqlMapClientTemplate().queryForObject("psnl2100DAO.selectBass031001ToPsnl2100ListTotCnt_S", psnl2100SrhVo);
	}	

}
