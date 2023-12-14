/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.login;



import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.SysIfSysm0100DTO;
import com.app.smrmf.core.msfmainapp.client.service.system.LoginService;
import com.app.smrmf.core.msfmainapp.client.service.system.LoginServiceAsync;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.binding.FormBinding;
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


public class ChangePwd extends Window {
	
	private TextField<String> userId;
    private TextField<String> oldPwd;
    private TextField<String> newPwd;
    private TextField<String> confNewPwd;
    private LoginServiceAsync loginService = LoginService.Util.getInstance(); // 로그인서비스 연동_2023.06.08_hieju
   
    
    public ChangePwd() {
        super();
        setBorders(false);
        setHeadingText(MSFMainApp.MSFCONSTANTS.CambiaPwd());//setHeading(MSFMainApp.MSFCONSTANTS.CambiaPwd());  
        setIconStyle("icon_key");  
        setMaximizable(false);  
        setResizable(false);  
        setLayout(new FitLayout());  
        setWidth(400);  
        setHeight(200);  
        setModal(true);  
        setBodyBorder(false);

        final FormPanel formPanel = new FormPanel();
        formPanel.setBorders(false);
        add(formPanel);
        formPanel.setFrame(true);
        formPanel.setSize("400px", "200px");
        formPanel.setBodyBorder(false);
        formPanel.setBorders(false);
        formPanel.setHeaderVisible(false);

        final FieldSet fieldSet = new FieldSet();
        formPanel.add(fieldSet);

        FormLayout layout = new FormLayout();  
        layout.setLabelWidth(120);  
        fieldSet.setLayout(layout);  
        
        // id추가_2023.06.08_hieju
        userId = new TextField<String>();
        fieldSet.add(userId);
        userId.setFieldLabel(MSFMainApp.MSFCONSTANTS.UserId());
        userId.setPassword(false);

        oldPwd = new TextField<String>();
        fieldSet.add(oldPwd);
        oldPwd.setFieldLabel(MSFMainApp.MSFCONSTANTS.OldPwd());
        oldPwd.setPassword(true);

        newPwd = new TextField<String>();
        fieldSet.add(newPwd);
        newPwd.setFieldLabel(MSFMainApp.MSFCONSTANTS.NewPwd());
        newPwd.setPassword(true);

        confNewPwd = new TextField<String>();
        fieldSet.add(confNewPwd);
        confNewPwd.setFieldLabel(MSFMainApp.MSFCONSTANTS.ConPwd());
        confNewPwd.setPassword(true);

        Button salva = new Button(MSFMainApp.MSFCONSTANTS.BtSave());
        salva.addSelectionListener(new SelectionListener<ButtonEvent>(){
            public void componentSelected(ButtonEvent ce) {
                salva();
            }
        });

        addButton(salva);

        Button annulla = new Button(MSFMainApp.MSFCONSTANTS.BtDelete());
        annulla.addSelectionListener(new SelectionListener<ButtonEvent>(){
            public void componentSelected(ButtonEvent ce) {
                hide();
            }
        });

        addButton(annulla);
        setButtonAlign(HorizontalAlignment.CENTER);
    }
    
    
        public void salva(){
        	
        // 추가적인 데이터 처리를 위한 메소드 호출
        if (checkValues()) {
        	changePwdOnDB();
        }
    }
   


	private boolean checkValues(){
        boolean result = true;
        if (oldPwd.getValue()==null) {
        	oldPwd.markInvalid(MSFMainApp.MSFCONSTANTS.CampoObbligatorio());
        	oldPwd.focus();
        	result = false;
        }
        if (confNewPwd.getValue()==null) {
            confNewPwd.markInvalid(MSFMainApp.MSFCONSTANTS.CampoObbligatorio());
            confNewPwd.focus();
            result = false;
        }
        if (newPwd.getValue()==null) {
            newPwd.markInvalid(MSFMainApp.MSFCONSTANTS.CampoObbligatorio());
            newPwd.focus();
            result = false;
        }
        if (newPwd.getValue()!=null && 
            newPwd.getValue().equals(oldPwd.getValue())) {
            newPwd.markInvalid(MSFMainApp.MSFCONSTANTS.VecchiaPwdUgualeNuova());
            newPwd.focus();
            result = false;
        }
        if (newPwd.getValue()!=null && 
                !newPwd.getValue().equals(confNewPwd.getValue())) {
            newPwd.markInvalid(MSFMainApp.MSFCONSTANTS.NuovaPwdConferma());
            newPwd.focus();
            result = false;
        }
        // id추가_2023.06.08_hieju
        if (userId.getValue()==null) {
        	userId.markInvalid(MSFMainApp.MSFCONSTANTS.CampoObbligatorio());
        	userId.focus();
            result = false;
        } 
       return result;
    }

    	private void changePwdOnDB(){ // 코드 변경_2023.06.08_hieju
    	
    	final String id = userId.getValue();
    	final String oldPassword = oldPwd.getValue();
    	final String newPassword = newPwd.getValue();
        
        // 비밀번호 정규식 검증  hieju_05.25
        if (!isValidPassword(newPassword)) {
            MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), "비밀번호는 영문, 숫자, 특수문자를 포함하여 9자 이상이어야 합니다.", null);
            return; // 정규식패턴에 맞지않게 입력하면 오류 팝업창 뜨고 처음화면으로 돌아감.
        }
        
		loginService.changePassword(id, oldPassword, newPassword, new AsyncCallback<Long>() {
            public void onFailure(Throwable caught) {
                MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService(" changePassword(): " + caught), null);
                		
            }

            public void onSuccess(Long result) {
            	if (result.compareTo(new Long(0))==0) {
            		MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), MSFMainApp.MSFCONSTANTS.SessioneNonValida(), null);
                } else if (result.compareTo(new Long(-1))==0) {
                	oldPwd.markInvalid(MSFMainApp.MSFCONSTANTS.OldPwdNotCorrect());
                    oldPwd.focus();
                } else {
                    MessageBox.info("", MSFMainApp.MSFCONSTANTS.PasswordAggiornata(), null);// 비밀번호 변경 성공!
                    hide(); // 팝업창 닫기
                }
            }
        });
    }


     /*private void checkPwdOnDB(){

    	loginService.checkPassword(oldPwd.getValue(), new AsyncCallback<Long>(){
            public void onFailure(Throwable caught) {
                MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService(" checkPassword(): "+caught), null);
            }

            public void onSuccess(Long result) {
                if (result.compareTo(new Long(0))==0) {
                    oldPwd.markInvalid(MSFMainApp.MSFCONSTANTS.OldPwdNotCorrect());
                    oldPwd.focus();
                } else {
                    changePwdOnDB();
                    hide();
                }
            }
        });
    }*/
    
    // 비밀번호 정규식 검증  hieju_05.25 *************************************************************************************
    private boolean isValidPassword(String password) {
        // 비밀번호 정규식을 여기에 추가하여 검증합니다.
        // 예시로  영어, 특수문자를 포함하고 9자 이상인지 확인하는 정규식을 사용합니다.
        String regex = "^(?=.*[a-zA-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{9,}$";
        return password.matches(regex);
    }
    
		};


          
			

