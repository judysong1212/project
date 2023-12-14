package com.app.exterms.personal.server.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.app.exterms.personal.client.dto.Psnl0115DTO;
import com.app.exterms.personal.client.service.Psnl0115Service;
import com.app.exterms.personal.server.service.dao.Psnl0115DAO;
import com.app.exterms.personal.server.vo.Psnl0115VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;

/**
 * @Class Name : Psnl0115ServiceImpl.java
 * @Description : Psnl0115 Business Implement class
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
@Service("psnl0115Service")
public class Psnl0115ServiceImpl extends AbstractCustomServiceImpl implements
        Psnl0115Service {

    @Resource(name="psnl0115DAO")
    private Psnl0115DAO psnl0115DAO;
    
    private static final Logger logger = LoggerFactory.getLogger(Psnl0115ServiceImpl.class);
    private static final String calledClass = Psnl0115ServiceImpl.class.getName();

    

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public BaseListLoadResult<Psnl0115DTO> selectPsnl0115(
			BaseListLoadConfig config, HashMap<String, String> params)
			throws Exception {
		
		// TODO Auto-generated method stub
		List<Psnl0115DTO> returnValue = new ArrayList<Psnl0115DTO>();
		List egovResultDataList = new ArrayList();
		
		String method = calledClass + ".selectPsnl0115";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		String windowNm = "인사";
		String windowId = "PSNL0100/PSNL0200";
		
		
		try {
			
			// 암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			
			egovResultDataList = psnl0115DAO.selectPsnl0115(params);
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					Psnl0115DTO dto = new Psnl0115DTO();
					
					String rrnDecCrypt = "";
					
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
					
					// 연말정산 정산여부CheckBox 
					if("Y".equals(dto.getYrtxYn())) {
						dto.setYrtxYnChk(true);
					}else {
						dto.setYrtxYnChk(false);
					}
					
					// 부양여부CheckBox
					if("Y".equals(dto.getFamySupptYn())) {
						dto.setFamySupptYnChk(true);
					}else {
						dto.setFamySupptYnChk(false);
					}
					
					// 주민번호 복호화
					rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dto.getFamyResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
					dto.setFamyResnRegnNum(rrnDecCrypt);
					
					
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
		
		return new BaseListLoadResult<Psnl0115DTO>(returnValue);
	}

	@Override
	public String savePsnl0115(ArrayList<Psnl0115DTO> changePsnl0115List)
			throws Exception {
		
		String method = calledClass + ".savePsnl0115";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		

		String windowNm = "인사";
		String windowId = "PSNL0100/PSNL0200";
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		// TODO Auto-generated method stub
		int delCnt = 0;
		int saveCnt = 0;
		
		try{
			if(changePsnl0115List!=null && changePsnl0115List.size() > 0){
				for ( int i = 0; i < changePsnl0115List.size(); i++){
					
					Psnl0115VO psnl0115Vo = new Psnl0115VO();
					
					psnl0115Vo.setDpobCd(MSFSharedUtils.allowNulls(changePsnl0115List.get(i).getDpobCd()));							/** column 사업장코드 : dpobCd */
					psnl0115Vo.setSystemkey(MSFSharedUtils.allowNulls(changePsnl0115List.get(i).getSystemkey()));    				/** column SYSTEMKEY : systemkey */
					
					psnl0115Vo.setFamyRelaDivCd(MSFSharedUtils.allowNulls(changePsnl0115List.get(i).getFamyRelaDivCd()));			/** column 가족관계구분코드 : famyRelaDivCd */
					psnl0115Vo.setFamyNm(MSFSharedUtils.allowNulls(changePsnl0115List.get(i).getFamyNm()));    						/** column 가족성명 : famyNm */
