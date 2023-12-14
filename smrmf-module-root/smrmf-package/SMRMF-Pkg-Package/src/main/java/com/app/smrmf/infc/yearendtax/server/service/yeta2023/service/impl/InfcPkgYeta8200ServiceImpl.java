package com.app.smrmf.infc.yearendtax.server.service.yeta2023.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao.InfcPkgYe160401DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao.InfcPkgYe160402DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao.InfcPkgYe160403DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao.InfcPkgYe160404_2023_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao.InfcPkgYe160405_2023_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao.InfcPkgYe160406_2023_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao.InfcPkgYe160510_2023_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao.InfcPkgYe161005_2023_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao.InfcPkgYe161010_2023_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao.InfcPkgYe161020_2023_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao.InfcPkgYe161030_2023_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao.InfcPkgYe161040_2023_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao.InfcPkgYe161050_2023_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao.InfcPkgYe161055_2023_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao.InfcPkgYe161060_2023_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao.InfcPkgYe161070_2023_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao.InfcPkgYe161080_2023_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao.InfcPkgYe161090_2023_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao.InfcPkgYe162010_2023_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao.InfcPkgYe162020_2023_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao.InfcPkgYe162030_2023_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao.InfcPkgYe162040_2023_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao.InfcPkgYe162510_2023_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao.InfcPkgYe162520_2023_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao.InfcPkgYe162530_2023_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao.InfcPkgYe164010_2023_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao.InfcPkgYe165010_2023_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao.InfcPkgYe165020_2023_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao.InfcPkgYe165030_2023_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao.InfcPkgYe165030Temp_2023_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao.InfcPkgYe166010_2023_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao.InfcPkgYe166020_2023_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao.InfcPkgYe169010_2023_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao.InfcPkgYe169010a_2023_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2023.service.InfcPkgYeta8200Service;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161010_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161020_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161030_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161040_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161050_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161055_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161060_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161070_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161080_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe162010_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe162020_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe162030_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe162040_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe162510_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe162520_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe162530_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe164010_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe165010_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe165020_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe165030_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe166010_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe166020_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe169010_2023_VO;
import com.app.smrmf.pkg.yeta.yeta2023.pdfxml.service.impl.Yeta8200XmlServiceImpl;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("InfcPkgYeta8200Service")
public class InfcPkgYeta8200ServiceImpl extends AbstractServiceImpl implements InfcPkgYeta8200Service{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Yeta8200XmlServiceImpl.class);

 
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
	@Resource(name = "InfcPkgYe160404_2023_DAO")
	private InfcPkgYe160404_2023_DAO  infcPkgYe160404DAO;//D_종전근무처
	@Autowired
	@Resource(name = "InfcPkgYe160405_2023_DAO")
	private InfcPkgYe160405_2023_DAO  infcPkgYe160405DAO;//D_종전근무처비과세_감면소득_비과세
	@Autowired
	@Resource(name = "InfcPkgYe160406_2023_DAO")
	private InfcPkgYe160406_2023_DAO  infcPkgYe160406DAO;//종전근무지연금보험료_공적연금
	@Autowired
	@Resource(name = "InfcPkgYe160510_2023_DAO")
	private InfcPkgYe160510_2023_DAO  infcPkgYe160510DAO;//근무지별비과세_감면소득
	            
	@Autowired
	@Resource(name = "InfcPkgYe161005_2023_DAO")
	private InfcPkgYe161005_2023_DAO  infcPkgYe161005DAO;//A_원천세신고기본
	            
	@Autowired
	@Resource(name = "InfcPkgYe161010_2023_DAO")
	private InfcPkgYe161010_2023_DAO  infcPkgYe161010DAO;// 연말정산대상자기본
	@Autowired
	@Resource(name = "InfcPkgYe161020_2023_DAO")
	private InfcPkgYe161020_2023_DAO  infcPkgYe161020DAO;//A_인적소득공제기본
	@Autowired
	@Resource(name = "InfcPkgYe161030_2023_DAO")
	private InfcPkgYe161030_2023_DAO  infcPkgYe161030DAO;//E_인적공제명세
	@Autowired
	@Resource(name = "InfcPkgYe161040_2023_DAO")
	private InfcPkgYe161040_2023_DAO  infcPkgYe161040DAO;//E_소득세액공제명세
	@Autowired
	@Resource(name = "InfcPkgYe161050_2023_DAO")
	private InfcPkgYe161050_2023_DAO  infcPkgYe161050DAO;//C_연금보험료공제
	@Autowired
	@Resource(name = "InfcPkgYe161055_2023_DAO")
	private InfcPkgYe161055_2023_DAO  infcPkgYe161055DAO;//C_연금보험료_공적연금상세
	@Autowired
	@Resource(name = "InfcPkgYe161060_2023_DAO")
	private InfcPkgYe161060_2023_DAO  infcPkgYe161060DAO;//C_특별소득공제
	@Autowired
	@Resource(name = "InfcPkgYe161070_2023_DAO")
	private InfcPkgYe161070_2023_DAO  infcPkgYe161070DAO;//C_그밖의소득공제
	@Autowired
	@Resource(name = "InfcPkgYe161080_2023_DAO")
	private InfcPkgYe161080_2023_DAO  infcPkgYe161080DAO;//C_세액감면및공제
	@Autowired
	@Resource(name = "InfcPkgYe161090_2023_DAO")
	private InfcPkgYe161090_2023_DAO  infcPkgYe161090DAO;//C_교육비내역
	@Autowired
	@Resource(name = "InfcPkgYe162010_2023_DAO")
	private InfcPkgYe162010_2023_DAO  infcPkgYe162010DAO;//F_연금저축계좌
	@Autowired
	@Resource(name = "InfcPkgYe162020_2023_DAO")
	private InfcPkgYe162020_2023_DAO  infcPkgYe162020DAO;//F_퇴직연금계좌명세
	@Autowired
	@Resource(name = "InfcPkgYe162030_2023_DAO")
	private InfcPkgYe162030_2023_DAO  infcPkgYe162030DAO;//F_주택마련저축
	@Autowired
	@Resource(name = "InfcPkgYe162040_2023_DAO")
	private InfcPkgYe162040_2023_DAO  infcPkgYe162040DAO;//F_장기집합투자증권저축_B1013
	@Autowired
	@Resource(name = "InfcPkgYe162510_2023_DAO")
	private InfcPkgYe162510_2023_DAO  infcPkgYe162510DAO;//G_월세액소득공제명세
	@Autowired
	@Resource(name = "InfcPkgYe162520_2023_DAO")
	private InfcPkgYe162520_2023_DAO  infcPkgYe162520DAO;//G_거주자간_금전소비대차
	@Autowired
	@Resource(name = "InfcPkgYe162530_2023_DAO")
	private InfcPkgYe162530_2023_DAO  infcPkgYe162530DAO;//G_임대차계약
	@Autowired
	@Resource(name = "InfcPkgYe164010_2023_DAO")
	private InfcPkgYe164010_2023_DAO infcPkgYe164010DAO; //A_의료비지급명세
	@Autowired
	@Resource(name = "InfcPkgYe165010_2023_DAO")
	private InfcPkgYe165010_2023_DAO  infcPkgYe165010DAO;//I_해당연도기부금명세
	@Autowired
	@Resource(name = "InfcPkgYe165020_2023_DAO")
	private InfcPkgYe165020_2023_DAO  infcPkgYe165020DAO;//I_기부자관계코드별기부금합계
	@Autowired
	@Resource(name = "InfcPkgYe165030_2023_DAO")
	private InfcPkgYe165030_2023_DAO  infcPkgYe165030DAO;//H_기부금조정명세
	@Autowired
	@Resource(name = "InfcPkgYe165030Temp_2023_DAO")
	private InfcPkgYe165030Temp_2023_DAO infcPkgYe165030TempDAO;    //H_기부금조정명세_TEMP	 
	@Autowired
	@Resource(name = "InfcPkgYe166010_2023_DAO")
	private InfcPkgYe166010_2023_DAO  infcPkgYe166010DAO;//신용카드등소득공제명세
	@Autowired
	@Resource(name = "InfcPkgYe166020_2023_DAO")
	private InfcPkgYe166020_2023_DAO  infcPkgYe166020DAO;//신용카드등소득공제상세
		 
	@Autowired
	@Resource(name = "InfcPkgYe169010_2023_DAO")
	private InfcPkgYe169010_2023_DAO infcPkgYe169010DAO; //C_주현근무처
	@Autowired
	@Resource(name = "InfcPkgYe169010a_2023_DAO")
	private InfcPkgYe169010a_2023_DAO infcPkgYe169010aDAO; //C_주현근무처_표준공제 
	
	
	public void yeta8200_Ye161020_2023_Update(InfcPkgYe161020_2023_VO ye161020VO) throws Exception {
		infcPkgYe161020DAO.updateYe161020YN(ye161020VO);
    }   

	/***********************************************************************************
	 * 2023년귀속 연말정산 처리를 위한 함수 처리 부 시작  -nts pdf
	 ***********************************************************************************/
	
	public int incTaxDeducDec_nts_Yeta2023_YetaAll_Delete(InfcPkgYe161010_2023_VO  infcPkgYe161010Vo) throws Exception {
		return infcPkgYe161010DAO.incTaxDeducDec_nts_Yeta2023_YetaAll_Delete(infcPkgYe161010Vo);
    }   
	 
	//InfcPkgYe161020VO     infcPkgYe161020Vo	 = new InfcPkgYe161020VO();	//A_인적소득공제기본 
	public int incTaxDeducDec_nts_Yeta2023_Ye161020_update(InfcPkgYe161020_2023_VO  infcPkgYe161020Vo) throws Exception {
		return infcPkgYe161020DAO.incTaxDeducDec_nts_Yeta2023_Ye161020_update(infcPkgYe161020Vo);
    }   

	//InfcPkgYe161030VO     infcPkgYe161030Vo	 = new InfcPkgYe161030VO();	//E_인적공제명세
	public String incTaxDeducDec_nts_Yeta2023_Ye161030_Insert(InfcPkgYe161030_2023_VO     infcPkgYe161030Vo) throws Exception {
		return infcPkgYe161030DAO.incTaxDeducDec_nts_Yeta2023_Ye161030_Insert(infcPkgYe161030Vo);
    }    
	
	//InfcPkgYe161040VO     infcPkgYe161040Vo	 = new InfcPkgYe161040VO();	//E_소득세액공제명세
	public String incTaxDeducDec_nts_Yeta2023_Ye161040_Insert(InfcPkgYe161040_2023_VO infcPkgYe161040Vo) throws Exception {
		return infcPkgYe161040DAO.incTaxDeducDec_nts_Yeta2023_Ye161040_Insert(infcPkgYe161040Vo);
    }   
	

	//InfcPkgYe161055VO     infcPkgYe161055Vo	 = new InfcPkgYe161055VO();	//C_연금보험료_공적연금상세 - 여기도삭제안함  TODO
	public String incTaxDeducDec_nts_Yeta2023_Ye161055_Insert(InfcPkgYe161055_2023_VO     infcPkgYe161055Vo) throws Exception {
		return infcPkgYe161055DAO.incTaxDeducDec_nts_Yeta2023_Ye161055_Insert(infcPkgYe161055Vo);
    } 
	
	public String fnYeta8100_Ye161055_PAYR_2023_Y0130002_Insert(InfcPkgYe161055_2023_VO     infcPkgYe161055Vo) throws Exception {
		return infcPkgYe161055DAO.fnYeta8100_Ye161055_PAYR_2023_Y0130002_Insert(infcPkgYe161055Vo);
    } 
	
	 
			
	//InfcPkgYe161050VO     infcPkgYe161050Vo	 = new InfcPkgYe161050VO();	//C_연금보험료공제
	public String incTaxDeducDec_nts_Yeta2023_Ye161050_Insert(InfcPkgYe161050_2023_VO     infcPkgYe161050Vo) throws Exception {
		return infcPkgYe161050DAO.incTaxDeducDec_nts_Yeta2023_Ye161050_Insert(infcPkgYe161050Vo);
    }   
	
	//InfcPkgYe161060VO     infcPkgYe161060Vo	 = new InfcPkgYe161060VO();	//C_특별소득공제
	public String incTaxDeducDec_nts_Yeta2023_Ye161060_Insert(InfcPkgYe161060_2023_VO     infcPkgYe161060Vo) throws Exception {
		return infcPkgYe161060DAO.incTaxDeducDec_nts_Yeta2023_Ye161060_Insert(infcPkgYe161060Vo);
    }   
	
	
	//InfcPkgYe161070VO     infcPkgYe161070Vo	 = new InfcPkgYe161070VO();	//C_그밖의소득공제
	public String incTaxDeducDec_nts_Yeta2023_Ye161070_Insert(InfcPkgYe161070_2023_VO     infcPkgYe161070Vo) throws Exception {
		return infcPkgYe161070DAO.incTaxDeducDec_nts_Yeta2023_Ye161070_Insert(infcPkgYe161070Vo);
    }   
	
	
	//InfcPkgYe161080VO     infcPkgYe161080Vo	 = new InfcPkgYe161080VO();	//C_세액감면및공제
	public String incTaxDeducDec_nts_Yeta2023_Ye161080_Insert(InfcPkgYe161080_2023_VO     infcPkgYe161080Vo) throws Exception {
		return infcPkgYe161080DAO.incTaxDeducDec_nts_Yeta2023_Ye161080_Insert(infcPkgYe161080Vo);
    }
	//InfcPkgYe161080VO     infcPkgYe161080Vo	 = new InfcPkgYe161080VO();	//C_세액감면및공제
	public String incTaxDeducDec_nts_Yeta2023_Ye161080_Insert_01(InfcPkgYe161080_2023_VO     infcPkgYe161080Vo) throws Exception {
		return infcPkgYe161080DAO.incTaxDeducDec_nts_Yeta2023_Ye161080_Insert_01(infcPkgYe161080Vo);
    }
	
	
