package egovframework.com.cmm.service;

import java.io.Serializable;

/**
 * 공통상세코드 모델 클래스
 * @author 공통서비스 개발팀 이중호
 * @since 2009.04.01
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2009.04.01  이중호          최초 생성
 *
 * </pre>
 */
public class CmmnDtlCode implements Serializable {
	

    /** COMM_CD */
    private java.lang.String commCd;
    
    /** COMM_DTL_CD */
    private java.lang.String commDtlCd;
    
    /** COMM_DTL_NM */
    private java.lang.String commDtlNm;
    
    /** COMM_DTL_ORD */
    private java.lang.String commDtlOrd;
    
    /** COMM_DTL_INFO */
    private java.lang.String commDtlInfo;  
     
    
    /** item01 */
    private java.lang.String item01;
    
    /** item02 */
    private java.lang.String item02;
    
    /** item03 */
    private java.lang.String item03;
    
    /** item04 */
    private java.lang.String item04;
    
    /** item05 */
    private java.lang.String item05; 
    
    
    /**
	 * @return the item01
	 */
	public java.lang.String getItem01() {
		return item01;
	}

	/**
	 * @param item01 the item01 to set
	 */
	public void setItem01(java.lang.String item01) {
		this.item01 = item01;
	}

	/**
	 * @return the item02
	 */
	public java.lang.String getItem02() {
		return item02;
	}

	/**
	 * @param item02 the item02 to set
	 */
	public void setItem02(java.lang.String item02) {
		this.item02 = item02;
	}

	/**
	 * @return the item03
	 */
	public java.lang.String getItem03() {
		return item03;
	}

	/**
	 * @param item03 the item03 to set
	 */
	public void setItem03(java.lang.String item03) {
		this.item03 = item03;
	}

	/**
	 * @return the item04
	 */
	public java.lang.String getItem04() {
		return item04;
	}

	/**
	 * @param item04 the item04 to set
	 */
	public void setItem04(java.lang.String item04) {
		this.item04 = item04;
	}

	/**
	 * @return the item05
	 */
	public java.lang.String getItem05() {
		return item05;
	}

	/**
	 * @param item05 the item05 to set
	 */
	public void setItem05(java.lang.String item05) {
		this.item05 = item05;
	}

	/** USE_YN */
    private java.lang.String useYn;
    
    public java.lang.String getCommDtlCd() {
        return this.commDtlCd;
    }
    
    public void setCommDtlCd(java.lang.String commDtlCd) {
        this.commDtlCd = commDtlCd;
    }
    
    public java.lang.String getCommDtlNm() {
        return this.commDtlNm;
    }
    
    public void setCommDtlNm(java.lang.String commDtlNm) {
        this.commDtlNm = commDtlNm;
    }
    
    public java.lang.String getCommDtlOrd() {
        return this.commDtlOrd;
    }
    
    public void setCommDtlOrd(java.lang.String commDtlOrd) {
        this.commDtlOrd = commDtlOrd;
    }
    
    public java.lang.String getCommDtlInfo() {
        return this.commDtlInfo;
    }
    
    public void setCommDtlInfo(java.lang.String commDtlInfo) {
        this.commDtlInfo = commDtlInfo;
    }
    
    public java.lang.String getCommCd() {
        return this.commCd;
    }
    
    public void setCommCd(java.lang.String commCd) {
        this.commCd = commCd;
    }
     
    
    public java.lang.String getUseYn() {
        return this.useYn;
    }
    
    public void setUseYn(java.lang.String useYn) {
        this.useYn = useYn;
    } 

}
