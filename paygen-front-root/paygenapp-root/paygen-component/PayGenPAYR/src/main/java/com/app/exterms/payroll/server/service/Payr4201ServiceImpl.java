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
package com.app.exterms.payroll.server.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.utils.SmrmfUtils;
import org.msf.utils.TimingInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.any.smrmf.utils.BeanFinder;
import com.app.exterms.diligence.client.dto.InfcPkgDlgn0250DTO;
import com.app.exterms.payroll.client.dto.InfcPkgPayr0304DTO;
import com.app.exterms.payroll.client.dto.Payr0250DTO;
import com.app.exterms.payroll.client.dto.Payr0302DTO;
import com.app.exterms.payroll.client.dto.Payr0304DTO;
import com.app.exterms.payroll.client.dto.Payr0307DTO;
import com.app.exterms.payroll.client.dto.Payr0470DTO;
/*import com.app.exterms.payroll.client.service.Payr4200Service;*/
import com.app.exterms.payroll.client.service.Payr4201Service; //4201 추가 6.17 -"30"
import com.app.exterms.payroll.server.service.dao.Payr0250DAO;
import com.app.exterms.payroll.server.service.dao.Payr0300DAO;
import com.app.exterms.payroll.server.service.dao.Payr0301DAO;
import com.app.exterms.payroll.server.service.dao.Payr0302DAO;
import com.app.exterms.payroll.server.service.dao.Payr0304DAO;
import com.app.exterms.payroll.server.service.dao.Payr0305DAO;
import com.app.exterms.payroll.server.service.dao.Payr0306DAO;
import com.app.exterms.payroll.server.service.dao.Payr0307DAO;
import com.app.exterms.payroll.server.service.dao.Payr0309DAO;
import com.app.exterms.payroll.server.service.dao.Payr0470DAO;
import com.app.exterms.payroll.server.vo.Payr0250SrhVO;
import com.app.exterms.payroll.server.vo.Payr0250VO;
import com.app.exterms.payroll.server.vo.Payr0300VO;
import com.app.exterms.payroll.server.vo.Payr0301SrhVO;
import com.app.exterms.payroll.server.vo.Payr0301VO;
import com.app.exterms.payroll.server.vo.Payr0302SrhVO;
import com.app.exterms.payroll.server.vo.Payr0302VO;
import com.app.exterms.payroll.server.vo.Payr0304SrhVO;
import com.app.exterms.payroll.server.vo.Payr0304VO;
import com.app.exterms.payroll.server.vo.Payr0305VO;
import com.app.exterms.payroll.server.vo.Payr0306VO;
import com.app.exterms.payroll.server.vo.Payr0307SrhVO;
import com.app.exterms.payroll.server.vo.Payr0307VO;
import com.app.exterms.payroll.server.vo.Payr0309VO;
import com.app.exterms.payroll.server.vo.Payr0470SrhVO;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnOrder;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFErrorMessage;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.diligence.server.service.dao.InfcPkgDlgn0100DAO;
import com.app.smrmf.infc.diligence.server.vo.InfcPkgDlgn0250VO;
import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr3300VO;
import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr4200VO;
import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr5200VO;
import com.app.smrmf.infc.payroll.server.service.dao.InfcPkgPayr0485DAO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0302VO;
import com.app.smrmf.pkg.insr.insurance.service.PkgInsrAmntVO;
import com.app.smrmf.pkg.insr.insurance.service.PkgInsrService;
import com.app.smrmf.pkg.listener.PayrListenerAdapter;
import com.app.smrmf.props.ExtermsProps;
import com.ext.constants.PropPayGenConfs;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

import egovframework.rte.psl.dataaccess.util.EgovMap;

@Service("Payr4201Service")
public class Payr4201ServiceImpl extends AbstractCustomServiceImpl implements Payr4201Service  ,PayrDaoConstants {

	private static final Logger logger = LoggerFactory.getLogger(Payr4201ServiceImpl.class);
	private static final String calledClass = Payr4201ServiceImpl.class.getName();
	 

	@Autowired
    @Resource(name="Payr0300DAO")
    private Payr0300DAO payr0300DAO;
	
	
   //우측급여상세정보 단건 가져오기 
	@Autowired
    @Resource(name="Payr0301DAO")
    private Payr0301DAO payr0301DAO;
	
    //급여대상자 가져오기 
	@Autowired
    @Resource(name="Payr0304DAO")
    private Payr0304DAO payr0304DAO;
    
	@Autowired
    @Resource(name="Payr0305DAO")
    private Payr0305DAO payr0305DAO; 
	
	//가족사항 정보 
	@Autowired
    @Resource(name="Payr0306DAO")
    private Payr0306DAO payr0306DAO; 
	
	//4대보험 처리 	
	@Autowired
    @Resource(name="Payr0309DAO")
    private Payr0309DAO payr0309DAO; 
	
	//지급공제	
	@Autowired
    @Resource(name="Payr0470DAO")
    private Payr0470DAO payr0470DAO; 
	
	//지급공제	
	@Autowired
    @Resource(name="InfcPkgDlgn0100DAO")
    private InfcPkgDlgn0100DAO infcPkgDlgn0100Dao; 
	
    /** ID Generation */
    //@Resource(name="{egovPayr0304IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;
	
	
//급여 수당공제이력정보 
	@Autowired
    @Resource(name="Payr0302DAO")
    private Payr0302DAO payr0302DAO;
	
	
	//급여조정내역 
	@Autowired
    @Resource(name="Payr0307DAO")
    private Payr0307DAO payr0307DAO;
    
	 
	@Autowired
	@Resource(name = "InfcPkgPayr0485DAO")
	private InfcPkgPayr0485DAO payr0485DAO; 
	  
	
	  //4대 사회보험 패키지  
    @Autowired
    @Resource(name = "PkgInsrService")
    protected PkgInsrService pkgInsrService; 
    
    
    
    
    
    
    //일괄정리 추가8 6.19 -"127"
    //일괄정리 주석처리 6.22 -"130"
    /*public PagingLoadResult<BaseModel> getPayr0304ToPayr4201DelDataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_PAYR0304TOPAYR4201_DATA_LIST;
        Payr0304SrhVO   payr0304SrhVO = new Payr0304SrhVO();
        Payr0304VO      payr0304VO = new Payr0304VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
       
        try {
        	
        	payr0304DAO = (Payr0304DAO)BeanFinder.getBean("Payr0304DAO");
        	
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
           // Sysm0250BM          user             = serviceParameters.getUser();
            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
            //String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
            List<String> listDeptCd = new ArrayList<String>();
            //** 조건절 *//*
            
            // 조건절 추가 6.18 -"71"
            payr0304SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드 ㅇ
            payr0304SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
            payr0304SrhVO.setUsrId(sessionUser.getUsrId()); //유저아이디
            payr0304SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
            
            
            
            
            //******************************** 권한 ************************************************************************//*
            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03(); 
            
            if ("FALSE".equals(chkDeptCd )) { 
            	 
            	 if (sessionUser.getDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) {
            		 payr0304SrhVO.setDeptCd(sessionUser.getDeptCd());
            		 listDeptCd.add(sessionUser.getDeptCd());
                     payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드   ㅇ
                     
            	 } else {
            		 
            		 payr0304SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
            		 listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                     payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
                     
            	 }  
                 payr0304SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
               
              
            } else {
            	    
            	     payr0304SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드 ㅇ
                     if (payr0304SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
                     	 listDeptCd = null; 
                     	 payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
                     	 payr0304SrhVO.setDeptCd("");  //부서코드
                     } else {
                    	  payr0304SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                          payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
                     } 
                  
            }
           

            payr0304SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
            payr0304SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));    
           //******************************** 권한 ************************************************************************//*
            
//              if (payr0304SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) {
//            	payr0304SrhVO.setPayrMangDeptYn("Y");  //단위기관담당자여부 
//            	List<String> listDeptCd = null; 
//            	payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
//            	payr0304SrhVO.setDeptCd("");     //부서코드
//            } else {
//
//                List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//                payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드  
//                payr0304SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드 
//            }
            
            payr0304SrhVO.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명  ㅇ
            payr0304SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드 ㅇ
            
            
            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
            payr0304SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
            payr0304SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종 ㅇ
           
            
            //주석 6.18 -"72"
          //확인위해 주석처리함 6.18 -"86"
            List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
            payr0304SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
            payr0304SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드 ㅇ
            
             
            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
            payr0304SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
            payr0304SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세통합코드 ㅇ
            
            
            payr0304SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키 ㅇ
            
            //추가 6.18 -"74"
            
            //확인위해 주석처리함 6.18 -"84"
            payr0304SrhVO.setPymtDducDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtDducDivCd")));   //지급공제구분 ㅇ  
            payr0304SrhVO.setPayItemCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payItemCd")));   //지급공제항목 ->def에서는 급여항목코드
            
            
            //주석처리 6.18 -"73"
          //확인위해 주석처리함 6.18 -"85"
            payr0304SrhVO.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters,"mangeDeptCd")));    //관리부서 
            payr0304SrhVO.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "repbtyBusinDivCd")) ); //호봉제구분
            
            
           
            
          //검색조건값들 추가 6.19 -"88"
            payr0304SrhVO.setPymtYrMnth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtYrMnth"))); // 지급년월
            payr0304SrhVO.setPayCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payCd")));  			// 급여구분코드
            //단위기관은 권한부분에 있음
            payr0304SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd"))); //고용구분코드
            payr0304SrhVO.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "repbtyBusinDivCd")) ); //호봉제구분
            payr0304SrhVO.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters,"mangeDeptCd")));    //관리부서
            //부서는 권한부분에 있음
            //주석처리해봄 6.19 -"90"
            List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
            payr0304SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
            payr0304SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //그룹 
            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
            payr0304SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
            payr0304SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종 
            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
            payr0304SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
            payr0304SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세통합코드
            payr0304SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드 
            payr0304SrhVO.setPymtDducDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtDducDivCd")));   //지급공제구분
            payr0304SrhVO.setPayItemCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payItemCd")));   //지급공제항목 ->def에서는 급여항목코드
            
            
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
//	         if ( pagingValues.executeRecordCount ) { 
//	            	
//                //Execute query that returns a single value
//                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
//                 
//                int iResultCnt = payr0304DAO.selectPayr0304ToPayr4200ListTotCnt(payr0304SrhVO);  
//              
//                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
//                pagingValues.totalRecordCount = iResultCnt;	       
//                
//                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
//            }
            
            
			if ( pagingValues.executeRecordCount ) { 
            	
				//Execute query that returns a single value
	        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	          	int iResultCnt = payr0304DAO.selectPayr0304ToPayr4201ListTotCnt(payr0304SrhVO);  
	              
	          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
	          	
	          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                
	         	pagingValues.totalRecordCount = iResultCnt;	       
	                
	        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
        
            TimingInfo millisBeginPayr0304ToPayr4200DataList = SmrmfUtils.startTiming(logger);
        
            //**페이지 카운트 처리를 위한 부분 *//* 
            payr0304SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	payr0304SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	payr0304SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = payr0304DAO.deletePayr0304ToPayr4201List(payr0304SrhVO);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
        
            while ( iter.hasNext() ) {
            	
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
                       
                   	//3. 복호화
                	case ColumnDef.TYPE_STRING: 
                	          			          			
                		String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));

                		String rrnDecCrypt = "";
                   			
                		if(	"resnRegnNum".equals(tableAttributes[i].getName())) {
                	          			
                	          			
                			// 주민번호(복호화) ㅇ
                			rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
                	          		
                			strValue = rrnDecCrypt;
                						
                		}else if("payFamyResnRegnNum".equals(tableAttributes[i].getName())) {

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
                  	
                    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                	
                    Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
                            map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
                
//                    switch ( tableAttributes[i].getType() ) {  
//                    case ColumnDef.TYPE_BIGDECIMAL: 
//                    	if (baseModelValue == null) {
//                    		baseModelValue = BigDecimal.ZERO;
//                    	}
//                        break; 
//                    }
                    
                    bm.set(tableAttributes[i].getName(), baseModelValue);
                }

                bm.set(TableDef.ID_PROPERTY_NAME, idValue);
                bmResult.add(bm);
            } 

            retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
            
            SmrmfUtils.endTiming(logger, millisBeginPayr0304ToPayr4200DataList, "getPayr0304ToPayr4200DataList");
       

        }
        catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }*/
    
    
    
    
    
    
    
    
    //새롭게 급여내역조회를 만듬, 근로자급여정보쪽 참고 6.18 -"65"
    //standalone 실행 실패 이유찾기위해 주석 6.18 -"80"
    public PagingLoadResult<BaseModel> getPayr0304ToPayr4201DataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_PAYR0304TOPAYR4201_DATA_LIST;
        Payr0304SrhVO   payr0304SrhVO = new Payr0304SrhVO();
        Payr0304VO      payr0304VO = new Payr0304VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
       
        try {
        	
        	payr0304DAO = (Payr0304DAO)BeanFinder.getBean("Payr0304DAO");
        	
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
           // Sysm0250BM          user             = serviceParameters.getUser();
            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
            //String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
            List<String> listDeptCd = new ArrayList<String>();
            //** 조건절 *//*
            
            // 조건절 추가 6.18 -"71"
            payr0304SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드 ㅇ
            payr0304SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
            payr0304SrhVO.setUsrId(sessionUser.getUsrId()); //유저아이디
            payr0304SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
            
            
            
            
            //******************************** 권한 ************************************************************************//*
            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03(); 
            
            if ("FALSE".equals(chkDeptCd )) { 
            	 
            	 if (sessionUser.getDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) {
            		 payr0304SrhVO.setDeptCd(sessionUser.getDeptCd());
            		 listDeptCd.add(sessionUser.getDeptCd());
                     payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드   ㅇ
                     
            	 } else {
            		 
            		 payr0304SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
            		 listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                     payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
                     
            	 }  
                 payr0304SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
               
              
            } else {
            	    
            	     payr0304SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드 ㅇ
                     if (payr0304SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
                     	 listDeptCd = null; 
                     	 payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
                     	 payr0304SrhVO.setDeptCd("");  //부서코드
                     } else {
                    	  payr0304SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                          payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
                     } 
                  
            }
           

            payr0304SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
            payr0304SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));    
           //******************************** 권한 ************************************************************************//*
            
            
          //검색조건값들 추가 6.19 -"88"
            payr0304SrhVO.setPymtYrMnth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtYrMnth"))); // 지급년월
            payr0304SrhVO.setPayCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payCd")));  			// 급여구분코드
            //단위기관은 권한부분에 있음
            payr0304SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd"))); //고용구분코드
            payr0304SrhVO.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "repbtyBusinDivCd")) ); //호봉제구분
            payr0304SrhVO.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters,"mangeDeptCd")));    //관리부서
            //부서는 권한부분에 있음
            //주석처리해봄 6.19 -"90"
            /*List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
            payr0304SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
            payr0304SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //그룹 
*/            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
            payr0304SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
            payr0304SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종 
            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
            payr0304SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
            payr0304SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세통합코드
            payr0304SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드 
            payr0304SrhVO.setPymtDducDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtDducDivCd")));   //지급공제구분
            payr0304SrhVO.setPayItemCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payItemCd")));   //지급공제항목 ->def에서는 급여항목코드
            
            
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
//	         if ( pagingValues.executeRecordCount ) { 
//	            	
//                //Execute query that returns a single value
//                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
//                 
//                int iResultCnt = payr0304DAO.selectPayr0304ToPayr4200ListTotCnt(payr0304SrhVO);  
//              
//                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
//                pagingValues.totalRecordCount = iResultCnt;	       
//                
//                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
//            }
            
			if ( pagingValues.executeRecordCount ) { 
            	
				//Execute query that returns a single value
	        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	          	int iResultCnt = payr0304DAO.selectPayr0304ToPayr4201ListTotCnt(payr0304SrhVO);  
	              
	          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
	          	
	          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                
	         	pagingValues.totalRecordCount = iResultCnt;	       
	                
	        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
        
            TimingInfo millisBeginPayr0304ToPayr4200DataList = SmrmfUtils.startTiming(logger);
        
            //**페이지 카운트 처리를 위한 부분 *//* 
            payr0304SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	payr0304SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	payr0304SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = payr0304DAO.selectPayr0304ToPayr4201List(payr0304SrhVO);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
        
            while ( iter.hasNext() ) {
            	
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
                       
                   	//3. 복호화
                	case ColumnDef.TYPE_STRING: 
                	          			          			
                		String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));

                		String rrnDecCrypt = "";
                   			
                		if(	"resnRegnNum".equals(tableAttributes[i].getName())) {
                	          			
                	          			
                			// 주민번호(복호화) ㅇ
                			rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
                	          		
                			strValue = rrnDecCrypt;
                						
                		}else if("payFamyResnRegnNum".equals(tableAttributes[i].getName())) {

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
                  	
                    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                	
                    Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
                            map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
                
//                    switch ( tableAttributes[i].getType() ) {  
//                    case ColumnDef.TYPE_BIGDECIMAL: 
//                    	if (baseModelValue == null) {
//                    		baseModelValue = BigDecimal.ZERO;
//                    	}
//                        break; 
//                    }
                    
                    bm.set(tableAttributes[i].getName(), baseModelValue);
                }

                bm.set(TableDef.ID_PROPERTY_NAME, idValue);
                bmResult.add(bm);
            } 

            retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
            
            SmrmfUtils.endTiming(logger, millisBeginPayr0304ToPayr4200DataList, "getPayr0304ToPayr4200DataList");
       

        }
        catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
    
    
    
    
    

	public PagingLoadResult<BaseModel> getPayr0304ToPayr4200DataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_PAYR0304TOPAYR4200_DATA_LIST;
        Payr0304SrhVO   payr0304SrhVO = new Payr0304SrhVO();
        Payr0304VO      payr0304VO = new Payr0304VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
       
        try {
        	
        	payr0304DAO = (Payr0304DAO)BeanFinder.getBean("Payr0304DAO");
        	
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
           // Sysm0250BM          user             = serviceParameters.getUser();
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
            payr0304SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드
            payr0304SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
           
            payr0304SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
            
            payr0304SrhVO.setUsrId(sessionUser.getUsrId()); 
            /******************************** 권한 ************************************************************************/
            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03(); 
            
            if ("FALSE".equals(chkDeptCd )) { 
            	 
            	 if (sessionUser.getDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) {
            		 payr0304SrhVO.setDeptCd(sessionUser.getDeptCd());
            		 listDeptCd.add(sessionUser.getDeptCd());
                     payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
                     
            	 } else {
            		 
            		 payr0304SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
            		 listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                     payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
                     
            	 }  
                 payr0304SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
               
              
            } else {
            	    
            	     payr0304SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드
                     if (payr0304SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
                     	 listDeptCd = null; 
                     	 payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
                     	 payr0304SrhVO.setDeptCd("");  //부서코드
                     } else {
                    	  payr0304SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                          payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
                     } 
                  
            }
           

            payr0304SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
            payr0304SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));    
           /******************************** 권한 ************************************************************************/
            
