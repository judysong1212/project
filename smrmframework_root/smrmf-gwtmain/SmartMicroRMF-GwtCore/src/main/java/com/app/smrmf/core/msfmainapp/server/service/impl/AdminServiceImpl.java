/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.server.service.impl;

 

import java.util.ArrayList;
import java.util.List;

import javax.management.Query;

import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.app.smrmf.core.msfmainapp.client.admin.dto.DatabaseObject;
import com.app.smrmf.core.msfmainapp.client.admin.dto.ElementoMenu;
import com.app.smrmf.core.msfmainapp.client.admin.dto.VoceMenuUser;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0300DTO;
import com.app.smrmf.core.msfmainapp.client.service.system.AdminService;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.sysm.server.vo.SysIfSysm0100VO;

@Service("AdminService")  
public class AdminServiceImpl  extends AbstractCustomServiceImpl  implements AdminService {
	 
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    public List<MSFSysm0100BM> getListUsers(){
    	
    	//RpcConfigServiceServlet();  
      //  Session session = null;
        List<MSFSysm0100BM> retval = new ArrayList<MSFSysm0100BM>();
        MSFSysm0100BM user = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        if (user!=null) {
            try {
           //     session = SessionManager.currentSession();
                Query query = null;
//                query = session.createQuery(
//                        "  FROM " + MSFSysm0100VO.class.getName() +
//                        " ORDER BY cognome, nome"
             //   );
               // List<MSFSysm0100VO> list = query.list();
              //  Iterator<MSFSysm0100VO> iter = list.iterator();
//                while ( iter.hasNext() ) {
//                    MSFSysm0100VO usr = (MSFSysm0100VO) iter.next();
//                    if ( usr!=null ) {
//                        MSFSysm0100BM sysm0100 = new MSFSysm0100BM(
//                        		usr.getDpobCd(),
//                                usr.getSysDivCd(), 
//                                usr.getSysDivNm(), 
//                                usr.getUsrId(), 
//                                usr.getUsrNm(),
//                                usr.getUsrDivCd(),
//                                usr.getUsrDivNm(),
//                                usr.getDeptCd(),
//                                usr.getDeptNm(),
//                                usr.getTypOccuCd(),
//                                usr.getTypOccuNm(),
//                                usr.getPyspGrdeCd(),
//                                usr.getPyspGrdeNm(),
//                                usr.getUsrTel(), 
//                                usr.getPayrMangDeptCd(),
//                                usr.getPayrMangDeptNm(),
//                                usr.getMangeDeptCd(),
//                                usr.getMangeDeptNm(),
//                                usr.getPayrMangDeptYn(),
//                                usr.getEmail(), 
//                                usr.getPwd(), 
//                                usr.getUseYn() 
//                        );
//                        retval.add(sysm0100);
//                    }
//                }
            }
            catch (Exception ex) {
                logger.error("EXCEPTION calling getListUsers(): "+ex);
            }
            finally {
          //      SessionManager.closeSession();
            }
        }
        return retval;
    }	

    public Long activityOnUser(MSFSysm0100BM sysm0100, ActionDatabase actionDatabase) {
       // Session session = null;
      //  Transaction transaction = null;
    //	RpcConfigServiceServlet();  
        Long result = new Long(1);
        try {
        //    session = SessionManager.currentSession();
        //    transaction = session.beginTransaction();

            SysIfSysm0100VO usr = new SysIfSysm0100VO(
                    sysm0100.getDpobCd(),
                    sysm0100.getSysDivCd(), 
                    sysm0100.getUsrId(), 
                    sysm0100.getUsrNm(),
                    sysm0100.getUsrDivCd(), 
                    sysm0100.getDeptCd(),
                   // sysm0100.getTypOccuCd(),
                   // sysm0100.getPyspGrdeCd(),
                    sysm0100.getUsrTel(), 
                    sysm0100.getEmail(), 
                    sysm0100.getPwd(), 
                    sysm0100.getUseYn() ,
                    sysm0100.getTplvlDeptCd() ,
                    sysm0100.getTplvlDeptNm() ,
                    sysm0100.getPayrMangDeptCd(),
                    sysm0100.getMangeDeptCd(),
                    sysm0100.getPayrMangDeptYn(),
                    sysm0100.getYrtxInptPrcsYn(),
                    null, 
                    null,
                    null,
                    null,
                    null,
                    null,
                    sysm0100.getLockat(), sysm0100.getLogincnt(), sysm0100.getPwddate(), sysm0100.getInptDt()); // 추가 hieju_05.31 
                    

//            switch (actionDatabase) {
//            case INSERT: session.save(usr); break;
//            case UPDATE: 
//                usr.setUsrId(sysm0100.getUsrId());
//                session.update(usr);
//                break;
//            case DELETE:
//                usr.setUsrId(sysm0100.getUsrId());
//                session.delete(usr);
//                break;
//            }
//            session.flush();
//            transaction.commit();
        }
        catch (Exception ex) {
            logger.error("EXCEPTION calling activityOnUser(): "+ex);
       //     transaction.rollback();
            result = new Long(0);
        }
        finally {
        //    SessionManager.closeSession();
        }
        return result;
    }

