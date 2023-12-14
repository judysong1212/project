/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.def;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.binding.BaseRecordBinding;
import com.app.smrmf.core.msfmainapp.client.binding.RadioGroupBinding;
import com.app.smrmf.core.msfmainapp.client.constants.Constants;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnOrder;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ListColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.event.MSFEvents;
import com.app.smrmf.core.msfmainapp.client.form.IMSFWindow;
import com.app.smrmf.core.msfmainapp.client.form.Page;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGrid;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.widget.CustomLayoutMultiField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFSimpleTrigger;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTabItem;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.VerticalAlignment;
import com.extjs.gxt.ui.client.binding.FieldBinding;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.HorizontalPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.CheckBoxGroup;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.SummaryColumnConfig;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayout.HBoxLayoutAlign;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayoutData;
import com.extjs.gxt.ui.client.widget.layout.TableData;
import com.google.gwt.event.dom.client.KeyCodes;
import com.msfgwt.reflection.client.Reflectable;

@Reflectable
public class TableDef implements IMSFWindow {

    public static final String SEPARATOR_CLIENT = "$";
    public static final String SEPARATOR_SERVER = "_";
    public static final String ID_PROPERTY_NAME = "@ID@";
    public static final String ID_THIS_NAME     = "@THIS@";

    public static final int FILTER_FORM_SINGLE    = 0;
    public static final int FILTER_FORM_MULTIPLE  = 1;
    public static final int FILTER_FORM_NO_FILTER = 2;

    public static EventType clickSearchButton = new EventType();

    protected String title;
    protected List<ColumnDef> columnsDefinition;
    protected IColumnFilter tableColumnFilters;
    private Class<?> daoClass;
    private String daoClassName;
    protected boolean isReadOnly       = false;
    protected boolean isAutoFillGrid   = false;
    protected boolean isEditableGrid   = false;
    protected boolean isEditFieldGrid   = false;
    
    protected boolean buttonsSingleRow = false;
    protected boolean reloadData       = false;
    protected boolean checkBoxOnGridRows = false;
    //protected boolean rowNumbererGrid = false;
    
    protected boolean showFilterToolbar  = true;
    protected boolean enableHistoryView  = false;
    protected int filterFormType = FILTER_FORM_SINGLE;
    protected int pageMaxSize = MSFGrid.MAX_LENGTH;
    protected List<RelationDef> relationDefs = new ArrayList<RelationDef>();
    protected IColumnFilter relationColumnFilters;
    protected BaseModel defaultBaseModel = null;
    protected Page page;
    protected MSFGridPanel msfGridPanel;

    protected String customSaveMethod;
    protected String customListMethod;
    protected String customReadMethod;

    private FormBinding searchFormBinding = null;
    private BaseModel searchFormBaseModel = null;

    private LayoutContainer customLayoutContainer;

    // LIST TRIGGERS
    protected List<MSFSimpleTrigger> triggers = null;

    protected int width      = 470;
    protected int labelWidth = 100;

    protected int searchFormLabelWidth = 100;
    protected int searchFormFieldWidth = 200;
    protected int searchFormHeight     = -1;
    private boolean isCellModel = false;
    
    public TableDef(){
        this.defaultBaseModel = new BaseModel();
    }

    public TableDef getTableDefInstance() {
        return this;
    }

    public ColumnAttribute[] getTableAttributes(){
        List<ColumnAttribute> result = new ArrayList<ColumnAttribute>();
        Iterator<ColumnDef> iterator = this.columnsDefinition.iterator();
        while (iterator.hasNext()) {
            ColumnDef columnDef = (ColumnDef) iterator.next();
            if (columnDef instanceof ColumnListDef) {
                ColumnListDef columnListDef = (ColumnListDef)columnDef;
                ColumnAttribute[] attributeTableLKP = columnListDef.getAttributeTableLKP();
                if ( columnListDef.isSkipJoin() ) {
                    if ( MSFSharedUtils.paramNotNull(columnDef.getAttributeName()) ) {
                        String idName      = columnDef.getAttributeName();
                        String idLabel     = columnDef.getTitle();
                        String idFormula   = null;
                        String descName    = columnDef.getAttributeName() + TableDef.SEPARATOR_CLIENT + columnListDef.attrNameDescription;
                        String descLabel   = columnDef.getTitle();
                        String descFormula = MSFSharedUtils.paramNotNull(columnDef.getAttributeFormula()) ? columnDef.getAttributeFormula() : "m."+columnDef.getAttributeName();
                        ColumnAttribute caId   = new ColumnAttribute(idName,   columnDef.getType(), idFormula,   columnListDef.isSkipJoin(), columnListDef.isFakeAttribute(), columnListDef.isVisibleInExport(), idLabel);
                        ColumnAttribute caDesc = new ColumnAttribute(descName, columnDef.getType(), descFormula, columnListDef.isSkipJoin(), columnListDef.isFakeAttribute(), columnListDef.isVisibleInExport(), descLabel);
                        result.add(caId);
                        result.add(caDesc);
                    }
                } else {
                    for (int e=0;e<attributeTableLKP.length;e++) {
                        String tableLkpAttrName    = attributeTableLKP[e].getName();
                        String tableLkpAttrLabel   = attributeTableLKP[e].getLabel();
                        int tableLkpAttrType       = attributeTableLKP[e].getType();
                        //String tableLkpAttrFormula = attributeTableLKP[e].getFormula();
                        //String tableLkpAttrFormula = null;
                        String tableLkpAttrFormula = MSFSharedUtils.replace(attributeTableLKP[e].getFormula(), ID_THIS_NAME, "m."+columnDef.getAttributeName());
                        String name  = columnListDef.getAttributeName() + TableDef.SEPARATOR_CLIENT + tableLkpAttrName;
                        ColumnAttribute ca = new ColumnAttribute(name, tableLkpAttrType, tableLkpAttrFormula, columnListDef.isSkipJoin(), columnListDef.isFakeAttribute(), columnListDef.isVisibleInExport(), tableLkpAttrLabel);
                        result.add(ca);
                    }
                }
            } else {
                if (MSFSharedUtils.paramNotNull(columnDef.getAttributeName())) {
                    String name = columnDef.getAttributeName();
                    String label       = columnDef.getTitle();
                    ColumnAttribute ca = new ColumnAttribute(name, columnDef.getType(), columnDef.getAttributeFormula());
                    ca.setFakeAttribute(columnDef.isFakeAttribute());
                    ca.setVisibleInExport(columnDef.isVisibleInExport());
                    ca.setLabel(label);
                    result.add(ca);
                }
            }
        }
        //Convert list to array
        ColumnAttribute[] attributi = new ColumnAttribute[result.size()];
        Iterator<ColumnAttribute> iter = result.iterator();
        int ii = 0;
        while (iter.hasNext()) {
            attributi[ii++] = iter.next();
        }
        return attributi;
    }

