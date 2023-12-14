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
	
	// RdaReportService
	public static final String RDA_REPORT_SERVICE = EgovProperties.getProperty("Globals.RdaReportService"); 
	//rda 파일경로 
	public static final String RDA_SERVER_PATH = EgovProperties.getProperty("Globals.RdaServerPath"); 
	
	//rda oracle server sid  
	public static final String RDA_SERVER_SID = EgovProperties.getProperty("Globals.RdaServerSID"); 
	// RexReportService
	public static final String REX_REPORT_SERVICE = EgovProperties.getProperty("Globals.RexReportService"); 
	//Rex 파일경로 
	public static final String REX_SERVER_PATH = EgovProperties.getProperty("Globals.RexServerPath"); 
	//Rex oracle server sid  
	public static final String REX_SERVER_SID = EgovProperties.getProperty("Globals.RexServerSID"); 
	//Rex server url
	public static final String REX_SERVER_URL = EgovProperties.getProperty("Globals.RexServerUrl"); 
	
	//TraceUserActivity
//	public static final String TRACE_USER_ACTIVITY = EgovProperties.getProperty("Globals.TraceUserActivity");  

	//사진업로드 폴더  Globals.ExtermPhoto=/ExTermsFile/ExtermPhoto
	public static final String EXTERM_PHOTO = EgovProperties.getProperty("Globals.ExTermPhoto"); 
	//빈사진이미지폴더 및 파일경로 Globals.NonExtermPhoto=/ExTermsFile/ExtermPhoto/nonPhoto.jpg
	public static final String NON_EXTERM_PHOTO = EgovProperties.getProperty("Globals.NonExTermPhoto"); 
	//일반파일 업로드경로  Globals.ExtermUpload=/ExTermsFile/UploadFile
	public static final String EXTERM_UPLOAD = EgovProperties.getProperty("Globals.ExTermUpload"); 
	
	//직인 url 경로 
	public static final String EXTERM_MYPHOTO_URL = EgovProperties.getProperty("Globals.MyPhotoUrl");
	//Globals.fileStorePhotoPath 
    public static final String FILE_STORE_PHOTO_PATH = EgovProperties.getProperty("Globals.fileStorePhotoPath"); 

    //Globals.fileStorePath  
    public static final String FILE_STORE_PATH = EgovProperties.getProperty("Globals.fileStorePath"); 
	//report 경로 
	public static final String EXTERM_REPORT_PATH_URL = EgovProperties.getProperty("Globals.MyReportPathUrl"); 
	  
    //report  출력구분자 
    public static final String  REPORT_DIVISION_TYPE = EgovProperties.getProperty("Globals.ReportDivisionType"); 
    
    //sso 사용여부 확인을 위한 설정값  SSOX, NONE 설정 
    public static final String  GSSO_USE_TYPE = EgovProperties.getProperty("Globals.SsoUseType"); 
    
    //우편번호 서비스 승인키 
    public static final String  POSTSYSTEMKEY = EgovProperties.getProperty("Globals.PostSystemkey"); 
    
    //리포트 출력 모드 
    public static final String  REX_PRINT_MODE = EgovProperties.getProperty("PayGen.RexPrintMode"); 
    
    
    

    
///**------------------------------------------
//* 보안모듈적용방법 공통처리 부분 
//*------------------------------------------**/
//// 보안서버 타입(win64, UNIX) 
//public static final String  SECURITY_OSTYPE = EgovProperties.getProperty("Security.OsType"); 
//
//// 보안db정책서버 타입 
//public static final String  SECURITY_DBTYPE = EgovProperties.getProperty("Security.DbType"); 
// 
////보안적용 정책서버 설정 
// 
//public static final String  SECURITY_TABLENAME = EgovProperties.getProperty("Security.TableName"); 
// 
//public static final String  SECURITY_OWNER = EgovProperties.getProperty("Security.Owner"); 
//
////보안모듈적용여부 SEC / NONE
// 
//public static final String  SECURITY_ENCRYPTION = EgovProperties.getProperty("Security.Encryption"); 
//
////보안모듈적용방법 FAST_SYNC(신규적용),SYNC(이전적용)
// 
//public static final String  SECURITY_XDSPNATIVETYPE = EgovProperties.getProperty("Security.XdspNativeType"); 
//
///**------------------------------------------ 
//*보안모듈적용방법 FAST_SYNC(신규적용)인경우 이하셋팅
//*------------------------------------------**/ 
//public static final String  SECURITY_PROPERTIESFILE = EgovProperties.getProperty("Security.PropertiesFile"); 
//
//
///**------------------------------------------
//*보안모듈적용방법  SYNC(이전적용)인경우 이하셋팅
//*------------------------------------------**/
////정책서버 ID/PW설정
// 
//public static final String  SECURITY_SERVERHOSTNAME = EgovProperties.getProperty("Security.ServerHostName"); 
// 
//public static final String  SECURITY_SERVERPORT = EgovProperties.getProperty("Security.ServerPort"); 
// 
//public static final String  SECURITY_CONTIMEOUT = EgovProperties.getProperty("Security.ConTimeOut"); 
// 
//public static final String  SECURITY_USERNAME = EgovProperties.getProperty("Security.UserName"); 
// 
//public static final String  SECURITY_PASSWORD = EgovProperties.getProperty("Security.Password"); 
 
    
	 
}
