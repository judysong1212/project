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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

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

import com.app.exterms.payroll.client.dto.Payr0307DTO_XLS;
import com.app.exterms.payroll.client.service.PayrP420002Service;
import com.app.exterms.payroll.server.service.dao.Payr0302DAO;
import com.app.exterms.payroll.server.service.dao.Payr0304DAO;
import com.app.exterms.payroll.server.service.dao.Payr0307DAO;
import com.app.exterms.payroll.server.vo.Payr0302VO;
import com.app.exterms.payroll.server.vo.Payr0307SrhVO;
import com.app.exterms.payroll.server.vo.Payr0307VO;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0302VO;
import com.app.smrmf.pkg.listener.PayrListenerAdapter;
import com.app.smrmf.props.ExtermsProps;

@Service("PayrP420002Service")
public class PayrP420002ServiceImpl extends AbstractCustomServiceImpl implements PayrP420002Service, PayrDaoConstants {  
	 
	private static final Logger logger = LoggerFactory.getLogger(PayrP420002ServiceImpl.class);
	private static final String calledClass = PayrP420002ServiceImpl.class.getName();
		 

	// 급여대상자 가져오기
	@Autowired
	@Resource(name = "Payr0304DAO")
	private Payr0304DAO payr0304DAO;

	// 급여 수당공제이력정보
	@Autowired
	@Resource(name = "Payr0302DAO")
	private Payr0302DAO payr0302DAO;

