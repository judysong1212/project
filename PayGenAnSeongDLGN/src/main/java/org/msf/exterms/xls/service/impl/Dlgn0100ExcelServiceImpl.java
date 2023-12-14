package org.msf.exterms.xls.service.impl;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.xls.imp.MsfExcelService;
import org.msf.exterms.xls.service.Dlgn0100ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;

import com.app.exterms.diligence.server.service.dao.Dlgn0100DAO;
import com.app.exterms.diligence.server.service.dao.Dlgn0110DAO;
import com.app.exterms.diligence.server.service.dao.Dlgn0200DAO;
import com.app.exterms.diligence.server.service.dao.Dlgn0210DAO;
import com.app.exterms.diligence.server.vo.Dlgn0100SrhVO;
import com.app.exterms.diligence.server.vo.Dlgn0100VO;
import com.app.exterms.diligence.server.vo.Dlgn0110ExlVO;
import com.app.exterms.diligence.server.vo.Dlgn0200VO;
import com.app.exterms.diligence.server.vo.Dlgn0210ExlVO;
import com.app.exterms.diligence.server.vo.Dlgn0250SrhVO;
import com.app.exterms.diligence.server.vo.Dlgn0250VO;
import com.app.exterms.dlgn.server.utils.DiligenceCommonConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.diligence.server.vo.InfcPkgDlgn0100VO;
import com.app.smrmf.infc.diligence.server.vo.InfcPkgDlgn0200VO;
import com.app.smrmf.pkg.listener.DlgnListenerAdapter;
import com.ibm.icu.util.Calendar;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("dlgn0100ExcelService")
public class Dlgn0100ExcelServiceImpl extends AbstractServiceImpl implements Dlgn0100ExcelService, ServletContextAware, ServletConfigAware  {
	
	 private static final Logger logger = LoggerFactory.getLogger(Dlgn0100ExcelServiceImpl.class);
	 private static final String calledClass = Dlgn0100ExcelServiceImpl.class.getName();
	 
	  private String detailYmKubn = DiligenceCommonConstants.ANSEONG_DLGN_DT_BUNGI;; //복무관리 기준일 
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
    
    @Autowired 
    @Resource(name="dlgn0100DAO")
    private Dlgn0100DAO dlgn0100DAO;
    
    @Autowired 
    @Resource(name="dlgn0110DAO")
    private Dlgn0110DAO dlgn0110DAO;
    
    @Autowired 
    @Resource(name="dlgn0210DAO")
    private Dlgn0210DAO dlgn0210DAO;
    
    @Autowired 
    @Resource(name="dlgn0200DAO")
    private Dlgn0200DAO dlgn0200DAO;
    
    @Autowired 
    @Resource(name = "dlgn0250ExcelUploadService")
    private MsfExcelService dlgn0250ExcelUploadService;
    
    @Autowired 
    @Resource(name = "dlgn0250XSSFExcelUploadService")
    private MsfExcelService dlgn0250XSSFExcelUploadService;
    
    
    public List<Dlgn0250VO> selectXlsDlgn0250List(Dlgn0250SrhVO dlgn0250SrhVo) throws Exception {
        return dlgn0100DAO.selectXlsDlgn0250List(dlgn0250SrhVo);
    } 
  
