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

import com.app.exterms.insurance.client.dto.Insr5400DTO;
import com.app.exterms.insurance.client.service.Insr5400Service;
import com.app.exterms.insurance.server.service.dao.Insr5400DAO;
import com.app.exterms.insurance.server.vo.Insr5400SrhVO;
import com.app.exterms.insurance.server.vo.Insr5400VO;
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
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

@Service("Insr5400Service")
public class Insr5400ServiceImpl extends AbstractCustomServiceImpl implements Insr5400Service ,InsrDaoConstants{
	
	private static final Logger logger = LoggerFactory.getLogger(Insr5400ServiceImpl.class);
	private static final String calledClass = Insr5400ServiceImpl.class.getName();
		
	@Autowired
    @Resource(name="Insr5400DAO")
	private Insr5400DAO insr5400DAO;
		
		  /** ID Generation */
	    //@Resource(name="{egovPayr0400IdGnrService}")    
	    //private EgovIdGnrService egovIdGnrService;
		
	public PagingLoadResult<BaseModel> getInsr5400ToInsr5300DataList(ServiceParameters serviceParameters) throws MSFException {

logger.debug("00000000001");
	        PagingLoadResult<BaseModel> retval = null;
	        String method =  CLASS_INSR5400TOINSR5300_DAO_LIST;
	        Insr5400SrhVO   insr5400SrhVo = new Insr5400SrhVO();
	        Insr5400VO      insr5400Vo = new Insr5400VO();
	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
	        String chkAntyDeinYr = "";   //구분자에 따라 쿼리를 다르게 가져옴.
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	        //if  (MSFSharedUtils.paramNull(insr4200DAO)) {
	        if  (MSFSharedUtils.paramNull(insr5400DAO)) {
	        
	        	WebApplicationContext wac = WebApplicationContextUtils.
	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	        	//insr4200DAO = (Insr4200DAO) wac.getBean("Insr4200DAO" );
	        	insr5400DAO = (Insr5400DAO) wac.getBean("Insr5400DAO" );
	        }
	        
	        try {
	        	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
	           // Sysm0400BM          user             = serviceParameters.getUser();
	            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
	            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
	            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
	            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
               
	            //Get paging configuration
	            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
	            List<String> listDeptCd = new ArrayList<String>();
	            /** 조건절 */
	            insr5400SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	            insr5400SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	            insr5400SrhVo.setPymtYrMnth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deductYrMnth"))); //공제년월
	            insr5400SrhVo.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeDeptCd")));  //관리부서 
	            insr5400SrhVo.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "repbtyBusinDivCd")));       //호봉제 구분
	            
logger.debug("emymtDivCd[" + MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")) + "]");
	            insr5400SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));//고용구분코드
logger.debug("deptCd[" + MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")) + "]");
	            insr5400SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));//부서
logger.debug("typOccuCd[" + MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")) + "]");
	            insr5400SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));//직종
logger.debug("dtilOccuInttnCd[" + MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")) + "]");
	            insr5400SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")));//직종세

	            insr5400SrhVo.setUsrId(sessionUser.getUsrId());  
	            insr5400SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
	            insr5400SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));      
	            /******************************** 권한 ************************************************************************/
	            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	            if ("FALSE".equals(chkDeptCd)) {
	            	insr5400SrhVo.setDeptCd(sessionUser.getDeptCd()); 
	               listDeptCd.add(sessionUser.getDeptCd());
	               insr5400SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
	               insr5400SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	            } else 
	            {
	            	insr5400SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드
                     if (insr5400SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
                     	 listDeptCd = null; 
                     	insr5400SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
                     	insr5400SrhVo.setDeptCd("");  //부서코드
                     } else {
                    	 insr5400SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                          insr5400SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
                     }
	            }

	            /******************************** 권한 ************************************************************************/
	            chkAntyDeinYr = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "chkAntyDeinYr"));
	            
	            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
	            insr5400SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
	            insr5400SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
	            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
	            insr5400SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	            insr5400SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
	            insr5400SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드 
	            insr5400SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
	            insr5400SrhVo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명 
	            List<String> lstHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd"))); 
	            insr5400SrhVo.setHdofcCodtnCdArr(lstHdofcCodtnCd); 
	            insr5400SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));       //재직상태
	            insr5400SrhVo.setSrhHlthInsrYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "srhHlthInsrYr")));
	            //insr5400SrhVo.setPayCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "srhPayCd")));
	            insr5400SrhVo.setPayCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payCd")));

	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
		         if ( pagingValues.executeRecordCount ) { 
		            	
	                //Execute query that returns a single value
	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

	                int iResultCnt =  0;
                	//iResultCnt = insr4200DAO.selectInsr4200ListTotCnt(insr4200SrhVo);  
	                iResultCnt = insr5400DAO.selectInsr5300ToInsr5400ListCnt(insr5400SrhVo);

	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	                
	                pagingValues.totalRecordCount = iResultCnt;	       
	                
	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	            }
	        
	            //TimingInfo millisBeginInsr3150ToInsr4200DataList = SmrmfUtils.startTiming(logger);
		         TimingInfo millisBeginInsr5400ToInsr5300DataList = SmrmfUtils.startTiming(logger);
	        
	            /**페이지 카운트 처리를 위한 부분 */ 
	            insr5400SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	            //Apply paging
	            if (pagingValues.start > 0) {
	            	insr5400SrhVo.setFirstIndex(pagingValues.start);
	            }
	            if (pagingValues.offsetLimit > 0) {
	            	insr5400SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
	            }

	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

	            @SuppressWarnings("unchecked")
	            List list = insr5400DAO.selectInsr5300ToInsr5400List(insr5400SrhVo);  //insr4200 table

				Iterator<Map<String, Object>> iter = list.iterator();
				SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");

