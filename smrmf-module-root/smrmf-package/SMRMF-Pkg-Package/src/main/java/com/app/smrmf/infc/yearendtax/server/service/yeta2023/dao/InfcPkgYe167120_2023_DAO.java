package com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe167120Srh_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe167120_2023_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167120_2023_DAO.java
 * @Description : Ye167120 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe167120_2023_DAO")
public class InfcPkgYe167120_2023_DAO extends EgovAbstractDAO {

	/**
	 * YE167120?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167120VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167120(InfcPkgYe167120_2023_VO vo) throws Exception {
        return (String)insert("infcPkgYe167120_2023_DAO.insertYe167120_S", vo);
    }

    /**
	 * YE167120?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167120VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167120(InfcPkgYe167120_2023_VO vo) throws Exception {
        update("infcPkgYe167120_2023_DAO.updateYe167120_S", vo);
    }

    /**
	 * YE167120?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167120VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167120(InfcPkgYe167120_2023_VO vo) throws Exception {
        delete("infcPkgYe167120_2023_DAO.deleteYe167120_S", vo);
    }

    /**
	 * YE167120?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167120VO
	 * @return 조회?�� YE167120
	 * @exception Exception
	 */
    public InfcPkgYe167120_2023_VO selectYe167120(InfcPkgYe167120_2023_VO vo) throws Exception {
        return (InfcPkgYe167120_2023_VO) selectByPk("infcPkgYe167120_2023_DAO.selectYe167120_S", vo);
    }

    /**
	 * YE167120 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167120 목록
	 * @exception Exception
	 */
    public List<?> selectYe167120List(InfcPkgYe167120Srh_2023_VO searchVO) throws Exception {
        return list("infcPkgYe167120_2023_DAO.selectYe167120List_D", searchVO);
    }

    /**
	 * YE167120 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167120 �? �??��
	 * @exception
	 */
    public int selectYe167120ListTotCnt(InfcPkgYe167120Srh_2023_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe167120_2023_DAO.selectYe167120ListTotCnt_S", searchVO);
    }

}
