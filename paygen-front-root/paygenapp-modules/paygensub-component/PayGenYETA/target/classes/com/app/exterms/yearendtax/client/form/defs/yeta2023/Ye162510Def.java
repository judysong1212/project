package com.app.exterms.yearendtax.client.form.defs.yeta2023;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.exterms.yearendtax.client.dto.yeta2023.Ye162510BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.google.gwt.i18n.client.DateTimeFormat;

public class Ye162510Def extends TableDef implements YetaDaoConstants{
	

	private int row = 0;
	final PrgmComBass0300DTO sysComBass0300Dto;

	public Ye162510Def(String chkDef) {

		sysComBass0300Dto = new PrgmComBass0300DTO();

		if ("YETAT13019".equals(chkDef)) {
			// setTitle("월세액소득공제명세");
			setTitle("");
			setDaoClass("");
			setCustomListMethod(CLASS_YETAT13019TOYE162510_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true);
			setEditFieldGrid(true);
			setColumnsDefinition(getYe16251ColumnsList());
		} else if ("YetaP83005".equals(chkDef)) {

			setTitle("");
			setDaoClass("");
			setCustomListMethod(CLASS_YETAP83005_TO_YE162510_DATA_LIST);
			setAutoFillGrid(false);
			setShowFilterToolbar(false);
			setCheckBoxOnGridRows(true);
			setEditFieldGrid(true);
			setColumnsDefinition(getYetaP83005ToYe16251ColumnsList());

		} else {
			setTitle("");
			setDaoClass("");
			setCustomListMethod("");
			// setCustomListMethod(CLASS_YETA0100_LIST);
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
        listColumnDefs.add(new ColumnDef("월세일련번호", Ye162510BM.ATTR_MNTHRNTQNTYSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
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
        listColumnDefs.add(new ColumnDef("월세_연간월세금액", Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 월세_월세세액공제금액 : mnthRnttyTxDducSum */
        listColumnDefs.add(new ColumnDef("월세_월세세액공제금액", Ye162510BM.ATTR_MNTHRNTTYTXDDUCSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
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
	
	private List<ColumnDef> getYe16251ColumnsList() {
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye162510BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
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
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye162510BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 월세액소득공제일련번호 : mnthRntQntySeilNum */
        listColumnDefs.add(new ColumnDef("월세액소득공제일련번호", Ye162510BM.ATTR_MNTHRNTQNTYSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column G7_월세액_임대인성명 : mnthRnttyLehdrNm */
        listColumnDefs.add(new ColumnDef("G7_월세액_임대인성명", Ye162510BM.ATTR_MNTHRNTTYLEHDRNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column G8_월세액_주민_사업자등록번호 : mnthRnttyBurRgsum */
        listColumnDefs.add(new ColumnDef("G8_월세액_주민_사업자등록번호", Ye162510BM.ATTR_MNTHRNTTYBURRGSUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column G9_월세액_주택유형코드 : mnthRnttyHusFrmCd */
        listColumnDefs.add(new ColumnDef("G9_월세액_주택유형코드", Ye162510BM.ATTR_MNTHRNTTYHUSFRMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column G10_월세액_주택계약면적 : mnthRnttyHusCnttArea */
        listColumnDefs.add(new ColumnDef("G10_월세액_주택계약면적", Ye162510BM.ATTR_MNTHRNTTYHUSCNTTAREA, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column G11_월세액_임대차계약서상주소지 : mnthRnttyRntlAddr */
        listColumnDefs.add(new ColumnDef("G11_월세액_임대차계약서상주소지", Ye162510BM.ATTR_MNTHRNTTYRNTLADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column G12_월세액_임대차계약기간시작일자 : mnthRnttyRntlBgnnDt */
        listColumnDefs.add(new ColumnDef("G12_월세액_임대차계약기간시작일자", Ye162510BM.ATTR_MNTHRNTTYRNTLBGNNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column G13_월세액_임대차계약기간종료일자 : mnthRnttyRntlEndDt */
        listColumnDefs.add(new ColumnDef("G13_월세액_임대차계약기간종료일자", Ye162510BM.ATTR_MNTHRNTTYRNTLENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column G14_월세액_연간월세금액 : mnthRnttyYrlyMnthSum */
        listColumnDefs.add(new ColumnDef("G14_월세액_연간월세금액", Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column G15_월세액_세액공제금액 : mnthRnttyTxDducSum */
        listColumnDefs.add(new ColumnDef("G15_월세액_세액공제금액", Ye162510BM.ATTR_MNTHRNTTYTXDDUCSUM, ColumnDef.TYPE_LONG , 90, true, false, true){
        	{

        	}
        });
        /** column 전자파일이관여부 : ectnFlTrnrCtlYn */
        listColumnDefs.add(new ColumnDef("전자파일이관여부", Ye162510BM.ATTR_ECTNFLTRNRCTLYN, ColumnDef.TYPE_STRING , 90, true, false, true){
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
          
        return listColumnDefs;
	}



	private List<ColumnDef> getYetaP83005ToYe16251ColumnsList() {
		
		
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        /** column 국세청자료구분코드 : taxVvalKrnCd */
	    listColumnDefs.add(new ColumnDef("국세청자료구분", Ye162510BM.ATTR_TAXVVALKRNNM, ColumnDef.TYPE_STRING , 90, false, true, false){
	    	{
	    		setReadOnly(true);
	    	}
	    });

        
        
        /** column G7_월세액_임대인성명 : mnthRnttyLehdrNm */
        listColumnDefs.add(new ColumnDef("임대인성명", Ye162510BM.ATTR_MNTHRNTTYLEHDRNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column G8_월세액_주민_사업자등록번호 : mnthRnttyBurRgsum */
        listColumnDefs.add(new ColumnDef("주민(사업자)번호", Ye162510BM.ATTR_MNTHRNTTYBURRGSUM, ColumnDef.TYPE_STRING , 120, true, true, true){
        	{

        	}
        });
        
        
        sysComBass0300Dto.setRpsttvCd("Y007");
        /** column G9_월세액_주택유형코드 : mnthRnttyHusFrmCd */
        listColumnDefs.add(new ColumnListDef("주택유형",   Ye162510BM.ATTR_MNTHRNTTYHUSFRMCD,   ColumnDef.TYPE_STRING, 100, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{

            }
        });
        
        
        /** column G10_월세액_주택계약면적 : mnthRnttyHusCnttArea */
        listColumnDefs.add(new ColumnDef("계약면적(㎡)", Ye162510BM.ATTR_MNTHRNTTYHUSCNTTAREA, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{

        	}
        });
        /** column G11_월세액_임대차계약서상주소지 : mnthRnttyRntlAddr */
        listColumnDefs.add(new ColumnDef("계약서상주소지", Ye162510BM.ATTR_MNTHRNTTYRNTLADDR, ColumnDef.TYPE_STRING , 120, true, true, true){
        	{

        	}
        });
        /** column G12_월세액_임대차계약기간시작일자 : mnthRnttyRntlBgnnDt */
        listColumnDefs.add(new ColumnDef("계약시작일자", Ye162510BM.ATTR_MNTHRNTTYRNTLBGNNDT, ColumnDef.TYPE_DATE , 120, true, true, true){
        	{
        		setMaxLength(10);
        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
        		setDtFieldMask("9999.99.99");
        	}
        });
        /** column G13_월세액_임대차계약기간종료일자 : mnthRnttyRntlEndDt */
        listColumnDefs.add(new ColumnDef("계약종료일자", Ye162510BM.ATTR_MNTHRNTTYRNTLENDDT, ColumnDef.TYPE_DATE, 120, true, true, true){
        	{
        		setMaxLength(10);
        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
        		setDtFieldMask("9999.99.99");
        	}
        });
        /** column G14_월세액_연간월세금액 : mnthRnttyYrlyMnthSum */
        listColumnDefs.add(new ColumnDef("연간월세액(월)", Ye162510BM.ATTR_MNTHRNTTYYRLYMNTHSUM, ColumnDef.TYPE_LONG , 120, true, true, true){
        	{

        	}
        });
        /** column G15_월세액_세액공제금액 : mnthRnttyTxDducSum */
        listColumnDefs.add(new ColumnDef("공제금액", Ye162510BM.ATTR_MNTHRNTTYTXDDUCSUM, ColumnDef.TYPE_LONG , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 전자파일이관여부 : ectnFlTrnrCtlYn */
        listColumnDefs.add(new ColumnDef("이관여부", Ye162510BM.ATTR_ECTNFLTRNRCTLYN, ColumnDef.TYPE_BOOLEAN , 90, false, false, false){
        	{

        	}
        });
        
        
        
        //--
        
        /** column 국세청자료구분코드 : taxVvalKrnCd */
	    listColumnDefs.add(new ColumnDef("국세청자료구분코드", Ye162510BM.ATTR_TAXVVALKRNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    	{
	
	    	}
	    });
        
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye162510BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
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
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye162510BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 월세액소득공제일련번호 : mnthRntQntySeilNum */
        listColumnDefs.add(new ColumnDef("월세액소득공제일련번호", Ye162510BM.ATTR_MNTHRNTQNTYSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
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
          
        return listColumnDefs;
	}





}
