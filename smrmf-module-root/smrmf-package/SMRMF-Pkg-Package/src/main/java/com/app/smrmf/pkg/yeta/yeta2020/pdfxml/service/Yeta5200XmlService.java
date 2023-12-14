package com.app.smrmf.pkg.yeta.yeta2020.pdfxml.service;

import java.util.List;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfA102y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfB101y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfB201y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfC101y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfC202y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfC301y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfC401y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfD101y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfE102y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfF102y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfG104y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfG106y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfG107m_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfG107y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfG205m_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfG205y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfG206m_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfG206y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfG207m_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfG207y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfG304m_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfG304y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfG306m_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfG306y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfG307m_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfG307y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfG407m_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfG407y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfJ101y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfJ203m_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfJ203ySrh_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfJ203y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfJ301y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfJ401y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfJ501y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfK101m_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfK101y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfL102y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfN101y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfO101m_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfO101y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfP101m_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfP101y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfP102m_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfP102y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfQ101y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfQ201y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfYE162015_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161010_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161040_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161050_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161055_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161060_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161070_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161080_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161090_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe162010_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe162020_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe162030_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe162040_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe162510_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe164010_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe165010_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe165020_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe165030_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe166020_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe166030_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe166040_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe167010_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe167020_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe167030_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe167040_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe167050_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe167060_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe167070_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe167110_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe167120_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe167130_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe167140_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe167150_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe167210_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe167220_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe167230_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe167240_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe167310_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe167320_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe167410_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe167420_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe167430_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe167440_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe167510_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe167520_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe167530_2020_VO;

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
public interface Yeta5200XmlService {

