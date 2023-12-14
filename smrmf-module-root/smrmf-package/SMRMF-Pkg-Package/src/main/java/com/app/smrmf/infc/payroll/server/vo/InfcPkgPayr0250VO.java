package com.app.smrmf.infc.payroll.server.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Class Name : Payr0250VO.java
 * @Description : Payr0250 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class InfcPkgPayr0250VO  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** PAYR_MANG_DEPT_CD */
    private java.lang.String payrMangDeptCd;
    
    /** PAY_SCDU_SEIL_NUM */
    private BigDecimal payScduSeilNum;
    
    /** PAY_CD */
    private java.lang.String payCd;
    
    /** EMYMT_DIV_CD */
    private java.lang.String emymtDivCd;
    
    /** DPOB_CD */
    private java.lang.String dpobCd;
    
    /** DEPT_CD */
    private java.lang.String deptCd;
    
    /** BUSIN_CD */
    private java.lang.String businCd;
    
    /** PERN_CHRG_EMP_IDEN_NUM */
    private java.lang.String pernChrgEmpIdenNum;
    
    /** JOB_YR_MNTH */
    private java.lang.String jobYrMnth;
    
    /** JOB_NM */
    private java.lang.String jobNm;
    
    /** PYMT_DT */
    private java.lang.String pymtDt;
    
    /** RFLCTN_BGNN_DT */
    private java.lang.String rflctnBgnnDt;
    
    /** RFLCTN_END_DT */
    private java.lang.String rflctnEndDt;
    
    /** PAY_DDLNE_DT */
    private java.lang.String payDdlneDt;
    
    /** GRO_FL_CRETN_DT */
    private java.lang.String groFlCretnDt;
    
    
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
    
    

    /** set 직종코드 : typOccuCd */
    private java.lang.String typOccuCd;
    
    /** set 호봉등급코드 : pyspGrdeCd */
    private java.lang.String pyspGrdeCd;


    /** 직종세통합코드 dtilOccuInttnCd */
    private java.lang.String dtilOccuInttnCd;
    private List<String> dtilOccuInttnCdArr; //스트링 값에 여러건을 넘기기의한 값
    
    /** SYSTEMKEY */
    private java.lang.String systemkey;
    
    /** TYP_OCCU_CD */
   // private java.lang.String typOccucdIn;
    
    /** PYSP_GRDE_CD */
   // private java.lang.String pyspGrdeCdIn; 
    
    private java.lang.String payrMangDeptYn;  //관리부서담당자인지여부 
    
    /** set 사용자아이디 : usrId */
    private java.lang.String usrId;
    
	     
	    
	/** 부서코드 - DEPT_CD */
	private java.lang.String deptCdAuth;
		
		 /** 직종세통합코드 dtilOccuInttnCd */
	private java.lang.String dtilOccuInttnCdAuth;  
    
	   /** 관리부서코드  mangeDeptCd */
    private java.lang.String  mangeDeptCd;

    
    /**
	 * Comment : 관리부서코드
	 * @fn java.lang.String getMangeDeptCd()
	 * @brief date:2018 2018. 3. 13. user:atres
	 * @return the mangeDeptCd get
	 */
	public java.lang.String getMangeDeptCd() {
		return mangeDeptCd;
	}

	/**
	 * Comment : 관리부서코드
	 *@fn void setMangeDeptCd(java.lang.String mangeDeptCd)
	 *@brief date:2018 2018. 3. 13. user:atres
	 *@param mangeDeptCd the mangeDeptCd to set
	 */
	public void setMangeDeptCd(java.lang.String mangeDeptCd) {
		this.mangeDeptCd = mangeDeptCd;
	}

    /**
		 * Comment : 
		 * @fn java.lang.String getDeptCdAuth()
		 * @brief date:2016 Jan 5, 2016 user:leeheuisung
		 * @return the deptCdAuth get
		 */
		public java.lang.String getDeptCdAuth() {
			return deptCdAuth;
		}

		/**
		 * Comment : 
		 *@fn void setDeptCdAuth(java.lang.String deptCdAuth)
		 *@brief date:2016 Jan 5, 2016 user:leeheuisung
		 *@param deptCdAuth the deptCdAuth to set
		 */
		public void setDeptCdAuth(java.lang.String deptCdAuth) {
			this.deptCdAuth = deptCdAuth;
		}

		/**
		 * Comment : 
		 * @fn java.lang.String getDtilOccuInttnCdAuth()
		 * @brief date:2016 Jan 5, 2016 user:leeheuisung
		 * @return the dtilOccuInttnCdAuth get
		 */
		public java.lang.String getDtilOccuInttnCdAuth() {
			return dtilOccuInttnCdAuth;
		}

		/**
		 * Comment : 
		 *@fn void setDtilOccuInttnCdAuth(java.lang.String dtilOccuInttnCdAuth)
		 *@brief date:2016 Jan 5, 2016 user:leeheuisung
		 *@param dtilOccuInttnCdAuth the dtilOccuInttnCdAuth to set
		 */
		public void setDtilOccuInttnCdAuth(java.lang.String dtilOccuInttnCdAuth) {
			this.dtilOccuInttnCdAuth = dtilOccuInttnCdAuth;
		}

	/**
	 * Comment : 
	 * @fn List<String> getDtilOccuInttnCdArr()
	 * @brief date:2015 Dec 12, 2015 user:leeheuisung
	 * @return the dtilOccuInttnCdArr get
	 */
	public List<String> getDtilOccuInttnCdArr() {
		return dtilOccuInttnCdArr;
	}

	/**
	 * Comment : 
	 *@fn void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr)
	 *@brief date:2015 Dec 12, 2015 user:leeheuisung
	 *@param dtilOccuInttnCdArr the dtilOccuInttnCdArr to set
	 */
	public void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr) {
		this.dtilOccuInttnCdArr = dtilOccuInttnCdArr;
	}

	/**
	 * Comment : 
	 * @fn java.lang.String getUsrId()
	 * @brief date:2015 Dec 12, 2015 user:leeheuisung
	 * @return the usrId get
	 */
	public java.lang.String getUsrId() {
		return usrId;
	}

	/**
	 * Comment : 
	 *@fn void setUsrId(java.lang.String usrId)
	 *@brief date:2015 Dec 12, 2015 user:leeheuisung
	 *@param usrId the usrId to set
	 */
	public void setUsrId(java.lang.String usrId) {
		this.usrId = usrId;
	}

	/**
	 * Comment : 직종세통합코드
	 * @fn java.lang.String getDtilOccuInttnCd()
	 * @brief date:2015 Dec 3, 2015 user:leeheuisung
	 * @return the dtilOccuInttnCd get
	 */
	public java.lang.String getDtilOccuInttnCd() {
		return dtilOccuInttnCd;
	}

	/**
	 * Comment : 직종세통합코드
	 *@fn void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd)
	 *@brief date:2015 Dec 3, 2015 user:leeheuisung
	 *@param dtilOccuInttnCd the dtilOccuInttnCd to set
	 */
	public void setDtilOccuInttnCd(java.lang.String dtilOccuInttnCd) {
		this.dtilOccuInttnCd = dtilOccuInttnCd;
	}

	public java.lang.String getPayrMangDeptYn() {
        return payrMangDeptYn;
    }

    public void setPayrMangDeptYn(java.lang.String payrMangDeptYn) {
        this.payrMangDeptYn = payrMangDeptYn;
    }

    public java.lang.String getTypOccuCd() {
        return typOccuCd;
    }

    public void setTypOccuCd(java.lang.String typOccuCd) {
        this.typOccuCd = typOccuCd;
    }

    public java.lang.String getPyspGrdeCd() {
        return pyspGrdeCd;
    }

    public void setPyspGrdeCd(java.lang.String pyspGrdeCd) {
        this.pyspGrdeCd = pyspGrdeCd;
    }

   

    public java.lang.String getSystemkey() {
        return systemkey;
    }

    public void setSystemkey(java.lang.String systemkey) {
        this.systemkey = systemkey;
    }

    public java.lang.String getPayrMangDeptCd() {
        return this.payrMangDeptCd;
    }
    
    public void setPayrMangDeptCd(java.lang.String payrMangDeptCd) {
        this.payrMangDeptCd = payrMangDeptCd;
    }
    
    public BigDecimal getPayScduSeilNum() {
        return this.payScduSeilNum;
    }
    
    public void setPayScduSeilNum(BigDecimal payScduSeilNum) {
        this.payScduSeilNum = payScduSeilNum;
    }
    
    public java.lang.String getPayCd() {
        return this.payCd;
    }
    
    public void setPayCd(java.lang.String payCd) {
        this.payCd = payCd;
    }
    
    public java.lang.String getEmymtDivCd() {
        return this.emymtDivCd;
    }
    
    public void setEmymtDivCd(java.lang.String emymtDivCd) {
        this.emymtDivCd = emymtDivCd;
    }
    
    public java.lang.String getDpobCd() {
        return this.dpobCd;
    }
    
    public void setDpobCd(java.lang.String dpobCd) {
        this.dpobCd = dpobCd;
    }
    
    public java.lang.String getDeptCd() {
        return this.deptCd;
    }
    
    public void setDeptCd(java.lang.String deptCd) {
        this.deptCd = deptCd;
    }
    
    public java.lang.String getBusinCd() {
        return this.businCd;
    }
    
    public void setBusinCd(java.lang.String businCd) {
        this.businCd = businCd;
    }
    
    public java.lang.String getPernChrgEmpIdenNum() {
        return this.pernChrgEmpIdenNum;
    }
    
    public void setPernChrgEmpIdenNum(java.lang.String pernChrgEmpIdenNum) {
        this.pernChrgEmpIdenNum = pernChrgEmpIdenNum;
    }
    
    public java.lang.String getJobYrMnth() {
        return this.jobYrMnth;
    }
    
    public void setJobYrMnth(java.lang.String jobYrMnth) {
        this.jobYrMnth = jobYrMnth;
    }
    
    public java.lang.String getJobNm() {
        return this.jobNm;
    }
    
    public void setJobNm(java.lang.String jobNm) {
        this.jobNm = jobNm;
    }
    
    public java.lang.String getPymtDt() {
        return this.pymtDt;
    }
    
    public void setPymtDt(java.lang.String pymtDt) {
        this.pymtDt = pymtDt;
    }
    
    public java.lang.String getRflctnBgnnDt() {
        return this.rflctnBgnnDt;
    }
    
    public void setRflctnBgnnDt(java.lang.String rflctnBgnnDt) {
        this.rflctnBgnnDt = rflctnBgnnDt;
    }
    
    public java.lang.String getRflctnEndDt() {
        return this.rflctnEndDt;
    }
    
    public void setRflctnEndDt(java.lang.String rflctnEndDt) {
        this.rflctnEndDt = rflctnEndDt;
    }
    
    public java.lang.String getPayDdlneDt() {
        return this.payDdlneDt;
    }
    
    public void setPayDdlneDt(java.lang.String payDdlneDt) {
        this.payDdlneDt = payDdlneDt;
    }
    
    public java.lang.String getGroFlCretnDt() {
        return this.groFlCretnDt;
    }
    
    public void setGroFlCretnDt(java.lang.String groFlCretnDt) {
        this.groFlCretnDt = groFlCretnDt;
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
    
    public void setRevnDt(java.lang.String revnDt) {
        this.revnDt = revnDt;
    }
    
    public java.lang.String getRevnAddr() {
        return this.revnAddr;
    }
    
    public void setRevnAddr(java.lang.String revnAddr) {
        this.revnAddr = revnAddr;
    }
   
}
