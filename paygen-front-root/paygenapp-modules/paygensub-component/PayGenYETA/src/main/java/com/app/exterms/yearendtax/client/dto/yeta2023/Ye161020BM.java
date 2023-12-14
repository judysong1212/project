package com.app.exterms.yearendtax.client.dto.yeta2023;



import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;


/**
 *
 * @Class Name : Ye161020BM.java
 * @since : 2017. 12. 8. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
public class Ye161020BM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 귀속연도 : yrtxBlggYr */
    public static final String ATTR_YRTXBLGGYR = "yrtxBlggYr";

    /** set 연말정산구분코드 : clutSeptCd */
    public static final String ATTR_CLUTSEPTCD = "clutSeptCd";
    
    /** set 연말정산구분코드 : clutSeptNm */
    public static final String ATTR_CLUTSEPTNM = "clutSeptNm";


    /** set SYSTEMKEY : systemkey */
    public static final String ATTR_SYSTEMKEY = "systemkey";

    /** set 소득자성명 : fnm */
    public static final String ATTR_FNM = "fnm";

    /** set 주민등록번호 : resnoEncCntn */
    public static final String ATTR_RESNOENCCNTN = "resnoEncCntn";

    /** set 근무처명 : tnm */
    public static final String ATTR_TNM = "tnm";

    /** set 사업자등록번호 : bsnoEncCntn */
    public static final String ATTR_BSNOENCCNTN = "bsnoEncCntn";

    /** set 세대주여부 : hshrClCd */
    public static final String ATTR_HSHRCLCD = "hshrClCd";

    /** set 국적 : rsplNtnInfrNm */
    public static final String ATTR_RSPLNTNINFRNM = "rsplNtnInfrNm";

    /** set 국적코드 : rsplNtnInfrCd */
    public static final String ATTR_RSPLNTNINFRCD = "rsplNtnInfrCd";

    /** set 근무기간시작일자 : dtyStrtDt */
    public static final String ATTR_DTYSTRTDT = "dtyStrtDt";

    /** set 근무기간종료일자 : dtyEndDt */
    public static final String ATTR_DTYENDDT = "dtyEndDt";

    /** set 감면기간시작일자 : reStrtDt */
    public static final String ATTR_RESTRTDT = "reStrtDt";

    /** set 감면기간종료일자 : reEndDt */
    public static final String ATTR_REENDDT = "reEndDt";

    /** set 거주구분 : rsdtClCd */
    public static final String ATTR_RSDTCLCD = "rsdtClCd";

    /** set 거주지국명 : rsplNtnNm */
    public static final String ATTR_RSPLNTNNM = "rsplNtnNm";

    /** set 거주지코드 : rsplNtnCd */
    public static final String ATTR_RSPLNTNCD = "rsplNtnCd";

    /** set 소득세원천징수세액조정구분코드 : inctxWhtxTxamtMetnCd */
    public static final String ATTR_INCTXWHTXTXAMTMETNCD = "inctxWhtxTxamtMetnCd";

    /** set 분납신청여부 : inpmYn */
    public static final String ATTR_INPMYN = "inpmYn";

    /** set 인적공제항목변동여부 : prifChngYn */
    public static final String ATTR_PRIFCHNGYN = "prifChngYn";

    /** set 기본공제인원수 : bscDdcnFpCnt */
    public static final String ATTR_BSCDDCNFPCNT = "bscDdcnFpCnt";

    /** set 경로우대인원수 : sccNfpCnt */
    public static final String ATTR_SCCNFPCNT = "sccNfpCnt";

    /** set 출산입양인원수 : chbtAdopNfpCnt */
    public static final String ATTR_CHBTADOPNFPCNT = "chbtAdopNfpCnt";

    /** set 부녀자인원수 : wmnNfpCnt */
    public static final String ATTR_WMNNFPCNT = "wmnNfpCnt";

    /** set 한부모인원수 : snprntNfpCnt */
    public static final String ATTR_SNPRNTNFPCNT = "snprntNfpCnt";

    /** set 자애인인원수 : dsbrNfpCnt */
    public static final String ATTR_DSBRNFPCNT = "dsbrNfpCnt";

    /** set 6세이하인원수 : age6ltNfpCnt */
    public static final String ATTR_AGE6LTNFPCNT = "age6ltNfpCnt";
    
    /** set 소득공제신고전자파일제출여부 : fileSbtYn */
    public static final String ATTR_FILESBTYN = "fileSbtYn";
    
    /** set 소득공제신고전자파일제출구분 : fileSbtNm */
    public static final String ATTR_FILESBTNM = "fileSbtNm";

    /** set 소득공제신고전자파일적용여부 : fileAppYn */
    public static final String ATTR_FILEAPPYN = "fileAppYn";
    
    /** set 공제신고서전자파일제출여부 : ddcFileSbtYn */
    public static final String ATTR_DDCFILESBTYN = "ddcFileSbtYn";
    
    /** set 공제신고서전자파일제출구분 : ddcFileSbtNm */
    public static final String ATTR_DDCFILESBTNM = "ddcFileSbtNm";
    
    /** set 공제신고서전자파일적용여부 : ddcFileAppYn */
    public static final String ATTR_DDCFILEAPPYN = "ddcFileAppYn";

    /** set 서식코드 : formCd */
    public static final String ATTR_FORMCD = "formCd";

    /** set 발급일자일련번호 : issDtSeilNum */
    public static final String ATTR_ISSDTSEILNUM = "issDtSeilNum";

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
    
    /** set 소득공제구분코드 : commCd */
    public static final String ATTR_COMMCD = "commCd";
    
    /** set 소득공제구분 : commNm */
    public static final String ATTR_COMMNM = "commNm";
    
    /** set 정산반영여부 : pdfDatAppYn */
    public static final String ATTR_PDFDATAPPYN = "pdfDatAppYn";

    /** 생성자 */
     public Ye161020BM() { super(); } 

    /** 일괄등록 처리   */
     public Ye161020BM(
    		 String  dpobCd 
    		, String  yrtxBlggYr 
    		, String  clutSeptCd 
    		, String  systemkey 
    		, String  fnm 
    		, String  resnoEncCntn 
    		, String  tnm 
    		, String  bsnoEncCntn 
    		, String  hshrClCd 
    		, String  rsplNtnInfrNm 
    		, String  rsplNtnInfrCd 
    		, String  dtyStrtDt 
    		, String  dtyEndDt 
    		, String  reStrtDt 
    		, String  reEndDt 
    		, String  rsdtClCd 
    		, String  rsplNtnNm 
    		, String  rsplNtnCd 
    		, String  inctxWhtxTxamtMetnCd 
    		, String  inpmYn 
    		, String  prifChngYn 
    		, Long  bscDdcnFpCnt 
    		, Long  sccNfpCnt 
    		, Long  chbtAdopNfpCnt 
    		, Long  wmnNfpCnt 
    		, Long  snprntNfpCnt 
    		, Long  dsbrNfpCnt 
    		, Long  age6ltNfpCnt
    		, String  fileSbtYn 
    		, String fileSbtNm
    		, String  fileAppYn 
    		, String  ddcFileSbtYn 
    		, String ddcFileSbtNm
    		, String  ddcFileAppYn 
    		, String  formCd 
    		, Long  issDtSeilNum 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr 
    		, String  commCd
    		, String  commNm 
     		, String  pdfDatAppYn){ 
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_YRTXBLGGYR,yrtxBlggYr);
     	values.put(ATTR_CLUTSEPTCD,clutSeptCd);
     	values.put(ATTR_SYSTEMKEY,systemkey);
     	values.put(ATTR_FNM,fnm);
     	values.put(ATTR_RESNOENCCNTN,resnoEncCntn);
     	values.put(ATTR_TNM,tnm);
     	values.put(ATTR_BSNOENCCNTN,bsnoEncCntn);
     	values.put(ATTR_HSHRCLCD,hshrClCd);
     	values.put(ATTR_RSPLNTNINFRNM,rsplNtnInfrNm);
     	values.put(ATTR_RSPLNTNINFRCD,rsplNtnInfrCd);
     	values.put(ATTR_DTYSTRTDT,dtyStrtDt);
     	values.put(ATTR_DTYENDDT,dtyEndDt);
     	values.put(ATTR_RESTRTDT,reStrtDt);
     	values.put(ATTR_REENDDT,reEndDt);
     	values.put(ATTR_RSDTCLCD,rsdtClCd);
     	values.put(ATTR_RSPLNTNNM,rsplNtnNm);
     	values.put(ATTR_RSPLNTNCD,rsplNtnCd);
     	values.put(ATTR_INCTXWHTXTXAMTMETNCD,inctxWhtxTxamtMetnCd);
     	values.put(ATTR_INPMYN,inpmYn);
     	values.put(ATTR_PRIFCHNGYN,prifChngYn);
     	values.put(ATTR_BSCDDCNFPCNT,bscDdcnFpCnt);
     	values.put(ATTR_SCCNFPCNT,sccNfpCnt);
     	values.put(ATTR_CHBTADOPNFPCNT,chbtAdopNfpCnt);
     	values.put(ATTR_WMNNFPCNT,wmnNfpCnt);
     	values.put(ATTR_SNPRNTNFPCNT,snprntNfpCnt);
     	values.put(ATTR_DSBRNFPCNT,dsbrNfpCnt);
     	values.put(ATTR_AGE6LTNFPCNT,age6ltNfpCnt);
     	values.put(ATTR_FILESBTYN,fileSbtYn);
     	values.put(ATTR_FILESBTNM, fileSbtNm);
     	values.put(ATTR_FILEAPPYN,fileAppYn);
     	values.put(ATTR_DDCFILESBTYN,ddcFileSbtYn);
     	values.put(ATTR_DDCFILESBTNM, ddcFileSbtNm);
     	values.put(ATTR_DDCFILEAPPYN,ddcFileAppYn);
     	values.put(ATTR_FORMCD,formCd);
     	values.put(ATTR_ISSDTSEILNUM,issDtSeilNum);
     	values.put(ATTR_KYBDR,kybdr);
     	values.put(ATTR_INPTDT,inptDt);
     	values.put(ATTR_INPTADDR,inptAddr);
     	values.put(ATTR_ISMT,ismt);
     	values.put(ATTR_REVNDT,revnDt);
     	values.put(ATTR_REVNADDR,revnAddr); 
     	values.put(ATTR_COMMCD,commCd);
     	values.put(ATTR_COMMNM,commNm);
     	values.put(ATTR_PDFDATAPPYN,pdfDatAppYn);} 

    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}
    /** set 귀속연도 : yrtxBlggYr */
    public void setYrtxBlggYr(String  yrtxBlggYr) { set( ATTR_YRTXBLGGYR ,yrtxBlggYr);}
    /** get 귀속연도 : yrtxBlggYr */
    public String  getYrtxBlggYr() { return (String )get( ATTR_YRTXBLGGYR );}
    /** set 연말정산구분코드 : clutSeptCd */
    public void setClutSeptCd(String  clutSeptCd) { set( ATTR_CLUTSEPTCD ,clutSeptCd);}
    /** get 연말정산구분코드 : clutSeptCd */
    public String  getClutSeptCd() { return (String )get( ATTR_CLUTSEPTCD );}
    
    /** set 연말정산구분코드 : clutSeptNm */
    public void setClutSeptNm(String  clutSeptNm) { set( ATTR_CLUTSEPTNM ,clutSeptNm);}
    /** get 연말정산구분코드 : clutSeptNm */
    public String  getClutSeptNm() { return (String )get( ATTR_CLUTSEPTNM );}  
    
    
    /** set SYSTEMKEY : systemkey */
    public void setSystemkey(String  systemkey) { set( ATTR_SYSTEMKEY ,systemkey);}
    /** get SYSTEMKEY : systemkey */
    public String  getSystemkey() { return (String )get( ATTR_SYSTEMKEY );}
    /** set 소득자성명 : fnm */
    public void setFnm(String  fnm) { set( ATTR_FNM ,fnm);}
    /** get 소득자성명 : fnm */
    public String  getFnm() { return (String )get( ATTR_FNM );}
    /** set 주민등록번호 : resnoEncCntn */
    public void setResnoEncCntn(String  resnoEncCntn) { set( ATTR_RESNOENCCNTN ,resnoEncCntn);}
    /** get 주민등록번호 : resnoEncCntn */
    public String  getResnoEncCntn() { return (String )get( ATTR_RESNOENCCNTN );}
    /** set 근무처명 : tnm */
    public void setTnm(String  tnm) { set( ATTR_TNM ,tnm);}
    /** get 근무처명 : tnm */
    public String  getTnm() { return (String )get( ATTR_TNM );}
    /** set 사업자등록번호 : bsnoEncCntn */
    public void setBsnoEncCntn(String  bsnoEncCntn) { set( ATTR_BSNOENCCNTN ,bsnoEncCntn);}
    /** get 사업자등록번호 : bsnoEncCntn */
    public String  getBsnoEncCntn() { return (String )get( ATTR_BSNOENCCNTN );}
    /** set 세대주여부 : hshrClCd */
    public void setHshrClCd(String  hshrClCd) { set( ATTR_HSHRCLCD ,hshrClCd);}
    /** get 세대주여부 : hshrClCd */
    public String  getHshrClCd() { return (String )get( ATTR_HSHRCLCD );}
    /** set 국적 : rsplNtnInfrNm */
    public void setRsplNtnInfrNm(String  rsplNtnInfrNm) { set( ATTR_RSPLNTNINFRNM ,rsplNtnInfrNm);}
    /** get 국적 : rsplNtnInfrNm */
    public String  getRsplNtnInfrNm() { return (String )get( ATTR_RSPLNTNINFRNM );}
    /** set 국적코드 : rsplNtnInfrCd */
    public void setRsplNtnInfrCd(String  rsplNtnInfrCd) { set( ATTR_RSPLNTNINFRCD ,rsplNtnInfrCd);}
    /** get 국적코드 : rsplNtnInfrCd */
    public String  getRsplNtnInfrCd() { return (String )get( ATTR_RSPLNTNINFRCD );}
    /** set 근무기간시작일자 : dtyStrtDt */
    public void setDtyStrtDt(String  dtyStrtDt) { set( ATTR_DTYSTRTDT ,dtyStrtDt);}
    /** get 근무기간시작일자 : dtyStrtDt */
    public String  getDtyStrtDt() { return (String )get( ATTR_DTYSTRTDT );}
    /** set 근무기간종료일자 : dtyEndDt */
    public void setDtyEndDt(String  dtyEndDt) { set( ATTR_DTYENDDT ,dtyEndDt);}
    /** get 근무기간종료일자 : dtyEndDt */
    public String  getDtyEndDt() { return (String )get( ATTR_DTYENDDT );}
    /** set 감면기간시작일자 : reStrtDt */
    public void setReStrtDt(String  reStrtDt) { set( ATTR_RESTRTDT ,reStrtDt);}
    /** get 감면기간시작일자 : reStrtDt */
    public String  getReStrtDt() { return (String )get( ATTR_RESTRTDT );}
    /** set 감면기간종료일자 : reEndDt */
    public void setReEndDt(String  reEndDt) { set( ATTR_REENDDT ,reEndDt);}
    /** get 감면기간종료일자 : reEndDt */
    public String  getReEndDt() { return (String )get( ATTR_REENDDT );}
    /** set 거주구분 : rsdtClCd */
    public void setRsdtClCd(String  rsdtClCd) { set( ATTR_RSDTCLCD ,rsdtClCd);}
    /** get 거주구분 : rsdtClCd */
    public String  getRsdtClCd() { return (String )get( ATTR_RSDTCLCD );}
    /** set 거주지국명 : rsplNtnNm */
    public void setRsplNtnNm(String  rsplNtnNm) { set( ATTR_RSPLNTNNM ,rsplNtnNm);}
    /** get 거주지국명 : rsplNtnNm */
    public String  getRsplNtnNm() { return (String )get( ATTR_RSPLNTNNM );}
    /** set 거주지코드 : rsplNtnCd */
    public void setRsplNtnCd(String  rsplNtnCd) { set( ATTR_RSPLNTNCD ,rsplNtnCd);}
    /** get 거주지코드 : rsplNtnCd */
    public String  getRsplNtnCd() { return (String )get( ATTR_RSPLNTNCD );}
    /** set 소득세원천징수세액조정구분코드 : inctxWhtxTxamtMetnCd */
    public void setInctxWhtxTxamtMetnCd(String  inctxWhtxTxamtMetnCd) { set( ATTR_INCTXWHTXTXAMTMETNCD ,inctxWhtxTxamtMetnCd);}
    /** get 소득세원천징수세액조정구분코드 : inctxWhtxTxamtMetnCd */
    public String  getInctxWhtxTxamtMetnCd() { return (String )get( ATTR_INCTXWHTXTXAMTMETNCD );}
    /** set 분납신청여부 : inpmYn */
    public void setInpmYn(String  inpmYn) { set( ATTR_INPMYN ,inpmYn);}
    /** get 분납신청여부 : inpmYn */
    public String  getInpmYn() { return (String )get( ATTR_INPMYN );}
    /** set 인적공제항목변동여부 : prifChngYn */
    public void setPrifChngYn(String  prifChngYn) { set( ATTR_PRIFCHNGYN ,prifChngYn);}
    /** get 인적공제항목변동여부 : prifChngYn */
    public String  getPrifChngYn() { return (String )get( ATTR_PRIFCHNGYN );}
    /** set 기본공제인원수 : bscDdcnFpCnt */
    public void setBscDdcnFpCnt(Long  bscDdcnFpCnt) { set( ATTR_BSCDDCNFPCNT ,bscDdcnFpCnt);}
    /** get 기본공제인원수 : bscDdcnFpCnt */
    public Long  getBscDdcnFpCnt() { return (Long )get( ATTR_BSCDDCNFPCNT );}
    /** set 경로우대인원수 : sccNfpCnt */
    public void setSccNfpCnt(Long  sccNfpCnt) { set( ATTR_SCCNFPCNT ,sccNfpCnt);}
    /** get 경로우대인원수 : sccNfpCnt */
    public Long  getSccNfpCnt() { return (Long )get( ATTR_SCCNFPCNT );}
    /** set 출산입양인원수 : chbtAdopNfpCnt */
    public void setChbtAdopNfpCnt(Long  chbtAdopNfpCnt) { set( ATTR_CHBTADOPNFPCNT ,chbtAdopNfpCnt);}
    /** get 출산입양인원수 : chbtAdopNfpCnt */
    public Long  getChbtAdopNfpCnt() { return (Long )get( ATTR_CHBTADOPNFPCNT );}
    /** set 부녀자인원수 : wmnNfpCnt */
    public void setWmnNfpCnt(Long  wmnNfpCnt) { set( ATTR_WMNNFPCNT ,wmnNfpCnt);}
    /** get 부녀자인원수 : wmnNfpCnt */
    public Long  getWmnNfpCnt() { return (Long )get( ATTR_WMNNFPCNT );}
    /** set 한부모인원수 : snprntNfpCnt */
    public void setSnprntNfpCnt(Long  snprntNfpCnt) { set( ATTR_SNPRNTNFPCNT ,snprntNfpCnt);}
    /** get 한부모인원수 : snprntNfpCnt */
    public Long  getSnprntNfpCnt() { return (Long )get( ATTR_SNPRNTNFPCNT );}
    /** set 자애인인원수 : dsbrNfpCnt */
    public void setDsbrNfpCnt(Long  dsbrNfpCnt) { set( ATTR_DSBRNFPCNT ,dsbrNfpCnt);}
    /** get 자애인인원수 : dsbrNfpCnt */
    public Long  getDsbrNfpCnt() { return (Long )get( ATTR_DSBRNFPCNT );}
    /** set 6세이하인원수 : age6ltNfpCnt */
    public void setAge6ltNfpCnt(Long  age6ltNfpCnt) { set( ATTR_AGE6LTNFPCNT ,age6ltNfpCnt);}
    /** get 6세이하인원수 : age6ltNfpCnt */
    public Long  getAge6ltNfpCnt() { return (Long )get( ATTR_AGE6LTNFPCNT );}
    /** set 소득공제신고전자파일제출여부 : fileSbtYn */
    public void setFileSbtYn(String  fileSbtYn) { set( ATTR_FILESBTYN ,fileSbtYn);}
    /** get 소득공제신고전자파일제출여부 : fileSbtYn */
    public String  getFileSbtYn() { return (String )get( ATTR_FILESBTYN );}
    /** set 소득공제신고전자파일제출구분 : fileSbtNm */
    public void setFileSbtNm(String  fileSbtNm) { set( ATTR_FILESBTNM ,fileSbtNm);}
    /** get 소득공제신고전자파일제출구분 : fileSbtNm */
    public String  getFileSbtNm() { return (String )get( ATTR_FILESBTNM );}
    /** set 소득공제신고전자파일적용여부 : fileAppYn */
    public void setFileAppYn(String  fileAppYn) { set( ATTR_FILEAPPYN ,fileAppYn);}
    /** get 소득공제신고전자파일적용여부 : fileAppYn */
    public String  getFileAppYn() { return (String )get( ATTR_FILEAPPYN );}
    
    /** set 공제신고서전자파일제출여부 : ddcFileSbtYn */
    public void setDdcFileSbtYn(String  ddcFileSbtYn) { set( ATTR_DDCFILESBTYN ,ddcFileSbtYn);}
    /** get 공제신고서전자파일제출여부 : ddcFileSbtYn */
    public String  getDdcFileSbtYn() { return (String )get( ATTR_DDCFILESBTYN );}
    /** set 공제신고서전자파일제출구분 : ddcFileSbtNm */
    public void setDdcFileSbtNm(String  ddcFileSbtNm) { set( ATTR_DDCFILESBTNM ,ddcFileSbtNm);}
    /** get 공제신고서전자파일제출구분 : ddcFileSbtNm */
    public String  getDdcFileSbtNm() { return (String )get( ATTR_DDCFILESBTNM );}
    /** set 공제신고서전자파일적용여부 : ddcFileAppYn */
    public void setDdcFileAppYn(String  ddcFileAppYn) { set( ATTR_DDCFILEAPPYN ,ddcFileAppYn);}
    /** get 공제신고서전자파일적용여부 : ddcFileAppYn */
    public String  getDdcFileAppYn() { return (String )get( ATTR_DDCFILEAPPYN );}
    
    /** set 서식코드 : formCd */
    public void setFormCd(String  formCd) { set( ATTR_FORMCD ,formCd);}
    /** get 서식코드 : formCd */
    public String  getFormCd() { return (String )get( ATTR_FORMCD );}
    /** set 발급일자일련번호 : issDtSeilNum */
    public void setIssDtSeilNum(Long  issDtSeilNum) { set( ATTR_ISSDTSEILNUM ,issDtSeilNum);}
    /** get 발급일자일련번호 : issDtSeilNum */
    public Long  getIssDtSeilNum() { return (Long )get( ATTR_ISSDTSEILNUM );}
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
    /** set 소득공제구분코드 : commCd */
    public void setCommCd(String  commCd) { set( ATTR_COMMCD ,commCd);}
    /** get 소득공제구분코드 : commCd */
    public String  getCommCd() { return (String )get( ATTR_COMMCD );}
    /** set 소득공제구분 : commNm */
    public void setCommNm(String  commNm) { set( ATTR_COMMNM ,commNm);}
    /** get 소득공제구분 : commNm */
    public String  getCommNm() { return (String )get( ATTR_COMMNM );}
    /** set 정산반영여부 : pdfDatAppYn */
    public void setPdfDatAppYn(String  pdfDatAppYn) { set( ATTR_PDFDATAPPYN ,pdfDatAppYn);}
    /** get 정산반영여부 : pdfDatAppYn */
    public String  getPdfDatAppYn() { return (String )get( ATTR_PDFDATAPPYN );}

}
