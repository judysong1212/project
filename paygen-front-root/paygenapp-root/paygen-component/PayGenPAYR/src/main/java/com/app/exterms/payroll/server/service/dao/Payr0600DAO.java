package com.app.exterms.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.payroll.client.dto.Payr0600DTO;
import com.app.exterms.payroll.server.vo.Payr0600SrhVO;
import com.app.exterms.payroll.server.vo.Payr0600VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @author atres
 * @version 1.0
 * @Class Name : Payr0600DAO.java
 * @Description : Payr0600 DAO Class
 * @Modification Information
 * @see Copyright (C)  All right reserved.
 * @since 2014.07.11
 */

@Repository("Payr0600DAO")
public class Payr0600DAO extends EgovAbstractDAO {

    /**
     * PAYR0600을 등록한다.
     *
     * @param vo - 등록할 정보가 담긴 Payr0600VO
     * @return 등록 결과
     * @throws Exception
     */
    @Transactional
    public String insertPayr0600(Payr0600VO vo) throws Exception {
        return (String) insert("payr0600DAO.insertPayr0600_S", vo);
    }

    /**
     * PAYR0600을 수정한다.
     *
     * @param vo - 수정할 정보가 담긴 Payr0600VO
     * @return void형
     * @throws Exception
     */
    @Transactional
    public void updatePayr0600_S(Payr0600VO vo) throws Exception {
        update("payr0600DAO.updatePayr0600_S", vo);
    }

    /**
     * PAYR0600을 삭제한다.
     *
     * @param vo - 삭제할 정보가 담긴 Payr0600VO
     * @return void형
     * @throws Exception
     */
    @Transactional
    public void deletePayr0600(Payr0600VO vo) throws Exception {
        delete("payr0600DAO.deletePayr0600_S", vo);
    }

    /**
     * PAYR0600을 조회한다.
     *
     * @param vo - 조회할 정보가 담긴 Payr0600VO
     * @return 조회한 PAYR0600
     * @throws Exception
     */
    public Payr0600VO selectPayr0600(Payr0600VO vo) throws Exception {
        return (Payr0600VO) selectByPk("payr0600DAO.selectPayr0600_S", vo);
    }

    /**
     * PAYR0600 목록을 조회한다.
     *
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return PAYR0600 목록
     * @throws Exception
     */
    public List selectPayr0600List(Payr0600SrhVO searchVO) throws Exception {
        return list("payr0600DAO.selectPayr0600List_D", searchVO);
    }

    /**
     * PAYR0600 총 갯수를 조회한다.
     *
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return PAYR0600 총 갯수
     * @throws
     */
    public int selectPayr0600ListTotCnt(Payr0600SrhVO searchVO) {
        return (Integer) getSqlMapClientTemplate().queryForObject("payr0600DAO.selectPayr0600ListTotCnt_S", searchVO);
    }

    /**
     * PAYR0600 목록을 조회한다.
     *
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return PAYR0600 목록
     * @throws Exception
     */
    public List selectPayr0600DtlWrkrIncmBlggYrList(Payr0600SrhVO searchVO) throws Exception {
        return list("payr0600DAO.selectPayr0600DtlWrkrIncmBlggYrList_D", searchVO);
    }

    /**
     * PAYR0600 총 갯수를 조회한다.
     *
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return PAYR0600 총 갯수
     * @throws
     */
    public int selectPayr0600DtlWrkrIncmBlggYrListTotCnt(Payr0600SrhVO searchVO) {
        return (Integer) getSqlMapClientTemplate().queryForObject("payr0600DAO.selectPayr0600DtlWrkrIncmBlggYrListTotCnt_S", searchVO);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public int deletePayr0600ForInsert(Payr0600DTO payr0600DTO) {
        return delete("payr0600DAO.deletePayr0600ForInsert", payr0600DTO);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public String insertPayr0600MultipleRow(Payr0600DTO payr0600DTO) {
        return (String) insert("payr0600DAO.insertPayr0600MultipleRow", payr0600DTO);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public int updatePayr0600(Payr0600DTO payr0600DTO) throws Exception {
        return update("payr0600DAO.updatePayr0600", payr0600DTO);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public int updatePayr0600PentrInfo(Payr0600DTO payr0600DTO) throws Exception {
        return update("payr0600DAO.updatePayr0600PentrInfo", payr0600DTO);
    }
}
