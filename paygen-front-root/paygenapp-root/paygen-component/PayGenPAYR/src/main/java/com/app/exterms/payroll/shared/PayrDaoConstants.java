/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.exterms.payroll.shared;

import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;

public interface PayrDaoConstants extends PayrDaoConstantsGenerated {

	
	public static final String CLASS_PAYR1100_DAO_LIST = "com.app.exterms.payroll.server.service.getSelectPayr1100List";	//간이소득세액관리
	public static final String CLASS_PAYR1200_DAO_LIST = "com.app.exterms.payroll.server.service.getSelectPayr1200List";	//직종등급맵핑관리
	public static final String CLASS_PAYR1300_DAO_LIST = "com.app.exterms.payroll.server.service.getSelectPayr13000List";	//급여수당관리
	public static final String CLASS_PAYR1400_DAO_LIST = "com.app.exterms.payroll.server.service.getSelectPayr1400List";	//급여공제관리
	public static final String CLASS_PAYR1500_DAO_LIST = "com.app.exterms.payroll.server.service.getSelectPayr1500List";	//지급공제항목관리(공무직)
	public static final String CLASS_PAYR1700_DAO_LIST = "com.app.exterms.payroll.server.service.Payr1700ServiceImpl.getSelectPayr1700List";	//급여계좌관리
	
	
	public static final String CLASS_PAYR5100_PAYR0425_DATA_LIST = "com.app.exterms.payroll.server.service.Payr5100ServiceImpl.getSelectPayr5100ToPayr0425List";	//단가산정(공무직)
	public static final String CLASS_PAYR5200_PAYR0445_DATA_LIST = "com.app.exterms.payroll.server.service.Payr5200ServiceImpl.getSelectPayr5200ToPayr0445List";	//단가관리(공무직)
	 
	public static final String CLASS_PAYR5300_DAO_LIST = "com.app.exterms.payroll.server.service.getSelectPayr5300List";	//지급공제단가관리(기간제)
	public static final String CLASS_PAYR5500_DAO_LIST = "com.app.exterms.payroll.server.service.getSelectPayr5500List";	//직책별수당관리
	public static final String CLASS_PAYR5600_DAO_LIST = "com.app.exterms.payroll.server.service.getSelectPayr5600List";	//항목별수당관리
	public static final String CLASS_PAYR3100_DAO_LIST = "com.app.exterms.payroll.server.service.getSelectPayr3100List";	//채권압류공제관리
	public static final String CLASS_PAYR3200_DAO_LIST =  "com.app.exterms.payroll.server.service.getSelectPayr3200List";	//개별공제관리
	public static final String CLASS_PAYR4050_DAO_LIST =  "com.app.exterms.payroll.server.service.getSelectPayr40500List";	//급여스케줄관리
	public static final String CLASS_PAYRP4050_DAO_LIST = "com.app.exterms.payroll.server.service.getSelectPayrP4050List";	//개인급여내역
	public static final String CLASS_PAYRP4051_DAO_LIST = "com.app.exterms.payroll.server.service.getSelectPayrP4051List";	//개인전체급여내역
	public static final String CLASS_PAYR4100_DAO_LIST = "com.app.exterms.payroll.server.service.getSelectPayr4100List";	//급여대상자관리
	 
	public static final String CLASS_PAYR4150_DAO_LIST = "com.app.exterms.payroll.server.service.getSelectPayr41500List";	//급여계산관리
	public static final String CLASS_PAYR4200_DAO_LIST = "com.app.exterms.payroll.server.service.getSelectPayr4200List";	//급여(조정)내역관리
	public static final String CLASS_PAYR4210_DAO_LIST = "com.app.exterms.payroll.server.service.getSelectPayr4210List";	//급여소급계산관리
	public static final String CLASS_PAYR4220_DAO_LIST = "com.app.exterms.payroll.server.service.getSelectPayr4220List";	//급여소급내역관리
	public static final String CLASS_PAYR4250_DAO_LIST = "com.app.exterms.payroll.server.service.getSelectPayr4250List";	//급여마감관리
	public static final String CLASS_PAYR4300_DAO_LIST = "com.app.exterms.payroll.server.service.getSelectPayr4300List";	//급여대장
	public static final String CLASS_PAYR4400_DAO_LIST = "com.app.exterms.payroll.server.service.Payr4400ServiceImpl.getSelectPayr4400List";	//급여지로이체명세서
	public static final String CLASS_PAYR4450_DAO_LIST = "com.app.exterms.payroll.server.service.getSelectPayr4450List";	//수당/공제지급명세서
	public static final String CLASS_PAYR4500_DAO_LIST = "com.app.exterms.payroll.server.service.getSelectPayr4500List";	//소득세납부내역
	public static final String CLASS_PAYR4550_DAO_LIST = "com.app.exterms.payroll.server.service.Payr4550ServiceImpl.getSelectPayr4550List";	//근로소득원천징수부
	public static final String CLASS_PAYR4600_DAO_LIST = "com.app.exterms.payroll.server.service.getSelectPayr4600List";	//일용근로소득지급명세서
	
	
	
	
	//콤보처리 lookup
	public static final String CLASS_PAYR0440_PAY_YR = "com.app.exterms.payroll.server.service.Payr5200ServiceImpl.getCboPayr0440PayYrList";
	public static final String CLASS_PAYR0440_UCST_DGM_APPTN_DT = "com.app.exterms.payroll.server.service.Payr5200ServiceImpl.getCboPayr0440UcstDgmApptnDtList";
	
	
	public static final String CLASS_PAYR0420_OCCU_CLSS_PAY_STD = "com.app.exterms.payroll.server.service.Payr5100ServiceImpl.getCboPayr0420OccuClssPayStdList";
	
