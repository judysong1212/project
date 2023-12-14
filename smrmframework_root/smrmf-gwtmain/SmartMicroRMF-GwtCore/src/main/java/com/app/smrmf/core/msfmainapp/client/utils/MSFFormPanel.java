/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.binding.BaseRecordBinding;
import com.app.smrmf.core.msfmainapp.client.binding.RadioGroupBinding;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.event.MSFEvents;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.widget.CustomLayoutMultiField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFComboBox;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import com.extjs.gxt.ui.client.binding.FieldBinding;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FormEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Timer;


public abstract class MSFFormPanel extends FormPanel  {

    public static final EventType OnSuccessSave = new EventType();
    public static final EventType OnFailureSave = new EventType();
    public static final EventType OnClearState  = new EventType();

    //    public enum StateForm {
    //        INSERT, QUERY, UPDATE
    //    }
  //implements IsSerializable 
    public enum ActionDatabase  { 
        INSERT, UPDATE, DELETE, EXPORT, READ, LIST, CUSTOM
    }

    private FormBinding formBinding;
    protected MSFGridPanel caller;
    protected ActionDatabase actionDatabase;
    //    protected StateForm stateForm;
    protected TableDef tableDef;
    protected MSFFormWindows msfWindows;
    private boolean isEnabled = true;
    private boolean isDirty = false;
    private List<Field<?>> listDisableItem = new ArrayList<Field<?>>();
    //    private GenericServiceAsync appService = GenericService.Util.getInstance();
    protected int width;
    protected LayoutContainer customLayoutContainer;

    

    @Override
    protected void onRender(Element target, int index) {
        super.onRender(target, index);
        //If ShowChangeHistory is enabled in tableDef, we add a context menu that allows the user
        //to show histoy data for selected record
 //TODO 선택된 레코드 .....보이기...임시주석       생각 
//        if (tableDef.getEnableHistoryView()) {
//            Menu menu = new Menu();
//            final MenuItem itemShowHistory = new MenuItem(MSFMainApp.MSFCONSTANTS.ShowHistoryLite());
//            menu.add(itemShowHistory);
//            itemShowHistory.addListener(Events.OnMouseOver, new Listener<BaseEvent>() {
//                @Override
//                public void handleEvent(BaseEvent be) {
//                    ModelData bm = formBinding.getModel();
//                    GWTUtils.showListHistoricDataWindow(bm, tableDef);
//                }
//            });
//            this.setContextMenu(menu);
//        }
    }

    public void clear() {
        //        super.clear();
        // Viene effettuato il clean dei soli campi testo        
        for (Field<?> f : getFields()) {
            if (!(f instanceof LabelField)){
                f.clear(); 
            }
        }
        if (this.formBinding != null) {
            this.formBinding.clear();
        }
    }

    public void reset() {
        super.reset();
        if (this.formBinding != null) {
            this.formBinding.clear();
        }
    }

    public void reload(ServiceParameters result){
        if (caller != null) {
            caller.reload(result);
        }
    }

    public void reload(){
        if (caller != null) {
            caller.reload();
        }
    }

    public abstract boolean isValid();

    public FormBinding getFormBinding() {
        return formBinding;
    }

    public void setFormBinding(FormBinding formBinding) {
        this.formBinding = formBinding;
        //        this.formBinding.setFiresEvents(false);
    }

