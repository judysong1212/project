/**
 * 최근 3개월간 기본급여 및 제수당 
 */
package com.app.exterms.retirement.client.dto;



import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0220VO.java
 * @Description : Payr0220 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class RemtDays0100BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
   
    /** set 지급공제항목코드 : payItemCd */
    public static final String ATTR_PAYITEMCD = "payItemCd";

    /** set 지급공제항목명 : payItemNm */
    public static final String ATTR_PAYITEMNM = "payItemNm";
 

    /** set 급여기간시작일자01 : itemStDt01 */
    public static final String ATTR_ITEMSTDT01 = "itemStDt01";

    /** set 급여기간종료일자01 : itemEdDt01 */
    public static final String ATTR_ITEMEDDT01 = "itemEdDt01";

    /** set 급여기간시작일자02 : itemStDt02 */
    public static final String ATTR_ITEMSTDT02 = "itemStDt02";

    /** set 급여기간종료일자02 : itemEdDt02 */
    public static final String ATTR_ITEMEDDT02 = "itemEdDt02";
    
    /** set 급여기간시작일자03 : itemStDt03 */
    public static final String ATTR_ITEMSTDT03 = "itemStDt03";

    /** set 급여기간종료일자03 : itemEdDt03 */
    public static final String ATTR_ITEMEDDT03 = "itemEdDt03";
    
    
    /** set 급여기간시작일자04 : itemStDt04 */
    public static final String ATTR_ITEMSTDT04 = "itemStDt04";

    /** set 급여기간종료일자04 : itemEdDt04 */
    public static final String ATTR_ITEMEDDT04 = "itemEdDt04";
    
    
    /** set 급여기간일수 : itemDays01 */
    public static final String ATTR_ITEMDAYS01 = "itemDays01";
    
    /** set 급여기간일수 : itemDays02 */
    public static final String ATTR_ITEMDAYS02 = "itemDays02";
    
    /** set 급여기간일수 : itemDays03 */
    public static final String ATTR_ITEMDAYS03 = "itemDays03";
    
    /** set 급여기간일수 : itemDays04 */
    public static final String ATTR_ITEMDAYS04 = "itemDays04";
    

    /** set 급여기간총일수 :  itemTotDays */
    public static final String ATTR_ITEMTOTDAYS = "itemTotDays";
 
    /** 생성자 */
     public RemtDays0100BM() { super(); } 

    /** 일괄등록 처리   */
     public RemtDays0100BM(
    		  String  payItemCd  
    		, String  itemStDt01  
    		, String  itemEdDt01  
    		, String  itemStDt02  
    		, String  itemEdDt02  
    		, String  itemStDt03  
    		, String  itemEdDt03  
    		, String  itemStDt04  
    		, String  itemEdDt04  
    		, Long  itemDays01 
    		, Long  itemDays02 
    		, Long  itemDays03 
    		, Long  itemDays04 
    		, Long  itemTotDays 
    	  ) { 
     	values.put(ATTR_PAYITEMCD,payItemCd);   //지급공제항목코드
     	values.put(ATTR_ITEMSTDT01,itemStDt01);
     	values.put(ATTR_ITEMEDDT01,itemEdDt01);
     	values.put(ATTR_ITEMSTDT02,itemStDt02);
     	values.put(ATTR_ITEMEDDT02,itemEdDt02);
     	values.put(ATTR_ITEMSTDT03,itemStDt03);
     	values.put(ATTR_ITEMEDDT03, itemEdDt03);
     	values.put(ATTR_ITEMSTDT04,itemStDt04);
     	values.put(ATTR_ITEMEDDT04,itemEdDt04);
     	values.put(ATTR_ITEMDAYS01,itemDays01);
     	values.put(ATTR_ITEMDAYS02,itemDays02);
     	values.put(ATTR_ITEMDAYS03,itemDays03);
     	values.put(ATTR_ITEMDAYS04,itemDays04);
     	values.put(ATTR_ITEMTOTDAYS,itemTotDays);} 

    /** set 지급공제항목코드 : payItemCd */
    public void setPayItemCd(String  payItemCd) { set( ATTR_PAYITEMCD ,payItemCd);}
    /** get 지급공제항목코드 : payItemCd */
    public String  getPayItemCd() { return (String )get( ATTR_PAYITEMCD );}
 
    
    /** set 지급공제항목명 : payItemNm */
    public void setPayItemNm(String  payItemNm) { set( ATTR_PAYITEMNM ,payItemNm);}
    /** get 지급공제항목명 : payItemNm */
    public String  getPayItemNm() { return (String )get( ATTR_PAYITEMNM );}
     

    /** set 급여기간시작일자01 : itemStDt01 */
    public void setItemStDt01(String  itemStDt01) { set( ATTR_ITEMSTDT01 ,itemStDt01);}
    /** get 급여기간시작일자01 : itemStDt01 */
    public String  getItemStDt01() { return (String )get( ATTR_ITEMSTDT01 );}
 
   
    /** set 급여기간종료일자01 : itemEdDt01 */
    public void setItemEdDt01(String  itemEdDt01) { set( ATTR_ITEMEDDT01 ,itemEdDt01);}
    /** get 급여기간종료일자01 : itemEdDt01 */
    public String  getItemEdDt01() { return (String )get( ATTR_ITEMEDDT01 );}
  
    
    /** set 급여기간시작일자02 : itemStDt02 */
    public void setItemStDt02(String  itemStDt02) { set( ATTR_ITEMSTDT02 ,itemStDt02);}
    /** get 급여기간시작일자02 : itemStDt02 */
    public String  getItemStDt02() { return (String )get( ATTR_ITEMSTDT02 );}
 
   
    /** set 급여기간종료일자02 : itemEdDt02 */
    public void setItemEdDt02(String  itemEdDt02) { set( ATTR_ITEMEDDT02 ,itemEdDt02);}
    /** get 급여기간종료일자02 : itemEdDt02 */
    public String  getItemEdDt02() { return (String )get( ATTR_ITEMEDDT02 );}
  
    /** set 급여기간시작일자03 : itemStDt03 */
    public void setItemStDt03(String  itemStDt03) { set( ATTR_ITEMSTDT03 ,itemStDt03);}
    /** get 급여기간시작일자03 : itemStDt03 */
    public String  getItemStDt03() { return (String )get( ATTR_ITEMSTDT03 );}
 

    /** set 급여기간종료일자03 : itemEdDt03 */
    public void setItemEdDt03(String  itemEdDt03) { set( ATTR_ITEMEDDT03 ,itemEdDt03);}
    /** get 급여기간종료일자03 : itemEdDt03 */
    public String  getItemEdDt03() { return (String )get( ATTR_ITEMEDDT03 );} 
   
  
    /** set 급여기간시작일자04 : itemStDt04 */
    public void setItemStDt04(String  itemStDt04) { set( ATTR_ITEMSTDT04 ,itemStDt04);}
    /** get 급여기간시작일자04 : itemStDt04 */
    public String  getItemStDt04() { return (String )get( ATTR_ITEMSTDT04 );}
 
   
    /** set 급여기간종료일자04 : itemEdDt04 */
    public void setItemEdDt04(String  itemEdDt04) { set( ATTR_ITEMEDDT04 ,itemEdDt04);}
    /** get 급여기간종료일자04 : itemEdDt04 */
    public String  getItemEdDt04() { return (String )get( ATTR_ITEMEDDT04 );}
     
    
   
    /** set 급여기간일수 : itemDays01 */
    public void setItemDays01(Long  itemDays01) { set( ATTR_ITEMDAYS01 ,itemDays01);}
    /** get 급여기간일수 : itemDays01 */
    public Long  getItemDays01() { return (Long )get( ATTR_ITEMDAYS01 );}
     
    /** set 급여기간일수 : itemDays02 */
    public void setItemDays02(Long  itemDays02) { set( ATTR_ITEMDAYS02 ,itemDays02);}
    /** get 급여기간일수 : itemDays02 */
    public Long  getItemDays02() { return (Long )get( ATTR_ITEMDAYS02 );}
    
    /** set 급여기간일수 : itemDays03 */
    public void setItemDays03(Long  itemDays03) { set( ATTR_ITEMDAYS03 ,itemDays03);}
    /** get 급여기간일수 : itemDays03 */
    public Long  getItemDays03() { return (Long )get( ATTR_ITEMDAYS03 );}
    
    /** set 급여기간일수 : itemDays04 */
    public void setItemDays04(Long  itemDays04) { set( ATTR_ITEMDAYS04 ,itemDays04);}
    /** get 급여기간일수 : itemDays04 */
    public Long  getItemDays04() { return (Long )get( ATTR_ITEMDAYS04 );}
    
    /** set 총일수  : itemTotDays */
    public void setItemTotDays(Long  itemTotDays) { set( ATTR_ITEMTOTDAYS ,itemTotDays);}
    /** get 퇴직금 급여합계  : itemTotDays */
    public Long  getItemTotDays() { return (Long )get( ATTR_ITEMTOTDAYS );}
 
}

 


