package com.app.exterms.basis.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.basis.server.vo.Bass0600SrhVO;
import com.app.exterms.basis.server.vo.Bass0600VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass0600DAO.java
 * @Description : Bass0600 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.14
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Bass0600DAO")
public class Bass0600DAO extends EgovAbstractDAO {

	/**
	 * BASS0600을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Bass0600VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertBass0600(Bass0600VO vo) throws Exception {
        return (String)insert("bass0600DAO.insertBass0600_S", vo);
    }

    /**
	 * BASS0600을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Bass0600VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateBass0600(Bass0600VO vo) throws Exception {
        update("bass0600DAO.updateBass0600_S", vo);
    }
    
    @Transactional
    public void updatePsnl0115(Bass0600VO vo) throws Exception {
        update("bass0600DAO.updatePsnl0115_S", vo);
    }
    
    @Transactional
    public void updatePayr0530(Bass0600VO vo) throws Exception {
        update("bass0600DAO.updatePayr0530_S", vo);
    }
    
    
    /**
	 * BASS0600을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Bass0600VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteBass0600(Bass0600VO vo) throws Exception {
        delete("bass0600DAO.deleteBass0600_S", vo);
    }

    /**
	 * BASS0600을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Bass0600VO
	 * @return 조회한 BASS0600
	 * @exception Exception
	 */
    public Bass0600VO selectBass0600(Bass0600VO vo) throws Exception {
        return (Bass0600VO) selectByPk("bass0600DAO.selectBass0600_S", vo);
    }

    /**
	 * BASS0600 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0600 목록
	 * @exception Exception
	 */
    public List selectBass0600List(Bass0600SrhVO searchVO) throws Exception {
        return list("bass0600DAO.selectBass0600List_D", searchVO);
    }
    
    
    //암호화 패치를 위해 임시로 적용 함 
    public List selectYetaAllList() throws Exception {
        return list("bass0600DAO.selectYetaAllList_D", null);
    }
    
    public void updateYetaAll(Bass0600VO vo) throws Exception {
        update("bass0600DAO.updateYetaAll_S", vo);
    }  
    
    /**
 	 * BASS0600 목록을 조회한다.
 	 * @param searchMap - 조회할 정보가 담긴 Map
 	 * @return BASS0600 목록
 	 * @exception Exception
 	 */
     public List selectBass0600ToPsnl0115List(Bass0600SrhVO searchVO) throws Exception {
         return list("bass0600DAO.selectBass0600ToPsnl0115List_D", searchVO);
     }

    /**
	 * BASS0600 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0600 총 갯수
	 * @exception
	 */
    public int selectBass0600ListTotCnt(Bass0600SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bass0600DAO.selectBass0600ListTotCnt_S", searchVO);
    }
    
    /**
 	 * BASS0600 목록을 조회한다.
 	 * @param searchMap - 조회할 정보가 담긴 Map
 	 * @return BASS0600 목록
 	 * @exception Exception
 	 */
     public List selectBass0600ToPayr0530List(Bass0600SrhVO searchVO) throws Exception {
         return list("bass0600DAO.selectBass0600ToPayr0530List_D", searchVO);
     }
 

}
