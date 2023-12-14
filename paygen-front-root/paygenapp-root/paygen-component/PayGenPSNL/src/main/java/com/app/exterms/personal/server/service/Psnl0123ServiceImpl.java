package com.app.exterms.personal.server.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.app.exterms.personal.client.dto.Psnl0100DTO;
import com.app.exterms.personal.client.dto.Psnl0110DTO;
import com.app.exterms.personal.client.dto.Psnl0123DTO;
import com.app.exterms.personal.client.service.Psnl0123Service;
import com.app.exterms.personal.server.service.dao.Psnl0100DAO;
import com.app.exterms.personal.server.service.dao.Psnl0110DAO;
import com.app.exterms.personal.server.service.dao.Psnl0123DAO;
import com.app.exterms.personal.server.vo.Psnl0100VO;
import com.app.exterms.personal.server.vo.Psnl0110VO;
import com.app.exterms.personal.server.vo.Psnl0123VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.props.ExtermsProps;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;

/**
 * @Class Name : Psnl0123ServiceImpl.java
 * @Description : Psnl0123 Business Implement class
 * @Modification Information
 **
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@SuppressWarnings("serial")
@Service("psnl0123Service")
public class Psnl0123ServiceImpl extends AbstractCustomServiceImpl implements
        Psnl0123Service {

    @Resource(name="psnl0123DAO")
    private Psnl0123DAO psnl0123DAO;
     
    @Resource(name="psnl0100DAO")
    private Psnl0100DAO psnl0100DAO;

    @Resource(name="psnl0110DAO")
    private Psnl0110DAO psnl0110DAO;
    
    
    private static final Logger logger = LoggerFactory.getLogger(Psnl0123ServiceImpl.class);
    private static final String calledClass = Psnl0123ServiceImpl.class.getName();
    

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public BaseListLoadResult<Psnl0123DTO> selectPsnl0123(
			BaseListLoadConfig config, HashMap<String, String> params)
			throws MSFException {
		
		// TODO Auto-generated method stub
		List<Psnl0123DTO> returnValue = new ArrayList<Psnl0123DTO>();
		List egovResultDataList = new ArrayList();
		
		String method = calledClass + ".selectPsnl0123";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		String windowNm = "인사";
		String windowId = "PSNL0100/PSNL0200";
		
		
		try {
			
			egovResultDataList = psnl0123DAO.selectPsnl0123(params);
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					Psnl0123DTO dto = new Psnl0123DTO();
					Map tempMap = (Map)egovResultDataList.get(i);
					Iterator<String> keys = tempMap.keySet().iterator();
					while( keys.hasNext() ){
			            String key = keys.next();
			            //형 타입이 숫자형일경우 형변환 해준다.
		            	if(tempMap.get(key) instanceof java.math.BigDecimal){
		            		dto.set(key, String.valueOf(tempMap.get(key)));
		            	}else{
		            		dto.set(key, tempMap.get(key));
		            	}
		            }
					//삭제 여부가 필요한 그리드 데이터일 경우 delChk를 false값을 필수로 넘겨준다.
					dto.setDelChk(false);
					returnValue.add(dto);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
		
		return new BaseListLoadResult<Psnl0123DTO>(returnValue);
	}

	@Override
	public String savePsnl0123(ArrayList<Psnl0123DTO> changePsnl0123List)
			throws MSFException {
		// TODO Auto-generated method stub
		
		String method = calledClass + ".changePsnl0123List";
         MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
     
         Date now = new Date(); 
		 SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd"); 
			
		 String nwDate =  format.format(now);
		 
		String windowNm = "인사";
		String windowId = "PSNL0100/PSNL0200";
		
		
		int delCnt = 0;
		int saveCnt = 0;
		try{
			if(changePsnl0123List!=null && changePsnl0123List.size() > 0){
				
				
				for ( int i = 0; i < changePsnl0123List.size(); i++){
					
					Psnl0123VO psnl0123Vo = new Psnl0123VO();
					
					psnl0123Vo.setDpobCd(MSFSharedUtils.allowNulls(changePsnl0123List.get(i).getDpobCd()));										/** column 사업장코드 : dpobCd */
					psnl0123Vo.setSystemkey(MSFSharedUtils.allowNulls(changePsnl0123List.get(i).getSystemkey()));    							/** column SYSTEMKEY : systemkey */
					psnl0123Vo.setLevfAbncDivCd(MSFSharedUtils.allowNulls(changePsnl0123List.get(i).getLevfAbncDivCd()));    					/** column 휴직구분코드 : levfAbncDivCd */
					psnl0123Vo.setLevfAbncBgnnDt(SmrmfUtils.getStringFromDate(changePsnl0123List.get(i).getLevfAbncBgnnDt(), "yyyyMMdd"));	/** column 휴직시작일자 : levfAbncBgnnDt */
					psnl0123Vo.setLevfAbncEndDt(SmrmfUtils.getStringFromDate(changePsnl0123List.get(i).getLevfAbncEndDt(), "yyyyMMdd"));	/** column 휴직종료일자 : levfAbncEndDt */
					psnl0123Vo.setTurtyRntmntDt(SmrmfUtils.getStringFromDate(changePsnl0123List.get(i).getTurtyRntmntDt(), "yyyyMMdd")); 	/** column 실제복직일자 : turtyRntmntDt */
					psnl0123Vo.setLevfAbncNoteCtnt(MSFSharedUtils.allowNulls(changePsnl0123List.get(i).getLevfAbncNoteCtnt()));					/** column 휴직비고내용 : levfAbncNoteCtnt */
					
					if(changePsnl0123List.get(i).getDelChk()){
						
						
						String tgDate = format.format(changePsnl0123List.get(i).getLevfAbncEndDt());
						
						if(MSFSharedUtils.paramNotNull(tgDate) ) {
							if (nwDate.compareTo(tgDate) >= 0) {
								//고용테이블 데이타 삭제 로직 추가 및 현재 휴직관련으로 되어 있으면 재직으로 변경 
								Psnl0100DTO psnl0100Dto = new Psnl0100DTO();
								Psnl0110DTO psnl0110Dto = new Psnl0110DTO();
								
								psnl0100Dto.setDpobCd(changePsnl0123List.get(i).getDpobCd());
								psnl0100Dto.setSystemkey(changePsnl0123List.get(i).getSystemkey());    /** column SYSTEMKEY : systemkey */
								psnl0100Dto.setHdofcCodtnCd(ExtermsProps.getProps("HDOFC_CODTN_CD_10") );   //마스터 재직변경 
								psnl0100Dto.setRetryDt(null);
								psnl0100Dto.setRetryReasCtnt(""); 
								
								psnl0100DAO.updatePsnl0100ToPsnlStat(psnl0100Dto);
								
//								psnl0110Dto.setDpobCd(changePsnl0123List.get(i).getDpobCd());    /** column 사업장코드 : dpobCd */
//								psnl0110Dto.setSystemkey(changePsnl0123List.get(i).getSystemkey());    /** column SYSTEMKEY : systemkey */
//								psnl0110Dto.setEmymtBgnnDt( changePsnl0123List.get(i).getLevfAbncBgnnDt()); //일련번호 
//								
//								// 휴직구분 코드가 출산휴가 이면 A0420080, 아니면 A0420040
//								if(changePsnl0123List.get(i).getLevfAbncDivCd() == "B0140006" || "B0140006".equals(changePsnl0123List.get(i).getLevfAbncDivCd())) {
//									psnl0110Dto.setEmymtTypCd("A0420080");    /** column 고용유형코드 : emymtTypCd */
//								}else {
//									psnl0110Dto.setEmymtTypCd("A0420040");    /** column 고용유형코드 : emymtTypCd */
//								}
////							    psnl0110Dto.setEmymtTypCd("A0420040");    /** column 고용유형코드 : emymtTypCd */
//								
//								psnl0110DAO.deletePsnl0100ToPsnl0110(psnl0110Dto);
								
							} 
							
							Psnl0110DTO psnl0110Dto = new Psnl0110DTO();
							psnl0110Dto.setDpobCd(changePsnl0123List.get(i).getDpobCd());    			/** column 사업장코드 : dpobCd */
							psnl0110Dto.setSystemkey(changePsnl0123List.get(i).getSystemkey());    		/** column SYSTEMKEY : systemkey */
							psnl0110Dto.setEmymtBgnnDt( changePsnl0123List.get(i).getLevfAbncBgnnDt()); //일련번호 
							
							// 휴직구분 코드가 출산휴가 이면 A0420080, 아니면 A0420040
							if(changePsnl0123List.get(i).getLevfAbncDivCd() == "B0140006" || "B0140006".equals(changePsnl0123List.get(i).getLevfAbncDivCd())) {
								psnl0110Dto.setEmymtTypCd("A0420080");    	/** column 고용유형코드 : emymtTypCd */
							}else {
								psnl0110Dto.setEmymtTypCd("A0420040");    	/** column 고용유형코드 : emymtTypCd */
							}
//						    psnl0110Dto.setEmymtTypCd("A0420040");    /** column 고용유형코드 : emymtTypCd */
							
							psnl0110DAO.deletePsnl0100ToPsnl0110(psnl0110Dto);
							
							psnl0123Vo.setLevfAbncSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0123List.get(i).getLevfAbncSeilNum(), "0")));	/** column 휴직일련번호 : levfAbncSeilNum */
