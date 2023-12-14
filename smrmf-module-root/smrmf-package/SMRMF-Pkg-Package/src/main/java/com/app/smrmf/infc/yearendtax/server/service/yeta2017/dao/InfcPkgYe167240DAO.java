package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167240SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167240VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167240DAO.java
 * @Description : Ye167240 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe167240DAO")
public class InfcPkgYe167240DAO extends EgovAbstractDAO {

	/**
	 * YE167240?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167240VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167240(InfcPkgYe167240VO vo) throws Exception {
        return (String)insert("infcPkgYe167240DAO.insertYe167240_S", vo);
    }

    /**
	 * YE167240?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167240VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167240(InfcPkgYe167240VO vo) throws Exception {
        update("infcPkgYe167240DAO.updateYe167240_S", vo);
    }

    /**
	 * YE167240?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167240VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167240(InfcPkgYe167240VO vo) throws Exception {
        delete("infcPkgYe167240DAO.deleteYe167240_S", vo);
    }

    /**
	 * YE167240?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167240VO
	 * @return 조회?�� YE167240
	 * @exception Exception
	 */
    public InfcPkgYe167240VO selectYe167240(InfcPkgYe167240VO vo) throws Exception {
        return (InfcPkgYe167240VO) selectByPk("infcPkgYe167240DAO.selectYe167240_S", vo);
    }

    /**
	 * YE167240 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167240 목록
	 * @exception Exception
	 */
    public List<?> selectYe167240List(InfcPkgYe167240SrhVO searchVO) throws Exception {
        return list("infcPkgYe167240DAO.selectYe167240List_D", searchVO);
    }

    /**
	 * YE167240 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167240 �? �??��
	 * @exception
	 */
    public int selectYe167240ListTotCnt(InfcPkgYe167240SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe167240DAO.selectYe167240ListTotCnt_S", searchVO);
    }

}
