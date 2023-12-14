package com.app.exterms.payroll.client.dto;

import com.app.smrmf.core.msfmainapp.client.admin.dto.MSFSimpleBaseModel;
import com.app.smrmf.core.msfmainapp.client.widget.MSFTextField;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.google.gwt.user.client.rpc.IsSerializable;

public class Hpe100BM extends MSFSimpleBaseModel implements IsSerializable {

	public static String ATTR_DPOBCD				= "dpobCd";
	public static String ATTR_YEARYYYY				= "yearYyyy";
	public static String ATTR_HALFYEAR				= "halfYear";
	public static String ATTR_DEPTCD				= "deptCd";
	public static String ATTR_PERSONNUMB			= "personNumb";
	public static String ATTR_RESNREGNNUM			= "resnRegnNum";
	public static String ATTR_HANNM					= "hanNm";
	public static String ATTR_CELLPHNENUM			= "cellPhneNum";
	public static String ATTR_FRGNRDIVCD			= "frgnrDivCd";
	public static String ATTR_RESIDENTCD			= "residentCd";
	public static String ATTR_NATNCD				= "natnCd";
	public static String ATTR_EMYMTBGNNDT			= "emymtBgnnDt";
	public static String ATTR_EMYMTENDDT			= "emymtEndDt";
	public static String ATTR_TXTNTOTAMNT			= "txtnTotAmnt";
	public static String ATTR_FREEDTYTOTAMT			= "freeDtyTotAmt";
	public static String ATTR_KYBDR					= "kybdr";
	public static String ATTR_INPTDT				= "inptDt";
	public static String ATTR_INPTADDR				= "inptAddr";
	public static String ATTR_ISMT					= "ismt";
	public static String ATTR_REVNDT				= "revnDt";
	public static String ATTR_REVNADDR				= "revnAddr";
	public static String ATTR_TEMPC01				= "tempc01";
	public static String ATTR_TEMPC02				= "tempc02";
	public static String ATTR_TEMPC03				= "tempc03";
	public static String ATTR_TEMPN01				= "tempn01";
	public static String ATTR_TEMPN02				= "tempn02";
	public static String ATTR_TEMPN03				= "tempn03";
	

