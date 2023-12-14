package egovframework.com.cmm.service;

/**
 *  Class Name : Globals.java
 *  Description : 시스템 구동 시 프로퍼티를 통해 사용될 전역변수를 정의한다.
 *  Modification Information
 *
 *     수정일         수정자                   수정내용
 *   -------    --------    ---------------------------
 *   2009.01.19    박지욱          최초 생성
 *
 *  @author 공통 서비스 개발팀 박지욱
 *  @since 2009. 01. 19
 *  @version 1.0
 *  @see
 *
 */

public class Globals {
	//OS 유형
    public static final String OS_TYPE = EgovProperties.getProperty("Globals.OsType");
    //DB 유형
    public static final String DB_TYPE = EgovProperties.getProperty("Globals.DbType");
    //메인 페이지
    public static final String MAIN_PAGE = EgovProperties.getProperty("Globals.MainPage");
    
    //업무페이지 호출 
    public static final String EXTERMS_PAGE = EgovProperties.getProperty("Globals.ExTermsPage");
    
    //ShellFile 경로
    public static final String SHELL_FILE_PATH = EgovProperties.getPathProperty("Globals.ShellFilePath");
    //퍼로퍼티 파일 위치
    public static final String CONF_PATH = EgovProperties.getPathProperty("Globals.ConfPath");
    //Server정보 프로퍼티 위치
    public static final String SERVER_CONF_PATH = EgovProperties.getPathProperty("Globals.ServerConfPath");
    //Client정보 프로퍼티 위치
    public static final String CLIENT_CONF_PATH = EgovProperties.getPathProperty("Globals.ClientConfPath");
    //파일포맷 정보 프로퍼티 위치
    public static final String FILE_FORMAT_PATH = EgovProperties.getPathProperty("Globals.FileFormatPath");

    //파일 업로드 원 파일명
	public static final String ORIGIN_FILE_NM = "originalFileName";
	//파일 확장자
	public static final String FILE_EXT = "fileExtension";
	//파일크기
	public static final String FILE_SIZE = "fileSize";
	//업로드된 파일명
	public static final String UPLOAD_FILE_NM = "uploadFileName";
	//파일경로
	public static final String FILE_PATH = "filePath";

	//메일발송요청 XML파일경로
	public static final String MAIL_REQUEST_PATH = EgovProperties.getPathProperty("Globals.MailRequestPath");
	//메일발송응답 XML파일경로
	public static final String MAIL_RESPONSE_PATH = EgovProperties.getPathProperty("Globals.MailRResponsePath");

	// G4C 연결용 IP (localhost)
	public static final String LOCAL_IP = EgovProperties.getProperty("Globals.LocalIp"); 
	
//	// RdaReportService
//	public static final   String RDA_REPORT_SERVICE = EgovProperties.getProperty("Globals.RdaReportService"); 
//	//rda 파일경로 
//	public static final String RDA_SERVER_PATH = EgovProperties.getProperty("Globals.RdaServerPath"); 
//	//rda oracle server sid  
//	public static final String RDA_SERVER_SID = EgovProperties.getProperty("Globals.RdaServerSID"); 
//	// RexReportService
//	public static final   String REX_REPORT_SERVICE = EgovProperties.getProperty("Globals.RexReportService"); 
//	//Rex 파일경로 
//	public static final String REX_SERVER_PATH = EgovProperties.getProperty("Globals.RexServerPath"); 
//	//Rex oracle server sid  
//	public static final String REX_SERVER_SID = EgovProperties.getProperty("Globals.RexServerSID"); 
	//TraceUserActivity
	public static final String TRACE_USER_ACTIVITY = EgovProperties.getProperty("Globals.TraceUserActivity");  
//	//사진업로드 폴더  Globals.ExtermPhoto=/ExTermsFile/ExtermPhoto
//	public static final String EXTERM_PHOTO = EgovProperties.getProperty("Globals.ExTermPhoto"); 
//	//빈사진이미지폴더 및 파일경로 Globals.NonExtermPhoto=/ExTermsFile/ExtermPhoto/nonPhoto.jpg
//	public static final String NON_EXTERM_PHOTO = EgovProperties.getProperty("Globals.NonExTermPhoto"); 
//	//일반파일 업로드경로  Globals.ExtermUpload=/ExTermsFile/UploadFile
//	public static final String EXTERM_UPLOAD = EgovProperties.getProperty("Globals.ExTermUpload"); 
//    //Globals.fileStorePhotoPath 
//    public static final String FILE_STORE_PHOTO_PATH = EgovProperties.getProperty("Globals.fileStorePhotoPath"); 
//   //Globals.fileStorePath  
//    public static final String FILE_STORE_PATH = EgovProperties.getProperty("Globals.fileStorePath"); 
    //mypage url
 //   public static final String MY_URL_PAGE = EgovProperties.getProperty("Globals.MyUrlPage"); 
//    //사진이미지 url 경로 
//    public static final String EXTERM_MYPHOTO_URL = EgovProperties.getProperty("Globals.MyPhotoUrl"); 
//    //SSOUrlPage url 105.19.10.32
    public static final String EXTERM_SSO_LINK_PAGE = EgovProperties.getProperty("Globals.SSOLinkPage"); 
//    //xls template 설정 url 
//    public static final String  XLS_TEMPLATE_LINK = EgovProperties.getProperty("Globals.XLSTemplateLink"); 
//    //report  출력구분자 
//    public static final String  REPORT_DIVISION_TYPE = EgovProperties.getProperty("Globals.ReportDivisionType"); 
    
    //sso 사용여부 확인을 위한 설정값  SSOX, NONE 설정 
   // public static final String  GSSO_USE_TYPE = EgovProperties.getProperty("Globals.SsoUseType"); 

   //지자체업무시스템구분
	// public static final String  PAYGEN_MUNICIPALITIES_NAME = EgovProperties.getProperty("Globals.MunicipalitiesName");
	//지자체 코드 구분 
	public static final String DPOB_CODE = EgovProperties.getProperty("Globals.DpobCode");  
 
   
}
