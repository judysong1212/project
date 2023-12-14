package com.app.exterms.basis.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.basis.server.vo.Bass0360SrhVO;
import com.app.exterms.basis.server.vo.Bass0360VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("Bass0360DAO")
public class Bass0360DAO  extends EgovAbstractDAO{
	
	/**
	 * BASS0360을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Bass0360VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	 @Transactional
    public String insertBass0360(Bass0360VO vo) throws Exception {
        return (String)insert("bass0360DAO.insertBass0360_S", vo);
    }

    /**
	 * BASS0360을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Bass0360VO
	 * @return void형
	 * @exception Exception
	 */
	 @Transactional
    public void updateBass0360(Bass0360VO vo) throws Exception {
        update("bass0360DAO.updateBass0360_S", vo);
    }

    /**
	 * BASS0360을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Bass0360VO
	 * @return void형 
	 * @exception Exception
	 */
	 @Transactional
    public void deleteBass0360(Bass0360VO vo) throws Exception {
        delete("bass0360DAO.deleteBass0360_S", vo);
    }

    /**
	 * BASS0360을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Bass0360VO
	 * @return 조회한 BASS0360
	 * @exception Exception
	 */
    public Bass0360VO selectBass0360(Bass0360VO vo) throws Exception {
        return (Bass0360VO) selectByPk("bass0360DAO.selectBass0360_S", vo);
    }

//    /**
//	 * BASS0360 목록을 조회한다.
//	 * @param searchMap - 조회할 정보가 담긴 Map
//	 * @return BASS0360 목록
//	 * @exception Exception
//	 */
//    public List<?> selectBass0360List(Bass0360SrhVO searchVO) throws Exception {
//        return list("bass0360DAO.selectBass0360List_D", searchVO);
//    }
//
//    /**
//	 * BASS0360 총 갯수를 조회한다.
//	 * @param searchMap - 조회할 정보가 담긴 Map
//	 * @return BASS0360 총 갯수
//	 * @exception
//	 */
//    public int selectBass0360ListTotCnt(Bass0360SrhVO searchVO) {
//        return (Integer)select("bass0360DAO.selectBass0360ListTotCnt_S", searchVO);
//    }
    
//	@SuppressWarnings("rawtypes")
//	public List selectBass0360List(Bass0360SrhVO Srhvo) throws Exception {
//		return list("bass0360DAO.selectBass0360List", Srhvo);
//	}	
//	public int selectBass0360ListTotCnt(Bass0360SrhVO Srhvo) {
//		return (Integer) getSqlMapClientTemplate().queryForObject("bass0360DAO.selectBass0360ListTotCnt", Srhvo);
//	}
	public List selectBass0360AllList() {
		
		return list("bass0360DAO.selectBass0360AllList","");
	}
	

  /**
	 * BASS0360 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0360 목록
	 * @exception Exception
	 */
  public List<?> selectBass0450ToBass0360List(Bass0360SrhVO searchVO) throws Exception {
      return list("bass0360DAO.selectBass0450ToBass0360List_D", searchVO);
  }

  /**
	 * BASS0360 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0360 총 갯수
	 * @exception
	 */
  public int selectBass0450ToBass0360ListTotCnt(Bass0360SrhVO searchVO) {
      return (Integer)getSqlMapClientTemplate().queryForObject("bass0360DAO.selectBass0450ToBass0360ListTotCnt_S", searchVO);
  }
  
	 
	
}
