package com.app.exterms.yearendtax.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Yeta3150VO.java
 * @Description : Yeta3150 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2016.01.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Yeta3150_2022_VO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 교육비가족상세일련번호 : edacDtnu */
    private java.math.BigDecimal edacDtnu;

    /** set 연말정산귀속년도 : edacRvyy */
    private java.lang.String edacRvyy;

    /** set 정산구분코드 : settGbcd */
    private java.lang.String settGbcd;

    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    /** set SYSTEMKEY : systemkey */
    private java.lang.String systemkey;

    /** set 가족학력구분코드 : fmacGbcd */
    private java.lang.String fmacGbcd;

    /** set 교육비지급금액 : edacOtam */
    private java.math.BigDecimal edacOtam;

    /** set 가족주민등록번호 : rsnoNumb */
    private java.lang.String rsnoNumb;

    /** set 국세청자료여부 : guksYeno */
    private java.lang.String guksYeno;

    
    /**
	 * Comment : 
	 * @fn java.lang.String getGuksYeno()
	 * @brief date:2017 2017. 2. 1. user:atres-pc
	 * @return the guksYeno get
	 */
	public java.lang.String getGuksYeno() {
		return guksYeno;
	}

	/**
	 * Comment : 
	 *@fn void setGuksYeno(java.lang.String guksYeno)
	 *@brief date:2017 2017. 2. 1. user:atres-pc
	 *@param guksYeno the guksYeno to set
	 */
	public void setGuksYeno(java.lang.String guksYeno) {
		this.guksYeno = guksYeno;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getRsnoNumb()
	 * @brief date:2016 Jan 30, 2016 user:leeheuisung
	 * @return the rsnoNumb get
	 */
	public java.lang.String getRsnoNumb() {
		return rsnoNumb;
	}

	/**
	 * Comment : 
	 *@fn void setRsnoNumb(java.lang.String rsnoNumb)
	 *@brief date:2016 Jan 30, 2016 user:leeheuisung
	 *@param rsnoNumb the rsnoNumb to set
	 */
	public void setRsnoNumb(java.lang.String rsnoNumb) {
		this.rsnoNumb = rsnoNumb;
	}

	public java.math.BigDecimal getEdacDtnu() {
        return this.edacDtnu;
    }
    
    public void setEdacDtnu(java.math.BigDecimal edacDtnu) {
        this.edacDtnu = edacDtnu;
    }
    
    public java.lang.String getEdacRvyy() {
        return this.edacRvyy;
    }
    
    public void setEdacRvyy(java.lang.String edacRvyy) {
        this.edacRvyy = edacRvyy;
    }
    
    public java.lang.String getSettGbcd() {
        return this.settGbcd;
    }
    
    public void setSettGbcd(java.lang.String settGbcd) {
        this.settGbcd = settGbcd;
    }
    
    public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
    public java.lang.String getSystemkey() {
        return this.systemkey;
    }
    
    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
    }
    
    public java.lang.String getFmacGbcd() {
        return this.fmacGbcd;
    }
    
    public void setFmacGbcd(java.lang.String fmacGbcd) {
        this.fmacGbcd = fmacGbcd;
    }
    
    public java.math.BigDecimal getEdacOtam() {
        return this.edacOtam;
    }
    
    public void setEdacOtam(java.math.BigDecimal edacOtam) {
        this.edacOtam = edacOtam;
    }
    
}
