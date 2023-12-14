package com.app.exterms.yearendtax.client.form.defs.yeta2023;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.dto.PrgmComPsnl0115BM;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.exterms.yearendtax.client.dto.yeta2023.Ye161030BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;


/**
 * @Class Name : Ye161030Def.java
 * @since : 2017. 12. 17. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
public class Ye161030Def  extends TableDef implements YetaDaoConstants {


	private int row = 0;

    private PrgmComBass0300DTO sysComBass0300Dto;


	public Ye161030Def(String chkPayrDef) {
		     
		if ("YETA2300".equals(chkPayrDef)) {
			
			sysComBass0300Dto = new PrgmComBass0300DTO();

			setDaoClass("");
			setCustomListMethod(CLASS_YETA2300_TO_YE161030_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true);
			setEditableGrid(true);
			setEditFieldGrid(true);
			setColumnsDefinition(getYeta2300ToYe161030ColumnsList());
		}else if ("Yeta3300".equals(chkPayrDef)) {
			
			sysComBass0300Dto = new PrgmComBass0300DTO();

			setDaoClass("");
			setCustomListMethod(CLASS_YETA3300_TO_YE161030_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true);
			setEditableGrid(true);
			setEditFieldGrid(true);
			setColumnsDefinition(getYeta2300ToYe161030ColumnsList());

		}else if ("Yeta4300".equals(chkPayrDef)) {
			
			sysComBass0300Dto = new PrgmComBass0300DTO();

			setDaoClass("");
			setCustomListMethod(CLASS_YETA4300_TO_YE161030_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true);
			setEditableGrid(true);
			setEditFieldGrid(true);
			setColumnsDefinition(getYeta2300ToYe161030ColumnsList());
			
			
		}else if ("Yeta5300".equals(chkPayrDef)) {
			
			sysComBass0300Dto = new PrgmComBass0300DTO();

			setDaoClass("");
			setCustomListMethod(CLASS_YETA5300_TO_YE161030_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true);
			setEditableGrid(true);
			setEditFieldGrid(true);
			setColumnsDefinition(getYeta2300ToYe161030ColumnsList());
			
		}else if ("Yeta6300".equals(chkPayrDef)) {
			
			sysComBass0300Dto = new PrgmComBass0300DTO();

			setDaoClass("");
			setCustomListMethod(CLASS_YETA6300_TO_YE161030_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true);
			setEditableGrid(true);
			setEditFieldGrid(true);
			setColumnsDefinition(getYeta2300ToYe161030ColumnsList());



		}else if ("Yeta7300".equals(chkPayrDef)) {
			
			sysComBass0300Dto = new PrgmComBass0300DTO();

			setDaoClass("");
			setCustomListMethod(CLASS_YETA7300_TO_YE161030_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true);
			setEditableGrid(true);
			setEditFieldGrid(true);
			setColumnsDefinition(getYeta2300ToYe161030ColumnsList());



		}else if ("Yeta8300".equals(chkPayrDef)) {
			
			sysComBass0300Dto = new PrgmComBass0300DTO();

			setDaoClass("");
			setCustomListMethod(CLASS_YETA8300_TO_YE161030_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true);
			setEditableGrid(true);
			setEditFieldGrid(true);
			setColumnsDefinition(getYeta2300ToYe161030ColumnsList());



		}else {
			
			sysComBass0300Dto = new PrgmComBass0300DTO();
			
			setDaoClass("");
			setCustomListMethod(CLASS_YETA8300_TO_YE161030_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true);
			setEditableGrid(false);
			setEditFieldGrid(false);
			setColumnsDefinition(getYeta2300ToYe161030ColumnsList());
			
		}

    }
     
    private List<ColumnDef> getYeta2300ToYe161030ColumnsList(){
    	
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        sysComBass0300Dto.setRpsttvCd("A019");
        listColumnDefs.add(new ColumnListDef("관계",   PrgmComPsnl0115BM.ATTR_FAMYRELADIVCD,   ColumnDef.TYPE_STRING, 80, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{
        		setReadOnly(true);
            }
        });
        
        sysComBass0300Dto.setRpsttvCd("Y012");
        listColumnDefs.add(new ColumnListDef("부양관계",   Ye161030BM.ATTR_SUPTFMLYRLTCLCD,   ColumnDef.TYPE_STRING, 80, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{
        		
            }
        });
        
        /** column 성명 : txprNm */
        listColumnDefs.add(new ColumnDef("성명", Ye161030BM.ATTR_TXPRNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        /** column 내외국인구분 : nnfClCd */
        listColumnDefs.add(new ColumnDef("내외국인", Ye161030BM.ATTR_NNFCLCD, ColumnDef.TYPE_STRING , 70, false, true, false){
        	{

        	}
        });
      
        
        /** column 주민등록번호 : txprDscmNoCntn */
        listColumnDefs.add(new ColumnDef("주민등록번호", Ye161030BM.ATTR_TXPRDSCMNOCNTN, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
      
        /** column 기본공제여부 : bscDdcClCd */
        listColumnDefs.add(new ColumnDef("기본", Ye161030BM.ATTR_BSCDDCCLCD, ColumnDef.TYPE_BOOLEAN , 70, false, true, false){
        	{

        	}
        });
        /** column 부녀자여부 : wmnDdcClCd */
        listColumnDefs.add(new ColumnDef("부녀자", Ye161030BM.ATTR_WMNDDCCLCD, ColumnDef.TYPE_BOOLEAN , 70, false, true, false){
        	{

        	}
        });
        /** column 한부모여부 : snprntFmlyDdcClCd */
        listColumnDefs.add(new ColumnDef("한부모", Ye161030BM.ATTR_SNPRNTFMLYDDCCLCD, ColumnDef.TYPE_BOOLEAN , 70, false, true, false){
        	{

        	}
        });
        /** column 경로우대여부 : sccDdcClCd */
        listColumnDefs.add(new ColumnDef("경로우대", Ye161030BM.ATTR_SCCDDCCLCD, ColumnDef.TYPE_BOOLEAN , 70, false, true, false){
        	{

        	}
        });
        
        /** column 장애인공제여부 : psclDdyn */
        sysComBass0300Dto.setRpsttvCd("Y008");
        listColumnDefs.add(new ColumnListDef("장애인",   Ye161030BM.ATTR_DSBRDDCCLCD,   ColumnDef.TYPE_STRING, 70, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{

            }
        });
        
        /** column 장애인여부 : dsbrDdcClCd */
        listColumnDefs.add(new ColumnDef("장애인", Ye161030BM.ATTR_DSBRDDCCLCD, ColumnDef.TYPE_BOOLEAN , 90, false, false, false){
        	{

        	}
        });
        
        sysComBass0300Dto.setRpsttvCd("Y021");
        listColumnDefs.add(new ColumnListDef("출산입양",   Ye161030BM.ATTR_CHBTATPRDDCCLCD,   ColumnDef.TYPE_STRING, 70, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{
        		
            }
        });
        
        listColumnDefs.add(new ColumnDef("7세미만취학여부", Ye161030BM.ATTR_SCHOOLYN, ColumnDef.TYPE_BOOLEAN, 100, false, true, false){
        	{

        	}
        });
        
        /** column 교육비공제구분 : eduDdcDvcd */
        listColumnDefs.add(new ColumnDef("교육비공제", Ye161030BM.ATTR_EDUDDCDVCD, ColumnDef.TYPE_BOOLEAN , 90, false, true, false){
        	{

        	}
        });
        
        /** column 인사가족관계코드 : famyRelaDivCd */
        listColumnDefs.add(new ColumnDef("인사가족관계코드", Ye161030BM.ATTR_FAMYRELADIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 귀속연도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속연도", Ye161030BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye161030BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye161030BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
       
        /** column 부양관계코드 : suptFmlyRltClCd */
        listColumnDefs.add(new ColumnDef("부양관계코드", Ye161030BM.ATTR_SUPTFMLYRLTCLCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
       
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye161030BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye161030BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye161030BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye161030BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye161030BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye161030BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
		return listColumnDefs;
	}

}
 