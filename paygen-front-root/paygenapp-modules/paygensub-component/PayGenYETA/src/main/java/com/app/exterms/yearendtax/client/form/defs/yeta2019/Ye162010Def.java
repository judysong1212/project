package com.app.exterms.yearendtax.client.form.defs.yeta2019;



import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.exterms.yearendtax.client.dto.yeta2019.Ye162010BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;



/**
 * @Class Name : Ye162010Def.java
 * @since : 2017. 12. 12. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
public class Ye162010Def  extends TableDef implements YetaDaoConstants {

	private int row = 0;
	private PrgmComBass0300DTO sysComBass0300Dto;

	// private YetaConstants yetaLabel = YetaConstants.INSTANCE;

	public Ye162010Def(String chkPayrDef) {
		
		sysComBass0300Dto = new PrgmComBass0300DTO();

		if ("YetaP43007".equals(chkPayrDef)) {

			setDaoClass("");
			setCustomListMethod(CLASS_YETAP43007_TO_YE162010_DATA_LIST);
			setAutoFillGrid(true);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true);
			setColumnsDefinition(getYetaP33007ToYe162010ColumnsList());
			setEditableGrid(true);
			setEditFieldGrid(true);

		}else {
			setDaoClass("");
			setCustomListMethod(CLASS_YETAP43007_TO_YE162010_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true);
			setColumnsDefinition(getYetaP33007ToYe162010ColumnsList());
		}

	}
     
    private List<ColumnDef> getYetaP33007ToYe162010ColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        
	    /** column 국세청자료구분코드 : taxVvalKrnCd */
	    listColumnDefs.add(new ColumnDef("국세청자료구분", Ye162010BM.ATTR_TAXVVALKRNNM, ColumnDef.TYPE_STRING , 90, false, true, false){
	    	{
	    		setReadOnly(true);
	    	}
	    });
        
        
        /** column 연금저축소득공제구분코드 : pnsnSvngAccPnsnSvngCl */
        sysComBass0300Dto.setRpsttvCd("Y004"); 
        listColumnDefs.add(new ColumnListDef("연금저축구분",   Ye162010BM.ATTR_PNSNSVNGACCPNSNSVNGCL,   ColumnDef.TYPE_STRING, 120, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{

            }
        });
        
        sysComBass0300Dto.setRpsttvCd("Y005");
        /** column 연금저축금융기관코드 : pnsnSvngFnnOrgnCd */
        listColumnDefs.add(new ColumnListDef("금융기관", Ye162010BM.ATTR_PNSNSVNGFNNORGNCD, ColumnDef.TYPE_STRING , 120, true, true, true, new LookupPrgmComBass0300(sysComBass0300Dto), PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{

            }
        });
        
       
        /** column 굼융회사등명 : pnsnSvngAccFnnCmp */
        
        listColumnDefs.add(new ColumnDef("금융회사등명", Ye162010BM.ATTR_PNSNSVNGACCFNNCMP, ColumnDef.TYPE_STRING , 120, true, true, true){
        	{

        	}
        });
        
        /** column 계좌번호_증권번호 : pnsnSvngAccAccno */
        listColumnDefs.add(new ColumnDef("계좌(증권)번호", Ye162010BM.ATTR_PNSNSVNGACCACCNO, ColumnDef.TYPE_STRING , 120, true, true, true){
        	{

        	}
        });
        
        /** column 연금저축계좌납입금액 : pnsnSvngAccPymAmt */
        listColumnDefs.add(new ColumnDef("납입금액", Ye162010BM.ATTR_PNSNSVNGACCPYMAMT, ColumnDef.TYPE_LONG , 120, true, true, true){
        	{

        	}
        });
        
        
        
        //-- 

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye162010BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 귀속년도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("귀속년도", Ye162010BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("연말정산구분코드", Ye162010BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 국세청자료구분코드 : taxVvalKrnCd */
	    listColumnDefs.add(new ColumnDef("국세청자료구분코드", Ye162010BM.ATTR_TAXVVALKRNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
	    
    
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye162010BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 연금저축계좌세액공제금액 : ipnsnSvngAccddcAmt */
        listColumnDefs.add(new ColumnDef("세액공제금액", Ye162010BM.ATTR_IPNSNSVNGACCDDCAMT, ColumnDef.TYPE_LONG , 90, false, false, false){
        	{
        		setReadOnly(true);

        	}
        });
      
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye162010BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye162010BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye162010BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye162010BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye162010BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye162010BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
            
            return listColumnDefs;
        }
    
     
} 
  