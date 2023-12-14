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
package com.app.exterms.yearendtax.server.service.yeta2021;
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

import com.app.exterms.yearendtax.client.dto.yeta2021.PdfA102yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfB101yDTO;

import com.app.exterms.yearendtax.client.dto.yeta2021.PdfB201yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfC101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfC202yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfC301yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfC401yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfD101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfE102yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfF102yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfG107yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfG207yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfG307yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfG407yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfJ101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfJ203yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfJ301yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfJ401yDTO;
//2021연말정산_추가
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfJ501yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfK101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfL102yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfN101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfO101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfP102yDTO;
//2021연말정산_추가
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfQ101yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfQ201yDTO;
import com.app.exterms.yearendtax.client.dto.yeta2021.PdfQ301yDTO;
import com.app.exterms.yearendtax.client.service.yeta2021.YetaP620001Service;
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
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgPdfA102y_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgPdfB101y_2021_DAO;

import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgPdfB201y_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgPdfC101y_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgPdfC202y_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgPdfC301y_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgPdfC401y_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgPdfD101y_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgPdfE102y_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgPdfF102y_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgPdfG104y_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgPdfG107y_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgPdfG205m_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgPdfG205y_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgPdfG207m_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgPdfG207y_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgPdfG304m_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgPdfG304y_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgPdfG307m_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgPdfG307y_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgPdfG407m_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgPdfG407y_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgPdfJ101y_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgPdfJ203m_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgPdfJ203y_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgPdfJ301y_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgPdfJ401y_2021_DAO;
//2021연말정산_추가
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgPdfJ501y_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgPdfK101m_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgPdfK101y_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgPdfL102y_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgPdfN101y_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgPdfO101m_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgPdfO101y_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgPdfP101m_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgPdfP101y_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgPdfP102m_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgPdfP102y_2021_DAO;
//2021연말정산_추가
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgPdfQ101y_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgPdfQ201y_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgPdfQ301y_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfA102ySrh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfA102y_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfB101ySrh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfB101y_2021_VO;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfB201ySrh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfB201y_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfC101ySrh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfC101y_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfC202ySrh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfC202y_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfC301ySrh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfC301y_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfC401ySrh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfC401y_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfD101ySrh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfD101y_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfE102ySrh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfE102y_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfF102ySrh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfF102y_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfG104ySrh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfG107ySrh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfG107y_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfG205ySrh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfG207ySrh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfG207y_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfG304ySrh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfG307ySrh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfG307y_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfG407ySrh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfG407y_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfJ101ySrh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfJ101y_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfJ203ySrh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfJ203y_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfJ301ySrh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfJ301y_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfJ401ySrh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfJ401y_2021_VO;
//2021연말정산_추가
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfJ501ySrh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfJ501y_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfK101ySrh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfK101y_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfL102ySrh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfL102y_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfN101ySrh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfN101y_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfO101ySrh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfO101y_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfP101ySrh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfP102ySrh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfP102y_2021_VO;
//2021연말정산_추가
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfQ101ySrh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfQ101y_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfQ201ySrh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfQ201y_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfQ301ySrh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfQ301y_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161010_2021_VO;
import com.app.smrmf.pkg.yeta.yeta2021.pdfxml.Func_PdfXml_Yeta2021_Insert;
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
@Service("YetaP620001Service")
public class YetaP620001ServiceImpl  extends AbstractCustomServiceImpl implements YetaP620001Service  ,YetaDaoConstants {


	private static final Logger logger = LoggerFactory.getLogger(YetaP620001ServiceImpl.class);
	private static final String calledClass = YetaP620001ServiceImpl.class.getName();

	@Autowired
	@Resource(name="InfcPkgPdfA102y_2021_DAO")
	private InfcPkgPdfA102y_2021_DAO pdfA102yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfB101y_2021_DAO")
	private InfcPkgPdfB101y_2021_DAO pdfB101yDAO;
	
	
	@Autowired
	@Resource(name="InfcPkgPdfB201y_2021_DAO")
	private InfcPkgPdfB201y_2021_DAO pdfB201yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfC101y_2021_DAO")
	private InfcPkgPdfC101y_2021_DAO pdfC101yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfC202y_2021_DAO")
	private InfcPkgPdfC202y_2021_DAO pdfC202yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfC301y_2021_DAO")
	private InfcPkgPdfC301y_2021_DAO pdfC301yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfC401y_2021_DAO")
	private InfcPkgPdfC401y_2021_DAO pdfC401yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfD101y_2021_DAO")
	private InfcPkgPdfD101y_2021_DAO pdfD101yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfE102y_2021_DAO")
	private InfcPkgPdfE102y_2021_DAO pdfE102yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfF102y_2021_DAO")
	private InfcPkgPdfF102y_2021_DAO pdfF102yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfG104y_2021_DAO")
	private InfcPkgPdfG104y_2021_DAO pdfG104yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfG107y_2021_DAO")
	private InfcPkgPdfG107y_2021_DAO pdfG107yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfG205m_2021_DAO")
	private InfcPkgPdfG205m_2021_DAO pdfG205mDAO;

	@Autowired
	@Resource(name="InfcPkgPdfG205y_2021_DAO")
	private InfcPkgPdfG205y_2021_DAO pdfG205yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfG207m_2021_DAO")
	private InfcPkgPdfG207m_2021_DAO pdfG207mDAO;

	@Autowired
	@Resource(name="InfcPkgPdfG207y_2021_DAO")
	private InfcPkgPdfG207y_2021_DAO pdfG207yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfG304y_2021_DAO")
	private InfcPkgPdfG304y_2021_DAO pdfG304yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfG304m_2021_DAO")
	private InfcPkgPdfG304m_2021_DAO pdfG304mDAO;

	@Autowired
	@Resource(name="InfcPkgPdfG307y_2021_DAO")
	private InfcPkgPdfG307y_2021_DAO pdfG307yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfG307m_2021_DAO")
	private InfcPkgPdfG307m_2021_DAO pdfG307mDAO;
	
	@Autowired
	@Resource(name="InfcPkgPdfG407y_2021_DAO")
	private InfcPkgPdfG407y_2021_DAO pdfG407yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfG407m_2021_DAO")
	private InfcPkgPdfG407m_2021_DAO pdfG407mDAO;

	@Autowired
	@Resource(name="InfcPkgPdfJ101y_2021_DAO")
	private InfcPkgPdfJ101y_2021_DAO pdfJ101yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfJ203y_2021_DAO")
	private InfcPkgPdfJ203y_2021_DAO pdfJ203yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfJ203m_2021_DAO")
	private InfcPkgPdfJ203m_2021_DAO pdfJ203mDAO;

	@Autowired
	@Resource(name="InfcPkgPdfJ301y_2021_DAO")
	private InfcPkgPdfJ301y_2021_DAO pdfJ301yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfJ401y_2021_DAO")
	private InfcPkgPdfJ401y_2021_DAO pdfJ401yDAO;
	
	
	@Autowired
	@Resource(name="InfcPkgPdfJ501y_2021_DAO")
	private InfcPkgPdfJ501y_2021_DAO pdfJ501yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfK101m_2021_DAO")
	private InfcPkgPdfK101m_2021_DAO pdfK101mDAO;

	@Autowired
	@Resource(name="InfcPkgPdfK101y_2021_DAO")
	private InfcPkgPdfK101y_2021_DAO pdfK101yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfL102y_2021_DAO")
	private InfcPkgPdfL102y_2021_DAO pdfL102yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfN101y_2021_DAO")
	private InfcPkgPdfN101y_2021_DAO pdfN101yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfO101m_2021_DAO")
	private InfcPkgPdfO101m_2021_DAO pdfO101mDAO;

	@Autowired
	@Resource(name="InfcPkgPdfO101y_2021_DAO")
	private InfcPkgPdfO101y_2021_DAO pdfO101yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfP101m_2021_DAO")
	private InfcPkgPdfP101m_2021_DAO pdfP101mDAO;

	@Autowired
	@Resource(name="InfcPkgPdfP101y_2021_DAO")
	private InfcPkgPdfP101y_2021_DAO pdfP101yDAO;

	@Autowired
	@Resource(name="InfcPkgPdfP102m_2021_DAO")
	private InfcPkgPdfP102m_2021_DAO pdfP102mDAO;

	@Autowired
	@Resource(name="InfcPkgPdfP102y_2021_DAO")
	private InfcPkgPdfP102y_2021_DAO pdfP102yDAO;
	
	//2021연말정산_추가
	@Autowired
	@Resource(name="InfcPkgPdfQ101y_2021_DAO")
	private InfcPkgPdfQ101y_2021_DAO pdfQ101yDAO;
	
	@Autowired
	@Resource(name="InfcPkgPdfQ201y_2021_DAO")
	private InfcPkgPdfQ201y_2021_DAO pdfQ201yDAO;
	
	@Autowired
	@Resource(name="InfcPkgPdfQ301y_2021_DAO")
	private InfcPkgPdfQ301y_2021_DAO pdfQ301yDAO;

