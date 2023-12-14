package com.app.smrmf.infc.diligence.server.service.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.diligence.server.vo.InfcPkgDlgn0200VO;
import com.google.gwt.user.client.rpc.IsSerializable;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;


@Repository("InfcPkgDlgn0200DAO")
public class InfcPkgDlgn0200DAO extends EgovAbstractDAO implements IsSerializable {
	 
	
	/**
	 * 급여 마감처리 - 마감풀기
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@Transactional
	public int updateDlgn0200PayDdlene(InfcPkgDlgn0200VO vo) throws Exception{
        return update("infcPkgDlgn0200DAO.updateDlgn0200PayDdlene_S", vo);
    }
	
	
	/**
     * DLGN0200을 등록한다.
     * @param vo - 등록할 정보가 담긴 Dlgn0200VO
     * @return 등록 결과
     * @exception Exception
     */
	@Transactional
    public String insertDlgn0200(InfcPkgDlgn0200VO vo) throws Exception {
        return (String)insert("infcPkgDlgn0200DAO.insertDlgn0200_S", vo);
    }

    /**
     * DLGN0200을 수정한다.
     * @param vo - 수정할 정보가 담긴 Dlgn0200VO
     * @return void형
     * @exception Exception
     */
	@Transactional
    public void updateDlgn0200(InfcPkgDlgn0200VO vo) throws Exception {
        update("infcPkgDlgn0200DAO.updateDlgn0200_S", vo);
    }

    /**
     * DLGN0200을 삭제한다.
     * @param vo - 삭제할 정보가 담긴 Dlgn0200VO
     * @return void형 
     * @exception Exception
     */
	@Transactional
    public void deleteDlgn0200(InfcPkgDlgn0200VO vo) throws Exception {
        delete("infcPkgDlgn0200DAO.deleteDlgn0200_S", vo);
    }

    /**
     * DLGN0200을 조회한다.
     * @param vo - 조회할 정보가 담긴 Dlgn0200VO
     * @return 조회한 DLGN0200
     * @exception Exception
     */
    public InfcPkgDlgn0200VO selectDlgn0200(InfcPkgDlgn0200VO vo) throws Exception {
        return (InfcPkgDlgn0200VO) selectByPk("infcPkgDlgn0200DAO.selectDlgn0200_S", vo);
    }

	
	
	
	
}
