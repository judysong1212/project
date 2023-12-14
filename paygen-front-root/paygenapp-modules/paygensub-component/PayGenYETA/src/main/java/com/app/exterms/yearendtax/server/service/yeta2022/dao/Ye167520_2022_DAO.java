package com.app.exterms.yearendtax.server.service.yeta2022.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye167520Srh_2022_VO;
import com.app.exterms.yearendtax.server.vo.Ye167520_2022_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167520_2022_DAO.java
 * @Description : Ye167520 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye167520_2022_DAO")
public class Ye167520_2022_DAO extends EgovAbstractDAO {

	/**
	 * YE167520?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167520VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167520(Ye167520_2022_VO vo) throws Exception {
        return (String)insert("ye167520_2022_DAO.insertYe167520_S", vo);
    }

    /**
	 * YE167520?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167520VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167520(Ye167520_2022_VO vo) throws Exception {
        update("ye167520_2022_DAO.updateYe167520_S", vo);
    }

    /**
	 * YE167520?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167520VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167520(Ye167520_2022_VO vo) throws Exception {
        delete("ye167520_2022_DAO.deleteYe167520_S", vo);
    }

    /**
	 * YE167520?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167520VO
	 * @return 조회?�� YE167520
	 * @exception Exception
	 */
    public Ye167520_2022_VO selectYe167520(Ye167520_2022_VO vo) throws Exception {
        return (Ye167520_2022_VO) selectByPk("ye167520_2022_DAO.selectYe167520_S", vo);
    }

    /**
	 * YE167520 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167520 목록
	 * @exception Exception
	 */
    public List<?> selectYe167520List(Ye167520Srh_2022_VO searchVO) throws Exception {
        return list("ye167520_2022_DAO.selectYe167520List_D", searchVO);
    }

    /**
	 * YE167520 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167520 �? �??��
	 * @exception
	 */
    public int selectYe167520ListTotCnt(Ye167520Srh_2022_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye167520_2022_DAO.selectYe167520ListTotCnt_S", searchVO);
    }

}
