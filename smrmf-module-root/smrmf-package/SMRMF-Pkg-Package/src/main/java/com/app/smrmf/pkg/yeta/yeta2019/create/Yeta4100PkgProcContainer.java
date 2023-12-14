package com.app.smrmf.pkg.yeta.yeta2019.create;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.any.smrmf.utils.BeanFinder;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.sysif.msfpackage.server.utils.SysifPkgServiceUtils;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160401VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160402VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160403VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgYe161010Srh_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgYe161010_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgYe161020_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgYe161030_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgYe161040_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgYe161070_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgYe161080_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgYe165010_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgYe165030Temp_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgYe165030_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgYe166010_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgYe166020_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgYe169010a_2019_VO;
import com.app.smrmf.pkg.yeta.yeta2019.tax.service.Yeta4100PayrService;
import com.app.smrmf.props.ExtermsProps;
import com.app.smrmf.sysm.server.service.vo.SysIfBass0350VO;
import com.ext.constants.PropPayGenConfs;
import com.ext.constants.SysmConf;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
/**
 * 퇴직정산 관련 실제 로직을 처리 하는 부분
 */
@Controller 
public class Yeta4100PkgProcContainer  extends AbstractCustomServiceImpl {
	

	private static final Logger logger = LoggerFactory.getLogger(Yeta4100PkgProcContainer.class);
	  
	
    
	@Resource(name = "Yeta4100PayrService")
    protected Yeta4100PayrService  yeta4100PayrService;
  
    
//    @Resource(name = "RetirementCalculstionService")
//    protected RetirementCalculstionService remtCalcService;
//
 
	
    public Yeta4100PkgProcContainer() {
    	
    }
    
    /**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * 단위사업장 맵핑 시작 
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * */	
    public PagingLoadResult<ShowMessageBM> execUpDpopYeta_2019_Insert(HttpServletRequest request, List<InfcPkgYe161010_2019_VO> listYe161010VO)  throws Exception  {
    
	  	  return  funcUpDpopYeta_2019_Insert(request,  listYe161010VO);
	}  
    
 private PagingLoadResult<ShowMessageBM> funcUpDpopYeta_2019_Insert(HttpServletRequest request, List<InfcPkgYe161010_2019_VO> listYe161010VO )  throws Exception  {
    	
		PagingLoadResult<ShowMessageBM> retval = null;
		List<ShowMessageBM> bmResult = new ArrayList<ShowMessageBM>();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		   if  (yeta4100PayrService == null) { 
               WebApplicationContext wac = WebApplicationContextUtils.
                       getRequiredWebApplicationContext( request.getSession().getServletContext());
   
               yeta4100PayrService = (Yeta4100PayrService) wac.getBean("Yeta4100PayrService"); 
              
            }
		   
		   BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);
	  
	     String dataCheck = "";
		 