//              if (payr0304SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) {
//            	payr0304SrhVO.setPayrMangDeptYn("Y");  //단위기관담당자여부 
//            	List<String> listDeptCd = null; 
//            	payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
//            	payr0304SrhVO.setDeptCd("");     //부서코드
//            } else {
//
//                List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//                payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드  
//                payr0304SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드 
//            }
            
            
            
            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
            payr0304SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
            payr0304SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
           
//            List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//            payr0304SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
//            payr0304SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
             
            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
            payr0304SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
            payr0304SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
            
            payr0304SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드 
            
            payr0304SrhVO.setPayCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payCd")));  //급여구분코드 
            payr0304SrhVO.setPymtYrMnth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtYrMnth"))); //지급년월
            payr0304SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
            payr0304SrhVO.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명 
            
            payr0304SrhVO.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters,"mangeDeptCd")));    //관리부서 
            payr0304SrhVO.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "repbtyBusinDivCd")) ); //호봉제구분
            
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
//	         if ( pagingValues.executeRecordCount ) { 
//	            	
//                //Execute query that returns a single value
//                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
//                 
//                int iResultCnt = payr0304DAO.selectPayr0304ToPayr4200ListTotCnt(payr0304SrhVO);  
//              
//                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
//                pagingValues.totalRecordCount = iResultCnt;	       
//                
//                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
//            }
            
			if ( pagingValues.executeRecordCount ) { 
            	
				//Execute query that returns a single value
	        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	          	int iResultCnt = payr0304DAO.selectPayr0304ToPayr4200ListTotCnt(payr0304SrhVO);  
	              
	          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
	          	
	          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                
	         	pagingValues.totalRecordCount = iResultCnt;	       
	                
	        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
        
            TimingInfo millisBeginPayr0304ToPayr4200DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            payr0304SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	payr0304SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	payr0304SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = payr0304DAO.selectPayr0304ToPayr4200List(payr0304SrhVO);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
        
            while ( iter.hasNext() ) {
            	
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
                  	
                    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                	
                    Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
                            map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
                
//                    switch ( tableAttributes[i].getType() ) {  
//                    case ColumnDef.TYPE_BIGDECIMAL: 
//                    	if (baseModelValue == null) {
//                    		baseModelValue = BigDecimal.ZERO;
//                    	}
//                        break; 
//                    }
                    
                    bm.set(tableAttributes[i].getName(), baseModelValue);
                }

                bm.set(TableDef.ID_PROPERTY_NAME, idValue);
                bmResult.add(bm);
            } 

            retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
            
            SmrmfUtils.endTiming(logger, millisBeginPayr0304ToPayr4200DataList, "getPayr0304ToPayr4200DataList");
       

        }
        catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }  
	
	
	
	
	
	

	//수당 
	public PagingLoadResult<BaseModel> getPayr0302ExtpyDataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_PAYR0302_EXTPY_DATA_LIST;
        Payr0302SrhVO   payr0302SrhVO = new Payr0302SrhVO();
        Payr0302VO      payr0302VO = new Payr0302VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
      
        
        try {
        	
        	payr0302DAO = (Payr0302DAO)BeanFinder.getBean("Payr0302DAO");
        	
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
            payr0302SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드
            payr0302SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));
            payr0302SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드
            payr0302SrhVO.setPayCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payCd")));  //급여구분코드 
            payr0302SrhVO.setPymtYrMnth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtYrMnth"))); //지급년 
            payr0302SrhVO.setPayrSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "payrSeilNum"),"0"))); //급여일련번호 
            //payr0302SrhVO.setPymtDducDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtDducDivCd")));
             //본봉수당 B0080010, 'B0080020' 공제 = B0080030,B0080040
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
//	         if ( pagingValues.executeRecordCount ) { 
//	            	
//                //Execute query that returns a single value
//                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
//                 
//                int iResultCnt = payr0302DAO.selectPayr0302ExtpyListTotCnt(payr0302SrhVO);  
//              
//                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
//                pagingValues.totalRecordCount = iResultCnt;	       
//                
//                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
//            }
            
			if ( pagingValues.executeRecordCount ) { 
            	
				//Execute query that returns a single value
	        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	        	int iResultCnt = payr0302DAO.selectPayr0302ExtpyListTotCnt(payr0302SrhVO);  
	              
	          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
	          	
	          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                
	         	pagingValues.totalRecordCount = iResultCnt;	       
	                
	        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
        
            TimingInfo millisBeginPayr0302DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            payr0302SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	payr0302SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.totalRecordCount < 100) { 
            	payr0302SrhVO.setLastIndex( pagingValues.totalRecordCount ); 
            } else
            if (pagingValues.offsetLimit > 0) {
            	payr0302SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = payr0302DAO.selectPayr0302ExtpyList(payr0302SrhVO);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
        
            while ( iter.hasNext() ) {
            	
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
                  	
                    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                    Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
                            map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
                
 
                    
                    bm.set(tableAttributes[i].getName(), baseModelValue);
                }

                bm.set(TableDef.ID_PROPERTY_NAME, idValue);
                bmResult.add(bm);
            } 

            retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
            
            SmrmfUtils.endTiming(logger, millisBeginPayr0302DataList, "getPayr0302DataList");
       

        }
        catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
	

	//공제 
	public PagingLoadResult<BaseModel> getPayr0302DducDataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_PAYR0302_DDUC_DATA_LIST;
        Payr0302SrhVO   payr0302SrhVO = new Payr0302SrhVO();
        Payr0302VO      payr0302VO = new Payr0302VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
       
        
        try {
        	
        	payr0302DAO = (Payr0302DAO)BeanFinder.getBean("Payr0302DAO");
        	
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
            payr0302SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드
            payr0302SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;
            payr0302SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));//단위기관코드
            payr0302SrhVO.setPayCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payCd")));  //급여구분코드 
            payr0302SrhVO.setPymtYrMnth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtYrMnth"))); //지급년 
            payr0302SrhVO.setPayrSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "payrSeilNum"),"0"))); //급여일련번호 
            //payr0302SrhVO.setPymtDducDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtDducDivCd")));
             //본봉수당 B0080010, 'B0080020' 공제 = B0080030,B0080040
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
//	         if ( pagingValues.executeRecordCount ) { 
//	            	
//                //Execute query that returns a single value
//                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
//                 
//                int iResultCnt = payr0302DAO.selectPayr0302DducListTotCnt(payr0302SrhVO);  
//                
//            	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
//            	if (!pagingValues.pageExecute) { 
//                    pagingValues.offsetLimit = iResultCnt;       
//                }
//                pagingValues.totalRecordCount = iResultCnt;	
//                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
//              
////                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
////                pagingValues.totalRecordCount = iResultCnt;	       
////                
////                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
//            }
            
	      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 
		            	
				//Execute query that returns a single value
	        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	          	int iResultCnt =  payr0302DAO.selectPayr0302DducListTotCnt(payr0302SrhVO);
	              
	          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
	          	
	          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                
	         	pagingValues.totalRecordCount = iResultCnt;	       
	                
	        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
        
            TimingInfo millisBeginPayr0302DducDataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            payr0302SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	payr0302SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.totalRecordCount < 100) { 
            	payr0302SrhVO.setLastIndex( pagingValues.totalRecordCount ); 
            } else  if (pagingValues.offsetLimit > 0) {
            	payr0302SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = payr0302DAO.selectPayr0302DducList(payr0302SrhVO);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
        
            while ( iter.hasNext() ) {
            	
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
                       
                     case ColumnDef.TYPE_LONG:   
                  	 
                  	if (mapCon != null) {  
                  		Long  lValue =  (new BigDecimal(mapCon.toString())).longValue() ; 
                  		map.put(tableAttributes[i].getName(), lValue); 
                  	}  
                  	   
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

                         }
                 			
                 	map.put(tableAttributes[i].getName(), strValue);
                 		                    
                 	break;

                  	 
                     case ColumnDef.TYPE_DOUBLE:  
                  	 
                  	  if (mapCon != null) {      
                      	 Double dbValue = (new BigDecimal(mapCon.toString())).doubleValue(); 
                      	 map.put(tableAttributes[i].getName(), dbValue); 
                  	  }  
                  	   
                    	 break;
                    }
                  	
                    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                    Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
                            map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
                
 
                    
                    bm.set(tableAttributes[i].getName(), baseModelValue);
                }

                bm.set(TableDef.ID_PROPERTY_NAME, idValue);
                bmResult.add(bm);
            } 

            retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
            
            SmrmfUtils.endTiming(logger, millisBeginPayr0302DducDataList, "getPayr0302DducDataList");
       

        }
        catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
	
	
	
	
	
    /**
     * 
     * <pre>
     * 1. 개요 : 복무관리  
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : getDlgn250Data
     * @date : 2017. 7. 20.
     * @author : atres
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2017. 7. 20.		atres				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param infcPkgDlgn0250Dto
     * @return
     * @throws MSFException
     */
	public InfcPkgDlgn0250DTO getDlgn250Data(InfcPkgDlgn0250DTO infcPkgDlgn0250Dto) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  "getDlgn250Data";
         
        InfcPkgDlgn0250VO      infcPkgDlgn0250Vo = new InfcPkgDlgn0250VO();
        InfcPkgDlgn0250DTO      infcDlgn0250Dto = new InfcPkgDlgn0250DTO();
         
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        try { 
           
        	infcPkgDlgn0100Dao = (InfcPkgDlgn0100DAO)BeanFinder.getBean("InfcPkgDlgn0100DAO");
        	
            /** 조건절 */
        	infcPkgDlgn0250Vo.setDpobCd(infcPkgDlgn0250Dto.getDpobCd());    																	/** column 사업장코드 : dpobCd */
        	infcPkgDlgn0250Vo.setSystemkey(infcPkgDlgn0250Dto.getSystemkey());    															/** column SYSTEMKEY : systemkey */
        	infcPkgDlgn0250Vo.setDilnlazYrMnth(infcPkgDlgn0250Dto.getDilnlazYrMnth().replace(".", ""));    									/** column 근태년월 : dilnlazYrMnth */
        	infcPkgDlgn0250Vo.setPayCd(infcPkgDlgn0250Dto.getPayCd());    																	/** column 급여구분코드 : payCd */
        	infcPkgDlgn0250Vo.setEmymtDivCd(infcPkgDlgn0250Dto.getEmymtDivCd());    															/** column 고용구분코드 : emymtDivCd */
        	infcPkgDlgn0250Vo.setDeptCd(infcPkgDlgn0250Dto.getDeptCd());    																	/** column 부서코드 : deptCd */
        	infcPkgDlgn0250Vo.setBusinCd(infcPkgDlgn0250Dto.getBusinCd());    																/** column 사업코드 : businCd */
           
        	infcPkgDlgn0250Vo = infcPkgDlgn0100Dao.selectDlgn0250Data(infcPkgDlgn0250Vo);
             
            if (MSFSharedUtils.paramNotNull(infcPkgDlgn0250Vo) ) {
        	
        	   infcDlgn0250Dto.setDpobCd(infcPkgDlgn0250Vo.getDpobCd());    																	/** column 사업장코드 : dpobCd */
               infcDlgn0250Dto.setSystemkey(infcPkgDlgn0250Vo.getSystemkey());    															/** column SYSTEMKEY : systemkey */
               infcDlgn0250Dto.setDilnlazYrMnth(infcPkgDlgn0250Vo.getDilnlazYrMnth().replace(".", ""));    									/** column 근태년월 : dilnlazYrMnth */
               infcDlgn0250Dto.setPayCd(infcPkgDlgn0250Vo.getPayCd());    																	/** column 급여구분코드 : payCd */
               infcDlgn0250Dto.setEmymtDivCd(infcPkgDlgn0250Vo.getEmymtDivCd());    															/** column 고용구분코드 : emymtDivCd */
               infcDlgn0250Dto.setDeptCd(infcPkgDlgn0250Vo.getDeptCd());    																	/** column 부서코드 : deptCd */
               infcDlgn0250Dto.setBusinCd(infcPkgDlgn0250Vo.getBusinCd());    																/** column 사업코드 : businCd */
          //     infcDlgn0250Dto.setTypOccuCd(infcPkgDlgn0250Vo.getTypOccuCd());    															/** column 직종코드 : typOccuCd */
           //    infcDlgn0250Dto.setDtilOccuInttnCd(infcPkgDlgn0250Vo.getDtilOccuInttnCd());    												/** column 직종세구분코드 : dtilOccuInttnCd */
           //    infcDlgn0250Dto.setDilnlazDutyBgnnDt(infcPkgDlgn0250Vo.getDilnlazDutyBgnnDt());    											/** column 근태_근무시작일자 : dilnlazDutyBgnnDt */
           //    infcDlgn0250Dto.setDilnlazDutyEndDt(infcPkgDlgn0250Vo.getDilnlazDutyEndDt());    												/** column 근태_근무종료일자 : dilnlazDutyEndDt */
               infcDlgn0250Dto.setDilnlazDutyNumDys(MSFSharedUtils.defaultNulls(infcPkgDlgn0250Vo.getDilnlazDutyNumDys(),"0"));    			/** column 근태_근무일수 : dilnlazDutyNumDys */
               infcDlgn0250Dto.setDilnlazLvsgNumDys(MSFSharedUtils.defaultNulls(infcPkgDlgn0250Vo.getDilnlazLvsgNumDys(),"0"));    			/** column 근태_연가일수 : dilnlazLvsgNumDys */
               infcDlgn0250Dto.setDilnlazAbnceNumDys(MSFSharedUtils.defaultNulls(infcPkgDlgn0250Vo.getDilnlazAbnceNumDys(),"0"));    			/** column 근태_결근일수 : dilnlazAbnceNumDys */
               infcDlgn0250Dto.setDilnlazSckleaNumDys(MSFSharedUtils.defaultNulls(infcPkgDlgn0250Vo.getDilnlazSckleaNumDys(),"0"));    		/** column 근태_병가일수 : dilnlazSckleaNumDys */
               infcDlgn0250Dto.setDilnlazOffvaNumDys(MSFSharedUtils.defaultNulls(infcPkgDlgn0250Vo.getDilnlazOffvaNumDys(),"0"));    			/** column 근태_공가일수 : dilnlazOffvaNumDys */
               infcDlgn0250Dto.setDilnlazFmlyEvntNumDys(MSFSharedUtils.defaultNulls(infcPkgDlgn0250Vo.getDilnlazFmlyEvntNumDys(),"0"));    	/** column 근태_경조사일수 : dilnlazFmlyEvntNumDys */
               infcDlgn0250Dto.setDilnlazHlthCreNumDys(MSFSharedUtils.defaultNulls(infcPkgDlgn0250Vo.getDilnlazHlthCreNumDys(),"0"));    		/** column 근태_보건일수 : dilnlazHlthCreNumDys */
               infcDlgn0250Dto.setDilnlazTotDutyNumDys(MSFSharedUtils.defaultNulls(infcPkgDlgn0250Vo.getDilnlazTotDutyNumDys(),"0"));    		/** column 근태_총근무일수 : dilnlazTotDutyNumDys */
               infcDlgn0250Dto.setDilnlazWklyHldyNumDys(MSFSharedUtils.defaultNulls(infcPkgDlgn0250Vo.getDilnlazWklyHldyNumDys(),"0"));    	/** column 근태_주휴일수 : dilnlazWklyHldyNumDys */
               infcDlgn0250Dto.setDilnlazPaidPubcHodyNum(MSFSharedUtils.defaultNulls(infcPkgDlgn0250Vo.getDilnlazPaidPubcHodyNum(),"0"));    	/** column 근태_유급휴일수 : dilnlazPaidPubcHodyNum */
               infcDlgn0250Dto.setDilnlazDdlnePrcsYn((Boolean.TRUE.equals(infcPkgDlgn0250Vo.getDilnlazDdlnePrcsYn()) ? "Y" : "N") );    		/** column 근태_마감처리여부 : dilnlazDdlnePrcsYn */
         //      infcDlgn0250Dto.setDilnlazNoteCtnt(infcPkgDlgn0250Vo.getDilnlazNoteCtnt());    												/** column 근태_비고내용 : dilnlazNoteCtnt */ 
               infcDlgn0250Dto.setDilnlazSpclHodyNumDys(MSFSharedUtils.defaultNulls(infcPkgDlgn0250Vo.getDilnlazSpclHodyNumDys(),"0"));    	/** column 근태_특별휴가일수 : dilnlazSpclHodyNumDys */
               infcDlgn0250Dto.setDilnlazSatDutyNumDys(MSFSharedUtils.defaultNulls(infcPkgDlgn0250Vo.getDilnlazSatDutyNumDys(),"0"));    		/** column 총토요근무일수 : dilnlazSatDutyNumDys */
                infcDlgn0250Dto.setDilnlazHodyDutyNumDys(MSFSharedUtils.defaultNulls(infcPkgDlgn0250Vo.getDilnlazHodyDutyNumDys(),"0"));    /** column 총휴일근무일수 : dilnlazPubcHodyDutyNumDys */
               infcDlgn0250Dto.setDilnlazHodyDutyNumDys(MSFSharedUtils.defaultNulls(infcPkgDlgn0250Vo.getDilnlazHodyDutyNumDys(),"0"));    	/** column 휴일일수 : dilnlazHodyDutyNumDys */
               infcDlgn0250Dto.setDilnlazAbnceDutyRcgtnDys(MSFSharedUtils.defaultNulls(infcPkgDlgn0250Vo.getDilnlazAbnceDutyRcgtnDys(),"0"));	/** column 근태_결근인정일수 : dilnlazAbnceDutyRcgtnDys */
               infcDlgn0250Dto.setPyspGrdeCd(infcPkgDlgn0250Vo.getPyspGrdeCd());    															/** column 호봉등급코드 : pyspGrdeCd */
               infcDlgn0250Dto.setDilnlazTotDutyTm(MSFSharedUtils.defaultNulls(infcPkgDlgn0250Vo.getDilnlazTotDutyTm(),"0"));    				/** column 근태_총근무시간 : dilnlazTotDutyTm */
               infcDlgn0250Dto.setDilnlazPaidHodyNumDys(MSFSharedUtils.defaultNulls(infcPkgDlgn0250Vo.getDilnlazPaidHodyNumDys(),"0"));    	/** column 근태_유급휴가일수 : dilnlazPaidHodyNumDys */
               infcDlgn0250Dto.setDilnlazTfcAssCstNumDys(MSFSharedUtils.defaultNulls(infcPkgDlgn0250Vo.getDilnlazTfcAssCstNumDys(),"0"));    	/** column 근태_교통보조비일수 : dilnlazTfcAssCstNumDys */ 
               infcDlgn0250Dto.setDilnlazLnchDys(MSFSharedUtils.allowNulls(infcPkgDlgn0250Vo.getDilnlazLnchDys()));    						/** column 근태_급식비일수 : dilnlazLnchDys */
               infcDlgn0250Dto.setDilnlazWkdDutyNumDys(MSFSharedUtils.allowNulls(infcPkgDlgn0250Vo.getDilnlazWkdDutyNumDys()));    			/** column 평일근무일수 : dilnlazWkdDutyNumDys */
               
               infcDlgn0250Dto.setDilnlazPubcHodyDutyNumDys(MSFSharedUtils.defaultNulls(infcPkgDlgn0250Vo.getDilnlazPubcHodyDutyNumDys(),"0"));/** column 총휴일근무일수 : dilnlazPubcHodyDutyNumDys */
//               infcDlgn0250Dto.setDilnlazHodyDutyNumDys(MSFSharedUtils.defaultNulls(infcPkgDlgn0250Vo.getDilnlazHodyDutyNumDys(),"0"));    	/** column 휴일일수 : dilnlazHodyDutyNumDys */
               infcDlgn0250Dto.setDilnlazSatDutyNumDys(infcPkgDlgn0250Vo.getDilnlazSatDutyNumDys());    /** column 근태_토요근무일수 : dilnlazSatDutyNumDys */
             //  infcDlgn0250Dto.setDilnlazTotNtotNumDys(infcPkgDlgn0250Vo.getDilnlazTotNtotNumDys());    /** column 근태_총야근일수 : dilnlazTotNtotNumDys */
               infcDlgn0250Dto.setDilnlazTotNtotTm(MSFSharedUtils.defaultNulls(infcPkgDlgn0250Vo.getDilnlazTotNtotTm(),"0"));    				/** column 근태_총야근시간 : dilnlazTotNtotTm */
               
               infcDlgn0250Dto.setDilnlazFndtnTmRstDutyTm(MSFSharedUtils.defaultNulls(infcPkgDlgn0250Vo.getDilnlazFndtnTmRstDutyTm(),"0"));	/** column 근태_기본시간외근무시간 : dilnlazFndtnTmRstDutyTm */
               infcDlgn0250Dto.setDilnlazTmRstDutyTm(MSFSharedUtils.defaultNulls(infcPkgDlgn0250Vo.getDilnlazTmRstDutyTm(),"0"));				/** column 근태_시간외근무시간 : dilnlazTmRstDutyTm */
               
               if (new BigDecimal(MSFSharedUtils.defaultNulls(infcPkgDlgn0250Vo.getDilnlazTotTmRstDutyTm(),"0")).compareTo(BigDecimal.ZERO) <= 0) { 
               	infcDlgn0250Dto.setDilnlazTotTmRstDutyTm((new BigDecimal(MSFSharedUtils.defaultNulls(infcPkgDlgn0250Vo.getDilnlazFndtnTmRstDutyTm(),"0")).add(new BigDecimal(MSFSharedUtils.defaultNulls(infcPkgDlgn0250Vo.getDilnlazTmRstDutyTm(),"0")))).toString());    /** column 근태_총시간외근무시간 : dilnlazTotTmRstDutyTm */
               }	else {
               	infcDlgn0250Dto.setDilnlazTotTmRstDutyTm(MSFSharedUtils.defaultNulls(infcPkgDlgn0250Vo.getDilnlazTotTmRstDutyTm(),"0"));	/** column 근태_총시간외근무시간 : dilnlazTotTmRstDutyTm */
               } 
               
        //       infcDlgn0250Dto.setDilnlazDdlnePrcsYn((Boolean.TRUE.equals(infcPkgDlgn0250Vo.getDilnlazDdlnePrcsYn()) ? "Y" : "N") );			/** column 근태_마감처리여부 : dilnlazDdlnePrcsYn */
         //      infcDlgn0250Dto.setDilnlazNoteCtnt(infcPkgDlgn0250Vo.getDilnlazNoteCtnt());    												/** column 근태_비고내용 : dilnlazNoteCtnt */
            }
        }
        catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return infcDlgn0250Dto;
    }
		
	
	
   //급여조정 
	public PagingLoadResult<BaseModel> getPayr0307ToPayr4200DataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_PAYR0307TOPAYR4200_DATA_LIST;
        Payr0307SrhVO   payr0307SrhVO = new Payr0307SrhVO();
        Payr0307VO      payr0307VO = new Payr0307VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        

    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        if  (MSFSharedUtils.paramNull(payr0307DAO)) {
        
        	WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

        	payr0307DAO = (Payr0307DAO) wac.getBean("Payr0307DAO" ); 
        }
        
        try {
        	
        	payr0307DAO = (Payr0307DAO)BeanFinder.getBean("Payr0307DAO");
        	
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
           // Sysm0250BM          user             = serviceParameters.getUser();
            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
            //String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
           
            /** 조건절 */
            payr0307SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드
            payr0307SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;
            payr0307SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));//단위기관코드
            payr0307SrhVO.setPayCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payCd")));  //급여구분코드 
            payr0307SrhVO.setPymtYrMnth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtYrMnth"))); //지급년 
            payr0307SrhVO.setPayrSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "payrSeilNum"),"0"))); //급여일련번호 
            //payr0302SrhVO.setPymtDducDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtDducDivCd")));
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	         if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = payr0307DAO.selectPayr0307ToPayr4200ListTotCnt(payr0307SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                pagingValues.totalRecordCount = iResultCnt;	       
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginPayr0307ToPayr4200DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            payr0307SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	payr0307SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.totalRecordCount < 100) { 
            	payr0307SrhVO.setLastIndex( pagingValues.totalRecordCount ); 
            } else  if (pagingValues.offsetLimit > 0) {
            	payr0307SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = payr0307DAO.selectPayr0307ToPayr4200List(payr0307SrhVO);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
        
            while ( iter.hasNext() ) {
            	
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
                  	
                    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
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
            
            SmrmfUtils.endTiming(logger, millisBeginPayr0307ToPayr4200DataList, "getPayr0307ToPayr4200DataList");
       

        }
        catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
	
	//급여조정이력
	public PagingLoadResult<BaseModel> getPayr0307ToPayr420001DataList(ServiceParameters serviceParameters) throws MSFException {

	        PagingLoadResult<BaseModel> retval = null;
	        String method =  CLASS_PAYR0307TOP420001_DATA_LIST;
	        Payr0307SrhVO   payr0307SrhVO = new Payr0307SrhVO();
	        Payr0307VO      payr0307VO = new Payr0307VO();
	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
	        
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	    	// 1. 암호화 객체 생성
//	    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	         
	        try {
	        	
	        	payr0307DAO = (Payr0307DAO)BeanFinder.getBean("Payr0307DAO");
	        	
	            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
	           // Sysm0250BM          user             = serviceParameters.getUser();
	            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
	            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
	            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
	            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

	            //Get paging configuration
	            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

	            //Get query parameters
	            //String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
	           
//	            /** 조건절 */
//	            payr0307SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드
//	            payr0307SrhVO.setPymtYrMnth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtYrMnth"))); 		//지급년 
//	            payr0307SrhVO.setPayCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payCd")));  					//급여구분코드 
//	            payr0307SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));	//단위기관코드
//	            payr0307SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));			//고용구분
//	            payr0307SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));
//	            payr0307SrhVO.setPayrSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "payrSeilNum"),"0"))); //급여일련번호 
	            //payr0302SrhVO.setPymtDducDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtDducDivCd")));
	            
	            List<String> listDeptCd = new ArrayList<String>();
	            
	            /** 조건절 */
	            payr0307SrhVO.setDpobCd(sessionUser.getDpobCd());  					// 사업장코드
	            payr0307SrhVO.setPymtYrMnth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtYrMnth"))); // 지급년월
	            payr0307SrhVO.setPayCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payCd")));  			// 급여구분코드 
	            payr0307SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  	// 단위기관담당자여부 
	           
	            payr0307SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));	// 고용구분코드
	            payr0307SrhVO.setUsrId(sessionUser.getUsrId());  
	            
	            /******************************** 권한 ************************************************************************/
	            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	            if ("FALSE".equals(chkDeptCd)) {
	            	
	            	if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"),sessionUser.getDeptCd()))) {
	               	 

		            	payr0307SrhVO.setDeptCd(sessionUser.getDeptCd()); 
		               listDeptCd.add(sessionUser.getDeptCd());
		               payr0307SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
	            	 } else {
	            		 payr0307SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
		            		listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
		            		payr0307SrhVO.setDeptCdArr(listDeptCd);     //부서코드    
	                     
	            	 }  
	            	 
	               payr0307SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	            } else {
	            	    
	            	payr0307SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드
	            	if (payr0307SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
	            		listDeptCd = null; 
	            		payr0307SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
	            		payr0307SrhVO.setDeptCd("");  //부서코드
	            	} else {
	            		payr0307SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
	            		listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
	            		payr0307SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
	            	} 
	            }
	           
	            payr0307SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
	            payr0307SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));    
	           /******************************** 권한 ************************************************************************/
	            