  //엑셀 다운로드
  public List  selectXlsFileDlgn0250List(Dlgn0250SrhVO dlgn0250SrhVo) throws Exception {
      return dlgn0100DAO.selectXlsDlgn0250FormList(dlgn0250SrhVo);
  }   
  
  
  /**
   *  엑셀파일을 등록한다.
   * @param  
   * @throws Exception
   */
  public Long updateXlsDlgn0250(List<Dlgn0250VO> dlgn0250List, HttpServletRequest request) throws Exception {
	  
	  String method = calledClass + ".updateXlsDlgn0250";
	  MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
	  

//	  String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),request);
//	  Dlgn0250VO dlgn0250Vo; 
//	  Dlgn0250VO dlgn0250Vo ; 
	  
	  Long result = new Long(0);
	  Long iCnt = new Long(0);
	  
	  try{
		  
		  
		  
		  if(dlgn0250List !=null && dlgn0250List.size() > 0){
			  for ( int i = 0; i < dlgn0250List.size(); i++){
				  String nResult = AnyCryptUtils.XecureCryptInitialize(sevltConfig, request);
				  Dlgn0250VO dlgn0250Vo = new Dlgn0250VO(); 
				  dlgn0250Vo = dlgn0250List.get(i);
				  
					   
				  dlgn0250Vo.setDpobCd(sessionUser.getDpobCd());		//사업장코드
				  
				  dlgn0250Vo.setDilnlazYrMnth(MSFSharedUtils.allowNulls(dlgn0250Vo.getDilnlazYrMnth()));/** 년월 column 근태년월 : dilnlazYrMnth */
				  dlgn0250Vo.setDilnlazExceDutyYrMnth(MSFSharedUtils.allowNulls(dlgn0250Vo.getDilnlazYrMnth()));/** 년월 column 근태년월 : dilnlazExceDutyYrMnth */
				  dlgn0250Vo.setPayCd(MSFSharedUtils.allowNulls(dlgn0250Vo.getPayCd()));						/** 급여구분 column 급여구분코드 : payCd */
				  dlgn0250Vo.setDilnlazDutyNumDys(MSFSharedUtils.allowNulls(dlgn0250Vo.getDilnlazDutyNumDys()));    /** 근무일수 column 근태_근무일수 : dilnlazDutyNumDys */
				  dlgn0250Vo.setHanNm(MSFSharedUtils.allowNulls(dlgn0250Vo.getHanNm()));//성명 hanNm
				  
//				  dlgn0250Vo.setResnRegnNum(MSFSharedUtils.allowNulls(dlgn0250List.get(i).getResnRegnNum()).replaceAll("-", ""));//주민등록번호 resnRegnNum
				  dlgn0250Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(dlgn0250Vo.getResnRegnNum().replaceAll("-","")),AnyCryptUtils.SEC_RRNUMC));	
				  
				  dlgn0250Vo.setDilnlazDutyNumDys(MSFSharedUtils.defaultNulls(dlgn0250Vo.getDilnlazDutyNumDys(), "0"));//근무일수 dilnlazDutyNumDys
				  dlgn0250Vo.setDilnlazPaidHodyNumDys(MSFSharedUtils.defaultNulls(dlgn0250Vo.getDilnlazPaidHodyNumDys(), "0"));	//휴가(유급)사용일수 dilnlazPaidHodyNumDys					  
				  dlgn0250Vo.setDilnlazTotDutyNumDys(MSFSharedUtils.defaultNulls(dlgn0250Vo.getDilnlazTotDutyNumDys(), "0"));//실근무일 dilnlazTotDutyNumDys
				  dlgn0250Vo.setDilnlazSpclHodyNumDys(MSFSharedUtils.defaultNulls(dlgn0250Vo.getDilnlazSpclHodyNumDys(), "0"));//특별휴가  dilnlazSpclHodyNumDys
				  dlgn0250Vo.setDilnlazAbnceNumDys(MSFSharedUtils.defaultNulls(dlgn0250Vo.getDilnlazAbnceNumDys(), "0"));		 //결근 dilnlazAbnceNumDys					  
				  dlgn0250Vo.setDilnlazAbnceDutyRcgtnDys(MSFSharedUtils.defaultNulls(dlgn0250Vo.getDilnlazAbnceDutyRcgtnDys(), "0"));	 //결근인정일수 dilnlazAbnceDutyRcgtnDys					   
				  dlgn0250Vo.setDilnlazSckleaNumDys(MSFSharedUtils.defaultNulls(dlgn0250Vo.getDilnlazSckleaNumDys(), "0"));	//병가 dilnlazSckleaNumDys							  
				  dlgn0250Vo.setDilnlazOffvaNumDys(MSFSharedUtils.defaultNulls(dlgn0250Vo.getDilnlazOffvaNumDys(), "0"));		//공가 dilnlazOffvaNumDys					  
				  dlgn0250Vo.setDilnlazFmlyEvntNumDys(MSFSharedUtils.defaultNulls(dlgn0250Vo.getDilnlazFmlyEvntNumDys(), "0"));//경조사 dilnlazFmlyEvntNumDys							  
				  dlgn0250Vo.setDilnlazHlthCreNumDys(MSFSharedUtils.defaultNulls(dlgn0250Vo.getDilnlazHlthCreNumDys(), "0"));	//보건 dilnlazHlthCreNumDys	
				  	//잔여월차 0
				  dlgn0250Vo.setDilnlazPubcHodyDutyNumDys(MSFSharedUtils.defaultNulls(dlgn0250Vo.getDilnlazPubcHodyDutyNumDys(), "0"));	//휴일근무 dilnlazPubcHodyDutyNumDys	
				  dlgn0250Vo.setDilnlazHodyDutyNumDys(MSFSharedUtils.defaultNulls(dlgn0250Vo.getDilnlazHodyDutyNumDys(), "0"));	//휴일일수 : dilnlazHodyDutyNumDys	
				  dlgn0250Vo.setDilnlazSatDutyNumDys(MSFSharedUtils.defaultNulls(dlgn0250Vo.getDilnlazSatDutyNumDys(), "0"));	//토요근무 dilnlazSatDutyNumDys			  
				  dlgn0250Vo.setDilnlazWklyHldyNumDys(MSFSharedUtils.defaultNulls(dlgn0250Vo.getDilnlazWklyHldyNumDys(), "0"));	//주휴일수 dilnlazWklyHldyNumDys					  
				  dlgn0250Vo.setDilnlazPaidPubcHodyNum(MSFSharedUtils.defaultNulls(dlgn0250Vo.getDilnlazPaidPubcHodyNum(), "0"));	//유급(월차)휴일수 dilnlazPaidPubcHodyNum				  
												  //잔여연가 0
				  dlgn0250Vo.setDilnlazTfcAssCstNumDys(MSFSharedUtils.defaultNulls(dlgn0250Vo.getDilnlazTfcAssCstNumDys(), "0"));//교통보조비 dilnlazTfcAssCstNumDys
				  dlgn0250Vo.setDilnlazWkdDutyNumDys(MSFSharedUtils.defaultNulls(dlgn0250Vo.getDilnlazWkdDutyNumDys(), "0"));	//평일근무일수 dilnlazWkdDutyNumDys - 200
				  
				  
				  dlgn0250Vo.setDilnlazFndtnTmRstDutyTm(MSFSharedUtils.defaultNulls(dlgn0250Vo.getDilnlazFndtnTmRstDutyTm(), "0"));//시간외기본시간 dilnlazFndtnTmRstDutyTm - 200								  
				  dlgn0250Vo.setDilnlazTmRstDutyTm(MSFSharedUtils.defaultNulls(dlgn0250Vo.getDilnlazTmRstDutyTm(), "0"));	//시간외시간 dilnlazTmRstDutyTm  - 200						  
				  dlgn0250Vo.setDilnlazTotTmRstDutyTm(MSFSharedUtils.defaultNulls(dlgn0250Vo.getDilnlazTotTmRstDutyTm(), "0"));//시간외총시간 dilnlazTotTmRstDutyTm - 200						  
				  dlgn0250Vo.setDilnlazTotNtotTm(MSFSharedUtils.defaultNulls(dlgn0250Vo.getDilnlazTotNtotTm(), "0"));	//야근수당(시간) dilnlazTotNtotTm - 200		
				  
	
				  
				  //				  dlgn0250Vo.setDilnlazYrMnth(MSFSharedUtils.allowNulls(dlgn0250List.get(i).getDilnlazYrMnth()));/** 년월 column 근태년월 : dilnlazYrMnth */
//				  dlgn0250Vo.setDilnlazExceDutyYrMnth(MSFSharedUtils.allowNulls(dlgn0250List.get(i).getDilnlazYrMnth()));/** 년월 column 근태년월 : dilnlazExceDutyYrMnth */
//				  dlgn0250Vo.setPayCd(MSFSharedUtils.allowNulls(dlgn0250List.get(i).getDilnlazYrMnth()));		/** 급여구분 column 급여구분코드 : payCd */
//				  dlgn0250Vo.setDilnlazDutyNumDys(MSFSharedUtils.allowNulls(dlgn0250List.get(i).getDilnlazDutyNumDys()));    /** 근무일수 column 근태_근무일수 : dilnlazDutyNumDys */
//				  dlgn0250Vo.setHanNm(MSFSharedUtils.allowNulls(dlgn0250List.get(i).getHanNm()));//성명 hanNm
//				  
////				  dlgn0250Vo.setResnRegnNum(MSFSharedUtils.allowNulls(dlgn0250List.get(i).getResnRegnNum()).replaceAll("-", ""));//주민등록번호 resnRegnNum
//				  dlgn0250Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(dlgn0250List.get(i).getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));//주민등록번호 resnRegnNum
//				  
//				  
//				  dlgn0250Vo.setDilnlazDutyNumDys(MSFSharedUtils.allowNulls(dlgn0250List.get(i).getDilnlazDutyNumDys()));//근무일수 dilnlazDutyNumDys
//				  dlgn0250Vo.setDilnlazPaidHodyNumDys(MSFSharedUtils.allowNulls(dlgn0250List.get(i).getDilnlazPaidHodyNumDys()));	//휴가(유급)사용일수 dilnlazPaidHodyNumDys					  
//				  dlgn0250Vo.setDilnlazTotDutyNumDys(MSFSharedUtils.allowNulls(dlgn0250List.get(i).getDilnlazTotDutyNumDys()));//실근무일 dilnlazTotDutyNumDys
//				  dlgn0250Vo.setDilnlazSpclHodyNumDys(MSFSharedUtils.allowNulls(dlgn0250List.get(i).getDilnlazSpclHodyNumDys()));//특별휴가  dilnlazSpclHodyNumDys
//				  dlgn0250Vo.setDilnlazAbnceNumDys(MSFSharedUtils.allowNulls(dlgn0250List.get(i).getDilnlazAbnceNumDys()));		 //결근 dilnlazAbnceNumDys					  
//				  dlgn0250Vo.setDilnlazAbnceDutyRcgtnDys(MSFSharedUtils.allowNulls(dlgn0250List.get(i).getDilnlazAbnceDutyRcgtnDys()));	 //결근인정일수 dilnlazAbnceDutyRcgtnDys					   
//				  dlgn0250Vo.setDilnlazSckleaNumDys(MSFSharedUtils.allowNulls(dlgn0250List.get(i).getDilnlazSckleaNumDys()));	//병가 dilnlazSckleaNumDys							  
//				  dlgn0250Vo.setDilnlazOffvaNumDys(MSFSharedUtils.allowNulls(dlgn0250List.get(i).getDilnlazOffvaNumDys()));		//공가 dilnlazOffvaNumDys					  
//				  dlgn0250Vo.setDilnlazFmlyEvntNumDys(MSFSharedUtils.allowNulls(dlgn0250List.get(i).getDilnlazFmlyEvntNumDys()));//경조사 dilnlazFmlyEvntNumDys							  
//				  dlgn0250Vo.setDilnlazHlthCreNumDys(MSFSharedUtils.allowNulls(dlgn0250List.get(i).getDilnlazHlthCreNumDys()));	//보건 dilnlazHlthCreNumDys	
//				  	//잔여월차 0
//				  dlgn0250Vo.setDilnlazPubcHodyDutyNumDys(MSFSharedUtils.allowNulls(dlgn0250List.get(i).getDilnlazPubcHodyDutyNumDys()));	//휴일근무 dilnlazPubcHodyDutyNumDys						 
//				  dlgn0250Vo.setDilnlazSatDutyNumDys(MSFSharedUtils.allowNulls(dlgn0250List.get(i).getDilnlazSatDutyNumDys()));	//토요근무 dilnlazSatDutyNumDys			  
//				  dlgn0250Vo.setDilnlazWklyHldyNumDys(MSFSharedUtils.allowNulls(dlgn0250List.get(i).getDilnlazWklyHldyNumDys()));	//주휴일수 dilnlazWklyHldyNumDys					  
//				  dlgn0250Vo.setDilnlazPaidPubcHodyNum(MSFSharedUtils.allowNulls(dlgn0250List.get(i).getDilnlazPaidPubcHodyNum()));	//유급(월차)휴일수 dilnlazPaidPubcHodyNum				  
//												  //잔여연가 0
//				  dlgn0250Vo.setDilnlazTfcAssCstNumDys(MSFSharedUtils.allowNulls(dlgn0250List.get(i).getDilnlazTfcAssCstNumDys()));//교통보조비 dilnlazTfcAssCstNumDys
//				  dlgn0250Vo.setDilnlazFndtnTmRstDutyTm(MSFSharedUtils.allowNulls(dlgn0250List.get(i).getDilnlazFndtnTmRstDutyTm()));//시간외기본시간 dilnlazFndtnTmRstDutyTm - 200								  
//				  dlgn0250Vo.setDilnlazTmRstDutyTm(MSFSharedUtils.allowNulls(dlgn0250List.get(i).getDilnlazTmRstDutyTm()));	//시간외시간 dilnlazTmRstDutyTm  - 200						  
//				  dlgn0250Vo.setDilnlazTotTmRstDutyTm(MSFSharedUtils.allowNulls(dlgn0250List.get(i).getDilnlazTotTmRstDutyTm()));//시간외총시간 dilnlazTotTmRstDutyTm - 200						  
//				  dlgn0250Vo.setDilnlazTotNtotTm(MSFSharedUtils.allowNulls(dlgn0250List.get(i).getDilnlazTotNtotTm()));	//야근수당(시간) dilnlazTotNtotTm - 200						  
				
				  //삭제 후 입력
				  dlgn0100DAO.deleteXlsDlgn0100(dlgn0250Vo); 
				  dlgn0100DAO.insertXlsDlgn0100(dlgn0250Vo); 
				  
				  dlgn0200DAO.deleteXlsDlgn0200(dlgn0250Vo); 
				  dlgn0200DAO.insertXlsDlgn0200(dlgn0250Vo);
			  
				}

			}
		  

		  
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "D:C:B");
		  
		  result = iCnt;
		  
	  }catch(Exception e){
			e.printStackTrace();
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
	}
	  return result;
  }
  
	  
  /**
   *  엑셀파일을 등록한다.
   * @param  
   * @throws Exception
   */
  public void insertXlsDlgn0200(List<Dlgn0250VO> dlgn0250List) throws Exception {
     // dlgn0100DAO.insertXlsDlgn0200(); //삭제호출 후 파일데이터 인서트  
	  
	  
  }
  
  
  
  
  //------
  /**
   *  엑셀파일을 등록한다.
   * @param  
   * @throws Exception
   */
  public void insertXlsDlgn0100(InputStream file) throws Exception {
     // dlgn0100DAO.insertXlsDlgn0100(); //삭제호출 후 파일데이터 인서트  
      dlgn0250ExcelUploadService.uploadExcel("dlgn0100DAO.deleteXlsDlgn0100_S","dlgn0100DAO.insertXlsDlgn0100_S", file, 3, (long) 0);  
  }
  
  
  /**
   *  엑셀파일을 등록한다.
   * @param  
   * @throws Exception
   */
  public void insertXlsDlgn0200(InputStream file) throws Exception {
     // dlgn0100DAO.insertXlsDlgn0200(); //삭제호출 후 파일데이터 인서트  
      dlgn0250ExcelUploadService.uploadExcel("dlgn0200DAO.deleteXlsDlgn0200_S","dlgn0200DAO.insertXlsDlgn0200_S", file, 3, (long) 0); 
  }


  /**
   *  엑셀파일을 등록한다.
   * @param  
   * @throws Exception
   */
  public void insertXSSFDlgn0100(InputStream file) throws Exception {
     // dlgn0100DAO.insertXlsDlgn0100(); //삭제호출 후 파일데이터 인서트  
      dlgn0250XSSFExcelUploadService.uploadXSSFExcel("dlgn0100DAO.deleteXlsDlgn0100_S","dlgn0100DAO.insertXlsDlgn0100_S", file, 3, (long) 0);  
  }
  
  
  /**
   *  엑셀파일을 등록한다.
   * @param  
   * @throws Exception
   */
  public void insertXSSFDlgn0200(InputStream file) throws Exception {
     // dlgn0100DAO.insertXlsDlgn0200(); //삭제호출 후 파일데이터 인서트  
      dlgn0250XSSFExcelUploadService.uploadXSSFExcel("dlgn0200DAO.deleteXlsDlgn0200_S", "dlgn0200DAO.insertXlsDlgn0200_S", file, 3, (long) 0); 
  }

  
  /**
   * DLGN0100을 수정한다.
   * @param vo - 수정할 정보가 담긴 Dlgn0100VO
   * @return void형
   * @exception Exception
   */
  public void updateXlsDlgn0100(Dlgn0100VO vo) throws Exception {
      dlgn0100DAO.updateDlgn0100(vo);
  }
  

  /**
   * DLGN0100을 등록한다.
   * @param vo - 등록할 정보가 담긴 Dlgn0100VO
   * @return 등록 결과
   * @exception Exception
   */
  public String insertDlgn0100(Dlgn0100VO vo) throws Exception {
      log.debug(vo.toString());
      
      /** ID Generation Service */
      //TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
      //String id = egovIdGnrService.getNextStringId();
      //vo.setId(id);
      log.debug(vo.toString());
      
      dlgn0100DAO.insertDlgn0100(vo);
      //TODO 해당 테이블 정보에 맞게 수정     
      return null;
  }

  /**
   * DLGN0100을 삭제한다.
   * @param vo - 삭제할 정보가 담긴 Dlgn0100VO
   * @return void형 
   * @exception Exception
   */
  public void deleteXlsDlgn0100(Dlgn0100VO vo) throws Exception {
      dlgn0100DAO.deleteDlgn0100(vo);
  }

  /**
   * DLGN0100을 조회한다.
   * @param vo - 조회할 정보가 담긴 Dlgn0100VO
   * @return 조회한 DLGN0100
   * @exception Exception
   */
  public Dlgn0100VO selectXlsDlgn0100(Dlgn0100VO vo) throws Exception {
      Dlgn0100VO resultVO = dlgn0100DAO.selectDlgn0100(vo);
//      if (resultVO == null)
//          throw processException("info.nodata.msg");
      return resultVO;
  }
  
  /**
   * DLGN0200을 등록한다.
   * @param vo - 등록할 정보가 담긴 Dlgn0200VO
   * @return 등록 결과
   * @exception Exception
   */
  public String insertXlsDlgn0200(Dlgn0200VO vo) throws Exception {
      log.debug(vo.toString());
      
      /** ID Generation Service */
      //TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
      //String id = egovIdGnrService.getNextStringId();
      //vo.setId(id);
      log.debug(vo.toString());
      
      dlgn0200DAO.insertDlgn0200(vo);
      //TODO 해당 테이블 정보에 맞게 수정     
      return null;
  }

  /**
   * DLGN0200을 수정한다.
   * @param vo - 수정할 정보가 담긴 Dlgn0200VO
   * @return void형
   * @exception Exception
   */
  public void updateXlsDlgn0200(Dlgn0200VO vo) throws Exception {
      dlgn0200DAO.updateDlgn0200(vo);
  }

  /**
   * DLGN0200을 삭제한다.
   * @param vo - 삭제할 정보가 담긴 Dlgn0200VO
   * @return void형 
   * @exception Exception
   */
  public void deleteXlsDlgn0200(Dlgn0200VO vo) throws Exception {
      dlgn0200DAO.deleteDlgn0200(vo);
  }

  /**
   * DLGN0200을 조회한다.
   * @param vo - 조회할 정보가 담긴 Dlgn0200VO
   * @return 조회한 DLGN0200
   * @exception Exception
   */
  public Dlgn0200VO selectXlsDlgn0200(Dlgn0200VO vo) throws Exception {
      Dlgn0200VO resultVO = dlgn0200DAO.selectDlgn0200(vo);
//      if (resultVO == null)
//          throw processException("info.nodata.msg");
      return resultVO;
  }

  //TODO 0100service부터 다시 정의
@Override
public List<Dlgn0250VO> selectXlsDlgn0100List(Dlgn0250SrhVO dlgn0250SrhVo)
		throws Exception {
	return dlgn0100DAO.selectXlsDlgn0100List(dlgn0250SrhVo);
}

//TODO 0100service부터 다시 정의
@Override
public Integer selectDlgn0100Cnt(Dlgn0250SrhVO dlgn0250SrhVo)
		throws Exception {
	return dlgn0100DAO.selectDlgn0100Cnt(dlgn0250SrhVo);
}


@Override
public List<Dlgn0250VO> selectXlsDlgn0100ListD(Dlgn0250SrhVO dlgn0250SrhVo)
		throws Exception {
	return dlgn0100DAO.selectXlsDlgn0100ListD(dlgn0250SrhVo);
}

