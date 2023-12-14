package com.app.exterms.yearendtax.server.service.yeta2022.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye167050Srh_2022_VO;
import com.app.exterms.yearendtax.server.vo.Ye167050VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167050_2022_DAO.java
 * @Description : Ye167050 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye167050_2022_DAO")
public class Ye167050_2022_DAO extends EgovAbstractDAO {

	/**
	 * YE167050?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167050VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167050(Ye167050VO vo) throws Exception {
        return (String)insert("ye167050_2022_DAO.insertYe167050_S", vo);
    }

    /**
	 * YE167050?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167050VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167050(Ye167050VO vo) throws Exception {
        update("ye167050_2022_DAO.updateYe167050_S", vo);
    }

    /**
	 * YE167050?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167050VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167050(Ye167050VO vo) throws Exception {
        delete("ye167050_2022_DAO.deleteYe167050_S", vo);
    }

    /**
	 * YE167050?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167050VO
	 * @return 조회?�� YE167050
	 * @exception Exception
	 */
    public Ye167050VO selectYe167050(Ye167050VO vo) throws Exception {
        return (Ye167050VO) selectByPk("ye167050_2022_DAO.selectYe167050_S", vo);
    }

    /**
	 * YE167050 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167050 목록
	 * @exception Exception
	 */
    public List<?> selectYe167050List(Ye167050Srh_2022_VO searchVO) throws Exception {
        return list("ye167050_2022_DAO.selectYe167050List_D", searchVO);
    }

    /**
	 * YE167050 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167050 �? �??��
	 * @exception
	 */
    public int selectYe167050ListTotCnt(Ye167050Srh_2022_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye167050_2022_DAO.selectYe167050ListTotCnt_S", searchVO);
    }

}
