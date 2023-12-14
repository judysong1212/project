package com.app.smrmf.pkg.yeta.yeta2017.pdfxml.service;

import java.util.List;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfA102yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfB101yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfC101yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfC202yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfC301yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfC401yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfD101yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfE102yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfF102yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG104yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG106yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG205mVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG205yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG206mVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG206yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG304mVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG304yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG306mVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG306yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfJ101yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfJ203mVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfJ203ySrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfJ203yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfJ301yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfJ401yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfK101mVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfK101yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfL102yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfN101yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfO101mVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfO101yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfP101mVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfP101yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfP102mVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfP102yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfYE162015VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161040VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161050VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161055VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161060VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161070VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161080VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161090VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162020VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162030VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162040VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe164010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe165010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe165020VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe165030VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe166020VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167020VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167030VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167040VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167050VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167060VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167070VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167110VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167120VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167130VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167140VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167150VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167210VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167220VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167230VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167240VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167310VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167320VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167410VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167420VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167430VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167440VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167510VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167520VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167530VO;

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
public interface Yeta2200XmlService {

	/**
	 * <pre>
	 * 1. 개요 : 일반 및 장애인 전용 보장성 보험 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_A102Y_2017_Delete
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
	public void yeta2200_PDF_A102Y_2017_Delete(InfcPkgPdfA102yVO yetaPdfA102yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 일반 및 장애인 전용 보장성 보험 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_A102Y_2017_Insert
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
	public String yeta2200_PDF_A102Y_2017_Insert(InfcPkgPdfA102yVO yetaPdfA102yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 의료비 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_B101Y_2017_Delete
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
	public void yeta2200_PDF_B101Y_2017_Delete(InfcPkgPdfB101yVO yetaPdfB101yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 의료비 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_B101Y_2017_Insert
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
	public String yeta2200_PDF_B101Y_2017_Insert(InfcPkgPdfB101yVO yetaPdfB101yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 교육비 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_C101Y_2017_Delete
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
	public void yeta2200_PDF_C101Y_2017_Delete(InfcPkgPdfC101yVO yetaPdfC101yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 교육비 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_C101Y_2017_Insert
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
	public String yeta2200_PDF_C101Y_2017_Insert(InfcPkgPdfC101yVO yetaPdfC101yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 직업휸련비 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_C202Y_2017_Delete
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
	public void yeta2200_PDF_C202Y_2017_Delete(InfcPkgPdfC202yVO yetaPdfC202yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 직업훈련비 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_C202Y_2017_Insert
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
	public String yeta2200_PDF_C202Y_2017_Insert(InfcPkgPdfC202yVO yetaPdfC202yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 교복구입비 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_C301Y_2017_Delete
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
	public void yeta2200_PDF_C301Y_2017_Delete(InfcPkgPdfC301yVO yetaPdfC301yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 교복구입비 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_C301Y_2017_Insert
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
	public String yeta2200_PDF_C301Y_2017_Insert(InfcPkgPdfC301yVO yetaPdfC301yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 학자금대출 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_C401Y_2017_Delete
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
	public void yeta2200_PDF_C401Y_2017_Delete(InfcPkgPdfC401yVO yetaPdfC341yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 학자금대출 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_C401Y_2017_Insert
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
	public String yeta2200_PDF_C401Y_2017_Insert(InfcPkgPdfC401yVO yetaPdfC401yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 개인연금저축 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_D101Y_2017_Delete
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
	public void yeta2200_PDF_D101Y_2017_Delete(InfcPkgPdfD101yVO yetaPdfD101yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 개인연금저축 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_D101Y_2017_Insert
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
	public String yeta2200_PDF_D101Y_2017_Insert(InfcPkgPdfD101yVO yetaPdfD101yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 연금저축 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_E102Y_2017_Delete
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
	public void yeta2200_PDF_E102Y_2017_Delete(InfcPkgPdfE102yVO yetaPdfE102yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 연금저축 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_E102Y_2017_Insert
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
	public String yeta2200_PDF_E102Y_2017_Insert(InfcPkgPdfE102yVO yetaPdfE102yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 퇴직연금 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_F102Y_2017_Delete
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
	public void yeta2200_PDF_F102Y_2017_Delete(InfcPkgPdfF102yVO yetaPdfF102yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 퇴직연금 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_F102Y_2017_Insert
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
	public String yeta2200_PDF_F102Y_2017_Insert(InfcPkgPdfF102yVO yetaPdfF102yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 신용카드 데이터 삭제(2016년 귀속)
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_G104Y_2017_Delete
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
	public void yeta2200_PDF_G104Y_2017_Delete(InfcPkgPdfG104yVO yetaPdfG104yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 신용카드 데이터 입력(2016년 귀속)
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_G104Y_2017_Insert
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
	public String yeta2200_PDF_G104Y_2017_Insert(InfcPkgPdfG104yVO yetaPdfG104yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 신용카드 데이터 삭제(2017년 귀속)
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_G106Y_2017_Delete
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
	public void yeta2200_PDF_G106Y_2017_Delete(InfcPkgPdfG106yVO yetaPdfG106yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 신용카드 데이터 입력(2017년 귀속)
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_G106Y_2017_Insert
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
	public String yeta2200_PDF_G106Y_2017_Insert(InfcPkgPdfG106yVO yetaPdfG106yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 현금영수증 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_G205M_2017_Delete
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
	public void yeta2200_PDF_G205M_2017_Delete(InfcPkgPdfG205mVO yetaPdfG205mVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 현금영수증 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_G205M_2017_Insert
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
	public String yeta2200_PDF_G205M_2017_Insert(InfcPkgPdfG205mVO yetaPdfG205mVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 현금영수증 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_G205Y_2017_Delete
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
	public void yeta2200_PDF_G205Y_2017_Delete(InfcPkgPdfG205yVO yetaPdfG205yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 현금영수증 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_G205Y_2017_Insert
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
	public String yeta2200_PDF_G205Y_2017_Insert(InfcPkgPdfG205yVO yetaPdfG205yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 현금영수증 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_G206M_2017_Delete
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
	public void yeta2200_PDF_G206M_2017_Delete(InfcPkgPdfG206mVO yetaPdfG206mVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 현금영수증 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_G206M_2017_Insert
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
	public String yeta2200_PDF_G206M_2017_Insert(InfcPkgPdfG206mVO yetaPdfG206mVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 현금영수증 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_G206Y_2017_Delete
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
	public void yeta2200_PDF_G206Y_2017_Delete(InfcPkgPdfG206yVO yetaPdfG206yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 현금영수증 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_G206Y_2017_Insert
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
	public String yeta2200_PDF_G206Y_2017_Insert(InfcPkgPdfG206yVO yetaPdfG206yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 직붙카드 등 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_G304Y_2017_Delete
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
	public void yeta2200_PDF_G304Y_2017_Delete(InfcPkgPdfG304yVO yetaPdfG304yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 직불카드 등 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_G304Y_2017_Insert
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
	public String yeta2200_PDF_G304Y_2017_Insert(InfcPkgPdfG304yVO yetaPdfG304yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 직붙카드 등 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_G304M_2017_Delete
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
	public void yeta2200_PDF_G304M_2017_Delete(InfcPkgPdfG304mVO yetaPdfG304mVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 직불카드 등 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_G304M_2017_Insert
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
	public String yeta2200_PDF_G304M_2017_Insert(InfcPkgPdfG304mVO yetaPdfG304mVo) throws Exception; 
	

	/**
	 * <pre>
	 * 1. 개요 : 직붙카드 등 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_G306Y_2017_Delete
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
	public void yeta2200_PDF_G306Y_2017_Delete(InfcPkgPdfG306yVO yetaPdfG306yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 직불카드 등 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_G306Y_2017_Insert
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
	public String yeta2200_PDF_G306Y_2017_Insert(InfcPkgPdfG306yVO yetaPdfG306yVo) throws Exception; 


	/**
	 * <pre>
	 * 1. 개요 : 직붙카드 등 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_G306M_2017_Delete
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
	public void yeta2200_PDF_G306M_2017_Delete(InfcPkgPdfG306mVO yetaPdfG306mVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 직불카드 등 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_G306M_2017_Insert
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
	public String yeta2200_PDF_G306M_2017_Insert(InfcPkgPdfG306mVO yetaPdfG306mVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 주택임차차입금_원리금상환액 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_J101Y_2017_Delete
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
	public void yeta2200_PDF_J101Y_2017_Delete(InfcPkgPdfJ101yVO yetaPdfJ101yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 주택임차차입금_원리금상환액 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_J101Y_2017_Insert
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
	public String yeta2200_PDF_J101Y_2017_Insert(InfcPkgPdfJ101yVO yetaPdfJ101yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 장기주책저당차입금 이자상환액 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_J203Y_2017_Delete
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
	public void yeta2200_PDF_J203Y_2017_Delete(InfcPkgPdfJ203yVO yetaPdfJ203yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 장기주책저당차입금 이자상환액 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_J203Y_2017_Insert
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
	public String yeta2200_PDF_J203Y_2017_Insert(InfcPkgPdfJ203yVO yetaPdfJ203yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 장기주책저당차입금 이자상환액 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_J203M_2017_Delete
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
	public void yeta2200_PDF_J203M_2017_Delete(InfcPkgPdfJ203mVO yetaPdfJ203mVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 장기주책저당차입금 이자상환액 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_J203M_2017_Insert
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
	public String yeta2200_PDF_J203M_2017_Insert(InfcPkgPdfJ203mVO yetaPdfJ203mVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 주택마련저축 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_J301Y_2017_Delete
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
	public void yeta2200_PDF_J301Y_2017_Delete(InfcPkgPdfJ301yVO yetaPdfJ103yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 주택마련저축 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_J301Y_2017_Insert
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
	public String yeta2200_PDF_J301Y_2017_Insert(InfcPkgPdfJ301yVO yetaPdfJ103yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 목돈 안드는 전세 이자상환액 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_J401Y_2017_Delete
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
	public void yeta2200_PDF_J401Y_2017_Delete(InfcPkgPdfJ401yVO yetaPdfJ401yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 목돈 안드는 전세 이자상환액 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_J401Y_2017_Insert
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
	public String yeta2200_PDF_J401Y_2017_Insert(InfcPkgPdfJ401yVO yetaPdfJ401yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 소기업소강공인 공제부금 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_K101M_2017_Delete
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
	public void yeta2200_PDF_K101M_2017_Delete(InfcPkgPdfK101mVO yetaPdfK101mVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 소기업소강공인 공제부금 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_K101M_2017_Insert
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
	public String yeta2200_PDF_K101M_2017_Insert(InfcPkgPdfK101mVO yetaPdfK101mVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 소기업소강공인 공제부금 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_K101Y_2017_Delete
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
	public void yeta2200_PDF_K101Y_2017_Delete(InfcPkgPdfK101yVO yetaPdfK101yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 소기업소강공인 공제부금 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_K101Y_2017_Insert
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
	public String yeta2200_PDF_K101Y_2017_Insert(InfcPkgPdfK101yVO yetaPdfK101yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 기부금 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_L102Y_2017_Delete
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
	public void yeta2200_PDF_L102Y_2017_Delete(InfcPkgPdfL102yVO yetaPdfL102yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 기부금 공제부금 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_L102Y_2017_Insert
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
	public String yeta2200_PDF_L102Y_2017_Insert(InfcPkgPdfL102yVO yetaPdfL102yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 장기집합투자증권저축 공제부금 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_N101Y_2017_Delete
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
	public void yeta2200_PDF_N101Y_2017_Delete(InfcPkgPdfN101yVO yetaPdfN101yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 장기집합투자증권저축 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_N101Y_2017_Insert
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
	public String yeta2200_PDF_N101Y_2017_Insert(InfcPkgPdfN101yVO yetaPdfN101yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 건강보험료 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_O101M_2017_Delete
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
	public void yeta2200_PDF_O101M_2017_Delete(InfcPkgPdfO101mVO yetaPdfO101mVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 건강보험료 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_O101M_2017_Insert
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
	public String yeta2200_PDF_O101M_2017_Insert(InfcPkgPdfO101mVO yetaPdfO101mVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 건강보험료 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_O101Y_2017_Delete
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
	public void yeta2200_PDF_O101Y_2017_Delete(InfcPkgPdfO101yVO yetaPdfO101yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 건강보험료 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_O101M_2017_Insert
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
	public String yeta2200_PDF_O101Y_2017_Insert(InfcPkgPdfO101yVO yetaPdfO101uVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 국민연금보험료 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_P101M_2017_Delete
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
	public void yeta2200_PDF_P101M_2017_Delete(InfcPkgPdfP101mVO yetaPdfP101mVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 국민연금보험료 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_P101M_2017_Insert
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
	public String yeta2200_PDF_P101M_2017_Insert(InfcPkgPdfP101mVO yetaPdfP101mVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 국민연금보험료 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_P101Y_2017_Delete
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
	public void yeta2200_PDF_P101Y_2017_Delete(InfcPkgPdfP101yVO yetaPdfP101yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 국민연금보험료 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_P101Y_2017_Insert
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
	public String yeta2200_PDF_P101Y_2017_Insert(InfcPkgPdfP101yVO yetaPdfP101yVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 국민연금보험료 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_P102M_2017_Delete
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
	public void yeta2200_PDF_P102M_2017_Delete(InfcPkgPdfP102mVO yetaPdfP102mVo) throws Exception; 

	/**
	 * <pre>
	 * 1. 개요 : 국민연금보험료 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_P102M_2017_Insert
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
	public String yeta2200_PDF_P102M_2017_Insert(InfcPkgPdfP102mVO yetaPdfP102mVo) throws Exception; 
	/**
	 * <pre>
	 * 1. 개요 : 국민연금보험료 데이터 입력
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_P102Y_2017_Delete
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
	public void yeta2200_PDF_P102Y_2017_Delete(InfcPkgPdfP102yVO yetaPdfP102yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 국민연금보험료 데이터 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_P102Y_2017_Insert
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
	public String yeta2200_PDF_P102Y_2017_Insert(InfcPkgPdfP102yVO yetaPdfP102yVo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE162015_2017_Delete
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
	public void yeta2200_PDF_YE162015_2017_Delete(InfcPkgPdfYE162015VO yetaPdfYE162015Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE162015_2017_Insert
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
	public String yeta2200_PDF_YE162015_2017_Insert(InfcPkgPdfYE162015VO yetaPdfYE162015Vo) throws Exception; 
	
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167010_2017_Delete
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
	public void yeta2200_PDF_YE167010_2017_Delete(InfcPkgYe167010VO yetaYE167010Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167010_2017_Insert
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
	public String yeta2200_PDF_YE167010_2017_Insert(InfcPkgYe167010VO yetaYE167010Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167020_2017_Delete
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
	public void yeta2200_PDF_YE167020_2017_Delete(InfcPkgYe167020VO yetaYE167020Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167020_2017_Insert
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
	public String yeta2200_PDF_YE167020_2017_Insert(InfcPkgYe167020VO yetaYE167020Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167030_2017_Delete
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
	public void yeta2200_PDF_YE167030_2017_Delete(InfcPkgYe167030VO yetaYE167030Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167030_2017_Insert
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
	public String yeta2200_PDF_YE167030_2017_Insert(InfcPkgYe167030VO yetaYE167030Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167040_2017_Delete
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
	public void yeta2200_PDF_YE167040_2017_Delete(InfcPkgYe167040VO yetaYE167040Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167040_2017_Insert
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
	public String yeta2200_PDF_YE167040_2017_Insert(InfcPkgYe167040VO yetaYE167040Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167050_2017_Delete
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
	public void yeta2200_PDF_YE167050_2017_Delete(InfcPkgYe167050VO yetaYE167050Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167050_2017_Insert
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
	public String yeta2200_PDF_YE167050_2017_Insert(InfcPkgYe167050VO yetaYE167050Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167060_2017_Delete
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
	public void yeta2200_PDF_YE167060_2017_Delete(InfcPkgYe167060VO yetaYE167060Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167060_2017_Insert
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
	public String yeta2200_PDF_YE167060_2017_Insert(InfcPkgYe167060VO yetaYE167060Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167070_2017_Delete
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
	public void yeta2200_PDF_YE167070_2017_Delete(InfcPkgYe167070VO yetaYE167070Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167070_2017_Insert
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
	public String yeta2200_PDF_YE167070_2017_Insert(InfcPkgYe167070VO yetaYE167070Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167530_2017_Delete
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
	public void yeta2200_PDF_YE167530_2017_Delete(InfcPkgYe167530VO yetaYE167530Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167530_2017_Insert
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
	public String yeta2200_PDF_YE167530_2017_Insert(InfcPkgYe167530VO yetaYE167530Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167110_2017_Delete
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
	public void yeta2200_PDF_YE167110_2017_Delete(InfcPkgYe167110VO yetaYE167110Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167110_2017_Insert
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
	public String yeta2200_PDF_YE167110_2017_Insert(InfcPkgYe167110VO yetaYE167110Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167120_2017_Delete
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
	public void yeta2200_PDF_YE167120_2017_Delete(InfcPkgYe167120VO yetaYE167120Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167120_2017_Insert
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
	public String yeta2200_PDF_YE167120_2017_Insert(InfcPkgYe167120VO yetaYE167120Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167130_2017_Delete
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
	public void yeta2200_PDF_YE167130_2017_Delete(InfcPkgYe167130VO yetaYE167130Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167130_2017_Insert
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
	public String yeta2200_PDF_YE167130_2017_Insert(InfcPkgYe167130VO yetaYE167130Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167140_2017_Delete
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
	public void yeta2200_PDF_YE167140_2017_Delete(InfcPkgYe167140VO yetaYE167140Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167140_2017_Insert
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
	public String yeta2200_PDF_YE167140_2017_Insert(InfcPkgYe167140VO yetaYE167140Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167150_2017_Delete
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
	public void yeta2200_PDF_YE167150_2017_Delete(InfcPkgYe167150VO yetaYE167150Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167150_2017_Insert
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
	public String yeta2200_PDF_YE167150_2017_Insert(InfcPkgYe167150VO yetaYE167150Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167210_2017_Delete
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
	public void yeta2200_PDF_YE167210_2017_Delete(InfcPkgYe167210VO yetaYE167210Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167210_2017_Insert
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
	public String yeta2200_PDF_YE167210_2017_Insert(InfcPkgYe167210VO yetaYE167210Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167220_2017_Delete
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
	public void yeta2200_PDF_YE167220_2017_Delete(InfcPkgYe167220VO yetaYE167220Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167220_2017_Insert
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
	public String yeta2200_PDF_YE167220_2017_Insert(InfcPkgYe167220VO yetaYE167220Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167230_2017_Delete
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
	public void yeta2200_PDF_YE167230_2017_Delete(InfcPkgYe167230VO yetaYE167230Vo) throws Exception; 
		
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167230_2017_Insert
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
	public String yeta2200_PDF_YE167230_2017_Insert(InfcPkgYe167230VO yetaYE167230Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167240_2017_Delete
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
	public void yeta2200_PDF_YE167240_2017_Delete(InfcPkgYe167240VO yetaYE167240Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167240_2017_Insert
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
	public String yeta2200_PDF_YE167240_2017_Insert(InfcPkgYe167240VO yetaYE167240Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167310_2017_Delete
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
	public void yeta2200_PDF_YE167310_2017_Delete(InfcPkgYe167310VO yetaYE167310Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167310_2017_Insert
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
	public String yeta2200_PDF_YE167310_2017_Insert(InfcPkgYe167310VO yetaYE167310Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167320_2017_Delete
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
	public void yeta2200_PDF_YE167320_2017_Delete(InfcPkgYe167320VO yetaYE167320Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167320_2017_Insert
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
	public String yeta2200_PDF_YE167320_2017_Insert(InfcPkgYe167320VO yetaYE167320Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167410_2017_Delete
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
	public void yeta2200_PDF_YE167410_2017_Delete(InfcPkgYe167410VO yetaYE167410Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167410_2017_Insert
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
	public String yeta2200_PDF_YE167410_2017_Insert(InfcPkgYe167410VO yetaYE167410Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167420_2017_Delete
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
	public void yeta2200_PDF_YE167420_2017_Delete(InfcPkgYe167420VO yetaYE167420Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167420_2017_Insert
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
	public String yeta2200_PDF_YE167420_2017_Insert(InfcPkgYe167420VO yetaYE167420Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167430_2017_Delete
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
	public void yeta2200_PDF_YE167430_2017_Delete(InfcPkgYe167430VO yetaYE167430Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167430_2017_Insert
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
	public String yeta2200_PDF_YE167430_2017_Insert(InfcPkgYe167430VO yetaYE167430Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167440_2017_Delete
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
	public void yeta2200_PDF_YE167440_2017_Delete(InfcPkgYe167440VO yetaYE167440Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167440_2017_Insert
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
	public String yeta2200_PDF_YE167440_2017_Insert(InfcPkgYe167440VO yetaYE167440Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167510_2017_Delete
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
	public void yeta2200_PDF_YE167510_2017_Delete(InfcPkgYe167510VO yetaYE167510Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167510_2017_Insert
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
	public String yeta2200_PDF_YE167510_2017_Insert(InfcPkgYe167510VO yetaYE167510Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167520_2017_Delete
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
	public void yeta2200_PDF_YE167520_2017_Delete(InfcPkgYe167520VO yetaYE167520Vo) throws Exception; 
	
	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : yeta2200_PDF_YE167520_2017_Insert
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
	public String yeta2200_PDF_YE167520_2017_Insert(InfcPkgYe167520VO yetaYE167520Vo) throws Exception; 
	
	/*********************************************************************************************** 
	 * 2017년도 간소화 자료 업데이트 부분처리 서비스 시작 정산데이타 반영부 처리 메서드 시작
	 ***********************************************************************************************/
	
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 보장성,장애인보장성 보험료 개별적업데이트  
	 * 2. 처리내용 : 보장성,장애인보장성 보험료 개별적업데이트
	 * </pre>
	 * @Method Name : PdfYeta2017_A102Y_YE161040_Update
	 * @date : 2018. 1. 22.
	 * @author : atres
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 22.		atres				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param ye161010VO
	 * @return
	 * @throws Exception
	 */
	public int PdfYeta2017_A102Y_YE161040_Update(InfcPkgYe161040VO ye161040VO) throws Exception; 
	public String fnYeta2200_A102Y_YE161080_2017_Update(InfcPkgYe161080VO infcPkgYe161080Vo) throws Exception; 
	 
