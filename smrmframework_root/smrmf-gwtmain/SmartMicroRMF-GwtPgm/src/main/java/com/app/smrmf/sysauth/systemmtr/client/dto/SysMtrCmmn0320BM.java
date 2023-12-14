package com.app.smrmf.sysauth.systemmtr.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/** @author Hibernate CodeGenerator */
public class SysMtrCmmn0320BM  extends MSFSimpleBaseModel implements IsSerializable{
	 
	/** set 우편번호 : zpcd */
	public static final String ATTR_ZPCD = "zpcd";

	/** set 우편번호일련번호 : zpcdSeilNum */
	public static final String ATTR_ZPCDSEILNUM = "zpcdSeilNum";

	/** set 건물번호본번 : buildNumBobn */
	public static final String ATTR_BUILDNUMBOBN = "buildNumBobn";

	/** set 건물번호부본 : buildNumBubn */
	public static final String ATTR_BUILDNUMBUBN = "buildNumBubn";

	/** set 시도 : ctapv */
	public static final String ATTR_CTAPV = "ctapv";

	/** set 시도영문 : ctapvEng */
	public static final String ATTR_CTAPVENG = "ctapvEng";

	/** set 시군구 : ctatgu */
	public static final String ATTR_CTATGU = "ctatgu";

	/** set 시군구영문 : ctatguEng */
	public static final String ATTR_CTATGUENG = "ctatguEng";

	/** set 읍면 : tat */
	public static final String ATTR_TAT = "tat";

	/** set 읍면영문 : tatEng */
	public static final String ATTR_TATENG = "tatEng";

	/** set 도로명코드 : roadNmCd */
	public static final String ATTR_ROADNMCD = "roadNmCd";

	/** set 도로명 : roadNm */
	public static final String ATTR_ROADNM = "roadNm";

	/** set 도로명영문 : roadNmEng */
	public static final String ATTR_ROADNMENG = "roadNmEng";

	/** set 지하여부 : ungrYn */
	public static final String ATTR_UNGRYN = "ungrYn";

	/** set 다량배달처명 : lotDsttnNm */
	public static final String ATTR_LOTDSTTNNM = "lotDsttnNm";

	/** set 법정동코드 : cutdogCd */
	public static final String ATTR_CUTDOGCD = "cutdogCd";

	/** set 법정동명 : cutdogNm */
	public static final String ATTR_CUTDOGNM = "cutdogNm";

	/** set 건물관리번호 : buildMangeNum */
	public static final String ATTR_BUILDMANGENUM = "buildMangeNum";

	/** set 비고 : note */
	public static final String ATTR_NOTE = "note";

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

	/** set 수정자주소 : revnAddr */
	public static final String ATTR_REVNADDR = "revnAddr";

	/** 생성자 */
	 public SysMtrCmmn0320BM() { super(); } 

	/** 일괄등록 처리   */
	 public SysMtrCmmn0320BM(
			String zpcd 
			,String zpcdSeilNum 
			,String buildNumBobn 
			,String buildNumBubn 
			,String ctapv 
			,String ctapvEng 
			,String ctatgu 
			,String ctatguEng 
			,String tat 
			,String tatEng 
			,String roadNmCd 
			,String roadNm 
			,String roadNmEng 
			,String ungrYn 
			,String lotDsttnNm 
			,String cutdogCd 
			,String cutdogNm 
			,String buildMangeNum 
			,String note   ) { 
	 	values.put(ATTR_ZPCD,zpcd);
	 	values.put(ATTR_ZPCDSEILNUM,zpcdSeilNum);
	 	values.put(ATTR_BUILDNUMBOBN,buildNumBobn);
	 	values.put(ATTR_BUILDNUMBUBN,buildNumBubn);
	 	values.put(ATTR_CTAPV,ctapv);
	 	values.put(ATTR_CTAPVENG,ctapvEng);
	 	values.put(ATTR_CTATGU,ctatgu);
	 	values.put(ATTR_CTATGUENG,ctatguEng);
	 	values.put(ATTR_TAT,tat);
	 	values.put(ATTR_TATENG,tatEng);
	 	values.put(ATTR_ROADNMCD,roadNmCd);
	 	values.put(ATTR_ROADNM,roadNm);
	 	values.put(ATTR_ROADNMENG,roadNmEng);
	 	values.put(ATTR_UNGRYN,ungrYn);
	 	values.put(ATTR_LOTDSTTNNM,lotDsttnNm);
	 	values.put(ATTR_CUTDOGCD,cutdogCd);
	 	values.put(ATTR_CUTDOGNM,cutdogNm);
	 	values.put(ATTR_BUILDMANGENUM,buildMangeNum);
	 	values.put(ATTR_NOTE,note);  } 

