package com.app.exterms.personal.client.dto;

import com.extjs.gxt.ui.client.data.BaseModel;

public class Psnl0600DTO extends BaseModel {

	private static final long serialVersionUID = 1L;

	public Psnl0600DTO() {}

	// 순번이 필요할경우
	public void setRnum(String rnum) {
		set("rnum", rnum);
	}

	public String getRnum() {
		return (String) get("rnum");
	}
    //소속부서
	public void setCurrDeptNm(String currDeptNm) {
		set("currDeptNm", currDeptNm);
	}

	public String getCurrDeptNm() {
		return (String) get("currDeptNm");
	}
	
	 //사업
    public void setBusinNm(String businNm) {
        set("businNm", businNm);
    }

    public String getBusinNm() {
        return (String) get("businNm");
    }
    
	//주민등록번호
	public void setResnRegnNum(String resnRegnNum) {
        set("resnRegnNum", resnRegnNum);
    }
    
    public String getResnRegnNum() {
        return (String) get("resnRegnNum");
    } 
    
	/** set 원본 주민등록번호 : secRegnNum */
	public void setSecRegnNum(String secRegnNum) { set("secRegnNum",secRegnNum);}
	/** get 원본 주민등록번호 : secRegnNum */
	public String getSecRegnNum() { return (String)get("secRegnNum");}
	//관리부서
	public void setDeptNm(String deptNm) {
		set("deptNm", deptNm);
	}

	public String getDeptNm() {
		return (String) get("deptNm");
	}

	public void setEmymtDivNm(String emymtDivNm) {
		set("emymtDivNm", emymtDivNm);
	}
   //고용구분
	public String getEmymtDivNm() {
		return (String) get("emymtDivNm");
	}
    //직종
	public void setTypeOccuNm(String typeOccuNm) {
		set("typeOccuNm", typeOccuNm);
	}

	public String getTypeOccuNm() {
		return (String) get("typeOccuNm");
	}

	public void setDtilOccuClsDivNm(String dtilOccuClsDivNm) {
		set("dtilOccuClsDivNm", dtilOccuClsDivNm);
	}
    //직종세
	public String getDtilOccuClsDivNm() {
		return (String) get("dtilOccuClsDivNm");
	}

	/** set 한글성명 : hanNm */
	public void setHanNm(String hanNm) {
		set("hanNm", hanNm);
	}

	/** get 한글성명 : hanNm */
	public String getHanNm() {
		return (String) get("hanNm");
	}

	/** set 재직상태코드 : hdofcCodtnNm */
	public void setHdofcCodtnNm(String hdofcCodtnNm) {
		set("hdofcCodtnNm", hdofcCodtnNm);
	}

	/** get 재직상태코드 : hdofcCodtnCd */
	public String getHdofcCodtnNm() {
		return (String) get("hdofcCodtnNm");
	}

	/** set 최초고용일자 : frstEmymtDt */
	public void setFrstEmymtDt(String frstEmymtDt) {
		set("frstEmymtDt", frstEmymtDt);
	}

	/** get 최초고용일자 : frstEmymtDt */
	public String getFrstEmymtDt() {
		return (String) get("frstEmymtDt");
	}

	/** set 현_부서발령일자 : currDeptAppmtDt */
	public void setCurrDeptAppmtDt(String currDeptAppmtDt) {
		set("currDeptAppmtDt", currDeptAppmtDt);
	}

	/** get 현_부서발령일자 : currDeptAppmtDt */
	public String getCurrDeptAppmtDt() {
		return (String) get("currDeptAppmtDt");
	}

	/** set 퇴직일자 : retryDt */
	public void setRetryDt(String retryDt) {
		set("retryDt", retryDt);
	}

	/** get 퇴직일자 : retryDt */
	public String getRetryDt() {
		return (String) get("retryDt");
	}

	public void setLogSvcYrNumNm(String logSvcYrNumNm) {
		set("logSvcYrNumNm", logSvcYrNumNm);
	}
   //근무년수
	public String getLogSvcYrNumNm() {
		return (String) get("logSvcYrNumNm");
	}
	
	public void setLogSvcMnthIcmNm(String logSvcMnthIcmNm) {
		set("logSvcMnthIcmNm", logSvcMnthIcmNm);
	}
	//근무월수
	public String getLogSvcMnthIcmNm() {
		return (String) get("logSvcMnthIcmNm");
	}
  //장애구분
	public void setDabtyDivNm(String dabtyDivNm) {
		set("dabtyDivNm", dabtyDivNm);
	}

