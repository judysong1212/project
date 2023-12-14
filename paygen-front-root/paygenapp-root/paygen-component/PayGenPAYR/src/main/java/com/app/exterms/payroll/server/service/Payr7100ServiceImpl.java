package com.app.exterms.payroll.server.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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

import com.app.exterms.payroll.client.dto.Hpe100BM;
import com.app.exterms.payroll.client.dto.Hpe100DTO;
import com.app.exterms.payroll.client.service.Payr7100Service;
import com.app.exterms.payroll.server.service.dao.Hpe100DAO;
import com.app.exterms.payroll.server.service.dao.Payr0500DAO;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnOrder;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.sysif.msfpackage.server.utils.SysifPkgServiceUtils;
import com.app.smrmf.sysm.server.service.vo.SysIfBass0350VO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

@Service("Payr7100Service")
public class Payr7100ServiceImpl extends AbstractCustomServiceImpl implements Payr7100Service, PayrDaoConstants {

	private static final Logger logger = LoggerFactory.getLogger(Payr7100ServiceImpl.class);
	private static final String calledClass = Payr7100ServiceImpl.class.getName();
	  
	// 원천세신고기준  
	@Autowired
	@Resource(name = "Hpe100DAO")
	private Hpe100DAO hpe100DAO;

	
		//추가_20200925
		@Override
		public Long setPayr7100DataSave(Hpe100DTO hpe100Dto){
			
				Long result = new Long(1);
				MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
				String method = calledClass + ".payr7100DataSave";
				
				if (RemoteServiceUtil.getThreadLocalRequest() != null) {
					sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
				} else {
					sessionUser = getUser();
				}
				
				try{
					
					hpe100Dto.setDPOB_CD(sessionUser.getDpobCd());
					hpe100Dto.setUsrId(sessionUser.getUsrId());
					hpe100Dto.setDEPT_CD(hpe100Dto.getDEPT_CD());
					/*hpe101Vo.setYrtxBlggYr(hpe101Dto.getYrtxBlggYr()); //정산년도 */		
					hpe100Dto.setYEAR_YYYY(hpe100Dto.getYEAR_YYYY());
					hpe100Dto.setHALF_YEAR(hpe100Dto.getHALF_YEAR());
					hpe100Dto.setDEGTR_NM(hpe100Dto.getDEGTR_NM());
					hpe100Dto.setDPOB_NM(hpe100Dto.getDPOB_NM());
					hpe100Dto.setBUSOPR_RGSTN_NUM(hpe100Dto.getBUSOPR_RGSTN_NUM());
					hpe100Dto.setRESN_REGN_NUM(hpe100Dto.getRESN_REGN_NUM());
					hpe100Dto.setCORP_RGSTN_NUM(hpe100Dto.getCORP_RGSTN_NUM());
					hpe100Dto.setDPOB_ZPCD(hpe100Dto.getDPOB_ZPCD());
					hpe100Dto.setDPOB_FNDTN_ADDR(hpe100Dto.getDPOB_FNDTN_ADDR());
					hpe100Dto.setDPOB_DTL_PATR_ADDR(hpe100Dto.getDPOB_DTL_PATR_ADDR());
					hpe100Dto.setTX_OFFC_CD(hpe100Dto.getTX_OFFC_CD());
					hpe100Dto.setSUBMITTER(hpe100Dto.getSUBMITTER());
					hpe100Dto.setTAX_AGENT_NO(hpe100Dto.getTAX_AGENT_NO());
					hpe100Dto.setHOMETAX_ID(hpe100Dto.getHOMETAX_ID());
					hpe100Dto.setTAX_PGM_CODE(hpe100Dto.getTAX_PGM_CODE());
					hpe100Dto.setDEPT_NM(hpe100Dto.getDEPT_NM());
					hpe100Dto.setUSR_TEL(hpe100Dto.getUSR_TEL());
					hpe100Dto.setUSR_NM(hpe100Dto.getUSR_NM());
					
					hpe100Dto.setKYBDR(sessionUser.getUsrId());
					hpe100Dto.setINPT_ADDR(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    
					hpe100Dto.setISMT(sessionUser.getUsrId());    
					hpe100Dto.setREVN_ADDR(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()); 
					
					hpe100DAO.setPayr7100DataSave(hpe100Dto);
				
				/** 로그반영
				 * CRUDSBLO
				 * C   //create  
		    	 * R   //read
		    	 * U   //update
		    	 * D   //delete
		    	 * S   //select
		    	 * B   //배치 
		    	 * L   //로그인 
		    	 * O   //로그아웃
		    	 */
				MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "C");
				
			}catch(Exception e){
				e.printStackTrace();
				result = new Long(0);
				throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
			}
			
			return result;
			
		}
	
	
		
