package com.app.exterms.yearendtax.client.form.defs.yeta2018;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2018.Ye162520BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.google.gwt.i18n.client.DateTimeFormat;

public class Ye162520Def extends TableDef implements YetaDaoConstants{
	
	private int row = 0;
	
	public Ye162520Def(String chkDef) {

		if ("YetaP33004".equals(chkDef)) {

			// setTitle("금전소비대차계약");
			setTitle("");
			setDaoClass("");
			// setCustomListMethod(CLASS_YETAP03004TOYE162520_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true);
			setEditFieldGrid(true);
			setColumnsDefinition(getColumnsListYetaP03004ToYE162520());

		} else if ("YetaT13004".equals(chkDef)) {

			setTitle("");
			setDaoClass("");
			// setCustomListMethod(CLASS_YETAP03004TOYE162520_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true);
			setEditFieldGrid(true);
			setColumnsDefinition(getColumnsListYetaT03004ToYE162520());

		} else if ("YetaP23004".equals(chkDef)) {

			setTitle("");
			setDaoClass("");
			setCustomListMethod(CLASS_YETAP33004_TO_YE162520_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true);
			setEditFieldGrid(true);
			setColumnsDefinition(getColumnsListYetaP33004ToYE162520());

		} else {
			setTitle("");
			setDaoClass("");
			setCustomListMethod("");
			// setCustomListMethod(CLASS_YETA0100_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true);
			setEditFieldGrid(true);
			setColumnsDefinition(getYe162520ColumnsList());
		}

	}

