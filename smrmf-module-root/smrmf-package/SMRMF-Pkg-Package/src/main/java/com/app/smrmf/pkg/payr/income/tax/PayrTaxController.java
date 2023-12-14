/*
 * Copyright yysvip.tistory.com.,LTD.
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information
 * of yysvip.tistory.com.,LTD. ("Confidential Information").
 */
package com.app.smrmf.pkg.payr.income.tax;
 
import java.math.BigDecimal;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0250VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0302VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0305VO;
import com.app.smrmf.pkg.payr.income.tax.service.InComeTaxService;
import com.app.smrmf.pkg.payr.payrcalc.service.PayrCommCalcService;
import com.app.smrmf.pkg.payr.payrcalc.service.PkgPayrCommCalcVO;
import com.app.smrmf.props.ExtermsProps;

/**
 * <pre>
 * 소득세 지방소득세를 구하기 위한 로직  
 * com.app.smrmf.payr.income.tax 
 *    |_ PayrTaxController.java
 * 
 * </pre>
 * @date : Jan 4, 2016 10:33:23 PM
 * @version : 
 * @author : leeheuisung
 */
 
public class PayrTaxController  extends AbstractCustomServiceImpl {

	private static final Logger LOGGER = LoggerFactory.getLogger(PayrTaxController.class);
 
	  private static PayrTaxController onePayrTax;  
	   
	  
	  
	   private  PayrTaxController () {  
		   
	   }
	   
	   public static PayrTaxController getInstance() {
	       if(onePayrTax==null) {
	    	   onePayrTax = new PayrTaxController();
	       }
	       return onePayrTax;
	   }
	   
	    //급여계산  
	    @Autowired
        @Resource(name = "PayrCommCalcService")
        protected PayrCommCalcService payrCommCalcService;
	
	//소득세계 
		@Autowired
	    @Resource(name = "InComeTaxService")
	    protected InComeTaxService inComeTaxService;
			 	 
	 
		
/**
 * 		
 * <pre>
 * 1. 개요 : getWorkIncmTxtn 소득세 지방소득세 처리를 위한 루틴 메서드 공통으로 처리 함
 * 2. 처리내용 : 년도등의 기준이 변경되는 경우 처리를 위해 공통 호출메서드 이용 함 
 * </pre>
 * @Method Name : getWorkIncmTxtn
 * @date : 2017. 8. 21.
 * @author : atres
 * @history : 
 *	-----------------------------------------------------------------------
 *	변경일				작성자						변경내용  
 *	----------- ------------------- ---------------------------------------
 *	2017. 8. 21.		atres				최초 작성 
 *	-----------------------------------------------------------------------
 * 
 * @param request
 * @param payr0250Vo
 * @param payCalculationVo
 * @param tpWorkIncmTxtnSum
 * @param tpNatPennAmt
 * @return
 * @throws Exception
 */
 public  BigDecimal getWorkIncmTxtn(HttpServletRequest request,InfcPkgPayr0250VO payr0250Vo,PkgPayrCommCalcVO payCalculationVo,BigDecimal tpWorkIncmTxtnSum ,BigDecimal tpNatPennAmt) throws Exception {
	
	      BigDecimal workIncmTxtnAmt = BigDecimal.ZERO;
	      
	      if (payCalculationVo.getDayWorkYn().equals("Y")) {
				//		                                                 
	    	  workIncmTxtnAmt =  getFuncWorkDayIncmTxtn( request,payr0250Vo,payCalculationVo,tpWorkIncmTxtnSum ,tpNatPennAmt);      
               
           } else {
        	   
        	    if ("201506".compareTo(payr0250Vo.getJobYrMnth().replace(".", "")) >= 0) {
		  		    	 /********************************************************************************/
		  	  		   /**************간이세액으로 인한 단가표 로 적용되는 경우 처리 추가 예정 
		  	  		   /********************************************************************************/
		  	  		   //무기계약직 소득세/지방소득세 
		  			  workIncmTxtnAmt = getFuncWorkIncmTxtn( request,payr0250Vo,payCalculationVo,tpWorkIncmTxtnSum ,tpNatPennAmt); 
		  	  	  
		  		} else if ("201701".compareTo(payr0250Vo.getJobYrMnth().replace(".", "")) >= 0) {
		  		    	 //소득세/지방소득세  
		  			  workIncmTxtnAmt = getFuncWorkIncmTxtn2015( request,payr0250Vo,payCalculationVo,tpWorkIncmTxtnSum ,tpNatPennAmt);
		  		     
		  	    } else {
		  	   			//20170203일자 소득세법 계정으로 변경된 계산 법 적용    
		  	   		   //소득세/지방소득세  
		  	    	  workIncmTxtnAmt = getFuncWorkIncmTxtn2017( request,payr0250Vo,payCalculationVo,tpWorkIncmTxtnSum ,tpNatPennAmt);
		  	   	   
		  	    }  
                  
           }
	       
		return workIncmTxtnAmt;  
}
 
		
		
		/**
		 * 
		 * <pre>
		 * 1. 개요 : 2017년 2월 변경된 소득세 처리 및 20170701부로 변경된 기준월4소득상한하한선 적용 국민연금처리를 위해 추가된 부분임  
		 * 2. 처리내용 : 
		 * </pre>
		 * @Method Name : getFuncWorkIncmTxtn2017
		 * @date : 2017. 8. 21.
		 * @author : atres
		 * @history : 
		 *	-----------------------------------------------------------------------
		 *	변경일				작성자						변경내용  
		 *	----------- ------------------- ---------------------------------------
		 *	2017. 8. 21.		atres				최초 작성 
		 *	-----------------------------------------------------------------------
		 * 
		 * @param request
		 * @param payr0250Vo
		 * @param payCalculationVo
		 * @param tpWorkIncmTxtnSum
		 * @param tpNatPennAmt
		 * @return
		 * @throws Exception
		 */
	 	public  BigDecimal getFuncWorkIncmTxtn2017(HttpServletRequest request,InfcPkgPayr0250VO payr0250Vo,PkgPayrCommCalcVO payCalculationVo,BigDecimal tpWorkIncmTxtnSum ,BigDecimal tpNatPennAmt) throws Exception {
    		
	  		return funcWorkIncmTxtn2017( request, payr0250Vo, payCalculationVo, tpWorkIncmTxtnSum , tpNatPennAmt);
	  	}
	 	
	  	public  BigDecimal getFuncWorkIncmTxtn2015(HttpServletRequest request,InfcPkgPayr0250VO payr0250Vo,PkgPayrCommCalcVO payCalculationVo,BigDecimal tpWorkIncmTxtnSum ,BigDecimal tpNatPennAmt) throws Exception {
	    		
	  		return funcWorkIncmTxtn2015( request, payr0250Vo, payCalculationVo, tpWorkIncmTxtnSum , tpNatPennAmt);
	  	}
	  	 
	  	
	  	public BigDecimal getFuncWorkIncmTxtn(HttpServletRequest request,InfcPkgPayr0250VO payr0250Vo,PkgPayrCommCalcVO payCalculationVo,BigDecimal tpWorkIncmTxtnSum ,BigDecimal tpNatPennAmt) throws Exception {
	  		
	  		return funcWorkIncmTxtn( request, payr0250Vo, payCalculationVo, tpWorkIncmTxtnSum , tpNatPennAmt) ;
	  	}
	  	
