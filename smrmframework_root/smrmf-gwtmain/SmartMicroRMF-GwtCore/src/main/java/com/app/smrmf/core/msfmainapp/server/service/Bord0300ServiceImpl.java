/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.app.smrmf.core.msfmainapp.server.service;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.smrmf.core.msfmainapp.client.admin.dto.Bord0300DTO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnOrder;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.service.Bord0300Service;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.MSFDaoConstants;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.sysm.server.service.dao.Bord0300DAO;
import com.app.smrmf.sysm.server.service.dao.Bord0400DAO;
import com.app.smrmf.sysm.server.service.vo.Bord0300SrhVO;
import com.app.smrmf.sysm.server.service.vo.Bord0300VO;
import com.app.smrmf.sysm.server.service.vo.Bord0400VO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
@Service("Bord0300Service")
public class Bord0300ServiceImpl extends AbstractCustomServiceImpl  implements Bord0300Service  ,MSFDaoConstants {

	private static final Logger logger = LoggerFactory.getLogger(Bord0300ServiceImpl.class);
	private static final String calledClass = Bord0300ServiceImpl.class.getName();
	
	   @Autowired	
	   @Resource(name="Bord0300DAO")
	   private Bord0300DAO bord0300DAO;
	   
	   @Autowired 
       @Resource(name="Bord0400DAO")
       private Bord0400DAO bord0400DAO;
	    
	    /** ID Generation */
	    //@Resource(name="{egovBord0300IdGnrService}")    
	    //private EgovIdGnrService egovIdGnrService;

	    public PagingLoadResult<BaseModel> getBord0300ViewList(ServiceParameters serviceParameters) throws MSFException {

            PagingLoadResult<BaseModel> retval = null;
            String method =  CLASS_BORD0300VIEW_LIST;
            Bord0300SrhVO   bord0300SrhVO = new Bord0300SrhVO();
            Bord0300VO      bord0300VO = new Bord0300VO(); 
            List<BaseModel>  bmResult = new ArrayList<BaseModel>();
            
            MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
            
            if  (MSFSharedUtils.paramNull(bord0300DAO)) {
            
                WebApplicationContext wac = WebApplicationContextUtils.
                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

                bord0300DAO = (Bord0300DAO) wac.getBean("Bord0300DAO" ); 
            }
            
            try {
                //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
               // Sysm0480BM          user             = serviceParameters.getUser();
                ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
                IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
                List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
                PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

                //Get paging configuration
                PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
 
                /** 조건절 공지사항출력 */
                bord0300SrhVO.setSysDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "SysDivCd")));
                bord0300SrhVO.setBullBordUid(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "bullBordUid")));   //"paygenapp02"
                bord0300SrhVO.setBullBordGrpId(new BigDecimal(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "bullBordGrpId"))));   //1
               
                //Get total record count //전체 데이터 갯수를 가지고 온다. 
                 if ( pagingValues.executeRecordCount ) { 
                        
                    //Execute query that returns a single value
                    TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                     
                    int iResultCnt = bord0300DAO.selectBord0300ViewListTotCnt(bord0300SrhVO);  
                  
                    SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                    pagingValues.totalRecordCount =  iResultCnt;        
                    
                    logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
                }
            
                TimingInfo millisBeginBord0300DataList = SmrmfUtils.startTiming(logger);
            
                /**페이지 카운트 처리를 위한 부분 */ 
                bord0300SrhVO.setPageSize(pagingValues.totalRecordCount);  
                
                //Apply paging
                if (pagingValues.start > 0) {
                    bord0300SrhVO.setFirstIndex(pagingValues.start);
                }
                if (pagingValues.totalRecordCount < pagingValues.offsetLimit) {
                    bord0300SrhVO.setLastIndex(pagingValues.totalRecordCount); 
               } else {
                   if (pagingValues.offsetLimit > 0) {
                       bord0300SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
                   }    
               }
                   
                //Execute query and convert to BaseModel list
                TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
                 
