package com.app.exterms.insurance.client.dto;

import java.util.Date;

import com.extjs.gxt.ui.client.data.BaseModel;

/**
 * @Class Name : Insr0200VO.java
 * @Description : Insr0200 VO class
 * @Modification Information
 *
 * @author exterms
 * @since 2015.04.13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr0200DTO  extends BaseModel {
    
	private static final long serialVersionUID = 1L;

	public Insr0200DTO() {
	}

	/** set 사업장코드 : dpobCd */
	public void setDpobCd(String dpobCd) { set("dpobCd",dpobCd);}
	/** get 사업장코드 : dpobCd */
	public String getDpobCd() { return (String)get("dpobCd");}
	/** set 건강보험_기준년도 : hlthInsrStdYr */
	public void setHlthInsrStdYr(String hlthInsrStdYr) { set("hlthInsrStdYr",hlthInsrStdYr);}
	/** get 건강보험_기준년도 : hlthInsrStdYr */
	public String getHlthInsrStdYr() { return (String)get("hlthInsrStdYr");}
	/** set 건강보험_시작일자 : hlthInsrBgnnDt */
	public void setHlthInsrBgnnDt(Date hlthInsrBgnnDt) { set("hlthInsrBgnnDt",hlthInsrBgnnDt);}
	/** get 건강보험_시작일자 : hlthInsrBgnnDt */
	public Date getHlthInsrBgnnDt() { return get("hlthInsrBgnnDt");}
	/** set 건강보험_최저보수월액 : hlthInsrMinmMnthRuntnAmnt */
	public void setHlthInsrMinmMnthRuntnAmnt(String hlthInsrMinmMnthRuntnAmnt) { set("hlthInsrMinmMnthRuntnAmnt",hlthInsrMinmMnthRuntnAmnt);}
	/** get 건강보험_최저보수월액 : hlthInsrMinmMnthRuntnAmnt */
	public String getHlthInsrMinmMnthRuntnAmnt() { return (String)get("hlthInsrMinmMnthRuntnAmnt");}
	/** set 건강보험_최고보수월액 : hlthInsrBstMnthRuntnAmnt */
	public void setHlthInsrBstMnthRuntnAmnt(String hlthInsrBstMnthRuntnAmnt) { set("hlthInsrBstMnthRuntnAmnt",hlthInsrBstMnthRuntnAmnt);}
	/** get 건강보험_최고보수월액 : hlthInsrBstMnthRuntnAmnt */
	public String getHlthInsrBstMnthRuntnAmnt() { return (String)get("hlthInsrBstMnthRuntnAmnt");}
	/** set 건강보험사용자부담요율 : hlthInsrUsrBrdnApmrt */
	public void setHlthInsrUsrBrdnApmrt(String hlthInsrUsrBrdnApmrt) { set("hlthInsrUsrBrdnApmrt",hlthInsrUsrBrdnApmrt);}
	/** get 건강보험사용자부담요율 : hlthInsrUsrBrdnApmrt */
	public String getHlthInsrUsrBrdnApmrt() { return (String)get("hlthInsrUsrBrdnApmrt");}
	/** set 건강보험본인부담요율 : hlthInsrHmlfBrdnApmrt */
	public void setHlthInsrHmlfBrdnApmrt(String hlthInsrHmlfBrdnApmrt) { set("hlthInsrHmlfBrdnApmrt",hlthInsrHmlfBrdnApmrt);}
	/** get 건강보험본인부담요율 : hlthInsrHmlfBrdnApmrt */
	public String getHlthInsrHmlfBrdnApmrt() { return (String)get("hlthInsrHmlfBrdnApmrt");}
	/** set 건강보험_요양사용자부담요율 : hlthRcptnUsrBrdnApmrt */
	public void setHlthRcptnUsrBrdnApmrt(String hlthRcptnUsrBrdnApmrt) { set("hlthRcptnUsrBrdnApmrt",hlthRcptnUsrBrdnApmrt);}
	/** get 건강보험_요양사용자부담요율 : hlthRcptnUsrBrdnApmrt */
	public String getHlthRcptnUsrBrdnApmrt() { return (String)get("hlthRcptnUsrBrdnApmrt");}
	/** set 건강보험_요양본인부담요율 : hlthRcptnHmlfBrdnApmrt */
	public void setHlthRcptnHmlfBrdnApmrt(String hlthRcptnHmlfBrdnApmrt) { set("hlthRcptnHmlfBrdnApmrt",hlthRcptnHmlfBrdnApmrt);}
	/** get 건강보험_요양본인부담요율 : hlthRcptnHmlfBrdnApmrt */
	public String getHlthRcptnHmlfBrdnApmrt() { return (String)get("hlthRcptnHmlfBrdnApmrt");}
	/** set 건강보험_종료일자 : hlthInsrEndDt */
	public void setHlthInsrEndDt(Date hlthInsrEndDt) { set("hlthInsrEndDt",hlthInsrEndDt);}
	/** get 건강보험_종료일자 : hlthInsrEndDt */
	public Date getHlthInsrEndDt() { return get("hlthInsrEndDt");}
	
	/** set 국민연금_기준년도 : natPennStdYr */
	public void setNatPennStdYr(String natPennStdYr) { set("natPennStdYr",natPennStdYr);}
	/** get 국민연금_기준년도 : natPennStdYr */
	public String getNatPennStdYr() { return (String)get("natPennStdYr");}
	/** set 국민연금_시작일자 : natPennBgnnDt */
	public void setNatPennBgnnDt(Date natPennBgnnDt) { set("natPennBgnnDt",natPennBgnnDt);}
	/** get 국민연금_시작일자 : natPennBgnnDt */
	public Date getNatPennBgnnDt() { return get("natPennBgnnDt");}
	/** set 국민연금_종료일자 : natPennEndDt */
	public void setNatPennEndDt(Date natPennEndDt) { set("natPennEndDt",natPennEndDt);}
	/** get 국민연금_종료일자 : natPennEndDt */
	public Date getNatPennEndDt() { return get("natPennEndDt");}
	/** set 국민연금최저소득월액 : natPennMinmIncmMnthAmnt */
	public void setNatPennMinmIncmMnthAmnt(String natPennMinmIncmMnthAmnt) { set("natPennMinmIncmMnthAmnt",natPennMinmIncmMnthAmnt);}
	/** get 국민연금최저소득월액 : natPennMinmIncmMnthAmnt */
	public String getNatPennMinmIncmMnthAmnt() { return (String)get("natPennMinmIncmMnthAmnt");}
	/** set 국민연금최고소득월액 : natPennBstIncmMnthAmnt */
	public void setNatPennBstIncmMnthAmnt(String natPennBstIncmMnthAmnt) { set("natPennBstIncmMnthAmnt",natPennBstIncmMnthAmnt);}
	/** get 국민연금최고소득월액 : natPennBstIncmMnthAmnt */
	public String getNatPennBstIncmMnthAmnt() { return (String)get("natPennBstIncmMnthAmnt");}
	/** set 국민연금사용자부담요율 : natPennUsrBrdnApmrt */
	public void setNatPennUsrBrdnApmrt(String natPennUsrBrdnApmrt) { set("natPennUsrBrdnApmrt",natPennUsrBrdnApmrt);}
	/** get 국민연금사용자부담요율 : natPennUsrBrdnApmrt */
	public String getNatPennUsrBrdnApmrt() { return (String)get("natPennUsrBrdnApmrt");}
	/** set 국인연금본인부담요율 : natPennHmlfBrdnApmrt */
	public void setNatPennHmlfBrdnApmrt(String natPennHmlfBrdnApmrt) { set("natPennHmlfBrdnApmrt",natPennHmlfBrdnApmrt);}
	/** get 국인연금본인부담요율 : natPennHmlfBrdnApmrt */
	public String getNatPennHmlfBrdnApmrt() { return (String)get("natPennHmlfBrdnApmrt");}
	
	/** set 고용보험_기준년도 : umytInsrStdYr */
	public void setUmytInsrStdYr(String umytInsrStdYr) { set("umytInsrStdYr",umytInsrStdYr);}
	/** get 고용보험_기준년도 : umytInsrStdYr */
	public String getUmytInsrStdYr() { return (String)get("umytInsrStdYr");}
	/** set 고용보험시작일자 : umytInsrBgnnDt */
	public void setUmytInsrBgnnDt(Date umytInsrBgnnDt) { set("umytInsrBgnnDt",umytInsrBgnnDt);}
	/** get 고용보험시작일자 : umytInsrBgnnDt */
	public Date getUmytInsrBgnnDt() { return get("umytInsrBgnnDt");}
	/** set 고용보험_최저보수월액 : umytInsrMinmIncmMnthAmnt */
	public void setUmytInsrMinmIncmMnthAmnt(String umytInsrMinmIncmMnthAmnt) { set("umytInsrMinmIncmMnthAmnt",umytInsrMinmIncmMnthAmnt);}
	/** get 고용보험_최저보수월액 : umytInsrMinmIncmMnthAmnt */
	public String getUmytInsrMinmIncmMnthAmnt() { return (String)get("umytInsrMinmIncmMnthAmnt");}
	/** set 고용보험_최고보수월액 : umytInsrBstIncmMnthAmnt */
	public void setUmytInsrBstIncmMnthAmnt(String umytInsrBstIncmMnthAmnt) { set("umytInsrBstIncmMnthAmnt",umytInsrBstIncmMnthAmnt);}
	/** get 고용보험_최고보수월액 : umytInsrBstIncmMnthAmnt */
	public String getUmytInsrBstIncmMnthAmnt() { return (String)get("umytInsrBstIncmMnthAmnt");}
	/** set 고용보험본인부담요율 : umytInsrHmlfBrdnApmrt */
	public void setUmytInsrHmlfBrdnApmrt(String umytInsrHmlfBrdnApmrt) { set("umytInsrHmlfBrdnApmrt",umytInsrHmlfBrdnApmrt);}
	/** get 고용보험본인부담요율 : umytInsrHmlfBrdnApmrt */
	public String getUmytInsrHmlfBrdnApmrt() { return (String)get("umytInsrHmlfBrdnApmrt");}
	/** set 고용보험사용자부담요율 : umytInsrUsrBrdnApmrt */
	public void setUmytInsrUsrBrdnApmrt(String umytInsrUsrBrdnApmrt) { set("umytInsrUsrBrdnApmrt",umytInsrUsrBrdnApmrt);}
	/** get 고용보험사용자부담요율 : umytInsrUsrBrdnApmrt */
	public String getUmytInsrUsrBrdnApmrt() { return (String)get("umytInsrUsrBrdnApmrt");}
	/** set 고용보험사용자_고용안정등사업요율 : umytInsrUsrSftyEbisApmrt */
	public void setUmytInsrUsrSftyEbisApmrt(String umytInsrUsrSftyEbisApmrt) { set("umytInsrUsrSftyEbisApmrt",umytInsrUsrSftyEbisApmrt);}
	/** get 고용보험사용자_고용안정등사업요율 : umytInsrUsrSftyEbisApmrt */
	public String getUmytInsrUsrSftyEbisApmrt() { return (String)get("umytInsrUsrSftyEbisApmrt");}
	/** set 고용보험종료일자 : umytInsrEndDt */
	public void setUmytInsrEndDt(Date umytInsrEndDt) { set("umytInsrEndDt",umytInsrEndDt);}
	/** get 고용보험종료일자 : umytInsrEndDt */
	public Date getUmytInsrEndDt() { return get("umytInsrEndDt");}
	
	/** set 산재보험_기준년도 : idtlAccdtInsurStdYr */
	public void setIdtlAccdtInsurStdYr(String idtlAccdtInsurStdYr) { set("idtlAccdtInsurStdYr",idtlAccdtInsurStdYr);}
	/** get 산재보험_기준년도 : idtlAccdtInsurStdYr */
	public String getIdtlAccdtInsurStdYr() { return (String)get("idtlAccdtInsurStdYr");}
	/** set 산재보험시작일자 : idtlAccdtInsurBgnnDt */
	public void setIdtlAccdtInsurBgnnDt(Date idtlAccdtInsurBgnnDt) { set("idtlAccdtInsurBgnnDt",idtlAccdtInsurBgnnDt);}
	/** get 산재보험시작일자 : idtlAccdtInsurBgnnDt */
	public Date getIdtlAccdtInsurBgnnDt() { return get("idtlAccdtInsurBgnnDt");}
	/** set 산재보험사용자부담요율 : idtlAccdtInsurUsrApmrt */
	public void setIdtlAccdtInsurUsrApmrt(String idtlAccdtInsurUsrApmrt) { set("idtlAccdtInsurUsrApmrt",idtlAccdtInsurUsrApmrt);}
	/** get 산재보험사용자부담요율 : idtlAccdtInsurUsrApmrt */
	public String getIdtlAccdtInsurUsrApmrt() { return (String)get("idtlAccdtInsurUsrApmrt");}
	/** set 산재보험종료일자 : idtlAccdtInsurEndDt */
	public void setIdtlAccdtInsurEndDt(Date idtlAccdtInsurEndDt) { set("idtlAccdtInsurEndDt",idtlAccdtInsurEndDt);}
	/** get 산재보험종료일자 : idtlAccdtInsurEndDt */
	public Date getIdtlAccdtInsurEndDt() { return get("idtlAccdtInsurEndDt");}
	/** set 입력자 : kybdr */
	public void setKybdr(String kybdr) { set("kybdr",kybdr);}
	/** get 입력자 : kybdr */
	public String getKybdr() { return (String)get("kybdr");}
	/** set 입력일자 : inptDt */
	public void setInptDt(String inptDt) { set("inptDt",inptDt);}
	/** get 입력일자 : inptDt */
	public String getInptDt() { return (String)get("inptDt");}
	/** set 입력주소 : inptAddr */
	public void setInptAddr(String inptAddr) { set("inptAddr",inptAddr);}
	/** get 입력주소 : inptAddr */
	public String getInptAddr() { return (String)get("inptAddr");}
	/** set 수정자 : ismt */
	public void setIsmt(String ismt) { set("ismt",ismt);}
	/** get 수정자 : ismt */
	public String getIsmt() { return (String)get("ismt");}
	/** set 수정일자 : revnDt */
	public void setRevnDt(String revnDt) { set("revnDt",revnDt);}
	/** get 수정일자 : revnDt */
	public String getRevnDt() { return (String)get("revnDt");}
	/** set 수정주소 : revnAddr */
	public void setRevnAddr(String revnAddr) { set("revnAddr",revnAddr);}
	/** get 수정주소 : revnAddr */
	public String getRevnAddr() { return (String)get("revnAddr");}

}
