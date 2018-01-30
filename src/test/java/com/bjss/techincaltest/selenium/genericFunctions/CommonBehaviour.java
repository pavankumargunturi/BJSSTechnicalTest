package com.bjss.techincaltest.selenium.genericFunctions;

import com.bjss.techincaltest.selenium.objectRepository.LoginPage;

import java.io.IOException;

public class CommonBehaviour extends SeleniumCommands {

    static LoadConfigProperties config = new LoadConfigProperties();

    private static final String MAIL_SMTP_PORT = "mail.smtp.port";
    private static final String MAIL_SMTP_HOST = "mail.smtp.host";
    private static final String MAILHOST_Bjss_NET = "mailhost.bjss.net";
    private static final String MAIL_SMTP_AUTH = "mail.smtp.auth";
    private static final String FALSE = "false";
    private static final String MAIL_DEBUG = "mail.debug";
    private static final String MAIL_SMTP_PORT_25 = "25";
    private static final String MAIL_SMTP_SOCKETFACTORY_PORT = "mail.smtp.socketFactory.port";


    //LOGIN
    public static void login() throws IOException {
        waitForVisibilityOfElement(30,LoginPage.emailAddress,"emailAdress");
        sendText(LoginPage.emailAddress,config.loadConfig("loginUserName"),"UserName");
        sendText(LoginPage.password,config.loadConfig("password"),"Password");
        click(LoginPage.loginButton,"Login Button");
    }

}
