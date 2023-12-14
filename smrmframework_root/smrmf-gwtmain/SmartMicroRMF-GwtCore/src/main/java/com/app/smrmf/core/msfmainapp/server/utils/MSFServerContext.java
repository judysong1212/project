/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.server.utils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFUserExpiredException;

public class MSFServerContext {

    private static final Logger logger = LoggerFactory.getLogger(MSFServerContext.class);

    public static void initUserInfo(HttpServletRequest req, HttpServletResponse res, ServletContext context, ServletConfig config) {
        try {
            MSFUserInfoManager.setUserInfo(req, res, context, config, MSFServerUtils.getLoggedUser(req));
        } catch (Throwable t) {
            logger.error("EXCEPTION storing user info in ThreadLocal:"+t, t);
        }
    }

    public static String getLocalizedMessage(String key, String defaultValue) {
        String msg = defaultValue;
        try {
            MSFUserInfo userInfo = MSFUserInfoManager.getUserInfo();
            msg = MSFServerUtils.getLocalizedMessage(userInfo.getServletConfig(), userInfo.getHttpServletRequest(), key, defaultValue);
        } catch (Throwable t) {
            logger.debug("EXCEPTION in getLocalizedMessage()", t);
        }
        return msg;
    }

    public static MSFSysm0100BM getLoggedUser() throws MSFUserExpiredException {
        try {
            MSFUserInfo userInfo = MSFUserInfoManager.getUserInfo();
            MSFSysm0100BM user = MSFServerUtils.getLoggedUser(userInfo.getHttpServletRequest());
            return user;
        } catch (Throwable t) {
            throw MSFServerUtils.getOperationException("MSFServerContext.getLoggedUser", t, logger);
        }
    }

    public static HttpSession getHttpSession() {
        MSFUserInfo userInfo = MSFUserInfoManager.getUserInfo();
        HttpSession session = userInfo.getHttpServletRequest().getSession();
        return session;
    }

    public static MSFUserInfo getUserInfo() {
        MSFUserInfo userInfo = MSFUserInfoManager.getUserInfo();
        return userInfo;
    }

}
