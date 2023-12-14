package com.app.smrmf.props;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.any.smrmf.utils.BeanFinder;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.props.service.PropMstr010100Service;
import com.app.smrmf.sysm.server.service.vo.SysIfMstr010100SrhVO;
import com.app.smrmf.sysm.server.service.vo.SysIfMstr010100VO;

/**
 *  공통으로 쓰이는  변수 및 설정값을 가지고 있는 패키지 
 * @author leehs
 *
 */
public class ExtermsProps { 
	
    /** log */
    private static Logger logger = LoggerFactory.getLogger(ExtermsProps.class); 

    private static ExtermsProps oneExtProps;   

    private static  List<SysIfMstr010100VO>  paygenProps;
     
    
	
   //TODO 세션정보에 데이타를 넣어야함.
   //연가보상일수 산정비율 출근 80%이상자
   public static  final String  PSNL_YRDY_RATE = "80"; 
    //공통 근태일근무시간 8시간 
   public static  final String PAYR_BASS_WKTM_201401_01 = "8.0";     //기본근무시간  
    //무기계약직 - 월통상일급 계산시간 226시간 
   // public static  final String PAYR_BASS_WKTM_201401_02 = "226";     //시간  
    //무기계약직 - 월통상시급 계산시간 226시간 
   // public static  final String PAYR_BASS_WKTM_201401_03 = "226";     //시간  
    //시간외근무 기본근무시간 
    public static  final String PAYR_OVER_WKTM_201401  = "10.0";   //시간외 기본근무시간.기본근무시간  한달기준 
    //주소정근로시간 
    public static final String USR_WEEK_WORK_TIME = "40";
    //월통상임금 - 기본급,정액수당,복리후생비
    //월통상임금(상여금포함) 
	
    
  //급여권한에 따른 근로자 불러오기 위해 셋팅 
  	//직종
  	public static final String PAY_TYPOCCUCD_01 = "A0410112";  //환경미화원 
  	
  	//호봉등급 
  	public static final String PAY_PYSPGRDECD_01 = "A0060000";  //환경미화원 
  	
  	
    
    //퇴직정산급여항목구분코드
    public static final String REMT_R0020010    = "R0020010";  //기본급여및제수당
    public static final String REMT_R0020020    = "R0020020";  //후생복지비
     
 	public static final String REMT_C9050100 = "12";    // 가족수당 개월수로 해서 값가져오기 
	public static final String REMT_C9110100 = "12";    // 명절휴가비 
	public static final String REMT_C9410600 = "12";    // 연가보상비
		

    
    /**
     * 별도관리되는 부분에 대한 처리 수당
     */
   
	//가족수당 가산자녀_이상
	//급여채권압류최저압류금지금액
	//급여채권압류계산적용월금액
	
	//휴직구분코드
	//휴직급여지급개월수 
	//급여항목그룹코드
	//휴직급여지급율 
	
  
    
	@Resource(name = "PropMstr010100Service")
    private static PropMstr010100Service propMstrService; 
 	
	
   private ExtermsProps() {    
	  
  } 
 
  public static ExtermsProps getInstance() {
      if(oneExtProps==null) {
      	oneExtProps = new ExtermsProps();
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
	 paygenProps = new ArrayList<SysIfMstr010100VO>();
	 
	 List<SysIfMstr010100VO> paygenList;
	 int rtnProp = -1; 
	 try {
		 
		 propMstrService = (PropMstr010100Service)BeanFinder.getBean("PropMstr010100Service");
		 
		 paygenList =  propMstrService.selectPropsMstr010100List(mstr010100SrhVo);
	
		 if (paygenList.size() <= 0) {
			 return rtnProp;
		 } else { 
			
			 paygenProps =  paygenList;
			//   HttpSession httpSession = RemoteServiceUtil.getThreadLocalSession();   
		    //   httpSession.setAttribute("paygenProps", paygenProps);    
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
	private static List<SysIfMstr010100VO> getPaygenProps() {
		
	//	HttpSession httpSession = RemoteServiceUtil.getThreadLocalSession();  
	//	paygenProps =  (List<HashMap<String, String>>) httpSession.getAttribute("paygenProps");
	 
		return paygenProps;
	}
	
	/**
	 * Comment : 설정변수  
	 *@fn void setPaygenProps(HashMap<String,String> paygenProps)
	 *@brief date:2017 2017. 11. 1. user:atres
	 *@param paygenProps the paygenProps to set
	 */
	private static void setPaygenProps(List<SysIfMstr010100VO> paygenProps) {
		ExtermsProps.paygenProps = paygenProps;
	} 
	
	
	/**
	 * Comment : 설정변수 값 
	 * @fn String getProps()
	 * @brief date:2017 2017. 11. 1. user:atres
	 * @return the String get
	 */
	public static String getProps(String keyVal)  throws MSFException {
		String rtnKeyValue = "";
		 List<SysIfMstr010100VO>  rtnPaygenProps = new ArrayList<SysIfMstr010100VO>();
		  try {
			  
			    rtnPaygenProps = getPaygenProps();
			    
				 
			    for ( int i=0 ; i<rtnPaygenProps.size() ; i++ ) {
			    	
			    	SysIfMstr010100VO mstr010100Vo = new SysIfMstr010100VO(); 
			    	mstr010100Vo = rtnPaygenProps.get(i);
			    	if (keyVal.equals(mstr010100Vo.getSysVarNm())) {
			    		rtnKeyValue = mstr010100Vo.getSysVarVal();
			    		break;
			    	}
			    	 
			    }
			    
		    } catch (Exception ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}	    
		
		return rtnKeyValue;
	}	

}