	public static String ATTR_DPOBNM				= "dpobNm";  //**사업장명**//
	public static String ATTR_TXOFFCCD				= "txOffcCd";
	public static String ATTR_BUSOPRRGSTNNUM		= "busoprRgstnNum";
	public static String ATTR_DPOBZPCD				= "dpobZpcd";
	public static String ATTR_DPOBFNDTNADDR			= "dpobFndtnAddr";
	public static String ATTR_DPOBDTLPATRADDR		= "dpobDtlPatrAddr";
	public static String ATTR_DEGTRNM				= "degtrNm";
	public static String ATTR_CORPRGSTNNUM			= "corpRgstnNum";
	public static String ATTR_DEPTNM				= "deptNm";
	public static String ATTR_USRNM					= "usrNm";
	public static String ATTR_USRTEL				= "usrTel";
	public static String ATTR_SUBMITDATE			= "submitDate";
	public static String ATTR_HOMETAXID				= "hometaxId";
	public static String ATTR_SUBMITTER				= "submitter";
	public static String ATTR_TAXAGENTNO			= "taxAgentNo";
	public static String ATTR_TAXPGMCODE			= "taxPgmCode";
	public static String ATTR_RESNREGNNUM1          = "resnregnnum1";
	
	
	public Hpe100BM() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hpe100BM(  String dpobCd
					, String yearYyyy
					, String halfYear
					, String deptCd
					, String personNumb
					, String resnRegnNum
					, String hanNm
					, String cellPhneNum
					, String frgnrDivCd
					, String residentCd
					, String natnCd
					, String emymtBgnnDt
					, String emymtEndDt
					, String txtnTotAmnt
					, String freeDtyTotAmt
					, String kybdr
					, String inptDt
					, String inptAddr
					, String ismt
					, String revnDt
					, String revnAddr
					, String tempc01
					, String tempc02
					, String tempc03
					, String tempn01
					, String tempn02
					, String tempn03
					, String dpobNm
					, String txOffcCd
					, String busoprRgstnNum
					, String dpobZpcd
					, String dpobFndtnAddr
					, String dpobDtlPatrAddr
					, String degtrNm
					, String corpRgstnNum
					, String resnregnnum1
					, String deptNm
					, String usrNm
					, String usrTel
					, String submitDate
					, String hometaxId
					, String submitter
					, String taxAgentNo
					, String taxPgmCode
					) {
		
		
		values.put(ATTR_DPOBCD, dpobCd);
		values.put(ATTR_YEARYYYY, yearYyyy);
		values.put(ATTR_HALFYEAR, halfYear);
		values.put(ATTR_DEPTCD, deptCd);
		values.put(ATTR_PERSONNUMB, personNumb);
		values.put(ATTR_RESNREGNNUM, resnRegnNum);
		values.put(ATTR_HANNM, hanNm);
		values.put(ATTR_CELLPHNENUM, cellPhneNum);
		values.put(ATTR_FRGNRDIVCD, frgnrDivCd);
		values.put(ATTR_RESIDENTCD, residentCd);
		values.put(ATTR_NATNCD, natnCd);
		values.put(ATTR_EMYMTBGNNDT, emymtBgnnDt);
		values.put(ATTR_EMYMTENDDT, emymtEndDt);
		values.put(ATTR_TXTNTOTAMNT, txtnTotAmnt);
		values.put(ATTR_FREEDTYTOTAMT, freeDtyTotAmt);
		values.put(ATTR_KYBDR, kybdr);
		values.put(ATTR_INPTDT, inptDt);
		values.put(ATTR_INPTADDR, inptAddr);
		values.put(ATTR_ISMT, ismt);
		values.put(ATTR_REVNDT, revnDt);
		values.put(ATTR_REVNADDR, revnAddr);
		values.put(ATTR_TEMPC01, tempc01);
		values.put(ATTR_TEMPC02, tempc02);
		values.put(ATTR_TEMPC03, tempc03);
		values.put(ATTR_TEMPN01, tempn01);
		values.put(ATTR_TEMPN02, tempn02);
		values.put(ATTR_TEMPN03, tempn03);
		values.put(ATTR_DPOBNM, dpobNm);						/*법인명*/
		values.put(ATTR_TXOFFCCD, txOffcCd);					/*세무서코드*/
		values.put(ATTR_BUSOPRRGSTNNUM, busoprRgstnNum);		/*사업자등록번호*/
		values.put(ATTR_DPOBZPCD, dpobZpcd);					/*우편번호*/
		values.put(ATTR_DPOBFNDTNADDR, dpobFndtnAddr);			/*사업장주소*/
		values.put(ATTR_DPOBDTLPATRADDR, dpobDtlPatrAddr);		/*법인명*/
		values.put(ATTR_DEGTRNM, degtrNm);						/*대표이사성명*/
		values.put(ATTR_RESNREGNNUM1, resnregnnum1);			/*대표이사주민번호*/
		values.put(ATTR_CORPRGSTNNUM, corpRgstnNum);    		/*법인번호*/
		values.put(ATTR_DEPTNM, deptNm);						/*담당부서명*/
		values.put(ATTR_USRNM, usrNm);							/*담당자성명*/
		values.put(ATTR_USRTEL, usrTel);						/*담당자전화번호*/
		values.put(ATTR_SUBMITDATE, submitDate);				/*제출일자*/
		values.put(ATTR_HOMETAXID, hometaxId);					/*홈텍스ID*/
		values.put(ATTR_SUBMITTER, submitter);					/*제출구분*/
		values.put(ATTR_TAXAGENTNO, taxAgentNo);				/*세무대리인번호*/
		values.put(ATTR_TAXPGMCODE, taxPgmCode);				/*세무프로그램코드*/
			
	}
	
