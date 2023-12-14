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
package com.app.exterms.insurance.server.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
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

import com.app.exterms.insurance.client.dto.Insr2500DTO;
import com.app.exterms.insurance.client.dto.Insr2510DTO;
import com.app.exterms.insurance.client.dto.Insr2530DTO;
import com.app.exterms.insurance.client.service.InsrP230006Service;
import com.app.exterms.insurance.server.service.dao.Insr2100DAO;
import com.app.exterms.insurance.server.service.dao.Insr2500DAO;
import com.app.exterms.insurance.server.service.dao.Insr2510DAO;
import com.app.exterms.insurance.server.service.dao.Insr2520DAO;
import com.app.exterms.insurance.server.service.dao.Insr2530DAO;
import com.app.exterms.insurance.server.vo.Insr2100VO;
import com.app.exterms.insurance.server.vo.Insr2500VO;
import com.app.exterms.insurance.server.vo.Insr2510SrhVO;
import com.app.exterms.insurance.server.vo.Insr2510VO;
import com.app.exterms.insurance.server.vo.Insr2520SrhVO;
import com.app.exterms.insurance.server.vo.Insr2520VO;
import com.app.exterms.insurance.server.vo.Insr2530SrhVO;
import com.app.exterms.insurance.server.vo.Insr2530VO;
import com.app.exterms.insurance.shared.InsrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnOrder;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

import egovframework.rte.psl.dataaccess.util.EgovMap;

          
@Service("InsrP230006Service")
public class InsrP230006ServiceImpl extends AbstractCustomServiceImpl implements InsrP230006Service ,InsrDaoConstants{

	private static final Logger logger = LoggerFactory.getLogger(InsrP230006ServiceImpl.class);
	private static final String calledClass = InsrP230006ServiceImpl.class.getName();

	@Autowired
	@Resource(name="Insr2100DAO")
	private Insr2100DAO insr2100DAO;
	
	@Autowired
	@Resource(name="Insr2500DAO")
	private Insr2500DAO insr2500DAO;
	
	@Autowired
	@Resource(name="Insr2510DAO")
	private Insr2510DAO insr2510DAO;
	
	@Autowired
	@Resource(name="Insr2520DAO")
	private Insr2520DAO insr2520DAO;
	
	@Autowired
	@Resource(name="Insr2530DAO")
	private Insr2530DAO insr2530DAO;
	

	public Long activityOnInsertInsr2520(List<BaseModel> list, Insr2500DTO insr2500Dto, List<Insr2510DTO> insr2510DtoArr, List<Insr2530DTO> insr2530DtoArr ) throws MSFException { 

		Long result = new Long(0); 

	//	String retryYrMnth = new SimpleDateFormat("YYYYMM").format(new java.util.Date());
		
	//	System.out.println("retryYrMnth = "+retryYrMnth);
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get(cal.YEAR);
		int month = cal.get(cal.MONTH)+1;
		
		String retryYrMnth = "";
		
		if(month < 10 ){
			 retryYrMnth = Integer.toString(year)+"0"+Integer.toString(month);
		}else{
			 retryYrMnth = Integer.toString(year)+Integer.toString(month);
		}

		
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());

