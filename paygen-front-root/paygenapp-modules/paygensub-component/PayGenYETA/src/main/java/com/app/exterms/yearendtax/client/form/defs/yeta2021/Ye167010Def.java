package com.app.exterms.yearendtax.client.form.defs.yeta2021;



import java.util.ArrayList;
import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2021.Ye167010BM;
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

public class Ye167010Def  extends TableDef implements YetaDaoConstants {

    private int row = 0;
//    private YetaConstants yetaLabel = YetaConstants.INSTANCE;

    

    public Ye167010Def(String chkPayrDef){
 
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
        listColumnDefs.add(new ColumnDef("사업장코드", Ye167010BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속연도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속연도", Ye167010BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye167010BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye167010BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 소득자성명 : fnm */
        listColumnDefs.add(new ColumnDef("소득자성명", Ye167010BM.ATTR_FNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 주민등록번호 : resnoEncCntn */
        listColumnDefs.add(new ColumnDef("주민등록번호", Ye167010BM.ATTR_RESNOENCCNTN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근무처명 : tnm */
        listColumnDefs.add(new ColumnDef("근무처명", Ye167010BM.ATTR_TNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업자등록번호 : bsnoEncCntn */
        listColumnDefs.add(new ColumnDef("사업자등록번호", Ye167010BM.ATTR_BSNOENCCNTN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세대주여부 : hshrClCd */
        listColumnDefs.add(new ColumnDef("세대주여부", Ye167010BM.ATTR_HSHRCLCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 국적 : rsplNtnInfrNm */
        listColumnDefs.add(new ColumnDef("국적", Ye167010BM.ATTR_RSPLNTNINFRNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 국적코드 : rsplNtnInfrCd */
        listColumnDefs.add(new ColumnDef("국적코드", Ye167010BM.ATTR_RSPLNTNINFRCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근무기간시작일자 : dtyStrtDt */
        listColumnDefs.add(new ColumnDef("근무기간시작일자", Ye167010BM.ATTR_DTYSTRTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 근무기간종료일자 : dtyEndDt */
        listColumnDefs.add(new ColumnDef("근무기간종료일자", Ye167010BM.ATTR_DTYENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 감면기간시작일자 : reStrtDt */
        listColumnDefs.add(new ColumnDef("감면기간시작일자", Ye167010BM.ATTR_RESTRTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 감면기간종료일자 : reEndDt */
        listColumnDefs.add(new ColumnDef("감면기간종료일자", Ye167010BM.ATTR_REENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 거주구분 : rsdtClCd */
        listColumnDefs.add(new ColumnDef("거주구분", Ye167010BM.ATTR_RSDTCLCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 거주지국명 : rsplNtnNm */
        listColumnDefs.add(new ColumnDef("거주지국명", Ye167010BM.ATTR_RSPLNTNNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 거주지코드 : rsplNtnCd */
        listColumnDefs.add(new ColumnDef("거주지코드", Ye167010BM.ATTR_RSPLNTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 소득세원천징수세액조정신청 : inctxWhtxTxamtMetnCd */
        listColumnDefs.add(new ColumnDef("소득세원천징수세액조정신청", Ye167010BM.ATTR_INCTXWHTXTXAMTMETNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 분납신청여부 : inpmYn */
        listColumnDefs.add(new ColumnDef("분납신청여부", Ye167010BM.ATTR_INPMYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 인적공제항목변동여부 : prifChngYn */
        listColumnDefs.add(new ColumnDef("인적공제항목변동여부", Ye167010BM.ATTR_PRIFCHNGYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기본공제인원수 : bscDdcnFpCnt */
        listColumnDefs.add(new ColumnDef("기본공제인원수", Ye167010BM.ATTR_BSCDDCNFPCNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 경로우대인원수 : sccNfpCnt */
        listColumnDefs.add(new ColumnDef("경로우대인원수", Ye167010BM.ATTR_SCCNFPCNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 출산입양인원수 : chbtAdopNfpCnt */
        listColumnDefs.add(new ColumnDef("출산입양인원수", Ye167010BM.ATTR_CHBTADOPNFPCNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 부녀자인원수 : wmnNfpCnt */
        listColumnDefs.add(new ColumnDef("부녀자인원수", Ye167010BM.ATTR_WMNNFPCNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 한부모인원수 : snprntNfpCnt */
        listColumnDefs.add(new ColumnDef("한부모인원수", Ye167010BM.ATTR_SNPRNTNFPCNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 자애인인원수 : dsbrNfpCnt */
        listColumnDefs.add(new ColumnDef("자애인인원수", Ye167010BM.ATTR_DSBRNFPCNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 6세이하인원수 : age6ltNfpCnt */
        listColumnDefs.add(new ColumnDef("6세이하인원수", Ye167010BM.ATTR_AGE6LTNFPCNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 소득공제신고전자파일제출여부 : fileSbtYn */
        listColumnDefs.add(new ColumnDef("소득공제신고전자파일제출여부", Ye167010BM.ATTR_FILESBTYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 소득공제신고전자파일적용여부 : fileAppYn */
        listColumnDefs.add(new ColumnDef("소득공제신고전자파일적용여부", Ye167010BM.ATTR_FILEAPPYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 문서종류 : docType */
        listColumnDefs.add(new ColumnDef("문서종류", Ye167010BM.ATTR_DOCTYPE, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 자료코드 : dataCd */
        listColumnDefs.add(new ColumnDef("자료코드", Ye167010BM.ATTR_DATACD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 서식코드 : formCd */
        listColumnDefs.add(new ColumnDef("서식코드", Ye167010BM.ATTR_FORMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 발급일자일련번호 : issDtSeilNum */
        listColumnDefs.add(new ColumnDef("발급일자일련번호", Ye167010BM.ATTR_ISSDTSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye167010BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye167010BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye167010BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye167010BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye167010BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye167010BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> yrtxBlggYr;   /** column 귀속연도 : yrtxBlggYr */
//
//        private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//        private TextField<String> clutSeptCd;   /** column 연말정산구분코드 : clutSeptCd */
//
//        private TextField<String> fnm;   /** column 소득자성명 : fnm */
//
//        private TextField<String> resnoEncCntn;   /** column 주민등록번호 : resnoEncCntn */
//
//        private TextField<String> tnm;   /** column 근무처명 : tnm */
//
//        private TextField<String> bsnoEncCntn;   /** column 사업자등록번호 : bsnoEncCntn */
//
//        private TextField<String> hshrClCd;   /** column 세대주여부 : hshrClCd */
//
//        private TextField<String> rsplNtnInfrNm;   /** column 국적 : rsplNtnInfrNm */
//
//        private TextField<String> rsplNtnInfrCd;   /** column 국적코드 : rsplNtnInfrCd */
//
//        private TextField<String> dtyStrtDt;   /** column 근무기간시작일자 : dtyStrtDt */
//
//        private TextField<String> dtyEndDt;   /** column 근무기간종료일자 : dtyEndDt */
//
//        private TextField<String> reStrtDt;   /** column 감면기간시작일자 : reStrtDt */
//
//        private TextField<String> reEndDt;   /** column 감면기간종료일자 : reEndDt */
//
//        private TextField<String> rsdtClCd;   /** column 거주구분 : rsdtClCd */
//
//        private TextField<String> rsplNtnNm;   /** column 거주지국명 : rsplNtnNm */
//
//        private TextField<String> rsplNtnCd;   /** column 거주지코드 : rsplNtnCd */
//
//        private TextField<String> inctxWhtxTxamtMetnCd;   /** column 소득세원천징수세액조정신청 : inctxWhtxTxamtMetnCd */
//
//        private TextField<String> inpmYn;   /** column 분납신청여부 : inpmYn */
//
//        private TextField<String> prifChngYn;   /** column 인적공제항목변동여부 : prifChngYn */
//
//        private TextField<String> bscDdcnFpCnt;   /** column 기본공제인원수 : bscDdcnFpCnt */
//
//        private TextField<String> sccNfpCnt;   /** column 경로우대인원수 : sccNfpCnt */
//
//        private TextField<String> chbtAdopNfpCnt;   /** column 출산입양인원수 : chbtAdopNfpCnt */
//
//        private TextField<String> wmnNfpCnt;   /** column 부녀자인원수 : wmnNfpCnt */
//
//        private TextField<String> snprntNfpCnt;   /** column 한부모인원수 : snprntNfpCnt */
//
//        private TextField<String> dsbrNfpCnt;   /** column 자애인인원수 : dsbrNfpCnt */
//
//        private TextField<String> age6ltNfpCnt;   /** column 6세이하인원수 : age6ltNfpCnt */
//
//        private TextField<String> fileSbtYn;   /** column 소득공제신고전자파일제출여부 : fileSbtYn */
//
//        private TextField<String> fileAppYn;   /** column 소득공제신고전자파일적용여부 : fileAppYn */
//
//        private TextField<String> docType;   /** column 문서종류 : docType */
//
//        private TextField<String> dataCd;   /** column 자료코드 : dataCd */
//
//        private TextField<String> formCd;   /** column 서식코드 : formCd */
//
//        private TextField<String> issDtSeilNum;   /** column 발급일자일련번호 : issDtSeilNum */
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
  