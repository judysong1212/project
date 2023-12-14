/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.generics;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.binding.BaseRecordBinding;
import com.app.smrmf.core.msfmainapp.client.binding.RadioGroupBinding;
import com.app.smrmf.core.msfmainapp.client.def.AttributeCustomForm;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.widget.CustomLayoutMultiField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFComboBox;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.binding.FieldBinding;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.CheckBoxGroup;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayout.HBoxLayoutAlign;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayoutData;

public class MSFCustomForm extends MSFFormPanel{

    private List<ColumnListDef> columnListDefs = new ArrayList<ColumnListDef>();
    private List<LabelField> listLabels = new ArrayList<LabelField>();
    //private LayoutContainer  customFormPanel;



    private FormLayout l;

    public MSFCustomForm(TableDef tableDef) {
        this(tableDef, 800);   
    }

    public MSFCustomForm(TableDef tableDef, int width) {
        this(tableDef, width, 100);
    }

    public MSFCustomForm(TableDef tableDef, int width, int labelWidth) {
        this(tableDef, width, labelWidth, false);
    }

    public MSFCustomForm(TableDef tableDef, int width, int labelWidth, boolean printForm) {
        this(tableDef, width, labelWidth, printForm, false);
    }

    public MSFCustomForm(TableDef tableDef, int width, int labelWidth, boolean printForm, boolean showLabelBorders) {
        this(tableDef, width, labelWidth, printForm, showLabelBorders, true);
    }

