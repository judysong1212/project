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
import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.utils.SmrmfUtils;
import org.msf.utils.TimingInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.exterms.yearendtax.client.dto.yeta2017.Ye161010DTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.Ye161020DTO;
import com.app.exterms.yearendtax.client.service.yeta2017.YetaP210001Service;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye160401DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye160402DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye160403DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye160404DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye160405DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye160406DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye160510DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye161005DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye161010DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye161020DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye161030DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye161040DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye161050DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye161055DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye161060DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye161070DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye161080DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye161090DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye162010DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye162020DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye162030DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye162040DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye162510DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye162520DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye162530DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye164010DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye165010DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye165020DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye165030DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye165030TempDAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye166010DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye166020DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye169010DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye169010aDAO;
import com.app.exterms.yearendtax.server.vo.InfcPsnl0100SrhVO;
import com.app.exterms.yearendtax.server.vo.Ye160401VO;
import com.app.exterms.yearendtax.server.vo.Ye160402VO;
import com.app.exterms.yearendtax.server.vo.Ye160403VO;
import com.app.exterms.yearendtax.server.vo.Ye160404VO;
import com.app.exterms.yearendtax.server.vo.Ye160405VO;
import com.app.exterms.yearendtax.server.vo.Ye160406VO;
import com.app.exterms.yearendtax.server.vo.Ye160510VO;
import com.app.exterms.yearendtax.server.vo.Ye161010VO;
import com.app.exterms.yearendtax.server.vo.Ye161020VO;
import com.app.exterms.yearendtax.server.vo.Ye161030VO;
import com.app.exterms.yearendtax.server.vo.Ye161040VO;
import com.app.exterms.yearendtax.server.vo.Ye161050VO;
import com.app.exterms.yearendtax.server.vo.Ye161055VO;
import com.app.exterms.yearendtax.server.vo.Ye161060VO;
import com.app.exterms.yearendtax.server.vo.Ye161070VO;
import com.app.exterms.yearendtax.server.vo.Ye161080VO;
import com.app.exterms.yearendtax.server.vo.Ye161090VO;
import com.app.exterms.yearendtax.server.vo.Ye162010VO;
import com.app.exterms.yearendtax.server.vo.Ye162020VO;
import com.app.exterms.yearendtax.server.vo.Ye162030VO;
import com.app.exterms.yearendtax.server.vo.Ye162040VO;
import com.app.exterms.yearendtax.server.vo.Ye162510VO;
import com.app.exterms.yearendtax.server.vo.Ye162520VO;
import com.app.exterms.yearendtax.server.vo.Ye162530VO;
import com.app.exterms.yearendtax.server.vo.Ye164010VO;
import com.app.exterms.yearendtax.server.vo.Ye165010VO;
import com.app.exterms.yearendtax.server.vo.Ye165020VO;
import com.app.exterms.yearendtax.server.vo.Ye165030TempVO;
import com.app.exterms.yearendtax.server.vo.Ye165030VO;
import com.app.exterms.yearendtax.server.vo.Ye166010VO;
import com.app.exterms.yearendtax.server.vo.Ye166020VO;
import com.app.exterms.yearendtax.server.vo.Ye169010VO;
import com.app.exterms.yearendtax.server.vo.Ye169010aVO;
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
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010VO;
import com.app.smrmf.pkg.listener.yeta.yeta2017.Yeta2100ListenerAdapter;
import com.ext.constants.PropPayGenConfs;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

/**
 * 
* <pre>
* 1. 패키지명 : com.app.exterms.yearendtax.server.service
* 2. 타입명 : YetaP210001ServiceImpl.java
* 3. 작성일 : Jan 13, 2016 5:12:49 PM
* 4. 작성자 : leeheuisung
* 5. 설명 :
* </pre>
 */
@Service("YetaP210001Service")
public class YetaP210001ServiceImpl  extends AbstractCustomServiceImpl implements YetaP210001Service  ,YetaDaoConstants {

	 
	private static final Logger logger = LoggerFactory.getLogger(YetaP210001ServiceImpl.class);
	private static final String calledClass = YetaP210001ServiceImpl.class.getName();
 
		
	@Autowired
	@Resource(name = "Ye160401DAO")
	private Ye160401DAO ye160401DAO; //현근무지급여지급명세
	@Autowired
	@Resource(name = "Ye160402DAO")
	private Ye160402DAO  ye160402DAO;//현근무지비과세_감면소득_과세
	@Autowired
	@Resource(name = "Ye160403DAO")
	private Ye160403DAO  ye160403DAO;//현근무지비과세_감면소득_비과세
	@Autowired
	@Resource(name = "Ye160404DAO")
	private Ye160404DAO  ye160404DAO;//D_종전근무처
	@Autowired
	@Resource(name = "Ye160405DAO")
	private Ye160405DAO  ye160405DAO;//D_종전근무처비과세_감면소득_비과세
	@Autowired
	@Resource(name = "Ye160406DAO")
	private Ye160406DAO  ye160406DAO;//종전근무지연금보험료_공적연금
	@Autowired
	@Resource(name = "Ye160510DAO")
	private Ye160510DAO  ye160510DAO;//근무지별비과세_감면소득
	            
