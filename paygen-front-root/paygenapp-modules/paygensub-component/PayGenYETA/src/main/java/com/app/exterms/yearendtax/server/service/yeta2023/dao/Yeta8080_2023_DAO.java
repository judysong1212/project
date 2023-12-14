package com.app.exterms.yearendtax.server.service.yeta2023.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Yeta2080Srh_2023_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("Yeta8080_2023_DAO")
public class Yeta8080_2023_DAO  extends EgovAbstractDAO{
	
	 /**
     * Yeta8060 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta8060 목록
     * @exception Exception
     */
    public List selectYeta8080List(Yeta2080Srh_2023_VO searchVO) throws Exception {
    	return list("Yeta8080_2023_DAO.selectYeta8080List_D", searchVO);
    }
    
    /**
     * Yeta8060 총 갯수를 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta8060 총 갯수
     * @exception
     */
    public int selectYeta8080ListTotCnt(Yeta2080Srh_2023_VO searchVO) {
    	return (Integer)getSqlMapClientTemplate().queryForObject("Yeta8080_2023_DAO.selectYeta8080ListTotCnt_S", searchVO);
    }
}
