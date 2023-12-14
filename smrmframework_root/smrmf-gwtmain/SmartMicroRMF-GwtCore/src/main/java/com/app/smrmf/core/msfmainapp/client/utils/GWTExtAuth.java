/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.store.ListStore;

/**
 * 권한 설정 확장을 위해 추가 클래스
 * @author leeheuisung
 *
 */
public class GWTExtAuth { 
  
	
	 private static String GWT_TYPE_TYPOCCUCD = "ypOccuCd";  //직종 
	 private static String GWT_TYPE_DTILOCCUINTTNCD = "tilOccuInttnCd";  // 직종세부
	 
	 private static boolean GWT_DEF_TRUE = true;
	 private static boolean GWT_DEF_FALSE = false;
	 
//	 public enum AuthAction  { 
//		  PayrMangDeptCd, EmymtDivCd, DeptCd, TypOccuCd, BusinCd 
//	  }   
//	 
//	  private static int checkRtnAuth = 0;  //권한 체크 결과 값 갯수 
	  private static GWTExtAuth oneAuth;  
	  private static  HashMap<String,Boolean> checkMapDef  = new HashMap<String,Boolean>() ;   //체크 맵
	  
	  private GWTExtAuth() { 
			
			checkMapDef = null;
		} 
	  
	  public static GWTExtAuth getInstance() {
	        if(oneAuth==null) {
	        	oneAuth = new GWTExtAuth();
	        }
	        return oneAuth;
	    }
	  
	  /**
	   * 권한설정 처리 체크 
	   * AuthAction 
	   */
	  public  Boolean checkExtAuth(String authAction, ListStore<BaseModel> bm) {  
		  
		    Boolean chkRtnBool = Boolean.FALSE; 
		    Boolean chkDataBool = Boolean.FALSE;
		   
		    if(checkMapDef.containsKey(authAction)){

		    	 if ( (MSFConfiguration.AUTH_USR_DIV_20.equals(MSFMainApp.get().getUser().getUsrDivCd())) 
		    			  || (MSFConfiguration.AUTH_USR_DIV_40.equals(MSFMainApp.get().getUser().getUsrDivCd()))) {
		    		 if(authAction.endsWith(GWT_TYPE_TYPOCCUCD) || authAction.endsWith(GWT_TYPE_DTILOCCUINTTNCD) ){
		    			 checkMapDef.put(authAction, Boolean.TRUE);
		    			 
		    		 } else {
		    			 
		    			 if (bm.getCount() >= 0) {
					   	    	checkMapDef.put(authAction, Boolean.TRUE);
				    	 }  
		    		 }
		    	 } else {
		    		 if (bm.getCount() >= 0) {
				   	    	checkMapDef.put(authAction, Boolean.TRUE);
			    	 }  
		    	 }
		   	    
		    	
		    }  
		   
		   Collection<Boolean> keyMapVal = checkMapDef.values();
		   Iterator<Boolean>  loadChkVal = keyMapVal.iterator();
	         
	        while (loadChkVal.hasNext()) {
	        	if (Boolean.FALSE.equals(loadChkVal.next())) {
	        		chkDataBool = Boolean.TRUE;
	        	}
	        }
	        
	        if (Boolean.FALSE.equals(chkDataBool)) {
	        	chkRtnBool = Boolean.TRUE;
	        } else {
	        	chkRtnBool = Boolean.FALSE;
	        }
	         
	        return chkRtnBool;
	         
	  }
	  

	 public    HashMap<String, Boolean> getCheckMapDef() {
		return checkMapDef;
	 }

	 public    void setCheckMapDef(HashMap<String, Boolean> checkMapDef) {
		 GWTExtAuth.checkMapDef = checkMapDef;
	 }

