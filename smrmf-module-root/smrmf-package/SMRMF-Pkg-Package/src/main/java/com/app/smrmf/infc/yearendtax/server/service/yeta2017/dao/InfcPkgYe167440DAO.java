package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167440SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167440VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167440DAO.java
 * @Description : Ye167440 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe167440DAO")
public class InfcPkgYe167440DAO extends EgovAbstractDAO {

	/**
	 * YE167440?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167440VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167440(InfcPkgYe167440VO vo) throws Exception {
        return (String)insert("infcPkgYe167440DAO.insertYe167440_S", vo);
    }

    /**
	 * YE167440?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167440VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167440(InfcPkgYe167440VO vo) throws Exception {
        update("infcPkgYe167440DAO.updateYe167440_S", vo);
    }

    /**
	 * YE167440?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167440VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167440(InfcPkgYe167440VO vo) throws Exception {
        delete("infcPkgYe167440DAO.deleteYe167440_S", vo);
    }

    /**
	 * YE167440?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167440VO
	 * @return 조회?�� YE167440
	 * @exception Exception
	 */
    public InfcPkgYe167440VO selectYe167440(InfcPkgYe167440VO vo) throws Exception {
        return (InfcPkgYe167440VO) selectByPk("infcPkgYe167440DAO.selectYe167440_S", vo);
    }

    /**
	 * YE167440 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167440 목록
	 * @exception Exception
	 */
    public List<?> selectYe167440List(InfcPkgYe167440SrhVO searchVO) throws Exception {
        return list("infcPkgYe167440DAO.selectYe167440List_D", searchVO);
    }

    /**
	 * YE167440 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167440 �? �??��
	 * @exception
	 */
    public int selectYe167440ListTotCnt(InfcPkgYe167440SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe167440DAO.selectYe167440ListTotCnt_S", searchVO);
    }

}
