package com.app.smrmf.sysm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.sysm.server.service.vo.SysIfBass0150SrhVO;
import com.app.smrmf.sysm.server.service.vo.SysIfBass0150VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("SysIfBass0150DAO")
public class SysIfBass0150DAO extends EgovAbstractDAO {

	/**
	 * BASS0150을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Bass0150VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertBass0150(SysIfBass0150VO vo) throws Exception {
        return (String)insert("sysIfBass0150DAO.insertBass0150_S", vo);
    }

    /**
	 * BASS0150을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Bass0150VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateBass0150(SysIfBass0150VO vo) throws Exception {
        update("sysIfBass0150DAO.updateBass0150_S", vo);
    }

    /**
	 * BASS0150을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Bass0150VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteBass0150(SysIfBass0150VO vo) throws Exception {
        delete("sysIfBass0150DAO.deleteBass0150_S", vo);
    }

    /**
	 * BASS0150을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Bass0150VO
	 * @return 조회한 BASS0150
	 * @exception Exception
	 */
    public SysIfBass0150VO selectBass0150(SysIfBass0150VO vo) throws Exception {
        return (SysIfBass0150VO) selectByPk("sysIfBass0150DAO.selectBass0150_S", vo);
    }

    /**
	 * BASS0150 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0150 목록
	 * @exception Exception
	 */
    public List<?> selectBass0150List(SysIfBass0150SrhVO searchVO) throws Exception {
        return list("sysIfBass0150DAO.selectBass0150List_D", searchVO);
    }

    /**
	 * BASS0150 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0150 총 갯수
	 * @exception
	 */
    public int selectBass0150ListTotCnt(SysIfBass0150SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("sysIfBass0150DAO.selectBass0150ListTotCnt_S", searchVO);
    }
    
    
    /**
 	 * BASS0150 목록을 조회한다.
 	 * @param searchMap - 조회할 정보가 담긴 Map
 	 * @return BASS0150 목록
 	 * @exception Exception
 	 */
     public List<?> selectSysm0600ToBass0150List(SysIfBass0150SrhVO searchVO) throws Exception {
         return list("sysIfBass0150DAO.selectSysm0600ToBass0150List_D", searchVO);
     }

     /**
 	 * BASS0150 총 갯수를 조회한다.
 	 * @param searchMap - 조회할 정보가 담긴 Map
 	 * @return BASS0150 총 갯수
 	 * @exception
 	 */
     public int selectSysm0600ToBass0150ListTotCnt(SysIfBass0150SrhVO searchVO) {
         return (Integer)getSqlMapClientTemplate().queryForObject("sysIfBass0150DAO.selectSysm0600ToBass0150ListTotCnt_S", searchVO);
     }
    
    
    /** 신규 메뉴 추가  */
     

     /**
  	 * BASS0150 목록을 조회한다.
  	 * @param searchMap - 조회할 정보가 담긴 Map
  	 * @return BASS0150 목록
  	 * @exception Exception
  	 */
      public List<?> selectSysmUsr0500ToBass0150List(SysIfBass0150SrhVO searchVO) throws Exception {
          return list("sysIfBass0150DAO.selectSysmUsr0500ToBass0150List_D", searchVO);
      }

      /**
  	 * BASS0150 총 갯수를 조회한다.
  	 * @param searchMap - 조회할 정보가 담긴 Map
  	 * @return BASS0150 총 갯수
  	 * @exception
  	 */
      public int selectSysmUsr0500ToBass0150ListTotCnt(SysIfBass0150SrhVO searchVO) {
          return (Integer)getSqlMapClientTemplate().queryForObject("sysIfBass0150DAO.selectSysmUsr0500ToBass0150ListTotCnt_S", searchVO);
      }
     

}
