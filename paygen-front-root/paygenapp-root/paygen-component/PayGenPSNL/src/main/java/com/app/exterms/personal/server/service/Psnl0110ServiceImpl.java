package com.app.exterms.personal.server.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.utils.SmrmfUtils;
import org.msf.utils.TimingInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.exterms.personal.client.dto.Psnl0100DTO;
import com.app.exterms.personal.client.dto.Psnl0110DTO;
import com.app.exterms.personal.client.dto.Psnl0110_02DTO;
import com.app.exterms.personal.client.service.Psnl0110Service;
import com.app.exterms.personal.server.service.dao.Psnl0100DAO;
import com.app.exterms.personal.server.service.dao.Psnl0101DAO;
import com.app.exterms.personal.server.service.dao.Psnl0110DAO;
import com.app.exterms.personal.server.service.dao.Psnl0123DAO;
import com.app.exterms.personal.server.service.dao.Psnl0127DAO;
import com.app.exterms.personal.server.vo.Psnl0101VO;
import com.app.exterms.personal.server.vo.Psnl0110SrhVO;
import com.app.exterms.personal.server.vo.Psnl0110VO;
import com.app.exterms.personal.server.vo.Psnl0123VO;
import com.app.exterms.personal.server.vo.Psnl0127SrhVO;
import com.app.exterms.personal.server.vo.Psnl0127VO;
import com.app.exterms.personal.shared.PsnlDaoConstants;
import com.app.exterms.prgm.server.service.dao.PrgmComBass0400DAO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnOrder;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFErrorMessage;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.basis.server.service.dao.InfcPkgBass0360DAO;
import com.app.smrmf.infc.basis.server.vo.InfcPkgBass0360SrhVO;
import com.app.smrmf.infc.basis.server.vo.InfcPkgBass0360VO;
import com.app.smrmf.infc.insurance.server.service.dao.InfcPkgInsr3000DAO;
import com.app.smrmf.infc.insurance.server.service.dao.InfcPkgInsr4100DAO;
import com.app.smrmf.infc.insurance.server.service.dao.InfcPkgInsr5100DAO;
import com.app.smrmf.infc.insurance.server.service.dao.InfcPkgInsr6100DAO;
import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr3000SrhVO;
import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr3000VO;
import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr4100VO;
import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr5100VO;
import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr6100VO;
import com.app.smrmf.props.ExtermsProps;
import com.ext.constants.PropPayGenConfs;
import com.ext.constants.SysmConf;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * @Class Name : Psnl0110ServiceImpl.java
 * @Description : Psnl0110 Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2015.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@SuppressWarnings("serial")
@Service("psnl0110Service")
public class Psnl0110ServiceImpl extends AbstractCustomServiceImpl  implements
        Psnl0110Service, PsnlDaoConstants {

    
    @Resource(name="psnl0100DAO")
    private Psnl0100DAO psnl0100DAO;
    
    @Resource(name="psnl0101DAO")
    private Psnl0101DAO psnl0101DAO;
    
    @Resource(name="psnl0110DAO")
    private Psnl0110DAO psnl0110DAO;
    
    @Resource(name="psnl0123DAO")
    private Psnl0123DAO psnl0123DAO;
    
	@Autowired
    @Resource(name="psnl0127DAO")
    private Psnl0127DAO psnl0127DAO;
    
    @Resource(name="InfcPkgInsr3000DAO")
    private InfcPkgInsr3000DAO infcInsr3000DAO;
    
    @Resource(name="InfcPkgInsr4100DAO")
    private InfcPkgInsr4100DAO infcInsr4100DAO;
    
    
    @Resource(name="InfcPkgInsr5100DAO")
    private InfcPkgInsr5100DAO infcInsr5100DAO;
    
    
    @Resource(name="InfcPkgInsr6100DAO")
    private InfcPkgInsr6100DAO infcInsr6100DAO;
    
    @Resource(name="InfcPkgBass0360DAO")
    private InfcPkgBass0360DAO infcBass0360DAO;
    
    @Resource(name="PrgmComBass0400DAO")
    private PrgmComBass0400DAO bass0400DAO;
    
    
    
    /** ID Generation */
    //@Resource(name="{egovPsnl0110IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

    private static final Logger logger = LoggerFactory.getLogger(Psnl0110ServiceImpl.class);
    private static final String calledClass = Psnl0110ServiceImpl.class.getName();
    
  //20210520_양평 근무시간 조회시 적용
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public BaseListLoadResult<Psnl0110DTO> selectPsnl0110(BaseListLoadConfig config, HashMap<String, String> params)throws MSFException {
		
		String windowNm = "인사";
		String windowId = "PSNL0100/PSNL0200";
		
		// TODO Auto-generated method stub
		List<Psnl0110DTO> returnValue = new ArrayList<Psnl0110DTO>();
		List egovResultDataList = new ArrayList();
		
		String method = calledClass + ".deleteHist0100";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		
		try {
			
			egovResultDataList = psnl0110DAO.selectPsnl0110(params);
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					Psnl0110DTO dto = new Psnl0110DTO();
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
		
		return new BaseListLoadResult<Psnl0110DTO>(returnValue);
	}
	
	

	@Override
	public String savePsnl0110(ArrayList<Psnl0110DTO> changePsnl0110List)
			throws MSFException {
		// TODO Auto-generated method stub
		
		String windowNm = "인사";
		String windowId = "PSNL0100/PSNL0200";
		
		String method = calledClass + ".savePsnl0110";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		Psnl0110VO psnl0110Vo = new Psnl0110VO();
		
		HashMap<String, String> extGlobals = SysmConf.getPayGenConfigInfo(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest()); 
		
		int delCnt = 0;
		int saveCnt = 0;
		
		String strPayrMangDeptCd = "";
		
		try{
			if(changePsnl0110List!=null && changePsnl0110List.size() > 0){
				for ( int i = 0; i < changePsnl0110List.size(); i++){
					
					psnl0110Vo.setDpobCd(MSFSharedUtils.allowNulls(changePsnl0110List.get(i).getDpobCd()));										/** column 사업장코드 : dpobCd */
					psnl0110Vo.setSystemkey(MSFSharedUtils.allowNulls(changePsnl0110List.get(i).getSystemkey()));								/** column SYSTEMKEY : systemkey */
					psnl0110Vo.setEmymtDivCd(MSFSharedUtils.allowNulls(changePsnl0110List.get(i).getEmymtDivCd()));								/** column 고용구분코드 : emymtDivCd */
					psnl0110Vo.setEmymtTypCd(MSFSharedUtils.allowNulls(changePsnl0110List.get(i).getEmymtTypCd()));								/** column 고용유형코드 : emymtTypCd */
//					psnl0110Vo.setEmymtBgnnDt(SmrmfUtils.getStringFromDate(changePsnl0110List.get(i).getEmymtBgnnDt(), "yyyyMMdd"));/** column 고용시작일자 : emymtBgnnDt */
//					psnl0110Vo.setEmymtEndDt(SmrmfUtils.getStringFromDate(changePsnl0110List.get(i).getEmymtEndDt(), "yyyyMMdd"));  /** column 고용종료일자 : emymtEndDt */
					
					psnl0110Vo.setEmymtBgnnDt(SmrmfUtils.getStringFromDate(changePsnl0110List.get(i).getEmymtBgnnDt(), "yyyyMMdd"));		/** column 고용시작일자 : emymtBgnnDt */
					psnl0110Vo.setEmymtEndDt(SmrmfUtils.getStringFromDate(changePsnl0110List.get(i).getEmymtEndDt(), "yyyyMMdd"));  		/** column 고용종료일자 : emymtEndDt */
					
					
					psnl0110Vo.setDeptCd(MSFSharedUtils.allowNulls(changePsnl0110List.get(i).getDeptCd()));    									/** column 부서코드 : deptCd */
					psnl0110Vo.setCurrPaeWorkNm(MSFSharedUtils.allowNulls(changePsnl0110List.get(i).getCurrPaeWorkNm())); 						/** column 현근무지명 : currPaeWorkNm */
					psnl0110Vo.setBusinCd(MSFSharedUtils.allowNulls(changePsnl0110List.get(i).getBusinCd()));    								/** column 사업코드 : businCd */
					psnl0110Vo.setTypOccuCd(MSFSharedUtils.allowNulls(changePsnl0110List.get(i).getTypOccuCd()));    							/** column 직종코드 : typOccuCd */
					psnl0110Vo.setOdtyCd(MSFSharedUtils.allowNulls(changePsnl0110List.get(i).getOdtyCd()));    									/** column 직책코드 : odtyCd */
					psnl0110Vo.setEmymtReasCtnt(MSFSharedUtils.allowNulls(changePsnl0110List.get(i).getEmymtReasCtnt()));  						/** column 고용사유내용 : emymtReasCtnt */
					psnl0110Vo.setCertNumHuhd(MSFSharedUtils.allowNulls(changePsnl0110List.get(i).getCertNumHuhd()));    						/** column 증번호 : certNumHuhd */
					psnl0110Vo.setRducBgnnDt(MSFSharedUtils.allowNulls(changePsnl0110List.get(i).getRducBgnnDt()));    							/** column 경감시작일자 : rducBgnnDt */
					psnl0110Vo.setRducEndDt(MSFSharedUtils.allowNulls(changePsnl0110List.get(i).getRducEndDt()));    							/** column 경감종료일자 : rducEndDt */
//					psnl0110Vo.setPyspGrdeCd(changePsnl0110List.get(i).getp);    		/** column 호봉등급코드 : pyspGrdeCd */
					psnl0110Vo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(changePsnl0110List.get(i).getDtilOccuInttnCd()));					/** column 직종세통합코드 : dtilOccuInttnCd */
					psnl0110Vo.setRetryReasCtnt((MSFSharedUtils.allowNulls(changePsnl0110List.get(i).getRetryReasCtnt())));                     /** column 퇴직사유내용 : retryReasCtnt */
					psnl0110Vo.setRetryDivCd((MSFSharedUtils.allowNulls(changePsnl0110List.get(i).getRetryDivCd())));                           /** column 퇴직이직사유구분코드 : retryDivCd */
					
					
					//삭제시
					if(changePsnl0110List.get(i).getDelChk()){
						psnl0110Vo.setEmymtSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0110List.get(i).getEmymtSeilNum(), "0")));   /** column 고용일련번호 : emymtSeilNum */
						
//						psnl0110DAO.deletePsnl0110(changePsnl0110List.get(i));
						psnl0110DAO.deletePsnl0110(psnl0110Vo);
						
//						if( "A0420990".equals(changePsnl0110List.get(i).getEmymtTypCd()) && "A0020010".equals(changePsnl0110List.get(i).getEmymtDivCd())){
//							psnl0110DAO.updateEmymtEndNull(changePsnl0110List.get(i));
//						}
						
//						// 신규 일 경우 사대보험 테이블 처리 관련
//						if("A0420010".equals(changePsnl0110List.get(i).getEmymtTypCd())) {
//                        	
//                        	// psnl0127 insert
//							// 해당년도에 데이터 있으면 삭제 후 다시 생성
//							if(MSFSharedUtils.paramNotNull(psnl0110Vo.getEmymtBgnnDt())) {
//								
//								
//								Psnl0127VO psnl0127Vo = new Psnl0127VO();
//								
//								psnl0127Vo.setDpobCd(psnl0110Vo.getDpobCd());
//								psnl0127Vo.setSystemkey(psnl0110Vo.getSystemkey());
//								psnl0127Vo.setSoctyInsurYr(psnl0110Vo.getEmymtBgnnDt().substring(0, 4));
//								
//								psnl0127Vo.setKybdr(sessionUser.getUsrId());
//								psnl0127Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//
//								psnl0127Vo.setIsmt(sessionUser.getUsrId());
//								psnl0127Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//								
//								psnl0127DAO.deletePsnl0127(psnl0127Vo);
//								psnl0127DAO.insertPsnl0127(psnl0127Vo);
//							}
//						}
						
						
						
						
						
						//공무직이면서 퇴직일 경우
						if( "A0420990".equals(psnl0110Vo.getEmymtTypCd()) && "A0020010".equals(psnl0110Vo.getEmymtDivCd())){
							psnl0110Vo.setEmymtSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0110List.get(i).getEmymtSeilNum(), "0")));   /** column 고용일련번호 : emymtSeilNum */
							
							psnl0110DAO.updateEmymtEndNull(psnl0110Vo);
						}
						
						// 휴직 A0420040 , 출산휴가 A0420080 일 경우 PSNL0123 에서도 DELETE 해준다.
						if( "A0420040".equals(psnl0110Vo.getEmymtTypCd()) || "A0420080".equals(psnl0110Vo.getEmymtTypCd())){
							
							Psnl0123VO psnl0123Vo = new Psnl0123VO();
							psnl0123Vo.setDpobCd(psnl0110Vo.getDpobCd());
							psnl0123Vo.setSystemkey(psnl0110Vo.getSystemkey());
							psnl0123Vo.setLevfAbncBgnnDt(psnl0110Vo.getEmymtBgnnDt());
							
							psnl0123DAO.deletePsnl0100ToPsnl0123(psnl0123Vo);
						}
						
						
						// 신규고용 , 공무직전환
						if( "A0420010".equals(psnl0110Vo.getEmymtTypCd()) || "A0420010".equals(psnl0110Vo.getEmymtTypCd())
							||	"A0420090".equals(psnl0110Vo.getEmymtTypCd()) || "A0420090".equals(psnl0110Vo.getEmymtTypCd())	
								){
							
							// 2017.09.22
                			// 신규고용일 경우 해당 테이블 데이터 update 처리
                			Psnl0101VO psnl0101Vo = new Psnl0101VO();
                			
                			psnl0101Vo.setDpobCd(MSFSharedUtils.allowNulls(changePsnl0110List.get(i).getDpobCd()));    								/** column 사업장코드 : dpobCd */
                			psnl0101Vo.setSystemkey(MSFSharedUtils.allowNulls(changePsnl0110List.get(i).getSystemkey()));							/** column SYSTEMKEY : systemkey */
//                			psnl0101Vo.setPsnlBseSeilNum(MSFSharedUtils.allowNulls(bmMapModel.get("psnlBseSeilNum")));    /** column 통계기준일련번호 : psnlBseSeilNum */
                			psnl0101Vo.setEmymtDivCd(MSFSharedUtils.allowNulls(changePsnl0110List.get(i).getEmymtDivCd()));   						/** column 고용구분코드 : emymtDivCd */
                			
                			psnl0101Vo.setFrstBseEmymtDt(SmrmfUtils.getStringFromDate(changePsnl0110List.get(i).getEmymtBgnnDt(), "yyyyMMdd"));		/** column 최초고용일자 : frstBseEmymtDt */
                			psnl0101Vo.setIsmt(sessionUser.getUsrId());    																			/** column 수정자 : ismt */
                			psnl0101Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());										/** column 수정주소 : revnAddr */
                			
                			
                			// 공무직전환자의 경우 해당일자를 최초고용일자로 해준다.
                			if(	"A0420090".equals(psnl0110Vo.getEmymtTypCd())) {
                				psnl0101Vo.setEmymtTypCd("A0420090");
                			}
                			
                			psnl0101DAO.deletePsnl0101(psnl0101Vo);
							psnl0101DAO.insertPsnl0101(psnl0101Vo);
							
						}
						
						delCnt++;
						
					}else{
//						MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
//						changePsnl0110List.get(i).setIsmt(sessionUser.getUsrId());
//						changePsnl0110List.get(i).setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
						psnl0110Vo.setIsmt(sessionUser.getUsrId());
						psnl0110Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
						
						//BASS0360 에 단위기관, 직종, 직종세, 부서 입력되어 있는지 체크
						strPayrMangDeptCd = checkBass0360(psnl0110Vo);
						
						if("fail".equals(strPayrMangDeptCd)) {
							MSFErrorMessage errMsg = new MSFErrorMessage("", "", 2, "고용 저장 에러가 발생했습니다."); 
					        throw MSFServerUtils.getValidationException("Psnl0100ServiceImpl.checkBass0360", errMsg, logger) ; 
						}else {
							
						}
						
						
						//changePsnl0110List.get(i).setEmymtBgnnDtStr(new SimpleDateFormat("yyyyMMdd").format(changePsnl0110List.get(i).getEmymtBgnnDt()));
						//changePsnl0110List.get(i).setEmymtEndDtStr(new SimpleDateFormat("yyyyMMdd").format(changePsnl0110List.get(i).getEmymtEndDt()));
						//2014.08.28 jungmin
						
						//공무직이면서 퇴직이 등록될 경우 바로 아래 데이터의 종료일을 업데이트 처리한다.
//						if( "A0420990".equals(changePsnl0110List.get(i).getEmymtTypCd()) && "A0020010".equals(changePsnl0110List.get(i).getEmymtDivCd())){
//							psnl0110Vo.setEmymtSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0110List.get(i).getEmymtSeilNum(), "0")));   /** column 고용일련번호 : emymtSeilNum */
//							
////							psnl0110DAO.updateEmymtEndDate(changePsnl0110List.get(i));
//							psnl0110DAO.updateEmymtEndDate(psnl0110Vo);
//							
//							//부서 및 직종이 비어 있는경우 처리를 위해 
//						//	psnl0110DAO.selectPsnl0110(changePsnl0110List.get(i));
//							
//						}
						//고용일련번호 존재시 (수정할할 경우)
						if(changePsnl0110List.get(i).getEmymtSeilNum() != null){
							psnl0110Vo.setEmymtSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0110List.get(i).getEmymtSeilNum(), "0")));   /** column 고용일련번호 : emymtSeilNum */
							
