package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye167410SrhVO;
import com.app.exterms.yearendtax.server.vo.Ye167410VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167410DAO.java
 * @Description : Ye167410 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye167410DAO")
public class Ye167410DAO extends EgovAbstractDAO {

	/**
	 * YE167410?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167410VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167410(Ye167410VO vo) throws Exception {
        return (String)insert("ye167410DAO.insertYe167410_S", vo);
    }

    /**
	 * YE167410?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167410VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167410(Ye167410VO vo) throws Exception {
        update("ye167410DAO.updateYe167410_S", vo);
    }

    /**
	 * YE167410?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167410VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167410(Ye167410VO vo) throws Exception {
        delete("ye167410DAO.deleteYe167410_S", vo);
    }

    /**
	 * YE167410?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167410VO
	 * @return 조회?�� YE167410
	 * @exception Exception
	 */
    public Ye167410VO selectYe167410(Ye167410VO vo) throws Exception {
        return (Ye167410VO) selectByPk("ye167410DAO.selectYe167410_S", vo);
    }

    /**
	 * YE167410 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167410 목록
	 * @exception Exception
	 */
    public List<?> selectYe167410List(Ye167410SrhVO searchVO) throws Exception {
        return list("ye167410DAO.selectYe167410List_D", searchVO);
    }

    /**
	 * YE167410 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167410 �? �??��
	 * @exception
	 */
    public int selectYe167410ListTotCnt(Ye167410SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye167410DAO.selectYe167410ListTotCnt_S", searchVO);
    }

}
