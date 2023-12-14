package com.app.exterms.yearendtax.client.dto.yeta2015;

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
public class Yeta3150DTO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 교육비가족상세일련번호 : edacDtnu */
    private Long edacDtnu;

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
    private Long edacOtam;
    
    /** set 주민등록번호 : rsnoNumb */
    private java.lang.String rsnoNumb;
    
    /** RSNO_NUMB */
    private java.lang.String rsnoNumb2;
    
    
    
    public java.lang.String getRsnoNumb2() {
		return rsnoNumb2;
	}

	public void setRsnoNumb2(java.lang.String rsnoNumb2) {
		this.rsnoNumb2 = rsnoNumb2;
	}

	public java.lang.String getRelhCode() {
		return relhCode;
	}

	public void setRelhCode(java.lang.String relhCode) {
		this.relhCode = relhCode;
	}

	/** set 성명 : kornName */
    private java.lang.String kornName;
    
	/** set 관계 : relhCode */
    private java.lang.String relhCode;
    
    
    
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

	public Long getEdacDtnu() {
        return this.edacDtnu;
    }
    
    public java.lang.String getKornName() {
		return kornName;
	}

	public void setKornName(java.lang.String kornName) {
		this.kornName = kornName;
	}

	public void setEdacDtnu(Long edacDtnu) {
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
    
    public Long getEdacOtam() {
        return this.edacOtam;
    }
    
    public void setEdacOtam(Long edacOtam) {
        this.edacOtam = edacOtam;
    }
    
}