	// 급여조정내역
	@Autowired
	@Resource(name = "Payr0307DAO")
	private Payr0307DAO payr0307DAO;
		
	
	/** 급여 일괄 조정 내역 리스트를 읽어들인다. **/
	@Override
	public List<HashMap<String, String>> getPayrP420002ExcelData(String fileFullPath)throws MSFException {
		// TODO Auto-generated method stub
		//ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		//InputStream input = classLoader.getResourceAsStream(fileFullPath);
		
		String windowNm = "급여(조정)내역관리";
		String windowId = "PAYRP420002";
		
		String method = calledClass + ".getPayrP420002ExcelData";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		//이미지 저장정보를 가지고 온다.
		HashMap<String, String> globals = MSFServerUtils.getLocalidedMessages(RemoteServiceUtil.getThreadLocalConfig(), RemoteServiceUtil.getThreadLocalRequest()); 
		

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		List<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
		boolean delChk  = false;
		
		if(fileFullPath != null && !"".equals(fileFullPath)){
			
//			String UPLOAD_DIRECTORY =  globals.get("PayGen.fileStorePath");  
//			fileFullPath = UPLOAD_DIRECTORY + "\\" + fileFullPath;
			
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
			FileInputStream fis = null;
			
			
			try{
				
				fis = new FileInputStream(fileFullPath);
				Workbook w = WorkbookFactory.create(fis);
				
				Sheet sheet = w.getSheetAt(0);
				
				Iterator<Row> rowIterator = sheet.iterator();
				int iRow = 0;
				
				Row row = rowIterator.next();
				row = rowIterator.next();
				row = rowIterator.next();
				
				while(rowIterator.hasNext()){
					
					
					row = rowIterator.next();
					
					iRow = iRow + 1;
					
					Iterator<Cell> cellIterator = row.cellIterator();
//					rowCnt++;
					HashMap<String, String> map = new HashMap<String, String>();
					
						
						while(cellIterator.hasNext()){
							
							Cell cell = cellIterator.next();
							map.put("rnum", iRow+"");
							
							switch(cell.getColumnIndex()){
							case 0: // 지급년월
								map.put("pymtYrMnth", cell.getStringCellValue());
								break;
								
							case 1: // 성 명
//								map.put("bgnnDt", new SimpleDateFormat("yyyy-MM-dd").format(cell.getDateCellValue()));
								break;
								
							case 2: //주민등록번호
//								Payr0307BM returnPayr0307 = new Payr0307BM();
								
								
								List egovResultDataList = new ArrayList();
								
								
								// 입력된 주민등록번호를 가지고 성명, 시스템키, 부서, 직종, 직종세, 사업을 가져온다.
								Payr0307SrhVO payr0307SrhVo = new Payr0307SrhVO();
								
								// 2. 파라미터 보낼 때(암호화)
								payr0307SrhVo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult, String.valueOf(MSFSharedUtils.allowNulls(cell.getStringCellValue())).replaceAll("-",""), AnyCryptUtils.SEC_RRNUMC));	//주민번호
//								payr0307SrhVo.setResnRegnNum( String.valueOf(MSFSharedUtils.allowNulls(cell.getStringCellValue())) );
								

								try {
									
									// 2.복호화 리턴받을 값 선언
									String rrnDecCrypt = "";
									
									egovResultDataList =  payr0307DAO.selectPayrP420002ToPsnl0100(payr0307SrhVo);

									if(egovResultDataList != null && egovResultDataList.size() > 0){
										for(int i = 0 ; i < egovResultDataList.size(); i++){
											
											Map tempMap = (Map)egovResultDataList.get(i);
											Iterator<String> keys = tempMap.keySet().iterator();
											while( keys.hasNext() ){
									            String key = keys.next();
									            //형 타입이 숫자형일경우 형변환 해준다.
								            	if(tempMap.get(key) instanceof java.math.BigDecimal){
//								            		returnPayr0307.set(key, String.valueOf(tempMap.get(key)));
								            		map.put(key, String.valueOf(tempMap.get(key)));
								            	}else{
//								            		returnPayr0307.set(key, tempMap.get(key));
								            		
								            		if("resnRegnNum".equals(key)) {
								            			// 2.복호화
								            			rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(tempMap.get("resnRegnNum")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);
										        		map.put(key, rrnDecCrypt);
								            			
								            		}else {
								            			map.put(key, String.valueOf(tempMap.get(key)));
								            		}
								            		
								            		
								            	}
								        		
								            }
										}
									}
								} catch (Exception ex) {
									ex.printStackTrace();
									
									/** 에러 로그 **/			
									MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",ex, windowNm , windowId);
									// Return operation exception
								}
								
								
								if(map.get("systemkey") == null || "".equals(map.get("systemkey"))) {
									map.put("dataChk", "X");
								}else {
									map.put("dataChk", "O");
								}
								
//								map.put("endDt", new SimpleDateFormat("yyyy-MM-dd").format(cell.getDateCellValue()));
								break;
								
							case 3: // 급여구분
								map.put("payCdNm", String.valueOf(cell.getStringCellValue()));
								break;
								
							case 4: // 급여구분코드
								map.put("payCd", cell.getStringCellValue());
								break;
								
							case 5: // 지급공제구분
								map.put("pymtDducDivCdNm", cell.getStringCellValue());
								break;
								
							case 6: // 지급공제구분코드
								map.put("pymtDducDivCd", cell.getStringCellValue());
								break;

							case 7: // 급여항목명
								map.put("payItemCdNm", cell.getStringCellValue());
								break;
								
							case 8: // 급여항목명코드
								map.put("payItemCd", cell.getStringCellValue());
								break;
								
							case 9: // 비과세금액
								map.put("pymtDducFreeDtySum",  String.valueOf(cell.getNumericCellValue()));
								break;
								
							case 10: // 금액
								map.put("pymtDducSum",  String.valueOf(cell.getNumericCellValue()));
								break;	
								
							case 11: // 과세금액
								map.put("pymtDducTxtnAmnt",  String.valueOf(cell.getNumericCellValue()));
								break;
								
							case 12: // 소득세
								map.put("mnthPayAdmntYn", cell.getStringCellValue());
								break;	
								
							case 13: // 조정사유
								map.put("mnthPayAdmntAssoBssCtnt", cell.getStringCellValue());
								break;	
							}
						}
						
						list.add(map);
						
					}
				
				
				try {
					
					
				} finally {
					fis.close();
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
	
	
	//급여지급대상자 업로드
	@Override
	public List<Payr0307DTO_XLS> updateXlsPayr0307ToP420002(List<Payr0307DTO_XLS> insertPayr0307List)throws MSFException {
		
		// TODO Auto-generated method stub
		Long result = new Long(1);
		
		List<Payr0307DTO_XLS> resultList = new ArrayList<Payr0307DTO_XLS>();
		
		Long iCnt = new Long(0);
		
        BigDecimal tpExtpyTotAmnt = BigDecimal.ZERO;		// 현수당금
        BigDecimal tpTxtnTotAmnt = BigDecimal.ZERO; 		// 과세금액  
        BigDecimal tpFreeDtyTotAmnt = BigDecimal.ZERO; 		// 비과세금액 
        BigDecimal freeDtySum = BigDecimal.ZERO;   			// 비과세 적용금액  
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
		// 1. 암호화 객체 생성
//		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
		try {  
			
			for(int iPayrCnt=0;iPayrCnt < insertPayr0307List.size();iPayrCnt++) {
				
				// 1. 암호화 객체 생성
				String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
				
				tpExtpyTotAmnt = BigDecimal.ZERO;			// 현수당금
                tpTxtnTotAmnt = BigDecimal.ZERO; 			// 과세금액  
                tpFreeDtyTotAmnt = BigDecimal.ZERO; 		// 비과세금액 
                freeDtySum = BigDecimal.ZERO;   			// 비과세 적용금액  
                String Payr4200DducCheck = "";  			//소득세주민세 여부 판단  
                Payr0307DTO_XLS payr0307Dto = new Payr0307DTO_XLS();  
				
				Payr0307VO payr0307Vo = new Payr0307VO();  
				Payr0307VO  tpPayr0307Vo = new Payr0307VO();
//				payr0307Vo = insertPayr0307List.get(iPayrCnt);
				payr0307Dto = insertPayr0307List.get(iPayrCnt);
				
				/**========================== 해당하는 조정내역 삭제 후 인서트 처리 : PAYR0307 ========================== */
				payr0307Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));													/** set 사업장코드 : dpobCd */
				
				// 2. 파라미터 보낼 때(암호화)
				payr0307Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult, String.valueOf(MSFSharedUtils.allowNulls(payr0307Dto.getResnRegnNum())).replaceAll("-",""), AnyCryptUtils.SEC_RRNUMC));	//주민번호
//				payr0307Vo.setResnRegnNum(MSFSharedUtils.allowNulls(payr0307Dto.getResnRegnNum()));											/** set 주민등록번호 : resnRegnNum */
				
				payr0307Vo.setPymtYrMnth(MSFSharedUtils.allowNulls(payr0307Dto.getPymtYrMnth()));											/** set 지급년월 : pymtYrMnth */
			    payr0307Vo.setPayCd(MSFSharedUtils.allowNulls(payr0307Dto.getPayCd()));														/** set 급여구분코드 : payCd */
			    payr0307Vo.setPayrSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Dto.getPayrSeilNum(), "0")));					/** set 급여일련번호 : payrSeilNum */
			    payr0307Vo.setSystemkey(MSFSharedUtils.allowNulls(payr0307Dto.getSystemkey()));												/** set SYSTEMKEY : systemkey */
			    payr0307Vo.setMnthPayAdmntSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Dto.getMnthPayAdmntSeilNum(), "0")));	/** set 월급여조정일련번호 : mnthPayAdmntSeilNum */
			    payr0307Vo.setPayItemCd(MSFSharedUtils.allowNulls(payr0307Dto.getPayItemCd()));												/** set 급여항목코드 : payItemCd */
			    payr0307Vo.setPymtDducDivCd(MSFSharedUtils.allowNulls(payr0307Dto.getPymtDducDivCd())); 									/** set 지급공제구분코드 : pymtDducDivCd */
			    payr0307Vo.setPymtDducSum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Dto.getPymtDducSum(), "0")));					/** set 지급공제금액 : pymtDducSum */
			    payr0307Vo.setPymtDducFreeDtySum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Dto.getPymtDducFreeDtySum(), "0")));	/** set 지급공제비과세금액 : pymtDducFreeDtySum */
			    payr0307Vo.setMnthPayAdmntAssoBssCtnt(MSFSharedUtils.allowNulls(payr0307Dto.getMnthPayAdmntAssoBssCtnt()));					/** set 월급여조정관련근거내용 : mnthPayAdmntAssoBssCtnt */
			    payr0307Vo.setMnthPayAdmntYn(MSFSharedUtils.allowNulls(payr0307Dto.getMnthPayAdmntYn()));									/** set 월급여소급조정여부 : mnthPayAdmntYn */
