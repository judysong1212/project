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

import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta2000DTO;
import com.app.exterms.yearendtax.client.service.yeta2016.Yeta1100Service;
import com.app.exterms.yearendtax.server.service.yeta2016.dao.Ye16Ta160401DAO;
import com.app.exterms.yearendtax.server.service.yeta2016.dao.Ye16Ta160402DAO;
import com.app.exterms.yearendtax.server.service.yeta2016.dao.Ye16Ta160403DAO;
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
import com.app.exterms.yearendtax.server.vo.Ye160401VO;
import com.app.exterms.yearendtax.server.vo.Ye160402VO;
import com.app.exterms.yearendtax.server.vo.Ye160403VO;
import com.app.exterms.yearendtax.server.vo.Yeta2000SrhVO;
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
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.sysif.msfpackage.server.utils.SysifPkgServiceUtils;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta2000VO;
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
@Service("Yeta1100Service")
public class Yeta1100ServiceImpl  extends AbstractCustomServiceImpl implements Yeta1100Service  ,YetaDaoConstants {

	private static final Logger logger = LoggerFactory.getLogger(Yeta1100ServiceImpl.class);
	private static final String calledClass = Yeta1100ServiceImpl.class.getName();
     
	// 현근무지급여
	@Autowired
	@Resource(name = "Ye16Ta160401DAO")
	private Ye16Ta160401DAO ye160401DAO;  
	
	// 과세
	@Autowired
	@Resource(name = "Ye16Ta160402DAO")
	private Ye16Ta160402DAO ye160402DAO;  
	
	// 비과세
	@Autowired
	@Resource(name = "Ye16Ta160403DAO")
	private Ye16Ta160403DAO ye160403DAO;  
	  
	// 연말정산 기본
	@Autowired
	@Resource(name = "Ye16Ta2000DAO")
	private Ye16Ta2000DAO yeta2000DAO;
	
	
	// 연말정산 상세
	@Autowired
    @Resource(name="Ye16Ta3000DAO")
    private Ye16Ta3000DAO yeta3000DAO;  
	
	
	// 연금저축공제
	@Autowired
    @Resource(name="Ye16Ta3100DAO")
    private Ye16Ta3100DAO yeta3100DAO; 
	  
	// 종전근무지
	@Autowired
    @Resource(name="Ye16Ta3110DAO")
    private Ye16Ta3110DAO yeta3110DAO;  
	
	// 거주자주택자금_금전소비대차
	@Autowired
	@Resource(name = "Ye16Ta3120DAO")
	private Ye16Ta3120DAO yeta3120DAO;

	// 주택자금_월세
	@Autowired
    @Resource(name="Ye16Ta3130DAO")
    private Ye16Ta3130DAO yeta3130DAO;  
  
	// 의료비
	@Autowired
	@Resource(name = "Ye16Ta3140DAO")
	private Ye16Ta3140DAO yeta3140DAO;
	
	
	// 교육비 가족사항
	@Autowired
	@Resource(name = "Ye16Ta3150DAO")
	private Ye16Ta3150DAO yeta3150DAO; 
	
	//거주자주택자금_임대차
    @Autowired
    @Resource(name="Ye16Ta3160DAO")
    private Ye16Ta3160DAO yeta3160DAO;  
    
    
    // 이월기부금
    @Autowired
    @Resource(name="Ye16Ta3170DAO")
    private Ye16Ta3170DAO yeta3170DAO; 
    
    // 기부금
    @Autowired
    @Resource(name="Ye16Ta3180DAO")
    private Ye16Ta3180DAO yeta3180DAO; 
    
    
    // 이월기부금
    @Autowired
    @Resource(name="Ye16Ta3190DAO")
    private Ye16Ta3190DAO yeta3190DAO; 
    
