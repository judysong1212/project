/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.def.AttributeCustomForm;
import com.app.smrmf.core.msfmainapp.client.def.ClientSession;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.DataHistoryDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnOrder;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.form.MessageDialog;
import com.app.smrmf.core.msfmainapp.client.form.ShowFormErrMsg;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.shared.MSFDaoConstants;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.binding.FieldBinding;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.js.JsUtil;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.Container;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Html;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.MultiField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.grid.LiveGridView;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.layout.FitData;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.http.client.URL;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;


public class GWTUtils {
     
	
	public static  com.extjs.gxt.ui.client.widget.Window  popupDoroWindow;
    
    public static native String getInfoAddress() /*-{
        var geocoder = new GClientGeocoder() ; 
        var address = 'via salaria, rome, italy';
        geocoder.getLatLng( address, 
        function (point) {
            if (! point) {
                return 'address not found';
            } else {
                alert ('Latitude='+point.lat()+'Longitude ='+point.lng());
            }
        }
        ) ; 

    }-*/;

    /**
     * @return the URL of the current page
     */
    public static native String getPageURL()
    /*-{
        return $wnd.location.href.replace(/[\\?#].*$/, "");
      }-*/;  

    /**
     * Set the current window location.
     * 
     * @param url the new URL location
     */
    public static native void setLocation(String url)
    /*-{
        $wnd.location = url;
      }-*/; 

    public static native String getParamString() /*-{
        return $wnd.location.search;
    }-*/;

    public static HashMap<String, String> parseParamString(String string){
        String[] ray = string.substring(1, string.length()).split("&");
        HashMap<String, String> map = new HashMap<String, String>();
        for (int i=0; i<ray.length; i++){
            String[] substrRay = ray[i].split("=");
            map.put(substrRay[0], substrRay[1]);
        }
        return map;
    }

    public static native String openExcel() /*-{
        var excel = null;
        function openExcel()
        {
            try
            {
                if(excel == null)
                {    
                     excel = new ActiveXObject("Excel.Application");
                }
                var workbook = excel.Workbooks.Add();
                workbook.Activate();
                var worksheet = workbook.Worksheets("Sheet1");
                worksheet.Activate();
                worksheet.Paste();
                excel.visible=true;
            }catch(exception)
            {
                window.alert("Now you may Paste into an Excel SpreadSheet");
            }
        }
    }-*/;

    
    public static void runHelp(String baseUrl) { 
         
        Window.open(GWT.getHostPageBaseURL() + baseUrl, "HelpWindow", "scrollbars=auto,resizable=no,location=no,toolbar=no,menubar=no,height=768,width=1024");
    }
    
    public static native void reload() /*-{ 
        $wnd.location.reload(); 
    }-*/; 

    public static native void postCall(String to, JavaScriptObject param) /*-{
        var myForm = document.createElement("form");
        myForm.method="post" ;
        myForm.action = to;
        myForm.target = "_blank";

        for (var k in param) {
            var myInput = document.createElement("input") ;
            myInput.setAttribute("name", k) ;
            myInput.setAttribute("value", param[k]);
            myForm.appendChild(myInput) ;
        }
        document.body.appendChild(myForm) ;
        myForm.submit() ;
        document.body.removeChild(myForm) ;
    }-*/;
    
    
  /**
   * 엑셀저장을 위한 처리
   * @param to
   * @param param
   *    var iframe = $doc.getElementById(sframe);   
       if(iframe==null){
             alert("iframe not found");.
       } else {
          alert("ok" + sframe);.
       } 
   */
    public static native void xlsExportData(String to, String sframe, JavaScriptObject param) /*-{
          
        var myForm = document.createElement("form");
        myForm.method="post" ;
        myForm.action = to;
        myForm.target = sframe;

        for (var k in param) {
            var myInput = document.createElement("input") ;
            myInput.setAttribute("name", k) ;
            myInput.setAttribute("value", param[k]);
            myForm.appendChild(myInput) ;
        }
        document.body.appendChild(myForm) ;
        myForm.submit() ;
        document.body.removeChild(myForm) ;
    }-*/;  
     
//    public static native void download(String url, String name, String features) /*-{   
//          // Create an IFRAME.     
//           var iframe = $doc.getElementById('myIFrm');   
//              if(iframe==null){       
//                   iframe = $doc.createElement("iframe");    
//                       iframe.setAttribute('id', "myIFrm");  
//                           }      // Point the IFRAME to GenerateFile, with the   
//                              //   desired region as a querystring argument.  
//                                  iframe.src = url;     
//                                   // This makes the IFRAME invisible to the user.   
//                                      iframe.style.display = "none";   
//                                         // Add the IFRAME to the page.  This will trigger      
//                                         //   a request to GenerateFile now.      
//                                         $doc.body.appendChild(iframe);     }-*/;
    
     
    
    public static native String postRdaCall(String to, JavaScriptObject param) /*-{
	
    Rdviewer.AutoAdjust = false;
    Rdviewer.ZoomRatio = 110;
    Rdviewer.setbackgroundcolor(255,255,255);
    Rdviewer.FileOpen("./insa.mrd","/rfn [insa.txt]");
    
  
	}-*/;
    

    public static Date getDateFromString(String strValue) {
        return getDateFromString(strValue, MSFMainApp.MSFCONSTANTS.DateFormat());
    }

    public static Date getDateFromString(String strValue, String pattern) {
        try {
            DateTimeFormat format = DateTimeFormat.getFormat(pattern);
            Date value = format.parse(strValue);
            return value;
        } catch (Exception ex) {
            return null;
        }
    }

    public static String getStringFromDate(Date dtValue) {
        return getStringFromDate(dtValue, MSFMainApp.MSFCONSTANTS.DateFormat());
    }

    public static String getStringFromDate(Date dtValue, String pattern) {
        try {
            DateTimeFormat format = DateTimeFormat.getFormat(pattern);
            String value = format.format(dtValue);
            return value;
        } catch (Exception ex) {
            return null;
        }
    }


