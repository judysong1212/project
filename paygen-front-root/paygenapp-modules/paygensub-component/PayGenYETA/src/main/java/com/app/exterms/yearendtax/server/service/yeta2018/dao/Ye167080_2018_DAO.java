package com.app.exterms.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye167080Srh_2018_VO;
import com.app.exterms.yearendtax.server.vo.Ye167080VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167080_2018_DAO.java
 * @Description : Ye167080 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye167080_2018_DAO")
public class Ye167080_2018_DAO extends EgovAbstractDAO {

	/**
	 * YE167080?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167080VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167080(Ye167080VO vo) throws Exception {
        return (String)insert("ye167080_2018_DAO.insertYe167080_S", vo);
    }

    /**
	 * YE167080?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167080VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167080(Ye167080VO vo) throws Exception {
        update("ye167080_2018_DAO.updateYe167080_S", vo);
    }

    /**
	 * YE167080?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167080VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167080(Ye167080VO vo) throws Exception {
        delete("ye167080_2018_DAO.deleteYe167080_S", vo);
    }

    /**
	 * YE167080?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167080VO
	 * @return 조회?�� YE167080
	 * @exception Exception
	 */
    public Ye167080VO selectYe167080(Ye167080VO vo) throws Exception {
        return (Ye167080VO) selectByPk("ye167080_2018_DAO.selectYe167080_S", vo);
    }

    /**
	 * YE167080 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167080 목록
	 * @exception Exception
	 */
    public List<?> selectYe167080List(Ye167080Srh_2018_VO searchVO) throws Exception {
        return list("ye167080_2018_DAO.selectYe167080List_D", searchVO);
    }

    /**
	 * YE167080 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167080 �? �??��
	 * @exception
	 */
    public int selectYe167080ListTotCnt(Ye167080Srh_2018_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye167080_2018_DAO.selectYe167080ListTotCnt_S", searchVO);
    }

}
