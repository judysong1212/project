package com.app.exterms.prgm.client.util;

import java.util.HashMap;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.dto.PrgmComPayr0470DTO;
import com.app.exterms.prgm.client.dto.PrgmComPayr0480DTO;
import com.app.exterms.prgm.client.service.PrgmComBass0150Service;
import com.app.exterms.prgm.client.service.PrgmComBass0150ServiceAsync;
import com.app.exterms.prgm.client.service.PrgmComBass0300Service;
import com.app.exterms.prgm.client.service.PrgmComBass0300ServiceAsync;
import com.app.exterms.prgm.client.service.PrgmComBass0350Service;
import com.app.exterms.prgm.client.service.PrgmComBass0350ServiceAsync;
import com.app.exterms.prgm.client.service.PrgmComBass0400Service;
import com.app.exterms.prgm.client.service.PrgmComBass0400ServiceAsync;
import com.app.exterms.prgm.client.service.PrgmComBass0500Service;
import com.app.exterms.prgm.client.service.PrgmComBass0500ServiceAsync;
import com.app.exterms.prgm.client.service.PrgmComPayr0470Service;
import com.app.exterms.prgm.client.service.PrgmComPayr0470ServiceAsync;
import com.app.exterms.prgm.client.service.PrgmComPayr0480Service;
import com.app.exterms.prgm.client.service.PrgmComPayr0480ServiceAsync;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class PrgmComComboUtils {
    
	
    public static final ListStore<BaseModel> getSinglePayr0470ComboData(PrgmComPayr0470DTO prgmComPayr0470Dto){
		
		final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
		PrgmComPayr0470ServiceAsync prgmComPayr0470Service = PrgmComPayr0470Service.Util.getInstance();
		
		prgmComPayr0470Service.getPrgmComComboPayr0470List(prgmComPayr0470Dto,new AsyncCallback<List<BaseModel>>() {
		
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
    
    public static final ListStore<BaseModel> getSinglePayr0480ComboData(PrgmComPayr0480DTO prgmComPayr0480Dto){
		
  		final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
  		PrgmComPayr0480ServiceAsync prgmComPayr0480Service = PrgmComPayr0480Service.Util.getInstance();
  		
  		prgmComPayr0480Service.getPrgmComComboPayr0480List(prgmComPayr0480Dto,new AsyncCallback<List<BaseModel>>() {
  		
  			/**
  			 * 결과값이 정상적으로 처리 된경우 
  			 * @param result
  			 */
  			@Override
  			public void onSuccess(List<BaseModel> result) {
  				// TODO Auto-generated method stub
//  				if(result.size() == 0){
//  					cboTgtCombo.setEmptyText("--전 체--");
//  				}  
  				
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
	 * 1. 개요 : 공통코드 데이타 처리  
	 * 2. 처리내용 : 한건에 대한 콤보 데이터를 가지고 와 baseModel을 리턴 한다.
	 *             List<BaseModel> getPrgmComComboBass0300List(PrgmComBass0300DTO prgmComBass0300Dto) 호출 
	 *             displayItem(item01 ~ item20 까지 데이터를 이용해 처리 할 경우 기본 출력의 경우 사용하는 item 셋팅 ) 
	 * </pre>
	 * @Method Name : getSingleBass0300ComboData
	 * @date : Feb 29, 2016
	 * @author : leeheuisung
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	Feb 29, 2016		leeheuisung				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param prgmComBass0300Dto
	 * @return
	 */
	public static final ListStore<BaseModel> getSingleBass0300ComboData(PrgmComBass0300DTO prgmComBass0300Dto){
		
		final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
		PrgmComBass0300ServiceAsync prgmComBass0300Service = PrgmComBass0300Service.Util.getInstance();
		
		prgmComBass0300Service.getPrgmComComboBass0300List(prgmComBass0300Dto,new AsyncCallback<List<BaseModel>>() {
		
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
				//caught.getStackTrace()
			}
		});
		return storeResult;
	}
	 
	
	/**
	 * 
	 * <pre>
	 * 1. 개요 : HshMap에  여러건의 코드 데이터를 가지고 온다.
	 * 2. 처리내용 : ex) ("A001",BaseModel) 형태로 데이터을 HashMap에 대입	  
	 * </pre>
	 * @Method Name : getMultiBass0300ComboData
	 * @date : Apr 21, 2016
	 * @author : leeheuisung
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	Apr 21, 2016		leeheuisung				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param lstRpsttvCd
	 * @return  HashMap<String, List<BaseModel>>
	 */
	public  static  final HashMap<String, List<BaseModel>> getMultiBass0300ComboData(List<String> lstRpsttvCd){
		
		final HashMap<String, List<BaseModel>> hMap = new HashMap<String, List<BaseModel>>(); 
		PrgmComBass0300DTO prgmComBass0300Dto = new PrgmComBass0300DTO(); 
		PrgmComBass0300ServiceAsync prgmComBass0300Service = PrgmComBass0300Service.Util.getInstance();
		
		prgmComBass0300Dto.setArrRpsttvCd(lstRpsttvCd);
		
		prgmComBass0300Service.getPrgmComMultiComboBass0300List(prgmComBass0300Dto,new AsyncCallback<HashMap<String, List<BaseModel>>>() {
		
			/**
			 * 결과값이 정상적으로 처리 된경우 
			 * @param result
			 */
			@Override
			public void onSuccess(HashMap<String, List<BaseModel>> result) {
				// TODO Auto-generated method stub
//				if(result.size() == 0){
//					cboTgtCombo.setEmptyText("--전 체--");
//				}  
				
				hMap.putAll(result);
			}
			/**
			 * 결과값이 비정상적으로 처리 된 경우 
			 */
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
			 
			}
		});
		
		return hMap;
	}
	
	
	/**
	 * HshMap에  여러건의 코드 데이터를 가지고 온다. item에 조건이 존재하는 경우 처리 
	 * ex) ("A001",BaseModel) 형태로 데이터을 HashMap에 대입	  
	 * @param lstRpsttvCd
	 * @return HashMap<String, List<BaseModel>>
	 */
	public static final HashMap<String, List<BaseModel>> getMultiItemBass0300ComboData(List<PrgmComBass0300DTO> lstBass0300DTO,final FormPanel mainForm){
		
		final HashMap<String, List<BaseModel>> hMap = new HashMap<String, List<BaseModel>>(); 
		PrgmComBass0300DTO prgmComBass0300Dto = new PrgmComBass0300DTO(); 
		PrgmComBass0300ServiceAsync prgmComBass0300Service = PrgmComBass0300Service.Util.getInstance();
		  
		prgmComBass0300Service.getPrgmComMultiWithItemComboBass0300List(lstBass0300DTO,new AsyncCallback<HashMap<String, List<BaseModel>>>() {
		    /**
			 * 결과값이 정상적으로 처리 된경우 
			 * @param result
			 */
			@Override
			public void onSuccess(HashMap<String, List<BaseModel>> result) {
				// TODO Auto-generated method stub
//				if(result.size() == 0){
//					cboTgtCombo.setEmptyText("--전 체--");
//				}  
				//panel.fireEvent(MSFEvents.BindLovRecord);
				  
                //panel.fireEvent(Events.Change);
				hMap.putAll(result);
			}
			/**
			 * 결과값이 비정상적으로 처리 된 경우 
			 */
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
			 
			}
		});
		
		return hMap;
	}

	/**
     * 직종 콤보를 가지고 온다. -직종 맵핑에 따른 값가져오기 
     * @param prgmComBass0350Dto(
     * @return ListStore<BaseModel>
     */
    public static final ListStore<BaseModel> getSingleTypOccuCdBass0320ComboData(PrgmComBass0320DTO prgmComBass0320Dto){
        
        final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
        PrgmComBass0350ServiceAsync prgmComBass0350Service = PrgmComBass0350Service.Util.getInstance();
        
        prgmComBass0350Service.getPrgmComComboTypOccuCdList(prgmComBass0320Dto, new AsyncCallback<List<BaseModel>>() { 
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
     * 
     * <pre>
     * 1. 개요 :  권한 없이 직종 가져오기 
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : getSingleNonBass0320ComboData
     * @date : Apr 21, 2016
     * @author : leeheuisung
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	Apr 21, 2016		leeheuisung				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param prgmComBass0320Dto
     * @return
     */
    public static final ListStore<BaseModel> getSingleNonBass0320ComboData(PrgmComBass0320DTO prgmComBass0320Dto){
        
        final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
        PrgmComBass0350ServiceAsync prgmComBass0350Service = PrgmComBass0350Service.Util.getInstance();
        
        prgmComBass0350Service.getPrgmNonTypOccuCdList(prgmComBass0320Dto, new AsyncCallback<List<BaseModel>>() { 
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
	 * 직종세 콤보를 가지고 온다. 
	 * @param prgmComBass0350Dto(
	 * @return ListStore<BaseModel>
	 */
	public static final ListStore<BaseModel> getSingleBass0350ComboData(PrgmComBass0350DTO prgmComBass0350Dto){
		
		final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
		PrgmComBass0350ServiceAsync prgmComBass0350Service = PrgmComBass0350Service.Util.getInstance();
		
		prgmComBass0350Service.getPrgmComComboBass0350List(prgmComBass0350Dto, new AsyncCallback<List<BaseModel>>() {
		
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
	 * 1. 개요 : 권한 없이 전체 직종세 데이타 가져오기 
	 * 2. 처리내용 : 직종세 
	 * </pre>
	 * @Method Name : getSingleBass0350ComboData
	 * @date : Apr 21, 2016
	 * @author : leeheuisung
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	Apr 21, 2016		leeheuisung				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param prgmComBass0350Dto
	 * @return ListStore<BaseModel>
	 */
	public static final ListStore<BaseModel> getSingleNonBass0350ComboData(PrgmComBass0350DTO prgmComBass0350Dto){
		
		final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
		PrgmComBass0350ServiceAsync prgmComBass0350Service = PrgmComBass0350Service.Util.getInstance();
		
		prgmComBass0350Service.getPrgmComboNonBass0350List(prgmComBass0350Dto, new AsyncCallback<List<BaseModel>>() {
		
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
     * 급여 직종세 콤보를 가지고 온다. 
     * @param prgmComBass0350Dto(
     * @return ListStore<BaseModel>
     */
    public static final ListStore<BaseModel> getSinglePayrBass0350ComboData(PrgmComBass0350DTO prgmComBass0350Dto){
        
        final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
        PrgmComBass0350ServiceAsync prgmComBass0350Service = PrgmComBass0350Service.Util.getInstance();
        
        prgmComBass0350Service.getPrgmComComboPayrBass0350List(prgmComBass0350Dto, new AsyncCallback<List<BaseModel>>() {
        
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
	 * 관리부서 콤보 데이터를 가지고 온다.
	 * @param prgmComBass0400Dto
	 * @return
	 */
	public static final  ListStore<BaseModel> getMangDeptBass0400ComboData(PrgmComBass0400DTO prgmComBass0400Dto){
		
		final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
		PrgmComBass0400ServiceAsync prgmComBass0400Service = PrgmComBass0400Service.Util.getInstance();
		
		prgmComBass0400Service.getPrgmComMangDeptBass0400List(prgmComBass0400Dto,new AsyncCallback<List<BaseModel>>() {
		
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
	 * 부서 콤보 데이터를 가지고 온다.
	 * @param prgmComBass0400Dto
	 * @return
	 */
	public static final ListStore<BaseModel> getDeptBass0400ComboData(PrgmComBass0400DTO prgmComBass0400Dto){
		
		final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
		PrgmComBass0400ServiceAsync prgmComBass0400Service = PrgmComBass0400Service.Util.getInstance();
		
		prgmComBass0400Service.getPrgmComWithBass0400List(new AsyncCallback<List<BaseModel>>() {
		
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
     * 급여콤보에서 사용되는  부서 콤보 데이터를 가지고 온다.
     * @param prgmComBass0400Dto
     * @return
     */
    public static final ListStore<BaseModel> getPayrBass0400ComboData(PrgmComBass0400DTO prgmComBass0400Dto){
        
        final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
        PrgmComBass0400ServiceAsync prgmComBass0400Service = PrgmComBass0400Service.Util.getInstance();
        
        prgmComBass0400Service.getPayrWithBass0400List(prgmComBass0400Dto,new AsyncCallback<List<BaseModel>>() {
        
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
	 * 관리부서에 속한 소속부서코드를 가지고 온다.
	 * 
	 * @param prgmComBass0400Dto(mangeDeptCd)
	 * @return
	 */
	public static final ListStore<BaseModel> getMangWithDeptComboData(PrgmComBass0400DTO prgmComBass0400Dto){
		
		final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
		PrgmComBass0400ServiceAsync prgmComBass0400Service = PrgmComBass0400Service.Util.getInstance();
		
		prgmComBass0400Service.getPrgmComDeptBass0400List(prgmComBass0400Dto,new AsyncCallback<List<BaseModel>>() {
		
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
     * 사업년도를 가지고온다.
     * @param prgmComBass0500Dto(년도,부서코드)
     * @return ListStore<BaseModel>
     */
    public static final ListStore<BaseModel> getPrgmComWithBusinApptnYr(PrgmComBass0500DTO prgmComBass0500Dto){
        
        final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
        PrgmComBass0500ServiceAsync prgmComBass0500Service = PrgmComBass0500Service.Util.getInstance();
        
        prgmComBass0500Service.getPrgmComWithBusinApptnYr(prgmComBass0500Dto, new AsyncCallback<List<BaseModel>>() {
        
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
	 * 부서코드 및 년도로 사업 코드를 가지고 온다.
	 * @param prgmComBass0500Dto(년도,부서코드)
	 * @return ListStore<BaseModel>
	 */
	public static final ListStore<BaseModel> getDeptWithBass0500ComboData(PrgmComBass0500DTO prgmComBass0500Dto){
		
		final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
		PrgmComBass0500ServiceAsync prgmComBass0500Service = PrgmComBass0500Service.Util.getInstance();
		
		prgmComBass0500Service.getPrgmComWithBass0500List(prgmComBass0500Dto, new AsyncCallback<List<BaseModel>>() {
		
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
	 * 1. 개요 : 부서코드 다중선택에 따른 여러값을 가지고 온다. 
	 * 2. 처리내용 : prgmComBass0500Dto(년도,부서코드)
	 * </pre>
	 * @Method Name : getDeptWithBass0500ComboData
	 * @date : Feb 17, 2016
	 * @author : leeheuisung
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	Feb 17, 2016		leeheuisung				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param prgmComBass0500Dto
	 * @return
	 */
	public static final ListStore<BaseModel> getDeptWithBass0500MultiCombo(PrgmComBass0500DTO prgmComBass0500Dto){
		
		final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
		PrgmComBass0500ServiceAsync prgmComBass0500Service = PrgmComBass0500Service.Util.getInstance();
		
		prgmComBass0500Service.getPrgmComWithMultiBass0500List(prgmComBass0500Dto, new AsyncCallback<List<BaseModel>>() {
		
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
	 * 단위기관
	 * @param prgmComBass0150Dto 
	 * @return ListStore<BaseModel>
	 */
	public static final ListStore<BaseModel> getDeptBass0150ComboData(PrgmComBass0150DTO prgmComBass0150Dto){
		
		final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
		PrgmComBass0150ServiceAsync prgmComBass0150Service = PrgmComBass0150Service.Util.getInstance();
		
		prgmComBass0150Service.getPrgmComComboBass0150List(prgmComBass0150Dto, new AsyncCallback<List<BaseModel>>() {
		
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
	 
    
 /***************************************권한 처리를 위한 이벤트 확장 수정 *******************************/
	/** 
	 * List<BaseModel> getPrgmComComboBass0300List(PrgmComBass0300DTO prgmComBass0300Dto) 호출 
	 * 데이터 값을 받은 공통 유틸리티 
	 * 한건에 대한 콤보 데이터를 가지고 와 baseModel을 리턴 한다.
	 * @param prgmComBass0300Dto(공통코드 vo)
	 * @param displayItem(item01 ~ item20 까지 데이터를 이용해 처리 할 경우 기본 출력의 경우 사용하는 item 셋팅 )  
	 * @return ListStore<BaseModel> //ListStore<BaseModel>
	 */
	public static final  HashMap<String, Object> getExSingleBass0300ComboData(PrgmComBass0300DTO prgmComBass0300Dto){
		
		final HashMap<String, Object> storeResult = new HashMap<String, Object>(); 
		//final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
		PrgmComBass0300ServiceAsync prgmComBass0300Service = PrgmComBass0300Service.Util.getInstance();
		
		prgmComBass0300Service.getPrgmComComboBass0300List(prgmComBass0300Dto,new AsyncCallback<List<BaseModel>>() {
		
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
	 * HshMap에  여러건의 코드 데이터를 가지고 온다.
	 * ex) ("A001",BaseModel) 형태로 데이터을 HashMap에 대입	  
	 * @param lstRpsttvCd
	 * @return HashMap<String, List<BaseModel>>
	 */
	public  static  final HashMap<String, Object> getExMultiBass0300ComboData(List<String> lstRpsttvCd){
		
		final HashMap<String, Object> storeResult = new HashMap<String, Object>(); 
		//final HashMap<String, List<BaseModel>> storeResult = new HashMap<String, List<BaseModel>>(); 
		PrgmComBass0300DTO prgmComBass0300Dto = new PrgmComBass0300DTO(); 
		PrgmComBass0300ServiceAsync prgmComBass0300Service = PrgmComBass0300Service.Util.getInstance();
		
		prgmComBass0300Dto.setArrRpsttvCd(lstRpsttvCd);
		
		prgmComBass0300Service.getPrgmComMultiComboBass0300List(prgmComBass0300Dto,new AsyncCallback<HashMap<String, List<BaseModel>>>() {
		
			/**
			 * 결과값이 정상적으로 처리 된경우 
			 * @param result
			 */
			@Override
			public void onSuccess(HashMap<String, List<BaseModel>> result) {
				// TODO Auto-generated method stub
//				if(result.size() == 0){
//					cboTgtCombo.setEmptyText("--전 체--");
//				}  
				storeResult.put("syncCallBack", "success");  //권한체크 
				storeResult.put("listStore", result);
				//hMap.putAll(result);
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
	 * HshMap에  여러건의 코드 데이터를 가지고 온다. item에 조건이 존재하는 경우 처리 
	 * ex) ("A001",BaseModel) 형태로 데이터을 HashMap에 대입	  
	 * @param lstRpsttvCd
	 * @return HashMap<String, List<BaseModel>>
	 */
	public static final HashMap<String, Object>  getExMultiItemBass0300ComboData(List<PrgmComBass0300DTO> lstBass0300DTO,final FormPanel mainForm){
		
		final HashMap<String, Object> storeResult = new HashMap<String, Object>(); 
		//final HashMap<String, List<BaseModel>> hMap = new HashMap<String, List<BaseModel>>(); 
		PrgmComBass0300DTO prgmComBass0300Dto = new PrgmComBass0300DTO(); 
		PrgmComBass0300ServiceAsync prgmComBass0300Service = PrgmComBass0300Service.Util.getInstance();
		  
		prgmComBass0300Service.getPrgmComMultiWithItemComboBass0300List(lstBass0300DTO,new AsyncCallback<HashMap<String, List<BaseModel>>>() {
		    /**
			 * 결과값이 정상적으로 처리 된경우 
			 * @param result
			 */
			@Override
			public void onSuccess(HashMap<String, List<BaseModel>> result) {
				// TODO Auto-generated method stub
//				if(result.size() == 0){
//					cboTgtCombo.setEmptyText("--전 체--");
//				}  
				//panel.fireEvent(MSFEvents.BindLovRecord);
				  
                //panel.fireEvent(Events.Change);
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
     * 직종 콤보를 가지고 온다. -직종 맵핑에 따른 값가져오기 
     * @param prgmComBass0350Dto(
     * @return ListStore<BaseModel>
     */
    public static final HashMap<String, Object>  getExSingleTypOccuCdBass0320ComboData(PrgmComBass0320DTO prgmComBass0320Dto){
        
    	final HashMap<String, Object> storeResult = new HashMap<String, Object>(); 
       // final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
        PrgmComBass0350ServiceAsync prgmComBass0350Service = PrgmComBass0350Service.Util.getInstance();
        
        prgmComBass0350Service.getPrgmComComboTypOccuCdList(prgmComBass0320Dto, new AsyncCallback<List<BaseModel>>() { 
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
	 * 직종세 콤보를 가지고 온다. 
	 * @param prgmComBass0350Dto(
	 * @return ListStore<BaseModel>
	 */
	public static final HashMap<String, Object>  getExSingleBass0350ComboData(PrgmComBass0350DTO prgmComBass0350Dto){
		
		final HashMap<String, Object> storeResult = new HashMap<String, Object>(); 
		//final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
		PrgmComBass0350ServiceAsync prgmComBass0350Service = PrgmComBass0350Service.Util.getInstance();
		
		prgmComBass0350Service.getPrgmComComboBass0350List(prgmComBass0350Dto, new AsyncCallback<List<BaseModel>>() {
		
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
     * 급여 직종세 콤보를 가지고 온다. 
     * @param prgmComBass0350Dto(
     * @return ListStore<BaseModel>
     */
    public static final HashMap<String, Object>  getExSinglePayrBass0350ComboData(PrgmComBass0350DTO prgmComBass0350Dto){
        
    	final HashMap<String, Object> storeResult = new HashMap<String, Object>(); 
        //final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
        PrgmComBass0350ServiceAsync prgmComBass0350Service = PrgmComBass0350Service.Util.getInstance();
        
        prgmComBass0350Service.getPrgmComComboPayrBass0350List(prgmComBass0350Dto, new AsyncCallback<List<BaseModel>>() {
        
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
	 * 관리부서 콤보 데이터를 가지고 온다.
	 * @param prgmComBass0400Dto
	 * @return
	 */
	public static final  HashMap<String, Object>  getExMangDeptBass0400ComboData(PrgmComBass0400DTO prgmComBass0400Dto){
		
		final HashMap<String, Object> storeResult = new HashMap<String, Object>(); 
		//final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
		PrgmComBass0400ServiceAsync prgmComBass0400Service = PrgmComBass0400Service.Util.getInstance();
		
		prgmComBass0400Service.getPrgmComMangDeptBass0400List(prgmComBass0400Dto, new AsyncCallback<List<BaseModel>>() {
		
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
	 * 부서 콤보 데이터를 가지고 온다.
	 * @param prgmComBass0400Dto
	 * @return
	 */
	public static final HashMap<String, Object>  getExDeptBass0400ComboData(PrgmComBass0400DTO prgmComBass0400Dto){
		
		final HashMap<String, Object> storeResult = new HashMap<String, Object>(); 
		//final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
		PrgmComBass0400ServiceAsync prgmComBass0400Service = PrgmComBass0400Service.Util.getInstance();
		
		prgmComBass0400Service.getPrgmComWithBass0400List(new AsyncCallback<List<BaseModel>>() {
		
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
     * 급여콤보에서 사용되는  부서 콤보 데이터를 가지고 온다.
     * @param prgmComBass0400Dto
     * @return
     */
    public static final HashMap<String, Object>  getExPayrBass0400ComboData(PrgmComBass0400DTO prgmComBass0400Dto){
        
    	final HashMap<String, Object> storeResult = new HashMap<String, Object>(); 
        //final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
        PrgmComBass0400ServiceAsync prgmComBass0400Service = PrgmComBass0400Service.Util.getInstance();
        
        prgmComBass0400Service.getPayrWithBass0400List(prgmComBass0400Dto,new AsyncCallback<List<BaseModel>>() {
        
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
	 * 관리부서에 속한 소속부서코드를 가지고 온다.
	 * 
	 * @param prgmComBass0400Dto(mangeDeptCd)
	 * @return
	 */
	public static final HashMap<String, Object>  getExMangWithDeptComboData(PrgmComBass0400DTO prgmComBass0400Dto){
		
		final HashMap<String, Object> storeResult = new HashMap<String, Object>(); 
		//final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
		PrgmComBass0400ServiceAsync prgmComBass0400Service = PrgmComBass0400Service.Util.getInstance();
		
		prgmComBass0400Service.getPrgmComDeptBass0400List(prgmComBass0400Dto,new AsyncCallback<List<BaseModel>>() {
		
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
     * 사업년도를 가지고온다.
     * @param prgmComBass0500Dto(년도,부서코드)
     * @return ListStore<BaseModel>
     */
    public static final HashMap<String, Object>  getExPrgmComWithBusinApptnYr(PrgmComBass0500DTO prgmComBass0500Dto){
        
    	final HashMap<String, Object> storeResult = new HashMap<String, Object>(); 
       // final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
        PrgmComBass0500ServiceAsync prgmComBass0500Service = PrgmComBass0500Service.Util.getInstance();
        
        prgmComBass0500Service.getPrgmComWithBusinApptnYr(prgmComBass0500Dto, new AsyncCallback<List<BaseModel>>() {
        
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
	 * 부서코드 및 년도로 사업 코드를 가지고 온다.
	 * @param prgmComBass0500Dto(년도,부서코드)
	 * @return ListStore<BaseModel>
	 */
	public static final HashMap<String, Object>  getExDeptWithBass0500ComboData(PrgmComBass0500DTO prgmComBass0500Dto){
		
		final HashMap<String, Object> storeResult = new HashMap<String, Object>(); 
		//final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
		PrgmComBass0500ServiceAsync prgmComBass0500Service = PrgmComBass0500Service.Util.getInstance();
		
		prgmComBass0500Service.getPrgmComWithBass0500List(prgmComBass0500Dto, new AsyncCallback<List<BaseModel>>() {
		
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
	 * 
	 * <pre>
	 * 1. 개요 : 부서코드 다중선택에 따른 여러값을 가지고 온다. 
	 * 2. 처리내용 : prgmComBass0500Dto(년도,부서코드)
	 * </pre>
	 * @Method Name : getDeptWithBass0500ComboData
	 * @date : Feb 17, 2016
	 * @author : leeheuisung
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	Feb 17, 2016		leeheuisung				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param prgmComBass0500Dto
	 * @return
	 */
	public static final HashMap<String, Object>  getExDeptWithBass0500MultiCombo(PrgmComBass0500DTO prgmComBass0500Dto){
		
		final HashMap<String, Object> storeResult = new HashMap<String, Object>(); 
		//final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
		PrgmComBass0500ServiceAsync prgmComBass0500Service = PrgmComBass0500Service.Util.getInstance();
		
		prgmComBass0500Service.getPrgmComWithMultiBass0500List(prgmComBass0500Dto, new AsyncCallback<List<BaseModel>>() {
		
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
	 * 단위기관
	 * @param prgmComBass0150Dto 
	 * @return ListStore<BaseModel>
	 */
	public static final HashMap<String, Object>  getExDeptBass0150ComboData(PrgmComBass0150DTO prgmComBass0150Dto){
		
		final HashMap<String, Object> storeResult = new HashMap<String, Object>(); 
		//final ListStore<BaseModel> storeResult = new ListStore<BaseModel>(); 
		PrgmComBass0150ServiceAsync prgmComBass0150Service = PrgmComBass0150Service.Util.getInstance();
		
		prgmComBass0150Service.getPrgmComComboBass0150List(prgmComBass0150Dto, new AsyncCallback<List<BaseModel>>() {
		
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
	 
	
}
 