    public static HashMap<Integer, ColumnOrder> sortHashMap(HashMap<Integer, ColumnOrder> input) {
        Map<Integer, ColumnOrder> tempMap = new HashMap<Integer, ColumnOrder>();
        for (Integer wsState : input.keySet()){
            tempMap.put(wsState,input.get(wsState));
        }

        List<Integer> mapKeys = new ArrayList<Integer>(tempMap.keySet());
        List<ColumnOrder> mapValues = new ArrayList<ColumnOrder>(tempMap.values());
        HashMap<Integer, ColumnOrder> sortedMap = new LinkedHashMap<Integer, ColumnOrder>();
        TreeSet<ColumnOrder> sortedSet = new TreeSet<ColumnOrder>(mapValues);
        Object[] sortedArray = sortedSet.toArray();
        int size = sortedArray.length;
        for (int i=0; i<size; i++){
            sortedMap.put(mapKeys.get(mapValues.indexOf(sortedArray[i])), 
                    (ColumnOrder)sortedArray[i]);
        }
        return sortedMap;
    }

    public static void maskComponent(Component cmp) {
        maskComponent(cmp, MSFMainApp.MSFMESSAGES.LoadingData());
    }

    public static void maskComponent(Component cmp, String msg) {
        if ( cmp==null ) {
            return;
        }
        if ( cmp.isMasked() ) {
            return;
        }
        if ( cmp instanceof Grid && ((Grid)cmp).getView()!=null && ((Grid)cmp).getView() instanceof LiveGridView && ((LiveGridView)((Grid)cmp).getView()).getScroller()!=null && ((LiveGridView)((Grid)cmp).getView()).getScroller().isMasked() ) {
            return;
        }
        cmp.mask(msg);
    }

    public static void unmaskComponent(Component cmp) {
        if ( cmp==null ) {
            return;
        }
        if ( cmp.isMasked() ) {
            cmp.unmask();
        }
    }

    @Deprecated
    public static void unmaskGrid(Component cmp) {
        unmaskComponent(cmp);
    }
    
   

    public static Field findField(Component cmp, String attributeName ) {
        Field field = null;
        if ( cmp==null || MSFSharedUtils.paramNull(attributeName) ) {
            return null;
        }
        if ( cmp instanceof MSFFormPanel ) {
            FormBinding formBinding = ((MSFFormPanel) cmp).getFormBinding();
            for (FieldBinding fieldBinding : formBinding.getBindings()) {
                if (fieldBinding.getProperty().equals(attributeName)) {
                    field = fieldBinding.getField();
                    break;
                }
            }
        }
        return field;
    }

    public static FieldBinding findFieldBinding(Component cmp, String attributeName ) {
        FieldBinding result = null;
        if ( cmp==null || MSFSharedUtils.paramNull(attributeName) ) {
            return null;
        }
        if ( cmp instanceof MSFFormPanel ) {
            FormBinding formBinding = ((MSFFormPanel) cmp).getFormBinding();
            for (FieldBinding fieldBinding : formBinding.getBindings()) {
                if (fieldBinding.getProperty().equals(attributeName)) {
                    result = fieldBinding;
                    break;
                }
            }
        }
        return result;
    }

    public static void setValueField(Component cmp, String attributeName, Object value) {
        Field field = null;
        if ( cmp != null && MSFSharedUtils.paramNotNull(attributeName) && MSFSharedUtils.paramNotNull(value)) {
            if ( cmp instanceof MSFFormPanel ) {
                FormBinding formBinding = ((MSFFormPanel) cmp).getFormBinding();
                for (FieldBinding fieldBinding : formBinding.getBindings()) {
                    if (fieldBinding.getProperty().equals(attributeName)) {
                        field = fieldBinding.getField();
                        field.setValue(value);
                        field.setOriginalValue(value);
                        fieldBinding.updateModel();
                        break;
                    }
                }
            }
        }
    }

    public static void clearField(Field field) {
        if ( field!=null ) {
            field.clear();
            if (field instanceof ComboBox) {
                ((ComboBox<BaseModel>)field).getStore().removeAll();
            }
        }
    }

    public static String getLocale() {
        String locale = LocaleInfo.getCurrentLocale().getLocaleName();
        try {
            locale = locale.substring(0, 2);
            locale = locale.toLowerCase();
        } catch (Exception e) {
            locale = "ko";
        }
        return locale;
    }

    public static String getLocaleInitCaps() {
        return toInitCaps(getLocale());
    }

    public static String toInitCaps(String inputString) {
        StringBuilder result = new StringBuilder();
        if (inputString != null && inputString.length() > 0) {
            for (String f : inputString.split(" ")) {
                if (result.length() > 0) {
                    result.append(" ");
                }
                result.append(f.substring(0, 1).toUpperCase()).append(f.substring(1, f.length()).toLowerCase());
            }
        }
        return result.toString();
    }        

    public static String replacePercentWithLocale(String param) {
        char lastChar = param.charAt(param.length() - 1);
        if (lastChar == '%') {
            param = param.substring(0, param.length()-1);
            param += toInitCaps(getLocale()); 
        }
        return param;
    }

    public static String replaceLocale(String param) {
        String shownLanguages = MSFMainApp.APPCONSTANTS.ShownLanguages().toUpperCase();
        String attributeLocal = param.substring(param.length()-2).toUpperCase();
        String attributeName  = param.substring(0, param.length()-2);
        if (shownLanguages.indexOf(attributeLocal) >= 0) {
            attributeName += toInitCaps(getLocale()); 
        }
        return attributeName;
    }

    public static String adjustsColumnDefName(String columnDefName) {
        if (MSFSharedUtils.paramNotNull(columnDefName)) {
            columnDefName = columnDefName.replace(".", TableDef.SEPARATOR_CLIENT);
            columnDefName = replacePercentWithLocale(columnDefName);
        }
        return columnDefName;
    }

    public static void removeComponentFromToolBar(ToolBar parent, Component child) {
        if ( parent!=null && child!=null && child.getParent()==parent ) {
            parent.remove(child);
        }
    }

