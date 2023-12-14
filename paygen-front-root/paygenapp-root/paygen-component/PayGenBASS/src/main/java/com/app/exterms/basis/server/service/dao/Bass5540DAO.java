package com.app.exterms.basis.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.basis.server.vo.Bass5540SrhVO;
import com.app.exterms.basis.server.vo.Bass5540VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("Bass5540DAO")
public class Bass5540DAO extends EgovAbstractDAO {

	/**
	 * @param vo - 등록할 정보가 담긴 Bass5540VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertBass5540(Bass5540VO vo) throws Exception {
        return (String)insert("bass5540DAO.insertBass5540_S", vo);
    }

    /**
	 * @param vo - 수정할 정보가 담긴 Bass5540VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateBass5540(Bass5540VO vo) throws Exception {
        update("bass5540DAO.updateBass5540_S", vo);
    }

    /**
	 * @param vo - 삭제할 정보가 담긴 Bass5540VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteBass5540(Bass5540VO vo) throws Exception {
        delete("bass5540DAO.deleteBass5540_S", vo);
    }

    /**
	 * @param vo - 조회할 정보가 담긴 Bass5540VO
	 * @exception Exception
	 */
    public Bass5540VO selectBass5540(Bass5540VO vo) throws Exception {
        return (Bass5540VO) selectByPk("bass5540DAO.selectBass5540_S", vo);
    }

    /**
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @exception Exception
	 */
    public List selectBass5540List(Bass5540SrhVO searchVO) throws Exception {
        return list("bass5540DAO.selectBass5540List_D", searchVO);
    }

    /**
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @exception
	 */
    public int selectBass5540ListTotCnt(Bass5540SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bass5540DAO.selectBass5540ListTotCnt_S", searchVO);
    }
    
    /**
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @exception Exception
   	 */
       public List selectBass5540ToPayr4450List(Bass5540SrhVO searchVO) throws Exception {
           return list("bass5540DAO.selectBass5540ToPayr4450List_D", searchVO);
       }
       
   /**
  	 * @param searchMap - 조회할 정보가 담긴 Map
  	 * @exception Exception
  	 */
      public List selectBass5540ToPayr0480List(Bass5540SrhVO searchVO) throws Exception {
          return list("bass5540DAO.selectBass5540ToPayr0480List", searchVO);
      }

	/**
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @exception
   	 */
       public int selectBass5540ToPayr4450ListTotCnt(Bass5540SrhVO searchVO) {
           return (Integer)getSqlMapClientTemplate().queryForObject("bass5540DAO.selectBass5540ToPayr4450ListTotCnt_S", searchVO);
       }
       
       
       /** 지급공제 구분에 따른 지급공제항목 리스트 **/
		@SuppressWarnings("rawtypes")
		public List selectPayDducExtpyCd(Bass5540SrhVO bass5540SrhVo) {
			return list("bass5540DAO.selectBass5540AND480ToPayr4200List_D", bass5540SrhVo);
		}

}
