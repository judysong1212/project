/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.shared;

public interface MSFDaoConstants {
 


    public static final String CLASS_BORD0300VIEW_LIST = "com.app.smrmf.core.msfmainapp.server.service.Bord0300ServiceImpl.getBord0300ViewList";
    /*
     * List of all Dao names
     */
    public static final String CLASS_AdmUtenti = "com.app.smrmf.core.msfmainapp.model.dao.AdmUtenti";
    public static final String CLASS_AdmMenu = "com.app.smrmf.core.msfmainapp.model.dao.AdmMenu";
    public static final String CLASS_AdmMenuProfiles = "com.app.smrmf.core.msfmainapp.model.dao.AdmMenuProfiles";
    public static final String CLASS_AdmMenuUtenti = "com.app.smrmf.core.msfmainapp.model.dao.AdmMenuUtenti";
    public static final String CLASS_AdmProfiles = "com.app.smrmf.core.msfmainapp.model.dao.AdmProfiles";
    public static final String CLASS_AdmProfilesUtenti = "com.app.smrmf.core.msfmainapp.model.dao.AdmProfilesUtenti";
    public static final String CLASS_AdmObjectDbConsidered = "com.app.smrmf.core.msfmainapp.model.dao.AdmObjectDbConsidered";
    public static final String CLASS_AdmColumnObjectDb = "com.app.smrmf.core.msfmainapp.model.dao.AdmColumnObjectDb";
    public static final String CLASS_AdmObjectDb = "com.app.smrmf.core.msfmainapp.model.dao.AdmObjectDb";
    public static final String CLASS_AdmTraceUser = "com.app.smrmf.core.msfmainapp.model.dao.AdmTraceUser";
    public static final String CLASS_AdmDataHistory = "com.app.smrmf.core.msfmainapp.model.dao.AdmDataHistory";

     /** 시스템 에러  리스트 **/
	 public static final String CLASS_COREHIST0300_DATA_LIST =  "com.app.smrmf.core.msfmainapp.server.service.Sysm3300ServiceImpl.getHist0300DataList";
    
	 
	 /*
     * List of all Dao attribute names
     */
    //AdmUtenti
    public static final String ATTR_AdmUtenti_identnr = "identnr";
    public static final String ATTR_AdmUtenti_titolo = "titolo";
    public static final String ATTR_AdmUtenti_cognome = "cognome";
    public static final String ATTR_AdmUtenti_nome = "nome";
    public static final String ATTR_AdmUtenti_username = "username";
    public static final String ATTR_AdmUtenti_password = "password";
    public static final String ATTR_AdmUtenti_email = "email";

    //AdmMenu
    public static final String ATTR_AdmMenu_id = "id";
    public static final String ATTR_AdmMenu_admMenu = "admMenu";
    public static final String ATTR_AdmMenu_title = "title";
    public static final String ATTR_AdmMenu_iconcls = "iconcls";
    public static final String ATTR_AdmMenu_thumbnail = "thumbnail";
    public static final String ATTR_AdmMenu_qtip = "qtip";
    public static final String ATTR_AdmMenu_screen = "screen";
    public static final String ATTR_AdmMenu_dateadded = "dateadded";
    public static final String ATTR_AdmMenu_ord = "ord";
    public static final String ATTR_AdmMenu_tipo = "tipo";
    public static final String ATTR_AdmMenu_name = "name";

    //AdmMenuProfiles
    public static final String ATTR_AdmMenuProfiles_id = "id";
    public static final String ATTR_AdmMenuProfiles_admMenu = "admMenu";
    public static final String ATTR_AdmMenuProfiles_admProfiles = "admProfiles";
    public static final String ATTR_AdmMenuProfiles_seInsert = "seInsert";
    public static final String ATTR_AdmMenuProfiles_seUpdate = "seUpdate";
    public static final String ATTR_AdmMenuProfiles_seDelete = "seDelete";

    //AdmMenuUtenti
    public static final String ATTR_AdmMenuUtenti_id = "id";
    public static final String ATTR_AdmMenuUtenti_admMenu = "admMenu";
    public static final String ATTR_AdmMenuUtenti_admUser = "admUser";
    public static final String ATTR_AdmMenuUtenti_seInsert = "seInsert";
    public static final String ATTR_AdmMenuUtenti_seUpdate = "seUpdate";
    public static final String ATTR_AdmMenuUtenti_seDelete = "seDelete";

    //AdmProfiles
    public static final String ATTR_AdmProfiles_id = "id";
    public static final String ATTR_AdmProfiles_description = "description";

    //AdmProfilesUtenti
    public static final String ATTR_AdmProfilesUtenti_id = "id";
    public static final String ATTR_AdmProfilesUtenti_admUser = "admUser";
    public static final String ATTR_AdmProfilesUtenti_admProfiles = "admProfiles";

    //AdmObjectDbConsidered
    public static final String ATTR_AdmObjectDbConsidered_objectName = "objectName";
    public static final String ATTR_AdmObjectDbConsidered_objectType = "objectType";

    //AdmColumnObjectDb
    public static final String ATTR_AdmColumnObjectDb_id = "id";
    public static final String ATTR_AdmColumnObjectDb_id_tableName = "tableName";
    public static final String ATTR_AdmColumnObjectDb_id_columnName = "columnName";
    public static final String ATTR_AdmColumnObjectDb_dataType = "dataType";
    public static final String ATTR_AdmColumnObjectDb_dataLength = "dataLength";
    public static final String ATTR_AdmColumnObjectDb_dataScale = "dataScale";
    public static final String ATTR_AdmColumnObjectDb_dataPrecision = "dataPrecision";
    public static final String ATTR_AdmColumnObjectDb_nullable = "nullable";
    public static final String ATTR_AdmColumnObjectDb_constraintType = "constraintType";

    //AdmObjectDb
    public static final String ATTR_AdmObjectDb_tname = "tname";
    public static final String ATTR_AdmObjectDb_tabtype = "tabtype";

    //AdmTraceUser
    public static final String ATTR_AdmTraceUser_id = "id";
    public static final String ATTR_AdmTraceUser_admUser = "admUser";
    public static final String ATTR_AdmTraceUser_datetime = "datetime";
    public static final String ATTR_AdmTraceUser_methodExecuted = "methodExecuted";
    public static final String ATTR_AdmTraceUser_daoUsed = "daoUsed";
    public static final String ATTR_AdmTraceUser_activityOnDb = "activityOnDb";
    public static final String ATTR_AdmTraceUser_dbSession = "dbSession";
    public static final String ATTR_AdmTraceUser_wsSesssion = "wsSesssion";

    //AdmDataHistory
    public static final String ATTR_AdmDataHistory_id = "id";
    public static final String ATTR_AdmDataHistory_admUser = "admUser";
    public static final String ATTR_AdmDataHistory_datetime = "datetime";
    public static final String ATTR_AdmDataHistory_activityOnDb = "activityOnDb";
    public static final String ATTR_AdmDataHistory_tableName = "tableName";
    public static final String ATTR_AdmDataHistory_daoName = "daoName";
    public static final String ATTR_AdmDataHistory_dataStored = "dataStored";
    public static final String ATTR_AdmDataHistory_primaryKey = "primaryKey";


}