    public void save() {
        //        appService.activityOnGenericObject(
        //                tableDef.getTable(), 
        //                getGenericObject(), 
        //                actionDatabase,
        //                new MSFAsyncCallback<Long>(this, "MSFFormPanel.salva.activityOnGenericObject", actionDatabase) {
        //
        //                    //public void onFailure(Throwable caught) {
        //                    //    if ( caught instanceof MSFException ) {
        //                    //        
        //                    //    } else {
        //                    //        String title = MSFMainApp.MSFCONSTANTS.ExceptionTitleService();
        //                    //        String msg = MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnGenericObjectWithRefl (" + actionDatabase.name() + "):")+"\n"+caught;
        //                    //        MessageBox.alert(title, msg, null);
        //                    //        onFailureSave();
        //                    //    }
        //                    //}
        //
        //                    public void onSuccess(Long result) {
        //                        if (msfWindows != null) {
        //                            msfWindows.hide();
        //                        }
        //                        onSuccessSave();
        //                        ricarica();
        //                    }
        //                });
        final FileUploadField fileUploadField = existsFileUploadField();
        if (fileUploadField != null && 
            !MSFSharedUtils.isEmpty(fileUploadField.getValue()) &&
            (
                    ActionDatabase.INSERT.equals(actionDatabase) ||
                    (
                            ActionDatabase.UPDATE.equals(actionDatabase) &&
                            !fileUploadField.getValue().equals(fileUploadField.getOriginalValue())
                    )
            ))
        {
            final Tracker tracker = new Tracker();
            tracker.setStatus(false);
            
            String urlServlet = fileUploadField.getData("urlServlet");
            
            setAction(GWT.getModuleBaseURL() + urlServlet);//"FileUpload");  
            setEncoding(Encoding.MULTIPART);  
            setMethod(Method.POST);  
            addListener(Events.Submit, new Listener<FormEvent>(){
                public void handleEvent(FormEvent be) {
                    tracker.setStatus(true);
                    if ("TOO-MUCH-SIZE".equals(be.getResultHtml()))
                        fileUploadField.markInvalid(MSFMainApp.MSFMESSAGES.msgFileTooBig());
                    else if ("NO-SCRIPT-DATA".equals(be.getResultHtml()))
                        fileUploadField.markInvalid(MSFMainApp.MSFMESSAGES.msgFileNotValid());
                    else if ("ERROR-WRITE-FILE".equals(be.getResultHtml()))
                        fileUploadField.markInvalid(MSFMainApp.MSFMESSAGES.msgFileWriteError());
                    else {
                        String fileName = be.getResultHtml()==null?"":be.getResultHtml();
                        formBinding.getModel().set(fileUploadField.getName(), fileName);
                        FieldBinding binding = formBinding.getBinding(fileUploadField);
                        if (binding != null) {
                            binding.updateField(true);
                        }
                        //TODO: forse non passa il valore a binding
                        callDispatcher();
                    }
                }
            });

            submit();
            //Progress bar for upload
            final MessageBox box = MessageBox.wait("Progress", "Uploading File, please wait...", "Uploading...");
            final Timer t = new Timer()
            {
                public void run()
                {
                    if (tracker.getStatus())
                    {
                        cancel();
                        box.close();
                    }
                }
            };
            t.scheduleRepeating(500);
        } else {
            callDispatcher();
        }
    }

    private void callDispatcher() {
        AppEvent appEvent = new AppEvent(
                MSFEvents.ActivityOnGenericObjects, 
                ServiceParameters.getCrtUpdDelParameters(
                        tableDef.getTable(), 
                        getGenericObject(), 
                        tableDef.getTableAttributes(),
                        actionDatabase, 
                        tableDef.getCustomSaveMethod(),
                        tableDef.isReloadData()));
        appEvent.setSource(this);
        Dispatcher.forwardEvent(appEvent);
    }

    protected void onFailureSave() {
        final FileUploadField fileUploadField = existsFileUploadField();
        if (fileUploadField != null && !MSFSharedUtils.isEmpty(fileUploadField.getValue()) && ActionDatabase.INSERT.equals(actionDatabase)) {
            String fileName = fileUploadField.getValue();
            fileName = fileName.substring(fileName.indexOf('.')+1);

            formBinding.getModel().set(fileUploadField.getName(), fileName);
            FieldBinding binding = formBinding.getBinding(fileUploadField);
            if (binding != null) {
                binding.updateField(true);
            }
        }
    }

    public abstract void onSuccessSave();

    /**
     * @return a GenericObject (BaseModel) to send at the server. 
     * This object is taken from FormBinding, but if this is null, I read every fieldBindig 
     * and build manually the BaseModel 
     */
    protected BaseModel getGenericObject(){
        BaseModel go = new BaseModel();
        ModelData model = formBinding.getModel();
        // Patch to set value of the editor HTML into the model of the formbinding 
        
//        HtmlEditor editor = null;
//        for (FieldBinding binding : formBinding.getBindings()) {
//            Field field = binding.getField();
//            if (field != null) {
//                if (field instanceof HtmlEditor) {
//                    editor = (HtmlEditor)field;
//                    String value = editor.getValue();
//                    model.set(binding.getProperty(), value);
//                }
//            }
//
//        }
        go.setProperties((Map<String, Object>) model.getProperties());
        rewriteBaseModel(go);
        return go;
    }

