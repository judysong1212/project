/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.app.smrmf.core.msfmainapp.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.admin.dto.ElementoMenu;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100DTO;
import com.app.smrmf.core.msfmainapp.client.constants.Constants;
import com.app.smrmf.core.msfmainapp.client.def.ClientSession;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.form.Page;
import com.app.smrmf.core.msfmainapp.client.form.WindowFactory;
import com.app.smrmf.core.msfmainapp.client.languages.AdminConstants;
import com.app.smrmf.core.msfmainapp.client.languages.AdminMessages;
import com.app.smrmf.core.msfmainapp.client.languages.AppConstants;
import com.app.smrmf.core.msfmainapp.client.languages.AppMessages;
import com.app.smrmf.core.msfmainapp.client.languages.MSFConstants;
import com.app.smrmf.core.msfmainapp.client.languages.MSFMessages;
import com.app.smrmf.core.msfmainapp.client.login.Login;
import com.app.smrmf.core.msfmainapp.client.login.LoginListenerAdapter;
import com.app.smrmf.core.msfmainapp.client.login.LoginPage;
import com.app.smrmf.core.msfmainapp.client.login.ToolbarApp;
import com.app.smrmf.core.msfmainapp.client.model.model.Category;
import com.app.smrmf.core.msfmainapp.client.model.model.Entry;
import com.app.smrmf.core.msfmainapp.client.model.model.MSFMainAppModel;
import com.app.smrmf.core.msfmainapp.client.mvc.AppController;
import com.app.smrmf.core.msfmainapp.client.mvc.AppView;
import com.app.smrmf.core.msfmainapp.client.mvc.ContentController;
import com.app.smrmf.core.msfmainapp.client.mvc.MainController;
import com.app.smrmf.core.msfmainapp.client.mvc.NavigationController;
import com.app.smrmf.core.msfmainapp.client.mvc.NavigationView.NavigationType;
import com.app.smrmf.core.msfmainapp.client.service.system.InitSysService;
import com.app.smrmf.core.msfmainapp.client.service.system.InitSysServiceAsync;
import com.app.smrmf.core.msfmainapp.client.service.system.LoginService;
import com.app.smrmf.core.msfmainapp.client.service.system.LoginServiceAsync;
import com.app.smrmf.core.msfmainapp.client.service.system.MenuService;
import com.app.smrmf.core.msfmainapp.client.service.system.MenuServiceAsync;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.core.resources.client.icons.ApplicazioneIcons;
import com.app.smrmf.core.resources.client.icons.CustomIcons;
import com.app.smrmf.core.resources.client.images.ApplicazioneImages;
import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.mvc.AppEvent;
import com.extjs.gxt.ui.client.mvc.Dispatcher;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.HorizontalPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Viewport;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.UrlBuilder;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MSFMainApp {
	 
	    public  static final String              ATTR_NAME           = "name";
	    public  static final String              ATTR_ID             = "id";
	    public  static final String              ATTR_IMAGE          = "image";
	    public  static final String              ATTR_ICON           = "icon";
	    public  static final String              ATTR_UPID           = "upid";
	    
	    public  static final String              ATTR_PAGE           = "page";
	    public  static final String              ATTR_WINDOW         = "window";
	    public  static final String              ATTR_WINDOW_FACTORY = "window-factory";
	    public  static final String              ENTRY_MENU_NAME     = "menuMSFMainApp";

	    public static final String[][] LANGUAGES = {
	        new String[]{"ko","KOREA"} 
	        ,new String[]{"ko","KOREA"} 
	    };

	    public  static final String              MENU           = "메뉴";
	    public  static final String              MODEL          = "model";
	    public  static final String              ENTRIES        = "entries";
	    public  static final ApplicazioneIcons   ICONS          = GWT.create(ApplicazioneIcons.class);
	    public  static final CustomIcons         CUSTOM_ICONS   = GWT.create(CustomIcons.class);
	    public  static final ApplicazioneImages  IMAGES         = GWT.create(ApplicazioneImages.class);
	    public  static final MSFMessages         MSFMESSAGES    = (MSFMessages) GWT.create(MSFMessages.class);
	    public  static final MSFConstants        MSFCONSTANTS   = (MSFConstants) GWT.create(MSFConstants.class);
	    public  static final AdminConstants      ADMINCONSTANTS = (AdminConstants) GWT.create(AdminConstants.class);
	    public  static final AdminMessages       ADMINMESSAGES  = (AdminMessages) GWT.create(AdminMessages.class);
	    public  static final AppConstants        APPCONSTANTS   = (AppConstants) GWT.create(AppConstants.class);
	    public  static final AppMessages         APPMESSAGES    = (AppMessages) GWT.create(AppMessages.class);
	    public  static final Constants			 CONSTANTS      = (Constants) GWT.create(Constants.class);
	    
	    public  static final String              DATABLOCK     = "datablocco";
	    public  static final String              USERLOCK   = "utenteblocco";
	    
	    protected static LoginServiceAsync       loginService   = LoginService.Util.getInstance(); 
	    protected static MenuServiceAsync        menuService    = MenuService.Util.getInstance();
	    protected static InitSysServiceAsync     initSysService    = InitSysService.Util.getInstance();
	    private static Viewport                  viewport;
	    private static Dispatcher                dispatcher;
	    private static MSFMainAppModel           model; 

	    private static AppController             appController;
	    private static NavigationController      navigationController;
	    private static ContentController         contentController;
	    private static MainController            mainController;
	    //TO 메뉴관련 설정을 하는 부분 NavigationType.TREE;
	    private static NavigationType            navigationType = NavigationType.ACCORDING;
	    protected static List<Category>          baseTreeModel  = new ArrayList<Category>();
	    protected static List<Entry>             entries        = new ArrayList<Entry>();
	    protected static List<Category>          categories     = new ArrayList<Category>();
	    private static MSFSysm0100BM                  user;
	    
	    //private static HashMap<String, Object> mapPanelApplication;
	    private static El                        element;
	    private static ClientSession             clientSession;
	    public  static String                    appl           = MSFMainApp.APPCONSTANTS.CodeApp();
	    private static LayoutContainer           customLayoutContent;

	    private HashMap<String, String>   serverMsgs;
	    protected String cookiePath;

	    /**
	     * Singleton instance of main application.
	     */
	    protected static MSFMainApp instance;

	    public MSFMainApp(){
	    }

	    /**
	     * Returns the singleton instance.
	     * 
	     * @return the EdpCore
	     */
	    public static MSFMainApp get() {
	        if ( instance==null ) {
	            instance = new MSFMainApp();
	            setCustomLayoutContent(null);
	        }
	        return instance;
	    }

	    public void startApplication() { 
	        GXT.hideLoadingPanel("loading"); 
	        //sso연동 및 아닌경우 처리를 위해 선언된 부분  
	       // if (Constants.SSO_USE_TYPE.equals(MSFMainApp.getMsg("PayGen.SsoUseType"))) {
	       // 	checkWithServerIfSSOSessionIdIsStillLegal();
	        //} else {
	        	checkWithServerIfSessionIdIsStillLegal();
	        //} 
	    }


	    public void displayApplication() {
	        if (!GWT.isScript()) {
	            GWT.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
	                public void onUncaughtException(Throwable e) {
	                    e.printStackTrace();
	                }
	            });
	        }
	        appController        = new AppController();
	        navigationController = new NavigationController(); 
	        contentController    = new ContentController();  
	        mainController        = new MainController();

	        model = new MSFMainAppModel();
	        Registry.register(MODEL, model);
	        entries.add(model.getEntryMenu());

	        dispatcher = Dispatcher.get();
	        dispatcher.getControllers().clear(); // Modified by Carlo 08/08/2011
	        dispatcher.addController(appController);
	        dispatcher.addController(navigationController);
	        dispatcher.addController(contentController);
	        dispatcher.addController(mainController);
	        dispatcher.dispatch(AppEvents.Init);

	        //Load main page. In case URL contains an entry ID, try to load also that entry
	        String hash = Window.Location.getHash();
	        //        Entry entry = model.findEntry(MSFMainApp.MENU);
	        Entry entry = findEntry(MSFMainApp.ENTRY_MENU_NAME);
	        showPage(entry);
	        if ( MSFSharedUtils.paramNotNull(hash) ) {
	            hash = hash.substring(1);
	            callEntry(hash,null);
	        }

	        unmaskMainPage();
	        viewport = Registry.get(AppView.VIEWPORT);
	        viewport.layout(true);
	    }
	    public static void showPage(Entry entry){
	        showPage(entry,null,null,null);   
	    }
	    
	    public static void showPage(Entry entry, Object idKey, String dataBlocco, String utenteBlocco) {
	        AppEvent appEvent = new AppEvent(AppEvents.ShowPage);
	        appEvent.setData("entry",entry);
	        appEvent.setData("idKey", entry +"_"+idKey);
	        appEvent.setData(DATABLOCK,dataBlocco);
	        appEvent.setData(USERLOCK,utenteBlocco);
	        appEvent.setHistoryEvent(true);
	        appEvent.setToken(entry.getId());
	        Dispatcher.forwardEvent(appEvent);
	    }

	    public static void removePage(Entry entry, Object idKey) {
	        AppEvent appEvent = new AppEvent(AppEvents.RemovePage);
	        appEvent.setData("entry",entry);
	        appEvent.setData("idKey", entry +"_"+idKey);
	        Dispatcher.forwardEvent(appEvent);
	    }

	    public static String getMsg(String key) {
	        return get().getServerMessage(key);
	    }

	    protected void displayLoginBox(){

	        final LoginPage login = new LoginPage(
	                APPCONSTANTS.MsgBenvenuto(), 
	                APPMESSAGES.TitoloApp(), 
	                APPMESSAGES.DescriptionApp());

	        login.addLoginListener(new LoginListenerAdapter(){
	            public void handleLoginEvent(String utente, String password, final boolean seRicorda) {
	                checkLogin(utente, password, seRicorda, null);
	            }
	        });

	        unmaskMainPage();
	        RootPanel.get().clear();
	        RootPanel.get().add(login);
	    }

	    public void checkLogin(String utente, String password, final boolean seRicorda, final Login loginContainer){
	        maskMainPage(MSFMainApp.ADMINMESSAGES.LoginDots()); 
	        final String locale = GWTUtils.getLocale();
	        loginService.checkUsr(utente, password, locale, new AsyncCallback<MSFSysm0100DTO>(){
	            public void onFailure(Throwable caught) {
	                unmaskMainPage();
	                ShowMessageBM smForm = new ShowMessageBM();
	                GWTUtils.messageExcepDlgEx(caught,smForm);
	                //MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	                  //      MSFMainApp.ADMINMESSAGES.ExceptionMessageService("checkUsr(): "+caught), null);
	            }

	            public void onSuccess(MSFSysm0100DTO result) {
	                MSFSysm0100BM user = result.getMsfSysm0100();
	                String sessionID = result.getError();
	                if (user == null) {
	                    unmaskMainPage();   
	                    if (MSFSharedUtils.paramNotNull(result.getMsgBmLogin()) && MSFSharedUtils.paramNotNull(result.getMsgBmLogin().getMessage())) { 
	                        
	                    	GWTUtils.messageExcepDlg(result.getMsgBmLogin());
	                    } else {  
	                        String msg = (String) getHashMapError().get(result.getDescriptionError());
	                        MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(),msg, null);
	                        //if ( loginContainer==null ) {
	                        //    MSFMainApp.this.displayLoginBox();
	                        //}
	                    }   
	                } else {
	                    final long DURATION = 1000 * 60 * 60 * 24 * 7; //duration remembering login. 1 week in this example.
	                    Date expires = new Date(System.currentTimeMillis() + DURATION);
	                    String ricordaValue = (seRicorda?"true":"false");
	                    Cookies.setCookie("sid"+appl, sessionID,          expires, null, cookiePath, false);
	                    Cookies.setCookie("usr"+appl, user.getUsrId(), expires, null, cookiePath, false);
	                    Cookies.setCookie("pwd"+appl, user.getPwd(), expires, null, cookiePath, false);
	                    Cookies.setCookie("seRicorda"+appl, ricordaValue, expires, null, cookiePath, false);
	                    MSFMainApp.get().setUser(user);
	                    MSFMainApp.getMsg("FAKE_LOAD_MESSAGES");
	                    if ( loginContainer!=null ) {
	                        unmaskMainPage();
	                        loginContainer.hide();
	                    } else {
	                        MSFMainApp.get().paygenInitialization();
	                    }
	                }
	            }
	        });
	    }  
	      
	    /**
	     * 
	     * <pre>
	     * 1. 개요 : sso 연동 데이타가 넘어오는 경우 처리 루틴 
	     * 2. 처리내용 : 
	     * </pre>
	     * @Method Name : checkWithServerIfSSOSessionIdIsStillLegal
	     * @date : Dec 21, 2015
	     * @author : leeheuisung
	     * @history : 
	     *	-----------------------------------------------------------------------
	     *	변경일				작성자						변경내용  
	     *	----------- ------------------- ---------------------------------------
	     *	Dec 21, 2015		leeheuisung				최초 작성 
	     *	-----------------------------------------------------------------------
	     *
	     */
	    private void checkWithServerIfSSOSessionIdIsStillLegal(){ 
	    	 
	    	loginService.checkSSOSession(new AsyncCallback<MSFSysm0100DTO>(){
	            public void onFailure(Throwable caught) {
	                unmaskMainPage(); 
	                MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("checkSSOUsr(): "+caught), null);
                     
	            }
	            public void onSuccess(MSFSysm0100DTO result) {
	                user = result.getMsfSysm0100();
	                
	                if (user != null && user.getUsrId() != null && !user.getUsrId().equals("")) { 
	                	//String dpobCd,String sysDivCd,String userId,
	                	 MSFMainApp.getMsg("FAKE_LOAD_MESSAGES"); 
	                     if ("SSOX".equals(user.getSsoUseType())) { 
	                    	 checkSSOLogin(user.getDpobCd(),user.getSysDivCd(),user.getUsrId() ,true, null); 
	                	  } else { 	
	                		  MSFMainApp.get().displayLoginBox();
		                  }  
	               
	                } else { 
	//                	checkWithServerIfSessionIdIsStillLegal();
	                	   if (   Cookies.getCookie("seRicorda"+appl)!=null
		                            && Cookies.getCookie("seRicorda"+appl).equals("true")
		                            && Cookies.getCookie("pwd"+appl)!=null 
		                            && Cookies.getCookie("usr"+appl)!=null
		                    ) {
		                        checkLogin(Cookies.getCookie("usr"+appl), Cookies.getCookie("pwd"+appl), true, null);
		                    } else {
		                        MSFMainApp.get().displayLoginBox();
		                    } 
	                }
	            }
	        });
	    }
	
	 public void checkSSOLogin(String dpobCd,String sysDivCd,String userId,  final boolean seRicorda, final Login loginContainer){
	        maskMainPage(MSFMainApp.ADMINMESSAGES.LoginDots()); 
	        final String locale = GWTUtils.getLocale();
	        
	        try {
		
	        	loginService.checkSSOUsr(dpobCd,sysDivCd, userId, locale, new AsyncCallback<MSFSysm0100DTO>(){
			            public void onFailure(Throwable caught) {
			                unmaskMainPage();
			                MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
			                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("checkSSOUsr(): "+caught), null);
			            }
		
			            public void onSuccess(MSFSysm0100DTO result) {
			                MSFSysm0100BM user = result.getMsfSysm0100();
			                String sessionID = result.getError();
			                if (user == null) {
			                    unmaskMainPage(); 
			                    String msg = (String) getHashMapError().get(result.getDescriptionError());
			                    MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(),msg, null);
			                  
			                   loginService.clearSession(new AsyncCallback<Void>(){
		                          public void onFailure(Throwable caught) {
		                              MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
		                                      MSFMainApp.ADMINMESSAGES.ExceptionMessageService("clearSession(): "+caught), null);
		                              MSFMainApp.get().displayLoginBox();
		                          }
		                          public void onSuccess(Void result) {
		                              MSFMainApp.get().displayLoginBox();
		                          }
		                       });
			                } else {
			                    final long DURATION = 1000 * 60 * 60 * 24 * 7; //duration remembering login. 1 week in this example.
			                    Date expires = new Date(System.currentTimeMillis() + DURATION);
			                    String ricordaValue = (seRicorda?"true":"false");
			                    Cookies.setCookie("sid"+appl, sessionID,          expires, null, cookiePath, false);
			                    Cookies.setCookie("usr"+appl, user.getUsrId(), expires, null, cookiePath, false);
			                    Cookies.setCookie("pwd"+appl, user.getPwd(), expires, null, cookiePath, false);
			                    Cookies.setCookie("seRicorda"+appl, ricordaValue, expires, null, cookiePath, false);
			                    MSFMainApp.get().setUser(user);
			                    MSFMainApp.getMsg("FAKE_LOAD_MESSAGES");
			                    if ( loginContainer!=null ) {
			                        unmaskMainPage();
			                        loginContainer.hide();
			                    } else {
			                        MSFMainApp.get().paygenInitialization();
			                    }
			                }
			            }
			        });
	         } catch (IllegalArgumentException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        
	    } 
	    


	    private void checkWithServerIfSessionIdIsStillLegal(){
	        loginService.checkSession(new AsyncCallback<MSFSysm0100DTO>(){
	            public void onFailure(Throwable caught) { 
	                MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("checkSession(): "+caught), null); 
//	                loginService.clearSession(new AsyncCallback<Void>(){
//	    	            public void onFailure(Throwable caught) {
//	    	                MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
//	    	                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("clearSession(): "+caught), null);
//	    	                MSFMainApp.get().displayLoginBox();
//	    	            }
//	    	            public void onSuccess(Void result) {
//	    	                MSFMainApp.get().displayLoginBox();
//	    	            }
//	    	        });
	                
	            }
	            public void onSuccess(MSFSysm0100DTO result) {
	                user = result.getMsfSysm0100(); 
	               // if (user != null && user.getUsrId() != null && !user.getUsrId().equals("")) { 
	                if (user == null) { 
		               if (   Cookies.getCookie("seRicorda"+appl)!=null
		                            && Cookies.getCookie("seRicorda"+appl).equals("true")
		                            && Cookies.getCookie("pwd"+appl)!=null 
		                            && Cookies.getCookie("usr"+appl)!=null
	                    ) {
	                        checkLogin(Cookies.getCookie("usr"+appl), Cookies.getCookie("pwd"+appl), true, null);
	                    } else { 
	                        MSFMainApp.get().displayLoginBox();
	                    	//checkWithServerIfSSOSessionIdIsStillLegal();
	                        
	                    }
		              
	                } else {
	                	 if ("SSOX".equals(user.getSsoUseType())) {
	                		// MSFMainApp.getMsg("FAKE_LOAD_MESSAGES");
			                 checkSSOLogin(user.getDpobCd(),user.getSysDivCd(),user.getUsrId() ,true, null);
		                 
	                	 } else {
			                    MSFMainApp.getMsg("FAKE_LOAD_MESSAGES");
			                    MSFMainApp.get().paygenInitialization();
		                 }       
	                }
	            }
	        });
	    }


	    public void logout(){
	        Cookies.removeCookie("sid"+appl);
	        Cookies.removeCookie("seRicorda"+appl);
	        Cookies.removeCookie("usr"+appl);
	        Cookies.removeCookie("pwd"+appl);
	        Registry.unregisterAll();
	        Registry.unregister(MODEL);
	        dispatcher.removeAllListeners();
	        dispatcher.removeController(appController);
	        dispatcher.removeController(navigationController);
	        dispatcher.removeController(contentController);
	        loginService.clearSession(new AsyncCallback<Void>(){
	            public void onFailure(Throwable caught) {
	                MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("clearSession(): "+caught), null);
	                MSFMainApp.get().displayLoginBox();
	            }
	            public void onSuccess(Void result) {
	                MSFMainApp.get().displayLoginBox();
	            }
	        });

	    }
       
	    
	    /**
	     * 공통설정 불러오기 루틴 
	     */
	    protected void paygenInitialization() {  
	    	//초기화 메시지 
	    	maskMainPage(MSFMESSAGES.PayGenApplication()); 
	    	
	    	initSysService.getInitialization(new AsyncCallback<String>(){
	            public void onFailure(Throwable caught) {
	                unmaskMainPage();
	                MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("getInitialization(): "+caught), null);
	            }

	            public void onSuccess(String result) { 
	                        if (!MSFSharedUtils.isNullAsString(result)) {
	                            if (result.equals("200")) {
	                            	 MSFMainApp.get().readMenu();
	                            } else {
	                            	 MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	             	                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("paygenInitialization(): "+"공통코드 초기화 오류!!"), null);
	                            	 logout(); 
	                            }
	                        }
	                    } 
	        });

	    }
	    /**
	     * 메뉴을 읽어 온다.
	     */
	    protected void readMenu() {
	        clearAppMenu();
	        menuService.getMenu(new AsyncCallback<List<ElementoMenu>>(){
	            public void onFailure(Throwable caught) {
	                unmaskMainPage();
	                MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	                        MSFMainApp.ADMINMESSAGES.ExceptionMessageService("getMenu(): "+caught), null);
	            }

	            public void onSuccess(List<ElementoMenu> result) {
	                Iterator<ElementoMenu> iter = result.iterator();
	                Category category = null;
	                entries.clear();
	                categories.clear();
	                Registry.register(ENTRIES, entries);
	               
	                while (iter.hasNext()) {
	                    ElementoMenu elementoMenu = (ElementoMenu) iter.next();
	                    if ( MSFSharedUtils.paramNull(elementoMenu.getMnuScnFrmPkgNm()) ) {
	                    	 
	                        category = new Category(
	                                elementoMenu.getMnuCd(),
	                                elementoMenu.getMnuNm(),
	                                elementoMenu.getMnuIcn(),
	                                elementoMenu.getHhrkMnuCd());
			                        //This is a flat list of all categories we use to search for the parent (if any)
			                        categories.add(category);
	                     
		                        //Look for parent category, if not found add to main menu as first level
		                        Category parent = null;
		                       
	                        for ( int i=0 ; i<categories.size() && parent==null ; i++ ) {
	                            Category item = categories.get(i);
	                           
	                            if ( item!=null && item.get(ATTR_ID)!=null && item.get(ATTR_ID).equals(elementoMenu.getHhrkMnuCd()) ) {
	                            	
	                            	parent = item;
	                            }
	                        }
	                        if ( parent!=null ) {
	                            addMenuCategory(category, parent);
	                        } else {
	                            addMenuCategory(category, null);
	                        }
	                    } else {
	                        Entry e = new Entry(elementoMenu.getMnuEpln(), // unique name (id Entry) of the menu element ????getName
	                                elementoMenu.getMnuNm(),  elementoMenu.getHhrkMnuCd(), 
	                                WindowFactory.get(elementoMenu),
	                                getHTMLThumbnail(elementoMenu.getMnuTmbl()),
	                                elementoMenu.getMnuIcn(),
	                                true);
	                        //This is a flat list of all entries we use to activate the screens
	                        entries.add(e);
	                        if (!MSFSharedUtils.isNullAsString(elementoMenu.getMnuIcn())) {
	                            if (category.get(ATTR_ID)!=null && category.get(ATTR_ID).equals(elementoMenu.getHhrkMnuCd())) {
	                                category.add(e);
	                            } else {
	                                Category parent = null;
	                                for ( int i=0 ; i<categories.size() && parent==null ; i++ ) {
	                                    Category item = categories.get(i);
	                                    if ( item!=null && item.get(ATTR_ID)!=null && item.get(ATTR_ID).equals(elementoMenu.getHhrkMnuCd()) ) {
	                                        parent = item;
	                                    }
	                                }  
	                                parent.add(e); 
	                            }
	                        }
	                    }
	                }
	                MSFMainApp.get().displayApplication();
	            }
	        });

	    }

	    private String getServerMessage(String key) {
	        if ( serverMsgs==null ) {
	            loginService.getServerMessages(new AsyncCallback<HashMap<String,String>>() {
	                public void onFailure(Throwable caught) {
	                    MessageBox.alert(MSFMainApp.MSFCONSTANTS.ExceptionTitleService(), 
	                            MSFMainApp.ADMINMESSAGES.ExceptionMessageService("getServerMessages(): "+caught), null);
	                }
	                public void onSuccess(HashMap<String, String> result) {
	                    serverMsgs = result;
	                }
	            });
	        }
	        String msg = null;
	        if ( serverMsgs!=null ) {
	            msg = serverMsgs.get(key);
	        } else {
	            msg = "NOT_FOUND_"+key;
	        }
	        return msg;
	    }

	    protected String getHTMLThumbnail(String img){
	        if (MSFSharedUtils.isNullAsString(img)) {
	            return null;
	        } else if ("default.gif".equals(img)) {
	            return MSFMainApp.IMAGES.accordionlayout().getHTML();
	        } else {
	           // Image thumb = new Image("resources/images/thumbs/"+img); 
	           // thumb.setSize("120px", "90px");
	           // return thumb.toString();
	            return null;
	        }
	    }

	    //    public static void setMapPanelApplication(HashMap<String, Object> mapPanelApplication) {
	    //        MSFMainApp.mapPanelApplication = mapPanelApplication;
	    //    }
	    //
	    //    public static HashMap<String, Object> getMapPanelApplication() {
	    //        return mapPanelApplication;
	    //    }

	    protected HashMap<String, String> getHashMapError() {
	        HashMap<String, String> map = new HashMap<String, String>();
	        map.put("PassWordErrata", MSFMainApp.MSFCONSTANTS.PassWordErrata());
	        map.put("UserNonEsiste",MSFMainApp.MSFCONSTANTS.UserNonEsiste());
	        map.put("ErroreGenerico", MSFMainApp.MSFCONSTANTS.ErroreGenerico());
	        return map;
	    }

	    public List<Category> getAppMenu() {
	        return baseTreeModel;
	    }

	    public void setAppMenu(List<Category> modelMenu) {
	        MSFMainApp.baseTreeModel =  modelMenu;
	    }

	    public void addMenuCategory(Category category, Category parent) {
	        if ( parent==null ) {
	            MSFMainApp.baseTreeModel.add(category);
	        } else {
	            parent.add(category);
	        }
	    }

	    public void clearAppMenu() {
	        MSFMainApp.baseTreeModel.clear();
	    }

	    public MSFSysm0100BM getUser() {
	        return user;
	    }

	    public void setUser(MSFSysm0100BM user) {
	        MSFMainApp.user = user;
	    }

	    public static List<Entry> getEntries() {
	        return entries;
	    }

	    public ToolBar getToolbar(){
	        Object obj = viewport.getItemByItemId("toolbarPanel");
	        if (obj instanceof ContentPanel) {
	            ContentPanel panel = (ContentPanel)obj;
	            Object objToolbar = panel.getItem(0);
	            if (objToolbar instanceof ToolbarApp) {
	                return (ToolbarApp)objToolbar;
	            }
	        }
	        return null;
	    }

	    public HorizontalPanel getFlagsTable() {
	        HorizontalPanel flagsTable = new HorizontalPanel();
	        String shownLanguages = MSFSharedUtils.allowNulls(MSFMainApp.APPCONSTANTS.ShownLanguages()).trim();
	        if ( shownLanguages.indexOf(",") > 0 ) {
	            flagsTable.add(new HTML("<img src='images/spacer.gif' border='0' width='5'>"));
	            for ( int i=0 ; i<MSFMainApp.LANGUAGES.length ; i++ ) {
	                final String langCode = MSFMainApp.LANGUAGES[i][0];
	                final String langDesc = MSFMainApp.LANGUAGES[i][1];
	                if ( shownLanguages.indexOf(langCode)>=0 ) {
	                    HTML flag = new HTML("<a href='#'><img src='images/flag_"+langCode+".jpg' border='0'></a>");
	                    flagsTable.add(flag);
	                    flagsTable.add(new HTML("<img src='images/spacer.gif' border='0' width='5'>"));
	                    flag.setTitle(langDesc);
	                    flag.addClickHandler(new ClickHandler() {
	                        public void onClick(ClickEvent event) {
	                            UrlBuilder builder = Location.createUrlBuilder().setParameter(MSFConfiguration.REQ_ATTR_LOCALE, langCode);
	                            Window.Location.replace(builder.buildString());
	                        }
	                    });
	                }
	            }
	        }
	        return flagsTable;
	    }

	    /**
	     * Returns the client session 
	     * @return ClientSession object
	     */
	    public static ClientSession getClientSession(){
	        if (clientSession == null) {
	            clientSession = new ClientSession();
	        }
	        return clientSession;
	    }

	    public static Entry findEntry(String id) {
	        //        if (get(name) != null) {
	        //            return (Entry) get(name);
	        //        }
	        for (Entry entry : getEntries()) {
	            if (id.equals(entry.getId())) {
	                return entry;
	            }
	        }
	        return null;
	    }

	    /**
	     * Finds and shows a Entry with the specified <i>id</i>
	     * @param id
	     */
	    public static void callEntry(String id) {
	        callEntry(id,null);
	    }
	    
	    public static void callEntry(String id,Object idKey) {
	        callEntry(id,idKey,null);

	    }
	            
	    public static void callEntry(String id,Object idKey, String statoProcedura) {
	        if (!ENTRY_MENU_NAME.equals(id)) {
	            
	            //            Entry entry = model.findEntry(id);
	            Entry entry = findEntry(id);
	            if (entry != null) {
	                String dataBlocco = null;
	                String utenteBlocco = null;
	                if (statoProcedura != null){
	                    String[] vector = statoProcedura.split("\\$");      
	                    String userId = vector[2] ;
	                    if (!MSFMainApp.get().getUser().getUsrId().equals(userId)){
	                        dataBlocco = vector[1];     //데이타블럭  data Block
	                        utenteBlocco = vector[4];   //차단된사용자  Blocked user
	                    }
	                }                
	                Page page = entry.get(MSFMainApp.ATTR_PAGE);
	                if (page == null) {
	                    showPage(entry,idKey,dataBlocco,utenteBlocco);
	                } else {
	                    Entry clonedEntry = entry.clone();
	                    showPage(clonedEntry,idKey,dataBlocco,utenteBlocco);
	                }
	            } else {
	                MessageBox.alert(MSFCONSTANTS.Alert(), MSFMESSAGES.NoEntry(id), null);
	            }
	        }
	    }

	    public static void removeEntry(String id) {
	        removeEntry(id,null);
	    }
	    
	    public static void removeEntry(String id,Object idKey) {
	        if (!ENTRY_MENU_NAME.equals(id)) {
	            Entry entry = findEntry(id);
	            if (entry != null) {
	                removePage(entry,idKey);
	            }
	        } else {
	            MessageBox.alert(MSFCONSTANTS.Alert(), MSFMESSAGES.NoEntry(id), null);
	        }
	    }
	    
	    public static void setNavigationType(NavigationType nt) {
	        navigationType = nt;
	    }

	    public static NavigationType getNavigationType() {
	        return navigationType;
	    }

	    public static void setCustomLayoutContent(LayoutContainer customLayoutContent) {
	        MSFMainApp.customLayoutContent = customLayoutContent;
	    }

	    public static LayoutContainer getCustomLayoutContent() {
	        return customLayoutContent;
	    }

	    public static void maskMainPage(String msg) {
	        if ( element==null ) {
	            element = new El(RootPanel.get().getElement());
	        }
	        element.mask(msg);
	    }

	    public static void unmaskMainPage() {
	        if ( element!=null ) {
	            element.unmask();
	        }
	    }

	   
}
