package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167320SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167320VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167320DAO.java
 * @Description : Ye167320 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe167320DAO")
public class InfcPkgYe167320DAO extends EgovAbstractDAO {

	/**
	 * YE167320?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167320VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167320(InfcPkgYe167320VO vo) throws Exception {
        return (String)insert("infcPkgYe167320DAO.insertYe167320_S", vo);
    }

    /**
	 * YE167320?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167320VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167320(InfcPkgYe167320VO vo) throws Exception {
        update("infcPkgYe167320DAO.updateYe167320_S", vo);
    }

    /**
	 * YE167320?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167320VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167320(InfcPkgYe167320VO vo) throws Exception {
        delete("infcPkgYe167320DAO.deleteYe167320_S", vo);
    }

    /**
	 * YE167320?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167320VO
	 * @return 조회?�� YE167320
	 * @exception Exception
	 */
    public InfcPkgYe167320VO selectYe167320(InfcPkgYe167320VO vo) throws Exception {
        return (InfcPkgYe167320VO) selectByPk("infcPkgYe167320DAO.selectYe167320_S", vo);
    }

    /**
	 * YE167320 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167320 목록
	 * @exception Exception
	 */
    public List<?> selectYe167320List(InfcPkgYe167320SrhVO searchVO) throws Exception {
        return list("infcPkgYe167320DAO.selectYe167320List_D", searchVO);
    }

    /**
	 * YE167320 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167320 �? �??��
	 * @exception
	 */
    public int selectYe167320ListTotCnt(InfcPkgYe167320SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe167320DAO.selectYe167320ListTotCnt_S", searchVO);
    }

}
