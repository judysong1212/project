package com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe167510Srh_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe167510_2023_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167510_2023_DAO.java
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

@Repository("InfcPkgYe167510_2023_DAO")
public class InfcPkgYe167510_2023_DAO extends EgovAbstractDAO {

	/**
	 * YE167510?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167510VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167510(InfcPkgYe167510_2023_VO vo) throws Exception {
        return (String)insert("infcPkgYe167510_2023_DAO.insertYe167510_S", vo);
    }

    /**
	 * YE167510?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167510VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167510(InfcPkgYe167510_2023_VO vo) throws Exception {
        update("infcPkgYe167510_2023_DAO.updateYe167510_S", vo);
    }

    /**
	 * YE167510?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167510VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167510(InfcPkgYe167510_2023_VO vo) throws Exception {
        delete("infcPkgYe167510_2023_DAO.deleteYe167510_S", vo);
    }

    /**
	 * YE167510?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167510VO
	 * @return 조회?�� YE167510
	 * @exception Exception
	 */
    public InfcPkgYe167510_2023_VO selectYe167510(InfcPkgYe167510_2023_VO vo) throws Exception {
        return (InfcPkgYe167510_2023_VO) selectByPk("infcPkgYe167510_2023_DAO.selectYe167510_S", vo);
    }

    /**
	 * YE167510 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167510 목록
	 * @exception Exception
	 */
    public List<?> selectYe167510List(InfcPkgYe167510Srh_2023_VO searchVO) throws Exception {
        return list("infcPkgYe167510_2023_DAO.selectYe167510List_D", searchVO);
    }

    /**
	 * YE167510 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167510 �? �??��
	 * @exception
	 */
    public int selectYe167510ListTotCnt(InfcPkgYe167510Srh_2023_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe167510_2023_DAO.selectYe167510ListTotCnt_S", searchVO);
    }

}