//							psnl0110DAO.updatePsnl0110(changePsnl0110List.get(i));
							//고용 정보 수정
							/**
							 * 고용 정보 수정 시 쿼리에서 
							 * 퇴직 AND 공무직 -> 직종, 직종세를 입력하지 않았을 경우 고용에서 퇴직, 휴직을 제외한 제일 최신의 값을 가져와 UPDATE
							 * 퇴직 -> 공무직, 기간제 근로자 모두 부서와 직책을 입력하지 않았을 경우 고용에서 퇴직, 휴직을 제외한 제일 최신의 값을 가져와 UPDATE 
							 * **/
							psnl0110DAO.updatePsnl0110(psnl0110Vo);
							
							if("A0420990".equals(changePsnl0110List.get(i).getEmymtTypCd())){
							    //퇴직일경우 마스터 업데이트 
							    Psnl0100DTO psnl0100Dto = new Psnl0100DTO();
							    psnl0100Dto.setDpobCd(changePsnl0110List.get(i).getDpobCd());
                                psnl0100Dto.setSystemkey(changePsnl0110List.get(i).getSystemkey());    /** column SYSTEMKEY : systemkey */
                                psnl0100Dto.setHdofcCodtnCd("A0030020");   //마스터 퇴직
                                psnl0100Dto.setRetryDt(SmrmfUtils.getStringFromDate(MSFSharedUtils.paramNull(changePsnl0110List.get(i).getEmymtEndDt()) ? changePsnl0110List.get(i).getEmymtBgnnDt() : changePsnl0110List.get(i).getEmymtEndDt(), "yyyyMMdd"));
                                psnl0100Dto.setRetryReasCtnt(changePsnl0110List.get(i).getEmymtReasCtnt()); 
                                
                                psnl0100DAO.updatePsnl0100ToPsnlStat(psnl0100Dto);
							    
							} else if("A0420040".equals(changePsnl0110List.get(i).getEmymtTypCd()) || "A0420080".equals(changePsnl0110List.get(i).getEmymtTypCd())){
                                //휴직일경우 마스터 업데이트 
                                Psnl0100DTO psnl0100Dto = new Psnl0100DTO();
                                psnl0100Dto.setDpobCd(changePsnl0110List.get(i).getDpobCd());
                                psnl0100Dto.setSystemkey(changePsnl0110List.get(i).getSystemkey());    /** column SYSTEMKEY : systemkey */
                                psnl0100Dto.setHdofcCodtnCd("A0030030");   //마스터 휴직
                                psnl0100Dto.setRetryDt(null);
                                psnl0100Dto.setRetryReasCtnt(""); 
                                
                                
                                Psnl0123VO psnl0123Vo = new Psnl0123VO();
            					
            					psnl0123Vo.setDpobCd(MSFSharedUtils.allowNulls(psnl0100Dto.getDpobCd()));													/** column 사업장코드 : dpobCd */
            					psnl0123Vo.setSystemkey(MSFSharedUtils.allowNulls(psnl0100Dto.getSystemkey()));    											/** column SYSTEMKEY : systemkey */
            					psnl0123Vo.setLevfAbncDivCd(MSFSharedUtils.allowNulls(changePsnl0110List.get(i).getEmymtTypCd()));    						/** column 휴직구분코드 : levfAbncDivCd */
            					psnl0123Vo.setLevfAbncBgnnDt(SmrmfUtils.getStringFromDate(changePsnl0110List.get(i).getEmymtBgnnDt(), "yyyyMMdd"));		/** column 휴직시작일자 : levfAbncBgnnDt */
            					psnl0123Vo.setLevfAbncEndDt(SmrmfUtils.getStringFromDate(changePsnl0110List.get(i).getEmymtEndDt(), "yyyyMMdd"));		/** column 휴직종료일자 : levfAbncEndDt */
//            					psnl0123Vo.setTurtyRntmntDt(SmrmfUtils.getStringFromDate(changePsnl0110List.get(i).getTurtyRntmntDt(), "yyyyMMdd")); 	/** column 실제복직일자 : turtyRntmntDt */
            					psnl0123Vo.setLevfAbncNoteCtnt(MSFSharedUtils.allowNulls(changePsnl0110List.get(i).getEmymtReasCtnt()));					/** column 휴직비고내용 : levfAbncNoteCtnt */
                                
            					// 휴직 이력에 시작일자와 휴직코드가 동일한게 있으면 같이 update 처리 해줌.
                            	psnl0123DAO.updatePsnl0110ToPsnl0123(psnl0123Vo);
                                psnl0100DAO.updatePsnl0100ToPsnlStat(psnl0100Dto);
                            
                             // 신규고용 또는 연장 계약일 경우    
                            } else if("A0420010".equals(changePsnl0110List.get(i).getEmymtTypCd()) || "A0420030".equals(changePsnl0110List.get(i).getEmymtTypCd())
                            		||	"A0420090".equals(changePsnl0110List.get(i).getEmymtTypCd())) {
                            	
                            		
                            	if("A0420010".equals(changePsnl0110List.get(i).getEmymtTypCd())
                            			||	"A0420090".equals(changePsnl0110List.get(i).getEmymtTypCd())) {
	                            	// 2017.09.22
	                        		// 신규고용일 경우 해당 테이블 데이터 update 처리
	                        		Psnl0101VO psnl0101Vo = new Psnl0101VO();
	                        			
	                        		psnl0101Vo.setDpobCd(MSFSharedUtils.allowNulls(changePsnl0110List.get(i).getDpobCd()));    								/** column 사업장코드 : dpobCd */
	                        		psnl0101Vo.setSystemkey(MSFSharedUtils.allowNulls(changePsnl0110List.get(i).getSystemkey()));							/** column SYSTEMKEY : systemkey */
	//                        		psnl0101Vo.setPsnlBseSeilNum(MSFSharedUtils.allowNulls(bmMapModel.get("psnlBseSeilNum")));    /** column 통계기준일련번호 : psnlBseSeilNum */
	                        		psnl0101Vo.setEmymtDivCd(MSFSharedUtils.allowNulls(changePsnl0110List.get(i).getEmymtDivCd()));   						/** column 고용구분코드 : emymtDivCd */
	                        		
	                        		psnl0101Vo.setFrstBseEmymtDt(SmrmfUtils.getStringFromDate(changePsnl0110List.get(i).getEmymtBgnnDt(), "yyyyMMdd"));		/** column 최초고용일자 : frstBseEmymtDt */
	                        		psnl0101Vo.setIsmt(sessionUser.getUsrId());    																			/** column 수정자 : ismt */
	                        		psnl0101Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());										/** column 수정주소 : revnAddr */
	                        		
	                        		
	                        		// 공무직전환자의 경우 해당일자를 최초고용일자로 해준다.
	                    			if(	"A0420090".equals(changePsnl0110List.get(i).getEmymtTypCd())) {
	                    				psnl0101Vo.setEmymtTypCd("A0420090");
	                    			}
	                        		
	                        		
	                        		psnl0101DAO.deletePsnl0101(psnl0101Vo);
	    							psnl0101DAO.insertPsnl0101(psnl0101Vo);
	                            		
	                            	
	    							// INSRT 테이블 처리
	                            	InfcPkgInsr3000VO insr3000Vo = new InfcPkgInsr3000VO();
									InfcPkgInsr4100VO insr4100Vo = new InfcPkgInsr4100VO();
									InfcPkgInsr5100VO insr5100Vo = new InfcPkgInsr5100VO();
									InfcPkgInsr6100VO insr6100Vo = new InfcPkgInsr6100VO();
									
									insr3000Vo.setDpobCd(changePsnl0110List.get(i).getDpobCd());    					/** column 사업장코드 : dpobCd */
									insr3000Vo.setSystemkey(changePsnl0110List.get(i).getSystemkey());    				/** column SYSTEMKEY : systemkey */
									insr3000Vo.setEmymtSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0110List.get(i).getEmymtSeilNum(), "0")));    /** column 고용일련번호 : emymtSeilNum */
									insr3000Vo.setKybdr(sessionUser.getUsrId());    									/** column 입력자 : kybdr */ 
									insr3000Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	/** column 입력주소 : inptAddr */ 
	
									insr4100Vo.setDpobCd(changePsnl0110List.get(i).getDpobCd());    					/** column 사업장코드 : dpobCd */
									insr4100Vo.setSystemkey(changePsnl0110List.get(i).getSystemkey());    				/** column SYSTEMKEY : systemkey */
									insr4100Vo.setEmymtSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0110List.get(i).getEmymtSeilNum(), "0")));    /** column 고용일련번호 : emymtSeilNum */ 
									insr4100Vo.setKybdr(sessionUser.getUsrId());    									/** column 입력자 : kybdr */ 
									insr4100Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	/** column 입력주소 : inptAddr */ 
	
								
									insr5100Vo.setDpobCd(changePsnl0110List.get(i).getDpobCd());    					/** column 사업장코드 : dpobCd */
									insr5100Vo.setSystemkey(changePsnl0110List.get(i).getSystemkey());    				/** column SYSTEMKEY : systemkey */
									insr5100Vo.setEmymtSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0110List.get(i).getEmymtSeilNum(), "0")));    /** column 고용일련번호 : emymtSeilNum */ 
									insr5100Vo.setKybdr(sessionUser.getUsrId());    									/** column 입력자 : kybdr */ 
									insr5100Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	/** column 입력주소 : inptAddr */ 
	
									
									insr6100Vo.setDpobCd(changePsnl0110List.get(i).getDpobCd());    					/** column 사업장코드 : dpobCd */
									insr6100Vo.setSystemkey(changePsnl0110List.get(i).getSystemkey());   	 			/** column SYSTEMKEY : systemkey */ 
									insr6100Vo.setEmymtSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0110List.get(i).getEmymtSeilNum(), "0")));    /** column 고용일련번호 : emymtSeilNum */
									insr6100Vo.setKybdr(sessionUser.getUsrId());    									/** column 입력자 : kybdr */ 
									insr6100Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	/** column 입력주소 : inptAddr */ 
	                            	
									infcInsr3000DAO.deleteInsr3000(insr3000Vo);
									infcInsr4100DAO.deleteInsr4100(insr4100Vo);
									infcInsr5100DAO.deleteInsr5100(insr5100Vo);
									infcInsr6100DAO.deleteInsr6100(insr6100Vo);
									
									infcInsr3000DAO.insertInsr3000(insr3000Vo);
									infcInsr4100DAO.insertInsr4100(insr4100Vo);
									infcInsr5100DAO.insertInsr5100(insr5100Vo);
									infcInsr6100DAO.insertInsr6100(insr6100Vo);
								
                            	}
                            	
