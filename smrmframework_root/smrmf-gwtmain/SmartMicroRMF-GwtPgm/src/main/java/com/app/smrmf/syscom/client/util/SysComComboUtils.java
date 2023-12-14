package com.app.smrmf.syscom.client.util;

import java.util.HashMap;
import java.util.List;

import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.app.smrmf.syscom.client.dto.SysComCmmn0320DTO;
import com.app.smrmf.syscom.client.service.SysCoCalendarService;
import com.app.smrmf.syscom.client.service.SysCoCalendarServiceAsync;
import com.app.smrmf.syscom.client.service.SysComCmmn0320Service;
import com.app.smrmf.syscom.client.service.SysComCmmn0320ServiceAsync;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class SysComComboUtils {
     
	/**
	 * 달력년도
	 * @param msfCoCalendarDto 
	 * @return ListStore<BaseModel>
	 */
	public static final ListStore<BaseModel> getSysComComboYearData(SysCoCalendarDTO msfCoCalendarDto){
		
		final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
		SysCoCalendarServiceAsync msfCoCalendarService = SysCoCalendarService.Util.getInstance();
		
		 
		msfCoCalendarService.getSysComComboYearList(msfCoCalendarDto, new AsyncCallback<List<BaseModel>>() {
		
			/**
			 * 결과값이 정상적으로 처리 된경우 
			 * @param result
			 */
			@Override
			public void onSuccess(List<BaseModel> result) {
				// TODO Auto-generated method stub
//				if(result.size() == 0){
//					cboTgtCombo.setEmptyText("--전 체--");
//				}  
				
				storeResult.add(result);
			}
			/**
			 * 결과값이 비정상적으로 처리 된 경우 
			 */
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				 
			}
		});
		return storeResult;
	}
	
	/**
	 * 달력년도
	 * @param msfCoCalendarDto 
	 * @return ListStore<BaseModel>
	 */
	public static final ListStore<BaseModel> getSysComComboMonthData(SysCoCalendarDTO msfCoCalendarDto){
		
		final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
		SysCoCalendarServiceAsync msfCoCalendarService = SysCoCalendarService.Util.getInstance();
		
		 
		msfCoCalendarService.getSysComComboMonthList(msfCoCalendarDto, new AsyncCallback<List<BaseModel>>() {
		
			/**
			 * 결과값이 정상적으로 처리 된경우 
			 * @param result
			 */
			@Override
			public void onSuccess(List<BaseModel> result) {
				// TODO Auto-generated method stub
//				if(result.size() == 0){
//					cboTgtCombo.setEmptyText("--전 체--");
//				}  
				
				storeResult.add(result);
			}
			/**
			 * 결과값이 비정상적으로 처리 된 경우 
			 */
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				 
			}
		});
		return storeResult;
	}
	
	   /**
     * 우편번호-시도ROAD_NM_CTAPV
     * @param msfCoCalendarDto 
     * @return ListStore<BaseModel>
     */
    public static final ListStore<BaseModel> getSysComComboRoadNmCtapv(SysComCmmn0320DTO sysComCmmn0320Dto){
        
        final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
        SysComCmmn0320ServiceAsync sysComCmmn0320Service = SysComCmmn0320Service.Util.getInstance();
        
         
        sysComCmmn0320Service.getSysComComboRoadNmCtapv(sysComCmmn0320Dto, new AsyncCallback<List<BaseModel>>() {
        
            /**
             * 결과값이 정상적으로 처리 된경우 
             * @param result
             */
            @Override
            public void onSuccess(List<BaseModel> result) {
                // TODO Auto-generated method stub
//              if(result.size() == 0){
//                  cboTgtCombo.setEmptyText("--전 체--");
//              }  
                
                storeResult.add(result);
            }
            /**
             * 결과값이 비정상적으로 처리 된 경우 
             */
            @Override
            public void onFailure(Throwable caught) {
                // TODO Auto-generated method stub
                 
            }
        });
        return storeResult;
    }
    
    /**
     * 우편번호-시도ROAD_NM_CATATGU
     * @param msfCoCalendarDto 
     * @return ListStore<BaseModel>
     */
    public static final ListStore<BaseModel> getSysComComboRoadNmCtatgu(SysComCmmn0320DTO sysComCmmn0320Dto){
        
        final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
        SysComCmmn0320ServiceAsync sysComCmmn0320Service = SysComCmmn0320Service.Util.getInstance();
        
         
        sysComCmmn0320Service.getSysComComboRoadNmCtatgu(sysComCmmn0320Dto, new AsyncCallback<List<BaseModel>>() {
        
            /**
             * 결과값이 정상적으로 처리 된경우 
             * @param result
             */
            @Override
            public void onSuccess(List<BaseModel> result) {
                // TODO Auto-generated method stub
//              if(result.size() == 0){
//                  cboTgtCombo.setEmptyText("--전 체--");
//              }  
                
                storeResult.add(result);
            }
            /**
             * 결과값이 비정상적으로 처리 된 경우 
             */
            @Override
            public void onFailure(Throwable caught) {
                // TODO Auto-generated method stub
                 
            }
        });
        return storeResult;
    }
	
     
	
	/**
	 * 달력년도
	 * @param msfCoCalendarDto 
	 * @return ListStore<BaseModel>
	 */
	public static final HashMap<String, Object>  getExSysComComboYearData(SysCoCalendarDTO msfCoCalendarDto){
		
		final HashMap<String, Object> storeResult = new HashMap<String, Object>(); 
		//final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
		SysCoCalendarServiceAsync msfCoCalendarService = SysCoCalendarService.Util.getInstance();
		
		 
		msfCoCalendarService.getSysComComboYearList(msfCoCalendarDto, new AsyncCallback<List<BaseModel>>() {
		
			/**
			 * 결과값이 정상적으로 처리 된경우 
			 * @param result
			 */
			@Override
			public void onSuccess(List<BaseModel> result) {
				// TODO Auto-generated method stub
//				if(result.size() == 0){
//					cboTgtCombo.setEmptyText("--전 체--");
//				}  
				
				storeResult.put("syncCallBack", "success");  //권한체크 
				storeResult.put("listStore", result);
			}
			/**
			 * 결과값이 비정상적으로 처리 된 경우 
			 */
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				storeResult.put("syncCallBack", "failure");
				storeResult.put("listStore", new ListStore<BaseModel>());
			}
		});
		return storeResult;
	}
	
	/**
	 * 달력년도
	 * @param msfCoCalendarDto 
	 * @return ListStore<BaseModel>
	 */
	public static final HashMap<String, Object>  getExSysComComboMonthData(SysCoCalendarDTO msfCoCalendarDto){
		
		final HashMap<String, Object> storeResult = new HashMap<String, Object>(); 
		//final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
		SysCoCalendarServiceAsync msfCoCalendarService = SysCoCalendarService.Util.getInstance();
		
		 
		msfCoCalendarService.getSysComComboMonthList(msfCoCalendarDto, new AsyncCallback<List<BaseModel>>() {
		
			/**
			 * 결과값이 정상적으로 처리 된경우 
			 * @param result
			 */
			@Override
			public void onSuccess(List<BaseModel> result) {
				// TODO Auto-generated method stub
//				if(result.size() == 0){
//					cboTgtCombo.setEmptyText("--전 체--");
//				}  
				
				storeResult.put("syncCallBack", "success");  //권한체크 
				storeResult.put("listStore", result);
			}
			/**
			 * 결과값이 비정상적으로 처리 된 경우 
			 */
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				storeResult.put("syncCallBack", "failure");
				storeResult.put("listStore", new ListStore<BaseModel>());
			}
		});
		return storeResult;
	}
	
	   /**
     * 우편번호-시도ROAD_NM_CTAPV
     * @param msfCoCalendarDto 
     * @return ListStore<BaseModel>
     */
    public static final HashMap<String, Object>  getExSysComComboRoadNmCtapv(SysComCmmn0320DTO sysComCmmn0320Dto){
        
    	final HashMap<String, Object> storeResult = new HashMap<String, Object>(); 
       // final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
    	SysComCmmn0320ServiceAsync sysComCmmn0320Service = SysComCmmn0320Service.Util.getInstance();
        
         
        sysComCmmn0320Service.getSysComComboRoadNmCtapv(sysComCmmn0320Dto, new AsyncCallback<List<BaseModel>>() {
        
            /**
             * 결과값이 정상적으로 처리 된경우 
             * @param result
             */
            @Override
            public void onSuccess(List<BaseModel> result) {
                // TODO Auto-generated method stub
//              if(result.size() == 0){
//                  cboTgtCombo.setEmptyText("--전 체--");
//              }  
                
            	storeResult.put("syncCallBack", "success");  //권한체크 
				storeResult.put("listStore", result);
            }
            /**
             * 결과값이 비정상적으로 처리 된 경우 
             */
            @Override
            public void onFailure(Throwable caught) {
                // TODO Auto-generated method stub
            	storeResult.put("syncCallBack", "failure");
            	storeResult.put("listStore", new ListStore<BaseModel>());
            }
        });
        return storeResult;
    }
    
    /**
     * 우편번호-시도ROAD_NM_CTAPV
     * @param msfCoCalendarDto 
     * @return ListStore<BaseModel>
     */
    public static final   HashMap<String, Object>  getExSysComComboRoadNmCtatgu(SysComCmmn0320DTO sysComCmmn0320Dto){
        
    	final HashMap<String, Object> storeResult = new HashMap<String, Object>(); 
        //final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
    	SysComCmmn0320ServiceAsync sysComCmmn0320Service = SysComCmmn0320Service.Util.getInstance();
        
         
        sysComCmmn0320Service.getSysComComboRoadNmCtatgu(sysComCmmn0320Dto, new AsyncCallback<List<BaseModel>>() {
        
            /**
             * 결과값이 정상적으로 처리 된경우 
             * @param result
             */
            @Override
            public void onSuccess(List<BaseModel> result) {
                // TODO Auto-generated method stub
//              if(result.size() == 0){
//                  cboTgtCombo.setEmptyText("--전 체--");
//              }  
             
            	storeResult.put("syncCallBack", "success");  //권한체크 
				storeResult.put("listStore", result);
            }
            /**
             * 결과값이 비정상적으로 처리 된 경우 
             */
            @Override
            public void onFailure(Throwable caught) {
                // TODO Auto-generated method stub
            	storeResult.put("syncCallBack", "failure");
            	storeResult.put("listStore", new ListStore<BaseModel>());
            }
        });
        return storeResult;
    }
	
	
}
 