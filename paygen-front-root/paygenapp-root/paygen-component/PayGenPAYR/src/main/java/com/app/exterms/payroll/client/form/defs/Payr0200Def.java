/**
 * 공통화면 팝업 
 */
package com.app.exterms.payroll.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0200BM;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr0200Def  extends TableDef implements PayrDaoConstants {

    private int row = 0;
    private PayrConstants PayrLabel = PayrConstants.INSTANCE;
 

    public Payr0200Def(String chkDef){ 
     	 
    	if ("PAYR0200".equals(chkDef)) {
    		
    		 setTitle(PayrLabel.titlePayr0200());
    	     setDaoClass("");
    	     setCustomListMethod(CLASS_PAYR0200_DATA_LIST);
  	        setAutoFillGrid(false); 
	        setShowFilterToolbar(false);
	         
	        setColumnsDefinition(getPayr0200Def());
    	} else if ("DDUCDIVCD".equals(chkDef)) {
    		
    	    setTitle(PayrLabel.titlePayr0200());
  	        setDaoClass("");
  	        setCustomListMethod(CLASS_PAYR0200_PAYR3200_DATA_LIST);
  	        setAutoFillGrid(true); 
	        setShowFilterToolbar(false);
	         
	        setColumnsDefinition(getPayr0200ToPayr3200());
    	}  
    }
    
 public List<ColumnDef> getPayr0200ToPayr3200(){
	
	  List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
      
     /** column 사업장코드 : dpobCd */
     listColumnDefs.add(new ColumnDef("사업장코드", Payr0200BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, false, false, true){
     	{

     	}
     });
     
     /** column 공제구분코드 : dducDivCd */
     listColumnDefs.add(new ColumnDef("공제구분코드", Payr0200BM.ATTR_DDUCDIVCD, ColumnDef.TYPE_STRING, 90, false, true, true){
     	{

     	}
     });
     
     /** column 공제구분 : dducDivNm */
     listColumnDefs.add(new ColumnDef("공제구분", Payr0200BM.ATTR_DDUCDIVNM, ColumnDef.TYPE_STRING, 90, false, true, true){
     	{

     	}
     });
     
	  return listColumnDefs;
	  
 }
    public List<ColumnDef> getPayr0200Def(){
       
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0200BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Payr0200BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 공제구분코드 : dducDivCd */
        listColumnDefs.add(new ColumnDef("공제구분코드", Payr0200BM.ATTR_DDUCDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
        /** column 공제구분 : dducDivNm */
        listColumnDefs.add(new ColumnDef("공제구분", Payr0200BM.ATTR_DDUCDIVNM, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{

        	}
        });
        
        /** column null : dducSeilNum */
        listColumnDefs.add(new ColumnDef("일련번호", Payr0200BM.ATTR_DDUCSEILNUM, ColumnDef.TYPE_LONG, 90, false, false, true){
        	{

        	}
        });
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분코드", Payr0200BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("한글성명", Payr0200BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{

        	}
        });
        /** column 주민등록번호 : resnRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", Payr0200BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{

        	}
        });
        /** column 주민등록번호 : secRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", Payr0200BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING, 0, false, false, false){
        	{

        	}
        });
        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서코드", Payr0200BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 사업코드 : businCd */
        listColumnDefs.add(new ColumnDef("사업코드", Payr0200BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종코드", Payr0200BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 공제금액 : dducSum */
        listColumnDefs.add(new ColumnDef("공제금액", Payr0200BM.ATTR_DDUCSUM, ColumnDef.TYPE_LONG, 90, false, true, true){
        	{

        	}
        });
        /** column 공제비율구분코드 : dducRtoDivCd */
        listColumnDefs.add(new ColumnDef("공제비율구분코드", Payr0200BM.ATTR_DDUCRTODIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
        /** column 공제비율구분 : dducRtoDivNm */
        listColumnDefs.add(new ColumnDef("공제비율구분", Payr0200BM.ATTR_DDUCRTODIVNM, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{

        	}
        });
        
        /** column 공제비율 : dducRto */
        listColumnDefs.add(new ColumnDef("공제비율", Payr0200BM.ATTR_DDUCRTO, ColumnDef.TYPE_DOUBLE, 90, false, true, true){
        	{

        	}
        });
        /** column 기타공제시작일자 : etcDducBgnnDt */
        listColumnDefs.add(new ColumnDef("시작일자", Payr0200BM.ATTR_ETCDDUCBGNNDT, ColumnDef.TYPE_DATE, 90, false, true, true){
        	{

        	}
        });
        /** column 기타공제종료일자 : etcDducEndDt */
        listColumnDefs.add(new ColumnDef("종료일자", Payr0200BM.ATTR_ETCDDUCENDDT, ColumnDef.TYPE_DATE, 90, false, true, true){
        	{

        	}
        });
        /** column 삭제여부 : dducDelYn */
        listColumnDefs.add(new ColumnDef("삭제여부", Payr0200BM.ATTR_DDUCDELYN, ColumnDef.TYPE_BOOLEAN, 50, false, true, true){
            {

            }
        });
        /** column 기타공제비고내용 : etcDducNoteCtnt */
        listColumnDefs.add(new ColumnDef("비고내용", Payr0200BM.ATTR_ETCDDUCNOTECTNT, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{

        	}
        });
       
//        /** column 입력자 : kybdr */
//        listColumnDefs.add(new ColumnDef("입력자", Payr0200BM.ATTR_KYBDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력일자 : inptDt */
//        listColumnDefs.add(new ColumnDef("입력일자", Payr0200BM.ATTR_INPTDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력주소 : inptAddr */
//        listColumnDefs.add(new ColumnDef("입력주소", Payr0200BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정자 : ismt */
//        listColumnDefs.add(new ColumnDef("수정자", Payr0200BM.ATTR_ISMT, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정일자 : revnDt */
//        listColumnDefs.add(new ColumnDef("수정일자", Payr0200BM.ATTR_REVNDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정주소 : revnAddr */
//        listColumnDefs.add(new ColumnDef("수정주소", Payr0200BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//
//        private TextField<String> dpobCd   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> systemkey   /** column SYSTEMKEY : systemkey */
//
//        private TextField<String> dducDivCd   /** column 공제구분코드 : dducDivCd */
//
//        private TextField<String> dducSeilNum   /** column null : dducSeilNum */
//
//        private TextField<String> dducSum   /** column 공제금액 : dducSum */
//
//        private TextField<String> dducRtoDivCd   /** column 공제비율구분코드 : dducRtoDivCd */
//
//        private TextField<String> dducRto   /** column 공제비율 : dducRto */
//
//        private TextField<String> etcDducBgnnDt   /** column 기타공제시작일자 : etcDducBgnnDt */
//
//        private TextField<String> etcDducEndDt   /** column 기타공제종료일자 : etcDducEndDt */
//
//        private TextField<String> etcDducNoteCtnt   /** column 기타공제비고내용 : etcDducNoteCtnt */
//
//        private TextField<String> dducDelYn   /** column null : dducDelYn */
//
//        private TextField<String> kybdr   /** column 입력자 : kybdr */
//
//        private TextField<String> inptDt   /** column 입력일자 : inptDt */
//
//        private TextField<String> inptAddr   /** column 입력주소 : inptAddr */
//
//        private TextField<String> ismt   /** column 수정자 : ismt */
//
//        private TextField<String> revnDt   /** column 수정일자 : revnDt */
//
//        private TextField<String> revnAddr   /** column 수정주소 : revnAddr */

        return listColumnDefs;
    }
}