	public String getDabtyDivNm() {
		return (String) get("dabtyDivNm");
	}
   //도로명주소
	public void setAddr(String addr) {
		set("addr", addr);
	}

	public String getAddr() {
		return (String) get("addr");
	}

	/** set 집전화번호 : husPhnNum */
	public void setHusPhnNum(String husPhnNum) {
		set("husPhnNum", husPhnNum);
	}

	/** get 집전화번호 : husPhnNum */
	public String getHusPhnNum() {
		return (String) get("husPhnNum");
	}

	/** set 핸드폰번호 : cellPhneNum */
	public void setCellPhneNum(String cellPhneNum) {
		set("cellPhneNum", cellPhneNum);
	}

	/** get 핸드폰번호 : cellPhneNum */
	public String getCellPhneNum() {
		return (String) get("cellPhneNum");
	}

	/** set 이메일주소 : emailAddr */
	public void setEmailAddr(String emailAddr) {
		set("emailAddr", emailAddr);
	}

	/** get 이메일주소 : emailAddr */
	public String getEmailAddr() {
		return (String) get("emailAddr");
	}

	/** set 인사비고내용 : pernNoteCtnt */
	public void setPernNoteCtnt(String pernNoteCtnt) {
		set("pernNoteCtnt", pernNoteCtnt);
	}

	/** get 인사비고내용 : pernNoteCtnt */
	public String getPernNoteCtnt() {
		return (String) get("pernNoteCtnt");
	}

	// 제대구분코드 : dsageDivCd
	public void setDsageDivCd(String dsageDivCd) {
		set("dsageDivCd", dsageDivCd);
	}

	public String getDsageDivCd() {
		return (String) get("dsageDivCd");
	}

	// 면제사유코드 : exmtnReasCd
	public void setExmtnReasCd(String exmtnReasCd) {
		set("exmtnReasCd", exmtnReasCd);
	}

	public String getExmtnReasCd() {
		return (String) get("exmtnReasCd");
	}

	// 입대일자 : enrlntDt
	public void setEnrlntDt(String enrlntDt) {
		set("enrlntDt", enrlntDt);
	}

	public String getEnrlntDt() {
		return (String) get("enrlntDt");
	}

	// 제대일자 : dsageDt
	public void setDsageDt(String dsageDt) {
		set("dsageDt", dsageDt);
	}

	public String getDsageDt() {
		return (String) get("dsageDt");
	}

	// 복무인정기간코드 : servcRcgtnPridCd
	public void setServcRcgtnPridCd(String servcRcgtnPridCd) {
		set("servcRcgtnPridCd", servcRcgtnPridCd);
	}

	public String getServcRcgtnPridCd() {
		return (String) get("servcRcgtnPridCd");
	}

	// 역종코드 : srvssCd
	public void setSrvssCd(String srvssCd) {
		set("srvssCd", srvssCd);
	}

	public String getSrvssCd() {
		return (String) get("srvssCd");
	}

	// 군별코드 : baggrpCd
	public void setBaggrpCd(String baggrpCd) {
		set("baggrpCd", baggrpCd);
	}

	public String getBaggrpCd() {
		return (String) get("baggrpCd");
	}

	// 병과코드 : abotsCd
	public void setAbotsCd(String abotsCd) {
		set("abotsCd", abotsCd);
	}

	public String getAbotsCd() {
		return (String) get("abotsCd");
	}

	// 계급코드 : clsCd
	public void setClsCd(String clsCd) {
		set("clsCd", clsCd);
	}

	public String getClsCd() {
		return (String) get("clsCd");
	}

	// 군번 : mitySilnum
	public void setMitySilnum(String mitySilnum) {
		set("mitySilnum", mitySilnum);
	}

	public String getMitySilnum() {
		return (String) get("mitySilnum");
	}

	// MOS : mos
	public void setMos(String mos) {
		set("mos", mos);
	}

	public String getMos() {
		return (String) get("mos");
	}

	// 가입일자 : jnDt
	public void setJnDt(String jnDt) {
		set("jnDt", jnDt);
	}

	public String getJnDt() {
		return (String) get("jnDt");
	}

	// 가입단체명 : jnOpztnNm
	public void setJnOpztnNm(String jnOpztnNm) {
		set("jnOpztnNm", jnOpztnNm);
	}

	public String getJnOpztnNm() {
		return (String) get("jnOpztnNm");
	}

	// 직책코드 : odtyCd
	public void setOdtyCd(String odtyCd) {
		set("odtyCd", odtyCd);
	}

	public String getOdtyCd() {
		return (String) get("odtyCd");
	}

	// 탈퇴일자 : wirlDt
	public void setWirlDt(String wirlDt) {
		set("wirlDt", wirlDt);
	}

