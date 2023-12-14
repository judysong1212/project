package com.app.exterms.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye167220Srh_2018_VO;
import com.app.exterms.yearendtax.server.vo.Ye167220VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167220_2018_DAO.java
 * @Description : Ye167220 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2016.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye167220_2018_DAO")
public class Ye167220_2018_DAO extends EgovAbstractDAO {

	/**
	 * YE167220?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167220VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167220(Ye167220VO vo) throws Exception {
        return (String)insert("ye167220_2018_DAO.insertYe167220_S", vo);
    }

    /**
	 * YE167220?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167220VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167220(Ye167220VO vo) throws Exception {
        update("ye167220_2018_DAO.updateYe167220_S", vo);
    }

    /**
	 * YE167220?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167220VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167220(Ye167220VO vo) throws Exception {
        delete("ye167220_2018_DAO.deleteYe167220_S", vo);
    }

    /**
	 * YE167220?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167220VO
	 * @return 조회?�� YE167220
	 * @exception Exception
	 */
    public Ye167220VO selectYe167220(Ye167220VO vo) throws Exception {
        return (Ye167220VO) selectByPk("ye167220_2018_DAO.selectYe167220_S", vo);
    }

    /**
	 * YE167220 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167220 목록
	 * @exception Exception
	 */
    public List<?> selectYe167220List(Ye167220Srh_2018_VO searchVO) throws Exception {
        return list("ye167220_2018_DAO.selectYe167220List_D", searchVO);
    }

    /**
	 * YE167220 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167220 �? �??��
	 * @exception
	 */
    public int selectYe167220ListTotCnt(Ye167220Srh_2018_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye167220_2018_DAO.selectYe167220ListTotCnt_S", searchVO);
    }

}
