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
package com.app.exterms.yearendtax.server.service.yeta2016;
 
 
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.utils.SmrmfUtils;
import org.msf.utils.TimingInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta1000DTO;
import com.app.exterms.yearendtax.client.service.yeta2016.YetaP110001Service;
import com.app.exterms.yearendtax.server.service.yeta2016.dao.Ye16Ta1000DAO;
import com.app.exterms.yearendtax.server.service.yeta2016.dao.Ye16Ta2000DAO;
import com.app.exterms.yearendtax.server.service.yeta2016.dao.Ye16Ta3000DAO;
import com.app.exterms.yearendtax.server.service.yeta2016.dao.Ye16Ta3100DAO;
import com.app.exterms.yearendtax.server.service.yeta2016.dao.Ye16Ta3110DAO;
import com.app.exterms.yearendtax.server.service.yeta2016.dao.Ye16Ta3120DAO;
import com.app.exterms.yearendtax.server.service.yeta2016.dao.Ye16Ta3130DAO;
import com.app.exterms.yearendtax.server.service.yeta2016.dao.Ye16Ta3140DAO;
import com.app.exterms.yearendtax.server.service.yeta2016.dao.Ye16Ta3150DAO;
import com.app.exterms.yearendtax.server.service.yeta2016.dao.Ye16Ta3160DAO;
import com.app.exterms.yearendtax.server.service.yeta2016.dao.Ye16Ta3170DAO;
import com.app.exterms.yearendtax.server.service.yeta2016.dao.Ye16Ta3180DAO;
import com.app.exterms.yearendtax.server.service.yeta2016.dao.Ye16Ta3190DAO;
import com.app.exterms.yearendtax.server.service.yeta2016.dao.Ye16Ta3220DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye160401DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye160402DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye160403DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye161010DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye161020DAO;
import com.app.exterms.yearendtax.server.vo.InfcPsnl0100SrhVO;
import com.app.exterms.yearendtax.server.vo.Ye160401VO;
import com.app.exterms.yearendtax.server.vo.Ye160402VO;
import com.app.exterms.yearendtax.server.vo.Ye160403VO;
import com.app.exterms.yearendtax.server.vo.Yeta1000VO;
import com.app.exterms.yearendtax.server.vo.Yeta2000VO;
import com.app.exterms.yearendtax.server.vo.Yeta3000VO;
import com.app.exterms.yearendtax.server.vo.Yeta3100VO;
import com.app.exterms.yearendtax.server.vo.Yeta3110VO;
import com.app.exterms.yearendtax.server.vo.Yeta3120VO;
import com.app.exterms.yearendtax.server.vo.Yeta3130VO;
import com.app.exterms.yearendtax.server.vo.Yeta3140VO;
import com.app.exterms.yearendtax.server.vo.Yeta3150VO;
import com.app.exterms.yearendtax.server.vo.Yeta3160VO;
import com.app.exterms.yearendtax.server.vo.Yeta3170VO;
import com.app.exterms.yearendtax.server.vo.Yeta3180VO;
import com.app.exterms.yearendtax.server.vo.Yeta3190VO;
import com.app.exterms.yearendtax.server.vo.Yeta3220VO;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnOrder;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.sysif.msfpackage.server.utils.SysifPkgServiceUtils;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta1000VO;
import com.app.smrmf.pkg.listener.yeta.yeta2016.Yeta1100ListenerAdapter;
import com.app.smrmf.sysm.server.service.vo.SysIfBass0350VO;
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
@Service("YetaP110001Service")
public class YetaP110001ServiceImpl  extends AbstractCustomServiceImpl implements YetaP110001Service  ,YetaDaoConstants {

	private static final Logger logger = LoggerFactory.getLogger(YetaP110001ServiceImpl.class);
	private static final String calledClass = YetaP110001ServiceImpl.class.getName();

//	@Autowired
//	@Resource(name = "Yeta1100DAO")
//	private Yeta1100DAO yeta1100DAO;
	
	// 연말정산 마감
	@Autowired
	@Resource(name = "Ye16Ta1000DAO")
	private Ye16Ta1000DAO ye16Ta1000DAO;
	
	// 연말정산 기본
	@Autowired
	@Resource(name = "Ye16Ta2000DAO")
	private Ye16Ta2000DAO ye16Ta2000DAO;
	
