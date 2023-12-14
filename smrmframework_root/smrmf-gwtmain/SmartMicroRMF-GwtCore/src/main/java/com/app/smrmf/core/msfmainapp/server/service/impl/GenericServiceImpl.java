/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.server.service.impl;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnOrder;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.service.GenericService;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerContext;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

@Service("GenericService") 
public class GenericServiceImpl  extends AbstractCustomServiceImpl  implements GenericService {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(GenericServiceImpl.class);
    private static final String calledClass = GenericServiceImpl.class.getName();
   
	public ServiceParameters activityOnGenericObject(
            ServiceParameters serviceParameters
            ) throws MSFException {

        String calledMethod = calledClass + "activityOnGenericObject";
        //RpcConfigServiceServlet();  
        //TODO 확인 후 처리 
        MSFServerContext.initUserInfo(RemoteServiceUtil.getThreadLocalRequest(), RemoteServiceUtil.getThreadLocalResponse(), RemoteServiceUtil.getThreadLocalContext(), RemoteServiceUtil.getThreadLocalConfig());

        MSFSysm0100BM user = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());

        String className                  = serviceParameters.getClsName();
        List<BaseModel> listObjects       = serviceParameters.getDataObjects();
        ActionDatabase actionDatabase     = serviceParameters.getActionDatabase(); 
        String customMethodName           = serviceParameters.getCustomMethodName();
        ColumnAttribute[] tableAttributes = serviceParameters.getTableAttributes();
        Boolean reloadData                = serviceParameters.isReloadData();
        Boolean noHistory                 = serviceParameters.isNoHistory(); 
        
        MSFLogHistoryUtils.tracerUserActivity( user
								                ,calledMethod
								                ,className
								                , actionDatabase.toString()
                							  );
 
        List<BaseModel> listReturnObjects = new ArrayList<BaseModel>();
        //TODO 메서드를 반드시 호출하여 처리 해야 함 그냥 처리해서은 안됨..현재 hibernate 기준으로 되어 있음. 수정완료해야함.
        if ( MSFSharedUtils.paramNull(customMethodName) ) { 
        	
        	 List<BaseModel> outbm = null;
        	 String customMethod = serviceParameters.getClsName();
             int lastDotIdx = customMethod.lastIndexOf(".");
             String clsName = customMethod.substring(0, lastDotIdx);
             String methodName = customMethod.substring(lastDotIdx+1);
             try {
            	 
				Object handler = Class.forName(clsName).newInstance();

				  if ( handler!=null ) { 
			            //	Class cls = target.getClass();
			            	Method  method   = handler.getClass().getDeclaredMethod(methodName, new Class[]{ServiceParameters.class});
			            	outbm = (List<BaseModel>)method.invoke(handler, new Object[]{serviceParameters});
			            	
			      }
				listReturnObjects.addAll(outbm);
				  
			//	Method method = org.springframework.util.ReflectionUtils.findMethod(handler, methodName, new Class[]{ServiceParameters.class});		    
	        //	Object name =  org.springframework.util.ReflectionUtils.invokeMethod("activityOnVoceMenuProfile",handler);
            } catch (Exception ex) {
//			} catch (InstantiationException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IllegalAccessException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (SecurityException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
             
           
        	
//            for (BaseModel object : listObjects) {
//                BaseModel outbm = GenericDaoUtils.activityOnGenericObject(
//                        className, 
//                        object, 
//                        actionDatabase, 
//                        tableAttributes, 
//                        user,
//                        reloadData,
//                        noHistory);
//                listReturnObjects.add(outbm);
//            }
          //   throw MSFServerUtils.getSimpleMessageException("readGenericObject()", "현재자동처리는 지원하지 않음", logger);
        } else {
            BaseModel outbm = MSFServerUtils.invokeCustomSaveMethod(
                    serviceParameters, user, RemoteServiceUtil.getThreadLocalRequest(), RemoteServiceUtil.getThreadLocalResponse(), RemoteServiceUtil.getThreadLocalContext(), RemoteServiceUtil.getThreadLocalConfig());
            listReturnObjects.add(outbm);
        }
        ServiceParameters result = ServiceParameters.getDelParameters(null, listReturnObjects, actionDatabase, null);
        return result;

    }

    public BaseModel readGenericObject(ServiceParameters serviceParameters) throws MSFException {

        String calledMethod = calledClass + "readGenericObject";
      //  RpcConfigServiceServlet();  
        //TODO 확인후 처리 
         MSFServerContext.initUserInfo(RemoteServiceUtil.getThreadLocalRequest(), RemoteServiceUtil.getThreadLocalResponse(), RemoteServiceUtil.getThreadLocalContext(), RemoteServiceUtil.getThreadLocalConfig());

        MSFSysm0100BM user = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());