    //간이지급명세서 신고파일생성 조회
	public Hpe100BM getPayr7100List(Hpe100DTO hpe100Dto) throws MSFException {
		
			MSFSysm0100BM sessionUser;
			String method = calledClass + ".getPayr7100List";
			
			String windowNm = "간이지급명세서";
			String windowId = "PAYR7100";

			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}

			if (MSFSharedUtils.paramNull(hpe100DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest()
						.getSession().getServletContext());
				hpe100DAO = (Hpe100DAO) wac.getBean("Hpe100DAO");
			}
					
			/** 조건절 */
			hpe100Dto.setSrhYrtxBlggYr(MSFSharedUtils.allowNulls(hpe100Dto.getSrhYrtxBlggYr())); //정산년도
				
			List<String> listDeptCd = new ArrayList<String>(); 
		   	hpe100Dto.setDPOB_CD(sessionUser.getDpobCd());	//사업장코드
		   	hpe100Dto.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
		  	
		   	hpe100Dto.setDeptCdAuth(MSFSharedUtils.allowNulls(hpe100Dto.getSrhDeptCd()));  //권한처리를위해 추가  
		   	hpe100Dto.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(hpe100Dto.getSrhDtilOccuInttnCd()).replace(",", ""));   
		     
		   	hpe100Dto.setUsrId(sessionUser.getUsrId()); //유저아이디
		   	/******************************** 권한 ************************************************************************/
		   	String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();

		   	if ("FALSE".equals(chkDeptCd)) {
		   		if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(hpe100Dto.getSrhDeptCd(),sessionUser.getDeptCd()))) {
		   			hpe100Dto.setSrhDeptCd(sessionUser.getDeptCd()); 
		   			listDeptCd.add(sessionUser.getDeptCd());
		   			hpe100Dto.setDeptCdArr(listDeptCd);     //부서코드
		   		} else {
		   			hpe100Dto.setSrhDeptCd(MSFSharedUtils.allowNulls(hpe100Dto.getSrhDeptCd()));
		   			listDeptCd = SmrmfUtils.getStrToArrayList(hpe100Dto.getSrhDeptCd());  
		   			hpe100Dto.setDeptCdArr(listDeptCd);     //부서코드    
		   		}
		   		
		   		hpe100Dto.setSrhPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
		   	} else {
		   		hpe100Dto.setSrhPayrMangDeptCd(MSFSharedUtils.allowNulls(hpe100Dto.getSrhPayrMangDeptCd())) ;   //단위기관코드   
		   	 		
		   		if (hpe100Dto.getSrhPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(hpe100Dto.getSrhDeptCd()))) { 
		   			listDeptCd = null; 
		   			hpe100Dto.setDeptCdArr(listDeptCd);     //부서코드 
		   			hpe100Dto.setSrhDeptCd("");  //부서코드
		   		} else {
		   			hpe100Dto.setSrhDeptCd(MSFSharedUtils.allowNulls(hpe100Dto.getSrhDeptCd()));
		   			listDeptCd = SmrmfUtils.getStrToArrayList(hpe100Dto.getSrhDeptCd());  
		   			hpe100Dto.setDeptCdArr(listDeptCd);     //부서코드   
		   		}
		   	}
		     
		   	/******************************** 권한 ************************************************************************/
		   	hpe100Dto.setSrhEmymtDivCd(MSFSharedUtils.allowNulls(hpe100Dto.getSrhEmymtDivCd()));      		//고용구분코드
		   	
		   	/*hpe100Dto.setHALF_YEAR(MSFSharedUtils.allowNulls(hpe100Dto.getHALF_YEAR())); //근무시기*/	   
		   	
		   	List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(hpe100Dto.getSrhTypOccuCd())); 
		   	hpe100Dto.setTypOccuCdArr(lstTypeOccuCd); 
		   	hpe100Dto.setSrhTypOccuCd(MSFSharedUtils.allowNulls(hpe100Dto.getSrhTypOccuCd()));  	//직종
		   	
		   	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(hpe100Dto.getSrhDtilOccuInttnCd())); 
		   	hpe100Dto.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
		   	hpe100Dto.setSrhDtilOccuInttnCd(MSFSharedUtils.allowNulls(hpe100Dto.getSrhDtilOccuInttnCd())); //직종세
		        
		   	List<String> lstBusinCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(hpe100Dto.getSrhBusinCd())); 
		   	hpe100Dto.setBusinCdArr(lstBusinCd);
		   	hpe100Dto.setSrhBusinCd(MSFSharedUtils.allowNulls(hpe100Dto.getSrhBusinCd()));   //사업코드
		   	
		   	hpe100Dto.setUsrId(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));		//User Id
		   	
		   	hpe100Dto.setSrhUtDpobCd(MSFSharedUtils.allowNulls(hpe100Dto.getSrhUtDpobCd()));				//원천징수부서
		   	
		   	hpe100Dto.setHALF_YEAR(MSFSharedUtils.allowNulls(hpe100Dto.getHALF_YEAR())); //근무시기
		   	
		   	
		   	Hpe100BM returnHpe100Bm = new Hpe100BM();
			List egovResultDataList = new ArrayList();

			try {
				egovResultDataList =  hpe100DAO.selectPayr7100BasisSave(hpe100Dto);
				if(egovResultDataList == null || egovResultDataList.size() < 1) {
					egovResultDataList =  hpe100DAO.selectPayr7100BasisInit(hpe100Dto);
				}

				if(egovResultDataList != null && egovResultDataList.size() > 0){
					for(int i = 0 ; i < egovResultDataList.size(); i++){
						// 1. 암호화 객체 생성
						String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

						Map tempMap = (Map)egovResultDataList.get(i);
						Iterator<String> keys = tempMap.keySet().iterator();

						// 2.복호화 리턴받을 값 선언
						String rrnDecCrypt = "";
						
						while( keys.hasNext() ){
							String key = keys.next();
							//형 타입이 숫자형일경우 형변환 해준다.
							if(tempMap.get(key) instanceof java.math.BigDecimal){
								returnHpe100Bm.set(key, String.valueOf(tempMap.get(key)));
							}else{
								
			            		if("resnRegnNum".equals(key)) {
			            			// 복호화
			            			rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(String.valueOf(tempMap.get(key))).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
			            			returnHpe100Bm.set(key, rrnDecCrypt);
			            			
			            		}else if("resuNumb".equals(key)) {
			            			// 복호화
			            			rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(String.valueOf(tempMap.get(key))).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
			            			returnHpe100Bm.set(key, rrnDecCrypt);
			            			
			            		}else {
			            			
			            			returnHpe100Bm.set(key, tempMap.get(key));
			            		}
					    	}
						}
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				
				/** 에러 로그 **/			
				MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S", ex, windowNm , windowId);
			}
			
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
		  	 * D:delete		S:select	B:배치 
		  	 * L:로그인		O:로그아웃
		  	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
			
			return returnHpe100Bm;
		}

		//간이지급명세서 조회
	public PagingLoadResult<BaseModel> getPayr7100DataList(ServiceParameters serviceParameters) throws MSFException {
					
					PagingLoadResult<BaseModel> retval = null;
					String method =  CLASS_PAYR7100_DATA_LIST;
					Hpe100DTO hpe100Dto = new Hpe100DTO();
					List<BaseModel> bmResult = new ArrayList<BaseModel>();
					MSFSysm0100BM sessionUser;
					    
					if (RemoteServiceUtil.getThreadLocalRequest() != null) {
						sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
					} else {
						sessionUser = getUser();
					}
				      
					if  (MSFSharedUtils.paramNull(hpe100DAO)) {
						WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
						hpe100DAO = (Hpe100DAO) wac.getBean("Hpe100DAO" ); 
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
				      	//String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
				    	
				    	List<String> listDeptCd = new ArrayList<String>();    
				      	/** 조건절 */
				    	hpe100Dto.setDPOB_CD(sessionUser.getDpobCd());	//사업장코드
				    	//hpe100Dto.setSrhClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));//정산구분
				    	hpe100Dto.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 

				    	hpe100Dto.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
				    	hpe100Dto.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));   
			            
				    	hpe100Dto.setUsrId(sessionUser.getUsrId());
				    	
			            /******************************** 권한 ************************************************************************/
			            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
			            if ("FALSE".equals(chkDeptCd)) {
			            	if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"),sessionUser.getDeptCd()))) {
			            		hpe100Dto.setSrhDeptCd(sessionUser.getDeptCd()); 
			            		listDeptCd.add(sessionUser.getDeptCd());
			            		hpe100Dto.setDeptCdArr(listDeptCd);     //부서코드
			            	} else {
			            		hpe100Dto.setSrhDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
			            		listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
			            		hpe100Dto.setDeptCdArr(listDeptCd);     //부서코드     
			            	}
			            	hpe100Dto.setSrhPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
			            } else {
			            	hpe100Dto.setSrhPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드   
			            	if (hpe100Dto.getSrhPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
			            		listDeptCd = null; 
			            		hpe100Dto.setDeptCdArr(listDeptCd);     //부서코드 
			            		hpe100Dto.setSrhDeptCd("");  //부서코드
			            	} else {
			            		hpe100Dto.setSrhDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
			            		listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
			            		hpe100Dto.setDeptCdArr(listDeptCd);     //부서코드   
			            	}
			            }            
			            /******************************** 권한 ************************************************************************/
				     	
			            hpe100Dto.setSrhYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yearYyyy"))); //년도
			            hpe100Dto.setHALF_YEAR(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "halfYearGroup"))); //근무시기
			            hpe100Dto.setSrhEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
			            
				       	List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
				       	hpe100Dto.setTypOccuCdArr(lstTypeOccuCd); 
				       	hpe100Dto.setSrhTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
				        
				      	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
				      	hpe100Dto.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
				      	hpe100Dto.setSrhDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
				             
				      	List<String> lstBusinCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd"))); 
				      	hpe100Dto.setBusinCdArr(lstBusinCd);  
				      	hpe100Dto.setSrhBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd"))); //사업
				      	
				      	//hpe100Dto.setPERSON_NUMB(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
				      	//hpe100Dto.setHAN_NM(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명 
					 
				      	hpe100Dto.setSrhUtDpobCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "utDpobCd"))); 			//원천신고부서  
				      	//hpe100Dto.setSrhBusoprRgstnum(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "busoprRgstnum")));	//사업자등록번호
				      	
				      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
						if ( pagingValues.executeRecordCount ) {
							//Execute query that returns a single value
				        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
				                 
				          	int iResultCnt = hpe100DAO.selectHpe100ToPayr7100DataListTotCnt(hpe100Dto);  
				              
				          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
				          	
				          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
			                if (!pagingValues.pageExecute) { 
			                    pagingValues.offsetLimit = iResultCnt;       
			                }
			                
				         	pagingValues.totalRecordCount = iResultCnt;
				                
				        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
						}
				        
				     	TimingInfo millisBeginPsnl0126DataList = SmrmfUtils.startTiming(logger);
				        
				     	/**페이지 카운트 처리를 위한 부분 */ 
				     	hpe100Dto.setPageSize(pagingValues.totalRecordCount);  
				            
				     	//Apply paging
				     	if (pagingValues.start > 0) {
				     		hpe100Dto.setFirstIndex(pagingValues.start);
				     	}
				     	if (pagingValues.offsetLimit > 0) {
				     		hpe100Dto.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
				     	}

				     	//Execute query and convert to BaseModel list
				     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
				            
				     	@SuppressWarnings("unchecked")
				     	List list = hpe100DAO.selectHpe100ToPayr7100DataList(hpe100Dto);
				            
						Iterator<Map<String, Object>> iter = list.iterator();
					            
						SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
						
						while (iter.hasNext()) {

							// 1. 암호화 객체 생성
							String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
							
							Map<String, Object> map = (Map<String, Object>) iter.next();
							String idValue = map.get("personNumb").toString();
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
				            	
				        				//3. 복호화
				        			case ColumnDef.TYPE_STRING:
				        				String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));
				        				String rrnDecCrypt = "";
				        				
				        				if(	"resnRegnNum".equals(tableAttributes[i].getName())) {	//	주민등록번호
				        					rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
				        					strValue = rrnDecCrypt;
				        				}
				        				else if("payFamyResnRegnNum".equals(tableAttributes[i].getName())) {
				        					rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
				        					strValue = rrnDecCrypt;
				        				}
				        				else if("degtrResnRegnNum".equals(tableAttributes[i].getName())) {
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
				            
						SmrmfUtils.endTiming(logger, millisBeginPsnl0126DataList, "getPayr7100DataList");
				       
					} catch (Exception ex) {
						ex.printStackTrace();
						//Return operation exception
						throw MSFServerUtils.getOperationException(method, ex, logger);
					}
					return retval;
				}

		
	//간이지급명세서 조회	
		public Hpe100BM setPayr7100SummaryData(Hpe100DTO hpe100Dto) throws MSFException {
		
			MSFSysm0100BM sessionUser;
			String method = calledClass + ".setPayr7100SummaryData";
			
			String windowNm = "간이지급명세서";
			String windowId = "PAYR7100";

			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}

			if (MSFSharedUtils.paramNull(hpe100DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest()
						.getSession().getServletContext());
				hpe100DAO = (Hpe100DAO) wac.getBean("Hpe100DAO");
			}
					
			/** 조건절 */
			hpe100Dto.setSrhYrtxBlggYr(MSFSharedUtils.allowNulls(hpe100Dto.getSrhYrtxBlggYr()));/** column 연말정산귀속년도 : yrtxBlggYr */
			//hpe100Dto.setSrhClutSeptCd(MSFSharedUtils.allowNulls(hpe100Dto.getSrhClutSeptCd()));/** column 정산구분코드 : clutSeptCd */
			
			List<String> listDeptCd = new ArrayList<String>(); 
		   	hpe100Dto.setDPOB_CD(sessionUser.getDpobCd());	//사업장코드
		   	hpe100Dto.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
		  	
		   	hpe100Dto.setDeptCdAuth(MSFSharedUtils.allowNulls(hpe100Dto.getSrhDeptCd()));  //권한처리를위해 추가  
		   	hpe100Dto.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(hpe100Dto.getSrhDtilOccuInttnCd()).replace(",", ""));   
		     
		   	hpe100Dto.setUsrId(sessionUser.getUsrId());
		   	/******************************** 권한 ************************************************************************/
		   	String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();

		   	if ("FALSE".equals(chkDeptCd)) {
		   		if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(hpe100Dto.getSrhDeptCd(),sessionUser.getDeptCd()))) {
		   			hpe100Dto.setSrhDeptCd(sessionUser.getDeptCd()); 
		   			listDeptCd.add(sessionUser.getDeptCd());
		   			hpe100Dto.setDeptCdArr(listDeptCd);     //부서코드
		   		} else {
		   			hpe100Dto.setSrhDeptCd(MSFSharedUtils.allowNulls(hpe100Dto.getSrhDeptCd()));
		   			listDeptCd = SmrmfUtils.getStrToArrayList(hpe100Dto.getSrhDeptCd());  
		   			hpe100Dto.setDeptCdArr(listDeptCd);     //부서코드    
		   		}
		   		
		   		hpe100Dto.setSrhPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
		   	} else {
		   		hpe100Dto.setSrhPayrMangDeptCd(MSFSharedUtils.allowNulls(hpe100Dto.getSrhPayrMangDeptCd())) ;   //단위기관코드   
		   	 		
		   		if (hpe100Dto.getSrhPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(hpe100Dto.getSrhDeptCd()))) { 
		   			listDeptCd = null; 
		   			hpe100Dto.setDeptCdArr(listDeptCd);     //부서코드 
		   			hpe100Dto.setSrhDeptCd("");  //부서코드
		   		} else {
		   			hpe100Dto.setSrhDeptCd(MSFSharedUtils.allowNulls(hpe100Dto.getSrhDeptCd()));
		   			listDeptCd = SmrmfUtils.getStrToArrayList(hpe100Dto.getSrhDeptCd());  
		   			hpe100Dto.setDeptCdArr(listDeptCd);     //부서코드   
		   		}
		   	}
		     
		   	/******************************** 권한 ************************************************************************/
		   	hpe100Dto.setSrhEmymtDivCd(MSFSharedUtils.allowNulls(hpe100Dto.getSrhEmymtDivCd()));      		//고용구분코드
		   	
		   	List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(hpe100Dto.getSrhTypOccuCd())); 
		   	hpe100Dto.setTypOccuCdArr(lstTypeOccuCd); 
		   	hpe100Dto.setSrhTypOccuCd(MSFSharedUtils.allowNulls(hpe100Dto.getSrhTypOccuCd()));  	//직종
		   	
		   	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(hpe100Dto.getSrhDtilOccuInttnCd())); 
		   	hpe100Dto.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
		   	hpe100Dto.setSrhDtilOccuInttnCd(MSFSharedUtils.allowNulls(hpe100Dto.getSrhDtilOccuInttnCd())); //직종세
		        
		   	List<String> lstBusinCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(hpe100Dto.getSrhBusinCd())); 
		   	hpe100Dto.setBusinCdArr(lstBusinCd);
		   	hpe100Dto.setSrhBusinCd(MSFSharedUtils.allowNulls(hpe100Dto.getSrhBusinCd()));   //사업코드
		   	
		   	hpe100Dto.setUsrId(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));		//User Id
		   	
		   	hpe100Dto.setSrhUtDpobCd(MSFSharedUtils.allowNulls(hpe100Dto.getSrhUtDpobCd()));				//원천신고부서
		   	
		   	
		   	Hpe100BM returnHpe100Bm = new Hpe100BM();
			

			try {
				hpe100DAO.setPayr7100SummaryData(hpe100Dto);
			} catch (Exception ex) {
				ex.printStackTrace();
				
				/** 에러 로그 **/			
				MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S", ex, windowNm , windowId);
			}
			
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
		  	 * D:delete		S:select	B:배치 
		  	 * L:로그인		O:로그아웃
		  	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
			
			return returnHpe100Bm;
		}
		
