package com.app.exterms.yearendtax.server.service.yeta2020.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye167030Srh_2020_VO;
import com.app.exterms.yearendtax.server.vo.Ye167030VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167030_2020_DAO.java
 * @Description : Ye167030 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye167030_2020_DAO")
public class Ye167030_2020_DAO extends EgovAbstractDAO {

	/**
	 * YE167030?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167030VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167030(Ye167030VO vo) throws Exception {
        return (String)insert("ye167030_2020_DAO.insertYe167030_S", vo);
    }

    /**
	 * YE167030?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167030VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167030(Ye167030VO vo) throws Exception {
        update("ye167030_2020_DAO.updateYe167030_S", vo);
    }

    /**
	 * YE167030?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167030VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167030(Ye167030VO vo) throws Exception {
        delete("ye167030_2020_DAO.deleteYe167030_S", vo);
    }

    /**
	 * YE167030?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167030VO
	 * @return 조회?�� YE167030
	 * @exception Exception
	 */
    public Ye167030VO selectYe167030(Ye167030VO vo) throws Exception {
        return (Ye167030VO) selectByPk("ye167030_2020_DAO.selectYe167030_S", vo);
    }

    /**
	 * YE167030 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167030 목록
	 * @exception Exception
	 */
    public List<?> selectYe167030List(Ye167030Srh_2020_VO searchVO) throws Exception {
        return list("ye167030_2020_DAO.selectYe167030List_D", searchVO);
    }

    /**
	 * YE167030 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167030 �? �??��
	 * @exception
	 */
    public int selectYe167030ListTotCnt(Ye167030Srh_2020_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye167030_2020_DAO.selectYe167030ListTotCnt_S", searchVO);
    }

}
