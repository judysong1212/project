/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.def;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ListColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.Lov;
import com.app.smrmf.core.msfmainapp.client.listner.ColumnDefListenerAdapter;
import com.app.smrmf.core.msfmainapp.client.utils.CustomNumberPropertyEditor;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.client.utils.MSFComponentKeyPress;
import com.app.smrmf.core.msfmainapp.client.utils.MSFNumberPropertyEditor;
import com.app.smrmf.core.msfmainapp.client.widget.DateFieldMask;
import com.app.smrmf.core.msfmainapp.client.widget.MSFCheckBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFColorField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFDateField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFHtmlEditor;
import com.app.smrmf.core.msfmainapp.client.widget.MSFImage;
import com.app.smrmf.core.msfmainapp.client.widget.MSFLovField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFNumberField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTextArea;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTextField;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTrigger;
import com.app.smrmf.core.msfmainapp.client.widget.TextFieldMask;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.SortDir;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.form.BooleanPropertyEditor;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.DateTimePropertyEditor;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.HtmlEditor;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.NumberPropertyEditor;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.TriggerField;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.grid.CheckColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.grid.SummaryColumnConfig;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Window;


public class ColumnDef {

    // TIPI DATI
    public static final int TYPE_STRING   = 1; 
    public static final int TYPE_DATE     = 2; 
    public static final int TYPE_LONG     = 3; 
    public static final int TYPE_DOUBLE   = 4; 
    public static final int TYPE_BOOLEAN  = 5;
    public static final int TYPE_DATETIME = 6; 
    public static final int TYPE_BIGDECIMAL = 7;
    

    // TIPI DI FIELD TEXT
    public static final String TEXTFIELD   = "TEXTFIELD";
    public static final String TEXTAREA    = "TEXTAREA";
    public static final String HTMLEDITOR  = "HTMLEDITOR";
    public static final String LABELFIELD  = "LABELFIELD";
    public static final String COLORFIELD  = "COLORFIELD";
    public static final String HTMLVIEW    = "HTMLVIEW";
    public static final String FILEUPLOAD  = "FILEUPLOAD";

