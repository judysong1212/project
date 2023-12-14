package com.app.smrmf.infc.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe167230Srh_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe167230_2018_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167230_2018_DAO.java
 * @Description : Ye167230 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe167230_2018_DAO")
public class InfcPkgYe167230_2018_DAO extends EgovAbstractDAO {

	/**
	 * YE167230?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167230VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167230(InfcPkgYe167230_2018_VO vo) throws Exception {
        return (String)insert("infcPkgYe167230_2018_DAO.insertYe167230_S", vo);
    }

    /**
	 * YE167230?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167230VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167230(InfcPkgYe167230_2018_VO vo) throws Exception {
        update("infcPkgYe167230_2018_DAO.updateYe167230_S", vo);
    }

    /**
	 * YE167230?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167230VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167230(InfcPkgYe167230_2018_VO vo) throws Exception {
        delete("infcPkgYe167230_2018_DAO.deleteYe167230_S", vo);
    }

    /**
	 * YE167230?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167230VO
	 * @return 조회?�� YE167230
	 * @exception Exception
	 */
    public InfcPkgYe167230_2018_VO selectYe167230(InfcPkgYe167230_2018_VO vo) throws Exception {
        return (InfcPkgYe167230_2018_VO) selectByPk("infcPkgYe167230_2018_DAO.selectYe167230_S", vo);
    }

    /**
	 * YE167230 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167230 목록
	 * @exception Exception
	 */
    public List<?> selectYe167230List(InfcPkgYe167230Srh_2018_VO searchVO) throws Exception {
        return list("infcPkgYe167230_2018_DAO.selectYe167230List_D", searchVO);
    }

    /**
	 * YE167230 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167230 �? �??��
	 * @exception
	 */
    public int selectYe167230ListTotCnt(InfcPkgYe167230Srh_2018_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe167230_2018_DAO.selectYe167230ListTotCnt_S", searchVO);
    }

}
