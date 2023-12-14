/**
 * 공통화면 팝업 
 */
package com.app.exterms.payroll.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0530BM;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.paygencomm.client.constants.PayGenConst;
import com.google.gwt.i18n.client.DateTimeFormat;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr0530Def  extends TableDef implements PayrDaoConstants {

    private int row = 0;
    private PayrConstants PayrLabel = PayrConstants.INSTANCE;

    final PrgmComBass0300DTO sysComBass0300Dto;
    
    
    public Payr0530Def(String chkDef){
        
        sysComBass0300Dto = new PrgmComBass0300DTO(); 
        
        
        if ("PAYRP410005".equals(chkDef)) {
            
            setDaoClass(CLASS_PAYRP410005_PAYR0530_DATA_LIST);
            setCustomListMethod(CLASS_PAYRP410005_PAYR0530_DATA_LIST);
            setAutoFillGrid(false); 
            setShowFilterToolbar(false);  
            
            addColumnFilter("pymtDducDivCd", PayGenConst.PYMT_DDUC_DIV_CD_03, SimpleColumnFilter.OPERATOR_EQUALS);   
           
          setColumnsDefinition(getPayrP410005ToPayr0530Def());
          
      } else {
        setTitle(PayrLabel.titlePayr0530());
        setDaoClass(CLASS_PAYR0530_DATA_LIST);
        setCustomListMethod(CLASS_PAYR0530_DATA_LIST);
        setAutoFillGrid(false);
        setShowFilterToolbar(false);
        // setCustomListMethod(SysConfiguration.CUSTOM_SERVICE_SKIP_CALL);
         setCheckBoxOnGridRows(true);
      //  setEditableGrid(true); 
        setEditFieldGrid(true);
        
        setColumnsDefinition(getPayr0530Def()) ;
        
      }
       
    }
public List<ColumnDef> getPayrP410005ToPayr0530Def(){
  
          
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0530BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Payr0530BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        

        /** column 고용구분코드 : emymtDivCd */
        listColumnDefs.add(new ColumnDef("고용구분코드", Payr0530BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
        /** column 고용구분 : emymtDivNm */
        listColumnDefs.add(new ColumnDef("고용구분", Payr0530BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING, 70, false, true, true){
        	{

        	}
        });
        
        /** column 부서 : deptNm */
        listColumnDefs.add(new ColumnDef("부서명", Payr0530BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING, 100, true, true, true){
        	{

        	}
        });
      
        
        /** column 직종 : typOccuNm */
        listColumnDefs.add(new ColumnDef("직종", Payr0530BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{

        	}
        });
        

    	/** column 직종세 : dtilOccuClsDivNm */
    	listColumnDefs.add(new ColumnDef("직종세", Payr0530BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 100, false, true, true){
    	{
    	
    	}
    	});                     


        /** column 사업 : businNm */
        listColumnDefs.add(new ColumnDef("사업명", Payr0530BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING, 90, false, true, true){
            {

            }
        });
        
        /** column 재직구분코드 : hdofcDivCd */
        listColumnDefs.add(new ColumnDef("재직구분코드", Payr0530BM.ATTR_HDOFCDIVCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        });
        
        /** column 재직상태코드 : hdofcCodtnCd */
        listColumnDefs.add(new ColumnDef("재직구분", Payr0530BM.ATTR_HDOFCDIVNM, ColumnDef.TYPE_STRING , 80, true, true, true){
        	{

        	}
        });
        
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("성명", Payr0530BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 60, true, true, true){
        	{

        	}
        });
        /** column 주민등록번호 : resnRegnNum */
        listColumnDefs.add(new ColumnDef("주민등록번호", Payr0530BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 80, true, true, true){
        	{

        	}
        });
       
        /** column 부서코드 : deptCd */
        listColumnDefs.add(new ColumnDef("부서코드", Payr0530BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING, 120, false, false, true){
        	{

        	}
        });
        /** column 사업코드 : businCd */
        listColumnDefs.add(new ColumnDef("사업코드", Payr0530BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종코드", Payr0530BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 직종세구분코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세구분코드", Payr0530BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
        
    	/** column 직종세통합코드 : dtilOccuInttnCd */
    	listColumnDefs.add(new ColumnDef("직종세통합코드", Payr0530BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
    	{
    	
    	}
    	});                                           
          


        /** column 직종세 : dtilOccuClsDivNm */
        listColumnDefs.add(new ColumnDef("직종세", Payr0530BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
        /** column 급여가족사항일련번호 : payFamyRsptSeilNum */
        listColumnDefs.add(new ColumnDef("번호", Payr0530BM.ATTR_PAYFAMYRSPTSEILNUM, ColumnDef.TYPE_LONG, 90, false, false, true){
        	{

        	}
        });
        sysComBass0300Dto.setRpsttvCd("A019"); 
        /** column 가족관계구분코드 : famyRelaDivCd */
        listColumnDefs.add(new ColumnListDef("가족관계", Payr0530BM.ATTR_FAMYRELADIVCD, ColumnDef.TYPE_STRING, 60, true, false, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
            {
                setReadOnly(true);
            }
        });
        /** column 가족관계 : famyRelaDivNm */
        listColumnDefs.add(new ColumnDef("가족관계", Payr0530BM.ATTR_FAMYRELADIVNM, ColumnDef.TYPE_STRING, 60, false, true, true){
            {
                setReadOnly(true);
            }
        });
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("가족성명", Payr0530BM.ATTR_FMLYHANNM, ColumnDef.TYPE_STRING, 50, false, true, true){
            {
                setReadOnly(true);
            }
        });
        /** column 급여가족주민번호 : payFamyResnRegnNum */
        listColumnDefs.add(new ColumnDef("가족주민번호", Payr0530BM.ATTR_PAYFAMYRESNREGNNUM, ColumnDef.TYPE_STRING, 100, false, true, true){
        	{
        	    setReadOnly(true);
        	}
        });
     
        /** column 가족수당지급여부 : famyAllwPymtYn */
        listColumnDefs.add(new ColumnDef("지급여부", Payr0530BM.ATTR_FAMYALLWPYMTYN, ColumnDef.TYPE_BOOLEAN, 70, false, true, true){
        	{

        	}
        });
        sysComBass0300Dto.setRpsttvCd("B026"); 
        /** column 가족수당구분코드 : famyExtpyDivCd */
        listColumnDefs.add(new ColumnListDef("수당구분", Payr0530BM.ATTR_FAMYEXTPYDIVCD, ColumnDef.TYPE_STRING, 80, false, false, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
            {

            }
        }); 
        /** column 가족수당 : famyExtpyDivNm */
        listColumnDefs.add(new ColumnDef("가족수당", Payr0530BM.ATTR_FAMYEXTPYDIVNM, ColumnDef.TYPE_STRING, 80, false, true, true){
            {

            }
        });
        /** column 가족수당금액 : famyExtpySum */
        listColumnDefs.add(new ColumnDef("가족수당금액", Payr0530BM.ATTR_FAMYEXTPYSUM, ColumnDef.TYPE_LONG, 90, false, true, true){
            {
                //setReadOnly(true);
            }
        });
        
        return listColumnDefs; 
    }

public List<ColumnDef> getPayr0530Def() {
  
          
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Payr0530BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column SYSTEMKEY : systemkey */
        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Payr0530BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 급여가족사항일련번호 : payFamyRsptSeilNum */
        listColumnDefs.add(new ColumnDef("번호", Payr0530BM.ATTR_PAYFAMYRSPTSEILNUM, ColumnDef.TYPE_LONG, 90, false, false, true){
        	{

        	}
        });
        sysComBass0300Dto.setRpsttvCd("A019"); 
        /** column 가족관계구분코드 : famyRelaDivCd */
        listColumnDefs.add(new ColumnListDef("가족관계", Payr0530BM.ATTR_FAMYRELADIVCD, ColumnDef.TYPE_STRING, 60, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
            {
                setReadOnly(true);
            }
        });
        /** column 가족관계 : famyRelaDivNm */
        listColumnDefs.add(new ColumnDef("가족관계", Payr0530BM.ATTR_FAMYRELADIVNM, ColumnDef.TYPE_STRING, 60, false, false, true){
            {
                setReadOnly(true);
            }
        });
        /** column 한글성명 : hanNm */
        listColumnDefs.add(new ColumnDef("성명", Payr0530BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 50, false, true, true){
            {
                setReadOnly(true);
            }
        });
        /** column 급여가족주민번호 : payFamyResnRegnNum */
        listColumnDefs.add(new ColumnDef("주민번호", Payr0530BM.ATTR_PAYFAMYRESNREGNNUM, ColumnDef.TYPE_STRING, 70, false, true, true){
        	{
        	    setReadOnly(true);
        	}
        });
        /** column 급여가족주민번호 : famySecRegnNum */
        listColumnDefs.add(new ColumnDef("주민번호", Payr0530BM.ATTR_FAMYSECREGNNUM, ColumnDef.TYPE_STRING, 0, false, false, false){
        	{
        	    setReadOnly(true);
        	}
        });
        /** column 가족수당지급여부 : famyAllwPymtYn */
        listColumnDefs.add(new ColumnDef("수당", Payr0530BM.ATTR_FAMYALLWPYMTYN, ColumnDef.TYPE_BOOLEAN, 50, false, true, true){
        	{

        	}
        });
        sysComBass0300Dto.setRpsttvCd("B026"); 
        /** column 가족수당구분코드 : famyExtpyDivCd */
        listColumnDefs.add(new ColumnListDef("수당구분", Payr0530BM.ATTR_FAMYEXTPYDIVCD, ColumnDef.TYPE_STRING, 80, false, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
            {

            }
        }); 
        /** column 가족수당 : famyExtpyDivNm */
        listColumnDefs.add(new ColumnDef("가족수당", Payr0530BM.ATTR_FAMYEXTPYDIVNM, ColumnDef.TYPE_STRING, 80, false, false, true){
            {

            }
        });
        /** column 가족수당금액 : famyExtpySum */
        listColumnDefs.add(new ColumnDef("가족수당금액", Payr0530BM.ATTR_FAMYEXTPYSUM, ColumnDef.TYPE_LONG, 90, false, true, true){
            {
                //setReadOnly(true);
            }
        });
        
        sysComBass0300Dto.setRpsttvCd("B020"); 
        /** column 학비보조수당구분코드 : schlExpnAdmclExtpyDivCd */
        listColumnDefs.add(new ColumnListDef("학비보조구분", Payr0530BM.ATTR_SCHLEXPNADMCLEXTPYDIVCD, ColumnDef.TYPE_STRING, 110, false, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
            {

            }
        });
        /** column 학비보조수당 : schlExpnAdmclExtpyDivNm */
        listColumnDefs.add(new ColumnDef("학비보조수당", Payr0530BM.ATTR_SCHLEXPNADMCLEXTPYDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
            {

            }
        });
        /** column 학비보조수당금액 : schlExpnAdmclExtpySum */
        listColumnDefs.add(new ColumnDef("학비보조금액", Payr0530BM.ATTR_SCHLEXPNADMCLEXTPYSUM, ColumnDef.TYPE_LONG, 90, false, true, true){
            {
              // setReadOnly(true);
            }
        });
      
        /** column 학비수당지급시작일자 : schlExpnExtpyPymtBgnnDt */
        listColumnDefs.add(new ColumnDef("시작일자", Payr0530BM.ATTR_SCHLEXPNEXTPYPYMTBGNNDT, ColumnDef.TYPE_DATE, 80, false, true, true){
            {
                setMaxLength(10);
        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
        		setDtFieldMask("9999.99.99");
            }
        });
        /** column 학비수당지급종료일자 : schlExpnExtpyPymtEndDt */
        listColumnDefs.add(new ColumnDef("종료일자", Payr0530BM.ATTR_SCHLEXPNEXTPYPYMTENDDT, ColumnDef.TYPE_DATE, 80, false, true, true){
            {
                setMaxLength(10);
        		setFormatDate(DateTimeFormat.getFormat("yyyy.MM.dd"));  
        		setDtFieldMask("9999.99.99");
            }
        });
        /** column 자녀양육비지급여부 : chdnChdRrgEpnsPymtYn */
        listColumnDefs.add(new ColumnDef("양육비지급", Payr0530BM.ATTR_CHDNCHDRRGEPNSPYMTYN, ColumnDef.TYPE_BOOLEAN, 60, false, false, true){
            {

            }
        });
        /** column 기본공제여부 : fndtnDducYn */
        listColumnDefs.add(new ColumnDef("기본공제", Payr0530BM.ATTR_FNDTNDDUCYN, ColumnDef.TYPE_BOOLEAN, 50, false, true, true){
        	{

        	}
        });
        /** column 배우자공제여부 : spueDducYn */
        listColumnDefs.add(new ColumnDef("배우자", Payr0530BM.ATTR_SPUEDDUCYN, ColumnDef.TYPE_BOOLEAN, 50, false, true, true){
        	{

        	}
        });
        /** column 부녀자공제여부 : wmnDducYn */
        listColumnDefs.add(new ColumnDef("부녀자", Payr0530BM.ATTR_WMNDDUCYN, ColumnDef.TYPE_BOOLEAN, 50, false, true, true){
        	{

        	}
        });
        /** column 경로우대공제여부 : rftaGvstDducYn */
        listColumnDefs.add(new ColumnDef("경로우대", Payr0530BM.ATTR_RFTAGVSTDDUCYN, ColumnDef.TYPE_BOOLEAN, 50, false, true, true){
        	{

        	}
        });
      
        /** column 장애자공제여부 : dabpnDducYn */
        listColumnDefs.add(new ColumnDef("장애자", Payr0530BM.ATTR_DABPNDDUCYN, ColumnDef.TYPE_BOOLEAN, 50, false, true, true){
        	{

        	}
        });
        /** column 한가족공제여부 : sgpnFmlyDducYn */
        listColumnDefs.add(new ColumnDef("한가족", Payr0530BM.ATTR_SGPNFMLYDDUCYN, ColumnDef.TYPE_BOOLEAN, 50, false, true, true){
        	{

        	}
        });
        /** column 자녀양육비공제여부 : chdnChdRrgEpnsDducYn */
        listColumnDefs.add(new ColumnDef("자녀양육비", Payr0530BM.ATTR_CHDNCHDRRGEPNSDDUCYN, ColumnDef.TYPE_BOOLEAN, 60, false, true, true){
        	{

        	}
        });
       
     
        
        return listColumnDefs; 
    }
}
