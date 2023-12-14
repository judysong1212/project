package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye167040SrhVO;
import com.app.exterms.yearendtax.server.vo.Ye167040VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167040DAO.java
 * @Description : Ye167040 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye167040DAO")
public class Ye167040DAO extends EgovAbstractDAO {

	/**
	 * YE167040?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167040VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167040(Ye167040VO vo) throws Exception {
        return (String)insert("ye167040DAO.insertYe167040_S", vo);
    }

    /**
	 * YE167040?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167040VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167040(Ye167040VO vo) throws Exception {
        update("ye167040DAO.updateYe167040_S", vo);
    }

    /**
	 * YE167040?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167040VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167040(Ye167040VO vo) throws Exception {
        delete("ye167040DAO.deleteYe167040_S", vo);
    }

    /**
	 * YE167040?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167040VO
	 * @return 조회?�� YE167040
	 * @exception Exception
	 */
    public Ye167040VO selectYe167040(Ye167040VO vo) throws Exception {
        return (Ye167040VO) selectByPk("ye167040DAO.selectYe167040_S", vo);
    }

    /**
	 * YE167040 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167040 목록
	 * @exception Exception
	 */
    public List<?> selectYe167040List(Ye167040SrhVO searchVO) throws Exception {
        return list("ye167040DAO.selectYe167040List_D", searchVO);
    }

    /**
	 * YE167040 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167040 �? �??��
	 * @exception
	 */
    public int selectYe167040ListTotCnt(Ye167040SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye167040DAO.selectYe167040ListTotCnt_S", searchVO);
    }

}