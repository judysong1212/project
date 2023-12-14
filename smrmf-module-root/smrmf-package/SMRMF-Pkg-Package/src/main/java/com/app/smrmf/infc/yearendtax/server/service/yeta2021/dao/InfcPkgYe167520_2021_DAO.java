package com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe167520Srh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe167520_2021_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167520_2021_DAO.java
 * @Description : Ye167520 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe167520_2021_DAO")
public class InfcPkgYe167520_2021_DAO extends EgovAbstractDAO {

	/**
	 * YE167520?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167520VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167520(InfcPkgYe167520_2021_VO vo) throws Exception {
        return (String)insert("infcPkgYe167520_2021_DAO.insertYe167520_S", vo);
    }

    /**
	 * YE167520?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167520VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167520(InfcPkgYe167520_2021_VO vo) throws Exception {
        update("infcPkgYe167520_2021_DAO.updateYe167520_S", vo);
    }

    /**
	 * YE167520?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167520VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167520(InfcPkgYe167520_2021_VO vo) throws Exception {
        delete("infcPkgYe167520_2021_DAO.deleteYe167520_S", vo);
    }

    /**
	 * YE167520?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167520VO
	 * @return 조회?�� YE167520
	 * @exception Exception
	 */
    public InfcPkgYe167520_2021_VO selectYe167520(InfcPkgYe167520_2021_VO vo) throws Exception {
        return (InfcPkgYe167520_2021_VO) selectByPk("infcPkgYe167520_2021_DAO.selectYe167520_S", vo);
    }

    /**
	 * YE167520 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167520 목록
	 * @exception Exception
	 */
    public List<?> selectYe167520List(InfcPkgYe167520Srh_2021_VO searchVO) throws Exception {
        return list("infcPkgYe167520_2021_DAO.selectYe167520List_D", searchVO);
    }

    /**
	 * YE167520 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167520 �? �??��
	 * @exception
	 */
    public int selectYe167520ListTotCnt(InfcPkgYe167520Srh_2021_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe167520_2021_DAO.selectYe167520ListTotCnt_S", searchVO);
    }

}