		public   BigDecimal getFuncWorkDayIncmTxtn(HttpServletRequest request,InfcPkgPayr0250VO payr0250Vo,PkgPayrCommCalcVO payCalculationVo,BigDecimal tpWorkIncmTxtnSum ,BigDecimal tpNatPennAmt) throws Exception {
			return funcWorkDayIncmTxtn( request, payr0250Vo, payCalculationVo, tpWorkIncmTxtnSum , tpNatPennAmt);
		}
	  		 
		
	  	/**
	  	 * 2015-07-01부터 소득세법계정에 따른 변경 추가 소득세 지방소득세구하는 로직 
	  	 * @param payr0250Vo
	  	 * @param payCalculationVo
	  	 * @param tpWorkIncmTxtnSum
	  	 * @param tpNatPennAmt
	  	 * @return
	  	 * @throws Exception
	  	 */
	  	private BigDecimal funcWorkIncmTxtn2015(HttpServletRequest request,InfcPkgPayr0250VO payr0250Vo,PkgPayrCommCalcVO payCalculationVo,BigDecimal tpWorkIncmTxtnSum ,BigDecimal tpNatPennAmt) throws Exception {
	  	    
		  	  if  (payrCommCalcService == null) { 
	              WebApplicationContext wac = WebApplicationContextUtils.
	                      getRequiredWebApplicationContext( request.getSession().getServletContext());
	  
	              payrCommCalcService = (PayrCommCalcService) wac.getBean("PayrCommCalcService" ); 
	             
	         }
        	  	  
        	          if  (inComeTaxService == null) { 
        	             WebApplicationContext wac = WebApplicationContextUtils.
        	                     getRequiredWebApplicationContext( request.getSession().getServletContext()); 
        	            
        	             inComeTaxService = (InComeTaxService) wac.getBean("InComeTaxService"); 
        	          } 
	          
	  	            InfcPkgPayr0302VO  payr0302Vo = new InfcPkgPayr0302VO(); 
	  	            InfcPkgPayr0305VO  payr0305Vo = new InfcPkgPayr0305VO();
        	  	   //소득세 지방소득세  
                   
                    BigDecimal eandIncmDducSum = BigDecimal.ZERO; //근로소득공제금액 
             
               
                    if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(5000000 / 12)) <= 0) {
                        
                        eandIncmDducSum = tpWorkIncmTxtnSum.multiply(new BigDecimal("0.70")).setScale(0,BigDecimal.ROUND_DOWN) ;
                    
                    } else if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(15000000 / 12)) <= 0) {
                        
                        eandIncmDducSum = (((tpWorkIncmTxtnSum.subtract(new BigDecimal(5000000.0 / 12))).multiply(new BigDecimal("0.40"))).add(new BigDecimal(3500000.0 / 12))).setScale(0,BigDecimal.ROUND_DOWN) ;
                        
                    } else if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(45000000 / 12)) <= 0) {
                          
                        eandIncmDducSum =  (((tpWorkIncmTxtnSum.subtract(new BigDecimal(15000000.0 / 12))).multiply((new BigDecimal("0.15"))))
                                               .add(new BigDecimal(7500000.0 / 12))).setScale(0, BigDecimal.ROUND_DOWN);
                        
                    } else if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(100000000 / 12)) <= 0) {
                       
                        eandIncmDducSum = (((tpWorkIncmTxtnSum.subtract(new BigDecimal(45000000.0 / 12))).multiply(new BigDecimal("0.05"))).add(new BigDecimal(12000000.0 / 12))).setScale(0,BigDecimal.ROUND_DOWN) ;
                        
                    } else {
                        //1억원초과 
                        eandIncmDducSum = (((tpWorkIncmTxtnSum.subtract(new BigDecimal(100000000.0 / 12))).multiply(new BigDecimal("0.02"))).add(new BigDecimal(14750000.0 / 12))).setScale(0,BigDecimal.ROUND_DOWN) ;
                        
                    }
                    
                    //근로소득금액 
                    BigDecimal tpEandIncmSum = BigDecimal.ZERO; 
                    
                    tpEandIncmSum =  tpWorkIncmTxtnSum.subtract(eandIncmDducSum);
                    
                    //인적공제인원수 
                    BigDecimal tpHmnDducNumPeplNum = BigDecimal.ZERO; 
                    BigDecimal tpHmnDducSum = BigDecimal.ZERO;  //인적공제금액 
                    
                       //본인 
                     tpHmnDducNumPeplNum = tpHmnDducNumPeplNum.add(BigDecimal.ONE);
                    //배우자유무 
                    if ("Y".equals(payCalculationVo.getSpueYn())) {
                        tpHmnDducNumPeplNum = tpHmnDducNumPeplNum.add(BigDecimal.ONE);
                    }
                    
                    tpHmnDducNumPeplNum = (tpHmnDducNumPeplNum.add(payCalculationVo.getSuprtFamyNumEtc().add(payCalculationVo.getSuprtFamyNumTwenChDn()))).add(payCalculationVo.getSuprtFamyNumTwenChDn());
                    
                    //인적공제금액 
                    tpHmnDducSum = (tpHmnDducNumPeplNum.multiply(new BigDecimal(1500000.0 / 12))).setScale(0,BigDecimal.ROUND_DOWN) ;
                    
                    //연금보험료 공제 계산 
                    //연금보험료공제 
                    BigDecimal tpAntyPrmmDducSum = BigDecimal.ZERO; 
                   
                    
                    if (payCalculationVo.getNatPennApptnYn().equals("Y")) {
                     	
                        if (tpNatPennAmt.compareTo(BigDecimal.ZERO) <= 0) {
                            
                            if (tpWorkIncmTxtnSum.compareTo(new BigDecimal("280000")) <= 0) {
                                
                                tpAntyPrmmDducSum = (new BigDecimal("280000")).multiply(new BigDecimal("0.045")).setScale(-1,BigDecimal.ROUND_DOWN);
                                
                           } else   if (tpWorkIncmTxtnSum.compareTo(new BigDecimal("4340000")) >= 0) {
                               
                                tpAntyPrmmDducSum = (new BigDecimal("4340000")).multiply(new BigDecimal("0.045")).setScale(-1,BigDecimal.ROUND_DOWN);
                               
                           } else {
                               tpAntyPrmmDducSum = tpNatPennAmt;
                           } 
                            
                        } else {
                            tpAntyPrmmDducSum = tpNatPennAmt; 
                        } 
                    }  else {
                    	tpAntyPrmmDducSum = tpNatPennAmt; 
                    }
                    
                    
                    //공제 대상자에 따른 특별소득공제 계산
                    BigDecimal tpSpclIncmDducEtcSum = BigDecimal.ZERO;
                    BigDecimal tp40EtcSum = BigDecimal.ZERO;
                    
                    if (tpHmnDducNumPeplNum.compareTo(new BigDecimal(2)) > 0) {
                        //3명이상인경우 
                        
                        tp40EtcSum = ((tpWorkIncmTxtnSum.subtract(new BigDecimal(40000000.0 / 12))).multiply(new BigDecimal("0.04")));
                        
                        if (tp40EtcSum.compareTo(BigDecimal.ZERO) < 0) {
                            tp40EtcSum = BigDecimal.ZERO;
                        }
                        
                        if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(30000000 / 12)) <= 0) {
                            
                           tpSpclIncmDducEtcSum = (tpWorkIncmTxtnSum.multiply(new BigDecimal("0.07"))).add(new BigDecimal(5000000.0 / 12)).add(tp40EtcSum) ; 
                           
                        } else if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(45000000 / 12)) <= 0) {
                            
                            tpSpclIncmDducEtcSum = ((tpWorkIncmTxtnSum.multiply(new BigDecimal("0.07"))).add(new BigDecimal(5000000.0 / 12))).subtract(
                                    ((tpWorkIncmTxtnSum.subtract(new BigDecimal(30000000.0 / 12))).multiply(new BigDecimal("0.05"))))
                                    .add(tp40EtcSum) ;
                            
                        } else if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(70000000 / 12)) <= 0) {
                            
                            tpSpclIncmDducEtcSum = ((tpWorkIncmTxtnSum.multiply(new BigDecimal("0.05"))).add(new BigDecimal(5000000.0 / 12))).add(tp40EtcSum) ;
                            
                        } else if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(120000000 / 12)) <= 0) {
                           
                            tpSpclIncmDducEtcSum = ((tpWorkIncmTxtnSum.multiply(new BigDecimal("0.03"))).add(new BigDecimal(5000000.0 / 12))).add(tp40EtcSum) ;
                            
                        } 
                        
                    } else if (tpHmnDducNumPeplNum.compareTo(new BigDecimal(2)) == 0) {
                        //2명인경우 
                           if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(30000000 / 12)) <= 0) {
                            
                               tpSpclIncmDducEtcSum = (tpWorkIncmTxtnSum.multiply(new BigDecimal("0.04"))).add(new BigDecimal(3600000.0 / 12)) ;
                            
                            } else if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(45000000 / 12)) <= 0) {
                                
                                tpSpclIncmDducEtcSum = ((tpWorkIncmTxtnSum.multiply(new BigDecimal("0.04"))).add(new BigDecimal(3600000.0 / 12))).subtract(
                                        ((tpWorkIncmTxtnSum.subtract(new BigDecimal(30000000.0 / 12))).multiply(new BigDecimal("0.05")))) ;
                                
                            } else if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(70000000 / 12)) <= 0) {
                                
                                tpSpclIncmDducEtcSum = ((tpWorkIncmTxtnSum.multiply(new BigDecimal("0.02"))).add(new BigDecimal(3600000.0 / 12))) ;
                                
                            } else if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(120000000 / 12)) <= 0) {
                               
                                tpSpclIncmDducEtcSum = ((tpWorkIncmTxtnSum.multiply(new BigDecimal("0.01"))).add(new BigDecimal(3600000.0 / 12))) ;
                                
                            } 
                           
                    } else if (tpHmnDducNumPeplNum.compareTo(new BigDecimal(1)) == 0) {
                        //1명인경우 
                           if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(30000000 / 12)) <= 0) {
                            
                               tpSpclIncmDducEtcSum = (tpWorkIncmTxtnSum.multiply(new BigDecimal("0.04"))).add(new BigDecimal(3100000.0 / 12)) ;
                            
                            } else if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(45000000 / 12)) <= 0) {
                                
                                tpSpclIncmDducEtcSum = ((tpWorkIncmTxtnSum.multiply(new BigDecimal("0.04"))).add(new BigDecimal(3100000.0 / 12))).subtract(
                                        ((tpWorkIncmTxtnSum.subtract(new BigDecimal(30000000.0 / 12))).multiply(new BigDecimal("0.05")))) ;
                                
                            } else if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(70000000 / 12)) <= 0) {
                                
                                tpSpclIncmDducEtcSum = ((tpWorkIncmTxtnSum.multiply(new BigDecimal("0.015"))).add(new BigDecimal(3100000.0 / 12))) ;
                                
                            } else if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(120000000 / 12)) <= 0) {
                               
                                tpSpclIncmDducEtcSum = ((tpWorkIncmTxtnSum.multiply(new BigDecimal("0.005"))).add(new BigDecimal(3100000.0 / 12))) ;
                                
                            } 
                            
                    }  else {
                    	//에러처리 
                    }
                    
                    //과세표준 
                    BigDecimal tpTxtnStdSum = BigDecimal.ZERO;
                   //과세표준 
                    tpTxtnStdSum = (tpEandIncmSum.subtract(tpHmnDducSum).subtract(tpAntyPrmmDducSum).subtract(tpSpclIncmDducEtcSum)) ;
                   //산출세율 
                    BigDecimal tpTxtnStdApptnTxrt = BigDecimal.ZERO;
                    //산출세액 
                    BigDecimal tpCalcTxAmnt = BigDecimal.ZERO;
                    
                    BigDecimal tpCalcOvrAmnt = BigDecimal.ZERO;
                    
                    if (tpTxtnStdSum.compareTo(new BigDecimal(12000000 / 12)) <= 0) {
                        
                           tpTxtnStdApptnTxrt = new BigDecimal(6); 
                           tpCalcTxAmnt = (tpTxtnStdSum.multiply(new BigDecimal("0.06"))).setScale(0,BigDecimal.ROUND_DOWN) ;
                        
                    } else if (tpTxtnStdSum.compareTo(new BigDecimal(46000000 / 12)) <= 0) {
                        
                        tpTxtnStdApptnTxrt = new BigDecimal(15);
                        
                        tpCalcOvrAmnt = tpTxtnStdSum.subtract(new BigDecimal(12000000.0 / 12));
                        
                        if (tpCalcOvrAmnt.compareTo(BigDecimal.ZERO) <= 0) {
                            tpCalcOvrAmnt = BigDecimal.ZERO;
                        }
                    
                        tpCalcTxAmnt = ((new BigDecimal(720000.0 / 12)).add((tpCalcOvrAmnt.multiply(new BigDecimal("0.15"))).setScale(0,BigDecimal.ROUND_DOWN))) ;
                        
                    } else if (tpTxtnStdSum.compareTo(new BigDecimal(88000000 / 12)) <= 0) {
                        
                        tpTxtnStdApptnTxrt = new BigDecimal(24);
                        
                        tpCalcOvrAmnt = tpTxtnStdSum.subtract(new BigDecimal(46000000.0 / 12));
                        
                        if (tpCalcOvrAmnt.compareTo(BigDecimal.ZERO) <= 0) {
                            tpCalcOvrAmnt = BigDecimal.ZERO;
                        }
                        
                        tpCalcTxAmnt = ((new BigDecimal(5820000.0 / 12)).add((tpCalcOvrAmnt.multiply(new BigDecimal("0.24"))).setScale(0,BigDecimal.ROUND_DOWN))) ;
                        
                    } else if (tpTxtnStdSum.compareTo(new BigDecimal(150000000 / 12)) <= 0) {
                       
                        tpTxtnStdApptnTxrt = new BigDecimal(35);
                         
                        tpCalcOvrAmnt = tpTxtnStdSum.subtract(new BigDecimal(88000000.0 / 12));
                        
                        if (tpCalcOvrAmnt.compareTo(BigDecimal.ZERO) <= 0) {
                            tpCalcOvrAmnt = BigDecimal.ZERO;
                        }
                        
                        tpCalcTxAmnt = ((new BigDecimal(15900000.0 / 12)).add((tpCalcOvrAmnt.multiply(new BigDecimal("0.35"))).setScale(0,BigDecimal.ROUND_DOWN))) ;
                        
                    } else {
                        
                        tpTxtnStdApptnTxrt = new BigDecimal(38);
                        
                        tpCalcOvrAmnt = tpTxtnStdSum.subtract(new BigDecimal(150000000.0 / 12));
                        
                        if (tpCalcOvrAmnt.compareTo(BigDecimal.ZERO) <= 0) {
                            tpCalcOvrAmnt = BigDecimal.ZERO;
                        }
                        
                        tpCalcTxAmnt = ((new BigDecimal(37600000.0 / 12)).add((tpCalcOvrAmnt.multiply(new BigDecimal("0.38"))).setScale(0,BigDecimal.ROUND_DOWN))) ;
                    }
                    
                    //근로소득세액공제 
                    BigDecimal tpEandIncmTxAmnt = BigDecimal.ZERO;
                    
                    if (tpCalcTxAmnt.compareTo(new BigDecimal(500000 / 12)) <= 0) {
                        tpEandIncmTxAmnt = (tpCalcTxAmnt.multiply(new BigDecimal("0.55"))).setScale(-1,BigDecimal.ROUND_DOWN) ; 
                    } else {
                        //공제한도금액 수정 
                       //   간이세액표 상 근로소득세액공제 한도
                       // • 총급여액이 5천 500만원 이하인 경우：66만원 / 12  4583333.333  / 55000  
                       // • 총급여액이 5천 500만원 초과 7천만원 이하인 경우：63만원 /12  5833333.333    / 52500
                       // • 총급여액이 7천만원 초과하는 경우：50만원 / 12  5833333.333       41666.666
                        BigDecimal tmEandIncmTxAm = BigDecimal.ZERO;
                       
                        tmEandIncmTxAm =  (((tpCalcTxAmnt.subtract((new BigDecimal("41666")))).multiply(new BigDecimal("0.30"))).add((new BigDecimal(275000.0/12)))); 
                       
                        if (tpWorkIncmTxtnSum.compareTo(new BigDecimal("4583333")) <= 0) { 
                          
                            if (tmEandIncmTxAm.compareTo(new BigDecimal("55000")) <= 0) {
                                tpEandIncmTxAmnt = tmEandIncmTxAm;
                            } else {
                                tpEandIncmTxAmnt = (new BigDecimal("55000")); 
                               
                            } 
                            
                        } else if (tpWorkIncmTxtnSum.compareTo(new BigDecimal("5833333")) <= 0) {
                            
                            if (tmEandIncmTxAm.compareTo(new BigDecimal("52500")) <= 0) {
                                tpEandIncmTxAmnt = tmEandIncmTxAm;
                            } else {
                                tpEandIncmTxAmnt = (new BigDecimal("52500")); 
                               
                            } 
                            
                        } else {
                            
                            if (tmEandIncmTxAm.compareTo(new BigDecimal("41666")) <= 0) {
                                tpEandIncmTxAmnt = tmEandIncmTxAm;
                            } else {
                                tpEandIncmTxAmnt = (new BigDecimal("41666"));
                            }  
                        } 
                          
                    }
                    //결정세액 
                    BigDecimal tpDeinTxAmnt = BigDecimal.ZERO;
                    
                    tpDeinTxAmnt = (tpCalcTxAmnt.setScale(-1,BigDecimal.ROUND_DOWN)).subtract(tpEandIncmTxAmnt.setScale(-1,BigDecimal.ROUND_DOWN));
                    
                    if (tpDeinTxAmnt.compareTo(BigDecimal.ZERO) < 0 ) {
                        
                        tpDeinTxAmnt = BigDecimal.ZERO;
                    }
                    
                    
                    //간이세액
                    BigDecimal tpTxtbSimfTxs = BigDecimal.ZERO;
                    
                    tpTxtbSimfTxs = tpDeinTxAmnt;
                    
                    
                    
                    /** column 실소득세액 : turtyIncmTxQnty */
                    BigDecimal tpTurtyIncmTxQnty = BigDecimal.ZERO;

                    /********************************************************************
                     * 소득원천세액 본인세액조정 +++++++++++++++++++++++++++++++++++++++++++++++
                     ********************************************************************/
                     tpTurtyIncmTxQnty = tpDeinTxAmnt; 
                    
                     if (!ExtermsProps.getProps("PAYR_TAX_B0290020").equals(MSFSharedUtils.allowNulls(payCalculationVo.getAddIncmTxApptnRtoCd()))) {
                    	 if (MSFSharedUtils.allowNulls(payCalculationVo.getAddIncmTxApptnYrMnth()).compareTo(payr0250Vo.getJobYrMnth().replace(".","")) <= 0) {
                             
                    		 tpTurtyIncmTxQnty = tpDeinTxAmnt.multiply((payCalculationVo.getAddIncmTxApptnRto().divide(new BigDecimal("100"), 5, BigDecimal.ROUND_DOWN))).setScale(-1,BigDecimal.ROUND_DOWN) ;
                    	 } 
                     }  
                    
                    /********************************************************************
                     * 소득원천세액 본인세액조정 +++++++++++++++++++++++++++++++++++++++++++++++ 
                     ********************************************************************/ 
                    
                    //지방소득세
                    BigDecimal tpLocIncmTxAmt = BigDecimal.ZERO;
                    tpLocIncmTxAmt = tpTurtyIncmTxQnty.multiply(new BigDecimal("0.10")).setScale(-1,BigDecimal.ROUND_DOWN);
                    
                     
                    //소득세   
                    payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                    payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;
                    payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());
                    payr0302Vo.setPayItemCd("T0010100");
                    payr0302Vo.setPayCd(payCalculationVo.getPayCd()); 
                    payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());
                    payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);
                    payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_04"));
                    payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);
                    payr0302Vo.setPymtDducSum(tpTurtyIncmTxQnty);
                    payr0302Vo.setPayPymtDducPrcsFlag("N");
                    payr0302Vo.setPayReattyAdmntVal("0");
                    payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);
