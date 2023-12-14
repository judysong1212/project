package com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe167110Srh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe167110_2021_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167110_2021_DAO.java
 * @Description : Ye167110 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe167110_2021_DAO")
public class InfcPkgYe167110_2021_DAO extends EgovAbstractDAO {

	/**
	 * YE167110?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167110VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167110(InfcPkgYe167110_2021_VO vo) throws Exception {
        return (String)insert("infcPkgYe167110_2021_DAO.insertYe167110_S", vo);
    }

    /**
	 * YE167110?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167110VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167110(InfcPkgYe167110_2021_VO vo) throws Exception {
        update("infcPkgYe167110_2021_DAO.updateYe167110_S", vo);
    }

    /**
	 * YE167110?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167110VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167110(InfcPkgYe167110_2021_VO vo) throws Exception {
        delete("infcPkgYe167110_2021_DAO.deleteYe167110_S", vo);
    }

    /**
	 * YE167110?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167110VO
	 * @return 조회?�� YE167110
	 * @exception Exception
	 */
    public InfcPkgYe167110_2021_VO selectYe167110(InfcPkgYe167110_2021_VO vo) throws Exception {
        return (InfcPkgYe167110_2021_VO) selectByPk("infcPkgYe167110_2021_DAO.selectYe167110_S", vo);
    }

    /**
	 * YE167110 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167110 목록
	 * @exception Exception
	 */
    public List<?> selectYe167110List(InfcPkgYe167110Srh_2021_VO searchVO) throws Exception {
        return list("infcPkgYe167110_2021_DAO.selectYe167110List_D", searchVO);
    }

    /**
	 * YE167110 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167110 �? �??��
	 * @exception
	 */
    public int selectYe167110ListTotCnt(InfcPkgYe167110Srh_2021_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe167110_2021_DAO.selectYe167110ListTotCnt_S", searchVO);
    }

}