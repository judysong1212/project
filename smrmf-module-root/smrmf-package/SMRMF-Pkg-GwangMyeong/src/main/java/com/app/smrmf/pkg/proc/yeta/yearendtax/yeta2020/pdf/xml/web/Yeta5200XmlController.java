package com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2020.pdf.xml.web;

import java.io.PrintWriter;
import java.io.StringReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.infc.yearendtax.server.service.yeta2020.service.InfcPkgYeta5200Service;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161010_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161020_2020_VO;
import com.app.smrmf.pkg.yeta.yeta2020.pdfxml.Yeta5200PkgXmlController;
//import com.app.smrmf.props.ExtermsProps;
import com.dreamsecurity.exception.DVException;
import com.dreamsecurity.verify.DSTSPDFSig;
import com.epapyrus.api.ExportCustomFile;

import egovframework.rte.fdl.property.EgovPropertyService;

@Controller
public class Yeta5200XmlController {



	private static final Logger logger = LoggerFactory.getLogger(Yeta5200XmlController.class);  


	@Resource(name = "InfcPkgYeta5200Service")
	private InfcPkgYeta5200Service yeta5200Service;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	private String p_pwd = "";  // 비밀번호
	private String key = "XML";  //key 


	@RequestMapping(value = "/imp/XmlYeta5200Import.do")
	public String xmlYeta5200Import(@ModelAttribute("InfcPkgYe161010_2020_VO") InfcPkgYe161010_2020_VO ye161010VO, HttpServletRequest request, 
			HttpServletResponse response, Model model) throws Exception {

		PrintWriter out ;
		
		String p_pwd = "";
		String sResult = "";
		String sResult2 = "";

		if  (yeta5200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yeta5200Service = (InfcPkgYeta5200Service) wac.getBean("InfcPkgYeta5200Service" ); 

		}
		InfcPkgYe161020_2020_VO ye161020VO = new InfcPkgYe161020_2020_VO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		Yeta5200PkgXmlController yete320 = new Yeta5200PkgXmlController();
		try	{
			ye161020VO.setSystemkey(ye161010VO.getSystemkey());
			ye161020VO.setDpobCd(ye161010VO.getDpobCd());
			ye161020VO.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
			ye161020VO.setClutSeptCd(ye161010VO.getClutSeptCd());
			ye161020VO.setIsmt(sessionUser.getUsrId());
			ye161020VO.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			ye161020VO.setFileSbtYn("Y");

			/* 업로드 파일 정의 부분(해당 시스템에서 사용하는  파일 업로드 패키지에 따라 수정 필요) */
			//DiskFileUpload fileUpload = new DiskFileUpload();

			/* 업로드 컨텐츠 목록 추출 */
			//List fileItemList   = fileUpload.parseRequest(request);

			/* 업로드 컨텐츠 종류에 따라 반복 처리 */
			//int v_fileCnt = fileItemList.size();
			//for(int i = 0 ; i < v_fileCnt ; i++) {


			final MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			final Map<String, MultipartFile> files = multiRequest.getFileMap();
			// InputStream fis = null; // 2011.11.1 보안점검 후속조치 

			Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
			MultipartFile file; 


			while (itr.hasNext()) {
				Entry<String, MultipartFile> entry = itr.next();

				file = entry.getValue();


				// 	FileItem fileItem = (FileItem) fileItemList.get(i);

				/* 문서 비밀번호 가져오기(비밀번호 없는 문서일 경우 생략 가능. 이 때 p_pwd="") */
				// 방식1.사용자 입력 방식인 경우(폼필드 입력값 추출)
				//	if (fileItem.isFormField()) {
				//		if (fileItem.getFieldName().equals("p_pwd")) {
				//			p_pwd = fileItem.getString();
				//		continue;
				//	}
				//}
				// 방식2.파일명등의 정보를 기준으로 인사DB 등에서 가져오는 경우
				// 비밀번호를 가져오는 로직 구현 
				System.out.println("결과값 : "+Boolean.parseBoolean(ye161010VO.getCreOriginYn()));
				if (Boolean.TRUE.equals(Boolean.parseBoolean(ye161010VO.getCreOriginYn()))) {
					p_pwd = ye161010VO.getCrePasswd();  // 인사정보 등에서 가져오기
				} 

				// path 제외한 파일명만 취득
				//String[] filePath = fileItem.getName().split("\\\\");
				//String fileName = filePath[filePath.length -1]; //파일명(ex:abcd.pdf)
				//System.out.println("\n\n<!-- [" + fileName + "] -->");

				// PDF파일이 아닌 경우 skip
				//        		if (!fileName.toUpperCase().endsWith(".PDF")) {
				//        			out.println("<!-- PDF 파일이 아닙니다. -->");
				//        			continue;
				//        		}

				if (!"".equals(file.getOriginalFilename())) {
					// 2011.10.07 업로드 파일에 대한 확장자를 체크
					if (file.getOriginalFilename().toUpperCase().endsWith(".PDF") ) {

						// 파일내용을 읽음
						byte[] pdfBytes = file.getBytes();   //fileItem.get();
						boolean isSuccess = false;
						if (Boolean.TRUE.equals(Boolean.parseBoolean(ye161010VO.getCreOriginYn()))) {
							/* [Step1] 전자문서 위변조 검증 */
							try {

								DSTSPDFSig dstsPdfsig = new DSTSPDFSig();

								dstsPdfsig.init(pdfBytes);
								dstsPdfsig.tokenParse();

								isSuccess = dstsPdfsig.tokenVerify();

								if( isSuccess ) {
									System.out.println("<!-- 검증 완료(진본) -->");
								} else {
									String msg = dstsPdfsig.getTstVerifyFailInfo();
									System.out.println(msg);
									sResult =  "success";
								}
							} catch (DVException e) {
								System.out.println("에러 코드 : "+ e.getLastError());
								System.out.println("에러 메시지 : "+ e.getMessage());
								sResult = "error";
							}
						} else {
							isSuccess = true;
						}
						/* [Step2] XML(or SAM) 데이터 추출 */

						try {
							if (isSuccess) {
								ExportCustomFile pdf = new ExportCustomFile();

								// 데이터 추출
								byte[] buf = pdf.NTS_GetFileBufEx(pdfBytes, p_pwd, key, false );
								int v_ret = pdf.NTS_GetLastError();

								if (v_ret == 1) {
									String strXml = new String( buf, "UTF-8" );
									// 정상적으로 추출된 데이터 활용하는 로직 구현 부분 
									System.out.print(strXml.replace("<", "&lt;")
											.replace(">", "&gt;")
											.replace(" ", "&nbsp;")
											.replace("\n", "<br/>")
											.replace("\t", "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"));   // 예  화면에 출력

									//DOM Document 객체 생성하기 위한 메서드 
									DocumentBuilderFactory factory   = DocumentBuilderFactory.newInstance();
									//DOM 파서로부터 입력받은 파일을 파싱하도록 요청
									DocumentBuilder builder = factory.newDocumentBuilder(); 

									Document xmlDoc = null; 
									//DOM 파서로부터 입력받은 파일을 파싱하도록 요청 
									//*****************************************************
									xmlDoc  =  builder.parse(new InputSource(new StringReader(strXml)));
									//*****************************************************
									xmlDoc.getDocumentElement().normalize(); 
									//                		               logger.debug("맵값확인 : "+ commandMap.get(0).toString());

									sResult2 = yete320.PayrXmlDataInsert(ye161010VO, xmlDoc, request);
									yeta5200Service.yeta5200_Ye161020_2020_Update(ye161020VO);

									response.setContentType("text/html; charset=UTF-8");

									if (sResult2.equals("1")) {
	
										out = response.getWriter();

										out.println("<script>alert('PDF 전자문서 업로드가 정상적으로 완료되었습니다.'); </script>");

										out.flush();

									}
									else if (sResult2.equals("2")) {
										
										out = response.getWriter();

										out.println("<script>alert('업로드 실패 ! PDF 전자문서의 귀속연도를 확인해주세요.'); </script>");

										out.flush();
									}
									else {
										
										out = response.getWriter();

										out.println("<script>alert('업로드 실패 ! PDF 전자문서의 주민등록번호와 일치하는지 확인해주세요.'); </script>");

										out.flush();
									}
									

								} else if (v_ret == 0) {
									System.out.println("연말정산간소화 표준 전자문서가 아닙니다.");
									response.setContentType("text/html; charset=UTF-8");
									
									out = response.getWriter();

									out.println("<script>alert('업로드 실패 ! 연말정산간소화 표준 전자문서가 아닙니다.'); </script>");

									out.flush();
								} else if (v_ret == -1) {
//									System.out.println("비밀번호가 틀립니다.");
									response.setContentType("text/html; charset=UTF-8");
									
									out = response.getWriter();

									out.println("<script>alert('업로드 실패 ! 비밀번호가 틀립니다.'); </script>");

									out.flush();
								} else if (v_ret == -2) {
//									System.out.println("PDF문서가 아니거나 손상된 문서입니다.");
									response.setContentType("text/html; charset=UTF-8");
									
									out = response.getWriter();

									out.println("<script>alert('업로드 실패 ! PDF문서가 아니거나 손상된 문서입니다.'); </script>");

									out.flush();
								} else {
//									System.out.println("데이터 추출에 실패하였습니다.");
									response.setContentType("text/html; charset=UTF-8");
									
									out = response.getWriter();

									out.println("<script>alert('업로드 실패 ! 데이터 추출에 실패하였습니다.'); </script>");

									out.flush();
								}
							}

						} catch (Exception e) {
							response.setContentType("text/html; charset=UTF-8");
							
							out = response.getWriter();

							out.println("<script>alert('업로드 실패 ! 데이터 추출 실패하였습니다.'); </script>");

							out.flush();
							System.out.println("[Step2] 데이터 추출 실패(" + e.toString() + ")");
							continue;
						}

					}else{
						logger.info("PDF 파일 타입만 등록이 가능합니다."); 
						response.setContentType("text/html; charset=UTF-8");
						
						out = response.getWriter();

						out.println("<script>alert('업로드 실패 ! PDF 파일 타입만 등록이 가능합니다.'); </script>");

						out.flush();
					}
				}
			}    


		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception" + e.getMessage());
			response.setContentType("text/html; charset=UTF-8");
			
			out = response.getWriter();

			out.println("<script>alert('업로드 실패 ! 비정상적으로 종료되었습니다.'); </script>");

			out.flush();
		} 

		return sResult;

	}  


