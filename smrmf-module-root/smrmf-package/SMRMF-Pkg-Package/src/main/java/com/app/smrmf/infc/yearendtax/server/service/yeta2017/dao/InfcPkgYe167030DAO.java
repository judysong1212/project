package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167030SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167030VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167030DAO.java
 * @Description : Ye167030 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe167030DAO")
public class InfcPkgYe167030DAO extends EgovAbstractDAO {

	/**
	 * YE167030?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167030VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167030(InfcPkgYe167030VO vo) throws Exception {
        return (String)insert("infcPkgYe167030DAO.insertYe167030_S", vo);
    }

    /**
	 * YE167030?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167030VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167030(InfcPkgYe167030VO vo) throws Exception {
        update("infcPkgYe167030DAO.updateYe167030_S", vo);
    }

    /**
	 * YE167030?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167030VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167030(InfcPkgYe167030VO vo) throws Exception {
        delete("infcPkgYe167030DAO.deleteYe167030_S", vo);
    }

    /**
	 * YE167030?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167030VO
	 * @return 조회?�� YE167030
	 * @exception Exception
	 */
    public InfcPkgYe167030VO selectYe167030(InfcPkgYe167030VO vo) throws Exception {
        return (InfcPkgYe167030VO) selectByPk("infcPkgYe167030DAO.selectYe167030_S", vo);
    }

    /**
	 * YE167030 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167030 목록
	 * @exception Exception
	 */
    public List<?> selectYe167030List(InfcPkgYe167030SrhVO searchVO) throws Exception {
        return list("infcPkgYe167030DAO.selectYe167030List_D", searchVO);
    }

    /**
	 * YE167030 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167030 �? �??��
	 * @exception
	 */
    public int selectYe167030ListTotCnt(InfcPkgYe167030SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe167030DAO.selectYe167030ListTotCnt_S", searchVO);
    }

}