	@Autowired
	@Resource(name = "Ye161005DAO")
	private Ye161005DAO  ye161005DAO;//A_원천세신고기본
	            
	@Autowired
	@Resource(name = "Ye161010DAO")
	private Ye161010DAO  ye161010DAO;// 연말정산대상자기본
	@Autowired
	@Resource(name = "Ye161020DAO")
	private Ye161020DAO  ye161020DAO;//A_인적소득공제기본
	@Autowired
	@Resource(name = "Ye161030DAO")
	private Ye161030DAO  ye161030DAO;//E_인적공제명세
	@Autowired
	@Resource(name = "Ye161040DAO")
	private Ye161040DAO  ye161040DAO;//E_소득세액공제명세
	@Autowired
	@Resource(name = "Ye161050DAO")
	private Ye161050DAO  ye161050DAO;//C_연금보험료공제
	@Autowired
	@Resource(name = "Ye161055DAO")
	private Ye161055DAO  ye161055DAO;//C_연금보험료_공적연금상세
	@Autowired
	@Resource(name = "Ye161060DAO")
	private Ye161060DAO  ye161060DAO;//C_특별소득공제
	@Autowired
	@Resource(name = "Ye161070DAO")
	private Ye161070DAO  ye161070DAO;//C_그밖의소득공제
	@Autowired
	@Resource(name = "Ye161080DAO")
	private Ye161080DAO  ye161080DAO;//C_세액감면및공제
	@Autowired
	@Resource(name = "Ye161090DAO")
	private Ye161090DAO  ye161090DAO;//C_교육비내역
	@Autowired
	@Resource(name = "Ye162010DAO")
	private Ye162010DAO  ye162010DAO;//F_연금저축계좌
	@Autowired
	@Resource(name = "Ye162020DAO")
	private Ye162020DAO  ye162020DAO;//F_퇴직연금계좌명세
	@Autowired
	@Resource(name = "Ye162030DAO")
	private Ye162030DAO  ye162030DAO;//F_주택마련저축
	@Autowired
	@Resource(name = "Ye162040DAO")
	private Ye162040DAO  ye162040DAO;//F_장기집합투자증권저축_B1013
	@Autowired
	@Resource(name = "Ye162510DAO")
	private Ye162510DAO  ye162510DAO;//G_월세액소득공제명세
	@Autowired
	@Resource(name = "Ye162520DAO")
	private Ye162520DAO  ye162520DAO;//G_거주자간_금전소비대차
	@Autowired
	@Resource(name = "Ye162530DAO")
	private Ye162530DAO  ye162530DAO;//G_임대차계약
	@Autowired
	@Resource(name = "Ye164010DAO")
	private Ye164010DAO ye164010DAO; //A_의료비지급명세
	@Autowired
	@Resource(name = "Ye165010DAO")
	private Ye165010DAO  ye165010DAO;//I_해당연도기부금명세
	@Autowired
	@Resource(name = "Ye165020DAO")
	private Ye165020DAO  ye165020DAO;//I_기부자관계코드별기부금합계
	@Autowired
	@Resource(name = "Ye165030DAO")
	private Ye165030DAO  ye165030DAO;//H_기부금조정명세
	@Autowired
	@Resource(name = "Ye165030TempDAO")
	private Ye165030TempDAO ye165030TempDAO;    //H_기부금조정명세_TEMP	 
	@Autowired
	@Resource(name = "Ye166010DAO")
	private Ye166010DAO  ye166010DAO;//신용카드등소득공제명세
	@Autowired
	@Resource(name = "Ye166020DAO")
	private Ye166020DAO  ye166020DAO;//신용카드등소득공제상세
		 
	@Autowired
	@Resource(name = "Ye169010DAO")
	private Ye169010DAO ye169010DAO; //C_주현근무처
	@Autowired
	@Resource(name = "Ye169010aDAO")
	private Ye169010aDAO ye169010aDAO; //C_주현근무처_표준공제 
	    
