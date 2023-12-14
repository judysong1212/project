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
package com.app.exterms.basis.server.service;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.gwtrpcspring.RemoteServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.exterms.basis.client.dto.Bass0600BM;
import com.app.exterms.basis.client.dto.Bass0600DTO;
import com.app.exterms.basis.client.service.Bass0600Service;
import com.app.exterms.basis.server.service.dao.Bass0600DAO;
import com.app.exterms.basis.server.vo.Bass0600VO;
import com.app.exterms.basis.shared.BasisDaoConstants;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFOperationException;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.crypto.service.AnyCryptService;

@Service("Bass0600Service")
public class Bass0600ServiceImpl   extends AbstractCustomServiceImpl implements  BasisDaoConstants ,Bass0600Service  {
	 
	   @Autowired  
	   @Resource(name="Bass0600DAO")
	    private Bass0600DAO bass0600DAO;
	   
	   
		 /** 암호화 모듈 호출  */
		@Autowired 
	    @Resource(name = "AnyCryptService")
	    protected AnyCryptService payGenCryptService;
		    
		 /** 암호화 모듈 호출  */
//		@Autowired 
//	    @Resource(name = "XecureNative")
//	    protected XecureNative xecureNative;
		    
		
	    /** ID Generation */
	    //@Resource(name="{egovBass0600IdGnrService}")    
	    //private EgovIdGnrService egovIdGnrService;

//		/**
//		 * BASS0600을 등록한다.
//		 * @param vo - 등록할 정보가 담긴 Bass0600VO
//		 * @return 등록 결과
//		 * @exception Exception
//		 */
//	    public String insertBass0600(Bass0600VO vo) throws MSFException {
//	    	log.debug(vo.toString());
//	    	
//	    	/** ID Generation Service */
//	    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
//	    	//String id = egovIdGnrService.getNextStringId();
//	    	//vo.setId(id);
//	    	log.debug(vo.toString());
//	    	
//	    	bass0600DAO.insertBass0600(vo);
//	    	//TODO 해당 테이블 정보에 맞게 수정    	
//	        return null;
//	    }
//
//	    /**
//		 * BASS0600을 수정한다.
//		 * @param vo - 수정할 정보가 담긴 Bass0600VO
//		 * @return void형
//		 * @exception Exception
//		 */
//	    public void updateBass0600(Bass0600VO vo) throws MSFException {
//	        bass0600DAO.updateBass0600(vo);
//	    }
//
//	    /**
//		 * BASS0600을 삭제한다.
//		 * @param vo - 삭제할 정보가 담긴 Bass0600VO
//		 * @return void형 
//		 * @exception Exception
//		 */
//	    public void deleteBass0600(Bass0600VO vo) throws MSFException {
//	        bass0600DAO.deleteBass0600(vo);
//	    }
//
//	    /**
//		 * BASS0600을 조회한다.
//		 * @param vo - 조회할 정보가 담긴 Bass0600VO
//		 * @return 조회한 BASS0600
//		 * @exception Exception
//		 */
//	    public Bass0600VO selectBass0600(Bass0600VO vo) throws MSFException {
//	        Bass0600VO resultVO = bass0600DAO.selectBass0600(vo);
//	        if (resultVO == null)
//	            throw processException("info.nodata.msg");
//	        return resultVO;
//	    }
//
//	    /**
//		 * BASS0600 목록을 조회한다.
//		 * @param searchVO - 조회할 정보가 담긴 VO
//		 * @return BASS0600 목록
//		 * @exception Exception
//		 */
//	    public List selectBass0600List(Bass0600SrhVO searchVO) throws MSFException {
//	        return bass0600DAO.selectBass0600List(searchVO);
//	    }
//
//	    /**
//		 * BASS0600 총 갯수를 조회한다.
//		 * @param searchVO - 조회할 정보가 담긴 VO
//		 * @return BASS0600 총 갯수
//		 * @exception
//		 */
//	    public int selectBass0600ListTotCnt(Bass0600SrhVO searchVO) {
//			return bass0600DAO.selectBass0600ListTotCnt(searchVO);
//		}	   
	   