    @SuppressWarnings("unchecked")
    public MSFCustomForm(TableDef tableDef, int width, int labelWidth, boolean printForm, boolean showLabelBorders, boolean alignRightFields) {

        super();
        setWidth(width);
        addStyleName("x-panel-mc");
        l = new FormLayout();
        setLayout(l);
        l.setLabelWidth(labelWidth);
        l.setDefaultWidth(width-labelWidth-60);
        //setFormBinding(new FormBinding(this));
        super.tableDef = tableDef;

        customLayoutContainer = tableDef.getCustomLayoutContainer();
        final FormData formData = new FormData("0");

        HBoxLayout layout = null;


        List<ColumnDef> listaColonne = tableDef.getColumnsDefinition();

        if ( customLayoutContainer == null ) {

            setFormBinding(new FormBinding(this));

            final HBoxLayoutData flex = new HBoxLayoutData();
            flex.setFlex(1);

            int oldRow = -1;
            CustomLayoutMultiField customLayoutMultiField = null;  

            for (ColumnDef columnDef : listaColonne) {
                final Field field = columnDef.getField();
                String itemId = field.getItemId();
                String labelText = columnDef.getTitle();
                String labelFieldText = MSFSharedUtils.paramNotNull(labelText) ? labelText+l.getLabelSeparator() : "";
                if (columnDef.isVisibleInForm() && columnDef.getAttributeCustomForm()!=null && !(field instanceof HiddenField)) {
                    AttributeCustomForm attributeCustomForm = columnDef.getAttributeCustomForm();
                    if (oldRow != attributeCustomForm.getRow()) {
                        if (customLayoutMultiField != null) {
                            add(customLayoutMultiField, formData);
                        }
                        layout = new HBoxLayout();
                        layout.setHBoxLayoutAlign(HBoxLayoutAlign.MIDDLE);
                        customLayoutMultiField = new CustomLayoutMultiField();
                        customLayoutMultiField.setLayout(layout);
                        if (printForm) {
                            customLayoutMultiField.add(getFilterCheckBox(customLayoutMultiField, attributeCustomForm.getRow()));
                            customLayoutMultiField.setHideLabel(true);
                        }
                    }
                    if (printForm) {
                        field.setEnabled(false);
                    }
                    if ( tableDef.isReadOnly() ) {
                        field.setReadOnly(true);
                    }
                    if (columnDef instanceof ColumnListDef) {
                        columnListDefs.add((ColumnListDef) columnDef);
                    }
                    int customWidth = attributeCustomForm.getWidth();
                    if (attributeCustomForm.getWidth() == 0) {
                        if (!printForm) {
                            customWidth = l.getDefaultWidth();
                        } else {
                            customWidth = l.getDefaultWidth() - 35;
                        }
                    } 
                    field.setWidth(customWidth);
                    if (attributeCustomForm.getColumn() == 0 && !printForm) {
                        customLayoutMultiField.setFieldLabel(labelText);
                        if ( showLabelBorders ) {
                            customLayoutMultiField.setLabelStyle("x-border");
                        }
                        HBoxLayoutData ld = new HBoxLayoutData(0, 0, 0, 3);
                        if ( field instanceof CheckBox ) {
                            CheckBoxGroup checkGroup = new CheckBoxGroup();
                            ((CheckBox)field).setBoxLabel("");
                            checkGroup.add(field);
                            checkGroup.setBorders(showLabelBorders);
                            customLayoutMultiField.add(checkGroup, ld);
                        } else {
                            field.setBorders(showLabelBorders);
                            customLayoutMultiField.add(field, ld);
                        }
                    } else {
                        //Add label as a label-field
                        HBoxLayoutData ldl = new HBoxLayoutData(0, 0, 0, 0);
                        LabelField labelField = new LabelField(labelFieldText);
                        labelField.setBorders(showLabelBorders);
                        if ( alignRightFields ) {
                            LabelField spacer = new LabelField("");
                            spacer.setBorders(showLabelBorders);
                            customLayoutMultiField.add(spacer, flex);
                        } else {
                            ldl = new HBoxLayoutData(0, 0, 0, 3);
                        }
                        //labelField.setLabelSeparator(l.getLabelSeparator());
                        //if (       attributeCustomForm.getLabelWidth() == -1) {
                        //    labelField.setWidth(0);
                        //    labelField.setText("");
                        //} else 
                        if (attributeCustomForm.getLabelWidth() == 0) {
                            labelField.setWidth(l.getLabelWidth());
                        } else {
                            labelField.setWidth(attributeCustomForm.getLabelWidth());
                        }
                        if ( attributeCustomForm.getLabelWidth() != -1 ) {
                            listLabels.add(labelField);
                            customLayoutMultiField.add(labelField, ldl);
                        }
                        //Add field
                        HBoxLayoutData ld = GXT.isIE ? new HBoxLayoutData(0, 30, 0, 3) : new HBoxLayoutData(0, 32, 0, 3);
                        if ( field instanceof CheckBox ) {
                            CheckBoxGroup checkGroup = new CheckBoxGroup();
                            ((CheckBox)field).setBoxLabel("");
                            checkGroup.add(field);
                            checkGroup.setBorders(showLabelBorders);
                            customLayoutMultiField.add(checkGroup, ld);
                        } else {
                            field.setBorders(showLabelBorders);
                            customLayoutMultiField.add(field, ld);
                        }
                    }
                    FieldBinding fieldBinding = null;
                    if (field instanceof RadioGroup) {
                        fieldBinding = new RadioGroupBinding((RadioGroup) field, field.getItemId()); //columnDef.getAttributeName()
                    } else if (field instanceof MSFComboBox<?>){
                        fieldBinding = new BaseRecordBinding((MSFComboBox) field, field.getItemId());
                    } else {
                        fieldBinding = new FieldBinding(field,field.getItemId());
                    }

                    ((Field)field).setFieldLabel(labelFieldText);
                    ((Field)field).setItemId(itemId);
                    ((Field)field).setName(itemId);    

//                  if (field instanceof CheckBox) {
//                      field.setFireChangeEventOnSetValue(false);
//                  }
                    fieldBinding.setUpdateOriginalValue(true);
                    getFormBinding().addFieldBinding(fieldBinding);
                    // to add the formBinding object to field, to use on client trigger 
                    field.setData(MSFConfiguration.PROP_FORM_BINDING, getFormBinding());
                    field.setData(MSFConfiguration.PROP_FORM_PARENT,  this);
                    field.setHideLabel(true);
                    /**
                     * WHEN VALIDATE ITEM
                     */
                    //                field.addListener(Events.OnBlur, new Listener<BaseEvent>() {
                    //                    public void handleEvent(BaseEvent be) {
                    //                        
                    //                    }
                    //                });
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
                    oldRow = attributeCustomForm.getRow(); 
                } else { // The field is a HiddenField
                    getFormBinding().addFieldBinding(new FieldBinding(field,field.getItemId()));
                }
            }
            if (customLayoutMultiField != null) {
                add(customLayoutMultiField, formData);
            }

        } else {

            setCustomLayout(listaColonne, l.getLabelSeparator());

        }

        //        bind(new BaseModel());

        //        populateListItem();

    }