    public List<MSFSysm0300DTO> getListaProfiles(){
      //  Session session = null;
    	//RpcConfigServiceServlet();  
        List<MSFSysm0300DTO> retval = new ArrayList<MSFSysm0300DTO>();
        MSFSysm0100BM user = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        if (user!=null) {
            try {
              //  session = SessionManager.currentSession();
                Query query = null;
//                query = session.createQuery(
//                        "  FROM " + MSFSysm0300VO.class.getName() +
//                        " ORDER BY description"
//                );
//                List<MSFSysm0300VO> list = query.list();
//                Iterator<MSFSysm0300VO> iter = list.iterator();
//                while ( iter.hasNext() ) {
//                    MSFSysm0300VO prf = (MSFSysm0300VO) iter.next();
//                    if ( prf!=null ) {
//                    	MSFSysm0300DTO profile = new MSFSysm0300DTO(
//                                prf.getSysDivCd(),
//                                prf.getAuthGrpSeilNum(),
//                                prf.getBusinDivCd(),
//                                prf.getAuthGrpNm(),
//                                prf.getGrde(),
//                                prf.getAuthGrpUseYn(),
//                                prf.getGrpEpln()
//                        );
//                        retval.add(profile);
//                    }
//                }
            }
            
            catch (Exception ex) {
                logger.error("EXCEPTION calling getListaProfiles(): "+ex);
            }
            finally {
            //    SessionManager.closeSession();
            }
        }
        return retval;
    }

    public Long activityOnProfiles(MSFSysm0300DTO profile, ActionDatabase actionDatabase) {
//        Session session = null;
//        Transaction transaction = null;
    //	RpcConfigServiceServlet();  
        Long result = new Long(1);
        try {
           // session = SessionManager.currentSession();
//            transaction = session.beginTransaction();
//
//            MSFSysm0300VO prf = new MSFSysm0300VO(  
//                     profile.getBusinDivCd(),
//                     profile.getAuthGrpNm(),
//                     profile.getGrde(),
//                     profile.getAuthGrpUseYn(),
//                     profile.getGrpEpln()
//            );
//
//            switch (actionDatabase) {
//            case INSERT: session.save(prf); break;
//            case UPDATE: 
//                prf.setAuthGrpSeilNum(profile.getAuthGrpSeilNum());
//                session.update(prf);
//                break;
//            case DELETE:
//                prf.setAuthGrpSeilNum(profile.getAuthGrpSeilNum());
//                session.delete(prf);
//                break;
//            }
//            session.flush();
//            transaction.commit();
        }
        catch (Exception ex) {
            logger.error("EXCEPTION calling activityOnProfiles(): "+ex);
        //    transaction.rollback();
            result = new Long(0);
        }
        finally {
          //  SessionManager.closeSession();
        }
        return result;
    }




 
    public List<ElementoMenu> getCategories(){
      //  Session session = null;
    	//RpcConfigServiceServlet();  
        List<ElementoMenu> retval = new ArrayList<ElementoMenu>();
        MSFSysm0100BM user = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        if (user!=null) {
            try {
               // session = SessionManager.currentSession();
                Query query = null;
//                query = session.createQuery(
//                        " from " + MSFSysm0200VO.class.getName()
//                        +   " WHERE admMenu IS NULL"
//                        +   " ORDER BY tipo, ord "
//                );
//                List<MSFSysm0200VO> list = query.list();
//                Iterator<MSFSysm0200VO> iter = list.iterator();
//                while ( iter.hasNext() ) {
//                    MSFSysm0200VO objDB = (MSFSysm0200VO) iter.next();
//                    if ( objDB!=null ) {
//
//                        ElementoMenu objClient = new ElementoMenu(
//                        		  objDB.getSysDivCd() 
//                                 , objDB.getMnuCd() 
//                                 , "EXTERM00"  //objDB.getHhrkMnuCd() 
//                                 , objDB.getMnuNm() 
//                                 , objDB.getMnuIcn()  
//                                 , objDB.getMnuTmbl() 
//                                 , objDB.getMnuAuthFrmCd() 
//                                 , objDB.getMnuTipNm() 
//                                 , objDB.getMnuScnFrmPkgNm() 
//                                 , objDB.getMnuPrntYn() 
//                                 , objDB.getMnuPrntOrd()  
//                                 , objDB.getUseYn() 
//                                 , objDB.getMnuEpln()          
//                        		 ,false, false, false,false,false 
//                        );
//                        retval.add(objClient);
//                    }
//                }
            }
            catch (Exception ex) {
                logger.error("EXCEPTION calling getCategories(): "+ex);
            }
            finally {
              //  SessionManager.closeSession();
            }
        }
        return retval;      
    }

