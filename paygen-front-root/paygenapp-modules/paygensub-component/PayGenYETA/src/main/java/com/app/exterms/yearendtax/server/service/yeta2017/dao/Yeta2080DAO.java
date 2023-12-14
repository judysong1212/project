package com.app.exterms.yearendtax.server.service.yeta2017.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Yeta2080SrhVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("Yeta2080DAO")
public class Yeta2080DAO  extends EgovAbstractDAO{
	
	 /**
     * Yeta2060 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta2060 목록
     * @exception Exception
     */
    public List selectYeta2080List(Yeta2080SrhVO searchVO) throws Exception {
    	return list("Yeta2080DAO.selectYeta2080List_D", searchVO);
    }
    
    /**
     * Yeta2060 총 갯수를 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta2060 총 갯수
     * @exception
     */
    public int selectYeta2080ListTotCnt(Yeta2080SrhVO searchVO) {
    	return (Integer)getSqlMapClientTemplate().queryForObject("Yeta2080DAO.selectYeta2080ListTotCnt_S", searchVO);
    }
}
