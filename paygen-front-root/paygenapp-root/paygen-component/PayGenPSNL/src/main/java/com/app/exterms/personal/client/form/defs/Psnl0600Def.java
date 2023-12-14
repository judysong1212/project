package com.app.exterms.personal.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.personal.client.dto.Psnl0100BM;
import com.app.exterms.personal.client.dto.Psnl0112BM;
import com.app.exterms.personal.client.dto.Psnl0114BM;
import com.app.exterms.personal.client.dto.Psnl0116BM;
import com.app.exterms.personal.client.dto.Psnl0118BM;
import com.app.exterms.personal.client.dto.Psnl0119BM;
import com.app.exterms.personal.client.dto.Psnl0120BM;
import com.app.exterms.personal.client.dto.Psnl0121BM;
import com.app.exterms.personal.client.dto.Psnl0122BM;
import com.app.exterms.personal.client.dto.Psnl0123BM;
import com.app.exterms.personal.client.languages.PsnlConstants;
import com.app.exterms.personal.shared.PsnlDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Psnl0600Def  extends TableDef implements PsnlDaoConstants {

    private int row = 0;
    private PsnlConstants psnlLabel = PsnlConstants.INSTANCE;

    public Psnl0600Def(String chkDef){
    	if ("PSNL0600".equals(chkDef)) {						// 기본  	
	        setTitle("");
//	        setDaoClass("CLASS_PSNL0126_DATA_LIST");
	        setCustomListMethod(CLASS_PSNL0600_DATA_LIST);
	        
	        setAutoFillGrid(false);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
	        setEditFieldGrid(false);
//	        setCellModel(true);
	        setColumnsDefinition(getPsnl0100ToPsnl0600ColumnsList());  
	      
    	}else if ("PSNL0112".equals(chkDef)) {				// 병역
	        setTitle("");
//	        setDaoClass("CLASS_PSNL0126_DATA_LIST");
	        setCustomListMethod(CLASS_PSNL0600_TO_PSNL0112_DATA_LIST);
	        setColumnsDefinition(getPsnl0112ToPsnl0600ColumnsList());
	        setAutoFillGrid(false);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
	        setEditFieldGrid(false);
//	        setCellModel(true);
    	}else if ("PSNL0114".equals(chkDef)) {				// 단체
	        setTitle("");
//	        setDaoClass("CLASS_PSNL0126_DATA_LIST");
	        setCustomListMethod(CLASS_PSNL0600_TO_PSNL0114_DATA_LIST);
	        setColumnsDefinition(getPsnl0114ToPsnl0600ColumnsList());
	        setAutoFillGrid(false);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
	        setEditFieldGrid(false);
//	        setCellModel(true);
    	}else if ("PSNL0116".equals(chkDef)) {				// 학력
	        setTitle("");
//	        setDaoClass("CLASS_PSNL0126_DATA_LIST");
	        setCustomListMethod(CLASS_PSNL0600_TO_PSNL0116_DATA_LIST);
	        setColumnsDefinition(getPsnl0116ToPsnl0600ColumnsList());
	        setAutoFillGrid(false);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
	        setEditFieldGrid(false);
//	        setCellModel(true);
    	}else if ("PSNL0119".equals(chkDef)) {				// 경력
	        setTitle("");
//	        setDaoClass("CLASS_PSNL0126_DATA_LIST");
	        setCustomListMethod(CLASS_PSNL0600_TO_PSNL0119_DATA_LIST);
	        setColumnsDefinition(getPsnl0119ToPsnl0600ColumnsList());
	        setAutoFillGrid(false);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
	        setEditFieldGrid(false);
//	        setCellModel(true);
    	}else if ("PSNL0118".equals(chkDef)) {				// 자격
	        setTitle("");
//	        setDaoClass("CLASS_PSNL0126_DATA_LIST");
	        setCustomListMethod(CLASS_PSNL0600_TO_PSNL0118_DATA_LIST);
	        setColumnsDefinition(getPsnl0118ToPsnl0600ColumnsList());
	        setAutoFillGrid(false);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
	        setEditFieldGrid(false);
//	        setCellModel(true);
    	}else if ("PSNL0120".equals(chkDef)) {				// 교육
	        setTitle("");
//	        setDaoClass("CLASS_PSNL0126_DATA_LIST");
	        setCustomListMethod(CLASS_PSNL0600_TO_PSNL0120_DATA_LIST);
	        setColumnsDefinition(getPsnl0120ToPsnl0600ColumnsList());
	        setAutoFillGrid(false);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
	        setEditFieldGrid(false);
//	        setCellModel(true);
    	}else if ("PSNL0121".equals(chkDef)) {				// 포상
	        setTitle("");
//	        setDaoClass("CLASS_PSNL0126_DATA_LIST");
	        setCustomListMethod(CLASS_PSNL0600_TO_PSNL0121_DATA_LIST);
	        setColumnsDefinition(getPsnl0121ToPsnl0600ColumnsList());
	        setAutoFillGrid(false);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
	        setEditFieldGrid(false);
//	        setCellModel(true);
    	}else if ("PSNL0122".equals(chkDef)) {				// 징계
	        setTitle("");
//	        setDaoClass("CLASS_PSNL0126_DATA_LIST");
	        setCustomListMethod(CLASS_PSNL0600_TO_PSNL0122_DATA_LIST);
	        setColumnsDefinition(getPsnl0122ToPsnl0600ColumnsList());
	        setAutoFillGrid(false);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
	        setEditFieldGrid(false);
//	        setCellModel(true);
    	}else if ("PSNL0123".equals(chkDef)) {				// 휴직
	        setTitle("");
//	        setDaoClass("CLASS_PSNL0126_DATA_LIST");
	        setCustomListMethod(CLASS_PSNL0600_TO_PSNL0123_DATA_LIST);
	        setColumnsDefinition(getPsnl0123ToPsnl0600ColumnsList());
	        setAutoFillGrid(false);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
	        setEditFieldGrid(false);
//	        setCellModel(true);
    	}
//	        setTitle("");
//	        setDaoClass("CLASS_PSNL0100_DATA_LIST");
//	        setCustomListMethod(CLASS_PSNL0100_DATA_LIST);
//	        setColumnsDefinition(getPsnl0100ToPsnl0250ColumnsList());
//	        setAutoFillGrid(true);
//	        setShowFilterToolbar(false);
//	        setCheckBoxOnGridRows(true);
//	        setEditFieldGrid(false);
    
    }

    /** 기본 **/
    private List<ColumnDef> getPsnl0100ToPsnl0600ColumnsList(){
        row = 0;
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Psnl0100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        
        
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분", Psnl0100BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 부서 : currDeptNm */
        listColumnDefs.add(new ColumnDef("부 서", Psnl0100BM.ATTR_CURRDEPTNM, ColumnDef.TYPE_STRING, 110, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("성 명", Psnl0100BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        /** column 주민등록번호 : resnRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", Psnl0100BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        
        /** column 직종 : typOccuNm */
        listColumnDefs.add(new ColumnDef("직 종", Psnl0100BM.ATTR_TYPEOCCUNM, ColumnDef.TYPE_STRING, 100, true, true, true){
        	{
        		
        	}
        });
        
        
        /** column 직종세구분코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세구분", Psnl0100BM.ATTR_DTILOCCUINTTNNM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 사업코드 : businCd */
        listColumnDefs.add(new ColumnDef("사 업", Psnl0100BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING , 110, true, true, true){
        	{

        	}
        });
        
        /** column 재직상태코드 : hdofcCodtnCd */
        listColumnDefs.add(new ColumnDef("재직구분", Psnl0100BM.ATTR_HDOFCCODTNNM, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        /** column 최초고용일자 : frstEmymtDt */
        listColumnDefs.add(new ColumnDef("최초고용일자", Psnl0100BM.ATTR_FRSTEMYMTDT, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 현부서고용일자 : currDeptAppmtDt */
        listColumnDefs.add(new ColumnDef("현부서고용일자", Psnl0100BM.ATTR_CURRDEPTAPPMTDT, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 퇴직일자 : retryDt */
        listColumnDefs.add(new ColumnDef("퇴직일자", Psnl0100BM.ATTR_RETRYDT, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 근무년수 : logSvcYrNumNm */
        listColumnDefs.add(new ColumnDef("근무년수", Psnl0100BM.ATTR_LOGSVCYRNUMNM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 근무월 : logSvcMnthIcmNm */
        listColumnDefs.add(new ColumnDef("근무월", Psnl0100BM.ATTR_LOGSVCMNTHICMNM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        
        /** column 장애구분 : dabtyDivNm */
        listColumnDefs.add(new ColumnDef("장애구분", Psnl0100BM.ATTR_DABTYDIVNM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 도로명주소 : addr */
        listColumnDefs.add(new ColumnDef("도로명주소", Psnl0100BM.ATTR_ADDR, ColumnDef.TYPE_STRING , 300, true, true, true){
        	{

        	}
        });
        
		/** column 전화번호 : husPhnNum */
        listColumnDefs.add(new ColumnDef("전화번호", Psnl0100BM.ATTR_HUSPHNNUM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
		/** column 핸드폰 : cellPhneNum */
        listColumnDefs.add(new ColumnDef("전화번호", Psnl0100BM.ATTR_CELLPHNENUM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
		/** column 이메일 : emailAddr */
        listColumnDefs.add(new ColumnDef("이메일", Psnl0100BM.ATTR_EMAILADDR, ColumnDef.TYPE_STRING , 120, true, true, true){
        	{

        	}
        });
        
        /** column 인사비고내용 : pernNoteCtnt */
        listColumnDefs.add(new ColumnDef("인사비고내용", Psnl0100BM.ATTR_PERNNOTECTNT, ColumnDef.TYPE_STRING , 200, false, true, true){
        	{

        	}
        });
        
        return listColumnDefs;
    }
    
    /** 병역 **/
    private List<ColumnDef> getPsnl0112ToPsnl0600ColumnsList(){
        row = 0;
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Psnl0100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        
        
        /** column 부서 : currDeptNm */
        listColumnDefs.add(new ColumnDef("부 서", Psnl0100BM.ATTR_CURRDEPTNM, ColumnDef.TYPE_STRING, 110, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        /** column 관리부서 : deptNm */
        listColumnDefs.add(new ColumnDef("관리부서", Psnl0100BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 110, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분", Psnl0100BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("성 명", Psnl0100BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        /** column 직종 : typOccuNm */
        listColumnDefs.add(new ColumnDef("직 종", Psnl0100BM.ATTR_TYPEOCCUNM, ColumnDef.TYPE_STRING, 100, true, true, true){
        	{
        		
        	}
        });
        
        
        /** column 직종세구분코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세구분", Psnl0100BM.ATTR_DTILOCCUINTTNNM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 재직상태코드 : hdofcCodtnCd */
        listColumnDefs.add(new ColumnDef("재직구분", Psnl0100BM.ATTR_HDOFCCODTNNM, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        /** column 제대구분코드 : dsageDivCd */
        listColumnDefs.add(new ColumnDef("제대구분", Psnl0112BM.ATTR_DSAGEDIVCD, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 입대일자 : enrlntDt */
        listColumnDefs.add(new ColumnDef("입대일자", Psnl0112BM.ATTR_ENRLNTDT, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 제대일자 : dsageDt */
        listColumnDefs.add(new ColumnDef("제대일자", Psnl0112BM.ATTR_DSAGEDT, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 복무인정기간코드 : servcRcgtnPridCd */
        listColumnDefs.add(new ColumnDef("복무인정기간", Psnl0112BM.ATTR_SERVCRCGTNPRIDCD, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 역종코드 : srvssCd */
        listColumnDefs.add(new ColumnDef("역 종", Psnl0112BM.ATTR_SRVSSCD, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 군별코드 : baggrpCd */
        listColumnDefs.add(new ColumnDef("군 별", Psnl0112BM.ATTR_BAGGRPCD, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 병과코드 : abotsCd */
        listColumnDefs.add(new ColumnDef("병 과", Psnl0112BM.ATTR_ABOTSCD, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 계급코드 : clsCd */
        listColumnDefs.add(new ColumnDef("병 과", Psnl0112BM.ATTR_CLSCD, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });   
        
        
        /** column 군번 : mitySilnum */
        listColumnDefs.add(new ColumnDef("군 번", Psnl0112BM.ATTR_MITYSILNUM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });  
        
        /** column MOS : mos */
        listColumnDefs.add(new ColumnDef("MOS", Psnl0112BM.ATTR_MOS, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });   
        
        /** column 면제사유코드 : exmtnReasCd */
        listColumnDefs.add(new ColumnDef("면제사유", Psnl0112BM.ATTR_EXMTNREASCD, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });   
        
        return listColumnDefs;
        
    }
    
    /** 단체 **/
    private List<ColumnDef> getPsnl0114ToPsnl0600ColumnsList(){
        row = 0;
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Psnl0100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        
        
        /** column 부서 : currDeptNm */
        listColumnDefs.add(new ColumnDef("부 서", Psnl0100BM.ATTR_CURRDEPTNM, ColumnDef.TYPE_STRING, 110, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        /** column 관리부서 : deptNm */
        listColumnDefs.add(new ColumnDef("관리부서", Psnl0100BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 110, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분", Psnl0100BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        /** column 직종 : typOccuNm */
        listColumnDefs.add(new ColumnDef("직 종", Psnl0100BM.ATTR_TYPEOCCUNM, ColumnDef.TYPE_STRING, 100, true, true, true){
        	{
        		
        	}
        });
        
        
        /** column 직종세구분코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세구분", Psnl0100BM.ATTR_DTILOCCUINTTNNM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("성 명", Psnl0100BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        
        /** column 재직상태코드 : hdofcCodtnCd */
        listColumnDefs.add(new ColumnDef("재직구분", Psnl0100BM.ATTR_HDOFCCODTNNM, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        /** column  가입일자 : jnDt  */
        listColumnDefs.add(new ColumnDef("가입일자", Psnl0114BM.ATTR_JNDT, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column  가입단체명 : jnOpztnNm  */
        listColumnDefs.add(new ColumnDef("가입일자", Psnl0114BM.ATTR_JNOPZTNNM, ColumnDef.TYPE_STRING , 150, true, true, true){
        	{

        	}
        });
      
    	/** column 직책코드 : odtyCd */
        listColumnDefs.add(new ColumnDef("직 책", Psnl0100BM.ATTR_ODTYCD, ColumnDef.TYPE_STRING , 120, true, true, true){
        	{

        	}
        });   
        
        return listColumnDefs;
        
    }
    
    /** 학력 **/
    private List<ColumnDef> getPsnl0116ToPsnl0600ColumnsList(){
        row = 0;
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Psnl0100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        
        /** column 부서 : currDeptNm */
        listColumnDefs.add(new ColumnDef("부 서", Psnl0100BM.ATTR_CURRDEPTNM, ColumnDef.TYPE_STRING, 110, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        /** column 관리부서 : deptNm */
        listColumnDefs.add(new ColumnDef("관리부서", Psnl0100BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 110, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분", Psnl0100BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        /** column 직종 : typOccuNm */
        listColumnDefs.add(new ColumnDef("직 종", Psnl0100BM.ATTR_TYPEOCCUNM, ColumnDef.TYPE_STRING, 100, true, true, true){
        	{
        		
        	}
        });
        
        
        /** column 직종세구분코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세구분", Psnl0100BM.ATTR_DTILOCCUINTTNNM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("성 명", Psnl0100BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        
        /** column 재직상태코드 : hdofcCodtnCd */
        listColumnDefs.add(new ColumnDef("재직구분", Psnl0100BM.ATTR_HDOFCCODTNNM, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        /** column  입학일자 : etncItshlDt  */
        listColumnDefs.add(new ColumnDef("입학일자", Psnl0116BM.ATTR_ETNCITSHLDT, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column  졸업일자 : grdtnDt  */
        listColumnDefs.add(new ColumnDef("졸업일자", Psnl0116BM.ATTR_GRDTNDT, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column  학력구분코드 : acadAbtyDivCd  */
        listColumnDefs.add(new ColumnDef("학력구분", Psnl0116BM.ATTR_ACADABTYDIVCD, ColumnDef.TYPE_STRING , 120, true, true, true){
        	{

        	}
        });
        
        /** column  학교코드 : schlCd  */
        listColumnDefs.add(new ColumnDef("학교명", Psnl0116BM.ATTR_SCHLCD, ColumnDef.TYPE_STRING , 120, true, true, true){
        	{

        	}
        });
        
        /** column  학과코드 : deprMajrCd  */
        listColumnDefs.add(new ColumnDef("전공학과", Psnl0116BM.ATTR_DEPRMAJRCD, ColumnDef.TYPE_STRING , 120, true, true, true){
        	{

        	}
        });
        
        /** column  학위구분코드 : degrDivCd */
        listColumnDefs.add(new ColumnDef("학위", Psnl0116BM.ATTR_DEGRDIVCD, ColumnDef.TYPE_STRING , 120, true, true, true){
        	{

        	}
        });
        
        /** column  수업년수코드 : lesnYrNumCd */
        listColumnDefs.add(new ColumnDef("수업년수", Psnl0116BM.ATTR_LESNYRNUMCD, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 학력비고내용 : acadAbtyNoteCtnt */
        listColumnDefs.add(new ColumnDef("비 고", Psnl0116BM.ATTR_ACADABTYNOTECTNT, ColumnDef.TYPE_STRING , 150, true, true, true){
        	{

        	}
        });
        
        return listColumnDefs;
        
    }
    
    
    /** 경력 **/
    private List<ColumnDef> getPsnl0119ToPsnl0600ColumnsList(){
        row = 0;
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Psnl0100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        
        /** column 부서 : currDeptNm */
        listColumnDefs.add(new ColumnDef("부 서", Psnl0100BM.ATTR_CURRDEPTNM, ColumnDef.TYPE_STRING, 110, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        /** column 관리부서 : deptNm */
        listColumnDefs.add(new ColumnDef("관리부서", Psnl0100BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 110, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분", Psnl0100BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        /** column 직종 : typOccuNm */
        listColumnDefs.add(new ColumnDef("직 종", Psnl0100BM.ATTR_TYPEOCCUNM, ColumnDef.TYPE_STRING, 100, true, true, true){
        	{
        		
        	}
        });
        
        
        /** column 직종세구분코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세구분", Psnl0100BM.ATTR_DTILOCCUINTTNNM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("성 명", Psnl0100BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        
        /** column 재직상태코드 : hdofcCodtnCd */
        listColumnDefs.add(new ColumnDef("재직구분", Psnl0100BM.ATTR_HDOFCCODTNNM, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        /** column  경력시작일자 : carrBgnnDt  */
        listColumnDefs.add(new ColumnDef("근무시작일자", Psnl0119BM.ATTR_CARRBGNNDT, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column  경력종료일자 : carrEndDt  */
        listColumnDefs.add(new ColumnDef("근무종료일자", Psnl0119BM.ATTR_CARRENDDT, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column  근무처명 : paeWorkNm  */
        listColumnDefs.add(new ColumnDef("근무처", Psnl0119BM.ATTR_PAEWORKNM, ColumnDef.TYPE_STRING , 200, true, true, true){
        	{

        	}
        });
        
        
        /** column  직책명 : odtyNm   */
        listColumnDefs.add(new ColumnDef("직책명", Psnl0119BM.ATTR_ODTYNM, ColumnDef.TYPE_STRING , 120, true, true, true){
        	{

        	}
        });
        
        /** column  담당업무명 : repbtyBusinNm   */
        listColumnDefs.add(new ColumnDef("담당업무", Psnl0119BM.ATTR_REPBTYBUSINNM, ColumnDef.TYPE_STRING , 200, true, true, true){
        	{

        	}
        });
        
        /** column  경력비고내용 : carrNoteCtnt  */
        listColumnDefs.add(new ColumnDef("비고", Psnl0119BM.ATTR_CARRNOTECTNT, ColumnDef.TYPE_STRING , 150, true, true, true){
        	{

        	}
        });
        
        return listColumnDefs;
        
    }
    
    
    /** 자격 **/
    private List<ColumnDef> getPsnl0118ToPsnl0600ColumnsList(){
        row = 0;
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Psnl0100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        
        /** column 부서 : currDeptNm */
        listColumnDefs.add(new ColumnDef("부 서", Psnl0100BM.ATTR_CURRDEPTNM, ColumnDef.TYPE_STRING, 110, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        /** column 관리부서 : deptNm */
        listColumnDefs.add(new ColumnDef("관리부서", Psnl0100BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 110, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분", Psnl0100BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        /** column 직종 : typOccuNm */
        listColumnDefs.add(new ColumnDef("직 종", Psnl0100BM.ATTR_TYPEOCCUNM, ColumnDef.TYPE_STRING, 100, true, true, true){
        	{
        		
        	}
        });
        
        
        /** column 직종세구분코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세구분", Psnl0100BM.ATTR_DTILOCCUINTTNNM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("성 명", Psnl0100BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        
        /** column 재직상태코드 : hdofcCodtnCd */
        listColumnDefs.add(new ColumnDef("재직구분", Psnl0100BM.ATTR_HDOFCCODTNNM, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        
        /** column  취득일자 : aqtnDt   */
        listColumnDefs.add(new ColumnDef("취득일자", Psnl0118BM.ATTR_AQTNDT, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column  자격면허코드 : qftntLicnsCd   */
        listColumnDefs.add(new ColumnDef("자격면허코드", Psnl0118BM.ATTR_QFTNTLICNSCD, ColumnDef.TYPE_STRING , 150, true, true, true){
        	{

        	}
        });
        
        
        /** column  자격면허분야내용 : qftntLicnsPovncCtnt   */
        listColumnDefs.add(new ColumnDef("자격면허분야", Psnl0118BM.ATTR_QFTNTLICNSPOVNCCTNT, ColumnDef.TYPE_STRING , 200, true, true, true){
        	{

        	}
        });
        
        /** column  시행기관명 : efmnIstutNm   */
        listColumnDefs.add(new ColumnDef("시행기관", Psnl0118BM.ATTR_EFMNISTUTNM, ColumnDef.TYPE_STRING , 150, true, true, true){
        	{

        	}
        });
        
        /** column  자격면허번호 : qftntLicnsNum   */
        listColumnDefs.add(new ColumnDef("자격면허번호", Psnl0118BM.ATTR_QFTNTLICNSNUM, ColumnDef.TYPE_STRING , 150, true, true, true){
        	{

        	}
        });
        
        return listColumnDefs;
        
    }
    
    
    /** 교육 **/
    private List<ColumnDef> getPsnl0120ToPsnl0600ColumnsList(){
        row = 0;
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Psnl0100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        
        /** column 부서 : currDeptNm */
        listColumnDefs.add(new ColumnDef("부 서", Psnl0100BM.ATTR_CURRDEPTNM, ColumnDef.TYPE_STRING, 110, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        /** column 관리부서 : deptNm */
        listColumnDefs.add(new ColumnDef("관리부서", Psnl0100BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 110, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분", Psnl0100BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        /** column 직종 : typOccuNm */
        listColumnDefs.add(new ColumnDef("직 종", Psnl0100BM.ATTR_TYPEOCCUNM, ColumnDef.TYPE_STRING, 100, true, true, true){
        	{
        		
        	}
        });
        
        
        /** column 직종세구분코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세구분", Psnl0100BM.ATTR_DTILOCCUINTTNNM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("성 명", Psnl0100BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        
        /** column 재직상태코드 : hdofcCodtnCd */
        listColumnDefs.add(new ColumnDef("재직구분", Psnl0100BM.ATTR_HDOFCCODTNNM, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        
        /** column  교육시작일자 : eduBgnnDt   */
        listColumnDefs.add(new ColumnDef("자격면허번호", Psnl0120BM.ATTR_EDUBGNNDT, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column  교육시작일자 : eduBgnnDt   */
        listColumnDefs.add(new ColumnDef("교육시작일자", Psnl0120BM.ATTR_EDUBGNNDT, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column  교육종료일자 : eduEndDt   */
        listColumnDefs.add(new ColumnDef("교육종료일자", Psnl0120BM.ATTR_EDUENDDT, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column  교육이수시간 : eduCmpteTm  */
        listColumnDefs.add(new ColumnDef("이수시간", Psnl0120BM.ATTR_EDUCMPTETM, ColumnDef.TYPE_STRING , 120, true, true, true){
        	{

        	}
        });
        
        /** column  교육종류명 : eduKndNm  */
        listColumnDefs.add(new ColumnDef("교육종류", Psnl0120BM.ATTR_EDUKNDNM, ColumnDef.TYPE_STRING , 200, true, true, true){
        	{

        	}
        });
        
        /** column  교육기관명 : eduIstutNm  */
        listColumnDefs.add(new ColumnDef("교육기관", Psnl0120BM.ATTR_EDUISTUTNM, ColumnDef.TYPE_STRING , 200, true, true, true){
        	{

        	}
        });
        

        /** column  교육비고내용 : eduNoteCtnt   */
        listColumnDefs.add(new ColumnDef("비 고", Psnl0120BM.ATTR_EDUNOTECTNT, ColumnDef.TYPE_STRING , 200, true, true, true){
        	{

        	}
        });
        
        return listColumnDefs;
        
    }
    
    
    /** 포상 **/
    private List<ColumnDef> getPsnl0121ToPsnl0600ColumnsList(){
        row = 0;
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Psnl0100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        
        /** column 부서 : currDeptNm */
        listColumnDefs.add(new ColumnDef("부 서", Psnl0100BM.ATTR_CURRDEPTNM, ColumnDef.TYPE_STRING, 110, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        /** column 관리부서 : deptNm */
        listColumnDefs.add(new ColumnDef("관리부서", Psnl0100BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 110, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분", Psnl0100BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        /** column 직종 : typOccuNm */
        listColumnDefs.add(new ColumnDef("직 종", Psnl0100BM.ATTR_TYPEOCCUNM, ColumnDef.TYPE_STRING, 100, true, true, true){
        	{
        		
        	}
        });
        
        
        /** column 직종세구분코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세구분", Psnl0100BM.ATTR_DTILOCCUINTTNNM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("성 명", Psnl0100BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        
        /** column 재직상태코드 : hdofcCodtnCd */
        listColumnDefs.add(new ColumnDef("재직구분", Psnl0100BM.ATTR_HDOFCCODTNNM, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        

        /** column  포상년도 : accldYr   */
        listColumnDefs.add(new ColumnDef("포상년도", Psnl0121BM.ATTR_ACCLDYR, ColumnDef.TYPE_STRING , 60, true, true, true){
        	{

        	}
        });
        
        /** column 포상수여일자 : accldPrttDt r   */
        listColumnDefs.add(new ColumnDef("포상일자", Psnl0121BM.ATTR_ACCLDPRTTDT, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        /** column포상종류코드 : accldKndCd   */
        listColumnDefs.add(new ColumnDef("포상종류", Psnl0121BM.ATTR_ACCLDKNDCD, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        /** column 포상구분코드 : accldDivCd   */
        listColumnDefs.add(new ColumnDef("포상구분", Psnl0121BM.ATTR_ACCLDDIVCD, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        /** column  포상명 : accldNm   */
        listColumnDefs.add(new ColumnDef("포상명", Psnl0121BM.ATTR_ACCLDNM, ColumnDef.TYPE_STRING , 150, true, true, true){
        	{

        	}
        });
        
        /** column 포상서훈번호 : accldCfmntNum   */
        listColumnDefs.add(new ColumnDef("포상서훈번호", Psnl0121BM.ATTR_ACCLDCFMNTNUM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 시행기관명 : efmnIstutNm   */
        listColumnDefs.add(new ColumnDef("시행기관", Psnl0121BM.ATTR_EFMNISTUTNM, ColumnDef.TYPE_STRING , 150, true, true, true){
        	{

        	}
        });
        
        /** column 포상주체내용 : accldMnantCtnt   */
        listColumnDefs.add(new ColumnDef("포상주체", Psnl0121BM.ATTR_ACCLDMNANTCTNT, ColumnDef.TYPE_STRING , 150, true, true, true){
        	{

        	}
        });
        
        /** column 포상비고내용 : accldNoteCtnt  */
        listColumnDefs.add(new ColumnDef("비 고", Psnl0121BM.ATTR_ACCLDNOTECTNT, ColumnDef.TYPE_STRING , 150, true, true, true){
        	{

        	}
        });
        
        return listColumnDefs;
        
    }
    
    
    /** 징계 **/
    private List<ColumnDef> getPsnl0122ToPsnl0600ColumnsList(){
        row = 0;
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Psnl0100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        
        /** column 부서 : currDeptNm */
        listColumnDefs.add(new ColumnDef("부 서", Psnl0100BM.ATTR_CURRDEPTNM, ColumnDef.TYPE_STRING, 110, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        /** column 관리부서 : deptNm */
        listColumnDefs.add(new ColumnDef("관리부서", Psnl0100BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 110, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분", Psnl0100BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        /** column 직종 : typOccuNm */
        listColumnDefs.add(new ColumnDef("직 종", Psnl0100BM.ATTR_TYPEOCCUNM, ColumnDef.TYPE_STRING, 100, true, true, true){
        	{
        		
        	}
        });
        
        
        /** column 직종세구분코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세구분", Psnl0100BM.ATTR_DTILOCCUINTTNNM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("성 명", Psnl0100BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        /** column 재직상태코드 : hdofcCodtnCd */
        listColumnDefs.add(new ColumnDef("재직구분", Psnl0100BM.ATTR_HDOFCCODTNNM, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        
        /** column 징계처분일자 : dsnyActDsplDt    */
        listColumnDefs.add(new ColumnDef("징계처분일자", Psnl0122BM.ATTR_DSNYACTDSPLDT, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        /** column 징계구분코드 : dsnyActDivCd    */
        listColumnDefs.add(new ColumnDef("징계구분", Psnl0122BM.ATTR_DSNYACTDIVCD, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        /** column 징계명 : dsnyActNm    */
        listColumnDefs.add(new ColumnDef("징계명", Psnl0122BM.ATTR_DSNYACTNM, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        /** column 징계사유내용 : dsnyActReasCtnt    */
        listColumnDefs.add(new ColumnDef("징계사유", Psnl0122BM.ATTR_DSNYACTREASCTNT, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        /** column 징계수행기관 : dsnyActEctgOrgn    */
        listColumnDefs.add(new ColumnDef("시행기관", Psnl0122BM.ATTR_DSNYACTECTGORGN, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        /** column 징계시작일자 : dsnyActBgnnDt  */
        listColumnDefs.add(new ColumnDef("징계시작", Psnl0122BM.ATTR_DSNYACTBGNNDT, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        /** column 징계종료일자 : dsnyActEndDt  */
        listColumnDefs.add(new ColumnDef("징계종료일", Psnl0122BM.ATTR_DSNYACTENDDT, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        /** column 징계사면일자 : dsnyActAnstyDt  */
        listColumnDefs.add(new ColumnDef("징계사면일", Psnl0122BM.ATTR_DSNYACTANSTYDT, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        /** column 징계사면구분코드 : dsnyActAnstyDivCd  */
        listColumnDefs.add(new ColumnDef("사면구분", Psnl0122BM.ATTR_DSNYACTANSTYDIVCD, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 징계감봉월수 : dsnyActCtwpMnthIcm */
        listColumnDefs.add(new ColumnDef("감봉월수", Psnl0122BM.ATTR_DSNYACTCTWPMNTHICM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 징계비고내용 : dsnyActNoteCtnt */
        listColumnDefs.add(new ColumnDef("비 고", Psnl0122BM.ATTR_DSNYACTNOTECTNT, ColumnDef.TYPE_STRING , 150, true, true, true){
        	{

        	}
        });
        
        return listColumnDefs;
        
    }
    
    
    /** 휴직 **/
    private List<ColumnDef> getPsnl0123ToPsnl0600ColumnsList(){
        row = 0;
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Psnl0100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        
        /** column 부서 : currDeptNm */
        listColumnDefs.add(new ColumnDef("부 서", Psnl0100BM.ATTR_CURRDEPTNM, ColumnDef.TYPE_STRING, 110, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        /** column 관리부서 : deptNm */
        listColumnDefs.add(new ColumnDef("관리부서", Psnl0100BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 110, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분", Psnl0100BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        /** column 직종 : typOccuNm */
        listColumnDefs.add(new ColumnDef("직 종", Psnl0100BM.ATTR_TYPEOCCUNM, ColumnDef.TYPE_STRING, 100, true, true, true){
        	{
        		
        	}
        });
        
        
        /** column 직종세구분코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세구분", Psnl0100BM.ATTR_DTILOCCUINTTNNM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("성 명", Psnl0100BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        /** column 재직상태코드 : hdofcCodtnCd */
        listColumnDefs.add(new ColumnDef("재직구분", Psnl0100BM.ATTR_HDOFCCODTNNM, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        
        
        /** column 휴직구분코드 : levfAbncDivCd */
        listColumnDefs.add(new ColumnDef("휴직구분", Psnl0123BM.ATTR_LEVFABNCDIVCD, ColumnDef.TYPE_STRING , 120, true, true, true){
        	{

        	}
        });
        
        /** column 휴직시작일자 : levfAbncBgnnDt */
        listColumnDefs.add(new ColumnDef("시작일자", Psnl0123BM.ATTR_LEVFABNCBGNNDT, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 휴직종료일자 : levfAbncEndDt */
        listColumnDefs.add(new ColumnDef("종료일자", Psnl0123BM.ATTR_LEVFABNCENDDT, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 실제복직일자 : turtyRntmntDt */
        listColumnDefs.add(new ColumnDef("복직일자", Psnl0123BM.ATTR_TURTYRNTMNTDT, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 휴직비고내용 : levfAbncNoteCtnt */
        listColumnDefs.add(new ColumnDef("비 고", Psnl0123BM.ATTR_LEVFABNCNOTECTNT, ColumnDef.TYPE_STRING , 300, true, true, true){
        	{

        	}
        });
        
        return listColumnDefs;
    }
    
    
    
}