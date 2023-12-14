package com.app.exterms.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.payroll.server.vo.Payr0410SrhVO;
import com.app.exterms.payroll.server.vo.Payr0410VO;
import com.app.exterms.payroll.server.vo.Payr0490VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0410DAO.java
 * @Description : Payr0410 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Payr0410DAO")
public class Payr0410DAO extends EgovAbstractDAO {

	/**
	 * PAYR0410을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0410VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPayr0410(Payr0410VO vo) throws Exception {
        return (String)insert("payr0410DAO.insertPayr0410_S", vo);
    }

    /**
	 * PAYR0410을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0410VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePayr0410(Payr0410VO vo) throws Exception {
        update("payr0410DAO.updatePayr0410_S", vo);
    }

    /**
	 * PAYR0410을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0410VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePayr0410(Payr0410VO vo) throws Exception {
        delete("payr0410DAO.deletePayr0410_S", vo);
    }
    
    
    /**
  	 * PAYR0410을 삭제한다.
  	 * @param vo - 삭제할 정보가 담긴 Payr0410VO
  	 * @return void형 
  	 * @exception Exception
  	 */
      @Transactional
      public void deletePayr510002To0410(Payr0410VO vo) throws Exception {
          delete("payr0410DAO.deletePayr510002To0410_S", vo);
      }
    
    
    /**
     * PAYR0410을 삭제한다.(이관)
     * @param vo - 삭제할 정보가 담긴 Payr0410VO
     * @return void형 
     * @exception Exception
     */
    @Transactional
    public void deleteBfToNewPayr0410(Payr0410VO vo) throws Exception {
        delete("payr0410DAO.deleteBfToNewPayr0410_S", vo);
    }
 
    /**
	 * PAYR0410을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0410VO
	 * @return 조회한 PAYR0410
	 * @exception Exception
	 */
    public Payr0410VO selectPayr0410(Payr0410VO vo) throws Exception {
        return (Payr0410VO) selectByPk("payr0410DAO.selectPayr0410_S", vo);
    }

    /**
	 * PAYR0410 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0410 목록
	 * @exception Exception
	 */
    public List selectPayr0410List(Payr0410SrhVO searchVO) throws Exception {
        return list("payr0410DAO.selectPayr0410List_D", searchVO);
    }
    
    
    /**
   	 * PAYR0410 목록을 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return PAYR0410 목록
   	 * @exception Exception
   	 */
       public List selectXlsPayr1500List(Payr0410SrhVO searchVO) throws Exception {
           return list("payr0410DAO.selectXlsPayr1500List_D", searchVO);
       }

    /**
     * PAYR0410 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return PAYR0410 목록
     * @exception Exception
     */
    public List selectPayr0410ToPayr0420List(Payr0410SrhVO searchVO) throws Exception {
        return list("payr0410DAO.selectPayr0410ToPayr0420List_D", searchVO);
    }
    
    

    /**
	 * PAYR0410 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0410 총 갯수
	 * @exception
	 */
    public int selectPayr0410ListTotCnt(Payr0410SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0410DAO.selectPayr0410ListTotCnt_S", searchVO);
    }
    
    
    /**
     * 직종세지급항목설정일괄생성
     * */
    public List selectPayr150002ToPayr0410List(Payr0410SrhVO searchVO) throws Exception {
        return list("payr0410DAO.selectPayr150002ToPayr0410List_D", searchVO);
    }
    /**
     * 직종세지급항목설정일괄생성
     * */
    public int selectPayr150002ToPayr0410ListTotCnt(Payr0410SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0410DAO.selectPayr150002ToPayr0410ListTotCnt_S", searchVO);
    }
    
    /**
     * PAYR0410을 등록한다.
     * @param vo - 등록할 정보가 담긴 Payr0410VO
     * @return 등록 결과
     * @exception Exception
     */
    @Transactional
    public String insertCopyPayr0410(Payr0410VO vo) throws Exception {
    	return (String)insert("payr0410DAO.trurCopyInsertPayr0410_S", vo);
    }
    
    /**
     * 직종세지급항목 복사 팝업
     * */
    public List selectPayr150003ToPayr0410List(Payr0410SrhVO searchVO) throws Exception {
        return list("payr0410DAO.selectPayr150003ToPayr0410List_D", searchVO);
    }
    /**
     * 직종세지급항목 복사 팝업
     * */
    public int selectPayr150003ToPayr0410ListTotCnt(Payr0410SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0410DAO.selectPayr150003ToPayr0410ListTotCnt_S", searchVO);
    }
    

}
