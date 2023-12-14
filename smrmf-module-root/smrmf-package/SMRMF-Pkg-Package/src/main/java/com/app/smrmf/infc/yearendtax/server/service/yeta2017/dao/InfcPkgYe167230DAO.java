package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167230SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167230VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167230DAO.java
 * @Description : Ye167230 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe167230DAO")
public class InfcPkgYe167230DAO extends EgovAbstractDAO {

	/**
	 * YE167230?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167230VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167230(InfcPkgYe167230VO vo) throws Exception {
        return (String)insert("infcPkgYe167230DAO.insertYe167230_S", vo);
    }

    /**
	 * YE167230?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167230VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167230(InfcPkgYe167230VO vo) throws Exception {
        update("infcPkgYe167230DAO.updateYe167230_S", vo);
    }

    /**
	 * YE167230?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167230VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167230(InfcPkgYe167230VO vo) throws Exception {
        delete("infcPkgYe167230DAO.deleteYe167230_S", vo);
    }

    /**
	 * YE167230?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167230VO
	 * @return 조회?�� YE167230
	 * @exception Exception
	 */
    public InfcPkgYe167230VO selectYe167230(InfcPkgYe167230VO vo) throws Exception {
        return (InfcPkgYe167230VO) selectByPk("infcPkgYe167230DAO.selectYe167230_S", vo);
    }

    /**
	 * YE167230 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167230 목록
	 * @exception Exception
	 */
    public List<?> selectYe167230List(InfcPkgYe167230SrhVO searchVO) throws Exception {
        return list("infcPkgYe167230DAO.selectYe167230List_D", searchVO);
    }

    /**
	 * YE167230 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167230 �? �??��
	 * @exception
	 */
    public int selectYe167230ListTotCnt(InfcPkgYe167230SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe167230DAO.selectYe167230ListTotCnt_S", searchVO);
    }

}