	public static final String CLASS_PAYR0415_PAY_YR = "com.app.exterms.payroll.server.service.Payr1500ServiceImpl.getCboPayr0415PayYrList";
	
	public static final String CLASS_BASS0500_PAY_YR = "com.app.exterms.payroll.server.service.Payr5300ServiceImpl.getCboBass0500PayYrList";
	
	
	
	public static final String CLASS_PAYR0416_PAY_YR = "com.app.exterms.payroll.server.service.Payr5250ServiceImpl.getCboPayr0416PayYrList";
	
	public static final String CLASS_PAYR0300_PAY_YR = "com.app.exterms.payroll.server.service.Payr4150ServiceImpl.getCboPayr0300PayYrList";
	
	//회차리스트 조회 
	public static final String CLASS_PAYR0360_REATTY_STP_DSPTY_NUM = "com.app.exterms.payroll.server.service.Payr4210ServiceImpl.getCboReattyStpDsptyNumList";
	
	 
	
	public static final String CLASS_PAYR0100_APPTN_YR = "com.app.exterms.payroll.server.service.Payr1100ServiceImpl.getPayr0100ApptnYrList";//근로소득간이세액표
	public static final String CLASS_PAYR0100_APPTN_STD_BGNN_DT = "com.app.exterms.payroll.server.service.Payr1100ServiceImpl.getPayr0100ApptnStdBgnnDtList";
	 
	
	public static final String CLASS_PSNL0123_PAYR4100_DAO_LIST = "com.app.exterms.payroll.server.service.Payr4100ServiceImpl.getSelectPsnl0123ToPayr4100List";//휴직  
	
	
	public static final String CLASS_REMT3500_PAYR4100_DATA_LIST  = "com.app.exterms.payroll.server.service.Payr4100ServiceImpl.getSelectPayr4100ToRemt3500List"; //퇴직정산항목 
	
	
    /** 
     * 퇴직금계산 대상자 조회
     * @param serviceParameters
     * @return
     * @throws MSFException
     */
//	public static final String CLASS_SYSCOM_PAYR8500_TO_PSNL0100_REMT0100_DATALIST  = "com.app.exterms.payroll.server.service.Payr8500ServiceImpl.getSelectPayr4100ToRemt3500List"; //퇴직정산항목
	
	public static final String CLASS_PAYR8500_TO_REMT0150_REMT2000_DATALIST  = "com.app.exterms.payroll.server.service.Payr8500ServiceImpl.getSelectRemt0150ToRemt2000List"; 
	
	
    /**
     * 퇴직금지급내역 조회 
     * @param serviceParameters
     * @return
     * @throws MSFException
     */
	public static final String CLASS_PAYR8500_TO_REMTPYMT0100_REMT2000_DATALIST  = "com.app.exterms.payroll.server.service.Payr8500ServiceImpl.getSelectRemtPymt0100ToRemt2000List"; 
	
	
    //public static final String CUSTOM_METHOD_JobHistory_List = "com.app.exterms.basis.server.services.JobHistoryCustomService.getList";
    //public static final String CUSTOM_METHOD_JobHistory_Save = "com.app.exterms.basis.server.services.JobHistoryCustomService.save";

	
	public static final String CLASS_PAYR5010_BASS0300_DATA_LIST = "com.app.exterms.payroll.server.service.Payr5010ServiceImpl.getPayr5010DataList";	//단가직군관리
	public static final String CLASS_PAYR5020_BASS0350_TOP_DATA_LIST = "com.app.exterms.payroll.server.service.Payr5020ServiceImpl.getPayr5020TopDataList";	//단가직군관리
	public static final String CLASS_PAYR5020_BASS0350_BOTTOM_DATA_LIST = "com.app.exterms.payroll.server.service.Payr5020ServiceImpl.getPayr5020BottomDataList";	//단가직군관리

	public static final String CLASS_PAYR7100_LIST		= "com.app.exterms.payroll.server.service.Payr7100ServiceImpl.getPayr7100List";	//간이지급명세서
	public static final String CLASS_PAYR7100_DATA_LIST = "com.app.exterms.payroll.server.service.Payr7100ServiceImpl.getPayr7100DataList";	//간이지급명세서
}
