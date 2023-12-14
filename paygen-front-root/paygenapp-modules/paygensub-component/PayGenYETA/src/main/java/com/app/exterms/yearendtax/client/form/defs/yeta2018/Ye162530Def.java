package com.app.exterms.yearendtax.client.form.defs.yeta2018;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.exterms.yearendtax.client.dto.yeta2018.Ye162530BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.google.gwt.i18n.client.DateTimeFormat;

public class Ye162530Def extends TableDef implements YetaDaoConstants{
	
	private int row = 0;
	final PrgmComBass0300DTO sysComBass0300Dto;
	
	public Ye162530Def(String chkDef) {
		
		sysComBass0300Dto = new PrgmComBass0300DTO();
		
		if("YetaP33004".equals(chkDef)) {
//		setTitle("임대차계약");
			setTitle("");
	        setDaoClass("");
//	        setCustomListMethod(CLASS_YETAP03004TOYETA3160_DATA_LIST);
	  	  	setAutoFillGrid(true);
	        setShowFilterToolbar(false);   
	        setCheckBoxOnGridRows(true); 
		    setEditFieldGrid(true);
		    setColumnsDefinition(getColumnsList()); 
		}else if("YetaT13004".equals(chkDef)){
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
		}else if("YetaP23004".equals(chkDef)){
			setTitle("");
	        setDaoClass("");
	        setCustomListMethod(CLASS_YETAP33004_TO_YE162530_DATA_LIST);
	  	  	setAutoFillGrid(false);
	        setShowFilterToolbar(false);   
	        setCheckBoxOnGridRows(true); 
		    setEditFieldGrid(true);
		    setEditableGrid(true);
		    setColumnsDefinition(getColumnsListYetaP33004ToYe162530()); 
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
	
	
	
//	private List<ColumnDef> getColumnsListYetaP03005ToYeta3160() {
//		 
//        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
//        
//        /** column 임대차_임대인성명_상호명 : rntlCttLehdrNm */
//        listColumnDefs.add(new ColumnDef("임대인성명_상호명", Ye162530BM.ATTR_RNTLCTTLEHDRNM, ColumnDef.TYPE_STRING , 70, true, true, true){
//        	{
//
//        	}
//        });
//        /** column 임대차_주민번호 : rntlCttBusoprRgstnnum */
//        listColumnDefs.add(new ColumnDef("주민번호", Ye162530BM.ATTR_RNTLCTTBUSOPRRGSTNNUM, ColumnDef.TYPE_STRING , 100, true, true, true){
//        	{
//
//        	}
//        });
//        
//        sysComBass0300Dto.setRpsttvCd("Y007");
//        /** column 월세_주택유형코드 : leasTyhu */
//        listColumnDefs.add(new ColumnListDef("주택유형",   Ye162530BM.ATTR_LEASTYHU,   ColumnDef.TYPE_STRING, 100, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
//        	{
//
//            }
//        });
//        
//        /** column 임대차_주택유형코드 : rntlCttHusFrmCd */
//        listColumnDefs.add(new ColumnDef("주택유형코드", Ye162530BM.ATTR_RNTLCTTHUSFRMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 임대차_주책계약면적 : rtnlCttHusCnttArea */
//        listColumnDefs.add(new ColumnDef("주택계약면적", Ye162530BM.ATTR_RTNLCTTHUSCNTTAREA, ColumnDef.TYPE_STRING , 70, true, true, true){
//        	{
//
//        	}
//        });
//        /** column 임대차_계약서상주소 : rtnlCttAddr */
//        listColumnDefs.add(new ColumnDef("임대차계약서상주소", Ye162530BM.ATTR_RTNLCTTADDR, ColumnDef.TYPE_STRING , 120, true, true, true){
//        	{
//
//        	}
//        });
//        /** column 임대차_계약시작일자 : rtnlCttPridBgnnDt */
//        listColumnDefs.add(new ColumnDef("계약시작일자", Ye162530BM.ATTR_RTNLCTTPRIDBGNNDT, ColumnDef.TYPE_DATE , 90, true, true, true){
//        	{
//        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
//        	}
//        });
//        /** column 임대차_계약종료일자 : rtnlCttPridEndDt */
//        listColumnDefs.add(new ColumnDef("계약종료일자", Ye162530BM.ATTR_RTNLCTTPRIDENDDT, ColumnDef.TYPE_DATE , 90, true, true, true){
//        	{
//        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
//        	}
//        });
//        /** column 임대차_전세보증금액 : rtnlCttChrtrGrnteSum */
//        listColumnDefs.add(new ColumnDef("전세보증금(원)", Ye162530BM.ATTR_RTNLCTTCHRTRGRNTESUM, ColumnDef.TYPE_LONG , 100, true, true, true){
//        	{
//
//        	}
//        });
//        
//        
//        /** column 연말정산귀속년도 : yrtxBlggYr */
//        listColumnDefs.add(new ColumnDef("연말정산귀속년도", Ye162530BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 정산구분코드 : clutSeptCd */
//        listColumnDefs.add(new ColumnDef("정산구분코드", Ye162530BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 임대차일련번호 : rntlCttSeilNum */
//        listColumnDefs.add(new ColumnDef("임대차일련번호", Ye162530BM.ATTR_RNTLCTTSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 사업장코드 : dpobCd */
//        listColumnDefs.add(new ColumnDef("사업장코드", Ye162530BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column SYSTEMKEY : systemkey */
//        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye162530BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력자 : kybdr */
//        listColumnDefs.add(new ColumnDef("입력자", Ye162530BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력일자 : inptDt */
//        listColumnDefs.add(new ColumnDef("입력일자", Ye162530BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력주소 : inptAddr */
//        listColumnDefs.add(new ColumnDef("입력주소", Ye162530BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정자 : ismt */
//        listColumnDefs.add(new ColumnDef("수정자", Ye162530BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정일자 : revnDt */
//        listColumnDefs.add(new ColumnDef("수정일자", Ye162530BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정주소 : revnAddr */
//        listColumnDefs.add(new ColumnDef("수정주소", Ye162530BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정주소 : ectnFlTrnrCtlYn */
//        listColumnDefs.add(new ColumnDef("전자파일이관여부", Ye162530BM.ATTR_ECTNFLTRNRCTLYN, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//          
//          return listColumnDefs;
//	}
//	
//	private List<ColumnDef> getColumnsListYetaT03004ToYe162530() {
//		 
//        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
//        
//        /** column 번호 : rnum */
//        listColumnDefs.add(new ColumnDef("번호", Ye162530BM.ATTR_RNUM, ColumnDef.TYPE_STRING , 50, true, true, true){
//        	{
//
//        	}
//        });
//        
//        /** column 임대차_임대인성명_상호명 : rntlCttLehdrNm */
//        listColumnDefs.add(new ColumnDef("임대인성명", Ye162530BM.ATTR_RNTLCTTLEHDRNM, ColumnDef.TYPE_STRING , 80, true, true, true){
//        	{
//
//        	}
//        });
//        /** column 임대차_주민번호 : rntlCttBusoprRgstnnum */
//        listColumnDefs.add(new ColumnDef("주민등록번호", Ye162530BM.ATTR_RNTLCTTBUSOPRRGSTNNUM, ColumnDef.TYPE_STRING , 100, true, true, true){
//        	{
//
//        	}
//        });
//        
//        sysComBass0300Dto.setRpsttvCd("Y007");
//        /** column 월세_주택유형코드 : leasTyhu */
//        listColumnDefs.add(new ColumnListDef("주택유형",   Ye162530BM.ATTR_LEASTYHU,   ColumnDef.TYPE_STRING, 80, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
//        	{
//
//            }
//        });
//        
//        /** column 임대차_주택유형코드 : rntlCttHusFrmCd */
//        listColumnDefs.add(new ColumnDef("주택유형코드", Ye162530BM.ATTR_RNTLCTTHUSFRMCD, ColumnDef.TYPE_STRING , 80, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 임대차_주책계약면적 : rtnlCttHusCnttArea */
//        listColumnDefs.add(new ColumnDef("주택계약면적", Ye162530BM.ATTR_RTNLCTTHUSCNTTAREA, ColumnDef.TYPE_STRING , 80, true, true, true){
//        	{
//
//        	}
//        });
//        /** column 임대차_계약서상주소 : rtnlCttAddr */
//        listColumnDefs.add(new ColumnDef("임대차계약서상주소지", Ye162530BM.ATTR_RTNLCTTADDR, ColumnDef.TYPE_STRING , 120, true, true, true){
//        	{
//
//        	}
//        });
//        /** column 임대차_계약시작일자 : rtnlCttPridBgnnDt */
//        listColumnDefs.add(new ColumnDef("계약시작일", Ye162530BM.ATTR_RTNLCTTPRIDBGNNDT, ColumnDef.TYPE_DATE , 80, true, true, true){
//        	{
//        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
//        	}
//        });
//        /** column 임대차_계약종료일자 : rtnlCttPridEndDt */
//        listColumnDefs.add(new ColumnDef("계약종료일", Ye162530BM.ATTR_RTNLCTTPRIDENDDT, ColumnDef.TYPE_DATE , 80, true, true, true){
//        	{
//        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
//        	}
//        });
//        /** column 임대차_전세보증금액 : rtnlCttChrtrGrnteSum */
//        listColumnDefs.add(new ColumnDef("전세보증금(원)", Ye162530BM.ATTR_RTNLCTTCHRTRGRNTESUM, ColumnDef.TYPE_LONG , 95, true, true, true){
//        	{
//
//        	}
//        });
//        
//        
//        /** column 연말정산귀속년도 : yrtxBlggYr */
//        listColumnDefs.add(new ColumnDef("연말정산귀속년도", Ye162530BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 정산구분코드 : clutSeptCd */
//        listColumnDefs.add(new ColumnDef("정산구분코드", Ye162530BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 임대차일련번호 : rntlCttSeilNum */
//        listColumnDefs.add(new ColumnDef("임대차일련번호", Ye162530BM.ATTR_RNTLCTTSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 사업장코드 : dpobCd */
//        listColumnDefs.add(new ColumnDef("사업장코드", Ye162530BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column SYSTEMKEY : systemkey */
//        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye162530BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력자 : kybdr */
//        listColumnDefs.add(new ColumnDef("입력자", Ye162530BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력일자 : inptDt */
//        listColumnDefs.add(new ColumnDef("입력일자", Ye162530BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력주소 : inptAddr */
//        listColumnDefs.add(new ColumnDef("입력주소", Ye162530BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정자 : ismt */
//        listColumnDefs.add(new ColumnDef("수정자", Ye162530BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정일자 : revnDt */
//        listColumnDefs.add(new ColumnDef("수정일자", Ye162530BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정주소 : revnAddr */
//        listColumnDefs.add(new ColumnDef("수정주소", Ye162530BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정주소 : ectnFlTrnrCtlYn */
//        listColumnDefs.add(new ColumnDef("전자파일이관여부", Ye162530BM.ATTR_ECTNFLTRNRCTLYN, ColumnDef.TYPE_STRING , 90, true, false, true){
//        	{
//
//        	}
//        });
//          
//          return listColumnDefs;
//	}
	
	
	
	private List<ColumnDef> getColumnsListYetaP33004ToYe162530() {
		 
       List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
       
       /** column 국세청자료구분코드 : taxVvalKrnCd */
	    listColumnDefs.add(new ColumnDef("국세청자료구분", Ye162530BM.ATTR_TAXVVALKRNNM, ColumnDef.TYPE_STRING , 90, false, true, false){
	    	{
	    		setReadOnly(true);
	    	}
	    });

       
       
       /** column G25_임대차계약_임대인성명_상호명 : rntlCttLehdrNm */
       listColumnDefs.add(new ColumnDef("임대인성명", Ye162530BM.ATTR_RNTLCTTLEHDRNM, ColumnDef.TYPE_STRING , 90, true, true, true){
       	{

       	}
       });
       
       /** column G26_임대차계약_주민_사업자등록번호 : rntlCttBusoprRgstnum */
       listColumnDefs.add(new ColumnDef("주민(사업자)번호", Ye162530BM.ATTR_RNTLCTTBUSOPRRGSTNUM, ColumnDef.TYPE_STRING , 100, true, true, true){
       	{

       	}
       });
       
       sysComBass0300Dto.setRpsttvCd("Y007");
       /** column G27_임대차계약_주택유형코드 : rntlCttHusFrmCd */
       listColumnDefs.add(new ColumnListDef("주택유형",   Ye162530BM.ATTR_RNTLCTTHUSFRMCD,   ColumnDef.TYPE_STRING, 100, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
       	{

           }
       });
       
       /** column G28_임대차계약_주택계약면적 : rntlCttHusCnttArea */
       listColumnDefs.add(new ColumnDef("계약면적", Ye162530BM.ATTR_RNTLCTTHUSCNTTAREA, ColumnDef.TYPE_LONG , 90, true, true, true){
       	{
       		setSelectOnFocus(true);
       	}
       });
       
       /** column G29_임대차계약_임대차계약서상주소지 : rntlCttAddr */
       listColumnDefs.add(new ColumnDef("계약서상주소", Ye162530BM.ATTR_RNTLCTTADDR, ColumnDef.TYPE_STRING , 120, true, true, true){
       	{

       	}
       });
       
       
       /** column G30_임대차계약_임대차계약기간시작일자 : rntlCttPridBgnnDt */
       listColumnDefs.add(new ColumnDef("계약시작일자", Ye162530BM.ATTR_RNTLCTTPRIDBGNNDT, ColumnDef.TYPE_DATE , 90, true, true, true){
       	{
       		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
			setDtFieldMask("9999.99.99");
       	}
       });
       
       /** column G31_임대차계약_임대차계약기간종료일자 : rntlCttPridEndDt */
       listColumnDefs.add(new ColumnDef("계약종료일자", Ye162530BM.ATTR_RNTLCTTPRIDENDDT, ColumnDef.TYPE_DATE , 90, true, true, true){
       	{
       		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
			setDtFieldMask("9999.99.99");
       	}
       });
       
       /** column G32_임대차계약_전세보증금액 : rntlCttChrtrGrnteSum */
       listColumnDefs.add(new ColumnDef("전세보증금(원)", Ye162530BM.ATTR_RNTLCTTCHRTRGRNTESUM, ColumnDef.TYPE_LONG , 100, true, true, true){
       	{
       		setSelectOnFocus(true);
       	}
       });
       
       /** column 전자파일이관여부 : ectnFlTrnrCtlYn */
       listColumnDefs.add(new ColumnDef("이관여부", Ye162530BM.ATTR_ECTNFLTRNRCTLYN, ColumnDef.TYPE_BOOLEAN , 90, false, false, false){
       	{

       	}
       });
       
       
       //-- 
       
       /** column 사업장코드 : dpobCd */
       listColumnDefs.add(new ColumnDef("사업장코드", Ye162530BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
       	{

       	}
       });
       
       /** column 연말정산귀속년도 : yrtxBlggYr */
       listColumnDefs.add(new ColumnDef("연말정산귀속년도", Ye162530BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
       	{

       	}
       });
       
       /** column 정산구분코드 : clutSeptCd */
       listColumnDefs.add(new ColumnDef("정산구분코드", Ye162530BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
       	{

       	}
       });
       
       /** column SYSTEMKEY : systemkey */
       listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye162530BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
       	{

       	}
       });
       
       /** column 임대차계약 일련번호 : rntlCttSeilNum */
       listColumnDefs.add(new ColumnDef("임대차계약 일련번호", Ye162530BM.ATTR_RNTLCTTSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
       	{

       	}
       });
       

       /** column 국세청자료구분코드 : taxVvalKrnCd */
   listColumnDefs.add(new ColumnDef("국세청자료구분코드", Ye162530BM.ATTR_TAXVVALKRNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
   	{

   	}
   });
   
   /** column 국세청자료구분코드 : taxVvalKrnCd */
   listColumnDefs.add(new ColumnDef("국세청자료구분코드", Ye162530BM.ATTR_TAXVVALKRNNM, ColumnDef.TYPE_STRING , 90, true, false, true){
   	{

   	}
   });
       
       

       
       /** column 입력자 : kybdr */
       listColumnDefs.add(new ColumnDef("입력자", Ye162530BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
       	{

       	}
       });
       
       /** column 입력일자 : inptDt */
       listColumnDefs.add(new ColumnDef("입력일자", Ye162530BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
       	{

       	}
       });
       
       /** column 입력주소 : inptAddr */
       listColumnDefs.add(new ColumnDef("입력주소", Ye162530BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
       	{

       	}
       });
       
       /** column 수정자 : ismt */
       listColumnDefs.add(new ColumnDef("수정자", Ye162530BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
       	{

       	}
       });
       
       /** column 수정일자 : revnDt */
       listColumnDefs.add(new ColumnDef("수정일자", Ye162530BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
       	{

       	}
       });
       
       /** column 수정주소 : revnAddr */
       listColumnDefs.add(new ColumnDef("수정주소", Ye162530BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
       	{

       	}
       });
       
       
         
         return listColumnDefs;
	}

