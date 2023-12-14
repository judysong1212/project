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
public class RemtWfep0100BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
   
    /** set 지급공제항목코드 : payItemCd */
    public static final String ATTR_PAYITEMCD = "payItemCd";

    /** set 지급공제항목명 : payItemNm */
    public static final String ATTR_PAYITEMNM = "payItemNm";
 
    /** set 수당그룹코드 : extpyGrpCd */
    public static final String ATTR_EXTPYGRPCD = "extpyGrpCd";

    /** set 수당그룹명 : extpyGrpNm */
    public static final String ATTR_EXTPYGRPNM = "extpyGrpNm";
    
    /** set 개월 : itemMonths */
    public static final String ATTR_ITEMMONTHS = "itemMonths";
 

    /** set 지급금액 :  pymtSum */
    public static final String ATTR_PYMTSUM = "pymtSum";
    
 
    /** 생성자 */
     public RemtWfep0100BM() { super(); } 

    /** 일괄등록 처리   */
     public RemtWfep0100BM(
    		  String  payItemCd  
      		, String  extpyGrpCd  
      		, String  itemMonths 
      		, Long    pymtSum  
      	  ) { 
       	values.put(ATTR_PAYITEMCD,payItemCd);   //지급공제항목코드
       	values.put(ATTR_EXTPYGRPCD,extpyGrpCd);
       	values.put(ATTR_ITEMMONTHS,itemMonths);
       	values.put(ATTR_PYMTSUM,pymtSum);  } 

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
   
	 /** set 개월 : itemMonths */
	 public void setItemMonths(String  itemMonths) { set( ATTR_ITEMMONTHS ,itemMonths);}
	 /** get 개월 : itemMonths */
	 public String  getItemMonths() { return (String )get( ATTR_ITEMMONTHS );}
      
      /** set 지급금액  : pymtSum */
      public void setPymtSum(Long  pymtSum) { set( ATTR_PYMTSUM ,pymtSum);}
      /** get 퇴직금 급여합계  : pymtSum */
      public Long  getPymtSum() { return (Long )get( ATTR_PYMTSUM );}
 
}

 