    public Long activityOnVoceMenu(ElementoMenu elementoMenu, ActionDatabase actionDatabase) {
    	//RpcConfigServiceServlet();  
//        Session session = null;
//        Transaction transaction = null;
        Long result = new Long(1);
        try {
          //  session = SessionManager.currentSession();
//            transaction = session.beginTransaction();
//            
//            MSFSysm0200VO category = null;
//            if (elementoMenu.getHhrkMnuCd() != null) {
//                category = new MSFSysm0200VO();
//                category.setMnuCd(elementoMenu.getHhrkMnuCd());
//            }
//            
//            MSFSysm0200VO mnu = new MSFSysm0200VO( 
//                    category, 
//                    elementoMenu.getSysDivCd(),
//                    elementoMenu.getMnuCd(),
//                    elementoMenu.getHhrkMnuCd(), 
//                    elementoMenu.getMnuNm(), 
//                    elementoMenu.getMnuIcn(), 
//                    elementoMenu.getMnuTmbl(),
//                    elementoMenu.getMnuAuthFrmCd(),
//                    elementoMenu.getMnuTipNm(), 
//                    elementoMenu.getMnuScnFrmPkgNm(), 
//                    elementoMenu.getMnuPrntYn(),
//                    elementoMenu.getMnuPrntOrd(),
//                    elementoMenu.getUseYn(),
//                    elementoMenu.getMnuEpln(),
//                    null
//            );
// 
//    		
//            switch (actionDatabase) {
//            case INSERT: session.save(mnu); break;
//            case UPDATE: 
//                mnu.setMnuCd(elementoMenu.getMnuCd());
//                session.update(mnu);
//                break;
//            case DELETE:
//                mnu.setMnuCd(elementoMenu.getMnuCd());
//                session.delete(mnu);
//                break;
//            }
//            session.flush();
//            transaction.commit();
        }
        catch (Exception ex) {
            logger.error("EXCEPTION calling activityOnVoceMenu(): "+ex);
           // transaction.rollback();
            result = new Long(0);
        }
        finally {
          //  SessionManager.closeSession();
        }
        return result;
    } 

    public List<DatabaseObject> getDatabaseObjects() {
    	//RpcConfigServiceServlet();  
     //   Session session = null;
        List<DatabaseObject> retval = new ArrayList<DatabaseObject>();
        MSFSysm0100BM user = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        if (user!=null) {
            try {
            //    session = SessionManager.currentSession();
                Query query = null;
//                query = session.createQuery(
//                            " FROM " + AdmObjectDb.class.getName() + " as db"
//                        +   " AND db.tname NOT IN (SELECT noCons.objectName FROM " + AdmObjectDbConsidered.class.getName() +" as noCons)"
//                        +   " ORDER BY db.tname"
//                );
//                List<AdmObjectDb> list = query.list();
//                for (AdmObjectDb objDB : list) {
//                    if ( objDB!=null ) {
//                        DatabaseObject databaseObject = new DatabaseObject(
//                                objDB.getTname(),
//                                objDB.getTabtype()
//                        );
//                        retval.add(databaseObject);
//                    }
//                }
            }
            catch (Exception ex) {
                logger.error("EXCEPTION calling getDatabaseObjects(): "+ex);
            }
            finally {
           //     SessionManager.closeSession();
            }
        }
        return retval;      
    }