//	              if (payr0304SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) {
//	            	payr0304SrhVO.setPayrMangDeptYn("Y");  //단위기관담당자여부 
//	            	List<String> listDeptCd = null; 
//	            	payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
//	            	payr0304SrhVO.setDeptCd("");     //부서코드
//	            } else {
	//
//	                List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//	                payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드  
//	                payr0304SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드 
//	            }
	            
	            
	            
	            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
	            payr0307SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
	            payr0307SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  				//직종
	           
	             
	            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
	            payr0307SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	            payr0307SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 	//직종세
	            
	            payr0307SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   	//사업코드 
	            payr0307SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));	//시스템키
	            payr0307SrhVO.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    		//한글성명 	            
	            
	            payr0307SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));	//시스템키
	            payr0307SrhVO.setPymtDducDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtDducDivCd")));   //지급공제구분 	   
	            payr0307SrhVO.setPayItemCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payItemCd")));   //지급공제항목 	   
	            
	            
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
		         if ( pagingValues.executeRecordCount ) { 
		            	
	                //Execute query that returns a single value
	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	                int iResultCnt = payr0307DAO.selectPayr0307ToPayr420001ListTotCnt(payr0307SrhVO);  
	              
	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	                if (!pagingValues.pageExecute) { 
	                    pagingValues.offsetLimit = iResultCnt;       
	                }
	                pagingValues.totalRecordCount = iResultCnt;	       
	                
	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	            }
	        
	            TimingInfo millisBeginPayr0307ToPayr4200DataList = SmrmfUtils.startTiming(logger);

		     	/**페이지 카운트 처리를 위한 부분 */ 
	            payr0307SrhVO.setPageSize(pagingValues.totalRecordCount);  
		            
		     	//Apply paging
		     	if (pagingValues.start > 0) {
		     		payr0307SrhVO.setFirstIndex(pagingValues.start);
		     	}
		     	if (pagingValues.offsetLimit > 0) {
		     		payr0307SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
		     	}


	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	            List list = payr0307DAO.selectPayr0307ToPayr420001List(payr0307SrhVO);
	            
		        Iterator<Map<String, Object>> iter = list.iterator();
		            
	            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	           
	        
	            while ( iter.hasNext() ) {
	            	
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
	                  	
	                    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
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
	            
	            SmrmfUtils.endTiming(logger, millisBeginPayr0307ToPayr4200DataList, "getPayr0307ToPayr420001DataList");
	       

	        }
	        catch (Exception ex) {
	        	ex.printStackTrace();
	            //Return operation exception
	            throw MSFServerUtils.getOperationException(method, ex, logger);
	        }

	        return retval;
	    }

 
