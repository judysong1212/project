/**
 * 공통화면 팝업 
 */
package com.app.exterms.payroll.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0420BM;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr0420Def  extends TableDef implements PayrDaoConstants {

    private int row = 0;
    private PayrConstants PayrLabel = PayrConstants.INSTANCE;

    
    public Payr0420Def(String chkDef){ 
   	 
    	if ("LEFT".equals(chkDef)) {
    		
    	    setTitle(PayrLabel.titlePayr0420());
  	        setDaoClass("");
  	        setCustomListMethod(CLASS_PAYR0420_LEFT_DATA_LIST);
  	        setAutoFillGrid(false); 
	        setShowFilterToolbar(false);
	         
	        setColumnsDefinition(getPayr0420Left());
	        
    	} else if ("CENTER".equals(chkDef)) {
    		
    		 setTitle(PayrLabel.titlePayr0420());
   	        setDaoClass("");
   	        setCustomListMethod(CLASS_PAYR0420_CTR_DATA_LIST);
   	        setAutoFillGrid(false); 
 	        setShowFilterToolbar(false);
 	        setEditFieldGrid(true);
 	        setCheckBoxOnGridRows(true);
 	         
 	        setColumnsDefinition(getPayr0420Right());
    	}
    }
    
    
    public List<ColumnDef> getPayr0420Left(){
      
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0420BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 급여년도 : payYr */
        listColumnDefs.add(new ColumnDef("년도", Payr0420BM.ATTR_PAYYR, ColumnDef.TYPE_STRING, 50, true, true, true){
        	{

        	}
        });
        /** column 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
        listColumnDefs.add(new ColumnDef("직종등급맵핑일련번호", Payr0420BM.ATTR_TYPOCCUGRDEMPPGSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, false, false, true){
            {

            }
        });
        /** column 급여항목일련번호 : payrItemSeilNum */
        listColumnDefs.add(new ColumnDef("급여항목일련번호", Payr0420BM.ATTR_PAYRITEMSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, false, false, true){
            {

            }
        });
        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종코드", Payr0420BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 직종 : typOccuNm */
        listColumnDefs.add(new ColumnDef("직종", Payr0420BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{

        	}
        });
        /** column 호봉등급코드 : pyspGrdeCd */
        listColumnDefs.add(new ColumnDef("호봉등급코드", Payr0420BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
        /** column 호봉등급 : pyspGrdeNm */
        listColumnDefs.add(new ColumnDef("호봉등급", Payr0420BM.ATTR_PYSPGRDENM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        }); 
        
        /** column 직종세코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세코드", Payr0420BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
        
		/** column 직종세통합코드 : dtilOccuInttnCd */
		listColumnDefs.add(new ColumnDef("직종세통합코드", Payr0420BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
		{
		
		}
		});      

        /** column 직종세 : dtilOccuClsDivNm */
        listColumnDefs.add(new ColumnDef("직종세", Payr0420BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{

        	}
        });
         
        
        /** column 직종별급여산정기준일자 : occuClssPayCmpttnStd */
        listColumnDefs.add(new ColumnDef("산정일자", Payr0420BM.ATTR_OCCUCLSSPAYCMPTTNSTD, ColumnDef.TYPE_STRING, 80, false, true, true){
        	{

        	}
        });
       
        /** column 급여산식계산구분코드 : payArithExprCalcDivCd */
        listColumnDefs.add(new ColumnDef("급여산식계산구분코드", Payr0420BM.ATTR_PAYARITHEXPRCALCDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
         
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분코드", Payr0420BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** EMYMT_DIV_NM */
        listColumnDefs.add(new ColumnDef("고용구분", Payr0420BM.ATTR_EMYMTDIVNM,  ColumnDef.TYPE_STRING, 80, false, false, true){
            {
               
            }
        });
        
      

       return listColumnDefs;
        
        
    }
    
    public List<ColumnDef> getPayr0420Right(){
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0420BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 급여년도 : payYr */
        listColumnDefs.add(new ColumnDef("급여년도", Payr0420BM.ATTR_PAYYR, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
        listColumnDefs.add(new ColumnDef("직종등급맵핑일련번호", Payr0420BM.ATTR_TYPOCCUGRDEMPPGSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, false, false, true){
            {

            }
        });
        /** column 급여항목일련번호 : payrItemSeilNum */
        listColumnDefs.add(new ColumnDef("급여항목일련번호", Payr0420BM.ATTR_PAYRITEMSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, false, false, true){
            {

            }
        });
        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종코드", Payr0420BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 직종 : typOccuNm */
        listColumnDefs.add(new ColumnDef("직종", Payr0420BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 호봉등급코드 : pyspGrdeCd */
        listColumnDefs.add(new ColumnDef("호봉등급코드", Payr0420BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
        /** column 호봉등급 : pyspGrdeNm */
        listColumnDefs.add(new ColumnDef("호봉등급", Payr0420BM.ATTR_PYSPGRDENM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        }); 
        
        /** column 직종세코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세코드", Payr0420BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 직종세 : dtilOccuClsDivNm */
        listColumnDefs.add(new ColumnDef("직종세", Payr0420BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
		/** column 직종세통합코드 : dtilOccuInttnCd */
		listColumnDefs.add(new ColumnDef("직종세통합코드", Payr0420BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
		{
		
		}
		});   
        
        /** column 급여구분코드 : payCd */
        listColumnDefs.add(new ColumnDef("급여구분코드", Payr0420BM.ATTR_PAYCD, ColumnDef.TYPE_STRING, 90, false, false, true){
            {

            }
        });
        
        /** column 급여구분코드 : payNm */
        listColumnDefs.add(new ColumnDef("급여구분", Payr0420BM.ATTR_PAYNM, ColumnDef.TYPE_STRING, 90, false, true, true){
            {

            }
        });
        
        /** column 급여항목코드 : payItemCd */
        listColumnDefs.add(new ColumnDef("항목코드", Payr0420BM.ATTR_PAYITEMCD, ColumnDef.TYPE_STRING, 80, false, false, true){
        	{

        	}
        });
        /** column 급여항목 : payItemNm */
        listColumnDefs.add(new ColumnDef("급여항목", Payr0420BM.ATTR_PAYITEMNM, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{

        	}
        });
         
        
        /** column 직종별급여산정기준일자 : occuClssPayCmpttnStd */
        listColumnDefs.add(new ColumnDef("산정일자", Payr0420BM.ATTR_OCCUCLSSPAYCMPTTNSTD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
       
        /** column 급여산식계산구분코드 : payArithExprCalcDivCd */
        listColumnDefs.add(new ColumnDef("급여산식계산구분코드", Payr0420BM.ATTR_PAYARITHEXPRCALCDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
        /** column 산식계산구분 : payArithExprCalcDivNm */
        listColumnDefs.add(new ColumnDef("산식계산구분", Payr0420BM.ATTR_PAYARITHEXPRCALCDIVNM, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{

        	}
        });
        /** column 산식산정지급항목코드  : arithExprCmpttnPymtItemCd */
        listColumnDefs.add(new ColumnDef("산식산정지급항목코드", Payr0420BM.ATTR_ARITHEXPRCMPTTNPYMTITEMCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
        /** column 산식산정지급항목 : arithExprCmpttnPymtItemNm */
        listColumnDefs.add(new ColumnDef("산식지급항목", Payr0420BM.ATTR_ARITHEXPRCMPTTNPYMTITEMNM, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{

        	}
        });
        /** column 산식산정비율 : arithExprCmpttnRto */
        listColumnDefs.add(new ColumnDef("산식산정비율", Payr0420BM.ATTR_ARITHEXPRCMPTTNRTO, ColumnDef.TYPE_DOUBLE, 90, false, true, true){
        	{

        	}
        });
        /** column 산식산정금액 : arithExprCmpttnSum */
        listColumnDefs.add(new ColumnDef("산식산정금액", Payr0420BM.ATTR_ARITHEXPRCMPTTNSUM, ColumnDef.TYPE_LONG, 90, false, true, true){
        	{

        	}
        });
        /** column 통상임금여부 : usalyAmntYn */
        listColumnDefs.add(new ColumnDef("통상임금", Payr0420BM.ATTR_USALYAMNTYN, ColumnDef.TYPE_BOOLEAN, 90, false, false, true){
        	{

        	}
        });
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분코드", Payr0420BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** EMYMT_DIV_NM */
        listColumnDefs.add(new ColumnDef("고용구분", Payr0420BM.ATTR_EMYMTDIVNM,  ColumnDef.TYPE_STRING, 80, false, false, true){
            {
               
            }
        });
        
        /** column 산정기준비고내용 : cmpttnStdNoteCtnt */
        listColumnDefs.add(new ColumnDef("산정기준비고내용", Payr0420BM.ATTR_CMPTTNSTDNOTECTNT, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{

        	}
        });
    


       return listColumnDefs;
        
        
    }
}