    public static ContentPanel applyTopBottomLayout(LayoutContainer topPanel, LayoutContainer bottomPanel, int height) {
        //Definisco un Container mainPanel al quale setto un BorderLayout che poi dividero' in due (north, center)
        LayoutContainer mainPanel = new LayoutContainer();
        BorderLayout borderLayout = new BorderLayout();
        mainPanel.setStyleAttribute("backgroundColor", "#FFFFFF");
        mainPanel.setLayout(borderLayout);

        //Metto il topPanel in alto ed il bottomPanel al centro (si adatternno alle dim definite qui sotto)
        BorderLayoutData northData  = new BorderLayoutData(LayoutRegion.NORTH, height);
        BorderLayoutData centerData = new BorderLayoutData(LayoutRegion.CENTER);
        mainPanel.add(topPanel, northData);
        mainPanel.add(bottomPanel, centerData);

        //Definisco il solito Panel che contiene tutta la maschera (gli passo il mainPanel)
        ContentPanel returnPanel = new ContentPanel();
        returnPanel.setBodyBorder(false);
        returnPanel.setBorders(false);
        returnPanel.setHeaderVisible(false);
        returnPanel.add(mainPanel);

        return returnPanel;
    }

    public static ContentPanel applyColumnLayout(ContentPanel atLeastOne, ContentPanel... panels) {
        ContentPanel mainPanel = new ContentPanel();
        mainPanel.setBodyBorder(false);
        mainPanel.setBorders(false);
        mainPanel.setHeaderVisible(false);
        // Definito il tipo di layout del contenitore
        mainPanel.setLayout(new FillLayout(Orientation.HORIZONTAL));
        mainPanel.add(atLeastOne);
        for (ContentPanel panel : panels) {
          if (panel != null) {
              mainPanel.add(panel);
              panel.setStyleAttribute("paddingLeft", "10px");
          }
        }
        //Definisco il solito Panel che contiene tutta la maschera (gli passo il mainPanel)
        ContentPanel returnPanel = new ContentPanel();
        returnPanel.setBodyBorder(false);
        returnPanel.setBorders(false);
        returnPanel.setHeaderVisible(false);
        returnPanel.add(mainPanel);

        return returnPanel;
    }

