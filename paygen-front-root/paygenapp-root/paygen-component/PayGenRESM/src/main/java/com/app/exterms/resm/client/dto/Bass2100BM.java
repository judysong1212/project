package com.app.exterms.resm.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Bass0200VO.java
 * @Description : Bass0200 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.14
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Bass2100BM   extends MSFSimpleBaseModel implements IsSerializable{
    private static final long serialVersionUID = 1L;
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 사업직종분류코드 : busnTypOccuCifiCd */
    public static final String ATTR_BUSNTYPOCCUCIFICD = "busnTypOccuCifiCd";

    /** set 사업분류명 : busnCifiNm */
    public static final String ATTR_BUSNCIFINM = "busnCifiNm";

    /** set 직종세적용단가구분코드 : dtilOcclsApptnUcstCd */
    public static final String ATTR_DTILOCCLSAPPTNUCSTCD = "dtilOcclsApptnUcstCd";

    /** set 사업직종분류단가금액 : busnTypOccuCifiUcstSum */
    public static final String ATTR_BUSNTYPOCCUCIFIUCSTSUM = "busnTypOccuCifiUcstSum";

    /** set 사업직종분류직군코드 : busnTypOccuCifiJbfmlCd */
    public static final String ATTR_BUSNTYPOCCUCIFIJBFMLCD = "busnTypOccuCifiJbfmlCd";

    /** set 사업직종분류시작일자 : busnTypOccuCifiBgnnDt */
    public static final String ATTR_BUSNTYPOCCUCIFIBGNNDT = "busnTypOccuCifiBgnnDt";

    /** set 사업직종분류종료일자 : busnTypOccuCifiEndDt */
    public static final String ATTR_BUSNTYPOCCUCIFIENDDT = "busnTypOccuCifiEndDt";

    /** set 사업직종분류사용여부 : busnTypOccuCifiUseYn */
    public static final String ATTR_BUSNTYPOCCUCIFIUSEYN = "busnTypOccuCifiUseYn";

    /** set 사업장직종분류비고내용 : dpobTypOccuCifiCtnt */
    public static final String ATTR_DPOBTYPOCCUCIFICTNT = "dpobTypOccuCifiCtnt";

    /** set 직종코드 : typOccuCd */
    public static final String ATTR_TYPOCCUCD = "typOccuCd";

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
     public Bass2100BM() { super(); } 

    /** 일괄등록 처리   */
     public Bass2100BM(
    		 String  dpobCd 
    		, String  busnTypOccuCifiCd 
    		, String  busnCifiNm 
    		, String  dtilOcclsApptnUcstCd 
    		, Double  busnTypOccuCifiUcstSum 
    		, String  busnTypOccuCifiJbfmlCd 
    		, String  busnTypOccuCifiBgnnDt 
    		, String  busnTypOccuCifiEndDt 
    		, String  busnTypOccuCifiUseYn 
    		, String  dpobTypOccuCifiCtnt 
    		, String  typOccuCd 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr ) { 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_BUSNTYPOCCUCIFICD,busnTypOccuCifiCd);
     	values.put(ATTR_BUSNCIFINM,busnCifiNm);
     	values.put(ATTR_DTILOCCLSAPPTNUCSTCD,dtilOcclsApptnUcstCd);
     	values.put(ATTR_BUSNTYPOCCUCIFIUCSTSUM,busnTypOccuCifiUcstSum);
     	values.put(ATTR_BUSNTYPOCCUCIFIJBFMLCD,busnTypOccuCifiJbfmlCd);
     	values.put(ATTR_BUSNTYPOCCUCIFIBGNNDT,busnTypOccuCifiBgnnDt);
     	values.put(ATTR_BUSNTYPOCCUCIFIENDDT,busnTypOccuCifiEndDt);
     	values.put(ATTR_BUSNTYPOCCUCIFIUSEYN,busnTypOccuCifiUseYn);
     	values.put(ATTR_DPOBTYPOCCUCIFICTNT,dpobTypOccuCifiCtnt);
     	values.put(ATTR_TYPOCCUCD,typOccuCd);
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

    /** set 사업직종분류코드 : busnTypOccuCifiCd */
    public void setBusnTypOccuCifiCd(String  busnTypOccuCifiCd) { set( ATTR_BUSNTYPOCCUCIFICD ,busnTypOccuCifiCd);}
    /** get 사업직종분류코드 : busnTypOccuCifiCd */
    public String  getBusnTypOccuCifiCd() { return (String )get( ATTR_BUSNTYPOCCUCIFICD );}

    /** set 사업분류명 : busnCifiNm */
    public void setBusnCifiNm(String  busnCifiNm) { set( ATTR_BUSNCIFINM ,busnCifiNm);}
    /** get 사업분류명 : busnCifiNm */
    public String  getBusnCifiNm() { return (String )get( ATTR_BUSNCIFINM );}

    /** set 직종세적용단가구분코드 : dtilOcclsApptnUcstCd */
    public void setDtilOcclsApptnUcstCd(String  dtilOcclsApptnUcstCd) { set( ATTR_DTILOCCLSAPPTNUCSTCD ,dtilOcclsApptnUcstCd);}
    /** get 직종세적용단가구분코드 : dtilOcclsApptnUcstCd */
    public String  getDtilOcclsApptnUcstCd() { return (String )get( ATTR_DTILOCCLSAPPTNUCSTCD );}

    /** set 사업직종분류단가금액 : busnTypOccuCifiUcstSum */
    public void setBusnTypOccuCifiUcstSum(Double  busnTypOccuCifiUcstSum) { set( ATTR_BUSNTYPOCCUCIFIUCSTSUM ,busnTypOccuCifiUcstSum);}
    /** get 사업직종분류단가금액 : busnTypOccuCifiUcstSum */
    public Double  getBusnTypOccuCifiUcstSum() { return (Double )get( ATTR_BUSNTYPOCCUCIFIUCSTSUM );}

    /** set 사업직종분류직군코드 : busnTypOccuCifiJbfmlCd */
    public void setBusnTypOccuCifiJbfmlCd(String  busnTypOccuCifiJbfmlCd) { set( ATTR_BUSNTYPOCCUCIFIJBFMLCD ,busnTypOccuCifiJbfmlCd);}
    /** get 사업직종분류직군코드 : busnTypOccuCifiJbfmlCd */
    public String  getBusnTypOccuCifiJbfmlCd() { return (String )get( ATTR_BUSNTYPOCCUCIFIJBFMLCD );}

    /** set 사업직종분류시작일자 : busnTypOccuCifiBgnnDt */
    public void setBusnTypOccuCifiBgnnDt(String  busnTypOccuCifiBgnnDt) { set( ATTR_BUSNTYPOCCUCIFIBGNNDT ,busnTypOccuCifiBgnnDt);}
    /** get 사업직종분류시작일자 : busnTypOccuCifiBgnnDt */
    public String  getBusnTypOccuCifiBgnnDt() { return (String )get( ATTR_BUSNTYPOCCUCIFIBGNNDT );}

    /** set 사업직종분류종료일자 : busnTypOccuCifiEndDt */
    public void setBusnTypOccuCifiEndDt(String  busnTypOccuCifiEndDt) { set( ATTR_BUSNTYPOCCUCIFIENDDT ,busnTypOccuCifiEndDt);}
    /** get 사업직종분류종료일자 : busnTypOccuCifiEndDt */
    public String  getBusnTypOccuCifiEndDt() { return (String )get( ATTR_BUSNTYPOCCUCIFIENDDT );}

    /** set 사업직종분류사용여부 : busnTypOccuCifiUseYn */
    public void setBusnTypOccuCifiUseYn(String  busnTypOccuCifiUseYn) { set( ATTR_BUSNTYPOCCUCIFIUSEYN ,busnTypOccuCifiUseYn);}
    /** get 사업직종분류사용여부 : busnTypOccuCifiUseYn */
    public String  getBusnTypOccuCifiUseYn() { return (String )get( ATTR_BUSNTYPOCCUCIFIUSEYN );}

    /** set 사업장직종분류비고내용 : dpobTypOccuCifiCtnt */
    public void setDpobTypOccuCifiCtnt(String  dpobTypOccuCifiCtnt) { set( ATTR_DPOBTYPOCCUCIFICTNT ,dpobTypOccuCifiCtnt);}
    /** get 사업장직종분류비고내용 : dpobTypOccuCifiCtnt */
    public String  getDpobTypOccuCifiCtnt() { return (String )get( ATTR_DPOBTYPOCCUCIFICTNT );}

    /** set 직종코드 : typOccuCd */
    public void setTypOccuCd(String  typOccuCd) { set( ATTR_TYPOCCUCD ,typOccuCd);}
    /** get 직종코드 : typOccuCd */
    public String  getTypOccuCd() { return (String )get( ATTR_TYPOCCUCD );}

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