//InfcPkgYe161090VO     infcPkgYe161090Vo	 = new InfcPkgYe161090VO();	//C_교육비내역 TODO 확인후  여기는 삭제안함 
//	public String incTaxDeducDec_nts_Yeta2023_Ye161090_Insert(InfcPkgYe161090VO     infcPkgYe161090Vo) throws Exception {
//		return infcPkgYe161090DAO.incTaxDeducDec_nts_Yeta2023_Ye161090_Insert(infcPkgYe161090Vo);
//    }   
	
	//InfcPkgYe162010VO     infcPkgYe162010Vo	 = new InfcPkgYe162010VO();	//F_연금저축계좌
	public String incTaxDeducDec_nts_Yeta2023_Ye162010_Insert(InfcPkgYe162010_2023_VO     infcPkgYe162010Vo) throws Exception {
		return infcPkgYe162010DAO.incTaxDeducDec_nts_Yeta2023_Ye162010_Insert(infcPkgYe162010Vo);
    }   
	
	//InfcPkgYe162020VO     infcPkgYe162020Vo	 = new InfcPkgYe162020VO();	//F_퇴직연금계좌명세
	public String incTaxDeducDec_nts_Yeta2023_Ye162020_Insert(InfcPkgYe162020_2023_VO     infcPkgYe162020Vo) throws Exception {
		return infcPkgYe162020DAO.incTaxDeducDec_nts_Yeta2023_Ye162020_Insert(infcPkgYe162020Vo);
    }   
	
	//InfcPkgYe162030VO     infcPkgYe162030Vo	 = new InfcPkgYe162030VO();	//F_주택마련저축
	public String incTaxDeducDec_nts_Yeta2023_Ye162030_Insert(InfcPkgYe162030_2023_VO     infcPkgYe162030Vo) throws Exception {
		return infcPkgYe162030DAO.incTaxDeducDec_nts_Yeta2023_Ye162030_Insert(infcPkgYe162030Vo);
    }   
	
	//InfcPkgYe162040VO     infcPkgYe162040Vo	 = new InfcPkgYe162040VO();	//F_장기집합투자증권저축_B1013
	public String incTaxDeducDec_nts_Yeta2023_Ye162040_Insert(InfcPkgYe162040_2023_VO     infcPkgYe162040Vo	) throws Exception {
		return infcPkgYe162040DAO.incTaxDeducDec_nts_Yeta2023_Ye162040_Insert(infcPkgYe162040Vo);
    }
 
	 
	
	//InfcPkgYe162510VO     infcPkgYe162510Vo	 = new InfcPkgYe162510VO();	//G_월세액소득공제명세
	public String incTaxDeducDec_nts_Yeta2023_Ye162510_Insert(InfcPkgYe162510_2023_VO     infcPkgYe162510Vo) throws Exception {
		return infcPkgYe162510DAO.incTaxDeducDec_nts_Yeta2023_Ye162510_Insert(infcPkgYe162510Vo);
    }   
	
	
	//InfcPkgYe162520VO     infcPkgYe162520Vo	 = new InfcPkgYe162520VO();	//G_거주자간_금전소비대차
	public String incTaxDeducDec_nts_Yeta2023_Ye162520_Insert(InfcPkgYe162520_2023_VO     infcPkgYe162520Vo) throws Exception {
		return infcPkgYe162520DAO.incTaxDeducDec_nts_Yeta2023_Ye162520_Insert(infcPkgYe162520Vo);
    }   
	
	
	//InfcPkgYe162530VO     infcPkgYe162530Vo	 = new InfcPkgYe162530VO();	//G_임대차계약
	public String incTaxDeducDec_nts_Yeta2023_Ye162530_Insert(InfcPkgYe162530_2023_VO     infcPkgYe162530Vo) throws Exception {
		return infcPkgYe162530DAO.incTaxDeducDec_nts_Yeta2023_Ye162530_Insert(infcPkgYe162530Vo);
    }   
	
	
	//InfcPkgYe164010VO     infcPkgYe164010Vo	 = new InfcPkgYe164010VO();	//A_의료비지급명세
	public String incTaxDeducDec_nts_Yeta2023_Ye164010_Insert(InfcPkgYe164010_2023_VO     infcPkgYe164010Vo) throws Exception {
		return infcPkgYe164010DAO.incTaxDeducDec_nts_Yeta2023_Ye164010_Insert(infcPkgYe164010Vo);
    }   
	
	
	//InfcPkgYe165010VO     infcPkgYe165010Vo	 = new InfcPkgYe165010VO();	//I_해당연도기부금명세
	public String incTaxDeducDec_nts_Yeta2023_Ye165010_Insert(InfcPkgYe165010_2023_VO     infcPkgYe165010Vo) throws Exception {
		return infcPkgYe165010DAO.incTaxDeducDec_nts_Yeta2023_Ye165010_Insert(infcPkgYe165010Vo);
    }   
	
	
	//InfcPkgYe165020VO     infcPkgYe165020Vo	 = new InfcPkgYe165020VO();	//I_기부자관계코드별기부금합계
	public String incTaxDeducDec_nts_Yeta2023_Ye165020_Insert(InfcPkgYe165020_2023_VO     infcPkgYe165020Vo) throws Exception {
		return infcPkgYe165020DAO.incTaxDeducDec_nts_Yeta2023_Ye165020_Insert(infcPkgYe165020Vo);
    }   
	
	
	//InfcPkgYe165030VO     infcPkgYe165030Vo	 = new InfcPkgYe165030VO();	//H_기부금조정명세
	public String incTaxDeducDec_nts_Yeta2023_Ye165030_Insert(InfcPkgYe165030_2023_VO     infcPkgYe165030Vo) throws Exception {
		return infcPkgYe165030DAO.incTaxDeducDec_nts_Yeta2023_Ye165030_Insert(infcPkgYe165030Vo);
    }   
	
	
	//InfcPkgYe165030TempVO infcPkgYe165030TempVo = new InfcPkgYe165030TempVO();  	    //H_기부금조정명세_TEMP	 
