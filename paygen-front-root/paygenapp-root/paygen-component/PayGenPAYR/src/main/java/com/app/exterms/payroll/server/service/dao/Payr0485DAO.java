package com.app.exterms.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.payroll.server.vo.Payr0485SrhVO;
import com.app.exterms.payroll.server.vo.Payr0485VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0485DAO.java
 * @Description : Payr0485 DAO Class
 * @Modification Information
 *
 * @author BaeDaEun
 * @since 2016.12..20
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Payr0485DAO")
public class Payr0485DAO extends EgovAbstractDAO {

    @SuppressWarnings("rawtypes")
    public List selectXlsPayr1450List(Payr0485SrhVO payr0485SrhVO) {
        return list("payr0485DAO.selectXlsPayr1450List", payr0485SrhVO);
    }
	
/**
 * PAYR0485 총 갯수를 조회한다.
 * @param searchMap - 조회할 정보가 담긴 Map
 * @return PAYR0485 총 갯수
 * @exception
 */
public int selectPayr0485ListTotCnt(Payr0485SrhVO searchVO) {
    return (Integer)getSqlMapClientTemplate().queryForObject("payr0485DAO.selectPayr0485ListTotCnt_S", searchVO);
}
	
  /**
	 * PAYR0485 목록을 조회한다.(엑셀 양식 출력)
	 * @param searchVO - 조회할 정보가 담긴 searchVO
	 * @return PAYR0485 목록
	 * @exception Exception
	 */
  public List selectPayr0485List(Payr0485SrhVO searchVO) throws Exception {
      return list("payr0485DAO.selectPayr0485_S", searchVO);
  }
	
  /**
 	 * PAYR0485 목록을 조회한다.
 	 * @param searchMap - 조회할 정보가 담긴 Map
 	 * @return PAYR04850 목록
 	 * @exception Exception
 	 */
 public List selectPayr0145ToPayr0485List(Payr0485SrhVO searchVO) throws Exception {
     return list("payr0485DAO.selectPayr0145ToPayr0485List", searchVO);
 }	
	/**
	 * PAYR0485을 등록한다.
	 * @param vo - 등록할 정보가 담긴 PAYR0485
	 * @return 등록 결과
	 * @exception Exception
	 */
 public String insertPayr0485(Payr0485VO vo) throws Exception {
     return (String)insert("payr0485DAO.insertPayr0485_I", vo);
 }	
 
	/**
	 * PAYR0485을 수정한다
	 * @param vo - 등록할 정보가 담긴 PAYR0485
	 * @return 등록 결과
	 * @exception Exception
	 */
public void updatePayr0485(Payr0485VO vo) throws Exception {
	update("payr0485DAO.updatePayr0485_I", vo);
}


/**
 * PAYR0485을 수정한다
 * @param vo - 등록할 정보가 담긴 PAYR0485
 * @return 등록 결과
 * @exception Exception
 */
public void payrUpdate0485Yn(Payr0485VO vo) throws Exception {
update("payr0485DAO.payrUpdate0485Yn", vo);
}

/**
* PAYR0485을 수정한다
* @param vo - PAYR0485에서 미사용시 payr0302에 없으면 삭제
* @return 등록 결과
* @exception Exception
*/
public void payrDelte0485(Payr0485VO vo) throws Exception {
update("payr0485DAO.payrDelte0485", vo);
}
//	/**
//	 * PAYR0485???�록?�다.
//	 * @param vo - ?�록???�보�??�긴 Payr0485VO
//	 * @return ?�록 결과
//	 * @exception Exception
//	 */
//    public String insertPayr0485(Payr0485VO vo) throws Exception {
//        return (String)insert("payr0485DAO.insertPayr0485_S", vo);
//    }
//
//    /**
//	 * PAYR0485???�정?�다.
//	 * @param vo - ?�정???�보�??�긴 Payr0485VO
//	 * @return void??
//	 * @exception Exception
//	 */
//    public void updatePayr0485(Payr0485VO vo) throws Exception {
//        update("payr0485DAO.updatePayr0485_S", vo);
//    }
//
//    /**
//	 * PAYR0485????��?�다.
//	 * @param vo - ??��???�보�??�긴 Payr0485VO
//	 * @return void??
//	 * @exception Exception
//	 */
//    public void deletePayr0485(Payr0485VO vo) throws Exception {
//        delete("payr0485DAO.deletePayr0485_S", vo);
//    }
//
//    /**
//	 * PAYR0485??조회?�다.
//	 * @param vo - 조회???�보�??�긴 Payr0485VO
//	 * @return 조회??PAYR0485
//	 * @exception Exception
//	 */
//    public Payr0485VO selectPayr0485(Payr0485VO vo) throws Exception {
//        return (Payr0485VO) select("payr0485DAO.selectPayr0485_S", vo);
//    }
//
//    /**
//	 * PAYR0485 목록??조회?�다.
//	 * @param searchMap - 조회???�보�??�긴 Map
//	 * @return PAYR0485 목록
//	 * @exception Exception
//	 */
//    public List<?> selectPayr0485List(Payr0485SrhVO searchVO) throws Exception {
//        return list("payr0485DAO.selectPayr0485List_D", searchVO);
//    }
//
//    /**
//	 * PAYR0485 �?�?���?조회?�다.
//	 * @param searchMap - 조회???�보�??�긴 Map
//	 * @return PAYR0485 �?�?��
//	 * @exception
//	 */
//    public int selectPayr0485ListTotCnt(Payr0485SrhVO searchVO) {
//        return (Integer)select("payr0485DAO.selectPayr0485ListTotCnt_S", searchVO);
//    }

}