//								if("A0420010".equals(changePsnl0110List.get(i).getEmymtTypCd())) {
									
									// PSNL0127 데이터 처리
									Psnl0127VO psnl0127Vo 	= new Psnl0127VO();
									Psnl0127VO tpPsnl0127Vo = new Psnl0127VO();
									Psnl0127SrhVO psnl0127SrhVo = new Psnl0127SrhVO();
									
									psnl0127Vo.setDpobCd(psnl0110Vo.getDpobCd());
									psnl0127Vo.setSystemkey(psnl0110Vo.getSystemkey());
									psnl0127Vo.setSoctyInsurYr(psnl0110Vo.getEmymtBgnnDt().substring(0, 4));
									
									psnl0127Vo.setKybdr(sessionUser.getUsrId());
									psnl0127Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());

									psnl0127Vo.setIsmt(sessionUser.getUsrId());
									psnl0127Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
									
										// 1. 기존 psnl0127 데이터를 가져온다.
									psnl0127SrhVo = new Psnl0127SrhVO();
									psnl0127SrhVo.setDpobCd(psnl0127Vo.getDpobCd());
									psnl0127SrhVo.setSystemkey(psnl0127Vo.getSystemkey());
									tpPsnl0127Vo = psnl0127DAO.selectPsnl0127Data(psnl0127SrhVo); 
									
										// 2. 기존 데이터 존재할 경우 해당 데이터 vo에 담아준 후 delete 처리, 데이터 없으면 그냥 delete 처리
									 if (MSFSharedUtils.paramNotNull(tpPsnl0127Vo) && MSFSharedUtils.paramNotNull(tpPsnl0127Vo.getSystemkey())) {
						                    
										 psnl0127Vo.setSoctyInsurYr(MSFSharedUtils.allowNulls(tpPsnl0127Vo.getSoctyInsurYr()));    											/** column 사회보험년도 : soctyInsurYr */
										 psnl0127Vo.setHlthInsurFlucDt(MSFSharedUtils.allowNulls(tpPsnl0127Vo.getHlthInsurFlucDt()));    									/** column 건강보험변동일자 : hlthInsurFlucDt */
										 psnl0127Vo.setHlthInsrPayTotAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(tpPsnl0127Vo.getHlthInsrPayTotAmnt(),"0")));			/** column 건강보험보수총액 : hlthInsrPayTotAmnt */
										 psnl0127Vo.setHlthInsrMnthRuntnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(tpPsnl0127Vo.getHlthInsrMnthRuntnAmnt(),"0")));    	/** column 건강보험보수월액 : hlthInsrMnthRuntnAmnt */
										 psnl0127Vo.setHlthInsrGrde(MSFSharedUtils.allowNulls(tpPsnl0127Vo.getHlthInsrGrde()));    											/** column 건강보험등급 : hlthInsrGrde */
										 psnl0127Vo.setHlthInsrCertNum(MSFSharedUtils.allowNulls(tpPsnl0127Vo.getHlthInsrCertNum()));   									/** column 건강보험증번호 : hlthInsrCertNum */
										 psnl0127Vo.setNatPennInsurFlucDt(MSFSharedUtils.allowNulls(tpPsnl0127Vo.getNatPennInsurFlucDt()));    								/** column 국민연금변동일자 : natPennInsurFlucDt */
										 psnl0127Vo.setNatPennStdIncmMnthAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(tpPsnl0127Vo.getNatPennStdIncmMnthAmnt(),"0")));	/** column 국민연금기준소득월액 : natPennStdIncmMnthAmnt */
										 psnl0127Vo.setNatPennGrde(MSFSharedUtils.allowNulls(tpPsnl0127Vo.getNatPennGrde()));    											/** column 국민연금등급 : natPennGrde */
										 psnl0127Vo.setHlthInsrApptnYn(MSFSharedUtils.allowNulls(tpPsnl0127Vo.getHlthInsrApptnYn()));    									/** column 건강보험적용여부 : hlthInsrApptnYn */
										 psnl0127Vo.setNatPennApptnYn(MSFSharedUtils.allowNulls(tpPsnl0127Vo.getNatPennApptnYn()));    										/** column 국민연금적용여부 : natPennApptnYn */
										 psnl0127Vo.setUmytInsrApptnYn(MSFSharedUtils.allowNulls(tpPsnl0127Vo.getUmytInsrApptnYn()));    									/** column 고용보험적용여부 : umytInsrApptnYn */
										 psnl0127Vo.setIdtlAccdtInsurApptnYn(MSFSharedUtils.allowNulls(tpPsnl0127Vo.getIdtlAccdtInsurApptnYn()));   				 		/** column 산재보험적용여부 : idtlAccdtInsurApptnYn */
										 psnl0127Vo.setUmytInsrFlucDt(MSFSharedUtils.allowNulls(tpPsnl0127Vo.getUmytInsrFlucDt()));    										/** column 고용보험변동일자 : umytInsrFlucDt */
										 psnl0127Vo.setUmytInsrPayTotAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(tpPsnl0127Vo.getUmytInsrPayTotAmnt(),"0")));    		/** column 고용보험보수총액 : umytInsrPayTotAmnt */
										 psnl0127Vo.setUmytInsrPayMnthAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(tpPsnl0127Vo.getUmytInsrPayMnthAmnt(),"0")));    		/** column 고용보험보수월액 : umytInsrPayMnthAmnt */
										 psnl0127Vo.setIdtlAccdtFlucDt(MSFSharedUtils.allowNulls(tpPsnl0127Vo.getIdtlAccdtFlucDt()));    									/** column 산재보험변동일자 : idtlAccdtFlucDt */
										 psnl0127Vo.setIdtlAccdtPayTotAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(tpPsnl0127Vo.getIdtlAccdtPayTotAmnt(),"0")));    		/** column 산재보험보수총액 : idtlAccdtPayTotAmnt */
										 psnl0127Vo.setIdtlAccdtPayMnthAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(tpPsnl0127Vo.getIdtlAccdtPayMnthAmnt(),"0")));    	/** column 산재보험보수월액 : idtlAccdtPayMnthAmnt */
						                    
										 psnl0127DAO.deletePsnl0127(psnl0127Vo);
										 
									 } else {
						                    
										 psnl0127Vo.setSoctyInsurYr(psnl0110Vo.getEmymtBgnnDt().substring(0, 4));
										 psnl0127DAO.deletePsnl0127(psnl0127Vo);
									 }
									
									 	// 3. 데이터 insert 처리
									 psnl0127DAO.insertPsnl0127(psnl0127Vo);
									
