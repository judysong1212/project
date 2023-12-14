package com.app.exterms.basis.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.basis.client.dto.Bass0120DTO;
import com.app.exterms.basis.server.vo.Bass0120SrhVO;
import com.app.exterms.basis.server.vo.Bass0120VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass0120DAO.java
 * @Description : Bass0120 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Bass0120DAO")
public class Bass0120DAO extends EgovAbstractDAO {
	
	@SuppressWarnings("rawtypes")
	public List getParentDpobCd() throws Exception{
		return list("bass0120DAO.getParentDpobCd", null);
	} 
	
	// 시스템 사업장 코드를 가져옴
	@SuppressWarnings("rawtypes")
	public List getSysDpobCd() throws Exception{
		return list("bass0120DAO.getSysDpobCd", null);
	}
	
	@SuppressWarnings("rawtypes")
	public List getParentRetryCllnDebrDivCd() throws Exception{
		return list("bass0120DAO.selectBass0120RetryCllnDebrDivCdList", null);
	}

	// 사용 시스템 구분 코드를 가져옴
	@SuppressWarnings("rawtypes")
	public List selectBass0120sysDivCdList() throws Exception{
		return list("bass0120DAO.getUseSysDivCd", null);
	}
	/**		
	@Transactional
	public int saveBass0120(InfcBass0120DTO dto) throws Exception{
		return update("bass0120DAO.saveBass0120", dto);
	}
	 */	
	
	@Transactional
	public int saveBass0120(Bass0120DTO dto) throws Exception{
		return update("bass0120DAO.saveBass0120", dto);
	}
	/**
	 * BASS0120을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Bass0120VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	@Transactional
    public String insertBass0120(Bass0120VO vo) throws Exception {
        return (String)insert("bass0120DAO.insertBass0120_S", vo);
    }

    /**
	 * BASS0120을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Bass0120VO
	 * @return void형
	 * @exception Exception
	 */
	@Transactional
    public void updateBass0120(Bass0120VO vo) throws Exception {
        update("bass0120DAO.updateBass0120_S", vo);
    }

    /**
	 * BASS0120을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Bass0120VO
	 * @return void형 
	 * @exception Exception
	 */
	/**
	@Transactional
    public int deleteBass0120(InfcBass0120DTO dto) throws Exception {
        return delete("bass0120DAO.deleteBass0120_S", dto);
    }
	*/
	@Transactional
    public int deleteBass0120(Bass0120DTO dto) throws Exception {
        return delete("bass0120DAO.deleteBass0120_S", dto);
    }

    /**
	 * BASS0120을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Bass0120VO
	 * @return 조회한 BASS0120
	 * @exception Exception
	 */
    public Bass0120VO selectBass0120(Bass0120VO vo) throws Exception {
        return (Bass0120VO) selectByPk("bass0120DAO.selectBass0120_S", vo);
    }

    /**
	 * BASS0120 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0120 목록
	 * @exception Exception
	 */
    public List selectBass0120List(Bass0120SrhVO searchVO) throws Exception {
        return list("bass0120DAO.selectBass0120List_D", searchVO);
    }

    /**
	 * BASS0120 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0120 총 갯수
	 * @exception
	 */
    public int selectBass0120ListTotCnt(Bass0120SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bass0120DAO.selectBass0120ListTotCnt_S", searchVO);
    }

    public int sum(int a, int b){
    	return a+b;
    }
}
