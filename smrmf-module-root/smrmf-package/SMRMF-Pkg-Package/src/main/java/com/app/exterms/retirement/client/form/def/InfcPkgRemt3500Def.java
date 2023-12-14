/**
 * 공통화면 팝업 
 */
package com.app.exterms.retirement.client.form.def;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.retirement.client.dto.InfcPkgRemt3500BM;
import com.app.exterms.retirement.client.dto.InfcPkgRemt9000BM;
import com.app.exterms.retirement.shared.InfcPkgRemtDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.google.gwt.i18n.client.DateTimeFormat;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class InfcPkgRemt3500Def  extends TableDef implements InfcPkgRemtDaoConstants {

    private int row = 0;
   // private PayrConstants RemtLabel = PayrConstants.INSTANCE;
  
    public InfcPkgRemt3500Def(String chkDef){ 
          
      if ("PAYR4100".equals(chkDef)) { 
    	   setTitle("");
	        setDaoClass(CLASS_REMT3500_PAYR4100_DATA_LIST);
	        setCustomListMethod(CLASS_REMT3500_PAYR4100_DATA_LIST);
	        setAutoFillGrid(false);
	        setEditFieldGrid(true);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
        
            setColumnsDefinition(getRemt3500ToPayr4100());
        }  
    } 
    
    public List<ColumnDef> getRemt3500ToPayr4100(){
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
           
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", InfcPkgRemt3500BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
            {

            }
        });

        /** column 퇴직금정산관리번호 : sevePayClutMangeNum */
        listColumnDefs.add(new ColumnDef("관리번호", InfcPkgRemt9000BM.ATTR_SEVEPAYCLUTMANGENUM, ColumnDef.TYPE_STRING , 90, false, true, true){
            {
                setReadOnly(true);
            }
        });
        
        /** column 퇴직정산귀속년도 : calcSevePayPsnBlggYr */
        listColumnDefs.add(new ColumnDef("귀속년도", InfcPkgRemt3500BM.ATTR_CALCSEVEPAYPSNBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
            {

            }
        });
        /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
        listColumnDefs.add(new ColumnDef("퇴직정산구분코드", InfcPkgRemt3500BM.ATTR_CALCSEVEPAYPSNDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
            {

            }
        }); 
   
         
        
        /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
        listColumnDefs.add(new ColumnDef("정산구분", InfcPkgRemt3500BM.ATTR_CALCSEVEPAYPSNDIVNM, ColumnDef.TYPE_STRING , 90, false, true, true){
            {

            }
        });
        /** column 입사일자 : icncDt */
        listColumnDefs.add(new ColumnDef("입사일자", InfcPkgRemt9000BM.ATTR_ICNCDT, ColumnDef.TYPE_DATE , 90, false, false, true){
            {
                setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));   
            }
        });
        /** column 지급일자 : pymtDt */
        listColumnDefs.add(new ColumnDef("지급일자", InfcPkgRemt9000BM.ATTR_PYMTDT, ColumnDef.TYPE_DATE , 90, false, true, true){
            {
                setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));   
            }
        });
        
        /** column 기산일자 : rkfcdDt */
        listColumnDefs.add(new ColumnDef("기산일자", InfcPkgRemt9000BM.ATTR_RKFCDDT, ColumnDef.TYPE_DATE , 90, false, true, true){
            {
                setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));   
            }
        });
        /** column 퇴사일자 : rsgtnDt */
        listColumnDefs.add(new ColumnDef("퇴사일자", InfcPkgRemt9000BM.ATTR_RSGTNDT, ColumnDef.TYPE_DATE , 90, false, true, true){
            {
                setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));   
            }
        });
       
        /** column 제외월수_2012이전 : eepnMnthIcm2012Bfr */
        listColumnDefs.add(new ColumnDef("제외2012이전", InfcPkgRemt9000BM.ATTR_EEPNMNTHICM2012BFR, ColumnDef.TYPE_LONG , 90, false, false, true){
            {

            }
        });
        /** column 제외월수_2013이후 : eepnMnthIcm2013Aft */
        listColumnDefs.add(new ColumnDef("제외2013이후", InfcPkgRemt9000BM.ATTR_EEPNMNTHICM2013AFT, ColumnDef.TYPE_LONG , 90, false, false, true){
            {

            }
        });
        /** column 가산월수_2012이전 : addMnthIcm2012Bfr */
        listColumnDefs.add(new ColumnDef("가산2012이전", InfcPkgRemt9000BM.ATTR_ADDMNTHICM2012BFR, ColumnDef.TYPE_LONG , 90, false, false, true){
            {

            }
        });
        /** column 가산월수_2013이후 : addMnthIcm2013Aft */
        listColumnDefs.add(new ColumnDef("가산2013이후", InfcPkgRemt9000BM.ATTR_ADDMNTHICM2013AFT, ColumnDef.TYPE_LONG , 90, false, false, true){
            {

            }
        });
        
        /** column 퇴직금가산율 : sevePayAddRate */
        listColumnDefs.add(new ColumnDef("가산율", InfcPkgRemt9000BM.ATTR_SEVEPAYADDRATE, ColumnDef.TYPE_DOUBLE , 80, false, true, true){
            {

            }
        });
        
        /** column 퇴직급여액 : retryPayQnty */
        listColumnDefs.add(new ColumnDef("퇴직금액", InfcPkgRemt9000BM.ATTR_RETRYPAYQNTY, ColumnDef.TYPE_LONG , 90, false, true, true){
            {

            }
        });
        /** column 비과세퇴직급여액 : freeDtyRetryPayQnty */
        listColumnDefs.add(new ColumnDef("비과세", InfcPkgRemt9000BM.ATTR_FREEDTYRETRYPAYQNTY, ColumnDef.TYPE_LONG , 90, false, true, true){
            {

            }
        });
        /** column 기납부세액 : alpayTxAmnt */
        listColumnDefs.add(new ColumnDef("소득세", InfcPkgRemt9000BM.ATTR_ALPAYTXAMNT, ColumnDef.TYPE_LONG , 90, false, true, true){
            {

            }
        });
      
        
        /** column 지방소득세 : locIncmTxAmt */
        listColumnDefs.add(new ColumnDef("지방소득세", InfcPkgRemt9000BM.ATTR_LOCINCMTXAMT, ColumnDef.TYPE_LONG , 90, false, true, true){
        	{

        	}
        });
        /** column 차인지급액 : pernPymtSum */
        listColumnDefs.add(new ColumnDef("지급액", InfcPkgRemt9000BM.ATTR_PERNPYMTSUM, ColumnDef.TYPE_LONG , 90, false, true, true){
        	{

        	}
        });
        
        /** column 군경력정산포함여부 : amcrrClutInsnYn */
        listColumnDefs.add(new ColumnDef("군경력", InfcPkgRemt9000BM.ATTR_AMCRRCLUTINSNYN, ColumnDef.TYPE_BOOLEAN , 60, false, true, true){
        	{

        	}
        });
      
        /** column 퇴직금중간정산비고내용 : sevePayCtrClutNoteCtnt */
        listColumnDefs.add(new ColumnDef("비고내용", InfcPkgRemt9000BM.ATTR_SEVEPAYCTRCLUTNOTECTNT, ColumnDef.TYPE_STRING , 150, false, true, true){
            {
                setTypeTextField(ColumnDef.TEXTAREA); 
            }
        });
//        /** column 입력자 : kybdr */
//        listColumnDefs.add(new ColumnDef("입력자", InfcRemt3500BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//            {
//
//            }
//        });
//        /** column 입력일자 : inptDt */
//        listColumnDefs.add(new ColumnDef("입력일자", InfcRemt3500BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//            {
//
//            }
//        });
//        /** column 입력주소 : inptAddr */
//        listColumnDefs.add(new ColumnDef("입력주소", InfcRemt3500BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//            {
//
//            }
//        });
//        /** column 수정자 : ismt */
//        listColumnDefs.add(new ColumnDef("수정자", InfcRemt3500BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
//            {
//
//            }
//        });
//        /** column 수정일자 : revnDt */
//        listColumnDefs.add(new ColumnDef("수정일자", InfcRemt3500BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//            {
//
//            }
//        });
//        /** column 수정주소 : revnAddr */
//        listColumnDefs.add(new ColumnDef("수정주소", InfcRemt3500BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//            {
//
//            }
//        });
 
        
        return listColumnDefs;
    }
     
    
}
