package com.app.exterms.yearendtax.server.service.yeta2021.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye167420Srh_2021_VO;
import com.app.exterms.yearendtax.server.vo.Ye167420VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167420_2021_DAO.java
 * @Description : Ye167420 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye167420_2021_DAO")
public class Ye167420_2021_DAO extends EgovAbstractDAO {

	/**
	 * YE167420?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167420VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167420(Ye167420VO vo) throws Exception {
        return (String)insert("ye167420_2021_DAO.insertYe167420_S", vo);
    }

    /**
	 * YE167420?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167420VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167420(Ye167420VO vo) throws Exception {
        update("ye167420_2021_DAO.updateYe167420_S", vo);
    }

    /**
	 * YE167420?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167420VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167420(Ye167420VO vo) throws Exception {
        delete("ye167420_2021_DAO.deleteYe167420_S", vo);
    }

    /**
	 * YE167420?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167420VO
	 * @return 조회?�� YE167420
	 * @exception Exception
	 */
    public Ye167420VO selectYe167420(Ye167420VO vo) throws Exception {
        return (Ye167420VO) selectByPk("ye167420_2021_DAO.selectYe167420_S", vo);
    }

    /**
	 * YE167420 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167420 목록
	 * @exception Exception
	 */
    public List<?> selectYe167420List(Ye167420Srh_2021_VO searchVO) throws Exception {
        return list("ye167420_2021_DAO.selectYe167420List_D", searchVO);
    }

    /**
	 * YE167420 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167420 �? �??��
	 * @exception
	 */
    public int selectYe167420ListTotCnt(Ye167420Srh_2021_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye167420_2021_DAO.selectYe167420ListTotCnt_S", searchVO);
    }

}
