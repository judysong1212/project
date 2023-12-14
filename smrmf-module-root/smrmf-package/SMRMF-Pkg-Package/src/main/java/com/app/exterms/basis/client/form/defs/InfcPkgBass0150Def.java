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

import com.app.exterms.basis.client.dto.InfcPkgBass0150BM;
import com.app.exterms.basis.client.dto.InfcPkgBass0150DTO;
import com.app.exterms.basis.client.languages.BasisConstants;
import com.app.exterms.basis.client.lookup.LookupPrgmComBass0120;
import com.app.exterms.basis.shared.PkgBasisDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.listner.ColumnDefListenerAdapter;
import com.app.smrmf.core.msfmainapp.client.utils.GWTUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.widget.form.Field;

public class InfcPkgBass0150Def extends TableDef implements PkgBasisDaoConstants {
    private int row = 0;
    
    private BasisConstants lblBasisConst = BasisConstants.INSTANCE;
    
    private InfcPkgBass0150DTO pkgBass0150DTO;
    
    protected ColumnDefListenerAdapter changeValueListenerAdapter;
    
    protected ColumnListDef dtDpobCdColumnDef;
    
    private  String dtDpobCd = "";   //단위사업장
    
	public String getDtDpobCd() {
		return dtDpobCd;
	}

	public void setDtDpobCd(String dtDpobCd) {
		this.dtDpobCd = dtDpobCd;
	}
    
    public InfcPkgBass0150Def(String chkDef){
    	if ("yeta2070ToBass0150".equals(chkDef)) {
    		
    		pkgBass0150DTO = new InfcPkgBass0150DTO();
    		
	        setTitle("단위기관");
	        setDaoClass("");
	        setCustomListMethod(CLASS_YETA2070_BASS0150_LIST);
//	        setCustomListMethod("");
	        setCheckBoxOnGridRows(true);
	        setAutoFillGrid(false);
	        setShowFilterToolbar(false);
	        setEditFieldGrid(true);
	        setColumnsDefinition(getAllColumnsList()); 
    	}
    	else if ("yeta3070ToBass0150".equals(chkDef)) {
    		
    		pkgBass0150DTO = new InfcPkgBass0150DTO();
    		
	        setTitle("단위기관");
	        setDaoClass("");
	        setCustomListMethod(CLASS_YETA3070_BASS0150_LIST);
//	        setCustomListMethod("");
	        setCheckBoxOnGridRows(true);
	        setAutoFillGrid(false);
	        setShowFilterToolbar(false);
	        setEditFieldGrid(true);
	        setColumnsDefinition(getAllColumnsList()); 
    	}else if ("yeta4070ToBass0150".equals(chkDef)) {
    		
    		pkgBass0150DTO = new InfcPkgBass0150DTO();
    		
	        setTitle("단위기관");
	        setDaoClass("");
	        setCustomListMethod(CLASS_YETA4070_BASS0150_LIST);
//	        setCustomListMethod("");
	        setCheckBoxOnGridRows(true);
	        setAutoFillGrid(false);
	        setShowFilterToolbar(false);
	        setEditFieldGrid(true);
	        setColumnsDefinition(getAllColumnsList()); 
    	}else if ("yeta5070ToBass0150".equals(chkDef)) {
    		
    		pkgBass0150DTO = new InfcPkgBass0150DTO();
    		
	        setTitle("단위기관");
	        setDaoClass("");
	        setCustomListMethod(CLASS_YETA5070_BASS0150_LIST);
//	        setCustomListMethod("");
	        setCheckBoxOnGridRows(true);
	        setAutoFillGrid(false);
	        setShowFilterToolbar(false);
	        setEditFieldGrid(true);
	        setColumnsDefinition(getAllColumnsList()); 
    	}else if ("yeta6070ToBass0150".equals(chkDef)) {
    		
    		pkgBass0150DTO = new InfcPkgBass0150DTO();
    		
	        setTitle("단위기관");
	        setDaoClass("");
	        setCustomListMethod(CLASS_YETA6070_BASS0150_LIST);
//	        setCustomListMethod("");
	        setCheckBoxOnGridRows(true);
	        setAutoFillGrid(false);
	        setShowFilterToolbar(false);
	        setEditFieldGrid(true);
	        setColumnsDefinition(getAllColumnsList()); 
    	}else if ("yeta7070ToBass0150".equals(chkDef)) {
    		
    		pkgBass0150DTO = new InfcPkgBass0150DTO();
    		
	        setTitle("단위기관");
	        setDaoClass("");
	        setCustomListMethod(CLASS_YETA7070_BASS0150_LIST);
//	        setCustomListMethod("");
	        setCheckBoxOnGridRows(true);
	        setAutoFillGrid(false);
	        setShowFilterToolbar(false);
	        setEditFieldGrid(true);
	        setColumnsDefinition(getAllColumnsList()); 
    	}else if ("yeta8070ToBass0150".equals(chkDef)) {
    		
    		pkgBass0150DTO = new InfcPkgBass0150DTO();
    		
	        setTitle("단위기관");
	        setDaoClass("");
	        setCustomListMethod(CLASS_YETA8070_BASS0150_LIST);
//	        setCustomListMethod("");
	        setCheckBoxOnGridRows(true);
	        setAutoFillGrid(false);
	        setShowFilterToolbar(false);
	        setEditFieldGrid(true);
	        setColumnsDefinition(getAllColumnsList()); 
    	}
	      
    }
       
