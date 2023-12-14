package com.app.exterms.retirement.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.retirement.server.vo.Remt9000SrhVO;
import com.app.exterms.retirement.server.vo.Remt9000VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Remt9000DAO.java
 * @Description : Remt9000 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.10.17
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Remt9000DAO")
public class Remt9000DAO extends EgovAbstractDAO {

	/**
	 * REMT9000을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Remt9000VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertRemt9000(Remt9000VO vo) throws Exception {
        return (String)insert("remt9000DAO.insertRemt9000_S", vo);
    }

    /**
	 * REMT9000을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Remt9000VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateRemt9000(Remt9000VO vo) throws Exception {
        update("remt9000DAO.updateRemt9000_S", vo);
    }

    /**
	 * REMT9000을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Remt9000VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteRemt9000(Remt9000VO vo) throws Exception {
        delete("remt9000DAO.deleteRemt9000_S", vo);
    }

    /**
	 * REMT9000을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Remt9000VO
	 * @return 조회한 REMT9000
	 * @exception Exception
	 */
    public Remt9000VO selectRemt9000(Remt9000VO vo) throws Exception {
        return (Remt9000VO) selectByPk("remt9000DAO.selectRemt9000_S", vo);
    }

    /**
	 * REMT9000 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return REMT9000 목록
	 * @exception Exception
	 */
    public List selectRemt9000List(Remt9000SrhVO searchVO) throws Exception {
        return list("remt9000DAO.selectRemt9000List_D", searchVO);
    }

    /**
	 * REMT9000 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return REMT9000 총 갯수
	 * @exception
	 */
    public int selectRemt9000ListTotCnt(Remt9000SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("remt9000DAO.selectRemt9000ListTotCnt_S", searchVO);
    }
    
    /**
	 * REMT9000 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return REMT9000 목록
	 * @exception Exception
	 */
	public List selectXlsRemt0400List(Remt9000SrhVO remt9000SrhVo)throws Exception {
		return list("remt9000DAO.selectXlsRemt0400List_D", remt9000SrhVo);
	}

	public int deleteXlsRemt0400(Remt9000VO remt9000vo)throws Exception {
		
		return delete("remt9000DAO.deleteXlsRemt0400_S",remt9000vo);
	}

	public String insertXlsRemt0400(Remt9000VO remt9000vo)throws Exception {
		
		return (String)insert("remt9000DAO.insertXlsRemt0400_S",remt9000vo);
	}
	
	/**
	 * PSNL0100 목록을 조회한다. 인사정보를 가져온다.
	 * @param searcVO - 조회할 정보가 담긴 searcVO
	 * @return PYYT0302 목록
	 * @exception Exception
	 */
    public List selectRemt0400ToPsnl0100List(Remt9000VO remt9000vo) throws Exception {
        return list("remt9000DAO.selectPsnl0100", remt9000vo);
    }



}
