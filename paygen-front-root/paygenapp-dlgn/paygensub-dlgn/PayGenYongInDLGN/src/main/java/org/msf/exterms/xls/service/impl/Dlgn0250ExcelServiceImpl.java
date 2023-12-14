package org.msf.exterms.xls.service.impl;

import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.msf.exterms.xls.imp.MsfExcelService;
import org.msf.exterms.xls.service.Dlgn0250ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;

import com.app.exterms.diligence.server.service.dao.Dlgn0100DAO;
import com.app.exterms.diligence.server.service.dao.Dlgn0200DAO;
import com.app.exterms.diligence.server.vo.Dlgn0100VO;
import com.app.exterms.diligence.server.vo.Dlgn0200VO;
import com.app.exterms.diligence.server.vo.Dlgn0250SrhVO;
import com.app.exterms.diligence.server.vo.Dlgn0250VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("dlgn0250ExcelService")
public class Dlgn0250ExcelServiceImpl extends AbstractServiceImpl implements Dlgn0250ExcelService, ServletContextAware, ServletConfigAware  {
	
	 private static final Logger logger = LoggerFactory.getLogger(Dlgn0250ExcelServiceImpl.class);
	 private static final String calledClass = Dlgn0250ExcelServiceImpl.class.getName();
	 

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
				  dlgn0250Vo.setDilnlazSatDutyNumDys(MSFSharedUtils.defaultNulls(dlgn0250Vo.getDilnlazSatDutyNumDys(), "0"));	//토요근무 dilnlazSatDutyNumDys			  
				  dlgn0250Vo.setDilnlazWklyHldyNumDys(MSFSharedUtils.defaultNulls(dlgn0250Vo.getDilnlazWklyHldyNumDys(), "0"));	//주휴일수 dilnlazWklyHldyNumDys					  
				  dlgn0250Vo.setDilnlazPaidPubcHodyNum(MSFSharedUtils.defaultNulls(dlgn0250Vo.getDilnlazPaidPubcHodyNum(), "0"));	//유급(월차)휴일수 dilnlazPaidPubcHodyNum				  
				  dlgn0250Vo.setDilnlazLvsgNumDys(MSFSharedUtils.defaultNulls(dlgn0250Vo.getDilnlazLvsgNumDys(), "0"));	  //잔여연가 0
				  dlgn0250Vo.setDilnlazTfcAssCstNumDys(MSFSharedUtils.defaultNulls(dlgn0250Vo.getDilnlazTfcAssCstNumDys(), "0"));//교통보조비 dilnlazTfcAssCstNumDys
				  dlgn0250Vo.setDilnlazFndtnTmRstDutyTm(MSFSharedUtils.defaultNulls(dlgn0250Vo.getDilnlazFndtnTmRstDutyTm(), "0"));//시간외기본시간 dilnlazFndtnTmRstDutyTm - 200								  
				  dlgn0250Vo.setDilnlazTmRstDutyTm(MSFSharedUtils.defaultNulls(dlgn0250Vo.getDilnlazTmRstDutyTm(), "0"));	//시간외시간 dilnlazTmRstDutyTm  - 200						  
				  dlgn0250Vo.setDilnlazTotTmRstDutyTm(MSFSharedUtils.defaultNulls(dlgn0250Vo.getDilnlazTotTmRstDutyTm(), "0"));//시간외총시간 dilnlazTotTmRstDutyTm - 200						  
				  dlgn0250Vo.setDilnlazTotNtotTm(MSFSharedUtils.defaultNulls(dlgn0250Vo.getDilnlazTotNtotTm(), "0"));	//야근수당(시간) dilnlazTotNtotTm - 200	
				  dlgn0250Vo.setDilnlazButpDys(MSFSharedUtils.allowNulls(dlgn0250Vo.getDilnlazButpDys()));    						/** column 근태_출장일수 : dilnlazButpDys */
				  
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

}
