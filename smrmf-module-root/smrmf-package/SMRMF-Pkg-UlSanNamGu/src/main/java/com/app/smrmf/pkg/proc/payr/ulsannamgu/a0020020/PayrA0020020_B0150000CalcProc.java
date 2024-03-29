package com.app.smrmf.pkg.proc.payr.ulsannamgu.a0020020;

 
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.pkg.insr.insurance.PkgInsrController;
import com.app.smrmf.pkg.payr.income.tax.PayrTaxController;
import com.app.smrmf.pkg.payr.payrcalc.service.PayrCommCalcService;
import com.app.smrmf.pkg.proc.payr.pay.calculation.service.PayCalculationService;
import com.app.smrmf.pkg.proc.payr.pysplogsvcyrnum.PyspLogSvcYrNumService;
/**
 * 각 급여 관련 실제 로직을 처리 하는 부분
 */
@Controller 
public class PayrA0020020_B0150000CalcProc  extends AbstractCustomServiceImpl {
	 

	private static final Logger logger = LoggerFactory.getLogger(PayrA0020020_B0150000CalcProc.class);
	
	private PayrTaxController payrTaxCtl; 
	
	private PkgInsrController pkgInsrCtl; 
	
	//급여계산  
	@Autowired
    @Resource(name = "PayCalculationService")
    protected PayCalculationService payCalculationService;
	

	 //급여관련 공통 패키지 처리 
	@Autowired
   @Resource(name = "PayrCommCalcService")
   protected PayrCommCalcService payrCommCalcService;
	 //근속년수 
    @Autowired
    @Resource(name = "PyspLogSvcYrNumService")
    protected PyspLogSvcYrNumService pyspLogSvcYrNumService; 
    
    /*
     * 생성자 
     */
     public PayrA0020020_B0150000CalcProc () {
     	
         
     }
    
	  	 
}