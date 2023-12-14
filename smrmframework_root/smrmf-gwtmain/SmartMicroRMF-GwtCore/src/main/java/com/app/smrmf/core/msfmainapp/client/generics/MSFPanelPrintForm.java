/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.generics;

import java.util.Date;
import java.util.HashMap;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.def.BaseRecordDef;
import com.app.smrmf.core.msfmainapp.client.def.PrintFilterDef;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;

import com.extjs.gxt.ui.client.binding.FieldBinding;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.Radio;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.i18n.client.DateTimeFormat;

public class MSFPanelPrintForm extends ContentPanel{
    private MSFCustomForm customForm;
    private Button printBtn;
    private ToolBar bottomToolbar;
    private PrintFilterDef printFilterDef;
    private Boolean postCall = false;
    private String  url = ""; 

    public MSFPanelPrintForm(PrintFilterDef printFilterDef, int width){
        this(printFilterDef, width, 100);
    }
    
    public MSFPanelPrintForm(PrintFilterDef printFilterDef, int width, int labelWidth){
        super();
        setBodyBorder(true);
        setBorders(false);
        setHeadingText(printFilterDef.getTitle());   //setHeading(printFilterDef.getTitle());  
        setWidth(width);
        setLayout(new FitLayout());  
        this.printFilterDef = printFilterDef;
        
        customForm = new MSFCustomForm(printFilterDef, width, labelWidth, true);
        customForm.setFrame(false);
        customForm.setBodyBorder(false);
        customForm.setBorders(false);
        customForm.setHeaderVisible(false);

        add(customForm);

        ToolBar bottomToolbar = getBottomToolbar();
        bottomToolbar.add(new FillToolItem());
        printBtn = new Button(MSFMainApp.MSFCONSTANTS.BtStampa(), myButtonListener);
        printBtn.setIcon(MSFMainApp.ICONS.print16());
        bottomToolbar.add(printBtn);
        setBottomComponent(bottomToolbar);
    }

    private SelectionListener<ButtonEvent> myButtonListener = new SelectionListener<ButtonEvent>() {
        public void componentSelected(ButtonEvent ce) {
            HashMap<String, String> param = getURLParam();
            param.put("rdaFile", printFilterDef.getReportRDAFile());
            GWTUtils.runReport(MSFPanelPrintForm.this.getURL(), param, postCall);
        }
    };
    
    public MSFCustomForm getCustomForm() {
        return customForm;
    }

    public void setPadding(int top, int bottom, int left, int right){
        if (top    != 0) setStyleAttribute("paddingTop"   , top+"px");
        if (bottom != 0) setStyleAttribute("paddingBottom", bottom+"px");
        if (left   != 0) setStyleAttribute("paddingLeft"  , left+"px");
        if (right  != 0) setStyleAttribute("paddingRight" , right+"px");
    }
    
    public ToolBar getBottomToolbar(){
        if (this.bottomToolbar == null) {
            this.bottomToolbar = new ToolBar();
        }
        return this.bottomToolbar;
    }
    
    public HashMap<String, String> getURLParam() {
        HashMap<String, String> result = new HashMap<String, String>();
        FormBinding binding = customForm.getFormBinding();
        for (FieldBinding fieldBinding : binding.getBindings()) {
            Field field = fieldBinding.getField();
            if (field != null && field.isEnabled()) {
                String value = getFieldValueAsString(field);
                result.put(field.getItemId(),value);
            }
        }
        return result;
    }

    private String getFieldValueAsString(Field field) {
        String value = null;
        Object obj = field.getValue();
        if (obj != null) {
            if (obj instanceof String) {
                value = (String)obj;
            } else if (obj instanceof Date) {
                DateTimeFormat formatter = DateTimeFormat.getFormat(MSFMainApp.MSFCONSTANTS.DateFormat());
                value = formatter.format((Date)obj);
            } else if (obj instanceof Double) {
                value = String.valueOf(obj);
            } else if (obj instanceof Long) {
                value = String.valueOf(obj);
            } else if (obj instanceof BaseModel) {
                BaseModel bm = (BaseModel)obj;
                value = String.valueOf(bm.get(BaseRecordDef.ID));
            } else if (obj instanceof Boolean) {
                value = String.valueOf(obj);
            } else if (obj instanceof Radio) {
                value = ((Radio)obj).getValueAttribute();
            }
        }
        return value;
    }

    public void setPostCall(Boolean postCall) {
        this.postCall = postCall;
    }

    public Boolean isPostCall() {
        return postCall;
    }

    public String getURL() {
        return url;
    }

    public void setURL(String url) {
        this.url = url;
    }
    
    
}