	/**
	 * 연말정산대상자조회
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	//조회
	public PagingLoadResult<BaseModel> getYetaP210001ToPsnl0100DataList(ServiceParameters serviceParameters) throws MSFException {
		

		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETAP210001_TO_PSNL0100_DATA_LIST;
		InfcPsnl0100SrhVO   psnl0100SrhVO = new InfcPsnl0100SrhVO();
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
	     	psnl0100SrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
	      	psnl0100SrhVO.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));	// 정산구분 
	     	psnl0100SrhVO.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));		// 귀속년도
	     	psnl0100SrhVO.setUtDpobCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "srhUtDpobCd")));		// 단위사업장
	     	psnl0100SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	     	
	     	psnl0100SrhVO.setUsrId(sessionUser.getUsrId());
            /******************************** 권한 ************************************************************************/
            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
            if ("FALSE".equals(chkDeptCd)) {
            	
            	if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"),sessionUser.getDeptCd()))) {
               	 

                	psnl0100SrhVO.setDeptCd(sessionUser.getDeptCd()); 
                   listDeptCd.add(sessionUser.getDeptCd());
                   psnl0100SrhVO.setDeptCdArr(listDeptCd);     //부서코드  
           	 } else {
           		 
           		 psnl0100SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                 listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                 psnl0100SrhVO.setDeptCdArr(listDeptCd);     //부서코드    
           	 }  
            	  
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
            
