package com.app.exterms.yearendtax.client.dto.yeta2021;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

public class PdfQ101yBM extends MSFSimpleBaseModel implements IsSerializable {
	private static final long serialVersionUID = 1L;

	/** set 사업장코드 : dpobCd */
	public static final String ATTR_DPOBCD = "dpobCd";

	public static final String ATTR_YRTXBLGGYR = "yrtxBlggYr";

	/** set 연말정산구분코드 : clutSeptCd */
	public static final String ATTR_CLUTSEPTCD = "clutSeptCd";

	/** set SYSTEMKEY : systemkey */
	public static final String ATTR_SYSTEMKEY = "systemkey";

	/** set 자료코드 : datCd */
	public static final String ATTR_DATCD = "datCd";

	/** set 서식코드 : formCd */
	public static final String ATTR_FORMCD = "formCd";

	/** set 주민등록번호 : resid */
	public static final String ATTR_RESID = "resid";

	/** set 성명 : name */
	public static final String ATTR_NAME = "name";

	/** set 사업자번호 : busnid */
	public static final String ATTR_BUSNID = "busnid";

	/** set 투자기관 : tradeNm */
	public static final String ATTR_TRADENM = "tradeNm";

	/** set 계좌번호 : secuNo */
	public static final String ATTR_SECUNO = "secuNo";

	/** set 투자신탁명: fundNm */
	public static final String ATTR_FUNDNM = "fundNm";

	/** set 납입연도: regDt */
	public static final String ATTR_REGDT = "regDt";

	/** set 벤처조합구분코드: vntAsctClCd */
	public static final String ATTR_VNTASCTCLCD = "vntAsctClCd";

	/** set 금융기관코드(1:조합 등, 2:벤처 등): comCd */
	public static final String ATTR_COMCD = "comCd";

	/** set 연간합계액 : vntSum */
	public static final String ATTR_VNTSUM = "vntSum";

	/** set pdf 소득공제자료적용여부 : pdfDatAppYn */
	public static final String ATTR_PDFDATAPPYN = "pdfDatAppYn";

	/** set pdf 소득공제자료적용일자 : pdfDatAppCmplDt */
	public static final String ATTR_PDFDATAPPCMPLDT = "pdfDatAppCmplDt";

	/** set pdf 소득공제자료제외사유내용 : pdfDatAppExcCtnt */
	public static final String ATTR_PDFDATAPPEXCCTNT = "pdfDatAppExcCtnt";

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
	public PdfQ101yBM() {
		super();

	}

	/** 일괄등록 처리 */
	public PdfQ101yBM(String dpobCd, String yrtxBlggYr, String clutSeptCd,
			String systemkey, String datCd, String formCd, String resid,
			String name, String busnid, String tradeNm, String secuNo,
			String fundNm, String regDt, String vntAsctClCd, String comCd,
			Long vntSum, String pdfDatAppYn, String pdfDatAppCmplDt,
			String pdfDatAppExcCtnt, String kybdr, String inptDt,
			String inptAddr, String ismt, String revnDt, String revnAddr) {
		values.put(ATTR_DPOBCD, dpobCd);
		values.put(ATTR_YRTXBLGGYR, yrtxBlggYr);
		values.put(ATTR_CLUTSEPTCD, clutSeptCd);
		values.put(ATTR_SYSTEMKEY, systemkey);
		values.put(ATTR_DATCD, datCd);
		values.put(ATTR_FORMCD, formCd);
		values.put(ATTR_RESID, resid);
		values.put(ATTR_NAME, name);
		values.put(ATTR_BUSNID, busnid);
		values.put(ATTR_TRADENM, tradeNm);
		values.put(ATTR_SECUNO, secuNo);
		values.put(ATTR_FUNDNM, fundNm);
		values.put(ATTR_REGDT, regDt);
		values.put(ATTR_VNTASCTCLCD, vntAsctClCd);
		values.put(ATTR_COMCD, comCd);
		values.put(ATTR_VNTSUM, vntSum);
		values.put(ATTR_PDFDATAPPYN, pdfDatAppYn);
		values.put(ATTR_PDFDATAPPCMPLDT, pdfDatAppCmplDt);
		values.put(ATTR_PDFDATAPPEXCCTNT, pdfDatAppExcCtnt);
		values.put(ATTR_KYBDR, kybdr);
		values.put(ATTR_INPTDT, inptDt);
		values.put(ATTR_INPTADDR, inptAddr);
		values.put(ATTR_ISMT, ismt);
		values.put(ATTR_REVNDT, revnDt);
		values.put(ATTR_REVNADDR, revnAddr);
	}

