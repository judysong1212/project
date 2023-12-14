package com.app.exterms.personal.server.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.personal.client.dto.Psnl0114DTO;
import com.app.exterms.personal.client.service.Psnl0114Service;
import com.app.exterms.personal.server.service.dao.Psnl0100DAO;
import com.app.exterms.personal.server.service.dao.Psnl0114DAO;
import com.app.exterms.personal.server.vo.Psnl0100VO;
import com.app.exterms.personal.server.vo.Psnl0114VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.extjs.gxt.ui.client.data.BaseModel;

/**
 * @Class Name : Psnl0114ServiceImpl.java
 * @Description : Psnl0114 Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
@SuppressWarnings("serial")
@Service("psnl0114Service")
public class Psnl0114ServiceImpl extends AbstractCustomServiceImpl implements Psnl0114Service {

	@Autowired
    @Resource(name="psnl0100DAO")
    private Psnl0100DAO psnl0100DAO;
	
    @Resource(name="psnl0114DAO")
    private Psnl0114DAO psnl0114DAO;
    
    
    private static final Logger logger = LoggerFactory.getLogger(Psnl0114ServiceImpl.class);
    private static final String calledClass = Psnl0114ServiceImpl.class.getName();
    

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public BaseListLoadResult<Psnl0114DTO> selectPsnl0114(
			BaseListLoadConfig config, HashMap<String, String> params)
			throws Exception {
		
		// TODO Auto-generated method stub
		List<Psnl0114DTO> returnValue = new ArrayList<Psnl0114DTO>();
		List egovResultDataList = new ArrayList();
		
		String windowNm = "인사";
		String windowId = "PSNL0100/PSNL0200";
		
		String method = calledClass + ".selectPsnl0114";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		
		try {
			
			egovResultDataList = psnl0114DAO.selectPsnl0114(params);
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					Psnl0114DTO dto = new Psnl0114DTO();
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
					dto.setJnPayrDducYnChk("Y".equals(dto.getJnPayrDducYn()) ? true : false);
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
		
		return new BaseListLoadResult<Psnl0114DTO>(returnValue);
	}

	@Override
	public String savePsnl0114(ArrayList<Psnl0114DTO> changePsnl0114List)
			throws Exception {
		// TODO Auto-generated method stub
		int delCnt = 0;
		int saveCnt = 0;
		
		String windowNm = "인사";
		String windowId = "PSNL0100/PSNL0200";
		
		String method = calledClass + ".savePsnl0114";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		
		try{
			if(changePsnl0114List!=null && changePsnl0114List.size() > 0){
				for ( int i = 0; i < changePsnl0114List.size(); i++){
					
					Psnl0114VO psnl0114Vo = new Psnl0114VO();
					
					psnl0114Vo.setDpobCd(MSFSharedUtils.allowNulls(changePsnl0114List.get(i).getDpobCd()));						/** column 사업장코드 : dpobCd */
					psnl0114Vo.setSystemkey(MSFSharedUtils.allowNulls(changePsnl0114List.get(i).getSystemkey()));    			/** column SYSTEMKEY : systemkey */
					psnl0114Vo.setJnDt(SmrmfUtils.getStringFromDate(changePsnl0114List.get(i).getJnDt(), "yyyyMMdd"));		/** column 가입일자 : jnDt */
					psnl0114Vo.setJnOpztnNm(MSFSharedUtils.allowNulls(changePsnl0114List.get(i).getJnOpztnNm()));    			/** column 가입단체명 : jnOpztnNm */
					psnl0114Vo.setOdtyNm(MSFSharedUtils.allowNulls(changePsnl0114List.get(i).getOdtyNm()));    					/** column 직책코드 : odtyNm */
					psnl0114Vo.setWirlDt(MSFSharedUtils.allowNulls(SmrmfUtils.getStringFromDate(changePsnl0114List.get(i).getWirlDt(), "yyyyMMdd")));  /** column 탈퇴일자 : wirlDt */
					
					psnl0114Vo.setJnPayrDducDivCd(MSFSharedUtils.allowNulls(changePsnl0114List.get(i).getJnPayrDducDivCd()));	/** column 급여공제구분코드 : jnPayrDducDivCd */
					psnl0114Vo.setJnPayrDducYn(changePsnl0114List.get(i).getJnPayrDducYnChk()?"Y":"N");    						/** column 단체급여공제여부 : jnPayrDducYn */
					psnl0114Vo.setJnCntbDducDivCd(MSFSharedUtils.allowNulls(changePsnl0114List.get(i).getJnCntbDducDivCd()));	/** column 기부금공제구분코드 : jnCntbDducDivCd */
					psnl0114Vo.setJnCntbMknm(MSFSharedUtils.allowNulls(changePsnl0114List.get(i).getJnCntbMknm()));    			/** column 기부금표기명 : jnCntbMknm */
					psnl0114Vo.setTxemRducDivCd(MSFSharedUtils.allowNulls(changePsnl0114List.get(i).getTxemRducDivCd()));    	/** column 비과세감면구분코드 : txemRducDivCd */
					psnl0114Vo.setJnCtnt(MSFSharedUtils.allowNulls(changePsnl0114List.get(i).getJnCtnt()));    					/** column 단체비고내용 : jnCtnt */
					
					
					
					// 급여공제코드가 노조회비이며, 탈퇴일자가 없을 경우에만 인사 마스터에 노조 가입여부 'Y'로 UPDATE 처리
					Psnl0100VO psnl0100Vo = new Psnl0100VO();
					psnl0100Vo.setDpobCd(psnl0114Vo.getDpobCd());
					psnl0100Vo.setSystemkey(psnl0114Vo.getSystemkey());
					if("D9500400".equals(psnl0114Vo.getJnPayrDducDivCd())) {
						if(psnl0114Vo.getWirlDt() == null || "".equals(psnl0114Vo.getWirlDt())) {
							psnl0100Vo.setUnnMbspSttYn("Y");
						}else {
//							psnl0100Vo.setUnnMbspSttYn("N");
						}
					}else {
//						psnl0100Vo.setUnnMbspSttYn("N");
					}
					psnl0100DAO.resetPsnl0100UNN_MBSP_STT_YN(psnl0100Vo);
					
					if(changePsnl0114List.get(i).getDelChk()){
						psnl0114Vo.setOpztnSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0114List.get(i).getOpztnSeilNum(), "0")));   /** column 단체일련번호 : opztnSeilNum */
