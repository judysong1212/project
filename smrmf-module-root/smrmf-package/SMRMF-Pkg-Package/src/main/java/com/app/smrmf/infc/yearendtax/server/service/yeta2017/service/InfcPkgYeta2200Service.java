package com.app.smrmf.infc.yearendtax.server.service.yeta2017.service;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161020VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161030VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161040VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161050VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161055VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161060VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161070VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161080VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162020VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162030VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162040VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162510VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162520VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162530VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe164010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe165010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe165020VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe165030VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe166010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe166020VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe169010VO;

/**
* <pre>
* 1. 패키지명 : com.app.smrmf.infc.yearendtax.server.service.yeta2017.service
* 2. 타입명 : InfcPkgYeta2200Service.java
* 3. 작성일 : 2017. 12. 5. 오후 3:43:39
* 4. 작성자 : kyumin.jang
* 5. 설명 : 
* </pre>
*/
public interface InfcPkgYeta2200Service {
	
	/**
	 * <pre>
	 * 1. 개요 : PDF 제출 여부 업데이트
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_Ye161020_2017_Update
	 * @date : 2017. 12. 5.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 12. 5.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param ye161020VO
	 * @throws Exception
	 */ 	
	public void yeta2200_Ye161020_2017_Update(InfcPkgYe161020VO ye161020VO) throws Exception; 
	
	
	/***********************************************************************************
	 * 2017년귀속 연말정산 처리를 위한 함수 처리 부 시작  -nts pdf
	 ***********************************************************************************/
    public int incTaxDeducDec_nts_Yeta2017_YetaAll_Delete(InfcPkgYe161010VO  infcPkgYe161010Vo) throws Exception;
	 
	
	//InfcPkgYe161020VO     infcPkgYe161020Vo	 = new InfcPkgYe161020VO();	//A_인적소득공제기본 
	public int incTaxDeducDec_nts_Yeta2017_Ye161020_update(InfcPkgYe161020VO  infcPkgYe161020Vo) throws Exception;
	
	//InfcPkgYe161030VO     infcPkgYe161030Vo	 = new InfcPkgYe161030VO();	//E_인적공제명세
	public String incTaxDeducDec_nts_Yeta2017_Ye161030_Insert(InfcPkgYe161030VO     infcPkgYe161030Vo) throws Exception;
	
	
	//InfcPkgYe161040VO     infcPkgYe161040Vo	 = new InfcPkgYe161040VO();	//E_소득세액공제명세
	public String incTaxDeducDec_nts_Yeta2017_Ye161040_Insert(InfcPkgYe161040VO     infcPkgYe161040Vo) throws Exception;
	
	
	//InfcPkgYe161050VO     infcPkgYe161050Vo	 = new InfcPkgYe161050VO();	//C_연금보험료공제
	public String incTaxDeducDec_nts_Yeta2017_Ye161050_Insert(InfcPkgYe161050VO     infcPkgYe161050Vo) throws Exception;
	
	//InfcPkgYe161055VO     infcPkgYe161055Vo	 = new InfcPkgYe161055VO();	//C_연금보험료_공적연금상세
	public String incTaxDeducDec_nts_Yeta2017_Ye161055_Insert(InfcPkgYe161055VO     infcPkgYe161055Vo) throws Exception;
	
	//InfcPkgYe161055VO     infcPkgYe161055Vo	 = new InfcPkgYe161055VO();	//C_연금보험료_공적연금상세
		public String fnYeta2100_Ye161055_PAYR_2017_Y0130002_Insert(InfcPkgYe161055VO     infcPkgYe161055Vo) throws Exception;
		
	 
	
	//InfcPkgYe161060VO     infcPkgYe161060Vo	 = new InfcPkgYe161060VO();	//C_특별소득공제
	public String incTaxDeducDec_nts_Yeta2017_Ye161060_Insert(InfcPkgYe161060VO     infcPkgYe161060Vo) throws Exception;
	
	
	//InfcPkgYe161070VO     infcPkgYe161070Vo	 = new InfcPkgYe161070VO();	//C_그밖의소득공제 
	public String incTaxDeducDec_nts_Yeta2017_Ye161070_Insert(InfcPkgYe161070VO     infcPkgYe161070Vo) throws Exception;
	
	
	//InfcPkgYe161080VO     infcPkgYe161080Vo	 = new InfcPkgYe161080VO();	//C_세액감면및공제
	public String incTaxDeducDec_nts_Yeta2017_Ye161080_Insert(InfcPkgYe161080VO     infcPkgYe161080Vo) throws Exception;
	//InfcPkgYe161080VO     infcPkgYe161080Vo	 = new InfcPkgYe161080VO();	//C_세액감면및공제
	public String incTaxDeducDec_nts_Yeta2017_Ye161080_Insert_01(InfcPkgYe161080VO     infcPkgYe161080Vo) throws Exception;
		
	
	
	//InfcPkgYe161090VO     infcPkgYe161090Vo	 = new InfcPkgYe161090VO();	//C_교육비내역
	//public String incTaxDeducDec_nts_Yeta2017_Ye161090_Insert(InfcPkgYe161090VO     infcPkgYe161090Vo) throws Exception;
	
