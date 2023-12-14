package com.app.smrmf.syscom.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : CoCalendarVO.java
 * @Description : CoCalendar VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.31
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class SysCoCalendarBM  extends MSFSimpleBaseModel implements IsSerializable{
    private static final long serialVersionUID = 1L;
    /** set null : calendarDate */
    public static final String ATTR_CALENDARDATE = "calendarDate";

    /** set null : year */
    public static final String ATTR_YEAR = "year";
    
    

    /** set null : year */
    public static final String ATTR_YEARDISP = "yearDisp";
     

    /** set null : month */
    public static final String ATTR_MONTH = "month";

    /** set null : yyyymm */
    public static final String ATTR_YYYYMM = "yyyymm";

    /** set null : yymm */
    public static final String ATTR_YYMM = "yymm";

    /** set null : day */
    public static final String ATTR_DAY = "day";

    /** set null : halfYear */
    public static final String ATTR_HALFYEAR = "halfYear";

    /** set null : quarterYear */
    public static final String ATTR_QUARTERYEAR = "quarterYear";

    /** set null : dayOfWeek */
    public static final String ATTR_DAYOFWEEK = "dayOfWeek";

    /** set null : offdayKubn */
    public static final String ATTR_OFFDAYKUBN = "offdayKubn";

    /** set null : rgstryUser */
    public static final String ATTR_RGSTRYUSER = "rgstryUser";

    /** set null : rgstryDt */
    public static final String ATTR_RGSTRYDT = "rgstryDt";

    /** set null : updateUser */
    public static final String ATTR_UPDATEUSER = "updateUser";

    /** set null : updateDt */
    public static final String ATTR_UPDATEDT = "updateDt";

    /** 생성자 */
     public SysCoCalendarBM() { super(); } 

    /** 일괄등록 처리   */
     public SysCoCalendarBM(
    		 String  calendarDate 
    		, String  year 
    		, String  month 
    		, String  yyyymm 
    		, String  yymm 
    		, String  day 
    		, String  halfYear 
    		, String  quarterYear 
    		, String  dayOfWeek 
    		, String  offdayKubn 
    		, String  rgstryUser 
    		, String  rgstryDt 
    		, String  updateUser 
    		, String  updateDt ) { 
     	values.put(ATTR_CALENDARDATE,calendarDate);
     	values.put(ATTR_YEAR,year);
     	values.put(ATTR_MONTH,month);
     	values.put(ATTR_YYYYMM,yyyymm);
     	values.put(ATTR_YYMM,yymm);
     	values.put(ATTR_DAY,day);
     	values.put(ATTR_HALFYEAR,halfYear);
     	values.put(ATTR_QUARTERYEAR,quarterYear);
     	values.put(ATTR_DAYOFWEEK,dayOfWeek);
     	values.put(ATTR_OFFDAYKUBN,offdayKubn);
     	values.put(ATTR_RGSTRYUSER,rgstryUser);
     	values.put(ATTR_RGSTRYDT,rgstryDt);
     	values.put(ATTR_UPDATEUSER,updateUser);
     	values.put(ATTR_UPDATEDT,updateDt); } 

    /** set null : calendarDate */
    public void setCalendarDate(String  calendarDate) { set( ATTR_CALENDARDATE ,calendarDate);}
    /** get null : calendarDate */
    public String  getCalendarDate() { return (String )get( ATTR_CALENDARDATE );}

    /** set null : year */
    public void setYear(String  year) { set( ATTR_YEAR ,year);}
    /** get null : year */
    public String  getYear() { return (String )get( ATTR_YEAR );}

    
    /** set null : yearDisp */
    public void setYearDisp(String  yearDisp) { set( ATTR_YEARDISP ,yearDisp);}
    /** get null : yearDisp */
    public String  getYearDisp() { return (String )get( ATTR_YEARDISP );}
     
    
    /** set null : month */
    public void setMonth(String  month) { set( ATTR_MONTH ,month);}
    /** get null : month */
    public String  getMonth() { return (String )get( ATTR_MONTH );}

    /** set null : yyyymm */
    public void setYyyymm(String  yyyymm) { set( ATTR_YYYYMM ,yyyymm);}
    /** get null : yyyymm */
    public String  getYyyymm() { return (String )get( ATTR_YYYYMM );}

    /** set null : yymm */
    public void setYymm(String  yymm) { set( ATTR_YYMM ,yymm);}
    /** get null : yymm */
    public String  getYymm() { return (String )get( ATTR_YYMM );}

    /** set null : day */
    public void setDay(String  day) { set( ATTR_DAY ,day);}
    /** get null : day */
    public String  getDay() { return (String )get( ATTR_DAY );}

    /** set null : halfYear */
    public void setHalfYear(String  halfYear) { set( ATTR_HALFYEAR ,halfYear);}
    /** get null : halfYear */
    public String  getHalfYear() { return (String )get( ATTR_HALFYEAR );}

    /** set null : quarterYear */
    public void setQuarterYear(String  quarterYear) { set( ATTR_QUARTERYEAR ,quarterYear);}
    /** get null : quarterYear */
    public String  getQuarterYear() { return (String )get( ATTR_QUARTERYEAR );}

    /** set null : dayOfWeek */
    public void setDayOfWeek(String  dayOfWeek) { set( ATTR_DAYOFWEEK ,dayOfWeek);}
    /** get null : dayOfWeek */
    public String  getDayOfWeek() { return (String )get( ATTR_DAYOFWEEK );}

    /** set null : offdayKubn */
    public void setOffdayKubn(String  offdayKubn) { set( ATTR_OFFDAYKUBN ,offdayKubn);}
    /** get null : offdayKubn */
    public String  getOffdayKubn() { return (String )get( ATTR_OFFDAYKUBN );}

    /** set null : rgstryUser */
    public void setRgstryUser(String  rgstryUser) { set( ATTR_RGSTRYUSER ,rgstryUser);}
    /** get null : rgstryUser */
    public String  getRgstryUser() { return (String )get( ATTR_RGSTRYUSER );}

    /** set null : rgstryDt */
    public void setRgstryDt(String  rgstryDt) { set( ATTR_RGSTRYDT ,rgstryDt);}
    /** get null : rgstryDt */
    public String  getRgstryDt() { return (String )get( ATTR_RGSTRYDT );}

    /** set null : updateUser */
    public void setUpdateUser(String  updateUser) { set( ATTR_UPDATEUSER ,updateUser);}
    /** get null : updateUser */
    public String  getUpdateUser() { return (String )get( ATTR_UPDATEUSER );}

    /** set null : updateDt */
    public void setUpdateDt(String  updateDt) { set( ATTR_UPDATEDT ,updateDt);}
    /** get null : updateDt */
    public String  getUpdateDt() { return (String )get( ATTR_UPDATEDT );}


    
}