//              Collection<Map<String, Object>> list  
                List list = bord0300DAO.selectBord0300ViewList(bord0300SrhVO);
                
               Iterator<Map<String, Object>> iter = list.iterator();
              
               SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
      
                while ( iter.hasNext() ) {
                    
                    Map<String, Object> map = (Map<String, Object>) iter.next();  
                    String idValue = map.get("bullBordMsgeSeilNum").toString();
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
                         /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/    
                        Object baseModelValue = null;
                        //콤보박스처리를 위해 추가함
                        if (tableAttributes[i].getName().contains("$")) {
                             String strMapCon = tableAttributes[i].getName().replace("$", "").toLowerCase();
                                  
                             map.put(tableAttributes[i].getName(),map.get(strMapCon));
                             
                             baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
                                     map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
                        } else {
                             baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
                                     map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
                        }
                     /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
                        
                        bm.set(tableAttributes[i].getName(), baseModelValue);
                    }

                    bm.set(TableDef.ID_PROPERTY_NAME, idValue);
                    bmResult.add(bm);
                } 

                retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
                
                SmrmfUtils.endTiming(logger, millisBeginBord0300DataList, "getBord0300ViewList");
           

            }
            catch (Exception ex) {
                ex.printStackTrace();
                //Return operation exception
                throw MSFServerUtils.getOperationException(method, ex, logger);
            }

            return retval;
        }

        @Override
        public Bord0300DTO activityOnBoard0300(Bord0300DTO bord0300Dto, ActionDatabase actionDatabase) {
           
            MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
            try { 
              
                if  (MSFSharedUtils.paramNull(bord0300DAO)) {
                    
                    WebApplicationContext wac = WebApplicationContextUtils.
                            getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

                    bord0300DAO = (Bord0300DAO) wac.getBean("Bord0300DAO" ); 
                }
                
                Bord0300VO bord0300Vo = new Bord0300VO(); 
                Bord0400VO bord0400Vo = new Bord0400VO(); 
                
                
                bord0300Vo.setSysDivCd(bord0300Dto.getSysDivCd());    /** column 시스템구분코드 : sysDivCd */
                bord0300Vo.setBullBordMsgeSeilNum(new BigDecimal(bord0300Dto.getBullBordMsgeSeilNum()));    /** column 게시글일련번호 : bullBordMsgeSeilNum */
                bord0300Vo.setBullBordUid(bord0300Dto.getBullBordUid());    /** column 게시판_UID : bullBordUid */
                bord0300Vo.setBullBordGrpId(new BigDecimal(bord0300Dto.getBullBordGrpId()));    /** column 게시판그룹ID : bullBordGrpId */
                bord0300Vo.setTplvlWrtnInfo(new BigDecimal(bord0300Dto.getTplvlWrtnInfo()));    /** column 최상위 글 정보 : tplvlWrtnInfo */
                bord0300Vo.setWrtnAswrStge(new BigDecimal(bord0300Dto.getWrtnAswrStge()));    /** column 글의 답변단계 : wrtnAswrStge */
                bord0300Vo.setWrtnRgstnOrd(new BigDecimal(bord0300Dto.getWrtnRgstnOrd()));    /** column 글의 등록된 순서 : wrtnRgstnOrd */
                bord0300Vo.setAswrWrtnNum(new BigDecimal(bord0300Dto.getAswrWrtnNum()));    /** column 답변하는 글의 번호 : aswrWrtnNum */
                bord0300Vo.setPpgPernNm(bord0300Dto.getPpgPernNm());    /** column 작성자 이름 : ppgPernNm */
                bord0300Vo.setUsrId(bord0300Dto.getUsrId());    /** column 사용자 아이디 : usrId */
                bord0300Vo.setBullBordMsgeTtl(bord0300Dto.getBullBordMsgeTtl());    /** column 제목 : bullBordMsgeTtl */
                bord0300Vo.setBullBordMsgeCtnt(bord0300Dto.getBullBordMsgeCtnt());    /** column 내용 : bullBordMsgeCtnt */
                bord0300Vo.setWrtnSecrNum(bord0300Dto.getWrtnSecrNum());    /** column 글 비밀번호 : wrtnSecrNum */
                bord0300Vo.setPpgPernEmail(bord0300Dto.getPpgPernEmail());    /** column 작성자 메일 : ppgPernEmail */
                bord0300Vo.setInqyNum(new BigDecimal(bord0300Dto.getInqyNum()));    /** column 조회수 : inqyNum */
                bord0300Vo.setHtmlUseYn((Boolean.TRUE.equals(bord0300Dto.getHtmlUseYn()) ? "Y" : "N"));    /** column HTML 사용여부 : htmlUseYn */
                bord0300Vo.setBullBordMsgeDelYn((Boolean.TRUE.equals(bord0300Dto.getBullBordMsgeDelYn()) ? "Y" : "N"));    /** column 삭제 여부 : bullBordMsgeDelYn */
                bord0300Vo.setNotiBgnnDt(bord0300Dto.getNotiBgnnDt());    /** column 공지 시작일 : notiBgnnDt */
                bord0300Vo.setNotiEndDt(bord0300Dto.getNotiEndDt());    /** column 공지 종료일 : notiEndDt */
                bord0300Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
                //bord0300Vo.setInptDt(bord0300Dto.getInptDt());    /** column 입력일자 : inptDt */
               // bord0300Vo.setInptAddr(bord0300Dto.getInptAddr());    /** column 입력주소 : inptAddr */
               // bord0300Vo.setIsmt(bord0300Dto.getIsmt());    /** column 수정자 : ismt */
               // bord0300Vo.setRevnDt(bord0300Dto.getRevnDt());    /** column 수정일자 : revnDt */
               // bord0300Vo.setRevnAddr(bord0300Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
                 
            
                switch (actionDatabase) {
                case INSERT:
                    bord0300DAO.insertBord0300(bord0300Vo); 
                   break;
                case UPDATE: 
                    bord0300DAO.updateBord0300(bord0300Vo); 
                    break;
                case DELETE: 
                    
                    bord0400Vo.setSysDivCd(bord0300Vo.getSysDivCd());    /** column 시스템구분코드 : sysDivCd */
                    bord0400Vo.setBullBordMsgeSeilNum(bord0300Vo.getBullBordMsgeSeilNum());    /** column 게시글일련번호 : bullBordMsgeSeilNum */
                    bord0400Vo.setBullBordUid(bord0300Vo.getBullBordUid());    /** column 게시판_UID : bullBordUid */
                    bord0400Vo.setBullBordGrpId( bord0300Vo.getBullBordGrpId());    /** column 게시판그룹ID : bullBordGrpId */
                     
                    bord0400DAO.deleteAllBord0400(bord0400Vo); 
                    bord0300DAO.deleteBord0300(bord0300Vo); 
                    break;
                } 
                
                bord0300Vo =  bord0300DAO.selectBord0300(bord0300Vo); 
                
                if  (bord0300Vo != null) {
                    bord0300Dto.setBullBordMsgeSeilNum(bord0300Vo.getBullBordMsgeSeilNum().longValue());
                }
                
                
            }
            catch (Exception ex) {
                logger.error("EXCEPTION calling activityOnBoard0300(): "+ex);  
            }
            finally {
              
            }
            
            return bord0300Dto; 
        }	  
	  
	  
		/**
		 * BORD0300을 등록한다.
		 * @param vo - 등록할 정보가 담긴 Bord0300VO
		 * @return 등록 결과
		 * @exception Exception
		 */
