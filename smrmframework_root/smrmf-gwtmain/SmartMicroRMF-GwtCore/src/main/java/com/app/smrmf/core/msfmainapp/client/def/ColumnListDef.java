/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.def;

import java.util.Iterator;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.event.MSFEvents;
import com.app.smrmf.core.msfmainapp.client.service.GenericService;
import com.app.smrmf.core.msfmainapp.client.service.GenericServiceAsync;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFAsyncCallback;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.widget.MSFComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTrigger;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.binding.FieldBinding;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;

public class ColumnListDef extends ColumnDef{

    protected GenericServiceAsync appService = GenericService.Util.getInstance();
    //protected MSFComboBox<BaseModel> cb;
    protected ListStore<BaseModel> store;
    //    private HiddenField<String> cbHidden;
    protected TableDef tableLKP;
    protected String attrNameId          = "combocode";
    protected String attrNameDescription = "comboname";
    protected boolean skipJoin           = false;
    protected boolean readDataOnCreate   = false;

    //    public ColumnListDef(
    //            String title, 
    //            String attributeName, 
    //            String type, 
    //            int size,
    //            Boolean isRequired, 
    //            Boolean isVisibleInGrid,
    //            Boolean isVisibleInForm,
    //            TableDef tableLKP){
    //
    //        super(title, 
    //                attributeName,
    //                type, 
    //                size,
    //                isRequired, 
    //                isVisibleInGrid,
    //                isVisibleInForm);
    //
    //        this.tableLKP = tableLKP;
    //        this.store = new ListStore<BaseModel>();
    //
    //        readData();
    //    }

    public ColumnListDef(
            String title, 
            String attributeName, 
            int type, 
            int size,
            Boolean isRequired, 
            Boolean isVisibleInGrid,
            Boolean isVisibleInForm,
            TableDef tableLKP,
            String attrNameId,
            String attrNameDescription,
            boolean readDataOnCreate) {

        super(title, 
                attributeName,
                type, 
                size,
                isRequired, 
                isVisibleInGrid,
                isVisibleInForm);

        this.tableLKP            = tableLKP;
        this.store               = new ListStore<BaseModel>();
        this.attrNameId          = GWTUtils.adjustsColumnDefName(attrNameId);
        this.attrNameDescription = GWTUtils.adjustsColumnDefName(attrNameDescription);
        this.readDataOnCreate    = readDataOnCreate;

        if ( this.readDataOnCreate ) {
            readData();
        }

    }

    public ColumnListDef(
            String title, 
            String attributeName, 
            int type, 
            int size,
            Boolean isRequired, 
            Boolean isVisibleInGrid,
            Boolean isVisibleInForm,
            TableDef tableLKP,
            String attrNameId,
            String attrNameDescription){

        this(title, attributeName, type, size, isRequired, isVisibleInGrid, isVisibleInForm, tableLKP, attrNameId, attrNameDescription, true);

    }

    public ColumnAttribute[] getAttributeTableLKP() {
        Iterator<ColumnDef> iter = tableLKP.getColumnsDefinition().iterator();
        ColumnAttribute[] result = new ColumnAttribute[tableLKP.getColumnsDefinition().size()];
        int i = 0;
        while (iter.hasNext()) {
            ColumnDef columnDef = (ColumnDef) iter.next();
            if (MSFSharedUtils.paramNotNull(columnDef.getAttributeName())) {
                ColumnAttribute ca = new ColumnAttribute(columnDef.getAttributeName(), columnDef.getType(), columnDef.getAttributeFormula());
                ca.setLabel(columnDef.getTitle());
                ca.setVisibleInExport(this.isVisibleInExport());
                result[i++] = ca;
            }
        }
        return result;
    }

    public String getTableNameLKP(){
        return tableLKP.getTable();
    }

    public TableDef getTableDef(){
        return tableLKP;
    }

    public MSFComboBox<BaseModel> getCb() {
        return (MSFComboBox<BaseModel>)columnField;
    }

    public void setCb(MSFComboBox<BaseModel> cb) {
        this.columnField = cb;
    }

    public boolean isSkipJoin() {
        return skipJoin;
    }

    public void setSkipJoin(boolean skipJoin) {
        this.skipJoin = skipJoin;
    }

