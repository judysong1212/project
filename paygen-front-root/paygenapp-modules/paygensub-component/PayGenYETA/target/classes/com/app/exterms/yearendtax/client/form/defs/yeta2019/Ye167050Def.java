package com.app.exterms.yearendtax.client.form.defs.yeta2019;



import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2019.Ye167050BM;
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

public class Ye167050Def  extends TableDef implements YetaDaoConstants {

    private int row = 0;
//    private YetaConstants yetaLabel = YetaConstants.INSTANCE;

    

    public Ye167050Def(String chkPayrDef){
 
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
        listColumnDefs.add(new ColumnDef("사업장코드", Ye167050BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye167050BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속연도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속연도", Ye167050BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye167050BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 국민건강보험_종근무지보험료금액 : hthrHifeAmt */
        listColumnDefs.add(new ColumnDef("국민건강보험_종근무지보험료금액", Ye167050BM.ATTR_HTHRHIFEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 국민건강보험_종근무지보험료공제액 : hthrHifeDdcAmt */
        listColumnDefs.add(new ColumnDef("국민건강보험_종근무지보험료공제액", Ye167050BM.ATTR_HTHRHIFEDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 국민건강보험_주근무지보험료금액 : mcurHifeAmt */
        listColumnDefs.add(new ColumnDef("국민건강보험_주근무지보험료금액", Ye167050BM.ATTR_MCURHIFEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 국민건강보험_주근무지보험료공제액 : mcurHifeDdcAmt */
        listColumnDefs.add(new ColumnDef("국민건강보험_주근무지보험료공제액", Ye167050BM.ATTR_MCURHIFEDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 고용보험_종근무지보험료금액 : hthrUiAmt */
        listColumnDefs.add(new ColumnDef("고용보험_종근무지보험료금액", Ye167050BM.ATTR_HTHRUIAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 고용보험_종근무지보험료공제액 : hthrUiDdcAmt */
        listColumnDefs.add(new ColumnDef("고용보험_종근무지보험료공제액", Ye167050BM.ATTR_HTHRUIDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 고용보험_주근무지보험료금액 : mcurUiAmt */
        listColumnDefs.add(new ColumnDef("고용보험_주근무지보험료금액", Ye167050BM.ATTR_MCURUIAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 고용보험_주근무지보험료공제액 : mcurUiDdcAmt */
        listColumnDefs.add(new ColumnDef("고용보험_주근무지보험료공제액", Ye167050BM.ATTR_MCURUIDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 건강고용_보험료보험료합계 : infeeUseAmtSum */
        listColumnDefs.add(new ColumnDef("건강고용_보험료보험료합계", Ye167050BM.ATTR_INFEEUSEAMTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 건강고용_보험료공제액합계 : infeeDdcAmtSum */
        listColumnDefs.add(new ColumnDef("건강고용_보험료공제액합계", Ye167050BM.ATTR_INFEEDDCAMTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 주택임차차입금대출기관차입원리금상환액 : brwLnpbSrmAmt */
        listColumnDefs.add(new ColumnDef("주택임차차입금대출기관차입원리금상환액", Ye167050BM.ATTR_BRWLNPBSRMAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 주택임차차입금대출기관차입공제액 : brwLnpbSrmDdcAmt */
        listColumnDefs.add(new ColumnDef("주택임차차입금대출기관차입공제액", Ye167050BM.ATTR_BRWLNPBSRMDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 주택임차차입금거주자차입원리금상환액 : rsdtLnpbSrmAmt */
        listColumnDefs.add(new ColumnDef("주택임차차입금거주자차입원리금상환액", Ye167050BM.ATTR_RSDTLNPBSRMAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 주택임차차입금거주자차입공제액 : rsdtLnpbSrmDdcAmt */
        listColumnDefs.add(new ColumnDef("주택임차차입금거주자차입공제액", Ye167050BM.ATTR_RSDTLNPBSRMDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 장기주택저장차입금2011년이전차입분중15년미만이자상환액 : lthYr15BlwItrAmt */
        listColumnDefs.add(new ColumnDef("장기주택저장차입금2011년이전차입분중15년미만이자상환액", Ye167050BM.ATTR_LTHYR15BLWITRAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 장기주택저당차입금2011년이전차입분15년미만공제액 : lthYr15BlwDdcAmt */
        listColumnDefs.add(new ColumnDef("장기주택저당차입금2011년이전차입분15년미만공제액", Ye167050BM.ATTR_LTHYR15BLWDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 장기주택저당차입금2011년이전차입분중15_29년이자상환액 : lthYr29ItrAmt */
        listColumnDefs.add(new ColumnDef("장기주택저당차입금2011년이전차입분중15_29년이자상환액", Ye167050BM.ATTR_LTHYR29ITRAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 장기주택저당차입금2011년이전차입분15_29년공제액 : lthYr29DdcAmt */
        listColumnDefs.add(new ColumnDef("장기주택저당차입금2011년이전차입분15_29년공제액", Ye167050BM.ATTR_LTHYR29DDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 장기주택저당차입금2011이전차입분중30년이상이자상환액 : lthY30OverItrAmt */
        listColumnDefs.add(new ColumnDef("장기주택저당차입금2011이전차입분중30년이상이자상환액", Ye167050BM.ATTR_LTHY30OVERITRAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 장기주택저당차입금2011이전차입분20년이상공제액 : lthY30OverDdcAmt */
        listColumnDefs.add(new ColumnDef("장기주택저당차입금2011이전차입분20년이상공제액", Ye167050BM.ATTR_LTHY30OVERDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 장기주택저당차입금2012이후고정금리이거나비거치상환대출이자상환액 : lthYr2012AfthY15Amt */
        listColumnDefs.add(new ColumnDef("장기주택저당차입금2012이후고정금리이거나비거치상환대출이자상환액", Ye167050BM.ATTR_LTHYR2012AFTHY15AMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 장기주택저당차입금2012이후고정금리이거나비거치산환대출공제액 : lthYr2012AfthY15DdcAmt */
        listColumnDefs.add(new ColumnDef("장기주택저당차입금2012이후고정금리이거나비거치산환대출공제액", Ye167050BM.ATTR_LTHYR2012AFTHY15DDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 장기주택저당차입금2012이후기타대출이자상환액 : lthYr2012EtcBrwItrAmt */
        listColumnDefs.add(new ColumnDef("장기주택저당차입금2012이후기타대출이자상환액", Ye167050BM.ATTR_LTHYR2012ETCBRWITRAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 장기주택저당차입금2012이후기타대출공제액 : lthYr2012EtcBrwDdcAmt */
        listColumnDefs.add(new ColumnDef("장기주택저당차입금2012이후기타대출공제액", Ye167050BM.ATTR_LTHYR2012ETCBRWDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 장기주택저당차입금2015이후_15이상_고정금리이면서비거치상환대출이자상환액 : lthYr2015AfthFxnIrItrAmt */
        listColumnDefs.add(new ColumnDef("장기주택저당차입금2015이후_15이상_고정금리이면서비거치상환대출이자상환액", Ye167050BM.ATTR_LTHYR2015AFTHFXNIRITRAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 장기주택저당차입금2015이후_15이상_고정금리이면서비거치상환대출공제액 : lthYr2015AfthFxnIrDdcAmt */
        listColumnDefs.add(new ColumnDef("장기주택저당차입금2015이후_15이상_고정금리이면서비거치상환대출공제액", Ye167050BM.ATTR_LTHYR2015AFTHFXNIRDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 장기주택저당차입금2015이후_15이상_고정금리이거나비거치상환대출이자상환액 : lthYr2015AfthY15Amt */
        listColumnDefs.add(new ColumnDef("장기주택저당차입금2015이후_15이상_고정금리이거나비거치상환대출이자상환액", Ye167050BM.ATTR_LTHYR2015AFTHY15AMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 장기주택저당차입금2015이후_15이상_고정금리이거나비거치상환대출공제액 : lthYr2015AfthY15DdcAmt */
        listColumnDefs.add(new ColumnDef("장기주택저당차입금2015이후_15이상_고정금리이거나비거치상환대출공제액", Ye167050BM.ATTR_LTHYR2015AFTHY15DDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 장기주택저당차입금2015이후_15이상_기타대출이자상환액 : lthYr2015AfthEtcAmt */
        listColumnDefs.add(new ColumnDef("장기주택저당차입금2015이후_15이상_기타대출이자상환액", Ye167050BM.ATTR_LTHYR2015AFTHETCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 장기주택저당차입금2015이후_15이상_기타대출공제액 : lthYr2015AfthEtcDdcAmt */
        listColumnDefs.add(new ColumnDef("장기주택저당차입금2015이후_15이상_기타대출공제액", Ye167050BM.ATTR_LTHYR2015AFTHETCDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 장기주택저당차입금_2015이후_10_15고정금리이거나비거치상환대출이자상환액 : lthYr2015AfthYr15Amt */
        listColumnDefs.add(new ColumnDef("장기주택저당차입금_2015이후_10_15고정금리이거나비거치상환대출이자상환액", Ye167050BM.ATTR_LTHYR2015AFTHYR15AMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 장기주택저당차입금_2015이후_10_15고정금리이거나비거치상환대출공제액 : lthYr2015AfthYr15DdcAmt */
        listColumnDefs.add(new ColumnDef("장기주택저당차입금_2015이후_10_15고정금리이거나비거치상환대출공제액", Ye167050BM.ATTR_LTHYR2015AFTHYR15DDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 주택자금공제액_합계 : hsngFndsDdcAmtSum */
        listColumnDefs.add(new ColumnDef("주택자금공제액_합계", Ye167050BM.ATTR_HSNGFNDSDDCAMTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금이월분_법정기부금기부금납입액 : conbLglUseAmt */
        listColumnDefs.add(new ColumnDef("기부금이월분_법정기부금기부금납입액", Ye167050BM.ATTR_CONBLGLUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금이월분_법정기부금기부금공제액 : conbLglDdcAmt */
        listColumnDefs.add(new ColumnDef("기부금이월분_법정기부금기부금공제액", Ye167050BM.ATTR_CONBLGLDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금이월분_지정기부금_종교단체외납입액 : conbReliOrgOthUseAmt */
        listColumnDefs.add(new ColumnDef("기부금이월분_지정기부금_종교단체외납입액", Ye167050BM.ATTR_CONBRELIORGOTHUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금이월분_지정기부금_종교단체외공제액 : conbReliOrgOthDdcAmt */
        listColumnDefs.add(new ColumnDef("기부금이월분_지정기부금_종교단체외공제액", Ye167050BM.ATTR_CONBRELIORGOTHDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금이월분_지정기부금_종교단체납입액 : conbReliOrgUseAmt */
        listColumnDefs.add(new ColumnDef("기부금이월분_지정기부금_종교단체납입액", Ye167050BM.ATTR_CONBRELIORGUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금이월분_지정기부금_종교단체공제액 : conbReliOrgDdcAmt */
        listColumnDefs.add(new ColumnDef("기부금이월분_지정기부금_종교단체공제액", Ye167050BM.ATTR_CONBRELIORGDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금이월분_지정기부금납입분합계 : conbUseAmtSum */
        listColumnDefs.add(new ColumnDef("기부금이월분_지정기부금납입분합계", Ye167050BM.ATTR_CONBUSEAMTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금이월분_지정기부금공제합계 : conbDdcAmtSum */
        listColumnDefs.add(new ColumnDef("기부금이월분_지정기부금공제합계", Ye167050BM.ATTR_CONBDDCAMTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye167050BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye167050BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye167050BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye167050BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye167050BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye167050BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
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
//        private TextField<String> hthrHifeAmt;   /** column 국민건강보험_종근무지보험료금액 : hthrHifeAmt */
//
//        private TextField<String> hthrHifeDdcAmt;   /** column 국민건강보험_종근무지보험료공제액 : hthrHifeDdcAmt */
//
//        private TextField<String> mcurHifeAmt;   /** column 국민건강보험_주근무지보험료금액 : mcurHifeAmt */
//
//        private TextField<String> mcurHifeDdcAmt;   /** column 국민건강보험_주근무지보험료공제액 : mcurHifeDdcAmt */
//
//        private TextField<String> hthrUiAmt;   /** column 고용보험_종근무지보험료금액 : hthrUiAmt */
//
//        private TextField<String> hthrUiDdcAmt;   /** column 고용보험_종근무지보험료공제액 : hthrUiDdcAmt */
//
//        private TextField<String> mcurUiAmt;   /** column 고용보험_주근무지보험료금액 : mcurUiAmt */
//
//        private TextField<String> mcurUiDdcAmt;   /** column 고용보험_주근무지보험료공제액 : mcurUiDdcAmt */
//
//        private TextField<String> infeeUseAmtSum;   /** column 건강고용_보험료보험료합계 : infeeUseAmtSum */
//
//        private TextField<String> infeeDdcAmtSum;   /** column 건강고용_보험료공제액합계 : infeeDdcAmtSum */
//
//        private TextField<String> brwLnpbSrmAmt;   /** column 주택임차차입금대출기관차입원리금상환액 : brwLnpbSrmAmt */
//
//        private TextField<String> brwLnpbSrmDdcAmt;   /** column 주택임차차입금대출기관차입공제액 : brwLnpbSrmDdcAmt */
//
//        private TextField<String> rsdtLnpbSrmAmt;   /** column 주택임차차입금거주자차입원리금상환액 : rsdtLnpbSrmAmt */
//
//        private TextField<String> rsdtLnpbSrmDdcAmt;   /** column 주택임차차입금거주자차입공제액 : rsdtLnpbSrmDdcAmt */
//
//        private TextField<String> lthYr15BlwItrAmt;   /** column 장기주택저장차입금2011년이전차입분중15년미만이자상환액 : lthYr15BlwItrAmt */
//
//        private TextField<String> lthYr15BlwDdcAmt;   /** column 장기주택저당차입금2011년이전차입분15년미만공제액 : lthYr15BlwDdcAmt */
//
//        private TextField<String> lthYr29ItrAmt;   /** column 장기주택저당차입금2011년이전차입분중15_29년이자상환액 : lthYr29ItrAmt */
//
//        private TextField<String> lthYr29DdcAmt;   /** column 장기주택저당차입금2011년이전차입분15_29년공제액 : lthYr29DdcAmt */
//
//        private TextField<String> lthY30OverItrAmt;   /** column 장기주택저당차입금2011이전차입분중30년이상이자상환액 : lthY30OverItrAmt */
//
//        private TextField<String> lthY30OverDdcAmt;   /** column 장기주택저당차입금2011이전차입분20년이상공제액 : lthY30OverDdcAmt */
//
//        private TextField<String> lthYr2012AfthY15Amt;   /** column 장기주택저당차입금2012이후고정금리이거나비거치상환대출이자상환액 : lthYr2012AfthY15Amt */
//
//        private TextField<String> lthYr2012AfthY15DdcAmt;   /** column 장기주택저당차입금2012이후고정금리이거나비거치산환대출공제액 : lthYr2012AfthY15DdcAmt */
//
//        private TextField<String> lthYr2012EtcBrwItrAmt;   /** column 장기주택저당차입금2012이후기타대출이자상환액 : lthYr2012EtcBrwItrAmt */
//
//        private TextField<String> lthYr2012EtcBrwDdcAmt;   /** column 장기주택저당차입금2012이후기타대출공제액 : lthYr2012EtcBrwDdcAmt */
//
//        private TextField<String> lthYr2015AfthFxnIrItrAmt;   /** column 장기주택저당차입금2015이후_15이상_고정금리이면서비거치상환대출이자상환액 : lthYr2015AfthFxnIrItrAmt */
//
//        private TextField<String> lthYr2015AfthFxnIrDdcAmt;   /** column 장기주택저당차입금2015이후_15이상_고정금리이면서비거치상환대출공제액 : lthYr2015AfthFxnIrDdcAmt */
//
//        private TextField<String> lthYr2015AfthY15Amt;   /** column 장기주택저당차입금2015이후_15이상_고정금리이거나비거치상환대출이자상환액 : lthYr2015AfthY15Amt */
//
//        private TextField<String> lthYr2015AfthY15DdcAmt;   /** column 장기주택저당차입금2015이후_15이상_고정금리이거나비거치상환대출공제액 : lthYr2015AfthY15DdcAmt */
//
//        private TextField<String> lthYr2015AfthEtcAmt;   /** column 장기주택저당차입금2015이후_15이상_기타대출이자상환액 : lthYr2015AfthEtcAmt */
//
//        private TextField<String> lthYr2015AfthEtcDdcAmt;   /** column 장기주택저당차입금2015이후_15이상_기타대출공제액 : lthYr2015AfthEtcDdcAmt */
//
//        private TextField<String> lthYr2015AfthYr15Amt;   /** column 장기주택저당차입금_2015이후_10_15고정금리이거나비거치상환대출이자상환액 : lthYr2015AfthYr15Amt */
//
//        private TextField<String> lthYr2015AfthYr15DdcAmt;   /** column 장기주택저당차입금_2015이후_10_15고정금리이거나비거치상환대출공제액 : lthYr2015AfthYr15DdcAmt */
//
//        private TextField<String> hsngFndsDdcAmtSum;   /** column 주택자금공제액_합계 : hsngFndsDdcAmtSum */
//
//        private TextField<String> conbLglUseAmt;   /** column 기부금이월분_법정기부금기부금납입액 : conbLglUseAmt */
//
//        private TextField<String> conbLglDdcAmt;   /** column 기부금이월분_법정기부금기부금공제액 : conbLglDdcAmt */
//
//        private TextField<String> conbReliOrgOthUseAmt;   /** column 기부금이월분_지정기부금_종교단체외납입액 : conbReliOrgOthUseAmt */
//
//        private TextField<String> conbReliOrgOthDdcAmt;   /** column 기부금이월분_지정기부금_종교단체외공제액 : conbReliOrgOthDdcAmt */
//
//        private TextField<String> conbReliOrgUseAmt;   /** column 기부금이월분_지정기부금_종교단체납입액 : conbReliOrgUseAmt */
//
//        private TextField<String> conbReliOrgDdcAmt;   /** column 기부금이월분_지정기부금_종교단체공제액 : conbReliOrgDdcAmt */
//
//        private TextField<String> conbUseAmtSum;   /** column 기부금이월분_지정기부금납입분합계 : conbUseAmtSum */
//
//        private TextField<String> conbDdcAmtSum;   /** column 기부금이월분_지정기부금공제합계 : conbDdcAmtSum */
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
//      
 
            
            return listColumnDefs;
        }
    
     
} 
 
       