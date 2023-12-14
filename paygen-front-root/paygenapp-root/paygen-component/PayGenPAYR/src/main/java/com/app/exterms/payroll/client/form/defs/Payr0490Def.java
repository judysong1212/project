/**
 * 공통화면 팝업 
 */
package com.app.exterms.payroll.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0490BM;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr0490Def  extends TableDef implements PayrDaoConstants {

	private int row = 0;
	private PayrConstants PayrLabel = PayrConstants.INSTANCE;

	public Payr0490Def(String chkDef){

		if ("PAYR5300_PAYR0490_LIST".equals(chkDef)) {

			setTitle(PayrLabel.titlePayr0490());
			setDaoClass(CLASS_PAYR0490_DATA_LIST);
			setCustomListMethod(CLASS_PAYR0490_DATA_LIST);
			setAutoFillGrid(false); 
			setShowFilterToolbar(false);

			setColumnsDefinition(getPayr5300ToPayr0490Def());
		}else if("POPUP_PAYR530002_PAYR0490_COPY_1".equals(chkDef)){
			setTitle(PayrLabel.titlePayr0490());
			setDaoClass(POPUP_PAYR530002_PAYR0490_DATA_LIST);
			setCustomListMethod(POPUP_PAYR530002_PAYR0490_DATA_LIST);
			setAutoFillGrid(false); 
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true); 

			setColumnsDefinition(getPayr530002ToPayr0490Def());
			
		}else if("POPUP_PAYR530002_PAYR0490_COPY_2".equals(chkDef)){
			setTitle(PayrLabel.titlePayr0490());
			setDaoClass(POPUP_PAYR530002_PAYR0490_DATA_LIST);
			setCustomListMethod(POPUP_PAYR530002_PAYR0490_DATA_LIST);
			setAutoFillGrid(false); 
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true); 

			setColumnsDefinition(getPayr530002ToPayr0490Def());			
		}
		

	}

	private List<ColumnDef> getPayr5300ToPayr0490Def() {

		List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 


		/** column 급여구분코드 : payCd */
		listColumnDefs.add(new ColumnDef("급여구분코드", Payr0490BM.ATTR_PAYCD, ColumnDef.TYPE_STRING, 90, false, false, true){
			{

			}
		}); 


		/** column 급여구분 : payNm */
		listColumnDefs.add(new ColumnDef("급여구분", Payr0490BM.ATTR_PAYNM, ColumnDef.TYPE_STRING, 80, true, true, true){
			{

			}
		});

		/** column 급여항목코드 : payItemCd */
		listColumnDefs.add(new ColumnDef("항목코드", Payr0490BM.ATTR_PAYITEMCD, ColumnDef.TYPE_STRING, 80, true, true, true){
			{

			}
		});


		/** column 항목명 : itemNm */
		listColumnDefs.add(new ColumnDef("항목명", Payr0490BM.ATTR_ITEMNM, ColumnDef.TYPE_STRING, 90, true, true, true){
			{

			}
		});

		/** column 계산기준구분코드 : calcStdDivCd */
		listColumnDefs.add(new ColumnDef("계산기준구분코드", Payr0490BM.ATTR_CALCSTDDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
			{

			}
		});


		/** column 계산기준구분 : calcStdDivNm */
		listColumnDefs.add(new ColumnDef("계산기준구분", Payr0490BM.ATTR_CALCSTDDIVNM, ColumnDef.TYPE_STRING, 90, true, true, true){
			{

			}
		});
		/** column 통상임금여부 : usalyAmntYn */
		listColumnDefs.add(new ColumnDef("통상임금", Payr0490BM.ATTR_USALYAMNTYN, ColumnDef.TYPE_BOOLEAN, 90, true, true, true){
			{

			}
		});

		/** column 지급공제구분코드 : pymtDducDivCd */
		listColumnDefs.add(new ColumnDef("지급공제구분코드", Payr0490BM.ATTR_PYMTDDUCDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
			{

			}
		});


		/** column 지급공제구분 : pymtDducDivNm */
		listColumnDefs.add(new ColumnDef("지급공제구분", Payr0490BM.ATTR_PYMTDDUCDIVNM, ColumnDef.TYPE_STRING, 90, true, true, true){
			{

			}
		});

		/** column 지급공제유형코드 : pymtDducFrmCd */
		listColumnDefs.add(new ColumnDef("지급공제유형코드", Payr0490BM.ATTR_PYMTDDUCFRMCD, ColumnDef.TYPE_STRING, 90, false, false, true){
			{

			}
		}); 


		/** column 지급공제유형 : pymtDducFrmNm */
		listColumnDefs.add(new ColumnDef("지급공제유형", Payr0490BM.ATTR_PYMTDDUCFRMNM, ColumnDef.TYPE_STRING, 90, true, true, true){
			{

			}
		});

		/** column 지급공제율 : pymtDducRate */
		listColumnDefs.add(new ColumnDef("지급공제율", Payr0490BM.ATTR_PYMTDDUCRATE, ColumnDef.TYPE_DOUBLE, 90, true, true, true){
			{

			}
		});
		/** column 지급공제액 : pymtDducSum */
		listColumnDefs.add(new ColumnDef("지급공제액", Payr0490BM.ATTR_PYMTDDUCSUM, ColumnDef.TYPE_LONG, 90, true, true, true){
			{

			}
		});
		/** column 과세구분코드 : txtnDivCd */
		listColumnDefs.add(new ColumnDef("과세구분코드", Payr0490BM.ATTR_TXTNDIVCD, ColumnDef.TYPE_STRING, 90, true, false, true){
			{

			}
		});

		/** column 과세구분 : txtnDivNm */
		listColumnDefs.add(new ColumnDef("과세구분", Payr0490BM.ATTR_TXTNDIVNM, ColumnDef.TYPE_STRING, 90, true, true, true){
			{

			}
		});  

		/** column 비과세율 : freeDtyRate */
		listColumnDefs.add(new ColumnDef("비과세율", Payr0490BM.ATTR_FREEDTYRATE, ColumnDef.TYPE_DOUBLE, 90, true, true, true){
			{

			}
		});
		/** column 비과세금액 : freeDtySum */
		listColumnDefs.add(new ColumnDef("비과세금액", Payr0490BM.ATTR_FREEDTYSUM, ColumnDef.TYPE_LONG, 90, true, true, true){
			{

			}
		});

		/** column 정렬순서 : rngeOrd */
		listColumnDefs.add(new ColumnDef("순서", Payr0490BM.ATTR_RNGEORD, ColumnDef.TYPE_LONG, 50, true, true, true){
			{

			}
		});
		/** column 급여항목사용여부 : payItemUseYn */
		listColumnDefs.add(new ColumnDef("사용", Payr0490BM.ATTR_PAYITEMUSEYN, ColumnDef.TYPE_BOOLEAN, 40, true, true, true){
			{

			}
		});
		/** column 항목적용시작일자 : itemApptnBgnnDt */
		listColumnDefs.add(new ColumnDef("시작일자", Payr0490BM.ATTR_ITEMAPPTNBGNNDT, ColumnDef.TYPE_DATE, 80, true, true, true){
			{

			}
		});
		/** column 항목적용종료일자 : itemApptnEndDt */
		listColumnDefs.add(new ColumnDef("종료일자", Payr0490BM.ATTR_ITEMAPPTNENDDT, ColumnDef.TYPE_DATE, 80, true, true, true){
			{

			}
		});


		/** column 급여년도 : payYr */
		listColumnDefs.add(new ColumnDef("급여년도", Payr0490BM.ATTR_PAYYR, ColumnDef.TYPE_STRING, 90, false, false, true){
			{

			}
		});


		/** column 사업코드 : businCd */
		listColumnDefs.add(new ColumnDef("사업코드", Payr0490BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING, 90, false, false, true){
			{

			}
		});

		/** column 사업 : businNm */
		listColumnDefs.add(new ColumnDef("사업", Payr0490BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING, 90, false, false, true){
			{

			}
		});



		/** column 부서코드 : deptCd */
		listColumnDefs.add(new ColumnDef("부서코드", Payr0490BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 90, false, false, true){
			{

			}
		});

		/** column 부서 : deptNm */
		listColumnDefs.add(new ColumnDef("부서", Payr0490BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 90, false, false, true){
			{

			}
		});

		/** column 단위기관코드 : payrMangDeptCd */
		listColumnDefs.add(new ColumnDef("단위기관코드", Payr0490BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING, 90, false, false, true){
			{

			}
		});

		/** column 단위기관 : payrMangDeptNm */
		listColumnDefs.add(new ColumnDef("단위기관", Payr0490BM.ATTR_PAYRMANGDEPTNM, ColumnDef.TYPE_STRING, 90, false, false, true){
			{

			}
		});

		/** column 사업장코드 : dpobCd */
		listColumnDefs.add(new ColumnDef("사업장코드", Payr0490BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, false, false, true){
			{

			}
		});


		/** column 급여단가표일련번호 : payrUcstDgmSeilNum */
		listColumnDefs.add(new ColumnDef("급여단가표일련번호", Payr0490BM.ATTR_PAYRUCSTDGMSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{

			}
		});

		/** column 1월 : jan */
		listColumnDefs.add(new ColumnDef("1월", Payr0490BM.ATTR_JAN, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
			{

			}
		});
		/** column 2월 : feb */
		listColumnDefs.add(new ColumnDef("2월", Payr0490BM.ATTR_FEB, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
			{

			}
		});
		/** column 3월 : mar */
		listColumnDefs.add(new ColumnDef("3월", Payr0490BM.ATTR_MAR, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
			{

			}
		});
		/** column 4월 : apr */
		listColumnDefs.add(new ColumnDef("4월", Payr0490BM.ATTR_APR, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
			{

			}
		});
		/** column 5월 : may */
		listColumnDefs.add(new ColumnDef("5월", Payr0490BM.ATTR_MAY, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
			{

			}
		});
		/** column 6월 : jun */
		listColumnDefs.add(new ColumnDef("6월", Payr0490BM.ATTR_JUN, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
			{

			}
		});
		/** column 7월 : jul */
		listColumnDefs.add(new ColumnDef("7월", Payr0490BM.ATTR_JUL, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
			{

			}
		});
		/** column 8월 : aug */
		listColumnDefs.add(new ColumnDef("8월", Payr0490BM.ATTR_AUG, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
			{

			}
		});
		/** column 9월 : sep */
		listColumnDefs.add(new ColumnDef("9월", Payr0490BM.ATTR_SEP, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
			{

			}
		});
		/** column 10월 : oct */
		listColumnDefs.add(new ColumnDef("10월", Payr0490BM.ATTR_OCT, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
			{

			}
		});
		/** column 11월 : nov */
		listColumnDefs.add(new ColumnDef("11월", Payr0490BM.ATTR_NOV, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
			{

			}
		});
		/** column 12월 : dec */
		listColumnDefs.add(new ColumnDef("12월", Payr0490BM.ATTR_DEC, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
			{

			}
		});

		/** column 일월액구분코드 : dayMnthAmntDivCd */
		listColumnDefs.add(new ColumnDef("일월액구분코드", Payr0490BM.ATTR_DAYMNTHAMNTDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
			{

			}
		});

		/** column 일월액구분 : dayMnthAmntDivNm */
		listColumnDefs.add(new ColumnDef("일월액구분", Payr0490BM.ATTR_DAYMNTHAMNTDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
			{

			}
		});



		/** column 고용구분코드 : emymtDivCd */
		listColumnDefs.add(new ColumnDef("고용구분코드", Payr0490BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
			{

			}
		});

		/** column 고용구분 : emymtDivNm */
		listColumnDefs.add(new ColumnDef("고용구분", Payr0490BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
			{

			}
		});


		/** column 계산수식내용 : calcStdFunc */
		listColumnDefs.add(new ColumnDef("계산수식내용", Payr0490BM.ATTR_CALCSTDFUNC, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});



		/** column 급여항목비고내용 : payItemNoteCtnt */
		listColumnDefs.add(new ColumnDef("급여항목비고내용", Payr0490BM.ATTR_PAYITEMNOTECTNT, ColumnDef.TYPE_STRING, 90, true, false, true){
			{

			}
		});

		return listColumnDefs;
	}
	
	private List<ColumnDef> getPayr530002ToPayr0490Def() {

		List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 


		/** column 급여구분코드 : payCd */
		listColumnDefs.add(new ColumnDef("급여구분코드", Payr0490BM.ATTR_PAYCD, ColumnDef.TYPE_STRING, 90, false, false, true){
			{

			}
		}); 


		/** column 급여구분 : payNm */
		listColumnDefs.add(new ColumnDef("급여구분", Payr0490BM.ATTR_PAYNM, ColumnDef.TYPE_STRING, 80, true, true, true){
			{

			}
		});

		/** column 급여항목코드 : payItemCd */
		listColumnDefs.add(new ColumnDef("항목코드", Payr0490BM.ATTR_PAYITEMCD, ColumnDef.TYPE_STRING, 80, true, true, true){
			{

			}
		});


		/** column 항목명 : itemNm */
		listColumnDefs.add(new ColumnDef("항목명", Payr0490BM.ATTR_ITEMNM, ColumnDef.TYPE_STRING, 90, true, true, true){
			{

			}
		});

		/** column 계산기준구분코드 : calcStdDivCd */
		listColumnDefs.add(new ColumnDef("계산기준구분코드", Payr0490BM.ATTR_CALCSTDDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
			{

			}
		});


		/** column 계산기준구분 : calcStdDivNm */
		listColumnDefs.add(new ColumnDef("계산기준구분", Payr0490BM.ATTR_CALCSTDDIVNM, ColumnDef.TYPE_STRING, 90, true, true, true){
			{

			}
		});
		/** column 통상임금여부 : usalyAmntYn */
		listColumnDefs.add(new ColumnDef("통상임금", Payr0490BM.ATTR_USALYAMNTYN, ColumnDef.TYPE_BOOLEAN, 90, true, true, true){
			{

			}
		});

		/** column 지급공제구분코드 : pymtDducDivCd */
		listColumnDefs.add(new ColumnDef("지급공제구분코드", Payr0490BM.ATTR_PYMTDDUCDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
			{

			}
		});


		/** column 지급공제구분 : pymtDducDivNm */
		listColumnDefs.add(new ColumnDef("지급공제구분", Payr0490BM.ATTR_PYMTDDUCDIVNM, ColumnDef.TYPE_STRING, 90, true, true, true){
			{

			}
		});

		/** column 지급공제유형코드 : pymtDducFrmCd */
		listColumnDefs.add(new ColumnDef("지급공제유형코드", Payr0490BM.ATTR_PYMTDDUCFRMCD, ColumnDef.TYPE_STRING, 90, false, false, true){
			{

			}
		}); 


		/** column 지급공제유형 : pymtDducFrmNm */
		listColumnDefs.add(new ColumnDef("지급공제유형", Payr0490BM.ATTR_PYMTDDUCFRMNM, ColumnDef.TYPE_STRING, 90, true, true, true){
			{

			}
		});

		/** column 지급공제율 : pymtDducRate */
		listColumnDefs.add(new ColumnDef("지급공제율", Payr0490BM.ATTR_PYMTDDUCRATE, ColumnDef.TYPE_DOUBLE, 90, true, true, true){
			{

			}
		});
		/** column 지급공제액 : pymtDducSum */
		listColumnDefs.add(new ColumnDef("지급공제액", Payr0490BM.ATTR_PYMTDDUCSUM, ColumnDef.TYPE_LONG, 90, true, true, true){
			{

			}
		});
		/** column 과세구분코드 : txtnDivCd */
		listColumnDefs.add(new ColumnDef("과세구분코드", Payr0490BM.ATTR_TXTNDIVCD, ColumnDef.TYPE_STRING, 90, true, false, true){
			{

			}
		});

		/** column 과세구분 : txtnDivNm */
		listColumnDefs.add(new ColumnDef("과세구분", Payr0490BM.ATTR_TXTNDIVNM, ColumnDef.TYPE_STRING, 90, true, true, true){
			{

			}
		});  

		/** column 비과세율 : freeDtyRate */
		listColumnDefs.add(new ColumnDef("비과세율", Payr0490BM.ATTR_FREEDTYRATE, ColumnDef.TYPE_DOUBLE, 90, true, true, true){
			{

			}
		});
		/** column 비과세금액 : freeDtySum */
		listColumnDefs.add(new ColumnDef("비과세금액", Payr0490BM.ATTR_FREEDTYSUM, ColumnDef.TYPE_LONG, 90, true, true, true){
			{

			}
		});

		/** column 정렬순서 : rngeOrd */
		listColumnDefs.add(new ColumnDef("순서", Payr0490BM.ATTR_RNGEORD, ColumnDef.TYPE_LONG, 50, true, true, true){
			{

			}
		});
		/** column 급여항목사용여부 : payItemUseYn */
		listColumnDefs.add(new ColumnDef("사용", Payr0490BM.ATTR_PAYITEMUSEYN, ColumnDef.TYPE_BOOLEAN, 40, true, true, true){
			{

			}
		});
		/** column 항목적용시작일자 : itemApptnBgnnDt */
		listColumnDefs.add(new ColumnDef("시작일자", Payr0490BM.ATTR_ITEMAPPTNBGNNDT, ColumnDef.TYPE_DATE, 80, true, true, true){
			{

			}
		});
		/** column 항목적용종료일자 : itemApptnEndDt */
		listColumnDefs.add(new ColumnDef("종료일자", Payr0490BM.ATTR_ITEMAPPTNENDDT, ColumnDef.TYPE_DATE, 80, true, true, true){
			{

			}
		});


		/** column 급여년도 : payYr */
		listColumnDefs.add(new ColumnDef("급여년도", Payr0490BM.ATTR_PAYYR, ColumnDef.TYPE_STRING, 90, false, false, true){
			{

			}
		});


		/** column 사업코드 : businCd */
		listColumnDefs.add(new ColumnDef("사업코드", Payr0490BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING, 90, false, false, true){
			{

			}
		});

		/** column 사업 : businNm */
		listColumnDefs.add(new ColumnDef("사업", Payr0490BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING, 90, false, false, true){
			{

			}
		});



		/** column 부서코드 : deptCd */
		listColumnDefs.add(new ColumnDef("부서코드", Payr0490BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 90, false, false, true){
			{

			}
		});

		/** column 부서 : deptNm */
		listColumnDefs.add(new ColumnDef("부서", Payr0490BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 90, false, false, true){
			{

			}
		});

		/** column 단위기관코드 : payrMangDeptCd */
		listColumnDefs.add(new ColumnDef("단위기관코드", Payr0490BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING, 90, false, false, true){
			{

			}
		});

		/** column 단위기관 : payrMangDeptNm */
		listColumnDefs.add(new ColumnDef("단위기관", Payr0490BM.ATTR_PAYRMANGDEPTNM, ColumnDef.TYPE_STRING, 90, false, false, true){
			{

			}
		});

		/** column 사업장코드 : dpobCd */
		listColumnDefs.add(new ColumnDef("사업장코드", Payr0490BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, false, false, true){
			{

			}
		});


		/** column 급여단가표일련번호 : payrUcstDgmSeilNum */
		listColumnDefs.add(new ColumnDef("급여단가표일련번호", Payr0490BM.ATTR_PAYRUCSTDGMSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
			{

			}
		});

		/** column 1월 : jan */
		listColumnDefs.add(new ColumnDef("1월", Payr0490BM.ATTR_JAN, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
			{

			}
		});
		/** column 2월 : feb */
		listColumnDefs.add(new ColumnDef("2월", Payr0490BM.ATTR_FEB, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
			{

			}
		});
		/** column 3월 : mar */
		listColumnDefs.add(new ColumnDef("3월", Payr0490BM.ATTR_MAR, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
			{

			}
		});
		/** column 4월 : apr */
		listColumnDefs.add(new ColumnDef("4월", Payr0490BM.ATTR_APR, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
			{

			}
		});
		/** column 5월 : may */
		listColumnDefs.add(new ColumnDef("5월", Payr0490BM.ATTR_MAY, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
			{

			}
		});
		/** column 6월 : jun */
		listColumnDefs.add(new ColumnDef("6월", Payr0490BM.ATTR_JUN, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
			{

			}
		});
		/** column 7월 : jul */
		listColumnDefs.add(new ColumnDef("7월", Payr0490BM.ATTR_JUL, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
			{

			}
		});
		/** column 8월 : aug */
		listColumnDefs.add(new ColumnDef("8월", Payr0490BM.ATTR_AUG, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
			{

			}
		});
		/** column 9월 : sep */
		listColumnDefs.add(new ColumnDef("9월", Payr0490BM.ATTR_SEP, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
			{

			}
		});
		/** column 10월 : oct */
		listColumnDefs.add(new ColumnDef("10월", Payr0490BM.ATTR_OCT, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
			{

			}
		});
		/** column 11월 : nov */
		listColumnDefs.add(new ColumnDef("11월", Payr0490BM.ATTR_NOV, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
			{

			}
		});
		/** column 12월 : dec */
		listColumnDefs.add(new ColumnDef("12월", Payr0490BM.ATTR_DEC, ColumnDef.TYPE_BOOLEAN, 90, true, false, true){
			{

			}
		});

		/** column 일월액구분코드 : dayMnthAmntDivCd */
		listColumnDefs.add(new ColumnDef("일월액구분코드", Payr0490BM.ATTR_DAYMNTHAMNTDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
			{

			}
		});

		/** column 일월액구분 : dayMnthAmntDivNm */
		listColumnDefs.add(new ColumnDef("일월액구분", Payr0490BM.ATTR_DAYMNTHAMNTDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
			{

			}
		});



		/** column 고용구분코드 : emymtDivCd */
		listColumnDefs.add(new ColumnDef("고용구분코드", Payr0490BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
			{

			}
		});

		/** column 고용구분 : emymtDivNm */
		listColumnDefs.add(new ColumnDef("고용구분", Payr0490BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
			{

			}
		});


		/** column 계산수식내용 : calcStdFunc */
		listColumnDefs.add(new ColumnDef("계산수식내용", Payr0490BM.ATTR_CALCSTDFUNC, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});



		/** column 급여항목비고내용 : payItemNoteCtnt */
		listColumnDefs.add(new ColumnDef("급여항목비고내용", Payr0490BM.ATTR_PAYITEMNOTECTNT, ColumnDef.TYPE_STRING, 90, true, false, true){
			{

			}
		});

		return listColumnDefs;
	}
}
