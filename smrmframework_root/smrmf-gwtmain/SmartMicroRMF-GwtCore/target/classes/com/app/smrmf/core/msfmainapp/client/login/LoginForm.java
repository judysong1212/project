/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.login;



import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100DTO;
import com.app.smrmf.core.msfmainapp.client.service.system.LoginService;
import com.app.smrmf.core.msfmainapp.client.service.system.LoginServiceAsync;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.server.service.impl.LoginServiceImpl;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfSysm0100BM;
import com.extjs.gxt.ui.client.Style.HideMode;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;


public class LoginForm extends Composite {
	
	private LoginServiceAsync loginService = GWT.create(LoginService.class);
	private Login caller = null; // 변경_hieju_07.12
	
	// private ChangePwd passChangePwd;

	SysIfSysm0100BM admUser = null;
	
    private TextField<String> utente;
    private TextField<String> password;
    public CheckBox ricorda;
    protected FormPanel formPanel;

    public LoginForm(final Login caller) {
    	
    	// 생성자 추가_hieju_07.12
    	this.caller = caller;
    	
    	loginService = GWT.create(LoginService.class);
    	
        formPanel = new FormPanel();
        formPanel.setSize("350px", "200px");
        formPanel.setFrame(true);
        formPanel.setBorders(false);
        formPanel.setPadding(15);
        formPanel.setHeaderVisible(false);
        formPanel.setLabelAlign(LabelAlign.RIGHT);

        final Label accediAlConfiguratoreLabel = new Label(MSFMainApp.APPCONSTANTS.MsgLogin());
        formPanel.add(accediAlConfiguratoreLabel);
        accediAlConfiguratoreLabel.setStyleName("label-normal");
        accediAlConfiguratoreLabel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

        final HTML html = new HTML("<br>");
        formPanel.add(html);

        final FieldSet fieldSet = new FieldSet();
        formPanel.add(fieldSet);

        FormLayout layout = new FormLayout();  
        layout.setLabelWidth(60);  
        fieldSet.setLayout(layout);  

        utente = new TextField<String>();
        utente.setFieldLabel(MSFMainApp.ADMINCONSTANTS.User());
        utente.setId("utente");
        utente.setWidth(160);
        utente.setAllowBlank(false);
        TextField<String>.TextFieldMessages msgUser = utente.new TextFieldMessages();
        msgUser.setBlankText(MSFMainApp.MSFCONSTANTS.CampoObbligatorio());
        utente.setMessages(msgUser);
        utente.focus();
        fieldSet.add(utente);

        password = new TextField<String>();
        password.setFieldLabel(MSFMainApp.ADMINCONSTANTS.Password());
        password.setId("password");
        password.setWidth(160);
        password.setAllowBlank(false);
        TextField<String>.TextFieldMessages msgPwd = password.new TextFieldMessages();
        msgPwd.setBlankText(MSFMainApp.MSFCONSTANTS.CampoObbligatorio());
        password.setMessages(msgPwd);
        fieldSet.add(password);
        password.setPassword(true);
        password.addKeyListener(new KeyListener(){
             public void componentKeyDown(ComponentEvent event) {             	
            	if (event.getKeyCode() == 13){  // 엔터 키를 누른 경우 처리
            		if (checkValues()) {
                        CheckPasswordChangeRequired(new AsyncCallback<Long>() {
                            public void onFailure(Throwable caught) {
                            	MessageBox.info("", MSFMainApp.MSFCONSTANTS.NotUser(), null);
                            }

                            public void onSuccess(Long isPasswordChangeRequired) {
                                // 비동기 메소드 호출 성공 시 처리
                       
                                //추가수정_sys_23.09.10
                                if (isPasswordChangeRequired.compareTo(new Long(1))==0) { 
                                	ChangePwd changePwd = new ChangePwd();
                                    changePwd.show();
                                    MessageBox.info("", MSFMainApp.MSFCONSTANTS.PwddateChange(), null);
                                }else if (isPasswordChangeRequired.compareTo(new Long(-1))==0) {
                                	MessageBox.info("", MSFMainApp.MSFCONSTANTS.NotUser(), null);
                                }else if (isPasswordChangeRequired.compareTo(new Long(-2))==0){
                                	MessageBox.info("", MSFMainApp.MSFCONSTANTS.LockId(), null);
                                }else if (isPasswordChangeRequired.compareTo(new Long(2))==0){
                                
                                	ChangePwd changePwd = new ChangePwd();
                                    changePwd.show();
                                    MessageBox.info("", MSFMainApp.MSFCONSTANTS.PwdnewChange(), null);
                                } else {
                                	LoginAfterPasswordChange(utente.getValue(), password.getValue());
                                }
                                
                                
                            }
                        });
                    }
            		}
            	}
            });

        ricorda = new CheckBox();
        ricorda.setBoxLabel(MSFMainApp.ADMINMESSAGES.RicordaLogin());
        ricorda.setHideLabel(true);
        ricorda.setId("ricorda");
        if (Cookies.getCookie("seRicorda"+MSFMainApp.appl)!=null) {
            ricorda.setValue(Cookies.getCookie("seRicorda"+MSFMainApp.appl).equals("true"));
            if (ricorda.getValue()) {
                if (Cookies.getCookie("pwd"+MSFMainApp.appl)!=null) 
                    password.setValue(Cookies.getCookie("pwd"+MSFMainApp.appl));
                if (Cookies.getCookie("usr"+MSFMainApp.appl)!=null) 
                    utente.setValue(Cookies.getCookie("usr"+MSFMainApp.appl));
            }
        }
        fieldSet.add(ricorda);


        final HorizontalPanel buttonPanel = new HorizontalPanel();
        formPanel.add(buttonPanel);
        buttonPanel.setWidth("50%");
        buttonPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

 

        
            // 로그인 버튼 생성
            final Button accesso = new Button(MSFMainApp.MSFCONSTANTS.BtLogIn());
            accesso.addSelectionListener(new SelectionListener<ButtonEvent>() {
                public void componentSelected(ButtonEvent ce) {
                    if (checkValues()) {
                    	CheckPasswordChangeRequired(null);
                    }
                }
            });
            
            buttonPanel.add(accesso);
       
        final Button btnCreateUser = new Button("계정신청");
        buttonPanel.add(btnCreateUser);
        btnCreateUser.addSelectionListener(new SelectionListener<ButtonEvent>(){
            public void componentSelected(ButtonEvent ce) {
               
            	   FormUser formUser = new FormUser();
                   BaseModel userBM = new BaseModel();
                   formUser.setValues(userBM);
                   formUser.show(); 
                
            }   
        });

        initWidget(formPanel);
    }


