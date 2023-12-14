package com.app.smrmf.infc.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe162520_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe162530Srh_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe162530_2018_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye162530_2018_DAO.java
 * @Description : Ye162530 DAO Class
 * @Modification Information
 *
 * @author Kim ji eun
 * @since 2016.12.30
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYe162530_2018_DAO")
public class InfcPkgYe162530_2018_DAO extends EgovAbstractDAO {

	// G_거주자간_금전소비대차 
	@Transactional
    public String incTaxDeducDec_nts_Yeta2018_Ye162530_Insert(InfcPkgYe162530_2018_VO  infcPkgYe162530Vo) throws Exception {
        return (String)insert("infcPkgYe162530_2018_DAO.incTaxDeducDec_nts_Yeta2018_Ye162530_Insert_S", infcPkgYe162530Vo);
    }
	 
	/**
	 * YE162530을 등록한다.(임대차계약)
	 * @param vo - 등록할 정보가 담긴 Ye162530VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String insertYetaP03004To162530(InfcPkgYe162530_2018_VO vo) throws Exception {
        return (String)insert("infcPkgYe162530_2018_DAO.insertYe162530_S", vo);
    }

    /**
	 * YE162530을 수정한다.(임대차계약)
	 * @param vo - 수정할 정보가 담긴 Ye162530VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
    public void updateYetaP03004To162530(InfcPkgYe162530_2018_VO vo) throws Exception {
        update("infcPkgYe162530_2018_DAO.updateYe162530_S", vo);
    }

    /**
	 * YE162530을 삭제한다.(임대차계약)
	 * @param vo - 삭제할 정보가 담긴 Ye162530VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void deleteYetaP03004To162530(InfcPkgYe162530_2018_VO vo) throws Exception {
        delete("infcPkgYe162530_2018_DAO.deleteYe162530_S", vo);
    }
    
    /**
	 * YE162530을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Ye162530VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void fnPayr06430_PAYR451_CREATE_Delete(InfcPkgYe162530_2018_VO vo) throws Exception {
        delete("infcPkgYe162530_2018_DAO.fnPayr06430_PAYR451_CREATE_Delete_S", vo);
    } 

    /**
	 * YE162530을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Ye162530VO
	 * @return 조회한 YE162530
	 * @exception Exception
	 */
    public InfcPkgYe162530_2018_VO selectYe162530(InfcPkgYe162530_2018_VO vo) throws Exception {
        return (InfcPkgYe162530_2018_VO) selectByPk("infcPkgYe162530_2018_DAO.selectYe162530_S", vo);
    }

    /**
	 * YE162530 목록을 조회한다.(임대차계약)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YE162530 목록
	 * @exception Exception
	 */
    public List selectYetaP03004To162530List(InfcPkgYe162530Srh_2018_VO searchVO) throws Exception {
        return list("infcPkgYe162530_2018_DAO.selectYe162530List_D", searchVO);
    }

    /**
	 * YE162530 총 갯수를 조회한다.(임대차계약)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YE162530 총 갯수
	 * @exception
	 */
    public int selectYetaP03004To162530ListTotCnt(InfcPkgYe162530Srh_2018_VO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYe162530_2018_DAO.selectYe162530ListTotCnt_S", searchVO);
    }

}
