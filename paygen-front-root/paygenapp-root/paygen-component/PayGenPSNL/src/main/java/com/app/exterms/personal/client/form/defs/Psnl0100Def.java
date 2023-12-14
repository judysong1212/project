package com.app.exterms.personal.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.personal.client.dto.Psnl0100BM;
import com.app.exterms.personal.client.languages.PsnlConstants;
import com.app.exterms.personal.shared.PsnlDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Psnl0100Def  extends TableDef implements PsnlDaoConstants {

    private int row = 0;
    private PsnlConstants psnlLabel = PsnlConstants.INSTANCE;

    public Psnl0100Def(){
	        setTitle("");
	        setDaoClass("CLASS_PSNL0100_DATA_LIST");
	        setCustomListMethod(CLASS_PSNL0100_DATA_LIST);
	        setColumnsDefinition(getPsnl0100ToPsnl0250ColumnsList());
	        setAutoFillGrid(true);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
	        setEditFieldGrid(false);
	        
    
    }
    
    public Psnl0100Def(String flag){
    	
    	if("PSNLP020001".equals(flag)) {
    		
            setTitle("");
            setDaoClass("CLASS_PSNL0100_DATA_LIST");
            setCustomListMethod(CLASS_PSNL0100_DATA_LIST);
            setColumnsDefinition(getPsnl0100ToPsnl0250ColumnsList());
            setAutoFillGrid(true);
            setShowFilterToolbar(false);
            setCheckBoxOnGridRows(true);
            setEditFieldGrid(false);
            
    		
    	}

}

    private List<ColumnDef> getPsnl0100ToPsnl0250ColumnsList(){
        row = 0;
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("성명", Psnl0100BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 주민등록번호 : resnRegnNum */
        listColumnDefs.add(new ColumnDef("주민번호", Psnl0100BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 주민등록번호 : resnSecNum */
        listColumnDefs.add(new ColumnDef("주민번호", Psnl0100BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING , 100, false, false, false){
        	{

        	}
        });
        
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분", Psnl0100BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING , 120, true, true, true){
        	{

        	}
        });
        
        /** column 부서 : deptNm */
        listColumnDefs.add(new ColumnDef("부서", Psnl0100BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 250, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        /** column 직종 : typOccuNm */
        listColumnDefs.add(new ColumnDef("직종", Psnl0100BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 250, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
       
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Psnl0100BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Psnl0100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 영문성명 : engNm */
        listColumnDefs.add(new ColumnDef("영문성명", Psnl0100BM.ATTR_ENGNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 한문성명 : chinCharNm */
        listColumnDefs.add(new ColumnDef("한문성명", Psnl0100BM.ATTR_CHINCHARNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 성별구분코드 : sxDivCd */
        listColumnDefs.add(new ColumnDef("성별구분코드", Psnl0100BM.ATTR_SXDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 생년월일 : yoobhMnthDay */
        listColumnDefs.add(new ColumnDef("생년월일", Psnl0100BM.ATTR_YOOBHMNTHDAY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 음양구분코드 : sclcDivCd */
        listColumnDefs.add(new ColumnDef("음양구분코드", Psnl0100BM.ATTR_SCLCDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 국가코드 : natnCd */
        listColumnDefs.add(new ColumnDef("국가코드", Psnl0100BM.ATTR_NATNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서코드", Psnl0100BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업코드 : businCd */
        listColumnDefs.add(new ColumnDef("사업코드", Psnl0100BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 현소속부서코드 : currAffnDeptCd */
        listColumnDefs.add(new ColumnDef("현소속부서코드", Psnl0100BM.ATTR_CURRAFFNDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 담당업무구분코드 : repbtyBusinDivCd */
        listColumnDefs.add(new ColumnDef("담당업무구분코드", Psnl0100BM.ATTR_REPBTYBUSINDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종코드", Psnl0100BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직책코드 : odtyCd */
        listColumnDefs.add(new ColumnDef("직책코드", Psnl0100BM.ATTR_ODTYCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 최초고용일자 : frstEmymtDt */
        listColumnDefs.add(new ColumnDef("최초고용일자", Psnl0100BM.ATTR_FRSTEMYMTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분코드", Psnl0100BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 고용시작일자 : emymtBgnnDt */
        listColumnDefs.add(new ColumnDef("고용시작일자", Psnl0100BM.ATTR_EMYMTBGNNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 고용종료일자 : emymtEndDt */
        listColumnDefs.add(new ColumnDef("고용종료일자", Psnl0100BM.ATTR_EMYMTENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 호봉코드 : pyspCd */
        listColumnDefs.add(new ColumnDef("호봉코드", Psnl0100BM.ATTR_PYSPCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 재직상태코드 : hdofcCodtnCd */
        listColumnDefs.add(new ColumnDef("재직상태코드", Psnl0100BM.ATTR_HDOFCCODTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 퇴직일자 : retryDt */
        listColumnDefs.add(new ColumnDef("퇴직일자", Psnl0100BM.ATTR_RETRYDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 퇴직사유내용 : retryReasCtnt */
        listColumnDefs.add(new ColumnDef("퇴직사유내용", Psnl0100BM.ATTR_RETRYREASCTNT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 외국인구분코드 : frgnrDivCd */
        listColumnDefs.add(new ColumnDef("외국인구분코드", Psnl0100BM.ATTR_FRGNRDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 여권번호 : psptNum */
        listColumnDefs.add(new ColumnDef("여권번호", Psnl0100BM.ATTR_PSPTNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 체류시작일자 : styBgnnDt */
        listColumnDefs.add(new ColumnDef("체류시작일자", Psnl0100BM.ATTR_STYBGNNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 체류종료일자 : styEndDt */
        listColumnDefs.add(new ColumnDef("체류종료일자", Psnl0100BM.ATTR_STYENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 최종학교 : endSchl */
        listColumnDefs.add(new ColumnDef("최종학교", Psnl0100BM.ATTR_ENDSCHL, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 최종학위구분코드 : endDegrDivCd */
        listColumnDefs.add(new ColumnDef("최종학위구분코드", Psnl0100BM.ATTR_ENDDEGRDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 승진예정일자 : pmtnScduDt */
        listColumnDefs.add(new ColumnDef("승진예정일자", Psnl0100BM.ATTR_PMTNSCDUDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 호봉승급예정일자 : pyspPrmtnScduDt */
        listColumnDefs.add(new ColumnDef("호봉승급예정일자", Psnl0100BM.ATTR_PYSPPRMTNSCDUDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 재고용예정일자 : reymnScduDt */
        listColumnDefs.add(new ColumnDef("재고용예정일자", Psnl0100BM.ATTR_REYMNSCDUDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근속년수코드 : logSvcYrNumCd */
        listColumnDefs.add(new ColumnDef("근속년수코드", Psnl0100BM.ATTR_LOGSVCYRNUMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근속월수코드 : logSvcMnthIcmCd */
        listColumnDefs.add(new ColumnDef("근속월수코드", Psnl0100BM.ATTR_LOGSVCMNTHICMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 현_호봉발령일자 : currPyspAppmtDt */
        listColumnDefs.add(new ColumnDef("현_호봉발령일자", Psnl0100BM.ATTR_CURRPYSPAPPMTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 현_부서발령일자 : currDeptAppmtDt */
        listColumnDefs.add(new ColumnDef("현_부서발령일자", Psnl0100BM.ATTR_CURRDEPTAPPMTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 인사비고내용 : pernNoteCtnt */
        listColumnDefs.add(new ColumnDef("인사비고내용", Psnl0100BM.ATTR_PERNNOTECTNT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Psnl0100BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Psnl0100BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Psnl0100BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Psnl0100BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Psnl0100BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Psnl0100BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 호봉등급코드 : pyspGrdeCd */
        listColumnDefs.add(new ColumnDef("호봉등급코드", Psnl0100BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종세구분코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세구분코드", Psnl0100BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        return listColumnDefs;
    }
}