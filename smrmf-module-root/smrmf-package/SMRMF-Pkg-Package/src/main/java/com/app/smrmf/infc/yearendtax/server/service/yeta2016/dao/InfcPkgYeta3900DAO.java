package com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3900SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3900VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Yeta3900DAO.java
 * @Description : Yeta3900 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2016.01.18
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYeta3900DAO")
public class InfcPkgYeta3900DAO extends EgovAbstractDAO {

	/**
	 * YETA3900을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta3900VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String insertYeta3900(InfcPkgYeta3900VO vo) throws Exception {
        return (String)insert("infcPkgYeta3900DAO.insertYetaPrc3900_S", vo);
    }

    /**
	 * YETA3900을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta3900VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
    public void updateYeta3900(InfcPkgYeta3900VO vo) throws Exception {
        update("infcPkgYeta3900DAO.updateYetaPrc3900_S", vo);
    }

    /**
	 * YETA3900을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3900VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void deleteYeta3900(InfcPkgYeta3900VO vo) throws Exception {
        delete("yetav3900DAO.deleteYetaPrc3900_S", vo);
    }

    /**
	 * YETA3900을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta3900VO
	 * @return 조회한 YETA3900
	 * @exception Exception
	 */
    public InfcPkgYeta3900VO selectYeta3900(InfcPkgYeta3900VO vo) throws Exception {
        return (InfcPkgYeta3900VO) selectByPk("infcPkgYeta3900DAO.selectYetaPrc3900_S", vo);
    }

    /**
	 * YETA3900 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3900 목록
	 * @exception Exceptionpay
	 */
    public List<?> selectYeta3900List(InfcPkgYeta3900SrhVO searchVO) throws Exception {
        return list("infcPkgYeta3900DAO.selectYetaPrc3900List_D", searchVO);
    }

    /**
	 * YETA3900 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3900 총 갯수
	 * @exception
	 */
    public int selectYeta3900ListTotCnt(InfcPkgYeta3900SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYeta3900DAO.selectYetaPrc3900ListTotCnt_S", searchVO);
    }

}