	/** set 사업장코드 : dpobCd */
	public void setDpobCd(String dpobCd) {
		set(ATTR_DPOBCD, dpobCd);
	}

	/** get 사업장코드 : dpobCd */
	public String getDpobCd() {
		return (String) get(ATTR_DPOBCD);
	}

	/** set 귀속년도 : yrtxBlggYr */
	public void setYrtxBlggYr(String yrtxBlggYr) {
		set(ATTR_YRTXBLGGYR, yrtxBlggYr);
	}

	/** get 귀속년도 : yrtxBlggYr */
	public String getYrtxBlggYr() {
		return (String) get(ATTR_YRTXBLGGYR);
	}

	/** set 연말정산구분코드 : clutSeptCd */
	public void setClutSeptCd(String clutSeptCd) {
		set(ATTR_CLUTSEPTCD, clutSeptCd);
	}

	/** get 연말정산구분코드 : clutSeptCd */
	public String getClutSeptCd() {
		return (String) get(ATTR_CLUTSEPTCD);
	}

	/** set SYSTEMKEY : systemkey */
	public void setSystemkey(String systemkey) {
		set(ATTR_SYSTEMKEY, systemkey);
	}

	/** get SYSTEMKEY : systemkey */
	public String getSystemkey() {
		return (String) get(ATTR_SYSTEMKEY);
	}

	/** set 자료코드 : datCd */
	public void setDatCd(String datCd) {
		set(ATTR_DATCD, datCd);
	}

	/** get 자료코드 : datCd */
	public String getDatCd() {
		return (String) get(ATTR_DATCD);
	}

	/** set 서식코드 : formCd */
	public void setFormCd(String formCd) {
		set(ATTR_FORMCD, formCd);
	}

	/** get 서식코드 : formCd */
	public String getFormCd() {
		return (String) get(ATTR_FORMCD);
	}

	/** set 월세액 주민등록번호 : resid */
	public void setResid(String resid) {
		set(ATTR_RESID, resid);
	}

	/** get 월세액 주민등록번호 : resid */
	public String getResid() {
		return (String) get(ATTR_RESID);
	}

	/** set 월세액 성명 : name */
	public void setName(String name) {
		set(ATTR_NAME, name);
	}

	/** get 월세액 성명 : name */
	public String getName() {
		return (String) get(ATTR_NAME);
	}

	/** set 월세액 사업자번호 : busnid */
	public void setBusnid(String busnid) {
		set(ATTR_BUSNID, busnid);
	}

	/** get 월세액 사업자번호 : busnid */
	public String getBusnid() {
		return (String) get(ATTR_BUSNID);
	}

	/** set 투자기관 : tradeNm */
	public void setTradeNm(String tradeNm) {
		set(ATTR_TRADENM, tradeNm);
	}

	/** get 투자기관 : tradeNm */
	public String getTradeNm() {
		return (String) get(ATTR_TRADENM);
	}

	/** set 계좌번호 : secuNo */
	public void setSecuNo(String secuNo) {
		set(ATTR_SECUNO, secuNo);
	}

	/** get 계좌번호 : secuNo */
	public String getSecuNo() {
		return (String) get(ATTR_SECUNO);
	}

	/** set 투자신탁명: fundNm */
	public void setFundNm(String fundNm) {
		set(ATTR_FUNDNM, fundNm);
	}

	/** get 투자신탁명: fundNm */
	public String getFundNm() {
		return (String) get(ATTR_FUNDNM);
	}

	/** set 납입연도: regDt */
	public void getRegDt(String regDt) {
		set(ATTR_REGDT, regDt);
	}

