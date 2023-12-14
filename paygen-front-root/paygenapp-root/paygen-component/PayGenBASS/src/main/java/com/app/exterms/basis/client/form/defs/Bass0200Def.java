/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.exterms.basis.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.basis.client.dto.Bass0200BM;
import com.app.exterms.basis.client.languages.BasisConstants;
import com.app.exterms.basis.shared.BasisDaoConstants;
import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;

public class Bass0200Def extends TableDef implements BasisDaoConstants {
    private int row = 0;
    
    private BasisConstants lblBasisConst = BasisConstants.INSTANCE;
    
    private PrgmComBass0300DTO sysComBass0300Dto ;
    
    public Bass0200Def(){
    	  
    	  sysComBass0300Dto = new PrgmComBass0300DTO();
    	 
    	  setTitle(lblBasisConst.title_Bass0200());
          setDaoClass(CLASS_BASS0200_LIST); 
          setCustomListMethod(CLASS_BASS0200_LIST);
          setAutoFillGrid(true);
          setShowFilterToolbar(false);
         // setCustomListMethod(MSFConfiguration.CUSTOM_SERVICE_SKIP_CALL);
          setCheckBoxOnGridRows(true);
           
          addColumnFilter("pubcHodyCtnt", "", SimpleColumnFilter.OPERATOR_LIKE); 
		    
          setColumnsDefinition(getAllColumnsList());
          
    }
       
    private List<ColumnDef> getAllColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
         
       
        /** set 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드",   Bass0200BM.ATTR_DPOBCD,   ColumnDef.TYPE_STRING, 90, false, false, false));
//        /** set 년도 : year */
//        listColumnDefs.add(new ColumnDef("년도",   Bass0200BM.ATTR_YEAR,   ColumnDef.TYPE_STRING, 90, false, false, false));
//        /** set 월 : mnth */
//        listColumnDefs.add(new ColumnDef("월",   Bass0200BM.ATTR_MNTH,   ColumnDef.TYPE_STRING, 90, false, false, false));
//        /** set 일 : day */
//        listColumnDefs.add(new ColumnDef("일",   Bass0200BM.ATTR_DAY,   ColumnDef.TYPE_STRING, 90, false, false, false));
        /** set 년월일 : pubcHodyDt */
//        listColumnDefs.add(new ColumnDef("휴일일자",   Bass0200BM.ATTR_,   ColumnDef.TYPE_DATE, 100, true, true, true));
        listColumnDefs.add(new ColumnDef("휴일일자",   Bass0200BM.ATTR_PUBCHODYDT,   ColumnDef.TYPE_DATE, 100, true, true, true));
        
        /** set 요일코드 : dotwCd */
        sysComBass0300Dto.setRpsttvCd("C001"); 
        listColumnDefs.add(new ColumnListDef("요일",   Bass0200BM.ATTR_DOTWCD,   ColumnDef.TYPE_STRING, 120, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM));
        /** set 요일명 : dotwNm */
        listColumnDefs.add(new ColumnDef("요일",   Bass0200BM.ATTR_DOTWNM,   ColumnDef.TYPE_STRING, 90, false, false, false));
        /** set 휴일내용 : pubcHodyCtnt */
        listColumnDefs.add(new ColumnDef("휴일내용",   Bass0200BM.ATTR_PUBCHODYCTNT,   ColumnDef.TYPE_STRING, 300, true, true, true));
        /** set 휴일유무 : pubcHodyYn */
        listColumnDefs.add(new ColumnDef("휴일",   Bass0200BM.ATTR_PUBCHODYYN,   ColumnDef.TYPE_BOOLEAN, 60, false, true, true));
        /** set 유급휴일여부 : paidPubcHodyYn */
        listColumnDefs.add(new ColumnDef("유급휴일",   Bass0200BM.ATTR_PAIDPUBCHODYYN,   ColumnDef.TYPE_BOOLEAN, 60, false, true, true));
        
        return listColumnDefs;
    }
}