    public boolean isReadDataOnCreate() {
        return readDataOnCreate;
    }

    public void setReadDataOnCreate(boolean readDataOnCreate) {
        this.readDataOnCreate = readDataOnCreate;
    }

    public String getIdHTML() {
        //return transactionId+"."+attributeName;
        //return attributeName;
        String name = tableLKP.getColumnsDefinition().get(1).getAttributeName();
        String idHTML = skipJoin ? super.getIdHTML() : super.getIdHTML() + TableDef.SEPARATOR_CLIENT + name;
        idHTML = super.getIdHTML() + TableDef.SEPARATOR_CLIENT + name;
        return idHTML;
    }

    public void configureMSFField(Field field) {
        MSFComboBox<BaseModel> result = (MSFComboBox<BaseModel>) field;
        result.setColumnDef(this);
        /** 20171014 설정 정보 추가 함 이벤트 확인 해야 함  */
        result.setForceSelection(true);
        result.setMinChars(1);
        /** 20171014 설정 정보 추가 함  */
        result.setDisplayField(attrNameDescription);
        result.setValueField(attrNameId);
        result.setAttrNameDescription(attrNameDescription);
        result.setAttrNameId(attrNameId);
        result.setFieldLabel(super.getTitle());  
        //result.setItemId(getIdHTML() + TableDef.SEPARATOR_CLIENT + attrNameId);
        String idHTML = skipJoin ? super.getIdHTML() : super.getIdHTML() + TableDef.SEPARATOR_CLIENT + attrNameId;
        result.setItemId(idHTML);
        result.setStore(store);
        result.setTypeAhead(true);  
        result.setTriggerAction(TriggerAction.ALL);  
       // result.setEmptyText("선택 ...");
        result.setSelectOnFocus(true);  
        //        result.addListener(Events.Select, new Listener<BaseEvent>() {
        //            public void handleEvent(BaseEvent be) {
        //                if (result.getValue() != null) {
        //                    cbHidden.setValue(result.getValue().get(attrNameCode).toString());
        //                }
        //            }
        //        });
        if (super.getIsRequired()) {
            result.setAllowBlank(false);
            ComboBox<BaseModel>.ComboBoxMessages messagesApp = result.new ComboBoxMessages();
            messagesApp.setBlankText(MSFMainApp.MSFCONSTANTS.CampoObbligatorio());
            result.setMessages(messagesApp);
        }
        if (isReadOnly()) {
            result.disable();
        }
        if (triggers != null) {
            if (triggers.size() > 0) {
                for (final MSFTrigger trigger : triggers) {
                    if (trigger.getListener() != null && trigger.getEventType() != null) {
                        result.addListener(trigger.getEventType(), new Listener<BaseEvent>() {
                            public void handleEvent(BaseEvent be) {
                                Object ojtRst = be.getSource();
                                Field  fldRst = null;
                                Object ojtv = null;
                                if (ojtRst instanceof Field) {
                                	fldRst = (Field)ojtRst;
                                    ojtv = fldRst.getValue();
                                }
                                trigger.getListener().initialize(fldRst);
                                trigger.getListener().run(fldRst, ojtv);
                            }
                        });
                    }
                    
                }
            }
        }
    }

    private MSFComboBox getComboBoxField(MSFComboBox result) {
        if ( result==null ) {
            result = new MSFComboBox();
            result.setWidth(300); 
        }
        configureMSFField(result);
        return result;
    }

    public Field getVisibleField(Field result){
        result = getComboBoxField((MSFComboBox)result);
        return result;
    }

    public Field getField(){
        Field result = getVisibleField();
        columnField = result;
        return result;
    }

