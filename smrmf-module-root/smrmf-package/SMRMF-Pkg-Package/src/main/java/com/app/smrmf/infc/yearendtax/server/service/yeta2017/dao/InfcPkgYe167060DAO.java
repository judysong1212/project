package com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167060SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167060VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye167060DAO.java
 * @Description : Ye167060 DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2017.01.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe167060DAO")
public class InfcPkgYe167060DAO extends EgovAbstractDAO {

	/**
	 * YE167060?�� ?��록한?��.
	 * @param vo - ?��록할 ?��보�? ?���? Ye167060VO
	 * @return ?���? 결과
	 * @exception Exception
	 */
    public String insertYe167060(InfcPkgYe167060VO vo) throws Exception {
        return (String)insert("infcPkgYe167060DAO.insertYe167060_S", vo);
    }

    /**
	 * YE167060?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167060VO
	 * @return void?��
	 * @exception Exception
	 */
    public void updateYe167060(InfcPkgYe167060VO vo) throws Exception {
        update("infcPkgYe167060DAO.updateYe167060_S", vo);
    }

    /**
	 * YE167060?�� ?��?��?��?��.
	 * @param vo - ?��?��?�� ?��보�? ?���? Ye167060VO
	 * @return void?�� 
	 * @exception Exception
	 */
    public void deleteYe167060(InfcPkgYe167060VO vo) throws Exception {
        delete("infcPkgYe167060DAO.deleteYe167060_S", vo);
    }

    /**
	 * YE167060?�� 조회?��?��.
	 * @param vo - 조회?�� ?��보�? ?���? Ye167060VO
	 * @return 조회?�� YE167060
	 * @exception Exception
	 */
    public InfcPkgYe167060VO selectYe167060(InfcPkgYe167060VO vo) throws Exception {
        return (InfcPkgYe167060VO) selectByPk("infcPkgYe167060DAO.selectYe167060_S", vo);
    }

    /**
	 * YE167060 목록?�� 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167060 목록
	 * @exception Exception
	 */
    public List<?> selectYe167060List(InfcPkgYe167060SrhVO searchVO) throws Exception {
        return list("infcPkgYe167060DAO.selectYe167060List_D", searchVO);
    }

    /**
	 * YE167060 �? �??���? 조회?��?��.
	 * @param searchMap - 조회?�� ?��보�? ?���? Map
	 * @return YE167060 �? �??��
	 * @exception
	 */
    public int selectYe167060ListTotCnt(InfcPkgYe167060SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe167060DAO.selectYe167060ListTotCnt_S", searchVO);
    }

}