//**----------2022.01.19 PDS(전자신고기본정보)조회 추가작업 (START)---------**//		
	
		public Hpe100BM getPayr7100Hpe000T(Hpe100DTO hpe100Dto) throws MSFException {
			
			MSFSysm0100BM sessionUser;
			String method = calledClass + ".getPayr7100Hpe000T";
			
			String windowNm = "간이지급명세서";
			String windowId = "PAYR7100";

			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}

			if (MSFSharedUtils.paramNull(hpe100DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest()
						.getSession().getServletContext());
				hpe100DAO = (Hpe100DAO) wac.getBean("Hpe100DAO");
			}
					
			/** 조건절 */
		 	
			hpe100Dto.setDPOB_CD(sessionUser.getDpobCd());	//사업장코드
	    	hpe100Dto.setYEAR_YYYY(MSFSharedUtils.allowNulls(hpe100Dto.getYEAR_YYYY()));//년도
	    	hpe100Dto.setHALF_YEAR(MSFSharedUtils.allowNulls(hpe100Dto.getHALF_YEAR())); //상하반기
	    	//hpe100Dto.setDEPT_CD(MSFSharedUtils.allowNulls(hpe100Dto.getSrhDeptCd())); //원천신고부서
	    	hpe100Dto.setDEPT_CD(sessionUser.getDeptCd()); //원천신고부서
	    	hpe100Dto.setUsrId(sessionUser.getUsrId());  //사용자ID

			
		   	
		   	/******************************** 권한 ************************************************************************/
		   	String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();

		   	if ("FALSE".equals(chkDeptCd)) {
		   		if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(hpe100Dto.getSrhDeptCd(),sessionUser.getDeptCd()))) {
		   			hpe100Dto.setSrhDeptCd(sessionUser.getDeptCd()); 
		   		} else {
		   			hpe100Dto.setSrhDeptCd(MSFSharedUtils.allowNulls(hpe100Dto.getSrhDeptCd()));
		   		}
		   		
		   		hpe100Dto.setSrhPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
		   	} else {
		   		hpe100Dto.setSrhPayrMangDeptCd(MSFSharedUtils.allowNulls(hpe100Dto.getSrhPayrMangDeptCd())) ;   //단위기관코드   
		   	 		
		   		if (hpe100Dto.getSrhPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(hpe100Dto.getSrhDeptCd()))) { 
		   			hpe100Dto.setSrhDeptCd("");  //부서코드
		   		} else {
		   			hpe100Dto.setSrhDeptCd(MSFSharedUtils.allowNulls(hpe100Dto.getSrhDeptCd()));
		   		}
		   	}
		
		   	Hpe100BM returnHpe100Bm = new Hpe100BM();
			List egovResultDataList = new ArrayList();

			try {
				egovResultDataList =  hpe100DAO.selectPayr7100BasisSave(hpe100Dto);
				if(egovResultDataList == null || egovResultDataList.size() < 1) {
					egovResultDataList =  hpe100DAO.selectPayr7100BasisInit(hpe100Dto);
				}

				if(egovResultDataList != null && egovResultDataList.size() > 0){
					for(int i = 0 ; i < egovResultDataList.size(); i++){
		
						Map tempMap = (Map)egovResultDataList.get(i);
						Iterator<String> keys = tempMap.keySet().iterator();

						// 2.복호화 리턴받을 값 선언
						String rrnDecCrypt = "";
						
						while( keys.hasNext() ){
							String key = keys.next();
							//형 타입이 숫자형일경우 형변환 해준다.
							if(tempMap.get(key) instanceof java.math.BigDecimal){
								returnHpe100Bm.set(key, String.valueOf(tempMap.get(key)));
							}else{
								
			            		if("resnRegnNum".equals(key)) {
			            			// 복호화
			            		//	rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(String.valueOf(tempMap.get(key))).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
			            			returnHpe100Bm.set(key, rrnDecCrypt);
			            			
			            		}else if("resuNumb".equals(key)) {
			            			// 복호화
			            		//	rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(String.valueOf(tempMap.get(key))).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
			            			returnHpe100Bm.set(key, rrnDecCrypt);
			            			
			            		}else {
			            			
			            			returnHpe100Bm.set(key, tempMap.get(key));
			            		}
					    	}
						}
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				
				/** 에러 로그 **/			
				MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S", ex, windowNm , windowId);
			}
			
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
		  	 * D:delete		S:select	B:배치 
		  	 * L:로그인		O:로그아웃
		  	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
			
			return returnHpe100Bm;
		}
//**----------2022.01.19 PDS(전자신고기본정보)조회 추가작업 (END)---------**//		
		
		
}