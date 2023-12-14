package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167310SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167310VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167310DAO.java
 * @Description : Ye167310 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe167310DAO")
public class InfcPkgYe167310DAO extends EgovAbstractDAO {

	/**
	 * YE167310?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167310VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167310(InfcPkgYe167310VO vo) throws Exception {
        return (String)insert("infcPkgYe167310DAO.insertYe167310_S", vo);
    }

    /**
	 * YE167310?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167310VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167310(InfcPkgYe167310VO vo) throws Exception {
        update("infcPkgYe167310DAO.updateYe167310_S", vo);
    }

    /**
	 * YE167310?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167310VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167310(InfcPkgYe167310VO vo) throws Exception {
        delete("infcPkgYe167310DAO.deleteYe167310_S", vo);
    }

    /**
	 * YE167310?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167310VO
	 * @return 조회?�� YE167310
	 * @exception Exception
	 */
    public InfcPkgYe167310VO selectYe167310(InfcPkgYe167310VO vo) throws Exception {
        return (InfcPkgYe167310VO) selectByPk("infcPkgYe167310DAO.selectYe167310_S", vo);
    }

    /**
	 * YE167310 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167310 목록
	 * @exception Exception
	 */
    public List<?> selectYe167310List(InfcPkgYe167310SrhVO searchVO) throws Exception {
        return list("infcPkgYe167310DAO.selectYe167310List_D", searchVO);
    }

    /**
	 * YE167310 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167310 �? �??��
	 * @exception
	 */
    public int selectYe167310ListTotCnt(InfcPkgYe167310SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe167310DAO.selectYe167310ListTotCnt_S", searchVO);
    }

}
