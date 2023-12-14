package com.app.exterms.yearendtax.server.service.yeta2022.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Yeta2070Srh_2022_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("Yeta7070_2022_DAO")
public class Yeta7070_2022_DAO  extends EgovAbstractDAO{
	
	 /**
     * Yeta7060 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta7060 목록
     * @exception Exception
     */
    public List selectYeta7070List(Yeta2070Srh_2022_VO searchVO) throws Exception {
    	return list("Yeta7070_2022_DAO.selectYeta7070List_D", searchVO);
    }
    
    /**
     * Yeta7060 총 갯수를 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta7060 총 갯수
     * @exception
     */
    public int selectYeta7070ListTotCnt(Yeta2070Srh_2022_VO searchVO) {
    	return (Integer)getSqlMapClientTemplate().queryForObject("Yeta7070_2022_DAO.selectYeta7070ListTotCnt_S", searchVO);
    }
}
