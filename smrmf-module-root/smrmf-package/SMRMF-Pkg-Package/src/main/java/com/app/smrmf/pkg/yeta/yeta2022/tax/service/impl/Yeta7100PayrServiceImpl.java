package com.app.smrmf.pkg.yeta.yeta2022.tax.service.impl;

import java.util.HashMap;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao.InfcPkgYe160404_2022_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao.InfcPkgYe160405_2022_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao.InfcPkgYe160406_2022_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao.InfcPkgYe160510_2022_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao.InfcPkgYe161005_2022_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao.InfcPkgYe161010_2022_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao.InfcPkgYe161020_2022_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao.InfcPkgYe161030_2022_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao.InfcPkgYe161040_2022_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao.InfcPkgYe161050_2022_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao.InfcPkgYe161055_2022_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao.InfcPkgYe161060_2022_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao.InfcPkgYe161070_2022_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao.InfcPkgYe161080_2022_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao.InfcPkgYe161090_2022_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao.InfcPkgYe162010_2022_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao.InfcPkgYe162020_2022_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao.InfcPkgYe162030_2022_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao.InfcPkgYe162040_2022_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao.InfcPkgYe162510_2022_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao.InfcPkgYe162520_2022_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao.InfcPkgYe162530_2022_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao.InfcPkgYe164010_2022_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao.InfcPkgYe165010_2022_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao.InfcPkgYe165020_2022_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao.InfcPkgYe165030_2022_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao.InfcPkgYe165030Temp_2022_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao.InfcPkgYe166010_2022_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao.InfcPkgYe166020_2022_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao.InfcPkgYe169010_2022_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao.InfcPkgYe169010a_2022_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao.InfcPkgYe170401_2022_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao.InfcPkgYe170402_2022_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2022.dao.InfcPkgYe170403_2022_DAO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160401VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160402VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160403VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161010Srh_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161010_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161020_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161030_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161040_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161070_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161080_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe165010_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe165030Temp_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe165030_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe166010_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe166020_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe169010a_2022_VO;
import com.app.smrmf.pkg.yeta.yeta2022.tax.service.Yeta7100PayrService;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

