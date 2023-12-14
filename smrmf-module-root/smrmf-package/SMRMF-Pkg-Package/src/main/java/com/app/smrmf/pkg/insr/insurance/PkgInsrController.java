/*
 *  
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information
 * of yysvip.tistory.com.,LTD. ("Confidential Information").
 */
package com.app.smrmf.pkg.insr.insurance;
 
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr3300VO;
import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr4200VO;
import com.app.smrmf.infc.insurance.server.vo.InfcPkgInsr5200VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0250VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0302VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0540SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0540VO;
import com.app.smrmf.pkg.insr.insurance.service.PkgInsrAmntVO;
import com.app.smrmf.pkg.insr.insurance.service.PkgInsrService;
import com.app.smrmf.pkg.insr.insurance.service.PkgInsrWorkVO;
import com.app.smrmf.pkg.insr.insurance.service.PkgPayrInsrStdVO;
import com.app.smrmf.pkg.payr.payrcalc.service.PayrCommCalcService;
import com.app.smrmf.pkg.payr.payrcalc.service.PkgPayrCommCalcVO;
import com.app.smrmf.props.ExtermsProps;

 
 /**
 * <pre> 
 *  4대보험 관련 처리 컨트롤러
 * 1. 패키지명 : com.app.smrmf.pkg.insr.insurance
 * 2. 타입명 : PkgInsrController.java
 * 3. 작성일 : 2016. 12. 20. 오후 3:19:36
 * 4. 작성자 : atres-pc
 * 5. 설명 :
 * </pre>
  */
public class PkgInsrController  extends AbstractCustomServiceImpl {

	private static final Logger LOGGER = LoggerFactory.getLogger(PkgInsrController.class);
 
	  private static PkgInsrController onePkgInsr;   
	  
	   private  PkgInsrController () {  
		   
	   }
	   
	   public static PkgInsrController getInstance() {
	       if(onePkgInsr==null) {
	    	   onePkgInsr = new PkgInsrController();
	       }
	       return onePkgInsr;
	   }
	   
	    //4대 사회보험 패키지  
	    @Autowired
        @Resource(name = "PkgInsrService")
        protected PkgInsrService pkgInsrService; 
			  
	    
	    //급여관련 공통 패키지 처리 
		@Autowired
	    @Resource(name = "PayrCommCalcService")
	    protected PayrCommCalcService payrCommCalcService;
			 
	    /**
	     * 
	     * <pre>
	     * 1. 개요 : 4대보험 요율 조회 
	     * 2. 처리내용 : 
	     * </pre>
	     * @Method Name : getSelect4InsureDataList
	     * @date : 2016. 12. 24.
	     * @author : atres-pc
	     * @history : 
	     *	-----------------------------------------------------------------------
	     *	변경일				작성자						변경내용  
	     *	----------- ------------------- ---------------------------------------
	     *	2016. 12. 24.		atres-pc				최초 작성 
	     *	-----------------------------------------------------------------------
	     * 
	     * @return
	     * @throws Exception 
	     */
	   public List getSelect4InsureDataList(HttpServletRequest request,InfcPkgPayr0250VO  payr0250Vo) throws Exception  {  
		    
		   
		   if  (pkgInsrService == null) { 
               WebApplicationContext wac = WebApplicationContextUtils.
                       getRequiredWebApplicationContext( request.getSession().getServletContext());
   
               pkgInsrService = (PkgInsrService) wac.getBean("PkgInsrService" ); 
              
          }   
	   
		  return pkgInsrService.select4InsureDataList(payr0250Vo); 
	   
	   } 
	   
	   public PkgInsrAmntVO select4InsureDataAmnt(HttpServletRequest request,InfcPkgPayr0250VO  payr0250Vo) throws Exception  {  
		    
		   
		   if  (pkgInsrService == null) { 
               WebApplicationContext wac = WebApplicationContextUtils.
                       getRequiredWebApplicationContext( request.getSession().getServletContext());
   
               pkgInsrService = (PkgInsrService) wac.getBean("PkgInsrService" ); 
              
          }   
	   
		  return pkgInsrService.select4InsureDataAmnt(payr0250Vo); 
	   
	   }   
	   
	   
	   public List getSelectPkgPayr0540List(HttpServletRequest request,InfcPkgPayr0540SrhVO payr0540SrhVo) throws Exception  {  
		   
		   if  (payrCommCalcService == null) { 
               WebApplicationContext wac = WebApplicationContextUtils.
                       getRequiredWebApplicationContext( request.getSession().getServletContext());
   
               payrCommCalcService = (PayrCommCalcService) wac.getBean("PayrCommCalcService" ); 
              
          }  
		   
		  return payrCommCalcService.selectPkgPayr0540List(payr0540SrhVo);
		   
	  } 
		   
	   
	   