//                  payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//                  payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//                  payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//                  payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//                  payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//                  payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
                    payrCommCalcService.deletePayr0302ToPayr0307T(payr0302Vo);  
                    
                    payrCommCalcService.insertPayr0302(payr0302Vo);
                    
                    
                    //지방소득세   
                    payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                    payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;
                    payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());
                    payr0302Vo.setPayItemCd("T0020100");
                    payr0302Vo.setPayCd(payCalculationVo.getPayCd()); 
                    payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());
                    payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);
                    payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_04"));
                    payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);
                    payr0302Vo.setPymtDducSum(tpLocIncmTxAmt);
                    payr0302Vo.setPayPymtDducPrcsFlag("N");
                    payr0302Vo.setPayReattyAdmntVal("0");
                    payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);
//                  payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//                  payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//                  payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//                  payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//                  payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//                  payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
                    payrCommCalcService.deletePayr0302ToPayr0307T(payr0302Vo);  
                    
                    payrCommCalcService.insertPayr0302(payr0302Vo);  
                     
                  
                   //근로소득간이세액표산출값 
                   payr0305Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                   payr0305Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());                 
                   payr0305Vo.setPayCd(payCalculationVo.getPayCd());                      
                   payr0305Vo.setSystemkey(payCalculationVo.getSystemkey());               
                   payr0305Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());                
                   payr0305Vo.setWorkIncmTxtnSum(tpWorkIncmTxtnSum);            
                   payr0305Vo.setPaySectiCtrSum(BigDecimal.ZERO);             
                   payr0305Vo.setYrlyTotPayQNty(BigDecimal.ZERO);             
                   payr0305Vo.setEandIncmDducSum(eandIncmDducSum.setScale(-1,BigDecimal.ROUND_DOWN));  
                   payr0305Vo.setEandIncmSum(tpEandIncmSum.setScale(-1,BigDecimal.ROUND_DOWN));   
                   payr0305Vo.setHmnDducNumPeplNum(tpHmnDducNumPeplNum);          
                   payr0305Vo.setHmnDducTwenSqntsChdnNum(payCalculationVo.getSuprtFamyNumTwenChDn());    
                   payr0305Vo.setHmnDducSum(tpHmnDducSum.setScale(-1,BigDecimal.ROUND_DOWN));                 
                   payr0305Vo.setAntyPrmmDducSum(tpAntyPrmmDducSum.setScale(-1,BigDecimal.ROUND_DOWN));            
                   payr0305Vo.setSpclIncmDducEtcSum(tpSpclIncmDducEtcSum.setScale(-1,BigDecimal.ROUND_DOWN));         
                   payr0305Vo.setTxtnStdSum(tpTxtnStdSum.setScale(-1,BigDecimal.ROUND_DOWN));                 
                   payr0305Vo.setTxtnStdApptnTxrt(tpTxtnStdApptnTxrt);           
                   payr0305Vo.setTxtnStdPgivDducSum(BigDecimal.ZERO);         
                   payr0305Vo.setCalcTxAmnt(tpCalcTxAmnt.setScale(-1,BigDecimal.ROUND_DOWN));           
                   payr0305Vo.setEandIncmTxAmnt(tpEandIncmTxAmnt.setScale(-1,BigDecimal.ROUND_DOWN));                
                   payr0305Vo.setDeinTxAmnt(tpDeinTxAmnt.setScale(-1,BigDecimal.ROUND_DOWN));                 
                   payr0305Vo.setTxtbSimfTxs(tpTxtbSimfTxs.setScale(-1,BigDecimal.ROUND_DOWN));  
                   payr0305Vo.setLocIncmTxAmt(tpLocIncmTxAmt.setScale(-1,BigDecimal.ROUND_DOWN));    
                   payr0305Vo.setAddIncmTxRate(payCalculationVo.getAddIncmTxApptnRto());    /** column 추가소득세율 : addIncmTxRate */
                   payr0305Vo.setTurtyIncmTxQnty(tpTurtyIncmTxQnty.setScale(-1,BigDecimal.ROUND_DOWN));    /** column 실소득세액 : turtyIncmTxQnty */
                   
                   payr0305Vo.setMnlTxtbSimfTxs(BigDecimal.ZERO);    /** column 수동소득세 : mnlTxtbSimfTxs */
                   payr0305Vo.setMnlLocTxAmt(BigDecimal.ZERO);    /** column 수동지방소득세 : mnlLocTxAmt */
                   payr0305Vo.setMnlTxtbSimfYn("N");    /** column 수동소득세여부 : mnlTxtbSimfYn */
                   