//			    payr0307Vo.setPymtDducTxtnAmnt(new BigDecimal(MSFSharedUtils.allowNulls(MSFSharedUtils.defaultNulls(payr0307Vo.getPymtDducTxtnAmnt(), "0"))));/** set 지급공제과세금액 : pymtDducTxtnAmnt */
			    
			    
			    
                //소득세제외 여부 추가 처리을 위해 조건추가 함 
                if (Boolean.TRUE.equals(payr0307Dto.getMnthPayAdmntYn())) {
                	 payr0307Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column null : pymtDducTxtnAmnt */
                } else {
			    
	                if ("B0080010".equals(payr0307Vo.getPymtDducDivCd())) {
	                    
	                    if (new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Vo.getPymtDducTxtnAmnt(),"0")).compareTo(BigDecimal.ZERO) == 0) {
	                      
	                        if (new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Vo.getPymtDducFreeDtySum(),"0")).compareTo(BigDecimal.ZERO) != 0) {
	                            
	                            payr0307Vo.setPymtDducTxtnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Vo.getPymtDducSum(),"0")).subtract(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Vo.getPymtDducFreeDtySum(),"0"))));    /** column null : pymtDducTxtnAmnt */ 
	                        
	                        } else {
	                            
	                            payr0307Vo.setPymtDducTxtnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Vo.getPymtDducSum(),"0")));    /** column null : pymtDducTxtnAmnt */ 
	                             
	                        }
	                    } else {
	                        
	                        if (new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Vo.getPymtDducFreeDtySum(),"0")).compareTo(BigDecimal.ZERO) != 0) {
	                            
	                            payr0307Vo.setPymtDducTxtnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Vo.getPymtDducSum(),"0")).subtract(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Vo.getPymtDducFreeDtySum(),"0"))));    /** column null : pymtDducTxtnAmnt */ 
	                        
	                        } else {
	                            
	                            payr0307Vo.setPymtDducTxtnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Vo.getPymtDducSum(),"0")));    /** column null : pymtDducTxtnAmnt */ 
	                             
	                        }
	                    }
	                   
	                
	                } else  if ("B0080020".equals(payr0307Vo.getPymtDducDivCd())) {
	                
	                    if (new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Vo.getPymtDducTxtnAmnt(),"0")).compareTo(BigDecimal.ZERO) == 0) {
	                        
	                        if (new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Vo.getPymtDducFreeDtySum(),"0")).compareTo(BigDecimal.ZERO) != 0) {
	                            
	                            payr0307Vo.setPymtDducTxtnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Vo.getPymtDducSum(),"0")).subtract(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Vo.getPymtDducFreeDtySum(),"0"))));    /** column null : pymtDducTxtnAmnt */ 
	                        
	                        } else {
	                            
	                            payr0307Vo.setPymtDducTxtnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Vo.getPymtDducSum(),"0")));    /** column null : pymtDducTxtnAmnt */ 
	                             
	                        }
	                    } else {
	                        
	                        if (new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Vo.getPymtDducFreeDtySum(),"0")).compareTo(BigDecimal.ZERO) != 0) {
	                            
	                            payr0307Vo.setPymtDducTxtnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Vo.getPymtDducSum(),"0")).subtract(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Vo.getPymtDducFreeDtySum(),"0"))));    /** column null : pymtDducTxtnAmnt */ 
	                        
	                        } else {
	                            
	                            payr0307Vo.setPymtDducTxtnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Vo.getPymtDducSum(),"0")));    /** column null : pymtDducTxtnAmnt */ 
	                             
	                        }
	                    }
	                    
	                }  else {
	                    
	                    payr0307Vo.setPymtDducTxtnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Vo.getPymtDducTxtnAmnt(),"0")));    /** column null : pymtDducTxtnAmnt */
	                } 
                
                }
			    
			    
                payr0307Vo.setMnthPayAdmntAssoBssCtnt(payr0307Dto.getMnthPayAdmntAssoBssCtnt());    /** column 월급여조정관련근거내용 : mnthPayAdmntAssoBssCtnt */
                
               /**
                * mnthPayAdmntYn ->  PAY_PYMT_DDUC_PRCS_FLAG 소득세제외여부로 변경 연동 PAYR0302 
                *  Y  :  소득세제외
                *  N  : 소득세처리  
                */ 
                payr0307Vo.setMnthPayAdmntYn((Boolean.TRUE.equals(payr0307Dto.getMnthPayAdmntYn()) ? "Y" : "N"));    /** column 소득세제외여부  : mnthPayAdmntYn */
              
                
                
                
                /** 소득세/지방소득세 입력시 처리 루틴 추가 */
                if (ExtermsProps.getProps("PAY_DDUC_T00101").equals(payr0307Vo.getPayItemCd())) {
                	Payr4200DducCheck = ExtermsProps.getProps("PAY_DDUC_T00101");
                } else   if (ExtermsProps.getProps("PAY_DDUC_T00201").equals(payr0307Vo.getPayItemCd())) {
                	Payr4200DducCheck = ExtermsProps.getProps("PAY_DDUC_T00101");
                } else {
                	
                } 
                
                
                String strInsertResult = "";
                
                if(!"".equals(payr0307Dto.getSystemkey()) && payr0307Dto.getSystemkey() != null) {
                	int iDeleteResult = payr0307DAO.deleteXlsPayr0307(payr0307Vo);
                	strInsertResult = payr0307DAO.insertXlsPayr0307(payr0307Vo);
                }
                
                
                // 리스트 리턴하기 위해서 데이터를 다시 담아준다.
            	payr0307Dto = new Payr0307DTO_XLS();
            	payr0307Dto = insertPayr0307List.get(iPayrCnt);
            	
            	payr0307Dto.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));													/** set 사업장코드 : dpobCd */
            	payr0307Dto.setResnRegnNum(MSFSharedUtils.allowNulls(payr0307Dto.getResnRegnNum()));										/** set 주민등록번호 : resnRegnNum */
				payr0307Dto.setPymtYrMnth(MSFSharedUtils.allowNulls(payr0307Dto.getPymtYrMnth()));											/** set 지급년월 : pymtYrMnth */
				payr0307Dto.setPayCd(MSFSharedUtils.allowNulls(payr0307Dto.getPayCd()));													/** set 급여구분코드 : payCd */
