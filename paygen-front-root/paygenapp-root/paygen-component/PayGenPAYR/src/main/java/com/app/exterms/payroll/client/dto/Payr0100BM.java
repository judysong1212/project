package com.app.exterms.payroll.client.dto;



import java.math.BigDecimal;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0100VO.java
 * @Description : Payr0100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0100BM    extends MSFSimpleBaseModel implements IsSerializable   {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 적용년도 : apptnYr */
    public static final String ATTR_APPTNYR = "apptnYr";
    
    /** set 적용년도disp : apptnYrDisp */
    public static final String ATTR_APPTNYRDISP = "apptnYrDisp";
    
    /** set 근로소득간이세액표일련번호 : eandIncmTxtbSimfTxsNum */
    public static final String ATTR_EANDINCMTXTBSIMFTXSNUM = "eandIncmTxtbSimfTxsNum";

    /** set 적용기준시작일자 : apptnStdBgnnDt */
    public static final String ATTR_APPTNSTDBGNNDT = "apptnStdBgnnDt";
    
    /** set 적용기준시작일자disp : apptnStdBgnnDtDisp */
    public static final String ATTR_APPTNSTDBGNNDTDISP = "apptnStdBgnnDtDisp";
    
    /** set 적용기준종료일자 : apptnStdEndDt */
    public static final String ATTR_APPTNSTDENDDT = "apptnStdEndDt";

    /** set 이상 : ovr */
    public static final String ATTR_OVR = "ovr";

    /** set 미만 : udr */
    public static final String ATTR_UDR = "udr";

    /** set 1인 : oneOfPepl */
    public static final String ATTR_ONEOFPEPL = "oneOfPepl";

    /** set 2인 : twoOfPepl */
    public static final String ATTR_TWOOFPEPL = "twoOfPepl";

    /** set 3인일반 : treOfGerl */
    public static final String ATTR_TREOFGERL = "treOfGerl";

    /** set 3인다자녀 : treOfMlchd */
    public static final String ATTR_TREOFMLCHD = "treOfMlchd";

    /** set 4인일반 : furOfGerl */
    public static final String ATTR_FUROFGERL = "furOfGerl";

    /** set 4인다자녀 : furOfMlchd */
    public static final String ATTR_FUROFMLCHD = "furOfMlchd";

    /** set 5인일반 : fveOfGerl */
    public static final String ATTR_FVEOFGERL = "fveOfGerl";

    /** set 5인다자녀 : fveOfMlchd */
    public static final String ATTR_FVEOFMLCHD = "fveOfMlchd";

    /** set 6인일반 : sixOfGerl */
    public static final String ATTR_SIXOFGERL = "sixOfGerl";

    /** set 6인다자녀 : sixOfMlchd */
    public static final String ATTR_SIXOFMLCHD = "sixOfMlchd";

    /** set 7인일반 : svnOfGerl */
    public static final String ATTR_SVNOFGERL = "svnOfGerl";

    /** set 7인다자녀 : svnOfMlchd */
    public static final String ATTR_SVNOFMLCHD = "svnOfMlchd";

    /** set 8인일반 : egtOfGerl */
    public static final String ATTR_EGTOFGERL = "egtOfGerl";

    /** set 8인다자녀 : egtOfMlchd */
    public static final String ATTR_EGTOFMLCHD = "egtOfMlchd";

    /** set 9인일반 : nineOfGerl */
    public static final String ATTR_NINEOFGERL = "nineOfGerl";

    /** set 9인다자녀 : nineOfMlchd */
    public static final String ATTR_NINEOFMLCHD = "nineOfMlchd";

    /** set 10인일반 : tenOfGerl */
    public static final String ATTR_TENOFGERL = "tenOfGerl";

    /** set 10인다자녀 : tenOfMlchd */
    public static final String ATTR_TENOFMLCHD = "tenOfMlchd";

    /** set 11인일반 : evthOfGerl */
    public static final String ATTR_EVTHOFGERL = "evthOfGerl";

    /** set 11인다자녀 : evthOfMlchd */
    public static final String ATTR_EVTHOFMLCHD = "evthOfMlchd";

    /** set 입력자 : kybdr */
    public static final String ATTR_KYBDR = "kybdr";

    /** set 입력일자 : inptDt */
    public static final String ATTR_INPTDT = "inptDt";

    /** set 입력주소 : inptAddr */
    public static final String ATTR_INPTADDR = "inptAddr";

    /** set 수정자 : ismt */
    public static final String ATTR_ISMT = "ismt";

    /** set 수정일자 : revnDt */
    public static final String ATTR_REVNDT = "revnDt";

    /** set 수정주소 : revnAddr */
    public static final String ATTR_REVNADDR = "revnAddr";

    /** 생성자 */
     public Payr0100BM() { super(); } 

    /** 일괄등록 처리   */
     public Payr0100BM(
    		 String  dpobCd 
    		, String  apptnYr 
    		, BigDecimal  eandIncmTxtbSimfTxsNum 
    		, String  apptnStdBgnnDt 
    		, String  apptnStdEndDt 
    		, BigDecimal  ovr 
    		, BigDecimal  udr 
    		, BigDecimal  oneOfPepl 
    		, BigDecimal  twoOfPepl 
    		, BigDecimal  treOfGerl 
    		, BigDecimal  treOfMlchd 
    		, BigDecimal  furOfGerl 
    		, BigDecimal  furOfMlchd 
    		, BigDecimal  fveOfGerl 
    		, BigDecimal  fveOfMlchd 
    		, BigDecimal  sixOfGerl 
    		, BigDecimal  sixOfMlchd 
    		, BigDecimal  svnOfGerl 
    		, BigDecimal  svnOfMlchd 
    		, BigDecimal  egtOfGerl 
    		, BigDecimal  egtOfMlchd 
    		, BigDecimal  nineOfGerl 
    		, BigDecimal  nineOfMlchd 
    		, BigDecimal  tenOfGerl 
    		, BigDecimal  tenOfMlchd 
    		, BigDecimal  evthOfGerl 
    		, BigDecimal  evthOfMlchd 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_APPTNYR,apptnYr);
     	values.put(ATTR_EANDINCMTXTBSIMFTXSNUM,eandIncmTxtbSimfTxsNum);
     	values.put(ATTR_APPTNSTDBGNNDT,apptnStdBgnnDt);
     	values.put(ATTR_APPTNSTDENDDT,apptnStdEndDt);
     	values.put(ATTR_OVR,ovr);
     	values.put(ATTR_UDR,udr);
     	values.put(ATTR_ONEOFPEPL,oneOfPepl);
     	values.put(ATTR_TWOOFPEPL,twoOfPepl);
     	values.put(ATTR_TREOFGERL,treOfGerl);
     	values.put(ATTR_TREOFMLCHD,treOfMlchd);
     	values.put(ATTR_FUROFGERL,furOfGerl);
     	values.put(ATTR_FUROFMLCHD,furOfMlchd);
     	values.put(ATTR_FVEOFGERL,fveOfGerl);
     	values.put(ATTR_FVEOFMLCHD,fveOfMlchd);
     	values.put(ATTR_SIXOFGERL,sixOfGerl);
     	values.put(ATTR_SIXOFMLCHD,sixOfMlchd);
     	values.put(ATTR_SVNOFGERL,svnOfGerl);
     	values.put(ATTR_SVNOFMLCHD,svnOfMlchd);
     	values.put(ATTR_EGTOFGERL,egtOfGerl);
     	values.put(ATTR_EGTOFMLCHD,egtOfMlchd);
     	values.put(ATTR_NINEOFGERL,nineOfGerl);
     	values.put(ATTR_NINEOFMLCHD,nineOfMlchd);
     	values.put(ATTR_TENOFGERL,tenOfGerl);
     	values.put(ATTR_TENOFMLCHD,tenOfMlchd);
     	values.put(ATTR_EVTHOFGERL,evthOfGerl);
     	values.put(ATTR_EVTHOFMLCHD,evthOfMlchd);
     	values.put(ATTR_KYBDR,kybdr);
     	values.put(ATTR_INPTDT,inptDt);
     	values.put(ATTR_INPTADDR,inptAddr);
     	values.put(ATTR_ISMT,ismt);
     	values.put(ATTR_REVNDT,revnDt);
     	values.put(ATTR_REVNADDR,revnAddr); } 

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}

    /** set 적용년도 : apptnYr */
    public void setApptnYr(String  apptnYr) { set( ATTR_APPTNYR ,apptnYr);}
    /** get 적용년도 : apptnYr */
    public String  getApptnYr() { return (String )get( ATTR_APPTNYR );}

    /** set 적용년도 : apptnYrDisp */
    public void setApptnYrDisp(String  apptnYrDisp) { set( ATTR_APPTNYRDISP ,apptnYrDisp);}
    /** get 적용년도 : apptnYrDisp */
    public String  getApptnYrDisp() { return (String )get( ATTR_APPTNYRDISP );}
    

    /** set 근로소득간이세액표일련번호 : eandIncmTxtbSimfTxsNum */
    public void setEandIncmTxtbSimfTxsNum(BigDecimal  eandIncmTxtbSimfTxsNum) { set( ATTR_EANDINCMTXTBSIMFTXSNUM ,eandIncmTxtbSimfTxsNum);}
    /** get 근로소득간이세액표일련번호 : eandIncmTxtbSimfTxsNum */
    public BigDecimal  getEandIncmTxtbSimfTxsNum() { return (BigDecimal )get( ATTR_EANDINCMTXTBSIMFTXSNUM );}

    /** set 적용기준시작일자 : apptnStdBgnnDt */
    public void setApptnStdBgnnDt(String  apptnStdBgnnDt) { set( ATTR_APPTNSTDBGNNDT ,apptnStdBgnnDt);}
    /** get 적용기준시작일자 : apptnStdBgnnDt */
    public String  getApptnStdBgnnDt() { return (String )get( ATTR_APPTNSTDBGNNDT );}
    
    /** set 적용기준시작일자 : apptnStdBgnnDtDisp */
    public void setApptnStdBgnnDtDisp(String  apptnStdBgnnDtDisp) { set( ATTR_APPTNSTDBGNNDTDISP ,apptnStdBgnnDtDisp);}
    /** get 적용기준시작일자 : apptnStdBgnnDtDisp */
    public String  getApptnStdBgnnDtDisp() { return (String )get( ATTR_APPTNSTDBGNNDTDISP );}
 
    /** set 적용기준종료일자 : apptnStdEndDt */
    public void setApptnStdEndDt(String  apptnStdEndDt) { set( ATTR_APPTNSTDENDDT ,apptnStdEndDt);}
    /** get 적용기준종료일자 : apptnStdEndDt */
    public String  getApptnStdEndDt() { return (String )get( ATTR_APPTNSTDENDDT );}

    /** set 이상 : ovr */
    public void setOvr(BigDecimal  ovr) { set( ATTR_OVR ,ovr);}
    /** get 이상 : ovr */
    public BigDecimal  getOvr() { return (BigDecimal )get( ATTR_OVR );}

    /** set 미만 : udr */
    public void setUdr(BigDecimal  udr) { set( ATTR_UDR ,udr);}
    /** get 미만 : udr */
    public BigDecimal  getUdr() { return (BigDecimal )get( ATTR_UDR );}

    /** set 1인 : oneOfPepl */
    public void setOneOfPepl(BigDecimal  oneOfPepl) { set( ATTR_ONEOFPEPL ,oneOfPepl);}
    /** get 1인 : oneOfPepl */
    public BigDecimal  getOneOfPepl() { return (BigDecimal )get( ATTR_ONEOFPEPL );}

    /** set 2인 : twoOfPepl */
    public void setTwoOfPepl(BigDecimal  twoOfPepl) { set( ATTR_TWOOFPEPL ,twoOfPepl);}
    /** get 2인 : twoOfPepl */
    public BigDecimal  getTwoOfPepl() { return (BigDecimal )get( ATTR_TWOOFPEPL );}

    /** set 3인일반 : treOfGerl */
    public void setTreOfGerl(BigDecimal  treOfGerl) { set( ATTR_TREOFGERL ,treOfGerl);}
    /** get 3인일반 : treOfGerl */
    public BigDecimal  getTreOfGerl() { return (BigDecimal )get( ATTR_TREOFGERL );}

    /** set 3인다자녀 : treOfMlchd */
    public void setTreOfMlchd(BigDecimal  treOfMlchd) { set( ATTR_TREOFMLCHD ,treOfMlchd);}
    /** get 3인다자녀 : treOfMlchd */
    public BigDecimal  getTreOfMlchd() { return (BigDecimal )get( ATTR_TREOFMLCHD );}

    /** set 4인일반 : furOfGerl */
    public void setFurOfGerl(BigDecimal  furOfGerl) { set( ATTR_FUROFGERL ,furOfGerl);}
    /** get 4인일반 : furOfGerl */
    public BigDecimal  getFurOfGerl() { return (BigDecimal )get( ATTR_FUROFGERL );}

    /** set 4인다자녀 : furOfMlchd */
    public void setFurOfMlchd(BigDecimal  furOfMlchd) { set( ATTR_FUROFMLCHD ,furOfMlchd);}
    /** get 4인다자녀 : furOfMlchd */
    public BigDecimal  getFurOfMlchd() { return (BigDecimal )get( ATTR_FUROFMLCHD );}

    /** set 5인일반 : fveOfGerl */
    public void setFveOfGerl(BigDecimal  fveOfGerl) { set( ATTR_FVEOFGERL ,fveOfGerl);}
    /** get 5인일반 : fveOfGerl */
    public BigDecimal  getFveOfGerl() { return (BigDecimal )get( ATTR_FVEOFGERL );}

    /** set 5인다자녀 : fveOfMlchd */
    public void setFveOfMlchd(BigDecimal  fveOfMlchd) { set( ATTR_FVEOFMLCHD ,fveOfMlchd);}
    /** get 5인다자녀 : fveOfMlchd */
    public BigDecimal  getFveOfMlchd() { return (BigDecimal )get( ATTR_FVEOFMLCHD );}

    /** set 6인일반 : sixOfGerl */
    public void setSixOfGerl(BigDecimal  sixOfGerl) { set( ATTR_SIXOFGERL ,sixOfGerl);}
    /** get 6인일반 : sixOfGerl */
    public BigDecimal  getSixOfGerl() { return (BigDecimal )get( ATTR_SIXOFGERL );}

    /** set 6인다자녀 : sixOfMlchd */
    public void setSixOfMlchd(BigDecimal  sixOfMlchd) { set( ATTR_SIXOFMLCHD ,sixOfMlchd);}
    /** get 6인다자녀 : sixOfMlchd */
    public BigDecimal  getSixOfMlchd() { return (BigDecimal )get( ATTR_SIXOFMLCHD );}

    /** set 7인일반 : svnOfGerl */
    public void setSvnOfGerl(BigDecimal  svnOfGerl) { set( ATTR_SVNOFGERL ,svnOfGerl);}
    /** get 7인일반 : svnOfGerl */
    public BigDecimal  getSvnOfGerl() { return (BigDecimal )get( ATTR_SVNOFGERL );}

    /** set 7인다자녀 : svnOfMlchd */
    public void setSvnOfMlchd(BigDecimal  svnOfMlchd) { set( ATTR_SVNOFMLCHD ,svnOfMlchd);}
    /** get 7인다자녀 : svnOfMlchd */
    public BigDecimal  getSvnOfMlchd() { return (BigDecimal )get( ATTR_SVNOFMLCHD );}

    /** set 8인일반 : egtOfGerl */
    public void setEgtOfGerl(BigDecimal  egtOfGerl) { set( ATTR_EGTOFGERL ,egtOfGerl);}
    /** get 8인일반 : egtOfGerl */
    public BigDecimal  getEgtOfGerl() { return (BigDecimal )get( ATTR_EGTOFGERL );}

    /** set 8인다자녀 : egtOfMlchd */
    public void setEgtOfMlchd(BigDecimal  egtOfMlchd) { set( ATTR_EGTOFMLCHD ,egtOfMlchd);}
    /** get 8인다자녀 : egtOfMlchd */
    public BigDecimal  getEgtOfMlchd() { return (BigDecimal )get( ATTR_EGTOFMLCHD );}

    /** set 9인일반 : nineOfGerl */
    public void setNineOfGerl(BigDecimal  nineOfGerl) { set( ATTR_NINEOFGERL ,nineOfGerl);}
    /** get 9인일반 : nineOfGerl */
    public BigDecimal  getNineOfGerl() { return (BigDecimal )get( ATTR_NINEOFGERL );}

    /** set 9인다자녀 : nineOfMlchd */
    public void setNineOfMlchd(BigDecimal  nineOfMlchd) { set( ATTR_NINEOFMLCHD ,nineOfMlchd);}
    /** get 9인다자녀 : nineOfMlchd */
    public BigDecimal  getNineOfMlchd() { return (BigDecimal )get( ATTR_NINEOFMLCHD );}

    /** set 10인일반 : tenOfGerl */
    public void setTenOfGerl(BigDecimal  tenOfGerl) { set( ATTR_TENOFGERL ,tenOfGerl);}
    /** get 10인일반 : tenOfGerl */
    public BigDecimal  getTenOfGerl() { return (BigDecimal )get( ATTR_TENOFGERL );}

    /** set 10인다자녀 : tenOfMlchd */
    public void setTenOfMlchd(BigDecimal  tenOfMlchd) { set( ATTR_TENOFMLCHD ,tenOfMlchd);}
    /** get 10인다자녀 : tenOfMlchd */
    public BigDecimal  getTenOfMlchd() { return (BigDecimal )get( ATTR_TENOFMLCHD );}

    /** set 11인일반 : evthOfGerl */
    public void setEvthOfGerl(BigDecimal  evthOfGerl) { set( ATTR_EVTHOFGERL ,evthOfGerl);}
    /** get 11인일반 : evthOfGerl */
    public BigDecimal  getEvthOfGerl() { return (BigDecimal )get( ATTR_EVTHOFGERL );}

    /** set 11인다자녀 : evthOfMlchd */
    public void setEvthOfMlchd(BigDecimal  evthOfMlchd) { set( ATTR_EVTHOFMLCHD ,evthOfMlchd);}
    /** get 11인다자녀 : evthOfMlchd */
    public BigDecimal  getEvthOfMlchd() { return (BigDecimal )get( ATTR_EVTHOFMLCHD );}

    /** set 입력자 : kybdr */
    public void setKybdr(String  kybdr) { set( ATTR_KYBDR ,kybdr);}
    /** get 입력자 : kybdr */
    public String  getKybdr() { return (String )get( ATTR_KYBDR );}

    /** set 입력일자 : inptDt */
    public void setInptDt(String  inptDt) { set( ATTR_INPTDT ,inptDt);}
    /** get 입력일자 : inptDt */
    public String  getInptDt() { return (String )get( ATTR_INPTDT );}

    /** set 입력주소 : inptAddr */
    public void setInptAddr(String  inptAddr) { set( ATTR_INPTADDR ,inptAddr);}
    /** get 입력주소 : inptAddr */
    public String  getInptAddr() { return (String )get( ATTR_INPTADDR );}

    /** set 수정자 : ismt */
    public void setIsmt(String  ismt) { set( ATTR_ISMT ,ismt);}
    /** get 수정자 : ismt */
    public String  getIsmt() { return (String )get( ATTR_ISMT );}

    /** set 수정일자 : revnDt */
    public void setRevnDt(String  revnDt) { set( ATTR_REVNDT ,revnDt);}
    /** get 수정일자 : revnDt */
    public String  getRevnDt() { return (String )get( ATTR_REVNDT );}

    /** set 수정주소 : revnAddr */
    public void setRevnAddr(String  revnAddr) { set( ATTR_REVNADDR ,revnAddr);}
    /** get 수정주소 : revnAddr */
    public String  getRevnAddr() { return (String )get( ATTR_REVNADDR );}

   
    
}
