package com.app.smrmf.infc.retirement.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt3100SrhVO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt3100VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Remt3100DAO.java
 * @Description : Remt3100 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgRemt3100DAO")
public class InfcPkgRemt3100DAO extends EgovAbstractDAO {

	/**
	 * REMT3100을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Remt3100VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertRemt3100(InfcPkgRemt3100VO vo) throws Exception {
        return (String)insert("infcPkgRemt3100DAO.insertRemt3100_S", vo);
    }

    /**
	 * REMT3100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Remt3100VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRemt3100(InfcPkgRemt3100VO vo) throws Exception {
        update("infcPkgRemt3100DAO.updateRemt3100_S", vo);
    }
    
    public void updateRemt3100Remt2000Data(InfcPkgRemt3100VO vo) throws Exception {
        update("infcPkgRemt3100DAO.updateRemt3100Remt2000Data_S", vo);
    }
    

    /**
	 * REMT3100을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Remt3100VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRemt3100(InfcPkgRemt3100VO vo) throws Exception {
        delete("infcPkgRemt3100DAO.deleteRemt3100_S", vo);
    }

    /**
	 * REMT3100을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Remt3100VO
	 * @return 조회한 REMT3100
	 * @exception Exception
	 */
    public InfcPkgRemt3100VO selectRemt3100(InfcPkgRemt3100VO vo) throws Exception {
        return (InfcPkgRemt3100VO) selectByPk("infcPkgRemt3100DAO.selectRemt3100_S", vo);
    }
    
    public InfcPkgRemt3100VO selectRemt3100EepnYrIcm(InfcPkgRemt3100VO vo) throws Exception {
        return (InfcPkgRemt3100VO) selectByPk("infcPkgRemt3100DAO.selectRemt3100EepnYrIcm_S", vo);
    }
     
    

    /**
	 * REMT3100 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return REMT3100 목록
	 * @exception Exception
	 */
    public List<?> selectRemt3100List(InfcPkgRemt3100SrhVO searchVO) throws Exception {
        return list("infcPkgRemt3100DAO.selectRemt3100List_D", searchVO);
    }

    /**
	 * REMT3100 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return REMT3100 총 갯수
	 * @exception
	 */
    public int selectRemt3100ListTotCnt(InfcPkgRemt3100SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgRemt3100DAO.selectRemt3100ListTotCnt_S", searchVO);
    }

}
