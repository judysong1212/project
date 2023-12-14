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
package com.app.exterms.yearendtax.server.service.yeta2017;
 
 
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.utils.SmrmfUtils;
import org.msf.utils.TimingInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.exterms.yearendtax.client.dto.yeta2017.Ye160401DTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.Ye161010DTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.Ye161020DTO;
import com.app.exterms.yearendtax.client.service.yeta2017.Yeta2100Service;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye160401DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye160402DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye160403DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye160404DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye160406DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye161010DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye161020DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye161050DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye161055DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye161060DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye169010DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Yeta1100DAO;
import com.app.exterms.yearendtax.server.vo.Ye160401VO;
import com.app.exterms.yearendtax.server.vo.Ye160402VO;
import com.app.exterms.yearendtax.server.vo.Ye160403VO;
import com.app.exterms.yearendtax.server.vo.Ye160404VO;
import com.app.exterms.yearendtax.server.vo.Ye160406VO;
import com.app.exterms.yearendtax.server.vo.Ye161010SrhVO;
import com.app.exterms.yearendtax.server.vo.Ye161010VO;
import com.app.exterms.yearendtax.server.vo.Ye161020VO;
import com.app.exterms.yearendtax.server.vo.Ye161050VO;
import com.app.exterms.yearendtax.server.vo.Ye161055VO;
import com.app.exterms.yearendtax.server.vo.Ye161060VO;
import com.app.exterms.yearendtax.server.vo.Ye169010VO;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
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
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160401VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010VO;
import com.app.smrmf.pkg.listener.yeta.yeta2017.Yeta2100ListenerAdapter;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

/**
 * 
* <pre>
* 1. 패키지명 : com.app.exterms.yearendtax.server.service
* 2. 타입명 : Yeta0100ServiceImpl.java
* 3. 작성일 : Jan 13, 2016 5:12:49 PM
* 4. 작성자 : leeheuisung
* 5. 설명 :
* </pre>
 */
@Service("Yeta2100Service")
public class Yeta2100ServiceImpl  extends AbstractCustomServiceImpl implements Yeta2100Service  ,YetaDaoConstants {

	 
	private static final Logger logger = LoggerFactory.getLogger(Yeta2100ServiceImpl.class);
	private static final String calledClass = Yeta2100ServiceImpl.class.getName();

	@Autowired
	@Resource(name = "Yeta1100DAO")
	private Yeta1100DAO yeta1100DAO;
	
	// 연말정산대상자기본
	@Autowired
	@Resource(name = "Ye161010DAO")
	private Ye161010DAO ye161010DAO;
	
	// 인적소득공제기본
	@Autowired
	@Resource(name = "Ye161020DAO")
	private Ye161020DAO ye161020DAO;
	
	// 현근무지급여지급명세
	@Autowired
	@Resource(name = "Ye160401DAO")
	private Ye160401DAO ye160401DAO;
	
	// 감면소득_과세
	@Autowired
	@Resource(name = "Ye160402DAO")
	private Ye160402DAO ye160402DAO;
	
	// 감면소득_비과세
	@Autowired
	@Resource(name = "Ye160403DAO")
	private Ye160403DAO ye160403DAO;
	
	// 종전근무지
	@Autowired
	@Resource(name = "Ye160404DAO")
	private Ye160404DAO ye160404DAO;
	
	 // 종전근무지연금보험료_공적연금
	@Autowired
	@Resource(name = "Ye160406DAO")
	private Ye160406DAO ye160406DAO;
	
	@Autowired
	@Resource(name = "Ye161050DAO")
	private Ye161050DAO ye161050DAO;
	
	@Autowired
	@Resource(name = "Ye161055DAO")
	private Ye161055DAO ye161055DAO;
	
	@Autowired
	@Resource(name = "Ye161060DAO")
	private Ye161060DAO ye161060DAO;
	
