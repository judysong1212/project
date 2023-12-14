package com.app.exterms.yearendtax.client.form.defs.yeta2021;



import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2021.Ye161030BM;
import com.app.exterms.yearendtax.client.dto.yeta2021.Ye161040BM;
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

public class Ye161040Def  extends TableDef implements YetaDaoConstants {

    private int row = 0;
//    private YetaConstants yetaLabel = YetaConstants.INSTANCE;

    

	public Ye161040Def(String chkPayrDef) {

		// 국세청 자료
		if ("Yeta630001".equals(chkPayrDef)) {

			setDaoClass("");
			setCustomListMethod(CLASS_YETA6300_TO_YE161040_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true);
			setEditableGrid(true);
			setEditFieldGrid(true);
			setColumnsDefinition(getYeta63000ToYe161040ColumnsList01());

       // 기타자료
      }else if("Yeta630002".equals(chkPayrDef)) {
    	  
			setDaoClass("");
			setCustomListMethod(CLASS_YETA6300_TO_YE161040_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true);
			setEditableGrid(true);
			setEditFieldGrid(true);
			setColumnsDefinition(getYeta63000ToYe161040ColumnsList02());
		}

	}
     
	/** 국세청 자료 **/
	private List<ColumnDef> getYeta63000ToYe161040ColumnsList01() {
		
		List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
//        /** column 합계 :  */ 
//        listColumnDefs.add(new ColumnDef("", Ye161040BM.ATTR_SUMNAME, ColumnDef.TYPE_STRING, 70, true, true, true));
          
//        /** column 구분 :  */
//        listColumnDefs.add(new ColumnDef("구분", Ye161040BM.ATTR_HEADER, ColumnDef.TYPE_STRING, 30, true, true, true));
        /** column 성명 : cvrgInscDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("성명", Ye161030BM.ATTR_TXPRNM, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{

        	}
        });
        
        
        /** column 건강등보험료 : hifeDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("건강", Ye161040BM.ATTR_HIFEDDCTRGTAMT, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{
        		setSelectOnFocus(true);
        		setReadOnly(true);
        	}
        });
        /** column 고용보험료 : mcurUiTrgtAmt */
        listColumnDefs.add(new ColumnDef("고용", Ye161040BM.ATTR_MCURUITRGTAMT, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{
        		setReadOnly(true);
        		setSelectOnFocus(true);
        		
        	}
        });
        
        
        /** column 보장성보험료 : cvrgInscDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("보장성", Ye161040BM.ATTR_CVRGINSCDDCTRGTAMT, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
       
        /** column 장애인전용보장성보험료 : dsbrDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("장애인전용", Ye161040BM.ATTR_DSBRDDCTRGTAMT, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        
        /** column 의료비금액 : mdxpsDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("의료비", Ye161040BM.ATTR_MDXPSDDCTRGTAMT, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{
        		setReadOnly(true);
        		setSelectOnFocus(true);
        	}
        });
        
        /** column 교육비금액 : scxpsDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("교육비", Ye161040BM.ATTR_SCXPSDDCTRGTAMT, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{
        		setReadOnly(true);
        		setSelectOnFocus(true);
        	}
        });
        
        /** column 신용카드_전통대중제외금액 : crdcDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("신용카드", Ye161040BM.ATTR_CRDCDDCTRGTAMT, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        /** column 직불카드등_전통대중제외금액 : drtpCardDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("직불카드등", Ye161040BM.ATTR_DRTPCARDDDCTRGTAMT, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        /** column 현금영수증_전통대중제외금액 : cshptDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("현금영수증", Ye161040BM.ATTR_CSHPTDDCTRGTAMT, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        /** column 도서구입액 : bookShowAmt */
        listColumnDefs.add(new ColumnDef("도서공연금액", Ye161040BM.ATTR_BOOKSHOWAMT, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        /** column 전통시작사용금액 : tdmrDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("전통시장사용액", Ye161040BM.ATTR_TDMRDDCTRGTAMT, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        /** column 대중교통이용금액 : pbtDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("대중교통이용액", Ye161040BM.ATTR_PBTDDCTRGTAMT, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        /** column 기부금액 : conbDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("기부금", Ye161040BM.ATTR_CONBDDCTRGTAMT, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{
        		setReadOnly(true);
        		setSelectOnFocus(true);
        	}
        });
        
        
        //--
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye161040BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속연도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속연도", Ye161040BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye161040BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye161040BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 주민등록번호 : txprDscmNoCntn */
        listColumnDefs.add(new ColumnDef("주민등록번호", Ye161040BM.ATTR_TXPRDSCMNOCNTN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 소득공제명세자료구분코드 : cdVvalKrnCd */
        listColumnDefs.add(new ColumnDef("소득공제명세자료구분코드", Ye161040BM.ATTR_CDVVALKRNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 건강고용등보험료 : hifeDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("건강고용등보험료", Ye161040BM.ATTR_HIFEDDCTRGTAMT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 보장성보험료 : cvrgInscDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("보장성보험료", Ye161040BM.ATTR_CVRGINSCDDCTRGTAMT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 장애인전용보장성보험료 : dsbrDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("장애인전용보장성보험료", Ye161040BM.ATTR_DSBRDDCTRGTAMT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 의료비금액 : mdxpsDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("의료비금액", Ye161040BM.ATTR_MDXPSDDCTRGTAMT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 교육비금액 : scxpsDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("교육비금액", Ye161040BM.ATTR_SCXPSDDCTRGTAMT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 신용카드_전통대중제외금액 : crdcDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("신용카드_도서공연전통대중제외금액", Ye161040BM.ATTR_CRDCDDCTRGTAMT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 직불카드등_전통대중제외금액 : drtpCardDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("직불카드등_도서공연전통대중제외금액", Ye161040BM.ATTR_DRTPCARDDDCTRGTAMT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 현금영수증_전통대중제외금액 : cshptDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("현금영수증_도서공연전통대중제외금액", Ye161040BM.ATTR_CSHPTDDCTRGTAMT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 도서이용금액 : bookShowAmt */
        listColumnDefs.add(new ColumnDef("도서공연금액", Ye161040BM.ATTR_BOOKSHOWAMT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 전통시작사용금액 : tdmrDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("전통시작사용금액", Ye161040BM.ATTR_TDMRDDCTRGTAMT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 대중교통이용금액 : pbtDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("대중교통이용금액", Ye161040BM.ATTR_PBTDDCTRGTAMT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금액 : conbDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("기부금액", Ye161040BM.ATTR_CONBDDCTRGTAMT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye161040BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye161040BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye161040BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye161040BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye161040BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye161040BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
       
          return listColumnDefs;
	}
	
	/** 기타 자료 **/
	private List<ColumnDef> getYeta63000ToYe161040ColumnsList02() {
		
		List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
//        /** column 합계 :  */ 
//        listColumnDefs.add(new ColumnDef("", Ye161040BM.ATTR_SUMNAME, ColumnDef.TYPE_STRING, 70, true, true, true));
          
//        /** column 구분 :  */
//        listColumnDefs.add(new ColumnDef("구분", Ye161040BM.ATTR_HEADER, ColumnDef.TYPE_STRING, 30, true, true, true));
        /** column 성명 : cvrgInscDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("성명", Ye161030BM.ATTR_TXPRNM, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{

        	}
        });
        
        /** column 건강등보험료 : hifeDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("건강", Ye161040BM.ATTR_HIFEDDCTRGTAMT, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{
        		setReadOnly(true);
        		setSelectOnFocus(true);
        	}
        });
        /** column 고용보험료 : mcurUiTrgtAmt */
        listColumnDefs.add(new ColumnDef("고용", Ye161040BM.ATTR_MCURUITRGTAMT, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{
        		setReadOnly(true);
        		setSelectOnFocus(true);
        	}
        });
        
        
        /** column 보장성보험료 : cvrgInscDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("보장성", Ye161040BM.ATTR_CVRGINSCDDCTRGTAMT, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
       
        /** column 장애인전용보장성보험료 : dsbrDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("장애인전용", Ye161040BM.ATTR_DSBRDDCTRGTAMT, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        
        /** column 의료비금액 : mdxpsDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("의료비", Ye161040BM.ATTR_MDXPSDDCTRGTAMT, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{
        		setReadOnly(true);
        		setSelectOnFocus(true);
        	}
        });
        
        /** column 교육비금액 : scxpsDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("교육비", Ye161040BM.ATTR_SCXPSDDCTRGTAMT, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{
        		setReadOnly(true);
        		setSelectOnFocus(true);
        	}
        });
        
        /** column 신용카드_전통대중제외금액 : crdcDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("신용카드", Ye161040BM.ATTR_CRDCDDCTRGTAMT, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        /** column 직불카드등_전통대중제외금액 : drtpCardDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("직불카드등", Ye161040BM.ATTR_DRTPCARDDDCTRGTAMT, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        /** column 현금영수증_전통대중제외금액 : cshptDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("현금영수증", Ye161040BM.ATTR_CSHPTDDCTRGTAMT, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        /** column 도서이용금액 : bookShowAmt */
        listColumnDefs.add(new ColumnDef("도서공연금액", Ye161040BM.ATTR_BOOKSHOWAMT, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        /** column 전통시작사용금액 : tdmrDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("전통시장사용액", Ye161040BM.ATTR_TDMRDDCTRGTAMT, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        /** column 대중교통이용금액 : pbtDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("대중교통이용액", Ye161040BM.ATTR_PBTDDCTRGTAMT, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        /** column 기부금액 : conbDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("기부금", Ye161040BM.ATTR_CONBDDCTRGTAMT, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{
        		setReadOnly(true);
        		setSelectOnFocus(true);
        	}
        });
        
        
        //--
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye161040BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속연도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속연도", Ye161040BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye161040BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye161040BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 주민등록번호 : txprDscmNoCntn */
        listColumnDefs.add(new ColumnDef("주민등록번호", Ye161040BM.ATTR_TXPRDSCMNOCNTN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 소득공제명세자료구분코드 : cdVvalKrnCd */
        listColumnDefs.add(new ColumnDef("소득공제명세자료구분코드", Ye161040BM.ATTR_CDVVALKRNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 건강고용등보험료 : hifeDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("건강고용등보험료", Ye161040BM.ATTR_HIFEDDCTRGTAMT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 보장성보험료 : cvrgInscDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("보장성보험료", Ye161040BM.ATTR_CVRGINSCDDCTRGTAMT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 장애인전용보장성보험료 : dsbrDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("장애인전용보장성보험료", Ye161040BM.ATTR_DSBRDDCTRGTAMT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 의료비금액 : mdxpsDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("의료비금액", Ye161040BM.ATTR_MDXPSDDCTRGTAMT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 교육비금액 : scxpsDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("교육비금액", Ye161040BM.ATTR_SCXPSDDCTRGTAMT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 신용카드_전통대중제외금액 : crdcDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("신용카드_도서공연전통대중제외금액", Ye161040BM.ATTR_CRDCDDCTRGTAMT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 직불카드등_전통대중제외금액 : drtpCardDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("직불카드등_도서공연전통대중제외금액", Ye161040BM.ATTR_DRTPCARDDDCTRGTAMT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 현금영수증_전통대중제외금액 : cshptDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("현금영수증_도서공연전통대중제외금액", Ye161040BM.ATTR_CSHPTDDCTRGTAMT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 대중교통이용금액 : bookShowAmt */
        listColumnDefs.add(new ColumnDef("도서공연금액", Ye161040BM.ATTR_BOOKSHOWAMT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 전통시작사용금액 : tdmrDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("전통시작사용금액", Ye161040BM.ATTR_TDMRDDCTRGTAMT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 대중교통이용금액 : pbtDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("대중교통이용금액", Ye161040BM.ATTR_PBTDDCTRGTAMT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금액 : conbDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("기부금액", Ye161040BM.ATTR_CONBDDCTRGTAMT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye161040BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye161040BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye161040BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye161040BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye161040BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye161040BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
       
          return listColumnDefs;
	}
	
	
} 
 
 