//							psnl0123DAO.deletePsnl0123(changePsnl0123List.get(i));
							psnl0123DAO.deletePsnl0123(psnl0123Vo);
							delCnt++;
						}
//						if (nwDate.compareTo(tgDate) >= 0) {
//							//고용테이블 데이타 삭제 로직 추가 및 현재 휴직관련으로 되어 있으면 재직으로 변경 
//							Psnl0100DTO psnl0100Dto = new Psnl0100DTO();
//							Psnl0110DTO psnl0110Dto = new Psnl0110DTO();
//							
//							psnl0100Dto.setDpobCd(changePsnl0123List.get(i).getDpobCd());
//							psnl0100Dto.setSystemkey(changePsnl0123List.get(i).getSystemkey());    /** column SYSTEMKEY : systemkey */
//							psnl0100Dto.setHdofcCodtnCd(ExtermsProps.getProps("HDOFC_CODTN_CD_10") );   //마스터 재직변경 
//							psnl0100Dto.setRetryDt(null);
//							psnl0100Dto.setRetryReasCtnt(""); 
//							
//							psnl0100DAO.updatePsnl0100ToPsnlStat(psnl0100Dto);
//							
//							psnl0110Dto.setDpobCd(changePsnl0123List.get(i).getDpobCd());    /** column 사업장코드 : dpobCd */
//							psnl0110Dto.setSystemkey(changePsnl0123List.get(i).getSystemkey());    /** column SYSTEMKEY : systemkey */
//							psnl0110Dto.setEmymtBgnnDt( changePsnl0123List.get(i).getLevfAbncBgnnDt()); //일련번호 
//							
//							// 휴직구분 코드가 출산휴가 이면 A0420080, 아니면 A0420040
//							if(changePsnl0123List.get(i).getLevfAbncDivCd() == "B0140006" || "B0140006".equals(changePsnl0123List.get(i).getLevfAbncDivCd())) {
//								psnl0110Dto.setEmymtTypCd("A0420080");    /** column 고용유형코드 : emymtTypCd */
//							}else {
//								psnl0110Dto.setEmymtTypCd("A0420040");    /** column 고용유형코드 : emymtTypCd */
//							}
////						    psnl0110Dto.setEmymtTypCd("A0420040");    /** column 고용유형코드 : emymtTypCd */
//							
//							psnl0110DAO.deletePsnl0100ToPsnl0110(psnl0110Dto);
//							
//						} 
//						psnl0123Vo.setLevfAbncSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0123List.get(i).getLevfAbncSeilNum(), "0")));	/** column 휴직일련번호 : levfAbncSeilNum */
////						psnl0123DAO.deletePsnl0123(changePsnl0123List.get(i));
//						psnl0123DAO.deletePsnl0123(psnl0123Vo);
//						delCnt++;
					}else{
						 
						changePsnl0123List.get(i).setIsmt(sessionUser.getUsrId());
						changePsnl0123List.get(i).setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
						
						psnl0123Vo.setIsmt(sessionUser.getUsrId());
						psnl0123Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
						
						/**
							   B0140001    B014    0001    육아휴직  ---
							   B0140002    B014    0002    질병휴직  ---
							   B0140003    B014    0003    특별휴가  --- 
							   B0140004    B014    0004    산재휴가  ---
							   B0140005    B014    0005    간병휴직  ---
							   B0140006    B014    0006    출산휴가  ---
						*/
						
						if(changePsnl0123List.get(i).getLevfAbncSeilNum() != null){
							 
							Psnl0123VO  sePsnl0123Vo = new Psnl0123VO(); 
							Psnl0100DTO psnl0100Dto = new Psnl0100DTO();
							Psnl0110DTO psnl0110Dto = new Psnl0110DTO();
							
							sePsnl0123Vo.setDpobCd(changePsnl0123List.get(i).getDpobCd());    /** column 사업장코드 : dpobCd */
							sePsnl0123Vo.setSystemkey(changePsnl0123List.get(i).getSystemkey());    /** column SYSTEMKEY : systemkey */
							sePsnl0123Vo.setLevfAbncSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0123List.get(i).getLevfAbncSeilNum(), "0"))); //일련번호 
							
							sePsnl0123Vo = psnl0123DAO.selectPsnl0123(sePsnl0123Vo);
							
							
						    psnl0110Dto.setDpobCd(changePsnl0123List.get(i).getDpobCd());    /** column 사업장코드 : dpobCd */
                            psnl0110Dto.setSystemkey(changePsnl0123List.get(i).getSystemkey());    /** column SYSTEMKEY : systemkey */
                            
                            // 휴직구분 코드가 출산휴가 이면 A0420080, 아니면 A0420040
							if(changePsnl0123List.get(i).getLevfAbncDivCd() == "B0140006" || "B0140006".equals(changePsnl0123List.get(i).getLevfAbncDivCd())) {
								psnl0110Dto.setEmymtTypCd("A0420080");    /** column 고용유형코드 : emymtTypCd */
							}else {
								psnl0110Dto.setEmymtTypCd("A0420040");    /** column 고용유형코드 : emymtTypCd */
							}
