package com.app.exterms.yearendtax.server.service.yeta2023.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye167440Srh_2023_VO;
import com.app.exterms.yearendtax.server.vo.Ye167440_2023_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167440_2023_DAO.java
 * @Description : Ye167440 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye167440_2023_DAO")
public class Ye167440_2023_DAO extends EgovAbstractDAO {

	/**
	 * YE167440?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167440VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167440(Ye167440_2023_VO vo) throws Exception {
        return (String)insert("ye167440_2023_DAO.insertYe167440_S", vo);
    }

    /**
	 * YE167440?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167440VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167440(Ye167440_2023_VO vo) throws Exception {
        update("ye167440_2023_DAO.updateYe167440_S", vo);
    }

    /**
	 * YE167440?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167440VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167440(Ye167440_2023_VO vo) throws Exception {
        delete("ye167440_2023_DAO.deleteYe167440_S", vo);
    }

    /**
	 * YE167440?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167440VO
	 * @return 조회?�� YE167440
	 * @exception Exception
	 */
    public Ye167440_2023_VO selectYe167440(Ye167440_2023_VO vo) throws Exception {
        return (Ye167440_2023_VO) selectByPk("ye167440_2023_DAO.selectYe167440_S", vo);
    }

    /**
	 * YE167440 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167440 목록
	 * @exception Exception
	 */
    public List<?> selectYe167440List(Ye167440Srh_2023_VO searchVO) throws Exception {
        return list("ye167440_2023_DAO.selectYe167440List_D", searchVO);
    }

    /**
	 * YE167440 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167440 �? �??��
	 * @exception
	 */
    public int selectYe167440ListTotCnt(Ye167440Srh_2023_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye167440_2023_DAO.selectYe167440ListTotCnt_S", searchVO);
    }

}
