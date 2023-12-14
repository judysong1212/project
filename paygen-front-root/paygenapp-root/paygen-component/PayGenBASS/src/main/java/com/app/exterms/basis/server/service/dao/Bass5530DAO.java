package com.app.exterms.basis.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.basis.server.vo.Bass5530SrhVO;
import com.app.exterms.basis.server.vo.Bass5530VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("Bass5530DAO")
public class Bass5530DAO extends EgovAbstractDAO {

	/**
	 * @param vo - 등록할 정보가 담긴 Bass5530VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertBass5530(Bass5530VO vo) throws Exception {
        return (String)insert("bass5530DAO.insertBass5530_S", vo);
    }

    /**
	 * @param vo - 수정할 정보가 담긴 Bass5530VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateBass5530(Bass5530VO vo) throws Exception {
        update("bass5530DAO.updateBass5530_S", vo);
    }

    /**
	 * @param vo - 삭제할 정보가 담긴 Bass5530VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteBass5530(Bass5530VO vo) throws Exception {
        delete("bass5530DAO.deleteBass5530_S", vo);
    }

    /**
	 * @param vo - 조회할 정보가 담긴 Bass5530VO
	 * @exception Exception
	 */
    public Bass5530VO selectBass5530(Bass5530VO vo) throws Exception {
        return (Bass5530VO) selectByPk("bass5530DAO.selectBass5530_S", vo);
    }

    /**
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @exception Exception
	 */
    public List  selectBass5530List(Bass5530SrhVO searchVO) throws Exception {
        return (List)list("bass5530DAO.selectBass5530List_D", searchVO);
    }

    /**
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @exception
	 */
    public int selectBass5530ListTotCnt(Bass5530SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bass5530DAO.selectBass5530ListTotCnt_S", searchVO);
    }
    
    /**
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @exception Exception
   	 */
       public List selectBass5530ToPayr4450List(Bass5530SrhVO searchVO) throws Exception {
           return  (List)list("bass5530DAO.selectBass5530ToPayr4450List_D", searchVO);
       }

       /**
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @exception
   	 */
       public int selectBass5530ToPayr4450ListTotCnt(Bass5530SrhVO searchVO) {
               
           return  (Integer)getSqlMapClientTemplate().queryForObject("bass5530DAO.selectBass5530ToPayr4450ListTotCnt_S", searchVO);
       }
       

    
    
}
