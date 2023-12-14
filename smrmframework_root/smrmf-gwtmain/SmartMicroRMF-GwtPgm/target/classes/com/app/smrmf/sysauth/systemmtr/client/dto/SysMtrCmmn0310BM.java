package com.app.smrmf.sysauth.systemmtr.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/** @author Hibernate CodeGenerator */
public class SysMtrCmmn0310BM  extends MSFSimpleBaseModel implements IsSerializable{
	 
	/** set 우편번호 : zpcd */
	public static final String ATTR_ZPCD = "zpcd";

	/** set 우편번호일련번호 : zpcdSeilNum */
	public static final String ATTR_ZPCDSEILNUM = "zpcdSeilNum";

	/** set 시도 : ctapv */
	public static final String ATTR_CTAPV = "ctapv";

	/** set 시군구 : ctatgu */
	public static final String ATTR_CTATGU = "ctatgu";

	/** set 읍면동 : tatd */
	public static final String ATTR_TATD = "tatd";

	/** set 리 : li */
	public static final String ATTR_LI = "li";

	/** set 도서 : bok */
	public static final String ATTR_BOK = "bok";

	/** set 산번지 : sanHusnum */
	public static final String ATTR_SANHUSNUM = "sanHusnum";

	/** set 시작번지_주 : bgnnMn */
	public static final String ATTR_BGNNMN = "bgnnMn";

	/** set 시작번주_부 : bgnnHusnumSb */
	public static final String ATTR_BGNNHUSNUMSB = "bgnnHusnumSb";

	/** set 끝번지_주 : endHusnumMn */
	public static final String ATTR_ENDHUSNUMMN = "endHusnumMn";

	/** set 끝번지_부 : endHusnumSb */
	public static final String ATTR_ENDHUSNUMSB = "endHusnumSb";

	/** set 건물명 : buildNm */
	public static final String ATTR_BUILDNM = "buildNm";

	/** set 건물시작동 : buildBgnnDong */
	public static final String ATTR_BUILDBGNNDONG = "buildBgnnDong";

	/** set 건물끝동 : buildEndDong */
	public static final String ATTR_BUILDENDDONG = "buildEndDong";

	/** set 전체주소 : whleAddr */
	public static final String ATTR_WHLEADDR = "whleAddr";

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
	 public SysMtrCmmn0310BM() { super(); } 

	/** 일괄등록 처리   */
	 public SysMtrCmmn0310BM(
			String zpcd 
			,String zpcdSeilNum 
			,String ctapv 
			,String ctatgu 
			,String tatd 
			,String li 
			,String bok 
			,String sanHusnum 
			,String bgnnMn 
			,String bgnnHusnumSb 
			,String endHusnumMn 
			,String endHusnumSb 
			,String buildNm 
			,String buildBgnnDong 
			,String buildEndDong 
			,String whleAddr 
			,String note  ) { 
	 	values.put(ATTR_ZPCD,zpcd);
	 	values.put(ATTR_ZPCDSEILNUM,zpcdSeilNum);
	 	values.put(ATTR_CTAPV,ctapv);
	 	values.put(ATTR_CTATGU,ctatgu);
	 	values.put(ATTR_TATD,tatd);
	 	values.put(ATTR_LI,li);
	 	values.put(ATTR_BOK,bok);
	 	values.put(ATTR_SANHUSNUM,sanHusnum);
	 	values.put(ATTR_BGNNMN,bgnnMn);
	 	values.put(ATTR_BGNNHUSNUMSB,bgnnHusnumSb);
	 	values.put(ATTR_ENDHUSNUMMN,endHusnumMn);
	 	values.put(ATTR_ENDHUSNUMSB,endHusnumSb);
	 	values.put(ATTR_BUILDNM,buildNm);
	 	values.put(ATTR_BUILDBGNNDONG,buildBgnnDong);
	 	values.put(ATTR_BUILDENDDONG,buildEndDong);
	 	values.put(ATTR_WHLEADDR,whleAddr);
	 	values.put(ATTR_NOTE,note);  } 

	/** set 우편번호 : zpcd */
	public void setZpcd(String zpcd) { set( ATTR_ZPCD ,zpcd);}
	/** get 우편번호 : zpcd */
	public String getZpcd() { return (String)get( ATTR_ZPCD );}