	public static String getAttrDpobcd() {
		return ATTR_DPOBCD;
	}
	public static String getAttrYearyyyy() {
		return ATTR_YEARYYYY;
	}
	public static String getAttrHalfyear() {
		return ATTR_HALFYEAR;
	}
	public static String getAttrDeptcd() {
		return ATTR_DEPTCD;
	}
	public static String getAttrPersonnumb() {
		return ATTR_PERSONNUMB;
	}
	public static String getAttrResnregnnum() {
		return ATTR_RESNREGNNUM;
	}
	public static String getAttrHannm() {
		return ATTR_HANNM;
	}
	public static String getAttrCellphnenum() {
		return ATTR_CELLPHNENUM;
	}
	public static String getAttrFrgnrdivcd() {
		return ATTR_FRGNRDIVCD;
	}
	public static String getAttrResidentcd() {
		return ATTR_RESIDENTCD;
	}
	public static String getAttrNatncd() {
		return ATTR_NATNCD;
	}
	public static String getAttrEmymtbgnndt() {
		return ATTR_EMYMTBGNNDT;
	}
	public static String getAttrEmymtenddt() {
		return ATTR_EMYMTENDDT;
	}
	public static String getAttrTxtntotamnt() {
		return ATTR_TXTNTOTAMNT;
	}
	public static String getAttrFreedtytotamt() {
		return ATTR_FREEDTYTOTAMT;
	}
	public static String getAttrKybdr() {
		return ATTR_KYBDR;
	}
	public static String getAttrInptdt() {
		return ATTR_INPTDT;
	}
	public static String getAttrInptaddr() {
		return ATTR_INPTADDR;
	}
	public static String getAttrIsmt() {
		return ATTR_ISMT;
	}
	public static String getAttrRevndt() {
		return ATTR_REVNDT;
	}
	public static String getAttrRevnaddr() {
		return ATTR_REVNADDR;
	}
	public static String getAttrTempc01() {
		return ATTR_TEMPC01;
	}
	public static String getAttrTempc02() {
		return ATTR_TEMPC02;
	}
	public static String getAttrTempc03() {
		return ATTR_TEMPC03;
	}
	public static String getAttrTempn01() {
		return ATTR_TEMPN01;
	}
	public static String getAttrTempn02() {
		return ATTR_TEMPN02;
	}
	public static String getAttrTempn03() {
		return ATTR_TEMPN03;
	}
	public static String getATTR_DPOBNM() {
		return ATTR_DPOBNM;
	}
	public static String getATTR_TXOFFCCD() {
		return ATTR_TXOFFCCD;
	}
	public static String getATTR_BUSOPRRGSTNNUM() {
		return ATTR_BUSOPRRGSTNNUM;
	}
	public static String getATTR_DPOBZPCD() {
		return ATTR_DPOBZPCD;
	}
	public static String getATTR_DPOBFNDTNADDR() {
		return ATTR_DPOBFNDTNADDR;
	}
	public static String getATTR_DPOBDTLPATRADDR() {
		return ATTR_DPOBDTLPATRADDR;
	}
	public static String getATTR_DEGTRNM() {
		return ATTR_DEGTRNM;
	}
	public static String getATTR_CORPRGSTNNUM() {
		return ATTR_CORPRGSTNNUM;
	}
	public static String getATTR_DEPTNM() {
		return ATTR_DEPTNM;
	}
	public static String getATTR_USRNM() {
		return ATTR_USRNM;
	}
	public static String getATTR_USRTEL() {
		return ATTR_USRTEL;
	}
	public static String getATTR_HOMETAXID() {
		return ATTR_HOMETAXID;
	}
	public static String getATTR_SUBMITDATE() {
		return ATTR_SUBMITDATE;
	}
	public static String getATTR_SUBMITTER() {
		return ATTR_SUBMITTER;
	}
	public static String getATTR_TAXAGENTNO() {
		return ATTR_TAXAGENTNO;
	}
	public static String getATTR_TAXPGMCODE() {
		return ATTR_TAXPGMCODE;
	}
	public static String getATTR_RESNREGNNUM1(){
		return ATTR_RESNREGNNUM1;
	}
	
	
	