/**
 * @Class Name : Yeta7900ServiceImpl.java
 * @Description : Yeta7900 Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2022.01.18
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("Yeta7100PayrService")
public class Yeta7100PayrServiceImpl extends AbstractServiceImpl  implements
        Yeta7100PayrService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(Yeta7100PayrServiceImpl.class);

	@Autowired
	@Resource(name = "InfcPkgYe170401_2022_DAO")
	private InfcPkgYe170401_2022_DAO infcPkgYe160401DAO; //현근무지급여지급명세
	@Autowired
	@Resource(name = "InfcPkgYe170402_2022_DAO")
	private InfcPkgYe170402_2022_DAO  infcPkgYe160402DAO;//현근무지비과세_감면소득_과세
	@Autowired
	@Resource(name = "InfcPkgYe170403_2022_DAO")
	private InfcPkgYe170403_2022_DAO  infcPkgYe160403DAO;//현근무지비과세_감면소득_비과세
	@Autowired
	@Resource(name = "InfcPkgYe160404_2022_DAO")
	private InfcPkgYe160404_2022_DAO  infcPkgYe160404DAO;//D_종전근무처
	@Autowired
	@Resource(name = "InfcPkgYe160405_2022_DAO")
	private InfcPkgYe160405_2022_DAO  infcPkgYe160405DAO;//D_종전근무처비과세_감면소득_비과세
	@Autowired
	@Resource(name = "InfcPkgYe160406_2022_DAO")
	private InfcPkgYe160406_2022_DAO  infcPkgYe160406DAO;//종전근무지연금보험료_공적연금
	@Autowired
	@Resource(name = "InfcPkgYe160510_2022_DAO")
	private InfcPkgYe160510_2022_DAO  infcPkgYe160510DAO;//근무지별비과세_감면소득
	            
	@Autowired
	@Resource(name = "InfcPkgYe161005_2022_DAO")
	private InfcPkgYe161005_2022_DAO  infcPkgYe161005DAO;//A_원천세신고기본
	            
	@Autowired
	@Resource(name = "InfcPkgYe161010_2022_DAO")
	private InfcPkgYe161010_2022_DAO  infcPkgYe161010DAO;// 연말정산대상자기본
	@Autowired
	@Resource(name = "InfcPkgYe161020_2022_DAO")
	private InfcPkgYe161020_2022_DAO  infcPkgYe161020DAO;//A_인적소득공제기본
	@Autowired
	@Resource(name = "InfcPkgYe161030_2022_DAO")
	private InfcPkgYe161030_2022_DAO  infcPkgYe161030DAO;//E_인적공제명세
	@Autowired
	@Resource(name = "InfcPkgYe161040_2022_DAO")
	private InfcPkgYe161040_2022_DAO  infcPkgYe161040DAO;//E_소득세액공제명세
	@Autowired
	@Resource(name = "InfcPkgYe161050_2022_DAO")
	private InfcPkgYe161050_2022_DAO  infcPkgYe161050DAO;//C_연금보험료공제
	@Autowired
	@Resource(name = "InfcPkgYe161055_2022_DAO")
	private InfcPkgYe161055_2022_DAO  infcPkgYe161055DAO;//C_연금보험료_공적연금상세
	@Autowired
	@Resource(name = "InfcPkgYe161060_2022_DAO")
	private InfcPkgYe161060_2022_DAO  infcPkgYe161060DAO;//C_특별소득공제
	@Autowired
	@Resource(name = "InfcPkgYe161070_2022_DAO")
	private InfcPkgYe161070_2022_DAO  infcPkgYe161070DAO;//C_그밖의소득공제
	@Autowired
	@Resource(name = "InfcPkgYe161080_2022_DAO")
	private InfcPkgYe161080_2022_DAO  infcPkgYe161080DAO;//C_세액감면및공제
	@Autowired
	@Resource(name = "InfcPkgYe161090_2022_DAO")
	private InfcPkgYe161090_2022_DAO  infcPkgYe161090DAO;//C_교육비내역
	@Autowired
	@Resource(name = "InfcPkgYe162010_2022_DAO")
	private InfcPkgYe162010_2022_DAO  infcPkgYe162010DAO;//F_연금저축계좌
	@Autowired
	@Resource(name = "InfcPkgYe162020_2022_DAO")
	private InfcPkgYe162020_2022_DAO  infcPkgYe162020DAO;//F_퇴직연금계좌명세
	@Autowired
	@Resource(name = "InfcPkgYe162030_2022_DAO")
	private InfcPkgYe162030_2022_DAO  infcPkgYe162030DAO;//F_주택마련저축
	@Autowired
	@Resource(name = "InfcPkgYe162040_2022_DAO")
	private InfcPkgYe162040_2022_DAO  infcPkgYe162040DAO;//F_장기집합투자증권저축_B1013
	@Autowired
	@Resource(name = "InfcPkgYe162510_2022_DAO")
	private InfcPkgYe162510_2022_DAO  infcPkgYe162510DAO;//G_월세액소득공제명세
	@Autowired
	@Resource(name = "InfcPkgYe162520_2022_DAO")
	private InfcPkgYe162520_2022_DAO  infcPkgYe162520DAO;//G_거주자간_금전소비대차
	@Autowired
	@Resource(name = "InfcPkgYe162530_2022_DAO")
	private InfcPkgYe162530_2022_DAO  infcPkgYe162530DAO;//G_임대차계약
	@Autowired
	@Resource(name = "InfcPkgYe164010_2022_DAO")
	private InfcPkgYe164010_2022_DAO infcPkgYe164010DAO; //A_의료비지급명세
	@Autowired
	@Resource(name = "InfcPkgYe165010_2022_DAO")
	private InfcPkgYe165010_2022_DAO  infcPkgYe165010DAO;//I_해당연도기부금명세
	@Autowired
	@Resource(name = "InfcPkgYe165020_2022_DAO")
	private InfcPkgYe165020_2022_DAO  infcPkgYe165020DAO;//I_기부자관계코드별기부금합계
	@Autowired
	@Resource(name = "InfcPkgYe165030_2022_DAO")
	private InfcPkgYe165030_2022_DAO  infcPkgYe165030DAO;//H_기부금조정명세
	@Autowired
	@Resource(name = "InfcPkgYe165030Temp_2022_DAO")
	private InfcPkgYe165030Temp_2022_DAO infcPkgYe165030TempDAO;    //H_기부금조정명세_TEMP	 
	@Autowired
	@Resource(name = "InfcPkgYe166010_2022_DAO")
	private InfcPkgYe166010_2022_DAO  infcPkgYe166010DAO;//신용카드등소득공제명세
	@Autowired
	@Resource(name = "InfcPkgYe166020_2022_DAO")
	private InfcPkgYe166020_2022_DAO infcPkgYe166020DAO;//신용카드등소득공제상세
		 
	@Autowired
	@Resource(name = "InfcPkgYe169010_2022_DAO")
	private InfcPkgYe169010_2022_DAO infcPkgYe169010DAO; //C_주현근무처
	@Autowired
	@Resource(name = "InfcPkgYe169010a_2022_DAO")
	private InfcPkgYe169010a_2022_DAO infcPkgYe169010aDAO; //C_주현근무처_표준공제 
	

	/***********************************************************************************
	 * 2022년귀속 연말정산 처리를 위한 함수 처리 부 시작 
	***********************************************************************************/
			
    /**
     * 
     * <pre>
     * 1. 개요 : 연말정산마감 급여내역 이관
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : fnYeta7100_YE160401_PAYR_2022_CREATE_Insert
     * @date : 2022. 1. 9.
     * @author : atres
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2022. 1. 9.		atres				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @see com.app.smrmf.pkg.yeta.yeta2022.tax.service.Yeta7100PayrService#fnYeta7100_YE160401_PAYR_2022_CREATE_Insert(com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160401VO)
     * @param infcPkgYe160401Vo
     * @return
     * @throws Exception
     */
	public String fnYeta7100_YE160401_PAYR_2022_CREATE_Insert(InfcPkgYe160401VO infcPkgYe160401Vo) throws Exception {
		// LOGGER.debug(vo.toString());
		String dataCheck = "";
		 
		dataCheck = infcPkgYe160401DAO.fnYeta7100_YE160401_PAYR_2022_CREATE_Insert(infcPkgYe160401Vo);
		// TODO 해당 테이블 정보에 맞게 수정
		return dataCheck;
	}  	
	 
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 연말정산기본 과세 감면  인서트 
	 * 2. 처리내용 :  연말정산기본 과세 감면  인서트 
	 * </pre>
	 * @Method Name : fnYeta7100_YE160402_PAYR_2022_CREATE_Insert
	 * @date : 2022. 1. 9.
	 * @author : atres
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2022. 1. 9.		atres				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @see com.app.smrmf.pkg.yeta.yeta2022.tax.service.Yeta7100PayrService#fnYeta7100_YE160402_PAYR_2022_CREATE_Insert(com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160402VO)
	 * @param infcPkgYe160402Vo
	 * @throws Exception
	 */
    public String fnYeta7100_YE160402_PAYR_2022_CREATE_Insert(InfcPkgYe160402VO infcPkgYe160402Vo) throws Exception {
    	String dataCheck = "";
    	dataCheck =  infcPkgYe160402DAO.fnYeta7100_YE160402_PAYR_2022_CREATE_Insert(infcPkgYe160402Vo);
    	return dataCheck;
	}
		 
    /**
	  * 
	  * <pre>
	  * 1. 개요 : 연말정산 4대보험 인서트 Ye161050 국민연금 관련 인서트 
	  * 2. 처리내용 : 연말정산 4대보험 인서트 Ye161050국민연금 관련 인서트 
	  *             C_연금보험료공제
	  * </pre>
	  * @Method Name : fnYeta7100_Ye161050_PAYR_2022_CREATE_Update
	  * @date : 2022. 1. 9.
	  * @author : atres
	  * @history : 
	  *	-----------------------------------------------------------------------
	  *	변경일				작성자						변경내용  
	  *	----------- ------------------- ---------------------------------------
	  *	2022. 1. 9.		atres				최초 작성 
	  *	-----------------------------------------------------------------------
	  *
	  */ 
    public String fnYeta7100_Ye161050_PAYR_2022_CREATE_Insert(InfcPkgYe160401VO infcPkgYe160401Vo) throws Exception {
    	return infcPkgYe161050DAO.fnYeta7100_Ye161050_PAYR_2022_CREATE_Insert(infcPkgYe160401Vo);
	}  
     
	/**
	 * 
	 * <pre>
	 * 1. 개요 : C_연금보험료_공적연금상세
	 * 2. 처리내용 : 연말정산 4대보험 인서트 Ye161050 /Ye161055
	 * </pre>
	 * @Method Name : fnYeta7100_Ye161055_PAYR_2022_CREATE_Insert
	 * @date : 2022. 1. 9.
	 * @author : atres
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2022. 1. 9.		atres				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param infcPkgYe160401Vo
	 */
	 
	  public String fnYeta7100_Ye161055_PAYR_2022_CREATE_Insert(InfcPkgYe160401VO infcPkgYe160401Vo) throws Exception {
		   String rtnChk = "";
		   //국민연금 주근무지
		   rtnChk = infcPkgYe161055DAO.fnYeta7100_Ye161055_PAYR_2022_Y0130001_Insert(infcPkgYe160401Vo);
		   //국민연금 종근무지
		   rtnChk = infcPkgYe161055DAO.fnYeta7100_Ye161055_PAYR_2022_Y0130002_Insert(infcPkgYe160401Vo);
		   
		   return rtnChk;
		   
		}  
	    
	  
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 연말정산 4대보험 인서트 Ye161060 
	 * 2. 처리내용 : 연말정산 4대보험 인서트 Ye161050 /Ye161055 /Ye161060 
	 * 				--- C_특별소득공제  국민연금/고용보험 
	 * </pre>
	 * @Method Name : fnYeta7100_Ye161060_PAYR_2022_CREATE_Insert
	 * @date : 2022. 1. 9.
	 * @author : atres
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2022. 1. 9.		atres				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param infcPkgYe160401Vo
	 */ 
	public String fnYeta7100_Ye161060_PAYR_2022_CREATE_Insert(InfcPkgYe160401VO infcPkgYe160401Vo) throws Exception {
		  return infcPkgYe161060DAO.fnYeta7100_Ye161060_PAYR_2022_CREATE_Insert(infcPkgYe160401Vo);
		}  
	    
	//{비과세 감면 인서트 }
    //{**************************연말정산기본 비과세 감면 업데이트   [4 - 1]********************************} 
    public String fnYeta7100_YE160403_PAYR_2022_CREATE_Insert(InfcPkgYe160403VO infcPkgYe160403Vo) throws Exception {
    	return infcPkgYe160403DAO.fnYeta7100_YE160403_PAYR_2022_CREATE_Insert(infcPkgYe160403Vo);
	}   

    // {******************************급여자료 이관 - 연말정산 425 업데이트   [5]*******************************************}
    //425 업데이트
	public String fnYeta7100_YE169010_PAYR_2022_CREATE_Insert(InfcPkgYe160401VO infcPkgYe160401Vo) throws Exception {
	   return infcPkgYe169010DAO.fnYeta7100_YE169010_PAYR_2022_CREATE_Insert(infcPkgYe160401Vo);
	}      
    
	           
	public String fnYeta7100_YE161010_2022_CREATE_Insert(InfcPkgYe161010_2022_VO infcPkgYe161010Vo) throws Exception {
      	//LOGGER.debug(vo.toString());
    	  String dataCheck = "";
      	/** ID Generation Service */
      	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
      	//String id = egovIdGnrService.getNextStringId();
      	//vo.setId(id);
      //	LOGGER.debug(vo.toString());
    	                                  
    	  dataCheck = infcPkgYe161010DAO.fnYeta7100_YE161010_2022_CREATE_Insert(infcPkgYe161010Vo);
		// TODO 해당 테이블 정보에 맞게 수정
		return dataCheck;
	} 
	
	public String fnYeta7100_YE161020_2022_CREATE_Insert(InfcPkgYe161020_2022_VO infcPkgYe161020Vo) throws Exception {
      	//LOGGER.debug(vo.toString());
    	  String dataCheck = "";
      	/** ID Generation Service */
      	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
      	//String id = egovIdGnrService.getNextStringId();
      	//vo.setId(id);
      //	LOGGER.debug(vo.toString());
    	                                  
    	  dataCheck = infcPkgYe161020DAO.fnYeta7100_YE161020_2022_CREATE_Insert(infcPkgYe161020Vo);
		// TODO 해당 테이블 정보에 맞게 수정
		return dataCheck;
	} 
	
	
	public String fnYeta7100_YE166020_2022_CREATE_Insert01(InfcPkgYe166020_2022_VO infcPkgYe166020Vo) throws Exception {
      	//LOGGER.debug(vo.toString());
    	  String dataCheck = "";
      	/** ID Generation Service */
      	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
      	//String id = egovIdGnrService.getNextStringId();
      	//vo.setId(id);
      //	LOGGER.debug(vo.toString());
    	                                  
    	  dataCheck = infcPkgYe166020DAO.fnYeta7100_YE166020_2022_CREATE_Insert01(infcPkgYe166020Vo);
		// TODO 해당 테이블 정보에 맞게 수정
		return dataCheck;
	} 
	
	
	public String fnYeta7100_YE166020_2022_CREATE_Insert02(InfcPkgYe166020_2022_VO infcPkgYe166020Vo) throws Exception {
      	//LOGGER.debug(vo.toString());
    	  String dataCheck = "";
      	/** ID Generation Service */
      	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
      	//String id = egovIdGnrService.getNextStringId();
      	//vo.setId(id);
      //	LOGGER.debug(vo.toString());
    	                                  
    	  dataCheck = infcPkgYe166020DAO.fnYeta7100_YE166020_2022_CREATE_Insert02(infcPkgYe166020Vo);
		// TODO 해당 테이블 정보에 맞게 수정
		return dataCheck;
	} 
	
	public String fnYeta7100_YE166010_2022_CREATE_Insert(InfcPkgYe166010_2022_VO infcPkgYe166010Vo) throws Exception {
      	//LOGGER.debug(vo.toString());
    	  String dataCheck = "";
      	/** ID Generation Service */
      	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
      	//String id = egovIdGnrService.getNextStringId();
      	//vo.setId(id);
      //	LOGGER.debug(vo.toString());
    	                                  
    	  dataCheck = infcPkgYe166010DAO.fnYeta7100_YE166010_2022_CREATE_Insert( infcPkgYe166010Vo);
		// TODO 해당 테이블 정보에 맞게 수정
		return dataCheck;
	}
	 
	
	public String fnYeta7100_YE161030_2022_CREATE_Insert(InfcPkgYe161030_2022_VO infcPkgYe161030Vo) throws Exception {
      	//LOGGER.debug(vo.toString());
    	  String dataCheck = "";
      	/** ID Generation Service */
      	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
      	//String id = egovIdGnrService.getNextStringId();
      	//vo.setId(id);
      //	LOGGER.debug(vo.toString());
    	                                  
    	  dataCheck = infcPkgYe161030DAO.fnYeta7100_YE161030_2022_CREATE_Insert(infcPkgYe161030Vo);
		// TODO 해당 테이블 정보에 맞게 수정
		return dataCheck;
	} 
	
	
	public String fnYeta7100_YE161040_2022_CREATE_Insert01(InfcPkgYe161040_2022_VO infcPkgYe161040Vo) throws Exception {
      	//LOGGER.debug(vo.toString());
    	  String dataCheck = "";
      	/** ID Generation Service */
      	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
      	//String id = egovIdGnrService.getNextStringId();
      	//vo.setId(id);
      //	LOGGER.debug(vo.toString());

    	  dataCheck = infcPkgYe161040DAO.fnYeta7100_YE161040_2022_CREATE_Insert01(infcPkgYe161040Vo);
		// TODO 해당 테이블 정보에 맞게 수정
		return dataCheck;
	} 
	
	
	public String fnYeta7100_YE161040_2022_CREATE_Insert02(InfcPkgYe161040_2022_VO infcPkgYe161040Vo) throws Exception {
      	//LOGGER.debug(vo.toString());
    	  String dataCheck = "";
      	/** ID Generation Service */
      	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
      	//String id = egovIdGnrService.getNextStringId();
      	//vo.setId(id);
      //	LOGGER.debug(vo.toString());
    	                                  
    	  dataCheck = infcPkgYe161040DAO.fnYeta7100_YE161040_2022_CREATE_Insert02(infcPkgYe161040Vo);
		// TODO 해당 테이블 정보에 맞게 수정
		return dataCheck;
	} 
	
	
	public int fnYeta7100_YE161040_2022_INSU_FETC_Update(InfcPkgYe161040_2022_VO infcPkgYe161040Vo) throws Exception {
      	//LOGGER.debug(vo.toString());
    	 
      	/** ID Generation Service */
      	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
      	//String id = egovIdGnrService.getNextStringId();
      	//vo.setId(id);
      //	LOGGER.debug(vo.toString());
    	                                  
    	  return infcPkgYe161040DAO.fnYeta7100_YE161040_2022_INSU_FETC_Update(infcPkgYe161040Vo);
		// TODO 해당 테이블 정보에 맞게 수정
		 
	} 

	
	public int fnYeta7100_YE161030_2022_CREATE_Update(InfcPkgYe161030_2022_VO infcPkgYe161030Vo) throws Exception {
      	//LOGGER.debug(vo.toString()); 
      	/** ID Generation Service */
      	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
      	//String id = egovIdGnrService.getNextStringId();
      	//vo.setId(id);
      //	LOGGER.debug(vo.toString());
    	                                  
    	  return infcPkgYe161030DAO.fnYeta7100_YE161030_2022_CREATE_Update(infcPkgYe161030Vo);
		// TODO 해당 테이블 정보에 맞게 수정
		 
	} 
	
	

	public String fnYeta7100_YE165030_TEMP_2022_CREATE_Insert(InfcPkgYe165030Temp_2022_VO infcPkgYe165030TempVo) throws Exception {
      	//LOGGER.debug(vo.toString());
    	  String dataCheck = "";
      	/** ID Generation Service */
      	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
      	//String id = egovIdGnrService.getNextStringId();
      	//vo.setId(id);
      //	LOGGER.debug(vo.toString());
    	                                  
    	  dataCheck = infcPkgYe165030TempDAO.fnYeta7100_YE165030_TEMP_2022_CREATE_Insert(infcPkgYe165030TempVo);
		// TODO 해당 테이블 정보에 맞게 수정
		return dataCheck;
	} 

	public String fnYeta7100_YE165030TempYE165030_2022_CREATE_Insert(InfcPkgYe165030_2022_VO infcPkgYe165030Vo) throws Exception {
      	//LOGGER.debug(vo.toString());
    	  String dataCheck = "";
      	/** ID Generation Service */
      	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
      	//String id = egovIdGnrService.getNextStringId();
      	//vo.setId(id);
      //	LOGGER.debug(vo.toString());
    	                                  
    	  dataCheck = infcPkgYe165030DAO.fnYeta7100_YE165030TempYE165030_2022_CREATE_Insert(infcPkgYe165030Vo);
		// TODO 해당 테이블 정보에 맞게 수정
		return dataCheck;
	} 
	  
	
	public String fnYeta7100_YE161070_2022_CREATE_Insert(InfcPkgYe161070_2022_VO infcPkgYe161070Vo) throws Exception {
      	//LOGGER.debug(vo.toString());
    	  String dataCheck = "";
      	/** ID Generation Service */
      	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
      	//String id = egovIdGnrService.getNextStringId();
      	//vo.setId(id);
      //	LOGGER.debug(vo.toString());
    	                                  
    	  dataCheck = infcPkgYe161070DAO.fnYeta7100_YE161070_2022_CREATE_Insert(infcPkgYe161070Vo);
		// TODO 해당 테이블 정보에 맞게 수정
		return dataCheck;
	} 
	
	
	
	public String fnYeta7100_YE161080_2022_CREATE_Insert(InfcPkgYe161080_2022_VO infcPkgYe161080Vo) throws Exception {
      	//LOGGER.debug(vo.toString());
    	  String dataCheck = "";
      	/** ID Generation Service */
      	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
      	//String id = egovIdGnrService.getNextStringId();
      	//vo.setId(id);
      //	LOGGER.debug(vo.toString());
    	                                  
    	  dataCheck = infcPkgYe161080DAO.fnYeta7100_YE161080_2022_CREATE_Insert(infcPkgYe161080Vo);
		// TODO 해당 테이블 정보에 맞게 수정
		return dataCheck;
	} 
	
	public String fnYeta7100_YE161080_2022_CREATE_Update_AS(InfcPkgYe161080_2022_VO infcPkgYe161080Vo) throws Exception {
      	//LOGGER.debug(vo.toString());
    	  String dataCheck = "";
      	/** ID Generation Service */
      	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
      	//String id = egovIdGnrService.getNextStringId();
      	//vo.setId(id);
      //	LOGGER.debug(vo.toString());
    	                                  
    	  dataCheck = infcPkgYe161080DAO.fnYeta7100_YE161080_2022_CREATE_Update_AS(infcPkgYe161080Vo);
		// TODO 해당 테이블 정보에 맞게 수정
		return dataCheck;
	} 
	 
	public String fnYeta7100_YE169010a_2022_CREATE_Insert(InfcPkgYe169010a_2022_VO infcPkgYe169010AVo) throws Exception {
	//LOGGER.debug(vo.toString());
  String dataCheck = "";
	/** ID Generation Service */
	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
	//String id = egovIdGnrService.getNextStringId();
	//vo.setId(id);
//	LOGGER.debug(vo.toString());
                                  
  dataCheck = infcPkgYe169010aDAO.fnYeta7100_YE169010a_2022_CREATE_Insert(infcPkgYe169010AVo);
// TODO 해당 테이블 정보에 맞게 수정
return dataCheck;
} 
	
	
	// 급여 노조회비 기부금 반영 처리 부
	public String fnYeta7100_YE165010_2022_PAYR_CREATE(InfcPkgYe165010_2022_VO infcPkgYe165010Vo) throws Exception {
      	//LOGGER.debug(vo.toString());
    	  String dataCheck = "";
      	/** ID Generation Service */
      	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	  infcPkgYe165010DAO.fnYeta7100_YE165010_2022_PAYR_CREATE_DELETE(infcPkgYe165010Vo);                   
    	  dataCheck = infcPkgYe165010DAO.fnYeta7100_YE165010_2022_PAYR_CREATE_INSERT(infcPkgYe165010Vo);
    	  
		return dataCheck;
	} 
	
	 
	 /**!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	  * 단위사업장 맵핑정보 가져오기 
	  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/

	  
    public HashMap selectBass0360SearchList(InfcPkgYe161010Srh_2022_VO infcPkgYe161010SrhVo) throws Exception {
        return infcPkgYe161010DAO.selectBass0360SearchList(infcPkgYe161010SrhVo);
    }	
    
    
    public HashMap selectBass0500SearchList(InfcPkgYe161010Srh_2022_VO infcPkgYe161010SrhVo) throws Exception {
        return infcPkgYe161010DAO.selectBass0500SearchList(infcPkgYe161010SrhVo);
    }	
    
    public void fnYeta7100_YE161010_UtDpobCd_2022_Update(InfcPkgYe161010_2022_VO infcPkgYe161010Vo) throws Exception {
          infcPkgYe161010DAO.fnYeta7100_YE161010_UtDpobCd_2022_Update(  infcPkgYe161010Vo);
    }

 
	
   /***********************************************************************************
    * 2022년귀속 연말정산 처리를 위한 함수 처리 부 종료
	***********************************************************************************/
	
	 
    
}