//	public String incTaxDeducDec_nts_Yeta2023_Ye165030Temp_Insert(InfcPkgYe165030TempVO infcPkgYe165030TempVo) throws Exception {
//		return infcPkgYe165030DAO.incTaxDeducDec_nts_Yeta2023_Ye165030Temp_Insert(infcPkgYe165030TempVo);
//    }   
	 
	//InfcPkgYe166010VO     infcPkgYe166010Vo	 = new InfcPkgYe166010VO();	//신용카드등소득공제명세
	public String incTaxDeducDec_nts_Yeta2023_Ye166010_Insert(InfcPkgYe166010_2023_VO     infcPkgYe166010Vo) throws Exception {
		return infcPkgYe166010DAO.incTaxDeducDec_nts_Yeta2023_Ye166010_Insert(infcPkgYe166010Vo);
    }   
	
	 
	//InfcPkgYe166020VO     infcPkgYe166020Vo	 = new InfcPkgYe166020VO();	//신용카드등소득공제상세
	public String incTaxDeducDec_nts_Yeta2023_Ye166020_Insert(InfcPkgYe166020_2023_VO     infcPkgYe166020Vo) throws Exception {
		return infcPkgYe166020DAO.incTaxDeducDec_nts_Yeta2023_Ye166020_Insert(infcPkgYe166020Vo);
    }

	//InfcPkgYe169010VO     infcPkgYe169010Vo	 = new InfcPkgYe169010VO();	//C_주현근무처 -안함 
//	public String incTaxDeducDec_nts_Yeta2023_Ye169010_Insert(InfcPkgYe169010VO     infcPkgYe169010Vo) throws Exception {
//		return infcPkgYe169010DAO.incTaxDeducDec_nts_Yeta2023_Ye169010_Insert(infcPkgYe169010Vo);
//    }   
	
	
	 /***********************************************************************************
	  * 2023년귀속 연말정산 처리를 위한 함수 처리 부 종료   -nts pdf
	  ***********************************************************************************/
	
}