	//의료비 
	public String PdfYeta2200_B101Y_YE164010_Delete(InfcPkgYe164010VO infcPkgYe164010Vo) throws Exception; 
	public String PdfYeta2200_B101Y_YE164010_Insert(InfcPkgYe164010VO infcPkgYe164010Vo) throws Exception; 
	
	public int PdfYeta2017_B101Y_YE161040_Update(InfcPkgYe161040VO ye161040VO) throws Exception; 
	
	// 의료비정리 합계
	public int fnYeta2200_B101Y_YE161080_2017_Update(InfcPkgYe161080VO infcPkgYe161080Vo) throws Exception; 
  
	
	//교육비처리 
	public String PdfYeta2200_C101Y_YE161090_Delete(InfcPkgYe161090VO infcPkgYe161090Vo) throws Exception; 
	public String PdfYeta2200_C101Y_YE161090_Insert(InfcPkgYe161090VO infcPkgYe161090Vo) throws Exception; 
	 
	public int PdfYeta2017_C101Y_YE161040_Update(InfcPkgYe161040VO ye161040VO) throws Exception; 
	
	public String fnYeta2200_C101Y_YE161080_2017_Update(InfcPkgYe161080VO infcPkgYe161080Vo) throws Exception; 
	
	
	//직업훈련비
	public String PdfYeta2200_C202Y_YE161090_Delete(InfcPkgYe161090VO infcPkgYe161090Vo) throws Exception; 
	public String PdfYeta2200_C202Y_YE161090_Insert(InfcPkgYe161090VO infcPkgYe161090Vo) throws Exception; 
	 
