package com.app.exterms.payroll.client.dto;



import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @Class Name : Payr0250VO.java
 * @Description : Payr0250 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Payr0250BM   extends MSFSimpleBaseModel implements IsSerializable  {
    private static final long serialVersionUID = 1L;
    
    /** set 단위기관코드 : payrMangDeptCd */
    public static final String ATTR_PAYRMANGDEPTCD = "payrMangDeptCd";
    
    
    /** set 단위기관 : payrMangDeptNm */
    public static final String ATTR_PAYRMANGDEPTNM = "payrMangDeptNm";


    /** set 급여스케줄일련번호 : payScduSeilNum */
    public static final String ATTR_PAYSCDUSEILNUM = "payScduSeilNum";

    /** set 급여구분코드 : payCd */
    public static final String ATTR_PAYCD = "payCd";
    

    /** set 급여구분 : payNm */
    public static final String ATTR_PAYNM = "payNm";

    /** set 고용구분코드 : emymtDivCd */
    public static final String ATTR_EMYMTDIVCD = "emymtDivCd";
    
    /** set 고용구분코드 : emymtDivNm */
    public static final String ATTR_EMYMTDIVNM = "emymtDivNm";

    /** set 사업장코드 : dpobCd */
    public static final String ATTR_DPOBCD = "dpobCd";

    /** set 부서코드 : deptCd */
    public static final String ATTR_DEPTCD = "deptCd";
    
    /** set 부서코드 : deptNm */
    public static final String ATTR_DEPTNM = "deptNm";

    /** set 사업코드 : businCd */
    public static final String ATTR_BUSINCD = "businCd";
    
    /** set 사업 : businNm */
    public static final String ATTR_BUSINNM = "businNm";

    /** set 담당직원번호 : pernChrgEmpIdenNum */
    public static final String ATTR_PERNCHRGEMPIDENNUM = "pernChrgEmpIdenNum";
    
    /** set 담당직원 : pernChrgEmpIdenNm */
    public static final String ATTR_PERNCHRGEMPIDENNM = "pernChrgEmpIdenNm";

    /** set 작업년월 : jobYrMnth */
    public static final String ATTR_JOBYRMNTH = "jobYrMnth";

    /** set 작업명 : jobNm */
    public static final String ATTR_JOBNM = "jobNm";

    /** set 지급일자 : pymtDt */
    public static final String ATTR_PYMTDT = "pymtDt";

    /** set 반영시작일자 : rflctnBgnnDt */
    public static final String ATTR_RFLCTNBGNNDT = "rflctnBgnnDt";

    /** set 반영종료일자 : rflctnEndDt */
    public static final String ATTR_RFLCTNENDDT = "rflctnEndDt";

    /** set 급여마감일자 : payDdlneDt */
    public static final String ATTR_PAYDDLNEDT = "payDdlneDt";

    /** set 지로파일생성일자 : groFlCretnDt */
    public static final String ATTR_GROFLCRETNDT = "groFlCretnDt";

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


	/** set 직종코드 : typOccuCd */
	public static final String ATTR_TYPOCCUCD = "typOccuCd";
	
	/** set 호봉등급코드 : pyspGrdeCd */
	public static final String ATTR_PYSPGRDECD = "pyspGrdeCd";
	
	
	/** set 직종코드 : typOccuNm */
	public static final String ATTR_TYPOCCUNM = "typOccuNm";
	
	/** set 호봉등급코드 : pyspGrdeNm */
	public static final String ATTR_PYSPGRDENM = "pyspGrdeNm";
	
	
	
	/** set 직종세통합코드 : dtilOccuInttnCd */
	public static final String ATTR_DTILOCCUINTTNCD = "dtilOccuInttnCd";


   /** set 직종세 : dtilOccuClsDivNm */
   public static final String ATTR_DTILOCCUCLSDIVNM = "dtilOccuClsDivNm";
   
   /** set 부서직종세그룹코드 : deptGpCd */
   public static final String ATTR_DEPTGPCD = "deptGpCd";

   /** set 호봉제구분코드 : repbtyBusinDivCd */
   public static final String ATTR_REPBTYBUSINDIVCD = "repbtyBusinDivCd";
   
   /** set 호봉제구분코드 : repbtyBusinDivCd */
   public static final String ATTR_REPBTYBUSINDIVNM = "repbtyBusinDivNm";
   

   /** 관리부서코드  mangeDeptCd */
   public static final String ATTR_MANGEDEPTCD = "mangeDeptCd";
   
   /** set 관리부서코드 : mangeDeptNm */
   public static final String ATTR_MANGEDEPTNM = "mangeDeptNm";
   
  


    /** 생성자 */
     public Payr0250BM() { super(); } 

    /** 일괄등록 처리   */
     public Payr0250BM(
    		 String  payrMangDeptCd 
    		, String  payrMangDeptNm 
    		, Long  payScduSeilNum 
    		, String  payCd 
    		, String  payNm
    		, String  emymtDivCd 
    		, String  emymtDivNm 
    		, String  dpobCd 
    		, String  deptCd 
    		, String  deptNm
    		, String  businCd 
    		, String  businNm
    		, String  pernChrgEmpIdenNum 
    		, String  jobYrMnth 
    		, String  jobNm 
    		, String  pymtDt 
    		, String  rflctnBgnnDt 
    		, String  rflctnEndDt 
    		, String  payDdlneDt 
    		, String  groFlCretnDt 
    		, String  kybdr 
    		, String  inptDt 
    		, String  inptAddr 
    		, String  ismt 
    		, String  revnDt 
    		, String  revnAddr 
    		, String  typOccuCd 
            , String  pyspGrdeCd) { 
     	values.put(ATTR_PAYRMANGDEPTCD,payrMangDeptCd);
    	values.put(ATTR_PAYRMANGDEPTNM,payrMangDeptNm);
     	values.put(ATTR_PAYSCDUSEILNUM,payScduSeilNum);
     	values.put(ATTR_PAYCD,payCd);
     	values.put(ATTR_PAYNM,payNm);
     	values.put(ATTR_EMYMTDIVCD,emymtDivCd);
     	values.put(ATTR_EMYMTDIVNM,emymtDivNm);
     	values.put(ATTR_DPOBCD,dpobCd);
     	values.put(ATTR_DEPTCD,deptCd);
     	values.put(ATTR_DEPTNM,deptNm);
     	values.put(ATTR_BUSINCD,businCd);
     	values.put(ATTR_BUSINNM,businNm);
     	values.put(ATTR_PERNCHRGEMPIDENNUM,pernChrgEmpIdenNum);
     	values.put(ATTR_JOBYRMNTH,jobYrMnth);
     	values.put(ATTR_JOBNM,jobNm);
     	values.put(ATTR_PYMTDT,pymtDt);
     	values.put(ATTR_RFLCTNBGNNDT,rflctnBgnnDt);
     	values.put(ATTR_RFLCTNENDDT,rflctnEndDt);
     	values.put(ATTR_PAYDDLNEDT,payDdlneDt);
     	values.put(ATTR_GROFLCRETNDT,groFlCretnDt);
     	values.put(ATTR_KYBDR,kybdr);
     	values.put(ATTR_INPTDT,inptDt);
     	values.put(ATTR_INPTADDR,inptAddr);
     	values.put(ATTR_ISMT,ismt);
     	values.put(ATTR_REVNDT,revnDt);
     	values.put(ATTR_REVNADDR,revnAddr);
     	values.put(ATTR_TYPOCCUCD,typOccuCd);
        values.put(ATTR_PYSPGRDECD,pyspGrdeCd);} 

    /** set 단위기관코드 : payrMangDeptCd */
    public void setPayrMangDeptCd(String  payrMangDeptCd) { set( ATTR_PAYRMANGDEPTCD ,payrMangDeptCd);}
    /** get 단위기관코드 : payrMangDeptCd */
    public String  getPayrMangDeptCd() { return (String )get( ATTR_PAYRMANGDEPTCD );}
    
    /** set 단위기관 : payrMangDeptNm */
    public void setPayrMangDeptNm(String  payrMangDeptNm) { set( ATTR_PAYRMANGDEPTNM ,payrMangDeptNm);}
    /** get 단위기관 : payrMangDeptNm */
    public String  getPayrMangDeptNm() { return (String )get( ATTR_PAYRMANGDEPTNM );}

    /** set 급여스케줄일련번호 : payScduSeilNum */
    public void setPayScduSeilNum(Long  payScduSeilNum) { set( ATTR_PAYSCDUSEILNUM ,payScduSeilNum);}
    /** get 급여스케줄일련번호 : payScduSeilNum */
    public Long  getPayScduSeilNum() { return (Long )get( ATTR_PAYSCDUSEILNUM );}

    /** set 급여구분코드 : payCd */
    public void setPayCd(String  payCd) { set( ATTR_PAYCD ,payCd);}
    /** get 급여구분코드 : payCd */
    public String  getPayCd() { return (String )get( ATTR_PAYCD );}
    
    /** set 급여구분 : payNm */
    public void setPayNm(String  payNm) { set( ATTR_PAYNM ,payNm);}
    /** get 급여구분 : payNm */
    public String  getPayNm() { return (String )get( ATTR_PAYNM );}

    /** set 고용구분코드 : emymtDivCd */
    public void setEmymtDivCd(String  emymtDivCd) { set( ATTR_EMYMTDIVCD ,emymtDivCd);}
    /** get 고용구분코드 : emymtDivCd */
    public String  getEmymtDivCd() { return (String )get( ATTR_EMYMTDIVCD );}

    /** set 고용구분 : emymtDivNm */
    public void setEmymtDivNm(String  emymtDivNm) { set( ATTR_EMYMTDIVNM ,emymtDivNm);}
    /** get 고용구분 : emymtDivNm */
    public String  getEmymtDivNm() { return (String )get( ATTR_EMYMTDIVNM );}
    
    /** set 사업장코드 : dpobCd */
    public void setDpobCd(String  dpobCd) { set( ATTR_DPOBCD ,dpobCd);}
    /** get 사업장코드 : dpobCd */
    public String  getDpobCd() { return (String )get( ATTR_DPOBCD );}

    /** set 부서코드 : deptCd */
    public void setDeptCd(String  deptCd) { set( ATTR_DEPTCD ,deptCd);}
    /** get 부서코드 : deptCd */
    public String  getDeptCd() { return (String )get( ATTR_DEPTCD );}

    /** set 사업코드 : businCd */
    public void setBusinCd(String  businCd) { set( ATTR_BUSINCD ,businCd);}
    /** get 사업코드 : businCd */
    public String  getBusinCd() { return (String )get( ATTR_BUSINCD );}


    /** set 부서 : deptNm */
    public void setDeptNm(String  deptNm) { set( ATTR_DEPTNM ,deptNm);}
    /** get 부서 : deptNm  */
    public String  getDeptNm() { return (String )get( ATTR_DEPTNM );}

    /** set 사업 : businNm */
    public void setBusinNm(String  businNm) { set( ATTR_BUSINNM ,businNm);}
    /** get 사업 : businNm */
    public String  getBusinNm() { return (String )get( ATTR_BUSINNM );}
    
    /** set 담당직원번호 : pernChrgEmpIdenNum */
    public void setPernChrgEmpIdenNum(String  pernChrgEmpIdenNum) { set( ATTR_PERNCHRGEMPIDENNUM ,pernChrgEmpIdenNum);}
    /** get 담당직원번호 : pernChrgEmpIdenNum */
    public String  getPernChrgEmpIdenNum() { return (String )get( ATTR_PERNCHRGEMPIDENNUM );}
    
    /** set 담당직원 : pernChrgEmpIdenNm */
    public void setPernChrgEmpIdenNm(String  pernChrgEmpIdenNm) { set( ATTR_PERNCHRGEMPIDENNM ,pernChrgEmpIdenNm);}
    /** get 담당직원번호 : pernChrgEmpIdenNm */
    public String  getPernChrgEmpIdenNm() { return (String )get( ATTR_PERNCHRGEMPIDENNM );}

    /** set 작업년월 : jobYrMnth */
    public void setJobYrMnth(String  jobYrMnth) { set( ATTR_JOBYRMNTH ,jobYrMnth);}
    /** get 작업년월 : jobYrMnth */
    public String  getJobYrMnth() { return (String )get( ATTR_JOBYRMNTH );}

    /** set 작업명 : jobNm */
    public void setJobNm(String  jobNm) { set( ATTR_JOBNM ,jobNm);}
    /** get 작업명 : jobNm */
    public String  getJobNm() { return (String )get( ATTR_JOBNM );}

    /** set 지급일자 : pymtDt */
    public void setPymtDt(String  pymtDt) { set( ATTR_PYMTDT ,pymtDt);}
    /** get 지급일자 : pymtDt */
    public String  getPymtDt() { return (String )get( ATTR_PYMTDT );}

    /** set 반영시작일자 : rflctnBgnnDt */
    public void setRflctnBgnnDt(String  rflctnBgnnDt) { set( ATTR_RFLCTNBGNNDT ,rflctnBgnnDt);}
    /** get 반영시작일자 : rflctnBgnnDt */
    public String  getRflctnBgnnDt() { return (String )get( ATTR_RFLCTNBGNNDT );}

    /** set 반영종료일자 : rflctnEndDt */
    public void setRflctnEndDt(String  rflctnEndDt) { set( ATTR_RFLCTNENDDT ,rflctnEndDt);}
    /** get 반영종료일자 : rflctnEndDt */
    public String  getRflctnEndDt() { return (String )get( ATTR_RFLCTNENDDT );}

    /** set 급여마감일자 : payDdlneDt */
    public void setPayDdlneDt(String  payDdlneDt) { set( ATTR_PAYDDLNEDT ,payDdlneDt);}
    /** get 급여마감일자 : payDdlneDt */
    public String  getPayDdlneDt() { return (String )get( ATTR_PAYDDLNEDT );}

    /** set 지로파일생성일자 : groFlCretnDt */
    public void setGroFlCretnDt(String  groFlCretnDt) { set( ATTR_GROFLCRETNDT ,groFlCretnDt);}
    /** get 지로파일생성일자 : groFlCretnDt */
    public String  getGroFlCretnDt() { return (String )get( ATTR_GROFLCRETNDT );}

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

	/** set 직종코드 : typOccuCd */
	public void setTypOccuCd(String  typOccuCd) { set( ATTR_TYPOCCUCD ,typOccuCd);}
	/** get 직종코드 : typOccuCd */
	public String  getTypOccuCd() { return (String )get( ATTR_TYPOCCUCD );}
	
	/** set 호봉등급코드 : pyspGrdeCd */
	public void setPyspGrdeCd(String  pyspGrdeCd) { set( ATTR_PYSPGRDECD ,pyspGrdeCd);}
	/** get 호봉등급코드 : pyspGrdeCd */
	public String  getPyspGrdeCd() { return (String )get( ATTR_PYSPGRDECD );}
	
	/** set 직종코드 : typOccuNm */
	public void setTypOccuNm(String  typOccuNm) { set( ATTR_TYPOCCUNM ,typOccuNm);}
	/** get 직종코드 : typOccuNm */
	public String  getTypOccuNm() { return (String )get( ATTR_TYPOCCUNM );}
	
	/** set 호봉등급코드 : pyspGrdeNm */
	public void setPyspGrdeNm(String  pyspGrdeNm) { set( ATTR_PYSPGRDENM ,pyspGrdeNm);}
	/** get 호봉등급코드 : pyspGrdeNm */
	public String  getPyspGrdeNm() { return (String )get( ATTR_PYSPGRDENM );}
	
	
	
	/** set 직종세통합코드 : dtilOccuInttnCd */
	public void setDtilOccuInttnCd(String  dtilOccuInttnCd) { set( ATTR_DTILOCCUINTTNCD ,dtilOccuInttnCd);}
	/** get 직종세통합코드 : dtilOccuInttnCd */
	public String  getDtilOccuInttnCd() { return (String )get( ATTR_DTILOCCUINTTNCD );}
	
	
	/** set 직종세 : dtilOccuClsDivNm */
	public void setDtilOccuClsDivNm(String  dtilOccuClsDivNm) { set( ATTR_DTILOCCUCLSDIVNM ,dtilOccuClsDivNm);}
	/** get 직종세 : dtilOccuClsDivNm */
	public String  getDtilOccuClsDivNm() { return (String )get( ATTR_DTILOCCUCLSDIVNM );}
	
	/** set 부서직종세그룹코드 : deptGpCd */
	public void setDeptGpCd(String  deptGpCd) { set( ATTR_DEPTGPCD ,deptGpCd);}
	/** get 부서직종세그룹코드 : deptGpCd */
	public String  getDeptGpCd() { return (String )get( ATTR_DEPTGPCD );}
	
	/** set 호봉제구분코드 : repbtyBusinDivCd */
	public void setRepbtyBusinDivCd(String  repbtyBusinDivCd) { set( ATTR_REPBTYBUSINDIVCD ,repbtyBusinDivCd);}
	/** get 호봉제구분코드 : repbtyBusinDivCd */
	public String  getRepbtyBusinDivCd() { return (String )get( ATTR_REPBTYBUSINDIVCD );}
	
	/** set 호봉제구분코드 : repbtyBusinDivCd */
	public void setRepbtyBusinDivNm(String  repbtyBusinDivNm) { set( ATTR_REPBTYBUSINDIVNM ,repbtyBusinDivNm);}
	/** get 호봉제구분코드 : repbtyBusinDivCd */
	public String  getRepbtyBusinDivNm() { return (String )get( ATTR_REPBTYBUSINDIVNM );}

	 /** 관리부서코드  mangeDeptCd */
	public void setMangeDeptCd(String  mangeDeptCd) { set( ATTR_MANGEDEPTCD ,mangeDeptCd);}
	 /** 관리부서코드  mangeDeptCd */
	public String  getMangeDeptCd() { return (String )get( ATTR_MANGEDEPTCD );}
	
	/** set 관리부서코드 : mangeDeptNm */
	public void setMangeDeptNm(String  mangeDeptNm) { set( ATTR_MANGEDEPTNM ,mangeDeptNm);}
	/** get 관리부서코드 : mangeDeptNm */
	public String  getMangeDeptNm() { return (String )get( ATTR_MANGEDEPTNM );}


}
