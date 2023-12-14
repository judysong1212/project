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
package com.app.exterms.personal.server.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.exterms.personal.client.dto.Psnl0100DTO;
import com.app.exterms.personal.client.dto.Psnl0110DTO;
import com.app.exterms.personal.client.service.PsnlP020001Service;
import com.app.exterms.personal.server.service.dao.Psnl0100DAO;
import com.app.exterms.personal.server.service.dao.Psnl0101DAO;
import com.app.exterms.personal.server.service.dao.Psnl0110DAO;
import com.app.exterms.personal.server.service.dao.Psnl0111DAO;
import com.app.exterms.personal.server.service.dao.Psnl0113DAO;
import com.app.exterms.personal.server.vo.Psnl0100VO;
import com.app.exterms.personal.server.vo.Psnl0101VO;
import com.app.exterms.personal.server.vo.Psnl0110VO;
import com.app.exterms.personal.server.vo.Psnl0111VO;
import com.app.exterms.personal.server.vo.Psnl0113VO;
import com.app.exterms.personal.shared.PsnlDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.insurance.server.service.dao.InfcPkgInsr3000DAO;
import com.app.smrmf.infc.insurance.server.service.dao.InfcPkgInsr4100DAO;
import com.app.smrmf.infc.insurance.server.service.dao.InfcPkgInsr5100DAO;
import com.app.smrmf.infc.insurance.server.service.dao.InfcPkgInsr6100DAO;
import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr3000VO;
import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr4100VO;
import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr5100VO;
import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr6100VO;
import com.app.smrmf.infc.payroll.server.service.dao.InfcPkgPayr0500DAO;
import com.app.smrmf.infc.payroll.server.service.dao.InfcPkgPayr0520DAO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0500VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0520VO;
import com.app.smrmf.props.ExtermsProps;

import egovframework.rte.psl.dataaccess.util.EgovMap;

@Service("PsnlP020001Service")
public class PsnlP020001ServiceImpl extends AbstractCustomServiceImpl  implements PsnlP020001Service, PsnlDaoConstants, ServletContextAware, ServletConfigAware  {  
	 
	private static final Logger logger = LoggerFactory.getLogger(PsnlP020001ServiceImpl.class);
	private static final String calledClass = PsnlP020001ServiceImpl.class.getName();
		

	
	  private static ServletContext sevltContext; 
	  private static ServletConfig sevltConfig;
	  
	  @Override
	    public void setServletConfig(ServletConfig servletConfig) {
	        this.sevltConfig = servletConfig;

	    }

	    @Override
	    public void setServletContext(ServletContext servletContext) {
	        this.sevltContext = servletContext;

	    }
	    
	// 인사 마스터
	@Autowired
    @Resource(name="psnl0100DAO")
    private Psnl0100DAO psnl0100DAO;
	
	@Resource(name="psnl0101DAO")
	private Psnl0101DAO psnl0101DAO;
	
	// 인사 고용
	@Autowired
    @Resource(name="psnl0110DAO")
	private Psnl0110DAO psnl0110DAO;
	
	// 인사 인적
    @Resource(name="psnl0111DAO")
    private Psnl0111DAO psnl0111DAO;
    
	// 인사 신상
    @Resource(name="psnl0113DAO")
    private Psnl0113DAO psnl01131DAO;
	
	@Resource(name = "InfcPkgPayr0500DAO")
	private InfcPkgPayr0500DAO infcPayr0500DAO;
	
	@Resource(name = "InfcPkgPayr0520DAO")
    private InfcPkgPayr0520DAO infcPayr0520DAO;
	
	
    @Resource(name="InfcPkgInsr3000DAO")
    private InfcPkgInsr3000DAO infcInsr3000DAO;
    
