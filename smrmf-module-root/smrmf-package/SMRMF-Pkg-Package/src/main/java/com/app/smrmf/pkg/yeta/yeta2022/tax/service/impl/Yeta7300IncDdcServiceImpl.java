package com.app.smrmf.pkg.yeta.yeta2022.tax.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao.InfcPkgYe160401DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao.InfcPkgYe160402DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao.InfcPkgYe160403DAO;
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
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161030_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161040_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161050_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161055_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161060_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161070_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161080_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe165020_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe165030_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe166010_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe166020_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe169010_2022_VO;
import com.app.smrmf.pkg.yeta.yeta2022.tax.service.Yeta7300IncDdcService;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

/**
 * @Class Name : Yeta7900ServiceImpl.java
 * @Description : Yeta7900 Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2016.01.18
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("Yeta7300IncDdcService")
public class Yeta7300IncDdcServiceImpl extends AbstractServiceImpl  implements Yeta7300IncDdcService  {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(Yeta7300IncDdcServiceImpl.class);

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
	private InfcPkgYe166020_2022_DAO  infcPkgYe166020DAO;//신용카드등소득공제상세
		 
	@Autowired
	@Resource(name = "InfcPkgYe169010_2022_DAO")
	private InfcPkgYe169010_2022_DAO infcPkgYe169010DAO; //C_주현근무처
	@Autowired
	@Resource(name = "InfcPkgYe169010a_2022_DAO")
	private InfcPkgYe169010a_2022_DAO infcPkgYe169010aDAO; //C_주현근무처_표준공제 
	
	
	public int incDdcYeta2022_B101Y_YE161040_Update(InfcPkgYe161040_2022_VO ye161040VO) throws Exception {
		 
		return infcPkgYe161040DAO.incDdcYeta2022_B101Y_YE161040_Update(ye161040VO);
			 
	} 
	
	// 의료비정리 합계
		public int incDdcYeta2022_YE161080_2022_Update(InfcPkgYe161080_2022_VO infcPkgYe161080Vo) throws Exception {
			 
			return infcPkgYe161080DAO.incDdcYeta2022_YE161080_2022_Update(infcPkgYe161080Vo);
				 
		} 
		
		public int incDdcYeta2022_C101Y_YE161040_Update(InfcPkgYe161040_2022_VO ye161040VO) throws Exception {
			 
			return infcPkgYe161040DAO.incDdcYeta2022_C101Y_YE161040_Update(ye161040VO);
				 
		} 
			

		public int incDdcYeta2022_C101Y_YE161080_2022_Update(InfcPkgYe161080_2022_VO infcPkgYe161080Vo) throws Exception {
			 
			return infcPkgYe161080DAO.incDdcYeta2022_C101Y_YE161080_2022_Update(infcPkgYe161080Vo);
				 
		} 	
		
		 //
		public int incDdcYeta2022_L102Y_YE165020_Delete(InfcPkgYe165020_2022_VO infcPkgYe165020Vo) throws Exception {
			 
			return infcPkgYe165020DAO.incDdcYeta2022_L102Y_YE165020_Delete(infcPkgYe165020Vo);
				 
		} 
		
		
		public String incDdcYeta2022_L102Y_YE165020_Insert(InfcPkgYe165020_2022_VO infcPkgYe165020Vo) throws Exception {
			 
			return infcPkgYe165020DAO.incDdcYeta2022_L102Y_YE165020_Insert(infcPkgYe165020Vo);
				 
		}
		
		
		public int incDdcYeta2022_L102Y_YE165030_Delete(InfcPkgYe165030_2022_VO infcPkgYe165030Vo) throws Exception {
			 
			return infcPkgYe165030DAO.incDdcYeta2022_L102Y_YE165030_Delete(infcPkgYe165030Vo);
				 
		} 
		
		
		public String incDdcYeta2022_L102Y_YE165030_Insert(InfcPkgYe165030_2022_VO infcPkgYe165030Vo) throws Exception {
			 
			return infcPkgYe165030DAO.incDdcYeta2022_L102Y_YE165030_Insert(infcPkgYe165030Vo);
				 
		} 
		
		
		public int incDdcYeta2022_L102Y_YE161080_2022_Update(InfcPkgYe161080_2022_VO infcPkgYe161080Vo) throws Exception {
			 
			return infcPkgYe161080DAO.incDdcYeta2022_L102Y_YE161080_2022_Update(infcPkgYe161080Vo);
				 
		} 
		
		public int incDdcYeta2022_L102Y_YE161040_2022_Update(InfcPkgYe161040_2022_VO infcPkgYe161040Vo) throws Exception {
			 
			return infcPkgYe161040DAO.incDdcYeta2022_L102Y_YE161040_2022_Update(infcPkgYe161040Vo);
				 
		} 
		 
		public int incDdcYeta2022_L102Y_YE161060_2022_Update(InfcPkgYe161060_2022_VO infcPkgYe161060Vo) throws Exception {
			 
			return infcPkgYe161060DAO.incDdcYeta2022_L102Y_YE161060_2022_Update(infcPkgYe161060Vo);
				 
		}   
		
		public int incDdcYeta2022_D101Y_YE161070_2022_Update(InfcPkgYe161070_2022_VO infcPkgYe161070Vo) throws Exception {
			 
			return infcPkgYe161070DAO.incDdcYeta2022_D101Y_YE161070_2022_Update(infcPkgYe161070Vo);
				 
		} 	
		
		public int incDdcYeta2022_E102Y_YE161080_2022_Update(InfcPkgYe161080_2022_VO infcPkgYe161080Vo) throws Exception {
			 
			return infcPkgYe161080DAO.incDdcYeta2022_E102Y_YE161080_2022_Update(infcPkgYe161080Vo);
				 
		} 
		

		public int incDdcYeta2022_F102Y_YE161080_2022_Update(InfcPkgYe161080_2022_VO infcPkgYe161080Vo) throws Exception {
			 
			return infcPkgYe161080DAO.incDdcYeta2022_F102Y_YE161080_2022_Update(infcPkgYe161080Vo);
				 
		} 
		
		
		public int incDdcYeta2022_YE161055_2022_Update(InfcPkgYe161050_2022_VO infcPkgYe161050Vo) throws Exception {
			 
			return infcPkgYe161050DAO.fnYeta7200_P102M_YE161050_2022_Update(infcPkgYe161050Vo);
				 
		}
		
		
		public int delete_YETA2300_2022_Ye161055(InfcPkgYe161055_2022_VO infcPkgYe161055Vo) throws Exception {
			 
			return infcPkgYe161055DAO.delete_YETA2300_2022_Ye161055(infcPkgYe161055Vo);
				 
		} 
		
		
		public String insert_YETA2300_2022_Ye161055(InfcPkgYe161055_2022_VO infcPkgYe161055Vo) throws Exception {
			 
			return infcPkgYe161055DAO.insert_YETA2300_2022_Ye161055(infcPkgYe161055Vo);
				 
		}  
		
		
		public int incDdcYeta2022_YE161050_2022_Update(InfcPkgYe161050_2022_VO infcPkgYe161050Vo) throws Exception {
			 
			return infcPkgYe161050DAO.fnYeta7300_Ye161050_PAYR_2022_CREATE_Insert(infcPkgYe161050Vo);
				 
		} 
		

		public int incDdcYeta2022_J301Y_YE161070_2022_Update(InfcPkgYe161070_2022_VO infcPkgYe161070Vo) throws Exception {
			 
			return infcPkgYe161070DAO.incDdcYeta2022_J301Y_YE161070_2022_Update(infcPkgYe161070Vo);
				 
		} 
		
		public int incDdcYeta2022_N101Y_YE161070_2022_Update(InfcPkgYe161070_2022_VO infcPkgYe161070Vo) throws Exception {
			 
			return infcPkgYe161070DAO.incDdcYeta2022_N101Y_YE161070_2022_Update(infcPkgYe161070Vo);
				 
		} 
		
		public int incDdcYeta2022_G107Y_YE166020_Update(InfcPkgYe166020_2022_VO infcPkgYe166020Vo) throws Exception {
			 
			return infcPkgYe166020DAO.incDdcYeta2022_G107Y_YE166020_Update(infcPkgYe166020Vo);
				 
		} 	
		
		public int incDdcYeta2022_G107Y_YE161070_2022_Update(InfcPkgYe161070_2022_VO infcPkgYe161070Vo) throws Exception {
			 
			return infcPkgYe161070DAO.incDdcYeta2022_G107Y_YE161070_2022_Update(infcPkgYe161070Vo);
				 
		} 	
		
		public int incDdcYeta2022_G207Y_YE161070_2022_Update(InfcPkgYe161070_2022_VO infcPkgYe161070Vo) throws Exception {
			 
			return infcPkgYe161070DAO.incDdcYeta2022_G207Y_YE161070_2022_Update(infcPkgYe161070Vo);
				 
		} 
		 	
		public int incDdcYeta2022_G307Y_YE161070_2022_Update(InfcPkgYe161070_2022_VO infcPkgYe161070Vo) throws Exception {
			 
			return infcPkgYe161070DAO.incDdcYeta2022_G307Y_YE161070_2022_Update(infcPkgYe161070Vo);
				 
		} 
		
		//제로페이
		public int incDdcYeta2022_G407Y_YE161070_2022_Update(InfcPkgYe161070_2022_VO infcPkgYe161070Vo) throws Exception {
			 
			return infcPkgYe161070DAO.incDdcYeta2022_G407Y_YE161070_2022_Update(infcPkgYe161070Vo);
				 
		} 
		
		public int incDdcYeta2022_G107Y_YE166020_Delete(InfcPkgYe166020_2022_VO infcPkgYe166020Vo) throws Exception {
			 
			return infcPkgYe166020DAO.incDdcYeta2022_G107Y_YE166020_Delete(infcPkgYe166020Vo);
				 
		} 
		
		public int incDdcYeta2022_YE166020_2022_CREATE_Delete(InfcPkgYe166020_2022_VO infcPkgYe166020Vo) throws Exception {
			 
			return infcPkgYe166020DAO.incDdcYeta2022_YE166020_2022_CREATE_Delete(infcPkgYe166020Vo);
				 
		} 
		
		
		public int incDdcYeta2022_YE166010_2022_CREATE_Delete(InfcPkgYe166010_2022_VO infcPkgYe166010Vo) throws Exception {
			 
			return infcPkgYe166010DAO.incDdcYeta2022_YE166010_2022_CREATE_Delete(infcPkgYe166010Vo);
				 
		} 	
		
		public String incDdcYeta2022_YE166020_2022_CREATE_Insert(InfcPkgYe166020_2022_VO infcPkgYe166020Vo) throws Exception {
	      	//LOGGER.debug(vo.toString());
	    	  String dataCheck = ""; 
	    	                                  
	    	  dataCheck = infcPkgYe166020DAO.incDdcYeta2022_YE166020_2022_CREATE_Insert01(infcPkgYe166020Vo);
			
	    	  dataCheck = infcPkgYe166020DAO.incDdcYeta2022_YE166020_2022_CREATE_Insert02(infcPkgYe166020Vo);
	  		
	    	  // TODO 해당 테이블 정보에 맞게 수정
			return dataCheck;
		} 
		
		public String incDdcYeta2022_YE166010_2022_CREATE_Insert(InfcPkgYe166010_2022_VO infcPkgYe166010Vo) throws Exception {
	      	 
	    	  String dataCheck = ""; 
	    	                                  
	    	  dataCheck = infcPkgYe166010DAO.incDdcYeta2022_YE166010_2022_CREATE_Insert( infcPkgYe166010Vo);
			// TODO 해당 테이블 정보에 맞게 수정
			return dataCheck;
		} 
		
		public int incDdcYeta2022_A102Y_YE161080_2022_Update(InfcPkgYe161080_2022_VO infcPkgYe161080Vo) throws Exception {
			 
			return infcPkgYe161080DAO.incDdcYeta2022_A102Y_YE161080_2022_Update(infcPkgYe161080Vo);
				 
		} 
		
		public int incDdcYeta2022_YE161040_2022_INSU_FETC_Update(InfcPkgYe161040_2022_VO infcPkgYe161040Vo) throws Exception {
	       
	    	                                  
	    	  return infcPkgYe161040DAO.incDdcYeta2022_YE161040_2022_INSU_FETC_Update(infcPkgYe161040Vo);
			// TODO 해당 테이블 정보에 맞게 수정
			 
		} 
		
		public int incDdcYeta2022_YE161040_2022_INSU_FETC01_Update(InfcPkgYe161060_2022_VO infcPkgYe161060Vo) throws Exception {
            
	    	  return infcPkgYe161060DAO.incDdcYeta2022_YE161040_2022_INSU_FETC01_Update(infcPkgYe161060Vo);
			// TODO 해당 테이블 정보에 맞게 수정
			 
		} 
		
		
		public int incDdcYeta2022_All_YE161060_2022_Update(InfcPkgYe161060_2022_VO infcPkgYe161060Vo) throws Exception {
		       
            
	    	  return infcPkgYe161060DAO.incDdcYeta2022_All_YE161060_2022_Update(infcPkgYe161060Vo);
			// TODO 해당 테이블 정보에 맞게 수정
			 
		} 
		public int incDdcYeta2022_All_YE161070_2022_Update(InfcPkgYe161070_2022_VO infcPkgYe161070Vo) throws Exception {
		       
            
	    	  return infcPkgYe161070DAO.incDdcYeta2022_All_YE161070_2022_Update(infcPkgYe161070Vo);
			// TODO 해당 테이블 정보에 맞게 수정
			 
		} 
		public int incDdcYeta2022_All_YE161080_2022_Update(InfcPkgYe161080_2022_VO infcPkgYe161080Vo) throws Exception {
		       
            
	    	  return infcPkgYe161080DAO.incDdcYeta2022_All_YE161080_2022_Update(infcPkgYe161080Vo);
			// TODO 해당 테이블 정보에 맞게 수정
			 
		}
 
		
		public int incDdcYeta7100_YE161030_2022_CREATE_Update(InfcPkgYe161030_2022_VO infcPkgYe161030Vo) throws Exception {
	      	//LOGGER.debug(vo.toString()); 
	      	/** ID Generation Service */
	      	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
	      	//String id = egovIdGnrService.getNextStringId();
	      	//vo.setId(id);
	      //	LOGGER.debug(vo.toString());
	    	                                  
	    	  return infcPkgYe161030DAO.fnYeta7100_YE161030_2022_CREATE_Update(infcPkgYe161030Vo);
			// TODO 해당 테이블 정보에 맞게 수정
			 
		} 
		
		public int incDdcYeta7300_YE169010_Tax_2022_06_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception {
	    
	    	                                  
	    	  return infcPkgYe169010DAO.fnYeta7300_YE169010_Tax_gun_Update(infcPkgYe169010Vo);
			// TODO 해당 테이블 정보에 맞게 수정
			 
		}

		@Override
		public int delete_YETA3300_2022_Ye161055(
				InfcPkgYe161055_2022_VO infcPkgYe161055Vo) throws Exception {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public String insert_YETA3300_2022_Ye161055(
				InfcPkgYe161055_2022_VO infcPkgYe161055Vo) throws Exception {
			// TODO Auto-generated method stub
			return null;
		} 
} 