    public Field getSearchField() {
        return getField();
    }

//    public Field getField(){
//
//        //        cbHidden = new HiddenField<String>();
//        //        cbHidden.setItemId(getIdHTML() + TableDef.SEPARATOR + BaseRecord.ID);
//
//        cb = new MSFComboBox<BaseModel>(attrNameId, attrNameDescription){
//            @Override
//            protected void onRender(com.google.gwt.user.client.Element target, int index) {
//                super.onRender(target, index);
//                if (!getAllowBlank()) {
//                    setRequiredStyle(this);
//                }
//            }
//        };  
//        cb.setFieldLabel(super.getTitle());  
//        //cb.setItemId(getIdHTML() + TableDef.SEPARATOR_CLIENT + attrNameId);
//        String idHTML = skipJoin ? super.getIdHTML() : super.getIdHTML() + TableDef.SEPARATOR_CLIENT + attrNameId;
//        cb.setItemId(idHTML);
//        cb.setStore(store);
//        cb.setTypeAhead(true);  
//        cb.setTriggerAction(TriggerAction.ALL);  
//        cb.setEmptyText("Seleziona ...");
//        cb.setSelectOnFocus(true);  
//        cb.setWidth(300);
//        //        cb.addListener(Events.Select, new Listener<BaseEvent>() {
//        //            public void handleEvent(BaseEvent be) {
//        //                if (cb.getValue() != null) {
//        //                    cbHidden.setValue(cb.getValue().get(attrNameCode).toString());
//        //                }
//        //            }
//        //        });
//        if (super.getIsRequired()) {
//            cb.setAllowBlank(false);
//            ComboBox<BaseModel>.ComboBoxMessages messagesApp = cb.new ComboBoxMessages();
//            messagesApp.setBlankText(MSFMainApp.MSFCONSTANTS.CampoObbligatorio());
//            cb.setMessages(messagesApp);
//        }
//        if (isReadOnly()) {
//            cb.disable();
//        }
//        if (triggers != null) {
//            if (triggers.size() > 0) {
//                for (final MSFTrigger trigger : triggers) {
//                    if (trigger.getListener() != null && trigger.getEventType() != null) {
//                        cb.addListener(trigger.getEventType(), new Listener<BaseEvent>() {
//                            public void handleEvent(BaseEvent be) {
//                                Object o = be.getSource();
//                                Field  f = null;
//                                Object v = null;
//                                if (o instanceof Field) {
//                                    f = (Field)o;
//                                    v = f.getValue();
//                                }
//                                trigger.getListener().initialize(f);
//                                trigger.getListener().run(f, v);
//                            }
//                        });
//                    }
//                    
//                }
//            }
//        }
//        return cb;
//    }

    //    public Field getFieldCod(){
    //        return cbHidden;
    //    }

    public List<ColumnDef> getColumnsDefinitionLKP() {
        return tableLKP.getColumnsDefinition();
    }

    
    public String getAttrItemId(){
        return attrNameId;
    }
    
    public String getattrNameDescription(){
        return attrNameDescription;
    }

    
    //    public String getAttrNameCode() {
    //        return attrNameCode;
    //    }
    //
    //    public void setAttrNameCode(String attrNameCode) {
    //        this.attrNameCode = attrNameCode;
    //    }
    //
    //    public String getAttrNameDescription() {
    //        return attrNameDescription;
    //    }
    //
    //    public void setAttrNameDescription(String attrNameDescription) {
    //        this.attrNameDescription = attrNameDescription;
    //    }

    public ColumnConfig getColumnConfig(){
        ColumnConfig result = null;
        //final String name = tableLKP.getColumnsDefinition().get(1).getAttributeName();
        //final String idHTML = skipJoin ? getIdHTML() : getIdHTML() + TableDef.SEPARATOR_CLIENT + name;
        final String idHTML = getIdHTML();
        result = new ColumnConfig() {
            {
                //setHeader(getTitle());
            	setHeaderText(getTitle());
                setSortable(true);
                setId(idHTML); 
                setWidth(getSize());
            }
        };
        if (parent.isEditableGrid) {
            setColumnEditor(result);
        }
        if (parent.isEditFieldGrid) {
            setColumnEditor(result);
        }
        if ( gridCellRenderer!=null ) {
            result.setRenderer(gridCellRenderer);
        }
        return result;
    }
    
    
    /**
     * @param columnConfig
     */
    private void setColumnEditor(ColumnConfig columnConfig) {
        final MSFComboBox<BaseModel> combo = (MSFComboBox<BaseModel>) getField();
        CellEditor editor = new CellEditor(combo) {  
            @Override  
            public Object preProcessValue(Object value) { 
                
                if (value == null) {  
                    return value;  
                }
                BaseModel baseModel = Registry.get("currentSelectedRecord");
                String attrId = ColumnListDef.this.getAttributeName()+TableDef.SEPARATOR_CLIENT+combo.getAttrNameId();
                if (baseModel != null) {
                    value = baseModel.get(attrId);
                }
                return combo.getStore().findModel(combo.getAttrNameId(), value);  
            }  

            @Override  
            public Object postProcessValue(Object value) {  
                //이부분은 데이터를 선택하지 않은 콤보처리를 위해 주석  품
                if (value == null) {  
                    return value;  
                }
                BaseModel baseModel = Registry.get("currentSelectedRecord");
                Registry.unregister("currentSelectedRecord");
                String attrId = ColumnListDef.this.getAttributeName()+TableDef.SEPARATOR_CLIENT+combo.getAttrNameId();
                if (baseModel != null) {
                    baseModel.set(attrId, combo.getValue().get(combo.getAttrNameId()));
                }
                return combo.getValue().get(combo.getAttrNameDescription());  
            }  
        };  
        columnConfig.setEditor(editor);
    }

