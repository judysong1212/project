package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye167520SrhVO;
import com.app.exterms.yearendtax.server.vo.Ye167520VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167520DAO.java
 * @Description : Ye167520 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye167520DAO")
public class Ye167520DAO extends EgovAbstractDAO {

	/**
	 * YE167520?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167520VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167520(Ye167520VO vo) throws Exception {
        return (String)insert("ye167520DAO.insertYe167520_S", vo);
    }

    /**
	 * YE167520?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167520VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167520(Ye167520VO vo) throws Exception {
        update("ye167520DAO.updateYe167520_S", vo);
    }

    /**
	 * YE167520?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167520VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167520(Ye167520VO vo) throws Exception {
        delete("ye167520DAO.deleteYe167520_S", vo);
    }

    /**
	 * YE167520?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167520VO
	 * @return 조회?�� YE167520
	 * @exception Exception
	 */
    public Ye167520VO selectYe167520(Ye167520VO vo) throws Exception {
        return (Ye167520VO) selectByPk("ye167520DAO.selectYe167520_S", vo);
    }

    /**
	 * YE167520 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167520 목록
	 * @exception Exception
	 */
    public List<?> selectYe167520List(Ye167520SrhVO searchVO) throws Exception {
        return list("ye167520DAO.selectYe167520List_D", searchVO);
    }

    /**
	 * YE167520 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167520 �? �??��
	 * @exception
	 */
    public int selectYe167520ListTotCnt(Ye167520SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye167520DAO.selectYe167520ListTotCnt_S", searchVO);
    }

}
