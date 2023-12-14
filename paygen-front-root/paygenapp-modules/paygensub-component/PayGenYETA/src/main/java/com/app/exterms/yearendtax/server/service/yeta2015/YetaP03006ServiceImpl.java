/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.app.exterms.yearendtax.server.service.yeta2015;

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

import com.app.exterms.yearendtax.client.dto.yeta2015.Yeta3110DTO;
import com.app.exterms.yearendtax.client.service.yeta2015.YetaP03006Service;
import com.app.exterms.yearendtax.server.service.yeta2015.dao.Yeta3110DAO;
import com.app.exterms.yearendtax.server.vo.Yeta3110SrhVO;
import com.app.exterms.yearendtax.server.vo.Yeta3110VO;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnOrder;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

@Service("YetaP03006Service")
public class YetaP03006ServiceImpl  extends AbstractCustomServiceImpl implements YetaP03006Service  ,YetaDaoConstants {

	// private  static final Logger LOGGER = LoggerFactory.getLogger(Yeta0100ServiceImpl.class);
	// private static final String calledClass = Yeta0100ServiceImpl.class.getName();
	private static final Logger logger = LoggerFactory.getLogger(YetaP03006ServiceImpl.class);
	private static final String calledClass = YetaP03006ServiceImpl.class.getName();
	
	@Autowired
	@Resource(name = "Yeta3110DAO")
	private Yeta3110DAO yeta3110DAO;
	
	
	
	@Override
	public Long activityOnYetaP03006ToYeta3110(List<Yeta3110DTO> listYeta3110dto, ActionDatabase actionDatabase) throws MSFException {
			// TODO Auto-generated method stub
			Long result = new Long(0);
			Long iCnt = new Long(0);
			
			MSFSysm0100BM sessionUser;
			String method = calledClass + ".activityOnYetaP03006ToYeta3110";
			
			String windowNm = "소득공제신고자료관리";
			String windowId = "YETAP030006";
			
			// 1. 암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	        
	        
			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}
			
