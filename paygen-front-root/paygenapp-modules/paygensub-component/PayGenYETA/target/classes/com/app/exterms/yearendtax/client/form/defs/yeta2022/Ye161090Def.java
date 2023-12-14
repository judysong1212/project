package com.app.exterms.yearendtax.client.form.defs.yeta2022;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComPsnl0115BM;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.exterms.yearendtax.client.dto.yeta2022.Ye161090BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**
 * @Class Name : Ye161090Def.java
 * @since : 2017. 12. 27. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
public class Ye161090Def  extends TableDef implements YetaDaoConstants {

    private int row = 0;
//    private YetaConstants yetaLabel = YetaConstants.INSTANCE;
    private PrgmComBass0300DTO sysComBass0300Dto;
    

	public Ye161090Def(String chkPayrDef) {
		
		sysComBass0300Dto = new PrgmComBass0300DTO();
		
		if ("YETA730001".equals(chkPayrDef)) {

			setDaoClass("");
			setCustomListMethod(CLASS_YETA7300_TO_YE161090_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true);
			setEditableGrid(true);
			setEditFieldGrid(true);
			setColumnsDefinition(getYeta7300ToYe161090ColumnsList01());

		}else if("YETA730002".equals(chkPayrDef)){
			
			setDaoClass("");
			setCustomListMethod(CLASS_YETA7300_TO_YE161090_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true);
			setEditableGrid(true);
			setEditFieldGrid(true);
			setColumnsDefinition(getYeta7300ToYe161090ColumnsList02());
			
		}else {
			
			setDaoClass("");
			 setCustomListMethod(CLASS_YETA7300_TO_YE161090_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true);
			setColumnsDefinition(getYe161090ColumnsList());
			
		}

	}
     