	@Autowired
	@Resource(name = "Ye169010DAO")
	private Ye169010DAO ye169010DAO;
	
	    
	/**
	 * 연말정산대상자내역조회
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	//조회
	public PagingLoadResult<BaseModel> getYeta2100ToYe161010DataList(ServiceParameters serviceParameters) throws MSFException {
		

		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA2100_DATA_LIST;
		Ye161010SrhVO   ye161010SrhVO = new Ye161010SrhVO();
//		Psnl0100VO      psnl0100VO = new Psnl0100VO();
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	        
	        
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
	      
		if  (MSFSharedUtils.paramNull(ye161010DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			ye161010DAO = (Ye161010DAO) wac.getBean("Ye161010DAO"); 
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
//	      	String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
	    	 List<String> listDeptCd = new ArrayList<String>(); 
	      	/** 조건절 */
	    	 ye161010SrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
	    	 ye161010SrhVO.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));			// 정산년도
	    	 ye161010SrhVO.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));		// 정산구분 
	      	
	    	 ye161010SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
//	     	psnl0100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));		//단위기관코드
	     	
	    	 ye161010SrhVO.setUsrId(sessionUser.getUsrId());
            /******************************** 권한 ************************************************************************/
            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
            if ("FALSE".equals(chkDeptCd)) {
            	
            	if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"),sessionUser.getDeptCd()))) {
               	 

                	ye161010SrhVO.setDeptCd(sessionUser.getDeptCd()); 
                   listDeptCd.add(sessionUser.getDeptCd());
                   ye161010SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
           	 } else {
           		 ye161010SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                 listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                 ye161010SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
                    
           	 }  
            	   
               ye161010SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
            } else {
            	    
            	ye161010SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드   
                     if (ye161010SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
                     	 listDeptCd = null; 
                     	ye161010SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
                     	ye161010SrhVO.setDeptCd("");  //부서코드
                     } else {
                    	 ye161010SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                          ye161010SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
                     } 
                  
            }
            
//            } else {
//            	
//            }
            
            ye161010SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
            ye161010SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));   
            
           /******************************** 권한 ************************************************************************/
	     	
	     	
	    	List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));  
	    	ye161010SrhVO.setHdofcCodtnCdArr(listHdofcCodtnCd);     //부서코드 
	    	ye161010SrhVO.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));			//재직코드
	     	
	     	
	    	ye161010SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));      		//고용구분코드
	            
//	       	List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//	       	psnl0100SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
//	      	psnl0100SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));			//부서코드
	            
	       	List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
	       	ye161010SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
	       	ye161010SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  	//직종
	           
//	     	List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//	     	psnl0100SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
//	     	psnl0100SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
	             
	      	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
	      	ye161010SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	      	ye161010SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 	//직종세
	             
	      	ye161010SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   				//사업코드
	           
	      	ye161010SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  				//시스템키
	      	ye161010SrhVO.setFnm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "fnm")));    						//한글성명 
	      	ye161010SrhVO.setUtDpobCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "utDpobCd")));	//단위사업장
	      	ye161010SrhVO.setUsrId(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));		//User Id
	      	ye161010SrhVO.setUtDpobChk(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "utDpobChk")) );
	            
	      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 
		            	
				//Execute query that returns a single value
	        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	          	int iResultCnt = ye161010DAO.selectYe161010ListTotCnt(ye161010SrhVO);  
	              
	          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
	          	
	          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                
	         	pagingValues.totalRecordCount = iResultCnt;	       
	                
	        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
	        
	     	TimingInfo millisBeginYeta2100ToYe161010DataList = SmrmfUtils.startTiming(logger);
	        
	     	/**페이지 카운트 처리를 위한 부분 */ 
	     	ye161010SrhVO.setPageSize(pagingValues.totalRecordCount);  
	            
	     	//Apply paging
	     	if (pagingValues.start > 0) {
	     		ye161010SrhVO.setFirstIndex(pagingValues.start);
	     	}
	     	if (pagingValues.offsetLimit > 0) {
	     		ye161010SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
	     	}
