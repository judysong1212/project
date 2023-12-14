/**
 * 주민등록번호 입력
 */
package com.app.exterms.yearendtax.client.form.yeta2022;



import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.SysIfSysm0100DTO;
import com.app.smrmf.core.msfmainapp.client.service.system.LoginService;
import com.app.smrmf.core.msfmainapp.client.service.system.LoginServiceAsync;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;


public class YetaP73010 extends Window {
	
   
    
    private TextField<String> txprDscmNoCntn;
	private BaseModel ppRecord; // 팝업에 넘길 레코드 값
	
	
    
    public YetaP73010() {
        super();
        setBorders(false);
        setHeadingText("주민등록번호");  
        setIconStyle("icon_key");  
        setMaximizable(false);  
        setResizable(false);  
        setLayout(new FitLayout());  
        setWidth(500);  
        setHeight(150);  
        setModal(true);  
        setBodyBorder(false);

        final FormPanel formPanel = new FormPanel();
        formPanel.setBorders(false);
        add(formPanel);
        formPanel.setFrame(true);
        formPanel.setSize("500px", "150px");
        formPanel.setBodyBorder(false);
        formPanel.setBorders(false);
        formPanel.setHeaderVisible(false);

        final FieldSet fieldSet = new FieldSet();
        formPanel.add(fieldSet);

        FormLayout layout = new FormLayout();  
        layout.setLabelWidth(120);  
        fieldSet.setLayout(layout);  
        
    
        txprDscmNoCntn = new TextField<String>();
        fieldSet.add(txprDscmNoCntn);
        txprDscmNoCntn.setFieldLabel("주민등록번호");
        

        Button salva = new Button("확인");
        salva.addSelectionListener(new SelectionListener<ButtonEvent>(){
            public void componentSelected(ButtonEvent ce) {
            	if (checkValues()) {
       
            		funcSetPopUpRecord();
            		hide();
            	}
            }
        });

        addButton(salva);

        Button annulla = new Button("닫기");
        annulla.addSelectionListener(new SelectionListener<ButtonEvent>(){
            public void componentSelected(ButtonEvent ce) {

                hide();
            }
        });

        addButton(annulla);
        setButtonAlign(HorizontalAlignment.CENTER);
    }
    
    
    	private boolean checkValues(){
	        boolean result = true;
	        if (txprDscmNoCntn.getValue()==null) {
	        	txprDscmNoCntn.markInvalid("주민등록번호를 입력해야합니다.");
	        	txprDscmNoCntn.focus();
	        	result = false;
	        }
	  
	       return result;
	    }
   


    	private void funcSetPopUpRecord() {

    		BaseModel ppRecord = new BaseModel();
    		
    		ppRecord.set("txprDscmNoCntn", txprDscmNoCntn.getValue());
    	
    		MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "ppRecord1"+txprDscmNoCntn.getValue(), null);
    		MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "ppRecord2"+ppRecord.get("txprDscmNoCntn"), null);
    		setPPRecord(ppRecord);
    	}


    
    	public void setPPRecord(BaseModel ppRecord) {
    		this.ppRecord = ppRecord;
    		MessageBox.alert(MSFMainApp.MSFCONSTANTS.Alert(), "ppRecord3" , null);
    	}
    	
        
    };


              
          
			

