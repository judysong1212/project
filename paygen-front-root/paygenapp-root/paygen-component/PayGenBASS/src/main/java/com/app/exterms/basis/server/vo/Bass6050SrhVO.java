package com.app.exterms.basis.server.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Class Name : Remt1000DefaultVO.java
 * @Description : Remt1000 Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.10.17
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Bass6050SrhVO implements Serializable {
	 
    /** 현재페이지 */
    private int pageIndex = 1;
    
    /** 페이지갯수 */
    private int pageUnit = 10;
    
    /** 페이지사이즈 */
    private int pageSize = 10;

    /** firstIndex */
    private int firstIndex = 1;

    /** lastIndex */
    private int lastIndex = 1;

    /** recordCountPerPage */
    private int recordCountPerPage = 10;
    
    /** set 사업장코드 : dpobCd */
    private String dpobCd;

    /** set 퇴직금가산율일련번호 : sevePayAddRateSeilNum */
    private BigDecimal sevePayAddRateSeilNum;

    /** set 직종코드 : typOccuCd */
    private String typOccuCd;

    /** set 호봉등급코드 : pyspGrdeCd */
    private String pyspGrdeCd;

    private String dtilOccuClsDivCd; 
    
    /** 직종세통합코드 dtilOccuInttnCd */
    private String dtilOccuInttnCd;
    
    /** set 퇴직금가산율유형코드 : sevePayAddRateFrmCd */
    private String sevePayAddRateFrmCd;

    private String dtilOccuInttnCdAuth;

    private String deptCdAuth;

    private List<String> deptCdArr;

    private String deptCd;

    private String payrMangDeptYn;

    private String payrMangDeptCd;

    private String clutYrMnth01;

    private String clutYrMnth02;

    private String usrId;

    private List<String> dtilOccuInttnCdArr;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageUnit() {
        return pageUnit;
    }

    public void setPageUnit(int pageUnit) {
        this.pageUnit = pageUnit;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getFirstIndex() {
        return firstIndex;
    }

    public void setFirstIndex(int firstIndex) {
        this.firstIndex = firstIndex;
    }

    public int getLastIndex() {
        return lastIndex;
    }

    public void setLastIndex(int lastIndex) {
        this.lastIndex = lastIndex;
    }

    public int getRecordCountPerPage() {
        return recordCountPerPage;
    }

    public void setRecordCountPerPage(int recordCountPerPage) {
        this.recordCountPerPage = recordCountPerPage;
    }

    public String getDpobCd() {
        return dpobCd;
    }

    public void setDpobCd(String dpobCd) {
        this.dpobCd = dpobCd;
    }

    public BigDecimal getSevePayAddRateSeilNum() {
        return sevePayAddRateSeilNum;
    }

    public void setSevePayAddRateSeilNum(BigDecimal sevePayAddRateSeilNum) {
        this.sevePayAddRateSeilNum = sevePayAddRateSeilNum;
    }

    public String getTypOccuCd() {
        return typOccuCd;
    }

    public void setTypOccuCd(String typOccuCd) {
        this.typOccuCd = typOccuCd;
    }

    public String getPyspGrdeCd() {
        return pyspGrdeCd;
    }

    public void setPyspGrdeCd(String pyspGrdeCd) {
        this.pyspGrdeCd = pyspGrdeCd;
    }

    public String getDtilOccuClsDivCd() {
        return dtilOccuClsDivCd;
    }

    public void setDtilOccuClsDivCd(String dtilOccuClsDivCd) {
        this.dtilOccuClsDivCd = dtilOccuClsDivCd;
    }

    public String getDtilOccuInttnCd() {
        return dtilOccuInttnCd;
    }

    public void setDtilOccuInttnCd(String dtilOccuInttnCd) {
        this.dtilOccuInttnCd = dtilOccuInttnCd;
    }

    public String getSevePayAddRateFrmCd() {
        return sevePayAddRateFrmCd;
    }

    public void setSevePayAddRateFrmCd(String sevePayAddRateFrmCd) {
        this.sevePayAddRateFrmCd = sevePayAddRateFrmCd;
    }

    public String getDtilOccuInttnCdAuth() {
        return dtilOccuInttnCdAuth;
    }

    public void setDtilOccuInttnCdAuth(String dtilOccuInttnCdAuth) {
        this.dtilOccuInttnCdAuth = dtilOccuInttnCdAuth;
    }

    public String getDeptCdAuth() {
        return deptCdAuth;
    }

    public void setDeptCdAuth(String deptCdAuth) {
        this.deptCdAuth = deptCdAuth;
    }

    public List<String> getDeptCdArr() {
        return deptCdArr;
    }

    public void setDeptCdArr(List<String> deptCdArr) {
        this.deptCdArr = deptCdArr;
    }

    public String getDeptCd() {
        return deptCd;
    }

    public void setDeptCd(String deptCd) {
        this.deptCd = deptCd;
    }

    public String getPayrMangDeptYn() {
        return payrMangDeptYn;
    }

    public void setPayrMangDeptYn(String payrMangDeptYn) {
        this.payrMangDeptYn = payrMangDeptYn;
    }

    public String getPayrMangDeptCd() {
        return payrMangDeptCd;
    }

    public void setPayrMangDeptCd(String payrMangDeptCd) {
        this.payrMangDeptCd = payrMangDeptCd;
    }

    public String getClutYrMnth01() {
        return clutYrMnth01;
    }

    public void setClutYrMnth01(String clutYrMnth01) {
        this.clutYrMnth01 = clutYrMnth01;
    }

    public String getClutYrMnth02() {
        return clutYrMnth02;
    }

    public void setClutYrMnth02(String clutYrMnth02) {
        this.clutYrMnth02 = clutYrMnth02;
    }

    public String getUsrId() {
        return usrId;
    }

    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    public List<String> getDtilOccuInttnCdArr() {
        return dtilOccuInttnCdArr;
    }

    public void setDtilOccuInttnCdArr(List<String> dtilOccuInttnCdArr) {
        this.dtilOccuInttnCdArr = dtilOccuInttnCdArr;
    }
}
