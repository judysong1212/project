/**
 * 공통화면 팝업 
 */
package com.app.exterms.payroll.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0440BM;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr0440Def  extends TableDef implements PayrDaoConstants {

    private int row = 0;
    private PayrConstants PayrLabel = PayrConstants.INSTANCE;

    final PrgmComBass0300DTO sysComBass0300Dto;
 
         
    public Payr0440Def(String chkDef){ 
      	 
        sysComBass0300Dto = new PrgmComBass0300DTO(); 
        
    	if ("PAYR5100".equals(chkDef)) {
    		
    	    setTitle(PayrLabel.titlePayr0440());
  	        setDaoClass(CLASS_PAYR0440_PAYR5100_DATA_LIST);
  	        setCustomListMethod(CLASS_PAYR0440_PAYR5100_DATA_LIST);
  	        setAutoFillGrid(false); 
	        setShowFilterToolbar(false);
	         
	        setColumnsDefinition(getPayr0440ToPayr5100());
    	} else if ("PAYR5200".equals(chkDef)) {
    		
    	    setTitle(PayrLabel.titlePayr0440());
  	        setDaoClass(CLASS_PAYR0440_PAYR5200_DATA_LIST);
  	        setCustomListMethod(CLASS_PAYR0440_PAYR5200_DATA_LIST);
  	        setAutoFillGrid(false); 
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
	         
	        setColumnsDefinition(getPayr0440ToPayr5200());
    	} else {
    		
    		setTitle(PayrLabel.titlePayr0440());
    	    setDaoClass(CLASS_PAYR0440_DATA_LIST);
    	    setCustomListMethod(CLASS_PAYR0440_DATA_LIST);
   	        setAutoFillGrid(false); 
 	        setShowFilterToolbar(false);
 	        setEditFieldGrid(true);
 	         
 	        setColumnsDefinition(getPayr0440());
    	}
    }
    

    public List<ColumnDef> getPayr0440ToPayr5200(){
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0440BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
        /** column 급여년도 : payYr */
        listColumnDefs.add(new ColumnDef("년도", Payr0440BM.ATTR_PAYYR, ColumnDef.TYPE_STRING, 40, true, true, true){
        	{

        	}
        });
        /** column 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
        listColumnDefs.add(new ColumnDef("직종등급맵핑일련번호", Payr0440BM.ATTR_TYPOCCUGRDEMPPGSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
            {

            }
        });
        /** column 급여항목일련번호 : payrItemSeilNum */
        listColumnDefs.add(new ColumnDef("급여항목일련번호", Payr0440BM.ATTR_PAYRITEMSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
            {

            }
        });
        /** column 호봉근속년수코드 : pyspLogSvcYrNumCd */
        listColumnDefs.add(new ColumnDef("근속년수코드", Payr0440BM.ATTR_PYSPLOGSVCYRNUMCD, ColumnDef.TYPE_STRING, 70, false, false, true){
            {

            }
        });
        /** column 호봉근속년수 : pyspLogSvcYrNumNm */
        listColumnDefs.add(new ColumnDef("근속년수", Payr0440BM.ATTR_PYSPLOGSVCYRNUMNM, ColumnDef.TYPE_STRING, 60, true, true, true){
            {

            }
        });
        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종코드", Payr0440BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 직종 : typOccuNm */
        listColumnDefs.add(new ColumnDef("직종", Payr0440BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 100, false, true, true){
        	{

        	}
        });
        

        /** column 호봉등급코드 : pyspGrdeCd */
        listColumnDefs.add(new ColumnDef("호봉등급코드", Payr0440BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
        /** column 호봉등급 : pyspGrdeNm */
        listColumnDefs.add(new ColumnDef("호봉등급", Payr0440BM.ATTR_PYSPGRDENM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        }); 
        /** column 직종세코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세코드", Payr0440BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
        
		/** column 직종세통합코드 : dtilOccuInttnCd */
		listColumnDefs.add(new ColumnDef("직종세통합코드", Payr0440BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
		{
		
		}
		});               
        
        /** column 직종세 : dtilOccuClsDivNm */
        listColumnDefs.add(new ColumnDef("직종세", Payr0440BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{

        	}
        });
        
       
        
        /** column 단위기관코드 : payrMangDeptCd */
        listColumnDefs.add(new ColumnDef("단위기관코드", Payr0440BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
        /** column 단위기관 : payrMangDeptNm */
        listColumnDefs.add(new ColumnDef("단위기관", Payr0440BM.ATTR_PAYRMANGDEPTNM, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{

        	}
        });

        
        /** column 직종별급여산정기준일자 : occuClssPayCmpttnStd */
        listColumnDefs.add(new ColumnDef("산정일자", Payr0440BM.ATTR_OCCUCLSSPAYCMPTTNSTD, ColumnDef.TYPE_DATE, 90, false, false, false){
            {

            }
        });


        return listColumnDefs;
    }
    
    public List<ColumnDef> getPayr0440(){
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0440BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
        /** column 급여년도 : payYr */
        listColumnDefs.add(new ColumnDef("급여년도", Payr0440BM.ATTR_PAYYR, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
        listColumnDefs.add(new ColumnDef("직종등급맵핑일련번호", Payr0440BM.ATTR_TYPOCCUGRDEMPPGSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
            {

            }
        });
        /** column 급여항목일련번호 : payrItemSeilNum */
        listColumnDefs.add(new ColumnDef("급여항목일련번호", Payr0440BM.ATTR_PAYRITEMSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
            {

            }
        });
        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종코드", Payr0440BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 직종 : typOccuNm */
        listColumnDefs.add(new ColumnDef("직종", Payr0440BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        sysComBass0300Dto.setRpsttvCd("A007"); 
        /** column 호봉근속년수코드 : pyspLogSvcYrNumCd */
        listColumnDefs.add(new ColumnListDef("근속년수", Payr0440BM.ATTR_PYSPLOGSVCYRNUMCD, ColumnDef.TYPE_STRING, 60, true, true, false,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
            {
                setReadOnly(true);
            }
        });
        /** column 호봉근속년수 : pyspLogSvcYrNumNm */
        listColumnDefs.add(new ColumnDef("근속년수", Payr0440BM.ATTR_PYSPLOGSVCYRNUMNM, ColumnDef.TYPE_STRING, 70, false, false, true){
            {

            }
        });
        sysComBass0300Dto.setRpsttvCd("B015"); 
        /** column 급여구분코드 : payCd */
        listColumnDefs.add(new ColumnListDef("급여구분", Payr0440BM.ATTR_PAYCD, ColumnDef.TYPE_STRING , 90, true, true, false,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
            {
                setReadOnly(true);
            }
        });
       
        /** column 급여구분 : payNm */
        listColumnDefs.add(new ColumnDef("급여구분", Payr0440BM.ATTR_PAYNM, ColumnDef.TYPE_STRING, 80, false, false, true){
        	{

        	}
        });
        
     
        /** column 호봉등급코드 : pyspGrdeCd */
        listColumnDefs.add(new ColumnDef("호봉등급코드", Payr0440BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
        /** column 호봉등급 : pyspGrdeNm */
        listColumnDefs.add(new ColumnDef("호봉등급", Payr0440BM.ATTR_PYSPGRDENM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        }); 
        /** column 급여항목코드 : payItemCd */
        listColumnDefs.add(new ColumnDef("급여항목코드", Payr0440BM.ATTR_PAYITEMCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 급여항목 : payItemNm */
        listColumnDefs.add(new ColumnDef("급여항목", Payr0440BM.ATTR_PAYITEMNM, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{
        	   setReadOnly(true);
        	}
        });
        

        /** column 단위기관코드 : payrMangDeptCd */
        listColumnDefs.add(new ColumnDef("단위기관코드", Payr0440BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
        /** column 단위기관 : payrMangDeptNm */
        listColumnDefs.add(new ColumnDef("단위기관", Payr0440BM.ATTR_PAYRMANGDEPTNM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 직종세코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세", Payr0440BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
        /** column 직종세통합코드 : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세통합코드", Payr0440BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });  
        
        /** column 직종세 : dtilOccuClsDivNm */
        listColumnDefs.add(new ColumnDef("직종세", Payr0440BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
       
        /** column 직종별급여산정기준일자 : occuClssPayCmpttnStd */
        listColumnDefs.add(new ColumnDef("산정일자", Payr0440BM.ATTR_OCCUCLSSPAYCMPTTNSTD, ColumnDef.TYPE_DATE, 90, false, false, true){
        	{ 
        	    setFormatDate(MSFMainApp.MSFCONSTANTS.DateFormat());
        	}
        });
        /** column 단가금액 : ucstSum */
        listColumnDefs.add(new ColumnDef("단가금액", Payr0440BM.ATTR_UCSTSUM, ColumnDef.TYPE_LONG, 90, true, true, true){
        	{

        	}
        });
     
        /** column 단가금액02 : ucstSum02 */
        listColumnDefs.add(new ColumnDef("단가금액02", Payr0440BM.ATTR_UCSTSUM02, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        
        /** column 급여적용시점일자 : payrIntoDt */
        listColumnDefs.add(new ColumnDef("급여적용시점일자", Payr0440BM.ATTR_PAYRINTODT, ColumnDef.TYPE_STRING , 90, true, false, false){
        	{

        	}
        });
        
        /** column 급여항목구간기준일자 : payrItemTrmStdDt */
        listColumnDefs.add(new ColumnDef("급여항목구간기준일자", Payr0440BM.ATTR_PAYRITEMTRMSTDDT, ColumnDef.TYPE_STRING , 90, true, false, false){
        	{

        	}
        });

        sysComBass0300Dto.setRpsttvCd("B018"); 
        /** column 단가계산구분코드 : ucstCalcDivCd */
        listColumnDefs.add(new ColumnListDef("단가계산", Payr0440BM.ATTR_UCSTCALCDIVCD, ColumnDef.TYPE_STRING, 90, false, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{
        	    setReadOnly(true);
        	}
        });
        /** column 단가계산구분 : ucstCalcDivNm */
        listColumnDefs.add(new ColumnDef("단가계산구분", Payr0440BM.ATTR_UCSTCALCDIVNM, ColumnDef.TYPE_STRING, 80, false, false, true){
        	{

        	}
        });
        /** column 단가출력순서 : ucstPrntOrd */
        listColumnDefs.add(new ColumnDef("순서", Payr0440BM.ATTR_UCSTPRNTORD, ColumnDef.TYPE_LONG, 50, true, true, true){
        	{

        	}
        });
        /** column 단가표시작일자 : ucstDgmBgnnDt */
        listColumnDefs.add(new ColumnDef("시작일자", Payr0440BM.ATTR_UCSTDGMBGNNDT, ColumnDef.TYPE_DATE, 90, true, true, true){
        	{

        	}
        });
        /** column 단가표종료일자 : ucstDgmEndDt */
        listColumnDefs.add(new ColumnDef("종료일자", Payr0440BM.ATTR_UCSTDGMENDDT, ColumnDef.TYPE_DATE, 90, true, true, true){
        	{

        	}
        });
        /** column 단가표사용여부 : ucstDgmUseYn */
        listColumnDefs.add(new ColumnDef("사용", Payr0440BM.ATTR_UCSTDGMUSEYN, ColumnDef.TYPE_BOOLEAN, 90, true, true, true){
        	{

        	}
        });
        /** column 단가비고내용 : ucstNoteCtnt */
        listColumnDefs.add(new ColumnDef("단가비고내용", Payr0440BM.ATTR_UCSTNOTECTNT, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{

        	}
        });
        

        return listColumnDefs;
    }
    
  public List<ColumnDef> getPayr0440ToPayr5100(){
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0440BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
        /** column 급여년도 : payYr */
        listColumnDefs.add(new ColumnDef("년도", Payr0440BM.ATTR_PAYYR, ColumnDef.TYPE_STRING, 40, true, true, true){
        	{

        	}
        });
        /** column 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
        listColumnDefs.add(new ColumnDef("직종등급맵핑일련번호", Payr0440BM.ATTR_TYPOCCUGRDEMPPGSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
            {

            }
        });
        /** column 급여항목일련번호 : payrItemSeilNum */
        listColumnDefs.add(new ColumnDef("급여항목일련번호", Payr0440BM.ATTR_PAYRITEMSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
            {

            }
        });
        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종코드", Payr0440BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 직종 : typOccuNm */
        listColumnDefs.add(new ColumnDef("직종", Payr0440BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{

        	}
        });
        /** column 급여구분코드 : payCd */
        listColumnDefs.add(new ColumnDef("급여구분코드", Payr0440BM.ATTR_PAYCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 급여구분코드 : payNm */
        listColumnDefs.add(new ColumnDef("급여구분", Payr0440BM.ATTR_PAYNM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
        /** column 호봉근속년수코드 : pyspLogSvcYrNumCd */
        listColumnDefs.add(new ColumnDef("호봉근속년수코드", Payr0440BM.ATTR_PYSPLOGSVCYRNUMCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 호봉근속년수 : pyspLogSvcYrNumNm */
        listColumnDefs.add(new ColumnDef("근속년수", Payr0440BM.ATTR_PYSPLOGSVCYRNUMNM, ColumnDef.TYPE_STRING, 80, true, true, true){
        	{

        	}
        });
        /** column 호봉등급코드 : pyspGrdeCd */
        listColumnDefs.add(new ColumnDef("호봉등급코드", Payr0440BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        
        /** column 호봉등급 : pyspGrdeNm */
        listColumnDefs.add(new ColumnDef("호봉등급", Payr0440BM.ATTR_PYSPGRDENM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        }); 
        /** column 급여항목코드 : payItemCd */
        listColumnDefs.add(new ColumnDef("급여항목코드", Payr0440BM.ATTR_PAYITEMCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 급여항목 : payItemNm */
        listColumnDefs.add(new ColumnDef("급여항목", Payr0440BM.ATTR_PAYITEMNM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
       

        /** column 단위기관코드 : payrMangDeptCd */
        listColumnDefs.add(new ColumnDef("단위기관", Payr0440BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        
        /** column 단위기관 : payrMangDeptNm */
        listColumnDefs.add(new ColumnDef("단위기관", Payr0440BM.ATTR_PAYRMANGDEPTNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
        /** column 직종세코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세코드", Payr0440BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
        
		/** column 직종세통합코드 : dtilOccuInttnCd */
		listColumnDefs.add(new ColumnDef("직종세통합코드", Payr0440BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
		{
		
		}
		});                                           

        
        /** column 직종세 : dtilOccuClsDivNm */
        listColumnDefs.add(new ColumnDef("직종세", Payr0440BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{

        	}
        });
        
       
        /** column 직종별급여산정기준일자 : occuClssPayCmpttnStd */
        listColumnDefs.add(new ColumnDef("산정일자", Payr0440BM.ATTR_OCCUCLSSPAYCMPTTNSTD, ColumnDef.TYPE_DATE, 90, false, false, true){
        	{

        	}
        });
        /** column 단가금액 : ucstSum */
        listColumnDefs.add(new ColumnDef("단가금액", Payr0440BM.ATTR_UCSTSUM, ColumnDef.TYPE_LONG, 90, true,true , true){
        	{

        	}
        });
        /** column 단가금액02 : ucstSum02 */
        listColumnDefs.add(new ColumnDef("단가금액02", Payr0440BM.ATTR_UCSTSUM02, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
        	{

        	}
        });
        
        /** column 급여적용시점일자 : payrIntoDt */
        listColumnDefs.add(new ColumnDef("급여적용시점일자", Payr0440BM.ATTR_PAYRINTODT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 급여항목구간기준일자 : payrItemTrmStdDt */
        listColumnDefs.add(new ColumnDef("급여항목구간기준일자", Payr0440BM.ATTR_PAYRITEMTRMSTDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단가계산구분코드 : ucstCalcDivCd */
        listColumnDefs.add(new ColumnDef("단가계산구분코드", Payr0440BM.ATTR_UCSTCALCDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 단가계산구분 : ucstCalcDivNm */
        listColumnDefs.add(new ColumnDef("단가계산구분", Payr0440BM.ATTR_UCSTCALCDIVNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
        /** column 단가출력순서 : ucstPrntOrd */
        listColumnDefs.add(new ColumnDef("단가출력순서", Payr0440BM.ATTR_UCSTPRNTORD, ColumnDef.TYPE_LONG, 90, true, false, true){
        	{

        	}
        });
        /** column 단가표시작일자 : ucstDgmBgnnDt */
        listColumnDefs.add(new ColumnDef("단가표시작일자", Payr0440BM.ATTR_UCSTDGMBGNNDT, ColumnDef.TYPE_DATE, 90, true, false, true){
        	{

        	}
        });
        /** column 단가표종료일자 : ucstDgmEndDt */
        listColumnDefs.add(new ColumnDef("단가표종료일자", Payr0440BM.ATTR_UCSTDGMENDDT, ColumnDef.TYPE_DATE, 90, true, false, true){
        	{

        	}
        });
        /** column 단가표사용여부 : ucstDgmUseYn */
        listColumnDefs.add(new ColumnDef("사용", Payr0440BM.ATTR_UCSTDGMUSEYN, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
        	{

        	}
        });
        /** column 단가비고내용 : ucstNoteCtnt */
        listColumnDefs.add(new ColumnDef("단가비고내용", Payr0440BM.ATTR_UCSTNOTECTNT, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
       
 
        
         return listColumnDefs;
    }
}