/**
 * 
 * <pre>
 * 1. 개요 : 
 * 2. 처리내용 : 
 * </pre>
 * @Method Name : activityOnPayr4200
 * @date : 2017. 7. 20.
 * @author : atres
 * @history : 
 *	-----------------------------------------------------------------------
 *	변경일				작성자						변경내용  
 *	----------- ------------------- ---------------------------------------
 *	2017. 7. 20.		atres				최초 작성 
 *	-----------------------------------------------------------------------
 * 
 * @see com.app.exterms.payroll.client.service.Payr4200Service#activityOnPayr4200(java.util.List, smrmframework.core.com.msfmainapp.client.utils.MSFFormPanel.ActionDatabase)
 * @param listPayr0307dto
 * @param actionDatabase
 * @return
 * @throws MSFException
 */
	
	
	
	
	
	
	
    @Override
    public Long activityOnPayr4200(List<Payr0307DTO> listPayr0307dto, ActionDatabase actionDatabase) throws MSFException  {
        Long result = new Long(0);
        Long iCnt = new Long(0);
        String Payr4200DducCheck = "";  //소득세주민세 여부 판단  
        try { 
            
        	payr0307DAO = (Payr0307DAO)BeanFinder.getBean("Payr0307DAO");
        	
        	InfcPkgPayr0302VO  calPayr0302Vo = new InfcPkgPayr0302VO(); 
            Payr0307SrhVO   payr0307SrhVO = new Payr0307SrhVO();
            
            BigDecimal tpExtpyTotAmnt = BigDecimal.ZERO;   //현수당금
            BigDecimal tpTxtnTotAmnt = BigDecimal.ZERO; //과세금액  
            BigDecimal tpFreeDtyTotAmnt = BigDecimal.ZERO; // 비과세금액 
            BigDecimal freeDtySum = BigDecimal.ZERO;   // 비과세 적용금액  
          
        	// 1. 암호화 객체 생성
//        	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
            
            for(int iPayrCnt=0;iPayrCnt < listPayr0307dto.size();iPayrCnt++) {
            	
            	// 1. 암호화 객체 생성
    	    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
            	
            	    tpExtpyTotAmnt = BigDecimal.ZERO;   //현수당금
                    tpTxtnTotAmnt = BigDecimal.ZERO; //과세금액  
                    tpFreeDtyTotAmnt = BigDecimal.ZERO; // 비과세금액 
                    freeDtySum = BigDecimal.ZERO;   // 비과세 적용금액  
                
                    Payr0307DTO payr0307Dto = new Payr0307DTO();  
                    payr0307Dto = listPayr0307dto.get(iPayrCnt); 
 
                    Payr0307VO  payr0307Vo = new Payr0307VO();
                    Payr0307VO  tpPayr0307Vo = new Payr0307VO();
                    
                    Payr0302VO  payr0302Vo = new Payr0302VO(); 
                       
                    payr0307Vo.setDpobCd(payr0307Dto.getDpobCd());    				/** column 사업장코드 : dpobCd */
                    payr0307Vo.setPymtYrMnth(payr0307Dto.getPymtYrMnth());    		/** column 지급년월 : pymtYrMnth */
                    payr0307Vo.setPayCd(payr0307Dto.getPayCd());    				/** column 급여구분코드 : payCd */
                    payr0307Vo.setPayrSeilNum(new BigDecimal(payr0307Dto.getPayrSeilNum()));    /** column 급여일련번호 : payrSeilNum */
                    payr0307Vo.setSystemkey(payr0307Dto.getSystemkey());    		/** column SYSTEMKEY : systemkey */
                    payr0307Vo.setMnthPayAdmntSeilNum(new BigDecimal(payr0307Dto.getMnthPayAdmntSeilNum()));    /** column 월급여조정일련번호 : mnthPayAdmntSeilNum */
                    payr0307Vo.setPayItemCd(payr0307Dto.getPayItemCd());   			/** column 급여항목코드 : payItemCd */
                    payr0307Vo.setPymtDducDivCd(payr0307Dto.getPymtDducDivCd());  	/** column 지급공제구분코드 : pymtDducDivCd */
                     
                  
                    payr0307Vo.setPymtDducSum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Dto.getPymtDducSum(),"0")));    /** column 지급공제금액 : pymtDducSum */
                    payr0307Vo.setPymtDducFreeDtySum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Dto.getPymtDducFreeDtySum(),"0")));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                   
                    //소득세제외 여부 추가 처리을 위해 조건추가 함 
                    if (Boolean.TRUE.equals(payr0307Dto.getMnthPayAdmntYn())) {
                    	 payr0307Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column null : pymtDducTxtnAmnt */
                    } else {
                    
		                    if ("B0080010".equals(payr0307Dto.getPymtDducDivCd())) {
		                        
		                        if (new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Dto.getPymtDducTxtnAmnt(),"0")).compareTo(BigDecimal.ZERO) == 0) {
		                          
		                            if (new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Dto.getPymtDducFreeDtySum(),"0")).compareTo(BigDecimal.ZERO) != 0) {
		                                
		                                payr0307Vo.setPymtDducTxtnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Dto.getPymtDducSum(),"0")).subtract(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Dto.getPymtDducFreeDtySum(),"0"))));    /** column null : pymtDducTxtnAmnt */ 
		                            
		                            } else {
		                                
		                                payr0307Vo.setPymtDducTxtnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Dto.getPymtDducSum(),"0")));    /** column null : pymtDducTxtnAmnt */ 
		                                 
		                            }
		                        } else {
		                            
		                            if (new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Dto.getPymtDducFreeDtySum(),"0")).compareTo(BigDecimal.ZERO) != 0) {
		                                
		                                payr0307Vo.setPymtDducTxtnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Dto.getPymtDducSum(),"0")).subtract(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Dto.getPymtDducFreeDtySum(),"0"))));    /** column null : pymtDducTxtnAmnt */ 
		                            
		                            } else {
		                                
		                                payr0307Vo.setPymtDducTxtnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Dto.getPymtDducSum(),"0")));    /** column null : pymtDducTxtnAmnt */ 
		                                 
		                            }
		                        }
		                       
		                    
		                    } else  if ("B0080020".equals(payr0307Dto.getPymtDducDivCd())) {
		                    
		                        if (new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Dto.getPymtDducTxtnAmnt(),"0")).compareTo(BigDecimal.ZERO) == 0) {
		                            
		                            if (new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Dto.getPymtDducFreeDtySum(),"0")).compareTo(BigDecimal.ZERO) != 0) {
		                                
		                                payr0307Vo.setPymtDducTxtnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Dto.getPymtDducSum(),"0")).subtract(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Dto.getPymtDducFreeDtySum(),"0"))));    /** column null : pymtDducTxtnAmnt */ 
		                            
		                            } else {
		                                
		                                payr0307Vo.setPymtDducTxtnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Dto.getPymtDducSum(),"0")));    /** column null : pymtDducTxtnAmnt */ 
		                                 
		                            }
		                        } else {
		                            
		                            if (new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Dto.getPymtDducFreeDtySum(),"0")).compareTo(BigDecimal.ZERO) != 0) {
		                                
		                                payr0307Vo.setPymtDducTxtnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Dto.getPymtDducSum(),"0")).subtract(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Dto.getPymtDducFreeDtySum(),"0"))));    /** column null : pymtDducTxtnAmnt */ 
		                            
		                            } else {
		                                
		                                payr0307Vo.setPymtDducTxtnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Dto.getPymtDducSum(),"0")));    /** column null : pymtDducTxtnAmnt */ 
		                                 
		                            }
		                        }
		                        
		                    }  else {
		                        
		                        payr0307Vo.setPymtDducTxtnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Dto.getPymtDducTxtnAmnt(),"0")));    /** column null : pymtDducTxtnAmnt */
		                    } 
                    }
                    payr0307Vo.setMnthPayAdmntAssoBssCtnt(payr0307Dto.getMnthPayAdmntAssoBssCtnt());    /** column 월급여조정관련근거내용 : mnthPayAdmntAssoBssCtnt */
                    
                   /**
                    * mnthPayAdmntYn ->  PAY_PYMT_DDUC_PRCS_FLAG 소득세제외여부로 변경 연동 PAYR0302 
                    *  Y  :  소득세제외
                    *  N  : 소득세처리  
                    */ 
                    payr0307Vo.setMnthPayAdmntYn((Boolean.TRUE.equals(payr0307Dto.getMnthPayAdmntYn()) ? "Y" : "N"));    /** column 소득세제외여부  : mnthPayAdmntYn */
                  
//                    payr0307Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
//                    payr0307Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
//                    payr0307Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//                    payr0307Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
//                    payr0307Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
//                    payr0307Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
                      
                    //정액급식비 인경우 비과세처리를 위해 추가 
//                    if ("C9080100".equals(payr0307Dto.getPayItemCd())) {  //) && (payr0307Vo.getPymtDducFreeDtySum().compareTo(BigDecimal.ZERO) <= 0)
//                    	
//                    	  payr0307SrhVO.setDpobCd(payr0307Dto.getDpobCd());  //사업장코드 
//                          payr0307SrhVO.setSystemkey(payr0307Dto.getSystemkey());//단위기관코드
//                          payr0307SrhVO.setPayCd(payr0307Dto.getPayCd());  //급여구분코드 
//                          payr0307SrhVO.setPymtYrMnth(payr0307Dto.getPymtYrMnth()); //지급년 
//                          payr0307SrhVO.setPayrSeilNum(new BigDecimal(payr0307Dto.getPayrSeilNum())); //급여일련번호 
//                          //payr0302SrhVO.setPymtDducDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtDducDivCd")));
//                          
//                    	  List  listPayrPymtFreeList = payr0307DAO.selectPayr0307ToFreeCalcList(payr0307SrhVO);
//                    	  
//                    	  if (listPayrPymtFreeList.size() > 0) {
//                    		  
//                    		Map tempMap = (Map)listPayrPymtFreeList.get(0); 
//                    		   
//                		    tpExtpyTotAmnt = new BigDecimal(String.valueOf(tempMap.get("tpExtpyTotAmnt")));   //현수당금액 
//                            tpTxtnTotAmnt = new BigDecimal(String.valueOf(tempMap.get("tpTxtnTotAmnt"))); ;   //과세금액  
//                            tpFreeDtyTotAmnt = new BigDecimal(String.valueOf(tempMap.get("tpFreeDtyTotAmnt"))); ; // 비과세금액 
//                            freeDtySum = new BigDecimal(String.valueOf(tempMap.get("freeDtySum"))); ;   // 비과세 적용금액  
//                               
//                            
//                            tpExtpyTotAmnt = tpExtpyTotAmnt.add(payr0307Vo.getPymtDducSum());
//                            
//                            if (tpExtpyTotAmnt.compareTo(BigDecimal.ZERO) > 0) {
//                            	
//                            	if (tpExtpyTotAmnt.compareTo(tpFreeDtyTotAmnt) > 0){ 
//                            		 
//                            		BigDecimal subFreeDytAm = freeDtySum.subtract(tpFreeDtyTotAmnt); //나머지 금액 
//                            		BigDecimal subExtpytotAm = tpExtpyTotAmnt.subtract(tpFreeDtyTotAmnt); //나머지 금액 
//                            		
//                            		if (subExtpytotAm.compareTo(subFreeDytAm) > 0) {
//                            			
//                            			 payr0307Vo.setPymtDducTxtnAmnt(subExtpytotAm.subtract(subFreeDytAm));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//                                         payr0307Vo.setPymtDducFreeDtySum(subFreeDytAm);    /** column null : pymtDducTxtnAmnt */ 
//                                         
//                            		} else {
//                            			payr0307Vo.setPymtDducFreeDtySum(subExtpytotAm);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//                                        payr0307Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column null : pymtDducTxtnAmnt */ 
//                            		}
//                            		
//                            		
//                            	} else {
//                            	 
//	                           		  payr0307Vo.setPymtDducFreeDtySum(tpExtpyTotAmnt.subtract(tpFreeDtyTotAmnt));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//                                      payr0307Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column null : pymtDducTxtnAmnt */ 
//	                           		 
//                            	}
//                            	
//                            } else {
//                            	
//                            	if ((tpFreeDtyTotAmnt.add(payr0307Vo.getPymtDducSum())).compareTo(BigDecimal.ZERO) > 0) {
//                            		  payr0307Vo.setPymtDducFreeDtySum(payr0307Vo.getPymtDducSum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//                                      payr0307Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column null : pymtDducTxtnAmnt */ 
//                            	} else {
//                            		 payr0307Vo.setPymtDducFreeDtySum(payr0307Vo.getPymtDducSum() );    /** column 지급공제비과세금액 : pymtDducFreeDtySum BigDecimal.ZERO.subtract(tpFreeDtyTotAmnt)*/
//                                     payr0307Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column null : pymtDducTxtnAmnt */ 
//                            	}
//                            	
//                            }
//                            
//                    	  }  
//                    } 
                    
                    
                    /** 소득세/지방소득세 입력시 처리 루틴 추가 */
                    if (ExtermsProps.getProps("PAY_DDUC_T00101").equals(payr0307Vo.getPayItemCd())) {
                    	Payr4200DducCheck = ExtermsProps.getProps("PAY_DDUC_T00101");
                    } else   if (ExtermsProps.getProps("PAY_DDUC_T00201").equals(payr0307Vo.getPayItemCd())) {
                    	Payr4200DducCheck = ExtermsProps.getProps("PAY_DDUC_T00101");
                    } else {
                    	
                    } 
                    
                   switch (actionDatabase) { 
                   case INSERT:
                       payr0307DAO.insertPayr0307(payr0307Vo);
                       
                       tpPayr0307Vo = payr0307DAO.selectPayr0307Max(payr0307Vo); 
                       
                       //TODO 급여조정정보을 급여상세내역에 추가하고 급여 합계정보 업데이트한다.  
                       if  (MSFSharedUtils.paramNotNull(tpPayr0307Vo) && MSFSharedUtils.paramNotNull(tpPayr0307Vo.getSystemkey())) {
                           payr0302Vo.setDpobCd(tpPayr0307Vo.getDpobCd());    						/** column 사업장코드 : dpobCd */
                           payr0302Vo.setPymtYrMnth(tpPayr0307Vo.getPymtYrMnth());    				/** column 지급년월 : pymtYrMnth */
                           payr0302Vo.setPayCd(tpPayr0307Vo.getPayCd());    						/** column 급여구분코드 : payCd */
                           payr0302Vo.setPayrSeilNum(tpPayr0307Vo.getPayrSeilNum());    			/** column 급여일련번호 : payrSeilNum */
                           payr0302Vo.setSystemkey(tpPayr0307Vo.getSystemkey());    				/** column SYSTEMKEY : systemkey */
                           payr0302Vo.setPayItemCd(tpPayr0307Vo.getPayItemCd());    				/** column 급여항목코드 : payItemCd */
                           payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));    					/** column 급여항목일련번호 : payItemSeilNum */
                           payr0302Vo.setPymtDducDivCd(tpPayr0307Vo.getPymtDducDivCd());    		/** column 지급공제구분코드 : pymtDducDivCd */
                           payr0302Vo.setPymtDducFreeDtySum(tpPayr0307Vo.getPymtDducFreeDtySum());	/** column 지급공제비과세금액 : pymtDducFreeDtySum */
                           payr0302Vo.setPymtDducSum(tpPayr0307Vo.getPymtDducSum());    			/** column 지급공제금액 : pymtDducSum */
                           payr0302Vo.setPayPymtDducPrcsFlag("N");    								/** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
                           payr0302Vo.setPayReattyAdmntVal(String.valueOf(tpPayr0307Vo.getMnthPayAdmntSeilNum()));    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
                           payr0302Vo.setPymtDducTxtnAmnt(tpPayr0307Vo.getPymtDducTxtnAmnt());    	/** column 지급공제과세금액 : pymtDducTxtnAmnt */
//                           payr0302Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
//                           payr0302Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
//                           payr0302Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//                           payr0302Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
//                           payr0302Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
//                           payr0302Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
                           payr0302DAO.insertPayr0302(payr0302Vo);
                       }
                      break;
                   case UPDATE: 
                       payr0307DAO.updatePayr0307(payr0307Vo);
                       
                       //TODO 급여조정정보을 급여상세내역에 추가하고 급여 합계정보 업데이트한다.   
                       payr0302Vo.setDpobCd(payr0307Vo.getDpobCd());    									/** column 사업장코드 : dpobCd */
                       payr0302Vo.setPymtYrMnth(payr0307Vo.getPymtYrMnth());    							/** column 지급년월 : pymtYrMnth */
                       payr0302Vo.setPayCd(payr0307Vo.getPayCd());    										/** column 급여구분코드 : payCd */
                       payr0302Vo.setPayrSeilNum(payr0307Vo.getPayrSeilNum());    							/** column 급여일련번호 : payrSeilNum */ 
                       payr0302Vo.setSystemkey(payr0307Vo.getSystemkey());    								/** column SYSTEMKEY : systemkey */
                       payr0302Vo.setPayItemCd(payr0307Vo.getPayItemCd());    								/** column 급여항목코드 : payItemCd */
                     //  payr0302Vo.setPayItemSeilNum(payr0307Vo.getPayItemSeilNum());    /** column 급여항목일련번호 : payItemSeilNum */
                       payr0302Vo.setPymtDducDivCd(payr0307Vo.getPymtDducDivCd());    						/** column 지급공제구분코드 : pymtDducDivCd */
                       payr0302Vo.setPymtDducFreeDtySum(payr0307Vo.getPymtDducFreeDtySum());    			/** column 지급공제비과세금액 : pymtDducFreeDtySum */
                       payr0302Vo.setPymtDducSum(payr0307Vo.getPymtDducSum());    							/** column 지급공제금액 : pymtDducSum */
                       payr0302Vo.setPayPymtDducPrcsFlag("N");    											/** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
                       payr0302Vo.setPayReattyAdmntVal(String.valueOf(payr0307Vo.getMnthPayAdmntSeilNum()));/** column 급여지급공제소급조정값 : payReattyAdmntVal */
                       payr0302Vo.setPymtDducTxtnAmnt(payr0307Vo.getPymtDducTxtnAmnt());    				/** column 지급공제과세금액 : pymtDducTxtnAmnt */