	private List<ColumnDef> getYe162520ColumnsList() {
		 
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye162520BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산귀속년도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("연말정산귀속년도", Ye162520BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("정산구분코드", Ye162520BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye162520BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 금전소비대차일련번호 : comrCalnSeilNum */
        listColumnDefs.add(new ColumnDef("금전소비대차일련번호", Ye162520BM.ATTR_COMRCALNSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column G16_금전소비대차_대주성명 : comrCdtrNm */
        listColumnDefs.add(new ColumnDef("G16_금전소비대차_대주성명", Ye162520BM.ATTR_COMRCDTRNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column G17_금전소비대차_대주주민등록번호 : comrCdtrResnRegnNum */
        listColumnDefs.add(new ColumnDef("G17_금전소비대차_대주주민등록번호", Ye162520BM.ATTR_COMRCDTRRESNREGNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column G18_금전소비대차_계약기간시작일자 : comrCnttPridBgnnDt */
        listColumnDefs.add(new ColumnDef("G18_금전소비대차_계약기간시작일자", Ye162520BM.ATTR_COMRCNTTPRIDBGNNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column G19_금전소비대차_계약기간종료일자 : comrCnttPridEndDt */
        listColumnDefs.add(new ColumnDef("G19_금전소비대차_계약기간종료일자", Ye162520BM.ATTR_COMRCNTTPRIDENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column G20_금전소비대차_차입금이자율 : comrLoanItrtRate */
        listColumnDefs.add(new ColumnDef("G20_금전소비대차_차입금이자율", Ye162520BM.ATTR_COMRLOANITRTRATE, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column G21_금전소비대차_원리금상환액합계 : comrPclttAmtftAggr */
        listColumnDefs.add(new ColumnDef("G21_금전소비대차_원리금상환액합계", Ye162520BM.ATTR_COMRPCLTTAMTFTAGGR, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column G22_금전소비대차_원금금액 : comrPrnilSum */
        listColumnDefs.add(new ColumnDef("G22_금전소비대차_원금금액", Ye162520BM.ATTR_COMRPRNILSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column G23_금전소비대차_이자금액 : comrItrtSum */
        listColumnDefs.add(new ColumnDef("G23_금전소비대차_이자금액", Ye162520BM.ATTR_COMRITRTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column G24_금전소비대차_공제금액 : comrDducSum */
        listColumnDefs.add(new ColumnDef("G24_금전소비대차_공제금액", Ye162520BM.ATTR_COMRDDUCSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 전자파일이관여부 : ectnFlTrnrCtlYn */
        listColumnDefs.add(new ColumnDef("전자파일이관여부", Ye162520BM.ATTR_ECTNFLTRNRCTLYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye162520BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye162520BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye162520BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye162520BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye162520BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye162520BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
          
          return listColumnDefs;
	}
	
	
	private List<ColumnDef> getColumnsListYetaP03004ToYE162520() {
		 
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye162520BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye162520BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 금전소비대차_대주성명 : comrCdtrNm */
        listColumnDefs.add(new ColumnDef("대주성명", Ye162520BM.ATTR_COMRCDTRNM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 금전소비대차_주민번호 : comrCdtrResnRegnNum */
        listColumnDefs.add(new ColumnDef("주민번호", Ye162520BM.ATTR_COMRCDTRRESNREGNNUM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 금전소비대차_계약시작일자 : comrCnttPridBgnnDt */
        listColumnDefs.add(new ColumnDef("계약시작일", Ye162520BM.ATTR_COMRCNTTPRIDBGNNDT, ColumnDef.TYPE_DATE , 100, true, true, true){
        	{
        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
        	}
        });
        /** column 금전소비대차_계약종료일자 : comrCnttPridEndDt */
        listColumnDefs.add(new ColumnDef("계약종료일", Ye162520BM.ATTR_COMRCNTTPRIDENDDT, ColumnDef.TYPE_DATE , 100, true, true, true){
        	{
        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
        	}
        });
        /** column 금전소비대차_차입금이자율 : comrLoanItrtRate */
        listColumnDefs.add(new ColumnDef("이자율", Ye162520BM.ATTR_COMRLOANITRTRATE, ColumnDef.TYPE_DOUBLE , 100, true, true, true){
        	{

        	}
        });
        /** column 금전소비대차_원리금상환액계 : comrPclttAmtftAggr */
        listColumnDefs.add(new ColumnDef("상환액계", Ye162520BM.ATTR_COMRPCLTTAMTFTAGGR, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{

        	}
        });
        /** column 금전소비대차_원리금 : comrPrnilSum */
        listColumnDefs.add(new ColumnDef("원금", Ye162520BM.ATTR_COMRPRNILSUM, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{

        	}
        });
        /** column 금전소비대차_이자 : comrItrtSum */
        listColumnDefs.add(new ColumnDef("이자", Ye162520BM.ATTR_COMRITRTSUM, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{

        	}
        });
        /** column 금전소비대차_공제금액 : comrDducSum */
        listColumnDefs.add(new ColumnDef("공제금액", Ye162520BM.ATTR_COMRDDUCSUM, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{
//        		setReadOnly(true);
        	}
        });
        
        
        

        /** column 연말정산귀속년도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("연말정산귀속년도", Ye162520BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정산구분코드 : clutseptCd */
        listColumnDefs.add(new ColumnDef("정산구분코드", Ye162520BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 금전소비대차일련번호 : comrCalnSeilNum */
        listColumnDefs.add(new ColumnDef("금전소비대차일련번호", Ye162520BM.ATTR_COMRCALNSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
     

      
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye162520BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye162520BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye162520BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye162520BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye162520BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye162520BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : ectnFlTrnrCtlYn */
        listColumnDefs.add(new ColumnDef("전자파일이관여부", Ye162520BM.ATTR_ECTNFLTRNRCTLYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

        return listColumnDefs;
	}
	
	private List<ColumnDef> getColumnsListYetaT03004ToYE162520() {
		 
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye162520BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye162520BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
//        /** column 금전소비대차_번호 : rnum */
//        listColumnDefs.add(new ColumnDef("번호", Ye162520BM.ATTR_RNUM, ColumnDef.TYPE_STRING , 50, true, true, true){
//        	{
//
//        	}
//        });
        
        /** column 금전소비대차_대주성명 : comrCdtrNm */
        listColumnDefs.add(new ColumnDef("대주성명", Ye162520BM.ATTR_COMRCDTRNM, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        /** column 금전소비대차_주민번호 : comrCdtrResnRegnNum */
        listColumnDefs.add(new ColumnDef("주민번호", Ye162520BM.ATTR_COMRCDTRRESNREGNNUM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 금전소비대차_계약시작일자 : comrCnttPridBgnnDt */
        listColumnDefs.add(new ColumnDef("계약시작일", Ye162520BM.ATTR_COMRCNTTPRIDBGNNDT, ColumnDef.TYPE_DATE , 80, true, true, true){
        	{
        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
        	}
        });
        /** column 금전소비대차_계약종료일자 : comrCnttPridEndDt */
        listColumnDefs.add(new ColumnDef("계약종료일", Ye162520BM.ATTR_COMRCNTTPRIDENDDT, ColumnDef.TYPE_DATE , 80, true, true, true){
        	{
        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
        	}
        });
        /** column 금전소비대차_차입금이자율 : comrLoanItrtRate */
        listColumnDefs.add(new ColumnDef("이자율", Ye162520BM.ATTR_COMRLOANITRTRATE, ColumnDef.TYPE_DOUBLE , 80, true, true, true){
        	{

        	}
        });
        /** column 금전소비대차_원리금상환액계 : comrPclttAmtftAggr */
        listColumnDefs.add(new ColumnDef("상환액계", Ye162520BM.ATTR_COMRPCLTTAMTFTAGGR, ColumnDef.TYPE_LONG , 95, true, true, true){
        	{

        	}
        });
        /** column 금전소비대차_원리금 : comrPrnilSum */
        listColumnDefs.add(new ColumnDef("원금", Ye162520BM.ATTR_COMRPRNILSUM, ColumnDef.TYPE_LONG , 95, true, true, true){
        	{

        	}
        });
        /** column 금전소비대차_이자 : comrItrtSum */
        listColumnDefs.add(new ColumnDef("이자", Ye162520BM.ATTR_COMRITRTSUM, ColumnDef.TYPE_LONG , 95, true, true, true){
        	{

        	}
        });
        /** column 금전소비대차_공제금액 : comrDducSum */
        listColumnDefs.add(new ColumnDef("공제금액", Ye162520BM.ATTR_COMRDDUCSUM, ColumnDef.TYPE_LONG , 95, true, false, true){
        	{
//        		setReadOnly(true);
        	}
        });
        
        
        

        /** column 연말정산귀속년도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("연말정산귀속년도", Ye162520BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정산구분코드 : clutseptCd */
        listColumnDefs.add(new ColumnDef("정산구분코드", Ye162520BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 금전소비대차일련번호 : comrCalnSeilNum */
        listColumnDefs.add(new ColumnDef("금전소비대차일련번호", Ye162520BM.ATTR_COMRCALNSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
     

      
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye162520BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye162520BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye162520BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye162520BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye162520BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye162520BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : ectnFlTrnrCtlYn */
        listColumnDefs.add(new ColumnDef("전자파일이관여부", Ye162520BM.ATTR_ECTNFLTRNRCTLYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

        return listColumnDefs;
	}

	
	private List<ColumnDef> getColumnsListYetaP33004ToYE162520() {
		 
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        /** column 국세청자료구분코드 : taxVvalKrnCd */
	    listColumnDefs.add(new ColumnDef("국세청자료구분", Ye162520BM.ATTR_TAXVVALKRNNM, ColumnDef.TYPE_STRING , 90, false, true, false){
	    	{
	    		setReadOnly(true);
	    	}
	    });
        
        /** column G16_금전소비대차_대주성명 : comrCdtrNm */
        listColumnDefs.add(new ColumnDef("대주성명", Ye162520BM.ATTR_COMRCDTRNM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column G17_금전소비대차_대주주민등록번호 : comrCdtrResnRegnNum */
        listColumnDefs.add(new ColumnDef("주민번호", Ye162520BM.ATTR_COMRCDTRRESNREGNNUM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column G18_금전소비대차_계약기간시작일자 : comrCnttPridBgnnDt */
        listColumnDefs.add(new ColumnDef("계약시작일자", Ye162520BM.ATTR_COMRCNTTPRIDBGNNDT, ColumnDef.TYPE_DATE, 100, true, true, true){
        	{
        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
				setDtFieldMask("9999.99.99");
        	}
        });
        
        /** column G19_금전소비대차_계약기간종료일자 : comrCnttPridEndDt */
        listColumnDefs.add(new ColumnDef("계약종료일자", Ye162520BM.ATTR_COMRCNTTPRIDENDDT, ColumnDef.TYPE_DATE , 100, true, true, true){
        	{
        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
				setDtFieldMask("9999.99.99");
        	}
        });
        
        /** column G20_금전소비대차_차입금이자율 : comrLoanItrtRate */
        listColumnDefs.add(new ColumnDef("이자율", Ye162520BM.ATTR_COMRLOANITRTRATE, ColumnDef.TYPE_DOUBLE , 100, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        
        /** column G21_금전소비대차_원리금상환액합계 : comrPclttAmtftAggr */
        listColumnDefs.add(new ColumnDef("상환액계", Ye162520BM.ATTR_COMRPCLTTAMTFTAGGR, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        /** column G22_금전소비대차_원금금액 : comrPrnilSum */
        listColumnDefs.add(new ColumnDef("원금", Ye162520BM.ATTR_COMRPRNILSUM, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        /** column G23_금전소비대차_이자금액 : comrItrtSum */
        listColumnDefs.add(new ColumnDef("이자", Ye162520BM.ATTR_COMRITRTSUM, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        /** column G24_금전소비대차_공제금액 : comrDducSum */
        listColumnDefs.add(new ColumnDef("공제금액", Ye162520BM.ATTR_COMRDDUCSUM, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        /** column 전자파일이관여부 : ectnFlTrnrCtlYn */
        listColumnDefs.add(new ColumnDef("이관여부", Ye162520BM.ATTR_ECTNFLTRNRCTLYN, ColumnDef.TYPE_BOOLEAN, 90, false, false, false){
        	{

        	}
        });
        
        
        
        //--

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye162520BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산귀속년도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("연말정산귀속년도", Ye162520BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("정산구분코드", Ye162520BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye162520BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 금전소비대차일련번호 : comrCalnSeilNum */
        listColumnDefs.add(new ColumnDef("금전소비대차일련번호", Ye162520BM.ATTR_COMRCALNSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        
        /** column 국세청자료구분코드 : taxVvalKrnCd */
        listColumnDefs.add(new ColumnDef("국세청자료구분코드", Ye162520BM.ATTR_TAXVVALKRNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
       
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye162520BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye162520BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye162520BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye162520BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye162520BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye162520BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

		return listColumnDefs;
		
	}

	
	
	
	
	
	
	
}