	//InfcPkgYe162010VO     infcPkgYe162010Vo	 = new InfcPkgYe162010VO();	//F_연금저축계좌
	public String incTaxDeducDec_nts_Yeta2017_Ye162010_Insert(InfcPkgYe162010VO     infcPkgYe162010Vo) throws Exception;
	
	//InfcPkgYe162020VO     infcPkgYe162020Vo	 = new InfcPkgYe162020VO();	//F_퇴직연금계좌명세
	public String incTaxDeducDec_nts_Yeta2017_Ye162020_Insert(InfcPkgYe162020VO     infcPkgYe162020Vo) throws Exception;
	
	//InfcPkgYe162030VO     infcPkgYe162030Vo	 = new InfcPkgYe162030VO();	//F_주택마련저축
	public String incTaxDeducDec_nts_Yeta2017_Ye162030_Insert(InfcPkgYe162030VO     infcPkgYe162030Vo) throws Exception;
	
	//InfcPkgYe162040VO     infcPkgYe162040Vo	 = new InfcPkgYe162040VO();	//F_장기집합투자증권저축_B1013
	public String incTaxDeducDec_nts_Yeta2017_Ye162040_Insert(InfcPkgYe162040VO     infcPkgYe162040Vo	) throws Exception;
	
	
	//InfcPkgYe162510VO     infcPkgYe162510Vo	 = new InfcPkgYe162510VO();	//G_월세액소득공제명세
	public String incTaxDeducDec_nts_Yeta2017_Ye162510_Insert(InfcPkgYe162510VO     infcPkgYe162510Vo) throws Exception;
	
	
	//InfcPkgYe162520VO     infcPkgYe162520Vo	 = new InfcPkgYe162520VO();	//G_거주자간_금전소비대차
	public String incTaxDeducDec_nts_Yeta2017_Ye162520_Insert(InfcPkgYe162520VO     infcPkgYe162520Vo) throws Exception;
	
	
	//InfcPkgYe162530VO     infcPkgYe162530Vo	 = new InfcPkgYe162530VO();	//G_임대차계약
	public String incTaxDeducDec_nts_Yeta2017_Ye162530_Insert(InfcPkgYe162530VO     infcPkgYe162530Vo) throws Exception;
	
	
	//InfcPkgYe164010VO     infcPkgYe164010Vo	 = new InfcPkgYe164010VO();	//A_의료비지급명세
	public String incTaxDeducDec_nts_Yeta2017_Ye164010_Insert(InfcPkgYe164010VO     infcPkgYe164010Vo) throws Exception;
	
	
	//InfcPkgYe165010VO     infcPkgYe165010Vo	 = new InfcPkgYe165010VO();	//I_해당연도기부금명세
	public String incTaxDeducDec_nts_Yeta2017_Ye165010_Insert(InfcPkgYe165010VO     infcPkgYe165010Vo) throws Exception;
	
	
	//InfcPkgYe165020VO     infcPkgYe165020Vo	 = new InfcPkgYe165020VO();	//I_기부자관계코드별기부금합계
	public String incTaxDeducDec_nts_Yeta2017_Ye165020_Insert(InfcPkgYe165020VO     infcPkgYe165020Vo) throws Exception;
	
	
	//InfcPkgYe165030VO     infcPkgYe165030Vo	 = new InfcPkgYe165030VO();	//H_기부금조정명세
	public String incTaxDeducDec_nts_Yeta2017_Ye165030_Insert(InfcPkgYe165030VO     infcPkgYe165030Vo) throws Exception;
	
	
	//InfcPkgYe165030TempVO infcPkgYe165030TempVo = new InfcPkgYe165030TempVO();  	    //H_기부금조정명세_TEMP	 
	//public String incTaxDeducDec_nts_Yeta2017_Ye165030Temp_Insert(InfcPkgYe165030TempVO infcPkgYe165030TempVo) throws Exception;
	
	
	//InfcPkgYe166010VO     infcPkgYe166010Vo	 = new InfcPkgYe166010VO();	//신용카드등소득공제명세
	public String incTaxDeducDec_nts_Yeta2017_Ye166010_Insert(InfcPkgYe166010VO     infcPkgYe166010Vo) throws Exception;
	
	
	//InfcPkgYe166020VO     infcPkgYe166020Vo	 = new InfcPkgYe166020VO();	//신용카드등소득공제상세
	public String incTaxDeducDec_nts_Yeta2017_Ye166020_Insert(InfcPkgYe166020VO     infcPkgYe166020Vo) throws Exception;
	
	//InfcPkgYe169010VO     infcPkgYe169010Vo	 = new InfcPkgYe169010VO();	//C_주현근무처
	//public String incTaxDeducDec_nts_Yeta2017_Ye169010_Insert(InfcPkgYe169010VO     infcPkgYe169010Vo) throws Exception;
	
	
	 /***********************************************************************************
	  * 2017년귀속 연말정산 처리를 위한 함수 처리 부 종료   -nts pdf
	  ***********************************************************************************/
	
	

}
