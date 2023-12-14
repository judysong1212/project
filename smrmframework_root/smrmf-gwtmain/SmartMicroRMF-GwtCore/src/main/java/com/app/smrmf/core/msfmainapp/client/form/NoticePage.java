/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.form;

 
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.admin.forms.NoticeBoardForm;
import com.app.smrmf.core.msfmainapp.client.admin.forms.defs.Bord0300ViewDef;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormWindows;
import com.app.smrmf.core.msfmainapp.client.utils.MSFPanel;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;

 
public class NoticePage  extends MSFPanel { 
  
	
	private MSFGridPanel msfBoardGridPanel;
	
	private VerticalPanel vp;
	private String txtForm = "";
    private Button insertButton;
    private Button updateButton;
    private Button deleteButton;
    private BaseModel record;
    private ActionDatabase actionDatabase;
    
	
    public ContentPanel getViewPanel(){
        if(panel == null){
            
           // formData = new FormData("-650");
            vp = new VerticalPanel();
            vp.setSpacing(10);
  
            vp.setSize("1010px", "700px");
                
            ContentPanel cp = new ContentPanel();   
            cp.setBodyBorder(true);   
         //   cp.setIcon(Resources.APP_ICONS.table());   
            cp.setHeadingHtml("공지사항"); //.setHeading( "공지사항" );   
            cp.setButtonAlign(HorizontalAlignment.CENTER);   
            cp.setLayout(new FitLayout());   
            cp.getHeader().setIconAltText("Grid Icon");   
            cp.setSize(1010, 700);   
            
            
            Bord0300ViewDef  bord0300View = new Bord0300ViewDef(); 
            
            bord0300View.addColumnFilter("sysDivCd", MSFMainApp.get().getUser().getSysDivCd(), SimpleColumnFilter.OPERATOR_EQUALS); 
            bord0300View.addColumnFilter("bullBordUid", "paygenapp02", SimpleColumnFilter.OPERATOR_EQUALS); 
            bord0300View.addColumnFilter("bullBordGrpId", "1", SimpleColumnFilter.OPERATOR_EQUALS);  
            // admSysm0100.setReadOnly(true);
            msfBoardGridPanel = new MSFGridPanel(bord0300View, false, false, false,true);  
            msfBoardGridPanel.setHeaderVisible(false);
            msfBoardGridPanel.setBodyBorder(true);
            msfBoardGridPanel.setBorders(true);
            msfBoardGridPanel.setSize(1010, 700);  
            final Grid msfBoardGrid = msfBoardGridPanel.getMsfGrid().getGrid(); 
            msfBoardGrid.addListener(Events.CellClick, new Listener<BaseEvent>() {            
                public void handleEvent(BaseEvent be) {
                    
                    if (msfBoardGridPanel.getCurrentlySelectedItem() != null) { 
                        setRecord(msfBoardGridPanel.getCurrentlySelectedItem());
                    }
                        
                   
                }
            });
            msfBoardGrid.addListener(Events.CellDoubleClick, new Listener<BaseEvent>() {            
                public void handleEvent(BaseEvent be) {
                    
                    if (MSFConfiguration.AUTH_USR_DIV_90.equals(MSFMainApp.get().getUser().getUsrDivCd())) {
                        doAction(ActionDatabase.UPDATE);  
                    } else {
                        doAction(ActionDatabase.READ);  
                    }    
                    
                }
            });
            
 if (MSFConfiguration.AUTH_USR_DIV_90.equals(MSFMainApp.get().getUser().getUsrDivCd())) {
                 
                
                ToolBar bottomToolbar = new ToolBar();  
                bottomToolbar.add(msfBoardGridPanel.getBottomComponent());
                bottomToolbar.add(new FillToolItem());
 
//                Button refresh = new Button(MSFMainApp.MSFCONSTANTS.BtRefresh());
//                refresh.setIcon(MSFMainApp.ICONS.actionRefresh());
//                refresh.addSelectionListener(new SelectionListener<ButtonEvent>() {
//                    public void componentSelected(ButtonEvent ce) {  
//                        msfBoardGridPanel.reload();  
//                    }  
//                });
//                bottomToolbar.add(refresh);

                insertButton = new Button(MSFMainApp.MSFCONSTANTS.BtNuovo());
                insertButton.setIcon(MSFMainApp.ICONS.add());
                insertButton.addSelectionListener(selectionListener);
                bottomToolbar.add(insertButton);

                updateButton = new Button(MSFMainApp.MSFCONSTANTS.BtModification());
                updateButton.setIcon(MSFMainApp.ICONS.edit());
                updateButton.addSelectionListener(selectionListener);
                bottomToolbar.add(updateButton);

                deleteButton = new Button(MSFMainApp.MSFCONSTANTS.BtCancel());
                deleteButton.setIcon(MSFMainApp.ICONS.delete());
                deleteButton.addSelectionListener(selectionListener);
                bottomToolbar.add(deleteButton);

                msfBoardGridPanel.setBottomComponent(bottomToolbar);    
 }
            
            
            
            cp.add(msfBoardGridPanel);  
            
            vp.add(cp);
              
            panel = new ContentPanel();
            panel.setBodyBorder(false);
            panel.setBorders(false);
            panel.setHeaderVisible(false);
            panel.setScrollMode(Scroll.AUTO);  
            panel.add(vp);
            
            
            
        }
        return panel;
    }
/**
*############################################################################# 
* 프로그램 종료        
*############################################################################# 
**/      

/**
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
* 생성자 함수 선언부 시작
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~         
**/    
  /**
   * @wbp.parser.constructor
   */
  public NoticePage() {
       
        setSize("1010px", "700px");  
  } 

