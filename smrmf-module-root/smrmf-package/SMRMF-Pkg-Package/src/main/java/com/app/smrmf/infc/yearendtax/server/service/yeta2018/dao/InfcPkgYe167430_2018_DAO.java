package com.app.smrmf.infc.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe167430Srh_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe167430_2018_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167430_2018_DAO.java
 * @Description : Ye167430 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe167430_2018_DAO")
public class InfcPkgYe167430_2018_DAO extends EgovAbstractDAO {

	/**
	 * YE167430?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167430VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167430(InfcPkgYe167430_2018_VO vo) throws Exception {
        return (String)insert("infcPkgYe167430_2018_DAO.insertYe167430_S", vo);
    }

    /**
	 * YE167430?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167430VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167430(InfcPkgYe167430_2018_VO vo) throws Exception {
        update("infcPkgYe167430_2018_DAO.updateYe167430_S", vo);
    }

    /**
	 * YE167430?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167430VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167430(InfcPkgYe167430_2018_VO vo) throws Exception {
        delete("infcPkgYe167430_2018_DAO.deleteYe167430_S", vo);
    }

    /**
	 * YE167430?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167430VO
	 * @return 조회?�� YE167430
	 * @exception Exception
	 */
    public InfcPkgYe167430_2018_VO selectYe167430(InfcPkgYe167430_2018_VO vo) throws Exception {
        return (InfcPkgYe167430_2018_VO) selectByPk("infcPkgYe167430_2018_DAO.selectYe167430_S", vo);
    }

    /**
	 * YE167430 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167430 목록
	 * @exception Exception
	 */
    public List<?> selectYe167430List(InfcPkgYe167430Srh_2018_VO searchVO) throws Exception {
        return list("infcPkgYe167430_2018_DAO.selectYe167430List_D", searchVO);
    }

    /**
	 * YE167430 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167430 �? �??��
	 * @exception
	 */
    public int selectYe167430ListTotCnt(InfcPkgYe167430Srh_2018_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe167430_2018_DAO.selectYe167430ListTotCnt_S", searchVO);
    }

}
