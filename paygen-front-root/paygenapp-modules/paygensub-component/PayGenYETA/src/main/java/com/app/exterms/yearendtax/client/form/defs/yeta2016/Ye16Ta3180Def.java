package com.app.exterms.yearendtax.client.form.defs.yeta2016;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta3180BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class Ye16Ta3180Def extends TableDef implements YetaDaoConstants{
	private int row = 0;
	final PrgmComBass0300DTO sysComBass0300Dto;
	public Ye16Ta3180Def(String chkDef) {
		
		sysComBass0300Dto = new PrgmComBass0300DTO();
		
		if("YETAP13003".equals(chkDef)) {
//		setTitle("기부금내역 등록");
		setTitle("");
        setDaoClass("");
        setCustomListMethod(CLASS_YETAP13003TOYETA3180_DATA_LIST);
  	  	setAutoFillGrid(false);
        setShowFilterToolbar(false);   
        setCheckBoxOnGridRows(true); 
	    setEditFieldGrid(true);
	    setColumnsDefinition(getColumnsListYetaP13003ToYeta03180()); 
		}else {
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
        

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye16Ta3180BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산귀속년도 : edacRvyy */
        listColumnDefs.add(new ColumnDef("연말정산귀속년도", Ye16Ta3180BM.ATTR_EDACRVYY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

        /** column 기부연도 : ctrbYrmn */
        listColumnDefs.add(new ColumnDef("연도", Ye16Ta3180BM.ATTR_CTRBYRMN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정산구분코드 : settGbcd */
        listColumnDefs.add(new ColumnDef("정산구분코드", Ye16Ta3180BM.ATTR_SETTGBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye16Ta3180BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부내역일련번호 : ctrbSeqn */
        listColumnDefs.add(new ColumnDef("기부내역일련번호", Ye16Ta3180BM.ATTR_CTRBSEQN, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기부유형구분코드 : ctrbDdcd */
        listColumnDefs.add(new ColumnDef("기부유형구분코드", Ye16Ta3180BM.ATTR_CTRBDDCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부유형코드 : ctrbTycd */
        listColumnDefs.add(new ColumnDef("기부유형코드", Ye16Ta3180BM.ATTR_CTRBTYCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부내용 : ctrbCont */
        listColumnDefs.add(new ColumnDef("기부내용", Ye16Ta3180BM.ATTR_CTRBCONT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부처명 : ctrbName */
        listColumnDefs.add(new ColumnDef("기부처명", Ye16Ta3180BM.ATTR_CTRBNAME, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부처사업자번호 : ctrbBsnu */
        listColumnDefs.add(new ColumnDef("기부처사업자번호", Ye16Ta3180BM.ATTR_CTRBBSNU, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금액 : ctrbAmnt */
        listColumnDefs.add(new ColumnDef("기부금액", Ye16Ta3180BM.ATTR_CTRBAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 기부자관계구분코드 : crtbCncd */
        listColumnDefs.add(new ColumnDef("기부자관계구분코드", Ye16Ta3180BM.ATTR_CRTBCNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부자내국인구분코드 : crnrFlag */
        listColumnDefs.add(new ColumnDef("기부자내국인구분코드", Ye16Ta3180BM.ATTR_CRNRFLAG, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 기부자성명 : cbtgName */
        listColumnDefs.add(new ColumnDef("기부자성명", Ye16Ta3180BM.ATTR_CBTGNAME, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 주민등록번호 : rsnoNumb */
        listColumnDefs.add(new ColumnDef("주민등록번호", Ye16Ta3180BM.ATTR_RSNONUMB, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 영수증유무 : receRati */
        listColumnDefs.add(new ColumnDef("영수증유무", Ye16Ta3180BM.ATTR_RECERATI, ColumnDef.TYPE_BOOLEAN , 90, true, false, true){
        	{

        	}
        });
        
        /** column 기부금건수 : ctrbNcnt */
        listColumnDefs.add(new ColumnDef("기부금건수", Ye16Ta3180BM.ATTR_CTRBNCNT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 공제대상기부금액 : ctrbTgam */
        listColumnDefs.add(new ColumnDef("공제대상기부금액", Ye16Ta3180BM.ATTR_CTRBTGAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부장려신청금액 : ctjaCham */
        listColumnDefs.add(new ColumnDef("기부장려신청금액", Ye16Ta3180BM.ATTR_CTJACHAM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 기부금유형콤보TEMP : ctrbCtnt */
        listColumnDefs.add(new ColumnDef("기부금유형콤보TEMP", Ye16Ta3180BM.ATTR_CTRBCTNT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye16Ta3180BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye16Ta3180BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye16Ta3180BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye16Ta3180BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye16Ta3180BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye16Ta3180BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

 
          return listColumnDefs;
	}
	
	
	private List<ColumnDef> getColumnsListYetaP13003ToYeta03180() {
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye16Ta3180BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye16Ta3180BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
       
        
        /** column 연말정산귀속년도 : edacRvyy */
        listColumnDefs.add(new ColumnDef("연말정산귀속년도", Ye16Ta3180BM.ATTR_EDACRVYY, ColumnDef.TYPE_STRING , 80, true, false, true){
        	{

        	}
        });
        /** column 기부연도 : ctrbYrmn */
        listColumnDefs.add(new ColumnDef("연도", Ye16Ta3180BM.ATTR_CTRBYRMN, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        

        /** column 기부유형구분코드 : ctrbDdcd */
        listColumnDefs.add(new ColumnDef("기부유형구분코드", Ye16Ta3180BM.ATTR_CTRBDDCD, ColumnDef.TYPE_STRING , 80, true, false, true){
        	{

        	}
        });
        sysComBass0300Dto.setRpsttvCd("B023");
        sysComBass0300Dto.setMangeItem01("Y");
        listColumnDefs.add(new ColumnListDef("유형",   Ye16Ta3180BM.ATTR_CTRBDDCD,   ColumnDef.TYPE_STRING, 80, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{

            }
        });
        sysComBass0300Dto.setMangeItem01("");
        /** column 기부유형코드 : ctrbTycd */
        listColumnDefs.add(new ColumnDef("코드", Ye16Ta3180BM.ATTR_CTRBTYCD, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{
        		//저장하고 나서 보여줌
        		setReadOnly(true);
        	}
        });
        /** column 기부내용 : ctrbCont */
        listColumnDefs.add(new ColumnDef("기부내용", Ye16Ta3180BM.ATTR_CTRBCONT, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        /** column 기부처명 : ctrbName */
        listColumnDefs.add(new ColumnDef("기부처명", Ye16Ta3180BM.ATTR_CTRBNAME, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        /** column 기부처사업자번호 : ctrbBsnu */
        listColumnDefs.add(new ColumnDef("사업자번호등", Ye16Ta3180BM.ATTR_CTRBBSNU, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        sysComBass0300Dto.setRpsttvCd("Y018");
        /** column 기부자관계구분코드 : crtbCncd */
        listColumnDefs.add(new ColumnListDef("기부자관계",   Ye16Ta3180BM.ATTR_CRTBCNCD,   ColumnDef.TYPE_STRING, 100, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{

            }
        });
        listColumnDefs.add(new ColumnDef("기부자관계", Ye16Ta3180BM.ATTR_CRTBCNCD, ColumnDef.TYPE_STRING , 100, true, false, true){
        	{

        	}
        }); 
        
        /** column 기부자성명 : cbtgName */
        listColumnDefs.add(new ColumnDef("기부자성명", Ye16Ta3180BM.ATTR_CBTGNAME, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        /** column 주민등록번호 : rsnoNumb */
        listColumnDefs.add(new ColumnDef("주민번호", Ye16Ta3180BM.ATTR_RSNONUMB, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        }); 
        
        
        /** column 기부금건수 : ctrbNcnt */
        listColumnDefs.add(new ColumnDef("건수", Ye16Ta3180BM.ATTR_CTRBNCNT, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        
        /** column 기부금액 : ctrbAmnt */
        listColumnDefs.add(new ColumnDef("기부금액", Ye16Ta3180BM.ATTR_CTRBAMNT, ColumnDef.TYPE_LONG , 100, true, true, true){
        	{

        	}
        });
        
      
        /** column 공제대상기부금액 : ctrbTgam */
        listColumnDefs.add(new ColumnDef("공제대상금액", Ye16Ta3180BM.ATTR_CTRBTGAM, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 기부장려신청금액 : ctjaCham */
        listColumnDefs.add(new ColumnDef("장려신청금액", Ye16Ta3180BM.ATTR_CTJACHAM, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        
        /** column 기부금유형콤보TEMP : ctrbCtnt */
        listColumnDefs.add(new ColumnDef("내용", Ye16Ta3180BM.ATTR_CTRBCTNT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 정산구분코드 : settGbcd */
        listColumnDefs.add(new ColumnDef("정산구분코드", Ye16Ta3180BM.ATTR_SETTGBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
       
        /** column 기부내역일련번호 : ctrbSeqn */
        listColumnDefs.add(new ColumnDef("기부내역일련번호", Ye16Ta3180BM.ATTR_CTRBSEQN, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });


        
      
        /** column 기부자내국인구분코드 : crnrFlag */
        listColumnDefs.add(new ColumnDef("기부자내국인구분코드", Ye16Ta3180BM.ATTR_CRNRFLAG, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
     
        /** column 영수증유무 : receRati */
        listColumnDefs.add(new ColumnDef("영수증유무", Ye16Ta3180BM.ATTR_RECERATI, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
     

        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye16Ta3180BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye16Ta3180BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye16Ta3180BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye16Ta3180BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye16Ta3180BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye16Ta3180BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

          return listColumnDefs;
	}


}