	public static void setAttrDpobcd(String attrDpobcd) {
		ATTR_DPOBCD = attrDpobcd;
	}
	public static void setAttrYearyyyy(String attrYearyyyy) {
		ATTR_YEARYYYY = attrYearyyyy;
	}
	public static void setAttrHalfyear(String attrHalfyear) {
		ATTR_HALFYEAR = attrHalfyear;
	}
	public static void setAttrDeptcd(String attrDeptcd) {
		ATTR_DEPTCD = attrDeptcd;
	}
	public static void setAttrPersonnumb(String attrPersonnumb) {
		ATTR_PERSONNUMB = attrPersonnumb;
	}
	public static void setAttrResnregnnum(String attrResnregnnum) {
		ATTR_RESNREGNNUM = attrResnregnnum;
	}
	public static void setAttrHannm(String attrHannm) {
		ATTR_HANNM = attrHannm;
	}
	public static void setAttrCellphnenum(String attrCellphnenum) {
		ATTR_CELLPHNENUM = attrCellphnenum;
	}
	public static void setAttrFrgnrdivcd(String attrFrgnrdivcd) {
		ATTR_FRGNRDIVCD = attrFrgnrdivcd;
	}
	public static void setAttrResidentcd(String attrResidentcd) {
		ATTR_RESIDENTCD = attrResidentcd;
	}
	public static void setAttrNatncd(String attrNatncd) {
		ATTR_NATNCD = attrNatncd;
	}
	public static void setAttrEmymtbgnndt(String attrEmymtbgnndt) {
		ATTR_EMYMTBGNNDT = attrEmymtbgnndt;
	}
	public static void setAttrEmymtenddt(String attrEmymtenddt) {
		ATTR_EMYMTENDDT = attrEmymtenddt;
	}
	public static void setAttrTxtntotamnt(String attrTxtntotamnt) {
		ATTR_TXTNTOTAMNT = attrTxtntotamnt;
	}
	public static void setAttrFreedtytotamt(String attrFreedtytotamt) {
		ATTR_FREEDTYTOTAMT = attrFreedtytotamt;
	}
	public static void setAttrKybdr(String attrKybdr) {
		ATTR_KYBDR = attrKybdr;
	}
	public static void setAttrInptdt(String attrInptdt) {
		ATTR_INPTDT = attrInptdt;
	}
	public static void setAttrInptaddr(String attrInptaddr) {
		ATTR_INPTADDR = attrInptaddr;
	}
	public static void setAttrIsmt(String attrIsmt) {
		ATTR_ISMT = attrIsmt;
	}
	public static void setAttrRevndt(String attrRevndt) {
		ATTR_REVNDT = attrRevndt;
	}
	public static void setAttrRevnaddr(String attrRevnaddr) {
		ATTR_REVNADDR = attrRevnaddr;
	}
	public static void setAttrTempc01(String attrTempc01) {
		ATTR_TEMPC01 = attrTempc01;
	}
	public static void setAttrTempc02(String attrTempc02) {
		ATTR_TEMPC02 = attrTempc02;
	}
	public static void setAttrTempc03(String attrTempc03) {
		ATTR_TEMPC03 = attrTempc03;
	}
	public static void setAttrTempn01(String attrTempn01) {
		ATTR_TEMPN01 = attrTempn01;
	}
	public static void setAttrTempn02(String attrTempn02) {
		ATTR_TEMPN02 = attrTempn02;
	}
	public static void setAttrTempn03(String attrTempn03) {
		ATTR_TEMPN03 = attrTempn03;
	}
	public static void setATTR_DPOBNM(String aTTR_DPOBNM) {
		ATTR_DPOBNM = aTTR_DPOBNM;
	}
	public static void setATTR_TXOFFCCD(String aTTR_TXOFFCCD) {
		ATTR_TXOFFCCD = aTTR_TXOFFCCD;
	}
	public static void setATTR_BUSOPRRGSTNNUM(String aTTR_BUSOPRRGSTNNUM) {
		ATTR_BUSOPRRGSTNNUM = aTTR_BUSOPRRGSTNNUM;
	}
	public static void setATTR_DPOBZPCD(String aTTR_DPOBZPCD) {
		ATTR_DPOBZPCD = aTTR_DPOBZPCD;
	}
	public static void setATTR_DPOBFNDTNADDR(String aTTR_DPOBFNDTNADDR) {
		ATTR_DPOBFNDTNADDR = aTTR_DPOBFNDTNADDR;
	}
	public static void setATTR_DPOBDTLPATRADDR(String aTTR_DPOBDTLPATRADDR) {
		ATTR_DPOBDTLPATRADDR = aTTR_DPOBDTLPATRADDR;
	}
	public static void setATTR_DEGTRNM(String aTTR_DEGTRNM) {
		ATTR_DEGTRNM = aTTR_DEGTRNM;
	}
	public static void setATTR_CORPRGSTNNUM(String aTTR_CORPRGSTNNUM) {
		ATTR_CORPRGSTNNUM = aTTR_CORPRGSTNNUM;
	}
	public static void setATTR_DEPTNM(String aTTR_DEPTNM) {
		ATTR_DEPTNM = aTTR_DEPTNM;
	}
	public static void setATTR_USRNM(String aTTR_USRNM) {
		ATTR_USRNM = aTTR_USRNM;
	}
	public static void setATTR_USRTEL(String aTTR_USRTEL) {
		ATTR_USRTEL = aTTR_USRTEL;
	}
	public static void setATTR_HOMETAXID(String aTTR_HOMETAXID) {
		ATTR_HOMETAXID = aTTR_HOMETAXID;
	}
	public static void setATTR_SUBMITDATE(String aTTR_SUBMITDATE) {
		ATTR_SUBMITDATE = aTTR_SUBMITDATE;
	}
	public static void setATTR_SUBMITTER(String aTTR_SUBMITTER) {
		ATTR_SUBMITTER = aTTR_SUBMITTER;
	}
	public static void setATTR_TAXAGENTNO(String aTTR_TAXAGENTNO) {
		ATTR_TAXAGENTNO = aTTR_TAXAGENTNO;
	}
	public static void setATTR_TAXPGMCODE(String aTTR_TAXPGMCODE) {
		ATTR_TAXPGMCODE = aTTR_TAXPGMCODE;
	}
	public static void setATTR_RESNREGNNUM1(String aTTR_RESNREGNNUM1) {
		ATTR_RESNREGNNUM1 = aTTR_RESNREGNNUM1;							/*대표이사주민번호*/
	}

	
	
/**--------------------------2022.01.16 PDS 전자신고기본정보 추가작업 START -----------------------------------*/
 	