	public Boolean getLoadCheck() {
		
		   Boolean boolChkAuth = Boolean.FALSE ;  
		 
		   Collection<Boolean> keyMapVal = checkMapDef.values();
		   Iterator<Boolean>  loadChkVal = keyMapVal.iterator();
	         
	        while (loadChkVal.hasNext()) {
	        	if (Boolean.TRUE.equals(loadChkVal.next())) {
	        		boolChkAuth = Boolean.TRUE;
	        	//} else if (Boolean.FALSE.equals(loadChkVal.next())) {
	        	//	boolChkAuth = Boolean.FALSE;
	        	//	break;
	            }
	        }
	        
	        return boolChkAuth;
		
	}  
	
	
	/*************************화면권한 루틴을 처리 부분 추가 **********************************/
	// 권한에 필요한 필드에 대한 활성화 비활성화 처리를 위한 함수 
	/*************************화면권한 루틴을 처리 부분 추가 **********************************/
	public boolean getReadOnlyPayrMangDeptCd() {
		
		String chkPayrMangDeptCd = MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getAuthCheck().getAuthCheck01());   //단위기관 
		boolean rtnChkPayrMangDeptCd = false;
		
		if ("FALSE".equals(chkPayrMangDeptCd)) {
			rtnChkPayrMangDeptCd = GWT_DEF_FALSE;
		} else {
			rtnChkPayrMangDeptCd = false;
		}
		return rtnChkPayrMangDeptCd;
	}
	
	public boolean getReadOnlyEmymtDivCd() {
		
		String chkEmymtDivCd = MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getAuthCheck().getAuthCheck02());   //고용구분 
		boolean rtnChkEmymtDivCd = false;
		
		if ("FALSE".equals(chkEmymtDivCd)) {
			rtnChkEmymtDivCd = GWT_DEF_FALSE;
		} else {
			rtnChkEmymtDivCd = false;
		}
		return rtnChkEmymtDivCd;
	}
	
	public boolean getReadOnlyDeptCd() {
		
		String chkDeptCd = MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getAuthCheck().getAuthCheck03());   //부서 
		boolean rtnChkDeptCd = false;
		
		if ("FALSE".equals(chkDeptCd)) {
			rtnChkDeptCd = GWT_DEF_FALSE;
		} else {
			rtnChkDeptCd = false;
		}
		return rtnChkDeptCd;
	}
	
	public boolean getReadOnlyTypOccuCd() {
		
		String chkTypOccuCd = MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getAuthCheck().getAuthCheck04());   //직종 
		boolean rtnChkTypOccuCd = false;
		
		if ("FALSE".equals(chkTypOccuCd)) {
			rtnChkTypOccuCd = GWT_DEF_FALSE;
		} else {
			rtnChkTypOccuCd = false;
		}
		return rtnChkTypOccuCd;
	}
	
	public boolean getReadOnlyDtilOccuInttnCd() {
		
		String chkDtilOccuInttnCd = MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getAuthCheck().getAuthCheck05());  //직종세 
		boolean rtnChkDtilOccuInttnCd = false;
		
		if ("FALSE".equals(chkDtilOccuInttnCd)) {
			rtnChkDtilOccuInttnCd = GWT_DEF_FALSE;
		} else {
			rtnChkDtilOccuInttnCd = false;
		}
		return rtnChkDtilOccuInttnCd;
	}
	
	public boolean getReadOnlyBusinCd() {
		
		String chkBusinCd = MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getAuthCheck().getAuthCheck06());  //사업 
		boolean rtnChkBusinCd = false;
		
		if ("FALSE".equals(chkBusinCd)) {
			rtnChkBusinCd = GWT_DEF_FALSE;
		} else {
			rtnChkBusinCd = false;
		}
		return rtnChkBusinCd;
	}
	
	
	/*************************화면권한 루틴을 처리 부분 추가 **********************************/
	// 권한에 필요한 필드에 대한 활성화 비활성화 처리를 위한 함수 
	/*************************화면권한 루틴을 처리 부분 추가 **********************************/
	public boolean getEnablePayrMangDeptCd() {
		
		String chkPayrMangDeptCd = MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getAuthCheck().getAuthCheck01());   //단위기관 
		boolean rtnChkPayrMangDeptCd = false;
		
		if ("TRUE".equals(chkPayrMangDeptCd)) {
			rtnChkPayrMangDeptCd = true;
		} else {
			rtnChkPayrMangDeptCd = GWT_DEF_TRUE;
		}
		return rtnChkPayrMangDeptCd;
	}
	
	public boolean getEnableEmymtDivCd() {
		
		String chkEmymtDivCd = MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getAuthCheck().getAuthCheck02());   //고용구분 
		boolean rtnChkEmymtDivCd = false;
		
		if ("TRUE".equals(chkEmymtDivCd)) {
			rtnChkEmymtDivCd = true;
		} else {
			rtnChkEmymtDivCd = GWT_DEF_TRUE;
		}
		return rtnChkEmymtDivCd;
	}
	
	public boolean getEnableDeptCd() {
		
		String chkDeptCd = MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getAuthCheck().getAuthCheck03());   //부서 
		boolean rtnChkDeptCd = false;
		
		if ("TRUE".equals(chkDeptCd)) {
			rtnChkDeptCd = true;
		} else {
			rtnChkDeptCd = GWT_DEF_TRUE;
		}
		return rtnChkDeptCd;
	}
	
	public boolean getEnableTypOccuCd() {
		
		String chkTypOccuCd = MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getAuthCheck().getAuthCheck04());   //직종 
		boolean rtnChkTypOccuCd = false;
		
		if ("TRUE".equals(chkTypOccuCd)) {
			rtnChkTypOccuCd = true;
		} else {
			rtnChkTypOccuCd = GWT_DEF_TRUE;
		}
		return rtnChkTypOccuCd;
	}
	
	public boolean getEnableDtilOccuInttnCd() {
		
		String chkDtilOccuInttnCd = MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getAuthCheck().getAuthCheck05());  //직종세 
		boolean rtnChkDtilOccuInttnCd = false;
		
		if ("TRUE".equals(chkDtilOccuInttnCd)) {
			rtnChkDtilOccuInttnCd = true;
		} else {
			rtnChkDtilOccuInttnCd = GWT_DEF_TRUE;
		}
		return rtnChkDtilOccuInttnCd;
	}
	
	public boolean getEnableBusinCd() {
		
		String chkBusinCd = MSFSharedUtils.allowNulls(MSFMainApp.get().getUser().getAuthCheck().getAuthCheck06());  //사업 
		boolean rtnChkBusinCd = false;
		
		if ("TRUE".equals(chkBusinCd)) {
			rtnChkBusinCd = true;
		} else {
			rtnChkBusinCd = GWT_DEF_TRUE;
		}
		return rtnChkBusinCd;
	}
	 
	
	 
	  /**
	   * 권한설정 처리 체크TODO 삭제 
	   * AuthAction 
	   */
//	  public static boolean checkExtAuth(AuthAction authAction, ListStore<BaseModel> bm, int authChk) {  
//		  
//		   boolean chkRtnBool = false;
//		   
//		   switch (authAction) {
//           case PayrMangDeptCd: 
//        	    if (bm.getCount() > 0) {
//        	    	checkRtnAuth++;
//        	    }  
//              break;
//           case EmymtDivCd: 
//        	   if (bm.getCount() > 0) {
//        		   checkRtnAuth++;
//       	       } 
//               break;
//           case DeptCd: 
//        	   if (bm.getCount() > 0) {
//        		   checkRtnAuth++;
//       	       } 
//               break;
//           case TypOccuCd: 
//        	   if (bm.getCount() > 0) {
//        		   checkRtnAuth++;
//       	       } 
//               break;
//           case BusinCd: 
//        	   if (bm.getCount() > 0) {
//        		   checkRtnAuth++;
//       	       }  
//               break;
//           default:
//        	   
//        	   break;
//           } 
//		 
//		   if (checkRtnAuth == authChk) {
//			    chkRtnBool = true;
//                checkRtnAuth = 0;  
//		   }
//		   
//		   return chkRtnBool;
//	  }  
}