	public String getWirlDt() {
		return (String) get("wirlDt");
	}

	// 입학일자 : etncItshlDt
	public void setEtncItshlDt(String etncItshlDt) {
		set("etncItshlDt", etncItshlDt);
	}

	public String getEtncItshlDt() {
		return (String) get("etncItshlDt");
	}

	// 졸업일자 : grdtnDt
	public void setGrdtnDt(String grdtnDt) {
		set("grdtnDt", grdtnDt);
	}

	public String getGrdtnDt() {
		return (String) get("grdtnDt");
	}

	// 학력구분코드 : acadAbtyDivCd
	public void setAcadAbtyDivCd(String acadAbtyDivCd) {
		set("acadAbtyDivCd", acadAbtyDivCd);
	}

	public String getAcadAbtyDivCd() {
		return (String) get("acadAbtyDivCd");
	}

	// 학교코드 : schlCd
	public void setSchlCd(String schlCd) {
		set("schlCd", schlCd);
	}

	public String getSchlCd() {
		return (String) get("schlCd");
	}

	// 학과코드 : deprMajrCd
	public void setDeprMajrCd(String deprMajrCd) {
		set("deprMajrCd", deprMajrCd);
	}

	public String getDeprMajrCd() {
		return (String) get("deprMajrCd");
	}

	// 학위구분코드 : degrDivCd
	public void setDegrDivCd(String degrDivCd) {
		set("degrDivCd", degrDivCd);
	}

	public String getDegrDivCd() {
		return (String) get("degrDivCd");
	}

	// 수업년수코드 : lesnYrNumCd
	public void setLesnYrNumCd(String lesnYrNumCd) {
		set("lesnYrNumCd", lesnYrNumCd);
	}

	public String getLesnYrNumCd() {
		return (String) get("lesnYrNumCd");
	}

	// 학력비고내용 : acadAbtyNoteCtnt
	public void setAcadAbtyNoteCtnt(String acadAbtyNoteCtnt) {
		set("acadAbtyNoteCtnt", acadAbtyNoteCtnt);
	}

	public String getAcadAbtyNoteCtnt() {
		return (String) get("acadAbtyNoteCtnt");
	}

	// 경력시작일자 : carrBgnnDt
	public void setCarrBgnnDt(String carrBgnnDt) {
		set("carrBgnnDt", carrBgnnDt);
	}

	public String getCarrBgnnDt() {
		return (String) get("carrBgnnDt");
	}

	// 경력종료일자 : carrEndDt
	public void setCarrEndDt(String carrEndDt) {
		set("carrEndDt", carrEndDt);
	}

	public String getCarrEndDt() {
		return (String) get("carrEndDt");
	}

	// 근무처명 : paeWorkNm
	public void setPaeWorkNm(String paeWorkNm) {
		set("paeWorkNm", paeWorkNm);
	}

	public String getPaeWorkNm() {
		return (String) get("paeWorkNm");
	}

	// 직책명 : odtyNm
	public void setOdtyNm(String odtyNm) {
		set("odtyNm", odtyNm);
	}

	public String getOdtyNm() {
		return (String) get("odtyNm");
	}

	// 담당업무명 : repbtyBusinNm
	public void setRepbtyBusinNm(String repbtyBusinNm) {
		set("repbtyBusinNm", repbtyBusinNm);
	}

	public String getRepbtyBusinNm() {
		return (String) get("repbtyBusinNm");
	}

	// 경력비고내용 : carrNoteCtnt
	public void setCarrNoteCtnt(String carrNoteCtnt) {
		set("carrNoteCtnt", carrNoteCtnt);
	}

	public String getCarrNoteCtnt() {
		return (String) get("carrNoteCtnt");
	}

	// 취득일자 : aqtnDt
	public void setAqtnDt(String aqtnDt) {
		set("aqtnDt", aqtnDt);
	}

	public String getAqtnDt() {
		return (String) get("aqtnDt");
	}
	
	// 자격면허코드 : qftntLicnsCd
	public void setQftntLicnsCd(String qftntLicnsCd) {
		set("qftntLicnsCd", qftntLicnsCd);
	}

	public String getQftntLicnsCd() {
		return (String) get("qftntLicnsCd");
	}

	// 자격면허분야내용 : qftntLicnsPovncCtnt
	public void setQftntLicnsPovncCtnt(String qftntLicnsPovncCtnt) {
		set("qftntLicnsPovncCtnt", qftntLicnsPovncCtnt);
	}

	public String getQftntLicnsPovncCtnt() {
		return (String) get("qftntLicnsPovncCtnt");
	}

