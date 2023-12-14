package com.app.exterms.insurance.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.insurance.client.dto.Insr5100BM;
import com.app.exterms.insurance.client.languages.InsrConstants;
import com.app.exterms.insurance.shared.InsrDaoConstants;
import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**
 * @Class Name : Insr5100VO.java
 * @Description : Insr5100 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr6600Def  extends TableDef implements InsrDaoConstants {
	  private int row = 0;
	    private InsrConstants InsrLabel = InsrConstants.INSTANCE;

	    final PrgmComBass0300DTO sysComBass0300Dto;
	    
	    public Insr6600Def(String chkDef){
	    	
	    	 sysComBass0300Dto = new PrgmComBass0300DTO(); 
	    	 
	    	  if ("INSR6500".equals(chkDef)) {
	    		    setTitle("");
	    	        setDaoClass("");
	    	        setCustomListMethod(CLASS_INSR5100TOINSR5100_DAO_LIST);
	    	        setAutoFillGrid(false);
	    	        setShowFilterToolbar(false);
	    	        setCheckBoxOnGridRows(true); 
	    	        setEditFieldGrid(true);
	    	       // setEditableGrid(true);
	               
	              setColumnsDefinition(getInsr6500ToInsr5100());
	         
	    	  } else  if ("INSRP510001".equals(chkDef)) {
	    		    setTitle("");
	    	        setDaoClass("");
	    	        setCustomListMethod(CLASS_INSRP510001TOINSR5100_DAO_LIST);
	    	        setAutoFillGrid(false);
	    	        setShowFilterToolbar(false);
	    	        setCheckBoxOnGridRows(true); 
	    	       // setEditFieldGrid(true);
	    	       // setEditableGrid(true);
	               
	              setColumnsDefinition(getInsrP510001ToInsr5100());
	            
	              
	          } else if ("".equals(chkDef)) {
	        	   setTitle("");
	              setDaoClass("");
	              setCustomListMethod("");
	              setAutoFillGrid(false);
	              setShowFilterToolbar(false);
	              setCheckBoxOnGridRows(true); 
	             // setEditFieldGrid(true); 
	              setColumnsDefinition(getInsr6500());
	              
	          } 
	    }	
	    
	    public List<ColumnDef> getInsr6500(){	  

	        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 

	        /** column 사업장코드 : dpobCd */
	    	listColumnDefs.add(new ColumnDef("사업장코드", Insr5100BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column SYSTEMKEY : systemkey */
	    	listColumnDefs.add(new ColumnDef("SYSTEMKEY", Insr5100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	 
	    	/** column 고용일련번호 : emymtSeilNum */
	    	listColumnDefs.add(new ColumnDef("고용일련번호", Insr5100BM.ATTR_EMYMTSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 사대보험공제방식코드 : socInsrDducEthdCd */
	    	listColumnDefs.add(new ColumnDef("사대보험공제방식코드", Insr5100BM.ATTR_SOCINSRDDUCETHDCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 고용보험취득일자 : umytInsrAqtnDt */
	    	listColumnDefs.add(new ColumnDef("고용보험취득일자", Insr5100BM.ATTR_UMYTINSRAQTNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 고용보험상실일자 : umytInsrLssDt */
	    	listColumnDefs.add(new ColumnDef("고용보험상실일자", Insr5100BM.ATTR_UMYTINSRLSSDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 고용보험제외여부 : umytInsrEepnYn */
	    	listColumnDefs.add(new ColumnDef("고용보험제외여부", Insr5100BM.ATTR_UMYTINSREEPNYN, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 고용보험제외사유내용 : umytInsrEepnReasCtnt */
	    	listColumnDefs.add(new ColumnDef("고용보험제외사유내용", Insr5100BM.ATTR_UMYTINSREEPNREASCTNT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 입력자 : kybdr */
	    	listColumnDefs.add(new ColumnDef("입력자", Insr5100BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 입력일자 : inptDt */
	    	listColumnDefs.add(new ColumnDef("입력일자", Insr5100BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 입력주소 : inptAddr */
	    	listColumnDefs.add(new ColumnDef("입력주소", Insr5100BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 수정자 : ismt */
	    	listColumnDefs.add(new ColumnDef("수정자", Insr5100BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 수정일자 : revnDt */
	    	listColumnDefs.add(new ColumnDef("수정일자", Insr5100BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 수정주소 : revnAddr */
	    	listColumnDefs.add(new ColumnDef("수정주소", Insr5100BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});

	    	 return listColumnDefs;
	    } 
	    
	    public List<ColumnDef> getInsr6500ToInsr5100(){	  

	        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 

	        /** column 사업장코드 : dpobCd */
	    	listColumnDefs.add(new ColumnDef("사업장코드", Insr5100BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	 	   
	        /** column 사업코드 : businCd */
	        listColumnDefs.add(new ColumnDef("사업", Insr5100BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, false, false, false){
	            {
	            	 setReadOnly(true);
	            }
	        });
	    	/** column SYSTEMKEY : systemkey */
	    	listColumnDefs.add(new ColumnDef("SYSTEMKEY", Insr5100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	
	    	   /** column 고용구분코드 : emymtDivCd */
	        listColumnDefs.add(new ColumnDef("고용구분", Insr5100BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, false, false, false){
	            {
	            	 setReadOnly(true);
	            }
	        });
	        /** column 부서코드 : deptCd */
	        listColumnDefs.add(new ColumnDef("부서", Insr5100BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, false, false, false){
	            {
	            	 setReadOnly(true);
	            }
	        });
	        
	     
	        
	        /** column 고용구분코드 : emymtDivCd */
	        listColumnDefs.add(new ColumnDef("고ㅇㅇ", Insr5100BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING , 80, false, true, false){
	            {
	                setReadOnly(true);
	            }
	        });
	        /** column 부서코드 : deptCd */
	        listColumnDefs.add(new ColumnDef("부서", Insr5100BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 100, false, true, false){
	            {
	                setReadOnly(true);
	            }
	        });
	        
	        /** column 한글성명 : hanNm */
	        listColumnDefs.add(new ColumnDef("성명", Insr5100BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 80, true, true, false){
	          {
	              setReadOnly(true);
	          }
	        });
	        /** column 주민등록번호 : resnRegnNum */
	        listColumnDefs.add(new ColumnDef("주민등록번호", Insr5100BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 90, true, true, false){
	          {
	              setReadOnly(true);
	          }
	        }); 
	        
	        /** column 주민등록번호 : secRegnNum */
	        listColumnDefs.add(new ColumnDef("주민등록번호", Insr5100BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING, 0, false, false, false){
	          {
	              setReadOnly(true);
	          }
	        });  
	    	/** column 고용일련번호 : emymtSeilNum */
	    	listColumnDefs.add(new ColumnDef("고용일련번호", Insr5100BM.ATTR_EMYMTSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
	    		{
	    			 setReadOnly(true);
	    		}
	    	});
	    	/** column 사대보험공제방식코드 : socInsrDducEthdCd */
	    	 sysComBass0300Dto.setRpsttvCd("I023"); 
	    	listColumnDefs.add(new ColumnListDef("공제방식", Insr5100BM.ATTR_SOCINSRDDUCETHDCD, ColumnDef.TYPE_STRING , 90,  false, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
	    		{

	    		}
	    	});
	    	
	    	/** column 사대보험공제방식 : socInsrDducEthdNm */ 
	    	listColumnDefs.add(new ColumnDef("공제방식", Insr5100BM.ATTR_SOCINSRDDUCETHDNM, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{
	    			 setReadOnly(true);
	    		}
	    	});
	    	
	    	/** column 고용보험취득일자 : umytInsrAqtnDt */
	    	listColumnDefs.add(new ColumnDef("취득일자", Insr5100BM.ATTR_UMYTINSRAQTNDT, ColumnDef.TYPE_DATE , 90, true, true, true){
	    		{

	    		}
	    	});
	    	/** column 고용보험상실일자 : umytInsrLssDt */
	    	listColumnDefs.add(new ColumnDef("상실일자", Insr5100BM.ATTR_UMYTINSRLSSDT, ColumnDef.TYPE_DATE , 90, true, false, true){
	    		{
	    			 setReadOnly(true);
	    		}
	    	});
	    	
	    	/** column 고용보험변동일자 : umytInsrFlucDt */
	    	listColumnDefs.add(new ColumnDef("변동일자", Insr5100BM.ATTR_UMYTINSRFLUCDT, ColumnDef.TYPE_DATE , 90, true, false, true){
	    		{
	    			 setReadOnly(true);
	    		}
	    	});
	    	/** column 고용보험보수총액 : umytInsrPayTotAmnt */
	    	listColumnDefs.add(new ColumnDef("보수총액", Insr5100BM.ATTR_UMYTINSRPAYTOTAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
	    		{
	    			 setReadOnly(true);
	    		}
	    	});
	    	/** column 고용보험보수월액 : umytInsrPayMnthAmnt */
	    	listColumnDefs.add(new ColumnDef("보수월액", Insr5100BM.ATTR_UMYTINSRPAYMNTHAMNT, ColumnDef.TYPE_LONG , 90, true, true, true){
	    		{

	    		}
	    	});
	    	/** column 고용보험료 : umytInsrMnthAmnt */
	    	listColumnDefs.add(new ColumnDef("보험료", Insr5100BM.ATTR_UMYTINSRMNTHAMNT, ColumnDef.TYPE_LONG , 90, true, true, true){
	    		{
	    			 setReadOnly(true);
	    		}
	    	});
	    	
	    	
	    	/** column 고용보험제외여부 : umytInsrEepnYn */
	    	listColumnDefs.add(new ColumnDef("제외", Insr5100BM.ATTR_UMYTINSREEPNYN, ColumnDef.TYPE_BOOLEAN , 60, true, true, true){
	    		{

	    		}
	    	});
	    	/** column 고용보험제외사유내용 : umytInsrEepnReasCtnt */
	    	listColumnDefs.add(new ColumnDef("제외사유", Insr5100BM.ATTR_UMYTINSREEPNREASCTNT, ColumnDef.TYPE_STRING , 200, false, true, false){
	    		{

	    		}
	    	});
	    	 
	    	/** column 고용보험적용여부 : umytInsrApptnYn */
	    	listColumnDefs.add(new ColumnDef("적용여부", Insr5100BM.ATTR_UMYTINSRAPPTNYN, ColumnDef.TYPE_BOOLEAN , 90, true, false, true){
	    		{
	    			 setReadOnly(true);
	    		}
	    	});
	    	
	    	 /** column 직종코드 : typOccuCd */
	        listColumnDefs.add(new ColumnDef("직종", Insr5100BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, false, false, false){
	            {
	            	  setReadOnly(true);
	            }
	        });
	        /** column 호봉등급코드 : pyspGrdeCd */
	        listColumnDefs.add(new ColumnDef("호봉등급", Insr5100BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, false, false, false){
	            {
	            	  setReadOnly(true);
	            }
	        });
	        /** column 직종세구분코드 : dtilOccuClsDivCd */
	        listColumnDefs.add(new ColumnDef("직종세", Insr5100BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING , 90, false, false, false){
	            {
	            	  setReadOnly(true);
	            }
	        });
	        
	        /** column 직종세통합코드 : dtilOccuInttnCd */
	        listColumnDefs.add(new ColumnDef("직종세통합코드", Insr5100BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });                                           
	                 
	      
	        /** column 직종 : typOccuCd */
	        listColumnDefs.add(new ColumnDef("직종", Insr5100BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING , 90, false, true, false){
	            {
	                setReadOnly(true);
	            }
	        });
	        /** column 호봉등급 : pyspGrdeCd */
	        listColumnDefs.add(new ColumnDef("호봉등급", Insr5100BM.ATTR_PYSPGRDENM, ColumnDef.TYPE_STRING , 90, false, false, false){
	            {
	                setReadOnly(true);
	            }
	        });
	        /** column 직종세구분 : dtilOccuClsDivCd */
	        listColumnDefs.add(new ColumnDef("직종세", Insr5100BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING , 90, false, true, false){
	            {
	                setReadOnly(true);
	            }
	        });
	        
	        /** column 사업 : businCd */
	        listColumnDefs.add(new ColumnDef("사업", Insr5100BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING , 90, false, true, false){
	            {
	                setReadOnly(true);
	            }
	        });

	    	 return listColumnDefs;
	    } 
	    
	    public List<ColumnDef> getInsrP510001ToInsr5100(){	  

	        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 

	        /** column 사업장코드 : dpobCd */
	    	listColumnDefs.add(new ColumnDef("사업장코드", Insr5100BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	 	   
	        /** column 사업코드 : businCd */
	        listColumnDefs.add(new ColumnDef("사업", Insr5100BM.ATTR_BUSINCD, ColumnDef.TYPE_STRING , 90, false, false, false){
	            {
	            	 setReadOnly(true);
	            }
	        });
	    	/** column SYSTEMKEY : systemkey */
	    	listColumnDefs.add(new ColumnDef("SYSTEMKEY", Insr5100BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	
	    	   /** column 고용구분코드 : emymtDivCd */
	        listColumnDefs.add(new ColumnDef("고용구분", Insr5100BM.ATTR_EMYMTDIVCD, ColumnDef.TYPE_STRING , 90, false, false, false){
	            {
	            	 setReadOnly(true);
	            }
	        });
	        /** column 부서코드 : deptCd */
	        listColumnDefs.add(new ColumnDef("부서", Insr5100BM.ATTR_DEPTCD, ColumnDef.TYPE_STRING , 90, false, false, false){
	            {
	            	 setReadOnly(true);
	            }
	        });
	        
	     
	        
	        /** column 고용구분코드 : emymtDivCd */
	        listColumnDefs.add(new ColumnDef("고용구분", Insr5100BM.ATTR_EMYMTDIVNM, ColumnDef.TYPE_STRING , 80, false, true, false){
	            {
	                setReadOnly(true);
	            }
	        });
	        /** column 부서코드 : deptCd */
	        listColumnDefs.add(new ColumnDef("부서", Insr5100BM.ATTR_DEPTNM, ColumnDef.TYPE_STRING , 100, false, true, false){
	            {
	                setReadOnly(true);
	            }
	        });
	        
	        /** column 한글성명 : hanNm */
	        listColumnDefs.add(new ColumnDef("성명", Insr5100BM.ATTR_HANNM, ColumnDef.TYPE_STRING, 80, true, true, false){
	          {
	              setReadOnly(true);
	          }
	        });
	        /** column 주민등록번호 : resnRegnNum */
	        listColumnDefs.add(new ColumnDef("주민등록번호", Insr5100BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING, 90, true, true, false){
	          {
	              setReadOnly(true);
	          }
	        }); 
	        /** column 주민등록번호 : secRegnNum */
	        listColumnDefs.add(new ColumnDef("주민등록번호", Insr5100BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING, 0, false, false, false){
	          {
	              setReadOnly(true);
	          }
	        }); 
	    	 
	    	/** column 고용일련번호 : emymtSeilNum */
	    	listColumnDefs.add(new ColumnDef("고용일련번호", Insr5100BM.ATTR_EMYMTSEILNUM, ColumnDef.TYPE_LONG , 90, true, false, true){
	    		{

	    		}
	    	});
	    	/** column 사대보험공제방식코드 : socInsrDducEthdCd */
	    	listColumnDefs.add(new ColumnDef("공제방식", Insr5100BM.ATTR_SOCINSRDDUCETHDCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	    		{

	    		}
	    	});
	    	
	    	/** column 사대보험공제방식 : socInsrDducEthdNm */
	    	listColumnDefs.add(new ColumnDef("공제방식", Insr5100BM.ATTR_SOCINSRDDUCETHDNM, ColumnDef.TYPE_STRING , 90, true, true, true){
	    		{

	    		}
	    	});
	    	
	    	/** column 고용보험취득일자 : umytInsrAqtnDt */
	    	listColumnDefs.add(new ColumnDef("취득일자", Insr5100BM.ATTR_UMYTINSRAQTNDT, ColumnDef.TYPE_DATE , 90, true, true, true){
	    		{

	    		}
	    	});
	    	/** column 고용보험상실일자 : umytInsrLssDt */
	    	listColumnDefs.add(new ColumnDef("상실일자", Insr5100BM.ATTR_UMYTINSRLSSDT, ColumnDef.TYPE_DATE , 90, true, false, true){
	    		{

	    		}
	    	});
	    	
	    	/** column 고용보험변동일자 : umytInsrFlucDt */
	    	listColumnDefs.add(new ColumnDef("변동일자", Insr5100BM.ATTR_UMYTINSRFLUCDT, ColumnDef.TYPE_DATE , 90, true, false, true){
	    		{
	    			 setReadOnly(true);
	    		}
	    	});
	    	/** column 고용보험보수총액 : umytInsrPayTotAmnt */
	    	listColumnDefs.add(new ColumnDef("보수총액", Insr5100BM.ATTR_UMYTINSRPAYTOTAMNT, ColumnDef.TYPE_LONG , 90, true, false, true){
	    		{
	    			 setReadOnly(true);
	    		}
	    	});

			/** set 고용보험료 : pymtDducD0160100 */
	    	listColumnDefs.add(new ColumnDef("고용보험료", Insr5100BM.ATTR_PYMTDDUCD0160100, ColumnDef.TYPE_LONG , 90, false, true, false){
	    		{

	    		}
	    	});
	    	
	    	/** set 정산보험료 : pymtDducD0160200 */
	    	listColumnDefs.add(new ColumnDef("정산보험료", Insr5100BM.ATTR_PYMTDDUCD0160200, ColumnDef.TYPE_LONG , 90, false, true, false){
	    		{

	    		}
	    	});
	    	
	    	/** set 소급보험료 : pymtDducD0160300 */
	    	listColumnDefs.add(new ColumnDef("소급보험료", Insr5100BM.ATTR_PYMTDDUCD0160300, ColumnDef.TYPE_LONG , 90, false, true, false){
	    		{

	    		}
	    	});
	    	 
	    	/** set 합계 : pymtSducSum */
	    	listColumnDefs.add(new ColumnDef("합계", Insr5100BM.ATTR_PYMTDDUCSUM, ColumnDef.TYPE_LONG , 90, false, true, false){
	    		{

	    		}
	    	});
	    	 /** column 직종코드 : typOccuCd */
	        listColumnDefs.add(new ColumnDef("직종", Insr5100BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, false, false, false){
	            {
	            	  setReadOnly(true);
	            }
	        });
	        /** column 호봉등급코드 : pyspGrdeCd */
	        listColumnDefs.add(new ColumnDef("호봉등급", Insr5100BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, false, false, false){
	            {
	            	  setReadOnly(true);
	            }
	        });
	        /** column 직종세구분코드 : dtilOccuClsDivCd */
	        listColumnDefs.add(new ColumnDef("직종세", Insr5100BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING , 90, false, false, false){
	            {
	            	  setReadOnly(true);
	            }
	        });
	      
	        /** column 직종 : typOccuCd */
	        listColumnDefs.add(new ColumnDef("직종", Insr5100BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING , 90, false, true, false){
	            {
	                setReadOnly(true);
	            }
	        });
	        /** column 호봉등급 : pyspGrdeCd */
	        listColumnDefs.add(new ColumnDef("호봉등급", Insr5100BM.ATTR_PYSPGRDENM, ColumnDef.TYPE_STRING , 90, false, false, false){
	            {
	                setReadOnly(true);
	            }
	        });
	        /** column 직종세구분 : dtilOccuClsDivCd */
	        listColumnDefs.add(new ColumnDef("직종세", Insr5100BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING , 90, false, true, false){
	            {
	                setReadOnly(true);
	            }
	        });
	        
	        /** column 사업 : businCd */
	        listColumnDefs.add(new ColumnDef("사업", Insr5100BM.ATTR_BUSINNM, ColumnDef.TYPE_STRING , 90, false, true, false){
	            {
	                setReadOnly(true);
	            }
	        });
 
	    	 return listColumnDefs;
	    }  
    
}
