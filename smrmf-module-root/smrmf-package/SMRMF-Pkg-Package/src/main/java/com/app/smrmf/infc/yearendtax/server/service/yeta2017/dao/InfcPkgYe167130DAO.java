package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167130SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167130VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167130DAO.java
 * @Description : Ye167130 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe167130DAO")
public class InfcPkgYe167130DAO extends EgovAbstractDAO {

	/**
	 * YE167130?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167130VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167130(InfcPkgYe167130VO vo) throws Exception {
        return (String)insert("infcPkgYe167130DAO.insertYe167130_S", vo);
    }

    /**
	 * YE167130?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167130VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167130(InfcPkgYe167130VO vo) throws Exception {
        update("infcPkgYe167130DAO.updateYe167130_S", vo);
    }

    /**
	 * YE167130?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167130VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167130(InfcPkgYe167130VO vo) throws Exception {
        delete("infcPkgYe167130DAO.deleteYe167130_S", vo);
    }

    /**
	 * YE167130?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167130VO
	 * @return 조회?�� YE167130
	 * @exception Exception
	 */
    public InfcPkgYe167130VO selectYe167130(InfcPkgYe167130VO vo) throws Exception {
        return (InfcPkgYe167130VO) selectByPk("infcPkgYe167130DAO.selectYe167130_S", vo);
    }

    /**
	 * YE167130 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167130 목록
	 * @exception Exception
	 */
    public List<?> selectYe167130List(InfcPkgYe167130SrhVO searchVO) throws Exception {
        return list("infcPkgYe167130DAO.selectYe167130List_D", searchVO);
    }

    /**
	 * YE167130 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167130 �? �??��
	 * @exception
	 */
    public int selectYe167130ListTotCnt(InfcPkgYe167130SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe167130DAO.selectYe167130ListTotCnt_S", searchVO);
    }

}
