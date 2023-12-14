package com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.tax.service.impl.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta1000SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta1000VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Yeta1000DAO.java
 * @Description : Yeta1000 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("YetaPrc1000DAO")
public class YetaPrc1000DAO extends EgovAbstractDAO {

	/**
	 * YETA1000을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta1000VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String insertYeta1000(InfcPkgYeta1000VO vo) throws Exception {
        return (String)insert("yetaPrc1000DAO.insertYetaPrc1000_S", vo);
    }
    
	/**
	 * YETA1000을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta1000VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String fnPayr06420_PAYR420_2014_CREATE_Insert(InfcPkgYeta1000VO vo) throws Exception {
        return (String)insert("yetaPrc1000DAO.fnPayr06420_PAYR420_2014_CREATE_Insert_S", vo);
    }
    

    /**
	 * YETA1000을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta1000VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
    public void updateYeta1000(InfcPkgYeta1000VO vo) throws Exception {
        update("yetaPrc1000DAO.updateYetaPrc1000_S", vo);
    }

    /**
	 * YETA1000을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta1000VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void deleteYeta1000(InfcPkgYeta1000VO vo) throws Exception {
        delete("yetaPrc1000DAO.deleteYetaPrc1000_S", vo);
    }
    /**
	 * YETA1000을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta1000VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void fnPayr06430_PAYR420_CREATE_Delete(InfcPkgYeta1000VO vo) throws Exception {
        delete("yetaPrc1000DAO.fnPayr06430_PAYR420_CREATE_Delete_S", vo);
    }
    

    /**
	 * YETA1000을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta1000VO
	 * @return 조회한 YETA1000
	 * @exception Exception
	 */
    public InfcPkgYeta1000VO selectYeta1000(InfcPkgYeta1000VO vo) throws Exception {
        return (InfcPkgYeta1000VO) selectByPk("yetaPrc1000DAO.selectYetaPrc1000_S", vo);
    }
    

    /**
	 * YETA1000을 일련번호를 조회한다 .
	 * @param vo - 조회할 정보가 담긴 Yeta1000VO
	 * @return 조회한 YETA1000
	 * @exception Exception
	 */
    public InfcPkgYeta1000VO selectYeta0100ToCreateYetaPrc1000(InfcPkgYeta1000VO vo) throws Exception {
        return (InfcPkgYeta1000VO) selectByPk("yetaPrc1000DAO.selectYeta0100ToCreateYetaPrc1000_S", vo);
    }
    
    
    public InfcPkgYeta1000VO selectYeta0100ToChkYetaPrc1000(InfcPkgYeta1000VO vo) throws Exception {
        return (InfcPkgYeta1000VO) selectByPk("yetaPrc1000DAO.selectYeta0100ToChkYetaPrc1000", vo);
    }
       
    
    

    /**
	 * YETA1000 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA1000 목록
	 * @exception Exception
	 */
    public List<?> selectYeta1000List(InfcPkgYeta1000SrhVO searchVO) throws Exception {
        return list("yetaPrc1000DAO.selectYetaPrc1000List_D", searchVO);
    }

    /**
	 * YETA1000 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA1000 총 갯수
	 * @exception
	 */
    public int selectYeta1000ListTotCnt(InfcPkgYeta1000SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("yetaPrc1000DAO.selectYetaPrc1000ListTotCnt_S", searchVO);
    }

}
