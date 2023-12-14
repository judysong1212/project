package com.app.smrmf.core.msfmainapp.server.utils;

import java.io.InputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Blob;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
 
import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.utils.SmrmfUtils;
import org.msf.utils.TimingInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ListColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFErrorMessage;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.server.service.dao.LogHistoryServiceDAO;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.sysm.server.vo.SysIfHist0100VO;
import com.app.smrmf.sysm.server.vo.SysIfHist0200VO;
import com.app.smrmf.sysm.server.vo.SysIfHist0300VO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0100VO;

public class MSFLogHistoryUtils {

    private static final Logger logger = LoggerFactory.getLogger(MSFLogHistoryUtils.class);
  
    //사용자 접속구분 
    private static  String PAYGEN_CONN_APP =  "APP"; 
    private static  String PAYGEN_CONN_WEB =  "WEB"; 
    
    @Autowired
	@Resource(name="LogHistoryServiceDAO")  
	private static LogHistoryServiceDAO logHisServDAO; 
	
    
    @Autowired
	public static void tracerLoginUserActivity(
            MSFSysm0100BM user,
            String currentMethod,
            String objectName,
            String typeActivity){
    	 
    	HashMap<String, String> msfGlobals = MSFServerUtils.getLocalidedMessages(RemoteServiceUtil.getThreadLocalConfig(), RemoteServiceUtil.getThreadLocalRequest()); 

        boolean traceEnabled = "true".equals(msfGlobals.get("PayGen.TraceUserActivity"));   //Globals.TRACE_USER_ACTIVITY
        if ( !traceEnabled ) return;
//        Date date = null;
        long time = System.currentTimeMillis();  
        HttpSession httpSession =  RemoteServiceUtil.getThreadLocalSession(); 
        
        SysIfHist0100VO  hist0100Vo = new SysIfHist0100VO();
        SysIfHist0200VO  hist0200Vo = new SysIfHist0200VO();
        
        TimingInfo millisBeginMethod = SmrmfUtils.startTiming(logger);
 
        try {
 
        	  if  (logHisServDAO == null) { 
                  WebApplicationContext wac = WebApplicationContextUtils.
                          getRequiredWebApplicationContext(  RemoteServiceUtil.getThreadLocalRequest().getSession().getServletContext());
      
                  logHisServDAO = (LogHistoryServiceDAO) wac.getBean("LogHistoryServiceDAO"); 
                 
             }  
        	   
        	  hist0100Vo.setDpobCd(user.getDpobCd());    		/** column 사업장코드 : dpobCd */
        	  hist0100Vo.setUsrConnectYr(SmrmfUtils.getStringFromDate( new Date(time),"yyyy"));    /** column 사용자접속년도 : usrConnectYr */
        	  hist0100Vo.setUsrId(user.getUsrId());    			/** column 사용자아이디 : usrId */
        	  hist0100Vo.setUsrConnectSeilNum(BigDecimal.ZERO);	/** column 사용자접속일련번호 : usrConnectSeilNum */
        	  hist0100Vo.setUsrConnectDivCd("APP");    			/** column 사용자접속구분코드 : usrConnectDivCd */
        	  hist0100Vo.setDeptCd(user.getDeptCd());    		/** column 부서코드 : deptCd */
        	  hist0100Vo.setUsrDivCd(user.getUsrDivCd());    	/** column 사용자구분코드 : usrDivCd */
        	  hist0100Vo.setUsrNm(user.getUsrNm());    			/** column 사용자성명 : usrNm */
        	  
        	  
        	  if (!"LOGOUT".equals(typeActivity)) {
         		 // date = new Date(httpSession.getCreationTime()); 
            	  hist0100Vo.setUsrConnectBgnnDtntm(SmrmfUtils.getStringFromDate( new Date(time),"yyyyMMddHHmmssSSS"));	/** column 사용자접속시작일시 : usrConnectBgnnDtntm */
            	  
        	  } 
        	  
        	 
        	 // date = new Date(httpSession.getLastAccessedTime());
        	  hist0100Vo.setUsrConnectEndDtntm(SmrmfUtils.getStringFromDate( new Date(time),"yyyyMMddHHmmssSSS"));    	/** column 사용자접속종료일시 : usrConnectEndDtntm */
        	  
        	  hist0100Vo.setSessionkey(httpSession.getId());    /** column SESSIONKEY : sessionkey */
        	  
        	  hist0100Vo.setKybdr(user.getUsrId());    														/** column 입력자 : kybdr */
        	  hist0100Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    		/** column 입력주소 : inptAddr */
        	  hist0100Vo.setIsmt(user.getUsrId());    														/** column 수정자 : ismt */
        	  hist0100Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    		/** column 수정주소 : revnAddr */
 
        	   
        	  hist0200Vo.setDpobCd(user.getDpobCd());    		/** column 사업장코드 : dpobCd */
        	  hist0200Vo.setUsrJobYr(SmrmfUtils.getStringFromDate( new Date(time),"yyyy"));    /** column 사용자작업년도 : usrJobYr */
        	  hist0200Vo.setUsrId(user.getUsrId());    			/** column 사용자아이디 : usrId */
        	  hist0200Vo.setUsrJobSeilNum(BigDecimal.ZERO);    	/** column 사용자작업일련번호 : usrJobSeilNum */
        	  hist0200Vo.setUsrConnectDivCd("APP");    			/** column 사용자접속구분코드 : usrConnectDivCd */
        	  hist0200Vo.setDeptCd(user.getDeptCd());    		/** column 부서코드 : deptCd */
        	  hist0200Vo.setUsrDivCd(user.getUsrDivCd());    	/** column 사용자구분코드 : usrDivCd */
        	  hist0200Vo.setUsrNm(user.getUsrNm());    			/** column 사용자성명 : usrNm */
        	  hist0200Vo.setSystemkey("");    					/** column SYSTEMKEY : systemkey */
        	  
//        	  date = new Date(httpSession.getLastAccessedTime());
        	  //date = new Date();
        	  hist0200Vo.setUsrJobDtntm(SmrmfUtils.getStringFromDate( new Date(time),"yyyyMMddHHmmssSSS"));		/** column 사용자작업일시 : usrJobDtntm */
        	  /**
        	   * C   //create  
        	   * R   //read
        	   * U   //update
        	   * D   //delete
        	   * S   //select
        	   * B   //배치 
        	   * L   //로그인 
        	   * O   //로그아웃
        	   */
        	  
        	  if ("LOGOUT".equals(typeActivity)) {
        		  hist0200Vo.setUsrJobSeptDivCd("XXXXXXXO");	/** column 사용자작업구분코드 : usrJobSeptDivCd */
//            	  date = new Date(httpSession.getLastAccessedTime());
             	 // date = new Date();
             	  hist0200Vo.setUsrJobEndTm(SmrmfUtils.getStringFromDate( new Date(time),"yyyyMMddHHmmssSSS"));	/** column 사용자작업종료일시 : usrJobEndTm */
             	  
        		   } else {
        		  hist0200Vo.setUsrJobSeptDivCd("XXXXXXLX");    /** column 사용자작업구분코드 : usrJobSeptDivCd */
        	   } 
        	  
        	  hist0200Vo.setUsrJobEthdNm(currentMethod);    	/** column 사용자작업메소드명 : usrJobEthdNm */ 
        	  hist0200Vo.setUsrJobBgnnTm(SmrmfUtils.getStringFromDate( new Date(time),"yyyyMMddHHmmssSSS"));	/** column 사용자작업시작일시 : usrJobBgnnTm */

        	  hist0100Vo.setKybdr(user.getUsrId());    												/** column 입력자 : kybdr */
        	  hist0100Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
        	  hist0100Vo.setIsmt(user.getUsrId());    												/** column 수정자 : ismt */
        	  hist0100Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
 
        	  
              if ("LOGOUT".equals(typeActivity)) {
            	  //세션키로 비교할것.....
            	  logHisServDAO.updateHist0100(hist0100Vo);
        	  } else {
        		  logHisServDAO.insertHist0100(hist0100Vo);
        	  } 
   
//              hist0200Activity(hist0200Vo);
        	  logHisServDAO.insertHist0200(hist0200Vo);
        	  
        }catch (Exception ex) {
        	ex.printStackTrace();
            //Rollback transaction and return operation exception 
           // throw SmrmfUtils.getOperationException("tracerUserActivity()", ex, logger);
        }finally {
          
        }

        SmrmfUtils.endTiming(logger, millisBeginMethod, "Method");

    }
    
    
//    public static void hist0200Activity(Hist0200VO hist0200Vo) {
//    	
//    	  try {
//			logHisServDAO.insertHist0200(hist0200Vo);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    }
    