    // 가족사항
    @Autowired
    @Resource(name="Ye16Ta3220DAO")
    private Ye16Ta3220DAO yeta3220DAO; 
     
	  
	/**
	 * 연말정산대상자내역조회
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	  //조회
	  public PagingLoadResult<BaseModel> getYeta1100ToYe16Ta2000List(ServiceParameters serviceParameters) throws MSFException {

		PagingLoadResult<BaseModel> retval = null;
		// String method = "getPsnl0100ToRemt0100DataList";
		String method = CLASS_YETA1100ToYE16TA2000_LIST;
		Yeta2000SrhVO yeta2000SrhVo = new Yeta2000SrhVO();
		Yeta2000VO yeta2000Vo = new Yeta2000VO();
		List<BaseModel> bmResult = new ArrayList<BaseModel>();
	        
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	        if  (MSFSharedUtils.paramNull(yeta2000DAO)) {
	        
	            WebApplicationContext wac = WebApplicationContextUtils.
	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	            yeta2000DAO = (Ye16Ta2000DAO) wac.getBean("Ye16Ta2000DAO" ); 
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
	              
	            List<String> listDeptCd = new ArrayList<String>();
	            /** 조건절 */
	            yeta2000SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	            yeta2000SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	            yeta2000SrhVo.setUsrId(sessionUser.getUsrId());  
	              
	            
	            /******************************** 권한 ************************************************************************/
	            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	            if ("FALSE".equals(chkDeptCd)) {
	            	yeta2000SrhVo.setDeptCd(sessionUser.getDeptCd()); 
	               listDeptCd.add(sessionUser.getDeptCd());
	               yeta2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
	               yeta2000SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	            } else {
	            	    
	            	 yeta2000SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드
	                     if (yeta2000SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
	                     	 listDeptCd = null; 
	                     	yeta2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	                     	yeta2000SrhVo.setDeptCd("");  //부서코드
	                     } else {
	                    	 yeta2000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
	                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
	                          yeta2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	                     } 
	                  
	            }
	            
	            yeta2000SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
	            yeta2000SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));      
//	            String chkTypOccuCd = sessionUser.getAuthCheck().getAuthCheck04();
//	            if ("FALSE".equals(chkTypOccuCd)) {
//	            	//sysComSrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
//	            	//sysComSrhVo.setUsrId(sessionUser.getUsrId());
//	            } else {
//	            	
//	            }
	            
	           /******************************** 권한 ************************************************************************/ 
	      
	            
	            yeta2000SrhVo.setEdacRvyy(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "edacRvyy"))); //연말정산년
	            yeta2000SrhVo.setSettGbcd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "settGbcd")));  //연말정산구분코드  
	            
	           
	            yeta2000SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
	            
	            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
	            yeta2000SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
	            yeta2000SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
	           
//	            List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//	            yeta2000SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
//	            yeta2000SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
	             
	            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
	            yeta2000SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	            yeta2000SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세 
	            
	            yeta2000SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드 
	          
	            yeta2000SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
	            yeta2000SrhVo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명
	            

	            yeta2000SrhVo.setYetaDpcd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yetaDpcd")));				//원천신고부서
	            yeta2000SrhVo.setBusoprRgstnum(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "busoprRgstnum;")));	//사업자등록번호


		     	/************************과거 직종세에 해당하는 사람들 데이타 가져오기 **********************************************************/
//		      	SysIfBass0320VO  sysIfBass0320Vo = new SysIfBass0320VO();
//		     	 List<String> listTypCd = new ArrayList<String>(); 
//		     	 
//		     	sysIfBass0320Vo.setYmdGb("Y");
//		     	sysIfBass0320Vo.setStrDate(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutYr")));
//		     	sysIfBass0320Vo.setTypOccuCd(psnl0100SrhVO.getTypOccuCd());
//		     	sysIfBass0320Vo.setTypOccuCdArr(lstTypeOccuCd); 
//		     	
//		     	listTypCd = SysifPkgServiceUtils.funcArrBeforTypOccuCd(RemoteServiceUtil.getThreadLocalRequest(),sysIfBass0320Vo);
		     	
		     	SysIfBass0350VO  sysIfBass0350Vo = new SysIfBass0350VO();
		     //	 List<String> listTyInttnCd = new ArrayList<String>(); 
		     	sysIfBass0350Vo.setDpobCd(sessionUser.getDpobCd());
		     	sysIfBass0350Vo.setYmdGb("Y");
		     	sysIfBass0350Vo.setStrDate(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "edacRvyy")));
		     	sysIfBass0350Vo.setTypOccuCd(yeta2000SrhVo.getTypOccuCd());
		     	sysIfBass0350Vo.setTypOccuCdArr(lstTypeOccuCd);
		    	sysIfBass0350Vo.setDtilOccuInttnCd(yeta2000SrhVo.getDtilOccuInttnCd());
		     	sysIfBass0350Vo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
		     	
		     	sysIfBass0350Vo = SysifPkgServiceUtils.getFuncBeforDtilOccuInttnCd(RemoteServiceUtil.getThreadLocalRequest(),sysIfBass0350Vo); 
		     
		     	yeta2000SrhVo.setTypOccuCdArr(sysIfBass0350Vo.getRtnTypOccuCdArr());  
		     	yeta2000SrhVo.setDtilOccuInttnCdArr(sysIfBass0350Vo.getRtnDtilOccuInttnCdArr());   
		     	
		     	/************************과거 직종세에 해당하는 사람들 데이타 가져오기 **********************************************************/