	@Override
	public String insertBass0600(Bass0600DTO vo)  throws MSFException  {
		// TODO Auto-generated method stub
		
		String rtnVal =  "";
		String rrnDecCrypt = "";
		 
	    if  (MSFSharedUtils.paramNull(payGenCryptService)) {
	        
        	WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

        	payGenCryptService = (AnyCryptService) wac.getBean("AnyCryptService" ); 
        	 
        }
	    
	    try {
		//사용시 반드시 초기화 선언 추가 
	//    XecureNative xnCrypt = XecureNative.getInstance();  
	    
//        if  (MSFSharedUtils.paramNull(xnCrypt)) {
//	        
//        	WebApplicationContext wac = WebApplicationContextUtils.
//                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//        	xnCrypt = (XecureNative) wac.getBean("XecureNative" ); 
//        	 
//       } 
	    
//	    xnCrypt.XecureInitNative(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	    	
	 	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
	    if  (MSFSharedUtils.paramNull(bass0600DAO)) {
	        
        	WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

        	bass0600DAO = (Bass0600DAO) wac.getBean("Bass0600DAO" ); 
        	 
        } 
	    
	    List  list = bass0600DAO.selectBass0600List(null);
	     
        Iterator<Map<String, Object>> iter = list.iterator();
     
        while ( iter.hasNext() ) {
        	
        	Map<String, Object> map = (Map<String, Object>) iter.next();
        	
        	Bass0600VO bass0600Vo = new Bass0600VO();
        	 
            /** set 사업장코드 : dpobCd */ 
            bass0600Vo.setDpobCd(MSFSharedUtils.allowNulls(map.get("dpobCd")));
            /** set SYSTEMKEY : systemkey */ 
            bass0600Vo.setSystemkey(MSFSharedUtils.allowNulls(map.get("systemkey")));

            /** set 주민등록번호 : resnRegnNum */ 
            bass0600Vo.setOrgResnNum(MSFSharedUtils.allowNulls(map.get("resnRegnNum")).replaceAll("-",""));
           
            bass0600Vo.setResnRegnNum(MSFSharedUtils.allowNulls(map.get("resnRegnNum")).replaceAll("-",""));
            
            String pwdCryptSHA512 = "";
            
            pwdCryptSHA512 = AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(bass0600Vo.getResnRegnNum()).replaceAll("-",""),
           		                 AnyCryptUtils.SEC_RRNUMC);
        // pwdCryptSHA512 =   xnCrypt.sync_EncRrnumc(MSFSharedUtils.allowNulls(bass0600Vo.getResnRegnNum()).replaceAll("-",""));   
              
        // 메인키  
             
           if (pwdCryptSHA512.equals(MSFSharedUtils.allowNulls(bass0600Vo.getResnRegnNum()).replaceAll("-",""))) {
        	   bass0600Vo.setResnRegnNum(pwdCryptSHA512 );  
	           bass0600Vo.setSecResnNum(pwdCryptSHA512 ); 
           } else {
	           bass0600Vo.setResnRegnNum(pwdCryptSHA512 );   
	           rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,pwdCryptSHA512,AnyCryptUtils.SEC_RRNUMC);
	           bass0600Vo.setSecResnNum(rrnDecCrypt ); 
           } 
           // if (!MSFSharedUtils.allowNulls(bass0600Vo.getSecResnNum()).equals(MSFSharedUtils.allowNulls(map.get("secResnNum")))) { 
           rtnVal = bass0600DAO.insertBass0600(bass0600Vo); 
          //  }
           
           
        }
        
        List  list1 = bass0600DAO.selectBass0600ToPsnl0115List(null);
	     
        Iterator<Map<String, Object>> iter1 = list1.iterator();
     