		try {

			 
			/******************************************************************************** 
			 * 선택한 대상자의 수 만큼 대상자를 생성한다. 
			 ********************************************************************************/
			System.out.println("===================================================== 199[");			 
			
			for (int iYetaCnt = 0; iYetaCnt < listYe161010VO.size(); iYetaCnt++) { 
				
				InfcPkgYe161010_2019_VO    infcPkgYe161010Vo	 = new InfcPkgYe161010_2019_VO();	// 연말정산대상자기본
				
				InfcPkgYe161010Srh_2019_VO    infcPkgYe161010SrhVo	 = new InfcPkgYe161010Srh_2019_VO();	// 연말정산대상자기본
				
				InfcPkgYe161010_2019_VO infcPkgGetYe161010Vo = new InfcPkgYe161010_2019_VO();
				
				infcPkgGetYe161010Vo = listYe161010VO.get(iYetaCnt); 
				   
				BeanUtils.copyProperties(infcPkgYe161010SrhVo, infcPkgGetYe161010Vo); 
				BeanUtils.copyProperties(infcPkgYe161010Vo, infcPkgGetYe161010Vo); 
	        
			       /**************************************************************************************
			        * 단위사업장맵핑
			        **************************************************************************************/
		 
				if (ExtermsProps.getProps("EMYMT_DIVCD_01").equals(infcPkgYe161010Vo.getEmymtDivCd())) {
					//무기계약직인경우 
					HashMap  listBass0360Data = yeta4100PayrService.selectBass0360SearchList(  infcPkgYe161010SrhVo);
                      
					if (MSFSharedUtils.paramNotNull(listBass0360Data.get("untDpobCd"))) {
						
						infcPkgYe161010Vo.setUtDpobCd(MSFSharedUtils.allowNulls(listBass0360Data.get("untDpobCd")));
						

						logger.debug("단위사업장맵핑 업데이트 시작 ");
						  yeta4100PayrService.fnYeta4100_YE161010_UtDpobCd_2019_Update(infcPkgYe161010Vo);   //infcPkgYeta4000Vo   
						
						logger.debug("단위사업장맵핑 업데이트 종료 ");
						
					}
					
				} else {
					//기간제인경우 맵핑데이타 존재시 아닌
					HashMap  listBass0500Data = yeta4100PayrService.selectBass0500SearchList(  infcPkgYe161010SrhVo);
                      
					if (MSFSharedUtils.paramNotNull(listBass0500Data.get("untDpobCd"))) {
						
						infcPkgYe161010Vo.setUtDpobCd(MSFSharedUtils.allowNulls(listBass0500Data.get("untDpobCd")));
						

						logger.debug("단위사업장맵핑 업데이트 시작 ");
						  yeta4100PayrService.fnYeta4100_YE161010_UtDpobCd_2019_Update(infcPkgYe161010Vo);   //infcPkgYeta4000Vo   
					 
						logger.debug("단위사업장맵핑 업데이트 종료 ");
						
					}
                    
					
				}
   
				bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "단위사업장 맵핑 .","데이타확인",""));
			}
	 
			
			 /**************************************************************************************
		      * 단위사업장맵핑 종료
		      **************************************************************************************/ 

			bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "대상자 생성이 완료되었습니다.","데이타확인",""));  
			
			retval = new BasePagingLoadResult<ShowMessageBM>(bmResult, 0,bmResult.size());
		  	        
		} catch (Exception ex) {
			ex.printStackTrace();
			ShowMessageBM smBm = new ShowMessageBM();
			smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR);
			smBm.setMenu("Yeta");
			smBm.setPhase("[연말정산대상자]대상자생성에러");
			smBm.setMessage(ex.getLocalizedMessage());
			smBm.setContent(ex.getMessage());
			bmResult.add(smBm);
			retval = new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());

		}

		return retval;
	}
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * 단위사업장맵핑 종료
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * */	  
    
    
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * 연말정산 대상자생성 시작
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * */	
    public PagingLoadResult<ShowMessageBM> execYeta4100_All_2019_Create(HttpServletRequest request, List<InfcPkgYe161010_2019_VO> listYe161010VO)  throws Exception  {
    
	  	  return  funcYetaYeta4100_All_2019_Create(request,  listYe161010VO);
	}
    
    /**
     * 
     * <pre>
     * 1. 개요 : 연말정산 대상자 생성에 따른 함수  
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : funcYetaYeta2100_All_Create
     * @date : 2019. 1. 7.
     * @author : atres
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2019. 1. 7.		atres				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param request
     * @param listYe161010VO
     * @return
     * @throws Exception
     */
    private PagingLoadResult<ShowMessageBM> funcYetaYeta4100_All_2019_Create(HttpServletRequest request, List<InfcPkgYe161010_2019_VO> listYe161010VO )  throws Exception  {
    	
		PagingLoadResult<ShowMessageBM> retval = null;
		List<ShowMessageBM> bmResult = new ArrayList<ShowMessageBM>();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		   if  (yeta4100PayrService == null) { 
               WebApplicationContext wac = WebApplicationContextUtils.
                       getRequiredWebApplicationContext( request.getSession().getServletContext());
   
               yeta4100PayrService = (Yeta4100PayrService) wac.getBean("Yeta4100PayrService"); 
              
            }
		   
		//yeta4100PayrService = (Yeta4100PayrService)BeanFinder.getBean("Yeta4100PayrService");
		//List<> listYe161010VO = new ArrayList<InfcPkgYe161010VO>();
	  
	     String dataCheck = "";
		 
		try {

			 
			/******************************************************************************** 
			 * 선택한 대상자의 수 만큼 대상자를 생성한다. 
			 ********************************************************************************/
			 
			
			for (int iYetaCnt = 0; iYetaCnt < listYe161010VO.size(); iYetaCnt++) {

				
				InfcPkgYe161010_2019_VO    infcPkgYe161010Vo	 = new InfcPkgYe161010_2019_VO();	// 연말정산대상자기본
				InfcPkgYe161020_2019_VO    infcPkgYe161020Vo	 = new InfcPkgYe161020_2019_VO();	//A_인적소득공제기본
				InfcPkgYe161030_2019_VO    infcPkgYe161030Vo	 = new InfcPkgYe161030_2019_VO();	//E_인적공제명세

				List<String> lstTypeOccuCd = null;
				List<String> lstDtilOccuInttnCd = null;
				SysIfBass0350VO sysIfBass0350Vo = new SysIfBass0350VO(); 
				InfcPkgYe161010_2019_VO infcPkgLstYe161010Vo = new InfcPkgYe161010_2019_VO();
				infcPkgLstYe161010Vo = listYe161010VO.get(iYetaCnt); 
					
						 /**************************************************************************************
					      * 연말정산 기본정보 생성 
					      **************************************************************************************/ 
				
						infcPkgYe161010Vo.setDpobCd(infcPkgLstYe161010Vo.getDpobCd());    						/** column 사업장코드 : dpobCd */
						infcPkgYe161010Vo.setYrtxBlggYr(infcPkgLstYe161010Vo.getYrtxBlggYr());    				/** column 귀속연도 : yrtxBlggYr */
						infcPkgYe161010Vo.setClutSeptCd(infcPkgLstYe161010Vo.getClutSeptCd());    				/** column 연말정산구분코드 : clutSeptCd */
						infcPkgYe161010Vo.setSystemkey(infcPkgLstYe161010Vo.getSystemkey());    				/** column SYSTEMKEY : systemkey */
		        		  
						infcPkgYe161010Vo.setPayrMangDeptCd(infcPkgLstYe161010Vo.getSrhPayrMangDeptCd());    /** column 급여관리부서코드 : payrMangDeptCd */
						infcPkgYe161010Vo.setDeptCd(infcPkgLstYe161010Vo.getSrhDeptCd());    /** column 부서코드 : deptCd */
						infcPkgYe161010Vo.setTypOccuCd(infcPkgLstYe161010Vo.getSrhTypOccuCd());    /** column 직종코드 : typOccuCd */ 
						infcPkgYe161010Vo.setDtilOccuInttnCd(infcPkgLstYe161010Vo.getSrhDtilOccuInttnCd());    /** column 직종세통합코드 : dtilOccuInttnCd */
						infcPkgYe161010Vo.setBusinCd(infcPkgLstYe161010Vo.getSrhBusinCd());    /** column 사업코드 : businCd */
						infcPkgYe161010Vo.setEmymtDivCd(infcPkgLstYe161010Vo.getSrhEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */ 
					      
		        	   	/************************과거 직종세에 해당하는 사람들 데이타 가져오기 **********************************************************/

		        	   	lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(infcPkgLstYe161010Vo.getSrhTypOccuCd()));  
		    	      	lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(infcPkgLstYe161010Vo.getSrhDtilOccuInttnCd())); 
		    	      	
		    	     	sysIfBass0350Vo = new SysIfBass0350VO(); 
		    	      	sysIfBass0350Vo.setDpobCd(sessionUser.getDpobCd());
		    	     	sysIfBass0350Vo.setYmdGb("Y");
		    	     	sysIfBass0350Vo.setStrDate(infcPkgLstYe161010Vo.getYrtxBlggYr());
		    	     	sysIfBass0350Vo.setTypOccuCd(infcPkgLstYe161010Vo.getSrhTypOccuCd());
		    	     	sysIfBass0350Vo.setTypOccuCdArr(lstTypeOccuCd);
		    	    	sysIfBass0350Vo.setDtilOccuInttnCd(infcPkgLstYe161010Vo.getSrhDtilOccuInttnCd());
		    	     	sysIfBass0350Vo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
		    	     	
		    	     	sysIfBass0350Vo = SysifPkgServiceUtils.getFuncBeforDtilOccuInttnCd(request,sysIfBass0350Vo); 
		    	     
		    	     	infcPkgYe161010Vo.setTypOccuCdArr(sysIfBass0350Vo.getRtnTypOccuCdArr());  
		    	     	infcPkgYe161010Vo.setDtilOccuInttnCdArr(sysIfBass0350Vo.getRtnDtilOccuInttnCdArr());   
		    	     	
		    	     	/************************과거 직종세에 해당하는 사람들 데이타 가져오기 **********************************************************/
		      
		    	      	 
		    	     	infcPkgYe161010Vo.setKybdr(sessionUser.getUsrId());    													/** column 입력자 : kybdr */
		    	     	infcPkgYe161010Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 입력주소 : inptAddr */
		    	     	infcPkgYe161010Vo.setIsmt(sessionUser.getUsrId());    													/** column 수정자 : ismt */
		    	     	infcPkgYe161010Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 수정주소 : revnAddr */
		    	     	infcPkgYe161010Vo.setAddCheck("ADD");   //추가 여부에 따른 기존데이타 스킾처리하는 루틴 추가       
						
		    	     	infcPkgYe161010Vo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
		    	     	infcPkgYe161010Vo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
		    	     	infcPkgYe161010Vo.setUsrId(sessionUser.getUsrId());  
						/******************************** 권한 ************************************************************************/
			         	
		    	     	infcPkgYe161010Vo.setDeptCdAuth(MSFSharedUtils.allowNulls(infcPkgLstYe161010Vo.getSrhDeptCd()).replace(",", ""));  //권한처리를위해 추가  
		    	     	infcPkgYe161010Vo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(infcPkgLstYe161010Vo.getSrhDtilOccuInttnCd()).replace(",", ""));  
						            
						if (infcPkgLstYe161010Vo.getSrhPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(infcPkgLstYe161010Vo.getSrhDeptCd()))) { 
							infcPkgYe161010Vo.setDeptCd("");  //부서코드
						}  
			
							dataCheck = "";
					 	
							dataCheck = yeta4100PayrService.fnYeta4100_YE161010_2019_CREATE_Insert(infcPkgYe161010Vo);   //infcPkgYeta2000Vo 
						
							bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "연말정산기본정보생성.","데이타확인","")); 
							
							// && (MSFSharedUtils.defaultNulls(dataCheck,"-1").compareTo("0") > 0)
							if (MSFSharedUtils.paramNull(dataCheck)) {				
							/**
			            	 * +++++++++++++ YE161020 INSERT 시작 +++++++++++++
			            	 * */
							infcPkgYe161020Vo.setDpobCd(sessionUser.getDpobCd());    																/** column 사업장코드 : dpobCd */
							infcPkgYe161020Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(infcPkgLstYe161010Vo.getYrtxBlggYr()));    							/** column 귀속연도 : yrtxBlggYr */
							infcPkgYe161020Vo.setClutSeptCd(MSFSharedUtils.allowNulls(infcPkgLstYe161010Vo.getClutSeptCd()));    							/** column 연말정산구분코드 : clutSeptCd */
							infcPkgYe161020Vo.setSystemkey(MSFSharedUtils.allowNulls(infcPkgLstYe161010Vo.getSystemkey()));    								/** column SYSTEMKEY : systemkey */
							infcPkgYe161020Vo.setKybdr(sessionUser.getUsrId());    																/** column 입력자 : kybdr */
							infcPkgYe161020Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    							/** column 입력주소 : inptAddr */
							infcPkgYe161020Vo.setIsmt(sessionUser.getUsrId());    																	/** column 수정자 : ismt */
							infcPkgYe161020Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    							/** column 수정주소 : revnAddr */
			            	
							yeta4100PayrService.fnYeta4100_YE161020_2019_CREATE_Insert(infcPkgYe161020Vo);
			            	        
							bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "인적소득공제기본","데이타확인","")); 
			            	
							
							if (MSFSharedUtils.paramNull(dataCheck)) {

									logger.debug("5. 가족사항 INSERT 시작 ");
									
									// 	{가족사항 인서트 YETA3220 }
									//	{**************************가족사항 [5]********************************}
									dataCheck = "";
									
									infcPkgYe161030Vo.setDpobCd(sessionUser.getDpobCd());    																/** column 사업장코드 : dpobCd */
									infcPkgYe161030Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(infcPkgLstYe161010Vo.getYrtxBlggYr()));    							/** column 귀속연도 : yrtxBlggYr */
									infcPkgYe161030Vo.setClutSeptCd(MSFSharedUtils.allowNulls(infcPkgLstYe161010Vo.getClutSeptCd()));    							/** column 연말정산구분코드 : clutSeptCd */
									infcPkgYe161030Vo.setSystemkey(MSFSharedUtils.allowNulls(infcPkgLstYe161010Vo.getSystemkey()));    								/** column SYSTEMKEY : systemkey */
 
									infcPkgYe161030Vo.setKybdr(sessionUser.getUsrId());    																/** column 입력자 : kybdr */
									infcPkgYe161030Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    							/** column 입력주소 : inptAddr */
									infcPkgYe161030Vo.setIsmt(sessionUser.getUsrId());    																	/** column 수정자 : ismt */
									infcPkgYe161030Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    							/** column 수정주소 : revnAddr */
									
									dataCheck = yeta4100PayrService.fnYeta4100_YE161030_2019_CREATE_Insert(infcPkgYe161030Vo);   //infcPkgYeta4220Vo   
									bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "가족사항 생성.","데이타확인","")); 
									logger.debug("5. 가족사항 INSERT 종료 ");
								//	if (MSFSharedUtils.paramNull(dataCheck)) {}
								 
							//	}
							}
					//	}
			    }
			}
			
			 /**************************************************************************************
		      * 연말정산 기본정보 종료
		      **************************************************************************************/ 

			bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "대상자 생성이 완료되었습니다.","데이타확인",""));  
			
			retval = new BasePagingLoadResult<ShowMessageBM>(bmResult, 0,bmResult.size());
		  	        
		} catch (Exception ex) {
			ex.printStackTrace();
			ShowMessageBM smBm = new ShowMessageBM();
			smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR);
			smBm.setMenu("Yeta");
			smBm.setPhase("[연말정산대상자]대상자생성에러");
			smBm.setMessage(ex.getLocalizedMessage());
			smBm.setContent(ex.getMessage());
			bmResult.add(smBm);
			retval = new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());

		}

		return retval;
	}
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * 연말정산 대상자생성 종료
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * */		  
    
	/**
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * 연말정산 급여자료이관 인터페이스 시작
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * */
	public PagingLoadResult<ShowMessageBM> execPayrToYeta_2019_Insert(HttpServletRequest request, List<InfcPkgYe161010_2019_VO> listYe161010VO)throws Exception {

		return funcPayrToYeta_2019_Insert(request, listYe161010VO);
	}  
    
	private PagingLoadResult<ShowMessageBM> funcPayrToYeta_2019_Insert(HttpServletRequest request,List<InfcPkgYe161010_2019_VO> listYe161010VO)  throws Exception  {
	    	
		PagingLoadResult<ShowMessageBM> retval = null;
		List<ShowMessageBM> bmResult = new ArrayList<ShowMessageBM>();
	 	
		try { 
		  		   
			  	  
			/************************* 대상자별로 루프 시작 ***************************************************/ 
			for (int iCnt01 = 0; iCnt01 < listYe161010VO.size(); iCnt01++) {

				InfcPkgYe161010_2019_VO infcPkgYe161010GetVo = new InfcPkgYe161010_2019_VO();
				infcPkgYe161010GetVo = listYe161010VO.get(iCnt01);
		  		
				bmResult.addAll(setSelfPayrToYeta_2019_Insert(request, infcPkgYe161010GetVo));
		  	}  
			/************************* 대상자별로 루프 종료 ***************************************************/        
		} catch (Exception ex) {
			ex.printStackTrace();
			ShowMessageBM smBm = new ShowMessageBM();
			smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR);
			smBm.setMenu("Yeta");
			smBm.setPhase("[연말정산 급여이관]대상자급여이관에러");
			smBm.setMessage(ex.getLocalizedMessage());
			smBm.setContent(ex.getMessage());
			bmResult.add(smBm);
			retval = new BasePagingLoadResult<ShowMessageBM>(bmResult, 0,bmResult.size());
		}

		return retval;
	}  
	
	
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 급여자료 이관 통합  
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : funcPayrToYeta_2019_Insert
	 * @date : 2019. 1. 8.
	 * @author : atres
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2019. 1. 8.		atres				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param request
	 * @param lstInfcPkgYe160401Vo
	 * @return
	 * @throws Exception
	 */
	private List<ShowMessageBM> setSelfPayrToYeta_2019_Insert(HttpServletRequest request,InfcPkgYe161010_2019_VO  infcPkgYe161010Vo)  throws Exception  {
    	
	 
		List<ShowMessageBM> bmResult = new ArrayList<ShowMessageBM>();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		  	
		yeta4100PayrService = (Yeta4100PayrService)BeanFinder.getBean("Yeta4100PayrService");
		
		InfcPkgYe160401VO infcPkgYe160401Vo = new InfcPkgYe160401VO(); 		// 현근무지 급여지급 명세 
		InfcPkgYe160402VO infcPkgYe160402Vo = new InfcPkgYe160402VO(); 		// 과세감면소득정산  
		InfcPkgYe160403VO infcPkgYe160403Vo = new InfcPkgYe160403VO(); 		// 비과세감면소득정산 
	 
		InfcPkgYe161030_2019_VO    infcPkgYe161030Vo	 = new InfcPkgYe161030_2019_VO();	//E_인적공제명세
		InfcPkgYe161040_2019_VO    infcPkgYe161040Vo	 = new InfcPkgYe161040_2019_VO();	//E_소득세액공제명세
		InfcPkgYe161070_2019_VO    infcPkgYe161070Vo	 = new InfcPkgYe161070_2019_VO();	//C_그밖의소득공제
		InfcPkgYe161080_2019_VO    infcPkgYe161080Vo	 = new InfcPkgYe161080_2019_VO();	//C_세액감면및공제
		InfcPkgYe165010_2019_VO    infcPkgYe165010Vo	 = new InfcPkgYe165010_2019_VO();	//I_해당연도기부금명세
    	InfcPkgYe165030_2019_VO    infcPkgYe165030Vo	 = new InfcPkgYe165030_2019_VO();	//H_기부금조정명세
		InfcPkgYe165030Temp_2019_VO infcPkgYe165030TempVo = new InfcPkgYe165030Temp_2019_VO();  	    //H_기부금조정명세_TEMP	 
		InfcPkgYe166010_2019_VO    infcPkgYe166010Vo	 = new InfcPkgYe166010_2019_VO();	//신용카드등소득공제명세
		InfcPkgYe166020_2019_VO    infcPkgYe166020Vo	 = new InfcPkgYe166020_2019_VO();	//신용카드등소득공제상세
		InfcPkgYe169010a_2019_VO   infcPkgYe169010AVo = new InfcPkgYe169010a_2019_VO();	//C_주현근무처_표준공제 
		
	    String dataCheck = "";
		  
		try { 
			
			HashMap<String, String> extGlobals = SysmConf.getPayGenConfigInfo(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest());
		  	  
			
			infcPkgYe160401Vo.setDpobCd(infcPkgYe161010Vo.getDpobCd());    									/** column 사업장코드 : dpobCd */
			infcPkgYe160401Vo.setYrtxBlggYr(infcPkgYe161010Vo.getYrtxBlggYr());    							/** column 귀속연도 : yrtxBlggYr */
			infcPkgYe160401Vo.setClutSeptCd(infcPkgYe161010Vo.getClutSeptCd());    							/** column 연말정산구분코드 : clutSeptCd */
			infcPkgYe160401Vo.setSystemkey(infcPkgYe161010Vo.getSystemkey());    							/** column SYSTEMKEY : systemkey */
	  		
			infcPkgYe160401Vo.setPayrMangDeptCd(infcPkgYe161010Vo.getPayrMangDeptCd());    					/** column 급여관리부서코드 : payrMangDeptCd */
			infcPkgYe160401Vo.setDeptCd(infcPkgYe161010Vo.getDeptCd());    									/** column 부서코드 : deptCd */
			infcPkgYe160401Vo.setTypOccuCd(infcPkgYe161010Vo.getTypOccuCd());    							/** column 직종코드 : typOccuCd */ 
			infcPkgYe160401Vo.setDtilOccuInttnCd(infcPkgYe161010Vo.getDtilOccuInttnCd());    				/** column 직종세통합코드 : dtilOccuInttnCd */
			infcPkgYe160401Vo.setBusinCd(infcPkgYe161010Vo.getBusinCd());    								/** column 사업코드 : businCd */
			infcPkgYe160401Vo.setEmymtDivCd(infcPkgYe161010Vo.getEmymtDivCd());    							/** column 고용구분코드 : emymtDivCd */ 
	        
			infcPkgYe160401Vo.setDpobCd(sessionUser.getDpobCd());  					//사업장코드
			infcPkgYe160401Vo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  	//단위기관담당자여부 
			infcPkgYe160401Vo.setUsrId(sessionUser.getUsrId());  
	              
			infcPkgYe160401Vo.setTypOccuCdArr(infcPkgYe161010Vo.getTypOccuCdArr());  
			infcPkgYe160401Vo.setDtilOccuInttnCdArr(infcPkgYe161010Vo.getDtilOccuInttnCdArr()); 
	            
	       /******************************** 권한 ************************************************************************/
	              
			infcPkgYe160401Vo.setDeptCdAuth(MSFSharedUtils.allowNulls(infcPkgYe161010Vo.getDeptCd()).replace(",", ""));  //권한처리를위해 추가  
			infcPkgYe160401Vo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(infcPkgYe161010Vo.getDtilOccuInttnCd()).replace(",", ""));  
	            
	        if (infcPkgYe161010Vo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(infcPkgYe161010Vo.getDeptCd()))) { 
	        	infcPkgYe160401Vo.setDeptCd("");  //부서코드
           } 	
	  		
	        infcPkgYe160401Vo.setKybdr(sessionUser.getUsrId());    										/** column 입력자 : kybdr */
	        infcPkgYe160401Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	/** column 입력주소 : inptAddr */
	        infcPkgYe160401Vo.setIsmt(sessionUser.getUsrId());    										/** column 수정자 : ismt */
	        infcPkgYe160401Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	/** column 수정주소 : revnAddr */
	  		
	        dataCheck = "";
		    	//****************************** YE160401 데이타 급여 자료 이관 [1]******************************************* 
	        dataCheck = yeta4100PayrService.fnYeta4100_YE160401_PAYR_2019_CREATE_Insert(infcPkgYe160401Vo);   //YE160401 현근무지 급여지급 명세
		  	
		  		if (MSFSharedUtils.paramNull(dataCheck)) {
		  			
		  			// ******************************급여자료 이관 - 연말정산 4대보험 인서트 Ye161050 /Ye161055 /Ye161060 [1-1]************* 
		  			dataCheck = "";
		  			int dataChk = 0;
		  			dataCheck = yeta4100PayrService.fnYeta4100_Ye161055_PAYR_2019_CREATE_Insert(infcPkgYe160401Vo);   //Ye161055VO();	//C_연금보험료_공적연금상세
				  		 
		  			if (MSFSharedUtils.paramNull(dataCheck)) {
		  			// ******************************급여자료 이관 - 연말정산 4대보험 인서트 Ye161050 /Ye161055 /Ye161060 [1-2]************* 
			  			dataCheck = "";
			  			dataCheck = yeta4100PayrService.fnYeta4100_Ye161050_PAYR_2019_CREATE_Insert(infcPkgYe160401Vo);   //Ye161050VO();	//C_연금보험료공제
					        
			  			if (MSFSharedUtils.paramNull(dataCheck)) {
			  			   // ******************************급여자료 이관 - 연말정산 4대보험 인서트 Ye161050 /Ye161055 /Ye161060 [1-3]************* 
				  			dataCheck = "";
				  			dataCheck = yeta4100PayrService.fnYeta4100_Ye161060_PAYR_2019_CREATE_Insert(infcPkgYe160401Vo);   //Ye161060VO();	//C_특별소득공제 
						  		  
				  			if (MSFSharedUtils.paramNull(dataCheck)) {  
				  				
				  				 //****************************** Ye160402 연말정산기본 과세 감면 인서트 [2]******************************************** 
						  		 
						  		
						  		infcPkgYe160402Vo.setDpobCd(infcPkgYe160401Vo.getDpobCd());    									/** column 사업장코드 : dpobCd */
						  		infcPkgYe160402Vo.setYrtxBlggYr(infcPkgYe160401Vo.getYrtxBlggYr());    							/** column 귀속연도 : yrtxBlggYr */
						  		infcPkgYe160402Vo.setClutSeptCd(infcPkgYe160401Vo.getClutSeptCd());    							/** column 연말정산구분코드 : clutSeptCd */
						  		infcPkgYe160402Vo.setSystemkey(infcPkgYe160401Vo.getSystemkey());    							/** column SYSTEMKEY : systemkey */
						  		
						  		infcPkgYe160402Vo.setPayrMangDeptCd(infcPkgYe160401Vo.getPayrMangDeptCd());    					/** column 급여관리부서코드 : payrMangDeptCd */
						  		infcPkgYe160402Vo.setDeptCd(infcPkgYe160401Vo.getDeptCd());    									/** column 부서코드 : deptCd */
						  		infcPkgYe160402Vo.setTypOccuCd(infcPkgYe160401Vo.getTypOccuCd());    							/** column 직종코드 : typOccuCd */ 
						  		infcPkgYe160402Vo.setDtilOccuInttnCd(infcPkgYe160401Vo.getDtilOccuInttnCd());    				/** column 직종세통합코드 : dtilOccuInttnCd */
						  		infcPkgYe160402Vo.setBusinCd(infcPkgYe160401Vo.getBusinCd());    								/** column 사업코드 : businCd */
						  		infcPkgYe160402Vo.setEmymtDivCd(infcPkgYe160401Vo.getEmymtDivCd());    							/** column 고용구분코드 : emymtDivCd */ 
						        
						  		infcPkgYe160402Vo.setDpobCd(sessionUser.getDpobCd());  					//사업장코드
						  		infcPkgYe160402Vo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  	//단위기관담당자여부 
						  		infcPkgYe160402Vo.setUsrId(sessionUser.getUsrId());  
						              
						  		infcPkgYe160402Vo.setTypOccuCdArr(infcPkgYe161010Vo.getTypOccuCdArr());  
						  		infcPkgYe160402Vo.setDtilOccuInttnCdArr(infcPkgYe161010Vo.getDtilOccuInttnCdArr()); 
						            
						       /******************************** 권한 ************************************************************************/
						              
						  		infcPkgYe160402Vo.setDeptCdAuth(MSFSharedUtils.allowNulls(infcPkgYe160401Vo.getDeptCd()).replace(",", ""));  //권한처리를위해 추가  
						  		infcPkgYe160402Vo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(infcPkgYe160401Vo.getDtilOccuInttnCd()).replace(",", ""));  
						            
						        if (infcPkgYe160402Vo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(infcPkgYe160401Vo.getDeptCd()))) { 
						        	infcPkgYe160402Vo.setDeptCd("");  //부서코드
				               } 	
						  		
						  		infcPkgYe160402Vo.setKybdr(sessionUser.getUsrId());    										/** column 입력자 : kybdr */
						  		infcPkgYe160402Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	/** column 입력주소 : inptAddr */
						  		infcPkgYe160402Vo.setIsmt(sessionUser.getUsrId());    										/** column 수정자 : ismt */
						  		infcPkgYe160402Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	/** column 수정주소 : revnAddr */
						  		
						  		dataCheck = "";
						  		
						  		dataCheck = yeta4100PayrService.fnYeta4100_YE160402_PAYR_2019_CREATE_Insert(infcPkgYe160402Vo);   //infcPkgYe160402Vo 
						  		
						  		if (MSFSharedUtils.paramNull(dataCheck)) {    
						  			
						  			 //****************************** Ye160403 연말정산기본 비과세 감면 인서트  [3]******************************************** 
								  	 
							  		
							  		infcPkgYe160403Vo = new InfcPkgYe160403VO(); // 비과세 감면소득
							  		infcPkgYe160403Vo.setDpobCd(infcPkgYe160401Vo.getDpobCd());    									/** column 사업장코드 : dpobCd */
							  		infcPkgYe160403Vo.setYrtxBlggYr(infcPkgYe160401Vo.getYrtxBlggYr());    							/** column 귀속연도 : yrtxBlggYr */
							  		infcPkgYe160403Vo.setClutSeptCd(infcPkgYe160401Vo.getClutSeptCd());    							/** column 연말정산구분코드 : clutSeptCd */
							  		infcPkgYe160403Vo.setSystemkey(infcPkgYe160401Vo.getSystemkey());    							/** column SYSTEMKEY : systemkey */
							  		
							  		infcPkgYe160403Vo.setPayrMangDeptCd(infcPkgYe160401Vo.getPayrMangDeptCd());    					/** column 급여관리부서코드 : payrMangDeptCd */
							  		infcPkgYe160403Vo.setDeptCd(infcPkgYe160401Vo.getDeptCd());    									/** column 부서코드 : deptCd */
							  		infcPkgYe160403Vo.setTypOccuCd(infcPkgYe160401Vo.getTypOccuCd());    							/** column 직종코드 : typOccuCd */ 
							  		infcPkgYe160403Vo.setDtilOccuInttnCd(infcPkgYe160401Vo.getDtilOccuInttnCd());    				/** column 직종세통합코드 : dtilOccuInttnCd */
							  		infcPkgYe160403Vo.setBusinCd(infcPkgYe160401Vo.getBusinCd());    								/** column 사업코드 : businCd */
							  		infcPkgYe160403Vo.setEmymtDivCd(infcPkgYe160401Vo.getEmymtDivCd());    							/** column 고용구분코드 : emymtDivCd */ 
							        
							  		infcPkgYe160403Vo.setDpobCd(sessionUser.getDpobCd());  					//사업장코드
							  		infcPkgYe160403Vo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  	//단위기관담당자여부 
							  		infcPkgYe160403Vo.setUsrId(sessionUser.getUsrId());  
							  		/******************************** 권한 ************************************************************************/
							  		infcPkgYe160403Vo.setTypOccuCdArr(infcPkgYe161010Vo.getTypOccuCdArr());  
							  		infcPkgYe160403Vo.setDtilOccuInttnCdArr(infcPkgYe161010Vo.getDtilOccuInttnCdArr());  
							  		
							  		infcPkgYe160402Vo.setDeptCdAuth(MSFSharedUtils.allowNulls(infcPkgYe160401Vo.getDeptCd()).replace(",", ""));  //권한처리를위해 추가  
							  		infcPkgYe160402Vo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(infcPkgYe160401Vo.getDtilOccuInttnCd()).replace(",", ""));  
							            
							        if (infcPkgYe160402Vo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(infcPkgYe160401Vo.getDeptCd()))) { 
							        	infcPkgYe160402Vo.setDeptCd("");  //부서코드
							        } 	
							  		infcPkgYe160403Vo.setKybdr(sessionUser.getUsrId());    										/** column 입력자 : kybdr */
							  		infcPkgYe160403Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	/** column 입력주소 : inptAddr */
							  		infcPkgYe160403Vo.setIsmt(sessionUser.getUsrId());    										/** column 수정자 : ismt */
							  		infcPkgYe160403Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	/** column 수정주소 : revnAddr */
							  		
							  		dataCheck = "";
							  		dataCheck = yeta4100PayrService.fnYeta4100_YE160403_PAYR_2019_CREATE_Insert(infcPkgYe160403Vo);   //yetaPrc3200Vo 
							  		
							  		if (MSFSharedUtils.paramNull(dataCheck)) { 
							  			
							  		//****************************** 급여자료 이관 - 연말정산상세 YETA3000 업데이트  [4] ********************************************  
								  		
								  		//*******************************급여관련사항 업데이트 *********************************************************************/
								  	// {가족사항 업데이트 YETA3220 고용/건강보험료외 업데이트  }
										// {**************************가족사항 [5_1]********************************}
							  			infcPkgYe161040Vo.setDpobCd(sessionUser.getDpobCd());    																/** column 사업장코드 : dpobCd */
										infcPkgYe161040Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(infcPkgYe161010Vo.getYrtxBlggYr()));    							/** column 귀속연도 : yrtxBlggYr */
										infcPkgYe161040Vo.setClutSeptCd(MSFSharedUtils.allowNulls(infcPkgYe161010Vo.getClutSeptCd()));    							/** column 연말정산구분코드 : clutSeptCd */
										infcPkgYe161040Vo.setSystemkey(MSFSharedUtils.allowNulls(infcPkgYe161010Vo.getSystemkey()));    								/** column SYSTEMKEY : systemkey */
	 
										infcPkgYe161040Vo.setKybdr(sessionUser.getUsrId());    																/** column 입력자 : kybdr */
										infcPkgYe161040Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    							/** column 입력주소 : inptAddr */
										infcPkgYe161040Vo.setIsmt(sessionUser.getUsrId());    																	/** column 수정자 : ismt */
										infcPkgYe161040Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    							/** column 수정주소 : revnAddr */
										
										logger.debug("5-1. 소득공제명세생성 시작 ");
										dataCheck = "";
										dataCheck =  yeta4100PayrService.fnYeta4100_YE161040_2019_CREATE_Insert01(infcPkgYe161040Vo);   //infcPkgYe161040Vo   
										bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "소득공제명세생성 .","데이타확인",""));
										logger.debug("5-2. 소득공제명세생성 종료 ");	
										if (MSFSharedUtils.paramNull(dataCheck)) { 
											
											
											logger.debug("5-3. 소득공제명세생성 시작 ");
											dataCheck = "";
											dataCheck =  yeta4100PayrService.fnYeta4100_YE161040_2019_CREATE_Insert02(infcPkgYe161040Vo);   //infcPkgYe161040Vo   
											bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "소득공제명세생성.","데이타확인",""));
											logger.debug("5-4. 소득공제명세생성 종료 ");	
											
											if (MSFSharedUtils.paramNull(dataCheck)) {
												
												infcPkgYe161040Vo.setDpobCd(infcPkgYe161010Vo.getDpobCd());    																/** column 사업장코드 : dpobCd */
												infcPkgYe161040Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(infcPkgYe161010Vo.getYrtxBlggYr()));    							/** column 귀속연도 : yrtxBlggYr */
												infcPkgYe161040Vo.setClutSeptCd(MSFSharedUtils.allowNulls(infcPkgYe161010Vo.getClutSeptCd()));    							/** column 연말정산구분코드 : clutSeptCd */
												infcPkgYe161040Vo.setSystemkey(MSFSharedUtils.allowNulls(infcPkgYe161010Vo.getSystemkey()));    								/** column SYSTEMKEY : systemkey */

												infcPkgYe161040Vo.setKybdr(sessionUser.getUsrId());    																/** column 입력자 : kybdr */
												infcPkgYe161040Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    							/** column 입력주소 : inptAddr */
												infcPkgYe161040Vo.setIsmt(sessionUser.getUsrId());    																	/** column 수정자 : ismt */
												infcPkgYe161040Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    							/** column 수정주소 : revnAddr */
												
												infcPkgYe161040Vo.setCdVvalKrnCd("Y0140001");
												//2014년 고용건강보험료외 업데이트
											 	logger.debug("5-1. 고용건강보험료외 UPDATE 시작 ");
											 	dataChk = 0;
											 	dataChk = yeta4100PayrService.fnYeta4100_YE161040_2019_INSU_FETC_Update(infcPkgYe161040Vo);   //infcPkgYeta4220Vo   
												bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "고용건강보험료외 생성.","데이타확인",""));
												logger.debug("5-2. 고용건강보험료외 UPDATE 종료 ");	  	       
												
												 if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_15.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
													// 안성시청 : 급여 노조회비를 기부금(40)으로 가져온다.
														logger.debug("5-3. 급여 노조회비 기부금 반영 시작 ");
														
														infcPkgYe165010Vo.setDpobCd(infcPkgYe160401Vo.getDpobCd());    									/** column 사업장코드 : dpobCd */
														infcPkgYe165010Vo.setYrtxBlggYr(infcPkgYe160401Vo.getYrtxBlggYr());    							/** column 귀속연도 : yrtxBlggYr */
														infcPkgYe165010Vo.setClutSeptCd(infcPkgYe160401Vo.getClutSeptCd());    							/** column 연말정산구분코드 : clutSeptCd */
														infcPkgYe165010Vo.setSystemkey(infcPkgYe160401Vo.getSystemkey());    							/** column SYSTEMKEY : systemkey */

														
														infcPkgYe165010Vo.setPayItemCd("D9500400"); 	// 노조회비
														infcPkgYe165010Vo.setConbCd("B0230040");    													/** column 기부유형코드 : conbCd */
														infcPkgYe165010Vo.setConbChgCd("40");    														/** column 기부유형전환코드 : conbChgCd */
														infcPkgYe165010Vo.setYrsMateClCd("Y0140001");    												/** column 기부국세자료구분코드 : yrsMateClCd */
														infcPkgYe165010Vo.setDntcntn("노조회비");    														/** column 기부내용 : dntcntn */
														infcPkgYe165010Vo.setCoplNm("전국민주일반노동조합연맹");    												/** column 기부처_상호명 : coplNm */
														infcPkgYe165010Vo.setBsnoEncCntn("1428284431");    												/** column 기부처_사업자등록번호 : bsnoEncCntn */
														infcPkgYe165010Vo.setCnbtRltClCd("Y0180001");    												/** column 기부자관계코드 : cnbtRltClCd */
														infcPkgYe165010Vo.setCnbtRltChgCd("1");    														/** column 기부자관계전환코드 : cnbtRltChgCd */