 /**
  * 
  * <pre>
  * 1. 개요 : 
  * 2. 처리내용 : 
  * </pre>
  * @Method Name : tracerUserActivity
  * @date : 2016. 8. 9.
  * @author : Administrator
  * @history : 
  *	-----------------------------------------------------------------------
  *	변경일				작성자						변경내용  
  *	----------- ------------------- ---------------------------------------
  *	2016. 8. 9.		Administrator				최초 작성 
  *	-----------------------------------------------------------------------
  * 
  * @param user
  * @param currentMethod
  * @param objectName
  * @param typeActivity
  */
    public static void tracerUserActivity(
            MSFSysm0100BM user,
            String currentMethod,
            String objectName,
            String typeActivity){
    	 
    	HashMap<String, String> msfGlobals = MSFServerUtils.getLocalidedMessages(RemoteServiceUtil.getThreadLocalConfig(), RemoteServiceUtil.getThreadLocalRequest()); 

        boolean traceEnabled = "true".equals(msfGlobals.get("PayGen.TraceUserActivity"));   //Globals.TRACE_USER_ACTIVITY
        if ( !traceEnabled ) return;
        long time = System.currentTimeMillis(); 
       
        HttpSession httpSession =  RemoteServiceUtil.getThreadLocalSession(); 

        TimingInfo millisBeginMethod = SmrmfUtils.startTiming(logger);
 
        try {
        	
      	  if  (logHisServDAO == null) { 
              WebApplicationContext wac = WebApplicationContextUtils.
                      getRequiredWebApplicationContext(  RemoteServiceUtil.getThreadLocalRequest().getSession().getServletContext());
  
              logHisServDAO = (LogHistoryServiceDAO) wac.getBean("LogHistoryServiceDAO"); 
             
         } 
      	  
//        HibernateUtils.tracerUserActivity(
//        user, 
//        calledMethod, String calledMethod = calledClass + "activityOnGenericObject";
        
//        USR_JOB_ETHD_NM	=>    currentMethod + 구분자 + objectName, 
//        typeActivity
//        );
      	  
      	  SysIfHist0200VO  hist0200Vo = new SysIfHist0200VO();
    	   
    	   
    	  hist0200Vo.setDpobCd(user.getDpobCd());    		/** column 사업장코드 : dpobCd */
    	  hist0200Vo.setUsrJobYr(SmrmfUtils.getStringFromDate( new Date(time),"yyyy"));    /** column 사용자작업년도 : usrJobYr */
    	  hist0200Vo.setUsrId(user.getUsrId());    			/** column 사용자아이디 : usrId */
    	  hist0200Vo.setUsrJobSeilNum(BigDecimal.ZERO);    	/** column 사용자작업일련번호 : usrJobSeilNum */
    	  hist0200Vo.setUsrConnectDivCd("APP");    			/** column 사용자접속구분코드 : usrConnectDivCd */
    	  hist0200Vo.setDeptCd(user.getDeptCd());    		/** column 부서코드 : deptCd */
    	  hist0200Vo.setUsrDivCd(user.getUsrDivCd());    	/** column 사용자구분코드 : usrDivCd */
    	  hist0200Vo.setUsrNm(user.getUsrNm());    			/** column 사용자성명 : usrNm */
//    	  hist0200Vo.setSystemkey("");    					/** column SYSTEMKEY : systemkey */
    	  
//    	  if (SmrmfUtils.dataNotNull(httpSession.getLastAccessedTime())) { 
//    		  date = new Date(httpSession.getLastAccessedTime());
//    	  }
    	  hist0200Vo.setUsrJobDtntm(SmrmfUtils.getStringFromDate( new Date(time),"yyyyMMddHHmmssSSS"));    /** column 사용자작업일시 : usrJobDtntm */
    	  
    	   /**
    	   * CRUDSBLO
    	   * C   //create  
    	   * R   //read
    	   * U   //update
    	   * D   //delete
    	   * S   //select
    	   * B   //배치 
    	   * L   //로그인 
    	   * O   //로그아웃
    	   */
//    	  String strJobSeptDivCd = "XXXXXXXX";
    	  StringBuffer sbJobSeptDivCd = new StringBuffer("XXXXXXXX");
    	  
    	  if(typeActivity.contains(":")) {
    		  
    		  String[] TypeActivity = typeActivity.split(":");
    		  
    		  for(int i = 0; i < TypeActivity.length; i ++) {
    			  String strTypeActivity = TypeActivity[i];
    			  
            	  if ("C".equals(strTypeActivity)  || (ActionDatabase.INSERT.toString()).equals(typeActivity)) {
            		  
            		  sbJobSeptDivCd.replace(1, 2, "C");
            		  
            		  hist0200Vo.setUsrJobSeptDivCd(sbJobSeptDivCd.toString());    								/** column 사용자작업구분코드 : usrJobSeptDivCd */
            		  
            	  } else if("R".equals(strTypeActivity) || (ActionDatabase.READ.toString()).equals(typeActivity)){
            		  
            		  sbJobSeptDivCd.replace(2, 3, "R");
            		
            		  hist0200Vo.setUsrJobSeptDivCd(sbJobSeptDivCd.toString());    								/** column 사용자작업구분코드 : usrJobSeptDivCd */
            	 
            	  } else if("U".equals(strTypeActivity) || (ActionDatabase.UPDATE.toString()).equals(typeActivity)){
            		  
            		  sbJobSeptDivCd.replace(3, 4, "U");
            		
            		  hist0200Vo.setUsrJobSeptDivCd(sbJobSeptDivCd.toString());    								/** column 사용자작업구분코드 : usrJobSeptDivCd */
            	
            	  } else if("D".equals(strTypeActivity) || (ActionDatabase.DELETE.toString()).equals(typeActivity)){
            		  
            		  sbJobSeptDivCd.replace(4, 5, "D");
            		
            		  hist0200Vo.setUsrJobSeptDivCd(sbJobSeptDivCd.toString());    								/** column 사용자작업구분코드 : usrJobSeptDivCd */
            	 
            	  } else if("S".equals(strTypeActivity) || (ActionDatabase.LIST.toString()).equals(typeActivity) || (ActionDatabase.CUSTOM.toString()).equals(typeActivity) ){
            		  
            		  sbJobSeptDivCd.replace(5, 6, "S");
            		
            		  hist0200Vo.setUsrJobSeptDivCd(sbJobSeptDivCd.toString());   				 				/** column 사용자작업구분코드 : usrJobSeptDivCd */
            	
            	  } else if("B".equals(strTypeActivity)){
            		  
            		  sbJobSeptDivCd.replace(6, 7, "B");
            		
            		  hist0200Vo.setUsrJobSeptDivCd(sbJobSeptDivCd.toString());    								/** column 사용자작업구분코드 : usrJobSeptDivCd */
            	 
            	  } else if("L".equals(strTypeActivity)){
            		  
            		  sbJobSeptDivCd.replace(7, 8, "L");
            		
            		  hist0200Vo.setUsrJobSeptDivCd(sbJobSeptDivCd.toString());    								/** column 사용자작업구분코드 : usrJobSeptDivCd */
            	 
            	  } else if("O".equals(strTypeActivity)){
            		  
            		  sbJobSeptDivCd.replace(8, 9, "O");
            		  hist0200Vo.setUsrJobSeptDivCd(sbJobSeptDivCd.toString());    								/** column 사용자작업구분코드 : usrJobSeptDivCd */
            	  }  					  
    					  
    		  }
    		  
    	  }else {
        	  if ("C".equals(typeActivity) || (ActionDatabase.INSERT.toString()).equals(typeActivity)) {
        		  hist0200Vo.setUsrJobSeptDivCd("CXXXXXXX");    												/** column 사용자작업구분코드 : usrJobSeptDivCd */
        	 
        	  } else if("R".equals(typeActivity) || (ActionDatabase.READ.toString()).equals(typeActivity)){
        		
        		  hist0200Vo.setUsrJobSeptDivCd("XRXXXXXX");    											/** column 사용자작업구분코드 : usrJobSeptDivCd */
        	 
        	  } else if("U".equals(typeActivity) || (ActionDatabase.UPDATE.toString()).equals(typeActivity)){
        		
        		  hist0200Vo.setUsrJobSeptDivCd("XXUXXXXX");    											/** column 사용자작업구분코드 : usrJobSeptDivCd */
        	
        	  } else if("D".equals(typeActivity) || (ActionDatabase.DELETE.toString()).equals(typeActivity)){
        		
        		  hist0200Vo.setUsrJobSeptDivCd("XXXDXXXX");    											/** column 사용자작업구분코드 : usrJobSeptDivCd */
        	 
        	  } else if("S".equals(typeActivity) || (ActionDatabase.LIST.toString()).equals(typeActivity) || (ActionDatabase.CUSTOM.toString()).equals(typeActivity) ){
        		
        		  hist0200Vo.setUsrJobSeptDivCd("XXXXSXXX");   				 								/** column 사용자작업구분코드 : usrJobSeptDivCd */
        	
        	  } else if("B".equals(typeActivity)){
        		
        		  hist0200Vo.setUsrJobSeptDivCd("XXXXXBXX");    											/** column 사용자작업구분코드 : usrJobSeptDivCd */
        	 
        	  } else if("L".equals(typeActivity)){
        		
        		  hist0200Vo.setUsrJobSeptDivCd("XXXXXXLX");    											/** column 사용자작업구분코드 : usrJobSeptDivCd */
        	 
        	  } else if("O".equals(typeActivity)){
        	
        		  hist0200Vo.setUsrJobSeptDivCd("XXXXXXXO");    											/** column 사용자작업구분코드 : usrJobSeptDivCd */
        	  
        	  } else {
        		  
        		  hist0200Vo.setUsrJobSeptDivCd(typeActivity);  
        	  }
    	  }
    	

    	  hist0200Vo.setUsrJobBgnnTm(SmrmfUtils.getStringFromDate( new Date(time),"yyyyMMddHHmmssSSS"));  	/** column 사용자작업시작일시 : usrJobBgnnTm */
     	 
    	  hist0200Vo.setUsrJobEthdNm(currentMethod + "$" + objectName);    								/** column 사용자작업메소드명 : usrJobEthdNm */ 

    	//  date = new Date(httpSession.getLastAccessedTime());
    	  hist0200Vo.setUsrJobEndTm(SmrmfUtils.getStringFromDate( new Date(time),"yyyyMMddHHmmssSSS"));			/** column 사용자작업종료일시 : usrJobEndTm */
    	 
    	  hist0200Vo.setKybdr(user.getUsrId());    														/** column 입력자 : kybdr */
    	  hist0200Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    		/** column 입력주소 : inptAddr */
    	  hist0200Vo.setIsmt(user.getUsrId());    														/** column 수정자 : ismt */
    	  hist0200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    		/** column 수정주소 : revnAddr */
    	  
    	  
    	  logHisServDAO.insertHist0200(hist0200Vo);
 
        }
        catch (Exception ex) {
            //Rollback transaction and return operation exception
            ex.printStackTrace();
           // throw SmrmfUtils.getOperationException("tracerUserActivity()", ex, logger);
        }
        finally {
          
        }

        SmrmfUtils.endTiming(logger, millisBeginMethod, "Method");

    }
    
    
    
//TODO 차후 히스토리 추가..을 위해 수정 
    public static void insertHistoryUserActivity(
            MSFSysm0100BM user,
            String objectName,
            ActionDatabase actionDatabase,
            Object dao,
            boolean isDaoDetached){
//TODO 이부분도 수정.
//        int historizationType = SmrmfUtils.isDaoHistorizable(objectName);
//
//        if ( historizationType<=0 ) {
//            logger.debug("insertHistory, dao '"+objectName+"' must not be inserted in DataHistory");
//            return;
//        }

        if ( logger.isDebugEnabled() ) {
            logger.debug("INI.insertHistoryUserActivity(user="+user+",objectName="+objectName+",actionDatabase="+actionDatabase+",dao="+dao+",isDaoDetached="+isDaoDetached+")");
        }

     //   TransactionManager tm = new TransactionManager();
        Object detachedDao = null;
        Blob dataStored  = null;

        try {

            //Get Hibernate session and start a new transaction
          //  Session session = tm.getSession();
         //   tm.initTransaction();

            //In case of a FULL historization, we must store in the table also current Object as a Blob
            //In case of a LITE historization, current Object can be null
//TODO 이부분도 확인  
//            if ( historizationType==MSFConfiguration.HISTORIZABLE_DAO_FULL ) {
//                //If dao is already detached, use it.
//                //otherwise, in case of INSERT simply create a detached copy
//                //           in case of UPDATE or DELETE take current values from database and get a detached copy
//                if ( isDaoDetached ) {
//                    detachedDao = dao;
//                } else if ( actionDatabase==ActionDatabase.INSERT ) {
//                    detachedDao = BeanCopyUtils.clone(dao);
//                } else {
//                    //Read current values of Dao and create a detached copy to store in History
//                    //Object obj = ReflectionUtils.convertBaseModelToObject(objectName, dataObject);
//                    Object id = HibernateUtils.getObjectIdValue(dao);
//                    //Object dao = readGenericObjectById(objectName, id, true, true);
//               //     Object oldDao = session.get(objectName, (Serializable)id);
//               //     detachedDao = BeanCopyUtils.clone(oldDao);
//                }
//                dataStored  = HibernateUtils.getBlobFromObject(detachedDao);
//            } else {
//                //In case of LITE historization, we must get only the primary key that is already present
//                //in the dao, also if is not detached
//                detachedDao = dao;
//                dataStored   = null;
//            }

            //Create new History record, serializing Dao in the Blob attribute
            SysIfSysm0100VO admUser = new SysIfSysm0100VO();
            admUser.setUsrId(user.getUsrId());

 //           String idValue   = HibernateUtils.getObjectIdValueAsString(detachedDao);
 //           String tableName = HibernateUtils.getPersistentClassTableName(objectName);

//            AdmDataHistory admDataHistory = new AdmDataHistory(
//            		admUser
//                   ,new Date(System.currentTimeMillis())
//                   ,actionDatabase.toString()
//                   ,tableName
//                   ,objectName
//                   ,dataStored
//                   ,idValue);

            //Persist history record
          //  session.save(admDataHistory); 
          //  session.flush();

            //Commit transaction
          //  tm.commitTransaction();
        }
        catch (Throwable ex) {
            //Rollback transaction and return operation exception
          //  tm.rollbackTransaction();
            throw MSFServerUtils.getOperationException("insertHistoryUserActivity()", ex, logger);
        }
        finally {
            //Remember to close Session
          //  tm.closeSession();
        }

        if ( logger.isDebugEnabled() ) {
            logger.debug("END.insertHistoryUserActivity(user="+user+",objectName="+objectName+",actionDatabase="+actionDatabase+",dao="+dao+",isDaoDetached="+isDaoDetached+")");
        }
    }
     
