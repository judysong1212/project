package com.app.exterms.basis.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.basis.client.dto.Bass0300DTOMng;
import com.app.exterms.basis.server.vo.Bass0300SrhVO;
import com.app.exterms.basis.server.vo.Bass0300VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass0300DAO.java
 * @Description : Bass0300 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Bass0300DAO")
public class Bass0300DAO extends EgovAbstractDAO {
	
	/*############################## 코드관리 서비스 시작 ######################################*/
	
	@SuppressWarnings("rawtypes")
	public List selectBass0300WorkList(Bass0300DTOMng dtoParam)throws Exception {
		return list("bass0300DAO.selectBass0300WorkList", dtoParam);
	}
	@SuppressWarnings("rawtypes")
	public List selectBass0300CodeList(Bass0300DTOMng dtoParam)throws Exception {
		return list("bass0300DAO.selectBass0300CodeList", dtoParam);
	}
	@SuppressWarnings("rawtypes")
	public List selectBass0300DtlCodeList(Bass0300DTOMng dtoParam)throws Exception {
		return list("bass0300DAO.selectBass0300DtlCodeList", dtoParam);
	}
	@Transactional
	public String insertBass0300(Bass0300DTOMng dtoParam) throws Exception{
		return (String) insert("bass0300DAO.insertBass0300", dtoParam);
	}
	@Transactional
	public int updateBass0300(Bass0300DTOMng dtoParam) throws Exception{
		return update("bass0300DAO.updateBass0300", dtoParam);
	}
	@Transactional
	public int deleteBass0300(Bass0300DTOMng dtoParam) throws Exception{
		return delete("bass0300DAO.deleteBass0300", dtoParam);
	}
	@Transactional
	public int deleteBass0300DtlCode(Bass0300DTOMng dtoParam) throws Exception{
		return delete("bass0300DAO.deleteBass0300DtlCode", dtoParam);
	}
	/*############################## 코드관리 서비스 끝 ######################################*/
	
	
	
	/**
	 * BASS0300을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Bass0300VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	@Transactional
    public String insertBass0300(Bass0300VO vo) throws Exception {
        return (String)insert("bass0300DAO.insertBass0300_S", vo);
    }

    /**
	 * BASS0300을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Bass0300VO
	 * @return void형
	 * @exception Exception
	 */
	@Transactional
    public void updateBass0300(Bass0300VO vo) throws Exception {
        update("bass0300DAO.updateBass0300_S", vo);
    }

    /**
	 * BASS0300을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Bass0300VO
	 * @return void형 
	 * @exception Exception
	 */
	@Transactional
    public void deleteBass0300(Bass0300VO vo) throws Exception {
        delete("bass0300DAO.deleteBass0300_S", vo);
    }

    /**
	 * BASS0300을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Bass0300VO
	 * @return 조회한 BASS0300
	 * @exception Exception
	 */
    public Bass0300VO selectBass0300(Bass0300VO vo) throws Exception {
        return (Bass0300VO) selectByPk("bass0300DAO.selectBass0300_S", vo);
    }

    /**
	 * BASS0300 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0300 목록
	 * @exception Exception
	 */
    public List selectBass0300List(Bass0300SrhVO searchVO) throws Exception {
        return list("bass0300DAO.selectBass0300List_D", searchVO);
    }

    /**
	 * BASS0300 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0300 총 갯수
	 * @exception
	 */
    public int selectBass0300ListTotCnt(Bass0300SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bass0300DAO.selectBass0300ListTotCnt_S", searchVO);
    }

}
