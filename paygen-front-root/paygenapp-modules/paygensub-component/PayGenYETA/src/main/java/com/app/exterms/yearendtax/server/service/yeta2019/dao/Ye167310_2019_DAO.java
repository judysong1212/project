package com.app.exterms.yearendtax.server.service.yeta2019.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye167310Srh_2019_VO;
import com.app.exterms.yearendtax.server.vo.Ye167310VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167310_2019_DAO.java
 * @Description : Ye167310 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye167310_2019_DAO")
public class Ye167310_2019_DAO extends EgovAbstractDAO {

	/**
	 * YE167310?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167310VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167310(Ye167310VO vo) throws Exception {
        return (String)insert("ye167310_2019_DAO.insertYe167310_S", vo);
    }

    /**
	 * YE167310?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167310VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167310(Ye167310VO vo) throws Exception {
        update("ye167310_2019_DAO.updateYe167310_S", vo);
    }

    /**
	 * YE167310?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167310VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167310(Ye167310VO vo) throws Exception {
        delete("ye167310_2019_DAO.deleteYe167310_S", vo);
    }

    /**
	 * YE167310?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167310VO
	 * @return 조회?�� YE167310
	 * @exception Exception
	 */
    public Ye167310VO selectYe167310(Ye167310VO vo) throws Exception {
        return (Ye167310VO) selectByPk("ye167310_2019_DAO.selectYe167310_S", vo);
    }

    /**
	 * YE167310 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167310 목록
	 * @exception Exception
	 */
    public List<?> selectYe167310List(Ye167310Srh_2019_VO searchVO) throws Exception {
        return list("ye167310_2019_DAO.selectYe167310List_D", searchVO);
    }

    /**
	 * YE167310 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167310 �? �??��
	 * @exception
	 */
    public int selectYe167310ListTotCnt(Ye167310Srh_2019_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye167310_2019_DAO.selectYe167310ListTotCnt_S", searchVO);
    }

}
