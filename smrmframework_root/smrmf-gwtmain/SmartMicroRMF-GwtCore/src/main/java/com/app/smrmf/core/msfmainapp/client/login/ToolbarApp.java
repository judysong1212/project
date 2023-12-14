/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.login;

import com.app.smrmf.core.msfmainapp.client.AppEvents;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.MenuEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.widget.Status;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;



public class ToolbarApp extends ToolBar {

    private Status userName;
    private final Button toolbarButton; 	
    public ToolbarApp() { 
        userName = new Status();
        add(userName);
        add(new SeparatorToolItem());  
        toolbarButton = new Button(MSFMainApp.MSFCONSTANTS.BtLogOut(),MSFMainApp.ICONS.powerOff());
        add(toolbarButton);
        toolbarButton.addSelectionListener(new SelectionListener<ButtonEvent>(){
            public void componentSelected(ButtonEvent ce) { 
            	 Dispatcher.forwardEvent(AppEvents.LogOut);	
            }
        });
//        toolbarButton.addListener(Events.OnClick,new Listener<ButtonEvent>() {
//            public void handleEvent(ButtonEvent be)	{
//                Dispatcher.forwardEvent(AppEvents.LogOut);	  
//            }
//        });			
        add(new SeparatorToolItem());  
        final Button refreshButton = new Button();
        refreshButton.setText(null);
        refreshButton.setTitle(MSFMainApp.ADMINCONSTANTS.MenuRefresh());
        add(refreshButton);
        refreshButton.setIcon(MSFMainApp.ICONS.actionRefresh());
        refreshButton.addSelectionListener(new SelectionListener<ButtonEvent>(){
            public void componentSelected(ButtonEvent ce) {
                GWTUtils.reload();
            }
        });
        add(new SeparatorToolItem()); 
        final Button helpButton = new Button("도움말",MSFMainApp.ICONS.help16());
       // helpButton.setText();
        //helpButton.setTitle("도움말");
        add(helpButton);
       // helpButton.setIcon(MSFMainApp.ICONS.help16());
        helpButton.addSelectionListener(new SelectionListener<ButtonEvent>(){
            public void componentSelected(ButtonEvent ce) { 
                String urlName = "webHelp/index.htm"; 
//                if (!GWT.isScript()) {
//                    urlName = "../../" + urlName;
//                }
                GWTUtils.runHelp(urlName);
            }
        });
        
        add(new SeparatorToolItem()); 
        add(new FillToolItem());  

        //Flags for language switch - TODO 랭귀지 설정부....
//        HorizontalPanel flagsTable = MSFMainApp.get().getFlagsTable();
//        add(flagsTable);

        //Settings menu -TODO 옵션설정부...
        final Button settings = new Button(MSFMainApp.ADMINCONSTANTS.MenuStrumenti());
        settings.setMenu(getMenuSettings());
        settings.setIcon(MSFMainApp.ICONS.settings()); 
        add(settings); 
        //Theme selector
//        changePathTheme();
//        add(new ThemeSelector());
    }

    public void setUsername(String name){
        userName.setHtml("사용자 : "+name+" ");
    }

    public void addSeparatore(){
        this.add(new SeparatorToolItem());
    }

    private Menu getMenuSettings(){
        Menu splitMenu = new Menu();  
        MenuItem ii = new MenuItem(MSFMainApp.MSFCONSTANTS.CambiaPwd());
        ii.setIconStyle("icon_key"); 
        ii.addSelectionListener(new SelectionListener<MenuEvent>(){
            public void componentSelected(MenuEvent ce) {
                ChangePwd changePwd = new ChangePwd();
                changePwd.show();
            }
        });
        splitMenu.add(ii);  

        //사용자정보  
//        ii = new MenuItem(MSFMainApp.ADMINCONSTANTS.MenuModificaUser());  
//        ii.addSelectionListener(new SelectionListener<MenuEvent>(){
//            public void componentSelected(MenuEvent ce) {
//                FormUser formUser = new FormUser();
//                BaseModel userBM = new BaseModel(MSFMainApp.get().getUser().getProperties());
//                formUser.setValues(userBM);
//                formUser.show();
//            }
//        });
//        splitMenu.add(ii);  

        return splitMenu;
    }

//    private void changePathTheme(){
//        Theme t = Theme.GRAY;
//        ThemeManager.unregister(t);
//
//        String file = t.getFile();
//        file = file.replace("gxt/", "resources/");
//        t.set("file", file);
//        ThemeManager.register(t);
//    }
}
