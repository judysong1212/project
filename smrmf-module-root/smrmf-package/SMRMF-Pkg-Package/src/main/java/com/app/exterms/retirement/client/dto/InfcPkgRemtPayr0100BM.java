/**
 * 연간 후생복지비
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
public class InfcPkgRemtPayr0100BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    /** set 지급공제항목코드 : payItemCd */
    public static final String ATTR_PAYITEMCD = "payItemCd";

    /** set 지급공제항목명 : payItemNm */
    public static final String ATTR_PAYITEMNM = "payItemNm";

    /** set 수당그룹코드 : extpyGrpCd */
    public static final String ATTR_EXTPYGRPCD = "extpyGrpCd";

    /** set 수당그룹명 : extpyGrpNm */
    public static final String ATTR_EXTPYGRPNM = "extpyGrpNm";

    /** set item_tm01 : itemTm01 */
    public static final String ATTR_ITEMTM01 = "itemTm01";

    /** set item_amnt01 : itemAmnt01 */
    public static final String ATTR_ITEMAMNT01 = "itemAmnt01";

    /** set item_tm02 : itemTm02 */
    public static final String ATTR_ITEMTM02 = "itemTm02";

    /** set item_amnt02 : itemAmnt02 */
    public static final String ATTR_ITEMAMNT02 = "itemAmnt02";

    /** set item_tm03 : itemTm03 */
    public static final String ATTR_ITEMTM03 = "itemTm03";

    /** set item_amnt03 : itemAmnt03 */
    public static final String ATTR_ITEMAMNT03 = "itemAmnt03";

    /** set item_tm04 : itemTm04 */
    public static final String ATTR_ITEMTM04 = "itemTm04";

    /** set item_amnt04 : itemAmnt04 */
    public static final String ATTR_ITEMAMNT04 = "itemAmnt04";

    /** set 퇴직금 급여합계 : item_tot-amnt itemTotAmnt */
    public static final String ATTR_ITEMTOTAMNT = "itemTotAmnt";
 
    /** 생성자 */
     public InfcPkgRemtPayr0100BM() { super(); } 

    /** 일괄등록 처리   */
     public InfcPkgRemtPayr0100BM(
    		  String  payItemCd  
    		, String  extpyGrpCd  
    		, Double  itemTm01 
    		, Long    itemAmnt01 
    		, Double  itemTm02 
    		, Long    itemAmnt02 
    		, Double  itemTm03 
    		, Long    itemAmnt03 
    		, Double  itemTm04 
    		, Long    itemAmnt04 
    		, Long    itemTotAmnt 
    	  ) { 
     	values.put(ATTR_PAYITEMCD,payItemCd);   //지급공제항목코드
     	values.put(ATTR_EXTPYGRPCD,extpyGrpCd);
     	values.put(ATTR_ITEMTM01,itemTm01);
     	values.put(ATTR_ITEMAMNT01,itemAmnt01);
     	values.put(ATTR_ITEMTM02,itemTm02);
     	values.put(ATTR_ITEMAMNT02,itemAmnt02);
     	values.put(ATTR_ITEMTM03, itemTm03);
     	values.put(ATTR_ITEMAMNT03,itemAmnt03);
     	values.put(ATTR_ITEMTM04,itemTm04);
     	values.put(ATTR_ITEMAMNT04,itemAmnt04);
     	values.put(ATTR_ITEMTOTAMNT,itemTotAmnt); } 

    /** set 지급공제항목코드 : payItemCd */
    public void setPayItemCd(String  payItemCd) { set( ATTR_PAYITEMCD ,payItemCd);}
    /** get 지급공제항목코드 : payItemCd */
    public String  getPayItemCd() { return (String )get( ATTR_PAYITEMCD );}
 
    
    /** set 지급공제항목명 : payItemNm */
    public void setPayItemNm(String  payItemNm) { set( ATTR_PAYITEMNM ,payItemNm);}
    /** get 지급공제항목명 : payItemNm */
    public String  getPayItemNm() { return (String )get( ATTR_PAYITEMNM );}
     

    /** set 수당그룹코드 : extpyGrpCd */
    public void setExtpyGrpCd(String  extpyGrpCd) { set( ATTR_EXTPYGRPCD ,extpyGrpCd);}
    /** get 수당그룹코드 : extpyGrpCd */
    public String  getExtpyGrpCd() { return (String )get( ATTR_EXTPYGRPCD );}
 
   
    /** set 수당그룹명 : extpyGrpNm */
    public void setExtpyGrpNm(String  extpyGrpNm) { set( ATTR_EXTPYGRPNM ,extpyGrpNm);}
    /** get 수당그룹명 : extpyGrpNm */
    public String  getExtpyGrpNm() { return (String )get( ATTR_EXTPYGRPNM );}
 
    
    /** set item_tm01 : itemTm01 */
    public void setItemTm01(Double  itemTm01) { set( ATTR_ITEMTM01 ,itemTm01);}
    /** get item_tm01 : itemTm01 */
    public Double  getItemTm01() { return (Double )get( ATTR_ITEMTM01 );}
 
   
    /** set item_amnt01 : itemAmnt01 */
    public void setItemAmnt01(Long  itemAmnt01) { set( ATTR_ITEMAMNT01 ,itemAmnt01);}
    /** get item_amnt01 : itemAmnt01 */
    public Long  getItemAmnt01() { return (Long )get( ATTR_ITEMAMNT01 );}

    
    /** set item_tm02 : itemTm02 */
    public void setItemTm02(Double  itemTm02) { set( ATTR_ITEMTM02 ,itemTm02);}
    /** get item_tm02 : itemTm02 */
    public Double  getItemTm02() { return (Double )get( ATTR_ITEMTM02 );}
 
   
    /** set item_amnt02 : itemAmnt02 */
    public void setItemAmnt02(Long  itemAmnt02) { set( ATTR_ITEMAMNT02 ,itemAmnt02);}
    /** get item_amnt02 : itemAmnt02 */
    public Long  getItemAmnt02() { return (Long )get( ATTR_ITEMAMNT02 );}
    
    
    
    /** set item_tm03 : itemTm03 */
    public void setItemTm03(Double  itemTm03) { set( ATTR_ITEMTM03 ,itemTm03);}
    /** get item_tm03 : itemTm03 */
    public Double  getItemTm03() { return (Double )get( ATTR_ITEMTM03 );}
 
   
    /** set item_amnt03 : itemAmnt03 */
    public void setItemAmnt03(Long  itemAmnt03) { set( ATTR_ITEMAMNT03 ,itemAmnt03);}
    /** get item_amnt03 : itemAmnt03 */
    public Long  getItemAmnt03() { return (Long )get( ATTR_ITEMAMNT03 );}
    
    /** set item_tm04 : itemTm04 */
    public void setItemTm04(Double  itemTm04) { set( ATTR_ITEMTM04 ,itemTm04);}
    /** get item_tm04 : itemTm04 */
    public Double  getItemTm04() { return (Double )get( ATTR_ITEMTM04 );}
 
   
    /** set item_amnt04 : itemAmnt04 */
    public void setItemAmnt04(Long  itemAmnt04) { set( ATTR_ITEMAMNT04 ,itemAmnt04);}
    /** get item_amnt04 : itemAmnt04 */
    public Long  getItemAmnt04() { return (Long )get( ATTR_ITEMAMNT04 );}
     
    
    /** set 퇴직금 급여합계  : itemTotAmnt */
    public void setItemTotAmnt(Long  itemTotAmnt) { set( ATTR_ITEMTOTAMNT ,itemTotAmnt);}
    /** get 퇴직금 급여합계  : itemTotAmnt */
    public Long  getItemTotAmnt() { return (Long )get( ATTR_ITEMTOTAMNT );}

}

 


