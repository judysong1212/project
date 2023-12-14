package com.app.exterms.yearendtax.server.service.yeta2021.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Yeta2070Srh_2021_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("Yeta6070_2021_DAO")
public class Yeta6070_2021_DAO  extends EgovAbstractDAO{
	
	 /**
     * Yeta6060 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta6060 목록
     * @exception Exception
     */
    public List selectYeta6070List(Yeta2070Srh_2021_VO searchVO) throws Exception {
    	return list("Yeta6070_2021_DAO.selectYeta6070List_D", searchVO);
    }
    
    /**
     * Yeta6060 총 갯수를 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta6060 총 갯수
     * @exception
     */
    public int selectYeta6070ListTotCnt(Yeta2070Srh_2021_VO searchVO) {
    	return (Integer)getSqlMapClientTemplate().queryForObject("Yeta6070_2021_DAO.selectYeta6070ListTotCnt_S", searchVO);
    }
}
