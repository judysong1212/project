package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye167240SrhVO;
import com.app.exterms.yearendtax.server.vo.Ye167240VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167240DAO.java
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

@Repository("Ye167240DAO")
public class Ye167240DAO extends EgovAbstractDAO {

	/**
	 * YE167240?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167240VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167240(Ye167240VO vo) throws Exception {
        return (String)insert("ye167240DAO.insertYe167240_S", vo);
    }

    /**
	 * YE167240?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167240VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167240(Ye167240VO vo) throws Exception {
        update("ye167240DAO.updateYe167240_S", vo);
    }

    /**
	 * YE167240?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167240VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167240(Ye167240VO vo) throws Exception {
        delete("ye167240DAO.deleteYe167240_S", vo);
    }

    /**
	 * YE167240?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167240VO
	 * @return 조회?�� YE167240
	 * @exception Exception
	 */
    public Ye167240VO selectYe167240(Ye167240VO vo) throws Exception {
        return (Ye167240VO) selectByPk("ye167240DAO.selectYe167240_S", vo);
    }

    /**
	 * YE167240 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167240 목록
	 * @exception Exception
	 */
    public List<?> selectYe167240List(Ye167240SrhVO searchVO) throws Exception {
        return list("ye167240DAO.selectYe167240List_D", searchVO);
    }

    /**
	 * YE167240 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167240 �? �??��
	 * @exception
	 */
    public int selectYe167240ListTotCnt(Ye167240SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye167240DAO.selectYe167240ListTotCnt_S", searchVO);
    }

}
