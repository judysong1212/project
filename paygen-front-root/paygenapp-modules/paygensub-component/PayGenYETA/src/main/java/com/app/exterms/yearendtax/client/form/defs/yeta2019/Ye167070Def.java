package com.app.exterms.yearendtax.client.form.defs.yeta2019;



import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2019.Ye167070BM;
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

public class Ye167070Def  extends TableDef implements YetaDaoConstants {

    private int row = 0;
//    private YetaConstants yetaLabel = YetaConstants.INSTANCE;

    

    public Ye167070Def(String chkPayrDef){
 
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
        listColumnDefs.add(new ColumnDef("사업장코드", Ye167070BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye167070BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속연도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속연도", Ye167070BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye167070BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 외국인근로자입국목적코드 : frgrLbrrEntcPupCd */
        listColumnDefs.add(new ColumnDef("외국인근로자입국목적코드", Ye167070BM.ATTR_FRGRLBRRENTCPUPCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 외국인그론자기술도입계약_근로제공일자 : frgrLbrrLbrOfrDt */
        listColumnDefs.add(new ColumnDef("외국인그론자기술도입계약_근로제공일자", Ye167070BM.ATTR_FRGRLBRRLBROFRDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 외국인근로자감면기간만료일자 : frgrLbrrReExryDt */
        listColumnDefs.add(new ColumnDef("외국인근로자감면기간만료일자", Ye167070BM.ATTR_FRGRLBRRREEXRYDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 외국인근로자외국인근로소득에대한감면접수일자 : frgrLbrrReRcpnDt */
        listColumnDefs.add(new ColumnDef("외국인근로자외국인근로소득에대한감면접수일자", Ye167070BM.ATTR_FRGRLBRRRERCPNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 외국인근로자외국인근로소득에대한감면제출일자 : frgrLbrrReAlfaSbmsDt */
        listColumnDefs.add(new ColumnDef("외국인근로자외국인근로소득에대한감면제출일자", Ye167070BM.ATTR_FRGRLBRRREALFASBMSDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 외국인근로자근로소득에대한조세조약상면제접수일자 : frgrLbrrErinImnRcpnDt */
        listColumnDefs.add(new ColumnDef("외국인근로자근로소득에대한조세조약상면제접수일자", Ye167070BM.ATTR_FRGRLBRRERINIMNRCPNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 외국인근로자근로소득에대한조세조약상면제제출일자 : frgrLbrrErinImnSbmsDt */
        listColumnDefs.add(new ColumnDef("외국인근로자근로소득에대한조세조약상면제제출일자", Ye167070BM.ATTR_FRGRLBRRERINIMNSBMSDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 중소기업취업자감면취업일자 : yupSnmcReStrtDt */
        listColumnDefs.add(new ColumnDef("중소기업취업자감면취업일자", Ye167070BM.ATTR_YUPSNMCRESTRTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 중소기업취업자감면기간종료일자 : yupSnmcReEndDt */
        listColumnDefs.add(new ColumnDef("중소기업취업자감면기간종료일자", Ye167070BM.ATTR_YUPSNMCREENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연금계좌_과학기술인공제납입금액 : sctcHpUseAmt */
        listColumnDefs.add(new ColumnDef("연금계좌_과학기술인공제납입금액", Ye167070BM.ATTR_SCTCHPUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 연금계좌_과학기술인공제_공제대상금액 : sctcHpDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("연금계좌_과학기술인공제_공제대상금액", Ye167070BM.ATTR_SCTCHPDDCTRGTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 연금계좌_과학기술인공제_공제세액 : sctcHpDdcAmt */
        listColumnDefs.add(new ColumnDef("연금계좌_과학기술인공제_공제세액", Ye167070BM.ATTR_SCTCHPDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 연금계좌_근로자퇴직급여보장법_퇴직연금납입금액 : rtpnUseAmt */
        listColumnDefs.add(new ColumnDef("연금계좌_근로자퇴직급여보장법_퇴직연금납입금액", Ye167070BM.ATTR_RTPNUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 연금계좌_근로자퇴직급여보장법_퇴직연금공제대상금액 : rtpnDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("연금계좌_근로자퇴직급여보장법_퇴직연금공제대상금액", Ye167070BM.ATTR_RTPNDDCTRGTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 연금계좌_근로자퇴직급여보장법_퇴직연금공제세액 : rtpnDdcAmt */
        listColumnDefs.add(new ColumnDef("연금계좌_근로자퇴직급여보장법_퇴직연금공제세액", Ye167070BM.ATTR_RTPNDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 연금계좌_연금저축납입금액 : pnsnSvngUseAmt */
        listColumnDefs.add(new ColumnDef("연금계좌_연금저축납입금액", Ye167070BM.ATTR_PNSNSVNGUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 연금계좌_연금저축공제대상금액 : pnsnSvngDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("연금계좌_연금저축공제대상금액", Ye167070BM.ATTR_PNSNSVNGDDCTRGTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 연금계좌_연금저축공제세액 : pnsnSvngDdcAmt */
        listColumnDefs.add(new ColumnDef("연금계좌_연금저축공제세액", Ye167070BM.ATTR_PNSNSVNGDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 연금계좌납입금액합계 : pnsnAccUseAmtSum */
        listColumnDefs.add(new ColumnDef("연금계좌납입금액합계", Ye167070BM.ATTR_PNSNACCUSEAMTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 연금계좌공제대상금액합계 : pnsnAccDdcTrgtAmtSum */
        listColumnDefs.add(new ColumnDef("연금계좌공제대상금액합계", Ye167070BM.ATTR_PNSNACCDDCTRGTAMTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 연금계좌공제세액합계 : pnsnAccDdcAmtSum */
        listColumnDefs.add(new ColumnDef("연금계좌공제세액합계", Ye167070BM.ATTR_PNSNACCDDCAMTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 보장성보험납입금액 : cvrgInscUseAmt */
        listColumnDefs.add(new ColumnDef("보장성보험납입금액", Ye167070BM.ATTR_CVRGINSCUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 보장성보험공제대상금액 : cvrgInscDdcTrgtAmt2 */
        listColumnDefs.add(new ColumnDef("보장성보험공제대상금액", Ye167070BM.ATTR_CVRGINSCDDCTRGTAMT2, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 보장성보험공제세액 : cvrgInscDdcAmt */
        listColumnDefs.add(new ColumnDef("보장성보험공제세액", Ye167070BM.ATTR_CVRGINSCDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 장애인전용보장성보험납입금액 : dsbrEuCvrgUseAmt */
        listColumnDefs.add(new ColumnDef("장애인전용보장성보험납입금액", Ye167070BM.ATTR_DSBREUCVRGUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 장애인전용보장성보험공제대상금액 : dsbrEuCvrgDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("장애인전용보장성보험공제대상금액", Ye167070BM.ATTR_DSBREUCVRGDDCTRGTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 장애인전용보장성보험공제세액 : dsbrEuCvrgDdcAmt */
        listColumnDefs.add(new ColumnDef("장애인전용보장성보험공제세액", Ye167070BM.ATTR_DSBREUCVRGDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 보험료납입금액합계 : infeePymUseAmtSum */
        listColumnDefs.add(new ColumnDef("보험료납입금액합계", Ye167070BM.ATTR_INFEEPYMUSEAMTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 보험료공제대상금액합계 : infeePymDdcTrgtAmtSum */
        listColumnDefs.add(new ColumnDef("보험료공제대상금액합계", Ye167070BM.ATTR_INFEEPYMDDCTRGTAMTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 보험료공제세액합계 : infeePymDdcAmtSum */
        listColumnDefs.add(new ColumnDef("보험료공제세액합계", Ye167070BM.ATTR_INFEEPYMDDCAMTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 의료비_본인65세이상장애인난임시술비납입금액 : mdxpsPrsUseAmt */
        listColumnDefs.add(new ColumnDef("의료비_본인65세이상장애인난임시술비납입금액", Ye167070BM.ATTR_MDXPSPRSUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 의료비_본인65세이상장애인난임시술비공제대상금액 : mdxpsPrsDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("의료비_본인65세이상장애인난임시술비공제대상금액", Ye167070BM.ATTR_MDXPSPRSDDCTRGTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 의료비_본인65세이상장애인난임시술비공제세액 : mdxpsPrsDdcAmt */
        listColumnDefs.add(new ColumnDef("의료비_본인65세이상장애인난임시술비공제세액", Ye167070BM.ATTR_MDXPSPRSDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 의료비_그밖의공제대상자납입금액 : mdxpsOthUseAmt */
        listColumnDefs.add(new ColumnDef("의료비_그밖의공제대상자납입금액", Ye167070BM.ATTR_MDXPSOTHUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 의료비_그밖의공제대상자공제대상금액 : mdxpsOthDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("의료비_그밖의공제대상자공제대상금액", Ye167070BM.ATTR_MDXPSOTHDDCTRGTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 의료비_그밖의공제대상자공제새액 : mdxpsOthDdcAmt */
        listColumnDefs.add(new ColumnDef("의료비_그밖의공제대상자공제새액", Ye167070BM.ATTR_MDXPSOTHDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 의료비납입금액합계 : mdxpsUseAmtSum */
        listColumnDefs.add(new ColumnDef("의료비납입금액합계", Ye167070BM.ATTR_MDXPSUSEAMTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 의료비공제대상금액합계 : mdxpsDdcTrgtAmtSum */
        listColumnDefs.add(new ColumnDef("의료비공제대상금액합계", Ye167070BM.ATTR_MDXPSDDCTRGTAMTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 의료비공제세액합계 : mdxpsDdcAmtSum */
        listColumnDefs.add(new ColumnDef("의료비공제세액합계", Ye167070BM.ATTR_MDXPSDDCAMTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 교육비_소득자본인납입금액 : scxpsPrsUseAmt */
        listColumnDefs.add(new ColumnDef("교육비_소득자본인납입금액", Ye167070BM.ATTR_SCXPSPRSUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 교육비_소득자본인공제대상금액 : scxpsPrsDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("교육비_소득자본인공제대상금액", Ye167070BM.ATTR_SCXPSPRSDDCTRGTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 교육비_소득자본인공제세액 : scxpsPrsDdcAmt */
        listColumnDefs.add(new ColumnDef("교육비_소득자본인공제세액", Ye167070BM.ATTR_SCXPSPRSDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 교육비_취학전아동납입금액 : scxpsKidUseAmt */
        listColumnDefs.add(new ColumnDef("교육비_취학전아동납입금액", Ye167070BM.ATTR_SCXPSKIDUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 교육비_취학전아동공제대상금액 : scxpsKidDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("교육비_취학전아동공제대상금액", Ye167070BM.ATTR_SCXPSKIDDDCTRGTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 교육비_취학전아동공제새액 : scxpsKidDdcAmt */
        listColumnDefs.add(new ColumnDef("교육비_취학전아동공제새액", Ye167070BM.ATTR_SCXPSKIDDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 교육비_초중고등학교납입금액 : scxpsStdUseAmt */
        listColumnDefs.add(new ColumnDef("교육비_초중고등학교납입금액", Ye167070BM.ATTR_SCXPSSTDUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 교육비_초중고등학교공제대상금액 : scxpsStdDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("교육비_초중고등학교공제대상금액", Ye167070BM.ATTR_SCXPSSTDDDCTRGTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 교육비_초중고등학교공제세액 : scxpsStdDdcAmt */
        listColumnDefs.add(new ColumnDef("교육비_초중고등학교공제세액", Ye167070BM.ATTR_SCXPSSTDDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 교육비_대학생납입금액 : scxpsUndUseAmt */
        listColumnDefs.add(new ColumnDef("교육비_대학생납입금액", Ye167070BM.ATTR_SCXPSUNDUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 교육비_대학생공제대상금액 : scxpsUndDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("교육비_대학생공제대상금액", Ye167070BM.ATTR_SCXPSUNDDDCTRGTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 교육비_대상생공제세액 : scxpsUndDdcAmt */
        listColumnDefs.add(new ColumnDef("교육비_대상생공제세액", Ye167070BM.ATTR_SCXPSUNDDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 교육비_장애인납입금액 : scxpsDsbrUseAmt */
        listColumnDefs.add(new ColumnDef("교육비_장애인납입금액", Ye167070BM.ATTR_SCXPSDSBRUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 교육비_장애인공제대상금액 : scxpsDsbrDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("교육비_장애인공제대상금액", Ye167070BM.ATTR_SCXPSDSBRDDCTRGTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 교육비_장애인공제세액 : scxpsDsbrDdcAmt */
        listColumnDefs.add(new ColumnDef("교육비_장애인공제세액", Ye167070BM.ATTR_SCXPSDSBRDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 교육비_취학전아동인원수 : scxpsKidCount */
        listColumnDefs.add(new ColumnDef("교육비_취학전아동인원수", Ye167070BM.ATTR_SCXPSKIDCOUNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 교육비_초중고등학교인원수 : scxpsStdCount */
        listColumnDefs.add(new ColumnDef("교육비_초중고등학교인원수", Ye167070BM.ATTR_SCXPSSTDCOUNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 교육비_대학생인원수 : scxpsUndCount */
        listColumnDefs.add(new ColumnDef("교육비_대학생인원수", Ye167070BM.ATTR_SCXPSUNDCOUNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 교육비_장애인인원수 : scxpsDsbrCount */
        listColumnDefs.add(new ColumnDef("교육비_장애인인원수", Ye167070BM.ATTR_SCXPSDSBRCOUNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 교육비납입금액합계 : scxpsUseAmtSum */
        listColumnDefs.add(new ColumnDef("교육비납입금액합계", Ye167070BM.ATTR_SCXPSUSEAMTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 교육비공제대상금액합계 : scxpsDdcTrgtAmtSum */
        listColumnDefs.add(new ColumnDef("교육비공제대상금액합계", Ye167070BM.ATTR_SCXPSDDCTRGTAMTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 교육비공제세액금액합계 : scxpsDdcAmtSum */
        listColumnDefs.add(new ColumnDef("교육비공제세액금액합계", Ye167070BM.ATTR_SCXPSDDCAMTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금_정치자금기부금10이하기부금 : conb10ttswLtUseAmt */
        listColumnDefs.add(new ColumnDef("기부금_정치자금기부금10이하기부금", Ye167070BM.ATTR_CONB10TTSWLTUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금_정치자금기부금10이하공제대상금액 : conb10ttswLtDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("기부금_정치자금기부금10이하공제대상금액", Ye167070BM.ATTR_CONB10TTSWLTDDCTRGTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금_정치자금기부금10이하공제세액 : conb10ttswLtDdcAmt */
        listColumnDefs.add(new ColumnDef("기부금_정치자금기부금10이하공제세액", Ye167070BM.ATTR_CONB10TTSWLTDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금_정치자금기부금10초과기부금액 : conb10excsLtUseAmt */
        listColumnDefs.add(new ColumnDef("기부금_정치자금기부금10초과기부금액", Ye167070BM.ATTR_CONB10EXCSLTUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금_정치자금기부금10초과공제대상금액 : conb10excsLtDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("기부금_정치자금기부금10초과공제대상금액", Ye167070BM.ATTR_CONB10EXCSLTDDCTRGTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금_정치자금기부금10초과공제세액 : conb10excsLtDdcAmt */
        listColumnDefs.add(new ColumnDef("기부금_정치자금기부금10초과공제세액", Ye167070BM.ATTR_CONB10EXCSLTDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금_법정기부금납입금액 : conbLglUseAmt */
        listColumnDefs.add(new ColumnDef("기부금_법정기부금납입금액", Ye167070BM.ATTR_CONBLGLUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금_법정기부금공제대상금액 : conbLglDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("기부금_법정기부금공제대상금액", Ye167070BM.ATTR_CONBLGLDDCTRGTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금_법정기부금공제세액 : conbLglDdcAmt */
        listColumnDefs.add(new ColumnDef("기부금_법정기부금공제세액", Ye167070BM.ATTR_CONBLGLDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금_우리사주조합기부금납입금액 : conbEmstAsctUseAmt */
        listColumnDefs.add(new ColumnDef("기부금_우리사주조합기부금납입금액", Ye167070BM.ATTR_CONBEMSTASCTUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금_우리사주조합기부금공제대상금액 : conbEmstAsctDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("기부금_우리사주조합기부금공제대상금액", Ye167070BM.ATTR_CONBEMSTASCTDDCTRGTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금_우리사주조합기부금공제세액 : conbEmstAsctDdcAmt */
        listColumnDefs.add(new ColumnDef("기부금_우리사주조합기부금공제세액", Ye167070BM.ATTR_CONBEMSTASCTDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금_지정기부금종교단체외기부금액 : conbReliOrgOthUseAmt */
        listColumnDefs.add(new ColumnDef("기부금_지정기부금종교단체외기부금액", Ye167070BM.ATTR_CONBRELIORGOTHUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금_지정기부금종교단체외공제대상금액 : conbReliOrgOthDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("기부금_지정기부금종교단체외공제대상금액", Ye167070BM.ATTR_CONBRELIORGOTHDDCTRGTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금_지정기부금종교단체외공제세액 : conbReliOrgOthDdcAmt */
        listColumnDefs.add(new ColumnDef("기부금_지정기부금종교단체외공제세액", Ye167070BM.ATTR_CONBRELIORGOTHDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금_지정기부금종교단체기부금액 : conbReliOrgUseAmt */
        listColumnDefs.add(new ColumnDef("기부금_지정기부금종교단체기부금액", Ye167070BM.ATTR_CONBRELIORGUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금_지정기부금종교단체공제대상금액 : conbReliOrgDdcTrgtAmt */
        listColumnDefs.add(new ColumnDef("기부금_지정기부금종교단체공제대상금액", Ye167070BM.ATTR_CONBRELIORGDDCTRGTAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금_지정기부금종교단체공제세액 : conbReliOrgDdcAmt */
        listColumnDefs.add(new ColumnDef("기부금_지정기부금종교단체공제세액", Ye167070BM.ATTR_CONBRELIORGDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금납입금액합계 : conbUseAmtSum */
        listColumnDefs.add(new ColumnDef("기부금납입금액합계", Ye167070BM.ATTR_CONBUSEAMTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금공제대상금액합계 : conbDdcTrgtAmtSum */
        listColumnDefs.add(new ColumnDef("기부금공제대상금액합계", Ye167070BM.ATTR_CONBDDCTRGTAMTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금공제세액합계 : conbDdcAmtSum */
        listColumnDefs.add(new ColumnDef("기부금공제세액합계", Ye167070BM.ATTR_CONBDDCAMTSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 외국납부세액_국외원천소득 : ovrsSurcIncFmt */
        listColumnDefs.add(new ColumnDef("외국납부세액_국외원천소득", Ye167070BM.ATTR_OVRSSURCINCFMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 외국납부세액_납세액_외화 : frgnPmtFcTxamt */
        listColumnDefs.add(new ColumnDef("외국납부세액_납세액_외화", Ye167070BM.ATTR_FRGNPMTFCTXAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 외국납부세액_납세액_원화 : frgnPmtWcTxamt */
        listColumnDefs.add(new ColumnDef("외국납부세액_납세액_원화", Ye167070BM.ATTR_FRGNPMTWCTXAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 외국납부세액납세국명 : frgnPmtTxamtTxpNtnNm */
        listColumnDefs.add(new ColumnDef("외국납부세액납세국명", Ye167070BM.ATTR_FRGNPMTTXAMTTXPNTNNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 외국납부세액납부일자 : frgnPmtTxamtPmtDt */
        listColumnDefs.add(new ColumnDef("외국납부세액납부일자", Ye167070BM.ATTR_FRGNPMTTXAMTPMTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 외국납부세액신청서제출일자 : frgnPmtTxamtAlfaSbmsDt */
        listColumnDefs.add(new ColumnDef("외국납부세액신청서제출일자", Ye167070BM.ATTR_FRGNPMTTXAMTALFASBMSDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 외국납부세액국외근무처명 : frgnPmtTxamtAbrdWkarNm */
        listColumnDefs.add(new ColumnDef("외국납부세액국외근무처명", Ye167070BM.ATTR_FRGNPMTTXAMTABRDWKARNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 외국납부세액_근무기간일자 : frgnDtyTerm */
        listColumnDefs.add(new ColumnDef("외국납부세액_근무기간일자", Ye167070BM.ATTR_FRGNDTYTERM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 외국납부세액직책 : frgnPmtTxamtRfoNm */
        listColumnDefs.add(new ColumnDef("외국납부세액직책", Ye167070BM.ATTR_FRGNPMTTXAMTRFONM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 주택자금차입금이자세액공제이자상환액 : hsngTennLnpbUseAmt */
        listColumnDefs.add(new ColumnDef("주택자금차입금이자세액공제이자상환액", Ye167070BM.ATTR_HSNGTENNLNPBUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 주택자금차입금이자세액공제세액금액 : hsngTennLnpbDdcAmt */
        listColumnDefs.add(new ColumnDef("주택자금차입금이자세액공제세액금액", Ye167070BM.ATTR_HSNGTENNLNPBDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 월세액세액공제지출금액 : mmrUseAmt */
        listColumnDefs.add(new ColumnDef("월세액세액공제지출금액", Ye167070BM.ATTR_MMRUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 월세액세액공제공제세액 : mmrDdcAmt */
        listColumnDefs.add(new ColumnDef("월세액세액공제공제세액", Ye167070BM.ATTR_MMRDDCAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 신고인 : cd218 */
        listColumnDefs.add(new ColumnDef("신고인", Ye167070BM.ATTR_CD218, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 외국인근로자단일세율적용신청서제출여부 : d219 */
        listColumnDefs.add(new ColumnDef("외국인근로자단일세율적용신청서제출여부", Ye167070BM.ATTR_D219, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 종근무지명 : cd222 */
        listColumnDefs.add(new ColumnDef("종근무지명", Ye167070BM.ATTR_CD222, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 종급여총액 : cd221 */
        listColumnDefs.add(new ColumnDef("종급여총액", Ye167070BM.ATTR_CD221, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 사업자등록번호 : cd220 */
        listColumnDefs.add(new ColumnDef("사업자등록번호", Ye167070BM.ATTR_CD220, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 종결정세액 : cd223 */
        listColumnDefs.add(new ColumnDef("종결정세액", Ye167070BM.ATTR_CD223, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 종근무지근로소득명세서제출여부 : prcspWorkIncmSumtYn */
        listColumnDefs.add(new ColumnDef("종근무지근로소득명세서제출여부", Ye167070BM.ATTR_PRCSPWORKINCMSUMTYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연금저축등소득세액공제명세서제출여부 : cd225 */
        listColumnDefs.add(new ColumnDef("연금저축등소득세액공제명세서제출여부", Ye167070BM.ATTR_CD225, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 월세액거주자간주책입차차입금원리금상환액소득세액공제명세서제출여부 : cd226 */
        listColumnDefs.add(new ColumnDef("월세액거주자간주책입차차입금원리금상환액소득세액공제명세서제출여부", Ye167070BM.ATTR_CD226, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 의료비지급명세서제출여부 : cd227 */
        listColumnDefs.add(new ColumnDef("의료비지급명세서제출여부", Ye167070BM.ATTR_CD227, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금명세서제출여부 : cd228 */
        listColumnDefs.add(new ColumnDef("기부금명세서제출여부", Ye167070BM.ATTR_CD228, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 소득공제신고서제출일자 : incmDducWtnnteSumtDt */
        listColumnDefs.add(new ColumnDef("소득공제신고서제출일자", Ye167070BM.ATTR_INCMDDUCWTNNTESUMTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye167070BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye167070BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye167070BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye167070BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye167070BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye167070BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
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
//        private TextField<String> frgrLbrrEntcPupCd;   /** column 외국인근로자입국목적코드 : frgrLbrrEntcPupCd */
//
//        private TextField<String> frgrLbrrLbrOfrDt;   /** column 외국인그론자기술도입계약_근로제공일자 : frgrLbrrLbrOfrDt */
//
//        private TextField<String> frgrLbrrReExryDt;   /** column 외국인근로자감면기간만료일자 : frgrLbrrReExryDt */
//
//        private TextField<String> frgrLbrrReRcpnDt;   /** column 외국인근로자외국인근로소득에대한감면접수일자 : frgrLbrrReRcpnDt */
//
//        private TextField<String> frgrLbrrReAlfaSbmsDt;   /** column 외국인근로자외국인근로소득에대한감면제출일자 : frgrLbrrReAlfaSbmsDt */
//
//        private TextField<String> frgrLbrrErinImnRcpnDt;   /** column 외국인근로자근로소득에대한조세조약상면제접수일자 : frgrLbrrErinImnRcpnDt */
//
//        private TextField<String> frgrLbrrErinImnSbmsDt;   /** column 외국인근로자근로소득에대한조세조약상면제제출일자 : frgrLbrrErinImnSbmsDt */
//
//        private TextField<String> yupSnmcReStrtDt;   /** column 중소기업취업자감면취업일자 : yupSnmcReStrtDt */
//
//        private TextField<String> yupSnmcReEndDt;   /** column 중소기업취업자감면기간종료일자 : yupSnmcReEndDt */
//
//        private TextField<String> sctcHpUseAmt;   /** column 연금계좌_과학기술인공제납입금액 : sctcHpUseAmt */
//
//        private TextField<String> sctcHpDdcTrgtAmt;   /** column 연금계좌_과학기술인공제_공제대상금액 : sctcHpDdcTrgtAmt */
//
//        private TextField<String> sctcHpDdcAmt;   /** column 연금계좌_과학기술인공제_공제세액 : sctcHpDdcAmt */
//
//        private TextField<String> rtpnUseAmt;   /** column 연금계좌_근로자퇴직급여보장법_퇴직연금납입금액 : rtpnUseAmt */
//
//        private TextField<String> rtpnDdcTrgtAmt;   /** column 연금계좌_근로자퇴직급여보장법_퇴직연금공제대상금액 : rtpnDdcTrgtAmt */
//
//        private TextField<String> rtpnDdcAmt;   /** column 연금계좌_근로자퇴직급여보장법_퇴직연금공제세액 : rtpnDdcAmt */
//
//        private TextField<String> pnsnSvngUseAmt;   /** column 연금계좌_연금저축납입금액 : pnsnSvngUseAmt */
//
//        private TextField<String> pnsnSvngDdcTrgtAmt;   /** column 연금계좌_연금저축공제대상금액 : pnsnSvngDdcTrgtAmt */
//
//        private TextField<String> pnsnSvngDdcAmt;   /** column 연금계좌_연금저축공제세액 : pnsnSvngDdcAmt */
//
//        private TextField<String> pnsnAccUseAmtSum;   /** column 연금계좌납입금액합계 : pnsnAccUseAmtSum */
//
//        private TextField<String> pnsnAccDdcTrgtAmtSum;   /** column 연금계좌공제대상금액합계 : pnsnAccDdcTrgtAmtSum */
//
//        private TextField<String> pnsnAccDdcAmtSum;   /** column 연금계좌공제세액합계 : pnsnAccDdcAmtSum */
//
//        private TextField<String> cvrgInscUseAmt;   /** column 보장성보험납입금액 : cvrgInscUseAmt */
//
//        private TextField<String> cvrgInscDdcTrgtAmt2;   /** column 보장성보험공제대상금액 : cvrgInscDdcTrgtAmt2 */
//
//        private TextField<String> cvrgInscDdcAmt;   /** column 보장성보험공제세액 : cvrgInscDdcAmt */
//
//        private TextField<String> dsbrEuCvrgUseAmt;   /** column 장애인전용보장성보험납입금액 : dsbrEuCvrgUseAmt */
//
//        private TextField<String> dsbrEuCvrgDdcTrgtAmt;   /** column 장애인전용보장성보험공제대상금액 : dsbrEuCvrgDdcTrgtAmt */
//
//        private TextField<String> dsbrEuCvrgDdcAmt;   /** column 장애인전용보장성보험공제세액 : dsbrEuCvrgDdcAmt */
//
//        private TextField<String> infeePymUseAmtSum;   /** column 보험료납입금액합계 : infeePymUseAmtSum */
//
//        private TextField<String> infeePymDdcTrgtAmtSum;   /** column 보험료공제대상금액합계 : infeePymDdcTrgtAmtSum */
//
//        private TextField<String> infeePymDdcAmtSum;   /** column 보험료공제세액합계 : infeePymDdcAmtSum */
//
//        private TextField<String> mdxpsPrsUseAmt;   /** column 의료비_본인65세이상장애인난임시술비납입금액 : mdxpsPrsUseAmt */
//
//        private TextField<String> mdxpsPrsDdcTrgtAmt;   /** column 의료비_본인65세이상장애인난임시술비공제대상금액 : mdxpsPrsDdcTrgtAmt */
//
//        private TextField<String> mdxpsPrsDdcAmt;   /** column 의료비_본인65세이상장애인난임시술비공제세액 : mdxpsPrsDdcAmt */
//
//        private TextField<String> mdxpsOthUseAmt;   /** column 의료비_그밖의공제대상자납입금액 : mdxpsOthUseAmt */
//
//        private TextField<String> mdxpsOthDdcTrgtAmt;   /** column 의료비_그밖의공제대상자공제대상금액 : mdxpsOthDdcTrgtAmt */
//
//        private TextField<String> mdxpsOthDdcAmt;   /** column 의료비_그밖의공제대상자공제새액 : mdxpsOthDdcAmt */
//
//        private TextField<String> mdxpsUseAmtSum;   /** column 의료비납입금액합계 : mdxpsUseAmtSum */
//
//        private TextField<String> mdxpsDdcTrgtAmtSum;   /** column 의료비공제대상금액합계 : mdxpsDdcTrgtAmtSum */
//
//        private TextField<String> mdxpsDdcAmtSum;   /** column 의료비공제세액합계 : mdxpsDdcAmtSum */
//
//        private TextField<String> scxpsPrsUseAmt;   /** column 교육비_소득자본인납입금액 : scxpsPrsUseAmt */
//
//        private TextField<String> scxpsPrsDdcTrgtAmt;   /** column 교육비_소득자본인공제대상금액 : scxpsPrsDdcTrgtAmt */
//
//        private TextField<String> scxpsPrsDdcAmt;   /** column 교육비_소득자본인공제세액 : scxpsPrsDdcAmt */
//
//        private TextField<String> scxpsKidUseAmt;   /** column 교육비_취학전아동납입금액 : scxpsKidUseAmt */
//
//        private TextField<String> scxpsKidDdcTrgtAmt;   /** column 교육비_취학전아동공제대상금액 : scxpsKidDdcTrgtAmt */
//
//        private TextField<String> scxpsKidDdcAmt;   /** column 교육비_취학전아동공제새액 : scxpsKidDdcAmt */
//
//        private TextField<String> scxpsStdUseAmt;   /** column 교육비_초중고등학교납입금액 : scxpsStdUseAmt */
//
//        private TextField<String> scxpsStdDdcTrgtAmt;   /** column 교육비_초중고등학교공제대상금액 : scxpsStdDdcTrgtAmt */
//
//        private TextField<String> scxpsStdDdcAmt;   /** column 교육비_초중고등학교공제세액 : scxpsStdDdcAmt */
//
//        private TextField<String> scxpsUndUseAmt;   /** column 교육비_대학생납입금액 : scxpsUndUseAmt */
//
//        private TextField<String> scxpsUndDdcTrgtAmt;   /** column 교육비_대학생공제대상금액 : scxpsUndDdcTrgtAmt */
//
//        private TextField<String> scxpsUndDdcAmt;   /** column 교육비_대상생공제세액 : scxpsUndDdcAmt */
//
//        private TextField<String> scxpsDsbrUseAmt;   /** column 교육비_장애인납입금액 : scxpsDsbrUseAmt */
//
//        private TextField<String> scxpsDsbrDdcTrgtAmt;   /** column 교육비_장애인공제대상금액 : scxpsDsbrDdcTrgtAmt */
//
//        private TextField<String> scxpsDsbrDdcAmt;   /** column 교육비_장애인공제세액 : scxpsDsbrDdcAmt */
//
//        private TextField<String> scxpsKidCount;   /** column 교육비_취학전아동인원수 : scxpsKidCount */
//
//        private TextField<String> scxpsStdCount;   /** column 교육비_초중고등학교인원수 : scxpsStdCount */
//
//        private TextField<String> scxpsUndCount;   /** column 교육비_대학생인원수 : scxpsUndCount */
//
//        private TextField<String> scxpsDsbrCount;   /** column 교육비_장애인인원수 : scxpsDsbrCount */
//
//        private TextField<String> scxpsUseAmtSum;   /** column 교육비납입금액합계 : scxpsUseAmtSum */
//
//        private TextField<String> scxpsDdcTrgtAmtSum;   /** column 교육비공제대상금액합계 : scxpsDdcTrgtAmtSum */
//
//        private TextField<String> scxpsDdcAmtSum;   /** column 교육비공제세액금액합계 : scxpsDdcAmtSum */
//
//        private TextField<String> conb10ttswLtUseAmt;   /** column 기부금_정치자금기부금10이하기부금 : conb10ttswLtUseAmt */
//
//        private TextField<String> conb10ttswLtDdcTrgtAmt;   /** column 기부금_정치자금기부금10이하공제대상금액 : conb10ttswLtDdcTrgtAmt */
//
//        private TextField<String> conb10ttswLtDdcAmt;   /** column 기부금_정치자금기부금10이하공제세액 : conb10ttswLtDdcAmt */
//
//        private TextField<String> conb10excsLtUseAmt;   /** column 기부금_정치자금기부금10초과기부금액 : conb10excsLtUseAmt */
//
//        private TextField<String> conb10excsLtDdcTrgtAmt;   /** column 기부금_정치자금기부금10초과공제대상금액 : conb10excsLtDdcTrgtAmt */
//
//        private TextField<String> conb10excsLtDdcAmt;   /** column 기부금_정치자금기부금10초과공제세액 : conb10excsLtDdcAmt */
//
//        private TextField<String> conbLglUseAmt;   /** column 기부금_법정기부금납입금액 : conbLglUseAmt */
//
//        private TextField<String> conbLglDdcTrgtAmt;   /** column 기부금_법정기부금공제대상금액 : conbLglDdcTrgtAmt */
//
//        private TextField<String> conbLglDdcAmt;   /** column 기부금_법정기부금공제세액 : conbLglDdcAmt */
//
//        private TextField<String> conbEmstAsctUseAmt;   /** column 기부금_우리사주조합기부금납입금액 : conbEmstAsctUseAmt */
//
//        private TextField<String> conbEmstAsctDdcTrgtAmt;   /** column 기부금_우리사주조합기부금공제대상금액 : conbEmstAsctDdcTrgtAmt */
//
//        private TextField<String> conbEmstAsctDdcAmt;   /** column 기부금_우리사주조합기부금공제세액 : conbEmstAsctDdcAmt */
//
//        private TextField<String> conbReliOrgOthUseAmt;   /** column 기부금_지정기부금종교단체외기부금액 : conbReliOrgOthUseAmt */
//
//        private TextField<String> conbReliOrgOthDdcTrgtAmt;   /** column 기부금_지정기부금종교단체외공제대상금액 : conbReliOrgOthDdcTrgtAmt */
//
//        private TextField<String> conbReliOrgOthDdcAmt;   /** column 기부금_지정기부금종교단체외공제세액 : conbReliOrgOthDdcAmt */
//
//        private TextField<String> conbReliOrgUseAmt;   /** column 기부금_지정기부금종교단체기부금액 : conbReliOrgUseAmt */
//
//        private TextField<String> conbReliOrgDdcTrgtAmt;   /** column 기부금_지정기부금종교단체공제대상금액 : conbReliOrgDdcTrgtAmt */
//
//        private TextField<String> conbReliOrgDdcAmt;   /** column 기부금_지정기부금종교단체공제세액 : conbReliOrgDdcAmt */
//
//        private TextField<String> conbUseAmtSum;   /** column 기부금납입금액합계 : conbUseAmtSum */
//
//        private TextField<String> conbDdcTrgtAmtSum;   /** column 기부금공제대상금액합계 : conbDdcTrgtAmtSum */
//
//        private TextField<String> conbDdcAmtSum;   /** column 기부금공제세액합계 : conbDdcAmtSum */
//
//        private TextField<String> ovrsSurcIncFmt;   /** column 외국납부세액_국외원천소득 : ovrsSurcIncFmt */
//
//        private TextField<String> frgnPmtFcTxamt;   /** column 외국납부세액_납세액_외화 : frgnPmtFcTxamt */
//
//        private TextField<String> frgnPmtWcTxamt;   /** column 외국납부세액_납세액_원화 : frgnPmtWcTxamt */
//
//        private TextField<String> frgnPmtTxamtTxpNtnNm;   /** column 외국납부세액납세국명 : frgnPmtTxamtTxpNtnNm */
//
//        private TextField<String> frgnPmtTxamtPmtDt;   /** column 외국납부세액납부일자 : frgnPmtTxamtPmtDt */
//
//        private TextField<String> frgnPmtTxamtAlfaSbmsDt;   /** column 외국납부세액신청서제출일자 : frgnPmtTxamtAlfaSbmsDt */
//
//        private TextField<String> frgnPmtTxamtAbrdWkarNm;   /** column 외국납부세액국외근무처명 : frgnPmtTxamtAbrdWkarNm */
//
//        private TextField<String> frgnDtyTerm;   /** column 외국납부세액_근무기간일자 : frgnDtyTerm */
//
//        private TextField<String> frgnPmtTxamtRfoNm;   /** column 외국납부세액직책 : frgnPmtTxamtRfoNm */
//
//        private TextField<String> hsngTennLnpbUseAmt;   /** column 주택자금차입금이자세액공제이자상환액 : hsngTennLnpbUseAmt */
//
//        private TextField<String> hsngTennLnpbDdcAmt;   /** column 주택자금차입금이자세액공제세액금액 : hsngTennLnpbDdcAmt */
//
//        private TextField<String> mmrUseAmt;   /** column 월세액세액공제지출금액 : mmrUseAmt */
//
//        private TextField<String> mmrDdcAmt;   /** column 월세액세액공제공제세액 : mmrDdcAmt */
//
//        private TextField<String> cd218;   /** column 신고인 : cd218 */
//
//        private TextField<String> d219;   /** column 외국인근로자단일세율적용신청서제출여부 : d219 */
//
//        private TextField<String> cd222;   /** column 종근무지명 : cd222 */
//
//        private TextField<String> cd221;   /** column 종급여총액 : cd221 */
//
//        private TextField<String> cd220;   /** column 사업자등록번호 : cd220 */
//
//        private TextField<String> cd223;   /** column 종결정세액 : cd223 */
//
//        private TextField<String> prcspWorkIncmSumtYn;   /** column 종근무지근로소득명세서제출여부 : prcspWorkIncmSumtYn */
//
//        private TextField<String> cd225;   /** column 연금저축등소득세액공제명세서제출여부 : cd225 */
//
//        private TextField<String> cd226;   /** column 월세액거주자간주책입차차입금원리금상환액소득세액공제명세서제출여부 : cd226 */
//
//        private TextField<String> cd227;   /** column 의료비지급명세서제출여부 : cd227 */
//
//        private TextField<String> cd228;   /** column 기부금명세서제출여부 : cd228 */
//
//        private TextField<String> incmDducWtnnteSumtDt;   /** column 소득공제신고서제출일자 : incmDducWtnnteSumtDt */
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
 
 
