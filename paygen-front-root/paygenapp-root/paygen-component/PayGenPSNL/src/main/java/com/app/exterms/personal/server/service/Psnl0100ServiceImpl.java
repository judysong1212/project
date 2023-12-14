package com.app.exterms.personal.server.service;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.payroll.client.dto.InfcPkgPayr0400DTO;
import com.app.exterms.personal.client.dto.Psnl0100DTO;
import com.app.exterms.personal.client.service.Psnl0100Service;
import com.app.exterms.personal.server.service.dao.Psnl0100DAO;
import com.app.exterms.personal.server.service.dao.Psnl0101DAO;
import com.app.exterms.personal.server.service.dao.Psnl0110DAO;
import com.app.exterms.personal.server.service.dao.Psnl0111DAO;
import com.app.exterms.personal.server.service.dao.Psnl0112DAO;
import com.app.exterms.personal.server.service.dao.Psnl0113DAO;
import com.app.exterms.personal.server.service.dao.Psnl0115DAO;
import com.app.exterms.personal.server.service.dao.Psnl0116DAO;
import com.app.exterms.personal.server.service.dao.Psnl0119DAO;
import com.app.exterms.personal.server.service.dao.Psnl0125DAO;
import com.app.exterms.personal.server.service.dao.Psnl0127DAO;
import com.app.exterms.personal.server.vo.Psnl0100SrhVO;
import com.app.exterms.personal.server.vo.Psnl0100VO;
import com.app.exterms.personal.server.vo.Psnl0101VO;
import com.app.exterms.personal.server.vo.Psnl0110SrhVO;
import com.app.exterms.personal.server.vo.Psnl0110VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFErrorMessage;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.basis.server.service.dao.InfcPkgBass0360DAO;
import com.app.smrmf.infc.basis.server.vo.InfcPkgBass0360SrhVO;
import com.app.smrmf.infc.basis.server.vo.InfcPkgBass0360VO;
import com.app.smrmf.infc.basis.server.vo.InfcPkgBass0400VO;
import com.app.smrmf.infc.payroll.server.service.dao.InfcPkgPayr0304DAO;
import com.app.smrmf.infc.payroll.server.service.dao.InfcPkgPayr0500DAO;
import com.app.smrmf.infc.payroll.server.service.dao.InfcPkgPayr0520DAO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0304SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0400VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0500VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0520VO;
import com.app.smrmf.pkg.listener.PayrListenerAdapter;
import com.app.smrmf.props.ExtermsProps;
import com.ext.constants.PropPayGenConfs;
import com.ext.constants.SysmConf;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.ibm.icu.text.SimpleDateFormat;

import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * @Class Name : Psnl0100ServiceImpl.java
 * @Description : Psnl0100 Business Implement class
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
@Service("psnl0100Service")
public class Psnl0100ServiceImpl    extends AbstractCustomServiceImpl  implements Psnl0100Service {
	
	 private static final Logger logger = LoggerFactory.getLogger(Psnl0100ServiceImpl.class);
	 private static final String calledClass = Psnl0100ServiceImpl.class.getName();
	    
	@Autowired
    @Resource(name="psnl0100DAO")
    private Psnl0100DAO psnl0100DAO;
	
	@Autowired
    @Resource(name="psnl0101DAO")
    private Psnl0101DAO psnl0101DAO;
	
	@Autowired
    @Resource(name="psnl0110DAO")
    private Psnl0110DAO psnl0110DAO;
	
	@Autowired
    @Resource(name="psnl0111DAO")
    private Psnl0111DAO psnl0111DAO;

	@Autowired
    @Resource(name="psnl0112DAO")
    private Psnl0112DAO psnl0112DAO;
	
	@Autowired
    @Resource(name="psnl0113DAO")
    private Psnl0113DAO psnl0113DAO;
	
	@Autowired
    @Resource(name="psnl0115DAO")
    private Psnl0115DAO psnl0115DAO;
	
	@Autowired
    @Resource(name="psnl0116DAO")
    private Psnl0116DAO psnl0116DAO;
	
	@Autowired
    @Resource(name="psnl0119DAO")
    private Psnl0119DAO psnl0119DAO;
	
	@Autowired
    @Resource(name="psnl0127DAO")
    private Psnl0127DAO psnl0127DAO;
	
	@Resource(name = "psnl0125DAO")
	private Psnl0125DAO psnl0125DAO;
	
    @Resource(name="InfcPkgBass0360DAO")
    private InfcPkgBass0360DAO infcBass0360DAO;
	
	@Resource(name = "InfcPkgPayr0500DAO")
	private InfcPkgPayr0500DAO infcPayr0500DAO;
	
	@Resource(name = "InfcPkgPayr0520DAO")
    private InfcPkgPayr0520DAO infcPayr0520DAO;