        while ( iter1.hasNext() ) {
        	
        	Map<String, Object> map = (Map<String, Object>) iter1.next();
        	
        	Bass0600VO bass0600Vo = new Bass0600VO();
        	 
            /** set 사업장코드 : dpobCd */ 
            bass0600Vo.setDpobCd(MSFSharedUtils.allowNulls(map.get("dpobCd")));
            /** set SYSTEMKEY : systemkey */ 
            bass0600Vo.setSystemkey(MSFSharedUtils.allowNulls(map.get("systemkey")));

            bass0600Vo.setFamySeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(map.get("famySeilNum"),"0")));    /** column 가족일련번호 : famySeilNum */
            
            bass0600Vo.setFamyResnRegnNum(MSFSharedUtils.allowNulls(map.get("famyResnRegnNum")));    /** column 가족주민등록번호 : famyResnRegnNum */
  
            bass0600Vo.setFamySecRegnNum(MSFSharedUtils.allowNulls(map.get("famySecRegnNum")));    /** column null : famySecRegnNum */
          
            bass0600Vo.setFamyOrgRegnNum(MSFSharedUtils.allowNulls(map.get("famyResnRegnNum")));    /** column null : famyOrgRegnNum */
            
          
            String pwdCryptSHA512 = "";
            
            pwdCryptSHA512 = AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(bass0600Vo.getFamyResnRegnNum()).replaceAll("-",""),
           		                 AnyCryptUtils.SEC_RRNUMC);
           // pwdCryptSHA512 =   xnCrypt.sync_EncRrnumc(MSFSharedUtils.allowNulls(bass0600Vo.getResnRegnNum()).replaceAll("-",""));   
              
           // 메인키  
             
           if (pwdCryptSHA512.equals(MSFSharedUtils.allowNulls(bass0600Vo.getFamyResnRegnNum()).replaceAll("-",""))) {
        	   bass0600Vo.setFamyResnRegnNum(pwdCryptSHA512 );  
	           bass0600Vo.setFamySecRegnNum(pwdCryptSHA512 ); 
           } else {
	           bass0600Vo.setFamyResnRegnNum(pwdCryptSHA512 );   
	           rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,pwdCryptSHA512,AnyCryptUtils.SEC_RRNUMC);
	           bass0600Vo.setFamySecRegnNum(rrnDecCrypt ); 
           } 
           // if (!MSFSharedUtils.allowNulls(bass0600Vo.getSecResnNum()).equals(MSFSharedUtils.allowNulls(map.get("secResnNum")))) { 
           
           //가족주민번호 암호화  
           bass0600DAO.updatePsnl0115(bass0600Vo);
          //  }
        } 
         //payr0530 table 암호회  
           List  list2 = bass0600DAO.selectBass0600ToPayr0530List(null);
  	     
           Iterator<Map<String, Object>> iter2 = list2.iterator();
        
           while ( iter2.hasNext() ) {
           	
           	Map<String, Object> map = (Map<String, Object>) iter2.next();
           	
           	Bass0600VO bass0600Vo = new Bass0600VO();
           	 

           	bass0600Vo.setDpobCd(MSFSharedUtils.allowNulls(map.get("dpobCd")));    /** column 사업장코드 : dpobCd */
           	bass0600Vo.setSystemkey(MSFSharedUtils.allowNulls(map.get("systemkey")));    /** column SYSTEMKEY : systemkey */
           	bass0600Vo.setPayFamyRsptSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(map.get("payFamyRsptSeilNum"),"0")));    /** column 급여가족사항일련번호 : payFamyRsptSeilNum */
           	bass0600Vo.setPayFamyResnRegnNum(MSFSharedUtils.allowNulls(map.get("payFamyResnRegnNum")));    /** column 급여가족주민번호 : payFamyResnRegnNum */
          // 	bass0600Vo.setHanNm(MSFSharedUtils.allowNulls(map.get("hanNm")));    /** column 한글성명 : hanNm */
 
               String pwdCryptSHA512 = "";
               
               pwdCryptSHA512 = AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(bass0600Vo.getPayFamyResnRegnNum()).replaceAll("-",""),
              		                 AnyCryptUtils.SEC_RRNUMC);
              // pwdCryptSHA512 =   xnCrypt.sync_EncRrnumc(MSFSharedUtils.allowNulls(bass0600Vo.getResnRegnNum()).replaceAll("-",""));   
                 
              // 메인키  
                
           //   if (pwdCryptSHA512.equals(MSFSharedUtils.allowNulls(bass0600Vo.getFamyResnRegnNum()).replaceAll("-",""))) {
           	   bass0600Vo.setPayFamyResnRegnNum(pwdCryptSHA512 );  
   	        //   bass0600Vo.setFamySecRegnNum(pwdCryptSHA512 ); 
           //   } else {
   	        //   bass0600Vo.setPayFamyResnRegnNum(pwdCryptSHA512 );   
   	         //  rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,pwdCryptSHA512,AnyCryptUtils.SEC_RRNUMC);
   	       //    bass0600Vo.setFamySecRegnNum(rrnDecCrypt ); 
         //     } 
              // if (!MSFSharedUtils.allowNulls(bass0600Vo.getSecResnNum()).equals(MSFSharedUtils.allowNulls(map.get("secResnNum")))) { 
              
              //가족주민번호 암호화  
              bass0600DAO.updatePayr0530(bass0600Vo);
             //  }     
           
             

        }
           
           yetaChangeConvert();
           
	    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new MSFOperationException();  
		}	
		return null;
	}

 
	public String yetaChangeConvert() throws Exception {
		// TODO Auto-generated method stub
		
		
		String rtnVal =  "";
		String rrnDecCrypt = "";
		 
    try {
 
	 	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	  
	    List  list = bass0600DAO.selectYetaAllList();
	     
        Iterator<Map<String, Object>> iter = list.iterator();
     
        while ( iter.hasNext() ) {
        	
        	Map<String, Object> map = (Map<String, Object>) iter.next();
        	
        	Bass0600VO  ye160404Vo = new Bass0600VO();
           
           
        	ye160404Vo.setSystemkey(MSFSharedUtils.allowNulls(map.get("resid")));

          
        	ye160404Vo.setOldresid(MSFSharedUtils.allowNulls(map.get("resid")).replaceAll("-",""));
           
        	ye160404Vo.setResid(MSFSharedUtils.allowNulls(map.get("resid")).replaceAll("-",""));
            
            String pwdCryptSHA512 = "";
            
            pwdCryptSHA512 = AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(ye160404Vo.getResid()).replaceAll("-",""), AnyCryptUtils.SEC_RRNUMC);
        // pwdCryptSHA512 =   xnCrypt.sync_EncRrnumc(MSFSharedUtils.allowNulls(bass0600Vo.getResnRegnNum()).replaceAll("-",""));   
            ye160404Vo.setResid(pwdCryptSHA512);    
      
           // if (!MSFSharedUtils.allowNulls(bass0600Vo.getSecResnNum()).equals(MSFSharedUtils.allowNulls(map.get("secResnNum")))) { 
            bass0600DAO.updateYetaAll(ye160404Vo); 
          //  }
           
           
        }
          
	    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new MSFOperationException();  
		}	 
		return null;
	}	
	
	@Override
	public void updateBass0600(Bass0600DTO vo)  throws Exception  {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBass0600(Bass0600DTO vo)  throws Exception  {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Bass0600BM selectBass0600(Bass0600DTO vo)  throws Exception  {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bass0600BM> selectBass0600List(Bass0600DTO searchVO)  throws Exception  {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectBass0600ListTotCnt(Bass0600DTO searchVO) {
		// TODO Auto-generated method stub
		return 0;
	}
}
