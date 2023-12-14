/**
 * 공통화면 팝업 
 */
package com.app.exterms.payroll.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0410BM;
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
public class Payr0417Def  extends TableDef implements PayrDaoConstants {

	private int row = 0;
	private PayrConstants PayrLabel = PayrConstants.INSTANCE;

	public Payr0417Def(String chkDef){

		if("".equals(chkDef)){
 
			setTitle("");
			setDaoClass(CLASS_PAYR0416_DATA_LIST);
			setCustomListMethod(CLASS_PAYR0416_DATA_LIST);
			setAutoFillGrid(true);
			setShowFilterToolbar(false);
			// setCustomListMethod(SysConfiguration.CUSTOM_SERVICE_SKIP_CALL);
			setCheckBoxOnGridRows(true);
			setColumnsDefinition(getPayr5250ToPayr0417());
			
		}else if("PAYR5250".equals(chkDef)){
 
			setTitle("");
			setDaoClass(CLASS_PAYR0417_DATA_LIST);
			setCustomListMethod(CLASS_PAYR0417_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			// setCustomListMethod(SysConfiguration.CUSTOM_SERVICE_SKIP_CALL);
			setCheckBoxOnGridRows(false);
			setColumnsDefinition(getPayr5250ToPayr0417());
			
		}else if("POPUP_PAYR525003_PAYR0417_COPY_1".equals(chkDef)){
			 
			setTitle("");
			setDaoClass(CLASS_PAYR525003_PAYR0417_DATA_LIST);
			setCustomListMethod(CLASS_PAYR525003_PAYR0417_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			// setCustomListMethod(SysConfiguration.CUSTOM_SERVICE_SKIP_CALL);
			setCheckBoxOnGridRows(true);
			setColumnsDefinition(getPayr525003ToPayr0417());
			
		}else if("POPUP_PAYR525003_PAYR0417_COPY_2".equals(chkDef)){
			 
			setTitle("");
			setDaoClass(CLASS_PAYR525003_PAYR0417_DATA_LIST);
			setCustomListMethod(CLASS_PAYR525003_PAYR0417_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			// setCustomListMethod(SysConfiguration.CUSTOM_SERVICE_SKIP_CALL);
			setCheckBoxOnGridRows(true);
			setColumnsDefinition(getPayr525003ToPayr0417());
			
		}
		
		
		
		
	}

	public List<ColumnDef> getPayr5250ToPayr0417(){


		List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 	
		
		
        /** column 급여구분 : payNm */
        listColumnDefs.add(new ColumnDef("급여구분", Payr0410BM.ATTR_PAYNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
        
	    /** column 급여항목코드 : payrImcd */
	    listColumnDefs.add(new ColumnDef("항목코드", Payr0417BM.ATTR_PAYRIMCD, ColumnDef.TYPE_STRING , 90, true, true, true){
	    	{

	    	}
	    });
	    /** column 항목명 : itemNm */
	    listColumnDefs.add(new ColumnDef("항목명", Payr0417BM.ATTR_ITEMNM, ColumnDef.TYPE_STRING , 90, true, true, true){
	    	{

	    	}
	    });
	    
	    
	    
	    /** column 지급공제구분 : pymtDducDivNm */
        listColumnDefs.add(new ColumnDef("지급공제구분", Payr0417BM.ATTR_PYMTDDUCDIVNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });

        

        /** column 지급공제유형 : pymtDducFrmNm */
        listColumnDefs.add(new ColumnDef("지급공제유형", Payr0417BM.ATTR_PYMTDDUCFRMNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });

	    /** column 지급공제액 : pymtDducSum */
	    listColumnDefs.add(new ColumnDef("지급공제액", Payr0417BM.ATTR_PYMTDDUCSUM, ColumnDef.TYPE_LONG , 90, true, true, true){
	    	{

	    	}
	    });

	    /** column 지급공제율 : pymtDducRate */
	    listColumnDefs.add(new ColumnDef("지급공제율", Payr0417BM.ATTR_PYMTDDUCRATE, ColumnDef.TYPE_DOUBLE , 90, true, true, true){
	    	{

	    	}
	    });
	    
        /** column 과세구분 : txtnDivNm */
        listColumnDefs.add(new ColumnDef("과세구분", Payr0410BM.ATTR_TXTNDIVNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
	    
	    
        
      
	    /** column 비과세금액 : freeDtySum */
	    listColumnDefs.add(new ColumnDef("비과세금액", Payr0417BM.ATTR_FREEDTYSUM, ColumnDef.TYPE_LONG , 90, true, true, true){
	    	{

	    	}
	    });
        
	    
	    /** column 비과세율 : freeDtyRate */
	    listColumnDefs.add(new ColumnDef("비과세율", Payr0417BM.ATTR_FREEDTYRATE, ColumnDef.TYPE_DOUBLE , 90, true, true, true){
	    	{

	    	}
	    });
	    
	    /** column 급여항목사용여부 : payItemUseYn */
	    listColumnDefs.add(new ColumnDef("사용여부", Payr0417BM.ATTR_PAYITEMUSEYN, ColumnDef.TYPE_BOOLEAN, 90, true, true, true){
	    	{

	    	}
	    });
	    
	    
	    /** column 항목적용시작일자 : itemApptnBgnnDt */
	    listColumnDefs.add(new ColumnDef("시작일자", Payr0417BM.ATTR_ITEMAPPTNBGNNDT, ColumnDef.TYPE_STRING , 90, true, true, true){
	    	{

	    	}
	    });
	    /** column 항목적용종료일자 : itemApptnEndDt */
	    listColumnDefs.add(new ColumnDef("종료일자", Payr0417BM.ATTR_ITEMAPPTNENDDT, ColumnDef.TYPE_STRING , 90, true, true, true){
	    	{

	    	}
	    });
	    
        /** column 일월액구분 : dayMnthAmntDivNm */
        listColumnDefs.add(new ColumnDef("일월액구분", Payr0417BM.ATTR_DAYMNTHAMNTDIVNM, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{

        	}
        });
        
        /** column 계산기준구분 : calcStdDivNm */
        listColumnDefs.add(new ColumnDef("계산기준구분", Payr0410BM.ATTR_CALCSTDDIVNM, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{

        	}
        });
	    
        
        
	    /** column 통상임금여부 : usalyAmntYn */
	    listColumnDefs.add(new ColumnDef("통상임금", Payr0417BM.ATTR_USALYAMNTYN, ColumnDef.TYPE_BOOLEAN , 80, true, true, true){
	    	{

	    	}
	    });
        

		  /** column 급여년도 : payYr */
	    listColumnDefs.add(new ColumnDef("급여년도", Payr0417BM.ATTR_PAYYR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 사업장코드 : dpobCd */
	    listColumnDefs.add(new ColumnDef("사업장코드", Payr0417BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 급여일용단가항목일련번호 : itemDlySeilNum */
	    listColumnDefs.add(new ColumnDef("급여일용단가항목일련번호", Payr0417BM.ATTR_ITEMDLYSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 직종세단가항목일련번호 : dtilOccuDlySeilNum */
	    listColumnDefs.add(new ColumnDef("직종세단가항목일련번호", Payr0417BM.ATTR_DTILOCCUDLYSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 급여관리부서코드 : payrMangDeptCd */
	    listColumnDefs.add(new ColumnDef("급여관리부서코드", Payr0417BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });

	    /** column 급여구분코드 : payCd */
	    listColumnDefs.add(new ColumnDef("급여구분코드", Payr0417BM.ATTR_PAYCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 지급공제구분코드 : pymtDducDivCd */
	    listColumnDefs.add(new ColumnDef("지급공제구분코드", Payr0417BM.ATTR_PYMTDDUCDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 지급공제유형코드 : pymtDducFrmCd */
	    listColumnDefs.add(new ColumnDef("지급공제유형코드", Payr0417BM.ATTR_PYMTDDUCFRMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });

	    /** column 과세구분코드 : txtnDivCd */
	    listColumnDefs.add(new ColumnDef("과세구분코드", Payr0417BM.ATTR_TXTNDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });

	    /** column 1월 : jan */
	    listColumnDefs.add(new ColumnDef("1월", Payr0417BM.ATTR_JAN, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 2월 : feb */
	    listColumnDefs.add(new ColumnDef("2월", Payr0417BM.ATTR_FEB, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 3월 : mar */
	    listColumnDefs.add(new ColumnDef("3월", Payr0417BM.ATTR_MAR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 4월 : apr */
	    listColumnDefs.add(new ColumnDef("4월", Payr0417BM.ATTR_APR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 5월 : may */
	    listColumnDefs.add(new ColumnDef("5월", Payr0417BM.ATTR_MAY, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 6월 : jun */
	    listColumnDefs.add(new ColumnDef("6월", Payr0417BM.ATTR_JUN, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 7월 : jul */
	    listColumnDefs.add(new ColumnDef("7월", Payr0417BM.ATTR_JUL, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 8월 : aug */
	    listColumnDefs.add(new ColumnDef("8월", Payr0417BM.ATTR_AUG, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 9월 : sep */
	    listColumnDefs.add(new ColumnDef("9월", Payr0417BM.ATTR_SEP, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 10월 : oct */
	    listColumnDefs.add(new ColumnDef("10월", Payr0417BM.ATTR_OCT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 11월 : nov */
	    listColumnDefs.add(new ColumnDef("11월", Payr0417BM.ATTR_NOV, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 12월 : dec */
	    listColumnDefs.add(new ColumnDef("12월", Payr0417BM.ATTR_DEC, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 정렬순서 : rngeOrd */
	    listColumnDefs.add(new ColumnDef("정렬순서", Payr0417BM.ATTR_RNGEORD, ColumnDef.TYPE_LONG , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 금액타항목동일적용여부 : sumOhrItemApptnYn */
	    listColumnDefs.add(new ColumnDef("금액타항목동일적용여부", Payr0417BM.ATTR_SUMOHRITEMAPPTNYN, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });

	    /** column 일월액구분코드 : dayMnthAmntDivCd */
	    listColumnDefs.add(new ColumnDef("일월액구분코드", Payr0417BM.ATTR_DAYMNTHAMNTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 계산기준구분코드 : calcStdDivCd */
	    listColumnDefs.add(new ColumnDef("계산기준구분코드", Payr0417BM.ATTR_CALCSTDDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 계산수식내용 : calcStdFunc */
	    listColumnDefs.add(new ColumnDef("계산수식내용", Payr0417BM.ATTR_CALCSTDFUNC, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 고용구분코드 : emymtDivCd */
	    listColumnDefs.add(new ColumnDef("고용구분코드", Payr0417BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });

	    /** column 급여항목비고내용 : payItemNoteCtnt */
	    listColumnDefs.add(new ColumnDef("급여항목비고내용", Payr0417BM.ATTR_PAYITEMNOTECTNT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
//	    /** column 입력자 : kybdr */
//	    listColumnDefs.add(new ColumnDef("입력자", Payr0417BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//	    	{
//
//	    	}
//	    });
//	    /** column 입력일자 : inptDt */
//	    listColumnDefs.add(new ColumnDef("입력일자", Payr0417BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//	    	{
//
//	    	}
//	    });
//	    /** column 입력주소 : inptAddr */
//	    listColumnDefs.add(new ColumnDef("입력주소", Payr0417BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//	    	{
//
//	    	}
//	    });
//	    /** column 수정자 : ismt */
//	    listColumnDefs.add(new ColumnDef("수정자", Payr0417BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
//	    	{
//
//	    	}
//	    });
//	    /** column 수정일자 : revnDt */
//	    listColumnDefs.add(new ColumnDef("수정일자", Payr0417BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//	    	{
//
//	    	}
//	    });
//	    /** column 수정주소 : revnAddr */
//	    listColumnDefs.add(new ColumnDef("수정주소", Payr0417BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//	    	{
//
//	    	}
//	    });

//	    private TextField<String> payYr;   /** column 급여년도 : payYr */
//
//	    private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//	    private TextField<String> itemDlySeilNum;   /** column 급여일용단가항목일련번호 : itemDlySeilNum */
//
//	    private TextField<String> dtilOccuDlySeilNum;   /** column 직종세단가항목일련번호 : dtilOccuDlySeilNum */
//
//	    private TextField<String> payrMangDeptCd;   /** column 급여관리부서코드 : payrMangDeptCd */
//
//	    private TextField<String> payrImcd;   /** column 급여항목코드 : payrImcd */
//
//	    private TextField<String> itemNm;   /** column 항목명 : itemNm */
//
//	    private TextField<String> payCd;   /** column 급여구분코드 : payCd */
//
//	    private TextField<String> pymtDducDivCd;   /** column 지급공제구분코드 : pymtDducDivCd */
//
//	    private TextField<String> pymtDducFrmCd;   /** column 지급공제유형코드 : pymtDducFrmCd */
//
//	    private TextField<String> pymtDducRate;   /** column 지급공제율 : pymtDducRate */
//
//	    private TextField<String> pymtDducSum;   /** column 지급공제액 : pymtDducSum */
//
//	    private TextField<String> txtnDivCd;   /** column 과세구분코드 : txtnDivCd */
//
//	    private TextField<String> freeDtyRate;   /** column 비과세율 : freeDtyRate */
//
//	    private TextField<String> freeDtySum;   /** column 비과세금액 : freeDtySum */
//
//	    private TextField<String> jan;   /** column 1월 : jan */
//
//	    private TextField<String> feb;   /** column 2월 : feb */
//
//	    private TextField<String> mar;   /** column 3월 : mar */
//
//	    private TextField<String> apr;   /** column 4월 : apr */
//
//	    private TextField<String> may;   /** column 5월 : may */
//
//	    private TextField<String> jun;   /** column 6월 : jun */
//
//	    private TextField<String> jul;   /** column 7월 : jul */
//
//	    private TextField<String> aug;   /** column 8월 : aug */
//
//	    private TextField<String> sep;   /** column 9월 : sep */
//
//	    private TextField<String> oct;   /** column 10월 : oct */
//
//	    private TextField<String> nov;   /** column 11월 : nov */
//
//	    private TextField<String> dec;   /** column 12월 : dec */
//
//	    private TextField<String> rngeOrd;   /** column 정렬순서 : rngeOrd */
//
//	    private TextField<String> sumOhrItemApptnYn;   /** column 금액타항목동일적용여부 : sumOhrItemApptnYn */
//
//	    private TextField<String> payItemUseYn;   /** column 급여항목사용여부 : payItemUseYn */
//
//	    private TextField<String> itemApptnBgnnDt;   /** column 항목적용시작일자 : itemApptnBgnnDt */
//
//	    private TextField<String> itemApptnEndDt;   /** column 항목적용종료일자 : itemApptnEndDt */
//
//	    private TextField<String> dayMnthAmntDivCd;   /** column 일월액구분코드 : dayMnthAmntDivCd */
//
//	    private TextField<String> calcStdDivCd;   /** column 계산기준구분코드 : calcStdDivCd */
//
//	    private TextField<String> calcStdFunc;   /** column 계산수식내용 : calcStdFunc */
//
//	    private TextField<String> emymtDivCd;   /** column 고용구분코드 : emymtDivCd */
//
//	    private TextField<String> usalyAmntYn;   /** column 통상임금여부 : usalyAmntYn */
//
//	    private TextField<String> payItemNoteCtnt;   /** column 급여항목비고내용 : payItemNoteCtnt */
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
	
	public List<ColumnDef> getPayr525003ToPayr0417(){


		List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 	
		
		
        /** column 급여구분 : payNm */
        listColumnDefs.add(new ColumnDef("급여구분", Payr0410BM.ATTR_PAYNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
        
	    /** column 급여항목코드 : payrImcd */
	    listColumnDefs.add(new ColumnDef("항목코드", Payr0417BM.ATTR_PAYRIMCD, ColumnDef.TYPE_STRING , 90, true, true, true){
	    	{

	    	}
	    });
	    /** column 항목명 : itemNm */
	    listColumnDefs.add(new ColumnDef("항목명", Payr0417BM.ATTR_ITEMNM, ColumnDef.TYPE_STRING , 90, true, true, true){
	    	{

	    	}
	    });
	    
	    
	    
	    /** column 지급공제구분 : pymtDducDivNm */
        listColumnDefs.add(new ColumnDef("지급공제구분", Payr0417BM.ATTR_PYMTDDUCDIVNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });

        

        /** column 지급공제유형 : pymtDducFrmNm */
        listColumnDefs.add(new ColumnDef("지급공제유형", Payr0417BM.ATTR_PYMTDDUCFRMNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });

	    /** column 지급공제액 : pymtDducSum */
	    listColumnDefs.add(new ColumnDef("지급공제액", Payr0417BM.ATTR_PYMTDDUCSUM, ColumnDef.TYPE_LONG , 90, true, true, true){
	    	{

	    	}
	    });

	    /** column 지급공제율 : pymtDducRate */
	    listColumnDefs.add(new ColumnDef("지급공제율", Payr0417BM.ATTR_PYMTDDUCRATE, ColumnDef.TYPE_DOUBLE , 90, true, true, true){
	    	{

	    	}
	    });
	    
        /** column 과세구분 : txtnDivNm */
        listColumnDefs.add(new ColumnDef("과세구분", Payr0410BM.ATTR_TXTNDIVNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
	    
	    
        
      
	    /** column 비과세금액 : freeDtySum */
	    listColumnDefs.add(new ColumnDef("비과세금액", Payr0417BM.ATTR_FREEDTYSUM, ColumnDef.TYPE_LONG , 90, true, true, true){
	    	{

	    	}
	    });
        
	    
	    /** column 비과세율 : freeDtyRate */
	    listColumnDefs.add(new ColumnDef("비과세율", Payr0417BM.ATTR_FREEDTYRATE, ColumnDef.TYPE_DOUBLE , 90, true, true, true){
	    	{

	    	}
	    });
	    
	    /** column 급여항목사용여부 : payItemUseYn */
	    listColumnDefs.add(new ColumnDef("사용여부", Payr0417BM.ATTR_PAYITEMUSEYN, ColumnDef.TYPE_BOOLEAN, 90, true, true, true){
	    	{

	    	}
	    });
	    
	    
	    /** column 항목적용시작일자 : itemApptnBgnnDt */
	    listColumnDefs.add(new ColumnDef("시작일자", Payr0417BM.ATTR_ITEMAPPTNBGNNDT, ColumnDef.TYPE_STRING , 90, true, true, true){
	    	{

	    	}
	    });
	    /** column 항목적용종료일자 : itemApptnEndDt */
	    listColumnDefs.add(new ColumnDef("종료일자", Payr0417BM.ATTR_ITEMAPPTNENDDT, ColumnDef.TYPE_STRING , 90, true, true, true){
	    	{

	    	}
	    });
	    
        /** column 일월액구분 : dayMnthAmntDivNm */
        listColumnDefs.add(new ColumnDef("일월액구분", Payr0417BM.ATTR_DAYMNTHAMNTDIVNM, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{

        	}
        });
        
        /** column 계산기준구분 : calcStdDivNm */
        listColumnDefs.add(new ColumnDef("계산기준구분", Payr0410BM.ATTR_CALCSTDDIVNM, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{

        	}
        });
	    
        
        
	    /** column 통상임금여부 : usalyAmntYn */
	    listColumnDefs.add(new ColumnDef("통상임금", Payr0417BM.ATTR_USALYAMNTYN, ColumnDef.TYPE_BOOLEAN , 80, true, true, true){
	    	{

	    	}
	    });
        

		  /** column 급여년도 : payYr */
	    listColumnDefs.add(new ColumnDef("급여년도", Payr0417BM.ATTR_PAYYR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 사업장코드 : dpobCd */
	    listColumnDefs.add(new ColumnDef("사업장코드", Payr0417BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 급여일용단가항목일련번호 : itemDlySeilNum */
	    listColumnDefs.add(new ColumnDef("급여일용단가항목일련번호", Payr0417BM.ATTR_ITEMDLYSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 직종세단가항목일련번호 : dtilOccuDlySeilNum */
	    listColumnDefs.add(new ColumnDef("직종세단가항목일련번호", Payr0417BM.ATTR_DTILOCCUDLYSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 급여관리부서코드 : payrMangDeptCd */
	    listColumnDefs.add(new ColumnDef("급여관리부서코드", Payr0417BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });

	    /** column 급여구분코드 : payCd */
	    listColumnDefs.add(new ColumnDef("급여구분코드", Payr0417BM.ATTR_PAYCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 지급공제구분코드 : pymtDducDivCd */
	    listColumnDefs.add(new ColumnDef("지급공제구분코드", Payr0417BM.ATTR_PYMTDDUCDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 지급공제유형코드 : pymtDducFrmCd */
	    listColumnDefs.add(new ColumnDef("지급공제유형코드", Payr0417BM.ATTR_PYMTDDUCFRMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });

	    /** column 과세구분코드 : txtnDivCd */
	    listColumnDefs.add(new ColumnDef("과세구분코드", Payr0417BM.ATTR_TXTNDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });

	    /** column 1월 : jan */
	    listColumnDefs.add(new ColumnDef("1월", Payr0417BM.ATTR_JAN, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 2월 : feb */
	    listColumnDefs.add(new ColumnDef("2월", Payr0417BM.ATTR_FEB, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 3월 : mar */
	    listColumnDefs.add(new ColumnDef("3월", Payr0417BM.ATTR_MAR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 4월 : apr */
	    listColumnDefs.add(new ColumnDef("4월", Payr0417BM.ATTR_APR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 5월 : may */
	    listColumnDefs.add(new ColumnDef("5월", Payr0417BM.ATTR_MAY, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 6월 : jun */
	    listColumnDefs.add(new ColumnDef("6월", Payr0417BM.ATTR_JUN, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 7월 : jul */
	    listColumnDefs.add(new ColumnDef("7월", Payr0417BM.ATTR_JUL, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 8월 : aug */
	    listColumnDefs.add(new ColumnDef("8월", Payr0417BM.ATTR_AUG, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 9월 : sep */
	    listColumnDefs.add(new ColumnDef("9월", Payr0417BM.ATTR_SEP, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 10월 : oct */
	    listColumnDefs.add(new ColumnDef("10월", Payr0417BM.ATTR_OCT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 11월 : nov */
	    listColumnDefs.add(new ColumnDef("11월", Payr0417BM.ATTR_NOV, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 12월 : dec */
	    listColumnDefs.add(new ColumnDef("12월", Payr0417BM.ATTR_DEC, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 정렬순서 : rngeOrd */
	    listColumnDefs.add(new ColumnDef("정렬순서", Payr0417BM.ATTR_RNGEORD, ColumnDef.TYPE_LONG , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 금액타항목동일적용여부 : sumOhrItemApptnYn */
	    listColumnDefs.add(new ColumnDef("금액타항목동일적용여부", Payr0417BM.ATTR_SUMOHRITEMAPPTNYN, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });

	    /** column 일월액구분코드 : dayMnthAmntDivCd */
	    listColumnDefs.add(new ColumnDef("일월액구분코드", Payr0417BM.ATTR_DAYMNTHAMNTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 계산기준구분코드 : calcStdDivCd */
	    listColumnDefs.add(new ColumnDef("계산기준구분코드", Payr0417BM.ATTR_CALCSTDDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 계산수식내용 : calcStdFunc */
	    listColumnDefs.add(new ColumnDef("계산수식내용", Payr0417BM.ATTR_CALCSTDFUNC, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
	    /** column 고용구분코드 : emymtDivCd */
	    listColumnDefs.add(new ColumnDef("고용구분코드", Payr0417BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });

	    /** column 급여항목비고내용 : payItemNoteCtnt */
	    listColumnDefs.add(new ColumnDef("급여항목비고내용", Payr0417BM.ATTR_PAYITEMNOTECTNT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{

	    	}
	    });
//	    /** column 입력자 : kybdr */
//	    listColumnDefs.add(new ColumnDef("입력자", Payr0417BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//	    	{
//
//	    	}
//	    });
//	    /** column 입력일자 : inptDt */
//	    listColumnDefs.add(new ColumnDef("입력일자", Payr0417BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//	    	{
//
//	    	}
//	    });
//	    /** column 입력주소 : inptAddr */
//	    listColumnDefs.add(new ColumnDef("입력주소", Payr0417BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//	    	{
//
//	    	}
//	    });
//	    /** column 수정자 : ismt */
//	    listColumnDefs.add(new ColumnDef("수정자", Payr0417BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
//	    	{
//
//	    	}
//	    });
//	    /** column 수정일자 : revnDt */
//	    listColumnDefs.add(new ColumnDef("수정일자", Payr0417BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//	    	{
//
//	    	}
//	    });
//	    /** column 수정주소 : revnAddr */
//	    listColumnDefs.add(new ColumnDef("수정주소", Payr0417BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//	    	{
//
//	    	}
//	    });

//	    private TextField<String> payYr;   /** column 급여년도 : payYr */
//
//	    private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//	    private TextField<String> itemDlySeilNum;   /** column 급여일용단가항목일련번호 : itemDlySeilNum */
//
//	    private TextField<String> dtilOccuDlySeilNum;   /** column 직종세단가항목일련번호 : dtilOccuDlySeilNum */
//
//	    private TextField<String> payrMangDeptCd;   /** column 급여관리부서코드 : payrMangDeptCd */
//
//	    private TextField<String> payrImcd;   /** column 급여항목코드 : payrImcd */
//
//	    private TextField<String> itemNm;   /** column 항목명 : itemNm */
//
//	    private TextField<String> payCd;   /** column 급여구분코드 : payCd */
//
//	    private TextField<String> pymtDducDivCd;   /** column 지급공제구분코드 : pymtDducDivCd */
//
//	    private TextField<String> pymtDducFrmCd;   /** column 지급공제유형코드 : pymtDducFrmCd */
//
//	    private TextField<String> pymtDducRate;   /** column 지급공제율 : pymtDducRate */
//
//	    private TextField<String> pymtDducSum;   /** column 지급공제액 : pymtDducSum */
//
//	    private TextField<String> txtnDivCd;   /** column 과세구분코드 : txtnDivCd */
//
//	    private TextField<String> freeDtyRate;   /** column 비과세율 : freeDtyRate */
//
//	    private TextField<String> freeDtySum;   /** column 비과세금액 : freeDtySum */
//
//	    private TextField<String> jan;   /** column 1월 : jan */
//
//	    private TextField<String> feb;   /** column 2월 : feb */
//
//	    private TextField<String> mar;   /** column 3월 : mar */
//
//	    private TextField<String> apr;   /** column 4월 : apr */
//
//	    private TextField<String> may;   /** column 5월 : may */
//
//	    private TextField<String> jun;   /** column 6월 : jun */
//
//	    private TextField<String> jul;   /** column 7월 : jul */
//
//	    private TextField<String> aug;   /** column 8월 : aug */
//
//	    private TextField<String> sep;   /** column 9월 : sep */
//
//	    private TextField<String> oct;   /** column 10월 : oct */
//
//	    private TextField<String> nov;   /** column 11월 : nov */
//
//	    private TextField<String> dec;   /** column 12월 : dec */
//
//	    private TextField<String> rngeOrd;   /** column 정렬순서 : rngeOrd */
//
//	    private TextField<String> sumOhrItemApptnYn;   /** column 금액타항목동일적용여부 : sumOhrItemApptnYn */
//
//	    private TextField<String> payItemUseYn;   /** column 급여항목사용여부 : payItemUseYn */
//
//	    private TextField<String> itemApptnBgnnDt;   /** column 항목적용시작일자 : itemApptnBgnnDt */
//
//	    private TextField<String> itemApptnEndDt;   /** column 항목적용종료일자 : itemApptnEndDt */
//
//	    private TextField<String> dayMnthAmntDivCd;   /** column 일월액구분코드 : dayMnthAmntDivCd */
//
//	    private TextField<String> calcStdDivCd;   /** column 계산기준구분코드 : calcStdDivCd */
//
//	    private TextField<String> calcStdFunc;   /** column 계산수식내용 : calcStdFunc */
//
//	    private TextField<String> emymtDivCd;   /** column 고용구분코드 : emymtDivCd */
//
//	    private TextField<String> usalyAmntYn;   /** column 통상임금여부 : usalyAmntYn */
//
//	    private TextField<String> payItemNoteCtnt;   /** column 급여항목비고내용 : payItemNoteCtnt */
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
	
 
}
