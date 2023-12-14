package com.app.smrmf.infc.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe167320Srh_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe167320_2018_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167320_2018_DAO.java
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

@Repository("InfcPkgYe167320_2018_DAO")
public class InfcPkgYe167320_2018_DAO extends EgovAbstractDAO {

	/**
	 * YE167320?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167320VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167320(InfcPkgYe167320_2018_VO vo) throws Exception {
        return (String)insert("infcPkgYe167320_2018_DAO.insertYe167320_S", vo);
    }

    /**
	 * YE167320?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167320VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167320(InfcPkgYe167320_2018_VO vo) throws Exception {
        update("infcPkgYe167320_2018_DAO.updateYe167320_S", vo);
    }

    /**
	 * YE167320?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167320VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167320(InfcPkgYe167320_2018_VO vo) throws Exception {
        delete("infcPkgYe167320_2018_DAO.deleteYe167320_S", vo);
    }

    /**
	 * YE167320?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167320VO
	 * @return 조회?�� YE167320
	 * @exception Exception
	 */
    public InfcPkgYe167320_2018_VO selectYe167320(InfcPkgYe167320_2018_VO vo) throws Exception {
        return (InfcPkgYe167320_2018_VO) selectByPk("infcPkgYe167320_2018_DAO.selectYe167320_S", vo);
    }

    /**
	 * YE167320 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167320 목록
	 * @exception Exception
	 */
    public List<?> selectYe167320List(InfcPkgYe167320Srh_2018_VO searchVO) throws Exception {
        return list("infcPkgYe167320_2018_DAO.selectYe167320List_D", searchVO);
    }

    /**
	 * YE167320 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167320 �? �??��
	 * @exception
	 */
    public int selectYe167320ListTotCnt(InfcPkgYe167320Srh_2018_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe167320_2018_DAO.selectYe167320ListTotCnt_S", searchVO);
    }

}
