package com.app.exterms.personal.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.personal.server.vo.Psnl0131SrhVO;
import com.app.exterms.personal.server.vo.Psnl0131VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Psnl0110DAO.java
 * @Description : Psnl0110 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.05.27
 * @version 1.0
 * @see
 *    
 *  Copyright (C)  All right reserved.
 */

@Repository("Psnl0131DAO")
public class Psnl0131DAO extends EgovAbstractDAO {

//	/**
//	 * PSNL0110을 등록한다.
//	 * @param vo - 등록할 정보가 담긴 Psnl0110VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//	//TODO psnl123, 300 Impl에서 DTO넣어서 호출해서 사용중.. 일단 그냥 두고 사용하는걸로..
//    @Transactional
//    public String insertPsnl0110(Psnl0110DTO dto) throws Exception {
//        return (String)insert("psnl0110DAO.insertPsnl0110", dto);
//    }
//    
//    public String insertPsnl0100ToPsnl0110(Psnl0110VO psnl0110Vo) throws Exception {
//        return (String)insert("psnl0110DAO.insertPsnl0100ToPsnl0110", psnl0110Vo);
//    }
//    
//    @Transactional
//    public String insertPsnl0110(Psnl0110VO psnl0110Vo) throws Exception {
//        return (String)insert("psnl0110DAO.insertPsnl0110Vo", psnl0110Vo);
//    }
//
//    
//    /**
//	 * PSNL0110을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 Psnl0110VO
//	 * @return void형
//	 * @exception Exception
//	 */
//    
////    @Transactional
////    public int updatePsnl0110(Psnl0110DTO dto) throws Exception {
////        return update("psnl0110DAO.updatePsnl0110", dto);
////    }
//    
//    @Transactional
//    public int updatePsnl0110(Psnl0110VO psnl0110Vo) throws Exception {
//        return update("psnl0110DAO.updatePsnl0110", psnl0110Vo);
//    }
//    
////    @Transactional
////    public int updatePsnl0100ToPsnl0110(Psnl0110DTO dto) throws Exception {
////        return update("psnl0110DAO.updatePsnl0100ToPsnl0110", dto);
////    }   
//    
//    @Transactional
//    public int updatePsnl0100ToPsnl0110(Psnl0110VO psnl0110Vo) throws Exception {
//        return update("psnl0110DAO.updatePsnl0100ToPsnl0110", psnl0110Vo);
//    }   
//    
//
//    //고용시작종료일
////    @Transactional
////    public int updateEmymtEndDate(Psnl0110DTO dto) throws Exception{
////    	return update("psnl0110DAO.updateEmymtEndDate", dto);
////    }
//    @Transactional
//    public int updateEmymtEndDate(Psnl0110VO psnl0110Vo) throws Exception{
//    	return update("psnl0110DAO.updateEmymtEndDate", psnl0110Vo);
//    }
//    
//    //고용날짜
////    @Transactional
////    public int updateEmymtEndNull(Psnl0110DTO dto) throws Exception{
////    	return update("psnl0110DAO.updateEmymtEndNull", dto);
////    }
//    
//    @Transactional
//    public int updateEmymtEndNull(Psnl0110VO psnl0110Vo) throws Exception{
//    	return update("psnl0110DAO.updateEmymtEndNull", psnl0110Vo);
//    }
//    
//    
//    /**
//	 * PSNL0110을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 Psnl0110VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//    
////    @Transactional
////    public int deletePsnl0110(Psnl0110DTO dto) throws Exception {
////        return delete("psnl0110DAO.deletePsnl0110", dto);
////    }
//    
//    @Transactional
//    public int deletePsnl0110(Psnl0110VO psnl0110Vo) throws Exception {
//        return delete("psnl0110DAO.deletePsnl0110", psnl0110Vo);
//    }
//    
//    
//    /**
//	 * PSNL0110을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 Psnl0110VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//    
//    @Transactional
//    public int deletePsnl0100ToPsnl0110(Psnl0110DTO dto) throws Exception {
//        return delete("psnl0110DAO.deletePsnl0100ToPsnl0110", dto);
//    }
//    

    /**
	 * PSNL0131을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Psnl0131VO
	 * @return 조회한 PSNL0110
	 * @exception Exception
	 */
    @SuppressWarnings("rawtypes")
	public List selectPsnl0131(Psnl0131SrhVO psnl0131SrhVo) throws Exception {
        return list("psnl0131DAO.selectPsnl0131", psnl0131SrhVo);
    }
    
    @SuppressWarnings("deprecation")
	public int selectPsnl0131ListCnt(Psnl0131SrhVO psnl0131SrhVo) {
        return (Integer)getSqlMapClientTemplate().queryForObject("psnl0131DAO.selectPsnl0131TotCnt", psnl0131SrhVo);
    }
    
    
    
	/**
	 * PSNL0131을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Psnl0131VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public Long insertPsnl0131(Psnl0131VO psnl0131Vo) throws Exception {
        return (Long)insert("psnl0131DAO.insertPsnl0131", psnl0131Vo);
    }
    
    
    
	/**
	 * PSNL0131을 수정한다.
	 * @param vo - 등록할 정보가 담긴 Psnl0131VO
	 * @return
	 * @exception Exception
	 */
    @Transactional
    public int updatePsnl0131(Psnl0131VO psnl0131Vo) throws Exception {
        return update("psnl0131DAO.updatePsnl0131", psnl0131Vo);
    }
    

}