    public String[] getIdHTML(){
        List<String> result = new ArrayList<String>();
        Iterator<ColumnDef> iterator = this.columnsDefinition.iterator();
        while (iterator.hasNext()) {
            ColumnDef columnDef = (ColumnDef) iterator.next();
            if (columnDef instanceof ColumnListDef) {
                ColumnListDef columnListDef = (ColumnListDef)columnDef;
                Iterator<ColumnDef> iterColumnListDef = columnListDef.getColumnsDefinitionLKP().iterator();
                while (iterColumnListDef.hasNext()) {
                    //ColumnDef columnDefLkp = (ColumnDef) iterColumnListDef.next();
                    //result.add(columnDef.getIdHTML() + TableDef.SEPARATOR_CLIENT + columnDefLkp.getAttributeName());
                    result.add(columnDef.getIdHTML());
                }
            } else {
                result.add(columnDef.getIdHTML());
            }
        }
        String[] idHTML = new String[result.size()];
        Iterator<String> iter = result.iterator();
        int ii = 0;
        while (iter.hasNext()) {
            idHTML[ii++] = iter.next();
        }
        return idHTML;
    }

    //setup column model
    public ColumnModel getColumnModel(){
        List<ColumnConfig> result = new ArrayList<ColumnConfig>();
        Iterator<ColumnDef> iterator = this.columnsDefinition.iterator();
        while (iterator.hasNext()) {
            ColumnDef columnDef = (ColumnDef) iterator.next();
            if (columnDef.isVisibleInGrid()) {
                result.add(columnDef.getColumnConfig());
            }
        }
        return new ColumnModel(  
                result
        );
    }

    public ColumnModel getSummaryColumnModel(){
        List<ColumnConfig> result = new ArrayList<ColumnConfig>();
        Iterator<ColumnDef> iterator = this.columnsDefinition.iterator();
        while (iterator.hasNext()) {
            ColumnDef columnDef = (ColumnDef) iterator.next();
            if (columnDef.isVisibleInGrid()) {
                SummaryColumnConfig scc = columnDef.getSummaryColumnConfig();
//                if (scc == null) {
//                    scc = new SummaryColumnConfig<Integer>(columnDef.getAttributeName(), columnDef.getTitle(), columnDef.getColumnGridWidth());
//                }
//                
                result.add(scc);
            }
        }
        return new ColumnModel(  
                result
        );
    }

    public FieldSet getFieldSet(){
        FieldSet result = new FieldSet();
        result.setTitle(null);
        result.setHeadingHtml(null); //.setHeading(null);
        result.setAutoWidth(true);
        FormLayout layout = new FormLayout();
        layout.setDefaultWidth(width-labelWidth-50);
        layout.setLabelWidth(labelWidth);
        result.setLayout(layout);  
        for (ColumnDef columnDef : this.columnsDefinition) {
            final Field<?> f = columnDef.getField();
            if ( isReadOnly() ) {
                f.setReadOnly(true);
            }
            if ( f instanceof CheckBox ) {
                CheckBoxGroup checkGroup = new CheckBoxGroup();
                checkGroup.setFieldLabel(f.getFieldLabel());
                ((CheckBox)f).setBoxLabel("");
                checkGroup.add(f);
                result.add(checkGroup);
            } else {
                result.add(f);
            }
        }
        return result;
    }

    public int getHeightSearchForm(){
//        int result = 0;
//        Iterator<ColumnDef> iterator = this.columnsDefinition.iterator();
//        while (iterator.hasNext()) {
//            ColumnDef columnDef = (ColumnDef) iterator.next();
//            if (columnDef.isVisibleInSearchForm())
//                result += columnDef.getHeightSearchField();
//        }
//        return result;
        return searchFormHeight;
    }

    public FormBinding getFormBinding(FormPanel panel, FieldSet fieldSet){
        FormBinding formBinding = new FormBinding(panel);
        //Iterator<Component> compIterator = fieldSet.iterator();
        List<Field> fields = getFieldList(fieldSet);
        Iterator<Field> compIterator = fields.iterator();
        while (compIterator.hasNext()) {
            Field field = (Field) compIterator.next();
            FieldBinding fieldBinding = null;
            if (field instanceof RadioGroup) {
                fieldBinding = new RadioGroupBinding((RadioGroup) field, field.getItemId());
            } else if (field instanceof MSFComboBox<?>){
                fieldBinding = new BaseRecordBinding((MSFComboBox) field, field.getItemId());
                //            } else if (field instanceof HtmlEditor){
                //                fieldBinding = new HtmlEditorBinding((HtmlEditor) field, field.getItemId());
            } else {
                fieldBinding = new FieldBinding(field, field.getItemId());

            }
            formBinding.addFieldBinding(fieldBinding);
            // to add the formBinding object to field, to use on client trigger 
            field.setData(MSFConfiguration.PROP_FORM_BINDING, formBinding);
            field.setData(MSFConfiguration.PROP_FORM_PARENT,  panel);
        }
        formBinding.setUpdateOriginalValue(true);
        return formBinding;
    }