	@Resource(name = "InfcPkgPayr0304DAO")
	private InfcPkgPayr0304DAO infcPayr0304DAO;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public PagingLoadResult<Psnl0100DTO> selectPsnl0100Paging(
			PagingLoadConfig config, HashMap<String, String> param)
			throws MSFException {
		
		String windowNm = "인사";
		String windowId = "PSNL0100";
		
		// TODO Auto-generated method stub
		//logger.debug(param.toString());
		
		//전체 갯수 가져오기  데이터 많은건수 가져오는데 느릴경우 재개발 필요함
		//int totCnt = psnl0100DAO.selectPsnl0100PagingTotCnt(param);
//		List returnValue = new ArrayList();
		//String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		String method = calledClass + ".selectPsnl0100Paging";
		
		ArrayList<Psnl0100DTO> sublist = new ArrayList<Psnl0100DTO>();
		int totCnt = 0;
		MSFSysm0100BM sessionUser;
		 
		
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
		
		Psnl0100SrhVO psnl0100SrhVo = new Psnl0100SrhVO();
		
		try{
			//암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		psnl0100SrhVo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(param.get("srhResnRegnNum")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
		

			psnl0100SrhVo.setHanNm(MSFSharedUtils.allowNulls(param.get("srhName")));						//성명
//			psnl0100SrhVo.setResnRegnNum(MSFSharedUtils.allowNulls(param.get("srhResnRegnNum")));
			
			//System.out.println("encryptype psnl0100:" + psnl0100SrhVo.getResnRegnNum());
			
			if("PSNL0100".equals(param.get("className"))){					//고용구분
				param.put("emymtDivCd", "A0020010");
				psnl0100SrhVo.setEmymtDivCd("A0020010");
				
			}
			if("PSNL0200".equals(param.get("className"))){
				param.put("emymtDivCd", "A0020020");
				psnl0100SrhVo.setEmymtDivCd("A0020020");
			}
			
			/** 조건절 */
	   	 	List<String> listDeptCd = new ArrayList<String>(); 
	   	 	
	   	 	psnl0100SrhVo.setDpobCd(sessionUser.getDpobCd());	//사업장코드
	   	 	psnl0100SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	   	 	psnl0100SrhVo.setUsrId(sessionUser.getUsrId());		//유저아이디
	   	 	
	   // 	psnl0100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));		//단위기관코드
	  	
	   	 	
	   	 	//TODO 인사는 무조건 나와야 하므로 권한 일단 빼둠..
	   	 	/******************************** 권한 ************************************************************************/
	   	 	String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	   	 	
	   	 	if ("FALSE".equals(chkDeptCd)) {
	   	 	psnl0100SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(param.get("srhMangeDeptCd"))));	
	//   	 	psnl0100SrhVo.setDeptCd(sessionUser.getDeptCd()); 
	   	 		listDeptCd.add(sessionUser.getDeptCd());
	   	 		psnl0100SrhVo.setDeptCdArr(listDeptCd);     	//부서코드    
	   	 		psnl0100SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	   	 		
	   	 	} else {
	   	 		psnl0100SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(param.get("srhMangeDeptCd"))) ;   //단위기관코드   
	            if (psnl0100SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(param.get("srhMangeDeptCd")))) { 
	//            	listDeptCd = null; 
	//            	psnl0100SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	//            	psnl0100SrhVo.setDeptCd("");  				//부서코드
	            	psnl0100SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(param.get("srhMangeDeptCd"))));
	            	listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("srhMangeDeptCd")));  
	            	psnl0100SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	            } else {
	            	psnl0100SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(param.get("srhMangeDeptCd"))));
	            	listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("srhMangeDeptCd")));  
	            	psnl0100SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	            } 
	           
	   	 	}
	     
	   	 	psnl0100SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(param.get("srhCurrAffnDeptCd")).replace(",", ""));  //권한처리를위해 추가  
	   	 	psnl0100SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(param.get("srhDtilOccuInttnCd")).replace(",", ""));   
	   	 	/******************************** 권한 ************************************************************************/
	   	 	
	   	 	List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(param.get("srhHdofcCodtnCd"));  
	   	 	psnl0100SrhVo.setHdofcCodtnCdArr(listHdofcCodtnCd);     //재직코드 
			psnl0100SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(param.get("srhHdofcCodtnCd")));		//재직코드
	//		psnl0100SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(param.get("srhHdofcCodtnCd")));		//재직구분
			psnl0100SrhVo.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(param.get("repbtyBusinDivCd")));       //호봉제 구분
			
	//		psnl0100SrhVo.setDeptCd(MSFSharedUtils.allowNulls(param.get("srhMangeDeptCd")));			//관리부서
	//		psnl0100SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(param.get("srhMangeDeptCd"))));//관리부서
			psnl0100SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(param.get("srhCurrAffnDeptCd")));	//소속부서
			psnl0100SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(param.get("srhTypOccuCd")));			//직종
			
			List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("srhDtilOccuInttnCd"))); 
			psnl0100SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	      	psnl0100SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(param.get("srhDtilOccuInttnCd")))); //직종세
	      	psnl0100SrhVo.setBusinCd(MSFSharedUtils.allowNulls(param.get("srhBusinCd")));				//사업
	     	
	
	      	psnl0100SrhVo.setSrhFlag("N");	
	      	if(psnl0100SrhVo.getEmymtDivCd() != "" || !"".equals(psnl0100SrhVo.getEmymtDivCd())) {
	      		
	          	// 퇴사한 공무직이 기간제 근로자로 재입사 한 경우 공무직 화면에서 조회하기 위해 srhVo 추가
		      	// 재직 구분이 없거나, 퇴직 포함 시 조회되도록 처리.
	      		if( ( psnl0100SrhVo.getHdofcCodtnCd() == null || "".equals(psnl0100SrhVo.getHdofcCodtnCd()) ) ||  ( ( psnl0100SrhVo.getHdofcCodtnCd().contains("A0030020")) ||  psnl0100SrhVo.getHdofcCodtnCd() == "A0030020"  ) ) {
	      			psnl0100SrhVo.setSrhFlag("Y");	
		      	}
					
	      	}
	      
	//			totCnt = psnl0100DAO.selectPsnl0100PagingTotCnt(param);
				totCnt = psnl0100DAO.selectPsnl0100PagingTotCnt(psnl0100SrhVo);
				
				int start = config.getOffset();
				int limit = totCnt;
				
				if (config.getLimit() > 0) {
					limit = Math.min(start + config.getLimit(), limit);
				}
				
				String currentpage = limit%50 > 0 ? ((limit/50)+1)+"" : (limit/50)+""; 
				
				param.put("ROWCOUNT", "50"); //default 50개까지 보여줌
				param.put("CURRENTPAGE", currentpage); //몇번째 페이지인지...
				
				psnl0100SrhVo.setRowCount(param.get("ROWCOUNT"));
				psnl0100SrhVo.setCurrEntPage(param.get("CURRENTPAGE"));
				
				
				List returnValue = psnl0100DAO.selectPsnl0100Paging(psnl0100SrhVo);
				
				for (int i = 0; i < returnValue.size(); i++) {
					
					Psnl0100DTO dto = new Psnl0100DTO();
				    String rrnDecCrypt = "";
					Map tempMap = (Map)returnValue.get(i);
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
					// TODO 주민번호
//					System.out.print("aaaaaa : " +dto.getResnRegnNum() );
//					nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
					rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dto.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
					dto.setResnRegnNum(rrnDecCrypt);
					sublist.add(dto);
				
				}
				/*
				returnValue = psnl0100DAO.selectPsnl0100Paging(param);
				
				int start = config.getOffset();
				int limit = returnValue.size();
				if (config.getLimit() > 0) {
					limit = Math.min(start + config.getLimit(), limit);
				}
				for (int i = config.getOffset(); i < limit; i++) {
					
					Psnl0100DTO dto = new Psnl0100DTO();
					
					Map tempMap = (Map)returnValue.get(i);
					Iterator<String> keys = tempMap.keySet().iterator();
					while( keys.hasNext() ){
			            String key = keys.next();
			            dto.set(key, tempMap.get(key));
			        }
					
					sublist.add(dto);
					
				}
				*/
		}catch(Exception e){
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
		
		return new BasePagingLoadResult<Psnl0100DTO>(sublist, config.getOffset(),totCnt);
	}

	

	@Override
	public int deletePsnl0100(HashMap<String, String> hMap) throws Exception {
		
		String windowNm = "인사";
		String windowId = "PSNL0100";
		
		boolean delFlage = true;
		int rtnInt = 0;
		
		// TODO Auto-generated method stub
		
//		map.put("dpobCd", dpobCd);					//사업장코드
//		map.put("systemkey", systemkey);			//시스템키
//		map.put("deptCd", mangeCd);  				//관리부서코드
//		map.put("currAffnDeptCd", currAffnDeptCd);	//소속부서코드
//		map.put("resnRegnNum", resnRegnNum); 		//주민등록번호
//		map.put("hanNm", hanNm);					//한글이름
//		map.put("chinCharNm", chinCharNm); 			//한자이름
//		map.put("engNm", engNm); 					//영문이름
//		map.put("emymtDivCd", emymtDivCd);			//"A0020020" 고용구분코드
		
		String method = calledClass + ".deletePsnl0100";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		
		try{
		
			//TODO 사대보험도 진행사항 없으면 삭제 로직..
			Psnl0110SrhVO psnl0110SrhVo = new Psnl0110SrhVO();
		        
			//삭제전 사회보험 데이터 확인 작업
			psnl0110SrhVo.setDpobCd(hMap.get("dpobCd"));
			psnl0110SrhVo.setSystemkey(hMap.get("systemkey"));
			
				
			List lstPsnl0110Insr2100 =  psnl0110DAO.selectPsnl0110Insr1200List(psnl0110SrhVo);
				
			if (lstPsnl0110Insr2100.size() > 0) {
				
				rtnInt = 3;
				
				delFlage = false;
				
				MSFErrorMessage errMsg = new MSFErrorMessage("", "", 2, "사회 보험 가입 이력 데이텨가 존재하는 대상자는 삭제할 수 없습니다."); 
		        throw MSFServerUtils.getValidationException("deletePsnl0100", errMsg, logger) ; 
			}
			
			 
			InfcPkgPayr0500VO payr0500vo = new InfcPkgPayr0500VO();
	        InfcPkgPayr0520VO tpPayr0520vo = new InfcPkgPayr0520VO();
	        InfcPkgPayr0304SrhVO infcPayr0304SrhVo = new InfcPkgPayr0304SrhVO();
	        
			//삭제전 급여 데이터 확인 작업
	        infcPayr0304SrhVo.setDpobCd(hMap.get("dpobCd"));
	        infcPayr0304SrhVo.setSystemkey(hMap.get("systemkey"));
	        infcPayr0304SrhVo.setResnRegnNum( AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(hMap.get("resnRegnNum")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));
	     
	        
			List lstInfcPayr0304 =   infcPayr0304DAO.selectPsnl0100ToPayr0304List(infcPayr0304SrhVo);
			
			if (lstInfcPayr0304.size() > 0) {
				
				rtnInt = 3;
				delFlage = false;
						
				 MSFErrorMessage errMsg = new MSFErrorMessage("", "", 2, "급여 데이타가 존재하는 대상자는 삭제할 수 없습니다."); 
	             throw MSFServerUtils.getValidationException("deletePsnl0100", errMsg, logger) ; 
			}
			
			
			//삭제전 고용 데이터 확인 작업
			psnl0110SrhVo = new Psnl0110SrhVO();
			
			psnl0110SrhVo.setDpobCd(hMap.get("dpobCd"));
			psnl0110SrhVo.setSystemkey(hMap.get("systemkey"));
			
			
			List lstPsnl0110 =   psnl0110DAO.selectPsnl0100ToPsnl0110List(psnl0110SrhVo);
			
			if (lstPsnl0110.size() > 0) {
				
				rtnInt = 3;
				
				delFlage = false;
				
				 MSFErrorMessage errMsg = new MSFErrorMessage("", "", 2, "고용 데이타가 존재하는 대상자는 삭제할 수 없습니다."); 
	             throw MSFServerUtils.getValidationException("deletePsnl0100", errMsg, logger) ; 
			}
			
			
			
			if(delFlage) {
				
				rtnInt = 1;
				
				
				//삭제시 PSNL0125 사진 정보도 삭제
				psnl0125DAO.deletePsnl0125(hMap); 
				
				//삭제시 PSNL0119 경력 정보도 삭제
				psnl0119DAO.deletePsnl0119(hMap);
		        
				//삭제시 PSNL0116 학력 정보도 삭제
				psnl0116DAO.deletePsnl0116(hMap);
				
				//삭제시 PSNL0115 가족 정보도 삭제
				psnl0115DAO.deletePsnl0115(hMap);
				
				//삭제시 PSNL0113 신상 정보도 삭제
				psnl0113DAO.deletePsnl0113(hMap);
				
				//삭제시 PSNL0112 병역 정보도 삭제
				psnl0112DAO.deletePsnl0112(hMap);
				
				//삭제시 PSNL0111 인적 정보도 삭제
				psnl0111DAO.deletePsnl0111(hMap);
				
				
    			Psnl0101VO psnl0101Vo = new Psnl0101VO();
    			
    			psnl0101Vo.setDpobCd(MSFSharedUtils.allowNulls(hMap.get("dpobCd")));    			/** column 사업장코드 : dpobCd */
    			psnl0101Vo.setSystemkey(MSFSharedUtils.allowNulls(hMap.get("systemkey")));			/** column SYSTEMKEY : systemkey */
				
				//삭제시 PSNL0101 인적 정보도 삭제
				psnl0101DAO.deletePsnl0101(psnl0101Vo);
				
				
		        payr0500vo.setDpobCd(hMap.get("dpobCd"));
		        payr0500vo.setSystemkey(hMap.get("systemkey"));
		        
				BeanUtils.copyProperties(tpPayr0520vo, payr0500vo);
		        
		        tpPayr0520vo.setPayItemCd("");
		        tpPayr0520vo.setPymtDducItemSilNum(BigDecimal.ZERO);
		         
		        tpPayr0520vo = infcPayr0520DAO.selectPayr0520(tpPayr0520vo);
		        
		        //급여자료 없으면 삭제
		        if (MSFSharedUtils.paramNull(tpPayr0520vo)) {
		        	infcPayr0500DAO.deletePayr0500(payr0500vo);
		        }  
		        
		        psnl0100DAO.deletePsnl0100(hMap);
				
			}
			
//			//삭제시 PSNL0125 사진 정보도 삭제
//			psnl0125DAO.deletePsnl0125(hMap); 
//			
//			//삭제시 PSNL0119 경력 정보도 삭제
//			psnl0119DAO.deletePsnl0119(hMap);
//	        
//			//삭제시 PSNL0116 학력 정보도 삭제
//			psnl0116DAO.deletePsnl0116(hMap);
//			
//			//삭제시 PSNL0115 가족 정보도 삭제
//			psnl0115DAO.deletePsnl0115(hMap);
//			
//			//삭제시 PSNL0113 신상 정보도 삭제
//			psnl0113DAO.deletePsnl0113(hMap);
//			
//			//삭제시 PSNL0112 병역 정보도 삭제
//			psnl0112DAO.deletePsnl0112(hMap);
//			
//			//삭제시 PSNL0111 인적 정보도 삭제
//			psnl0111DAO.deletePsnl0111(hMap);
//				
//	        payr0500vo.setDpobCd(hMap.get("dpobCd"));
//	        payr0500vo.setSystemkey(hMap.get("systemkey"));
//	        
//			BeanUtils.copyProperties(tpPayr0520vo, payr0500vo);
//	        
//	        tpPayr0520vo.setPayItemCd("");
//	        tpPayr0520vo.setPymtDducItemSilNum(BigDecimal.ZERO);
//	         
//	        tpPayr0520vo = infcPayr0520DAO.selectPayr0520(tpPayr0520vo);
//	        
//	        //급여자료 없으면 삭제
//	        if (MSFSharedUtils.paramNull(tpPayr0520vo)) {
//	        	infcPayr0500DAO.deletePayr0500(payr0500vo);
//	        }  
        
		}catch(Exception e) {
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"D:S",e, windowNm , windowId);
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "D:S");
        
