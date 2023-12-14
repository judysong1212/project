package com.app.exterms.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.payroll.client.dto.Payr0650DTO;
import com.app.exterms.payroll.server.vo.Payr0650SrhVO;
import com.app.exterms.payroll.server.vo.Payr0650VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @author atres
 * @version 1.0
 * @Class Name : Payr0650DAO.java
 * @Description : Payr0650 DAO Class
 * @Modification Information
 * @see Copyright (C)  All right reserved.
 * @since 2014.07.11
 */

@Repository("Payr0650DAO")
public class Payr0650DAO extends EgovAbstractDAO {

    /**
     * PAYR0650을 등록한다.
     *
     * @param vo - 등록할 정보가 담긴 Payr0650VO
     * @return 등록 결과
     * @throws Exception
     */
    @Transactional
    public String insertPayr0650(Payr0650VO vo) throws Exception {
        return (String) insert("payr0650DAO.insertPayr0650_S", vo);
    }

    /**
     * PAYR0650을 수정한다.
     *
     * @param vo - 수정할 정보가 담긴 Payr0650VO
     * @return void형
     * @throws Exception
     */
    @Transactional
    public void updatePayr0650(Payr0650VO vo) throws Exception {
        update("payr0650DAO.updatePayr0650_S", vo);
    }

    /**
     * PAYR0650을 삭제한다.
     *
     * @param vo - 삭제할 정보가 담긴 Payr0650VO
     * @return void형
     * @throws Exception
     */
    @Transactional
    public void deletePayr0650_S(Payr0650VO vo) throws Exception {
        delete("payr0650DAO.deletePayr0650_S", vo);
    }

    /**
     * PAYR0650을 조회한다.
     *
     * @param vo - 조회할 정보가 담긴 Payr0650VO
     * @return 조회한 PAYR0650
     * @throws Exception
     */
    public Payr0650VO selectPayr0650(Payr0650VO vo) throws Exception {
        return (Payr0650VO) selectByPk("payr0650DAO.selectPayr0650_S", vo);
    }

    /**
     * PAYR0650 목록을 조회한다.
     *
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return PAYR0650 목록
     * @throws Exception
     */
    public List selectPayr0650List(Payr0650SrhVO searchVO) throws Exception {
        return list("payr0650DAO.selectPayr0650List_D", searchVO);
    }

    /**
     * PAYR0650 총 갯수를 조회한다.
     *
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return PAYR0650 총 갯수
     * @throws
     */
    public int selectPayr0650ListTotCnt(Payr0650SrhVO searchVO) throws Exception {
        return (Integer) getSqlMapClientTemplate().queryForObject("payr0650DAO.selectPayr0650ListTotCnt_S", searchVO);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public int deletePayr0650ForInsert(Payr0650DTO payr0650DTO) throws Exception {
        return delete("payr0650DAO.deletePayr0650ForInsert", payr0650DTO);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public String insertPayr0650MultipleRow(Payr0650DTO payr0650DTO) throws Exception {
        return (String) insert("payr0650DAO.insertPayr0650MultipleRow", payr0650DTO);
    }

    public List selectPayr0650LeftGrid(Payr0650SrhVO payr0650SrhVO) throws Exception {
        return list("payr0650DAO.selectPayr0650LeftGrid", payr0650SrhVO);
    }

    public int selectPayr0650LeftGridTotCnt(Payr0650SrhVO payr0650SrhVO) throws Exception {
        return (Integer) getSqlMapClientTemplate().queryForObject("payr0650DAO.selectPayr0650LeftGridTotCnt", payr0650SrhVO);
    }

    public List selectPayr0650RightGrid(Payr0650SrhVO payr0650SrhVO) throws Exception {
        return list("payr0650DAO.selectPayr0650RightGrid", payr0650SrhVO);
    }

    public int selectPayr0650RightGridTotCnt(Payr0650SrhVO payr0650SrhVO) throws Exception {
        return (Integer) getSqlMapClientTemplate().queryForObject("payr0650DAO.selectPayr0650RightGridTotCnt", payr0650SrhVO);
    }

    public List selectXlsPayr0650List(Payr0650SrhVO payr0650SrhVO) throws Exception {
        return list("payr0650DAO.selectXlsPayr0650List", payr0650SrhVO);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public int deletePayr0650(Payr0650DTO payr0650DTO) throws Exception {
        return delete("payr0650DAO.deletePayr0650", payr0650DTO);
    }
}