    /** set A10_법인_상호명 : corpFmnmNm */
    public void setCorpFmnmNm(String  dpobNm) { set( ATTR_DPOBNM ,dpobNm);}
    /** get A10_법인_상호명 : corpFmnmNm */
    public String  getCorpFmnmNm() { return (String )get( ATTR_DPOBNM );}
    
    /** set A10_근무시기 : HelfYear */
    public void setHelfYear(String  halfYear) { set( ATTR_HALFYEAR ,halfYear);}
    /** get A10_근무시기 : HelfYear */
    public String  getHelfYear() { return (String )get( ATTR_HALFYEAR );}
    
    
    
	/** set A9_사업자등록번호 : busoprRgstnum */
    public void setBusoprRgstnum(String  busoprRgstnum) { set( ATTR_BUSOPRRGSTNNUM ,busoprRgstnum);}
    /** get A9_사업자등록번호 : busoprRgstnum */
    public String  getBusoprRgstnum() { return (String )get( ATTR_BUSOPRRGSTNNUM );}
    
    
    /** set A10_대표자명 : degTrNm */
    public void setDegTrNm(String  degtrNm) { set( ATTR_DEGTRNM ,degtrNm);}
    /** get A10_대표자명 : degTrNm */
    public String  getDegTrNm() { return (String )get( ATTR_DEGTRNM );}
    
    /** set A10_주민등록번호 : ResnRegnnum */
    public void setResnRegnnum(String resnregnnum1) { set(ATTR_RESNREGNNUM1, resnregnnum1);}
    /** get A10_주민등록번호 : Resn_Regn_num */
    public String getResnRegnnum(){ return (String )get(ATTR_RESNREGNNUM1 );}
    
    
    /** set A10_법인번호 : corpFmnmnum */
    public void setCorpFmnmnum(String  corpFmnmnum) { set( ATTR_CORPRGSTNNUM ,corpFmnmnum);}
    /** get A10_법인번호 : corpFmnmnum */
    public String  getCorpFmnmnum() { return (String )get( ATTR_CORPRGSTNNUM );}
    
