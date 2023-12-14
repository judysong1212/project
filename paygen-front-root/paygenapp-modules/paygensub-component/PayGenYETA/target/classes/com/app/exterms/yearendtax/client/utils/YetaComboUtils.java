/**
 * 연말정산 콤보박스 데이타 처리를 위한 처리 부분 추가 부 
 */
package com.app.exterms.yearendtax.client.utils;

import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta1005DTO;
import com.app.exterms.yearendtax.client.service.yeta2016.YetaP110002Service;
import com.app.exterms.yearendtax.client.service.yeta2016.YetaP110002ServiceAsync;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.user.client.rpc.AsyncCallback;


/**
 * @author cyberlhs
 *
 */
public class YetaComboUtils {
	
	/**
	 * 원천신고부서를 가져온다.
	 */
	public static final ListStore<BaseModel> getYeta2000YetaDpcdList(Ye16Ta1005DTO yeta161005Dto){
		
		final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
		YetaP110002ServiceAsync yetaP110002Service = YetaP110002Service.Util.getInstance();
		
		yetaP110002Service.getYeta2000YetaDpcdList(yeta161005Dto, new AsyncCallback<List<BaseModel>>() {
		
			@Override
			public void onSuccess(List<BaseModel> result) {
				
				storeResult.add(result);
			}
			
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
			 
			}
		});
		return storeResult;
	}
	
	public static final ListStore<BaseModel> getYeta2000YetaDpcdListNoAuth(){
		
		final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
		YetaP110002ServiceAsync yetaP110002Service = YetaP110002Service.Util.getInstance();
		
		yetaP110002Service.getYeta2000YetaDpcdListNoAuth(new AsyncCallback<List<BaseModel>>() {
		
			@Override
			public void onSuccess(List<BaseModel> result) {
				
				storeResult.add(result);
			}
			
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
			 
			}
		});
		return storeResult;
	}
	
	/**
	 * 원천신고부서 정보를 가져온다.
	 * */
	public static final ListStore<BaseModel> getBass0120ListNoAuth(){
		
		final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
		YetaP110002ServiceAsync yetaP110002Service = YetaP110002Service.Util.getInstance();
		
		yetaP110002Service.getYeta2000YetaDpcdListNoAuth(new AsyncCallback<List<BaseModel>>() {
		
			@Override
			public void onSuccess(List<BaseModel> result) {
				
				storeResult.add(result);
			}
			
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
			 
			}
			
			
		});
		return storeResult;
	}
	
	
	
	
	
	
	/**
	 * 원천신고부서에 따른 사업자번호를 가져온다.
	 */
	public static final ListStore<BaseModel> getYeta2000busoprRgstnumList(Ye16Ta1005DTO yeta161005Dto){
		
		final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
		YetaP110002ServiceAsync yetaP110002Service = YetaP110002Service.Util.getInstance();
		
		yetaP110002Service.getYeta2000busoprRgstnumList(yeta161005Dto, new AsyncCallback<List<BaseModel>>() {
		
			@Override
			public void onSuccess(List<BaseModel> result) {
				
				storeResult.add(result);
			}
			
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
			 
			}
		});
		return storeResult;
	}

    
   
}
