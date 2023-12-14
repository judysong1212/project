package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167220SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167220VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167220DAO.java
 * @Description : Ye167220 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2016.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe167220DAO")
public class InfcPkgYe167220DAO extends EgovAbstractDAO {

	/**
	 * YE167220?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167220VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167220(InfcPkgYe167220VO vo) throws Exception {
        return (String)insert("infcPkgYe167220DAO.insertYe167220_S", vo);
    }

    /**
	 * YE167220?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167220VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167220(InfcPkgYe167220VO vo) throws Exception {
        update("infcPkgYe167220DAO.updateYe167220_S", vo);
    }

    /**
	 * YE167220?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167220VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167220(InfcPkgYe167220VO vo) throws Exception {
        delete("infcPkgYe167220DAO.deleteYe167220_S", vo);
    }

    /**
	 * YE167220?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167220VO
	 * @return 조회?�� YE167220
	 * @exception Exception
	 */
    public InfcPkgYe167220VO selectYe167220(InfcPkgYe167220VO vo) throws Exception {
        return (InfcPkgYe167220VO) selectByPk("infcPkgYe167220DAO.selectYe167220_S", vo);
    }

    /**
	 * YE167220 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167220 목록
	 * @exception Exception
	 */
    public List<?> selectYe167220List(InfcPkgYe167220SrhVO searchVO) throws Exception {
        return list("infcPkgYe167220DAO.selectYe167220List_D", searchVO);
    }

    /**
	 * YE167220 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167220 �? �??��
	 * @exception
	 */
    public int selectYe167220ListTotCnt(InfcPkgYe167220SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe167220DAO.selectYe167220ListTotCnt_S", searchVO);
    }

}