//		return psnl0100DAO.deletePsnl0100(hMap);
		return rtnInt ;
	}

	
	//근로자 신규등록
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String insertPsnl0100(Psnl0100DTO psnl0100Dto) throws MSFException {
		
		String windowNm = "인사";
		String windowId = "PSNL0100";
		
		// TODO Auto-generated method stub
		
		String method = calledClass + ".insertPsnl0100"; 
		String systemkey = "";
		MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		HashMap<String, String> tempMap = new HashMap<String, String>();
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		try{
		
			
			
			//이미지 저장정보를 가지고 온다.
			HashMap<String, String> globals = MSFServerUtils.getLocalidedMessages(RemoteServiceUtil.getThreadLocalConfig(), RemoteServiceUtil.getThreadLocalRequest()); 
					 
			//필수 키값 세팅
			psnl0100Dto.setKybdr(sessionUser.getUsrId());
			psnl0100Dto.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			
			psnl0100Dto.setIsmt(sessionUser.getUsrId());
			psnl0100Dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			
			//신규일 경우 호봉은 무조건 '0호봉' 코드값을 넣어줌.
			//쿼리에서 기간제일 경우는 호봉 ''로 넣고 공무직 일 경우만 호봉코드 넣어줌.
			psnl0100Dto.setPyspCd("A0050000");
			
			
			// 인사 초기 등록 시 근속년월 0년 0개월 넣어줌.
			psnl0100Dto.setLogSvcYrNumCd("A0070000");	// 근속년수코드
			psnl0100Dto.setLogSvcMnthIcmCd("A0060034");	// 근속월수코드
			
			
			// 2. 파라미터 보낼 때(암호화)
			psnl0100Dto.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(psnl0100Dto.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
			
			
			String dpobCd = sessionUser.getUsrDivCd() == null ? sessionUser.getDpobCd() : sessionUser.getDpobCd();
	//		String dpobCd = sessionUser.getUsrDivCd() == null ? " " : sessionUser.getDpobCd();
//			String systemkey = psnl0100DAO.getNewSystemkey(dpobCd);
			systemkey = psnl0100DAO.getNewSystemkey(dpobCd);
			psnl0100Dto.setDpobCd(dpobCd);
			psnl0100Dto.setSystemkey(systemkey);
			if(psnl0100Dto.getPicFlnm() != null){
				//사진 등록 처리 시작 ======================================================
				//String UPLOAD_DIRECTORY = "C:\\eGovFrameDev-2.7.0\\workspace\\PayGenApp\\war\\ExTermsFile\\ExTermPhoto";
				//서버용 
				String UPLOAD_DIRECTORY =  globals.get("PayGen.ExTermPhoto") ;   // PayGen.EXTERM_PHOTO; 
	
	            String extName = psnl0100Dto.getPicFlnm().substring(psnl0100Dto.getPicFlnm().lastIndexOf("."), psnl0100Dto.getPicFlnm().length());
				
				HashMap map = new HashMap();
				map.put("dpobCd", dpobCd);
				map.put("systemkey", systemkey);
				map.put("picRfta", UPLOAD_DIRECTORY);
				map.put("picFlnm",  psnl0100Dto.getSystemkey()+extName);
				map.put("kybdr", sessionUser.getUsrId());
				map.put("inptAddr", psnl0100Dto.getInptAddr());
				map.put("ismt", sessionUser.getUsrId());
				map.put("revnAddr", psnl0100Dto.getRevnAddr());
				
				psnl0125DAO.insertPsnl0125(map);
				//사진 등록 처리 끝 ======================================================
			}
			
			
			psnl0100DAO.insertPsnl0100(psnl0100Dto);
			
			
			//jungmin 2014.09.25
			//급여인사 마스터 등록 추가 시작
			InfcPkgPayr0500VO payr0500vo = new InfcPkgPayr0500VO();
			InfcPkgPayr0520VO tpPayr0520vo = new InfcPkgPayr0520VO();
			
			payr0500vo.setDpobCd(dpobCd);
			payr0500vo.setSystemkey(systemkey);
//			HashMap<String, String> tempMap = new HashMap<String, String>();
			tempMap = new HashMap<String, String>();
			tempMap.put("dpobCd", dpobCd );
			tempMap.put("deptCd", psnl0100Dto.getCurrAffnDeptCd());
			payr0500vo.setPayrMangDeptCd(psnl0100DAO.getPayDeptCd(tempMap));
			payr0500vo.setEmymtDivCd(psnl0100Dto.getEmymtDivCd());
//			payr0500vo.setRetryClutYn("Y"); 
			payr0500vo.setPayRcptYn("Y"); 
			/** 2015.07.13 소득세 관련추가  */
			payr0500vo.setAddIncmTxApptnRtoCd(ExtermsProps.getProps("PAYR_TAX_B0290020"));    /** column 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
			payr0500vo.setAddIncmTxApptnYrMnth("");/** column 추가소득세적용년월 : addIncmTxApptnYrMnth */
			payr0500vo.setAddIncmTxApptnYn("N");   /** column 추가소득세적용여부 : addIncmTxApptnYn  N : 최초입력  Y: 변경적용 E : 급여적용 이후 수정불가 .과세기간동*/
	           
			payr0500vo.setKybdr(psnl0100Dto.getKybdr());
			payr0500vo.setIsmt(psnl0100Dto.getIsmt());
			payr0500vo.setInptAddr(psnl0100Dto.getInptAddr());
			payr0500vo.setRevnAddr(psnl0100Dto.getRevnAddr());
			
			BeanUtils.copyProperties(tpPayr0520vo, payr0500vo);
			
			tpPayr0520vo.setPayItemCd("");
			tpPayr0520vo.setPymtDducItemSilNum(BigDecimal.ZERO);
			 
			tpPayr0520vo = infcPayr0520DAO.selectPayr0520(tpPayr0520vo);
			
			if (MSFSharedUtils.paramNull(tpPayr0520vo)) {
				infcPayr0500DAO.deletePayr0500(payr0500vo);
			}  
			
			infcPayr0500DAO.insertPayr0500(payr0500vo);
		
		}catch(Exception e) {
			e.printStackTrace();
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"C:S",e, windowNm , windowId);
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "C:S");
		
		tempMap = new HashMap<String, String>();
		//급여인사 마스트 등록 추가 끝
		return systemkey;
	} 

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public int updatePsnl0100(Psnl0100DTO psnl0100Dto) throws Exception {
		
		String windowNm = "인사";
		String windowId = "PSNL0100";
		// TODO Auto-generated method stub
		
		String method = calledClass + ".updatePsnl0100";
		MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		
		// 파라미터 보낼 때(암호화)
		psnl0100Dto.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(psnl0100Dto.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
		
		//이미지 저장정보를 가지고 온다.
		HashMap<String, String> globals = MSFServerUtils.getLocalidedMessages(RemoteServiceUtil.getThreadLocalConfig(), RemoteServiceUtil.getThreadLocalRequest()); 
		 
		
		try{
			
			psnl0100Dto.setIsmt(sessionUser.getUsrId());
			psnl0100Dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			
			if(psnl0100Dto.getPicFlnm() != null){
				//사진 등록 처리 시작 ======================================================
				//String UPLOAD_DIRECTORY = "C:\\eGovFrameDev-2.7.0\\workspace\\PayGenApp\\war\\ExTermsFile\\ExTermPhoto";
				//서버용
				String UPLOAD_DIRECTORY =  globals.get("PayGen.ExTermPhoto") ; //PayGen.EXTERM_PHOTO;//egovMessageSource.getMessage("PayGen.ExTermPhoto");   
				
				
				String extName = psnl0100Dto.getPicFlnm().substring(psnl0100Dto.getPicFlnm().lastIndexOf("."), psnl0100Dto.getPicFlnm().length());
				
				
				HashMap map = new HashMap();
				map.put("dpobCd", psnl0100Dto.getDpobCd());
				map.put("systemkey", psnl0100Dto.getSystemkey());
				map.put("picRfta", UPLOAD_DIRECTORY);
				map.put("picFlnm", psnl0100Dto.getSystemkey()+extName);
				map.put("ismt", sessionUser.getUsrId());
				map.put("revnAddr", psnl0100Dto.getRevnAddr());
				
				psnl0125DAO.updatePsnl0125(map);
				//사진 등록 처리 끝 ======================================================
			}
		
		}catch(Exception e) {
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U",e, windowNm , windowId);
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "U");
		
		//System.out.println("updatePsnl0100 Starting.....................1111.....");
		
		int rtnVal = 0;
		

		String strEmymtDivCd = MSFSharedUtils.defaultNulls(psnl0100Dto.getEmymtDivCd(),""); /* 고용구분*/
		String strHdofcCodtnCd = MSFSharedUtils.defaultNulls(psnl0100Dto.getHdofcCodtnCd(),""); /* 재직구분*/
		HashMap chkMap = new HashMap();
		
		chkMap.put("dpobCd", psnl0100Dto.getDpobCd());
		chkMap.put("systemkey", psnl0100Dto.getSystemkey());
		chkMap.put("ismt", sessionUser.getUsrId());
		chkMap.put("revnAddr", psnl0100Dto.getRevnAddr());
		chkMap.put("emymtDivCd", strEmymtDivCd);
		chkMap.put("hdofcCodtnCd", strHdofcCodtnCd);
			
		System.out.println("strEmymtDivCd==="+strEmymtDivCd+",   strHdofcCodtnCd====="+strHdofcCodtnCd);
		
		
		if(!"".equals(strEmymtDivCd)&&!"".equals(strHdofcCodtnCd)){
			if( strHdofcCodtnCd.equals("A0030020")  ){   /* 퇴직  */
				
				if( strEmymtDivCd.equals("A0020010") ){  /* 공무직  */

					rtnVal = psnl0110DAO.selectPsnl0110Chk2017Enter01(chkMap);
					
				}else if( strEmymtDivCd.equals("A0020020") ){ /* 기간직  */

					rtnVal = psnl0110DAO.selectPsnl0110Chk2017Enter02(chkMap);
				}
			}
			
			
		}
	  
		System.out.println("rtnVal===1111"+rtnVal);
		
		
	   try{			
			
		   if(rtnVal==0){
			   psnl0100DAO.updatePsnl0100ToPayr0500(psnl0100Dto);
			   rtnVal= psnl0100DAO.updatePsnl0100(psnl0100Dto);
		   
		   }else{
			   
			   rtnVal= -1;
		   }
			
		   System.out.println("rtnVal===2222"+rtnVal);
		   
		}catch(Exception ex){
			
			ex.printStackTrace();
		}
		
		
		
		
		return rtnVal;
	}
	
	
	/** 근로자 고용구분 전환 작업 **/
	@SuppressWarnings("unused")
	@Override
	public int updatePsnl0100Status(Psnl0100DTO psnl0100Dto) throws Exception {
		// TODO Auto-generated method stub
		
		String method = calledClass + ".updatePsnl0100Status";
		
		String windowNm = "인사";
		String windowId = "PSNL0100";
		
		MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		psnl0100Dto.setIsmt(sessionUser.getUsrId());
		psnl0100Dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		
		
		Psnl0100VO psnl0100Vo = new Psnl0100VO();
		
		psnl0100Vo.setDpobCd(psnl0100Dto.getDpobCd());
		psnl0100Vo.setSystemkey(psnl0100Dto.getSystemkey());
		psnl0100Vo.setHdofcCodtnCd("A0030010");
		
		if("A0020010".equals(psnl0100Dto.getEmymtDivCd())) {	
			//무기계약근로자 - > 기간제근로자 변환
			psnl0100Vo.setEmymtDivCd("A0020020");
		}else if ("A0020020".equals(psnl0100Dto.getEmymtDivCd())) {
			//기간제근로자 - > 무기계약근로자 변환
			psnl0100Vo.setEmymtDivCd("A0020010");
		}else {
			MSFErrorMessage errMsg = new MSFErrorMessage("", "", 2, "고용구분 정보가 없습니다. 데이터를 확인해주세요."); 
		}
		
		
		
		int result = 0;
		
		try{
			/** ++++++++++++++++++ 고용구분 전환시 데이터 초기화 ++++++++++++++++++ **/	
			psnl0100DAO.updatePsnl0100Status(psnl0100Vo);
			
			psnl0100Vo.setBusinCd("");
			psnl0100DAO.resetPsnl0100BUSIN_CD(psnl0100Vo);					//사업 
			
			psnl0100Vo.setLogSvcYrNumCd("A0070000");	//0년
			psnl0100Vo.setLogSvcMnthIcmCd("A0060034");	//0월
			psnl0100DAO.resetPsnl0100LOG_SVC_CD(psnl0100Vo);				//근속년, 월 
			
			psnl0100Vo.setTypOccuCd("");
			psnl0100DAO.resetPsnl0100TYP_OCCU_CD(psnl0100Vo);				//직종
			
			psnl0100Vo.setDtilOccuInttnCd("");
			psnl0100DAO.resetPsnl0100DTIL_OCCU_INTTN_CD(psnl0100Vo);		//직종세
			
			psnl0100Vo.setCurrDeptAppmtDt("");
			psnl0100DAO.resetPsnl0100CURR_DEPT_APPMT_DT(psnl0100Vo);		//현부서발령일
			
			psnl0100Vo.setCurrAffnDeptCd("");
			psnl0100DAO.resetPsnl0100CURR_AFFN_DEPT_CD(psnl0100Vo);			//현소속부서
			
			psnl0100Vo.setRetryReasCtnt("");
			psnl0100DAO.resetPsnl0100RETRY_REAS_CTNT(psnl0100Vo);			//고용해제사유
			
			psnl0100Vo.setFrstEmymtDt("");
			psnl0100DAO.resetPsnl0100FRST_EMYMT_DT(psnl0100Vo);				//최초고용일
			
			psnl0100Vo.setRetryDt("");
			psnl0100DAO.resetPsnl0100RESET_RETRY_DT(psnl0100Vo);					//퇴직일자
			/** ++++++++++++++++++ 고용구분 전환시 데이터 초기화 ++++++++++++++++++ **/
			
			result = 1;
			
		}catch (Exception e) {
			
			result = 0;
			
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
		

		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "U");
		
//		return psnl0100DAO.updatePsnl0100Status(psnl0100Vo);
		
		return result;
	}



	@Override
	public List<HashMap<String, String>> getExcelData(String fileFullPath)
			throws Exception {
		// TODO Auto-generated method stub
		//ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		//InputStream input = classLoader.getResourceAsStream(fileFullPath);
		
		String method = calledClass + ".getExcelData";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		List<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
		
		String windowNm = "인사";
		String windowId = "PSNL0100";
		
		
		if(fileFullPath != null && !"".equals(fileFullPath)){
			File file = new File(fileFullPath);
			FileInputStream fis = null;
//			XSSFWorkbook w = null;
			
			try{
				
				org.apache.poi.ss.usermodel.Workbook w = WorkbookFactory.create(file);
				fis = new FileInputStream(file);
//				w = new XSSFWorkbook(fis);
				// 첫번째 엑셀 시트를 가져옴.
				org.apache.poi.ss.usermodel.Sheet sheet = w.getSheetAt(0);
//				XSSFSheet sheet = w.getSheetAt(0);
				
				Iterator<Row> rowIterator = sheet.iterator();
				int rowCnt = 0;
				
				while(rowIterator.hasNext()){
					Row row = rowIterator.next();
					Iterator<Cell> cellIterator = row.cellIterator();
					rowCnt++;
					HashMap<String, String> map = new HashMap<String, String>();
					while(cellIterator.hasNext()){
						
						Cell cell = cellIterator.next();
						map.put("rnum", rowCnt+"");
						
						switch(cell.getColumnIndex()){
						case 0: //주민번호
							map.put("rrn", String.valueOf(cell.getStringCellValue()));
							break;
						case 1: //교육시작일자
							map.put("bgnnDt", new SimpleDateFormat("yyyy-MM-dd").format(cell.getDateCellValue()));
							break;
						case 2: //교육종료일자
							map.put("endDt", new SimpleDateFormat("yyyy-MM-dd").format(cell.getDateCellValue()));
							break;
						case 3: //교옥이수시간
							map.put("cmpteTm", String.valueOf(cell.getNumericCellValue()));
							break;
						case 4: //교육종류명
							map.put("kndNm", cell.getStringCellValue());
							break;
						case 5: //교육기관명
							map.put("istutNm", cell.getStringCellValue());
							break;
						case 6: //비고내용
							map.put("noteCtnt", cell.getStringCellValue());
							break;
						}
						/*
						switch(cell.getCellType()){
						case Cell.CELL_TYPE_NUMERIC :
							map.put("A", String.valueOf(cell.getNumericCellValue()));
							break;
						case Cell.CELL_TYPE_STRING :
							map.put("B", cell.getStringCellValue());
							break;
						}
						*/
					}
					list.add(map);
					
				}
				fis.close();
				
			}catch (Exception e) {
				e.printStackTrace();
				
				/** 에러 로그 **/			
				MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"R",e, windowNm , windowId);
				
				return new ArrayList<HashMap<String, String>>();
			}
			
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "R");
		
		return list;
	}



	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public BaseListLoadResult<Psnl0100DTO> selectPsnl0100(
			BaseListLoadConfig config, HashMap<String, String> param)
			throws Exception {
		// TODO Auto-generated method stub
		
		String windowNm = "인사";
		String windowId = "PSNL0100";
		
		String method = calledClass + ".selectPsnl0100";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		List<Psnl0100DTO> returnValue = new ArrayList<Psnl0100DTO>();
		List egovResultDataList = new ArrayList();
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		// 2. 파라미터 보낼 때(암호화)
		
		param.put("resnRegnNum", AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(param.get("resnRegnNum")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));
		
		try{
			egovResultDataList = psnl0100DAO.selectPsnl0100(param);
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					
					// 2.복호화 리턴받을 값 선언
					String rrnDecCrypt = "";
					
					Psnl0100DTO dto = new Psnl0100DTO();
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
					
					// 3.복호화
					rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dto.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
					dto.setResnRegnNum(rrnDecCrypt);
					returnValue.add(dto);
				}
			}
			
			
		}catch(Exception e){
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
		
		return new BaseListLoadResult<Psnl0100DTO>(returnValue);
	}
  

	//학력
	@Override
	public String updateProcPsnl0100(Psnl0100DTO psnl0100Dto) throws Exception {
		
		
		String method = calledClass + ".updateProcPsnl0100";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		String windowNm = "인사";
		String windowId = "PSNL0100";
		
		String returnVal = "";
		
		try{
			
	//		returnVal += "_"+ psnl0100DAO.updatePsnl0100BUSIN_CD(psnl0100Dto);
	//		returnVal += "_"+ psnl0100DAO.updatePsnl0100CURR_AFFN_DEPT_CD(psnl0100Dto);
	//		returnVal += "_"+ psnl0100DAO.updatePsnl0100CURR_DEPT_APPMT_DT(psnl0100Dto);
	//		returnVal += "_"+ psnl0100DAO.updatePsnl0100DTIL_OCCU_CLS_DIV_CD(psnl0100Dto);
	//		returnVal += "_"+ psnl0100DAO.updatePsnl0100EMYMT_BGNN_DT(psnl0100Dto);
	//		returnVal += "_"+ psnl0100DAO.updatePsnl0100EMYMT_DIV_CD(psnl0100Dto);
	//		returnVal += "_"+ psnl0100DAO.updatePsnl0100EMYMT_END_DT(psnl0100Dto);
			returnVal += "_"+ psnl0100DAO.updatePsnl0100END_DEGR_DIV_CD(psnl0100Dto);
			returnVal += "_"+ psnl0100DAO.updatePsnl0100END_SCHL(psnl0100Dto);
	//		returnVal += "_"+ psnl0100DAO.updatePsnl0100FRST_EMYMT_DT(psnl0100Dto);
	//		returnVal += "_"+ psnl0100DAO.updatePsnl0100HDOFC_CODTN_CD(psnl0100Dto);
	//		returnVal += "_"+ psnl0100DAO.updatePsnl0100ODTY_CD(psnl0100Dto);
	//		returnVal += "_"+ psnl0100DAO.updatePsnl0100RETRY_DT(psnl0100Dto);
	//		returnVal += "_"+ psnl0100DAO.updatePsnl0100TYP_OCCU_CD(psnl0100Dto);
		
		}catch(Exception e) {
			e.printStackTrace();

			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U",e, windowNm , windowId);

		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "U");
		
		return returnVal;
	}



	//고용
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Psnl0100DTO updateProcPsnl0100Return(Psnl0100DTO psnl0100Dto)
			throws Exception {
		
		String method = calledClass + ".updateProcPsnl0100Return";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		String windowNm = "인사";
		String windowId = "PSNL0100";
		
		HashMap<String, String> extGlobals = SysmConf.getPayGenConfigInfo(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest()); 
		
		String returnVal = "";
		Psnl0100DTO returnDTO = new Psnl0100DTO();
		List egovResultDataList = new ArrayList();
		
		try{
			
				if("true".equals(psnl0100Dto.getAutoLoadFlag())){
					
				String yearStr = new SimpleDateFormat("yyyy").format(new Date());
				
				/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
				/** 1차 : 고용 구분에 따라 **/
				//기간제일 때
				if("A0020020".equals(psnl0100Dto.getEmymtDivCd())) {
					
					// 연장계약 (재고용) 이며, 고용시작일자가 현재 년도보다 클 경우 사업은 update 쳐주지 않는다.
					if(( "A0420030".equals(psnl0100Dto.getEmymtTypCd()) || "A0420020".equals(psnl0100Dto.getEmymtTypCd()))
						&& Integer.parseInt( psnl0100Dto.getEmymtBgnnDt().substring(0, 4)) > Integer.parseInt(yearStr)
						) {
						
					}else {
						
						returnVal += "_"+ psnl0100DAO.updatePsnl0100BUSIN_CD(psnl0100Dto);					//사업
						
					}
					
					returnVal += "_"+ psnl0100DAO.updatePsnl0100RETRY_DT(psnl0100Dto);						//퇴직일자
					
				}else if("A0020010".equals(psnl0100Dto.getEmymtDivCd())) {
					
					//공무직일 때
					returnVal += "_"+ psnl0100DAO.updatePsnl0100TYP_OCCU_CD(psnl0100Dto);					//직종
					returnVal += "_"+ psnl0100DAO.updatePsnl0100DTIL_OCCU_INTTN_CD(psnl0100Dto);			//직종세
					
				}
				/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
				
				
				/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
				/** 2차 : 고용 유형에 따라 **/
				//신규 or 재고용
				if("A0420010".equals(psnl0100Dto.getEmymtTypCd()) || "A0420020".equals(psnl0100Dto.getEmymtTypCd())) {
					
					returnVal += "_"+ psnl0100DAO.updatePsnl0100CURR_AFFN_DEPT_CD(psnl0100Dto);	//소속 부서 
					
					// 진안군의 경우 기간제 -> 공무직 전환 시 현부서발령일은 공무직 신규입사일로 처리.
					if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
						
						psnl0100Dto.setEmymtDtTyp(psnl0100Dto.getEmymtDivCd());
						
					}else {
						
						psnl0100Dto.setEmymtDtTyp("");
						
					}
					returnVal += "_"+ psnl0100DAO.updatePsnl0100CURR_DEPT_APPMT_DT(psnl0100Dto);		//현부서 발령일
					
					
					// 진안군의 경우 기간제 -> 공무직 전환 시 최초입사일자는 공무직 신규입사일로 처리.
					if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
						
						psnl0100Dto.setEmymtDtTyp(psnl0100Dto.getEmymtDivCd());
						
					}else {
						
						psnl0100Dto.setEmymtDtTyp("");
						
					}
					//고용구분코드 신규일 때
					returnVal += "_"+ psnl0100DAO.updatePsnl0100FRST_EMYMT_DT(psnl0100Dto);				//최초고용일자
					
					
					
					
				//직제개편	
				}else if("A0420050".equals(psnl0100Dto.getEmymtTypCd())) {
					//고용구분코드 신규 or 직제개편
	//				returnVal += "_"+ psnl0100DAO.updatePsnl0100CURR_AFFN_DEPT_CD(psnl0100Dto);	//현부서
					returnVal += "_"+ psnl0100DAO.updatePsnl0100CURR_DEPT_APPMT_DT(psnl0100Dto);			//현부서 발령일
				
				//퇴직
				}else if("A0420990".equals(psnl0100Dto.getEmymtTypCd())) {
					//고용유형이 퇴직일때만
					returnVal += "_"+ psnl0100DAO.updatePsnl0100RETRY_DT(psnl0100Dto);						//퇴직일자
					
				//전보
				}else if("A0420060".equals(psnl0100Dto.getEmymtTypCd())) {
					returnVal += "_"+ psnl0100DAO.updatePsnl0100CURR_AFFN_DEPT_CD(psnl0100Dto);				//소속 부서 
					returnVal += "_"+ psnl0100DAO.updatePsnl0100CURR_DEPT_APPMT_DT(psnl0100Dto);			//현부서 발령일
				// 연장계약
				}else if("A0420030".equals(psnl0100Dto.getEmymtTypCd())) {
					// 퇴직 후 연장계약 하는 경우도 있으므로 기존의 퇴직일자를 없애주기 위해 연장계약일 때도 퇴직일자 로직 타게끔 추가
					returnVal += "_"+ psnl0100DAO.updatePsnl0100RETRY_DT(psnl0100Dto);						//퇴직일자
				
				// 공무직전환	
				}else if("A0420090".equals(psnl0100Dto.getEmymtTypCd())) {
					
					returnVal += "_"+ psnl0100DAO.updatePsnl0100CURR_AFFN_DEPT_CD(psnl0100Dto);				//소속 부서 
					
				}
				/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
				
				/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
				/** 3차 : 공통 사항 **/
	//			returnVal += "_"+ psnl0100DAO.updatePsnl0100EMYMT_DIV_CD(psnl0100Dto);	//고용구분
				
				// 1. 고용구분 : 기간제 근로자, 2. 고용유형 : 재고용, 연장계약 , 3. 사업년도가 올해년도 보다 클 경우
				if("A0020020".equals(psnl0100Dto.getEmymtDivCd()) 
						&& ( "A0420030".equals(psnl0100Dto.getEmymtTypCd()) || "A0420020".equals(psnl0100Dto.getEmymtTypCd()))
						&& Integer.parseInt( psnl0100Dto.getEmymtBgnnDt().substring(0, 4)) > Integer.parseInt(yearStr)
						) {
					
							returnVal += "_"+ psnl0100DAO.updatePsnl0100EMYMT_END_DT(psnl0100Dto);			//고용종료일
							
				}else {
					
					returnVal += "_"+ psnl0100DAO.updatePsnl0100EMYMT_BGNN_DT(psnl0100Dto);					//고용시작일
					returnVal += "_"+ psnl0100DAO.updatePsnl0100EMYMT_END_DT(psnl0100Dto);					//고용종료일
					
				}

//				returnVal += "_"+ psnl0100DAO.updatePsnl0100HDOFC_CODTN_CD_A0030010(psnl0100Dto);	//재직상태코드
				returnVal += "_"+ psnl0100DAO.updatePsnl0100HDOFC_CODTN_CD(psnl0100Dto);//재직상태코드
				
				returnVal += "_"+ psnl0100DAO.updatePsnl0100ODTY_CD(psnl0100Dto);							//직책코드
				returnVal += "_"+ psnl0100DAO.updatePsnl0100RETRY_REAS_CTNT(psnl0100Dto);					//고용해제사유
				
				// 용인시의 경우에는 소속부서 update 시 관리부서도 동일하게 update 처리 해준다.
				if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
					returnVal += "_"+ psnl0100DAO.updatePsnl0100DEPT_CD(psnl0100Dto);						//관리 부서 
				}
				/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
				
			}else {
				
				String yearStr = new SimpleDateFormat("yyyy").format(new Date());
				
				/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
				/** 1차 : 고용 구분에 따라 **/
				//기간제일 때
				if("A0020020".equals(psnl0100Dto.getEmymtDivCd())) {
					
					// 연장계약 (재고용) 이며, 고용시작일자가 현재 년도보다 클 경우 사업은 update 쳐주지 않는다.
					if(( "A0420030".equals(psnl0100Dto.getEmymtTypCd()) || "A0420020".equals(psnl0100Dto.getEmymtTypCd()))
						&& Integer.parseInt( psnl0100Dto.getEmymtBgnnDt().substring(0, 4)) > Integer.parseInt(yearStr)
						) {
						
					}else {
						returnVal += "_"+ psnl0100DAO.updatePsnl0100BUSIN_CD(psnl0100Dto);					//사업
					}
					
					returnVal += "_"+ psnl0100DAO.updatePsnl0100RETRY_DT(psnl0100Dto);						//퇴직일자
					
				}else if("A0020010".equals(psnl0100Dto.getEmymtDivCd())) {
					
					//공무직일 때
					returnVal += "_"+ psnl0100DAO.updatePsnl0100TYP_OCCU_CD(psnl0100Dto);					//직종
					returnVal += "_"+ psnl0100DAO.updatePsnl0100DTIL_OCCU_INTTN_CD(psnl0100Dto);			//직종세
					
				}
				/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
				
				
				
				/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
				/** 2차 : 고용 유형에 따라 **/
				//신규 or 재고용
				if("A0420010".equals(psnl0100Dto.getEmymtTypCd()) || "A0420020".equals(psnl0100Dto.getEmymtTypCd())) {
					
					//고용구분코드 신규 or 직제개편
					returnVal += "_"+ psnl0100DAO.updatePsnl0100CURR_AFFN_DEPT_CD(psnl0100Dto);				//소속 부서 
					
					// 진안군의 경우 기간제 -> 공무직 전환 시 현부서발령일은 공무직 신규입사일로 처리.
					if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
						
						psnl0100Dto.setEmymtDtTyp(psnl0100Dto.getEmymtDivCd());
						
					}else {
						
						psnl0100Dto.setEmymtDtTyp("");
						
					}
					returnVal += "_"+ psnl0100DAO.updatePsnl0100CURR_DEPT_APPMT_DT(psnl0100Dto);		//현부서 발령일
					
					
					// 진안군의 경우 기간제 -> 공무직 전환 시 최초입사일자는 공무직 신규입사일로 처리.
					if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
						
						psnl0100Dto.setEmymtDtTyp(psnl0100Dto.getEmymtDivCd());
						
					}else {
						
						psnl0100Dto.setEmymtDtTyp("");
						
					}
					//고용구분코드 신규일 때
					returnVal += "_"+ psnl0100DAO.updatePsnl0100FRST_EMYMT_DT(psnl0100Dto);				//최초고용일자
					
					
					
					