//                            psnl0110Dto.setEmymtTypCd("A0420040");    /** column 고용유형코드 : emymtTypCd */
                            
                            
                            psnl0110Dto.setEmymtBgnnDt(changePsnl0123List.get(i).getLevfAbncBgnnDt());    /** column 고용시작일자 : emymtBgnnDt */
                            psnl0110Dto.setEmymtEndDt(changePsnl0123List.get(i).getLevfAbncEndDt());    /** column 고용종료일자 : emymtEndDt */
                          
                 		    psnl0110Dto.setIsmt(sessionUser.getUsrId());
                 		    psnl0110Dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
                         		  
                     		    
						    
							if (MSFSharedUtils.paramNotNull(sePsnl0123Vo) && MSFSharedUtils.paramNotNull(sePsnl0123Vo.getLevfAbncBgnnDt())) {
								
								psnl0100Dto.setDpobCd(changePsnl0123List.get(i).getDpobCd());
    							psnl0100Dto.setSystemkey(changePsnl0123List.get(i).getSystemkey());    /** column SYSTEMKEY : systemkey */
    							psnl0100Dto.setHdofcCodtnCd(ExtermsProps.getProps("HDOFC_CODTN_CD_10"));   //마스터 재직변경 
    							psnl0100Dto.setRetryDt(null);
    							psnl0100Dto.setRetryReasCtnt(""); 
    							 
							    
								if (MSFSharedUtils.paramNotNull(sePsnl0123Vo.getTurtyRntmntDt())) {
									
									if(MSFSharedUtils.paramNotNull(changePsnl0123List.get(i).getTurtyRntmntDt())) {
										 
										if(!sePsnl0123Vo.getTurtyRntmntDt().equals(changePsnl0123List.get(i).getTurtyRntmntDt())) {
											
											if(format.format(changePsnl0123List.get(i).getTurtyRntmntDt()).compareTo(sePsnl0123Vo.getLevfAbncEndDt()) > 0) {
												//재직처리 루틴 호출 
												if(nwDate.compareTo(format.format(changePsnl0123List.get(i).getTurtyRntmntDt())) >= 0) {
													//재직처리 루틴 호출 
													psnl0100DAO.updatePsnl0100ToPsnlStat(psnl0100Dto);
												}  
											}  
										} else {
											//같으면 
											if(nwDate.compareTo(format.format(changePsnl0123List.get(i).getTurtyRntmntDt())) >= 0) {
												//재직처리 루틴 호출 
												psnl0100DAO.updatePsnl0100ToPsnlStat(psnl0100Dto);
											}  
										} 
										
									 }  
									
									
									/** 마스터 시작일자 변경 **/
									Psnl0110VO psnl0110Vo = new Psnl0110VO();
									
									psnl0110Vo.setDpobCd(changePsnl0123List.get(i).getDpobCd());    /** column 사업장코드 : dpobCd */
									psnl0110Vo.setSystemkey(changePsnl0123List.get(i).getSystemkey());    /** column SYSTEMKEY : systemkey */ 
									
									// 휴직구분 코드가 출산휴가 이면 A0420080, 아니면 A0420040
									if(changePsnl0123List.get(i).getLevfAbncDivCd() == "B0140006" || "B0140006".equals(changePsnl0123List.get(i).getLevfAbncDivCd())) {
										psnl0110Vo.setEmymtTypCd("A0420080");    /** column 고용유형코드 : emymtTypCd */
									}else {
										psnl0110Vo.setEmymtTypCd("A0420040");    /** column 고용유형코드 : emymtTypCd */
									}
//									psnl0110Vo.setEmymtTypCd("A0420040");    /** column 고용유형코드 : emymtTypCd */
									psnl0110Vo.setEmymtBgnnDt(SmrmfUtils.getStringFromDate(changePsnl0123List.get(i).getLevfAbncBgnnDt(), "yyyyMMdd"));	/** column 고용시작일자 : emymtBgnnDt */
									psnl0110Vo.setEmymtEndDt(SmrmfUtils.getStringFromDate(changePsnl0123List.get(i).getLevfAbncEndDt(), "yyyyMMdd"));  	/** column 고용종료일자 : emymtEndDt */
									psnl0110Vo.setEmymtReasCtnt(MSFSharedUtils.allowNulls(changePsnl0123List.get(i).getLevfAbncNoteCtnt()));				/** column 휴직비고내용 : levfAbncNoteCtnt */
									
									psnl0110Vo.setIsmt(sessionUser.getUsrId());
									psnl0110Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
									
	      							//TODO 수정
//									psnl0110DAO.updatePsnl0100ToPsnl0110(psnl0110Dto);
									psnl0110DAO.updatePsnl0100ToPsnl0110(psnl0110Vo);
	      							
	      							psnl0123Vo.setLevfAbncSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0123List.get(i).getLevfAbncSeilNum(), "0")));	/** column 휴직일련번호 : levfAbncSeilNum */
									//업데이트 처리 