	//public String PdfYeta2017_C202Y_YE161040_Update(InfcPkgYe161040VO ye161040VO) throws Exception; 
	
	//public String fnYeta2200_C202Y_YE161080_2017_Update(InfcPkgYe161080VO infcPkgYe161080Vo) throws Exception; 
	
	
	//교복구입비
	public String PdfYeta2200_C301Y_YE161090_Delete(InfcPkgYe161090VO infcPkgYe161090Vo) throws Exception; 
	public String PdfYeta2200_C301Y_YE161090_Insert(InfcPkgYe161090VO infcPkgYe161090Vo) throws Exception; 
	 
//	public String PdfYeta2017_C301Y_YE161040_Update(InfcPkgYe161040VO ye161040VO) throws Exception; 
	
//	public String fnYeta2200_C301Y_YE161080_2017_Update(InfcPkgYe161080VO infcPkgYe161080Vo) throws Exception; 
	
	
	//학자금대출
	public String PdfYeta2200_C401Y_YE161090_Delete(InfcPkgYe161090VO infcPkgYe161090Vo) throws Exception; 
	public String PdfYeta2200_C401Y_YE161090_Insert(InfcPkgYe161090VO infcPkgYe161090Vo) throws Exception; 
	 
//	public String PdfYeta2017_C401Y_YE161040_Update(InfcPkgYe161040VO ye161040VO) throws Exception; 
//	
//	public String fnYeta2200_C401Y_YE161080_2017_Update(InfcPkgYe161080VO infcPkgYe161080Vo) throws Exception; 
		
