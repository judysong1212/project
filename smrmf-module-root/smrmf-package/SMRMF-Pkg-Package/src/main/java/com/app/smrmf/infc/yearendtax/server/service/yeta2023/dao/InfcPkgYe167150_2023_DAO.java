package com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe167150Srh_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe167150_2023_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167150_2023_DAO.java
 * @Description : Ye167150 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe167150_2023_DAO")
public class InfcPkgYe167150_2023_DAO extends EgovAbstractDAO {

	/**
	 * YE167150?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167150VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167150(InfcPkgYe167150_2023_VO vo) throws Exception {
        return (String)insert("infcPkgYe167150_2023_DAO.insertYe167150_S", vo);
    }

    /**
	 * YE167150?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167150VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167150(InfcPkgYe167150_2023_VO vo) throws Exception {
        update("infcPkgYe167150_2023_DAO.updateYe167150_S", vo);
    }

    /**
	 * YE167150?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167150VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167150(InfcPkgYe167150_2023_VO vo) throws Exception {
        delete("infcPkgYe167150_2023_DAO.deleteYe167150_S", vo);
    }

    /**
	 * YE167150?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167150VO
	 * @return 조회?�� YE167150
	 * @exception Exception
	 */
    public InfcPkgYe167150_2023_VO selectYe167150(InfcPkgYe167150_2023_VO vo) throws Exception {
        return (InfcPkgYe167150_2023_VO) selectByPk("infcPkgYe167150_2023_DAO.selectYe167150_S", vo);
    }

    /**
	 * YE167150 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167150 목록
	 * @exception Exception
	 */
    public List<?> selectYe167150List(InfcPkgYe167150Srh_2023_VO searchVO) throws Exception {
        return list("infcPkgYe167150_2023_DAO.selectYe167150List_D", searchVO);
    }

    /**
	 * YE167150 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167150 �? �??��
	 * @exception
	 */
    public int selectYe167150ListTotCnt(InfcPkgYe167150Srh_2023_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe167150_2023_DAO.selectYe167150ListTotCnt_S", searchVO);
    }

}
