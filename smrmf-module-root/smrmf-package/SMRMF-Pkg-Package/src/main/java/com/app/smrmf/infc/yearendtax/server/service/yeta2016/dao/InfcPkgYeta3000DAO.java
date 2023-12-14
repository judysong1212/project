package com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160401VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta2000VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3000SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3000VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Yeta3000DAO.java
 * @Description : Yeta3000 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgYeta3000DAO")
public class InfcPkgYeta3000DAO extends EgovAbstractDAO {

	
	@Transactional
    public String fnYeta1100_YETA3000_2016_CREATE_Insert(InfcPkgYeta2000VO vo) throws Exception {
		return (String)insert("infcPkgYeta3000DAO.fnYeta1100_YETA3000_2016_CREATE_Insert_S", vo);
    } 
	
	@Transactional
	public void fnYeta1100_YETA3000_PAYR_2016_CREATE_Update(InfcPkgYe160401VO infcPkgYe160401Vo)throws Exception {
		update("infcPkgYeta3000DAO.fnYeta1100_YETA3000_PAYR_2016_CREATE_Update", infcPkgYe160401Vo);
	}
	
	@Transactional
    public String fnYeta2100_YETA3000_2017_CREATE_Insert(InfcPkgYeta2000VO vo) throws Exception {
		return (String)insert("infcPkgYeta3000DAO.fnYeta1100_YETA3000_2016_CREATE_Insert_S", vo);
    } 
	
	@Transactional
	public void fnYeta2100_YETA3000_PAYR_2017_CREATE_Update(InfcPkgYe160401VO infcPkgYe160401Vo)throws Exception {
		update("infcPkgYeta3000DAO.fnYeta1100_YETA3000_PAYR_2016_CREATE_Update", infcPkgYe160401Vo);
	}
    	
	
	
	
	
	
	
	
	/**
	 * YETA3000을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta3000VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String insertYeta3000(InfcPkgYeta3000VO vo) throws Exception {
        return (String)insert("infcPkgYeta3000DAO.insertYetaPrc3000_S", vo);
    }
	  @Transactional
    public String fnPayr06430_PAYR425_2014_CREATE_Insert(InfcPkgYeta2000VO vo) throws Exception {
        return (String)insert("infcPkgYeta3000DAO.fnPayr06430_PAYR425_2014_CREATE_Insert_S", vo);
    } 
    

    /**
	 * YETA3000을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta3000VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
    public void updateYeta3000(InfcPkgYeta3000VO vo) throws Exception {
        update("infcPkgYeta3000DAO.updateYetaPrc3000_S", vo);
    }
	  @Transactional
    public void fnPayr06530_PAYR425_2015_CREATE1_Update(InfcPkgYeta2000VO vo) throws Exception {
        update("infcPkgYeta3000DAO.fnPayr06530_PAYR425_2015_CREATE1_Update", vo);
    }
    
    /**
	 * YETA3000을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3000VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void deleteYeta3000(InfcPkgYeta3000VO vo) throws Exception {
        delete("infcPkgYeta3000DAO.deleteYetaPrc3000_S", vo);
    }
    
    /**
 	 * YETA3000을 삭제한다.
 	 * @param vo - 삭제할 정보가 담긴 Yeta3000VO
 	 * @return void형 
 	 * @exception Exception
 	 */
	  @Transactional
     public void fnPayr06430_PAYR425_CREATE_Delete(InfcPkgYeta3000VO vo) throws Exception {
         delete("infcPkgYeta3000DAO.fnPayr06430_PAYR425_CREATE_Delete_S", vo);
     }
    
    /**
	 * YETA3000을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta3000VO
	 * @return 조회한 YETA3000
	 * @exception Exception
	 */
    public InfcPkgYeta3000VO selectYeta3000(InfcPkgYeta3000VO vo) throws Exception {
        return (InfcPkgYeta3000VO) selectByPk("infcPkgYeta3000DAO.selectYetaPrc3000_S", vo);
    }

    
    public InfcPkgYeta3000VO fnPayr06430_PAYR425_ReTax_2016_SPCI_Select_Update(InfcPkgYeta3000VO vo) throws Exception {
        return (InfcPkgYeta3000VO) selectByPk("infcPkgYeta3000DAO.fnPayr06430_PAYR425_ReTax_2016_SPCI_Select_Update", vo);
    }
     
    
    /**
	 * YETA3000 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3000 목록
	 * @exception Exception
	 */
    public List<?> selectYeta3000List(InfcPkgYeta3000SrhVO searchVO) throws Exception {
        return list("infcPkgYeta3000DAO.selectYetaPrc3000List_D", searchVO);
    }

    /**
	 * YETA3000 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3000 총 갯수
	 * @exception
	 */
    public int selectYeta3000ListTotCnt(InfcPkgYeta3000SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgYeta3000DAO.selectYetaPrc3000ListTotCnt_S", searchVO);
    }

}
