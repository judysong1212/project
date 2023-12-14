package com.app.exterms.yearendtax.client.form.defs.yeta2016;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta3140BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.store.ListStore;

public class Ye16Ta3140Def extends TableDef implements YetaDaoConstants{
	private int row = 0;
	final PrgmComBass0300DTO sysComBass0300Dto;
	
	public ListStore<BaseModel> lsMediCfcd = new ListStore<BaseModel>();
	  
	public Ye16Ta3140Def(String chkDef) {
		
		sysComBass0300Dto = new PrgmComBass0300DTO();
		
		if("YETAP13002".equals(chkDef)) {
//		setTitle("의료비 내역");
		setTitle("");
        setDaoClass("");
        setCustomListMethod(CLASS_YETAP13002TOYETA3140_DATA_LIST);
  	  	setAutoFillGrid(false);
        setShowFilterToolbar(false);   
        setCheckBoxOnGridRows(true); 
	    setEditFieldGrid(true);
	    setColumnsDefinition(getColumnsListYetaP03002ToYeta03140()); 
		}else{
//			setTitle("연말정산대상자 및 내역");
			setTitle("");
	        setDaoClass("");
	        setCustomListMethod("");
//	        setCustomListMethod(CLASS_YETA0100_LIST);
	  	  	setAutoFillGrid(false);
	        setShowFilterToolbar(false);   
	        setCheckBoxOnGridRows(true); 
		    setEditFieldGrid(false);
		    setColumnsDefinition(getColumnsList()); 
		}
	}

	private List<ColumnDef> getColumnsList() {
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        

        /** column 의료비지급일련번호 : mediSeqn */
        listColumnDefs.add(new ColumnDef("의료비지급일련번호", Ye16Ta3140BM.ATTR_MEDISEQN, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산귀속년도 : edacRvyy */
        listColumnDefs.add(new ColumnDef("연말정산귀속년도", Ye16Ta3140BM.ATTR_EDACRVYY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정산구분코드 : settGbcd */
        listColumnDefs.add(new ColumnDef("정산구분코드", Ye16Ta3140BM.ATTR_SETTGBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye16Ta3140BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye16Ta3140BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 주민등록번호 : rsnoNumb */
        listColumnDefs.add(new ColumnDef("주민등록번호", Ye16Ta3140BM.ATTR_RSNONUMB, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 본인등해당여부 : psclHpyn */
        listColumnDefs.add(new ColumnDef("본인등해당여부", Ye16Ta3140BM.ATTR_PSCLHPYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 거래처번호 : vendNumb */
        listColumnDefs.add(new ColumnDef("거래처번호", Ye16Ta3140BM.ATTR_VENDNUMB, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 거래처명 : vendName */
        listColumnDefs.add(new ColumnDef("거래처명", Ye16Ta3140BM.ATTR_VENDNAME, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 의료증빙코드 : mediCfcd */
//        listColumnDefs.add(new ColumnDef("의료증빙코드", Ye16Ta3140BM.ATTR_MEDICFCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
        sysComBass0300Dto.setRpsttvCd("Y007");
        listColumnDefs.add(new ColumnListDef("의료증빙코드",   Ye16Ta3140BM.ATTR_MEDICFCD,   ColumnDef.TYPE_STRING, 180, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{

            }
        });
        /** column 지급건수 : cashUect */
        listColumnDefs.add(new ColumnDef("지급건수", Ye16Ta3140BM.ATTR_CASHUECT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 지급금액 : cashUeam */
        listColumnDefs.add(new ColumnDef("지급금액", Ye16Ta3140BM.ATTR_CASHUEAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 난임시술비해당여부 : ctifTrea */
        listColumnDefs.add(new ColumnDef("난임시술비해당여부", Ye16Ta3140BM.ATTR_CTIFTREA, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye16Ta3140BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye16Ta3140BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye16Ta3140BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye16Ta3140BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye16Ta3140BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye16Ta3140BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
 
          return listColumnDefs;
	}
	
	
	private List<ColumnDef> getColumnsListYetaP03002ToYeta03140() {
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye16Ta3140BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye16Ta3140BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        
        
        /** column 주민등록번호 : rsnoNumb */
        listColumnDefs.add(new ColumnDef("주민번호", Ye16Ta3140BM.ATTR_RSNONUMB, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 본인등해당여부 : psclHpyn */
        listColumnDefs.add(new ColumnDef("본인등", Ye16Ta3140BM.ATTR_PSCLHPYN, ColumnDef.TYPE_BOOLEAN , 80, true, true, true){
        	{

        	}
        });
        
        /** column 난임시술비해당여부 : ctifTrea */
        listColumnDefs.add(new ColumnDef("난임여부", Ye16Ta3140BM.ATTR_CTIFTREA, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        /** column 거래처번호 : vendNumb */
        listColumnDefs.add(new ColumnDef("사업자번호", Ye16Ta3140BM.ATTR_VENDNUMB, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        /** column 거래처명 : vendName */
        listColumnDefs.add(new ColumnDef("거래처명", Ye16Ta3140BM.ATTR_VENDNAME, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        
        
        /** column 의료증빙코드 : mediCfcd */
        listColumnDefs.add(new ColumnDef("의료증빙코드", Ye16Ta3140BM.ATTR_MEDICFCD, ColumnDef.TYPE_STRING , 100, true, false, true){
        	{

        	}
        });
        sysComBass0300Dto.setRpsttvCd("Y006");
        listColumnDefs.add(new ColumnListDef("의료증빙구분",   Ye16Ta3140BM.ATTR_MEDICFCD,   ColumnDef.TYPE_STRING, 150, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{

            }
        });
        /** column 지급건수 : cashUect */
        listColumnDefs.add(new ColumnDef("지급건수", Ye16Ta3140BM.ATTR_CASHUECT, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{

        	}
        });
        /** column 지급금액 : cashUeam */
        listColumnDefs.add(new ColumnDef("지급금액", Ye16Ta3140BM.ATTR_CASHUEAM, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{

        	}
        });
        

        /** column 의료비지급일련번호 : mediSeqn */
        listColumnDefs.add(new ColumnDef("의료비지급일련번호", Ye16Ta3140BM.ATTR_MEDISEQN, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산귀속년도 : edacRvyy */
        listColumnDefs.add(new ColumnDef("연말정산귀속년도", Ye16Ta3140BM.ATTR_EDACRVYY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정산구분코드 : settGbcd */
        listColumnDefs.add(new ColumnDef("정산구분코드", Ye16Ta3140BM.ATTR_SETTGBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });


        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye16Ta3140BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye16Ta3140BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye16Ta3140BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye16Ta3140BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye16Ta3140BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye16Ta3140BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

          return listColumnDefs;
	}

}