    /** set A10_우편번호 : DpobZpcd */
    public void setDpobZpcd(String  DpobZpcd) { set( ATTR_DPOBZPCD ,DpobZpcd);}
    /** get A10_우편번호 : DpobZpcd */
    public String  getDpobZpcd() { return (String )get( ATTR_DPOBZPCD );}
    
    /** set A10_사업장주소 : DpobFndtnAddr */
    public void setDpobFndtnAddr(String  DpobFndtnAddr) { set( ATTR_DPOBFNDTNADDR ,DpobFndtnAddr);}
    /** get A10_사업장주소 : DpobFndtnAddr */
    public String  getDpobFndtnAddr() { return (String )get( ATTR_DPOBFNDTNADDR );}
    
    /** set A10_사업장상세주소 : DpobFndtnAddr */
    public void setDpobDtlpatrAddr(String  DpobDtlpatrAddr) { set( ATTR_DPOBDTLPATRADDR ,DpobDtlpatrAddr);}
    /** get A10_사업장상세주소 : DpobFndtnAddr */
    public String  getDpobDtlpatrAddr() { return (String )get( ATTR_DPOBDTLPATRADDR );}
    
    /** set A10_관할세무서 : TxoffcCd */
    public void setTxoffcCd(String  TxoffcCd) { set( ATTR_TXOFFCCD ,TxoffcCd);}
    /** get A10_관할세무서 : DegResn_Regn_num */
    public String  getTxoffcCd() { return (String )get( ATTR_TXOFFCCD );}
   
    /** set A10_제출자구분 : SubmitTer */
    public void setSubmitTer(String  SubmitTer) { set( ATTR_SUBMITTER ,SubmitTer);}
    /** get A10_제출자구분 : DegResn_Regn_num */
    public String  getSubmitTer() { return (String )get( ATTR_SUBMITTER );}
    
    /** set A10_제출일자 : SubmitDate */
    public void setSubmitDate(String  SubmitDate) { set( ATTR_SUBMITDATE ,SubmitDate);}
    /** get A10_제출일자 : DegResn_Regn_num */
    public String  getSubmitDate() { return (String )get( ATTR_SUBMITDATE );}
    
    /** set A10_세무대리번호 : TaxAgentNo */
    public void setTaxAgentNo(String  TaxAgentNo) { set( ATTR_TAXAGENTNO ,TaxAgentNo);}
    /** get A10_세무대리번호 : TaxAgentNo */
    public String  getTaxAgentNo() { return (String )get( ATTR_TAXAGENTNO );}
   
    /** set A10_홈펙스ID : HomeTaxId */
    public void setHomeTaxId(String  HomeTaxId) { set( ATTR_HOMETAXID ,HomeTaxId);}
    /** get A10_홈텍스ID : HomeTaxId */
    public String  getHomeTaxId() { return (String )get( ATTR_HOMETAXID );}

    /** set A10_세무프로그램코드 : TaxPgmCode */
    public void setTaxPgmCode(String  TaxPgmCode) { set( ATTR_TAXPGMCODE ,TaxPgmCode);}
    /** get A10_세무프로그램코드 : TaxPgmCode */
    public String  getTaxPgmCode() { return (String )get( ATTR_TAXPGMCODE );}

    /** set A10_담당부서명 : DeptNm */
    public void setDeptNm(String  DeptNm) { set( ATTR_DEPTNM ,DeptNm);}
    /** get A10_담당부서명 : DeptNm */
    public String  getDeptNm() { return (String )get( ATTR_DEPTNM );}

    /** set A10_담당전화번호 : UsrTel */
    public void setUsrTel(String  UsrTel) { set( ATTR_USRTEL ,UsrTel);}
    /** get A10_담당전화번호 : UsrTel */
    public String  getUsrTel() { return (String )get( ATTR_USRTEL );}

    /** set A10_담당자명 : UsrNm */
    public void setUsrNm(String  UsrNm) { set( ATTR_USRNM ,UsrNm);}
    /** get A10_담당자명 : UsrNm */
    public String  getUsrNm() { return (String )get( ATTR_USRNM );}
    
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

/**-------------------------------------(END)---------------------------------**/  

}
