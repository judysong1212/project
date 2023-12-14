package com.app.smrmf.infc.yearendtax.server.service.yeta2020.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe167140Srh_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe167140_2020_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167140_2020_DAO.java
 * @Description : Ye167140 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe167140_2020_DAO")
public class InfcPkgYe167140_2020_DAO extends EgovAbstractDAO {

	/**
	 * YE167140?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167140VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167140(InfcPkgYe167140_2020_VO vo) throws Exception {
        return (String)insert("infcPkgYe167140_2020_DAO.insertYe167140_S", vo);
    }

    /**
	 * YE167140?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167140VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167140(InfcPkgYe167140_2020_VO vo) throws Exception {
        update("infcPkgYe167140_2020_DAO.updateYe167140_S", vo);
    }

    /**
	 * YE167140?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167140VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167140(InfcPkgYe167140_2020_VO vo) throws Exception {
        delete("infcPkgYe167140_2020_DAO.deleteYe167140_S", vo);
    }

    /**
	 * YE167140?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167140VO
	 * @return 조회?�� YE167140
	 * @exception Exception
	 */
    public InfcPkgYe167140_2020_VO selectYe167140(InfcPkgYe167140_2020_VO vo) throws Exception {
        return (InfcPkgYe167140_2020_VO) selectByPk("infcPkgYe167140_2020_DAO.selectYe167140_S", vo);
    }

    /**
	 * YE167140 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167140 목록
	 * @exception Exception
	 */
    public List<?> selectYe167140List(InfcPkgYe167140Srh_2020_VO searchVO) throws Exception {
        return list("infcPkgYe167140_2020_DAO.selectYe167140List_D", searchVO);
    }

    /**
	 * YE167140 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167140 �? �??��
	 * @exception
	 */
    public int selectYe167140ListTotCnt(InfcPkgYe167140Srh_2020_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe167140_2020_DAO.selectYe167140ListTotCnt_S", searchVO);
    }

}
