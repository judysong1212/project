package com.app.exterms.yearendtax.server.service.yeta2020.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye167110Srh_2020_VO;
import com.app.exterms.yearendtax.server.vo.Ye167110VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167110_2020_DAO.java
 * @Description : Ye167110 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye167110_2020_DAO")
public class Ye167110_2020_DAO extends EgovAbstractDAO {

	/**
	 * YE167110?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167110VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167110(Ye167110VO vo) throws Exception {
        return (String)insert("ye167110_2020_DAO.insertYe167110_S", vo);
    }

    /**
	 * YE167110?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167110VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167110(Ye167110VO vo) throws Exception {
        update("ye167110_2020_DAO.updateYe167110_S", vo);
    }

    /**
	 * YE167110?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167110VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167110(Ye167110VO vo) throws Exception {
        delete("ye167110_2020_DAO.deleteYe167110_S", vo);
    }

    /**
	 * YE167110?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167110VO
	 * @return 조회?�� YE167110
	 * @exception Exception
	 */
    public Ye167110VO selectYe167110(Ye167110VO vo) throws Exception {
        return (Ye167110VO) selectByPk("ye167110_2020_DAO.selectYe167110_S", vo);
    }

    /**
	 * YE167110 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167110 목록
	 * @exception Exception
	 */
    public List<?> selectYe167110List(Ye167110Srh_2020_VO searchVO) throws Exception {
        return list("ye167110_2020_DAO.selectYe167110List_D", searchVO);
    }

    /**
	 * YE167110 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167110 �? �??��
	 * @exception
	 */
    public int selectYe167110ListTotCnt(Ye167110Srh_2020_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye167110_2020_DAO.selectYe167110ListTotCnt_S", searchVO);
    }

}
