package com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe167020Srh_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe167020_2022_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167020_2022_DAO.java
 * @Description : Ye167020 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe167020_2022_DAO")
public class InfcPkgYe167020_2022_DAO extends EgovAbstractDAO {

	/**
	 * YE167020?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167020VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167020(InfcPkgYe167020_2022_VO vo) throws Exception {
        return (String)insert("infcPkgYe167020_2022_DAO.insertYe167020_S", vo);
    }

    /**
	 * YE167020?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167020VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167020(InfcPkgYe167020_2022_VO vo) throws Exception {
        update("infcPkgYe167020_2022_DAO.updateYe167020_S", vo);
    }

    /**
	 * YE167020?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167020VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167020(InfcPkgYe167020_2022_VO vo) throws Exception {
        delete("infcPkgYe167020_2022_DAO.deleteYe167020_S", vo);
    }

    /**
	 * YE167020?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167020VO
	 * @return 조회?�� YE167020
	 * @exception Exception
	 */
    public InfcPkgYe167020_2022_VO selectYe167020(InfcPkgYe167020_2022_VO vo) throws Exception {
        return (InfcPkgYe167020_2022_VO) selectByPk("infcPkgYe167020_2022_DAO.selectYe167020_S", vo);
    }

    /**
	 * YE167020 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167020 목록
	 * @exception Exception
	 */
    public List<?> selectYe167020List(InfcPkgYe167020Srh_2022_VO searchVO) throws Exception {
        return list("infcPkgYe167020_2022_DAO.selectYe167020List_D", searchVO);
    }

    /**
	 * YE167020 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167020 �? �??��
	 * @exception
	 */
    public int selectYe167020ListTotCnt(InfcPkgYe167020Srh_2022_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe167020_2022_DAO.selectYe167020ListTotCnt_S", searchVO);
    }

}
