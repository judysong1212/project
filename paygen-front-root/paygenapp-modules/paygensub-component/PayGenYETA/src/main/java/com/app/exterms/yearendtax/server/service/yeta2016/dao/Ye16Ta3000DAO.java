package com.app.exterms.yearendtax.server.service.yeta2016.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.yearendtax.server.vo.Yeta3000SrhVO;
import com.app.exterms.yearendtax.server.vo.Yeta3000VO;
import com.google.gwt.user.client.rpc.IsSerializable;

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

@Repository("Ye16Ta3000DAO")
public class Ye16Ta3000DAO extends EgovAbstractDAO implements IsSerializable {
    /**
 	 * YETA3000을 삭제한다.
 	 * @param vo - 삭제할 정보가 담긴 Yeta3000VO
 	 * @return void형 
 	 * @exception Exception
 	 */
	  @Transactional
     public void fnYeta1100_YETA3000_2016_CREATE_Delete(Yeta3000VO vo) throws Exception {
         delete("ye16Ta3000DAO.fnYeta1100_YETA3000_2016_CREATE_Delete_S", vo);
     }
	
    /**
	 * YETA3000을 수정한다.(기본사항)
	 * @param vo - 수정할 정보가 담긴 Yeta3000VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
    public void saveYeta0300To3000tabItem01(Yeta3000VO vo) throws Exception {
    	update("ye16Ta3000DAO.updateYeta0300To3000tabItem01", vo);
    }

	/**
	 * YETA3000을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta3000VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String insertYeta3000(Yeta3000VO vo) throws Exception {
        return (String)insert("ye16Ta3000DAO.insertYeta3000_S", vo);
    }

    /**
	 * YETA3000을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta3000VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
    public void updateYeta3000(Yeta3000VO vo) throws Exception {
        update("ye16Ta3000DAO.updateYeta3000_S", vo);
    }

    /**
	 * YETA3000을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3000VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void deleteYeta3000(Yeta3000VO vo) throws Exception {
        delete("ye16Ta3000DAO.deleteYeta3000_S", vo);
    }
    
    /**
 	 * YETA3000을 삭제한다.
 	 * @param vo - 삭제할 정보가 담긴 Yeta3000VO
 	 * @return void형 
 	 * @exception Exception
 	 */
	  @Transactional
     public void fnPayr06430_PAYR425_CREATE_Delete(Yeta3000VO vo) throws Exception {
         delete("ye16Ta3000DAO.fnPayr06430_PAYR425_CREATE_Delete_S", vo);
     }
    
    /**
	 * YETA3000을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta3000VO
	 * @return 조회한 YETA3000
	 * @exception Exception
	 */
    public Yeta3000VO selectYeta3000(Yeta3000VO vo) throws Exception {
        return (Yeta3000VO) selectByPk("ye16Ta3000DAO.selectYeta3000_S", vo);
    }

    /**
	 * YETA3000 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3000 목록
	 * @exception Exception
	 */
    public List<?> selectYeta3000List(Yeta3000SrhVO searchVO) throws Exception {
        return list("ye16Ta3000DAO.selectYeta3000List_D", searchVO);
    }

    /**
	 * YETA3000 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3000 총 갯수
	 * @exception
	 */
    public int selectYeta3000ListTotCnt(Yeta3000SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye16Ta3000DAO.selectYeta3000ListTotCnt_S", searchVO);
    }
    
    
    
    public List<?> selectYeta0300ToSubTaxList(Yeta3000SrhVO searchVO) throws Exception {
        return list("ye16Ta3000DAO.selectYeta0300ToSubTaxList_D", searchVO);
    }

    /**
	 * YETA3000 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3000 총 갯수
	 * @exception
	 */
    public int selectYeta0300ToSubTaxListTotCnt(Yeta3000SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye16Ta3000DAO.selectYeta0300ToSubTaxListTotCnt_S", searchVO);
    } 
    
    

}