			try {  
				if (MSFSharedUtils.paramNull(yeta3110DAO)) {
					WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

					yeta3110DAO = (Yeta3110DAO) wac.getBean("yeta3110DAO" ); 
				}
		            
				for(int iPsnlCnt=0;iPsnlCnt < listYeta3110dto.size();iPsnlCnt++) {
		                
					Yeta3110DTO yeta3110Dto = new Yeta3110DTO();  
					yeta3110Dto = listYeta3110dto.get(iPsnlCnt);
		                 
		            Yeta3110VO yeta3110Vo = new Yeta3110VO(); 
		            
		            
		            yeta3110Vo.setDpobCd(MSFSharedUtils.allowNulls(yeta3110Dto.getDpobCd()));			/** column 사업장코드 : dpobCd */
		            yeta3110Vo.setSystemkey(MSFSharedUtils.allowNulls(yeta3110Dto.getSystemkey()));		/** column SYSTEMKEY : systemkey */
		            yeta3110Vo.setEdacRvyy(MSFSharedUtils.allowNulls(yeta3110Dto.getEdacRvyy()));		/** column 연말정산귀속년도 : edacRvyy */
		            yeta3110Vo.setSettGbcd(MSFSharedUtils.allowNulls(yeta3110Dto.getSettGbcd()));		/** column 정산구분코드 : settGbcd */
		            yeta3110Vo.setSiteNumb(MSFSharedUtils.allowNulls(yeta3110Dto.getSiteNumb().replace("-", "")));		/** column 사업자등록번호 : siteNumb */
		            yeta3110Vo.setJeymStdt(MSFSharedUtils.allowNulls(yeta3110Dto.getJeymStdt()));		/** column 귀속년월_From : jeymStdt */
		            yeta3110Vo.setJeymEddt(MSFSharedUtils.allowNulls(yeta3110Dto.getJeymEddt()));		/** column 귀속년월_TO : jeymEddt */
		            yeta3110Vo.setJutrEddt(MSFSharedUtils.allowNulls(yeta3110Dto.getJutrEddt()));		/** column 감면기간_TO : jutrEddt */
		            yeta3110Vo.setJutrStdt(MSFSharedUtils.allowNulls(yeta3110Dto.getJutrStdt()));		/** column 감면기간_From : jutrStdt */
		            yeta3110Vo.setSiteCtnt(MSFSharedUtils.allowNulls(yeta3110Dto.getSiteCtnt()));		/** column 근무지명 : siteCtnt */
		            yeta3110Vo.setPayrTotl(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3110Dto.getPayrTotl(),"0")));	/** column 급여합계금액 : payrTotl */
		            yeta3110Vo.setBonsAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3110Dto.getBonsAmnt(),"0")));	/** column 상여합계금액 : bonsAmnt */
		            yeta3110Vo.setDtmnBtam(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3110Dto.getDtmnBtam(),"0"))); /** column 인정상여합계금액 : dtmnBtam */
		            yeta3110Vo.setStckPrft(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3110Dto.getStckPrft(),"0")));	/** column 주식행사이익 : stckPrft */
		            yeta3110Vo.setUnonAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3110Dto.getUnonAmnt(),"0")));	/** column 우리사주조합인출금액 : unonAmnt */
		            yeta3110Vo.setOfrrExli(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3110Dto.getOfrrExli(),"0")));	/** column 임원퇴직소득금액한도초과액 : ofrrExli */
		            yeta3110Vo.setTaxeTotl(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3110Dto.getTaxeTotl(),"0")));	/** column 비과세합계금액 : taxeTotl */
		            yeta3110Vo.setReseSmam(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3110Dto.getReseSmam(),"0")));	/** column 연구보조비합계금액 : reseSmam */
		            yeta3110Vo.setEarnTaxn(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3110Dto.getEarnTaxn(),"0")));	/** column 소득세 : earnTaxn */
		            yeta3110Vo.setIhtxTaxn(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3110Dto.getIhtxTaxn(),"0")));	/** column 지방소득세 : ihtxTaxn */
		            yeta3110Vo.setFarmTaxn(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3110Dto.getFarmTaxn(),"0")));	/** column 농특세 : farmTaxn */
		            yeta3110Vo.setAnnuMuam(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3110Dto.getAnnuMuam(),"0")));	/** column 국민연금보험료금액 : annuMuam */
		            yeta3110Vo.setAnnuDdam(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3110Dto.getAnnuDdam(),"0")));	/** column 국민연금보험료공제액 : annuDdam */
		            yeta3110Vo.setAuetMuam(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3110Dto.getAuetMuam(),"0")));	/** column 국민연금외공무원연금 : auetMuam */
		            yeta3110Vo.setAuetSold(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3110Dto.getAuetSold(),"0")));	/** column 국민연금외군인연금 : auetSold */
		            yeta3110Vo.setAuetTech(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3110Dto.getAuetTech(),"0")));	/** column 국민연금외교직원연금 : auetTech */
		            yeta3110Vo.setAuetFect(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3110Dto.getAuetFect(),"0")));	/** column 국민연금외별정우체국 : auetFect */
		            yeta3110Vo.setAuetDdam(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3110Dto.getAuetDdam(),"0")));	/** column 국민연금외공무원연금공제액 : auetDdam */
		            yeta3110Vo.setAuetDold(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3110Dto.getAuetDold(),"0")));	/** column 국민연금외군인연금공제액 : auetDold */
		            yeta3110Vo.setAuetDech(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3110Dto.getAuetDech(),"0")));	/** column 국민연금외교직원연금공제액 : auetDech */
		            yeta3110Vo.setAuetDect(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3110Dto.getAuetDect(),"0")));	/** column 국민연금외별정우체국공제액 : auetDect */
		            yeta3110Vo.setRtreMuam(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3110Dto.getRtreMuam(),"0")));	/** column 퇴직연금과학기술인금액 : rtreMuam */
		            yeta3110Vo.setRtrePsct(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3110Dto.getRtrePsct(),"0")));	/** column 퇴직연금근로자퇴직급여보장법 : rtrePsct */
		            yeta3110Vo.setRtreAnsv(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3110Dto.getRtreAnsv(),"0")));	/** column 퇴직연금연금계좌_연금저축금액 : rtreAnsv */
		            yeta3110Vo.setRtreDdam(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3110Dto.getRtreDdam(),"0")));	/** column 퇴직연금과학기술인공제액 : rtreDdam */
		            yeta3110Vo.setRtreDsct(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3110Dto.getRtreDsct(),"0")));	/** column 퇴직연금근로자퇴직급여보장법공제액 : rtreDsct */
		            yeta3110Vo.setRtreDnsv(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3110Dto.getRtreDnsv(),"0")));	/** column 퇴직연금연금계좌_연금저축공제액 : rtreDnsv */
		            yeta3110Vo.setHlthDbam(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3110Dto.getHlthDbam(),"0")));	/** column 국민건강보험료금액 : hlthDbam */
		            yeta3110Vo.setHlthMuam(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3110Dto.getHlthMuam(),"0")));	/** column 국민건강보험료공제액 : hlthMuam */
		            yeta3110Vo.setUpisJuam(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3110Dto.getUpisJuam(),"0")));	/** column 고용보험금액 : upisJuam */
		            yeta3110Vo.setUpisMuam(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3110Dto.getUpisMuam(),"0")));	/** column 고용보험공제액 : upisMuam */
		            yeta3110Vo.setMangGbyn(MSFSharedUtils.allowNulls(yeta3110Dto.getMangGbyn()));						/** column 처리구분여부 : mangGbyn */
		            yeta3110Vo.setWthdSbyn(MSFSharedUtils.allowNulls(yeta3110Dto.getWthdSbyn()));						/** column 원천징수영수증제출여부 : wthdSbyn */
   
		        	switch (actionDatabase) {
		        		case INSERT:
		        			
		        			yeta3110Vo.setKybdr(sessionUser.getUsrId()); 												/** column 입력자 : kybdr */ 
		        			yeta3110Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());			/** column 입력주소 : inptAddr */ 
				    		
		        			yeta3110Vo.setIsmt(sessionUser.getUsrId());													/** column 수정자 : ismt */
		        			yeta3110Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()); 			/** column 수정주소 : revnAddr */
				    		
		        			yeta3110DAO.insertYetaP03006To3110(yeta3110Vo); 
		        			
		        			break;
		            	case UPDATE:
		            		
		            		yeta3110Vo.setIsmt(sessionUser.getUsrId());													/** column 수정자 : ismt */
		        			yeta3110Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()); 			/** column 수정주소 : revnAddr */
		        			
		            		yeta3110DAO.updateYetaP03006To3110(yeta3110Vo);

		            		break;
		            	case DELETE: 
		            		
		            		yeta3110DAO.deleteYetaP03006To3110(yeta3110Vo); 
		            		
		            		break;
		        	} 
		        		iCnt = iCnt + 1; 
		                    
				} 
				result = iCnt;
		          
			} catch (Exception ex) {
				
				logger.error("EXCEPTION calling activityOnYetaP03001ToYeta3170(): "+ ex); 
				
				/** 에러 로그 **/			
				MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass, actionDatabase.toString(), ex, windowNm , windowId);
		            
				result = new Long(0);
				throw MSFServerUtils.getOperationException("activityOnYetaP03001ToYeta3170", ex, logger);
			}
			finally {
		          
			}
			
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, actionDatabase.toString());
			
			return result;
	}
	
	
	//종전근무지 조회
	public PagingLoadResult<BaseModel> getYetaP03006To3100List(ServiceParameters serviceParameters) throws MSFException {
			
		PagingLoadResult<BaseModel> retval = null;
		String method = CLASS_YETAP03006TOYETA3110_DATA_LIST;
		Yeta3110SrhVO yeta3110SrhVo = new Yeta3110SrhVO();
		List<BaseModel> bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		        
		        
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}

		if (MSFSharedUtils.paramNull(yeta3110DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest().getSession().getServletContext());
			yeta3110DAO = (Yeta3110DAO) wac.getBean("Yeta3110DAO");
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
		    	
//		    	List<String> listDeptCd = new ArrayList<String>();    
		    /** 조건절 */
		    yeta3110SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
		    yeta3110SrhVo.setEdacRvyy(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "edacRvyy")));		//연말정산귀속년도
		    yeta3110SrhVo.setSettGbcd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "settGbcd"))); 	//정산구분코드
		    yeta3110SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));	//systemkey
		    	
		    	
