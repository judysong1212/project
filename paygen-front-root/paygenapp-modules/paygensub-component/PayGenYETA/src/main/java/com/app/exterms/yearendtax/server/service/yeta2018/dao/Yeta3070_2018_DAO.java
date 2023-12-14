package com.app.exterms.yearendtax.server.service.yeta2018.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Yeta2070Srh_2018_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("Yeta3070_2018_DAO")
public class Yeta3070_2018_DAO  extends EgovAbstractDAO{
	
	 /**
     * Yeta3060 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta3060 목록
     * @exception Exception
     */
    public List selectYeta3070List(Yeta2070Srh_2018_VO searchVO) throws Exception {
    	return list("Yeta3070_2018_DAO.selectYeta3070List_D", searchVO);
    }
    
    /**
     * Yeta3060 총 갯수를 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta3060 총 갯수
     * @exception
     */
    public int selectYeta3070ListTotCnt(Yeta2070Srh_2018_VO searchVO) {
    	return (Integer)getSqlMapClientTemplate().queryForObject("Yeta3070_2018_DAO.selectYeta3070ListTotCnt_S", searchVO);
    }
}
