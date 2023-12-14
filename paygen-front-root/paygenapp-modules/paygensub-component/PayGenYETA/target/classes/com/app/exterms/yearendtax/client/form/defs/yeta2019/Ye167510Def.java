package com.app.exterms.yearendtax.client.form.defs.yeta2019;



import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2019.Ye167510BM;
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
public class Ye167510Def  extends TableDef implements YetaDaoConstants {

    private int row = 0;
//    private YetaConstants yetaLabel = YetaConstants.INSTANCE;

    

    public Ye167510Def(String chkPayrDef){
 
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
        listColumnDefs.add(new ColumnDef("사업장코드", Ye167510BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속년도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속년도", Ye167510BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye167510BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye167510BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 서식코드 : formCd */
        listColumnDefs.add(new ColumnDef("서식코드", Ye167510BM.ATTR_FORMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 거주자성명 : fnm */
        listColumnDefs.add(new ColumnDef("거주자성명", Ye167510BM.ATTR_FNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 생년월일 : resno */
        listColumnDefs.add(new ColumnDef("생년월일", Ye167510BM.ATTR_RESNO, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근무처명 : tnm */
        listColumnDefs.add(new ColumnDef("근무처명", Ye167510BM.ATTR_TNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업자등록번호 : bsnoEncCntn */
        listColumnDefs.add(new ColumnDef("사업자등록번호", Ye167510BM.ATTR_BSNOENCCNTN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 전통시장사용분공제금액 : tdmrDdcAmt */
        listColumnDefs.add(new ColumnDef("전통시장사용분공제금액", Ye167510BM.ATTR_TDMRDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 대중교통이용분공제금액 : pbtDdcAmt */
        listColumnDefs.add(new ColumnDef("대중교통이용분공제금액", Ye167510BM.ATTR_PBTDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 직불카드등사용분공제금액 : drtpCardDdcAmt */
        listColumnDefs.add(new ColumnDef("직불카드등사용분공제금액", Ye167510BM.ATTR_DRTPCARDDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 공제제외금액계산총급여액 : totaSnwAmt */
        listColumnDefs.add(new ColumnDef("공제제외금액계산총급여액", Ye167510BM.ATTR_TOTASNWAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 공제제외금액계산최저사용금액 : minmUseAmt */
        listColumnDefs.add(new ColumnDef("공제제외금액계산최저사용금액", Ye167510BM.ATTR_MINMUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 공제제외금액계산공제제외금액 : ddcExclAmt */
        listColumnDefs.add(new ColumnDef("공제제외금액계산공제제외금액", Ye167510BM.ATTR_DDCEXCLAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 추가공제율사용분증가분공제금액 : addDdcrtDdcAmt */
        listColumnDefs.add(new ColumnDef("추가공제율사용분증가분공제금액", Ye167510BM.ATTR_ADDDDCRTDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 공제가능금액 : ddcPsbAmt */
        listColumnDefs.add(new ColumnDef("공제가능금액", Ye167510BM.ATTR_DDCPSBAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 공제한도액 : ddcLmtAmt */
        listColumnDefs.add(new ColumnDef("공제한도액", Ye167510BM.ATTR_DDCLMTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 일반공제금액 : gnrlDdcAmt */
        listColumnDefs.add(new ColumnDef("일반공제금액", Ye167510BM.ATTR_GNRLDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 전통시장추가공제금액 : tdmrAddDdcAmt */
        listColumnDefs.add(new ColumnDef("전통시장추가공제금액", Ye167510BM.ATTR_TDMRADDDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 대중교통추가공제금액 : pbtAddDdcAmt */
        listColumnDefs.add(new ColumnDef("대중교통추가공제금액", Ye167510BM.ATTR_PBTADDDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 최종공제금ㄴ액 : lstDdcAmt */
        listColumnDefs.add(new ColumnDef("최종공제금ㄴ액", Ye167510BM.ATTR_LSTDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 전전년도본인신용카드사용액_2014 : ftyrPrsCrdcUseAmt */
        listColumnDefs.add(new ColumnDef("전전년도본인신용카드사용액_2014", Ye167510BM.ATTR_FTYRPRSCRDCUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 전년도본인신용카드사용액_2015 : pyrPrsCrdcUseAmt1 */
        listColumnDefs.add(new ColumnDef("전년도본인신용카드사용액_2015", Ye167510BM.ATTR_PYRPRSCRDCUSEAMT1, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 전전년도_본인추가공제율사용분_2014 : ftyrPrsAddDdcrtAmt */
        listColumnDefs.add(new ColumnDef("전전년도_본인추가공제율사용분_2014", Ye167510BM.ATTR_FTYRPRSADDDDCRTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 당해년도상반기추가공제율사용분_2016상 : tyYrTfhyPrsAddDdcrtAmt */
        listColumnDefs.add(new ColumnDef("당해년도상반기추가공제율사용분_2016상", Ye167510BM.ATTR_TYYRTFHYPRSADDDDCRTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 신용카드사용분 공제금액 : crdcDdcAmt */
        listColumnDefs.add(new ColumnDef("신용카드사용분 공제금액", Ye167510BM.ATTR_CRDCDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye167510BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye167510BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye167510BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye167510BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye167510BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye167510BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> yrtxBlggYr;   /** column 귀속년도 : yrtxBlggYr */
//
//        private TextField<String> clutSeptCd;   /** column 연말정산구분코드 : clutSeptCd */
//
//        private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//        private TextField<String> formCd;   /** column 서식코드 : formCd */
//
//        private TextField<String> fnm;   /** column 거주자성명 : fnm */
//
//        private TextField<String> resno;   /** column 생년월일 : resno */
//
//        private TextField<String> tnm;   /** column 근무처명 : tnm */
//
//        private TextField<String> bsnoEncCntn;   /** column 사업자등록번호 : bsnoEncCntn */
//
//        private TextField<String> tdmrDdcAmt;   /** column 전통시장사용분공제금액 : tdmrDdcAmt */
//
//        private TextField<String> pbtDdcAmt;   /** column 대중교통이용분공제금액 : pbtDdcAmt */
//
//        private TextField<String> drtpCardDdcAmt;   /** column 직불카드등사용분공제금액 : drtpCardDdcAmt */
//
//        private TextField<String> totaSnwAmt;   /** column 공제제외금액계산총급여액 : totaSnwAmt */
//
//        private TextField<String> minmUseAmt;   /** column 공제제외금액계산최저사용금액 : minmUseAmt */
//
//        private TextField<String> ddcExclAmt;   /** column 공제제외금액계산공제제외금액 : ddcExclAmt */
//
//        private TextField<String> addDdcrtDdcAmt;   /** column 추가공제율사용분증가분공제금액 : addDdcrtDdcAmt */
//
//        private TextField<String> ddcPsbAmt;   /** column 공제가능금액 : ddcPsbAmt */
//
//        private TextField<String> ddcLmtAmt;   /** column 공제한도액 : ddcLmtAmt */
//
//        private TextField<String> gnrlDdcAmt;   /** column 일반공제금액 : gnrlDdcAmt */
//
//        private TextField<String> tdmrAddDdcAmt;   /** column 전통시장추가공제금액 : tdmrAddDdcAmt */
//
//        private TextField<String> pbtAddDdcAmt;   /** column 대중교통추가공제금액 : pbtAddDdcAmt */
//
//        private TextField<String> lstDdcAmt;   /** column 최종공제금ㄴ액 : lstDdcAmt */
//
//        private TextField<String> ftyrPrsCrdcUseAmt;   /** column 전전년도본인신용카드사용액_2014 : ftyrPrsCrdcUseAmt */
//
//        private TextField<String> pyrPrsCrdcUseAmt1;   /** column 전년도본인신용카드사용액_2015 : pyrPrsCrdcUseAmt1 */
//
//        private TextField<String> ftyrPrsAddDdcrtAmt;   /** column 전전년도_본인추가공제율사용분_2014 : ftyrPrsAddDdcrtAmt */
//
//        private TextField<String> tyYrTfhyPrsAddDdcrtAmt;   /** column 당해년도상반기추가공제율사용분_2016상 : tyYrTfhyPrsAddDdcrtAmt */
//
//        private TextField<String> crdcDdcAmt;   /** column 신용카드사용분 공제금액 : crdcDdcAmt */
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
 