  public NoticePage(String txtForm) {
        this.txtForm = txtForm;
  }
/**
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
* 생성자 함수 선언부 종료
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~         
**/    

  private SelectionListener<ButtonEvent> selectionListener = 
      new SelectionListener<ButtonEvent>() {
      public void componentSelected(ButtonEvent ce) { 
          if (ce.getButton() == insertButton) {
              doAction(ActionDatabase.INSERT);
          } else if (ce.getButton() == updateButton) {
              doAction(ActionDatabase.UPDATE);
          } else if (ce.getButton() == deleteButton) {
              doAction(ActionDatabase.DELETE);
          }

      }  
  };

  private void doAction(ActionDatabase actionDatabase) {
      switch (actionDatabase) {
      case INSERT:
          NoticeBoardForm nbForm = new NoticeBoardForm(ActionDatabase.INSERT, getThis());
          MSFFormWindows w = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.BtNew(),nbForm,MSFMainApp.MSFCONSTANTS.BtSave(),MSFMainApp.MSFCONSTANTS.BtDelete());
          w.show(); 
          nbForm.setMSFFormWindows(w);
          nbForm.bind(new BaseModel());
          nbForm.clean();
          break;
      case UPDATE:
          nbForm = new NoticeBoardForm(ActionDatabase.UPDATE, getThis());      
          w = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.BtModification(),nbForm,MSFMainApp.MSFCONSTANTS.BtRefresh(),MSFMainApp.MSFCONSTANTS.BtDelete());
          w.show();
          nbForm.setMSFFormWindows(w);
          nbForm.bind(record);    
          break;
      case DELETE:
          nbForm = new NoticeBoardForm(ActionDatabase.DELETE, getThis());      
          w = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.BtCancel(),nbForm,MSFMainApp.MSFCONSTANTS.BtCancel(),MSFMainApp.MSFCONSTANTS.BtDelete());
          w.show();  
          nbForm.setMSFFormWindows(w);
          nbForm.bind(record);                 
          break;
      case READ:
          nbForm = new NoticeBoardForm(ActionDatabase.READ, getThis());      
          w = new MSFFormWindows(MSFMainApp.MSFCONSTANTS.BtRefresh(),nbForm,MSFMainApp.MSFCONSTANTS.BtRefresh(),MSFMainApp.MSFCONSTANTS.BtDelete());
          w.show();
          nbForm.setMSFFormWindows(w);
          nbForm.bind(record);    
          break;
      }
  }

  private void readNoticeBoard(){
      msfBoardGridPanel.reload();
  }
 
  public String getIntro() {
      return null;
  }

  public void setRecord(BaseModel record) {
      this.record = record;
  }

  @Override
  public void reload() {
      readNoticeBoard();
  }

  private NoticePage getThis(){
      return this;
  }

}