    public List<DatabaseObject> getDatabaseObjectsConsidered() {
    	//RpcConfigServiceServlet();  
        //Session session = null;
        List<DatabaseObject> retval = new ArrayList<DatabaseObject>();
        MSFSysm0100BM user = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        if (user!=null) {
            try {
           //     session = SessionManager.currentSession();
                Query query = null;
//                query = session.createQuery(
//                            " FROM " + AdmObjectDbConsidered.class.getName()
//                        +   " ORDER BY objectName"
//                );
//                List<AdmObjectDbConsidered> list = query.list();
//                Iterator<AdmObjectDbConsidered> iter = list.iterator();
//                while ( iter.hasNext() ) {
//                    AdmObjectDbConsidered objDB = iter.next();
//                    if ( objDB!=null ) {
//                        DatabaseObject databaseObject = new DatabaseObject(
//                                objDB.getObjectName(),
//                                objDB.getObjectType()
//                        );
//                        retval.add(databaseObject);
//                    }
//                }
            }
            catch (Exception ex) {
                logger.error("EXCEPTION calling getDatabaseObjectsConsidered(): "+ex);
            }
            finally {
            //    SessionManager.closeSession();
            }
        }
        return retval;      
    }

    public Long activityOnDBObject(DatabaseObject databaseObject, ActionDatabase actionDatabase) {
    	//RpcConfigServiceServlet();  
//        Session session = null;
//        Transaction transaction = null;
        Long result = new Long(1);
        try {
           // session = SessionManager.currentSession();
//            transaction = session.beginTransaction();
//
//            AdmObjectDbConsidered obj = new AdmObjectDbConsidered(
//                    databaseObject.getName(), 
//                    databaseObject.getType());
//
//            switch (actionDatabase) {
//            case INSERT: session.save(obj);   break;
//            case DELETE: session.delete(obj); break;
//            }
//            session.flush();
//            transaction.commit();
        }
        catch (Exception ex) {
            logger.error("EXCEPTION calling activityOnDBObject(): "+ex);
        //    transaction.rollback();
            result = new Long(0);
        }
        finally {
          //  SessionManager.closeSession();
        }
        return result;
    }

	public String activityOnVoceMenuUser(VoceMenuUser voceMenuUser,
			ActionDatabase actionDatabase) {
	//	RpcConfigServiceServlet();  
		// TODO Auto-generated method stub
//		  Session session = null;
//	        Transaction transaction = null;
	        String result = "0";
	        try {
	           // session = SessionManager.currentSession();
//	            transaction = session.beginTransaction();
//
//	            MSFSysm0200VO instMenu = new MSFSysm0200VO();
//	            instMenu.setMnuCd(voceMenuUser.getIdMnu());
//
//	            MSFSysm0100VO instAdmUser = new MSFSysm0100VO();
//	            instAdmUser.setUsrId(voceMenuUser.getIdUsr());
//
//	            String seIns = "0";
//	            if (voceMenuUser.getSeInsert()) seIns = "1";
//	            String seUpd = "0";
//	            if (voceMenuUser.getSeUpdate()) seUpd = "1";
//	            String seDel = "0";
//	            if (voceMenuUser.getSeDelete()) seDel = "1";
//
//	            MSFSysm0250VO mnu = new MSFSysm0250VO(
//	                    instMenu, 
//	                    instAdmUser,
//	                    seIns, 
//	                    seUpd, 
//	                    seDel, "0","0"
//	            );
//
//	            switch (actionDatabase) {
//	            case INSERT: session.save(mnu); break;
//	            case UPDATE: 
//	                mnu.setMnuCd(voceMenuUser.getMnuCd());
//	                session.update(mnu);
//	                break;
//	            case DELETE:
//	                mnu.setMnuCd(voceMenuUser.getMnuCd());
//	                session.delete(mnu);
//	                break;
//	            }
//	            session.flush();
//	            transaction.commit();
	          //  result = mnu.getMnuCd();
	        }
	        catch (Exception ex) {
	            logger.error("EXCEPTION calling activityOnVoceMenuUser(): "+ex);
	           // transaction.rollback();
	            result = "0";
	        }
	        finally {
	         //   SessionManager.closeSession();
	        }
	        return result;
	}
	
