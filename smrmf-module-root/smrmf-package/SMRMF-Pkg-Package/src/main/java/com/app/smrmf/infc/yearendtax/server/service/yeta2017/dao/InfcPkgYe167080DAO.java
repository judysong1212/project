package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167080SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167080VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167080DAO.java
 * @Description : Ye167080 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe167080DAO")
public class InfcPkgYe167080DAO extends EgovAbstractDAO {

	/**
	 * YE167080?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167080VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167080(InfcPkgYe167080VO vo) throws Exception {
        return (String)insert("infcPkgYe167080DAO.insertYe167080_S", vo);
    }

    /**
	 * YE167080?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167080VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167080(InfcPkgYe167080VO vo) throws Exception {
        update("infcPkgYe167080DAO.updateYe167080_S", vo);
    }

    /**
	 * YE167080?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167080VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167080(InfcPkgYe167080VO vo) throws Exception {
        delete("infcPkgYe167080DAO.deleteYe167080_S", vo);
    }

    /**
	 * YE167080?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167080VO
	 * @return 조회?�� YE167080
	 * @exception Exception
	 */
    public InfcPkgYe167080VO selectYe167080(InfcPkgYe167080VO vo) throws Exception {
        return (InfcPkgYe167080VO) selectByPk("infcPkgYe167080DAO.selectYe167080_S", vo);
    }

    /**
	 * YE167080 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167080 목록
	 * @exception Exception
	 */
    public List<?> selectYe167080List(InfcPkgYe167080SrhVO searchVO) throws Exception {
        return list("infcPkgYe167080DAO.selectYe167080List_D", searchVO);
    }

    /**
	 * YE167080 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167080 �? �??��
	 * @exception
	 */
    public int selectYe167080ListTotCnt(InfcPkgYe167080SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe167080DAO.selectYe167080ListTotCnt_S", searchVO);
    }

}
