package com.app.smrmf.infc.sysif.msfpackage.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.languages.MSFConstants;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0150BM;
import com.app.smrmf.infc.sysif.msfpackage.shared.MSFPkgDaoConstants;

public class SysIfBass0150Def extends TableDef implements MSFPkgDaoConstants {
    private int row = 0;
    
    private MSFConstants lblSysIfConst = MSFConstants.INSTANCE;
    	
    public SysIfBass0150Def(String chkDef){
    
    	if("SYSM0600".equals(chkDef)){
    		 setTitle("단위기관정보");
            setDaoClass(""); 
            setCustomListMethod(PKG_SYSM0600TOBASS0150_LIST);
      	  	setAutoFillGrid(true);
            setShowFilterToolbar(false);   
            setCheckBoxOnGridRows(false); 
   	      	setEditFieldGrid(false);
   	      	setColumnsDefinition(getLeftBass0150ColumnsList()); 
    	} else {
    	  setTitle("");
         // setDaoClass(CLASS_SysIfBass0150_LIST); 
         // setCustomListMethod(CLASS_SysIfBass0150_LIST);
          
    	  setColumnsDefinition(getAllColumnsList());
          isAutoFillGrid = false;
    	  setAutoFillGrid(false);
          showFilterToolbar = false ; 
    	}  
    }
    