    private CheckBox getFilterCheckBox(final CustomLayoutMultiField customLayoutMultiField, int row) {
        CheckBox result = new CheckBox();
        result.addListener(Events.OnClick, new Listener<BaseEvent>() {
            public void handleEvent(BaseEvent be) {
                Object o = be.getSource();
                if (o instanceof CheckBox) {
                    List<Field> list = customLayoutMultiField.getAll();
                    for (Field f : list) {
                        if (!f.getItemId().startsWith("filterEnablerRow")) {
                            f.setEnabled(((CheckBox)o).getValue());
                        }
                    }
                }
            }
        });
        result.setItemId("filterEnablerRow"+row);
        result.setFireChangeEventOnSetValue(false);
        result.setWidth(30);
        return result;
    }

    public boolean isValid() {
        boolean result = true;
        for (Field<?> comp : getFields()) {
            if (comp instanceof TextField){
                if (!((TextField)comp).isValid()) {
                    result = false;
                }
            } else if (comp instanceof DateField){
                if (!((DateField)comp).isValid()) {
                    result = false;
                }
            } else if (comp instanceof NumberField){
                if (!((NumberField)comp).isValid()) {
                    result = false;
                }
            } else if (comp instanceof ComboBox){
                if (!((ComboBox)comp).isValid()) {
                    result = false;
                }
            }
        }
        return result;
    }

    @Override
    public void onSuccessSave() {
        clearDirtyFields();
        unmask();
    }

    public void setLabelAlign(LabelAlign labelAlign) {
        l.setLabelAlign(labelAlign);
        for (LabelField f : listLabels) {
            //f.el().addStyleName("x-form-label-" + labelAlign.name().toLowerCase());
            f.setStyleAttribute("text-align", labelAlign.name());
        }
    }
    @Override
    protected void onFailureSave() {
        unmask();
    }

    //    @Override
    //    protected void setCustomLayout(List<ColumnDef> listaColonne, String labelSeparator) {
    //
    //        setFormBinding(new FormBinding(this));
    //        final FormData formData = new FormData("0");
    //
    //        //Ciclo sui fields della TableDef e cerco nel CustomFormPanel un field con lo stesso ID per farci sopra il binding
    //        for (ColumnDef columnDef : listaColonne) {
    //            Field cf = columnDef.getField();
    //            String labelText = columnDef.getTitle();
    //            String labelFieldText = MSFSharedUtils.paramNotNull(labelText) ? labelText+labelSeparator : "";
    //            // Leggo sia il campo itemId  
    //            String itemId = cf.getItemId();
    //            List<Component> listaField =  (List<Component>) GWTUtils.findChildrenComponentsByItemId(customLayoutContainer, itemId);
    //            for (Component field : listaField){
    //
    //                if (field!=null && (field instanceof LabelField)) {
    //                    ((Field)field).setValue(labelFieldText);    
    //                } else if ( field!=null && (field instanceof Field || field instanceof MSFComboBox<?>) ) {
    //                    FieldBinding fieldBinding = null;
    //                    if (field instanceof RadioGroup) {
    //                        fieldBinding = new RadioGroupBinding((RadioGroup) field, itemId); //columnDef.getAttributeName()
    //                    } else if (field instanceof MSFComboBox<?>){
    //                        fieldBinding = new BaseRecordBinding((MSFComboBox) field, itemId);
    //                    } else {
    //                        fieldBinding = new FieldBinding((Field)field, itemId);
    //                    }
    //
    //                    ((Field)field).setFieldLabel(labelFieldText);
    //                    fieldBinding.setUpdateOriginalValue(true);
    //                    getFormBinding().addFieldBinding(fieldBinding);
    //                    // to add the formBinding object to field, to use on client trigger 
    //                    field.setData(MSFConfiguration.PROP_FORM_BINDING, getFormBinding());
    //                    field.setData(MSFConfiguration.PROP_FORM_PARENT,  this);
    //
    //                    if (field instanceof LovField){
    //                        ((LovField)field).setLov(columnDef.getLov());
    //                        ((LovField)field).setParentColumnDef(columnDef);
    //                    }
    //                    field.addListener(Events.Change, new Listener<BaseEvent>() {
    //                        public void handleEvent(BaseEvent be) {
    //                            if (be.getSource() instanceof Field) {
    //                                Field f = (Field) be.getSource();
    //                                setDirtyField(f);
    //                            }
    //                        }
    //                    });
    //                }
    //            }
    //        }
    //
    //        add(customLayoutContainer, formData);
    //
    //    }



}
