package com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.tax.service.impl.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3180SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3180VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Yeta3180DAO.java
 * @Description : Yeta3180 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2016.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("YetaPrc3180DAO")
public class YetaPrc3180DAO extends EgovAbstractDAO {

	/**
	 * YETA3180을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta3180VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String insertYeta3180(InfcPkgYeta3180VO vo) throws Exception {
        return (String)insert("yetaPrc3180DAO.insertYetaPrc3180_S", vo);
    }
	  @Transactional
    public String fnPayr06430_PAYR440_2014_1_Insert(InfcPkgYeta3180VO vo) throws Exception {
        return (String)insert("yetaPrc3180DAO.fnPayr06430_PAYR440_2014_1_Insert", vo);
    }
    

    /**
	 * YETA3180을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta3180VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
    public void updateYeta3180(InfcPkgYeta3180VO vo) throws Exception {
        update("yetaPrc3180DAO.updateYetaPrc3180_S", vo);
    }

    /**
	 * YETA3180을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3180VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void deleteYeta3180(InfcPkgYeta3180VO vo) throws Exception {
        delete("yetaPrc3180DAO.deleteYetaPrc3180_S", vo);
    }
	  @Transactional
    public void fnPayr06430_PAYR440_2014_Delete(InfcPkgYeta3180VO vo) throws Exception {
        delete("yetaPrc3180DAO.fnPayr06430_PAYR440_2014_Delete", vo);
    }
     
     
    /**
	 * YETA3180을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3180VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void fnPayr06430_PAYR440_CREATE_Delete(InfcPkgYeta3180VO vo) throws Exception {
        delete("yetaPrc3180DAO.fnPayr06430_PAYR440_CREATE_Delete_S", vo);
    } 
        
    /**
	 * YETA3180을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta3180VO
	 * @return 조회한 YETA3180
	 * @exception Exception
	 */
    public InfcPkgYeta3180VO selectYeta3180(InfcPkgYeta3180VO vo) throws Exception {
        return (InfcPkgYeta3180VO) selectByPk("yetaPrc3180DAO.selectYetaPrc3180_S", vo);
    }

    /**
	 * YETA3180 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3180 목록
	 * @exception Exception
	 */
    public List<?> selectYeta3180List(InfcPkgYeta3180SrhVO searchVO) throws Exception {
        return list("yetaPrc3180DAO.selectYetaPrc3180List_D", searchVO);
    }

    /**
	 * YETA3180 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3180 총 갯수
	 * @exception
	 */
    public int selectYeta3180ListTotCnt(InfcPkgYeta3180SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("yetaPrc3180DAO.selectYetaPrc3180ListTotCnt_S", searchVO);
    }

}