	//개인연금저축 
	public String PdfYeta2200_D101Y_YE162010_Delete(InfcPkgYe162010VO infcPkgYe162010Vo) throws Exception; 
	public String PdfYeta2200_D101Y_YE162010_Insert(InfcPkgYe162010VO infcPkgYe162010Vo) throws Exception; 
	 
	public String fnYeta2200_D101Y_YE161070_2017_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception; 
	
	//연금저축
	
	public String PdfYeta2200_E102Y_YE162010_Delete(InfcPkgYe162010VO infcPkgYe162010Vo) throws Exception; 
	public String PdfYeta2200_E102Y_YE162010_Insert(InfcPkgYe162010VO infcPkgYe162010Vo) throws Exception; 
	 
	public String fnYeta2200_E102Y_YE161080_2017_Update(InfcPkgYe161080VO infcPkgYe161080Vo) throws Exception; 
	
	
	//퇴직연금 
	public String PdfYeta2200_F102Y_YE162020_Delete(InfcPkgYe162020VO infcPkgYe162020Vo) throws Exception; 
	public String PdfYeta2200_F102Y_YE162020_Insert(InfcPkgYe162020VO infcPkgYe162020Vo) throws Exception; 
	 
	public String fnYeta2200_F102Y_YE161080_2017_Update(InfcPkgYe161080VO infcPkgYe161080Vo) throws Exception; 
	