    //	public String getOrderInfo() {
    //		Iterator<ColumnDef> iter = tableLKP.getColumnsDefinition().iterator();
    //		String result = "";
    //		while (iter.hasNext()) {
    //			ColumnDef columnDef = (ColumnDef) iter.next();
    //			if (columnDef.getOrderPosition()>0) {
    //				result = getIdHTML()+SEPARATOR+columnDef.getOrderAttribute()+" "+result;
    //			}
    //		}
    //		return result;
    //	}

    /**
     * Performs the call to the remote service to retrieve data used to fill the combo box.
     */
    public void readData(){
        //Check if call must be skipped
        if ( MSFConfiguration.CUSTOM_SERVICE_SKIP_CALL.equals(getTableDef().getCustomListMethod()) ) {
            return;
        }
        //Remove current values from store associated with the combo box
        //store.removeAll();
        //Perform the remote query with correct parameters
        ServiceParameters params = ServiceParameters.getListParameters(
                getTableDef().getTable(),
                ActionDatabase.LIST,
                getAttributeTableLKP(),
                getTableDef().getTableColumnFilters(),
                getTableDef().getColumnOrders(),
                null,
                getTableDef().getCustomListMethod());
        appService.getListGenericObjects(
                params,
                new MSFAsyncCallback<PagingLoadResult<BaseModel>>(null, "ColumnListDef.readData.getListGenericObjects") {
                    public void onSuccess(PagingLoadResult<BaseModel> result) {
                        //When data is read, clear current values and put new values in the store
                        List<BaseModel> list = result.getData();
                        store.removeAll();
                        store.add(list);
                        //If field is present, call a refresh on the field binding and fire an event that can be used by the user
                        if ( columnField!=null ) {
                            FormBinding formBinding = columnField.getData(MSFConfiguration.PROP_FORM_BINDING);
                            FieldBinding fieldBinding = formBinding!=null ? formBinding.getBinding(columnField) : null;
                            if ( fieldBinding!=null && fieldBinding.getModel()!=null ) {
                                fieldBinding.updateField(true);
                            }
                            columnField.fireEvent(MSFEvents.dataReadInColumnDef, new BaseEvent(columnField));
                         }
                    }
                }
        );
    }

    //    private BaseModel getRecordStore(Store<BaseModel> store, String combocode, String attrNameCode){
    //        Iterator<BaseModel> iter = store.getModels().iterator();
    //        BaseModel baseRecord = null;
    //        while (iter.hasNext()) {
    //            baseRecord = (BaseModel) iter.next();
    //            Object obj = baseRecord.get(attrNameCode);
    //            String value = null;
    //            if (obj instanceof String) {
    //                value = (String)obj;
    //                if (combocode.equals(value)) {
    //                    return baseRecord;
    //                }
    //            } else if (obj instanceof Long) {
    //                value = ((Long)obj).toString();
    //                if (combocode.equals(value)) {
    //                    return baseRecord;
    //                }
    //            } 
    //        }
    //        return null;
    //    }

    public BaseModel getBaseModelByCode(Object codValue) {
        if (codValue != null) {
            for (BaseModel bm : store.getModels()) {
                if (bm.get(attrNameId).equals(codValue)) {
                    return bm;
                }
            }
        }
        return null; 
    }

}


