package com.app.smrmf.infc.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe167440Srh_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe167440_2018_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167440_2018_DAO.java
 * @Description : Ye167440 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe167440_2018_DAO")
public class InfcPkgYe167440_2018_DAO extends EgovAbstractDAO {

	/**
	 * YE167440?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167440VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167440(InfcPkgYe167440_2018_VO vo) throws Exception {
        return (String)insert("infcPkgYe167440_2018_DAO.insertYe167440_S", vo);
    }

    /**
	 * YE167440?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167440VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167440(InfcPkgYe167440_2018_VO vo) throws Exception {
        update("infcPkgYe167440_2018_DAO.updateYe167440_S", vo);
    }

    /**
	 * YE167440?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167440VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167440(InfcPkgYe167440_2018_VO vo) throws Exception {
        delete("infcPkgYe167440_2018_DAO.deleteYe167440_S", vo);
    }

    /**
	 * YE167440?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167440VO
	 * @return 조회?�� YE167440
	 * @exception Exception
	 */
    public InfcPkgYe167440_2018_VO selectYe167440(InfcPkgYe167440_2018_VO vo) throws Exception {
        return (InfcPkgYe167440_2018_VO) selectByPk("infcPkgYe167440_2018_DAO.selectYe167440_S", vo);
    }

    /**
	 * YE167440 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167440 목록
	 * @exception Exception
	 */
    public List<?> selectYe167440List(InfcPkgYe167440Srh_2018_VO searchVO) throws Exception {
        return list("infcPkgYe167440_2018_DAO.selectYe167440List_D", searchVO);
    }

    /**
	 * YE167440 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167440 �? �??��
	 * @exception
	 */
    public int selectYe167440ListTotCnt(InfcPkgYe167440Srh_2018_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe167440_2018_DAO.selectYe167440ListTotCnt_S", searchVO);
    }

}