//		    	yeta3220SrhVo.setDpobCd(sessionUser.getDpobCd());	//사업장코드
//		    	yeta3220SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
////		     	psnl0100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));		//단위기관코드
//		     	
//		    	yeta3220SrhVo.setUsrId(sessionUser.getUsrId());
//	            /******************************** 권한 ************************************************************************/
//	            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
//	            if ("FALSE".equals(chkDeptCd)) {
//	            	yeta3220SrhVo.setDeptCd(sessionUser.getDeptCd()); 
//	               listDeptCd.add(sessionUser.getDeptCd());
//	               yeta3220SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
//	               yeta3220SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
//	            } else {
//	            	yeta3220SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드   
//	                     if (yeta3220SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
//	                     	 listDeptCd = null; 
//	                     	yeta3220SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
//	                     	yeta3220SrhVo.setDeptCd("");  //부서코드
//	                     } else {
//	                    	 yeta3220SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
//	                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//	                          yeta3220SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
//	                     } 
//	            }
//	            
////	            } else {
////	            	
////	            }
//	            
//	            yeta3220SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
//	            yeta3220SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));   
//	            
//	           /******************************** 권한 ************************************************************************/
//		     	
//		     	
//	            yeta3220SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
//		            
////		       	List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
////		     	yeta2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
////		      	yeta2000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
//		            
//		       	List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
//		       	yeta3220SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
//		       	yeta3220SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
//		           
////		     	List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
////		     	yeta2000SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
////		     	yeta2000SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
//		             
//		      	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
//		      	yeta3220SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
//		      	yeta3220SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
//		             
//		      	yeta3220SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
//		           
//		           
//		      	yeta3220SrhVo.setEdacRvyy(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "edacRvyy"))); //년도
//		      	yeta3220SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
//		      	yeta3220SrhVo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명 
		            
		      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
		    if ( pagingValues.executeRecordCount ) { 
			            	
		    	//Execute query that returns a single value
		    	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
		                 
		    	int iResultCnt = yeta3110DAO.selectYetaP03006To3110ListTotCnt(yeta3110SrhVo);  
		          	
		          	
		              
		          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
		          	
		          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
	                if (!pagingValues.pageExecute) { 
	                    pagingValues.offsetLimit = iResultCnt;       
	                }
	                
		         	pagingValues.totalRecordCount = iResultCnt;	       
		                
		        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
				}
		        
		     	TimingInfo millisBeginYeta3100DataList = SmrmfUtils.startTiming(logger);
		        
		     	/**페이지 카운트 처리를 위한 부분 */ 
		     	yeta3110SrhVo.setPageSize(pagingValues.totalRecordCount);  
		            
		     	//Apply paging
		     	if (pagingValues.start > 0) {
		     		yeta3110SrhVo.setFirstIndex(pagingValues.start);
		     	}
		     	if (pagingValues.offsetLimit > 0) {
		     		yeta3110SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
		     	}

		     	//Execute query and convert to BaseModel list
		     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
		            
		     	@SuppressWarnings("unchecked")