//
	     	//Execute query and convert to BaseModel list
	     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	     	@SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	     	List list = ye161010DAO.selectYe161010List(ye161010SrhVO);
	            
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
	          							
	          			}else if("resnoEncCntn".equals(tableAttributes[i].getName())) {
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
	            
			SmrmfUtils.endTiming(logger, millisBeginYeta2100ToYe161010DataList, "getYeta2100ToYe161010DataList");
	       
		} catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
			
    /**
     * 
     * <pre>
     * 1. 개요 : 선택된 대상자에 대해 급여자료을 이관한다. 
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : PayrExec_Yeta_Insert_2017
     * @date : Jan 06, 2017
     * @author : leeheuisung
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	Jan 06, 2017		BaeDaEun				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param listYe160401Dto
     * @return
     * @throws MSFException
     */
    @Override
    public  Long PayrExec_Yeta_Insert_2017(List<Ye161010DTO> listYe161010Dto) throws MSFException {
	    	 
    	 
		String method = calledClass + ".PayrExec_Yeta_Insert_2017";

		String windowNm = "17.연말정산대상자관리";
		String windowId = "YETA2100";

		Long retval = 0L;
		int delCnt = 0; 
		BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		//List<InfcPkgYe160401VO> lstYe160401Vo = new ArrayList<InfcPkgYe160401VO>(); // 현근무지급여지급명세
		//InfcPkgYe160401VO yePrc160401Vo = new InfcPkgYe160401VO(); // 현근무지급여지급명세

		Ye160401VO ye160401Vo = new Ye160401VO(); // 현근무지급여지급명세
		Ye160402VO ye160402Vo = new Ye160402VO(); // 과세감면소득
		Ye160403VO ye160403Vo = new Ye160403VO(); // 비과세감면소득
		
		Ye161050VO ye161050Vo = new Ye161050VO();
		Ye161055VO ye161055Vo = new Ye161055VO();
		Ye161060VO ye161060Vo = new Ye161060VO();
		Ye169010VO ye169010Vo = new Ye169010VO();
		
		List<InfcPkgYe161010VO> listYe161010VO = new ArrayList<InfcPkgYe161010VO>();
	        
	 
			 
			try{
				
	            for(int iYetaCnt=0; iYetaCnt < listYe161010Dto.size(); iYetaCnt++) {

					// 1. 암호화 객체 생성
					String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			            	 
			                
        		Ye161010DTO ye161010Dto = new Ye161010DTO();  
            	Ye161010VO  ye161010Vo = new Ye161010VO();
        	 
            	InfcPkgYe161010VO infcPkgYe161010Vo = new InfcPkgYe161010VO();
            	ye161010Dto = listYe161010Dto.get(iYetaCnt);  
            	

            	/**
            	 * +++++++++++++검색조건 넘김 INSERT 시작 +++++++++++++
            	 * */	
            	   /** 조건절 */
            	ye161010Vo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
            	ye161010Vo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
            	ye161010Vo.setUsrId(sessionUser.getUsrId());  
            	
            	/**
            	 * +++++++++++++ YE161010 INSERT 시작 +++++++++++++
            	 * */
            	ye161010Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));    					/** column 사업장코드 : dpobCd */
            	ye161010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161010Dto.getYrtxBlggYr()));    			/** column 귀속연도 : yrtxBlggYr */
            	ye161010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye161010Dto.getClutSeptCd()));    			/** column 연말정산구분코드 : clutSeptCd */
            	ye161010Vo.setSystemkey(MSFSharedUtils.allowNulls(ye161010Dto.getSystemkey()));    				/** column SYSTEMKEY : systemkey */
            	ye161010Vo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(ye161010Dto.getPayrMangDeptCd()));    	/** column 급여관리부서코드 : payrMangDeptCd */
            	ye161010Vo.setEmymtDivCd(MSFSharedUtils.allowNulls(ye161010Dto.getEmymtDivCd()));    			/** column 당시_고용구분코드 : emymtDivCd */
            	ye161010Vo.setDeptCd(MSFSharedUtils.allowNulls(ye161010Dto.getDeptCd()));    					/** column 당시_부서코드 : deptCd */
            	ye161010Vo.setTypOccuCd(MSFSharedUtils.allowNulls(ye161010Dto.getTypOccuCd()));    				/** column 당시_직종코드 : typOccuCd */
            	ye161010Vo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(ye161010Dto.getDtilOccuInttnCd()));    	/** column 당시_직종세통합코드 : dtilOccuInttnCd */
            	ye161010Vo.setBusinCd(MSFSharedUtils.allowNulls(ye161010Dto.getBusinCd()));    					/** column 당시_사업코드 : businCd */ 
            	ye161010Vo.setKybdr(sessionUser.getUsrId());    												/** column 입력자 : kybdr */
            	ye161010Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 입력주소 : inptAddr */
            	ye161010Vo.setIsmt(sessionUser.getUsrId());    													/** column 수정자 : ismt */
            	ye161010Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 수정주소 : revnAddr */
         
		   
     	//    {******************************급여자료 이관*******************************************}
            
            	BeanUtils.copyProperties(ye160401Vo, ye161010Vo);
            	BeanUtils.copyProperties(infcPkgYe161010Vo, ye161010Vo);
            	
			//	BeanUtils.copyProperties(ye160402Vo, ye161010Vo);
			//	BeanUtils.copyProperties(ye160403Vo, ye161010Vo);
			//	BeanUtils.copyProperties(ye161050Vo, ye161010Vo);
			//	BeanUtils.copyProperties(ye161055Vo, ye161010Vo);
			//	BeanUtils.copyProperties(ye161060Vo, ye161010Vo);
			//	BeanUtils.copyProperties(ye169010Vo, ye161010Vo);
		
		       // [과세감면내역 삭제 ]
		        ye160401DAO.fnYeta2100_Ye160401_CREATE_Delete(ye160401Vo);
				       
				// 과세감면소득
			//	ye160402DAO.fnYeta2100_Ye160402_CREATE_Delete(ye160402Vo);
				
				
				// [비과세감면내역 삭제 ]
				// 비과세감면소득
			//	ye160403DAO.fnYeta2100_Ye160403_CREATE_Delete(ye160403Vo);
				
				
				// {급여내역삭제}
				// 급여내역 삭제
			//	ye160401Vo.setElctYymm(ye160401Dto.getElctYymm());    		/** column 지급년월 : elctYymm */
				
			//	ye161050DAO.deleteYetaP210001_Ye161050VO_2017_Delete(ye161050Vo);
			//	ye161055DAO.deleteYetaP210001_Ye161055VO_2017_Delete(ye161055Vo);
			//	ye161060DAO.deleteYetaP210001_Ye161060VO_2017_Delete(ye161060Vo);
			//	ye169010DAO.deleteYetaP210001_Ye169010VO_2017_Delete(ye169010Vo);

				delCnt = delCnt + 1;
				
				
				// 이관메소드 호출을 위해
