package com.app.smrmf.pkg.yeta.yeta2017.tax.service.impl;

import java.util.HashMap;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgYe160404DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgYe160405DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgYe160406DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgYe160510DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgYe161005DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgYe161010DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgYe161020DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgYe161030DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgYe161040DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgYe161050DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgYe161055DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgYe161060DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgYe161070DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgYe161080DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgYe161090DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgYe162010DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgYe162020DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgYe162030DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgYe162040DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgYe162510DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgYe162520DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgYe162530DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgYe164010DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgYe165010DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgYe165020DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgYe165030DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgYe165030TempDAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgYe166010DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgYe166020DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgYe169010DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgYe169010aDAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgYe170401DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgYe170402DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgYe170403DAO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160401VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160402VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160403VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161020VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161030VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161040VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161070VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161080VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe165010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe165030TempVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe165030VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe166010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe166020VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe169010aVO;
import com.app.smrmf.pkg.yeta.yeta2017.tax.service.Yeta2100PayrService;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

/**
 * @Class Name : Yeta3900ServiceImpl.java
 * @Description : Yeta3900 Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2017.01.18
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("Yeta2100PayrService")
public class Yeta2100PayrServiceImpl extends AbstractServiceImpl  implements
        Yeta2100PayrService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(Yeta2100PayrServiceImpl.class);

	@Autowired
	@Resource(name = "InfcPkgYe170401DAO")
	private InfcPkgYe170401DAO infcPkgYe160401DAO; //현근무지급여지급명세
	@Autowired
	@Resource(name = "InfcPkgYe170402DAO")
	private InfcPkgYe170402DAO  infcPkgYe160402DAO;//현근무지비과세_감면소득_과세
	@Autowired
	@Resource(name = "InfcPkgYe170403DAO")
	private InfcPkgYe170403DAO  infcPkgYe160403DAO;//현근무지비과세_감면소득_비과세
	@Autowired
	@Resource(name = "InfcPkgYe160404DAO")
	private InfcPkgYe160404DAO  infcPkgYe160404DAO;//D_종전근무처
	@Autowired
	@Resource(name = "InfcPkgYe160405DAO")
	private InfcPkgYe160405DAO  infcPkgYe160405DAO;//D_종전근무처비과세_감면소득_비과세
	@Autowired
	@Resource(name = "InfcPkgYe160406DAO")
	private InfcPkgYe160406DAO  infcPkgYe160406DAO;//종전근무지연금보험료_공적연금
	@Autowired
	@Resource(name = "InfcPkgYe160510DAO")
	private InfcPkgYe160510DAO  infcPkgYe160510DAO;//근무지별비과세_감면소득
	            
	@Autowired
	@Resource(name = "InfcPkgYe161005DAO")
	private InfcPkgYe161005DAO  infcPkgYe161005DAO;//A_원천세신고기본
	            
	@Autowired
	@Resource(name = "InfcPkgYe161010DAO")
	private InfcPkgYe161010DAO  infcPkgYe161010DAO;// 연말정산대상자기본
	@Autowired
	@Resource(name = "InfcPkgYe161020DAO")
	private InfcPkgYe161020DAO  infcPkgYe161020DAO;//A_인적소득공제기본
	@Autowired
	@Resource(name = "InfcPkgYe161030DAO")
	private InfcPkgYe161030DAO  infcPkgYe161030DAO;//E_인적공제명세
	@Autowired
	@Resource(name = "InfcPkgYe161040DAO")
	private InfcPkgYe161040DAO  infcPkgYe161040DAO;//E_소득세액공제명세
	@Autowired
	@Resource(name = "InfcPkgYe161050DAO")
	private InfcPkgYe161050DAO  infcPkgYe161050DAO;//C_연금보험료공제
	@Autowired
	@Resource(name = "InfcPkgYe161055DAO")
	private InfcPkgYe161055DAO  infcPkgYe161055DAO;//C_연금보험료_공적연금상세
	@Autowired
	@Resource(name = "InfcPkgYe161060DAO")
	private InfcPkgYe161060DAO  infcPkgYe161060DAO;//C_특별소득공제
	@Autowired
	@Resource(name = "InfcPkgYe161070DAO")
	private InfcPkgYe161070DAO  infcPkgYe161070DAO;//C_그밖의소득공제
	@Autowired
	@Resource(name = "InfcPkgYe161080DAO")
	private InfcPkgYe161080DAO  infcPkgYe161080DAO;//C_세액감면및공제
	@Autowired
	@Resource(name = "InfcPkgYe161090DAO")
	private InfcPkgYe161090DAO  infcPkgYe161090DAO;//C_교육비내역
	@Autowired
	@Resource(name = "InfcPkgYe162010DAO")
	private InfcPkgYe162010DAO  infcPkgYe162010DAO;//F_연금저축계좌
	@Autowired
	@Resource(name = "InfcPkgYe162020DAO")
	private InfcPkgYe162020DAO  infcPkgYe162020DAO;//F_퇴직연금계좌명세
	@Autowired
	@Resource(name = "InfcPkgYe162030DAO")
	private InfcPkgYe162030DAO  infcPkgYe162030DAO;//F_주택마련저축
	@Autowired
	@Resource(name = "InfcPkgYe162040DAO")
	private InfcPkgYe162040DAO  infcPkgYe162040DAO;//F_장기집합투자증권저축_B1013
	@Autowired
	@Resource(name = "InfcPkgYe162510DAO")
	private InfcPkgYe162510DAO  infcPkgYe162510DAO;//G_월세액소득공제명세
	@Autowired
	@Resource(name = "InfcPkgYe162520DAO")
	private InfcPkgYe162520DAO  infcPkgYe162520DAO;//G_거주자간_금전소비대차
	@Autowired
	@Resource(name = "InfcPkgYe162530DAO")
	private InfcPkgYe162530DAO  infcPkgYe162530DAO;//G_임대차계약
	@Autowired
	@Resource(name = "InfcPkgYe164010DAO")
	private InfcPkgYe164010DAO infcPkgYe164010DAO; //A_의료비지급명세
	@Autowired
	@Resource(name = "InfcPkgYe165010DAO")
	private InfcPkgYe165010DAO  infcPkgYe165010DAO;//I_해당연도기부금명세
	@Autowired
	@Resource(name = "InfcPkgYe165020DAO")
	private InfcPkgYe165020DAO  infcPkgYe165020DAO;//I_기부자관계코드별기부금합계
	@Autowired
	@Resource(name = "InfcPkgYe165030DAO")
	private InfcPkgYe165030DAO  infcPkgYe165030DAO;//H_기부금조정명세
	@Autowired
	@Resource(name = "InfcPkgYe165030TempDAO")
	private InfcPkgYe165030TempDAO infcPkgYe165030TempDAO;    //H_기부금조정명세_TEMP	 
	@Autowired
	@Resource(name = "InfcPkgYe166010DAO")
	private InfcPkgYe166010DAO  infcPkgYe166010DAO;//신용카드등소득공제명세
	@Autowired
	@Resource(name = "InfcPkgYe166020DAO")
	private InfcPkgYe166020DAO infcPkgYe166020DAO;//신용카드등소득공제상세
		 
	@Autowired
	@Resource(name = "InfcPkgYe169010DAO")
	private InfcPkgYe169010DAO infcPkgYe169010DAO; //C_주현근무처
	@Autowired
	@Resource(name = "InfcPkgYe169010aDAO")
	private InfcPkgYe169010aDAO infcPkgYe169010aDAO; //C_주현근무처_표준공제 
	
	
	
//	// 연말정산 마감
//		@Autowired
//		@Resource(name = "InfcPkgYeta1000DAO")
//		private InfcPkgYeta1000DAO infcPkgYeta1000DAO;
//		
//		// 연말정산기본
//		@Autowired
//		@Resource(name = "InfcPkgYeta2000DAO")
//		private InfcPkgYeta2000DAO infcPkgYeta2000DAO;
//		
//		// 연말정산상세
//		@Autowired
//		@Resource(name = "InfcPkgYeta3000DAO")
//		private InfcPkgYeta3000DAO infcPkgYeta3000DAO;
//
//		@Autowired
//		@Resource(name = "InfcPkgYeta3100DAO")
//		private InfcPkgYeta3100DAO infcPkgYeta3100DAO;
//
//		@Autowired
//		@Resource(name = "InfcPkgYeta3110DAO")
//		private InfcPkgYeta3110DAO infcPkgYeta3110DAO;
//
//		@Resource(name = "InfcPkgYeta3120DAO")
//		private InfcPkgYeta3120DAO infcPkgYeta3120DAO;
//
//		@Autowired
//		@Resource(name = "InfcPkgYeta3130DAO")
//		private InfcPkgYeta3130DAO infcPkgYeta3130DAO;
//
//		@Resource(name = "InfcPkgYeta3140DAO")
//		private InfcPkgYeta3140DAO infcPkgYeta3140DAO;
//
//		@Autowired
//		@Resource(name = "InfcPkgYeta3150DAO")
//		private InfcPkgYeta3150DAO infcPkgYeta3150DAO;
//
//		@Autowired
//		@Resource(name = "InfcPkgYeta3160DAO")
//		private InfcPkgYeta3160DAO infcPkgYeta3160DAO;
//
//		@Autowired
//		@Resource(name = "InfcPkgYeta3170DAO")
//		private InfcPkgYeta3170DAO infcPkgYeta3170DAO;
//
//		@Autowired
//		@Resource(name = "InfcPkgYeta3180DAO")
//		private InfcPkgYeta3180DAO infcPkgYeta3180DAO;
//		
//		// 이월기부금
//		@Autowired
//		@Resource(name = "InfcPkgYeta3190DAO")
//		private InfcPkgYeta3190DAO infcPkgYeta3190DAO;
//		
//		// 가족사항
//		@Autowired
//		@Resource(name = "InfcPkgYeta3200DAO")
//		private InfcPkgYeta3200DAO infcPkgYeta3200DAO;
//
//		@Autowired
//		@Resource(name = "InfcPkgYeta3210DAO")
//		private InfcPkgYeta3210DAO infcPkgYeta3210DAO;
//
//		@Autowired
//		@Resource(name = "InfcPkgYeta3220DAO")
//		private InfcPkgYeta3220DAO infcPkgYeta3220DAO;
//
//		@Autowired
//		@Resource(name = "InfcPkgYeta3300DAO")
//		private InfcPkgYeta3300DAO infcPkgYeta3300DAO;
//
//		@Autowired
//		@Resource(name = "InfcPkgYeta3900DAO")
//		private InfcPkgYeta3900DAO infcPkgYeta3900DAO;
// 

	/***********************************************************************************
	 * 2017년귀속 연말정산 처리를 위한 함수 처리 부 시작 
	***********************************************************************************/
			
    /**
     * 
     * <pre>
     * 1. 개요 : 연말정산마감 급여내역 이관
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : fnYeta2100_YE160401_PAYR_2017_CREATE_Insert
     * @date : 2018. 1. 9.
     * @author : atres
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2018. 1. 9.		atres				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @see com.app.smrmf.pkg.yeta.yeta2017.tax.service.Yeta2100PayrService#fnYeta2100_YE160401_PAYR_2017_CREATE_Insert(com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160401VO)
     * @param infcPkgYe160401Vo
     * @return
     * @throws Exception
     */
	public String fnYeta2100_YE160401_PAYR_2017_CREATE_Insert(InfcPkgYe160401VO infcPkgYe160401Vo) throws Exception {
		// LOGGER.debug(vo.toString());
		String dataCheck = "";
		 
		dataCheck = infcPkgYe160401DAO.fnYeta2100_YE160401_PAYR_2017_CREATE_Insert(infcPkgYe160401Vo);
		// TODO 해당 테이블 정보에 맞게 수정
		return dataCheck;
	}  	
	 
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 연말정산기본 과세 감면  인서트 
	 * 2. 처리내용 :  연말정산기본 과세 감면  인서트 
	 * </pre>
	 * @Method Name : fnYeta2100_YE160402_PAYR_2017_CREATE_Insert
	 * @date : 2018. 1. 9.
	 * @author : atres
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 9.		atres				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @see com.app.smrmf.pkg.yeta.yeta2017.tax.service.Yeta2100PayrService#fnYeta2100_YE160402_PAYR_2017_CREATE_Insert(com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160402VO)
	 * @param infcPkgYe160402Vo
	 * @throws Exception
	 */
    public String fnYeta2100_YE160402_PAYR_2017_CREATE_Insert(InfcPkgYe160402VO infcPkgYe160402Vo) throws Exception {
    	String dataCheck = "";
    	dataCheck =  infcPkgYe160402DAO.fnYeta2100_YE160402_PAYR_2017_CREATE_Insert(infcPkgYe160402Vo);
    	return dataCheck;
	}
		 
    /**
	  * 
	  * <pre>
	  * 1. 개요 : 연말정산 4대보험 인서트 Ye161050 국민연금 관련 인서트 
	  * 2. 처리내용 : 연말정산 4대보험 인서트 Ye161050국민연금 관련 인서트 
	  *             C_연금보험료공제
	  * </pre>
	  * @Method Name : fnYeta2100_Ye161050_PAYR_2017_CREATE_Update
	  * @date : 2018. 1. 9.
	  * @author : atres
	  * @history : 
	  *	-----------------------------------------------------------------------
	  *	변경일				작성자						변경내용  
	  *	----------- ------------------- ---------------------------------------
	  *	2018. 1. 9.		atres				최초 작성 
	  *	-----------------------------------------------------------------------
	  *
	  */ 
    public String fnYeta2100_Ye161050_PAYR_2017_CREATE_Insert(InfcPkgYe160401VO infcPkgYe160401Vo) throws Exception {
    	return infcPkgYe161050DAO.fnYeta2100_Ye161050_PAYR_2017_CREATE_Insert(infcPkgYe160401Vo);
	}  
     
	/**
	 * 
	 * <pre>
	 * 1. 개요 : C_연금보험료_공적연금상세
	 * 2. 처리내용 : 연말정산 4대보험 인서트 Ye161050 /Ye161055
	 * </pre>
	 * @Method Name : fnYeta2100_Ye161055_PAYR_2017_CREATE_Insert
	 * @date : 2018. 1. 9.
	 * @author : atres
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 9.		atres				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param infcPkgYe160401Vo
	 */
	 
	  public String fnYeta2100_Ye161055_PAYR_2017_CREATE_Insert(InfcPkgYe160401VO infcPkgYe160401Vo) throws Exception {
		   String rtnChk = "";
		   //국민연금 주근무지
		   rtnChk = infcPkgYe161055DAO.fnYeta2100_Ye161055_PAYR_2017_Y0130001_Insert(infcPkgYe160401Vo);
		   //국민연금 종근무지
		   rtnChk = infcPkgYe161055DAO.fnYeta2100_Ye161055_PAYR_2017_Y0130002_Insert(infcPkgYe160401Vo);
		   
		   return rtnChk;
		   
		}  
	    
	  
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 연말정산 4대보험 인서트 Ye161060 
	 * 2. 처리내용 : 연말정산 4대보험 인서트 Ye161050 /Ye161055 /Ye161060 
	 * 				--- C_특별소득공제  국민연금/고용보험 
	 * </pre>
	 * @Method Name : fnYeta2100_Ye161060_PAYR_2017_CREATE_Insert
	 * @date : 2018. 1. 9.
	 * @author : atres
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 9.		atres				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param infcPkgYe160401Vo
	 */ 
	public String fnYeta2100_Ye161060_PAYR_2017_CREATE_Insert(InfcPkgYe160401VO infcPkgYe160401Vo) throws Exception {
		  return infcPkgYe161060DAO.fnYeta2100_Ye161060_PAYR_2017_CREATE_Insert(infcPkgYe160401Vo);
		}  
	    
	//{비과세 감면 인서트 }
    //{**************************연말정산기본 비과세 감면 업데이트   [4 - 1]********************************} 
    public String fnYeta2100_YE160403_PAYR_2017_CREATE_Insert(InfcPkgYe160403VO infcPkgYe160403Vo) throws Exception {
    	return infcPkgYe160403DAO.fnYeta2100_YE160403_PAYR_2017_CREATE_Insert(infcPkgYe160403Vo);
	}   
     
    // {******************************급여자료 이관 - 연말정산 425 업데이트   [5]*******************************************}
    //425 업데이트
	public String fnYeta2100_YE169010_PAYR_2017_CREATE_Insert(InfcPkgYe160401VO infcPkgYe160401Vo) throws Exception {
	   return infcPkgYe169010DAO.fnYeta2100_YE169010_PAYR_2017_CREATE_Insert(infcPkgYe160401Vo);
	}      
    
	           
	public String fnYeta2100_YE161010_2017_CREATE_Insert(InfcPkgYe161010VO infcPkgYe161010Vo) throws Exception {
      	//LOGGER.debug(vo.toString());
    	  String dataCheck = "";
      	/** ID Generation Service */
      	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
      	//String id = egovIdGnrService.getNextStringId();
      	//vo.setId(id);
      //	LOGGER.debug(vo.toString());
    	                                  
    	  dataCheck = infcPkgYe161010DAO.fnYeta2100_YE161010_2017_CREATE_Insert(infcPkgYe161010Vo);
		// TODO 해당 테이블 정보에 맞게 수정
		return dataCheck;
	} 
	
	public String fnYeta2100_YE161020_2017_CREATE_Insert(InfcPkgYe161020VO infcPkgYe161020Vo) throws Exception {
      	//LOGGER.debug(vo.toString());
    	  String dataCheck = "";
      	/** ID Generation Service */
      	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
      	//String id = egovIdGnrService.getNextStringId();
      	//vo.setId(id);
      //	LOGGER.debug(vo.toString());
    	                                  
    	  dataCheck = infcPkgYe161020DAO.fnYeta2100_YE161020_2017_CREATE_Insert(infcPkgYe161020Vo);
		// TODO 해당 테이블 정보에 맞게 수정
		return dataCheck;
	} 
	
	
	public String fnYeta2100_YE166020_2017_CREATE_Insert01(InfcPkgYe166020VO infcPkgYe166020Vo) throws Exception {
      	//LOGGER.debug(vo.toString());
    	  String dataCheck = "";
      	/** ID Generation Service */
      	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
      	//String id = egovIdGnrService.getNextStringId();
      	//vo.setId(id);
      //	LOGGER.debug(vo.toString());
    	                                  
    	  dataCheck = infcPkgYe166020DAO.fnYeta2100_YE166020_2017_CREATE_Insert01(infcPkgYe166020Vo);
		// TODO 해당 테이블 정보에 맞게 수정
		return dataCheck;
	} 
	
	
	public String fnYeta2100_YE166020_2017_CREATE_Insert02(InfcPkgYe166020VO infcPkgYe166020Vo) throws Exception {
      	//LOGGER.debug(vo.toString());
    	  String dataCheck = "";
      	/** ID Generation Service */
      	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
      	//String id = egovIdGnrService.getNextStringId();
      	//vo.setId(id);
      //	LOGGER.debug(vo.toString());
    	                                  
    	  dataCheck = infcPkgYe166020DAO.fnYeta2100_YE166020_2017_CREATE_Insert02(infcPkgYe166020Vo);
		// TODO 해당 테이블 정보에 맞게 수정
		return dataCheck;
	} 
	
	public String fnYeta2100_YE166010_2017_CREATE_Insert(InfcPkgYe166010VO infcPkgYe166010Vo) throws Exception {
      	//LOGGER.debug(vo.toString());
    	  String dataCheck = "";
      	/** ID Generation Service */
      	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
      	//String id = egovIdGnrService.getNextStringId();
      	//vo.setId(id);
      //	LOGGER.debug(vo.toString());
    	                                  
    	  dataCheck = infcPkgYe166010DAO.fnYeta2100_YE166010_2017_CREATE_Insert( infcPkgYe166010Vo);
		// TODO 해당 테이블 정보에 맞게 수정
		return dataCheck;
	}
	 
	
	public String fnYeta2100_YE161030_2017_CREATE_Insert(InfcPkgYe161030VO infcPkgYe161030Vo) throws Exception {
      	//LOGGER.debug(vo.toString());
    	  String dataCheck = "";
      	/** ID Generation Service */
      	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
      	//String id = egovIdGnrService.getNextStringId();
      	//vo.setId(id);
      //	LOGGER.debug(vo.toString());
    	                                  
    	  dataCheck = infcPkgYe161030DAO.fnYeta2100_YE161030_2017_CREATE_Insert(infcPkgYe161030Vo);
		// TODO 해당 테이블 정보에 맞게 수정
		return dataCheck;
	} 
	
	
	public String fnYeta2100_YE161040_2017_CREATE_Insert01(InfcPkgYe161040VO infcPkgYe161040Vo) throws Exception {
      	//LOGGER.debug(vo.toString());
    	  String dataCheck = "";
      	/** ID Generation Service */
      	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
      	//String id = egovIdGnrService.getNextStringId();
      	//vo.setId(id);
      //	LOGGER.debug(vo.toString());
    	                                  
    	  dataCheck = infcPkgYe161040DAO.fnYeta2100_YE161040_2017_CREATE_Insert01(infcPkgYe161040Vo);
		// TODO 해당 테이블 정보에 맞게 수정
		return dataCheck;
	} 
	
	
	public String fnYeta2100_YE161040_2017_CREATE_Insert02(InfcPkgYe161040VO infcPkgYe161040Vo) throws Exception {
      	//LOGGER.debug(vo.toString());
    	  String dataCheck = "";
      	/** ID Generation Service */
      	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
      	//String id = egovIdGnrService.getNextStringId();
      	//vo.setId(id);
      //	LOGGER.debug(vo.toString());
    	                                  
    	  dataCheck = infcPkgYe161040DAO.fnYeta2100_YE161040_2017_CREATE_Insert02(infcPkgYe161040Vo);
		// TODO 해당 테이블 정보에 맞게 수정
		return dataCheck;
	} 
	
	
	public int fnYeta2100_YE161040_2017_INSU_FETC_Update(InfcPkgYe161040VO infcPkgYe161040Vo) throws Exception {
      	//LOGGER.debug(vo.toString());
    	 
      	/** ID Generation Service */
      	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
      	//String id = egovIdGnrService.getNextStringId();
      	//vo.setId(id);
      //	LOGGER.debug(vo.toString());
    	                                  
    	  return infcPkgYe161040DAO.fnYeta2100_YE161040_2017_INSU_FETC_Update(infcPkgYe161040Vo);
		// TODO 해당 테이블 정보에 맞게 수정
		 
	} 

	
	public int fnYeta2100_YE161030_2017_CREATE_Update(InfcPkgYe161030VO infcPkgYe161030Vo) throws Exception {
      	//LOGGER.debug(vo.toString()); 
      	/** ID Generation Service */
      	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
      	//String id = egovIdGnrService.getNextStringId();
      	//vo.setId(id);
      //	LOGGER.debug(vo.toString());
    	                                  
    	  return infcPkgYe161030DAO.fnYeta2100_YE161030_2017_CREATE_Update(infcPkgYe161030Vo);
		// TODO 해당 테이블 정보에 맞게 수정
		 
	} 
	
	

	public String fnYeta2100_YE165030_TEMP_2017_CREATE_Insert(InfcPkgYe165030TempVO infcPkgYe165030TempVo) throws Exception {
      	//LOGGER.debug(vo.toString());
    	  String dataCheck = "";
      	/** ID Generation Service */
      	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
      	//String id = egovIdGnrService.getNextStringId();
      	//vo.setId(id);
      //	LOGGER.debug(vo.toString());
    	                                  
    	  dataCheck = infcPkgYe165030TempDAO.fnYeta2100_YE165030_TEMP_2017_CREATE_Insert(infcPkgYe165030TempVo);
		// TODO 해당 테이블 정보에 맞게 수정
		return dataCheck;
	} 

	public String fnYeta2100_YE165030TempYE165030_2017_CREATE_Insert(InfcPkgYe165030VO infcPkgYe165030Vo) throws Exception {
      	//LOGGER.debug(vo.toString());
    	  String dataCheck = "";
      	/** ID Generation Service */
      	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
      	//String id = egovIdGnrService.getNextStringId();
      	//vo.setId(id);
      //	LOGGER.debug(vo.toString());
    	                                  
    	  dataCheck = infcPkgYe165030DAO.fnYeta2100_YE165030TempYE165030_2017_CREATE_Insert(infcPkgYe165030Vo);
		// TODO 해당 테이블 정보에 맞게 수정
		return dataCheck;
	} 
	  
	
	public String fnYeta2100_YE161070_2017_CREATE_Insert(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception {
      	//LOGGER.debug(vo.toString());
    	  String dataCheck = "";
      	/** ID Generation Service */
      	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
      	//String id = egovIdGnrService.getNextStringId();
      	//vo.setId(id);
      //	LOGGER.debug(vo.toString());
    	                                  
    	  dataCheck = infcPkgYe161070DAO.fnYeta2100_YE161070_2017_CREATE_Insert(infcPkgYe161070Vo);
		// TODO 해당 테이블 정보에 맞게 수정
		return dataCheck;
	} 
	
	
	
	public String fnYeta2100_YE161080_2017_CREATE_Insert(InfcPkgYe161080VO infcPkgYe161080Vo) throws Exception {
      	//LOGGER.debug(vo.toString());
    	  String dataCheck = "";
      	/** ID Generation Service */
      	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
      	//String id = egovIdGnrService.getNextStringId();
      	//vo.setId(id);
      //	LOGGER.debug(vo.toString());
    	                                  
    	  dataCheck = infcPkgYe161080DAO.fnYeta2100_YE161080_2017_CREATE_Insert(infcPkgYe161080Vo);
		// TODO 해당 테이블 정보에 맞게 수정
		return dataCheck;
	} 
	 
	
//	public String fnYeta2100_YE169010_2017_CREATE_Insert(InfcPkgYe161010VO infcPkgYe161010Vo) throws Exception {
//      	//LOGGER.debug(vo.toString());
//    	  String dataCheck = "";
//      	/** ID Generation Service */
//      	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
//      	//String id = egovIdGnrService.getNextStringId();
//      	//vo.setId(id);
//      //	LOGGER.debug(vo.toString());
//    	                                  
//    	  dataCheck = infcPkgYe169010DAO.fnYeta2100_YE169010_2017_CREATE_Insert(infcPkgYe161010Vo);
//		// TODO 해당 테이블 정보에 맞게 수정
//		return dataCheck;
//	} 
	 
	public String fnYeta2100_YE169010a_2017_CREATE_Insert(InfcPkgYe169010aVO infcPkgYe169010AVo) throws Exception {
	//LOGGER.debug(vo.toString());
  String dataCheck = "";
	/** ID Generation Service */
	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
	//String id = egovIdGnrService.getNextStringId();
	//vo.setId(id);
//	LOGGER.debug(vo.toString());
                                  
  dataCheck = infcPkgYe169010aDAO.fnYeta2100_YE169010a_2017_CREATE_Insert(infcPkgYe169010AVo);
// TODO 해당 테이블 정보에 맞게 수정
return dataCheck;
} 
	
	
	// 급여 노조회비 기부금 반영 처리 부
	public String fnYeta2100_YE165010_2017_PAYR_CREATE(InfcPkgYe165010VO infcPkgYe165010Vo) throws Exception {
      	//LOGGER.debug(vo.toString());
    	  String dataCheck = "";
      	/** ID Generation Service */
      	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	  infcPkgYe165010DAO.fnYeta2100_YE165010_2017_PAYR_CREATE_DELETE(infcPkgYe165010Vo);                   
    	  dataCheck = infcPkgYe165010DAO.fnYeta2100_YE165010_2017_PAYR_CREATE_INSERT(infcPkgYe165010Vo);
    	  
		return dataCheck;
	} 
	
	 
	 /**!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	  * 단위사업장 맵핑정보 가져오기 
	  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/

	  
    public HashMap selectBass0360SearchList(InfcPkgYe161010SrhVO infcPkgYe161010SrhVo) throws Exception {
        return infcPkgYe161010DAO.selectBass0360SearchList(infcPkgYe161010SrhVo);
    }	
    
    
    public HashMap selectBass0500SearchList(InfcPkgYe161010SrhVO infcPkgYe161010SrhVo) throws Exception {
        return infcPkgYe161010DAO.selectBass0500SearchList(infcPkgYe161010SrhVo);
    }	
    
    public void fnYeta2100_YE161010_UtDpobCd_2017_Update(InfcPkgYe161010VO infcPkgYe161010Vo) throws Exception {
          infcPkgYe161010DAO.fnYeta2100_YE161010_UtDpobCd_2017_Update(  infcPkgYe161010Vo);
    }	 
 
  
	
   /***********************************************************************************
    * 2017년귀속 연말정산 처리를 위한 함수 처리 부 종료
	***********************************************************************************/
	
	 
    
}
