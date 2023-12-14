package com.app.smrmf.sysm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.sysm.server.service.vo.SysComSearchVO;
import com.app.smrmf.sysm.server.service.vo.SysIfPsnl0100VO;
import com.app.smrmf.sysm.server.vo.system.SsoxUserSrhVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
//import com.googlecode.ehcache.annotations.Cacheable;

/**
 * @Class Name : Bass0300DAO.java
 * @Description : Bass0300 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.03
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("SysIfPkgSmrmfDAO")
public class SysIfPkgSmrmfDAO extends EgovAbstractDAO  { 
	 
   
    public List selectBass0300List(SysComSearchVO searchVO) throws Exception {
        return list("msfPkgSmrmfDAO.selectBass0300List_D", searchVO);
    }

    /**
	 * BASS0300 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0300 총 갯수
	 * @exception
	 */ 
   
    
    public int selectBass0300ListTotCnt(SysComSearchVO searchVO) throws Exception {
        return (Integer)getSqlMapClientTemplate().queryForObject("msfPkgSmrmfDAO.selectBass0300ListTotCnt_S", searchVO);
    }
    
    /**
     * BASS0350 직종구하는 쿼리 
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return BASS0350 목록
     * @exception Exception
     */
    //@Cacheable(value = "typOccuCdCache")  
    public List selectBass0320TypOccuCdList(SysComSearchVO searchVO) throws Exception {
        return list("msfPkgSmrmfDAO.selectBass0320TypOccuCdList_D", searchVO);
    }
    
    /**
   	 * BASS0350 총 갯수를 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return BASS0350 총 갯수
   	 * @exception
   	 */
      // @Cacheable(cacheName = "typOccuCdCache")  
       public int selectSysIfBass0350ListTotCnt(SysComSearchVO searchVO) {
           return (Integer)getSqlMapClientTemplate().queryForObject("msfPkgSmrmfDAO.selectSysIfBass0350ListTotCnt_S", searchVO);
       }
       
       /**
   	 * BASS0350 목록을 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return BASS0350 목록
   	 * @exception Exception
   	 */
     //  @Cacheable(cacheName = "typOccuCdCache")  
       public List selectSysIfBass0350List(SysComSearchVO searchVO) throws Exception {
           return list("msfPkgSmrmfDAO.selectSysIfBass0350List_D", searchVO);
       }

       
    /**
     * BASS0350 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return BASS0350 목록
     * @exception Exception
     */
  //  @Cacheable(cacheName = "typOccuCdCache")  
    public List selectBass0350ComboTypOccuCdList(SysComSearchVO searchVO) throws Exception {
        return list("msfPkgSmrmfDAO.selectBass0350ComboTypOccuCdList_D", searchVO);
    }

    /**
     * BASS0350 총 갯수를 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return BASS0350 총 갯수
     * @exception
     */
   // @Cacheable(cacheName = "typOccuCdCache")  
    public int selectBass0350ComboTypOccuCdListTotCnt(SysComSearchVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("msfPkgSmrmfDAO.selectBass0350ComboTypOccuCdListTotCnt_S", searchVO);
    }
    
    
    /**
     * BASS0400 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return BASS0400 목록
     * @exception Exception
     */
    
    public List selectPayrWithBass0400List(SysComSearchVO searchVO) throws Exception {
        return list("msfPkgSmrmfDAO.selectPayrWithBass0400List_D", searchVO);
    }
     

    /**
     * BASS0400 총 갯수를 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return BASS0400 총 갯수
     * @exception
     */
   // @Cacheable(cacheName = "deptCache")  
    public int selectPayrWithBass0400ListTotCnt(SysComSearchVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("msfPkgSmrmfDAO.selectPayrWithBass0400ListTotCnt_S", searchVO);
    }
    
    
    /**
     * BASS0400 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return BASS0400 목록
     * @exception Exception
     */
  //  @Cacheable(value = "deptCache")  
    public List selectBass0400ComboList(SysComSearchVO searchVO) throws Exception {
        return list("msfPkgSmrmfDAO.selectBass0400List_D", searchVO);
    } 
    
    /**
 	 * BASS0300 목록을 조회한다.
 	 * @param searchMap - 조회할 정보가 담긴 Map
 	 * @return BASS0300 목록
 	 * @exception Exception
 	 * 
 	 */
    
     public List selectBass0300ComboList(SysComSearchVO searchVO) throws Exception {
         return list("msfPkgSmrmfDAO.selectBass0300List_D", searchVO);
     }
     
     
     /**
 	 * SSOX_USER 목록을 조회한다.
 	 * @param searchMap - 조회할 정보가 담긴 Map
 	 * @return SSOX_USER 목록
 	 * @exception Exception
 	 */
     public List selectSsoxIfUserList(SsoxUserSrhVO searchVO) throws Exception {
         return list("msfPkgSmrmfDAO.selectSsoxIfUserList_D", searchVO);
     }

     /**
 	 * SSOX_USER 총 갯수를 조회한다.
 	 * @param searchMap - 조회할 정보가 담긴 Map
 	 * @return SSOX_USER 총 갯수
 	 * @exception
 	 */
     public int selectSsoxIfUserListTotCnt(SsoxUserSrhVO searchVO) {
         return (Integer)getSqlMapClientTemplate().queryForObject("msfPkgSmrmfDAO.selectSsoxIfUserListTotCnt_S", searchVO);
     }
     
     
     /**
 	 * PSNL0100 총 갯수를 조회한다.
 	 * @param searchMap - 조회할 정보가 담긴 Map
 	 * @return PSNL0100 총 갯수
 	 * @exception
 	 */
     public int selectPsnl0100ListTotCnt(SysComSearchVO  sysIfSearchVO) {
         return (Integer)getSqlMapClientTemplate().queryForObject("msfPkgSmrmfDAO.selectPsnl0100ListTotCnt_S", sysIfSearchVO);
     }
     
     
     /**
 	 * PSNL0100 목록을 조회한다.
 	 * @param searchMap - 조회할 정보가 담긴 Map
 	 * @return PSNL0100 목록
 	 * @exception Exception
 	 */
     public List selectPsnl0100List(SysComSearchVO  sysIfSearchVO) throws Exception {
         return list("msfPkgSmrmfDAO.selectPsnl0100List_D", sysIfSearchVO);
     }
     
     /**
      * BASS0350 목록을 조회한다.
      * @param searchMap - 조회할 정보가 담긴 Map
      * @return BASS0350 목록
      * @exception Exception
      */
     public List selectBass0320ComboTypOccuCdList(SysComSearchVO  sysIfSearchVO) throws Exception {
         return list("msfPkgSmrmfDAO.selectBass0320ComboTypOccuCdList_D", sysIfSearchVO);
     }
     
     /**
      * BASS0350 총 갯수를 조회한다.
      * @param searchMap - 조회할 정보가 담긴 Map
      * @return BASS0350 총 갯수
      * @exception
      */
    // @Cacheable(cacheName = "typOccuCdCache")  
     public int selectBass0320ComboTypOccuCdListTotCnt(SysComSearchVO  sysIfSearchVO) {
         return (Integer)getSqlMapClientTemplate().queryForObject("msfPkgSmrmfDAO.selectBass0320ComboTypOccuCdListTotCnt_S", sysIfSearchVO);
     }
     
     

     public List setFuncBeforComboBass0400List(SysComSearchVO  sysIfSearchVO) throws Exception {
         return list("msfPkgSmrmfDAO.setFuncBeforComboBass0400List_D", sysIfSearchVO);
     }
     
     public List setFuncBeforComboBass0320List(SysComSearchVO  sysIfSearchVO) throws Exception {
         return list("msfPkgSmrmfDAO.setFuncBeforComboBass0320List_D", sysIfSearchVO);
     }
     
     public List setFuncBeforComboBass0350List(SysComSearchVO  sysIfSearchVO) throws Exception {
         return list("msfPkgSmrmfDAO.setFuncBeforComboBass0350List_D", sysIfSearchVO);
     }
     
     /**
      * SYSM0100을 조회한다.
      * @param vo - 조회할 정보가 담긴 SysIfSysm0100VO
      * @return 조회한 SYSM0100
      * @exception Exception
      */
     public SysIfPsnl0100VO selectPsnlUser0100(SysIfPsnl0100VO vo) throws Exception {
         return (SysIfPsnl0100VO) selectByPk("msfPkgSmrmfDAO.selectPsnlUser0100_S", vo);
     }

         
}
