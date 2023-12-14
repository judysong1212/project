package com.app.exterms.yearendtax.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Bass0100VO.java
 * @Description : Bass0100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.29
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Yeta2060_2019_VO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**  사업장코드 : dpobCd */
	private String dpobCd;

	/**  단위사업장코드 : utDpobCd */
	private String utDpobCd;

	/**  단위사업장명 : utDpobNm */
	private String utDpobNm;

	/**  상위단위사업장코드 : hhrkUntDpobCd */
	private String hhrkUntDpobCd;

	/**  대표자주민번호 : degtrResnRegnNum */
	private String degtrResnRegnNum;

	/**  대표자명 : degtrNm */
	private String degtrNm;

	/**  내외국인구분코드 : frgnrDivCd */
	private String frgnrDivCd;

	/**  사업자등록번호 : busoprRgstnNum */
	private String busoprRgstnNum;

	/**  법인등록번호 : corpRgstnNum */
	private String corpRgstnNum;

	/**  법인구분코드 : corpDivCd */
	private String corpDivCd;

	/**  단위사업장우편번호 : untDpobZpcd */
	private String untDpobZpcd;

	/**  단위사업장기본주소 : untDpobFndtnAddr */
	private String untDpobFndtnAddr;

	/**  단위사업장상세주소 : untDpobDtlPatrAddr */
	private String untDpobDtlPatrAddr;

	/**  단위사업장전화번호 : untDpobPhnNum */
	private String untDpobPhnNum;

	/**  단위사업장팩스번호 : untDpobFaxNum */
	private String untDpobFaxNum;

	/**  단위사업장전자우편주소 : untDpobEctnMailAddr */
	private String untDpobEctnMailAddr;

	/**  단위사업장업종_업태 : untDpobBncdsNm */
	private String untDpobBncdsNm;

	/**  단위사업장업종_종목명 : untDpobItemNm */
	private String untDpobItemNm;

	/**  단위사업장업종_주생산품 : untDpobMnPrdt */
	private String untDpobMnPrdt;

	/**  단위사업장설립일자 : untDpobEsbmDt */
	private String untDpobEsbmDt;

	/**  단위사업장개업일자 : untDpobIngnDt */
	private String untDpobIngnDt;

	/**  단위사업장폐업일자 : untDpobEobDt */
	private String untDpobEobDt;

	/**  단위사업장직인문구명 : untDpobSealWrdNm */
	private String untDpobSealWrdNm;

	/**  단위사업장직인경로 : untDpobSealRfta */
	private String untDpobSealRfta;

	/**  단위사업장직인파일명 : untDpobSealFlnm */
	private String untDpobSealFlnm;

	/**  단위사업장기본사용여부 : untDpobFndtnUseYn */
	private String untDpobFndtnUseYn;

	/**  입력자 : kybdr */
	private String kybdr;

	/**  입력일자 : inptDt */
	private String inptDt;

	/**  입력주소 : inptAddr */
	private String inptAddr;

	/**  수정자 : ismt */
	private String ismt;

	/**  수정일자 : revnDt */
	private String revnDt;

	/**  수정주소 : revnAddr */
	private String revnAddr;

	/**  주종사업장구분코드 */
	private String mtstBusinDivCd;

	/** 단위사업장승인번호 : upDpobCmpNo */
	private String upDpobCmpNo;

	/** C171_사업자단위과세자여부 : upDpobUtynC171 */
	private String upDpobUtynC171;

	/** C172_종사업장일련번호 : mtstDpobSeilNumC172 */
	private String mtstDpobSeilNumC172;

	/** 본지점구분코드 : mnbhDivCd */
	private String mnbhDivCd;

	/** 원천세신고유형구분코드 : whdgTxCtypDivCd */
	private String whdgTxCtypDivCd;	
	
	private String sysDivCd;	
	
	private String befBusoprRgstnNum;	
	
	public String getBefBusoprRgstnNum() {
		return befBusoprRgstnNum;
	}

	public void setBefBusoprRgstnNum(String befBusoprRgstnNum) {
		this.befBusoprRgstnNum = befBusoprRgstnNum;
	}

	public String getSysDivCd() {
		return sysDivCd;
	}

	public void setSysDivCd(String sysDivCd) {
		this.sysDivCd = sysDivCd;
	}
	
	public String getDpobCd() {
		return dpobCd;
	}

	public void setDpobCd(String dpobCd) {
		this.dpobCd = dpobCd;
	}

	public String getUtDpobCd() {
		return utDpobCd;
	}

	public void setUtDpobCd(String utDpobCd) {
		this.utDpobCd = utDpobCd;
	}

	public String getUtDpobNm() {
		return utDpobNm;
	}

	public void setUtDpobNm(String utDpobNm) {
		this.utDpobNm = utDpobNm;
	}

	public String getHhrkUntDpobCd() {
		return hhrkUntDpobCd;
	}

	public void setHhrkUntDpobCd(String hhrkUntDpobCd) {
		this.hhrkUntDpobCd = hhrkUntDpobCd;
	}

	public String getDegtrResnRegnNum() {
		return degtrResnRegnNum;
	}

	public void setDegtrResnRegnNum(String degtrResnRegnNum) {
		this.degtrResnRegnNum = degtrResnRegnNum;
	}

	public String getDegtrNm() {
		return degtrNm;
	}

	public void setDegtrNm(String degtrNm) {
		this.degtrNm = degtrNm;
	}

	public String getFrgnrDivCd() {
		return frgnrDivCd;
	}

	public void setFrgnrDivCd(String frgnrDivCd) {
		this.frgnrDivCd = frgnrDivCd;
	}

	public String getBusoprRgstnNum() {
		return busoprRgstnNum;
	}

	public void setBusoprRgstnNum(String busoprRgstnNum) {
		this.busoprRgstnNum = busoprRgstnNum;
	}

	public String getCorpRgstnNum() {
		return corpRgstnNum;
	}

	public void setCorpRgstnNum(String corpRgstnNum) {
		this.corpRgstnNum = corpRgstnNum;
	}

	public String getCorpDivCd() {
		return corpDivCd;
	}

	public void setCorpDivCd(String corpDivCd) {
		this.corpDivCd = corpDivCd;
	}

	public String getUntDpobZpcd() {
		return untDpobZpcd;
	}

	public void setUntDpobZpcd(String untDpobZpcd) {
		this.untDpobZpcd = untDpobZpcd;
	}

	public String getUntDpobFndtnAddr() {
		return untDpobFndtnAddr;
	}

	public void setUntDpobFndtnAddr(String untDpobFndtnAddr) {
		this.untDpobFndtnAddr = untDpobFndtnAddr;
	}

	public String getUntDpobDtlPatrAddr() {
		return untDpobDtlPatrAddr;
	}

	public void setUntDpobDtlPatrAddr(String untDpobDtlPatrAddr) {
		this.untDpobDtlPatrAddr = untDpobDtlPatrAddr;
	}

	public String getUntDpobPhnNum() {
		return untDpobPhnNum;
	}

	public void setUntDpobPhnNum(String untDpobPhnNum) {
		this.untDpobPhnNum = untDpobPhnNum;
	}

	public String getUntDpobFaxNum() {
		return untDpobFaxNum;
	}

	public void setUntDpobFaxNum(String untDpobFaxNum) {
		this.untDpobFaxNum = untDpobFaxNum;
	}

	public String getUntDpobEctnMailAddr() {
		return untDpobEctnMailAddr;
	}

	public void setUntDpobEctnMailAddr(String untDpobEctnMailAddr) {
		this.untDpobEctnMailAddr = untDpobEctnMailAddr;
	}

	public String getUntDpobBncdsNm() {
		return untDpobBncdsNm;
	}

	public void setUntDpobBncdsNm(String untDpobBncdsNm) {
		this.untDpobBncdsNm = untDpobBncdsNm;
	}

	public String getUntDpobItemNm() {
		return untDpobItemNm;
	}

	public void setUntDpobItemNm(String untDpobItemNm) {
		this.untDpobItemNm = untDpobItemNm;
	}

	public String getUntDpobMnPrdt() {
		return untDpobMnPrdt;
	}

	public void setUntDpobMnPrdt(String untDpobMnPrdt) {
		this.untDpobMnPrdt = untDpobMnPrdt;
	}

	public String getUntDpobEsbmDt() {
		return untDpobEsbmDt;
	}

	public void setUntDpobEsbmDt(String untDpobEsbmDt) {
		this.untDpobEsbmDt = untDpobEsbmDt;
	}

	public String getUntDpobIngnDt() {
		return untDpobIngnDt;
	}

	public void setUntDpobIngnDt(String untDpobIngnDt) {
		this.untDpobIngnDt = untDpobIngnDt;
	}

	public String getUntDpobEobDt() {
		return untDpobEobDt;
	}

	public void setUntDpobEobDt(String untDpobEobDt) {
		this.untDpobEobDt = untDpobEobDt;
	}

	public String getUntDpobSealWrdNm() {
		return untDpobSealWrdNm;
	}

	public void setUntDpobSealWrdNm(String untDpobSealWrdNm) {
		this.untDpobSealWrdNm = untDpobSealWrdNm;
	}

	public String getUntDpobSealRfta() {
		return untDpobSealRfta;
	}

	public void setUntDpobSealRfta(String untDpobSealRfta) {
		this.untDpobSealRfta = untDpobSealRfta;
	}

	public String getUntDpobSealFlnm() {
		return untDpobSealFlnm;
	}

	public void setUntDpobSealFlnm(String untDpobSealFlnm) {
		this.untDpobSealFlnm = untDpobSealFlnm;
	}

	public String getUntDpobFndtnUseYn() {
		return untDpobFndtnUseYn;
	}

	public void setUntDpobFndtnUseYn(String untDpobFndtnUseYn) {
		this.untDpobFndtnUseYn = untDpobFndtnUseYn;
	}

	public String getKybdr() {
		return kybdr;
	}

	public void setKybdr(String kybdr) {
		this.kybdr = kybdr;
	}

	public String getInptDt() {
		return inptDt;
	}

	public void setInptDt(String inptDt) {
		this.inptDt = inptDt;
	}

	public String getInptAddr() {
		return inptAddr;
	}

	public void setInptAddr(String inptAddr) {
		this.inptAddr = inptAddr;
	}

	public String getIsmt() {
		return ismt;
	}

	public void setIsmt(String ismt) {
		this.ismt = ismt;
	}

	public String getRevnDt() {
		return revnDt;
	}

	public void setRevnDt(String revnDt) {
		this.revnDt = revnDt;
	}

	public String getRevnAddr() {
		return revnAddr;
	}

	public void setRevnAddr(String revnAddr) {
		this.revnAddr = revnAddr;
	}

	public String getMtstBusinDivCd() {
		return mtstBusinDivCd;
	}

	public void setMtstBusinDivCd(String mtstBusinDivCd) {
		this.mtstBusinDivCd = mtstBusinDivCd;
	}

	public String getUpDpobCmpNo() {
		return upDpobCmpNo;
	}

	public void setUpDpobCmpNo(String upDpobCmpNo) {
		this.upDpobCmpNo = upDpobCmpNo;
	}

	public String getUpDpobUtynC171() {
		return upDpobUtynC171;
	}

	public void setUpDpobUtynC171(String upDpobUtynC171) {
		this.upDpobUtynC171 = upDpobUtynC171;
	}

	public String getMtstDpobSeilNumC172() {
		return mtstDpobSeilNumC172;
	}

	public void setMtstDpobSeilNumC172(String mtstDpobSeilNumC172) {
		this.mtstDpobSeilNumC172 = mtstDpobSeilNumC172;
	}

	public String getMnbhDivCd() {
		return mnbhDivCd;
	}

	public void setMnbhDivCd(String mnbhDivCd) {
		this.mnbhDivCd = mnbhDivCd;
	}

	public String getWhdgTxCtypDivCd() {
		return whdgTxCtypDivCd;
	}

	public void setWhdgTxCtypDivCd(String whdgTxCtypDivCd) {
		this.whdgTxCtypDivCd = whdgTxCtypDivCd;
	}	
	
}