	// 연말정산
	@Autowired
	@Resource(name = "Ye16Ta3000DAO")
	private Ye16Ta3000DAO ye16Ta3000DAO;
	
	// 연금저축공제
	@Autowired
    @Resource(name="Ye16Ta3100DAO")
    private Ye16Ta3100DAO ye16Ta3100DAO; 
	  
	// 종전근무지
	@Autowired
    @Resource(name="Ye16Ta3110DAO")
    private Ye16Ta3110DAO ye16Ta3110DAO;  
	
	// 거주자주택자금_금전소비대차
	@Autowired
	@Resource(name = "Ye16Ta3120DAO")
	private Ye16Ta3120DAO ye16Ta3120DAO;

	// 주택자금_월세
	@Autowired
    @Resource(name="Ye16Ta3130DAO")
    private Ye16Ta3130DAO ye16Ta3130DAO;  
  
	// 의료비
	@Autowired
	@Resource(name = "Ye16Ta3140DAO")
	private Ye16Ta3140DAO ye16Ta3140DAO;
	
	
	// 교육비 가족사항
	@Autowired
	@Resource(name = "Ye16Ta3150DAO")
	private Ye16Ta3150DAO ye16Ta3150DAO; 
	
	//거주자주택자금_임대차
    @Autowired
    @Resource(name="Ye16Ta3160DAO")
    private Ye16Ta3160DAO ye16Ta3160DAO;  
    
    
    // 이월기부금
    @Autowired
    @Resource(name="Ye16Ta3170DAO")
    private Ye16Ta3170DAO ye16Ta3170DAO; 
    
    // 기부금
    @Autowired
    @Resource(name="Ye16Ta3180DAO")
    private Ye16Ta3180DAO ye16Ta3180DAO; 
    
    
    // 이월기부금
    @Autowired
    @Resource(name="Ye16Ta3190DAO")
    private Ye16Ta3190DAO ye16Ta3190DAO; 
    
    // 가족사항
    @Autowired
    @Resource(name="Ye16Ta3220DAO")
    private Ye16Ta3220DAO ye16Ta3220DAO; 
	
	
	
//	// 기부금 조정
//	@Autowired
//	@Resource(name = "Ye16Ta3190DAO")
//	private Ye16Ta3190DAO ye16Ta3190DAO;
//	
//	// 가족사항
//	@Autowired
//	@Resource(name = "Ye16Ta3220DAO")
//	private Ye16Ta3220DAO ye16Ta3220DAO;
	
	@Autowired
	@Resource(name = "Ye161010DAO")
	private Ye161010DAO ye161010DAO;
	
	@Autowired
	@Resource(name = "Ye161020DAO")
	private Ye161020DAO ye161020DAO;
	
	// 현근무지급여
	@Autowired
	@Resource(name = "Ye160401DAO")
	private Ye160401DAO ye160401DAO;
	
	// 현근무지과세
	@Autowired
	@Resource(name = "Ye160402DAO")
	private Ye160402DAO ye160402DAO;
	
	// 현근무지비과세
	@Autowired
	@Resource(name = "Ye160403DAO")
	private Ye160403DAO ye160403DAO;
	
	    
	/**
	 * 연말정산대상자조회
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	//조회
	public PagingLoadResult<BaseModel> getYetaP110001ToPsnl0100DataList(ServiceParameters serviceParameters) throws MSFException {
		
		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETAP110001_TO_PSNL0100_DATA_LIST;
		InfcPsnl0100SrhVO   psnl0100SrhVO = new InfcPsnl0100SrhVO();
//		Psnl0100VO      psnl0100VO = new Psnl0100VO();
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
		
	        
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
	      
		if  (MSFSharedUtils.paramNull(ye16Ta2000DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			ye16Ta2000DAO = (Ye16Ta2000DAO) wac.getBean("Ye16Ta2000DAO"); 
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
	     	psnl0100SrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
	       	psnl0100SrhVO.setClutYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutYr")));	// 정산년도
	      	psnl0100SrhVO.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));	// 정산구분 
	      	
	      	
	     	psnl0100SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
//	     	psnl0100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));		//단위기관코드
	     	
	     	psnl0100SrhVO.setUsrId(sessionUser.getUsrId());
            /******************************** 권한 ************************************************************************/
            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
            if ("FALSE".equals(chkDeptCd)) {
            	psnl0100SrhVO.setDeptCd(sessionUser.getDeptCd()); 
               listDeptCd.add(sessionUser.getDeptCd());
               psnl0100SrhVO.setDeptCdArr(listDeptCd);     //부서코드    
               psnl0100SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
            } else {
            	    
            	psnl0100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드   
                     if (psnl0100SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
                     	 listDeptCd = null; 
                     	psnl0100SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
                     	psnl0100SrhVO.setDeptCd("");  //부서코드
                     } else {
                    	 psnl0100SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                          psnl0100SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
                     } 
                  
            }
            
//            } else {
//            	
//            }
            
