package com.app.exterms.yearendtax.server.service.yeta2019.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye167010Srh_2019_VO;
import com.app.exterms.yearendtax.server.vo.Ye167010VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167010_2019_DAO.java
 * @Description : Ye167010 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye167010_2019_DAO")
public class Ye167010_2019_DAO extends EgovAbstractDAO {

	/**
	 * YE167010?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167010VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167010(Ye167010VO vo) throws Exception {
        return (String)insert("ye167010_2019_DAO.insertYe167010_S", vo);
    }

    /**
	 * YE167010?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167010VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167010(Ye167010VO vo) throws Exception {
        update("ye167010_2019_DAO.updateYe167010_S", vo);
    }

    /**
	 * YE167010?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167010VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167010(Ye167010VO vo) throws Exception {
        delete("ye167010_2019_DAO.deleteYe167010_S", vo);
    }

    /**
	 * YE167010?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167010VO
	 * @return 조회?�� YE167010
	 * @exception Exception
	 */
    public Ye167010VO selectYe167010(Ye167010VO vo) throws Exception {
        return (Ye167010VO) selectByPk("ye167010_2019_DAO.selectYe167010_S", vo);
    }

    /**
	 * YE167010 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167010 목록
	 * @exception Exception
	 */
    public List<?> selectYe167010List(Ye167010Srh_2019_VO searchVO) throws Exception {
        return list("ye167010_2019_DAO.selectYe167010List_D", searchVO);
    }

    /**
	 * YE167010 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167010 �? �??��
	 * @exception
	 */
    public int selectYe167010ListTotCnt(Ye167010Srh_2019_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye167010_2019_DAO.selectYe167010ListTotCnt_S", searchVO);
    }

}
