/**
 * 공통화면 팝업 
 */
package com.app.exterms.payroll.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0220BM;
import com.app.exterms.payroll.client.dto.Payr0301BM;
import com.app.exterms.payroll.client.dto.Payr0304BM;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr0220Def  extends TableDef implements PayrDaoConstants {

    private int row = 0;
    private PayrConstants PayrLabel = PayrConstants.INSTANCE;

    
    public Payr0220Def(String chkDef){ 
    	 
    	if ("PAYR4100".equals(chkDef)) {
    		
    		setTitle(PayrLabel.titlePayr0220());
    	     setDaoClass("");
    	     setCustomListMethod(CLASS_PAYR0220_PAYR4100_DATA_LIST);
  	        setAutoFillGrid(false); 
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
	         
	        setColumnsDefinition(getPayr0220ToPayr4100());
    	} else {
    		
    		    setTitle(PayrLabel.titlePayr0220());
    	        setDaoClass(CLASS_PAYR0220_DATA_LIST);
    	        setCustomListMethod(CLASS_PAYR0220_DATA_LIST);
    	        setAutoFillGrid(false);
    	        setShowFilterToolbar(false);
    	       // setCustomListMethod(MSFConfiguration.CUSTOM_SERVICE_SKIP_CALL);
    	        setCheckBoxOnGridRows(true);
	         
	        setColumnsDefinition(getPayr0220Def());
	      
    	}  
    }
    public List<ColumnDef> getPayr0220Def(){
       

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0220BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Payr0220BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        
        
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분코드", Payr0304BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        
        /** column 고용구분 : emymtDivNm */
        listColumnDefs.add(new ColumnDef("고용구분", Payr0304BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
        
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("한글성명", Payr0304BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
        /** column 주민등록번호 : resnRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", Payr0304BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
        /** column 주민등록번호 : secRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", Payr0304BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING, 0, false, false, false){
        	{

        	}
        });
        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서코드", Payr0304BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 사업코드 : businCd */
        listColumnDefs.add(new ColumnDef("사업코드", Payr0304BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종코드", Payr0304BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 직종세구분코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세구분코드", Payr0304BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 직종세통합코드 : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세통합코드", Payr0304BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 80, true, false, true){
        	{

        	}
        });          
        /** column 부서 : deptNm */
        listColumnDefs.add(new ColumnDef("부서명", Payr0304BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{

        	}
        });
        /** column 사업 : businNm */
        listColumnDefs.add(new ColumnDef("사업명", Payr0304BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 직종 : typOccuNm */
        listColumnDefs.add(new ColumnDef("직종", Payr0304BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 직종세 : dtilOccuClsDivNm */
        listColumnDefs.add(new ColumnDef("직종세", Payr0304BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
         
        /** column 단위기관 : payrMangDeptCd */
        listColumnDefs.add(new ColumnDef("단위기관코드", Payr0301BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, false, false, true){
        	{

        	}
        });
        
        /** column 단위기관 : payrMangDept */
        listColumnDefs.add(new ColumnDef("단위기관", Payr0301BM.ATTR_PAYRMANGDEPTNM, ColumnDef.TYPE_STRING , 90, false, false, true){
        	{

        	}
        });
        
        /** column 가압류일련번호 : provAthmSeilNum */
        listColumnDefs.add(new ColumnDef("가압류일련번호", Payr0220BM.ATTR_PROVATHMSEILNUM, ColumnDef.TYPE_LONG, 90, false, false, true){
        	{

        	}
        });
        /** column 사건번호 : icntNum */
        listColumnDefs.add(new ColumnDef("사건번호", Payr0220BM.ATTR_ICNTNUM, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{

        	}
        });
        /** column 사건명 : icntNm */
        listColumnDefs.add(new ColumnDef("사건명", Payr0220BM.ATTR_ICNTNM, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{

        	}
        });
        /** column 채권자명 : cdtrNm */
        listColumnDefs.add(new ColumnDef("채권자명", Payr0220BM.ATTR_CDTRNM, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{

        	}
        });
        /** column 채권기관 : bondIstut */
        listColumnDefs.add(new ColumnDef("채권기관", Payr0220BM.ATTR_BONDISTUT, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{

        	}
        });
        /** column 은행코드 : bnkCd */
        listColumnDefs.add(new ColumnDef("은행코드", Payr0220BM.ATTR_BNKCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 은행 : bnkNm */
        listColumnDefs.add(new ColumnDef("은행", Payr0220BM.ATTR_BNKNM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 은행계좌번호 : bnkAccuNum */
        listColumnDefs.add(new ColumnDef("은행계좌번호", Payr0220BM.ATTR_BNKACCUNUM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 예금주명 : acntHodrNm */
        listColumnDefs.add(new ColumnDef("예금주명", Payr0220BM.ATTR_ACNTHODRNM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 접수일자 : rcptDt */
        listColumnDefs.add(new ColumnDef("접수일자", Payr0220BM.ATTR_RCPTDT, ColumnDef.TYPE_DATE, 90, true, true, true){
        	{

        	}
        });
        /** column 송달일자 : dlvyDt */
        listColumnDefs.add(new ColumnDef("송달일자", Payr0220BM.ATTR_DLVYDT, ColumnDef.TYPE_DATE, 90, false, false, true){
        	{

        	}
        });
        /** column 공제기간시작일자 : dducPridBgnnDt */
        listColumnDefs.add(new ColumnDef("시작일자", Payr0220BM.ATTR_DDUCPRIDBGNNDT, ColumnDef.TYPE_DATE, 90, true, true, true){
        	{

        	}
        });
        /** column 공제기간종료일자 : dducPridEndDt */
        listColumnDefs.add(new ColumnDef("종료일자", Payr0220BM.ATTR_DDUCPRIDENDDT, ColumnDef.TYPE_DATE, 90, true, true, true){
        	{

        	}
        });
        /** column 채권압류종료여부 : bondFrclrEndYn */
        listColumnDefs.add(new ColumnDef("압류종료", Payr0220BM.ATTR_BONDFRCLRENDYN, ColumnDef.TYPE_BOOLEAN, 50, true, false, true){
        	{

        	}
        });
        /** column 급여공제여부 : payDducYn */
        listColumnDefs.add(new ColumnDef("급여공제", Payr0220BM.ATTR_PAYDDUCYN, ColumnDef.TYPE_BOOLEAN, 50, true, true, true){
        	{

        	}
        });
        /** column 청구금액 : clmSum */
        listColumnDefs.add(new ColumnDef("청구금액", Payr0220BM.ATTR_CLMSUM, ColumnDef.TYPE_LONG, 90, true, true, true){
        	{

        	}
        });
        /** column 청구잔액 : clmBaln */
        listColumnDefs.add(new ColumnDef("청구잔액", Payr0220BM.ATTR_CLMBALN, ColumnDef.TYPE_LONG, 90, true, true, true){
        	{

        	}
        });
        /** column 채권압류제한금액 : bondFrclrLmtSum */
        listColumnDefs.add(new ColumnDef("제한금액", Payr0220BM.ATTR_BONDFRCLRLMTSUM, ColumnDef.TYPE_LONG, 90, true, true, true){
        	{

        	}
        });
        /** column 누적공제금액 : acmlteDducSum */
        listColumnDefs.add(new ColumnDef("누적공제금액", Payr0220BM.ATTR_ACMLTEDDUCSUM, ColumnDef.TYPE_LONG, 90, true, true, true){
        	{

        	}
        });
        /** column 공제금액 : dducSum */
        listColumnDefs.add(new ColumnDef("공제금액", Payr0220BM.ATTR_DDUCSUM, ColumnDef.TYPE_LONG, 90, true, true, true){
        	{

        	}
        });
        /** column 공제비율 : dducRto */
        listColumnDefs.add(new ColumnDef("공제비율", Payr0220BM.ATTR_DDUCRTO, ColumnDef.TYPE_DOUBLE, 90, false, false, true){
        	{

        	}
        });
        /** column 가압류비고내용 : provAthmNoteCtnt */
        listColumnDefs.add(new ColumnDef("가압류비고내용", Payr0220BM.ATTR_PROVATHMNOTECTNT, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
//        /** column 입력자 : kybdr */
//        listColumnDefs.add(new ColumnDef("입력자", Payr0220BM.ATTR_KYBDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력일자 : inptDt */
//        listColumnDefs.add(new ColumnDef("입력일자", Payr0220BM.ATTR_INPTDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력주소 : inptAddr */
//        listColumnDefs.add(new ColumnDef("입력주소", Payr0220BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정자 : ismt */
//        listColumnDefs.add(new ColumnDef("수정자", Payr0220BM.ATTR_ISMT, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정일자 : revnDt */
//        listColumnDefs.add(new ColumnDef("수정일자", Payr0220BM.ATTR_REVNDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정주소 : revnAddr */
//        listColumnDefs.add(new ColumnDef("수정주소", Payr0220BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        }); 

        
        return listColumnDefs;
    }
    
    public List<ColumnDef> getPayr0220ToPayr4100(){
        

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0220BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Payr0220BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        
        
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분코드", Payr0304BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        
        /** column 고용구분 : emymtDivNm */
        listColumnDefs.add(new ColumnDef("고용구분", Payr0304BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("성명", Payr0304BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 주민등록번호 : resnRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", Payr0304BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 주민등록번호 : secRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", Payr0304BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING, 0, false, false, false){
        	{

        	}
        });
        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서코드", Payr0304BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 사업코드 : businCd */
        listColumnDefs.add(new ColumnDef("사업코드", Payr0304BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종코드", Payr0304BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 직종세구분코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세구분코드", Payr0304BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        
        /** column 직종세통합코드 : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세통합코드", Payr0304BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 80, true, false, true){
        	{

        	}
        });          
        
        /** column 부서 : deptNm */
        listColumnDefs.add(new ColumnDef("부서명", Payr0304BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 사업 : businNm */
        listColumnDefs.add(new ColumnDef("사업명", Payr0304BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 직종 : typOccuNm */
        listColumnDefs.add(new ColumnDef("직종", Payr0304BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 직종세 : dtilOccuClsDivNm */
        listColumnDefs.add(new ColumnDef("직종세", Payr0304BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
         
        /** column 단위기관 : payrMangDeptCd */
        listColumnDefs.add(new ColumnDef("단위기관코드", Payr0301BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 단위기관 : payrMangDept */
        listColumnDefs.add(new ColumnDef("단위기관", Payr0301BM.ATTR_PAYRMANGDEPTNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 가압류일련번호 : provAthmSeilNum */
        listColumnDefs.add(new ColumnDef("번호", Payr0220BM.ATTR_PROVATHMSEILNUM, ColumnDef.TYPE_LONG, 40, true, true, true){
        	{

        	}
        });
        /** column 사건번호 : icntNum */
        listColumnDefs.add(new ColumnDef("사건번호", Payr0220BM.ATTR_ICNTNUM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
        /** column 사건명 : icntNm */
        listColumnDefs.add(new ColumnDef("사건명", Payr0220BM.ATTR_ICNTNM, ColumnDef.TYPE_STRING, 100, true, true, true){
        	{

        	}
        });
        /** column 채권자명 : cdtrNm */
        listColumnDefs.add(new ColumnDef("채권자명", Payr0220BM.ATTR_CDTRNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
        /** column 채권기관 : bondIstut */
        listColumnDefs.add(new ColumnDef("채권기관", Payr0220BM.ATTR_BONDISTUT, ColumnDef.TYPE_STRING, 120, true, true, true){
        	{

        	}
        });
        /** column 은행코드 : bnkCd */
        listColumnDefs.add(new ColumnDef("은행코드", Payr0220BM.ATTR_BNKCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 은행 : bnkNm */
        listColumnDefs.add(new ColumnDef("은행", Payr0220BM.ATTR_BNKNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
        /** column 은행계좌번호 : bnkAccuNum */
        listColumnDefs.add(new ColumnDef("은행계좌번호", Payr0220BM.ATTR_BNKACCUNUM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
        /** column 예금주명 : acntHodrNm */
        listColumnDefs.add(new ColumnDef("예금주명", Payr0220BM.ATTR_ACNTHODRNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
        /** column 접수일자 : rcptDt */
        listColumnDefs.add(new ColumnDef("접수일자", Payr0220BM.ATTR_RCPTDT, ColumnDef.TYPE_DATE, 90, true, true, true){
        	{

        	}
        });
        /** column 송달일자 : dlvyDt */
        listColumnDefs.add(new ColumnDef("송달일자", Payr0220BM.ATTR_DLVYDT, ColumnDef.TYPE_DATE, 90, true, false, true){
        	{

        	}
        });
        /** column 공제기간시작일자 : dducPridBgnnDt */
        listColumnDefs.add(new ColumnDef("시작일자", Payr0220BM.ATTR_DDUCPRIDBGNNDT, ColumnDef.TYPE_DATE, 90, true, true, true){
        	{

        	}
        });
        /** column 공제기간종료일자 : dducPridEndDt */
        listColumnDefs.add(new ColumnDef("종료일자", Payr0220BM.ATTR_DDUCPRIDENDDT, ColumnDef.TYPE_DATE, 90, true, true, true){
        	{

        	}
        });
        /** column 채권압류종료여부 : bondFrclrEndYn */
        listColumnDefs.add(new ColumnDef("압류종료", Payr0220BM.ATTR_BONDFRCLRENDYN, ColumnDef.TYPE_BOOLEAN, 60, true, true, true){
        	{

        	}
        });
        /** column 급여공제여부 : payDducYn */
        listColumnDefs.add(new ColumnDef("급여공제", Payr0220BM.ATTR_PAYDDUCYN, ColumnDef.TYPE_BOOLEAN, 60, true, true, true){
        	{

        	}
        });
        /** column 청구금액 : clmSum */
        listColumnDefs.add(new ColumnDef("청구금액", Payr0220BM.ATTR_CLMSUM, ColumnDef.TYPE_LONG, 90, true, true, true){
        	{

        	}
        });
        /** column 청구잔액 : clmBaln */
        listColumnDefs.add(new ColumnDef("청구잔액", Payr0220BM.ATTR_CLMBALN, ColumnDef.TYPE_LONG, 90, true, true, true){
        	{

        	}
        });
        /** column 채권압류제한금액 : bondFrclrLmtSum */
        listColumnDefs.add(new ColumnDef("제한금액", Payr0220BM.ATTR_BONDFRCLRLMTSUM, ColumnDef.TYPE_LONG, 90, true, true, true){
        	{

        	}
        });
        /** column 누적공제금액 : acmlteDducSum */
        listColumnDefs.add(new ColumnDef("누적공제금액", Payr0220BM.ATTR_ACMLTEDDUCSUM, ColumnDef.TYPE_LONG, 90, true, true, true){
        	{

        	}
        });
        /** column 공제금액 : dducSum */
        listColumnDefs.add(new ColumnDef("공제금액", Payr0220BM.ATTR_DDUCSUM, ColumnDef.TYPE_LONG, 90, true, true, true){
        	{

        	}
        });
        /** column 공제비율 : dducRto */
        listColumnDefs.add(new ColumnDef("공제비율", Payr0220BM.ATTR_DDUCRTO, ColumnDef.TYPE_DOUBLE, 90, true, true, true){
        	{

        	}
        });
        /** column 가압류비고내용 : provAthmNoteCtnt */
        listColumnDefs.add(new ColumnDef("가압류비고내용", Payr0220BM.ATTR_PROVATHMNOTECTNT, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
 
        
        return listColumnDefs;
    }
}