//	            String strHdofcCodtnCd = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd"));
//	            
//	            List<String> listHdofcCodtnCd = new ArrayList<String>(); 
//	           
//	            String[] ray = strHdofcCodtnCd.substring(0, strHdofcCodtnCd.length()).split(",");
//	            
//	            for (int i=0; i<ray.length; i++){ 
//	                listHdofcCodtnCd.add(ray[i]);
//	            } 
//	            yeta2000SrhVo.setHdofcCodtnCdArr(listHdofcCodtnCd);    //재직상
//	            yeta2000SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));    //재직상
	            
	            
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	             if ( pagingValues.executeRecordCount ) { 
	                    
	                //Execute query that returns a single value
	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	                int iResultCnt = yeta2000DAO.selectYeta1100ToYeta2000ListTotCnt(yeta2000SrhVo);  
	                if (!pagingValues.pageExecute) { 
	                    pagingValues.offsetLimit = iResultCnt;       
	                }
	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	                pagingValues.totalRecordCount = iResultCnt;        
	                
	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	            }
	        
	            TimingInfo millisBeginPsnl0100ToRemt0100DataList = SmrmfUtils.startTiming(logger);
	        
	            /**페이지 카운트 처리를 위한 부분 */ 
	            yeta2000SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	            //Apply paging
	            if (pagingValues.start > 0) {
	                yeta2000SrhVo.setFirstIndex(pagingValues.start);
	            }
	            if (pagingValues.offsetLimit > 0) {
	                yeta2000SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
	            }

	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list  
	            List list = yeta2000DAO.selectYeta1100ToYeta2000List(yeta2000SrhVo);
	            
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
	                 		} else if("rsnoNumb".equals(tableAttributes[i].getName())) { 
		            			// 복호화
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
	            
	            SmrmfUtils.endTiming(logger, millisBeginPsnl0100ToRemt0100DataList, "getPsnl0100ToRemt0100DataList");
	       

		} catch (Exception ex) {
			ex.printStackTrace();
			// Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}

		return retval;
	}
	    

	  
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 연말정산 대상자 삭제  
	 * 2. 처리내용 : 선택된 연말정산 대상자를 삭제한다.
	 * </pre>
	 * @Method Name : Payr06420_Payr400_Delete
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
	public  Long YETA1100_TO_YETA2000_DELETE(List<Ye16Ta2000DTO> listYeta2000Dto) throws MSFException {
	    	
		String method = calledClass + ".YETA1100_TO_YETA2000_DELETE";
	
		String windowNm = "연말정산대상자관리";
		String windowId = "YETA1100";
	    	 
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	    		
		Long retval = 0L;
		BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);  
		
		Yeta3120VO yeta3120Vo = new Yeta3120VO(); // 거주자주택자금_금전소비대차
		Yeta3160VO yeta3160Vo = new Yeta3160VO(); // 거주자주택자금_임대차
		Yeta3100VO yeta3100Vo = new Yeta3100VO(); // 연금_저축공제
		Yeta3130VO yeta3130Vo = new Yeta3130VO(); // 주택자금_월세
		Yeta3140VO yeta3140Vo = new Yeta3140VO(); // 의료비
		Yeta3180VO yeta3180Vo = new Yeta3180VO(); // 기부금 명세
		Yeta3170VO yeta3170Vo = new Yeta3170VO(); // 이월기부금명세
		Yeta3190VO yeta3190Vo = new Yeta3190VO(); // 이월기부금temp
		Yeta3110VO yeta3110Vo = new Yeta3110VO(); // 종전근무지명세