//logger.debug("list.get(0).toString()[" + list.get(0).toString() + "]");

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
	                    case ColumnDef.TYPE_STRING: 
	                    	String strValue = String.valueOf(mapCon);
	                    	if("resnRegnNum".equals(tableAttributes[i].getName())) {
	                    		// TODO 주민번호		
	                    		strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(map.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	                    	}
	                    	map.put(tableAttributes[i].getName(), strValue);
	                    	break;
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
	            
	            //SmrmfUtils.endTiming(logger, millisBeginInsr3150ToInsr4200DataList, "getInsr3150ToInsr4200DataList");
	            SmrmfUtils.endTiming(logger, millisBeginInsr5400ToInsr5300DataList, "getInsr5400ToInsr5300DataList");
	        }catch (Exception ex) {
	        	ex.printStackTrace();
	            //Return operation exception
	            throw MSFServerUtils.getOperationException(method, ex, logger);
	        }

	        return retval;
	    }

	@Override
	public int saveInsr5400To5300Grid(List<Insr5400DTO> listInsr5400dto)throws Exception {
		// TODO Auto-generated method stub
		
logger.debug("000001");

        if  (MSFSharedUtils.paramNull(insr5400DAO))
        {
            
        	WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

        	insr5400DAO = (Insr5400DAO) wac.getBean("Insr5400DAO" );
        }

        try
        {
        	int iProc = 0;
			for(int i=0; i<listInsr5400dto.size(); i++)
			{
				Insr5400DTO insr5400Dto = listInsr5400dto.get(i);
				
				Insr5400SrhVO insr5400SrhVo = new Insr5400SrhVO();
logger.debug("000002");

				insr5400SrhVo.setUmytDpobCd(insr5400Dto.getUmytDpobCd());//고용보험사업장코드
				insr5400SrhVo.setUmytInsrClutYr(insr5400Dto.getUmytInsrClutYr());//고용보험정산년도
				insr5400SrhVo.setUmytSystemkey(insr5400Dto.getUmytSystemkey());//고용보험시스템키
				insr5400SrhVo.setEmymtSeilNum2(insr5400Dto.getEmymtSeilNum2());//고용보험고용일련번호
				insr5400SrhVo.setUmytInsrAqtnDt(insr5400Dto.getUmytInsrAqtnDt());//고용보험취득일자
				insr5400SrhVo.setUmytInsrLssDt(insr5400Dto.getUmytInsrLssDt());//고용보험상실일자
				insr5400SrhVo.setUmytInsrPayTotAmnt(insr5400Dto.getUmytInsrPayTotAmnt());//고용보험보수총액

				int iCnt = insr5400DAO.selectInsr5300Cnt(insr5400SrhVo);

				if (iCnt <= 0)
				{
					logger.debug("getUmytDpobCd[" + insr5400Dto.getUmytDpobCd() + "]");
					logger.debug("getUmytInsrClutYr[" + insr5400Dto.getUmytInsrClutYr() + "]");
					logger.debug("getUmytSystemkey[" + insr5400Dto.getUmytSystemkey() + "]");
					logger.debug("getEmymtSeilNum2[" + insr5400Dto.getEmymtSeilNum2() + "]");
					logger.debug("getUmytInsrAqtnDt[" + insr5400Dto.getUmytInsrAqtnDt() + "]");
					logger.debug("getUmytInsrLssDt[" + insr5400Dto.getUmytInsrLssDt() + "]");
					logger.debug("getUmytInsrPayTotAmnt[" + insr5400Dto.getUmytInsrPayTotAmnt() + "]");

					logger.debug("INSR5300 테이블 insert");
					insr5400DAO.insertInsr5300(insr5400SrhVo);
				}else
				{
					logger.debug("getUmytDpobCd[" + insr5400Dto.getUmytDpobCd() + "]");
					logger.debug("getUmytInsrClutYr[" + insr5400Dto.getUmytInsrClutYr() + "]");
					logger.debug("getUmytSystemkey[" + insr5400Dto.getUmytSystemkey() + "]");
					logger.debug("getEmymtSeilNum2[" + insr5400Dto.getEmymtSeilNum2() + "]");
					logger.debug("getUmytInsrAqtnDt[" + insr5400Dto.getUmytInsrAqtnDt() + "]");
					logger.debug("getUmytInsrLssDt[" + insr5400Dto.getUmytInsrLssDt() + "]");
					logger.debug("getUmytInsrPayTotAmnt[" + insr5400Dto.getUmytInsrPayTotAmnt() + "]");
					
					logger.debug("INSR5300 테이블 update");
					insr5400DAO.updateInsr5300(insr5400SrhVo);
				}

				insr5400SrhVo = new Insr5400SrhVO();

				insr5400SrhVo.setIdtlDpobCd(insr5400Dto.getIdtlDpobCd());//산재보험사업장코드
				insr5400SrhVo.setIdtlAccdtInsurClutYr(insr5400Dto.getIdtlAccdtInsurClutYr());//산재보험정산년도
				insr5400SrhVo.setIdtlSystemkey(insr5400Dto.getIdtlSystemkey());//산재보험시스템키
				insr5400SrhVo.setEmymtSeilNum1(insr5400Dto.getEmymtSeilNum1());//산재보험고용일련번호
				insr5400SrhVo.setIdtlAccdtInsurAqtnDt(insr5400Dto.getIdtlAccdtInsurAqtnDt());//산재취득일자
				insr5400SrhVo.setIdtlAccdtInsurLssDt(insr5400Dto.getIdtlAccdtInsurLssDt());//산재상실일자
				insr5400SrhVo.setIdtlAccdtPayTotAmnt(insr5400Dto.getIdtlAccdtPayTotAmnt());//산재보수총액

				iCnt = insr5400DAO.selectInsr6200Cnt(insr5400SrhVo);  //insr6200 table

				if (iCnt <= 0)
				{
					logger.debug("getUmytDpobCd[" + insr5400Dto.getUmytDpobCd() + "]");
					logger.debug("getUmytInsrClutYr[" + insr5400Dto.getUmytInsrClutYr() + "]");
					logger.debug("getUmytSystemkey[" + insr5400Dto.getUmytSystemkey() + "]");
					logger.debug("getEmymtSeilNum2[" + insr5400Dto.getEmymtSeilNum2() + "]");
					logger.debug("getUmytInsrAqtnDt[" + insr5400Dto.getUmytInsrAqtnDt() + "]");
					logger.debug("getUmytInsrLssDt[" + insr5400Dto.getUmytInsrLssDt() + "]");
					logger.debug("getUmytInsrPayTotAmnt[" + insr5400Dto.getUmytInsrPayTotAmnt() + "]");

					logger.debug("INSR6200 테이블 insert");
					insr5400DAO.insertInsr6200(insr5400SrhVo);
				}else
				{
					logger.debug("getIdtlDpobCd[" + insr5400Dto.getIdtlDpobCd() + "]");
					logger.debug("getIdtlAccdtInsurClutYr[" + insr5400Dto.getIdtlAccdtInsurClutYr() + "]");
					logger.debug("getIdtlSystemkey[" + insr5400Dto.getIdtlSystemkey() + "]");
					logger.debug("getEmymtSeilNum1[" + insr5400Dto.getEmymtSeilNum1() + "]");
					logger.debug("getIdtlAccdtInsurAqtnDt[" + insr5400Dto.getIdtlAccdtInsurAqtnDt() + "]");
					logger.debug("getIdtlAccdtInsurLssDt[" + insr5400Dto.getIdtlAccdtInsurLssDt() + "]");
					logger.debug("getIdtlAccdtPayTotAmnt[" + insr5400Dto.getIdtlAccdtPayTotAmnt() + "]");

					logger.debug("INSR6200 테이블 update");
					insr5400DAO.updateInsr6200(insr5400SrhVo);
				}

				iProc++;
			}
        }catch (Exception ex)
        {
        	logger.error("EXCEPTION calling saveInsr5400To5300Grid(): "+ex.toString());
        	throw MSFServerUtils.getOperationException("saveInsr5400To5300Grid", ex, logger);
        }finally
        {
          
        }
         
		return 0;
	}
}