//                 payr0305Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//                 payr0305Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//                 payr0305Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//                 payr0305Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//                 payr0305Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//                 payr0305Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
                   inComeTaxService.deletePayr0305(payr0305Vo);
                   
                   inComeTaxService.insertPayr0305(payr0305Vo);
                   
               return  tpTurtyIncmTxQnty.add(tpLocIncmTxAmt);   
	  	}
	  	
	  	/**
	  	 * 소득세 지방소득세구하는 로직 
	  	 * @param payr0250Vo
	  	 * @param payCalculationVo
	  	 * @param tpWorkIncmTxtnSum
	  	 * @param tpNatPennAmt
	  	 * @return
	  	 * @throws Exception
	  	 */
	  	private BigDecimal funcWorkIncmTxtn(HttpServletRequest request,InfcPkgPayr0250VO payr0250Vo,PkgPayrCommCalcVO payCalculationVo,BigDecimal tpWorkIncmTxtnSum ,BigDecimal tpNatPennAmt) throws Exception {
	  	    
	  	  if  (payrCommCalcService == null) { 
              WebApplicationContext wac = WebApplicationContextUtils.
                      getRequiredWebApplicationContext( request.getSession().getServletContext());
  
              payrCommCalcService = (PayrCommCalcService) wac.getBean("PayrCommCalcService" ); 
             
         }
        	  	  
        	          if  (inComeTaxService == null) { 
        	             WebApplicationContext wac = WebApplicationContextUtils.
        	                     getRequiredWebApplicationContext( request.getSession().getServletContext()); 
        	            
        	             inComeTaxService = (InComeTaxService) wac.getBean("InComeTaxService"); 
        	          } 
	          
	  	            InfcPkgPayr0302VO  payr0302Vo = new InfcPkgPayr0302VO(); 
	  	            InfcPkgPayr0305VO  payr0305Vo = new InfcPkgPayr0305VO();
        	  	   //소득세 지방소득세  
                   
                    BigDecimal eandIncmDducSum = BigDecimal.ZERO; //근로소득공제금액 
             
               
                    if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(5000000 / 12)) <= 0) {
                        
                        eandIncmDducSum = tpWorkIncmTxtnSum.multiply(new BigDecimal("0.70")).setScale(0,BigDecimal.ROUND_DOWN) ;
                    
                    } else if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(15000000 / 12)) <= 0) {
                        
                        eandIncmDducSum = (((tpWorkIncmTxtnSum.subtract(new BigDecimal(5000000.0 / 12))).multiply(new BigDecimal("0.40"))).add(new BigDecimal(3500000.0 / 12))).setScale(0,BigDecimal.ROUND_DOWN) ;
                        
                    } else if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(45000000 / 12)) <= 0) {
                          
                        eandIncmDducSum =  (((tpWorkIncmTxtnSum.subtract(new BigDecimal(15000000.0 / 12))).multiply((new BigDecimal("0.15"))))
                                               .add(new BigDecimal(7500000.0 / 12))).setScale(0, BigDecimal.ROUND_DOWN);
                        
                    } else if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(100000000 / 12)) <= 0) {
                       
                        eandIncmDducSum = (((tpWorkIncmTxtnSum.subtract(new BigDecimal(45000000.0 / 12))).multiply(new BigDecimal("0.05"))).add(new BigDecimal(12000000.0 / 12))).setScale(0,BigDecimal.ROUND_DOWN) ;
                        
                    } else {
                        //1억원초과 
                        eandIncmDducSum = (((tpWorkIncmTxtnSum.subtract(new BigDecimal(100000000.0 / 12))).multiply(new BigDecimal("0.02"))).add(new BigDecimal(14750000.0 / 12))).setScale(0,BigDecimal.ROUND_DOWN) ;
                        
                    }
                    
                    //근로소득금액 
                    BigDecimal tpEandIncmSum = BigDecimal.ZERO; 
                    
                    tpEandIncmSum =  tpWorkIncmTxtnSum.subtract(eandIncmDducSum);
                    
                    //인적공제인원수 
                    BigDecimal tpHmnDducNumPeplNum = BigDecimal.ZERO; 
                    BigDecimal tpHmnDducSum = BigDecimal.ZERO;  //인적공제금액 
                    
                       //본인 
                     tpHmnDducNumPeplNum = tpHmnDducNumPeplNum.add(BigDecimal.ONE);
                    //배우자유무 
                    if ("Y".equals(payCalculationVo.getSpueYn())) {
                        tpHmnDducNumPeplNum = tpHmnDducNumPeplNum.add(BigDecimal.ONE);
                    }
                    
                    tpHmnDducNumPeplNum = (tpHmnDducNumPeplNum.add(payCalculationVo.getSuprtFamyNumEtc().add(payCalculationVo.getSuprtFamyNumTwenChDn()))).add(payCalculationVo.getSuprtFamyNumTwenChDn());
                    
                    //인적공제금액 
                    tpHmnDducSum = (tpHmnDducNumPeplNum.multiply(new BigDecimal(1500000.0 / 12))).setScale(0,BigDecimal.ROUND_DOWN) ;
                    
                    //연금보험료 공제 계산 
                    //연금보험료공제 
                    BigDecimal tpAntyPrmmDducSum = BigDecimal.ZERO; 
                   
                    
                    if (payCalculationVo.getNatPennApptnYn().equals("Y")) {
                        if (tpNatPennAmt.compareTo(BigDecimal.ZERO) <= 0) {
                            
                            if (tpWorkIncmTxtnSum.compareTo(new BigDecimal("250000")) <= 0) {
                                
                                tpAntyPrmmDducSum = (new BigDecimal("250000")).multiply(new BigDecimal("0.045")).setScale(-1,BigDecimal.ROUND_DOWN);
                                
                           } else   if (tpWorkIncmTxtnSum.compareTo(new BigDecimal("3980000")) >= 0) {
                               
                                tpAntyPrmmDducSum = (new BigDecimal("3980000")).multiply(new BigDecimal("0.045")).setScale(-1,BigDecimal.ROUND_DOWN);
                               
                           } else {
                               tpAntyPrmmDducSum = tpNatPennAmt;
                           } 
                            
                        } else {
                            tpAntyPrmmDducSum = tpNatPennAmt; 
                        } 
                    }  else {
                    	tpAntyPrmmDducSum = tpNatPennAmt; 
                    }
                    
                    
                    //공제 대상자에 따른 특별소득공제 계산
                    BigDecimal tpSpclIncmDducEtcSum = BigDecimal.ZERO;
                    BigDecimal tp40EtcSum = BigDecimal.ZERO;
                    
                    if (tpHmnDducNumPeplNum.compareTo(new BigDecimal(2)) > 0) {
                        //3명이상인경우 
                        
                        tp40EtcSum = ((tpWorkIncmTxtnSum.subtract(new BigDecimal(40000000.0 / 12))).multiply(new BigDecimal("0.04")));
                        
                        if (tp40EtcSum.compareTo(BigDecimal.ZERO) < 0) {
                            tp40EtcSum = BigDecimal.ZERO;
                        }
                        
                        if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(30000000 / 12)) <= 0) {
                            
                           tpSpclIncmDducEtcSum = (tpWorkIncmTxtnSum.multiply(new BigDecimal("0.07"))).add(new BigDecimal(5000000.0 / 12)).add(tp40EtcSum) ; 
                           
                        } else if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(45000000 / 12)) <= 0) {
                            
                            tpSpclIncmDducEtcSum = ((tpWorkIncmTxtnSum.multiply(new BigDecimal("0.07"))).add(new BigDecimal(5000000.0 / 12))).subtract(
                                    ((tpWorkIncmTxtnSum.subtract(new BigDecimal(30000000.0 / 12))).multiply(new BigDecimal("0.05"))))
                                    .add(tp40EtcSum) ;
                            
                        } else if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(70000000 / 12)) <= 0) {
                            
                            tpSpclIncmDducEtcSum = ((tpWorkIncmTxtnSum.multiply(new BigDecimal("0.05"))).add(new BigDecimal(5000000.0 / 12))).add(tp40EtcSum) ;
                            
                        } else if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(120000000 / 12)) <= 0) {
                           
                            tpSpclIncmDducEtcSum = ((tpWorkIncmTxtnSum.multiply(new BigDecimal("0.03"))).add(new BigDecimal(5000000.0 / 12))).add(tp40EtcSum) ;
                            
                        } 
                        
                    } else {
                        //3명이하인경우 
                           if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(30000000 / 12)) <= 0) {
                            
                               tpSpclIncmDducEtcSum = (tpWorkIncmTxtnSum.multiply(new BigDecimal("0.04"))).add(new BigDecimal(3600000.0 / 12)) ;
                            
                            } else if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(45000000 / 12)) <= 0) {
                                
                                tpSpclIncmDducEtcSum = ((tpWorkIncmTxtnSum.multiply(new BigDecimal("0.04"))).add(new BigDecimal(3600000.0 / 12))).subtract(
                                        ((tpWorkIncmTxtnSum.subtract(new BigDecimal(30000000.0 / 12))).multiply(new BigDecimal("0.05")))) ;
                                
                            } else if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(70000000 / 12)) <= 0) {
                                
                                tpSpclIncmDducEtcSum = ((tpWorkIncmTxtnSum.multiply(new BigDecimal("0.02"))).add(new BigDecimal(3600000.0 / 12))) ;
                                
                            } else if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(120000000 / 12)) <= 0) {
                               
                                tpSpclIncmDducEtcSum = ((tpWorkIncmTxtnSum.multiply(new BigDecimal("0.01"))).add(new BigDecimal(3600000.0 / 12))) ;
                                
                            } 
                            
                    }
                    
                    //과세표준 
                    BigDecimal tpTxtnStdSum = BigDecimal.ZERO;
                   //과세표준 
                    tpTxtnStdSum = (tpEandIncmSum.subtract(tpHmnDducSum).subtract(tpAntyPrmmDducSum).subtract(tpSpclIncmDducEtcSum)) ;
                   //산출세율 
                    BigDecimal tpTxtnStdApptnTxrt = BigDecimal.ZERO;
                    //산출세액 
                    BigDecimal tpCalcTxAmnt = BigDecimal.ZERO;
                    
                    BigDecimal tpCalcOvrAmnt = BigDecimal.ZERO;
                    
                    if (tpTxtnStdSum.compareTo(new BigDecimal(12000000 / 12)) <= 0) {
                        
                           tpTxtnStdApptnTxrt = new BigDecimal(6); 
                           tpCalcTxAmnt = (tpTxtnStdSum.multiply(new BigDecimal("0.06"))).setScale(0,BigDecimal.ROUND_DOWN) ;
                        
                    } else if (tpTxtnStdSum.compareTo(new BigDecimal(46000000 / 12)) <= 0) {
                        
                        tpTxtnStdApptnTxrt = new BigDecimal(15);
                        
                        tpCalcOvrAmnt = tpTxtnStdSum.subtract(new BigDecimal(12000000.0 / 12));
                        
                        if (tpCalcOvrAmnt.compareTo(BigDecimal.ZERO) <= 0) {
                            tpCalcOvrAmnt = BigDecimal.ZERO;
                        }
                    
                        tpCalcTxAmnt = ((new BigDecimal(720000.0 / 12)).add((tpCalcOvrAmnt.multiply(new BigDecimal("0.15"))).setScale(0,BigDecimal.ROUND_DOWN))) ;
                        
                    } else if (tpTxtnStdSum.compareTo(new BigDecimal(88000000 / 12)) <= 0) {
                        
                        tpTxtnStdApptnTxrt = new BigDecimal(24);
                        
                        tpCalcOvrAmnt = tpTxtnStdSum.subtract(new BigDecimal(46000000.0 / 12));
                        
                        if (tpCalcOvrAmnt.compareTo(BigDecimal.ZERO) <= 0) {
                            tpCalcOvrAmnt = BigDecimal.ZERO;
                        }
                        
                        tpCalcTxAmnt = ((new BigDecimal(5820000.0 / 12)).add((tpCalcOvrAmnt.multiply(new BigDecimal("0.24"))).setScale(0,BigDecimal.ROUND_DOWN))) ;
                        
                    } else if (tpTxtnStdSum.compareTo(new BigDecimal(150000000 / 12)) <= 0) {
                       
                        tpTxtnStdApptnTxrt = new BigDecimal(35);
                         
                        tpCalcOvrAmnt = tpTxtnStdSum.subtract(new BigDecimal(88000000.0 / 12));
                        
                        if (tpCalcOvrAmnt.compareTo(BigDecimal.ZERO) <= 0) {
                            tpCalcOvrAmnt = BigDecimal.ZERO;
                        }
                        
                        tpCalcTxAmnt = ((new BigDecimal(15900000.0 / 12)).add((tpCalcOvrAmnt.multiply(new BigDecimal("0.35"))).setScale(0,BigDecimal.ROUND_DOWN))) ;
                        
                    } else {
                        
                        tpTxtnStdApptnTxrt = new BigDecimal(38);
                        
                        tpCalcOvrAmnt = tpTxtnStdSum.subtract(new BigDecimal(150000000.0 / 12));
                        
                        if (tpCalcOvrAmnt.compareTo(BigDecimal.ZERO) <= 0) {
                            tpCalcOvrAmnt = BigDecimal.ZERO;
                        }
                        
                        tpCalcTxAmnt = ((new BigDecimal(37600000.0 / 12)).add((tpCalcOvrAmnt.multiply(new BigDecimal("0.38"))).setScale(0,BigDecimal.ROUND_DOWN))) ;
                    }
                    
                    //근로소득세액공제 
                    BigDecimal tpEandIncmTxAmnt = BigDecimal.ZERO;
                    
                    if (tpCalcTxAmnt.compareTo(new BigDecimal(500000 / 12)) <= 0) {
                        tpEandIncmTxAmnt = (tpCalcTxAmnt.multiply(new BigDecimal("0.55"))).setScale(-1,BigDecimal.ROUND_DOWN) ; 
                    } else {
                        //공제한도금액 수정 
                       //   간이세액표 상 근로소득세액공제 한도
                       // • 총급여액이 5천 500만원 이하인 경우：66만원 / 12  4583333.333  / 55000  
                       // • 총급여액이 5천 500만원 초과 7천만원 이하인 경우：63만원 /12  5833333.333    / 52500
                       // • 총급여액이 7천만원 초과하는 경우：50만원 / 12  5833333.333       41666.666
                        BigDecimal tmEandIncmTxAm = BigDecimal.ZERO;
                       
                        tmEandIncmTxAm =  (((tpCalcTxAmnt.subtract((new BigDecimal("41666")))).multiply(new BigDecimal("0.30"))).add((new BigDecimal(275000.0/12)))); 
                       
                        if (tpWorkIncmTxtnSum.compareTo(new BigDecimal("4583333")) <= 0) { 
                          
                            if (tmEandIncmTxAm.compareTo(new BigDecimal("55000")) <= 0) {
                                tpEandIncmTxAmnt = tmEandIncmTxAm;
                            } else {
                                tpEandIncmTxAmnt = (new BigDecimal("55000")); 
                               
                            } 
                            
                        } else if (tpWorkIncmTxtnSum.compareTo(new BigDecimal("5833333")) <= 0) {
                            
                            if (tmEandIncmTxAm.compareTo(new BigDecimal("52500")) <= 0) {
                                tpEandIncmTxAmnt = tmEandIncmTxAm;
                            } else {
                                tpEandIncmTxAmnt = (new BigDecimal("52500")); 
                               
                            } 
                            
                        } else {
                            
                            if (tmEandIncmTxAm.compareTo(new BigDecimal("41666")) <= 0) {
                                tpEandIncmTxAmnt = tmEandIncmTxAm;
                            } else {
                                tpEandIncmTxAmnt = (new BigDecimal("41666"));
                            }  
                        } 
                          
                    }
                    //결정세액 
                    BigDecimal tpDeinTxAmnt = BigDecimal.ZERO;
                    
                    tpDeinTxAmnt = (tpCalcTxAmnt.setScale(-1,BigDecimal.ROUND_DOWN)).subtract(tpEandIncmTxAmnt.setScale(-1,BigDecimal.ROUND_DOWN));
                    
                    if (tpDeinTxAmnt.compareTo(BigDecimal.ZERO) < 0 ) {
                        
                        tpDeinTxAmnt = BigDecimal.ZERO;
                    }
                    
                    //간이세액
                    BigDecimal tpTxtbSimfTxs = BigDecimal.ZERO;
                    
                    tpTxtbSimfTxs = tpDeinTxAmnt;
                    
                    /** column 실소득세액 : turtyIncmTxQnty */
                    BigDecimal tpTurtyIncmTxQnty = BigDecimal.ZERO;

                    tpTurtyIncmTxQnty = tpDeinTxAmnt;
                    
                    //지방소득세
                    BigDecimal tpLocIncmTxAmt = BigDecimal.ZERO;
                    tpLocIncmTxAmt = tpTurtyIncmTxQnty.multiply(new BigDecimal("0.10")).setScale(-1,BigDecimal.ROUND_DOWN);
                   
                     
                    //소득세   
                    payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                    payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;
                    payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());
                    payr0302Vo.setPayItemCd("T0010100");
                    payr0302Vo.setPayCd(payCalculationVo.getPayCd()); 
                    payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());
                    payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);
                    payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_04"));
                    payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);
                    payr0302Vo.setPymtDducSum(tpTurtyIncmTxQnty);
                    payr0302Vo.setPayPymtDducPrcsFlag("N");
                    payr0302Vo.setPayReattyAdmntVal("0");
                    payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);