//								}
                            	
                            }else {
                            	
                            	// 신규고용이 아닐 경우 사대보험 테이블에서 지워줌
                            	
                            	InfcPkgInsr3000VO insr3000Vo = new InfcPkgInsr3000VO();
								InfcPkgInsr4100VO insr4100Vo = new InfcPkgInsr4100VO();
								InfcPkgInsr5100VO insr5100Vo = new InfcPkgInsr5100VO();
								InfcPkgInsr6100VO insr6100Vo = new InfcPkgInsr6100VO();
								
								insr3000Vo.setDpobCd(changePsnl0110List.get(i).getDpobCd());    					/** column 사업장코드 : dpobCd */
								insr3000Vo.setSystemkey(changePsnl0110List.get(i).getSystemkey());    				/** column SYSTEMKEY : systemkey */
								insr3000Vo.setEmymtSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0110List.get(i).getEmymtSeilNum(), "0")));    /** column 고용일련번호 : emymtSeilNum */
								insr3000Vo.setKybdr(sessionUser.getUsrId());    									/** column 입력자 : kybdr */ 
								insr3000Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	/** column 입력주소 : inptAddr */ 

								insr4100Vo.setDpobCd(changePsnl0110List.get(i).getDpobCd());    					/** column 사업장코드 : dpobCd */
								insr4100Vo.setSystemkey(changePsnl0110List.get(i).getSystemkey());    				/** column SYSTEMKEY : systemkey */
								insr4100Vo.setEmymtSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0110List.get(i).getEmymtSeilNum(), "0")));    /** column 고용일련번호 : emymtSeilNum */ 
								insr4100Vo.setKybdr(sessionUser.getUsrId());    									/** column 입력자 : kybdr */ 
								insr4100Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	/** column 입력주소 : inptAddr */ 

							
								insr5100Vo.setDpobCd(changePsnl0110List.get(i).getDpobCd());    					/** column 사업장코드 : dpobCd */
								insr5100Vo.setSystemkey(changePsnl0110List.get(i).getSystemkey());    				/** column SYSTEMKEY : systemkey */
								insr5100Vo.setEmymtSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0110List.get(i).getEmymtSeilNum(), "0")));    /** column 고용일련번호 : emymtSeilNum */ 
								insr5100Vo.setKybdr(sessionUser.getUsrId());    									/** column 입력자 : kybdr */ 
								insr5100Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	/** column 입력주소 : inptAddr */ 

								
								insr6100Vo.setDpobCd(changePsnl0110List.get(i).getDpobCd());    					/** column 사업장코드 : dpobCd */
								insr6100Vo.setSystemkey(changePsnl0110List.get(i).getSystemkey());   	 			/** column SYSTEMKEY : systemkey */ 
								insr6100Vo.setEmymtSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0110List.get(i).getEmymtSeilNum(), "0")));    /** column 고용일련번호 : emymtSeilNum */
								insr6100Vo.setKybdr(sessionUser.getUsrId());    									/** column 입력자 : kybdr */ 
								insr6100Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	/** column 입력주소 : inptAddr */ 
                            	
								infcInsr3000DAO.deleteInsr3000(insr3000Vo);
								infcInsr4100DAO.deleteInsr4100(insr4100Vo);
								infcInsr5100DAO.deleteInsr5100(insr5100Vo);
								infcInsr6100DAO.deleteInsr6100(insr6100Vo);
                            	
                            }
							
						
						
						}else{	// 고용 신규 insert 시 (고용 일련번호 존재하지 않을 경우)
							
							psnl0110Vo.setEmymtSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0110List.get(i).getEmymtSeilNum(), "0")));   /** column 고용일련번호 : emymtSeilNum */
//							psnl0110DAO.insertPsnl0110(changePsnl0110List.get(i));
							psnl0110DAO.insertPsnl0110(psnl0110Vo);
							
							
							//신규 고용일때 병역 기간을 산정하여 인사 마스터 메인에 경력기간 년 월을 업데이트 시켜준다.
							// 근속년수 및 근속년월 업데이트 처리 시작###########################################
							if("A0420010".equals(changePsnl0110List.get(i).getEmymtTypCd()) || "A0420090".equals(changePsnl0110List.get(i).getEmymtTypCd())){
								
								// 2017.09.22
								// 통계기준테이블도 같이 INSERT 처리
								Psnl0101VO psnl0101Vo = new Psnl0101VO();
								
								psnl0101Vo.setDpobCd(MSFSharedUtils.allowNulls(changePsnl0110List.get(i).getDpobCd()));    		/** column 사업장코드 : dpobCd */
								psnl0101Vo.setSystemkey(MSFSharedUtils.allowNulls(changePsnl0110List.get(i).getSystemkey()));	/** column SYSTEMKEY : systemkey */
//								psnl0101Vo.setPsnlBseSeilNum(MSFSharedUtils.allowNulls(bmMapModel.get("psnlBseSeilNum")));    /** column 통계기준일련번호 : psnlBseSeilNum */
								psnl0101Vo.setEmymtDivCd(MSFSharedUtils.allowNulls(changePsnl0110List.get(i).getEmymtDivCd()));	/** column 고용구분코드 : emymtDivCd */
								psnl0101Vo.setFrstBseEmymtDt(SmrmfUtils.getStringFromDate(
																changePsnl0110List.get(i).getEmymtBgnnDt(), "yyyyMMdd"));    	/** column 최초고용일자 : frstBseEmymtDt */
								psnl0101Vo.setKybdr(sessionUser.getUsrId());    												/** column 입력자 : kybdr */
								psnl0101Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());  			/** column 입력주소 : inptAddr */
								psnl0101Vo.setIsmt(sessionUser.getUsrId());    													/** column 수정자 : ismt */
								psnl0101Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());				/** column 수정주소 : revnAddr */

								
								// 공무직전환자의 경우 해당일자를 최초고용일자로 해준다.
                    			if(	"A0420090".equals(changePsnl0110List.get(i).getEmymtTypCd())) {
                    				psnl0101Vo.setEmymtTypCd("A0420090");
                    			}
								
								
								psnl0101DAO.deletePsnl0101(psnl0101Vo);
								psnl0101DAO.insertPsnl0101(psnl0101Vo);
								
								//100$급여소득세적용 최초입력 
//								changePsnl0110List.get(i).setAddIncmTxApptnRtoCd(ExtermsProps.getProps("PAYR_TAX_B0290020"));
								psnl0110Vo.setAddIncmTxApptnRtoCd(ExtermsProps.getProps("PAYR_TAX_B0290020"));
								
								//2014.09.18 신규고용일때 급여마스터 테이블 신규 등록처리.
