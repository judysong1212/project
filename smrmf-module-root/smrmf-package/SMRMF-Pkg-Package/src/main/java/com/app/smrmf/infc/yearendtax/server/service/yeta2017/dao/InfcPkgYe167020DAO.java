package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167020SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167020VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167020DAO.java
 * @Description : Ye167020 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe167020DAO")
public class InfcPkgYe167020DAO extends EgovAbstractDAO {

	/**
	 * YE167020?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167020VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167020(InfcPkgYe167020VO vo) throws Exception {
        return (String)insert("infcPkgYe167020DAO.insertYe167020_S", vo);
    }

    /**
	 * YE167020?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167020VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167020(InfcPkgYe167020VO vo) throws Exception {
        update("infcPkgYe167020DAO.updateYe167020_S", vo);
    }

    /**
	 * YE167020?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167020VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167020(InfcPkgYe167020VO vo) throws Exception {
        delete("infcPkgYe167020DAO.deleteYe167020_S", vo);
    }

    /**
	 * YE167020?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167020VO
	 * @return 조회?�� YE167020
	 * @exception Exception
	 */
    public InfcPkgYe167020VO selectYe167020(InfcPkgYe167020VO vo) throws Exception {
        return (InfcPkgYe167020VO) selectByPk("infcPkgYe167020DAO.selectYe167020_S", vo);
    }

    /**
	 * YE167020 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167020 목록
	 * @exception Exception
	 */
    public List<?> selectYe167020List(InfcPkgYe167020SrhVO searchVO) throws Exception {
        return list("infcPkgYe167020DAO.selectYe167020List_D", searchVO);
    }

    /**
	 * YE167020 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167020 �? �??��
	 * @exception
	 */
    public int selectYe167020ListTotCnt(InfcPkgYe167020SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe167020DAO.selectYe167020ListTotCnt_S", searchVO);
    }

}