package com.app.exterms.personal.server.service;

import org.springframework.stereotype.Service;

import com.app.exterms.personal.client.service.Psnl0125Service;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;

/**
 * @Class Name : Psnl0125ServiceImpl.java
 * @Description : Psnl0125 Business Implement class
 * @Modification Information
 * 
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */

@Service("psnl0125Service")
public class Psnl0125ServiceImpl extends AbstractCustomServiceImpl implements
		Psnl0125Service {

	//@Resource(name = "psnl0125DAO")
	//private Psnl0125DAO psnl0125DAO;

	/** ID Generation */
	// @Resource(name="{egovPsnl0125IdGnrService}")
	// private EgovIdGnrService egovIdGnrService;

	

	/**
	 * PSNL0125을 등록한다.
	 * 
	 * @param vo
	 *            - 등록할 정보가 담긴 Psnl0125VO
	 * @return 등록 결과
	 * @exception Exception
	 */
//	public String insertPsnl0125(Psnl0125VO vo) throws Exception {
//		log.debug(vo.toString());
//
//		/** ID Generation Service */
//		// TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
//		// String id = egovIdGnrService.getNextStringId();
//		// vo.setId(id);
//		log.debug(vo.toString());
//
//		psnl0125DAO.insertPsnl0125_S(vo);
//		// TODO 해당 테이블 정보에 맞게 수정
//		return null;
//	}
//
//	/**
//	 * PSNL0125을 수정한다.
//	 * 
//	 * @param vo
//	 *            - 수정할 정보가 담긴 Psnl0125VO
//	 * @return void형
//	 * @exception Exception
//	 */
//	public void updatePsnl0125(Psnl0125VO vo) throws Exception {
//		psnl0125DAO.updatePsnl0125_S(vo);
//	}
//
//	/**
//	 * PSNL0125을 삭제한다.
//	 * 
//	 * @param vo
//	 *            - 삭제할 정보가 담긴 Psnl0125VO
//	 * @return void형
//	 * @exception Exception
//	 */
//	public void deletePsnl0125(Psnl0125VO vo) throws Exception {
//		psnl0125DAO.deletePsnl0125_S(vo);
//	}
//
//	/**
//	 * PSNL0125을 조회한다.
//	 * 
//	 * @param vo
//	 *            - 조회할 정보가 담긴 Psnl0125VO
//	 * @return 조회한 PSNL0125
//	 * @exception Exception
//	 */
//	public Psnl0125VO selectPsnl0125(Psnl0125VO vo) throws Exception {
//		Psnl0125VO resultVO = psnl0125DAO.selectPsnl0125(vo);
//		if (resultVO == null)
//			throw processException("info.nodata.msg");
//		return resultVO;
//	}
//
//	/**
//	 * PSNL0125 목록을 조회한다.
//	 * 
//	 * @param searchVO
//	 *            - 조회할 정보가 담긴 VO
//	 * @return PSNL0125 목록
//	 * @exception Exception
//	 */
//	public List selectPsnl0125List(Psnl0125DefaultVO searchVO) throws Exception {
//		return psnl0125DAO.selectPsnl0125List(searchVO);
//	}
//
//	/**
//	 * PSNL0125 총 갯수를 조회한다.
//	 * 
//	 * @param searchVO
//	 *            - 조회할 정보가 담긴 VO
//	 * @return PSNL0125 총 갯수
//	 * @exception
//	 */
//	public int selectPsnl0125ListTotCnt(Psnl0125DefaultVO searchVO) {
//		return psnl0125DAO.selectPsnl0125ListTotCnt(searchVO);
//	}

	

	
	

}
