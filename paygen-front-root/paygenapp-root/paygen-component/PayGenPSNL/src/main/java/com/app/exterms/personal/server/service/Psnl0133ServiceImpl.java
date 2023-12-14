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
import org.springframework.stereotype.Service;

import com.app.exterms.personal.client.dto.Psnl0133DTO;
import com.app.exterms.personal.client.service.Psnl0133Service;
import com.app.exterms.personal.server.service.dao.Psnl0133DAO;
import com.app.exterms.personal.server.vo.Psnl0133SrhVO;
import com.app.exterms.personal.server.vo.Psnl0133VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;

/**
 * @Class Name : Psnl0133ServiceImpl.java
 * @Description : Psnl0133 Business Implement class
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
@Service("psnl0133Service")
public class Psnl0133ServiceImpl extends AbstractCustomServiceImpl implements Psnl0133Service {

    @Resource(name="psnl0133DAO")
    private Psnl0133DAO psnl0133DAO;
    
    private static final Logger logger = LoggerFactory.getLogger(Psnl0133ServiceImpl.class);
    private static final String calledClass = Psnl0133ServiceImpl.class.getName();

    
    /** 근무상황 조회 **/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public BaseListLoadResult<Psnl0133DTO> selectPsnl0133(BaseListLoadConfig config, HashMap<String, String> params)throws Exception {
		// TODO Auto-generated method stub
		List<Psnl0133DTO> returnValue = new ArrayList<Psnl0133DTO>();
		List egovResultDataList = new ArrayList();
		
		String method = calledClass + ".selectPsnl0133";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		String windowNm = "인사";
		String windowId = "PSNL0100/PSNL0200";
		Psnl0133SrhVO psnl0133SrhVo = new Psnl0133SrhVO();
		
		
		try {
			
			
			psnl0133SrhVo = new Psnl0133SrhVO();
			psnl0133SrhVo.setDpobCd(params.get("dpobCd"));
			psnl0133SrhVo.setSystemkey(params.get("systemkey"));
			
			egovResultDataList = psnl0133DAO.selectPsnl0133(psnl0133SrhVo);
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					Psnl0133DTO dto = new Psnl0133DTO();
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
		
		return new BaseListLoadResult<Psnl0133DTO>(returnValue);
	}

	@Override
	public String savePsnl0133(ArrayList<Psnl0133DTO> changePsnl0133List)throws Exception {
		
		// TODO Auto-generated method stub
		int delCnt = 0;
		int saveCnt = 0;
		
		String method = calledClass + ".savePsnl0133";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		String windowNm = "인사";
		String windowId = "PSNL0100/PSNL0200";
		Psnl0133VO psnl0133Vo = new Psnl0133VO(); 
		
		try{
			if(changePsnl0133List!=null && changePsnl0133List.size() > 0){
				for ( int i = 0; i < changePsnl0133List.size(); i++){
					
					psnl0133Vo = new Psnl0133VO(); 
					
					
					psnl0133Vo.setDpobCd(MSFSharedUtils.allowNulls(changePsnl0133List.get(i).getDpobCd()));    					/** column 사업장코드 : dpobCd */
					psnl0133Vo.setSystemkey(MSFSharedUtils.allowNulls(changePsnl0133List.get(i).getSystemkey()));    			/** column SYSTEMKEY : systemkey */
//					psnl0133Vo.setDutySittnSeilNum(psnl0133Dto.getDutySittnSeilNum());    /** column 근무상황일련번호 : dutySittnSeilNum */
					psnl0133Vo.setDutySittnTtl(MSFSharedUtils.allowNulls(changePsnl0133List.get(i).getDutySittnTtl()));    		/** column 근무상황제목 : dutySittnTtl */
					psnl0133Vo.setDutySittnCmptnDt(MSFSharedUtils.allowNulls(SmrmfUtils.getStringFromDate(changePsnl0133List.get(i).getDutySittnCmptnDt(), "yyyyMMdd")));	/** column 근무상황작성일자 : dutySittnCmptnDt */
					psnl0133Vo.setDutySittnPpgPern(MSFSharedUtils.allowNulls(changePsnl0133List.get(i).getDutySittnPpgPern()));	/** column 근무상황작성자 : dutySittnPpgPern */
					psnl0133Vo.setDutyDeptCd(MSFSharedUtils.allowNulls(changePsnl0133List.get(i).getDutyDeptCd()));				/** column 근무상황부서명 : dutyDeptCd */
					psnl0133Vo.setDutySittnCtnt(MSFSharedUtils.allowNulls(changePsnl0133List.get(i).getDutySittnCtnt()));    	/** column 근무상황내용 : dutySittnCtnt */
					psnl0133Vo.setDutySittnSgctrt(MSFSharedUtils.allowNulls(changePsnl0133List.get(i).getDutySittnSgctrt())); 	/** column 근무상황특이사항 : dutySittnSgctrt */
					
					
					if(changePsnl0133List.get(i).getDelChk()){
						psnl0133Vo.setDutySittnSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0133List.get(i).getDutySittnSeilNum(), "0")));		/** column 근무상황일련번호 : dutySittnSeilNum */
						
						psnl0133DAO.deletePsnl0133(psnl0133Vo);
						delCnt++;
						
					}else{
						
						if(changePsnl0133List.get(i).getDutySittnSeilNum() != null){
							psnl0133Vo.setDutySittnSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0133List.get(i).getDutySittnSeilNum(), "0")));	/** column 근무상황일련번호 : dutySittnSeilNum */
							
							
							psnl0133Vo.setIsmt(sessionUser.getUsrId());    											/** column 수정자 : ismt */
							psnl0133Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    	/** column 수정주소 : revnAddr */
							
							psnl0133DAO.updatePsnl0133(psnl0133Vo);
							
						}else{
							psnl0133Vo.setDutySittnSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0133List.get(i).getDutySittnSeilNum(), "0")));	/** column 근무상황일련번호 : dutySittnSeilNum */
							
							
							psnl0133Vo.setKybdr(sessionUser.getUsrId());    										/** column 입력자 : kybdr */
							psnl0133Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    	/** column 입력주소 : inptAddr */
							
							psnl0133Vo.setIsmt(sessionUser.getUsrId());    											/** column 수정자 : ismt */
							psnl0133Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    	/** column 수정주소 : revnAddr */
							
							psnl0133DAO.insertPsnl0133(psnl0133Vo);
							
						}
						
						saveCnt++;
						
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"C:U:D",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "C:U:D");
		
		return "저장:"+saveCnt+",삭제:"+delCnt;
	}
  
	
}