//														infcPkgYe165010Vo.setCnbtFnm(MSFSharedUtils.allowNulls(egovMap.get("cnbtFnm")));    /** column 기부자성명 : cnbtFnm */
//														infcPkgYe165010Vo.setResnoEncCntn(MSFSharedUtils.allowNulls(egovMap.get("resnoEncCntn")));    /** column 기부자_주민등록번호 : resnoEncCntn */
														
														infcPkgYe165010Vo.setDntScnt(new BigDecimal("1"));    											/** column 기부명세건수 : dntScnt */
//														ye165010Vo.setUseSumAmt(MSFSharedUtils.allowNulls(egovMap.get("useSumAmt")));    /** column 기부명세합계금액 : useSumAmt */
//														infcPkgYe165010Vo.setDdcTrgtConbAmt(new BigDecimal("0"));    									/** column 공제대상기부금액 : ddcTrgtConbAmt */
														infcPkgYe165010Vo.setConbSumAmt(new BigDecimal("0"));    										/** column 기부장려금신청금 : conbSumAmt */
														infcPkgYe165010Vo.setCnbtEtc("0");    															/** column 기부금기타 : cnbtEtc */
														
														
														infcPkgYe165010Vo.setKybdr(sessionUser.getUsrId());    											/** column 입력자 : kybdr */
														infcPkgYe165010Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());		/** column 입력주소 : inptAddr */
														infcPkgYe165010Vo.setIsmt(sessionUser.getUsrId());    											/** column 수정자 : ismt */
														infcPkgYe165010Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());		/** column 수정주소 : revnAddr */
														
														yeta4100PayrService.fnYeta4100_YE165010_2019_PAYR_CREATE(infcPkgYe165010Vo); 
											  	
														logger.debug("5-3. 급여 노조회비 기부금 반영 종료 ");
												 }else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
										 			//광명로직 
													 	logger.debug("5-3. 급여 노조회비 기부금 반영 시작 ");
														
														infcPkgYe165010Vo.setDpobCd(infcPkgYe160401Vo.getDpobCd());    									/** column 사업장코드 : dpobCd */
														infcPkgYe165010Vo.setYrtxBlggYr(infcPkgYe160401Vo.getYrtxBlggYr());    							/** column 귀속연도 : yrtxBlggYr */
														infcPkgYe165010Vo.setClutSeptCd(infcPkgYe160401Vo.getClutSeptCd());    							/** column 연말정산구분코드 : clutSeptCd */
														infcPkgYe165010Vo.setSystemkey(infcPkgYe160401Vo.getSystemkey());    							/** column SYSTEMKEY : systemkey */

														infcPkgYe165010Vo.setPayItemCd("D9500400"); 	// 노조회비
														infcPkgYe165010Vo.setConbCd("B0230040");    													/** column 기부유형코드 : conbCd */
														infcPkgYe165010Vo.setConbChgCd("40");    														/** column 기부유형전환코드 : conbChgCd */
														infcPkgYe165010Vo.setYrsMateClCd("Y0140001");    												/** column 기부국세자료구분코드 : yrsMateClCd */
														infcPkgYe165010Vo.setDntcntn("노조회비");    														/** column 기부내용 : dntcntn */
														infcPkgYe165010Vo.setCoplNm("전국민주연합노동조합");    												/** column 기부처_상호명 : coplNm */
														infcPkgYe165010Vo.setBsnoEncCntn("1288262620");    												/** column 기부처_사업자등록번호 : bsnoEncCntn */
														infcPkgYe165010Vo.setCnbtRltClCd("Y0180001");    												/** column 기부자관계코드 : cnbtRltClCd */
														infcPkgYe165010Vo.setCnbtRltChgCd("1");    														/** column 기부자관계전환코드 : cnbtRltChgCd */
