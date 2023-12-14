package com.app.exterms.yearendtax.server.service.yeta2023.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye167430Srh_2023_VO;
import com.app.exterms.yearendtax.server.vo.Ye167430VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167430_2023_DAO.java
 * @Description : Ye167430 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye167430_2023_DAO")
public class Ye167430_2023_DAO extends EgovAbstractDAO {

	/**
	 * YE167430?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167430VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167430(Ye167430VO vo) throws Exception {
        return (String)insert("ye167430_2023_DAO.insertYe167430_S", vo);
    }

    /**
	 * YE167430?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167430VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167430(Ye167430VO vo) throws Exception {
        update("ye167430_2023_DAO.updateYe167430_S", vo);
    }

    /**
	 * YE167430?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167430VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167430(Ye167430VO vo) throws Exception {
        delete("ye167430_2023_DAO.deleteYe167430_S", vo);
    }

    /**
	 * YE167430?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167430VO
	 * @return 조회?�� YE167430
	 * @exception Exception
	 */
    public Ye167430VO selectYe167430(Ye167430VO vo) throws Exception {
        return (Ye167430VO) selectByPk("ye167430_2023_DAO.selectYe167430_S", vo);
    }

    /**
	 * YE167430 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167430 목록
	 * @exception Exception
	 */
    public List<?> selectYe167430List(Ye167430Srh_2023_VO searchVO) throws Exception {
        return list("ye167430_2023_DAO.selectYe167430List_D", searchVO);
    }

    /**
	 * YE167430 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167430 �? �??��
	 * @exception
	 */
    public int selectYe167430ListTotCnt(Ye167430Srh_2023_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye167430_2023_DAO.selectYe167430ListTotCnt_S", searchVO);
    }

}
