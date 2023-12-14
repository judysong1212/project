package com.app.exterms.yearendtax.client.form.defs.yeta2022;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2022.PdfQ301yBM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class PdfQ301yDef extends TableDef implements YetaDaoConstants {

	  private int row = 0;
//    private YetaConstants yetaLabel = YetaConstants.INSTANCE;

	  public PdfQ301yDef(String chkPayrDef){

		  if ("".equals(chkPayrDef)) {  
		    	
		    setDaoClass("");
		    setCustomListMethod(CLASS_YETA7200_PDF_Q301Y_DATA_LIST);
		    setAutoFillGrid(true);
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
		  listColumnDefs.add(new ColumnDef("사업장코드", PdfQ301yBM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
		  	{
		  		setReadOnly(true);
		  	}
		  });
		  /** column 귀속년도 : yrtxBlggYr */
		  listColumnDefs.add(new ColumnDef("귀속년도", PdfQ301yBM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
		  	{
		  		setReadOnly(true);
		  	}
		  });
		  /** column 연말정산구분코드 : clutSeptCd */
		  listColumnDefs.add(new ColumnDef("연말정산구분코드", PdfQ301yBM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
		  	{
		  		setReadOnly(true);
		  	}
		  });
		  /** column pdf 소득공제자료적용여부 : pdfDatAppYn */
		  listColumnDefs.add(new ColumnDef("소득공제자료적용", PdfQ301yBM.ATTR_PDFDATAPPYN, ColumnDef.TYPE_STRING , 90, true, true, true){
		  	{
		  		setReadOnly(true);
		  	}
		  });
		  /** column PDF_소득공제적용일자 : pdfDatAppCmplDt */
		  listColumnDefs.add(new ColumnDef("소득공제적용일자", PdfQ301yBM.ATTR_PDFDATAPPCMPLDT, ColumnDef.TYPE_STRING , 90, true, true, true){
		  	{
		  		setReadOnly(true);
		  	}
		  });
		  /** column PDF_소득공제제외사유내용 : pdfDatAppExcCtnt */
		  listColumnDefs.add(new ColumnDef("소득공제제외사유내용", PdfQ301yBM.ATTR_PDFDATAPPEXCCTNT, ColumnDef.TYPE_STRING , 90, true, false, true){
		  	{

		  	}
		  });
		  
		  /** column 주민등록번호(피보험자): insuResid */
		  listColumnDefs.add(new ColumnDef("주민등록번호", PdfQ301yBM.ATTR_RESID, ColumnDef.TYPE_STRING , 90, true, true, true){
		  	{
		  		setReadOnly(true);
		  	}
		  });

		  /** column 성명(피보험자) : insuNm */
		  listColumnDefs.add(new ColumnDef("성명", PdfQ301yBM.ATTR_NAME, ColumnDef.TYPE_STRING , 90, true, true, true){
		  	{
		  		setReadOnly(true);
		  	}
		  });
		  /** column SYSTEMKEY : systemkey */
		  listColumnDefs.add(new ColumnDef("SYSTEMKEY", PdfQ301yBM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
		  	{
		  		setReadOnly(true);
		  	}
		  });
		  /** column 사업자번호 : busnid */
		  listColumnDefs.add(new ColumnDef("사업자번호", PdfQ301yBM.ATTR_BUSNID, ColumnDef.TYPE_STRING , 90, true, true, true){
		  	{
		  		setReadOnly(true);
		  	}
		  });
		  /** column 투자기관 : tradeNm*/
		  listColumnDefs.add(new ColumnDef("투자기관", PdfQ301yBM.ATTR_TRADENM, ColumnDef.TYPE_STRING , 90, true, true, true){
		  	{
		  		setReadOnly(true);
		  	}
		  });
		  /** column  계좌번호 : secuNo */
		  listColumnDefs.add(new ColumnDef("계좌번호", PdfQ301yBM.ATTR_SECUNO, ColumnDef.TYPE_STRING , 90, true, false, true){
		  	{
		  		setReadOnly(true);
		  	}
		  });

		  /** column 투자신탁명: fundNm  */
		  listColumnDefs.add(new ColumnDef("투자신탁명", PdfQ301yBM.ATTR_FUNDNM, ColumnDef.TYPE_STRING , 90, true, true, true){
		  	{
		  		setReadOnly(true);
		  	}
		  });
		  /** set 납입연도: regDt */
		  listColumnDefs.add(new ColumnDef("납입연도", PdfQ301yBM.ATTR_REGDT, ColumnDef.TYPE_STRING , 90, true, true, true){
		  	{
		  		setReadOnly(true);
		  	}
		  });
		  /** set 벤처조합구분코드: vntAsctClCd */
		  listColumnDefs.add(new ColumnDef("벤처조합구분코드", PdfQ301yBM.ATTR_VNTASCTCLCD, ColumnDef.TYPE_STRING , 90, true, false, true){
		  	{
		  		setReadOnly(true);
		  	}
		  });
		  
		  /** set 금융기관코드(1:조합 등, 2:벤처 등): comCd */
		  listColumnDefs.add(new ColumnDef("금융기관코드", PdfQ301yBM.ATTR_COMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
		  	{
		  		setReadOnly(true);
		  	}
		  });

		  /** column 연간합계액 : vntSum  */
		  listColumnDefs.add(new ColumnDef("연간합계액", PdfQ301yBM.ATTR_VNTSUM, ColumnDef.TYPE_STRING , 90, true, true, true){
		  	{
		  		setReadOnly(true);
		  	}
		  });

		  /** column 입력자 : kybdr */
		  listColumnDefs.add(new ColumnDef("입력자", PdfQ301yBM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
		  	{
		  		setReadOnly(true);
		  	}
		  });
		  /** column 입력일자 : inptDt */
		  listColumnDefs.add(new ColumnDef("입력일자", PdfQ301yBM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
		  	{
		  		setReadOnly(true);
		  	}
		  });
		  /** column 입력주소 : inptAddr */
		  listColumnDefs.add(new ColumnDef("입력주소", PdfQ301yBM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
		  	{
		  		setReadOnly(true);
		  	}
		  });
		  /** column 수정자 : ismt */
		  listColumnDefs.add(new ColumnDef("수정자", PdfQ301yBM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
		  	{
		  		setReadOnly(true);
		  	}
		  });
		  /** column 수정일자 : revnDt */
		  listColumnDefs.add(new ColumnDef("수정일자", PdfQ301yBM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
		  	{
		  		setReadOnly(true);
		  	}
		  });
		  /** column 수정주소 : revnAddr */
		  listColumnDefs.add(new ColumnDef("수정주소", PdfQ301yBM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
		  	{
		  		setReadOnly(true);
		  	}
		  });

		      return listColumnDefs;
        }
    
}
