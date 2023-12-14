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

import com.app.exterms.basis.client.dto.Bass0350BM;
import com.app.exterms.basis.client.languages.BasisConstants;
import com.app.exterms.basis.shared.BasisDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

public class Bass0350Def extends TableDef implements BasisDaoConstants {
    private int row = 0;
    
    private BasisConstants lblBasisConst = BasisConstants.INSTANCE;
    
    public Bass0350Def(){
    	
    	  setTitle(lblBasisConst.title_Bass0350());
          setDaoClass(""); 
          setCustomListMethod(CLASS_BASS0350_LIST);
          
    	  setColumnsDefinition(getAllColumnsList()); 
    	  setAutoFillGrid(true);
          setShowFilterToolbar(false);  
    }
    
    public Bass0350Def(String chkDef){
    	if ("BASS0350_BEF".equals(chkDef)) {
	        setTitle("");
	        setDaoClass("");
	        setCustomListMethod(CLASS_BASS0350_LIST);
	        
	        setAutoFillGrid(false);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
	        setEditFieldGrid(true);
//	        setCellModel(true);
	        
	        setColumnsDefinition(getBass0350List());  
	      
    	}else if ("BASS0350_CRE".equals(chkDef)) {
	        setTitle("");
	        setDaoClass("");
	        setCustomListMethod(CLASS_BASS0350_LIST);
	        
	        setAutoFillGrid(false);
	        setShowFilterToolbar(false);
	        setCheckBoxOnGridRows(true);
	        setEditFieldGrid(false);
//	        setCellModel(true);
	       
	        setColumnsDefinition(getBass0350List());
	        
    	}
    }
       
