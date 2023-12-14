package org.msf.exterms.xls.service.impl;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.xls.imp.MsfExcelService;
import org.msf.exterms.xls.service.Psnl0290ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.personal.server.service.Psnl0290ServiceImpl;
import com.app.exterms.personal.server.service.dao.Psnl0126DAO;
import com.app.exterms.personal.server.vo.Psnl0126SrhVO;
import com.app.exterms.personal.server.vo.Psnl0126VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("psnl0290ExcelService")
public class Psnl0290ExcelServiceImpl extends AbstractServiceImpl implements Psnl0290ExcelService {
	
	private static final Logger logger = LoggerFactory.getLogger(Psnl0290ServiceImpl.class);
	private static final String calledClass = Psnl0290ExcelService.class.getName();
    
    @Autowired 
    @Resource(name="psnl0126DAO")
    private Psnl0126DAO psnl0126DAO;
    
    @Autowired 
    @Resource(name = "psnl0290ExcelUploadService")
    private MsfExcelService psnl0290ExcelUploadService;
    
    @Autowired 
    @Resource(name = "psnl0290XSSFExcelUploadService")
    private MsfExcelService psnl0290XSSFExcelUploadService;

//    
//  public List<Psnl0126VO> selectXlsPsnl0126List(Psnl0126SrhVO psnl0126SrhVO) throws Exception {
//      return psnl0126DAO.selectXlsPsnl0126List(psnl0126SrhVO);
//  } 
//  
    
    //엑셀파일 저장_jxls(양식)
	public List  selectXlsFilePsnl0126List(Psnl0126SrhVO psnl0126SrhVO) throws Exception {
		return psnl0126DAO.selectXlsTmpPsnl0126List(psnl0126SrhVO);
	}
	
    //엑셀파일 저장_jxls_export 
	public List  selectXlsExportPsnl0126List(Psnl0126SrhVO psnl0126SrhVO) throws Exception {
		return psnl0126DAO.selectXlsFilePsnl0126List(psnl0126SrhVO);
	}
	
	/**
	 *  엑셀파일을 등록한다.
	 * @param  
	 * @throws Exception
	 */
	//Xls
	public void updateXlsPsnl0126(InputStream file) throws Exception {
		psnl0290ExcelUploadService.uploadExcel("psnl0126DAO.deleteExcelPsnl0126_S", "psnl0126DAO.insertExcelPsnl0126_S", file, 3, (long) 0); 
		}
	//Xlxs
	 public void updateXlssPsnl0126(InputStream file) throws Exception {
		 psnl0290XSSFExcelUploadService.uploadXSSFExcel("psnl0126DAO.deleteExcelPsnl0126_S", "psnl0126DAO.insertExcelPsnl0126_S",file, 3, (long) 0);
	  }	  
//
//  /**
//   *  엑셀파일을 등록한다.
//   * @param  
//   * @throws Exception
//   */
//  public void insertXlsDlgn0100(InputStream file) throws Exception {
//     // dlgn0100DAO.insertXlsDlgn0100(); //삭제호출 후 파일데이터 인서트  
//	  psnl0290ExcelUploadService.uploadExcel("dlgn0100DAO.deleteXlsDlgn0100_S","dlgn0100DAO.insertXlsDlgn0100_S", file, 3, (long) 0);  
//  }
//  
//  
//  /**
//   *  엑셀파일을 등록한다.
//   * @param  
//   * @throws Exception
//   */
//  public void insertXlsDlgn0200(InputStream file) throws Exception {
//     // dlgn0100DAO.insertXlsDlgn0200(); //삭제호출 후 파일데이터 인서트  
//	  psnl0290ExcelUploadService.uploadExcel("dlgn0200DAO.deleteXlsDlgn0200_S","dlgn0200DAO.insertXlsDlgn0200_S", file, 3, (long) 0); 
//  }
//
//
//  /**
//   *  엑셀파일을 등록한다.
//   * @param  
//   * @throws Exception
//   */
//  public void insertXSSFDlgn0100(InputStream file) throws Exception {
//     // dlgn0100DAO.insertXlsDlgn0100(); //삭제호출 후 파일데이터 인서트  
//      dlgn0250XSSFExcelUploadService.uploadXSSFExcel("dlgn0100DAO.deleteXlsDlgn0100_S","dlgn0100DAO.insertXlsDlgn0100_S", file, 3, (long) 0);  
//  }
//  
//  /**
//   *  엑셀파일을 등록한다.
//   * @param  
//   * @throws Exception
//   */
//  public void insertXSSFDlgn0200(InputStream file) throws Exception {
//     // dlgn0100DAO.insertXlsDlgn0200(); //삭제호출 후 파일데이터 인서트  
//      dlgn0250XSSFExcelUploadService.uploadXSSFExcel("dlgn0200DAO.deleteXlsDlgn0200_S", "dlgn0200DAO.insertXlsDlgn0200_S", file, 3, (long) 0); 
//  }
//  
	 /**
	  *  엑셀파일을 등록한다._jxls
	  * @param  hMap
	  * @throws Exception
	  */

