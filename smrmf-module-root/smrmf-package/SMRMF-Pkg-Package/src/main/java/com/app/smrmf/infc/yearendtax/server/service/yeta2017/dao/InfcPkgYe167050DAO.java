package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167050SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167050VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167050DAO.java
 * @Description : Ye167050 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe167050DAO")
public class InfcPkgYe167050DAO extends EgovAbstractDAO {

	/**
	 * YE167050?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167050VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167050(InfcPkgYe167050VO vo) throws Exception {
        return (String)insert("infcPkgYe167050DAO.insertYe167050_S", vo);
    }

    /**
	 * YE167050?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167050VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167050(InfcPkgYe167050VO vo) throws Exception {
        update("infcPkgYe167050DAO.updateYe167050_S", vo);
    }

    /**
	 * YE167050?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167050VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167050(InfcPkgYe167050VO vo) throws Exception {
        delete("infcPkgYe167050DAO.deleteYe167050_S", vo);
    }

    /**
	 * YE167050?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167050VO
	 * @return 조회?�� YE167050
	 * @exception Exception
	 */
    public InfcPkgYe167050VO selectYe167050(InfcPkgYe167050VO vo) throws Exception {
        return (InfcPkgYe167050VO) selectByPk("infcPkgYe167050DAO.selectYe167050_S", vo);
    }

    /**
	 * YE167050 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167050 목록
	 * @exception Exception
	 */
    public List<?> selectYe167050List(InfcPkgYe167050SrhVO searchVO) throws Exception {
        return list("infcPkgYe167050DAO.selectYe167050List_D", searchVO);
    }

    /**
	 * YE167050 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167050 �? �??��
	 * @exception
	 */
    public int selectYe167050ListTotCnt(InfcPkgYe167050SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe167050DAO.selectYe167050ListTotCnt_S", searchVO);
    }

}
