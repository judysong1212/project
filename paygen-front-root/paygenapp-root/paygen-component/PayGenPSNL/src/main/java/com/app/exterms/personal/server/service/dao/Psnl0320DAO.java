package com.app.exterms.personal.server.service.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.personal.server.vo.Psnl0119VO;
import com.app.exterms.personal.server.vo.Psnl0122VO;
import com.app.exterms.personal.server.vo.Psnl0320SrhVO;
import com.app.exterms.personal.server.vo.Psnl0320VO;
import com.google.gwt.user.client.rpc.IsSerializable;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * @Class Name : Psnl0320DAO.java
 * @Description : Psnl0320 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("psnl0320DAO")
public class Psnl0320DAO extends EgovAbstractDAO implements IsSerializable{

	public int selectPsnl0100PagingTotCnt(Psnl0320SrhVO psnl0320SrhVo) throws Exception{
		return (Integer)getSqlMapClient().queryForObject("psnl0320DAO.selectPsnl0100PagingTotCnt", psnl0320SrhVo);
	}

	@SuppressWarnings("rawtypes")
	public List getPsnl0100ToPsnl0320DataList(Psnl0320SrhVO psnl0320SrhVo) throws Exception{
		return list("psnl0320DAO.getPsnl0100ToPsnl0320DataList", psnl0320SrhVo);
	}

	@SuppressWarnings("rawtypes")
	public List getPsnl0110ToPsnl0320DataList(Psnl0320SrhVO psnl0320SrhVo) throws Exception{
		return list("psnl0320DAO.getPsnl0110ToPsnl0320DataList", psnl0320SrhVo);
	}

	@SuppressWarnings("rawtypes")
	public List getPsnl0119ToPsnl0320DataList(Psnl0320SrhVO psnl0320SrhVo) throws Exception{
		return list("psnl0320DAO.getPsnl0119ToPsnl0320DataList", psnl0320SrhVo);
	}

	@SuppressWarnings("rawtypes")
	public List getPsnl0122ToPsnl0320DataList(Psnl0320SrhVO psnl0320SrhVo) throws Exception{
		return list("psnl0320DAO.getPsnl0122ToPsnl0320DataList", psnl0320SrhVo);
	}

    public int updatePsnl0110(Psnl0320VO vo) throws Exception {
    	int result = 0;
    	result = update("psnl0320DAO.updatePsnl0110", vo);
    	return result;
    }

    public int updatePsnl0119(Psnl0119VO vo) throws Exception {
    	int result = 0;
    	result = update("psnl0320DAO.updatePsnl0119", vo);
    	return result;
    }

    public int updatePsnl0122(Psnl0122VO vo) throws Exception {
    	int result = 0;
    	result = update("psnl0320DAO.updatePsnl0122", vo);
    	return result;
    }

    public int getPyspReMrkSeilNum(Psnl0320VO vo) throws Exception {
    	return (Integer)getSqlMapClient().queryForObject("psnl0320DAO.getPyspReMrkSeilNum", vo);
    }

    @SuppressWarnings("rawtypes")
    public EgovMap getLogSvcDysList(Psnl0320VO vo) throws Exception {
    	return (EgovMap) selectByPk("psnl0320DAO.getLogSvcDysList", vo);
    }

    public String savePsnl0320(Psnl0320VO vo) throws Exception {
    	return (String)insert("psnl0320DAO.savePsnl0320", vo);
    }

	public int getPsnl0320ListButtomCnt(Psnl0320VO vo) throws Exception{
		return (Integer)getSqlMapClient().queryForObject("psnl0320DAO.getPsnl0320ListButtomCnt", vo);
	}

	@SuppressWarnings("rawtypes")
	public List getPsnl0320ListButtom(Psnl0320VO vo) throws Exception{
		return list("psnl0320DAO.getPsnl0320ListButtom", vo);
	}
	
	
	@SuppressWarnings("rawtypes")
	public List selectXlsPsnl0320List(Psnl0320SrhVO vo) throws Exception{
		return list("psnl0320DAO.selectXlsPsnl0320List", vo);
	}

	@SuppressWarnings("rawtypes")
	public EgovMap getPsnl0320ListButtomResult(Psnl0320VO vo) throws Exception{
		return (EgovMap) selectByPk("psnl0320DAO.getPsnl0320ListButtomResult", vo);
	}
	
    /**
	 * PSNL0111을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Psnl0111VO
	 * @return 조회한 PSNL0111
	 * @exception Exception
	 */
	@SuppressWarnings("rawtypes")
	public List selectPsnl0320(HashMap<String, String> hMap) throws Exception {
        return list("psnl0320DAO.selectPsnl0320", hMap);
    }
}