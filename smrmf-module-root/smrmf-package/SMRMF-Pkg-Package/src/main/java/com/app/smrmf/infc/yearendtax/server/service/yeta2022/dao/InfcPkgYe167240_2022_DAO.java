package com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe167240Srh_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe167240_2022_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167240_2022_DAO.java
 * @Description : Ye167240 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe167240_2022_DAO")
public class InfcPkgYe167240_2022_DAO extends EgovAbstractDAO {

	/**
	 * YE167240?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167240VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167240(InfcPkgYe167240_2022_VO vo) throws Exception {
        return (String)insert("infcPkgYe167240_2022_DAO.insertYe167240_S", vo);
    }

    /**
	 * YE167240?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167240VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167240(InfcPkgYe167240_2022_VO vo) throws Exception {
        update("infcPkgYe167240_2022_DAO.updateYe167240_S", vo);
    }

    /**
	 * YE167240?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167240VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167240(InfcPkgYe167240_2022_VO vo) throws Exception {
        delete("infcPkgYe167240_2022_DAO.deleteYe167240_S", vo);
    }

    /**
	 * YE167240?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167240VO
	 * @return 조회?�� YE167240
	 * @exception Exception
	 */
    public InfcPkgYe167240_2022_VO selectYe167240(InfcPkgYe167240_2022_VO vo) throws Exception {
        return (InfcPkgYe167240_2022_VO) selectByPk("infcPkgYe167240_2022_DAO.selectYe167240_S", vo);
    }

    /**
	 * YE167240 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167240 목록
	 * @exception Exception
	 */
    public List<?> selectYe167240List(InfcPkgYe167240Srh_2022_VO searchVO) throws Exception {
        return list("infcPkgYe167240_2022_DAO.selectYe167240List_D", searchVO);
    }

    /**
	 * YE167240 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167240 �? �??��
	 * @exception
	 */
    public int selectYe167240ListTotCnt(InfcPkgYe167240Srh_2022_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe167240_2022_DAO.selectYe167240ListTotCnt_S", searchVO);
    }

}