//				payr0307Dto.setPayrSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Dto.getPayrSeilNum(), "0")));					/** set 급여일련번호 : payrSeilNum */
				payr0307Dto.setSystemkey(MSFSharedUtils.allowNulls(payr0307Dto.getSystemkey()));												/** set SYSTEMKEY : systemkey */
//			    payr0307Dto.setMnthPayAdmntSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0307Dto.getMnthPayAdmntSeilNum(), "0")));	/** set 월급여조정일련번호 : mnthPayAdmntSeilNum */
			    payr0307Dto.setPayItemCd(MSFSharedUtils.allowNulls(payr0307Dto.getPayItemCd()));											/** set 급여항목코드 : payItemCd */
			    payr0307Dto.setPymtDducDivCd(MSFSharedUtils.allowNulls(payr0307Dto.getPymtDducDivCd())); 									/** set 지급공제구분코드 : pymtDducDivCd */
			    payr0307Dto.setPymtDducSum(Double.valueOf((MSFSharedUtils.defaultNulls(payr0307Dto.getPymtDducSum(), "0"))) );				/** set 지급공제금액 : pymtDducSum */
			    payr0307Dto.setPymtDducFreeDtySum(Double.valueOf(MSFSharedUtils.defaultNulls(payr0307Dto.getPymtDducFreeDtySum(), "0")));	/** set 지급공제비과세금액 : pymtDducFreeDtySum */
			    payr0307Dto.setMnthPayAdmntAssoBssCtnt(MSFSharedUtils.allowNulls(payr0307Dto.getMnthPayAdmntAssoBssCtnt()));				/** set 월급여조정관련근거내용 : mnthPayAdmntAssoBssCtnt */
			    payr0307Dto.setMnthPayAdmntYn(MSFSharedUtils.allowNulls(payr0307Dto.getMnthPayAdmntYn()));									/** set 월급여소급조정여부 : mnthPayAdmntYn */
			    
                