//								psnl0110DAO.mergeIntoPayr0500(changePsnl0110List.get(i));
								psnl0110DAO.mergeIntoPayr0500(psnl0110Vo);
								
//								EgovMap map01 =  psnl0110DAO.selectInsrPsnl0110(changePsnl0110List.get(i));
								EgovMap map01 =  psnl0110DAO.selectInsrPsnl0110(psnl0110Vo);
								
								
//								if("A0420010".equals(changePsnl0110List.get(i).getEmymtTypCd())) {
									
								if (MSFSharedUtils.paramNotNull(map01)) {
									//신규고용인경우 4대보험 테이블에 데이터 인서트하기 
									InfcPkgInsr3000VO insr3000Vo = new InfcPkgInsr3000VO();
									InfcPkgInsr4100VO insr4100Vo = new InfcPkgInsr4100VO();
									InfcPkgInsr5100VO insr5100Vo = new InfcPkgInsr5100VO();
									InfcPkgInsr6100VO insr6100Vo = new InfcPkgInsr6100VO();
											
									
									insr3000Vo.setDpobCd(String.valueOf(map01.get("dpobCd")));    							/** column 사업장코드 : dpobCd */
									insr3000Vo.setSystemkey(String.valueOf(map01.get("systemkey")));    					/** column SYSTEMKEY : systemkey */
									insr3000Vo.setEmymtSeilNum(new BigDecimal(String.valueOf(map01.get("emymtSeilNum"))));  /** column 고용일련번호 : emymtSeilNum */
									insr3000Vo.setKybdr(sessionUser.getUsrId());    										/** column 입력자 : kybdr */ 
									insr3000Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    	/** column 입력주소 : inptAddr */ 
										
		 							insr4100Vo.setDpobCd(String.valueOf(map01.get("dpobCd")));    							/** column 사업장코드 : dpobCd */
									insr4100Vo.setSystemkey(String.valueOf(map01.get("systemkey")));    					/** column SYSTEMKEY : systemkey */
									//insr4100Vo.setNatPennSeilNum(new BigDecimal(String.valueOf(map01.get("emymtSeilNum"))));    /** column 국민연금일련번호 : natPennSeilNum */
									insr4100Vo.setEmymtSeilNum(new BigDecimal(String.valueOf(map01.get("emymtSeilNum"))));	/** column 고용일련번호 : emymtSeilNum */ 
									insr4100Vo.setKybdr(sessionUser.getUsrId());    										/** column 입력자 : kybdr */ 
									insr4100Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    	/** column 입력주소 : inptAddr */ 

									insr5100Vo.setDpobCd(String.valueOf(map01.get("dpobCd")));   				 			/** column 사업장코드 : dpobCd */
									insr5100Vo.setSystemkey(String.valueOf(map01.get("systemkey")));    					/** column SYSTEMKEY : systemkey */
									insr5100Vo.setEmymtSeilNum(new BigDecimal(String.valueOf(map01.get("emymtSeilNum"))));	/** column 고용일련번호 : emymtSeilNum */ 
									insr5100Vo.setKybdr(sessionUser.getUsrId());    										/** column 입력자 : kybdr */ 
									insr5100Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    	/** column 입력주소 : inptAddr */ 

									insr6100Vo.setDpobCd(String.valueOf(map01.get("dpobCd")));    							/** column 사업장코드 : dpobCd */
									insr6100Vo.setSystemkey(String.valueOf(map01.get("systemkey")));    					/** column SYSTEMKEY : systemkey */ 
									insr6100Vo.setEmymtSeilNum(new BigDecimal(String.valueOf(map01.get("emymtSeilNum"))));	/** column 고용일련번호 : emymtSeilNum */
									insr6100Vo.setKybdr(sessionUser.getUsrId());    										/** column 입력자 : kybdr */ 
									insr6100Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    	/** column 입력주소 : inptAddr */ 
											
									/**
									 * 단, 고용정보를 전체 다 삭제할 경우 이력이 남아있으므로 Insert시 오류나서
									 * 일단은 select 후 데이터 있으면 delete 후 다시 insert처리,  없으면 기존대로 insert 하게끔 처리함.
									 */
									InfcPkgInsr3000SrhVO insr3000SrhVo = new InfcPkgInsr3000SrhVO();
											
									insr3000SrhVo.setDpobCd(String.valueOf(map01.get("dpobCd")));    		/** column 사업장코드 : dpobCd */
									insr3000SrhVo.setSystemkey(String.valueOf(map01.get("systemkey")));    	/** column SYSTEMKEY : systemkey */

									int iCnt = infcInsr3000DAO.selectInsr3000Cnt(insr3000SrhVo);
											
									if(iCnt == 0) {	// 데이터 없으면 insert
										infcInsr3000DAO.insertInsr3000(insr3000Vo);
										infcInsr4100DAO.insertInsr4100(insr4100Vo);
										infcInsr5100DAO.insertInsr5100(insr5100Vo);
										infcInsr6100DAO.insertInsr6100(insr6100Vo);
										
									}else {			// 데이터 있으면 delete 후 insert
												
										infcInsr3000DAO.deleteInsr3000(insr3000Vo);
										infcInsr4100DAO.deleteInsr4100(insr4100Vo);
										infcInsr5100DAO.deleteInsr5100(insr5100Vo);
										infcInsr6100DAO.deleteInsr6100(insr6100Vo);
												
										infcInsr3000DAO.insertInsr3000(insr3000Vo);
										infcInsr4100DAO.insertInsr4100(insr4100Vo);
										infcInsr5100DAO.insertInsr5100(insr5100Vo);
										infcInsr6100DAO.insertInsr6100(insr6100Vo);
												
									}
								}
									
								// 고용일련번호 없는 경우 ( 신규 생성 ) 
								Psnl0127VO psnl0127Vo = new Psnl0127VO();
									
								psnl0127Vo.setDpobCd(changePsnl0110List.get(i).getDpobCd());
								psnl0127Vo.setSystemkey(changePsnl0110List.get(i).getSystemkey());
								psnl0127Vo.setSoctyInsurYr(SmrmfUtils.getStringFromDate( changePsnl0110List.get(i).getEmymtBgnnDt(), "yyyyMMdd").substring(0, 4)) ;
								psnl0127Vo.setKybdr(sessionUser.getUsrId());
								psnl0127Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
								psnl0127Vo.setIsmt(sessionUser.getUsrId());
								psnl0127Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
								
								psnl0127DAO.deletePsnl0127(psnl0127Vo);
								psnl0127DAO.insertPsnl0127(psnl0127Vo);
									
									
//								}
								
								/* 근속년수 코드 A007, 근속년월 코드 A006 : 둘다 MANAGE_ITEM01 참조
									A0290000    A029    0000    해당없음
									A0290001    A029    0001    최대 6개월
									A0290002    A029    0002    최대 1년
									A0290003    A029    0003    최대 2년
									A0290004    A029    0004    최대 3년
									A029000A    A029    000A    모두인정
								*/
