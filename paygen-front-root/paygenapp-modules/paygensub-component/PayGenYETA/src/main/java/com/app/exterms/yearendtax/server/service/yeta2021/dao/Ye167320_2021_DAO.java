package com.app.exterms.yearendtax.server.service.yeta2021.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye167320Srh_2021_VO;
import com.app.exterms.yearendtax.server.vo.Ye167320VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167320_2021_DAO.java
 * @Description : Ye167320 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye167320_2021_DAO")
public class Ye167320_2021_DAO extends EgovAbstractDAO {

	/**
	 * YE167320?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167320VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167320(Ye167320VO vo) throws Exception {
        return (String)insert("ye167320_2021_DAO.insertYe167320_S", vo);
    }

    /**
	 * YE167320?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167320VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167320(Ye167320VO vo) throws Exception {
        update("ye167320_2021_DAO.updateYe167320_S", vo);
    }

    /**
	 * YE167320?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167320VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167320(Ye167320VO vo) throws Exception {
        delete("ye167320_2021_DAO.deleteYe167320_S", vo);
    }

    /**
	 * YE167320?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167320VO
	 * @return 조회?�� YE167320
	 * @exception Exception
	 */
    public Ye167320VO selectYe167320(Ye167320VO vo) throws Exception {
        return (Ye167320VO) selectByPk("ye167320_2021_DAO.selectYe167320_S", vo);
    }

    /**
	 * YE167320 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167320 목록
	 * @exception Exception
	 */
    public List<?> selectYe167320List(Ye167320Srh_2021_VO searchVO) throws Exception {
        return list("ye167320_2021_DAO.selectYe167320List_D", searchVO);
    }

    /**
	 * YE167320 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167320 �? �??��
	 * @exception
	 */
    public int selectYe167320ListTotCnt(Ye167320Srh_2021_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye167320_2021_DAO.selectYe167320ListTotCnt_S", searchVO);
    }

}
