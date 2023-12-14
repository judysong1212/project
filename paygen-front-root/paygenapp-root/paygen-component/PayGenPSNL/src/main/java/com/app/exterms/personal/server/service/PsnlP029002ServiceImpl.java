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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

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

import com.app.exterms.personal.client.dto.Psnl0126DTO;
import com.app.exterms.personal.client.dto.PsnlP029002DTO;
import com.app.exterms.personal.client.service.PsnlP029002Service;
import com.app.exterms.personal.server.service.dao.Psnl0126DAO;
import com.app.exterms.personal.server.vo.Psnl0126VO;
import com.app.exterms.personal.shared.PsnlDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

@Service("PsnlP029002Service")
public class PsnlP029002ServiceImpl extends AbstractCustomServiceImpl  implements PsnlP029002Service, PsnlDaoConstants, ServletContextAware, ServletConfigAware  {  

	private static final Logger logger = LoggerFactory.getLogger(PsnlP029002ServiceImpl.class);
	private static final String calledClass = PsnlP029002ServiceImpl.class.getName();

	@Autowired
	@Resource(name="psnl0126DAO")
	private Psnl0126DAO psnl0126DAO;

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

	/** 휴가일수 리스트를 읽어들인다 **/
	@SuppressWarnings("unused")
	@Override
	public List<HashMap<String, String>> getPsnlP029002ExcelData(String fileFullPath)throws MSFException {

		String windowNm = "엑셀일괄업로드";
		String windowId = "PsnlP029002";

		String method = calledClass + ".getPsnlP029002ExcelData";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());

		//이미지 저장정보를 가지고 온다.
		HashMap<String, String> globals = MSFServerUtils.getLocalidedMessages(RemoteServiceUtil.getThreadLocalConfig(), RemoteServiceUtil.getThreadLocalRequest()); 


		Psnl0126VO psnl0126Vo;

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		List<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
		List<HashMap<String,String>> dataList = new ArrayList<HashMap<String, String>>();
		List<HashMap<String,String>> returnDataList = new ArrayList<HashMap<String, String>>();
		List egovResultDataList = new ArrayList();
		File file = null;

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

			file = new File(fileFullPath);

			/** 파일이 생성 될때까지 돌다가 생성되면  break 걸고 다음 진행
			 *   inFile : 지정된 파일이 정상인지 여부를 테스트 함
			 *   exists : 경로에 의해 지정된 파일 또는 디렉터리가 존재하는지 여부를 테스트 함
			 */			
//			while(true){ 				
//				if(file.isFile() && file.exists()||"".equals(file.getAbsolutePath())){
//					break;
//				}
//				System.out.println("길이 : "+file.length());	
//				System.out.println("존재여부 : "+file.exists());
//				System.out.println("정상여부 : "+file.isFile());
////				file.deleteOnExit();
//				file.delete();
//			}
			
			FileInputStream fis = null; 
			boolean delChk  = false;

