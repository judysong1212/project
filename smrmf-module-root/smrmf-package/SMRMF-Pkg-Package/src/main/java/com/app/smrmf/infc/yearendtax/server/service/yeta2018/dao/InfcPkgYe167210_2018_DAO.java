package com.app.smrmf.infc.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe167210Srh_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe167210_2018_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167210_2018_DAO.java
 * @Description : Ye167210 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe167210_2018_DAO")
public class InfcPkgYe167210_2018_DAO extends EgovAbstractDAO {

	/**
	 * YE167210?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167210VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167210(InfcPkgYe167210_2018_VO vo) throws Exception {
        return (String)insert("infcPkgYe167210_2018_DAO.insertYe167210_S", vo);
    }

    /**
	 * YE167210?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167210VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167210(InfcPkgYe167210_2018_VO vo) throws Exception {
        update("infcPkgYe167210_2018_DAO.updateYe167210_S", vo);
    }

    /**
	 * YE167210?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167210VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167210(InfcPkgYe167210_2018_VO vo) throws Exception {
        delete("infcPkgYe167210_2018_DAO.deleteYe167210_S", vo);
    }

    /**
	 * YE167210?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167210VO
	 * @return 조회?�� YE167210
	 * @exception Exception
	 */
    public InfcPkgYe167210_2018_VO selectYe167210(InfcPkgYe167210_2018_VO vo) throws Exception {
        return (InfcPkgYe167210_2018_VO) selectByPk("infcPkgYe167210_2018_DAO.selectYe167210_S", vo);
    }

    /**
	 * YE167210 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167210 목록
	 * @exception Exception
	 */
    public List<?> selectYe167210List(InfcPkgYe167210Srh_2018_VO searchVO) throws Exception {
        return list("infcPkgYe167210_2018_DAO.selectYe167210List_D", searchVO);
    }

    /**
	 * YE167210 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167210 �? �??��
	 * @exception
	 */
    public int selectYe167210ListTotCnt(InfcPkgYe167210Srh_2018_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe167210_2018_DAO.selectYe167210ListTotCnt_S", searchVO);
    }

}