	// 자격면허번호 : qftntLicnsNum
	public void setQftntLicnsNum(String qftntLicnsNum) {
		set("qftntLicnsNum", qftntLicnsNum);
	}

	public String getQftntLicnsNum() {
		return (String) get("qftntLicnsNum");
	}

	// 교육시작일자 : eduBgnnDt
	public void setEduBgnnDt(String eduBgnnDt) {
		set("eduBgnnDt", eduBgnnDt);
	}

	public String getEduBgnnDt() {
		return (String) get("eduBgnnDt");
	}

	// 교육종료일자 : eduEndDt
	public void setEduEndDt(String eduEndDt) {
		set("eduEndDt", eduEndDt);
	}

	public String getEduEndDt() {
		return (String) get("eduEndDt");
	}

	// 교육이수시간 : eduCmpteTm
	public void setEduCmpteTm(String eduCmpteTm) {
		set("eduCmpteTm", eduCmpteTm);
	}

	public String getEduCmpteTm() {
		return (String) get("eduCmpteTm");
	}

	// 교육종류명 : eduKndNm
	public void setEduKndNm(String eduKndNm) {
		set("eduKndNm", eduKndNm);
	}

	public String getEduKndNm() {
		return (String) get("eduKndNm");
	}

	// 교육기관명 : eduIstutNm
	public void setEduIstutNm(String eduIstutNm) {
		set("eduIstutNm", eduIstutNm);
	}

	public String getEduIstutNm() {
		return (String) get("eduIstutNm");
	}

	// 교육비고내용 : eduNoteCtnt
	public void setEduNoteCtnt(String eduNoteCtnt) {
		set("eduNoteCtnt", eduNoteCtnt);
	}

	public String getEduNoteCtnt() {
		return (String) get("eduNoteCtnt");
	}

	// 포상년도 : accldYr
	public void setAccldYr(String accldYr) {
		set("accldYr", accldYr);
	}

	public String getAccldYr() {
		return (String) get("accldYr");
	}

	// 포상수여일자 : accldPrttDt
	public void setAccldPrttDt(String accldPrttDt) {
		set("accldPrttDt", accldPrttDt);
	}

	public String getAccldPrttDt() {
		return (String) get("accldPrttDt");
	}

	// 포상종류코드 : accldKndCd
	public void setAccldKndCd(String accldKndCd) {
		set("accldKndCd", accldKndCd);
	}

	public String getAccldKndCd() {
		return (String) get("accldKndCd");
	}

	// 포상구분코드 : accldDivCd
	public void setAccldDivCd(String accldDivCd) {
		set("accldDivCd", accldDivCd);
	}

	public String getAccldDivCd() {
		return (String) get("accldDivCd");
	}

	// 포상명 : accldNm
	public void setAccldNm(String accldNm) {
		set("accldNm", accldNm);
	}

	public String getAccldNm() {
		return (String) get("accldNm");
	}

	// 포상서훈번호 : accldCfmntNum
	public void setAccldCfmntNum(String accldCfmntNum) {
		set("accldCfmntNum", accldCfmntNum);
	}

	public String getAccldCfmntNum() {
		return (String) get("accldCfmntNum");
	}

	// 시행기관명 : efmnIstutNm
	public void setEfmnIstutNm(String efmnIstutNm) {
		set("efmnIstutNm", efmnIstutNm);
	}

	public String getEfmnIstutNm() {
		return (String) get("efmnIstutNm");
	}

	// 포상주체내용 : accldMnantCtnt
	public void setAccldMnantCtnt(String accldMnantCtnt) {
		set("accldMnantCtnt", accldMnantCtnt);
	}

	public String getAccldMnantCtnt() {
		return (String) get("accldMnantCtnt");
	}

	// 포상비고내용 : accldNoteCtnt
	public void setAccldNoteCtnt(String accldNoteCtnt) {
		set("accldNoteCtnt", accldNoteCtnt);
	}

	public String getAccldNoteCtnt() {
		return (String) get("accldNoteCtnt");
	}

	// 징계처분일자 : dsnyActDsplDt
	public void setDsnyActDsplDt(String dsnyActDsplDt) {
		set("dsnyActDsplDt", dsnyActDsplDt);
	}

	public String getDsnyActDsplDt() {
		return (String) get("dsnyActDsplDt");
	}

	// 징계구분코드 : dsnyActDivCd
	public void setDsnyActDivCd(String dsnyActDivCd) {
		set("dsnyActDivCd", dsnyActDivCd);
	}

	public String getDsnyActDivCd() {
		return (String) get("dsnyActDivCd");
	}

