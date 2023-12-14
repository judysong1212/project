package com.app.smrmf.infc.sysif.msfpackage.client.utils;

import java.util.List;

import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.Lov;
import com.app.smrmf.core.msfmainapp.client.generics.LovLiveGeneric;
import com.app.smrmf.core.msfmainapp.client.generics.MSFCustomForm;
import com.app.smrmf.core.msfmainapp.client.generics.MSFPanelCustomForm;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.sysif.msfpackage.client.form.SysIfP0100;
import com.app.smrmf.infc.sysif.msfpackage.client.form.defs.SysIfPsnl0100Def;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0300DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0320DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0350DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0400DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0500DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.service.MSFPkgSmrmfService;
import com.app.smrmf.infc.sysif.msfpackage.client.service.MSFPkgSmrmfServiceAsync;
import com.app.smrmf.infc.sysif.msfpackage.client.service.SysIfBass0500Service;
import com.app.smrmf.infc.sysif.msfpackage.client.service.SysIfBass0500ServiceAsync;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class SysifComServiceUtils {
   
	
	private static SysIfBass0400DTO listResult01 = new SysIfBass0400DTO();
	private static SysIfBass0320DTO listResult02 = new SysIfBass0320DTO(); 
	private static SysIfBass0350DTO listResult03 = new SysIfBass0350DTO(); 
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 부서 콤보 데이터를 가지고 온다.
	 * 2. 처리내용 : 로그인이 안된 상태에서 부서정보를 가지고오는경우 사용 
	 * </pre>
	 * @Method Name : getSysIfWithNoLoginBass0400List
	 * @date : Dec 23, 2015
	 * @author : leeheuisung
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	Dec 23, 2015		leeheuisung				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param sysIfBass0400Dto
	 * @return
	 */
	public static final ListStore<BaseModel> getSysIfWithNoLoginBass0400List(SysIfBass0400DTO coreBass0400Dto){
		
		final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
		MSFPkgSmrmfServiceAsync sysIfSmrmfService = MSFPkgSmrmfService.Util.getInstance();
		
		sysIfSmrmfService.getSysIfWithNoLoginBass0400List(new AsyncCallback<List<BaseModel>>() {
		
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
	 * 
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 :  데이터 값을 받은 공통 유틸리티 
	 *            한건에 대한 콤보 데이터를 가지고 와 baseModel을 리턴 한다.
	 * </pre>
	 * @Method Name : getSingleBass0300ComboData
	 * @date : 2016. 9. 8.
	 * @author : Administrator
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2016. 9. 8.		Administrator				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param sysIfBass0300Dto(공통코드 vo)
	 * @param displayItem(item01 ~ item20 까지 데이터를 이용해 처리 할 경우 기본 출력의 경우 사용하는 item 셋팅 )  
	 * @return ListStore<BaseModel>
	 * @return
	 */
	public static final ListStore<BaseModel> getSingleBass0300ComboData(SysIfBass0300DTO sysIfBass0300Dto){
		
		final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
		MSFPkgSmrmfServiceAsync sysIfSmrmfService = MSFPkgSmrmfService.Util.getInstance();
		
		sysIfSmrmfService.getSysIfComboBass0300List(sysIfBass0300Dto,new AsyncCallback<List<BaseModel>>() {
		
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
	 * 
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : getDeptBass0400ComboData
	 * @date : 2016. 9. 8.
	 * @author : Administrator
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2016. 9. 8.		Administrator				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param sysIfBass0400Dto
	 * @return
	 */
	public static final ListStore<BaseModel> getDeptBass0400ComboData(SysIfBass0400DTO sysIfBass0400Dto){
		
		final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
		MSFPkgSmrmfServiceAsync sysIfSmrmfService = MSFPkgSmrmfService.Util.getInstance();
		
		sysIfSmrmfService.getSysIfWithBass0400List(new AsyncCallback<List<BaseModel>>() {
		
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
	
	
	 
		//인사팝업-단건선택
		public static final MSFFormPanel lovPopUpMsfCom0100Form(){
		        
		        // TODO Auto-generated method stub 
		            return lovPopUpMsfCom0100Form(null);
		         
		}
		   
		public static final MSFFormPanel lovPopUpMsfCom0100Form(String UsrName){ 
			
			Lov lov = null;     
			//LovLiveGeneric lovWindow = null; 
			final MSFPanelCustomForm customForm  = new MSFPanelCustomForm(new SysIfPsnl0100Def(), 1, 0);
			MSFCustomForm sysCom0100Form = customForm.getCustomForm();    
			MSFFormPanel comform = (MSFFormPanel)sysCom0100Form;
			final SysIfP0100 sysComP0100 =  new SysIfP0100(850,600); 
			customForm.setLov(sysComP0100);
			lov = customForm.getLov();   
			
			if (MSFSharedUtils.paramNull(UsrName)) {
			    customForm.getLov().getLovDef().addColumnFilter("hanNm", "TT", SimpleColumnFilter.OPERATOR_EQUALS);   
			} else {
				SysIfP0100.getHanNm().setValue(UsrName);
			    customForm.getLov().getLovDef().addColumnFilter("hanNm", UsrName, SimpleColumnFilter.OPERATOR_EQUALS);  
			}
			
		 
	        if (lov != null) {
	            final LovLiveGeneric lovWindow = new LovLiveGeneric(customForm.getLov().getLovDef(),sysCom0100Form.getTableDef());
	            lovWindow.setInitialForm(sysCom0100Form);   //formPanel을적어준다.
	            lovWindow.showButtonNew(false); 
	            lovWindow.setSize(lov.getWidth(),lov.getHeight());  //팝업화면 사이즈
	            lovWindow.show();
	            lov.fixAttributeFormNames(); 
	   
	            SysIfP0100.getHanNm().addKeyListener(new KeyListener() {
	                public void componentKeyUp(ComponentEvent event) {
	                    super.componentKeyUp(event);
	                    SysIfP0100.getHanNm().validate();
	                    if(event.getKeyCode() == KeyCodes.KEY_ENTER) {  
	                        IColumnFilter filters = null;
	                        lovWindow.getLovDef().setTableColumnFilters(filters); 
	                        lovWindow.getLovDef().addColumnFilter("deptCd", MSFSharedUtils.getSelectedComboValue(SysIfP0100.getDeptCd(),"deptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
	                        lovWindow.getLovDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(SysIfP0100.getTypOccuCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
	                        lovWindow.getLovDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(SysIfP0100.getEmymtDivCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
	                        lovWindow.getLovDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(SysIfP0100.getBusinCd(),"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
	                        lovWindow.getLovDef().addColumnFilter("hdofcCodtnCd", MSFSharedUtils.getSelectedComboValue(SysIfP0100.getHdofcCodtnCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
	                        lovWindow.getLovDef().addColumnFilter("hanNm", MSFSharedUtils.defaultNulls(SysIfP0100.getHanNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
	                        lovWindow.getLovDef().addColumnFilter("resnRegnNum", MSFSharedUtils.defaultNulls(SysIfP0100.getResnRegnNum().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
	                        lovWindow.getLovDef().addColumnFilter("systemkey", MSFSharedUtils.defaultNulls(SysIfP0100.getSystemkey().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
	                        lovWindow.readData();
	                    }
	                }
	             });
	            
	            SysIfP0100.btnUsrSearch.addListener(Events.Select, new Listener<ButtonEvent>() {
	              public void handleEvent(ButtonEvent e) {
	            	  SysIfP0100.getHanNm().validate();
	                  IColumnFilter filters = null;
	                  lovWindow.getLovDef().setTableColumnFilters(filters);
	                  lovWindow.getLovDef().addColumnFilter("deptCd", MSFSharedUtils.getSelectedComboValue(SysIfP0100.getDeptCd(),"deptCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
	                  lovWindow.getLovDef().addColumnFilter("typOccuCd", MSFSharedUtils.getSelectedComboValue(SysIfP0100.getTypOccuCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
	                  lovWindow.getLovDef().addColumnFilter("emymtDivCd", MSFSharedUtils.getSelectedComboValue(SysIfP0100.getEmymtDivCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
	                  lovWindow.getLovDef().addColumnFilter("businCd", MSFSharedUtils.getSelectedComboValue(SysIfP0100.getBusinCd(),"businCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
	                  lovWindow.getLovDef().addColumnFilter("hdofcCodtnCd", MSFSharedUtils.getSelectedComboValue(SysIfP0100.getHdofcCodtnCd(),"commCd"), SimpleColumnFilter.OPERATOR_EQUALS); 
	                  lovWindow.getLovDef().addColumnFilter("hanNm", MSFSharedUtils.defaultNulls(SysIfP0100.getHanNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
	                  lovWindow.getLovDef().addColumnFilter("resnRegnNum", MSFSharedUtils.defaultNulls(SysIfP0100.getResnRegnNum().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
	                  lovWindow.getLovDef().addColumnFilter("systemkey", MSFSharedUtils.defaultNulls(SysIfP0100.getSystemkey().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
	                  lovWindow.readData();
	                  
	              }
	             });
	            
	    	} 
		        return comform;
			 
		}
			 

		/**
		 * 부서코드 및 년도로 사업 코드를 가지고 온다.
		 * @param sysComBass0500Dto(년도,부서코드)
		 * @return ListStore<BaseModel>
		 */
		public static final ListStore<BaseModel> getDeptWithBass0500ComboData(SysIfBass0500DTO sysComBass0500Dto){
			
			final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
			SysIfBass0500ServiceAsync sysComBass0500Service = SysIfBass0500Service.Util.getInstance();
			
			sysComBass0500Service.getSysComWithBass0500List(sysComBass0500Dto, new AsyncCallback<List<BaseModel>>() {
			
				/**
				 * 결과값이 정상적으로 처리 된경우 
				 * @param result
				 */
				@Override
				public void onSuccess(List<BaseModel> result) {
					// TODO Auto-generated method stub
//					if(result.size() == 0){
//						cboTgtCombo.setEmptyText("--전 체--");
//					}  
					
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
		
		
/************************************* 시점에 따른 사용 부서, 직종, 직종세 데이타를 가져와 넘기는 부분으로 이 부분은 차후 추가 하여 처리할 부분 존재 ******************************/
		
/**
 * 		
 * <pre>
 * 1. 개요 :   기간에 따른 부서 리스트를 리스트 형태로 리턴 한다.  
 * 2. 처리내용 : 
 * </pre>
 * @Method Name : funcArrBeforDeptCd
 * @date : 2017. 1. 21.
 * @author : atres-pc
 * @history : 
 *	-----------------------------------------------------------------------
 *	변경일				작성자						변경내용  
 *	----------- ------------------- ---------------------------------------
 *	2017. 1. 21.		atres-pc				최초 작성 
 *	-----------------------------------------------------------------------
 * 
 * @param sysIfBass0400Dto
 * @return
 */
public static final SysIfBass0400DTO funcArrBeforDeptCd(SysIfBass0400DTO sysIfBass0400Dto ) {
	
	 
	MSFPkgSmrmfServiceAsync sysIfSmrmfService = MSFPkgSmrmfService.Util.getInstance();
	
	sysIfSmrmfService.getFuncBeforComboBass0400List(sysIfBass0400Dto , new AsyncCallback<SysIfBass0400DTO>() {
	
		/**
		 * 결과값이 정상적으로 처리 된경우 
		 * @param result
		 */
		@Override
		public void onSuccess(SysIfBass0400DTO result) {
			// TODO Auto-generated method stub
//			if(result.size() == 0){
//				cboTgtCombo.setEmptyText("--전 체--");
//			}  
			
			listResult01 = result;
		}
		/**
		 * 결과값이 비정상적으로 처리 된 경우 
		 */
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
		 
		}
	});
	return listResult01;
}	

/**
 * 
 * <pre>
 * 1. 개요 : 기간에 포함 되어 있는 리스트를 직종에 대해 출력한다.  
 * 2. 처리내용 : 
 * </pre>
 * @Method Name : funcArrBeforTypOccuCd
 * @date : 2017. 1. 21.
 * @author : atres-pc
 * @history : 
 *	-----------------------------------------------------------------------
 *	변경일				작성자						변경내용  
 *	----------- ------------------- ---------------------------------------
 *	2017. 1. 21.		atres-pc				최초 작성 
 *	-----------------------------------------------------------------------
 * 
 * @param sysComBass0320Dto
 * @return
 */
public static final SysIfBass0320DTO funcArrBeforTypOccuCd(SysIfBass0320DTO sysComBass0320Dto){
	
	
	MSFPkgSmrmfServiceAsync sysIfSmrmfService = MSFPkgSmrmfService.Util.getInstance();
	
	sysIfSmrmfService.getFuncBeforComboBass0320List(sysComBass0320Dto, new AsyncCallback<SysIfBass0320DTO>() {
		
		/**
		 * 결과값이 정상적으로 처리 된경우 
		 * @param result
		 */
		@Override
		public void onSuccess(SysIfBass0320DTO result) {
			// TODO Auto-generated method stub
//			if(result.size() == 0){
//				cboTgtCombo.setEmptyText("--전 체--");
//			}  
			
			listResult02 = result;
		}
		/**
		 * 결과값이 비정상적으로 처리 된 경우 
		 */
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
		 
		}
	});
	return listResult02;
}	

public static final SysIfBass0350DTO getFuncBeforDtilOccuInttnCd(SysIfBass0350DTO sysIfBass0350Dto){
	
	MSFPkgSmrmfServiceAsync sysIfSmrmfService = MSFPkgSmrmfService.Util.getInstance();
	
	sysIfSmrmfService.getFuncBeforComboBass0350List(sysIfBass0350Dto,new AsyncCallback<SysIfBass0350DTO>() {
		
		/**
		 * 결과값이 정상적으로 처리 된경우 
		 * @param result
		 */
		@Override
		public void onSuccess(SysIfBass0350DTO result) {
			// TODO Auto-generated method stub
//			if(result.size() == 0){
//				cboTgtCombo.setEmptyText("--전 체--");
//			}  
			
			listResult03 = result;
		}
		/**
		 * 결과값이 비정상적으로 처리 된 경우 
		 */
		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
		 
		}
	});
	return listResult03;
}	

/**
 * 직종 콤보를 가지고 온다. -직종 맵핑에 따른 값가져오기 
 * @param prgmComBass0350Dto(
 * @return ListStore<BaseModel>
 */
public static final ListStore<BaseModel> getSingleTypOccuCdBass0320ComboData(SysIfBass0320DTO sysIfBass0320Dto){
    
    final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
	MSFPkgSmrmfServiceAsync sysIfSmrmfService = MSFPkgSmrmfService.Util.getInstance();
    
    sysIfSmrmfService.getSysIfComboTypOccuCdList(sysIfBass0320Dto, new AsyncCallback<List<BaseModel>>() { 
        /**
         * 결과값이 정상적으로 처리 된경우 
         * @param result
         */
        @Override
        public void onSuccess(List<BaseModel> result) {
            // TODO Auto-generated method stub
//          if(result.size() == 0){
//              cboTgtCombo.setEmptyText("--전 체--");
//          }  
            
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

///**
// * 
// * <pre>
// * 1. 개요 :  권한 없이 직종 가져오기 
// * 2. 처리내용 : 
// * </pre>
// * @Method Name : getSingleNonBass0320ComboData
// * @date : Apr 21, 2016
// * @author : leeheuisung
// * @history : 
// *	-----------------------------------------------------------------------
// *	변경일				작성자						변경내용  
// *	----------- ------------------- ---------------------------------------
// *	Apr 21, 2016		leeheuisung				최초 작성 
// *	-----------------------------------------------------------------------
// * 
// * @param prgmComBass0320Dto
// * @return
// */
//public static final ListStore<BaseModel> getSingleNonBass0320ComboData(PrgmComBass0320DTO prgmComBass0320Dto){
//    
//    final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
//    PrgmComBass0350ServiceAsync prgmComBass0350Service = PrgmComBass0350Service.Util.getInstance();
//    
//    prgmComBass0350Service.getSysNonTypOccuCdList(prgmComBass0320Dto, new AsyncCallback<List<BaseModel>>() { 
//        /**
//         * 결과값이 정상적으로 처리 된경우 
//         * @param result
//         */
//        @Override
//        public void onSuccess(List<BaseModel> result) {
//            // TODO Auto-generated method stub
////          if(result.size() == 0){
////              cboTgtCombo.setEmptyText("--전 체--");
////          }  
//            
//            storeResult.add(result);
//        }
//        /**
//         * 결과값이 비정상적으로 처리 된 경우 
//         */
//        @Override
//        public void onFailure(Throwable caught) {
//            // TODO Auto-generated method stub
//         
//        }
//    });
//    return storeResult;
//}
//
//
///**
// * 직종세 콤보를 가지고 온다. 
// * @param prgmComBass0350Dto(
// * @return ListStore<BaseModel>
// */
public static final ListStore<BaseModel> getSingleBass0350ComboData(SysIfBass0350DTO sysIfBass0350Dto){
	
	final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
	MSFPkgSmrmfServiceAsync sysIfSmrmfService = MSFPkgSmrmfService.Util.getInstance();
	
	sysIfSmrmfService.getSysIfComboBass0350List(sysIfBass0350Dto, new AsyncCallback<List<BaseModel>>() {
	
		/**
		 * 결과값이 정상적으로 처리 된경우 
		 * @param result
		 */
		@Override
		public void onSuccess(List<BaseModel> result) {
			// TODO Auto-generated method stub
//			if(result.size() == 0){
//				cboTgtCombo.setEmptyText("--전 체--");
//			}  
			
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

///**
// * 
// * <pre>
// * 1. 개요 : 권한 없이 전체 직종세 데이타 가져오기 
// * 2. 처리내용 : 직종세 
// * </pre>
// * @Method Name : getSingleBass0350ComboData
// * @date : Apr 21, 2016
// * @author : leeheuisung
// * @history : 
// *	-----------------------------------------------------------------------
// *	변경일				작성자						변경내용  
// *	----------- ------------------- ---------------------------------------
// *	Apr 21, 2016		leeheuisung				최초 작성 
// *	-----------------------------------------------------------------------
// * 
// * @param prgmComBass0350Dto
// * @return ListStore<BaseModel>
// */
//public static final ListStore<BaseModel> getSingleNonBass0350ComboData(PrgmComBass0350DTO prgmComBass0350Dto){
//	
//	final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
//	PrgmComBass0350ServiceAsync prgmComBass0350Service = PrgmComBass0350Service.Util.getInstance();
//	
//	prgmComBass0350Service.getPrgmComboNonBass0350List(prgmComBass0350Dto, new AsyncCallback<List<BaseModel>>() {
//	
//		/**
//		 * 결과값이 정상적으로 처리 된경우 
//		 * @param result
//		 */
//		@Override
//		public void onSuccess(List<BaseModel> result) {
//			// TODO Auto-generated method stub
////			if(result.size() == 0){
////				cboTgtCombo.setEmptyText("--전 체--");
////			}  
//			
//			storeResult.add(result);
//		}
//		/**
//		 * 결과값이 비정상적으로 처리 된 경우 
//		 */
//		@Override
//		public void onFailure(Throwable caught) {
//			// TODO Auto-generated method stub
//		 
//		}
//	});
//	return storeResult;
//}
		
/************************************* 시점에 따른 사용 부서, 직종, 직종세 데이타를 가져와 넘기는 부분으로 이 부분은 차후 추가 하여 처리할 부분 존재 ******************************/		
	
	
}
 