/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.server.vo.system;

// Generated 18-mag-2010 14.14.14 by Hibernate Tools 3.2.5.Beta

import java.util.Date;

import com.app.smrmf.sysm.server.vo.SysIfSysm0100VO;


/**
 * AdmTraceUser generated by hbm2java
 */
public class AdmTraceUser implements java.io.Serializable {

    private Long id;
    private SysIfSysm0100VO admUser;
    private Date datetime;
    private String methodExecuted;
    private String daoUsed;
    private String activityOnDb;
    private String dbSession;
    private String wsSesssion;

    public AdmTraceUser() {
    }

    public AdmTraceUser(SysIfSysm0100VO admUser, Date datetime) {
        this.admUser = admUser;
        this.datetime = datetime;
    }

    public AdmTraceUser(SysIfSysm0100VO admUser, Date datetime, String methodExecuted, String daoUsed, String activityOnDb, String dbSession, String wsSesssion) {
        this.admUser = admUser;
        this.datetime = datetime;
        this.methodExecuted = methodExecuted;
        this.daoUsed = daoUsed;
        this.activityOnDb = activityOnDb;
        this.dbSession = dbSession;
        this.wsSesssion = wsSesssion;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SysIfSysm0100VO getadmUser() {
        return this.admUser;
    }

    public void setadmUser(SysIfSysm0100VO admUser) {
        this.admUser = admUser;
    }

    public Date getDatetime() {
        return this.datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getMethodExecuted() {
        return this.methodExecuted;
    }

    public void setMethodExecuted(String methodExecuted) {
        this.methodExecuted = methodExecuted;
    }

    public String getDaoUsed() {
        return this.daoUsed;
    }

    public void setDaoUsed(String daoUsed) {
        this.daoUsed = daoUsed;
    }

    public String getActivityOnDb() {
        return this.activityOnDb;
    }

    public void setActivityOnDb(String activityOnDb) {
        this.activityOnDb = activityOnDb;
    }

    public String getDbSession() {
        return this.dbSession;
    }

    public void setDbSession(String dbSession) {
        this.dbSession = dbSession;
    }

    public String getWsSesssion() {
        return this.wsSesssion;
    }

    public void setWsSesssion(String wsSesssion) {
        this.wsSesssion = wsSesssion;
    }

}
