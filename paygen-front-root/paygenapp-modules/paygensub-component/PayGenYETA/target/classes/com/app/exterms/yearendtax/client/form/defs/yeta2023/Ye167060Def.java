package com.app.exterms.yearendtax.client.form.defs.yeta2023;



import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2023.Ye167060BM;
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
public class Ye167060Def  extends TableDef implements YetaDaoConstants {

    private int row = 0;
//    private YetaConstants yetaLabel = YetaConstants.INSTANCE;

    

    public Ye167060Def(String chkPayrDef){
 
        if ("".equals(chkPayrDef)) {  
          	
          setDaoClass("");
//          setCustomListMethod(CLASS_PAYR0304TOPAYR4200_DATA_LIST);
          setAutoFillGrid(false);
          setShowFilterToolbar(false); 
          
          setCheckBoxOnGridRows(true); 

          setColumnsDefinition(getPayr0304ToPayr4420ColumnsList());
          
      }
 
        
    }
     
    private List<ColumnDef> getPayr0304ToPayr4420ColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 


        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye167060BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye167060BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속연도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속연도", Ye167060BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye167060BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 개인연금저축_2000이전_납입금액 : yr2000PnsnSvngUseAmt */
        listColumnDefs.add(new ColumnDef("개인연금저축_2000이전_납입금액", Ye167060BM.ATTR_YR2000PNSNSVNGUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 개인연금저축_2000이전_공제액 : yr2000PnsnSvngDdcAmt */
        listColumnDefs.add(new ColumnDef("개인연금저축_2000이전_공제액", Ye167060BM.ATTR_YR2000PNSNSVNGDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 소기업소상인공제부금납입금액 : smceSbizUseAmt */
        listColumnDefs.add(new ColumnDef("소기업소상인공제부금납입금액", Ye167060BM.ATTR_SMCESBIZUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 소기업소상인공제부금공제액 : smceSbizDdcAmt */
        listColumnDefs.add(new ColumnDef("소기업소상인공제부금공제액", Ye167060BM.ATTR_SMCESBIZDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 주택마련저축_청약저축납입금액 : sbcSvngUseAmt */
        listColumnDefs.add(new ColumnDef("주택마련저축_청약저축납입금액", Ye167060BM.ATTR_SBCSVNGUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 주택마련저축_청약저축공제액 : sbcSvngDdcAmt */
        listColumnDefs.add(new ColumnDef("주택마련저축_청약저축공제액", Ye167060BM.ATTR_SBCSVNGDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 주택마련저축_근로자주택마련저축납입금액 : lbrrPrptSvngUseAmt */
        listColumnDefs.add(new ColumnDef("주택마련저축_근로자주택마련저축납입금액", Ye167060BM.ATTR_LBRRPRPTSVNGUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 주택마련저축_근로자주택마련저축공제액 : lbrrPrptSvngDdcAmt */
        listColumnDefs.add(new ColumnDef("주택마련저축_근로자주택마련저축공제액", Ye167060BM.ATTR_LBRRPRPTSVNGDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 주택마련저축_주택청약종합저축납입금액 : hsngSvngUseAmt */
        listColumnDefs.add(new ColumnDef("주택마련저축_주택청약종합저축납입금액", Ye167060BM.ATTR_HSNGSVNGUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 주택마련저축_주택청약종합저축공제액 : hsngSvngDdcAmt */
        listColumnDefs.add(new ColumnDef("주택마련저축_주택청약종합저축공제액", Ye167060BM.ATTR_HSNGSVNGDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 주택마련저축_소득공제합계 : hsngIncUseAmtSum */
        listColumnDefs.add(new ColumnDef("주택마련저축_소득공제합계", Ye167060BM.ATTR_HSNGINCUSEAMTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 주택마련저축소득공제액합계 : hsngIncDdcAmtSum */
        listColumnDefs.add(new ColumnDef("주택마련저축소득공제액합계", Ye167060BM.ATTR_HSNGINCDDCAMTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 출자투자금액_조합등_2014납입금액 : cpivAsctUseAmt2 */
        listColumnDefs.add(new ColumnDef("출자투자금액_조합등_2014납입금액", Ye167060BM.ATTR_CPIVASCTUSEAMT2, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 출자투자금액_조합등_2014공제액 : cpivAsctDdcAmt2 */
        listColumnDefs.add(new ColumnDef("출자투자금액_조합등_2014공제액", Ye167060BM.ATTR_CPIVASCTDDCAMT2, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 출자투자금액_벤처등_2014납입금액 : cpivVntUseAmt2 */
        listColumnDefs.add(new ColumnDef("출자투자금액_벤처등_2014납입금액", Ye167060BM.ATTR_CPIVVNTUSEAMT2, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 출자투자금액_벤처등_2014공제액 : cpivVntDdcAmt2 */
        listColumnDefs.add(new ColumnDef("출자투자금액_벤처등_2014공제액", Ye167060BM.ATTR_CPIVVNTDDCAMT2, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 출자투자금액_조합등_2015납입금액 : cpivAsctUseAmt1 */
        listColumnDefs.add(new ColumnDef("출자투자금액_조합등_2015납입금액", Ye167060BM.ATTR_CPIVASCTUSEAMT1, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 출자투자금액_조합등_2015공제액 : cpivAsctDdcAmt1 */
        listColumnDefs.add(new ColumnDef("출자투자금액_조합등_2015공제액", Ye167060BM.ATTR_CPIVASCTDDCAMT1, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 출자투자금액_벤처등_2015납입금액 : cpivVntUseAmt1 */
        listColumnDefs.add(new ColumnDef("출자투자금액_벤처등_2015납입금액", Ye167060BM.ATTR_CPIVVNTUSEAMT1, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 출자투자금액_벤처등_2015공제액 : cpivVntDdcAmt1 */
        listColumnDefs.add(new ColumnDef("출자투자금액_벤처등_2015공제액", Ye167060BM.ATTR_CPIVVNTDDCAMT1, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 출자투자금액_조합등_2016납입금 : cpivAsctUseAmt0 */
        listColumnDefs.add(new ColumnDef("출자투자금액_조합등_2016납입금", Ye167060BM.ATTR_CPIVASCTUSEAMT0, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 출자투자금액 조합등_2016공제액 : cpivAsctDdcAmt0 */
        listColumnDefs.add(new ColumnDef("출자투자금액 조합등_2016공제액", Ye167060BM.ATTR_CPIVASCTDDCAMT0, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 출자투자금액벤처등_2016납입금액 : cpivVntUseAmt0 */
        listColumnDefs.add(new ColumnDef("출자투자금액벤처등_2016납입금액", Ye167060BM.ATTR_CPIVVNTUSEAMT0, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 출자투자금액벤처등_2016공제액 : cpivVntDdcAmt0 */
        listColumnDefs.add(new ColumnDef("출자투자금액벤처등_2016공제액", Ye167060BM.ATTR_CPIVVNTDDCAMT0, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 투자조합출자등소득공제납입금액계 : ivcpInvmUseAmtSum */
        listColumnDefs.add(new ColumnDef("투자조합출자등소득공제납입금액계", Ye167060BM.ATTR_IVCPINVMUSEAMTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 투자조합출자등소득공제공제액계 : ivcpInvmDdcAmtSum */
        listColumnDefs.add(new ColumnDef("투자조합출자등소득공제공제액계", Ye167060BM.ATTR_IVCPINVMDDCAMTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 신용카드_전통대중제외사용금액 : crdcUseAmt */
        listColumnDefs.add(new ColumnDef("신용카드_전통대중제외사용금액", Ye167060BM.ATTR_CRDCUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 직불선불카드_전통대중제외사용금액 : drtpCardUseAmt */
        listColumnDefs.add(new ColumnDef("직불선불카드_전통대중제외사용금액", Ye167060BM.ATTR_DRTPCARDUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 현금영수증_전통대중제외사용금액 : cshptUseAmt */
        listColumnDefs.add(new ColumnDef("현금영수증_전통대중제외사용금액", Ye167060BM.ATTR_CSHPTUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 전통시장사용금액 : tdmrUseAmt */
        listColumnDefs.add(new ColumnDef("전통시장사용금액", Ye167060BM.ATTR_TDMRUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 대중교통이용금액 : pbtUseAmt */
        listColumnDefs.add(new ColumnDef("대중교통이용금액", Ye167060BM.ATTR_PBTUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 신용카드등사용액합계 : crdcSumUseAmt */
        listColumnDefs.add(new ColumnDef("신용카드등사용액합계", Ye167060BM.ATTR_CRDCSUMUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 신용카드등사용공제액합계 : rdcSumDdcAmt */
        listColumnDefs.add(new ColumnDef("신용카드등사용공제액합계", Ye167060BM.ATTR_RDCSUMDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 본인신용카드등사용액_2014 : prsCrdcUseAmt1 */
        listColumnDefs.add(new ColumnDef("본인신용카드등사용액_2014", Ye167060BM.ATTR_PRSCRDCUSEAMT1, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 본인신용등사용액_2015 : tyYrPrsCrdcUseAmt */
        listColumnDefs.add(new ColumnDef("본인신용등사용액_2015", Ye167060BM.ATTR_TYYRPRSCRDCUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 본인추가공제율사용분_2014 : pyrPrsAddDdcrtUseAmt */
        listColumnDefs.add(new ColumnDef("본인추가공제율사용분_2014", Ye167060BM.ATTR_PYRPRSADDDDCRTUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 본인추가공제울사용분_2015_2016 : tyShfyPrsAddDdcrtUseAmt */
        listColumnDefs.add(new ColumnDef("본인추가공제울사용분_2015_2016", Ye167060BM.ATTR_TYSHFYPRSADDDDCRTUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 우리사주조합출연금액 : emstAsctCntrUseAmt */
        listColumnDefs.add(new ColumnDef("우리사주조합출연금액", Ye167060BM.ATTR_EMSTASCTCNTRUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 우리사주조합출연금공제금액 : emstAsctCntrDdcAmt */
        listColumnDefs.add(new ColumnDef("우리사주조합출연금공제금액", Ye167060BM.ATTR_EMSTASCTCNTRDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 고용유지중소기업근로자임금삭감액 : empMntnSnmcUseAmt */
        listColumnDefs.add(new ColumnDef("고용유지중소기업근로자임금삭감액", Ye167060BM.ATTR_EMPMNTNSNMCUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 고용유지중소기업근로자공제금액 : empMntnSnmcDdcAmt */
        listColumnDefs.add(new ColumnDef("고용유지중소기업근로자공제금액", Ye167060BM.ATTR_EMPMNTNSNMCDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 장기집합투자증권저축납입금액 : ltrmCniSsUseAmt */
        listColumnDefs.add(new ColumnDef("장기집합투자증권저축납입금액", Ye167060BM.ATTR_LTRMCNISSUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 장기집합투자증권저축공제금액 : ltrmCniSsDdcAmt */
        listColumnDefs.add(new ColumnDef("장기집합투자증권저축공제금액", Ye167060BM.ATTR_LTRMCNISSDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye167060BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye167060BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye167060BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye167060BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye167060BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye167060BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//        private TextField<String> yrtxBlggYr;   /** column 귀속연도 : yrtxBlggYr */
//
//        private TextField<String> clutSeptCd;   /** column 연말정산구분코드 : clutSeptCd */
//
//        private TextField<String> yr2000PnsnSvngUseAmt;   /** column 개인연금저축_2000이전_납입금액 : yr2000PnsnSvngUseAmt */
//
//        private TextField<String> yr2000PnsnSvngDdcAmt;   /** column 개인연금저축_2000이전_공제액 : yr2000PnsnSvngDdcAmt */
//
//        private TextField<String> smceSbizUseAmt;   /** column 소기업소상인공제부금납입금액 : smceSbizUseAmt */
//
//        private TextField<String> smceSbizDdcAmt;   /** column 소기업소상인공제부금공제액 : smceSbizDdcAmt */
//
//        private TextField<String> sbcSvngUseAmt;   /** column 주택마련저축_청약저축납입금액 : sbcSvngUseAmt */
//
//        private TextField<String> sbcSvngDdcAmt;   /** column 주택마련저축_청약저축공제액 : sbcSvngDdcAmt */
//
//        private TextField<String> lbrrPrptSvngUseAmt;   /** column 주택마련저축_근로자주택마련저축납입금액 : lbrrPrptSvngUseAmt */
//
//        private TextField<String> lbrrPrptSvngDdcAmt;   /** column 주택마련저축_근로자주택마련저축공제액 : lbrrPrptSvngDdcAmt */
//
//        private TextField<String> hsngSvngUseAmt;   /** column 주택마련저축_주택청약종합저축납입금액 : hsngSvngUseAmt */
//
//        private TextField<String> hsngSvngDdcAmt;   /** column 주택마련저축_주택청약종합저축공제액 : hsngSvngDdcAmt */
//
//        private TextField<String> hsngIncUseAmtSum;   /** column 주택마련저축_소득공제합계 : hsngIncUseAmtSum */
//
//        private TextField<String> hsngIncDdcAmtSum;   /** column 주택마련저축소득공제액합계 : hsngIncDdcAmtSum */
//
//        private TextField<String> cpivAsctUseAmt2;   /** column 출자투자금액_조합등_2014납입금액 : cpivAsctUseAmt2 */
//
//        private TextField<String> cpivAsctDdcAmt2;   /** column 출자투자금액_조합등_2014공제액 : cpivAsctDdcAmt2 */
//
//        private TextField<String> cpivVntUseAmt2;   /** column 출자투자금액_벤처등_2014납입금액 : cpivVntUseAmt2 */
//
//        private TextField<String> cpivVntDdcAmt2;   /** column 출자투자금액_벤처등_2014공제액 : cpivVntDdcAmt2 */
//
//        private TextField<String> cpivAsctUseAmt1;   /** column 출자투자금액_조합등_2015납입금액 : cpivAsctUseAmt1 */
//
//        private TextField<String> cpivAsctDdcAmt1;   /** column 출자투자금액_조합등_2015공제액 : cpivAsctDdcAmt1 */
//
//        private TextField<String> cpivVntUseAmt1;   /** column 출자투자금액_벤처등_2015납입금액 : cpivVntUseAmt1 */
//
//        private TextField<String> cpivVntDdcAmt1;   /** column 출자투자금액_벤처등_2015공제액 : cpivVntDdcAmt1 */
//
//        private TextField<String> cpivAsctUseAmt0;   /** column 출자투자금액_조합등_2016납입금 : cpivAsctUseAmt0 */
//
//        private TextField<String> cpivAsctDdcAmt0;   /** column 출자투자금액 조합등_2016공제액 : cpivAsctDdcAmt0 */
//
//        private TextField<String> cpivVntUseAmt0;   /** column 출자투자금액벤처등_2016납입금액 : cpivVntUseAmt0 */
//
//        private TextField<String> cpivVntDdcAmt0;   /** column 출자투자금액벤처등_2016공제액 : cpivVntDdcAmt0 */
//
//        private TextField<String> ivcpInvmUseAmtSum;   /** column 투자조합출자등소득공제납입금액계 : ivcpInvmUseAmtSum */
//
//        private TextField<String> ivcpInvmDdcAmtSum;   /** column 투자조합출자등소득공제공제액계 : ivcpInvmDdcAmtSum */
//
//        private TextField<String> crdcUseAmt;   /** column 신용카드_전통대중제외사용금액 : crdcUseAmt */
//
//        private TextField<String> drtpCardUseAmt;   /** column 직불선불카드_전통대중제외사용금액 : drtpCardUseAmt */
//
//        private TextField<String> cshptUseAmt;   /** column 현금영수증_전통대중제외사용금액 : cshptUseAmt */
//
//        private TextField<String> tdmrUseAmt;   /** column 전통시장사용금액 : tdmrUseAmt */
//
//        private TextField<String> pbtUseAmt;   /** column 대중교통이용금액 : pbtUseAmt */
//
//        private TextField<String> crdcSumUseAmt;   /** column 신용카드등사용액합계 : crdcSumUseAmt */
//
//        private TextField<String> rdcSumDdcAmt;   /** column 신용카드등사용공제액합계 : rdcSumDdcAmt */
//
//        private TextField<String> prsCrdcUseAmt1;   /** column 본인신용카드등사용액_2014 : prsCrdcUseAmt1 */
//
//        private TextField<String> tyYrPrsCrdcUseAmt;   /** column 본인신용등사용액_2015 : tyYrPrsCrdcUseAmt */
//
//        private TextField<String> pyrPrsAddDdcrtUseAmt;   /** column 본인추가공제율사용분_2014 : pyrPrsAddDdcrtUseAmt */
//
//        private TextField<String> tyShfyPrsAddDdcrtUseAmt;   /** column 본인추가공제울사용분_2015_2016 : tyShfyPrsAddDdcrtUseAmt */
//
//        private TextField<String> emstAsctCntrUseAmt;   /** column 우리사주조합출연금액 : emstAsctCntrUseAmt */
//
//        private TextField<String> emstAsctCntrDdcAmt;   /** column 우리사주조합출연금공제금액 : emstAsctCntrDdcAmt */
//
//        private TextField<String> empMntnSnmcUseAmt;   /** column 고용유지중소기업근로자임금삭감액 : empMntnSnmcUseAmt */
//
//        private TextField<String> empMntnSnmcDdcAmt;   /** column 고용유지중소기업근로자공제금액 : empMntnSnmcDdcAmt */
//
//        private TextField<String> ltrmCniSsUseAmt;   /** column 장기집합투자증권저축납입금액 : ltrmCniSsUseAmt */
//
//        private TextField<String> ltrmCniSsDdcAmt;   /** column 장기집합투자증권저축공제금액 : ltrmCniSsDdcAmt */
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

            
            return listColumnDefs;
        }
    
     
} 
 
 
