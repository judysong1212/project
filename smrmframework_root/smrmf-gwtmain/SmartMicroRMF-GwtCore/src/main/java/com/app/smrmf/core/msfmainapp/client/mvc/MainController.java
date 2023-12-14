/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.mvc;



 
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.event.MSFEvents;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.service.GenericService;
import com.app.smrmf.core.msfmainapp.client.service.GenericServiceAsync;
import com.app.smrmf.core.msfmainapp.client.utils.MSFAsyncCallback;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Controller;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;

public class MainController extends Controller {
	
    private GenericServiceAsync appService = GenericService.Util.getInstance();

    public MainController() {
    	
        registerEventTypes(MSFEvents.ActivityOnGenericObjects);
    }

    public void handleEvent(AppEvent event) {
        EventType t = event.getType();
        final Object source = event.getSource();
        if (t == MSFEvents.ActivityOnGenericObjects) {
            if (event.getData() instanceof ServiceParameters) {
                final ServiceParameters serviceParameters = (ServiceParameters)event.getData();
                if (serviceParameters!=null && serviceParameters.getDataObjects().size()>1) {
                    MessageBox.confirm(
                            MSFMainApp.MSFCONSTANTS.Alert(), 
                            MSFMainApp.MSFMESSAGES.msgDeleteRecords(serviceParameters.getDataObjects().size()), 
                            new Listener<MessageBoxEvent>() {
                        public void handleEvent(MessageBoxEvent be) {
                            if ("yes".equals(be.getButtonClicked().getItemId())) {
                                save(serviceParameters, (LayoutContainer) source);
                            }
                        }
                    });
                } else {
                    save(serviceParameters, (LayoutContainer) source);
                }
            }
        }
    }

    private void save(ServiceParameters serviceParameters, final LayoutContainer source) {

        //Check if call must be skipped
        if ( MSFConfiguration.CUSTOM_SERVICE_SKIP_CALL.equals(serviceParameters.getCustomMethodName()) ) {
            return;
        }
        appService.activityOnGenericObject(
                serviceParameters,
                new MSFAsyncCallback<ServiceParameters>(source, "MSFFormPanel.save.activityOnGenericObject", serviceParameters.getActionDatabase()) {
                    public void onSuccess(ServiceParameters result) {
                        if (source instanceof MSFFormPanel) {
                        	MSFFormPanel form = (MSFFormPanel)source;
                            // if the form is not into the window, I bind the first baseModel returned by servlet
                            BaseEvent baseEvent = null;
                            List<BaseModel> returnedObject = null;
                            if (result != null) {
                                returnedObject = result.getDataObjects();
                                baseEvent = new BaseEvent(returnedObject);
                            }
                            if (form.getMSFWindows() != null) {
                                form.getMSFWindows().hide();
//                            } else {
//                                if (returnedObject.size() > 0) {
//                                    BaseModel baseModel = returnedObject.get(0);
//                                    if (baseModel != null) {
//                                        form.bind(baseModel);
//                                        form.getTableDef().refreshObjectLinked(baseModel);
//                                    }
//                                }
                            }
                            form.onSuccessSave();
                            form.fireEvent(MSFFormPanel.OnSuccessSave, baseEvent);
                            form.reload(result);
                        } else if (source instanceof MSFGridPanel) {
                            MSFGridPanel grid = (MSFGridPanel)source;
                            grid.reload();
                        }
                    }
                });
    }
}