	/** get 납입연도: regDt */
	public String setRegDt() {
		return (String) get(ATTR_REGDT);
	}

	/** set pdf 벤처조합구분코드: vntAsctClCd */
	public void setVntAsctClCd(String vntAsctClCd) {
		set(ATTR_VNTASCTCLCD, vntAsctClCd);
	}

	/** get 벤처조합구분코드: vntAsctClCd */
	public String getVntAsctClCd() {
		return (String) get(ATTR_VNTASCTCLCD);
	}

	/** set 금융기관코드(1:조합 등, 2:벤처 등): comCd */
	public void setComCd(String comCd) {
		set(ATTR_COMCD, comCd);
	}

	/** get 금융기관코드(1:조합 등, 2:벤처 등): comCd */
	public String getComCd() {
		return (String) get(ATTR_COMCD);
	}

	/** set 연간합계액 : vntSum */
	public void setVntSum(Long vntSum) {
		set(ATTR_VNTSUM, vntSum);
	}

	/** get 연간합계액 : vntSum */
	public Long getVntSum() {
		return (Long) get(ATTR_VNTSUM);
	}

	/** set pdf 소득공제자료적용여부 : pdfDatAppYn */
	public void setPdfDatAppYn(String pdfDatAppYn) {
		set(ATTR_PDFDATAPPYN, pdfDatAppYn);
	}

	/** get pdf 소득공제자료적용여부 : pdfDatAppYn */
	public String getPdfDatAppYn() {
		return (String) get(ATTR_PDFDATAPPYN);
	}

	/** set pdf 소득공제자료적용일자 : pdfDatAppCmplDt */
	public void setPdfDatAppCmplDt(String pdfDatAppCmplDt) {
		set(ATTR_PDFDATAPPCMPLDT, pdfDatAppCmplDt);
	}

	/** get pdf 소득공제자료적용일자 : pdfDatAppCmplDt */
	public String getPdfDatAppCmplDt() {
		return (String) get(ATTR_PDFDATAPPCMPLDT);
	}

	/** set pdf 소득공제자료제외사유내용 : pdfDatAppExcCtnt */
	public void setPdfDatAppExcCtnt(String pdfDatAppExcCtnt) {
		set(ATTR_PDFDATAPPEXCCTNT, pdfDatAppExcCtnt);
	}

	/** get pdf 소득공제자료제외사유내용 : pdfDatAppExcCtnt */
	public String getPdfDatAppExcCtnt() {
		return (String) get(ATTR_PDFDATAPPEXCCTNT);
	}

	/** set 입력자 : kybdr */
	public void setKybdr(String kybdr) {
		set(ATTR_KYBDR, kybdr);
	}

	/** get 입력자 : kybdr */
	public String getKybdr() {
		return (String) get(ATTR_KYBDR);
	}

	/** set 입력일자 : inptDt */
	public void setInptDt(String inptDt) {
		set(ATTR_INPTDT, inptDt);
	}

	/** get 입력일자 : inptDt */
	public String getInptDt() {
		return (String) get(ATTR_INPTDT);
	}

	/** set 입력주소 : inptAddr */
	public void setInptAddr(String inptAddr) {
		set(ATTR_INPTADDR, inptAddr);
	}

	/** get 입력주소 : inptAddr */
	public String getInptAddr() {
		return (String) get(ATTR_INPTADDR);
	}

	/** set 수정자 : ismt */
	public void setIsmt(String ismt) {
		set(ATTR_ISMT, ismt);
	}

	/** get 수정자 : ismt */
	public String getIsmt() {
		return (String) get(ATTR_ISMT);
	}

	/** set 수정일자 : revnDt */
	public void setRevnDt(String revnDt) {
		set(ATTR_REVNDT, revnDt);
	}

	/** get 수정일자 : revnDt */
	public String getRevnDt() {
		return (String) get(ATTR_REVNDT);
	}

	/** set 수정주소 : revnAddr */
	public void setRevnAddr(String revnAddr) {
		set(ATTR_REVNADDR, revnAddr);
	}

	/** get 수정주소 : revnAddr */
	public String getRevnAddr() {
		return (String) get(ATTR_REVNADDR);
	}

}
