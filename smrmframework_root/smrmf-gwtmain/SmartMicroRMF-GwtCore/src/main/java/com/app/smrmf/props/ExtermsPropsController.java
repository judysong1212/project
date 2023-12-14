package com.app.smrmf.props;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.any.smrmf.utils.BeanFinder;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.props.service.PropMstr010100Service;
import com.app.smrmf.sysm.server.service.vo.SysIfMstr010100SrhVO;
import com.app.smrmf.sysm.server.service.vo.SysIfMstr010100VO;

/**
 *  공통으로 쓰이는  변수 및 설정값을 가지고 있는 패키지 
 * @author leehs
 *
 */
public class ExtermsPropsController { 
	
    /** log */
    private static Logger logger = LoggerFactory.getLogger(ExtermsPropsController.class); 

    private static ExtermsPropsController oneExtProps;   

    private static  List<HashMap<String, String>>  paygenProps;
     
     
  
    /** LoginService */
	@Resource(name = "PropMstr010100Service")
    private static PropMstr010100Service propMstrService; 
 	
	
   private ExtermsPropsController() {    
	  
  } 
 
 public static ExtermsPropsController getInstance() {
      if(oneExtProps==null) {
      	oneExtProps = new ExtermsPropsController();
      }
      return oneExtProps;
  } 
  
 /**
  * 
  * <pre>
  * 1. 개요 : 시스템 설정정보를 가지고 온다.  
  * 2. 처리내용 : 
  * </pre>
  * @Method Name : extermsPropsConfig
  * @date : 2017. 11. 1.
  * @author : atres
  * @history : 
  *	-----------------------------------------------------------------------
  *	변경일				작성자						변경내용  
  *	----------- ------------------- ---------------------------------------
  *	2017. 11. 1.		atres				최초 작성 
  *	-----------------------------------------------------------------------
  *
  */
 private static int extermsPropsConfig() {
	
	 SysIfMstr010100SrhVO mstr010100SrhVo = new SysIfMstr010100SrhVO();
	 SysIfMstr010100VO mstr010100Vo = new SysIfMstr010100VO(); 
	 paygenProps = new ArrayList<HashMap<String, String>>();
	 
	 List paygenList;
	 int rtnProp = -1; 
	 try {
		 
		 propMstrService = (PropMstr010100Service)BeanFinder.getBean("PropMstr010100Service");
		 
		 paygenList = propMstrService.selectPropsMstr010100List(mstr010100SrhVo);
	
		 if (paygenList.size() <= 0) {
			 return rtnProp;
		 } else {
			 
			 Iterator<Map<String, Object>> iter = paygenList.iterator();
	      
			 
			 while ( iter.hasNext() ) {
				 
				 HashMap<String, String>  hmResult = new  HashMap<String, String>();
				 Map<String, Object> map01 = (Map<String, Object>) iter.next();
				 
				 hmResult.put(MSFSharedUtils.allowNulls(map01.get("sysVarNm")),MSFSharedUtils.allowNulls(map01.get("sysVarVal")));  
	             paygenProps.add(hmResult) ;
			 }
			// System.out.println("data------- : " + paygenProps.toString());
			 rtnProp = 200;
		 }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		 e.printStackTrace();
		 return rtnProp;
	}
	 
	 return rtnProp;
}
 
 
 public static String PropsInitialize()  throws MSFException {    
	 
	   String rtnResult = "-1";
	   int rtnProps = -1;
	  try {
			//사용시 반드시 초기화 선언 추가 
		    oneExtProps = getInstance();    
		    rtnProps =  extermsPropsConfig();
		    
		    if (!(rtnProps <= 0)) {
		    	rtnResult = "200";	
		    }  
		    
	    } catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}	  
	   
	  return rtnResult;
}

	/**
	 * Comment : 설정변수  
	 * @fn HashMap<String,String> getPaygenProps()
	 * @brief date:2017 2017. 11. 1. user:atres
	 * @return the paygenProps get
	 */
	private static List<HashMap<String, String>> getPaygenProps() {
		return paygenProps;
	}
	
	/**
	 * Comment : 설정변수  
	 *@fn void setPaygenProps(HashMap<String,String> paygenProps)
	 *@brief date:2017 2017. 11. 1. user:atres
	 *@param paygenProps the paygenProps to set
	 */
	private static void setPaygenProps(List<HashMap<String, String>> paygenProps) {
		ExtermsPropsController.paygenProps = paygenProps;
	} 
	
	
	/**
	 * Comment : 설정변수 값 
	 * @fn String getProps()
	 * @brief date:2017 2017. 11. 1. user:atres
	 * @return the String get
	 */
	public static String getProps(String keyVal) {
		String rtnKeyValue = "";
		
	    for ( int i=0 ; i<getPaygenProps().size() ; i++ ) {
	    	
	    	//HashMap<String, String>  keyResult = new  HashMap<String, String>();
	    	 System.out.println("data------- : " + getPaygenProps().get(i).toString());
	    	 System.out.println("data------- : " + getPaygenProps().get(i).values());
	    	rtnKeyValue = getPaygenProps().get(i).get(keyVal);
	    	
	    }
		
		return rtnKeyValue;
	}	

}