//                  payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//                  payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//                  payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//                  payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//                  payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//                  payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
                    payrCommCalcService.deletePayr0302ToPayr0307T(payr0302Vo);  
                    
                    payrCommCalcService.insertPayr0302(payr0302Vo);
                    
                    
                    //지방소득세   
                    payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                    payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;
                    payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());
                    payr0302Vo.setPayItemCd("T0020100");
                    payr0302Vo.setPayCd(payCalculationVo.getPayCd()); 
                    payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());
                    payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);
                    payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_04"));
                    payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);
                    payr0302Vo.setPymtDducSum(tpLocIncmTxAmt);
                    payr0302Vo.setPayPymtDducPrcsFlag("N");
                    payr0302Vo.setPayReattyAdmntVal("0");
                    payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);
//                  payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//                  payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//                  payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//                  payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//                  payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//                  payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
                    payrCommCalcService.deletePayr0302ToPayr0307T(payr0302Vo);  
                    
                    payrCommCalcService.insertPayr0302(payr0302Vo);  
                     
                  
                    //근로소득간이세액표산출값 
                   payr0305Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                   payr0305Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());                 
                   payr0305Vo.setPayCd(payCalculationVo.getPayCd());                      
                   payr0305Vo.setSystemkey(payCalculationVo.getSystemkey());               
                   payr0305Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());                
                   payr0305Vo.setWorkIncmTxtnSum(tpWorkIncmTxtnSum);            
                   payr0305Vo.setPaySectiCtrSum(BigDecimal.ZERO);             
                   payr0305Vo.setYrlyTotPayQNty(BigDecimal.ZERO);             
                   payr0305Vo.setEandIncmDducSum(eandIncmDducSum.setScale(-1,BigDecimal.ROUND_DOWN));  
                   payr0305Vo.setEandIncmSum(tpEandIncmSum.setScale(-1,BigDecimal.ROUND_DOWN));   
                   payr0305Vo.setHmnDducNumPeplNum(tpHmnDducNumPeplNum);          
                   payr0305Vo.setHmnDducTwenSqntsChdnNum(payCalculationVo.getSuprtFamyNumTwenChDn());    
                   payr0305Vo.setHmnDducSum(tpHmnDducSum.setScale(-1,BigDecimal.ROUND_DOWN));                 
                   payr0305Vo.setAntyPrmmDducSum(tpAntyPrmmDducSum.setScale(-1,BigDecimal.ROUND_DOWN));            
                   payr0305Vo.setSpclIncmDducEtcSum(tpSpclIncmDducEtcSum.setScale(-1,BigDecimal.ROUND_DOWN));         
                   payr0305Vo.setTxtnStdSum(tpTxtnStdSum.setScale(-1,BigDecimal.ROUND_DOWN));                 
                   payr0305Vo.setTxtnStdApptnTxrt(tpTxtnStdApptnTxrt);           
                   payr0305Vo.setTxtnStdPgivDducSum(BigDecimal.ZERO);         
                   payr0305Vo.setCalcTxAmnt(tpCalcTxAmnt.setScale(-1,BigDecimal.ROUND_DOWN));           
                   payr0305Vo.setEandIncmTxAmnt(tpEandIncmTxAmnt.setScale(-1,BigDecimal.ROUND_DOWN));                
                   payr0305Vo.setDeinTxAmnt(tpDeinTxAmnt.setScale(-1,BigDecimal.ROUND_DOWN));                 
                   payr0305Vo.setTxtbSimfTxs(tpTxtbSimfTxs.setScale(-1,BigDecimal.ROUND_DOWN));  
                   payr0305Vo.setLocIncmTxAmt(tpLocIncmTxAmt.setScale(-1,BigDecimal.ROUND_DOWN));  
                   payr0305Vo.setAddIncmTxRate(BigDecimal.ZERO);    /** column 추가소득세율 : addIncmTxRate */
                   payr0305Vo.setTurtyIncmTxQnty(tpTurtyIncmTxQnty.setScale(-1,BigDecimal.ROUND_DOWN));    /** column 실소득세액 : turtyIncmTxQnty */
                   payr0305Vo.setMnlTxtbSimfTxs(BigDecimal.ZERO);    /** column 수동소득세 : mnlTxtbSimfTxs */
                   payr0305Vo.setMnlLocTxAmt(BigDecimal.ZERO);    /** column 수동지방소득세 : mnlLocTxAmt */
                   payr0305Vo.setMnlTxtbSimfYn("N");    /** column 수동소득세여부 : mnlTxtbSimfYn */
