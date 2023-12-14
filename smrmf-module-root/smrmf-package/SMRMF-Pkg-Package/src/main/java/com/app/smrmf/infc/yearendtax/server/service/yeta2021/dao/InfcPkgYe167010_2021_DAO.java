package com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe162010_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe166010_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe167010Srh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe167010_2021_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167010_2021_DAO.java
 * @Description : Ye167010 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe167010_2021_DAO")
public class InfcPkgYe167010_2021_DAO extends EgovAbstractDAO {


	/**
	 * YE167010?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167010VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167010(InfcPkgYe167010_2021_VO vo) throws Exception {
        return (String)insert("infcPkgYe167010_2021_DAO.insertYe167010_S", vo);
    }

    /**
	 * YE167010?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167010VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167010(InfcPkgYe167010_2021_VO vo) throws Exception {
        update("infcPkgYe167010_2021_DAO.updateYe167010_S", vo);
    }

    /**
	 * YE167010?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167010VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167010(InfcPkgYe167010_2021_VO vo) throws Exception {
        delete("infcPkgYe167010_2021_DAO.deleteYe167010_S", vo);
    }

    /**
	 * YE167010?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167010VO
	 * @return 조회?�� YE167010
	 * @exception Exception
	 */
    public InfcPkgYe167010_2021_VO selectYe167010(InfcPkgYe167010_2021_VO vo) throws Exception {
        return (InfcPkgYe167010_2021_VO) selectByPk("infcPkgYe167010_2021_DAO.selectYe167010_S", vo);
    }

    /**
	 * YE167010 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167010 목록
	 * @exception Exception
	 */
    public List<?> selectYe167010List(InfcPkgYe167010Srh_2021_VO searchVO) throws Exception {
        return list("infcPkgYe167010_2021_DAO.selectYe167010List_D", searchVO);
    }

    /**
	 * YE167010 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167010 �? �??��
	 * @exception
	 */
    public int selectYe167010ListTotCnt(InfcPkgYe167010Srh_2021_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe167010_2021_DAO.selectYe167010ListTotCnt_S", searchVO);
    }

}
