package com.app.exterms.yearendtax.server.service.yeta2016.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.yearendtax.server.vo.Yeta3100SrhVO;
import com.app.exterms.yearendtax.server.vo.Yeta3100VO;
import com.google.gwt.user.client.rpc.IsSerializable;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Yeta3100DAO.java
 * @Description : Yeta3100 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye16Ta3100DAO")
public class Ye16Ta3100DAO extends EgovAbstractDAO implements IsSerializable {
	
	
    /**
	 * YETA3100을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3100VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void fnYeta1100_YETA3100_2016_CREATE_Delete(Yeta3100VO vo) throws Exception {
        delete("ye16Ta3100DAO.fnYeta1100_YETA3100_2016_CREATE_Delete_S", vo);
    }	
	
	
	
	
	
	
	/**
	 * YETA3100을 등록한다.(연금저축소득공제)
	 * @param vo - 등록할 정보가 담긴 Yeta3100VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	  @Transactional
    public String insertYetaP03007To3100(Yeta3100VO vo) throws Exception {
        return (String)insert("ye16Ta3100DAO.insertYeta3100_S", vo);
    }

    /**
	 * YETA3100을 수정한다.(연금저축소득공제)
	 * @param vo - 수정할 정보가 담긴 Yeta3100VO
	 * @return void형
	 * @exception Exception
	 */
	  @Transactional
    public void updateYetaP03007To3100(Yeta3100VO vo) throws Exception {
        update("ye16Ta3100DAO.updateYeta3100_S", vo);
    }

    /**
	 * YETA3100을 삭제한다.(연금저축소득공제)
	 * @param vo - 삭제할 정보가 담긴 Yeta3100VO
	 * @return void형 
	 * @exception Exception
	 */
	  @Transactional
    public void deleteYetaP03007To3100(Yeta3100VO vo) throws Exception {
        delete("ye16Ta3100DAO.deleteYeta3100_S", vo);
    }
    
    /**
	 * YETA3100 목록을 조회한다.(연금저축소득공제)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3100 목록
	 * @exception Exception
	 */
    public List selectYetaP03001To3100List(Yeta3100SrhVO searchVO) throws Exception {
        return list("ye16Ta3100DAO.selectYetaP03001To3100List_D", searchVO);
    }

    /**
	 * YETA3100 총 갯수를 조회한다.(연금저축소득공제)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3100 총 갯수
	 * @exception
	 */
    public int selectYetaP03007To3100ListTotCnt(Yeta3100SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye16Ta3100DAO.selectYetaP03001To3100ListTotCnt_S", searchVO);
    }
    
	

	/**
	 * YETA3100을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta3100VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertYeta3100(Yeta3100VO vo) throws Exception {
        return (String)insert("ye16Ta3100DAO.insertYeta3100_S", vo);
    }

    /**
	 * YETA3100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta3100VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateYeta3100(Yeta3100VO vo) throws Exception {
        update("ye16Ta3100DAO.updateYeta3100_S", vo);
    }

    /**
	 * YETA3100을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3100VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteYeta3100(Yeta3100VO vo) throws Exception {
        delete("ye16Ta3100DAO.deleteYeta3100_S", vo);
    }
    
    /**
	 * YETA3100을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3100VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void fnPayr06430_PAYR418_CREATE_Delete(Yeta3100VO vo) throws Exception {
        delete("ye16Ta3100DAO.fnPayr06430_PAYR418_CREATE_Delete_S", vo);
    }
    

    /**
	 * YETA3100을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta3100VO
	 * @return 조회한 YETA3100
	 * @exception Exception
	 */
    public Yeta3100VO selectYeta3100(Yeta3100VO vo) throws Exception {
        return (Yeta3100VO) selectByPk("ye16Ta3100DAO.selectYeta3100_S", vo);
    }

    /**
	 * YETA3100 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3100 목록
	 * @exception Exception
	 */
    public List<?> selectYeta3100List(Yeta3100SrhVO searchVO) throws Exception {
        return list("ye16Ta3100DAO.selectYeta3100List_D", searchVO);
    }

    /**
	 * YETA3100 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3100 총 갯수
	 * @exception
	 */
    public int selectYeta3100ListTotCnt(Yeta3100SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye16Ta3100DAO.selectYeta3100ListTotCnt_S", searchVO);
    }

}