//								EgovMap map = psnl0110DAO.getLogSvcData(changePsnl0110List.get(i));
								EgovMap map = psnl0110DAO.getLogSvcData(psnl0110Vo);
								
								int year = 0; //업데이트 년
								int month = 0; //업데이트 월
								if(map != null ){
									
									int diffMonths = 0;
									if (MSFSharedUtils.paramNull(map.get("diffMonths"))) {
										diffMonths = 0;
									} else {
										diffMonths = map.get("diffMonths") == null ? 0 : Integer.parseInt(String.valueOf(map.get("diffMonths")));
									}
									 if("A0290001".equals(map.get("servcRcgtnPridCd"))){
										if(diffMonths > 6){
											month = 6;
										}else{
											if (MSFSharedUtils.paramNotNull(map.get("diffMonth"))) {
												if(String.valueOf(map.get("diffMonth")) != null || "".equals(String.valueOf(map.get("diffMonth"))))  {
													month = Integer.parseInt(String.valueOf(map.get("diffMonth")));
												}
											}
										}
										
									}else if("A0290002".equals(map.get("servcRcgtnPridCd"))){
										if(diffMonths > 12){
											year = 1;
											month = 0;
										}else{
											if (MSFSharedUtils.paramNotNull(map.get("diffMonth"))) {
												if(String.valueOf(map.get("diffMonth")) != null || "".equals(String.valueOf(map.get("diffMonth"))))  {
													month = Integer.parseInt(String.valueOf(map.get("diffMonth")));
												}
											}
										}
									}else if("A0290003".equals(map.get("servcRcgtnPridCd"))){
										if(diffMonths > 24){
											year = 2;
											month = 0;
										}else{
											if (MSFSharedUtils.paramNotNull(map.get("diffYear"))) {	
												if(String.valueOf(map.get("diffYear")) != null || "".equals(String.valueOf(map.get("diffYear"))))  {
													year = Integer.parseInt(String.valueOf(map.get("diffYear")));
												}
												
												if(String.valueOf(map.get("diffMonth")) != null || "".equals(String.valueOf(map.get("diffMonth"))))  {
													month = Integer.parseInt(String.valueOf(map.get("diffMonth")));
												}
											}
										}
									}else if("A0290004".equals(map.get("servcRcgtnPridCd"))){
										if(diffMonths > 36){
											year = 3;
											month = 0;
										}else{
											if (MSFSharedUtils.paramNotNull(map.get("diffYear"))) {		
												if(String.valueOf(map.get("diffYear")) != null || "".equals(String.valueOf(map.get("diffYear"))))  {
													year = Integer.parseInt(String.valueOf(map.get("diffYear")));
												}
												
												
												if(String.valueOf(map.get("diffMonth")) != null || "".equals(String.valueOf(map.get("diffMonth"))))  {
													month = Integer.parseInt(String.valueOf(map.get("diffMonth")));
												}
	//											year = Integer.parseInt(String.valueOf(map.get("diffYear")));
	//											month = Integer.parseInt(String.valueOf(map.get("diffMonth")));
											}	
										}
									}else if("A029000A".equals(map.get("servcRcgtnPridCd"))){
										
										if (MSFSharedUtils.paramNotNull(map.get("diffYear"))) {		
											if(String.valueOf(map.get("diffYear")) != null || "".equals(String.valueOf(map.get("diffYear"))))  {
												year = Integer.parseInt(String.valueOf(map.get("diffYear")));
											}
											
											
											if(String.valueOf(map.get("diffMonth")) != null || "".equals(String.valueOf(map.get("diffMonth"))))  {
												month = Integer.parseInt(String.valueOf(map.get("diffMonth")));
											}
										}
//										year = Integer.parseInt(String.valueOf(map.get("diffYear")));
//										month = Integer.parseInt(String.valueOf(map.get("diffMonth")));
									}
								}
								HashMap<String, String> tempMap = new HashMap<String, String>();
								tempMap.put("dpobCd", changePsnl0110List.get(i).getDpobCd());
								tempMap.put("systemkey", changePsnl0110List.get(i).getSystemkey());
								
								psnl0110Vo.setDpobCd(tempMap.get("dpobCd"));
								psnl0110Vo.setSystemkey(tempMap.get("systemkey"));
								
								
								if(year>0){
									tempMap.put("year",year+"");
									psnl0110Vo.setYear(tempMap.get("year"));
									
									try{
//										psnl0110DAO.updateYearMst(tempMap);
										psnl0110DAO.updateYearMst(psnl0110Vo);
									}catch(Exception e) {
										MSFErrorMessage errMsg = new MSFErrorMessage("", "", 2, "고용 저장 에러가 발생했습니다. : updateYearMst" + e); 
								        throw MSFServerUtils.getValidationException("Psnl0110ServiceImpl.psnl0110DAO.updateYearMst", errMsg, logger) ; 
									}
								}
								if(month>0){
									tempMap.put("month",month+"");
									psnl0110Vo.setMonth(tempMap.get("month"));
									
									try{
//										psnl0110DAO.updateYearMst(tempMap);
										psnl0110DAO.updateMonthMst(psnl0110Vo);
									}catch(Exception e) {
										MSFErrorMessage errMsg = new MSFErrorMessage("", "", 2, "고용 저장 에러가 발생했습니다. : updateMonthMst" + e); 
								        throw MSFServerUtils.getValidationException("Psnl0110ServiceImpl.psnl0110DAO.updateMonthMst", errMsg, logger) ; 
									}
									
//									psnl0110DAO.updateMonthMst(tempMap);
									
								}
								tempMap = new HashMap<String, String>();
								// 근속년수 및 근속년월 업데이트 처리 끝###########################################
							} else if("A0420990".equals(changePsnl0110List.get(i).getEmymtTypCd())){
							    //퇴직일경우 마스터 업데이트 
							    Psnl0100DTO psnl0100Dto = new Psnl0100DTO();
							    psnl0100Dto.setDpobCd(changePsnl0110List.get(i).getDpobCd());
                                psnl0100Dto.setSystemkey(changePsnl0110List.get(i).getSystemkey());    /** column SYSTEMKEY : systemkey */
                                psnl0100Dto.setHdofcCodtnCd("A0030020");   //마스터 퇴
                                psnl0100Dto.setRetryDt(SmrmfUtils.getStringFromDate(MSFSharedUtils.paramNull(changePsnl0110List.get(i).getEmymtEndDt()) ? changePsnl0110List.get(i).getEmymtBgnnDt() : changePsnl0110List.get(i).getEmymtEndDt(), "yyyyMMdd"));
                                psnl0100Dto.setRetryReasCtnt(changePsnl0110List.get(i).getEmymtReasCtnt()); 
                                
                                
                                try{
                                	psnl0100DAO.updatePsnl0100ToPsnlStat(psnl0100Dto);
								}catch(Exception e) {
									MSFErrorMessage errMsg = new MSFErrorMessage("", "", 2, "고용 저장 에러가 발생했습니다. : updatePsnl0100ToPsnlStat" + e); 
							        throw MSFServerUtils.getValidationException("Psnl0110ServiceImpl.psnl0100DAO.updatePsnl0100ToPsnlStat(psnl0100Dto)", errMsg, logger) ; 
								}
                                
//                                psnl0100DAO.updatePsnl0100ToPsnlStat(psnl0100Dto);
							    
							} else if("A0420040".equals(changePsnl0110List.get(i).getEmymtTypCd())){
                                //휴직일경우 마스터 업데이트 
                                Psnl0100DTO psnl0100Dto = new Psnl0100DTO();
                                psnl0100Dto.setDpobCd(changePsnl0110List.get(i).getDpobCd());
                                psnl0100Dto.setSystemkey(changePsnl0110List.get(i).getSystemkey());    /** column SYSTEMKEY : systemkey */
                                psnl0100Dto.setHdofcCodtnCd("A0030030");   //마스터 휴직
                                psnl0100Dto.setRetryDt(null);
                                psnl0100Dto.setRetryReasCtnt(""); 
                                
                                
                                try{
                                	psnl0100DAO.updatePsnl0100ToPsnlStat(psnl0100Dto);
								}catch(Exception e) {
									MSFErrorMessage errMsg = new MSFErrorMessage("", "", 2, "고용 저장 에러가 발생했습니다. : updatePsnl0100ToPsnlStat" + e); 
							        throw MSFServerUtils.getValidationException("Psnl0110ServiceImpl.psnl0100DAO.updatePsnl0100ToPsnlStat(psnl0100Dto)", errMsg, logger) ; 
								}
                                
//                                psnl0100DAO.updatePsnl0100ToPsnlStat(psnl0100Dto);
                            
                            }
							
						}
						
						// 2017.06.19 공무직이면서 퇴직,전보, 직제개편 추가
						if( "A0020010".equals(changePsnl0110List.get(i).getEmymtDivCd())){
							
							if("A0420990".equals(changePsnl0110List.get(i).getEmymtTypCd()) 
									|| "A0420050".equals(changePsnl0110List.get(i).getEmymtTypCd())
									|| "A0420060".equals(changePsnl0110List.get(i).getEmymtTypCd())) {
								psnl0110Vo.setEmymtSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(changePsnl0110List.get(i).getEmymtSeilNum(), "0")));   /** column 고용일련번호 : emymtSeilNum */
								
								psnl0110DAO.updateEmymtEndDate(psnl0110Vo);
								
								//부서 및 직종이 비어 있는경우 처리를 위해 
							//	psnl0110DAO.selectPsnl0110(changePsnl0110List.get(i));
							}
						}	
						
						saveCnt++;
					}
					
					