    private void rewriteBaseModel(BaseModel bm) {
        Iterator<String> iter = bm.getPropertyNames().iterator();
        while (iter.hasNext()) {
            String key = (String) iter.next();
            Object object = bm.get(key);
            if (object instanceof BaseModel) {
                BaseModel bmDetail = (BaseModel) object;
                if (bmDetail instanceof BaseModel) {
                    Object objectDetail = bmDetail.get("id"); //TODO controllare
                    bm.remove(key);
                    bm.set(key, objectDetail);
                } else {
                    Iterator<String> iterDetail = bmDetail.getPropertyNames().iterator();
                    while (iterDetail.hasNext()) {
                        String keyDetail = (String) iterDetail.next();
                        Object objectDetail = bmDetail.get(keyDetail);
                        if (objectDetail instanceof BaseModel) {
                            rewriteBaseModel((BaseModel)objectDetail);
                        } else {
                            bm.set(key+TableDef.SEPARATOR_CLIENT+keyDetail, objectDetail);
                        }
                    }
                    bm.remove(key);
                }
            }

        }
    }

    /**
     * This method binds the BaseModel into the form and clears all the dirty field
     * @param model It's the currently record selected from the grid
     */
    public void bind(ModelData model){
        if (formBinding != null && model != null) {
            formBinding.bind(model);
            //            clearDirtyFields();
        }
    }

    public boolean isEnabled(){
        return this.isEnabled;
    }

    public void disable(){
        if (isEnabled) {
            this.isEnabled = false;
            for (Field<?> f : getFields()) {
                disable(f);
            }
        }
    }

    private void disable(Field<?> f){
        if ( f instanceof CustomLayoutMultiField ) {
            List<Field<?>> fields = ((CustomLayoutMultiField<Field<?>>)f).getAll();
            for (Field<?> cf : fields ) {
                disable(cf);
            }
        } else {
            if (!f.isEnabled()) {
                listDisableItem.add(f);
            }
            f.disable();
        }
    }

    public void enable(){
        if (!isEnabled) {
            this.isEnabled = true;
            for (Field<?> f : getFields()) {
                enable(f);
            }
        }
    }

    private void enable(Field<?> f){
        if ( f instanceof CustomLayoutMultiField ) {
            List<Field<?>> fields = ((CustomLayoutMultiField<Field<?>>)f).getAll();
            for (Field<?> cf : fields ) {
                enable(cf);
            }
        } else {
            if (listDisableItem.indexOf(f) < 0) {
                f.enable();
            }
        }
    }

    protected void setDirtyField(Field f) {
        this.isDirty = true;
        El el = f.el();
        El child = el.firstChild();
        child.addStyleName("x-grid3-dirty-cell");
    }

    protected void clearDirtyField(Field f) {
        f.setOriginalValue(f.getValue());
        //        f.removeStyleName("x-grid3-dirty-cell");
        if (f.isRendered() && f.el()!=null && f.el().firstChild()!=null) {
            El el = f.el();
            El child = el.firstChild();
            child.removeStyleName("x-grid3-dirty-cell");
        }
    }

    public void clearDirtyFields(){
        for (FieldBinding f : formBinding.getBindings()) {
            Field field = f.getField();
            clearDirtyField(field);
        }
        this.isDirty = false;
    }

    public void cancelChangeFields(){
        for (FieldBinding f : formBinding.getBindings()) {
            Field field = f.getField();
            field.reset();
            if (field.isRendered()) {
                El el = field.el();
                El child = el.firstChild();
                child.removeStyleName("x-grid3-dirty-cell");
            }
        }
        this.isDirty = false;
        fireEvent(OnClearState,new BaseEvent(this));
    }

    public void clearStateFields(){
        for (FieldBinding f : formBinding.getBindings()) {
            Field field = f.getField();
            field.clearInvalid();
        }
        this.isDirty = false;
    }

    /**
     * Returns true if any of the form's fields are dirty
     */
    public boolean isDirty(){
        return this.isDirty;
    }

    public void setMSFFormWindows(MSFFormWindows msfWindows) {
        this.msfWindows = msfWindows;
    }

    public MSFFormWindows getMSFWindows() {
        return msfWindows;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
        super.setWidth(width);
    }

    public ActionDatabase getActionDatabase() {
        return actionDatabase;
    }

    /**
     * Set type of action on database. See static attributes 
     */
    public void setActionDatabase(ActionDatabase actionDatabase) {
        this.actionDatabase = actionDatabase;
    }