//					returnVal += "_"+ psnl0100DAO.updatePsnl0100CURR_DEPT_APPMT_DT(psnl0100Dto);			//현부서 발령일
//					
//					//고용구분코드 신규일 때
//					returnVal += "_"+ psnl0100DAO.updatePsnl0100FRST_EMYMT_DT(psnl0100Dto);					//최초고용일자
					
				//직제개편	
				}else if("A0420050".equals(psnl0100Dto.getEmymtTypCd())) {
					//고용구분코드 신규 or 직제개편
					returnVal += "_"+ psnl0100DAO.updatePsnl0100CURR_AFFN_DEPT_CD(psnl0100Dto);				//현부서
					returnVal += "_"+ psnl0100DAO.updatePsnl0100CURR_DEPT_APPMT_DT(psnl0100Dto);			//현부서 발령일
				
				//퇴직
				}else if("A0420990".equals(psnl0100Dto.getEmymtTypCd())) {
					//고용유형이 퇴직일때만
					returnVal += "_"+ psnl0100DAO.updatePsnl0100RETRY_DT(psnl0100Dto);						//퇴직일자
						
				//전보
				}else if("A0420060".equals(psnl0100Dto.getEmymtTypCd())) {
					returnVal += "_"+ psnl0100DAO.updatePsnl0100CURR_AFFN_DEPT_CD(psnl0100Dto);				//소속 부서 
					returnVal += "_"+ psnl0100DAO.updatePsnl0100CURR_DEPT_APPMT_DT(psnl0100Dto);			//현부서 발령일
				// 연장계약
				}else if("A0420030".equals(psnl0100Dto.getEmymtTypCd())) {
					// 퇴직 후 연장계약 하는 경우도 있으므로 기존의 퇴직일자를 없애주기 위해 연장계약일 때도 퇴직일자 로직 타게끔 추가
					returnVal += "_"+ psnl0100DAO.updatePsnl0100RETRY_DT(psnl0100Dto);						//퇴직일자
				// 공무직전환	
				}else if("A0420090".equals(psnl0100Dto.getEmymtTypCd())) {
				
					returnVal += "_"+ psnl0100DAO.updatePsnl0100CURR_AFFN_DEPT_CD(psnl0100Dto);				// 소속 부서 
				
				}
				/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
					
				
				/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
				/** 3차 : 공통 사항 **/
	//			returnVal += "_"+ psnl0100DAO.updatePsnl0100EMYMT_DIV_CD(psnl0100Dto);	//고용구분
				// 1. 고용구분 : 기간제 근로자, 2. 고용유형 : 재고용, 연장계약 , 3. 사업년도가 올해년도 보다 클 경우
				if("A0020020".equals(psnl0100Dto.getEmymtDivCd()) 
						&& ( "A0420030".equals(psnl0100Dto.getEmymtTypCd()) || "A0420020".equals(psnl0100Dto.getEmymtTypCd()))
						&& Integer.parseInt( psnl0100Dto.getEmymtBgnnDt().substring(0, 4)) > Integer.parseInt(yearStr)
						) {
					
							returnVal += "_"+ psnl0100DAO.updatePsnl0100EMYMT_END_DT(psnl0100Dto);					//고용종료일
							
				}else {
					
					returnVal += "_"+ psnl0100DAO.updatePsnl0100EMYMT_BGNN_DT(psnl0100Dto);					//고용시작일
					returnVal += "_"+ psnl0100DAO.updatePsnl0100EMYMT_END_DT(psnl0100Dto);					//고용종료일
					
				}
				
				returnVal += "_"+ psnl0100DAO.updatePsnl0100HDOFC_CODTN_CD(psnl0100Dto);					//재직상태코드
				returnVal += "_"+ psnl0100DAO.updatePsnl0100ODTY_CD(psnl0100Dto);							//직책코드
				returnVal += "_"+ psnl0100DAO.updatePsnl0100RETRY_REAS_CTNT(psnl0100Dto);					//고용해제사유
				
				
				// 용인시의 경우에는 소속부서 update 시 관리부서도 동일하게 update 처리 해준다.
				if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
					returnVal += "_"+ psnl0100DAO.updatePsnl0100DEPT_CD(psnl0100Dto);						//관리 부서 
					
				}
				/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
				
			}
	
	
	//		returnVal += "_"+ psnl0100DAO.updatePsnl0100END_DEGR_DIV_CD(psnl0100Dto);
	//		returnVal += "_"+ psnl0100DAO.updatePsnl0100END_SCHL(psnl0100Dto);

			egovResultDataList = psnl0100DAO.getMemberInfo(psnl0100Dto);
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					
					Map tempMap = (Map)egovResultDataList.get(i);
					Iterator<String> keys = tempMap.keySet().iterator();
					while( keys.hasNext() ){
			            String key = keys.next();
			            //형 타입이 숫자형일경우 형변환 해준다.
		            	if(tempMap.get(key) instanceof java.math.BigDecimal){
		            		returnDTO.set(key, String.valueOf(tempMap.get(key)));
		            	}else{
		            		returnDTO.set(key, tempMap.get(key));
		            	}
		            }
				}
			}
			
			
			Psnl0110VO psnl0110Vo = new Psnl0110VO();
			psnl0110Vo.setDpobCd(psnl0100Dto.getDpobCd());
			psnl0110Vo.setSystemkey(psnl0100Dto.getSystemkey());
			psnl0110Vo.setEmymtTypCd(psnl0100Dto.getEmymtTypCd());
			// 고용구분이 공무직이고 고용유형이 신규고용, 전보, 재고용, 직제개편인 경우해만 해당 로직 실행
			// 공무직일 경우에만 BASS360 작동
			if("A0020010".equals(psnl0100Dto.getEmymtDivCd()) &&  !"".equals(MSFSharedUtils.defaultNulls(psnl0100Dto.getTypOccuCd(), ""))) {
//				if("A0020010".equals(psnl0100Dto.getEmymtDivCd()) && psnl0100Dto.getTypOccuCd() != null || !"".equals(psnl0100Dto.getTypOccuCd())) {
				//TODO  신규 A0420010 , 직제개편 A0420050, 전보 A0420060, 재고용 A0420020, 연장계약 A0420030 , 공무직전환 A0420090
				if("A0420010".equals(psnl0110Vo.getEmymtTypCd()) 
						|| "A0420020".equals(psnl0110Vo.getEmymtTypCd())
						|| "A0420030".equals(psnl0110Vo.getEmymtTypCd())
						|| "A0420050".equals(psnl0110Vo.getEmymtTypCd()) 
						|| "A0420060".equals(psnl0110Vo.getEmymtTypCd())
						|| "A0420090".equals(psnl0110Vo.getEmymtTypCd())
						) {
					
					
					// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					// 1. 가장 최신의 고용 이력 정보를 가져온다. (신규고용, 재고용, 직제개편, 전보, 연장계약, 공무직전환  중)
					Psnl0110SrhVO psnl0110SrhVo = new Psnl0110SrhVO();
					psnl0110SrhVo.setDpobCd(psnl0110Vo.getDpobCd());
					psnl0110SrhVo.setSystemkey(psnl0110Vo.getSystemkey());
					
					
					Psnl0110VO returnPsnl0110Vo = new Psnl0110VO();
					returnPsnl0110Vo = psnl0110DAO.selectPsnl0110MaxData(psnl0110SrhVo);
					// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					
					if(returnPsnl0110Vo != null) {
						// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
						// 2. 단위기관 코드를 가져온다.
						InfcPkgBass0360SrhVO infcBass0360SrhVo = new InfcPkgBass0360SrhVO();
						
						infcBass0360SrhVo.setDpobCd(returnPsnl0110Vo.getDpobCd());
						infcBass0360SrhVo.setDeptCd(returnPsnl0110Vo.getDeptCd());
						infcBass0360SrhVo.setTypOccuCd(returnPsnl0110Vo.getTypOccuCd());
						infcBass0360SrhVo.setDtilOccuInttnCd(returnPsnl0110Vo.getDtilOccuInttnCd());
						
						
						InfcPkgBass0360VO infcBass0360Vo = new InfcPkgBass0360VO();
						String strPayrMangDeptCd = "";
						
						@SuppressWarnings("unused")
						List infcBass0360List = infcBass0360DAO.getPayrMangDeptCd(infcBass0360SrhVo);
	//					infcBass0360Vo = infcBass0360DAO.getPayrMangDeptCd(infcBass0360SrhVo);
						
						for (int i = 0; i < infcBass0360List.size(); i++) {
							EgovMap egovMap = (EgovMap) infcBass0360List.get(i);
							strPayrMangDeptCd = String.valueOf(egovMap.get("payrMangDeptCd"));
						}
						// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
						
						
						// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
						// 3. 해당 고용 정보를 가지고 단위기관 코드가 존재하는지 찾아본다.
						// 데이터 null 체크
						boolean datacChk = true;
						if(MSFSharedUtils.paramNull(returnPsnl0110Vo.getDpobCd())) {
							datacChk = false;
						}
						
						if(MSFSharedUtils.paramNull(returnPsnl0110Vo.getDeptCd())) {
							datacChk = false;
						}
						
						if(MSFSharedUtils.paramNull(returnPsnl0110Vo.getTypOccuCd())) {
							datacChk = false;
						}
						
						if(MSFSharedUtils.paramNull(returnPsnl0110Vo.getDtilOccuInttnCd())) {
							datacChk = false;
						}
						
						// 데이터가 null 이 아닐 경우에만 실행.
						int iResult = 0;
						if(datacChk) {
							
							infcBass0360SrhVo = new InfcPkgBass0360SrhVO();
							
							infcBass0360SrhVo.setDpobCd(returnPsnl0110Vo.getDpobCd());
							infcBass0360SrhVo.setPayrMangDeptCd(strPayrMangDeptCd);
							infcBass0360SrhVo.setDeptCd(returnPsnl0110Vo.getDeptCd());
							infcBass0360SrhVo.setTypOccuCd(returnPsnl0110Vo.getTypOccuCd());
							infcBass0360SrhVo.setDtilOccuInttnCd(returnPsnl0110Vo.getDtilOccuInttnCd());
							
							iResult = psnl0110DAO.selectBass0360PayrMangDeptCdTotCnt(infcBass0360SrhVo);
						}
						// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
						
						
						
						// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
						// 4. 존재하면 그 값들을 가지고 PAYR0500 을 update 쳐주고 단위기관코드를 리턴, 존재하지 않을 경우 fail 리턴
						if(0 < iResult) {
							
							try{
								
								infcBass0360Vo = new InfcPkgBass0360VO();
								
								psnl0110Vo.setPayrMangDeptCd(strPayrMangDeptCd);
								psnl0110Vo.setIsmt(sessionUser.getUsrId());
								psnl0110Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
								
								psnl0110DAO.updatePayrMangDeptCdPayr0500(psnl0110Vo);
								strPayrMangDeptCd = infcBass0360Vo.getPayrMangDeptCd();
							}catch(Exception e) {
								
								returnDTO.setDataChk("fail");
								e.printStackTrace();		
							}
						}else {
	//						strPayrMangDeptCd = "fail";
							// 기존 컨버전 데이트 중 직종세 권한 안 준 데이터 들로 인해서 fail 리턴 안하도록 처리..
//							returnDTO.setDataChk("fail");
						}
						// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					}
				}
			
				
			// 기간제 근로자일경우 payr0500 단위기관코드 update 처리 해준다.
			}else if("A0020020".equals(psnl0100Dto.getEmymtDivCd())) {
				//TODO  신규 A0420010 , 직제개편 A0420050, 전보 A0420060, 재고용 A0420020, 연장계약 A0420030
				if("A0420010".equals(psnl0110Vo.getEmymtTypCd()) 
						|| "A0420020".equals(psnl0110Vo.getEmymtTypCd())
						|| "A0420030".equals(psnl0110Vo.getEmymtTypCd())
						|| "A0420050".equals(psnl0110Vo.getEmymtTypCd()) 
						|| "A0420060".equals(psnl0110Vo.getEmymtTypCd())) {
					
					// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					// 1. 가장 최신의 고용 이력 정보를 가져온다. (신규고용, 재고용, 직제개편, 전보, 연장계약 중)
					Psnl0110SrhVO psnl0110SrhVo = new Psnl0110SrhVO();
					psnl0110SrhVo.setDpobCd(psnl0110Vo.getDpobCd());
					psnl0110SrhVo.setSystemkey(psnl0110Vo.getSystemkey());
					
					
					Psnl0110VO returnPsnl0110Vo = new Psnl0110VO();
					returnPsnl0110Vo = psnl0110DAO.selectPsnl0110MaxData(psnl0110SrhVo);
					// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					
					
					
					if(returnPsnl0110Vo != null) {
						// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
						// 2. 단위기관 코드를 가져온다.
						InfcPkgBass0400VO infcBass0400SrhVo = new InfcPkgBass0400VO();
						
						infcBass0400SrhVo.setDpobCd(returnPsnl0110Vo.getDpobCd());
						infcBass0400SrhVo.setDeptCd(returnPsnl0110Vo.getDeptCd());
						
						
						String strPayrMangDeptCd = "";
						
						@SuppressWarnings("unused")
						List infcBass0400List = psnl0100DAO.getPayrMangDeptCd_02(infcBass0400SrhVo);
	//					infcBass0360Vo = infcBass0360DAO.getPayrMangDeptCd(infcBass0360SrhVo);
						
						for (int i = 0; i < infcBass0400List.size(); i++) {
							EgovMap egovMap = (EgovMap) infcBass0400List.get(i);
							strPayrMangDeptCd = String.valueOf(egovMap.get("payrMangDeptCd"));
						}
						// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
						
						
						// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
						// 3.. 존재하면 그 값들을 가지고 PAYR0500 을 update 쳐주고 단위기관코드를 리턴
						if(!"".equals(strPayrMangDeptCd) || strPayrMangDeptCd != "") {
							
							try{
								
								
								psnl0110Vo.setPayrMangDeptCd(strPayrMangDeptCd);
								psnl0110Vo.setIsmt(sessionUser.getUsrId());
								psnl0110Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
								
								psnl0110DAO.updatePayrMangDeptCdPayr0500(psnl0110Vo);
								
							}catch(Exception e) {
								
								returnDTO.setDataChk("fail");
								e.printStackTrace();		
							}
						}else {
	//						strPayrMangDeptCd = "fail";
							// 기존 컨버전 데이트 중 직종세 권한 안 준 데이터 들로 인해서 fail 리턴 안하도록 처리..
//							returnDTO.setDataChk("fail");
						}
						// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					}
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S:U",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S:U");
		
		return returnDTO;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Psnl0100DTO> selectPsnl0100Check(Psnl0100DTO param) throws Exception {
		
		String method = calledClass + ".selectPsnl0100Check";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		List<Psnl0100DTO> returnValue = new ArrayList<Psnl0100DTO>();
		List egovResultDataList = new ArrayList();
		
		String windowNm = "인사";
		String windowId = "PSNL0100";
		
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		// 파라미터 보낼 때(암호화)
		param.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(param.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));
		
		
		try{
			egovResultDataList = psnl0100DAO.selectPsnl0100Check(param);
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					
					// 복호화 리턴받을 값 선언
					String rrnDecCrypt = "";
					
					Psnl0100DTO dto = new Psnl0100DTO();
					
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
					
					// 복호화
					rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dto.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
					dto.setResnRegnNum(rrnDecCrypt);
					
					returnValue.add(dto);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);

			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
			
		
		return returnValue;
	}

	
	/** 직종, 직종세 맵핑 **/
    @Override
    public Long createPyspLogSvcYrNumCd(InfcPkgPayr0400DTO payr0400Dto) {
        // TODO Auto-generated method stub
        Long result = new Long(1);
        
        String method = calledClass + ".createPyspLogSvcYrNumCd";
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());  
        

    	String windowNm = "인사";
    		String windowId = "PSNL0100";
        
        try { 
          
            InfcPkgPayr0400VO payr0400Vo = new InfcPkgPayr0400VO();
            
            payr0400Vo.setDpobCd(MSFSharedUtils.allowNulls(payr0400Dto.getDpobCd()));
        	payr0400Vo.setTypOccuCd(MSFSharedUtils.allowNulls(payr0400Dto.getTypOccuCd()));
        	payr0400Vo.setPyspGrdeCd(MSFSharedUtils.allowNulls(payr0400Dto.getPyspGrdeCd()));
        	payr0400Vo.setTypOccuGrdeMppgSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0400Dto.getTypOccuGrdeMppgSeilNum(), "1")));
        	payr0400Vo.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(payr0400Dto.getDtilOccuClsDivCd()));
        	payr0400Vo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(payr0400Dto.getDtilOccuInttnCd()));
        	payr0400Vo.setTypOccuGrdeMppgDelYn("N");
        	payr0400Vo.setKybdr(sessionUser.getUsrId());
        	payr0400Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
        	payr0400Vo.setIsmt(sessionUser.getUsrId());
        	payr0400Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */     
            
            BeanUtils.copyProperties(payr0400Vo, payr0400Dto); 
            
            PayrListenerAdapter payrAdapter = new PayrListenerAdapter(); 
        	result = (long) payrAdapter.createPyspLogSvcYrNumCd(RemoteServiceUtil.getThreadLocalRequest(), payr0400Vo);
            
        }
        catch (Exception ex) {
            logger.error("EXCEPTION calling createPyspLogSvcYrMumCd(): "+ex); 
            
            /** 에러 로그 **/			
            MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"C",ex, windowNm , windowId);

            
            result = new Long(0);
            throw MSFServerUtils.getOperationException("createPyspLogSvcYrNumCd()", ex, logger);
        }
        finally {
          
        }
        return result;
    }
	 

}