	//YE161040 소득공제명세에 신용카드 
	public int PdfYeta2017_G106Y_YE161040_Update(InfcPkgYe161040VO ye161040VO) throws Exception; 
	
	public String PdfYeta2200_G106Y_YE166020_Update(InfcPkgYe166020VO infcPkgYe166020Vo) throws Exception;  
	
	public String fnYeta2200_G106Y_YE161070_2017_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception; 
	
	 
  //YE161040 소득공제명세에 현금영수증  
	public int PdfYeta2017_G206Y_YE161040_Update(InfcPkgYe161040VO ye161040VO) throws Exception; 
	
	 
	public String fnYeta2200_G206Y_YE161070_2017_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception; 
	
	//YE161040 소득공제명세에직불카드   
	public int PdfYeta2017_G306Y_YE161040_Update(InfcPkgYe161040VO ye161040VO) throws Exception; 
	
	 
	public String fnYeta2200_G306Y_YE161070_2017_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception; 
	
	
	//주책임차차입금원리금상환액
	public String fnYeta2200_J101Y_YE161060_2017_Update(InfcPkgYe161060VO infcPkgYe161060Vo) throws Exception; 
		
	 
	//장기주택저당차입금	 
	 public List<InfcPkgPdfJ203yVO> PdfYeta2200_F102Y_PDF_J203Y_Select(InfcPkgPdfJ203ySrhVO yetaPdfJ203yVo) throws Exception; 
	
