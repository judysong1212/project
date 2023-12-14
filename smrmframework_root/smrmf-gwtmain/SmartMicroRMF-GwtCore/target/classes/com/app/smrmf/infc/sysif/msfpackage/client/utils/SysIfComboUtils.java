package com.app.smrmf.infc.sysif.msfpackage.client.utils;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.form.ComboBox;

public class SysIfComboUtils {
	
	 
 	private static  List<ModelData> mDtalistDeptCd;    			//부서

	/**
	 * Cd 값을 통해 콤보박스를 선택한다. 3번째 인수는 어떤값을 가져올지 코드네임명을 넣는다.
	 * @param comboBoxObj
	 * @param value
	 */
	public static void setSelectedComboValue(ComboBox<BaseModel> comboBoxObj ,String cd, String getX){
		boolean chkCombo = false;
		String commCd = "commCd";
		if(cd != null && !"".equals(cd)){
			commCd = getX == null ? "commCd" : getX;
			for(int i = 0; i < comboBoxObj.getStore().getCount(); i++){
				if( cd.equals(comboBoxObj.getStore().getAt(i).get(commCd))){
					comboBoxObj.setValue(comboBoxObj.getStore().getAt(i));
					chkCombo = true;
					break;
				}
			}
		}
		if(!chkCombo){
			comboBoxObj.setValue(new BaseModel());
		}
	}
	
