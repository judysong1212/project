/**
 * 
 */
package com.app.exterms.prgm.client.lov.DeptMenu;

import com.app.exterms.prgm.client.form.PrgmComP0140;
import com.app.exterms.prgm.client.form.defs.PrgmComBass0400Def;
import com.app.exterms.prgm.client.util.PrgmComPopupUtils;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.Lov;
import com.app.smrmf.core.msfmainapp.client.generics.LovLiveGeneric;
import com.app.smrmf.core.msfmainapp.client.generics.MSFCustomForm;
import com.app.smrmf.core.msfmainapp.client.generics.MSFPanelCustomForm;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.DatePickerEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MenuEvent;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonGroup;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.event.dom.client.KeyCodes;

/**
 * @author cyberlhs
 *
 */
public class PrgmDeptMenu extends Menu {
      
    private   static Lov lov;
    private   static LovLiveGeneric lovWindow;
    private FormPanel frmpl; 
    
    public PrgmDeptMenu() {  
         
        final Window window = new Window();  
        
        //window.setHeading("Overflow Example");  
        window.setHeadingText("Overflow Example");
        window.setSize(400, 200);  
        window.setMinWidth(50);  
        window.setFrame(true);  
      
        ToolBar toolBar = new ToolBar();  
      
        ButtonGroup group = new ButtonGroup(2);  
       // group.setHeading("Clipboard");  
        group.setHeadingText("Clipboard");
        toolBar.add(group);  
      
        toolBar.add(new FillToolItem());  
      
        group = new ButtonGroup(2);  
        //group.setHeading("Other Bugus Actions");  
        group.setHeadingText("Other Bugus Actions");
        toolBar.add(group);  
      
        window.setTopComponent(toolBar);  
        window.setButtonAlign(HorizontalAlignment.CENTER);  
        window.addButton(new Button("Save"));  
        window.addButton(new Button("Cancel"));  
        window.addButton(new Button("Close"));  
        window.addButton(new Button("Highlight"));  
        window.addButton(new Button("Shutdown"));  
        
        window.show();  
        
       // frmpl = new  FormPanel();
       // frmpl.setSize(800, 600);
      //  frmpl.add(lovWindow);
       add(window);
      addStyleName("x-date-menu");
      setAutoHeight(true);
      plain = false;
      showSeparator = false;
      setEnableScrolling(false);
    }

    @Override
    public void focus() {
      super.focus();
     // lovWindow.el().focus();
    }
 
    public void setLov(Lov lov) {
        this.lov = lov;
    }

    public Lov getLov() {
        return lov;
    }

    protected void onPickerSelect(DatePickerEvent be) {
      MenuEvent e = new MenuEvent(this);
      e.setDate(be.getDate());
      fireEvent(Events.Select, e);
    }
    
    public void getFnPopupCommP160(String deptCd) { 
        //부서
     final MSFFormPanel popCom0140 = PrgmComPopupUtils.lovPopUpPrgmCom0140Form(deptCd); 
        
        final FormBinding popBindingCom0140 = popCom0140.getFormBinding();
        
        popBindingCom0140.addListener(Events.Change, new Listener<BaseEvent>() {
           
            @SuppressWarnings("unchecked")
            public void handleEvent(BaseEvent be) {
                BaseModel mapModel = (BaseModel)be.getSource(); 
                if (!"".equals(mapModel.get("deptCd"))) {   
                    fireEvent(Events.Change, be); 
                }     
            }
        });
     } 
    
    //부서팝업  
    private static final MSFFormPanel lovPopUpPrgmCom0140Form(){
                  // TODO Auto-generated method stub 
                      return lovPopUpPrgmCom0140Form(null);
                
    }
     
    //부서팝업  
    private static final MSFFormPanel lovPopUpPrgmCom0140Form(String DeptNm){
  
        MSFPanelCustomForm customForm  = new MSFPanelCustomForm(new PrgmComBass0400Def(), 1, 0);
        MSFCustomForm sysCom0140Form = customForm.getCustomForm();    
        MSFFormPanel comform = (MSFFormPanel)sysCom0140Form;
          
          final PrgmComP0140 sysComP0140 =  new PrgmComP0140(600,600); 
          customForm.setLov(sysComP0140);
          lov = customForm.getLov();  
    
            if (MSFSharedUtils.paramNull(DeptNm)) { 
                customForm.getLov().getLovDef().addColumnFilter("deptNm", "TT", SimpleColumnFilter.OPERATOR_EQUALS);    
                customForm.getLov().getLovDef().addColumnFilter("deptDspyYn", "", SimpleColumnFilter.OPERATOR_EQUALS);   
               
            } else {
                sysComP0140.getDeptNm().setValue(DeptNm);
                customForm.getLov().getLovDef().addColumnFilter("deptNm", DeptNm, SimpleColumnFilter.OPERATOR_EQUALS);    
                customForm.getLov().getLovDef().addColumnFilter("deptDspyYn", "", SimpleColumnFilter.OPERATOR_EQUALS);   
                
            }
          
            if (lov != null) {
                lovWindow = new LovLiveGeneric(customForm.getLov().getLovDef(),sysCom0140Form.getTableDef());
                lovWindow.setInitialForm(sysCom0140Form);   //formPanel을적어준다.
                lovWindow.showButtonNew(false); 
                lovWindow.setSize(lov.getWidth(),lov.getHeight());  //팝업화면 사이즈
                lovWindow.show();
                lov.fixAttributeFormNames(); 
       
                sysComP0140.getDeptNm().addKeyListener(new KeyListener() {
                    public void componentKeyUp(ComponentEvent event) {
                        super.componentKeyUp(event);
                        sysComP0140.getDeptNm().validate();
                        if(event.getKeyCode() == KeyCodes.KEY_ENTER) {  
                            IColumnFilter filters = null;
                            lovWindow.getLovDef().setTableColumnFilters(filters);
                            lovWindow.getLovDef().addColumnFilter("deptNm", MSFSharedUtils.defaultNulls(sysComP0140.getDeptNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                            lovWindow.readData();
                        }
                    }
                 });
                
                sysComP0140.btnUsrSearch.addListener(Events.Select, new Listener<ButtonEvent>() {
                  public void handleEvent(ButtonEvent e) {
                      sysComP0140.getDeptNm().validate();
                      IColumnFilter filters = null;
                      lovWindow.getLovDef().setTableColumnFilters(filters);
                      lovWindow.getLovDef().addColumnFilter("deptNm", MSFSharedUtils.defaultNulls(sysComP0140.getDeptNm().getValue(),""), SimpleColumnFilter.OPERATOR_EQUALS); 
                      lovWindow.readData();
                      
                  }
                 });
                
            } 
            return comform;
    }
  }