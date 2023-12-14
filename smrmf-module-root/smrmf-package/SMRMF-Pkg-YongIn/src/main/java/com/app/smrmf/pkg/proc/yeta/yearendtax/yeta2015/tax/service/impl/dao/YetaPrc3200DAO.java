package com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.tax.service.impl.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta2000VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3200SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3200VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Yeta3200DAO.java
 * @Description : Yeta3200 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2016.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("YetaPrc3200DAO")
public class YetaPrc3200DAO extends EgovAbstractDAO {



	/**
	 * YETA3200을 등록한다. yeta0100 화면 연말정산 대상자 생성시 비과세 감면 내역 생성로직 
	 * @param vo - 등록할 정보가 담긴 Yeta3200VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String fnPayr06420_YETA3200_2015_CREATE_Insert(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
        return (String)insert("yetaPrc3200DAO.fnPayr06420_YETA3200_2015_CREATE_Insert_S", yetaPrc2000Vo);
    } 
   
    
    	/**
	 * YETA3200을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta3200VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String insertYeta3200(InfcPkgYeta3200VO vo) throws Exception {
        return (String)insert("yetaPrc3200DAO.insertYetaPrc3200_S", vo);
    }
    
    
    /**
	 * YETA3200을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta3200VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
    public void updateYeta3200(InfcPkgYeta3200VO vo) throws Exception {
        update("yetaPrc3200DAO.updateYetaPrc3200_S", vo);
    }
	  @Transactional
    public void fnPayr06420_YETA3200_2015_CREATE1_Update(InfcPkgYeta2000VO vo) throws Exception {
        update("yetaPrc3200DAO.fnPayr06420_YETA3200_2015_CREATE1_Update", vo);
    } 
    
    
    /**
	 * YETA3200을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3200VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void deleteYeta3200(InfcPkgYeta3200VO vo) throws Exception {
        delete("yetaPrc3200DAO.deleteYetaPrc3200_S", vo);
    }
	  @Transactional
    public void fnPayr06430_Yeta3200_CREATE_Delete(InfcPkgYeta3200VO vo) throws Exception {
        delete("yetaPrc3200DAO.fnPayr06430_Yeta3200_CREATE_Delete_S", vo);
    }
    
    
    

    /**
	 * YETA3200을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta3200VO
	 * @return 조회한 YETA3200
	 * @exception Exception
	 */
    public InfcPkgYeta3200VO selectYeta3200(InfcPkgYeta3200VO vo) throws Exception {
        return (InfcPkgYeta3200VO) selectByPk("yetaPrc3200DAO.selectYetaPrc3200_S", vo);
    }

    /**
	 * YETA3200 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3200 목록
	 * @exception Exception
	 */
    public List<?> selectYeta3200List(InfcPkgYeta3200SrhVO searchVO) throws Exception {
        return list("yetaPrc3200DAO.selectYetaPrc3200List_D", searchVO);
    }

    /**
	 * YETA3200 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3200 총 갯수
	 * @exception
	 */
    public int selectYeta3200ListTotCnt(InfcPkgYeta3200SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("yetaPrc3200DAO.selectYetaPrc3200ListTotCnt_S", searchVO);
    }

}