//				yePrc160401Vo = new InfcPkgYe160401VO(); // 현근무지급여지급명세
//				
//				yePrc160401Vo.setDpobCd(ye160401Dto.getDpobCd());    			/** column 사업장코드 : dpobCd */
//				yePrc160401Vo.setYrtxBlggYr(ye160401Dto.getYrtxBlggYr());    	/** column 귀속연도 : yrtxBlggYr */
//				yePrc160401Vo.setClutSeptCd(ye160401Dto.getClutSeptCd());    	/** column 연말정산구분코드 : clutSeptCd */
//				yePrc160401Vo.setSystemkey(ye160401Dto.getSystemkey());    		/** column SYSTEMKEY : systemkey */
//				
//				yePrc160401Vo.setPayrMangDeptCd(ye160401Dto.getPayrMangDeptCd());		/** column 급여관리부서코드 : payrMangDeptCd */
//				yePrc160401Vo.setEmymtDivCd(ye160401Dto.getEmymtDivCd());    			/** column 고용구분코드 : emymtDivCd */
//				yePrc160401Vo.setDeptCd(ye160401Dto.getDeptCd());    					/** column 부서코드 : deptCd */
//				yePrc160401Vo.setBusinCd(ye160401Dto.getBusinCd());    					/** column 사업코드 : businCd */
//				yePrc160401Vo.setTypOccuCd(ye160401Dto.getTypOccuCd());    				/** column 직종코드 : typOccuCd */
//				yePrc160401Vo.setDtilOccuInttnCd(ye160401Dto.getDtilOccuInttnCd());		/** column 직종세통합코드 : dtilOccuInttnCd */

	            
				listYe161010VO.add(infcPkgYe161010Vo);

			}	  
			if (delCnt > 0) {

				Yeta2100ListenerAdapter yetaLsAdtr = new Yeta2100ListenerAdapter();
//				for(int i =0; i < listYe161010VO.size() ; i++){
//					logger.debug("test "+i+" : "+ToStringBuilder.reflectionToString(listYe161010VO.get(i)));
//				}				
				// 컴포넌트 호출하기
				yetaLsAdtr.setPayrToYeta_Insert(RemoteServiceUtil.getThreadLocalRequest(),listYe161010VO);
				 
			}
			retval = 1L;
			
		} catch (Exception ex) {
		
			logger.error("EXCEPTION calling PayrExec_Yeta_Insert_2017(): " + ex);
			
			/** 에러 로그 **/
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser, method,calledClass, "C", ex, windowNm, windowId);
		
			retval = 0L;
			throw MSFServerUtils.getOperationException("PayrExec_Yeta_Insert_2017", ex, logger);
		}
		
		/**
		 * 로그반영 CRUDSBLO C:create R:read U:update D:delete S:select B:배치 L:로그인
		 * O:로그아웃
		 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass,"C");

		return retval;

	}
    
    /**
     * 
     * <pre>
     * 1. 개요 : 연말정산 대상자 삭제  
     * 2. 처리내용 : 선택된 연말정산 대상자를 삭제한다.
     * </pre>
     * @Method Name : Yeta2100ToYe160401_Delete
     * @date : Jan 18, 2016
     * @author : leeheuisung
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	Jan 18, 2016		leeheuisung				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @return
     */
    @Override
    public  Long Yeta2100ToYe160401_Delete(List<Ye161010DTO> listYe161010Dto) throws MSFException {
    	
		String method = calledClass + ".Yeta2100ToYe160401_Delete";

		String windowNm = "연말정산대상자관리";
		String windowId = "YETA2100";
    	 
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
    		
		Long retval = 0L;
    	BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);  

