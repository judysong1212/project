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
package com.app.exterms.yearendtax.server.service.yeta2019;
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

import com.app.exterms.yearendtax.client.dto.yeta2019.Ye161010DTO;
import com.app.exterms.yearendtax.client.dto.yeta2019.Ye161020DTO;
import com.app.exterms.yearendtax.client.service.yeta2019.YetaP410001Service;
import com.app.exterms.yearendtax.server.service.yeta2019.dao.Ye160401_2019_DAO;
import com.app.exterms.yearendtax.server.service.yeta2019.dao.Ye160402_2019_DAO;
import com.app.exterms.yearendtax.server.service.yeta2019.dao.Ye160403_2019_DAO;
import com.app.exterms.yearendtax.server.service.yeta2019.dao.Ye160404_2019_DAO;
import com.app.exterms.yearendtax.server.service.yeta2019.dao.Ye160405_2019_DAO;
import com.app.exterms.yearendtax.server.service.yeta2019.dao.Ye160406_2019_DAO;
import com.app.exterms.yearendtax.server.service.yeta2019.dao.Ye160510_2019_DAO;
import com.app.exterms.yearendtax.server.service.yeta2019.dao.Ye161005_2019_DAO;
import com.app.exterms.yearendtax.server.service.yeta2019.dao.Ye161010_2019_DAO;
import com.app.exterms.yearendtax.server.service.yeta2019.dao.Ye161020_2019_DAO;
import com.app.exterms.yearendtax.server.service.yeta2019.dao.Ye161030_2019_DAO;
import com.app.exterms.yearendtax.server.service.yeta2019.dao.Ye161040_2019_DAO;
import com.app.exterms.yearendtax.server.service.yeta2019.dao.Ye161050_2019_DAO;
import com.app.exterms.yearendtax.server.service.yeta2019.dao.Ye161055_2019_DAO;
import com.app.exterms.yearendtax.server.service.yeta2019.dao.Ye161060_2019_DAO;
import com.app.exterms.yearendtax.server.service.yeta2019.dao.Ye161070_2019_DAO;
import com.app.exterms.yearendtax.server.service.yeta2019.dao.Ye161080_2019_DAO;
import com.app.exterms.yearendtax.server.service.yeta2019.dao.Ye161090_2019_DAO;
import com.app.exterms.yearendtax.server.service.yeta2019.dao.Ye162010_2019_DAO;
import com.app.exterms.yearendtax.server.service.yeta2019.dao.Ye162020_2019_DAO;
import com.app.exterms.yearendtax.server.service.yeta2019.dao.Ye162030_2019_DAO;
import com.app.exterms.yearendtax.server.service.yeta2019.dao.Ye162040_2019_DAO;
import com.app.exterms.yearendtax.server.service.yeta2019.dao.Ye162510_2019_DAO;
import com.app.exterms.yearendtax.server.service.yeta2019.dao.Ye162520_2019_DAO;
import com.app.exterms.yearendtax.server.service.yeta2019.dao.Ye162530_2019_DAO;
import com.app.exterms.yearendtax.server.service.yeta2019.dao.Ye164010_2019_DAO;
import com.app.exterms.yearendtax.server.service.yeta2019.dao.Ye165010_2019_DAO;
import com.app.exterms.yearendtax.server.service.yeta2019.dao.Ye165020_2019_DAO;
import com.app.exterms.yearendtax.server.service.yeta2019.dao.Ye165030_2019_DAO;
import com.app.exterms.yearendtax.server.service.yeta2019.dao.Ye165030Temp_2019_DAO;
import com.app.exterms.yearendtax.server.service.yeta2019.dao.Ye166010_2019_DAO;
import com.app.exterms.yearendtax.server.service.yeta2019.dao.Ye166020_2019_DAO;
import com.app.exterms.yearendtax.server.service.yeta2019.dao.Ye169010_2019_DAO;
import com.app.exterms.yearendtax.server.service.yeta2019.dao.Ye169010a_2019_DAO;
import com.app.exterms.yearendtax.server.vo.InfcPsnl0100Srh_2019_VO;
import com.app.exterms.yearendtax.server.vo.Ye160401_2019_VO;
import com.app.exterms.yearendtax.server.vo.Ye160402_2019_VO;
import com.app.exterms.yearendtax.server.vo.Ye160403_2019_VO;
import com.app.exterms.yearendtax.server.vo.Ye160404_2019_VO;
import com.app.exterms.yearendtax.server.vo.Ye160405_2019_VO;
import com.app.exterms.yearendtax.server.vo.Ye160406_2019_VO;
import com.app.exterms.yearendtax.server.vo.Ye160510_2019_VO;
import com.app.exterms.yearendtax.server.vo.Ye161010_2019_VO;
import com.app.exterms.yearendtax.server.vo.Ye161020_2019_VO;
import com.app.exterms.yearendtax.server.vo.Ye161030_2019_VO;
import com.app.exterms.yearendtax.server.vo.Ye161040_2019_VO;
import com.app.exterms.yearendtax.server.vo.Ye161050_2019_VO;
import com.app.exterms.yearendtax.server.vo.Ye161055_2019_VO;
import com.app.exterms.yearendtax.server.vo.Ye161060_2019_VO;
import com.app.exterms.yearendtax.server.vo.Ye161070_2019_VO;
import com.app.exterms.yearendtax.server.vo.Ye161080_2019_VO;
import com.app.exterms.yearendtax.server.vo.Ye161090_2019_VO;
import com.app.exterms.yearendtax.server.vo.Ye162010_2019_VO;
import com.app.exterms.yearendtax.server.vo.Ye162020_2019_VO;
import com.app.exterms.yearendtax.server.vo.Ye162030_2019_VO;
import com.app.exterms.yearendtax.server.vo.Ye162040_2019_VO;
import com.app.exterms.yearendtax.server.vo.Ye162510_2019_VO;
import com.app.exterms.yearendtax.server.vo.Ye162520_2019_VO;
import com.app.exterms.yearendtax.server.vo.Ye162530_2019_VO;
import com.app.exterms.yearendtax.server.vo.Ye164010_2019_VO;
import com.app.exterms.yearendtax.server.vo.Ye165010_2019_VO;
import com.app.exterms.yearendtax.server.vo.Ye165020_2019_VO;
import com.app.exterms.yearendtax.server.vo.Ye165030Temp_2019_VO;
import com.app.exterms.yearendtax.server.vo.Ye165030_2019_VO;
import com.app.exterms.yearendtax.server.vo.Ye166010_2019_VO;
import com.app.exterms.yearendtax.server.vo.Ye166020_2019_VO;
import com.app.exterms.yearendtax.server.vo.Ye169010_2019_VO;
import com.app.exterms.yearendtax.server.vo.Ye169010a_2019_VO;
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
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgYe161010_2019_VO;
import com.app.smrmf.pkg.listener.yeta.yeta2019.Yeta4100ListenerAdapter;
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
@Service("YetaP410001Service")
public class YetaP410001ServiceImpl  extends AbstractCustomServiceImpl implements YetaP410001Service  ,YetaDaoConstants {

	 
	private static final Logger logger = LoggerFactory.getLogger(YetaP410001ServiceImpl.class);
	private static final String calledClass = YetaP410001ServiceImpl.class.getName();
 
		
	@Autowired
	@Resource(name = "Ye160401_2019_DAO")
	private Ye160401_2019_DAO ye160401DAO; //현근무지급여지급명세
	@Autowired
	@Resource(name = "Ye160402_2019_DAO")
	private Ye160402_2019_DAO  ye160402DAO;//현근무지비과세_감면소득_과세
	@Autowired
	@Resource(name = "Ye160403_2019_DAO")
	private Ye160403_2019_DAO  ye160403DAO;//현근무지비과세_감면소득_비과세
	@Autowired
	@Resource(name = "Ye160404_2019_DAO")
	private Ye160404_2019_DAO  ye160404DAO;//D_종전근무처
	@Autowired
	@Resource(name = "Ye160405_2019_DAO")
	private Ye160405_2019_DAO  ye160405DAO;//D_종전근무처비과세_감면소득_비과세
	@Autowired
	@Resource(name = "Ye160406_2019_DAO")
	private Ye160406_2019_DAO  ye160406DAO;//종전근무지연금보험료_공적연금
	@Autowired
	@Resource(name = "Ye160510_2019_DAO")
	private Ye160510_2019_DAO  ye160510DAO;//근무지별비과세_감면소득
	            