@Override
public List selectXlsFileDlgn0100List(Dlgn0100SrhVO dlgn0100SrhVo)
		throws Exception {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List selectXlsUseDlgn0100List(Dlgn0100SrhVO dlgn0100SrhVo)throws Exception {
	// TODO Auto-generated method stub
	return dlgn0100DAO.selectDlgn0100(dlgn0100SrhVo);
}

@Override
public Long updateXlsDlgn0100(List<Dlgn0110ExlVO> dlgn0110List,HttpServletRequest request) throws Exception {
	  String method = calledClass + ".updateXlsDlgn0110";
	  MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
	  	
	  Long result = new Long(0);
	  Long iCnt = new Long(0);
	  Long iResult = new Long(0);
	  Long iResult1 = new Long(0);
	  
	  try{
		  
		  if(dlgn0110List !=null && dlgn0110List.size() > 0){
			  for ( int i = 0; i < dlgn0110List.size(); i++){
				  String nResult = AnyCryptUtils.XecureCryptInitialize(sevltConfig, request);
				  Dlgn0110ExlVO dlgn0110Vo = new Dlgn0110ExlVO(); 
				  Dlgn0210ExlVO dlgn0210Vo = new Dlgn0210ExlVO(); 
				  Dlgn0110ExlVO dlgn0110SaveVo = new Dlgn0110ExlVO(); 
				  Dlgn0210ExlVO dlgn0210SaveVo = new Dlgn0210ExlVO(); 
				  
				  dlgn0110Vo = dlgn0110List.get(i);
				  dlgn0110Vo.setDpobCd(sessionUser.getDpobCd());		//사업장코드
				  dlgn0110Vo.setIsmt(sessionUser.getUsrId());
				  dlgn0110Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				  dlgn0110Vo.setPayCd(MSFSharedUtils.allowNulls(dlgn0110Vo.getPayCd()));	/** 급여구분 column 급여구분코드 : payCd */
				  dlgn0110Vo.setHanNm(MSFSharedUtils.allowNulls(dlgn0110Vo.getHanNm()));//성명 hanNm
				  dlgn0110Vo.setEmymtDivCd(MSFSharedUtils.allowNulls(dlgn0110Vo.getEmymtDivCd())); //고용구분코드
				  dlgn0110Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(dlgn0110Vo.getResnRegnNum().replaceAll("-","")),AnyCryptUtils.SEC_RRNUMC));
				  dlgn0110Vo.setDilnlazYrMnth(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazYrMnth()));/** 년월 column 근태년월 : dilnlazYrMnth */
				  dlgn0110Vo.setDilnlazDutyBgnnDt(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyBgnnDt(),""));/** 년월 column 근무시작일자 : dilnlazDutyBgnnDt */
				  dlgn0110Vo.setDilnlazDutyEndDt(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyEndDt(),""));/** 년월 column 근무종료일자 : dilnlazDutyEndDt */
				  dlgn0110Vo.setDilnlazApptnDt(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazApptnDt()));/** 년월 column 근무일자 : dilnlazApptnDt */
				  
				  String strDilnlazDutyBgnnDt = dlgn0110Vo.getDilnlazDutyBgnnDt();
				  String strDilnlazDutyEndDt = dlgn0110Vo.getDilnlazDutyEndDt();
				  
				  if("".equals(strDilnlazDutyBgnnDt) || "".equals(strDilnlazDutyEndDt) ){
					  
					  result = -10L;
					  
				  }else{
					  
					    
					  	 SimpleDateFormat  formatter03 = new SimpleDateFormat("yyyyMMdd");
					  	 Date endDate =  formatter03.parse(strDilnlazDutyEndDt);
					  	 Date startDate =  formatter03.parse(strDilnlazDutyBgnnDt);
					  	        
					  	 long diff = endDate.getTime() - startDate.getTime();
					
					     long diffDays = diff / (24 * 60 * 60 * 1000);
					    
					     int numDays = Integer.parseInt(diffDays+"") + 1;
					     
					     String[] strDate = new String[numDays];
					     System.out.println("numDays========="+numDays);

					     Calendar cal = Calendar.getInstance();
					    
					     cal.setTime(startDate);
					     for(int k=0 ;k<31;k++){
					    	 if(k == 0){
					    		 cal.add(Calendar.DATE, 0);
					    	 }else{
					    		 cal.add(Calendar.DATE, 1);
					    	 } 
					    	  strDate[k] = formatter03.format(cal.getTime());
					    	  System.out.println("strDate========="+ strDate[k]);
					     }

					     
					     

						 
						  dlgn0110Vo.setKubn1(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn1(),""));/** 년월 column 근무구분_1일 : kubn1 */
						  dlgn0110Vo.setDilnlazDutyTm1(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm1(),"")));/** column 근무시간_1일 : dilnlazDutyTm1 */
						  dlgn0110Vo.setDilnlazStTm1(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm1(),"")));/** column 출근시간_1일 : dilnlazStTm1 */
						  dlgn0110Vo.setDilnlazEdTm1(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm1(),"")));/** column 퇴근시간_1일 : dilnlazEtTm1 */
						  dlgn0110Vo.setDilnlazApptnDt1(MSFSharedUtils.defaultNulls(strDate[0],""));/**근무일 */
						  
						  dlgn0110Vo.setKubn2(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn2(),""));/** 년월 column 근무구분_2일 : kubn2 */
						  dlgn0110Vo.setDilnlazDutyTm2(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm2(),"")));/** column 근무시간_2일 : dilnlazDutyTm2 */
						  dlgn0110Vo.setDilnlazStTm2(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm2(),"")));/** column 출근시간_2일 : dilnlazStTm2 */
						  dlgn0110Vo.setDilnlazEdTm2(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm2(),"")));/** column 퇴근시간_2일 : dilnlazEtTm2 */
						  dlgn0110Vo.setDilnlazApptnDt2(MSFSharedUtils.defaultNulls(strDate[1],""));/**근무일 */
						  
						  
						  dlgn0110Vo.setKubn3(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn3(),""));/** 년월 column 근무구분_3일 : kubn3 */
						  dlgn0110Vo.setDilnlazDutyTm3(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm3(),"")));/** column 근무시간_3일 : dilnlazDutyTm3 */
						  dlgn0110Vo.setDilnlazStTm3(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm3(),"")));/** column 출근시간_3일 : dilnlazStTm3 */
						  dlgn0110Vo.setDilnlazEdTm3(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm3(),"")));/** column 퇴근시간_3일 : dilnlazEtTm3 */
						  dlgn0110Vo.setDilnlazApptnDt3(MSFSharedUtils.defaultNulls(strDate[2],""));/**근무일 */
						  
						  
						  dlgn0110Vo.setKubn4(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn4(),""));/** 년월 column 근무구분_4일 : kubn4 */
						  dlgn0110Vo.setDilnlazDutyTm4(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm4(),"")));/** column 근무시간_4일 : dilnlazDutyTm4 */
						  dlgn0110Vo.setDilnlazStTm4(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm4(),"")));/** column 출근시간_4일 : dilnlazStTm4 */
						  dlgn0110Vo.setDilnlazEdTm4(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm4(),"")));/** column 퇴근시간_4일 : dilnlazEtTm4 */
						  dlgn0110Vo.setDilnlazApptnDt4(MSFSharedUtils.defaultNulls(strDate[3],""));/**근무일 */
						  
						  dlgn0110Vo.setKubn5(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn5(),""));/** 년월 column 근무구분_5일 : kubn5 */
						  dlgn0110Vo.setDilnlazDutyTm5(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm5(),"")));/** column 근무시간_5일 : dilnlazDutyTm5 */
						  dlgn0110Vo.setDilnlazStTm5(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm5(),"")));/** column 출근시간_5일 : dilnlazStTm5 */
						  dlgn0110Vo.setDilnlazEdTm5(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm5(),"")));/** column 퇴근시간_5일 : dilnlazEtTm5 */
						  dlgn0110Vo.setDilnlazApptnDt5(MSFSharedUtils.defaultNulls(strDate[4],""));/**근무일 */
						  
						  dlgn0110Vo.setKubn6(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn6(),""));/** 년월 column 근무구분_6일 : kubn6 */
						  dlgn0110Vo.setDilnlazDutyTm6(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm6(),"")));/** column 근무시간_6일 : dilnlazDutyTm6 */
						  dlgn0110Vo.setDilnlazStTm6(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm6(),"")));/** column 출근시간_6일 : dilnlazStTm6 */
						  dlgn0110Vo.setDilnlazEdTm6(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm6(),"")));/** column 퇴근시간_6일 : dilnlazEtTm6 */
						  dlgn0110Vo.setDilnlazApptnDt6(MSFSharedUtils.defaultNulls(strDate[5],""));/**근무일 */
						  
						  dlgn0110Vo.setKubn7(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn7(),""));/** 년월 column 근무구분_7일 : kubn7 */
						  dlgn0110Vo.setDilnlazDutyTm7(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm7(),"")));/** column 근무시간_7일 : dilnlazDutyTm7 */
						  dlgn0110Vo.setDilnlazStTm7(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm7(),"")));/** column 출근시간_7일 : dilnlazStTm7 */
						  dlgn0110Vo.setDilnlazEdTm7(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm7(),"")));/** column 퇴근시간_7일 : dilnlazEtTm7 */
						  dlgn0110Vo.setDilnlazApptnDt7(MSFSharedUtils.defaultNulls(strDate[6],""));/**근무일 */
						  
						  dlgn0110Vo.setKubn8(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn8(),""));/** 년월 column 근무구분_8일 : kubn8 */
						  dlgn0110Vo.setDilnlazDutyTm8(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm8(),"")));/** column 근무시간_8일 : dilnlazDutyTm8 */
						  dlgn0110Vo.setDilnlazStTm8(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm8(),"")));/** column 출근시간_8일 : dilnlazStTm8 */
						  dlgn0110Vo.setDilnlazEdTm8(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm8(),"")));/** column 퇴근시간_8일 : dilnlazEtTm8 */
						  dlgn0110Vo.setDilnlazApptnDt8(MSFSharedUtils.defaultNulls(strDate[7],""));/**근무일 */
						  
						  dlgn0110Vo.setKubn9(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn9(),""));/** 년월 column 근무구분_9일 : kubn9 */
						  dlgn0110Vo.setDilnlazDutyTm9(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm9(),"")));/** column 근무시간_9일 : dilnlazDutyTm9 */
						  dlgn0110Vo.setDilnlazStTm9(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm9(),"")));/** column 출근시간_9일 : dilnlazStTm9 */
						  dlgn0110Vo.setDilnlazEdTm9(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm9(),"")));/** column 퇴근시간_9일 : dilnlazEtTm9 */
						  dlgn0110Vo.setDilnlazApptnDt9(MSFSharedUtils.defaultNulls(strDate[8],""));/**근무일 */
						  
						  dlgn0110Vo.setKubn10(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn10(),""));/** 년월 column 근무구분_10일 : kubn10 */
						  dlgn0110Vo.setDilnlazDutyTm10(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm10(),"")));/** column 근무시간_10일 : dilnlazDutyTm10 */
						  dlgn0110Vo.setDilnlazStTm10(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm10(),"")));/** column 출근시간_10일 : dilnlazStTm10 */
						  dlgn0110Vo.setDilnlazEdTm10(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm10(),"")));/** column 퇴근시간_10일 : dilnlazEtTm10 */
						  dlgn0110Vo.setDilnlazApptnDt10(MSFSharedUtils.defaultNulls(strDate[9],""));/**근무일 */
						  
						  dlgn0110Vo.setKubn11(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn11(),""));/** 년월 column 근무구분_11일 : kubn11 */
						  dlgn0110Vo.setDilnlazDutyTm11(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm11(),"")));/** column 근무시간_11일 : dilnlazDutyTm11 */
						  dlgn0110Vo.setDilnlazStTm11(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm11(),"")));/** column 출근시간_11일 : dilnlazStTm11 */
						  dlgn0110Vo.setDilnlazEdTm11(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm11(),"")));/** column 퇴근시간_11일 : dilnlazEtTm11 */
						  dlgn0110Vo.setDilnlazApptnDt11(MSFSharedUtils.defaultNulls(strDate[10],""));/**근무일 */
						  
						  dlgn0110Vo.setKubn12(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn12(),""));/** 년월 column 근무구분_12일 : kubn12 */
						  dlgn0110Vo.setDilnlazDutyTm12(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm12(),"")));/** column 근무시간_12일 : dilnlazDutyTm12 */
						  dlgn0110Vo.setDilnlazStTm12(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm12(),"")));/** column 출근시간_12일 : dilnlazStTm12 */
						  dlgn0110Vo.setDilnlazEdTm12(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm12(),"")));/** column 퇴근시간_12일 : dilnlazEtTm12 */
						  dlgn0110Vo.setDilnlazApptnDt12(MSFSharedUtils.defaultNulls(strDate[11],""));/**근무일 */
						  
						  dlgn0110Vo.setKubn13(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn13(),""));/** 년월 column 근무구분_13일 : kubn13 */
						  dlgn0110Vo.setDilnlazDutyTm13(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm13(),"")));/** column 근무시간_13일 : dilnlazDutyTm13 */
						  dlgn0110Vo.setDilnlazStTm13(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm13(),"")));/** column 출근시간_13일 : dilnlazStTm13 */
						  dlgn0110Vo.setDilnlazEdTm13(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm13(),"")));/** column 퇴근시간_13일 : dilnlazEtTm13 */
						  dlgn0110Vo.setDilnlazApptnDt13(MSFSharedUtils.defaultNulls(strDate[12],""));/**근무일 */
						  
						  dlgn0110Vo.setKubn14(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn14(),""));/** 년월 column 근무구분_14일 : kubn14 */
						  dlgn0110Vo.setDilnlazDutyTm14(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm14(),"")));/** column 근무시간_14일 : dilnlazDutyTm14 */
						  dlgn0110Vo.setDilnlazStTm14(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm14(),"")));/** column 출근시간_14일 : dilnlazStTm14 */
						  dlgn0110Vo.setDilnlazEdTm14(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm14(),"")));/** column 퇴근시간_14일 : dilnlazEtTm14 */
						  dlgn0110Vo.setDilnlazApptnDt14(MSFSharedUtils.defaultNulls(strDate[13],""));/**근무일 */
						  
						  dlgn0110Vo.setKubn15(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn15(),""));/** 년월 column 근무구분_15일 : kubn15 */
						  dlgn0110Vo.setDilnlazDutyTm15(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm15(),"")));/** column 근무시간_15일 : dilnlazDutyTm15 */
						  dlgn0110Vo.setDilnlazStTm15(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm15(),"")));/** column 출근시간_15일 : dilnlazStTm15 */
						  dlgn0110Vo.setDilnlazEdTm15(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm15(),"")));/** column 퇴근시간_15일 : dilnlazEtTm15 */
						  dlgn0110Vo.setDilnlazApptnDt15(MSFSharedUtils.defaultNulls(strDate[14],""));/**근무일 */
						  
						  dlgn0110Vo.setKubn16(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn16(),""));/** 년월 column 근무구분_16일 : kubn16 */
						  dlgn0110Vo.setDilnlazDutyTm16(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm16(),"")));/** column 근무시간_16일 : dilnlazDutyTm16 */
						  dlgn0110Vo.setDilnlazStTm16(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm16(),"")));/** column 출근시간_16일 : dilnlazStTm16 */
						  dlgn0110Vo.setDilnlazEdTm16(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm16(),"")));/** column 퇴근시간_16일 : dilnlazEtTm16 */
						  dlgn0110Vo.setDilnlazApptnDt16(MSFSharedUtils.defaultNulls(strDate[15],""));/**근무일 */
						  
						  dlgn0110Vo.setKubn17(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn17(),""));/** 년월 column 근무구분_17일 : kubn17 */
						  dlgn0110Vo.setDilnlazDutyTm17(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm17(),"")));/** column 근무시간_17일 : dilnlazDutyTm17 */
						  dlgn0110Vo.setDilnlazStTm17(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm17(),"")));/** column 출근시간_17일 : dilnlazStTm17 */
						  dlgn0110Vo.setDilnlazEdTm17(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm17(),"")));/** column 퇴근시간_17일 : dilnlazEtTm17 */
						  dlgn0110Vo.setDilnlazApptnDt17(MSFSharedUtils.defaultNulls(strDate[16],""));/**근무일 */
						  
						  dlgn0110Vo.setKubn18(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn18(),""));/** 년월 column 근무구분_18일 : kubn18 */
						  dlgn0110Vo.setDilnlazDutyTm18(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm18(),"")));/** column 근무시간_18일 : dilnlazDutyTm18 */
						  dlgn0110Vo.setDilnlazStTm18(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm18(),"")));/** column 출근시간_18일 : dilnlazStTm18 */
						  dlgn0110Vo.setDilnlazEdTm18(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm18(),"")));/** column 퇴근시간_18일 : dilnlazEtTm18 */
						  dlgn0110Vo.setDilnlazApptnDt18(MSFSharedUtils.defaultNulls(strDate[17],""));/**근무일 */
						  
						  dlgn0110Vo.setKubn19(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn19(),""));/** 년월 column 근무구분_19일 : kubn19 */
						  dlgn0110Vo.setDilnlazDutyTm19(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm19(),"")));/** column 근무시간_19일 : dilnlazDutyTm19 */
						  dlgn0110Vo.setDilnlazStTm19(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm19(),"")));/** column 출근시간_19일 : dilnlazStTm19 */
						  dlgn0110Vo.setDilnlazEdTm19(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm19(),"")));/** column 퇴근시간_19일 : dilnlazEtTm19 */
						  dlgn0110Vo.setDilnlazApptnDt19(MSFSharedUtils.defaultNulls(strDate[18],""));/**근무일 */
						  
						  dlgn0110Vo.setKubn20(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn20(),""));/** 년월 column 근무구분_20일 : kubn20 */
						  dlgn0110Vo.setDilnlazDutyTm20(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm20(),"")));/** column 근무시간_20일 : dilnlazDutyTm20 */
						  dlgn0110Vo.setDilnlazStTm20(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm20(),"")));/** column 출근시간_20일 : dilnlazStTm20 */
						  dlgn0110Vo.setDilnlazEdTm20(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm20(),"")));/** column 퇴근시간_20일 : dilnlazEtTm20 */
						  dlgn0110Vo.setDilnlazApptnDt20(MSFSharedUtils.defaultNulls(strDate[19],""));/**근무일 */
						  
						  dlgn0110Vo.setKubn21(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn21(),""));/** 년월 column 근무구분_21일 : kubn21 */
						  dlgn0110Vo.setDilnlazDutyTm21(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm21(),"")));/** column 근무시간_21일 : dilnlazDutyTm21 */
						  dlgn0110Vo.setDilnlazStTm21(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm21(),"")));/** column 출근시간_21일 : dilnlazStTm21 */
						  dlgn0110Vo.setDilnlazEdTm21(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm21(),"")));/** column 퇴근시간_21일 : dilnlazEtTm21 */
						  dlgn0110Vo.setDilnlazApptnDt21(MSFSharedUtils.defaultNulls(strDate[20],""));/**근무일 */
						  
						  dlgn0110Vo.setKubn22(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn22(),""));/** 년월 column 근무구분_22일 : kubn22 */
						  dlgn0110Vo.setDilnlazDutyTm22(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm22(),"")));/** column 근무시간_22일 : dilnlazDutyTm22 */
						  dlgn0110Vo.setDilnlazStTm22(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm22(),"")));/** column 출근시간_22일 : dilnlazStTm22 */
						  dlgn0110Vo.setDilnlazEdTm22(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm22(),"")));/** column 퇴근시간_22일 : dilnlazEtTm22 */
						  dlgn0110Vo.setDilnlazApptnDt22(MSFSharedUtils.defaultNulls(strDate[21],""));/**근무일 */
						  
						  dlgn0110Vo.setKubn23(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn23(),""));/** 년월 column 근무구분_23일 : kubn23 */
						  dlgn0110Vo.setDilnlazDutyTm23(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm23(),"")));/** column 근무시간_23일 : dilnlazDutyTm23 */
						  dlgn0110Vo.setDilnlazStTm23(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm23(),"")));/** column 출근시간_23일 : dilnlazStTm23 */
						  dlgn0110Vo.setDilnlazEdTm23(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm23(),"")));/** column 퇴근시간_23일 : dilnlazEtTm23 */
						  dlgn0110Vo.setDilnlazApptnDt23(MSFSharedUtils.defaultNulls(strDate[22],""));/**근무일 */
						  
						  dlgn0110Vo.setKubn24(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn24(),""));/** 년월 column 근무구분_24일 : kubn24 */
						  dlgn0110Vo.setDilnlazDutyTm24(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm24(),"")));/** column 근무시간_24일 : dilnlazDutyTm24 */
						  dlgn0110Vo.setDilnlazStTm24(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm24(),"")));/** column 출근시간_24일 : dilnlazStTm24 */
						  dlgn0110Vo.setDilnlazEdTm24(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm24(),"")));/** column 퇴근시간_24일 : dilnlazEtTm24 */
						  dlgn0110Vo.setDilnlazApptnDt24(MSFSharedUtils.defaultNulls(strDate[23],""));/**근무일 */
						  
						  dlgn0110Vo.setKubn25(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn25(),""));/** 년월 column 근무구분_25일 : kubn25 */
						  dlgn0110Vo.setDilnlazDutyTm25(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm25(),"")));/** column 근무시간_25일 : dilnlazDutyTm25 */
						  dlgn0110Vo.setDilnlazStTm25(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm25(),"")));/** column 출근시간_25일 : dilnlazStTm25 */
						  dlgn0110Vo.setDilnlazEdTm25(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm25(),"")));/** column 퇴근시간_25일 : dilnlazEtTm25 */
						  dlgn0110Vo.setDilnlazApptnDt25(MSFSharedUtils.defaultNulls(strDate[24],""));/**근무일 */
						  
						  dlgn0110Vo.setKubn26(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn26(),""));/** 년월 column 근무구분_26일 : kubn26 */
						  dlgn0110Vo.setDilnlazDutyTm26(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm26(),"")));/** column 근무시간_26일 : dilnlazDutyTm26 */
						  dlgn0110Vo.setDilnlazStTm26(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm26(),"")));/** column 출근시간_26일 : dilnlazStTm26 */
						  dlgn0110Vo.setDilnlazEdTm26(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm26(),"")));/** column 퇴근시간_26일 : dilnlazEtTm26 */
						  dlgn0110Vo.setDilnlazApptnDt26(MSFSharedUtils.defaultNulls(strDate[25],""));/**근무일 */
						  
						  dlgn0110Vo.setKubn27(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn27(),""));/** 년월 column 근무구분_27일 : kubn27 */
						  dlgn0110Vo.setDilnlazDutyTm27(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm27(),"")));/** column 근무시간_27일 : dilnlazDutyTm27 */
						  dlgn0110Vo.setDilnlazStTm27(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm27(),"")));/** column 출근시간_27일 : dilnlazStTm27 */
						  dlgn0110Vo.setDilnlazEdTm27(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm27(),"")));/** column 퇴근시간_27일 : dilnlazEtTm27 */
						  dlgn0110Vo.setDilnlazApptnDt27(MSFSharedUtils.defaultNulls(strDate[26],""));/**근무일 */
						  
						  dlgn0110Vo.setKubn28(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn28(),""));/** 년월 column 근무구분_28일 : kubn28 */
						  dlgn0110Vo.setDilnlazDutyTm28(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm28(),"")));/** column 근무시간_28일 : dilnlazDutyTm28 */
						  dlgn0110Vo.setDilnlazStTm28(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm28(),"")));/** column 출근시간_28일 : dilnlazStTm28 */
						  dlgn0110Vo.setDilnlazEdTm28(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm28(),"")));/** column 퇴근시간_28일 : dilnlazEtTm28 */
						  dlgn0110Vo.setDilnlazApptnDt28(MSFSharedUtils.defaultNulls(strDate[27],""));/**근무일 */
						  
						  dlgn0110Vo.setKubn29(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn29(),""));/** 년월 column 근무구분_29일 : kubn29 */
						  dlgn0110Vo.setDilnlazDutyTm29(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm29(),"")));/** column 근무시간_29일 : dilnlazDutyTm29 */
						  dlgn0110Vo.setDilnlazStTm29(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm29(),"")));/** column 출근시간_29일 : dilnlazStTm30 */
						  dlgn0110Vo.setDilnlazEdTm29(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm29(),"")));/** column 퇴근시간_29일 : dilnlazEtTm30 */
						  dlgn0110Vo.setDilnlazApptnDt29(MSFSharedUtils.defaultNulls(strDate[28],""));/**근무일 */
						  
						  dlgn0110Vo.setKubn30(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn30(),""));/** 년월 column 근무구분_30일 : kubn30 */
						  dlgn0110Vo.setDilnlazDutyTm30(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm30(),"")));/** column 근무시간_30일 : dilnlazDutyTm30 */
						  dlgn0110Vo.setDilnlazStTm30(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm30(),"")));/** column 출근시간_30일 : dilnlazStTm30 */
						  dlgn0110Vo.setDilnlazEdTm30(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm30(),"")));/** column 퇴근시간_30일 : dilnlazEtTm30 */
						  dlgn0110Vo.setDilnlazApptnDt30(MSFSharedUtils.defaultNulls(strDate[29],""));/**근무일 */
						  
						  dlgn0110Vo.setKubn31(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn31(),""));/** 년월 column 근무구분_31일 : kubn31 */
						  dlgn0110Vo.setDilnlazDutyTm31(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm31(),"")));/** column 근무시간_31일 : dilnlazDutyTm31 */
						  dlgn0110Vo.setDilnlazStTm31(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm31(),"")));/** column 출근시간_31일 : dilnlazStTm31 */
						  dlgn0110Vo.setDilnlazEdTm31(checkTimeFormat(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm31(),"")));/** column 퇴근시간_31일 : dilnlazEtTm31 */
						  dlgn0110Vo.setDilnlazApptnDt31(MSFSharedUtils.defaultNulls(strDate[30],""));/**근무일 */
						  
					      dlgn0210Vo.setDpobCd(sessionUser.getDpobCd());		//사업장코드
						  dlgn0210Vo.setPayCd(MSFSharedUtils.allowNulls(dlgn0110Vo.getPayCd()));	/** 급여구분 column 급여구분코드 : payCd */
						  dlgn0210Vo.setEmymtDivCd(MSFSharedUtils.allowNulls(dlgn0110Vo.getEmymtDivCd())); //고용구분코드
						  dlgn0210Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(dlgn0110Vo.getResnRegnNum().replaceAll("-","")),AnyCryptUtils.SEC_RRNUMC));
						  dlgn0210Vo.setDilnlazYrMnth(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazYrMnth()));/** 년월 column 근태년월 : dilnlazYrMnth */
						  dlgn0210Vo.setDilnlazApptnDt(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazApptnDt()));/** 년월 column 근무종료일자 : dilnlazDutyEndDt */
						  
						  // 쿼리함수.
						  if(!dlgn0110Vo.getKubn1().equals("")){
							  dlgn0110SaveVo = new Dlgn0110ExlVO();
							  
							  dlgn0110SaveVo.setDpobCd(sessionUser.getDpobCd());		//사업장코드
							  dlgn0110SaveVo.setIsmt(sessionUser.getUsrId());
							  dlgn0110SaveVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
							  dlgn0110SaveVo.setResnRegnNum( dlgn0110Vo.getResnRegnNum());
							  dlgn0110SaveVo.setDilnlazYrMnth(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazYrMnth()));/** 년월 column 근태년월 : dilnlazYrMnth */
							  dlgn0110SaveVo.setKubn(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn1(),""));/** 년월 column 근무구분_1일 : kubn1 */
							  dlgn0110SaveVo.setDilnlazDutyTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm1(),""));/** column 근무시간_1일 : dilnlazDutyTm1 */
							  dlgn0110SaveVo.setDilnlazStTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm1(),""));/** column 출근시간_1일 : dilnlazStTm1 */
							  dlgn0110SaveVo.setDilnlazEdTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm1(),""));/** column 퇴근시간_1일 : dilnlazEtTm1 */
							  dlgn0110SaveVo.setDilnlazApptnDt(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazApptnDt1()));/** 년월 column 근무일자 : dilnlazApptnDt */
							  
							  dlgn0110DAO.updateXlsDlgn0100(dlgn0110SaveVo);
							  //  dlgn0210DAO.updateXlsDlgn0100ToDlgn0210(dlgn0110SaveVo);
						  }
						  if(!dlgn0110Vo.getKubn2().equals("")){
							  dlgn0110SaveVo = new Dlgn0110ExlVO();
							  
							  dlgn0110SaveVo.setDpobCd(sessionUser.getDpobCd());		//사업장코드
							  dlgn0110SaveVo.setIsmt(sessionUser.getUsrId());
							  dlgn0110SaveVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
							  dlgn0110SaveVo.setResnRegnNum( dlgn0110Vo.getResnRegnNum());
							  dlgn0110SaveVo.setDilnlazYrMnth(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazYrMnth()));/** 년월 column 근태년월 : dilnlazYrMnth */
							  dlgn0110SaveVo.setKubn(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn2(),""));/** 년월 column 근무구분_1일 : kubn1 */
							  dlgn0110SaveVo.setDilnlazDutyTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm2(),""));/** column 근무시간_1일 : dilnlazDutyTm1 */
							  dlgn0110SaveVo.setDilnlazStTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm2(),""));/** column 출근시간_1일 : dilnlazStTm1 */
							  dlgn0110SaveVo.setDilnlazEdTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm2(),""));/** column 퇴근시간_1일 : dilnlazEtTm1 */
							  dlgn0110SaveVo.setDilnlazApptnDt(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazApptnDt2()));/** 년월 column 근무일자 : dilnlazApptnDt */
							 
							  dlgn0110DAO.updateXlsDlgn0100(dlgn0110SaveVo);
							  //  dlgn0210DAO.updateXlsDlgn0100ToDlgn0210(dlgn0110SaveVo);
						  }
						  if(!dlgn0110Vo.getKubn3().equals("")){
							  dlgn0110SaveVo = new Dlgn0110ExlVO();
							  
							  dlgn0110SaveVo.setDpobCd(sessionUser.getDpobCd());		//사업장코드
							  dlgn0110SaveVo.setIsmt(sessionUser.getUsrId());
							  dlgn0110SaveVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
							  dlgn0110SaveVo.setResnRegnNum( dlgn0110Vo.getResnRegnNum());
							  dlgn0110SaveVo.setDilnlazYrMnth(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazYrMnth()));/** 년월 column 근태년월 : dilnlazYrMnth */
							  dlgn0110SaveVo.setKubn(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn3(),""));/** 년월 column 근무구분_1일 : kubn1 */
							  dlgn0110SaveVo.setDilnlazDutyTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm3(),""));/** column 근무시간_1일 : dilnlazDutyTm1 */
							  dlgn0110SaveVo.setDilnlazStTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm3(),""));/** column 출근시간_1일 : dilnlazStTm1 */
							  dlgn0110SaveVo.setDilnlazEdTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm3(),""));/** column 퇴근시간_1일 : dilnlazEtTm1 */
							  dlgn0110SaveVo.setDilnlazApptnDt(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazApptnDt3()));/** 년월 column 근무일자 : dilnlazApptnDt */
							  
							  dlgn0110DAO.updateXlsDlgn0100(dlgn0110SaveVo);
							  //  dlgn0210DAO.updateXlsDlgn0100ToDlgn0210(dlgn0110SaveVo);
						  }
						  if(!dlgn0110Vo.getKubn4().equals("")){
							  dlgn0110SaveVo = new Dlgn0110ExlVO();
							  
							  dlgn0110SaveVo.setDpobCd(sessionUser.getDpobCd());		//사업장코드
							  dlgn0110SaveVo.setIsmt(sessionUser.getUsrId());
							  dlgn0110SaveVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
							  dlgn0110SaveVo.setResnRegnNum( dlgn0110Vo.getResnRegnNum());
							  dlgn0110SaveVo.setDilnlazYrMnth(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazYrMnth()));/** 년월 column 근태년월 : dilnlazYrMnth */
							  dlgn0110SaveVo.setKubn(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn4(),""));/** 년월 column 근무구분_1일 : kubn1 */
							  dlgn0110SaveVo.setDilnlazDutyTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm4(),""));/** column 근무시간_1일 : dilnlazDutyTm1 */
							  dlgn0110SaveVo.setDilnlazStTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm4(),""));/** column 출근시간_1일 : dilnlazStTm1 */
							  dlgn0110SaveVo.setDilnlazEdTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm4(),""));/** column 퇴근시간_1일 : dilnlazEtTm1 */
							  dlgn0110SaveVo.setDilnlazApptnDt(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazApptnDt4()));/** 년월 column 근무일자 : dilnlazApptnDt */
							 
							  dlgn0110DAO.updateXlsDlgn0100(dlgn0110SaveVo);
							  //  dlgn0210DAO.updateXlsDlgn0100ToDlgn0210(dlgn0110SaveVo);
						  }
						  if(!dlgn0110Vo.getKubn5().equals("")){
							  dlgn0110SaveVo = new Dlgn0110ExlVO();
							  
							  dlgn0110SaveVo.setDpobCd(sessionUser.getDpobCd());		//사업장코드
							  dlgn0110SaveVo.setIsmt(sessionUser.getUsrId());
							  dlgn0110SaveVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
							  dlgn0110SaveVo.setResnRegnNum( dlgn0110Vo.getResnRegnNum());
							  dlgn0110SaveVo.setDilnlazYrMnth(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazYrMnth()));/** 년월 column 근태년월 : dilnlazYrMnth */
							  dlgn0110SaveVo.setKubn(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn5(),""));/** 년월 column 근무구분_1일 : kubn1 */
							  dlgn0110SaveVo.setDilnlazDutyTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm5(),""));/** column 근무시간_1일 : dilnlazDutyTm1 */
							  dlgn0110SaveVo.setDilnlazStTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm5(),""));/** column 출근시간_1일 : dilnlazStTm1 */
							  dlgn0110SaveVo.setDilnlazEdTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm5(),""));/** column 퇴근시간_1일 : dilnlazEtTm1 */
							  dlgn0110SaveVo.setDilnlazApptnDt(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazApptnDt5()));/** 년월 column 근무일자 : dilnlazApptnDt */
							 
							  dlgn0110DAO.updateXlsDlgn0100(dlgn0110SaveVo);
							  //  dlgn0210DAO.updateXlsDlgn0100ToDlgn0210(dlgn0110SaveVo);
						  }
						  if(!dlgn0110Vo.getKubn6().equals("")){
							  dlgn0110SaveVo = new Dlgn0110ExlVO();
							  
							  dlgn0110SaveVo.setDpobCd(sessionUser.getDpobCd());		//사업장코드
							  dlgn0110SaveVo.setIsmt(sessionUser.getUsrId());
							  dlgn0110SaveVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
							  dlgn0110SaveVo.setResnRegnNum( dlgn0110Vo.getResnRegnNum());
							  dlgn0110SaveVo.setDilnlazYrMnth(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazYrMnth()));/** 년월 column 근태년월 : dilnlazYrMnth */
							  dlgn0110SaveVo.setKubn(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn6(),""));/** 년월 column 근무구분_1일 : kubn1 */
							  dlgn0110SaveVo.setDilnlazDutyTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm6(),""));/** column 근무시간_1일 : dilnlazDutyTm1 */
							  dlgn0110SaveVo.setDilnlazStTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm6(),""));/** column 출근시간_1일 : dilnlazStTm1 */
							  dlgn0110SaveVo.setDilnlazEdTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm6(),""));/** column 퇴근시간_1일 : dilnlazEtTm1 */
							  dlgn0110SaveVo.setDilnlazApptnDt(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazApptnDt6()));/** 년월 column 근무일자 : dilnlazApptnDt */
							 
							  dlgn0110DAO.updateXlsDlgn0100(dlgn0110SaveVo);
							  //  dlgn0210DAO.updateXlsDlgn0100ToDlgn0210(dlgn0110SaveVo);
						  }
						  if(!dlgn0110Vo.getKubn7().equals("")){
							  dlgn0110SaveVo = new Dlgn0110ExlVO();
							  
							  dlgn0110SaveVo.setDpobCd(sessionUser.getDpobCd());		//사업장코드
							  dlgn0110SaveVo.setIsmt(sessionUser.getUsrId());
							  dlgn0110SaveVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
							  dlgn0110SaveVo.setResnRegnNum( dlgn0110Vo.getResnRegnNum());
							  dlgn0110SaveVo.setDilnlazYrMnth(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazYrMnth()));/** 년월 column 근태년월 : dilnlazYrMnth */
							  dlgn0110SaveVo.setKubn(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn7(),""));/** 년월 column 근무구분_1일 : kubn1 */
							  dlgn0110SaveVo.setDilnlazDutyTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm7(),""));/** column 근무시간_1일 : dilnlazDutyTm1 */
							  dlgn0110SaveVo.setDilnlazStTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm7(),""));/** column 출근시간_1일 : dilnlazStTm1 */
							  dlgn0110SaveVo.setDilnlazEdTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm7(),""));/** column 퇴근시간_1일 : dilnlazEtTm1 */
							  dlgn0110SaveVo.setDilnlazApptnDt(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazApptnDt7()));/** 년월 column 근무일자 : dilnlazApptnDt */
							 
							  dlgn0110DAO.updateXlsDlgn0100(dlgn0110SaveVo);
							  //  dlgn0210DAO.updateXlsDlgn0100ToDlgn0210(dlgn0110SaveVo);
						  }
						  if(!dlgn0110Vo.getKubn8().equals("")){
							  dlgn0110SaveVo = new Dlgn0110ExlVO();
							  
							  dlgn0110SaveVo.setDpobCd(sessionUser.getDpobCd());		//사업장코드
							  dlgn0110SaveVo.setIsmt(sessionUser.getUsrId());
							  dlgn0110SaveVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
							  dlgn0110SaveVo.setResnRegnNum( dlgn0110Vo.getResnRegnNum());
							  dlgn0110SaveVo.setDilnlazYrMnth(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazYrMnth()));/** 년월 column 근태년월 : dilnlazYrMnth */
							  dlgn0110SaveVo.setKubn(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn8(),""));/** 년월 column 근무구분_1일 : kubn1 */
							  dlgn0110SaveVo.setDilnlazDutyTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm8(),""));/** column 근무시간_1일 : dilnlazDutyTm1 */
							  dlgn0110SaveVo.setDilnlazStTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm8(),""));/** column 출근시간_1일 : dilnlazStTm1 */
							  dlgn0110SaveVo.setDilnlazEdTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm8(),""));/** column 퇴근시간_1일 : dilnlazEtTm1 */
							  dlgn0110SaveVo.setDilnlazApptnDt(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazApptnDt8()));/** 년월 column 근무일자 : dilnlazApptnDt */
							 
							  dlgn0110DAO.updateXlsDlgn0100(dlgn0110SaveVo);
							  //  dlgn0210DAO.updateXlsDlgn0100ToDlgn0210(dlgn0110SaveVo);
						  }
						  if(!dlgn0110Vo.getKubn9().equals("")){
							  dlgn0110SaveVo = new Dlgn0110ExlVO();
							  
							  dlgn0110SaveVo.setDpobCd(sessionUser.getDpobCd());		//사업장코드
							  dlgn0110SaveVo.setIsmt(sessionUser.getUsrId());
							  dlgn0110SaveVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
							  dlgn0110SaveVo.setResnRegnNum( dlgn0110Vo.getResnRegnNum());
							  dlgn0110SaveVo.setDilnlazYrMnth(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazYrMnth()));/** 년월 column 근태년월 : dilnlazYrMnth */
							  dlgn0110SaveVo.setKubn(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn9(),""));/** 년월 column 근무구분_1일 : kubn1 */
							  dlgn0110SaveVo.setDilnlazDutyTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm9(),""));/** column 근무시간_1일 : dilnlazDutyTm1 */
							  dlgn0110SaveVo.setDilnlazStTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm9(),""));/** column 출근시간_1일 : dilnlazStTm1 */
							  dlgn0110SaveVo.setDilnlazEdTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm9(),""));/** column 퇴근시간_1일 : dilnlazEtTm1 */
							  dlgn0110SaveVo.setDilnlazApptnDt(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazApptnDt9()));/** 년월 column 근무일자 : dilnlazApptnDt */
							 
							  dlgn0110DAO.updateXlsDlgn0100(dlgn0110SaveVo);
							  //  dlgn0210DAO.updateXlsDlgn0100ToDlgn0210(dlgn0110SaveVo);
						  }
						  if(!dlgn0110Vo.getKubn10().equals("")){
							  dlgn0110SaveVo = new Dlgn0110ExlVO();
							  
							  dlgn0110SaveVo.setDpobCd(sessionUser.getDpobCd());		//사업장코드
							  dlgn0110SaveVo.setIsmt(sessionUser.getUsrId());
							  dlgn0110SaveVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
							  dlgn0110SaveVo.setResnRegnNum( dlgn0110Vo.getResnRegnNum());
							  dlgn0110SaveVo.setDilnlazYrMnth(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazYrMnth()));/** 년월 column 근태년월 : dilnlazYrMnth */
							  dlgn0110SaveVo.setKubn(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn10(),""));/** 년월 column 근무구분_1일 : kubn1 */
							  dlgn0110SaveVo.setDilnlazDutyTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm10(),""));/** column 근무시간_1일 : dilnlazDutyTm1 */
							  dlgn0110SaveVo.setDilnlazStTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm10(),""));/** column 출근시간_1일 : dilnlazStTm1 */
							  dlgn0110SaveVo.setDilnlazEdTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm10(),""));/** column 퇴근시간_1일 : dilnlazEtTm1 */
							  dlgn0110SaveVo.setDilnlazApptnDt(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazApptnDt10()));/** 년월 column 근무일자 : dilnlazApptnDt */
							 
							  dlgn0110DAO.updateXlsDlgn0100(dlgn0110SaveVo);
							  //  dlgn0210DAO.updateXlsDlgn0100ToDlgn0210(dlgn0110SaveVo);
						  }
						  if(!dlgn0110Vo.getKubn11().equals("")){
							  dlgn0110SaveVo = new Dlgn0110ExlVO();
							  
							  dlgn0110SaveVo.setDpobCd(sessionUser.getDpobCd());		//사업장코드
							  dlgn0110SaveVo.setIsmt(sessionUser.getUsrId());
							  dlgn0110SaveVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
							  dlgn0110SaveVo.setResnRegnNum( dlgn0110Vo.getResnRegnNum());
							  dlgn0110SaveVo.setDilnlazYrMnth(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazYrMnth()));/** 년월 column 근태년월 : dilnlazYrMnth */
							  dlgn0110SaveVo.setKubn(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn11(),""));/** 년월 column 근무구분_1일 : kubn1 */
							  dlgn0110SaveVo.setDilnlazDutyTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm11(),""));/** column 근무시간_1일 : dilnlazDutyTm1 */
							  dlgn0110SaveVo.setDilnlazStTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm11(),""));/** column 출근시간_1일 : dilnlazStTm1 */
							  dlgn0110SaveVo.setDilnlazEdTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm11(),""));/** column 퇴근시간_1일 : dilnlazEtTm1 */
							  dlgn0110SaveVo.setDilnlazApptnDt(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazApptnDt11()));/** 년월 column 근무일자 : dilnlazApptnDt */
							 
							  dlgn0110DAO.updateXlsDlgn0100(dlgn0110SaveVo);
							  //  dlgn0210DAO.updateXlsDlgn0100ToDlgn0210(dlgn0110SaveVo);
						  }
						  if(!dlgn0110Vo.getKubn12().equals("")){
							  dlgn0110SaveVo = new Dlgn0110ExlVO();
							  
							  dlgn0110SaveVo.setDpobCd(sessionUser.getDpobCd());		//사업장코드
							  dlgn0110SaveVo.setIsmt(sessionUser.getUsrId());
							  dlgn0110SaveVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
							  dlgn0110SaveVo.setResnRegnNum( dlgn0110Vo.getResnRegnNum());
							  dlgn0110SaveVo.setDilnlazYrMnth(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazYrMnth()));/** 년월 column 근태년월 : dilnlazYrMnth */
							  dlgn0110SaveVo.setKubn(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn12(),""));/** 년월 column 근무구분_1일 : kubn1 */
							  dlgn0110SaveVo.setDilnlazDutyTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm12(),""));/** column 근무시간_1일 : dilnlazDutyTm1 */
							  dlgn0110SaveVo.setDilnlazStTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm12(),""));/** column 출근시간_1일 : dilnlazStTm1 */
							  dlgn0110SaveVo.setDilnlazEdTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm12(),""));/** column 퇴근시간_1일 : dilnlazEtTm1 */
							  dlgn0110SaveVo.setDilnlazApptnDt(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazApptnDt12()));/** 년월 column 근무일자 : dilnlazApptnDt */
							 
							  dlgn0110DAO.updateXlsDlgn0100(dlgn0110SaveVo);
							  //  dlgn0210DAO.updateXlsDlgn0100ToDlgn0210(dlgn0110SaveVo);
						  }
						  if(!dlgn0110Vo.getKubn13().equals("")){
							  dlgn0110SaveVo = new Dlgn0110ExlVO();
							  
							  dlgn0110SaveVo.setDpobCd(sessionUser.getDpobCd());		//사업장코드
							  dlgn0110SaveVo.setIsmt(sessionUser.getUsrId());
							  dlgn0110SaveVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
							  dlgn0110SaveVo.setResnRegnNum( dlgn0110Vo.getResnRegnNum());
							  dlgn0110SaveVo.setDilnlazYrMnth(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazYrMnth()));/** 년월 column 근태년월 : dilnlazYrMnth */
							  dlgn0110SaveVo.setKubn(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn13(),""));/** 년월 column 근무구분_1일 : kubn1 */
							  dlgn0110SaveVo.setDilnlazDutyTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm13(),""));/** column 근무시간_1일 : dilnlazDutyTm1 */
							  dlgn0110SaveVo.setDilnlazStTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm13(),""));/** column 출근시간_1일 : dilnlazStTm1 */
							  dlgn0110SaveVo.setDilnlazEdTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm13(),""));/** column 퇴근시간_1일 : dilnlazEtTm1 */
							  dlgn0110SaveVo.setDilnlazApptnDt(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazApptnDt13()));/** 년월 column 근무일자 : dilnlazApptnDt */
							 
							  dlgn0110DAO.updateXlsDlgn0100(dlgn0110SaveVo);
							  //  dlgn0210DAO.updateXlsDlgn0100ToDlgn0210(dlgn0110SaveVo);
						  }
						  if(!dlgn0110Vo.getKubn14().equals("")){
							  dlgn0110SaveVo = new Dlgn0110ExlVO();
							  
							  dlgn0110SaveVo.setDpobCd(sessionUser.getDpobCd());		//사업장코드
							  dlgn0110SaveVo.setIsmt(sessionUser.getUsrId());
							  dlgn0110SaveVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
							  dlgn0110SaveVo.setResnRegnNum( dlgn0110Vo.getResnRegnNum());
							  dlgn0110SaveVo.setDilnlazYrMnth(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazYrMnth()));/** 년월 column 근태년월 : dilnlazYrMnth */
							  dlgn0110SaveVo.setKubn(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn14(),""));/** 년월 column 근무구분_1일 : kubn1 */
							  dlgn0110SaveVo.setDilnlazDutyTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm14(),""));/** column 근무시간_1일 : dilnlazDutyTm1 */
							  dlgn0110SaveVo.setDilnlazStTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm14(),""));/** column 출근시간_1일 : dilnlazStTm1 */
							  dlgn0110SaveVo.setDilnlazEdTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm14(),""));/** column 퇴근시간_1일 : dilnlazEtTm1 */
							  dlgn0110SaveVo.setDilnlazApptnDt(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazApptnDt14()));/** 년월 column 근무일자 : dilnlazApptnDt */
							 
							  dlgn0110DAO.updateXlsDlgn0100(dlgn0110SaveVo);
							  //  dlgn0210DAO.updateXlsDlgn0100ToDlgn0210(dlgn0110SaveVo);
						  }
						  if(!dlgn0110Vo.getKubn15().equals("")){
							  dlgn0110SaveVo = new Dlgn0110ExlVO();
							  
							  dlgn0110SaveVo.setDpobCd(sessionUser.getDpobCd());		//사업장코드
							  dlgn0110SaveVo.setIsmt(sessionUser.getUsrId());
							  dlgn0110SaveVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
							  dlgn0110SaveVo.setResnRegnNum( dlgn0110Vo.getResnRegnNum());
							  dlgn0110SaveVo.setDilnlazYrMnth(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazYrMnth()));/** 년월 column 근태년월 : dilnlazYrMnth */
							  dlgn0110SaveVo.setKubn(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn15(),""));/** 년월 column 근무구분_1일 : kubn1 */
							  dlgn0110SaveVo.setDilnlazDutyTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm15(),""));/** column 근무시간_1일 : dilnlazDutyTm1 */
							  dlgn0110SaveVo.setDilnlazStTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm15(),""));/** column 출근시간_1일 : dilnlazStTm1 */
							  dlgn0110SaveVo.setDilnlazEdTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm15(),""));/** column 퇴근시간_1일 : dilnlazEtTm1 */
							  dlgn0110SaveVo.setDilnlazApptnDt(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazApptnDt15()));/** 년월 column 근무일자 : dilnlazApptnDt */
							 
							  dlgn0110DAO.updateXlsDlgn0100(dlgn0110SaveVo);
							  //  dlgn0210DAO.updateXlsDlgn0100ToDlgn0210(dlgn0110SaveVo);
						  }
						  if(!dlgn0110Vo.getKubn16().equals("")){
							  dlgn0110SaveVo = new Dlgn0110ExlVO();
							  
							  dlgn0110SaveVo.setDpobCd(sessionUser.getDpobCd());		//사업장코드
							  dlgn0110SaveVo.setIsmt(sessionUser.getUsrId());
							  dlgn0110SaveVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
							  dlgn0110SaveVo.setResnRegnNum( dlgn0110Vo.getResnRegnNum());
							  dlgn0110SaveVo.setDilnlazYrMnth(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazYrMnth()));/** 년월 column 근태년월 : dilnlazYrMnth */
							  dlgn0110SaveVo.setKubn(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn16(),""));/** 년월 column 근무구분_1일 : kubn1 */
							  dlgn0110SaveVo.setDilnlazDutyTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm16(),""));/** column 근무시간_1일 : dilnlazDutyTm1 */
							  dlgn0110SaveVo.setDilnlazStTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm16(),""));/** column 출근시간_1일 : dilnlazStTm1 */
							  dlgn0110SaveVo.setDilnlazEdTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm16(),""));/** column 퇴근시간_1일 : dilnlazEtTm1 */
							  dlgn0110SaveVo.setDilnlazApptnDt(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazApptnDt16()));/** 년월 column 근무일자 : dilnlazApptnDt */
							 
							  dlgn0110DAO.updateXlsDlgn0100(dlgn0110SaveVo);
							  //  dlgn0210DAO.updateXlsDlgn0100ToDlgn0210(dlgn0110SaveVo);
						  }
						  if(!dlgn0110Vo.getKubn17().equals("")){
							  dlgn0110SaveVo = new Dlgn0110ExlVO();
							  
							  dlgn0110SaveVo.setDpobCd(sessionUser.getDpobCd());		//사업장코드
							  dlgn0110SaveVo.setIsmt(sessionUser.getUsrId());
							  dlgn0110SaveVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
							  dlgn0110SaveVo.setResnRegnNum( dlgn0110Vo.getResnRegnNum());
							  dlgn0110SaveVo.setDilnlazYrMnth(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazYrMnth()));/** 년월 column 근태년월 : dilnlazYrMnth */
							  dlgn0110SaveVo.setKubn(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn17(),""));/** 년월 column 근무구분_1일 : kubn1 */
							  dlgn0110SaveVo.setDilnlazDutyTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm17(),""));/** column 근무시간_1일 : dilnlazDutyTm1 */
							  dlgn0110SaveVo.setDilnlazStTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm17(),""));/** column 출근시간_1일 : dilnlazStTm1 */
							  dlgn0110SaveVo.setDilnlazEdTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm17(),""));/** column 퇴근시간_1일 : dilnlazEtTm1 */
							  dlgn0110SaveVo.setDilnlazApptnDt(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazApptnDt17()));/** 년월 column 근무일자 : dilnlazApptnDt */
							 
							  dlgn0110DAO.updateXlsDlgn0100(dlgn0110SaveVo);
							  //  dlgn0210DAO.updateXlsDlgn0100ToDlgn0210(dlgn0110SaveVo);
						  }
						  if(!dlgn0110Vo.getKubn18().equals("")){
							  dlgn0110SaveVo = new Dlgn0110ExlVO();
							  
							  dlgn0110SaveVo.setDpobCd(sessionUser.getDpobCd());		//사업장코드
							  dlgn0110SaveVo.setIsmt(sessionUser.getUsrId());
							  dlgn0110SaveVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
							  dlgn0110SaveVo.setResnRegnNum( dlgn0110Vo.getResnRegnNum());
							  dlgn0110SaveVo.setDilnlazYrMnth(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazYrMnth()));/** 년월 column 근태년월 : dilnlazYrMnth */
							  dlgn0110SaveVo.setKubn(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn18(),""));/** 년월 column 근무구분_1일 : kubn1 */
							  dlgn0110SaveVo.setDilnlazDutyTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm18(),""));/** column 근무시간_1일 : dilnlazDutyTm1 */
							  dlgn0110SaveVo.setDilnlazStTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm18(),""));/** column 출근시간_1일 : dilnlazStTm1 */
							  dlgn0110SaveVo.setDilnlazEdTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm18(),""));/** column 퇴근시간_1일 : dilnlazEtTm1 */
							  dlgn0110SaveVo.setDilnlazApptnDt(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazApptnDt18()));/** 년월 column 근무일자 : dilnlazApptnDt */
							 
							  dlgn0110DAO.updateXlsDlgn0100(dlgn0110SaveVo);
							  //  dlgn0210DAO.updateXlsDlgn0100ToDlgn0210(dlgn0110SaveVo);
						  }
						  if(!dlgn0110Vo.getKubn19().equals("")){
							  dlgn0110SaveVo = new Dlgn0110ExlVO();
							  
							  dlgn0110SaveVo.setDpobCd(sessionUser.getDpobCd());		//사업장코드
							  dlgn0110SaveVo.setIsmt(sessionUser.getUsrId());
							  dlgn0110SaveVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
							  dlgn0110SaveVo.setResnRegnNum( dlgn0110Vo.getResnRegnNum());
							  dlgn0110SaveVo.setDilnlazYrMnth(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazYrMnth()));/** 년월 column 근태년월 : dilnlazYrMnth */
							  dlgn0110SaveVo.setKubn(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn19(),""));/** 년월 column 근무구분_1일 : kubn1 */
							  dlgn0110SaveVo.setDilnlazDutyTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm19(),""));/** column 근무시간_1일 : dilnlazDutyTm1 */
							  dlgn0110SaveVo.setDilnlazStTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm19(),""));/** column 출근시간_1일 : dilnlazStTm1 */
							  dlgn0110SaveVo.setDilnlazEdTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm19(),""));/** column 퇴근시간_1일 : dilnlazEtTm1 */
							  dlgn0110SaveVo.setDilnlazApptnDt(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazApptnDt19()));/** 년월 column 근무일자 : dilnlazApptnDt */
							 
							  dlgn0110DAO.updateXlsDlgn0100(dlgn0110SaveVo);
							  //  dlgn0210DAO.updateXlsDlgn0100ToDlgn0210(dlgn0110SaveVo);
						  }
						  if(!dlgn0110Vo.getKubn20().equals("")){
							  dlgn0110SaveVo = new Dlgn0110ExlVO();
							  
							  dlgn0110SaveVo.setDpobCd(sessionUser.getDpobCd());		//사업장코드
							  dlgn0110SaveVo.setIsmt(sessionUser.getUsrId());
							  dlgn0110SaveVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
							  dlgn0110SaveVo.setResnRegnNum( dlgn0110Vo.getResnRegnNum());
							  dlgn0110SaveVo.setDilnlazYrMnth(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazYrMnth()));/** 년월 column 근태년월 : dilnlazYrMnth */
							  dlgn0110SaveVo.setKubn(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn20(),""));/** 년월 column 근무구분_1일 : kubn1 */
							  dlgn0110SaveVo.setDilnlazDutyTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm20(),""));/** column 근무시간_1일 : dilnlazDutyTm1 */
							  dlgn0110SaveVo.setDilnlazStTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm20(),""));/** column 출근시간_1일 : dilnlazStTm1 */
							  dlgn0110SaveVo.setDilnlazEdTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm20(),""));/** column 퇴근시간_1일 : dilnlazEtTm1 */
							  dlgn0110SaveVo.setDilnlazApptnDt(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazApptnDt20()));/** 년월 column 근무일자 : dilnlazApptnDt */
							 
							  dlgn0110DAO.updateXlsDlgn0100(dlgn0110SaveVo);
							  //  dlgn0210DAO.updateXlsDlgn0100ToDlgn0210(dlgn0110SaveVo);
						  }
						  if(!dlgn0110Vo.getKubn21().equals("")){
							  dlgn0110SaveVo = new Dlgn0110ExlVO();
							  
							  dlgn0110SaveVo.setDpobCd(sessionUser.getDpobCd());		//사업장코드
							  dlgn0110SaveVo.setIsmt(sessionUser.getUsrId());
							  dlgn0110SaveVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
							  dlgn0110SaveVo.setResnRegnNum( dlgn0110Vo.getResnRegnNum());
							  dlgn0110SaveVo.setDilnlazYrMnth(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazYrMnth()));/** 년월 column 근태년월 : dilnlazYrMnth */
							  dlgn0110SaveVo.setKubn(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn21(),""));/** 년월 column 근무구분_1일 : kubn1 */
							  dlgn0110SaveVo.setDilnlazDutyTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm21(),""));/** column 근무시간_1일 : dilnlazDutyTm1 */
							  dlgn0110SaveVo.setDilnlazStTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm21(),""));/** column 출근시간_1일 : dilnlazStTm1 */
							  dlgn0110SaveVo.setDilnlazEdTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm21(),""));/** column 퇴근시간_1일 : dilnlazEtTm1 */
							  dlgn0110SaveVo.setDilnlazApptnDt(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazApptnDt21()));/** 년월 column 근무일자 : dilnlazApptnDt */
							 
							  dlgn0110DAO.updateXlsDlgn0100(dlgn0110SaveVo);
							  //  dlgn0210DAO.updateXlsDlgn0100ToDlgn0210(dlgn0110SaveVo);
						  }
						  if(!dlgn0110Vo.getKubn22().equals("")){
							  dlgn0110SaveVo = new Dlgn0110ExlVO();
							  
							  dlgn0110SaveVo.setDpobCd(sessionUser.getDpobCd());		//사업장코드
							  dlgn0110SaveVo.setIsmt(sessionUser.getUsrId());
							  dlgn0110SaveVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
							  dlgn0110SaveVo.setResnRegnNum( dlgn0110Vo.getResnRegnNum());
							  dlgn0110SaveVo.setDilnlazYrMnth(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazYrMnth()));/** 년월 column 근태년월 : dilnlazYrMnth */
							  dlgn0110SaveVo.setKubn(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn22(),""));/** 년월 column 근무구분_1일 : kubn1 */
							  dlgn0110SaveVo.setDilnlazDutyTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm22(),""));/** column 근무시간_1일 : dilnlazDutyTm1 */
							  dlgn0110SaveVo.setDilnlazStTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm22(),""));/** column 출근시간_1일 : dilnlazStTm1 */
							  dlgn0110SaveVo.setDilnlazEdTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm22(),""));/** column 퇴근시간_1일 : dilnlazEtTm1 */
							  dlgn0110SaveVo.setDilnlazApptnDt(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazApptnDt22()));/** 년월 column 근무일자 : dilnlazApptnDt */
							 
							  dlgn0110DAO.updateXlsDlgn0100(dlgn0110SaveVo);
							  //  dlgn0210DAO.updateXlsDlgn0100ToDlgn0210(dlgn0110SaveVo);
						  }
						  if(!dlgn0110Vo.getKubn23().equals("")){
							  dlgn0110SaveVo = new Dlgn0110ExlVO();
							  
							  dlgn0110SaveVo.setDpobCd(sessionUser.getDpobCd());		//사업장코드
							  dlgn0110SaveVo.setIsmt(sessionUser.getUsrId());
							  dlgn0110SaveVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
							  dlgn0110SaveVo.setResnRegnNum( dlgn0110Vo.getResnRegnNum());
							  dlgn0110SaveVo.setDilnlazYrMnth(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazYrMnth()));/** 년월 column 근태년월 : dilnlazYrMnth */
							  dlgn0110SaveVo.setKubn(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn23(),""));/** 년월 column 근무구분_1일 : kubn1 */
							  dlgn0110SaveVo.setDilnlazDutyTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm23(),""));/** column 근무시간_1일 : dilnlazDutyTm1 */
							  dlgn0110SaveVo.setDilnlazStTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm23(),""));/** column 출근시간_1일 : dilnlazStTm1 */
							  dlgn0110SaveVo.setDilnlazEdTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm23(),""));/** column 퇴근시간_1일 : dilnlazEtTm1 */
							  dlgn0110SaveVo.setDilnlazApptnDt(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazApptnDt23()));/** 년월 column 근무일자 : dilnlazApptnDt */
							 
							  dlgn0110DAO.updateXlsDlgn0100(dlgn0110SaveVo);
							  //  dlgn0210DAO.updateXlsDlgn0100ToDlgn0210(dlgn0110SaveVo);
						  }
						  if(!dlgn0110Vo.getKubn24().equals("")){
							  dlgn0110SaveVo = new Dlgn0110ExlVO();
							  
							  dlgn0110SaveVo.setDpobCd(sessionUser.getDpobCd());		//사업장코드
							  dlgn0110SaveVo.setIsmt(sessionUser.getUsrId());
							  dlgn0110SaveVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
							  dlgn0110SaveVo.setResnRegnNum( dlgn0110Vo.getResnRegnNum());
							  dlgn0110SaveVo.setDilnlazYrMnth(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazYrMnth()));/** 년월 column 근태년월 : dilnlazYrMnth */
							  dlgn0110SaveVo.setKubn(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn24(),""));/** 년월 column 근무구분_1일 : kubn1 */
							  dlgn0110SaveVo.setDilnlazDutyTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm24(),""));/** column 근무시간_1일 : dilnlazDutyTm1 */
							  dlgn0110SaveVo.setDilnlazStTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm24(),""));/** column 출근시간_1일 : dilnlazStTm1 */
							  dlgn0110SaveVo.setDilnlazEdTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm24(),""));/** column 퇴근시간_1일 : dilnlazEtTm1 */
							  dlgn0110SaveVo.setDilnlazApptnDt(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazApptnDt24()));/** 년월 column 근무일자 : dilnlazApptnDt */
							 
							  dlgn0110DAO.updateXlsDlgn0100(dlgn0110SaveVo);
							  //  dlgn0210DAO.updateXlsDlgn0100ToDlgn0210(dlgn0110SaveVo);
						  }
						  if(!dlgn0110Vo.getKubn25().equals("")){
							  dlgn0110SaveVo = new Dlgn0110ExlVO();
							  
							  dlgn0110SaveVo.setDpobCd(sessionUser.getDpobCd());		//사업장코드
							  dlgn0110SaveVo.setIsmt(sessionUser.getUsrId());
							  dlgn0110SaveVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
							  dlgn0110SaveVo.setResnRegnNum( dlgn0110Vo.getResnRegnNum());
							  dlgn0110SaveVo.setDilnlazYrMnth(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazYrMnth()));/** 년월 column 근태년월 : dilnlazYrMnth */
							  dlgn0110SaveVo.setKubn(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn25(),""));/** 년월 column 근무구분_1일 : kubn1 */
							  dlgn0110SaveVo.setDilnlazDutyTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm25(),""));/** column 근무시간_1일 : dilnlazDutyTm1 */
							  dlgn0110SaveVo.setDilnlazStTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm25(),""));/** column 출근시간_1일 : dilnlazStTm1 */
							  dlgn0110SaveVo.setDilnlazEdTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm25(),""));/** column 퇴근시간_1일 : dilnlazEtTm1 */
							  dlgn0110SaveVo.setDilnlazApptnDt(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazApptnDt25()));/** 년월 column 근무일자 : dilnlazApptnDt */
							 
							  dlgn0110DAO.updateXlsDlgn0100(dlgn0110SaveVo);
							  //  dlgn0210DAO.updateXlsDlgn0100ToDlgn0210(dlgn0110SaveVo);
						  }
						  if(!dlgn0110Vo.getKubn26().equals("")){
							  dlgn0110SaveVo = new Dlgn0110ExlVO();
							  
							  dlgn0110SaveVo.setDpobCd(sessionUser.getDpobCd());		//사업장코드
							  dlgn0110SaveVo.setIsmt(sessionUser.getUsrId());
							  dlgn0110SaveVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
							  dlgn0110SaveVo.setResnRegnNum( dlgn0110Vo.getResnRegnNum());
							  dlgn0110SaveVo.setDilnlazYrMnth(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazYrMnth()));/** 년월 column 근태년월 : dilnlazYrMnth */
							  dlgn0110SaveVo.setKubn(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn26(),""));/** 년월 column 근무구분_1일 : kubn1 */
							  dlgn0110SaveVo.setDilnlazDutyTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm26(),""));/** column 근무시간_1일 : dilnlazDutyTm1 */
							  dlgn0110SaveVo.setDilnlazStTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm26(),""));/** column 출근시간_1일 : dilnlazStTm1 */
							  dlgn0110SaveVo.setDilnlazEdTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm26(),""));/** column 퇴근시간_1일 : dilnlazEtTm1 */
							  dlgn0110SaveVo.setDilnlazApptnDt(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazApptnDt26()));/** 년월 column 근무일자 : dilnlazApptnDt */
							 
							  dlgn0110DAO.updateXlsDlgn0100(dlgn0110SaveVo);
							  //  dlgn0210DAO.updateXlsDlgn0100ToDlgn0210(dlgn0110SaveVo);
						  }
						  if(!dlgn0110Vo.getKubn27().equals("")){
							  dlgn0110SaveVo = new Dlgn0110ExlVO();
							  
							  dlgn0110SaveVo.setDpobCd(sessionUser.getDpobCd());		//사업장코드
							  dlgn0110SaveVo.setIsmt(sessionUser.getUsrId());
							  dlgn0110SaveVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
							  dlgn0110SaveVo.setResnRegnNum( dlgn0110Vo.getResnRegnNum());
							  dlgn0110SaveVo.setDilnlazYrMnth(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazYrMnth()));/** 년월 column 근태년월 : dilnlazYrMnth */
							  dlgn0110SaveVo.setKubn(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn27(),""));/** 년월 column 근무구분_1일 : kubn1 */
							  dlgn0110SaveVo.setDilnlazDutyTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm27(),""));/** column 근무시간_1일 : dilnlazDutyTm1 */
							  dlgn0110SaveVo.setDilnlazStTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm27(),""));/** column 출근시간_1일 : dilnlazStTm1 */
							  dlgn0110SaveVo.setDilnlazEdTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm27(),""));/** column 퇴근시간_1일 : dilnlazEtTm1 */
							  dlgn0110SaveVo.setDilnlazApptnDt(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazApptnDt27()));/** 년월 column 근무일자 : dilnlazApptnDt */
							  
							  dlgn0110DAO.updateXlsDlgn0100(dlgn0110SaveVo);
						      //  dlgn0210DAO.updateXlsDlgn0100ToDlgn0210(dlgn0110SaveVo);
						  }
						  if(!dlgn0110Vo.getKubn28().equals("")){
							  dlgn0110SaveVo = new Dlgn0110ExlVO();
							  
							  dlgn0110SaveVo.setDpobCd(sessionUser.getDpobCd());		//사업장코드
							  dlgn0110SaveVo.setIsmt(sessionUser.getUsrId());
							  dlgn0110SaveVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
							  dlgn0110SaveVo.setResnRegnNum( dlgn0110Vo.getResnRegnNum());
							  dlgn0110SaveVo.setDilnlazYrMnth(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazYrMnth()));/** 년월 column 근태년월 : dilnlazYrMnth */
							  dlgn0110SaveVo.setKubn(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn28(),""));/** 년월 column 근무구분_1일 : kubn1 */
							  dlgn0110SaveVo.setDilnlazDutyTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm28(),""));/** column 근무시간_1일 : dilnlazDutyTm1 */
							  dlgn0110SaveVo.setDilnlazStTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm28(),""));/** column 출근시간_1일 : dilnlazStTm1 */
							  dlgn0110SaveVo.setDilnlazEdTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm28(),""));/** column 퇴근시간_1일 : dilnlazEtTm1 */
							  dlgn0110SaveVo.setDilnlazApptnDt(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazApptnDt28()));/** 년월 column 근무일자 : dilnlazApptnDt */
							 
							  dlgn0110DAO.updateXlsDlgn0100(dlgn0110SaveVo);
							  //  dlgn0210DAO.updateXlsDlgn0100ToDlgn0210(dlgn0110SaveVo);
						  }
						  if(!dlgn0110Vo.getKubn29().equals("")){
							  dlgn0110SaveVo = new Dlgn0110ExlVO();
							  
							  dlgn0110SaveVo.setDpobCd(sessionUser.getDpobCd());		//사업장코드
							  dlgn0110SaveVo.setIsmt(sessionUser.getUsrId());
							  dlgn0110SaveVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
							  dlgn0110SaveVo.setResnRegnNum( dlgn0110Vo.getResnRegnNum());
							  dlgn0110SaveVo.setDilnlazYrMnth(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazYrMnth()));/** 년월 column 근태년월 : dilnlazYrMnth */
							  dlgn0110SaveVo.setKubn(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn29(),""));/** 년월 column 근무구분_1일 : kubn1 */
							  dlgn0110SaveVo.setDilnlazDutyTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm29(),""));/** column 근무시간_1일 : dilnlazDutyTm1 */
							  dlgn0110SaveVo.setDilnlazStTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm29(),""));/** column 출근시간_1일 : dilnlazStTm1 */
							  dlgn0110SaveVo.setDilnlazEdTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm29(),""));/** column 퇴근시간_1일 : dilnlazEtTm1 */
							  dlgn0110SaveVo.setDilnlazApptnDt(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazApptnDt29()));/** 년월 column 근무일자 : dilnlazApptnDt */
							 
							  dlgn0110DAO.updateXlsDlgn0100(dlgn0110SaveVo);
							  //  dlgn0210DAO.updateXlsDlgn0100ToDlgn0210(dlgn0110SaveVo);
						  }
						  if(!dlgn0110Vo.getKubn30().equals("")){
							  dlgn0110SaveVo = new Dlgn0110ExlVO();
							  
							  dlgn0110SaveVo.setDpobCd(sessionUser.getDpobCd());		//사업장코드
							  dlgn0110SaveVo.setIsmt(sessionUser.getUsrId());
							  dlgn0110SaveVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
							  dlgn0110SaveVo.setResnRegnNum( dlgn0110Vo.getResnRegnNum());
							  dlgn0110SaveVo.setDilnlazYrMnth(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazYrMnth()));/** 년월 column 근태년월 : dilnlazYrMnth */
							  dlgn0110SaveVo.setKubn(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn30(),""));/** 년월 column 근무구분_1일 : kubn1 */
							  dlgn0110SaveVo.setDilnlazDutyTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm30(),""));/** column 근무시간_1일 : dilnlazDutyTm1 */
							  dlgn0110SaveVo.setDilnlazStTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm30(),""));/** column 출근시간_1일 : dilnlazStTm1 */
							  dlgn0110SaveVo.setDilnlazEdTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm30(),""));/** column 퇴근시간_1일 : dilnlazEtTm1 */
							  dlgn0110SaveVo.setDilnlazApptnDt(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazApptnDt30()));/** 년월 column 근무일자 : dilnlazApptnDt */
							 
							  dlgn0110DAO.updateXlsDlgn0100(dlgn0110SaveVo);
							  //  dlgn0210DAO.updateXlsDlgn0100ToDlgn0210(dlgn0110SaveVo);
						  }
						  if(!dlgn0110Vo.getKubn31().equals("")){
							  dlgn0110SaveVo = new Dlgn0110ExlVO();
							  
							  dlgn0110SaveVo.setDpobCd(sessionUser.getDpobCd());		//사업장코드
							  dlgn0110SaveVo.setIsmt(sessionUser.getUsrId());
							  dlgn0110SaveVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
							  dlgn0110SaveVo.setResnRegnNum( dlgn0110Vo.getResnRegnNum());
							  dlgn0110SaveVo.setDilnlazYrMnth(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazYrMnth()));/** 년월 column 근태년월 : dilnlazYrMnth */
							  dlgn0110SaveVo.setKubn(MSFSharedUtils.defaultNulls(dlgn0110Vo.getKubn31(),""));/** 년월 column 근무구분_1일 : kubn1 */
							  dlgn0110SaveVo.setDilnlazDutyTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazDutyTm31(),""));/** column 근무시간_1일 : dilnlazDutyTm1 */
							  dlgn0110SaveVo.setDilnlazStTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazStTm31(),""));/** column 출근시간_1일 : dilnlazStTm1 */
							  dlgn0110SaveVo.setDilnlazEdTm(MSFSharedUtils.defaultNulls(dlgn0110Vo.getDilnlazEdTm31(),""));/** column 퇴근시간_1일 : dilnlazEtTm1 */
							  dlgn0110SaveVo.setDilnlazApptnDt(MSFSharedUtils.allowNulls(dlgn0110Vo.getDilnlazApptnDt31()));/** 년월 column 근무일자 : dilnlazApptnDt */
							 
							  dlgn0110DAO.updateXlsDlgn0100(dlgn0110SaveVo);
							  //  dlgn0210DAO.updateXlsDlgn0100ToDlgn0210(dlgn0110SaveVo);
						  }
						 // dlgn0210DAO.updateXlsDlgn0200ToDlgn0210Yn(dlgn0210Vo);
						  
						    InfcPkgDlgn0100VO infcDlgn0100Vo = new InfcPkgDlgn0100VO();
						    InfcPkgDlgn0200VO infcDlgn0200Vo = new InfcPkgDlgn0200VO();
							// 3.복호화
	//						rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dlgn0110Dto.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	//						infcDlgn0100Vo.setResnRegnNum(rrnDecCrypt);
	//						
							infcDlgn0100Vo.setIsmt(sessionUser.getUsrId());
							infcDlgn0100Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
					 
					        infcDlgn0100Vo.setDpobCd(dlgn0110Vo.getDpobCd());						/** column 사업장코드 : dpobCd */
							infcDlgn0100Vo.setSystemkey(dlgn0110Vo.getSystemkey());				/** column SYSTEMKEY : systemkey */
							infcDlgn0100Vo.setDilnlazYrMnth(dlgn0110Vo.getDilnlazYrMnth());		/** column 근태년월 : dilnlazYrMnth */
							infcDlgn0100Vo.setPayCd(dlgn0110Vo.getPayCd());    					/** column 급여구분코드 : payCd */
							infcDlgn0100Vo.setEmymtDivCd(dlgn0110Vo.getEmymtDivCd());    			/** column 고용구분코드 : emymtDivCd */
	//						infcDlgn0100Vo.setDeptCd(dlgn0110Vo.getDeptCd());						/** column 부서코드 : deptCd */
	//						infcDlgn0100Vo.setBusinCd(dlgn0110Vo.getBusinCd());					/** column 사업코드 : businCd */
	//						infcDlgn0100Vo.setTypOccuCd(dlgn0110Vo.getTypOccuCd());    			/** column 직종코드 : typOccuCd */
	//						infcDlgn0100Vo.setDtilOccuInttnCd(dlgn0110Vo.getDtilOccuInttnCd());    /** column 직종세구분코드 : dtilOccuInttnCd */
	//						infcDlgn0100Vo.setDilnlazWklyHldyNumDys(dlgn0110Vo.getDilnlazWklyHldyNumDys()); //주휴일수
							
							
							infcDlgn0200Vo.setIsmt(sessionUser.getUsrId());
							infcDlgn0200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
						 
							infcDlgn0200Vo.setDpobCd(dlgn0210Vo.getDpobCd());						/** column 사업장코드 : dpobCd */
							infcDlgn0200Vo.setSystemkey(dlgn0210Vo.getSystemkey());				/** column SYSTEMKEY : systemkey */
							infcDlgn0200Vo.setDilnlazExceDutyYrMnth(dlgn0210Vo.getDilnlazYrMnth());		/** column 근태년월 : dilnlazYrMnth */
							infcDlgn0200Vo.setPayCd(dlgn0210Vo.getPayCd());    					/** column 급여구분코드 : payCd */
							infcDlgn0200Vo.setEmymtDivCd(dlgn0210Vo.getEmymtDivCd());    			/** column 고용구분코드 : emymtDivCd */
							
							
							
							if((detailYmKubn.compareTo(dlgn0210Vo.getDilnlazYrMnth().replaceAll("\\.", "")) >= 0 )){ //기준일 전
								/****************************************************************************************************
						         * 집계 인터페이스 모듈 호출 부분 추가 2014.10.14 ATRES  
						         ****************************************************************************************************/
								DlgnListenerAdapter dlgnAdapter = new DlgnListenerAdapter();  
						        iResult = dlgnAdapter.setUpdateManageDlgn0100CommuteService(RemoteServiceUtil.getThreadLocalRequest(), infcDlgn0100Vo);
						        /****************************************************************************************************
						         * 집계 인터페이스 모듈 호출 부분 추가 2014.10.14 ATRES  
						         ****************************************************************************************************/
							}else {
								//기본근무관리폼 등록시 기본근무관리 시간에 따른 집계함수
								/****************************************************************************************************
								 * 분단위 집계 인터페이스 모듈 호출 부분 추가 2017.04.14 ATRES  
								 ****************************************************************************************************/
								DlgnListenerAdapter dlgnAdapter = new DlgnListenerAdapter();  
								iResult = dlgnAdapter.setUpdateManageDlgn0100HHMiCommuteService(RemoteServiceUtil.getThreadLocalRequest(), infcDlgn0100Vo);
								/****************************************************************************************************
								 * 분단위 집계 인터페이스 모듈 호출 부분 추가 2017.04.14 ATRES  
								 ****************************************************************************************************/
							}
					  }  // inner if end 
					  
				  		iCnt = iCnt + 1L ;
				  
				  } // for end 
				  
				  
				  /** 로그반영
					 * CRUDSBLO
					 * C:create		R:read		U:update
			    	 * D:delete		S:select	B:배치 
			    	 * L:로그인		O:로그아웃
			    	 */
					MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "D:C:B");
				  
				  result = iCnt;
					  
					  
				  }  // if end 
				  
				  System.out.println("result================"+result+",iResult============="+iResult+", iResult1=============="+iResult1);

	  }catch(Exception e){
		  e.printStackTrace();
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
	  }
	return result;
	}


	private String checkTimeFormat(String chkTime){
		
		String rtnTime = "";
		
		if(!"".equals(chkTime) ){
			if(chkTime.length() ==1 &&(  Integer.parseInt(chkTime)>0&& Integer.parseInt(chkTime)<10 )){
				rtnTime = "0"+chkTime+":00";
			}else if(chkTime.length() ==2 &&(  Integer.parseInt(chkTime)>0&& Integer.parseInt(chkTime)<25 )){
				rtnTime = chkTime+":00";
			}else{
				if(Integer.parseInt(chkTime.replace(":", ""))<0 || Integer.parseInt(chkTime.replace(":", ""))>=2500){
					rtnTime = "99:99";
				}else{
					rtnTime = chkTime;
				}
			}
		}
		
		return rtnTime;
	}


}

