package com.app.exterms.dlgn.server.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.utils.SmrmfUtils;
import org.msf.utils.TimingInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.exterms.dlgn.client.dto.Dlgn0300DTO;
import com.app.exterms.dlgn.client.service.Dlgn0300Service;
import com.app.exterms.dlgn.server.service.dao.Dlgn0300DAO;
import com.app.exterms.dlgn.server.vo.Dlgn0300SrhVO;
import com.app.exterms.dlgn.server.vo.Dlgn0300VO;
import com.app.exterms.dlgn.shared.DlgnDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnOrder;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;


@Service("Dlgn0300Service")
public class Dlgn0300ServiceImpl extends AbstractCustomServiceImpl implements Dlgn0300Service ,DlgnDaoConstants {

	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(Dlgn0300ServiceImpl.class);
	
	@Resource(name="Dlgn0300DAO")
	private Dlgn0300DAO dlgn0300Dao;
	
    public PagingLoadResult<BaseModel> getDlgn0300DataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_DLGN0300_DATA_LIST;
        Dlgn0300SrhVO   dlgn0300SrhVO = new Dlgn0300SrhVO();
        Dlgn0300VO      dlgn0300VO = new Dlgn0300VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        MSFSysm0100BM sessionUser;
        List<String> listDeptCd = new ArrayList<String>();
        
        
    	// 1. 암호화 객체 생성
    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        if (RemoteServiceUtil.getThreadLocalRequest() != null) {
              sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        } else {
            sessionUser = getUser();
        }
        
        if  (MSFSharedUtils.paramNull(dlgn0300Dao)) {
        
            WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

            dlgn0300Dao = (Dlgn0300DAO) wac.getBean("Dlgn0300DAO" ); 
        }
        
        try {
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
           // Sysm0100BM          user             = serviceParameters.getUser();
            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
            Boolean blnExecuteCount            = serviceParameters.isNoPageData();
            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
           // String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
           
            /** 조건절 */
            dlgn0300SrhVO.setDpobCd(sessionUser.getDpobCd()); 
            
            dlgn0300SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
            dlgn0300SrhVO.setUsrId(sessionUser.getUsrId());  
             
            dlgn0300SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드  
            
            /******************************** 권한 ************************************************************************/
            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
            if ("FALSE".equals(chkDeptCd)) {
            	dlgn0300SrhVO.setDeptCd(sessionUser.getDeptCd()); 
               listDeptCd.add(sessionUser.getDeptCd());
               dlgn0300SrhVO.setDeptCdArr(listDeptCd);     //부서코드    
               dlgn0300SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
            } else {
            	    
            	dlgn0300SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));    
                     if (dlgn0300SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
                     	 listDeptCd = null; 
                     	dlgn0300SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
                     	dlgn0300SrhVO.setDeptCd("");  //부서코드
                     } else {
                    	 dlgn0300SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                          dlgn0300SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
                     } 
                  
            }
            
//            String chkTypOccuCd = sessionUser.getAuthCheck().getAuthCheck04();
//            if ("FALSE".equals(chkTypOccuCd)) {
//            	//sysComSrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
//            	//sysComSrhVo.setUsrId(sessionUser.getUsrId());
//            } else {
//            	
//            }
            
            dlgn0300SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
            dlgn0300SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", "")); 
            
           /******************************** 권한 ************************************************************************/
            
             
           // dlgn0300SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드 
            
          //  List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
           // dlgn0300SrhVO.setDeptCdArr(listDeptCd);     //부서코드  
           // dlgn0300SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
             
            
            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
            dlgn0300SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
            dlgn0300SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
           
//            List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//            dlgn0300SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
//            dlgn0300SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
             
            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
            dlgn0300SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
            dlgn0300SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
             
            dlgn0300SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
           
           
            dlgn0300SrhVO.setPayCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payCd")));  //급여구분코드 
            dlgn0300SrhVO.setPymtYrMnth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtYrMnth"))); //지급년
            dlgn0300SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
            dlgn0300SrhVO.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명 
            	 /**
  	         * TODO 김해 시청 호봉제만 불러 오는 로직 추가  함. 임시로 김해시만 적용 
  	         */
