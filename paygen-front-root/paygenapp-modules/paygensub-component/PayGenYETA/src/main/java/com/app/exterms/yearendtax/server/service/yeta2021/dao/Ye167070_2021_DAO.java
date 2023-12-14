package com.app.exterms.yearendtax.server.service.yeta2021.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye167070Srh_2021_VO;
import com.app.exterms.yearendtax.server.vo.Ye167070VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167070_2021_DAO.java
 * @Description : Ye167070 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye167070_2021_DAO")
public class Ye167070_2021_DAO extends EgovAbstractDAO {

	/**
	 * YE167070?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167070VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167070(Ye167070VO vo) throws Exception {
        return (String)insert("ye167070_2021_DAO.insertYe167070_S", vo);
    }

    /**
	 * YE167070?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167070VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167070(Ye167070VO vo) throws Exception {
        update("ye167070_2021_DAO.updateYe167070_S", vo);
    }

    /**
	 * YE167070?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167070VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167070(Ye167070VO vo) throws Exception {
        delete("ye167070_2021_DAO.deleteYe167070_S", vo);
    }

    /**
	 * YE167070?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167070VO
	 * @return 조회?�� YE167070
	 * @exception Exception
	 */
    public Ye167070VO selectYe167070(Ye167070VO vo) throws Exception {
        return (Ye167070VO) selectByPk("ye167070_2021_DAO.selectYe167070_S", vo);
    }

    /**
	 * YE167070 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167070 목록
	 * @exception Exception
	 */
    public List<?> selectYe167070List(Ye167070Srh_2021_VO searchVO) throws Exception {
        return list("ye167070_2021_DAO.selectYe167070List_D", searchVO);
    }

    /**
	 * YE167070 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167070 �? �??��
	 * @exception
	 */
    public int selectYe167070ListTotCnt(Ye167070Srh_2021_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye167070_2021_DAO.selectYe167070ListTotCnt_S", searchVO);
    }

}
