package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161005SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161005VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye161005DAO.java
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

@Repository("InfcPkgYe161005DAO")
public class InfcPkgYe161005DAO extends EgovAbstractDAO {

	/**
	 * YE161005?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye161005VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe161005(InfcPkgYe161005VO vo) throws Exception {
        return (String)insert("infcPkgYe161005DAO.insertYe161005_S", vo);
    }

    /**
	 * YE161005?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161005VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe161005(InfcPkgYe161005VO vo) throws Exception {
        update("infcPkgYe161005DAO.updateYe161005_S", vo);
    }

    /**
	 * YE161005?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye161005VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe161005(InfcPkgYe161005VO vo) throws Exception {
        delete("infcPkgYe161005DAO.deleteYe161005_S", vo);
    }

    /**
	 * YE161005?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye161005VO
	 * @return 조회?�� YE161005
	 * @exception Exception
	 */
    public InfcPkgYe161005VO selectYe161005(InfcPkgYe161005VO vo) throws Exception {
        return (InfcPkgYe161005VO) selectByPk("infcPkgYe161005DAO.selectYe161005_S", vo);
    }

    /**
	 * YE161005 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE161005 목록
	 * @exception Exception
	 */
    public List<?> selectYe161005List(InfcPkgYe161005SrhVO searchVO) throws Exception {
        return list("infcPkgYe161005DAO.selectYe161005List_D", searchVO);
    }

    /**
	 * YE161005 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE161005 �? �??��
	 * @exception
	 */
    public int selectYe161005ListTotCnt(InfcPkgYe161005SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe161005DAO.selectYe161005ListTotCnt_S", searchVO);
    }

}