	/** set 우편번호 : zpcd */
	public void setZpcd(String zpcd) { set( ATTR_ZPCD ,zpcd);}
	/** get 우편번호 : zpcd */
	public String getZpcd() { return (String)get( ATTR_ZPCD );}

	/** set 우편번호일련번호 : zpcdSeilNum */
	public void setZpcdSeilNum(String zpcdSeilNum) { set( ATTR_ZPCDSEILNUM ,zpcdSeilNum);}
	/** get 우편번호일련번호 : zpcdSeilNum */
	public String getZpcdSeilNum() { return (String)get( ATTR_ZPCDSEILNUM );}

	/** set 건물번호본번 : buildNumBobn */
	public void setBuildNumBobn(String buildNumBobn) { set( ATTR_BUILDNUMBOBN ,buildNumBobn);}
	/** get 건물번호본번 : buildNumBobn */
	public String getBuildNumBobn() { return (String)get( ATTR_BUILDNUMBOBN );}

	/** set 건물번호부본 : buildNumBubn */
	public void setBuildNumBubn(String buildNumBubn) { set( ATTR_BUILDNUMBUBN ,buildNumBubn);}
	/** get 건물번호부본 : buildNumBubn */
	public String getBuildNumBubn() { return (String)get( ATTR_BUILDNUMBUBN );}

	/** set 시도 : ctapv */
	public void setCtapv(String ctapv) { set( ATTR_CTAPV ,ctapv);}
	/** get 시도 : ctapv */
	public String getCtapv() { return (String)get( ATTR_CTAPV );}

	/** set 시도영문 : ctapvEng */
	public void setCtapvEng(String ctapvEng) { set( ATTR_CTAPVENG ,ctapvEng);}
	/** get 시도영문 : ctapvEng */
	public String getCtapvEng() { return (String)get( ATTR_CTAPVENG );}

	/** set 시군구 : ctatgu */
	public void setCtatgu(String ctatgu) { set( ATTR_CTATGU ,ctatgu);}
	/** get 시군구 : ctatgu */
	public String getCtatgu() { return (String)get( ATTR_CTATGU );}

	/** set 시군구영문 : ctatguEng */
	public void setCtatguEng(String ctatguEng) { set( ATTR_CTATGUENG ,ctatguEng);}
	/** get 시군구영문 : ctatguEng */
	public String getCtatguEng() { return (String)get( ATTR_CTATGUENG );}

	/** set 읍면 : tat */
	public void setTat(String tat) { set( ATTR_TAT ,tat);}
	/** get 읍면 : tat */
	public String getTat() { return (String)get( ATTR_TAT );}

	/** set 읍면영문 : tatEng */
	public void setTatEng(String tatEng) { set( ATTR_TATENG ,tatEng);}
	/** get 읍면영문 : tatEng */
	public String getTatEng() { return (String)get( ATTR_TATENG );}

	/** set 도로명코드 : roadNmCd */
	public void setRoadNmCd(String roadNmCd) { set( ATTR_ROADNMCD ,roadNmCd);}
	/** get 도로명코드 : roadNmCd */
	public String getRoadNmCd() { return (String)get( ATTR_ROADNMCD );}