		try {  
			if  (MSFSharedUtils.paramNull(insr2500DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.
						getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				insr2500DAO = (Insr2500DAO) wac.getBean("Insr2500DAO" ); 
			}
			if  (MSFSharedUtils.paramNull(insr2510DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.
						getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				insr2510DAO = (Insr2510DAO) wac.getBean("Insr2510DAO" ); 
			}
			if  (MSFSharedUtils.paramNull(insr2520DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.
						getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				insr2520DAO = (Insr2520DAO) wac.getBean("Insr2520DAO" ); 
			}
			if  (MSFSharedUtils.paramNull(insr2530DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.
						getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				insr2530DAO = (Insr2530DAO) wac.getBean("Insr2530DAO" ); 
			}
	
			
			//Insr2500DTO insr2500Dto = (Insr2500DTO) hMap.get("insr2500Dto");
			
			System.out.println("=============>>>>> getRetryYrMnth : "+insr2500Dto.getRetryYrMnth());
			
			//고용보험_이직확인
			Insr2500VO insr2500Vo = new Insr2500VO();
			insr2500Vo.setDpobCd(insr2500Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
			insr2500Vo.setSystemkey(insr2500Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
			insr2500Vo.setRetryYrMnth(insr2500Dto.getRetryYrMnth());    /** column 작성년월 : retryYrMnth */
			insr2500Vo.setSocInsrLssEmymtNum(insr2500Dto.getSocInsrLssEmymtNum());    /** column 고용보험상실_고용_일련번호 : socInsrLssEmymtNum */
			insr2500Vo.setSoctyInsurCmptnDt(insr2500Dto.getSoctyInsurCmptnDt());    /** column 사회보험작성일자 : soctyInsurCmptnDt */
			insr2500Vo.setDeptCd(insr2500Dto.getDeptCd());    /** column 부서코드 : deptCd */
			insr2500Vo.setNm(insr2500Dto.getNm());    /** column 성명 : nm */
			insr2500Vo.setIcncDt(insr2500Dto.getIcncDt());    /** column 입사일자 : icncDt */
			insr2500Vo.setUmytInsrAqtnDt(insr2500Dto.getUmytInsrAqtnDt());    /** column 고용보험취득일자 : umytInsrAqtnDt */
			insr2500Vo.setRetryDt(insr2500Dto.getRetryDt());    /** column 퇴직일자 : retryDt */
			insr2500Vo.setUmytInsrChgjbReasCd(insr2500Dto.getUmytInsrChgjbReasCd());    /** column 고용보험이직사유코드 : umytInsrChgjbReasCd */
			insr2500Vo.setUmytInsrSpecResnCtnt(insr2500Dto.getUmytInsrSpecResnCtnt());    /** column 고용보험구체적사유내용 : umytInsrSpecResnCtnt */
			insr2500Vo.setUsalyTisedUntPridNumDys(insr2500Dto.getUsalyTisedUntPridNumDys());    /** column 통상피보험자단위기간일수 : usalyTisedUntPridNumDys */
			insr2500Vo.setAvgAmntCalcTotNumDys(insr2500Dto.getAvgAmntCalcTotNumDys());    /** column 평균임금계산총일수 : avgAmntCalcTotNumDys */
			insr2500Vo.setAvgAmntFndtnSum(insr2500Dto.getAvgAmntFndtnSum());    /** column 평균임금기본금금액 : avgAmntFndtnSum */
			insr2500Vo.setAvgAmntEtcExtpySum(insr2500Dto.getAvgAmntEtcExtpySum());    /** column 평균임금이외수당금액 : avgAmntEtcExtpySum */
			insr2500Vo.setAvgAmntAllwBnusSum(insr2500Dto.getAvgAmntAllwBnusSum());    /** column 평균임금상여금금액 : avgAmntAllwBnusSum */
			insr2500Vo.setAvgAmntAnnlExtpySum(insr2500Dto.getAvgAmntAnnlExtpySum());    /** column 평균임금연차수당금액 : avgAmntAnnlExtpySum */
			insr2500Vo.setAvgAmntEtcSum(insr2500Dto.getAvgAmntEtcSum());    /** column 평균임금기타금액 : avgAmntEtcSum */
			insr2500Vo.setAvgAmntQnty(insr2500Dto.getAvgAmntQnty());    /** column 평균임금액 : avgAmntQnty */
			insr2500Vo.setUsalyAmntWag(insr2500Dto.getUsalyAmntWag());    /** column 통상임금액 : usalyAmntWag */
			insr2500Vo.setStdAmntWag(insr2500Dto.getStdAmntWag());    /** column 기준임금액 : stdAmntWag */
			insr2500Vo.setDayFxdWorkTmNum(insr2500Dto.getDayFxdWorkTmNum());    /** column 1일소정근로시간 : dayFxdWorkTmNum */
			insr2500Vo.setSevePayReipSum(insr2500Dto.getSevePayReipSum());    /** column 퇴직금수령금액 : sevePayReipSum */
			insr2500Vo.setSevePayRstEtcSum(insr2500Dto.getSevePayRstEtcSum());    /** column 퇴직금외기타금액 : sevePayRstEtcSum */
			insr2500Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
			insr2500Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
			insr2500Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
			insr2500Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */			
			
			
			if(insr2500Dto.getRetryYrMnth() == null || insr2500Dto.getRetryYrMnth().equals("")){
				insr2500Vo.setRetryYrMnth(retryYrMnth);    /** column 작성년월 : retryYrMnth */
				insr2500DAO.insertInsr2500(insr2500Vo);
			}else{
				insr2500DAO.updateInsr2500(insr2500Vo);
			}
			
			//고용보험_평균임금산정
			//List insr2510DtoArr = (List) hMap.get("insr2510DtoArr");
			
			for(int i=0; i < insr2510DtoArr.size(); i++ ){
				Insr2510DTO insr2510Dto = (Insr2510DTO) insr2510DtoArr.get(i);
				Insr2510VO insr2510Vo = new Insr2510VO();
				
				insr2510Vo.setDpobCd(insr2510Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
				insr2510Vo.setSystemkey(insr2510Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
				insr2510Vo.setSocInsrLssEmymtNum(insr2510Dto.getSocInsrLssEmymtNum());    /** column 고용보험상실_고용_일련번호 : socInsrLssEmymtNum */
				insr2510Vo.setRetryYrMnth(insr2510Dto.getRetryYrMnth());    /** column 작성년월 : retryYrMnth */
				insr2510Vo.setSevePayDtlPatrNum(insr2510Dto.getSevePayDtlPatrNum());    /** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
				insr2510Vo.setPayPymtBgnnDt(insr2510Dto.getPayPymtBgnnDt());    /** column 임금산정시작일자 : payPymtBgnnDt */
				insr2510Vo.setPayPymtEndDt(insr2510Dto.getPayPymtEndDt());    /** column 임금산정종료일자 : payPymtEndDt */
				insr2510Vo.setPymtNumDys(insr2510Dto.getPymtNumDys());    /** column 임금산정일수 : pymtNumDys */
				insr2510Vo.setAmntBspySum(insr2510Dto.getAmntBspySum());    /** column 임금_기본급금액 : amntBspySum */
				insr2510Vo.setAmntEtcExtpySum(insr2510Dto.getAmntEtcExtpySum());    /** column 임금_이외수당금액 : amntEtcExtpySum */
				insr2510Vo.setAmntAllwBnusSum(insr2510Dto.getAmntAllwBnusSum());    /** column 임금_상여금액 : amntAllwBnusSum */
				insr2510Vo.setAmntAnnlExtpySum(insr2510Dto.getAmntAnnlExtpySum());    /** column 임금_연차수당금액 : amntAnnlExtpySum */
				insr2510Vo.setAmntEtcSum(insr2510Dto.getAmntEtcSum());    /** column 임금_기타금액 : amntEtcSum */
				insr2510Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
				insr2510Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
				insr2510Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
				insr2510Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */	
				
				if(insr2510Dto.getRetryYrMnth() == null || insr2510Dto.getRetryYrMnth().equals("")){
					insr2510Vo.setRetryYrMnth(retryYrMnth);    /** column 작성년월 : retryYrMnth */
					insr2510DAO.insertInsr2510(insr2510Vo);
				}else{
					insr2510DAO.deleteInsr2510(insr2510Vo);
					insr2510DAO.insertInsr2510(insr2510Vo);
				}
					
				//}else{
				//	insr2510DAO.updateInsr2510(insr2510Vo);
				//}
				
			}
			
			//고용보험_산정대상기간
			Iterator<BaseModel> iterRecords = (Iterator<BaseModel>)list.iterator();
			while (iterRecords.hasNext()) {
				BaseModel bmMapModel = (BaseModel) iterRecords.next();      

				//System.out.println("=============>>>>> cmpttnTgtBgnnDt : "+MSFSharedUtils.allowNulls(bmMapModel.get("cmpttnTgtBgnnDt")));
				//System.out.println("=============>>>>> cmpttnTgtPridSeilNum : "+MSFSharedUtils.allowNulls(bmMapModel.get("cmpttnTgtPridSeilNum")));
				
				Insr2520VO  insr2520Vo = new Insr2520VO();	                             
				insr2520Vo.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
				insr2520Vo.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
				insr2520Vo.setRetryYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("retryYrMnth")));    /** column 작성년월 : retryYrMnth */
				insr2520Vo.setSocInsrLssEmymtNum((Long) bmMapModel.get("socInsrLssEmymtNum"));    /** column 고용보험상실_고용_일련번호 : socInsrLssEmymtNum */
				insr2520Vo.setCmpttnTgtPridSeilNum((Long) bmMapModel.get("cmpttnTgtPridSeilNum"));    /** column 산정대상기간일련번호 : cmpttnTgtPridSeilNum */
				insr2520Vo.setCmpttnTgtBgnnDt(MSFSharedUtils.allowNulls(bmMapModel.get("cmpttnTgtBgnnDt")));    /** column 산정대상시작일자 : cmpttnTgtBgnnDt */
				insr2520Vo.setCmpttnTgtEndDt(MSFSharedUtils.allowNulls(bmMapModel.get("cmpttnTgtEndDt")));    /** column 산정대상종료일자 : cmpttnTgtEndDt */
				insr2520Vo.setAmntPymtNumDys((Long) bmMapModel.get("amntPymtNumDys"));    /** column 임금지급기초일수 : amntPymtNumDys */	                           	                            
				insr2520Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
				insr2520Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
				insr2520Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
				insr2520Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */

				//Insr2520VO resultVo = insr2520DAO.selectInsr2520(insr2520Vo);                             
				if(insr2520Vo.getRetryYrMnth() == null || insr2520Vo.getRetryYrMnth().equals("")){
					insr2520Vo.setRetryYrMnth(retryYrMnth);    /** column 작성년월 : retryYrMnth */
					insr2520DAO.insertInsr2520(insr2520Vo);
				}else{
					insr2520DAO.deleteInsr2520(insr2520Vo);
					insr2520DAO.insertInsr2520(insr2520Vo);
				}
					
				//}else{
				//	insr2520DAO.updateInsr2520(insr2520Vo);	                            	  
				//}       
			}

			//고용보험_기준연장기간
			//List insr2530DtoArr = (List) hMap.get("insr2530DtoArr");
			for(int i=0; i < insr2530DtoArr.size(); i++ ){
				Insr2530DTO insr2530Dto = (Insr2530DTO) insr2530DtoArr.get(i);
				Insr2530VO insr2530Vo = new Insr2530VO();
				
				insr2530Vo.setDpobCd(insr2530Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
				insr2530Vo.setSystemkey(insr2530Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
				insr2530Vo.setRetryYrMnth(insr2530Dto.getRetryYrMnth());    /** column 작성년월 : retryYrMnth */
				insr2530Vo.setSocInsrLssEmymtNum(insr2530Dto.getSocInsrLssEmymtNum());    /** column 고용보험상실_고용_일련번호 : socInsrLssEmymtNum */
				insr2530Vo.setStdExtnnSeilNum(insr2530Dto.getStdExtnnSeilNum());    /** column 기준연장일련번호 : stdExtnnSeilNum */
				insr2530Vo.setStdExtnnBgnnDt(insr2530Dto.getStdExtnnBgnnDt());    /** column 기준연장시작일자 : stdExtnnBgnnDt */
				insr2530Vo.setStdExtnnEndDt(insr2530Dto.getStdExtnnEndDt());    /** column 기준연장종료일자 : stdExtnnEndDt */
				insr2530Vo.setStdExtnnReasCd(insr2530Dto.getStdExtnnReasCd());    /** column 기준연장사유코드 : stdExtnnReasCd */
				insr2530Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
				insr2530Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
				insr2530Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
				insr2530Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */	
				
				if(insr2530Dto.getRetryYrMnth() == null || insr2530Dto.getRetryYrMnth().equals("")){
					insr2530Vo.setRetryYrMnth(retryYrMnth);    /** column 작성년월 : retryYrMnth */
					insr2530DAO.insertInsr2530(insr2530Vo);
				}else{
					insr2530DAO.deleteInsr2530(insr2530Vo);
					insr2530DAO.insertInsr2530(insr2530Vo);
				}
					
				//}else{
				//	insr2530DAO.updateInsr2530(insr2530Vo);
				//}
				
			}
			
			result = 1L;
		}
		catch (Exception ex) {
			logger.error("EXCEPTION calling activityOnDeleteInsr2100(): "+ex); 
			result = new Long(0);
			throw MSFServerUtils.getOperationException("activityOnDeleteInsr2200", ex, logger);
		}
		finally {
		}

		return result;
	} 
	
	/**
	 * 고용보험 산정대상기간
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	public PagingLoadResult<BaseModel> getInsrP230006ToInsr2520DataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_INSR2300TOINSR2200_DAO_LIST;
        Insr2520SrhVO   insr2520SrhVO = new Insr2520SrhVO();       
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        List<String> listDeptCd = new ArrayList<String>();
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        if  (MSFSharedUtils.paramNull(insr2520DAO)) {
        	WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
        	insr2520DAO = (Insr2520DAO) wac.getBean("Insr2520DAO" ); 
        }
        
        try {
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
           // Sysm0400BM          user             = serviceParameters.getUser();
            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
            //String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
            
            
            /** 조건절 */
            insr2520SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드             
            //insr2520SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
            
            insr2520SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키	            
            insr2520SrhVO.setRetryYrMnth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "retryYrMnth")));
            insr2520SrhVO.setSocInsrLssEmymtNum(new Long(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "socInsrLssEmymtNum"),"0")));
            
            
           
                       
	         if ( pagingValues.executeRecordCount ) { 
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                int iResultCnt = insr2520DAO.selectInsr2520ListTotCnt(insr2520SrhVO); 
                                             
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;	       
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginInsr2100ToInsr2200DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            insr2520SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	insr2520SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	insr2520SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }
            
         
            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")

            List list = insr2520DAO.selectInsr2520List(insr2520SrhVO);
            
            
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
        
            while ( iter.hasNext() ) {
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
            
            SmrmfUtils.endTiming(logger, millisBeginInsr2100ToInsr2200DataList, "getInsr2100ToInsr2200DataList");
       

        }
        catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
	
	
	
	
	/**
	 * 고용보험 산정대상기간
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	public Insr2500DTO activityOnSelectInsr2500Data(BaseModel baseModel) throws MSFException {

		Insr2500DTO insr2500Dto = new Insr2500DTO();
		
		String windowNm = "사회보험자격상실신고";
		String windowId = "INSRP230006";

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		String method = calledClass + ".activityOnSelectInsr2500Data";

		if  (MSFSharedUtils.paramNull(insr2100DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			insr2100DAO = (Insr2100DAO) wac.getBean("Insr2100DAO" ); 
		}
		
		if  (MSFSharedUtils.paramNull(insr2500DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			insr2500DAO = (Insr2500DAO) wac.getBean("Insr2500DAO" ); 
		}

		try {
			Insr2500VO insr2500Vo = new Insr2500VO();                   
			insr2500Vo.setDpobCd(sessionUser.getDpobCd());         
			insr2500Vo.setSystemkey(MSFSharedUtils.allowNulls(baseModel.get("systemkey")));              
			insr2500Vo.setRetryYrMnth(MSFSharedUtils.allowNulls(baseModel.get("retryYrMnth")));
			insr2500Vo.setSocInsrLssEmymtNum(new Long(MSFSharedUtils.defaultNulls(baseModel.get("socInsrLssEmymtNum"),"0")));

			Insr2500VO resultVo = insr2500DAO.selectInsr2500(insr2500Vo);

			if(resultVo == null){
				Insr2100VO insr2100Vo = new Insr2100VO(); 

				insr2100Vo.setDpobCd(sessionUser.getDpobCd());         
				insr2100Vo.setSystemkey(MSFSharedUtils.allowNulls(baseModel.get("systemkey")));              
				insr2100Vo.setSocInsrLssEmymtNum(new Long(MSFSharedUtils.defaultNulls(baseModel.get("socInsrLssEmymtNum"),"0")));

				EgovMap eMap = insr2100DAO.selectInsr2100ToEtc(insr2100Vo);

				insr2500Dto.setDeptCd((String) eMap.get("deptCd"));    /** column 부서코드 : deptCd */
				insr2500Dto.setIcncDt((String) eMap.get("emymtBgnnDt"));    /** column 입사일자 : icncDt */
				insr2500Dto.setUmytInsrAqtnDt((String) eMap.get("umytInsrAqtnDt"));    /** column 고용보험취득일자 : umytInsrAqtnDt */
				insr2500Dto.setRetryDt((String) eMap.get("retryDt"));    /** column 퇴직일자 : retryDt */
			}else{
				insr2500Dto.setRetryYrMnth(resultVo.getRetryYrMnth());
				insr2500Dto.setSoctyInsurCmptnDt(resultVo.getSoctyInsurCmptnDt());    /** column 사회보험작성일자 : soctyInsurCmptnDt */
				insr2500Dto.setDeptCd(resultVo.getDeptCd());    /** column 부서코드 : deptCd */
				insr2500Dto.setNm(resultVo.getNm());    /** column 성명 : nm */
				insr2500Dto.setIcncDt(resultVo.getIcncDt());    /** column 입사일자 : icncDt */
				insr2500Dto.setUmytInsrAqtnDt(resultVo.getUmytInsrAqtnDt());    /** column 고용보험취득일자 : umytInsrAqtnDt */
				insr2500Dto.setRetryDt(resultVo.getRetryDt());    /** column 퇴직일자 : retryDt */
				insr2500Dto.setUmytInsrChgjbReasCd(resultVo.getUmytInsrChgjbReasCd());    /** column 고용보험이직사유코드 : umytInsrChgjbReasCd */
				insr2500Dto.setUmytInsrSpecResnCtnt(resultVo.getUmytInsrSpecResnCtnt());    /** column 고용보험구체적사유내용 : umytInsrSpecResnCtnt */

				insr2500Dto.setUsalyTisedUntPridNumDys(resultVo.getUsalyTisedUntPridNumDys());    /** column 통상피보험자단위기간일수 : usalyTisedUntPridNumDys */
				insr2500Dto.setAvgAmntCalcTotNumDys(resultVo.getAvgAmntCalcTotNumDys());    /** column 평균임금계산총일수 : avgAmntCalcTotNumDys */
				insr2500Dto.setAvgAmntFndtnSum(resultVo.getAvgAmntFndtnSum());    /** column 평균임금기본금금액 : avgAmntFndtnSum */
				insr2500Dto.setAvgAmntEtcExtpySum(resultVo.getAvgAmntEtcExtpySum());    /** column 평균임금이외수당금액 : avgAmntEtcExtpySum */
				insr2500Dto.setAvgAmntAllwBnusSum(resultVo.getAvgAmntAllwBnusSum());    /** column 평균임금상여금금액 : avgAmntAllwBnusSum */
				insr2500Dto.setAvgAmntAnnlExtpySum(resultVo.getAvgAmntAnnlExtpySum());    /** column 평균임금연차수당금액 : avgAmntAnnlExtpySum */
				insr2500Dto.setAvgAmntEtcSum(resultVo.getAvgAmntEtcSum());    /** column 평균임금기타금액 : avgAmntEtcSum */
				insr2500Dto.setAvgAmntQnty(resultVo.getAvgAmntQnty());    /** column 평균임금액 : avgAmntQnty */
				insr2500Dto.setUsalyAmntWag(resultVo.getUsalyAmntWag());    /** column 통상임금액 : usalyAmntWag */
				insr2500Dto.setStdAmntWag(resultVo.getStdAmntWag());    /** column 기준임금액 : stdAmntWag */
				insr2500Dto.setDayFxdWorkTmNum(resultVo.getDayFxdWorkTmNum());    /** column 1일소정근로시간 : dayFxdWorkTmNum */
				insr2500Dto.setSevePayReipSum(resultVo.getSevePayReipSum());    /** column 퇴직금수령금액 : sevePayReipSum */
				insr2500Dto.setSevePayRstEtcSum(resultVo.getSevePayRstEtcSum());    /** column 퇴직금외기타금액 : sevePayRstEtcSum */
			}
			
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
			
		}catch (Exception ex) {
			ex.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",ex, windowNm , windowId);
			
			//Return operation exception
			throw MSFServerUtils.getOperationException("activityOnSelectInsr2500Data", ex, logger);
		}