   public List<VoceMenuUser> getListaVociMenuUser(MSFSysm0100BM utente){
      //  Session session = null;
        List<VoceMenuUser> retval = new ArrayList<VoceMenuUser>();
        MSFSysm0100BM user = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        if (user!=null) {
            try {
            //    session = SessionManager.currentSession();
               // retval = getVoceMenuUsers (session, null, utente);
                retval = getVoceMenuUsers ( null, utente);
            }
            catch (Exception ex) {
                logger.error("EXCEPTION calling getListaVociMenuUser(): "+ex);
            }
            finally {
              //  SessionManager.closeSession();
            }
        }
        return retval;		
    }
   
  // private List<VoceMenuUser> getVoceMenuUsers (Session session, String idCategory, MSFSysm0100BM sysm0100){
  private List<VoceMenuUser> getVoceMenuUsers ( String idCategory, MSFSysm0100BM sysm0100){
	//  RpcConfigServiceServlet();  
       List<VoceMenuUser> retval = new ArrayList<VoceMenuUser>();
//       try {
//           Query query = null;
//           query = session.createQuery(
//                   " SELECT "
//                   +   "(SELECT put.id FROM " + AdmMenuUser.class.getName() + " as put "
//                   +   "  WHERE mnu.id = put.admMenu.id "
//                   +   "    AND put.admUser.id = :USR) as ID, "  
//                   +   " mnu, "
//                   +   " (SELECT count(*) FROM " + AdmMenuUser.class.getName() + " as put "
//                   +   "   WHERE mnu.id = put.admMenu.id "
//                   +   "     AND put.admUser.id = :USR) as SINO, " 
//                   +   " (SELECT seInsert FROM " + AdmMenuUser.class.getName() + " as put "
//                   +   "   WHERE mnu.id = put.admMenu.id "
//                   +   "     AND put.admUser.id = :USR) as SE_INSERT, "
//                   +   " (SELECT seUpdate FROM " + AdmMenuUser.class.getName() + " as put "
//                   +   "   WHERE mnu.id = put.admMenu.id "
//                   +   "     AND put.admUser.id = :USR) as SE_UPDATE, "
//                   +   " (SELECT seDelete FROM " + AdmMenuUser.class.getName() + " as put "
//                   +   "   WHERE mnu.id = put.admMenu.id "
//                   +   "     AND put.admUser.id = :USR) as SE_DELETE  "
//                   +   " from " + AdmMenu.class.getName() + " as mnu"
//                   +   (idCategory==null?"   WHERE mnu.admMenu IS NULL":"   WHERE mnu.admMenu.id = :CAT")
////                   +   "   AND mnu.tipo IS NULL"
//                   +   " ORDER BY mnu.tipo, mnu.ord "
//           );
//           query.setString("USR", sysm0100.getUsrId());
//           if (idCategory != null) {
//               query.setString("CAT", idCategory);
//           }
//           List list = query.list();
//           Iterator iter = list.iterator();
//           while ( iter.hasNext() ) {
//               Object[] objDB = (Object[]) iter.next();
//               if ( objDB!=null ) {
//                   Long yesNo = (Long)objDB[2];
//                   Boolean yesNoBoolean = false;
//                   if (yesNo != null) {
//                       if (yesNo.compareTo(Long.valueOf(1)) == 0) {
//                           yesNoBoolean = true;
//                       }
//                   }
//                   AdmMenu admMenu = (AdmMenu)objDB[1];
//                   VoceMenuUser vmu = new VoceMenuUser(
//                           objDB[0], 
//                           admMenu.getMnuCd(), 
//                           sysm0100.getUsrId(),
//                           admMenu.getMnuNm(),
//                           (admMenu.getAdmMenu()==null?null:admMenu.getAdmMenu().getMnuCd()),
//                           yesNoBoolean,
//                           MSFSharedUtils.convertLongToBoolean(((Long)objDB[3])==null?Long.valueOf(0):(Long)objDB[3]),
//                           MSFSharedUtils.convertLongToBoolean(((Long)objDB[4])==null?Long.valueOf(0):(Long)objDB[4]),
//                           MSFSharedUtils.convertLongToBoolean(((Long)objDB[5])==null?Long.valueOf(0):(Long)objDB[5])
//                   );
//                   retval.add(vmu);
//                   retval.addAll(getVoceMenuUsers(session, admMenu.getMnuCd(), sysm0100));
//               }  
//           }
//       } catch (Exception e) {
//           // TODO: handle exception
//       }
       return retval;
   }
   
	
 
}
