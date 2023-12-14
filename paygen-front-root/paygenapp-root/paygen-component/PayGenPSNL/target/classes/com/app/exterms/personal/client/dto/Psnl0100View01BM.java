package com.app.exterms.personal.client.dto;



import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Psnl0100VO.java
 * @Description : Psnl0100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Psnl0100View01BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    
    
	/** set ITEM01 : item01 */
	public static final String ATTR_ITEM01 = "item01";
	
	/** set ITEM02 : item02 */
	public static final String ATTR_ITEM02 = "item02";
	
	/** set ITEM03 : item03 */
	public static final String ATTR_ITEM03 = "item03";



	/** set ITEM01 : item01 */
	public void setItem01(String  item01) { set( ATTR_ITEM01 ,item01);}
	/** get ITEM01 : item01 */
	public String  getItem01() { return (String )get( ATTR_ITEM01 );}
	
	/** set ITEM02 : item02 */
	public void setItem02(String  item02) { set( ATTR_ITEM02 ,item02);}
	/** get ITEM02 : item02 */
	public String  getItem02() { return (String )get( ATTR_ITEM02 );}
	
	/** set ITEM03 : item03 */
	public void setItem03(String  item03) { set( ATTR_ITEM03 ,item03);}
	/** get ITEM03 : item03 */
	public String  getItem03() { return (String )get( ATTR_ITEM03 );}

     
}