    private List<ColumnDef> getYe161090ColumnsList(){
    	
    	
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 


        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye161090BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속연도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속연도", Ye161090BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye161090BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye161090BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 가족주민등록번호 : famResnoEncCntn */
        listColumnDefs.add(new ColumnDef("가족주민등록번호", Ye161090BM.ATTR_FAMRESNOENCCNTN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 교육비공제대상구분코드 : scxpsStd */
        listColumnDefs.add(new ColumnDef("교육비공제대상구분코드", Ye161090BM.ATTR_SCXPSSTD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 교육비지출금액 : scxpsUseAmt */
        listColumnDefs.add(new ColumnDef("교육비지출금액", Ye161090BM.ATTR_SCXPSUSEAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 개별공제대상금액 : scxpsStdDdcTrgtIndvAmt */
        listColumnDefs.add(new ColumnDef("개별공제대상금액", Ye161090BM.ATTR_SCXPSSTDDDCTRGTINDVAMT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye161090BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye161090BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye161090BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye161090BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye161090BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye161090BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

//        private TextField<String> dpobCd;   /** column 사업장코드 : dpobCd */
//
//        private TextField<String> yrtxBlggYr;   /** column 귀속연도 : yrtxBlggYr */
//
//        private TextField<String> clutSeptCd;   /** column 연말정산구분코드 : clutSeptCd */
//
//        private TextField<String> systemkey;   /** column SYSTEMKEY : systemkey */
//
//        private TextField<String> famResnoEncCntn;   /** column 가족주민등록번호 : famResnoEncCntn */
//
//        private TextField<String> scxpsStd;   /** column 교육비공제대상구분코드 : scxpsStd */
//
//        private TextField<String> scxpsUseAmt;   /** column 교육비지출금액 : scxpsUseAmt */
//
//        private TextField<String> scxpsStdDdcTrgtIndvAmt;   /** column 개별공제대상금액 : scxpsStdDdcTrgtIndvAmt */
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
    
    private List<ColumnDef> getYeta7300ToYe161090ColumnsList01(){
    	
    	
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 

       
        
        /** column 가족성명 : famyNm */
        listColumnDefs.add(new ColumnDef("성명",  PrgmComPsnl0115BM.ATTR_FAMYNM, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        /** column 가족주민등록번호 : famResnoEncCntn */
        listColumnDefs.add(new ColumnDef("주민등록번호", Ye161090BM.ATTR_FAMRESNOENCCNTN, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{
        		setTextFdMask("999999-9999999");
        		setReadOnly(true);
        	}
        });
        
        sysComBass0300Dto.setRpsttvCd("Y014");
        /** set 소득공제명세자료구분코드 : cdVvalKrnCd */
        listColumnDefs.add(new ColumnListDef("자료구분", Ye161090BM.ATTR_CDVVALKRNCD,   ColumnDef.TYPE_STRING, 100, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{
        		setReadOnly(true);
            }
        });
        
        
        sysComBass0300Dto.setRpsttvCd("Y003");
        /** column 교육비공제대상구분코드 : scxpsStd */
        listColumnDefs.add(new ColumnListDef("공제대상구분", Ye161090BM.ATTR_SCXPSSTD,   ColumnDef.TYPE_STRING, 100, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{

            }
        });
        
        
        sysComBass0300Dto.setRpsttvCd("Y020");
        /** column 교육비구분코드 : scxpsStdClDivCd */
        listColumnDefs.add(new ColumnListDef("교육구분", Ye161090BM.ATTR_SCXPSSTDCLDIVCD,   ColumnDef.TYPE_STRING, 100, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{

            }
        });
        
        /** column 교육비지출금액 : scxpsUseAmt */
        listColumnDefs.add(new ColumnDef("지출금액", Ye161090BM.ATTR_SCXPSUSEAMT, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{

        	}
        });
        
        /** column 개별공제대상금액 : scxpsStdDdcTrgtIndvAmt */
        listColumnDefs.add(new ColumnDef("개별공제대상금액", Ye161090BM.ATTR_SCXPSSTDDDCTRGTINDVAMT, ColumnDef.TYPE_LONG , 120, false, true, false){
        	{
        		setReadOnly(true);
        	}
        });
        
        //-- 

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye161090BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속연도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속연도", Ye161090BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye161090BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye161090BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 가족주민등록번호 : famResnoEncCntn */
        listColumnDefs.add(new ColumnDef("가족주민등록번호", Ye161090BM.ATTR_FAMRESNOENCCNTN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
      


        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye161090BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye161090BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye161090BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye161090BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye161090BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye161090BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        
        /** column 교육비공제대상구분코드 : scxpsStd */
        listColumnDefs.add(new ColumnDef("공제대상구분", Ye161090BM.ATTR_SCXPSSTDTMP,   ColumnDef.TYPE_STRING, 100, false, false, false){
        	{

            }
        });
        
        /** column 교육비공제대상구분코드 : scxpsStd */
        listColumnDefs.add(new ColumnDef("공제대상구분", Ye161090BM.ATTR_SCXPSSTDNM,   ColumnDef.TYPE_STRING, 100, false, false, false){
        	{

            }
        });
        
        /** column 교육비공제대상구분코드 : scxpsStd */
        listColumnDefs.add(new ColumnDef("공제대상구분", Ye161090BM.ATTR_SCXPSSTDCLDIVCDTMP,   ColumnDef.TYPE_STRING, 100, false, false, false){
        	{

            }
        });
        
        /** column 교육비공제대상구분코드 : scxpsStd */
        listColumnDefs.add(new ColumnDef("공제대상구분", Ye161090BM.ATTR_SCXPSSTDCLDIVNM,   ColumnDef.TYPE_STRING, 100, false, false, false){
        	{

            }
        });

		return listColumnDefs;
	}
  
    
    private List<ColumnDef> getYeta7300ToYe161090ColumnsList02(){
    	
    	
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 

       
        
        /** column 가족성명 : famyNm */
        listColumnDefs.add(new ColumnDef("성명",  PrgmComPsnl0115BM.ATTR_FAMYNM, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        /** column 가족주민등록번호 : famResnoEncCntn */
        listColumnDefs.add(new ColumnDef("주민등록번호", Ye161090BM.ATTR_FAMRESNOENCCNTN, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{
        		setTextFdMask("999999-9999999");
        		setReadOnly(true);
        	}
        });
        
        sysComBass0300Dto.setRpsttvCd("Y014");
        /** set 소득공제명세자료구분코드 : cdVvalKrnCd */
        listColumnDefs.add(new ColumnListDef("자료구분", Ye161090BM.ATTR_CDVVALKRNCD,   ColumnDef.TYPE_STRING, 100, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{
        		setReadOnly(true);
            }
        });
        
        
        sysComBass0300Dto.setRpsttvCd("Y003");
        /** column 교육비공제대상구분코드 : scxpsStd */
        listColumnDefs.add(new ColumnListDef("공제대상구분", Ye161090BM.ATTR_SCXPSSTD,   ColumnDef.TYPE_STRING, 100, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{

            }
        });
        
        
        sysComBass0300Dto.setRpsttvCd("Y020");
        /** column 교육비구분코드 : scxpsStdClDivCd */
        listColumnDefs.add(new ColumnListDef("교육구분", Ye161090BM.ATTR_SCXPSSTDCLDIVCD,   ColumnDef.TYPE_STRING, 100, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{
        		setReadOnly(true);
            }
        });
        
        /** column 교육비지출금액 : scxpsUseAmt */
        listColumnDefs.add(new ColumnDef("지출금액", Ye161090BM.ATTR_SCXPSUSEAMT, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        /** column 개별공제대상금액 : scxpsStdDdcTrgtIndvAmt */
        listColumnDefs.add(new ColumnDef("개별공제대상금액", Ye161090BM.ATTR_SCXPSSTDDDCTRGTINDVAMT, ColumnDef.TYPE_LONG , 120, false, true, false){
        	{
        		setReadOnly(true);
        	}
        });
        
        //-- 

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye161090BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속연도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속연도", Ye161090BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye161090BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye161090BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 가족주민등록번호 : famResnoEncCntn */
        listColumnDefs.add(new ColumnDef("가족주민등록번호", Ye161090BM.ATTR_FAMRESNOENCCNTN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
      


        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye161090BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye161090BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye161090BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye161090BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye161090BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye161090BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        
        /** column 교육비공제대상구분코드 : scxpsStd */
        listColumnDefs.add(new ColumnDef("공제대상구분", Ye161090BM.ATTR_SCXPSSTDTMP,   ColumnDef.TYPE_STRING, 100, false, false, false){
        	{

            }
        });
        
        /** column 교육비공제대상구분코드 : scxpsStd */
        listColumnDefs.add(new ColumnDef("공제대상구분", Ye161090BM.ATTR_SCXPSSTDNM,   ColumnDef.TYPE_STRING, 100, false, false, false){
        	{

            }
        });
        
        /** column 교육비공제대상구분코드 : scxpsStd */
        listColumnDefs.add(new ColumnDef("공제대상구분", Ye161090BM.ATTR_SCXPSSTDCLDIVCDTMP,   ColumnDef.TYPE_STRING, 100, false, false, false){
        	{

            }
        });
        
        /** column 교육비공제대상구분코드 : scxpsStd */
        listColumnDefs.add(new ColumnDef("공제대상구분", Ye161090BM.ATTR_SCXPSSTDCLDIVNM,   ColumnDef.TYPE_STRING, 100, false, false, false){
        	{

            }
        });

		return listColumnDefs;
	}
        
    
} 
 

 
