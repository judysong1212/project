package com.app.smrmf.sche.quartz.service.impl;

import java.io.Serializable;
import java.sql.Date;

/**
 * @Class Name : Bass0150VO.java
 * @Description : Bass0150 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.11.12
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class SmrmfScheVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** set 사업장코드 : dpobCd */
    private java.lang.String dpobCd;

    private Date healthCheck;

	/**
	 * Comment : 
	 * @fn java.lang.String getDpobCd()
	 * @brief date:2017 2017. 6. 11. user:atres
	 * @return the dpobCd get
	 */
	public java.lang.String getDpobCd() {
		return dpobCd;
	}

	/**
	 * Comment : 
	 *@fn void setDpobCd(java.lang.String dpobCd)
	 *@brief date:2017 2017. 6. 11. user:atres
	 *@param dpobCd the dpobCd to set
	 */
	public void setDpobCd(java.lang.String dpobCd) {
		this.dpobCd = dpobCd;
	}

	/**
	 * Comment : 
	 * @fn Date getHealthCheck()
	 * @brief date:2017 2017. 6. 12. user:atres
	 * @return the healthCheck get
	 */
	public Date getHealthCheck() {
		return healthCheck;
	}

	/**
	 * Comment : 
	 *@fn void setHealthCheck(Date healthCheck)
	 *@brief date:2017 2017. 6. 12. user:atres
	 *@param healthCheck the healthCheck to set
	 */
	public void setHealthCheck(Date healthCheck) {
		this.healthCheck = healthCheck;
	}

	 
    
}