	   /** 
	    * 
	    * <pre>
	    * 1. 개요 : 4대보험 처리 서비스 호출 보험별 처리 루틴 추가 처리 ... 
	    * 2. 처리내용 : HLTH_INSR_PRCS_YN	8			Y	VARCHAR2 (1 Byte)		건강보험처리여부
		* HLTH_INSR_PRMM_SRD	9			Y	NUMBER (10)		건강보험보험료차액    D0010100
		* LGTM_RCPTN_INSUR_SRD	10			Y	NUMBER (10)		장기요양보험차액       D0110100
		* YRTX_PRMM	11			Y	NUMBER (10)		건강보험정산보험료            D0010200
		* LGTM_RCPTN_YRTX_PRMM	12			Y	NUMBER (10)		장기요양정산보험료     D0110200
		* HLTH_INSR_REFD_ITRT	13			Y	NUMBER (10)		건강보험환급금이자   D0010500
		* LGTM_RCPTN_INSUR_REFD_ITRT	14			Y	NUMBER (10)		장기요양보험환급금이자  D0110500  
	    * </pre>
	    * @Method Name : func4InsureService
	    * @date : 2016. 12. 24.
	    * @author : atres-pc
	    * @history : 
	    *	-----------------------------------------------------------------------
	    *	변경일				작성자						변경내용  
	    *	----------- ------------------- ---------------------------------------
	    *	2016. 12. 24.		atres-pc				최초 작성 
	    *	-----------------------------------------------------------------------
	    * 
	    * @param payr0250Vo
	    * @return
	    * @throws Exception
	    */
	   public PkgInsrWorkVO func4InsureService(HttpServletRequest request
			                         ,PkgPayrCommCalcVO payCalculationVo
			                         ,InfcPkgPayr0250VO  payr0250Vo
			                         ,PkgInsrWorkVO pkgTpInsrWorkVo) throws Exception  {    
		   
		   
		   if  (payrCommCalcService == null) { 
               WebApplicationContext wac = WebApplicationContextUtils.
                       getRequiredWebApplicationContext( request.getSession().getServletContext());
   
               payrCommCalcService = (PayrCommCalcService) wac.getBean("PayrCommCalcService" ); 
              
          }  
		   
		   if  (pkgInsrService == null) { 
               WebApplicationContext wac = WebApplicationContextUtils.
                       getRequiredWebApplicationContext( request.getSession().getServletContext());
   
               pkgInsrService = (PkgInsrService) wac.getBean("PkgInsrService" ); 
              
          }  

		   InfcPkgPayr0540SrhVO payr0540SrhVo = new InfcPkgPayr0540SrhVO();
		   InfcPkgPayr0540VO  payr0540Vo = null;
		   PkgPayrInsrStdVO payrInsrStdVo = null;
		   InfcPkgPayr0302VO  payr0302Vo = new InfcPkgPayr0302VO();
		   
		   PkgInsrWorkVO pkgInsrWorkVo = new PkgInsrWorkVO();
		   PkgInsrAmntVO pkgInsrAmntVo = new PkgInsrAmntVO();
		   MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		    
		   //PkgPayrCommCalcVO payCalculationVo = null;
		  
           
		   //사대보험계산로직추가 에외처리로직 추가 
	       /*########################################################################################*/
	       /**   에외처리로직 추가                                                                                                                                                                      **/
	       /*########################################################################################*/    
	       payr0540SrhVo.setDpobCd(payr0250Vo.getDpobCd());
	       payr0540SrhVo.setSystemkey(payCalculationVo.getSystemkey());
	       payr0540SrhVo.setPymtDt(payr0250Vo.getPymtDt());  //지급구간 
	       payr0540SrhVo.setJobYrMnth(payr0250Vo.getJobYrMnth());  //지급구간 
	       payr0540SrhVo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));
	       //공제테이블 
	       List lisPayr0540 = payrCommCalcService.selectPkgPayr0540List(payr0540SrhVo);
	       
	       /*########################################################################################*/
	       /**   에외처리로직 추가                                                                                                                                                                                                    **/
	       /*########################################################################################*/  
	       
	       
	       /*******************************************************************************************/
	       /*** 금액으로 처리 하기 위한 부분 추가함                                                                                                                                                                             ***/
	       /*******************************************************************************************/
	       pkgInsrAmntVo = select4InsureDataAmnt(request,payr0250Vo);  
	       
	       
	       //사회보험요율가져오기 
           List insureList = getSelect4InsureDataList(request,payr0250Vo);  
           
           if (insureList.size() > 0) {
        	  //  BaseModel bm = new BaseModel();
        	  // ShowMessageBM smBm = new ShowMessageBM();
        	  // smBm.setDivision(PropPayGenConfs.PAYGEN_INFO);
        	  // smBm.setMenu("Payr");
        	  // smBm.setPhase("[급여]4대보험요율");
        	  // smBm.setMessage("불러오기성공");
        	  // smBm.setContent("");
        	  // bmResult.add(smBm); 
           } 
	       
	       //기본적으로 계산되어 나오나 값이 없는 경우에는 값을 가지고와서 처리함. 과세대상금액으로 처리 
	       for(int iCnt01 = 0;iCnt01 < insureList.size();iCnt01++) {
	           
	           payrInsrStdVo  = new PkgPayrInsrStdVO();
	          // payrInsrStdVo = (PayrInsrStdVO)insureList.get(iCnt01);
	           BeanUtils.copyProperties(payrInsrStdVo,insureList.get(iCnt01));
	           //건강보험 
	           pkgInsrWorkVo.setTpHlthInsrPayAmt(BigDecimal.ZERO);
	           //요양 
	           pkgInsrWorkVo.setTpHlthInsrRcptnPayAmt(BigDecimal.ZERO);
	           
	           //건강보험 
	         //  pkgInsrWorkVo.setTpYrtxPrmm(BigDecimal.ZERO);
	           //요양 
	         //  pkgInsrWorkVo.setTpLgtmRcptnYrtxPrmm(BigDecimal.ZERO); 
	           
	           //환급금이자  
	         //  pkgInsrWorkVo.setTpHlthInsrRefdItrt(BigDecimal.ZERO);
	           //장기요양보험환급금이자 
	         //  pkgInsrWorkVo.setTpLgtmRcptnInsurRefdItrt(BigDecimal.ZERO);  
	           
	            //국민연금  
	           pkgInsrWorkVo.setTpNatPennAmt(BigDecimal.ZERO);
	           //고용 
	           pkgInsrWorkVo.setTpUmytInsrApptnAmt(BigDecimal.ZERO);
	           //보수금액 
	           pkgInsrWorkVo.setTpPymtAmnt(BigDecimal.ZERO);
	              
	           pkgInsrWorkVo.setTpDducTotAmnt(BigDecimal.ZERO);
	           
	           /*******************************주의해서처리 해야 함 ***************************************/
     	       //공제금액합계
     	      // pkgInsrWorkVo.setTpDducTotAmnt(pkgTpInsrWorkVo.getTpDducTotAmnt());
     	       //기본금액 
     	       pkgInsrWorkVo.setTpStdPymtTotAmnt(pkgTpInsrWorkVo.getTpStdPymtTotAmnt());
     	        
	           pkgInsrWorkVo.setTpPymtAmnt(pkgTpInsrWorkVo.getTpTxtnTotAmnt());  //보수금액 
	           
	           pkgInsrWorkVo.setTpWorkIncmTxtnSum(pkgTpInsrWorkVo.getTpPymtAmnt());  //과세대상금액 
	           /*******************************주의해서처리 해야 함 ***************************************/
	           //B013 
	           //건강보험
	           if (payCalculationVo.getHlthInsrApptnYn().equals("Y")) {
	               
	        	      /************************** 건강보험 금액처리 부추가 ********************************************************************/
	         
	        	       if (MSFSharedUtils.paramNotNull(pkgInsrAmntVo) && MSFSharedUtils.paramNotNull(pkgInsrAmntVo.getSystemkey()) && 
	        	    		      pkgInsrAmntVo.getHlthInsrPrmmSrd().compareTo(BigDecimal.ZERO) != 0) {
	        	    	   
	        	    	   		   InfcPkgInsr3300VO infcPkgInsr3300Vo = new InfcPkgInsr3300VO();
	        	    	           //건강보험 정산, 건강보험환급금이자....
	        	    	          // BigDecimal bdHlthInsrPrmmSrd = BigDecimal.ZERO;   //건강보험
	        	    	          // BigDecimal bdLgtmRcptnInsurSrd = BigDecimal.ZERO; //장기요양보험
	        	    	   
	        	    	          
	        	    	         //  bdHlthInsrPrmmSrd = (pkgInsrAmntVo.getHlthInsrPrmmSrd().add(pkgInsrAmntVo.getYrtxPrmm())).add(pkgInsrAmntVo.getHlthInsrRefdItrt());
	        	    	         //  bdLgtmRcptnInsurSrd = (pkgInsrAmntVo.getLgtmRcptnInsurSrd().add(pkgInsrAmntVo.getLgtmRcptnYrtxPrmm())).add(pkgInsrAmntVo.getLgtmRcptnInsurRefdItrt());
	        	    	        
	        	    	           //건강보험 
	        	    	           pkgInsrWorkVo.setTpHlthInsrPayAmt(pkgInsrAmntVo.getHlthInsrPrmmSrd());
	        	    			   //장기요양 
				                   pkgInsrWorkVo.setTpHlthInsrRcptnPayAmt(pkgInsrAmntVo.getLgtmRcptnInsurSrd());
				                   
				                   // 건강보험 테이블 업데이트 payr3300  

									infcPkgInsr3300Vo.setDpobCd(pkgInsrAmntVo.getDpobCd());    /** column 사업장코드 : dpobCd */
									infcPkgInsr3300Vo.setNofctYrMnth(pkgInsrAmntVo.getNofctYrMnth());    /** column 고지년월 : nofctYrMnth */
									infcPkgInsr3300Vo.setNofctDspty(pkgInsrAmntVo.getNofctDspty());    /** column 고지차수 : nofctDspty */
									infcPkgInsr3300Vo.setSystemkey(pkgInsrAmntVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
								//	infcPkgInsr3300Vo.setEmymtSeilNum(pkgInsrAmntVo.getEmymtSeilNum());    /** column 고용일련번호 : emymtSeilNum */
									infcPkgInsr3300Vo.setDducYrMnth(pkgInsrAmntVo.getHlthDducYrMnth());    /** column 공제년월 : dducYrMnth */
								//	infcPkgInsr3300Vo.setHlthInsrPrcsDt(pkgInsrAmntVo.getHlthInsrPrcsDt());    /** column 건강보험처리일자 : hlthInsrPrcsDt */
								//	infcPkgInsr3300Vo.setHlthInsrPrcsYn(pkgInsrAmntVo.getHlthInsrPrcsYn());    /** column 건강보험처리여부 : hlthInsrPrcsYn */
								 
								//	infcPkgInsr3300Vo.setDivdPymtDivCd(pkgInsrAmntVo.getDivdPymtDivCd());    /** column 분할납부구분코드 : divdPymtDivCd */
								//	infcPkgInsr3300Vo.setDivdPymt(pkgInsrAmntVo.getDivdPymt());    /** column 분할납부횟수 : divdPymt */
									infcPkgInsr3300Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
									infcPkgInsr3300Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
 
				                   
				                   pkgInsrService.updatePayrToInsr3300(infcPkgInsr3300Vo);
				                   
				                   
				                   
				                   
	        	       } else {  
	        	   
	        	      /************************** 요율처리 부 ***************************************************************************/
			                   if (payCalculationVo.getHlthInsrApptnYn().equals("Y") &&  payCalculationVo.getHlthInsrMnthRuntnAmnt().compareTo(BigDecimal.ZERO) > 0) {
			                	   pkgInsrWorkVo.setTpHlthInsrPayAmt(payCalculationVo.getHlthInsrPayAmt());
			                   } else {
			                       //현재금액에서 값을 구한다. 
			                       if (payrInsrStdVo.getHlthInsrBstMnthRuntnAmnt().compareTo(pkgInsrWorkVo.getTpPymtAmnt()) >= 0) {
			                    	   pkgInsrWorkVo.setTpHlthInsrPayAmt(BigDecimal.ZERO);
			                       } else {
			                    	   pkgInsrWorkVo.setTpHlthInsrPayAmt(pkgInsrWorkVo.getTpPymtAmnt().multiply(payrInsrStdVo.getHlthInsrHmlfBrdnApmrt().divide(new BigDecimal(100))).setScale(-1, BigDecimal.ROUND_DOWN));
			                       }
			                       
			                   } 
		
			                   //장기요양 
			                   pkgInsrWorkVo.setTpHlthInsrRcptnPayAmt(pkgInsrWorkVo.getTpHlthInsrPayAmt().multiply(payrInsrStdVo.getHlthRcptnHmlfBrdnApmrt().divide(new BigDecimal(100))).setScale(-1, BigDecimal.ROUND_DOWN));
			                    
	        	       }
	        	       
	                   for(int i540Cnt01 = 0;i540Cnt01 < lisPayr0540.size();i540Cnt01++) {
	                     
	                      // public static final String PAY_DDUC_CD_2 = "D0010100"; //공제 건강보험
	                      // public static final String PAY_DDUC_CD_3 = "D0150100"; //공제 국민보험
	                      // public static final String PAY_DDUC_CD_4 = "D0160100"; //공제 고용보험 
	                      // public static final String PAY_INSR_ETC_CD_01 = "B0130002";  //     기여금면제  
	                         
	                       payr0540Vo = new InfcPkgPayr0540VO();
	                       BeanUtils.copyProperties(payr0540Vo,lisPayr0540.get(i540Cnt01));
	                       
	                     //  if (ExtermsProps.PAY_DDUC_CD_2.equals(payr0540Vo.getPayItemCd())) {
	                           
	                     //  }
	                     
	                       if (ExtermsProps.getProps("PAY_INSR_ETC_CD_02").equals(payr0540Vo.getExptnDivCd())) {
	                           // public static final String PAY_INSR_ETC_CD_02 = "B0130003";  // 건강보험면제(100%)  
	                    	   pkgInsrWorkVo.setTpHlthInsrPayAmt(BigDecimal.ZERO); //건강 
	                    	   pkgInsrWorkVo.setTpHlthInsrRcptnPayAmt(BigDecimal.ZERO); //장기
	                           
	                       } else if (ExtermsProps.getProps("PAY_INSR_ETC_CD_03").equals(payr0540Vo.getExptnDivCd())) {
	                           // public static final String PAY_INSR_ETC_CD_03 = "B0130005";  // 건강보험면제(50%) 
	                           BigDecimal tpPayPerAmt =  BigDecimal.ZERO;
	                           
	                           if (BigDecimal.ZERO.compareTo(payr0540Vo.getExptnPrcsPymtRto()) < 0) {
	                               tpPayPerAmt = ((new BigDecimal("100")).subtract(payr0540Vo.getExptnPrcsPymtRto())).divide(new BigDecimal("100")).setScale(3, 2);
	                               pkgInsrWorkVo.setTpHlthInsrPayAmt(pkgInsrWorkVo.getTpHlthInsrPayAmt().multiply(tpPayPerAmt).setScale(-1, 2));
	                           } else {
	                               tpPayPerAmt = payr0540Vo.getExptnPrcsPymtSum();
	                               pkgInsrWorkVo.setTpHlthInsrPayAmt(pkgInsrWorkVo.getTpHlthInsrPayAmt().add(tpPayPerAmt).setScale(-1, 2)) ;
	                           }  
	                           
	                       }  
	                      
	                   }
	                   
	                   
	                   for(int i540Cnt01 = 0;i540Cnt01 < lisPayr0540.size();i540Cnt01++) {
	                        
	                        payr0540Vo = new InfcPkgPayr0540VO();
	                        BeanUtils.copyProperties(payr0540Vo,lisPayr0540.get(i540Cnt01));
	                        
	                        if (ExtermsProps.getProps("PAY_INSR_ETC_CD_02").equals(payr0540Vo.getExptnDivCd())) {
	                            // public static final String PAY_INSR_ETC_CD_02 = "B0130003";  // 건강보험면제(100%)   
	                        	pkgInsrWorkVo.setTpHlthInsrRcptnPayAmt(BigDecimal.ZERO); //장기
	                            
	                        } else {
	                          
	                            if (ExtermsProps.getProps("PAY_INSR_ETC_CD_04").equals(payr0540Vo.getExptnDivCd())) {
	                                //  public static final String PAY_INSR_ETC_CD_04 = "B0130007";  // 노인장기요양보험면제(30%)   
	                                //장기요양 
	                            	pkgInsrWorkVo.setTpHlthInsrRcptnPayAmt(pkgInsrWorkVo.getTpHlthInsrPayAmt().multiply(payrInsrStdVo.getHlthRcptnHmlfBrdnApmrt()
	                            			                                                        .divide(new BigDecimal(100))).setScale(-1, BigDecimal.ROUND_DOWN));
	                                
	                                BigDecimal tpPayPerAmt =  BigDecimal.ZERO;
	                                
	                                if (BigDecimal.ZERO.compareTo(payr0540Vo.getExptnPrcsPymtRto()) < 0) {
	                                    
	                                    tpPayPerAmt = ((new BigDecimal("100")).subtract(payr0540Vo.getExptnPrcsPymtRto())).divide(new BigDecimal("100")).setScale(3, 2);
	                                    pkgInsrWorkVo.setTpHlthInsrRcptnPayAmt(pkgInsrWorkVo.getTpHlthInsrRcptnPayAmt().multiply(tpPayPerAmt).setScale(-1, 2));
	                                } else {
	                                    tpPayPerAmt = payr0540Vo.getExptnPrcsPymtSum();
	                                    pkgInsrWorkVo.setTpHlthInsrRcptnPayAmt(pkgInsrWorkVo.getTpHlthInsrRcptnPayAmt().add(tpPayPerAmt).setScale(-1, 2));
	                                }   
	                                
	                            }
	                        }   
	                       
	                    }
	                   
	                    //건강보험 
	                   payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
	                   payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
	                   payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
	                   payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
	                   payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
	                   payr0302Vo.setPayItemCd("D0010100");   /** column 급여항목코드 : payItemCd */
	                   payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
	                   payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */ 
	                   payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
	                   payr0302Vo.setPymtDducSum(pkgInsrWorkVo.getTpHlthInsrPayAmt().setScale(-1, BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
	                   payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
	                   payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
	                   payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
	                   payr0302Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
	                   payr0302Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
	                   payr0302Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
	                   payr0302Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
                  	      
	                   if (BigDecimal.ZERO.compareTo(pkgInsrWorkVo.getTpPymtAmnt()) != 0)  { 
	                	  payrCommCalcService.insertPayr0302(payr0302Vo);  
	                   
	                	  pkgInsrWorkVo.setTpDducTotAmnt(pkgInsrWorkVo.getTpDducTotAmnt().add(pkgInsrWorkVo.getTpHlthInsrPayAmt().setScale(-1, BigDecimal.ROUND_DOWN))); 
	                   }
	                   
	                  //건강보험 -요양 
	                  payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
	                  payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
	                  payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
	                  payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
	                  payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
	                  payr0302Vo.setPayItemCd("D0110100");   /** column 급여항목코드 : payItemCd */
	                  payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
	                  payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */ 
	                  payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
	                  payr0302Vo.setPymtDducSum(pkgInsrWorkVo.getTpHlthInsrRcptnPayAmt().setScale(-1, BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
	                  payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
	                  payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
	                  payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
	                  payr0302Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
	                   payr0302Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
	                   payr0302Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
	                   payr0302Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */ 
	                    
	                  if (BigDecimal.ZERO.compareTo(pkgInsrWorkVo.getTpPymtAmnt()) != 0)  {    
	                	  payrCommCalcService.insertPayr0302(payr0302Vo);  
	                	  pkgInsrWorkVo.setTpDducTotAmnt(pkgInsrWorkVo.getTpDducTotAmnt().add(pkgInsrWorkVo.getTpHlthInsrRcptnPayAmt().setScale(-1, BigDecimal.ROUND_DOWN)));
	                  }    
	                  
	                  /**********월정산처리*******************************************************************************************/
	                  
	                  //월정산보험료  
	                   payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
	                   payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
	                   payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
	                   payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
	                   payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
	                   payr0302Vo.setPayItemCd("D0010200");   /** column 급여항목코드 : payItemCd */
	                   payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
	                   payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */ 
	                   payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
	                   payr0302Vo.setPymtDducSum(pkgInsrAmntVo.getYrtxPrmm().setScale(-1, BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
	                   payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
	                   payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
	                   payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
	                   payr0302Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
	                   payr0302Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
	                   payr0302Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
	                   payr0302Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
                 	      
	                   if (BigDecimal.ZERO.compareTo(pkgInsrAmntVo.getYrtxPrmm()) != 0)  { 
	                	  payrCommCalcService.insertPayr0302(payr0302Vo);  
	                   
	                	  pkgInsrWorkVo.setTpDducTotAmnt(pkgInsrWorkVo.getTpDducTotAmnt().add(pkgInsrAmntVo.getYrtxPrmm().setScale(-1, BigDecimal.ROUND_DOWN))); 
	                   }
	                   
	                  //건강보험 -요양 
	                  payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
	                  payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
	                  payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
	                  payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
	                  payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
	                  payr0302Vo.setPayItemCd("D0110200");   /** column 급여항목코드 : payItemCd */
	                  payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
	                  payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */ 
	                  payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
	                  payr0302Vo.setPymtDducSum(pkgInsrAmntVo.getLgtmRcptnYrtxPrmm().setScale(-1, BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
	                  payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
	                  payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
	                  payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
	                  payr0302Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
	                  payr0302Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
	                  payr0302Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
	                  payr0302Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */ 
	                    
	                  if (BigDecimal.ZERO.compareTo(pkgInsrAmntVo.getLgtmRcptnYrtxPrmm()) != 0)  {    
	                	  payrCommCalcService.insertPayr0302(payr0302Vo);  
	                	  pkgInsrWorkVo.setTpDducTotAmnt(pkgInsrWorkVo.getTpDducTotAmnt().add(pkgInsrAmntVo.getLgtmRcptnYrtxPrmm().setScale(-1, BigDecimal.ROUND_DOWN)));
	                  }    
	                  
	                  /**********월정산처리 *******************************************************************************************/
	                  
	                  
	                  /**********환급이자 처리 *******************************************************************************************/
	                  
	                  //환급금이자  
	                   payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
	                   payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
	                   payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
	                   payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
	                   payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
	                   payr0302Vo.setPayItemCd("D0010500");   /** column 급여항목코드 : payItemCd */
	                   payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
	                   payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */ 
	                   payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
	                   payr0302Vo.setPymtDducSum(pkgInsrAmntVo.getHlthInsrRefdItrt().setScale(-1, BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
	                   payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
	                   payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
	                   payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
	                   payr0302Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
	                   payr0302Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
	                   payr0302Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
	                   payr0302Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
                 	      
	                   if (BigDecimal.ZERO.compareTo(pkgInsrAmntVo.getHlthInsrRefdItrt()) != 0)  { 
	                	  payrCommCalcService.insertPayr0302(payr0302Vo);  
	                   
	                	  pkgInsrWorkVo.setTpDducTotAmnt(pkgInsrWorkVo.getTpDducTotAmnt().add(pkgInsrAmntVo.getHlthInsrRefdItrt().setScale(-1, BigDecimal.ROUND_DOWN))); 
	                   }
	                   
	                  //장기요양보험환급금이자
	                  payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
	                  payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
	                  payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
	                  payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
	                  payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
	                  payr0302Vo.setPayItemCd("D0110500");   /** column 급여항목코드 : payItemCd */
	                  payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
	                  payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */ 
	                  payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
	                  payr0302Vo.setPymtDducSum(pkgInsrAmntVo.getLgtmRcptnInsurRefdItrt().setScale(-1, BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
	                  payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
	                  payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
	                  payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
	                  payr0302Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
	                   payr0302Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
	                   payr0302Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
	                   payr0302Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */ 
	                    
	                  if (BigDecimal.ZERO.compareTo(pkgInsrAmntVo.getLgtmRcptnInsurRefdItrt()) != 0)  {    
	                	  payrCommCalcService.insertPayr0302(payr0302Vo);  
	                	  pkgInsrWorkVo.setTpDducTotAmnt(pkgInsrWorkVo.getTpDducTotAmnt().add(pkgInsrAmntVo.getLgtmRcptnInsurRefdItrt().setScale(-1, BigDecimal.ROUND_DOWN)));
	                  }    
	                  
	                  /**********환급이자 처리 *******************************************************************************************/
	                  
	                  
	                  
	           } 
	           
	           //국민연금  
	           if (payCalculationVo.getNatPennApptnYn().equals("Y")) {
	        	   
	        	   /**************************  국민보험 금액처리 부추가 ********************************************************************/
        	       if (MSFSharedUtils.paramNotNull(pkgInsrAmntVo) && MSFSharedUtils.paramNotNull(pkgInsrAmntVo.getSystemkey()) && 
        	    		   pkgInsrAmntVo.getNatInsrPrmmSrd().compareTo(BigDecimal.ZERO) != 0) {
        	    	     
        	    	       InfcPkgInsr4200VO infcPkgInsr4200Vo = new InfcPkgInsr4200VO();
              	    	  
         	    	       //금액이존재하는경우 처리됨 우선처리 
         	    	       pkgInsrWorkVo.setTpNatPennAmt(pkgInsrAmntVo.getNatInsrPrmmSrd());
         	    	        


							infcPkgInsr4200Vo.setDpobCd(pkgInsrAmntVo.getDpobCd());    /** column 사업장코드 : dpobCd */
							infcPkgInsr4200Vo.setSystemkey(pkgInsrAmntVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
							infcPkgInsr4200Vo.setDducYrMnth(pkgInsrAmntVo.getHlthDducYrMnth());    /** column 공제년월 : dducYrMnth */
							infcPkgInsr4200Vo.setEmymtSeilNum(pkgInsrAmntVo.getEmymtSeilNum());    /** column 고용일련번호 : emymtSeilNum */
					 
							infcPkgInsr4200Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
							infcPkgInsr4200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
							infcPkgInsr4200Vo.setNatPayrDducYrMnth(pkgInsrAmntVo.getNatPayrDducYrMnth());    /** column 국민연금급여공제년월 : natPayrDducYrMnth */
						//	infcPkgInsr4200Vo.setNatInsrPrcsDt(pkgInsrAmntVo.getNatInsrPrcsDt());    /** column 국민연금처리일자 : natInsrPrcsDt */
						//	infcPkgInsr4200Vo.setNatInsrPrcsYn(pkgInsrAmntVo.getNatInsrPrcsYn());    /** column 국민연금처리여부 : natInsrPrcsYn */
						//	infcPkgInsr4200Vo.setNatInsrPrmmSrd(pkgInsrAmntVo.getNatInsrPrmmSrd());    /** column 국민연금차액 : natInsrPrmmSrd */
						//	infcPkgInsr4200Vo.setDivdPymtDivCd(pkgInsrAmntVo.getDivdPymtDivCd());    /** column 분할납부구분코드 : divdPymtDivCd */
						//	infcPkgInsr4200Vo.setDivdPymt(pkgInsrAmntVo.getDivdPymt());    /** column 분할납부회수 : divdPymt */

         	    	       pkgInsrService.updatePayrToInsr4200(infcPkgInsr4200Vo);
         	       
         	    	       
        	       } else {  
        	   
        	      /************************** 요율처리 부 ***************************************************************************/
		            
        	    	   
	                   if (payCalculationVo.getNatPennApptnYn().equals("Y") &&  payCalculationVo.getNatPennAmt().compareTo(BigDecimal.ZERO) > 0) {
	                       
	                	   pkgInsrWorkVo.setTpNatPennAmt(payCalculationVo.getNatPennAmt().setScale(-1,BigDecimal.ROUND_DOWN));
	                   } else {
	                       //현재금액에서 값을 구한다. 
	                       if (payrInsrStdVo.getNatPennMinmIncmMnthAmnt().compareTo(pkgInsrWorkVo.getTpPymtAmnt()) >= 0) {
	                    	   pkgInsrWorkVo.setTpNatPennAmt(BigDecimal.ZERO);
	                       } else {
	                           //국민연금 기준소득월액 상하향 조정 2015 270000 - 4210000    
	                       	//                  2016 280000  - 4340000 
	                       	
//	                           if (tpPymtAmnt.compareTo(new BigDecimal("250000")) <= 0) {
//	                               
//	                               tpNatPennAmt = (new BigDecimal("250000")).multiply(new BigDecimal("0.045")).setScale(-1,BigDecimal.ROUND_DOWN);
//	                               
//	                          } else  if (tpPymtAmnt.compareTo(new BigDecimal("3980000")) >= 0) {
//	                              
//	                              tpNatPennAmt = (new BigDecimal("3980000")).multiply(new BigDecimal("0.045")).setScale(-1,BigDecimal.ROUND_DOWN);
//	                              
//	                          } else {
//	                              tpNatPennAmt  =  tpPymtAmnt.multiply(payrInsrStdVo.getNatPennHmlfBrdnApmrt().divide(new BigDecimal(100))).setScale(-1, BigDecimal.ROUND_DOWN);
//	                          }
	                           
	                          if (pkgInsrWorkVo.getTpPymtAmnt().compareTo(new BigDecimal("280000")) <= 0) {
	                               
	                        	  pkgInsrWorkVo.setTpNatPennAmt((new BigDecimal("280000")).multiply(new BigDecimal("0.045")).setScale(-1,BigDecimal.ROUND_DOWN));
	                               
	                          } else  if (pkgInsrWorkVo.getTpPymtAmnt().compareTo(new BigDecimal("4340000")) >= 0) {
	                              
	                        	  pkgInsrWorkVo.setTpNatPennAmt((new BigDecimal("4340000")).multiply(new BigDecimal("0.045")).setScale(-1,BigDecimal.ROUND_DOWN));
	                              
	                          } else {
	                        	  pkgInsrWorkVo.setTpNatPennAmt(pkgInsrWorkVo.getTpPymtAmnt().multiply(payrInsrStdVo.getNatPennHmlfBrdnApmrt().divide(new BigDecimal(100))).setScale(-1, BigDecimal.ROUND_DOWN));
	                          }
	                       }
	                       
	                   }
        	       } 
	                   for(int i540Cnt01 = 0;i540Cnt01 < lisPayr0540.size();i540Cnt01++) { 
	                      
	                          
	                        payr0540Vo = new InfcPkgPayr0540VO();
	                        BeanUtils.copyProperties(payr0540Vo,lisPayr0540.get(i540Cnt01));
	                        
	                      //  if (ExtermsProps.PAY_DDUC_CD_2.equals(payr0540Vo.getPayItemCd())) {
	                            
	                      //  }
	                      
	                        if (ExtermsProps.getProps("PAY_INSR_ETC_CD_01").equals(payr0540Vo.getExptnDivCd())) {
	                            // public static final String  PAY_INSR_ETC_CD_01 = "B0130002";  //     기여금면제  
	                        	pkgInsrWorkVo.setTpNatPennAmt(BigDecimal.ZERO);
	                        }  
	                         
	                       
	                    }
	                   
	                   //국민연금 
	                   payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
	                   payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
	                   payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
	                   payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
	                   payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
	                   payr0302Vo.setPayItemCd("D0150100");   /** column 급여항목코드 : payItemCd */
	                   payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
	                   payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */ 
	                   payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
	                   payr0302Vo.setPymtDducSum(pkgInsrWorkVo.getTpNatPennAmt());   /** column 지급공제금액 : pymtDducSum */
	                   payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
	                   payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
	                   payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
	                   payr0302Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
	                   payr0302Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
	                   payr0302Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
	                   payr0302Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
	                     
	                   if (BigDecimal.ZERO.compareTo(pkgInsrWorkVo.getTpPymtAmnt()) < 0)  { 
	                	   payrCommCalcService.insertPayr0302(payr0302Vo);  
	                	   pkgInsrWorkVo.setTpDducTotAmnt(pkgInsrWorkVo.getTpDducTotAmnt().add(pkgInsrWorkVo.getTpNatPennAmt()));
	                   }
	           }
	           
	           if (payCalculationVo.getUmytInsrApptnYn().equals("Y")) {
	               
	        	   /**************************  고용 보험 금액처리 부추가 ********************************************************************/
        	       if (MSFSharedUtils.paramNotNull(pkgInsrAmntVo) && MSFSharedUtils.paramNotNull(pkgInsrAmntVo.getSystemkey()) &&
        	    		   pkgInsrAmntVo.getUmytInsrPrmmSrd().compareTo(BigDecimal.ZERO) != 0) {
        	    	   
        	    	       InfcPkgInsr5200VO infcPkgInsr5200Vo = new InfcPkgInsr5200VO();
        	    	   
        	    	       //금액이존재하는경우 처리됨 우선처리 
        	    	       pkgInsrWorkVo.setTpUmytInsrApptnAmt(pkgInsrAmntVo.getUmytInsrPrmmSrd());
        	    	       

							infcPkgInsr5200Vo.setDpobCd(pkgInsrAmntVo.getDpobCd());    /** column 사업장코드 : dpobCd */
							infcPkgInsr5200Vo.setSystemkey(pkgInsrAmntVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
							infcPkgInsr5200Vo.setDducYrMnth(pkgInsrAmntVo.getHlthDducYrMnth());    /** column 납부년월 : dducYrMnth */
							infcPkgInsr5200Vo.setEmymtSeilNum(pkgInsrAmntVo.getEmymtSeilNum());    /** column 고용일련번호 : emymtSeilNum */
							 
							infcPkgInsr5200Vo.setUmytPayrDducYrMnth(pkgInsrAmntVo.getUmytPayrDducYrMnth());    /** column 고용보험급여공제년월 : umytPayrDducYrMnth */
							//infcPkgInsr5200Vo.setUmytInsrPrcsDt(pkgInsrAmntVo.getUmytInsrPrcsDt());    /** column 고용보험처리일자 : umytInsrPrcsDt */
							//infcPkgInsr5200Vo.setUmytInsrPrcsYn(pkgInsrAmntVo.getUmytInsrPrcsYn());    /** column 고용보험처리여부 : umytInsrPrcsYn */
						//	infcPkgInsr5200Vo.setUmytInsrPrmmSrd(pkgInsrAmntVo.getUmytInsrPrmmSrd());    /** column 개인실업급여고용보험차액 : umytInsrPrmmSrd */
						//	infcPkgInsr5200Vo.setDivdPymtDivCd(pkgInsrAmntVo.getDivdPymtDivCd());    /** column 분할납부구분코드 : divdPymtDivCd */
						//	infcPkgInsr5200Vo.setDivdPymt(pkgInsrAmntVo.getDivdPymt());    /** column 분할납부횟수 : divdPymt */
						 
							infcPkgInsr5200Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
							//infcPkgInsr5200Vo.setRevnDt(pkgInsrAmntVo.getRevnDt());    /** column 수정일자 : revnDt */
							infcPkgInsr5200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */

        	    	       
        	    	       pkgInsrService.updatePayrToInsr5200(infcPkgInsr5200Vo);
         	       
        	       } else {  
        	   
        	      /************************** 요율처리 부 ***************************************************************************/
		            
			               //고용보험  
			               if (payCalculationVo.getUmytInsrApptnYn().equals("Y") &&  payCalculationVo.getUmytInsrPayMnthAmnt().compareTo(BigDecimal.ZERO) > 0) {
			            	   pkgInsrWorkVo.setTpUmytInsrApptnAmt(payCalculationVo.getUmytInsrPayMnthAmnt().setScale(-1, BigDecimal.ROUND_DOWN));
			                 } else {
			                     //현재금액에서 값을 구한다. 
			                   if (payrInsrStdVo.getUmytInsrHmlfBrdnApmrt().compareTo(pkgInsrWorkVo.getTpPymtAmnt()) >= 0) {
			                	   pkgInsrWorkVo.setTpUmytInsrApptnAmt(BigDecimal.ZERO);
			                   } else {
			                	   pkgInsrWorkVo.setTpUmytInsrApptnAmt(pkgInsrWorkVo.getTpPymtAmnt().multiply(payrInsrStdVo.getUmytInsrHmlfBrdnApmrt()
			                			                                                     .divide(new BigDecimal(100))).setScale(-1, BigDecimal.ROUND_DOWN));
			                 }
			                     
			                 } 
        	       }  
	                   //고용보험  
	                  payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
	                  payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
	                  payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
	                  payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
	                  payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
	                  payr0302Vo.setPayItemCd("D0160100");   /** column 급여항목코드 : payItemCd */
	                  payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
	                  payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */ 
	                  payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
	                  payr0302Vo.setPymtDducSum(pkgInsrWorkVo.getTpUmytInsrApptnAmt());   /** column 지급공제금액 : pymtDducSum */
	                  payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
	                  payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
	                  payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
	                  payr0302Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
	                  payr0302Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
	                  payr0302Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
	                  payr0302Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */ 
	                     
	                  if (BigDecimal.ZERO.compareTo(pkgInsrWorkVo.getTpPymtAmnt()) < 0)  {   
	                	  payrCommCalcService.insertPayr0302(payr0302Vo);   
	                	  pkgInsrWorkVo.setTpDducTotAmnt(pkgInsrWorkVo.getTpDducTotAmnt().add(pkgInsrWorkVo.getTpUmytInsrApptnAmt()));
	                  }
	            }
	       } 
	       
	       return pkgInsrWorkVo;
	 }  
	   
	   
	   /**
	    * 
	    * <pre>
	    * 1. 개요  : 급여조정에 따른 4대보험 재 계산 처리 루틴  
	    * 2. 처리내용 : 급여조정 처리시 플래그 확인 후처리 나 제외된 4대 보험의 경우 처리에서 제외 해야 함. 확인 후 처리 수동처리을 위해 처리 루틴 추가 
	    * </pre>
	    * @Method Name : func4InsureModService
	    * @date : 2016. 12. 27.
	    * @author : atres-pc
	    * @history : 
	    *	-----------------------------------------------------------------------
	    *	변경일				작성자						변경내용  
	    *	----------- ------------------- ---------------------------------------
	    *	2016. 12. 27.		atres-pc				최초 작성 
	    *	-----------------------------------------------------------------------
	    * 
	    * @param request
	    * @param payCalculationVo
	    * @param payr0250Vo
	    * @param pkgTpInsrWorkVo
	    * @return
	    * @throws Exception
	    */
	   public PkgInsrWorkVO func4InsureModService(HttpServletRequest request
               ,PkgPayrCommCalcVO payCalculationVo
               ,InfcPkgPayr0250VO  payr0250Vo
               ,PkgInsrWorkVO pkgTpInsrWorkVo
               ,BigDecimal sumReattyD0150100) throws Exception  {    	   
	   

		   if  (payrCommCalcService == null) { 
               WebApplicationContext wac = WebApplicationContextUtils.
                       getRequiredWebApplicationContext( request.getSession().getServletContext());
   
               payrCommCalcService = (PayrCommCalcService) wac.getBean("PayrCommCalcService" ); 
              
          }  
		   
		   if  (pkgInsrService == null) { 
               WebApplicationContext wac = WebApplicationContextUtils.
                       getRequiredWebApplicationContext( request.getSession().getServletContext());
   
               pkgInsrService = (PkgInsrService) wac.getBean("PkgInsrService" ); 
              
          }  
		   
		   InfcPkgPayr0540SrhVO payr0540SrhVo = new InfcPkgPayr0540SrhVO();
		   InfcPkgPayr0540VO  payr0540Vo = null;
		   PkgPayrInsrStdVO payrInsrStdVo = null;
		   InfcPkgPayr0302VO  payr0302Vo = new InfcPkgPayr0302VO();
		   PkgInsrAmntVO pkgInsrAmntVo = new PkgInsrAmntVO();
		   PkgInsrWorkVO pkgInsrWorkVo = new PkgInsrWorkVO();
		   
		   MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request); 
			    
		       //사대보험계산로직추가 에외처리로직 추가 
		       /*########################################################################################*/
		       /**   에외처리로직 추가                                                                                                                                                                      **/
		       /*########################################################################################*/    
		       payr0540SrhVo.setDpobCd(payr0250Vo.getDpobCd());
		       payr0540SrhVo.setSystemkey(payr0250Vo.getSystemkey());
		       payr0540SrhVo.setPymtDt(payr0250Vo.getPymtDt());  //지급구간 
		       payr0540SrhVo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));
		       //공제테이블 
		       List lisPayr0540 = payrCommCalcService.selectPkgPayr0540List(payr0540SrhVo);
		       
		       /*########################################################################################*/
		       /**   에외처리로직 추가                                                                                                                                                                      **/
		       /*########################################################################################*/   

		       /*******************************************************************************************/
		       /*** 금액으로 처리 하기 위한 부분 추가함                                                                                                                                                                             ***/
		       /*******************************************************************************************/
		       pkgInsrAmntVo = select4InsureDataAmnt(request,payr0250Vo);   
               //사회보험요율가져오기 
               List insureList =  getSelect4InsureDataList(request,payr0250Vo);  
               
               if (insureList.size() > 0) {
            	 //  BaseModel bm = new BaseModel();
            	 //  ShowMessageBM smBm = new ShowMessageBM();
            	 //  smBm.setDivision(PropPayGenConfs.PAYGEN_INFO);
            	 //  smBm.setMenu("Payr");
            	  // smBm.setPhase("[급여]4대보험요율");
            	  // smBm.setMessage("불러오기성공");
            	  // smBm.setContent("");
            	  // bmResult.add(smBm); 
               } 
               
		   //기본적으로 계산되어 나오나 값이 없는 경우에는 값을 가지고와서 처리함. 과세대상금액으로 처리 
		    for(int iCnt02 = 0;iCnt02 < insureList.size();iCnt02++) {
		        
		  	    payrInsrStdVo  = new PkgPayrInsrStdVO();
		       // payrInsrStdVo = (PayrInsrStdVO)insureList.get(iCnt01);
		        BeanUtils.copyProperties(payrInsrStdVo,insureList.get(iCnt02));
		         
		          //건강보험 
		           pkgInsrWorkVo.setTpHlthInsrPayAmt(BigDecimal.ZERO);
		           //요양 
		           pkgInsrWorkVo.setTpHlthInsrRcptnPayAmt(BigDecimal.ZERO);
		            //국민연금  
		           pkgInsrWorkVo.setTpNatPennAmt(BigDecimal.ZERO);
		           //고용 
		           pkgInsrWorkVo.setTpUmytInsrApptnAmt(BigDecimal.ZERO);
		           //보수금액 
		           pkgInsrWorkVo.setTpPymtAmnt(BigDecimal.ZERO);
		           
		           pkgInsrWorkVo.setTpDducTotAmnt(BigDecimal.ZERO);
		           
		           /*******************************주의해서처리 해야 함 ***************************************/
		           //공제금액합계
	     	      // pkgInsrWorkVo.setTpDducTotAmnt(pkgTpInsrWorkVo.getTpDducTotAmnt());
	     	       //기본금액 
	     	       pkgInsrWorkVo.setTpStdPymtTotAmnt(pkgTpInsrWorkVo.getTpStdPymtTotAmnt());
	     	        
	     	       pkgInsrWorkVo.setTpTxtnTotAmnt(pkgTpInsrWorkVo.getTpTxtnTotAmnt());  //과세금액 
	     	      
		           pkgInsrWorkVo.setTpPymtAmnt(pkgTpInsrWorkVo.getTpTxtnTotAmnt());  //보수금액 
		            
		           pkgInsrWorkVo.setTpWorkIncmTxtnSum(pkgTpInsrWorkVo.getTpPymtAmnt());  //과세대상금액  
		           /*******************************주의해서처리 해야 함 ***************************************/    
		           //B013  
 
                    //건강보험
                    if (payCalculationVo.getHlthInsrApptnYn().equals("Y")) {
                    	
                    	//건강보험 수동입력인 경우 요양도 수동입력이어야 함 	
                    	if (!"Y".equals(pkgTpInsrWorkVo.getSumChkD0010100())) {
                    		
		                      /************************** 건강보험 금액처리 부추가 ********************************************************************/
			        	       if (MSFSharedUtils.paramNotNull(pkgInsrAmntVo) &&  MSFSharedUtils.paramNotNull(pkgInsrAmntVo.getSystemkey()) && 
			        	    		   pkgInsrAmntVo.getHlthInsrPrmmSrd().compareTo(BigDecimal.ZERO) != 0) {
			        	    	   
			        	    	   InfcPkgInsr3300VO infcPkgInsr3300Vo = new InfcPkgInsr3300VO();
		    	    	           //건강보험 정산, 건강보험환급금이자....
		    	    	          // BigDecimal bdHlthInsrPrmmSrd = BigDecimal.ZERO;   //건강보험
		    	    	          // BigDecimal bdLgtmRcptnInsurSrd = BigDecimal.ZERO; //장기요양보험
		    	    	   
		    	    	          // bdHlthInsrPrmmSrd = (pkgInsrAmntVo.getHlthInsrPrmmSrd().add(pkgInsrAmntVo.getYrtxPrmm())).add(pkgInsrAmntVo.getHlthInsrRefdItrt());
		    	    	          // bdLgtmRcptnInsurSrd = (pkgInsrAmntVo.getLgtmRcptnInsurSrd().add(pkgInsrAmntVo.getLgtmRcptnYrtxPrmm())).add(pkgInsrAmntVo.getLgtmRcptnInsurRefdItrt());
		    	    	           //건강보험 
		    	    	           pkgInsrWorkVo.setTpHlthInsrPayAmt(pkgInsrAmntVo.getHlthInsrPrmmSrd());
		    	    			   //장기요양 
				                   pkgInsrWorkVo.setTpHlthInsrRcptnPayAmt(pkgInsrAmntVo.getLgtmRcptnInsurSrd());
				                   
				                   // 건강보험 테이블 업데이트 payr3300  
		
									infcPkgInsr3300Vo.setDpobCd(pkgInsrAmntVo.getDpobCd());    /** column 사업장코드 : dpobCd */
									infcPkgInsr3300Vo.setNofctYrMnth(pkgInsrAmntVo.getNofctYrMnth());    /** column 고지년월 : nofctYrMnth */
									infcPkgInsr3300Vo.setNofctDspty(pkgInsrAmntVo.getNofctDspty());    /** column 고지차수 : nofctDspty */
									infcPkgInsr3300Vo.setSystemkey(pkgInsrAmntVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
								//	infcPkgInsr3300Vo.setEmymtSeilNum(pkgInsrAmntVo.getEmymtSeilNum());    /** column 고용일련번호 : emymtSeilNum */
									infcPkgInsr3300Vo.setDducYrMnth(pkgInsrAmntVo.getHlthDducYrMnth());    /** column 공제년월 : dducYrMnth */
								//	infcPkgInsr3300Vo.setHlthInsrPrcsDt(pkgInsrAmntVo.getHlthInsrPrcsDt());    /** column 건강보험처리일자 : hlthInsrPrcsDt */
								//	infcPkgInsr3300Vo.setHlthInsrPrcsYn(pkgInsrAmntVo.getHlthInsrPrcsYn());    /** column 건강보험처리여부 : hlthInsrPrcsYn */
								 
								//	infcPkgInsr3300Vo.setDivdPymtDivCd(pkgInsrAmntVo.getDivdPymtDivCd());    /** column 분할납부구분코드 : divdPymtDivCd */
								//	infcPkgInsr3300Vo.setDivdPymt(pkgInsrAmntVo.getDivdPymt());    /** column 분할납부횟수 : divdPymt */
									infcPkgInsr3300Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
									infcPkgInsr3300Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
		
				                   
				                   pkgInsrService.updatePayrToInsr3300(infcPkgInsr3300Vo);
				                    
			        	       } else {  
			        	   
			        	      /************************** 요율처리 부 ***************************************************************************/
		                            if (payCalculationVo.getHlthInsrApptnYn().equals("Y") &&  payCalculationVo.getHlthInsrMnthRuntnAmnt().compareTo(BigDecimal.ZERO) > 0) {
		                         	   pkgInsrWorkVo.setTpHlthInsrPayAmt(payCalculationVo.getHlthInsrMnthRuntnAmnt().multiply(payrInsrStdVo.getHlthInsrHmlfBrdnApmrt()
		                             		                                                                        .divide(new BigDecimal(100))).setScale(-1, BigDecimal.ROUND_DOWN));
		                           
		                            } else {
		                                //현재금액에서 값을 구한다. 
		                                if (payrInsrStdVo.getHlthInsrBstMnthRuntnAmnt().compareTo(pkgInsrWorkVo.getTpPymtAmnt()) >= 0) {
		                             	   pkgInsrWorkVo.setTpHlthInsrPayAmt(BigDecimal.ZERO);
		                             	   
		                             	  
		                                } else {
		                             	   pkgInsrWorkVo.setTpHlthInsrPayAmt(pkgInsrWorkVo.getTpPymtAmnt().multiply(payrInsrStdVo.getHlthInsrHmlfBrdnApmrt()
		                             			                                                          .divide(new BigDecimal(100))).setScale(-1, BigDecimal.ROUND_DOWN));
		                                }
		                                
		                            } 
		
		                            //장기요양 
		                            pkgInsrWorkVo.setTpHlthInsrRcptnPayAmt(pkgInsrWorkVo.getTpHlthInsrPayAmt().multiply(payrInsrStdVo.getHlthRcptnHmlfBrdnApmrt().divide(new BigDecimal(100))).setScale(-1, BigDecimal.ROUND_DOWN));
			        	       }       
                            
		                            for(int i540Cnt01 = 0;i540Cnt01 < lisPayr0540.size();i540Cnt01++) {
		                              
		                               // public static final String PAY_DDUC_CD_2 = "D0010100"; //공제 건강보험
		                               // public static final String PAY_DDUC_CD_3 = "D0150100"; //공제 국민보험
		                               // public static final String PAY_DDUC_CD_4 = "D0160100"; //공제 고용보험 
		                               // public static final String PAY_INSR_ETC_CD_01 = "B0130002";  //     기여금면제  
		                                  
		                         	    payr0540Vo = new InfcPkgPayr0540VO();
		                                
		                         	    BeanUtils.copyProperties(payr0540Vo,lisPayr0540.get(i540Cnt01));
		                                
		                              //  if (ExtermsProps.PAY_DDUC_CD_2.equals(payr0540Vo.getPayItemCd())) {
		                                    
		                              //  }
		                              
		                                if (ExtermsProps.getProps("PAY_INSR_ETC_CD_02").equals(payr0540Vo.getExptnDivCd())) {
		                                    // public static final String PAY_INSR_ETC_CD_02 = "B0130003";  // 건강보험면제(100%)  
		                             	   pkgInsrWorkVo.setTpHlthInsrPayAmt(BigDecimal.ZERO); //건강 
		                             	   pkgInsrWorkVo.setTpHlthInsrRcptnPayAmt(BigDecimal.ZERO); //장기
		                                    
		                                } else if (ExtermsProps.getProps("PAY_INSR_ETC_CD_03").equals(payr0540Vo.getExptnDivCd())) {
		                                    // public static final String PAY_INSR_ETC_CD_03 = "B0130005";  // 건강보험면제(50%) 
		                                    BigDecimal tpPayPerAmt =  BigDecimal.ZERO;
		                                    
		                                    if (BigDecimal.ZERO.compareTo(payr0540Vo.getExptnPrcsPymtRto()) < 0) {
		                                        tpPayPerAmt = ((new BigDecimal("100")).subtract(payr0540Vo.getExptnPrcsPymtRto())).divide(new BigDecimal("100")).setScale(3, 2);
		                                        pkgInsrWorkVo.setTpHlthInsrPayAmt(pkgInsrWorkVo.getTpHlthInsrPayAmt().multiply(tpPayPerAmt).setScale(-1, 2));
		                                    } else {
		                                        tpPayPerAmt = payr0540Vo.getExptnPrcsPymtSum();
		                                        pkgInsrWorkVo.setTpHlthInsrPayAmt(pkgInsrWorkVo.getTpHlthInsrPayAmt().add(tpPayPerAmt).setScale(-1, 2)) ;
		                                    }  
		                                    
		                                } 
		                               
		                            }
                            
                            
		                            for(int i540Cnt01 = 0;i540Cnt01 < lisPayr0540.size();i540Cnt01++) {
		                                 
		                         	     payr0540Vo = new InfcPkgPayr0540VO();
		                         	     
		                                 BeanUtils.copyProperties(payr0540Vo,lisPayr0540.get(i540Cnt01));
		                                 
		                                 if (ExtermsProps.getProps("PAY_INSR_ETC_CD_02").equals(payr0540Vo.getExptnDivCd())) {
		                                     // public static final String PAY_INSR_ETC_CD_02 = "B0130003";  // 건강보험면제(100%)   
		                                 	pkgInsrWorkVo.setTpHlthInsrRcptnPayAmt(BigDecimal.ZERO); //장기
		                                     
		                                 } else {
		                                   
		                                     if (ExtermsProps.getProps("PAY_INSR_ETC_CD_04").equals(payr0540Vo.getExptnDivCd())) {
		                                         //  public static final String PAY_INSR_ETC_CD_04 = "B0130007";  // 노인장기요양보험면제(30%)   
		                                         //장기요양 
		                                     	pkgInsrWorkVo.setTpHlthInsrRcptnPayAmt(pkgInsrWorkVo.getTpHlthInsrPayAmt().multiply(payrInsrStdVo.getHlthRcptnHmlfBrdnApmrt().divide(new BigDecimal("100"))).setScale(-1, BigDecimal.ROUND_DOWN));
		                                         
		                                         BigDecimal tpPayPerAmt =  BigDecimal.ZERO;
		                                         
		                                         if (BigDecimal.ZERO.compareTo(payr0540Vo.getExptnPrcsPymtRto()) < 0) {
		                                             
		                                             tpPayPerAmt = ((new BigDecimal("100")).subtract(payr0540Vo.getExptnPrcsPymtRto())).divide(new BigDecimal("100")).setScale(3, 2);
		                                             pkgInsrWorkVo.setTpHlthInsrRcptnPayAmt(pkgInsrWorkVo.getTpHlthInsrRcptnPayAmt().multiply(tpPayPerAmt).setScale(-1, 2));
		                                         } else {
		                                             tpPayPerAmt = payr0540Vo.getExptnPrcsPymtSum();
		                                             pkgInsrWorkVo.setTpHlthInsrRcptnPayAmt(pkgInsrWorkVo.getTpHlthInsrRcptnPayAmt().add(tpPayPerAmt).setScale(-1, 2)) ;
		                                         }   
		                                         
		                                     }
		                                 }    
		                              
		                                
		                             }
                    	    } else {
                  	    	
                    	    	//수동처리시 건강,장기요양 둘다 수동입력으로 처리 함. 
                    	    	//pkgInsrWorkVo.getSumChkD0010100() - 장기요양 
                    	    	pkgInsrWorkVo.setTpHlthInsrPayAmt(pkgTpInsrWorkVo.getTpHlthInsrPayAmt());
                    	    	pkgInsrWorkVo.setTpHlthInsrRcptnPayAmt(pkgTpInsrWorkVo.getTpHlthInsrRcptnPayAmt());
                    	    	
                    	    }
                    	
                            //건강보험 
                            payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                            payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
                            payr0302Vo.setPayCd(payr0250Vo.getPayCd());    /** column 급여구분코드 : payCd */
                            payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
                            payr0302Vo.setSystemkey(payr0250Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                            payr0302Vo.setPayItemCd("D0010100");   /** column 급여항목코드 : payItemCd */
                            payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
                            payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */ 
                            payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                            payr0302Vo.setPymtDducSum(pkgInsrWorkVo.getTpHlthInsrPayAmt().setScale(-1, BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
                            payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
                            payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
                            payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                            payr0302Vo.setPymtDducChgYn(pkgTpInsrWorkVo.getSumChkD0010100());     /** 급여지급공제변경여부 */
                            payr0302Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
     	                    payr0302Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
     	                    payr0302Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
     	                    payr0302Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
                            
     	                    
                            if (BigDecimal.ZERO.compareTo(pkgInsrWorkVo.getTpHlthInsrPayAmt()) != 0)  { 
                            	
                            	payrCommCalcService.deletePayr0302Payr0307(payr0302Vo);
                            	payrCommCalcService.insertPayr0302(payr0302Vo);  
                            
                            	pkgInsrWorkVo.setTpDducTotAmnt(pkgInsrWorkVo.getTpDducTotAmnt().add(pkgInsrWorkVo.getTpHlthInsrPayAmt().setScale(-1, BigDecimal.ROUND_DOWN))); 
                            }
                           //건강보험 -요양 
                           payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                           payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
                           payr0302Vo.setPayCd(payr0250Vo.getPayCd());    /** column 급여구분코드 : payCd */
                           payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
                           payr0302Vo.setSystemkey(payr0250Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                           payr0302Vo.setPayItemCd("D0110100");   /** column 급여항목코드 : payItemCd */
                           payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
                           payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */ 
                           payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                           payr0302Vo.setPymtDducSum(pkgInsrWorkVo.getTpHlthInsrRcptnPayAmt().setScale(-1, BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
                           payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
                           payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
                           payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                           payr0302Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
    	                   payr0302Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
    	                   payr0302Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
    	                   payr0302Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
                             
                           if (BigDecimal.ZERO.compareTo(pkgInsrWorkVo.getTpHlthInsrRcptnPayAmt()) != 0)  {    
                        	   payrCommCalcService.deletePayr0302Payr0307(payr0302Vo);
                        	   payrCommCalcService.insertPayr0302(payr0302Vo); 
                          
                        	   pkgInsrWorkVo.setTpDducTotAmnt(pkgInsrWorkVo.getTpDducTotAmnt().add(pkgInsrWorkVo.getTpHlthInsrRcptnPayAmt().setScale(-1, BigDecimal.ROUND_DOWN)));
                           }   
                           
                           
                           
//     	                  /**********월정산처리*******************************************************************************************/
//     	                  
//     	                  //월정산보험료  
//     	                   payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//     	                   payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//     	                   payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//     	                   payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//     	                   payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//     	                   payr0302Vo.setPayItemCd("D0010200");   /** column 급여항목코드 : payItemCd */
//     	                   payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//     	                   payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */ 
//     	                   payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//     	                   payr0302Vo.setPymtDducSum(pkgInsrAmntVo.getYrtxPrmm().setScale(-1, BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
//     	                   payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//     	                   payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//     	                   payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//     	                   payr0302Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
//     	                   payr0302Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
//     	                   payr0302Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
//     	                   payr0302Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
//                      	      
//     	                   if (BigDecimal.ZERO.compareTo(pkgInsrAmntVo.getYrtxPrmm()) != 0)  {
//     	                	   
//     	                	  payrCommCalcService.deletePayr0302Payr0307(payr0302Vo); 
//     	                	  payrCommCalcService.insertPayr0302(payr0302Vo);  
//     	                   
//     	                	  pkgInsrWorkVo.setTpDducTotAmnt(pkgInsrWorkVo.getTpDducTotAmnt().add(pkgInsrAmntVo.getYrtxPrmm().setScale(-1, BigDecimal.ROUND_DOWN))); 
//     	                   }
//     	                   
//     	                  //건강보험 -요양 
//     	                  payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//     	                  payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//     	                  payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//     	                  payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//     	                  payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//     	                  payr0302Vo.setPayItemCd("D0110200");   /** column 급여항목코드 : payItemCd */
//     	                  payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//     	                  payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */ 
//     	                  payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//     	                  payr0302Vo.setPymtDducSum(pkgInsrAmntVo.getLgtmRcptnYrtxPrmm().setScale(-1, BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
//     	                  payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//     	                  payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//     	                  payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//     	                  payr0302Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
//     	                  payr0302Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
//     	                  payr0302Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
//     	                  payr0302Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */ 
//     	                    
//     	                  if (BigDecimal.ZERO.compareTo(pkgInsrAmntVo.getLgtmRcptnYrtxPrmm()) != 0)  {    
//     	                	  
//     	                	  payrCommCalcService.deletePayr0302Payr0307(payr0302Vo);
//     	                	  payrCommCalcService.insertPayr0302(payr0302Vo);  
//     	                	  
//     	                	  pkgInsrWorkVo.setTpDducTotAmnt(pkgInsrWorkVo.getTpDducTotAmnt().add(pkgInsrAmntVo.getLgtmRcptnYrtxPrmm().setScale(-1, BigDecimal.ROUND_DOWN)));
//     	                  }    
//     	                  
//     	                  /**********월정산처리 *******************************************************************************************/
//     	                  
//     	                  
//     	                  /**********환급이자 처리 *******************************************************************************************/
//     	                  
//     	                  //환급금이자  
//     	                   payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//     	                   payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//     	                   payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//     	                   payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//     	                   payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//     	                   payr0302Vo.setPayItemCd("D0010500");   /** column 급여항목코드 : payItemCd */
//     	                   payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//     	                   payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */ 
//     	                   payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//     	                   payr0302Vo.setPymtDducSum(pkgInsrAmntVo.getHlthInsrRefdItrt().setScale(-1, BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
//     	                   payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//     	                   payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//     	                   payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//     	                   payr0302Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
//     	                   payr0302Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
//     	                   payr0302Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
//     	                   payr0302Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
//                      	      
//     	                   if (BigDecimal.ZERO.compareTo(pkgInsrAmntVo.getHlthInsrRefdItrt()) != 0)  { 
//     	                	   
//     	                	  payrCommCalcService.deletePayr0302Payr0307(payr0302Vo); 
//     	                	  payrCommCalcService.insertPayr0302(payr0302Vo);  
//     	                   
//     	                	  pkgInsrWorkVo.setTpDducTotAmnt(pkgInsrWorkVo.getTpDducTotAmnt().add(pkgInsrAmntVo.getHlthInsrRefdItrt().setScale(-1, BigDecimal.ROUND_DOWN))); 
//     	                   }
//     	                   
//     	                  //장기요양보험환급금이자
//     	                  payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//     	                  payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
//     	                  payr0302Vo.setPayCd(payCalculationVo.getPayCd());    /** column 급여구분코드 : payCd */
//     	                  payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
//     	                  payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//     	                  payr0302Vo.setPayItemCd("D0110500");   /** column 급여항목코드 : payItemCd */
//     	                  payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
//     	                  payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */ 
//     	                  payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
//     	                  payr0302Vo.setPymtDducSum(pkgInsrAmntVo.getLgtmRcptnInsurRefdItrt().setScale(-1, BigDecimal.ROUND_DOWN));   /** column 지급공제금액 : pymtDducSum */
//     	                  payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
//     	                  payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
//     	                  payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
//     	                  payr0302Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
//     	                  payr0302Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
//     	                  payr0302Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
//     	                  payr0302Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */ 
//     	                    
//     	                  if (BigDecimal.ZERO.compareTo(pkgInsrAmntVo.getLgtmRcptnInsurRefdItrt()) != 0)  {    
//     	                	  
//     	                	  payrCommCalcService.deletePayr0302Payr0307(payr0302Vo);
//     	                	  payrCommCalcService.insertPayr0302(payr0302Vo);  
//     	                	  pkgInsrWorkVo.setTpDducTotAmnt(pkgInsrWorkVo.getTpDducTotAmnt().add(pkgInsrAmntVo.getLgtmRcptnInsurRefdItrt().setScale(-1, BigDecimal.ROUND_DOWN)));
//     	                  }    
//     	                  
//     	                  /**********환급이자 처리 *******************************************************************************************/
     	                  
     	                  
                    } 
                    
                    //국민연금  
                      if (payCalculationVo.getNatPennApptnYn().equals("Y")) {
                    
                        if (!"Y".equals(pkgTpInsrWorkVo.getSumChkD0150100())) {	
                        	
		                      /**************************  국민보험 금액처리 부추가 ********************************************************************/
		             	       if (MSFSharedUtils.paramNotNull(pkgInsrAmntVo) &&  MSFSharedUtils.paramNotNull(pkgInsrAmntVo.getSystemkey()) && 
		             	    		   pkgInsrAmntVo.getNatInsrPrmmSrd().compareTo(BigDecimal.ZERO) != 0) {
		             	    	 
		             	    	       InfcPkgInsr4200VO infcPkgInsr4200Vo = new InfcPkgInsr4200VO();
		             	    	  
		             	    	        //금액이존재하는경우 처리됨 우선처리 
		             	    	        pkgInsrWorkVo.setTpNatPennAmt(pkgInsrAmntVo.getNatInsrPrmmSrd()); 
		
		
										infcPkgInsr4200Vo.setDpobCd(pkgInsrAmntVo.getDpobCd());    /** column 사업장코드 : dpobCd */
										infcPkgInsr4200Vo.setSystemkey(pkgInsrAmntVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
										infcPkgInsr4200Vo.setDducYrMnth(pkgInsrAmntVo.getHlthDducYrMnth());    /** column 공제년월 : dducYrMnth */
										infcPkgInsr4200Vo.setEmymtSeilNum(pkgInsrAmntVo.getEmymtSeilNum());    /** column 고용일련번호 : emymtSeilNum */
								 
										infcPkgInsr4200Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
										infcPkgInsr4200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
										infcPkgInsr4200Vo.setNatPayrDducYrMnth(pkgInsrAmntVo.getNatPayrDducYrMnth());    /** column 국민연금급여공제년월 : natPayrDducYrMnth */
									//	infcPkgInsr4200Vo.setNatInsrPrcsDt(pkgInsrAmntVo.getNatInsrPrcsDt());    /** column 국민연금처리일자 : natInsrPrcsDt */
									//	infcPkgInsr4200Vo.setNatInsrPrcsYn(pkgInsrAmntVo.getNatInsrPrcsYn());    /** column 국민연금처리여부 : natInsrPrcsYn */
									//	infcPkgInsr4200Vo.setNatInsrPrmmSrd(pkgInsrAmntVo.getNatInsrPrmmSrd());    /** column 국민연금차액 : natInsrPrmmSrd */
									//	infcPkgInsr4200Vo.setDivdPymtDivCd(pkgInsrAmntVo.getDivdPymtDivCd());    /** column 분할납부구분코드 : divdPymtDivCd */
									//	infcPkgInsr4200Vo.setDivdPymt(pkgInsrAmntVo.getDivdPymt());    /** column 분할납부회수 : divdPymt */
		
		             	    	       pkgInsrService.updatePayrToInsr4200(infcPkgInsr4200Vo);
		             	       
		             	       } else {  
		             	   
		             	      /************************** 요율처리 부 ***************************************************************************/
		             	    	   
		                            if (payCalculationVo.getNatPennApptnYn().equals("Y") &&  payCalculationVo.getNatPennStdIncmMnthAmnt().compareTo(BigDecimal.ZERO) > 0) {
		                                
		                         	   pkgInsrWorkVo.setTpNatPennAmt( payCalculationVo.getNatPennStdIncmMnthAmnt().multiply(payrInsrStdVo.getNatPennHmlfBrdnApmrt().divide(new BigDecimal(100))).setScale(-1, BigDecimal.ROUND_DOWN));
		                          
		                            } else {
		                                //현재금액에서 값을 구한다. 
		                                if (payrInsrStdVo.getNatPennMinmIncmMnthAmnt().compareTo(pkgInsrWorkVo.getTpPymtAmnt()) >= 0) {
		                                	
		                             	   pkgInsrWorkVo.setTpNatPennAmt(BigDecimal.ZERO);
		                             	   
		                                } else {
		                                	
		                                	if ("201606".compareTo(payr0250Vo.getJobYrMnth()) >= 0) {
			                                    
		                                		  if (pkgInsrWorkVo.getTpPymtAmnt().compareTo(new BigDecimal("250000")) <= 0) {
				                                        
				                                 	   pkgInsrWorkVo.setTpNatPennAmt((new BigDecimal("250000")).multiply(payrInsrStdVo.getNatPennHmlfBrdnApmrt().divide(new BigDecimal(100))).setScale(-1,BigDecimal.ROUND_DOWN));
				                                        
				                                   } else  if (pkgInsrWorkVo.getTpPymtAmnt().compareTo(new BigDecimal("3980000")) >= 0) {
				                                       
				                                 	  pkgInsrWorkVo.setTpNatPennAmt((new BigDecimal("3980000")).multiply(payrInsrStdVo.getNatPennHmlfBrdnApmrt().divide(new BigDecimal(100))).setScale(-1,BigDecimal.ROUND_DOWN));
				                                       
				                                   } else {
				                                 	  pkgInsrWorkVo.setTpNatPennAmt(pkgInsrWorkVo.getTpPymtAmnt().multiply(payrInsrStdVo.getNatPennHmlfBrdnApmrt().divide(new BigDecimal(100))).setScale(-1, BigDecimal.ROUND_DOWN));
				                                   }
		        		                            
		                                	} else  if ("201706".compareTo(payr0250Vo.getJobYrMnth()) >= 0) {
		                                		//20170701기준 국민연금 상하한선 적용 
		                                		  if (pkgInsrWorkVo.getTpPymtAmnt().compareTo(new BigDecimal("280000")) <= 0) {
				                                        
				                                 	   pkgInsrWorkVo.setTpNatPennAmt((new BigDecimal("280000")).multiply(payrInsrStdVo.getNatPennHmlfBrdnApmrt().divide(new BigDecimal(100))).setScale(-1,BigDecimal.ROUND_DOWN));
				                                        
				                                   } else  if (pkgInsrWorkVo.getTpPymtAmnt().compareTo(new BigDecimal("4340000")) >= 0) {
				                                       
				                                 	  pkgInsrWorkVo.setTpNatPennAmt((new BigDecimal("4340000")).multiply(payrInsrStdVo.getNatPennHmlfBrdnApmrt().divide(new BigDecimal(100))).setScale(-1,BigDecimal.ROUND_DOWN));
				                                       
				                                   } else {
				                                 	  pkgInsrWorkVo.setTpNatPennAmt(pkgInsrWorkVo.getTpPymtAmnt().multiply(payrInsrStdVo.getNatPennHmlfBrdnApmrt().divide(new BigDecimal(100))).setScale(-1, BigDecimal.ROUND_DOWN));
				                                   }
		        		                            
		                                	} else {
		                                		
		                                		   if (pkgInsrWorkVo.getTpPymtAmnt().compareTo(new BigDecimal("290000")) <= 0) {
				                                        
				                                 	   pkgInsrWorkVo.setTpNatPennAmt((new BigDecimal("290000")).multiply(payrInsrStdVo.getNatPennHmlfBrdnApmrt().divide(new BigDecimal(100))).setScale(-1,BigDecimal.ROUND_DOWN));
				                                        
				                                   } else  if (pkgInsrWorkVo.getTpPymtAmnt().compareTo(new BigDecimal("4490000")) >= 0) {
				                                       
				                                 	  pkgInsrWorkVo.setTpNatPennAmt((new BigDecimal("4490000")).multiply(payrInsrStdVo.getNatPennHmlfBrdnApmrt().divide(new BigDecimal(100))).setScale(-1,BigDecimal.ROUND_DOWN));
				                                       
				                                   } else {
				                                 	  pkgInsrWorkVo.setTpNatPennAmt(pkgInsrWorkVo.getTpPymtAmnt().multiply(payrInsrStdVo.getNatPennHmlfBrdnApmrt().divide(new BigDecimal(100))).setScale(-1, BigDecimal.ROUND_DOWN));
				                                   }
		                                	} 
		                                    
		                                }
		                                
		                            }
		             	       }   
	                            for(int i540Cnt01 = 0;i540Cnt01 < lisPayr0540.size();i540Cnt01++) { 
	                                   
	                         	     payr0540Vo = new InfcPkgPayr0540VO();
	                                 BeanUtils.copyProperties(payr0540Vo,lisPayr0540.get(i540Cnt01));
	                                 
	                               //  if (ExtermsProps.PAY_DDUC_CD_2.equals(payr0540Vo.getPayItemCd())) {
	                                     
	                               //  }
	                               
	                                 if (ExtermsProps.getProps("PAY_INSR_ETC_CD_01").equals(payr0540Vo.getExptnDivCd())) {
	                                     // public static final String  PAY_INSR_ETC_CD_01 = "B0130002";  //     기여금면제  
	                                 	pkgInsrWorkVo.setTpNatPennAmt( BigDecimal.ZERO);
	                                 }   
	                                
	                             }
                        } else {
                        	
                        	//국민연금 수동입력 
                        	pkgInsrWorkVo.setTpNatPennAmt(pkgTpInsrWorkVo.getTpNatPennAmt());
                        }
                            //국민연금 
                            payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                            payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
                            payr0302Vo.setPayCd(payr0250Vo.getPayCd());    /** column 급여구분코드 : payCd */
                            payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
                            payr0302Vo.setSystemkey(payr0250Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                            payr0302Vo.setPayItemCd("D0150100");   /** column 급여항목코드 : payItemCd */
                            payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
                            payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */ 
                            payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                            payr0302Vo.setPymtDducSum(pkgInsrWorkVo.getTpNatPennAmt());   /** column 지급공제금액 : pymtDducSum */
                            payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
                            payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
                            payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                            payr0302Vo.setPymtDducChgYn(pkgTpInsrWorkVo.getSumChkD0150100());     /** 급여지급공제변경여부 */
                            payr0302Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
     	                    payr0302Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
     	                    payr0302Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
     	                    payr0302Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
                              
                            if (BigDecimal.ZERO.compareTo(pkgInsrWorkVo.getTpNatPennAmt()) != 0)  { 
                            	payrCommCalcService.deletePayr0302Payr0307(payr0302Vo);
                            	payrCommCalcService.insertPayr0302(payr0302Vo);  
                            	pkgInsrWorkVo.setTpDducTotAmnt(pkgInsrWorkVo.getTpDducTotAmnt().add(pkgInsrWorkVo.getTpNatPennAmt()));
                            
                            }
                            pkgInsrWorkVo.setTpNatPennAmt(pkgInsrWorkVo.getTpNatPennAmt().add(sumReattyD0150100));   //2016.10.04
                            
                    } else {
                    	
                 	   if (BigDecimal.ZERO.compareTo(sumReattyD0150100) < 0)  { 
                 		   pkgInsrWorkVo.setTpNatPennAmt(pkgInsrWorkVo.getTpNatPennAmt().add(sumReattyD0150100));   //2016.10.04 
                 	   } else {
                 		   pkgInsrWorkVo.setTpNatPennAmt(BigDecimal.ZERO);   //2016.10.04   
                 	   }
                    }
                    
                    if (payCalculationVo.getUmytInsrApptnYn().equals("Y")) {
                    	
                    	 if (!"Y".equals(pkgTpInsrWorkVo.getSumChkD0160100())) {		
                     
		                      /**************************  고용 보험 금액처리 부추가 ********************************************************************/
		             	       if (MSFSharedUtils.paramNotNull(pkgInsrAmntVo) &&  MSFSharedUtils.paramNotNull(pkgInsrAmntVo.getSystemkey()) &&
		             	    		    pkgInsrAmntVo.getUmytInsrPrmmSrd().compareTo(BigDecimal.ZERO) != 0) {
		             	    	   
		             	    	   InfcPkgInsr5200VO infcPkgInsr5200Vo = new InfcPkgInsr5200VO();
		             	    	   
		         	    	       //금액이존재하는경우 처리됨 우선처리 
		         	    	       pkgInsrWorkVo.setTpUmytInsrApptnAmt(pkgInsrAmntVo.getUmytInsrPrmmSrd());
		         	    	       
		
		 							infcPkgInsr5200Vo.setDpobCd(pkgInsrAmntVo.getDpobCd());    /** column 사업장코드 : dpobCd */
		 							infcPkgInsr5200Vo.setSystemkey(pkgInsrAmntVo.getSystemkey());    /** column SYSTEMKEY : systemkey */
		 							infcPkgInsr5200Vo.setDducYrMnth(pkgInsrAmntVo.getHlthDducYrMnth());    /** column 납부년월 : dducYrMnth */
		 							infcPkgInsr5200Vo.setEmymtSeilNum(pkgInsrAmntVo.getEmymtSeilNum());    /** column 고용일련번호 : emymtSeilNum */
		 							 
		 							infcPkgInsr5200Vo.setUmytPayrDducYrMnth(pkgInsrAmntVo.getUmytPayrDducYrMnth());    /** column 고용보험급여공제년월 : umytPayrDducYrMnth */
		 							//infcPkgInsr5200Vo.setUmytInsrPrcsDt(pkgInsrAmntVo.getUmytInsrPrcsDt());    /** column 고용보험처리일자 : umytInsrPrcsDt */
		 							//infcPkgInsr5200Vo.setUmytInsrPrcsYn(pkgInsrAmntVo.getUmytInsrPrcsYn());    /** column 고용보험처리여부 : umytInsrPrcsYn */
		 						//	infcPkgInsr5200Vo.setUmytInsrPrmmSrd(pkgInsrAmntVo.getUmytInsrPrmmSrd());    /** column 개인실업급여고용보험차액 : umytInsrPrmmSrd */
		 						//	infcPkgInsr5200Vo.setDivdPymtDivCd(pkgInsrAmntVo.getDivdPymtDivCd());    /** column 분할납부구분코드 : divdPymtDivCd */
		 						//	infcPkgInsr5200Vo.setDivdPymt(pkgInsrAmntVo.getDivdPymt());    /** column 분할납부횟수 : divdPymt */
		 						 
		 							infcPkgInsr5200Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
		 							//infcPkgInsr5200Vo.setRevnDt(pkgInsrAmntVo.getRevnDt());    /** column 수정일자 : revnDt */
		 							infcPkgInsr5200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
		
		         	    	       
		         	    	       pkgInsrService.updatePayrToInsr5200(infcPkgInsr5200Vo);
		         	    	       
		             	       } else {  
		             	   
		             	      /************************** 요율처리 부 ***************************************************************************/
		     		             
		                        //고용보험  
		                        if (payCalculationVo.getUmytInsrApptnYn().equals("Y") &&  payCalculationVo.getUmytInsrPayMnthAmnt().compareTo(BigDecimal.ZERO) > 0) {
		                     	   pkgInsrWorkVo.setTpUmytInsrApptnAmt(payCalculationVo.getUmytInsrPayMnthAmnt().multiply(payrInsrStdVo.getUmytInsrHmlfBrdnApmrt().divide(new BigDecimal("100"))).setScale(-1, BigDecimal.ROUND_DOWN));
		                          } else {
		                              //현재금액에서 값을 구한다. 
		                            if (payrInsrStdVo.getUmytInsrHmlfBrdnApmrt().compareTo(pkgInsrWorkVo.getTpPymtAmnt()) >= 0) {
		                         	   pkgInsrWorkVo.setTpUmytInsrApptnAmt(BigDecimal.ZERO);
		                            } else {
		                         	   pkgInsrWorkVo.setTpUmytInsrApptnAmt(pkgInsrWorkVo.getTpPymtAmnt().multiply(payrInsrStdVo.getUmytInsrHmlfBrdnApmrt().divide(new BigDecimal("100"))).setScale(-1, BigDecimal.ROUND_DOWN));
		                          }
		                              
		                          } 
		             	       } 
                    	 } else {
                         	//고용보험 수동입력 
                         	pkgInsrWorkVo.setTpUmytInsrApptnAmt(pkgTpInsrWorkVo.getTpUmytInsrApptnAmt());
                         }     
                           //고용보험  
                           payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                           payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;   /** column 지급년월 : pymtYrMnth */
                           payr0302Vo.setPayCd(payr0250Vo.getPayCd());    /** column 급여구분코드 : payCd */
                           payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());    /** column 급여일련번호 : payrSeilNum */
                           payr0302Vo.setSystemkey(payr0250Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                           payr0302Vo.setPayItemCd("D0160100");   /** column 급여항목코드 : payItemCd */
                           payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);    /** column 급여항목일련번호 : payItemSeilNum */ 
                           payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_03"));    /** column 지급공제구분코드 : pymtDducDivCd */ 
                           payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                           payr0302Vo.setPymtDducSum(pkgInsrWorkVo.getTpUmytInsrApptnAmt());   /** column 지급공제금액 : pymtDducSum */
                           payr0302Vo.setPayPymtDducPrcsFlag("N");   /** column 급여지급공제처리플래그 : payPymtDducPrcsFlag */
                           payr0302Vo.setPayReattyAdmntVal("0");    /** column 급여지급공제소급조정값 : payReattyAdmntVal */
                           payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);    /** column 지급공제과세금액 : pymtDducTxtnAmnt */ 
                           payr0302Vo.setPymtDducChgYn(pkgTpInsrWorkVo.getSumChkD0160100());     /** 급여지급공제변경여부 */
                           payr0302Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
    	                   payr0302Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
    	                   payr0302Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
    	                   payr0302Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
                              
                           if (BigDecimal.ZERO.compareTo(pkgInsrWorkVo.getTpUmytInsrApptnAmt()) != 0)  {   
                        	   
                        	   payrCommCalcService.deletePayr0302Payr0307(payr0302Vo);
                        	   payrCommCalcService.insertPayr0302(payr0302Vo);   
                        	   pkgInsrWorkVo.setTpDducTotAmnt(pkgInsrWorkVo.getTpDducTotAmnt().add(pkgInsrWorkVo.getTpUmytInsrApptnAmt()));
                           
                           }
                     }
                } 
		    return pkgInsrWorkVo;     
	   }     
	 
}
