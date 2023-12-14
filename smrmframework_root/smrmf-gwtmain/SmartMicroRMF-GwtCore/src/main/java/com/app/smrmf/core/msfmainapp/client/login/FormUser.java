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
import com.app.smrmf.core.msfmainapp.client.widget.MSFComboBox;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTextField;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0400DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.utils.SysifComServiceUtils;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.KeyListener;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Params;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class FormUser extends Window {
    private FormBinding formBinding;
    private LoginServiceAsync loginService = LoginService.Util.getInstance();

    public FormUser() {
        setSize("450", "300");
        setHeadingText(MSFMainApp.ADMINCONSTANTS.TitleUpdateUser());  //setHeading(MSFMainApp.ADMINCONSTANTS.TitleUpdateUser());
        setModal(true);
        setLayout(new RowLayout(Orientation.VERTICAL));
        {
            Button btnSalva = new Button("승인신청");
            btnSalva.addSelectionListener(new SelectionListener<ButtonEvent>() {
                public void componentSelected(ButtonEvent ce) {
                	
                	SysIfSysm0100DTO utenteDto = new SysIfSysm0100DTO();

                    utenteDto.setUsrId(MSFSharedUtils.allowNulls(formBinding.getModel().get("usrId")));		
                    utenteDto.setUsrNm(MSFSharedUtils.allowNulls(formBinding.getModel().get("usrNm")));
                    
                    BaseModel bmDeptCd = formBinding.getModel().get("deptCd"); 
                    utenteDto.setDeptCd(MSFSharedUtils.allowNulls(bmDeptCd.get("deptCd")));	
                    utenteDto.setUsrTel(MSFSharedUtils.allowNulls(formBinding.getModel().get("usrTel")));	
                    utenteDto.setEmail(MSFSharedUtils.allowNulls(formBinding.getModel().get("email")));
                    utenteDto.setPwd(MSFSharedUtils.allowNulls(formBinding.getModel().get("pwdOne")));	
                    
                    String passwordOne = MSFSharedUtils.allowNulls(formBinding.getModel().get("pwdOne"));
                    String passwordTwo = MSFSharedUtils.allowNulls(formBinding.getModel().get("pwdTwo"));

                    // 패스워드 정규식 패턴
                    String passwordPattern = "^(?=.*[a-zA-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{9,}$";

                    // 비밀번호 유효성 검사(패스워드를 알맞게 입력하지 않으면 승인 실패 처리)_hieju/06.05
                    if (!passwordOne.equals(passwordTwo)) {
                        MessageBox.alert("패스워드 오류", "입력한 패스워드가 일치하지 않습니다.", null);
                        return; // 승인신청을 중단하고 종료
                    } else if (!passwordOne.matches(passwordPattern) || !passwordTwo.matches(passwordPattern)) {
                        MessageBox.alert("패스워드 오류", "비밀번호는 숫자, 영문자, 특수문자를 포함하고 9자 이상이어야 합니다.", null);
                        return; // 승인신청을 중단하고 종료
                    }
                    loginService.saveUser(utenteDto, new AsyncCallback<Long>() {
                        public void onSuccess(Long result) {
                        	 MessageBox.alert("승인", 
                                     "관리자에게 승인신청이 완료되었습니다.", null);
                            hide();
                        }
                        public void onFailure(Throwable caught) {
                            MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
                                    MSFMainApp.ADMINMESSAGES.SaveUserException(), null);
                            hide();
                        }
                    });
                }
            });
            addButton(btnSalva);
        }
        {
            Button btnAnnulla = new Button("취소");
            btnAnnulla.addSelectionListener(new SelectionListener<ButtonEvent>() {
                public void componentSelected(ButtonEvent ce) {
                    hide();
                }
            });
            addButton(btnAnnulla);
        }
        {
            FormPanel formPanel = new FormPanel();
            formPanel.setLabelWidth(100);
            formPanel.setFieldWidth(290);
            formPanel.setBodyBorder(false);
            formPanel.setHeaderVisible(false);
           // formPanel.setHeading("");
            formPanel.setHeadingText("");
            formPanel.setCollapsible(true);
            formBinding = new FormBinding(formPanel, true);


            {
                HiddenField<String> sysDivCd = new HiddenField<String>();
                formPanel.add(sysDivCd);
                sysDivCd.setName("sysDivCd");
                sysDivCd.setId("sysDivCd");
            }
            {
            	MSFTextField usrId = new MSFTextField();
                formPanel.add(usrId);
                usrId.setEmptyText("세올아이디를 입력해주세요");
                usrId.setName("usrId");
                usrId.setId("usrId");
                usrId.setFieldLabel("아이디");
            }
            {
            	MSFTextField usrNm = new MSFTextField();
                formPanel.add(usrNm);
                usrNm.setName("usrNm");
                usrNm.setId("usrNm");
                usrNm.setFieldLabel("성 명");
            }
            {   //부서 
            	ListStore<BaseModel> listStoreDeptCd 	= new ListStore<BaseModel>();
            	SysIfBass0400DTO sysComBass0400Dto  = new SysIfBass0400DTO(); //부서코드
                
                listStoreDeptCd = SysifComServiceUtils.getSysIfWithNoLoginBass0400List(sysComBass0400Dto);
                
            	MSFComboBox<BaseModel> deptCd = new MSFComboBox<BaseModel>();
            	deptCd.setName("deptCd");
            	deptCd.setForceSelection(true);
            	deptCd.setMinChars(1);
            	deptCd.setDisplayField("deptNmRtchnt");
            	deptCd.setValueField("deptCd");
            	deptCd.setTriggerAction(TriggerAction.ALL);
            	deptCd.setEmptyText("--부서선택--");
            	deptCd.setSelectOnFocus(true); 
            	deptCd.setReadOnly(false);
            	deptCd.setEnabled(true); 
            	deptCd.setStore(listStoreDeptCd );
                   
                formPanel.add(deptCd); 
                deptCd.setId("deptCd");
                deptCd.setFieldLabel("부 서");
            }
            
            {
            	MSFTextField usrTel = new MSFTextField();
                formPanel.add(usrTel);
                usrTel.setEmptyText("02-333-3333");
                usrTel.setName("usrTel");
                usrTel.setId("usrTel");
                usrTel.setFieldLabel("전화번호");
            }
            
            {
            	MSFTextField email = new MSFTextField();
                formPanel.add(email);
                email.setName("email");
                email.setId("email");
                email.setRegex("^(?=.*[a-zA-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{9,}$");
                TextField<String>.TextFieldMessages msgs = email.new TextFieldMessages();
                msgs.setRegexText(MSFMainApp.MSFMESSAGES.FormatoNonValido());
                email.setFieldLabel("이메일");
            }
            {
            	final MSFTextField pwdOne = new MSFTextField();
                formPanel.add(pwdOne);
                pwdOne.setName("pwdOne");
                pwdOne.setId("pwdOne");
                // 비밀번호 유효성검사 정규식 설정_hieju/06.05
                pwdOne.setRegex("^(?=.*[a-zA-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{9,}$"); 
                pwdOne.setPassword(true);
                pwdOne.setFieldLabel("패스워드");
            	// 비밀번호안내_hieju/06.05
                pwdOne.setToolTip("비밀번호는 9자 이상의 길이어야하며, 적어도 하나의 숫자와 영문자와 특수문자를 포함해야합니다.");
                
                final MSFTextField pwdTwo = new MSFTextField();
                formPanel.add(pwdTwo);
                pwdTwo.setName("pwdTwo");
                pwdTwo.setId("pwdTwo");
                // 비밀번호 유효성검사 정규식 설정_hieju/06.05
                pwdTwo.setRegex("^(?=.*[a-zA-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{9,}$");
                pwdTwo.setPassword(true);
                pwdTwo.setFieldLabel("패스워드확인");
                // 비밀번호안내_hieju/06.05
                pwdTwo.setToolTip("비밀번호는 9자 이상의 길이어야하며, 적어도 하나의 숫자와 영문자와 특수문자를 포함해야합니다.");
              
                pwdTwo.addKeyListener(new KeyListener() {
                	
                	// 회원가입 버튼 클릭 시 호출되는 메서드 또는 이벤트 핸들러 기능 수정_hieju/05.29
					public void componentKeyUp(ComponentEvent event) { 
                        super.componentKeyUp(event);
                        pwdTwo.validate(); 
                        if(event.getKeyCode() == KeyCodes.KEY_ENTER) {
                        	if (MSFSharedUtils.allowNulls(pwdOne.getValue()).trim().equals("")) {
                        		pwdOne.focus();
                            	pwdOne.setSelectOnFocus(true);
                        	}
                        	
                        	if(!MSFSharedUtils.allowNulls(pwdOne.getRawValue()).equals(MSFSharedUtils.allowNulls(pwdTwo.getRawValue()))) {
                        		pwdTwo.focus();
                        		pwdTwo.setSelectOnFocus(true);
                        	    Info.display("패스워드", "{0}가 일치하지 않습니다.",new Params("패스워드"));  
                        	}
                        }
                    }
                 });
                
                
                pwdOne.addListener(Events.KeyUp, new Listener<BaseEvent>() { 
                    @Override
                    public void handleEvent(BaseEvent be) {  
                        if (MSFSharedUtils.allowNulls(pwdOne.getValue()).trim().equals("")) {
                        	pwdOne.focus();
                        	pwdOne.setSelectOnFocus(true);
                        	Info.display("패스워드", "{0}가 일치하지 않습니다.",new Params("패스워드"));  
                    	    
                        	
                        } 
                        
                        
                        if(!MSFSharedUtils.allowNulls(pwdOne.getRawValue()).equals(MSFSharedUtils.allowNulls(pwdTwo.getRawValue()))) { 
                    		 
                    	}
                        
                    } 
              }); 
               
                pwdOne.addListener(Events.OnBlur, new Listener<BaseEvent>() {
                    @Override
                    public void handleEvent(BaseEvent be) {
                        if (!isValidPassword(pwdOne.getRawValue())) {
                        	pwdOne.markInvalid("비밀번호는 한글, 영문, 특수문자 조합으로 9자 이상이어야 합니다.");
                        }
                    }

                	private boolean isValidPassword(String rawValue) {
						String regex = "^(?=.*[a-zA-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{9,}$";
						 return rawValue.matches(regex);
					}
                	// 수정 끝*************************** //

					

                });
              pwdTwo.addListener(Events.OnBlur, new Listener<BaseEvent>() { 
                    @Override
                    public void handleEvent(BaseEvent be) {  
                       
                        if(!MSFSharedUtils.allowNulls(pwdOne.getRawValue()).equals(MSFSharedUtils.allowNulls(pwdTwo.getRawValue()))) {
                        	pwdTwo.focus();
                    		pwdTwo.setSelectOnFocus(true);
                    	    Info.display("패스워드", "{0}가 일치하지 않습니다.",new Params("패스워드"));  
                    	}
                        
                    } 
              });   
                
            }

          formBinding.autoBind();
            add(formPanel);
        }
    }


	public void setValues(BaseModel baseModel){
        formBinding.bind(baseModel);
    }

}