//                       payr0302Vo.setKybdr(payr0307Vo.getKybdr());    /** column 입력자 : kybdr */
//                       payr0302Vo.setInptDt(payr0307Vo.getInptDt());    /** column 입력일자 : inptDt */
//                       payr0302Vo.setInptAddr(payr0307Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//                       payr0302Vo.setIsmt(payr0307Vo.getIsmt());    /** column 수정자 : ismt */
//                       payr0302Vo.setRevnDt(payr0307Vo.getRevnDt());    /** column 수정일자 : revnDt */
//                       payr0302Vo.setRevnAddr(payr0307Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
                       Payr0302VO  tpPayr0302Vo = new Payr0302VO();   
                       
                       tpPayr0302Vo = payr0302DAO.selectPayr0302Payr0307(payr0302Vo); 
                       
                       if  (MSFSharedUtils.paramNotNull(tpPayr0302Vo) && MSFSharedUtils.paramNotNull(tpPayr0302Vo.getSystemkey())) {
                           payr0302DAO.updatePayr0302Payr0307(payr0302Vo);
                       } else {
                           payr0302DAO.insertPayr0302(payr0302Vo);
                       } 
                      
                       
                       break;
                   case DELETE: 
                       payr0307DAO.deletePayr0307(payr0307Vo);
                       
                       payr0302Vo.setDpobCd(payr0307Vo.getDpobCd());    									/** column 사업장코드 : dpobCd */
                       payr0302Vo.setPymtYrMnth(payr0307Vo.getPymtYrMnth());    							/** column 지급년월 : pymtYrMnth */
                       payr0302Vo.setPayCd(payr0307Vo.getPayCd());    										/** column 급여구분코드 : payCd */
                       payr0302Vo.setPayrSeilNum(payr0307Vo.getPayrSeilNum());    							/** column 급여일련번호 : payrSeilNum */ 
                       payr0302Vo.setSystemkey(payr0307Vo.getSystemkey());    								/** column SYSTEMKEY : systemkey */
                       payr0302Vo.setPayItemCd(payr0307Vo.getPayItemCd());    								/** column 급여항목코드 : payItemCd */
                     //  payr0302Vo.setPayItemSeilNum(payr0307Vo.getPayItemSeilNum());    /** column 급여항목일련번호 : payItemSeilNum */
                       payr0302Vo.setPymtDducDivCd(payr0307Vo.getPymtDducDivCd());    						/** column 지급공제구분코드 : pymtDducDivCd */
                       payr0302Vo.setPymtDducFreeDtySum(payr0307Vo.getPymtDducFreeDtySum());    			/** column 지급공제비과세금액 : pymtDducFreeDtySum */
                       payr0302Vo.setPymtDducSum(payr0307Vo.getPymtDducSum());    							/** column 지급공제금액 : pymtDducSum */
                       payr0302Vo.setPayPymtDducPrcsFlag("N");    											/** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
                       payr0302Vo.setPayReattyAdmntVal(String.valueOf(payr0307Vo.getMnthPayAdmntSeilNum()));/** column 급여지급공제소급조정값 : payReattyAdmntVal */
                       payr0302Vo.setPymtDducTxtnAmnt(payr0307Vo.getPymtDducTxtnAmnt());    				/** column 지급공제과세금액 : pymtDducTxtnAmnt */