//									psnl0123DAO.updatePsnl0123(changePsnl0123List.get(i)); 
									psnl0123DAO.updatePsnl0123(psnl0123Vo);
									
								} else {
									
									if(MSFSharedUtils.paramNotNull(changePsnl0123List.get(i).getTurtyRntmntDt())) {
										 
										if(format.format(changePsnl0123List.get(i).getTurtyRntmntDt()).compareTo(sePsnl0123Vo.getLevfAbncEndDt()) > 0) {
											//재직처리 루틴 호출 
											if(nwDate.compareTo(format.format(changePsnl0123List.get(i).getTurtyRntmntDt())) >= 0) {
												//재직처리 루틴 호출   
			        							psnl0100DAO.updatePsnl0100ToPsnlStat(psnl0100Dto);
											}  
										}  
									 } 
									
									
									/** 마스터 시작일자 변경 **/
									Psnl0110VO psnl0110Vo = new Psnl0110VO();
									
									psnl0110Vo.setDpobCd(MSFSharedUtils.allowNulls(changePsnl0123List.get(i).getDpobCd()));    /** column 사업장코드 : dpobCd */
									psnl0110Vo.setSystemkey(MSFSharedUtils.allowNulls(changePsnl0123List.get(i).getSystemkey()));    /** column SYSTEMKEY : systemkey */ 
									// 휴직구분 코드가 출산휴가 이면 A0420080, 아니면 A0420040
									if(changePsnl0123List.get(i).getLevfAbncDivCd() == "B0140006" || "B0140006".equals(changePsnl0123List.get(i).getLevfAbncDivCd())) {
										psnl0110Vo.setEmymtTypCd("A0420080");    /** column 고용유형코드 : emymtTypCd */
									}else {
										psnl0110Vo.setEmymtTypCd("A0420040");    /** column 고용유형코드 : emymtTypCd */
									}
//									psnl0110Vo.setEmymtTypCd("A0420040");    /** column 고용유형코드 : emymtTypCd */
									psnl0110Vo.setEmymtBgnnDt(SmrmfUtils.getStringFromDate(changePsnl0123List.get(i).getLevfAbncBgnnDt(), "yyyyMMdd"));    /** column 고용시작일자 : emymtBgnnDt */
									psnl0110Vo.setEmymtEndDt(SmrmfUtils.getStringFromDate(changePsnl0123List.get(i).getLevfAbncEndDt(), "yyyyMMdd"));  /** column 고용종료일자 : emymtEndDt */
									psnl0110Vo.setIsmt(sessionUser.getUsrId());
									psnl0110Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
									
									//TODO 수정
//									psnl0110DAO.updatePsnl0100ToPsnl0110(psnl0110Dto);
									psnl0110DAO.updatePsnl0100ToPsnl0110(psnl0110Vo);
									
									psnl0123Vo.setLevfAbncSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0123List.get(i).getLevfAbncSeilNum(), "0")));	/** column 휴직일련번호 : levfAbncSeilNum */
									//업데이트 처리 
