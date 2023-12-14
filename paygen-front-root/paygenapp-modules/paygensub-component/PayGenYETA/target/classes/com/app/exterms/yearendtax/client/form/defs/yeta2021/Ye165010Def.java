package com.app.exterms.yearendtax.client.form.defs.yeta2021;



import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.exterms.yearendtax.client.dto.yeta2021.Ye165010BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;


/**
 * @Class Name : Ye165010Def.java
 * @since : 2017. 12. 12. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
public class Ye165010Def  extends TableDef implements YetaDaoConstants {

	private int row = 0;
	private PrgmComBass0300DTO sysComBass0300Dto; 
	// private YetaConstants yetaLabel = YetaConstants.INSTANCE;

	public Ye165010Def(String chkPayrDef) {
		
		sysComBass0300Dto = new PrgmComBass0300DTO();

		if ("YetaP63003".equals(chkPayrDef)) {

			setDaoClass("");
			setCustomListMethod(CLASS_YETAP63003_TO_YE165010_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true);
			setEditableGrid(true);
			setEditFieldGrid(true);
			setColumnsDefinition(getYetaP63003ToYe165010ColumnsList());

		}else {
			setDaoClass("");
			setCustomListMethod(CLASS_YETAP63003_TO_YE165010_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true);
			setColumnsDefinition(getYe165010ColumnsList());
		}

	}
     
    private List<ColumnDef> getYe165010ColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye165010BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye165010BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속연도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속연도", Ye165010BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye165010BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금일련번호 : cnbtSeilNum */
        listColumnDefs.add(new ColumnDef("기부금일련번호", Ye165010BM.ATTR_CNBTSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기부유형 : conbCd */
        listColumnDefs.add(new ColumnDef("기부유형", Ye165010BM.ATTR_CONBCD, ColumnDef.TYPE_STRING , 120, true, false, true){
        	{

        	}
        });
        /** column 기부코드 : conbNm */
        listColumnDefs.add(new ColumnDef("기부코드", Ye165010BM.ATTR_CONBCHGCD, ColumnDef.TYPE_STRING , 90, false, true, false){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 기부자료구분코드 : yrsMateClCd */
        listColumnDefs.add(new ColumnDef("기부자료구분코드", Ye165010BM.ATTR_YRSMATECLCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부내용 : dntcntn */
        listColumnDefs.add(new ColumnDef("기부내용", Ye165010BM.ATTR_DNTCNTN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부처_상호명 : coplNm */
        listColumnDefs.add(new ColumnDef("기부처_상호명", Ye165010BM.ATTR_COPLNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부처_사업자등록번호 : bsnoEncCntn */
        listColumnDefs.add(new ColumnDef("기부처_사업자등록번호", Ye165010BM.ATTR_BSNOENCCNTN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부자관계코드 : cnbtRltClCd */
        listColumnDefs.add(new ColumnDef("기부자관계코드", Ye165010BM.ATTR_CNBTRLTCLCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부자성명 : cnbtFnm */
        listColumnDefs.add(new ColumnDef("기부자성명", Ye165010BM.ATTR_CNBTFNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부자_주민등록번호 : resnoEncCntn */
        listColumnDefs.add(new ColumnDef("기부자_주민등록번호", Ye165010BM.ATTR_RESNOENCCNTN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부명세건수 : dntScnt */
        listColumnDefs.add(new ColumnDef("기부명세건수", Ye165010BM.ATTR_DNTSCNT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기부명세합계금액 : useSumAmt */
        listColumnDefs.add(new ColumnDef("기부명세합계금액", Ye165010BM.ATTR_USESUMAMT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 공제대상기부금액 : ddcTrgtConbAmt */
        listColumnDefs.add(new ColumnDef("공제대상기부금액", Ye165010BM.ATTR_DDCTRGTCONBAMT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기부장려금신청금 : conbSumAmt */
        listColumnDefs.add(new ColumnDef("기부장려금신청금", Ye165010BM.ATTR_CONBSUMAMT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye165010BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye165010BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye165010BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye165010BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye165010BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye165010BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

		return listColumnDefs;
	}
     
    
    
    private List<ColumnDef> getYetaP63003ToYe165010ColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        
        /** column 귀속연도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("기부연도", Ye165010BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        
        
        sysComBass0300Dto.setRpsttvCd("B023");
        sysComBass0300Dto.setMangeItem02("Y");
        /** column 기부유형 : conbCd */
        listColumnDefs.add(new ColumnListDef("유형",   Ye165010BM.ATTR_CONBCD,   ColumnDef.TYPE_STRING, 80, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{

            }
        });
        sysComBass0300Dto.setMangeItem02("");
        
        
        /** column 기부코드 : conbNm */
        listColumnDefs.add(new ColumnDef("기부코드", Ye165010BM.ATTR_CONBCHGCD, ColumnDef.TYPE_STRING , 90, false, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        
        sysComBass0300Dto.setRpsttvCd("Y014");
        /** column 기부자료구분코드 : yrsMateClCd */
        listColumnDefs.add(new ColumnListDef("자료구분",   Ye165010BM.ATTR_YRSMATECLCD,   ColumnDef.TYPE_STRING, 80, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{

            }
        });
        
        
        /** column 기부내용 : dntcntn */
        listColumnDefs.add(new ColumnDef("기부내용", Ye165010BM.ATTR_DNTCNTN, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 기부처_상호명 : coplNm */
        listColumnDefs.add(new ColumnDef("기부처명", Ye165010BM.ATTR_COPLNM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 기부처_사업자등록번호 : bsnoEncCntn */
        listColumnDefs.add(new ColumnDef("사업자번호", Ye165010BM.ATTR_BSNOENCCNTN, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		
        	}
        });
        
        
        sysComBass0300Dto.setRpsttvCd("Y018");
        /** column 기부자관계코드 : cnbtRltClCd */
        listColumnDefs.add(new ColumnListDef("기부자관계",   Ye165010BM.ATTR_CNBTRLTCLCD,   ColumnDef.TYPE_STRING, 100, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{

            }
        });
        
        /** column 기부자성명 : cnbtFnm */
        listColumnDefs.add(new ColumnDef("기부자성명", Ye165010BM.ATTR_CNBTFNM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 기부자_주민등록번호 : resnoEncCntn */
        listColumnDefs.add(new ColumnDef("주민등록번호", Ye165010BM.ATTR_RESNOENCCNTN, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{
        		setTextFdMask("999999-9999999");
        	}
        });
        
        
        /** column 기부명세건수 : dntScnt */
        listColumnDefs.add(new ColumnDef("건수", Ye165010BM.ATTR_DNTSCNT, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        /** column 기부명세합계금액 : useSumAmt */
        listColumnDefs.add(new ColumnDef("기부금액", Ye165010BM.ATTR_USESUMAMT, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        
        /** column 기부장려금신청금 : conbSumAmt */
        listColumnDefs.add(new ColumnDef("기부장려신청금", Ye165010BM.ATTR_CONBSUMAMT, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        
        /** column 기부금기타 : cnbtEtc */
        listColumnDefs.add(new ColumnDef("기부금기타", Ye165010BM.ATTR_CNBTETC, ColumnDef.TYPE_STRING, 90, false, true, false){
        	{
        		setSelectOnFocus(true);
        	}
        });
        
        /** column 공제대상기부금액 : ddcTrgtConbAmt */
        listColumnDefs.add(new ColumnDef("공제금액", Ye165010BM.ATTR_DDCTRGTCONBAMT, ColumnDef.TYPE_LONG , 90, false, true, false){
        	{
        		setReadOnly(true);
        	}
        });
        //--

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye165010BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye165010BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
   
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye165010BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금일련번호 : cnbtSeilNum */
        listColumnDefs.add(new ColumnDef("기부금일련번호", Ye165010BM.ATTR_CNBTSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기부유형 : conbCd */
        listColumnDefs.add(new ColumnDef("기부유형", Ye165010BM.ATTR_CONBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

        /** column 기부자료구분코드 : yrsMateClCd */
        listColumnDefs.add(new ColumnDef("기부자료구분코드", Ye165010BM.ATTR_YRSMATECLCD, ColumnDef.TYPE_STRING , 90, true, false, false){
        	{

        	}
        });
    
    
 
      
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye165010BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye165010BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye165010BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye165010BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye165010BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye165010BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

		return listColumnDefs;
	}
    
} 
 
 