    public MSFGridPanel getMSFGridPanel() {
        return caller;
    }

    public void setMSFGridPanel(MSFGridPanel caller) {
        this.caller = caller;
    }

    public void restoreValues() {
        for (FieldBinding f : formBinding.getBindings()) {
            Field field = f.getField();
            field.reset();
            f.updateModel();
        }        
    }

    public TableDef getTableDef() {
        return tableDef;
    }

    //    public StateForm getStateForm() {
    //        return stateForm;
    //    }
    //
    //    public void setStateForm(StateForm stateForm) {
    //        this.stateForm = stateForm;
    //    }

    protected void setCustomLayout(List<ColumnDef> listaColonne, String labelSeparator) {

        setFormBinding(new FormBinding(this));
        final FormData formData = new FormData("0");

        //Ciclo sui fields della TableDef e cerco nel CustomFormPanel un field con lo stesso ID per farci sopra il binding
        for (ColumnDef columnDef : listaColonne) {
            Field columnField = columnDef.getField();
            final String itemId = columnField.getItemId();

            String labelText = columnDef.getTitle();
            String labelFieldText = MSFSharedUtils.paramNotNull(labelText) ? labelText+labelSeparator : "";

            //Riconfiguro i field sul custom layout con tutte le customizzazioni che arrivano dal ColumnDef
            List<Component> listaField =  (List<Component>) GWTUtils.findChildrenComponentsByItemId(customLayoutContainer, itemId);

            for ( Component component : listaField) {

                Field field = (Field) component;

                if (field!=null && (field instanceof LabelField)) {
                    ((Field)field).setValue(labelFieldText);
                } else if ( field!=null && (field instanceof Field || field instanceof ComboBox<?> ) ) {

                    //Configure binding
                    FieldBinding fieldBinding = null;
                    if (field instanceof RadioGroup) {
                        fieldBinding = new RadioGroupBinding((RadioGroup) field, itemId); //columnDef.getAttributeName()
                    } else if (field instanceof MSFComboBox<?> ){
                        // Aggangia lo store della table def
                        ListStore<BaseModel> store = ((MSFComboBox) columnField).getStore();
                        if (store != null) {
                            ((MSFComboBox) field).setStore(store);
                        }
                        fieldBinding = new BaseRecordBinding((MSFComboBox) field, itemId);
                    } else  {
                        fieldBinding = new FieldBinding((Field)field, itemId);
                    }

                    fieldBinding.setUpdateOriginalValue(true);
                    getFormBinding().addFieldBinding(fieldBinding);
                    // to add the formBinding object to field, to use on client trigger 
                    field.setData(MSFConfiguration.PROP_FORM_BINDING, getFormBinding());
                    field.setData(MSFConfiguration.PROP_FORM_PARENT,  this);

                    /**
                     * WHEN ITEM CHANGED
                     */
                    field.addListener(Events.Change, new Listener<BaseEvent>() {
                        public void handleEvent(BaseEvent be) {
                            if (be.getSource() instanceof Field) {
                                Field f = (Field) be.getSource();
                                setDirtyField(f);
                            }
                        }
                    });

                    //Fix some ids
                    field.setFieldLabel(labelFieldText);
                    field.setItemId(itemId);
                    field.setName(itemId);

                    //Configure Field from ColumnDef
                    columnDef.getVisibleField(field);

                } //if (field instanceof Field || field instanceof ComboBox<?>)

            }

        }

        //Add info regarding formBinding and formParent to this custom layout
        customLayoutContainer.setData(MSFConfiguration.PROP_FORM_BINDING, getFormBinding());
        customLayoutContainer.setData(MSFConfiguration.PROP_FORM_PARENT,  this);

        //At the end apply current LayoutContainer to our Panel
        add(customLayoutContainer, formData);

    }

    private FileUploadField existsFileUploadField() {
        if (this.formBinding != null) {
            for (FieldBinding fieldBinding : this.formBinding.getBindings()) {
                Field field = fieldBinding.getField();
                if (field instanceof FileUploadField && !MSFSharedUtils.isEmpty((String) field.getValue())) {
                    return (FileUploadField) field;
                }
            }
        }
        return null;
    }


    class Tracker 
    {
        public boolean status = false;
        public boolean getStatus(){return status;}
        public void setStatus(boolean stat){status = stat;}
    }
}
