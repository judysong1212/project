package com.app.exterms.yearendtax.server.service.yeta2022.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Yeta2080Srh_2022_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("Yeta7080_2022_DAO")
public class Yeta7080_2022_DAO  extends EgovAbstractDAO{
	
	 /**
     * Yeta7060 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta7060 목록
     * @exception Exception
     */
    public List selectYeta7080List(Yeta2080Srh_2022_VO searchVO) throws Exception {
    	return list("Yeta7080_2022_DAO.selectYeta7080List_D", searchVO);
    }
    
    /**
     * Yeta7060 총 갯수를 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta7060 총 갯수
     * @exception
     */
    public int selectYeta7080ListTotCnt(Yeta2080Srh_2022_VO searchVO) {
    	return (Integer)getSqlMapClientTemplate().queryForObject("Yeta7080_2022_DAO.selectYeta7080ListTotCnt_S", searchVO);
    }
}