    /** 에러 로그 **/
    public static void tracerUserExceptionActivity(
            MSFSysm0100BM user,
            String currentMethod,
            String objectName,
            String typeActivity,
            Throwable caught,
            String windowNm,
            String windowId){
    	 
    	HashMap<String, String> msfGlobals = MSFServerUtils.getLocalidedMessages(RemoteServiceUtil.getThreadLocalConfig(), RemoteServiceUtil.getThreadLocalRequest()); 

        boolean traceEnabled = "true".equals(msfGlobals.get("PayGen.TraceUserActivity"));   //Globals.TRACE_USER_ACTIVITY
        if ( !traceEnabled ) return;
        
        long time = System.currentTimeMillis(); 
        
//        HttpSession httpSession =  RemoteServiceUtil.getThreadLocalSession(); 

        TimingInfo millisBeginMethod = SmrmfUtils.startTiming(logger);
 
        try {
        	
      	  if  (logHisServDAO == null) { 
              WebApplicationContext wac = WebApplicationContextUtils.
                      getRequiredWebApplicationContext(  RemoteServiceUtil.getThreadLocalRequest().getSession().getServletContext());
  
              logHisServDAO = (LogHistoryServiceDAO) wac.getBean("LogHistoryServiceDAO"); 
             
         } 
		       if (MSFSharedUtils.paramNotNull(user)) {
		      	     SysIfHist0300VO  hist0300Vo = new SysIfHist0300VO();
		    	   
					
			    	hist0300Vo.setDpobCd(user.getDpobCd());    		/** column 사업장코드 : dpobCd */
					hist0300Vo.setErrOccrrncYr(SmrmfUtils.getStringFromDate(new Date(time),"yyyy"));    /** column 에러발생년도 : errOccrrncYr */
					hist0300Vo.setUsrId(user.getUsrId());    		/** column 사용자아이디 : usrId */
					hist0300Vo.setErrSeilNum(BigDecimal.ZERO);    	/** column 에러일련번호 : errSeilNum */
					hist0300Vo.setUsrConnectDivCd(PAYGEN_CONN_APP);	/** column 사용자접속구분코드 : usrConnectDivCd */
					hist0300Vo.setDeptCd(user.getDeptCd());			/** column 부서코드 : deptCd */
					hist0300Vo.setUsrDivCd(user.getUsrDivCd());    	/** column 사용자구분코드 : usrDivCd */
					hist0300Vo.setUsrNm(user.getUsrNm());    		/** column 사용자성명 : usrNm */
					
					
		//			 if (SmrmfUtils.dataNotNull(httpSession.getLastAccessedTime())) { 
		//	    		  date = new Date(httpSession.getLastAccessedTime());
		//	    	  } 
					 
					hist0300Vo.setErrOccrrncDtntm(SmrmfUtils.getStringFromDate(new Date(time),"yyyyMMddHHmmssSSS"));		/** column 에러발생일시 : errOccrrncDtntm */
				
					hist0300Vo.setErrEthdNm(currentMethod);    													/** column 에러메소드명 : errEthdNm */
					hist0300Vo.setErrNm(caught.getMessage());    												/** column 에러명 : errNm */
					hist0300Vo.setErrCtnt(MSFSharedUtils.getStackTraceString(caught));    						/** column 에러내용 : errCtnt */
					hist0300Vo.setWindowId(windowId);															/** column 화면아이디 : windowId */
					hist0300Vo.setWindowNm(windowNm);															/** column 화면명 : windowNm */
					
					
					
					hist0300Vo.setKybdr(user.getUsrId()); 														/** column 입력자 : kybdr */
					hist0300Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    		/** column 입력주소 : inptAddr */
					hist0300Vo.setIsmt(user.getUsrId());    													/** column 수정자 : ismt */
					hist0300Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    		/** column 수정주소 : revnAddr */
			    	   
		    	    logHisServDAO.insertHist0300(hist0300Vo);
		       }
        }
        catch (Exception ex) {
        	 ex.printStackTrace(); 
            //throw SmrmfUtils.getOperationException("tracerUserExceptionActivity()", ex, logger);
        }
        finally {
          
        }

        SmrmfUtils.endTiming(logger, millisBeginMethod, "Method");

    }
 
