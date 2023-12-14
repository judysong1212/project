/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.widget;

import java.util.Iterator;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnLovDef;
import com.app.smrmf.core.msfmainapp.client.def.LovDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.generics.Lov;
import com.app.smrmf.core.msfmainapp.client.generics.LovFormWindows;
import com.app.smrmf.core.msfmainapp.client.generics.LovLiveGeneric;
import com.app.smrmf.core.msfmainapp.client.generics.MSFCustomForm;
import com.app.smrmf.core.msfmainapp.client.generics.MSFSimpleForm;
import com.app.smrmf.core.msfmainapp.client.service.GenericService;
import com.app.smrmf.core.msfmainapp.client.service.GenericServiceAsync;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFServiceFailureHandler;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.PreviewEvent;
import com.extjs.gxt.ui.client.util.BaseEventPreview;
import com.extjs.gxt.ui.client.util.KeyNav;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class MSFLovField extends MSFManyTriggerField<String> {

    private GenericServiceAsync appService = GenericService.Util.getInstance();
    private BaseEventPreview eventPreview;
    private Lov lov;
    private LovLiveGeneric lovLiveGeneric;
    private int customWidth;
    protected ColumnDef columnDef;

    public MSFLovField() {

        super(3);
        this.setFirstTriggerStyle("x-form-lov-trigger");
        this.setSecondTriggerStyle("x-form-clear-trigger");
        this.setThirdTriggerStyle("x-form-edit-trigger");
        this.setFirstTriggerStyleOnMouseOver("x-form-trigger-over");
        this.setSecondTriggerStyleOnMouseOver("x-form-trigger-over");
        this.setThirdTriggerStyleOnMouseOver("x-form-trigger-over");
        this.setDelimiter(2);

        this.setWidth(Style.UNDEFINED);

        // click on search trigger
        this.addListener(MSFManyTriggerField.triggerClickEvent[0], new Listener<BaseEvent>() {
            public void handleEvent(BaseEvent be) {
                expand();
                getInputEl().focus();
            }
        });
        // click on clear trigger
        this.addListener(MSFManyTriggerField.triggerClickEvent[1], new Listener<BaseEvent>() {
            public void handleEvent(BaseEvent be) {
                clearBoundFields();
                getInputEl().focus();
            }
        });
        // click on edit trigger
        this.addListener(MSFManyTriggerField.triggerClickEvent[2], new Listener<BaseEvent>() {
            public void handleEvent(BaseEvent be) {
                activityOnBoundRecord("EDIT");
                getInputEl().focus();
            }
        });
        //If user changes manually value of input Lov field, then we must change values 
        //also from all other fields bound to the Lov
        //if field is empty, then clear all bound fiels
        //if field has a value, then make the lookup to see if the ID is correct
        this.addListener(Events.Change, new Listener<BaseEvent>() {
            public void handleEvent(BaseEvent be) {
                //If change comes from a set from the LOV window, then we have the JS-Event filled (we did this in LovLiveGeneric.confirmRecordSelected)
                //In this case we do not have to perform a Lookup
                if ( be!=null && be instanceof FieldEvent ) {
                    FieldEvent fe = (FieldEvent) be;
                    Event event = fe.getEvent();
                    if ( event!=null ) {
                        return;
                    }
                }
                //If change comes from a user input in the field, we must perform a Lookup for inserted value
                if ( MSFSharedUtils.paramNull(getValue()) ) {
                    clearBoundFields();
                    getInputEl().focus();
                } else {
                    activityOnBoundRecord("LOOKUP");
                }
            }
        });
    }

    private void activityOnBoundRecord(final String activity){

        String className = null;
        BaseModel genericObject = null;
        ColumnAttribute[] tableAttributes = null;

        //Look for BaseModel to be associated with EditLovDef
        final TableDef boundTable = lov.getEditLovDef();
        final LovDef lovDef = lov.getLovDef();
        final FormPanel initialForm = getFormPanel();
        if (lovDef!=null && initialForm!=null && initialForm instanceof MSFFormPanel) {
            MSFFormPanel form = (MSFFormPanel)initialForm;
            FormBinding binding = form.getFormBinding();
            if ( binding!=null && binding.getModel()!=null && lovDef.getListColumns()!=null ) {
                genericObject = (BaseModel)binding.getModel();
                if ( genericObject!=null ) {
                    genericObject.set(getItemId(), getValue());
                }
            }
            if ("LOOKUP".equals(activity) && columnDef!=null && columnDef.getParent()!=null ) {
                //tableAttributes = parentColumnDef.getParent().getTableAttributes();
                tableAttributes = lovDef.getTableAttributes();
                className       = columnDef.getParent().getTable();
            } else if ( "EDIT".equals(activity) && boundTable != null ) {
                tableAttributes = boundTable.getTableAttributes();
                if ( form.getMSFGridPanel()!=null && form.getMSFGridPanel().getTableDef()!=null ) {
                    className = form.getMSFGridPanel().getTableDef().getTable();
                } else if ( form.getTableDef()!=null ) {
                    className = form.getTableDef().getTable();
                }
            }
        }

        //Call service to retrieve associated object to edit
        if ( tableAttributes!=null && MSFSharedUtils.paramNotNull(className) ) {

            String associationAttrName  = lov.getAssociationAttributeName();
            String filterAttrName       = lov.getFilterAttributeName();
            String readCustomMethodName = lovDef!=null ? lovDef.getCustomReadMethod() : null;

            //Check if call must be skipped
            if ( !MSFConfiguration.CUSTOM_SERVICE_SKIP_CALL.equals(readCustomMethodName) ) {

                ServiceParameters params = ServiceParameters.getReadParameters(
                        className, genericObject, ActionDatabase.READ, tableAttributes, associationAttrName, filterAttrName, readCustomMethodName);

                appService.readGenericObject(
                        params, 
                        new AsyncCallback<BaseModel>() {
                            public void onFailure(Throwable caught) {
                                MSFServiceFailureHandler handler = new MSFServiceFailureHandler();
                                handler.handleServiceFailure(caught);
                            }
                            public void onSuccess(BaseModel result) {
                                if ( result == null ) {
                                    String id    = MSFSharedUtils.allowNulls(getValue());
                                    String title = MSFMainApp.MSFCONSTANTS.msgErrorServiceInvocationTitoloService();
                                    String msg   = MSFMainApp.MSFMESSAGES.msgNoRecordFound(id);
                                    MessageBox.alert(title, msg, null);
                                } else if ("LOOKUP".equals(activity)) {
                                    handleSuccessLookupRecord(result);
                                } else if ("EDIT".equals(activity)) {
                                    handleSuccessEditRecord(result, boundTable, lovDef, initialForm);
                                }
                            }
                        });

            }

        } //End call service

    }

    public void handleSuccessLookupRecord(BaseModel result) {
        //Update values on bound fields
        LovDef lovDef = lov.getLovDef();
        FormPanel initialForm = getFormPanel();
        if (lovDef!=null && initialForm!=null && initialForm instanceof MSFFormPanel) {
            MSFFormPanel form = (MSFFormPanel)initialForm;
            FormBinding binding = form.getFormBinding();
            lovDef.updateBaseModelForm(result, binding);
        }
    }

    public void handleSuccessEditRecord(BaseModel result, TableDef boundTable, LovDef lovDef, FormPanel initialForm) {
        //Open window to edit/show associated object
        MSFSimpleForm MSFFormPanel = new MSFSimpleForm(
                ActionDatabase.UPDATE, 
                boundTable);
        LovFormWindows myWindows = 
            new LovFormWindows(
                    getFieldLabel(),
                    MSFFormPanel,
                    MSFMainApp.MSFCONSTANTS.BtRefresh(),
                    MSFMainApp.MSFCONSTANTS.BtDelete(),
                    lovDef,
                    initialForm);
        myWindows.setWidth(MSFFormPanel.getWidth()+12);
        myWindows.show();
        MSFFormPanel.setMSFFormWindows(myWindows);
        MSFFormPanel.bind(result);
    }

    public void clearBoundFields() {
        LovDef lovDef = lov.getLovDef();
        FormPanel initialForm = getFormPanel();
        if (lovDef!=null && initialForm!=null && initialForm instanceof MSFFormPanel) {
            MSFFormPanel form = (MSFFormPanel)initialForm;
            FormBinding binding = form.getFormBinding();
            if ( binding!=null && binding.getModel()!=null && lovDef.getListColumns()!=null ) {
                ModelData formModel = binding.getModel();
                Iterator<ColumnLovDef> iter = lovDef.getListColumns().iterator();
                while (iter.hasNext()) {
                    ColumnLovDef columnLovDef = (ColumnLovDef) iter.next();
                    String attrForm = columnLovDef.getAttributeForm();
                    if (MSFSharedUtils.paramNotNull(attrForm)) {
                        formModel.set(attrForm, null);
                    }
                }
            }
        }
    }

    protected void expand() {
        lov.checkDymanicFilter(getFormPanel());
        boolean isNewLov = lov.inizialize();
        lovLiveGeneric = lov.getLovWindow();
        lovLiveGeneric.setInitialForm(getFormPanel());
        lovLiveGeneric.setFieldCaller(this);
        if (!isNewLov) {
            lovLiveGeneric.readData();
        }
        lovLiveGeneric.show();
    }

//    protected void onDown(FieldEvent fe) {
//        fe.cancelBubble();
//        expand();
//    }

    protected void collapseIf(PreviewEvent pe) {
        if (lovLiveGeneric != null) {
            lovLiveGeneric.hide();
        }
    }

    @Override
    protected void onRender(Element target, int index) {
        super.onRender(target, index);
        GWTUtils.setCustomStyles(this);

        this.fixInputTextWidth();
        eventPreview = new BaseEventPreview() {
            @Override
            protected boolean onPreview(PreviewEvent pe) {
                switch (pe.getType().getEventCode()) {
                case Event.ONSCROLL:
                case Event.ONMOUSEWHEEL:
                case Event.ONMOUSEDOWN:
                    collapseIf(pe);
                }
                return true;
            }
        };
        eventPreview.setAutoHide(false);

        new KeyNav<FieldEvent>(this) {
            @Override
            public void onDown(FieldEvent fe) {
                fe.cancelBubble();
                expand();
            }

            @Override
            public void onEsc(FieldEvent fe) {
                if (lovLiveGeneric != null) {
                    lovLiveGeneric.hide();
                }
            }
        };
    }

    public void setLov(Lov lov) {
        this.lov = lov;
    }

    public Lov getLov() {
        return lov;
    }

    public FormPanel getFormPanel(){
        Object o = getData(MSFConfiguration.PROP_FORM_PARENT);
        if (o instanceof MSFFormPanel) {
            return (FormPanel) o;
        }
        return null;
    }

    protected void fixInputTextWidth() {
        Object o = getData(MSFConfiguration.PROP_FORM_PARENT);
        int minusWidth = 0;
        if (o != null) {
            if (o instanceof MSFCustomForm) {
                minusWidth = 20;
            } else {
                minusWidth = 8;
            }
        }
        El input = getInputEl();
        if ( input != null ) {
            int numTriggers = this.getNumberOfTriggers();
            int fullWidth = getWidth(true);
            int triggersWidth = 17*numTriggers;
            int tmpFullWidth   = fullWidth   - 23 - minusWidth - triggersWidth;
            int tmpCustomWidth = customWidth + 12 - minusWidth - triggersWidth;
            int finalWidth = customWidth>0 ? tmpCustomWidth : tmpFullWidth;
            input.setWidth(finalWidth);
            //int numTriggers = this.getNumberOfTriggers();
            //int fullWidth = getWidth(true);
            //fullWidth = fullWidth - 23 - 17*numTriggers - minusWidth;
            //input.setWidth(fullWidth);
        }
    }
    


    //@Override
    public void handleEvent(BaseEvent be) {
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        this.customWidth = width;
    }

    public int getCustomWidth() {
        return customWidth;
    }
    public void setCustomWidth(int customWidth) {
        this.customWidth = customWidth;
    }

    public ColumnDef getColumnDef() {
        return columnDef;
    }
    public void setColumnDef(ColumnDef columnDef) {
        this.columnDef = columnDef;
    }

}
