/**
 * 공통화면 팝업 
 */
package com.app.exterms.payroll.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0300BM;
import com.app.exterms.payroll.client.dto.Payr0301BM;
import com.app.exterms.payroll.client.dto.Payr0302BM;
import com.app.exterms.payroll.client.dto.Payr0304BM;
import com.app.exterms.payroll.client.dto.Payr0307BM;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr0304Def  extends TableDef implements PayrDaoConstants {

    private int row = 0;
    private PayrConstants PayrLabel = PayrConstants.INSTANCE;

    

    public Payr0304Def(String chkPayrDef){
    	 setTitle(PayrLabel.titlePayr0304());
       
        
        if ("".equals(chkPayrDef)) { 
        	
        	 setDaoClass(CLASS_PAYR0304_DATA_LIST);
             setCustomListMethod(CLASS_PAYR0304_DATA_LIST);
             setAutoFillGrid(false);
             setShowFilterToolbar(false);
            // setCustomListMethod(MSFConfiguration.CUSTOM_SERVICE_SKIP_CALL);
             setCheckBoxOnGridRows(true); 

             setColumnsDefinition(getPayr0304Def());
         
       } else if ("PAYR4200".equals(chkPayrDef)) {  
          	
          setDaoClass("");
          setCustomListMethod(CLASS_PAYR0304TOPAYR4200_DATA_LIST);
          setAutoFillGrid(false);
          setShowFilterToolbar(false); 
          
          setCheckBoxOnGridRows(true); 

          setColumnsDefinition(getPayr0304ToPayr4420ColumnsList());
          
      } else if ("PAYR4201".equals(chkPayrDef)) {  //급여내역조회를 다시 추가함 6.17 -"61"
        	
        setDaoClass("");
        setCustomListMethod(CLASS_PAYR0304TOPAYR4201_DATA_LIST); //수정 6.18 -"81"
        setAutoFillGrid(false);
        setShowFilterToolbar(false); 
        
        setCheckBoxOnGridRows(true); 

        setColumnsDefinition(getPayr0304ToPayr4201ColumnsList());
       
       //일괄정리 주석처리 6.22 -"131"
      } /*else if ("PAYR4201Del".equals(chkPayrDef)) {  //일괄정리 추가5 6.19 -"124"
      	
      setDaoClass("");
      setCustomListMethod(CLASS_PAYR0304TOPAYR4201_DEL_DATA_LIST); 
      setAutoFillGrid(false);
      setShowFilterToolbar(false); 
      
      setCheckBoxOnGridRows(true); 

      setColumnsDefinition(getPayr0304ToPayr4201DelColumnsList()); 
      
      }*/ else if ("PAYRP410001".equals(chkPayrDef)) {  
        	
        setDaoClass("");
        setCustomListMethod(CLASS_PAYR0304TOP410001_DATA_LIST);
        setAutoFillGrid(false);
        setShowFilterToolbar(false);  

        setColumnsDefinition(getPayr0304ToPayrP410001ColumnsList());
        
    }  else if ("PAYRP410002".equals(chkPayrDef)) {  
    	
	    setDaoClass("");
	    setCustomListMethod(CLASS_PAYR0304TOP410002_DATA_LIST);
	    setAutoFillGrid(true);
	    setShowFilterToolbar(false);  
	    setCheckBoxOnGridRows(true);
			setColumnsDefinition(getPayr0304ToPayrP410002ColumnsList());

		}

	}
    

    
    //일괄정리 추가6 6.19 -"125"
    //일괄정리 주석처리 6.22 -"134"
    /*private List<ColumnDef> getPayr0304ToPayr4201DelColumnsList(){
    	row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        //** column 사업장코드 : dpobCd ㅇ*//*
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0300BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, true, false, true){
            {

            }
        });
        
        //** column 고용구분코드 : emymtDivCd ㅇ*//*
        listColumnDefs.add(new ColumnDef("고용구분코드", Payr0304BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
        //** column 고용구분 : emymtDivNm *//*
        listColumnDefs.add(new ColumnDef("고용구분", Payr0304BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
        //** column 부서코드 : deptCd ㅇ*//*
        listColumnDefs.add(new ColumnDef("부서코드", Payr0304BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 120, false, false, true){
        	{

        	}
        });
        
        //** column 부서 : deptNm *//*
        listColumnDefs.add(new ColumnDef("부서명", Payr0304BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
        
        //** column 한글성명 : hanNm ㅇ*//*
        listColumnDefs.add(new ColumnDef("성명", Payr0304BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 60, true, true, true){
        	{

        	}
        });
        
        //** column 주민등록번호 : resnRegnNum ㅇ*//*
        listColumnDefs.add(new ColumnDef("주민등록번호", Payr0304BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 80, true, true, true){
        	{

        	}
        });
        //** column 주민등록번호 : secRegnNum *//*
        listColumnDefs.add(new ColumnDef("주민등록번호", Payr0304BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING, 0, false , false, false){
        	{

        	}
        });
        
        //** column 사업코드 : businCd ㅇ*//*
        listColumnDefs.add(new ColumnDef("사업코드", Payr0304BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        //** column 직종코드 : typOccuCd ㅇ*//*
        listColumnDefs.add(new ColumnDef("직종코드", Payr0304BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
        //** column 호봉등급코드 : pyspGrdeCd ㅇ*//*
        listColumnDefs.add(new ColumnDef("호봉등급코드", Payr0304BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
        //** column 직종세구분코드 : dtilOccuClsDivCd *//*
        listColumnDefs.add(new ColumnDef("직종세구분코드", Payr0304BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
        //** column 직종세통합코드 : dtilOccuInttnCd ㅇ*//*
    	listColumnDefs.add(new ColumnDef("직종세통합코드", Payr0304BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    	{
    	
    	}
    	});
    	
    	//** column 직종 : typOccuNm *//*
        listColumnDefs.add(new ColumnDef("직종", Payr0304BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });

    	//** column 직종세 : dtilOccuClsDivNm *//*
    	listColumnDefs.add(new ColumnDef("직종세", Payr0304BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{
    	
    	}
    	});                     

        //** column 사업 : businNm *//*
        listColumnDefs.add(new ColumnDef("사업명", Payr0304BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING, 90, false, false, true){
            {

            }
        });
        
        //** column 지급년월 : pymtYrMnth ㅇ*//*
        listColumnDefs.add(new ColumnDef("지급년월", Payr0301BM.ATTR_PYMTYRMNTH, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{
              
        	}
        });
        
        //** column 급여구분코드 : payCd ㅇ*//*
        listColumnDefs.add(new ColumnDef("급여구분코드", Payr0304BM.ATTR_PAYCD, ColumnDef.TYPE_STRING , 90, false, false, true){
        	{

        	}
        });

        //** column 급여구분 : payNm *//*
        listColumnDefs.add(new ColumnDef("급여구분", Payr0304BM.ATTR_PAYNM, ColumnDef.TYPE_STRING , 90, false, true, false){
        	{

        	}
        });
        
        //** column SYSTEMKEY : systemkey ㅇ*//*
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Payr0301BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
        //** column 지급공제구분코드 : pymtDducDivCd  수정필요?확인해야함 *//*
        listColumnDefs.add(new ColumnDef("지급공제구분코드", Payr0302BM.ATTR_PYMTDDUCDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{
        	}
        });
        
        //** column 지급공제구분 : pymtDducDivNm ㅇ*//*
        listColumnDefs.add(new ColumnDef("지급공제구분", Payr0302BM.ATTR_PYMTDDUCDIVNM, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{
        	}
        });
        
        //** column 급여항목코드 : payItemCd ㅇ*//*
        listColumnDefs.add(new ColumnDef("급여항목코드", Payr0302BM.ATTR_PAYITEMCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{
        	}
        });
        //** column 급여항목 : payItemNm *//*
        listColumnDefs.add(new ColumnDef("급여항목", Payr0302BM.ATTR_PAYITEMNM, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{
        	}
        });
        
        //** column 지급공제비과세금액 : pymtDducFreeDtySum *//*
        listColumnDefs.add(new ColumnDef("비과세금액", Payr0302BM.ATTR_PYMTDDUCFREEDTYSUM, ColumnDef.TYPE_LONG, 90, false, true, true){
        	{
        	}
        });
        //** column 지급공제금액 : pymtDducSum *//*
        listColumnDefs.add(new ColumnDef("금액", Payr0302BM.ATTR_PYMTDDUCSUM, ColumnDef.TYPE_LONG, 90, false, true, true){
        	{
        	}
        });
        //** column 지급공제과세금액 : pymtDducTxtnAmnt *//*
        listColumnDefs.add(new ColumnDef("과세금액", Payr0302BM.ATTR_PYMTDDUCTXTNAMNT, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{
        	}
        });
        
        //** column 단위기관 : payrMangDeptCd ㅇ*//*
        listColumnDefs.add(new ColumnDef("단위기관코드", Payr0301BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        //** column 단위기관 : payrMangDeptNm *//*
        listColumnDefs.add(new ColumnDef("단위기관", Payr0301BM.ATTR_PAYRMANGDEPTNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        //쿼리문테스트 위해 주석처리 6.19 -"89"
        //** column 급여일련번호 : payrSeilNum *//*
        listColumnDefs.add(new ColumnDef("급여일련번호", Payr0304BM.ATTR_PAYRSEILNUM, ColumnDef.TYPE_LONG , 50, true, false, true){
        	{

        	}
        });
        
        //** column null : mnthPayAdmntSeilNum *//* //필요할까? 6.17 -"62"
        listColumnDefs.add(new ColumnDef("급여조정일련번호", Payr0307BM.ATTR_MNTHPAYADMNTSEILNUM, ColumnDef.TYPE_LONG, 90, true, false, true){
        	{

        	}
        });
        
        //** column 등록일자 : inptDt *//*
        listColumnDefs.add(new ColumnDef("등록일자", Payr0307BM.ATTR_INPTDT, ColumnDef.TYPE_DATE, 90, true, true, true){
        	{

        	}
        });
        
        return listColumnDefs;
        
    }   */ 
    
    
    
    
    
    
    //새롭게 급여내역조회 컬럼을 만들어준다 6.18 -"64"
private List<ColumnDef> getPayr0304ToPayr4201ColumnsList(){
	row = 0;
    List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
    
    /** column 사업장코드 : dpobCd ㅇ*/
    listColumnDefs.add(new ColumnDef("사업장코드", Payr0300BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        {

        }
    });
    
    /** column 고용구분코드 : emymtDivCd ㅇ*/
    listColumnDefs.add(new ColumnDef("고용구분코드", Payr0304BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{

    	}
    });
    
    /** column 고용구분 : emymtDivNm */
    listColumnDefs.add(new ColumnDef("고용구분", Payr0304BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{

    	}
    });
    
    /** column 부서코드 : deptCd ㅇ*/
    listColumnDefs.add(new ColumnDef("부서코드", Payr0304BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 120, false, false, true){
    	{

    	}
    });
    
    /** column 부서 : deptNm */
    listColumnDefs.add(new ColumnDef("부서명", Payr0304BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 90, true, true, true){
    	{

    	}
    });
    
    /** column 한글성명 : hanNm ㅇ*/
    listColumnDefs.add(new ColumnDef("성명", Payr0304BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 60, true, true, true){
    	{

    	}
    });
    
    /** column 주민등록번호 : resnRegnNum ㅇ*/
    listColumnDefs.add(new ColumnDef("주민등록번호", Payr0304BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 80, true, true, true){
    	{

    	}
    });
    /** column 주민등록번호 : secRegnNum */
    listColumnDefs.add(new ColumnDef("주민등록번호", Payr0304BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING, 0, false , false, false){
    	{

    	}
    });
    
    /** column 사업코드 : businCd ㅇ*/
    listColumnDefs.add(new ColumnDef("사업코드", Payr0304BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{

    	}
    });
    /** column 직종코드 : typOccuCd ㅇ*/
    listColumnDefs.add(new ColumnDef("직종코드", Payr0304BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{

    	}
    });
    
    /** column 호봉등급코드 : pyspGrdeCd ㅇ*/
    listColumnDefs.add(new ColumnDef("호봉등급코드", Payr0304BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{

    	}
    });
    
    /** column 직종세구분코드 : dtilOccuClsDivCd */
    listColumnDefs.add(new ColumnDef("직종세구분코드", Payr0304BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{

    	}
    });
    
    /** column 직종세통합코드 : dtilOccuInttnCd ㅇ*/
	listColumnDefs.add(new ColumnDef("직종세통합코드", Payr0304BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
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

    /** column 사업 : businNm */
    listColumnDefs.add(new ColumnDef("사업명", Payr0304BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING, 90, false, false, true){
        {

        }
    });
    
    /** column 지급년월 : pymtYrMnth ㅇ*/
    listColumnDefs.add(new ColumnDef("지급년월", Payr0301BM.ATTR_PYMTYRMNTH, ColumnDef.TYPE_STRING, 90, false, true, true){
    	{
          
    	}
    });
    
    /** column 급여구분코드 : payCd ㅇ*/
    listColumnDefs.add(new ColumnDef("급여구분코드", Payr0304BM.ATTR_PAYCD, ColumnDef.TYPE_STRING , 90, false, false, true){
    	{

    	}
    });

    /** column 급여구분 : payNm */
    listColumnDefs.add(new ColumnDef("급여구분", Payr0304BM.ATTR_PAYNM, ColumnDef.TYPE_STRING , 90, false, true, false){
    	{

    	}
    });
    
    /** column SYSTEMKEY : systemkey ㅇ*/
    listColumnDefs.add(new ColumnDef("SYSTEMKEY", Payr0301BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{

    	}
    });
    
    /** column 지급공제구분코드 : pymtDducDivCd  수정필요?확인해야함 */
    listColumnDefs.add(new ColumnDef("지급공제구분코드", Payr0302BM.ATTR_PYMTDDUCDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{
    	}
    });
    
    /** column 지급공제구분 : pymtDducDivNm ㅇ*/
    listColumnDefs.add(new ColumnDef("지급공제구분", Payr0302BM.ATTR_PYMTDDUCDIVNM, ColumnDef.TYPE_STRING, 90, false, true, true){
    	{
    	}
    });
    
    /** column 급여항목코드 : payItemCd ㅇ*/
    listColumnDefs.add(new ColumnDef("급여항목코드", Payr0302BM.ATTR_PAYITEMCD, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{
    	}
    });
    /** column 급여항목 : payItemNm */
    listColumnDefs.add(new ColumnDef("급여항목", Payr0302BM.ATTR_PAYITEMNM, ColumnDef.TYPE_STRING, 90, false, true, true){
    	{
    	}
    });
    
    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
    listColumnDefs.add(new ColumnDef("비과세금액", Payr0302BM.ATTR_PYMTDDUCFREEDTYSUM, ColumnDef.TYPE_LONG, 90, false, true, true){
    	{
    	}
    });
    /** column 지급공제금액 : pymtDducSum */
    listColumnDefs.add(new ColumnDef("금액", Payr0302BM.ATTR_PYMTDDUCSUM, ColumnDef.TYPE_LONG, 90, false, true, true){
    	{
    	}
    });
    /** column 지급공제과세금액 : pymtDducTxtnAmnt */
    listColumnDefs.add(new ColumnDef("과세금액", Payr0302BM.ATTR_PYMTDDUCTXTNAMNT, ColumnDef.TYPE_LONG , 90, true, true, true){
    	{
    	}
    });
    
    /** column 단위기관 : payrMangDeptCd ㅇ*/
    listColumnDefs.add(new ColumnDef("단위기관코드", Payr0301BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    	{

    	}
    });
    
    /** column 단위기관 : payrMangDeptNm */
    listColumnDefs.add(new ColumnDef("단위기관", Payr0301BM.ATTR_PAYRMANGDEPTNM, ColumnDef.TYPE_STRING , 90, true, false, true){
    	{

    	}
    });
    
    //쿼리문테스트 위해 주석처리 6.19 -"89"
    /** column 급여일련번호 : payrSeilNum *//*
    listColumnDefs.add(new ColumnDef("급여일련번호", Payr0304BM.ATTR_PAYRSEILNUM, ColumnDef.TYPE_LONG , 50, true, false, true){
    	{

    	}
    });
    
    *//** column null : mnthPayAdmntSeilNum *//* //필요할까? 6.17 -"62"
    listColumnDefs.add(new ColumnDef("급여조정일련번호", Payr0307BM.ATTR_MNTHPAYADMNTSEILNUM, ColumnDef.TYPE_LONG, 90, true, false, true){
    	{

    	}
    });*/
    
    /** column 등록일자 : inptDt */
    listColumnDefs.add(new ColumnDef("등록일자", Payr0307BM.ATTR_INPTDT, ColumnDef.TYPE_DATE, 90, true, true, true){
    	{

    	}
    });
    
    return listColumnDefs;
    
}
    
private List<ColumnDef> getPayr0304ToPayr4420ColumnsList(){
    row = 0;
    List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 

    /** column 사업장코드 : dpobCd */
    listColumnDefs.add(new ColumnDef("사업장코드", Payr0300BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        {

        }
    });
    
    /** column 지급년월 : pymtYrMnth */
    listColumnDefs.add(new ColumnDef("지급년월", Payr0301BM.ATTR_PYMTYRMNTH, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{
          
    	}
    });
    /** column SYSTEMKEY : systemkey */
    listColumnDefs.add(new ColumnDef("SYSTEMKEY", Payr0301BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{

    	}
    });
    
    /** column 급여구분코드 : payCd */
    listColumnDefs.add(new ColumnDef("급여구분코드", Payr0304BM.ATTR_PAYCD, ColumnDef.TYPE_STRING , 90, false, false, true){
    	{

    	}
    });

    /** column 급여구분 : payNm */
    listColumnDefs.add(new ColumnDef("급여구분", Payr0304BM.ATTR_PAYNM, ColumnDef.TYPE_STRING , 90, false, false, true){
    	{

    	}
    });

     
    /** column 고용구분코드 : emymtDivCd */
    listColumnDefs.add(new ColumnDef("고용구분코드", Payr0304BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{

    	}
    });
    
    /** column 고용구분 : emymtDivNm */
    listColumnDefs.add(new ColumnDef("고용구분", Payr0304BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{

    	}
    });
    
    /** column 한글성명 : hanNm */
    listColumnDefs.add(new ColumnDef("성명", Payr0304BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 60, true, true, true){
    	{

    	}
    });
    /** column 주민등록번호 : resnRegnNum */
    listColumnDefs.add(new ColumnDef("주민등록번호", Payr0304BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 80, true, true, true){
    	{

    	}
    });
    /** column 주민등록번호 : secRegnNum */
    listColumnDefs.add(new ColumnDef("주민등록번호", Payr0304BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING, 0, false , false, false){
    	{

    	}
    });
    /** column 부서코드 : deptCd */
    listColumnDefs.add(new ColumnDef("부서코드", Payr0304BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 120, false, false, true){
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
    
    /** column 부서 : deptNm */
    listColumnDefs.add(new ColumnDef("부서명", Payr0304BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 90, true, true, true){
    	{

    	}
    });
  
    /** column 직종 : typOccuNm */
    listColumnDefs.add(new ColumnDef("직종", Payr0304BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{

    	}
    });
    

	/** column 직종세 : dtilOccuClsDivNm */
	listColumnDefs.add(new ColumnDef("직종세", Payr0304BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 90, false, true, true){
	{
	
	}
	});                     


    /** column 사업 : businNm */
    listColumnDefs.add(new ColumnDef("사업명", Payr0304BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING, 90, false, true, true){
        {

        }
    });
    
	/** column 직종세통합코드 : dtilOccuInttnCd */
	listColumnDefs.add(new ColumnDef("직종세통합코드", Payr0304BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	{
	
	}
	});                                           
      


    /** column 직종세 : dtilOccuClsDivNm */
    listColumnDefs.add(new ColumnDef("직종세", Payr0304BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{

    	}
    });
    /** column 호봉코드 : pyspCd */
    listColumnDefs.add(new ColumnDef("호봉코드", Payr0304BM.ATTR_PYSPCD, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{

    	}
    });
    /** column 호봉등급코드 : pyspGrdeCd */
    listColumnDefs.add(new ColumnDef("호봉등급코드", Payr0304BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{

    	}
    });
    /** column 근속년수코드 : logSvcYrNumCd */
    listColumnDefs.add(new ColumnDef("근속년수코드", Payr0304BM.ATTR_LOGSVCYRNUMCD, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{

    	}
    });
    
    /** column 근속년수코드 : logSvcYrNumNm */
    listColumnDefs.add(new ColumnDef("근속년수", Payr0304BM.ATTR_LOGSVCYRNUMNM, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{

    	}
    });
     
    /** column 단위기관 : payrMangDeptCd */
    listColumnDefs.add(new ColumnDef("단위기관코드", Payr0301BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, false, false, true){
    	{

    	}
    });
    
    /** column 단위기관 : payrMangDeptNm */
    listColumnDefs.add(new ColumnDef("단위기관", Payr0301BM.ATTR_PAYRMANGDEPTNM, ColumnDef.TYPE_STRING , 90, false, false, true){
    	{

    	}
    });
    
    /** column 급여일련번호 : payrSeilNum */
    listColumnDefs.add(new ColumnDef("급여번호", Payr0304BM.ATTR_PAYRSEILNUM, ColumnDef.TYPE_LONG , 50, false, true, true){
    	{

    	}
    });
    /** column 지급총액 : pymtTotAmnt */
    listColumnDefs.add(new ColumnDef("지급금액", Payr0301BM.ATTR_PYMTTOTAMNT, ColumnDef.TYPE_LONG , 90, false, false, true){
    	{
    		// setFormatNumeric(NumberFormat.getFormat("$#,##0.00")); 
    		//this.setFormatNumeric("########");
    		//setFormatNumeric(NumberFormat.getCurrencyFormat("EUR"));
    	}
    });
    /** column 수당총액 : extpyTotAmnt */
    listColumnDefs.add(new ColumnDef("수당금액", Payr0301BM.ATTR_EXTPYTOTAMNT, ColumnDef.TYPE_LONG , 90, false, false, true){
    	{

    	}
    });
    /** column 과세총액 : txtnTotAmnt */
    listColumnDefs.add(new ColumnDef("과세금액", Payr0301BM.ATTR_TXTNTOTAMNT, ColumnDef.TYPE_LONG , 90, false, false, true){
    	{

    	}
    });
    /** column 비과세총액 : freeDtyTotAmnt */
    listColumnDefs.add(new ColumnDef("비과세금액", Payr0301BM.ATTR_FREEDTYTOTAMNT, ColumnDef.TYPE_LONG , 90, false, false, true){
    	{

    	}
    });
    /** column 공제총액 : dducTotAmnt */
    listColumnDefs.add(new ColumnDef("공제금액", Payr0301BM.ATTR_DDUCTOTAMNT, ColumnDef.TYPE_LONG , 90, false, false, true){
    	{

    	}
    });
    /** column 세금총액 : txTotAmnt */
    listColumnDefs.add(new ColumnDef("세금", Payr0301BM.ATTR_TXTOTAMNT, ColumnDef.TYPE_LONG , 90, false, false, true){
    	{

    	}
    });
    /** column 퇴직금지급여부 : sevePayPymtYn */
    listColumnDefs.add(new ColumnDef("퇴직금지급여부", Payr0301BM.ATTR_SEVEPAYPYMTYN, ColumnDef.TYPE_STRING , 90, false, false, true){
    	{

    	}
    });
    /** column 실지급액 : pernPymtSum */
    listColumnDefs.add(new ColumnDef("지급금액", Payr0301BM.ATTR_PERNPYMTSUM, ColumnDef.TYPE_LONG , 90, false, false, true){
    	{

    	}
    });
    /** column 기본급 : pymtB10100Sum */
    listColumnDefs.add(new ColumnDef("기본급", Payr0301BM.ATTR_PYMTB10100SUM, ColumnDef.TYPE_LONG , 90, false, false, true){
    	{

    	}
    });
    
    /** column 소득세 : pymtT10100Sum */
    listColumnDefs.add(new ColumnDef("소득세", Payr0301BM.ATTR_PYMTT10100SUM, ColumnDef.TYPE_LONG , 90, false, false, true){
    	{

    	}
    });
    
    /** column 주민세  : pymtT20100Sum */
    listColumnDefs.add(new ColumnDef("주민세", Payr0301BM.ATTR_PYMTT20100SUM, ColumnDef.TYPE_LONG , 90, false, false, true){
    	{

    	}
    });
    
    /** column 소득세징수비율 : incmTxCllnRto */
    listColumnDefs.add(new ColumnDef("소득세징수비율", Payr0301BM.ATTR_INCMTXCLLNRTO, ColumnDef.TYPE_DOUBLE , 90, false, false, true){
    	{

    	}
    });
    /** column 은행코드 : bnkCd */
    listColumnDefs.add(new ColumnDef("은행코드", Payr0301BM.ATTR_BNKCD, ColumnDef.TYPE_STRING , 90, false, false, true){
    	{

    	}
    });
    /** column 은행계좌번호 : bnkAccuNum */
    listColumnDefs.add(new ColumnDef("계좌번호", Payr0301BM.ATTR_BNKACCUNUM, ColumnDef.TYPE_STRING , 90, false, false, true){
    	{

    	}
    });
    /** column 예금주명 : acntHodrNm */
    listColumnDefs.add(new ColumnDef("예금주명", Payr0301BM.ATTR_ACNTHODRNM, ColumnDef.TYPE_STRING , 90, false, false, true){
    	{

    	}
    });
    /** column 급여마감일자 : payDdlneDt */
    listColumnDefs.add(new ColumnDef("마감일자", Payr0301BM.ATTR_PAYDDLNEDT, ColumnDef.TYPE_STRING , 90, false, false, true){
    	{

    	}
    });
    /** column 급여마감여부 : payDdlneYn */
    listColumnDefs.add(new ColumnDef("마감여부", Payr0301BM.ATTR_PAYDDLNEYN, ColumnDef.TYPE_STRING , 90, false, false, true){
    	{

    	}
    });
     
    /** column 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
    listColumnDefs.add(new ColumnDef("추가소득세적용비율코드", Payr0304BM.ATTR_ADDINCMTXAPPTNRTOCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    	{

    	}
    });
    /** column 추가소득세적용년월 : addIncmTxApptnYrMnth */
    listColumnDefs.add(new ColumnDef("추가소득세적용년월", Payr0304BM.ATTR_ADDINCMTXAPPTNYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
    	{

    	}
    });
  
//    /** column 입력자 : kybdr */
//    listColumnDefs.add(new ColumnDef("입력자", Payr0301BM.ATTR_KYBDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//    	{
//
//    	}
//    });
//    /** column 입력일자 : inptDt */
//    listColumnDefs.add(new ColumnDef("입력일자", Payr0301BM.ATTR_INPTDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//    	{
//
//    	}
//    });
//    /** column 입력주소 : inptAddr */
//    listColumnDefs.add(new ColumnDef("입력주소", Payr0301BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//    	{
//
//    	}
//    });
//    /** column 수정자 : ismt */
//    listColumnDefs.add(new ColumnDef("수정자", Payr0301BM.ATTR_ISMT, ColumnDef.TYPE_STRING, 90, true, false, true){
//    	{
//
//    	}
//    });
//    /** column 수정일자 : revnDt */
//    listColumnDefs.add(new ColumnDef("수정일자", Payr0301BM.ATTR_REVNDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//    	{
//
//    	}
//    });
//    /** column 수정주소 : revnAddr */
//    listColumnDefs.add(new ColumnDef("수정주소", Payr0301BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//    	{
//
//    	}
//    });
 
    
    return listColumnDefs;
}
    public List<ColumnDef> getPayr0304Def(){
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0300BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, true, false, true){
            {

            }
        });
        /** column 지급년월 : pymtYrMnth */
        listColumnDefs.add(new ColumnDef("지급년월", Payr0304BM.ATTR_PYMTYRMNTH, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Payr0304BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 급여구분코드 : payCd */
        listColumnDefs.add(new ColumnDef("급여구분코드", Payr0304BM.ATTR_PAYCD, ColumnDef.TYPE_STRING, 90, true, false, true){
            {

            }
        });
        
        /** column 급여구분 : payNm */
        listColumnDefs.add(new ColumnDef("급여구분", Payr0304BM.ATTR_PAYNM, ColumnDef.TYPE_STRING, 90, true, true, true){
            {

            }
        });
        
        
        /** column 급여일련번호 : payrSeilNum */
        listColumnDefs.add(new ColumnDef("급여일련번호", Payr0304BM.ATTR_PAYRSEILNUM, ColumnDef.TYPE_LONG, 90, true, false, true){
            {

            }
        });
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분코드", Payr0304BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING, 90, true, false, true){
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
		listColumnDefs.add(new ColumnDef("직종세통합코드", Payr0304BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
		{
		
		}
		});                                           

        /** column 직책코드 : odtyCd */
        listColumnDefs.add(new ColumnDef("직책코드", Payr0304BM.ATTR_ODTYCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 호봉코드 : pyspCd */
        listColumnDefs.add(new ColumnDef("호봉코드", Payr0304BM.ATTR_PYSPCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 호봉등급코드 : pyspGrdeCd */
        listColumnDefs.add(new ColumnDef("호봉등급코드", Payr0304BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 근속년수코드 : logSvcYrNumCd */
        listColumnDefs.add(new ColumnDef("근속년수코드", Payr0304BM.ATTR_LOGSVCYRNUMCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 근속월수코드 : logSvcMnthIcmCd */
        listColumnDefs.add(new ColumnDef("근속월수코드", Payr0304BM.ATTR_LOGSVCMNTHICMCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 최초고용일자 : frstEmymtDt */
        listColumnDefs.add(new ColumnDef("최초고용일자", Payr0304BM.ATTR_FRSTEMYMTDT, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 고용시작일자 : emymtBgnnDt */
        listColumnDefs.add(new ColumnDef("고용시작일자", Payr0304BM.ATTR_EMYMTBGNNDT, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 고용종료일자 : emymtEndDt */
        listColumnDefs.add(new ColumnDef("고용종료일자", Payr0304BM.ATTR_EMYMTENDDT, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 재직구분코드 : hdofcDivCd */
        listColumnDefs.add(new ColumnDef("재직구분코드", Payr0304BM.ATTR_HDOFCDIVCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        /** column 퇴직일자 : retryDt */
        listColumnDefs.add(new ColumnDef("퇴직일자", Payr0304BM.ATTR_RETRYDT, ColumnDef.TYPE_DATE, 90, true, false, true){
        	{

        	}
        });
        /** column 근속기준일자 : logSvcStdDt */
        listColumnDefs.add(new ColumnDef("근속기준일자", Payr0304BM.ATTR_LOGSVCSTDDT, ColumnDef.TYPE_DATE, 90, true, false, true){
        	{

        	}
        });
        /** column 배우자유무 : spueYn */
        listColumnDefs.add(new ColumnDef("배우자유무", Payr0304BM.ATTR_SPUEYN, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
        	{

        	}
        });
        
 
        /** column 부양가족수20_자녀 : suprtFamyNumTwenChDn */
        listColumnDefs.add(new ColumnDef("부양가족수20_자녀", Payr0304BM.ATTR_SUPRTFAMYNUMTWENCHDN, ColumnDef.TYPE_LONG , 90, true, false, true){
            {

            }
        });
        /** column 부양가족수_3_이상자녀 : suprtFamyNumTreOvrChdn */
        listColumnDefs.add(new ColumnDef("부양가족수_3_이상자녀", Payr0304BM.ATTR_SUPRTFAMYNUMTREOVRCHDN, ColumnDef.TYPE_LONG , 90, true, false, true){
            {

            }
        });
        /** column 부양가족수_기타 : suprtFamyNumEtc */
        listColumnDefs.add(new ColumnDef("부양가족수_기타", Payr0304BM.ATTR_SUPRTFAMYNUMETC, ColumnDef.TYPE_LONG , 90, true, false, true){
            {

            }
        });
        /** column 부양가족3인이상자녀수당금액 : suprtFamy3ChdnExtpySum */
        listColumnDefs.add(new ColumnDef("부양가족3인이상자녀수당금액", Payr0304BM.ATTR_SUPRTFAMY3CHDNEXTPYSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
            {

            }
        });
        /** column 자녀학비보조여부 : chdnSchlExpnAdmclYn */
        listColumnDefs.add(new ColumnDef("자녀학비보조여부", Payr0304BM.ATTR_CHDNSCHLEXPNADMCLYN, ColumnDef.TYPE_STRING , 90, true, false, true){
            {

            }
        });
        /** column 건강보험등급 : hlthInsrGrde */
        listColumnDefs.add(new ColumnDef("건강보험등급", Payr0304BM.ATTR_HLTHINSRGRDE, ColumnDef.TYPE_STRING , 90, true, false, true){
            {

            }
        });
        /** column 국민연금등급 : natPennGrde */
        listColumnDefs.add(new ColumnDef("국민연금등급", Payr0304BM.ATTR_NATPENNGRDE, ColumnDef.TYPE_STRING , 90, true, false, true){
            {

            }
        });
        /** column 월급여일당금액 : mnthPayDlywagSum */
        listColumnDefs.add(new ColumnDef("월급여일당금액", Payr0304BM.ATTR_MNTHPAYDLYWAGSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
            {

            }
        });
        
        /** column 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
        listColumnDefs.add(new ColumnDef("추가소득세적용비율코드", Payr0304BM.ATTR_ADDINCMTXAPPTNRTOCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 추가소득세적용년월 : addIncmTxApptnYrMnth */
        listColumnDefs.add(new ColumnDef("추가소득세적용년월", Payr0304BM.ATTR_ADDINCMTXAPPTNYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

         
//        /** column 입력자 : kybdr */
//        listColumnDefs.add(new ColumnDef("입력자", Payr0304BM.ATTR_KYBDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력일자 : inptDt */
//        listColumnDefs.add(new ColumnDef("입력일자", Payr0304BM.ATTR_INPTDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력주소 : inptAddr */
//        listColumnDefs.add(new ColumnDef("입력주소", Payr0304BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정자 : ismt */
//        listColumnDefs.add(new ColumnDef("수정자", Payr0304BM.ATTR_ISMT, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정일자 : revnDt */
//        listColumnDefs.add(new ColumnDef("수정일자", Payr0304BM.ATTR_REVNDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정주소 : revnAddr */
//        listColumnDefs.add(new ColumnDef("수정주소", Payr0304BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> pymtYrMnth;   /** column 지급년월 : pymtYrMnth */
//
//        private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//        private TextField<String> payrMangDeptCd;   /** column 급여관리부서코드 : payrMangDeptCd */
//
//        private TextField<String> emymtDivCd;   /** column 고용구분코드 : emymtDivCd */
//
//        private TextField<String> hanNm;   /** column 한글성명 : hanNm */
//
//        private TextField<String> resnRegnNum;   /** column 주민등록번호 : resnRegnNum */
//
//        private TextField<String> deptCd;   /** column 부서코드 : deptCd */
//
//        private TextField<String> businCd;   /** column 사업코드 : businCd */
//
//        private TextField<String> typOccuCd;   /** column 직종코드 : typOccuCd */
//
//        private TextField<String> dtilOccuClsDivCd;   /** column 직종세구분코드 : dtilOccuClsDivCd */
//
//        private TextField<String> odtyCd;   /** column 직책코드 : odtyCd */
//
//        private TextField<String> pyspCd;   /** column 호봉코드 : pyspCd */
//
//        private TextField<String> pyspGrdeCd;   /** column 호봉등급코드 : pyspGrdeCd */
//
//        private TextField<String> logSvcYrNumCd;   /** column 근속년수코드 : logSvcYrNumCd */
//
//        private TextField<String> logSvcMnthIcmCd;   /** column 근속월수코드 : logSvcMnthIcmCd */
//
//        private TextField<String> frstEmymtDt;   /** column 최초고용일자 : frstEmymtDt */
//
//        private TextField<String> emymtBgnnDt;   /** column 고용시작일자 : emymtBgnnDt */
//
//        private TextField<String> emymtEndDt;   /** column 고용종료일자 : emymtEndDt */
//
//        private TextField<String> hdofcDivCd;   /** column 재직구분코드 : hdofcDivCd */
//
//        private TextField<String> retryDt;   /** column 퇴직일자 : retryDt */
//
//        private TextField<String> logSvcStdDt;   /** column 근속기준일자 : logSvcStdDt */
//
//        private TextField<String> spueYn;   /** column 배우자유무 : spueYn */
//
//        private TextField<String> suprtFamyNumTwenChDn;   /** column 부양가족수20_자녀 : suprtFamyNumTwenChDn */
//
//        private TextField<String> suprtFamyNumTreOvrChdn;   /** column 부양가족수_3_이상자녀 : suprtFamyNumTreOvrChdn */
//
//        private TextField<String> suprtFamyNumEtc;   /** column 부양가족수_기타 : suprtFamyNumEtc */
//
//        private TextField<String> suprtFamy3ChdnExtpySum;   /** column 부양가족3인이상자녀수당금액 : suprtFamy3ChdnExtpySum */
//
//        private TextField<String> chdnSchlExpnAdmclYn;   /** column 자녀학비보조여부 : chdnSchlExpnAdmclYn */
//
//        private TextField<String> hlthInsrGrde;   /** column 건강보험등급 : hlthInsrGrde */
//
//        private TextField<String> natPennGrde;   /** column 국민연금등급 : natPennGrde */
//
//        private TextField<String> mnthPayDlywagSum;   /** column 월급여일당금액 : mnthPayDlywagSum */
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
        
//        private TextField<String> addIncmTxApptnRtoCd;   /** column 추가소득세적용비율코드 : addIncmTxApptnRtoCd */

//        private TextField<String> addIncmTxApptnYrMnth;   /** column 추가소득세적용년월 : addIncmTxApptnYrMnth */
        
        return listColumnDefs;
    }
    
    


private List<ColumnDef> getPayr0304ToPayrP410001ColumnsList(){
    
    List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 

    /** column 사업장코드 : dpobCd */
    listColumnDefs.add(new ColumnDef("사업장코드", Payr0300BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, true, true, true){
        {

        }
    });
    
    /** column 지급년월 : pymtYrMnth */
    listColumnDefs.add(new ColumnDef("지급년월", Payr0301BM.ATTR_PYMTYRMNTH, ColumnDef.TYPE_STRING, 90, false, true, true){
    	{
          
    	}
    });
    /** column SYSTEMKEY : systemkey */
    listColumnDefs.add(new ColumnDef("SYSTEMKEY", Payr0301BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{

    	}
    });
    
    /** column 급여구분코드 : payCd */
    listColumnDefs.add(new ColumnDef("급여구분코드", Payr0304BM.ATTR_PAYCD, ColumnDef.TYPE_STRING , 90, false, true, true){
    	{

    	}
    });

    /** column 급여구분 : payNm */
    listColumnDefs.add(new ColumnDef("급여구분", Payr0304BM.ATTR_PAYNM, ColumnDef.TYPE_STRING , 90, false, false, true){
    	{

    	}
    });

     
    /** column 고용구분코드 : emymtDivCd */
    listColumnDefs.add(new ColumnDef("고용구분코드", Payr0304BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING, 90, false, true, true){
    	{

    	}
    });
    
    /** column 고용구분 : emymtDivNm */
    listColumnDefs.add(new ColumnDef("고용구분", Payr0304BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{

    	}
    });
    
    /** column 한글성명 : hanNm */
    listColumnDefs.add(new ColumnDef("성명", Payr0304BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 60, true, true, true){
    	{

    	}
    });
    /** column 주민등록번호 : resnRegnNum */
    listColumnDefs.add(new ColumnDef("주민등록번호", Payr0304BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 80, true, true, true){
    	{

    	}
    });
    /** column 주민등록번호 : secRegnNum */
    listColumnDefs.add(new ColumnDef("주민등록번호", Payr0304BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING, 0, false, false, false){
    	{

    	}
    });
    /** column 부서코드 : deptCd */
    listColumnDefs.add(new ColumnDef("부서코드", Payr0304BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 120, false, false, true){
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
    listColumnDefs.add(new ColumnDef("직종세통합코드", Payr0304BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    	{

    	}
    });
    
    /** column 부서 : deptNm */
    listColumnDefs.add(new ColumnDef("부서명", Payr0304BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 90, true, true, true){
    	{

    	}
    });
  
    /** column 직종 : typOccuNm */
    listColumnDefs.add(new ColumnDef("직종", Payr0304BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{

    	}
    });
    
    /** column 직종세 : dtilOccuClsDivNm */
    listColumnDefs.add(new ColumnDef("직종세", Payr0304BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 90, false, true, true){
    	{

    	}
    });
    
    /** column 사업 : businNm */
    listColumnDefs.add(new ColumnDef("사업명", Payr0304BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING, 90, false, true, true){
        {

        }
    });
   
    /** column 호봉코드 : pyspCd */
    listColumnDefs.add(new ColumnDef("호봉코드", Payr0304BM.ATTR_PYSPCD, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{

    	}
    });
    /** column 호봉등급코드 : pyspGrdeCd */
    listColumnDefs.add(new ColumnDef("호봉등급코드", Payr0304BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{

    	}
    });
    /** column 근속년수코드 : logSvcYrNumCd */
    listColumnDefs.add(new ColumnDef("근속년수코드", Payr0304BM.ATTR_LOGSVCYRNUMCD, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{

    	}
    });
    
    /** column 근속년수코드 : logSvcYrNumNm */
    listColumnDefs.add(new ColumnDef("근속년수", Payr0304BM.ATTR_LOGSVCYRNUMNM, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{

    	}
    });
     
    /** column 단위기관 : payrMangDeptCd */
    listColumnDefs.add(new ColumnDef("단위기관코드", Payr0301BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, false, false, true){
    	{

    	}
    });
    
    /** column 단위기관 : payrMangDeptNm */
    listColumnDefs.add(new ColumnDef("단위기관", Payr0301BM.ATTR_PAYRMANGDEPTNM, ColumnDef.TYPE_STRING , 90, false, false, true){
    	{

    	}
    });
    
    /** column 급여일련번호 : payrSeilNum */
    listColumnDefs.add(new ColumnDef("급여일련번호", Payr0304BM.ATTR_PAYRSEILNUM, ColumnDef.TYPE_LONG , 90, false, true, true){
    	{

    	}
    });
    /** column 지급총액 : pymtTotAmnt */
    listColumnDefs.add(new ColumnDef("지급금액", Payr0301BM.ATTR_PYMTTOTAMNT, ColumnDef.TYPE_LONG , 90, false, true, true){
    	{
    		// setFormatNumeric(NumberFormat.getFormat("$#,##0.00")); 
    		//this.setFormatNumeric("########");
    		//setFormatNumeric(NumberFormat.getCurrencyFormat("EUR"));
    	}
    });
    /** column 수당총액 : extpyTotAmnt */
    listColumnDefs.add(new ColumnDef("수당금액", Payr0301BM.ATTR_EXTPYTOTAMNT, ColumnDef.TYPE_LONG , 90, false, true, true){
    	{

    	}
    });
    /** column 과세총액 : txtnTotAmnt */
    listColumnDefs.add(new ColumnDef("과세금액", Payr0301BM.ATTR_TXTNTOTAMNT, ColumnDef.TYPE_LONG , 90, false, true, true){
    	{

    	}
    });
    /** column 비과세총액 : freeDtyTotAmnt */
    listColumnDefs.add(new ColumnDef("비과세금액", Payr0301BM.ATTR_FREEDTYTOTAMNT, ColumnDef.TYPE_LONG , 90, false, true, true){
    	{

    	}
    });
    /** column 공제총액 : dducTotAmnt */
    listColumnDefs.add(new ColumnDef("공제금액", Payr0301BM.ATTR_DDUCTOTAMNT, ColumnDef.TYPE_LONG , 90, false, true, true){
    	{

    	}
    });
    /** column 세금총액 : txTotAmnt */
    listColumnDefs.add(new ColumnDef("세금", Payr0301BM.ATTR_TXTOTAMNT, ColumnDef.TYPE_LONG , 90, false, true, true){
    	{

    	}
    });
//    /** column 퇴직금지급여부 : sevePayPymtYn */
//    listColumnDefs.add(new ColumnDef("퇴직금지급여부", Payr0301BM.ATTR_SEVEPAYPYMTYN, ColumnDef.TYPE_STRING , 90, false, false, true){
//    	{
//
//    	}
//    });
    /** column 실지급액 : pernPymtSum */
    listColumnDefs.add(new ColumnDef("지급금액", Payr0301BM.ATTR_PERNPYMTSUM, ColumnDef.TYPE_LONG , 90, false, true, true){
    	{

    	}
    });
    /** column 기본급 : pymtB10100Sum */
    listColumnDefs.add(new ColumnDef("기본급", Payr0301BM.ATTR_PYMTB10100SUM, ColumnDef.TYPE_LONG , 90, false, true, true){
    	{

    	}
    });
    
    /** column 소득세 : pymtT10100Sum */
    listColumnDefs.add(new ColumnDef("소득세", Payr0301BM.ATTR_PYMTT10100SUM, ColumnDef.TYPE_LONG , 90, false, true, true){
    	{

    	}
    });
    
    /** column 주민세  : pymtT20100Sum */
    listColumnDefs.add(new ColumnDef("주민세", Payr0301BM.ATTR_PYMTT20100SUM, ColumnDef.TYPE_LONG , 90, false, true, true){
    	{

    	}
    });
    
    /** column 소득세징수비율 : incmTxCllnRto */
    listColumnDefs.add(new ColumnDef("소득세징수비율", Payr0301BM.ATTR_INCMTXCLLNRTO, ColumnDef.TYPE_DOUBLE , 90, false, false, true){
    	{

    	}
    });
    
    /** column 급여마감일자 : payDdlneDt */
    listColumnDefs.add(new ColumnDef("마감일자", Payr0301BM.ATTR_PAYDDLNEDT, ColumnDef.TYPE_STRING , 90, false, false, true){
    	{

    	}
    });
    /** column 급여마감여부 : payDdlneYn */
    listColumnDefs.add(new ColumnDef("마감여부", Payr0301BM.ATTR_PAYDDLNEYN, ColumnDef.TYPE_STRING , 90, false, false, true){
    	{

    	}
    });
     
    /** column 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
    listColumnDefs.add(new ColumnDef("추가소득세적용비율코드", Payr0304BM.ATTR_ADDINCMTXAPPTNRTOCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    	{

    	}
    });
    /** column 추가소득세적용년월 : addIncmTxApptnYrMnth */
    listColumnDefs.add(new ColumnDef("추가소득세적용년월", Payr0304BM.ATTR_ADDINCMTXAPPTNYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
    	{

    	}
    });
   
    
    return listColumnDefs;
} 

private List<ColumnDef> getPayr0304ToPayrP410002ColumnsList(){
    
    List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 

    /** column 사업장코드 : dpobCd */
    listColumnDefs.add(new ColumnDef("사업장코드", Payr0300BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        {

        }
    });
    
    /** column 지급년월 : pymtYrMnth */
    listColumnDefs.add(new ColumnDef("지급년월", Payr0301BM.ATTR_PYMTYRMNTH, ColumnDef.TYPE_STRING, 60, false, true, true){
    	{
          
    	}
    });
    /** column SYSTEMKEY : systemkey */
    listColumnDefs.add(new ColumnDef("SYSTEMKEY", Payr0301BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 70, false, false, true){
    	{

    	}
    });
    
    /** column 급여구분코드 : payCd */
    listColumnDefs.add(new ColumnDef("급여구분코드", Payr0304BM.ATTR_PAYCD, ColumnDef.TYPE_STRING , 90, false, false, true){
    	{

    	}
    });

    /** column 급여구분 : payNm */
    listColumnDefs.add(new ColumnDef("급여구분", Payr0304BM.ATTR_PAYNM, ColumnDef.TYPE_STRING , 70, false, true, true){
    	{

    	}
    });

     
    /** column 고용구분코드 : emymtDivCd */
    listColumnDefs.add(new ColumnDef("고용구분코드", Payr0304BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{

    	}
    });
    
    /** column 고용구분 : emymtDivNm */
    listColumnDefs.add(new ColumnDef("고용구분", Payr0304BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING, 80, false, false, true){
    	{

    	}
    });
    
    /** column 한글성명 : hanNm */
    listColumnDefs.add(new ColumnDef("성명", Payr0304BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 60, true, false, true){
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
    listColumnDefs.add(new ColumnDef("부서코드", Payr0304BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 120, false, false, true){
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
    listColumnDefs.add(new ColumnDef("직종세통합코드", Payr0304BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    	{

    	}
    });   
    
    /** column 부서 : deptNm */
    listColumnDefs.add(new ColumnDef("부서명", Payr0304BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 90, false, false, true){
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
    
    /** column 사업 : businNm */
    listColumnDefs.add(new ColumnDef("사업명", Payr0304BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING, 90, false, false, true){
        {

        }
    });
   
    /** column 호봉코드 : pyspCd */
    listColumnDefs.add(new ColumnDef("호봉코드", Payr0304BM.ATTR_PYSPCD, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{

    	}
    });
    /** column 호봉등급코드 : pyspGrdeCd */
    listColumnDefs.add(new ColumnDef("호봉등급코드", Payr0304BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{

    	}
    });
    /** column 근속년수코드 : logSvcYrNumCd */
    listColumnDefs.add(new ColumnDef("근속년수코드", Payr0304BM.ATTR_LOGSVCYRNUMCD, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{

    	}
    });
    
    /** column 근속년수코드 : logSvcYrNumNm */
    listColumnDefs.add(new ColumnDef("근속년수", Payr0304BM.ATTR_LOGSVCYRNUMNM, ColumnDef.TYPE_STRING, 90, false, false, true){
    	{

    	}
    });
     
    /** column 단위기관 : payrMangDeptCd */
    listColumnDefs.add(new ColumnDef("단위기관코드", Payr0301BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, false, false, true){
    	{

    	}
    });
    
    /** column 단위기관 : payrMangDeptNm */
    listColumnDefs.add(new ColumnDef("단위기관", Payr0301BM.ATTR_PAYRMANGDEPTNM, ColumnDef.TYPE_STRING , 90, false, false, true){
    	{

    	}
    });
    
    /** column 급여일련번호 : payrSeilNum */
    listColumnDefs.add(new ColumnDef("급여일련번호", Payr0304BM.ATTR_PAYRSEILNUM, ColumnDef.TYPE_LONG , 90, false, false, true){
    	{

    	}
    });
    /** column 지급총액 : pymtTotAmnt */
    listColumnDefs.add(new ColumnDef("지급총액", Payr0301BM.ATTR_PYMTTOTAMNT, ColumnDef.TYPE_LONG , 80, false, true, true){
    	{
    		// setFormatNumeric(NumberFormat.getFormat("$#,##0.00")); 
    		//this.setFormatNumeric("########");
    		//setFormatNumeric(NumberFormat.getCurrencyFormat("EUR"));
    	}
    });
    /** column 수당총액 : extpyTotAmnt */
    listColumnDefs.add(new ColumnDef("수당금액", Payr0301BM.ATTR_EXTPYTOTAMNT, ColumnDef.TYPE_LONG , 80, false, true, true){
    	{

    	}
    });
    /** column 공제총액 : dducTotAmnt */
    listColumnDefs.add(new ColumnDef("공제금액", Payr0301BM.ATTR_DDUCTOTAMNT, ColumnDef.TYPE_LONG , 80, false, true, true){
    	{

    	}
    });
    /** column 과세총액 : txtnTotAmnt */
    listColumnDefs.add(new ColumnDef("과세금액", Payr0301BM.ATTR_TXTNTOTAMNT, ColumnDef.TYPE_LONG , 80, false, true, true){
    	{

    	}
    });
    /** column 비과세총액 : freeDtyTotAmnt */
    listColumnDefs.add(new ColumnDef("비과세", Payr0301BM.ATTR_FREEDTYTOTAMNT, ColumnDef.TYPE_LONG , 80, false, true, true){
    	{

    	}
    });
  
    /** column 세금총액 : txTotAmnt */
    listColumnDefs.add(new ColumnDef("세금", Payr0301BM.ATTR_TXTOTAMNT, ColumnDef.TYPE_LONG , 80, false, true, true){
    	{

    	}
    });
//    /** column 퇴직금지급여부 : sevePayPymtYn */
//    listColumnDefs.add(new ColumnDef("퇴직금지급여부", Payr0301BM.ATTR_SEVEPAYPYMTYN, ColumnDef.TYPE_STRING , 90, false, false, true){
//    	{
//
//    	}
//    });
    /** column 실지급액 : pernPymtSum */
    listColumnDefs.add(new ColumnDef("지급금액", Payr0301BM.ATTR_PERNPYMTSUM, ColumnDef.TYPE_LONG , 90, false, true, true){
    	{

    	}
    });
    /** column 기본급 : pymtB10100Sum */
    listColumnDefs.add(new ColumnDef("기본급", Payr0301BM.ATTR_PYMTB10100SUM, ColumnDef.TYPE_LONG , 90, false, false, true){
    	{

    	}
    });
    
    /** column 소득세 : pymtT10100Sum */
    listColumnDefs.add(new ColumnDef("소득세", Payr0301BM.ATTR_PYMTT10100SUM, ColumnDef.TYPE_LONG , 90, false, false, true){
    	{

    	}
    });
    
    /** column 주민세  : pymtT20100Sum */
    listColumnDefs.add(new ColumnDef("주민세", Payr0301BM.ATTR_PYMTT20100SUM, ColumnDef.TYPE_LONG , 90, false, false, true){
    	{

    	}
    });
    
    /** column 소득세징수비율 : incmTxCllnRto */
    listColumnDefs.add(new ColumnDef("소득세징수비율", Payr0301BM.ATTR_INCMTXCLLNRTO, ColumnDef.TYPE_DOUBLE , 90, false, false, true){
    	{

    	}
    });
    
    /** column 급여마감일자 : payDdlneDt */
    listColumnDefs.add(new ColumnDef("마감일자", Payr0301BM.ATTR_PAYDDLNEDT, ColumnDef.TYPE_STRING , 90, false, false, true){
    	{

    	}
    });
    /** column 급여마감여부 : payDdlneYn */
    listColumnDefs.add(new ColumnDef("마감여부", Payr0301BM.ATTR_PAYDDLNEYN, ColumnDef.TYPE_STRING , 90, false, false, true){
    	{

    	}
    });
     
    /** column 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
    listColumnDefs.add(new ColumnDef("추가소득세적용비율코드", Payr0304BM.ATTR_ADDINCMTXAPPTNRTOCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    	{

    	}
    });
    /** column 추가소득세적용년월 : addIncmTxApptnYrMnth */
    listColumnDefs.add(new ColumnDef("추가소득세적용년월", Payr0304BM.ATTR_ADDINCMTXAPPTNYRMNTH, ColumnDef.TYPE_STRING , 90, true, false, true){
    	{

    	}
    });
  
    
    return listColumnDefs;
}
}
