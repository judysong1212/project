package com.app.smrmf.infc.yearendtax.server.service.yeta2020.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe167070Srh_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe167070_2020_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167070_2020_DAO.java
 * @Description : Ye167070 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe167070_2020_DAO")
public class InfcPkgYe167070_2020_DAO extends EgovAbstractDAO {

	/**
	 * YE167070?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167070VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167070(InfcPkgYe167070_2020_VO vo) throws Exception {
        return (String)insert("infcPkgYe167070_2020_DAO.insertYe167070_S", vo);
    }

    /**
	 * YE167070?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167070VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167070(InfcPkgYe167070_2020_VO vo) throws Exception {
        update("ye167070_2020_DAO.updateYe167070_S", vo);
    }

    /**
	 * YE167070?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167070VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167070(InfcPkgYe167070_2020_VO vo) throws Exception {
        delete("ye167070_2020_DAO.deleteYe167070_S", vo);
    }

    /**
	 * YE167070?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167070VO
	 * @return 조회?�� YE167070
	 * @exception Exception
	 */
    public InfcPkgYe167070_2020_VO selectYe167070(InfcPkgYe167070_2020_VO vo) throws Exception {
        return (InfcPkgYe167070_2020_VO) selectByPk("ye167070_2020_DAO.selectYe167070_S", vo);
    }

    /**
	 * YE167070 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167070 목록
	 * @exception Exception
	 */
    public List<?> selectYe167070List(InfcPkgYe167070Srh_2020_VO searchVO) throws Exception {
        return list("ye167070_2020_DAO.selectYe167070List_D", searchVO);
    }

    /**
	 * YE167070 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167070 �? �??��
	 * @exception
	 */
    public int selectYe167070ListTotCnt(InfcPkgYe167070Srh_2020_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye167070_2020_DAO.selectYe167070ListTotCnt_S", searchVO);
    }

}