    private String title;        //타이틀제목
    private String attributeName;  //컬럼영문명
    private int attributeType;       //데이터 타입
    private String attributeFormula;  //컬럼공식
    private int columnGridWidth;      //그리드길이 
    private String  emptyText;        //컬럼 공백
    private Boolean isRequired;       //데이터 필수 여부 
    private Boolean isVisibleInGrid;  //그리드에 보여줄지여부 
    private Boolean isVisibleInForm;   //폼에 보여줄지여부
    private Boolean isVisibleInExport     = false;   //익스포트 보여줄지여부
    private Boolean isVisibleInSearchForm = false;   //검색폼보여줄지여부
    private Boolean isReadOnly            = false;   //data readonly 
    private Boolean isEnabled             = true;    //활성화여부
    private Boolean isFakeAttribute       = false;   //??
    private Boolean isSelectOnFocus       = false; //edit select
    private Boolean isPassword   =  false;       //패스워드여부 
    
 
    private String typeTextField = null;
    private Lov lov;
    protected int     sortPos = 0;
    protected SortDir sortDir = SortDir.ASC;
    private IColumnFilter columnFilters;
    private DateTimeFormat formatDate     = DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat());
    private DateTimeFormat formatDateTime = DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateTimeFormat());
    private NumberFormat   formatNumeric = NumberFormat.getDecimalFormat();
    private String regEx;
    private String txtFieldMask;
    private String dtFieldMask;
    
    private int maxLength = Integer.MAX_VALUE;
    private int fieldHeight;
    private HorizontalAlignment textAlign;
    private Object         defaultValue;
    private Object         defaultSearchValue;
    private int maxDecimals  = 8;
    protected Field columnField;
    protected GridCellRenderer<BaseModel> gridCellRenderer;
    protected SummaryColumnConfig summaryColumnConfig = null;

    public static int SIZE_FOR_TEXT_AREA = 250;
    // CUSTOM FORM ATTRIBUTE
    private AttributeCustomForm attributeCustomForm;
    // LIST TRIGGERS
    protected List<MSFTrigger> triggers = null;
    
    protected TableDef parent;

    public ColumnDef(
            String title,             //타이틀제목
            String attributeName,     //컬럼영문명
            int type,                 //데이터 타입
            int columnGridWidth,      //그리드 길이
            Boolean isRequired,       //데이터 필수 여부 
            Boolean isVisibleInGrid,  //그리드에 보여줄지여부 
            Boolean isVisibleInForm,  //폼에 보여줄지여부
            Boolean isReadonly){   //data readonly
        this.title = title;
        this.attributeName = GWTUtils.adjustsColumnDefName(attributeName);
        this.attributeType = type;
        this.columnGridWidth = columnGridWidth;
        this.isRequired = isRequired;
        this.isVisibleInGrid = isVisibleInGrid;
        this.isVisibleInForm = isVisibleInForm;
        this.isVisibleInSearchForm = isVisibleInGrid;
        this.isVisibleInExport = isVisibleInGrid;
        this.isReadOnly = isReadonly;
    }

    public ColumnDef(
            String title, 
            String attributeName, 
            int type, 
            int columnGridWidth,
            Boolean isRequired, 
            Boolean isVisibleInGrid,
            Boolean isVisibleInForm) {
        this(title, attributeName, type, columnGridWidth, isRequired, isVisibleInGrid, isVisibleInForm, false);
    }

    public ColumnDef(
            String title, 
            String attributeName, 
            int type, 
            Boolean isRequired, 
            Boolean isVisibleInForm,
            AttributeCustomForm attributeCustomForm){
        this(title, attributeName, type, 0, isRequired, false, isVisibleInForm);
        setAttributeCustomForm(attributeCustomForm);
    }

    public ColumnDef(
            String title, 
            String attributeName, 
            int type, 
            Boolean isRequired, 
            Boolean isVisibleInForm){
        this(title, attributeName, type, 0, isRequired, false, isVisibleInForm);
    }

    public ColumnDef(
            String title, 
            String attributeName, 
            int type){
        this(title, attributeName, type, 0, false, false, false);
    }

    public int getType() {
        return attributeType;
    }

    public void setType(int type) {
        this.attributeType = type;
    }

    public int getSize() {
        return columnGridWidth;
    }

    public void setSize(int size) {
        this.columnGridWidth = size;
    }

    public Boolean getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Boolean isRequired) {
        this.isRequired = isRequired;
    }

    public Boolean isVisibleInGrid() {
        return isVisibleInGrid;
    }

    public void setIsVisibleInGrid(Boolean isVisibleInGrid) {
        this.isVisibleInGrid = isVisibleInGrid;
    }


    public Boolean isVisibleInForm() {
        return isVisibleInForm;
    }

    public void setIsVisibleInForm(Boolean isVisibleInForm) {
        this.isVisibleInForm = isVisibleInForm;
    }

   
    
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAttributeName() {
        return attributeName;
    }
    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName.replace(".", TableDef.SEPARATOR_CLIENT);
    }

    public String getAttributeFormula() {
        return attributeFormula;
    }
    public void setAttributeFormula(String attributeFormula) {
        if ( MSFSharedUtils.paramNotNull(attributeFormula) ) {
            attributeFormula = GWTUtils.replacePercentWithLocale(attributeFormula);
        }
        this.attributeFormula = attributeFormula;
    }

    public String getIdHTML() {
        //return transactionId+"."+attributeName;
        return attributeName;
    }

    public ColumnConfig getColumnConfig(){
        ColumnConfig result = null;
        switch ( this.attributeType ) {
        case TYPE_STRING:
                result = new ColumnConfig() {
                    {
                        setSortable(true);
                        setAlignment(textAlign!=null ? textAlign : HorizontalAlignment.LEFT);
                  
                        
                    }
                }; 
//TODO 최종정리시 추가 마스크 작업            if (TEXTFIELD.equals(getTipoCampoText())) {
//                
//           
//                result.setRenderer(new GridCellRenderer<BaseModel>() {
//                @Override
//                public Object render(BaseModel model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<BaseModel> store, Grid<BaseModel> grid) {
//                    
//                    MaskUtils.setReMask(grid.getColumnModel().getColumnById("jobYrMnth").getId(), "9999.99", null);                 
//                    return grid;
//                   
//                }
//            });
//            } else       
            if (COLORFIELD.equals(getTipoCampoText())) {
                result.setRenderer(new GridCellRenderer<BaseModel>() {
                @Override
                public Object render(BaseModel model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<BaseModel> store, Grid<BaseModel> grid) {
             
                    String colore = (String)model.get(property);
                    String style = GWTUtils.removeBackgroudFromStyle(config.style);
                    if ( !MSFSharedUtils.isEmpty(colore) ) {
                        style += " background-color:#"+colore+";";
                    }
                    config.style = style;                        
                    return colore;
                }
            });
            } else if (FILEUPLOAD.equals(getTipoCampoText())) {
                result.setRenderer(new GridCellRenderer<BaseModel>() {
                    @Override
                    public Object render(BaseModel model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<BaseModel> store, Grid<BaseModel> grid) {
                        final String fileName = (String)model.get(property);
                        if (!MSFSharedUtils.isEmpty(fileName)) {
                            MSFImage button = new MSFImage();
                            //Button button = new Button();
                            button.setToolTip(fileName);
//                            button.setIcon(MSFMainApp.ICONS.save());
                            button.setIcon(MSFMainApp.CUSTOM_ICONS.save());
//                            button.addSelectionListener(new SelectionListener<ButtonEvent>() {
//                                public void componentSelected(ButtonEvent ce) {
                            button.addClickHandler(new ClickHandler() {
                                public void onClick(ClickEvent arg0) {
                                    String url = GWT.getHostPageBaseURL()+MSFMainApp.getMsg("ATTACHMENTS_PATH")+"/";
                                    Window.open(url+fileName,"_blank", null);
                                }
                            });
                            return button;
                        }
                        return null;
                    }
                });
            }
         
            break;
        case TYPE_DATE:
            result = new ColumnConfig() {
                {
                    setSortable(true);
                    setDateTimeFormat(getFormatDate()); 
                    setAlignment(textAlign!=null ? textAlign : HorizontalAlignment.LEFT);
                }
            };
            break;
        case TYPE_DATETIME:
            result = new ColumnConfig() {
                {
                    setSortable(true);
                    setDateTimeFormat(getFormatDateTime());
                    setAlignment(textAlign!=null ? textAlign : HorizontalAlignment.LEFT);
                }
            };
            break;
        case TYPE_LONG:
        case TYPE_DOUBLE:
        case TYPE_BIGDECIMAL:
            result = new ColumnConfig() {
                {
                    setSortable(true);
                    setNumberFormat(formatNumeric);
                    setAlignment(textAlign!=null ? textAlign : HorizontalAlignment.RIGHT);
                  
                }
            };
            break;
        case TYPE_BOOLEAN:
            result = new CheckColumnConfig(){
                {
                    setAlignment(textAlign!=null ? textAlign : HorizontalAlignment.CENTER);
                }
            };
            break;
        }
        result.setHeaderText(getTitle());  //.setHeader(getTitle());
        result.setId(getIdHTML());
        result.setWidth(getSize());
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
    
    private void setColumnEditor(ColumnConfig columnConfig) {
        switch ( this.attributeType ) {
        case TYPE_STRING:
            columnConfig.setEditor(new CellEditor(getTextField(null)));
            break;
        case TYPE_DATE:
        case TYPE_DATETIME:
        case TYPE_LONG:
        case TYPE_DOUBLE:
        case TYPE_BIGDECIMAL:
        case TYPE_BOOLEAN:
            columnConfig.setEditor(new CellEditor(getVisibleField()));
            break;
        }
    }

    public Field getVisibleField(){
        Field result = getVisibleField(null);
        return result;
    }

    public Field getVisibleField(Field result){
        //Field result = null;
        if (lov!=null ) {
            result = getLovField((MSFLovField)result);
        } else if (TYPE_STRING==this.attributeType ) {
            if (getTipoCampoText() == null) {
                if (getSize() <= SIZE_FOR_TEXT_AREA) {
                    setTypeTextField(TEXTFIELD);
                } else {
                    setTypeTextField(TEXTAREA);
                }
            }
            if (TEXTAREA.equals(getTipoCampoText())) {
                result = getTextArea((MSFTextArea)result);
            } else if (HTMLEDITOR.equals(getTipoCampoText())) {
                result = getHtmlEditor();
            } else if (HTMLVIEW.equals(getTipoCampoText())) {
                result = getHtmlView();
            } else if (LABELFIELD.equals(getTipoCampoText())) {
                result = getLabelField();
            } else if (COLORFIELD.equals(getTipoCampoText())) {
                result = getColorField();
            } else if (FILEUPLOAD.equals(getTipoCampoText())) {
                result = getFileUploadField();
            } else {
                result = getTextField((MSFTextField)result);
            }
        } else if (TYPE_DATE==this.attributeType) {
            result = getDateField((MSFDateField)result, false);
        } else if (TYPE_DATETIME==this.attributeType) {
            result = getDateField((MSFDateField)result, true);
        } else if (TYPE_LONG==this.attributeType) {
            result = getNumberField((MSFNumberField)result);
        } else if (TYPE_DOUBLE==this.attributeType) {
            result = getNumberField((MSFNumberField)result);
        } else if (TYPE_BIGDECIMAL==this.attributeType) {
            result = getNumberField((MSFNumberField)result); 
        } else if (TYPE_BOOLEAN==this.attributeType) {
            result = getCheckBoxField((MSFCheckBox)result);
        }

        //configureVisibleField(result);
        return result;
    }



    public void configureMSFField(Field result){

        result.setItemId(getIdHTML());
        result.setFieldLabel(getTitle()); 
        result.setReadOnly(isReadOnly); 
        result.setEnabled(isEnabled);
        result.setName(attributeName);

        if (triggers != null) {
            if (triggers.size() > 0) {
                for (final MSFTrigger trigger : triggers) {
                    if (trigger.getListener() != null && trigger.getEventType() != null) {
                        result.addListener(trigger.getEventType(), new Listener<BaseEvent>() {
                            public void handleEvent(BaseEvent be) {
                                Object o = be.getSource();
                                Field  f = null;
                                Object v = null;
                                if (o instanceof Field) {
                                    f = (Field)o;
                                    v = f.getValue();
                                }
                                trigger.getListener().initialize(f);
                                trigger.getListener().run(f, v);
                            }
                        });
                    }
                    
                }
            }
        }
        
        if (!MSFSharedUtils.isEmpty(emptyText)) {
            result.setEmptyText(emptyText);
        }

    }

    public Field getField(){
        Field result = null;
        if (this.isVisibleInForm) {
            result = getVisibleField();
        } else {
            if (TYPE_STRING==this.attributeType) {
                result = new HiddenField<String>();
            } else if (TYPE_DATE==this.attributeType) {
                result = new HiddenField<Date>();
                result.setPropertyEditor(new DateTimePropertyEditor());
            } else if (TYPE_DATETIME==this.attributeType) {
                result = new HiddenField<Date>();
                result.setPropertyEditor(new DateTimePropertyEditor());
            } else if (TYPE_LONG==this.attributeType) {
                result = new HiddenField<Long>();
                result.setPropertyEditor(new NumberPropertyEditor(Long.class));
            } else if (TYPE_DOUBLE==this.attributeType) {
                result = new HiddenField<Double>();
                result.setPropertyEditor(new NumberPropertyEditor(Double.class));
            } else if (TYPE_BIGDECIMAL==this.attributeType) {
                result = new HiddenField<BigDecimal>();
                result.setPropertyEditor(new CustomNumberPropertyEditor(BigDecimal.class));
            } else if (TYPE_BOOLEAN==this.attributeType) {
                result = new HiddenField<Boolean>();
                result.setPropertyEditor(new BooleanPropertyEditor());
            }
            result.setItemId(getIdHTML());
        }
        columnField = result;
        return result;
    }

    public Field getSearchField(){
        Field result = null;
        if (this.isVisibleInForm) {
            if (       TYPE_STRING==this.attributeType) {
                result = getTextField(null);
            } else if (TYPE_DATE==this.attributeType) {
                result = getDateField(null, false);
            } else if (TYPE_DATETIME==this.attributeType) {
                result = getDateField(null, true);
            } else if (TYPE_LONG==this.attributeType) {
                result = getNumberField(null);
            } else if (TYPE_DOUBLE==this.attributeType) {
                result = getNumberField(null);
            } else if (TYPE_BIGDECIMAL==this.attributeType) {
                result = getNumberField(null);    
            } else if (TYPE_BOOLEAN==this.attributeType) {
                //result = getCheckBoxField(null);
                ColumnListStaticDef booleanCombo = new TrueFalseNullStaticDef(title, attributeName, ColumnDef.TYPE_STRING, 150, isRequired, isVisibleInGrid, isVisibleInForm);
                result = booleanCombo.getSearchField();
            }
        }
        return result;
    }

    public int getHeight(){
        int result = 0;
        if (this.isVisibleInForm) {
            result = 27;
        }
        return result;
    }

    public int getHeightSearchField(){
        int result = 0;
        if (this.isVisibleInSearchForm) {
            result = 27;
        }
        return result;
    }

    /**
     * Set the type of text field, see ColumnDef constants 
     * @param typeTextField
     */
    public void setTypeTextField(String t) {
        this.typeTextField = t;
    }

    public String getTipoCampoText() {
        return typeTextField;
    }

    private CheckBox getCheckBoxField(MSFCheckBox result){
        if ( result==null ) {
            result = new MSFCheckBox();
            result.setWidth(100);
        }
        configureCheckBox(result);
        return result;
    }

    private NumberField getNumberField(MSFNumberField result) {//, boolean allowNegative){
        if ( result==null ) {
            result = new MSFNumberField();
            result.setWidth(100);
        }
        configureNumberField(result);
        return result;
    }

    private DateField getDateField(MSFDateField result, boolean withTime) {
        if ( result==null ) {
            result = new MSFDateField();
            result.setWidth(100);
        }
        configureDateField(result, withTime);
        return result;
    }

    private TextArea getTextArea(MSFTextArea result) {
        if ( result==null ) {
            result = new MSFTextArea();
            result.setWidth(300);
            if ( fieldHeight>0 ) {
                result.setHeight(fieldHeight);
            }
        }
        configureTextArea(result);
        return result;
    }

    private MSFTextField getTextField(MSFTextField result) {
        if ( result==null ) {
            result = new MSFTextField();
            result.setWidth(300);
        }
        configureTextField(result);
 
        return result;
    }

    private HtmlEditor getHtmlEditor(){
        MSFHtmlEditor result = new MSFHtmlEditor();
        result.setItemId(getIdHTML());
        result.setFieldLabel(getTitle());
        result.setWidth(300);
        if ( fieldHeight>0 ) {
            result.setHeight(fieldHeight);
        } else {
            result.setHeight(200);
        }
        return result;
    }

    private HtmlEditor getHtmlView() {
        MSFHtmlEditor result = new MSFHtmlEditor();
        result.setItemId(getIdHTML());
        result.setFieldLabel(getTitle());
        result.setWidth(300);
        if ( fieldHeight>0 ) {
            result.setHeight(fieldHeight);
        } else {
            result.setHeight(200);
        }
        result.setShowToolbar(false);
        result.setEnabled(false);
        return result;
    }

    private LabelField getLabelField(){
        LabelField result = new LabelField();
        result.setItemId(getIdHTML());
        result.setFieldLabel(getTitle());
        result.setWidth(300);
        return result;
    }

    private MSFColorField getColorField(){
        MSFColorField result = new MSFColorField();
        result.setItemId(getIdHTML());
        result.setFieldLabel(getTitle());
        result.setWidth(300);
        configureColorField(result);
        return result;
    }

    private MSFLovField getLovField(MSFLovField result){
        if ( result == null ) {
            result = new MSFLovField();
            result.setWidth(300);
        }
        configureLovField(result);
        return result;
    }

    protected Field getFileUploadField() {
        FileUploadField result = new FileUploadField();
        result.setItemId(getIdHTML());
        result.setFieldLabel(getTitle());
        result.setWidth(300);
        result.setButtonOffset(10);
        result.setShim(true);
        result.setData("urlServlet", "FileUploadServlet"); // Default servlet name FileUpload
        configureMSFField(result);
        return result;
    }

    private void configureNumberField(MSFNumberField result) {//, boolean allowNegative){
        result.setColumnDef(this);
        MSFNumberPropertyEditor propertyEditor = new MSFNumberPropertyEditor(getFormatNumeric());
        propertyEditor.setStripGroupSeparator(true);
        
        if (TYPE_LONG==this.attributeType) {
            result.setAllowDecimals(false);
            propertyEditor.setType(Long.class);
        } else {
            result.setAllowDecimals(true);
            propertyEditor.setType(Double.class);
        }
        result.setAllowNegative(true);//allowNegative);
        result.setPropertyEditor(propertyEditor);
        result.setFormat(getFormatNumeric());
        if (this.isRequired) {
            ((NumberField)result).setAllowBlank(false);
            NumberField.NumberFieldMessages messagesNote = ((NumberField)result).new NumberFieldMessages();
            messagesNote.setBlankText(MSFMainApp.MSFCONSTANTS.CampoObbligatorio());
            ((NumberField)result).setMessages(messagesNote);    
        }
        result.setMaxLength(maxLength);
        result.setMaxDecimals(maxDecimals);
        result.setSelectOnFocus(isSelectOnFocus);
        //Allineo a destra
        result.setInputStyleAttribute("text-align","right");
        // Aggiunge il controllo della lunghezza del campo
        result.addKeyListener(new MSFComponentKeyPress()); 
        //Setto il property editor corretto
        if (        TYPE_LONG==this.attributeType ) {
            result.setPropertyEditorType(Long.class);
        } else if ( TYPE_DOUBLE==this.attributeType ) {
            result.setPropertyEditorType(Double.class);
        
	    } else if ( TYPE_BIGDECIMAL==this.attributeType ) {
	        result.setPropertyEditorType(BigDecimal.class);
	    }
        configureMSFField(result);
    }
    //TODO MASK
    private void configureTextField(MSFTextField result) {
        result.setColumnDef(this);
        if (this.isRequired) {
            ((TextField<String>)result).setAllowBlank(false);
            TextField<String>.TextFieldMessages messagesNote = ((TextField<String>)result).new TextFieldMessages();
            messagesNote.setBlankText(MSFMainApp.MSFCONSTANTS.CampoObbligatorio());
            ((TextField<String>)result).setMessages(messagesNote);
        }
        if (MSFSharedUtils.paramNotNull(regEx)) {
            result.setRegex(regEx);
            TextField<String>.TextFieldMessages messagesNote = ((TextField<String>)result).getMessages();
            if (messagesNote == null) {
                messagesNote = ((TextField<String>)result).new TextFieldMessages();
                ((TextField<String>)result).setMessages(messagesNote);
            }
            messagesNote.setRegexText(MSFMainApp.MSFCONSTANTS.RegExMessage());
        }
        //TODO 마스크처리를 위한 뤀틴 추가 
        if (MSFSharedUtils.paramNotNull(txtFieldMask)) { 
            new TextFieldMask<String>(result, txtFieldMask);
//            TextField<String>.TextFieldMessages messagesNote = ((TextField<String>)result).getMessages();
//            if (messagesNote == null) {
//                messagesNote = ((TextField<String>)result).new TextFieldMessages();
//                ((TextField<String>)result).setMessages(messagesNote);
//            }
//            messagesNote.setRegexText(MSFMainApp.MSFCONSTANTS.RegExMessage());
        }
        
        result.setPassword(isPassword);
        result.setMaxLength(maxLength);
        result.setSelectOnFocus(isSelectOnFocus);
        result.addKeyListener(new MSFComponentKeyPress());
        configureMSFField(result);
    }

    private void configureColorField(MSFColorField result) {
        result.setColumnDef(this);
        if (this.getIsRequired()) {
            result.setAllowBlank(false);
            TriggerField<String>.TextFieldMessages messagesNote = result.new TextFieldMessages();
            messagesNote.setBlankText(MSFMainApp.MSFCONSTANTS.CampoObbligatorio());
            result.setMessages(messagesNote);
        }
        if (MSFSharedUtils.paramNotNull(getRegEx())) {
            result.setRegex(getRegEx());
            TriggerField<String>.TextFieldMessages messagesNote = result.getMessages();
            if (messagesNote == null) {
                messagesNote = ((TextField<String>)result).new TextFieldMessages();
                result.setMessages(messagesNote);
            }
            messagesNote.setRegexText(MSFMainApp.MSFCONSTANTS.RegExMessage());
        }
        result.setMaxLength(getMaxLength());
        result.addKeyListener(new MSFComponentKeyPress());
        configureMSFField(result);
    }    
    //TODO MASK
    private void configureDateField(MSFDateField result, boolean withTime) {
        result.setColumnDef(this);
        DateTimePropertyEditor propertyEditor = new DateTimePropertyEditor();
        propertyEditor.setFormat(withTime ? getFormatDateTime() : getFormatDate());
        result.setPropertyEditor(propertyEditor);
        if (this.isRequired) {
            ((DateField)result).setAllowBlank(false);
            DateField.DateFieldMessages messagesNote = ((DateField)result).new DateFieldMessages();
            messagesNote.setBlankText(MSFMainApp.MSFCONSTANTS.CampoObbligatorio());
            ((DateField)result).setMessages(messagesNote);
        }
        
        if (MSFSharedUtils.paramNotNull(dtFieldMask)) { 
            new DateFieldMask(result, dtFieldMask);
//            TextField<String>.TextFieldMessages messagesNote = ((TextField<String>)result).getMessages();
//            if (messagesNote == null) {
//                messagesNote = ((TextField<String>)result).new TextFieldMessages();
//                ((TextField<String>)result).setMessages(messagesNote);
//            }
//            messagesNote.setRegexText(MSFMainApp.MSFCONSTANTS.RegExMessage());
        }
         
        configureMSFField(result);
    }

    private void configureTextArea(MSFTextArea result) {
        result.setColumnDef(this);
        if (this.isRequired) {
            ((TextArea)result).setAllowBlank(false);
            TextArea.TextFieldMessages messagesNote = ((TextArea)result).new TextFieldMessages();
            messagesNote.setBlankText(MSFMainApp.MSFCONSTANTS.CampoObbligatorio());
            ((TextArea)result).setMessages(messagesNote);
        }
        result.setMaxLength(maxLength);
        result.addKeyListener(new MSFComponentKeyPress());
        configureMSFField(result);
    }

    private void configureCheckBox(MSFCheckBox result) {
        result.setColumnDef(this);
        result.setFireChangeEventOnSetValue(false);
        configureMSFField(result);
    }

    private void configureLovField(MSFLovField result) {
        result.setColumnDef(this);
        result.setLov(lov);
        lov.fixAttributeFormNames();
        if (this.isRequired) {
            ((TextField<String>)result).setAllowBlank(false);
            TextField<String>.TextFieldMessages messagesNote = ((TextField<String>)result).new TextFieldMessages();
            messagesNote.setBlankText(MSFMainApp.MSFCONSTANTS.CampoObbligatorio());
            ((TextField<String>)result).setMessages(messagesNote);
        }
        if (MSFSharedUtils.paramNotNull(regEx)) {
            result.setRegex(regEx);
            TextField<String>.TextFieldMessages messagesNote = ((TextField<String>)result).getMessages();
            if (messagesNote == null) {
                messagesNote = ((TextField<String>)result).new TextFieldMessages();
                ((TextField<String>)result).setMessages(messagesNote);
            }
            messagesNote.setRegexText(MSFMainApp.MSFCONSTANTS.RegExMessage());
        }
        if (MSFSharedUtils.paramNotNull(txtFieldMask)) {
            new TextFieldMask<String>(result, txtFieldMask);
//            TextField<String>.TextFieldMessages messagesNote = ((TextField<String>)result).getMessages();
//            if (messagesNote == null) {
//                messagesNote = ((TextField<String>)result).new TextFieldMessages();
//                ((TextField<String>)result).setMessages(messagesNote);
//            }
//            messagesNote.setRegexText(MSFMainApp.MSFCONSTANTS.RegExMessage());
        }
        if (this.isPassword) {
        	result.setPassword(isPassword);
        }	
        result.setMaxLength(maxLength);
        result.addKeyListener(new MSFComponentKeyPress());
        //Setto il property editor corretto
        if (        TYPE_LONG==this.attributeType ) {
            result.setPropertyEditor(new NumberPropertyEditor(Long.class));
        } else if ( TYPE_DOUBLE==this.attributeType ) {
            result.setPropertyEditor(new NumberPropertyEditor(Double.class));
        } else if ( TYPE_BIGDECIMAL==this.attributeType ) {
    	    result.setPropertyEditor(new CustomNumberPropertyEditor(BigDecimal.class));
    	}
        configureMSFField(result);
    }

    public HorizontalAlignment getTextAlign(){
        return this.textAlign;
    }
    public void setTextAlign(HorizontalAlignment textAlign){
        this.textAlign = textAlign;
    }

    /**
     * With this method you can set the index of order about the ColumnDef
     * 
     * @param orderPosition index of order by (default 0, attribute not considered)
     */
    public void setSortPosition(int sortPos) {
        this.sortPos = sortPos;
    }

    /**
     * With this method you can set the index of sorter and the direction about the ColumnDef
     * 
     * @param sortPos index of order by (default 0, attribute not considered)
     * @param sortDir direction ASC o DESC (default ASC)
     */
    public void setSortPosDir(int sortPos, SortDir sortDir) {
        this.sortPos = sortPos;
        this.sortDir = sortDir;
    }

    public int getSortPos() {
        return this.sortPos;
    }

    public SortDir getSortDir() {
        return this.sortDir;
    }

    public String getSortAttributes() {
        if (sortPos > 0) {
            return getIdHTML() + " " + sortDir.name();
        } 
        return "";
    }

    public void setLov(Lov lov) {
        this.lov = lov;
    }

    public Lov getLov() {
        return lov;
    }

//    public ColumnDef getColumnDef(){
//        return this;
//    }

    /**
     * This method allows to add more filter condition about the column. 
     * All this condition are added to List<ColumnFilter> of the TableDef defined.
     * @param value of the condition (String, Long, ecc)
     * @param operator See ColumnFilter.AVAILABLE_OPERATORS
     */
    public void addColumnFilter(Serializable value, String operator) {
        SimpleColumnFilter scf = new SimpleColumnFilter(this.attributeName, value, operator);
        if (columnFilters == null) {
            columnFilters = scf;
        } else if (columnFilters instanceof SimpleColumnFilter) {
            ListColumnFilter lcf = new ListColumnFilter();
            lcf.addFilter(columnFilters);
            lcf.addFilter(scf);
            columnFilters = lcf;
        } else if (columnFilters instanceof ListColumnFilter) {
            ((ListColumnFilter) columnFilters).addFilter(scf);
        }
    }

    public void setColumnFilters(IColumnFilter columnFilters){
        this.columnFilters = columnFilters;
    }

    /**
     * @return A list of the ColumnFilter about the columnDef
     */
    public IColumnFilter getColumnFilters(){
        return columnFilters;
    }

    public void setFormatDate(DateTimeFormat formatDate) {
        this.formatDate = formatDate;
    }
    public void setFormatDate(String format) {
        this.formatDate = DateTimeFormat.getFormat(format);
    }
    public DateTimeFormat getFormatDate() {
        return formatDate;
    }

    public void setFormatDateTime(DateTimeFormat formatDateTime) {
        this.formatDateTime = formatDateTime;
    }
    public void setFormatDateTime(String formatTime) {
        this.formatDateTime = DateTimeFormat.getFormat(formatTime);
    }
    public DateTimeFormat getFormatDateTime() {
        return formatDateTime;
    }

    public SimpleColumnFilter getColumnFilter(String value) {
        SimpleColumnFilter filter = null;
        Serializable filterValue = null;
        String operator = null;
        try {
            //Convert value to correct data type and use correct operator
            if (TYPE_STRING==this.attributeType) {
                filterValue = value;
                operator    = SimpleColumnFilter.OPERATOR_ILIKE;
            } else if (TYPE_DATE==this.attributeType || TYPE_DATETIME==this.attributeType) {
                filterValue = GWTUtils.getDateFromString(value, getFormatDate().getPattern());
                operator = SimpleColumnFilter.OPERATOR_EQUALS;
            } else if (TYPE_LONG==this.attributeType) {
                filterValue = MSFSharedUtils.convertStringToLong(value);
                operator = SimpleColumnFilter.OPERATOR_EQUALS;
            } else if (TYPE_DOUBLE==this.attributeType) {
                filterValue = MSFSharedUtils.convertStringToDouble(value);
                operator = SimpleColumnFilter.OPERATOR_EQUALS;
            } else if (TYPE_BIGDECIMAL==this.attributeType) {
                filterValue = MSFSharedUtils.convertStringToBigDecimal(value);
                operator = SimpleColumnFilter.OPERATOR_EQUALS;
            } else if (TYPE_BOOLEAN==this.attributeType) {
                filterValue = MSFSharedUtils.convertStringToBoolean(value);
                operator = SimpleColumnFilter.OPERATOR_EQUALS;
            }
            //If conversion was successful create filter
            if ( operator!=null && ( (filterValue!=null && value!=null) || (filterValue==null && value==null) ) ) {
                String filterAttrName = this.attributeName;
                if ( this instanceof ColumnListDef && MSFSharedUtils.paramNotNull(((ColumnListDef)this).attrNameId) ) {
                    filterAttrName += TableDef.SEPARATOR_CLIENT + ((ColumnListDef)this).attrNameDescription;
                }
                filter = new SimpleColumnFilter(filterAttrName, filterValue, operator);
            }
        } catch (Exception e) {
            filter = null;
        }
        return filter;
    }

    public int getColumnGridWidth() {
        return columnGridWidth;
    }

    public void setColumnGridWidth(int columnGridWidth) {
        this.columnGridWidth = columnGridWidth;
    }

    public void setDefaultValue(Object defaultValue) {
        this.defaultValue = defaultValue;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultSearchValue(Object defaultSearchValue) {
        this.defaultSearchValue = defaultSearchValue;
    }

    public Object getDefaultSearchValue() {
        return defaultSearchValue;
    }

    public void setReadOnly(Boolean isReadOnly) {
        this.isReadOnly = isReadOnly;
    }
    
    public void setSelectOnFocus(Boolean isSelectOnFocus) {
        this.isSelectOnFocus = isSelectOnFocus;
    } 
    

    public Boolean isReadOnly() {
        return isReadOnly;
    }
    
    public void setPassword(Boolean isPassword) {
        this.isPassword = isPassword;
    }
    

    public Boolean isPassword() {
        return isPassword;
    }

    public void setAttributeCustomForm(AttributeCustomForm attributeCustomForm) {
        this.attributeCustomForm = attributeCustomForm;
    }

    public AttributeCustomForm getAttributeCustomForm(){
        return this.attributeCustomForm;
    }

    /**
     * To set the regular expression to the field. 
     * Now, it run only with the TextField or its extension, like LovField
     * @param regEx See statis regEx into RegEx class or use your expression 
     */
    public void setRegEx(String regEx) {
        this.regEx = regEx;
    }

    public String getRegEx() {
        return regEx;
    }

    
    /**
     * 텍스트필드 마스크 기능 
     * @param txtFieldMask
     */
    public void setTextFdMask(String txtFieldMask) {
        this.txtFieldMask = txtFieldMask;
    }

    public String getTextFdMask() {
        return txtFieldMask;
    }
    
    /**
     * 날짜 마스크 기능 
     * @param dtFieldMask
     */
    
    public void setDtFieldMask(String dtFieldMask) {
        this.dtFieldMask = dtFieldMask;
    }

    public String getDtFieldMask() {
        return dtFieldMask;
    } 

    
    /**
     * To set the maximum number of characters for TextField, TextArea and NumericField
     * @param maxLength no default set
     */
    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public int getMaxLength() {
        return maxLength;
    }

    /**
     * Height of the field, in case of TEXTAREA or HTMLEDITOR. For other field types height is defined by the system.
     * @return
     */
    public int getFieldHeight() {
        return fieldHeight;
    }
    /**
     * Height of the field, in case of TEXTAREA or HTMLEDITOR. For other field types height is defined by the system.
     * @param fieldHeight
     */
    public void setFieldHeight(int fieldHeight) {
        this.fieldHeight = fieldHeight;
    }

    public void setFormatNumeric(NumberFormat formatNumeric) {
        this.formatNumeric = formatNumeric;
    }

    public void setFormatNumeric(String format) {
        this.formatNumeric = NumberFormat.getFormat(format);
    }

    public NumberFormat getFormatNumeric() {
        return formatNumeric;
    }

    /**
     * Questo metodo permette di impostare il formato per le colonne
     * numeriche. 
     * Il metodo � Deprecated perch� sostituito dal metodo setFormatNumeric, per uniformit�.
     * @param format E' il formato tipo stringa Es. NNNNNN
     * 
     * @deprecated
     */
    @Deprecated
    public void setNumberFormat(String format) {
        this.formatNumeric = NumberFormat.getFormat(format);
    }

    /**
     * Convenience function for setting field disabled/enabled by boolean.
     * 
     * @param enabled the enabled state (default is false)
     */
    public void setEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Boolean isEnabled() {
        return isEnabled;
    }

    public void addTrigger(EventType event, ColumnDefListenerAdapter listener){
        if (this.triggers == null) {
            this.triggers = new ArrayList<MSFTrigger>();
        }
        this.triggers.add(new MSFTrigger(event, listener));
    }

    public List<MSFTrigger> getTriggers() {
        return this.triggers;
    }

    public void setParent(TableDef parent) {
        this.parent = parent;
    }

    public TableDef getParent() {
        return parent;
    }

    /**
     * Sets if the attribute is visible into filter form. 
     * @param isVisibleInSearchForm (default true)
     */
    public void setIsVisibleInSearchForm(Boolean isVisibleInSearchForm) {
        this.isVisibleInSearchForm = isVisibleInSearchForm;
    }
    public Boolean isVisibleInSearchForm() {
        return isVisibleInSearchForm;
    }

    public Boolean isVisibleInExport() {
        return isVisibleInExport;
    }
    public void setIsVisibleInExport(Boolean isVisibleInExport) {
        this.isVisibleInExport = isVisibleInExport;
    }

    public void setIsFakeAttribute(Boolean isFakeAttribute) {
        this.isFakeAttribute = isFakeAttribute;
    }
    public Boolean isFakeAttribute() {
        return isFakeAttribute;
    }

    public int getMaxDecimals() {
        return maxDecimals;
    }

    public void setMaxDecimals(int maxDecimals) {
        this.maxDecimals = maxDecimals;
    }

    public GridCellRenderer<BaseModel> getGridCellRenderer() {
        return gridCellRenderer;
    }

    public void setGridCellRenderer(GridCellRenderer<BaseModel> gridCellRenderer) {
        this.gridCellRenderer = gridCellRenderer;
    }

    public SummaryColumnConfig getSummaryColumnConfig() {
        ColumnConfig cc = getColumnConfig();
        SummaryColumnConfig result = summaryColumnConfig;
        if (result == null) {
            result = new SummaryColumnConfig<Integer>(getAttributeName(), getTitle(), getColumnGridWidth());
        }
        result.setAlignment(cc.getAlignment());
        result.setSortable(cc.isSortable());
        result.setDateTimeFormat(cc.getDateTimeFormat());
        result.setNumberFormat(cc.getNumberFormat());
        result.setRenderer(cc.getRenderer());
        
        return result;
    }

    public void setSummaryColumnConfig(SummaryColumnConfig summaryColumnConfig) {
        this.summaryColumnConfig = summaryColumnConfig;
    }

    /**
     * Sets the default text to display in an empty field.
     * 
     * @param emptyText the empty text
     */
    public void setEmptyText(String emptyText) {
        this.emptyText = emptyText;
    }
}
