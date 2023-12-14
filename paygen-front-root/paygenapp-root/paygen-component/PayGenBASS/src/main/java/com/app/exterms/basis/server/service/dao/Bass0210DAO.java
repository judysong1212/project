package com.app.exterms.basis.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.basis.server.vo.Bass0210SrhVO;
import com.app.exterms.basis.server.vo.Bass0210VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("Bass0210DAO")
public class Bass0210DAO extends EgovAbstractDAO {
	/**
	 * BASS0210을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Bass0210VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertBass0210(Bass0210VO vo) throws Exception {
        return (String)insert("bass0210DAO.insertBass0210_S", vo);
    }

    /**
	 * BASS0210을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Bass0210VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateBass0210(Bass0210VO vo) throws Exception {
    	update("bass0210DAO.updateBass0210_S", vo);
    }

    /**
	 * BASS0210을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Bass0210VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteBass0210(Bass0210VO vo) throws Exception {
        delete("bass0210DAO.deleteBass0210_S", vo);
    }

    /**
	 * BASS0210을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Bass0210VO
	 * @return 조회한 BASS0210
	 * @exception Exception
	 */
    public Bass0210VO selectBass0210(Bass0210VO vo) throws Exception {
        return (Bass0210VO) selectByPk("bass0210DAO.selectBass0210_S", vo);
    }

    /**
	 * BASS0210 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0210 목록
	 * @exception Exception
	 */
    public List selectBass0210List(Bass0210SrhVO searchVO) throws Exception {
        return list("bass0210DAO.selectBass0210List_D", searchVO);
    }

    /**
	 * BASS0210 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0210 총 갯수
	 * @exception
	 */
    public int selectBass0210ListTotCnt(Bass0210SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("bass0210DAO.selectBass0210ListTotCnt_S", searchVO);
    }

    /**
	 * CoCalendar 법정 휴일 구분 값을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return CoCalendar 법정 휴일 구분 값
	 * @exception
	 */
	public Bass0210VO selectCoCalendar(Bass0210VO bass0210Vo) {
		return (Bass0210VO) selectByPk("bass0210DAO.selectCoCalendar_S", bass0210Vo);
	}
}