		return insr2500Dto;
	}
	
	/**
	 * 고용보험 평균임금산정
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	public List<Insr2510DTO> activityOnSelectInsr2510DataList(BaseModel baseModel) throws MSFException {

		List<Insr2510DTO> resultList = new ArrayList<Insr2510DTO>();
		String method = calledClass + ".activityOnSelectInsr2510DataList";
		
		String windowNm = "사회보험자격상실신고";
		String windowId = "INSRP230006";
		
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
		if  (MSFSharedUtils.paramNull(insr2510DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			insr2510DAO = (Insr2510DAO) wac.getBean("Insr2510DAO" ); 
		}
        
        try {       	
            Insr2510SrhVO insr2510SrhVo = new Insr2510SrhVO();

        	//평균임금산정
        	insr2510SrhVo.setDpobCd(sessionUser.getDpobCd());
        	insr2510SrhVo.setSystemkey(MSFSharedUtils.allowNulls(baseModel.get("systemkey")));
        	insr2510SrhVo.setSocInsrLssEmymtNum(new Long(MSFSharedUtils.defaultNulls(baseModel.get("socInsrLssEmymtNum"),"0")));
	       
        	List insr2510List = insr2510DAO.selectInsr2510List(insr2510SrhVo);
        	
        	for(int i=0; i<insr2510List.size(); i++){
        		Insr2510VO  resultVo = (Insr2510VO) insr2510List.get(i);
        		
        		Insr2510DTO insr2510Dto = new Insr2510DTO();
      		
        		insr2510Dto.setSevePayDtlPatrNum(resultVo.getSevePayDtlPatrNum());    /** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
        		insr2510Dto.setPayPymtBgnnDt(resultVo.getPayPymtBgnnDt());    /** column 임금산정시작일자 : payPymtBgnnDt */
        		insr2510Dto.setPayPymtEndDt(resultVo.getPayPymtEndDt());    /** column 임금산정종료일자 : payPymtEndDt */
        		insr2510Dto.setPymtNumDys(resultVo.getPymtNumDys());    /** column 임금산정일수 : pymtNumDys */
        		insr2510Dto.setAmntBspySum(resultVo.getAmntBspySum());    /** column 임금_기본급금액 : amntBspySum */
        		insr2510Dto.setAmntEtcExtpySum(resultVo.getAmntEtcExtpySum());    /** column 임금_이외수당금액 : amntEtcExtpySum */
        		insr2510Dto.setAmntAllwBnusSum(resultVo.getAmntAllwBnusSum());    /** column 임금_상여금액 : amntAllwBnusSum */
        		insr2510Dto.setAmntAnnlExtpySum(resultVo.getAmntAnnlExtpySum());    /** column 임금_연차수당금액 : amntAnnlExtpySum */
        		insr2510Dto.setAmntEtcSum(resultVo.getAmntEtcSum());    /** column 임금_기타금액 : amntEtcSum */

        		resultList.add(insr2510Dto);
        	}
        }
        catch (Exception ex) {
        	ex.printStackTrace();
        	
        	/** 에러 로그 **/			
        	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",ex, windowNm , windowId);
        	
            //Return operation exception
            throw MSFServerUtils.getOperationException("activityOnSelectInsr2510DataList", ex, logger);
        }
        
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");

        return resultList;
    }
	
	/**
	 * 고용보험 기준연장기간
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	public List<Insr2530DTO> activityOnSelectInsr2530DataList(BaseModel baseModel) throws MSFException {

		List<Insr2530DTO> resultList = new ArrayList<Insr2530DTO>();
		String method = calledClass + ".activityOnSelectInsr2530DataList";
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
    	String windowNm = "사회보험자격상실신고";
		String windowId = "INSRP230006";
        
		if  (MSFSharedUtils.paramNull(insr2530DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			insr2530DAO = (Insr2530DAO) wac.getBean("Insr2530DAO" ); 
		}
        
        try {       	
            Insr2530SrhVO insr2530SrhVo = new Insr2530SrhVO();

        	insr2530SrhVo.setDpobCd(sessionUser.getDpobCd());
        	insr2530SrhVo.setSystemkey(MSFSharedUtils.allowNulls(baseModel.get("systemkey")));
        	insr2530SrhVo.setSocInsrLssEmymtNum(new Long(MSFSharedUtils.defaultNulls(baseModel.get("socInsrLssEmymtNum"),"0")));

        	List insr2530List  = insr2530DAO.selectInsr2530List(insr2530SrhVo);
        	
          	for(int i=0; i<insr2530List.size(); i++){
          		Insr2530VO  resultVo = (Insr2530VO) insr2530List.get(i);
        		
        		Insr2530DTO insr2530Dto = new Insr2530DTO();      	
	        	insr2530Dto.setStdExtnnSeilNum(resultVo.getStdExtnnSeilNum());    /** column 기준연장일련번호 : stdExtnnSeilNum */
	        	insr2530Dto.setStdExtnnBgnnDt(resultVo.getStdExtnnBgnnDt());    	/** column 기준연장시작일자 : stdExtnnBgnnDt */
	        	insr2530Dto.setStdExtnnEndDt(resultVo.getStdExtnnEndDt());    		/** column 기준연장종료일자 : stdExtnnEndDt */
	        	insr2530Dto.setStdExtnnReasCd(resultVo.getStdExtnnReasCd());    	/** column 기준연장사유코드 : stdExtnnReasCd */
	        	resultList.add(insr2530Dto);
          	}

        }
        catch (Exception ex) {
        	ex.printStackTrace();
        	
        	/** 에러 로그 **/			
        	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",ex, windowNm , windowId);
            //Return operation exception
            throw MSFServerUtils.getOperationException("activityOnSelectInsr2530DataList", ex, logger);
        }
        
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");

        return resultList;
    }

}
