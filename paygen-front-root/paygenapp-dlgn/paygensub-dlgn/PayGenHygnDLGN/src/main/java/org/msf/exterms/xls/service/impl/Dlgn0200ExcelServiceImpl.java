package org.msf.exterms.xls.service.impl;

import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.xls.imp.MsfExcelService;
import org.msf.exterms.xls.service.Dlgn0200ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;

import com.app.exterms.diligence.server.service.dao.Dlgn0100DAO;
import com.app.exterms.diligence.server.service.dao.Dlgn0200DAO;
import com.app.exterms.diligence.server.service.dao.Dlgn0210DAO;
import com.app.exterms.diligence.server.vo.Dlgn0200SrhVO;
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

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("dlgn0200ExcelService")
public class Dlgn0200ExcelServiceImpl extends AbstractServiceImpl implements Dlgn0200ExcelService, ServletContextAware, ServletConfigAware  {
	
	private static final Logger logger = LoggerFactory.getLogger(Dlgn0200ExcelServiceImpl.class);
	private static final String calledClass = Dlgn0200ExcelServiceImpl.class.getName();
	
	private String detailYmKubn = DiligenceCommonConstants.HYGN_DLGN_DT_BUNGI;
	
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
    @Resource(name="dlgn0210DAO")
    private Dlgn0210DAO dlgn0210DAO;
    
    @Autowired 
    @Resource(name = "dlgn0250ExcelUploadService")
    private MsfExcelService dlgn0250ExcelUploadService;
    
    @Autowired 
    @Resource(name = "dlgn0250XSSFExcelUploadService")
    private MsfExcelService dlgn0250XSSFExcelUploadService;
    
    
    public List<Dlgn0250VO> selectXlsDlgn0250List(Dlgn0250SrhVO dlgn0250SrhVo) throws Exception {
        return dlgn0200DAO.selectXlsDlgn0250List(dlgn0250SrhVo);
    } 
  
