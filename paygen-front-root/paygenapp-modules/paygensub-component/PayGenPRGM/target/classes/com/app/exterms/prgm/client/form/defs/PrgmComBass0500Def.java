/**
 * 공통화면 팝업 
 */
package com.app.exterms.prgm.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0500BM;
import com.app.exterms.prgm.client.languages.PrgmConstants;
import com.app.exterms.prgm.shared.PrgmComDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.AttributeCustomForm;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class PrgmComBass0500Def  extends TableDef implements PrgmComDaoConstants {

    private int row = 0;
    private PrgmConstants SysComLabel = PrgmConstants.INSTANCE;

    public PrgmComBass0500Def(String chkDef){
        
       if ("PAYR5300".equals(chkDef)) {
            
           setTitle(SysComLabel.titleSysComPopUpBass0500());
           setDaoClass(CLASS_SYSCOM_BASS0500VO);
           setCustomListMethod(CLASS_BASS0500_PAYR5300_DATA_LIST);
           setAutoFillGrid(true); 
           setShowFilterToolbar(false);
             
            setColumnsDefinition(getBass0500ToPayr5300());
        } else {
            
            setTitle(SysComLabel.titleSysComPopUpBass0500());
            setDaoClass(CLASS_SYSCOM_BASS0500VO);
            setCustomListMethod(CLASS_SYSCOM_BASS0500VO);
            setAutoFillGrid(false); 
            setShowFilterToolbar(false);
             
            setColumnsDefinition(getBass0500());
        }    
    }
       
       public List<ColumnDef> getBass0500ToPayr5300(){         
        
            List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
              
            listColumnDefs.add(new ColumnDef("사업장코드", PrgmComBass0500BM.ATTR_DPOBCD,  ColumnDef.TYPE_STRING, 100, false, false, true){
                {
                    setAttributeCustomForm(new AttributeCustomForm(0, row));
                }
            });
            /** BUSIN_APPTN_YR */
            listColumnDefs.add(new ColumnDef("년도", PrgmComBass0500BM.ATTR_BUSINAPPTNYR, ColumnDef.TYPE_STRING, 60, false, true, true){
                {
                    setAttributeCustomForm(new AttributeCustomForm(1, row++, 100));
                }
            });
            /** DEPT_CD */
            listColumnDefs.add(new ColumnDef("부서코드", PrgmComBass0500BM.ATTR_DEPTCD,  ColumnDef.TYPE_STRING, 80, false, false, true){
                {
                    setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
                }
            }); 
            
            /** DEPT_NM_HAN == deptNmHan*/
            listColumnDefs.add(new ColumnDef("부서", PrgmComBass0500BM.ATTR_DEPTNM,   ColumnDef.TYPE_STRING, 90, false, true, true){
                {
                    setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
                }
            });
           
            /** BUSIN_CD == businCd*/
            listColumnDefs.add(new ColumnDef("사업코드", PrgmComBass0500BM.ATTR_BUSINCD,   ColumnDef.TYPE_STRING, 80, false, false, true){
                {
                    setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
                }
            });
            /** BUSIN_NM  == businNm*/
            listColumnDefs.add(new ColumnDef("사업", PrgmComBass0500BM.ATTR_BUSINNM,   ColumnDef.TYPE_STRING, 120, false, true, true){
                {
                    setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
                }
            });
            /** EMYMT_TYP_OCCU_CD == emymtTypOccuCd*/
            listColumnDefs.add(new ColumnDef("사업고용직종코드", PrgmComBass0500BM.ATTR_EMYMTTYPOCCUCD,   ColumnDef.TYPE_STRING, 80, false, false, true){
                {
                    setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
                }
            });
            /** EMYMT_TYP_OCCU_NM == emymtTypOccuNm*/
            listColumnDefs.add(new ColumnDef("고용직종", PrgmComBass0500BM.ATTR_EMYMTTYPOCCUNM,   ColumnDef.TYPE_STRING, 80, false, true, true){
                {
                    setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
                }
            });
            /** BUSIN_REPBTY_EMP_NUM == businRepbtyEmpNum*/
            listColumnDefs.add(new ColumnDef("사업담당직원번호", PrgmComBass0500BM.ATTR_BUSINREPBTYEMPNUM,   ColumnDef.TYPE_STRING, 80, false, false, true){
                {
                    setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
                }
            });
            /** IDTL_ACCDT_INSUR_APMRT = idtlAccdtInsurApmrt */
            listColumnDefs.add(new ColumnDef("산재보험요율", PrgmComBass0500BM.ATTR_IDTLACCDTINSURAPMRT,   ColumnDef.TYPE_DOUBLE, 80, false, false, true){
                {
                    setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
                }
            });
            /** SPITY_CTNT */
            listColumnDefs.add(new ColumnDef("특기사항", PrgmComBass0500BM.ATTR_SPITYCTNT,   ColumnDef.TYPE_STRING, 80, false, false, true){
                {
                    setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
                }
            });
            /** NAT_PENN_SYM */
            listColumnDefs.add(new ColumnDef("국민연금기호", PrgmComBass0500BM.ATTR_NATPENNSYM,   ColumnDef.TYPE_STRING, 80, false, false, true){
                {
                    setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
                }
            });
            /** HLTH_INSR_SYM */
            listColumnDefs.add(new ColumnDef("건강보험기호", PrgmComBass0500BM.ATTR_HLTHINSRSYM,   ColumnDef.TYPE_STRING, 80, false, false, true){
                {
                    setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
                }
            });
            /** UMYT_INSR_SYM */
            listColumnDefs.add(new ColumnDef("고용보험기호", PrgmComBass0500BM.ATTR_UMYTINSRSYM,   ColumnDef.TYPE_STRING, 80, false, false, true){
                {
                    setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
                }
            });
            /** IDTL_ACCDT_INSUR_SYM */
            listColumnDefs.add(new ColumnDef("산재보험기호", PrgmComBass0500BM.ATTR_IDTLACCDTINSURSYM,   ColumnDef.TYPE_STRING, 80, false, false, true){
                {
                    setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
                }
            });
            
            /** column 사업기간시작일자 : businStdt */
            listColumnDefs.add(new ColumnDef("시작일자", PrgmComBass0500BM.ATTR_BUSINSTDT, ColumnDef.TYPE_DATE , 90, false, false, true){
                {

                }
            });
            /** column 사업기간종료일자 : businEddt */
            listColumnDefs.add(new ColumnDef("종료일자", PrgmComBass0500BM.ATTR_BUSINEDDT, ColumnDef.TYPE_DATE , 90, false, false, true){
                {

                }
            });
            
           return  listColumnDefs;
    }
       
  public List<ColumnDef> getBass0500(){         
           
           List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
             
           listColumnDefs.add(new ColumnDef("사업장코드", PrgmComBass0500BM.ATTR_DPOBCD,  ColumnDef.TYPE_STRING, 100, false, false, true){
               {
                   setAttributeCustomForm(new AttributeCustomForm(0, row));
               }
           });
           /** BUSIN_APPTN_YR */
           listColumnDefs.add(new ColumnDef("사업년도", PrgmComBass0500BM.ATTR_BUSINAPPTNYR, ColumnDef.TYPE_STRING, 80, false, true, true){
               {
                   setAttributeCustomForm(new AttributeCustomForm(1, row++, 100));
               }
           });
           /** DEPT_CD */
           listColumnDefs.add(new ColumnDef("부서코드", PrgmComBass0500BM.ATTR_DEPTCD,  ColumnDef.TYPE_STRING, 80, false, true, true){
               {
                   setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
               }
           }); 
           
           /** DEPT_NM == deptNm*/
           listColumnDefs.add(new ColumnDef("부서명", PrgmComBass0500BM.ATTR_DEPTNM,   ColumnDef.TYPE_STRING, 80, false, false, true){
               {
                   setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
               }
           });
          
           /** BUSIN_CD == businCd*/
           listColumnDefs.add(new ColumnDef("사업코드", PrgmComBass0500BM.ATTR_BUSINCD,   ColumnDef.TYPE_STRING, 80, false, true, true){
               {
                   setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
               }
           });
           /** BUSIN_NM  == businNm*/
           listColumnDefs.add(new ColumnDef("사업명", PrgmComBass0500BM.ATTR_BUSINNM,   ColumnDef.TYPE_STRING, 80, false, true, true){
               {
                   setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
               }
           });
           /** EMYMT_TYP_OCCU_CD == emymtTypOccuCd*/
           listColumnDefs.add(new ColumnDef("사업고용직종코드", PrgmComBass0500BM.ATTR_EMYMTTYPOCCUCD,   ColumnDef.TYPE_STRING, 80, false, true, true){
               {
                   setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
               }
           });
           /** EMYMT_TYP_OCCU_NM == emymtTypOccuNm*/
           listColumnDefs.add(new ColumnDef("사업고용직종명", PrgmComBass0500BM.ATTR_EMYMTTYPOCCUNM,   ColumnDef.TYPE_STRING, 80, false, true, true){
               {
                   setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
               }
           });
           /** BUSIN_REPBTY_EMP_NUM == businRepbtyEmpNum*/
           listColumnDefs.add(new ColumnDef("사업담당직원번호", PrgmComBass0500BM.ATTR_BUSINREPBTYEMPNUM,   ColumnDef.TYPE_STRING, 80, false, false, true){
               {
                   setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
               }
           });
           /** IDTL_ACCDT_INSUR_APMRT = idtlAccdtInsurApmrt */
           listColumnDefs.add(new ColumnDef("산재보험요율", PrgmComBass0500BM.ATTR_IDTLACCDTINSURAPMRT,   ColumnDef.TYPE_DOUBLE, 80, false, false, true){
               {
                   setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
               }
           });
           /** SPITY_CTNT */
           listColumnDefs.add(new ColumnDef("특기사항", PrgmComBass0500BM.ATTR_SPITYCTNT,   ColumnDef.TYPE_STRING, 80, false, false, true){
               {
                   setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
               }
           });
           /** NAT_PENN_SYM */
           listColumnDefs.add(new ColumnDef("국민연금기호", PrgmComBass0500BM.ATTR_NATPENNSYM,   ColumnDef.TYPE_STRING, 80, false, false, true){
               {
                   setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
               }
           });
           /** HLTH_INSR_SYM */
           listColumnDefs.add(new ColumnDef("건강보험기호", PrgmComBass0500BM.ATTR_HLTHINSRSYM,   ColumnDef.TYPE_STRING, 80, false, false, true){
               {
                   setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
               }
           });
           /** UMYT_INSR_SYM */
           listColumnDefs.add(new ColumnDef("고용보험기호", PrgmComBass0500BM.ATTR_UMYTINSRSYM,   ColumnDef.TYPE_STRING, 80, false, false, true){
               {
                   setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
               }
           });
           /** IDTL_ACCDT_INSUR_SYM */
           listColumnDefs.add(new ColumnDef("산재보험기호", PrgmComBass0500BM.ATTR_IDTLACCDTINSURSYM,   ColumnDef.TYPE_STRING, 80, false, false, true){
               {
                   setAttributeCustomForm(new AttributeCustomForm(1, row++, 10));
               }
           });
           /** column 사업기간시작일자 : businStdt */
           listColumnDefs.add(new ColumnDef("사업기간시작일자", PrgmComBass0500BM.ATTR_BUSINSTDT, ColumnDef.TYPE_DATE , 90, false, false, true){
               {

               }
           });
           /** column 사업기간종료일자 : businEddt */
           listColumnDefs.add(new ColumnDef("사업기간종료일자", PrgmComBass0500BM.ATTR_BUSINEDDT, ColumnDef.TYPE_DATE , 90, false, false, true){
               {

               }
           });
           
          return  listColumnDefs;
   }
}
