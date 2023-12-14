package com.app.exterms.prgm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.prgm.server.vo.PrgmComBass0320VO;
import com.app.exterms.prgm.server.vo.PrgmComSearchVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass0320DAO.java
 * @Description : Bass0320 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.11.09
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("PrgmComBass0320DAO")
public class PrgmComBass0320DAO extends EgovAbstractDAO {

	/**
	 * BASS0320을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Bass0320VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertBass0320(PrgmComBass0320VO vo) throws Exception {
        return (String)insert("prgmComBass0320DAO.insertBass0320_S", vo);
    }

    /**
	 * BASS0320을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Bass0320VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateBass0320(PrgmComBass0320VO vo) throws Exception {
        update("prgmComBass0320DAO.updateBass0320_S", vo);
    }

    /**
	 * BASS0320을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Bass0320VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteBass0320(PrgmComBass0320VO vo) throws Exception {
        delete("prgmComBass0320DAO.deleteBass0320_S", vo);
    }

    /**
	 * BASS0320을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Bass0320VO
	 * @return 조회한 BASS0320
	 * @exception Exception
	 */
    public PrgmComBass0320VO selectBass0320(PrgmComBass0320VO vo) throws Exception {
        return (PrgmComBass0320VO) selectByPk("prgmComBass0320DAO.selectBass0320_S", vo);
    }

    /**
	 * BASS0320 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0320 목록
	 * @exception Exception
	 */
    public List<?> selectBass0320List(PrgmComSearchVO searchVO) throws Exception {
        return list("prgmComBass0320DAO.selectBass0320List_D", searchVO);
    }

    /**
	 * BASS0320 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0320 총 갯수
	 * @exception
	 */
    public int selectBass0320ListTotCnt(PrgmComSearchVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("prgmComBass0320DAO.selectBass0320ListTotCnt_S", searchVO);
    }
    
    
    
    /**
     * BASS0350 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return BASS0350 목록
     * @exception Exception
     */
  //  @Cacheable(cacheName = "typOccuCdCache")  
    public List selectBass0320ComboTypOccuCdList(PrgmComSearchVO searchVO) throws Exception {
        return list("prgmComBass0320DAO.selectBass0320ComboTypOccuCdList_D", searchVO);
    }

    /**
     * BASS0350 총 갯수를 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return BASS0350 총 갯수
     * @exception
     */
   // @Cacheable(cacheName = "typOccuCdCache")  
    public int selectBass0320ComboTypOccuCdListTotCnt(PrgmComSearchVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("prgmComBass0320DAO.selectBass0320ComboTypOccuCdListTotCnt_S", searchVO);
    }
    
    
   /**
    * BASS0350 직종구하는 쿼리 
    * @param searchMap - 조회할 정보가 담긴 Map
    * @return BASS0350 목록
    * @exception Exception
    */
   //@Cacheable(value = "typOccuCdCache")  
   public List selectBass0320TypOccuCdList(PrgmComSearchVO searchVO) throws Exception {
       return list("prgmComBass0320DAO.selectBass0320TypOccuCdList_D", searchVO);
   }
   
   public List selectNonBass0320TypOccuCdList(PrgmComSearchVO searchVO) throws Exception {
       return list("prgmComBass0320DAO.selectNonBass0320TypOccuCdList_D", searchVO);
   }
      

}