    public List<Field> getFieldList(FieldSet fieldSet) {
        List<Field> list = new ArrayList<Field>();
        Iterator<Component> compIterator = fieldSet.iterator();
        while (compIterator.hasNext()) {
            Field field = (Field) compIterator.next();
            if ( field instanceof CheckBoxGroup ) {
                for ( Field cb : ((CheckBoxGroup)field).getAll() ) {
                    list.add(cb);
                }
            } else {
                list.add(field);
            }
        }
        return list;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setColumnsDefinition(List<ColumnDef> columnsDefinition) {
        this.columnsDefinition = columnsDefinition;
        for (ColumnDef columnDef : columnsDefinition) {
            columnDef.setParent(this);
        }
    }

    public void addColumnDefinition(ColumnDef columnDef) {
        if ( columnsDefinition==null ) {
            columnsDefinition = new ArrayList<ColumnDef>();
        }
        columnsDefinition.add(columnDef);
        columnDef.setParent(this);
    }

    public void addColumnDefinition(int index, ColumnDef columnDef) {
        if ( columnsDefinition==null ) {
            columnsDefinition = new ArrayList<ColumnDef>();
        }
        columnsDefinition.add(index, columnDef);
        columnDef.setParent(this);
    }

    public List<ColumnDef> getColumnsDefinition() {
        return columnsDefinition;
    }

    /**
     *  All the attributes add with addColumnFilter are in AND.
     *  Instead you want add some attributes in OR, you must create a ListColumnFilter with OR operator
     *  and add to this the SingleFilterColumn. At end you must set the listColumnFilter to the tableDef
     *  whit setIColumnFilter method
     * @param attribute name of the dao column
     * @param value generic object (String, Date, Long, etc)
     * @param operator see SimpleColumnFilter.AVAILABLE_OPERATORS
     */
    public void addColumnFilter(String attribute, Serializable value, String operator) {
        SimpleColumnFilter scf = new SimpleColumnFilter(attribute, value, operator);
        if (tableColumnFilters == null) {
            tableColumnFilters = scf;
        } else if (tableColumnFilters instanceof SimpleColumnFilter) {
            ListColumnFilter lcf = new ListColumnFilter();
            lcf.addFilter(tableColumnFilters);
            lcf.addFilter(scf);
            tableColumnFilters = lcf;
        } else if (tableColumnFilters instanceof ListColumnFilter) {
            ((ListColumnFilter) tableColumnFilters).addFilter(scf);
        }
    }

    public IColumnFilter getColumnFilters(String value) {
        ListColumnFilter listColumnFilter = new ListColumnFilter();
        if (tableColumnFilters != null) {
            listColumnFilter.getFilterList().add(tableColumnFilters);
        }
        /*
         * Read every columns and get the IColumnFilter of each, clearly this could be 
         * a SimpleColumnFilter or a ListColumnFilter (in AND or OR operator)
         */
        Iterator<ColumnDef> iterator = this.columnsDefinition.iterator();
        while (iterator.hasNext()) {
            ColumnDef columnDef = (ColumnDef) iterator.next();
            if (columnDef.getColumnFilters() != null) {
                listColumnFilter.getFilterList().add(columnDef.getColumnFilters());
            }
        }
        /* if value is not null, means that you're using the filedFilter over the grid,
         * therefore I must read all the grid columns and for each create a SimpleColumnFilter
         * and add them into a ListColumnFiler whit OR operator  
         */
        if (MSFSharedUtils.paramNotNull(value)) {
            ListColumnFilter listColumnFilterOR = new ListColumnFilter(ListColumnFilter.OPERATOR_OR);
            Iterator<ColumnDef> iteratorOR = this.columnsDefinition.iterator();
            while (iteratorOR.hasNext()) {
                ColumnDef columnDef = iteratorOR.next();
                if (columnDef.isVisibleInGrid()) {
                    SimpleColumnFilter columnFilter = columnDef.getColumnFilter(value);
                    if ( columnFilter!=null ) {
                        listColumnFilterOR.addFilter(columnFilter);
                    }
                }
            }
            if (listColumnFilterOR.getFilterList()!=null && listColumnFilterOR.getFilterList().size() > 0) {
                listColumnFilter.addFilter(listColumnFilterOR);
            }
        }
        if (showFilterForm()) {
            IColumnFilter searchFormFilterColumns = getSearchFormFilterColumns();
            if (searchFormFilterColumns != null) {
                listColumnFilter.addFilter(searchFormFilterColumns);
            }
        }
        if (this.relationColumnFilters != null) {
            listColumnFilter.addFilter(this.relationColumnFilters);
        }
        if (listColumnFilter.getFilterList().size() == 0) {
            listColumnFilter = null;
        }
        return listColumnFilter;
    }

    public IColumnFilter getTableColumnFilters() {
        return this.tableColumnFilters;
    }
    public void setTableColumnFilters(IColumnFilter tableColumnFilters) {
        this.tableColumnFilters = tableColumnFilters;
    }

    public String getTable() {
        return daoClassName;
    }

    public List<ColumnOrder> getColumnOrders(){
        List<ColumnOrder> columnOrders = getMapOrder(this.columnsDefinition, "");
        Collections.sort(columnOrders);
        return columnOrders;
    }

    private List<ColumnOrder> getMapOrder(List<ColumnDef> list, String prefixTable){
        List<ColumnOrder> columnOrders = new ArrayList<ColumnOrder>();
        String separator = TableDef.SEPARATOR_CLIENT;
        for (ColumnDef columnDef : list) {
//            if (columnDef instanceof ColumnListDef) {
//                ColumnListDef def = (ColumnListDef)columnDef;
//                columnOrders.addAll(getMapOrder(
//                        def.getColumnsDefinitionLKP(), def.getAttributeName()));
//            } else {
                if (columnDef.getSortPos() > 0 ) {
                    String attrName = ("".equals(prefixTable) ? "" : prefixTable + separator) + columnDef.getAttributeName();
                    columnOrders.add(new ColumnOrder(attrName, columnDef.getSortDir().name(), columnDef.getSortPos()));
                }
//            }
        }
        return columnOrders;
    }

    public void setDaoClass(String daoClassName) {
        this.daoClassName = daoClassName;
    }

    public void setDaoClass(Class<?> daoClass) {
        this.daoClass = daoClass;
        this.daoClassName = daoClass.getName();
    }

    public Class<?> getDaoClass() {
        return daoClass;
    }

    public void setReadOnly(boolean isReadOnly) {
        this.isReadOnly = isReadOnly;
    }

    public boolean isReadOnly() {
        return isReadOnly;
    }

    public void setButtonsSingleRow(boolean buttonsSingleRow) {
        this.buttonsSingleRow = buttonsSingleRow;
    }

    public boolean isButtonsSingleRow() {
        return buttonsSingleRow;
    }

    public int getPageMaxSize() {
        return pageMaxSize;
    }

    public void setPageMaxSize(int pageMaxSize) {
        this.pageMaxSize = pageMaxSize;
    }

    /**
     * You can set if as filter exists a simple form over the grid.
     * @param b true or false (default false)
     */
    public void setFilterForm(boolean b) {
        if ( b ) {
            this.filterFormType = FILTER_FORM_MULTIPLE;
        } else {
            this.filterFormType = FILTER_FORM_SINGLE;
        }
    }
    public boolean showFilterForm() {
        return this.filterFormType==FILTER_FORM_MULTIPLE;
    }

    public void setFilterFormType(int filterFormType) {
        this.filterFormType = filterFormType;
    }
    public int getFilterFormType() {
        return this.filterFormType;
    }

    public FormBinding getSearchFormBinding() {
        return searchFormBinding;
    }

    public BaseModel getSearchFormBaseModelCleaned(){
        FormBinding binding = getSearchFormBinding();
        ModelData modelData = binding.getModel();
        if (modelData == null) {
            return null;
        }
        BaseModel result = new BaseModel(modelData.getProperties());
        Collection<String> attributes = modelData.getPropertyNames();
        if (attributes == null) {
            return null;
        }
        for (String attribute : attributes ) {
            Object obj = modelData.get(attribute);
            if (obj != null) {
                if (obj instanceof BaseModel) {
                    Collection<FieldBinding> bindings = binding.getBindings();
                    Iterator<FieldBinding> iterator = bindings!=null ? bindings.iterator() : null;
                    MSFComboBox<?> cb = null;
                    while ( iterator!=null && iterator.hasNext() && cb==null ) {
                        FieldBinding fb = iterator.next();
                        Field<?> f = fb.getField();
                        String fieldName = fb.getProperty();
                        String itemId    = f.getItemId();
                        if ( f!=null && f instanceof MSFComboBox && attribute.equals(fieldName) ) {
                            cb = (MSFComboBox<?>)f;
                            String attrNameId = cb.getAttrNameId();
                            Object realValue = ((BaseModel)obj).get(attrNameId);
                            result.remove(attribute);
                            result.set(attribute+SEPARATOR_CLIENT+attrNameId, realValue);
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * This method is called when the filterForm attribute is true, and it show the search fields in one column
     * 
     * @return A horizontalPanel with to left the search form to right the search and clear buttons. 
     */
    public LayoutContainer getFilterForm() {
        return getFilterForm(1);
    }

    /**
     * This method is called when the filterForm attribute is true, and it show the search fields in numcols columns
     * 
     * @return A horizontalPanel with to left the search form to right the search and clear buttons. 
     */
    public LayoutContainer getFilterForm(int numCols) {
        final HorizontalPanel horizontalPanel = new HorizontalPanel();
        horizontalPanel.setSpacing(2);
        FormPanel formPanel = new FormPanel();
        formPanel.setHeaderVisible(false);
        formPanel.setAutoHeight(true);
        formPanel.setBorders(false);
        formPanel.setBodyBorder(false);
        FormLayout formPanelLayout = new FormLayout();
        int mfwidth = (numCols-1) * (searchFormFieldWidth + searchFormLabelWidth + 6) + searchFormFieldWidth + 6;
        formPanelLayout.setDefaultWidth(mfwidth);
        //layout.setDefaultWidth(width-labelWidth-50);
        formPanelLayout.setLabelWidth(searchFormLabelWidth);
        formPanel.setLayout(formPanelLayout);
        searchFormBinding = new FormBinding(formPanel);
        searchFormBaseModel = new BaseModel();

        //Align Form fields in numCols columns
        int col = 0; int row = 0;
        int formHeight = 0;
        CustomLayoutMultiField<?> customLayoutMultiField = null;  
        for (ColumnDef columnDef : this.columnsDefinition) {
            if (columnDef.isVisibleInSearchForm()) {

                columnDef.setIsRequired(false);
                columnDef.setColumnGridWidth(100);
                Field<?> field = columnDef.getSearchField();
                configureSearchFormDefaultValue(field, columnDef);
                FieldBinding fieldBinding = new FieldBinding(field, columnDef.getAttributeName());
                fieldBinding.setUpdateOriginalValue(true);
                searchFormBinding.addFieldBinding(fieldBinding);
                field.setData(MSFConfiguration.PROP_FORM_BINDING, searchFormBinding);
                field.setData(MSFConfiguration.PROP_FORM_PARENT,  formPanel);
                field.setWidth(searchFormFieldWidth);
                field.addKeyListener(new KeyListener(){
                    @Override
                    public void componentKeyUp(ComponentEvent event) {
                        char ch = (char) event.getKeyCode();
                        if ( ch == KeyCodes.KEY_ENTER ) {
                            //getMsfGridPanel().getMsfGrid().readData();
                            horizontalPanel.fireEvent(TableDef.clickSearchButton, null);
                        }
                    }
                });
                //field.setBorders(true);

                if ( numCols<=1 ) {
                    formPanel.add(field);
                    formHeight += columnDef.getHeightSearchField();
                } else {
                    //String labelColumnDefText = columnDef.getTitle();
                    String labelFieldText     = field.getFieldLabel();
                    if ( col==numCols ) {
                        col = 0;
                        row++;
                    }
                    if ( col==0 ) {
                        //This is a workaround, first line is added with a width of 0px, very strange
                        if ( row==0 ) {
                            customLayoutMultiField = new CustomLayoutMultiField<String>();
                            customLayoutMultiField.setHeight(0);
                            customLayoutMultiField.setLabelSeparator("");
                            customLayoutMultiField.setFieldLabel("");
                            formPanel.add(customLayoutMultiField);
                        }
                        HBoxLayout mflayout = new HBoxLayout();
                        mflayout.setHBoxLayoutAlign(HBoxLayoutAlign.MIDDLE);
                        customLayoutMultiField = new CustomLayoutMultiField();
                        customLayoutMultiField.setLayout(mflayout);
                        customLayoutMultiField.setFieldLabel(labelFieldText);
                        //customLayoutMultiField.setLabelStyle("x-border");
                        //customLayoutMultiField.setBorders(true);
                        HBoxLayoutData ld = new HBoxLayoutData(0, 0, 0, 3);
                        customLayoutMultiField.setWidth(mfwidth);
                        customLayoutMultiField.setStyleAttribute("width", mfwidth+"px");
                        customLayoutMultiField.add(field, ld);

                        formPanel.add(customLayoutMultiField);
                        formHeight += columnDef.getHeightSearchField();
                    } else {
                        //Add label as a label-field
                        HBoxLayoutData ldl = new HBoxLayoutData(0, 0, 0, 3);
                        LabelField labelField = new LabelField(labelFieldText+formPanelLayout.getLabelSeparator());
                        //HBoxLayoutData ldl = new HBoxLayoutData(0, 0, 0, 0);
                        //LabelField spacer = new LabelField("");
                        //spacer.setBorders(true);
                        //HBoxLayoutData flex = new HBoxLayoutData();
                        //flex.setFlex(1);
                        //customLayoutMultiField.add(spacer, flex);
                        labelField.setWidth(searchFormLabelWidth);
                        //labelField.setBorders(true);
                        customLayoutMultiField.add(labelField, ldl);
                        //Add field
                        //HBoxLayoutData ld = GXT.isIE ? new HBoxLayoutData(0, 30, 0, 3) : new HBoxLayoutData(0, 32, 0, 3);
                        HBoxLayoutData ld = new HBoxLayoutData(0, 0, 0, 3);
                        customLayoutMultiField.add(field, ld);
                    }
                }

                col++;
            }
        }

        if ( searchFormHeight==-1 ) {
            searchFormHeight = formHeight+5;
        }

        horizontalPanel.add(formPanel);
        searchFormBinding.autoBind();
        searchFormBinding.bind(searchFormBaseModel);
        HorizontalPanel buttonPanel = new HorizontalPanel();
        buttonPanel.setSpacing(13);
        Button search = new Button(MSFMainApp.MSFCONSTANTS.BtnSearch());
        search.setIcon(MSFMainApp.ICONS.search());
        search.addSelectionListener(new SelectionListener<ButtonEvent>() {
            @Override
            public void componentSelected(ButtonEvent ce) {
                //searchFormBinding.bind(new BaseModel());
                horizontalPanel.fireEvent(TableDef.clickSearchButton, ce);
            }
        });
        buttonPanel.add(search);
        Button clear = new Button(MSFMainApp.MSFCONSTANTS.BtCancel());
        clear.setIcon(MSFMainApp.ICONS.cancel());
        clear.addSelectionListener(new SelectionListener<ButtonEvent>() {
            @Override
            public void componentSelected(ButtonEvent ce) {
                FormBinding binding = getSearchFormBinding();
                binding.clear();
                clearBaseModel((BaseModel) binding.getModel());
                horizontalPanel.fireEvent(TableDef.clickSearchButton, ce);
            }
        });
        buttonPanel.add(clear);
        horizontalPanel.add(buttonPanel, new TableData(HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM));

        return horizontalPanel;
    }

    protected void configureSearchFormDefaultValue(Field<?> field, ColumnDef columnDef) {
        Object obj = columnDef.getDefaultSearchValue();
        if (obj != null) {
            if (columnDef instanceof ColumnListDef) {
                field.setData("defaultValue", obj);
                field.addListener(MSFEvents.dataReadInColumnDef, new Listener<BaseEvent>() {
                    public void handleEvent(BaseEvent be) {
                        MSFComboBox<BaseModel> combo = (MSFComboBox<BaseModel>) be.getSource();
                        Object defaultObj = combo.getData("defaultValue");
                        FormBinding formBinding = combo.getData("formBinding");
                        FieldBinding fieldBinding = formBinding!=null ? formBinding.getBinding(combo) : null;
                        List<BaseModel> models = combo.getStore().getModels();
                        BaseModel value = null;
                        for (BaseModel baseModel : models) {
                            if (defaultObj.equals(baseModel.get(combo.getAttrNameId()))) {
                                value = baseModel;
                                break;
                            }
                        }
                        if ( fieldBinding!=null && fieldBinding.getModel()!=null && value != null) {
                            combo.setValue(value);
                            combo.setOriginalValue(value);
                            fieldBinding.updateModel();
                        }
                    }
                });
            } else if (columnDef instanceof ColumnListStaticDef) {
                ColumnListStaticDef columnListStaticDef = (ColumnListStaticDef)columnDef;
                obj = columnListStaticDef.getBaseModelByCode(obj);
                searchFormBaseModel.set(columnDef.getAttributeName(), obj);
            } else {
                if (ColumnDef.TYPE_BOOLEAN == columnDef.getType() && obj instanceof Boolean) {
                    obj = (Boolean)obj?TrueFalseNullStaticDef.getBaseModelByCode(Constants.TRUE_VALUE):TrueFalseNullStaticDef.getBaseModelByCode(Constants.FALSE_VALUE);
                }
                searchFormBaseModel.set(columnDef.getAttributeName(), obj);
            }
        }
    }

    private void clearBaseModel(BaseModel baseModel) {
        if (baseModel != null) {
            Collection<String> attributes = baseModel.getPropertyNames();
            if (attributes != null) {
                Iterator<String> iter = attributes.iterator();
                while (iter.hasNext()) {
                    String attribute = iter.next();
                    baseModel.set(attribute, null);
                }
            }
        }
    }

    /**
     * 
     * @return A IColumnFilter with the where conditions about the search form. 
     */
    protected IColumnFilter getSearchFormFilterColumns(){
        return this.getSearchFormFilterColumns(ListColumnFilter.OPERATOR_AND);
    }
    
    protected IColumnFilter getSearchFormFilterColumns(String operator){
        IColumnFilter columnFilter = null;
        FormBinding binding = getSearchFormBinding();
        //Loop on field values, binding is updated only when cursor goes out from field, pressing enter on a field immediately
        //after setting a value does not update the model, so we must use field.getValue() instead
//        ModelData modelData = binding.getModel();
//        if (modelData == null) {
//            return null;
//        }
        Iterator<FieldBinding> iterFieldBinding = 
            binding!=null && binding.getBindings()!=null ? binding.getBindings().iterator() : null;
        ModelData modelData = new BaseModel();
        while ( iterFieldBinding!=null && iterFieldBinding.hasNext() ) {
            FieldBinding fieldBinding = iterFieldBinding.next();
            Field<Object> field = fieldBinding.getField();
            //String rawValue = field.getRawValue();
            String itemId = field.getItemId();
            Object value = field.getValue();
            if ( value!=null ) {
                modelData.set(itemId, value);
            }
        }
        Collection<String> attributes = modelData.getPropertyNames();
        if (attributes == null || attributes.size()==0) {
            return null;
        }
        Iterator<String> iter = attributes.iterator();
        while (iter.hasNext()) {
            String attribute = iter.next();
            Object obj = modelData.get(attribute);
            if (obj != null) {
                SimpleColumnFilter scf = null;
                boolean skipFilter = false;
                if (obj instanceof BaseModel) {
                    //If value is a BaseModel, perhaps it comes from a ComboBox, so we must find associated
                    //field and get the ID value
                    Collection<FieldBinding> bindings = binding.getBindings();
                    Iterator<FieldBinding> iterator = bindings!=null ? bindings.iterator() : null;
                    MSFComboBox<?> cb = null;
                    while ( iterator!=null && iterator.hasNext() && cb==null ) {
                        FieldBinding fb = iterator.next();
                        Field<?> f = fb.getField();
                        String fieldName = fb.getProperty();
                        String itemId    = f.getItemId();
                        if ( f!=null && f instanceof MSFComboBox && attribute.equals(fieldName) ) {
                            cb = (MSFComboBox<?>)f;
                            String attrNameId = cb.getAttrNameId();
                            Object realValue = ((BaseModel)obj).get(attrNameId);
                            if ( Constants.ALL_VALUE.equals(realValue) ) {
                                skipFilter = true;
                            } else {
                                scf = new SimpleColumnFilter(itemId, (Serializable)realValue, SimpleColumnFilter.OPERATOR_EQUALS);
                            }
                        }
                    }
                    if ( scf==null && !skipFilter ) {
                        scf = new SimpleColumnFilter(attribute, (Serializable)obj, SimpleColumnFilter.OPERATOR_ILIKE);
                    }
                } else if (obj instanceof String) {
                    scf = new SimpleColumnFilter(attribute, (Serializable)obj, SimpleColumnFilter.OPERATOR_ILIKE);
                } else {
                    scf = new SimpleColumnFilter(attribute, (Serializable)obj, SimpleColumnFilter.OPERATOR_EQUALS);
                }
                if ( scf!=null ) {
                    if (columnFilter == null) {
                        columnFilter = scf; 
                    } else if (columnFilter instanceof SimpleColumnFilter) {
                        ListColumnFilter lcf = new ListColumnFilter(operator);
                        lcf.addFilter(columnFilter);
                        lcf.addFilter(scf);
                        columnFilter = lcf;
                    } else if (columnFilter instanceof ListColumnFilter) {
                        ((ListColumnFilter) columnFilter).addFilter(scf);
                    }
                }
            }
        }
        return columnFilter;
    }

    /**
     * This method adds the relations between master and detail 
     * @param relationDef Definition of relation, see RelationDef
     */
    public void addRelation(RelationDef relationDef) {
        relationDefs.add(relationDef);
    }

    /**
     * 
     * @return A IColumnFilter with the where conditions about the relations. 
     */
    public IColumnFilter getRelationFilterColumns(BaseModel record, TableDef detailTable){
        IColumnFilter columnFilter = null;
        if (relationDefs != null && relationDefs.size() > 0) {
            for (RelationDef relationDef : relationDefs) {
               if (relationDef.getDetailTable() == detailTable && relationDef.isAutoQuery()) {
                    List<ColumnJoinDef> joinDefs = relationDef.getJoinColumns();
                    if (joinDefs != null && joinDefs.size() > 0) {
                        Iterator<ColumnJoinDef> iterJoin = joinDefs.iterator();
                        while (iterJoin.hasNext()) {
                            ColumnJoinDef columnJoinDef = (ColumnJoinDef) iterJoin.next();
                            Object obj = record.get(columnJoinDef.getAttributeMasterTable());
                            SimpleColumnFilter scf = new SimpleColumnFilter(columnJoinDef.getAttributeDetailTable(), (Serializable)obj, SimpleColumnFilter.OPERATOR_EQUALS);
                            if (columnFilter == null) {
                                columnFilter = scf; 
                            } else if (columnFilter instanceof SimpleColumnFilter) {
                                ListColumnFilter lcf = new ListColumnFilter();
                                lcf.addFilter(columnFilter);
                                lcf.addFilter(scf);
                                columnFilter = lcf;
                            } else if (columnFilter instanceof ListColumnFilter) {
                                ((ListColumnFilter) columnFilter).addFilter(scf);
                            }
                        }
                    }
                } else {
                    List<ColumnJoinDef> joinDefs = relationDef.getJoinColumns();
                    if (joinDefs != null && joinDefs.size() > 0) {
                        Iterator<ColumnJoinDef> iterJoin = joinDefs.iterator();
                        while (iterJoin.hasNext()) {
                            ColumnJoinDef columnJoinDef = (ColumnJoinDef) iterJoin.next();
                            Object obj = record.get(columnJoinDef.getAttributeMasterTable());
                            SimpleColumnFilter scf = new SimpleColumnFilter(columnJoinDef.getAttributeDetailTable(), (Serializable)obj, SimpleColumnFilter.OPERATOR_EQUALS);
                            if (columnFilter == null) {
                                columnFilter = scf; 
                            } else if (columnFilter instanceof SimpleColumnFilter) {
                                ListColumnFilter lcf = new ListColumnFilter();
                                lcf.addFilter(columnFilter);
                                lcf.addFilter(scf);
                                columnFilter = lcf;
                            } else if (columnFilter instanceof ListColumnFilter) {
                                ((ListColumnFilter) columnFilter).addFilter(scf);
                            }
                        }
                    }
                }
            }
        }
        return columnFilter;
    }

    public void setRelationColumnFilters(IColumnFilter relationColumnFilters) {
        this.relationColumnFilters = relationColumnFilters;
    }

    /**
     * @return A BaseModel with all default value of the attribute. 
     * Default value is set with setDefaultValue method for each columnDef 
     */
    public BaseModel getDefaultValues() {
        BaseModel bm = new BaseModel(this.defaultBaseModel.getProperties());

        //for (ColumnDef columnDef : this.columnsDefinition) {
        //    Object obj = columnDef.getDefaultValue();
        //    bm.set(columnDef.getAttributeName(), obj);
        //}

        Iterator<ColumnDef> iterator = this.columnsDefinition.iterator();
        while (iterator.hasNext()) {
            ColumnDef columnDef = (ColumnDef) iterator.next();
            if (columnDef instanceof ColumnListDef) {
                ColumnListDef columnListDef = (ColumnListDef)columnDef;
                ColumnAttribute[] attributeTableLKP = columnListDef.getAttributeTableLKP();
                Object obj = columnDef.getDefaultValue();
                //TODO: qui servirebbe settare solo il valore dell'identificativo
                for (int e=0;e<attributeTableLKP.length;e++) {
                    String tableLkpAttrName    = attributeTableLKP[e].getName();
                    String name = columnDef.getAttributeName() + TableDef.SEPARATOR_CLIENT + tableLkpAttrName;
                    if (MSFSharedUtils.paramNotNull(obj)) {
                        bm.set(name, obj);
                    }
                }
            } else {
                if (MSFSharedUtils.paramNotNull(columnDef.getAttributeName())) {
                    Object obj = columnDef.getDefaultValue();
                    //In case of a boolean type, an unchecked checkbox means FALSE
                    if ( ColumnDef.TYPE_BOOLEAN == columnDef.getType() && obj==null ) {
                        obj = Boolean.FALSE;
                    }
                    if (MSFSharedUtils.paramNotNull(obj)) {
                        bm.set(columnDef.getAttributeName(), obj);
                    }
                }
            }
        }

        return bm;
    }

    public void setDefaultValues(BaseModel defaultBaseModel) {
        this.defaultBaseModel.setProperties(defaultBaseModel.getProperties());
    }

    /**
     * 
     * @param record
     * @param detailTable
     */
    public void setValuesDefaultDetailRecord(BaseModel record, TableDef detailTable) {
        if (record!=null && detailTable!=null && relationDefs != null && relationDefs.size() > 0) {
            BaseModel detailDefaultValues = detailTable.getDefaultValues();
            for (RelationDef relationDef : relationDefs) {
                if (relationDef.getDetailTable() == detailTable) {
                    List<ColumnJoinDef> joinDefs = relationDef.getJoinColumns();
                    if (joinDefs != null && joinDefs.size() > 0) {
                        for (ColumnJoinDef columnJoinDef : joinDefs) {
                            Object obj = record.get(columnJoinDef.getAttributeMasterTable());
                            detailDefaultValues.set(columnJoinDef.getAttributeDetailTable(), obj);
                        }
                    }
                }
            }
            detailTable.setDefaultValues(detailDefaultValues);
        }
    }

    public void clearValuesDefaultDetailRecord(TableDef detailTable) {
        if (detailTable!=null && relationDefs != null && relationDefs.size() > 0) {
            BaseModel detailDefaultValues = detailTable.getDefaultValues();
            for (RelationDef relationDef : relationDefs) {
                if (relationDef.getDetailTable() == detailTable) {
                    List<ColumnJoinDef> joinDefs = relationDef.getJoinColumns();
                    if (joinDefs != null && joinDefs.size() > 0) {
                        for (ColumnJoinDef columnJoinDef : joinDefs) {
                            detailDefaultValues.set(columnJoinDef.getAttributeDetailTable(), null);
                        }
                    }
                }
            }
            detailTable.setDefaultValues(detailDefaultValues);
        }
    }

    /**
     * Returns true if auto expand the columns in the grid is enabled.
     * 
     * @return true for auto fill
     */    
    public boolean isAutoFillGrid() {
        return isAutoFillGrid;
    }

    /**
     * True to auto expand the columns to fit the grid <b>when the grid is
     * created</b>.
     * 
     * @param isAutoFillGrid true to expand columns's grid
     */
    public void setAutoFillGrid(boolean isAutoFillGrid) {
        this.isAutoFillGrid = isAutoFillGrid;
    }

    /**
     * Returns the list of definition's relations <i>RelationDef</i>
     * @return Returns List of RelationDef
     */
    public List<RelationDef> getRelationDefs(){
        return this.relationDefs;
    }

    public void refreshObjectLinked(BaseModel currentMasterRecord) {
        for (RelationDef relationDef : relationDefs) {
            if (relationDef.isAutoQuery()) {
                Object objLinked = relationDef.getLinkedObject();
                if (objLinked != null) {
                    MSFGridPanel detailGrid = null;
                    if (objLinked instanceof MSFGridPanel) {
                        synchronizeGridDetail(currentMasterRecord, (MSFGridPanel)objLinked);
                        detailGrid = (MSFGridPanel)objLinked;
                    } else if (objLinked instanceof MSFFormPanel) {

                    } else if (objLinked instanceof MSFTabItem) {
                        MSFTabItem tabItem = (MSFTabItem)objLinked;
                        if (tabItem.getTabPanel().getSelectedItem() == tabItem) { 
                            synchronizeGridDetail(currentMasterRecord, tabItem.getDetailGridPanel());
                            detailGrid = tabItem.getDetailGridPanel();
                        }
                    }
                    if (detailGrid != null) {
                        detailGrid.getTableDef().refreshObjectLinked(
                                detailGrid.getCurrentlySelectedItem());
                    }
                }
            } 
            
//            else {
//                Object objLinked = relationDef.getLinkedObject();
//                if (objLinked != null) {
//                    MSFGridPanel detailGrid = null;
//                    if (objLinked instanceof MSFGridPanel) {
//                        synchronizeNonGridDetail(currentMasterRecord, (MSFGridPanel)objLinked);
//                        detailGrid = (MSFGridPanel)objLinked;
//                    } else if (objLinked instanceof MSFFormPanel) {
//
//                    } else if (objLinked instanceof MSFTabItem) {
//                        MSFTabItem tabItem = (MSFTabItem)objLinked;
//                        if (tabItem.getTabPanel().getSelectedItem() == tabItem) { 
//                            synchronizeNonGridDetail(currentMasterRecord, tabItem.getDetailGridPanel());
//                            detailGrid = tabItem.getDetailGridPanel();
//                        }
//                    }
//                    if (detailGrid != null) {
//                        detailGrid.getTableDef().refreshObjectLinked(
//                                detailGrid.getCurrentlySelectedItem());
//                    }
//                }  
//            }
        }
    }

    /**
     * This method is called when the parent MsfGridPanel is created.
     * Override it to perform custom behaviour.
     */
    public void onMsfGridPanelCreated() {
    	
    }

    /**
     * To synchronize the master table with a detail
     * @param selectionMaster it's the current selected record 
     * @param msfGridPanel it's the detail object to be synchronized
     */
    public void synchronizeGridDetail(BaseModel selectionMaster, MSFGridPanel msfGridPanel){
        TableDef detailTab = msfGridPanel.getTableDef();
        if (selectionMaster != null && detailTab != null) {
            IColumnFilter iColumnFilter = 
                getRelationFilterColumns(selectionMaster, detailTab);
            if (iColumnFilter != null) {
                detailTab.setRelationColumnFilters(iColumnFilter);
                msfGridPanel.reload();
            }
            // Update default values of the detail TableDef with the values of the primary keys of the master 
            setValuesDefaultDetailRecord(selectionMaster, detailTab);
        } else if (selectionMaster == null) {
            // Clear master values of the detail TableDef 
            clearValuesDefaultDetailRecord(detailTab);
            detailTab.setRelationColumnFilters(null);
            msfGridPanel.getMsfGrid().clearData();
        }
    }
    
//    public void synchronizeNonGridDetail(BaseModel selectionMaster, MSFGridPanel msfGridPanel){
//        TableDef detailTab = msfGridPanel.getTableDef();
//        if (selectionMaster != null && detailTab != null) {
//            IColumnFilter iColumnFilter = 
//                getRelationFilterColumns(selectionMaster, detailTab);
//            if (iColumnFilter != null) {
//                detailTab.setRelationColumnFilters(iColumnFilter); 
//            }
//            // Update default values of the detail TableDef with the values of the primary keys of the master 
//           // setValuesDefaultDetailRecord(selectionMaster, detailTab);
//        } else if (selectionMaster == null) {
//            // Clear master values of the detail TableDef 
//            //clearValuesDefaultDetailRecord(detailTab);
//            detailTab.setRelationColumnFilters(null);
//            msfGridPanel.getMsfGrid().clearData();
//        }
//    }
    
   
    public boolean isEditableGrid() {
        return isEditableGrid;
    }

    /**
     * Sets if the grid created is a editable grid
     * @param isEditableGrid (default id false)
     */
    public void setEditableGrid(boolean isEditableGrid) {
        this.isEditableGrid = isEditableGrid;
    }
    

    public boolean isEditFieldGrid() {
        return isEditFieldGrid;
    }

    /**
     * Sets if the grid created is a editable grid
     * @param isEditFieldGrid (default id false)
     */
    public void setEditFieldGrid(boolean isEditFieldGrid) {
        this.isEditFieldGrid = isEditFieldGrid;
    }

    public String getCustomSaveMethod() {
        return customSaveMethod;
    }
    public void setCustomSaveMethod(String customSaveMethod) {
        this.customSaveMethod = customSaveMethod;
    }

    public String getCustomListMethod() {
        return customListMethod;
    }
    public void setCustomListMethod(String customListMethod) {
        this.customListMethod = customListMethod;
    }

    public String getCustomReadMethod() {
        return customReadMethod;
    }
    public void setCustomReadMethod(String customReadMethod) {
        this.customReadMethod = customReadMethod;
    }

    public void skipServiceCalls() {
        this.customListMethod = MSFConfiguration.CUSTOM_SERVICE_SKIP_CALL;
        this.customSaveMethod = MSFConfiguration.CUSTOM_SERVICE_SKIP_CALL;
        this.customReadMethod = MSFConfiguration.CUSTOM_SERVICE_SKIP_CALL;
    }

    public Boolean isReloadData() {
        return this.reloadData;
    }

    /**
     * Permette di definire se rileggere lato server il dato oppure no
     * @param reloadData
     */
    public void setReloadData(Boolean reloadData) {
        this.reloadData = reloadData;
    }

    public Page getPage() {
        return page;
    }
    public void setPage(Page page) {
        this.page = page;
    }

    public boolean isCheckBoxOnGridRows() {
        return checkBoxOnGridRows;
    }
    public void setCheckBoxOnGridRows(boolean checkBoxOnGridRows) {
        this.checkBoxOnGridRows = checkBoxOnGridRows;
    }
   
//    public boolean isRowNumberer() {
//        return rowNumbererGrid;
//    }
//    public void setRowNumberer(boolean rowNumbererGrid) {
//        this.rowNumbererGrid = rowNumbererGrid;
//    }
    
    

    public MSFGridPanel getMsfGridPanel() {
        return msfGridPanel;
    }
    public void setMsfGridPanel(MSFGridPanel msfGridPanel) {
        this.msfGridPanel = msfGridPanel;
    }

    public LayoutContainer getCustomLayoutContainer() {
        return customLayoutContainer;
    }

    public void setCustomLayoutContainer(LayoutContainer customLayoutContainer) {
        this.customLayoutContainer = customLayoutContainer;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    public int getWidth() {
        return width;
    }

    public void setLabelWidth(int labelWidth) {
        this.labelWidth = labelWidth;
    }
    public int getLabelWidth() {
        return labelWidth;
    }

    public int getSearchFormLabelWidth() {
        return searchFormLabelWidth;
    }
    public void setSearchFormLabelWidth(int searchFormLabelWidth) {
        this.searchFormLabelWidth = searchFormLabelWidth;
    }

    public int getSearchFormFieldWidth() {
        return searchFormFieldWidth;
    }
    public void setSearchFormFieldWidth(int searchFormFieldWidth) {
        this.searchFormFieldWidth = searchFormFieldWidth;
    }

    public int getSearchFormHeight() {
        return searchFormHeight;
    }
    public void setSearchFormHeight(int searchFormHeight) {
        this.searchFormHeight = searchFormHeight;
    }

    public void addTrigger(EventType event, Listener<BaseEvent> listener){
        if (this.triggers == null) {
            this.triggers = new ArrayList<MSFSimpleTrigger>();
        }
        this.triggers.add(new MSFSimpleTrigger(event, listener));
    }

    public List<MSFSimpleTrigger> getTriggers() {
        return this.triggers;
    }

    public void setShowFilterToolbar(boolean showFilterToolbar) {
        this.showFilterToolbar = showFilterToolbar;
    }

    public boolean showFilterToolbar() {
        return this.showFilterToolbar;
    }

    public void setEnableHistoryView(boolean enableHistoryView) {
        this.enableHistoryView = enableHistoryView;
    }

    public boolean getEnableHistoryView() {
        return this.enableHistoryView;
    }
    
    public void setCellModel(boolean CellModel) {
        this.isCellModel = CellModel;
    }
    
    public boolean isCellModel() {
        return isCellModel;
    }
}