    private List<ColumnDef> getAllColumnsList(){
        row = 0;
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();
        
        
        /** column 직종세코드 : dtilOccuClsDivCd */
        listColumnDefs.add(new ColumnDef("직종세코드", Bass0350BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING, 100, true, false, true){
        	{

        	}
        });
   
        
        /** column 직종세통합코드 : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세코드", Bass0350BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING, 100, true, true, true){
        	{
        			
        	}
        });     

        /** column 사업장코드 : dpobCd */
        listColumnDefs.add(new ColumnDef("사업장코드", Bass0350BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING, 90, false, false, true){
        	{

        	}
        });
        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종코드", Bass0350BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING, 100, false, false, true){
        	{

        	}
        });
        
        listColumnDefs.add(new ColumnDef("직종명", Bass0350BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 100, true, true, true){
        	{

        	}
        });
        
        listColumnDefs.add(new ColumnDef("등급코드", Bass0350BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING, 100, true, false, true){
        	{

        	}
        });
        
        listColumnDefs.add(new ColumnDef("등급", Bass0350BM.ATTR_PYSPGRDENM, ColumnDef.TYPE_STRING, 100, true, true, true){
            {

            }
        });
        
        /** column 직종세명 : dtilOccuClsNm */
        listColumnDefs.add(new ColumnDef("직종세명", Bass0350BM.ATTR_DTILOCCUCLSNM, ColumnDef.TYPE_STRING, 100, true, true, true){
        	{

        	}
        });
        
        /** column 직종세직군구분코드 : dtilOccuJbfmlDivCd */
        listColumnDefs.add(new ColumnDef("직종세직군구분코드", Bass0350BM.ATTR_DTILOCCUJBFMLDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
            {

            }
        });
        
        /** column 직군 : dtilOccuJbfmlDivNm */
        listColumnDefs.add(new ColumnDef("직군", Bass0350BM.ATTR_DTILOCCUJBFMLDIVNM, ColumnDef.TYPE_STRING, 70, false, true, true){
     	   {
        	 
        	  } 
        }); 
        /** set 최대근속년수코드 : bggLogSvcYrNumNm */ 
        listColumnDefs.add(new ColumnDef("년수", Bass0350BM.ATTR_BGGLOGSVCYRNUMNM, ColumnDef.TYPE_STRING , 90, true, false, true){
            {

            }
        });
        
        /** column 직종세내용 : dtilOccuClsCtnt */
        listColumnDefs.add(new ColumnDef("직종세내용", Bass0350BM.ATTR_DTILOCCUCLSCTNT, ColumnDef.TYPE_STRING, 150, false, true, true){
        	{

        	}
        });
        /** column 개편직종코드 : chngTypOccuCd */
		listColumnDefs.add(new ColumnDef("개편직종코드", Bass0350BM.ATTR_CHNGTYPOCCUCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** column 개편직종세코드 : chngDtilOccuInttnCd */
		listColumnDefs.add(new ColumnDef("개편직종세코드", Bass0350BM.ATTR_CHNGDTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});        
        /** column 정렬순서 : dtilOccuClsOrd */
        listColumnDefs.add(new ColumnDef("순서", Bass0350BM.ATTR_DTILOCCUCLSORD, ColumnDef.TYPE_BIGDECIMAL, 60, false, true, true){
        	{

        	}
        });
        /** column 직종세사용여부 : dtilOccuClsUseYn */
        listColumnDefs.add(new ColumnDef("사용여부", Bass0350BM.ATTR_DTILOCCUCLSUSEYN, ColumnDef.TYPE_BOOLEAN, 60, true, true, true){
        	{

        	}
        });
        /** column 전환대상여부 : chngTgtYn */
        listColumnDefs.add(new ColumnDef("전환대상", Bass0350BM.ATTR_CHNGTGTYN, ColumnDef.TYPE_BOOLEAN, 60, false, true, true){
        	{

        	}
        }); 
        
        
        /** column 직종세통합코드 : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세통합코드", Bass0350BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, false, false, false){
            {

            }
        });
      
        
        /** column 직종코드 : typOccuCd */
        listColumnDefs.add(new ColumnDef("직종", Bass0350BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING, 90, true, false, false){
            {

            }
        });
        /** set 최대근속년수코드 : bggLogSvcYrNumCd */ 
        listColumnDefs.add(new ColumnDef("최대근속년수코드", Bass0350BM.ATTR_BGGLOGSVCYRNUMCD, ColumnDef.TYPE_STRING , 90, true, false, true){
            {

            }
        });
    	/** column 직종세적용단가구분코드 : dtilOcclsApptnUcstCd */
		listColumnDefs.add(new ColumnDef("직종세적용단가구분코드", Bass0350BM.ATTR_DTILOCCLSAPPTNUCSTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		
		/** column 직종세적용단가금액 : dtilOcclsApptnUcstSum */
		listColumnDefs.add(new ColumnDef("단가금액", Bass0350BM.ATTR_DTILOCCLSAPPTNUCSTSUM, ColumnDef.TYPE_LONG , 90, true, true, true){
			{

			}
		});		
		/** column 직종세시작일자 : dtilOccuInttnStdt */
		listColumnDefs.add(new ColumnDef("시작일자", Bass0350BM.ATTR_DTILOCCUINTTNSTDT, ColumnDef.TYPE_STRING , 90, true, true, true){
			{

			}
		});
		/** column 직종세종료일자 : dtilOccuInttnEddt */
		listColumnDefs.add(new ColumnDef("종료일자", Bass0350BM.ATTR_DTILOCCUINTTNEDDT, ColumnDef.TYPE_STRING , 90, true, true, true){
			{

			}
		});
		/** set 직종세회계코드 : dtilOccuInttnAccCd */
		listColumnDefs.add(new ColumnDef("회계코드", Bass0350BM.ATTR_DTILOCCUINTTNACCCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** set 직종세회계명 : dtilOccuInttnAccNm */
		listColumnDefs.add(new ColumnDef("회계명", Bass0350BM.ATTR_DTILOCCUINTTNACCNM, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		});
		/** set 기간제사용여부 : dtilTermUseYn */
		listColumnDefs.add(new ColumnDef("기간게사용여부", Bass0350BM.ATTR_DTILTERMUSEYN, ColumnDef.TYPE_BOOLEAN , 90, true, false, true){
			{

			}
		});
		/** set 직종세단가일수 : dtilOcclsApptnUcstDys */
		listColumnDefs.add(new ColumnDef("단가일수", Bass0350BM.ATTR_DTILOCCLSAPPTNUCSTDYS, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});
		

        return listColumnDefs;
    }
    

    private List<ColumnDef> getBass0350List(){
    	
        row = 0;
        
        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>();     
       
        
        listColumnDefs.add(new ColumnDef("직종명", Bass0350BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 110, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });
        
        /** column 직종세통합코드 : dtilOccuInttnCd */
        listColumnDefs.add(new ColumnDef("직종세코드", Bass0350BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING, 100, true, true, true){
        	{
        		setReadOnly(true);	
        	}
        });  
        
        /** column 직종세명 : dtilOccuClsNm */
        listColumnDefs.add(new ColumnDef("직종세명", Bass0350BM.ATTR_DTILOCCUCLSNM, ColumnDef.TYPE_STRING, 112, true, true, true){
        	{
        		setReadOnly(true);
        	}
        });       
       
        return listColumnDefs;
    }
}