	/**
	 * <pre>
	 * 1. 개요 : 일반 및 장애인 전용 보장성 보험 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_A102Y_2020_Delete
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
	public void yeta5200_PDF_A102Y_2020_Delete(InfcPkgPdfA102y_2020_VO yetaPdfA102yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 일반 및 장애인 전용 보장성 보험 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_A102Y_2020_Insert
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
	public String yeta5200_PDF_A102Y_2020_Insert(InfcPkgPdfA102y_2020_VO yetaPdfA102yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 의료비 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_B101Y_2020_Delete
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
	public void yeta5200_PDF_B101Y_2020_Delete(InfcPkgPdfB101y_2020_VO yetaPdfB101yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 의료비 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_B101Y_2020_Insert
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
	public String yeta5200_PDF_B101Y_2020_Insert(InfcPkgPdfB101y_2020_VO yetaPdfB101yVo) throws Exception; 

	
	
	//실손의료보험금 추가20201210
	public void yeta5200_PDF_B201Y_2020_Delete(InfcPkgPdfB201y_2020_VO yetaPdfB201yVo) throws Exception;
	
	
	//실손의료보험금 추가20201210
	public String yeta5200_PDF_B201Y_2020_Insert(InfcPkgPdfB201y_2020_VO yetaPdfB201yVo) throws Exception;
	
	
	/**
	 * <pre>
	 * 1. 개요 : 교육비 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_C101Y_2020_Delete
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
	public void yeta5200_PDF_C101Y_2020_Delete(InfcPkgPdfC101y_2020_VO yetaPdfC101yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 교육비 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_C101Y_2020_Insert
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
	public String yeta5200_PDF_C101Y_2020_Insert(InfcPkgPdfC101y_2020_VO yetaPdfC101yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 직업휸련비 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_C202Y_2020_Delete
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
	public void yeta5200_PDF_C202Y_2020_Delete(InfcPkgPdfC202y_2020_VO yetaPdfC202yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 직업훈련비 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_C202Y_2020_Insert
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
	public String yeta5200_PDF_C202Y_2020_Insert(InfcPkgPdfC202y_2020_VO yetaPdfC202yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 교복구입비 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_C301Y_2020_Delete
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
	public void yeta5200_PDF_C301Y_2020_Delete(InfcPkgPdfC301y_2020_VO yetaPdfC301yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 교복구입비 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_C301Y_2020_Insert
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
	public String yeta5200_PDF_C301Y_2020_Insert(InfcPkgPdfC301y_2020_VO yetaPdfC301yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 학자금대출 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_C401Y_2020_Delete
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
	public void yeta5200_PDF_C401Y_2020_Delete(InfcPkgPdfC401y_2020_VO yetaPdfC341yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 학자금대출 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_C401Y_2020_Insert
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
	public String yeta5200_PDF_C401Y_2020_Insert(InfcPkgPdfC401y_2020_VO yetaPdfC401yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 개인연금저축 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_D101Y_2020_Delete
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
	public void yeta5200_PDF_D101Y_2020_Delete(InfcPkgPdfD101y_2020_VO yetaPdfD101yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 개인연금저축 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_D101Y_2020_Insert
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
	public String yeta5200_PDF_D101Y_2020_Insert(InfcPkgPdfD101y_2020_VO yetaPdfD101yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 연금저축 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_E102Y_2020_Delete
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
	public void yeta5200_PDF_E102Y_2020_Delete(InfcPkgPdfE102y_2020_VO yetaPdfE102yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 연금저축 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_E102Y_2020_Insert
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
	public String yeta5200_PDF_E102Y_2020_Insert(InfcPkgPdfE102y_2020_VO yetaPdfE102yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 퇴직연금 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_F102Y_2020_Delete
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
	public void yeta5200_PDF_F102Y_2020_Delete(InfcPkgPdfF102y_2020_VO yetaPdfF102yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 퇴직연금 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_F102Y_2020_Insert
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
	public String yeta5200_PDF_F102Y_2020_Insert(InfcPkgPdfF102y_2020_VO yetaPdfF102yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 신용카드 데이터 삭제(2016년 귀속)
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_G104Y_2020_Delete
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
	public void yeta5200_PDF_G104Y_2020_Delete(InfcPkgPdfG104y_2020_VO yetaPdfG104yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 신용카드 데이터 입력(2016년 귀속)
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_G104Y_2020_Insert
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
	public String yeta5200_PDF_G104Y_2020_Insert(InfcPkgPdfG104y_2020_VO yetaPdfG104yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 신용카드 데이터 삭제(2017년 귀속)
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_G107Y_2020_Delete
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
	public void yeta5200_PDF_G107Y_2020_Delete(InfcPkgPdfG107y_2020_VO yetaPdfG107yVo) throws Exception;
	
	/**
	 * <pre>
	 * 1. 개요 : 신용카드 데이터 입력(2017년 귀속)
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_G106Y_2020_Insert
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
	public String yeta5200_PDF_G107Y_2020_Insert(InfcPkgPdfG107y_2020_VO yetaPdfG107yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 현금영수증 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_G205M_2020_Delete
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
	
	//2020연말정산 추가
	public String yeta5200_PDF_G107M_2020_Insert(InfcPkgPdfG107m_2020_VO yetaPdfG107mVo) throws Exception;
	
	public void yeta5200_PDF_G107M_2020_Delete(InfcPkgPdfG107m_2020_VO yetaPdfG107yVo) throws Exception;
	
	
	
	
	public void yeta5200_PDF_G205M_2020_Delete(InfcPkgPdfG205m_2020_VO yetaPdfG205mVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 현금영수증 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_G205M_2020_Insert
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
	public String yeta5200_PDF_G205M_2020_Insert(InfcPkgPdfG205m_2020_VO yetaPdfG205mVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 현금영수증 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_G205Y_2020_Delete
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
	public void yeta5200_PDF_G205Y_2020_Delete(InfcPkgPdfG205y_2020_VO yetaPdfG205yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 현금영수증 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_G205Y_2020_Insert
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
	public String yeta5200_PDF_G205Y_2020_Insert(InfcPkgPdfG205y_2020_VO yetaPdfG205yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 현금영수증 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_G206M_2020_Delete
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
	public void yeta5200_PDF_G207M_2020_Delete(InfcPkgPdfG207m_2020_VO yetaPdfG207mVo) throws Exception; 
	

	/**
	 * <pre>
	 * 1. 개요 : 현금영수증 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_G206M_2020_Insert
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
	public String yeta5200_PDF_G207M_2020_Insert(InfcPkgPdfG207m_2020_VO yetaPdfG207mVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 현금영수증 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_G206Y_2020_Delete
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
	public void yeta5200_PDF_G207Y_2020_Delete(InfcPkgPdfG207y_2020_VO yetaPdfG207yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 현금영수증 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_G206Y_2020_Insert
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
	public String yeta5200_PDF_G207Y_2020_Insert(InfcPkgPdfG207y_2020_VO yetaPdfG207yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 직붙카드 등 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_G304Y_2020_Delete
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
	public void yeta5200_PDF_G304Y_2020_Delete(InfcPkgPdfG304y_2020_VO yetaPdfG304yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 직불카드 등 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_G304Y_2020_Insert
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
	public String yeta5200_PDF_G304Y_2020_Insert(InfcPkgPdfG304y_2020_VO yetaPdfG304yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 직붙카드 등 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_G304M_2020_Delete
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
	public void yeta5200_PDF_G304M_2020_Delete(InfcPkgPdfG304m_2020_VO yetaPdfG304mVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 직불카드 등 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_G304M_2020_Insert
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
	public String yeta5200_PDF_G304M_2020_Insert(InfcPkgPdfG304m_2020_VO yetaPdfG304mVo) throws Exception; 
	

	/**
	 * <pre>
	 * 1. 개요 : 직불카드 등 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_G306M_2020_Insert
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
	public String yeta5200_PDF_G307M_2020_Insert(InfcPkgPdfG307m_2020_VO yetaPdfG307mVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 직붙카드 등 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_G306Y_2020_Delete
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
	public void yeta5200_PDF_G307Y_2020_Delete(InfcPkgPdfG307y_2020_VO yetaPdfG307yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 직불카드 등 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_G306Y_2020_Insert
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
	public String yeta5200_PDF_G307Y_2020_Insert(InfcPkgPdfG307y_2020_VO yetaPdfG307yVo) throws Exception; 


	/**
	 * <pre>
	 * 1. 개요 : 직붙카드 등 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_G306M_2020_Delete
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
	public void yeta5200_PDF_G307M_2020_Delete(InfcPkgPdfG307m_2020_VO yetaPdfG307mVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 제로페이 데이터 입력
	 */ 	
	public String yeta5200_PDF_G407M_2020_Insert(InfcPkgPdfG407m_2020_VO yetaPdfG407mVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 제로페이 데이터 삭제
	 */ 	
	public void yeta5200_PDF_G407Y_2020_Delete(InfcPkgPdfG407y_2020_VO yetaPdfG407yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 제로페이 데이터 입력
	 */ 	
	public String yeta5200_PDF_G407Y_2020_Insert(InfcPkgPdfG407y_2020_VO yetaPdfG407yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 제로페이 데이터 삭제
	 */ 	
	public void yeta5200_PDF_G407M_2020_Delete(InfcPkgPdfG407m_2020_VO yetaPdfG407mVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 주택임차차입금_원리금상환액 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_J101Y_2020_Delete
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
	public void yeta5200_PDF_J101Y_2020_Delete(InfcPkgPdfJ101y_2020_VO yetaPdfJ101yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 주택임차차입금_원리금상환액 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_J101Y_2020_Insert
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
	public String yeta5200_PDF_J101Y_2020_Insert(InfcPkgPdfJ101y_2020_VO yetaPdfJ101yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 장기주책저당차입금 이자상환액 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_J203Y_2020_Delete
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
	public void yeta5200_PDF_J203Y_2020_Delete(InfcPkgPdfJ203y_2020_VO yetaPdfJ203yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 장기주책저당차입금 이자상환액 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_J203Y_2020_Insert
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
	public String yeta5200_PDF_J203Y_2020_Insert(InfcPkgPdfJ203y_2020_VO yetaPdfJ203yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 장기주책저당차입금 이자상환액 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_J203M_2020_Delete
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
	public void yeta5200_PDF_J203M_2020_Delete(InfcPkgPdfJ203m_2020_VO yetaPdfJ203mVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 장기주책저당차입금 이자상환액 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_J203M_2020_Insert
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
	public String yeta5200_PDF_J203M_2020_Insert(InfcPkgPdfJ203m_2020_VO yetaPdfJ203mVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 주택마련저축 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_J301Y_2020_Delete
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
	public void yeta5200_PDF_J301Y_2020_Delete(InfcPkgPdfJ301y_2020_VO yetaPdfJ103yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 주택마련저축 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_J301Y_2020_Insert
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
	public String yeta5200_PDF_J301Y_2020_Insert(InfcPkgPdfJ301y_2020_VO yetaPdfJ103yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 목돈 안드는 전세 이자상환액 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_J401Y_2020_Delete
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
	public void yeta5200_PDF_J401Y_2020_Delete(InfcPkgPdfJ401y_2020_VO yetaPdfJ401yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 목돈 안드는 전세 이자상환액 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_J401Y_2020_Insert
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
	public String yeta5200_PDF_J401Y_2020_Insert(InfcPkgPdfJ401y_2020_VO yetaPdfJ401yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 소기업소강공인 공제부금 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_K101M_2020_Delete
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
	
	
	//추가20201215
	public void yeta5200_PDF_J501Y_2020_Delete(InfcPkgPdfJ501y_2020_VO yetaPdfJ501yVo) throws Exception; 

	//추가20201215
	public String yeta5200_PDF_J501Y_2020_Insert(InfcPkgPdfJ501y_2020_VO yetaPdfJ501yVo) throws Exception; 
	
	public String PdfYeta5200_J501Y_YE162510_Delete(InfcPkgYe162510_2020_VO infcPkgYe162510Vo) throws Exception;
	
	public String PdfYeta5200_J501Y_YE162510_Insert(InfcPkgYe162510_2020_VO infcPkgYe162510Vo) throws Exception;
	
	public String fnYeta5200_J501Y_YE161080_2020_Update(InfcPkgYe161080_2020_VO infcPkgYe161080Vo) throws Exception;
	
	//추가20201216
	public void yeta5200_PDF_Q101Y_2020_Delete (InfcPkgPdfQ101y_2020_VO yetaPdfQ101yVo) throws Exception; 
	
	//추가20201216
	public String yeta5200_PDF_Q101Y_2020_Insert(InfcPkgPdfQ101y_2020_VO yetaPdfQ101yVo) throws Exception; 
	
	public String PdfYeta5200_Q101Y_YE166040_Delete(InfcPkgYe166040_2020_VO infcPkgYe166040Vo) throws Exception;
	
	public String PdfYeta5200_Q101Y_YE166040_Insert(InfcPkgYe166040_2020_VO infcPkgYe166040Vo) throws Exception;
	
	public String fnYeta5200_Q101Y_YE161070_2020_Update(InfcPkgYe161070_2020_VO infcPkgYe161070Vo) throws Exception;
	
	
	//추가20201216
	public void yeta5200_PDF_Q201Y_2020_Delete (InfcPkgPdfQ201y_2020_VO yetaPdfQ201yVo) throws Exception; 
			
	//추가20201216
	public String yeta5200_PDF_Q201Y_2020_Insert(InfcPkgPdfQ201y_2020_VO yetaPdfQ201yVo) throws Exception; 
	
	
	
	
	public void yeta5200_PDF_K101M_2020_Delete(InfcPkgPdfK101m_2020_VO yetaPdfK101mVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 소기업소강공인 공제부금 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_K101M_2020_Insert
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
	public String yeta5200_PDF_K101M_2020_Insert(InfcPkgPdfK101m_2020_VO yetaPdfK101mVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 소기업소강공인 공제부금 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_K101Y_2020_Delete
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
	public void yeta5200_PDF_K101Y_2020_Delete(InfcPkgPdfK101y_2020_VO yetaPdfK101yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 소기업소강공인 공제부금 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_K101Y_2020_Insert
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
	public String yeta5200_PDF_K101Y_2020_Insert(InfcPkgPdfK101y_2020_VO yetaPdfK101yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 기부금 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_L102Y_2020_Delete
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
	public void yeta5200_PDF_L102Y_2020_Delete(InfcPkgPdfL102y_2020_VO yetaPdfL102yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 기부금 공제부금 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_L102Y_2020_Insert
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
	public String yeta5200_PDF_L102Y_2020_Insert(InfcPkgPdfL102y_2020_VO yetaPdfL102yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 장기집합투자증권저축 공제부금 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_N101Y_2020_Delete
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
	public void yeta5200_PDF_N101Y_2020_Delete(InfcPkgPdfN101y_2020_VO yetaPdfN101yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 장기집합투자증권저축 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_N101Y_2020_Insert
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
	public String yeta5200_PDF_N101Y_2020_Insert(InfcPkgPdfN101y_2020_VO yetaPdfN101yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 건강보험료 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_O101M_2020_Delete
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
	public void yeta5200_PDF_O101M_2020_Delete(InfcPkgPdfO101m_2020_VO yetaPdfO101mVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 건강보험료 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_O101M_2020_Insert
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
	public String yeta5200_PDF_O101M_2020_Insert(InfcPkgPdfO101m_2020_VO yetaPdfO101mVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 건강보험료 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_O101Y_2020_Delete
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
	public void yeta5200_PDF_O101Y_2020_Delete(InfcPkgPdfO101y_2020_VO yetaPdfO101yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 건강보험료 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_O101M_2020_Insert
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
	public String yeta5200_PDF_O101Y_2020_Insert(InfcPkgPdfO101y_2020_VO yetaPdfO101uVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 국민연금보험료 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_P101M_2020_Delete
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
	public void yeta5200_PDF_P101M_2020_Delete(InfcPkgPdfP101m_2020_VO yetaPdfP101mVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 국민연금보험료 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_P101M_2020_Insert
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
	public String yeta5200_PDF_P101M_2020_Insert(InfcPkgPdfP101m_2020_VO yetaPdfP101mVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 국민연금보험료 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_P101Y_2020_Delete
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
	public void yeta5200_PDF_P101Y_2020_Delete(InfcPkgPdfP101y_2020_VO yetaPdfP101yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 국민연금보험료 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_P101Y_2020_Insert
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
	public String yeta5200_PDF_P101Y_2020_Insert(InfcPkgPdfP101y_2020_VO yetaPdfP101yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 국민연금보험료 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_P102M_2020_Delete
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
	public void yeta5200_PDF_P102M_2020_Delete(InfcPkgPdfP102m_2020_VO yetaPdfP102mVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 국민연금보험료 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_P102M_2020_Insert
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
	public String yeta5200_PDF_P102M_2020_Insert(InfcPkgPdfP102m_2020_VO yetaPdfP102mVo) throws Exception; 
	/**
	 * <pre>
	 * 1. 개요 : 국민연금보험료 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_P102Y_2020_Delete
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
	public void yeta5200_PDF_P102Y_2020_Delete(InfcPkgPdfP102y_2020_VO yetaPdfP102yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 국민연금보험료 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_P102Y_2020_Insert
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
	public String yeta5200_PDF_P102Y_2020_Insert(InfcPkgPdfP102y_2020_VO yetaPdfP102yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE162015_2020_Delete
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
	public void yeta5200_PDF_YE162015_2020_Delete(InfcPkgPdfYE162015_2020_VO yetaPdfYE162015Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE162015_2020_Insert
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
	public String yeta5200_PDF_YE162015_2020_Insert(InfcPkgPdfYE162015_2020_VO yetaPdfYE162015Vo) throws Exception; 
	
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167010_2020_Delete
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
	public void yeta5200_PDF_YE167010_2020_Delete(InfcPkgYe167010_2020_VO yetaYE167010Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167010_2020_Insert
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
	public String yeta5200_PDF_YE167010_2020_Insert(InfcPkgYe167010_2020_VO yetaYE167010Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167020_2020_Delete
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
	public void yeta5200_PDF_YE167020_2020_Delete(InfcPkgYe167020_2020_VO yetaYE167020Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167020_2020_Insert
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
	public String yeta5200_PDF_YE167020_2020_Insert(InfcPkgYe167020_2020_VO yetaYE167020Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167030_2020_Delete
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
	public void yeta5200_PDF_YE167030_2020_Delete(InfcPkgYe167030_2020_VO yetaYE167030Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167030_2020_Insert
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
	public String yeta5200_PDF_YE167030_2020_Insert(InfcPkgYe167030_2020_VO yetaYE167030Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167040_2020_Delete
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
	public void yeta5200_PDF_YE167040_2020_Delete(InfcPkgYe167040_2020_VO yetaYE167040Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167040_2020_Insert
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
	public String yeta5200_PDF_YE167040_2020_Insert(InfcPkgYe167040_2020_VO yetaYE167040Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167050_2020_Delete
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
	public void yeta5200_PDF_YE167050_2020_Delete(InfcPkgYe167050_2020_VO yetaYE167050Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167050_2020_Insert
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
	public String yeta5200_PDF_YE167050_2020_Insert(InfcPkgYe167050_2020_VO yetaYE167050Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167060_2020_Delete
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
	public void yeta5200_PDF_YE167060_2020_Delete(InfcPkgYe167060_2020_VO yetaYE167060Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167060_2020_Insert
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
	public String yeta5200_PDF_YE167060_2020_Insert(InfcPkgYe167060_2020_VO yetaYE167060Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167070_2020_Delete
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
	public void yeta5200_PDF_YE167070_2020_Delete(InfcPkgYe167070_2020_VO yetaYE167070Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167070_2020_Insert
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
	public String yeta5200_PDF_YE167070_2020_Insert(InfcPkgYe167070_2020_VO yetaYE167070Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167530_2020_Delete
	 * @date : 2020. 1. 2.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2020. 1. 2.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167530Vo
	 * @throws Exception
	 */ 	
	public void yeta5200_PDF_YE167530_2020_Delete(InfcPkgYe167530_2020_VO yetaYE167530Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167530_2020_Insert
	 * @date : 2020. 1. 2.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2020. 1. 2.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167530Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta5200_PDF_YE167530_2020_Insert(InfcPkgYe167530_2020_VO yetaYE167530Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167110_2020_Delete
	 * @date : 2020. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2020. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167110Vo
	 * @throws Exception
	 */ 	
	public void yeta5200_PDF_YE167110_2020_Delete(InfcPkgYe167110_2020_VO yetaYE167110Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167110_2020_Insert
	 * @date : 2020. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2020. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167110Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta5200_PDF_YE167110_2020_Insert(InfcPkgYe167110_2020_VO yetaYE167110Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167120_2020_Delete
	 * @date : 2020. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2020. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167120Vo
	 * @throws Exception
	 */ 	
	public void yeta5200_PDF_YE167120_2020_Delete(InfcPkgYe167120_2020_VO yetaYE167120Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167120_2020_Insert
	 * @date : 2020. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2020. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167120Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta5200_PDF_YE167120_2020_Insert(InfcPkgYe167120_2020_VO yetaYE167120Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167130_2020_Delete
	 * @date : 2020. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2020. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167130Vo
	 * @throws Exception
	 */ 	
	public void yeta5200_PDF_YE167130_2020_Delete(InfcPkgYe167130_2020_VO yetaYE167130Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167130_2020_Insert
	 * @date : 2020. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2020. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167130Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta5200_PDF_YE167130_2020_Insert(InfcPkgYe167130_2020_VO yetaYE167130Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167140_2020_Delete
	 * @date : 2020. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2020. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167140Vo
	 * @throws Exception
	 */ 	
	public void yeta5200_PDF_YE167140_2020_Delete(InfcPkgYe167140_2020_VO yetaYE167140Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167140_2020_Insert
	 * @date : 2020. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2020. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167140Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta5200_PDF_YE167140_2020_Insert(InfcPkgYe167140_2020_VO yetaYE167140Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167150_2020_Delete
	 * @date : 2020. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2020. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167150Vo
	 * @throws Exception
	 */ 	
	public void yeta5200_PDF_YE167150_2020_Delete(InfcPkgYe167150_2020_VO yetaYE167150Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167150_2020_Insert
	 * @date : 2020. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2020. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167150Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta5200_PDF_YE167150_2020_Insert(InfcPkgYe167150_2020_VO yetaYE167150Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167210_2020_Delete
	 * @date : 2020. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2020. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167210Vo
	 * @throws Exception
	 */ 	
	public void yeta5200_PDF_YE167210_2020_Delete(InfcPkgYe167210_2020_VO yetaYE167210Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167210_2020_Insert
	 * @date : 2020. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2020. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167210Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta5200_PDF_YE167210_2020_Insert(InfcPkgYe167210_2020_VO yetaYE167210Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167220_2020_Delete
	 * @date : 2020. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2020. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167220Vo
	 * @throws Exception
	 */ 	
	public void yeta5200_PDF_YE167220_2020_Delete(InfcPkgYe167220_2020_VO yetaYE167220Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167220_2020_Insert
	 * @date : 2020. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2020. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167220Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta5200_PDF_YE167220_2020_Insert(InfcPkgYe167220_2020_VO yetaYE167220Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167230_2020_Delete
	 * @date : 2020. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2020. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167230Vo
	 * @throws Exception
	 */ 	
	public void yeta5200_PDF_YE167230_2020_Delete(InfcPkgYe167230_2020_VO yetaYE167230Vo) throws Exception; 
		
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167230_2020_Insert
	 * @date : 2020. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2020. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167230Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta5200_PDF_YE167230_2020_Insert(InfcPkgYe167230_2020_VO yetaYE167230Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167240_2020_Delete
	 * @date : 2020. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2020. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167240Vo
	 * @throws Exception
	 */ 	
	public void yeta5200_PDF_YE167240_2020_Delete(InfcPkgYe167240_2020_VO yetaYE167240Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167240_2020_Insert
	 * @date : 2020. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2020. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167240Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta5200_PDF_YE167240_2020_Insert(InfcPkgYe167240_2020_VO yetaYE167240Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167310_2020_Delete
	 * @date : 2020. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2020. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167310Vo
	 * @throws Exception
	 */ 	
	public void yeta5200_PDF_YE167310_2020_Delete(InfcPkgYe167310_2020_VO yetaYE167310Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167310_2020_Insert
	 * @date : 2020. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2020. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167310Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta5200_PDF_YE167310_2020_Insert(InfcPkgYe167310_2020_VO yetaYE167310Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167320_2020_Delete
	 * @date : 2020. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2020. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167320Vo
	 * @throws Exception
	 */ 	
	public void yeta5200_PDF_YE167320_2020_Delete(InfcPkgYe167320_2020_VO yetaYE167320Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167320_2020_Insert
	 * @date : 2020. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2020. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167320Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta5200_PDF_YE167320_2020_Insert(InfcPkgYe167320_2020_VO yetaYE167320Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167410_2020_Delete
	 * @date : 2020. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2020. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167410Vo
	 * @throws Exception
	 */ 	
	public void yeta5200_PDF_YE167410_2020_Delete(InfcPkgYe167410_2020_VO yetaYE167410Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167410_2020_Insert
	 * @date : 2020. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2020. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167410Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta5200_PDF_YE167410_2020_Insert(InfcPkgYe167410_2020_VO yetaYE167410Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167420_2020_Delete
	 * @date : 2020. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2020. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167420Vo
	 * @throws Exception
	 */ 	
	public void yeta5200_PDF_YE167420_2020_Delete(InfcPkgYe167420_2020_VO yetaYE167420Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167420_2020_Insert
	 * @date : 2020. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2020. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167420Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta5200_PDF_YE167420_2020_Insert(InfcPkgYe167420_2020_VO yetaYE167420Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167430_2020_Delete
	 * @date : 2020. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2020. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167430Vo
	 * @throws Exception
	 */ 	
	public void yeta5200_PDF_YE167430_2020_Delete(InfcPkgYe167430_2020_VO yetaYE167430Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167430_2020_Insert
	 * @date : 2020. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2020. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167430Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta5200_PDF_YE167430_2020_Insert(InfcPkgYe167430_2020_VO yetaYE167430Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167440_2020_Delete
	 * @date : 2020. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2020. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167440Vo
	 * @throws Exception
	 */ 	
	public void yeta5200_PDF_YE167440_2020_Delete(InfcPkgYe167440_2020_VO yetaYE167440Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167440_2020_Insert
	 * @date : 2020. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2020. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167440Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta5200_PDF_YE167440_2020_Insert(InfcPkgYe167440_2020_VO yetaYE167440Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167510_2020_Delete
	 * @date : 2020. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2020. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167510Vo
	 * @throws Exception
	 */ 	
	public void yeta5200_PDF_YE167510_2020_Delete(InfcPkgYe167510_2020_VO yetaYE167510Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167510_2020_Insert
	 * @date : 2020. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2020. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167510Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta5200_PDF_YE167510_2020_Insert(InfcPkgYe167510_2020_VO yetaYE167510Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167520_2020_Delete
	 * @date : 2020. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2020. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167520Vo
	 * @throws Exception
	 */ 	
	public void yeta5200_PDF_YE167520_2020_Delete(InfcPkgYe167520_2020_VO yetaYE167520Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta5200_PDF_YE167520_2020_Insert
	 * @date : 2020. 1. 4.
	 * @author : USER
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2020. 1. 4.		USER				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yetaYE167520Vo
	 * @return
	 * @throws Exception
	 */ 	
	public String yeta5200_PDF_YE167520_2020_Insert(InfcPkgYe167520_2020_VO yetaYE167520Vo) throws Exception; 
	
	/*********************************************************************************************** 
	 * 2017년도 간소화 자료 업데이트 부분처리 서비스 시작 정산데이타 반영부 처리 메서드 시작
	 ***********************************************************************************************/
	
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 보장성,장애인보장성 보험료 개별적업데이트  
	 * 2. 처리내용 : 보장성,장애인보장성 보험료 개별적업데이트
	 * </pre>
	 * @Method Name : PdfYeta2020_A102Y_YE161040_Update
	 * @date : 2020. 1. 22.
	 * @author : atres
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2020. 1. 22.		atres				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param ye161010_2020_VO
	 * @return
	 * @throws Exception
	 */
	public int PdfYeta2020_A102Y_YE161040_Update(InfcPkgYe161040_2020_VO ye161040_2020_VO) throws Exception; 
	public String fnYeta5200_A102Y_YE161080_2020_Update(InfcPkgYe161080_2020_VO infcPkgYe161080Vo) throws Exception; 
	 
	//의료비 
	public String PdfYeta5200_B101Y_YE164010_Delete(InfcPkgYe164010_2020_VO infcPkgYe164010Vo) throws Exception; 
	public String PdfYeta5200_B101Y_YE164010_Insert(InfcPkgYe164010_2020_VO infcPkgYe164010Vo) throws Exception; 
	
	public int PdfYeta2020_B101Y_YE161040_Update(InfcPkgYe161040_2020_VO ye161040_2020_VO) throws Exception; 
	
	// 의료비정리 합계
	public int fnYeta5200_B101Y_YE161080_2020_Update(InfcPkgYe161080_2020_VO infcPkgYe161080Vo) throws Exception; 
	
	//실손의료보험비 추가20201211
	public String PdfYeta5200_B201Y_YE166030_Delete(InfcPkgYe166030_2020_VO infcPkgYe166030Vo) throws Exception; 
	public String PdfYeta5200_B201Y_YE166030_Insert(InfcPkgYe166030_2020_VO infcPkgYe166030Vo) throws Exception; 
	
	public int PdfYeta2020_B201Y_YE161040_Update(InfcPkgYe161040_2020_VO ye161040_2020_VO) throws Exception; 
	
	public int fnYeta5200_B201Y_YE161080_2020_Update(InfcPkgYe161080_2020_VO infcPkgYe161080Vo) throws Exception;
	
	
	
	//교육비처리 
	public String PdfYeta5200_C101Y_YE161090_Delete(InfcPkgYe161090_2020_VO infcPkgYe161090Vo) throws Exception; 
	public String PdfYeta5200_C101Y_YE161090_Insert(InfcPkgYe161090_2020_VO infcPkgYe161090Vo) throws Exception; 
	 
	public int PdfYeta2020_C101Y_YE161040_Update(InfcPkgYe161040_2020_VO ye161040_2020_VO) throws Exception; 
	
	public String fnYeta5200_C101Y_YE161080_2020_Update(InfcPkgYe161080_2020_VO infcPkgYe161080Vo) throws Exception; 
	
	
	//직업훈련비
	public String PdfYeta5200_C202Y_YE161090_Delete(InfcPkgYe161090_2020_VO infcPkgYe161090Vo) throws Exception; 
	public String PdfYeta5200_C202Y_YE161090_Insert(InfcPkgYe161090_2020_VO infcPkgYe161090Vo) throws Exception; 
	 
	//public String PdfYeta2020_C202Y_YE161040_Update(InfcPkgYe161040_2020_VO ye161040_2020_VO) throws Exception; 
	
	//public String fnYeta5200_C202Y_YE161080_2020_Update(InfcPkgYe161080_2020_VO infcPkgYe161080Vo) throws Exception; 
	
	
	//교복구입비
	public String PdfYeta5200_C301Y_YE161090_Delete(InfcPkgYe161090_2020_VO infcPkgYe161090Vo) throws Exception; 
	public String PdfYeta5200_C301Y_YE161090_Insert(InfcPkgYe161090_2020_VO infcPkgYe161090Vo) throws Exception; 
	 
//	public String PdfYeta2020_C301Y_YE161040_Update(InfcPkgYe161040_2020_VO ye161040_2020_VO) throws Exception; 
	
//	public String fnYeta5200_C301Y_YE161080_2020_Update(InfcPkgYe161080_2020_VO infcPkgYe161080Vo) throws Exception; 
	
	
	//학자금대출
	public String PdfYeta5200_C401Y_YE161090_Delete(InfcPkgYe161090_2020_VO infcPkgYe161090Vo) throws Exception; 
	public String PdfYeta5200_C401Y_YE161090_Insert(InfcPkgYe161090_2020_VO infcPkgYe161090Vo) throws Exception; 
	 
//	public String PdfYeta2020_C401Y_YE161040_Update(InfcPkgYe161040_2020_VO ye161040_2020_VO) throws Exception; 
//	
//	public String fnYeta5200_C401Y_YE161080_2020_Update(InfcPkgYe161080_2020_VO infcPkgYe161080Vo) throws Exception; 
		
	//개인연금저축 
	public String PdfYeta5200_D101Y_YE162010_Delete(InfcPkgYe162010_2020_VO infcPkgYe162010Vo) throws Exception; 
	public String PdfYeta5200_D101Y_YE162010_Insert(InfcPkgYe162010_2020_VO infcPkgYe162010Vo) throws Exception; 
	 
	public String fnYeta5200_D101Y_YE161070_2020_Update(InfcPkgYe161070_2020_VO infcPkgYe161070Vo) throws Exception; 
	
	//연금저축
	
	public String PdfYeta5200_E102Y_YE162010_Delete(InfcPkgYe162010_2020_VO infcPkgYe162010Vo) throws Exception; 
	public String PdfYeta5200_E102Y_YE162010_Insert(InfcPkgYe162010_2020_VO infcPkgYe162010Vo) throws Exception; 
	 
	public String fnYeta5200_E102Y_YE161080_2020_Update(InfcPkgYe161080_2020_VO infcPkgYe161080Vo) throws Exception; 
	
	
	//퇴직연금 
	public String PdfYeta5200_F102Y_YE162020_Delete(InfcPkgYe162020_2020_VO infcPkgYe162020Vo) throws Exception; 
	public String PdfYeta5200_F102Y_YE162020_Insert(InfcPkgYe162020_2020_VO infcPkgYe162020Vo) throws Exception; 
	 
	public String fnYeta5200_F102Y_YE161080_2020_Update(InfcPkgYe161080_2020_VO infcPkgYe161080Vo) throws Exception; 
	

	//YE161040 소득공제명세에 신용카드 
	//public int PdfYeta2020_G106Y_YE161040_Update(InfcPkgYe161040_2020_VO ye161040_2020_VO) throws Exception; 
	
	//public String PdfYeta5200_G106Y_YE166020_Update(InfcPkgYe166020_2020_VO infcPkgYe166020Vo) throws Exception;  
	
	//public String fnYeta5200_G106Y_YE161070_2020_Update(InfcPkgYe161070_2020_VO infcPkgYe161070Vo) throws Exception; 
	
	public int PdfYeta2020_G107Y_YE161040_Update(InfcPkgYe161040_2020_VO ye161040_2020_VO) throws Exception; 
	
	public String PdfYeta5200_G107Y_YE166020_Update(InfcPkgYe166020_2020_VO infcPkgYe166020Vo) throws Exception;  
	
	/*public String PdfYeta5200_G107Y_YE166020_Update_2(InfcPkgYe166020_2020_VO infcPkgYe166020Vo) throws Exception;
	
	public String PdfYeta5200_G107Y_YE166020_Update_3(InfcPkgYe166020_2020_VO infcPkgYe166020Vo) throws Exception;
	
	public String PdfYeta5200_G107Y_YE166020_Update_4(InfcPkgYe166020_2020_VO infcPkgYe166020Vo) throws Exception;*/
	
	public String fnYeta5200_G107Y_YE161070_2020_Update(InfcPkgYe161070_2020_VO infcPkgYe161070Vo) throws Exception; 
	 
  //YE161040 소득공제명세에 현금영수증  
	//public int PdfYeta2020_G206Y_YE161040_Update(InfcPkgYe161040_2020_VO ye161040_2020_VO) throws Exception; 
	 
	//public String fnYeta5200_G206Y_YE161070_2020_Update(InfcPkgYe161070_2020_VO infcPkgYe161070Vo) throws Exception; 
	
	public int PdfYeta2020_G207Y_YE161040_Update(InfcPkgYe161040_2020_VO ye161040_2020_VO) throws Exception; 
	 
	public String fnYeta5200_G207Y_YE161070_2020_Update(InfcPkgYe161070_2020_VO infcPkgYe161070Vo) throws Exception;
	
	//YE161040 소득공제명세에직불카드   
	//public int PdfYeta2020_G306Y_YE161040_Update(InfcPkgYe161040_2020_VO ye161040_2020_VO) throws Exception; 
	
	//public String fnYeta5200_G306Y_YE161070_2020_Update(InfcPkgYe161070_2020_VO infcPkgYe161070Vo) throws Exception; 
	
	public int PdfYeta2020_G307Y_YE161040_Update(InfcPkgYe161040_2020_VO ye161040_2020_VO) throws Exception; 
	
	public String fnYeta5200_G307Y_YE161070_2020_Update(InfcPkgYe161070_2020_VO infcPkgYe161070Vo) throws Exception; 

	//YE161040 소득공제명세에 제로페이
	public int PdfYeta2020_G407Y_YE161040_Update(InfcPkgYe161040_2020_VO ye161040_2020_VO) throws Exception; 
	
	public String fnYeta5200_G407Y_YE161070_2020_Update(InfcPkgYe161070_2020_VO infcPkgYe161070Vo) throws Exception; 

	//주책임차차입금원리금상환액
	public String fnYeta5200_J101Y_YE161060_2020_Update(InfcPkgYe161060_2020_VO infcPkgYe161060Vo) throws Exception; 
		
	 
	//장기주택저당차입금	 
	 public List<InfcPkgPdfJ203y_2020_VO> PdfYeta5200_F102Y_PDF_J203Y_Select(InfcPkgPdfJ203ySrh_2020_VO yetaPdfJ203yVo) throws Exception; 
	
	 public String fnYeta5200_J203Y_YE161060_2020_Update(InfcPkgYe161060_2020_VO infcPkgYe161060Vo) throws Exception; 
	 
	  
	//주택마련 
    public String PdfYeta5200_J301Y_YE162030_Delete(InfcPkgYe162030_2020_VO infcPkgYe162030Vo) throws Exception; 
	public String PdfYeta5200_J301Y_YE162030_Insert(InfcPkgYe162030_2020_VO infcPkgYe162030Vo) throws Exception; 
	 
	public String fnYeta5200_J301Y_YE161070_2020_Update(InfcPkgYe161070_2020_VO infcPkgYe161070Vo) throws Exception; 
		
	//소상공인공제  
	public String fnYeta5200_K101M_YE161070_2020_Update(InfcPkgYe161070_2020_VO infcPkgYe161070Vo) throws Exception; 
		 
	//기부금 
    public String PdfYeta5200_L102Y_YE165010_Delete(InfcPkgYe165010_2020_VO infcPkgYe165010Vo) throws Exception; 
	public String PdfYeta5200_L102Y_YE165010_Insert(InfcPkgYe165010_2020_VO infcPkgYe165010Vo) throws Exception; 
	
	public String PdfYeta5200_L102Y_YE165020_Delete(InfcPkgYe165020_2020_VO infcPkgYe165020Vo) throws Exception; 
	public String PdfYeta5200_L102Y_YE165020_Insert(InfcPkgYe165020_2020_VO infcPkgYe165020Vo) throws Exception; 
		
    public String PdfYeta5200_L102Y_YE165030_Delete(InfcPkgYe165030_2020_VO infcPkgYe165030Vo) throws Exception;
	public String PdfYeta5200_L102Y_YE165030_Insert(InfcPkgYe165030_2020_VO infcPkgYe165030Vo) throws Exception; 
	 
	public int fnYeta5200_L102Y_YE161040_2020_Update(InfcPkgYe161040_2020_VO infcPkgYe161040Vo) throws Exception; 
	
	
	public int fnYeta5200_L102Y_YE161080_2020_Update(InfcPkgYe161080_2020_VO infcPkgYe161080Vo) throws Exception; 
	public String fnYeta5200_L102Y_YE161060_2020_Update(InfcPkgYe161060_2020_VO infcPkgYe161060Vo) throws Exception; 
	 
	
	//장기집합 투자 증권 
    public String PdfYeta5200_N101Y_YE162040_Delete(InfcPkgYe162040_2020_VO infcPkgYe162040Vo) throws Exception; 
	public String PdfYeta5200_N101Y_YE162040_Insert(InfcPkgYe162040_2020_VO infcPkgYe162040Vo) throws Exception; 
	
	public String fnYeta5200_N101Y_YE161070_2020_Update(InfcPkgYe161070_2020_VO infcPkgYe161070Vo) throws Exception; 
	 
	//건강보험료 금액 
	public String PdfYeta2020_O101M_YE161040_Update(InfcPkgYe161040_2020_VO infcPkgYe161040Vo) throws Exception; 
	public String fnYeta5200_O101M_YE161060_2020_Update(InfcPkgYe161060_2020_VO infcPkgYe161060Vo) throws Exception; 
	 
	//YE161055 국민연금 주사업장 
	public String PdfYeta2020_P102M_YE161055_Update(InfcPkgYe161055_2020_VO infcPkgYe161055Vo) throws Exception; 
	public int fnYeta5200_P102M_YE161050_2020_Update(InfcPkgYe161050_2020_VO infcPkgYe161050Vo) throws Exception; 
	
	public int PdfYeta5200_AllDelete(InfcPkgYe161010_2020_VO ye161010_2020_VO) throws Exception; 
	 
	/*********************************************************************************************** 
	 * 2017년도 간소화 자료 업데이트 부분처리 서비스 시작 정산데이타 반영부 처리 메서드 종료
	 ***********************************************************************************************/
	
}
