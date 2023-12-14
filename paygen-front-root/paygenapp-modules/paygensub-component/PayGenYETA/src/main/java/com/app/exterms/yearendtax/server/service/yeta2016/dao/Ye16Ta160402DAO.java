package com.app.exterms.yearendtax.server.service.yeta2016.dao;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye160402VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : ye16Ta160402DAO.java
 * @Description : Ye160402 DAO Class
 * @Modification Information
 *
 * @author DaEun
 * @since 2017.01.03
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye16Ta160402DAO")
public class Ye16Ta160402DAO extends EgovAbstractDAO {

	/**
	 * YE160402???�록?�다.
	 * @param vo - ?�록???�보�??�긴 Ye160402VO
	 * @return ?�록 결과
	 * @exception Exception
	 */
    public String insertYe160402(Ye160402VO vo) throws Exception {
        return (String)insert("ye16Ta160402DAO.insertYe160402_S", vo);
    }

    /**
	 * YE160402???�정?�다.
	 * @param vo - ?�정???�보�??�긴 Ye160402VO
	 * @return void??
	 * @exception Exception
	 */
    public void updateYe160402(Ye160402VO vo) throws Exception {
        update("ye16Ta160402DAO.updateYe160402_S", vo);
    }

    /**
	 * YE160402????��?�다.
	 * @param vo - ??��???�보�??�긴 Ye160402VO
	 * @return void??
	 * @exception Exception
	 */
    public void deleteYe160402(Ye160402VO vo) throws Exception {
        delete("ye16Ta160402DAO.deleteYe160402_S", vo);
    }
    
    public void fnYeta1100_YE160402_2016_CREATE_Delete(Ye160402VO vo) throws Exception {
        delete("ye16Ta160402DAO.fnYeta1100_YE160402_2016_CREATE_Delete_S", vo);
    }
    
    
    /**
	 * YE160402????��?�다.
	 * @param vo - ??��???�보�??�긴 Ye160402VO
	 * @return void??
	 * @exception Exception
	 */
    public void deleteYeYeta1100To160402(Ye160402VO vo) throws Exception {
        delete("ye16Ta160402DAO.deleteYeta1100ToYe160402_S", vo);
    }
    
    
    /**
	 * YE160402????��?�다.
	 * @param vo - ??��???�보�??�긴 Ye160402VO
	 * @return void??
	 * @exception Exception
	 */
    public void fnYeta1100_Ye160402_CREATE_Delete(Ye160402VO vo) throws Exception {
        delete("ye16Ta160402DAO.fnYeta1100_Ye160402_CREATE_Delete", vo);
    }
    
    
    
    

//    /**
//	 * YE160402??조회?�다.
//	 * @param vo - 조회???�보�??�긴 Ye160402VO
//	 * @return 조회??YE160402
//	 * @exception Exception
//	 */
//    public Ye160402VO selectYe160402(Ye160402VO vo) throws Exception {
//        return (Ye160402VO) select("ye16Ta160402DAO.selectYe160402_S", vo);
//    }
//
//    /**
//	 * YE160402 목록??조회?�다.
//	 * @param searchMap - 조회???�보�??�긴 Map
//	 * @return YE160402 목록
//	 * @exception Exception
//	 */
//    public List<?> selectYe160402List(Ye160402DefaultVO searchVO) throws Exception {
//        return list("ye16Ta160402DAO.selectYe160402List_D", searchVO);
//    }
//
//    /**
//	 * YE160402 �?�?���?조회?�다.
//	 * @param searchMap - 조회???�보�??�긴 Map
//	 * @return YE160402 �?�?��
//	 * @exception
//	 */
//    public int selectYe160402ListTotCnt(Ye160402DefaultVO searchVO) {
//        return (Integer)select("ye16Ta160402DAO.selectYe160402ListTotCnt_S", searchVO);
//    }

}