        String className                  = serviceParameters.getClsName(); 
        List<BaseModel> listObjects       = serviceParameters.getDataObjects();
        ActionDatabase actionDatabase     = serviceParameters.getActionDatabase(); 
        String customMethodName           = serviceParameters.getCustomMethodName();
        ColumnAttribute[] tableAttributes = serviceParameters.getTableAttributes();
        String associationAttrName        = serviceParameters.getAssociationAttrName();
        String filterAttrName             = serviceParameters.getFilterAttrName();
        BaseModel object = listObjects!=null && listObjects.size()>=0 ? listObjects.get(0) : null;

        MSFLogHistoryUtils.tracerUserActivity( user
                ,calledMethod
                ,className
                , actionDatabase.toString()
			  );

        BaseModel result = null;
        //TODO 메서드를 반드시 호출하여 처리 해야 함 그냥 처리해서은 안됨..현재 hibernate 기준으로 되어 있음. 수정완료해야함.
        if ( MSFSharedUtils.paramNull(customMethodName) ) {
            // result = GenericDaoUtils.readGenericObject(
            //        className, object, tableAttributes, associationAttrName, filterAttrName);
        	  throw MSFServerUtils.getSimpleMessageException("readGenericObject()", "현재자동처리는 지원하지 않음", logger);
        } else {
            result = MSFServerUtils.invokeCustomReadMethod(
                    serviceParameters, user,  RemoteServiceUtil.getThreadLocalRequest(), RemoteServiceUtil.getThreadLocalResponse(), RemoteServiceUtil.getThreadLocalContext(), RemoteServiceUtil.getThreadLocalConfig());
        }

        return result;

    }

    public PagingLoadResult<BaseModel> getListGenericObjects(
            ServiceParameters serviceParameters
    ) throws MSFException {

        String calledMethod = calledClass + ".getListGenericObjects";
       // RpcConfigServiceServlet();  
        //TODO 확인 후 처리 
        MSFServerContext.initUserInfo(RemoteServiceUtil.getThreadLocalRequest(), RemoteServiceUtil.getThreadLocalResponse(), RemoteServiceUtil.getThreadLocalContext(), RemoteServiceUtil.getThreadLocalConfig());

        MSFSysm0100BM user = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());

        String className                  = serviceParameters.getClsName(); 
        ActionDatabase actionDatabase     = serviceParameters.getActionDatabase(); 
        String customMethodName           = serviceParameters.getCustomMethodName();

       //TODO  로그주석 나중에 확인 후 출기 
        MSFLogHistoryUtils.tracerUserActivity( user
                ,calledMethod
                ,className
                , actionDatabase.toString()
			  );

        PagingLoadResult<BaseModel> result = null;
        //TODO 메서드를 반드시 호출하여 처리 해야 함 그냥 처리해서은 안됨..현재 hibernate 기준으로 되어 있음. 수정완료해야함.
        if ( MSFSharedUtils.paramNull(customMethodName) ) {
           // result = GenericDaoUtils.getListGenericObjectsMap(serviceParameters);
            throw MSFServerUtils.getSimpleMessageException(calledMethod, "현재자동처리는 지원하지 않음", logger);
        } else {
            result = MSFServerUtils.invokeCustomListMethod(
                    serviceParameters, user, RemoteServiceUtil.getThreadLocalRequest(), RemoteServiceUtil.getThreadLocalResponse(), RemoteServiceUtil.getThreadLocalContext(), RemoteServiceUtil.getThreadLocalConfig());
        }

        return result;

    }

    public String exportXLSGenericObjects(
            ServiceParameters serviceParameters
    ) throws MSFException {

        String calledMethod = calledClass + "exportXLSGenericObjects";
       // RpcConfigServiceServlet();  
        //TODO 확인 후 처리 
        MSFServerContext.initUserInfo(RemoteServiceUtil.getThreadLocalRequest(), RemoteServiceUtil.getThreadLocalResponse(), RemoteServiceUtil.getThreadLocalContext(), RemoteServiceUtil.getThreadLocalConfig());

        String result = "";
        try {
            result = "XLS_"+System.currentTimeMillis();
            HttpSession httpSession =  RemoteServiceUtil.getThreadLocalSession();
            httpSession.setAttribute(result, serviceParameters);

            MSFSysm0100BM user = MSFServerUtils.getLoggedUser( RemoteServiceUtil.getThreadLocalRequest());

            String className                  = serviceParameters.getClsName(); 
            ActionDatabase actionDatabase     = serviceParameters.getActionDatabase(); 

            MSFLogHistoryUtils.tracerUserActivity( user
	                ,calledMethod
	                ,className
	                , actionDatabase.toString()
				  );

        } catch (Exception ex) {
            throw MSFServerUtils.getOperationException("exportXLSGenericObjects()", ex, logger);
        }

        return result;
    }

    public List<BaseModel> getSampleValues(
            String            paramString, 
            BaseModel         paramBaseModel, 
            ColumnAttribute[] paramColumnAttribute, 
            IColumnFilter     paramColumnFilter, 
            List<ColumnOrder> paramColumnOrder,
            PagingLoadConfig  paramPagingLoadConfig,
            ActionDatabase    paramActionDatabase) {

        List<BaseModel> retval = new ArrayList<BaseModel>();
        return retval;

    }

}
