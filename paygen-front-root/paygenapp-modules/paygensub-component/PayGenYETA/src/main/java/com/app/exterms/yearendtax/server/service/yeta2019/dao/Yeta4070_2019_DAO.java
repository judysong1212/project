package com.app.exterms.yearendtax.server.service.yeta2019.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Yeta2070Srh_2019_VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("Yeta4070_2019_DAO")
public class Yeta4070_2019_DAO  extends EgovAbstractDAO{
	
	 /**
     * Yeta4060 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta4060 목록
     * @exception Exception
     */
    public List selectYeta4070List(Yeta2070Srh_2019_VO searchVO) throws Exception {
    	return list("Yeta4070_2019_DAO.selectYeta4070List_D", searchVO);
    }
    
    /**
     * Yeta4060 총 갯수를 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Yeta4060 총 갯수
     * @exception
     */
    public int selectYeta4070ListTotCnt(Yeta2070Srh_2019_VO searchVO) {
    	return (Integer)getSqlMapClientTemplate().queryForObject("Yeta4070_2019_DAO.selectYeta4070ListTotCnt_S", searchVO);
    }
}