	@Override
	public Long updateXlsPsnl0290(List<Psnl0126VO> psnl0126List, HttpServletRequest request)throws MSFException {
		
		// TODO Auto-generated method stub
		Long result = new Long(0);
		Long iCnt = new Long(0);
		
		int monthS = 1;
		int monthE = 12;
		int maxDays = 0;
		
		 MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		 
		
		
		try {  
			
			for(int iPsnlCnt=0;iPsnlCnt < psnl0126List.size();iPsnlCnt++) {
				
				// 1. 암호화 객체 생성
				String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
				
				Psnl0126VO psnl0126Vo = new Psnl0126VO();  
				psnl0126Vo = psnl0126List.get(iPsnlCnt);
				
				psnl0126Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));  		/** column 사업장코드 : dpobCd */
//	           	psnl0126Vo.setDpobCd("");  														/** column 사업장코드 : dpobCd */
//	           	psnl0126Vo.setResnRegnNum(psnl0126Vo.getResnRegnNum());							/** column 주민등록번호 : ResnRegnNum */
				// 암호화
				psnl0126Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(psnl0126Vo.getResnRegnNum().replaceAll("-","")),AnyCryptUtils.SEC_RRNUMC));	
				
	           	psnl0126Vo.setSystemkey(MSFSharedUtils.allowNulls(psnl0126Vo.getSystemkey()));	/** column SYSTEMKEY : systemkey */
	           	psnl0126Vo.setHodyApptnYr(psnl0126Vo.getHodyApptnYr());							/** 휴가적용년도 HODY_APPTN_YR */
	            psnl0126Vo.setLvsgCoptnCstApptnYn(psnl0126Vo.getLvsgCoptnCstApptnYn());			/** 연가보상비적용여부 LVSG_COPTN_CST_APPTN_YN */
	            
	            Calendar  intiCal =  Calendar.getInstance();
	            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	            if("Y".equals(psnl0126Vo.getLvsgCoptnCstApptnYn())) {
	            	 psnl0126Vo.setLvsgCoptnCstApptnDt(format.format(intiCal.getTime()));
	            }else {
	            	psnl0126Vo.setLvsgCoptnCstApptnDt("");
	            }
	            
	          	psnl0126Vo.setHodyNumDysSysCalc(MSFSharedUtils.defaultNulls(psnl0126Vo.getHodyNumDysSysCalc(), "0"));	/** 휴가일수_시스템 계산 HODY_NUM_DYS_SYS_CALC */
	         	psnl0126Vo.setHodyApptnNumDys(MSFSharedUtils.defaultNulls(psnl0126Vo.getHodyApptnNumDys(), "0"));		/** 휴가적용일수 HODY_APPTN_NUM_DYS */
	          	psnl0126Vo.setSpclHodyNumDys(MSFSharedUtils.defaultNulls(psnl0126Vo.getSpclHodyNumDys(), "0"));			/** 특별휴가일수  spclHodyNumDys */
	          	psnl0126Vo.setSpclHodyUseDys(MSFSharedUtils.defaultNulls(psnl0126Vo.getSpclHodyUseDys(), "0"));			/** 특별휴가사용일수 SPCL_HODY_USE_DYS */
	         	psnl0126Vo.setHodyUseNumDys(MSFSharedUtils.defaultNulls(psnl0126Vo.getHodyUseNumDys(), "0"));			/** 휴가사용일수 HODY_USE_NUM_DYS */
	          	psnl0126Vo.setHodyRstNumDys(MSFSharedUtils.defaultNulls(psnl0126Vo.getHodyRstNumDys(), "0"));			/** 휴가잔여일수 HODY_RST_NUM_DYS */
	          	psnl0126Vo.setHodyNoteCtnt(psnl0126Vo.getHodyNoteCtnt()); 												/** 휴가비고내용 HODY_NOTE_CTNT */
	          	psnl0126Vo.setKybdr(sessionUser.getUsrId());		/** column 입력자 : kybdr */
	          	psnl0126Vo.setInptAddr(request.getRemoteHost());	/** column 입력주소 : inptAddr */
	          	psnl0126Vo.setIsmt(sessionUser.getUsrId());    		/** column 수정자 : ismt */
	          	psnl0126Vo.setRevnAddr(request.getRemoteHost());    /** column 수정주소 : revnAddr */  
	          	
	          	
	          	
	          	 //TODO 휴가확정여부는 일단 N로 insert 후 화면에서 확정하게끔...
	          	psnl0126Vo.setHodyFixYn("N");		/** 휴가확정여부 HODY_FIX_YN */ 
	          	psnl0126Vo.setHodyFixDt("");		/** 휴가확정일자 HODY_FIX_DT */ 
	          	 //=========휴가 시작일자 계산하여 mapping========
	            
	            
	            
	            if(psnl0126Vo.getHodyApptnYr() == null || psnl0126Vo.getHodyApptnYr().equals("")) {
	            	psnl0126Vo.setHodyBgnnDt("");	/** 휴가시작일자 HODY_BGNN_DT */
	            	psnl0126Vo.setHodyEndDt("");	/** 휴가종료일자 HODY_BGNN_DT */
	            }else {
	            	 intiCal =  Calendar.getInstance();
	            	format = new SimpleDateFormat("yyyyMMdd");
	            	intiCal.set(Integer.parseInt(psnl0126Vo.getHodyApptnYr()), monthS -1, 1);
	            	psnl0126Vo.setHodyBgnnDt(format.format(intiCal.getTime()));	/** 휴가시작일자 HODY_BGNN_DT */
	        		
	        		maxDays = intiCal.getActualMaximum (intiCal.DAY_OF_MONTH); 
	        		
	        	  	intiCal =   Calendar.getInstance();
	        	  	intiCal.set(Integer.parseInt(psnl0126Vo.getHodyApptnYr()), monthE - 1, maxDays); 
	        	    psnl0126Vo.setHodyEndDt(format.format(intiCal.getTime()));	/** 휴가종료일자 HODY_BGNN_DT */
	        	  //=========휴가 시작일자 계산하여 mapping========	
	            }
	          	
	          	psnl0126DAO.deleteXlsPsnl0126(psnl0126Vo);
	          	psnl0126DAO.insertXlsPsnl0126(psnl0126Vo); 
	          	
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

	 
//	@Override
//	public List updateXlsFilePsnl0126List(List<Psnl0126VO> listpsnl0126)
//			throws Exception {
//		// TODO Auto-generated method stub
////		return psnl0126DAO.updatePsnl0126(listpsnl0126); 
//	}


  
}
