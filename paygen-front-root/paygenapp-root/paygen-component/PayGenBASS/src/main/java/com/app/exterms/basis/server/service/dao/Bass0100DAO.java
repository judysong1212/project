package com.app.exterms.basis.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.basis.client.dto.Bass0100DTO;
import com.app.exterms.basis.server.vo.Bass0100SrhVO;
import com.app.exterms.basis.server.vo.Bass0100VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass0100DAO.java
 * @Description : Bass0100 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Bass0100DAO")
public class Bass0100DAO extends EgovAbstractDAO {
	
	@SuppressWarnings("rawtypes")
	public List getParentDpobCd() throws Exception{
		return list("bass0100DAO.getParentDpobCd", null);
	}
	
	
	
	// 시스템 사업장 코드를 가져옴
	@SuppressWarnings("rawtypes")
	public List getSysDpobCd() throws Exception{
		return list("bass0100DAO.getSysDpobCd", null);
	}
	
	@SuppressWarnings("rawtypes")
	public List getParentRetryCllnDebrDivCd() throws Exception{
		return list("bass0100DAO.selectBass0100RetryCllnDebrDivCdList", null);
	}

	// 사용 시스템 구분 코드를 가져옴
	@SuppressWarnings("rawtypes")
	public List selectBass0100sysDivCdList() throws Exception{
		return list("bass0100DAO.getUseSysDivCd", null);
	}
	/**		
	@Transactional
	public int saveBass0100(InfcBass0100DTO dto) throws Exception{
		return update("bass0100DAO.saveBass0100", dto);
	}
	 */	
	
	@Transactional
	public int saveBass0100(Bass0100DTO dto) throws Exception{
		return update("bass0100DAO.saveBass0100", dto);
	}
	/**
	 * BASS0100을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Bass0100VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	@Transactional
    public String insertBass0100(Bass0100VO vo) throws Exception {
        return (String)insert("bass0100DAO.insertBass0100_S", vo);
    }

    /**
	 * BASS0100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Bass0100VO
	 * @return void형
	 * @exception Exception
	 */
	@Transactional
    public void updateBass0100(Bass0100VO vo) throws Exception {
        update("bass0100DAO.updateBass0100_S", vo);
    }

    /**
	 * BASS0100을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Bass0100VO
	 * @return void형 
	 * @exception Exception
	 */
	/**
	@Transactional
    public int deleteBass0100(InfcBass0100DTO dto) throws Exception {
        return delete("bass0100DAO.deleteBass0100_S", dto);
    }
	*/
	@Transactional
    public int deleteBass0100(Bass0100DTO dto) throws Exception {
        return delete("bass0100DAO.deleteBass0100_S", dto);
    }

    /**
	 * BASS0100을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Bass0100VO
	 * @return 조회한 BASS0100
	 * @exception Exception
	 */
    public Bass0100VO selectBass0100(Bass0100VO vo) throws Exception {
        return (Bass0100VO) selectByPk("bass0100DAO.selectBass0100_S", vo);
    }

    /**
	 * BASS0100 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0100 목록
	 * @exception Exception
	 */
    public List selectBass0100List(Bass0100SrhVO searchVO) throws Exception {
        return list("bass0100DAO.selectBass0100List_D", searchVO);
    }

    /**
	 * BASS0100 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0100 총 갯수
	 * @exception
	 */
    public int selectBass0100ListTotCnt(Bass0100SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bass0100DAO.selectBass0100ListTotCnt_S", searchVO);
    }

}
