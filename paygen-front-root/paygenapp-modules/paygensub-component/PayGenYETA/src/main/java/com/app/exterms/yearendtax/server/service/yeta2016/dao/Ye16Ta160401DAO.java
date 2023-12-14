package com.app.exterms.yearendtax.server.service.yeta2016.dao;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye160401VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Ye16Ta160401DAO.java
 * @Description : Ye160401 DAO Class
 * @Modification Information
 *
 * @author DaEun
 * @since 2017.01.06
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye16Ta160401DAO")
public class Ye16Ta160401DAO extends EgovAbstractDAO {

	/**
	 * YE160401???�록?�다.
	 * @param vo - ?�록???�보�??�긴 Ye160401VO
	 * @return ?�록 결과
	 * @exception Exception
	 */
    public String insertYe160401(Ye160401VO vo) throws Exception {
        return (String)insert("Ye16Ta160401DAO.insertYe160401_S", vo);
    }

    /**
	 * YE160401???�정?�다.
	 * @param vo - ?�정???�보�??�긴 Ye160401VO
	 * @return void??
	 * @exception Exception
	 */
    public void updateYe160401(Ye160401VO vo) throws Exception {
        update("Ye16Ta160401DAO.updateYe160401_S", vo);
    }

    /**
	 * YE160401????��?�다.
	 * @param vo - ??��???�보�??�긴 Ye160401VO
	 * @return void??
	 * @exception Exception
	 */
    public void deleteYe160401(Ye160401VO vo) throws Exception {
        delete("Ye16Ta160401DAO.deleteYe160401_S", vo);
    }
    
    public void fnYeta1100_YE160401_2016_CREATE_Delete(Ye160401VO vo) throws Exception {
        delete("Ye16Ta160401DAO.fnYeta1100_YE160401_2016_CREATE_Delete_S", vo);
    }
    
    /**
	 * YE160401????��?�다.
	 * @param vo - ??��???�보�??�긴 Ye160401VO
	 * @return void??
	 * @exception Exception
	 */
    public void deleteYeta2100ToYe160401(Ye160401VO vo) throws Exception {
        delete("Ye16Ta160401DAO.deleteYeta1100ToYe160401_S", vo);
    }
    
    
    /**
	 * YE160401????��?�다.
	 * @param vo - ??��???�보�??�긴 Ye160401VO
	 * @return void??
	 * @exception Exception
	 */
    public void fnYeta2100_Ye160401_CREATE_Delete(Ye160401VO vo) throws Exception {
        delete("Ye16Ta160401DAO.fnYeta1100_Ye160401_CREATE_Delete", vo);
    }
    
    
    
    

//    /**
//	 * YE160401??조회?�다.
//	 * @param vo - 조회???�보�??�긴 Ye160401VO
//	 * @return 조회??YE160401
//	 * @exception Exception
//	 */
//    public Ye160401VO selectYe160401(Ye160401VO vo) throws Exception {
//        return (Ye160401VO) select("Ye16Ta160401DAO.selectYe160401_S", vo);
//    }
//
//    /**
//	 * YE160401 목록??조회?�다.
//	 * @param searchMap - 조회???�보�??�긴 Map
//	 * @return YE160401 목록
//	 * @exception Exception
//	 */
//    public List<?> selectYe160401List(Ye160401DefaultVO searchVO) throws Exception {
//        return list("Ye16Ta160401DAO.selectYe160401List_D", searchVO);
//    }
//
//    /**
//	 * YE160401 �?�?���?조회?�다.
//	 * @param searchMap - 조회???�보�??�긴 Map
//	 * @return YE160401 �?�?��
//	 * @exception
//	 */
//    public int selectYe160401ListTotCnt(Ye160401DefaultVO searchVO) {
//        return (Integer)select("Ye16Ta160401DAO.selectYe160401ListTotCnt_S", searchVO);
//    }

}
