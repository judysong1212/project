package com.app.exterms.yearendtax.client.form.defs.yeta2019;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2019.PdfA102yBM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**
 * @Class Name : Payr0300VO.java
 * @Description : Payr0300 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class PdfA102yDef  extends TableDef implements YetaDaoConstants {

	private int row = 0;
	
	public PdfA102yDef(String chkPayrDef){

		if ("".equals(chkPayrDef)) {  

			setDaoClass("");
			setCustomListMethod(CLASS_YETA4200_PDF_A102Y_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setEditFieldGrid(true);
			setCheckBoxOnGridRows(true);

			setColumnsDefinition(getPayr0304ToPayr4420ColumnsList());

		}


	}

	private List<ColumnDef> getPayr0304ToPayr4420ColumnsList(){
		row = 0;
		List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 

		/** column 사업장코드 : dpobCd */
		listColumnDefs.add(new ColumnDef("사업장코드", PdfA102yBM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				setReadOnly(true);
			}
		});
		/** column pdf 소득공제자료적용여부 : pdfDatAppYn */
		listColumnDefs.add(new ColumnDef("소득공제자료적용여부", PdfA102yBM.ATTR_PDFDATAPPYN, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				setReadOnly(true);
			}
		});
		/** column PDF_소득공제적용일자 : pdfDatAppCmplDt */
		listColumnDefs.add(new ColumnDef("소득공제적용일자", PdfA102yBM.ATTR_PDFDATAPPCMPLDT, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				setReadOnly(true);
			}
		});
		/** column PDF_소득공제제외사유내용 : pdfDatAppExcCtnt */
		listColumnDefs.add(new ColumnDef("소득공제제외사유내용", PdfA102yBM.ATTR_PDFDATAPPEXCCTNT, ColumnDef.TYPE_STRING , 110, true, true, true){
			{
				
			}
		});
		/** column 귀속년도 : yrtxBlggYr */
		listColumnDefs.add(new ColumnDef("귀속년도", PdfA102yBM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				setReadOnly(true);
			}
		});
		/** column 연말정산구분코드 : clutSeptCd */
		listColumnDefs.add(new ColumnDef("연말정산구분코드", PdfA102yBM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				setReadOnly(true);
			}
		});
		/** column SYSTEMKEY : systemkey */
		listColumnDefs.add(new ColumnDef("SYSTEMKEY", PdfA102yBM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				setReadOnly(true);
			}
		});
		/** column 증권번호 : accNo */
		listColumnDefs.add(new ColumnDef("증권번호", PdfA102yBM.ATTR_ACCNO, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				setReadOnly(true);
			}
		});
		/** column 서식코드 : formCd */
		listColumnDefs.add(new ColumnDef("서식코드", PdfA102yBM.ATTR_FORMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				setReadOnly(true);
			}
		});
		/** column 주민등록번호 : resid */
		listColumnDefs.add(new ColumnDef("주민등록번호", PdfA102yBM.ATTR_RESID, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				setReadOnly(true);
			}
		});
		/** column 성명 : name */
		listColumnDefs.add(new ColumnDef("성명", PdfA102yBM.ATTR_NAME, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				setReadOnly(true);
			}
		});
		/** column 자료코드 : datCd */
		listColumnDefs.add(new ColumnDef("자료코드", PdfA102yBM.ATTR_DATCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				setReadOnly(true);
			}
		});
		/** column 사업자번호 : busnid */
		listColumnDefs.add(new ColumnDef("사업자번호", PdfA102yBM.ATTR_BUSNID, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				setReadOnly(true);
			}
		});
		/** column 상호명 : tradeNm */
		listColumnDefs.add(new ColumnDef("상호명", PdfA102yBM.ATTR_TRADENM, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				setReadOnly(true);
			}
		});
		/** column 보험종류 : goodsNm */
		listColumnDefs.add(new ColumnDef("보험종류", PdfA102yBM.ATTR_GOODSNM, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				setReadOnly(true);
			}
		});
		/** column 주민등록번호_주피보험자 : insu1Resid */
		listColumnDefs.add(new ColumnDef("주민등록번호_주피보험자", PdfA102yBM.ATTR_INSU1RESID, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				setReadOnly(true);
			}
		});
		/** column 성명_주피보험자 : insu1Nm */
		listColumnDefs.add(new ColumnDef("성명_주피보험자", PdfA102yBM.ATTR_INSU1NM, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				setReadOnly(true);
			}
		});
		/** column 주민등록번호_종피보험자1 : insu2Resid1 */
		listColumnDefs.add(new ColumnDef("주민등록번호_종피보험자1", PdfA102yBM.ATTR_INSU2RESID1, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				setReadOnly(true);
			}
		});
		/** column 성명_종피보험자1 : insu2Nm1 */
		listColumnDefs.add(new ColumnDef("성명_종피보험자1", PdfA102yBM.ATTR_INSU2NM1, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				setReadOnly(true);
			}
		});
		/** column 주민등록번호_종피보험자2 : insu2Resid2 */
		listColumnDefs.add(new ColumnDef("주민등록번호_종피보험자2", PdfA102yBM.ATTR_INSU2RESID2, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				setReadOnly(true);
			}
		});
		/** column 성명_종피보험자2 : insu2Nm2 */
		listColumnDefs.add(new ColumnDef("성명_종피보험자2", PdfA102yBM.ATTR_INSU2NM2, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				setReadOnly(true);
			}
		});
		/** column 주민등록번호_종피보험자3 : insu2Resid3 */
		listColumnDefs.add(new ColumnDef("주민등록번호_종피보험자3", PdfA102yBM.ATTR_INSU2RESID3, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				setReadOnly(true);
			}
		});
		/** column 성명_종피보험자3 : insu2Nm3 */
		listColumnDefs.add(new ColumnDef("성명_종피보험자3", PdfA102yBM.ATTR_INSU2NM3, ColumnDef.TYPE_STRING , 90, true, true, true){
			{
				setReadOnly(true);
			}
		});
		/** column 보험료납입금액계 : insuPaySum */
		listColumnDefs.add(new ColumnDef("보험료납입금액계", PdfA102yBM.ATTR_INSUPAYSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, true, true){
			{
				setReadOnly(true);
			}
		});
		/** column 입력자 : kybdr */
		listColumnDefs.add(new ColumnDef("입력자", PdfA102yBM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				setReadOnly(true);
			}
		});
		/** column 입력일자 : inptDt */
		listColumnDefs.add(new ColumnDef("입력일자", PdfA102yBM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				setReadOnly(true);
			}
		});
		/** column 입력주소 : inptAddr */
		listColumnDefs.add(new ColumnDef("입력주소", PdfA102yBM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				setReadOnly(true);
			}
		});
		/** column 수정자 : ismt */
		listColumnDefs.add(new ColumnDef("수정자", PdfA102yBM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				setReadOnly(true);
			}
		});
		/** column 수정일자 : revnDt */
		listColumnDefs.add(new ColumnDef("수정일자", PdfA102yBM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				setReadOnly(true);
			}
		});
		/** column 수정주소 : revnAddr */
		listColumnDefs.add(new ColumnDef("수정주소", PdfA102yBM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
			{
				setReadOnly(true);
			}
		});

		return listColumnDefs;
	}

}
