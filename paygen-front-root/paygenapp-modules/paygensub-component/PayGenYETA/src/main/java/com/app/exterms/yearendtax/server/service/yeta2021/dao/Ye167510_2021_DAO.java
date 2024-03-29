package com.app.exterms.yearendtax.server.service.yeta2021.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye167510Srh_2021_VO;
import com.app.exterms.yearendtax.server.vo.Ye167510_2021_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167510_2021_DAO.java
 * @Description : Ye167510 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye167510_2021_DAO")
public class Ye167510_2021_DAO extends EgovAbstractDAO {

	/**
	 * YE167510?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167510VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167510(Ye167510_2021_VO vo) throws Exception {
        return (String)insert("ye167510_2021_DAO.insertYe167510_S", vo);
    }

    /**
	 * YE167510?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167510VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167510(Ye167510_2021_VO vo) throws Exception {
        update("ye167510_2021_DAO.updateYe167510_S", vo);
    }

    /**
	 * YE167510?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167510VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167510(Ye167510_2021_VO vo) throws Exception {
        delete("ye167510_2021_DAO.deleteYe167510_S", vo);
    }

    /**
	 * YE167510?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167510VO
	 * @return 조회?�� YE167510
	 * @exception Exception
	 */
    public Ye167510_2021_VO selectYe167510(Ye167510_2021_VO vo) throws Exception {
        return (Ye167510_2021_VO) selectByPk("ye167510_2021_DAO.selectYe167510_S", vo);
    }

    /**
	 * YE167510 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167510 목록
	 * @exception Exception
	 */
    public List<?> selectYe167510List(Ye167510Srh_2021_VO searchVO) throws Exception {
        return list("ye167510_2021_DAO.selectYe167510List_D", searchVO);
    }

    /**
	 * YE167510 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167510 �? �??��
	 * @exception
	 */
    public int selectYe167510ListTotCnt(Ye167510Srh_2021_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye167510_2021_DAO.selectYe167510ListTotCnt_S", searchVO);
    }

}