//					// 신규 일 경우 사대보험 테이블 처리 관련
//					if("A0420010".equals(changePsnl0110List.get(i).getEmymtTypCd())) {
//                    	// psnl0127 insert
//						// 해당년도에 데이터 있으면 삭제 후 다시 생성
//						if(MSFSharedUtils.paramNotNull(psnl0110Vo.getEmymtBgnnDt())) {
//							
//							Psnl0127VO psnl0127Vo = new Psnl0127VO();
//							
//							psnl0127Vo.setDpobCd(psnl0110Vo.getDpobCd());
//							psnl0127Vo.setSystemkey(psnl0110Vo.getSystemkey());
//							psnl0127Vo.setSoctyInsurYr(psnl0110Vo.getEmymtBgnnDt().substring(0, 4));
//							
//							psnl0127Vo.setKybdr(sessionUser.getUsrId());
//							psnl0127Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//
//							psnl0127Vo.setIsmt(sessionUser.getUsrId());
//							psnl0127Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//							
//							psnl0127DAO.deletePsnl0127(psnl0127Vo);
//							psnl0127DAO.insertPsnl0127(psnl0127Vo);
//							
//						}
//					}
					
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
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S:C:U:D" );
		
		return "저장:"+saveCnt+",삭제:"+delCnt +  ";" + strPayrMangDeptCd;
	}
	
	/** 고용 등록시 입력한 직종, 직종세가 BASS00360에 등록되어 있는지 확인 후 없으면 insert, 있으면 pass **/
	public String checkBass0360(Psnl0110VO psnl0110Vo) {
		
		String windowNm = "인사";
		String windowId = "PSNL0100/PSNL0200";
		
		String method = calledClass + ".checkBass0360";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		String strResult = "";
		
		try {
			// 공무직일 경우에만 BASS360 작동
			if("A0020010".equals(psnl0110Vo.getEmymtDivCd()) && ( psnl0110Vo.getTypOccuCd() != null || !"".equals(psnl0110Vo.getTypOccuCd())) ) {
				
				//TODO  신규 A0420010 , 직제개편 A0420050, 전보 A0420060, 재고용 A0420020, 연장계약 A0420030 , 복직 A0420070, 공무직전환 A0420090
				if("A0420010".equals(psnl0110Vo.getEmymtTypCd()) 
						|| "A0420020".equals(psnl0110Vo.getEmymtTypCd())
						|| "A0420050".equals(psnl0110Vo.getEmymtTypCd()) 
						|| "A0420060".equals(psnl0110Vo.getEmymtTypCd())
						|| "A0420030".equals(psnl0110Vo.getEmymtTypCd())
						|| "A0420070".equals(psnl0110Vo.getEmymtTypCd())
						|| "A0420090".equals(psnl0110Vo.getEmymtTypCd())	
						
						) {
					
					InfcPkgBass0360SrhVO infcBass0360SrhVo = new InfcPkgBass0360SrhVO();
					
					infcBass0360SrhVo.setDpobCd(psnl0110Vo.getDpobCd());
					infcBass0360SrhVo.setDeptCd(psnl0110Vo.getDeptCd());
					infcBass0360SrhVo.setTypOccuCd(psnl0110Vo.getTypOccuCd());
					infcBass0360SrhVo.setDtilOccuInttnCd(psnl0110Vo.getDtilOccuInttnCd());
					
					
					InfcPkgBass0360VO infcBass0360Vo = new InfcPkgBass0360VO();
					
					//단위기관 코드를 가져옴
					@SuppressWarnings("unused")
					List infcBass0360List = infcBass0360DAO.getPayrMangDeptCd(infcBass0360SrhVo);
//					infcBass0360Vo = infcBass0360DAO.getPayrMangDeptCd(infcBass0360SrhVo);
					
					for (int i = 0; i < infcBass0360List.size(); i++) {
						EgovMap egovMap = (EgovMap) infcBass0360List.get(i);
						infcBass0360SrhVo.setPayrMangDeptCd(String.valueOf(egovMap.get("payrMangDeptCd")));
					}
					
//					infcBass0360SrhVo.setPayrMangDeptCd(infcBass0360Vo.getPayrMangDeptCd());
					
					// 2016.09.07
					// 사업장, 부서, 직종, 직종세 비교 후 맞는 데이터가 없으면 insert
					// 없으면 단위기관 코드가 없을 경우만 update 처리..
					int iResult = infcBass0360DAO.selectBass0360ListTotCnt(infcBass0360SrhVo);
					
					
					infcBass0360Vo = new InfcPkgBass0360VO();
					infcBass0360Vo.setDpobCd(infcBass0360SrhVo.getDpobCd());
					infcBass0360Vo.setDeptCd(infcBass0360SrhVo.getDeptCd());
					infcBass0360Vo.setTypOccuCd(infcBass0360SrhVo.getTypOccuCd());
					infcBass0360Vo.setDtilOccuInttnCd(infcBass0360SrhVo.getDtilOccuInttnCd());
					infcBass0360Vo.setPayrMangDeptCd(infcBass0360SrhVo.getPayrMangDeptCd());
	
			
					
					
					if(iResult == 0) {
						
						infcBass0360Vo.setKybdr(sessionUser.getUsrId());
						infcBass0360Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
						
						infcBass0360DAO.insertBass0360(infcBass0360Vo);
//						strResult = infcBass0360Vo.getPayrMangDeptCd();
						
					}else{
						
						infcBass0360Vo.setIsmt(sessionUser.getUsrId());
						infcBass0360Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
						
						// 단위기관이 맵핑되어 있지 않은 데이터를 맵핑하여 사용한다.
						infcBass0360DAO.updateBass0360PayrMangDeptCd(infcBass0360Vo);
						
						
					}
					
//					// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//					// 1. 가장 최신의 고용 이력 정보를 가져온다. (신규고용, 재고용, 직제개편, 전보 중)
//					Psnl0110SrhVO psnl0110SrhVo = new Psnl0110SrhVO();
//					psnl0110SrhVo.setDpobCd(psnl0110Vo.getDpobCd());
//					psnl0110SrhVo.setSystemkey(psnl0110Vo.getSystemkey());
//					
//					
//					Psnl0110VO returnPsnl0110Vo = new Psnl0110VO();
//					returnPsnl0110Vo = psnl0110DAO.selectPsnl0110MaxData(psnl0110SrhVo);
//					// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//					
//					
//					// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//					// 2. 해당 고용 정보를 가지고 단위기관 코드가 존재하는지 찾아본다.
//					// 데이터 null 체크
//					boolean datacChk = true;
//					if(MSFSharedUtils.paramNull(returnPsnl0110Vo.getDpobCd())) {
//						datacChk = false;
//					}
//					
//					if(MSFSharedUtils.paramNull(returnPsnl0110Vo.getDeptCd())) {
//						datacChk = false;
//					}
//					
//					if(MSFSharedUtils.paramNull(returnPsnl0110Vo.getTypOccuCd())) {
//						datacChk = false;
//					}
//					
//					if(MSFSharedUtils.paramNull(returnPsnl0110Vo.getDtilOccuInttnCd())) {
//						datacChk = false;
//					}
//					
//					// 데이터가 null 이 아닐 경우에만 실행.
//					iResult = 0;
//					if(datacChk) {
//						infcBass0360SrhVo.setDpobCd(returnPsnl0110Vo.getDpobCd());
//						infcBass0360SrhVo.setPayrMangDeptCd(infcBass0360Vo.getPayrMangDeptCd());
//						infcBass0360SrhVo.setDeptCd(returnPsnl0110Vo.getDeptCd());
//						infcBass0360SrhVo.setTypOccuCd(returnPsnl0110Vo.getTypOccuCd());
//						infcBass0360SrhVo.setDtilOccuInttnCd(returnPsnl0110Vo.getDtilOccuInttnCd());
//						
//						iResult = psnl0110DAO.selectBass0360PayrMangDeptCdTotCnt(infcBass0360SrhVo);
//					}
//					// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//					
//					
//					
//					// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//					// 3. 존재하면 그 값들을 가지고 PAYR0500 을 update 쳐주고 단위기관코드를 리턴, 존재하지 않을 경우 fail 리턴
//					if(0 < iResult) {
//						
//						try{
//							
//							psnl0110Vo.setPayrMangDeptCd(infcBass0360Vo.getPayrMangDeptCd());
//							psnl0110Vo.setIsmt(sessionUser.getUsrId());
//							psnl0110Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//							
//							psnl0110DAO.updatePayrMangDeptCdPayr0500(psnl0110Vo);
//							strResult = infcBass0360Vo.getPayrMangDeptCd();
//						}catch(Exception e) {
//							strResult = "fail";
//							e.printStackTrace();		
//						}
//					}else {
//						strResult = "fail";
//					}
//					// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					
				}else {
					
				}

			}else {

			}

		}catch(Exception e) {
			
			strResult = "fail";
			
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S:C:U",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);	
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S:C" );
		
		return strResult;
	}
	
	
	
	
	
	//조회
	public PagingLoadResult<BaseModel> getPsnl0100To0110DataList(ServiceParameters serviceParameters) throws MSFException {
			

			PagingLoadResult<BaseModel> retval = null;
			String method =  CLASS_PSNL0100_TO_0110_DATA_LIST;
			Psnl0110SrhVO   psnl0110SrhVO = new Psnl0110SrhVO();
//			Psnl0100VO      psnl0100VO = new Psnl0100VO();
			List<BaseModel>  bmResult = new ArrayList<BaseModel>();
			MSFSysm0100BM sessionUser;
			
			// 1. 암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		        
		        
			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}
		      
			if  (MSFSharedUtils.paramNull(psnl0110DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				psnl0110DAO = (Psnl0110DAO) wac.getBean("psnl0110DAO"); 
			}
		        
			try {
				//TODO 유저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
				ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
				IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
				List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();		
				PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

				//Get paging configuration
		    	PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

		    	//Get query parameters
//		      	String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
		      	/** 조건절 */
		    	 psnl0110SrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
		    	 psnl0110SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
//		    	 psnl0110SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));
		            
		      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
				if ( pagingValues.executeRecordCount ) { 
			            	
					//Execute query that returns a single value
		        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
		                 
		          	int iResultCnt = psnl0110DAO.selectPsnl0110ListCnt(psnl0110SrhVO);  
		              
		          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
		          	
		          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
	                if (!pagingValues.pageExecute) { 
	                    pagingValues.offsetLimit = iResultCnt;       
	                }
	                
		         	pagingValues.totalRecordCount = iResultCnt;	       
		                
		        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
				}
		        
		     	TimingInfo millisBeginPsnl0100ToPsnl0250DataList = SmrmfUtils.startTiming(logger);
		        
		     	/**페이지 카운트 처리를 위한 부분 */ 
		     	psnl0110SrhVO.setPageSize(pagingValues.totalRecordCount);  
		            
		     	//Apply paging
		     	if (pagingValues.start > 0) {
		     		psnl0110SrhVO.setFirstIndex(pagingValues.start);
		     	}
		     	if (pagingValues.offsetLimit > 0) {
		     		psnl0110SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
		     	}
	//
		     	//Execute query and convert to BaseModel list
		     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
		            
		     	@SuppressWarnings("unchecked")
//		            Collection<Map<String, Object>> list ??????
		     	List list = psnl0110DAO.selectPsnl0110List(psnl0110SrhVO);
		            
				Iterator<Map<String, Object>> iter = list.iterator();
			            
				SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
		           
		        
				while (iter.hasNext()) {
					Map<String, Object> map = (Map<String, Object>) iter.next();
					String idValue = map.get("systemkey").toString();
		        	BaseModel bm = new BaseModel();
		 
		       	//bm.setProperties(map);
		     	for ( int i=0 ; i<tableAttributes.length ; i++ ) {
		     		//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++  
		     		Object mapCon = map.get(tableAttributes[i].getName());  
		                     
		     		switch ( tableAttributes[i].getType() ) {  
		          		case ColumnDef.TYPE_DATE: 
		          		case ColumnDef.TYPE_DATETIME: 
		                       
		             	Date value =  SmrmfUtils.getDateFromString(String.valueOf(mapCon),"yyyyMMdd");
		            	map.put(tableAttributes[i].getName(), value);
		                     
		            	break; 
		            	
		          		case ColumnDef.TYPE_STRING: 
			          			
		          			String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));
		          	   			
		          			if(	"resnRegnNum".equals(tableAttributes[i].getName())) {
		          		          			
		          				String rrnDecCrypt = "";
		          		          			
		          				// TODO 주민번호 
		          				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		          		          		
		          				strValue = rrnDecCrypt;
		          							
		          			}
		          	 	                       
		          			map.put(tableAttributes[i].getName(), strValue);
		          		
		          		 break;
		                       
		          		case ColumnDef.TYPE_LONG:   
		                     
		          			if (mapCon != null) {  
		          				Long  lValue =  (new BigDecimal(mapCon.toString())).longValue() ; 
		                        map.put(tableAttributes[i].getName(), lValue); 
		                    }  
		                       
		                     break;
		                     
		          		case ColumnDef.TYPE_DOUBLE:  
		          			
		                      if (mapCon != null) {      
		                         Double dbValue = (new BigDecimal(mapCon.toString())).doubleValue(); 
		                         map.put(tableAttributes[i].getName(), dbValue); 
		                      }  
		                       
		                   	break;
		     		}
		     		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/    
		     			Object baseModelValue = null;
		            	//콤보박스처리를 위해 추가함
		     			if (tableAttributes[i].getName().contains("$")) {
		     				
		     				String strMapCon = tableAttributes[i].getName().replace("$", "").toLowerCase();
		                              
		     				map.put(tableAttributes[i].getName(),map.get(strMapCon));
		                         
		                         baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
		                                 map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
		     			} else {
		                         baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
		                                 map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
		     			}
		     		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
		                    
		                    bm.set(tableAttributes[i].getName(), baseModelValue);
		     	}

		     	bm.set(TableDef.ID_PROPERTY_NAME, idValue);
		     	bmResult.add(bm);
			} 

				retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
		            
				SmrmfUtils.endTiming(logger, millisBeginPsnl0100ToPsnl0250DataList, "getPsnl0100To0110DataList");
		       
		} catch (Exception ex) {
			ex.printStackTrace();
			// Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	
	
	
	/** 인사(무기) 기간제고용 저장/수정/삭제 처리 **/
	@Override
	public Long savePsnl0100ToPsnl0110(List<Psnl0110_02DTO> listPsnl0110Dto, ActionDatabase actionDatabase) throws MSFException {
		
		
		// TODO Auto-generated method stub
		Long result = new Long(0);
		Long iCnt = new Long(0);
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		HashMap<String, String> extGlobals = SysmConf.getPayGenConfigInfo(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest());
			
		try { 
			
			if (MSFSharedUtils.paramNull(psnl0110DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				psnl0110DAO = (Psnl0110DAO) wac.getBean("psnl0110DAO" ); 
			}

			for (int iPsnlCnt = 0; iPsnlCnt < listPsnl0110Dto.size(); iPsnlCnt++) {

				Psnl0110_02DTO psnl0110Dto = new Psnl0110_02DTO();
				psnl0110Dto = listPsnl0110Dto.get(iPsnlCnt);

				Psnl0110VO psnl0110Vo = new Psnl0110VO();
				
				

				psnl0110Vo.setDpobCd(sessionUser.getDpobCd());    												/** column 사업장코드 : dpobCd */
				psnl0110Vo.setSystemkey(MSFSharedUtils.allowNulls(psnl0110Dto.getSystemkey()));    				/** column SYSTEMKEY : systemkey */
				psnl0110Vo.setEmymtSeilNum(
						new BigDecimal(MSFSharedUtils.defaultNulls(psnl0110Dto.getEmymtSeilNum(), "0")));		/** column 고용일련번호 : emymtSeilNum */
				psnl0110Vo.setEmymtDivCd(MSFSharedUtils.allowNulls(psnl0110Dto.getEmymtDivCd()));    			/** column 고용구분코드 : emymtDivCd */
				psnl0110Vo.setEmymtTypCd(MSFSharedUtils.allowNulls(psnl0110Dto.getEmymtTypCd()));    			/** column 고용유형코드 : emymtTypCd */
				psnl0110Vo.setEmymtBgnnDt(MSFSharedUtils.allowNulls(psnl0110Dto.getEmymtBgnnDt()));    			/** column 고용시작일자 : emymtBgnnDt */
				psnl0110Vo.setEmymtEndDt(MSFSharedUtils.allowNulls(psnl0110Dto.getEmymtEndDt()));    			/** column 고용종료일자 : emymtEndDt */
				psnl0110Vo.setDeptCd(MSFSharedUtils.allowNulls(psnl0110Dto.getDeptCd()));    					/** column 부서코드 : deptCd */
				psnl0110Vo.setBusinCd(MSFSharedUtils.allowNulls(psnl0110Dto.getBusinCd()));    					/** column 사업코드 : businCd */
				psnl0110Vo.setCurrPaeWorkNm(MSFSharedUtils.allowNulls(psnl0110Dto.getCurrPaeWorkNm()));    		/** column 현근무지명 : currPaeWorkNm */
				psnl0110Vo.setOdtyCd(MSFSharedUtils.allowNulls(psnl0110Dto.getOdtyCd()));    					/** column 직책코드 : odtyCd */
				psnl0110Vo.setEmymtReasCtnt(MSFSharedUtils.allowNulls(psnl0110Dto.getEmymtReasCtnt()));    		/** column 고용사유내용 : emymtReasCtnt */
		             
				switch (actionDatabase) {
				case INSERT:

					psnl0110Vo.setKybdr(sessionUser.getUsrId());
					psnl0110Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());

					psnl0110Vo.setIsmt(sessionUser.getUsrId());
					psnl0110Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
					
					psnl0110DAO.insertPsnl0110(psnl0110Vo);
					break;
				case UPDATE:

					psnl0110Vo.setIsmt(sessionUser.getUsrId());
					psnl0110Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
					
					
					// 삭제여부가 Y인 건 UPDATE 말고 DELETE 처리
					if("true".equals(psnl0110Dto.getDelChk())) {
						psnl0110DAO.deletePsnl0110(psnl0110Vo);
					}else {
						psnl0110DAO.updatePsnl0110(psnl0110Vo);
					}
					
					break;
					
				}
				
				if("A0420010".equals(psnl0110Vo.getEmymtTypCd()) ||	"A0420090".equals(psnl0110Vo.getEmymtTypCd()) ) {
                	
        			// 2017.09.22
        			// 신규고용일 경우 해당 테이블 데이터 update 처리
        			Psnl0101VO psnl0101Vo = new Psnl0101VO();
        			
        			psnl0101Vo.setDpobCd(MSFSharedUtils.allowNulls(psnl0110Vo.getDpobCd()));    							/** column 사업장코드 : dpobCd */
        			psnl0101Vo.setSystemkey(MSFSharedUtils.allowNulls(psnl0110Vo.getSystemkey()));							/** column SYSTEMKEY : systemkey */
//        			psnl0101Vo.setPsnlBseSeilNum(MSFSharedUtils.allowNulls(bmMapModel.get("psnlBseSeilNum")));    /** column 통계기준일련번호 : psnlBseSeilNum */
        			psnl0101Vo.setEmymtDivCd(MSFSharedUtils.allowNulls(psnl0110Vo.getEmymtDivCd()));   						/** column 고용구분코드 : emymtDivCd */
        			
        			psnl0101Vo.setFrstBseEmymtDt(psnl0110Vo.getEmymtBgnnDt());												/** column 최초고용일자 : frstBseEmymtDt */
        			psnl0101Vo.setIsmt(sessionUser.getUsrId());    															/** column 수정자 : ismt */
        			psnl0101Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());						/** column 수정주소 : revnAddr */
        			
        			
        			
        			// 공무직전환자의 경우 해당일자를 최초고용일자로 해준다.
        			if(	"A0420090".equals(psnl0110Vo.getEmymtTypCd())) {
        				psnl0101Vo.setEmymtTypCd("A0420090");
        			}
        			
        			
        			psnl0101DAO.deletePsnl0101(psnl0101Vo);
					psnl0101DAO.insertPsnl0101(psnl0101Vo);
				
				}
				
				iCnt = iCnt + 1;

			}
			result = iCnt;

		} catch (Exception ex) {
			logger.error("EXCEPTION calling savePsnl0100ToPsnl0110(): " + ex);

			result = new Long(0);
			throw MSFServerUtils.getOperationException("savePsnl0100ToPsnl0110", ex,
					logger);
		} finally {

		}
		return result;
	}
	