	public void clearFormFields() {
        utente.clear();
        password.clear();
        ricorda.clear();
    }

    
    private boolean checkValues(){ // 유효성 검사(아이디, 비밀번호)
        boolean result = true;
        if (!utente.isValid()) {
            utente.markInvalid(MSFMainApp.MSFCONSTANTS.CampoObbligatorio());
            utente.focus();
            result = false;
        }
        if (!password.isValid()) {
            password.markInvalid(MSFMainApp.MSFCONSTANTS.CampoObbligatorio());
            password.focus();
            result = false;
        }
               
        return result;
    }
    
    
     	
     // 비밀번호 변경일자 감지 기능 추가_hieju_06.26
    public void CheckPasswordChangeRequired(AsyncCallback<Long> asyncCallback) {
        final String userId = utente.getValue();
        final String userpassword = password.getValue();
        
     
        loginService.isPasswordChangeRequired(userId, userpassword, new AsyncCallback<Long>() {
        	
            public void onFailure(Throwable caught) {
                 caller.getLoginListener().handleLoginEvent(utente.getValue(), password.getValue(), ricorda.getValue());
            }

            // @Override
            public void onSuccess(Long result) {
            	
                if (result.compareTo(new Long(1))==0) { 
                	ChangePwd changePwd = new ChangePwd();
                    changePwd.show();
                    MessageBox.info("", MSFMainApp.MSFCONSTANTS.PwddateChange(), null);
                }else if (result.compareTo(new Long(-1))==0) {
                	MessageBox.info("", MSFMainApp.MSFCONSTANTS.NotUser(), null);
                }else if (result.compareTo(new Long(-2))==0){
                	MessageBox.info("", MSFMainApp.MSFCONSTANTS.LockId(), null);
                }else if (result.compareTo(new Long(2))==0){
                    //추가수정_sys_23.09.10
                	ChangePwd changePwd = new ChangePwd();
                    changePwd.show();
                    MessageBox.info("", MSFMainApp.MSFCONSTANTS.PwdnewChange(), null);
                } else {
                	LoginAfterPasswordChange(userId, userpassword);
                }
            }
            
        });
        }

	// 비밀번호 변경이 끝나고 로그인 실행 기능 추가_hieju_06.26
 	private void LoginAfterPasswordChange(String userId, String userPassword) {
  
    final String ricordaValue = (ricorda != null?"true":"false");
    // caller 생성자 추가
    final Login caller = LoginForm.this.caller;

    loginService.checkUsr(userId, userPassword, ricordaValue, new AsyncCallback<MSFSysm0100DTO>() {
    	
		public void onFailure(Throwable caught) {
			MessageBox.info("", MSFMainApp.MSFCONSTANTS.NotUser(), null);
        }
        public void onSuccess(MSFSysm0100DTO sysm0100Login) {
			caller.getLoginListener().handleLoginEvent(utente.getValue(), password.getValue(), ricorda.getValue());
			
			
        }
    });
 		}
    
    }



    