    private List<ColumnDef> getAllColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", InfcPkgBass0150BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여관리부서코드 : payrMangDeptCd */
        listColumnDefs.add(new ColumnDef("단위기관코드", InfcPkgBass0150BM.ATTR_PAYRMANGDEPTCD, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 급여관리부서명 : payMangeDeptNm */
        listColumnDefs.add(new ColumnDef("단위기관명", InfcPkgBass0150BM.ATTR_PAYMANGEDEPTNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 대표자주민번호 : degtrResnRegnNum */
        listColumnDefs.add(new ColumnDef("대표자주민번호", InfcPkgBass0150BM.ATTR_DEGTRRESNREGNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 대표자명 : degtrNm */
        listColumnDefs.add(new ColumnDef("대표자명", InfcPkgBass0150BM.ATTR_DEGTRNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 사업자등록번호 : busoprRgstnNum */
        listColumnDefs.add(new ColumnDef("사업자등록번호", InfcPkgBass0150BM.ATTR_BUSOPRRGSTNNUM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 급여관리부서총괄담당자 : payMangeDeptWhlePernChrg */
        listColumnDefs.add(new ColumnDef("담당자", InfcPkgBass0150BM.ATTR_PAYMANGEDEPTWHLEPERNCHRG, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        /** column 단위사업장코드 : untDpobCd */
        pkgBass0150DTO.setUntDpobFndtnUseYn("Y");
        dtDpobCdColumnDef = new ColumnListDef("단위사업장", InfcPkgBass0150BM.ATTR_UNTDPOBCD, ColumnDef.TYPE_STRING, 100, true, true, true, new LookupPrgmComBass0120(pkgBass0150DTO),InfcPkgBass0150BM.ATTR_UTDPOBCD,InfcPkgBass0150BM.ATTR_UTDPOBNM){
        	{ 
        		setReadOnly(false);
        	}
        };
        listColumnDefs.add(dtDpobCdColumnDef);
        listColumnDefs.add(new ColumnDef("단위사업장", InfcPkgBass0150BM.ATTR_UNTDPOBNM, ColumnDef.TYPE_STRING , 90, false, false, false){
        	{

        	}
        });
        /** column 법인등록번호 : corpRgstnNum */
        listColumnDefs.add(new ColumnDef("법인등록번호", InfcPkgBass0150BM.ATTR_CORPRGSTNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 법인구분코드 : corpDivCd */
        listColumnDefs.add(new ColumnDef("법인구분코드", InfcPkgBass0150BM.ATTR_CORPDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여관리부서우편번호 : payMangeDeptZpcd */
        listColumnDefs.add(new ColumnDef("급여관리부서우편번호", InfcPkgBass0150BM.ATTR_PAYMANGEDEPTZPCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여관리부서기본주소 : payMangeDeptFNdtnAddr */
        listColumnDefs.add(new ColumnDef("급여관리부서기본주소", InfcPkgBass0150BM.ATTR_PAYMANGEDEPTFNDTNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여관리부서상세주소 : payMangeDeptDtlPatrAddr */
        listColumnDefs.add(new ColumnDef("급여관리부서상세주소", InfcPkgBass0150BM.ATTR_PAYMANGEDEPTDTLPATRADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여관리부서전화번호 : payMangeDeptPhnNum */
        listColumnDefs.add(new ColumnDef("급여관리부서전화번호", InfcPkgBass0150BM.ATTR_PAYMANGEDEPTPHNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여관리부서팩스번호 : payMangeDeptFaxNum */
        listColumnDefs.add(new ColumnDef("급여관리부서팩스번호", InfcPkgBass0150BM.ATTR_PAYMANGEDEPTFAXNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여관리부서직인문구명 : payMangeDeptSealWrdNm */
        listColumnDefs.add(new ColumnDef("급여관리부서직인문구명", InfcPkgBass0150BM.ATTR_PAYMANGEDEPTSEALWRDNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여관리부서직인경로 : payMangeDeptSealRftaNm */
        listColumnDefs.add(new ColumnDef("급여관리부서직인경로", InfcPkgBass0150BM.ATTR_PAYMANGEDEPTSEALRFTANM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여관리부서직인파일명 : payMangeDeptSealFlNm */
        listColumnDefs.add(new ColumnDef("급여관리부서직인파일명", InfcPkgBass0150BM.ATTR_PAYMANGEDEPTSEALFLNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여관리부서기본사용여부 : payMangeDeptFNdtnUseYn */
        listColumnDefs.add(new ColumnDef("급여관리부서기본사용여부", InfcPkgBass0150BM.ATTR_PAYMANGEDEPTFNDTNUSEYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 급여관리부서분임지출관 : payMangeDeptDivTskOffr */
        listColumnDefs.add(new ColumnDef("급여관리부서분임지출관", InfcPkgBass0150BM.ATTR_PAYMANGEDEPTDIVTSKOFFR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 회계코드 : accCd */
        listColumnDefs.add(new ColumnDef("회계코드", InfcPkgBass0150BM.ATTR_ACCCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 건강보험기호XX : hlthInsrSym */
        listColumnDefs.add(new ColumnDef("건강보험기호XX", InfcPkgBass0150BM.ATTR_HLTHINSRSYM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 국민연금기호XX : natPennSym */
        listColumnDefs.add(new ColumnDef("국민연금기호XX", InfcPkgBass0150BM.ATTR_NATPENNSYM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 고용보험기호XX : umytInsrSym */
        listColumnDefs.add(new ColumnDef("고용보험기호XX", InfcPkgBass0150BM.ATTR_UMYTINSRSYM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 징수의무자명 : cllnDebrNm */
        listColumnDefs.add(new ColumnDef("징수의무자명", InfcPkgBass0150BM.ATTR_CLLNDEBRNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 홈텍스ID : hmtxId */
        listColumnDefs.add(new ColumnDef("홈텍스ID", InfcPkgBass0150BM.ATTR_HMTXID, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 세무서코드 : txOffcCd */
        listColumnDefs.add(new ColumnDef("세무서코드", InfcPkgBass0150BM.ATTR_TXOFFCCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 은행코드 : bnkCd */
        listColumnDefs.add(new ColumnDef("은행코드", InfcPkgBass0150BM.ATTR_BNKCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 지로이체코드 : groTnsrCd */
        listColumnDefs.add(new ColumnDef("지로이체코드", InfcPkgBass0150BM.ATTR_GROTNSRCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", InfcPkgBass0150BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", InfcPkgBass0150BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", InfcPkgBass0150BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", InfcPkgBass0150BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", InfcPkgBass0150BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", InfcPkgBass0150BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 건강보험영업소기호XX : hlthInsrOfceSym */
        listColumnDefs.add(new ColumnDef("건강보험영업소기호XX", InfcPkgBass0150BM.ATTR_HLTHINSROFCESYM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 산재보험기호XX : idtlAccdtInsurSym */
        listColumnDefs.add(new ColumnDef("산재보험기호XX", InfcPkgBass0150BM.ATTR_IDTLACCDTINSURSYM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 과세유형구분코드 : txtnFrmDivCd */
        listColumnDefs.add(new ColumnDef("과세유형구분코드", InfcPkgBass0150BM.ATTR_TXTNFRMDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사대보험사업장기호통합코드 : socInsrSymInttnCd */
        listColumnDefs.add(new ColumnDef("사대보험사업장기호통합코드", InfcPkgBass0150BM.ATTR_SOCINSRSYMINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 전자우편주소 : ectnMailAddr */
        listColumnDefs.add(new ColumnDef("전자우편주소", InfcPkgBass0150BM.ATTR_ECTNMAILADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분코드", InfcPkgBass0150BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        
        return listColumnDefs;
    }
}