    private List<ColumnDef> getLeftBass0150ColumnsList(){
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", SysIfBass0150BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여관리부서코드 : payrMangDeptCd */
        listColumnDefs.add(new ColumnDef("단위기관코드", SysIfBass0150BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 급여관리부서명 : payMangeDeptNm */
        listColumnDefs.add(new ColumnDef("단위기관", SysIfBass0150BM.ATTR_PAYMANGEDEPTNM, ColumnDef.TYPE_STRING , 90, true,true, true){
        	{

        	}
        });
        /** column 대표자주민번호 : degtrResnRegnNum */
        listColumnDefs.add(new ColumnDef("대표자주민번호", SysIfBass0150BM.ATTR_DEGTRRESNREGNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 대표자명 : degtrNm */
        listColumnDefs.add(new ColumnDef("대표자명", SysIfBass0150BM.ATTR_DEGTRNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업자등록번호 : busoprRgstnNum */
        listColumnDefs.add(new ColumnDef("사업자등록번호", SysIfBass0150BM.ATTR_BUSOPRRGSTNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 법인등록번호 : corpRgstnNum */
        listColumnDefs.add(new ColumnDef("법인등록번호", SysIfBass0150BM.ATTR_CORPRGSTNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 법인구분코드 : corpDivCd */
        listColumnDefs.add(new ColumnDef("법인구분코드", SysIfBass0150BM.ATTR_CORPDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여관리부서우편번호 : payMangeDeptZpcd */
        listColumnDefs.add(new ColumnDef("급여관리부서우편번호", SysIfBass0150BM.ATTR_PAYMANGEDEPTZPCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여관리부서기본주소 : payMangeDeptFNdtnAddr */
        listColumnDefs.add(new ColumnDef("급여관리부서기본주소", SysIfBass0150BM.ATTR_PAYMANGEDEPTFNDTNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여관리부서상세주소 : payMangeDeptDtlPatrAddr */
        listColumnDefs.add(new ColumnDef("급여관리부서상세주소", SysIfBass0150BM.ATTR_PAYMANGEDEPTDTLPATRADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여관리부서전화번호 : payMangeDeptPhnNum */
        listColumnDefs.add(new ColumnDef("급여관리부서전화번호", SysIfBass0150BM.ATTR_PAYMANGEDEPTPHNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여관리부서팩스번호 : payMangeDeptFaxNum */
        listColumnDefs.add(new ColumnDef("급여관리부서팩스번호", SysIfBass0150BM.ATTR_PAYMANGEDEPTFAXNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여관리부서직인문구명 : payMangeDeptSealWrdNm */
        listColumnDefs.add(new ColumnDef("급여관리부서직인문구명", SysIfBass0150BM.ATTR_PAYMANGEDEPTSEALWRDNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여관리부서직인경로 : payMangeDeptSealRftaNm */
        listColumnDefs.add(new ColumnDef("급여관리부서직인경로", SysIfBass0150BM.ATTR_PAYMANGEDEPTSEALRFTANM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여관리부서직인파일명 : payMangeDeptSealFlNm */
        listColumnDefs.add(new ColumnDef("급여관리부서직인파일명", SysIfBass0150BM.ATTR_PAYMANGEDEPTSEALFLNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여관리부서총괄담당자 : payMangeDeptWhlePernChrg */
        listColumnDefs.add(new ColumnDef("아이디", SysIfBass0150BM.ATTR_PAYMANGEDEPTWHLEPERNCHRG, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여관리부서총괄담당자 : payMangeDeptWhlePernChrg */
        listColumnDefs.add(new ColumnDef("아이디", SysIfBass0150BM.ATTR_PAYMANGEDEPTWHLEPERNCHRG, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사용자성명 : usrNm */
    	listColumnDefs.add(new ColumnDef("성명", SysIfBass0150BM.ATTR_USRNM, ColumnDef.TYPE_STRING , 70, true, true, true){
    		{
    			setTypeTextField(ColumnDef.TEXTFIELD);
    		}
    	});
        /** column 급여관리부서분임지출관 : payMangeDeptDivTskOffr */
        listColumnDefs.add(new ColumnDef("급여관리부서분임지출관", SysIfBass0150BM.ATTR_PAYMANGEDEPTDIVTSKOFFR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여관리부서기본사용여부 : payMangeDeptFNdtnUseYn */
        listColumnDefs.add(new ColumnDef("사용", SysIfBass0150BM.ATTR_PAYMANGEDEPTFNDTNUSEYN, ColumnDef.TYPE_BOOLEAN , 90, true, true, true){
        	{

        	}
        });
       
        /** column 회계코드 : accCd */
        listColumnDefs.add(new ColumnDef("회계코드", SysIfBass0150BM.ATTR_ACCCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 건강보험기호 : hlthInsrSym */
        listColumnDefs.add(new ColumnDef("건강보험기호", SysIfBass0150BM.ATTR_HLTHINSRSYM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 국민연금기호 : natPennSym */
        listColumnDefs.add(new ColumnDef("국민연금기호", SysIfBass0150BM.ATTR_NATPENNSYM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 고용보험기호 : umytInsrSym */
        listColumnDefs.add(new ColumnDef("고용보험기호", SysIfBass0150BM.ATTR_UMYTINSRSYM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 징수의무자명 : cllnDebrNm */
        listColumnDefs.add(new ColumnDef("징수의무자명", SysIfBass0150BM.ATTR_CLLNDEBRNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 홈텍스ID : hmtxId */
        listColumnDefs.add(new ColumnDef("홈텍스ID", SysIfBass0150BM.ATTR_HMTXID, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세무서코드 : txOffcCd */
        listColumnDefs.add(new ColumnDef("세무서코드", SysIfBass0150BM.ATTR_TXOFFCCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 은행코드 : bnkCd */
        listColumnDefs.add(new ColumnDef("은행코드", SysIfBass0150BM.ATTR_BNKCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 지로이체코드 : groTnsrCd */
        listColumnDefs.add(new ColumnDef("지로이체코드", SysIfBass0150BM.ATTR_GROTNSRCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
//        /** column 입력자 : kybdr */
//        listColumnDefs.add(new ColumnDef("입력자", SysIfBass0150BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력일자 : inptDt */
//        listColumnDefs.add(new ColumnDef("입력일자", SysIfBass0150BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력주소 : inptAddr */
//        listColumnDefs.add(new ColumnDef("입력주소", SysIfBass0150BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정자 : ismt */
//        listColumnDefs.add(new ColumnDef("수정자", SysIfBass0150BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정일자 : revnDt */
//        listColumnDefs.add(new ColumnDef("수정일자", SysIfBass0150BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정주소 : revnAddr */
//        listColumnDefs.add(new ColumnDef("수정주소", SysIfBass0150BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
        /** column 건강보험영업소기호 : hlthInsrOfceSym */
        listColumnDefs.add(new ColumnDef("건강보험영업소기호", SysIfBass0150BM.ATTR_HLTHINSROFCESYM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 산재보험기호 : idtlAccdtInsurSym */
        listColumnDefs.add(new ColumnDef("산재보험기호", SysIfBass0150BM.ATTR_IDTLACCDTINSURSYM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
 

        return listColumnDefs;
    }
       
    private List<ColumnDef> getAllColumnsList(){
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", SysIfBass0150BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여관리부서코드 : payrMangDeptCd */
        listColumnDefs.add(new ColumnDef("급여관리부서코드", SysIfBass0150BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여관리부서명 : payMangeDeptNm */
        listColumnDefs.add(new ColumnDef("급여관리부서명", SysIfBass0150BM.ATTR_PAYMANGEDEPTNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 대표자주민번호 : degtrResnRegnNum */
        listColumnDefs.add(new ColumnDef("대표자주민번호", SysIfBass0150BM.ATTR_DEGTRRESNREGNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 대표자명 : degtrNm */
        listColumnDefs.add(new ColumnDef("대표자명", SysIfBass0150BM.ATTR_DEGTRNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업자등록번호 : busoprRgstnNum */
        listColumnDefs.add(new ColumnDef("사업자등록번호", SysIfBass0150BM.ATTR_BUSOPRRGSTNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 법인등록번호 : corpRgstnNum */
        listColumnDefs.add(new ColumnDef("법인등록번호", SysIfBass0150BM.ATTR_CORPRGSTNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 법인구분코드 : corpDivCd */
        listColumnDefs.add(new ColumnDef("법인구분코드", SysIfBass0150BM.ATTR_CORPDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여관리부서우편번호 : payMangeDeptZpcd */
        listColumnDefs.add(new ColumnDef("급여관리부서우편번호", SysIfBass0150BM.ATTR_PAYMANGEDEPTZPCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여관리부서기본주소 : payMangeDeptFNdtnAddr */
        listColumnDefs.add(new ColumnDef("급여관리부서기본주소", SysIfBass0150BM.ATTR_PAYMANGEDEPTFNDTNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여관리부서상세주소 : payMangeDeptDtlPatrAddr */
        listColumnDefs.add(new ColumnDef("급여관리부서상세주소", SysIfBass0150BM.ATTR_PAYMANGEDEPTDTLPATRADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여관리부서전화번호 : payMangeDeptPhnNum */
        listColumnDefs.add(new ColumnDef("급여관리부서전화번호", SysIfBass0150BM.ATTR_PAYMANGEDEPTPHNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여관리부서팩스번호 : payMangeDeptFaxNum */
        listColumnDefs.add(new ColumnDef("급여관리부서팩스번호", SysIfBass0150BM.ATTR_PAYMANGEDEPTFAXNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여관리부서직인문구명 : payMangeDeptSealWrdNm */
        listColumnDefs.add(new ColumnDef("급여관리부서직인문구명", SysIfBass0150BM.ATTR_PAYMANGEDEPTSEALWRDNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여관리부서직인경로 : payMangeDeptSealRftaNm */
        listColumnDefs.add(new ColumnDef("급여관리부서직인경로", SysIfBass0150BM.ATTR_PAYMANGEDEPTSEALRFTANM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여관리부서직인파일명 : payMangeDeptSealFlNm */
        listColumnDefs.add(new ColumnDef("급여관리부서직인파일명", SysIfBass0150BM.ATTR_PAYMANGEDEPTSEALFLNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여관리부서기본사용여부 : payMangeDeptFNdtnUseYn */
        listColumnDefs.add(new ColumnDef("급여관리부서기본사용여부", SysIfBass0150BM.ATTR_PAYMANGEDEPTFNDTNUSEYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여관리부서총괄담당자 : payMangeDeptWhlePernChrg */
        listColumnDefs.add(new ColumnDef("급여관리부서총괄담당자", SysIfBass0150BM.ATTR_PAYMANGEDEPTWHLEPERNCHRG, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여관리부서분임지출관 : payMangeDeptDivTskOffr */
        listColumnDefs.add(new ColumnDef("급여관리부서분임지출관", SysIfBass0150BM.ATTR_PAYMANGEDEPTDIVTSKOFFR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 회계코드 : accCd */
        listColumnDefs.add(new ColumnDef("회계코드", SysIfBass0150BM.ATTR_ACCCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 건강보험기호 : hlthInsrSym */
        listColumnDefs.add(new ColumnDef("건강보험기호", SysIfBass0150BM.ATTR_HLTHINSRSYM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 국민연금기호 : natPennSym */
        listColumnDefs.add(new ColumnDef("국민연금기호", SysIfBass0150BM.ATTR_NATPENNSYM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 고용보험기호 : umytInsrSym */
        listColumnDefs.add(new ColumnDef("고용보험기호", SysIfBass0150BM.ATTR_UMYTINSRSYM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 징수의무자명 : cllnDebrNm */
        listColumnDefs.add(new ColumnDef("징수의무자명", SysIfBass0150BM.ATTR_CLLNDEBRNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 홈텍스ID : hmtxId */
        listColumnDefs.add(new ColumnDef("홈텍스ID", SysIfBass0150BM.ATTR_HMTXID, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세무서코드 : txOffcCd */
        listColumnDefs.add(new ColumnDef("세무서코드", SysIfBass0150BM.ATTR_TXOFFCCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 은행코드 : bnkCd */
        listColumnDefs.add(new ColumnDef("은행코드", SysIfBass0150BM.ATTR_BNKCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 지로이체코드 : groTnsrCd */
        listColumnDefs.add(new ColumnDef("지로이체코드", SysIfBass0150BM.ATTR_GROTNSRCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
//        /** column 입력자 : kybdr */
//        listColumnDefs.add(new ColumnDef("입력자", SysIfBass0150BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력일자 : inptDt */
//        listColumnDefs.add(new ColumnDef("입력일자", SysIfBass0150BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력주소 : inptAddr */
//        listColumnDefs.add(new ColumnDef("입력주소", SysIfBass0150BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정자 : ismt */
//        listColumnDefs.add(new ColumnDef("수정자", SysIfBass0150BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정일자 : revnDt */
//        listColumnDefs.add(new ColumnDef("수정일자", SysIfBass0150BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정주소 : revnAddr */
//        listColumnDefs.add(new ColumnDef("수정주소", SysIfBass0150BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
        /** column 건강보험영업소기호 : hlthInsrOfceSym */
        listColumnDefs.add(new ColumnDef("건강보험영업소기호", SysIfBass0150BM.ATTR_HLTHINSROFCESYM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 산재보험기호 : idtlAccdtInsurSym */
        listColumnDefs.add(new ColumnDef("산재보험기호", SysIfBass0150BM.ATTR_IDTLACCDTINSURSYM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> payrMangDeptCd;   /** column 급여관리부서코드 : payrMangDeptCd */
//
//        private TextField<String> payMangeDeptNm;   /** column 급여관리부서명 : payMangeDeptNm */
//
//        private TextField<String> degtrResnRegnNum;   /** column 대표자주민번호 : degtrResnRegnNum */
//
//        private TextField<String> degtrNm;   /** column 대표자명 : degtrNm */
//
//        private TextField<String> busoprRgstnNum;   /** column 사업자등록번호 : busoprRgstnNum */
//
//        private TextField<String> corpRgstnNum;   /** column 법인등록번호 : corpRgstnNum */
//
//        private TextField<String> corpDivCd;   /** column 법인구분코드 : corpDivCd */
//
//        private TextField<String> payMangeDeptZpcd;   /** column 급여관리부서우편번호 : payMangeDeptZpcd */
//
//        private TextField<String> payMangeDeptFNdtnAddr;   /** column 급여관리부서기본주소 : payMangeDeptFNdtnAddr */
//
//        private TextField<String> payMangeDeptDtlPatrAddr;   /** column 급여관리부서상세주소 : payMangeDeptDtlPatrAddr */
//
//        private TextField<String> payMangeDeptPhnNum;   /** column 급여관리부서전화번호 : payMangeDeptPhnNum */
//
//        private TextField<String> payMangeDeptFaxNum;   /** column 급여관리부서팩스번호 : payMangeDeptFaxNum */
//
//        private TextField<String> payMangeDeptSealWrdNm;   /** column 급여관리부서직인문구명 : payMangeDeptSealWrdNm */
//
//        private TextField<String> payMangeDeptSealRftaNm;   /** column 급여관리부서직인경로 : payMangeDeptSealRftaNm */
//
//        private TextField<String> payMangeDeptSealFlNm;   /** column 급여관리부서직인파일명 : payMangeDeptSealFlNm */
//
//        private TextField<String> payMangeDeptFNdtnUseYn;   /** column 급여관리부서기본사용여부 : payMangeDeptFNdtnUseYn */
//
//        private TextField<String> payMangeDeptWhlePernChrg;   /** column 급여관리부서총괄담당자 : payMangeDeptWhlePernChrg */
//
//        private TextField<String> payMangeDeptDivTskOffr;   /** column 급여관리부서분임지출관 : payMangeDeptDivTskOffr */
//
//        private TextField<String> accCd;   /** column 회계코드 : accCd */
//
//        private TextField<String> hlthInsrSym;   /** column 건강보험기호 : hlthInsrSym */
//
//        private TextField<String> natPennSym;   /** column 국민연금기호 : natPennSym */
//
//        private TextField<String> umytInsrSym;   /** column 고용보험기호 : umytInsrSym */
//
//        private TextField<String> cllnDebrNm;   /** column 징수의무자명 : cllnDebrNm */
//
//        private TextField<String> hmtxId;   /** column 홈텍스ID : hmtxId */
//
//        private TextField<String> txOffcCd;   /** column 세무서코드 : txOffcCd */
//
//        private TextField<String> bnkCd;   /** column 은행코드 : bnkCd */
//
//        private TextField<String> groTnsrCd;   /** column 지로이체코드 : groTnsrCd */
//
//        private TextField<String> kybdr;   /** column 입력자 : kybdr */
//
//        private TextField<String> inptDt;   /** column 입력일자 : inptDt */
//
//        private TextField<String> inptAddr;   /** column 입력주소 : inptAddr */
//
//        private TextField<String> ismt;   /** column 수정자 : ismt */
//
//        private TextField<String> revnDt;   /** column 수정일자 : revnDt */
//
//        private TextField<String> revnAddr;   /** column 수정주소 : revnAddr */
//
//        private TextField<String> hlthInsrOfceSym;   /** column 건강보험영업소기호 : hlthInsrOfceSym */
//
//        private TextField<String> idtlAccdtInsurSym;   /** column 산재보험기호 : idtlAccdtInsurSym */
      

        return listColumnDefs;
    }
}