//						psnl0114DAO.deletePsnl0114(changePsnl0114List.get(i));
						psnl0114DAO.deletePsnl0114(psnl0114Vo);
						
						delCnt++;
					}else{
//						MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
					
						
						
						
						if(changePsnl0114List.get(i).getOpztnSeilNum() != null){
							
							changePsnl0114List.get(i).setIsmt(sessionUser.getUsrId());
							changePsnl0114List.get(i).setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
							
							psnl0114Vo.setOpztnSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0114List.get(i).getOpztnSeilNum(), "0")));   /** column 단체일련번호 : opztnSeilNum */
//							psnl0114DAO.updatePsnl0114(changePsnl0114List.get(i));
							psnl0114DAO.updatePsnl0114(psnl0114Vo);
						}else{
							
							psnl0114Vo.setKybdr(sessionUser.getUsrId());
							psnl0114Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
							
							psnl0114Vo.setOpztnSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0114List.get(i).getOpztnSeilNum(), "0")));   /** column 단체일련번호 : opztnSeilNum */
//							psnl0114DAO.insertPsnl0114(changePsnl0114List.get(i));
							psnl0114DAO.insertPsnl0114(psnl0114Vo);
						}
						saveCnt++;
						
					}
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U:D",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "U:D");
		
		return "저장:"+saveCnt+",삭제:"+delCnt;
	}
	
	
	/** **/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<BaseModel> getPayrDducCd() throws MSFException {
			
			String method = calledClass + ".getPayrDducCd";
			MSFSysm0100BM sessionUser;

			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}
			
			List<BaseModel> returnValue = new ArrayList<BaseModel>();
			List egovResultDataList = new ArrayList();
			try{
				
				egovResultDataList = psnl0114DAO.getPayrDducCd();
				
				if(egovResultDataList != null && egovResultDataList.size() > 0){
					for(int i = 0 ; i < egovResultDataList.size(); i++){
						BaseModel bm = new BaseModel();
						Map tempMap = (Map)egovResultDataList.get(i);
						Iterator<String> keys = tempMap.keySet().iterator();
						while( keys.hasNext() ){
				            String key = keys.next();
				            //형 타입이 숫자형일경우 형변환 해준다.
			            	if(tempMap.get(key) instanceof java.math.BigDecimal){
			            		bm.set(key, String.valueOf(tempMap.get(key)));
			            	}else{
			            		bm.set(key, tempMap.get(key));
			            	}
			            }
						returnValue.add(bm);
					}
				}
			}catch(Exception e){
				e.printStackTrace();
				throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
			}
			
	 
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
//			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
	 
			return returnValue;
		}
    
}