	/**
	 * 보장성보험 조회
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	//조회
	public PagingLoadResult<BaseModel> getYetaP620001ToPdfA102yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA6200_PDF_A102Y_DATA_LIST;
						
		InfcPkgPdfA102ySrh_2021_VO   pdfA102ySrhVO = new InfcPkgPdfA102ySrh_2021_VO();
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
			pdfA102yDAO = (InfcPkgPdfA102y_2021_DAO) wac.getBean("InfcPkgPdfA102y_2021_DAO"); 
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

			TimingInfo millisBeginYetaP610001ToPsnl0100DataList = SmrmfUtils.startTiming(logger);

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

			SmrmfUtils.endTiming(logger, millisBeginYetaP610001ToPsnl0100DataList, "getYetaP610001ToPsnl0100DataList");

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
	public PagingLoadResult<BaseModel> getYetaP620001ToPdfB101yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA6200_PDF_B101Y_DATA_LIST;
		InfcPkgPdfB101ySrh_2021_VO   pdfB101ySrhVO = new InfcPkgPdfB101ySrh_2021_VO();
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
			pdfB101yDAO = (InfcPkgPdfB101y_2021_DAO) wac.getBean("InfcPkgPdfB101y_2021_DAO"); 
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

			TimingInfo millisBeginYetaP610001ToPsnl0100DataList = SmrmfUtils.startTiming(logger);

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

			SmrmfUtils.endTiming(logger, millisBeginYetaP610001ToPsnl0100DataList, "getYetaP610001ToPsnl0100DataList");

		} catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	
	
	
	public PagingLoadResult<BaseModel> getYetaP620001ToPdfB201yDataList(ServiceParameters serviceParameters) throws MSFException {
		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA6200_PDF_B201Y_DATA_LIST;
		InfcPkgPdfB201ySrh_2021_VO  pdfB201ySrhVO = new InfcPkgPdfB201ySrh_2021_VO();
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

		if  (MSFSharedUtils.paramNull(pdfB201yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfB201yDAO = (InfcPkgPdfB201y_2021_DAO) wac.getBean("InfcPkgPdfB201y_2021_DAO"); 
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
			pdfB201ySrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
			pdfB201ySrhVO.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));	// 정산구분 
			pdfB201ySrhVO.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));		// 귀속년도
			pdfB201ySrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));

			logger.debug("안성_실손보험조회1 = " + pdfB201ySrhVO.getDpobCd());
			logger.debug("안성_실손보험조회1 = " + pdfB201ySrhVO.getClutSeptCd());
			logger.debug("안성_실손보험조회1 = " + pdfB201ySrhVO.getYrtxBlggYr());
			logger.debug("안성_실손보험조회1 = " + pdfB201ySrhVO.getSystemkey());
			//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 

				//Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

				int iResultCnt = pdfB201yDAO.selectPdfB201yListTotCnt(pdfB201ySrhVO);

				logger.debug("실손보험조회2");
				SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");

				//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
				if (!pagingValues.pageExecute) { 
					pagingValues.offsetLimit = iResultCnt; 
					logger.debug("실손보험조회3");
				}

				pagingValues.totalRecordCount = iResultCnt;	       

				logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
			logger.debug("실손보험조회4");
			TimingInfo millisBeginYetaP610001ToPsnl0100DataList = SmrmfUtils.startTiming(logger);

			/**페이지 카운트 처리를 위한 부분 */ 
			pdfB201ySrhVO.setPageSize(pagingValues.totalRecordCount);  

