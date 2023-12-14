package com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe167420Srh_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe167420_2023_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167420_2023_DAO.java
 * @Description : Ye167420 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe167420_2023_DAO")
public class InfcPkgYe167420_2023_DAO extends EgovAbstractDAO {

	/**
	 * YE167420?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167420VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167420(InfcPkgYe167420_2023_VO vo) throws Exception {
        return (String)insert("infcPkgYe167420_2023_DAO.insertYe167420_S", vo);
    }

    /**
	 * YE167420?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167420VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167420(InfcPkgYe167420_2023_VO vo) throws Exception {
        update("infcPkgYe167420_2023_DAO.updateYe167420_S", vo);
    }

    /**
	 * YE167420?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167420VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167420(InfcPkgYe167420_2023_VO vo) throws Exception {
        delete("infcPkgYe167420_2023_DAO.deleteYe167420_S", vo);
    }

    /**
	 * YE167420?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167420VO
	 * @return 조회?�� YE167420
	 * @exception Exception
	 */
    public InfcPkgYe167420_2023_VO selectYe167420(InfcPkgYe167420_2023_VO vo) throws Exception {
        return (InfcPkgYe167420_2023_VO) selectByPk("infcPkgYe167420_2023_DAO.selectYe167420_S", vo);
    }

    /**
	 * YE167420 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167420 목록
	 * @exception Exception
	 */
    public List<?> selectYe167420List(InfcPkgYe167420Srh_2023_VO searchVO) throws Exception {
        return list("infcPkgYe167420_2023_DAO.selectYe167420List_D", searchVO);
    }

    /**
	 * YE167420 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167420 �? �??��
	 * @exception
	 */
    public int selectYe167420ListTotCnt(InfcPkgYe167420Srh_2023_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe167420_2023_DAO.selectYe167420ListTotCnt_S", searchVO);
    }

}