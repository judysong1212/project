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

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.utils.SmrmfUtils;
import org.msf.utils.TimingInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.exterms.yearendtax.client.dto.yeta2017.PdfA102yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfB101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfC101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfC202yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfC301yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfC401yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfD101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfE102yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfF102yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfG106yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfG206yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfG306yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfJ101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfJ203yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfJ301yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfJ401yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfK101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfL102yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfN101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfO101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.PdfP102yDTO;
import com.app.exterms.yearendtax.client.service.yeta2017.YetaP220001Service;
import com.app.exterms.yearendtax.server.vo.Ye161010VO;
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
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgPdfA102yDAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgPdfB101yDAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgPdfC101yDAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgPdfC202yDAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgPdfC301yDAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgPdfC401yDAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgPdfD101yDAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgPdfE102yDAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgPdfF102yDAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgPdfG104yDAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgPdfG106yDAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgPdfG205mDAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgPdfG205yDAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgPdfG206mDAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgPdfG206yDAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgPdfG304mDAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgPdfG304yDAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgPdfG306mDAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgPdfG306yDAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgPdfJ101yDAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgPdfJ203mDAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgPdfJ203yDAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgPdfJ301yDAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgPdfJ401yDAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgPdfK101mDAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgPdfK101yDAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgPdfL102yDAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgPdfN101yDAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgPdfO101mDAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgPdfO101yDAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgPdfP101mDAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgPdfP101yDAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgPdfP102mDAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgPdfP102yDAO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfA102ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfA102yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfB101ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfB101yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfC101ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfC101yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfC202ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfC202yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfC301ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfC301yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfC401ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfC401yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfD101ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfD101yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfE102ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfE102yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfF102ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfF102yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG104ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG106ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG106yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG205ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG206ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG206yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG304ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG306ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG306yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfJ101ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfJ101yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfJ203ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfJ203yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfJ301ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfJ301yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfJ401ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfJ401yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfK101ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfK101yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfL102ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfL102yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfN101ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfN101yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfO101ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfO101yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfP101ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfP102ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfP102yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010VO;
import com.app.smrmf.pkg.yeta.yeta2017.pdfxml.Func_PdfXml_Yeta2017_Insert;
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
@Service("YetaP220001Service")
public class YetaP220001ServiceImpl  extends AbstractCustomServiceImpl implements YetaP220001Service  ,YetaDaoConstants {


	private static final Logger logger = LoggerFactory.getLogger(YetaP220001ServiceImpl.class);
	private static final String calledClass = YetaP220001ServiceImpl.class.getName();

	@Autowired
	@Resource(name="InfcPkgPdfA102yDAO")
	private InfcPkgPdfA102yDAO pdfA102yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfB101yDAO")
	private InfcPkgPdfB101yDAO pdfB101yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfC101yDAO")
	private InfcPkgPdfC101yDAO pdfC101yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfC202yDAO")
	private InfcPkgPdfC202yDAO pdfC202yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfC301yDAO")
	private InfcPkgPdfC301yDAO pdfC301yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfC401yDAO")
	private InfcPkgPdfC401yDAO pdfC401yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfD101yDAO")
	private InfcPkgPdfD101yDAO pdfD101yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfE102yDAO")
	private InfcPkgPdfE102yDAO pdfE102yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfF102yDAO")
	private InfcPkgPdfF102yDAO pdfF102yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfG104yDAO")
	private InfcPkgPdfG104yDAO pdfG104yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfG106yDAO")
	private InfcPkgPdfG106yDAO pdfG106yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfG205mDAO")
	private InfcPkgPdfG205mDAO pdfG205mDAO;

	@Autowired
	@Resource(name="InfcPkgPdfG205yDAO")
	private InfcPkgPdfG205yDAO pdfG205yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfG206mDAO")
	private InfcPkgPdfG206mDAO pdfG206mDAO;

	@Autowired
	@Resource(name="InfcPkgPdfG206yDAO")
	private InfcPkgPdfG206yDAO pdfG206yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfG304yDAO")
	private InfcPkgPdfG304yDAO pdfG304yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfG304mDAO")
	private InfcPkgPdfG304mDAO pdfG304mDAO;

	@Autowired
	@Resource(name="InfcPkgPdfG306yDAO")
	private InfcPkgPdfG306yDAO pdfG306yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfG306mDAO")
	private InfcPkgPdfG306mDAO pdfG306mDAO;

	@Autowired
	@Resource(name="InfcPkgPdfJ101yDAO")
	private InfcPkgPdfJ101yDAO pdfJ101yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfJ203yDAO")
	private InfcPkgPdfJ203yDAO pdfJ203yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfJ203mDAO")
	private InfcPkgPdfJ203mDAO pdfJ203mDAO;

	@Autowired
	@Resource(name="InfcPkgPdfJ301yDAO")
	private InfcPkgPdfJ301yDAO pdfJ301yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfJ401yDAO")
	private InfcPkgPdfJ401yDAO pdfJ401yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfK101mDAO")
	private InfcPkgPdfK101mDAO pdfK101mDAO;

	@Autowired
	@Resource(name="InfcPkgPdfK101yDAO")
	private InfcPkgPdfK101yDAO pdfK101yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfL102yDAO")
	private InfcPkgPdfL102yDAO pdfL102yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfN101yDAO")
	private InfcPkgPdfN101yDAO pdfN101yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfO101mDAO")
	private InfcPkgPdfO101mDAO pdfO101mDAO;

	@Autowired
	@Resource(name="InfcPkgPdfO101yDAO")
	private InfcPkgPdfO101yDAO pdfO101yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfP101mDAO")
	private InfcPkgPdfP101mDAO pdfP101mDAO;

	@Autowired
	@Resource(name="InfcPkgPdfP101yDAO")
	private InfcPkgPdfP101yDAO pdfP101yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfP102mDAO")
	private InfcPkgPdfP102mDAO pdfP102mDAO;

	@Autowired
	@Resource(name="InfcPkgPdfP102yDAO")
	private InfcPkgPdfP102yDAO pdfP102yDAO;