//                 payr0305Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//                 payr0305Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//                 payr0305Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//                 payr0305Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//                 payr0305Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//                 payr0305Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
                   inComeTaxService.deletePayr0305(payr0305Vo);
                   
                   inComeTaxService.insertPayr0305(payr0305Vo);
                   
               return  tpTurtyIncmTxQnty.add(tpLocIncmTxAmt);   
	  	}
	  	
	     
	  	
	  	/**
	  	 * 
	  	 * <pre>
	  	 * 1. 개요 : 소득세 지방소득세구하는 로직 -일용직인경우 처리 루틴 
	  	 * 2. 처리내용 : 
	  	 * </pre>
	  	 * @Method Name : funcWorkDayIncmTxtn
	  	 * @date : Jan 4, 2016
	  	 * @author : leeheuisung
	  	 * @history : 
	  	 *	-----------------------------------------------------------------------
	  	 *	변경일				작성자						변경내용  
	  	 *	----------- ------------------- ---------------------------------------
	  	 *	Jan 4, 2016		leeheuisung				최초 작성 
	  	 *	-----------------------------------------------------------------------
	  	 * 
	  	 * @param request
	  	 * @param payr0250Vo
	  	 * @param payCalculationVo
	  	 * @param tpWorkIncmTxtnSum
	  	 * @param tpNatPennAmt
	  	 * @return
	  	 * @throws Exception
	  	 */
	  	private   BigDecimal funcWorkDayIncmTxtn(HttpServletRequest request,InfcPkgPayr0250VO payr0250Vo,PkgPayrCommCalcVO payCalculationVo,BigDecimal tpWorkIncmTxtnSum ,BigDecimal tpNatPennAmt) throws Exception {
            
	  	  if  (payrCommCalcService == null) { 
              WebApplicationContext wac = WebApplicationContextUtils.
                      getRequiredWebApplicationContext( request.getSession().getServletContext());
  
              payrCommCalcService = (PayrCommCalcService) wac.getBean("PayrCommCalcService" ); 
             
         }
                  
                      if  (inComeTaxService == null) { 
                         WebApplicationContext wac = WebApplicationContextUtils.
                                 getRequiredWebApplicationContext( request.getSession().getServletContext()); 
                        
                         inComeTaxService = (InComeTaxService) wac.getBean("InComeTaxService"); 
                      } 
              
                    InfcPkgPayr0302VO  payr0302Vo = new InfcPkgPayr0302VO(); 
                    InfcPkgPayr0305VO  payr0305Vo = new InfcPkgPayr0305VO();
                   //소득세 지방소득세  
                   
                    BigDecimal eandIncmDducSum = BigDecimal.ZERO; //근로소득공제금액 
            
                     
                    eandIncmDducSum = (new BigDecimal("100000")).setScale(-1, BigDecimal.ROUND_DOWN);
            
                    //근로소득금액 
                    BigDecimal tpEandIncmSum = BigDecimal.ZERO; 
                    
                    tpEandIncmSum =  tpWorkIncmTxtnSum.subtract((eandIncmDducSum.multiply(new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys()))).setScale(-1, BigDecimal.ROUND_DOWN));
                    
                    if (tpEandIncmSum.compareTo(BigDecimal.ZERO) < 0 ) {
                        
                        tpEandIncmSum = BigDecimal.ZERO;
                    }
   
                    //인적공제인원수 
                    BigDecimal tpHmnDducNumPeplNum = BigDecimal.ZERO; 
                    BigDecimal tpHmnDducSum = BigDecimal.ZERO;  //인적공제금액 
                    
                       //본인 
                    tpHmnDducNumPeplNum = BigDecimal.ZERO;
                     
                    //인적공제금액 
                    tpHmnDducSum = BigDecimal.ZERO;
                    
                    //연금보험료 공제 계산 
                    //연금보험료공제 
                    BigDecimal tpAntyPrmmDducSum = BigDecimal.ZERO; 
                    
                    
                    //공제 대상자에 따른 특별소득공제 계산
                    BigDecimal tpSpclIncmDducEtcSum = BigDecimal.ZERO;
                     
                    //과세표준 
                    BigDecimal tpTxtnStdSum = BigDecimal.ZERO;
                   
                   //산출세율 
                    BigDecimal tpTxtnStdApptnTxrt = BigDecimal.ZERO;
                    //산출세액 
                    BigDecimal tpCalcTxAmnt = BigDecimal.ZERO;
                    
                    tpTxtnStdApptnTxrt = new BigDecimal(6); 
                    tpCalcTxAmnt = (tpEandIncmSum.multiply(new BigDecimal("0.06"))).setScale(-1, BigDecimal.ROUND_DOWN); 
                    
                    //근로소득세액공제 
                    BigDecimal tpEandIncmTxAmnt = BigDecimal.ZERO;
                    
                    tpEandIncmTxAmnt = ((tpEandIncmSum.multiply(new BigDecimal("0.06"))).multiply(new BigDecimal("0.55"))).setScale(-1, BigDecimal.ROUND_DOWN); 
                   
                    //결정세액 
                    BigDecimal tpDeinTxAmnt = BigDecimal.ZERO;
                    
                    if ((tpCalcTxAmnt.subtract(tpEandIncmTxAmnt)).divide((new BigDecimal(payCalculationVo.getDilnlazTotDutyNumDys())), 0).compareTo(new BigDecimal("1000")) >= 0) {
                        tpDeinTxAmnt = tpCalcTxAmnt.subtract(tpEandIncmTxAmnt).setScale(-1,BigDecimal.ROUND_DOWN);
                    } else {
                        tpDeinTxAmnt = BigDecimal.ZERO;
                    }
                    
                    
                    if (tpDeinTxAmnt.compareTo(BigDecimal.ZERO) < 0 ) {
                        
                        tpDeinTxAmnt = BigDecimal.ZERO;
                    }
                    
                    //간이세액
                    BigDecimal tpTxtbSimfTxs = BigDecimal.ZERO;
                    
                    tpTxtbSimfTxs = tpDeinTxAmnt;
                    
                    //지방소득세
                    BigDecimal tpLocIncmTxAmt = BigDecimal.ZERO;
                    tpLocIncmTxAmt = tpDeinTxAmnt.multiply(new BigDecimal("0.10")).setScale(-1,BigDecimal.ROUND_DOWN);
                    
                     
                    //소득세   
                    payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                    payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;
                    payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());
                    payr0302Vo.setPayItemCd("T0010100");
                    payr0302Vo.setPayCd(payCalculationVo.getPayCd()); 
                    payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());
                    payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);
                    payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_04"));
                    payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);
                    payr0302Vo.setPymtDducSum(tpDeinTxAmnt.setScale(-1,BigDecimal.ROUND_DOWN));
                    payr0302Vo.setPayPymtDducPrcsFlag("N");
                    payr0302Vo.setPayReattyAdmntVal("0");
                    payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);
//                  payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//                  payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//                  payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//                  payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//                  payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//                  payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
                    payrCommCalcService.deletePayr0302ToPayr0307T(payr0302Vo);  
                    
                    payrCommCalcService.insertPayr0302(payr0302Vo);
                    
                    //지방소득세   
                    payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                    payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;
                    payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());
                    payr0302Vo.setPayItemCd("T0020100");
                    payr0302Vo.setPayCd(payCalculationVo.getPayCd()); 
                    payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());
                    payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);
                    payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_04"));
                    payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);
                    payr0302Vo.setPymtDducSum(tpLocIncmTxAmt.setScale(-1,BigDecimal.ROUND_DOWN));
                    payr0302Vo.setPayPymtDducPrcsFlag("N");
                    payr0302Vo.setPayReattyAdmntVal("0");
                    payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);
//                  payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//                  payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//                  payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//                  payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//                  payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//                  payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
                    payrCommCalcService.deletePayr0302ToPayr0307T(payr0302Vo);  
                    
                    payrCommCalcService.insertPayr0302(payr0302Vo);   
                  
                    //근로소득간이세액표산출값 
                   payr0305Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                   payr0305Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());                 
                   payr0305Vo.setPayCd(payCalculationVo.getPayCd());                      
                   payr0305Vo.setSystemkey(payCalculationVo.getSystemkey());               
                   payr0305Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());                
                   payr0305Vo.setWorkIncmTxtnSum(tpWorkIncmTxtnSum);            
                   payr0305Vo.setPaySectiCtrSum(BigDecimal.ZERO);             
                   payr0305Vo.setYrlyTotPayQNty(BigDecimal.ZERO);             
                   payr0305Vo.setEandIncmDducSum(eandIncmDducSum );  
                   payr0305Vo.setEandIncmSum(tpEandIncmSum);   
                   payr0305Vo.setHmnDducNumPeplNum(tpHmnDducNumPeplNum);          
                   payr0305Vo.setHmnDducTwenSqntsChdnNum(payCalculationVo.getSuprtFamyNumTwenChDn());    
                   payr0305Vo.setHmnDducSum(tpHmnDducSum);                 
                   payr0305Vo.setAntyPrmmDducSum(tpAntyPrmmDducSum);            
                   payr0305Vo.setSpclIncmDducEtcSum(tpSpclIncmDducEtcSum);         
                   payr0305Vo.setTxtnStdSum(tpTxtnStdSum);                 
                   payr0305Vo.setTxtnStdApptnTxrt(tpTxtnStdApptnTxrt);           
                   payr0305Vo.setTxtnStdPgivDducSum(BigDecimal.ZERO);         
                   payr0305Vo.setCalcTxAmnt(tpCalcTxAmnt);                 
                   payr0305Vo.setEandIncmTxAmnt(tpEandIncmTxAmnt);             
                   payr0305Vo.setDeinTxAmnt(tpDeinTxAmnt);                 
                   payr0305Vo.setTxtbSimfTxs(tpTxtbSimfTxs);  
                   payr0305Vo.setLocIncmTxAmt(tpLocIncmTxAmt);       
                   payr0305Vo.setMnlTxtbSimfTxs(BigDecimal.ZERO);    /** column 수동소득세 : mnlTxtbSimfTxs */
                   payr0305Vo.setMnlLocTxAmt(BigDecimal.ZERO);    /** column 수동지방소득세 : mnlLocTxAmt */
                   payr0305Vo.setMnlTxtbSimfYn("N");    /** column 수동소득세여부 : mnlTxtbSimfYn */