	private List<ColumnDef> getColumnsList() {
	 
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Ye162530BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 연말정산귀속년도 : yrtxBlggYr */
        listColumnDefs.add(new ColumnDef("연말정산귀속년도", Ye162530BM.ATTR_YRTXBLGGYR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 정산구분코드 : clutSeptCd */
        listColumnDefs.add(new ColumnDef("정산구분코드", Ye162530BM.ATTR_CLUTSEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Ye162530BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 임대차계약 일련번호 : rntlCttSeilNum */
        listColumnDefs.add(new ColumnDef("임대차계약 일련번호", Ye162530BM.ATTR_RNTLCTTSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column G25_임대차계약_임대인성명_상호명 : rntlCttLehdrNm */
        listColumnDefs.add(new ColumnDef("G25_임대차계약_임대인성명_상호명", Ye162530BM.ATTR_RNTLCTTLEHDRNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column G26_임대차계약_주민_사업자등록번호 : rntlCttBusoprRgstnum */
        listColumnDefs.add(new ColumnDef("G26_임대차계약_주민_사업자등록번호", Ye162530BM.ATTR_RNTLCTTBUSOPRRGSTNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column G27_임대차계약_주택유형코드 : rntlCttHusFrmCd */
        listColumnDefs.add(new ColumnDef("G27_임대차계약_주택유형코드", Ye162530BM.ATTR_RNTLCTTHUSFRMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column G28_임대차계약_주택계약면적 : rntlCttHusCnttArea */
        listColumnDefs.add(new ColumnDef("G28_임대차계약_주택계약면적", Ye162530BM.ATTR_RNTLCTTHUSCNTTAREA, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column G29_임대차계약_임대차계약서상주소지 : rntlCttAddr */
        listColumnDefs.add(new ColumnDef("G29_임대차계약_임대차계약서상주소지", Ye162530BM.ATTR_RNTLCTTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column G30_임대차계약_임대차계약기간시작일자 : rntlCttPridBgnnDt */
        listColumnDefs.add(new ColumnDef("G30_임대차계약_임대차계약기간시작일자", Ye162530BM.ATTR_RNTLCTTPRIDBGNNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column G31_임대차계약_임대차계약기간종료일자 : rntlCttPridEndDt */
        listColumnDefs.add(new ColumnDef("G31_임대차계약_임대차계약기간종료일자", Ye162530BM.ATTR_RNTLCTTPRIDENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column G32_임대차계약_전세보증금액 : rntlCttChrtrGrnteSum */
        listColumnDefs.add(new ColumnDef("G32_임대차계약_전세보증금액", Ye162530BM.ATTR_RNTLCTTCHRTRGRNTESUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 전자파일이관여부 : ectnFlTrnrCtlYn */
        listColumnDefs.add(new ColumnDef("전자파일이관여부", Ye162530BM.ATTR_ECTNFLTRNRCTLYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Ye162530BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Ye162530BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Ye162530BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Ye162530BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Ye162530BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Ye162530BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
          
          return listColumnDefs;
	}

}