	@Autowired
	@Resource(name = "Ye161005_2019_DAO")
	private Ye161005_2019_DAO  ye161005DAO;//A_원천세신고기본
	            
	@Autowired
	@Resource(name = "Ye161010_2019_DAO")
	private Ye161010_2019_DAO  ye161010DAO;// 연말정산대상자기본
	@Autowired
	@Resource(name = "Ye161020_2019_DAO")
	private Ye161020_2019_DAO  ye161020DAO;//A_인적소득공제기본
	@Autowired
	@Resource(name = "Ye161030_2019_DAO")
	private Ye161030_2019_DAO  ye161030DAO;//E_인적공제명세
	@Autowired
	@Resource(name = "Ye161040_2019_DAO")
	private Ye161040_2019_DAO  ye161040DAO;//E_소득세액공제명세
	@Autowired
	@Resource(name = "Ye161050_2019_DAO")
	private Ye161050_2019_DAO  ye161050DAO;//C_연금보험료공제
	@Autowired
	@Resource(name = "Ye161055_2019_DAO")
	private Ye161055_2019_DAO  ye161055DAO;//C_연금보험료_공적연금상세
	@Autowired
	@Resource(name = "Ye161060_2019_DAO")
	private Ye161060_2019_DAO  ye161060DAO;//C_특별소득공제
	@Autowired
	@Resource(name = "Ye161070_2019_DAO")
	private Ye161070_2019_DAO  ye161070DAO;//C_그밖의소득공제
	@Autowired
	@Resource(name = "Ye161080_2019_DAO")
	private Ye161080_2019_DAO  ye161080DAO;//C_세액감면및공제
	@Autowired
	@Resource(name = "Ye161090_2019_DAO")
	private Ye161090_2019_DAO  ye161090DAO;//C_교육비내역
	@Autowired
	@Resource(name = "Ye162010_2019_DAO")
	private Ye162010_2019_DAO  ye162010DAO;//F_연금저축계좌
	@Autowired
	@Resource(name = "Ye162020_2019_DAO")
	private Ye162020_2019_DAO  ye162020DAO;//F_퇴직연금계좌명세
	@Autowired
	@Resource(name = "Ye162030_2019_DAO")
	private Ye162030_2019_DAO  ye162030DAO;//F_주택마련저축
	@Autowired
	@Resource(name = "Ye162040_2019_DAO")
	private Ye162040_2019_DAO  ye162040DAO;//F_장기집합투자증권저축_B1013
	@Autowired
	@Resource(name = "Ye162510_2019_DAO")
	private Ye162510_2019_DAO  ye162510DAO;//G_월세액소득공제명세
	@Autowired
	@Resource(name = "Ye162520_2019_DAO")
	private Ye162520_2019_DAO  ye162520DAO;//G_거주자간_금전소비대차
	@Autowired
	@Resource(name = "Ye162530_2019_DAO")
	private Ye162530_2019_DAO  ye162530DAO;//G_임대차계약
	@Autowired
	@Resource(name = "Ye164010_2019_DAO")
	private Ye164010_2019_DAO ye164010DAO; //A_의료비지급명세
	@Autowired
	@Resource(name = "Ye165010_2019_DAO")
	private Ye165010_2019_DAO  ye165010DAO;//I_해당연도기부금명세
	@Autowired
	@Resource(name = "Ye165020_2019_DAO")
	private Ye165020_2019_DAO  ye165020DAO;//I_기부자관계코드별기부금합계
	@Autowired
	@Resource(name = "Ye165030_2019_DAO")
	private Ye165030_2019_DAO  ye165030DAO;//H_기부금조정명세
	@Autowired
	@Resource(name = "Ye165030Temp_2019_DAO")
	private Ye165030Temp_2019_DAO ye165030TempDAO;    //H_기부금조정명세_TEMP	 
	@Autowired
	@Resource(name = "Ye166010_2019_DAO")
	private Ye166010_2019_DAO  ye166010DAO;//신용카드등소득공제명세
	@Autowired
	@Resource(name = "Ye166020_2019_DAO")
	private Ye166020_2019_DAO  ye166020DAO;//신용카드등소득공제상세
		 
