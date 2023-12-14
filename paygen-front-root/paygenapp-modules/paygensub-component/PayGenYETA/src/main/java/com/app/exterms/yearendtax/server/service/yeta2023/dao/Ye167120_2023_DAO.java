package com.app.exterms.yearendtax.server.service.yeta2023.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye167120Srh_2023_VO;
import com.app.exterms.yearendtax.server.vo.Ye167120VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167120_2023_DAO.java
 * @Description : Ye167120 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye167120_2023_DAO")
public class Ye167120_2023_DAO extends EgovAbstractDAO {

	/**
	 * YE167120?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167120VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167120(Ye167120VO vo) throws Exception {
        return (String)insert("ye167120_2023_DAO.insertYe167120_S", vo);
    }

    /**
	 * YE167120?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167120VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167120(Ye167120VO vo) throws Exception {
        update("ye167120_2023_DAO.updateYe167120_S", vo);
    }

    /**
	 * YE167120?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167120VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167120(Ye167120VO vo) throws Exception {
        delete("ye167120_2023_DAO.deleteYe167120_S", vo);
    }

    /**
	 * YE167120?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167120VO
	 * @return 조회?�� YE167120
	 * @exception Exception
	 */
    public Ye167120VO selectYe167120(Ye167120VO vo) throws Exception {
        return (Ye167120VO) selectByPk("ye167120_2023_DAO.selectYe167120_S", vo);
    }

    /**
	 * YE167120 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167120 목록
	 * @exception Exception
	 */
    public List<?> selectYe167120List(Ye167120Srh_2023_VO searchVO) throws Exception {
        return list("ye167120_2023_DAO.selectYe167120List_D", searchVO);
    }

    /**
	 * YE167120 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167120 �? �??��
	 * @exception
	 */
    public int selectYe167120ListTotCnt(Ye167120Srh_2023_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye167120_2023_DAO.selectYe167120ListTotCnt_S", searchVO);
    }

}