//									psnl0123DAO.updatePsnl0123(changePsnl0123List.get(i)); 
									psnl0123DAO.updatePsnl0123(psnl0123Vo);
								}
								
							} else {
								
								
								/** 마스터 시작일자 변경 **/
								Psnl0110VO psnl0110Vo = new Psnl0110VO();
								
								psnl0110Vo.setDpobCd(changePsnl0123List.get(i).getDpobCd());    /** column 사업장코드 : dpobCd */
								psnl0110Vo.setSystemkey(changePsnl0123List.get(i).getSystemkey());    /** column SYSTEMKEY : systemkey */ 
								// 휴직구분 코드가 출산휴가 이면 A0420080, 아니면 A0420040
								if(changePsnl0123List.get(i).getLevfAbncDivCd() == "B0140006" || "B0140006".equals(changePsnl0123List.get(i).getLevfAbncDivCd())) {
									psnl0110Vo.setEmymtTypCd("A0420080");    /** column 고용유형코드 : emymtTypCd */
								}else {
									psnl0110Vo.setEmymtTypCd("A0420040");    /** column 고용유형코드 : emymtTypCd */
								}
//								psnl0110Vo.setEmymtTypCd("A0420040");    /** column 고용유형코드 : emymtTypCd */
								psnl0110Vo.setEmymtBgnnDt(SmrmfUtils.getStringFromDate(changePsnl0123List.get(i).getLevfAbncBgnnDt(), "yyyyMMdd"));    /** column 고용시작일자 : emymtBgnnDt */
								psnl0110Vo.setEmymtEndDt(SmrmfUtils.getStringFromDate(changePsnl0123List.get(i).getLevfAbncEndDt(), "yyyyMMdd"));  /** column 고용종료일자 : emymtEndDt */
								psnl0110Vo.setIsmt(sessionUser.getUsrId());
								psnl0110Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
								
								//TODO 수정
//								psnl0110DAO.updatePsnl0100ToPsnl0110(psnl0110Dto);
								psnl0110DAO.updatePsnl0100ToPsnl0110(psnl0110Vo);
								
								psnl0123Vo.setLevfAbncSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0123List.get(i).getLevfAbncSeilNum(), "0")));	/** column 휴직일련번호 : levfAbncSeilNum */
								//업데이트 처리 