//					psnl0115Vo.setFamyResnRegnNum(MSFSharedUtils.allowNulls(changePsnl0115List.get(i).getFamyResnRegnNum()));  	 	/** column 가족주민등록번호 : famyResnRegnNum */
					
					// 2. 파라미터 보낼 때(암호화)
					psnl0115Vo.setFamyResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(
							changePsnl0115List.get(i).getFamyResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));			/** column 가족주민등록번호 : famyResnRegnNum */
					
					
					psnl0115Vo.setYoobhMnthDay(MSFSharedUtils.allowNulls(changePsnl0115List.get(i).getYoobhMnthDay())); 			/** column 생년월일 : yoobhMnthDay */
					psnl0115Vo.setSclcDivCd(MSFSharedUtils.allowNulls(changePsnl0115List.get(i).getSclcDivCd()));    				/** column 음양구분코드 : sclcDivCd */
					psnl0115Vo.setAcadAbtyDivCd(MSFSharedUtils.allowNulls(changePsnl0115List.get(i).getAcadAbtyDivCd()));    		/** column 학력구분코드 : acadAbtyDivCd */
					psnl0115Vo.setSchlNm(MSFSharedUtils.allowNulls(changePsnl0115List.get(i).getSchlNm()));    						/** column 학교명 : schlNm */
					psnl0115Vo.setCrrCd(MSFSharedUtils.allowNulls(changePsnl0115List.get(i).getCrrCd()));    						/** column 직업명 : crrCd */
					psnl0115Vo.setWkOfcNm(MSFSharedUtils.allowNulls(changePsnl0115List.get(i).getWkOfcNm()));    					/** column 직장명 : wkOfcNm */
					psnl0115Vo.setInbyNm(MSFSharedUtils.allowNulls(changePsnl0115List.get(i).getInbyNm()));    						/** column 직위명 : inbyNm */
					psnl0115Vo.setFrgnrYn(MSFSharedUtils.allowNulls(changePsnl0115List.get(i).getFrgnrYn()));    					/** column 외국인여부 : frgnrYn */
					psnl0115Vo.setDabtyDivCd(MSFSharedUtils.allowNulls(changePsnl0115List.get(i).getDabtyDivCd()));    				/** column 장애구분코드 : dabtyDivCd */
					psnl0115Vo.setDabtyGrdeCd(MSFSharedUtils.allowNulls(changePsnl0115List.get(i).getDabtyGrdeCd()));  		 		/** column 장애등급코드 : dabtyGrdeCd */
					psnl0115Vo.setFamyPartNoteCtnt(MSFSharedUtils.allowNulls(changePsnl0115List.get(i).getFamyPartNoteCtnt()));    	/** column 가족사항비고내용 : famyPartNoteCtnt */
					psnl0115Vo.setNatnCd(MSFSharedUtils.allowNulls(changePsnl0115List.get(i).getNatnCd()));    						/** column 국가코드 : natnCd */
					psnl0115Vo.setFamyChbttYn(MSFSharedUtils.allowNulls(changePsnl0115List.get(i).getFamyChbttYn()));   			/** column 가족동거여부 : famyChbttYn */
					psnl0115Vo.setFamyAllwYn(MSFSharedUtils.allowNulls(changePsnl0115List.get(i).getFamyAllwYn()));    				/** column 가족수당여부 : famyAllwYn */
					psnl0115Vo.setSchlExpnAdmclYn(MSFSharedUtils.allowNulls(changePsnl0115List.get(i).getSchlExpnAdmclYn()));							/** column 학비보조여부 : schlExpnAdmclYn */
					
					
					psnl0115Vo.setYrtxYn(changePsnl0115List.get(i).getYrtxYnChk()?"Y":"N");
					psnl0115Vo.setFamySupptYn(changePsnl0115List.get(i).getFamySupptYnChk()?"Y":"N");
					
					
//					if(changePsnl0115List.get(i).getYrtxYnChk()){
//						psnl0115Vo.setYrtxYn("Y");
//					}else {
//						psnl0115Vo.setYrtxYn("N");
//					}
//					
//					if(changePsnl0115List.get(i).getFamySupptYnChk()){
//						psnl0115Vo.setFamySupptYn("Y");
//					}else {
//						psnl0115Vo.setFamySupptYn("N");
//					}
					
//					psnl0115Vo.setYrtxYn(changePsnl0115List.get(i).getYrtxYnChk()  ? "Y":"N");   									/** column 연말정산여부 : yrtxYn */
//					psnl0115Vo.setFamySupptYn(changePsnl0115List.get(i).getFamySupptYnChk()?"Y":"N"); 								/** column 부양여부 : famySupptYn */
					psnl0115Vo.setFamySupptRelaDivCd(MSFSharedUtils.allowNulls(changePsnl0115List.get(i).getFamySupptRelaDivCd())); /** column 연말정산부양관계코드 : famySupptRelaDivCd */
					
					
					if(changePsnl0115List.get(i).getDelChk()){
						psnl0115Vo.setFamySeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0115List.get(i).getFamySeilNum(), "0")));	/** column 가족일련번호 : famySeilNum */
//						psnl0115DAO.deletePsnl0115(changePsnl0115List.get(i));
						psnl0115DAO.deletePsnl0115(psnl0115Vo);
						delCnt++;
						
					}else{
//						MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
						changePsnl0115List.get(i).setIsmt(sessionUser.getUsrId());
						changePsnl0115List.get(i).setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
						
						psnl0115Vo.setIsmt(sessionUser.getUsrId());
						psnl0115Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
						
						if(changePsnl0115List.get(i).getFamySeilNum() != null){
							psnl0115Vo.setFamySeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0115List.get(i).getFamySeilNum(), "0")));	/** column 가족일련번호 : famySeilNum */
//							psnl0115DAO.updatePsnl0115(changePsnl0115List.get(i));
							psnl0115DAO.updatePsnl0115(psnl0115Vo);
							
						}else{
							psnl0115Vo.setFamySeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0115List.get(i).getFamySeilNum(), "0")));	/** column 가족일련번호 : famySeilNum */
//							psnl0115DAO.insertPsnl0115(changePsnl0115List.get(i));
							psnl0115DAO.insertPsnl0115(psnl0115Vo);
							
						}
						saveCnt++;
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U:D:C",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "U:D:C");
		
		return "저장:"+saveCnt+",삭제:"+delCnt;
	}
    
}
