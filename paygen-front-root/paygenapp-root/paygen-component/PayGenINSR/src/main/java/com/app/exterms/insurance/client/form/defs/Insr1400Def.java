package com.app.exterms.insurance.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.insurance.client.dto.Insr1400BM;
import com.app.exterms.insurance.client.languages.InsrConstants;
import com.app.exterms.insurance.shared.InsrDaoConstants;
import com.app.exterms.prgm.client.dto.PrgmComBass0300BM;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.lookup.LookupPrgmComBass0300;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.ColumnListDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**
 * @Class Name : Insr1400VO.java
 * @Description : Insr1400 VO class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class Insr1400Def  extends TableDef implements InsrDaoConstants {
	  private int row = 0;
	    private InsrConstants InsrLabel = InsrConstants.INSTANCE;
	    
	    final PrgmComBass0300DTO sysComBass0300Dto;
	    
	    public Insr1400Def(String chkDef){ 
	    	
	     	 sysComBass0300Dto = new PrgmComBass0300DTO();  
	     	 
	      	 if ("INSRP210001".equals(chkDef)) {
	   	   		 
	      		setTitle("");
	 	        setDaoClass("");
	 	        setCustomListMethod(CLASS_INSRP210001TOINSR1400_DAO_LIST);
	 	        setAutoFillGrid(false);
	 	        setShowFilterToolbar(false);
	 	        setCheckBoxOnGridRows(true);
	 	        setFilterFormType(FILTER_FORM_SINGLE);
	 	         	 
		   	   setColumnsDefinition(getInsrp210001ToInsr1400()) ;
		   	             
		   }else if("Insr2400".equals(chkDef)) {
			   
	      		setTitle("");
	 	        setDaoClass("");
//	 	        setCustomListMethod(CLASS_INSRP210001TOINSR1400_DAO_LIST);
	 	        setAutoFillGrid(false);
	 	        setShowFilterToolbar(false);
	 	        setCheckBoxOnGridRows(true);
	 	        setFilterFormType(FILTER_FORM_SINGLE);
	 	         	 
		   	   setColumnsDefinition(getInsr2400ToInsr1400()) ;
		   }else if("INSR2150".equals(chkDef)) {
			   
	      		setTitle("");
	 	        setDaoClass("");
//	 	        setCustomListMethod(CLASS_INSRP210001TOINSR1400_DAO_LIST);
	 	        setAutoFillGrid(false);
	 	        setShowFilterToolbar(false);
	 	        setCheckBoxOnGridRows(false);
	 	        setFilterFormType(FILTER_FORM_SINGLE);
	 	         	 
		   	   setColumnsDefinition(getInsr2150ToInsr1400()) ;
		   }
	    }     	 
	       
     public List<ColumnDef> getInsrp210001ToInsr1400(){	 
	        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 

			
			/** column 사업장코드 : dpobCd */
			listColumnDefs.add(new ColumnDef("사업장코드", Insr1400BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column SYSTEMKEY : systemkey */
			listColumnDefs.add(new ColumnDef("SYSTEMKEY", Insr1400BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 가족일련번호 : famySeilNum */
			listColumnDefs.add(new ColumnDef("가족일련번호", Insr1400BM.ATTR_FAMYSEILNUM, ColumnDef.TYPE_LONG , 90, true, true, true){
				{
			
				}
			});
			 sysComBass0300Dto.setRpsttvCd("A019"); 
			/** column 가족관계구분코드 : famyRelaDivCd */
			listColumnDefs.add(new ColumnListDef("가족관계", Insr1400BM.ATTR_FAMYRELADIVCD, ColumnDef.TYPE_STRING , 90, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
				{
			
				}
			});
			/** column 가족관계 : famyRelaDivNm */
			listColumnDefs.add(new ColumnDef("가족관계", Insr1400BM.ATTR_FAMYRELADIVNM, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 가족성명 : famyNm */
			listColumnDefs.add(new ColumnDef("가족성명", Insr1400BM.ATTR_FAMYNM, ColumnDef.TYPE_STRING , 90, true, true, true){
				{
			
				}
			});
			/** column 가족주민등록번호 : famyResnRegnNum */
			listColumnDefs.add(new ColumnDef("주민등록번호", Insr1400BM.ATTR_FAMYRESNREGNNUM, ColumnDef.TYPE_STRING , 90, true, true, true){
				{
			
				}
			});
			
			/** column 가족주민등록번호 : famySecRegnNum */
			listColumnDefs.add(new ColumnDef("주민등록번호", Insr1400BM.ATTR_FAMYSECREGNNUM, ColumnDef.TYPE_STRING , 0, false, false, false){
				{
			
				}
			});
			sysComBass0300Dto.setRpsttvCd("A019"); 
			/** column 관계부호 : relaSgn */
			listColumnDefs.add(new ColumnListDef("관계부호", Insr1400BM.ATTR_RELASGN, ColumnDef.TYPE_STRING , 90, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
				{
			
				}
			});
			/** column 관계부호 : relaSgnNm */
			listColumnDefs.add(new ColumnDef("관계부호", Insr1400BM.ATTR_RELASGNNM, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			sysComBass0300Dto.setRpsttvCd("A019"); 
			/** column 취득상실구분코드 : aqtnLssDivCd */
			listColumnDefs.add(new ColumnListDef("구분", Insr1400BM.ATTR_AQTNLSSDIVCD, ColumnDef.TYPE_STRING , 90, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
				{
			
				}
			});
			/** column 취득상실구분 : aqtnLssDivNm */
			listColumnDefs.add(new ColumnDef("취득상실구분", Insr1400BM.ATTR_AQTNLSSDIVNM, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 취득일자 : aqtnDt */
			listColumnDefs.add(new ColumnDef("취득일자", Insr1400BM.ATTR_AQTNDT, ColumnDef.TYPE_DATE , 90, true, true, true){
				{
			
				}
			});
			sysComBass0300Dto.setRpsttvCd("A019"); 
			/** column 취득상실사유코드 : aqtnLssReasCd */
			listColumnDefs.add(new ColumnListDef("취득상실사유", Insr1400BM.ATTR_AQTNLSSREASCD, ColumnDef.TYPE_STRING , 90, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
				{
			
				}
			});
			/** column 취득상실사유 : aqtnLssReasNm */
			listColumnDefs.add(new ColumnDef("취득상실사유", Insr1400BM.ATTR_AQTNLSSREASNM, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			sysComBass0300Dto.setRpsttvCd("A019"); 
			/** column 장애인_종별부호코드 : dbpsnAssttnSgnCd */
			listColumnDefs.add(new ColumnListDef("종별부호", Insr1400BM.ATTR_DBPSNASSTTNSGNCD, ColumnDef.TYPE_STRING , 90, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
				{
			
				}
			});
			/** column 장애인_종별부호코드 : dbpsnAssttnSgnNm */
			listColumnDefs.add(new ColumnDef("종별부호", Insr1400BM.ATTR_DBPSNASSTTNSGNNM, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			sysComBass0300Dto.setRpsttvCd("A019"); 
			/** column 장애인_등급코드 : dbpsnGrdeCd */
			listColumnDefs.add(new ColumnListDef("등급", Insr1400BM.ATTR_DBPSNGRDECD, ColumnDef.TYPE_STRING , 90, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
				{
			
				}
			});
			/** column 장애인_등급코드 : dbpsnGrdeNm */
			listColumnDefs.add(new ColumnDef("등급", Insr1400BM.ATTR_DBPSNGRDENM, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 장애인_등록일자 : dbpsnRgstnDt */
			listColumnDefs.add(new ColumnDef("등록일자", Insr1400BM.ATTR_DBPSNRGSTNDT, ColumnDef.TYPE_DATE , 90, true, true, true){
				{
			
				}
			});
			/** column 장애인_국적코드 : dbpsnNatnCd */
			listColumnDefs.add(new ColumnDef("국적", Insr1400BM.ATTR_DBPSNNATNCD, ColumnDef.TYPE_STRING , 90, true, true, true){
				{
			
				}
			});
			/** column 장애인_국적코드 : dbpsnNatnCd */
			listColumnDefs.add(new ColumnDef("장애인_국적", Insr1400BM.ATTR_DBPSNNATNNM, ColumnDef.TYPE_STRING , 90, true, true, true){
				{
			
				}
			});
			sysComBass0300Dto.setRpsttvCd("A019"); 
			/** column 외국인_체류자격코드 : frgnrStyQftntCd */
			listColumnDefs.add(new ColumnListDef("체류자격", Insr1400BM.ATTR_FRGNRSTYQFTNTCD, ColumnDef.TYPE_STRING , 90, true, true, true,  new LookupPrgmComBass0300(sysComBass0300Dto),PrgmComBass0300BM.ATTR_COMMCD,PrgmComBass0300BM.ATTR_COMMCDNM){
				{
			
				}
			});
			/** column 외국인_체류자격코드 : frgnrStyQftntCd */
			listColumnDefs.add(new ColumnDef("체류자격", Insr1400BM.ATTR_FRGNRSTYQFTNTNM, ColumnDef.TYPE_STRING , 120, true, false, true){
				{
			
				}
			});
			/** column 외국인_체류시작일자 : frgnrStyBgnnDt */
			listColumnDefs.add(new ColumnDef("시작일자", Insr1400BM.ATTR_FRGNRSTYBGNNDT, ColumnDef.TYPE_DATE , 90, true, true, true){
				{
			
				}
			});
			/** column 외국인_체류종료일자 : frgnrStyEndDt */
			listColumnDefs.add(new ColumnDef("종료일자", Insr1400BM.ATTR_FRGNRSTYENDDT, ColumnDef.TYPE_DATE , 90, true, true, true){
				{
			
				}
			});
			/** column 사회보험작성일자 : soctyInsurCmptnDt */
			listColumnDefs.add(new ColumnDef("사회보험작성일자", Insr1400BM.ATTR_SOCTYINSURCMPTNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
				{
			
				}
			});
			/** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
			listColumnDefs.add(new ColumnDef("사회보험취득_고용_일련번호", Insr1400BM.ATTR_SOCINSRAQTNEMYMTNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
				{
			
				}
			});
			
		
			 return listColumnDefs;
			 
	    }   
     
     
     
     public List<ColumnDef> getInsr2400ToInsr1400(){	 
	        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
	        
	        /**************** 추후 다시 맵핑한다. ******************/
	        /** column 사업장코드 : dpobCd */
	        listColumnDefs.add(new ColumnDef("순번", Insr1400BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 50, true, true, true){
	        	{

	        	}
	        });
	        /** column SYSTEMKEY : systemkey */
	        listColumnDefs.add(new ColumnDef("시작일자", Insr1400BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 120, true, true, true){
	        	{

	        	}
	        });
	        /** column SYSTEMKEY : systemkey */
	        listColumnDefs.add(new ColumnDef("종료일자", Insr1400BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 120, true, true, true){
	        	{

	        	}
	        });
	        /** column 가족일련번호 : famySeilNum */
	        listColumnDefs.add(new ColumnDef("임금지급기초일수", Insr1400BM.ATTR_FAMYSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 120, true, true, true){
	        	{

	        	}
	        });  
	        /**************** 추후 다시 맵핑한다. ******************/

			
	        /** column 사업장코드 : dpobCd */
	        listColumnDefs.add(new ColumnDef("사업장코드", Insr1400BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column SYSTEMKEY : systemkey */
	        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Insr1400BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 가족일련번호 : famySeilNum */
	        listColumnDefs.add(new ColumnDef("가족일련번호", Insr1400BM.ATTR_FAMYSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 가족관계구분코드 : famyRelaDivCd */
	        listColumnDefs.add(new ColumnDef("가족관계구분코드", Insr1400BM.ATTR_FAMYRELADIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 가족성명 : famyNm */
	        listColumnDefs.add(new ColumnDef("가족성명", Insr1400BM.ATTR_FAMYNM, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 가족주민등록번호 : famyResnRegnNum */
	        listColumnDefs.add(new ColumnDef("가족주민등록번호", Insr1400BM.ATTR_FAMYRESNREGNNUM, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 가족주민등록번호 : famySecRegnNum */
	        listColumnDefs.add(new ColumnDef("가족주민등록번호", Insr1400BM.ATTR_FAMYSECREGNNUM, ColumnDef.TYPE_STRING , 0, false, false, false){
	        	{

	        	}
	        });
	        /** column 관계부호 : relaSgn */
	        listColumnDefs.add(new ColumnDef("관계부호", Insr1400BM.ATTR_RELASGN, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 취득상실구분코드 : aqtnLssDivCd */
	        listColumnDefs.add(new ColumnDef("취득상실구분코드", Insr1400BM.ATTR_AQTNLSSDIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 취득일자 : aqtnDt */
	        listColumnDefs.add(new ColumnDef("취득일자", Insr1400BM.ATTR_AQTNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 취득상실사유코드 : aqtnLssReasCd */
	        listColumnDefs.add(new ColumnDef("취득상실사유코드", Insr1400BM.ATTR_AQTNLSSREASCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 장애인_종별부호코드 : dbpsnAssttnSgnCd */
	        listColumnDefs.add(new ColumnDef("장애인_종별부호코드", Insr1400BM.ATTR_DBPSNASSTTNSGNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 장애인_등급코드 : dbpsnGrdeCd */
	        listColumnDefs.add(new ColumnDef("장애인_등급코드", Insr1400BM.ATTR_DBPSNGRDECD, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 장애인_등록일자 : dbpsnRgstnDt */
	        listColumnDefs.add(new ColumnDef("장애인_등록일자", Insr1400BM.ATTR_DBPSNRGSTNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 장애인_국적코드 : dbpsnNatnCd */
	        listColumnDefs.add(new ColumnDef("장애인_국적코드", Insr1400BM.ATTR_DBPSNNATNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 외국인_체류자격코드 : frgnrStyQftntCd */
	        listColumnDefs.add(new ColumnDef("외국인_체류자격코드", Insr1400BM.ATTR_FRGNRSTYQFTNTCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 외국인_체류시작일자 : frgnrStyBgnnDt */
	        listColumnDefs.add(new ColumnDef("외국인_체류시작일자", Insr1400BM.ATTR_FRGNRSTYBGNNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 외국인_체류종료일자 : frgnrStyEndDt */
	        listColumnDefs.add(new ColumnDef("외국인_체류종료일자", Insr1400BM.ATTR_FRGNRSTYENDDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 사회보험작성일자 : soctyInsurCmptnDt */
	        listColumnDefs.add(new ColumnDef("사회보험작성일자", Insr1400BM.ATTR_SOCTYINSURCMPTNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
	        listColumnDefs.add(new ColumnDef("사회보험취득_고용_일련번호", Insr1400BM.ATTR_SOCINSRAQTNEMYMTNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	        	{

	        	}
	        });
			
			 return listColumnDefs;
			 
	    }  
     
     public List<ColumnDef> getInsr2150ToInsr1400(){	
    	 
	        List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 
	        
	        /** set 한글성명 : hanNm */
	        listColumnDefs.add(new ColumnDef("성명", Insr1400BM.ATTR_HANNM, ColumnDef.TYPE_STRING , 90, true, true, true){
	        	{

	        	}
	        });
	        
	        /** set 주민등록번호 : resnRegnNum */
	        listColumnDefs.add(new ColumnDef("주민등록번호", Insr1400BM.ATTR_RESNREGNNUM, ColumnDef.TYPE_STRING , 100, true, true, true){
	        	{

	        	}
	        });
	        
	        /** set 주민등록번호 : secRegnNum */
	        listColumnDefs.add(new ColumnDef("주민등록번호", Insr1400BM.ATTR_SECREGNNUM, ColumnDef.TYPE_STRING , 0, false, false, false){
	        	{

	        	}
	        });
	        
	        /** set 전화번호(사업장) : tempComPunNm */
	        listColumnDefs.add(new ColumnDef("(사업장)", Insr1400BM.ATTR_TEMPCOMPUNNM, ColumnDef.TYPE_STRING , 90, true, true, true){
	        	{

	        	}
	        });
	        
	        /** set 전화번호(가입) : tempHuPunNm */
	        listColumnDefs.add(new ColumnDef("(가입)", Insr1400BM.ATTR_TEMPHUPUNNM, ColumnDef.TYPE_STRING , 90, true, true, true){
	        	{

	        	}
	        });
			
	        /** column 가족성명 : famyNm */
	        listColumnDefs.add(new ColumnDef("성명", Insr1400BM.ATTR_FAMYNM, ColumnDef.TYPE_STRING , 90, true, true, true){
	        	{

	        	}
	        });
	        /** column 가족주민등록번호 : famyResnRegnNum */
	        listColumnDefs.add(new ColumnDef("주민등록번호", Insr1400BM.ATTR_FAMYRESNREGNNUM, ColumnDef.TYPE_STRING , 100, true, true, true){
	        	{

	        	}
	        });
	        /** column 가족주민등록번호 : famySecRegnNum */
	        listColumnDefs.add(new ColumnDef("주민등록번호", Insr1400BM.ATTR_FAMYSECREGNNUM, ColumnDef.TYPE_STRING , 0, false, false, false){
	        	{

	        	}
	        });
	        /** column 관계부호 : relaSgn */
	        listColumnDefs.add(new ColumnDef("관계부호", Insr1400BM.ATTR_RELASGN, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 취득상실구분코드 : aqtnLssDivCd */
	        listColumnDefs.add(new ColumnDef("구분", Insr1400BM.ATTR_AQTNLSSDIVCD, ColumnDef.TYPE_STRING , 60, true,  true, true){
	        	{

	        	}
	        });
	        /** column 취득일자 : aqtnDt */
	        listColumnDefs.add(new ColumnDef("년월일", Insr1400BM.ATTR_AQTNDT, ColumnDef.TYPE_STRING , 120, true, true, true){
	        	{

	        	}
	        });
	        /** column 취득상실사유코드 : aqtnLssReasCd */
	        listColumnDefs.add(new ColumnDef("사유", Insr1400BM.ATTR_AQTNLSSREASCD, ColumnDef.TYPE_STRING , 80, true, true, true){
	        	{

	        	}
	        });
	        /** column 장애인_종별부호코드 : dbpsnAssttnSgnCd */
	        listColumnDefs.add(new ColumnDef("종별", Insr1400BM.ATTR_DBPSNASSTTNSGNCD, ColumnDef.TYPE_STRING , 80, true, true, true){
	        	{

	        	}
	        });
	        /** column 장애인_등급코드 : dbpsnGrdeCd */
	        listColumnDefs.add(new ColumnDef("등급", Insr1400BM.ATTR_DBPSNGRDECD, ColumnDef.TYPE_STRING , 80, true, true, true){
	        	{

	        	}
	        });
	        /** column 장애인_등록일자 : dbpsnRgstnDt */
	        listColumnDefs.add(new ColumnDef("등록일자", Insr1400BM.ATTR_DBPSNRGSTNDT, ColumnDef.TYPE_STRING , 90, true, true, true){
	        	{

	        	}
	        });
	        
	        /** column 장애인_국적코드 : dbpsnNatnCd */
	        listColumnDefs.add(new ColumnDef("외국인국적", Insr1400BM.ATTR_DBPSNNATNCD, ColumnDef.TYPE_STRING , 90, true, true, true){
	        	{

	        	}
	        });
	        
	        /** column 외국인_체류자격코드 : frgnrStyQftntCd */
	        listColumnDefs.add(new ColumnDef("체류자격", Insr1400BM.ATTR_FRGNRSTYQFTNTCD, ColumnDef.TYPE_STRING , 90, true, true, true){
	        	{

	        	}
	        });
	        /** column 외국인_체류시작일자 : frgnrStyBgnnDt */
	        listColumnDefs.add(new ColumnDef("시작일자", Insr1400BM.ATTR_FRGNRSTYBGNNDT, ColumnDef.TYPE_STRING , 90, true, true, true){
	        	{

	        	}
	        });
	        /** column 외국인_체류종료일자 : frgnrStyEndDt */
	        listColumnDefs.add(new ColumnDef("종료일자", Insr1400BM.ATTR_FRGNRSTYENDDT, ColumnDef.TYPE_STRING , 90, true, true, true){
	        	{

	        	}
	        });
	        
	        //--
	        /** column 가족관계구분코드 : famyRelaDivCd */
	        listColumnDefs.add(new ColumnDef("가족관계구분코드", Insr1400BM.ATTR_FAMYRELADIVCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 사업장코드 : dpobCd */
	        listColumnDefs.add(new ColumnDef("사업장코드", Insr1400BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column SYSTEMKEY : systemkey */
	        listColumnDefs.add(new ColumnDef("SYSTEMKEY", Insr1400BM.ATTR_SYSTEMKEY, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 가족일련번호 : famySeilNum */
	        listColumnDefs.add(new ColumnDef("가족일련번호", Insr1400BM.ATTR_FAMYSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	        	{

	        	}
	        });
	        




	        /** column 사회보험작성일자 : soctyInsurCmptnDt */
	        listColumnDefs.add(new ColumnDef("사회보험작성일자", Insr1400BM.ATTR_SOCTYINSURCMPTNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
	        	{

	        	}
	        });
	        /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
	        listColumnDefs.add(new ColumnDef("사회보험취득_고용_일련번호", Insr1400BM.ATTR_SOCINSRAQTNEMYMTNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
	        	{

	        	}
	        });
			
			 return listColumnDefs;
			 
	    }  
}
