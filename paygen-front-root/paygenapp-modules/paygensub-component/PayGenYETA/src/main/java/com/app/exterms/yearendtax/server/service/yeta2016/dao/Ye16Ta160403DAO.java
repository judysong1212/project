package com.app.exterms.yearendtax.server.service.yeta2016.dao;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Ye160403VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : ye16Ta160403DAO.java
 * @Description : Ye160403 DAO Class
 * @Modification Information
 *
 * @author DaEun
 * @since 2017.01.06
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Ye16Ta160403DAO")
public class Ye16Ta160403DAO extends EgovAbstractDAO {

	/**
	 * YE160403???�록?�다.
	 * @param vo - ?�록???�보�??�긴 Ye160403VO
	 * @return ?�록 결과
	 * @exception Exception
	 */
    public String insertYe160403(Ye160403VO vo) throws Exception {
        return (String)insert("ye16Ta160403DAO.insertYe160403_S", vo);
    }

    /**
	 * YE160403???�정?�다.
	 * @param vo - ?�정???�보�??�긴 Ye160403VO
	 * @return void??
	 * @exception Exception
	 */
    public void updateYe160403(Ye160403VO vo) throws Exception {
        update("ye16Ta160403DAO.updateYe160403_S", vo);
    }

    /**
	 * YE160403????��?�다.
	 * @param vo - ??��???�보�??�긴 Ye160403VO
	 * @return void??
	 * @exception Exception
	 */
    public void deleteYe160403(Ye160403VO vo) throws Exception {
        delete("ye16Ta160403DAO.deleteYe160403_S", vo);
    }
    
    
    public void fnYeta1100_YE160403_2016_CREATE_Delete(Ye160403VO vo) throws Exception {
        delete("ye16Ta160403DAO.fnYeta1100_YE160403_2016_CREATE_Delete_S", vo);
    }
    
    
    /**
	 * YE160403????��?�다.
	 * @param vo - ??��???�보�??�긴 Ye160403VO
	 * @return void??
	 * @exception Exception
	 */
    public void deleteYeta1100ToYe160403(Ye160403VO vo) throws Exception {
        delete("ye16Ta160403DAO.deleteYeta1100ToYe160403_S", vo);
    }
    
    
    
    /**
	 * YE160402????��?�다.
	 * @param vo - ??��???�보�??�긴 Ye160402VO
	 * @return void??
	 * @exception Exception
	 */
    public void fnYeta1100_Ye160403_CREATE_Delete(Ye160403VO vo) throws Exception {
        delete("ye16Ta160403DAO.fnYeta1100_Ye160403_CREATE_Delete", vo);
    }
    

//    /**
//	 * YE160403??조회?�다.
//	 * @param vo - 조회???�보�??�긴 Ye160403VO
//	 * @return 조회??YE160403
//	 * @exception Exception
//	 */
//    public Ye160403VO selectYe160403(Ye160403VO vo) throws Exception {
//        return (Ye160403VO) select("ye16Ta160403DAO.selectYe160403_S", vo);
//    }
//
//    /**
//	 * YE160403 목록??조회?�다.
//	 * @param searchMap - 조회???�보�??�긴 Map
//	 * @return YE160403 목록
//	 * @exception Exception
//	 */
//    public List<?> selectYe160403List(Ye160403DefaultVO searchVO) throws Exception {
//        return list("ye16Ta160403DAO.selectYe160403List_D", searchVO);
//    }
//
//    /**
//	 * YE160403 �?�?���?조회?�다.
//	 * @param searchMap - 조회???�보�??�긴 Map
//	 * @return YE160403 �?�?��
//	 * @exception
//	 */
//    public int selectYe160403ListTotCnt(Ye160403DefaultVO searchVO) {
//        return (Integer)select("ye16Ta160403DAO.selectYe160403ListTotCnt_S", searchVO);
//    }

}