    @Resource(name="InfcPkgInsr4100DAO")
    private InfcPkgInsr4100DAO infcInsr4100DAO;
    
    
    @Resource(name="InfcPkgInsr5100DAO")
    private InfcPkgInsr5100DAO infcInsr5100DAO;
    
    
    @Resource(name="InfcPkgInsr6100DAO")
    private InfcPkgInsr6100DAO infcInsr6100DAO;

	
	/** 기간제 인사 고용 내역 리스트를 읽어들인다 **/
	@SuppressWarnings("unused")
	@Override
	public List<HashMap<String, String>> getPsnlP020002ExcelData(String fileFullPath)throws MSFException {
		// TODO Auto-generated method stub
		//ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		//InputStream input = classLoader.getResourceAsStream(fileFullPath);
		
		String windowNm = "신규고용일괄등록";
		String windowId = "PsnlP020001";
		
		String method = calledClass + ".getPsnlP020002ExcelData";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		Psnl0110VO psnl0110Vo;
		
		//이미지 저장정보를 가지고 온다.
		HashMap<String, String> globals = MSFServerUtils.getLocalidedMessages(RemoteServiceUtil.getThreadLocalConfig(), RemoteServiceUtil.getThreadLocalRequest()); 
		

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		List<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
		List<HashMap<String,String>> dataList = new ArrayList<HashMap<String, String>>();
		List<HashMap<String,String>> returnDataList = new ArrayList<HashMap<String, String>>();
		List egovResultDataList = new ArrayList();
		
		if(fileFullPath != null && !"".equals(fileFullPath)){
			
			String UPLOAD_DIRECTORY =  globals.get("PayGen.fileStorePath");  
			
			String osType =  globals.get("Globals.OsType");  
			String path = "";
			if("WINDOWS".equals(osType)) {
				path = "\\";
			}else {
				path = "/";
			}
 
			
			fileFullPath = UPLOAD_DIRECTORY + path + fileFullPath;
 
			
			File file = new File(fileFullPath);
//			MultipartRequest file = new MultipartRequest(fileFullPath);
			
			FileInputStream fis = null;
			boolean delChk  = false;
//			OPCPackage pkg = null;
//			Properties properties = new Properties();
			
			try{
				
				psnl0110Vo = new Psnl0110VO();
				psnl0110Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
				System.out.println("파일 : " + fileFullPath);
				fis = new FileInputStream(fileFullPath);
				Workbook wb = WorkbookFactory.create(fis);
				
				
//				Workbook w = WorkbookFactory.create(file);
//				fis = new FileInputStream(file);
				
//				XSSFWorkbook wb = new XSSFWorkbook(OPCPackage.open(inputStream));
//				org.apache.poi.ss.usermodel.Workbook w = WorkbookFactory.create(file);
//				pkg = OPCPackage.open(fileFullPath);
				
				
				Sheet sheet = wb.getSheetAt(0);
				Iterator<Row> rowIterator = sheet.iterator();
				int iRow = 0;
				
				//rowIterator = (Iterator<Row>) rowIterator.next();
				//rowIterator = (Iterator<Row>) rowIterator.next();
				
				Row row = rowIterator.next();
				row = rowIterator.next();
				row = rowIterator.next();
				row = rowIterator.next();
				
				while(rowIterator.hasNext()){
					
					row = rowIterator.next();
					
					//Row row = rowIterator.next();
					
					iRow = iRow + 1;
					
					Iterator<Cell> cellIterator = row.cellIterator();
					HashMap<String, String> map = new HashMap<String, String>();
					
						
						while(cellIterator.hasNext()){
							
							
							Cell cell = cellIterator.next();
							map.put("rnum", iRow+"");
							
							switch(cell.getColumnIndex()){
							case 0: // 신규구분코드
								map.put("emymtNewTypCd", String.valueOf(cell.getStringCellValue()));
								
								if("01".equals(String.valueOf(cell.getStringCellValue()))) {
									map.put("emymtNewTypNm", "신규");
								}else {
									map.put("emymtNewTypNm", "기존");
								}
								
								psnl0110Vo.setEmymtNewTypCd(String.valueOf(cell.getStringCellValue()));
								
								break;
								
							case 1: // 고용유형코드
								map.put("emymtTypCd", String.valueOf(cell.getStringCellValue()));
								psnl0110Vo.setEmymtTypCd(String.valueOf(cell.getStringCellValue()));
								break;
								
							case 2: //관리부서코드
								map.put("mangeDeptCd", MSFSharedUtils.allowNulls(cell.getStringCellValue()));		
								psnl0110Vo.setDeptCd(MSFSharedUtils.allowNulls(cell.getStringCellValue()));
								
								break;
								
							case 3: // 소속부서코드
								map.put("currAffnDeptCd", MSFSharedUtils.allowNulls(cell.getStringCellValue()));
								psnl0110Vo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(cell.getStringCellValue()));
								break;
								
							case 4: // 성명
								map.put("hanNm", cell.getStringCellValue());
								break;
								
							case 5: // 성명(한자)
								map.put("chinCharNm", cell.getStringCellValue());
								break;
								
							case 6: // 주민등록번호
								
								// 암호화
								map.put("resnRegnNum", MSFSharedUtils.allowNulls(cell.getStringCellValue()).replaceAll("-",""));
								psnl0110Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(cell.getStringCellValue()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));
								
								break;

							case 7: // 시작일자
								map.put("emymtBgnnDt", MSFSharedUtils.allowNulls(cell.getStringCellValue()));
								break;
								
							case 8: // 종료일자
								map.put("emymtEndDt", MSFSharedUtils.allowNulls(cell.getStringCellValue()));
								break;
								
							case 9: // 사업년도
								map.put("businApptnYr",  MSFSharedUtils.allowNulls(cell.getStringCellValue()));
								psnl0110Vo.setBusinApptnYr(MSFSharedUtils.allowNulls(cell.getStringCellValue()));
								break;
								
							case 10: // 사업코드
								map.put("businCd",  MSFSharedUtils.allowNulls(cell.getStringCellValue()));
								psnl0110Vo.setBusinCd(MSFSharedUtils.allowNulls(cell.getStringCellValue()));
								break;								
								
							case 11: // 현근무지
								map.put("currPaeWorkNm",  String.valueOf(cell.getStringCellValue()));
								break;	
								
							case 12: // 고용사유내용
								map.put("emymtReasCtnt",  String.valueOf(cell.getStringCellValue()));
								break;
								
							case 13: // 우편번호
								map.put("husRoadNmZpcd",  String.valueOf(cell.getStringCellValue()));
								break;
								
							case 14: // 기본주소
								map.put("husRoadNmFndtnAddr",  String.valueOf(cell.getStringCellValue()));
								break;
								
							case 15: // 상세주소
								map.put("husRoadNmDtlPatrAddr",  String.valueOf(cell.getStringCellValue()));
								break;
								
							case 16: // 전화번호
								map.put("husPhnNum",  String.valueOf(cell.getStringCellValue()));
								break;
								
							case 17: // 핸드폰번호
								map.put("cellPhneNum",  String.valueOf(cell.getStringCellValue()));
								break;
								
							case 18: // 장애구분
								map.put("dabtyDivCd",  String.valueOf(cell.getStringCellValue()));
								break;
								
							case 19: // 장애등급
								map.put("dabtyGrdeCd",  String.valueOf(cell.getStringCellValue()));
								break;
								
							case 20: // 장애판정일자
								map.put("dabtyAjmtDt",  String.valueOf(cell.getStringCellValue()));
								break;

							}
						}
						
						try {
							
							// 3.복호화 리턴받을 값 선언
							String rrnDecCrypt = "";
							
							egovResultDataList = psnl0110DAO.selectPsnl0110ExlDataListChk(psnl0110Vo);
							
							if(egovResultDataList != null && egovResultDataList.size() > 0){
								for(int i = 0 ; i < egovResultDataList.size(); i++){
									Psnl0110DTO dto = new Psnl0110DTO();
									Map tempMap = (Map)egovResultDataList.get(i);
									Iterator<String> keys = tempMap.keySet().iterator();
									
									while( keys.hasNext() ){
							            String key = keys.next();
							            
							            if("resnRegnNum".equals(key)) {
					            			// 3.복호화
					            			rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(tempMap.get("resnRegnNum")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);
							        		map.put(key, rrnDecCrypt);
//							            	map.put(key,  String.valueOf(tempMap.get(key)));
					            		}else {
					            			map.put(key,  String.valueOf(tempMap.get(key)));
					            		}
							        }
								}
							}
							
						} catch (Exception e) {
							
							// TODO Auto-generated catch block
							e.printStackTrace();
							
							/** 에러 로그 **/			
							MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);
							
							throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
						}
						
						map.put("filaPath", file.getPath());
						
						list.add(map);
						
						
						// 데이터 이상 여부 판단
						//for(int i=0; i < list.size(); i++){
							
							// 데이터를 담아준다.
							dataList.add(map);//조회데이터
							
							// TODO 추후 주석풀고 테스트
//							// 500건씩 처리
//							if(iRow % 30 == 0) {
//								
//								// 조회
//								returnDataList = null;
//								
//
//								dataList.clear();
//							}else {
//								if(iRow == list.size()) {
//									// 조회
//									returnDataList = null;
//								}
//								
//							}
							
						//}
					}
					
					
					try {
						
						
					} finally {
//						fis.getChannel().close();
						fis.close();
//						properties.clear();
//						pkg.close(); 
//						fis.reset();
						delChk = file.delete();
						System.out.println("삭제여부 		: " + delChk);
						
					}
				
				
				}catch (Exception e) {
						
						try {
							fis.close();
							delChk = file.delete();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						System.out.println("삭제여부 		: " + delChk);
					
					e.printStackTrace();
					
					/** 에러 로그 **/			
					MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"R",e, windowNm , windowId);
					
					return new ArrayList<HashMap<String, String>>();
					
				}
			}
			
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "R");
			
			return list;
		}

	
	
	//기간제 신규 고용 내역을 등록한다.
	@SuppressWarnings("null")
	@Override
	public List<Psnl0110DTO> updateXlsPsnl0110ToP020002(List<Psnl0110DTO> insertPsnl0110List)throws MSFException {
		
		// TODO Auto-generated method stub
		Long result = new Long(1);
		Psnl0110VO psnl0110Vo;
		
		
		String method = calledClass + ".updateXlsPsnl0110ToP020002";
		
		List<Psnl0110DTO> resultList = new ArrayList<Psnl0110DTO>();
		List<Psnl0110VO> dataList;
		
//		Long iCnt = new Long(0);
		Psnl0100DTO psnl0100Dto;
		Psnl0110DTO psnl0110Dto = new Psnl0110DTO();
//		Psnl0110BM returnPsnl0110BM;
		Psnl0110DTO returnPsnl0110Dto = new Psnl0110DTO();
		Psnl0100VO psnl0100Vo = new Psnl0100VO();
		
		Psnl0111VO psnl0111Vo = new Psnl0111VO();
		Psnl0113VO psnl0113Vo = new Psnl0113VO();
		
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
		try {  
			
	           if  (MSFSharedUtils.paramNull(psnl0100DAO)) {
	                
	                WebApplicationContext wac = WebApplicationContextUtils.
	                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	                psnl0100DAO = (Psnl0100DAO) wac.getBean("psnl0100DAO" ); 
	           }
	           
	           
	           if  (MSFSharedUtils.paramNull(psnl0110DAO)) {
	                
	                WebApplicationContext wac = WebApplicationContextUtils.
	                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	                psnl0110DAO = (Psnl0110DAO) wac.getBean("psnl0110DAO" ); 
	            }
	           
	           
	           if  (MSFSharedUtils.paramNull(psnl0111DAO)) {
	                
	                WebApplicationContext wac = WebApplicationContextUtils.
	                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	                psnl0111DAO = (Psnl0111DAO) wac.getBean("psnl0111DAO" ); 
	            }
	           
	           
	           if  (MSFSharedUtils.paramNull(psnl01131DAO)) {
	                
	                WebApplicationContext wac = WebApplicationContextUtils.
	                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	                psnl01131DAO = (Psnl0113DAO) wac.getBean("psnl01131DAO" ); 
	           }
	           
	           
	           
			
				int dataCount = 0;							// 저장한 데이터 건수
				int batchCount = 200; 						// 배치 처리한 건수
				int totalCount = insertPsnl0110List.size(); // 전체 데이터의 건수
				
				for(int iPsnlCnt=0;iPsnlCnt < insertPsnl0110List.size();iPsnlCnt++) {
					
					psnl0110Dto = insertPsnl0110List.get(iPsnlCnt);
					
					// 기간제근로자 셋팅
					psnl0110Dto.setEmymtDivCd("A0020020");
	                
					psnl0110Vo = new Psnl0110VO();  
	//				returnPsnl0110BM = new Psnl0110BM();
	//				resultList = new ArrayList<Psnl0110DTO>();
					
					dataList = new ArrayList<Psnl0110VO>();
	//				resultList = new ArrayList<Psnl0110DTO>();
					
					// 정상 데이터만 처리
					if(!psnl0110Dto.getDataChk().contains("N")) {
					
						SimpleDateFormat transFormat = new SimpleDateFormat("yyyyMMdd");
						
						psnl0110Vo.setRnum(MSFSharedUtils.allowNulls(psnl0110Dto.getRnum()));
						psnl0110Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
						psnl0110Vo.setEmymtDivCd(psnl0110Dto.getEmymtDivCd());
						psnl0110Vo.setSystemkey(MSFSharedUtils.allowNulls(psnl0110Dto.getSystemkey()));
						psnl0110Vo.setDataChk(MSFSharedUtils.allowNulls(psnl0110Dto.getDataChk()));
						psnl0110Vo.setEmymtNewTypCd(MSFSharedUtils.allowNulls(psnl0110Dto.getEmymtNewTypCd()));
						psnl0110Vo.setEmymtNewTypNm(MSFSharedUtils.allowNulls(psnl0110Dto.getEmymtNewTypNm()));
						psnl0110Vo.setEmymtTypCd(MSFSharedUtils.allowNulls(psnl0110Dto.getEmymtTypCd()));
						psnl0110Vo.setEmymtTypNm(MSFSharedUtils.allowNulls(psnl0110Dto.getEmymtTypNm()));
						psnl0110Vo.setMangeDeptCd(MSFSharedUtils.allowNulls(psnl0110Dto.getMangeDeptCd()));
	//					psnl0110Vo.setMangeDeptNm(MSFSharedUtils.allowNulls(psnl0110Dto.getMangeDeptNm()));
						psnl0110Vo.setResnRegnNum(MSFSharedUtils.allowNulls(psnl0110Dto.getResnRegnNum()));
						psnl0110Vo.setDeptCd(MSFSharedUtils.allowNulls(psnl0110Dto.getCurrAffnDeptCd()));
						psnl0110Vo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(psnl0110Dto.getCurrAffnDeptCd()));
	//					psnl0110Vo.setCurrAffnDeptNm(MSFSharedUtils.allowNulls(psnl0110Dto.getCurrAffnDeptNm()));
						psnl0110Vo.setHanNm(MSFSharedUtils.allowNulls(psnl0110Dto.getHanNm()));
						psnl0110Vo.setChinCharNm(MSFSharedUtils.allowNulls(psnl0110Dto.getChinCharNm()));
						
						
						psnl0110Vo.setEmymtBgnnDt(MSFSharedUtils.allowNulls(transFormat.format(psnl0110Dto.getEmymtBgnnDt())));
			
						
						psnl0110Vo.setEmymtEndDt(MSFSharedUtils.allowNulls(transFormat.format(psnl0110Dto.getEmymtEndDt())));
						psnl0110Vo.setBusinApptnYr(MSFSharedUtils.allowNulls(psnl0110Dto.getBusinApptnYr()));
						psnl0110Vo.setBusinCd(MSFSharedUtils.allowNulls(psnl0110Dto.getBusinCd()));
						psnl0110Vo.setBusinNm(MSFSharedUtils.allowNulls(psnl0110Dto.getBusinNm()));
						psnl0110Vo.setCurrPaeWorkNm(MSFSharedUtils.allowNulls(psnl0110Dto.getCurrPaeWorkNm()));
						psnl0110Vo.setEmymtReasCtnt(MSFSharedUtils.allowNulls(psnl0110Dto.getEmymtReasCtnt()));
						
						psnl0110Vo.setKybdr(sessionUser.getUsrId());
						psnl0110Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
						psnl0110Vo.setIsmt(sessionUser.getUsrId());
						psnl0110Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
							
						
						/** ++++++++++++++++++ 신규/기존 근로자에 대한 데이터 처리 시작 ++++++++++++++++++ **/ 
						// 1. 주민등록번호를 가지고 이미 기등록된 사람인지 체크
						psnl0100Vo = new Psnl0100VO();
						psnl0100Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
						psnl0100Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult, MSFSharedUtils.allowNulls(psnl0110Vo.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));
						
						String systemkeyStr = psnl0100DAO.getSystemkey(psnl0100Vo);
						
						
						// 신규 일 경우
						if(psnl0110Vo.getEmymtNewTypCd() == "01" || "01".equals(psnl0110Vo.getEmymtNewTypCd())) {
							
							// 2. 시스템키 없으면 신규 등록 로직 처리
							//   , 없을경우 고용구분타입을 '기존' 근로자로 변경처리하고 시스템키 담아줌.
							if(systemkeyStr == null || "".equals(systemkeyStr)) {
								systemkeyStr = insertPsnl0100(psnl0110Vo);
								psnl0110Vo.setSystemkey(systemkeyStr);
								
								
								// 인사 인적 insert 처리
								psnl0111Vo = new Psnl0111VO();
								
								psnl0111Vo.setDpobCd(MSFSharedUtils.allowNulls(psnl0110Vo.getDpobCd()));
								psnl0111Vo.setSystemkey(MSFSharedUtils.allowNulls(psnl0110Vo.getSystemkey()));
								psnl0111Vo.setHusRoadNmZpcd(MSFSharedUtils.allowNulls(psnl0110Dto.getHusRoadNmZpcd()));
								psnl0111Vo.setHusRoadNmFndtnAddr(MSFSharedUtils.allowNulls(psnl0110Dto.getHusRoadNmFndtnAddr()));
								psnl0111Vo.setHusRoadNmDtlPatrAddr(MSFSharedUtils.allowNulls(psnl0110Dto.getHusRoadNmDtlPatrAddr()));
								psnl0111Vo.setHusPhnNum(MSFSharedUtils.allowNulls(psnl0110Dto.getHusPhnNum()));
								psnl0111Vo.setCellPhneNum(MSFSharedUtils.allowNulls(psnl0110Dto.getCellPhneNum()));
								
								psnl0111Vo.setKybdr(sessionUser.getUsrId());    										/** column 입력자 : kybdr */ 
								psnl0111Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());		/** column 입력주소 : inptAddr */ 
								
								psnl0111DAO.insertPsnl0111_S(psnl0111Vo);
								
								
								// 인사 신상 insert 처리
								psnl0113Vo = new Psnl0113VO();
								psnl0113Vo.setDpobCd(MSFSharedUtils.allowNulls(psnl0110Vo.getDpobCd()));
								psnl0113Vo.setSystemkey(MSFSharedUtils.allowNulls(psnl0110Vo.getSystemkey()));
								
								psnl0113Vo.setDabtyDivCd(MSFSharedUtils.allowNulls(psnl0110Dto.getDabtyDivCd()));
								psnl0113Vo.setDabtyGrdeCd(MSFSharedUtils.allowNulls(psnl0110Dto.getDabtyGrdeCd()));
								psnl0113Vo.setDabtyAjmtDt(MSFSharedUtils.allowNulls(psnl0110Dto.getDabtyAjmtDt()));
								
								psnl0113Vo.setKybdr(sessionUser.getUsrId());    										/** column 입력자 : kybdr */ 
								psnl0113Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());		/** column 입력주소 : inptAddr */ 
								
								psnl01131DAO.insertPsnl0113_S(psnl0113Vo);
								
								
							}else {
								psnl0110Vo.setEmymtNewTypCd("02");
								psnl0110Vo.setEmymtNewTypNm("기존");
								psnl0110Vo.setSystemkey(systemkeyStr);
							}
						
						// 기존일 경우 
						}else {
								psnl0110Vo.setSystemkey(systemkeyStr);
						}
						/** ++++++++++++++++++ 신규/기존 근로자에 대한 데이터 처리 종료 ++++++++++++++++++ **/ 
							
						
						
						
						
						dataCount = dataCount + 1;
						dataList.add(psnl0110Vo);
							
						// BACTH 처리 시작
						if(dataCount % batchCount == 0) {
							// 고용구분, 고용유형, 시작일자, 종료일자, 부서코드, 사업코드가 일치할 경우 중복 insert를 막기 위해 delete 처리 후 insert 처리 해준다.
							psnl0110DAO.insertXlsData(dataList);
							dataList.clear();
							totalCount = 0;
						}else {
							
							if (totalCount == insertPsnl0110List.size()) {
								// 고용 등록
								psnl0110DAO.insertXlsData(dataList);
							}
						}
						
						
						
						
						if("A0420010".equals(psnl0110Vo.getEmymtTypCd()) || psnl0110Vo.getEmymtTypCd() == "A0420010") {
							
							Psnl0101VO psnl0101Vo = new Psnl0101VO();

				            psnl0101Vo.setDpobCd(MSFSharedUtils.allowNulls(psnl0110Vo.getDpobCd()));
				            psnl0101Vo.setSystemkey(MSFSharedUtils.allowNulls(psnl0110Vo.getSystemkey()));

				            psnl0101Vo.setEmymtDivCd(MSFSharedUtils.allowNulls(psnl0110Vo.getEmymtDivCd()));
				            psnl0101Vo.setFrstBseEmymtDt(psnl0110Vo.getEmymtBgnnDt());
				            psnl0101Vo.setIsmt(sessionUser.getUsrId());
				            psnl0101Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());

				            psnl0101DAO.deletePsnl0101(psnl0101Vo);
				            psnl0101DAO.insertPsnl0101(psnl0101Vo);
				                
							
							EgovMap map01 =  psnl0110DAO.selectInsrPsnl0110(psnl0110Vo);
							
							
		                	// 신규고용일 경우 사대보험에 insert 해줌
		                	InfcPkgInsr3000VO insr3000Vo = new InfcPkgInsr3000VO();
							InfcPkgInsr4100VO insr4100Vo = new InfcPkgInsr4100VO();
							InfcPkgInsr5100VO insr5100Vo = new InfcPkgInsr5100VO();
							InfcPkgInsr6100VO insr6100Vo = new InfcPkgInsr6100VO();
							
							insr3000Vo.setDpobCd(String.valueOf(map01.get("dpobCd")));    							/** column 사업장코드 : dpobCd */
							insr3000Vo.setSystemkey(String.valueOf(map01.get("systemkey")));    					/** column SYSTEMKEY : systemkey */
							insr3000Vo.setEmymtSeilNum(new BigDecimal(String.valueOf(map01.get("emymtSeilNum"))));  /** column 고용일련번호 : emymtSeilNum */
							insr3000Vo.setKybdr(sessionUser.getUsrId());    										/** column 입력자 : kybdr */ 
							insr3000Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());		/** column 입력주소 : inptAddr */ 
	
							insr4100Vo.setDpobCd(String.valueOf(map01.get("dpobCd")));    							/** column 사업장코드 : dpobCd */
							insr4100Vo.setSystemkey(String.valueOf(map01.get("systemkey")));    					/** column SYSTEMKEY : systemkey */
							insr4100Vo.setEmymtSeilNum(new BigDecimal(String.valueOf(map01.get("emymtSeilNum"))));	/** column 고용일련번호 : emymtSeilNum */ 
							insr4100Vo.setKybdr(sessionUser.getUsrId());    										/** column 입력자 : kybdr */ 
							insr4100Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());		/** column 입력주소 : inptAddr */ 
	
						
							insr5100Vo.setDpobCd(String.valueOf(map01.get("dpobCd")));    							/** column 사업장코드 : dpobCd */
							insr5100Vo.setSystemkey(String.valueOf(map01.get("systemkey")));    					/** column SYSTEMKEY : systemkey */
							insr5100Vo.setEmymtSeilNum(new BigDecimal(String.valueOf(map01.get("emymtSeilNum"))));  /** column 고용일련번호 : emymtSeilNum */ 
							insr5100Vo.setKybdr(sessionUser.getUsrId());    										/** column 입력자 : kybdr */ 
							insr5100Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());		/** column 입력주소 : inptAddr */ 
	
							
							insr6100Vo.setDpobCd(String.valueOf(map01.get("dpobCd")));    							/** column 사업장코드 : dpobCd */
							insr6100Vo.setSystemkey(String.valueOf(map01.get("systemkey")));   	 					/** column SYSTEMKEY : systemkey */ 
							insr6100Vo.setEmymtSeilNum(new BigDecimal(String.valueOf(map01.get("emymtSeilNum"))));  /** column 고용일련번호 : emymtSeilNum */
							insr6100Vo.setKybdr(sessionUser.getUsrId());    										/** column 입력자 : kybdr */ 
							insr6100Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());		/** column 입력주소 : inptAddr */ 
							
							
							infcInsr3000DAO.deleteInsr3000(insr3000Vo);
							infcInsr4100DAO.deleteInsr4100(insr4100Vo);
							infcInsr5100DAO.deleteInsr5100(insr5100Vo);
							infcInsr6100DAO.deleteInsr6100(insr6100Vo);
							
							infcInsr3000DAO.insertInsr3000(insr3000Vo);
							infcInsr4100DAO.insertInsr4100(insr4100Vo);
							infcInsr5100DAO.insertInsr5100(insr5100Vo);
							infcInsr6100DAO.insertInsr6100(insr6100Vo);
							
						}
							
					}		
					
					
					
					psnl0110Dto.setRnum(MSFSharedUtils.allowNulls(psnl0110Dto.getRnum()));
					psnl0110Dto.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
						
						
	//				psnl0100Vo = new Psnl0100VO();
	//				psnl0100Vo.setDpobCd(sessionUser.getDpobCd());
	//				psnl0100Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult, MSFSharedUtils.allowNulls(psnl0110Dto.getResnRegnNum().replaceAll("-","")),AnyCryptUtils.SEC_RRNUMC));
	//				String systemkeyStr = psnl0100DAO.getSystemkey(psnl0100Vo);	// 시스템키를 가져온다.
	//				psnl0110Dto.setSystemkey(systemkeyStr);
						
						
					returnPsnl0110Dto = new Psnl0110DTO();
					
					// 데이터 처리 여부
					if(psnl0110Dto.getDataChk().contains("N")) {
						returnPsnl0110Dto.setDataChk("X");
					}else {
						returnPsnl0110Dto.setDataChk("V");
					}
					returnPsnl0110Dto.setDpobCd(sessionUser.getDpobCd());
					returnPsnl0110Dto.setSystemkey(MSFSharedUtils.allowNulls(psnl0110Vo.getSystemkey()));
					returnPsnl0110Dto.setRnum(MSFSharedUtils.allowNulls(psnl0110Dto.getRnum()));
					returnPsnl0110Dto.setHanNm(MSFSharedUtils.allowNulls(psnl0110Dto.getHanNm()));
					returnPsnl0110Dto.setChinCharNm(MSFSharedUtils.allowNulls(psnl0110Dto.getChinCharNm()));
					returnPsnl0110Dto.setEmymtDivCd(MSFSharedUtils.allowNulls(psnl0110Vo.getEmymtDivCd()));
					returnPsnl0110Dto.setEmymtNewTypCd(MSFSharedUtils.allowNulls(psnl0110Vo.getEmymtNewTypCd()));
					returnPsnl0110Dto.setEmymtNewTypNm(MSFSharedUtils.allowNulls(psnl0110Dto.getEmymtNewTypNm()));
					returnPsnl0110Dto.setEmymtTypCd(MSFSharedUtils.allowNulls(psnl0110Dto.getEmymtTypCd()));
					returnPsnl0110Dto.setEmymtTypNm(MSFSharedUtils.allowNulls(psnl0110Dto.getEmymtTypNm()));
					returnPsnl0110Dto.setMangeDeptCd(MSFSharedUtils.allowNulls(psnl0110Dto.getMangeDeptCd()));
					returnPsnl0110Dto.setMangeDeptNm(MSFSharedUtils.allowNulls(psnl0110Dto.getMangeDeptNm()));
					returnPsnl0110Dto.setResnRegnNum(MSFSharedUtils.allowNulls(psnl0110Dto.getResnRegnNum()));
					returnPsnl0110Dto.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(psnl0110Dto.getCurrAffnDeptCd()));
					returnPsnl0110Dto.setCurrAffnDeptNm(MSFSharedUtils.allowNulls(psnl0110Dto.getCurrAffnDeptNm()));
					returnPsnl0110Dto.setHanNm(MSFSharedUtils.allowNulls(psnl0110Dto.getHanNm()));
					returnPsnl0110Dto.setChinCharNm(MSFSharedUtils.allowNulls(psnl0110Dto.getChinCharNm()));
					
					returnPsnl0110Dto.setEmymtBgnnDt(psnl0110Dto.getEmymtBgnnDt() );
					returnPsnl0110Dto.setEmymtEndDt( psnl0110Dto.getEmymtEndDt() );
					
					returnPsnl0110Dto.setBusinApptnYr(MSFSharedUtils.allowNulls(psnl0110Dto.getBusinApptnYr()));
					returnPsnl0110Dto.setBusinCd(MSFSharedUtils.allowNulls(psnl0110Dto.getBusinCd()));
					returnPsnl0110Dto.setBusinNm(MSFSharedUtils.allowNulls(psnl0110Dto.getBusinNm()));
					returnPsnl0110Dto.setCurrPaeWorkNm(MSFSharedUtils.allowNulls(psnl0110Dto.getCurrPaeWorkNm()));
					returnPsnl0110Dto.setEmymtReasCtnt(MSFSharedUtils.allowNulls(psnl0110Dto.getEmymtReasCtnt()));
					
					returnPsnl0110Dto.setHusRoadNmZpcd(MSFSharedUtils.allowNulls(psnl0110Dto.getHusRoadNmZpcd()));
					returnPsnl0110Dto.setHusRoadNmFndtnAddr(MSFSharedUtils.allowNulls(psnl0110Dto.getHusRoadNmFndtnAddr()));
					returnPsnl0110Dto.setHusRoadNmDtlPatrAddr(MSFSharedUtils.allowNulls(psnl0110Dto.getHusRoadNmDtlPatrAddr()));
					returnPsnl0110Dto.setHusPhnNum(MSFSharedUtils.allowNulls(psnl0110Dto.getHusPhnNum()));
					returnPsnl0110Dto.setCellPhneNum(MSFSharedUtils.allowNulls(psnl0110Dto.getCellPhneNum()));
					
					returnPsnl0110Dto.setDabtyDivCd(MSFSharedUtils.allowNulls(psnl0110Dto.getDabtyDivCd()));
					returnPsnl0110Dto.setDabtyGrdeCd(MSFSharedUtils.allowNulls(psnl0110Dto.getDabtyGrdeCd()));
					returnPsnl0110Dto.setDabtyAjmtDt(MSFSharedUtils.allowNulls(psnl0110Dto.getDabtyAjmtDt()));
					
						
					//정상 데이터만 처리 
					if(!psnl0110Dto.getDataChk().contains("N")) {
							
						// 인사 마스터 업데이트
						psnl0100Update(returnPsnl0110Dto);
					}
					
					
					// 리턴할 데이터
					resultList.add(returnPsnl0110Dto);
				} 
				
				
	//			// 각 사대보험 테이블에 고용에 따른 누락자 자료 생성
	//			infcInsr3000DAO.insertInsr3000_NOT_EXISTS(new InfcPkgInsr3000VO());
	//			infcInsr4100DAO.insertInsr4100_NOT_EXISTS(new InfcPkgInsr4100VO());
	//		    infcInsr5100DAO.insertInsr5100_NOT_EXISTS(new InfcPkgInsr5100VO());
	//		    infcInsr6100DAO.insertInsr6100_NOT_EXISTS(new InfcPkgInsr6100VO());
			    
			    
			} catch (Exception ex) {
				logger.error("EXCEPTION calling updateXlsPsnl0110ToP020002(): "+ex); 
				
				/** 에러 로그 **/			
				MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S:C",ex, "고용일괄등록" , "PsnlP020001");
		            
				result = new Long(0);
				throw MSFServerUtils.getOperationException("updateXlsPsnl0110ToP020002", ex, logger);
			} finally {
		          
			}
			
		return resultList;
		
	}
	
	/** 인사 신규 등록 **/
	private String insertPsnl0100(Psnl0110VO psnl0110Vo) {
		
		
		String systemkeyStr;
		
		String method = calledClass + ".insertPsnl0100";
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		Psnl0100VO psnl0100Vo = new Psnl0100VO();
		
		try {
			
			psnl0100Vo.setDpobCd(psnl0110Vo.getDpobCd());
			psnl0100Vo.setDeptCd(psnl0110Vo.getMangeDeptCd());
			psnl0100Vo.setCurrAffnDeptCd(psnl0110Vo.getCurrAffnDeptCd());
			psnl0100Vo.setHanNm(psnl0110Vo.getHanNm());
			psnl0100Vo.setChinCharNm(psnl0110Vo.getChinCharNm());
			
			// ---- 주민등록번호를 이용하여 성별과 생년월일을 가져온다. ----
	        String sxDivCdTemp = "";
	        sxDivCdTemp = psnl0110Vo.getResnRegnNum().substring(7,8);
	        if("1".equals(sxDivCdTemp) || "3".equals(sxDivCdTemp)) {
	        	psnl0100Vo.setSxDivCd("A0040010");				// 성별
	        	
	        	
	        }else if("2".equals(sxDivCdTemp) || "4".equals(sxDivCdTemp)) {
	        	psnl0100Vo.setSxDivCd("A0040020");				// 성별
	        	
	        }
	        
	        sxDivCdTemp = "";
	        sxDivCdTemp = psnl0110Vo.getResnRegnNum().substring(7,8);
	        if("1".equals(sxDivCdTemp) || "2".equals(sxDivCdTemp)) {
	        	psnl0100Vo.setYoobhMnthDay("19" + psnl0110Vo.getResnRegnNum().substring(0, 6));		// 생년월일
	        	
	        	
	        }else if("3".equals(sxDivCdTemp) || "4".equals(sxDivCdTemp)) {
	        	psnl0100Vo.setYoobhMnthDay("20" + psnl0110Vo.getResnRegnNum().substring(0, 6));		// 생년월일
	        }
	        // -------------------------------------
	        
			psnl0100Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult, MSFSharedUtils.allowNulls(psnl0110Vo.getResnRegnNum().replaceAll("-","")),AnyCryptUtils.SEC_RRNUMC));
			psnl0100Vo.setBusinCd(psnl0110Vo.getBusinCd());
			psnl0100Vo.setFrstEmymtDt(psnl0110Vo.getEmymtBgnnDt());
			psnl0100Vo.setEmymtDivCd("A0020020");
			psnl0100Vo.setEmymtBgnnDt(psnl0110Vo.getEmymtBgnnDt());
			psnl0100Vo.setEmymtEndDt(psnl0110Vo.getEmymtEndDt());
			psnl0100Vo.setHdofcCodtnCd("A0030010");
			
			psnl0100Vo.setKybdr(sessionUser.getUsrId());
			psnl0100Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			psnl0100Vo.setIsmt(sessionUser.getUsrId());
			psnl0100Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			
			
			String systemkey = psnl0100DAO.getNewSystemkey(psnl0100Vo.getDpobCd());	// 새로운 시스템키를 가져온다.
			psnl0100Vo.setSystemkey(systemkey);
			systemkeyStr = systemkey;
			
			psnl0100DAO.insertXlsPsnl0100(psnl0100Vo);
			
			
			//jungmin 2014.09.25
			//급여인사 마스터 등록 추가 시작
			InfcPkgPayr0500VO payr0500vo = new InfcPkgPayr0500VO();
			InfcPkgPayr0520VO tpPayr0520vo = new InfcPkgPayr0520VO();
			
			payr0500vo.setDpobCd(psnl0100Vo.getDpobCd());
			payr0500vo.setSystemkey(systemkey);
