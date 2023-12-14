package com.app.exterms.basis.server.vo;

import java.io.Serializable;

/**
 * @Class Name : Bass0200VO.java
 * @Description : Bass0200 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.14
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Bass0200VO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** DPOB_CD */
    private java.lang.String dpobCd;

    /** PUB_HODY_DT */
    private java.lang.String pubcHodyDt;
    
    /** DOTW_CD */
    private java.lang.String dotwCd;
    
    /** PUBC_HODY_CTNT */
    private java.lang.String pubcHodyCtnt;
    
    /** PUBC_HODY_YN */
    private java.lang.String pubcHodyYn;
    
    /** PAID_PUBC_HODY_YN */
    private java.lang.String paidPubcHodyYn;
    
    /** KYBDR */
    private java.lang.String kybdr;
    
    /** INPT_DT */
    private java.lang.String inptDt;
    
    /** INPT_ADDR */
    private java.lang.String inptAddr;
    
    /** ISMT */
    private java.lang.String ismt;
    
    /** REVN_DT */
    private java.lang.String revnDt;
    
    /** REVN_ADDR */
    private java.lang.String revnAddr;
     
    /** OFFDAY_KUBN */
    private java.lang.String offdayKubn;
    
    /** YEAR_MNTH_DAY */
    private java.lang.String yearMnthDay;
    
     
    
//    /** YEAR */
//    private java.lang.String year; 
//    
//    /** MNTH */
//    private java.lang.String mnth;
//    
//    /** DAY */
//    private java.lang.String day;
    
    
	
    
    /**
	 * Comment : 
	 * @fn java.lang.String getPubcHodyDt()
	 * @brief date:2017 2017. 11. 29. user:atres
	 * @return the pubcHodyDt get
	 */
	public java.lang.String getPubcHodyDt() {
		return pubcHodyDt;
	}

	/**
	 * Comment : 
	 *@fn void setPubcHodyDt(java.lang.String pubcHodyDt)
	 *@brief date:2017 2017. 11. 29. user:atres
	 *@param pubcHodyDt the pubcHodyDt to set
	 */
	public void setPubcHodyDt(java.lang.String pubcHodyDt) {
		this.pubcHodyDt = pubcHodyDt;
	}

	public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
//    public java.lang.String getYear() {
//        return this.year;
//    }
//    
//    public void setYear(java.lang.String year) {
//        this.year = year;
//    }
//    
//    public java.lang.String getMnth() {
//        return this.mnth;
//    }
//    
//    public void setMnth(java.lang.String mnth) {
//        this.mnth = mnth;
//    }
//    
//    public java.lang.String getDay() {
//        return this.day;
//    }
//    
//    public void setDay(java.lang.String day) {
//        this.day = day;
//    }
    
    public java.lang.String getDotwCd() {
        return this.dotwCd;
    }
    
    public void setDotwCd(java.lang.String dotwCd) {
        this.dotwCd = dotwCd;
    }
    
    public java.lang.String getPubcHodyCtnt() {
        return this.pubcHodyCtnt;
    }
    
    public void setPubcHodyCtnt(java.lang.String pubcHodyCtnt) {
        this.pubcHodyCtnt = pubcHodyCtnt;
    }
    
    public java.lang.String getPubcHodyYn() {
        return this.pubcHodyYn;
    }
    
    public void setPubcHodyYn(java.lang.String pubcHodyYn) {
        this.pubcHodyYn = pubcHodyYn;
    }
    
    public java.lang.String getPaidPubcHodyYn() {
        return this.paidPubcHodyYn;
    }
    
    public void setPaidPubcHodyYn(java.lang.String paidPubcHodyYn) {
        this.paidPubcHodyYn = paidPubcHodyYn;
    }
    
    public java.lang.String getKybdr() {
        return this.kybdr;
    }
    
    public void setKybdr(java.lang.String kybdr) {
        this.kybdr = kybdr;
    }
    
    public java.lang.String getInptDt() {
        return this.inptDt;
    }
    
    public void setInptDt(java.lang.String inptDt) {
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
    
    public java.lang.String getRevnDt() {
        return this.revnDt;
    }

	/**
	 * Comment : 
	 * @fn java.lang.String getRevnAddr()
	 * @brief date:2017 2017. 12. 15. user:atres
	 * @return the revnAddr get
	 */
	public java.lang.String getRevnAddr() {
		return revnAddr;
	}

	/**
	 * Comment : 
	 *@fn void setRevnAddr(java.lang.String revnAddr)
	 *@brief date:2017 2017. 12. 15. user:atres
	 *@param revnAddr the revnAddr to set
	 */
	public void setRevnAddr(java.lang.String revnAddr) {
		this.revnAddr = revnAddr;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getOffdayKubn()
	 * @brief date:2017 2017. 12. 15. user:atres
	 * @return the offdayKubn get
	 */
	public java.lang.String getOffdayKubn() {
		return offdayKubn;
	}

	/**
	 * Comment : 
	 *@fn void setOffdayKubn(java.lang.String offdayKubn)
	 *@brief date:2017 2017. 12. 15. user:atres
	 *@param offdayKubn the offdayKubn to set
	 */
	public void setOffdayKubn(java.lang.String offdayKubn) {
		this.offdayKubn = offdayKubn;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getYearMnthDay()
	 * @brief date:2017 2017. 12. 15. user:atres
	 * @return the yearMnthDay get
	 */
	public java.lang.String getYearMnthDay() {
		return yearMnthDay;
	}

	/**
	 * Comment : 
	 *@fn void setYearMnthDay(java.lang.String yearMnthDay)
	 *@brief date:2017 2017. 12. 15. user:atres
	 *@param yearMnthDay the yearMnthDay to set
	 */
	public void setYearMnthDay(java.lang.String yearMnthDay) {
		this.yearMnthDay = yearMnthDay;
	}

	/**
	 * Comment : 
	 *@fn void setRevnDt(java.lang.String revnDt)
	 *@brief date:2017 2017. 12. 15. user:atres
	 *@param revnDt the revnDt to set
	 */
	public void setRevnDt(java.lang.String revnDt) {
		this.revnDt = revnDt;
	}
 

    
}
