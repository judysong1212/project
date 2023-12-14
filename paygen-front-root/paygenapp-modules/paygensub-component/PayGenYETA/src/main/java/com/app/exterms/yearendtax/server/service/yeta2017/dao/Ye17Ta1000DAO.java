package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.yearendtax.server.vo.Yeta1000SrhVO;
import com.app.exterms.yearendtax.server.vo.Yeta1000VO;
import com.google.gwt.user.client.rpc.IsSerializable;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

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

@Repository("Ye17Ta1000DAO")
public class Ye17Ta1000DAO extends EgovAbstractDAO implements IsSerializable {
	
	
	
    /**
	 * YETA1000 목록을 조회한다.(연말정산신고 기본정보)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA1000 목록
	 * @exception Exception
	 */
    public List selectYeta0400List(Yeta1000SrhVO searchVO) throws Exception {
        return list("ye17Ta1000DAO.selectYeta0400ToList_D", searchVO);
    }
    
    /**
	 * YETA1000 총 갯수를 조회한다..(연말정산신고 기본정보)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA1000 총 갯수
	 * @exception
	 */
    public int selectYeta0400ListTotCnt(Yeta1000SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye17Ta1000DAO.selectYeta0400ToListTotCnt_S", searchVO);
    }
    
    
    /**
	 * YETA1000 목록을 조회한다.(마감할 일련번호를 가져온다.)
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA1000 목록
	 * @exception Exception
	 */
    public List<EgovMap> selectFinYeta1000List(Yeta1000VO vo) throws Exception {
        return (List<EgovMap>)list("ye17Ta1000DAO.selectFinYeta1000List", vo);
    }
    
    
    /**
	 * YETA1000을 수정한다.(연말정산신고파일생성 마감/마감풀기)
	 * @param vo - 수정할 정보가 담긴 Yeta1000VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void finishYeta0400List(Yeta1000VO vo) throws Exception {
        update("ye17Ta1000DAO.finishYeta1000_S", vo);
    }
    
    /**
	 * YETA1000을 수정한다.(전자신고기본정보 수정)
	 * @param vo - 수정할 정보가 담긴 Yeta1000VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void saveYeta0400List(Yeta1000VO vo) throws Exception {
        update("ye17Ta1000DAO.updateYeta0400ToYeta1000_S", vo);
    }
	
	

	/**
	 * YETA1000을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta1000VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertYeta1000(Yeta1000VO vo) throws Exception {
        return (String)insert("ye17Ta1000DAO.insertYeta1000_S", vo);
    }

    /**
	 * YETA1000을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta1000VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateYeta1000(Yeta1000VO vo) throws Exception {
        update("ye17Ta1000DAO.updateYeta1000_S", vo);
    }

    /**
	 * YETA1000을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta1000VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteYeta1000(Yeta1000VO vo) throws Exception {
        delete("ye17Ta1000DAO.deleteYeta1000_S", vo);
    }
    public void fnYeta1100_YETA1000_2016_CREATE_Delete(Yeta1000VO vo) throws Exception {
        delete("ye17Ta1000DAO.fnYeta1100_YETA1000_2016_CREATE_Delete_S", vo);
    }
    
    
    
    /**
	 * YETA1000을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta1000VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void fnPayr06430_PAYR420_CREATE_Delete(Yeta1000VO vo) throws Exception {
        delete("ye17Ta1000DAO.fnPayr06430_PAYR420_CREATE_Delete_S", vo);
    }
    
    
    

    /**
	 * YETA1000을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta1000VO
	 * @return 조회한 YETA1000
	 * @exception Exception
	 */
    public Yeta1000VO selectYeta1000(Yeta1000VO vo) throws Exception {
        return (Yeta1000VO) selectByPk("ye17Ta1000DAO.selectYeta1000_S", vo);
    }

    /**
	 * YETA1000 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA1000 목록
	 * @exception Exception
	 */
    public List<?> selectYeta1000List(Yeta1000SrhVO searchVO) throws Exception {
        return list("ye17Ta1000DAO.selectYeta1000List_D", searchVO);
    }

    /**
	 * YETA1000 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return YETA1000 총 갯수
	 * @exception
	 */
    public int selectYeta1000ListTotCnt(Yeta1000SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("ye17Ta1000DAO.selectYeta1000ListTotCnt_S", searchVO);
    }

}