//		            Collection<Map<String, Object>> list ??????
		     	List list = yeta3110DAO.selectYetaP03001To3170List(yeta3110SrhVo);
		            
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
		            	
		            	//3. 복호화
		          		case ColumnDef.TYPE_STRING: 
		          		          			          			
		          			String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));

		          			String rrnDecCrypt = "";
		          	   			
		          			if(	"resnRegnNum".equals(tableAttributes[i].getName())) {
		          		          			
		          		          			
		          				// 주민번호(복호화)
		          				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		          		          		
		          				strValue = rrnDecCrypt;
		          							
		          			}else if("payFamyResnRegnNum".equals(tableAttributes[i].getName())) {

		          				// 주민번호(복호화)
		          				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		          		          		
		          				strValue = rrnDecCrypt;

		          	        }else if("degtrResnRegnNum".equals(tableAttributes[i].getName())) {

		          				// 주민번호(복호화)
		          				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		          		          		
		          				strValue = rrnDecCrypt;

		          	        }else if("rsnoNumb".equals(tableAttributes[i].getName())) {

		          				// 주민번호(복호화)
		          				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		          		          		
		          				strValue = rrnDecCrypt;

		          	        }else if("cnclRsno".equals(tableAttributes[i].getName())) {

		          				// 주민번호(복호화)
		          				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		          		          		
		          				strValue = rrnDecCrypt;

		          	        }else if("leasRsno".equals(tableAttributes[i].getName())) {

		          				// 주민번호(복호화)
		          				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		          		          		
		          				strValue = rrnDecCrypt;

		          	        }else if("mnrnRsno".equals(tableAttributes[i].getName())) {

		          				// 주민번호(복호화)
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
		            
				SmrmfUtils.endTiming(logger, millisBeginYeta3100DataList, "getYetaP03006To3100List");
		       
			} catch (Exception ex) {
				ex.printStackTrace();
				//Return operation exception
				throw MSFServerUtils.getOperationException(method, ex, logger);
			}
			return retval;
	}	
	
	
} 
 