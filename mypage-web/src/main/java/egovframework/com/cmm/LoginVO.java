package egovframework.com.cmm;

import java.io.Serializable;

/**
 * @Class Name : LoginVO.java
 * @Description : Login VO class
 * @Modification Information
 * @
 * @  수정일         수정자                   수정내용
 * @ -------    --------    ---------------------------
 * @ 2009.03.03    박지욱          최초 생성
 *
 *  @author 공통서비스 개발팀 박지욱
 *  @since 2009.03.03
 *  @version 1.0
 *  @see
 *  
 *  
 */
public class LoginVO implements Serializable{

   /**
	 * 
	 */
	private static final long serialVersionUID = -8274004534207618049L;
	 /** SYS_DIV_CD */
    private java.lang.String sysDivCd;
    
    /** USR_ID */
    private java.lang.String usrId;
    
    /** USR_NM */
    private java.lang.String usrNm;
    
    /** USR_DIV_CD */
    private java.lang.String usrDivCd;
    
    /** SYSTEMKEY */
    private java.lang.String systemkey;
    
    /** DEPT_CD */
    private java.lang.String deptCd;
    
    /** EMAIL */
    private java.lang.String email;
    
    /** PWD */
    private java.lang.String pwd;
    
    /** USE_YN */
    private java.lang.String useYn;
    
    /** KYBDR */
    private java.lang.String kybdr;
    
    /** INPT_DT */
    private java.sql.Date inptDt;
    
    /** INPT_ADDR */
    private java.lang.String inptAddr;
    
    /** ISMT */
    private java.lang.String ismt;
    
    /** REVN_DT */
    private java.sql.Date revnDt;
    
    /** REVN_ADDR */
    private java.lang.String revnAddr;
    
    public java.lang.String getSysDivCd() {
        return this.sysDivCd;
    }
    
    public void setSysDivCd(java.lang.String sysDivCd) {
        this.sysDivCd = sysDivCd;
    }
    
    public java.lang.String getUsrId() {
        return this.usrId;
    }
    
    public void setUsrId(java.lang.String usrId) {
        this.usrId = usrId;
    }
    
    public java.lang.String getUsrNm() {
        return this.usrNm;
    }
    
    public void setUsrNm(java.lang.String usrNm) {
        this.usrNm = usrNm;
    }
    
    public java.lang.String getUsrDivCd() {
        return this.usrDivCd;
    }
    
    public void setUsrDivCd(java.lang.String usrDivCd) {
        this.usrDivCd = usrDivCd;
    }
    
    public java.lang.String getSystemkey() {
        return this.systemkey;
    }
    
    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
    }
    
    public java.lang.String getDeptCd() {
        return this.deptCd;
    }
    
    public void setDeptCd(java.lang.String deptCd) {
        this.deptCd = deptCd;
    }
    
    public java.lang.String getEmail() {
        return this.email;
    }
    
    public void setEmail(java.lang.String email) {
        this.email = email;
    }
    
    public java.lang.String getPwd() {
        return this.pwd;
    }
    
    public void setPwd(java.lang.String pwd) {
        this.pwd = pwd;
    }
    
    public java.lang.String getUseYn() {
        return this.useYn;
    }
    
    public void setUseYn(java.lang.String useYn) {
        this.useYn = useYn;
    }
    
    public java.lang.String getKybdr() {
        return this.kybdr;
    }
    
    public void setKybdr(java.lang.String kybdr) {
        this.kybdr = kybdr;
    }
    
    public java.sql.Date getInptDt() {
        return this.inptDt;
    }
    
    public void setInptDt(java.sql.Date inptDt) {
        this.inptDt = inptDt;
    }
    
    public java.lang.String getInptAddr() {
        return this.inptAddr;
    }
    
    public void setInptAddr(java.lang.String inptAddr) {
        this.inptAddr = inptAddr;
    }
    
    public java.lang.String getIsmt() {
        return this.ismt;
    }
    
    public void setIsmt(java.lang.String ismt) {
        this.ismt = ismt;
    }
    
    public java.sql.Date getRevnDt() {
        return this.revnDt;
    }
    
    public void setRevnDt(java.sql.Date revnDt) {
        this.revnDt = revnDt;
    }
    
    public java.lang.String getRevnAddr() {
        return this.revnAddr;
    }
    
    public void setRevnAddr(java.lang.String revnAddr) {
        this.revnAddr = revnAddr;
    }
    
	
}
