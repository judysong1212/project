/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.server.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.smrmf.core.msfmainapp.client.admin.dto.ElementoMenu;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.service.system.MenuService;
import com.app.smrmf.core.msfmainapp.server.service.dao.MenuServiceDAO;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.sysm.server.vo.SysIfSysm0100SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0200VO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0300VO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0400VO;

@Service("MenuService")
public class MenuServiceImpl  extends AbstractCustomServiceImpl implements MenuService {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);
    
	@Autowired
	@Resource(name="MenuServiceDAO")  
	private MenuServiceDAO menuServiceDAO; 
	
    /**
     * 좌측의 트리 메뉴 셋팅을 위한 메뉴테이블의 데이터을 가지고 온다.
     */
    public List<ElementoMenu> getMenu(){
       // Session session = null;
        List<ElementoMenu> retval = null;
        MSFSysm0100BM user = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
            try {
            
            	retval = getMenuProfiless(null, user);
            }
            catch (Exception ex) {
                logger.error("EXCEPTION calling getMenu(): "+ex, ex);
            }
            finally {
                
            }
        return retval;
    }	
    
    private List<ElementoMenu> getMenuProfiless (String idCategory, MSFSysm0100BM user){
        List<ElementoMenu> retval = new ArrayList<ElementoMenu>();
         
        SysIfSysm0200VO srhSysm0200VO = new SysIfSysm0200VO();
        SysIfSysm0100SrhVO srhSysm0100 = new SysIfSysm0100SrhVO();
        SysIfSysm0300VO msfSysm0300VO = new SysIfSysm0300VO();
 
        try {
 
        	//TODO SYSDIVCD 은 전체적용으로 손볼것.
        	srhSysm0100.setSysDivCd("EXTERM00");
        	srhSysm0100.setUsrId(user.getUsrId());
        	
           if (idCategory != null) { 
        	   srhSysm0100.setIdCategory(idCategory) ;
           } else {
        	   srhSysm0100.setIdCategory("TT") ;
           }
        	
        	List<SysIfSysm0200VO>  list  =  menuServiceDAO.getMenuSysm0400(srhSysm0100);
        	 
            for (SysIfSysm0200VO mnu : list) {
                if ( mnu!=null ) { 
                    String title = MSFServerUtils.getLocalizedMessage(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest(), 
                            "title_"+mnu.getMnuCd(), mnu.getMnuNm());
                 //   String category = null;
                 //   if (mnu.getAdmMenu() != null) {
                   //     category = mnu.getAdmMenu().getMnuCd();
                 //   }
                    //Evaluate flags: in case of many group assignement, return true if we have true in at least one assignement
                    boolean seInsert = false;
                    boolean seUpdate = false;
                    boolean seDelete = false;
                    boolean seSearch = false;
                    boolean sePrint  = false;
                    Set<SysIfSysm0400VO> admMenuSysm0400 = mnu.getAdmMenuSysm0400();
                    Iterator<SysIfSysm0400VO> iterMenuSysm0400 = admMenuSysm0400.iterator();
                    
                    while ( iterMenuSysm0400.hasNext() ) {
                        SysIfSysm0400VO admMenuProfile = iterMenuSysm0400.next(); 
                        if ( MSFSharedUtils.convertStringToBoolean(admMenuProfile.getMnuAuthGrPScnInptYn()) ) { //등록
                            seInsert = true;
                        }
                        if ( MSFSharedUtils.convertStringToBoolean(admMenuProfile.getMnuAuthGrPScnRevnYn()) ) {//수정
                            seUpdate = true;
                        }
                        if ( MSFSharedUtils.convertStringToBoolean(admMenuProfile.getMnuAuthGrPScnDelYn()) ) {//삭제
                            seDelete = true;
                        }
                        if ( MSFSharedUtils.convertStringToBoolean(admMenuProfile.getMnuAuthGrPScnInqyYn()) ) { //조회
                        	seSearch = true;
                        }
                        if ( MSFSharedUtils.convertStringToBoolean(admMenuProfile.getMnuAuthGrPScnPrtYn()) ) { //출력
                        	sePrint = true;
                        }
                    }
                    if (mnu.getRowCnt() == 1) {
	                    ElementoMenu menu = new ElementoMenu(
	                    		  mnu.getSysDivCd() 
	                            , mnu.getMnuCd() 
	                            , mnu.getHhrkMnuCd()    
	                            , mnu.getMnuNm()    
	                            , mnu.getMnuIcn()  
	                            , mnu.getMnuTmbl() 
	                            , mnu.getMnuAuthFrmCd() 
	                            , mnu.getMnuTipNm() 
	                            , mnu.getMnuScnFrmPkgNm() 
	                            , mnu.getMnuPrntYn() 
	                            , mnu.getMnuPrntOrd()  
	                            , mnu.getUseYn() 
	                            , mnu.getMnuEpln()   
	                            ,seInsert 
	                            ,seUpdate 
	                            ,seDelete
	                            ,seSearch
	                            ,sePrint);
	                    retval.add(menu);
                 }
                  //  retval.addAll(getMenuProfiless(mnu.getMnuCd(), user));
                }
            }
        } catch (Exception ex) {
            logger.error("EXCEPTION calling getMenuProfiless(): "+ex, ex);
        }
        return retval;
    }

}