	/** 소득공제 신고서 */
	@RequestMapping(value = "/imp/XmlYeta5200DdcImport.do")
	public String xmlYeta5200DdcImport(@ModelAttribute("InfcPkgYe161010_2020_VO") InfcPkgYe161010_2020_VO ye161010VO, HttpServletRequest request,
			HttpServletResponse response, Model model) throws Exception {

		PrintWriter out ;
		
		String p_pwd = "";
		String sResult = "";
		String sResult2 = "";

		if  (yeta5200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yeta5200Service = (InfcPkgYeta5200Service) wac.getBean("InfcPkgYeta5200Service" ); 

		}

		Yeta5200PkgXmlController yete320 = new Yeta5200PkgXmlController();
		try	{

			/* 업로드 파일 정의 부분(해당 시스템에서 사용하는  파일 업로드 패키지에 따라 수정 필요) */
			//DiskFileUpload fileUpload = new DiskFileUpload();

			/* 업로드 컨텐츠 목록 추출 */
			//List fileItemList   = fileUpload.parseRequest(request);

			/* 업로드 컨텐츠 종류에 따라 반복 처리 */
			//int v_fileCnt = fileItemList.size();
			//for(int i = 0 ; i < v_fileCnt ; i++) {


			final MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			final Map<String, MultipartFile> files = multiRequest.getFileMap();
			// InputStream fis = null; // 2011.11.1 보안점검 후속조치 

			Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
			MultipartFile file; 


			while (itr.hasNext()) {
				Entry<String, MultipartFile> entry = itr.next();

				file = entry.getValue();


				// 	FileItem fileItem = (FileItem) fileItemList.get(i);

				/* 문서 비밀번호 가져오기(비밀번호 없는 문서일 경우 생략 가능. 이 때 p_pwd="") */
				// 방식1.사용자 입력 방식인 경우(폼필드 입력값 추출)
				//	if (fileItem.isFormField()) {
				//		if (fileItem.getFieldName().equals("p_pwd")) {
				//			p_pwd = fileItem.getString();
				//		continue;
				//	}
				//}
				// 방식2.파일명등의 정보를 기준으로 인사DB 등에서 가져오는 경우
				// 비밀번호를 가져오는 로직 구현 
				if (Boolean.TRUE.equals(Boolean.parseBoolean(ye161010VO.getDdcCreOriginYn()))) {
					p_pwd = ye161010VO.getDdcCrePasswd();  // 인사정보 등에서 가져오기
				} 

				// path 제외한 파일명만 취득
				//String[] filePath = fileItem.getName().split("\\\\");
				//String fileName = filePath[filePath.length -1]; //파일명(ex:abcd.pdf)
				//System.out.println("\n\n<!-- [" + fileName + "] -->");

				// PDF파일이 아닌 경우 skip
				//        		if (!fileName.toUpperCase().endsWith(".PDF")) {
				//        			out.println("<!-- PDF 파일이 아닙니다. -->");
				//        			continue;
				//        		}

				if (!"".equals(file.getOriginalFilename())) {
					// 2011.10.07 업로드 파일에 대한 확장자를 체크
					if (file.getOriginalFilename().toUpperCase().endsWith(".PDF") ) {

						// 파일내용을 읽음
						byte[] pdfBytes = file.getBytes();   //fileItem.get();
						boolean isSuccess = true;
						if (Boolean.TRUE.equals(Boolean.parseBoolean(ye161010VO.getDdcCreOriginYn()))) {
							/* [Step1] 전자문서 위변조 검증 */
							try {

								DSTSPDFSig dstsPdfsig = new DSTSPDFSig();

								dstsPdfsig.init(pdfBytes);
								dstsPdfsig.tokenParse();

								isSuccess = dstsPdfsig.tokenVerify();

								if( isSuccess ) {
									System.out.println("<!-- 검증 완료(진본) -->");
								} else {
									String msg = dstsPdfsig.getTstVerifyFailInfo();
									System.out.println(msg);
									sResult =  "success";
								}
							} catch (DVException e) {
								System.out.println("에러 코드 : "+ e.getLastError());
								System.out.println("에러 메시지 : "+ e.getMessage());
								sResult = "error";
							}
						} else {
							isSuccess = true;
						}
						/* [Step2] XML(or SAM) 데이터 추출 */ 
						try {
							if (isSuccess) {
								ExportCustomFile pdf = new ExportCustomFile();

								// 데이터 추출
								byte[] buf = pdf.NTS_GetFileBufEx(pdfBytes, p_pwd, key, false );
								int v_ret = pdf.NTS_GetLastError();

								if (v_ret == 1) {
									String strXml = new String( buf, "UTF-8" );
									// 정상적으로 추출된 데이터 활용하는 로직 구현 부분 
									System.out.print(strXml.replace("<", "&lt;")
											.replace(">", "&gt;")
											.replace(" ", "&nbsp;")
											.replace("\n", "<br/>")
											.replace("\t", "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"));   // 예  화면에 출력

									//DOM Document 객체 생성하기 위한 메서드 
									DocumentBuilderFactory factory   = DocumentBuilderFactory.newInstance();
									//DOM 파서로부터 입력받은 파일을 파싱하도록 요청
									DocumentBuilder builder = factory.newDocumentBuilder(); 

									Document xmlDoc = null; 
									//DOM 파서로부터 입력받은 파일을 파싱하도록 요청 
									//*****************************************************
									xmlDoc  =  builder.parse(new InputSource(new StringReader(strXml)));
									//*****************************************************
									xmlDoc.getDocumentElement().normalize(); 

									sResult2 = yete320.PayrDdcXmlDataInsert(ye161010VO, xmlDoc, request);
									
									response.setContentType("text/html; charset=UTF-8");

									if (sResult2.equals("1")) {

										out = response.getWriter();

										out.println("<script>alert('PDF 전자문서 업로드가 정상적으로 완료되었습니다.'); </script>");

										out.flush();

									}
									else if (sResult2.equals("2")) {
										
										out = response.getWriter();

										out.println("<script>alert('업로드 실패 ! PDF 전자문서의 귀속연도를 확인해주세요.'); </script>");

										out.flush();
									}
									else {
										
										out = response.getWriter();

										out.println("<script>alert('업로드 실패 ! PDF 전자문서의 주민등록번호와 일치하는지 확인해주세요.'); </script>");

										out.flush();
									}

								} else if (v_ret == 0) {
									System.out.println("연말정산간소화 표준 전자문서가 아닙니다.");
									response.setContentType("text/html; charset=UTF-8");
									
									out = response.getWriter();

									out.println("<script>alert('업로드 실패 ! 공제 신고서 표준 전자문서가 아닙니다.'); </script>");

									out.flush();
								} else if (v_ret == -1) {
//									System.out.println("비밀번호가 틀립니다.");
									response.setContentType("text/html; charset=UTF-8");
									
									out = response.getWriter();

									out.println("<script>alert('업로드 실패 ! 비밀번호가 틀립니다.'); </script>");

									out.flush();
								} else if (v_ret == -2) {
//									System.out.println("PDF문서가 아니거나 손상된 문서입니다.");
									response.setContentType("text/html; charset=UTF-8");
									
									out = response.getWriter();

									out.println("<script>alert('업로드 실패 ! PDF문서가 아니거나 손상된 문서입니다.'); </script>");

									out.flush();
								} else {
//									System.out.println("데이터 추출에 실패하였습니다.");
									response.setContentType("text/html; charset=UTF-8");
									
									out = response.getWriter();

									out.println("<script>alert('업로드 실패 ! 데이터 추출에 실패하였습니다.'); </script>");

									out.flush();
								}
							}

						} catch (Exception e) {
							response.setContentType("text/html; charset=UTF-8");
							
							out = response.getWriter();

							out.println("<script>alert('업로드 실패 ! 데이터 추출 실패하였습니다.'); </script>");

							out.flush();
							System.out.println("[Step2] 데이터 추출 실패(" + e.toString() + ")");
							continue;
						}

					}else{
						logger.info("PDF 파일 타입만 등록이 가능합니다."); 
						response.setContentType("text/html; charset=UTF-8");
						
						out = response.getWriter();

						out.println("<script>alert('업로드 실패 ! PDF 파일 타입만 등록이 가능합니다.'); </script>");

						out.flush();
					}
				}
			}    


		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception" + e.getMessage());
			response.setContentType("text/html; charset=UTF-8");
			
			out = response.getWriter();

			out.println("<script>alert('업로드 실패 ! 비정상적으로 종료되었습니다.'); </script>");

			out.flush();
		} 

		return sResult;

	}  


  


}
