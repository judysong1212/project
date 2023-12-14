package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye167210SrhVO;
import com.app.exterms.yearendtax.server.vo.Ye167210VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167210DAO.java
 * @Description : Ye167210 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye167210DAO")
public class Ye167210DAO extends EgovAbstractDAO {

	/**
	 * YE167210?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167210VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167210(Ye167210VO vo) throws Exception {
        return (String)insert("ye167210DAO.insertYe167210_S", vo);
    }

    /**
	 * YE167210?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167210VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167210(Ye167210VO vo) throws Exception {
        update("ye167210DAO.updateYe167210_S", vo);
    }

    /**
	 * YE167210?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167210VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167210(Ye167210VO vo) throws Exception {
        delete("ye167210DAO.deleteYe167210_S", vo);
    }

    /**
	 * YE167210?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167210VO
	 * @return 조회?�� YE167210
	 * @exception Exception
	 */
    public Ye167210VO selectYe167210(Ye167210VO vo) throws Exception {
        return (Ye167210VO) selectByPk("ye167210DAO.selectYe167210_S", vo);
    }

    /**
	 * YE167210 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167210 목록
	 * @exception Exception
	 */
    public List<?> selectYe167210List(Ye167210SrhVO searchVO) throws Exception {
        return list("ye167210DAO.selectYe167210List_D", searchVO);
    }

    /**
	 * YE167210 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167210 �? �??��
	 * @exception
	 */
    public int selectYe167210ListTotCnt(Ye167210SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye167210DAO.selectYe167210ListTotCnt_S", searchVO);
    }

}