	/**
	 * commCd 값을 통해 콤보박스를 선택한다. 
	 * @param comboBoxObj
	 * @param value
	 */
	public static void setSelectedComboValue(ComboBox<BaseModel> comboBoxObj ,String commCd){
		boolean chkCombo = false;
		if(commCd != null && !"".equals(commCd)){
			for(int i = 0; i < comboBoxObj.getStore().getCount(); i++){
				if( commCd.equals(comboBoxObj.getStore().getAt(i).get("commCd"))){
					comboBoxObj.setValue(comboBoxObj.getStore().getAt(i));
					chkCombo = true;
					break;
				}
			}
		}
		if(!chkCombo){
			comboBoxObj.setValue(new BaseModel());
		}
	}
 
	
	 /**
	  * 부서 멀티 콤보처리 
	  * @param lsDeptCd
	  * @return
	  */
	   public static List<ModelData> getDeptCdModelData(ListStore<BaseModel>  lsDeptCd) {
	        mDtalistDeptCd = new ArrayList<ModelData>();
	       for(int i=0; i< lsDeptCd.getCount(); i++) {
	        ModelData m = new BaseModel();
	        m.set("deptCd", lsDeptCd.getAt(i).get("deptCd"));
	        m.set("deptNmRtchnt", lsDeptCd.getAt(i).get("deptNmRtchnt")); 
	        mDtalistDeptCd.add(m);
	       }
	       return mDtalistDeptCd;
	   }
	
	   
//	/** 
//	 * List<BaseModel> getSysIfComboBass0300List(SysIfBass0300DTO sysIfBass0300Dto) 호출 
//	 * 데이터 값을 받은 공통 유틸리티 
//	 * 한건에 대한 콤보 데이터를 가지고 와 baseModel을 리턴 한다.
//	 * @param sysIfBass0300Dto(공통코드 vo)
//	 * @param displayItem(item01 ~ item20 까지 데이터를 이용해 처리 할 경우 기본 출력의 경우 사용하는 item 셋팅 )  
//	 * @return ListStore<BaseModel>
//	 */
//	public static final ListStore<BaseModel> getSingleBass0300ComboData(SysIfBass0300DTO sysIfBass0300Dto){
//		
//		final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
//		SysIfSmrmfServiceAsync sysIfSmrmfService = SysIfSmrmfService.Util.getInstance();
//		
//		sysIfSmrmfService.getSysIfComboBass0300List(sysIfBass0300Dto,new AsyncCallback<List<BaseModel>>() {
//		
//			/**
//			 * 결과값이 정상적으로 처리 된경우 
//			 * @param result
//			 */
//			@Override
//			public void onSuccess(List<BaseModel> result) {
//				// TODO Auto-generated method stub
////				if(result.size() == 0){
////					cboTgtCombo.setEmptyText("--전 체--");
////				}  
//				
//				storeResult.add(result);
//			}
//			/**
//			 * 결과값이 비정상적으로 처리 된 경우 
//			 */
//			@Override
//			public void onFailure(Throwable caught) {
//				// TODO Auto-generated method stub
//			 
//			}
//		});
//		return storeResult;
//	}
//	
//	
//	/**
//	 * 부서 콤보 데이터를 가지고 온다.
//	 * @param sysIfBass0400Dto
//	 * @return
//	 */
//	public static final ListStore<BaseModel> getDeptBass0400ComboData(SysIfBass0400DTO sysIfBass0400Dto){
//		
//		final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
//		SysIfSmrmfServiceAsync sysIfSmrmfService = SysIfSmrmfService.Util.getInstance();
//		
//		sysIfSmrmfService.getSysIfWithBass0400List(new AsyncCallback<List<BaseModel>>() {
//		
//			/**
//			 * 결과값이 정상적으로 처리 된경우 
//			 * @param result
//			 */
//			@Override
//			public void onSuccess(List<BaseModel> result) {
//				// TODO Auto-generated method stub
////				if(result.size() == 0){
////					cboTgtCombo.setEmptyText("--전 체--");
////				}  
//				
//				storeResult.add(result);
//			}
//			/**
//			 * 결과값이 비정상적으로 처리 된 경우 
//			 */
//			@Override
//			public void onFailure(Throwable caught) {
//				// TODO Auto-generated method stub
//			 
//			}
//		});
//		return storeResult;
//	}
	
	 
//	
//	/**
//	 * 
//	 * <pre>
//	 * 1. 개요 : 부서 콤보 데이터를 가지고 온다.
//	 * 2. 처리내용 : 로그인이 안된 상태에서 부서정보를 가지고오는경우 사용 
//	 * </pre>
//	 * @Method Name : getSysIfWithNoLoginBass0400List
//	 * @date : Dec 23, 2015
//	 * @author : leeheuisung
//	 * @history : 
//	 *	-----------------------------------------------------------------------
//	 *	변경일				작성자						변경내용  
//	 *	----------- ------------------- ---------------------------------------
//	 *	Dec 23, 2015		leeheuisung				최초 작성 
//	 *	-----------------------------------------------------------------------
//	 * 
//	 * @param sysIfBass0400Dto
//	 * @return
//	 */
//	public static final ListStore<BaseModel> getSysIfWithNoLoginBass0400List(SysIfBass0400DTO sysIfBass0400Dto){
//		
//		final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
//		SysIfSmrmfServiceAsync sysIfSmrmfService = SysIfSmrmfService.Util.getInstance();
//		
//		sysIfSmrmfService.getSysIfWithNoLoginBass0400List(new AsyncCallback<List<BaseModel>>() {
//		
//			/**
//			 * 결과값이 정상적으로 처리 된경우 
//			 * @param result
//			 */
//			@Override
//			public void onSuccess(List<BaseModel> result) {
//				// TODO Auto-generated method stub
////				if(result.size() == 0){
////					cboTgtCombo.setEmptyText("--전 체--");
////				}  
//				
//				storeResult.add(result);
//			}
//			/**
//			 * 결과값이 비정상적으로 처리 된 경우 
//			 */
//			@Override
//			public void onFailure(Throwable caught) {
//				// TODO Auto-generated method stub
//			 
//			}
//		});
//		return storeResult;
//	}
//	

//	/**
//	 * 부서코드 및 년도로 사업 코드를 가지고 온다.
//	 * @param sysComBass0500Dto(년도,부서코드)
//	 * @return ListStore<BaseModel>
//	 */
//	public static final ListStore<BaseModel> getDeptWithBass0500ComboData(SysIfBass0500DTO sysComBass0500Dto){
//		
//		final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
//		SysIfBass0500ServiceAsync sysComBass0500Service = SysIfBass0500Service.Util.getInstance();
//		
//		sysComBass0500Service.getSysComWithBass0500List(sysComBass0500Dto, new AsyncCallback<List<BaseModel>>() {
//		
//			/**
//			 * 결과값이 정상적으로 처리 된경우 
//			 * @param result
//			 */
//			@Override
//			public void onSuccess(List<BaseModel> result) {
//				// TODO Auto-generated method stub
////				if(result.size() == 0){
////					cboTgtCombo.setEmptyText("--전 체--");
////				}  
//				
//				storeResult.add(result);
//			}
//			/**
//			 * 결과값이 비정상적으로 처리 된 경우 
//			 */
//			@Override
//			public void onFailure(Throwable caught) {
//				// TODO Auto-generated method stub
//				 
//			}
//		});
//		return storeResult;
//	}
	
}
 