	// 엑셀 다운로드
	public List selectXlsFileDlgn0250List(Dlgn0250SrhVO dlgn0250SrhVo)throws Exception {
		return dlgn0200DAO.selectXlsDlgn0250FormList(dlgn0250SrhVo);
	}  
  
  
	/**
	 * 엑셀파일을 등록한다.
	 * 
	 * @param
	 * @throws Exception
	 */
	public Long updateXlsDlgn0250(List<Dlgn0250VO> dlgn0250List, HttpServletRequest request) throws Exception {

		String method = calledClass + ".updateXlsDlgn0250";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		// String nResult =
		// AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),request);
		// Dlgn0250VO dlgn0250Vo;
		// Dlgn0250VO dlgn0250Vo ;

		Long result = new Long(0);
		Long iCnt = new Long(0);

		try {
		  
			if (dlgn0250List != null && dlgn0250List.size() > 0) {
				
				for (int i = 0; i < dlgn0250List.size(); i++) {
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
//				  dlgn0250Vo.setDilnlazPubcHodyDutyNumDys(MSFSharedUtils.defaultNulls(dlgn0250Vo.getDilnlazPubcHodyDutyNumDys(), "0"));	//휴일근무 dilnlazPubcHodyDutyNumDys
				  dlgn0250Vo.setDilnlazHodyDutyNumDys(MSFSharedUtils.defaultNulls(dlgn0250Vo.getDilnlazHodyDutyNumDys(), "0"));	// 휴일일수 dilnlazHodyDutyNumDys	
				  dlgn0250Vo.setDilnlazPubcHodyDutyNumDys(MSFSharedUtils.defaultNulls(dlgn0250Vo.getDilnlazPubcHodyDutyNumDys(), "0"));	//휴일근무 dilnlazPubcHodyDutyNumDys	
				  dlgn0250Vo.setDilnlazSatDutyNumDys(MSFSharedUtils.defaultNulls(dlgn0250Vo.getDilnlazSatDutyNumDys(), "0"));	//토요근무 dilnlazSatDutyNumDys			  
				  dlgn0250Vo.setDilnlazWklyHldyNumDys(MSFSharedUtils.defaultNulls(dlgn0250Vo.getDilnlazWklyHldyNumDys(), "0"));	//주휴일수 dilnlazWklyHldyNumDys					  
				  dlgn0250Vo.setDilnlazPaidPubcHodyNum(MSFSharedUtils.defaultNulls(dlgn0250Vo.getDilnlazPaidPubcHodyNum(), "0"));	//유급(월차)휴일수 dilnlazPaidPubcHodyNum				  
												  //잔여연가 0
				  dlgn0250Vo.setDilnlazTfcAssCstNumDys(MSFSharedUtils.defaultNulls(dlgn0250Vo.getDilnlazTfcAssCstNumDys(), "0"));//교통보조비 dilnlazTfcAssCstNumDys
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
     // dlgn0200DAO.insertXlsDlgn0200(); //삭제호출 후 파일데이터 인서트  
	  
	  
  }
  
  /**
   *  엑셀파일을 등록한다.
   * @param  
   * @throws Exception
   */
  public void insertXlsDlgn0200(InputStream file) throws Exception {
     // dlgn0200DAO.insertXlsDlgn0200(); //삭제호출 후 파일데이터 인서트  
      dlgn0250ExcelUploadService.uploadExcel("dlgn0200DAO.deleteXlsDlgn0200_S","dlgn0200DAO.insertXlsDlgn0200_S", file, 3, (long) 0); 
  }
  
  /**
   *  엑셀파일을 등록한다.
   * @param  
   * @throws Exception
   */
  public void insertXSSFDlgn0200(InputStream file) throws Exception {
     // dlgn0200DAO.insertXlsDlgn0200(); //삭제호출 후 파일데이터 인서트  
      dlgn0250XSSFExcelUploadService.uploadXSSFExcel("dlgn0200DAO.deleteXlsDlgn0200_S", "dlgn0200DAO.insertXlsDlgn0200_S", file, 3, (long) 0); 
  }

  /**
   * DLGN0200을 등록한다.
   * @param vo - 등록할 정보가 담긴 Dlgn0200VO
   * @return 등록 결과
   * @exception Exception
   */
  public String insertDlgn0200(Dlgn0200VO vo) throws Exception {
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
  
  /**
   * DLGN0200을 등록한다.
   * @param vo - 등록할 정보가 담긴 Dlgn0200VO
   * @return 등록 결과
   * @exception Exception
   */
	public String insertXlsDlgn0200(Dlgn0200VO vo) throws Exception {
		log.debug(vo.toString());

		/** ID Generation Service */
		// TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
		// String id = egovIdGnrService.getNextStringId();
		// vo.setId(id);
		log.debug(vo.toString());

		dlgn0200DAO.insertDlgn0200(vo);
		// TODO 해당 테이블 정보에 맞게 수정
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
	
	//TODO 0200service부터 다시 정의
	@Override
	public List<Dlgn0250VO> selectXlsDlgn0200List(Dlgn0250SrhVO dlgn0250SrhVo)
			throws Exception {
		return dlgn0200DAO.selectXlsDlgn0200List(dlgn0250SrhVo);
	}
	
	@Override
	public List selectXlsFileDlgn0200List(Dlgn0200SrhVO dlgn0200SrhVo)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/** 시간외근무관리 엑셀 업로드 **/
	@Override
	public Long updateXlsDlgn0200(List<Dlgn0210ExlVO> dlgn0210List,HttpServletRequest request) throws Exception {

		String method = calledClass + ".updateXlsDlgn0200";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);

		Long result = new Long(0);
		Long iCnt = new Long(0);
	  
	  try{
		 
		  if(dlgn0210List !=null && dlgn0210List.size() > 0){
			  
			  for ( int i = 0; i < dlgn0210List.size(); i++){
				  
				  String nResult = AnyCryptUtils.XecureCryptInitialize(sevltConfig, request);
				  Dlgn0210ExlVO dlgn0210Vo = new Dlgn0210ExlVO(); 
				  
				  
				  dlgn0210Vo = dlgn0210List.get(i);
//				  dlgn0210Vo = dlgn0210List.get(i);
				  
				  dlgn0210Vo.setDpobCd(sessionUser.getDpobCd());													/** column 사업장코드 : dpobCd */
				  dlgn0210Vo.setIsmt(sessionUser.getUsrId());														/** column 수정자 : ismt */
				  dlgn0210Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());				/** column 수정주소 : revnAddr */
				  
				  
				  dlgn0210Vo.setPayCd(MSFSharedUtils.allowNulls(dlgn0210Vo.getPayCd()));							/** column 급여구분코드 : payCd */
				  dlgn0210Vo.setEmymtDivCd(MSFSharedUtils.allowNulls(dlgn0210Vo.getEmymtDivCd()));					/** column 고용구분코드 : emymtDivCd */
				  dlgn0210Vo.setHanNm(MSFSharedUtils.allowNulls(dlgn0210Vo.getHanNm()));							/** column 한글성명 : hanNm */
				  dlgn0210Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(dlgn0210Vo.getResnRegnNum().replaceAll("-","")),AnyCryptUtils.SEC_RRNUMC));
				  dlgn0210Vo.setDilnlazYrMnth(MSFSharedUtils.allowNulls(dlgn0210Vo.getDilnlazYrMnth()));			/** column 근태년월 : dilnlazYrMnth */
				  dlgn0210Vo.setDilnlazApptnDt(MSFSharedUtils.allowNulls(dlgn0210Vo.getDilnlazApptnDt()));			/** column 근무일자 : dilnlazApptnDt */
				  dlgn0210Vo.setDilnlazDutyStTm(MSFSharedUtils.allowNulls(dlgn0210Vo.getDilnlazDutyStTm()));		/** column 출근시간 : dilnlazDutyStTm */
				  dlgn0210Vo.setDilnlazDutyEdTm(MSFSharedUtils.allowNulls(dlgn0210Vo.getDilnlazDutyEdTm()));		/** column 퇴근시간 : dilnlazDutyEdTm */
				  dlgn0210Vo.setDilnlazTmRstDutyTm(MSFSharedUtils.allowNulls(dlgn0210Vo.getDilnlazTmRstDutyTm()));	/** column 평일연장시간 : dilnlazTmRstDutyTm */
				  dlgn0210Vo.setDilnlazNtotTm(MSFSharedUtils.allowNulls(dlgn0210Vo.getDilnlazNtotTm()));			/** column 평일야근시간 : dilnlazNtotTm */
				  dlgn0210Vo.setDilnlazHodyDutyTm(MSFSharedUtils.allowNulls(dlgn0210Vo.getDilnlazHodyDutyTm()));	/** column 휴일근무시간 : dilnlazHodyDutyTm */
				  dlgn0210Vo.setDilnlazHodyNtotTm(MSFSharedUtils.allowNulls(dlgn0210Vo.getDilnlazHodyNtotTm()));	/** column 휴일연장시간 : dilnlazHodyRstDutyTm */
				  
				  // 업로드 구분이 01 이면 기존 hh:mm 로직. 아닐 경우(02) mm 로직 사용
				  if("01".equals(dlgn0210Vo.getDlgnFlag()) || dlgn0210Vo.getDlgnFlag() == "01" ) {
					  // hh:mm 입력
					  
					  dlgn0210Vo.setDilnlazTmRstDutyTm(MSFSharedUtils.allowNulls(dlgn0210Vo.getDilnlazTmRstDutyTm()));		/** column 연장근무시간 : dilnlazTmRstDutyTm */
			 			// 한자릿수 시간만 입력할 경우 저장 시 hh:mm 형식으로 해줌.
			 			if(dlgn0210Vo.getDilnlazTmRstDutyTm().length() == 1) {
			 				dlgn0210Vo.setDilnlazTmRstDutyTm("0" +  dlgn0210Vo.getDilnlazTmRstDutyTm() + ":00");			/** column 연장근무시간 : dilnlazTmRstDutyTm */
			 			}else if(dlgn0210Vo.getDilnlazTmRstDutyTm().length() == 2) {
			 				if("0".equals(dlgn0210Vo.getDilnlazTmRstDutyTm().substring(0,1))) {
			 					dlgn0210Vo.setDilnlazTmRstDutyTm(dlgn0210Vo.getDilnlazTmRstDutyTm() + "00");				/** column 연장근무시간 : dilnlazTmRstDutyTm */
			 				}else {
			 					dlgn0210Vo.setDilnlazTmRstDutyTm(dlgn0210Vo.getDilnlazTmRstDutyTm() + "00");	
			 				}
			 			}
			 			
			 			dlgn0210Vo.setDilnlazNtotTm(MSFSharedUtils.allowNulls(dlgn0210Vo.getDilnlazNtotTm()));				/** column 야간근무시간 : dilnlazNtotTm */
			 			// 한자릿수 시간만 입력할 경우 저장 시 hh:mm 형식으로 해줌.
			 			if(dlgn0210Vo.getDilnlazNtotTm().length() == 1) {
			 				dlgn0210Vo.setDilnlazNtotTm("0" +  dlgn0210Vo.getDilnlazNtotTm() + "00");						/** column 야간근무시간 : dilnlazNtotTm */
			 			}else if(dlgn0210Vo.getDilnlazNtotTm().length() == 2) {
			 				if("0".equals(dlgn0210Vo.getDilnlazNtotTm().substring(0,1))) {
			 					dlgn0210Vo.setDilnlazNtotTm(dlgn0210Vo.getDilnlazNtotTm() + "00");							/** column 야간근무시간 : dilnlazNtotTm */
			 				}else {
			 					dlgn0210Vo.setDilnlazNtotTm(dlgn0210Vo.getDilnlazNtotTm() + "00");	
			 				}
			 			}
			 			
			 			
			 			
			 			dlgn0210Vo.setDilnlazHodyDutyTm(MSFSharedUtils.allowNulls(dlgn0210Vo.getDilnlazHodyDutyTm()));		/** column 휴일근무시간 : dilnlazHodyDutyTm */
			 			// 한자릿수 시간만 입력할 경우 저장 시 hh:mm 형식으로 해줌.
			 			if(dlgn0210Vo.getDilnlazHodyDutyTm().length() == 1) {
			 				dlgn0210Vo.setDilnlazHodyDutyTm("0" +  dlgn0210Vo.getDilnlazHodyDutyTm() + "00");				/** column 휴일근무시간 : dilnlazHodyDutyTm */
			 			}else if(dlgn0210Vo.getDilnlazHodyDutyTm().length() == 2) {
			 				if("0".equals(dlgn0210Vo.getDilnlazHodyDutyTm().substring(0,1))) {
			 					dlgn0210Vo.setDilnlazHodyDutyTm(dlgn0210Vo.getDilnlazHodyDutyTm() + "00");					/** column 휴일근무시간 : dilnlazHodyDutyTm */
			 				}else {
			 					dlgn0210Vo.setDilnlazHodyDutyTm(dlgn0210Vo.getDilnlazHodyDutyTm() + "00");
			 				}
			 			}
			 			
			 			
			 			
			 			dlgn0210Vo.setDilnlazHodyNtotTm(MSFSharedUtils.allowNulls(dlgn0210Vo.getDilnlazHodyNtotTm()));		/** column 휴일연장근무시간 : dilnlazHodyDutyRstTm */
			 			// 한자릿수 시간만 입력할 경우 저장 시 hh:mm 형식으로 해줌.
			 			if(dlgn0210Vo.getDilnlazHodyNtotTm().length() == 1) {
			 				dlgn0210Vo.setDilnlazHodyNtotTm("0" +  dlgn0210Vo.getDilnlazHodyNtotTm() + "00");				/** column 휴일연장근무시간 : dilnlazHodyDutyRstTm */
			 			}else if(dlgn0210Vo.getDilnlazHodyNtotTm().length() == 2) {
			 				if("0".equals(dlgn0210Vo.getDilnlazHodyNtotTm().substring(0,1))) {
			 					dlgn0210Vo.setDilnlazHodyNtotTm(dlgn0210Vo.getDilnlazHodyNtotTm() + "00");					/** column 휴일연장근무시간 : dilnlazHodyDutyRstTm */
			 				}else {
			 					dlgn0210Vo.setDilnlazHodyNtotTm(dlgn0210Vo.getDilnlazHodyNtotTm() + "00");			
			 				}
			 			}
			 			
			 			
			 			// 기존 hh:mm 로직
			 			//dlgn0210DAO.updateXlsDlgn0200ToDlgn0210(dlgn0210Vo);
			 			dlgn0210DAO.updateXlsDlgn0200ToDlgn0210Input(dlgn0210Vo);
			 			dlgn0210DAO.updateXlsDlgn0200ToDlgn0210Yn(dlgn0210Vo);
					  
					  
				  }else {
					  
					  // mm 로직
					  //dlgn0210DAO.updateXlsDlgn0200ToDlgn0210(dlgn0210Vo);
					  dlgn0210DAO.updateXlsDlgn0200ToDlgn0210Input02(dlgn0210Vo);
					  dlgn0210DAO.updateXlsDlgn0200ToDlgn0210Yn(dlgn0210Vo);
					  
				  }
					  
				  InfcPkgDlgn0200VO infcDlgn0200Vo = new InfcPkgDlgn0200VO();
				  InfcPkgDlgn0100VO infcDlgn0100Vo = new InfcPkgDlgn0100VO();
					  
					// 3.복호화
//					rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dlgn0110Dto.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//					infcDlgn0100Vo.setResnRegnNum(rrnDecCrypt);
//						
				    infcDlgn0200Vo.setIsmt(sessionUser.getUsrId());
					infcDlgn0200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				 
					infcDlgn0200Vo.setDpobCd(dlgn0210Vo.getDpobCd());							/** column 사업장코드 : dpobCd */
					infcDlgn0200Vo.setSystemkey(dlgn0210Vo.getSystemkey());						/** column SYSTEMKEY : systemkey */
					infcDlgn0200Vo.setDilnlazExceDutyYrMnth(dlgn0210Vo.getDilnlazYrMnth());		/** column 근태년월 : dilnlazYrMnth */
					infcDlgn0200Vo.setPayCd(dlgn0210Vo.getPayCd());    							/** column 급여구분코드 : payCd */
					infcDlgn0200Vo.setEmymtDivCd(dlgn0210Vo.getEmymtDivCd());    				/** column 고용구분코드 : emymtDivCd */
//					infcDlgn0100Vo.setDeptCd(dlgn0110Vo.getDeptCd());						/** column 부서코드 : deptCd */
//					infcDlgn0100Vo.setBusinCd(dlgn0110Vo.getBusinCd());					/** column 사업코드 : businCd */
//					infcDlgn0100Vo.setTypOccuCd(dlgn0110Vo.getTypOccuCd());    			/** column 직종코드 : typOccuCd */
//					infcDlgn0100Vo.setDtilOccuInttnCd(dlgn0110Vo.getDtilOccuInttnCd());    /** column 직종세구분코드 : dtilOccuInttnCd */
//					infcDlgn0100Vo.setDilnlazWklyHldyNumDys(dlgn0110Vo.getDilnlazWklyHldyNumDys()); //주휴일수
					
					
			        infcDlgn0100Vo.setDpobCd(dlgn0210Vo.getDpobCd());							/** column 사업장코드 : dpobCd */
					infcDlgn0100Vo.setSystemkey(dlgn0210Vo.getSystemkey());						/** column SYSTEMKEY : systemkey */
					infcDlgn0100Vo.setDilnlazYrMnth(dlgn0210Vo.getDilnlazYrMnth());				/** column 근태년월 : dilnlazYrMnth */
					infcDlgn0100Vo.setPayCd(dlgn0210Vo.getPayCd());    							/** column 급여구분코드 : payCd */
					infcDlgn0100Vo.setEmymtDivCd(dlgn0210Vo.getEmymtDivCd());    				/** column 고용구분코드 : emymtDivCd */
					infcDlgn0100Vo.setIsmt(sessionUser.getUsrId());
					infcDlgn0100Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
					
					
					
					if((detailYmKubn.compareTo(dlgn0210Vo.getDilnlazYrMnth().replaceAll("\\.", "")) >= 0 )){ //기준일 전
						
//						/****************************************************************************************************
//						 * 분단위 집계 인터페이스 모듈 호출 부분 추가 2017.04.14 ATRES  
//						 ****************************************************************************************************/
//							DlgnListenerAdapter dlgn0100Adapter = new DlgnListenerAdapter();  
//							Long iResult0100 = dlgn0100Adapter.setUpdateManageDlgn0100CommuteService(RemoteServiceUtil.getThreadLocalRequest(), infcDlgn0100Vo);
//						/****************************************************************************************************
//						 * 분단위 집계 인터페이스 모듈 호출 부분 추가 2017.04.14 ATRES  
//						 ****************************************************************************************************/
						
						/****************************************************************************************************
				         * 집계 인터페이스 모듈 호출 부분 추가 2014.10.14 ATRES  
				         ****************************************************************************************************/
						DlgnListenerAdapter dlgn0200Adapter = new DlgnListenerAdapter();  
				        Long iResult0200 = dlgn0200Adapter.setUpdateManageDlgn0200CommuteService(RemoteServiceUtil.getThreadLocalRequest(), infcDlgn0200Vo);
				        /****************************************************************************************************
				         * 집계 인터페이스 모듈 호출 부분 추가 2014.10.14 ATRES  
				         ****************************************************************************************************/
			        
					}else{ //기준일 후
						
//						/****************************************************************************************************
//						 * 분단위 집계 인터페이스 모듈 호출 부분 추가 2017.04.14 ATRES  
//						 ****************************************************************************************************/
//							DlgnListenerAdapter dlgn0100Adapter = new DlgnListenerAdapter();  
//							Long iResult0100 = dlgn0100Adapter.setUpdateManageDlgn0100HHMiCommuteService(request, infcDlgn0100Vo);
//						/****************************************************************************************************
//						 * 분단위 집계 인터페이스 모듈 호출 부분 추가 2017.04.14 ATRES  
//						 ****************************************************************************************************/
						/****************************************************************************************************
						 * 시간외 분단위 집계 인터페이스 모듈 호출 부분 추가 2017.04.14 ATRES  
						 ****************************************************************************************************/
						DlgnListenerAdapter dlgn0200Adapter = new DlgnListenerAdapter();
						dlgn0200Adapter.getDlgnListenerCheck(sevltConfig,request);
						Long iResult0200 = dlgn0200Adapter.setUpdateManageDlgn0200HHMiCommuteService(RemoteServiceUtil.getThreadLocalRequest(), infcDlgn0200Vo);
						/****************************************************************************************************
						 * 시간외 분단위 집계 인터페이스 모듈 호출 부분 추가 2017.04.14 ATRES  
						 ****************************************************************************************************/
					}					
					
					iCnt = iCnt + 1	;  
//					/****************************************************************************************************
//					 * 분단위 집계 인터페이스 모듈 호출 부분 추가 2017.04.14 ATRES  
//					 ****************************************************************************************************/
//					DlgnListenerAdapter dlgnAdapter = new DlgnListenerAdapter();  
//					Long iResult = dlgnAdapter.setUpdateManageDlgn0100HHMiCommuteService(RemoteServiceUtil.getThreadLocalRequest(), infcDlgn0100Vo);
//					/****************************************************************************************************
//					 * 분단위 집계 인터페이스 모듈 호출 부분 추가 2017.04.14 ATRES  
//					 ****************************************************************************************************/
//					
//					/****************************************************************************************************
//					 * 시간외 분단위 집계 인터페이스 모듈 호출 부분 추가 2017.04.14 ATRES  
//					 ****************************************************************************************************/
//					DlgnListenerAdapter dlgnAdapter1 = new DlgnListenerAdapter();  
//					Long iResult1 = dlgnAdapter1.setUpdateManageDlgn0200HHMiCommuteService(RemoteServiceUtil.getThreadLocalRequest(), infcDlgn0200Vo);
//					/****************************************************************************************************
//					 * 시간외 분단위 집계 인터페이스 모듈 호출 부분 추가 2017.04.14 ATRES  
//					 ****************************************************************************************************/
					
			  }
			  
		  }
		  
			/**
			 * 로그반영 CRUDSBLO C:create R:read U:update D:delete S:select B:배치
			 * L:로그인 O:로그아웃
			 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "D:C:B");
		  
			result = iCnt;
		  
	  }catch(Exception e){
		  e.printStackTrace();
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
	  }
	  
	  return result;
	  
	}
}


