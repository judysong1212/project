package com.app.smrmf.infc.personal.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.personal.server.vo.InfcPkgPsnl0130SrhVO;
import com.app.smrmf.infc.personal.server.vo.InfcPkgPsnl0130VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Psnl0130DAO.java
 * @Description : Psnl0130 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014/07/31
 * @version 1.0
 * @param <Psnl0130DTO>
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPsnl0130DAO")
public class InfcPkgPsnl0130DAO<Psnl0130DTO> extends EgovAbstractDAO {

	/**
	 * PSNL0130을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Psnl0130VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPsnl0130(InfcPkgPsnl0130VO vo) throws Exception {
        return (String)insert("infcPkgPsnl0130DAO.insertPsnl0130_S", vo);
    }

    /**
	 * PSNL0130을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Psnl0130VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePsnl0130(InfcPkgPsnl0130VO vo) throws Exception {
        update("infcPkgPsnl0130DAO.updatePsnl0130_S", vo);
    }

    /**
	 * PSNL0130을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Psnl0130VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePsnl0130(InfcPkgPsnl0130VO vo) throws Exception {
        delete("infcPkgPsnl0130DAO.deletePsnl0130_S", vo);
    }

    /**
	 * PSNL0130을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Psnl0130VO
	 * @return 조회한 PSNL0130
	 * @exception Exception
	 */
    public InfcPkgPsnl0130VO selectPsnl0130(InfcPkgPsnl0130VO vo) throws Exception {
        return (InfcPkgPsnl0130VO) selectByPk("infcPkgPsnl0130DAO.selectPsnl0130_S", vo);
    }
    
	public int selectPayr1700ToPsnl0130_S(InfcPkgPsnl0130VO vo) throws Exception{
		return (Integer)getSqlMapClient().queryForObject("infcPkgPsnl0130DAO.selectPayr1700ToPsnl0130_S", vo);
	}

    /**
	 * PSNL0130 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PSNL0130 목록
	 * @exception Exception
	 */
    public List selectPsnl0130List(InfcPkgPsnl0130SrhVO searchVO) throws Exception {
        return list("infcPkgPsnl0130DAO.selectPsnl0130List_D", searchVO);
    }

    /** 
	 * PSNL0130 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PSNL0130 총 갯수
	 * @exception
	 */
	public int selectPsnl0130ListTotCnt(InfcPkgPsnl0130SrhVO searchVO) {
		return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPsnl0130DAO.selectPsnl0130ListTotCnt_S", searchVO);
	}
	
	/**
	 * Payr1700 화면 엑셀저장 PSNL0130 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PSNL0130 목록
	 * @exception Exception
	 */
	public List selectXlsPayr1700List(InfcPkgPsnl0130SrhVO searchVO) throws Exception {
		return list("infcPkgPsnl0130DAO.selectXlsPayr1700List", searchVO);
	}
	
	/**************************** 엑셀 업로드 ****************************/
	/**
	 * PSNL0130을 삭제한다.(엑셀)
	 * @param vo - 삭제할 정보가 담긴 InfcPsnl0130VO
	 * @return void형 
	 * @exception Exception
	 */
	public void deleteXlsPayr1700(InfcPkgPsnl0130VO vo) throws Exception {
		delete("infcPkgPsnl0130DAO.deleteXlsPayr1700", vo);
	}
	
	/**
	 * PSNL0130을 등록한다.(엑셀)
	 * @param vo - 등록할 정보가 담긴 InfcPsnl0130VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	public String insertXlsPayr1700(InfcPkgPsnl0130VO vo) throws Exception {
		return (String)insert("infcPkgPsnl0130DAO.insertXlsPayr1700", vo);
	}
	/**************************** 엑셀 업로드 ****************************/
}