package com.app.exterms.yearendtax.server.service.yeta2020.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye167150Srh_2020_VO;
import com.app.exterms.yearendtax.server.vo.Ye167150VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167150_2020_DAO.java
 * @Description : Ye167150 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye167150_2020_DAO")
public class Ye167150_2020_DAO extends EgovAbstractDAO {

	/**
	 * YE167150?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167150VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167150(Ye167150VO vo) throws Exception {
        return (String)insert("ye167150_2020_DAO.insertYe167150_S", vo);
    }

    /**
	 * YE167150?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167150VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167150(Ye167150VO vo) throws Exception {
        update("ye167150_2020_DAO.updateYe167150_S", vo);
    }

    /**
	 * YE167150?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167150VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167150(Ye167150VO vo) throws Exception {
        delete("ye167150_2020_DAO.deleteYe167150_S", vo);
    }

    /**
	 * YE167150?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167150VO
	 * @return 조회?�� YE167150
	 * @exception Exception
	 */
    public Ye167150VO selectYe167150(Ye167150VO vo) throws Exception {
        return (Ye167150VO) selectByPk("ye167150_2020_DAO.selectYe167150_S", vo);
    }

    /**
	 * YE167150 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167150 목록
	 * @exception Exception
	 */
    public List<?> selectYe167150List(Ye167150Srh_2020_VO searchVO) throws Exception {
        return list("ye167150_2020_DAO.selectYe167150List_D", searchVO);
    }

    /**
	 * YE167150 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167150 �? �??��
	 * @exception
	 */
    public int selectYe167150ListTotCnt(Ye167150Srh_2020_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye167150_2020_DAO.selectYe167150ListTotCnt_S", searchVO);
    }

}
