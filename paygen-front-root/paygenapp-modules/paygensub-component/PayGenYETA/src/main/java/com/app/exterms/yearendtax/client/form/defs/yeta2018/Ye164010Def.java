package com.app.exterms.yearendtax.client.form.defs.yeta2018;



import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.exterms.yearendtax.client.dto.yeta2018.Ye164010BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;


/**
 * @Class Name : Ye164010Def.java
 * @since : 2017. 12. 12. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
public class Ye164010Def  extends TableDef implements YetaDaoConstants {
	private PrgmComBass0300DTO sysComBass0300Dto;
    private int row = 0;
//    private YetaConstants yetaLabel = YetaConstants.INSTANCE;

	public Ye164010Def(String chkPayrDef) {

		sysComBass0300Dto = new PrgmComBass0300DTO();

		if ("YetaP33002".equals(chkPayrDef)) {
			setDaoClass("");
			 setCustomListMethod(CLASS_YETAP33002_TO_YE164010_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true);
			setEditableGrid(true);
			setEditFieldGrid(true);
			setColumnsDefinition(getYetaP33002ToYe164010ColumnsList());
		} else {
			setDaoClass("");
			// setCustomListMethod(CLASS_PAYR0304TOPAYR4200_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true);
			setColumnsDefinition(getYe164010ColumnsList());
		}

	}
     
    private List<ColumnDef> getYe164010ColumnsList(){
    	
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 

        
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye164010BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속연도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속연도", Ye164010BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye164010BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye164010BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 의료비공제대상자주민등록번호 : resnoEncCntn */
        listColumnDefs.add(new ColumnDef("의료비공제대상자주민등록번호", Ye164010BM.ATTR_RESNOENCCNTN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 본인등해당여부 : yn */
        listColumnDefs.add(new ColumnDef("본인등해당여부", Ye164010BM.ATTR_YN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 지급처사업자등록번호 : bsnoEncCntn */
        listColumnDefs.add(new ColumnDef("지급처사업자등록번호", Ye164010BM.ATTR_BSNOENCCNTN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 의료비_상호명 : plymNm */
        listColumnDefs.add(new ColumnDef("의료비_상호명", Ye164010BM.ATTR_PLYMNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 의료비_의료증빙코드 : mdxpsPrfClCd */
        listColumnDefs.add(new ColumnDef("의료비_의료증빙코드", Ye164010BM.ATTR_MDXPSPRFCLCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 의료비_건수 : scnt */
        listColumnDefs.add(new ColumnDef("의료비_건수", Ye164010BM.ATTR_SCNT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 의료비_금액 : useAmt */
        listColumnDefs.add(new ColumnDef("의료비_금액", Ye164010BM.ATTR_USEAMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 의료비_난임시술비해당여부 : yn2 */
        listColumnDefs.add(new ColumnDef("의료비_난임시술비해당여부", Ye164010BM.ATTR_YN2, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye164010BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye164010BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye164010BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye164010BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye164010BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye164010BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
            
            return listColumnDefs;
        }
    
     
    
    private List<ColumnDef> getYetaP33002ToYe164010ColumnsList(){
    	
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        
        
        /** column 의료비공제대상자주민등록번호 : resnoEncCntn */
        listColumnDefs.add(new ColumnDef("주민등록번호", Ye164010BM.ATTR_RESNOENCCNTN, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{
        		setTextFdMask("999999-9999999");
        	}
        });
        
        /** column 본인등해당여부 : yn */
        listColumnDefs.add(new ColumnDef("본인등", Ye164010BM.ATTR_YN, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{

        	}
        });
        
        /** column 의료비_난임시술비해당여부 : yn2 */
        listColumnDefs.add(new ColumnDef("난임여부", Ye164010BM.ATTR_YN2, ColumnDef.TYPE_STRING , 70, true, true, true){
        	{

        	}
        });
        
        /** column 의료비국세자료구분코드 : mdxpsVvalKrnCd */
        listColumnDefs.add(new ColumnDef("국세자료구분", Ye164010BM.ATTR_MDXPSVVALKRNNM, ColumnDef.TYPE_STRING , 90, false, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        /** column 지급처사업자등록번호 : bsnoEncCntn */
        listColumnDefs.add(new ColumnDef("사업자등록번호", Ye164010BM.ATTR_BSNOENCCNTN, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{
        		setTextFdMask("999-99-99999");
        	}
        });
        
        /** column 의료비_상호명 : plymNm */
        listColumnDefs.add(new ColumnDef("상호명", Ye164010BM.ATTR_PLYMNM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        
        sysComBass0300Dto.setRpsttvCd("Y006");
        /** column 의료비_의료증빙코드 : mdxpsPrfClCd */
        listColumnDefs.add(new ColumnListDef("의료증빙구분",   Ye164010BM.ATTR_MDXPSPRFCLCD,   ColumnDef.TYPE_STRING, 150, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{

            }
        });
        
        
        /** column 의료비_건수 : scnt */
        listColumnDefs.add(new ColumnDef("지급건수", Ye164010BM.ATTR_SCNT, ColumnDef.TYPE_LONG, 70, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        /** column 의료비_금액 : useAmt */
        listColumnDefs.add(new ColumnDef("지급금액", Ye164010BM.ATTR_USEAMT, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{
        		setSelectOnFocus(true);
        	}
        });
        
        
        
        //--
        
        /** column 의료비국세자료구분코드 : mdxpsVvalKrnCd */
        listColumnDefs.add(new ColumnDef("의료비국세자료구분코드", Ye164010BM.ATTR_MDXPSVVALKRNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 의료비지급일련번호 : mdxpsSeilNum */
        listColumnDefs.add(new ColumnDef("의료비지급일련번호", Ye164010BM.ATTR_MDXPSSEILNUM, ColumnDef.TYPE_LONG, 90, true, false, true){
        	{

        	}
        });
        
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye164010BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속연도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속연도", Ye164010BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye164010BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye164010BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

 

        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye164010BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye164010BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye164010BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye164010BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye164010BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye164010BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

		return listColumnDefs;
	}

}
 
 
