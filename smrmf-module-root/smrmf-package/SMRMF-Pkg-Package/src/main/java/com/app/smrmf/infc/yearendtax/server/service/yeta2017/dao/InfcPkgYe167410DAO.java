package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167410SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167410VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167410DAO.java
 * @Description : Ye167410 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe167410DAO")
public class InfcPkgYe167410DAO extends EgovAbstractDAO {

	/**
	 * YE167410?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167410VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167410(InfcPkgYe167410VO vo) throws Exception {
        return (String)insert("infcPkgYe167410DAO.insertYe167410_S", vo);
    }

    /**
	 * YE167410?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167410VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167410(InfcPkgYe167410VO vo) throws Exception {
        update("infcPkgYe167410DAO.updateYe167410_S", vo);
    }

    /**
	 * YE167410?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167410VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167410(InfcPkgYe167410VO vo) throws Exception {
        delete("infcPkgYe167410DAO.deleteYe167410_S", vo);
    }

    /**
	 * YE167410?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167410VO
	 * @return 조회?�� YE167410
	 * @exception Exception
	 */
    public InfcPkgYe167410VO selectYe167410(InfcPkgYe167410VO vo) throws Exception {
        return (InfcPkgYe167410VO) selectByPk("infcPkgYe167410DAO.selectYe167410_S", vo);
    }

    /**
	 * YE167410 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167410 목록
	 * @exception Exception
	 */
    public List<?> selectYe167410List(InfcPkgYe167410SrhVO searchVO) throws Exception {
        return list("infcPkgYe167410DAO.selectYe167410List_D", searchVO);
    }

    /**
	 * YE167410 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167410 �? �??��
	 * @exception
	 */
    public int selectYe167410ListTotCnt(InfcPkgYe167410SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe167410DAO.selectYe167410ListTotCnt_S", searchVO);
    }

}