	/** set 도로명 : roadNm */
	public void setRoadNm(String roadNm) { set( ATTR_ROADNM ,roadNm);}
	/** get 도로명 : roadNm */
	public String getRoadNm() { return (String)get( ATTR_ROADNM );}

	/** set 도로명영문 : roadNmEng */
	public void setRoadNmEng(String roadNmEng) { set( ATTR_ROADNMENG ,roadNmEng);}
	/** get 도로명영문 : roadNmEng */
	public String getRoadNmEng() { return (String)get( ATTR_ROADNMENG );}

	/** set 지하여부 : ungrYn */
	public void setUngrYn(String ungrYn) { set( ATTR_UNGRYN ,ungrYn);}
	/** get 지하여부 : ungrYn */
	public String getUngrYn() { return (String)get( ATTR_UNGRYN );}

	/** set 다량배달처명 : lotDsttnNm */
	public void setLotDsttnNm(String lotDsttnNm) { set( ATTR_LOTDSTTNNM ,lotDsttnNm);}
	/** get 다량배달처명 : lotDsttnNm */
	public String getLotDsttnNm() { return (String)get( ATTR_LOTDSTTNNM );}

	/** set 법정동코드 : cutdogCd */
	public void setCutdogCd(String cutdogCd) { set( ATTR_CUTDOGCD ,cutdogCd);}
	/** get 법정동코드 : cutdogCd */
	public String getCutdogCd() { return (String)get( ATTR_CUTDOGCD );}

	/** set 법정동명 : cutdogNm */
	public void setCutdogNm(String cutdogNm) { set( ATTR_CUTDOGNM ,cutdogNm);}
	/** get 법정동명 : cutdogNm */
	public String getCutdogNm() { return (String)get( ATTR_CUTDOGNM );}

	/** set 건물관리번호 : buildMangeNum */
	public void setBuildMangeNum(String buildMangeNum) { set( ATTR_BUILDMANGENUM ,buildMangeNum);}
	/** get 건물관리번호 : buildMangeNum */
	public String getBuildMangeNum() { return (String)get( ATTR_BUILDMANGENUM );}

	/** set 비고 : note */
	public void setNote(String note) { set( ATTR_NOTE ,note);}
	/** get 비고 : note */
	public String getNote() { return (String)get( ATTR_NOTE );}

	/** set 입력자 : kybdr */
	public void setKybdr(String kybdr) { set( ATTR_KYBDR ,kybdr);}
	/** get 입력자 : kybdr */
	public String getKybdr() { return (String)get( ATTR_KYBDR );}

	/** set 입력일자 : inptDt */
	public void setInptDt(String inptDt) { set( ATTR_INPTDT ,inptDt);}
	/** get 입력일자 : inptDt */
	public String getInptDt() { return (String)get( ATTR_INPTDT );}

	/** set 입력주소 : inptAddr */
	public void setInptAddr(String inptAddr) { set( ATTR_INPTADDR ,inptAddr);}
	/** get 입력주소 : inptAddr */
	public String getInptAddr() { return (String)get( ATTR_INPTADDR );}

	/** set 수정자 : ismt */
	public void setIsmt(String ismt) { set( ATTR_ISMT ,ismt);}
	/** get 수정자 : ismt */
	public String getIsmt() { return (String)get( ATTR_ISMT );}

	/** set 수정일자 : revnDt */
	public void setRevnDt(String revnDt) { set( ATTR_REVNDT ,revnDt);}
	/** get 수정일자 : revnDt */
	public String getRevnDt() { return (String)get( ATTR_REVNDT );}

	/** set 수정자주소 : revnAddr */
	public void setRevnAddr(String revnAddr) { set( ATTR_REVNADDR ,revnAddr);}
	/** get 수정자주소 : revnAddr */
	public String getRevnAddr() { return (String)get( ATTR_REVNADDR );}



}