//			HashMap<String, String> tempMap = new HashMap<String, String>();
			HashMap<String, String> tempMap = new HashMap<String, String>();
			tempMap.put("dpobCd", psnl0100Vo.getDpobCd() );
			tempMap.put("deptCd", psnl0100Vo.getCurrAffnDeptCd());
			payr0500vo.setPayrMangDeptCd(psnl0100DAO.getPayDeptCd(tempMap));
			payr0500vo.setEmymtDivCd("A0020020");
//			payr0500vo.setRetryClutYn("Y"); 
			payr0500vo.setPayRcptYn("Y"); 
			/** 2015.07.13 소득세 관련추가  */
			payr0500vo.setAddIncmTxApptnRtoCd(ExtermsProps.getProps("PAYR_TAX_B0290020"));    /** column 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
			payr0500vo.setAddIncmTxApptnYrMnth("");/** column 추가소득세적용년월 : addIncmTxApptnYrMnth */
			payr0500vo.setAddIncmTxApptnYn("N");   /** column 추가소득세적용여부 : addIncmTxApptnYn  N : 최초입력  Y: 변경적용 E : 급여적용 이후 수정불가 .과세기간동*/
			
			payr0500vo.setKybdr(sessionUser.getUsrId());
			payr0500vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			payr0500vo.setIsmt(sessionUser.getUsrId());
			payr0500vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			
			BeanUtils.copyProperties(tpPayr0520vo, payr0500vo);
			
			tpPayr0520vo.setPayItemCd("");
			tpPayr0520vo.setPymtDducItemSilNum(BigDecimal.ZERO);
			 
			tpPayr0520vo = infcPayr0520DAO.selectPayr0520(tpPayr0520vo);
			
			if (MSFSharedUtils.paramNull(tpPayr0520vo)) {
				infcPayr0500DAO.deletePayr0500(payr0500vo);
			}  
			
			infcPayr0500DAO.insertPayr0500(payr0500vo);
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, "고용일괄등록" , "PsnlP020001");
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
		
		return systemkeyStr;
		
	}
	
	private void psnl0100Update(Psnl0110DTO psnl0110Dto) {
		
		
		String windowNm = "신규고용일괄등록";
		String windowId = "PsnlP020001";
		
		String method = calledClass + ".psnl0100Update";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		Psnl0100DTO psnl0100Dto;
		
		
		String returnVal = "";
		
		try{
			
			psnl0100Dto = new Psnl0100DTO();
			
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyyMMdd");
			
			psnl0100Dto.setDpobCd(sessionUser.getDpobCd());
			psnl0100Dto.setSystemkey(psnl0110Dto.getSystemkey());
			psnl0100Dto.setEmymtDivCd(psnl0110Dto.getEmymtDivCd());
//			psnl0100Dto.setDataChk(MSFSharedUtils.allowNulls(psnl0110Dto.getDataChk()));
			psnl0100Dto.setEmymtTypCd(MSFSharedUtils.allowNulls(psnl0110Dto.getEmymtTypCd()));
			psnl0100Dto.setDeptCd(MSFSharedUtils.allowNulls(psnl0110Dto.getMangeDeptCd()));
			psnl0100Dto.setResnRegnNum(MSFSharedUtils.allowNulls(psnl0110Dto.getResnRegnNum()));
			psnl0100Dto.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(psnl0110Dto.getCurrAffnDeptCd()));
			psnl0100Dto.setCurrAffnDeptNm(MSFSharedUtils.allowNulls(psnl0110Dto.getCurrAffnDeptNm()));
			psnl0100Dto.setHanNm(MSFSharedUtils.allowNulls(psnl0110Dto.getHanNm()));
			psnl0100Dto.setChinCharNm(MSFSharedUtils.allowNulls(psnl0110Dto.getChinCharNm()));
			psnl0100Dto.setEmymtBgnnDt(MSFSharedUtils.allowNulls(transFormat.format( psnl0110Dto.getEmymtBgnnDt())));
			psnl0100Dto.setEmymtEndDt(MSFSharedUtils.allowNulls(transFormat.format(psnl0110Dto.getEmymtEndDt())));
			psnl0100Dto.setBusinCd(MSFSharedUtils.allowNulls(psnl0110Dto.getBusinCd()));
			psnl0100Dto.setRetryReasCtnt(MSFSharedUtils.allowNulls(psnl0110Dto.getEmymtReasCtnt()));
			
			/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
			/** 1차 : 고용 구분에 따라 **/
			//기간제일 때
			if("A0020020".equals(psnl0100Dto.getEmymtDivCd())) {
					returnVal += "_"+ psnl0100DAO.updatePsnl0100BUSIN_CD(psnl0100Dto);						//사업
					returnVal += "_"+ psnl0100DAO.updatePsnl0100RETRY_DT(psnl0100Dto);						//퇴직일자
			}
			/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
			
			
			/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
			/** 2차 : 고용 유형에 따라 **/
			//신규 or 재고용
			if("A0420010".equals(psnl0100Dto.getEmymtTypCd())|| "A0420020".equals(psnl0100Dto.getEmymtTypCd())) {
				//고용구분코드 신규 or 직제개편
//					returnVal += "_"+ psnl0100DAO.updatePsnl0100CURR_AFFN_DEPT_CD(psnl0100Dto);	//소속 부서 
				returnVal += "_"+ psnl0100DAO.updatePsnl0100CURR_DEPT_APPMT_DT(psnl0100Dto);			//현부서 발령일
				
				//고용구분코드 신규일 때
				returnVal += "_"+ psnl0100DAO.updatePsnl0100FRST_EMYMT_DT(psnl0100Dto);					//최초고용일자
				
			//직제개편	
			}else if("A0420050".equals(psnl0100Dto.getEmymtTypCd())) {
				//고용구분코드 신규 or 직제개편
//					returnVal += "_"+ psnl0100DAO.updatePsnl0100CURR_AFFN_DEPT_CD(psnl0100Dto);	//현부서
				returnVal += "_"+ psnl0100DAO.updatePsnl0100CURR_DEPT_APPMT_DT(psnl0100Dto);			//현부서 발령일
			
			//퇴직
			}else if("A0420990".equals(psnl0100Dto.getEmymtTypCd())) {
				//고용유형이 퇴직일때만
				returnVal += "_"+ psnl0100DAO.updatePsnl0100RETRY_DT(psnl0100Dto);						//퇴직일자
				
			//전보
			}else if("A0420060".equals(psnl0100Dto.getEmymtTypCd())) {
				returnVal += "_"+ psnl0100DAO.updatePsnl0100CURR_AFFN_DEPT_CD(psnl0100Dto);				//소속 부서 
				returnVal += "_"+ psnl0100DAO.updatePsnl0100CURR_DEPT_APPMT_DT(psnl0100Dto);			//현부서 발령일
			}
			/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
			
			/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
			/** 3차 : 공통 사항 **/
//				returnVal += "_"+ psnl0100DAO.updatePsnl0100EMYMT_DIV_CD(psnl0100Dto);	//고용구분
			returnVal += "_"+ psnl0100DAO.updatePsnl0100EMYMT_BGNN_DT(psnl0100Dto);						//고용시작일
			returnVal += "_"+ psnl0100DAO.updatePsnl0100EMYMT_END_DT(psnl0100Dto);						//고용종료일
			returnVal += "_"+ psnl0100DAO.updatePsnl0100HDOFC_CODTN_CD(psnl0100Dto);					//재직상태코드
//				returnVal += "_"+ psnl0100DAO.updatePsnl0100HDOFC_CODTN_CD(psnl0100Dto);//재직상태코드
			
			returnVal += "_"+ psnl0100DAO.updatePsnl0100ODTY_CD(psnl0100Dto);							//직책코드
			returnVal += "_"+ psnl0100DAO.updatePsnl0100RETRY_REAS_CTNT(psnl0100Dto);					//고용해제사유
			/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
			
		}catch(Exception e) {
			
			e.printStackTrace();
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
			
		}
		
		
	}
	
	
	
	