	// 징계명 : dsnyActNm
	public void setDsnyActNm(String dsnyActNm) {
		set("dsnyActNm", dsnyActNm);
	}

	public String getDsnyActNm() {
		return (String) get("dsnyActNm");
	}

	// 징계사유내용 : dsnyActReasCtnt
	public void setDsnyActReasCtnt(String dsnyActReasCtnt) {
		set("dsnyActReasCtnt", dsnyActReasCtnt);
	}

	public String getDsnyActReasCtnt() {
		return (String) get("dsnyActReasCtnt");
	}

	// 징계수행기관 : dsnyActEctgOrgn
	public void setDsnyActEctgOrgn(String dsnyActEctgOrgn) {
		set("dsnyActEctgOrgn", dsnyActEctgOrgn);
	}

	public String getDsnyActEctgOrgn() {
		return (String) get("dsnyActEctgOrgn");
	}

	// 징계비고내용 : dsnyActNoteCtnt
	public void setDsnyActNoteCtnt(String dsnyActNoteCtnt) {
		set("dsnyActNoteCtnt", dsnyActNoteCtnt);
	}

	public String getDsnyActNoteCtnt() {
		return (String) get("dsnyActNoteCtnt");
	}

	// 징계시작일자 : dsnyActBgnnDt
	public void setDsnyActBgnnDt(String dsnyActBgnnDt) {
		set("dsnyActBgnnDt", dsnyActBgnnDt);
	}

	public String getDsnyActBgnnDt() {
		return (String) get("dsnyActBgnnDt");
	}

	// 징계종료일자 : dsnyActEndDt
	public void setDsnyActEndDt(String dsnyActEndDt) {
		set("dsnyActEndDt", dsnyActEndDt);
	}

	public String getDsnyActEndDt() {
		return (String) get("dsnyActEndDt");
	}

	// 징계감봉월수 : dsnyActCtwpMnthIcm
	public void setDsnyActCtwpMnthIcm(String dsnyActCtwpMnthIcm) {
		set("dsnyActCtwpMnthIcm", dsnyActCtwpMnthIcm);
	}

	public String getDsnyActCtwpMnthIcm() {
		return (String) get("dsnyActCtwpMnthIcm");
	}

	// 징계사면일자 : dsnyActAnstyDt
	public void setDsnyActAnstyDt(String dsnyActAnstyDt) {
		set("dsnyActAnstyDt", dsnyActAnstyDt);
	}

	public String getDsnyActAnstyDt() {
		return (String) get("dsnyActAnstyDt");
	}

	// 징계사면구분코드 : dsnyActAnstyDivCd
	public void setDsnyActAnstyDivCd(String dsnyActAnstyDivCd) {
		set("dsnyActAnstyDivCd", dsnyActAnstyDivCd);
	}

	public String getDsnyActAnstyDivCd() {
		return (String) get("dsnyActAnstyDivCd");
	}

	// 휴직구분코드 : levfAbncDivCd
	public void setLevfAbncDivCd(String levfAbncDivCd) {
		set("levfAbncDivCd", levfAbncDivCd);
	}

	public String getLevfAbncDivCd() {
		return (String) get("levfAbncDivCd");
	}

	// 휴직시작일자 : levfAbncBgnnDt
	public void setLevfAbncBgnnDt(String levfAbncBgnnDt) {
		set("levfAbncBgnnDt", levfAbncBgnnDt);
	}

	public String getLevfAbncBgnnDt() {
		return (String) get("levfAbncBgnnDt");
	}

	// 휴직종료일자 : levfAbncEndDt
	public void setLevfAbncEndDt(String levfAbncEndDt) {
		set("levfAbncEndDt", levfAbncEndDt);
	}

	public String getLevfAbncEndDt() {
		return (String) get("levfAbncEndDt");
	}

	// 실제복직일자 : turtyRntmntDt
	public void setTurtyRntmntDt(String turtyRntmntDt) {
		set("turtyRntmntDt", turtyRntmntDt);
	}

	public String getTurtyRntmntDt() {
		return (String) get("turtyRntmntDt");
	}

	// 휴직비고내용 : levfAbncNoteCtnt
	public void setLevfAbncNoteCtnt(String levfAbncNoteCtnt) {
		set("levfAbncNoteCtnt", levfAbncNoteCtnt);
	}

	public String getLevfAbncNoteCtnt() {
		return (String) get("levfAbncNoteCtnt");
	}
	
	public void setSystemkey(String systemkey){
		set("systemkey" , systemkey);
	}
	
	public String getSystemkey(){
		return (String) get("systemkey");
	}
}
