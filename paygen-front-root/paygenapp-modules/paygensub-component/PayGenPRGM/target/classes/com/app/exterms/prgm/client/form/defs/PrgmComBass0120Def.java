/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.exterms.prgm.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0120BM;
import com.app.exterms.prgm.client.languages.PrgmConstants;
import com.app.exterms.prgm.shared.PrgmComDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class PrgmComBass0120Def extends TableDef implements PrgmComDaoConstants {

    private int row = 0;
    private PrgmConstants SysComLabel = PrgmConstants.INSTANCE;

    
    public PrgmComBass0120Def(){
    	
    	  setTitle("");
          setDaoClass(PRGMCOM_METHOD_BASS0120_LIST); 
          setCustomListMethod(PRGMCOM_METHOD_BASS0120_LIST);
          setColumnsDefinition(getAllColumnsList());
          setAutoFillGrid(false);
          setShowFilterToolbar(false);
    }
     

    private List<ColumnDef> getAllColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
         
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", PrgmComBass0120BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장코드 : utDpobCd */
        listColumnDefs.add(new ColumnDef("단위사업장코드", PrgmComBass0120BM.ATTR_UTDPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장명 : utDpobNm */
        listColumnDefs.add(new ColumnDef("단위사업장명", PrgmComBass0120BM.ATTR_UTDPOBNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 상위단위사업장코드 : hhrkUntDpobCd */
        listColumnDefs.add(new ColumnDef("상위단위사업장코드", PrgmComBass0120BM.ATTR_HHRKUNTDPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 대표자주민번호 : degtrResnRegnNum */
        listColumnDefs.add(new ColumnDef("대표자주민번호", PrgmComBass0120BM.ATTR_DEGTRRESNREGNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 대표자명 : degtrNm */
        listColumnDefs.add(new ColumnDef("대표자명", PrgmComBass0120BM.ATTR_DEGTRNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 내외국인구분코드 : frgnrDivCd */
        listColumnDefs.add(new ColumnDef("내외국인구분코드", PrgmComBass0120BM.ATTR_FRGNRDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업자등록번호 : busoprRgstnNum */
        listColumnDefs.add(new ColumnDef("사업자등록번호", PrgmComBass0120BM.ATTR_BUSOPRRGSTNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 법인등록번호 : corpRgstnNum */
        listColumnDefs.add(new ColumnDef("법인등록번호", PrgmComBass0120BM.ATTR_CORPRGSTNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 법인구분코드 : corpDivCd */
        listColumnDefs.add(new ColumnDef("법인구분코드", PrgmComBass0120BM.ATTR_CORPDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장우편번호 : untDpobZpcd */
        listColumnDefs.add(new ColumnDef("단위사업장우편번호", PrgmComBass0120BM.ATTR_UNTDPOBZPCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장기본주소 : untDpobFndtnAddr */
        listColumnDefs.add(new ColumnDef("단위사업장기본주소", PrgmComBass0120BM.ATTR_UNTDPOBFNDTNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장상세주소 : untDpobDtlPatrAddr */
        listColumnDefs.add(new ColumnDef("단위사업장상세주소", PrgmComBass0120BM.ATTR_UNTDPOBDTLPATRADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장전화번호 : untDpobPhnNum */
        listColumnDefs.add(new ColumnDef("단위사업장전화번호", PrgmComBass0120BM.ATTR_UNTDPOBPHNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장팩스번호 : untDpobFaxNum */
        listColumnDefs.add(new ColumnDef("단위사업장팩스번호", PrgmComBass0120BM.ATTR_UNTDPOBFAXNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장전자우편주소 : untDpobEctnMailAddr */
        listColumnDefs.add(new ColumnDef("단위사업장전자우편주소", PrgmComBass0120BM.ATTR_UNTDPOBECTNMAILADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장업종_업태 : untDpobBncdsNm */
        listColumnDefs.add(new ColumnDef("단위사업장업종_업태", PrgmComBass0120BM.ATTR_UNTDPOBBNCDSNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장업종_종목명 : untDpobItemNm */
        listColumnDefs.add(new ColumnDef("단위사업장업종_종목명", PrgmComBass0120BM.ATTR_UNTDPOBITEMNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장업종_주생산품 : untDpobMnPrdt */
        listColumnDefs.add(new ColumnDef("단위사업장업종_주생산품", PrgmComBass0120BM.ATTR_UNTDPOBMNPRDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장설립일자 : untDpobEsbmDt */
        listColumnDefs.add(new ColumnDef("단위사업장설립일자", PrgmComBass0120BM.ATTR_UNTDPOBESBMDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장개업일자 : untDpobIngnDt */
        listColumnDefs.add(new ColumnDef("단위사업장개업일자", PrgmComBass0120BM.ATTR_UNTDPOBINGNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장폐업일자 : untDpobEobDt */
        listColumnDefs.add(new ColumnDef("단위사업장폐업일자", PrgmComBass0120BM.ATTR_UNTDPOBEOBDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장직인문구명 : untDpobSealWrdNm */
        listColumnDefs.add(new ColumnDef("단위사업장직인문구명", PrgmComBass0120BM.ATTR_UNTDPOBSEALWRDNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장직인경로 : untDpobSealRfta */
        listColumnDefs.add(new ColumnDef("단위사업장직인경로", PrgmComBass0120BM.ATTR_UNTDPOBSEALRFTA, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장직인파일명 : untDpobSealFlnm */
        listColumnDefs.add(new ColumnDef("단위사업장직인파일명", PrgmComBass0120BM.ATTR_UNTDPOBSEALFLNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장기본사용여부 : untDpobFndtnUseYn */
        listColumnDefs.add(new ColumnDef("단위사업장기본사용여부", PrgmComBass0120BM.ATTR_UNTDPOBFNDTNUSEYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", PrgmComBass0120BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", PrgmComBass0120BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", PrgmComBass0120BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", PrgmComBass0120BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", PrgmComBass0120BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", PrgmComBass0120BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 주종사업장코드 : mtstBusinDivCd */
        listColumnDefs.add(new ColumnDef("주종사업장코드", PrgmComBass0120BM.ATTR_MTSTBUSINDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장승인번호 : upDpobCmpNo */
        listColumnDefs.add(new ColumnDef("단위사업장승인번호", PrgmComBass0120BM.ATTR_UPDPOBCMPNO, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column C171_사업자단위과세자여부 : upDpobUtynC171 */
        listColumnDefs.add(new ColumnDef("C171_사업자단위과세자여부", PrgmComBass0120BM.ATTR_UPDPOBUTYNC171, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column C172_종사업장일련번호 : mtstDpobSeilNumC172 */
        listColumnDefs.add(new ColumnDef("C172_종사업장일련번호", PrgmComBass0120BM.ATTR_MTSTDPOBSEILNUMC172, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 본지점구분코드 : mnbhDivCd */
        listColumnDefs.add(new ColumnDef("본지점구분코드", PrgmComBass0120BM.ATTR_MNBHDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 원천세신고유형구분코드 : whdgTxCtypDivCd */
        listColumnDefs.add(new ColumnDef("원천세신고유형구분코드", PrgmComBass0120BM.ATTR_WHDGTXCTYPDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        return listColumnDefs;
    }
    
 
    
}