            psnl0100SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
            psnl0100SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));   
            
           /******************************** 권한 ************************************************************************/
	     	
	     	
	    	List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));  
	       	psnl0100SrhVO.setHdofcCodtnCdArr(listHdofcCodtnCd);     //부서코드 
	      	psnl0100SrhVO.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));			//재직코드
	     	
	     	
	     	psnl0100SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));      		//고용구분코드
	            
//	       	List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//	       	psnl0100SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
//	      	psnl0100SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));			//부서코드
	            
	       	List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
	      	psnl0100SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
	     	psnl0100SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  	//직종
	           
//	     	List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//	     	psnl0100SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
//	     	psnl0100SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
	             
	      	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
	      	psnl0100SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	     	psnl0100SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
	     	
	     	
	     	/************************과거 직종세에 해당하는 사람들 데이타 가져오기 **********************************************************/
//	      	SysIfBass0320VO  sysIfBass0320Vo = new SysIfBass0320VO();
//	     	 List<String> listTypCd = new ArrayList<String>(); 
//	     	 
//	     	sysIfBass0320Vo.setYmdGb("Y");
//	     	sysIfBass0320Vo.setStrDate(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutYr")));
//	     	sysIfBass0320Vo.setTypOccuCd(psnl0100SrhVO.getTypOccuCd());
//	     	sysIfBass0320Vo.setTypOccuCdArr(lstTypeOccuCd); 
//	     	
//	     	listTypCd = SysifPkgServiceUtils.funcArrBeforTypOccuCd(RemoteServiceUtil.getThreadLocalRequest(),sysIfBass0320Vo);
	     	
	     	SysIfBass0350VO  sysIfBass0350Vo = new SysIfBass0350VO();
	     //	 List<String> listTyInttnCd = new ArrayList<String>(); 
	     	sysIfBass0350Vo.setDpobCd(sessionUser.getDpobCd());
	     	sysIfBass0350Vo.setYmdGb("Y");
	     	sysIfBass0350Vo.setStrDate(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutYr")));
	     	sysIfBass0350Vo.setTypOccuCd(psnl0100SrhVO.getTypOccuCd());
	     	sysIfBass0350Vo.setTypOccuCdArr(lstTypeOccuCd);
	    	sysIfBass0350Vo.setDtilOccuInttnCd(psnl0100SrhVO.getDtilOccuInttnCd());
	     	sysIfBass0350Vo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	     	
	     	sysIfBass0350Vo = SysifPkgServiceUtils.getFuncBeforDtilOccuInttnCd(RemoteServiceUtil.getThreadLocalRequest(),sysIfBass0350Vo); 
	     
	     	psnl0100SrhVO.setTypOccuCdArr(sysIfBass0350Vo.getRtnTypOccuCdArr());  
	      	psnl0100SrhVO.setDtilOccuInttnCdArr(sysIfBass0350Vo.getRtnDtilOccuInttnCdArr());   
	     	
	     	/************************과거 직종세에 해당하는 사람들 데이타 가져오기 **********************************************************/
	     	
	    	psnl0100SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
	           
	       	psnl0100SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
	      	psnl0100SrhVO.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명 
	      	
	      	psnl0100SrhVO.setUsrId(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));		//User Id
	      	psnl0100SrhVO.setEmymtBgnnDt(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtBgnnDt")));
	      	psnl0100SrhVO.setEmymtEndDt(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtEndDt")));
	            
	      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 
		            	
				//Execute query that returns a single value
	        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	          	int iResultCnt = ye16Ta2000DAO.selectYetaP110001ListTotCnt(psnl0100SrhVO);  
	              
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
	     	psnl0100SrhVO.setPageSize(pagingValues.totalRecordCount);  
	            
	     	//Apply paging
	     	if (pagingValues.start > 0) {
	     		psnl0100SrhVO.setFirstIndex(pagingValues.start);
	     	}
	     	if (pagingValues.offsetLimit > 0) {
	     		psnl0100SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
	     	}
//
	     	//Execute query and convert to BaseModel list
	     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	     	@SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	     	List list = ye16Ta2000DAO.selectYetaP110001List(psnl0100SrhVO);
	            
			Iterator<Map<String, Object>> iter = list.iterator();
		            
			SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	           
	        
			while (iter.hasNext()) {
				

				// 1. 암호화 객체 생성
				String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			        
				
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
	            
			SmrmfUtils.endTiming(logger, millisBeginPsnl0100ToPsnl0250DataList, "getPsnl0100ToPsnl0250DataList");
	       
		} catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	
	
	/** 연말정산 대상자 생성  **/
	@Override
	public PagingLoadResult<ShowMessageBM> saveYetaP110001ToYeta1000(List<Ye16Ta1000DTO> listye16Ta1000Dto) throws  MSFException {
		
		String method = calledClass + ".saveYetaP110001ToYeta1000";
		
		String windowNm = "연말정산대상자검색";
		String windowId = "YETAP110001";
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		BigDecimal seqn = new BigDecimal(0);
		
 	   	PagingLoadResult<ShowMessageBM> retval = null;
 	   	List<InfcPkgYeta1000VO> listYetaPrc1000Vo = new ArrayList<InfcPkgYeta1000VO>();
 	   InfcPkgYeta1000VO yetaPrc1000Vo = new InfcPkgYeta1000VO();  //마감테이블 
		
		
		try{
			
            for(int iYetaCnt=0; iYetaCnt < listye16Ta1000Dto.size(); iYetaCnt++) {
            	

        		// 1. 암호화 객체 생성
        		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        		
        		
            	if(0L < Yeta1100_All_Delete(listye16Ta1000Dto)) {
            		
                	yetaPrc1000Vo = new InfcPkgYeta1000VO();  //마감테이블 
                    
                	Ye16Ta1000DTO ye16Ta1000Dto = new Ye16Ta1000DTO();  
                	ye16Ta1000Dto = listye16Ta1000Dto.get(iYetaCnt);  
                	
    	            /** 조건절 */
    		        yetaPrc1000Vo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
    		        yetaPrc1000Vo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
    		        yetaPrc1000Vo.setUsrId(sessionUser.getUsrId());   
    		     
    		        
    		        // ----- YETA1000 INSERT 를 위한 VO
    		        yetaPrc1000Vo.setSrhPayrMangDeptCd(ye16Ta1000Dto.getSrhPayrMangDeptCd());    	/** column 급여관리부서코드 : payrMangDeptCd */
    				yetaPrc1000Vo.setSrhEmymtDivCd(ye16Ta1000Dto.getSrhEmymtDivCd());    			/** column 고용구분코드 : emymtDivCd */
    				//yetaPrc2000Vo.setHanNm(yetaPrc1000Vo.getHanNm());    /** column 한글성명 : hanNm */
    				//yetaPrc2000Vo.setResnRegnNum(yetaPrc1000Vo.getResnRegnNum());    /** column 주민등록번호 : resnRegnNum */
    				yetaPrc1000Vo.setSrhDeptCd(ye16Ta1000Dto.getSrhDeptCd());    					/** column 부서코드 : deptCd */
    				yetaPrc1000Vo.setSrhBusinCd(ye16Ta1000Dto.getSrhBusinCd());    					/** column 사업코드 : businCd */
    				yetaPrc1000Vo.setSrhTypOccuCd(ye16Ta1000Dto.getSrhTypOccuCd());    				/** column 직종코드 : typOccuCd */
    				yetaPrc1000Vo.setSrhDtilOccuInttnCd(ye16Ta1000Dto.getSrhDtilOccuInttnCd());		/** column 직종세통합코드 : dtilOccuInttnCd */
    				yetaPrc1000Vo.setSrhDtilOccuClsDivCd(ye16Ta1000Dto.getDtilOccuClsDivCd());		/** column 직종세구분코드 : dtilOccuClsDivCd */
    				//yetaPrc2000Vo.setOdtyCd(yetaPrc1000Vo.getOdtyCd());    /** column 직책코드 : odtyCd */
    				//yetaPrc2000Vo.setPyspCd(yetaPrc1000Vo.getPyspCd());    /** column 호봉코드 : pyspCd */
//    				yetaPrc2000Vo.setPyspGrdeCd(yetaPrc1000Vo.getSrhPyspGrdeCd());    			/** column 호봉등급코드 : pyspGrdeCd */
    		        
    		        
    		        
    		        
    		    	yetaPrc1000Vo.setEdacRvyy(ye16Ta1000Dto.getEdacRvyy());    												/** column 연말정산귀속년도 : edacRvyy */
    		    	yetaPrc1000Vo.setSettGbcd(ye16Ta1000Dto.getSettGbcd());    												/** column 정산구분코드 : settGbcd */
    		    	yetaPrc1000Vo.setSystemkey(MSFSharedUtils.allowNulls(ye16Ta1000Dto.getSystemkey()));    				/** column SYSTEMKEY : systemkey */
    		    	yetaPrc1000Vo.setEdacSeilNum(new BigDecimal(ye16Ta1000Dto.getEdacSeilNum()));    						/** column 연말정산마감일련번호 : edacSeilNum */
    		    	yetaPrc1000Vo.setPayrMangDeptCd(ye16Ta1000Dto.getPayrMangDeptCd());    									/** column 급여관리부서코드 : payrMangDeptCd */
    		    	yetaPrc1000Vo.setDeptCd(ye16Ta1000Dto.getDeptCd());    													/** column 부서코드 : deptCd */
    		    	yetaPrc1000Vo.setTypOccuCd(MSFSharedUtils.allowNulls(ye16Ta1000Dto.getTypOccuCd()));    				/** column 직종코드 : typOccuCd */
    		    	yetaPrc1000Vo.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(ye16Ta1000Dto.getDtilOccuClsDivCd()));    	/** column 직종세구분코드 : dtilOccuClsDivCd */
    		    	yetaPrc1000Vo.setPyspGrdeCd(MSFSharedUtils.allowNulls(ye16Ta1000Dto.getPyspGrdeCd()));    				/** column 호봉등급코드 : pyspGrdeCd */
    		    	yetaPrc1000Vo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(ye16Ta1000Dto.getDtilOccuInttnCd()));    	/** column 직종세통합코드 : dtilOccuInttnCd */
    		    	yetaPrc1000Vo.setBusinCd(MSFSharedUtils.allowNulls(ye16Ta1000Dto.getBusinCd()));    					/** column 사업코드 : businCd */
    		    	yetaPrc1000Vo.setEmymtDivCd(MSFSharedUtils.allowNulls(ye16Ta1000Dto.getEmymtDivCd()));    				/** column 고용구분코드 : emymtDivCd */
    		    	yetaPrc1000Vo.setPernChrgEmpIdenNum(sessionUser.getUsrId());    										/** column 생성직원번호 : pernChrgEmpIdenNum */
    	            
    	            /******************************** 권한 ************************************************************************/

    	           // if (yetaPrc1000Vo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(ye16Ta1000Dto.getSrhDeptCd()))) { 
    	           //  	yetaPrc1000Vo.setDeptCd("");  //부서코드
                   //    }  
    	           //    yetaPrc1000Vo.setDeptCdAuth(MSFSharedUtils.allowNulls(ye16Ta1000Dto.getSrhDeptCd()).replace(",", ""));  //권한처리를위해 추가  
    	           //    yetaPrc1000Vo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(ye16Ta1000Dto.getSrhDtilOccuInttnCd()).replace(",", ""));      

    	            
    	           /******************************** 권한 ************************************************************************/

//    	            System.out.println("넘기는 시스템키 ? " + yetaPrc1000Vo.getSystemkey());
    		    	listYetaPrc1000Vo.add(yetaPrc1000Vo);
                }	
            }
            	
	    	Yeta1100ListenerAdapter yetaLsAdtr = new Yeta1100ListenerAdapter();
	    	//컴포넌트 호출하기 
	    	retval = yetaLsAdtr.setYetaPayr06420_All_Create(RemoteServiceUtil.getThreadLocalRequest(), listYetaPrc1000Vo);  
            
			
		}catch(Exception e){
			
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass, "C", e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
			
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "C");
		
		return retval;
		
	}
		
	
	   /**
	    * 
	    * <pre>
	    * 1. 개요 : 연말정산 생성시 삭제처리 하는 로직  
	    * 2. 처리내용 : 
	    * </pre>
	    * @Method Name : Payr06420_All_Delete
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
	    * @throws MSFException
	    */
	private  Long Yeta1100_All_Delete(List<Ye16Ta1000DTO> listye16Ta1000Dto) throws MSFException {
	    	
		String method = calledClass + ".Yeta1100_All_Delete";

		String windowNm = "연말정산대상자관리";
		String windowId = "YETA1100";

		Long retval = 1L;

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());


		Ye160401VO ye160401Vo = new Ye160401VO(); // 현근무지급여
		Ye160402VO ye160402Vo = new Ye160402VO(); // 과세
		Ye160403VO ye160403Vo = new Ye160403VO(); // 비과세
		
		Yeta1000VO yeta1000Vo = new Yeta1000VO(); // 마감테이블
		Yeta2000VO yeta2000Vo = new Yeta2000VO(); // 연말정산기본
		
		Yeta3000VO yeta3000Vo = new Yeta3000VO(); // 연말정산
		Yeta3100VO yeta3100Vo = new Yeta3100VO(); // 연금_저축공제
		Yeta3110VO yeta3110Vo = new Yeta3110VO(); // 종전근무지명세
		Yeta3120VO yeta3120Vo = new Yeta3120VO(); // 거주자주택자금_금전소비대차
		Yeta3130VO yeta3130Vo = new Yeta3130VO(); // 주택자금_월세
		Yeta3140VO yeta3140Vo = new Yeta3140VO(); // 의료비
		Yeta3150VO yeta3150Vo = new Yeta3150VO(); // 교육비
		Yeta3160VO yeta3160Vo = new Yeta3160VO(); // 거주자주택자금_임대차
		Yeta3170VO yeta3170Vo = new Yeta3170VO(); // 이월기부금명세
		Yeta3180VO yeta3180Vo = new Yeta3180VO(); // 기부금 명세
		Yeta3190VO yeta3190Vo = new Yeta3190VO(); // 기부금조정
		Yeta3220VO yeta3220Vo = new Yeta3220VO(); // 가족사항
		
		
     			
		BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);   	
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		System.out.println("삭제자 : " + sessionUser.getDeptNm() + "[" + sessionUser.getUsrNm() + "]");
			  
		try {
				  
			for(int i = 0; i < listye16Ta1000Dto.size(); i ++) {
				
				Ye16Ta1000DTO ye16Ta1000Dto = new Ye16Ta1000DTO();
				ye16Ta1000Dto = listye16Ta1000Dto.get(i);
				
				
				ye160401Vo = new Ye160401VO(); // 현근무지급여
				ye160402Vo = new Ye160402VO(); // 과세
				ye160403Vo = new Ye160403VO(); // 비과세
				
				
				yeta1000Vo = new Yeta1000VO(); // 마감테이블
				yeta2000Vo = new Yeta2000VO(); // 연말정산기본

				yeta1000Vo = new Yeta1000VO(); // 마감테이블
				yeta3000Vo = new Yeta3000VO(); // 연말정산
				yeta3100Vo = new Yeta3100VO(); // 연금_저축공제
				yeta3110Vo = new Yeta3110VO(); // 종전근무지명세
				yeta3120Vo = new Yeta3120VO(); // 거주자주택자금_금전소비대차
				yeta3130Vo = new Yeta3130VO(); // 주택자금_월세
				yeta3140Vo = new Yeta3140VO(); // 의료비
				yeta3150Vo = new Yeta3150VO(); // 교육비
				yeta3160Vo = new Yeta3160VO(); // 거주자주택자금_임대차
				yeta3170Vo = new Yeta3170VO(); // 이월기부금명세
				yeta3180Vo = new Yeta3180VO(); // 기부금 명세
				yeta3190Vo = new Yeta3190VO(); // 기부금조정
				yeta3220Vo = new Yeta3220VO(); // 가족사항
				
				  

				// YETA1000
				yeta1000Vo.setDpobCd(ye16Ta1000Dto.getDpobCd());    	/** column null : dpobCd */
				yeta1000Vo.setEdacRvyy(ye16Ta1000Dto.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
				yeta1000Vo.setSettGbcd(ye16Ta1000Dto.getSettGbcd());    /** column 정산구분코드 : settGbcd */
				
				
				// YETA2000
				yeta2000Vo.setDpobCd(ye16Ta1000Dto.getDpobCd());    	/** column null : dpobCd */
				yeta2000Vo.setEdacRvyy(ye16Ta1000Dto.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
				yeta2000Vo.setSettGbcd(ye16Ta1000Dto.getSettGbcd());    /** column 정산구분코드 : settGbcd */	
				yeta2000Vo.setSystemkey(ye16Ta1000Dto.getSystemkey());	/** column SYSTEMKEY : systemkey */
				
				
				
				BeanUtils.copyProperties(yeta3000Vo, yeta2000Vo);
				BeanUtils.copyProperties(yeta3100Vo, yeta2000Vo);
				BeanUtils.copyProperties(yeta3110Vo, yeta2000Vo);
				BeanUtils.copyProperties(yeta3120Vo, yeta2000Vo);
				BeanUtils.copyProperties(yeta3130Vo, yeta2000Vo);
				BeanUtils.copyProperties(yeta3140Vo, yeta2000Vo);
				BeanUtils.copyProperties(yeta3150Vo, yeta2000Vo);
				BeanUtils.copyProperties(yeta3160Vo, yeta2000Vo);
				BeanUtils.copyProperties(yeta3170Vo, yeta2000Vo);
				BeanUtils.copyProperties(yeta3180Vo, yeta2000Vo);
				BeanUtils.copyProperties(yeta3190Vo, yeta2000Vo);
				BeanUtils.copyProperties(yeta3220Vo, yeta2000Vo);
			
				
//				// YETA3000
//				yeta3000Vo.setDpobCd(ye16Ta1000Dto.getDpobCd());    	/** column null : dpobCd */
//				yeta3000Vo.setEdacRvyy(ye16Ta1000Dto.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
//				yeta3000Vo.setSettGbcd(ye16Ta1000Dto.getSettGbcd());    /** column 정산구분코드 : settGbcd */	
//				yeta3000Vo.setSystemkey(ye16Ta1000Dto.getSystemkey());	/** column SYSTEMKEY : systemkey */
//				
//				
//				// YETA3190
//				yeta3190Vo.setDpobCd(ye16Ta1000Dto.getDpobCd());    	/** column null : dpobCd */
//				yeta3190Vo.setEdacRvyy(ye16Ta1000Dto.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
//				yeta3190Vo.setSettGbcd(ye16Ta1000Dto.getSettGbcd());    /** column 정산구분코드 : settGbcd */	
//				yeta3190Vo.setSystemkey(ye16Ta1000Dto.getSystemkey());	/** column SYSTEMKEY : systemkey */
//				
//				// YETA3290
//				yeta3220Vo.setDpobCd(ye16Ta1000Dto.getDpobCd());    	/** column null : dpobCd */
//				yeta3220Vo.setEdacRvyy(ye16Ta1000Dto.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
//				yeta3220Vo.setSettGbcd(ye16Ta1000Dto.getSettGbcd());    /** column 정산구분코드 : settGbcd */	
//				yeta3220Vo.setSystemkey(ye16Ta1000Dto.getSystemkey());	/** column SYSTEMKEY : systemkey */
				
				
				// YE160401
				ye160401Vo.setDpobCd(ye16Ta1000Dto.getDpobCd());    	/** column null : dpobCd */
				ye160401Vo.setYrtxBlggYr(ye16Ta1000Dto.getEdacRvyy());  /** column 연말정산귀속년도 : edacRvyy */
				ye160401Vo.setClutSeptCd(ye16Ta1000Dto.getSettGbcd());	/** column 정산구분코드 : settGbcd */	
				ye160401Vo.setSystemkey(ye16Ta1000Dto.getSystemkey());	/** column SYSTEMKEY : systemkey */
				
				
				// YE160402
				ye160402Vo.setDpobCd(ye16Ta1000Dto.getDpobCd());    	/** column null : dpobCd */
				ye160402Vo.setYrtxBlggYr(ye16Ta1000Dto.getEdacRvyy());  /** column 연말정산귀속년도 : edacRvyy */
				ye160402Vo.setClutSeptCd(ye16Ta1000Dto.getSettGbcd());	/** column 정산구분코드 : settGbcd */	
				ye160402Vo.setSystemkey(ye16Ta1000Dto.getSystemkey());	/** column SYSTEMKEY : systemkey */
				
				
				// YE160403
				ye160403Vo.setDpobCd(ye16Ta1000Dto.getDpobCd());    	/** column null : dpobCd */
				ye160403Vo.setYrtxBlggYr(ye16Ta1000Dto.getEdacRvyy());  /** column 연말정산귀속년도 : edacRvyy */
				ye160403Vo.setClutSeptCd(ye16Ta1000Dto.getSettGbcd());	/** column 정산구분코드 : settGbcd */	
				ye160403Vo.setSystemkey(ye16Ta1000Dto.getSystemkey());	/** column SYSTEMKEY : systemkey */
				
				
				
				// {현근무지비과세_감면소득_비과세 삭제} 
				ye160403DAO.deleteYetaP110001_Ye160403_2016_CREATE_Delete(ye160403Vo);	//	YE160403  현근무지비과세 
				
				// {현근무지비과세_감면소득_과세 삭제} 
				ye160402DAO.deleteYetaP110001_Ye160402_2016_CREATE_Delete(ye160402Vo);	//	YE160402  현근무지과세 
				
				// {현근무지급여 삭제} 
				ye160401DAO.deleteYetaP110001_Ye160401_2016_CREATE_Delete(ye160401Vo);	//	YE160401  현근무지급여 
				
				
				//	{연금_저축공제 삭제}
				ye16Ta3100DAO.fnYeta1100_YETA3100_2016_CREATE_Delete(yeta3100Vo);	//yeta3100  연금_저축공제
	                   
				//	{종전근무지삭제}
				ye16Ta3110DAO.fnYeta1100_YETA3110_2016_CREATE_Delete(yeta3110Vo);	//yeta3110  종전근무지명세   
				
				//	{거주자주택자금_금전소비대차 삭제} 
				ye16Ta3120DAO.fnYeta1100_YETA3120_2016_CREATE_Delete(yeta3120Vo);	//yeta3120  거주자주택자금_금전소비대차
				
				//	{주택자금_월세 삭제}
				ye16Ta3130DAO.fnYeta1100_YETA3130_2016_CREATE_Delete(yeta3130Vo);	//yeta3130  주택자금_월세

				//	{의료비삭제} 
				ye16Ta3140DAO.fnYeta1100_YETA3140_2016_CREATE_Delete(yeta3140Vo);	//yeta3140 
				

			  	//	{교육비가족사항삭제}
				ye16Ta3150DAO.fnYeta1100_YETA3150_2016_CREATE_Delete(yeta3150Vo);	//yeta3150 교육사항  
			             
				//	{거주자주택자금_임대차 삭제}
			  	ye16Ta3160DAO.fnYeta1100_YETA3160_2016_CREATE_Delete(yeta3160Vo);	//yeta3160  거주자주택자금_임대차 
			           
				//	{이월기부금삭제}  
				ye16Ta3170DAO.fnYeta1100_YETA3170_2016_CREATE_Delete(yeta3170Vo);	//yeta3170 이월기부금삭제  
			  	
				//	{기부금삭제}
			  	ye16Ta3180DAO.fnYeta1100_YETA3180_2016_CREATE_Delete(yeta3180Vo);	//yeta3180 기부금명세  
			             
				//	{이월기부금삭제}
			  	ye16Ta3190DAO.fnYeta1100_YETA3190_2016_CREATE_Delete(yeta3190Vo);	//yeta3190 이월기부금삭제  

			  	//	{가족사항삭제}
			  	ye16Ta3220DAO.fnYeta1100_YETA3220_2016_CREATE_Delete(yeta3220Vo);	//yeta3220 가족사항   
	  
			  	// 	{연말정산상세삭제}
			  	ye16Ta3000DAO.fnYeta1100_YETA3000_2016_CREATE_Delete(yeta3000Vo);	//yeta3000    
		  
			  	//	{연말정산기본삭제}
			  	ye16Ta2000DAO.fnYeta1100_YETA2000_2016_CREATE_Delete(yeta2000Vo);	//yeta2000  연말정산기본  
			  	
			  	// {연말정산마감 삭제}
			  	// YETA2000번에 존재하지 않는 마감 일련번호만 삭제한다.
			  	ye16Ta1000DAO.fnYeta1100_YETA1000_2016_CREATE_Delete(yeta1000Vo);
				
			  	retval = 1L;
				
			}

		} catch (Exception ex) {

			logger.error("EXCEPTION calling Yeta1100_All_Delete(): " + ex);

			/** 에러 로그 **/
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser, method,calledClass, "D", ex, windowNm, windowId);

			retval = 0L;
			throw MSFServerUtils.getOperationException("Yeta1100_All_Delete", ex, logger);
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

}
