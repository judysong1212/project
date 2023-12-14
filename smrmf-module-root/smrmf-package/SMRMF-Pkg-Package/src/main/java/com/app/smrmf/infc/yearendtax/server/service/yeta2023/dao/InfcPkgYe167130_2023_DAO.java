package com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe167130Srh_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe167130_2023_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167130_2023_DAO.java
 * @Description : Ye167130 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe167130_2023_DAO")
public class InfcPkgYe167130_2023_DAO extends EgovAbstractDAO {

	/**
	 * YE167130?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167130VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167130(InfcPkgYe167130_2023_VO vo) throws Exception {
        return (String)insert("infcPkgYe167130_2023_DAO.insertYe167130_S", vo);
    }

    /**
	 * YE167130?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167130VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167130(InfcPkgYe167130_2023_VO vo) throws Exception {
        update("infcPkgYe167130_2023_DAO.updateYe167130_S", vo);
    }

    /**
	 * YE167130?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167130VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167130(InfcPkgYe167130_2023_VO vo) throws Exception {
        delete("infcPkgYe167130_2023_DAO.deleteYe167130_S", vo);
    }

    /**
	 * YE167130?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167130VO
	 * @return 조회?�� YE167130
	 * @exception Exception
	 */
    public InfcPkgYe167130_2023_VO selectYe167130(InfcPkgYe167130_2023_VO vo) throws Exception {
        return (InfcPkgYe167130_2023_VO) selectByPk("infcPkgYe167130_2023_DAO.selectYe167130_S", vo);
    }

    /**
	 * YE167130 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167130 목록
	 * @exception Exception
	 */
    public List<?> selectYe167130List(InfcPkgYe167130Srh_2023_VO searchVO) throws Exception {
        return list("infcPkgYe167130_2023_DAO.selectYe167130List_D", searchVO);
    }

    /**
	 * YE167130 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167130 �? �??��
	 * @exception
	 */
    public int selectYe167130ListTotCnt(InfcPkgYe167130Srh_2023_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe167130_2023_DAO.selectYe167130ListTotCnt_S", searchVO);
    }

}