//                       payr0302Vo.setKybdr(payr0307Vo.getKybdr());    /** column 입력자 : kybdr */
//                       payr0302Vo.setInptDt(payr0307Vo.getInptDt());    /** column 입력일자 : inptDt */
//                       payr0302Vo.setInptAddr(payr0307Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//                       payr0302Vo.setIsmt(payr0307Vo.getIsmt());    /** column 수정자 : ismt */
//                       payr0302Vo.setRevnDt(payr0307Vo.getRevnDt());    /** column 수정일자 : revnDt */
//                       payr0302Vo.setRevnAddr(payr0307Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
                       
                       payr0302DAO.deletePayr0302Payr0307(payr0302Vo);
                       
                       break;
                   }
                     
                   iCnt = iCnt + 1; 
                 
                
                    calPayr0302Vo.setDpobCd(payr0302Vo.getDpobCd());    						/** column 사업장코드 : dpobCd */
                    calPayr0302Vo.setPymtYrMnth(payr0302Vo.getPymtYrMnth());    				/** column 지급년월 : pymtYrMnth */
                    calPayr0302Vo.setPayCd(payr0302Vo.getPayCd());    							/** column 급여구분코드 : payCd */
                    calPayr0302Vo.setPayrSeilNum(payr0302Vo.getPayrSeilNum());    				/** column 급여일련번호 : payrSeilNum */
                    calPayr0302Vo.setSystemkey(payr0302Vo.getSystemkey());    					/** column SYSTEMKEY : systemkey */
                    calPayr0302Vo.setPayItemCd(payr0302Vo.getPayItemCd());    					/** column 급여항목코드 : payItemCd */
                    calPayr0302Vo.setPayItemSeilNum(payr0302Vo.getPayItemSeilNum());    		/** column 급여항목일련번호 : payItemSeilNum */ 
                    calPayr0302Vo.setPymtDducDivCd(payr0302Vo.getPymtDducDivCd());    			/** column 지급공제구분코드 : pymtDducDivCd */
                    calPayr0302Vo.setPymtDducFreeDtySum(payr0302Vo.getPymtDducFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                    calPayr0302Vo.setPymtDducSum(payr0302Vo.getPymtDducSum());    				/** column 지급공제금액 : pymtDducSum */
                    calPayr0302Vo.setPayPymtDducPrcsFlag(payr0302Vo.getPayPymtDducPrcsFlag());	/** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
                    calPayr0302Vo.setPayReattyAdmntVal(payr0302Vo.getPayReattyAdmntVal());    	/** column 급여지급공제소급조정값 : payReattyAdmntVal */
                    calPayr0302Vo.setKybdr(payr0302Vo.getKybdr());    							/** column 입력자 : kybdr */
                    calPayr0302Vo.setInptDt(payr0302Vo.getInptDt());    						/** column 입력일자 : inptDt */
                    calPayr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    					/** column 입력주소 : inptAddr */
                    calPayr0302Vo.setIsmt(payr0302Vo.getIsmt());    							/** column 수정자 : ismt */
                    calPayr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    						/** column 수정일자 : revnDt */
                    calPayr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    					/** column 수정주소 : revnAddr */
                    calPayr0302Vo.setPymtDducTxtnAmnt(payr0302Vo.getPymtDducTxtnAmnt());    	/** column 지급공제과세금액 : pymtDducTxtnAmnt */
 
               } 
            
            result = iCnt;
                
            if (result > 0) {

                /** 소득세/지방소득세 입력시 처리 루틴 추가 */
                if (ExtermsProps.getProps("PAY_DDUC_T00101").equals(Payr4200DducCheck)) {
                	calPayr0302Vo.setPayr4200DducCheck(Payr4200DducCheck); 
                	
                }  else {
                	calPayr0302Vo.setPayr4200DducCheck("");
                } 
            	PayrListenerAdapter payrAdapter = new PayrListenerAdapter(); 
            	result = (long) payrAdapter.setPayr4200ToPayCalcSeft(RemoteServiceUtil.getThreadLocalRequest(), calPayr0302Vo);
            }
            
            //급여 계산시 신규 항목 추가 처리를 위한 메서드 
            mutilInsertPayr0485();
            
        }catch (Exception ex) {
            
            result = new Long(0);
            throw MSFServerUtils.getOperationException("activityOnPayr4200", ex, logger);
        }
        finally {
          
        }
        
        return result;
    }  
     

	@Override
	public Long deletePayr4200(List<InfcPkgPayr0304DTO> listInfcPayr0304Dto ,ActionDatabase actionDatabase) throws MSFException  {
		// TODO Auto-generated method stub
		   Long result = new Long(1);
		   
			String windowNm = "급여내역조회관리";
			String windowId = "PAYR4201";
			
			String method = calledClass + ".deletePayr4200";
			MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	        try {
	           
	        	
	        	   for(int iPayrCnt=0;iPayrCnt < listInfcPayr0304Dto.size();iPayrCnt++) {
	                   

	   	        	Payr0300VO  payr0300Vo = new Payr0300VO();
	   	        	Payr0301VO  payr0301Vo = new Payr0301VO();
	   	        	Payr0301SrhVO  payr0301SrhVo = new Payr0301SrhVO();
	   	        	Payr0302VO  payr0302Vo = new Payr0302VO();
	   	        	Payr0304VO  payr0304Vo = new Payr0304VO();
	   	        	Payr0305VO  payr0305Vo = new Payr0305VO();
	   	        	Payr0306VO  payr0306Vo = new Payr0306VO();
	   	        	Payr0307VO  payr0307Vo = new Payr0307VO();
	   	        	Payr0309VO  payr0309Vo = new Payr0309VO();
	                   
	        		InfcPkgPayr0304DTO payr0304Dto = new InfcPkgPayr0304DTO();
	                   
	                payr0304Dto = listInfcPayr0304Dto.get(iPayrCnt);  
	        	
	        	
	                payr0300Vo.setDpobCd(payr0304Dto.getDpobCd());    						/** column 사업장코드 : dpobCd */
                    payr0300Vo.setPymtYrMnth(payr0304Dto.getPymtYrMnth());    				/** column 지급년월 : pymtYrMnth */ 
	                payr0300Vo.setPayCd(payr0304Dto.getPayCd());    						/** column 급여구분코드 : payCd */
	                payr0300Vo.setPayrSeilNum(new BigDecimal(payr0304Dto.getPayrSeilNum()));/** column 급여일련번호 : payrSeilNum */
	            
	//              payr0300Vo.setKybdr(payr0307Dto.getKybdr());    /** column 입력자 : kybdr */
	//              payr0300Vo.setInptDt(payr0307Dto.getInptDt());    /** column 입력일자 : inptDt */
	//              payr0300Vo.setInptAddr(payr0307Dto.getInptAddr());    /** column 입력주소 : inptAddr */
	//              payr0300Vo.setIsmt(payr0307Dto.getIsmt());    /** column 수정자 : ismt */
	//              payr0300Vo.setRevnDt(payr0307Dto.getRevnDt());    /** column 수정일자 : revnDt */
	//              payr0300Vo.setRevnAddr(payr0307Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
	              
		            BeanUtils.copyProperties(payr0301Vo, payr0300Vo); 
		            BeanUtils.copyProperties(payr0302Vo, payr0300Vo);  
		            BeanUtils.copyProperties(payr0305Vo, payr0300Vo);  
		            BeanUtils.copyProperties(payr0307Vo, payr0300Vo); 
		            BeanUtils.copyProperties(payr0304Vo, payr0300Vo);  
	                BeanUtils.copyProperties(payr0306Vo, payr0300Vo); 
	                BeanUtils.copyProperties(payr0309Vo, payr0300Vo);

	                payr0301Vo.setSystemkey(payr0304Dto.getSystemkey());    					/** column SYSTEMKEY : systemkey */
	                payr0302Vo.setSystemkey(payr0304Dto.getSystemkey());    					/** column SYSTEMKEY : systemkey */
	                payr0302Vo.setPayItemCd("");
	                payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);
	                payr0305Vo.setSystemkey(payr0304Dto.getSystemkey());    					/** column SYSTEMKEY : systemkey */
	                payr0304Vo.setSystemkey(payr0304Dto.getSystemkey());    					/** column SYSTEMKEY : systemkey */
	                payr0306Vo.setSystemkey(payr0304Dto.getSystemkey());    					/** column SYSTEMKEY : systemkey */
	                payr0307Vo.setSystemkey(payr0304Dto.getSystemkey());    					/** column SYSTEMKEY : systemkey */ 
	                payr0309Vo.setSystemkey(payr0304Dto.getSystemkey());    					/** column SYSTEMKEY : systemkey */ 
	                 
	                payr0301SrhVo.setDpobCd(payr0304Dto.getDpobCd());    						/** column 사업장코드 : dpobCd */
	                payr0301SrhVo.setPymtYrMnth(payr0304Dto.getPymtYrMnth());   				/** column 지급년월 : pymtYrMnth */  
	                payr0301SrhVo.setPayCd(payr0304Dto.getPayCd());    							/** column 급여구분코드 : payCd */
	                payr0301SrhVo.setPayrSeilNum(new BigDecimal(payr0304Dto.getPayrSeilNum()));	/** column 급여일련번호 : payrSeilNum */
		            
		            switch (actionDatabase) { 
		            case INSERT:
		            	//payr0307DAO.insertPayr0307(payr0307Vo);
		               break;
		            case UPDATE: 
		            	//payr0307DAO.updatePayr0307(payr0307Vo);
		                break;
		            case DELETE:
		             
		                payr0307DAO.deletePayr0307(payr0307Vo);
		                payr0309DAO.deletePayr0309(payr0309Vo);
	                    payr0306DAO.deletePayr0306(payr0306Vo); 
		                payr0305DAO.deletePayr0305(payr0305Vo);
		                payr0304DAO.deletePayr0304(payr0304Vo);
		                payr0302DAO.deletePayr0302(payr0302Vo);
		            	payr0301DAO.deletePayr0301(payr0301Vo); 
	 	            	

		            	  if  (pkgInsrService == null) { 
		                      WebApplicationContext wac = WebApplicationContextUtils.
		                              getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
		          
		                      pkgInsrService = (PkgInsrService) wac.getBean("PkgInsrService" ); 
		                     
		                 }  
		            	
		            	/*************************************************************************************/  
	            	    //2017.04.11 추가 모듈 
	            	    //급여 대상자 삭제시 4대보험 금액 초기화 처리 루틴 추가 
		            	//금액처리데이타가 존재하는지 확인 후 처리 
		            	  PkgInsrAmntVO pkgInsrAmntVo = new PkgInsrAmntVO();
		            	  PkgInsrAmntVO tpPkgInsrAmntVo = new PkgInsrAmntVO();
		            	  InfcPkgInsr3300VO infcPkgInsr3300Vo = new InfcPkgInsr3300VO();
		            	  InfcPkgInsr4200VO infcPkgInsr4200Vo = new InfcPkgInsr4200VO();
		            	
		            	  pkgInsrAmntVo.setDpobCd(payr0304Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
		            	  pkgInsrAmntVo.setNofctYrMnth(payr0304Dto.getPymtYrMnth());    /** column 고지년월 : nofctYrMnth */
		            //	pkgInsrAmntVo.setNofctDspty(pkgInsrAmntVo.getNofctDspty());    /** column 고지차수 : nofctDspty */
		            	  pkgInsrAmntVo.setSystemkey(payr0304Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
					//	pkgInsrAmntVo.setEmymtSeilNum(pkgInsrAmntVo.getEmymtSeilNum());    /** column 고용일련번호 : emymtSeilNum */
		            	  pkgInsrAmntVo.setHlthDducYrMnth(payr0304Dto.getPymtYrMnth());    /** column 공제년월 : dducYrMnth */	
		            	  
		            	  //4대보험 초기화 데이타가 존재하는지 여부 판단. 루틴 추가 
		            	  tpPkgInsrAmntVo =  pkgInsrService.selectPyar4200ToInsr(pkgInsrAmntVo);
		            	 
		            	  if ((new BigDecimal(MSFSharedUtils.defaultNulls(tpPkgInsrAmntVo.getHlthDducCnt(),"0"))).compareTo(BigDecimal.ZERO) > 0) {
		            		  //건강보험 
		            			infcPkgInsr3300Vo.setDpobCd(pkgInsrAmntVo.getDpobCd());    /** column 사업장코드 : dpobCd */
								infcPkgInsr3300Vo.setNofctYrMnth(pkgInsrAmntVo.getNofctYrMnth());    /** column 고지년월 : nofctYrMnth */
								infcPkgInsr3300Vo.setNofctDspty(pkgInsrAmntVo.getNofctDspty());    /** column 고지차수 : nofctDspty */
								infcPkgInsr3300Vo.setSystemkey(pkgInsrAmntVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
							//	infcPkgInsr3300Vo.setEmymtSeilNum(pkgInsrAmntVo.getEmymtSeilNum());    /** column 고용일련번호 : emymtSeilNum */
								infcPkgInsr3300Vo.setDducYrMnth(pkgInsrAmntVo.getHlthDducYrMnth());    /** column 공제년월 : dducYrMnth */
							//	infcPkgInsr3300Vo.setHlthInsrPrcsDt(pkgInsrAmntVo.getHlthInsrPrcsDt());    /** column 건강보험처리일자 : hlthInsrPrcsDt */
							//	infcPkgInsr3300Vo.setHlthInsrPrcsYn(pkgInsrAmntVo.getHlthInsrPrcsYn());    /** column 건강보험처리여부 : hlthInsrPrcsYn */
							 
							//	infcPkgInsr3300Vo.setDivdPymtDivCd(pkgInsrAmntVo.getDivdPymtDivCd());    /** column 분할납부구분코드 : divdPymtDivCd */
							//	infcPkgInsr3300Vo.setDivdPymt(pkgInsrAmntVo.getDivdPymt());    /** column 분할납부횟수 : divdPymt */
								infcPkgInsr3300Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
								infcPkgInsr3300Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */

			                   
			                   pkgInsrService.updatePayCancelInsr3300(infcPkgInsr3300Vo);
		            	  } 
		            	  
		            	  if ((new BigDecimal(MSFSharedUtils.defaultNulls(tpPkgInsrAmntVo.getNatPayrDducCnt(),"0"))).compareTo(BigDecimal.ZERO) > 0) {
		            		  //국민연금
		            		  
		            			infcPkgInsr4200Vo.setDpobCd(pkgInsrAmntVo.getDpobCd());    /** column 사업장코드 : dpobCd */
								infcPkgInsr4200Vo.setSystemkey(pkgInsrAmntVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
								infcPkgInsr4200Vo.setDducYrMnth(pkgInsrAmntVo.getHlthDducYrMnth());    /** column 공제년월 : dducYrMnth */
								infcPkgInsr4200Vo.setEmymtSeilNum(pkgInsrAmntVo.getEmymtSeilNum());    /** column 고용일련번호 : emymtSeilNum */
						 
								infcPkgInsr4200Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
								infcPkgInsr4200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
								infcPkgInsr4200Vo.setNatPayrDducYrMnth(pkgInsrAmntVo.getNatPayrDducYrMnth());    /** column 국민연금급여공제년월 : natPayrDducYrMnth */
							//	infcPkgInsr4200Vo.setNatInsrPrcsDt(pkgInsrAmntVo.getNatInsrPrcsDt());    /** column 국민연금처리일자 : natInsrPrcsDt */
							//	infcPkgInsr4200Vo.setNatInsrPrcsYn(pkgInsrAmntVo.getNatInsrPrcsYn());    /** column 국민연금처리여부 : natInsrPrcsYn */
							//	infcPkgInsr4200Vo.setNatInsrPrmmSrd(pkgInsrAmntVo.getNatInsrPrmmSrd());    /** column 국민연금차액 : natInsrPrmmSrd */
							//	infcPkgInsr4200Vo.setDivdPymtDivCd(pkgInsrAmntVo.getDivdPymtDivCd());    /** column 분할납부구분코드 : divdPymtDivCd */
							//	infcPkgInsr4200Vo.setDivdPymt(pkgInsrAmntVo.getDivdPymt());    /** column 분할납부회수 : divdPymt */

	         	    	       pkgInsrService.updatePayCancelInsr4200(infcPkgInsr4200Vo);
	         	    	       
		            	  } 
		            	  
		            	  if ((new BigDecimal(MSFSharedUtils.defaultNulls(tpPkgInsrAmntVo.getUmytPayrDducCnt(),"0"))).compareTo(BigDecimal.ZERO) > 0) {	  
		            		  //고용보험 
		            		  InfcPkgInsr5200VO infcPkgInsr5200Vo = new InfcPkgInsr5200VO();
		            		  
		            			infcPkgInsr5200Vo.setDpobCd(pkgInsrAmntVo.getDpobCd());    /** column 사업장코드 : dpobCd */
								infcPkgInsr5200Vo.setSystemkey(pkgInsrAmntVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
								infcPkgInsr5200Vo.setDducYrMnth(pkgInsrAmntVo.getHlthDducYrMnth());    /** column 납부년월 : dducYrMnth */
								infcPkgInsr5200Vo.setEmymtSeilNum(pkgInsrAmntVo.getEmymtSeilNum());    /** column 고용일련번호 : emymtSeilNum */
								 
								infcPkgInsr5200Vo.setUmytPayrDducYrMnth(pkgInsrAmntVo.getUmytPayrDducYrMnth());    /** column 고용보험급여공제년월 : umytPayrDducYrMnth */
								//infcPkgInsr5200Vo.setUmytInsrPrcsDt(pkgInsrAmntVo.getUmytInsrPrcsDt());    /** column 고용보험처리일자 : umytInsrPrcsDt */
								//infcPkgInsr5200Vo.setUmytInsrPrcsYn(pkgInsrAmntVo.getUmytInsrPrcsYn());    /** column 고용보험처리여부 : umytInsrPrcsYn */
							//	infcPkgInsr5200Vo.setUmytInsrPrmmSrd(pkgInsrAmntVo.getUmytInsrPrmmSrd());    /** column 개인실업급여고용보험차액 : umytInsrPrmmSrd */
							//	infcPkgInsr5200Vo.setDivdPymtDivCd(pkgInsrAmntVo.getDivdPymtDivCd());    /** column 분할납부구분코드 : divdPymtDivCd */
							//	infcPkgInsr5200Vo.setDivdPymt(pkgInsrAmntVo.getDivdPymt());    /** column 분할납부횟수 : divdPymt */
							 
								infcPkgInsr5200Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
								//infcPkgInsr5200Vo.setRevnDt(pkgInsrAmntVo.getRevnDt());    /** column 수정일자 : revnDt */
								infcPkgInsr5200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */

	        	    	       
	        	    	       pkgInsrService.updatePayCancelInsr5200(infcPkgInsr5200Vo);
	        	    	       
		            	  }
		            	  
		            	  /*************************************************************************************/
		            	
		                 int payr0301Cnt = payr0301DAO.selectPayr4200DelToPayr0301ListTotCnt(payr0301SrhVo); 
	 
		            	 if (payr0301Cnt == 0) { 
		            		 
		            	     payr0300DAO.deletePayr0300(payr0300Vo);  
		            	    
		            	 }
		            	
		                break;
		              }

	        	   }  
	        } catch (Exception ex) {
	        	
	            //logger.error("EXCEPTION calling activityOnVoceMenu(): "+ex); 
	            result = new Long(0);
	            ex.printStackTrace();
	            
				/** 에러 로그 **/			
				MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass, actionDatabase.toString(),ex, windowNm , windowId);

	            throw MSFServerUtils.getOperationException("deletePayr4200", ex, logger);
	            
	        } finally {
	          
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
	
	
	
 

@Override
public Long activityOnCalcPayr4200(Payr0307DTO payr0307dto) {
        Long result = new Long(0);
       
        try { 
               //소득세 재계산시 이전등록된 소득세 전체 삭제후 다시 계산함. 
        	
        	   // 소득세재계산처리인경우  307 테이블 소득세 삭제처리 후  초기화 하는 루틴 필요함 
                Payr0307VO  payr0307Vo = new Payr0307VO();
                InfcPkgPayr0302VO  calPayr0302Vo = new InfcPkgPayr0302VO();  
                   
                calPayr0302Vo.setDpobCd(payr0307dto.getDpobCd());    						/** column 사업장코드 : dpobCd */
                calPayr0302Vo.setPymtYrMnth(payr0307dto.getPymtYrMnth());    				/** column 지급년월 : pymtYrMnth */
                calPayr0302Vo.setPayCd(payr0307dto.getPayCd());    							/** column 급여구분코드 : payCd */
                calPayr0302Vo.setPayrSeilNum(new BigDecimal(payr0307dto.getPayrSeilNum())); /** column 급여일련번호 : payrSeilNum */
                calPayr0302Vo.setSystemkey(payr0307dto.getSystemkey());    					/** column SYSTEMKEY : systemkey */
                calPayr0302Vo.setPayr4200DducCheck("");
                
                // 소득세재계산처리인경우  307 테이블 소득세 삭제처리 후  초기화 하는 루틴 필요함 
                //++++++++++++++++++++++++++++++++++++++++++
                payr0307Vo.setDpobCd(calPayr0302Vo.getDpobCd());    									/** column 사업장코드 : dpobCd */
                payr0307Vo.setPymtYrMnth(calPayr0302Vo.getPymtYrMnth());    							/** column 지급년월 : pymtYrMnth */
                payr0307Vo.setPayCd(calPayr0302Vo.getPayCd());    										/** column 급여구분코드 : payCd */
                payr0307Vo.setPayrSeilNum(calPayr0302Vo.getPayrSeilNum());    							/** column 급여일련번호 : payrSeilNum */ 
                payr0307Vo.setSystemkey(calPayr0302Vo.getSystemkey());    								/** column SYSTEMKEY : systemkey */
            //    payr0307Vo.setPayItemCd(payr0307Vo.getPayItemCd());    								/** column 급여항목코드 : payItemCd */
              //  payr0307Vo.setPayItemSeilNum(payr0307Vo.getPayItemSeilNum());    /** column 급여항목일련번호 : payItemSeilNum */
                
//                BeanUtils.copyProperties(payr0307Vo, calPayr0302Vo); 
                
                payr0307Vo.setPayItemCd(ExtermsProps.getProps("PAY_DDUC_T00101"));
                payr0307DAO.deletePayr0307(payr0307Vo);
                

                payr0307Vo.setPayItemCd(ExtermsProps.getProps("PAY_DDUC_T00201"));
                payr0307DAO.deletePayr0307(payr0307Vo);
                
                Payr0302VO  payr0302Vo = new Payr0302VO();
                payr0302Vo.setDpobCd(calPayr0302Vo.getDpobCd());    									/** column 사업장코드 : dpobCd */
                payr0302Vo.setPymtYrMnth(calPayr0302Vo.getPymtYrMnth());    							/** column 지급년월 : pymtYrMnth */
                payr0302Vo.setPayCd(calPayr0302Vo.getPayCd());    										/** column 급여구분코드 : payCd */
                payr0302Vo.setPayrSeilNum(calPayr0302Vo.getPayrSeilNum());    							/** column 급여일련번호 : payrSeilNum */ 
                payr0302Vo.setSystemkey(calPayr0302Vo.getSystemkey());    								/** column SYSTEMKEY : systemkey */
            //    payr0302Vo.setPayItemCd(calPayr0302Vo.getPayItemCd());    								/** column 급여항목코드 : payItemCd */
              //  payr0302Vo.setPayItemSeilNum(calPayr0302Vo.getPayItemSeilNum());    /** column 급여항목일련번호 : payItemSeilNum */
                
                
                payr0302Vo.setPayItemCd(ExtermsProps.getProps("PAY_DDUC_T00101"));
                payr0302DAO.deletePayr0302(payr0302Vo);
                

                payr0302Vo.setPayItemCd(ExtermsProps.getProps("PAY_DDUC_T00201")); 
                payr0302DAO.deletePayr0302(payr0302Vo);
                //++++++++++++++++++++++++++++++++++++++++++
                
                //소득세계산호출 
                PayrListenerAdapter payrAdapter = new PayrListenerAdapter(); 
                result = (long) payrAdapter.setPayr4200ToPayCalcSeft(RemoteServiceUtil.getThreadLocalRequest(), calPayr0302Vo);
                
                 
                
        }
        catch (Exception ex) {
            
            result = new Long(0);
            throw MSFServerUtils.getOperationException("activityOnCalcPayr4200", ex, logger);
        }
        finally {
          
        }
        
        return result;
}
    
    
    
    
	/** 지급공제구분에 따른 지급공제항목 콤보박스로 가져옴 **/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<BaseModel> getPayDducExtpyCd(Payr0470DTO payr0470dDto) throws Exception {
		
		List<BaseModel> returnValue = new ArrayList<BaseModel>();
		List egovResultDataList = new ArrayList();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		String method = calledClass + ".getPayDducExtpyCd";
		
		String windowNm = "급여내역조회관리";
		String windowId = "PAYR4201";
		
		Payr0470SrhVO payr0470SrhVo = new Payr0470SrhVO();
		
//		payr0470SrhVo.setDpobCd(sessionUser.getDpobCd());		//사업장 코드
//		payr0470SrhVo.setPymtDducDivCd(MSFSharedUtils.allowNulls(payr0470SrhVo.getPymtDducDivCd()));	//지급공제구분
		
		payr0470SrhVo.setDpobCd(sessionUser.getDpobCd());		//사업장 코드
		payr0470SrhVo.setPymtDducDivCd(MSFSharedUtils.allowNulls(payr0470dDto.getPymtDducDivCd()));	//지급공제구분
		
		
		try{
			
			egovResultDataList = payr0470DAO.selectPayDducExtpyCd(payr0470SrhVo);
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					BaseModel bm = new BaseModel();
					Map tempMap = (Map)egovResultDataList.get(i);
					Iterator<String> keys = tempMap.keySet().iterator();
					while( keys.hasNext() ){
			            String key = keys.next();
			            //형 타입이 숫자형일경우 형변환 해준다.
		            	if(tempMap.get(key) instanceof java.math.BigDecimal){
		            		bm.set(key, String.valueOf(tempMap.get(key)));
		            	}else{
		            		bm.set(key, tempMap.get(key));
		            	}
		            }
					returnValue.add(bm);
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
		
		return returnValue;
	}

	 
	 /**
	  * 
	  * <pre>
	  * 1. 개요 : 수당처리 로직  
	  * 2. 처리내용 : 
	  * </pre>
	  * @Method Name : activityOnExtpyPayr4200
	  * @date : 2017. 7. 9.
	  * @author : atres
	  * @history : 
	  *	-----------------------------------------------------------------------
	  *	변경일				작성자						변경내용  
	  *	----------- ------------------- ---------------------------------------
	  *	2017. 7. 9.		atres				최초 작성 
	  *	-----------------------------------------------------------------------
	  * 
	  * @param listPayr0307dto
	  * @param actionDatabase
	  * @return
	  * @throws MSFException
	  */
	  @Override
	    public PagingLoadResult<ShowMessageBM>  activityOnExtpyPayr4200(List<Payr0302DTO> listPayr0302dto, ActionDatabase actionDatabase) throws MSFException  {
	     
		    Long result = new Long(0);
		    String Payr4200DducCheck = "";  //소득세주민세 여부 판단  
		    PagingLoadResult<ShowMessageBM> retval = null;
		    List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
		    
	        Long iCnt = new Long(0);
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	      
	        try { 
	             
	        	payr0305DAO = (Payr0305DAO)BeanFinder.getBean("Payr0305DAO");
	        	
	        	InfcPkgPayr0302VO  calPayr0302Vo = new InfcPkgPayr0302VO();  
	            
	            BigDecimal tpExtpyTotAmnt = BigDecimal.ZERO;   //수당금액 
	            BigDecimal tpTxtnTotAmnt = BigDecimal.ZERO; //과세금액  
	            BigDecimal tpFreeDtyTotAmnt = BigDecimal.ZERO; // 비과세금액 
	            BigDecimal freeDtySum = BigDecimal.ZERO;   // 비과세 적용금액  
	         
	            
	            if  (MSFSharedUtils.paramNull(payr0302DAO)) {
	                
	                WebApplicationContext wac = WebApplicationContextUtils.
	                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	                payr0302DAO = (Payr0302DAO) wac.getBean("Payr0302DAO" ); 
	            } 
	            
	         	// 1. 암호화 객체 생성
    	    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
            	
	            for(int iPayrCnt=0;iPayrCnt < listPayr0302dto.size();iPayrCnt++) { 
	           
	            	    tpExtpyTotAmnt = BigDecimal.ZERO;   //수당금액 
	                    tpTxtnTotAmnt = BigDecimal.ZERO; //과세금액  
	                    tpFreeDtyTotAmnt = BigDecimal.ZERO; // 비과세금액 
	                    freeDtySum = BigDecimal.ZERO;   // 비과세 적용금액  
	                
	                    Payr0302SrhVO   payr0302SrhVO = new Payr0302SrhVO();
	                    Payr0302DTO payr0302Dto = new Payr0302DTO();  
	                    payr0302Dto = listPayr0302dto.get(iPayrCnt); 
	 
	                    Payr0302VO  payr0302Vo = new Payr0302VO();
	                    Payr0302VO  tpPayr0302Vo = new Payr0302VO();
	                     
	                    
	                    //급여항목에 따른 등록된 건수전체를 불러와서 처리 해야 함. 
	                    payr0302SrhVO.setDpobCd(payr0302Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
	                    payr0302SrhVO.setPymtYrMnth(payr0302Dto.getPymtYrMnth());    /** column 지급년월 : pymtYrMnth */
	                    payr0302SrhVO.setPayCd(payr0302Dto.getPayCd());    /** column 급여구분코드 : payCd */
	                    payr0302SrhVO.setPayrSeilNum(new BigDecimal(payr0302Dto.getPayrSeilNum()));    /** column 급여일련번호 : payrSeilNum */
	                    payr0302SrhVO.setSystemkey(payr0302Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
	                    payr0302SrhVO.setPayItemCd(payr0302Dto.getPayItemCd());    /** column 급여항목코드 : payItemCd */
	                    
	                    List list = payr0302DAO.selectExtpyPayr0302List(payr0302SrhVO); 
	                    
	                    if (list.size() > 1) {
	                    	
	                       	 bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","수당수정","수당수정 - 조정내역존재함! 조정이존재하는경우 조정수정 요망." )); 
	                         retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());  
	                    	 return retval;
	                    	   
	                    } else {  
			                    
			        	        Iterator<Map<String, Object>> iter = list.iterator();
			        	            
			                    while ( iter.hasNext() ) {
			                    	
			                       Map<String, Object> extpyMap = (Map<String, Object>) iter.next(); 
			                       
			                       
			                       if (!"0".equals(MSFSharedUtils.allowNulls(extpyMap.get("payReattyAdmntVal")))) {
			                    	   
			                    		 bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","수당수정","수당수정 - 조정내역 자료는 조정내역에서 처리요망." )); 
				                         retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());  
				                    	 return retval;
			                       } else {
			                    
						                        payr0302Vo.setDpobCd(payr0302Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
							                    payr0302Vo.setPymtYrMnth(payr0302Dto.getPymtYrMnth());    /** column 지급년월 : pymtYrMnth */
							                    payr0302Vo.setPayCd(payr0302Dto.getPayCd());    /** column 급여구분코드 : payCd */
							                    payr0302Vo.setPayrSeilNum(new BigDecimal(payr0302Dto.getPayrSeilNum()));    /** column 급여일련번호 : payrSeilNum */
							                    payr0302Vo.setSystemkey(payr0302Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
							                    payr0302Vo.setPayItemCd(payr0302Dto.getPayItemCd());    /** column 급여항목코드 : payItemCd */
							                   payr0302Vo.setPayItemSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0302Dto.getPayItemSeilNum(),"0")));    /** column 급여항목일련번호 : payItemSeilNum */
							                    payr0302Vo.setPymtDducDivCd(payr0302Dto.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */
							              
							                    //지급공제비과세 금액 /지급공제금액/지급공제과세금액 분리작업  
							                    payr0302Vo.setPymtDducFreeDtySum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0302Dto.getPymtDducFreeDtySum(),"0")));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
							                    payr0302Vo.setPymtDducSum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0302Dto.getPymtDducSum(),"0")));    /** column 지급공제금액 : pymtDducSum */
							                 
							                    //소득세제외 여부 추가 처리을 위해 조건추가 함 
							             
							                    
									                    if ("B0080010".equals(payr0302Vo.getPymtDducDivCd())) {
									                    	
									                        if ("Y".equals(extpyMap.get("payPymtDducPrcsFlag"))) {
										                    	
										                    	payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column null : pymtDducTxtnAmnt */
										                    	
										                    } else {
											                        if (new BigDecimal(MSFSharedUtils.defaultNulls(payr0302Vo.getPymtDducTxtnAmnt(),"0")).compareTo(BigDecimal.ZERO) == 0) {
											                          
											                            if (new BigDecimal(MSFSharedUtils.defaultNulls(payr0302Vo.getPymtDducFreeDtySum(),"0")).compareTo(BigDecimal.ZERO) != 0) {
											                                
											                            	payr0302Vo.setPymtDducTxtnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(payr0302Vo.getPymtDducSum(),"0")).subtract(new BigDecimal(MSFSharedUtils.defaultNulls(payr0302Vo.getPymtDducFreeDtySum(),"0"))));    /** column null : pymtDducTxtnAmnt */ 
											                            
											                            } else {
											                                
											                            	payr0302Vo.setPymtDducTxtnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(payr0302Vo.getPymtDducSum(),"0")));    /** column null : pymtDducTxtnAmnt */ 
											                                 
											                            }
											                        } else {
											                            
											                            if (new BigDecimal(MSFSharedUtils.defaultNulls(payr0302Vo.getPymtDducFreeDtySum(),"0")).compareTo(BigDecimal.ZERO) != 0) {
											                                
											                            	payr0302Vo.setPymtDducTxtnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(payr0302Vo.getPymtDducSum(),"0")).subtract(new BigDecimal(MSFSharedUtils.defaultNulls(payr0302Vo.getPymtDducFreeDtySum(),"0"))));    /** column null : pymtDducTxtnAmnt */ 
											                            
											                            } else {
											                                
											                            	payr0302Vo.setPymtDducTxtnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(payr0302Vo.getPymtDducSum(),"0")));    /** column null : pymtDducTxtnAmnt */ 
											                                 
											                            }
											                        }
									                       
										                    }
									                    } else  if ("B0080020".equals(payr0302Vo.getPymtDducDivCd())) {
									                    	
									                        if ("Y".equals(extpyMap.get("payPymtDducPrcsFlag"))) {
										                    	
										                    	payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column null : pymtDducTxtnAmnt */
										                    	
										                    } else {
									                    
											                        if (new BigDecimal(MSFSharedUtils.defaultNulls(payr0302Vo.getPymtDducTxtnAmnt(),"0")).compareTo(BigDecimal.ZERO) == 0) {
											                            
											                            if (new BigDecimal(MSFSharedUtils.defaultNulls(payr0302Vo.getPymtDducFreeDtySum(),"0")).compareTo(BigDecimal.ZERO) != 0) {
											                                
											                            	payr0302Vo.setPymtDducTxtnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(payr0302Vo.getPymtDducSum(),"0")).subtract(new BigDecimal(MSFSharedUtils.defaultNulls(payr0302Vo.getPymtDducFreeDtySum(),"0"))));    /** column null : pymtDducTxtnAmnt */ 
											                            
											                            } else {
											                                
											                            	payr0302Vo.setPymtDducTxtnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(payr0302Vo.getPymtDducSum(),"0")));    /** column null : pymtDducTxtnAmnt */ 
											                                 
											                            }
											                        } else {
											                            
											                            if (new BigDecimal(MSFSharedUtils.defaultNulls(payr0302Vo.getPymtDducFreeDtySum(),"0")).compareTo(BigDecimal.ZERO) != 0) {
											                                
											                            	payr0302Vo.setPymtDducTxtnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(payr0302Vo.getPymtDducSum(),"0")).subtract(new BigDecimal(MSFSharedUtils.defaultNulls(payr0302Vo.getPymtDducFreeDtySum(),"0"))));    /** column null : pymtDducTxtnAmnt */ 
											                            
											                            } else {
											                                
											                            	payr0302Vo.setPymtDducTxtnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(payr0302Vo.getPymtDducSum(),"0")));    /** column null : pymtDducTxtnAmnt */ 
											                                 
											                            }
											                        }
										                    }
									                    }  else {
									                     
									                    	payr0302Vo.setPymtDducTxtnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(payr0302Vo.getPymtDducTxtnAmnt(),"0")));    /** column null : pymtDducTxtnAmnt */
									                    } 
							                   
							              
							                  payr0302Vo.setPayPymtDducPrcsFlag(MSFSharedUtils.allowNulls(extpyMap.get("payPymtDducPrcsFlag")));    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
								              payr0302Vo.setPayReattyAdmntVal(MSFSharedUtils.allowNulls(extpyMap.get("payReattyAdmntVal")));    /** column 급여지급공제소급조정값 : payReattyAdmntVal */ 
								            
								              
							               // payr0302Vo.setPyytYrtxDotnCd(payr0302Dto.getPyytYrtxDotnCd());    /** column 연말정산_기부금코드 : pyytYrtxDotnCd */
							               //  payr0302Vo.setPyytYtfeDtyReduCd(payr0302Dto.getPyytYtfeDtyReduCd());    /** column 연말정산_비과세감면코드 : pyytYtfeDtyReduCd */
							                    payr0302Vo.setKybdr(sessionUser.getUsrId());    												/** column 입력자 : kybdr */
							                    payr0302Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 입력주소 : inptAddr */
							                    payr0302Vo.setIsmt(sessionUser.getUsrId());    													/** column 수정자 : ismt */
							                    payr0302Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 수정주소 : revnAddr */
							                      
							                     
						                      switch (actionDatabase) { 
							                   case INSERT:
							                  
							                      break;
							                   case UPDATE: 
							                	    
							                           payr0302DAO.updatePayr0302Payr0307(payr0302Vo);
							                       
							                       break;
							                     case DELETE: 
							                     
							                       payr0302DAO.deletePayr0302Payr0307(payr0302Vo);
							                       
							                       break;
							                   }
			                         }
				               }  //while
			                    
				                     
				                   iCnt = iCnt + 1; 
				                 
				                   
				                    calPayr0302Vo.setDpobCd(payr0302Vo.getDpobCd());    						/** column 사업장코드 : dpobCd */
				                    calPayr0302Vo.setPymtYrMnth(payr0302Vo.getPymtYrMnth());    				/** column 지급년월 : pymtYrMnth */
				                    calPayr0302Vo.setPayCd(payr0302Vo.getPayCd());    							/** column 급여구분코드 : payCd */
				                    calPayr0302Vo.setPayrSeilNum(payr0302Vo.getPayrSeilNum());    				/** column 급여일련번호 : payrSeilNum */
				                    calPayr0302Vo.setSystemkey(payr0302Vo.getSystemkey());    					/** column SYSTEMKEY : systemkey */
				                    calPayr0302Vo.setPayItemCd(payr0302Vo.getPayItemCd());    					/** column 급여항목코드 : payItemCd */
				                    calPayr0302Vo.setPayItemSeilNum(payr0302Vo.getPayItemSeilNum());    		/** column 급여항목일련번호 : payItemSeilNum */ 
				                    calPayr0302Vo.setPymtDducDivCd(payr0302Vo.getPymtDducDivCd());    			/** column 지급공제구분코드 : pymtDducDivCd */
				                    calPayr0302Vo.setPymtDducFreeDtySum(payr0302Vo.getPymtDducFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
				                    calPayr0302Vo.setPymtDducSum(payr0302Vo.getPymtDducSum());    				/** column 지급공제금액 : pymtDducSum */
				                    calPayr0302Vo.setPayPymtDducPrcsFlag(payr0302Vo.getPayPymtDducPrcsFlag());	/** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
				                    calPayr0302Vo.setPayReattyAdmntVal(payr0302Vo.getPayReattyAdmntVal());    	/** column 급여지급공제소급조정값 : payReattyAdmntVal */
				                    calPayr0302Vo.setKybdr(payr0302Vo.getKybdr());    							/** column 입력자 : kybdr */
				                    calPayr0302Vo.setInptDt(payr0302Vo.getInptDt());    						/** column 입력일자 : inptDt */
				                    calPayr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    					/** column 입력주소 : inptAddr */
				                    calPayr0302Vo.setIsmt(payr0302Vo.getIsmt());    							/** column 수정자 : ismt */
				                    calPayr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    						/** column 수정일자 : revnDt */
				                    calPayr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    					/** column 수정주소 : revnAddr */
				                    calPayr0302Vo.setPymtDducTxtnAmnt(payr0302Vo.getPymtDducTxtnAmnt());    	/** column 지급공제과세금액 : pymtDducTxtnAmnt */
				                    calPayr0302Vo.setPayr4200DducCheck("");
			                    	
			        }	
			              
			            if (iCnt > 0) {
			            	
			            	// 소득세가 수정모드인지 판단하여 값을 넘겨야 함
			                /** 소득세/지방소득세 입력시 처리 루틴 추가 *********************************************/
			            	 Payr0305VO  payr0305Vo = new Payr0305VO(); 
			            	 calPayr0302Vo.setPayr4200DducCheck("");
			            	 
			            	 payr0305Vo.setDpobCd(calPayr0302Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
			            	 payr0305Vo.setPymtYrMnth(calPayr0302Vo.getPymtYrMnth());    /** column 지급년월 : pymtYrMnth */
			            	 payr0305Vo.setPayCd(calPayr0302Vo.getPayCd());    /** column 급여구분코드 : payCd */
			            	 payr0305Vo.setPayrSeilNum(calPayr0302Vo.getPayrSeilNum());    /** column 급여일련번호 : payrSeilNum */
			            	 payr0305Vo.setSystemkey(calPayr0302Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */ 
			                    
			            	 payr0305Vo = payr0305DAO.selectPayr0305(payr0305Vo); 
			            	  
			            	 if (MSFSharedUtils.paramNotNull(payr0305Vo) && MSFSharedUtils.paramNotNull(payr0305Vo.getSystemkey())
			            			   && ("Y".equals(MSFSharedUtils.defaultNulls(payr0305Vo.getMnlTxtbSimfYn(),"N")))) { 
			            	 
			                         	calPayr0302Vo.setPayr4200DducCheck(ExtermsProps.getProps("PAY_DDUC_T00101")); 
			                    
			            	 }  
			               /** 소득세/지방소득세 입력시 처리 루틴 추가 *********************************************/
			            
			            	 PayrListenerAdapter payrAdapter = new PayrListenerAdapter(); 
			            	result = (long) payrAdapter.setPayr4200ToPayCalcSeft(RemoteServiceUtil.getThreadLocalRequest(), calPayr0302Vo);
			            	
			            	if (result >= 0L) {
				                
			            		    bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Payr","[근로자]수당수정" ,"처리완료","근로자 수당확인 !" )); 
					                retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());
					                
			            	}
			            }
	            }   
	        }catch (Exception ex) {
	            
	        	   ShowMessageBM smBm = new ShowMessageBM();
	        	   smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR);
	        	   smBm.setMenu("Payr");
	        	   smBm.setPhase("[급여]수당수정에러");
	        	   smBm.setMessage(ex.getLocalizedMessage());
	        	   smBm.setContent(ex.getMessage());
	        	   bmResult.add(smBm);  
	        	   retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());  
	        	   
	             throw MSFServerUtils.getOperationException("activityOnExtpyPayr4200", ex, logger);
	        }
	        finally {
	          
	        }
	        
	        return retval;
	    }  
	     
	  /**
	   * 
	   * <pre>
	   * 1. 개요 :  공제로직  
	   * 2. 처리내용 : 
	   * </pre>
	   * @Method Name : activityOnDDucPayr4200
	   * @date : 2017. 7. 9.
	   * @author : atres
	   * @history : 
	   *	-----------------------------------------------------------------------
	   *	변경일				작성자						변경내용  
	   *	----------- ------------------- ---------------------------------------
	   *	2017. 7. 9.		atres				최초 작성 
	   *	-----------------------------------------------------------------------
	   * 
	   * @param listPayr0307dto
	   * @param actionDatabase
	   * @return
	   * @throws MSFException
	   */
	  @Override
	    public PagingLoadResult<ShowMessageBM>  activityOnDDucPayr4200(List<Payr0302DTO> listPayr0302dto, ActionDatabase actionDatabase) throws MSFException  {
		    Long result = new Long(0);
		    String Payr4200DducCheck = "";  //소득세주민세 여부 판단  
		    PagingLoadResult<ShowMessageBM> retval = null;
		    List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
		    MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		      
	        Long iCnt = new Long(0);
	        
	        try { 
	        	
	        	payr0302DAO = (Payr0302DAO)BeanFinder.getBean("Payr0302DAO");
	        	
	             
	            InfcPkgPayr0302VO  calPayr0302Vo = new InfcPkgPayr0302VO(); 
	            Payr0307SrhVO   payr0307SrhVO = new Payr0307SrhVO();
	            
	            BigDecimal tpExtpyTotAmnt = BigDecimal.ZERO;   //현수당금
	            BigDecimal tpTxtnTotAmnt = BigDecimal.ZERO; //과세금액  
	            BigDecimal tpFreeDtyTotAmnt = BigDecimal.ZERO; // 비과세금액 
	            BigDecimal freeDtySum = BigDecimal.ZERO;   // 비과세 적용금액  
	          
	        	// 1. 암호화 객체 생성
             	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	            
	            for(int iPayrCnt=0;iPayrCnt < listPayr0302dto.size();iPayrCnt++) {
	         
	            	
	            	    tpExtpyTotAmnt = BigDecimal.ZERO;   //현수당금
	                    tpTxtnTotAmnt = BigDecimal.ZERO; //과세금액  
	                    tpFreeDtyTotAmnt = BigDecimal.ZERO; // 비과세금액 
	                    freeDtySum = BigDecimal.ZERO;   // 비과세 적용금액  
	                
	                    Payr0302SrhVO   payr0302SrhVO = new Payr0302SrhVO();
	                    
	                    Payr0302DTO payr0302Dto = new Payr0302DTO();  
	                    payr0302Dto = listPayr0302dto.get(iPayrCnt); 
	 
	                    Payr0302VO  payr0302Vo = new Payr0302VO();
	                    Payr0302VO  tpPayr0302Vo = new Payr0302VO();
	                    
	                    
	                    //급여항목에 따른 등록된 건수전체를 불러와서 처리 해야 함. 
	                    payr0302SrhVO.setDpobCd(payr0302Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
	                    payr0302SrhVO.setPymtYrMnth(payr0302Dto.getPymtYrMnth());    /** column 지급년월 : pymtYrMnth */
	                    payr0302SrhVO.setPayCd(payr0302Dto.getPayCd());    /** column 급여구분코드 : payCd */
	                    payr0302SrhVO.setPayrSeilNum(new BigDecimal(payr0302Dto.getPayrSeilNum()));    /** column 급여일련번호 : payrSeilNum */
	                    payr0302SrhVO.setSystemkey(payr0302Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
	                    payr0302SrhVO.setPayItemCd(payr0302Dto.getPayItemCd());    /** column 급여항목코드 : payItemCd */
	                    
	                    List list = payr0302DAO.selectDducPayr0302List(payr0302SrhVO); 
	                    
	                    if (list.size() > 1) {
	                    	
	                       	 bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","공제수정","공제수정 - 조정내역존재함! 조정이존재하는경우 조정에서수정 요망." )); 
	                         retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());  
	                    	 return retval;
	                    	   
	                    } else { 
	                       
	                        Iterator<Map<String, Object>> iter = list.iterator();
	        	            
		                    while ( iter.hasNext() ) {
		                    	
		                       Map<String, Object> extpyMap = (Map<String, Object>) iter.next(); 
		                       
		                       if (!"0".equals(MSFSharedUtils.allowNulls(extpyMap.get("payReattyAdmntVal")))) {
			                    	
			                       	 bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"Payr","[급여]에러","공제수정","공제수정 - 조정내역존재함! 조정이존재하는경우 조정에서수정 요망." )); 
			                         retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());  
			                    	 return retval;  
			                    }
		                    
		                        payr0302Vo.setDpobCd(payr0302Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
			                    payr0302Vo.setPymtYrMnth(payr0302Dto.getPymtYrMnth());    /** column 지급년월 : pymtYrMnth */
			                    payr0302Vo.setPayCd(payr0302Dto.getPayCd());    /** column 급여구분코드 : payCd */
			                    payr0302Vo.setPayrSeilNum(new BigDecimal(payr0302Dto.getPayrSeilNum()));    /** column 급여일련번호 : payrSeilNum */
			                    payr0302Vo.setSystemkey(payr0302Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
			                    payr0302Vo.setPayItemCd(payr0302Dto.getPayItemCd());    /** column 급여항목코드 : payItemCd */
			                    payr0302Vo.setPayItemSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0302Dto.getPayItemSeilNum(),"0")));    /** column 급여항목일련번호 : payItemSeilNum */
			                    payr0302Vo.setPymtDducDivCd(payr0302Dto.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */
			              
			                    //지급공제비과세 금액 /지급공제금액/지급공제과세금액 분리작업  
			                    payr0302Vo.setPymtDducFreeDtySum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0302Dto.getPymtDducFreeDtySum(),"0")));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
			                    payr0302Vo.setPymtDducSum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0302Dto.getPymtDducSum(),"0")));    /** column 지급공제금액 : pymtDducSum */
			        	
			                    payr0302Vo.setPymtDducTxtnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(extpyMap.get("pymtDducTxtnAmnt"),"0")));    /** column null : pymtDducTxtnAmnt */ 
			              
			                    payr0302Vo.setPayPymtDducPrcsFlag(MSFSharedUtils.allowNulls(extpyMap.get("payPymtDducPrcsFlag")));    /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
				                payr0302Vo.setPayReattyAdmntVal(MSFSharedUtils.allowNulls(extpyMap.get("payReattyAdmntVal")));    /** column 급여지급공제소급조정값 : payReattyAdmntVal */ 
				                payr0302Vo.setPymtDducChgYn("Y");                                                         /** 급여지급공제변경여부 */
			                    payr0302Vo.setKybdr(sessionUser.getUsrId());    												/** column 입력자 : kybdr */
			                    payr0302Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 입력주소 : inptAddr */
			                    payr0302Vo.setIsmt(sessionUser.getUsrId());    													/** column 수정자 : ismt */
			                    payr0302Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 수정주소 : revnAddr */
			                    
			               
		                      switch (actionDatabase) { 
			                   case INSERT:
			                      break;
			                   case UPDATE: 
			                           payr0302DAO.updatePayr0302Payr0307(payr0302Vo);
			                       
			                    	   /** 소득세/지방소득세 입력시 처리 루틴 추가 */
					                    if (ExtermsProps.getProps("PAY_DDUC_T00101").equals(payr0302Vo.getPayItemCd())) {
					                    	Payr4200DducCheck = ExtermsProps.getProps("PAY_DDUC_T00101");
					                    } else   if (ExtermsProps.getProps("PAY_DDUC_T00201").equals(payr0302Vo.getPayItemCd())) {
					                    	Payr4200DducCheck = ExtermsProps.getProps("PAY_DDUC_T00101");
					                    } else {
					                    	
					                    } 
					                    
			                       break;
			                     case DELETE: 
			                    	 
			                       payr0302DAO.deletePayr0302Payr0307(payr0302Vo);
			                       
			                	   /** 소득세/지방소득세 입력시 처리 루틴 추가 */
				                    if (ExtermsProps.getProps("PAY_DDUC_T00101").equals(payr0302Vo.getPayItemCd())) {
				                    	Payr4200DducCheck = ExtermsProps.getProps("PAY_DDUC_T00101");
				                    } else   if (ExtermsProps.getProps("PAY_DDUC_T00201").equals(payr0302Vo.getPayItemCd())) {
				                    	Payr4200DducCheck = ExtermsProps.getProps("PAY_DDUC_T00101");
				                    } else {
				                    	
				                    } 
				                    
			                       break;
			                   }
		                     
			               }  //while
	                     
	                     
	                    iCnt = iCnt + 1; 
	                 
	                   
	                    calPayr0302Vo.setDpobCd(payr0302Vo.getDpobCd());    						/** column 사업장코드 : dpobCd */
	                    calPayr0302Vo.setPymtYrMnth(payr0302Vo.getPymtYrMnth());    				/** column 지급년월 : pymtYrMnth */
	                    calPayr0302Vo.setPayCd(payr0302Vo.getPayCd());    							/** column 급여구분코드 : payCd */
	                    calPayr0302Vo.setPayrSeilNum(payr0302Vo.getPayrSeilNum());    				/** column 급여일련번호 : payrSeilNum */
	                    calPayr0302Vo.setSystemkey(payr0302Vo.getSystemkey());    					/** column SYSTEMKEY : systemkey */
	                    calPayr0302Vo.setPayItemCd(payr0302Vo.getPayItemCd());    					/** column 급여항목코드 : payItemCd */
	                    calPayr0302Vo.setPayItemSeilNum(payr0302Vo.getPayItemSeilNum());    		/** column 급여항목일련번호 : payItemSeilNum */ 
	                    calPayr0302Vo.setPymtDducDivCd(payr0302Vo.getPymtDducDivCd());    			/** column 지급공제구분코드 : pymtDducDivCd */
	                    calPayr0302Vo.setPymtDducFreeDtySum(payr0302Vo.getPymtDducFreeDtySum());    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
	                    calPayr0302Vo.setPymtDducSum(payr0302Vo.getPymtDducSum());    				/** column 지급공제금액 : pymtDducSum */
	                    calPayr0302Vo.setPayPymtDducPrcsFlag(payr0302Vo.getPayPymtDducPrcsFlag());	/** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
	                    calPayr0302Vo.setPayReattyAdmntVal(payr0302Vo.getPayReattyAdmntVal());    	/** column 급여지급공제소급조정값 : payReattyAdmntVal */
	                    calPayr0302Vo.setKybdr(payr0302Vo.getKybdr());    							/** column 입력자 : kybdr */
	                    calPayr0302Vo.setInptDt(payr0302Vo.getInptDt());    						/** column 입력일자 : inptDt */
	                    calPayr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    					/** column 입력주소 : inptAddr */
	                    calPayr0302Vo.setIsmt(payr0302Vo.getIsmt());    							/** column 수정자 : ismt */
	                    calPayr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    						/** column 수정일자 : revnDt */
	                    calPayr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    					/** column 수정주소 : revnAddr */
	                    calPayr0302Vo.setPymtDducChgYn(payr0302Vo.getPymtDducChgYn());                                                         /** 급여지급공제변경여부 */
	                    calPayr0302Vo.setPymtDducTxtnAmnt(payr0302Vo.getPymtDducTxtnAmnt());    	/** column 지급공제과세금액 : pymtDducTxtnAmnt */
	                    calPayr0302Vo.setPayr4200DducCheck("");
	               } 
	             
			            if (iCnt > 0) {
			            	
			            	  /** 소득세/지방소득세 입력시 처리 루틴 추가 */
			                if (ExtermsProps.getProps("PAY_DDUC_T00101").equals(Payr4200DducCheck)) {
			                	calPayr0302Vo.setPayr4200DducCheck(Payr4200DducCheck); 
			                	
			                }  else {
			                	calPayr0302Vo.setPayr4200DducCheck("");
			                } 
			                
			            	
			            	PayrListenerAdapter payrAdapter = new PayrListenerAdapter(); 
			            	result = (long) payrAdapter.setPayr4200ToPayCalcSeft(RemoteServiceUtil.getThreadLocalRequest(), calPayr0302Vo);
			            	
			            	if (result >= 0L) {
				                
		            		    bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Payr","[근로자]공제수정" ,"처리완료","근로자 공제확인 !" )); 
				                retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());
				                
		            	   }
			            }
	            } 
	        }catch (Exception ex) {
	            
	        	  ShowMessageBM smBm = new ShowMessageBM();
	        	   smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR);
	        	   smBm.setMenu("Payr");
	        	   smBm.setPhase("[급여]공제수정에러");
	        	   smBm.setMessage(ex.getLocalizedMessage());
	        	   smBm.setContent(ex.getMessage());
	        	   bmResult.add(smBm);  
	        	   retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());  
	        	   
	               throw MSFServerUtils.getOperationException("activityOnDDucPayr4200", ex, logger);
	        }
	        finally {
	          
	        }
	        
	        return retval;
	    }  
	     
	  /**
	     * 
	     * <pre>
	     * 1. 개요 : 급여출력물 정보 지급항목 추가 쿼리 
	     * 2. 처리내용 : 
	     * </pre>
	     * @Method Name : mutilInsertPayr0485
	     * @date : 2018. 1. 11.
	     * @author : atres
	     * @history : 
	     *	-----------------------------------------------------------------------
	     *	변경일				작성자						변경내용  
	     *	----------- ------------------- ---------------------------------------
	     *	2018. 1. 11.		atres				최초 작성 
	     *	-----------------------------------------------------------------------
	     * 
	     * @return
	     * @throws MSFException
	     */
	    private Long mutilInsertPayr0485() throws MSFException  {
	        // TODO Auto-generated method stub
	        Long result = new Long(1);
	        try { 
	            
	        	payr0485DAO.mutilInsertPayr4150ToPayr0485_01(); 
	        	payr0485DAO.mutilInsertPayr4150ToPayr0485_02(); 
	        	payr0485DAO.mutilInsertPayr4150ToPayr0485_03(); 
	        	payr0485DAO.mutilInsertPayr4150ToPayr0485_04(); 
	        }
	        catch (Exception ex) {
	            logger.error("EXCEPTION calling mutilInsertPayr0485(): "+ex); 
	            result = new Long(0);
	            throw MSFServerUtils.getOperationException("mutilInsertPayr0485()", ex, logger);
	        }
	        finally {
	          
	        }
	        return result;
	    }





	    
	    //일괄정리 추가 6.22 -"145"
	@Override
	public Long activityOnPayr4201Save(Payr0304DTO payr0304Dto, ActionDatabase actionDatabase) throws MSFException  {
	    Long result = new Long(0);
	    Long iCnt = new Long(0);
	    
	    try { 
	    	
	    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	    	
	    	// 1. 암호화 객체 생성
//	    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	 
	        payr0304DAO = (Payr0304DAO)BeanFinder.getBean("Payr0304DAO");
	        
	        Payr0304SrhVO payr0304SrhVo = new Payr0304SrhVO(); 
	        
	       
	       
	        	
	        	// 1. 암호화 객체 생성
	        		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	                
	                /*payr0304Vo.setDpobCd(MSFSharedUtils.allowNulls(payr0304Dto.getDpobCd()));*/
	        		payr0304SrhVo.setDpobCd(sessionUser.getDpobCd()); /** column 사업장코드 : dpobCd */
	                payr0304SrhVo.setSystemkey(MSFSharedUtils.allowNulls(payr0304Dto.getSystemkey()));  //시스템키
	                payr0304SrhVo.setUsrId(sessionUser.getUsrId()); //유저아이디 d
	                payr0304SrhVo.setPymtYrMnth(MSFSharedUtils.allowNulls(payr0304Dto.getPymtYrMnth())); //지급년월   								
	                payr0304SrhVo.setPayCd(MSFSharedUtils.allowNulls(payr0304Dto.getPayCd()) ); //급여구분    										
	                payr0304SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(payr0304Dto.getPayrMangDeptCd()) );   //단위기관 			
	                payr0304SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(payr0304Dto.getEmymtDivCd()) );    //고용구분		
	                payr0304SrhVo.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(payr0304Dto.getRepbtyBusinDivCd()));  //호봉제  
	                payr0304SrhVo.setMangeDeptCd(MSFSharedUtils.allowNulls(payr0304Dto.getMangeDeptCd()) );    //관리부서	
	                /*payr0304SrhVo.setDeptGpCd(MSFSharedUtils.allowNulls(payr0304Dto.getDeptGpCd()) );*/   //그룹 
	                payr0304SrhVo.setDeptCd(MSFSharedUtils.allowNulls(payr0304Dto.getDeptCd()) );   //부서 						
	                payr0304SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(payr0304Dto.getTypOccuCd()));   //직종 
	                payr0304SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(payr0304Dto.getDtilOccuInttnCd())); //직종세통합    			
	                payr0304SrhVo.setBusinCd(MSFSharedUtils.allowNulls(payr0304Dto.getBusinCd()));    //사업						
	                payr0304SrhVo.setPymtDducDivCd(MSFSharedUtils.allowNulls(payr0304Dto.getPymtDducDivCd())); // 지급공제구분 
	                payr0304SrhVo.setPayItemCd(MSFSharedUtils.allowNulls(payr0304Dto.getPayItemCd())); // 지급공제항목
	                
	                payr0304SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(payr0304Dto.getDeptCd()).replace(",", "")); //권한처리
	                
	                payr0304SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	                
	                payr0304DAO.deletePayr0304All(payr0304SrhVo);
	                        
	                iCnt = iCnt + 1;
	                result = iCnt;
	      
	    }catch (Exception ex) {
	        logger.error("EXCEPTION calling activityOnPayr4201Save(): "+ex); 
	        result = new Long(0);
	        throw MSFServerUtils.getOperationException("activityOnPayr4201Save", ex, logger);
	    }finally {
	      
	    }
	    
	    return result;
	}
}
