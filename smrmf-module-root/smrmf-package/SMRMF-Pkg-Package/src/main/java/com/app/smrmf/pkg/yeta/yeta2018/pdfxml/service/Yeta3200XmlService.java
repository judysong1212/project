package com.app.smrmf.pkg.yeta.yeta2018.pdfxml.service;

import java.util.List;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfA102y_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfB101y_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfC101y_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfC202y_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfC301y_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfC401y_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfD101y_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfE102y_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfF102y_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfG104y_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfG106y_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfG107y_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfG205m_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfG205y_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfG206m_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfG206y_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfG207m_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfG207y_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfG304m_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfG304y_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfG306m_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfG306y_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfG307m_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfG307y_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfJ101y_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfJ203m_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfJ203ySrh_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfJ203y_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfJ301y_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfJ401y_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfK101m_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfK101y_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfL102y_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfN101y_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfO101m_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfO101y_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfP101m_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfP101y_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfP102m_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfP102y_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfYE162015_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161010_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161040_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161050_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161055_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161060_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161070_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161080_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161090_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe162010_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe162020_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe162030_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe162040_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe164010_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe165010_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe165020_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe165030_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe166020_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe167010_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe167020_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe167030_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe167040_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe167050_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe167060_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe167070_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe167110_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe167120_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe167130_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe167140_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe167150_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe167210_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe167220_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe167230_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe167240_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe167310_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe167320_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe167410_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe167420_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe167430_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe167440_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe167510_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe167520_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe167530_2018_VO;

