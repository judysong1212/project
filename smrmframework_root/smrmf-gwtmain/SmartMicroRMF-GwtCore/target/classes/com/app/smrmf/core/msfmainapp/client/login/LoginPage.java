/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.login;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;

public class LoginPage extends Composite implements Login {

    protected LoginForm loginForm;
    protected LoginListener loginListener;

    public LoginPage(
            String msgBenvenuto, 
            String titoloApp, 
            String descriptionApp) {

        super();

        final DockPanel mainTable = new DockPanel();
        initWidget(mainTable);
        mainTable.setSpacing(15);
        mainTable.setSize("100%", "100%");
        mainTable.setStyleName("wrap_login_business");
       
        
//        final HorizontalPanel horizontalPanel = new HorizontalPanel();
//        mainTable.add(horizontalPanel, DockPanel.NORTH);
//        horizontalPanel.setWidth("100%");
//          
//        
//        horizontalPanel.setHeight("100%");
//        horizontalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
//        horizontalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
//         
//        final Image image_1 = new Image();
//        horizontalPanel.add(image_1);
//        image_1.setSize("224px", "63px");
//        image_1.setUrl("images/login_logo_business.png");

//        RoundedPanel r1 = new RoundedPanel();
//        horizontalPanel.add(r1);
//        horizontalPanel.setCellVerticalAlignment(r1, HasVerticalAlignment.ALIGN_MIDDLE);
//        horizontalPanel.setCellWidth(r1, "100%");
//        r1.setCornerColor(Constants.colorDefault);
//        HorizontalPanel s1 = new HorizontalPanel();
//        DOM.setStyleAttribute(s1.getElement(), "backgroundColor", Constants.colorDefault);
//        s1.setSize("100%", "20px");
//        r1.add(s1);
//        s1.setSpacing(5);
//
//        final Label benvenutoNelConfiguratoreLabel = new Label();
//        s1.add(benvenutoNelConfiguratoreLabel);
//        benvenutoNelConfiguratoreLabel.setStyleName("label-bold");
//        benvenutoNelConfiguratoreLabel.setText(msgBenvenuto);
//        benvenutoNelConfiguratoreLabel.setSize("100%", "100%");
//
//        r1.setSize("100%", "20px");
//
//        // END FORM
//
//        RoundedPanel r2 = new RoundedPanel();
//        r2.setSize("100%", "20px");
//        r2.setCornerColor(Constants.colorDefault);
//        HorizontalPanel s2 = new HorizontalPanel();
//        DOM.setStyleAttribute(s2.getElement(), "backgroundColor", Constants.colorDefault);
//        s2.setSize("100%", "20px");
//        r2.add(s2);
//        s2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
//        s2.setSpacing(5);
//
//        final HTML label = new HTML(MSFMainApp.APPCONSTANTS.Copyright());
//        s2.add(label);
//        label.setStyleName("x-form-item label");
// 
//        mainTable.add(r2, DockPanel.SOUTH);
//
        final VerticalPanel verticalPanel_1 = new VerticalPanel();
        mainTable.add(verticalPanel_1, DockPanel.NORTH);
        verticalPanel_1.setSpacing(15);
        mainTable.setCellHeight(verticalPanel_1, "100%");
        mainTable.setCellWidth(verticalPanel_1, "100%");
        verticalPanel_1.setSize("100%", "380px");
        verticalPanel_1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        verticalPanel_1.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
       // verticalPanel_1.setStyleName("login_area_business");
        mainTable.setCellHorizontalAlignment(verticalPanel_1, HasHorizontalAlignment.ALIGN_CENTER);   
        mainTable.setCellVerticalAlignment(verticalPanel_1, HasVerticalAlignment.ALIGN_MIDDLE);
        

//        final Label disegnaSuLabel = new Label();
//        verticalPanel_1.add(disegnaSuLabel);
//        disegnaSuLabel.setStyleName("label-bold");
//        disegnaSuLabel.setText(titoloApp);
//
//        final Label ilConfiguratoreTiLabel = new Label();
//        verticalPanel_1.add(ilConfiguratoreTiLabel);
//        ilConfiguratoreTiLabel.setText(descriptionApp);
//        ilConfiguratoreTiLabel.setStyleName("label-normal");

        final Image image_1 = new Image();
        verticalPanel_1.add(image_1);
        verticalPanel_1.setCellVerticalAlignment(image_1, HasVerticalAlignment.ALIGN_BOTTOM);
       // image_1.setSize("224px", "63px");
        image_1.setUrl("images/login_logo_business.png");
        
        final Image image = new Image();
        verticalPanel_1.add(image);
        verticalPanel_1.setCellVerticalAlignment(image, HasVerticalAlignment.ALIGN_BOTTOM);
        image.setUrl("images/login_subject_business.png");
      //  image.setSize("400", "300");


//        final VerticalPanel contentVP = new VerticalPanel();
//        mainTable.add(contentVP, DockPanel.CENTER); 
//        contentVP.setWidth("400px");
//        contentVP.setSpacing(15);
//        contentVP.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
//        contentVP.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
//        mainTable.setCellHeight(contentVP, "100%");
//        mainTable.setCellWidth(contentVP, "450px");
//        mainTable.setCellHorizontalAlignment(contentVP, HasHorizontalAlignment.ALIGN_CENTER);   //ALIGN_RIGHT
//        mainTable.setCellVerticalAlignment(contentVP, HasVerticalAlignment.ALIGN_MIDDLE);

        // FORM
        loginForm = new LoginForm(this);
        verticalPanel_1.add(loginForm);


        final HTML label = new HTML("Copyright ⓒ <span class='blue_b'>PAYGEN-VER1.0 2015</span> All rights reserved.");
        verticalPanel_1.add(label);
        label.setStyleName("x-form-item label"); 
      //  SimplePanel space = new SimplePanel();
      //  space.setHeight("30px");
      //  verticalPanel_1.add(space);

    }

    public void addLoginListener(LoginListener loginListener) {
        this.loginListener = loginListener;
    }

    public LoginListener getLoginListener() {
        return loginListener;
    }

    public void hide() {
    }

}
