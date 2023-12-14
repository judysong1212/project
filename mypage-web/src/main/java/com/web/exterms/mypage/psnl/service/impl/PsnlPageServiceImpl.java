package com.web.exterms.mypage.psnl.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.exterms.mypage.iucert.service.PsnlProofAcceptVO;
import com.web.exterms.mypage.psnl.service.PsnlPageDefaultVO;
import com.web.exterms.mypage.psnl.service.PsnlPageService;
import com.web.exterms.mypage.psnl.service.PsnlPageVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

/**
 * @Class Name : PsnlPageServiceImpl.java
 * @Description : PsnlPage Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.06
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("psnlPageService")
public class PsnlPageServiceImpl extends AbstractServiceImpl implements
        PsnlPageService {

    @Resource(name="psnlPageDAO")
    private PsnlPageDAO psnlPageDAO;
    
    /** ID Generation */
    //@Resource(name="{egovPsnlPageIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * PSNL0100을 등록한다.
	 * @param vo - 등록할 정보가 담긴 PsnlPageVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertPsnlPage(PsnlPageVO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	log.debug(vo.toString());
    	
    	psnlPageDAO.insertPsnlPage(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * PSNL0100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 PsnlPageVO
	 * @return void형
	 * @exception Exception
	 */
    public void updatePsnlPage(PsnlPageVO vo) throws Exception {
        psnlPageDAO.updatePsnlPage(vo);
    }

    /**
	 * PSNL0100을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 PsnlPageVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deletePsnlPage(PsnlPageVO vo) throws Exception {
        psnlPageDAO.deletePsnlPage(vo);
    }

    /**
	 * PSNL0100을 조회한다.
	 * @param vo - 조회할 정보가 담긴 PsnlPageVO
	 * @return 조회한 PSNL0100
	 * @exception Exception
	 */
    public PsnlPageVO selectPsnlPage(PsnlPageVO vo) throws Exception {
        PsnlPageVO resultVO = psnlPageDAO.selectPsnlPage(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * PSNL0100 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return PSNL0100 목록
	 * @exception Exception
	 */
    public List selectPsnlPageList(PsnlPageDefaultVO searchVO) throws Exception {
        return psnlPageDAO.selectPsnlPageList(searchVO);
    }

    /**
	 * PSNL0100 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return PSNL0100 총 갯수
	 * @exception
	 */
    public int selectPsnlPageListTotCnt(PsnlPageDefaultVO searchVO) {
		return psnlPageDAO.selectPsnlPageListTotCnt(searchVO);
	}
    
    
	@SuppressWarnings("rawtypes")
	@Override
	public PsnlPageVO selectPsnl0100(PsnlPageVO psnlPageVO)
			throws Exception {
		return psnlPageDAO.selectPsnl0100(psnlPageVO);
		
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getZipCodeList(HashMap<String, String> hMap) throws Exception {
		return psnlPageDAO.getZipCodeList(hMap);
	}

	@Override
	public int updateDoroAddr(PsnlPageVO psnlPageVO) throws Exception {
		return psnlPageDAO.updateDoroAddr(psnlPageVO);
	}
	
	/**가족사항*/
	@SuppressWarnings("rawtypes")
	@Override
	public List getFamilyList(PsnlPageVO psnlPageVO) throws Exception {
		return psnlPageDAO.getFamilyList(psnlPageVO);
	}
	@SuppressWarnings("rawtypes")
	@Override
	public List getCertType(PsnlProofAcceptVO psnlProofAcceptVO) throws Exception {
		return psnlPageDAO.getCertType(psnlProofAcceptVO);
	}
	/**증명서발급신청리스트*/
	@SuppressWarnings("rawtypes")
	@Override
	public List getCertList(PsnlProofAcceptVO psnlProofAcceptVO) throws Exception {
		return psnlPageDAO.getCertList(psnlProofAcceptVO);
	}

	@Override
	public String getCertListTotCnt(PsnlProofAcceptVO psnlProofAcceptVO) throws Exception {
		return psnlPageDAO.getCertListTotCnt(psnlProofAcceptVO);
	}

	@Override
	public String insertCertInfo(PsnlProofAcceptVO psnlProofAcceptVO) throws Exception {
		return psnlPageDAO.insertCertInfo(psnlProofAcceptVO);
	}

	@Override
	public int deleteCertInfo(PsnlProofAcceptVO psnlProofAcceptVO) throws Exception {
		int val = 0;
//		PsnlProofAcceptVO psnlProofAcceptVO;
//		for(int i = 0 ; i < delList.size(); i++){
			val ++;
//			psnlProofAcceptVO = new PsnlProofAcceptVO();
//			psnlProofAcceptVO = delList.get(i);
			psnlPageDAO.deleteCertInfo(psnlProofAcceptVO);			
//		}
		return val;
	}
	
	@Override
	public int afterPrintDown(PsnlProofAcceptVO psnlProofAcceptVO) throws Exception {
		return psnlPageDAO.afterPrintDown(psnlProofAcceptVO);
	}
	
	/* 원천징수 인쇄 처리후 변경을 위해서 추가 */
	@Override
	public int afterPrintDown2(PsnlProofAcceptVO psnlProofAcceptVO) throws Exception {
		return psnlPageDAO.afterPrintDown2(psnlProofAcceptVO);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List getPayrCertList(PsnlProofAcceptVO psnlProofAcceptVO) throws Exception {
		return psnlPageDAO.getPayrCertList(psnlProofAcceptVO);
	}

	@Override
	public String getPayrCertListTotCnt(PsnlProofAcceptVO psnlProofAcceptVO)
			throws Exception {
		return psnlPageDAO.getPayrCertListTotCnt(psnlProofAcceptVO);
	}

	@Override
	public String insertPayrCertInfo(PsnlProofAcceptVO psnlProofAcceptVO)
			throws Exception {
		return psnlPageDAO.insertPayrCertInfo(psnlProofAcceptVO);
	}

	@Override
	public int deletePayrCertInfo(PsnlProofAcceptVO psnlProofAcceptVO)
			throws Exception {
		int val = 0;
//		PsnlProofAcceptVO psnlProofAcceptVO;
//		for(int i = 0 ; i < delList.size(); i++){
			val++;
//			psnlProofAcceptVO = new PsnlProofAcceptVO();
//			psnlProofAcceptVO = delList.get(i);
			psnlPageDAO.deletePayrCertInfo(psnlProofAcceptVO);
//		}
		return val;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getCarrList(PsnlPageVO psnlPageVO) throws Exception {
		 return psnlPageDAO.getCarrList(psnlPageVO);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List getRewardList(PsnlPageVO psnlPageVO) throws Exception {

		return psnlPageDAO.getRewardList(psnlPageVO);
	}

	
    
}
