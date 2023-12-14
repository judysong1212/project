package com.app.exterms.basis.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.basis.server.vo.Bass0320SrhVO;
import com.app.exterms.basis.server.vo.Bass0320VO;

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

@Repository("Bass0320DAO")
public class Bass0320DAO extends EgovAbstractDAO {

	/**
	 * BASS0320을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Bass0320VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertBass0320(Bass0320VO vo) throws Exception {
        return (String)insert("bass0320DAO.insertBass0320_S", vo);
    }

    /**
	 * BASS0320을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Bass0320VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateBass0320(Bass0320VO vo) throws Exception {
        update("bass0320DAO.updateBass0320_S", vo);
    }

    /**
	 * BASS0320을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Bass0320VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteBass0320(Bass0320VO vo) throws Exception {
        delete("bass0320DAO.deleteBass0320_S", vo);
    }

    /**
	 * BASS0320을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Bass0320VO
	 * @return 조회한 BASS0320
	 * @exception Exception
	 */
    public Bass0320VO selectBass0320(Bass0320VO vo) throws Exception {
        return (Bass0320VO) selectByPk("bass0320DAO.selectBass0320_S", vo);
    }

    /**
	 * BASS0320 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0320 목록
	 * @exception Exception
	 */
    public List<?> selectBass0320List(Bass0320SrhVO searchVO) throws Exception {
        return list("bass0320DAO.selectBass0320List_D", searchVO);
    }

    /**
	 * BASS0320 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0320 총 갯수
	 * @exception
	 */
    public int selectBass0320ListTotCnt(Bass0320SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bass0320DAO.selectBass0320ListTotCnt_S", searchVO);
    }
    
    /**
	 * BASS0320 Excel 데이터를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0320 Excel
	 * @exception
	 */
	public List selectXlsBass0320List(Bass0320SrhVO bass0320SrhVo) {
		
		return list("bass0320DAO.selectXlsBass0320List_D", bass0320SrhVo);
	}
	
	public String insertXlsBass0320(Bass0320VO bass0320vo)throws Exception {
		
		return (String)insert("bass0320DAO.insertXlsBass0320_S",bass0320vo);
	}
	
	public void updateXlsBass0320(Bass0320VO bass0320vo)throws Exception {
		
		update("bass0320DAO.updateXlsBass0320_S",bass0320vo);
	}

}