//		Yeta3200VO yeta3200Vo = new Yeta3200VO(); // 비과세감면소득
		Yeta3220VO yeta3220Vo = new Yeta3220VO(); // 가족사항
		Yeta3150VO yeta3150Vo = new Yeta3150VO(); // 교육비
		// Yeta3210VO yeta3210Vo = new Yeta3210VO(); //급여내역
		Ye160401VO ye160401Vo = new Ye160401VO(); // 현근무지 급여지급 명세
		// Yeta3300VO yeta3300Vo = new Yeta3300VO(); //비과세감면소득정산
		Ye160402VO ye160402Vo = new Ye160402VO(); // 과세감면소득정산
		Ye160403VO ye160403Vo = new Ye160403VO(); // 비과세감면소득정산
		Yeta3000VO yeta3000Vo = new Yeta3000VO(); // 연말정산결과
			   
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		System.out.println("삭제자 : " + sessionUser.getDeptNm() + "["+ sessionUser.getUsrNm() + "]");
		
		
		try { 
            
		        	 
			for (int iCnt = 0; iCnt < listYeta2000Dto.size(); iCnt++) {

				Ye16Ta2000DTO yeta2000Dto = new Ye16Ta2000DTO(); 	// 연말정산기본 ;
				Yeta2000VO yeta2000Vo = new Yeta2000VO(); 		// 연말정산기본
				yeta2000Dto = listYeta2000Dto.get(iCnt);
		                	 
				//  BeanUtils.copyProperties(yeta2000Vo, yeta2000Dto);   
					  
				yeta2000Vo.setDpobCd(yeta2000Dto.getDpobCd());    							/** column 사업장코드 : dpobCd */
				yeta2000Vo.setEdacRvyy(yeta2000Dto.getEdacRvyy());    						/** column 연말정산귀속년도 : edacRvyy */
				yeta2000Vo.setSettGbcd(yeta2000Dto.getSettGbcd());    						/** column 정산구분코드 : settGbcd */
				yeta2000Vo.setSystemkey(yeta2000Dto.getSystemkey());    					/** column SYSTEMKEY : systemkey */
				yeta2000Vo.setEdacSeilNum(new BigDecimal(yeta2000Dto.getEdacSeilNum()));    /** column 연말정산마감일련번호 : edacSeilNum */
				yeta2000Vo.setPayrMangDeptCd(yeta2000Dto.getPayrMangDeptCd());    			/** column 급여관리부서코드 : payrMangDeptCd */
				yeta2000Vo.setEmymtDivCd(yeta2000Dto.getEmymtDivCd());    					/** column 고용구분코드 : emymtDivCd */
				yeta2000Vo.setHanNm(yeta2000Dto.getHanNm());    							/** column 한글성명 : hanNm */
//							yeta2000Vo.setResnRegnNum(yeta2000Dto.getResnRegnNum());    /** column 주민등록번호 : resnRegnNum */
				// 암호화
				yeta2000Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(yeta2000Dto.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));
							
				yeta2000Vo.setDeptCd(yeta2000Dto.getDeptCd());    							/** column 부서코드 : deptCd */
				yeta2000Vo.setBusinCd(yeta2000Dto.getBusinCd());    						/** column 사업코드 : businCd */
				yeta2000Vo.setTypOccuCd(yeta2000Dto.getTypOccuCd());    					/** column 직종코드 : typOccuCd */
				yeta2000Vo.setDtilOccuInttnCd(yeta2000Dto.getDtilOccuInttnCd());    		/** column 직종세통합코드 : dtilOccuInttnCd */
				yeta2000Vo.setDtilOccuClsDivCd(yeta2000Dto.getDtilOccuClsDivCd());    		/** column 직종세구분코드 : dtilOccuClsDivCd */
				yeta2000Vo.setOdtyCd(yeta2000Dto.getOdtyCd());    							/** column 직책코드 : odtyCd */
				yeta2000Vo.setPyspCd(yeta2000Dto.getPyspCd());    							/** column 호봉코드 : pyspCd */
				yeta2000Vo.setPyspGrdeCd(yeta2000Dto.getPyspGrdeCd());    					/** column 호봉등급코드 : pyspGrdeCd */
				yeta2000Vo.setLogSvcYrNumCd(yeta2000Dto.getLogSvcYrNumCd());    			/** column 근속년수코드 : logSvcYrNumCd */
				yeta2000Vo.setLogSvcMnthIcmCd(yeta2000Dto.getLogSvcMnthIcmCd());    		/** column 근속월수코드 : logSvcMnthIcmCd */
				yeta2000Vo.setFrstEmymtDt(yeta2000Dto.getFrstEmymtDt());    				/** column 최초고용일자 : frstEmymtDt */
				yeta2000Vo.setEmymtBgnnDt(yeta2000Dto.getEmymtBgnnDt());    				/** column 고용시작일자 : emymtBgnnDt */
				yeta2000Vo.setEmymtEndDt(yeta2000Dto.getEmymtEndDt());    					/** column 고용종료일자 : emymtEndDt */
				yeta2000Vo.setHdofcDivCd(yeta2000Dto.getHdofcDivCd());    					/** column 재직구분코드 : hdofcDivCd */
				yeta2000Vo.setRetryDt(yeta2000Dto.getRetryDt());    						/** column 퇴직일자 : retryDt */
				yeta2000Vo.setYrtxApptnYrMnth(yeta2000Dto.getYrtxApptnYrMnth());    		/** column 연말정산적용년월 : yrtxApptnYrMnth */
				yeta2000Vo.setYrtxPrcsDt(yeta2000Dto.getYrtxPrcsDt());    					/** column 연말정산처리일자 : yrtxPrcsDt */
//							yeta2000Vo.setYrtxPrcsYn(yeta2000Dto.getYrtxPrcsYn());    /** column 연말정산처리여부 : yrtxPrcsYn */
				yeta2000Vo.setYrtxPrcsYn((Boolean.TRUE.equals(yeta2000Dto.getYrtxPrcsYn()) ? "Y" : "N"));    /** column 연말정산처리여부 : yrtxPrcsYn */
				yeta2000Vo.setDivdPymtDivCd(yeta2000Dto.getDivdPymtDivCd());    			/** column 분할납부구분코드 : divdPymtDivCd */
							
				BeanUtils.copyProperties(yeta3120Vo, yeta2000Vo);
				BeanUtils.copyProperties(yeta3160Vo, yeta2000Vo);
				BeanUtils.copyProperties(yeta3100Vo, yeta2000Vo);
				BeanUtils.copyProperties(yeta3130Vo, yeta2000Vo);
				BeanUtils.copyProperties(yeta3170Vo, yeta2000Vo);
				BeanUtils.copyProperties(yeta3190Vo, yeta2000Vo);

				BeanUtils.copyProperties(yeta3140Vo, yeta2000Vo);
				BeanUtils.copyProperties(yeta3180Vo, yeta2000Vo);
				BeanUtils.copyProperties(yeta3110Vo, yeta2000Vo);
//				BeanUtils.copyProperties(ye160402Vo, yeta2000Vo);
				BeanUtils.copyProperties(yeta3220Vo, yeta2000Vo);
				BeanUtils.copyProperties(yeta3150Vo, yeta2000Vo);
//				BeanUtils.copyProperties(ye160401Vo, yeta2000Vo);
//				BeanUtils.copyProperties(ye160403Vo, yeta2000Vo);
				BeanUtils.copyProperties(yeta3000Vo, yeta2000Vo);
				
				
				ye160401Vo = new Ye160401VO(); // 현근무지 급여지급 명세
				ye160402Vo = new Ye160402VO(); // 과세감면소득정산
				ye160403Vo = new Ye160403VO(); // 비과세감면소득정산
				
				ye160401Vo.setDpobCd(yeta2000Dto.getDpobCd());
				ye160401Vo.setYrtxBlggYr(yeta2000Dto.getEdacRvyy());
				ye160401Vo.setClutSeptCd(yeta2000Dto.getSettGbcd());
				ye160401Vo.setSystemkey(yeta2000Dto.getSystemkey());
				
				BeanUtils.copyProperties(ye160402Vo, ye160401Vo);
				BeanUtils.copyProperties(ye160403Vo, ye160401Vo);
				
						  
				//  {-- 삭제처리 --} 
						    
				//	{의료비삭제} 
				yeta3140DAO.fnYeta1100_YETA3140_2016_CREATE_Delete(yeta3140Vo);	//yeta3140 
	                   
				//	{종전근무지삭제}
				yeta3110DAO.fnYeta1100_YETA3110_2016_CREATE_Delete(yeta3110Vo);	//yeta3110  종전근무지명세   
	                  
				//	{거주자주택자금_금전소비대차 삭제} 
				yeta3120DAO.fnYeta1100_YETA3120_2016_CREATE_Delete(yeta3120Vo);	//yeta3120  거주자주택자금_금전소비대차  
			             
				//	{거주자주택자금_임대차 삭제}
				yeta3160DAO.fnYeta1100_YETA3160_2016_CREATE_Delete(yeta3160Vo);	//yeta3160  거주자주택자금_임대차 
			           
				//	{연금_저축공제 삭제}
				yeta3100DAO.fnYeta1100_YETA3100_2016_CREATE_Delete(yeta3100Vo);	//yeta3100  연금_저축공제
			            
				//	{주택자금_월세 삭제}
				yeta3130DAO.fnYeta1100_YETA3130_2016_CREATE_Delete(yeta3130Vo);	//yeta3130  주택자금_월세
			             
				//	{이월기부금삭제}
			  	yeta3190DAO.fnYeta1100_YETA3190_2016_CREATE_Delete(yeta3190Vo);	//yeta3190 이월기부금삭제  

				//	{이월기부금삭제}  
			  	yeta3170DAO.fnYeta1100_YETA3170_2016_CREATE_Delete(yeta3170Vo);	//yeta3170 이월기부금삭제  
			      		
			  	//	{기부금삭제}
			  	yeta3180DAO.fnYeta1100_YETA3180_2016_CREATE_Delete(yeta3180Vo);	//yeta3180 기부금명세  
	                      
			  	//	{가족사항삭제}
			  	yeta3220DAO.fnYeta1100_YETA3220_2016_CREATE_Delete(yeta3220Vo);	//yeta3220 가족사항   
	
			  	//	{교육비가족사항삭제}
			  	yeta3150DAO.fnYeta1100_YETA3150_2016_CREATE_Delete(yeta3150Vo);	//yeta3150 교육사항    
			  
				//	[비과세감면내역 삭제 ]
			  	ye160403DAO.fnYeta1100_YE160403_2016_CREATE_Delete(ye160403Vo);	//ye160403Vo  비과세감면소득  
			  	
			  	//	{과세감면 정산 삭제 }
			  	ye160402DAO.fnYeta1100_YE160402_2016_CREATE_Delete(ye160402Vo);//yeta3300  과세감면소득정산   	 
	  		            
			  	//	{급여내역삭제}
			  	ye160401DAO.fnYeta1100_YE160401_2016_CREATE_Delete(ye160401Vo);//yeta3210 급여내역 삭제   
		  
			  	// 	{연말정산상세삭제}
			  	yeta3000DAO.fnYeta1100_YETA3000_2016_CREATE_Delete(yeta3000Vo);//yeta3000    
		  
			  	//	{연말정산기본삭제}
			  	yeta2000DAO.fnYeta1100_YETA2000_2016_CREATE_Delete(yeta2000Vo);//yeta2000  연말정산기본  
		  			   
		  			   
			}
			
			retval = 1L;
			
		}catch (Exception ex) {
		        	 
			logger.error("EXCEPTION calling Payr06420_Payr400_Delete(): "+ex); 
		            
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"D", ex, windowNm , windowId);
		            
			retval = 0L;
			throw MSFServerUtils.getOperationException("Payr06420_Payr400_Delete", ex, logger);
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
	  
	  
	  
    /**
     * 
     * <pre>
     * 1. 개요 : 선택된 대상자에 대해 급여자료을 이관한다. 
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : PayrExec_Yeta_Insert
     * @date : Jan 30, 2016
     * @author : leeheuisung
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	Jan 30, 2016		leeheuisung				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param listYeta2000Dto
     * @return
     * @throws MSFException
     */
    public  Long PayrExec_Yeta_2016_Insert(List<Ye16Ta2000DTO> listYeta2000Dto) throws MSFException {
	    	 
    	 
		String method = calledClass + ".PayrExec_Yeta_2016_Insert";

		String windowNm = "연말정산대상자관리";
		String windowId = "YETA1100";
    		
		Long retval = 0L;
		int delCnt = 0;
		BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		List<InfcPkgYeta2000VO> lstYetaPrc2000Vo = new ArrayList<InfcPkgYeta2000VO>(); // 연말정산기본
		
		Ye160401VO ye160401Vo = new Ye160401VO(); // 현근무지 급여지급 명세
		Ye160402VO ye160402Vo = new Ye160402VO(); // 과세감면소득정산
		Ye160403VO ye160403Vo = new Ye160403VO(); // 비과세감면소득정산
		
		
		try {

			for (int iCnt = 0; iCnt < listYeta2000Dto.size(); iCnt++) {
		            	 

				// 1. 암호화 객체 생성
				String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
       
				Ye16Ta2000DTO yeta2000Dto = new Ye16Ta2000DTO();  //연말정산기본  ;  
				InfcPkgYeta2000VO yeta2000Vo = new InfcPkgYeta2000VO();  //연말정산기본  
				yeta2000Dto = listYeta2000Dto.get(iCnt); 
	                	 
	        	     // BeanUtils.copyProperties(yeta2000Vo, yeta2000Dto);   

				yeta2000Vo.setDpobCd(yeta2000Dto.getDpobCd());    							/** column 사업장코드 : dpobCd */
				yeta2000Vo.setEdacRvyy(yeta2000Dto.getEdacRvyy());    						/** column 연말정산귀속년도 : edacRvyy */
				yeta2000Vo.setSettGbcd(yeta2000Dto.getSettGbcd());    						/** column 정산구분코드 : settGbcd */
				yeta2000Vo.setSystemkey(yeta2000Dto.getSystemkey());    					/** column SYSTEMKEY : systemkey */
				yeta2000Vo.setEdacSeilNum(new BigDecimal(yeta2000Dto.getEdacSeilNum()));	/** column 연말정산마감일련번호 : edacSeilNum */
				yeta2000Vo.setPayrMangDeptCd(yeta2000Dto.getPayrMangDeptCd());    			/** column 급여관리부서코드 : payrMangDeptCd */
				yeta2000Vo.setEmymtDivCd(yeta2000Dto.getEmymtDivCd());    					/** column 고용구분코드 : emymtDivCd */
				yeta2000Vo.setHanNm(yeta2000Dto.getHanNm());    							/** column 한글성명 : hanNm */
//						yeta2000Vo.setResnRegnNum(yeta2000Dto.getResnRegnNum());    /** column 주민등록번호 : resnRegnNum */
				// 암호화
				yeta2000Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(yeta2000Dto.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));
						
						
				yeta2000Vo.setDeptCd(yeta2000Dto.getDeptCd());    							/** column 부서코드 : deptCd */
				yeta2000Vo.setBusinCd(yeta2000Dto.getBusinCd());    						/** column 사업코드 : businCd */
				yeta2000Vo.setTypOccuCd(yeta2000Dto.getTypOccuCd());    					/** column 직종코드 : typOccuCd */
				yeta2000Vo.setDtilOccuInttnCd(yeta2000Dto.getDtilOccuInttnCd());    		/** column 직종세통합코드 : dtilOccuInttnCd */
				yeta2000Vo.setDtilOccuClsDivCd(yeta2000Dto.getDtilOccuClsDivCd());    		/** column 직종세구분코드 : dtilOccuClsDivCd */
				yeta2000Vo.setOdtyCd(yeta2000Dto.getOdtyCd());    							/** column 직책코드 : odtyCd */
				yeta2000Vo.setPyspCd(yeta2000Dto.getPyspCd());    							/** column 호봉코드 : pyspCd */
				yeta2000Vo.setPyspGrdeCd(yeta2000Dto.getPyspGrdeCd());    					/** column 호봉등급코드 : pyspGrdeCd */
				yeta2000Vo.setLogSvcYrNumCd(yeta2000Dto.getLogSvcYrNumCd());    			/** column 근속년수코드 : logSvcYrNumCd */
				yeta2000Vo.setLogSvcMnthIcmCd(yeta2000Dto.getLogSvcMnthIcmCd());    		/** column 근속월수코드 : logSvcMnthIcmCd */
				yeta2000Vo.setFrstEmymtDt(yeta2000Dto.getFrstEmymtDt());    				/** column 최초고용일자 : frstEmymtDt */
				yeta2000Vo.setEmymtBgnnDt(yeta2000Dto.getEmymtBgnnDt());    				/** column 고용시작일자 : emymtBgnnDt */
				yeta2000Vo.setEmymtEndDt(yeta2000Dto.getEmymtEndDt());    					/** column 고용종료일자 : emymtEndDt */
				yeta2000Vo.setHdofcDivCd(yeta2000Dto.getHdofcDivCd());    					/** column 재직구분코드 : hdofcDivCd */
				yeta2000Vo.setRetryDt(yeta2000Dto.getRetryDt());    						/** column 퇴직일자 : retryDt */
				yeta2000Vo.setYrtxApptnYrMnth(yeta2000Dto.getYrtxApptnYrMnth());    		/** column 연말정산적용년월 : yrtxApptnYrMnth */
				yeta2000Vo.setYrtxPrcsDt(yeta2000Dto.getYrtxPrcsDt());    					/** column 연말정산처리일자 : yrtxPrcsDt */
//						yeta2000Vo.setYrtxPrcsYn(yeta2000Dto.getYrtxPrcsYn());    /** column 연말정산처리여부 : yrtxPrcsYn */
				yeta2000Vo.setYrtxPrcsYn((Boolean.TRUE.equals(yeta2000Dto.getYrtxPrcsYn()) ? "Y" : "N"));
				yeta2000Vo.setDivdPymtDivCd(yeta2000Dto.getDivdPymtDivCd());    			/** column 분할납부구분코드 : divdPymtDivCd */
	        	      
				//	{급여내역삭제}
				// {******************************급여자료 이관 - 급여내역 삭제 [1]*******************************************}
				ye160401Vo = new Ye160401VO(); // 현근무지 급여지급 명세
				ye160402Vo = new Ye160402VO(); // 과세감면소득정산
				ye160403Vo = new Ye160403VO(); // 비과세감면소득정산
				
				
				ye160401Vo.setDpobCd(yeta2000Vo.getDpobCd());
				ye160401Vo.setYrtxBlggYr(yeta2000Vo.getEdacRvyy());
				ye160401Vo.setClutSeptCd(yeta2000Vo.getSettGbcd());
				ye160401Vo.setSystemkey(yeta2000Vo.getSystemkey());
				
	        	    
				BeanUtils.copyProperties(ye160402Vo, yeta2000Vo); 
				BeanUtils.copyProperties(ye160403Vo, yeta2000Vo); 
				
				
				ye160402Vo.setYrtxBlggYr(yeta2000Dto.getEdacRvyy());    						/** column 연말정산귀속년도 : edacRvyy */
				ye160402Vo.setClutSeptCd(yeta2000Dto.getSettGbcd());    						/** column 정산구분코드 : settGbcd */
				
				ye160403Vo.setYrtxBlggYr(yeta2000Dto.getEdacRvyy());    						/** column 연말정산귀속년도 : edacRvyy */
				ye160403Vo.setClutSeptCd(yeta2000Dto.getSettGbcd());    						/** column 정산구분코드 : settGbcd */
	        	     
//	        	yeta3200Vo.setSiteNumb("0000000000");
	        	//[비과세감면내역 삭제 ]
				ye160403DAO.fnYeta1100_YE160403_2016_CREATE_Delete(ye160403Vo);//ye160403Vo  비과세감면소득   	
	  			
	  			//[과세감면내역 삭제 ]
	  			ye160402DAO.fnYeta1100_YE160402_2016_CREATE_Delete(ye160402Vo);//ye160402Vo  과세감면소득   
	  		            
	  			//{급여내역삭제}
	  			ye160401DAO.fnYeta1100_YE160401_2016_CREATE_Delete(ye160401Vo);//ye160401Vo 급여내역 삭제
	  			
	  			lstYetaPrc2000Vo.add(yeta2000Vo);
		  			  
	  			delCnt = delCnt + 1;	
		  			 
			}	  
	        	  
			if (delCnt > 0) {

				Yeta1100ListenerAdapter yetaLsAdtr = new Yeta1100ListenerAdapter();
				// 컴포넌트 호출하기
				yetaLsAdtr.setPayrToYeta_Insert(RemoteServiceUtil.getThreadLocalRequest(), lstYetaPrc2000Vo);

			}
			
			retval = 1L;
			
		} catch (Exception ex) {

			logger.error("EXCEPTION calling Payr06420_Payr400_Delete(): " + ex);

			/** 에러 로그 **/
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser, method,calledClass, "C", ex, windowNm, windowId);

			retval = 0L;
			throw MSFServerUtils.getOperationException("Payr06420_Payr400_Delete", ex, logger);
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
	  
}