	 public String fnYeta2200_J203Y_YE161060_2017_Update(InfcPkgYe161060VO infcPkgYe161060Vo) throws Exception; 
	 
	  
	//주택마련 
    public String PdfYeta2200_J301Y_YE162030_Delete(InfcPkgYe162030VO infcPkgYe162030Vo) throws Exception; 
	public String PdfYeta2200_J301Y_YE162030_Insert(InfcPkgYe162030VO infcPkgYe162030Vo) throws Exception; 
	 
	public String fnYeta2200_J301Y_YE161070_2017_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception; 
		
	//소상공인공제  
	public String fnYeta2200_K101M_YE161070_2017_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception; 
		 
	//기부금 
    public String PdfYeta2200_L102Y_YE165010_Delete(InfcPkgYe165010VO infcPkgYe165010Vo) throws Exception; 
	public String PdfYeta2200_L102Y_YE165010_Insert(InfcPkgYe165010VO infcPkgYe165010Vo) throws Exception; 
	
	public String PdfYeta2200_L102Y_YE165020_Delete(InfcPkgYe165020VO infcPkgYe165020Vo) throws Exception; 
	public String PdfYeta2200_L102Y_YE165020_Insert(InfcPkgYe165020VO infcPkgYe165020Vo) throws Exception; 
		
