package com.app.exterms.yearendtax.client.form.defs.yeta2017;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.Ye162510BM;
import com.app.exterms.yearendtax.client.dto.yeta2017.YetaT13001BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class YetaT13017Def extends TableDef implements YetaDaoConstants{
	private int row = 0;
	final PrgmComBass0300DTO sysComBass0300Dto;
	
	public YetaT13017Def(String chkDef) {
		
		sysComBass0300Dto = new PrgmComBass0300DTO();
		
		if("YetaT13017".equals(chkDef)) { //TODO 테이블 정의되면 다시 구현.
			setTitle("");
	        setDaoClass("");
	        setCustomListMethod(CLASS_YETAT13019TOYE162510_DATA_LIST);
	  	  	setAutoFillGrid(false);
	        setShowFilterToolbar(false);   
	        setCheckBoxOnGridRows(true); 
		    setEditFieldGrid(true);
		    setColumnsDefinition(getColumnsListYetaT13017()); 
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
        
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye162510BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산귀속년도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("연말정산귀속년도", Ye162510BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("정산구분코드", Ye162510BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 월세일련번호 : mnthRntQntySeilNum */
        listColumnDefs.add(new ColumnDef("월세일련번호", Ye162510BM.ATTR_MNTHRNTQNTYSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye162510BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye162510BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 월세_임대인성명 : mnthRnttyLehdrNm */
        listColumnDefs.add(new ColumnDef("월세_임대인성명", Ye162510BM.ATTR_MNTHRNTTYLEHDRNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 월세_주민번호 : mnthRnttyBurRgsum */
        listColumnDefs.add(new ColumnDef("월세_주민번호", Ye162510BM.ATTR_MNTHRNTTYBURRGSUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 월세_주택유형코드 : mnthRnttyHusFrmCd */
        listColumnDefs.add(new ColumnDef("월세_주택유형코드", Ye162510BM.ATTR_MNTHRNTTYHUSFRMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 월세주택계약면적 : mnthRnttyHusCnttArea */
        listColumnDefs.add(new ColumnDef("월세주택계약면적", Ye162510BM.ATTR_MNTHRNTTYHUSCNTTAREA, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 월세_계약서상주소 : mnthRnttyRntlAddr */
        listColumnDefs.add(new ColumnDef("월세_임대차계약서상주소", Ye162510BM.ATTR_MNTHRNTTYRNTLADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 월세_임대차계약시작일자 : mnthRnttyRntlBgnnDt */
        listColumnDefs.add(new ColumnDef("월세_임대차계약시작일자", Ye162510BM.ATTR_MNTHRNTTYRNTLBGNNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 월세_임대차계약종료일자 : mnthRnttyRntlEndDt */
        listColumnDefs.add(new ColumnDef("월세_임대차계약종료일자", Ye162510BM.ATTR_MNTHRNTTYRNTLENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 월세_연간월세금액 : mnthRnttyYrlyMnthSum */
        listColumnDefs.add(new ColumnDef("월세_연간월세금액", Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 월세_월세세액공제금액 : mnthRnttyTxDducSum */
        listColumnDefs.add(new ColumnDef("월세_월세세액공제금액", Ye162510BM.ATTR_MNTHRNTTYTXDDUCSUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye162510BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye162510BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye162510BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye162510BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye162510BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye162510BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 전자파일이관여부 : ectnFlTrnrCtlYn */
        listColumnDefs.add(new ColumnDef("전자파일이관여부", Ye162510BM.ATTR_ECTNFLTRNRCTLYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

          return listColumnDefs;
	}
	
	private List<ColumnDef> getColumnsListYetaT13017() { //TODO BM 다시 정의.
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", YetaT13001BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", YetaT13001BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", YetaT13001BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 번호 : rNum */
        listColumnDefs.add(new ColumnDef("번호", YetaT13001BM.ATTR_RNUM, ColumnDef.TYPE_STRING , 50, true, true, true){
        	{

        	}
        });
        
        /** column 코드 : mnthRnttyLehdrNm */
        listColumnDefs.add(new ColumnDef("코드", YetaT13001BM.ATTR_MNTHRNTTYLEHDRNM, ColumnDef.TYPE_STRING , 100, true, true, true){
        	{

        	}
        });
        /** column 항목명 : mnthRnttyBurRgsum */
        listColumnDefs.add(new ColumnDef("항목명", YetaT13001BM.ATTR_MNTHRNTTYBURRGSUM, ColumnDef.TYPE_STRING , 150, true, true, true){
        	{

        	}
        });
        /** column 기지급(급여) : mnthRnttyHusFrmCd */
        listColumnDefs.add(new ColumnDef("기지급(급여)", YetaT13001BM.ATTR_MNTHRNTTYHUSFRMCD, ColumnDef.TYPE_STRING , 150, true, true, true){
        	{

        	}
        });
        /** column 기지급(종전) : mnthRnttyHusFrmNm */
        listColumnDefs.add(new ColumnDef("기지급(종전)", YetaT13001BM.ATTR_MNTHRNTTYHUSFRMNM, ColumnDef.TYPE_STRING , 150, true, true, true){
        	{

        	}
        });
        /** column 과세전환금 : mnthRnttyHusCnttArea */
        listColumnDefs.add(new ColumnDef("과세전환금", YetaT13001BM.ATTR_MNTHRNTTYHUSCNTTAREA, ColumnDef.TYPE_STRING , 150, true, true, true){
        	{

        	}
        });
          
        return listColumnDefs;
	}

}