/**
 * @Class Name : Yeta3900Service.java
 * @Description : Yeta3900 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2016.01.18
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface Yeta3200XmlService {

	/**
	 * <pre>
	 * 1. 개요 : 일반 및 장애인 전용 보장성 보험 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_A102Y_2018_Delete
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfA102yVo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_A102Y_2018_Delete(InfcPkgPdfA102y_2018_VO yetaPdfA102yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 일반 및 장애인 전용 보장성 보험 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_A102Y_2018_Insert
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfA102yVo
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_A102Y_2018_Insert(InfcPkgPdfA102y_2018_VO yetaPdfA102yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 의료비 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_B101Y_2018_Delete
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfB101yVo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_B101Y_2018_Delete(InfcPkgPdfB101y_2018_VO yetaPdfB101yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 의료비 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_B101Y_2018_Insert
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfB101yVo
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_B101Y_2018_Insert(InfcPkgPdfB101y_2018_VO yetaPdfB101yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 교육비 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_C101Y_2018_Delete
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfC101yVo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_C101Y_2018_Delete(InfcPkgPdfC101y_2018_VO yetaPdfC101yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 교육비 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_C101Y_2018_Insert
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfC101yVo
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_C101Y_2018_Insert(InfcPkgPdfC101y_2018_VO yetaPdfC101yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 직업휸련비 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_C202Y_2018_Delete
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfC202yVo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_C202Y_2018_Delete(InfcPkgPdfC202y_2018_VO yetaPdfC202yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 직업훈련비 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_C202Y_2018_Insert
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfC202yVo
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_C202Y_2018_Insert(InfcPkgPdfC202y_2018_VO yetaPdfC202yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 교복구입비 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_C301Y_2018_Delete
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfC301yVo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_C301Y_2018_Delete(InfcPkgPdfC301y_2018_VO yetaPdfC301yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 교복구입비 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_C301Y_2018_Insert
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfC301yVo
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_C301Y_2018_Insert(InfcPkgPdfC301y_2018_VO yetaPdfC301yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 학자금대출 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_C401Y_2018_Delete
	 * @date : 2017. 12. 07.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfC401yVo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_C401Y_2018_Delete(InfcPkgPdfC401y_2018_VO yetaPdfC341yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 학자금대출 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_C401Y_2018_Insert
	 * @date : 2017. 12. 07.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfC401yVo
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_C401Y_2018_Insert(InfcPkgPdfC401y_2018_VO yetaPdfC401yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 개인연금저축 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_D101Y_2018_Delete
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfD101yVo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_D101Y_2018_Delete(InfcPkgPdfD101y_2018_VO yetaPdfD101yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 개인연금저축 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_D101Y_2018_Insert
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfD101yVo
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_D101Y_2018_Insert(InfcPkgPdfD101y_2018_VO yetaPdfD101yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 연금저축 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_E102Y_2018_Delete
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfE102yVo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_E102Y_2018_Delete(InfcPkgPdfE102y_2018_VO yetaPdfE102yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 연금저축 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_E102Y_2018_Insert
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfE102yVo
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_E102Y_2018_Insert(InfcPkgPdfE102y_2018_VO yetaPdfE102yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 퇴직연금 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_F102Y_2018_Delete
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfF102yVo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_F102Y_2018_Delete(InfcPkgPdfF102y_2018_VO yetaPdfF102yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 퇴직연금 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_F102Y_2018_Insert
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfF102yVo
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_F102Y_2018_Insert(InfcPkgPdfF102y_2018_VO yetaPdfF102yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 신용카드 데이터 삭제(2016년 귀속)
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_G104Y_2018_Delete
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfG104yVo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_G104Y_2018_Delete(InfcPkgPdfG104y_2018_VO yetaPdfG104yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 신용카드 데이터 입력(2016년 귀속)
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_G104Y_2018_Insert
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfG104yVo
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_G104Y_2018_Insert(InfcPkgPdfG104y_2018_VO yetaPdfG104yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 신용카드 데이터 삭제(2017년 귀속)
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_G107Y_2018_Delete
	 * @date : 2017. 12. 07.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfG106yVo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_G107Y_2018_Delete(InfcPkgPdfG107y_2018_VO yetaPdfG106yVo) throws Exception;
	
	/**
	 * <pre>
	 * 1. 개요 : 신용카드 데이터 입력(2017년 귀속)
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_G106Y_2018_Insert
	 * @date : 2017. 12. 07.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfG106yVo
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_G107Y_2018_Insert(InfcPkgPdfG107y_2018_VO yetaPdfG107yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 현금영수증 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_G205M_2018_Delete
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfG205mVo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_G205M_2018_Delete(InfcPkgPdfG205m_2018_VO yetaPdfG205mVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 현금영수증 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_G205M_2018_Insert
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfG205mVo
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_G205M_2018_Insert(InfcPkgPdfG205m_2018_VO yetaPdfG205mVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 현금영수증 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_G205Y_2018_Delete
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfG205yVo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_G205Y_2018_Delete(InfcPkgPdfG205y_2018_VO yetaPdfG205yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 현금영수증 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_G205Y_2018_Insert
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfG205yVo
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_G205Y_2018_Insert(InfcPkgPdfG205y_2018_VO yetaPdfG205yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 현금영수증 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_G206M_2018_Delete
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfG206mVo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_G207M_2018_Delete(InfcPkgPdfG207m_2018_VO yetaPdfG207mVo) throws Exception; 
	

	/**
	 * <pre>
	 * 1. 개요 : 현금영수증 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_G206M_2018_Insert
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfG206mVo
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_G207M_2018_Insert(InfcPkgPdfG207m_2018_VO yetaPdfG207mVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 현금영수증 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_G206Y_2018_Delete
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfG206yVo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_G207Y_2018_Delete(InfcPkgPdfG207y_2018_VO yetaPdfG207yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 현금영수증 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_G206Y_2018_Insert
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfG206yVo
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_G207Y_2018_Insert(InfcPkgPdfG207y_2018_VO yetaPdfG207yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 직붙카드 등 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_G304Y_2018_Delete
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfG304yVo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_G304Y_2018_Delete(InfcPkgPdfG304y_2018_VO yetaPdfG304yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 직불카드 등 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_G304Y_2018_Insert
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfG304yVo
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_G304Y_2018_Insert(InfcPkgPdfG304y_2018_VO yetaPdfG304yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 직붙카드 등 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_G304M_2018_Delete
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfG304mVo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_G304M_2018_Delete(InfcPkgPdfG304m_2018_VO yetaPdfG304mVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 직불카드 등 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_G304M_2018_Insert
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfG304mVo
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_G304M_2018_Insert(InfcPkgPdfG304m_2018_VO yetaPdfG304mVo) throws Exception; 
	

	/**
	 * <pre>
	 * 1. 개요 : 직불카드 등 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_G306M_2018_Insert
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfG306mVo
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_G307M_2018_Insert(InfcPkgPdfG307m_2018_VO yetaPdfG307mVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 직붙카드 등 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_G306Y_2018_Delete
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfG306yVo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_G307Y_2018_Delete(InfcPkgPdfG307y_2018_VO yetaPdfG307yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 직불카드 등 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_G306Y_2018_Insert
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfG306yVo
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_G307Y_2018_Insert(InfcPkgPdfG307y_2018_VO yetaPdfG307yVo) throws Exception; 


	/**
	 * <pre>
	 * 1. 개요 : 직붙카드 등 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_G306M_2018_Delete
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfG306mVo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_G307M_2018_Delete(InfcPkgPdfG307m_2018_VO yetaPdfG307mVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 주택임차차입금_원리금상환액 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_J101Y_2018_Delete
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfJ101yVo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_J101Y_2018_Delete(InfcPkgPdfJ101y_2018_VO yetaPdfJ101yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 주택임차차입금_원리금상환액 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_J101Y_2018_Insert
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfJ101yVo
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_J101Y_2018_Insert(InfcPkgPdfJ101y_2018_VO yetaPdfJ101yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 장기주책저당차입금 이자상환액 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_J203Y_2018_Delete
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfJ203yVo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_J203Y_2018_Delete(InfcPkgPdfJ203y_2018_VO yetaPdfJ203yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 장기주책저당차입금 이자상환액 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_J203Y_2018_Insert
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfJ203yVo
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_J203Y_2018_Insert(InfcPkgPdfJ203y_2018_VO yetaPdfJ203yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 장기주책저당차입금 이자상환액 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_J203M_2018_Delete
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfJ203mVo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_J203M_2018_Delete(InfcPkgPdfJ203m_2018_VO yetaPdfJ203mVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 장기주책저당차입금 이자상환액 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_J203M_2018_Insert
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfJ203mVo
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_J203M_2018_Insert(InfcPkgPdfJ203m_2018_VO yetaPdfJ203mVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 주택마련저축 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_J301Y_2018_Delete
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfJ103yVo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_J301Y_2018_Delete(InfcPkgPdfJ301y_2018_VO yetaPdfJ103yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 주택마련저축 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_J301Y_2018_Insert
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfJ103yVo
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_J301Y_2018_Insert(InfcPkgPdfJ301y_2018_VO yetaPdfJ103yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 목돈 안드는 전세 이자상환액 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_J401Y_2018_Delete
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfJ401yVo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_J401Y_2018_Delete(InfcPkgPdfJ401y_2018_VO yetaPdfJ401yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 목돈 안드는 전세 이자상환액 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_J401Y_2018_Insert
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfJ401yVo
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_J401Y_2018_Insert(InfcPkgPdfJ401y_2018_VO yetaPdfJ401yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 소기업소강공인 공제부금 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_K101M_2018_Delete
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfK101mVo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_K101M_2018_Delete(InfcPkgPdfK101m_2018_VO yetaPdfK101mVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 소기업소강공인 공제부금 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_K101M_2018_Insert
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfK101mVo
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_K101M_2018_Insert(InfcPkgPdfK101m_2018_VO yetaPdfK101mVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 소기업소강공인 공제부금 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_K101Y_2018_Delete
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfK101yVo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_K101Y_2018_Delete(InfcPkgPdfK101y_2018_VO yetaPdfK101yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 소기업소강공인 공제부금 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_K101Y_2018_Insert
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfK101yVo
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_K101Y_2018_Insert(InfcPkgPdfK101y_2018_VO yetaPdfK101yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 기부금 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_L102Y_2018_Delete
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfL102yVo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_L102Y_2018_Delete(InfcPkgPdfL102y_2018_VO yetaPdfL102yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 기부금 공제부금 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_L102Y_2018_Insert
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfL102yVo
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_L102Y_2018_Insert(InfcPkgPdfL102y_2018_VO yetaPdfL102yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 장기집합투자증권저축 공제부금 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_N101Y_2018_Delete
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfN101yVo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_N101Y_2018_Delete(InfcPkgPdfN101y_2018_VO yetaPdfN101yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 장기집합투자증권저축 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_N101Y_2018_Insert
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfN101yVo
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_N101Y_2018_Insert(InfcPkgPdfN101y_2018_VO yetaPdfN101yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 건강보험료 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_O101M_2018_Delete
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfO101mVo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_O101M_2018_Delete(InfcPkgPdfO101m_2018_VO yetaPdfO101mVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 건강보험료 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_O101M_2018_Insert
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfO101mVo
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_O101M_2018_Insert(InfcPkgPdfO101m_2018_VO yetaPdfO101mVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 건강보험료 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_O101Y_2018_Delete
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfO101uVo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_O101Y_2018_Delete(InfcPkgPdfO101y_2018_VO yetaPdfO101yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 건강보험료 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_O101M_2018_Insert
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfO101uVo
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_O101Y_2018_Insert(InfcPkgPdfO101y_2018_VO yetaPdfO101uVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 국민연금보험료 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_P101M_2018_Delete
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfP101mVo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_P101M_2018_Delete(InfcPkgPdfP101m_2018_VO yetaPdfP101mVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 국민연금보험료 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_P101M_2018_Insert
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfP101mVo
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_P101M_2018_Insert(InfcPkgPdfP101m_2018_VO yetaPdfP101mVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 국민연금보험료 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_P101Y_2018_Delete
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfP101yVo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_P101Y_2018_Delete(InfcPkgPdfP101y_2018_VO yetaPdfP101yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 국민연금보험료 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_P101Y_2018_Insert
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfP101yVo
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_P101Y_2018_Insert(InfcPkgPdfP101y_2018_VO yetaPdfP101yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 국민연금보험료 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_P102M_2018_Delete
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfP102mVo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_P102M_2018_Delete(InfcPkgPdfP102m_2018_VO yetaPdfP102mVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 국민연금보험료 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_P102M_2018_Insert
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfP102mVo
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_P102M_2018_Insert(InfcPkgPdfP102m_2018_VO yetaPdfP102mVo) throws Exception; 
	/**
	 * <pre>
	 * 1. 개요 : 국민연금보험료 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_P102Y_2018_Delete
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfP102yVo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_P102Y_2018_Delete(InfcPkgPdfP102y_2018_VO yetaPdfP102yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 국민연금보험료 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_P102Y_2018_Insert
	 * @date : 2017. 11. 28.
	 * @author : kyumin.jang
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 28.		kyumin.jang				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfP102yVo
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_P102Y_2018_Insert(InfcPkgPdfP102y_2018_VO yetaPdfP102yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE162015_2018_Delete
	 * @date : 2017. 12. 21.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 12. 21.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfYE162015Vo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_YE162015_2018_Delete(InfcPkgPdfYE162015_2018_VO yetaPdfYE162015Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE162015_2018_Insert
	 * @date : 2017. 12. 21.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 12. 21.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaPdfYE162015Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_YE162015_2018_Insert(InfcPkgPdfYE162015_2018_VO yetaPdfYE162015Vo) throws Exception; 
	
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167010_2018_Delete
	 * @date : 2017. 12. 27.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 12. 27.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167010Vo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_YE167010_2018_Delete(InfcPkgYe167010_2018_VO yetaYE167010Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167010_2018_Insert
	 * @date : 2017. 12. 27.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 12. 27.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167010Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_YE167010_2018_Insert(InfcPkgYe167010_2018_VO yetaYE167010Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167020_2018_Delete
	 * @date : 2017. 12. 27.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 12. 27.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167020Vo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_YE167020_2018_Delete(InfcPkgYe167020_2018_VO yetaYE167020Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167020_2018_Insert
	 * @date : 2017. 12. 27.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 12. 27.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167020Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_YE167020_2018_Insert(InfcPkgYe167020_2018_VO yetaYE167020Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167030_2018_Delete
	 * @date : 2017. 12. 27.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 12. 27.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167030Vo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_YE167030_2018_Delete(InfcPkgYe167030_2018_VO yetaYE167030Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167030_2018_Insert
	 * @date : 2017. 12. 27.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 12. 27.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167030Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_YE167030_2018_Insert(InfcPkgYe167030_2018_VO yetaYE167030Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167040_2018_Delete
	 * @date : 2017. 12. 27.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 12. 27.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167040Vo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_YE167040_2018_Delete(InfcPkgYe167040_2018_VO yetaYE167040Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167040_2018_Insert
	 * @date : 2017. 12. 27.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 12. 27.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167040Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_YE167040_2018_Insert(InfcPkgYe167040_2018_VO yetaYE167040Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167050_2018_Delete
	 * @date : 2017. 12. 27.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 12. 27.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167050Vo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_YE167050_2018_Delete(InfcPkgYe167050_2018_VO yetaYE167050Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167050_2018_Insert
	 * @date : 2017. 12. 27.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 12. 27.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167050Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_YE167050_2018_Insert(InfcPkgYe167050_2018_VO yetaYE167050Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167060_2018_Delete
	 * @date : 2017. 12. 27.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 12. 27.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167060Vo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_YE167060_2018_Delete(InfcPkgYe167060_2018_VO yetaYE167060Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167060_2018_Insert
	 * @date : 2017. 12. 27.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 12. 27.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167060Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_YE167060_2018_Insert(InfcPkgYe167060_2018_VO yetaYE167060Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167070_2018_Delete
	 * @date : 2017. 12. 27.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 12. 27.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167070Vo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_YE167070_2018_Delete(InfcPkgYe167070_2018_VO yetaYE167070Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167070_2018_Insert
	 * @date : 2017. 12. 27.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 12. 27.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167070Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_YE167070_2018_Insert(InfcPkgYe167070_2018_VO yetaYE167070Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167530_2018_Delete
	 * @date : 2018. 1. 2.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 2.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167530Vo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_YE167530_2018_Delete(InfcPkgYe167530_2018_VO yetaYE167530Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167530_2018_Insert
	 * @date : 2018. 1. 2.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 2.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167530Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_YE167530_2018_Insert(InfcPkgYe167530_2018_VO yetaYE167530Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167110_2018_Delete
	 * @date : 2018. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167110Vo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_YE167110_2018_Delete(InfcPkgYe167110_2018_VO yetaYE167110Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167110_2018_Insert
	 * @date : 2018. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167110Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_YE167110_2018_Insert(InfcPkgYe167110_2018_VO yetaYE167110Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167120_2018_Delete
	 * @date : 2018. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167120Vo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_YE167120_2018_Delete(InfcPkgYe167120_2018_VO yetaYE167120Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167120_2018_Insert
	 * @date : 2018. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167120Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_YE167120_2018_Insert(InfcPkgYe167120_2018_VO yetaYE167120Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167130_2018_Delete
	 * @date : 2018. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167130Vo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_YE167130_2018_Delete(InfcPkgYe167130_2018_VO yetaYE167130Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167130_2018_Insert
	 * @date : 2018. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167130Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_YE167130_2018_Insert(InfcPkgYe167130_2018_VO yetaYE167130Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167140_2018_Delete
	 * @date : 2018. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167140Vo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_YE167140_2018_Delete(InfcPkgYe167140_2018_VO yetaYE167140Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167140_2018_Insert
	 * @date : 2018. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167140Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_YE167140_2018_Insert(InfcPkgYe167140_2018_VO yetaYE167140Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167150_2018_Delete
	 * @date : 2018. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167150Vo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_YE167150_2018_Delete(InfcPkgYe167150_2018_VO yetaYE167150Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167150_2018_Insert
	 * @date : 2018. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167150Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_YE167150_2018_Insert(InfcPkgYe167150_2018_VO yetaYE167150Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167210_2018_Delete
	 * @date : 2018. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167210Vo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_YE167210_2018_Delete(InfcPkgYe167210_2018_VO yetaYE167210Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167210_2018_Insert
	 * @date : 2018. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167210Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_YE167210_2018_Insert(InfcPkgYe167210_2018_VO yetaYE167210Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167220_2018_Delete
	 * @date : 2018. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167220Vo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_YE167220_2018_Delete(InfcPkgYe167220_2018_VO yetaYE167220Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167220_2018_Insert
	 * @date : 2018. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167220Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_YE167220_2018_Insert(InfcPkgYe167220_2018_VO yetaYE167220Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167230_2018_Delete
	 * @date : 2018. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167230Vo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_YE167230_2018_Delete(InfcPkgYe167230_2018_VO yetaYE167230Vo) throws Exception; 
		
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167230_2018_Insert
	 * @date : 2018. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167230Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_YE167230_2018_Insert(InfcPkgYe167230_2018_VO yetaYE167230Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167240_2018_Delete
	 * @date : 2018. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167240Vo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_YE167240_2018_Delete(InfcPkgYe167240_2018_VO yetaYE167240Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167240_2018_Insert
	 * @date : 2018. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167240Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_YE167240_2018_Insert(InfcPkgYe167240_2018_VO yetaYE167240Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167310_2018_Delete
	 * @date : 2018. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167310Vo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_YE167310_2018_Delete(InfcPkgYe167310_2018_VO yetaYE167310Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167310_2018_Insert
	 * @date : 2018. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167310Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_YE167310_2018_Insert(InfcPkgYe167310_2018_VO yetaYE167310Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167320_2018_Delete
	 * @date : 2018. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167320Vo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_YE167320_2018_Delete(InfcPkgYe167320_2018_VO yetaYE167320Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167320_2018_Insert
	 * @date : 2018. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167320Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_YE167320_2018_Insert(InfcPkgYe167320_2018_VO yetaYE167320Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167410_2018_Delete
	 * @date : 2018. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167410Vo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_YE167410_2018_Delete(InfcPkgYe167410_2018_VO yetaYE167410Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167410_2018_Insert
	 * @date : 2018. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167410Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_YE167410_2018_Insert(InfcPkgYe167410_2018_VO yetaYE167410Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167420_2018_Delete
	 * @date : 2018. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167420Vo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_YE167420_2018_Delete(InfcPkgYe167420_2018_VO yetaYE167420Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167420_2018_Insert
	 * @date : 2018. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167420Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_YE167420_2018_Insert(InfcPkgYe167420_2018_VO yetaYE167420Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167430_2018_Delete
	 * @date : 2018. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167430Vo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_YE167430_2018_Delete(InfcPkgYe167430_2018_VO yetaYE167430Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167430_2018_Insert
	 * @date : 2018. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167430Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_YE167430_2018_Insert(InfcPkgYe167430_2018_VO yetaYE167430Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167440_2018_Delete
	 * @date : 2018. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167440Vo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_YE167440_2018_Delete(InfcPkgYe167440_2018_VO yetaYE167440Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167440_2018_Insert
	 * @date : 2018. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167440Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_YE167440_2018_Insert(InfcPkgYe167440_2018_VO yetaYE167440Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167510_2018_Delete
	 * @date : 2018. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167510Vo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_YE167510_2018_Delete(InfcPkgYe167510_2018_VO yetaYE167510Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167510_2018_Insert
	 * @date : 2018. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167510Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_YE167510_2018_Insert(InfcPkgYe167510_2018_VO yetaYE167510Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167520_2018_Delete
	 * @date : 2018. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167520Vo
	 * @throws Exception
	 */ 	
	public void yeta3200_PDF_YE167520_2018_Delete(InfcPkgYe167520_2018_VO yetaYE167520Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta3200_PDF_YE167520_2018_Insert
	 * @date : 2018. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167520Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta3200_PDF_YE167520_2018_Insert(InfcPkgYe167520_2018_VO yetaYE167520Vo) throws Exception; 
	
	/*********************************************************************************************** 
	 * 2017년도 간소화 자료 업데이트 부분처리 서비스 시작 정산데이타 반영부 처리 메서드 시작
	 ***********************************************************************************************/
	
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 보장성,장애인보장성 보험료 개별적업데이트  
	 * 2. 처리내용 : 보장성,장애인보장성 보험료 개별적업데이트
	 * </pre>
	 * @Method Name : PdfYeta2018_A102Y_YE161040_Update
	 * @date : 2018. 1. 22.
	 * @author : atres
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 22.		atres				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param ye161010_2018_VO
	 * @return
	 * @throws Exception
	 */
	public int PdfYeta2018_A102Y_YE161040_Update(InfcPkgYe161040_2018_VO ye161040_2018_VO) throws Exception; 
	public String fnYeta3200_A102Y_YE161080_2018_Update(InfcPkgYe161080_2018_VO infcPkgYe161080Vo) throws Exception; 
	 
	//의료비 
	public String PdfYeta3200_B101Y_YE164010_Delete(InfcPkgYe164010_2018_VO infcPkgYe164010Vo) throws Exception; 
	public String PdfYeta3200_B101Y_YE164010_Insert(InfcPkgYe164010_2018_VO infcPkgYe164010Vo) throws Exception; 
	
	public int PdfYeta2018_B101Y_YE161040_Update(InfcPkgYe161040_2018_VO ye161040_2018_VO) throws Exception; 
	
	// 의료비정리 합계
	public int fnYeta3200_B101Y_YE161080_2018_Update(InfcPkgYe161080_2018_VO infcPkgYe161080Vo) throws Exception; 
  
	
	//교육비처리 
	public String PdfYeta3200_C101Y_YE161090_Delete(InfcPkgYe161090_2018_VO infcPkgYe161090Vo) throws Exception; 
	public String PdfYeta3200_C101Y_YE161090_Insert(InfcPkgYe161090_2018_VO infcPkgYe161090Vo) throws Exception; 
	 
	public int PdfYeta2018_C101Y_YE161040_Update(InfcPkgYe161040_2018_VO ye161040_2018_VO) throws Exception; 
	
	public String fnYeta3200_C101Y_YE161080_2018_Update(InfcPkgYe161080_2018_VO infcPkgYe161080Vo) throws Exception; 
	
	
	//직업훈련비
	public String PdfYeta3200_C202Y_YE161090_Delete(InfcPkgYe161090_2018_VO infcPkgYe161090Vo) throws Exception; 
	public String PdfYeta3200_C202Y_YE161090_Insert(InfcPkgYe161090_2018_VO infcPkgYe161090Vo) throws Exception; 
	 
	//public String PdfYeta2018_C202Y_YE161040_Update(InfcPkgYe161040_2018_VO ye161040_2018_VO) throws Exception; 
	
	//public String fnYeta3200_C202Y_YE161080_2018_Update(InfcPkgYe161080_2018_VO infcPkgYe161080Vo) throws Exception; 
	
	
	//교복구입비
	public String PdfYeta3200_C301Y_YE161090_Delete(InfcPkgYe161090_2018_VO infcPkgYe161090Vo) throws Exception; 
	public String PdfYeta3200_C301Y_YE161090_Insert(InfcPkgYe161090_2018_VO infcPkgYe161090Vo) throws Exception; 
	 
//	public String PdfYeta2018_C301Y_YE161040_Update(InfcPkgYe161040_2018_VO ye161040_2018_VO) throws Exception; 
	
//	public String fnYeta3200_C301Y_YE161080_2018_Update(InfcPkgYe161080_2018_VO infcPkgYe161080Vo) throws Exception; 
	
	
	//학자금대출
	public String PdfYeta3200_C401Y_YE161090_Delete(InfcPkgYe161090_2018_VO infcPkgYe161090Vo) throws Exception; 
	public String PdfYeta3200_C401Y_YE161090_Insert(InfcPkgYe161090_2018_VO infcPkgYe161090Vo) throws Exception; 
	 
//	public String PdfYeta2018_C401Y_YE161040_Update(InfcPkgYe161040_2018_VO ye161040_2018_VO) throws Exception; 
//	
//	public String fnYeta3200_C401Y_YE161080_2018_Update(InfcPkgYe161080_2018_VO infcPkgYe161080Vo) throws Exception; 
		
	//개인연금저축 
	public String PdfYeta3200_D101Y_YE162010_Delete(InfcPkgYe162010_2018_VO infcPkgYe162010Vo) throws Exception; 
	public String PdfYeta3200_D101Y_YE162010_Insert(InfcPkgYe162010_2018_VO infcPkgYe162010Vo) throws Exception; 
	 
	public String fnYeta3200_D101Y_YE161070_2018_Update(InfcPkgYe161070_2018_VO infcPkgYe161070Vo) throws Exception; 
	
	//연금저축
	
	public String PdfYeta3200_E102Y_YE162010_Delete(InfcPkgYe162010_2018_VO infcPkgYe162010Vo) throws Exception; 
	public String PdfYeta3200_E102Y_YE162010_Insert(InfcPkgYe162010_2018_VO infcPkgYe162010Vo) throws Exception; 
	 
	public String fnYeta3200_E102Y_YE161080_2018_Update(InfcPkgYe161080_2018_VO infcPkgYe161080Vo) throws Exception; 
	
	
	//퇴직연금 
	public String PdfYeta3200_F102Y_YE162020_Delete(InfcPkgYe162020_2018_VO infcPkgYe162020Vo) throws Exception; 
	public String PdfYeta3200_F102Y_YE162020_Insert(InfcPkgYe162020_2018_VO infcPkgYe162020Vo) throws Exception; 
	 
	public String fnYeta3200_F102Y_YE161080_2018_Update(InfcPkgYe161080_2018_VO infcPkgYe161080Vo) throws Exception; 
	

	//YE161040 소득공제명세에 신용카드 
	//public int PdfYeta2018_G106Y_YE161040_Update(InfcPkgYe161040_2018_VO ye161040_2018_VO) throws Exception; 
	
	//public String PdfYeta3200_G106Y_YE166020_Update(InfcPkgYe166020_2018_VO infcPkgYe166020Vo) throws Exception;  
	
	//public String fnYeta3200_G106Y_YE161070_2018_Update(InfcPkgYe161070_2018_VO infcPkgYe161070Vo) throws Exception; 
	
	public int PdfYeta2018_G107Y_YE161040_Update(InfcPkgYe161040_2018_VO ye161040_2018_VO) throws Exception; 
	
	public String PdfYeta3200_G107Y_YE166020_Update(InfcPkgYe166020_2018_VO infcPkgYe166020Vo) throws Exception;  
	
	public String fnYeta3200_G107Y_YE161070_2018_Update(InfcPkgYe161070_2018_VO infcPkgYe161070Vo) throws Exception; 
	 
  //YE161040 소득공제명세에 현금영수증  
	//public int PdfYeta2018_G206Y_YE161040_Update(InfcPkgYe161040_2018_VO ye161040_2018_VO) throws Exception; 
	 
	//public String fnYeta3200_G206Y_YE161070_2018_Update(InfcPkgYe161070_2018_VO infcPkgYe161070Vo) throws Exception; 
	
	public int PdfYeta2018_G207Y_YE161040_Update(InfcPkgYe161040_2018_VO ye161040_2018_VO) throws Exception; 
	 
	public String fnYeta3200_G207Y_YE161070_2018_Update(InfcPkgYe161070_2018_VO infcPkgYe161070Vo) throws Exception;
	
	//YE161040 소득공제명세에직불카드   
	//public int PdfYeta2018_G306Y_YE161040_Update(InfcPkgYe161040_2018_VO ye161040_2018_VO) throws Exception; 
	
	//public String fnYeta3200_G306Y_YE161070_2018_Update(InfcPkgYe161070_2018_VO infcPkgYe161070Vo) throws Exception; 
	
	public int PdfYeta2018_G307Y_YE161040_Update(InfcPkgYe161040_2018_VO ye161040_2018_VO) throws Exception; 
	
	public String fnYeta3200_G307Y_YE161070_2018_Update(InfcPkgYe161070_2018_VO infcPkgYe161070Vo) throws Exception; 

	//주책임차차입금원리금상환액
	public String fnYeta3200_J101Y_YE161060_2018_Update(InfcPkgYe161060_2018_VO infcPkgYe161060Vo) throws Exception; 
		
	 
	//장기주택저당차입금	 
	 public List<InfcPkgPdfJ203y_2018_VO> PdfYeta3200_F102Y_PDF_J203Y_Select(InfcPkgPdfJ203ySrh_2018_VO yetaPdfJ203yVo) throws Exception; 
	
	 public String fnYeta3200_J203Y_YE161060_2018_Update(InfcPkgYe161060_2018_VO infcPkgYe161060Vo) throws Exception; 
	 
	  
	//주택마련 
    public String PdfYeta3200_J301Y_YE162030_Delete(InfcPkgYe162030_2018_VO infcPkgYe162030Vo) throws Exception; 
	public String PdfYeta3200_J301Y_YE162030_Insert(InfcPkgYe162030_2018_VO infcPkgYe162030Vo) throws Exception; 
	 
	public String fnYeta3200_J301Y_YE161070_2018_Update(InfcPkgYe161070_2018_VO infcPkgYe161070Vo) throws Exception; 
		
	//소상공인공제  
	public String fnYeta3200_K101M_YE161070_2018_Update(InfcPkgYe161070_2018_VO infcPkgYe161070Vo) throws Exception; 
		 
	//기부금 
    public String PdfYeta3200_L102Y_YE165010_Delete(InfcPkgYe165010_2018_VO infcPkgYe165010Vo) throws Exception; 
	public String PdfYeta3200_L102Y_YE165010_Insert(InfcPkgYe165010_2018_VO infcPkgYe165010Vo) throws Exception; 
	
	public String PdfYeta3200_L102Y_YE165020_Delete(InfcPkgYe165020_2018_VO infcPkgYe165020Vo) throws Exception; 
	public String PdfYeta3200_L102Y_YE165020_Insert(InfcPkgYe165020_2018_VO infcPkgYe165020Vo) throws Exception; 
		
    public String PdfYeta3200_L102Y_YE165030_Delete(InfcPkgYe165030_2018_VO infcPkgYe165030Vo) throws Exception;
	public String PdfYeta3200_L102Y_YE165030_Insert(InfcPkgYe165030_2018_VO infcPkgYe165030Vo) throws Exception; 
	 
	public int fnYeta3200_L102Y_YE161040_2018_Update(InfcPkgYe161040_2018_VO infcPkgYe161040Vo) throws Exception; 
	
	
	public int fnYeta3200_L102Y_YE161080_2018_Update(InfcPkgYe161080_2018_VO infcPkgYe161080Vo) throws Exception; 
	public String fnYeta3200_L102Y_YE161060_2018_Update(InfcPkgYe161060_2018_VO infcPkgYe161060Vo) throws Exception; 
	 
	
	//장기집합 투자 증권 
    public String PdfYeta3200_N101Y_YE162040_Delete(InfcPkgYe162040_2018_VO infcPkgYe162040Vo) throws Exception; 
	public String PdfYeta3200_N101Y_YE162040_Insert(InfcPkgYe162040_2018_VO infcPkgYe162040Vo) throws Exception; 
	
	public String fnYeta3200_N101Y_YE161070_2018_Update(InfcPkgYe161070_2018_VO infcPkgYe161070Vo) throws Exception; 
	 
	//건강보험료 금액 
	public String PdfYeta2018_O101M_YE161040_Update(InfcPkgYe161040_2018_VO infcPkgYe161040Vo) throws Exception; 
	public String fnYeta3200_O101M_YE161060_2018_Update(InfcPkgYe161060_2018_VO infcPkgYe161060Vo) throws Exception; 
	 
	//YE161055 국민연금 주사업장 
	public String PdfYeta2018_P102M_YE161055_Update(InfcPkgYe161055_2018_VO infcPkgYe161055Vo) throws Exception; 
	public int fnYeta3200_P102M_YE161050_2018_Update(InfcPkgYe161050_2018_VO infcPkgYe161050Vo) throws Exception; 
	
	public int PdfYeta3200_AllDelete(InfcPkgYe161010_2018_VO ye161010_2018_VO) throws Exception; 
	 
	/*********************************************************************************************** 
	 * 2017년도 간소화 자료 업데이트 부분처리 서비스 시작 정산데이타 반영부 처리 메서드 종료
	 ***********************************************************************************************/
	
}
