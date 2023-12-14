/**
 * 공통화면 팝업 
 */
package com.app.exterms.basis.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.basis.client.dto.Bass5540BM;
import com.app.exterms.basis.client.dto.Payr0480BM;
import com.app.exterms.basis.client.languages.BasisConstants;
import com.app.exterms.basis.shared.BasisDaoConstants;
import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Bass5540Def  extends TableDef implements BasisDaoConstants {

    private int row = 0;
    private BasisConstants bassLabel = BasisConstants.INSTANCE;

    final PrgmComBass0300DTO sysComBass0300Dto;
    
    public Bass5540Def(){
        this("");
    }
    
    public Bass5540Def(String chkPayrDef){
    	
    	setTitle(bassLabel.titleBass5540());
    	  sysComBass0300Dto = new PrgmComBass0300DTO(); 
    	  
        if ("".equals(chkPayrDef)) { 
        	 
        	 setDaoClass(CLASS_BASS5540_DATA_LIST);
             setCustomListMethod(CLASS_BASS5540_DATA_LIST);
             setAutoFillGrid(true);
             setShowFilterToolbar(false);
            // setCustomListMethod(SysConfiguration.CUSTOM_SERVICE_SKIP_CALL);
             setCheckBoxOnGridRows(true);
             setEditFieldGrid(true);

            setColumnsDefinition(getPayr0470Def());
             
        } else if ("PAYR4450".equals(chkPayrDef)) {  
        	
        	 setDaoClass(CLASS_BASS5540TOPAYR4450_DATA_LIST);
             setCustomListMethod(CLASS_BASS5540TOPAYR4450_DATA_LIST);
             setAutoFillGrid(true);
             setShowFilterToolbar(false); 
             setCheckBoxOnGridRows(true); 

             setColumnsDefinition(getPayr0470ToPayr4450Def());
     
        } else if ("PAYR1450".equals(chkPayrDef)) {  
       	 	setDaoClass(CLASS_BASS5540TO0485_DATA_LIST);
            setCustomListMethod(CLASS_BASS5540TO0485_DATA_LIST);
            setAutoFillGrid(true);
            setShowFilterToolbar(false); 
            setCheckBoxOnGridRows(true); 

            setColumnsDefinition(getPayr0470ToPayr0485Def());
    
       }   
    }
    
    public List<ColumnDef> getPayr0470ToPayr4450Def(){
        
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Bass5540BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, true, false, true){
        	{

        	}
        }); 
        /** column 급여공제코드 : payDducCd */
        listColumnDefs.add(new ColumnDef("공제코드", Bass5540BM.ATTR_PAYDDUCCD, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        });
       
        /** column 급여공제명 : payDducNm */
        listColumnDefs.add(new ColumnDef("공제명", Bass5540BM.ATTR_PAYDDUCNM, ColumnDef.TYPE_STRING, 90, true, true, true){
        	{

        	}
        }); 
        return listColumnDefs;
    }
    
    public List<ColumnDef> getPayr0470Def(){
        
       
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Bass5540BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        
        sysComBass0300Dto.setRpsttvCd("B008"); 
        sysComBass0300Dto.setMangeItem02("N");
        /** column 지급공제구분 : pymtDducDivCd */
        listColumnDefs.add(new ColumnListDef("지급공제", Bass5540BM.ATTR_PYMTDDUCDIVCD, ColumnDef.TYPE_STRING , 90, false, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
            {

            }
        });
        sysComBass0300Dto.setMangeItem02("");
        /** column 지급공제구분 : pymtDducDivCd */
        listColumnDefs.add(new ColumnDef("지급공제", Bass5540BM.ATTR_PYMTDDUCDIVNM, ColumnDef.TYPE_STRING , 90, false, false, true){
            {

            }
        });
        
//        sysComBass0300Dto.setRpsttvCd("B025");
//        sysComBass0300Dto.setMangeItem01("D");
//        /** column 급여공제그룹코드 : payDducGrpCd */
//        listColumnDefs.add(new ColumnListDef("공제그룹", Payr0470BM.ATTR_PAYDDUCGRPCD, ColumnDef.TYPE_STRING, 90, false, true, true ,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
//        	{
//
//        	}
//        });
        
        sysComBass0300Dto.setRpsttvCd("B008");
        sysComBass0300Dto.setMangeItem01("D");
        /** column 급여공제그룹코드 : payDducGrpCd */
        listColumnDefs.add(new ColumnListDef("공제그룹", Bass5540BM.ATTR_PAYDDUCGRPCD, ColumnDef.TYPE_STRING, 90, false, true, true ,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{

        	}
        });
        
        /** column 급여공제그룹 : payDducGrpNm */
        listColumnDefs.add(new ColumnDef("급여공제그룹", Bass5540BM.ATTR_PAYDDUCGRPNM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 급여공제코드 : payDducCd */
        listColumnDefs.add(new ColumnDef("공제코드", Bass5540BM.ATTR_PAYDDUCCD, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{

        	}
        });
       
        /** column 급여공제명 : payDducNm */
        listColumnDefs.add(new ColumnDef("공제명", Bass5540BM.ATTR_PAYDDUCNM, ColumnDef.TYPE_STRING, 90, false, true, true){
        	{

        	}
        });
        /** column 기간제공제사용여부 : payrTermDducYn */
        listColumnDefs.add(new ColumnDef("기간제", Bass5540BM.ATTR_PAYRTERMDDUCYN, ColumnDef.TYPE_BOOLEAN , 60, false, true, true){
        	{

        	}
        });
        /** column 급여공제사용여부 : payDducUseYn */
        listColumnDefs.add(new ColumnDef("사용", Bass5540BM.ATTR_PAYDDUCUSEYN, ColumnDef.TYPE_BOOLEAN, 50, false, true, true){
        	{

        	}
        });
        /** column 급여공제금액 : payDducSum */
        listColumnDefs.add(new ColumnDef("급여공제금액", Bass5540BM.ATTR_PAYDDUCSUM, ColumnDef.TYPE_LONG, 120, false, true, true){
        	{

        	}
        });
        /** column 급여공제비율 : payDducRto */
        listColumnDefs.add(new ColumnDef("급여공제비율", Bass5540BM.ATTR_PAYDDUCRTO, ColumnDef.TYPE_DOUBLE, 90, false, true, true){
        	{

        	}
        });
        sysComBass0300Dto.setRpsttvCd("B023");
        sysComBass0300Dto.setMangeItem01("");
        /** column 연말정산_공제구분코드 : yrtxDducDivCd */
        listColumnDefs.add(new ColumnListDef("연말정산공제", Bass5540BM.ATTR_YRTXDDUCDIVCD, ColumnDef.TYPE_STRING, 120, false, true, true ,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{

        	}
        });
        /** column 연말정산_공제구분코드 : yrtxDducDivNm */
        listColumnDefs.add(new ColumnDef("연말정산공제", Bass5540BM.ATTR_YRTXDDUCDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        sysComBass0300Dto.setRpsttvCd("B024");
        sysComBass0300Dto.setMangeItem01("");
        /** column 그룹적용구분코드 : grpApptnDivCd */
        listColumnDefs.add(new ColumnListDef("그룹적용", Bass5540BM.ATTR_GRPAPPTNDIVCD, ColumnDef.TYPE_STRING, 90, false, true, true ,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
        	{

        	}
        });
        /** column 그룹적용구분 : grpApptnDivNm */
        listColumnDefs.add(new ColumnDef("그룹적용구분", Bass5540BM.ATTR_GRPAPPTNDIVNM, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 급여공제시작일자 : payDducBgnnDt */
        listColumnDefs.add(new ColumnDef("시작일자", Bass5540BM.ATTR_PAYDDUCBGNNDT, ColumnDef.TYPE_DATE, 90, false, true, true){
        	{

        	}
        });
        /** column 급여공제종료일자 : payDducEndDt */
        listColumnDefs.add(new ColumnDef("종료일자", Bass5540BM.ATTR_PAYDDUCENDDT, ColumnDef.TYPE_DATE, 90, false, true, true){
        	{

        	}
        });
        return listColumnDefs;
    }
//        /** column 입력자 : kybdr */
//        listColumnDefs.add(new ColumnDef("입력자", Payr0470BM.ATTR_KYBDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력일자 : inptDt */
//        listColumnDefs.add(new ColumnDef("입력일자", Payr0470BM.ATTR_INPTDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 입력주소 : inptAddr */
//        listColumnDefs.add(new ColumnDef("입력주소", Payr0470BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정자 : ismt */
//        listColumnDefs.add(new ColumnDef("수정자", Payr0470BM.ATTR_ISMT, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정일자 : revnDt */
//        listColumnDefs.add(new ColumnDef("수정일자", Payr0470BM.ATTR_REVNDT, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
//        /** column 수정주소 : revnAddr */
//        listColumnDefs.add(new ColumnDef("수정주소", Payr0470BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING, 90, true, false, true){
//        	{
//
//        	}
//        });
        
        public List<ColumnDef> getPayr0470ToPayr0485Def(){
            
            
            List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 

            /** column 사업장코드 : dpobCd */
            listColumnDefs.add(new ColumnDef("사업장코드", Bass5540BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, false, false, true){
            	{

            	}
            });
            
            /** column 급여공제그룹 : payExtpyGrpCd */
            listColumnDefs.add(new ColumnDef("수당그룹", Bass5540BM.ATTR_PAYEXTPYGRPCD, ColumnDef.TYPE_STRING, 90, false, false, true){
            	{

            	}
            });
            
            sysComBass0300Dto.setRpsttvCd("A002");
            //sysComBass0300Dto.setMangeItem01("D");
            /** column 고용구분코드 : emymtDivCd */
            listColumnDefs.add(new ColumnListDef("고용구분코드", Bass5540BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING, 90, false, false, true ,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
            	{

            	}
            });
            
//            sysComBass0300Dto.setMangeItem01("D");
//            /** column 급여공제그룹코드 : payDducGrpCd */
//            listColumnDefs.add(new ColumnListDef("지급공제구분", Payr0470BM.ATTR_PAYDDUCGRPCD, ColumnDef.TYPE_STRING, 90, false, true, true ,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
//            	{
//
//            	}
//            });
            
            /** column 지급공제 : payDducGrpNm */
            listColumnDefs.add(new ColumnDef("지급공제", Bass5540BM.ATTR_PAYDDUCGRPNM, ColumnDef.TYPE_STRING, 90, false, false, true){
            	{

            	}
            });
            
            /** column 지급공제 : payDducGrpNm */
            listColumnDefs.add(new ColumnDef("지급공제", Bass5540BM.ATTR_PYMTDDUCDIVNM, ColumnDef.TYPE_STRING, 90, false, true, true){
            	{

            	}
            });
            
            
            
//            sysComBass0300Dto.setRpsttvCd("B025");
//            sysComBass0300Dto.setMangeItem01("C");
//            /** column 급여수당그룹명 : payExtpyGrpNm */
//            listColumnDefs.add(new ColumnListDef("그룹", Payr0480BM.ATTR_PAYEXTPYGRPNM, ColumnDef.TYPE_STRING, 90, false, true, true ,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
//            	{
//            	   
//            	}
//            });
            /** column 급여수당그룹명 : payExtpyGrpNm */
            listColumnDefs.add(new ColumnDef("그룹", Payr0480BM.ATTR_PAYEXTPYGRPNM, ColumnDef.TYPE_STRING, 90, false, true, true){
            	{

            	}
            });
            /** column 급여공제코드 : payDducCd */
            listColumnDefs.add(new ColumnDef("코드", Bass5540BM.ATTR_PAYDDUCCD, ColumnDef.TYPE_STRING, 90, false, true, true){
            	{

            	}
            });
           
            /** column 급여공제명 : payDducNm */
            listColumnDefs.add(new ColumnDef("항목", Bass5540BM.ATTR_PAYDDUCNM, ColumnDef.TYPE_STRING, 90, false, true, true){
            	{

            	}
            });
            /** column 급여공제사용여부 : payDducUseYn */
            listColumnDefs.add(new ColumnDef("사용", Bass5540BM.ATTR_PAYDDUCUSEYN, ColumnDef.TYPE_BOOLEAN, 50, false, true, true){
            	{

            	}
            });
            /** set 퇴직적용여부 : sevePayYn */
            listColumnDefs.add(new ColumnDef("퇴직적용", Bass5540BM.ATTR_SEVEPAYYN, ColumnDef.TYPE_STRING, 50, false, false, true){
            	{

            	}
            });
            /** set 회계계정코드 : accAccCd */
            listColumnDefs.add(new ColumnDef("회계계정", Bass5540BM.ATTR_ACCACCCD, ColumnDef.TYPE_STRING, 50, false, false, true){
            	{

            	}
            });
            /** set 연말정산_비과세감면코드 : yrtxFreeDtyReduCd */
            listColumnDefs.add(new ColumnDef("비과세감면", Bass5540BM.ATTR_YRTXFREEDTYREDUCD, ColumnDef.TYPE_STRING, 50, false, false, true){
            	{

            	}
            });

        return listColumnDefs;
    }
}