//                 payr0305Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//                 payr0305Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//                 payr0305Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//                 payr0305Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//                 payr0305Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//                 payr0305Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
                   inComeTaxService.deletePayr0305(payr0305Vo);
                   
                   inComeTaxService.insertPayr0305(payr0305Vo);
                   
               return  tpDeinTxAmnt.add(tpLocIncmTxAmt);   
        }
  
	  	
	  	

	  	/**
	  	 * 2017-02-01부터 소득세법계정에 따른 변경 추가 소득세 지방소득세구하는 로직 
	  	 * @param payr0250Vo
	  	 * @param payCalculationVo
	  	 * @param tpWorkIncmTxtnSum
	  	 * @param tpNatPennAmt
	  	 * @return
	  	 * @throws Exception
	  	 */
	  	private BigDecimal funcWorkIncmTxtn2017(HttpServletRequest request,InfcPkgPayr0250VO payr0250Vo,PkgPayrCommCalcVO payCalculationVo,BigDecimal tpWorkIncmTxtnSum ,BigDecimal tpNatPennAmt) throws Exception {
	  	    
		  	  if  (payrCommCalcService == null) { 
	              WebApplicationContext wac = WebApplicationContextUtils.
	                      getRequiredWebApplicationContext( request.getSession().getServletContext());
	  
	              payrCommCalcService = (PayrCommCalcService) wac.getBean("PayrCommCalcService" ); 
	             
	         }
        	  	  
        	          if  (inComeTaxService == null) { 
        	             WebApplicationContext wac = WebApplicationContextUtils.
        	                     getRequiredWebApplicationContext( request.getSession().getServletContext()); 
        	            
        	             inComeTaxService = (InComeTaxService) wac.getBean("InComeTaxService"); 
        	          } 
	          
	  	            InfcPkgPayr0302VO  payr0302Vo = new InfcPkgPayr0302VO(); 
	  	            InfcPkgPayr0305VO  payr0305Vo = new InfcPkgPayr0305VO();
        	  	   //소득세 지방소득세  
                   
                    BigDecimal eandIncmDducSum = BigDecimal.ZERO; //근로소득공제금액 
             
               
                    if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(5000000 / 12)) <= 0) {
                        
                        eandIncmDducSum = tpWorkIncmTxtnSum.multiply(new BigDecimal("0.70")).setScale(0,BigDecimal.ROUND_DOWN) ;
                    
                    } else if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(15000000 / 12)) <= 0) {
                        
                        eandIncmDducSum = (((tpWorkIncmTxtnSum.subtract(new BigDecimal(5000000.0 / 12))).multiply(new BigDecimal("0.40"))).add(new BigDecimal(3500000.0 / 12))).setScale(0,BigDecimal.ROUND_DOWN) ;
                        
                    } else if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(45000000 / 12)) <= 0) {
                          
                        eandIncmDducSum =  (((tpWorkIncmTxtnSum.subtract(new BigDecimal(15000000.0 / 12))).multiply((new BigDecimal("0.15"))))
                                               .add(new BigDecimal(7500000.0 / 12))).setScale(0, BigDecimal.ROUND_DOWN);
                        
                    } else if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(100000000 / 12)) <= 0) {
                       
                        eandIncmDducSum = (((tpWorkIncmTxtnSum.subtract(new BigDecimal(45000000.0 / 12))).multiply(new BigDecimal("0.05"))).add(new BigDecimal(12000000.0 / 12))).setScale(0,BigDecimal.ROUND_DOWN) ;
                        
                    } else {
                        //1억원초과 
                        eandIncmDducSum = (((tpWorkIncmTxtnSum.subtract(new BigDecimal(100000000.0 / 12))).multiply(new BigDecimal("0.02"))).add(new BigDecimal(14750000.0 / 12))).setScale(0,BigDecimal.ROUND_DOWN) ;
                        
                    }
                    
                    //근로소득금액 
                    BigDecimal tpEandIncmSum = BigDecimal.ZERO; 
                    
                    tpEandIncmSum =  tpWorkIncmTxtnSum.subtract(eandIncmDducSum);
                    
                    //인적공제인원수 
                    BigDecimal tpHmnDducNumPeplNum = BigDecimal.ZERO; 
                    BigDecimal tpHmnDducSum = BigDecimal.ZERO;  //인적공제금액 
                    
                       //본인 
                     tpHmnDducNumPeplNum = tpHmnDducNumPeplNum.add(BigDecimal.ONE);
                    //배우자유무 
                    if ("Y".equals(payCalculationVo.getSpueYn())) {
                        tpHmnDducNumPeplNum = tpHmnDducNumPeplNum.add(BigDecimal.ONE);
                    }
                    
                    tpHmnDducNumPeplNum = (tpHmnDducNumPeplNum.add(payCalculationVo.getSuprtFamyNumEtc().add(payCalculationVo.getSuprtFamyNumTwenChDn()))).add(payCalculationVo.getSuprtFamyNumTwenChDn());
                    
                    //인적공제금액 
                    tpHmnDducSum = (tpHmnDducNumPeplNum.multiply(new BigDecimal(1500000.0 / 12))).setScale(0,BigDecimal.ROUND_DOWN) ;
                    
                    //연금보험료 공제 계산 
                    //연금보험료공제 
                    BigDecimal tpAntyPrmmDducSum = BigDecimal.ZERO; 
                   
                    
                    if (payCalculationVo.getNatPennApptnYn().equals("Y")) {                     	 
                        if (tpNatPennAmt.compareTo(BigDecimal.ZERO) <= 0) {
                        	
                        	//20170701기준 국민연금 상하한선 적용 
                        	if ("201706".compareTo(payr0250Vo.getJobYrMnth()) >= 0) {
                            
		                            if (tpWorkIncmTxtnSum.compareTo(new BigDecimal("280000")) <= 0) {
		                                
		                                tpAntyPrmmDducSum = (new BigDecimal("280000")).multiply(new BigDecimal("0.045")).setScale(-1,BigDecimal.ROUND_DOWN);
		                                
		                           } else   if (tpWorkIncmTxtnSum.compareTo(new BigDecimal("4340000")) >= 0) {
		                               
		                                tpAntyPrmmDducSum = (new BigDecimal("4340000")).multiply(new BigDecimal("0.045")).setScale(-1,BigDecimal.ROUND_DOWN);
		                               
		                           } else {
		                               tpAntyPrmmDducSum = tpNatPennAmt;
		                           }
		                            
                        	} else {
                        		
                        		   if (tpWorkIncmTxtnSum.compareTo(new BigDecimal("290000")) <= 0) {
		                                
		                                tpAntyPrmmDducSum = (new BigDecimal("290000")).multiply(new BigDecimal("0.045")).setScale(-1,BigDecimal.ROUND_DOWN);
		                                
		                           } else   if (tpWorkIncmTxtnSum.compareTo(new BigDecimal("4490000")) >= 0) {
		                               
		                                tpAntyPrmmDducSum = (new BigDecimal("4490000")).multiply(new BigDecimal("0.045")).setScale(-1,BigDecimal.ROUND_DOWN);
		                               
		                           } else {
		                               tpAntyPrmmDducSum = tpNatPennAmt;
		                           } 
                        	}
                        } else {
                            tpAntyPrmmDducSum = tpNatPennAmt; 
                        } 
                    }  else {
                    	tpAntyPrmmDducSum = tpNatPennAmt; 
                    }
                    
                    
                    //공제 대상자에 따른 특별소득공제 계산
                    BigDecimal tpSpclIncmDducEtcSum = BigDecimal.ZERO;
                    BigDecimal tp40EtcSum = BigDecimal.ZERO;
                    
                    if (tpHmnDducNumPeplNum.compareTo(new BigDecimal(2)) > 0) {
                        //3명이상인경우 
                        
                        tp40EtcSum = ((tpWorkIncmTxtnSum.subtract(new BigDecimal(40000000.0 / 12))).multiply(new BigDecimal("0.04")));
                        
                        if (tp40EtcSum.compareTo(BigDecimal.ZERO) < 0) {
                            tp40EtcSum = BigDecimal.ZERO;
                        }
                        
                        if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(30000000 / 12)) <= 0) {
                            
                           tpSpclIncmDducEtcSum = (tpWorkIncmTxtnSum.multiply(new BigDecimal("0.07"))).add(new BigDecimal(5000000.0 / 12)).add(tp40EtcSum) ; 
                           
                        } else if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(45000000 / 12)) <= 0) {
                            
                            tpSpclIncmDducEtcSum = ((tpWorkIncmTxtnSum.multiply(new BigDecimal("0.07"))).add(new BigDecimal(5000000.0 / 12))).subtract(
                                    ((tpWorkIncmTxtnSum.subtract(new BigDecimal(30000000.0 / 12))).multiply(new BigDecimal("0.05"))))
                                    .add(tp40EtcSum) ;
                            
                        } else if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(70000000 / 12)) <= 0) {
                            
                            tpSpclIncmDducEtcSum = ((tpWorkIncmTxtnSum.multiply(new BigDecimal("0.05"))).add(new BigDecimal(5000000.0 / 12))).add(tp40EtcSum) ;
                            
                        } else if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(120000000 / 12)) <= 0) {
                           
                            tpSpclIncmDducEtcSum = ((tpWorkIncmTxtnSum.multiply(new BigDecimal("0.03"))).add(new BigDecimal(5000000.0 / 12))).add(tp40EtcSum) ;
                            
                        } 
                        
                    } else if (tpHmnDducNumPeplNum.compareTo(new BigDecimal(2)) == 0) {
                        //2명인경우 
                           if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(30000000 / 12)) <= 0) {
                            
                               tpSpclIncmDducEtcSum = (tpWorkIncmTxtnSum.multiply(new BigDecimal("0.04"))).add(new BigDecimal(3600000.0 / 12)) ;
                            
                            } else if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(45000000 / 12)) <= 0) {
                                
                                tpSpclIncmDducEtcSum = ((tpWorkIncmTxtnSum.multiply(new BigDecimal("0.04"))).add(new BigDecimal(3600000.0 / 12))).subtract(
                                        ((tpWorkIncmTxtnSum.subtract(new BigDecimal(30000000.0 / 12))).multiply(new BigDecimal("0.05")))) ;
                                
                            } else if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(70000000 / 12)) <= 0) {
                                
                                tpSpclIncmDducEtcSum = ((tpWorkIncmTxtnSum.multiply(new BigDecimal("0.02"))).add(new BigDecimal(3600000.0 / 12))) ;
                                
                            } else if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(120000000 / 12)) <= 0) {
                               
                                tpSpclIncmDducEtcSum = ((tpWorkIncmTxtnSum.multiply(new BigDecimal("0.01"))).add(new BigDecimal(3600000.0 / 12))) ;
                                
                            } 
                           
                    } else if (tpHmnDducNumPeplNum.compareTo(new BigDecimal(1)) == 0) {
                        //1명인경우 
                           if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(30000000 / 12)) <= 0) {
                            
                               tpSpclIncmDducEtcSum = (tpWorkIncmTxtnSum.multiply(new BigDecimal("0.04"))).add(new BigDecimal(3100000.0 / 12)) ;
                            
                            } else if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(45000000 / 12)) <= 0) {
                                
                                tpSpclIncmDducEtcSum = ((tpWorkIncmTxtnSum.multiply(new BigDecimal("0.04"))).add(new BigDecimal(3100000.0 / 12))).subtract(
                                        ((tpWorkIncmTxtnSum.subtract(new BigDecimal(30000000.0 / 12))).multiply(new BigDecimal("0.05")))) ;
                                
                            } else if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(70000000 / 12)) <= 0) {
                                
                                tpSpclIncmDducEtcSum = ((tpWorkIncmTxtnSum.multiply(new BigDecimal("0.015"))).add(new BigDecimal(3100000.0 / 12))) ;
                                
                            } else if (tpWorkIncmTxtnSum.compareTo(new BigDecimal(120000000 / 12)) <= 0) {
                               
                                tpSpclIncmDducEtcSum = ((tpWorkIncmTxtnSum.multiply(new BigDecimal("0.005"))).add(new BigDecimal(3100000.0 / 12))) ;
                                
                            } 
                            
                    }  else {
                    	//에러처리 
                    }
                    
                    //과세표준 
                    BigDecimal tpTxtnStdSum = BigDecimal.ZERO;
                   //과세표준 
                    tpTxtnStdSum = (tpEandIncmSum.subtract(tpHmnDducSum).subtract(tpAntyPrmmDducSum).subtract(tpSpclIncmDducEtcSum)) ;
                    
                    /****************************************과세표준이 0 이하인경우 ************************************/
                    if (tpTxtnStdSum.compareTo(BigDecimal.ZERO) < 0) {
                    	tpTxtnStdSum = BigDecimal.ZERO;
                    } 
                    /****************************************과세표준이 0 이하인경우 ************************************/
                   //산출세율 
                    BigDecimal tpTxtnStdApptnTxrt = BigDecimal.ZERO;
                    //산출세액 
                    BigDecimal tpCalcTxAmnt = BigDecimal.ZERO;
                    
                    BigDecimal tpCalcOvrAmnt = BigDecimal.ZERO;
                    
                    if (tpTxtnStdSum.compareTo(new BigDecimal(12000000 / 12)) <= 0) {
                        
                           tpTxtnStdApptnTxrt = new BigDecimal(6); 
                           tpCalcTxAmnt = (tpTxtnStdSum.multiply(new BigDecimal("0.06"))).setScale(0,BigDecimal.ROUND_DOWN) ;
                        
                    } else if (tpTxtnStdSum.compareTo(new BigDecimal(46000000 / 12)) <= 0) {
                        
                        tpTxtnStdApptnTxrt = new BigDecimal(15);
                        
                        tpCalcOvrAmnt = tpTxtnStdSum.subtract(new BigDecimal(12000000.0 / 12));
                        
                        if (tpCalcOvrAmnt.compareTo(BigDecimal.ZERO) <= 0) {
                            tpCalcOvrAmnt = BigDecimal.ZERO;
                        }
                    
                        tpCalcTxAmnt = ((new BigDecimal(720000.0 / 12)).add((tpCalcOvrAmnt.multiply(new BigDecimal("0.15"))).setScale(0,BigDecimal.ROUND_DOWN))) ;
                        
                    } else if (tpTxtnStdSum.compareTo(new BigDecimal(88000000 / 12)) <= 0) {
                        
                        tpTxtnStdApptnTxrt = new BigDecimal(24);
                        
                        tpCalcOvrAmnt = tpTxtnStdSum.subtract(new BigDecimal(46000000.0 / 12));
                        
                        if (tpCalcOvrAmnt.compareTo(BigDecimal.ZERO) <= 0) {
                            tpCalcOvrAmnt = BigDecimal.ZERO;
                        }
                        
                        tpCalcTxAmnt = ((new BigDecimal(5820000.0 / 12)).add((tpCalcOvrAmnt.multiply(new BigDecimal("0.24"))).setScale(0,BigDecimal.ROUND_DOWN))) ;
                        
                    } else if (tpTxtnStdSum.compareTo(new BigDecimal(150000000 / 12)) <= 0) {
                       
                        tpTxtnStdApptnTxrt = new BigDecimal(35);
                         
                        tpCalcOvrAmnt = tpTxtnStdSum.subtract(new BigDecimal(88000000.0 / 12));
                        
                        if (tpCalcOvrAmnt.compareTo(BigDecimal.ZERO) <= 0) {
                            tpCalcOvrAmnt = BigDecimal.ZERO;
                        }
                        
                        tpCalcTxAmnt = ((new BigDecimal(15900000.0 / 12)).add((tpCalcOvrAmnt.multiply(new BigDecimal("0.35"))).setScale(0,BigDecimal.ROUND_DOWN))) ;
                        
                    } else {
                        
                        tpTxtnStdApptnTxrt = new BigDecimal(38);
                        
                        tpCalcOvrAmnt = tpTxtnStdSum.subtract(new BigDecimal(150000000.0 / 12));
                        
                        if (tpCalcOvrAmnt.compareTo(BigDecimal.ZERO) <= 0) {
                            tpCalcOvrAmnt = BigDecimal.ZERO;
                        }
                        
                        tpCalcTxAmnt = ((new BigDecimal(37600000.0 / 12)).add((tpCalcOvrAmnt.multiply(new BigDecimal("0.38"))).setScale(0,BigDecimal.ROUND_DOWN))) ;
                    }
                    
                    //근로소득세액공제 
                    BigDecimal tpEandIncmTxAmnt = BigDecimal.ZERO;
                    
                    if (tpCalcTxAmnt.compareTo(new BigDecimal(500000 / 12)) <= 0) {
                        tpEandIncmTxAmnt = (tpCalcTxAmnt.multiply(new BigDecimal("0.55"))).setScale(-1,BigDecimal.ROUND_DOWN) ; 
                    } else {
                        //공제한도금액 수정 
                       //   간이세액표 상 근로소득세액공제 한도
                       // • 총급여액이 5천 500만원 이하인 경우：66만원 / 12  4583333.333  / 55000  
                       // • 총급여액이 5천 500만원 초과 7천만원 이하인 경우：63만원 /12  5833333.333    / 52500
                       // • 총급여액이 7천만원 초과하는 경우：50만원 / 12  5833333.333       41666.666
                        BigDecimal tmEandIncmTxAm = BigDecimal.ZERO;
                       
                        tmEandIncmTxAm =  (((tpCalcTxAmnt.subtract((new BigDecimal("41666")))).multiply(new BigDecimal("0.30"))).add((new BigDecimal(275000.0/12)))); 
                       
                        if (tpWorkIncmTxtnSum.compareTo(new BigDecimal("4583333")) <= 0) { 
                          
                            if (tmEandIncmTxAm.compareTo(new BigDecimal("55000")) <= 0) {
                                tpEandIncmTxAmnt = tmEandIncmTxAm;
                            } else {
                                tpEandIncmTxAmnt = (new BigDecimal("55000")); 
                               
                            } 
                            
                        } else if (tpWorkIncmTxtnSum.compareTo(new BigDecimal("5833333")) <= 0) {
                            
                            if (tmEandIncmTxAm.compareTo(new BigDecimal("52500")) <= 0) {
                                tpEandIncmTxAmnt = tmEandIncmTxAm;
                            } else {
                                tpEandIncmTxAmnt = (new BigDecimal("52500")); 
                               
                            } 
                            
                        } else {
                            
                            if (tmEandIncmTxAm.compareTo(new BigDecimal("41666")) <= 0) {
                                tpEandIncmTxAmnt = tmEandIncmTxAm;
                            } else {
                                tpEandIncmTxAmnt = (new BigDecimal("41666"));
                            }  
                        } 
                          
                    }
                    //결정세액 
                    BigDecimal tpDeinTxAmnt = BigDecimal.ZERO;
                    
                    tpDeinTxAmnt = (tpCalcTxAmnt.setScale(-1,BigDecimal.ROUND_DOWN)).subtract(tpEandIncmTxAmnt.setScale(-1,BigDecimal.ROUND_DOWN));
                    
                    if (tpDeinTxAmnt.compareTo(BigDecimal.ZERO) < 0 ) {
                        
                        tpDeinTxAmnt = BigDecimal.ZERO;
                    }
                    
                    
                    //간이세액
                    BigDecimal tpTxtbSimfTxs = BigDecimal.ZERO;
                    
                    tpTxtbSimfTxs = tpDeinTxAmnt;
                    
                    
                    
                    /** column 실소득세액 : turtyIncmTxQnty */
                    BigDecimal tpTurtyIncmTxQnty = BigDecimal.ZERO;

                    /********************************************************************
                     * 소득원천세액 본인세액조정 +++++++++++++++++++++++++++++++++++++++++++++++
                     ********************************************************************/
                     tpTurtyIncmTxQnty = tpDeinTxAmnt; 
                    
                     if (!ExtermsProps.getProps("PAYR_TAX_B0290020").equals(MSFSharedUtils.allowNulls(payCalculationVo.getAddIncmTxApptnRtoCd()))) {
                    	 if (MSFSharedUtils.allowNulls(payCalculationVo.getAddIncmTxApptnYrMnth()).compareTo(payr0250Vo.getJobYrMnth().replace(".","")) <= 0) {
                             
                    		 tpTurtyIncmTxQnty = tpDeinTxAmnt.multiply((payCalculationVo.getAddIncmTxApptnRto().divide(new BigDecimal("100"), 5, BigDecimal.ROUND_DOWN))).setScale(-1,BigDecimal.ROUND_DOWN) ;
                    	 } 
                     }  
                    
                    /********************************************************************
                     * 소득원천세액 본인세액조정 +++++++++++++++++++++++++++++++++++++++++++++++ 
                     ********************************************************************/ 
                    
                    //지방소득세
                    BigDecimal tpLocIncmTxAmt = BigDecimal.ZERO;
                    tpLocIncmTxAmt = tpTurtyIncmTxQnty.multiply(new BigDecimal("0.10")).setScale(-1,BigDecimal.ROUND_DOWN);
                    
                     
                    //소득세   
                    payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                    payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;
                    payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());
                    payr0302Vo.setPayItemCd("T0010100");
                    payr0302Vo.setPayCd(payCalculationVo.getPayCd()); 
                    payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());
                    payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);
                    payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_04"));
                    payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);
                    payr0302Vo.setPymtDducSum(tpTurtyIncmTxQnty);
                    payr0302Vo.setPayPymtDducPrcsFlag("N");
                    payr0302Vo.setPayReattyAdmntVal("0");
                    payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);
