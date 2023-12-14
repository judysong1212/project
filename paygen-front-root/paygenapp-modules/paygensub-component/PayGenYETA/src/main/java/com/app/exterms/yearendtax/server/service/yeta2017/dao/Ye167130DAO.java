package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye167130SrhVO;
import com.app.exterms.yearendtax.server.vo.Ye167130VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167130DAO.java
 * @Description : Ye167130 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye167130DAO")
public class Ye167130DAO extends EgovAbstractDAO {

	/**
	 * YE167130?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167130VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167130(Ye167130VO vo) throws Exception {
        return (String)insert("ye167130DAO.insertYe167130_S", vo);
    }

    /**
	 * YE167130?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167130VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167130(Ye167130VO vo) throws Exception {
        update("ye167130DAO.updateYe167130_S", vo);
    }

    /**
	 * YE167130?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167130VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167130(Ye167130VO vo) throws Exception {
        delete("ye167130DAO.deleteYe167130_S", vo);
    }

    /**
	 * YE167130?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167130VO
	 * @return 조회?�� YE167130
	 * @exception Exception
	 */
    public Ye167130VO selectYe167130(Ye167130VO vo) throws Exception {
        return (Ye167130VO) selectByPk("ye167130DAO.selectYe167130_S", vo);
    }

    /**
	 * YE167130 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167130 목록
	 * @exception Exception
	 */
    public List<?> selectYe167130List(Ye167130SrhVO searchVO) throws Exception {
        return list("ye167130DAO.selectYe167130List_D", searchVO);
    }

    /**
	 * YE167130 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167130 �? �??��
	 * @exception
	 */
    public int selectYe167130ListTotCnt(Ye167130SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye167130DAO.selectYe167130ListTotCnt_S", searchVO);
    }

}
