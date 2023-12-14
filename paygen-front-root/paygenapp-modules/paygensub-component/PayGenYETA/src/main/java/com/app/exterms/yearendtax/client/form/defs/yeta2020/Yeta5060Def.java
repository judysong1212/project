/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.exterms.yearendtax.client.form.defs.yeta2020;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.exterms.yearendtax.client.dto.yeta2020.Yeta5060BM;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class Yeta5060Def extends TableDef implements YetaDaoConstants {
	
    private int row = 0;
    private PrgmComBass0300DTO sysComBass0300Dto;
//    private BasisConstants lblBasisConst = BasisConstants.INSTANCE;
    
    public Yeta5060Def(){
    	
    	  setTitle("");
          setDaoClass(CLASS_YETA5060_LIST); 
          setCustomListMethod(CLASS_YETA5060_LIST);
          setColumnsDefinition(getAllColumnsList());
          setAutoFillGrid(false);
          setShowFilterToolbar(false);
    }
    
    public Yeta5060Def(String chkDef){
    	
    	sysComBass0300Dto = new PrgmComBass0300DTO();
    	
    	if ("Yeta5060_01".equals(chkDef)) {
	        setTitle("");
	        setDaoClass(CLASS_YETA5060_MLIST); 
	        setCustomListMethod(CLASS_YETA5060_MLIST);
	        
	        setAutoFillGrid(false);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(false);
	        setEditFieldGrid(false);
//	        setCellModel(true);
	        setColumnsDefinition(getMasterColumnsList());  
	      
    	}
    	else if ("Yeta5060_02".equals(chkDef)) {
	        setTitle("");
	        setDaoClass(CLASS_YETA5060_SLIST); 
	        setCustomListMethod(CLASS_YETA5060_SLIST);
	        
	        setAutoFillGrid(false);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(false);
	        setEditFieldGrid(false);
//	        setCellModel(true);
	        
	        setColumnsDefinition(getServantColumnsList());
	        
		}
    	else if ("Yeta506001_Mt".equals(chkDef)) {
    		setTitle("");
    		setDaoClass(CLASS_YETA506001_MLIST); 
    		setCustomListMethod(CLASS_YETA506001_MLIST);
    		
    		setAutoFillGrid(true);
    		setShowFilterToolbar(false);
    		setCheckBoxOnGridRows(false);
    		setEditFieldGrid(false);
//	        setCellModel(true);
    		
    		setColumnsDefinition(getMasterColumnsList_2());
    		
    	}
    	else if ("Yeta506001_St".equals(chkDef)) {
    		setTitle("");
    		setDaoClass(CLASS_YETA506001_SLIST); 
    		setCustomListMethod(CLASS_YETA506001_SLIST);
    		
    		setAutoFillGrid(true);
    		setShowFilterToolbar(false);
    		setCheckBoxOnGridRows(true);
    		setEditFieldGrid(true);
//	        setCellModel(true);
    		
    		setColumnsDefinition(getServantColumnsList_2());
    		
    	}
	}

    private List<ColumnDef> getAllColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
         
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Yeta5060BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장코드 : utDpobCd */
        listColumnDefs.add(new ColumnDef("단위사업장코드", Yeta5060BM.ATTR_UTDPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장명 : utDpobNm */
        listColumnDefs.add(new ColumnDef("단위사업장명", Yeta5060BM.ATTR_UTDPOBNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 상위단위사업장코드 : hhrkUntDpobCd */
        listColumnDefs.add(new ColumnDef("상위단위사업장코드", Yeta5060BM.ATTR_HHRKUNTDPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 대표자주민번호 : degtrResnRegnNum */
        listColumnDefs.add(new ColumnDef("대표자주민번호", Yeta5060BM.ATTR_DEGTRRESNREGNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 대표자명 : degtrNm */
        listColumnDefs.add(new ColumnDef("대표자명", Yeta5060BM.ATTR_DEGTRNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 내외국인구분코드 : frgnrDivCd */
        listColumnDefs.add(new ColumnDef("내외국인구분코드", Yeta5060BM.ATTR_FRGNRDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업자등록번호 : busoprRgstnNum */
        listColumnDefs.add(new ColumnDef("사업자등록번호", Yeta5060BM.ATTR_BUSOPRRGSTNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 법인등록번호 : corpRgstnNum */
        listColumnDefs.add(new ColumnDef("법인등록번호", Yeta5060BM.ATTR_CORPRGSTNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 법인구분코드 : corpDivCd */
        listColumnDefs.add(new ColumnDef("법인구분코드", Yeta5060BM.ATTR_CORPDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장우편번호 : untDpobZpcd */
        listColumnDefs.add(new ColumnDef("단위사업장우편번호", Yeta5060BM.ATTR_UNTDPOBZPCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장기본주소 : untDpobFndtnAddr */
        listColumnDefs.add(new ColumnDef("단위사업장기본주소", Yeta5060BM.ATTR_UNTDPOBFNDTNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장상세주소 : untDpobDtlPatrAddr */
        listColumnDefs.add(new ColumnDef("단위사업장상세주소", Yeta5060BM.ATTR_UNTDPOBDTLPATRADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장전화번호 : untDpobPhnNum */
        listColumnDefs.add(new ColumnDef("단위사업장전화번호", Yeta5060BM.ATTR_UNTDPOBPHNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장팩스번호 : untDpobFaxNum */
        listColumnDefs.add(new ColumnDef("단위사업장팩스번호", Yeta5060BM.ATTR_UNTDPOBFAXNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장전자우편주소 : untDpobEctnMailAddr */
        listColumnDefs.add(new ColumnDef("단위사업장전자우편주소", Yeta5060BM.ATTR_UNTDPOBECTNMAILADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장업종_업태 : untDpobBncdsNm */
        listColumnDefs.add(new ColumnDef("단위사업장업종_업태", Yeta5060BM.ATTR_UNTDPOBBNCDSNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장업종_종목명 : untDpobItemNm */
        listColumnDefs.add(new ColumnDef("단위사업장업종_종목명", Yeta5060BM.ATTR_UNTDPOBITEMNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장업종_주생산품 : untDpobMnPrdt */
        listColumnDefs.add(new ColumnDef("단위사업장업종_주생산품", Yeta5060BM.ATTR_UNTDPOBMNPRDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장설립일자 : untDpobEsbmDt */
        listColumnDefs.add(new ColumnDef("단위사업장설립일자", Yeta5060BM.ATTR_UNTDPOBESBMDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장개업일자 : untDpobIngnDt */
        listColumnDefs.add(new ColumnDef("단위사업장개업일자", Yeta5060BM.ATTR_UNTDPOBINGNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장폐업일자 : untDpobEobDt */
        listColumnDefs.add(new ColumnDef("단위사업장폐업일자", Yeta5060BM.ATTR_UNTDPOBEOBDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장직인문구명 : untDpobSealWrdNm */
        listColumnDefs.add(new ColumnDef("단위사업장직인문구명", Yeta5060BM.ATTR_UNTDPOBSEALWRDNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장직인경로 : untDpobSealRfta */
        listColumnDefs.add(new ColumnDef("단위사업장직인경로", Yeta5060BM.ATTR_UNTDPOBSEALRFTA, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장직인파일명 : untDpobSealFlnm */
        listColumnDefs.add(new ColumnDef("단위사업장직인파일명", Yeta5060BM.ATTR_UNTDPOBSEALFLNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장기본사용여부 : untDpobFndtnUseYn */
        listColumnDefs.add(new ColumnDef("단위사업장기본사용여부", Yeta5060BM.ATTR_UNTDPOBFNDTNUSEYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Yeta5060BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Yeta5060BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Yeta5060BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Yeta5060BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Yeta5060BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", Yeta5060BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 주종사업장코드 : mtstBusinDivCd */
        listColumnDefs.add(new ColumnDef("주종사업장코드", Yeta5060BM.ATTR_MTSTBUSINDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장승인번호 : upDpobCmpNo */
        listColumnDefs.add(new ColumnDef("단위사업장승인번호", Yeta5060BM.ATTR_UPDPOBCMPNO, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column C171_사업자단위과세자여부 : upDpobUtynC171 */
        listColumnDefs.add(new ColumnDef("C171_사업자단위과세자여부", Yeta5060BM.ATTR_UPDPOBUTYNC171, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column C172_종사업장일련번호 : mtstDpobSeilNumC172 */
        listColumnDefs.add(new ColumnDef("C172_종사업장일련번호", Yeta5060BM.ATTR_MTSTDPOBSEILNUMC172, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 본지점구분코드 : mnbhDivCd */
        listColumnDefs.add(new ColumnDef("본지점구분코드", Yeta5060BM.ATTR_MNBHDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 원천세신고유형구분코드 : whdgTxCtypDivCd */
        listColumnDefs.add(new ColumnDef("원천세신고유형구분코드", Yeta5060BM.ATTR_WHDGTXCTYPDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        return listColumnDefs;
    }
    
    /****************************************************************/
    /************************** 주 사업장 그리드 **************************/
    private List<ColumnDef> getMasterColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        /** column 주종사업장구분코드 : mtstBusinDivCd */
        listColumnDefs.add(new ColumnDef("주종사업장구분코드", Yeta5060BM.ATTR_MTSTBUSINDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 사업장명 : dpobNm */
        listColumnDefs.add(new ColumnDef("사업장명", Yeta5060BM.ATTR_UTDPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		
        	}
        });
        
        /** column 사업장명 : dpobNm */
        listColumnDefs.add(new ColumnDef("사업장명", Yeta5060BM.ATTR_UTDPOBNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 대표자명 : degtrNm */
        listColumnDefs.add(new ColumnDef("대표자명", Yeta5060BM.ATTR_DEGTRNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 사업자등록번호 : busoprRgstnNum */
        listColumnDefs.add(new ColumnDef("사업자번호", Yeta5060BM.ATTR_BUSOPRRGSTNNUM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        sysComBass0300Dto.setRpsttvCd("C003");
        listColumnDefs.add(new ColumnListDef("주종구분",   Yeta5060BM.ATTR_MTSTBUSINDIVCD,   ColumnDef.TYPE_STRING, 100, true, false, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{

            }
        });
        /** column 사업장기본사용여부 : untDpobFndtnUseYn */
        listColumnDefs.add(new ColumnDef("주종구분", Yeta5060BM.ATTR_MTSTBUSINDIVNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 사업장기본사용여부 : untDpobFndtnUseYn */
        listColumnDefs.add(new ColumnDef("사용여부", Yeta5060BM.ATTR_UNTDPOBFNDTNUSEYN, ColumnDef.TYPE_BOOLEAN , 90, true, true, true){
        	{

        	}
        });

        // ===============
        
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Yeta5060BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        /** column 대표자주민번호 : degtrResnRegnNum */
        listColumnDefs.add(new ColumnDef("대표자주민번호", Yeta5060BM.ATTR_DEGTRRESNREGNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 상위단위사업장코드 : hhrkUntDpobCd */
        listColumnDefs.add(new ColumnDef("상위단위사업장코드", Yeta5060BM.ATTR_HHRKUNTDPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });


        /** column 법인등록번호 : corpRgstnNum */
        listColumnDefs.add(new ColumnDef("법인등록번호", Yeta5060BM.ATTR_CORPRGSTNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 법인구분코드 : corpDivCd */
        listColumnDefs.add(new ColumnDef("법인구분코드", Yeta5060BM.ATTR_CORPDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업장우편번호 : dpobZpcd */
        listColumnDefs.add(new ColumnDef("사업장우편번호", Yeta5060BM.ATTR_UNTDPOBZPCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업장기본주소 : dpobFndtnAddr */
        listColumnDefs.add(new ColumnDef("사업장기본주소", Yeta5060BM.ATTR_UNTDPOBFNDTNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업장상세주소 : dpobDtlPatrAddr */
        listColumnDefs.add(new ColumnDef("사업장상세주소", Yeta5060BM.ATTR_UNTDPOBDTLPATRADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업장전화번호 : dpobPhnNum */
        listColumnDefs.add(new ColumnDef("사업장전화번호", Yeta5060BM.ATTR_UNTDPOBPHNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업장팩스번호 : dpobFaxNum */
        listColumnDefs.add(new ColumnDef("사업장팩스번호", Yeta5060BM.ATTR_UNTDPOBFAXNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업장직인문구명 : dpobSealWrdNm */
        listColumnDefs.add(new ColumnDef("사업장직인문구명", Yeta5060BM.ATTR_UNTDPOBSEALWRDNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업장직인경로 : untDpobSealRfta */
        listColumnDefs.add(new ColumnDef("사업장직인경로", Yeta5060BM.ATTR_UNTDPOBSEALRFTA, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업장직인파일명 : untDpobSealFlnm */
        listColumnDefs.add(new ColumnDef("사업장직인파일명", Yeta5060BM.ATTR_UNTDPOBSEALFLNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Yeta5060BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Yeta5060BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Yeta5060BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Yeta5060BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Yeta5060BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정자주소", Yeta5060BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

        /** column 전자우편주소 : untDpobEctnMailAddr */
        listColumnDefs.add(new ColumnDef("전자우편주소", Yeta5060BM.ATTR_UNTDPOBECTNMAILADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		
        	}
        });
        /** column 업태 : untDpobBncdsNm */
        listColumnDefs.add(new ColumnDef("업태", Yeta5060BM.ATTR_UNTDPOBBNCDSNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		
        	}
        });
        /** column 종목명 : untDpobItemNm */
        listColumnDefs.add(new ColumnDef("종목명", Yeta5060BM.ATTR_UNTDPOBITEMNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		
        	}
        });
        /** column 주생산품 : untDpobMnPrdt */
        listColumnDefs.add(new ColumnDef("주생산품", Yeta5060BM.ATTR_UNTDPOBMNPRDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		
        	}
        });
        /** column 단위사업장승인번호 : upDpobCmpNo */
        listColumnDefs.add(new ColumnDef("단위사업장승인번호", Yeta5060BM.ATTR_UPDPOBCMPNO, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column C171_사업자단위과세자여부 : upDpobUtynC171 */
        listColumnDefs.add(new ColumnDef("C171_사업자단위과세자여부", Yeta5060BM.ATTR_UPDPOBUTYNC171, ColumnDef.TYPE_BOOLEAN , 90, true, false, true){
        	{

        	}
        });
        /** column C172_종사업장일련번호 : mtstDpobSeilNumC172 */
        listColumnDefs.add(new ColumnDef("C172_종사업장일련번호", Yeta5060BM.ATTR_MTSTDPOBSEILNUMC172, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 본지점구분코드 : mnbhDivCd */
        listColumnDefs.add(new ColumnDef("본지점구분코드", Yeta5060BM.ATTR_MNBHDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 원천세신고유형구분코드 : whdgTxCtypDivCd */
        listColumnDefs.add(new ColumnDef("원천세신고유형구분코드", Yeta5060BM.ATTR_WHDGTXCTYPDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        return listColumnDefs;
    }
    private List<ColumnDef> getMasterColumnsList_2(){
    	row = 0;
    	List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
    	
    	/** column 주종사업장구분코드 : mtstBusinDivCd */
    	listColumnDefs.add(new ColumnDef("주종사업장구분코드", Yeta5060BM.ATTR_MTSTBUSINDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			
    		}
    	});
    	
    	/** column 사업장코드 : dpobCd */
    	listColumnDefs.add(new ColumnDef("사업장코드", Yeta5060BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			
    		}
    	});
    	
    	 /** column 사업장명 : UtDpobCd */
    	listColumnDefs.add(new ColumnDef("단위사업장코드", Yeta5060BM.ATTR_UTDPOBCD, ColumnDef.TYPE_STRING , 90, true, true, true){
    		{
    			
    		}
    	});
    	
    	/** column 사업장명 : UtDpobCd */
    	listColumnDefs.add(new ColumnDef("단위사업장명", Yeta5060BM.ATTR_UTDPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			
    		}
    	});
    	
    	/** column 사업장명 : UtDpobNm */
    	listColumnDefs.add(new ColumnDef("사업장명", Yeta5060BM.ATTR_UTDPOBNM, ColumnDef.TYPE_STRING , 90, true, true, true){
    		{
    			
    		}
    	});
    	/** column 대표자명 : degtrNm */
    	listColumnDefs.add(new ColumnDef("대표자명", Yeta5060BM.ATTR_DEGTRNM, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			
    		}
    	});
    	/** column 사업자등록번호 : busoprRgstnNum */
    	listColumnDefs.add(new ColumnDef("사업자번호", Yeta5060BM.ATTR_BUSOPRRGSTNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			
    		}
    	});
    	sysComBass0300Dto.setRpsttvCd("C003");
    	listColumnDefs.add(new ColumnListDef("주종구분",   Yeta5060BM.ATTR_MTSTBUSINDIVCD,   ColumnDef.TYPE_STRING, 100, true, false, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
    		{
    			
    		}
    	});
    	/** column 사업장기본사용여부 : untDpobFndtnUseYn */
    	listColumnDefs.add(new ColumnDef("주종구분", Yeta5060BM.ATTR_MTSTBUSINDIVNM, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			
    		}
    	});
    	/** column 사업장기본사용여부 : untDpobFndtnUseYn */
    	listColumnDefs.add(new ColumnDef("사용여부", Yeta5060BM.ATTR_UNTDPOBFNDTNUSEYN, ColumnDef.TYPE_BOOLEAN , 90, true, false, true){
    		{
    			
    		}
    	});
    	
    	// ===============
    	
    	
    	/** column 대표자주민번호 : degtrResnRegnNum */
    	listColumnDefs.add(new ColumnDef("대표자주민번호", Yeta5060BM.ATTR_DEGTRRESNREGNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			
    		}
    	});
    	/** column 상위단위사업장코드 : hhrkUntDpobCd */
    	listColumnDefs.add(new ColumnDef("상위단위사업장코드", Yeta5060BM.ATTR_HHRKUNTDPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			
    		}
    	});
    	
    	
    	/** column 법인등록번호 : corpRgstnNum */
    	listColumnDefs.add(new ColumnDef("법인등록번호", Yeta5060BM.ATTR_CORPRGSTNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			
    		}
    	});
    	/** column 법인구분코드 : corpDivCd */
    	listColumnDefs.add(new ColumnDef("법인구분코드", Yeta5060BM.ATTR_CORPDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			
    		}
    	});
    	/** column 사업장우편번호 : dpobZpcd */
    	listColumnDefs.add(new ColumnDef("사업장우편번호", Yeta5060BM.ATTR_UNTDPOBZPCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			
    		}
    	});
    	/** column 사업장기본주소 : dpobFndtnAddr */
    	listColumnDefs.add(new ColumnDef("사업장기본주소", Yeta5060BM.ATTR_UNTDPOBFNDTNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			
    		}
    	});
    	/** column 사업장상세주소 : dpobDtlPatrAddr */
    	listColumnDefs.add(new ColumnDef("사업장상세주소", Yeta5060BM.ATTR_UNTDPOBDTLPATRADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			
    		}
    	});
    	/** column 사업장전화번호 : dpobPhnNum */
    	listColumnDefs.add(new ColumnDef("사업장전화번호", Yeta5060BM.ATTR_UNTDPOBPHNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			
    		}
    	});
    	/** column 사업장팩스번호 : dpobFaxNum */
    	listColumnDefs.add(new ColumnDef("사업장팩스번호", Yeta5060BM.ATTR_UNTDPOBFAXNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			
    		}
    	});
    	/** column 사업장직인문구명 : dpobSealWrdNm */
    	listColumnDefs.add(new ColumnDef("사업장직인문구명", Yeta5060BM.ATTR_UNTDPOBSEALWRDNM, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			
    		}
    	});
    	/** column 사업장직인경로 : untDpobSealRfta */
    	listColumnDefs.add(new ColumnDef("사업장직인경로", Yeta5060BM.ATTR_UNTDPOBSEALRFTA, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			
    		}
    	});
    	/** column 사업장직인파일명 : dpobSealFlNm */
    	listColumnDefs.add(new ColumnDef("사업장직인파일명", Yeta5060BM.ATTR_UNTDPOBSEALFLNM, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			
    		}
    	});
    	/** column 입력자 : kybdr */
    	listColumnDefs.add(new ColumnDef("입력자", Yeta5060BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			
    		}
    	});
    	/** column 입력일자 : inptDt */
    	listColumnDefs.add(new ColumnDef("입력일자", Yeta5060BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			
    		}
    	});
    	/** column 입력주소 : inptAddr */
    	listColumnDefs.add(new ColumnDef("입력주소", Yeta5060BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			
    		}
    	});
    	/** column 수정자 : ismt */
    	listColumnDefs.add(new ColumnDef("수정자", Yeta5060BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			
    		}
    	});
    	/** column 수정일자 : revnDt */
    	listColumnDefs.add(new ColumnDef("수정일자", Yeta5060BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			
    		}
    	});
    	/** column 수정자주소 : revnAddr */
    	listColumnDefs.add(new ColumnDef("수정자주소", Yeta5060BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			
    		}
    	});
    	
    	/** column 전자우편주소 : untDpobEctnMailAddr */
    	listColumnDefs.add(new ColumnDef("전자우편주소", Yeta5060BM.ATTR_UNTDPOBECTNMAILADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			
    		}
    	});
    	/** column 업태 : untDpobBncdsNm */
    	listColumnDefs.add(new ColumnDef("업태", Yeta5060BM.ATTR_UNTDPOBBNCDSNM, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			
    		}
    	});
    	/** column 종목명 : untDpobItemNm */
    	listColumnDefs.add(new ColumnDef("종목명", Yeta5060BM.ATTR_UNTDPOBITEMNM, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			
    		}
    	});
    	/** column 주생산품 : untDpobMnPrdt */
    	listColumnDefs.add(new ColumnDef("주생산품", Yeta5060BM.ATTR_UNTDPOBMNPRDT, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			
    		}
    	});
    	/** column 단위사업장승인번호 : upDpobCmpNo */
    	listColumnDefs.add(new ColumnDef("승인번호", Yeta5060BM.ATTR_UPDPOBCMPNO, ColumnDef.TYPE_STRING , 90, true, true, true){
    		{
    			
    		}
    	});
    	/** column C171_사업자단위과세자여부 : upDpobUtynC171 */
    	listColumnDefs.add(new ColumnDef("C171_사업자단위과세자여부", Yeta5060BM.ATTR_UPDPOBUTYNC171, ColumnDef.TYPE_BOOLEAN , 90, true, false, true){
    		{
    			
    		}
    	});
    	/** column C172_종사업장일련번호 : mtstDpobSeilNumC172 */
    	listColumnDefs.add(new ColumnDef("C172_종사업장일련번호", Yeta5060BM.ATTR_MTSTDPOBSEILNUMC172, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			
    		}
    	});
    	/** column 본지점구분코드 : mnbhDivCd */
    	listColumnDefs.add(new ColumnDef("본지점구분코드", Yeta5060BM.ATTR_MNBHDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			
    		}
    	});
    	/** column 원천세신고유형구분코드 : whdgTxCtypDivCd */
    	listColumnDefs.add(new ColumnDef("원천세신고유형구분코드", Yeta5060BM.ATTR_WHDGTXCTYPDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			
    		}
    	});
    	return listColumnDefs;
    }
    /**************************************************/
    /********************종 사업장 그리드*******************/
    private List<ColumnDef> getServantColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
         
        /** column 주종사업장구분코드 : mtstBusinDivCd */
        listColumnDefs.add(new ColumnDef("주종사업장구분코드", Yeta5060BM.ATTR_MTSTBUSINDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        sysComBass0300Dto.setRpsttvCd("C003");
        listColumnDefs.add(new ColumnListDef("주종구분",   Yeta5060BM.ATTR_MTSTBUSINDIVCD,   ColumnDef.TYPE_STRING, 100, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{

            }
        });
         
        /** column 사업장명 : utDpobNm */
        listColumnDefs.add(new ColumnDef("사업장명", Yeta5060BM.ATTR_UTDPOBNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 대표자명 : degtrNm */
        listColumnDefs.add(new ColumnDef("대표자명", Yeta5060BM.ATTR_DEGTRNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 사업자등록번호 : busoprRgstnNum */
        listColumnDefs.add(new ColumnDef("사업자등록번호", Yeta5060BM.ATTR_BUSOPRRGSTNNUM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 사업장기본사용여부 : untDpobFndtnUseYn */
        listColumnDefs.add(new ColumnDef("사용여부", Yeta5060BM.ATTR_UNTDPOBFNDTNUSEYN, ColumnDef.TYPE_BOOLEAN , 90, true, true, true){
        	{

        	}
        });
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Yeta5060BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 대표자주민번호 : degtrResnRegnNum */
        listColumnDefs.add(new ColumnDef("대표자주민번호", Yeta5060BM.ATTR_DEGTRRESNREGNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 상위단위사업장코드 : hhrkUntDpobCd */
        listColumnDefs.add(new ColumnDef("상위단위사업장코드", Yeta5060BM.ATTR_HHRKUNTDPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });


        /** column 법인등록번호 : corpRgstnNum */
        listColumnDefs.add(new ColumnDef("법인등록번호", Yeta5060BM.ATTR_CORPRGSTNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 법인구분코드 : corpDivCd */
        listColumnDefs.add(new ColumnDef("법인구분코드", Yeta5060BM.ATTR_CORPDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업장우편번호 : dpobZpcd */
        listColumnDefs.add(new ColumnDef("사업장우편번호", Yeta5060BM.ATTR_UNTDPOBZPCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업장기본주소 : dpobFndtnAddr */
        listColumnDefs.add(new ColumnDef("사업장기본주소", Yeta5060BM.ATTR_UNTDPOBFNDTNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업장상세주소 : dpobDtlPatrAddr */
        listColumnDefs.add(new ColumnDef("사업장상세주소", Yeta5060BM.ATTR_UNTDPOBDTLPATRADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업장전화번호 : dpobPhnNum */
        listColumnDefs.add(new ColumnDef("사업장전화번호", Yeta5060BM.ATTR_UNTDPOBPHNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업장팩스번호 : dpobFaxNum */
        listColumnDefs.add(new ColumnDef("사업장팩스번호", Yeta5060BM.ATTR_UNTDPOBFAXNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업장직인문구명 : dpobSealWrdNm */
        listColumnDefs.add(new ColumnDef("사업장직인문구명", Yeta5060BM.ATTR_UNTDPOBSEALWRDNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업장직인경로 : dpobSealRftaNm */
        listColumnDefs.add(new ColumnDef("사업장직인경로", Yeta5060BM.ATTR_UNTDPOBSEALFLNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업장직인파일명 : dpobSealFlNm */
        listColumnDefs.add(new ColumnDef("사업장직인파일명", Yeta5060BM.ATTR_UNTDPOBSEALFLNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });

        /** column 전자우편주소 : untDpobEctnMailAddr */
        listColumnDefs.add(new ColumnDef("전자우편주소", Yeta5060BM.ATTR_UNTDPOBECTNMAILADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		
        	}
        });
        /** column 업태 : untDpobBncdsNm */
        listColumnDefs.add(new ColumnDef("업태", Yeta5060BM.ATTR_UNTDPOBBNCDSNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		
        	}
        });
        /** column 종목명 : untDpobItemNm */
        listColumnDefs.add(new ColumnDef("종목명", Yeta5060BM.ATTR_UNTDPOBITEMNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		
        	}
        });
        /** column 주생산품 : untDpobMnPrdt */
        listColumnDefs.add(new ColumnDef("주생산품", Yeta5060BM.ATTR_UNTDPOBMNPRDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		
        	}
        });
        
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", Yeta5060BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", Yeta5060BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", Yeta5060BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", Yeta5060BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", Yeta5060BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정자주소", Yeta5060BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장승인번호 : upDpobCmpNo */
        listColumnDefs.add(new ColumnDef("단위사업장승인번호", Yeta5060BM.ATTR_UPDPOBCMPNO, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column C171_사업자단위과세자여부 : upDpobUtynC171 */
        listColumnDefs.add(new ColumnDef("C171_사업자단위과세자여부", Yeta5060BM.ATTR_UPDPOBUTYNC171, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column C172_종사업장일련번호 : mtstDpobSeilNumC172 */
        listColumnDefs.add(new ColumnDef("C172_종사업장일련번호", Yeta5060BM.ATTR_MTSTDPOBSEILNUMC172, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 본지점구분코드 : mnbhDivCd */
        listColumnDefs.add(new ColumnDef("본지점구분코드", Yeta5060BM.ATTR_MNBHDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 원천세신고유형구분코드 : whdgTxCtypDivCd */
        listColumnDefs.add(new ColumnDef("원천세신고유형구분코드", Yeta5060BM.ATTR_WHDGTXCTYPDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        return listColumnDefs;
        
    }
    private List<ColumnDef> getServantColumnsList_2(){
         
    	row = 0;
    	List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
    	
    	/** column 주종사업장구분코드 : mtstBusinDivCd */
    	listColumnDefs.add(new ColumnDef("주종사업장구분코드", Yeta5060BM.ATTR_MTSTBUSINDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			setReadOnly(true);
    		}
    	});
    	
    	sysComBass0300Dto.setRpsttvCd("C003");
    	listColumnDefs.add(new ColumnListDef("주종구분",   Yeta5060BM.ATTR_MTSTBUSINDIVCD,   ColumnDef.TYPE_STRING, 100, true, false, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
    		{
    			setReadOnly(true);
    		}
    	});
    	
    	/** column 사업장코드 : dpobCd */
    	listColumnDefs.add(new ColumnDef("사업장코드", Yeta5060BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			setReadOnly(true);
    		}
    	});
    	
    	 /** column 사업장명 : UtDpobCd */
    	listColumnDefs.add(new ColumnDef("사업장코드", Yeta5060BM.ATTR_UTDPOBCD, ColumnDef.TYPE_STRING , 90, true, true, true){
    		{
    			setReadOnly(true);
    		}
    	});
    	
    	/** column 사업장명 : utDpobNm */
    	listColumnDefs.add(new ColumnDef("사업장명", Yeta5060BM.ATTR_UTDPOBNM, ColumnDef.TYPE_STRING , 90, true, true, true){
    		{
    			setReadOnly(true);
    		}
    	});
    	/** column 대표자명 : degtrNm */
    	listColumnDefs.add(new ColumnDef("대표자명", Yeta5060BM.ATTR_DEGTRNM, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			setReadOnly(true);
    		}
    	});
    	/** column 사업자등록번호 : busoprRgstnNum */
    	listColumnDefs.add(new ColumnDef("사업자번호", Yeta5060BM.ATTR_BUSOPRRGSTNNUM, ColumnDef.TYPE_STRING , 90, true, true, true){
    		{
    			setReadOnly(true);
    		}
    	});
    	/** column 사업장기본사용여부 : untDpobFndtnUseYn */
    	listColumnDefs.add(new ColumnDef("사용여부", Yeta5060BM.ATTR_UNTDPOBFNDTNUSEYN, ColumnDef.TYPE_BOOLEAN , 90, true, false, true){
    		{
    			setReadOnly(true);
    		}
    	});
    	/** column 대표자주민번호 : degtrResnRegnNum */
    	listColumnDefs.add(new ColumnDef("대표자주민번호", Yeta5060BM.ATTR_DEGTRRESNREGNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			setReadOnly(true);
    		}
    	});
    	/** column 상위단위사업장코드 : hhrkUntDpobCd */
    	listColumnDefs.add(new ColumnDef("상위단위사업장코드", Yeta5060BM.ATTR_HHRKUNTDPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			setReadOnly(true);
    		}
    	});
    	
    	/** column 법인등록번호 : corpRgstnNum */
    	listColumnDefs.add(new ColumnDef("법인등록번호", Yeta5060BM.ATTR_CORPRGSTNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			setReadOnly(true);
    		}
    	});
    	/** column 법인구분코드 : corpDivCd */
    	listColumnDefs.add(new ColumnDef("법인구분코드", Yeta5060BM.ATTR_CORPDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			setReadOnly(true);
    		}
    	});
    	/** column 사업장우편번호 : dpobZpcd */
    	listColumnDefs.add(new ColumnDef("사업장우편번호", Yeta5060BM.ATTR_UNTDPOBZPCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			setReadOnly(true);
    		}
    	});
    	/** column 사업장기본주소 : dpobFndtnAddr */
    	listColumnDefs.add(new ColumnDef("사업장기본주소", Yeta5060BM.ATTR_UNTDPOBFNDTNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			setReadOnly(true);
    		}
    	});
    	/** column 사업장상세주소 : dpobDtlPatrAddr */
    	listColumnDefs.add(new ColumnDef("사업장상세주소", Yeta5060BM.ATTR_UNTDPOBDTLPATRADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			setReadOnly(true);
    		}
    	});
    	/** column 사업장전화번호 : dpobPhnNum */
    	listColumnDefs.add(new ColumnDef("사업장전화번호", Yeta5060BM.ATTR_UNTDPOBPHNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			setReadOnly(true);
    		}
    	});
    	/** column 사업장팩스번호 : dpobFaxNum */
    	listColumnDefs.add(new ColumnDef("사업장팩스번호", Yeta5060BM.ATTR_UNTDPOBFAXNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			setReadOnly(true);
    		}
    	});
    	/** column 사업장직인문구명 : dpobSealWrdNm */
    	listColumnDefs.add(new ColumnDef("사업장직인문구명", Yeta5060BM.ATTR_UNTDPOBSEALWRDNM, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			setReadOnly(true);
    		}
    	});
    	/** column 사업장직인경로 : dpobSealRftaNm */
    	listColumnDefs.add(new ColumnDef("사업장직인경로", Yeta5060BM.ATTR_UNTDPOBSEALFLNM, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			setReadOnly(true);
    		}
    	});
    	/** column 사업장직인파일명 : dpobSealFlNm */
    	listColumnDefs.add(new ColumnDef("사업장직인파일명", Yeta5060BM.ATTR_UNTDPOBSEALFLNM, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			setReadOnly(true);
    		}
    	});
    	
    	/** column 전자우편주소 : untDpobEctnMailAddr */
    	listColumnDefs.add(new ColumnDef("전자우편주소", Yeta5060BM.ATTR_UNTDPOBECTNMAILADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			setReadOnly(true);
    		}
    	});
    	/** column 업태 : untDpobBncdsNm */
    	listColumnDefs.add(new ColumnDef("업태", Yeta5060BM.ATTR_UNTDPOBBNCDSNM, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			setReadOnly(true);
    		}
    	});
    	/** column 종목명 : untDpobItemNm */
    	listColumnDefs.add(new ColumnDef("종목명", Yeta5060BM.ATTR_UNTDPOBITEMNM, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			setReadOnly(true);
    		}
    	});
    	/** column 주생산품 : untDpobMnPrdt */
    	listColumnDefs.add(new ColumnDef("주생산품", Yeta5060BM.ATTR_UNTDPOBMNPRDT, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			setReadOnly(true);
    		}
    	});
    	
    	/** column 입력자 : kybdr */
    	listColumnDefs.add(new ColumnDef("입력자", Yeta5060BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			setReadOnly(true);
    		}
    	});
    	/** column 입력일자 : inptDt */
    	listColumnDefs.add(new ColumnDef("입력일자", Yeta5060BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			setReadOnly(true);
    		}
    	});
    	/** column 입력주소 : inptAddr */
    	listColumnDefs.add(new ColumnDef("입력주소", Yeta5060BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			setReadOnly(true);
    		}
    	});
    	/** column 수정자 : ismt */
    	listColumnDefs.add(new ColumnDef("수정자", Yeta5060BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			setReadOnly(true);
    		}
    	});
    	/** column 수정일자 : revnDt */
    	listColumnDefs.add(new ColumnDef("수정일자", Yeta5060BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			setReadOnly(true);
    		}
    	});
    	/** column 수정자주소 : revnAddr */
    	listColumnDefs.add(new ColumnDef("수정자주소", Yeta5060BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			setReadOnly(true);
    		}
    	});
    	/** column 단위사업장승인번호 : upDpobCmpNo */
    	listColumnDefs.add(new ColumnDef("단위사업장승인번호", Yeta5060BM.ATTR_UPDPOBCMPNO, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			setReadOnly(true);
    		}
    	});
    	/** column C171_사업자단위과세자여부 : upDpobUtynC171 */
    	listColumnDefs.add(new ColumnDef("C171_사업자단위과세자여부", Yeta5060BM.ATTR_UPDPOBUTYNC171, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			setReadOnly(true);
    		}
    	});
    	/** column C172_종사업장일련번호 : mtstDpobSeilNumC172 */
    	listColumnDefs.add(new ColumnDef("일련번호", Yeta5060BM.ATTR_MTSTDPOBSEILNUMC172, ColumnDef.TYPE_STRING , 90, true, true, true){
    		{    	
    			setReadOnly(false);
    		}
    	});
    	/** column 본지점구분코드 : mnbhDivCd */
    	listColumnDefs.add(new ColumnDef("본지점구분코드", Yeta5060BM.ATTR_MNBHDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			setReadOnly(true);
    		}
    	});
    	/** column 원천세신고유형구분코드 : whdgTxCtypDivCd */
    	listColumnDefs.add(new ColumnDef("원천세신고유형구분코드", Yeta5060BM.ATTR_WHDGTXCTYPDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			setReadOnly(true);
    		}
    	});
    	/** column 원천세신고유형구분코드 : whdgTxCtypDivCd */
    	listColumnDefs.add(new ColumnDef("이전사업자번호", Yeta5060BM.ATTR_BEFBUSOPRRGSTNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
    		{
    			setReadOnly(true);
    		}
    	});
    	return listColumnDefs;
    	
    }
    
}