//								psnl0123DAO.updatePsnl0123(changePsnl0123List.get(i)); 
								psnl0123DAO.updatePsnl0123(psnl0123Vo);
							}
							 
						}else{
							psnl0123Vo.setLevfAbncSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0123List.get(i).getLevfAbncSeilNum(), "0")));	/** column 휴직일련번호 : levfAbncSeilNum */
//							psnl0123DAO.insertPsnl0123(changePsnl0123List.get(i)); 
							psnl0123DAO.insertPsnl0123(psnl0123Vo); 
							
							if (!"B0140003".equals(changePsnl0123List.get(i).getLevfAbncDivCd())) {
							 
//    							  if ("B0140001".equals(changePsnl0123List.get(i).getLevfAbncDivCd())) {
//    							    
//    							  } else if ("B0140002".equals(changePsnl0123List.get(i).getLevfAbncDivCd())) {
//                                    
//                                } else if ("B0140004".equals(changePsnl0123List.get(i).getLevfAbncDivCd())) {
//                                    
//                                } else if ("B0140005".equals(changePsnl0123List.get(i).getLevfAbncDivCd())) {
//                                    
//                                } else if ("B0140006".equals(changePsnl0123List.get(i).getLevfAbncDivCd())) {
//                                    
//                                }
							    Psnl0100VO psnl0100Vo = new Psnl0100VO();
							   
							    
							    psnl0100Vo.setDpobCd(MSFSharedUtils.allowNulls(changePsnl0123List.get(i).getDpobCd()));    /** column 사업장코드 : dpobCd */
							    psnl0100Vo.setSystemkey(MSFSharedUtils.allowNulls(changePsnl0123List.get(i).getSystemkey()));    /** column SYSTEMKEY : systemkey */
							    
							    psnl0100Vo = psnl0100DAO.selectPsnl0100ToPsnl0123(psnl0100Vo);
							    
    							if (MSFSharedUtils.paramNotNull(psnl0100Vo)) {
        							//고용인서트 및 마스터 업데이트 작업 할것.추가 2015-01-13
        							Psnl0110DTO psnl0110Dto = new Psnl0110DTO();
        							Psnl0100DTO psnl0100Dto = new Psnl0100DTO();
        							 
        							psnl0100Dto.setDpobCd(MSFSharedUtils.allowNulls(changePsnl0123List.get(i).getDpobCd()));
        							psnl0100Dto.setSystemkey(MSFSharedUtils.allowNulls(changePsnl0123List.get(i).getSystemkey()));    /** column SYSTEMKEY : systemkey */
        							psnl0100Dto.setHdofcCodtnCd(MSFSharedUtils.allowNulls(ExtermsProps.getProps("HDOFC_CODTN_CD_30")));   //마스터 휴직
        							psnl0100Dto.setRetryDt(null);
        							psnl0100Dto.setRetryReasCtnt(""); 
        							 //필수 키값 세팅
                            		psnl0100Dto.setKybdr(sessionUser.getUsrId());
                            		psnl0100Dto.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
                            		
                            		psnl0100Dto.setIsmt(sessionUser.getUsrId());
                            		psnl0100Dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
        							
        							psnl0100DAO.updatePsnl0100ToPsnlStat(psnl0100Dto);
        							
        							
//                                    psnl0110Dto.setDpobCd(changePsnl0123List.get(i).getDpobCd());    /** column 사업장코드 : dpobCd */
//                                    psnl0110Dto.setSystemkey(changePsnl0123List.get(i).getSystemkey());    /** column SYSTEMKEY : systemkey */
//                                  //psnl0110Dto.setEmymtSeilNum();    /** column 고용일련번호 : emymtSeilNum */
//                                    psnl0110Dto.setEmymtDivCd(psnl0100Vo.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */
//                                    psnl0110Dto.setEmymtTypCd("A0420040");    /** column 고용유형코드 : emymtTypCd */
//                                    psnl0110Dto.setEmymtBgnnDt(changePsnl0123List.get(i).getLevfAbncBgnnDt());    /** column 고용시작일자 : emymtBgnnDt */
//                                    psnl0110Dto.setEmymtEndDt(changePsnl0123List.get(i).getLevfAbncEndDt());    /** column 고용종료일자 : emymtEndDt */
//                                    psnl0110Dto.setDeptCd(psnl0100Vo.getCurrAffnDeptCd());    /** column 부서코드 : deptCd */
//                                    psnl0110Dto.setCurrPaeWorkNm("");    /** column 현근무지명 : currPaeWorkNm */
//                                    psnl0110Dto.setBusinCd(psnl0100Vo.getBusinCd());    /** column 사업코드 : businCd */
//                                    if (psnl0100Vo.getTypOccuCd().length() == 17) {
//                                        psnl0110Dto.setTypOccuCd(psnl0100Vo.getTypOccuCd().substring(0, 8));    /** column 직종코드 : typOccuCd */
//                                    } else {
//                                        psnl0110Dto.setTypOccuCd("");  /** column 직종코드 : typOccuCd */  
//                                    }
//                                    psnl0110Dto.setDtilOccuInttnCd(psnl0100Vo.getDtilOccuInttnCd());    /** column 직종세구분코드 : DtilOccuInttnCd */
//                                    psnl0110Dto.setTempDtilOccuInttnCd(psnl0100Vo.getDtilOccuInttnCd());    /** column 직종세구분코드 : DtilOccuInttnCd */
//                                    
//                                    psnl0110Dto.setOdtyCd("");    /** column 직책코드 : odtyCd */
//                                    psnl0110Dto.setPayPymtDivCd("");    /** column 급여지급구분코드 : payPymtDivCd */
//                                    psnl0110Dto.setEmymtSum("0");    /** column 고용금액 : emymtSum */
//                                    psnl0110Dto.setEmymtReasCtnt(changePsnl0123List.get(i).getLevfAbncNoteCtnt());    /** column 고용사유내용 : emymtReasCtnt */
//                                    psnl0110Dto.setCertNumHuhd("");    /** column 증번호 : certNumHuhd */
//                                    psnl0110Dto.setRducBgnnDt("");    /** column 경감시작일자 : rducBgnnDt */
//                                    psnl0110Dto.setRducEndDt("");    /** column 경감종료일자 : rducEndDt */
//                                    psnl0110Dto.setPyspGrdeCd(psnl0100Vo.getPyspGrdeCd());    /** column 호봉등급코드 : pyspGrdeCd */
//                                    //필수 키값 세팅
//                            		psnl0110Dto.setKybdr(sessionUser.getUsrId());
//                            		psnl0110Dto.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//                            		
//                            		psnl0110Dto.setIsmt(sessionUser.getUsrId());
//                            		psnl0110Dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//                            		
//        							psnl0110DAO.insertPsnl0110(psnl0110Dto);
                            		
        							//--
        							Psnl0110VO psnl0110Vo = new Psnl0110VO();
        							psnl0110Vo.setDpobCd(MSFSharedUtils.allowNulls(changePsnl0123List.get(i).getDpobCd()));    /** column 사업장코드 : dpobCd */
        							psnl0110Vo.setSystemkey(MSFSharedUtils.allowNulls(changePsnl0123List.get(i).getSystemkey()));    /** column SYSTEMKEY : systemkey */
                                   //psnl0110Dto.setEmymtSeilNum();    /** column 고용일련번호 : emymtSeilNum */
        							psnl0110Vo.setEmymtDivCd(MSFSharedUtils.allowNulls(psnl0100Vo.getEmymtDivCd()));    /** column 고용구분코드 : emymtDivCd */
//        							psnl0110Vo.setEmymtTypCd("A0420040");    /** column 고용유형코드 : emymtTypCd */
        							/** 
        							 * 16.04.19 : 출산 휴가는 휴직이 아닌 출산휴가로 맵핑
        							 	A0420010	A042	0010	신규고용
        							 	A0420020	A042	0020	재고용
        							 	A0420030	A042	0030	연장계약
        							 	A0420040	A042	0040	휴직
        							 	A0420050	A042	0050	직제개편
        							 	A0420060	A042	0060	전보
        							 	A0420990	A042	0990	퇴직
        							 	A0420070	A042	0070	복직
        							 	A0420080	A042	0080	출산휴가
        							**/
        							if(changePsnl0123List.get(i).getLevfAbncDivCd() == "B0140006" || "B0140006".equals(changePsnl0123List.get(i).getLevfAbncDivCd())) {
        								psnl0110Vo.setEmymtTypCd("A0420080");    /** column 고용유형코드 : emymtTypCd */
        							}else {
        								psnl0110Vo.setEmymtTypCd("A0420040");    /** column 고용유형코드 : emymtTypCd */
        							}
        							
                                     psnl0110Vo.setEmymtBgnnDt(SmrmfUtils.getStringFromDate(changePsnl0123List.get(i).getLevfAbncBgnnDt(), "yyyyMMdd"));    /** column 고용시작일자 : emymtBgnnDt */
                                     psnl0110Vo.setEmymtEndDt(SmrmfUtils.getStringFromDate(changePsnl0123List.get(i).getLevfAbncEndDt(), "yyyyMMdd"));    /** column 고용종료일자 : emymtEndDt */
                                     psnl0110Vo.setDeptCd(MSFSharedUtils.allowNulls(psnl0100Vo.getCurrAffnDeptCd()));    /** column 부서코드 : deptCd */
                                     psnl0110Vo.setCurrPaeWorkNm("");    /** column 현근무지명 : currPaeWorkNm */
                                     psnl0110Vo.setBusinCd(MSFSharedUtils.allowNulls(psnl0100Vo.getBusinCd()));    /** column 사업코드 : businCd */
                                     
                                     
                                     if(MSFSharedUtils.paramNotNull(psnl0100Vo.getTypOccuCd())) {
                                    	 
                                    	 psnl0110Vo.setTypOccuCd(psnl0100Vo.getTypOccuCd());
                                    	 
//                                    	 if (MSFSharedUtils.allowNulls(psnl0100Vo.getTypOccuCd()).length() == 17) {
//                                        	 psnl0110Vo.setTypOccuCd(psnl0100Vo.getTypOccuCd().substring(0, 8));    /** column 직종코드 : typOccuCd */
//                                         } else {
//                                        	 psnl0110Vo.setTypOccuCd("");  /** column 직종코드 : typOccuCd */  
//                                         }
                                     }
                                     
//                                     if (MSFSharedUtils.paramNotNull(psnl0100Vo.getTypOccuCd()) || MSFSharedUtils.allowNulls(psnl0100Vo.getTypOccuCd()).length() == 17) {
//                                    	 psnl0110Vo.setTypOccuCd(psnl0100Vo.getTypOccuCd().substring(0, 8));    /** column 직종코드 : typOccuCd */
//                                     } else {
//                                    	 psnl0110Vo.setTypOccuCd("");  /** column 직종코드 : typOccuCd */  
//                                     }
                                     psnl0110Vo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(psnl0100Vo.getDtilOccuInttnCd()));    /** column 직종세구분코드 : DtilOccuInttnCd */
                                     psnl0110Vo.setTempDtilOccuInttnCd(MSFSharedUtils.allowNulls(psnl0100Vo.getDtilOccuInttnCd()));    /** column 직종세구분코드 : DtilOccuInttnCd */
                                     
                                     psnl0110Vo.setOdtyCd("");    /** column 직책코드 : odtyCd */
                                     psnl0110Vo.setPayPymtDivCd("");    /** column 급여지급구분코드 : payPymtDivCd */
                                     psnl0110Vo.setEmymtSum(new BigDecimal("0"));    /** column 고용금액 : emymtSum */
                                     psnl0110Vo.setEmymtReasCtnt(changePsnl0123List.get(i).getLevfAbncNoteCtnt());    /** column 고용사유내용 : emymtReasCtnt */
                                     psnl0110Vo.setCertNumHuhd("");    /** column 증번호 : certNumHuhd */
                                     psnl0110Vo.setRducBgnnDt("");    /** column 경감시작일자 : rducBgnnDt */
                                     psnl0110Vo.setRducEndDt("");    /** column 경감종료일자 : rducEndDt */
                                     psnl0110Vo.setPyspGrdeCd(MSFSharedUtils.allowNulls(psnl0100Vo.getPyspGrdeCd()));    /** column 호봉등급코드 : pyspGrdeCd */
                                     //필수 키값 세팅
                                     psnl0110Vo.setKybdr(sessionUser.getUsrId());
                                     psnl0110Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
                             		
                                     psnl0110Vo.setIsmt(sessionUser.getUsrId());
                                     psnl0110Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
                            		
                                     psnl0110DAO.insertPsnl0100ToPsnl0110(psnl0110Vo);
                            		
//                                    psnl0110Dto.setKybdr(changePsnl0123List.get(i).getKybdr());    /** column 입력자 : kybdr */
//                                    psnl0110Dto.setInptDt(changePsnl0123List.get(i).getInptDt());    /** column 입력일자 : inptDt */
//                                    psnl0110Dto.setInptAddr(changePsnl0123List.get(i).getInptAddr());    /** column 입력주소 : inptAddr */
//                                    psnl0110Dto.setIsmt(changePsnl0123List.get(i).getIsmt());    /** column 수정자 : ismt */
//                                    psnl0110Dto.setRevnDt(changePsnl0123List.get(i).getRevnDt());    /** column 수정일자 : revnDt */
//                                    psnl0110Dto.setRevnAddr(changePsnl0123List.get(i).getRevnAddr());    /** column 수정주소 : revnAddr */
         
    							}
							}
						}
						saveCnt++;
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S:C:U:D",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S:C:U:D");
		
		return "저장:"+saveCnt+",삭제:"+delCnt;
	}
    
}