	/** set 우편번호일련번호 : zpcdSeilNum */
	public void setZpcdSeilNum(String zpcdSeilNum) { set( ATTR_ZPCDSEILNUM ,zpcdSeilNum);}
	/** get 우편번호일련번호 : zpcdSeilNum */
	public String getZpcdSeilNum() { return (String)get( ATTR_ZPCDSEILNUM );}

	/** set 시도 : ctapv */
	public void setCtapv(String ctapv) { set( ATTR_CTAPV ,ctapv);}
	/** get 시도 : ctapv */
	public String getCtapv() { return (String)get( ATTR_CTAPV );}

	/** set 시군구 : ctatgu */
	public void setCtatgu(String ctatgu) { set( ATTR_CTATGU ,ctatgu);}
	/** get 시군구 : ctatgu */
	public String getCtatgu() { return (String)get( ATTR_CTATGU );}

	/** set 읍면동 : tatd */
	public void setTatd(String tatd) { set( ATTR_TATD ,tatd);}
	/** get 읍면동 : tatd */
	public String getTatd() { return (String)get( ATTR_TATD );}

	/** set 리 : li */
	public void setLi(String li) { set( ATTR_LI ,li);}
	/** get 리 : li */
	public String getLi() { return (String)get( ATTR_LI );}

	/** set 도서 : bok */
	public void setBok(String bok) { set( ATTR_BOK ,bok);}
	/** get 도서 : bok */
	public String getBok() { return (String)get( ATTR_BOK );}

	/** set 산번지 : sanHusnum */
	public void setSanHusnum(String sanHusnum) { set( ATTR_SANHUSNUM ,sanHusnum);}
	/** get 산번지 : sanHusnum */
	public String getSanHusnum() { return (String)get( ATTR_SANHUSNUM );}

	/** set 시작번지_주 : bgnnMn */
	public void setBgnnMn(String bgnnMn) { set( ATTR_BGNNMN ,bgnnMn);}
	/** get 시작번지_주 : bgnnMn */
	public String getBgnnMn() { return (String)get( ATTR_BGNNMN );}

	/** set 시작번주_부 : bgnnHusnumSb */
	public void setBgnnHusnumSb(String bgnnHusnumSb) { set( ATTR_BGNNHUSNUMSB ,bgnnHusnumSb);}
	/** get 시작번주_부 : bgnnHusnumSb */
	public String getBgnnHusnumSb() { return (String)get( ATTR_BGNNHUSNUMSB );}

	/** set 끝번지_주 : endHusnumMn */
	public void setEndHusnumMn(String endHusnumMn) { set( ATTR_ENDHUSNUMMN ,endHusnumMn);}
	/** get 끝번지_주 : endHusnumMn */
	public String getEndHusnumMn() { return (String)get( ATTR_ENDHUSNUMMN );}

	/** set 끝번지_부 : endHusnumSb */
	public void setEndHusnumSb(String endHusnumSb) { set( ATTR_ENDHUSNUMSB ,endHusnumSb);}
	/** get 끝번지_부 : endHusnumSb */
	public String getEndHusnumSb() { return (String)get( ATTR_ENDHUSNUMSB );}

	/** set 건물명 : buildNm */
	public void setBuildNm(String buildNm) { set( ATTR_BUILDNM ,buildNm);}
	/** get 건물명 : buildNm */
	public String getBuildNm() { return (String)get( ATTR_BUILDNM );}

	/** set 건물시작동 : buildBgnnDong */
	public void setBuildBgnnDong(String buildBgnnDong) { set( ATTR_BUILDBGNNDONG ,buildBgnnDong);}
	/** get 건물시작동 : buildBgnnDong */
	public String getBuildBgnnDong() { return (String)get( ATTR_BUILDBGNNDONG );}

	/** set 건물끝동 : buildEndDong */
	public void setBuildEndDong(String buildEndDong) { set( ATTR_BUILDENDDONG ,buildEndDong);}
	/** get 건물끝동 : buildEndDong */
	public String getBuildEndDong() { return (String)get( ATTR_BUILDENDDONG );}

	/** set 전체주소 : whleAddr */
	public void setWhleAddr(String whleAddr) { set( ATTR_WHLEADDR ,whleAddr);}
	/** get 전체주소 : whleAddr */
	public String getWhleAddr() { return (String)get( ATTR_WHLEADDR );}

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