//														infcPkgYe165010Vo.setCnbtFnm(MSFSharedUtils.allowNulls(egovMap.get("cnbtFnm")));    /** column 기부자성명 : cnbtFnm */
//														infcPkgYe165010Vo.setResnoEncCntn(MSFSharedUtils.allowNulls(egovMap.get("resnoEncCntn")));    /** column 기부자_주민등록번호 : resnoEncCntn */
														
														infcPkgYe165010Vo.setDntScnt(new BigDecimal("1"));    											/** column 기부명세건수 : dntScnt */
//														ye165010Vo.setUseSumAmt(MSFSharedUtils.allowNulls(egovMap.get("useSumAmt")));    /** column 기부명세합계금액 : useSumAmt */
//														infcPkgYe165010Vo.setDdcTrgtConbAmt(new BigDecimal("0"));    									/** column 공제대상기부금액 : ddcTrgtConbAmt */
														infcPkgYe165010Vo.setConbSumAmt(new BigDecimal("0"));    										/** column 기부장려금신청금 : conbSumAmt */
														infcPkgYe165010Vo.setCnbtEtc("0");    															/** column 기부금기타 : cnbtEtc */
														
														
														infcPkgYe165010Vo.setKybdr(sessionUser.getUsrId());    											/** column 입력자 : kybdr */
														infcPkgYe165010Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());		/** column 입력주소 : inptAddr */
														infcPkgYe165010Vo.setIsmt(sessionUser.getUsrId());    											/** column 수정자 : ismt */
														infcPkgYe165010Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());		/** column 수정주소 : revnAddr */
														
														yeta4100PayrService.fnYeta4100_YE165010_2019_PAYR_CREATE(infcPkgYe165010Vo); 
											  	
														logger.debug("5-3. 급여 노조회비 기부금 반영 종료 ");
										 		
												 } 
