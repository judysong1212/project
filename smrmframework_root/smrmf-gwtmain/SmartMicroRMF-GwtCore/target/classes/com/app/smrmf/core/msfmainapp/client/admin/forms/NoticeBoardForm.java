/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.admin.forms;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.admin.dto.Bord0300DTO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.Bord0400DTO;
import com.app.smrmf.core.msfmainapp.client.service.Bord0300Service;
import com.app.smrmf.core.msfmainapp.client.service.Bord0300ServiceAsync;
import com.app.smrmf.core.msfmainapp.client.service.Bord0400Service;
import com.app.smrmf.core.msfmainapp.client.service.Bord0400ServiceAsync;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FormEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.Html;
import com.extjs.gxt.ui.client.widget.Label;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.HiddenField;
import com.extjs.gxt.ui.client.widget.form.HtmlEditor;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnData;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class NoticeBoardForm extends MSFFormPanel {
  
    private Bord0300ServiceAsync bord0300Service = Bord0300Service.Util.getInstance();
    private Bord0400ServiceAsync bord0400Service = Bord0400Service.Util.getInstance();
    
    private TextField<String> ppgPernNm;  //작성자명
    private TextField<String>  ppgPernEmail ;    /** column 작성자 메일 : ppgPernEmail */
    private TextField<String> bullBordMsgeTtl; //제목 
    private HtmlEditor bullBordMsgeCtnt; //내용  
    private Boolean frmBoolCheck ;   //파일업로드 처리 
    
    private HiddenField<String> sysDivCd;   /** column 시스템구분코드 : sysDivCd */
    private HiddenField<String>   bullBordMsgeSeilNum;   /** column 게시글일련번호 : bullBordMsgeSeilNum */
    private HiddenField<String> bullBordUid ;  /** column 게시판_UID : bullBordUid */
    private HiddenField<String>   bullBordGrpId;   /** column 게시판그룹ID : bullBordGrpId */
    private HiddenField<String>   tplvlWrtnInfo;   /** column 최상위 글 정보 : tplvlWrtnInfo */
    private HiddenField<String>   wrtnAswrStge;   /** column 글의 답변단계 : wrtnAswrStge */
    private HiddenField<String>   wrtnRgstnOrd;   /** column 글의 등록된 순서 : wrtnRgstnOrd */
    private HiddenField<String>   aswrWrtnNum ;  /** column 답변하는 글의 번호 : aswrWrtnNum */
    private HiddenField<String> usrId;   /** column 사용자 아이디 : usrId */
    private TextField<String> wrtnSecrNum ;  /** column 글 비밀번호 : wrtnSecrNum */
    private HiddenField<String>   inqyNum ;  /** column 조회수 : inqyNum */
    private HiddenField<String> htmlUseYn;   /** column HTML 사용여부 : htmlUseYn */
    private HiddenField<String> bullBordMsgeDelYn;   /** column 삭제 여부 : bullBordMsgeDelYn */
    private HiddenField<String> notiBgnnDt;   /** column 공지 시작일 : notiBgnnDt */
    private HiddenField<String> notiEndDt;   /** column 공지 종료일 : notiEndDt */
    private HiddenField<String> flRfta;   /** column 파일경로 : flRfta */
    private HiddenField<String> flNm;   /** column 파일명  : flNm */ 
      
    private FileUploadField boardAtthflUp; 
    
    
    private ActionDatabase actionDatabase;
    private MSFPanel caller;
    private Boolean reading = false;
    public  FormBinding formBinding;
    
    private LayoutContainer filedown;

    public NoticeBoardForm(ActionDatabase actionDatabase, MSFPanel caller) {
      //  super();
        this.setFrame(false);
        this.setBodyBorder(false);
        this.setBorders(false);
        this.setHeaderVisible(false);
        FormLayout layout = new FormLayout();
        layout.setDefaultWidth(600);
        layout.setLabelWidth(0);  
        this.setLayout(layout);   
        this.setAutoHeight(true);
        this.actionDatabase = actionDatabase;
        this.caller = caller;
        if (actionDatabase.name().equalsIgnoreCase("DELETE")) {
            this.reading = true;
        } else if (actionDatabase.name().equalsIgnoreCase("READ")) {
            this.reading = true;
        } else {    
            this.reading = false;
        } 

        this.sysDivCd= new HiddenField<String>();   /** column 시스템구분코드 : sysDivCd */
        this.sysDivCd.setName("sysDivCd"); 
        add(this.sysDivCd);
        this.bullBordMsgeSeilNum= new HiddenField<String>();   /** column 게시글일련번호 : bullBordMsgeSeilNum */
        this.bullBordMsgeSeilNum.setName("bullBordMsgeSeilNum"); 
        add(this.bullBordMsgeSeilNum);
        this.bullBordUid = new HiddenField<String>();  /** column 게시판_UID : bullBordUid */
        this.bullBordUid.setName("bullBordUid"); 
        add(this.bullBordUid);
        
        bullBordGrpId= new HiddenField<String>();   /** column 게시판그룹ID : bullBordGrpId */
        bullBordGrpId.setName("bullBordGrpId");
        add(bullBordGrpId);
        tplvlWrtnInfo= new HiddenField<String>();   /** column 최상위 글 정보 : tplvlWrtnInfo */
        tplvlWrtnInfo.setName("tplvlWrtnInfo");
        add(tplvlWrtnInfo);
        wrtnAswrStge= new HiddenField<String>();   /** column 글의 답변단계 : wrtnAswrStge */
        wrtnAswrStge.setName("wrtnAswrStge");
        add(wrtnAswrStge);
        wrtnRgstnOrd= new HiddenField<String>();   /** column 글의 등록된 순서 : wrtnRgstnOrd */
        wrtnRgstnOrd.setName("wrtnRgstnOrd");
        add(wrtnRgstnOrd);
        aswrWrtnNum = new HiddenField<String>();  /** column 답변하는 글의 번호 : aswrWrtnNum */
        aswrWrtnNum.setName("aswrWrtnNum");
        add(aswrWrtnNum);
        usrId= new HiddenField<String>();   /** column 사용자 아이디 : usrId */
        usrId.setName("usrId");
        add(usrId); 
        inqyNum = new HiddenField<String>();  /** column 조회수 : inqyNum */
        inqyNum.setName("inqyNum");
        add(inqyNum);
        htmlUseYn= new HiddenField<String>();   /** column HTML 사용여부 : htmlUseYn */
        htmlUseYn.setName("htmlUseYn");
        add(htmlUseYn);
        bullBordMsgeDelYn= new HiddenField<String>();   /** column 삭제 여부 : bullBordMsgeDelYn */
        bullBordMsgeDelYn.setName("bullBordMsgeDelYn");
        add(bullBordMsgeDelYn);
        notiBgnnDt= new HiddenField<String>();   /** column 공지 시작일 : notiBgnnDt */
        notiBgnnDt.setName("notiBgnnDt");
        add(notiBgnnDt);
        notiEndDt= new HiddenField<String>();   /** column 공지 종료일 : notiEndDt */
        notiEndDt.setName("notiEndDt");
        add(notiEndDt); 
        
        flRfta= new HiddenField<String>();   /** column 파일경로 : flRfta */
        flRfta.setName("flRfta");
        add(flRfta);
        
        flNm= new HiddenField<String>();   /** column 파일명  : flNm */ 
        flNm.setName("flNm");
        add(flNm);
        
        createColumnForm();  
         

        formBinding = new FormBinding(this, true);
         

    }
    
    private void createColumnForm() {  
         
        FormData formData = new FormData("100%");  
       
        LayoutContainer main = new LayoutContainer();  
        main.setLayout(new ColumnLayout());  
      
        LayoutContainer leftRight = new LayoutContainer();  
       // leftRight.setStyleAttribute("paddingRight", "10px");  
        FormLayout layout = new FormLayout();  
        layout.setLabelWidth(70);
        leftRight.setLayout(layout);  
      
        ppgPernNm = new TextField<String>();  
        ppgPernNm.setName("ppgPernNm");
        ppgPernNm.setReadOnly(true);
        ppgPernNm.setFieldLabel("작성자");  
        leftRight.add(ppgPernNm, new FormData("50%"));  
        
        ppgPernEmail = new TextField<String>();  
        ppgPernEmail.setName("ppgPernEmail");
        ppgPernEmail.setReadOnly(reading);
        ppgPernEmail.setFieldLabel("이메일");  
        leftRight.add(ppgPernEmail, formData);  
         
      
        bullBordMsgeTtl = new TextField<String>(); 
        bullBordMsgeTtl.setAllowBlank(false);
        bullBordMsgeTtl.setName("bullBordMsgeTtl");
         bullBordMsgeTtl.setReadOnly(reading);
        bullBordMsgeTtl.setFieldLabel("제 목");  
        leftRight.add(bullBordMsgeTtl, formData);  
      
        /** column 글 비밀번호 : wrtnSecrNum */
        wrtnSecrNum = new TextField<String>(); 
        wrtnSecrNum.setName("wrtnSecrNum");
        wrtnSecrNum.setAllowBlank(false);
         wrtnSecrNum.setReadOnly(reading);
        wrtnSecrNum.setPassword(true);
        wrtnSecrNum.setFieldLabel("비밀번호");  
        leftRight.add(wrtnSecrNum, new FormData("50%"));  
       
        boardAtthflUp = new FileUploadField(); 
        boardAtthflUp.setName("boardAtthflUp"); 
         boardAtthflUp.setEnabled((reading ? false : true));
        boardAtthflUp.setButtonOffset(10);
        boardAtthflUp.setShim(true);  
        boardAtthflUp.setFieldLabel("파일");
        leftRight.add(boardAtthflUp, formData); 
           
        main.add(leftRight, new ColumnData(1));   
      
        filedown = new LayoutContainer();  
        filedown.setLayout(new ColumnLayout());  
        filedown.setVisible(false);
      
        leftRight.add(filedown);
        
        
        add(main, new FormData("100%"));   
      
        bullBordMsgeCtnt = new HtmlEditor();   
        bullBordMsgeCtnt.setLabelSeparator(""); 
        bullBordMsgeCtnt.setInEditor((reading ? false : true));
        bullBordMsgeCtnt.setReadOnly(reading);
        bullBordMsgeCtnt.setShowToolbar((reading ? false : true));
        bullBordMsgeCtnt.setName("bullBordMsgeCtnt");
        bullBordMsgeCtnt.setWidth(630);
        bullBordMsgeCtnt.setHeight(500);   
        add(bullBordMsgeCtnt, formData);  
       
      } 
    
    
    private void fileUploadData(Bord0300DTO bord0300Dto) { 
    
        //get the filename to be uploaded
        String filename = MSFSharedUtils.allowNulls(boardAtthflUp.getValue());
       
        if (filename.length() == 0) {
            getMSFWindows().hide();
            recharge();
          //Window.alert("No File Specified!"); 
        } else {
            
            Bord0400DTO bord0400Dto = new Bord0400DTO();   
            
            bord0400Dto.setSysDivCd(bord0300Dto.getSysDivCd());    /** column 시스템구분코드 : sysDivCd */
            bord0400Dto.setBullBordMsgeAttcFlNum(0L);    /** column 게시글첨부파일일련번호 : bullBordMsgeAttcFlNum */
            bord0400Dto.setBullBordMsgeSeilNum(bord0300Dto.getBullBordMsgeSeilNum());    /** column 게시글일련번호 : bullBordMsgeSeilNum */
            bord0400Dto.setBullBordUid(bord0300Dto.getBullBordUid());    /** column 게시판_UID : bullBordUid */
            bord0400Dto.setBullBordGrpId(bord0300Dto.getBullBordGrpId());    /** column 게시판그룹ID : bullBordGrpId */
            
            final String fullPath = boardAtthflUp.getValue();
            int lastIndex = fullPath.lastIndexOf('\\');
            String fileName = fullPath.substring(lastIndex + 1);
            
          //  Window.alert(fileName);
            
            bord0400Dto.setFlNm(fileName);    /** column 파일 이름 : flNm */
            bord0400Dto.setFlSz("");    /** column 파일 크기 : flSz */
            bord0400Dto.setCtntTyp("F");    /** column 콘텐트 타입 : ctntTyp */
            bord0400Dto.setDwldNum(0L);    /** column 다운로드 수 : dwldNum */
            bord0400Dto.setImgSzEtt(0L);    /** column 이미지 크기 넓이 : imgSzEtt */
            bord0400Dto.setImgSzHeit(0L);    /** column 이미지 크기 높이 : imgSzHeit */
            bord0400Dto.setFlRfta("");    /** column 게시글파일경로 : flRfta */
            bord0400Dto.setKybdr(bord0300Dto.getKybdr());    /** column 입력자 : kybdr */
            bord0400Dto.setInptDt(bord0300Dto.getInptDt());    /** column 입력일자 : inptDt */
            bord0400Dto.setInptAddr(bord0300Dto.getInptAddr());    /** column 입력주소 : inptAddr */
            bord0400Dto.setIsmt(bord0300Dto.getIsmt());    /** column 수정자 : ismt */
            bord0400Dto.setRevnDt(bord0300Dto.getRevnDt());    /** column 수정일자 : revnDt */
            bord0400Dto.setRevnAddr(bord0300Dto.getRevnAddr());    /** column 수정주소 : revnAddr */ 
              
            bord0400Service.activityOnBoard0400(bord0400Dto, 
                                      actionDatabase,
                                      new AsyncCallback<Bord0400DTO>() {
                  public void onFailure(Throwable caught) {
                      MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                              MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnVoceMenu(" + actionDatabase.name() + ") : " + caught), null);
                  }
                  public void onSuccess(Bord0400DTO result) {
                      
                      funcFileUpload();
                  } 
              });
               
        }   
      
    }  
    
    
private void  funcFileUpload() { 

    //submit the form
     mask("파일 업로드 중입니다. 업로드 중...");  
     //파일업로드 처리
     this.setAction(GWT.getHostPageBaseURL() + "upload/BoardFileUpload.do");
     this.setEncoding(Encoding.MULTIPART);
     this.setMethod(Method.POST);  
     this.submit();
     this.onFrameLoad(); 
     frmBoolCheck = true;
     // reset and unmask the form 
     // after file upload 
       this.addListener(Events.Submit, new Listener<FormEvent>() {
         public void handleEvent(FormEvent evt) {  
             unmask();  
             if ("success".endsWith(evt.getResultHtml()) && frmBoolCheck) {
                 //업로드가  성공했으면 인서트 모듈을 태운다.  
                 frmBoolCheck = false;
                 evt.setResultHtml("");
                 getMSFWindows().hide();
                 recharge();
             } else {
                 //실패 메시지나 에러 메시지 처리 .
                 evt.setResultHtml("");
                // MessageBox.alert("에러", 
                //         MSFMainApp.ADMINMESSAGES.ExceptionMessageService("fileUploadData(): " + evt.getSource()), null);
             }
         };
      }); 
       
}
 
// 게시글 클릭 시 나오는 창에서 파일 다운로드 링크
// http://127.0.0.1:8085/ExTermsFile/UploadFile/EXTERMA01_%EB%AC%B4%EA%B8%B0%EA%B3%84%EC%95%BD%EC%A7%81%EC%97%85%EB%AC%B4%ED%9D%90%EB%A6%84%EB%8F%84.doc
// 파일다운로드 가능
    public void bind(final ModelData model) { 
        formBinding.bind(model);
        formBinding.addListener(Events.Bind, new Listener<BaseEvent>() {
            //@Override
            public void handleEvent(BaseEvent be) {
                
                if (MSFSharedUtils.paramNotNull(flNm.getValue())) {
                    
                    Label lblTitle = new Label("다운로드");
                    Html link = new Html("<a href='#'>"+flNm.getValue()+"</a>");
                    // Html link = new Html("<div class='link'>"+flNm+"</div>");
                     link.addListener(Events.OnClick, new Listener<BaseEvent>(){
                         public void handleEvent(BaseEvent be) {
                        
                                 if (flNm != null) { 
                                     Window.open(GWT.getHostPageBaseURL() + flRfta.getValue() + "/" + flNm.getValue(), "FileWindow", "scrollbars=no,resizable=no,location=no,toolbar=no,menubar=no,height=0,width=0");
                                      
                                 }
                         }
                     }); 
                     
                     filedown.add(lblTitle,new ColumnData(0.12));
                     filedown.add(link,new ColumnData(0.7));
                     filedown.setVisible(true);
                     
                     filedown.setHeight(30);
                    
                } else {
                  //  Window.alert(flNm.getValue());
                }
                
                if (actionDatabase.name().equalsIgnoreCase("INSERT")) {
                    sysDivCd.setValue(MSFMainApp.get().getUser().getSysDivCd());/** column 시스템구분코드 : sysDivCd */
                    bullBordMsgeSeilNum.setValue("0"); /** column 게시글일련번호 : bullBordMsgeSeilNum */
                    bullBordUid.setValue("paygenapp02");  /** column 게시판_UID : bullBordUid */
                    bullBordGrpId.setValue("1");   /** column 게시판그룹ID : bullBordGrpId */
                    tplvlWrtnInfo.setValue("0");   /** column 최상위 글 정보 : tplvlWrtnInfo */
                    wrtnAswrStge.setValue("0");   /** column 글의 답변단계 : wrtnAswrStge */
                    wrtnRgstnOrd.setValue("0");   /** column 글의 등록된 순서 : wrtnRgstnOrd */
                    aswrWrtnNum.setValue("0");  /** column 답변하는 글의 번호 : aswrWrtnNum */
                    usrId.setValue(MSFMainApp.get().getUser().getUsrId());   /** column 사용자 아이디 : usrId */
                    wrtnSecrNum.setValue("");  /** column 글 비밀번호 : wrtnSecrNum */
                    inqyNum.setValue("0");  /** column 조회수 : inqyNum */
                    htmlUseYn.setValue("Y");   /** column HTML 사용여부 : htmlUseYn */
                    bullBordMsgeDelYn.setValue("N");   /** column 삭제 여부 : bullBordMsgeDelYn */
                    notiBgnnDt.setValue("");   /** column 공지 시작일 : notiBgnnDt */
                    notiEndDt.setValue("");   /** column 공지 종료일 : notiEndDt */
                    ppgPernNm.setValue(MSFMainApp.get().getUser().getUsrNm());
                }
                
            }
        });
    }
 
    public boolean isValid() {
        boolean result = true;
        if (!bullBordMsgeTtl.isValid()) {
            bullBordMsgeTtl.focus();
            result = false;
        }
        if (!wrtnSecrNum.isValid()) {
            wrtnSecrNum.focus();
            result = false;
        }
        if (bullBordMsgeCtnt.getValue() != null && !bullBordMsgeCtnt.isValid()) {
            bullBordMsgeCtnt.focus();
            result = false;
        }
        
        return result;
    }
   
    public void save() { 
       
        if (!actionDatabase.name().equalsIgnoreCase("READ")) { 
            boardSave();
        } else {
            Window.alert("업데이트 권한이 없습니다.");
        } 
        
    }
    
    
    private void boardSave() {
      
      if (isValid()) {
         
        Bord0300DTO bord0300Dto = new Bord0300DTO();
           
        
        bord0300Dto.setSysDivCd(sysDivCd.getValue());    /** column 시스템구분코드 : sysDivCd */
        bord0300Dto.setBullBordMsgeSeilNum(Long.parseLong(bullBordMsgeSeilNum.getValue()));    /** column 게시글일련번호 : bullBordMsgeSeilNum */
        bord0300Dto.setBullBordUid(bullBordUid.getValue());    /** column 게시판_UID : bullBordUid */
        bord0300Dto.setBullBordGrpId(Long.parseLong(bullBordGrpId.getValue()));    /** column 게시판그룹ID : bullBordGrpId */
        bord0300Dto.setTplvlWrtnInfo(Long.parseLong(tplvlWrtnInfo.getValue()));    /** column 최상위 글 정보 : tplvlWrtnInfo */
        bord0300Dto.setWrtnAswrStge(Long.parseLong(wrtnAswrStge.getValue()));    /** column 글의 답변단계 : wrtnAswrStge */
        bord0300Dto.setWrtnRgstnOrd(Long.parseLong(wrtnRgstnOrd.getValue()));    /** column 글의 등록된 순서 : wrtnRgstnOrd */
        bord0300Dto.setAswrWrtnNum(Long.parseLong(aswrWrtnNum.getValue()));    /** column 답변하는 글의 번호 : aswrWrtnNum */
        bord0300Dto.setPpgPernNm(ppgPernNm.getValue());    /** column 작성자 이름 : ppgPernNm */
        bord0300Dto.setUsrId(usrId.getValue());    /** column 사용자 아이디 : usrId */
        bord0300Dto.setBullBordMsgeTtl(bullBordMsgeTtl.getValue());    /** column 제목 : bullBordMsgeTtl */
        bord0300Dto.setBullBordMsgeCtnt(bullBordMsgeCtnt.getValue());    /** column 내용 : bullBordMsgeCtnt */
        bord0300Dto.setWrtnSecrNum(wrtnSecrNum.getValue());    /** column 글 비밀번호 : wrtnSecrNum */
        bord0300Dto.setPpgPernEmail(ppgPernEmail.getValue());    /** column 작성자 메일 : ppgPernEmail */
        bord0300Dto.setInqyNum(Long.parseLong(inqyNum.getValue()));    /** column 조회수 : inqyNum */
        bord0300Dto.setHtmlUseYn(MSFSharedUtils.convertStringToBoolean(htmlUseYn.getValue()));    /** column HTML 사용여부 : htmlUseYn */
        bord0300Dto.setBullBordMsgeDelYn(MSFSharedUtils.convertStringToBoolean(bullBordMsgeDelYn.getValue()));    /** column 삭제 여부 : bullBordMsgeDelYn */
        bord0300Dto.setNotiBgnnDt(notiBgnnDt.getValue());    /** column 공지 시작일 : notiBgnnDt */
        bord0300Dto.setNotiEndDt(notiEndDt.getValue());    /** column 공지 종료일 : notiEndDt */
//        bord0300Dto.setKybdr(kybdr.getValue());    /** column 입력자 : kybdr */
//        bord0300Dto.setInptDt(inptDt.getValue());    /** column 입력일자 : inptDt */
//        bord0300Dto.setInptAddr(inptAddr.getValue());    /** column 입력주소 : inptAddr */
//        bord0300Dto.setIsmt(ismt.getValue());    /** column 수정자 : ismt */
//        bord0300Dto.setRevnDt(revnDt.getValue());    /** column 수정일자 : revnDt */
//        bord0300Dto.setRevnAddr(revnAddr.getValue());    /** column 수정주소 : revnAddr */
   
          
          bord0300Service.activityOnBoard0300(bord0300Dto, 
                                  actionDatabase,
                                  new AsyncCallback<Bord0300DTO>() {
              public void onFailure(Throwable caught) {
                  MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
                          MSFMainApp.ADMINMESSAGES.ExceptionMessageService("activityOnBoard0300(" + actionDatabase.name() + ") : " + caught), null);
              }
              public void onSuccess(Bord0300DTO result) {
                  
                  fileUploadData(result) ; 
                  
              } 
          });
      }
    }

    public void clean() {
         this.clear();
    }

    public void recharge(){
         caller.reload();
    }

    @Override
    public void onSuccessSave() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void onFailureSave() {
        // TODO Auto-generated method stub

    }

    public void restoreValues() {
        
    }

}