//	    public String insertBord0300(Bord0300VO vo) throws Exception {
//	    	log.debug(vo.toString());
//	    	
//	    	/** ID Generation Service */
//	    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
//	    	//String id = egovIdGnrService.getNextStringId();
//	    	//vo.setId(id);
//	    	log.debug(vo.toString());
//	    	
//	    	bord0300DAO.insertBord0300(vo);
//	    	//TODO 해당 테이블 정보에 맞게 수정    	
//	        return null;
//	    }
//
//	    /**
//		 * BORD0300을 수정한다.
//		 * @param vo - 수정할 정보가 담긴 Bord0300VO
//		 * @return void형
//		 * @exception Exception
//		 */
//	    public void updateBord0300(Bord0300VO vo) throws Exception {
//	        bord0300DAO.updateBord0300(vo);
//	    }
//
//	    /**
//		 * BORD0300을 삭제한다.
//		 * @param vo - 삭제할 정보가 담긴 Bord0300VO
//		 * @return void형 
//		 * @exception Exception
//		 */
//	    public void deleteBord0300(Bord0300VO vo) throws Exception {
//	        bord0300DAO.deleteBord0300(vo);
//	    }
//
//	    /**
//		 * BORD0300을 조회한다.
//		 * @param vo - 조회할 정보가 담긴 Bord0300VO
//		 * @return 조회한 BORD0300
//		 * @exception Exception
//		 */
//	    public Bord0300VO selectBord0300(Bord0300VO vo) throws Exception {
//	        Bord0300VO resultVO = bord0300DAO.selectBord0300(vo);
//	        if (resultVO == null)
//	            throw processException("info.nodata.msg");
//	        return resultVO;
//	    }
//
//	    /**
//		 * BORD0300 목록을 조회한다.
//		 * @param searchVO - 조회할 정보가 담긴 VO
//		 * @return BORD0300 목록
//		 * @exception Exception
//		 */
//	    public List selectBord0300List(Bord0300DefaultVO searchVO) throws Exception {
//	        return bord0300DAO.selectBord0300List(searchVO);
//	    }
//
//	    /**
//		 * BORD0300 총 갯수를 조회한다.
//		 * @param searchVO - 조회할 정보가 담긴 VO
//		 * @return BORD0300 총 갯수
//		 * @exception
//		 */
//	    public int selectBord0300ListTotCnt(Bord0300DefaultVO searchVO) {
//			return bord0300DAO.selectBord0300ListTotCnt(searchVO);
//		}
	    
//	@Override
//	public String insertBord0300(Bord0300VO vo) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void updateBord0300(Bord0300VO vo) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void deleteBord0300(Bord0300VO vo) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public Bord0300VO selectBord0300(Bord0300VO vo) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List selectBord0300List(Bord0300SrhVO searchVO) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public int selectBord0300ListTotCnt(Bord0300SrhVO searchVO) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
}
