package com.app.exterms.personal.server.service.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.personal.server.vo.Psnl0123VO;
import com.app.smrmf.infc.personal.server.vo.InfcPkgPsnl0123SrhVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
 
/**
 * @Class Name : Psnl0123DAO.java
 * @Description : Psnl0123 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("psnl0123DAO")
public class Psnl0123DAO extends EgovAbstractDAO {

	/**
	 * PSNL0123을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Psnl0123VO
	 * @return 등록 결과
	 * @exception Exception
	 */
//    @Transactional
//    public String insertPsnl0123(Psnl0123DTO dto) throws Exception {
//        return (String)insert("psnl0123DAO.insertPsnl0123", dto);
//    }
    
    @Transactional
    public String insertPsnl0123(Psnl0123VO psnl0123Vo) throws Exception {
        return (String)insert("psnl0123DAO.insertPsnl0123", psnl0123Vo);
    }

    /**
	 * PSNL0123을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Psnl0123VO
	 * @return int형
	 * @exception Exception
	 */
//    @Transactional
//    public int updatePsnl0123(Psnl0123DTO dto) throws Exception {
//        return update("psnl0123DAO.updatePsnl0123", dto);
//    }
    
    @Transactional
    public int updatePsnl0123(Psnl0123VO psnl0123Vo) throws Exception {
        return update("psnl0123DAO.updatePsnl0123", psnl0123Vo);
    }
    
    /**
	 * PSNL0123을 수정한다. ( 고용 탭에서 휴직 이력 수정 시 )
	 * @param vo - 수정할 정보가 담긴 Psnl0123VO
	 * @return int형
	 * @exception Exception
	 */
    @Transactional
    public int updatePsnl0110ToPsnl0123(Psnl0123VO psnl0123Vo) throws Exception {
        return update("psnl0123DAO.updatePsnl0110ToPsnl0123", psnl0123Vo);
    }
    

    /**
	 * PSNL0123을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Psnl0123VO
	 * @return void형 
	 * @exception Exception
	 */
//    @Transactional
//    public int deletePsnl0123(Psnl0123DTO dto) throws Exception {
//        return delete("psnl0123DAO.deletePsnl0123", dto);
//    }
    
    @Transactional
    public int deletePsnl0123(Psnl0123VO psnl0123Vo) throws Exception {
        return delete("psnl0123DAO.deletePsnl0123", psnl0123Vo);
    }
    
    @Transactional
    public int deletePsnl0100ToPsnl0123(Psnl0123VO psnl0123Vo) throws Exception {
        return delete("psnl0123DAO.deletePsnl100ToPsnl0123", psnl0123Vo);
    }

    /**
	 * PSNL0123을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Psnl0123VO
	 * @return 조회한 PSNL0123
	 * @exception Exception
	 */
    @SuppressWarnings("rawtypes")
	public List selectPsnl0123(HashMap<String, String> hMap) throws Exception {
        return list("psnl0123DAO.selectPsnl0123", hMap);
    }
    
    
    /**
   	 * PSNL0123을 조회한다.
   	 * @param vo - 조회할 정보가 담긴 Psnl0123VO
   	 * @return 조회한 PSNL0123
   	 * @exception Exception
   	 */
       public Psnl0123VO selectPsnl0123(Psnl0123VO vo) throws Exception {
           return (Psnl0123VO) selectByPk("psnl0123DAO.selectPsnl0123_S", vo);
       }

 
    /**
   	 * PSNL0123 목록을 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return PSNL0123 목록
   	 * @exception Exception
   	 */
       public List selectPsnl0123ToPayr4100List(InfcPkgPsnl0123SrhVO searchVO) throws Exception {
           return list("psnl0123DAO.selectPsnl0123ToPayr4100List_D", searchVO);
       }

       /**
   	 * PSNL0123 총 갯수를 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return PSNL0123 총 갯수
   	 * @exception
   	 */
       public int selectPsnl0123ToPayr4100ListTotCnt(InfcPkgPsnl0123SrhVO searchVO) {
           return (Integer)getSqlMapClientTemplate().queryForObject("psnl0123DAO.selectPsnl0123ToPayr4100ListTotCnt_S", searchVO);
       }
       
    

}