	@Autowired
	@Resource(name = "Ye169010_2019_DAO")
	private Ye169010_2019_DAO ye169010DAO; //C_주현근무처
	@Autowired
	@Resource(name = "Ye169010a_2019_DAO")
	private Ye169010a_2019_DAO ye169010aDAO; //C_주현근무처_표준공제 
	    
	/**
	 * 연말정산대상자조회
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	//조회
	public PagingLoadResult<BaseModel> getYetaP410001ToPsnl0100DataList(ServiceParameters serviceParameters) throws MSFException {
		

		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETAP410001_TO_PSNL0100_DATA_LIST;
		InfcPsnl0100Srh_2019_VO   psnl0100SrhVO = new InfcPsnl0100Srh_2019_VO();
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
			ye161010DAO = (Ye161010_2019_DAO) wac.getBean("Ye161010_2019_DAO"); 
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
	                 
	          	int iResultCnt = ye161010DAO.selectYetaP410001ToPsnl0100ListTotCnt(psnl0100SrhVO);  
	              
	          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
	          	
	          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                
	         	pagingValues.totalRecordCount = iResultCnt;	       
	                
	        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
	        
	     	TimingInfo millisBeginYetaP410001ToPsnl0100DataList = SmrmfUtils.startTiming(logger);
	        
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
	     	List list = ye161010DAO.selectYetaP410001ToPsnl0100List(psnl0100SrhVO);
	            
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
	            
			SmrmfUtils.endTiming(logger, millisBeginYetaP410001ToPsnl0100DataList, "getYetaP410001ToPsnl0100DataList");
	       
		} catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	
	
	/** 연말정산 대상자 생성  **/
	@Override
	public PagingLoadResult<ShowMessageBM> saveYetaP410001ToYe161010(List<Ye161010DTO> listYe161010Dto,List<Ye161020DTO> listYe161020Dto, ActionDatabase actionDatabase) throws  MSFException {
		
		String method = calledClass + ".saveYetaP410001ToYe161010";
		
		String windowNm = "연말정산대상자검색";
		String windowId = "YETAP410001";
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		 
		int result = 0; 
		int iCnt = 0;
		
		BigDecimal seqn = new BigDecimal(0);
		PagingLoadResult<ShowMessageBM> retval = null;
	  	List<InfcPkgYe161010_2019_VO> listYe161010VO = new ArrayList<InfcPkgYe161010_2019_VO>();
		List<ShowMessageBM> bmResult = new ArrayList<ShowMessageBM>();
		
		try{
			
            for(int iYetaCnt=0; iYetaCnt < listYe161020Dto.size(); iYetaCnt++) {
                
            	if(0L < Yeta410001_All_Delete(listYe161020Dto)) {
            	 
            		Ye161010DTO ye161010Dto = new Ye161010DTO();  
	            	Ye161020DTO ye161020Dto = new Ye161020DTO();  
	            	Ye161010_2019_VO  ye161010Vo = new Ye161010_2019_VO();
	        		Ye161020_2019_VO  ye161020Vo = new Ye161020_2019_VO();

	        		InfcPkgYe161010_2019_VO infcPkgYe161010Vo = new InfcPkgYe161010_2019_VO();
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

	            	BeanUtils.copyProperties(infcPkgYe161010Vo, ye161010Vo);  
	            	listYe161010VO.add(infcPkgYe161010Vo);
	            	
	            	iCnt = iCnt + 1;
              }
            } 
            
            if (iCnt > 0) {

	        	Yeta4100ListenerAdapter yetaLsAdtr = new Yeta4100ListenerAdapter();
		    	//컴포넌트 호출하기 
	        	retval = yetaLsAdtr.setYetaP410001ToAll_2019_Create(RemoteServiceUtil.getThreadLocalRequest(), listYe161010VO);  
            
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
		
	private  Long Yeta410001_All_Delete(List<Ye161020DTO> listYe161020Dto) throws MSFException {
    	
		String method = calledClass + ".Yeta410001_All_Delete";

		String windowNm = "연말정산대상자관리";
		String windowId = "YETA410001";

		Long retval = 1L;

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());


		Ye160401_2019_VO    ye160401Vo	 = new  Ye160401_2019_VO();	//현근무지급여지급명세
		Ye160402_2019_VO    ye160402Vo	 = new  Ye160402_2019_VO();	//현근무지비과세_감면소득_과세
		Ye160403_2019_VO    ye160403Vo	 = new  Ye160403_2019_VO();	//현근무지비과세_감면소득_비과세
		Ye160404_2019_VO    ye160404Vo	 = new  Ye160404_2019_VO();	//D_종전근무처
		Ye160405_2019_VO    ye160405Vo	 = new  Ye160405_2019_VO();	//D_종전근무처비과세_감면소득_비과세
		Ye160406_2019_VO    ye160406Vo	 = new  Ye160406_2019_VO();	//종전근무지연금보험료_공적연금
		Ye160510_2019_VO    ye160510Vo	 = new  Ye160510_2019_VO();	//근무지별비과세_감면소득
			      			        
		//Ye161005VO    ye161005Vo	 = new  Ye161005VO();	//A_원천세신고기본
			       			        
		Ye161010_2019_VO    ye161010Vo	 = new  Ye161010_2019_VO();	// 연말정산대상자기본
		
		Ye161020_2019_VO    ye161020Vo	 = new  Ye161020_2019_VO();	//A_인적소득공제기본
		Ye161030_2019_VO    ye161030Vo	 = new  Ye161030_2019_VO();	//E_인적공제명세
		Ye161040_2019_VO    ye161040Vo	 = new  Ye161040_2019_VO();	//E_소득세액공제명세
		Ye161050_2019_VO    ye161050Vo	 = new  Ye161050_2019_VO();	//C_연금보험료공제
		Ye161055_2019_VO    ye161055Vo	 = new  Ye161055_2019_VO();	//C_연금보험료_공적연금상세
		Ye161060_2019_VO    ye161060Vo	 = new  Ye161060_2019_VO();	//C_특별소득공제
		Ye161070_2019_VO    ye161070Vo	 = new  Ye161070_2019_VO();	//C_그밖의소득공제
		Ye161080_2019_VO    ye161080Vo	 = new  Ye161080_2019_VO();	//C_세액감면및공제
		Ye161090_2019_VO    ye161090Vo	 = new  Ye161090_2019_VO();	//C_교육비내역
		Ye162010_2019_VO    ye162010Vo	 = new  Ye162010_2019_VO();	//F_연금저축계좌
		Ye162020_2019_VO    ye162020Vo	 = new  Ye162020_2019_VO();	//F_퇴직연금계좌명세
		Ye162030_2019_VO    ye162030Vo	 = new  Ye162030_2019_VO();	//F_주택마련저축
		Ye162040_2019_VO    ye162040Vo	 = new  Ye162040_2019_VO();	//F_장기집합투자증권저축_B1013
		Ye162510_2019_VO    ye162510Vo	 = new  Ye162510_2019_VO();	//G_월세액소득공제명세
		Ye162520_2019_VO    ye162520Vo	 = new  Ye162520_2019_VO();	//G_거주자간_금전소비대차
		Ye162530_2019_VO    ye162530Vo	 = new  Ye162530_2019_VO();	//G_임대차계약
		Ye164010_2019_VO    ye164010Vo	 = new  Ye164010_2019_VO();	//A_의료비지급명세
		Ye165010_2019_VO    ye165010Vo	 = new  Ye165010_2019_VO();	//I_해당연도기부금명세
		Ye165020_2019_VO    ye165020Vo	 = new  Ye165020_2019_VO();	//I_기부자관계코드별기부금합계
		Ye165030_2019_VO    ye165030Vo	 = new  Ye165030_2019_VO();	//H_기부금조정명세
		Ye165030Temp_2019_VO ye165030TempVo = new  Ye165030Temp_2019_VO();  	    //H_기부금조정명세_TEMP	 
		Ye166010_2019_VO     ye166010Vo	 = new  Ye166010_2019_VO();	//신용카드등소득공제명세
		Ye166020_2019_VO     ye166020Vo	 = new  Ye166020_2019_VO();	//신용카드등소득공제상세
							 //
		Ye169010_2019_VO     ye169010Vo	 = new  Ye169010_2019_VO();	//C_주현근무처
		Ye169010a_2019_VO    ye169010AVo = new  Ye169010a_2019_VO();	//C_주현근무처_표준공제 
		 	
		BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);   	
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		 	  
		try {
				  
			for(int i = 0; i < listYe161020Dto.size(); i ++) {
				
				Ye161020DTO ye161020Dto = new Ye161020DTO();  
            	InfcPkgYe161010_2019_VO infcPkgYe161010Vo = new InfcPkgYe161010_2019_VO();
            	ye161020Dto = listYe161020Dto.get(i);    
			  
            	 
            	ye161010Vo.setDpobCd(ye161020Dto.getDpobCd());    		/** column null : dpobCd */
            	ye161010Vo.setYrtxBlggYr(ye161020Dto.getYrtxBlggYr());    /** column 귀속연도 : yrtxBlggYr */
            	ye161010Vo.setClutSeptCd(ye161020Dto.getClutSeptCd());   	/** column 연말정산구분코드 : clutSeptCd */	
            	ye161010Vo.setSystemkey(ye161020Dto.getSystemkey());	/** column SYSTEMKEY : systemkey */ 

				/**  Ye161010VO    // 연말정산대상자기본   **/
				ye161010DAO.deleteYetaP410001_Ye161010VO_2019_Delete(ye161010Vo);
				
			  	retval = 1L;
				
			}

		} catch (Exception ex) {

			logger.error("EXCEPTION calling Yeta410001_All_Delete(): " + ex);

			/** 에러 로그 **/
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser, method,calledClass, "D", ex, windowNm, windowId);

			retval = 0L;
			throw MSFServerUtils.getOperationException("Yeta410001_All_Delete", ex, logger);
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