//		Ye160401VO ye160401Vo = new Ye160401VO(); // 현근무지급여지급명세
//		Ye160402VO ye160402Vo = new Ye160402VO(); // 현근무지비과세_감면소득_과세
//		Ye160403VO ye160403Vo = new Ye160403VO(); // 현근무지비과세_감면소득_비과세
//		Ye160404VO ye160404vo = new Ye160404VO(); // 종전근무지
//		Ye160406VO ye160406Vo = new Ye160406VO(); // 종전근무지연금보험료_공적연금

		
//		Ye161020VO ye161020Vo = new Ye161020VO(); // 인적소득공제기본
		   
	    MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	  	
	    try {
	     
	    	for(int i = 0; i < listYe161010Dto.size(); i ++) {
				
	    		Ye161010DTO ye161010Dto = new Ye161010DTO();  
	    		Ye161010VO ye161010Vo = new Ye161010VO(); // 연말정산대상자기본
	    		ye161010Dto = listYe161010Dto.get(i);    
	            	 
	            	ye161010Vo.setDpobCd(ye161010Dto.getDpobCd());    		/** column null : dpobCd */
	            	ye161010Vo.setYrtxBlggYr(ye161010Dto.getYrtxBlggYr());    /** column 귀속연도 : yrtxBlggYr */
	            	ye161010Vo.setClutSeptCd(ye161010Dto.getClutSeptCd());   	/** column 연말정산구분코드 : clutSeptCd */	
	            	ye161010Vo.setSystemkey(ye161010Dto.getSystemkey());	/** column SYSTEMKEY : systemkey */ 
					 
				 
					/**  Ye161010VO    // 연말정산대상자기본   **/
					ye161010DAO.deleteYetaP210001_Ye161010VO_2017_Delete(ye161010Vo);
					 
	  			   
	        	  }	  			    
				   retval = 1L;
	        }catch (Exception ex) {
	        	 
	            logger.error("EXCEPTION calling Yeta2100ToYe160401_Delete(): "+ex); 
	            
	            /** 에러 로그 **/			
	            MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"D", ex, windowNm , windowId);
	            
	            retval = 0L;
	            throw MSFServerUtils.getOperationException("Yeta2100ToYe160401_Delete", ex, logger);
	        } 
	        
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "D"); 
	        
	        
	        return retval;
    }

	@Override
	public Long UpDpobExec_Yeta_Insert_2017(List<Ye161010DTO> listYe161010Dto)
			throws MSFException {
		 
   	 
			String method = calledClass + ".UpDpobExec_Yeta_Insert_2017";

			String windowNm = "17.연말정산대상자관리";
			String windowId = "YETA2100";

			Long retval = 0L;
			int delCnt = 0; 
			BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);
			MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			 
			List<InfcPkgYe161010VO> listYe161010VO = new ArrayList<InfcPkgYe161010VO>();
		         
				try{
					
		            for(int iYetaCnt=0; iYetaCnt < listYe161010Dto.size(); iYetaCnt++) {
 
	        		Ye161010DTO ye161010Dto = new Ye161010DTO();  
	            	Ye161010VO  ye161010Vo = new Ye161010VO();
	        	 
	            	InfcPkgYe161010VO infcPkgYe161010Vo = new InfcPkgYe161010VO();
	            	ye161010Dto = listYe161010Dto.get(iYetaCnt);  
	            	

	            	/**
	            	 * +++++++++++++검색조건 넘김 INSERT 시작 +++++++++++++
	            	 * */	
	            	   /** 조건절 */
	            	ye161010Vo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	            	ye161010Vo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	            	ye161010Vo.setUsrId(sessionUser.getUsrId());  
	            	
	            	/**
	            	 * +++++++++++++ YE161010 INSERT 시작 +++++++++++++
	            	 * */
	            	ye161010Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));    					/** column 사업장코드 : dpobCd */
	            	ye161010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161010Dto.getYrtxBlggYr()));    			/** column 귀속연도 : yrtxBlggYr */
	            	ye161010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye161010Dto.getClutSeptCd()));    			/** column 연말정산구분코드 : clutSeptCd */
	            	ye161010Vo.setSystemkey(MSFSharedUtils.allowNulls(ye161010Dto.getSystemkey()));    				/** column SYSTEMKEY : systemkey */
	            	ye161010Vo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(ye161010Dto.getPayrMangDeptCd()));    	/** column 급여관리부서코드 : payrMangDeptCd */
	            	ye161010Vo.setEmymtDivCd(MSFSharedUtils.allowNulls(ye161010Dto.getEmymtDivCd()));    			/** column 당시_고용구분코드 : emymtDivCd */
	            	ye161010Vo.setDeptCd(MSFSharedUtils.allowNulls(ye161010Dto.getDeptCd()));    					/** column 당시_부서코드 : deptCd */
	            	ye161010Vo.setTypOccuCd(MSFSharedUtils.allowNulls(ye161010Dto.getTypOccuCd()));    				/** column 당시_직종코드 : typOccuCd */
	            	ye161010Vo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(ye161010Dto.getDtilOccuInttnCd()));    	/** column 당시_직종세통합코드 : dtilOccuInttnCd */
	            	ye161010Vo.setBusinCd(MSFSharedUtils.allowNulls(ye161010Dto.getBusinCd()));    					/** column 당시_사업코드 : businCd */ 
	            	ye161010Vo.setKybdr(sessionUser.getUsrId());    												/** column 입력자 : kybdr */
	            	ye161010Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 입력주소 : inptAddr */
	            	ye161010Vo.setIsmt(sessionUser.getUsrId());    													/** column 수정자 : ismt */
	            	ye161010Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 수정주소 : revnAddr */
	         
			   
	     	//    {******************************급여자료 이관*******************************************}
	             
	            	BeanUtils.copyProperties(infcPkgYe161010Vo, ye161010Vo); 
		            
					listYe161010VO.add(infcPkgYe161010Vo);

				}
		            
				if (listYe161010VO.size() > 0) {

					Yeta2100ListenerAdapter yetaLsAdtr = new Yeta2100ListenerAdapter();
 	
					// 컴포넌트 호출하기
					yetaLsAdtr.setUpDpopYeta_Insert(RemoteServiceUtil.getThreadLocalRequest(),listYe161010VO);
					 
				}
				retval = 1L;
				
			} catch (Exception ex) {
			
				logger.error("EXCEPTION calling UpDpobExec_Yeta_Insert_2017(): " + ex);
				
				/** 에러 로그 **/
				MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser, method,calledClass, "U", ex, windowNm, windowId);
			
				retval = 0L;
				throw MSFServerUtils.getOperationException("UpDpobExec_Yeta_Insert_2017", ex, logger);
			}
			
			/**
			 * 로그반영 CRUDSBLO C:create R:read U:update D:delete S:select B:배치 L:로그인
			 * O:로그아웃
			 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass,"U");

			return retval;

	}    
	
	

}