			//Apply paging
			if (pagingValues.start > 0) {
				pdfB201ySrhVO.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				pdfB201ySrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			//
			//Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

			@SuppressWarnings("unchecked")
			List list = pdfB201yDAO.selectPdfB201yList(pdfB201ySrhVO);

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

			SmrmfUtils.endTiming(logger, millisBeginYetaP610001ToPsnl0100DataList, "getYetaP610001ToPsnl0100DataList");

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
	public PagingLoadResult<BaseModel> getYetaP620001ToPdfC101yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA6200_PDF_C101Y_DATA_LIST;
		InfcPkgPdfC101ySrh_2021_VO   pdfC101ySrhVO = new InfcPkgPdfC101ySrh_2021_VO();
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
			pdfC101yDAO = (InfcPkgPdfC101y_2021_DAO) wac.getBean("InfcPkgPdfC101y_2021_DAO"); 
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

			TimingInfo millisBeginYetaP610001ToPsnl0100DataList = SmrmfUtils.startTiming(logger);

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

			SmrmfUtils.endTiming(logger, millisBeginYetaP610001ToPsnl0100DataList, "getYetaP610001ToPsnl0100DataList");

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
	public PagingLoadResult<BaseModel> getYetaP620001ToPdfC202yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA6200_PDF_C202Y_DATA_LIST;
		InfcPkgPdfC202ySrh_2021_VO   pdfC202ySrhVO = new InfcPkgPdfC202ySrh_2021_VO();
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
			pdfC202yDAO = (InfcPkgPdfC202y_2021_DAO) wac.getBean("InfcPkgPdfC202y_2021_DAO"); 
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

			TimingInfo millisBeginYetaP610001ToPsnl0100DataList = SmrmfUtils.startTiming(logger);

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

			SmrmfUtils.endTiming(logger, millisBeginYetaP610001ToPsnl0100DataList, "getYetaP610001ToPsnl0100DataList");

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
	public PagingLoadResult<BaseModel> getYetaP620001ToPdfC301yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA6200_PDF_C301Y_DATA_LIST;
		InfcPkgPdfC301ySrh_2021_VO   pdfC301ySrhVO = new InfcPkgPdfC301ySrh_2021_VO();
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
			pdfC301yDAO = (InfcPkgPdfC301y_2021_DAO) wac.getBean("InfcPkgPdfC301y_2021_DAO"); 
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

			TimingInfo millisBeginYetaP610001ToPsnl0100DataList = SmrmfUtils.startTiming(logger);

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

			SmrmfUtils.endTiming(logger, millisBeginYetaP610001ToPsnl0100DataList, "getYetaP610001ToPsnl0100DataList");

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
	public PagingLoadResult<BaseModel> getYetaP620001ToPdfC401yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA6200_PDF_C401Y_DATA_LIST;
		InfcPkgPdfC401ySrh_2021_VO   pdfC401ySrhVO = new InfcPkgPdfC401ySrh_2021_VO();
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
			pdfC401yDAO = (InfcPkgPdfC401y_2021_DAO) wac.getBean("InfcPkgPdfC401y_2021_DAO"); 
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

			TimingInfo millisBeginYetaP610001ToPsnl0100DataList = SmrmfUtils.startTiming(logger);

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

			SmrmfUtils.endTiming(logger, millisBeginYetaP610001ToPsnl0100DataList, "getYetaP610001ToPsnl0100DataList");

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
	public PagingLoadResult<BaseModel> getYetaP620001ToPdfD101yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA6200_PDF_D101Y_DATA_LIST;
		InfcPkgPdfD101ySrh_2021_VO   pdfD101ySrhVO = new InfcPkgPdfD101ySrh_2021_VO();
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
			pdfD101yDAO = (InfcPkgPdfD101y_2021_DAO) wac.getBean("InfcPkgPdfD101y_2021_DAO"); 
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

			TimingInfo millisBeginYetaP610001ToPsnl0100DataList = SmrmfUtils.startTiming(logger);

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

			SmrmfUtils.endTiming(logger, millisBeginYetaP610001ToPsnl0100DataList, "getYetaP610001ToPsnl0100DataList");

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
	public PagingLoadResult<BaseModel> getYetaP620001ToPdfE102yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA6200_PDF_E102Y_DATA_LIST;
		InfcPkgPdfE102ySrh_2021_VO   pdfE102ySrhVO = new InfcPkgPdfE102ySrh_2021_VO();
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
			pdfE102yDAO = (InfcPkgPdfE102y_2021_DAO) wac.getBean("InfcPkgPdfE102y_2021_DAO"); 
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

			TimingInfo millisBeginYetaP610001ToPsnl0100DataList = SmrmfUtils.startTiming(logger);

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

			SmrmfUtils.endTiming(logger, millisBeginYetaP610001ToPsnl0100DataList, "getYetaP610001ToPsnl0100DataList");

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
	public PagingLoadResult<BaseModel> getYetaP620001ToPdfF102yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA6200_PDF_F102Y_DATA_LIST;
		InfcPkgPdfF102ySrh_2021_VO   pdfF102ySrhVO = new InfcPkgPdfF102ySrh_2021_VO();
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
			pdfF102yDAO = (InfcPkgPdfF102y_2021_DAO) wac.getBean("InfcPkgPdfF102y_2021_DAO"); 
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

			TimingInfo millisBeginYetaP610001ToPsnl0100DataList = SmrmfUtils.startTiming(logger);

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

			SmrmfUtils.endTiming(logger, millisBeginYetaP610001ToPsnl0100DataList, "getYetaP610001ToPsnl0100DataList");

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
	public PagingLoadResult<BaseModel> getYetaP620001ToPdfG104yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA6200_PDF_G104Y_DATA_LIST;
		InfcPkgPdfG104ySrh_2021_VO   pdfG104ySrhVO = new InfcPkgPdfG104ySrh_2021_VO();
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
			pdfG104yDAO = (InfcPkgPdfG104y_2021_DAO) wac.getBean("InfcPkgPdfG104y_2021_DAO"); 
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

			TimingInfo millisBeginYetaP610001ToPsnl0100DataList = SmrmfUtils.startTiming(logger);

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

			SmrmfUtils.endTiming(logger, millisBeginYetaP610001ToPsnl0100DataList, "getYetaP610001ToPsnl0100DataList");

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
	public PagingLoadResult<BaseModel> getYetaP620001ToPdfG107yDataList(ServiceParameters serviceParameters) throws MSFException {
	
		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA6200_PDF_G107Y_DATA_LIST;
		InfcPkgPdfG107ySrh_2021_VO   pdfG107ySrhVO = new InfcPkgPdfG107ySrh_2021_VO();
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

		if  (MSFSharedUtils.paramNull(pdfG107yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfG107yDAO = (InfcPkgPdfG107y_2021_DAO) wac.getBean("InfcPkgPdfG107y_2021_DAO"); 
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
			pdfG107ySrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
			pdfG107ySrhVO.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));	// 정산구분 
			pdfG107ySrhVO.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));		// 귀속년도
			pdfG107ySrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));

			//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 

				//Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

				int iResultCnt = pdfG107yDAO.selectPdfG107yListTotCnt(pdfG107ySrhVO);

				SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");

				//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
				if (!pagingValues.pageExecute) { 
					pagingValues.offsetLimit = iResultCnt;       
				}

				pagingValues.totalRecordCount = iResultCnt;	       

				logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}

			TimingInfo millisBeginYetaP610001ToPsnl0100DataList = SmrmfUtils.startTiming(logger);

			/**페이지 카운트 처리를 위한 부분 */ 
			pdfG107ySrhVO.setPageSize(pagingValues.totalRecordCount);  

			//Apply paging
			if (pagingValues.start > 0) {
				pdfG107ySrhVO.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				pdfG107ySrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			//
			//Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

			@SuppressWarnings("unchecked")
			//	            Collection<Map<String, Object>> list ??????
			List list = pdfG107yDAO.selectPdfG107yList(pdfG107ySrhVO);

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

			SmrmfUtils.endTiming(logger, millisBeginYetaP610001ToPsnl0100DataList, "getYetaP610001ToPsnl0100DataList");

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
	public PagingLoadResult<BaseModel> getYetaP620001ToPdfG205yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA6200_PDF_G205Y_DATA_LIST;
		InfcPkgPdfG205ySrh_2021_VO   pdfG205ySrhVO = new InfcPkgPdfG205ySrh_2021_VO();
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
			pdfG205yDAO = (InfcPkgPdfG205y_2021_DAO) wac.getBean("InfcPkgPdfG205y_2021_DAO"); 
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

			TimingInfo millisBeginYetaP610001ToPsnl0100DataList = SmrmfUtils.startTiming(logger);

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

			SmrmfUtils.endTiming(logger, millisBeginYetaP610001ToPsnl0100DataList, "getYetaP610001ToPsnl0100DataList");

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
	public PagingLoadResult<BaseModel> getYetaP620001ToPdfG207yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA6200_PDF_G207Y_DATA_LIST;
		InfcPkgPdfG207ySrh_2021_VO   pdfG207ySrhVO = new InfcPkgPdfG207ySrh_2021_VO();
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

		if  (MSFSharedUtils.paramNull(pdfG207yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfG207yDAO = (InfcPkgPdfG207y_2021_DAO) wac.getBean("InfcPkgPdfG207y_2021_DAO"); 
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
			pdfG207ySrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
			pdfG207ySrhVO.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));	// 정산구분 
			pdfG207ySrhVO.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));		// 귀속년도
			pdfG207ySrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));

			//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 

				//Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

				int iResultCnt = pdfG207yDAO.selectPdfG207yListTotCnt(pdfG207ySrhVO);

				SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");

				//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
				if (!pagingValues.pageExecute) { 
					pagingValues.offsetLimit = iResultCnt;       
				}

				pagingValues.totalRecordCount = iResultCnt;	       

				logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}

			TimingInfo millisBeginYetaP610001ToPsnl0100DataList = SmrmfUtils.startTiming(logger);

			/**페이지 카운트 처리를 위한 부분 */ 
			pdfG207ySrhVO.setPageSize(pagingValues.totalRecordCount);  

			//Apply paging
			if (pagingValues.start > 0) {
				pdfG207ySrhVO.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				pdfG207ySrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			//
			//Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

			@SuppressWarnings("unchecked")
			//	            Collection<Map<String, Object>> list ??????
			List list = pdfG207yDAO.selectPdfG207yList(pdfG207ySrhVO);

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

			SmrmfUtils.endTiming(logger, millisBeginYetaP610001ToPsnl0100DataList, "getYetaP610001ToPsnl0100DataList");

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
	public PagingLoadResult<BaseModel> getYetaP620001ToPdfG304yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA6200_PDF_G304Y_DATA_LIST;
		InfcPkgPdfG304ySrh_2021_VO   pdfG304ySrhVO = new InfcPkgPdfG304ySrh_2021_VO();
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
			pdfG304yDAO = (InfcPkgPdfG304y_2021_DAO) wac.getBean("InfcPkgPdfG304y_2021_DAO"); 
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

			TimingInfo millisBeginYetaP610001ToPsnl0100DataList = SmrmfUtils.startTiming(logger);

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

			SmrmfUtils.endTiming(logger, millisBeginYetaP610001ToPsnl0100DataList, "getYetaP610001ToPsnl0100DataList");

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
	public PagingLoadResult<BaseModel> getYetaP620001ToPdfG307yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA6200_PDF_G307Y_DATA_LIST;
		InfcPkgPdfG307ySrh_2021_VO   pdfG307ySrhVO = new InfcPkgPdfG307ySrh_2021_VO();
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

		if  (MSFSharedUtils.paramNull(pdfG307yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfG307yDAO = (InfcPkgPdfG307y_2021_DAO) wac.getBean("InfcPkgPdfG307y_2021_DAO"); 
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
			pdfG307ySrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
			pdfG307ySrhVO.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));	// 정산구분 
			pdfG307ySrhVO.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));		// 귀속년도
			pdfG307ySrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));

			//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 

				//Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

				int iResultCnt = pdfG307yDAO.selectPdfG307yListTotCnt(pdfG307ySrhVO);

				SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");

				//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
				if (!pagingValues.pageExecute) { 
					pagingValues.offsetLimit = iResultCnt;       
				}

				pagingValues.totalRecordCount = iResultCnt;	       

				logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}

			TimingInfo millisBeginYetaP610001ToPsnl0100DataList = SmrmfUtils.startTiming(logger);

			/**페이지 카운트 처리를 위한 부분 */ 
			pdfG307ySrhVO.setPageSize(pagingValues.totalRecordCount);  

			//Apply paging
			if (pagingValues.start > 0) {
				pdfG307ySrhVO.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				pdfG307ySrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			//
			//Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

			@SuppressWarnings("unchecked")
			//	            Collection<Map<String, Object>> list ??????
			List list = pdfG307yDAO.selectPdfG307yList(pdfG307ySrhVO);

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

			SmrmfUtils.endTiming(logger, millisBeginYetaP610001ToPsnl0100DataList, "getYetaP610001ToPsnl0100DataList");

		} catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	/**
	 * 제로페이 조회
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	//조회
	public PagingLoadResult<BaseModel> getYetaP620001ToPdfG407yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA6200_PDF_G407Y_DATA_LIST;
		InfcPkgPdfG407ySrh_2021_VO   pdfG407ySrhVO = new InfcPkgPdfG407ySrh_2021_VO();
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

		if  (MSFSharedUtils.paramNull(pdfG407yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfG407yDAO = (InfcPkgPdfG407y_2021_DAO) wac.getBean("InfcPkgPdfG407y_2021_DAO"); 
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
			pdfG407ySrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
			pdfG407ySrhVO.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));	// 정산구분 
			pdfG407ySrhVO.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));		// 귀속년도
			pdfG407ySrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));

			//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 

				//Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

				int iResultCnt = pdfG407yDAO.selectPdfG407yListTotCnt(pdfG407ySrhVO);

				SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");

				//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
				if (!pagingValues.pageExecute) { 
					pagingValues.offsetLimit = iResultCnt;       
				}

				pagingValues.totalRecordCount = iResultCnt;	       

				logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}

			TimingInfo millisBeginYetaP610001ToPsnl0100DataList = SmrmfUtils.startTiming(logger);

			/**페이지 카운트 처리를 위한 부분 */
			pdfG407ySrhVO.setPageSize(pagingValues.totalRecordCount);  

			//Apply paging
			if (pagingValues.start > 0) {
				pdfG407ySrhVO.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				pdfG407ySrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			//
			//Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

			@SuppressWarnings("unchecked")
			//	            Collection<Map<String, Object>> list ??????
			List list = pdfG407yDAO.selectPdfG407yList(pdfG407ySrhVO);

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

			SmrmfUtils.endTiming(logger, millisBeginYetaP610001ToPsnl0100DataList, "getYetaP610001ToPsnl0100DataList");

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
	public PagingLoadResult<BaseModel> getYetaP620001ToPdfJ101yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA6200_PDF_J101Y_DATA_LIST;
		InfcPkgPdfJ101ySrh_2021_VO   pdfJ101ySrhVO = new InfcPkgPdfJ101ySrh_2021_VO();
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
			pdfJ101yDAO = (InfcPkgPdfJ101y_2021_DAO) wac.getBean("InfcPkgPdfJ101y_2021_DAO"); 
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

			TimingInfo millisBeginYetaP610001ToPsnl0100DataList = SmrmfUtils.startTiming(logger);

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

			SmrmfUtils.endTiming(logger, millisBeginYetaP610001ToPsnl0100DataList, "getYetaP610001ToPsnl0100DataList");

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
	public PagingLoadResult<BaseModel> getYetaP620001ToPdfJ203yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA6200_PDF_J203Y_DATA_LIST;
		InfcPkgPdfJ203ySrh_2021_VO   pdfJ203ySrhVO = new InfcPkgPdfJ203ySrh_2021_VO();
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
			pdfJ203yDAO = (InfcPkgPdfJ203y_2021_DAO) wac.getBean("InfcPkgPdfJ203y_2021_DAO"); 
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

			TimingInfo millisBeginYetaP610001ToPsnl0100DataList = SmrmfUtils.startTiming(logger);

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

			SmrmfUtils.endTiming(logger, millisBeginYetaP610001ToPsnl0100DataList, "getYetaP610001ToPsnl0100DataList");

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
	public PagingLoadResult<BaseModel> getYetaP620001ToPdfJ301yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA6200_PDF_J301Y_DATA_LIST;
		InfcPkgPdfJ301ySrh_2021_VO   pdfJ301ySrhVO = new InfcPkgPdfJ301ySrh_2021_VO();
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
			pdfJ301yDAO = (InfcPkgPdfJ301y_2021_DAO) wac.getBean("InfcPkgPdfJ301y_2021_DAO"); 
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

			TimingInfo millisBeginYetaP610001ToPsnl0100DataList = SmrmfUtils.startTiming(logger);

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

			SmrmfUtils.endTiming(logger, millisBeginYetaP610001ToPsnl0100DataList, "getYetaP610001ToPsnl0100DataList");

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
	public PagingLoadResult<BaseModel> getYetaP620001ToPdfJ401yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA6200_PDF_J401Y_DATA_LIST;
		InfcPkgPdfJ401ySrh_2021_VO   pdfJ401ySrhVO = new InfcPkgPdfJ401ySrh_2021_VO();
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
			pdfJ401yDAO = (InfcPkgPdfJ401y_2021_DAO) wac.getBean("InfcPkgPdfJ401y_2021_DAO"); 
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

			TimingInfo millisBeginYetaP610001ToPsnl0100DataList = SmrmfUtils.startTiming(logger);

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

			SmrmfUtils.endTiming(logger, millisBeginYetaP610001ToPsnl0100DataList, "getYetaP610001ToPsnl0100DataList");

		} catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	
	
	//2021연말정산_추가
	public PagingLoadResult<BaseModel> getYetaP620001ToPdfJ501yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA6200_PDF_J501Y_DATA_LIST;
		InfcPkgPdfJ501ySrh_2021_VO   pdfJ501ySrhVO = new InfcPkgPdfJ501ySrh_2021_VO();
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

		if  (MSFSharedUtils.paramNull(pdfJ501yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfJ501yDAO = (InfcPkgPdfJ501y_2021_DAO) wac.getBean("InfcPkgPdfJ501y_2021_DAO"); 
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
			pdfJ501ySrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
			pdfJ501ySrhVO.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));	// 정산구분 
			pdfJ501ySrhVO.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));		// 귀속년도
			pdfJ501ySrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));
			
			logger.debug(pdfJ501ySrhVO.getDpobCd() + " : j501y");
			//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 

				//Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

				int iResultCnt = pdfJ501yDAO.selectPdfJ501yListTotCnt(pdfJ501ySrhVO);

				SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");

				//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
				if (!pagingValues.pageExecute) { 
					pagingValues.offsetLimit = iResultCnt;       
				}

				pagingValues.totalRecordCount = iResultCnt;	       

				logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}

			TimingInfo millisBeginYetaP610001ToPsnl0100DataList = SmrmfUtils.startTiming(logger);

			/**페이지 카운트 처리를 위한 부분 */ 
			pdfJ501ySrhVO.setPageSize(pagingValues.totalRecordCount);  

			//Apply paging
			if (pagingValues.start > 0) {
				pdfJ501ySrhVO.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				pdfJ501ySrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			//
			//Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
			
			@SuppressWarnings("unchecked")
			//	            Collection<Map<String, Object>> list ??????
			List list = pdfJ501yDAO.selectPdfJ501yList(pdfJ501ySrhVO);

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

			SmrmfUtils.endTiming(logger, millisBeginYetaP610001ToPsnl0100DataList, "getYetaP610001ToPsnl0100DataList");

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
	public PagingLoadResult<BaseModel> getYetaP620001ToPdfK101yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA6200_PDF_K101Y_DATA_LIST;
		InfcPkgPdfK101ySrh_2021_VO   pdfK101ySrhVO = new InfcPkgPdfK101ySrh_2021_VO();
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
			pdfK101yDAO = (InfcPkgPdfK101y_2021_DAO) wac.getBean("InfcPkgPdfK101y_2021_DAO"); 
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

			TimingInfo millisBeginYetaP610001ToPsnl0100DataList = SmrmfUtils.startTiming(logger);

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

			SmrmfUtils.endTiming(logger, millisBeginYetaP610001ToPsnl0100DataList, "getYetaP610001ToPsnl0100DataList");

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
	public PagingLoadResult<BaseModel> getYetaP620001ToPdfL102yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA6200_PDF_L102Y_DATA_LIST;
		InfcPkgPdfL102ySrh_2021_VO   pdfL102ySrhVO = new InfcPkgPdfL102ySrh_2021_VO();
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
			pdfL102yDAO = (InfcPkgPdfL102y_2021_DAO) wac.getBean("InfcPkgPdfL102y_2021_DAO"); 
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

			TimingInfo millisBeginYetaP610001ToPsnl0100DataList = SmrmfUtils.startTiming(logger);

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

			SmrmfUtils.endTiming(logger, millisBeginYetaP610001ToPsnl0100DataList, "getYetaP610001ToPsnl0100DataList");

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
	public PagingLoadResult<BaseModel> getYetaP620001ToPdfN101yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA6200_PDF_N101Y_DATA_LIST;
		InfcPkgPdfN101ySrh_2021_VO   pdfN101ySrhVO = new InfcPkgPdfN101ySrh_2021_VO();
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
			pdfN101yDAO = (InfcPkgPdfN101y_2021_DAO) wac.getBean("InfcPkgPdfN101y_2021_DAO"); 
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

			TimingInfo millisBeginYetaP610001ToPsnl0100DataList = SmrmfUtils.startTiming(logger);

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

			SmrmfUtils.endTiming(logger, millisBeginYetaP610001ToPsnl0100DataList, "getYetaP610001ToPsnl0100DataList");

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
	public PagingLoadResult<BaseModel> getYetaP620001ToPdfO101yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA6200_PDF_O101Y_DATA_LIST;
		InfcPkgPdfO101ySrh_2021_VO   pdfO101ySrhVO = new InfcPkgPdfO101ySrh_2021_VO();
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
			pdfO101yDAO = (InfcPkgPdfO101y_2021_DAO) wac.getBean("InfcPkgPdfO101y_2021_DAO"); 
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

			TimingInfo millisBeginYetaP610001ToPsnl0100DataList = SmrmfUtils.startTiming(logger);

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

			SmrmfUtils.endTiming(logger, millisBeginYetaP610001ToPsnl0100DataList, "getYetaP610001ToPsnl0100DataList");

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
	public PagingLoadResult<BaseModel> getYetaP620001ToPdfP101yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA6200_PDF_P101Y_DATA_LIST;
		InfcPkgPdfP101ySrh_2021_VO   pdfP101ySrhVO = new InfcPkgPdfP101ySrh_2021_VO();
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
			pdfP101yDAO = (InfcPkgPdfP101y_2021_DAO) wac.getBean("InfcPkgPdfP101y_2021_DAO"); 
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

			TimingInfo millisBeginYetaP610001ToPsnl0100DataList = SmrmfUtils.startTiming(logger);

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

			SmrmfUtils.endTiming(logger, millisBeginYetaP610001ToPsnl0100DataList, "getYetaP610001ToPsnl0100DataList");

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
	public PagingLoadResult<BaseModel> getYetaP620001ToPdfP102yDataList(ServiceParameters serviceParameters) throws MSFException {


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA6200_PDF_P102Y_DATA_LIST;
		InfcPkgPdfP102ySrh_2021_VO   pdfP102ySrhVO = new InfcPkgPdfP102ySrh_2021_VO();
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
			pdfP102yDAO = (InfcPkgPdfP102y_2021_DAO) wac.getBean("InfcPkgPdfP102y_2021_DAO"); 
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

			TimingInfo millisBeginYetaP610001ToPsnl0100DataList = SmrmfUtils.startTiming(logger);

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

			SmrmfUtils.endTiming(logger, millisBeginYetaP610001ToPsnl0100DataList, "getYetaP610001ToPsnl0100DataList");

		} catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	
	//2021연말정산_추가
	public PagingLoadResult<BaseModel> getYetaP620001ToPdfQ101yDataList(ServiceParameters serviceParameters) throws MSFException {
		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA6200_PDF_Q101Y_DATA_LIST;
		InfcPkgPdfQ101ySrh_2021_VO  pdfQ101ySrhVO = new InfcPkgPdfQ101ySrh_2021_VO();
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

		if  (MSFSharedUtils.paramNull(pdfQ101yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfQ101yDAO = (InfcPkgPdfQ101y_2021_DAO) wac.getBean("InfcPkgPdfQ101y_2021_DAO"); 
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
			pdfQ101ySrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
			pdfQ101ySrhVO.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));	// 정산구분 
			pdfQ101ySrhVO.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));		// 귀속년도
			pdfQ101ySrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));

			//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 

				//Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

				int iResultCnt = pdfQ101yDAO.selectPdfQ101yListTotCnt(pdfQ101ySrhVO);

				SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");

				//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
				if (!pagingValues.pageExecute) { 
					pagingValues.offsetLimit = iResultCnt;       
				}

				pagingValues.totalRecordCount = iResultCnt;	       

				logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}

			TimingInfo millisBeginYetaP610001ToPsnl0100DataList = SmrmfUtils.startTiming(logger);

			/**페이지 카운트 처리를 위한 부분 */ 
			pdfQ101ySrhVO.setPageSize(pagingValues.totalRecordCount);  

			//Apply paging
			if (pagingValues.start > 0) {
				pdfQ101ySrhVO.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				pdfQ101ySrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			//
			//Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

			@SuppressWarnings("unchecked")
			//	            Collection<Map<String, Object>> list ??????
			List list = pdfQ101yDAO.selectPdfQ101yList(pdfQ101ySrhVO);

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

			SmrmfUtils.endTiming(logger, millisBeginYetaP610001ToPsnl0100DataList, "getYetaP610001ToPsnl0100DataList");

		} catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
		
		
	
		
	}
	
	
	public PagingLoadResult<BaseModel> getYetaP620001ToPdfQ201yDataList(ServiceParameters serviceParameters) throws MSFException {
		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA6200_PDF_Q201Y_DATA_LIST;
		InfcPkgPdfQ201ySrh_2021_VO  pdfQ201ySrhVO = new InfcPkgPdfQ201ySrh_2021_VO();
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

		if  (MSFSharedUtils.paramNull(pdfQ201yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfQ201yDAO = (InfcPkgPdfQ201y_2021_DAO) wac.getBean("InfcPkgPdfQ201y_2021_DAO"); 
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
			pdfQ201ySrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
			pdfQ201ySrhVO.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));	// 정산구분 
			pdfQ201ySrhVO.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));		// 귀속년도
			pdfQ201ySrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));

			//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 

				//Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

				int iResultCnt = pdfQ201yDAO.selectPdfQ201yListTotCnt(pdfQ201ySrhVO);

				SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");

				//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
				if (!pagingValues.pageExecute) { 
					pagingValues.offsetLimit = iResultCnt;       
				}

				pagingValues.totalRecordCount = iResultCnt;	       

				logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}

			TimingInfo millisBeginYetaP610001ToPsnl0100DataList = SmrmfUtils.startTiming(logger);

			/**페이지 카운트 처리를 위한 부분 */ 
			pdfQ201ySrhVO.setPageSize(pagingValues.totalRecordCount);  

			//Apply paging
			if (pagingValues.start > 0) {
				pdfQ201ySrhVO.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				pdfQ201ySrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			//
			//Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

			@SuppressWarnings("unchecked")
			//	            Collection<Map<String, Object>> list ??????
			List list = pdfQ201yDAO.selectPdfQ201yList(pdfQ201ySrhVO);

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

			SmrmfUtils.endTiming(logger, millisBeginYetaP610001ToPsnl0100DataList, "getYetaP610001ToPsnl0100DataList");

		} catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
		
		
	
		
	}
	
	
	
	
	
	public PagingLoadResult<BaseModel> getYetaP620001ToPdfQ301yDataList(ServiceParameters serviceParameters) throws MSFException {
		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA6200_PDF_Q301Y_DATA_LIST;
		InfcPkgPdfQ301ySrh_2021_VO  pdfQ301ySrhVO = new InfcPkgPdfQ301ySrh_2021_VO();
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

		if  (MSFSharedUtils.paramNull(pdfQ301yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfQ301yDAO = (InfcPkgPdfQ301y_2021_DAO) wac.getBean("InfcPkgPdfQ301y_2021_DAO"); 
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
			pdfQ301ySrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
			pdfQ301ySrhVO.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));	// 정산구분 
			pdfQ301ySrhVO.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));		// 귀속년도
			pdfQ301ySrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));

			//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 

				//Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

				int iResultCnt = pdfQ301yDAO.selectPdfQ301yListTotCnt(pdfQ301ySrhVO);

				SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");

				//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
				if (!pagingValues.pageExecute) { 
					pagingValues.offsetLimit = iResultCnt;       
				}

				pagingValues.totalRecordCount = iResultCnt;	       

				logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}

			TimingInfo millisBeginYetaP610001ToPsnl0100DataList = SmrmfUtils.startTiming(logger);

			/**페이지 카운트 처리를 위한 부분 */ 
			pdfQ301ySrhVO.setPageSize(pagingValues.totalRecordCount);  

			//Apply paging
			if (pagingValues.start > 0) {
				pdfQ301ySrhVO.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				pdfQ301ySrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			//
			//Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

			@SuppressWarnings("unchecked")
			//	            Collection<Map<String, Object>> list ??????
			List list = pdfQ301yDAO.selectPdfQ301yList(pdfQ301ySrhVO);

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

			SmrmfUtils.endTiming(logger, millisBeginYetaP610001ToPsnl0100DataList, "getYetaP610001ToPsnl0100DataList");

		} catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
		
		
	
		
	}
	
	
	
	

	@Override
	public Integer updateYetaP620001ToPdfA102Y(List<PdfA102yDTO> listPdfA102yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP620001ToPdfA102Y";

		String windowNm = "보장성보험 업데이트";
		String windowId = "YETAP620001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfA102yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfA102yDAO = (InfcPkgPdfA102y_2021_DAO) wac.getBean("InfcPkgPdfA102y_2021_DAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfA102y_2021_VO pdfA102yVo = new InfcPkgPdfA102y_2021_VO();
		InfcPkgYe161010_2021_VO  ye161010Vo = new InfcPkgYe161010_2021_VO();
				
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
				
				pdfA102yDAO.updateYetaP620001ToPdfA102y(pdfA102yVo);
				
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
			Func_PdfXml_Yeta2021_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2021_Insert();
			funcPdfXmlIn.pdfXml_Yeta2021_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
			
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
	public Integer updateYetaP620001ToPdfB101Y(List<PdfB101yDTO> listPdfB101yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP620001ToPdfB101Y";

		String windowNm = "의료비 업데이트";
		String windowId = "YETAP620001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfB101yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfB101yDAO = (InfcPkgPdfB101y_2021_DAO) wac.getBean("InfcPkgPdfB101y_2021_DAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfB101y_2021_VO pdfB101yVo = new InfcPkgPdfB101y_2021_VO();
		InfcPkgYe161010_2021_VO  ye161010Vo = new InfcPkgYe161010_2021_VO();
		
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
				
				pdfB101yDAO.updateYetaP620001ToPdfB101y(pdfB101yVo);

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
			Func_PdfXml_Yeta2021_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2021_Insert();
			funcPdfXmlIn.pdfXml_Yeta2021_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest()); 
			
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
	public Integer updateYetaP620001ToPdfB201Y(List<PdfB201yDTO> listPdfB201yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP620001ToPdfB201Y";

		String windowNm = "실손보험금 업데이트";
		String windowId = "YETAP620001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfB201yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfB201yDAO = (InfcPkgPdfB201y_2021_DAO) wac.getBean("InfcPkgPdfB201y_2021_DAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfB201y_2021_VO pdfB201yVo = new InfcPkgPdfB201y_2021_VO();
		InfcPkgYe161010_2021_VO  ye161010Vo = new InfcPkgYe161010_2021_VO();
		
		try{

			for(int iYetaCnt=0; iYetaCnt < listPdfB201yDto.size(); iYetaCnt++) {

				PdfB201yDTO pdfB201yDto = new PdfB201yDTO();  
				pdfB201yDto = listPdfB201yDto.get(iYetaCnt);  
				
				pdfB201yVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
				pdfB201yVo.setSystemkey(MSFSharedUtils.allowNulls(pdfB201yDto.getSystemkey()));
				pdfB201yVo.setManSeilNum(MSFSharedUtils.convertStringToBigDecimal(String.valueOf(pdfB201yDto.getManSeilNum())));
				pdfB201yVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfB201yDto.getYrtxBlggYr()));
				pdfB201yVo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfB201yDto.getClutSeptCd()));
				
				pdfB201yVo.setPdfDatAppYn(MSFSharedUtils.allowNulls(Boolean.parseBoolean(pdfB201yDto.getPdfDatAppYn())? "Y" : "N"));
				pdfB201yVo.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(pdfB201yDto.getPdfDatAppExcCtnt()));
				
				pdfB201yVo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
				pdfB201yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				pdfB201yDAO.updateYetaP620001ToPdfB201y(pdfB201yVo);

				if (iCnt == 0) {
					ye161010Vo.setDpobCd(MSFSharedUtils.allowNulls(pdfB201yVo.getDpobCd()));    					/** column 사업장코드 : dpobCd */
		        	ye161010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfB201yVo.getYrtxBlggYr()));    			/** column 귀속연도 : yrtxBlggYr */
		        	ye161010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfB201yVo.getClutSeptCd()));    			/** column 연말정산구분코드 : clutSeptCd */
		        	ye161010Vo.setSystemkey(MSFSharedUtils.allowNulls(pdfB201yVo.getSystemkey()));    				/** column SYSTEMKEY : systemkey */
				}
				
				iCnt = iCnt + 1;
			}

			/***************************************************************************************************************************
			 * pdf 저장 후 체크된 데이타에 대해서 업데이트 인서트 한다 
			 ***************************************************************************************************************************/
			ye161010Vo.setXmlFormCd("B201Y");
			Func_PdfXml_Yeta2021_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2021_Insert();
			funcPdfXmlIn.pdfXml_Yeta2021_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest()); 
			
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
	public Integer updateYetaP620001ToPdfC101Y(List<PdfC101yDTO> listPdfC101yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP620001ToPdfC101Y";

		String windowNm = "교육비 업데이트";
		String windowId = "YETAP620001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfC101yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfC101yDAO = (InfcPkgPdfC101y_2021_DAO) wac.getBean("InfcPkgPdfC101y_2021_DAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfC101y_2021_VO pdfC101yVo = new InfcPkgPdfC101y_2021_VO();
		InfcPkgYe161010_2021_VO  ye161010Vo = new InfcPkgYe161010_2021_VO();
		
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
				
				pdfC101yDAO.updateYetaP620001ToPdfC101y(pdfC101yVo);
				
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
			Func_PdfXml_Yeta2021_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2021_Insert();
			funcPdfXmlIn.pdfXml_Yeta2021_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
			
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
	public Integer updateYetaP620001ToPdfC202Y(List<PdfC202yDTO> listPdfC202yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP620001ToPdfC202Y";

		String windowNm = "직업훈련비 업데이트";
		String windowId = "YETAP620001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfC202yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfC202yDAO = (InfcPkgPdfC202y_2021_DAO) wac.getBean("InfcPkgPdfC202y_2021_DAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfC202y_2021_VO pdfC202yVo = new InfcPkgPdfC202y_2021_VO();
		InfcPkgYe161010_2021_VO  ye161010Vo = new InfcPkgYe161010_2021_VO();
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
				
				pdfC202yDAO.updateYetaP620001ToPdfC202y(pdfC202yVo);
				
				
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
			Func_PdfXml_Yeta2021_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2021_Insert();
			funcPdfXmlIn.pdfXml_Yeta2021_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
			
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
	public Integer updateYetaP620001ToPdfC301Y(List<PdfC301yDTO> listPdfC301yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP620001ToPdfC301Y";

		String windowNm = "교복구입비 업데이트";
		String windowId = "YETAP620001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfC301yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfC301yDAO = (InfcPkgPdfC301y_2021_DAO) wac.getBean("InfcPkgPdfC301y_2021_DAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfC301y_2021_VO pdfC301yVo = new InfcPkgPdfC301y_2021_VO();
		InfcPkgYe161010_2021_VO  ye161010Vo = new InfcPkgYe161010_2021_VO();
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
				
				pdfC301yDAO.updateYetaP620001ToPdfC301y(pdfC301yVo);
			
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
			Func_PdfXml_Yeta2021_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2021_Insert();
			funcPdfXmlIn.pdfXml_Yeta2021_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
			
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
	public Integer updateYetaP620001ToPdfC401Y(List<PdfC401yDTO> listPdfC401yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP620001ToPdfC401Y";

		String windowNm = "학자금대출상환액 업데이트";
		String windowId = "YETAP620001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfC401yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfC401yDAO = (InfcPkgPdfC401y_2021_DAO) wac.getBean("InfcPkgPdfC401y_2021_DAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfC401y_2021_VO pdfC401yVo = new InfcPkgPdfC401y_2021_VO();
		InfcPkgYe161010_2021_VO  ye161010Vo = new InfcPkgYe161010_2021_VO();
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
				
				pdfC401yDAO.updateYetaP620001ToPdfC401y(pdfC401yVo);
				
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
			Func_PdfXml_Yeta2021_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2021_Insert();
			funcPdfXmlIn.pdfXml_Yeta2021_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
			
			

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
	public Integer updateYetaP620001ToPdfD101Y(List<PdfD101yDTO> listPdfD101yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP620001ToPdfD101Y";

		String windowNm = "개인연금저축 업데이트";
		String windowId = "YETAP620001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfD101yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfD101yDAO = (InfcPkgPdfD101y_2021_DAO) wac.getBean("InfcPkgPdfD101y_2021_DAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfD101y_2021_VO pdfD101yVo = new InfcPkgPdfD101y_2021_VO();
		InfcPkgYe161010_2021_VO  ye161010Vo = new InfcPkgYe161010_2021_VO();
		
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
				
				pdfD101yDAO.updateYetaP620001ToPdfD101y(pdfD101yVo);
				
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
			Func_PdfXml_Yeta2021_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2021_Insert();
			funcPdfXmlIn.pdfXml_Yeta2021_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
			
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
	public Integer updateYetaP620001ToPdfE102Y(List<PdfE102yDTO> listPdfE102yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP620001ToPdfE102Y";

		String windowNm = "연금저축  업데이트";
		String windowId = "YETAP620001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfE102yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfE102yDAO = (InfcPkgPdfE102y_2021_DAO) wac.getBean("InfcPkgPdfE102y_2021_DAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfE102y_2021_VO pdfE102yVo = new InfcPkgPdfE102y_2021_VO();
		InfcPkgYe161010_2021_VO  ye161010Vo = new InfcPkgYe161010_2021_VO();
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
				
				pdfE102yDAO.updateYetaP620001ToPdfE102y(pdfE102yVo);
				
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
				Func_PdfXml_Yeta2021_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2021_Insert();
				funcPdfXmlIn.pdfXml_Yeta2021_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
				
				
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
	public Integer updateYetaP620001ToPdfF102Y(List<PdfF102yDTO> listPdfF102yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP620001ToPdfF102Y";

		String windowNm = "퇴직연금 업데이트";
		String windowId = "YETAP620001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfF102yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfF102yDAO = (InfcPkgPdfF102y_2021_DAO) wac.getBean("InfcPkgPdfF102y_2021_DAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfF102y_2021_VO pdfF102yVo = new InfcPkgPdfF102y_2021_VO();
		InfcPkgYe161010_2021_VO  ye161010Vo = new InfcPkgYe161010_2021_VO();
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
				
				pdfF102yDAO.updateYetaP620001ToPdfF102y(pdfF102yVo);
				
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
			Func_PdfXml_Yeta2021_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2021_Insert();
			funcPdfXmlIn.pdfXml_Yeta2021_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
			
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
	public Integer updateYetaP620001ToPdfG107Y(List<PdfG107yDTO> listPdfG107yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP620001ToPdfG107Y";

		String windowNm = "신용카드 업데이트";
		String windowId = "YETAP620001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfG107yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfG107yDAO = (InfcPkgPdfG107y_2021_DAO) wac.getBean("InfcPkgPdfG107y_2021_DAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfG107y_2021_VO pdfG107yVo = new InfcPkgPdfG107y_2021_VO();
		InfcPkgYe161010_2021_VO  ye161010Vo = new InfcPkgYe161010_2021_VO();
		try{

			for(int iYetaCnt=0; iYetaCnt < listPdfG107yDto.size(); iYetaCnt++) {

				PdfG107yDTO pdfG107yDto = new PdfG107yDTO();  
				pdfG107yDto = listPdfG107yDto.get(iYetaCnt);  
				
				pdfG107yVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
				pdfG107yVo.setSystemkey(MSFSharedUtils.allowNulls(pdfG107yDto.getSystemkey()));
				pdfG107yVo.setCardSeilNum(MSFSharedUtils.convertStringToBigDecimal(String.valueOf(pdfG107yDto.getCardSeilNum())));
				pdfG107yVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfG107yDto.getYrtxBlggYr()));
				pdfG107yVo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfG107yDto.getClutSeptCd()));
				
				pdfG107yVo.setPdfDatAppYn(MSFSharedUtils.allowNulls(Boolean.parseBoolean(pdfG107yDto.getPdfDatAppYn())? "Y" : "N"));
				pdfG107yVo.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(pdfG107yDto.getPdfDatAppExcCtnt()));
				
				pdfG107yVo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
				pdfG107yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				pdfG107yDAO.updateYetaP620001ToPdfG107y(pdfG107yVo);
			
				if (iCnt == 0) {
					ye161010Vo.setDpobCd(MSFSharedUtils.allowNulls(pdfG107yVo.getDpobCd()));    					/** column 사업장코드 : dpobCd */
		        	ye161010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfG107yVo.getYrtxBlggYr()));    			/** column 귀속연도 : yrtxBlggYr */
		        	ye161010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfG107yVo.getClutSeptCd()));    			/** column 연말정산구분코드 : clutSeptCd */
		        	ye161010Vo.setSystemkey(MSFSharedUtils.allowNulls(pdfG107yVo.getSystemkey()));    				/** column SYSTEMKEY : systemkey */
				}
				
				iCnt = iCnt + 1;
			}


			/***************************************************************************************************************************
			 * pdf 저장 후 체크된 데이타에 대해서 업데이트 인서트 한다 
			 ***************************************************************************************************************************/
			ye161010Vo.setXmlFormCd("G107Y");
			Func_PdfXml_Yeta2021_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2021_Insert();
			funcPdfXmlIn.pdfXml_Yeta2021_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
			
			
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
	public Integer updateYetaP620001ToPdfG207Y(List<PdfG207yDTO> listPdfG207yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP620001ToPdfG207Y";

		String windowNm = "현금영수증 업데이트";
		String windowId = "YETAP620001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfG207yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfG207yDAO = (InfcPkgPdfG207y_2021_DAO) wac.getBean("InfcPkgPdfG207y_2021_DAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfG207y_2021_VO pdfG207yVo = new InfcPkgPdfG207y_2021_VO();
		InfcPkgYe161010_2021_VO  ye161010Vo = new InfcPkgYe161010_2021_VO();
		
		try{

			for(int iYetaCnt=0; iYetaCnt < listPdfG207yDto.size(); iYetaCnt++) {

				PdfG207yDTO pdfG207yDto = new PdfG207yDTO();  
				pdfG207yDto = listPdfG207yDto.get(iYetaCnt);  
				
				pdfG207yVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
				pdfG207yVo.setSystemkey(MSFSharedUtils.allowNulls(pdfG207yDto.getSystemkey()));
				pdfG207yVo.setCashCardSeilNum(MSFSharedUtils.convertStringToBigDecimal(String.valueOf(pdfG207yDto.getCashCardSeilNum())));
				pdfG207yVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfG207yDto.getYrtxBlggYr()));
				pdfG207yVo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfG207yDto.getClutSeptCd()));
				
				pdfG207yVo.setPdfDatAppYn(MSFSharedUtils.allowNulls(Boolean.parseBoolean(pdfG207yDto.getPdfDatAppYn())? "Y" : "N"));
				pdfG207yVo.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(pdfG207yDto.getPdfDatAppExcCtnt()));
				
				pdfG207yVo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
				pdfG207yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				pdfG207yDAO.updateYetaP620001ToPdfG207y(pdfG207yVo);
				
				if (iCnt == 0) {
					ye161010Vo.setDpobCd(MSFSharedUtils.allowNulls(pdfG207yVo.getDpobCd()));    					/** column 사업장코드 : dpobCd */
		        	ye161010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfG207yVo.getYrtxBlggYr()));    			/** column 귀속연도 : yrtxBlggYr */
		        	ye161010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfG207yVo.getClutSeptCd()));    			/** column 연말정산구분코드 : clutSeptCd */
		        	ye161010Vo.setSystemkey(MSFSharedUtils.allowNulls(pdfG207yVo.getSystemkey()));    				/** column SYSTEMKEY : systemkey */
				}
				
				iCnt = iCnt + 1;
			}
			
			/***************************************************************************************************************************
			 * pdf 저장 후 체크된 데이타에 대해서 업데이트 인서트 한다 
			 ***************************************************************************************************************************/
			ye161010Vo.setXmlFormCd("G207M");
			Func_PdfXml_Yeta2021_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2021_Insert();
			funcPdfXmlIn.pdfXml_Yeta2021_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
			

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
	public Integer updateYetaP620001ToPdfG307Y(List<PdfG307yDTO> listPdfG307yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP620001ToPdfG307Y";

		String windowNm = "직불카드 업데이트";
		String windowId = "YETAP620001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfG307yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfG307yDAO = (InfcPkgPdfG307y_2021_DAO) wac.getBean("InfcPkgPdfG307y_2021_DAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfG307y_2021_VO pdfG307yVo = new InfcPkgPdfG307y_2021_VO();
		InfcPkgYe161010_2021_VO  ye161010Vo = new InfcPkgYe161010_2021_VO();
		
		try{

			for(int iYetaCnt=0; iYetaCnt < listPdfG307yDto.size(); iYetaCnt++) {

				PdfG307yDTO pdfG307yDto = new PdfG307yDTO();  
				pdfG307yDto = listPdfG307yDto.get(iYetaCnt);  
				
				pdfG307yVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
				pdfG307yVo.setSystemkey(MSFSharedUtils.allowNulls(pdfG307yDto.getSystemkey()));
				pdfG307yVo.setDirCardSeilNum(MSFSharedUtils.convertStringToBigDecimal(String.valueOf(pdfG307yDto.getDirCardSeilNum())));
				pdfG307yVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfG307yDto.getYrtxBlggYr()));
				pdfG307yVo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfG307yDto.getClutSeptCd()));
				
				pdfG307yVo.setPdfDatAppYn(MSFSharedUtils.allowNulls(Boolean.parseBoolean(pdfG307yDto.getPdfDatAppYn())? "Y" : "N"));
				pdfG307yVo.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(pdfG307yDto.getPdfDatAppExcCtnt()));
				
				pdfG307yVo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
				pdfG307yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				pdfG307yDAO.updateYetaP620001ToPdfG307y(pdfG307yVo);
				
				if (iCnt == 0) {
					ye161010Vo.setDpobCd(MSFSharedUtils.allowNulls(pdfG307yVo.getDpobCd()));    					/** column 사업장코드 : dpobCd */
		        	ye161010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfG307yVo.getYrtxBlggYr()));    			/** column 귀속연도 : yrtxBlggYr */
		        	ye161010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfG307yVo.getClutSeptCd()));    			/** column 연말정산구분코드 : clutSeptCd */
		        	ye161010Vo.setSystemkey(MSFSharedUtils.allowNulls(pdfG307yVo.getSystemkey()));    				/** column SYSTEMKEY : systemkey */
				}
				
				iCnt = iCnt + 1;
			}

			/***************************************************************************************************************************
			 * pdf 저장 후 체크된 데이타에 대해서 업데이트 인서트 한다 
			 ***************************************************************************************************************************/
			ye161010Vo.setXmlFormCd("G307Y");
			Func_PdfXml_Yeta2021_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2021_Insert();
			funcPdfXmlIn.pdfXml_Yeta2021_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
			
			
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
	public Integer updateYetaP620001ToPdfG407Y(List<PdfG407yDTO> listPdfG407yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP620001ToPdfG407Y";

		String windowNm = "제로페이 업데이트";
		String windowId = "YETAP620001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfG407yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfG407yDAO = (InfcPkgPdfG407y_2021_DAO) wac.getBean("InfcPkgPdfG407y_2021_DAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfG407y_2021_VO pdfG407yVo = new InfcPkgPdfG407y_2021_VO();
		InfcPkgYe161010_2021_VO  ye161010Vo = new InfcPkgYe161010_2021_VO();
		
		try{

			for(int iYetaCnt=0; iYetaCnt < listPdfG407yDto.size(); iYetaCnt++) {

				PdfG407yDTO pdfG407yDto = new PdfG407yDTO();  
				pdfG407yDto = listPdfG407yDto.get(iYetaCnt);  
				
				pdfG407yVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
				pdfG407yVo.setSystemkey(MSFSharedUtils.allowNulls(pdfG407yDto.getSystemkey()));
				pdfG407yVo.setZeroSeilNum(MSFSharedUtils.convertStringToBigDecimal(String.valueOf(pdfG407yDto.getZeroSeilNum())));
				pdfG407yVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfG407yDto.getYrtxBlggYr()));
				pdfG407yVo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfG407yDto.getClutSeptCd()));
				
				pdfG407yVo.setPdfDatAppYn(MSFSharedUtils.allowNulls(Boolean.parseBoolean(pdfG407yDto.getPdfDatAppYn())? "Y" : "N"));
				pdfG407yVo.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(pdfG407yDto.getPdfDatAppExcCtnt()));
				
				pdfG407yVo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
				pdfG407yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				pdfG407yDAO.updateYetaP620001ToPdfG407y(pdfG407yVo);
				
				if (iCnt == 0) {
					ye161010Vo.setDpobCd(MSFSharedUtils.allowNulls(pdfG407yVo.getDpobCd()));    					//** column 사업장코드 : dpobCd *//*
		        	ye161010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfG407yVo.getYrtxBlggYr()));    			//** column 귀속연도 : yrtxBlggYr *//*
		        	ye161010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfG407yVo.getClutSeptCd()));    			//** column 연말정산구분코드 : clutSeptCd *//*
		        	ye161010Vo.setSystemkey(MSFSharedUtils.allowNulls(pdfG407yVo.getSystemkey()));    				//** column SYSTEMKEY : systemkey *//*
				}
				
				iCnt = iCnt + 1;
			}

			/***************************************************************************************************************************
			 * pdf 저장 후 체크된 데이타에 대해서 업데이트 인서트 한다 
			 ***************************************************************************************************************************/
			ye161010Vo.setXmlFormCd("G407Y");
			Func_PdfXml_Yeta2021_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2021_Insert();
			funcPdfXmlIn.pdfXml_Yeta2021_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
			
			
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
	public Integer updateYetaP620001ToPdfJ101Y(List<PdfJ101yDTO> listPdfJ101yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP620001ToPdfJ101Y";

		String windowNm = "주택임차차입금원리금상환액 업데이트";
		String windowId = "YETAP620001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfJ101yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfJ101yDAO = (InfcPkgPdfJ101y_2021_DAO) wac.getBean("InfcPkgPdfJ101y_2021_DAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfJ101y_2021_VO pdfJ101yVo = new InfcPkgPdfJ101y_2021_VO();
		InfcPkgYe161010_2021_VO  ye161010Vo = new InfcPkgYe161010_2021_VO();
		
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
				
				pdfJ101yDAO.updateYetaP620001ToPdfJ101y(pdfJ101yVo);
				
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
			Func_PdfXml_Yeta2021_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2021_Insert();
			funcPdfXmlIn.pdfXml_Yeta2021_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
			
			
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
	public Integer updateYetaP620001ToPdfJ203Y(List<PdfJ203yDTO> listPdfJ203yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP620001ToPdfJ203Y";

		String windowNm = "장기주택저당차입금이자상환액 업데이트";
		String windowId = "YETAP620001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfJ203yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfJ203yDAO = (InfcPkgPdfJ203y_2021_DAO) wac.getBean("InfcPkgPdfJ203y_2021_DAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfJ203y_2021_VO pdfJ203yVo = new InfcPkgPdfJ203y_2021_VO();
		InfcPkgYe161010_2021_VO  ye161010Vo = new InfcPkgYe161010_2021_VO();
		
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
				
				pdfJ203yDAO.updateYetaP620001ToPdfJ203y(pdfJ203yVo);
				
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
			Func_PdfXml_Yeta2021_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2021_Insert();
			funcPdfXmlIn.pdfXml_Yeta2021_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
			
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
	public Integer updateYetaP620001ToPdfJ301Y(List<PdfJ301yDTO> listPdfJ301yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP620001ToPdfJ301Y";

		String windowNm = "주책마련저축 업데이트";
		String windowId = "YETAP620001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfJ301yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfJ301yDAO = (InfcPkgPdfJ301y_2021_DAO) wac.getBean("InfcPkgPdfJ301y_2021_DAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfJ301y_2021_VO pdfJ301yVo = new InfcPkgPdfJ301y_2021_VO();
		InfcPkgYe161010_2021_VO  ye161010Vo = new InfcPkgYe161010_2021_VO();
		
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
				
				pdfJ301yDAO.updateYetaP620001ToPdfJ301y(pdfJ301yVo);
				
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
			Func_PdfXml_Yeta2021_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2021_Insert();
			funcPdfXmlIn.pdfXml_Yeta2021_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
			
			
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
	public Integer updateYetaP620001ToPdfJ401Y(List<PdfJ401yDTO> listPdfJ401yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP620001ToPdfJ401Y";

		String windowNm = "목돈 안드는 전세 이자상환액 업데이트";
		String windowId = "YETAP620001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfJ401yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfJ401yDAO = (InfcPkgPdfJ401y_2021_DAO) wac.getBean("InfcPkgPdfJ401y_2021_DAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfJ401y_2021_VO pdfJ401yVo = new InfcPkgPdfJ401y_2021_VO();
		InfcPkgYe161010_2021_VO  ye161010Vo = new InfcPkgYe161010_2021_VO();
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
				
				pdfJ401yDAO.updateYetaP620001ToPdfJ401y(pdfJ401yVo);
				
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
			Func_PdfXml_Yeta2021_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2021_Insert();
			funcPdfXmlIn.pdfXml_Yeta2021_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
			
			
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
	
	
	
	//2021연말정산_추가
	@Override
	public Integer updateYetaP620001ToPdfJ501Y(List<PdfJ501yDTO> listPdfJ501yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP620001ToPdfJ501Y";

		String windowNm = "월세액 업데이트";
		String windowId = "YETAP620001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfJ501yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfJ501yDAO = (InfcPkgPdfJ501y_2021_DAO) wac.getBean("InfcPkgPdfJ501y_2021_DAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfJ501y_2021_VO pdfJ501yVo = new InfcPkgPdfJ501y_2021_VO();
		InfcPkgYe161010_2021_VO  ye161010Vo = new InfcPkgYe161010_2021_VO();
		try{

			for(int iYetaCnt=0; iYetaCnt < listPdfJ501yDto.size(); iYetaCnt++) {

				PdfJ501yDTO pdfJ501yDto = new PdfJ501yDTO();  
				pdfJ501yDto = listPdfJ501yDto.get(iYetaCnt);  
				
				pdfJ501yVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
				pdfJ501yVo.setSystemkey(MSFSharedUtils.allowNulls(pdfJ501yDto.getSystemkey()));
				pdfJ501yVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfJ501yDto.getYrtxBlggYr()));
				pdfJ501yVo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfJ501yDto.getClutSeptCd()));
				
				pdfJ501yVo.setPdfDatAppYn(MSFSharedUtils.allowNulls(Boolean.parseBoolean(pdfJ501yDto.getPdfDatAppYn())? "Y" : "N"));
				pdfJ501yVo.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(pdfJ501yDto.getPdfDatAppExcCtnt()));
				
				pdfJ501yVo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
				pdfJ501yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				pdfJ501yDAO.updateYetaP620001ToPdfJ501y(pdfJ501yVo);
				
				if (iCnt == 0) {
					ye161010Vo.setDpobCd(MSFSharedUtils.allowNulls(pdfJ501yVo.getDpobCd()));    					/** column 사업장코드 : dpobCd */
		        	ye161010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfJ501yVo.getYrtxBlggYr()));    			/** column 귀속연도 : yrtxBlggYr */
		        	ye161010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfJ501yVo.getClutSeptCd()));    			/** column 연말정산구분코드 : clutSeptCd */
		        	ye161010Vo.setSystemkey(MSFSharedUtils.allowNulls(pdfJ501yVo.getSystemkey()));    				/** column SYSTEMKEY : systemkey */
				}
				
				iCnt = iCnt + 1;
			}

			/***************************************************************************************************************************
			 * pdf 저장 후 체크된 데이타에 대해서 업데이트 인서트 한다 
			 ***************************************************************************************************************************/
			ye161010Vo.setXmlFormCd("J501Y");
			Func_PdfXml_Yeta2021_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2021_Insert();
			funcPdfXmlIn.pdfXml_Yeta2021_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
			
			
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
	public Integer updateYetaP620001ToPdfK101Y(List<PdfK101yDTO> listPdfK101yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP620001ToPdfK101Y";

		String windowNm = "소기업소상공인 공제부금  업데이트";
		String windowId = "YETAP620001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfK101yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfK101yDAO = (InfcPkgPdfK101y_2021_DAO) wac.getBean("InfcPkgPdfK101y_2021_DAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfK101y_2021_VO pdfK101yVo = new InfcPkgPdfK101y_2021_VO();
		InfcPkgYe161010_2021_VO  ye161010Vo = new InfcPkgYe161010_2021_VO();
		
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
				
				pdfK101yDAO.updateYetaP620001ToPdfK101y(pdfK101yVo);
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
			Func_PdfXml_Yeta2021_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2021_Insert();
			funcPdfXmlIn.pdfXml_Yeta2021_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
			

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
	public Integer updateYetaP620001ToPdfL102Y(List<PdfL102yDTO> listPdfL102yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP620001ToPdfL102Y";

		String windowNm = "기부금 업데이트";
		String windowId = "YETAP620001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfL102yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfL102yDAO = (InfcPkgPdfL102y_2021_DAO) wac.getBean("InfcPkgPdfL102y_2021_DAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfL102y_2021_VO pdfL102yVo = new InfcPkgPdfL102y_2021_VO();
		InfcPkgYe161010_2021_VO  ye161010Vo = new InfcPkgYe161010_2021_VO();
		
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
				
				pdfL102yDAO.updateYetaP620001ToPdfL102y(pdfL102yVo);
				
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
			Func_PdfXml_Yeta2021_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2021_Insert();
			funcPdfXmlIn.pdfXml_Yeta2021_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
			
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
	public Integer updateYetaP620001ToPdfN101Y(List<PdfN101yDTO> listPdfN101yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP620001ToPdfN101Y";

		String windowNm = "장기집합투자증권저축 업데이트";
		String windowId = "YETAP620001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfN101yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfN101yDAO = (InfcPkgPdfN101y_2021_DAO) wac.getBean("InfcPkgPdfN101y_2021_DAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfN101y_2021_VO pdfN101yVo = new InfcPkgPdfN101y_2021_VO();
		InfcPkgYe161010_2021_VO  ye161010Vo = new InfcPkgYe161010_2021_VO();
		
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
				
				pdfN101yDAO.updateYetaP620001ToPdfN101y(pdfN101yVo);
				
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
			Func_PdfXml_Yeta2021_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2021_Insert();
			funcPdfXmlIn.pdfXml_Yeta2021_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
			
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
	public Integer updateYetaP620001ToPdfO101Y(List<PdfO101yDTO> listPdfO101yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP620001ToPdfO101Y";

		String windowNm = "건강보험료 업데이트";
		String windowId = "YETAP620001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfO101yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfO101yDAO = (InfcPkgPdfO101y_2021_DAO) wac.getBean("InfcPkgPdfO101y_2021_DAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfO101y_2021_VO pdfO101yVo = new InfcPkgPdfO101y_2021_VO();
		InfcPkgYe161010_2021_VO  ye161010Vo = new InfcPkgYe161010_2021_VO();
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
				
				pdfO101yDAO.updateYetaP620001ToPdfO101y(pdfO101yVo);
				
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
			Func_PdfXml_Yeta2021_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2021_Insert();
			funcPdfXmlIn.pdfXml_Yeta2021_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
			
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
	public Integer updateYetaP620001ToPdfP102Y(List<PdfP102yDTO> listPdfP102yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP620001ToPdfP102Y";

		String windowNm = "국민연금보험료 업데이트";
		String windowId = "YETAP620001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfP102yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfP102yDAO = (InfcPkgPdfP102y_2021_DAO) wac.getBean("InfcPkgPdfP102y_2021_DAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfP102y_2021_VO pdfP102yVo = new InfcPkgPdfP102y_2021_VO();
		InfcPkgYe161010_2021_VO  ye161010Vo = new InfcPkgYe161010_2021_VO();
		
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
				
				pdfP102yDAO.updateYetaP620001ToPdfP102y(pdfP102yVo);
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
			Func_PdfXml_Yeta2021_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2021_Insert();
			funcPdfXmlIn.pdfXml_Yeta2021_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
			
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
	
	
	
	//2021연말정산_추가
	@Override
	public Integer updateYetaP620001ToPdfQ101Y(List<PdfQ101yDTO> listPdfQ101yDto, ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".updateYetaP620001ToPdfQ101Y";

		String windowNm = "벤처기업투자신탁 업데이트";
		String windowId = "YETAP620001";

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if  (MSFSharedUtils.paramNull(pdfQ101yDAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			pdfQ101yDAO = (InfcPkgPdfQ101y_2021_DAO) wac.getBean("InfcPkgPdfQ101y_2021_DAO"); 
		}

		//		Long result = new Long(1);
		//		Long iCnt = new Long(0);

		int result = 0;
		int iCnt = 0;

		BigDecimal seqn = new BigDecimal(0);

		InfcPkgPdfQ101y_2021_VO pdfQ101yVo = new InfcPkgPdfQ101y_2021_VO();
		InfcPkgYe161010_2021_VO  ye161010Vo = new InfcPkgYe161010_2021_VO();
		try{

			for(int iYetaCnt=0; iYetaCnt < listPdfQ101yDto.size(); iYetaCnt++) {

				PdfQ101yDTO pdfQ101yDto = new PdfQ101yDTO();  
				pdfQ101yDto = listPdfQ101yDto.get(iYetaCnt);  
				
				pdfQ101yVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
				pdfQ101yVo.setSystemkey(MSFSharedUtils.allowNulls(pdfQ101yDto.getSystemkey()));
				pdfQ101yVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfQ101yDto.getYrtxBlggYr()));
				pdfQ101yVo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfQ101yDto.getClutSeptCd()));
				pdfQ101yVo.setSecuNo(MSFSharedUtils.allowNulls(pdfQ101yDto.getSecuNo()));
				
				pdfQ101yVo.setPdfDatAppYn(MSFSharedUtils.allowNulls(Boolean.parseBoolean(pdfQ101yDto.getPdfDatAppYn())? "Y" : "N"));
				pdfQ101yVo.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(pdfQ101yDto.getPdfDatAppExcCtnt()));
				
				pdfQ101yVo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
				pdfQ101yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				pdfQ101yDAO.updateYetaP620001ToPdfQ101y(pdfQ101yVo);
				
				if (iCnt == 0) {
					ye161010Vo.setDpobCd(MSFSharedUtils.allowNulls(pdfQ101yVo.getDpobCd()));    					/** column 사업장코드 : dpobCd */
		        	ye161010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfQ101yVo.getYrtxBlggYr()));    			/** column 귀속연도 : yrtxBlggYr */
		        	ye161010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfQ101yVo.getClutSeptCd()));    			/** column 연말정산구분코드 : clutSeptCd */
		        	ye161010Vo.setSystemkey(MSFSharedUtils.allowNulls(pdfQ101yVo.getSystemkey()));    				/** column SYSTEMKEY : systemkey */
				}
				
				iCnt = iCnt + 1;
			}

			/***************************************************************************************************************************
			 * pdf 저장 후 체크된 데이타에 대해서 업데이트 인서트 한다 
			 ***************************************************************************************************************************/
			ye161010Vo.setXmlFormCd("Q101Y");
			Func_PdfXml_Yeta2021_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2021_Insert();
			funcPdfXmlIn.pdfXml_Yeta2021_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
			
			
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
	
	//2021연말정산_추가
		@Override
		public Integer updateYetaP620001ToPdfQ201Y(List<PdfQ201yDTO> listPdfQ201yDto, ActionDatabase actionDatabase) throws MSFException {
			String method = calledClass + ".updateYetaP620001ToPdfQ201Y";

			String windowNm = "전년도벤처기업투자신탁 업데이트";
			String windowId = "YETAP620001";

			// 1. 암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

			MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			
			if  (MSFSharedUtils.paramNull(pdfQ201yDAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				pdfQ201yDAO = (InfcPkgPdfQ201y_2021_DAO) wac.getBean("InfcPkgPdfQ201y_2021_DAO"); 
			}

			//		Long result = new Long(1);
			//		Long iCnt = new Long(0);

			int result = 0;
			int iCnt = 0;

			BigDecimal seqn = new BigDecimal(0);

			InfcPkgPdfQ201y_2021_VO pdfQ201yVo = new InfcPkgPdfQ201y_2021_VO();
			InfcPkgYe161010_2021_VO  ye161010Vo = new InfcPkgYe161010_2021_VO();
			try{

				for(int iYetaCnt=0; iYetaCnt < listPdfQ201yDto.size(); iYetaCnt++) {

					PdfQ201yDTO pdfQ201yDto = new PdfQ201yDTO();  
					pdfQ201yDto = listPdfQ201yDto.get(iYetaCnt);  
					
					pdfQ201yVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
					pdfQ201yVo.setSystemkey(MSFSharedUtils.allowNulls(pdfQ201yDto.getSystemkey()));
					pdfQ201yVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfQ201yDto.getYrtxBlggYr()));
					pdfQ201yVo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfQ201yDto.getClutSeptCd()));
					pdfQ201yVo.setSecuNo(MSFSharedUtils.allowNulls(pdfQ201yDto.getSecuNo()));
					
					pdfQ201yVo.setPdfDatAppYn(MSFSharedUtils.allowNulls(Boolean.parseBoolean(pdfQ201yDto.getPdfDatAppYn())? "Y" : "N"));
					pdfQ201yVo.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(pdfQ201yDto.getPdfDatAppExcCtnt()));
					
					pdfQ201yVo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
					pdfQ201yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
					
					pdfQ201yDAO.updateYetaP620001ToPdfQ201y(pdfQ201yVo);
					
					if (iCnt == 0) {
						ye161010Vo.setDpobCd(MSFSharedUtils.allowNulls(pdfQ201yVo.getDpobCd()));    					/** column 사업장코드 : dpobCd */
			        	ye161010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfQ201yVo.getYrtxBlggYr()));    			/** column 귀속연도 : yrtxBlggYr */
			        	ye161010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfQ201yVo.getClutSeptCd()));    			/** column 연말정산구분코드 : clutSeptCd */
			        	ye161010Vo.setSystemkey(MSFSharedUtils.allowNulls(pdfQ201yVo.getSystemkey()));    				/** column SYSTEMKEY : systemkey */
					}
					
					iCnt = iCnt + 1;
				}

				/***************************************************************************************************************************
				 * pdf 저장 후 체크된 데이타에 대해서 업데이트 인서트 한다 
				 ***************************************************************************************************************************/
				ye161010Vo.setXmlFormCd("Q201Y");
				Func_PdfXml_Yeta2021_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2021_Insert();
				funcPdfXmlIn.pdfXml_Yeta2021_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
				
				
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
		
		
		//2021연말정산_추가
		@Override
		public Integer updateYetaP620001ToPdfQ301Y(List<PdfQ301yDTO> listPdfQ301yDto, ActionDatabase actionDatabase) throws MSFException {
			String method = calledClass + ".updateYetaP620001ToPdfQ301Y";

			String windowNm = "전전년도벤처기업투자신탁 업데이트";
			String windowId = "YETAP620001";

			// 1. 암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

			MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			
			if  (MSFSharedUtils.paramNull(pdfQ301yDAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				pdfQ301yDAO = (InfcPkgPdfQ301y_2021_DAO) wac.getBean("InfcPkgPdfQ301y_2021_DAO"); 
			}

			//		Long result = new Long(1);
			//		Long iCnt = new Long(0);

			int result = 0;
			int iCnt = 0;

			BigDecimal seqn = new BigDecimal(0);

			InfcPkgPdfQ301y_2021_VO pdfQ301yVo = new InfcPkgPdfQ301y_2021_VO();
			InfcPkgYe161010_2021_VO  ye161010Vo = new InfcPkgYe161010_2021_VO();
			try{

				for(int iYetaCnt=0; iYetaCnt < listPdfQ301yDto.size(); iYetaCnt++) {

					PdfQ301yDTO pdfQ301yDto = new PdfQ301yDTO();  
					pdfQ301yDto = listPdfQ301yDto.get(iYetaCnt);  
					
					pdfQ301yVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
					pdfQ301yVo.setSystemkey(MSFSharedUtils.allowNulls(pdfQ301yDto.getSystemkey()));
					pdfQ301yVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfQ301yDto.getYrtxBlggYr()));
					pdfQ301yVo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfQ301yDto.getClutSeptCd()));
					pdfQ301yVo.setSecuNo(MSFSharedUtils.allowNulls(pdfQ301yDto.getSecuNo()));
					
					pdfQ301yVo.setPdfDatAppYn(MSFSharedUtils.allowNulls(Boolean.parseBoolean(pdfQ301yDto.getPdfDatAppYn())? "Y" : "N"));
					pdfQ301yVo.setPdfDatAppExcCtnt(MSFSharedUtils.allowNulls(pdfQ301yDto.getPdfDatAppExcCtnt()));
					
					pdfQ301yVo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
					pdfQ301yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
					
					pdfQ301yDAO.updateYetaP620001ToPdfQ301y(pdfQ301yVo);
					
					if (iCnt == 0) {
						ye161010Vo.setDpobCd(MSFSharedUtils.allowNulls(pdfQ301yVo.getDpobCd()));    					/** column 사업장코드 : dpobCd */
			        	ye161010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(pdfQ301yVo.getYrtxBlggYr()));    			/** column 귀속연도 : yrtxBlggYr */
			        	ye161010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(pdfQ301yVo.getClutSeptCd()));    			/** column 연말정산구분코드 : clutSeptCd */
			        	ye161010Vo.setSystemkey(MSFSharedUtils.allowNulls(pdfQ301yVo.getSystemkey()));    				/** column SYSTEMKEY : systemkey */
					}
					
					iCnt = iCnt + 1;
				}

				/***************************************************************************************************************************
				 * pdf 저장 후 체크된 데이타에 대해서 업데이트 인서트 한다 
				 ***************************************************************************************************************************/
				ye161010Vo.setXmlFormCd("Q301Y");
				Func_PdfXml_Yeta2021_Insert funcPdfXmlIn = new Func_PdfXml_Yeta2021_Insert();
				funcPdfXmlIn.pdfXml_Yeta2021_Insert(ye161010Vo, RemoteServiceUtil.getThreadLocalRequest());
				
				
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