    public static void layoutFormFields(TableDef tableDef, int formWidth, int labelWidth, int numCols) {
        //Align Form fields in numCols columns
        int col = 0;
        int row = 0;
        //int formWidth  = (labelWidth+fieldWidth) * numCols + labelWidth;
        int fieldWidth = Math.round( (formWidth-labelWidth) / numCols - labelWidth );
        for (int i=0 ; i<tableDef.getColumnsDefinition().size() ; i++ ) {
            ColumnDef columnDef = tableDef.getColumnsDefinition().get(i);
            if ( columnDef.isVisibleInForm() ) {
                if ( col==numCols ) {
                    col = 0;
                    row++;
                }
                columnDef.setAttributeCustomForm(new AttributeCustomForm(col, row, fieldWidth, labelWidth));
                col++;
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static Component findChildComponentByItemId(Container<Component> container, String itemId) {
        Component retval = null;
        if ( container!=null && itemId!=null ) {
            List<Component> items = container.getItems();
            for ( int i=0 ; retval==null && i<items.size() ; i++ ) {
                Component component = items.get(i);
                String id = component.getItemId();
                if ( itemId.equals(id) ) {
                    retval = component;
                } else if ( component instanceof Container ) {
                    retval = findChildComponentByItemId((Container<Component>)component, itemId);
                }
            }
        }
        return retval;
    }

    public static List<Component> findChildrenComponentsByItemId(Container<Component> container, String itemId) {
        List<Component> retval = new ArrayList<Component>();
        findChildrenComponentsByItemId(retval, container, itemId);
        return retval;
    }

    @SuppressWarnings("unchecked")
    public static void findChildrenComponentsByItemId(List<Component> children, Container<Component> container, String itemId) {
        if ( container!=null && itemId!=null ) {
            List<Component> items = container.getItems();
            for ( int i=0 ; i<items.size() ; i++ ) {
                Component component = items.get(i);
                if ( component instanceof Field ) {
                    addFieldComponent(children, component, itemId);
                } else if ( component instanceof Container ) {
                    findChildrenComponentsByItemId(children, (Container<Component>)component, itemId);
                }
                //                Component component = items.get(i);
                //                String id =  adjustsColumnDefName(component.getItemId());
                //                String name = null;
                //                if ( component instanceof Field ) {
                //                    name =  adjustsColumnDefName(((Field)component).getName());
                //                }
                //                if ( component instanceof MultiField ) {
                //                    List<Component> multItems = ((MultiField) component).getAll();
                //                    for (int q=0 ; q<items.size() ; q++ ) {
                //                        Component multComponent = multItems.get(q);
                //                        String idMultComponent =  adjustsColumnDefName(multComponent.getItemId());
                //                        String nameMultComponent = null;
                //                        if (multComponent instanceof Field ) {
                //                            nameMultComponent =  adjustsColumnDefName(((Field)multComponent).getName());
                //                        } 
                //                        if ( itemId.equals(idMultComponent) || itemId.equals(nameMultComponent) ) {
                //                            children.add(multComponent);
                //                        }
                //                    }
                //                }
                //                if ( itemId.equals(id) || itemId.equals(name) ) {
                //                    children.add(component);
                //                } else if ( component instanceof Container ) {
                //                    findChildrenComponentsByItemId(children, (Container<Component>)component, itemId);
                //                }
            }
        }
    }

    private static void addFieldComponent(List<Component> children, Component component, String itemId){
        if ( component instanceof MultiField ) {
            addFieldComponent(children, ((MultiField) component).getAll(),  itemId); 
        }
        String id =  adjustsColumnDefName(component.getItemId());
        String name = null;
        if ( component instanceof Field ) {
            name =  adjustsColumnDefName(((Field)component).getName());
        }
        if ( itemId.equals(id) || itemId.equals(name) ) {
            if ( !children.contains(component) ) {
                children.add(component);
            }
        }
    }

    private static void addFieldComponent(List<Component> children, List<Component> items, String itemId){
        for ( int i=0 ; i<items.size() ; i++ ) {
            Component component = items.get(i);
            addFieldComponent(children, component, itemId);
        }
    }

    public static void setRequiredStyle(TextField f){
        El el = f.el();
        El child = el.firstChild();
        child.addStyleName("x-form-field-required");
    }
    
    public static void setEditStyle(TextField f){
        El el = f.el();
        El child = el.firstChild();
        child.addStyleName("x-form-field-required");
    }

    public static void setReadonlyStyle(TextField f){
        El el = f.el();
        El child = el.firstChild();
        child.addStyleName("x-form-field-readonly");
    }

    public static void setCustomStyles(TextField f){
        if (!f.getAllowBlank()) {
            setRequiredStyle(f);
        } 
        if ( f.isReadOnly() ) {
            setReadonlyStyle(f);
        } else {
        	//입력처리시 
        	setEditStyle(f);
        }
    }

    /**
     * Given a GridPanel, this methods looks for the ColumnConfig with ID equals to the passed parameter columnId
     * in the list of ColumnConfigs of the Grid owned by the GridPanel. If no ColumnConfig with that ID is present, null is returned.
     * 
     * @param gridPanel
     * @param columnId
     * @return
     */
    public static ColumnConfig findColumnConfig(MSFGridPanel gridPanel, String columnId) {
        ColumnConfig columnConfig = null;
        try {
            columnId = adjustsColumnDefName(columnId);
            ColumnModel columnModel = gridPanel.getGrid().getColumnModel();
            List<ColumnConfig> columnConfigs = columnModel.getColumns();
            for ( int i=0 ; columnConfig==null && i<columnConfigs.size() ; i++ ) {
                ColumnConfig tmp = columnConfigs.get(i);
                if ( tmp.getId().equals(columnId) ) {
                    columnConfig = tmp;
                }
            }
        } catch (Exception ex) {
        }
        return columnConfig;
    }

    /**
     * Given a TableDef, this methods looks for the ColumnDef with ID equals to the passed parameter columnId
     * in the list of its ColumnDefs. If no ColumnDef with that ID is present, null is returned.
     * 
     * @param tableDef
     * @param columnId
     * @return
     */
    public static ColumnDef findColumnDef(TableDef tableDef, String columnId) {
        ColumnDef columnDef = null;
        try {
            columnId = adjustsColumnDefName(columnId);
            List<ColumnDef> columnsDefinition = tableDef.getColumnsDefinition();
            for ( int i=0 ; columnDef==null && i<columnsDefinition.size() ; i++ ) {
                ColumnDef tmp = columnsDefinition.get(i);
                if ( tmp.getAttributeName().equals(columnId) ) {
                    columnDef = tmp;
                }
            }
        } catch (Exception ex) {
        }
        return columnDef;
    }

    /**
     * Given a TableDef, this methods looks for the ColumnDef with ID equals to the passed parameter columnId
     * If found, an AttributeCustomForm is attached to the ColumnDef
     * @param tableDef
     * @param columnId
     * @param col
     * @param row
     * @return
     */
    public static ColumnDef applyCustomFormToColumnDef(TableDef tableDef, String columnId, AttributeCustomForm acf) {
        ColumnDef columnDef = null;
        try {
            columnDef = GWTUtils.findColumnDef(tableDef, columnId);
            columnDef.setAttributeCustomForm(acf);
        } catch (Exception ex) {
        }
        return columnDef;
    }

    /**
     * Sets a custom GridCellRender to a column in the Grid owned by a MSFGridPanel.
     * The column is identified by the columnId that is the same used to configure the ColumnDef. 
     * This can be useful to add a custom background or to format the text in the cell in a custom way.
     * 
     * Example:
     * GridCellRenderer<BaseModel> cellRender = GWTUtils.createDecodeColumnRenderer("-");
     * GWTUtils.setGridCellRenderer(gridPanel, "jobs", cellRender);
     * 
     * @param gridPanel
     * @param columnId
     * @param columnRenderer
     */
    public static void setGridCellRenderer(MSFGridPanel gridPanel, String columnId, GridCellRenderer<BaseModel> columnRenderer) {
        ColumnConfig columnConfig = findColumnConfig(gridPanel, columnId);
        if ( columnConfig!=null ) {
            columnConfig.setRenderer(columnRenderer);
        }
    }

    /**
     * @see createDecodeColumnRenderer(final String separator, final String textAlign)
     * the method is called with the default text-align of "center"
     * 
     * @param separator
     * @return
     */
    public static GridCellRenderer<BaseModel> createDecodeColumnRenderer(final String separator) {
        return createDecodeColumnRenderer(separator, "center");
    };

    /**
     * Creates a custom GridCellRenderer that formats the text in the cell of a grid in this way:
     * the original text in the cell should be in the form of txt1 separator txt2 and the effect is that in the cell
     * only txt1 is displayed and the full text is shown when an hover occurs.
     * 
     * Example:
     * In this example we create a ColumnDef that, using a formula, shows a concatenation of ID and DESC (for example the string "IT_PROG - Programmer".
     * The call to createDecodeColumnRenderer("-", "left") will change the shown text to "IT_PROG" and, when the user goes with the mouse over this text
     * full text is shown as alt text. 
     *   listColumnDefs.add(new ColumnDef("Job", "jobs", ColumnDef.TYPE_STRING, 70, false, true, true) {{
     *       this.setAttributeFormula("(m.jobs.jobId || ' - ' || m.jobs.jobTitle)");
     *       this.setGridCellRenderer(GWTUtils.createDecodeColumnRenderer("-", "left"));
     *   }});
     * 
     * @param separator
     * @param textAlign
     * @return
     */
    public static GridCellRenderer<BaseModel> createDecodeColumnRenderer(final String separator, final String textAlign) {
        GridCellRenderer<BaseModel> renderer = new GridCellRenderer<BaseModel>() {
            public Object render(final BaseModel model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<BaseModel> store, Grid<BaseModel> grid) {
                String text = model.get(property);
                Object txt = null;
                try {
                    String[] texts = text.split(separator);
                    //txt = new Html("<span title='"+texts[1]+"'>"+texts[0]+"</span>");
                    txt = new Html("<span title='"+text+"'>"+texts[0]+"</span>");
                    config.style += " text-align:"+(textAlign!=null?textAlign:"center")+"; ";
                } catch (Exception ex) {
                    txt = new Html(text);
                }
                return txt;
            }
        };
        return renderer;
    };

    /**
     * Creates a custom GridCellRenderer that formats the text in the cell of a grid in this way:
     * only txtShort is displayed and the full text is shown when an hover occurs. Text is taken from the BaseModel bound to current grid row.
     * 
     * Example:
     * In this example we create a ColumnDef that shows the ID and DESC as tooltip (for example the string IT_PROG and as tooltip Programmer).
     * 
     *   listColumnDefs.add(new ColumnDef("Job", "jobs.jobId", ColumnDef.TYPE_STRING, 70, false, true, true) {{
     *       this.setGridCellRenderer(GWTUtils.createDecodeColumnRenderer("jobs.jobId", "jobs.jobTitle", "left"));
     *   }});
     * 
     * @param attrShort
     * @param attrFull
     * @param textAlign
     * @return
     */
    public static GridCellRenderer<BaseModel> createDecodeColumnRenderer(final String attrShort, final String attrFull, final String textAlign) {
        GridCellRenderer<BaseModel> renderer = new GridCellRenderer<BaseModel>() {
            public Object render(final BaseModel model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<BaseModel> store, Grid<BaseModel> grid) {
                String txtShort = model.get(adjustsColumnDefName(attrShort));
                String txtFull  = model.get(adjustsColumnDefName(attrFull));
                Object txt = null;
                try {
                    if ( txtShort!=null ) {
                        txt = new Html("<span title='"+txtFull+"'>"+txtShort+"</span>");
                        config.style += " text-align:"+(textAlign!=null?textAlign:"center")+"; ";
                    } else {
                        txt = new Html("");
                    }
                } catch (Exception ex) {
                    String text = model.get(property);
                    txt = new Html(text);
                }
                return txt;
            }
        };
        return renderer;
    };

    /**
     * Creates a GridCellRenderer that shows a link with a click handler that opens a new Entry.
     * Before opening the new entry, the value associated with the ID is 
     * @param attrNameGrid
     *   The name of the attribute to show as a link in the grid
     * @param attrNameId
     *   The name of the attribute to use as the ID to pass to the nuew entry
     * @param attrSessionId
     *   The name used to store the ID in the session
     * @param entryId
     *   The name of the entry to open when the link is clicked
     * @return
     * 
     * Example:
     *   createLinkIdColumnRenderer("id", "id", "JobId", "JobsDetailPanel");
     */
    public static GridCellRenderer<BaseModel> createLinkIdColumnRenderer(
            final String attrNameGrid, final String attrNameId, final String attrSessionId, final String entryId) {
        GridCellRenderer<BaseModel> renderer = new GridCellRenderer<BaseModel>() {
            public Object render(final BaseModel model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<BaseModel> store, Grid<BaseModel> grid) {
                Object idGrid = model.get(attrNameGrid);
                //Html link = new Html("<a href='#'>"+idGrid+"</a>");
                Html link = new Html("<div class='link'>"+idGrid+"</div>");
                link.addListener(Events.OnClick, new Listener<BaseEvent>(){
                    public void handleEvent(BaseEvent be) {
                        Object source = be.getSource();
                        BaseModel model = ((Html)source).getData("model");
                        if (model != null) {
                            Object idRow = model.get(attrNameId);
                            if (idRow != null) {
                                ClientSession session = MSFMainApp.getClientSession();
                                session.addAttribute(attrSessionId, model);
                                MSFMainApp.callEntry(entryId,idRow);
                            }
                        }
                    }
                });
                link.setData("model", model);
                return link;
            }
        };
        return renderer;
    };
    
   /**
    * Link Url  
    * @param attrNameGrid
    * @param attrNameId
    * @param attrSessionId
    * @param entryId
    * @return
    */
    public static GridCellRenderer<BaseModel> createLinkUrlColumnRenderer(
            final String attrNameGrid, final String attrNameId, final String attrFileUrl) {
        GridCellRenderer<BaseModel> renderer = new GridCellRenderer<BaseModel>() {
            public Object render(final BaseModel model, String property, ColumnData config, final int rowIndex,
                    final int colIndex, ListStore<BaseModel> store, Grid<BaseModel> grid) {
                
                Object idGrid = model.get(attrNameGrid);
                if (idGrid != null) {
                    idGrid = "다운로드" ;
                } else {
                    idGrid = "" ;
                }
//                Html link = new Html("<a href='#'>"+idGrid+"</a>");
//               // Html link = new Html("<div class='link'>"+idGrid+"</div>");
//                link.addListener(Events.OnClick, new Listener<BaseEvent>(){
//                    public void handleEvent(BaseEvent be) {
//                        Object source = be.getSource();
//                        BaseModel model = ((Html)source).getData("model");
//                        if (model != null) {
//                            Object fileName = model.get(attrNameId);
//                            Object fileUrl = model.get(attrFileUrl);
//                            if (fileName != null) { 
//                                Window.alert(GWT.getHostPageBaseURL() + fileUrl + "?filename=" + fileName + "&original=" + fileName);
//                                Window.open(GWT.getHostPageBaseURL() + fileUrl + "?filename=" + fileName + "&original=" + fileName, "winDown", "scrollbars=no,resizable=no,location=no,toolbar=no,menubar=no,height=0,width=0");
//                                
//                               // ClientSession session = MSFMainApp.getClientSession();
//                               // session.addAttribute(attrSessionId, model);
//                               // MSFMainApp.callEntry(entryId,idRow);
//                            }
//                        }
//                    }
//                });
               // link.setData("model", model);
               // return link;
               return "<b><a style=\"color: #385F95; text-decoration: none;\" href=\"" +GWT.getHostPageBaseURL() + attrFileUrl + "?filename="   
                        + URL.encode(String.valueOf(model.get(attrNameGrid)))   + "&original="  + URL.encode(String.valueOf(model.get(attrNameGrid)))  
                        + "\" target=\"_blank\">"  
                        + idGrid  
                        + "</a>";    
                 
            }
        };
        return renderer;
    };
     

    /**
     * Permette di lanciare un report Jasper
     * @param url       Indirizzo URL del report/service
     * @param param     Mappa dei parametri da passare in GET/POST al report
     * @param postCall  Indica se fare la chiamata in GET/POST
     */
    public static void runReport(String url, HashMap<String, String> param, Boolean postCall) {
        if (postCall) {
            GWTUtils.postCall(url, JsUtil.toJavaScriptObject(param));
        } else {
            Window.open(url+"?"+getURLParamAsString(param), "_blank", null);
        }
    }
    

    /**
     * rda 리포트 출력
     * @param url       Indirizzo URL del report/service
     * @param param     Mappa dei parametri da passare in GET/POST al report
     * @param postCall  Indica se fare la chiamata in GET/POST
     */
    public static void runRdaReport(String baseUrl, HashMap<String, String> param, Boolean postCall) {
    	
         if (postCall) {
        	rdaDialogShow(baseUrl,  param, postCall);
            //GWTUtils.postRdaCall(url, JsUtil.toJavaScriptObject(param));
         } else {
    	     Window.open(baseUrl+"?"+getURLParamAsString(param), "popupWindow", "scrollbars=no,resizable=no,location=no,toolbar=no,menubar=no,height=700,width=960");
          //  Window.open(baseUrl+"?"+getURLParamAsString(param), param.get("rdaFile"), "scrollbars=no,resizable=no,location=no,toolbar=no,menubar=no,height=600,width=800");
         } 
           
    }
    
    /**
     * rex 리포트 출력
     * @param url       Indirizzo URL del report/service
     * @param param     Mappa dei parametri da passare in GET/POST al report
     * @param postCall  Indica se fare la chiamata in GET/POST
     */
    public static void runRexReport(String baseUrl, HashMap<String, String> param, Boolean postCall) {
    	
         if (postCall) {
        	rexDialogShow(baseUrl,  param, postCall);
            //GWTUtils.postRdaCall(url, JsUtil.toJavaScriptObject(param));
         } else {
    	     Window.open(baseUrl+"?"+getURLParamAsString(param), "popupWindow", "scrollbars=no,resizable=no,location=no,toolbar=no,menubar=no,height=700,width=960");
          //  Window.open(baseUrl+"?"+getURLParamAsString(param), param.get("rdaFile"), "scrollbars=no,resizable=no,location=no,toolbar=no,menubar=no,height=600,width=800");
         } 
           
    }
    
    
    public static void rdaDialogShow(String baseUrl, HashMap<String, String> param, Boolean postCall) {
      	        
//		    	final Dialog dlgRdViewer = new Dialog();  
//		    	dlgRdViewer.setBodyBorder(false);  
//		    	dlgRdViewer.setFrame(true);
//			  //  dlgRdViewer.setIcon(Resources.ICONS.side_list());  
//		        dlgRdViewer.setHeading("PAYGEN-RDVIEWER");  
//		        dlgRdViewer.setWidth(900);  
//		        dlgRdViewer.setHeight(650);  
//		     //   dlgRdViewer.setAutoHeight(true);
//		        dlgRdViewer.setHideOnButtonClick(true);  
//			  
//			    BorderLayout layout = new BorderLayout();  
//			    dlgRdViewer.setLayout(layout);  
//	 
//				if ( MSFSharedUtils.paramNotNull(baseUrl)) { 
//					  
//					dlgRdViewer.setUrl(baseUrl+"?"+getURLParamAsString(param));
//				 
//					dlgRdViewer.setModal(true); 
//					dlgRdViewer.show();   
//					
//				}

//          private Frame frame;
//          frame = new Frame(GXT.SSL_SECURE_URL);
//          frame.addStyleName("x-panel-bwrap");
//          String path = Window.Location.getPath().replaceAll("index.html", "");
//          frame.setUrl(path+"static/start_page.jsp?version="+Resources.CONFIG.getVersion());
//          //Remove 3D borderDOM.setIntStyleAttribute(startPageFrame.getElement(), "frameBorder", 0);
//          DOM.setStyleAttribute(startPageFrame.getElement(), "borderTop",Resources.CONSTANT.getBorderStyle()); 
//          // enable borderparentPanel.add(frame);
//          frame.getParent().setStyleName("x-component");
//          parentPanel.layout(); 
		  
		  if ( MSFSharedUtils.paramNotNull(baseUrl)) {  
		      
		    final com.extjs.gxt.ui.client.widget.Window  popupWindow = new  com.extjs.gxt.ui.client.widget.Window();  
	    	popupWindow.setBodyBorder(false);  
	    	popupWindow.setFrame(true); 
		  //  popupWindow.setIcon(Resources.ICONS.side_list());  
	        //popupWindow.setHeading("PAYGEN-RDVIEWER");  
	    	popupWindow.setHeadingText("PAYGEN-RDVIEWER");
	        popupWindow.setWidth(900);  
	        popupWindow.setHeight(650);  
		    popupWindow.setPlain(true);  
		    popupWindow.setModal(true);  
		    popupWindow.setBlinkModal(true);  
		    popupWindow.setLayout(new FitLayout());  
//		    popupWindow.addWindowListener(new WindowListener() {  
//		      @Override  
//		      public void windowHide(WindowEvent we) {  
//		        Button open = we.getWindow().getData("open");  
//		        open.focus();  
//		      }  
//		    });  
		    
		    ContentPanel cpWindow = new ContentPanel(); 
		    cpWindow.setUrl(baseUrl+"?"+getURLParamAsString(param));
		    cpWindow.setBodyBorder(false); 
		    cpWindow.setFrame(true);
		    cpWindow.setHeaderVisible(false); 
		    
		    popupWindow.add(cpWindow, new FitData(4));  
		    popupWindow.addButton(new Button("Close", new SelectionListener<ButtonEvent>() {  
		      @Override  
		      public void componentSelected(ButtonEvent ce) {  
		        popupWindow.hide();  
		      }  
		    })); 
		    
		     popupWindow.show();  
		     
		  }	
		 	 
    	
    }
    
   /**
    * rex report 출력처리 추가 
    * @param baseUrl
    * @param param
    * @param postCall
    */
    public static void rexDialogShow(String baseUrl, HashMap<String, String> param, Boolean postCall) {
      	         
		  
		  if ( MSFSharedUtils.paramNotNull(baseUrl)) {  
		      
		    final com.extjs.gxt.ui.client.widget.Window  popupWindow = new  com.extjs.gxt.ui.client.widget.Window();  
	    	popupWindow.setBodyBorder(false);  
	    	popupWindow.setFrame(true); 
		  //  popupWindow.setIcon(Resources.ICONS.side_list());  
	       // popupWindow.setHeading("PAYGEN-REXVIEWER");
	    	popupWindow.setHeadingText("PAYGEN-REXVIEWER");
	        popupWindow.setWidth(900);  
	        popupWindow.setHeight(650);  
		    popupWindow.setPlain(true);  
		    popupWindow.setModal(true);  
		    popupWindow.setBlinkModal(true);  
		    popupWindow.setLayout(new FitLayout());  
 
		    
		    ContentPanel cpWindow = new ContentPanel(); 
		    cpWindow.setUrl(baseUrl+"?"+getURLParamAsString(param));
		    cpWindow.setBodyBorder(false); 
		    cpWindow.setFrame(true);
		    cpWindow.setHeaderVisible(false); 
		    
		    popupWindow.add(cpWindow, new FitData(4));  
		    popupWindow.addButton(new Button("Close", new SelectionListener<ButtonEvent>() {  
		      @Override  
		      public void componentSelected(ButtonEvent ce) {  
		        popupWindow.hide();  
		      }  
		    })); 
		    
		     popupWindow.show();  
		     
		  }	
		 	 
    	
    }
    
    public native static void rdaOpen()/*-{
    	$wnd.rdDlgOpen();
    }-*/;
     

    public static String getURLParamAsString(HashMap<String, String> map) {
        String result = null;
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Entry<String, String> e = (Entry<String, String>) iter.next();
            String key = e.getKey();
            String val = e.getValue();
            if (MSFSharedUtils.paramNotNull(key) &&
                MSFSharedUtils.paramNotNull(val)) {
                if (result == null) {
                    result = e.getKey()+"="+e.getValue();
                } else {
                    result += "&"+e.getKey()+"="+e.getValue();
                }
            }
        }
        return result;
    }

    public static String removeBackgroudFromStyle(String style) {
        int i = style.indexOf("background-color");
        if (i > 0) {
            return style.substring(0, i);
        }
        return style;
    }
    
    /**
     * Opens a new modal window showing the list of change history for the Dao passed as bm
     * @param bm
     *     current record
     */
    public static void showListHistoricDataWindow(ModelData bm, TableDef tableDef){
        if ( bm!=null ) {
            final TableDef historyDef = new DataHistoryDef();
            final String rowPK = bm.get(TableDef.ID_PROPERTY_NAME);
            final String title = MSFMainApp.MSFCONSTANTS.TitleDataHistory()+" ("+rowPK+")";
            SimpleColumnFilter filter = new SimpleColumnFilter(
                    MSFDaoConstants.ATTR_AdmDataHistory_primaryKey, 
                    rowPK, 
                    SimpleColumnFilter.OPERATOR_EQUALS);
            historyDef.setTableColumnFilters(filter);
            historyDef.setDaoClass(tableDef.getTable());
            historyDef.setTitle("");
            historyDef.setFilterFormType(TableDef.FILTER_FORM_NO_FILTER);
            final MSFGridPanel historyPanel = new MSFGridPanel(historyDef, false, false, false);
            historyPanel.setShowRefreshButton(false);

            com.extjs.gxt.ui.client.widget.Window historyWindow = new com.extjs.gxt.ui.client.widget.Window() {
                @Override
                protected void onRender(Element parent, int pos) {
                    super.onRender(parent, pos);
                    setLayout(new FitLayout());
                   // setHeading(title);
                    setHeadingText(title);
                    setIcon(MSFMainApp.ICONS.form());
                    setMaximizable(false);
                    setResizable(true);
                    setWidth(400);
                    setHeight(200);
                    //setAutoWidth(true);
                    //setAutoHeight(true);
                    setModal(true);
                    add(historyPanel);
                }
            };
            historyWindow.show();
        }
    }
    
  
     /**
      * 
      * <pre>
      * 1. 개요 : 우편번호 우편모아 연계처리 부분  
      * 2. 처리내용 : 우편모아 우편번호 사용을 위한 jsp 연동처리 루틴임 
      * </pre>
      * @Method Name : postDialogShow
      * @date : Mar 28, 2016
      * @author : leeheuisung
      * @history : 
      *	-----------------------------------------------------------------------
      *	변경일				작성자						변경내용  
      *	----------- ------------------- ---------------------------------------
      *	Mar 28, 2016		leeheuisung				최초 작성 
      *	-----------------------------------------------------------------------
      * 
      * @param baseUrl
      * @param param
      * @param postCall
      */
     public static void postDialogShow(String baseUrl, HashMap<String, String> param, Boolean postCall) {
       	         
 		  
 		  if ( MSFSharedUtils.paramNotNull(baseUrl)) {  
 		      
 		    popupDoroWindow = new  com.extjs.gxt.ui.client.widget.Window();  
 		    popupDoroWindow.setBodyBorder(false);  
 		    popupDoroWindow.setFrame(true); 
 		  //  popupWindow.setIcon(Resources.ICONS.side_list());  
 		   // popupDoroWindow.setHeading("PAYGEN-POSTVIEWER");  
 		    popupDoroWindow.setHeadingText("PAYGEN-POSTVIEWER");
 		    popupDoroWindow.setWidth(900);  
 		    popupDoroWindow.setHeight(700);  
 		    popupDoroWindow.setPlain(true);  
 		    popupDoroWindow.setModal(true);  
 		    popupDoroWindow.setBlinkModal(false);  
 		    popupDoroWindow.setLayout(new FitLayout());   
 		    
 		    final ContentPanel cpWindow = new ContentPanel(); 
 		    cpWindow.setUrl(baseUrl+"?"+getURLParamAsString(param));
 		    cpWindow.setBodyBorder(true); 
 		    cpWindow.setFrame(true);
 		    cpWindow.setHeaderVisible(false); 
 		    
 		    popupDoroWindow.add(cpWindow, new FitData(4));  
 		    popupDoroWindow.addButton(new Button("Close", new SelectionListener<ButtonEvent>() {  
 		      @Override  
 		      public void componentSelected(ButtonEvent ce) {  
 		    	 popupDoroWindow.hide(); 
 		       // popupWindow.remove(cpWindow);
 		      }  
 		    })); 
 		    
 		    popupDoroWindow.show();  
 		     
 		  }	
 		 	 
     	
     }
     
     public static native void popupDoroWndClose() /*-{
          $wnd.popupDoroWndClose = $entry(@com.app.smrmf.core.msfmainapp.client.utils.GWTUtils::onDoroClose());
     }-*/;
     
     
     public static void onDoroClose() {
    	 popupDoroWindow.hide();  
     }

     
     public static void runPostPopUp(String baseUrl, HashMap<String, String> param, Boolean postCall) {
     	
         if (postCall) {
        	postDialogShow(baseUrl,  param, postCall); 
         } else {
    	     Window.open(baseUrl+"?"+getURLParamAsString(param), "popupWindow", "scrollbars=no,resizable=no,location=no,toolbar=no,menubar=no,height=700,width=960");
          //  Window.open(baseUrl+"?"+getURLParamAsString(param), param.get("rdaFile"), "scrollbars=no,resizable=no,location=no,toolbar=no,menubar=no,height=600,width=800");
         } 
           
    }
    /**
     *  
     * <pre>
     * 1. 개요 : 정상처리루틴에 에러처리 메시지를 보낼때 사용 
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : messageExcepDlg
     * @date : 2016. 8. 10.
     * @author : Administrator
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2016. 8. 10.		Administrator				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param smBmData
     */
    public static void  messageExcepDlg(ShowMessageBM smBmData) {
    	
    	 ShowMessageBM smBm = new ShowMessageBM();
         smBm = smBmData;
         if (MSFSharedUtils.paramNotNull(smBm) && MSFSharedUtils.paramNotNull(smBm.getMessage())) { 
             MessageDialog messageDlg = new MessageDialog(smBm,ActionDatabase.READ, null);   
 		    MSFFormWindows msFwMessage = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),messageDlg,"닫기","620px", "510px",true);
 		    msFwMessage.show();
 		    messageDlg.setMSFFormWindows(msFwMessage);
         } else {  
             String msg = "팝업메시지오류";
             MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(),msg, null); 
         } 
    } 
     
    /**
     * 
     * <pre>
     * 1. 개요 : 에러메시지를 받아 처리 할때 사용하는 메서드
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : messageExcepDlgEx
     * @date : 2016. 8. 10.
     * @author : Administrator
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2016. 8. 10.		Administrator				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param caught
     */
    public static void  messageExcepDlgEx(Throwable caught,ShowMessageBM smb) {
    	
   	    ShowMessageBM smBm = new ShowMessageBM();
   	     
        if (MSFSharedUtils.paramNotNull(caught) && MSFSharedUtils.paramNotNull(caught.getMessage())) { 
        	smBm.setWindowId(smb.getWindowId());
        	smBm.setWindowNm(smb.getWindowNm());
        	smBm.setMessage(caught.getMessage());
          	smBm.setStackTraceContent(MSFSharedUtils.getStackTraceString(caught));
        	smBm.setMessageDttm((new Date()).toString());
        	    
            MessageDialog messageDlg = new MessageDialog(smBm,ActionDatabase.READ, null);   
		    MSFFormWindows msFwMessage = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),messageDlg,"닫기","620px", "510px",true);
		    msFwMessage.show();
		    messageDlg.setMSFFormWindows(msFwMessage);
        } else {  
            String msg = "팝업메시지오류";
            MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(),msg, null); 
        } 
   } 
    
    /** 
	 * <pre>
	 * 1. 개      요   : 화면 로그 공통 팝업 호출 
	 * 2. 처리내용   : 
	 * </pre>
	 * @Method  Name : funcLogMessage
	 * @date    : 2016. 9. 2.
	 * @author  : Administrator
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2016. 9. 2.		Administrator				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param wndName
	 * @param wndId
	 */
	public static void funcLogMessage(ShowMessageBM smb){
		 
		    ShowMessageBM smBm = new ShowMessageBM();
	   	     
		    if (MSFSharedUtils.paramNotNull(smb.getWindowNm())) { 
	        	smBm.setWindowId(smb.getWindowId());
	        	smBm.setWindowNm(smb.getWindowNm());
	        	smBm.setMessageDttm((new Date()).toString());
	        	    
	        	ShowFormErrMsg showFormErrMsg = new ShowFormErrMsg(smBm,ActionDatabase.READ, null);  
			    MSFFormWindows msFwMessage = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(),showFormErrMsg,"닫기","620px", "510px",false);
			    msFwMessage.show();
			    showFormErrMsg.setMSFFormWindows(msFwMessage);
			    
	        } else {  
	            String msg = "팝업메시지오류";
	            MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(),msg, null); 
	        } 
		
	}  
}
