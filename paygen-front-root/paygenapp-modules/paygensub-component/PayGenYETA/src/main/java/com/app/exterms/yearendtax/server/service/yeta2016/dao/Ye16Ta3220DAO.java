package com.app.exterms.yearendtax.server.service.yeta2016.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.yearendtax.server.vo.Yeta3220SrhVO;
import com.app.exterms.yearendtax.server.vo.Yeta3220VO;
import com.google.gwt.user.client.rpc.IsSerializable;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Yeta3220DAO.java
 * @Description : Yeta3220 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2016.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye16Ta3220DAO")
public class Ye16Ta3220DAO extends EgovAbstractDAO implements IsSerializable {
    /**
	 * YETA3220을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3220VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void fnYeta1100_YETA3220_2016_CREATE_Delete(Yeta3220VO vo) throws Exception {
        delete("ye16Ta3220DAO.fnYeta1100_YETA3220_2016_CREATE_Delete_S", vo);
    } 
    	
	
    /**
	 * YETA3220 조회한다.(YETA3220)
	 * @param srhVo - 조회할 정보가 담긴 YETA3220SrhVO
	 * @return 조회한 YETA3220
	 * @exception Exception
	 */
    public List selectYeta0300To3220List(Yeta3220SrhVO Yeta2000SrhVo) throws Exception {
        return list("ye16Ta3220DAO.selectYeta0300To3220List", Yeta2000SrhVo);
    }
    
    /**
	 * YETA3220 조회한다.(소득공제명세 - 합계)
	 * @param srhVo - 조회할 정보가 담긴 YETA3220SrhVO
	 * @return 조회한 YETA3220
	 * @exception Exception
	 */
    public List selectYeta0300To3220SumList(Yeta3220SrhVO Yeta2000SrhVo) throws Exception {
        return list("ye16Ta3220DAO.selectYeta0300To3220SumList", Yeta2000SrhVo);
    }
    
    /**
	 * YETA3220 총 갯수를 조회한다.(소득공제명세 - 합계)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3220 총 갯수
	 * @exception
	 */
    public int selectYeta0300To3220SumListTotCnt(Yeta3220SrhVO Yeta2000SrhVo) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye16Ta3220DAO.selectYeta0300To3220SumListTotCnt_S", Yeta2000SrhVo);
    }
	
	
    /**
	 * YETA3220 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3220 총 갯수
	 * @exception
	 */
    public int selectYeta0300To3220ListTotCnt(Yeta3220SrhVO Yeta2000SrhVo) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye16Ta3220DAO.selectYeta0300To3220ListTotCnt_S", Yeta2000SrhVo);
    }
	
	
	
    
	/**
	 * YETA3220을 등록한다.(인적공제명세)
	 * @param vo - 등록할 정보가 담긴 Yeta3220VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertYeta0300ToYeta3220(Yeta3220VO vo) throws Exception {
        return (String)insert("ye16Ta3220DAO.insertYeta3220_S", vo);
    }
    
    
    
    /**
	 * YETA3220을 수정한다.(인적공제명세)
	 * @param vo - 수정할 정보가 담긴 Yeta3220VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateYeta0300ToYeta3220(Yeta3220VO vo) throws Exception {
        update("ye16Ta3220DAO.updateYeta0300ToYeta3220_01_S", vo);
    }
	
	
    /**
	 * YETA3220을 수정한다.(소득공제_국세청자료)
	 * @param vo - 수정할 정보가 담긴 Yeta3220VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateYeta0300ToYeta3220_01(Yeta3220VO vo) throws Exception {
        update("ye16Ta3220DAO.updateYeta3220_01", vo);
    }
    
    /**
	 * YETA3220을 수정한다.(소득공제_기타자료)
	 * @param vo - 수정할 정보가 담긴 Yeta3220VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateYeta0300ToYeta3220_02(Yeta3220VO vo) throws Exception {
        update("ye16Ta3220DAO.updateYeta3220_02", vo);
    }
    
    
    /**
	 * YETA3220을 삭제한다.(인적공제명세)
	 * @param vo - 삭제할 정보가 담긴 Yeta3220VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteYeta0300ToYeta3220(Yeta3220VO vo) throws Exception {
        delete("ye16Ta3220DAO.deleteYeta3220_S", vo);
    }
	
	
	
	/**
	 * YETA3220을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta3220VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertYeta3220(Yeta3220VO vo) throws Exception {
        return (String)insert("ye16Ta3220DAO.insertYeta3220_S", vo);
    }

    /**
	 * YETA3220을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta3220VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateYeta3220(Yeta3220VO vo) throws Exception {
        update("ye16Ta3220DAO.updateYeta3220_S", vo);
    }

    /**
	 * YETA3220을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3220VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteYeta3220(Yeta3220VO vo) throws Exception {
        delete("ye16Ta3220DAO.deleteYeta3220_S", vo);
    }
    
    /**
	 * YETA3220을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3220VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void fnPayr06430_PAYR410_CREATE_Delete(Yeta3220VO vo) throws Exception {
        delete("ye16Ta3220DAO.fnPayr06430_PAYR410_CREATE_Delete_S", vo);
    } 
    

    /**
	 * YETA3220을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta3220VO
	 * @return 조회한 YETA3220
	 * @exception Exception
	 */
    public Yeta3220VO selectYeta3220(Yeta3220VO vo) throws Exception {
        return (Yeta3220VO) selectByPk("ye16Ta3220DAO.selectYeta3220_S", vo);
    }

    /**
	 * YETA3220 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3220 목록
	 * @exception Exception
	 */
    public List<?> selectYeta3220List(Yeta3220SrhVO searchVO) throws Exception {
        return list("ye16Ta3220DAO.selectYeta3220List_D", searchVO);
    }

    /**
	 * YETA3220 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA3220 총 갯수
	 * @exception
	 */
    public int selectYeta3220ListTotCnt(Yeta3220SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye16Ta3220DAO.selectYeta3220ListTotCnt_S", searchVO);
    }

}
