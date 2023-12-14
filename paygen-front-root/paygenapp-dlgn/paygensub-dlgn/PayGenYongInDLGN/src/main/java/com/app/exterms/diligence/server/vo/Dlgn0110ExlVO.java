package com.app.exterms.diligence.server.vo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @Class Name : Dlgn0110VO.java
 * @Description : Dlgn0110 VO class
 * @Modification Information
 *
 * @author admin
 * @since 2016.07.13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Dlgn0110ExlVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    ArrayList<Dlgn0110ExlVO> dlgn0110List = new ArrayList<Dlgn0110ExlVO>();
    
    public ArrayList<Dlgn0110ExlVO> getDlgn0110List() {
		return dlgn0110List;
	}

	public void setDlgn0110List(ArrayList<Dlgn0110ExlVO> dlgn0110List) {
		this.dlgn0110List = dlgn0110List;
	}
    
	/** set 사업장코드 : DPOB_CD */
    private java.lang.String dpobCd;
    
    /** set SYSTEMKEY : SYSTEMKEY */
    private java.lang.String systemkey;
    
    /** set 한글성명 : hanNm */
    private java.lang.String hanNm;

    /** set 주민등록번호 : resnRegnNum */
    private java.lang.String resnRegnNum;
    
    /** secResnNum : 주민등록번호 원본*/
    private java.lang.String secResnNum;
    
    /** set 근태년월 : DILNLAZ_YR_MNTH */
    private java.lang.String dilnlazYrMnth;
    
    /** set 급여구분코드 : PAY_CD */
    private java.lang.String payCd;

    /** set 근태_적용일자 : DILNLAZ_APPTN_DT */
    private java.lang.String dilnlazApptnDt;
    
    /** set 근태_근무시간 : DILNLAZ_DUTY_TM */
    private java.lang.String dilnlazDutyTm;
    
    /** set 근태_근무여부 : DILNLAZ_DUTY_YN */
    private java.lang.String dilnlazDutyYn;
    
    /** set 근태_결근여부 : DILNLAZ_ABNCE_YN */
    private java.lang.String dilnlazAbnceYn;
    
    /** set 근태_연가여부 : DILNLAZ_LVSG_YN */
    private java.lang.String dilnlazLvsgYn;
    
    /** set 근태_병가여부 : DILNLAZ_SCKLEA_YN */
    private java.lang.String dilnlazSckleaYn;
    
    /** set 근태_공가여부 : DILNLAZ_OFFVA_YN */
    private java.lang.String dilnlazOffvaYn;
    
    /** set 근태_경조사여부 : DILNLAZ_FMLY_EVNT_YN */
    private java.lang.String dilnlazFmlyEvntYn;
    
    /** set 근태_보건여부 : DILNLAZ_HLTH_CRE_YN */
    private java.lang.String dilnlazHlthCreYn;
    
    /** set 근태_결근근무인정여부 : DILNLAZ_ABNCE_DUTY_RCGTN_YN */
    private java.lang.String dilnlazAbnceDutyRcgtnYn;
    
    /** set 입력자 : KYBDR */
    private java.lang.String kybdr;
    
    /** set 입력일자 : INPT_DT */
    private java.lang.String inptDt;
    
    /** set 입력주소 : INPT_ADDR */
    private java.lang.String inptAddr;
    
    /** set 수정자 : ISMT */
    private java.lang.String ismt;
    
    /** set 수정일자 : REVN_DT */
    private java.lang.String revnDt;
    
    /** set 수정주소 : REVN_ADDR */
    private java.lang.String revnAddr;
    
    /** set 근태_특별휴가여부 : DILNLAZ_SPCL_HODY_YN */
    private java.lang.String dilnlazSpclHodyYn;
    
    /** set 근태_교통보조비여부 : DILNLAZ_TFC_ASS_CST_YN */
    private java.lang.String dilnlazTfcAssCstYn;
    
    /** set 근태_급식비여부 : DILNLAZ_LNCH_YN */
    private java.lang.String dilnlazLnchYn;
    
    /** set 근태_휴일근무여부 : DILNLAZ_HODY_YN */
    private java.lang.String dilnlazHodyYn;
    
    /** set 복무기타구분코드 : DILNLAZ_ETC_DIV_CD */
    private java.lang.String dilnlazEtcDivCd;
    
    /** set 근태_근무시작일자 : dilnlazDutyBgnnDt */
    private java.lang.String dilnlazDutyBgnnDt;

    /** set 근태_근무종료일자 : dilnlazDutyEndDt */
    private java.lang.String dilnlazDutyEndDt;
    
    /** set 근태_출근시간 : dilnlazStTm */
    private java.lang.String dilnlazStTm;

    /** set 근태_퇴근시간 : dilnlazEdTm */
    private java.lang.String dilnlazEdTm;

    

	/** set 엑셀 업로드 1일 구분코드 : kubn1 */
	private java.lang.String kubn1;

	/** set 엑셀 업로드 2일 구분코드 : kubn2 */
	private java.lang.String kubn2;

	/** set 엑셀 업로드 3일 구분코드 : kubn3 */
	private java.lang.String kubn3;

	/** set 엑셀 업로드 4일 구분코드 : kubn4 */
	private java.lang.String kubn4;

	/** set 엑셀 업로드 5일 구분코드 : kubn5 */
	private java.lang.String kubn5;

	/** set 엑셀 업로드 6일 구분코드 : kubn6 */
	private java.lang.String kubn6;

	/** set 엑셀 업로드 7일 구분코드 : kubn7 */
	private java.lang.String kubn7;

	/** set 엑셀 업로드 8일 구분코드 : kubn8 */
	private java.lang.String kubn8;

	/** set 엑셀 업로드 9일 구분코드 : kubn9 */
	private java.lang.String kubn9;

	/** set 엑셀 업로드 10일 구분코드 : kubn10 */
	private java.lang.String kubn10;

	/** set 엑셀 업로드 11일 구분코드 : kubn11 */
	private java.lang.String kubn11;

	/** set 엑셀 업로드 12일 구분코드 : kubn12 */
	private java.lang.String kubn12;

	/** set 엑셀 업로드 13일 구분코드 : kubn13 */
	private java.lang.String kubn13;

	/** set 엑셀 업로드 14일 구분코드 : kubn14 */
	private java.lang.String kubn14;

	/** set 엑셀 업로드 15일 구분코드 : kubn15 */
	private java.lang.String kubn15;

	/** set 엑셀 업로드 16일 구분코드 : kubn16 */
	private java.lang.String kubn16;

	/** set 엑셀 업로드 17일 구분코드 : kubn17 */
	private java.lang.String kubn17;

	/** set 엑셀 업로드 18일 구분코드 : kubn18 */
	private java.lang.String kubn18;

	/** set 엑셀 업로드 19일 구분코드 : kubn19 */
	private java.lang.String kubn19;

	/** set 엑셀 업로드 20일 구분코드 : kubn20 */
	private java.lang.String kubn20;

	/** set 엑셀 업로드 21일 구분코드 : kubn21 */
	private java.lang.String kubn21;

	/** set 엑셀 업로드 22일 구분코드 : kubn22 */
	private java.lang.String kubn22;

	/** set 엑셀 업로드 23일 구분코드 : kubn23 */
	private java.lang.String kubn23;

	/** set 엑셀 업로드 24일 구분코드 : kubn24 */
	private java.lang.String kubn24;

	/** set 엑셀 업로드 25일 구분코드 : kubn25 */
	private java.lang.String kubn25;

	/** set 엑셀 업로드 26일 구분코드 : kubn26 */
	private java.lang.String kubn26;

	/** set 엑셀 업로드 27일 구분코드 : kubn27 */
	private java.lang.String kubn27;

	/** set 엑셀 업로드 28일 구분코드 : kubn28 */
	private java.lang.String kubn28;

	/** set 엑셀 업로드 29일 구분코드 : kubn29 */
	private java.lang.String kubn29;

	/** set 엑셀 업로드 30일 구분코드 : kubn30 */
	private java.lang.String kubn30;

	/** set 엑셀 업로드 31일 구분코드 : kubn31 */
	private java.lang.String kubn31;

	/** set 근태_근무시간_엑셀업로드1일 : DILNLAZ_DUTY_TM1 */
	private java.lang.String dilnlazDutyTm1;

	/** set 근태_근무시간_엑셀업로드2일 : DILNLAZ_DUTY_TM2 */
	private java.lang.String dilnlazDutyTm2;

	/** set 근태_근무시간_엑셀업로드3일 : DILNLAZ_DUTY_TM3 */
	private java.lang.String dilnlazDutyTm3;

	/** set 근태_근무시간_엑셀업로드4일 : DILNLAZ_DUTY_TM4 */
	private java.lang.String dilnlazDutyTm4;

	/** set 근태_근무시간_엑셀업로드5일 : DILNLAZ_DUTY_TM5 */
	private java.lang.String dilnlazDutyTm5;

	/** set 근태_근무시간_엑셀업로드6일 : DILNLAZ_DUTY_TM6 */
	private java.lang.String dilnlazDutyTm6;

	/** set 근태_근무시간_엑셀업로드7일 : DILNLAZ_DUTY_TM7 */
	private java.lang.String dilnlazDutyTm7;

	/** set 근태_근무시간_엑셀업로드8일 : DILNLAZ_DUTY_TM8 */
	private java.lang.String dilnlazDutyTm8;

	/** set 근태_근무시간_엑셀업로드9일 : DILNLAZ_DUTY_TM9 */
	private java.lang.String dilnlazDutyTm9;

	/** set 근태_근무시간_엑셀업로드10일 : DILNLAZ_DUTY_TM10 */
	private java.lang.String dilnlazDutyTm10;

	/** set 근태_근무시간_엑셀업로드11일 : DILNLAZ_DUTY_TM11 */
	private java.lang.String dilnlazDutyTm11;

	/** set 근태_근무시간_엑셀업로드12일 : DILNLAZ_DUTY_TM12 */
	private java.lang.String dilnlazDutyTm12;

	/** set 근태_근무시간_엑셀업로드13일 : DILNLAZ_DUTY_TM13 */
	private java.lang.String dilnlazDutyTm13;

	/** set 근태_근무시간_엑셀업로드14일 : DILNLAZ_DUTY_TM14 */
	private java.lang.String dilnlazDutyTm14;

	/** set 근태_근무시간_엑셀업로드15일 : DILNLAZ_DUTY_TM15 */
	private java.lang.String dilnlazDutyTm15;

	/** set 근태_근무시간_엑셀업로드16일 : DILNLAZ_DUTY_TM16 */
	private java.lang.String dilnlazDutyTm16;

	/** set 근태_근무시간_엑셀업로드17일 : DILNLAZ_DUTY_TM17 */
	private java.lang.String dilnlazDutyTm17;

	/** set 근태_근무시간_엑셀업로드18일 : DILNLAZ_DUTY_TM18 */
	private java.lang.String dilnlazDutyTm18;

	/** set 근태_근무시간_엑셀업로드19일 : DILNLAZ_DUTY_TM19 */
	private java.lang.String dilnlazDutyTm19;

	/** set 근태_근무시간_엑셀업로드20일 : DILNLAZ_DUTY_TM20 */
	private java.lang.String dilnlazDutyTm20;

	/** set 근태_근무시간_엑셀업로드21일 : DILNLAZ_DUTY_TM21 */
	private java.lang.String dilnlazDutyTm21;

	/** set 근태_근무시간_엑셀업로드22일 : DILNLAZ_DUTY_TM22 */
	private java.lang.String dilnlazDutyTm22;

	/** set 근태_근무시간_엑셀업로드23일 : DILNLAZ_DUTY_TM23 */
	private java.lang.String dilnlazDutyTm23;

	/** set 근태_근무시간_엑셀업로드24일 : DILNLAZ_DUTY_TM24 */
	private java.lang.String dilnlazDutyTm24;

	/** set 근태_근무시간_엑셀업로드25일 : DILNLAZ_DUTY_TM25 */
	private java.lang.String dilnlazDutyTm25;

	/** set 근태_근무시간_엑셀업로드26일 : DILNLAZ_DUTY_TM26 */
	private java.lang.String dilnlazDutyTm26;

	/** set 근태_근무시간_엑셀업로드27일 : DILNLAZ_DUTY_TM27 */
	private java.lang.String dilnlazDutyTm27;

	/** set 근태_근무시간_엑셀업로드28일 : DILNLAZ_DUTY_TM28 */
	private java.lang.String dilnlazDutyTm28;

	/** set 근태_근무시간_엑셀업로드29일 : DILNLAZ_DUTY_TM29 */
	private java.lang.String dilnlazDutyTm29;

	/** set 근태_근무시간_엑셀업로드30일 : DILNLAZ_DUTY_TM30 */
	private java.lang.String dilnlazDutyTm30;

	/** set 근태_근무시간_엑셀업로드31일 : DILNLAZ_DUTY_TM31 */
	private java.lang.String dilnlazDutyTm31;
	
	/** set 근태_출근시간_엑셀업로드1일 : DILNLAZ_ST_TM1 */
	private java.lang.String dilnlazStTm1;
	
	/** set 근태_출근시간_엑셀업로드2일 : DILNLAZ_ST_TM2 */
	private java.lang.String dilnlazStTm2;
	
	/** set 근태_출근시간_엑셀업로드3일 : DILNLAZ_ST_TM3 */
	private java.lang.String dilnlazStTm3;
	
	/** set 근태_출근시간_엑셀업로드4일 : DILNLAZ_ST_TM4 */
	private java.lang.String dilnlazStTm4;
	
	/** set 근태_출근시간_엑셀업로드5일 : DILNLAZ_ST_TM5 */
	private java.lang.String dilnlazStTm5;
	
	/** set 근태_출근시간_엑셀업로드6일 : DILNLAZ_ST_TM6 */
	private java.lang.String dilnlazStTm6;
	
	/** set 근태_출근시간_엑셀업로드7일 : DILNLAZ_ST_TM7 */
	private java.lang.String dilnlazStTm7;
	
	/** set 근태_출근시간_엑셀업로드8일 : DILNLAZ_ST_TM8 */
	private java.lang.String dilnlazStTm8;
	
	/** set 근태_출근시간_엑셀업로드9일 : DILNLAZ_ST_TM9 */
	private java.lang.String dilnlazStTm9;
	
	/** set 근태_출근시간_엑셀업로드10일 : DILNLAZ_ST_TM10 */
	private java.lang.String dilnlazStTm10;
	
	/** set 근태_출근시간_엑셀업로드11일 : DILNLAZ_ST_TM11 */
	private java.lang.String dilnlazStTm11;
	
	/** set 근태_출근시간_엑셀업로드12일 : DILNLAZ_ST_TM12*/
	private java.lang.String dilnlazStTm12;
	
	/** set 근태_출근시간_엑셀업로드13일 : DILNLAZ_ST_TM13 */
	private java.lang.String dilnlazStTm13;
	
	/** set 근태_출근시간_엑셀업로드14일 : DILNLAZ_ST_TM14 */
	private java.lang.String dilnlazStTm14;
	
	/** set 근태_출근시간_엑셀업로드15일 : DILNLAZ_ST_TM15 */
	private java.lang.String dilnlazStTm15;
	
	/** set 근태_출근시간_엑셀업로드16일 : DILNLAZ_ST_TM16 */
	private java.lang.String dilnlazStTm16;
	
	/** set 근태_출근시간_엑셀업로드17일 : DILNLAZ_ST_TM17 */
	private java.lang.String dilnlazStTm17;
	
	/** set 근태_출근시간_엑셀업로드18일 : DILNLAZ_ST_TM18 */
	private java.lang.String dilnlazStTm18;
	
	/** set 근태_출근시간_엑셀업로드19일 : DILNLAZ_ST_TM19 */
	private java.lang.String dilnlazStTm19;
	
	/** set 근태_출근시간_엑셀업로드20일 : DILNLAZ_ST_TM20 */
	private java.lang.String dilnlazStTm20;
	
	/** set 근태_출근시간_엑셀업로드21일 : DILNLAZ_ST_TM21 */
	private java.lang.String dilnlazStTm21;
	
	/** set 근태_출근시간_엑셀업로드22일 : DILNLAZ_ST_TM22 */
	private java.lang.String dilnlazStTm22;
	
	/** set 근태_출근시간_엑셀업로드23일 : DILNLAZ_ST_TM23 */
	private java.lang.String dilnlazStTm23;
	
	/** set 근태_출근시간_엑셀업로드24일 : DILNLAZ_ST_TM24 */
	private java.lang.String dilnlazStTm24;
	
	/** set 근태_출근시간_엑셀업로드25일 : DILNLAZ_ST_TM25 */
	private java.lang.String dilnlazStTm25;
	
	/** set 근태_출근시간_엑셀업로드26일 : DILNLAZ_ST_TM26 */
	private java.lang.String dilnlazStTm26;
	
	/** set 근태_출근시간_엑셀업로드27일 : DILNLAZ_ST_TM27 */
	private java.lang.String dilnlazStTm27;
	
	/** set 근태_출근시간_엑셀업로드28일 : DILNLAZ_ST_TM28 */
	private java.lang.String dilnlazStTm28;
	
	/** set 근태_출근시간_엑셀업로드29일 : DILNLAZ_ST_TM29 */
	private java.lang.String dilnlazStTm29;
	
	/** set 근태_출근시간_엑셀업로드30일 : DILNLAZ_ST_TM30 */
	private java.lang.String dilnlazStTm30;
	
	/** set 근태_출근시간_엑셀업로드31일 : DILNLAZ_ST_TM31 */
	private java.lang.String dilnlazStTm31;
	
	/** set 근태_퇴근시간_엑셀업로드1일 : DILNLAZ_ED_TM1 */
	private java.lang.String dilnlazEdTm1;
	
	/** set 근태_퇴근시간_엑셀업로드2일 : DILNLAZ_ED_TM2 */
	private java.lang.String dilnlazEdTm2;
	
	/** set 근태_퇴근시간_엑셀업로드3일 : DILNLAZ_ED_TM3 */
	private java.lang.String dilnlazEdTm3;
	
	/** set 근태_퇴근시간_엑셀업로드4일 : DILNLAZ_ED_TM4 */
	private java.lang.String dilnlazEdTm4;
	
	/** set 근태_퇴근시간_엑셀업로드5일 : DILNLAZ_ED_TM5 */
	private java.lang.String dilnlazEdTm5;
	
	/** set 근태_퇴근시간_엑셀업로드6일 : DILNLAZ_ED_TM6 */
	private java.lang.String dilnlazEdTm6;
	
	/** set 근태_퇴근시간_엑셀업로드7일 : DILNLAZ_ED_TM7 */
	private java.lang.String dilnlazEdTm7;
	
	/** set 근태_퇴근시간_엑셀업로드8일 : DILNLAZ_ED_TM8 */
	private java.lang.String dilnlazEdTm8;
	
	/** set 근태_퇴근시간_엑셀업로드9일 : DILNLAZ_ED_TM9 */
	private java.lang.String dilnlazEdTm9;
	
	/** set 근태_퇴근시간_엑셀업로드10일 : DILNLAZ_ED_TM10 */
	private java.lang.String dilnlazEdTm10;
	
	/** set 근태_퇴근시간_엑셀업로드11일 : DILNLAZ_ED_TM11 */
	private java.lang.String dilnlazEdTm11;
	
	/** set 근태_퇴근시간_엑셀업로드12일 : DILNLAZ_ED_TM12 */
	private java.lang.String dilnlazEdTm12;
	
	/** set 근태_퇴근시간_엑셀업로드13일 : DILNLAZ_ED_TM13 */
	private java.lang.String dilnlazEdTm13;
	
	/** set 근태_퇴근시간_엑셀업로드14일 : DILNLAZ_ED_TM14 */
	private java.lang.String dilnlazEdTm14;
	
	/** set 근태_퇴근시간_엑셀업로드15일 : DILNLAZ_ED_TM15 */
	private java.lang.String dilnlazEdTm15;
	
	/** set 근태_퇴근시간_엑셀업로드16일 : DILNLAZ_ED_TM16 */
	private java.lang.String dilnlazEdTm16;
	
	/** set 근태_퇴근시간_엑셀업로드17일 : DILNLAZ_ED_TM17 */
	private java.lang.String dilnlazEdTm17;
	
	/** set 근태_퇴근시간_엑셀업로드18일 : DILNLAZ_ED_TM18 */
	private java.lang.String dilnlazEdTm18;
	
	/** set 근태_퇴근시간_엑셀업로드19일 : DILNLAZ_ED_TM19 */
	private java.lang.String dilnlazEdTm19;
	
	/** set 근태_퇴근시간_엑셀업로드20일 : DILNLAZ_ED_TM20 */
	private java.lang.String dilnlazEdTm20;
	
	/** set 근태_퇴근시간_엑셀업로드21일 : DILNLAZ_ED_TM21 */
	private java.lang.String dilnlazEdTm21;
	
	/** set 근태_퇴근시간_엑셀업로드22일 : DILNLAZ_ED_TM22 */
	private java.lang.String dilnlazEdTm22;
	
	/** set 근태_퇴근시간_엑셀업로드23일 : DILNLAZ_ED_TM23 */
	private java.lang.String dilnlazEdTm23;
	
	/** set 근태_퇴근시간_엑셀업로드24일 : DILNLAZ_ED_TM24 */
	private java.lang.String dilnlazEdTm24;
	
	/** set 근태_퇴근시간_엑셀업로드25일 : DILNLAZ_ED_TM25 */
	private java.lang.String dilnlazEdTm25;
	
	/** set 근태_퇴근시간_엑셀업로드26일 : DILNLAZ_ED_TM26 */
	private java.lang.String dilnlazEdTm26;
	
	/** set 근태_퇴근시간_엑셀업로드27일 : DILNLAZ_ED_TM27 */
	private java.lang.String dilnlazEdTm27;
	
	/** set 근태_퇴근시간_엑셀업로드28일 : DILNLAZ_ED_TM28 */
	private java.lang.String dilnlazEdTm28;
	
	/** set 근태_퇴근시간_엑셀업로드29일 : DILNLAZ_ED_TM29 */
	private java.lang.String dilnlazEdTm29;
	
	/** set 근태_퇴근시간_엑셀업로드30일 : DILNLAZ_ED_TM30 */
	private java.lang.String dilnlazEdTm30;
	
	/** set 근태_퇴근시간_엑셀업로드31일 : DILNLAZ_ED_TM31 */
	private java.lang.String dilnlazEdTm31;

	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	public java.lang.String getSystemkey() {
		return systemkey;
	}

	public void setSystemkey(java.lang.String systemkey) {
		this.systemkey = systemkey;
	}

	public java.lang.String getHanNm() {
		return hanNm;
	}

	public void setHanNm(java.lang.String hanNm) {
		this.hanNm = hanNm;
	}

	public java.lang.String getResnRegnNum() {
		return resnRegnNum;
	}

	public void setResnRegnNum(java.lang.String resnRegnNum) {
		this.resnRegnNum = resnRegnNum;
	}

	public java.lang.String getSecResnNum() {
		return secResnNum;
	}

	public void setSecResnNum(java.lang.String secResnNum) {
		this.secResnNum = secResnNum;
	}

	public java.lang.String getDilnlazYrMnth() {
		return dilnlazYrMnth;
	}

	public void setDilnlazYrMnth(java.lang.String dilnlazYrMnth) {
		this.dilnlazYrMnth = dilnlazYrMnth;
	}

	public java.lang.String getPayCd() {
		return payCd;
	}

	public void setPayCd(java.lang.String payCd) {
		this.payCd = payCd;
	}

	public java.lang.String getDilnlazApptnDt() {
		return dilnlazApptnDt;
	}

	public void setDilnlazApptnDt(java.lang.String dilnlazApptnDt) {
		this.dilnlazApptnDt = dilnlazApptnDt;
	}

	public java.lang.String getDilnlazDutyTm() {
		return dilnlazDutyTm;
	}

	public void setDilnlazDutyTm(java.lang.String dilnlazDutyTm) {
		this.dilnlazDutyTm = dilnlazDutyTm;
	}

	public java.lang.String getDilnlazDutyYn() {
		return dilnlazDutyYn;
	}

	public void setDilnlazDutyYn(java.lang.String dilnlazDutyYn) {
		this.dilnlazDutyYn = dilnlazDutyYn;
	}

	public java.lang.String getDilnlazAbnceYn() {
		return dilnlazAbnceYn;
	}

	public void setDilnlazAbnceYn(java.lang.String dilnlazAbnceYn) {
		this.dilnlazAbnceYn = dilnlazAbnceYn;
	}

	public java.lang.String getDilnlazLvsgYn() {
		return dilnlazLvsgYn;
	}

	public void setDilnlazLvsgYn(java.lang.String dilnlazLvsgYn) {
		this.dilnlazLvsgYn = dilnlazLvsgYn;
	}

	public java.lang.String getDilnlazSckleaYn() {
		return dilnlazSckleaYn;
	}

	public void setDilnlazSckleaYn(java.lang.String dilnlazSckleaYn) {
		this.dilnlazSckleaYn = dilnlazSckleaYn;
	}

	public java.lang.String getDilnlazOffvaYn() {
		return dilnlazOffvaYn;
	}

	public void setDilnlazOffvaYn(java.lang.String dilnlazOffvaYn) {
		this.dilnlazOffvaYn = dilnlazOffvaYn;
	}

	public java.lang.String getDilnlazFmlyEvntYn() {
		return dilnlazFmlyEvntYn;
	}

	public void setDilnlazFmlyEvntYn(java.lang.String dilnlazFmlyEvntYn) {
		this.dilnlazFmlyEvntYn = dilnlazFmlyEvntYn;
	}

	public java.lang.String getDilnlazHlthCreYn() {
		return dilnlazHlthCreYn;
	}

	public void setDilnlazHlthCreYn(java.lang.String dilnlazHlthCreYn) {
		this.dilnlazHlthCreYn = dilnlazHlthCreYn;
	}

	public java.lang.String getDilnlazAbnceDutyRcgtnYn() {
		return dilnlazAbnceDutyRcgtnYn;
	}

	public void setDilnlazAbnceDutyRcgtnYn(java.lang.String dilnlazAbnceDutyRcgtnYn) {
		this.dilnlazAbnceDutyRcgtnYn = dilnlazAbnceDutyRcgtnYn;
	}

	public java.lang.String getKybdr() {
		return kybdr;
	}

	public void setKybdr(java.lang.String kybdr) {
		this.kybdr = kybdr;
	}

	public java.lang.String getInptDt() {
		return inptDt;
	}

	public void setInptDt(java.lang.String inptDt) {
		this.inptDt = inptDt;
	}

	public java.lang.String getInptAddr() {
		return inptAddr;
	}

	public void setInptAddr(java.lang.String inptAddr) {
		this.inptAddr = inptAddr;
	}

	public java.lang.String getIsmt() {
		return ismt;
	}

	public void setIsmt(java.lang.String ismt) {
		this.ismt = ismt;
	}

	public java.lang.String getRevnDt() {
		return revnDt;
	}

	public void setRevnDt(java.lang.String revnDt) {
		this.revnDt = revnDt;
	}

	public java.lang.String getRevnAddr() {
		return revnAddr;
	}

	public void setRevnAddr(java.lang.String revnAddr) {
		this.revnAddr = revnAddr;
	}

	public java.lang.String getDilnlazSpclHodyYn() {
		return dilnlazSpclHodyYn;
	}

	public void setDilnlazSpclHodyYn(java.lang.String dilnlazSpclHodyYn) {
		this.dilnlazSpclHodyYn = dilnlazSpclHodyYn;
	}

	public java.lang.String getDilnlazTfcAssCstYn() {
		return dilnlazTfcAssCstYn;
	}

	public void setDilnlazTfcAssCstYn(java.lang.String dilnlazTfcAssCstYn) {
		this.dilnlazTfcAssCstYn = dilnlazTfcAssCstYn;
	}

	public java.lang.String getDilnlazLnchYn() {
		return dilnlazLnchYn;
	}

	public void setDilnlazLnchYn(java.lang.String dilnlazLnchYn) {
		this.dilnlazLnchYn = dilnlazLnchYn;
	}

	public java.lang.String getDilnlazHodyYn() {
		return dilnlazHodyYn;
	}

	public void setDilnlazHodyYn(java.lang.String dilnlazHodyYn) {
		this.dilnlazHodyYn = dilnlazHodyYn;
	}

	public java.lang.String getDilnlazEtcDivCd() {
		return dilnlazEtcDivCd;
	}

	public void setDilnlazEtcDivCd(java.lang.String dilnlazEtcDivCd) {
		this.dilnlazEtcDivCd = dilnlazEtcDivCd;
	}

	public java.lang.String getDilnlazDutyBgnnDt() {
		return dilnlazDutyBgnnDt;
	}

	public void setDilnlazDutyBgnnDt(java.lang.String dilnlazDutyBgnnDt) {
		this.dilnlazDutyBgnnDt = dilnlazDutyBgnnDt;
	}

	public java.lang.String getDilnlazDutyEndDt() {
		return dilnlazDutyEndDt;
	}

	public void setDilnlazDutyEndDt(java.lang.String dilnlazDutyEndDt) {
		this.dilnlazDutyEndDt = dilnlazDutyEndDt;
	}

	public java.lang.String getKubn1() {
		return kubn1;
	}

	public void setKubn1(java.lang.String kubn1) {
		this.kubn1 = kubn1;
	}

	public java.lang.String getKubn2() {
		return kubn2;
	}

	public void setKubn2(java.lang.String kubn2) {
		this.kubn2 = kubn2;
	}

	public java.lang.String getKubn3() {
		return kubn3;
	}

	public void setKubn3(java.lang.String kubn3) {
		this.kubn3 = kubn3;
	}

	public java.lang.String getKubn4() {
		return kubn4;
	}

	public void setKubn4(java.lang.String kubn4) {
		this.kubn4 = kubn4;
	}

	public java.lang.String getKubn5() {
		return kubn5;
	}

	public void setKubn5(java.lang.String kubn5) {
		this.kubn5 = kubn5;
	}

	public java.lang.String getKubn6() {
		return kubn6;
	}

	public void setKubn6(java.lang.String kubn6) {
		this.kubn6 = kubn6;
	}

	public java.lang.String getKubn7() {
		return kubn7;
	}

	public void setKubn7(java.lang.String kubn7) {
		this.kubn7 = kubn7;
	}

	public java.lang.String getKubn8() {
		return kubn8;
	}

	public void setKubn8(java.lang.String kubn8) {
		this.kubn8 = kubn8;
	}

	public java.lang.String getKubn9() {
		return kubn9;
	}

	public void setKubn9(java.lang.String kubn9) {
		this.kubn9 = kubn9;
	}

	public java.lang.String getKubn10() {
		return kubn10;
	}

	public void setKubn10(java.lang.String kubn10) {
		this.kubn10 = kubn10;
	}

	public java.lang.String getKubn11() {
		return kubn11;
	}

	public void setKubn11(java.lang.String kubn11) {
		this.kubn11 = kubn11;
	}

	public java.lang.String getKubn12() {
		return kubn12;
	}

	public void setKubn12(java.lang.String kubn12) {
		this.kubn12 = kubn12;
	}

	public java.lang.String getKubn13() {
		return kubn13;
	}

	public void setKubn13(java.lang.String kubn13) {
		this.kubn13 = kubn13;
	}

	public java.lang.String getKubn14() {
		return kubn14;
	}

	public void setKubn14(java.lang.String kubn14) {
		this.kubn14 = kubn14;
	}

	public java.lang.String getKubn15() {
		return kubn15;
	}

	public void setKubn15(java.lang.String kubn15) {
		this.kubn15 = kubn15;
	}

	public java.lang.String getKubn16() {
		return kubn16;
	}

	public void setKubn16(java.lang.String kubn16) {
		this.kubn16 = kubn16;
	}

	public java.lang.String getKubn17() {
		return kubn17;
	}

	public void setKubn17(java.lang.String kubn17) {
		this.kubn17 = kubn17;
	}

	public java.lang.String getKubn18() {
		return kubn18;
	}

	public void setKubn18(java.lang.String kubn18) {
		this.kubn18 = kubn18;
	}

	public java.lang.String getKubn19() {
		return kubn19;
	}

	public void setKubn19(java.lang.String kubn19) {
		this.kubn19 = kubn19;
	}

	public java.lang.String getKubn20() {
		return kubn20;
	}

	public void setKubn20(java.lang.String kubn20) {
		this.kubn20 = kubn20;
	}

	public java.lang.String getKubn21() {
		return kubn21;
	}

	public void setKubn21(java.lang.String kubn21) {
		this.kubn21 = kubn21;
	}

	public java.lang.String getKubn22() {
		return kubn22;
	}

	public void setKubn22(java.lang.String kubn22) {
		this.kubn22 = kubn22;
	}

	public java.lang.String getKubn23() {
		return kubn23;
	}

	public void setKubn23(java.lang.String kubn23) {
		this.kubn23 = kubn23;
	}

	public java.lang.String getKubn24() {
		return kubn24;
	}

	public void setKubn24(java.lang.String kubn24) {
		this.kubn24 = kubn24;
	}

	public java.lang.String getKubn25() {
		return kubn25;
	}

	public void setKubn25(java.lang.String kubn25) {
		this.kubn25 = kubn25;
	}

	public java.lang.String getKubn26() {
		return kubn26;
	}

	public void setKubn26(java.lang.String kubn26) {
		this.kubn26 = kubn26;
	}

	public java.lang.String getKubn27() {
		return kubn27;
	}

	public void setKubn27(java.lang.String kubn27) {
		this.kubn27 = kubn27;
	}

	public java.lang.String getKubn28() {
		return kubn28;
	}

	public void setKubn28(java.lang.String kubn28) {
		this.kubn28 = kubn28;
	}

	public java.lang.String getKubn29() {
		return kubn29;
	}

	public void setKubn29(java.lang.String kubn29) {
		this.kubn29 = kubn29;
	}

	public java.lang.String getKubn30() {
		return kubn30;
	}

	public void setKubn30(java.lang.String kubn30) {
		this.kubn30 = kubn30;
	}

	public java.lang.String getKubn31() {
		return kubn31;
	}

	public void setKubn31(java.lang.String kubn31) {
		this.kubn31 = kubn31;
	}

	public java.lang.String getDilnlazDutyTm1() {
		return dilnlazDutyTm1;
	}

	public void setDilnlazDutyTm1(java.lang.String dilnlazDutyTm1) {
		this.dilnlazDutyTm1 = dilnlazDutyTm1;
	}

	public java.lang.String getDilnlazDutyTm2() {
		return dilnlazDutyTm2;
	}

	public void setDilnlazDutyTm2(java.lang.String dilnlazDutyTm2) {
		this.dilnlazDutyTm2 = dilnlazDutyTm2;
	}

	public java.lang.String getDilnlazDutyTm3() {
		return dilnlazDutyTm3;
	}

	public void setDilnlazDutyTm3(java.lang.String dilnlazDutyTm3) {
		this.dilnlazDutyTm3 = dilnlazDutyTm3;
	}

	public java.lang.String getDilnlazDutyTm4() {
		return dilnlazDutyTm4;
	}

	public void setDilnlazDutyTm4(java.lang.String dilnlazDutyTm4) {
		this.dilnlazDutyTm4 = dilnlazDutyTm4;
	}

	public java.lang.String getDilnlazDutyTm5() {
		return dilnlazDutyTm5;
	}

	public void setDilnlazDutyTm5(java.lang.String dilnlazDutyTm5) {
		this.dilnlazDutyTm5 = dilnlazDutyTm5;
	}

	public java.lang.String getDilnlazDutyTm6() {
		return dilnlazDutyTm6;
	}

	public void setDilnlazDutyTm6(java.lang.String dilnlazDutyTm6) {
		this.dilnlazDutyTm6 = dilnlazDutyTm6;
	}

	public java.lang.String getDilnlazDutyTm7() {
		return dilnlazDutyTm7;
	}

	public void setDilnlazDutyTm7(java.lang.String dilnlazDutyTm7) {
		this.dilnlazDutyTm7 = dilnlazDutyTm7;
	}

	public java.lang.String getDilnlazDutyTm8() {
		return dilnlazDutyTm8;
	}

	public void setDilnlazDutyTm8(java.lang.String dilnlazDutyTm8) {
		this.dilnlazDutyTm8 = dilnlazDutyTm8;
	}

	public java.lang.String getDilnlazDutyTm9() {
		return dilnlazDutyTm9;
	}

	public void setDilnlazDutyTm9(java.lang.String dilnlazDutyTm9) {
		this.dilnlazDutyTm9 = dilnlazDutyTm9;
	}

	public java.lang.String getDilnlazDutyTm10() {
		return dilnlazDutyTm10;
	}

	public void setDilnlazDutyTm10(java.lang.String dilnlazDutyTm10) {
		this.dilnlazDutyTm10 = dilnlazDutyTm10;
	}

	public java.lang.String getDilnlazDutyTm11() {
		return dilnlazDutyTm11;
	}

	public void setDilnlazDutyTm11(java.lang.String dilnlazDutyTm11) {
		this.dilnlazDutyTm11 = dilnlazDutyTm11;
	}

	public java.lang.String getDilnlazDutyTm12() {
		return dilnlazDutyTm12;
	}

	public void setDilnlazDutyTm12(java.lang.String dilnlazDutyTm12) {
		this.dilnlazDutyTm12 = dilnlazDutyTm12;
	}

	public java.lang.String getDilnlazDutyTm13() {
		return dilnlazDutyTm13;
	}

	public void setDilnlazDutyTm13(java.lang.String dilnlazDutyTm13) {
		this.dilnlazDutyTm13 = dilnlazDutyTm13;
	}

	public java.lang.String getDilnlazDutyTm14() {
		return dilnlazDutyTm14;
	}

	public void setDilnlazDutyTm14(java.lang.String dilnlazDutyTm14) {
		this.dilnlazDutyTm14 = dilnlazDutyTm14;
	}

	public java.lang.String getDilnlazDutyTm15() {
		return dilnlazDutyTm15;
	}

	public void setDilnlazDutyTm15(java.lang.String dilnlazDutyTm15) {
		this.dilnlazDutyTm15 = dilnlazDutyTm15;
	}

	public java.lang.String getDilnlazDutyTm16() {
		return dilnlazDutyTm16;
	}

	public void setDilnlazDutyTm16(java.lang.String dilnlazDutyTm16) {
		this.dilnlazDutyTm16 = dilnlazDutyTm16;
	}

	public java.lang.String getDilnlazDutyTm17() {
		return dilnlazDutyTm17;
	}

	public void setDilnlazDutyTm17(java.lang.String dilnlazDutyTm17) {
		this.dilnlazDutyTm17 = dilnlazDutyTm17;
	}

	public java.lang.String getDilnlazDutyTm18() {
		return dilnlazDutyTm18;
	}

	public void setDilnlazDutyTm18(java.lang.String dilnlazDutyTm18) {
		this.dilnlazDutyTm18 = dilnlazDutyTm18;
	}

	public java.lang.String getDilnlazDutyTm19() {
		return dilnlazDutyTm19;
	}

	public void setDilnlazDutyTm19(java.lang.String dilnlazDutyTm19) {
		this.dilnlazDutyTm19 = dilnlazDutyTm19;
	}

	public java.lang.String getDilnlazDutyTm20() {
		return dilnlazDutyTm20;
	}

	public void setDilnlazDutyTm20(java.lang.String dilnlazDutyTm20) {
		this.dilnlazDutyTm20 = dilnlazDutyTm20;
	}

	public java.lang.String getDilnlazDutyTm21() {
		return dilnlazDutyTm21;
	}

	public void setDilnlazDutyTm21(java.lang.String dilnlazDutyTm21) {
		this.dilnlazDutyTm21 = dilnlazDutyTm21;
	}

	public java.lang.String getDilnlazDutyTm22() {
		return dilnlazDutyTm22;
	}

	public void setDilnlazDutyTm22(java.lang.String dilnlazDutyTm22) {
		this.dilnlazDutyTm22 = dilnlazDutyTm22;
	}

	public java.lang.String getDilnlazDutyTm23() {
		return dilnlazDutyTm23;
	}

	public void setDilnlazDutyTm23(java.lang.String dilnlazDutyTm23) {
		this.dilnlazDutyTm23 = dilnlazDutyTm23;
	}

	public java.lang.String getDilnlazDutyTm24() {
		return dilnlazDutyTm24;
	}

	public void setDilnlazDutyTm24(java.lang.String dilnlazDutyTm24) {
		this.dilnlazDutyTm24 = dilnlazDutyTm24;
	}

	public java.lang.String getDilnlazDutyTm25() {
		return dilnlazDutyTm25;
	}

	public void setDilnlazDutyTm25(java.lang.String dilnlazDutyTm25) {
		this.dilnlazDutyTm25 = dilnlazDutyTm25;
	}

	public java.lang.String getDilnlazDutyTm26() {
		return dilnlazDutyTm26;
	}

	public void setDilnlazDutyTm26(java.lang.String dilnlazDutyTm26) {
		this.dilnlazDutyTm26 = dilnlazDutyTm26;
	}

	public java.lang.String getDilnlazDutyTm27() {
		return dilnlazDutyTm27;
	}

	public void setDilnlazDutyTm27(java.lang.String dilnlazDutyTm27) {
		this.dilnlazDutyTm27 = dilnlazDutyTm27;
	}

	public java.lang.String getDilnlazDutyTm28() {
		return dilnlazDutyTm28;
	}

	public void setDilnlazDutyTm28(java.lang.String dilnlazDutyTm28) {
		this.dilnlazDutyTm28 = dilnlazDutyTm28;
	}

	public java.lang.String getDilnlazDutyTm29() {
		return dilnlazDutyTm29;
	}

	public void setDilnlazDutyTm29(java.lang.String dilnlazDutyTm29) {
		this.dilnlazDutyTm29 = dilnlazDutyTm29;
	}

	public java.lang.String getDilnlazDutyTm30() {
		return dilnlazDutyTm30;
	}

	public void setDilnlazDutyTm30(java.lang.String dilnlazDutyTm30) {
		this.dilnlazDutyTm30 = dilnlazDutyTm30;
	}

	public java.lang.String getDilnlazDutyTm31() {
		return dilnlazDutyTm31;
	}

	public void setDilnlazDutyTm31(java.lang.String dilnlazDutyTm31) {
		this.dilnlazDutyTm31 = dilnlazDutyTm31;
	}

	public java.lang.String getDilnlazStTm() {
		return dilnlazStTm;
	}

	public void setDilnlazStTm(java.lang.String dilnlazStTm) {
		this.dilnlazStTm = dilnlazStTm;
	}

	public java.lang.String getDilnlazEdTm() {
		return dilnlazEdTm;
	}

	public void setDilnlazEdTm(java.lang.String dilnlazEdTm) {
		this.dilnlazEdTm = dilnlazEdTm;
	}

	public java.lang.String getDilnlazStTm1() {
		return dilnlazStTm1;
	}

	public void setDilnlazStTm1(java.lang.String dilnlazStTm1) {
		this.dilnlazStTm1 = dilnlazStTm1;
	}

	public java.lang.String getDilnlazStTm2() {
		return dilnlazStTm2;
	}

	public void setDilnlazStTm2(java.lang.String dilnlazStTm2) {
		this.dilnlazStTm2 = dilnlazStTm2;
	}

	public java.lang.String getDilnlazStTm3() {
		return dilnlazStTm3;
	}

	public void setDilnlazStTm3(java.lang.String dilnlazStTm3) {
		this.dilnlazStTm3 = dilnlazStTm3;
	}

	public java.lang.String getDilnlazStTm4() {
		return dilnlazStTm4;
	}

	public void setDilnlazStTm4(java.lang.String dilnlazStTm4) {
		this.dilnlazStTm4 = dilnlazStTm4;
	}

	public java.lang.String getDilnlazStTm5() {
		return dilnlazStTm5;
	}

	public void setDilnlazStTm5(java.lang.String dilnlazStTm5) {
		this.dilnlazStTm5 = dilnlazStTm5;
	}

	public java.lang.String getDilnlazStTm6() {
		return dilnlazStTm6;
	}

	public void setDilnlazStTm6(java.lang.String dilnlazStTm6) {
		this.dilnlazStTm6 = dilnlazStTm6;
	}

	public java.lang.String getDilnlazStTm7() {
		return dilnlazStTm7;
	}

	public void setDilnlazStTm7(java.lang.String dilnlazStTm7) {
		this.dilnlazStTm7 = dilnlazStTm7;
	}

	public java.lang.String getDilnlazStTm8() {
		return dilnlazStTm8;
	}

	public void setDilnlazStTm8(java.lang.String dilnlazStTm8) {
		this.dilnlazStTm8 = dilnlazStTm8;
	}

	public java.lang.String getDilnlazStTm9() {
		return dilnlazStTm9;
	}

	public void setDilnlazStTm9(java.lang.String dilnlazStTm9) {
		this.dilnlazStTm9 = dilnlazStTm9;
	}

	public java.lang.String getDilnlazStTm10() {
		return dilnlazStTm10;
	}

	public void setDilnlazStTm10(java.lang.String dilnlazStTm10) {
		this.dilnlazStTm10 = dilnlazStTm10;
	}

	public java.lang.String getDilnlazStTm11() {
		return dilnlazStTm11;
	}

	public void setDilnlazStTm11(java.lang.String dilnlazStTm11) {
		this.dilnlazStTm11 = dilnlazStTm11;
	}

	public java.lang.String getDilnlazStTm12() {
		return dilnlazStTm12;
	}

	public void setDilnlazStTm12(java.lang.String dilnlazStTm12) {
		this.dilnlazStTm12 = dilnlazStTm12;
	}

	public java.lang.String getDilnlazStTm13() {
		return dilnlazStTm13;
	}

	public void setDilnlazStTm13(java.lang.String dilnlazStTm13) {
		this.dilnlazStTm13 = dilnlazStTm13;
	}

	public java.lang.String getDilnlazStTm14() {
		return dilnlazStTm14;
	}

	public void setDilnlazStTm14(java.lang.String dilnlazStTm14) {
		this.dilnlazStTm14 = dilnlazStTm14;
	}

	public java.lang.String getDilnlazStTm15() {
		return dilnlazStTm15;
	}

	public void setDilnlazStTm15(java.lang.String dilnlazStTm15) {
		this.dilnlazStTm15 = dilnlazStTm15;
	}

	public java.lang.String getDilnlazStTm16() {
		return dilnlazStTm16;
	}

	public void setDilnlazStTm16(java.lang.String dilnlazStTm16) {
		this.dilnlazStTm16 = dilnlazStTm16;
	}

	public java.lang.String getDilnlazStTm17() {
		return dilnlazStTm17;
	}

	public void setDilnlazStTm17(java.lang.String dilnlazStTm17) {
		this.dilnlazStTm17 = dilnlazStTm17;
	}

	public java.lang.String getDilnlazStTm18() {
		return dilnlazStTm18;
	}

	public void setDilnlazStTm18(java.lang.String dilnlazStTm18) {
		this.dilnlazStTm18 = dilnlazStTm18;
	}

	public java.lang.String getDilnlazStTm19() {
		return dilnlazStTm19;
	}

	public void setDilnlazStTm19(java.lang.String dilnlazStTm19) {
		this.dilnlazStTm19 = dilnlazStTm19;
	}

	public java.lang.String getDilnlazStTm20() {
		return dilnlazStTm20;
	}

	public void setDilnlazStTm20(java.lang.String dilnlazStTm20) {
		this.dilnlazStTm20 = dilnlazStTm20;
	}

	public java.lang.String getDilnlazStTm21() {
		return dilnlazStTm21;
	}

	public void setDilnlazStTm21(java.lang.String dilnlazStTm21) {
		this.dilnlazStTm21 = dilnlazStTm21;
	}

	public java.lang.String getDilnlazStTm22() {
		return dilnlazStTm22;
	}

	public void setDilnlazStTm22(java.lang.String dilnlazStTm22) {
		this.dilnlazStTm22 = dilnlazStTm22;
	}

	public java.lang.String getDilnlazStTm23() {
		return dilnlazStTm23;
	}

	public void setDilnlazStTm23(java.lang.String dilnlazStTm23) {
		this.dilnlazStTm23 = dilnlazStTm23;
	}

	public java.lang.String getDilnlazStTm24() {
		return dilnlazStTm24;
	}

	public void setDilnlazStTm24(java.lang.String dilnlazStTm24) {
		this.dilnlazStTm24 = dilnlazStTm24;
	}

	public java.lang.String getDilnlazStTm25() {
		return dilnlazStTm25;
	}

	public void setDilnlazStTm25(java.lang.String dilnlazStTm25) {
		this.dilnlazStTm25 = dilnlazStTm25;
	}

	public java.lang.String getDilnlazStTm26() {
		return dilnlazStTm26;
	}

	public void setDilnlazStTm26(java.lang.String dilnlazStTm26) {
		this.dilnlazStTm26 = dilnlazStTm26;
	}

	public java.lang.String getDilnlazStTm27() {
		return dilnlazStTm27;
	}

	public void setDilnlazStTm27(java.lang.String dilnlazStTm27) {
		this.dilnlazStTm27 = dilnlazStTm27;
	}

	public java.lang.String getDilnlazStTm28() {
		return dilnlazStTm28;
	}

	public void setDilnlazStTm28(java.lang.String dilnlazStTm28) {
		this.dilnlazStTm28 = dilnlazStTm28;
	}

	public java.lang.String getDilnlazStTm29() {
		return dilnlazStTm29;
	}

	public void setDilnlazStTm29(java.lang.String dilnlazStTm29) {
		this.dilnlazStTm29 = dilnlazStTm29;
	}

	public java.lang.String getDilnlazStTm30() {
		return dilnlazStTm30;
	}

	public void setDilnlazStTm30(java.lang.String dilnlazStTm30) {
		this.dilnlazStTm30 = dilnlazStTm30;
	}

	public java.lang.String getDilnlazStTm31() {
		return dilnlazStTm31;
	}

	public void setDilnlazStTm31(java.lang.String dilnlazStTm31) {
		this.dilnlazStTm31 = dilnlazStTm31;
	}

	public java.lang.String getDilnlazEdTm1() {
		return dilnlazEdTm1;
	}

	public void setDilnlazEdTm1(java.lang.String dilnlazEdTm1) {
		this.dilnlazEdTm1 = dilnlazEdTm1;
	}

	public java.lang.String getDilnlazEdTm2() {
		return dilnlazEdTm2;
	}

	public void setDilnlazEdTm2(java.lang.String dilnlazEdTm2) {
		this.dilnlazEdTm2 = dilnlazEdTm2;
	}

	public java.lang.String getDilnlazEdTm3() {
		return dilnlazEdTm3;
	}

	public void setDilnlazEdTm3(java.lang.String dilnlazEdTm3) {
		this.dilnlazEdTm3 = dilnlazEdTm3;
	}

	public java.lang.String getDilnlazEdTm4() {
		return dilnlazEdTm4;
	}

	public void setDilnlazEdTm4(java.lang.String dilnlazEdTm4) {
		this.dilnlazEdTm4 = dilnlazEdTm4;
	}

	public java.lang.String getDilnlazEdTm5() {
		return dilnlazEdTm5;
	}

	public void setDilnlazEdTm5(java.lang.String dilnlazEdTm5) {
		this.dilnlazEdTm5 = dilnlazEdTm5;
	}

	public java.lang.String getDilnlazEdTm6() {
		return dilnlazEdTm6;
	}

	public void setDilnlazEdTm6(java.lang.String dilnlazEdTm6) {
		this.dilnlazEdTm6 = dilnlazEdTm6;
	}

	public java.lang.String getDilnlazEdTm7() {
		return dilnlazEdTm7;
	}

	public void setDilnlazEdTm7(java.lang.String dilnlazEdTm7) {
		this.dilnlazEdTm7 = dilnlazEdTm7;
	}

	public java.lang.String getDilnlazEdTm8() {
		return dilnlazEdTm8;
	}

	public void setDilnlazEdTm8(java.lang.String dilnlazEdTm8) {
		this.dilnlazEdTm8 = dilnlazEdTm8;
	}

	public java.lang.String getDilnlazEdTm9() {
		return dilnlazEdTm9;
	}

	public void setDilnlazEdTm9(java.lang.String dilnlazEdTm9) {
		this.dilnlazEdTm9 = dilnlazEdTm9;
	}

	public java.lang.String getDilnlazEdTm10() {
		return dilnlazEdTm10;
	}

	public void setDilnlazEdTm10(java.lang.String dilnlazEdTm10) {
		this.dilnlazEdTm10 = dilnlazEdTm10;
	}

	public java.lang.String getDilnlazEdTm11() {
		return dilnlazEdTm11;
	}

	public void setDilnlazEdTm11(java.lang.String dilnlazEdTm11) {
		this.dilnlazEdTm11 = dilnlazEdTm11;
	}

	public java.lang.String getDilnlazEdTm12() {
		return dilnlazEdTm12;
	}

	public void setDilnlazEdTm12(java.lang.String dilnlazEdTm12) {
		this.dilnlazEdTm12 = dilnlazEdTm12;
	}

	public java.lang.String getDilnlazEdTm13() {
		return dilnlazEdTm13;
	}

	public void setDilnlazEdTm13(java.lang.String dilnlazEdTm13) {
		this.dilnlazEdTm13 = dilnlazEdTm13;
	}

	public java.lang.String getDilnlazEdTm14() {
		return dilnlazEdTm14;
	}

	public void setDilnlazEdTm14(java.lang.String dilnlazEdTm14) {
		this.dilnlazEdTm14 = dilnlazEdTm14;
	}

	public java.lang.String getDilnlazEdTm15() {
		return dilnlazEdTm15;
	}

	public void setDilnlazEdTm15(java.lang.String dilnlazEdTm15) {
		this.dilnlazEdTm15 = dilnlazEdTm15;
	}

	public java.lang.String getDilnlazEdTm16() {
		return dilnlazEdTm16;
	}

	public void setDilnlazEdTm16(java.lang.String dilnlazEdTm16) {
		this.dilnlazEdTm16 = dilnlazEdTm16;
	}

	public java.lang.String getDilnlazEdTm17() {
		return dilnlazEdTm17;
	}

	public void setDilnlazEdTm17(java.lang.String dilnlazEdTm17) {
		this.dilnlazEdTm17 = dilnlazEdTm17;
	}

	public java.lang.String getDilnlazEdTm18() {
		return dilnlazEdTm18;
	}

	public void setDilnlazEdTm18(java.lang.String dilnlazEdTm18) {
		this.dilnlazEdTm18 = dilnlazEdTm18;
	}

	public java.lang.String getDilnlazEdTm19() {
		return dilnlazEdTm19;
	}

	public void setDilnlazEdTm19(java.lang.String dilnlazEdTm19) {
		this.dilnlazEdTm19 = dilnlazEdTm19;
	}

	public java.lang.String getDilnlazEdTm20() {
		return dilnlazEdTm20;
	}

	public void setDilnlazEdTm20(java.lang.String dilnlazEdTm20) {
		this.dilnlazEdTm20 = dilnlazEdTm20;
	}

	public java.lang.String getDilnlazEdTm21() {
		return dilnlazEdTm21;
	}

	public void setDilnlazEdTm21(java.lang.String dilnlazEdTm21) {
		this.dilnlazEdTm21 = dilnlazEdTm21;
	}

	public java.lang.String getDilnlazEdTm22() {
		return dilnlazEdTm22;
	}

	public void setDilnlazEdTm22(java.lang.String dilnlazEdTm22) {
		this.dilnlazEdTm22 = dilnlazEdTm22;
	}

	public java.lang.String getDilnlazEdTm23() {
		return dilnlazEdTm23;
	}

	public void setDilnlazEdTm23(java.lang.String dilnlazEdTm23) {
		this.dilnlazEdTm23 = dilnlazEdTm23;
	}

	public java.lang.String getDilnlazEdTm24() {
		return dilnlazEdTm24;
	}

	public void setDilnlazEdTm24(java.lang.String dilnlazEdTm24) {
		this.dilnlazEdTm24 = dilnlazEdTm24;
	}

	public java.lang.String getDilnlazEdTm25() {
		return dilnlazEdTm25;
	}

	public void setDilnlazEdTm25(java.lang.String dilnlazEdTm25) {
		this.dilnlazEdTm25 = dilnlazEdTm25;
	}

	public java.lang.String getDilnlazEdTm26() {
		return dilnlazEdTm26;
	}

	public void setDilnlazEdTm26(java.lang.String dilnlazEdTm26) {
		this.dilnlazEdTm26 = dilnlazEdTm26;
	}

	public java.lang.String getDilnlazEdTm27() {
		return dilnlazEdTm27;
	}

	public void setDilnlazEdTm27(java.lang.String dilnlazEdTm27) {
		this.dilnlazEdTm27 = dilnlazEdTm27;
	}

	public java.lang.String getDilnlazEdTm28() {
		return dilnlazEdTm28;
	}

	public void setDilnlazEdTm28(java.lang.String dilnlazEdTm28) {
		this.dilnlazEdTm28 = dilnlazEdTm28;
	}

	public java.lang.String getDilnlazEdTm29() {
		return dilnlazEdTm29;
	}

	public void setDilnlazEdTm29(java.lang.String dilnlazEdTm29) {
		this.dilnlazEdTm29 = dilnlazEdTm29;
	}

	public java.lang.String getDilnlazEdTm30() {
		return dilnlazEdTm30;
	}

	public void setDilnlazEdTm30(java.lang.String dilnlazEdTm30) {
		this.dilnlazEdTm30 = dilnlazEdTm30;
	}

	public java.lang.String getDilnlazEdTm31() {
		return dilnlazEdTm31;
	}

	public void setDilnlazEdTm31(java.lang.String dilnlazEdTm31) {
		this.dilnlazEdTm31 = dilnlazEdTm31;
	}
  
	
}