//												
//										 		} 
											
												 
												 
//												if (dataChk >= 0) { 

													infcPkgYe161030Vo.setDpobCd(sessionUser.getDpobCd());    																/** column 사업장코드 : dpobCd */
													infcPkgYe161030Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(infcPkgYe161010Vo.getYrtxBlggYr()));    							/** column 귀속연도 : yrtxBlggYr */
													infcPkgYe161030Vo.setClutSeptCd(MSFSharedUtils.allowNulls(infcPkgYe161010Vo.getClutSeptCd()));    							/** column 연말정산구분코드 : clutSeptCd */
													infcPkgYe161030Vo.setSystemkey(MSFSharedUtils.allowNulls(infcPkgYe161010Vo.getSystemkey()));    								/** column SYSTEMKEY : systemkey */

													infcPkgYe161030Vo.setKybdr(sessionUser.getUsrId());    																/** column 입력자 : kybdr */
													infcPkgYe161030Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    							/** column 입력주소 : inptAddr */
													infcPkgYe161030Vo.setIsmt(sessionUser.getUsrId());    																	/** column 수정자 : ismt */
													infcPkgYe161030Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    							/** column 수정주소 : revnAddr */
													
													// {**************************부녀자공제 [6]********************************}
													// {부녀자공제란 여성근로소득자 본인인경우 업데이트 처리 }/
													logger.debug("6. 부녀자공제 UPDATE 시작 ");
													dataChk = 0;
													dataChk =  yeta4100PayrService.fnYeta4100_YE161030_2019_CREATE_Update(infcPkgYe161030Vo);   //infcPkgYe161030Vo   
													bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "부녀자공제 UPDATE 수정.","데이타확인",""));
													logger.debug("6. 부녀자공제 UPDATE 종료 ");    
													if (dataChk >= 0) {  
														
														 
														//신용카드  			  	    
														infcPkgYe166020Vo.setDpobCd(sessionUser.getDpobCd());    																/** column 사업장코드 : dpobCd */
														infcPkgYe166020Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(infcPkgYe161010Vo.getYrtxBlggYr()));    							/** column 귀속연도 : yrtxBlggYr */
														infcPkgYe166020Vo.setClutSeptCd(MSFSharedUtils.allowNulls(infcPkgYe161010Vo.getClutSeptCd()));    							/** column 연말정산구분코드 : clutSeptCd */
														infcPkgYe166020Vo.setSystemkey(MSFSharedUtils.allowNulls(infcPkgYe161010Vo.getSystemkey()));    								/** column SYSTEMKEY : systemkey */

														infcPkgYe166020Vo.setKybdr(sessionUser.getUsrId());    																/** column 입력자 : kybdr */
														infcPkgYe166020Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    							/** column 입력주소 : inptAddr */
														infcPkgYe166020Vo.setIsmt(sessionUser.getUsrId());    																	/** column 수정자 : ismt */
														infcPkgYe166020Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    							/** column 수정주소 : revnAddr */
														dataCheck = "";
														dataCheck = yeta4100PayrService.fnYeta4100_YE166020_2019_CREATE_Insert01(infcPkgYe166020Vo);   //infcPkgYeta4220Vo 
														
														if (MSFSharedUtils.paramNull(dataCheck)) { 

															dataCheck = "";
															dataCheck = yeta4100PayrService.fnYeta4100_YE166020_2019_CREATE_Insert02(infcPkgYe166020Vo);   //infcPkgYeta4220Vo 
															
															bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "신용카드인적 생성.","데이타확인","")); 
															logger.debug("5. 신용카드 INSERT 종료 ");
															if (MSFSharedUtils.paramNull(dataCheck)) { 
																
																//신용카드 
																infcPkgYe166010Vo.setDpobCd(sessionUser.getDpobCd());    																/** column 사업장코드 : dpobCd */
																infcPkgYe166010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(infcPkgYe161010Vo.getYrtxBlggYr()));    							/** column 귀속연도 : yrtxBlggYr */
																infcPkgYe166010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(infcPkgYe161010Vo.getClutSeptCd()));    							/** column 연말정산구분코드 : clutSeptCd */
																infcPkgYe166010Vo.setSystemkey(MSFSharedUtils.allowNulls(infcPkgYe161010Vo.getSystemkey()));    								/** column SYSTEMKEY : systemkey */

																infcPkgYe166010Vo.setKybdr(sessionUser.getUsrId());    																/** column 입력자 : kybdr */
																infcPkgYe166010Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    							/** column 입력주소 : inptAddr */
																infcPkgYe166010Vo.setIsmt(sessionUser.getUsrId());    																	/** column 수정자 : ismt */
																infcPkgYe166010Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    							/** column 수정주소 : revnAddr */
																dataCheck = "";
																dataCheck = yeta4100PayrService.fnYeta4100_YE166010_2019_CREATE_Insert(infcPkgYe166010Vo);   //infcPkgYeta4220Vo   
																bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "신용카드계산 생성.","데이타확인","")); 
																logger.debug("5.신용카드 INSERT 종료 ");
																 
																	
																	if (MSFSharedUtils.paramNull(dataCheck)) {	
																	
																		
																		infcPkgYe161070Vo.setDpobCd(sessionUser.getDpobCd());    																/** column 사업장코드 : dpobCd */
																		infcPkgYe161070Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(infcPkgYe161010Vo.getYrtxBlggYr()));    							/** column 귀속연도 : yrtxBlggYr */
																		infcPkgYe161070Vo.setClutSeptCd(MSFSharedUtils.allowNulls(infcPkgYe161010Vo.getClutSeptCd()));    							/** column 연말정산구분코드 : clutSeptCd */
																		infcPkgYe161070Vo.setSystemkey(MSFSharedUtils.allowNulls(infcPkgYe161010Vo.getSystemkey()));    								/** column SYSTEMKEY : systemkey */
									 
																		infcPkgYe161070Vo.setKybdr(sessionUser.getUsrId());    																/** column 입력자 : kybdr */
																		infcPkgYe161070Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    							/** column 입력주소 : inptAddr */
																		infcPkgYe161070Vo.setIsmt(sessionUser.getUsrId());    																	/** column 수정자 : ismt */
																		infcPkgYe161070Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    							/** column 수정주소 : revnAddr */
																		
																		dataCheck = "";
																		logger.debug("8. 그밖의 소득공제 INSERT 시작 ");
																		dataCheck =    yeta4100PayrService.fnYeta4100_YE161070_2019_CREATE_Insert(infcPkgYe161070Vo);   //infcPkgYeta4000Vo   
																		bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "그밖의 소득공제.","데이타확인",""));
																		logger.debug("8. 그밖의 소득공제 INSERT 종료 ");
																		
																		if (MSFSharedUtils.paramNull(dataCheck)) {	

																			infcPkgYe161080Vo.setDpobCd(sessionUser.getDpobCd());    																/** column 사업장코드 : dpobCd */
																			infcPkgYe161080Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(infcPkgYe161010Vo.getYrtxBlggYr()));    							/** column 귀속연도 : yrtxBlggYr */
																			infcPkgYe161080Vo.setClutSeptCd(MSFSharedUtils.allowNulls(infcPkgYe161010Vo.getClutSeptCd()));    							/** column 연말정산구분코드 : clutSeptCd */
																			infcPkgYe161080Vo.setSystemkey(MSFSharedUtils.allowNulls(infcPkgYe161010Vo.getSystemkey()));    								/** column SYSTEMKEY : systemkey */
										 
																			infcPkgYe161080Vo.setKybdr(sessionUser.getUsrId());    																/** column 입력자 : kybdr */
																			infcPkgYe161080Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    							/** column 입력주소 : inptAddr */
																			infcPkgYe161080Vo.setIsmt(sessionUser.getUsrId());    																	/** column 수정자 : ismt */
																			infcPkgYe161080Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());   
																			
																			dataCheck = "";
																			logger.debug("9. 세액감면및공제 INSERT 시작 ");
																			dataCheck =  yeta4100PayrService.fnYeta4100_YE161080_2019_CREATE_Insert(infcPkgYe161080Vo);   //infcPkgYeta4000Vo
																			
																			if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_15.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
																				// 안성시청이면 노조회비 기부금액 update
																				dataCheck = yeta4100PayrService.fnYeta4100_YE161080_2019_CREATE_Update_AS(infcPkgYe161080Vo);
																			}
																			
																			bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "세액감면및공제.","데이타확인",""));
																			logger.debug("9. 세액감면및공제 INSERT 종료 ");
																		
																			//	{**************************이월기부금  [7]********************************}
																			//	{이월기부금  YETA3190 인서트 }
																			
																			if (MSFSharedUtils.paramNull(dataCheck)) { 
																				
																				infcPkgYe165030TempVo.setDpobCd(sessionUser.getDpobCd());    																/** column 사업장코드 : dpobCd */
																				infcPkgYe165030TempVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(infcPkgYe161010Vo.getYrtxBlggYr()));    							/** column 귀속연도 : yrtxBlggYr */
																				infcPkgYe165030TempVo.setClutSeptCd(MSFSharedUtils.allowNulls(infcPkgYe161010Vo.getClutSeptCd()));    							/** column 연말정산구분코드 : clutSeptCd */
																				infcPkgYe165030TempVo.setSystemkey(MSFSharedUtils.allowNulls(infcPkgYe161010Vo.getSystemkey()));    								/** column SYSTEMKEY : systemkey */

																				infcPkgYe165030TempVo.setKybdr(sessionUser.getUsrId());    																/** column 입력자 : kybdr */
																				infcPkgYe165030TempVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    							/** column 입력주소 : inptAddr */
																				infcPkgYe165030TempVo.setIsmt(sessionUser.getUsrId());    																	/** column 수정자 : ismt */
																				infcPkgYe165030TempVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    							/** column 수정주소 : revnAddr */
																				
																				dataCheck = "";
																				logger.debug("7. 이월기부금 INSERT 시작 ");
																				dataCheck =    yeta4100PayrService.fnYeta4100_YE165030_TEMP_2019_CREATE_Insert(infcPkgYe165030TempVo);   //infcPkgYeta4190Vo   
																				bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "이월기부금 생성.","데이타확인",""));
																				logger.debug("7. 이월기부금 INSERT 종료");
																				
																				if (MSFSharedUtils.paramNull(dataCheck)) {
																					
																					infcPkgYe165030Vo.setDpobCd(sessionUser.getDpobCd());    																/** column 사업장코드 : dpobCd */
																					infcPkgYe165030Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(infcPkgYe161010Vo.getYrtxBlggYr()));    							/** column 귀속연도 : yrtxBlggYr */
																					infcPkgYe165030Vo.setClutSeptCd(MSFSharedUtils.allowNulls(infcPkgYe161010Vo.getClutSeptCd()));    							/** column 연말정산구분코드 : clutSeptCd */
																					infcPkgYe165030Vo.setSystemkey(MSFSharedUtils.allowNulls(infcPkgYe161010Vo.getSystemkey()));    								/** column SYSTEMKEY : systemkey */

																					infcPkgYe165030Vo.setKybdr(sessionUser.getUsrId());    																/** column 입력자 : kybdr */
																					infcPkgYe165030Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    							/** column 입력주소 : inptAddr */
																					infcPkgYe165030Vo.setIsmt(sessionUser.getUsrId());    																	/** column 수정자 : ismt */
																					infcPkgYe165030Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    							/** column 수정주소 : revnAddr */
																					
																					dataCheck = "";
																					logger.debug("7. 이월기부금 INSERT 시작 ");
																					dataCheck =    yeta4100PayrService.fnYeta4100_YE165030TempYE165030_2019_CREATE_Insert(infcPkgYe165030Vo);   //infcPkgYeta4190Vo   
																					bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "이월기부금 생성.","데이타확인",""));
																					logger.debug("7. 이월기부금 INSERT 종료");
																					
																				}
																				
																				//	{**************************연말정산상세  [8]********************************}
																				if (MSFSharedUtils.paramNull(dataCheck)) { 
																				// YETA3000 업데이트
																				 dataCheck = "";
System.out.println("=================급여이관===========YE169010 insert start");																				 
																				 dataCheck = yeta4100PayrService.fnYeta4100_YE169010_PAYR_2019_CREATE_Insert(infcPkgYe160401Vo);   //yetaPrc3210Vo 
System.out.println("==================급여이관==========YE169010 insert end");
																				
																				// 	{연말정산상세 YETA3000 인서트 } 
																			 	if (MSFSharedUtils.paramNull(dataCheck)) {
//																					dataCheck = "";
//																					logger.debug("10. 연말정산 상세 INSERT 시작 ");
//																					dataCheck =    yeta4100PayrService.fnYeta4100_YE169010_2019_CREATE_Insert(infcPkgYe161010Vo);   //infcPkgYeta4000Vo   
//																					bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "연말정산 정산.","데이타확인",""));
//																					logger.debug("10. 연말정산 상세 INSERT 종료 ");
																			 	
																			 		infcPkgYe169010AVo.setDpobCd(sessionUser.getDpobCd());    																/** column 사업장코드 : dpobCd */
																			 		infcPkgYe169010AVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(infcPkgYe161010Vo.getYrtxBlggYr()));    							/** column 귀속연도 : yrtxBlggYr */
																			 		infcPkgYe169010AVo.setClutSeptCd(MSFSharedUtils.allowNulls(infcPkgYe161010Vo.getClutSeptCd()));    							/** column 연말정산구분코드 : clutSeptCd */
																			 		infcPkgYe169010AVo.setSystemkey(MSFSharedUtils.allowNulls(infcPkgYe161010Vo.getSystemkey()));    								/** column SYSTEMKEY : systemkey */
												 
																			 		infcPkgYe169010AVo.setKybdr(sessionUser.getUsrId());    																/** column 입력자 : kybdr */
																					infcPkgYe169010AVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    							/** column 입력주소 : inptAddr */
																					infcPkgYe169010AVo.setIsmt(sessionUser.getUsrId());    																	/** column 수정자 : ismt */
																					infcPkgYe169010AVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());   
																					
																					dataCheck = "";
																					logger.debug("10. 연말정산 상세-표준공제적용 INSERT 시작 ");
																					dataCheck =    yeta4100PayrService.fnYeta4100_YE169010a_2019_CREATE_Insert(infcPkgYe169010AVo);   //infcPkgYeta4000Vo   
																					bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "연말정산(표준공제적용) 정산.","데이타확인",""));
																					logger.debug("10. 연말정산 상세표준공제적용 INSERT 종료 ");
																					
																					}
																			 	
																				
																				}
																			}
																			
																		}	
																
																
															      }  //
																	
															}
															
														} 
														
													
														
													}  //8부녀자공제 UPDATE 종료
												
//											}  //소득공제명세생성
											 	
									    } 
							  			
							  			
								  		
											
										} //7
									
							  			
							  		} // 6
							  		
							  		
						  		} //5
						  		
								
				  			} //4
					  	  	
			  			} //3
					
		  			}
					
		  		}
		  		
			 
		} catch (Exception ex) {
			ex.printStackTrace();
			ShowMessageBM smBm = new ShowMessageBM();
			smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR);
			smBm.setMenu("Yeta");
			smBm.setPhase("[연말정산 급여이관]대상자급여이관에러");
			smBm.setMessage(ex.getLocalizedMessage());
			smBm.setContent(ex.getMessage());
			bmResult.add(smBm); 
		}

		return bmResult;
	}  
 
}