//	/** 기간제 인사 고용 내역 리스트를 읽어들인다 **/
//	@Override
//	public HashMap<String, Object> exportDataList(List<Psnl0110DTO> insertPsnl0110List)throws MSFException {
//		// TODO Auto-generated method stub
//		//ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//		//InputStream input = classLoader.getResourceAsStream(fileFullPath);
//		
//		String windowNm = "신규고용일괄등록";
//		String windowId = "PsnlP020001";
//		
//		String method = calledClass + ".getPsnlP020002ExcelData";
//		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
//		
//		int rtn = 1;
//
//		// 1. 암호화 객체 생성
//		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
//		
//		Psnl0110VO psnl0110Vo = new Psnl0110VO();
//		Psnl0110DTO psnl0110Dto = new Psnl0110DTO();
//		
//		HashMap<String, Object> map = new HashMap<String, Object>();
//		
//        List<Psnl0110VO> excelList = new ArrayList<Psnl0110VO>();
//			
//		try {
//			
//			
//			for(int i = 0; i < insertPsnl0110List.size(); i++ ) {
//				
////				DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat("yyyyMMdd");
//				
//				psnl0110Vo = new Psnl0110VO();
//				psnl0110Dto = insertPsnl0110List.get(i);
//				
//				psnl0110Vo.setRnum(MSFSharedUtils.allowNulls(psnl0110Dto.getRnum()));
//				psnl0110Vo.setSystemkey(MSFSharedUtils.allowNulls(psnl0110Dto.getSystemkey()));
//				psnl0110Vo.setDataChk(MSFSharedUtils.allowNulls(psnl0110Dto.getDataChk()));
//				psnl0110Vo.setEmymtNewTypCd(MSFSharedUtils.allowNulls(psnl0110Dto.getEmymtNewTypCd()));
//				psnl0110Vo.setEmymtNewTypNm(MSFSharedUtils.allowNulls(psnl0110Dto.getEmymtNewTypNm()));
//				psnl0110Vo.setEmymtTypCd(MSFSharedUtils.allowNulls(psnl0110Dto.getEmymtTypCd()));
//				psnl0110Vo.setEmymtTypNm(MSFSharedUtils.allowNulls(psnl0110Dto.getEmymtTypNm()));
//				psnl0110Vo.setMangeDeptCd(MSFSharedUtils.allowNulls(psnl0110Dto.getMangeDeptCd()));
//				psnl0110Vo.setMangeDeptNm(MSFSharedUtils.allowNulls(psnl0110Dto.getMangeDeptNm()));
//				psnl0110Vo.setResnRegnNum(MSFSharedUtils.allowNulls(psnl0110Dto.getResnRegnNum()));
//				psnl0110Vo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(psnl0110Dto.getCurrAffnDeptCd()));
//				psnl0110Vo.setCurrAffnDeptNm(MSFSharedUtils.allowNulls(psnl0110Dto.getCurrAffnDeptNm()));
//				psnl0110Vo.setHanNm(MSFSharedUtils.allowNulls(psnl0110Dto.getHanNm()));
//				psnl0110Vo.setChinCharNm(MSFSharedUtils.allowNulls(psnl0110Dto.getChinCharNm()));
//				psnl0110Vo.setEmymtBgnnDt(psnl0110Dto.getEmymtBgnnDt().toString());
//				psnl0110Vo.setEmymtEndDt(psnl0110Dto.getEmymtEndDt().toString());
//				psnl0110Vo.setBusinApptnYr(MSFSharedUtils.allowNulls(psnl0110Dto.getBusinApptnYr()));
//				psnl0110Vo.setBusinCd(MSFSharedUtils.allowNulls(psnl0110Dto.getBusinCd()));
//				psnl0110Vo.setBusinNm(MSFSharedUtils.allowNulls(psnl0110Dto.getBusinNm()));
//				psnl0110Vo.setCurrPaeWorkNm(MSFSharedUtils.allowNulls(psnl0110Dto.getCurrPaeWorkNm()));
//				psnl0110Vo.setEmymtReasCtnt(MSFSharedUtils.allowNulls(psnl0110Dto.getEmymtReasCtnt()));
//				
//				excelList.add(psnl0110Vo);
//				
//			}
//			
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			
//			rtn = 0;
//
//		}
//		
//		
//        map = new HashMap<String, Object>();
//        map.put("listFilePsnl", excelList);
//				
//        
//        
////        new ModelAndView("psnlP020001ExcelView", map);
//			
////			/** 로그반영
////			 * CRUDSBLO
////			 * C:create		R:read		U:update
////	    	 * D:delete		S:select	B:배치 
////	    	 * L:로그인		O:로그아웃
////	    	 */
////			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "R");
//			
//		return map;
//	}
//	
	
	
	
	
	
	
	
	
}	