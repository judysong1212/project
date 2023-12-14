package com.app.exterms.payroll.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0416BM;
import com.app.exterms.payroll.client.dto.Payr0417BM;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr0416Def  extends TableDef implements PayrDaoConstants {

	private int row = 0;
	private PayrConstants PayrLabel = PayrConstants.INSTANCE;

	public Payr0416Def(String chkDef){

		if("".equals(chkDef)){
 
			setTitle("");
			setDaoClass(CLASS_PAYR0416_DATA_LIST);
			setCustomListMethod(CLASS_PAYR0416_DATA_LIST);
			setAutoFillGrid(true);
			setShowFilterToolbar(false);
			// setCustomListMethod(SysConfiguration.CUSTOM_SERVICE_SKIP_CALL);
			setCheckBoxOnGridRows(true);
			setColumnsDefinition(getPayr5250ToPayr0416());
			setReadOnly(true);
		} else if("PAYR5250".equals(chkDef)){
			
			setTitle("");
			setDaoClass(CLASS_PAYR0416_DATA_LIST);
			setCustomListMethod(CLASS_PAYR0416_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			// setCustomListMethod(SysConfiguration.CUSTOM_SERVICE_SKIP_CALL);
			setCheckBoxOnGridRows(true);
			setColumnsDefinition(getPayr5250ToPayr0416());
			setReadOnly(true);
			
			}else if("PAYRP525001".equals(chkDef)) {
				
				
				setTitle("");
//				setDaoClass(CLASS_PAYR0415_COPY_DATA_LIST);
				setCustomListMethod(CLASS_PAYR0416_COPY_DATA_LIST);
				setAutoFillGrid(true);
				setShowFilterToolbar(false);
				// setCustomListMethod(SysConfiguration.CUSTOM_SERVICE_SKIP_CALL);
				setCheckBoxOnGridRows(true);
				setColumnsDefinition(getPayrP525001ToPayr0416());
				
			}else if("PAYRP525002".equals(chkDef)){
				
	    		setTitle(PayrLabel.titlePayr0410());
	    		setDaoClass("");
	    		setCustomListMethod(CLASS_PAYR0416_LUMP_DATA_LIST);
	    		setAutoFillGrid(false); 
	    		setShowFilterToolbar(false);
	    		setCheckBoxOnGridRows(true);
	    		setColumnsDefinition(getPayr525002ToPayr0416());
	    		
	    	}else if("PAYRP525002TARGET".equals(chkDef)){
	    		
	    		setTitle(PayrLabel.titlePayr0410());
	    		//setDaoClass(CLASS_PAYR150002TOPAYR0410_DATA_LIST);
	    		//setCustomListMethod(CLASS_PAYR150002TOPAYR0410_DATA_LIST);
	    		setAutoFillGrid(false); 
	    		setShowFilterToolbar(false);
	    		setCheckBoxOnGridRows(true);
	    		setColumnsDefinition(getPayr520002ToTarget());
	    		
	    	}else {
				setTitle("");
				setDaoClass(CLASS_PAYR0416_DATA_LIST);
				setCustomListMethod(CLASS_PAYR0416_DATA_LIST);
				setAutoFillGrid(true);
				setShowFilterToolbar(false);
				// setCustomListMethod(SysConfiguration.CUSTOM_SERVICE_SKIP_CALL);
				setCheckBoxOnGridRows(true);
				setColumnsDefinition(getPayr5250ToPayr0416());
				setReadOnly(true);
			}
		}

	public List<ColumnDef> getPayr5250ToPayr0416(){


		List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 	


	    /** column 급여년도 : payYr */
	    listColumnDefs.add(new ColumnDef("년도", Payr0416BM.ATTR_PAYYR, ColumnDef.TYPE_STRING , 50, true, true, true){
	    	{

	    	}
	    });
	    
	    
	    /** column 직종코드 : typOccuCd */
	    listColumnDefs.add(new ColumnDef("직종", Payr0416BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING , 90, true, true, true){
	    	{

	    	}
	    });
	    /** column 호봉등급코드 : pyspGrdeCd */
	    listColumnDefs.add(new ColumnDef("호봉등급", Payr0416BM.ATTR_PYSPGRDENM, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 직종세통합코드 : dtilOccuInttnCd */
	    listColumnDefs.add(new ColumnDef("직종세", Payr0416BM.ATTR_DTILOCCUINTTNNM, ColumnDef.TYPE_STRING , 90, true, true, true){
	    	{

	    	}
	    });	    
	    
	    /** column 부서코드 : deptCd */
	    listColumnDefs.add(new ColumnDef("부서", Payr0416BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 90, true, true, true){
	    	{

	    	}
	    });   
	    
	    
	    /** column 사업장코드 : dpobCd */
	    listColumnDefs.add(new ColumnDef("사업장코드", Payr0416BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 직종세단가항목일련번호 : dtilOccuDlySeilNum */
	    listColumnDefs.add(new ColumnDef("직종세단가항목일련번호", Payr0416BM.ATTR_DTILOCCUDLYSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
	    	{

	    	}
	    });
	    
	    /** column 부서코드 : deptCd */
	    listColumnDefs.add(new ColumnDef("부서코드", Payr0416BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    
	    
	    /** column 직종코드 : typOccuCd */
	    listColumnDefs.add(new ColumnDef("직종코드", Payr0416BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 호봉등급코드 : pyspGrdeCd */
	    listColumnDefs.add(new ColumnDef("호봉등급코드", Payr0416BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 직종세통합코드 : dtilOccuInttnCd */
	    listColumnDefs.add(new ColumnDef("직종세통합코드", Payr0416BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 직종세코드 : dtilOccuClsDivCd */
	    listColumnDefs.add(new ColumnDef("직종세코드", Payr0416BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
//	    /** column 입력자 : kybdr */
//	    listColumnDefs.add(new ColumnDef("입력자", Payr0416BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//	    	{
//
//	    	}
//	    });
//	    /** column 입력일자 : inptDt */
//	    listColumnDefs.add(new ColumnDef("입력일자", Payr0416BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//	    	{
//
//	    	}
//	    });
//	    /** column 입력주소 : inptAddr */
//	    listColumnDefs.add(new ColumnDef("입력주소", Payr0416BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//	    	{
//
//	    	}
//	    });
//	    /** column 수정자 : ismt */
//	    listColumnDefs.add(new ColumnDef("수정자", Payr0416BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
//	    	{
//
//	    	}
//	    });
//	    /** column 수정일자 : revnDt */
//	    listColumnDefs.add(new ColumnDef("수정일자", Payr0416BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//	    	{
//
//	    	}
//	    });
//	    /** column 수정주소 : revnAddr */
//	    listColumnDefs.add(new ColumnDef("수정주소", Payr0416BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//	    	{
//
//	    	}
//	    });

//	    private TextField<String> payYr;   /** column 급여년도 : payYr */
//
//	    private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//	    private TextField<String> dtilOccuDlySeilNum;   /** column 직종세단가항목일련번호 : dtilOccuDlySeilNum */
//
//	    private TextField<String> typOccuCd;   /** column 직종코드 : typOccuCd */
//
//	    private TextField<String> pyspGrdeCd;   /** column 호봉등급코드 : pyspGrdeCd */
//
//	    private TextField<String> dtilOccuInttnCd;   /** column 직종세통합코드 : dtilOccuInttnCd */
//
//	    private TextField<String> dtilOccuClsDivCd;   /** column 직종세코드 : dtilOccuClsDivCd */
//
//	    private TextField<String> kybdr;   /** column 입력자 : kybdr */
//
//	    private TextField<String> inptDt;   /** column 입력일자 : inptDt */
//
//	    private TextField<String> inptAddr;   /** column 입력주소 : inptAddr */
//
//	    private TextField<String> ismt;   /** column 수정자 : ismt */
//
//	    private TextField<String> revnDt;   /** column 수정일자 : revnDt */
//
//	    private TextField<String> revnAddr;   /** column 수정주소 : revnAddr */


		return listColumnDefs;



	}
	
	
	
	public List<ColumnDef> getPayrP525001ToPayr0416(){

		List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 	
		
		
		
	    /** column 직종코드 : typOccuCd */
	    listColumnDefs.add(new ColumnDef("직종", Payr0416BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING , 90, true, true, true){
	    	{

	    	}
	    });
		
		
	    /** column 직종세통합코드 : dtilOccuInttnCd */
	    listColumnDefs.add(new ColumnDef("직종세", Payr0416BM.ATTR_DTILOCCUINTTNNM, ColumnDef.TYPE_STRING , 90, true, true, true){
	    	{

	    	}
	    });	 
		
		
		
		/** column 직종세사용여부 : dtilOccuClsUseYn */
		listColumnDefs.add(new ColumnDef("이관여부", Payr0416BM.ATTR_TRANSFER_YN, ColumnDef.TYPE_BOOLEAN , 90, true, true, true){
			{

			}
		});


	    /** column 급여년도 : payYr */
	    listColumnDefs.add(new ColumnDef("년도", Payr0416BM.ATTR_PAYYR, ColumnDef.TYPE_STRING , 60, true, false, true){
	    	{

	    	}
	    });
	    
	    /** column 부서코드 : deptCd */
	    listColumnDefs.add(new ColumnDef("부서", Payr0416BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    

	    /** column 호봉등급코드 : pyspGrdeCd */
	    listColumnDefs.add(new ColumnDef("호봉등급", Payr0416BM.ATTR_PYSPGRDENM, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
   
	    
	    
	    
	    
	    /** column 사업장코드 : dpobCd */
	    listColumnDefs.add(new ColumnDef("사업장코드", Payr0416BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 직종세단가항목일련번호 : dtilOccuDlySeilNum */
	    listColumnDefs.add(new ColumnDef("직종세단가항목일련번호", Payr0416BM.ATTR_DTILOCCUDLYSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
	    	{

	    	}
	    });
	    
	    /** column 부서코드 : deptCd */
	    listColumnDefs.add(new ColumnDef("부서코드", Payr0416BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    
	    
	    /** column 직종코드 : typOccuCd */
	    listColumnDefs.add(new ColumnDef("직종코드", Payr0416BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 호봉등급코드 : pyspGrdeCd */
	    listColumnDefs.add(new ColumnDef("호봉등급코드", Payr0416BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 직종세통합코드 : dtilOccuInttnCd */
	    listColumnDefs.add(new ColumnDef("직종세통합코드", Payr0416BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 직종세코드 : dtilOccuClsDivCd */
	    listColumnDefs.add(new ColumnDef("직종세코드", Payr0416BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });


		return listColumnDefs;

	}
	
	
	/** 직종세항목생성내역 **/
 	public List<ColumnDef> getPayr525002ToPayr0416(){

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        
        /** set 급여항목코드 : payrImcd */
        listColumnDefs.add(new ColumnDef("항목코드", Payr0417BM.ATTR_PAYRIMCD, ColumnDef.TYPE_STRING, 60, true, true, true){
        	{

        	}
        });
        
        
        /** column 항목명 : itemNm */
        listColumnDefs.add(new ColumnDef("항목명", Payr0417BM.ATTR_ITEMNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
        
        
        /** column 급여구분 : payNm */
        listColumnDefs.add(new ColumnDef("급여구분", Payr0417BM.ATTR_PAYNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
        
	    /** column 부서코드 : deptCd */
	    listColumnDefs.add(new ColumnDef("부서", Payr0416BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 90, true, true, true){
	    	{

	    	}
	    });

        
        /** column 직종코드 : typOccuNm */
        listColumnDefs.add(new ColumnDef("직종", Payr0416BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
        
        /** column 직종세통합코드 : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세", Payr0416BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });  
        
        /** column 급여항목사용여부 : payItemUseYn */
        listColumnDefs.add(new ColumnDef("생성여부", Payr0416BM.ATTR_CREATEYN, ColumnDef.TYPE_BOOLEAN, 60, true, true, true){
        	{

        	}
        });
        
        
        
        
          
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0416BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });

        /** column 급여년도 : payYr */
        listColumnDefs.add(new ColumnDef("급여년도", Payr0416BM.ATTR_PAYYR, ColumnDef.TYPE_STRING , 90, true, false, true){
            {
        
            }
        });
         
	    /** column 직종세단가항목일련번호 : dtilOccuDlySeilNum */
	    listColumnDefs.add(new ColumnDef("직종세단가항목일련번호", Payr0416BM.ATTR_DTILOCCUDLYSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
	    	{

	    	}
	    });
	    
	    
	    /** set 급여일용단가항목일련번호 : itemDlySeilNum */
        listColumnDefs.add(new ColumnDef("급여일용단가항목일련번호", Payr0417BM.ATTR_ITEMDLYSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
            {
        
            }
        });

        
		/** column 부서코드 : deptCd */
	    listColumnDefs.add(new ColumnDef("부서코드", Payr0416BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
        
        
        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종코드", Payr0416BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        
        
        /** column 직종세코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세코드", Payr0416BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        
        /** column 직종세통합코드 : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세통합코드", Payr0416BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });    
        
             
        
        return listColumnDefs;
    }
 	
 	
	/** 직종세항목생성대상 **/
 	public List<ColumnDef> getPayr520002ToTarget(){

        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
          
        /** set 급여항목코드 : payrImcd */
        listColumnDefs.add(new ColumnDef("항목코드", Payr0417BM.ATTR_PAYRIMCD, ColumnDef.TYPE_STRING, 60, true, true, true){
        	{

        	}
        });
        
        
        /** column 항목명 : itemNm */
        listColumnDefs.add(new ColumnDef("항목명", Payr0417BM.ATTR_ITEMNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
        
        
        /** column 급여구분 : payNm */
        listColumnDefs.add(new ColumnDef("급여구분", Payr0417BM.ATTR_PAYNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
        
	    /** column 부서코드 : deptCd */
	    listColumnDefs.add(new ColumnDef("부서", Payr0416BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 90, true, true, true){
	    	{

	    	}
	    });

        
        /** column 직종코드 : typOccuNm */
        listColumnDefs.add(new ColumnDef("직종", Payr0416BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
        
        /** column 직종세통합코드 : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세", Payr0416BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });    
        
        
        
          
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0416BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });

        /** column 급여년도 : payYr */
        listColumnDefs.add(new ColumnDef("급여년도", Payr0416BM.ATTR_PAYYR, ColumnDef.TYPE_STRING , 90, true, false, true){
            {
        
            }
        });
         
	    /** column 직종세단가항목일련번호 : dtilOccuDlySeilNum */
	    listColumnDefs.add(new ColumnDef("직종세단가항목일련번호", Payr0416BM.ATTR_DTILOCCUDLYSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
	    	{

	    	}
	    });
	    
	    
	    /** set 급여일용단가항목일련번호 : itemDlySeilNum */
        listColumnDefs.add(new ColumnDef("급여일용단가항목일련번호", Payr0417BM.ATTR_ITEMDLYSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
            {
        
            }
        });

        
		/** column 부서코드 : deptCd */
	    listColumnDefs.add(new ColumnDef("부서코드", Payr0416BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
        
        
        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종코드", Payr0416BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        
        
        /** column 직종세코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세코드", Payr0416BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        
        /** column 직종세통합코드 : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세통합코드", Payr0416BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });    
        
        
        return listColumnDefs;
        
        
    }
 	
 	
 	
 	
	
	
	
 
}