//                System.out.println("결과값 : " + strInsertResult);
                if("".equals(strInsertResult) ||strInsertResult==null) {
                	payr0307Dto.setDataChk(payr0307Dto.getDataChk());
                	
                	resultList.add(payr0307Dto);
                }else {
                	
                	// 대상자가 있을 경우만 실행한다.
                	payr0307Dto.setDataChk("V");
                	
                	resultList.add(payr0307Dto);
                	
                	
				    /**========================== 해당하는 조정내역 삭제 후 인서트 처리 : PAYR0307 ========================== */
	                
				    Payr0302VO  payr0302Vo = new Payr0302VO(); 
				    //tpPayr0307Vo = payr0307DAO.selectPayr0307Max(payr0307Vo); 
				    tpPayr0307Vo = payr0307DAO.selectPayr0307Max_2(payr0307Vo);			    
				    /**==========================해당하는 수당공제항목 삭제 후 인서트 처리 : PAYR0302 ==========================*/
	                if  (MSFSharedUtils.paramNotNull(tpPayr0307Vo) && MSFSharedUtils.paramNotNull(tpPayr0307Vo.getSystemkey())) {
	                    payr0302Vo.setDpobCd(MSFSharedUtils.allowNulls(tpPayr0307Vo.getDpobCd()));    												/** column 사업장코드 : dpobCd */
	                    payr0302Vo.setPymtYrMnth(MSFSharedUtils.allowNulls(tpPayr0307Vo.getPymtYrMnth()));											/** column 지급년월 : pymtYrMnth */
	                    payr0302Vo.setPayCd(MSFSharedUtils.allowNulls(tpPayr0307Vo.getPayCd()));    												/** column 급여구분코드 : payCd */
	                    payr0302Vo.setPayrSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(tpPayr0307Vo.getPayrSeilNum(),"0")));    				/** column 급여일련번호 : payrSeilNum */
	                    payr0302Vo.setSystemkey(MSFSharedUtils.allowNulls(tpPayr0307Vo.getSystemkey()));    										/** column SYSTEMKEY : systemkey */
	                    payr0302Vo.setPayItemCd(MSFSharedUtils.allowNulls(tpPayr0307Vo.getPayItemCd()));    										/** column 급여항목코드 : payItemCd */
	                    payr0302Vo.setPayItemSeilNum(new BigDecimal("0"));																			/** column 급여항목일련번호 : payItemSeilNum */
	                    payr0302Vo.setPymtDducDivCd(MSFSharedUtils.allowNulls(tpPayr0307Vo.getPymtDducDivCd()));    								/** column 지급공제구분코드 : pymtDducDivCd */
	                    payr0302Vo.setPymtDducFreeDtySum(new BigDecimal(MSFSharedUtils.defaultNulls(tpPayr0307Vo.getPymtDducFreeDtySum(),"0")));	/** column 지급공제비과세금액 : pymtDducFreeDtySum */
	                    payr0302Vo.setPymtDducSum(new BigDecimal(MSFSharedUtils.defaultNulls(tpPayr0307Vo.getPymtDducSum(),"0")));    				/** column 지급공제금액 : pymtDducSum */
	                    payr0302Vo.setPayPymtDducPrcsFlag("N");																						/** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
	                    payr0302Vo.setPayReattyAdmntVal(String.valueOf(tpPayr0307Vo.getMnthPayAdmntSeilNum()));    									/** column 급여지급공제소급조정값 : payReattyAdmntVal */
	                    payr0302Vo.setPymtDducTxtnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(tpPayr0307Vo.getPymtDducTxtnAmnt(),"0")));    	/** column 지급공제과세금액 : pymtDducTxtnAmnt */
	                    payr0302Vo.setKybdr(sessionUser.getUsrId());																				/** column 입력자 : kybdr */
	                    payr0302Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());											/** column 입력주소 : inptAddr */
	                    payr0302Vo.setIsmt(sessionUser.getUsrId());    																				/** column 수정자 : ismt */
	                    payr0302Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());											/** column 수정주소 : revnAddr */                
	                }
	                
	                
	                Payr0302VO  tpPayr0302Vo = new Payr0302VO();   
	                //tpPayr0302Vo = payr0302DAO.selectPayr0302Payr0307_2(payr0302Vo);
	                tpPayr0302Vo = payr0302DAO.selectPayr0302Payr0307(payr0302Vo); 
				    
				    //TODO 급여조정정보을 급여상세내역에 추가하고 급여 합계정보 업데이트한다.  
	                payr0302DAO.deletePayr0302Payr0307(payr0302Vo);
	                if  (MSFSharedUtils.paramNotNull(tpPayr0302Vo) && MSFSharedUtils.paramNotNull(tpPayr0302Vo.getSystemkey())) {
	                    payr0302DAO.updatePayr0302Payr0307(payr0302Vo);
	                } else {
	                    payr0302DAO.insertPayr0302(payr0302Vo);
	                } 
		                /**========================== 해당하는 수당공제항목 삭제 후 인서트 처리 : PAYR0302 ==========================*/ 
		                
		                
		                
		                /**========================== 급여 변동사항 반영 ==========================*/ 
		                InfcPkgPayr0302VO  calPayr0302Vo = new InfcPkgPayr0302VO(); 
					    
		                calPayr0302Vo.setDpobCd(payr0302Vo.getDpobCd());									/** column 사업장코드 : dpobCd */
		                calPayr0302Vo.setPymtYrMnth(payr0302Vo.getPymtYrMnth());    						/** column 지급년월 : pymtYrMnth */
		                calPayr0302Vo.setPayCd(payr0302Vo.getPayCd());    									/** column 급여구분코드 : payCd */
		                calPayr0302Vo.setPayrSeilNum(payr0302Vo.getPayrSeilNum());							/** column 급여일련번호 : payrSeilNum */
		                calPayr0302Vo.setSystemkey(payr0302Vo.getSystemkey());    							/** column SYSTEMKEY : systemkey */
		                calPayr0302Vo.setPayItemCd(payr0302Vo.getPayItemCd());    							/** column 급여항목코드 : payItemCd */
		                calPayr0302Vo.setPayItemSeilNum(payr0302Vo.getPayItemSeilNum());					/** column 급여항목일련번호 : payItemSeilNum */ 
		                calPayr0302Vo.setPymtDducDivCd(payr0302Vo.getPymtDducDivCd());    					/** column 지급공제구분코드 : pymtDducDivCd */
		                calPayr0302Vo.setPymtDducFreeDtySum(payr0302Vo.getPymtDducFreeDtySum());			/** column 지급공제비과세금액 : pymtDducFreeDtySum */
		                calPayr0302Vo.setPymtDducSum(payr0302Vo.getPymtDducSum());    						/** column 지급공제금액 : pymtDducSum */
		                calPayr0302Vo.setPayPymtDducPrcsFlag(payr0302Vo.getPayPymtDducPrcsFlag());			/** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
		                calPayr0302Vo.setPayReattyAdmntVal(payr0302Vo.getPayReattyAdmntVal());				/** column 급여지급공제소급조정값 : payReattyAdmntVal */
		                calPayr0302Vo.setKybdr(payr0302Vo.getKybdr());										/** column 입력자 : kybdr */
		                calPayr0302Vo.setInptDt(payr0302Vo.getInptDt());    								/** column 입력일자 : inptDt */
		                calPayr0302Vo.setInptAddr(payr0302Vo.getInptAddr());								/** column 입력주소 : inptAddr */
		                calPayr0302Vo.setIsmt(payr0302Vo.getIsmt());    									/** column 수정자 : ismt */
		                calPayr0302Vo.setRevnDt(payr0302Vo.getRevnDt());									/** column 수정일자 : revnDt */
		                calPayr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());								/** column 수정주소 : revnAddr */
		                calPayr0302Vo.setPymtDducTxtnAmnt(payr0302Vo.getPymtDducTxtnAmnt());    			/** column 지급공제과세금액 : pymtDducTxtnAmnt */
					    
		                
					    if (result > 0) {
					    	
					    	
					        /** 소득세/지방소득세 입력시 처리 루틴 추가 */
			                if (ExtermsProps.getProps("PAY_DDUC_T00101").equals(Payr4200DducCheck)) {
			                	calPayr0302Vo.setPayr4200DducCheck(Payr4200DducCheck); 
			                	
			                }  else {
			                	calPayr0302Vo.setPayr4200DducCheck("");
			                } 
					    	
		                    PayrListenerAdapter payrAdapter = new PayrListenerAdapter(); 
		                    
		                    //TODO RemoteServiceUtil.getThreadLocalRequest() 오류
		                    result = (long) payrAdapter.setPayr4200ToPayCalcSeft(RemoteServiceUtil.getThreadLocalRequest(), calPayr0302Vo);
		                }
					    /**========================== 급여 변동사항 반영 ==========================*/ 
	                }
			    
			    iCnt = iCnt + 1;
	                    
			} 
			
			
	          
		} catch (Exception ex) {
			logger.error("EXCEPTION calling updateXlsPayr0307ToP420002(): "+ex); 
	            
			result = new Long(0);
			throw MSFServerUtils.getOperationException("updateXlsPayr0307ToP420002", ex, logger);
		} finally {
	          
		}
		
//		result = iCnt;
		
		return resultList;
	}
	
	
	
}	