package com.app.smrmf.infc.yearendtax.server.vo;

/**
 * 
* <pre>
* 1. 패키지명 : com.app.smrmf.infc.yearendtax.server.vo
* 2. 타입명 : YetaMessageVO.java
* 3. 작성일 : 2017. 2. 21. 오전 10:02:08
* 4. 작성자 : atres-pc
* 5. 설명 : 연말정산 검증 메시지 vo 
* </pre>
 */
public class YetaMessageVO {
	
	private static final long serialVersionUID = 1L; 
    
	//화면
	 private String dispWindow;
	//검증레코드 
	 private String veriRec;
	//검증레코드내용
	 private String veriRecCtnt;
	//검증대상자명
	 private String veriTgtName;
	// 검증항목-서식항목
	 private String veriItem;
	// 검증오류
	 private String veriError;
	//수정위치내용 
	 private String veriModCtnt;
	//비고   
     private String veriCtnt;
     
     /**
 	 * Comment : 화면
 	 * @fn String getDispWindow()
 	 * @brief date:2017 2017. 2. 21. user:atres-pc
 	 * @return the dispWindow get
 	 */
 	public String getDispWindow() {
 		return dispWindow;
 	}
 	/**
 	 * Comment : 화면
 	 *@fn void setDispWindow(String dispWindow)
 	 *@brief date:2017 2017. 2. 21. user:atres-pc
 	 *@param dispWindow the dispWindow to set
 	 */
 	public void setDispWindow(String dispWindow) {
 		this.dispWindow = dispWindow;
 	}
 	/**
 	 * Comment : 검증레코드
 	 * @fn String getVeriRec()
 	 * @brief date:2017 2017. 2. 21. user:atres-pc
 	 * @return the veriRec get
 	 */
 	public String getVeriRec() {
 		return veriRec;
 	}
 	/**
 	 * Comment : 검증레코드
 	 *@fn void setVeriRec(String veriRec)
 	 *@brief date:2017 2017. 2. 21. user:atres-pc
 	 *@param veriRec the veriRec to set
 	 */
 	public void setVeriRec(String veriRec) {
 		this.veriRec = veriRec;
 	}
 	/**
 	 * Comment : 검증레코드내용
 	 * @fn String getVeriRecCtnt()
 	 * @brief date:2017 2017. 2. 21. user:atres-pc
 	 * @return the veriRecCtnt get
 	 */
 	public String getVeriRecCtnt() {
 		return veriRecCtnt;
 	}
 	/**
 	 * Comment : 검증레코드내용
 	 *@fn void setVeriRecCtnt(String veriRecCtnt)
 	 *@brief date:2017 2017. 2. 21. user:atres-pc
 	 *@param veriRecCtnt the veriRecCtnt to set
 	 */
 	public void setVeriRecCtnt(String veriRecCtnt) {
 		this.veriRecCtnt = veriRecCtnt;
 	}
 	/**
 	 * Comment : 검증대상자명
 	 * @fn String getVeriTgtName()
 	 * @brief date:2017 2017. 2. 21. user:atres-pc
 	 * @return the veriTgtName get
 	 */
 	public String getVeriTgtName() {
 		return veriTgtName;
 	}
 	/**
 	 * Comment : 검증대상자명
 	 *@fn void setVeriTgtName(String veriTgtName)
 	 *@brief date:2017 2017. 2. 21. user:atres-pc
 	 *@param veriTgtName the veriTgtName to set
 	 */
 	public void setVeriTgtName(String veriTgtName) {
 		this.veriTgtName = veriTgtName;
 	}
 	/**
 	 * Comment : 검증항목-서식항목
 	 * @fn String getVeriItem()
 	 * @brief date:2017 2017. 2. 21. user:atres-pc
 	 * @return the veriItem get
 	 */
 	public String getVeriItem() {
 		return veriItem;
 	}
 	/**
 	 * Comment : 검증항목-서식항목
 	 *@fn void setVeriItem(String veriItem)
 	 *@brief date:2017 2017. 2. 21. user:atres-pc
 	 *@param veriItem the veriItem to set
 	 */
 	public void setVeriItem(String veriItem) {
 		this.veriItem = veriItem;
 	}
 	/**
 	 * Comment : 검증오류
 	 * @fn String getVeriError()
 	 * @brief date:2017 2017. 2. 21. user:atres-pc
 	 * @return the veriError get
 	 */
 	public String getVeriError() {
 		return veriError;
 	}
 	/**
 	 * Comment : 검증오류
 	 *@fn void setVeriError(String veriError)
 	 *@brief date:2017 2017. 2. 21. user:atres-pc
 	 *@param veriError the veriError to set
 	 */
 	public void setVeriError(String veriError) {
 		this.veriError = veriError;
 	}
 	/**
 	 * Comment : 수정위치내용
 	 * @fn String getVeriModCtnt()
 	 * @brief date:2017 2017. 2. 21. user:atres-pc
 	 * @return the veriModCtnt get
 	 */
 	public String getVeriModCtnt() {
 		return veriModCtnt;
 	}
 	/**
 	 * Comment : 수정위치내용
 	 *@fn void setVeriModCtnt(String veriModCtnt)
 	 *@brief date:2017 2017. 2. 21. user:atres-pc
 	 *@param veriModCtnt the veriModCtnt to set
 	 */
 	public void setVeriModCtnt(String veriModCtnt) {
 		this.veriModCtnt = veriModCtnt;
 	}
 	/**
 	 * Comment : 비고
 	 * @fn String getVeriCtnt()
 	 * @brief date:2017 2017. 2. 21. user:atres-pc
 	 * @return the veriCtnt get
 	 */
 	public String getVeriCtnt() {
 		return veriCtnt;
 	}
 	/**
 	 * Comment : 비고 
 	 *@fn void setVeriCtnt(String veriCtnt)
 	 *@brief date:2017 2017. 2. 21. user:atres-pc
 	 *@param veriCtnt the veriCtnt to set
 	 */
 	public void setVeriCtnt(String veriCtnt) {
 		this.veriCtnt = veriCtnt;
 	} 
}