    public String PdfYeta2200_L102Y_YE165030_Delete(InfcPkgYe165030VO infcPkgYe165030Vo) throws Exception;
	public String PdfYeta2200_L102Y_YE165030_Insert(InfcPkgYe165030VO infcPkgYe165030Vo) throws Exception; 
	 
	public int fnYeta2200_L102Y_YE161040_2017_Update(InfcPkgYe161040VO infcPkgYe161040Vo) throws Exception; 
	
	
	public int fnYeta2200_L102Y_YE161080_2017_Update(InfcPkgYe161080VO infcPkgYe161080Vo) throws Exception; 
	public String fnYeta2200_L102Y_YE161060_2017_Update(InfcPkgYe161060VO infcPkgYe161060Vo) throws Exception; 
	 
	
	//장기집합 투자 증권 
    public String PdfYeta2200_N101Y_YE162040_Delete(InfcPkgYe162040VO infcPkgYe162040Vo) throws Exception; 
	public String PdfYeta2200_N101Y_YE162040_Insert(InfcPkgYe162040VO infcPkgYe162040Vo) throws Exception; 
	
	public String fnYeta2200_N101Y_YE161070_2017_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception; 
	 
	//건강보험료 금액 
	public String PdfYeta2017_O101M_YE161040_Update(InfcPkgYe161040VO infcPkgYe161040Vo) throws Exception; 
	public String fnYeta2200_O101M_YE161060_2017_Update(InfcPkgYe161060VO infcPkgYe161060Vo) throws Exception; 
	 
	//YE161055 국민연금 주사업장 
	public String PdfYeta2017_P102M_YE161055_Update(InfcPkgYe161055VO infcPkgYe161055Vo) throws Exception; 
	public int fnYeta2200_P102M_YE161050_2017_Update(InfcPkgYe161050VO infcPkgYe161050Vo) throws Exception; 
	
	public int PdfYeta2200_AllDelete(InfcPkgYe161010VO ye161010VO) throws Exception; 
	 
	/*********************************************************************************************** 
	 * 2017년도 간소화 자료 업데이트 부분처리 서비스 시작 정산데이타 반영부 처리 메서드 종료
	 ***********************************************************************************************/
	
}