	/**
	 * 보장성보험 조회
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	//조회
	public PagingLoadResult<BaseModel> getYetaP220001ToPdfA102yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA2200_PDF_A102Y_DATA_LIST;
		InfcPkgPdfA102ySrhVO   pdfA102ySrhVO = new InfcPkgPdfA102ySrhVO();
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

		if  (MSFSharedUtils.paramNull(pdfA102yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfA102yDAO = (InfcPkgPdfA102yDAO) wac.getBean("InfcPkgPdfA102yDAO"); 
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
			pdfA102ySrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
			pdfA102ySrhVO.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));	// 정산구분 
			pdfA102ySrhVO.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));		// 귀속년도
			pdfA102ySrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));

			//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 

				//Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

				int iResultCnt = pdfA102yDAO.selectPdfA102yListTotCnt(pdfA102ySrhVO);

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
			pdfA102ySrhVO.setPageSize(pagingValues.totalRecordCount);  

			//Apply paging
			if (pagingValues.start > 0) {
				pdfA102ySrhVO.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				pdfA102ySrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			//
			//Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

			@SuppressWarnings("unchecked")
			//	            Collection<Map<String, Object>> list ??????
			List list = pdfA102yDAO.selectPdfA102yList(pdfA102ySrhVO);

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

						if(	"resid".equals(tableAttributes[i].getName())) {

							String rrnDecCrypt = "";

							// TODO 주민번호 
							rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);

							strValue = rrnDecCrypt;

						}
						else if ("insu1Resid".equals(tableAttributes[i].getName())) {

							String rrnDecCrypt = "";

							// TODO 주민번호 
							rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);

							strValue = rrnDecCrypt;

						}
						else if ("insu2Resid1".equals(tableAttributes[i].getName())) {

							String rrnDecCrypt = "";

							// TODO 주민번호 
							rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);

							strValue = rrnDecCrypt;

						}
						else if ("insu2Resid2".equals(tableAttributes[i].getName())) {

							String rrnDecCrypt = "";

							// TODO 주민번호 
							rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);

							strValue = rrnDecCrypt;

						}
						else if ("insu2Resid3".equals(tableAttributes[i].getName())) {

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

	/**
	 * 의료비 조회
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	//조회
	public PagingLoadResult<BaseModel> getYetaP220001ToPdfB101yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA2200_PDF_B101Y_DATA_LIST;
		InfcPkgPdfB101ySrhVO   pdfB101ySrhVO = new InfcPkgPdfB101ySrhVO();
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

		if  (MSFSharedUtils.paramNull(pdfB101yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfB101yDAO = (InfcPkgPdfB101yDAO) wac.getBean("InfcPkgPdfB101yDAO"); 
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
			pdfB101ySrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
			pdfB101ySrhVO.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));	// 정산구분 
			pdfB101ySrhVO.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));		// 귀속년도
			pdfB101ySrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));

			//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 

				//Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

				int iResultCnt = pdfB101yDAO.selectPdfB101yListTotCnt(pdfB101ySrhVO);

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
			pdfB101ySrhVO.setPageSize(pagingValues.totalRecordCount);  

			//Apply paging
			if (pagingValues.start > 0) {
				pdfB101ySrhVO.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				pdfB101ySrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			//
			//Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

			@SuppressWarnings("unchecked")
			//	            Collection<Map<String, Object>> list ??????
			List list = pdfB101yDAO.selectPdfB101yList(pdfB101ySrhVO);

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

						if(	"resid".equals(tableAttributes[i].getName())) {

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

	/**
	 * 교육비 조회
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	//조회
	public PagingLoadResult<BaseModel> getYetaP220001ToPdfC101yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA2200_PDF_C101Y_DATA_LIST;
		InfcPkgPdfC101ySrhVO   pdfC101ySrhVO = new InfcPkgPdfC101ySrhVO();
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

		if  (MSFSharedUtils.paramNull(pdfC101yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfC101yDAO = (InfcPkgPdfC101yDAO) wac.getBean("InfcPkgPdfC101yDAO"); 
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
			pdfC101ySrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
			pdfC101ySrhVO.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));	// 정산구분 
			pdfC101ySrhVO.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));		// 귀속년도
			pdfC101ySrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));

			//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 

				//Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

				int iResultCnt = pdfC101yDAO.selectPdfC101yListTotCnt(pdfC101ySrhVO);

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
			pdfC101ySrhVO.setPageSize(pagingValues.totalRecordCount);  

			//Apply paging
			if (pagingValues.start > 0) {
				pdfC101ySrhVO.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				pdfC101ySrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			//
			//Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

			@SuppressWarnings("unchecked")
			//	            Collection<Map<String, Object>> list ??????
			List list = pdfC101yDAO.selectPdfC101yList(pdfC101ySrhVO);

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

						if(	"resid".equals(tableAttributes[i].getName())) {

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

	/**
	 * 직업훈련비 조회
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	//조회
	public PagingLoadResult<BaseModel> getYetaP220001ToPdfC202yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA2200_PDF_C202Y_DATA_LIST;
		InfcPkgPdfC202ySrhVO   pdfC202ySrhVO = new InfcPkgPdfC202ySrhVO();
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

		if  (MSFSharedUtils.paramNull(pdfC202yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfC202yDAO = (InfcPkgPdfC202yDAO) wac.getBean("InfcPkgPdfC202yDAO"); 
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
			pdfC202ySrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
			pdfC202ySrhVO.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));	// 정산구분 
			pdfC202ySrhVO.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));		// 귀속년도
			pdfC202ySrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));

			//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 

				//Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

				int iResultCnt = pdfC202yDAO.selectPdfC202yListTotCnt(pdfC202ySrhVO);

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
			pdfC202ySrhVO.setPageSize(pagingValues.totalRecordCount);  

			//Apply paging
			if (pagingValues.start > 0) {
				pdfC202ySrhVO.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				pdfC202ySrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			//
			//Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

			@SuppressWarnings("unchecked")
			//	            Collection<Map<String, Object>> list ??????
			List list = pdfC202yDAO.selectPdfC202yList(pdfC202ySrhVO);

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

						if(	"resid".equals(tableAttributes[i].getName())) {

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

	/**
	 * 교복구입비 조회
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	//조회
	public PagingLoadResult<BaseModel> getYetaP220001ToPdfC301yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA2200_PDF_C301Y_DATA_LIST;
		InfcPkgPdfC301ySrhVO   pdfC301ySrhVO = new InfcPkgPdfC301ySrhVO();
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

		if  (MSFSharedUtils.paramNull(pdfC301yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfC301yDAO = (InfcPkgPdfC301yDAO) wac.getBean("InfcPkgPdfC301yDAO"); 
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
			pdfC301ySrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
			pdfC301ySrhVO.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));	// 정산구분 
			pdfC301ySrhVO.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));		// 귀속년도
			pdfC301ySrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));

			//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 

				//Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

				int iResultCnt = pdfC301yDAO.selectPdfC301yListTotCnt(pdfC301ySrhVO);

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
			pdfC301ySrhVO.setPageSize(pagingValues.totalRecordCount);  

			//Apply paging
			if (pagingValues.start > 0) {
				pdfC301ySrhVO.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				pdfC301ySrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			//
			//Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

			@SuppressWarnings("unchecked")
			//	            Collection<Map<String, Object>> list ??????
			List list = pdfC301yDAO.selectPdfC301yList(pdfC301ySrhVO);

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

						if(	"resid".equals(tableAttributes[i].getName())) {

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

	/**
	 * 학자금대출 조회
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	//조회
	public PagingLoadResult<BaseModel> getYetaP220001ToPdfC401yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA2200_PDF_C401Y_DATA_LIST;
		InfcPkgPdfC401ySrhVO   pdfC401ySrhVO = new InfcPkgPdfC401ySrhVO();
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

		if  (MSFSharedUtils.paramNull(pdfC401yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfC401yDAO = (InfcPkgPdfC401yDAO) wac.getBean("InfcPkgPdfC401yDAO"); 
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
			pdfC401ySrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
			pdfC401ySrhVO.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));	// 정산구분 
			pdfC401ySrhVO.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));		// 귀속년도
			pdfC401ySrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));

			//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 

				//Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

				int iResultCnt = pdfC401yDAO.selectPdfC401yListTotCnt(pdfC401ySrhVO);

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
			pdfC401ySrhVO.setPageSize(pagingValues.totalRecordCount);  

			//Apply paging
			if (pagingValues.start > 0) {
				pdfC401ySrhVO.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				pdfC401ySrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			//
			//Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

			@SuppressWarnings("unchecked")
			//	            Collection<Map<String, Object>> list ??????
			List list = pdfC401yDAO.selectPdfC401yList(pdfC401ySrhVO);

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

						if(	"resid".equals(tableAttributes[i].getName())) {

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

	/**
	 * 개인연금저축 조회
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	//조회
	public PagingLoadResult<BaseModel> getYetaP220001ToPdfD101yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA2200_PDF_D101Y_DATA_LIST;
		InfcPkgPdfD101ySrhVO   pdfD101ySrhVO = new InfcPkgPdfD101ySrhVO();
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

		if  (MSFSharedUtils.paramNull(pdfD101yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfD101yDAO = (InfcPkgPdfD101yDAO) wac.getBean("InfcPkgPdfD101yDAO"); 
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
			pdfD101ySrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
			pdfD101ySrhVO.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));	// 정산구분 
			pdfD101ySrhVO.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));		// 귀속년도
			pdfD101ySrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));

			//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 

				//Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

				int iResultCnt = pdfD101yDAO.selectPdfD101yListTotCnt(pdfD101ySrhVO);

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
			pdfD101ySrhVO.setPageSize(pagingValues.totalRecordCount);  

			//Apply paging
			if (pagingValues.start > 0) {
				pdfD101ySrhVO.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				pdfD101ySrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			//
			//Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

			@SuppressWarnings("unchecked")
			//	            Collection<Map<String, Object>> list ??????
			List list = pdfD101yDAO.selectPdfD101yList(pdfD101ySrhVO);

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

						if(	"resid".equals(tableAttributes[i].getName())) {

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

	/**
	 * 연금저축 조회
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	//조회
	public PagingLoadResult<BaseModel> getYetaP220001ToPdfE102yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA2200_PDF_E102Y_DATA_LIST;
		InfcPkgPdfE102ySrhVO   pdfE102ySrhVO = new InfcPkgPdfE102ySrhVO();
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

		if  (MSFSharedUtils.paramNull(pdfE102yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfE102yDAO = (InfcPkgPdfE102yDAO) wac.getBean("InfcPkgPdfE102yDAO"); 
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
			pdfE102ySrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
			pdfE102ySrhVO.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));	// 정산구분 
			pdfE102ySrhVO.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));		// 귀속년도
			pdfE102ySrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));

			//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 

				//Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

				int iResultCnt = pdfE102yDAO.selectPdfE102yListTotCnt(pdfE102ySrhVO);

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
			pdfE102ySrhVO.setPageSize(pagingValues.totalRecordCount);  

			//Apply paging
			if (pagingValues.start > 0) {
				pdfE102ySrhVO.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				pdfE102ySrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			//
			//Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

			@SuppressWarnings("unchecked")
			//	            Collection<Map<String, Object>> list ??????
			List list = pdfE102yDAO.selectPdfE102yList(pdfE102ySrhVO);

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

						if(	"resid".equals(tableAttributes[i].getName())) {

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

	/**
	 * 퇴직연금 조회
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	//조회
	public PagingLoadResult<BaseModel> getYetaP220001ToPdfF102yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA2200_PDF_F102Y_DATA_LIST;
		InfcPkgPdfF102ySrhVO   pdfF102ySrhVO = new InfcPkgPdfF102ySrhVO();
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

		if  (MSFSharedUtils.paramNull(pdfF102yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfF102yDAO = (InfcPkgPdfF102yDAO) wac.getBean("InfcPkgPdfF102yDAO"); 
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
			pdfF102ySrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
			pdfF102ySrhVO.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));	// 정산구분 
			pdfF102ySrhVO.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));		// 귀속년도
			pdfF102ySrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));

			//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 

				//Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

				int iResultCnt = pdfF102yDAO.selectPdfF102yListTotCnt(pdfF102ySrhVO);

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
			pdfF102ySrhVO.setPageSize(pagingValues.totalRecordCount);  

			//Apply paging
			if (pagingValues.start > 0) {
				pdfF102ySrhVO.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				pdfF102ySrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			//
			//Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

			@SuppressWarnings("unchecked")
			//	            Collection<Map<String, Object>> list ??????
			List list = pdfF102yDAO.selectPdfF102yList(pdfF102ySrhVO);

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

						if(	"resid".equals(tableAttributes[i].getName())) {

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

	/**
	 * 신용카드 조회
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	//조회
	public PagingLoadResult<BaseModel> getYetaP220001ToPdfG104yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA2200_PDF_G104Y_DATA_LIST;
		InfcPkgPdfG104ySrhVO   pdfG104ySrhVO = new InfcPkgPdfG104ySrhVO();
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

		if  (MSFSharedUtils.paramNull(pdfG104yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfG104yDAO = (InfcPkgPdfG104yDAO) wac.getBean("InfcPkgPdfG104yDAO"); 
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
			pdfG104ySrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
			pdfG104ySrhVO.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));	// 정산구분 
			pdfG104ySrhVO.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));		// 귀속년도
			pdfG104ySrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));

			//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 

				//Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

				int iResultCnt = pdfG104yDAO.selectPdfG104yListTotCnt(pdfG104ySrhVO);

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
			pdfG104ySrhVO.setPageSize(pagingValues.totalRecordCount);  

			//Apply paging
			if (pagingValues.start > 0) {
				pdfG104ySrhVO.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				pdfG104ySrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			//
			//Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

			@SuppressWarnings("unchecked")
			//	            Collection<Map<String, Object>> list ??????
			List list = pdfG104yDAO.selectPdfG104yList(pdfG104ySrhVO);

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

						if(	"resid".equals(tableAttributes[i].getName())) {

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

	/**
	 * 신용카드(2017년) 조회
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	//조회
	public PagingLoadResult<BaseModel> getYetaP220001ToPdfG106yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA2200_PDF_G106Y_DATA_LIST;
		InfcPkgPdfG106ySrhVO   pdfG106ySrhVO = new InfcPkgPdfG106ySrhVO();
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

		if  (MSFSharedUtils.paramNull(pdfG106yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfG106yDAO = (InfcPkgPdfG106yDAO) wac.getBean("InfcPkgPdfG106yDAO"); 
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
			pdfG106ySrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
			pdfG106ySrhVO.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));	// 정산구분 
			pdfG106ySrhVO.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));		// 귀속년도
			pdfG106ySrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));

			//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 

				//Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

				int iResultCnt = pdfG106yDAO.selectPdfG106yListTotCnt(pdfG106ySrhVO);

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
			pdfG106ySrhVO.setPageSize(pagingValues.totalRecordCount);  

			//Apply paging
			if (pagingValues.start > 0) {
				pdfG106ySrhVO.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				pdfG106ySrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			//
			//Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

			@SuppressWarnings("unchecked")
			//	            Collection<Map<String, Object>> list ??????
			List list = pdfG106yDAO.selectPdfG106yList(pdfG106ySrhVO);

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

						if(	"resid".equals(tableAttributes[i].getName())) {

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

	/**
	 * 현금영수증 조회
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	//조회
	public PagingLoadResult<BaseModel> getYetaP220001ToPdfG205yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA2200_PDF_G205Y_DATA_LIST;
		InfcPkgPdfG205ySrhVO   pdfG205ySrhVO = new InfcPkgPdfG205ySrhVO();
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

		if  (MSFSharedUtils.paramNull(pdfG205yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfG205yDAO = (InfcPkgPdfG205yDAO) wac.getBean("InfcPkgPdfG205yDAO"); 
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
			pdfG205ySrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
			pdfG205ySrhVO.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));	// 정산구분 
			pdfG205ySrhVO.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));		// 귀속년도
			pdfG205ySrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));

			//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 

				//Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

				int iResultCnt = pdfG205yDAO.selectPdfG205yListTotCnt(pdfG205ySrhVO);

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
			pdfG205ySrhVO.setPageSize(pagingValues.totalRecordCount);  

			//Apply paging
			if (pagingValues.start > 0) {
				pdfG205ySrhVO.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				pdfG205ySrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			//
			//Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

			@SuppressWarnings("unchecked")
			//	            Collection<Map<String, Object>> list ??????
			List list = pdfG205yDAO.selectPdfG205yList(pdfG205ySrhVO);

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

						if(	"resid".equals(tableAttributes[i].getName())) {

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

	/**
	 * 현금영수증(2017년) 조회
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	//조회
	public PagingLoadResult<BaseModel> getYetaP220001ToPdfG206yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA2200_PDF_G206Y_DATA_LIST;
		InfcPkgPdfG206ySrhVO   pdfG206ySrhVO = new InfcPkgPdfG206ySrhVO();
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

		if  (MSFSharedUtils.paramNull(pdfG206yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfG206yDAO = (InfcPkgPdfG206yDAO) wac.getBean("InfcPkgPdfG206yDAO"); 
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
			pdfG206ySrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
			pdfG206ySrhVO.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));	// 정산구분 
			pdfG206ySrhVO.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));		// 귀속년도
			pdfG206ySrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));

			//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 

				//Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

				int iResultCnt = pdfG206yDAO.selectPdfG206yListTotCnt(pdfG206ySrhVO);

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
			pdfG206ySrhVO.setPageSize(pagingValues.totalRecordCount);  

			//Apply paging
			if (pagingValues.start > 0) {
				pdfG206ySrhVO.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				pdfG206ySrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			//
			//Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

			@SuppressWarnings("unchecked")
			//	            Collection<Map<String, Object>> list ??????
			List list = pdfG206yDAO.selectPdfG206yList(pdfG206ySrhVO);

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

						if(	"resid".equals(tableAttributes[i].getName())) {

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

	/**
	 * 직불카드 등 조회
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	//조회
	public PagingLoadResult<BaseModel> getYetaP220001ToPdfG304yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA2200_PDF_G304Y_DATA_LIST;
		InfcPkgPdfG304ySrhVO   pdfG304ySrhVO = new InfcPkgPdfG304ySrhVO();
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

		if  (MSFSharedUtils.paramNull(pdfG304yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfG304yDAO = (InfcPkgPdfG304yDAO) wac.getBean("InfcPkgPdfG304yDAO"); 
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
			pdfG304ySrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
			pdfG304ySrhVO.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));	// 정산구분 
			pdfG304ySrhVO.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));		// 귀속년도
			pdfG304ySrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));

			//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 

				//Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

				int iResultCnt = pdfG304yDAO.selectPdfG304yListTotCnt(pdfG304ySrhVO);

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
			pdfG304ySrhVO.setPageSize(pagingValues.totalRecordCount);  

			//Apply paging
			if (pagingValues.start > 0) {
				pdfG304ySrhVO.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				pdfG304ySrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			//
			//Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

			@SuppressWarnings("unchecked")
			//	            Collection<Map<String, Object>> list ??????
			List list = pdfG304yDAO.selectPdfG304yList(pdfG304ySrhVO);

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

						if(	"resid".equals(tableAttributes[i].getName())) {

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

	/**
	 * 직불카드 등(2017년) 조회
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	//조회
	public PagingLoadResult<BaseModel> getYetaP220001ToPdfG306yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA2200_PDF_G306Y_DATA_LIST;
		InfcPkgPdfG306ySrhVO   pdfG306ySrhVO = new InfcPkgPdfG306ySrhVO();
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

		if  (MSFSharedUtils.paramNull(pdfG306yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfG306yDAO = (InfcPkgPdfG306yDAO) wac.getBean("InfcPkgPdfG306yDAO"); 
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
			pdfG306ySrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
			pdfG306ySrhVO.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));	// 정산구분 
			pdfG306ySrhVO.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));		// 귀속년도
			pdfG306ySrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));

			//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 

				//Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

				int iResultCnt = pdfG306yDAO.selectPdfG306yListTotCnt(pdfG306ySrhVO);

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
			pdfG306ySrhVO.setPageSize(pagingValues.totalRecordCount);  

			//Apply paging
			if (pagingValues.start > 0) {
				pdfG306ySrhVO.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				pdfG306ySrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			//
			//Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

			@SuppressWarnings("unchecked")
			//	            Collection<Map<String, Object>> list ??????
			List list = pdfG306yDAO.selectPdfG306yList(pdfG306ySrhVO);

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

						if(	"resid".equals(tableAttributes[i].getName())) {

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

	/**
	 * 주택임차차입급 원리금상환액 조회
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	//조회
	public PagingLoadResult<BaseModel> getYetaP220001ToPdfJ101yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA2200_PDF_J101Y_DATA_LIST;
		InfcPkgPdfJ101ySrhVO   pdfJ101ySrhVO = new InfcPkgPdfJ101ySrhVO();
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

		if  (MSFSharedUtils.paramNull(pdfJ101yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfJ101yDAO = (InfcPkgPdfJ101yDAO) wac.getBean("InfcPkgPdfJ101yDAO"); 
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
			pdfJ101ySrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
			pdfJ101ySrhVO.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));	// 정산구분 
			pdfJ101ySrhVO.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));		// 귀속년도
			pdfJ101ySrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));

			//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 

				//Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

				int iResultCnt = pdfJ101yDAO.selectPdfJ101yListTotCnt(pdfJ101ySrhVO);

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
			pdfJ101ySrhVO.setPageSize(pagingValues.totalRecordCount);  

			//Apply paging
			if (pagingValues.start > 0) {
				pdfJ101ySrhVO.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				pdfJ101ySrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			//
			//Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

			@SuppressWarnings("unchecked")
			//	            Collection<Map<String, Object>> list ??????
			List list = pdfJ101yDAO.selectPdfJ101yList(pdfJ101ySrhVO);

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

						if(	"resid".equals(tableAttributes[i].getName())) {

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

	/**
	 * 장기주택저당차입금 이자상환액 조회
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	//조회
	public PagingLoadResult<BaseModel> getYetaP220001ToPdfJ203yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA2200_PDF_J203Y_DATA_LIST;
		InfcPkgPdfJ203ySrhVO   pdfJ203ySrhVO = new InfcPkgPdfJ203ySrhVO();
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

		if  (MSFSharedUtils.paramNull(pdfJ203yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfJ203yDAO = (InfcPkgPdfJ203yDAO) wac.getBean("InfcPkgPdfJ203yDAO"); 
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
			pdfJ203ySrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
			pdfJ203ySrhVO.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));	// 정산구분 
			pdfJ203ySrhVO.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));		// 귀속년도
			pdfJ203ySrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));

			//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 

				//Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

				int iResultCnt = pdfJ203yDAO.selectPdfJ203yListTotCnt(pdfJ203ySrhVO);

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
			pdfJ203ySrhVO.setPageSize(pagingValues.totalRecordCount);  

			//Apply paging
			if (pagingValues.start > 0) {
				pdfJ203ySrhVO.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				pdfJ203ySrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			//
			//Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

			@SuppressWarnings("unchecked")
			//	            Collection<Map<String, Object>> list ??????
			List list = pdfJ203yDAO.selectPdfJ203yList(pdfJ203ySrhVO);

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

						if(	"resid".equals(tableAttributes[i].getName())) {

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

	/**
	 * 주택마련저축 조회
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	//조회
	public PagingLoadResult<BaseModel> getYetaP220001ToPdfJ301yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA2200_PDF_J301Y_DATA_LIST;
		InfcPkgPdfJ301ySrhVO   pdfJ301ySrhVO = new InfcPkgPdfJ301ySrhVO();
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

		if  (MSFSharedUtils.paramNull(pdfJ301yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfJ301yDAO = (InfcPkgPdfJ301yDAO) wac.getBean("InfcPkgPdfJ301yDAO"); 
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
			pdfJ301ySrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
			pdfJ301ySrhVO.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));	// 정산구분 
			pdfJ301ySrhVO.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));		// 귀속년도
			pdfJ301ySrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));

			//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 

				//Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

				int iResultCnt = pdfJ301yDAO.selectPdfJ301yListTotCnt(pdfJ301ySrhVO);

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
			pdfJ301ySrhVO.setPageSize(pagingValues.totalRecordCount);  

			//Apply paging
			if (pagingValues.start > 0) {
				pdfJ301ySrhVO.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				pdfJ301ySrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			//
			//Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

			@SuppressWarnings("unchecked")
			//	            Collection<Map<String, Object>> list ??????
			List list = pdfJ301yDAO.selectPdfJ301yList(pdfJ301ySrhVO);

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

						if(	"resid".equals(tableAttributes[i].getName())) {

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

	/**
	 * 목돈 안드는 전세 이자상환액 조회
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	//조회
	public PagingLoadResult<BaseModel> getYetaP220001ToPdfJ401yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA2200_PDF_J401Y_DATA_LIST;
		InfcPkgPdfJ401ySrhVO   pdfJ401ySrhVO = new InfcPkgPdfJ401ySrhVO();
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

		if  (MSFSharedUtils.paramNull(pdfJ401yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfJ401yDAO = (InfcPkgPdfJ401yDAO) wac.getBean("InfcPkgPdfJ401yDAO"); 
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
			pdfJ401ySrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
			pdfJ401ySrhVO.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));	// 정산구분 
			pdfJ401ySrhVO.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));		// 귀속년도
			pdfJ401ySrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));

			//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 

				//Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

				int iResultCnt = pdfJ401yDAO.selectPdfJ401yListTotCnt(pdfJ401ySrhVO);

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
			pdfJ401ySrhVO.setPageSize(pagingValues.totalRecordCount);  

			//Apply paging
			if (pagingValues.start > 0) {
				pdfJ401ySrhVO.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				pdfJ401ySrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			//
			//Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

			@SuppressWarnings("unchecked")
			//	            Collection<Map<String, Object>> list ??????
			List list = pdfJ401yDAO.selectPdfJ401yList(pdfJ401ySrhVO);

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

						if(	"resid".equals(tableAttributes[i].getName())) {

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

	/**
	 * 소기업소상공인 공제부금 조회
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	//조회
	public PagingLoadResult<BaseModel> getYetaP220001ToPdfK101yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA2200_PDF_K101Y_DATA_LIST;
		InfcPkgPdfK101ySrhVO   pdfK101ySrhVO = new InfcPkgPdfK101ySrhVO();
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

		if  (MSFSharedUtils.paramNull(pdfK101yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfK101yDAO = (InfcPkgPdfK101yDAO) wac.getBean("InfcPkgPdfK101yDAO"); 
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
			pdfK101ySrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
			pdfK101ySrhVO.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));	// 정산구분 
			pdfK101ySrhVO.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));		// 귀속년도
			pdfK101ySrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));

			//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 

				//Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

				int iResultCnt = pdfK101yDAO.selectPdfK101yListTotCnt(pdfK101ySrhVO);

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
			pdfK101ySrhVO.setPageSize(pagingValues.totalRecordCount);  

			//Apply paging
			if (pagingValues.start > 0) {
				pdfK101ySrhVO.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				pdfK101ySrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			//
			//Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

			@SuppressWarnings("unchecked")
			//	            Collection<Map<String, Object>> list ??????
			List list = pdfK101yDAO.selectPdfK101yList(pdfK101ySrhVO);

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

						if(	"resid".equals(tableAttributes[i].getName())) {

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

	/**
	 * 기부금 조회
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	//조회
	public PagingLoadResult<BaseModel> getYetaP220001ToPdfL102yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA2200_PDF_L102Y_DATA_LIST;
		InfcPkgPdfL102ySrhVO   pdfL102ySrhVO = new InfcPkgPdfL102ySrhVO();
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

		if  (MSFSharedUtils.paramNull(pdfL102yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfL102yDAO = (InfcPkgPdfL102yDAO) wac.getBean("InfcPkgPdfL102yDAO"); 
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
			pdfL102ySrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
			pdfL102ySrhVO.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));	// 정산구분 
			pdfL102ySrhVO.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));		// 귀속년도
			pdfL102ySrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));

			//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 

				//Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

				int iResultCnt = pdfL102yDAO.selectPdfL102yListTotCnt(pdfL102ySrhVO);

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
			pdfL102ySrhVO.setPageSize(pagingValues.totalRecordCount);  

			//Apply paging
			if (pagingValues.start > 0) {
				pdfL102ySrhVO.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				pdfL102ySrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			//
			//Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

			@SuppressWarnings("unchecked")
			//	            Collection<Map<String, Object>> list ??????
			List list = pdfL102yDAO.selectPdfL102yList(pdfL102ySrhVO);

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

						if(	"resid".equals(tableAttributes[i].getName())) {

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

	/**
	 * 장기집합투자증권저축 조회
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	//조회
	public PagingLoadResult<BaseModel> getYetaP220001ToPdfN101yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA2200_PDF_N101Y_DATA_LIST;
		InfcPkgPdfN101ySrhVO   pdfN101ySrhVO = new InfcPkgPdfN101ySrhVO();
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

		if  (MSFSharedUtils.paramNull(pdfN101yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfN101yDAO = (InfcPkgPdfN101yDAO) wac.getBean("InfcPkgPdfN101yDAO"); 
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
			pdfN101ySrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
			pdfN101ySrhVO.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));	// 정산구분 
			pdfN101ySrhVO.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));		// 귀속년도
			pdfN101ySrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));

			//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 

				//Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

				int iResultCnt = pdfN101yDAO.selectPdfN101yListTotCnt(pdfN101ySrhVO);

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
			pdfN101ySrhVO.setPageSize(pagingValues.totalRecordCount);  

			//Apply paging
			if (pagingValues.start > 0) {
				pdfN101ySrhVO.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				pdfN101ySrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			//
			//Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

			@SuppressWarnings("unchecked")
			//	            Collection<Map<String, Object>> list ??????
			List list = pdfN101yDAO.selectPdfN101yList(pdfN101ySrhVO);

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

						if(	"resid".equals(tableAttributes[i].getName())) {

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

	/**
	 * 건강보험료 조회
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	//조회
	public PagingLoadResult<BaseModel> getYetaP220001ToPdfO101yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA2200_PDF_O101Y_DATA_LIST;
		InfcPkgPdfO101ySrhVO   pdfO101ySrhVO = new InfcPkgPdfO101ySrhVO();
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

		if  (MSFSharedUtils.paramNull(pdfO101yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfO101yDAO = (InfcPkgPdfO101yDAO) wac.getBean("InfcPkgPdfO101yDAO"); 
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
			pdfO101ySrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
			pdfO101ySrhVO.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));	// 정산구분 
			pdfO101ySrhVO.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));		// 귀속년도
			pdfO101ySrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));

			//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 

				//Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

				int iResultCnt = pdfO101yDAO.selectPdfO101yListTotCnt(pdfO101ySrhVO);

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
			pdfO101ySrhVO.setPageSize(pagingValues.totalRecordCount);  

			//Apply paging
			if (pagingValues.start > 0) {
				pdfO101ySrhVO.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				pdfO101ySrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			//
			//Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

			@SuppressWarnings("unchecked")
			//	            Collection<Map<String, Object>> list ??????
			List list = pdfO101yDAO.selectPdfO101yList(pdfO101ySrhVO);

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

						if(	"resid".equals(tableAttributes[i].getName())) {

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

	/**
	 * 국민연금보험료 조회
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	//조회
	public PagingLoadResult<BaseModel> getYetaP220001ToPdfP101yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA2200_PDF_P101Y_DATA_LIST;
		InfcPkgPdfP101ySrhVO   pdfP101ySrhVO = new InfcPkgPdfP101ySrhVO();
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

		if  (MSFSharedUtils.paramNull(pdfP101yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfP101yDAO = (InfcPkgPdfP101yDAO) wac.getBean("InfcPkgPdfP101yDAO"); 
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
			pdfP101ySrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
			pdfP101ySrhVO.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));	// 정산구분 
			pdfP101ySrhVO.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));		// 귀속년도
			pdfP101ySrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));

			//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 

				//Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

				int iResultCnt = pdfP101yDAO.selectPdfP101yListTotCnt(pdfP101ySrhVO);

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
			pdfP101ySrhVO.setPageSize(pagingValues.totalRecordCount);  

			//Apply paging
			if (pagingValues.start > 0) {
				pdfP101ySrhVO.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				pdfP101ySrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			//
			//Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

			@SuppressWarnings("unchecked")
			//	            Collection<Map<String, Object>> list ??????
			List list = pdfP101yDAO.selectPdfP101yList(pdfP101ySrhVO);

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

						if(	"resid".equals(tableAttributes[i].getName())) {

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

	/**
	 * 국민연금보험료(2017년) 조회
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	//조회
	public PagingLoadResult<BaseModel> getYetaP220001ToPdfP102yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA2200_PDF_P102Y_DATA_LIST;
		InfcPkgPdfP102ySrhVO   pdfP102ySrhVO = new InfcPkgPdfP102ySrhVO();
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

		if  (MSFSharedUtils.paramNull(pdfP102yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfP102yDAO = (InfcPkgPdfP102yDAO) wac.getBean("InfcPkgPdfP102yDAO"); 
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
			pdfP102ySrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
			pdfP102ySrhVO.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));	// 정산구분 
			pdfP102ySrhVO.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));		// 귀속년도
			pdfP102ySrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));

			//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 

				//Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

				int iResultCnt = pdfP102yDAO.selectPdfP102yListTotCnt(pdfP102ySrhVO);

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
			pdfP102ySrhVO.setPageSize(pagingValues.totalRecordCount);  

			//Apply paging
			if (pagingValues.start > 0) {
				pdfP102ySrhVO.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				pdfP102ySrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			//
			//Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

			@SuppressWarnings("unchecked")
			//	            Collection<Map<String, Object>> list ??????
			List list = pdfP102yDAO.selectPdfP102yList(pdfP102ySrhVO);

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

						if(	"resid".equals(tableAttributes[i].getName())) {

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

	@Override
	public Integer updateYetaP220001ToPdfA102Y(List<PdfA102yDTO> listPdfA102yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP220001ToPdfA102Y";

		String windowNm = "보장성보험 업데이트";
		String windowId = "YETAP220001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfA102yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfA102yDAO = (InfcPkgPdfA102yDAO) wac.getBean("InfcPkgPdfA102yDAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfA102yVO pdfA102yVo = new InfcPkgPdfA102yVO();
		InfcPkgYe161010VO  ye161010Vo = new InfcPkgYe161010VO();
				
		try{

			for(int iYetaCnt=0; iYetaCnt < listPdfA102yDto.size(); iYetaCnt++) {

				PdfA102yDTO pdfA102yDto = new PdfA102yDTO();  
				pdfA102yDto = listPdfA102yDto.get(iYetaCnt);  
				
				pdfA102yVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
				pdfA102yVo.setSystemkey(MSFSharedUtils.allowNulls(pdfA102yDto.getSystemkey()));
				pdfA102yVo.setAccNo(MSFSharedUtils.allowNulls(pdfA102yDto.getAccNo()));
				pdfA102yVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfA102yDto.getYrtxBlggYr()));
				pdfA102yVo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfA102yDto.getClutSeptCd()));
				
				pdfA102yVo.setPdfDatAppYn(MSFSharedUtils.allowNulls(Boolean.parseBoolean(pdfA102yDto.getPdfDatAppYn())? "Y" : "N"));
				pdfA102yVo.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(pdfA102yDto.getPdfDatAppExcCtnt()));
				
				pdfA102yVo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
				pdfA102yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				pdfA102yDAO.updateYetaP220001ToPdfA102y(pdfA102yVo);
				
				if (iCnt == 0) {
					ye161010Vo.setDpobCd(MSFSharedUtils.allowNulls(pdfA102yVo.getDpobCd()));    					/** column 사업장코드 : dpobCd */
		        	ye161010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfA102yVo.getYrtxBlggYr()));    			/** column 귀속연도 : yrtxBlggYr */
		        	ye161010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfA102yVo.getClutSeptCd()));    			/** column 연말정산구분코드 : clutSeptCd */
		        	ye161010Vo.setSystemkey(MSFSharedUtils.allowNulls(pdfA102yVo.getSystemkey()));    				/** column SYSTEMKEY : systemkey */
				}
				
				iCnt = iCnt + 1;
			}

			/***************************************************************************************************************************
			 * pdf 저장 후 체크된 데이타에 대해서 업데이트 인서트 한다 
			 ***************************************************************************************************************************/
			ye161010Vo.setXmlFormCd("A102Y");
			Func_PdfXml_Yeta2017_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2017_Insert();
			funcPdfXmlIn.pdfXml_Yeta2017_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
			
			result = iCnt;

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

		return result;

	}

	@Override
	public Integer updateYetaP220001ToPdfB101Y(List<PdfB101yDTO> listPdfB101yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP220001ToPdfB101Y";

		String windowNm = "의료비 업데이트";
		String windowId = "YETAP220001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfB101yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfB101yDAO = (InfcPkgPdfB101yDAO) wac.getBean("InfcPkgPdfB101yDAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfB101yVO pdfB101yVo = new InfcPkgPdfB101yVO();
		InfcPkgYe161010VO  ye161010Vo = new InfcPkgYe161010VO();
		
		try{

			for(int iYetaCnt=0; iYetaCnt < listPdfB101yDto.size(); iYetaCnt++) {

				PdfB101yDTO pdfB101yDto = new PdfB101yDTO();  
				pdfB101yDto = listPdfB101yDto.get(iYetaCnt);  
				
				pdfB101yVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
				pdfB101yVo.setSystemkey(MSFSharedUtils.allowNulls(pdfB101yDto.getSystemkey()));
				pdfB101yVo.setManSeilNum(MSFSharedUtils.convertStringToBigDecimal(String.valueOf(pdfB101yDto.getManSeilNum())));
				pdfB101yVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfB101yDto.getYrtxBlggYr()));
				pdfB101yVo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfB101yDto.getClutSeptCd()));
				
				pdfB101yVo.setPdfDatAppYn(MSFSharedUtils.allowNulls(Boolean.parseBoolean(pdfB101yDto.getPdfDatAppYn())? "Y" : "N"));
				pdfB101yVo.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(pdfB101yDto.getPdfDatAppExcCtnt()));
				
				pdfB101yVo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
				pdfB101yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				pdfB101yDAO.updateYetaP220001ToPdfB101y(pdfB101yVo);

				if (iCnt == 0) {
					ye161010Vo.setDpobCd(MSFSharedUtils.allowNulls(pdfB101yVo.getDpobCd()));    					/** column 사업장코드 : dpobCd */
		        	ye161010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfB101yVo.getYrtxBlggYr()));    			/** column 귀속연도 : yrtxBlggYr */
		        	ye161010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfB101yVo.getClutSeptCd()));    			/** column 연말정산구분코드 : clutSeptCd */
		        	ye161010Vo.setSystemkey(MSFSharedUtils.allowNulls(pdfB101yVo.getSystemkey()));    				/** column SYSTEMKEY : systemkey */
				}
				
				iCnt = iCnt + 1;
			}

			/***************************************************************************************************************************
			 * pdf 저장 후 체크된 데이타에 대해서 업데이트 인서트 한다 
			 ***************************************************************************************************************************/
			ye161010Vo.setXmlFormCd("B101Y");
			Func_PdfXml_Yeta2017_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2017_Insert();
			funcPdfXmlIn.pdfXml_Yeta2017_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest()); 
			
			result = iCnt;

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

		return result;
	}

	@Override
	public Integer updateYetaP220001ToPdfC101Y(List<PdfC101yDTO> listPdfC101yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP220001ToPdfC101Y";

		String windowNm = "교육비 업데이트";
		String windowId = "YETAP220001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfC101yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfC101yDAO = (InfcPkgPdfC101yDAO) wac.getBean("InfcPkgPdfC101yDAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfC101yVO pdfC101yVo = new InfcPkgPdfC101yVO();
		InfcPkgYe161010VO  ye161010Vo = new InfcPkgYe161010VO();
		
		try{

			for(int iYetaCnt=0; iYetaCnt < listPdfC101yDto.size(); iYetaCnt++) {

				PdfC101yDTO pdfC101yDto = new PdfC101yDTO();  
				pdfC101yDto = listPdfC101yDto.get(iYetaCnt);  
				
				pdfC101yVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
				pdfC101yVo.setSystemkey(MSFSharedUtils.allowNulls(pdfC101yDto.getSystemkey()));
				pdfC101yVo.setEdiSeilNum(MSFSharedUtils.convertStringToBigDecimal(String.valueOf(pdfC101yDto.getEdiSeilNum())));
				pdfC101yVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfC101yDto.getYrtxBlggYr()));
				pdfC101yVo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfC101yDto.getClutSeptCd()));
				
				pdfC101yVo.setPdfDatAppYn(MSFSharedUtils.allowNulls(Boolean.parseBoolean(pdfC101yDto.getPdfDatAppYn())? "Y" : "N"));
				pdfC101yVo.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(pdfC101yDto.getPdfDatAppExcCtnt()));
				
				pdfC101yVo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
				pdfC101yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				pdfC101yDAO.updateYetaP220001ToPdfC101y(pdfC101yVo);
				
				if (iCnt == 0) {
					ye161010Vo.setDpobCd(MSFSharedUtils.allowNulls(pdfC101yDto.getDpobCd()));    					/** column 사업장코드 : dpobCd */
		        	ye161010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfC101yDto.getYrtxBlggYr()));    			/** column 귀속연도 : yrtxBlggYr */
		        	ye161010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfC101yDto.getClutSeptCd()));    			/** column 연말정산구분코드 : clutSeptCd */
		        	ye161010Vo.setSystemkey(MSFSharedUtils.allowNulls(pdfC101yDto.getSystemkey()));    				/** column SYSTEMKEY : systemkey */
				}
				
				iCnt = iCnt + 1;
			}
			
			/***************************************************************************************************************************
			 * pdf 저장 후 체크된 데이타에 대해서 업데이트 인서트 한다 
			 ***************************************************************************************************************************/
			ye161010Vo.setXmlFormCd("C101Y");
			Func_PdfXml_Yeta2017_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2017_Insert();
			funcPdfXmlIn.pdfXml_Yeta2017_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
			
			result = iCnt;

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

		return result;
	}

	@Override
	public Integer updateYetaP220001ToPdfC202Y(List<PdfC202yDTO> listPdfC202yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP220001ToPdfC202Y";

		String windowNm = "직업훈련비 업데이트";
		String windowId = "YETAP220001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfC202yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfC202yDAO = (InfcPkgPdfC202yDAO) wac.getBean("InfcPkgPdfC202yDAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfC202yVO pdfC202yVo = new InfcPkgPdfC202yVO();
		InfcPkgYe161010VO  ye161010Vo = new InfcPkgYe161010VO();
		try{

			for(int iYetaCnt=0; iYetaCnt < listPdfC202yDto.size(); iYetaCnt++) {

				PdfC202yDTO pdfC202yDto = new PdfC202yDTO();  
				pdfC202yDto = listPdfC202yDto.get(iYetaCnt);  
				
				pdfC202yVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
				pdfC202yVo.setSystemkey(MSFSharedUtils.allowNulls(pdfC202yDto.getSystemkey()));
				pdfC202yVo.setJbEdiSeilNum(MSFSharedUtils.convertStringToBigDecimal(String.valueOf(pdfC202yDto.getJbEdiSeilNum())));
				pdfC202yVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfC202yDto.getYrtxBlggYr()));
				pdfC202yVo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfC202yDto.getClutSeptCd()));
				
				pdfC202yVo.setPdfDatAppYn(MSFSharedUtils.allowNulls(Boolean.parseBoolean(pdfC202yDto.getPdfDatAppYn())? "Y" : "N"));
				pdfC202yVo.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(pdfC202yDto.getPdfDatAppExcCtnt()));
				
				pdfC202yVo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
				pdfC202yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				pdfC202yDAO.updateYetaP220001ToPdfC202y(pdfC202yVo);
				
				
				if (iCnt == 0) {
					ye161010Vo.setDpobCd(MSFSharedUtils.allowNulls(pdfC202yDto.getDpobCd()));    					/** column 사업장코드 : dpobCd */
		        	ye161010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfC202yDto.getYrtxBlggYr()));    			/** column 귀속연도 : yrtxBlggYr */
		        	ye161010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfC202yDto.getClutSeptCd()));    			/** column 연말정산구분코드 : clutSeptCd */
		        	ye161010Vo.setSystemkey(MSFSharedUtils.allowNulls(pdfC202yDto.getSystemkey()));    				/** column SYSTEMKEY : systemkey */
				}
				
				iCnt = iCnt + 1;
			}
			
			/***************************************************************************************************************************
			 * pdf 저장 후 체크된 데이타에 대해서 업데이트 인서트 한다 
			 ***************************************************************************************************************************/
			ye161010Vo.setXmlFormCd("C202Y");
			Func_PdfXml_Yeta2017_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2017_Insert();
			funcPdfXmlIn.pdfXml_Yeta2017_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
			
			result = iCnt;

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

		return result;
	}

	@Override
	public Integer updateYetaP220001ToPdfC301Y(List<PdfC301yDTO> listPdfC301yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP220001ToPdfC301Y";

		String windowNm = "교복구입비 업데이트";
		String windowId = "YETAP220001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfC301yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfC301yDAO = (InfcPkgPdfC301yDAO) wac.getBean("InfcPkgPdfC301yDAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfC301yVO pdfC301yVo = new InfcPkgPdfC301yVO();
		InfcPkgYe161010VO  ye161010Vo = new InfcPkgYe161010VO();
		try{

			for(int iYetaCnt=0; iYetaCnt < listPdfC301yDto.size(); iYetaCnt++) {

				PdfC301yDTO pdfC301yDto = new PdfC301yDTO();  
				pdfC301yDto = listPdfC301yDto.get(iYetaCnt);  
				
				pdfC301yVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
				pdfC301yVo.setSystemkey(MSFSharedUtils.allowNulls(pdfC301yDto.getSystemkey()));
				pdfC301yVo.setSchUniSeilNum(MSFSharedUtils.convertStringToBigDecimal(String.valueOf(pdfC301yDto.getSchUniSeilNum())));
				pdfC301yVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfC301yDto.getYrtxBlggYr()));
				pdfC301yVo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfC301yDto.getClutSeptCd()));
				
				pdfC301yVo.setPdfDatAppYn(MSFSharedUtils.allowNulls(Boolean.parseBoolean(pdfC301yDto.getPdfDatAppYn())? "Y" : "N"));
				pdfC301yVo.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(pdfC301yDto.getPdfDatAppExcCtnt()));
				
				pdfC301yVo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
				pdfC301yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				pdfC301yDAO.updateYetaP220001ToPdfC301y(pdfC301yVo);
			
				if (iCnt == 0) {
					ye161010Vo.setDpobCd(MSFSharedUtils.allowNulls(pdfC301yDto.getDpobCd()));    					/** column 사업장코드 : dpobCd */
		        	ye161010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfC301yDto.getYrtxBlggYr()));    			/** column 귀속연도 : yrtxBlggYr */
		        	ye161010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfC301yDto.getClutSeptCd()));    			/** column 연말정산구분코드 : clutSeptCd */
		        	ye161010Vo.setSystemkey(MSFSharedUtils.allowNulls(pdfC301yDto.getSystemkey()));    				/** column SYSTEMKEY : systemkey */
				}
				
				iCnt = iCnt + 1;
			}
			
			/***************************************************************************************************************************
			 * pdf 저장 후 체크된 데이타에 대해서 업데이트 인서트 한다 
			 ***************************************************************************************************************************/
			ye161010Vo.setXmlFormCd("C301Y");
			Func_PdfXml_Yeta2017_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2017_Insert();
			funcPdfXmlIn.pdfXml_Yeta2017_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
			
			result = iCnt;

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

		return result;
	}

	@Override
	public Integer updateYetaP220001ToPdfC401Y(List<PdfC401yDTO> listPdfC401yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP220001ToPdfC401Y";

		String windowNm = "학자금대출상환액 업데이트";
		String windowId = "YETAP220001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfC401yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfC401yDAO = (InfcPkgPdfC401yDAO) wac.getBean("InfcPkgPdfC401yDAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfC401yVO pdfC401yVo = new InfcPkgPdfC401yVO();
		InfcPkgYe161010VO  ye161010Vo = new InfcPkgYe161010VO();
		try{

			for(int iYetaCnt=0; iYetaCnt < listPdfC401yDto.size(); iYetaCnt++) {

				PdfC401yDTO pdfC401yDto = new PdfC401yDTO();  
				pdfC401yDto = listPdfC401yDto.get(iYetaCnt);  
				
				pdfC401yVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
				pdfC401yVo.setSystemkey(MSFSharedUtils.allowNulls(pdfC401yDto.getSystemkey()));
				pdfC401yVo.setSchUniSeilNum(MSFSharedUtils.convertStringToBigDecimal(String.valueOf(pdfC401yDto.getSchUniSeilNum())));
				pdfC401yVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfC401yDto.getYrtxBlggYr()));
				pdfC401yVo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfC401yDto.getClutSeptCd()));
				
				pdfC401yVo.setPdfDatAppYn(MSFSharedUtils.allowNulls(Boolean.parseBoolean(pdfC401yDto.getPdfDatAppYn())? "Y" : "N"));
				pdfC401yVo.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(pdfC401yDto.getPdfDatAppExcCtnt()));
				
				pdfC401yVo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
				pdfC401yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				pdfC401yDAO.updateYetaP220001ToPdfC401y(pdfC401yVo);
				
				if (iCnt == 0) {
					ye161010Vo.setDpobCd(MSFSharedUtils.allowNulls(pdfC401yVo.getDpobCd()));    					/** column 사업장코드 : dpobCd */
		        	ye161010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfC401yVo.getYrtxBlggYr()));    			/** column 귀속연도 : yrtxBlggYr */
		        	ye161010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfC401yVo.getClutSeptCd()));    			/** column 연말정산구분코드 : clutSeptCd */
		        	ye161010Vo.setSystemkey(MSFSharedUtils.allowNulls(pdfC401yVo.getSystemkey()));    				/** column SYSTEMKEY : systemkey */
				}
				
				iCnt = iCnt + 1;
			}
			
			/***************************************************************************************************************************
			 * pdf 저장 후 체크된 데이타에 대해서 업데이트 인서트 한다 
			 ***************************************************************************************************************************/
			ye161010Vo.setXmlFormCd("C401Y");
			Func_PdfXml_Yeta2017_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2017_Insert();
			funcPdfXmlIn.pdfXml_Yeta2017_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
			
			

			result = iCnt;

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

		return result;
	}

	@Override
	public Integer updateYetaP220001ToPdfD101Y(List<PdfD101yDTO> listPdfD101yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP220001ToPdfD101Y";

		String windowNm = "개인연금저축 업데이트";
		String windowId = "YETAP220001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfD101yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfD101yDAO = (InfcPkgPdfD101yDAO) wac.getBean("InfcPkgPdfD101yDAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfD101yVO pdfD101yVo = new InfcPkgPdfD101yVO();
		InfcPkgYe161010VO  ye161010Vo = new InfcPkgYe161010VO();
		
		try{

			for(int iYetaCnt=0; iYetaCnt < listPdfD101yDto.size(); iYetaCnt++) {

				PdfD101yDTO pdfD101yDto = new PdfD101yDTO();  
				pdfD101yDto = listPdfD101yDto.get(iYetaCnt);  
				
				pdfD101yVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
				pdfD101yVo.setSystemkey(MSFSharedUtils.allowNulls(pdfD101yDto.getSystemkey()));
				pdfD101yVo.setPnsnSeilNum(MSFSharedUtils.allowNulls(pdfD101yDto.getPnsnSeilNum()));
				pdfD101yVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfD101yDto.getYrtxBlggYr()));
				pdfD101yVo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfD101yDto.getClutSeptCd()));
				
				pdfD101yVo.setPdfDatAppYn(MSFSharedUtils.allowNulls(Boolean.parseBoolean(pdfD101yDto.getPdfDatAppYn())? "Y" : "N"));
				pdfD101yVo.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(pdfD101yDto.getPdfDatAppExcCtnt()));
				
				pdfD101yVo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
				pdfD101yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				pdfD101yDAO.updateYetaP220001ToPdfD101y(pdfD101yVo);
				
				if (iCnt == 0) {
					ye161010Vo.setDpobCd(MSFSharedUtils.allowNulls(pdfD101yVo.getDpobCd()));    					/** column 사업장코드 : dpobCd */
		        	ye161010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfD101yVo.getYrtxBlggYr()));    			/** column 귀속연도 : yrtxBlggYr */
		        	ye161010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfD101yVo.getClutSeptCd()));    			/** column 연말정산구분코드 : clutSeptCd */
		        	ye161010Vo.setSystemkey(MSFSharedUtils.allowNulls(pdfD101yVo.getSystemkey()));    				/** column SYSTEMKEY : systemkey */
				}
				
				iCnt = iCnt + 1;
			}

			/***************************************************************************************************************************
			 * pdf 저장 후 체크된 데이타에 대해서 업데이트 인서트 한다 
			 ***************************************************************************************************************************/
			ye161010Vo.setXmlFormCd("D101Y");
			Func_PdfXml_Yeta2017_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2017_Insert();
			funcPdfXmlIn.pdfXml_Yeta2017_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
			
			result = iCnt;

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

		return result;
	}

	@Override
	public Integer updateYetaP220001ToPdfE102Y(List<PdfE102yDTO> listPdfE102yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP220001ToPdfE102Y";

		String windowNm = "연금저축  업데이트";
		String windowId = "YETAP220001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfE102yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfE102yDAO = (InfcPkgPdfE102yDAO) wac.getBean("InfcPkgPdfE102yDAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfE102yVO pdfE102yVo = new InfcPkgPdfE102yVO();
		InfcPkgYe161010VO  ye161010Vo = new InfcPkgYe161010VO();
		try{

			for(int iYetaCnt=0; iYetaCnt < listPdfE102yDto.size(); iYetaCnt++) {

				PdfE102yDTO pdfE102yDto = new PdfE102yDTO();  
				pdfE102yDto = listPdfE102yDto.get(iYetaCnt);  
				
				pdfE102yVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
				pdfE102yVo.setSystemkey(MSFSharedUtils.allowNulls(pdfE102yDto.getSystemkey()));
				pdfE102yVo.setPnsnSvSeilNum(MSFSharedUtils.allowNulls(pdfE102yDto.getPnsnSvSeilNum()));
				pdfE102yVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfE102yDto.getYrtxBlggYr()));
				pdfE102yVo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfE102yDto.getClutSeptCd()));
				
				pdfE102yVo.setPdfDatAppYn(MSFSharedUtils.allowNulls(Boolean.parseBoolean(pdfE102yDto.getPdfDatAppYn())? "Y" : "N"));
				pdfE102yVo.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(pdfE102yDto.getPdfDatAppExcCtnt()));
				
				pdfE102yVo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
				pdfE102yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				pdfE102yDAO.updateYetaP220001ToPdfE102y(pdfE102yVo);
				
				if (iCnt == 0) {
					ye161010Vo.setDpobCd(MSFSharedUtils.allowNulls(pdfE102yVo.getDpobCd()));    					/** column 사업장코드 : dpobCd */
		        	ye161010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfE102yVo.getYrtxBlggYr()));    			/** column 귀속연도 : yrtxBlggYr */
		        	ye161010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfE102yVo.getClutSeptCd()));    			/** column 연말정산구분코드 : clutSeptCd */
		        	ye161010Vo.setSystemkey(MSFSharedUtils.allowNulls(pdfE102yVo.getSystemkey()));    				/** column SYSTEMKEY : systemkey */
				}
				
				/***************************************************************************************************************************
				 * pdf 저장 후 체크된 데이타에 대해서 업데이트 인서트 한다 
				 ***************************************************************************************************************************/
				ye161010Vo.setXmlFormCd("E102Y");
				Func_PdfXml_Yeta2017_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2017_Insert();
				funcPdfXmlIn.pdfXml_Yeta2017_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
				
				
				iCnt = iCnt + 1;
			}

			result = iCnt;

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

		return result;
	}

	@Override
	public Integer updateYetaP220001ToPdfF102Y(List<PdfF102yDTO> listPdfF102yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP220001ToPdfF102Y";

		String windowNm = "퇴직연금 업데이트";
		String windowId = "YETAP220001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfF102yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfF102yDAO = (InfcPkgPdfF102yDAO) wac.getBean("InfcPkgPdfF102yDAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfF102yVO pdfF102yVo = new InfcPkgPdfF102yVO();
		InfcPkgYe161010VO  ye161010Vo = new InfcPkgYe161010VO();
		try{

			for(int iYetaCnt=0; iYetaCnt < listPdfF102yDto.size(); iYetaCnt++) {

				PdfF102yDTO pdfF102yDto = new PdfF102yDTO();  
				pdfF102yDto = listPdfF102yDto.get(iYetaCnt);  
				
				pdfF102yVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
				pdfF102yVo.setSystemkey(MSFSharedUtils.allowNulls(pdfF102yDto.getSystemkey()));
				pdfF102yVo.setAccNo(MSFSharedUtils.allowNulls(pdfF102yDto.getAccNo()));
				pdfF102yVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfF102yDto.getYrtxBlggYr()));
				pdfF102yVo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfF102yDto.getClutSeptCd()));
				
				pdfF102yVo.setPdfDatAppYn(MSFSharedUtils.allowNulls(Boolean.parseBoolean(pdfF102yDto.getPdfDatAppYn())? "Y" : "N"));
				pdfF102yVo.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(pdfF102yDto.getPdfDatAppExcCtnt()));
				
				pdfF102yVo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
				pdfF102yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				pdfF102yDAO.updateYetaP220001ToPdfF102y(pdfF102yVo);
				
				if (iCnt == 0) {
					ye161010Vo.setDpobCd(MSFSharedUtils.allowNulls(pdfF102yVo.getDpobCd()));    					/** column 사업장코드 : dpobCd */
		        	ye161010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfF102yVo.getYrtxBlggYr()));    			/** column 귀속연도 : yrtxBlggYr */
		        	ye161010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfF102yVo.getClutSeptCd()));    			/** column 연말정산구분코드 : clutSeptCd */
		        	ye161010Vo.setSystemkey(MSFSharedUtils.allowNulls(pdfF102yVo.getSystemkey()));    				/** column SYSTEMKEY : systemkey */
				}
				
				iCnt = iCnt + 1;
			}

			/***************************************************************************************************************************
			 * pdf 저장 후 체크된 데이타에 대해서 업데이트 인서트 한다 
			 ***************************************************************************************************************************/
			ye161010Vo.setXmlFormCd("F102Y");
			Func_PdfXml_Yeta2017_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2017_Insert();
			funcPdfXmlIn.pdfXml_Yeta2017_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
			
			result = iCnt;

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

		return result;

	}

	@Override
	public Integer updateYetaP220001ToPdfG106Y(List<PdfG106yDTO> listPdfG106yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP220001ToPdfG106Y";

		String windowNm = "신용카드 업데이트";
		String windowId = "YETAP220001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfG106yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfG106yDAO = (InfcPkgPdfG106yDAO) wac.getBean("InfcPkgPdfG106yDAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfG106yVO pdfG106yVo = new InfcPkgPdfG106yVO();
		InfcPkgYe161010VO  ye161010Vo = new InfcPkgYe161010VO();
		try{

			for(int iYetaCnt=0; iYetaCnt < listPdfG106yDto.size(); iYetaCnt++) {

				PdfG106yDTO pdfG106yDto = new PdfG106yDTO();  
				pdfG106yDto = listPdfG106yDto.get(iYetaCnt);  
				
				pdfG106yVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
				pdfG106yVo.setSystemkey(MSFSharedUtils.allowNulls(pdfG106yDto.getSystemkey()));
				pdfG106yVo.setCardSeilNum(MSFSharedUtils.convertStringToBigDecimal(String.valueOf(pdfG106yDto.getCardSeilNum())));
				pdfG106yVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfG106yDto.getYrtxBlggYr()));
				pdfG106yVo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfG106yDto.getClutSeptCd()));
				
				pdfG106yVo.setPdfDatAppYn(MSFSharedUtils.allowNulls(Boolean.parseBoolean(pdfG106yDto.getPdfDatAppYn())? "Y" : "N"));
				pdfG106yVo.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(pdfG106yDto.getPdfDatAppExcCtnt()));
				
				pdfG106yVo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
				pdfG106yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				pdfG106yDAO.updateYetaP220001ToPdfG106y(pdfG106yVo);
			
				if (iCnt == 0) {
					ye161010Vo.setDpobCd(MSFSharedUtils.allowNulls(pdfG106yVo.getDpobCd()));    					/** column 사업장코드 : dpobCd */
		        	ye161010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfG106yVo.getYrtxBlggYr()));    			/** column 귀속연도 : yrtxBlggYr */
		        	ye161010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfG106yVo.getClutSeptCd()));    			/** column 연말정산구분코드 : clutSeptCd */
		        	ye161010Vo.setSystemkey(MSFSharedUtils.allowNulls(pdfG106yVo.getSystemkey()));    				/** column SYSTEMKEY : systemkey */
				}
				
				iCnt = iCnt + 1;
			}


			/***************************************************************************************************************************
			 * pdf 저장 후 체크된 데이타에 대해서 업데이트 인서트 한다 
			 ***************************************************************************************************************************/
			ye161010Vo.setXmlFormCd("G106Y");
			Func_PdfXml_Yeta2017_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2017_Insert();
			funcPdfXmlIn.pdfXml_Yeta2017_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
			
			
			result = iCnt;

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

		return result;
	}

	@Override
	public Integer updateYetaP220001ToPdfG206Y(List<PdfG206yDTO> listPdfG206yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP220001ToPdfG206Y";

		String windowNm = "현금영수증 업데이트";
		String windowId = "YETAP220001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfG206yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfG206yDAO = (InfcPkgPdfG206yDAO) wac.getBean("InfcPkgPdfG206yDAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfG206yVO pdfG206yVo = new InfcPkgPdfG206yVO();
		InfcPkgYe161010VO  ye161010Vo = new InfcPkgYe161010VO();
		
		try{

			for(int iYetaCnt=0; iYetaCnt < listPdfG206yDto.size(); iYetaCnt++) {

				PdfG206yDTO pdfG206yDto = new PdfG206yDTO();  
				pdfG206yDto = listPdfG206yDto.get(iYetaCnt);  
				
				pdfG206yVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
				pdfG206yVo.setSystemkey(MSFSharedUtils.allowNulls(pdfG206yDto.getSystemkey()));
				pdfG206yVo.setCashCardSeilNum(MSFSharedUtils.convertStringToBigDecimal(String.valueOf(pdfG206yDto.getCashCardSeilNum())));
				pdfG206yVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfG206yDto.getYrtxBlggYr()));
				pdfG206yVo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfG206yDto.getClutSeptCd()));
				
				pdfG206yVo.setPdfDatAppYn(MSFSharedUtils.allowNulls(Boolean.parseBoolean(pdfG206yDto.getPdfDatAppYn())? "Y" : "N"));
				pdfG206yVo.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(pdfG206yDto.getPdfDatAppExcCtnt()));
				
				pdfG206yVo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
				pdfG206yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				pdfG206yDAO.updateYetaP220001ToPdfG206y(pdfG206yVo);
				
				if (iCnt == 0) {
					ye161010Vo.setDpobCd(MSFSharedUtils.allowNulls(pdfG206yVo.getDpobCd()));    					/** column 사업장코드 : dpobCd */
		        	ye161010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfG206yVo.getYrtxBlggYr()));    			/** column 귀속연도 : yrtxBlggYr */
		        	ye161010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfG206yVo.getClutSeptCd()));    			/** column 연말정산구분코드 : clutSeptCd */
		        	ye161010Vo.setSystemkey(MSFSharedUtils.allowNulls(pdfG206yVo.getSystemkey()));    				/** column SYSTEMKEY : systemkey */
				}
				
				iCnt = iCnt + 1;
			}
			
			/***************************************************************************************************************************
			 * pdf 저장 후 체크된 데이타에 대해서 업데이트 인서트 한다 
			 ***************************************************************************************************************************/
			ye161010Vo.setXmlFormCd("G206M");
			Func_PdfXml_Yeta2017_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2017_Insert();
			funcPdfXmlIn.pdfXml_Yeta2017_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
			

			result = iCnt;

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

		return result;
	}

	@Override
	public Integer updateYetaP220001ToPdfG306Y(List<PdfG306yDTO> listPdfG306yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP220001ToPdfG306Y";

		String windowNm = "직불카드 업데이트";
		String windowId = "YETAP220001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfG306yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfG306yDAO = (InfcPkgPdfG306yDAO) wac.getBean("InfcPkgPdfG306yDAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfG306yVO pdfG306yVo = new InfcPkgPdfG306yVO();
		InfcPkgYe161010VO  ye161010Vo = new InfcPkgYe161010VO();
		
		try{

			for(int iYetaCnt=0; iYetaCnt < listPdfG306yDto.size(); iYetaCnt++) {

				PdfG306yDTO pdfG306yDto = new PdfG306yDTO();  
				pdfG306yDto = listPdfG306yDto.get(iYetaCnt);  
				
				pdfG306yVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
				pdfG306yVo.setSystemkey(MSFSharedUtils.allowNulls(pdfG306yDto.getSystemkey()));
				pdfG306yVo.setDirCardSeilNum(MSFSharedUtils.convertStringToBigDecimal(String.valueOf(pdfG306yDto.getDirCardSeilNum())));
				pdfG306yVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfG306yDto.getYrtxBlggYr()));
				pdfG306yVo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfG306yDto.getClutSeptCd()));
				
				pdfG306yVo.setPdfDatAppYn(MSFSharedUtils.allowNulls(Boolean.parseBoolean(pdfG306yDto.getPdfDatAppYn())? "Y" : "N"));
				pdfG306yVo.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(pdfG306yDto.getPdfDatAppExcCtnt()));
				
				pdfG306yVo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
				pdfG306yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				pdfG306yDAO.updateYetaP220001ToPdfG306y(pdfG306yVo);
				
				if (iCnt == 0) {
					ye161010Vo.setDpobCd(MSFSharedUtils.allowNulls(pdfG306yVo.getDpobCd()));    					/** column 사업장코드 : dpobCd */
		        	ye161010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfG306yVo.getYrtxBlggYr()));    			/** column 귀속연도 : yrtxBlggYr */
		        	ye161010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfG306yVo.getClutSeptCd()));    			/** column 연말정산구분코드 : clutSeptCd */
		        	ye161010Vo.setSystemkey(MSFSharedUtils.allowNulls(pdfG306yVo.getSystemkey()));    				/** column SYSTEMKEY : systemkey */
				}
				
				iCnt = iCnt + 1;
			}

			/***************************************************************************************************************************
			 * pdf 저장 후 체크된 데이타에 대해서 업데이트 인서트 한다 
			 ***************************************************************************************************************************/
			ye161010Vo.setXmlFormCd("G306Y");
			Func_PdfXml_Yeta2017_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2017_Insert();
			funcPdfXmlIn.pdfXml_Yeta2017_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
			
			
			result = iCnt;

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

		return result;
	}

	@Override
	public Integer updateYetaP220001ToPdfJ101Y(List<PdfJ101yDTO> listPdfJ101yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP220001ToPdfJ101Y";

		String windowNm = "주택임차차입금원리금상환액 업데이트";
		String windowId = "YETAP220001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfJ101yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfJ101yDAO = (InfcPkgPdfJ101yDAO) wac.getBean("InfcPkgPdfJ101yDAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfJ101yVO pdfJ101yVo = new InfcPkgPdfJ101yVO();
		InfcPkgYe161010VO  ye161010Vo = new InfcPkgYe161010VO();
		
		try{

			for(int iYetaCnt=0; iYetaCnt < listPdfJ101yDto.size(); iYetaCnt++) {

				PdfJ101yDTO pdfJ101yDto = new PdfJ101yDTO();  
				pdfJ101yDto = listPdfJ101yDto.get(iYetaCnt);  
				
				pdfJ101yVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
				pdfJ101yVo.setSystemkey(MSFSharedUtils.allowNulls(pdfJ101yDto.getSystemkey()));
				pdfJ101yVo.setTradeSeilNum(MSFSharedUtils.convertStringToBigDecimal(String.valueOf(pdfJ101yDto.getTradeSeilNum())));
				pdfJ101yVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfJ101yDto.getYrtxBlggYr()));
				pdfJ101yVo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfJ101yDto.getClutSeptCd()));
				
				pdfJ101yVo.setPdfDatAppYn(MSFSharedUtils.allowNulls(Boolean.parseBoolean(pdfJ101yDto.getPdfDatAppYn())? "Y" : "N"));
				pdfJ101yVo.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(pdfJ101yDto.getPdfDatAppExcCtnt()));
				
				pdfJ101yVo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
				pdfJ101yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				pdfJ101yDAO.updateYetaP220001ToPdfJ101y(pdfJ101yVo);
				
				if (iCnt == 0) {
					ye161010Vo.setDpobCd(MSFSharedUtils.allowNulls(pdfJ101yVo.getDpobCd()));    					/** column 사업장코드 : dpobCd */
		        	ye161010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfJ101yVo.getYrtxBlggYr()));    			/** column 귀속연도 : yrtxBlggYr */
		        	ye161010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfJ101yVo.getClutSeptCd()));    			/** column 연말정산구분코드 : clutSeptCd */
		        	ye161010Vo.setSystemkey(MSFSharedUtils.allowNulls(pdfJ101yVo.getSystemkey()));    				/** column SYSTEMKEY : systemkey */
				}
				
			 
				
				iCnt = iCnt + 1;
			}

			/***************************************************************************************************************************
			 * pdf 저장 후 체크된 데이타에 대해서 업데이트 인서트 한다 
			 ***************************************************************************************************************************/
			ye161010Vo.setXmlFormCd("J101Y");
			Func_PdfXml_Yeta2017_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2017_Insert();
			funcPdfXmlIn.pdfXml_Yeta2017_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
			
			
			result = iCnt;

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

		return result;
	}

	@Override
	public Integer updateYetaP220001ToPdfJ203Y(List<PdfJ203yDTO> listPdfJ203yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP220001ToPdfJ203Y";

		String windowNm = "장기주택저당차입금이자상환액 업데이트";
		String windowId = "YETAP220001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfJ203yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfJ203yDAO = (InfcPkgPdfJ203yDAO) wac.getBean("InfcPkgPdfJ203yDAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfJ203yVO pdfJ203yVo = new InfcPkgPdfJ203yVO();
		InfcPkgYe161010VO  ye161010Vo = new InfcPkgYe161010VO();
		
		try{

			for(int iYetaCnt=0; iYetaCnt < listPdfJ203yDto.size(); iYetaCnt++) {

				PdfJ203yDTO pdfJ203yDto = new PdfJ203yDTO();  
				pdfJ203yDto = listPdfJ203yDto.get(iYetaCnt);  
				
				pdfJ203yVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
				pdfJ203yVo.setSystemkey(MSFSharedUtils.allowNulls(pdfJ203yDto.getSystemkey()));
				pdfJ203yVo.setLoanSeilNum(MSFSharedUtils.convertStringToBigDecimal(String.valueOf(pdfJ203yDto.getLoanSeilNum())));
				pdfJ203yVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfJ203yDto.getYrtxBlggYr()));
				pdfJ203yVo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfJ203yDto.getClutSeptCd()));
				
				pdfJ203yVo.setPdfDatAppYn(MSFSharedUtils.allowNulls(Boolean.parseBoolean(pdfJ203yDto.getPdfDatAppYn())? "Y" : "N"));
				pdfJ203yVo.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(pdfJ203yDto.getPdfDatAppExcCtnt()));
				
				pdfJ203yVo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
				pdfJ203yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				pdfJ203yDAO.updateYetaP220001ToPdfJ203y(pdfJ203yVo);
				
				if (iCnt == 0) {
					ye161010Vo.setDpobCd(MSFSharedUtils.allowNulls(pdfJ203yVo.getDpobCd()));    					/** column 사업장코드 : dpobCd */
		        	ye161010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfJ203yVo.getYrtxBlggYr()));    			/** column 귀속연도 : yrtxBlggYr */
		        	ye161010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfJ203yVo.getClutSeptCd()));    			/** column 연말정산구분코드 : clutSeptCd */
		        	ye161010Vo.setSystemkey(MSFSharedUtils.allowNulls(pdfJ203yVo.getSystemkey()));    				/** column SYSTEMKEY : systemkey */
				}
				
				iCnt = iCnt + 1;
			}
			
			/***************************************************************************************************************************
			 * pdf 저장 후 체크된 데이타에 대해서 업데이트 인서트 한다 
			 ***************************************************************************************************************************/
			ye161010Vo.setXmlFormCd("J203Y");
			Func_PdfXml_Yeta2017_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2017_Insert();
			funcPdfXmlIn.pdfXml_Yeta2017_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
			
			result = iCnt;

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

		return result;
	}

	@Override
	public Integer updateYetaP220001ToPdfJ301Y(List<PdfJ301yDTO> listPdfJ301yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP220001ToPdfJ301Y";

		String windowNm = "주책마련저축 업데이트";
		String windowId = "YETAP220001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfJ301yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfJ301yDAO = (InfcPkgPdfJ301yDAO) wac.getBean("InfcPkgPdfJ301yDAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfJ301yVO pdfJ301yVo = new InfcPkgPdfJ301yVO();
		InfcPkgYe161010VO  ye161010Vo = new InfcPkgYe161010VO();
		
		try{

			for(int iYetaCnt=0; iYetaCnt < listPdfJ301yDto.size(); iYetaCnt++) {

				PdfJ301yDTO pdfJ301yDto = new PdfJ301yDTO();  
				pdfJ301yDto = listPdfJ301yDto.get(iYetaCnt);  
				
				pdfJ301yVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
				pdfJ301yVo.setSystemkey(MSFSharedUtils.allowNulls(pdfJ301yDto.getSystemkey()));
				pdfJ301yVo.setHomeSeilSum(MSFSharedUtils.allowNulls(pdfJ301yDto.getHomeSeilSum()));
				pdfJ301yVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfJ301yDto.getYrtxBlggYr()));
				pdfJ301yVo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfJ301yDto.getClutSeptCd()));
				
				pdfJ301yVo.setPdfDatAppYn(MSFSharedUtils.allowNulls(Boolean.parseBoolean(pdfJ301yDto.getPdfDatAppYn())? "Y" : "N"));
				pdfJ301yVo.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(pdfJ301yDto.getPdfDatAppExcCtnt()));
				
				pdfJ301yVo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
				pdfJ301yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				pdfJ301yDAO.updateYetaP220001ToPdfJ301y(pdfJ301yVo);
				
				if (iCnt == 0) {
					ye161010Vo.setDpobCd(MSFSharedUtils.allowNulls(pdfJ301yVo.getDpobCd()));    					/** column 사업장코드 : dpobCd */
		        	ye161010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfJ301yVo.getYrtxBlggYr()));    			/** column 귀속연도 : yrtxBlggYr */
		        	ye161010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfJ301yVo.getClutSeptCd()));    			/** column 연말정산구분코드 : clutSeptCd */
		        	ye161010Vo.setSystemkey(MSFSharedUtils.allowNulls(pdfJ301yVo.getSystemkey()));    				/** column SYSTEMKEY : systemkey */
				}
				
				iCnt = iCnt + 1;
			}

			/***************************************************************************************************************************
			 * pdf 저장 후 체크된 데이타에 대해서 업데이트 인서트 한다 
			 ***************************************************************************************************************************/
			ye161010Vo.setXmlFormCd("J301Y");
			Func_PdfXml_Yeta2017_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2017_Insert();
			funcPdfXmlIn.pdfXml_Yeta2017_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
			
			
			result = iCnt;

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

		return result;

	}

	@Override
	public Integer updateYetaP220001ToPdfJ401Y(List<PdfJ401yDTO> listPdfJ401yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP220001ToPdfJ401Y";

		String windowNm = "목돈 안드는 전세 이자상환액 업데이트";
		String windowId = "YETAP220001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfJ401yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfJ401yDAO = (InfcPkgPdfJ401yDAO) wac.getBean("InfcPkgPdfJ401yDAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfJ401yVO pdfJ401yVo = new InfcPkgPdfJ401yVO();
		InfcPkgYe161010VO  ye161010Vo = new InfcPkgYe161010VO();
		try{

			for(int iYetaCnt=0; iYetaCnt < listPdfJ401yDto.size(); iYetaCnt++) {

				PdfJ401yDTO pdfJ401yDto = new PdfJ401yDTO();  
				pdfJ401yDto = listPdfJ401yDto.get(iYetaCnt);  
				
				pdfJ401yVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
				pdfJ401yVo.setSystemkey(MSFSharedUtils.allowNulls(pdfJ401yDto.getSystemkey()));
				pdfJ401yVo.setAccNo(MSFSharedUtils.allowNulls(pdfJ401yDto.getAccNo()));
				pdfJ401yVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfJ401yDto.getYrtxBlggYr()));
				pdfJ401yVo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfJ401yDto.getClutSeptCd()));
				
				pdfJ401yVo.setPdfDatAppYn(MSFSharedUtils.allowNulls(Boolean.parseBoolean(pdfJ401yDto.getPdfDatAppYn())? "Y" : "N"));
				pdfJ401yVo.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(pdfJ401yDto.getPdfDatAppExcCtnt()));
				
				pdfJ401yVo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
				pdfJ401yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				pdfJ401yDAO.updateYetaP220001ToPdfJ401y(pdfJ401yVo);
				
				if (iCnt == 0) {
					ye161010Vo.setDpobCd(MSFSharedUtils.allowNulls(pdfJ401yVo.getDpobCd()));    					/** column 사업장코드 : dpobCd */
		        	ye161010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfJ401yVo.getYrtxBlggYr()));    			/** column 귀속연도 : yrtxBlggYr */
		        	ye161010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfJ401yVo.getClutSeptCd()));    			/** column 연말정산구분코드 : clutSeptCd */
		        	ye161010Vo.setSystemkey(MSFSharedUtils.allowNulls(pdfJ401yVo.getSystemkey()));    				/** column SYSTEMKEY : systemkey */
				}
				
				iCnt = iCnt + 1;
			}

			/***************************************************************************************************************************
			 * pdf 저장 후 체크된 데이타에 대해서 업데이트 인서트 한다 
			 ***************************************************************************************************************************/
			ye161010Vo.setXmlFormCd("J401Y");
			Func_PdfXml_Yeta2017_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2017_Insert();
			funcPdfXmlIn.pdfXml_Yeta2017_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
			
			
			result = iCnt;

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

		return result;

	}

	@Override
	public Integer updateYetaP220001ToPdfK101Y(List<PdfK101yDTO> listPdfK101yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP220001ToPdfK101Y";

		String windowNm = "소기업소상공인 공제부금  업데이트";
		String windowId = "YETAP220001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfK101yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfK101yDAO = (InfcPkgPdfK101yDAO) wac.getBean("InfcPkgPdfK101yDAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfK101yVO pdfK101yVo = new InfcPkgPdfK101yVO();
		InfcPkgYe161010VO  ye161010Vo = new InfcPkgYe161010VO();
		
		try{

			for(int iYetaCnt=0; iYetaCnt < listPdfK101yDto.size(); iYetaCnt++) {

				PdfK101yDTO pdfK101yDto = new PdfK101yDTO();  
				pdfK101yDto = listPdfK101yDto.get(iYetaCnt);  
				
				pdfK101yVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
				pdfK101yVo.setSystemkey(MSFSharedUtils.allowNulls(pdfK101yDto.getSystemkey()));
				pdfK101yVo.setAccNo(MSFSharedUtils.allowNulls(pdfK101yDto.getAccNo()));
				pdfK101yVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfK101yDto.getYrtxBlggYr()));
				pdfK101yVo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfK101yDto.getClutSeptCd()));
				
				pdfK101yVo.setPdfDatAppYn(MSFSharedUtils.allowNulls(Boolean.parseBoolean(pdfK101yDto.getPdfDatAppYn())? "Y" : "N"));
				pdfK101yVo.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(pdfK101yDto.getPdfDatAppExcCtnt()));
				
				pdfK101yVo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
				pdfK101yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				pdfK101yDAO.updateYetaP220001ToPdfK101y(pdfK101yVo);
				if (iCnt == 0) {
					ye161010Vo.setDpobCd(MSFSharedUtils.allowNulls(pdfK101yVo.getDpobCd()));    					/** column 사업장코드 : dpobCd */
		        	ye161010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfK101yVo.getYrtxBlggYr()));    			/** column 귀속연도 : yrtxBlggYr */
		        	ye161010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfK101yVo.getClutSeptCd()));    			/** column 연말정산구분코드 : clutSeptCd */
		        	ye161010Vo.setSystemkey(MSFSharedUtils.allowNulls(pdfK101yVo.getSystemkey()));    				/** column SYSTEMKEY : systemkey */
				}
				iCnt = iCnt + 1;
			}
			
			/***************************************************************************************************************************
			 * pdf 저장 후 체크된 데이타에 대해서 업데이트 인서트 한다 
			 ***************************************************************************************************************************/
			ye161010Vo.setXmlFormCd("K101M");
			Func_PdfXml_Yeta2017_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2017_Insert();
			funcPdfXmlIn.pdfXml_Yeta2017_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
			

			result = iCnt;

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

		return result;

	}

	@Override
	public Integer updateYetaP220001ToPdfL102Y(List<PdfL102yDTO> listPdfL102yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP220001ToPdfL102Y";

		String windowNm = "기부금 업데이트";
		String windowId = "YETAP220001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfL102yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfL102yDAO = (InfcPkgPdfL102yDAO) wac.getBean("InfcPkgPdfL102yDAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfL102yVO pdfL102yVo = new InfcPkgPdfL102yVO();
		InfcPkgYe161010VO  ye161010Vo = new InfcPkgYe161010VO();
		
		try{

			for(int iYetaCnt=0; iYetaCnt < listPdfL102yDto.size(); iYetaCnt++) {

				PdfL102yDTO pdfL102yDto = new PdfL102yDTO();  
				pdfL102yDto = listPdfL102yDto.get(iYetaCnt);  
				
				pdfL102yVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
				pdfL102yVo.setSystemkey(MSFSharedUtils.allowNulls(pdfL102yDto.getSystemkey()));
				pdfL102yVo.setConbSeilNum(MSFSharedUtils.convertStringToBigDecimal(String.valueOf(pdfL102yDto.getConbSeilNum())));
				pdfL102yVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfL102yDto.getYrtxBlggYr()));
				pdfL102yVo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfL102yDto.getClutSeptCd()));
				
				pdfL102yVo.setPdfDatAppYn(MSFSharedUtils.allowNulls(Boolean.parseBoolean(pdfL102yDto.getPdfDatAppYn())? "Y" : "N"));
				pdfL102yVo.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(pdfL102yDto.getPdfDatAppExcCtnt()));
				
				pdfL102yVo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
				pdfL102yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				pdfL102yDAO.updateYetaP220001ToPdfL102y(pdfL102yVo);
				
				if (iCnt == 0) {
					ye161010Vo.setDpobCd(MSFSharedUtils.allowNulls(pdfL102yVo.getDpobCd()));    					/** column 사업장코드 : dpobCd */
		        	ye161010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfL102yVo.getYrtxBlggYr()));    			/** column 귀속연도 : yrtxBlggYr */
		        	ye161010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfL102yVo.getClutSeptCd()));    			/** column 연말정산구분코드 : clutSeptCd */
		        	ye161010Vo.setSystemkey(MSFSharedUtils.allowNulls(pdfL102yVo.getSystemkey()));    				/** column SYSTEMKEY : systemkey */
				}
				
				iCnt = iCnt + 1;
			}
			
			/***************************************************************************************************************************
			 * pdf 저장 후 체크된 데이타에 대해서 업데이트 인서트 한다 
			 ***************************************************************************************************************************/
			ye161010Vo.setXmlFormCd("L102Y");
			Func_PdfXml_Yeta2017_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2017_Insert();
			funcPdfXmlIn.pdfXml_Yeta2017_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
			
			result = iCnt;

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

		return result;
	}

	@Override
	public Integer updateYetaP220001ToPdfN101Y(List<PdfN101yDTO> listPdfN101yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP220001ToPdfN101Y";

		String windowNm = "장기집합투자증권저축 업데이트";
		String windowId = "YETAP220001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfN101yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfN101yDAO = (InfcPkgPdfN101yDAO) wac.getBean("InfcPkgPdfN101yDAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfN101yVO pdfN101yVo = new InfcPkgPdfN101yVO();
		InfcPkgYe161010VO  ye161010Vo = new InfcPkgYe161010VO();
		
		try{

			for(int iYetaCnt=0; iYetaCnt < listPdfN101yDto.size(); iYetaCnt++) {

				PdfN101yDTO pdfN101yDto = new PdfN101yDTO();  
				pdfN101yDto = listPdfN101yDto.get(iYetaCnt);  
				
				pdfN101yVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
				pdfN101yVo.setSystemkey(MSFSharedUtils.allowNulls(pdfN101yDto.getSystemkey()));
				pdfN101yVo.setSecuNo(MSFSharedUtils.allowNulls(pdfN101yDto.getSecuNo()));
				pdfN101yVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfN101yDto.getYrtxBlggYr()));
				pdfN101yVo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfN101yDto.getClutSeptCd()));
				
				pdfN101yVo.setPdfDatAppYn(MSFSharedUtils.allowNulls(Boolean.parseBoolean(pdfN101yDto.getPdfDatAppYn())? "Y" : "N"));
				pdfN101yVo.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(pdfN101yDto.getPdfDatAppExcCtnt()));
				
				pdfN101yVo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
				pdfN101yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				pdfN101yDAO.updateYetaP220001ToPdfN101y(pdfN101yVo);
				
				if (iCnt == 0) {
					ye161010Vo.setDpobCd(MSFSharedUtils.allowNulls(pdfN101yVo.getDpobCd()));    					/** column 사업장코드 : dpobCd */
		        	ye161010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfN101yVo.getYrtxBlggYr()));    			/** column 귀속연도 : yrtxBlggYr */
		        	ye161010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfN101yVo.getClutSeptCd()));    			/** column 연말정산구분코드 : clutSeptCd */
		        	ye161010Vo.setSystemkey(MSFSharedUtils.allowNulls(pdfN101yVo.getSystemkey()));    				/** column SYSTEMKEY : systemkey */
				}
				iCnt = iCnt + 1;
			}
			/***************************************************************************************************************************
			 * pdf 저장 후 체크된 데이타에 대해서 업데이트 인서트 한다 
			 ***************************************************************************************************************************/
			ye161010Vo.setXmlFormCd("N101Y");
			Func_PdfXml_Yeta2017_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2017_Insert();
			funcPdfXmlIn.pdfXml_Yeta2017_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
			
			result = iCnt;

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

		return result;

	}

	@Override
	public Integer updateYetaP220001ToPdfO101Y(List<PdfO101yDTO> listPdfO101yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP220001ToPdfO101Y";

		String windowNm = "건강보험료 업데이트";
		String windowId = "YETAP220001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfO101yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfO101yDAO = (InfcPkgPdfO101yDAO) wac.getBean("InfcPkgPdfO101yDAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfO101yVO pdfO101yVo = new InfcPkgPdfO101yVO();
		InfcPkgYe161010VO  ye161010Vo = new InfcPkgYe161010VO();
		try{

			for(int iYetaCnt=0; iYetaCnt < listPdfO101yDto.size(); iYetaCnt++) {

				PdfO101yDTO pdfO101yDto = new PdfO101yDTO();  
				pdfO101yDto = listPdfO101yDto.get(iYetaCnt);  
				
				pdfO101yVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
				pdfO101yVo.setSystemkey(MSFSharedUtils.allowNulls(pdfO101yDto.getSystemkey()));
				pdfO101yVo.setDatCd(MSFSharedUtils.allowNulls(pdfO101yDto.getDatCd()));
				pdfO101yVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfO101yDto.getYrtxBlggYr()));
				pdfO101yVo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfO101yDto.getClutSeptCd()));
				
				pdfO101yVo.setPdfDatAppYn(MSFSharedUtils.allowNulls(Boolean.parseBoolean(pdfO101yDto.getPdfDatAppYn())? "Y" : "N"));
				pdfO101yVo.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(pdfO101yDto.getPdfDatAppExcCtnt()));
				
				pdfO101yVo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
				pdfO101yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				pdfO101yDAO.updateYetaP220001ToPdfO101y(pdfO101yVo);
				
				if (iCnt == 0) {
					ye161010Vo.setDpobCd(MSFSharedUtils.allowNulls(pdfO101yVo.getDpobCd()));    					/** column 사업장코드 : dpobCd */
		        	ye161010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfO101yVo.getYrtxBlggYr()));    			/** column 귀속연도 : yrtxBlggYr */
		        	ye161010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfO101yVo.getClutSeptCd()));    			/** column 연말정산구분코드 : clutSeptCd */
		        	ye161010Vo.setSystemkey(MSFSharedUtils.allowNulls(pdfO101yVo.getSystemkey()));    				/** column SYSTEMKEY : systemkey */
				}
				
				iCnt = iCnt + 1;
			}
			
			/***************************************************************************************************************************
			 * pdf 저장 후 체크된 데이타에 대해서 업데이트 인서트 한다 
			 ***************************************************************************************************************************/
			ye161010Vo.setXmlFormCd("O101M");
			Func_PdfXml_Yeta2017_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2017_Insert();
			funcPdfXmlIn.pdfXml_Yeta2017_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
			
			result = iCnt;

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

		return result;

	}

	@Override
	public Integer updateYetaP220001ToPdfP102Y(List<PdfP102yDTO> listPdfP102yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP220001ToPdfP102Y";

		String windowNm = "국민연금보험료 업데이트";
		String windowId = "YETAP220001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfP102yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfP102yDAO = (InfcPkgPdfP102yDAO) wac.getBean("InfcPkgPdfP102yDAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfP102yVO pdfP102yVo = new InfcPkgPdfP102yVO();
		InfcPkgYe161010VO  ye161010Vo = new InfcPkgYe161010VO();
		
		try{

			for(int iYetaCnt=0; iYetaCnt < listPdfP102yDto.size(); iYetaCnt++) {

				PdfP102yDTO pdfP102yDto = new PdfP102yDTO();  
				pdfP102yDto = listPdfP102yDto.get(iYetaCnt);  
				
				pdfP102yVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
				pdfP102yVo.setSystemkey(MSFSharedUtils.allowNulls(pdfP102yDto.getSystemkey()));
				pdfP102yVo.setDatCd(MSFSharedUtils.allowNulls(pdfP102yDto.getDatCd()));
				pdfP102yVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfP102yDto.getYrtxBlggYr()));
				pdfP102yVo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfP102yDto.getClutSeptCd()));
				
				pdfP102yVo.setPdfDatAppYn(MSFSharedUtils.allowNulls(Boolean.parseBoolean(pdfP102yDto.getPdfDatAppYn())? "Y" : "N"));
				pdfP102yVo.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(pdfP102yDto.getPdfDatAppExcCtnt()));
				
				pdfP102yVo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
				pdfP102yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				pdfP102yDAO.updateYetaP220001ToPdfP102y(pdfP102yVo);
				if (iCnt == 0) {
					
					ye161010Vo.setDpobCd(MSFSharedUtils.allowNulls(pdfP102yVo.getDpobCd()));    					/** column 사업장코드 : dpobCd */
		        	ye161010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfP102yVo.getYrtxBlggYr()));    			/** column 귀속연도 : yrtxBlggYr */
		        	ye161010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfP102yVo.getClutSeptCd()));    			/** column 연말정산구분코드 : clutSeptCd */
		        	ye161010Vo.setSystemkey(MSFSharedUtils.allowNulls(pdfP102yVo.getSystemkey()));    				/** column SYSTEMKEY : systemkey */
				}
				
				iCnt = iCnt + 1;
			}
			
			/***************************************************************************************************************************
			 * pdf 저장 후 체크된 데이타에 대해서 업데이트 인서트 한다 
			 ***************************************************************************************************************************/
			ye161010Vo.setXmlFormCd("P102M");
			Func_PdfXml_Yeta2017_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2017_Insert();
			funcPdfXmlIn.pdfXml_Yeta2017_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
			
			result = iCnt;

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

		return result;

	}


}
