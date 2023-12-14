package com.app.smrmf.infc.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161005Srh_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161005_2018_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye161005_2018_DAO.java
 * @Description : Ye161005 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe161005_2018_DAO")
public class InfcPkgYe161005_2018_DAO extends EgovAbstractDAO {

	/**
	 * YE161005?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye161005VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe161005(InfcPkgYe161005_2018_VO vo) throws Exception {
        return (String)insert("infcPkgYe161005_2018_DAO.insertYe161005_S", vo);
    }

    /**
	 * YE161005?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161005VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe161005(InfcPkgYe161005_2018_VO vo) throws Exception {
        update("infcPkgYe161005_2018_DAO.updateYe161005_S", vo);
    }

    /**
	 * YE161005?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161005VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe161005(InfcPkgYe161005_2018_VO vo) throws Exception {
        delete("infcPkgYe161005_2018_DAO.deleteYe161005_S", vo);
    }

    /**
	 * YE161005?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye161005VO
	 * @return 조회?�� YE161005
	 * @exception Exception
	 */
    public InfcPkgYe161005_2018_VO selectYe161005(InfcPkgYe161005_2018_VO vo) throws Exception {
        return (InfcPkgYe161005_2018_VO) selectByPk("infcPkgYe161005_2018_DAO.selectYe161005_S", vo);
    }

    /**
	 * YE161005 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE161005 목록
	 * @exception Exception
	 */
    public List<?> selectYe161005List(InfcPkgYe161005Srh_2018_VO searchVO) throws Exception {
        return list("infcPkgYe161005_2018_DAO.selectYe161005List_D", searchVO);
    }

    /**
	 * YE161005 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE161005 �? �??��
	 * @exception
	 */
    public int selectYe161005ListTotCnt(InfcPkgYe161005Srh_2018_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe161005_2018_DAO.selectYe161005ListTotCnt_S", searchVO);
    }

}