//	/** 부서 코드를 가져온다. 권한x **/
//	public PagingLoadResult<BaseModel> getLookupWithBass0400List(ServiceParameters serviceParameters) {
//		
//		
//		
//		PagingLoadResult retval = null;
//		String method = CLASS_PSNL0100_TO_BASS0400_DATA_LIST;
//		SysComSearchVO sysComSrhVo = new SysComSearchVO();
//		PrgmComBass0400VO sysComBass0400Vo = new PrgmComBass0400VO();
//		List bmResult = new ArrayList();
//		MSFServerExtAuth msfServerExtAuth = MSFServerExtAuth.getInstance();
//
//		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
//
//		if (MSFSharedUtils.paramNull(this.bass0400DAO)) {
//			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest().getSession().getServletContext());
//
//			this.bass0400DAO = ((PrgmComBass0400DAO) wac.getBean("PrgmComBass0400DAO"));
//		}
//
//		try{
//			
//			IColumnFilter columnFilters = serviceParameters.getColumnFilters();
//			List columnOrders = serviceParameters.getColumnOrders();
//			PagingLoadConfig pagingLoadConfig = serviceParameters.getPagingLoadConfig();
//
//			ColumnAttribute[] columnAttributes = { new ColumnAttribute("dpobCd", "dpobCd", 1), new ColumnAttribute("deptCd", "deptCd", 1), new ColumnAttribute("deptNmHan", "deptNmHan", 1), new ColumnAttribute("deptNmRtchnt", "deptNmRtchnt", 1) };
//
//			PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
//
//			sysComSrhVo.setDpobCd(sessionUser.getDpobCd());
//			sysComSrhVo.setDeptCd("");
//
//			sysComSrhVo.setEmymtDivCd("");
//			sysComSrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));
//
//			if (MSFSharedUtils.isEmpty(sysComSrhVo.getPayrMangDeptCd())) {
//				sysComSrhVo.setPayrMangDeptCd(sessionUser.getTplvlDeptCd());
//			}
//			sysComSrhVo.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeDeptCd")));
//
//			// sysComSrhVo.setDeptNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters,
//			// "deptNm")));
//			sysComSrhVo.setDeptDspyYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptDspyYn")));
//			
//			if ("combo".equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "chkCombo")))) {
//				
//				sysComSrhVo.setLastIndex(-1);
//				
//			}else {
//				
//				if (pagingValues.executeRecordCount) {
//					
//					TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
//
//					int iResultCnt = this.bass0400DAO.selectBass0400ListTotCnt(sysComSrhVo);
//
//					SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
//					pagingValues.totalRecordCount = iResultCnt;
//
//					logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
//				}
//
//	            sysComSrhVo.setPageSize(pagingValues.totalRecordCount);
//
//	            if (pagingValues.start > 0) {
//	              sysComSrhVo.setFirstIndex(pagingValues.start);
//	            }
//	            if (pagingValues.offsetLimit > 0) {
//	              sysComSrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
//	            }
//
//			}
//
//			TimingInfo millisBeginSelectBass0400List = SmrmfUtils.startTiming(logger);
//
//			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
//
//			List list = this.bass0400DAO.selectBass0400List(sysComSrhVo);
//
//			Iterator iter = list.iterator();
//
//			SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");
//	          
//
//			while (iter.hasNext()) {
//				Map map = (Map) iter.next();
//				String idValue = map.get("deptCd").toString();
//				BaseModel bm = new BaseModel();
//
//				for (int i = 0; i < columnAttributes.length; i++) {
//					
//					Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(map.get(columnAttributes[i].getName()),columnAttributes[i].getType());
//
//					bm.set(columnAttributes[i].getName(), baseModelValue);
//				}
//
//				bm.set("@ID@", idValue);
//				bmResult.add(bm);
//			}
//
//			retval = new BasePagingLoadResult(bmResult, pagingValues.start,pagingValues.totalRecordCount);
//
//			SmrmfUtils.endTiming(logger, millisBeginSelectBass0400List,"getPayrWithBass0400List");
//			
//		} catch (Exception ex) {
//			
//			throw MSFServerUtils.getOperationException(method, ex, logger);
//			
//		}
//
//	        return retval;
//	  }	
	
	
}
