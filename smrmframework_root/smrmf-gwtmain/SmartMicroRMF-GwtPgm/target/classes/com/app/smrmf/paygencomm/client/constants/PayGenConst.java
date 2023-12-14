/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.paygencomm.client.constants;

import java.util.Date;

import com.google.gwt.i18n.client.DateTimeFormat;


public class PayGenConst {
	
	
	//화면 상단 프로그램 명 공통처리 
	public static  final String  PAYGEN_VERSION = "PayGen Ver1.0";

    //급여구분
    public static  final String PAY_CD_01 = "B0150000";     //월급여 
    public static  final String PAY_CD_02 = "B0150001";     //복리후생비  
    public static  final String PAY_CD_03 = "B0150002";     //월급여 2회차   
    public static  final String PAY_CD_04 = "B0150003";     //명절휴가비  
    public static  final String PAY_CD_05 = "B0150004";     //초과근무수당    
    public static  final String PAY_CD_06 = "B0150005";     //연가보상비 
    public static  final String PAY_CD_07 = "B0150006";     //초과근무수당(12월)
    
    //주소정근로시간 
    public final String USR_WEEK_WORK_TIME = "40";
    
  //payr5500 
    //직책별 수당에 따른 그리드 처리를 위한 값 선언 
    public static final String PAYR5500_PYMT_01 = "C9210100";    // 장려수당
    public static final String PAYR5500_PYMT_02 = "C9220100";    // 특수업무수당
    public static final String PAYR5500_PYMT_03 = "C9310100";    // 위생수당
    public static final String PAYR5500_PYMT_04 = "C9310200";    // 대민활동비
    public static final String PAYR5500_PYMT_05 = "C9999200";    // 선임인력수당
    
    //payr5600 
    //항목별 수당에 따른 그리드 처리를 위한 값 선언 
    public static final String PAYR5600_PYMT_01 = "C9010200";    // 장기근속수당
    public static final String PAYR5600_PYMT_02 = "C9030100";    // 정근수당
    public static final String PAYR5600_PYMT_03 = "C9050100";    // 가족수당
    public static final String PAYR5600_PYMT_04 = "C9060100";    // 학비보조수당 
    
    //T0010100	B0080040	B0250370	소득세
    public static final String PAYR4200_DDUC_01 = "T0010100";    // 소득세
    
   // T0020100	B0080040	B0250380	지방소득세
    public static final String PAYR4200_DDUC_02 = "T0020100";    // 지방소득세 


    public static  final String PYMT_DDUC_DIV_CD_01 = "B0080010";     //기본급
    public static  final String PYMT_DDUC_DIV_CD_02 = "B0080020";      //수당 
    public static  final String PYMT_DDUC_DIV_CD_03 = "B0080030";      //공제 
    public static  final String PYMT_DDUC_DIV_CD_04 = "B0080040";      //세금 
    
    public static  final String HDOFC_CODTN_CD_01 = "A0030010";      //재직상태코드 
    public static  final String HDOFC_CODTN_CD_02 = "A0030020";      //재직상태코드 
    public static  final String HDOFC_CODTN_CD_03 = "A0030030";      //재직상태코드 
    
    public static  final int FRM_COMBO_WIDTH_100 = 100;      //부서코드 콤보박스 셋팅  
    public static  final int FRM_COMBO_WIDTH_120 = 120;      //부서코드 콤보박스 셋팅  
    public static  final int FRM_COMBO_WIDTH_160 = 160;      //부서코드 콤보박스 셋팅  
    public static  final int FRM_COMBO_WIDTH_200 = 200;      //부서코드 콤보박스 셋팅  
    public static  final int FRM_COMBO_WIDTH_250 = 250;      //부서코드 콤보박스 셋팅  
    public static  final int FRM_COMBO_WIDTH_300 = 300;      //부서코드 콤보박스 셋팅  
    public static  final int FRM_COMBO_WIDTH_350 = 350;      //부서코드 콤보박스 셋팅  
    public static  final int FRM_COMBO_WIDTH_400 = 400;      //부서코드 콤보박스 셋팅  
   
    public static final String PAYR_TAX_B0290020     = "B0290020";  //100%  추가소득세 비율  
     
    //입력폼그리드 색상지정
    public static final String gridBgColor =  "background-color:#F5F6CE;";
    
    
    //리포트 출력물 구분자 
    public static  final String REPORT_DIV_TYPE01 = "REXPERT";      //클립프트 제품군 
    public static  final String REPORT_DIV_TYPE02 = "RDAGENT";      //m2soft  
    
    //TODO 회계년도 임시 처리 
    public static  final String ACC_CURR_YEAR = DateTimeFormat.getFormat("yyyy").format(new Date());     
    
     
}