//                  payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//                  payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//                  payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//                  payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//                  payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//                  payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */   
                    payrCommCalcService.deletePayr0302ToPayr0307T(payr0302Vo);  
                    
                    payrCommCalcService.insertPayr0302(payr0302Vo);
                    
                    
                    //지방소득세   
                    payr0302Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                    payr0302Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth()) ;
                    payr0302Vo.setSystemkey(payCalculationVo.getSystemkey());
                    payr0302Vo.setPayItemCd("T0020100");
                    payr0302Vo.setPayCd(payCalculationVo.getPayCd()); 
                    payr0302Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());
                    payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);
                    payr0302Vo.setPymtDducDivCd(ExtermsProps.getProps("PYMT_DDUC_DIV_CD_04"));
                    payr0302Vo.setPymtDducFreeDtySum(BigDecimal.ZERO);
                    payr0302Vo.setPymtDducSum(tpLocIncmTxAmt);
                    payr0302Vo.setPayPymtDducPrcsFlag("N");
                    payr0302Vo.setPayReattyAdmntVal("0");
                    payr0302Vo.setPymtDducTxtnAmnt(BigDecimal.ZERO);
//                  payr0302Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//                  payr0302Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//                  payr0302Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//                  payr0302Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//                  payr0302Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//                  payr0302Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
                    payrCommCalcService.deletePayr0302ToPayr0307T(payr0302Vo);  
                    
                    payrCommCalcService.insertPayr0302(payr0302Vo);  
                     
                  
                   //근로소득간이세액표산출값 
                   payr0305Vo.setDpobCd(payr0250Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                   payr0305Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth());                 
                   payr0305Vo.setPayCd(payCalculationVo.getPayCd());                      
                   payr0305Vo.setSystemkey(payCalculationVo.getSystemkey());               
                   payr0305Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());                
                   payr0305Vo.setWorkIncmTxtnSum(tpWorkIncmTxtnSum);            
                   payr0305Vo.setPaySectiCtrSum(BigDecimal.ZERO);             
                   payr0305Vo.setYrlyTotPayQNty(BigDecimal.ZERO);             
                   payr0305Vo.setEandIncmDducSum(eandIncmDducSum.setScale(-1,BigDecimal.ROUND_DOWN));  
                   payr0305Vo.setEandIncmSum(tpEandIncmSum.setScale(-1,BigDecimal.ROUND_DOWN));   
                   payr0305Vo.setHmnDducNumPeplNum(tpHmnDducNumPeplNum);          
                   payr0305Vo.setHmnDducTwenSqntsChdnNum(payCalculationVo.getSuprtFamyNumTwenChDn());    
                   payr0305Vo.setHmnDducSum(tpHmnDducSum.setScale(-1,BigDecimal.ROUND_DOWN));                 
                   payr0305Vo.setAntyPrmmDducSum(tpAntyPrmmDducSum.setScale(-1,BigDecimal.ROUND_DOWN));            
                   payr0305Vo.setSpclIncmDducEtcSum(tpSpclIncmDducEtcSum.setScale(-1,BigDecimal.ROUND_DOWN));         
                   payr0305Vo.setTxtnStdSum(tpTxtnStdSum.setScale(-1,BigDecimal.ROUND_DOWN));                 
                   payr0305Vo.setTxtnStdApptnTxrt(tpTxtnStdApptnTxrt);           
                   payr0305Vo.setTxtnStdPgivDducSum(BigDecimal.ZERO);         
                   payr0305Vo.setCalcTxAmnt(tpCalcTxAmnt.setScale(-1,BigDecimal.ROUND_DOWN));           
                   payr0305Vo.setEandIncmTxAmnt(tpEandIncmTxAmnt.setScale(-1,BigDecimal.ROUND_DOWN));                
                   payr0305Vo.setDeinTxAmnt(tpDeinTxAmnt.setScale(-1,BigDecimal.ROUND_DOWN));                 
                   payr0305Vo.setTxtbSimfTxs(tpTxtbSimfTxs.setScale(-1,BigDecimal.ROUND_DOWN));  
                   payr0305Vo.setLocIncmTxAmt(tpLocIncmTxAmt.setScale(-1,BigDecimal.ROUND_DOWN));    
                   payr0305Vo.setAddIncmTxRate(payCalculationVo.getAddIncmTxApptnRto());    /** column 추가소득세율 : addIncmTxRate */
                   payr0305Vo.setTurtyIncmTxQnty(tpTurtyIncmTxQnty.setScale(-1,BigDecimal.ROUND_DOWN));    /** column 실소득세액 : turtyIncmTxQnty */
                   
                   payr0305Vo.setMnlTxtbSimfTxs(BigDecimal.ZERO);    /** column 수동소득세 : mnlTxtbSimfTxs */
                   payr0305Vo.setMnlLocTxAmt(BigDecimal.ZERO);    /** column 수동지방소득세 : mnlLocTxAmt */
                   payr0305Vo.setMnlTxtbSimfYn("N");    /** column 수동소득세여부 : mnlTxtbSimfYn */
                   
//                 payr0305Vo.setKybdr(payr0302Vo.getKybdr());    /** column 입력자 : kybdr */
//                 payr0305Vo.setInptDt(payr0302Vo.getInptDt());    /** column 입력일자 : inptDt */
//                 payr0305Vo.setInptAddr(payr0302Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//                 payr0305Vo.setIsmt(payr0302Vo.getIsmt());    /** column 수정자 : ismt */
//                 payr0305Vo.setRevnDt(payr0302Vo.getRevnDt());    /** column 수정일자 : revnDt */
//                 payr0305Vo.setRevnAddr(payr0302Vo.getRevnAddr());    /** column 수정주소 : revnAddr */ 
                   inComeTaxService.deletePayr0305(payr0305Vo);
                   
                   inComeTaxService.insertPayr0305(payr0305Vo);
                   
               return  tpTurtyIncmTxQnty.add(tpLocIncmTxAmt);   
	  	}
	  	

}