//              if (dlgn0300SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(dlgn0300SrhVO.getDeptCdAuth())) 
//          			|| MSFSharedUtils.allowNulls(dlgn0300SrhVO.getDeptCdAuth()).contains(dlgn0300SrhVO.getPayrMangDeptCd())
//          			) {
//                  
//                	 dlgn0300SrhVO.setRepbtyBusinDivCd(DlgnServerUtils.getRepbtyBusinData(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest()));
//              	 
//          	  }  
              
                //Get total record count //전체 데이터 갯수를 가지고 온다. 
                 if ( pagingValues.executeRecordCount ) { 
                        
                    //Execute query that returns a single value
                    TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                     
                    int iResultCnt = dlgn0300Dao.selectDlgn0300ListTotCnt(dlgn0300SrhVO);  
                  
                    SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                    //페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                    if (!pagingValues.pageExecute) { 
                        pagingValues.offsetLimit = iResultCnt;       
                    }
                    
                    pagingValues.totalRecordCount = iResultCnt;        
                    
                    logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
                }
            
                TimingInfo millisBeginDlgn0300DataList = SmrmfUtils.startTiming(logger);
            
                /**페이지 카운트 처리를 위한 부분 */ 
                dlgn0300SrhVO.setPageSize(pagingValues.totalRecordCount);  
                
          
                //Apply paging
                if (pagingValues.start > 0) {
                    dlgn0300SrhVO.setFirstIndex(pagingValues.start);
                }
                if (pagingValues.offsetLimit > 0) {
                    dlgn0300SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));  
                }
//            if (!blnExecuteCount) {    
//                dlgn0300SrhVO.setLastIndex(-1); 
//            }
            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = dlgn0300Dao.selectDlgn0300List(dlgn0300SrhVO);
            
            Iterator<Map<String, Object>> iter = list.iterator();
                
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
        
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("systemkey").toString();
                BaseModel bm = new BaseModel();
 
                //bm.setProperties(map);
                for ( int i=0 ; i<tableAttributes.length ; i++ ) {
                    
                  //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++   
                  Object mapCon = map.get(tableAttributes[i].getName());    
                   
                  switch ( tableAttributes[i].getType() ) {  
                  case ColumnDef.TYPE_DATE: 
                  case ColumnDef.TYPE_DATETIME: 
                       
                     Date value =  SmrmfUtils.getDateFromString(String.valueOf(mapCon),"yyyyMMdd");
                     map.put(tableAttributes[i].getName(), value);
                     
                     break; 
                     
                  //3. 복호화
              	  case ColumnDef.TYPE_STRING: 
              	          			          			
              		String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));
                 			
              		if(	"resnRegnNum".equals(tableAttributes[i].getName())) {
              	          			
              			String rrnDecCrypt = "";
              	          			
              			// 주민번호(복호화)
              			rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
              	          		
              			strValue = rrnDecCrypt;
              						
              			}
               	                       
              		map.put(tableAttributes[i].getName(), strValue);
	              		                    
	              	break;  
                     
                     
                   case ColumnDef.TYPE_LONG:   
                     
                    if (mapCon != null) {  
                        Long  lValue =  (new BigDecimal(mapCon.toString())).longValue() ; 
                        map.put(tableAttributes[i].getName(), lValue); 
                    }  
                       
                     break;
                     
                   case ColumnDef.TYPE_DOUBLE:  
                     
                      if (mapCon != null) {      
                         Double dbValue = (new BigDecimal(mapCon.toString())).doubleValue(); 
                         map.put(tableAttributes[i].getName(), dbValue); 
                      }  
                       
                     break;
                  }
                    
                  //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                    Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
                            map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
                 
                    bm.set(tableAttributes[i].getName(), baseModelValue);
                }

                bm.set(TableDef.ID_PROPERTY_NAME, idValue);
                bmResult.add(bm);
            } 

            retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
            
            SmrmfUtils.endTiming(logger, millisBeginDlgn0300DataList, "getDlgn0300DataList");
       

        }
        catch (Exception ex) {
            ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }

	@Override
	public BaseListLoadResult<Dlgn0300DTO> selectDlgn0300(
			BaseListLoadConfig config, Dlgn0300DTO dto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
    


//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	@Override
//	public BaseListLoadResult<Dlgn0300DTO> selectDlgn0300(
//			BaseListLoadConfig config, Dlgn0300DTO dtoParam) throws Exception {
//		List<Dlgn0300DTO> returnValue = new ArrayList<Dlgn0300DTO>();
//		List egovResultDataList = new ArrayList();
//		
//		try{
//			egovResultDataList = dlgn0300Dao.selectDlgn0300(dtoParam);
//			if(egovResultDataList != null && egovResultDataList.size() > 0){
//				for(int i = 0 ; i < egovResultDataList.size(); i++){
//					Dlgn0300DTO dto = new Dlgn0300DTO();
//					Map tempMap = (Map)egovResultDataList.get(i);
//					Iterator<String> keys = tempMap.keySet().iterator();
//					while( keys.hasNext() ){
//			            String key = keys.next();
//			            //형 타입이 숫자형일경우 형변환 해준다.
//		            	if(tempMap.get(key) instanceof java.math.BigDecimal){
//		            		dto.set(key, String.valueOf(tempMap.get(key)));
//		            	}else{
//		            		dto.set(key, tempMap.get(key));
//		            	}
//		            }
//					returnValue.add(dto);
//				}
//			}
//			
//			
//		}catch(Exception e){
//			e.printStackTrace();
//			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
//		}
//			
//		
//		return new BaseListLoadResult<Dlgn0300DTO>(returnValue);
//	}
	

	
}