            psnl0100SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
            psnl0100SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));   
            
           /******************************** 권한 ************************************************************************/
	     	
	    	List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));  
	       	psnl0100SrhVO.setHdofcCodtnCdArr(listHdofcCodtnCd);     //부서코드 
	      	psnl0100SrhVO.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));			//재직코드
	     	
	     	psnl0100SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));      		//고용구분코드
	            
	       	List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
	      	psnl0100SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
	     	psnl0100SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  	//직종
	             
	      	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
	      	psnl0100SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	     	psnl0100SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
	             
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
	                 
	          	int iResultCnt = ye161010DAO.selectYetaP210001ToPsnl0100ListTotCnt(psnl0100SrhVO);  
	              
	          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
	          	
	          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                
	         	pagingValues.totalRecordCount = iResultCnt;	       
	                
	        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
	        
	     	TimingInfo millisBeginYetaP210001ToPsnl0100DataList = SmrmfUtils.startTiming(logger);
	        
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
	     	List list = ye161010DAO.selectYetaP210001ToPsnl0100List(psnl0100SrhVO);
	            
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
	            
			SmrmfUtils.endTiming(logger, millisBeginYetaP210001ToPsnl0100DataList, "getYetaP210001ToPsnl0100DataList");
	       
		} catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	
	
	/** 연말정산 대상자 생성  **/
	@Override
	public PagingLoadResult<ShowMessageBM> saveYetaP210001ToYe161010(List<Ye161010DTO> listYe161010Dto,List<Ye161020DTO> listYe161020Dto, ActionDatabase actionDatabase) throws  MSFException {
		
		String method = calledClass + ".saveYetaP210001ToYe161010";
		
		String windowNm = "연말정산대상자검색";
		String windowId = "YETAP210001";
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		 
		int result = 0; 
		int iCnt = 0;
		
		BigDecimal seqn = new BigDecimal(0);
		PagingLoadResult<ShowMessageBM> retval = null;
	  	List<InfcPkgYe161010VO> listYe161010VO = new ArrayList<InfcPkgYe161010VO>();
		List<ShowMessageBM> bmResult = new ArrayList<ShowMessageBM>();
		
		try{
			
            for(int iYetaCnt=0; iYetaCnt < listYe161020Dto.size(); iYetaCnt++) {
                
            	if(0L < Yeta210001_All_Delete(listYe161020Dto)) {
            	 
            		Ye161010DTO ye161010Dto = new Ye161010DTO();  
	            	Ye161020DTO ye161020Dto = new Ye161020DTO();  
	            	Ye161010VO  ye161010Vo = new Ye161010VO();
	        		Ye161020VO  ye161020Vo = new Ye161020VO();
	        		
	            	InfcPkgYe161010VO infcPkgYe161010Vo = new InfcPkgYe161010VO();
	            	ye161010Dto = listYe161010Dto.get(iYetaCnt); 
	            	ye161020Dto = listYe161020Dto.get(iYetaCnt);  
	            	

	            	/**
	            	 * +++++++++++++검색조건 넘김 INSERT 시작 +++++++++++++
	            	 * */	
	            	   /** 조건절 */
	            	ye161010Vo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	            	ye161010Vo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	            	ye161010Vo.setUsrId(sessionUser.getUsrId());   
    		      
	            	ye161010Vo.setSrhPayrMangDeptCd(ye161010Dto.getSrhPayrMangDeptCd());    	/** column 급여관리부서코드 : payrMangDeptCd */
	            	ye161010Vo.setSrhEmymtDivCd(ye161010Dto.getSrhEmymtDivCd());    			/** column 고용구분코드 : emymtDivCd */
    			 	ye161010Vo.setSrhDeptCd(ye161010Dto.getSrhDeptCd());    					/** column 부서코드 : deptCd */
	            	ye161010Vo.setSrhBusinCd(ye161010Dto.getSrhBusinCd());    					/** column 사업코드 : businCd */
	            	ye161010Vo.setSrhTypOccuCd(ye161010Dto.getSrhTypOccuCd());    				/** column 직종코드 : typOccuCd */
    				ye161010Vo.setSrhDtilOccuInttnCd(ye161010Dto.getSrhDtilOccuInttnCd());		/** column 직종세통합코드 : dtilOccuInttnCd */
    			 	 
	            	
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
	            	ye161010Vo.setPernChrgEmpIdenNum(sessionUser.getUsrId());    									/** column 생성직원번호 : pernChrgEmpIdenNum */
	            	ye161010Vo.setClosFlag("N");    																/** column 마감여부 : closFlag */
	            	ye161010Vo.setClosCont(new BigDecimal(0));    													/** column 마감건수 : closCont */
	            	ye161010Vo.setClosDate("");    																	/** column 마감일자 : closDate */
	            	ye161010Vo.setEdacPrdt("");    																	/** column 연말정산제출일자 : edacPrdt */
	            	ye161010Vo.setKybdr(sessionUser.getUsrId());    												/** column 입력자 : kybdr */
	            	ye161010Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 입력주소 : inptAddr */
	            	ye161010Vo.setIsmt(sessionUser.getUsrId());    													/** column 수정자 : ismt */
	            	ye161010Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 수정주소 : revnAddr */
	            	
	            	//ye161010DAO.insertYe161010(ye161010Vo);
	            	
	            	/**
	            	 * +++++++++++++ YE161020 INSERT 시작 +++++++++++++
	            	 * */
//	            	ye161020Vo.setDpobCd(sessionUser.getDpobCd());    																/** column 사업장코드 : dpobCd */
//	            	ye161020Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161020Dto.getYrtxBlggYr()));    							/** column 귀속연도 : yrtxBlggYr */
//	            	ye161020Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye161020Dto.getClutSeptCd()));    							/** column 연말정산구분코드 : clutSeptCd */
//	            	ye161020Vo.setSystemkey(MSFSharedUtils.allowNulls(ye161020Dto.getSystemkey()));    								/** column SYSTEMKEY : systemkey */
//	            	ye161020Vo.setFnm(ye161020Dto.getFnm());    																	/** column 소득자성명 : fnm */
//	            	ye161020Vo.setResnoEncCntn(AnyCryptUtils.getEncSyncCrypt(nResult, MSFSharedUtils.allowNulls(ye161020Dto.getResnoEncCntn()).replaceAll("-",""), AnyCryptUtils.SEC_RRNUMC));																			/** column 주민등록번호 : resnoEncCntn */
//	            	ye161020Vo.setTnm(MSFSharedUtils.allowNulls(ye161020Dto.getTnm()));    											/** column 근무처명 : tnm */
//	            	ye161020Vo.setBsnoEncCntn(MSFSharedUtils.allowNulls(ye161020Dto.getBsnoEncCntn()));    							/** column 사업자등록번호 : bsnoEncCntn */
//	            	ye161020Vo.setHshrClCd(MSFSharedUtils.allowNulls("A0190001".equals(ye161020Dto.getHshrClCd())? "Y" : "N"));		/** column 세대주여부 : hshrClCd */
//	            	ye161020Vo.setRsplNtnInfrNm(MSFSharedUtils.allowNulls(ye161020Dto.getRsplNtnInfrNm()));    						/** column 국적 : rsplNtnInfrNm */
//	            	ye161020Vo.setRsplNtnInfrCd(MSFSharedUtils.allowNulls(ye161020Dto.getRsplNtnInfrCd()));    						/** column 국적코드 : rsplNtnInfrCd */
//	            	ye161020Vo.setDtyStrtDt(MSFSharedUtils.allowNulls(ye161020Dto.getDtyStrtDt()));    								/** column 근무기간시작일자 : dtyStrtDt */
//	            	ye161020Vo.setDtyEndDt(MSFSharedUtils.allowNulls(ye161020Dto.getDtyEndDt()));    								/** column 근무기간종료일자 : dtyEndDt */
//	            	ye161020Vo.setReStrtDt(MSFSharedUtils.allowNulls(ye161020Dto.getReStrtDt()));    								/** column 감면기간시작일자 : reStrtDt */
//	            	ye161020Vo.setReEndDt(MSFSharedUtils.allowNulls(ye161020Dto.getReEndDt()));    									/** column 감면기간종료일자 : reEndDt */
//	            	ye161020Vo.setRsdtClCd(MSFSharedUtils.allowNulls(ye161020Dto.getRsdtClCd()));    								/** column 거주구분 : rsdtClCd */
//	            	ye161020Vo.setRsplNtnNm(MSFSharedUtils.allowNulls(ye161020Dto.getRsplNtnNm()));    								/** column 거주지국명 : rsplNtnNm */
//	            	ye161020Vo.setRsplNtnCd(MSFSharedUtils.allowNulls(ye161020Dto.getRsplNtnCd()));    								/** column 거주지코드 : rsplNtnCd */
//	            	ye161020Vo.setInctxWhtxTxamtMetnCd(MSFSharedUtils.allowNulls(ye161020Dto.getInctxWhtxTxamtMetnCd()));    		/** column 소득세원천징수세액조정구분코드 : inctxWhtxTxamtMetnCd */
//	            	ye161020Vo.setInpmYn(ye161020Dto.getInpmYn());    																/** column 분납신청여부 : inpmYn */
//	            	ye161020Vo.setPrifChngYn(ye161020Dto.getPrifChngYn());    														/** column 인적공제항목변동여부 : prifChngYn */
//	            	ye161020Vo.setBscDdcnFpCnt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161020Dto.getBscDdcnFpCnt(), "0")));    /** column 기본공제인원수 : bscDdcnFpCnt */
//	            	ye161020Vo.setSccNfpCnt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161020Dto.getSccNfpCnt(), "0")));    		/** column 경로우대인원수 : sccNfpCnt */
//	            	ye161020Vo.setChbtAdopNfpCnt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161020Dto.getChbtAdopNfpCnt(), "0")));/** column 출산입양인원수 : chbtAdopNfpCnt */
//	            	ye161020Vo.setWmnNfpCnt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161020Dto.getWmnNfpCnt(), "0")));    		/** column 부녀자인원수 : wmnNfpCnt */
//	            	ye161020Vo.setSnprntNfpCnt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161020Dto.getSnprntNfpCnt(), "0")));    /** column 한부모인원수 : snprntNfpCnt */
//	            	ye161020Vo.setDsbrNfpCnt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161020Dto.getDsbrNfpCnt(), "0")));    	/** column 자애인인원수 : dsbrNfpCnt */
//	            	ye161020Vo.setAge6ltNfpCnt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161020Dto.getAge6ltNfpCnt(), "0")));    /** column 6세이하인원수 : age6ltNfpCnt */
//	            	ye161020Vo.setFileSbtYn(ye161020Dto.getFileSbtYn());    														/** column 소득공제신고전자파일제출여부 : fileSbtYn */
//	            	ye161020Vo.setFileAppYn(ye161020Dto.getFileAppYn());    														/** column 소득공제신고전자파일적용여부 : fileAppYn */
//	            	ye161020Vo.setFormCd(ye161020Dto.getFormCd());    																/** column 서식코드 : formCd */
//	            	ye161020Vo.setIssDtSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(ye161020Dto.getIssDtSeilNum(), "0")));    /** column 발급일자일련번호 : issDtSeilNum */
//	            	ye161020Vo.setKybdr(sessionUser.getUsrId());    																/** column 입력자 : kybdr */
//	            	ye161020Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    							/** column 입력주소 : inptAddr */
//	            	ye161020Vo.setIsmt(sessionUser.getUsrId());    																	/** column 수정자 : ismt */
//	            	ye161020Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    							/** column 수정주소 : revnAddr */
	            	
	            	//ye161020DAO.insertYe161020(ye161020Vo);
	            	        
	            	BeanUtils.copyProperties(infcPkgYe161010Vo, ye161010Vo);  
	            	listYe161010VO.add(infcPkgYe161010Vo);
	            	
	            	iCnt = iCnt + 1;
              }
            } 
            
            if (iCnt > 0) {

	        	Yeta2100ListenerAdapter yetaLsAdtr = new Yeta2100ListenerAdapter();
		    	//컴포넌트 호출하기 
	        	retval = yetaLsAdtr.setYetaP210001ToAll_Create(RemoteServiceUtil.getThreadLocalRequest(), listYe161010VO);  
            
            } 
            result = iCnt;
        	bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "급여대상자생성.","데이타확인",""));  
        	
		}catch(Exception e){
			
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass, actionDatabase.toString(), e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
			
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, actionDatabase.toString());
		
		return retval;
		
	}
		
	private  Long Yeta210001_All_Delete(List<Ye161020DTO> listYe161020Dto) throws MSFException {
    	
		String method = calledClass + ".Yeta210001_All_Delete";

		String windowNm = "연말정산대상자관리";
		String windowId = "YETA210001";

		Long retval = 1L;

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());


		Ye160401VO    ye160401Vo	 = new  Ye160401VO();	//현근무지급여지급명세
		Ye160402VO    ye160402Vo	 = new  Ye160402VO();	//현근무지비과세_감면소득_과세
		Ye160403VO    ye160403Vo	 = new  Ye160403VO();	//현근무지비과세_감면소득_비과세
		Ye160404VO    ye160404Vo	 = new  Ye160404VO();	//D_종전근무처
		Ye160405VO    ye160405Vo	 = new  Ye160405VO();	//D_종전근무처비과세_감면소득_비과세
		Ye160406VO    ye160406Vo	 = new  Ye160406VO();	//종전근무지연금보험료_공적연금
		Ye160510VO    ye160510Vo	 = new  Ye160510VO();	//근무지별비과세_감면소득
			      			        
		//Ye161005VO    ye161005Vo	 = new  Ye161005VO();	//A_원천세신고기본
			       			        
		Ye161010VO    ye161010Vo	 = new  Ye161010VO();	// 연말정산대상자기본
		
		Ye161020VO    ye161020Vo	 = new  Ye161020VO();	//A_인적소득공제기본
		Ye161030VO    ye161030Vo	 = new  Ye161030VO();	//E_인적공제명세
		Ye161040VO    ye161040Vo	 = new  Ye161040VO();	//E_소득세액공제명세
		Ye161050VO    ye161050Vo	 = new  Ye161050VO();	//C_연금보험료공제
		Ye161055VO    ye161055Vo	 = new  Ye161055VO();	//C_연금보험료_공적연금상세
		Ye161060VO    ye161060Vo	 = new  Ye161060VO();	//C_특별소득공제
		Ye161070VO    ye161070Vo	 = new  Ye161070VO();	//C_그밖의소득공제
		Ye161080VO    ye161080Vo	 = new  Ye161080VO();	//C_세액감면및공제
		Ye161090VO    ye161090Vo	 = new  Ye161090VO();	//C_교육비내역
		Ye162010VO    ye162010Vo	 = new  Ye162010VO();	//F_연금저축계좌
		Ye162020VO    ye162020Vo	 = new  Ye162020VO();	//F_퇴직연금계좌명세
		Ye162030VO    ye162030Vo	 = new  Ye162030VO();	//F_주택마련저축
		Ye162040VO    ye162040Vo	 = new  Ye162040VO();	//F_장기집합투자증권저축_B1013
		Ye162510VO    ye162510Vo	 = new  Ye162510VO();	//G_월세액소득공제명세
		Ye162520VO    ye162520Vo	 = new  Ye162520VO();	//G_거주자간_금전소비대차
		Ye162530VO    ye162530Vo	 = new  Ye162530VO();	//G_임대차계약
		Ye164010VO    ye164010Vo	 = new  Ye164010VO();	//A_의료비지급명세
		Ye165010VO    ye165010Vo	 = new  Ye165010VO();	//I_해당연도기부금명세
		Ye165020VO    ye165020Vo	 = new  Ye165020VO();	//I_기부자관계코드별기부금합계
		Ye165030VO    ye165030Vo	 = new  Ye165030VO();	//H_기부금조정명세
		Ye165030TempVO ye165030TempVo = new  Ye165030TempVO();  	    //H_기부금조정명세_TEMP	 
		Ye166010VO     ye166010Vo	 = new  Ye166010VO();	//신용카드등소득공제명세
		Ye166020VO     ye166020Vo	 = new  Ye166020VO();	//신용카드등소득공제상세
							 //
		Ye169010VO     ye169010Vo	 = new  Ye169010VO();	//C_주현근무처
		Ye169010aVO    ye169010AVo = new  Ye169010aVO();	//C_주현근무처_표준공제 
		 	
		BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);   	
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		 	  
		try {
				  
			for(int i = 0; i < listYe161020Dto.size(); i ++) {
				
				Ye161020DTO ye161020Dto = new Ye161020DTO();  
            	InfcPkgYe161010VO infcPkgYe161010Vo = new InfcPkgYe161010VO();
            	ye161020Dto = listYe161020Dto.get(i);    
			  
            	 
            	ye161010Vo.setDpobCd(ye161020Dto.getDpobCd());    		/** column null : dpobCd */
            	ye161010Vo.setYrtxBlggYr(ye161020Dto.getYrtxBlggYr());    /** column 귀속연도 : yrtxBlggYr */
            	ye161010Vo.setClutSeptCd(ye161020Dto.getClutSeptCd());   	/** column 연말정산구분코드 : clutSeptCd */	
            	ye161010Vo.setSystemkey(ye161020Dto.getSystemkey());	/** column SYSTEMKEY : systemkey */ 
				
				
				//월급여 사항 이전근무지 포함             	
 //           	BeanUtils.copyProperties(ye160401Vo, ye161010Vo);
//				BeanUtils.copyProperties(ye160402Vo, ye161010Vo);
//				BeanUtils.copyProperties(ye160403Vo, ye161010Vo);
//				BeanUtils.copyProperties(ye160404Vo, ye161010Vo);
//				BeanUtils.copyProperties(ye160405Vo, ye161010Vo);
//				BeanUtils.copyProperties(ye160406Vo, ye161010Vo);
//				BeanUtils.copyProperties(ye160510Vo, ye161010Vo);
//				
//				BeanUtils.copyProperties(ye161020Vo, ye161010Vo);
//				BeanUtils.copyProperties(ye161030Vo, ye161010Vo);
//				BeanUtils.copyProperties(ye161040Vo, ye161010Vo);
//				BeanUtils.copyProperties(ye161050Vo, ye161010Vo); 
//				BeanUtils.copyProperties(ye161055Vo, ye161010Vo);
//				
//				BeanUtils.copyProperties(ye161060Vo, ye161010Vo);
//				BeanUtils.copyProperties(ye161070Vo, ye161010Vo);
//				BeanUtils.copyProperties(ye161080Vo, ye161010Vo);
//				BeanUtils.copyProperties(ye161090Vo, ye161010Vo);
//				BeanUtils.copyProperties(ye162010Vo, ye161010Vo);
//				BeanUtils.copyProperties(ye162020Vo, ye161010Vo);
//				BeanUtils.copyProperties(ye162030Vo, ye161010Vo);
//				BeanUtils.copyProperties(ye162040Vo, ye161010Vo);
//				BeanUtils.copyProperties(ye162510Vo, ye161010Vo);
//				BeanUtils.copyProperties(ye162520Vo, ye161010Vo);
//				BeanUtils.copyProperties(ye162530Vo, ye161010Vo);
//				BeanUtils.copyProperties(ye164010Vo, ye161010Vo);
//				BeanUtils.copyProperties(ye165010Vo, ye161010Vo);
//				BeanUtils.copyProperties(ye165020Vo, ye161010Vo);
//				BeanUtils.copyProperties(ye165030Vo, ye161010Vo);
//				BeanUtils.copyProperties(ye165030TempVo, ye161010Vo);
//				BeanUtils.copyProperties(ye166010Vo, ye161010Vo);
//				BeanUtils.copyProperties(ye166020Vo, ye161010Vo);
//				BeanUtils.copyProperties(ye169010Vo, ye161010Vo);
//				BeanUtils.copyProperties(ye169010AVo, ye161010Vo);
				
			
				/**  Ye160401VO    //현근무지급여지급명세     **/
				//ye160401DAO.deleteYetaP210001_Ye160401VO_2017_Delete(ye160401Vo);	 
				
				/**  Ye160402VO    //현근무지비과세_감면소득_과세   **/
				//ye160402DAO.deleteYetaP210001_Ye160402VO_2017_Delete(ye160402Vo);	
				
				/**  Ye160403VO    //현근무지비과세_감면소득_비과세   **/
				//ye160403DAO.deleteYetaP210001_Ye160403VO_2017_Delete(ye160403Vo);	
				
				/**  Ye160404VO    //D_종전근무처   **/
				//ye160404DAO.deleteYetaP210001_Ye160404VO_2017_Delete(ye160404Vo);	
				
				/**  Ye160405VO    //D_종전근무처비과세_감면소득_비과세   **/
				//ye160405DAO.deleteYetaP210001_Ye160405VO_2017_Delete(ye160405Vo);	
				
				/**  Ye160406VO    //종전근무지연금보험료_공적연금   **/
				//ye160406DAO.deleteYetaP210001_Ye160406VO_2017_Delete(ye160406Vo);	
				
				/**  Ye160510VO    //근무지별비과세_감면소득   **/
				//ye160510DAO.deleteYetaP210001_Ye160510VO_2017_Delete(ye160510Vo);	
				
						
				/**  //Ye161005VO  //A_원천세신고기본   **/
				
				
				/**  Ye161020VO    //A_인적소득공제기본   **/
			//	ye161020DAO.deleteYetaP210001_Ye161020VO_2017_Delete(ye161020Vo);	
				
				/**  Ye161030VO    //E_인적공제명세   **/
				//ye161030DAO.deleteYetaP210001_Ye161030VO_2017_Delete(ye161030Vo);	
				
				/**  Ye161040VO    //E_소득세액공제명세   **/
				//ye161040DAO.deleteYetaP210001_Ye161040VO_2017_Delete(ye161040Vo);	
				
				/**  Ye161050VO    //C_연금보험료공제   **/
				//ye161050DAO.deleteYetaP210001_Ye161050VO_2017_Delete(ye161050Vo);	
				
				/**  Ye161055VO    //C_연금보험료_공적연금상세   **/
				//ye161055DAO.deleteYetaP210001_Ye161055VO_2017_Delete(ye161055Vo);
				
				/**  Ye161060VO    //C_특별소득공제   **/
				//ye161060DAO.deleteYetaP210001_Ye161060VO_2017_Delete(ye161060Vo);	
				
				/**  Ye161070VO    //C_그밖의소득공제   **/
				//ye161070DAO.deleteYetaP210001_Ye161070VO_2017_Delete(ye161070Vo);	
				
				/**  Ye161080VO    //C_세액감면및공제   **/
				//ye161080DAO.deleteYetaP210001_Ye161080VO_2017_Delete(ye161080Vo);	
				
				/**  Ye161090VO    //C_교육비내역   **/
				//ye161090DAO.deleteYetaP210001_Ye161090VO_2017_Delete(ye161090Vo);	
				
				/**  Ye162010VO    //F_연금저축계좌   **/
				//ye162010DAO.deleteYetaP210001_Ye162010VO_2017_Delete(ye162010Vo);	
				
				/**  Ye162020VO    //F_퇴직연금계좌명세   **/
				//ye162020DAO.deleteYetaP210001_Ye162020VO_2017_Delete(ye162020Vo);

				/**  Ye162030VO    //F_주택마련저축   **/
				//ye162030DAO.deleteYetaP210001_Ye162030VO_2017_Delete(ye162030Vo);	
				
				/**  Ye162040VO    //F_장기집합투자증권저축_B1013   **/
				//ye162040DAO.deleteYetaP210001_Ye162040VO_2017_Delete(ye162040Vo);	
				
				/**  Ye162510VO    //G_월세액소득공제명세   **/
				//ye162510DAO.deleteYetaP210001_Ye162510VO_2017_Delete(ye162510Vo);	
				
				/**  Ye162520VO    //G_거주자간_금전소비대차   **/
				//ye162520DAO.deleteYetaP210001_Ye162520VO_2017_Delete(ye162520Vo);	
				
				/**  Ye162530VO    //G_임대차계약   **/
				//ye162530DAO.deleteYetaP210001_Ye162530VO_2017_Delete(ye162530Vo);
				
				/**  Ye164010VO    //A_의료비지급명세   **/
				//ye164010DAO.deleteYetaP210001_Ye164010VO_2017_Delete(ye164010Vo);
				
				/**  Ye165010VO    //I_해당연도기부금명세   **/
				//ye165010DAO.deleteYetaP210001_Ye165010VO_2017_Delete(ye165010Vo);	
				
				/**  Ye165020VO    //I_기부자관계코드별기부금합계   **/
				//ye165020DAO.deleteYetaP210001_Ye165020VO_2017_Delete(ye165020Vo);	
				
				/**  Ye165030VO    //H_기부금조정명세   **/
				//ye165030DAO.deleteYetaP210001_Ye165030VO_2017_Delete(ye165030Vo);	
				
				/**  Ye165030TempVO	    //H_기부금조정명세_TEMP	    **/
				//ye165030TempDAO.deleteYetaP210001_Ye165030TempVO_2017_Delete(ye165030TempVo);
				
				/**  Ye166010VO    //신용카드등소득공제명세   **/
				//ye166010DAO.deleteYetaP210001_Ye166010VO_2017_Delete(ye166010Vo);	
				
				/**  Ye166020VO    //신용카드등소득공제상세   **/
				//ye166020DAO.deleteYetaP210001_Ye166020VO_2017_Delete(ye166020Vo);	
				
				/**  Ye169010VO    //C_주현근무처   **/
				//ye169010DAO.deleteYetaP210001_Ye169010VO_2017_Delete(ye169010Vo);	
				
				/**  Ye169010aVO   //C_주현근무처_표준공제     **/
				//ye169010aDAO.deleteYetaP210001_Ye169010aVO_2017_Delete(ye169010AVo);	
				
				/**  Ye161010VO    // 연말정산대상자기본   **/
				ye161010DAO.deleteYetaP210001_Ye161010VO_2017_Delete(ye161010Vo);
				
			  	retval = 1L;
				
			}

		} catch (Exception ex) {

			logger.error("EXCEPTION calling Yeta210001_All_Delete(): " + ex);

			/** 에러 로그 **/
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser, method,calledClass, "D", ex, windowNm, windowId);

			retval = 0L;
			throw MSFServerUtils.getOperationException("Yeta210001_All_Delete", ex, logger);
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