			try{

				psnl0126Vo = new Psnl0126VO();
				psnl0126Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
				System.out.println("파일 : " + fileFullPath);
				System.out.println("길이 : "+file.length());	
				
				/** 파일 경로에 파일이 정상인지 여부를 확인하고 존재하는지 확인한다*/
				if(file.isFile() && file.exists()){
					fis = new FileInputStream(file);
					/** fls에 파일이 존재할때 진행*/
					if(fis != null){
						Workbook wb = WorkbookFactory.create(fis);

						Sheet sheet = wb.getSheetAt(0);
						Iterator<Row> rowIterator = sheet.iterator();
						int iRow = 0;

						Row row = rowIterator.next();
						row = rowIterator.next();
						row = rowIterator.next();
						row = rowIterator.next();

						while(rowIterator.hasNext()){

							row = rowIterator.next();

							iRow = iRow + 1;

							Iterator<Cell> cellIterator = row.cellIterator();
							HashMap<String, String> map = new HashMap<String, String>();

							while(cellIterator.hasNext()){

								Cell cell = cellIterator.next();

								switch(cell.getColumnIndex()){
								case 0: // 적용년도
									map.put("hodyApptnYr", String.valueOf(cell.getStringCellValue()));
									psnl0126Vo.setHodyApptnYr(MSFSharedUtils.allowNulls(cell.getStringCellValue()));
									break;

								case 1: // 소속부서명
									map.put("currAffnDeptNm", String.valueOf(cell.getStringCellValue()));
									//							psnl0126Vo.setDeptCd(String.valueOf(cell.getStringCellValue()));
									break;

								case 2: //성명
									map.put("hanNm", cell.getStringCellValue());
									psnl0126Vo.setHanNm(cell.getStringCellValue());
									break;

								case 3: // 주민등록구분
									map.put("resnRegnGbn", MSFSharedUtils.allowNulls(cell.getStringCellValue()));
									psnl0126Vo.setResnRegnGbn(MSFSharedUtils.allowNulls(cell.getStringCellValue()));
									break;

								case 4: // 주민등록번호
									map.put("resnRegnNum", MSFSharedUtils.allowNulls(cell.getStringCellValue()));							
									if("Y".equals(String.valueOf(map.get("resnRegnGbn"))) || "Y"== String.valueOf(map.get("resnRegnGbn"))) {
										psnl0126Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(cell.getStringCellValue()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
									}else {
										psnl0126Vo.setResnRegnNum( MSFSharedUtils.allowNulls(cell.getStringCellValue()));
									}
									break;

								case 5: // 기본휴가일수
									map.put("hodyApptnNumDys",  String.valueOf(cell.getNumericCellValue()));
									psnl0126Vo.setHodyApptnNumDys(MSFSharedUtils.defaultNulls(String.valueOf(cell.getNumericCellValue()),"0"));
									break;

								case 6: // 특별휴가일수
									map.put("spclHodyNumDys", String.valueOf(cell.getNumericCellValue()));
									//							psnl0126Vo.setSpclHodyNumDys(MSFSharedUtils.defaultNulls(String.valueOf(cell.getNumericCellValue()),"0"));
									break;

								case 7: // 기본휴가사용일수
									map.put("hodyUseNumDys",String.valueOf(cell.getNumericCellValue()));
									//							psnl0126Vo.setHodyUseNumDys(MSFSharedUtils.defaultNulls(String.valueOf(cell.getNumericCellValue()),"0"));
									break;

								case 8: // 특별휴가사용일수
									map.put("spclHodyUseDys",String.valueOf(cell.getNumericCellValue()));
									//							psnl0126Vo.setSpclHodyUseDys(MSFSharedUtils.defaultNulls(String.valueOf(cell.getNumericCellValue()),"0"));
									break;

								case 9: // 잔여일수
									map.put("hodyRstNumDys",String.valueOf(cell.getNumericCellValue()));
									//							psnl0126Vo.setHodyRstNumDys(MSFSharedUtils.defaultNulls(String.valueOf(cell.getNumericCellValue()),"0"));
									break;

								case 10: // 비고내용
									map.put("hodyNoteCtnt",  MSFSharedUtils.allowNulls(cell.getStringCellValue()));
									break;

								}
							}

							try {

								// 3.복호화 리턴받을 값 선언
								String rrnDecCrypt = "";

								egovResultDataList = psnl0126DAO.selectPsnl0126ToPsnlP029002ExlDataListChk(psnl0126Vo);

								if(egovResultDataList != null && egovResultDataList.size() > 0){
									for(int i = 0 ; i < egovResultDataList.size(); i++){
										Psnl0126DTO dto = new Psnl0126DTO();
										Map tempMap = (Map)egovResultDataList.get(i);
										Iterator<String> keys = tempMap.keySet().iterator();

										while( keys.hasNext() ){
											String key = keys.next();

											if("resnRegnNum".equals(key)) {
												// 3.복호화
												rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(tempMap.get("resnRegnNum")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);
												map.put(key, rrnDecCrypt);
												//									            	map.put(key,  String.valueOf(tempMap.get(key)));
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

							//					map.put("filaPath", file.getPath());

							list.add(map);							
							//					dataList.add(map);
						}
					}	
				}

				try {
					if(fis != null){
						fis.close();

					}
					delChk = file.delete();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("삭제여부 		: " + delChk);

			}catch (Exception e) {

				try {
					if(fis != null){
						fis.close();

					}
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

	@Override
	public Long updateXlsPsnl0126ToP029002(List<PsnlP029002DTO> insertPsnl0290026List) throws MSFException {

		Long result = new Long(0);
		Long iCnt = new Long(0);

		int monthS = 1;
		int monthE = 12;
		int maxDays = 0;

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());

		if  (MSFSharedUtils.paramNull(psnl0126DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			psnl0126DAO = (Psnl0126DAO) wac.getBean("psnl0126DAO" ); 
		}


		try {  

			for(int iPsnlCnt=0;iPsnlCnt < insertPsnl0290026List.size();iPsnlCnt++) {

				// 1. 암호화 객체 생성
				String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

				PsnlP029002DTO psnl029002Dto = new PsnlP029002DTO();
				Psnl0126VO psnl0126Vo = new Psnl0126VO();  
				psnl029002Dto = insertPsnl0290026List.get(iPsnlCnt);

				psnl0126Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));  		/** column 사업장코드 : dpobCd */
				psnl0126Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(psnl029002Dto.getResnRegnNum().replaceAll("-","")),AnyCryptUtils.SEC_RRNUMC));	

				psnl0126Vo.setSystemkey(MSFSharedUtils.allowNulls(psnl029002Dto.getSystemkey()));	/** column SYSTEMKEY : systemkey */
				psnl0126Vo.setHodyApptnYr(psnl029002Dto.getHodyApptnYr());							/** 휴가적용년도 HODY_APPTN_YR */
				psnl0126Vo.setLvsgCoptnCstApptnYn(psnl029002Dto.getLvsgCoptnCstApptnYn());			/** 연가보상비적용여부 LVSG_COPTN_CST_APPTN_YN */

				Calendar  intiCal =  Calendar.getInstance();
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
				if("Y".equals(psnl029002Dto.getLvsgCoptnCstApptnYn())) {
					psnl0126Vo.setLvsgCoptnCstApptnDt(format.format(intiCal.getTime()));
				}else {
					psnl0126Vo.setLvsgCoptnCstApptnDt("");
				}

				psnl0126Vo.setHodyNumDysSysCalc(MSFSharedUtils.defaultNulls(psnl029002Dto.getHodyNumDysSysCalc(), "0"));	/** 휴가일수_시스템 계산 HODY_NUM_DYS_SYS_CALC */
				psnl0126Vo.setHodyApptnNumDys(MSFSharedUtils.defaultNulls(psnl029002Dto.getHodyApptnNumDys(), "0"));		/** 휴가적용일수 HODY_APPTN_NUM_DYS */
				psnl0126Vo.setSpclHodyNumDys(MSFSharedUtils.defaultNulls(psnl029002Dto.getSpclHodyNumDys(), "0"));			/** 특별휴가일수  spclHodyNumDys */
				psnl0126Vo.setSpclHodyUseDys(MSFSharedUtils.defaultNulls(psnl029002Dto.getSpclHodyUseDys(), "0"));			/** 특별휴가사용일수 SPCL_HODY_USE_DYS */
				psnl0126Vo.setHodyUseNumDys(MSFSharedUtils.defaultNulls(psnl029002Dto.getHodyUseNumDys(), "0"));			/** 휴가사용일수 HODY_USE_NUM_DYS */
				psnl0126Vo.setHodyRstNumDys(MSFSharedUtils.defaultNulls(psnl029002Dto.getHodyRstNumDys(), "0"));			/** 휴가잔여일수 HODY_RST_NUM_DYS */
				psnl0126Vo.setHodyNoteCtnt(psnl029002Dto.getHodyNoteCtnt()); 												/** 휴가비고내용 HODY_NOTE_CTNT */
				psnl0126Vo.setKybdr(sessionUser.getUsrId());		/** column 입력자 : kybdr */
				psnl0126Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	/** column 입력주소 : inptAddr */
				psnl0126Vo.setIsmt(sessionUser.getUsrId());    		/** column 수정자 : ismt */
				psnl0126Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */  


				//TODO 휴가확정여부는 일단 N로 insert 후 화면에서 확정하게끔...
				psnl0126Vo.setHodyFixYn("N");		/** 휴가확정여부 HODY_FIX_YN */ 
				psnl0126Vo.setHodyFixDt("");		/** 휴가확정일자 HODY_FIX_DT */ 
				//=========휴가 시작일자 계산하여 mapping========		

				if(psnl029002Dto.getHodyApptnYr() == null || psnl029002Dto.getHodyApptnYr().equals("")) {
					psnl0126Vo.setHodyBgnnDt("");	/** 휴가시작일자 HODY_BGNN_DT */
					psnl0126Vo.setHodyEndDt("");	/** 휴가종료일자 HODY_BGNN_DT */
				}else {
					intiCal =  Calendar.getInstance();
					format = new SimpleDateFormat("yyyyMMdd");
					intiCal.set(Integer.parseInt(psnl029002Dto.getHodyApptnYr()), monthS -1, 1);
					psnl0126Vo.setHodyBgnnDt(format.format(intiCal.getTime()));	/** 휴가시작일자 HODY_BGNN_DT */

					maxDays = intiCal.getActualMaximum (intiCal.DAY_OF_MONTH); 

					intiCal =   Calendar.getInstance();
					intiCal.set(Integer.parseInt(psnl029002Dto.getHodyApptnYr()), monthE - 1, maxDays); 
					psnl0126Vo.setHodyEndDt(format.format(intiCal.getTime()));	/** 휴가종료일자 HODY_BGNN_DT */
					//=========휴가 시작일자 계산하여 mapping========	
				}

				psnl0126DAO.deleteXlsPsnlP029002(psnl0126Vo);
				psnl0126DAO.insertXlsPsnlP029002(psnl0126Vo); 

				iCnt = iCnt + 1;

			} 
			result = new Long(1);

		} catch (Exception ex) {

			logger.error("EXCEPTION calling updateXlsPsnl0290(): "+ex); 

			result = new Long(0);
			throw MSFServerUtils.getOperationException("updateXlsPsnl0290", ex, logger);
		}
		finally {

		}
		return iCnt;
	}


}	