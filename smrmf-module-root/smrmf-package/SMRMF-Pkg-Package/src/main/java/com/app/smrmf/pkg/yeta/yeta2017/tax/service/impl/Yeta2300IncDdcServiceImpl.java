package com.app.smrmf.pkg.yeta.yeta2017.tax.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao.InfcPkgYe160401DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao.InfcPkgYe160402DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao.InfcPkgYe160403DAO;
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
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161030VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161040VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161050VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161055VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161060VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161070VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161080VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe165020VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe165030VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe166010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe166020VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe169010VO;
import com.app.smrmf.pkg.yeta.yeta2017.tax.service.Yeta2300IncDdcService;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

/**
 * @Class Name : Yeta3900ServiceImpl.java
 * @Description : Yeta3900 Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2016.01.18
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("Yeta2300IncDdcService")
public class Yeta2300IncDdcServiceImpl extends AbstractServiceImpl  implements Yeta2300IncDdcService  {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(Yeta2300IncDdcServiceImpl.class);

    /***************************************
	 * 연말정산 테이블  dao
	 ***************************************/
	@Autowired
	@Resource(name = "InfcPkgYe160401DAO")
	private InfcPkgYe160401DAO infcPkgYe160401DAO; //현근무지급여지급명세
	@Autowired
	@Resource(name = "InfcPkgYe160402DAO")
	private InfcPkgYe160402DAO  infcPkgYe160402DAO;//현근무지비과세_감면소득_과세
	@Autowired
	@Resource(name = "InfcPkgYe160403DAO")
	private InfcPkgYe160403DAO  infcPkgYe160403DAO;//현근무지비과세_감면소득_비과세
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
	private InfcPkgYe166020DAO  infcPkgYe166020DAO;//신용카드등소득공제상세
		 
	@Autowired
	@Resource(name = "InfcPkgYe169010DAO")
	private InfcPkgYe169010DAO infcPkgYe169010DAO; //C_주현근무처
	@Autowired
	@Resource(name = "InfcPkgYe169010aDAO")
	private InfcPkgYe169010aDAO infcPkgYe169010aDAO; //C_주현근무처_표준공제 
	
	
	public int incDdcYeta2017_B101Y_YE161040_Update(InfcPkgYe161040VO ye161040VO) throws Exception {
		 
		return infcPkgYe161040DAO.incDdcYeta2017_B101Y_YE161040_Update(ye161040VO);
			 
	} 
	
	// 의료비정리 합계
		public int incDdcYeta2017_YE161080_2017_Update(InfcPkgYe161080VO infcPkgYe161080Vo) throws Exception {
			 
			return infcPkgYe161080DAO.incDdcYeta2017_YE161080_2017_Update(infcPkgYe161080Vo);
				 
		} 
		
		public int incDdcYeta2017_C101Y_YE161040_Update(InfcPkgYe161040VO ye161040VO) throws Exception {
			 
			return infcPkgYe161040DAO.incDdcYeta2017_C101Y_YE161040_Update(ye161040VO);
				 
		} 
			

		public int incDdcYeta2017_C101Y_YE161080_2017_Update(InfcPkgYe161080VO infcPkgYe161080Vo) throws Exception {
			 
			return infcPkgYe161080DAO.incDdcYeta2017_C101Y_YE161080_2017_Update(infcPkgYe161080Vo);
				 
		} 	
		
		 //
		public int incDdcYeta2017_L102Y_YE165020_Delete(InfcPkgYe165020VO infcPkgYe165020Vo) throws Exception {
			 
			return infcPkgYe165020DAO.incDdcYeta2017_L102Y_YE165020_Delete(infcPkgYe165020Vo);
				 
		} 
		
		
		public String incDdcYeta2017_L102Y_YE165020_Insert(InfcPkgYe165020VO infcPkgYe165020Vo) throws Exception {
			 
			return infcPkgYe165020DAO.incDdcYeta2017_L102Y_YE165020_Insert(infcPkgYe165020Vo);
				 
		}
		
		
		public int incDdcYeta2017_L102Y_YE165030_Delete(InfcPkgYe165030VO infcPkgYe165030Vo) throws Exception {
			 
			return infcPkgYe165030DAO.incDdcYeta2017_L102Y_YE165030_Delete(infcPkgYe165030Vo);
				 
		} 
		
		
		public String incDdcYeta2017_L102Y_YE165030_Insert(InfcPkgYe165030VO infcPkgYe165030Vo) throws Exception {
			 
			return infcPkgYe165030DAO.incDdcYeta2017_L102Y_YE165030_Insert(infcPkgYe165030Vo);
				 
		} 
		
		
		public int incDdcYeta2017_L102Y_YE161080_2017_Update(InfcPkgYe161080VO infcPkgYe161080Vo) throws Exception {
			 
			return infcPkgYe161080DAO.incDdcYeta2017_L102Y_YE161080_2017_Update(infcPkgYe161080Vo);
				 
		} 
		
		public int incDdcYeta2017_L102Y_YE161040_2017_Update(InfcPkgYe161040VO infcPkgYe161040Vo) throws Exception {
			 
			return infcPkgYe161040DAO.incDdcYeta2017_L102Y_YE161040_2017_Update(infcPkgYe161040Vo);
				 
		} 
		 
		public int incDdcYeta2017_L102Y_YE161060_2017_Update(InfcPkgYe161060VO infcPkgYe161060Vo) throws Exception {
			 
			return infcPkgYe161060DAO.incDdcYeta2017_L102Y_YE161060_2017_Update(infcPkgYe161060Vo);
				 
		}   
		
		public int incDdcYeta2017_D101Y_YE161070_2017_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception {
			 
			return infcPkgYe161070DAO.incDdcYeta2017_D101Y_YE161070_2017_Update(infcPkgYe161070Vo);
				 
		} 	
		
		public int incDdcYeta2017_E102Y_YE161080_2017_Update(InfcPkgYe161080VO infcPkgYe161080Vo) throws Exception {
			 
			return infcPkgYe161080DAO.incDdcYeta2017_E102Y_YE161080_2017_Update(infcPkgYe161080Vo);
				 
		} 
		

		public int incDdcYeta2017_F102Y_YE161080_2017_Update(InfcPkgYe161080VO infcPkgYe161080Vo) throws Exception {
			 
			return infcPkgYe161080DAO.incDdcYeta2017_F102Y_YE161080_2017_Update(infcPkgYe161080Vo);
				 
		} 
		
		
		public int incDdcYeta2017_YE161055_2017_Update(InfcPkgYe161050VO infcPkgYe161050Vo) throws Exception {
			 
			return infcPkgYe161050DAO.fnYeta2200_P102M_YE161050_2017_Update(infcPkgYe161050Vo);
				 
		}
		
		
		public int delete_YETA2300_2017_Ye161055(InfcPkgYe161055VO infcPkgYe161055Vo) throws Exception {
			 
			return infcPkgYe161055DAO.delete_YETA2300_2017_Ye161055(infcPkgYe161055Vo);
				 
		} 
		
		
		public String insert_YETA2300_2017_Ye161055(InfcPkgYe161055VO infcPkgYe161055Vo) throws Exception {
			 
			return infcPkgYe161055DAO.insert_YETA2300_2017_Ye161055(infcPkgYe161055Vo);
				 
		}  
		
		
		public int incDdcYeta2017_YE161050_2017_Update(InfcPkgYe161050VO infcPkgYe161050Vo) throws Exception {
			 
			return infcPkgYe161050DAO.fnYeta2300_Ye161050_PAYR_2017_CREATE_Insert(infcPkgYe161050Vo);
				 
		} 
		

		public int incDdcYeta2017_J301Y_YE161070_2017_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception {
			 
			return infcPkgYe161070DAO.incDdcYeta2017_J301Y_YE161070_2017_Update(infcPkgYe161070Vo);
				 
		} 
		
		public int incDdcYeta2017_N101Y_YE161070_2017_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception {
			 
			return infcPkgYe161070DAO.incDdcYeta2017_N101Y_YE161070_2017_Update(infcPkgYe161070Vo);
				 
		} 
		
		public int incDdcYeta2017_G106Y_YE166020_Update(InfcPkgYe166020VO infcPkgYe166020Vo) throws Exception {
			 
			return infcPkgYe166020DAO.incDdcYeta2017_G106Y_YE166020_Update(infcPkgYe166020Vo);
				 
		} 	
		
		public int incDdcYeta2017_G106Y_YE161070_2017_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception {
			 
			return infcPkgYe161070DAO.incDdcYeta2017_G106Y_YE161070_2017_Update(infcPkgYe161070Vo);
				 
		} 	
		
		public int incDdcYeta2017_G206Y_YE161070_2017_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception {
			 
			return infcPkgYe161070DAO.incDdcYeta2017_G206Y_YE161070_2017_Update(infcPkgYe161070Vo);
				 
		} 
		 	
		public int incDdcYeta2017_G306Y_YE161070_2017_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception {
			 
			return infcPkgYe161070DAO.incDdcYeta2017_G306Y_YE161070_2017_Update(infcPkgYe161070Vo);
				 
		} 
		
		public int incDdcYeta2017_G106Y_YE166020_Delete(InfcPkgYe166020VO infcPkgYe166020Vo) throws Exception {
			 
			return infcPkgYe166020DAO.incDdcYeta2017_G106Y_YE166020_Delete(infcPkgYe166020Vo);
				 
		} 
		
		public int incDdcYeta2017_YE166020_2017_CREATE_Delete(InfcPkgYe166020VO infcPkgYe166020Vo) throws Exception {
			 
			return infcPkgYe166020DAO.incDdcYeta2017_YE166020_2017_CREATE_Delete(infcPkgYe166020Vo);
				 
		} 
		
		
		public int incDdcYeta2017_YE166010_2017_CREATE_Delete(InfcPkgYe166010VO infcPkgYe166010Vo) throws Exception {
			 
			return infcPkgYe166010DAO.incDdcYeta2017_YE166010_2017_CREATE_Delete(infcPkgYe166010Vo);
				 
		} 	
		
		public String incDdcYeta2017_YE166020_2017_CREATE_Insert(InfcPkgYe166020VO infcPkgYe166020Vo) throws Exception {
	      	//LOGGER.debug(vo.toString());
	    	  String dataCheck = ""; 
	    	                                  
	    	  dataCheck = infcPkgYe166020DAO.incDdcYeta2017_YE166020_2017_CREATE_Insert01(infcPkgYe166020Vo);
			
	    	  dataCheck = infcPkgYe166020DAO.incDdcYeta2017_YE166020_2017_CREATE_Insert02(infcPkgYe166020Vo);
	  		
	    	  // TODO 해당 테이블 정보에 맞게 수정
			return dataCheck;
		} 
		
		public String incDdcYeta2017_YE166010_2017_CREATE_Insert(InfcPkgYe166010VO infcPkgYe166010Vo) throws Exception {
	      	 
	    	  String dataCheck = ""; 
	    	                                  
	    	  dataCheck = infcPkgYe166010DAO.incDdcYeta2017_YE166010_2017_CREATE_Insert( infcPkgYe166010Vo);
			// TODO 해당 테이블 정보에 맞게 수정
			return dataCheck;
		} 
		
		public int incDdcYeta2017_A102Y_YE161080_2017_Update(InfcPkgYe161080VO infcPkgYe161080Vo) throws Exception {
			 
			return infcPkgYe161080DAO.incDdcYeta2017_A102Y_YE161080_2017_Update(infcPkgYe161080Vo);
				 
		} 
		
		public int incDdcYeta2017_YE161040_2017_INSU_FETC_Update(InfcPkgYe161040VO infcPkgYe161040Vo) throws Exception {
	       
	    	                                  
	    	  return infcPkgYe161040DAO.incDdcYeta2017_YE161040_2017_INSU_FETC_Update(infcPkgYe161040Vo);
			// TODO 해당 테이블 정보에 맞게 수정
			 
		} 
		
		public int incDdcYeta2017_YE161040_2017_INSU_FETC01_Update(InfcPkgYe161060VO infcPkgYe161060Vo) throws Exception {
		       
            
	    	  return infcPkgYe161060DAO.incDdcYeta2017_YE161040_2017_INSU_FETC01_Update(infcPkgYe161060Vo);
			// TODO 해당 테이블 정보에 맞게 수정
			 
		} 
		
		
		public int incDdcYeta2017_All_YE161060_2017_Update(InfcPkgYe161060VO infcPkgYe161060Vo) throws Exception {
		       
            
	    	  return infcPkgYe161060DAO.incDdcYeta2017_All_YE161060_2017_Update(infcPkgYe161060Vo);
			// TODO 해당 테이블 정보에 맞게 수정
			 
		} 
		public int incDdcYeta2017_All_YE161070_2017_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception {
		       
            
	    	  return infcPkgYe161070DAO.incDdcYeta2017_All_YE161070_2017_Update(infcPkgYe161070Vo);
			// TODO 해당 테이블 정보에 맞게 수정
			 
		} 
		public int incDdcYeta2017_All_YE161080_2017_Update(InfcPkgYe161080VO infcPkgYe161080Vo) throws Exception {
		       
            
	    	  return infcPkgYe161080DAO.incDdcYeta2017_All_YE161080_2017_Update(infcPkgYe161080Vo);
			// TODO 해당 테이블 정보에 맞게 수정
			 
		}
 
		
		public int incDdcYeta2100_YE161030_2017_CREATE_Update(InfcPkgYe161030VO infcPkgYe161030Vo) throws Exception {
	      	//LOGGER.debug(vo.toString()); 
	      	/** ID Generation Service */
	      	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
	      	//String id = egovIdGnrService.getNextStringId();
	      	//vo.setId(id);
	      //	LOGGER.debug(vo.toString());
	    	                                  
	    	  return infcPkgYe161030DAO.fnYeta2100_YE161030_2017_CREATE_Update(infcPkgYe161030Vo);
			// TODO 해당 테이블 정보에 맞게 수정
			 
		} 
		
		public int incDdcYeta2300_YE169010_Tax_2017_06_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	    
	    	                                  
	    	  return infcPkgYe169010DAO.fnYeta2300_YE169010_Tax_gun_Update(infcPkgYe169010Vo);
			// TODO 해당 테이블 정보에 맞게 수정
			 
		} 
} 