    public static void addErrorToList(String prefix, List<MSFErrorMessage> errlist, MSFErrorMessage err) {
        if ( errlist!=null && err!=null ) {
            if ( MSFSharedUtils.paramNotNull(err.attributeName) && MSFSharedUtils.paramNotNull(prefix) ) {
                err.attributeName = prefix + TableDef.SEPARATOR_CLIENT + err.attributeName;
            }
            errlist.add(err);
        }
    }
 
 

    public static String getIdValueAsString(String[] idAttrNames, Map<String,Object> values) {
        String retval = null;
        try {
            Map<String, Object> idMap = new HashMap<String, Object>();
            for ( int i=0 ; i<idAttrNames.length ; i++ ) {
                String key   = idAttrNames[i];
                Object value = values.get(key);
                idMap.put(key, value);
            }
            retval = ReflectionUtils.convertMapToString(idMap);
        } catch (Exception ex) {
            logger.error("EXCEPTION: "+ex, ex);
        }
        return retval;
    }

    public static IColumnFilter getIdValueAsFilter(String[] idAttrNames, Map<String,Object> values) {
        ListColumnFilter retval = new ListColumnFilter();
        try {
            for ( int i=0 ; i<idAttrNames.length ; i++ ) {
                String key   = idAttrNames[i];
                Object value = values.get(key);
                retval.addFilter(new SimpleColumnFilter(key, (Serializable) value, SimpleColumnFilter.OPERATOR_EQUALS));
            }
        } catch (Exception ex) {
            logger.error("EXCEPTION: "+ex, ex);
        }
        return retval;
    }
 

    public static Object getObjectFromBlob(Blob blob) {

        if ( blob == null ) {
            return null;
        }

        Object obj = null;
        try {
            InputStream bis = blob.getBinaryStream();
            obj = MSFServerUtils.unzipObject(bis);
            bis.close();
        } catch(Exception ex) {
            logger.error("EXCEPTION getObjectFromBlob: "+ex);
        }
        return obj;
    }
}
