package com.app.exterms.yearendtax.server.service.yeta2020.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye167140Srh_2020_VO;
import com.app.exterms.yearendtax.server.vo.Ye167140VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167140_2020_DAO.java
 * @Description : Ye167140 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye167140_2020_DAO")
public class Ye167140_2020_DAO extends EgovAbstractDAO {

	/**
	 * YE167140?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167140VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167140(Ye167140VO vo) throws Exception {
        return (String)insert("ye167140_2020_DAO.insertYe167140_S", vo);
    }

    /**
	 * YE167140?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167140VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167140(Ye167140VO vo) throws Exception {
        update("ye167140_2020_DAO.updateYe167140_S", vo);
    }

    /**
	 * YE167140?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167140VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167140(Ye167140VO vo) throws Exception {
        delete("ye167140_2020_DAO.deleteYe167140_S", vo);
    }

    /**
	 * YE167140?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167140VO
	 * @return 조회?�� YE167140
	 * @exception Exception
	 */
    public Ye167140VO selectYe167140(Ye167140VO vo) throws Exception {
        return (Ye167140VO) selectByPk("ye167140_2020_DAO.selectYe167140_S", vo);
    }

    /**
	 * YE167140 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167140 목록
	 * @exception Exception
	 */
    public List<?> selectYe167140List(Ye167140Srh_2020_VO searchVO) throws Exception {
        return list("ye167140_2020_DAO.selectYe167140List_D", searchVO);
    }

    /**
	 * YE167140 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167140 �? �??��
	 * @exception
	 */
    public int selectYe167140ListTotCnt(Ye167140Srh_2020_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye167140_2020_DAO.selectYe167140ListTotCnt_S", searchVO);
    }

}
