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

import com.app.exterms.basis.client.dto.InfcPkgBass0500BM;
import com.app.exterms.basis.client.languages.BasisConstants;
import com.app.exterms.basis.shared.PkgBasisDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class InfcPkgBass0500Def extends TableDef implements PkgBasisDaoConstants {
    private int row = 0;
    
    private BasisConstants lblBasisConst = BasisConstants.INSTANCE;
    
    public InfcPkgBass0500Def(String chkDef){
    	if ("YETA2070_BASS0500_ON".equals(chkDef)) {
	        setTitle("사용 사업정보");
	        setDaoClass("");
	        setCustomListMethod(CLASS_YETA2070_BASS0500_ON_LIST);
//	        setCustomListMethod("");
	        setAutoFillGrid(true);
            setShowFilterToolbar(false);   
            setCheckBoxOnGridRows(false); 
   	      	setEditFieldGrid(false);
	        setColumnsDefinition(getAllColumnsList_ON());  
	      
    	}else if ("YETA2070_BASS0500_OFF".equals(chkDef)) {
	        setTitle("미사용 사업정보");
	        setDaoClass("");
	        setCustomListMethod(CLASS_YETA2070_BASS0500_OFF_LIST);
//	        setCustomListMethod("");
	        setAutoFillGrid(true);
            setShowFilterToolbar(false);   
            setCheckBoxOnGridRows(false); 
   	      	setEditFieldGrid(false);
	        setColumnsDefinition(getAllColumnsList_OFF());
	        
    	}
    	else if ("YETA3070_BASS0500_ON".equals(chkDef)) {
	        setTitle("사용 사업정보");
	        setDaoClass("");
	        setCustomListMethod(CLASS_YETA3070_BASS0500_ON_LIST);
//	        setCustomListMethod("");
	        setAutoFillGrid(true);
            setShowFilterToolbar(false);   
            setCheckBoxOnGridRows(false); 
   	      	setEditFieldGrid(false);
	        setColumnsDefinition(getAllColumnsList_ON());  
	      
    	}else if ("YETA3070_BASS0500_OFF".equals(chkDef)) {
	        setTitle("미사용 사업정보");
	        setDaoClass("");
	        setCustomListMethod(CLASS_YETA3070_BASS0500_OFF_LIST);
//	        setCustomListMethod("");
	        setAutoFillGrid(true);
            setShowFilterToolbar(false);   
            setCheckBoxOnGridRows(false); 
   	      	setEditFieldGrid(false);
	        setColumnsDefinition(getAllColumnsList_OFF());
	        
    	}
    	else if ("YETA4070_BASS0500_ON".equals(chkDef)) {
	        setTitle("사용 사업정보");
	        setDaoClass("");
	        setCustomListMethod(CLASS_YETA4070_BASS0500_ON_LIST);
//	        setCustomListMethod("");
	        setAutoFillGrid(true);
            setShowFilterToolbar(false);   
            setCheckBoxOnGridRows(false); 
   	      	setEditFieldGrid(false);
	        setColumnsDefinition(getAllColumnsList_ON());  
	      
    	}else if ("YETA4070_BASS0500_OFF".equals(chkDef)) {
	        setTitle("미사용 사업정보");
	        setDaoClass("");
	        setCustomListMethod(CLASS_YETA4070_BASS0500_OFF_LIST);
//	        setCustomListMethod("");
	        setAutoFillGrid(true);
            setShowFilterToolbar(false);   
            setCheckBoxOnGridRows(false); 
   	      	setEditFieldGrid(false);
	        setColumnsDefinition(getAllColumnsList_OFF());
	        
    	}else if ("YETA5070_BASS0500_ON".equals(chkDef)) {
	        setTitle("사용 사업정보");
	        setDaoClass("");
	        setCustomListMethod(CLASS_YETA5070_BASS0500_ON_LIST);
//	        setCustomListMethod("");
	        setAutoFillGrid(true);
            setShowFilterToolbar(false);   
            setCheckBoxOnGridRows(false); 
   	      	setEditFieldGrid(false);
	        setColumnsDefinition(getAllColumnsList_ON());  
	      
    	}else if ("YETA5070_BASS0500_OFF".equals(chkDef)) {
	        setTitle("미사용 사업정보");
	        setDaoClass("");
	        setCustomListMethod(CLASS_YETA5070_BASS0500_OFF_LIST);
//	        setCustomListMethod("");
	        setAutoFillGrid(true);
            setShowFilterToolbar(false);   
            setCheckBoxOnGridRows(false); 
   	      	setEditFieldGrid(false);
	        setColumnsDefinition(getAllColumnsList_OFF());
    	}else if ("YETA6070_BASS0500_ON".equals(chkDef)) {
	        setTitle("사용 사업정보");
	        setDaoClass("");
	        setCustomListMethod(CLASS_YETA6070_BASS0500_ON_LIST);
//	        setCustomListMethod("");
	        setAutoFillGrid(true);
            setShowFilterToolbar(false);   
            setCheckBoxOnGridRows(false); 
   	      	setEditFieldGrid(false);
	        setColumnsDefinition(getAllColumnsList_ON());  
	      
    	}else if ("YETA6070_BASS0500_OFF".equals(chkDef)) {
	        setTitle("미사용 사업정보");
	        setDaoClass("");
	        setCustomListMethod(CLASS_YETA6070_BASS0500_OFF_LIST);
//	        setCustomListMethod("");
	        setAutoFillGrid(true);
            setShowFilterToolbar(false);   
            setCheckBoxOnGridRows(false); 
   	      	setEditFieldGrid(false);
	        setColumnsDefinition(getAllColumnsList_OFF());
    	}else if ("YETA7070_BASS0500_ON".equals(chkDef)) {
	        setTitle("사용 사업정보");
	        setDaoClass("");
	        setCustomListMethod(CLASS_YETA7070_BASS0500_ON_LIST);
//	        setCustomListMethod("");
	        setAutoFillGrid(true);
            setShowFilterToolbar(false);   
            setCheckBoxOnGridRows(false); 
   	      	setEditFieldGrid(false);
	        setColumnsDefinition(getAllColumnsList_ON());  
	      
    	}else if ("YETA7070_BASS0500_OFF".equals(chkDef)) {
	        setTitle("미사용 사업정보");
	        setDaoClass("");
	        setCustomListMethod(CLASS_YETA7070_BASS0500_OFF_LIST);
//	        setCustomListMethod("");
	        setAutoFillGrid(true);
            setShowFilterToolbar(false);   
            setCheckBoxOnGridRows(false); 
   	      	setEditFieldGrid(false);
	        setColumnsDefinition(getAllColumnsList_OFF());
    	}else if ("YETA8070_BASS0500_ON".equals(chkDef)) {
	        setTitle("사용 사업정보");
	        setDaoClass("");
	        setCustomListMethod(CLASS_YETA8070_BASS0500_ON_LIST);
//	        setCustomListMethod("");
	        setAutoFillGrid(true);
            setShowFilterToolbar(false);   
            setCheckBoxOnGridRows(false); 
   	      	setEditFieldGrid(false);
	        setColumnsDefinition(getAllColumnsList_ON());  
	      
    	}else if ("YETA8070_BASS0500_OFF".equals(chkDef)) {
	        setTitle("미사용 사업정보");
	        setDaoClass("");
	        setCustomListMethod(CLASS_YETA8070_BASS0500_OFF_LIST);
//	        setCustomListMethod("");
	        setAutoFillGrid(true);
            setShowFilterToolbar(false);   
            setCheckBoxOnGridRows(false); 
   	      	setEditFieldGrid(false);
	        setColumnsDefinition(getAllColumnsList_OFF());
    	}
    }
    
    
    private List<ColumnDef> getAllColumnsList_ON(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        listColumnDefs.add(new ColumnDef("선택", InfcPkgBass0500BM.ATTR_SELECT, ColumnDef.TYPE_BOOLEAN, 90, true, true, true){
        	{

        	}
        }); 
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", InfcPkgBass0500BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업코드 : businCd */
        listColumnDefs.add(new ColumnDef("사업코드", InfcPkgBass0500BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서코드", InfcPkgBass0500BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장코드 : untDpobCd */
        listColumnDefs.add(new ColumnDef("단위사업장", InfcPkgBass0500BM.ATTR_UNTDPOBNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		
        	}
        });
        /** column 사업적용년도 : businApptnYr */
        listColumnDefs.add(new ColumnDef("적용년도", InfcPkgBass0500BM.ATTR_BUSINAPPTNYR, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 부서명 : deptNm */
        listColumnDefs.add(new ColumnDef("부서", InfcPkgBass0500BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 사업명 : businNm */
        listColumnDefs.add(new ColumnDef("사업", InfcPkgBass0500BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 사업사용여부 : businUseYn */
        listColumnDefs.add(new ColumnDef("단위과세여부", InfcPkgBass0500BM.ATTR_BUSINUSEYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업사용여부 : businUseYn */
        listColumnDefs.add(new ColumnDef("사업사용여부", InfcPkgBass0500BM.ATTR_BUSINUSEYN, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		
        	}
        });
        /** column 급여인사관리부서사용여부 : payMangeDeptUseYn */
        listColumnDefs.add(new ColumnDef("급여인사관리부서사용여부", InfcPkgBass0500BM.ATTR_PAYMANGEDEPTUSEYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 관리부서코드 : mangeDeptCd */
        listColumnDefs.add(new ColumnDef("관리부서코드", InfcPkgBass0500BM.ATTR_MANGEDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
       
        /** column null : repbtyBusinDivCd */
        listColumnDefs.add(new ColumnDef("null", InfcPkgBass0500BM.ATTR_REPBTYBUSINDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업고용직종코드 : businEmymtTypOccuCd */
        listColumnDefs.add(new ColumnDef("사업고용직종코드", InfcPkgBass0500BM.ATTR_BUSINEMYMTTYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업담당직원번호X : businRepbtyEmpNum */
        listColumnDefs.add(new ColumnDef("사업담당직원번호X", InfcPkgBass0500BM.ATTR_BUSINREPBTYEMPNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 산재보험적용요율 : idtlAccdtInsurApmrt */
        listColumnDefs.add(new ColumnDef("산재보험적용요율", InfcPkgBass0500BM.ATTR_IDTLACCDTINSURAPMRT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 특기사항내용 : spityCtnt */
        listColumnDefs.add(new ColumnDef("특기사항내용", InfcPkgBass0500BM.ATTR_SPITYCTNT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 국민연금기호X : natPennSym */
        listColumnDefs.add(new ColumnDef("국민연금기호X", InfcPkgBass0500BM.ATTR_NATPENNSYM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 건강보험기호X : hlthInsrSym */
        listColumnDefs.add(new ColumnDef("건강보험기호X", InfcPkgBass0500BM.ATTR_HLTHINSRSYM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 고용보험기호X : umytInsrSym */
        listColumnDefs.add(new ColumnDef("고용보험기호X", InfcPkgBass0500BM.ATTR_UMYTINSRSYM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 산재보험기호X : idtlAccdtInsurSym */
        listColumnDefs.add(new ColumnDef("산재보험기호X", InfcPkgBass0500BM.ATTR_IDTLACCDTINSURSYM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업기간시작일자 : businStdt */
        listColumnDefs.add(new ColumnDef("사업기간시작일자", InfcPkgBass0500BM.ATTR_BUSINSTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업기간종료일자 : businEddt */
        listColumnDefs.add(new ColumnDef("사업기간종료일자", InfcPkgBass0500BM.ATTR_BUSINEDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 건강보험영업소기호X : hlthInsrOfceSym */
        listColumnDefs.add(new ColumnDef("건강보험영업소기호X", InfcPkgBass0500BM.ATTR_HLTHINSROFCESYM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종세적용단가구분코드 : dtilOcclsApptnUcstCd */
        listColumnDefs.add(new ColumnDef("직종세적용단가구분코드", InfcPkgBass0500BM.ATTR_DTILOCCLSAPPTNUCSTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분코드", InfcPkgBass0500BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 과세유형구분코드 : txtnFrmDivCd */
        listColumnDefs.add(new ColumnDef("과세유형구분코드", InfcPkgBass0500BM.ATTR_TXTNFRMDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장코드 : untDpobCd */
        listColumnDefs.add(new ColumnDef("단위사업장코드", InfcPkgBass0500BM.ATTR_UNTDPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사대보험사업장기호통합코드 : socInsrSymInttnCd */
        listColumnDefs.add(new ColumnDef("사대보험사업장기호통합코드", InfcPkgBass0500BM.ATTR_SOCINSRSYMINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업회계코드 : businAccCd */
        listColumnDefs.add(new ColumnDef("사업회계코드", InfcPkgBass0500BM.ATTR_BUSINACCCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 상위부서코드01 : hhrkDeptCd01 */
        listColumnDefs.add(new ColumnDef("상위부서코드01", InfcPkgBass0500BM.ATTR_HHRKDEPTCD01, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 상위부서코드02 : hhrkDeptCd02 */
        listColumnDefs.add(new ColumnDef("상위부서코드02", InfcPkgBass0500BM.ATTR_HHRKDEPTCD02, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", InfcPkgBass0500BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", InfcPkgBass0500BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", InfcPkgBass0500BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", InfcPkgBass0500BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", InfcPkgBass0500BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", InfcPkgBass0500BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 원천세징수유형구분코드 : whdgTxCtypDivCd */
        listColumnDefs.add(new ColumnDef("원천세징수유형구분코드", InfcPkgBass0500BM.ATTR_WHDGTXCTYPDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        return listColumnDefs;
    }
    
    private List<ColumnDef> getAllColumnsList_OFF(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
         
        listColumnDefs.add(new ColumnDef("선택", InfcPkgBass0500BM.ATTR_SELECT, ColumnDef.TYPE_BOOLEAN, 90, true, true, true){
        	{

        	}
        }); 
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", InfcPkgBass0500BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업코드 : businCd */
        listColumnDefs.add(new ColumnDef("사업코드", InfcPkgBass0500BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서코드", InfcPkgBass0500BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장코드 : untDpobCd */
        listColumnDefs.add(new ColumnDef("단위사업장", InfcPkgBass0500BM.ATTR_UNTDPOBNM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{
        		
        	}
        });
        /** column 사업적용년도 : businApptnYr */
        listColumnDefs.add(new ColumnDef("적용년도", InfcPkgBass0500BM.ATTR_BUSINAPPTNYR, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{

        	}
        });
        /** column 부서명 : deptNm */
        listColumnDefs.add(new ColumnDef("부서", InfcPkgBass0500BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 120, true, true, true){
        	{

        	}
        });
        /** column 사업명 : businNm */
        listColumnDefs.add(new ColumnDef("사업", InfcPkgBass0500BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING , 120, true, true, true){
        	{

        	}
        });
        /** column 사업사용여부 : businUseYn */
        listColumnDefs.add(new ColumnDef("단위과세여부", InfcPkgBass0500BM.ATTR_BUSINUSEYN, ColumnDef.TYPE_STRING , 65, true, false, true){
        	{

        	}
        });
        /** column 사업사용여부 : businUseYn */
        listColumnDefs.add(new ColumnDef("사업사용여부", InfcPkgBass0500BM.ATTR_BUSINUSEYN, ColumnDef.TYPE_STRING , 90, true, true, true){
        	{
        		
        	}
        });
        /** column 급여인사관리부서사용여부 : payMangeDeptUseYn */
        listColumnDefs.add(new ColumnDef("급여인사관리부서사용여부", InfcPkgBass0500BM.ATTR_PAYMANGEDEPTUSEYN, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 관리부서코드 : mangeDeptCd */
        listColumnDefs.add(new ColumnDef("관리부서코드", InfcPkgBass0500BM.ATTR_MANGEDEPTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
       
        /** column null : repbtyBusinDivCd */
        listColumnDefs.add(new ColumnDef("null", InfcPkgBass0500BM.ATTR_REPBTYBUSINDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업고용직종코드 : businEmymtTypOccuCd */
        listColumnDefs.add(new ColumnDef("사업고용직종코드", InfcPkgBass0500BM.ATTR_BUSINEMYMTTYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업담당직원번호X : businRepbtyEmpNum */
        listColumnDefs.add(new ColumnDef("사업담당직원번호X", InfcPkgBass0500BM.ATTR_BUSINREPBTYEMPNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 산재보험적용요율 : idtlAccdtInsurApmrt */
        listColumnDefs.add(new ColumnDef("산재보험적용요율", InfcPkgBass0500BM.ATTR_IDTLACCDTINSURAPMRT, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
        	{

        	}
        });
        /** column 특기사항내용 : spityCtnt */
        listColumnDefs.add(new ColumnDef("특기사항내용", InfcPkgBass0500BM.ATTR_SPITYCTNT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 국민연금기호X : natPennSym */
        listColumnDefs.add(new ColumnDef("국민연금기호X", InfcPkgBass0500BM.ATTR_NATPENNSYM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 건강보험기호X : hlthInsrSym */
        listColumnDefs.add(new ColumnDef("건강보험기호X", InfcPkgBass0500BM.ATTR_HLTHINSRSYM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 고용보험기호X : umytInsrSym */
        listColumnDefs.add(new ColumnDef("고용보험기호X", InfcPkgBass0500BM.ATTR_UMYTINSRSYM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 산재보험기호X : idtlAccdtInsurSym */
        listColumnDefs.add(new ColumnDef("산재보험기호X", InfcPkgBass0500BM.ATTR_IDTLACCDTINSURSYM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업기간시작일자 : businStdt */
        listColumnDefs.add(new ColumnDef("사업기간시작일자", InfcPkgBass0500BM.ATTR_BUSINSTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업기간종료일자 : businEddt */
        listColumnDefs.add(new ColumnDef("사업기간종료일자", InfcPkgBass0500BM.ATTR_BUSINEDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 건강보험영업소기호X : hlthInsrOfceSym */
        listColumnDefs.add(new ColumnDef("건강보험영업소기호X", InfcPkgBass0500BM.ATTR_HLTHINSROFCESYM, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 직종세적용단가구분코드 : dtilOcclsApptnUcstCd */
        listColumnDefs.add(new ColumnDef("직종세적용단가구분코드", InfcPkgBass0500BM.ATTR_DTILOCCLSAPPTNUCSTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분코드", InfcPkgBass0500BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 과세유형구분코드 : txtnFrmDivCd */
        listColumnDefs.add(new ColumnDef("과세유형구분코드", InfcPkgBass0500BM.ATTR_TXTNFRMDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 단위사업장코드 : untDpobCd */
        listColumnDefs.add(new ColumnDef("단위사업장코드", InfcPkgBass0500BM.ATTR_UNTDPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사대보험사업장기호통합코드 : socInsrSymInttnCd */
        listColumnDefs.add(new ColumnDef("사대보험사업장기호통합코드", InfcPkgBass0500BM.ATTR_SOCINSRSYMINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 사업회계코드 : businAccCd */
        listColumnDefs.add(new ColumnDef("사업회계코드", InfcPkgBass0500BM.ATTR_BUSINACCCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 상위부서코드01 : hhrkDeptCd01 */
        listColumnDefs.add(new ColumnDef("상위부서코드01", InfcPkgBass0500BM.ATTR_HHRKDEPTCD01, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 상위부서코드02 : hhrkDeptCd02 */
        listColumnDefs.add(new ColumnDef("상위부서코드02", InfcPkgBass0500BM.ATTR_HHRKDEPTCD02, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력자 : kybdr */
        listColumnDefs.add(new ColumnDef("입력자", InfcPkgBass0500BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력일자 : inptDt */
        listColumnDefs.add(new ColumnDef("입력일자", InfcPkgBass0500BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 입력주소 : inptAddr */
        listColumnDefs.add(new ColumnDef("입력주소", InfcPkgBass0500BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정자 : ismt */
        listColumnDefs.add(new ColumnDef("수정자", InfcPkgBass0500BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정일자 : revnDt */
        listColumnDefs.add(new ColumnDef("수정일자", InfcPkgBass0500BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 수정주소 : revnAddr */
        listColumnDefs.add(new ColumnDef("수정주소", InfcPkgBass0500BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        /** column 원천세징수유형구분코드 : whdgTxCtypDivCd */
        listColumnDefs.add(new ColumnDef("원천세징수유형구분코드", InfcPkgBass0500BM.ATTR_WHDGTXCTYPDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
        	{

        	}
        });
        return listColumnDefs;
    }
    
    
}
