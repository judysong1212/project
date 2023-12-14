package com.app.smrmf.core.msfmainapp.server.utils;

import java.io.InputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
 
import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.utils.SmrmfUtils;
import org.msf.utils.TimingInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ComparableBaseModel;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ListColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.SimpleColumnFilter;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFErrorMessage;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.server.service.dao.LoginServiceDAO;
import com.app.smrmf.core.msfmainapp.server.vo.system.AdmTraceUser;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.sysm.server.vo.SysIfSysm0100VO;
import com.extjs.gxt.ui.client.data.BaseModel;

public class GenericDaoUtils {

    private static final Logger logger = LoggerFactory.getLogger(GenericDaoUtils.class);
    
//    @Autowired
//    @Resource(name="SysmIfHist0100DAO")
//    private static SysmIfHist0100DAO hist0100DAO; 
    
	@Autowired
	@Resource(name="LoginServiceDAO")  
	private static LoginServiceDAO loginServiceDAO; 
 
//    public static PagingLoadResult<BaseModel> getListGenericObjectsMap(
//            ServiceParameters serviceParameters) {
//
//        TimingInfo millisBeginMethod = SmrmfUtils.startTiming(logger);
//
//        PagingLoadResult<BaseModel> retval = null;
//
//        try {
//
//            //Get some values from Service Parameters
//            String            className        = serviceParameters.getClsName();        //com.app.exterms.basis.model.dao.Jobs
//            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();  //db_Table
//            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();    //검색조건필터링 .
//            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();     //오더링 정렬 
//            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();  //페이지 기본셋팅을 위한 부분 확인 
//
//            retval = 
//                getListGenericObjectsMapWithParameters(
//                        className,
//                        tableAttributes,
//                        columnFilters,
//                        columnOrders,
//                        pagingLoadConfig);
//
//        } catch (Exception ex) {
//            //Return operation exception
//            throw MSFServerUtils.getOperationException("getListGenericObjectsMapWithParameters()", ex, logger);
//        }
//
//        SmrmfUtils.endTiming(logger, millisBeginMethod, "Method");
//
//        return retval;
//    }
// 
//    public static void prepareParamsForListCustomSelect(
//            String            className,
//            ColumnAttribute[] tableAttributes,
//            IColumnFilter     columnFilters,
//            StringBuffer      hqlFrom,
//            StringBuffer      hqlWhere,
//            List<Object>      whereBindings,
//            List<String>      aliases) {
//
//        TimingInfo millisBeginMethod = SmrmfUtils.startTiming(logger);
//
//        try {
//
//            //Create FROM clause with outer joins for associated entities
//            hqlFrom.append(" " + className + "  as m ");
//            String idPropertyName = getObjectIdName(className);
//            String joinClause = MSFServerUtils.getAliasesAsString(tableAttributes, idPropertyName, false, aliases);
//            if ( MSFSharedUtils.paramNotNull(joinClause) ) {
//                hqlFrom.append(joinClause);
//            }
//
//            //Define columns and aliases from table attributes
//            MSFServerUtils.getSelectAttributeNames(tableAttributes, aliases);
//
//            //Add where clause from filters
//            String whereClause = MSFServerUtils.getWhereClauseAsString(columnFilters, whereBindings, tableAttributes);
//            if ( MSFSharedUtils.paramNotNull(whereClause) ) {
//                hqlWhere.append(whereClause);
//            }
//
//        } catch (Exception ex) {
//            //Return operation exception
//            throw MSFServerUtils.getOperationException("prepareParamsForListGenericObjectMapWithParameters()", ex, logger);
//        }
//
//        SmrmfUtils.endTiming(logger, millisBeginMethod, "Method");
//
//    }
//
//    public static PagingLoadResult<BaseModel> getListGenericObjectsMapWithParameters(
//            String            className,
//            ColumnAttribute[] tableAttributes,
//            IColumnFilter     columnFilters,
//            List<ColumnOrder> columnOrders,
//            PagingLoadConfig  pagingLoadConfig) {
//
//        TimingInfo millisBeginMethod = SmrmfUtils.startTiming(logger);
//
//        PagingLoadResult<BaseModel> retval = null;;
//
//        try {
//             
//            //Prepare variables to create query using hql
//            StringBuffer hqlFrom   = new StringBuffer();
//            StringBuffer hqlWhere  = new StringBuffer();
//            StringBuffer hqlOrder  = new StringBuffer();
//            List<Object> whereBindings = new ArrayList<Object>();
//            List<String> aliases       = new ArrayList<String>();
//
//            prepareParamsForListCustomSelect(
//                    className, tableAttributes, columnFilters, 
//                    hqlFrom, hqlWhere, whereBindings, aliases);
//
////            //Create FROM clause with outer joins for associated entities
////            hqlFrom.append(" " + className + "  as m ");
////            String idPropertyName = getObjectIdName(className);
////            String joinClause = MSFServerUtils.getAliasesAsString(tableAttributes, idPropertyName, false, aliases);
////            if ( MSFSharedUtils.paramNotNull(joinClause) ) {
////                hqlFrom.append(joinClause);
////            }
//
////            //Define columns and aliases from table attributes
////            MSFServerUtils.getSelectAttributeNames(tableAttributes, aliases);
//
//            //Get paging configuration
//            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
//
////            //Add where clause from filters
////            String whereClause = MSFServerUtils.getWhereClauseAsString(columnFilters, whereBindings, tableAttributes);
////            if ( MSFSharedUtils.paramNotNull(whereClause) ) {
////                hqlWhere.append(whereClause);
////            }
//
//            //Execute query and get values as PagingLoadResult
//            String[] idAttrNames = getObjectIdAttrNames(className);
//            retval = HibernateUtils.getListCustomSelect(
//                    pagingValues, tableAttributes, hqlFrom, hqlWhere, hqlOrder, whereBindings, idAttrNames);
//
//        } catch (Exception ex) {
//            //Return operation exception
//            throw MSFServerUtils.getOperationException("getListLiveGenericObjectsUsingHQLWithParameters()", ex, logger);
//        }
//
//        SmrmfUtils.endTiming(logger, millisBeginMethod, "Method");
//
//        return retval;
//    }
//
//    public static PagingLoadResult<BaseModel> getListCustomSelect(
//            PagingValues pagingValues, ColumnAttribute[] columnAttributes, StringBuffer hqlFrom, 
//            StringBuffer hqlWhere, StringBuffer hqlOrder, List<Object> whereBindings, String[] idAttrNames ) {
//
//        TimingInfo millisBeginMethod = SmrmfUtils.startTiming(logger);
//
//        PagingLoadResult<BaseModel> retval = null;
//        Session session = null;
//        List<BaseModel> result = new ArrayList<BaseModel>();
//        StringBuffer hqlSelect = new StringBuffer();
//        StringBuffer hqlCount  = new StringBuffer();
////        TransactionManager tm = new TransactionManager();
//
//        try {
//
//            //Get Hibernate session
// //           session = tm.getSession();
//
//            //Calculate custom order by
//            TimingInfo millisBeginCustomOrder = SmrmfUtils.startTiming(logger);
//            if ( pagingValues.columnOrders!=null && pagingValues.columnOrders.size()>0 ) {
//                for (ColumnOrder columnOrder : pagingValues.columnOrders) {
////                  String attributeName = pagingValues.columnOrders.get(0).getAttributeName();
////                  String orientation   = pagingValues.columnOrders.get(0).getOrientation();
//                    String attributeName = columnOrder.getAttributeName();
//                    String orientation   = columnOrder.getOrientation();
//                    String aliasName = MSFSharedUtils.replace(attributeName,".","$");
//                    for ( int i=0 ; i<columnAttributes.length ; i++ ) {
//                        if ( aliasName.equals(columnAttributes[i].getName()) ) {
//                            attributeName = columnAttributes[i].getSelectName();
//                            if ( attributeName!=null && attributeName.toLowerCase().indexOf("select")<0 ) {
//                                boolean isDefaultOrderPresent = MSFSharedUtils.paramNotNull(hqlOrder);
//                                hqlOrder.append((isDefaultOrderPresent?", ":"")+attributeName+" "+orientation);
//                            }
//                            break;
//                        }
//                    }
//                }
//            }
//            SmrmfUtils.endTiming(logger, millisBeginCustomOrder, "CustomOrder");
//
//            //Create select statement from select attributes
//            hqlSelect.append("SELECT new map(");
//            for ( int i=0 ; i<columnAttributes.length ; i++ ) {
//                if (!MSFSharedUtils.isNullAsString(columnAttributes[i].getSelectName())) {
//                    hqlSelect.append( (i==0?" ":",") + columnAttributes[i].getSelectName() + " as " + columnAttributes[i].getName() );
//                }
//            }
//            hqlSelect.append("       ) ");
//
//            //Create select count statement
//            hqlCount.append("SELECT count(*) ");
//
//            if ( MSFSharedUtils.paramNotNull(hqlFrom.toString()) ) {
//                hqlSelect.append(" FROM ").append(hqlFrom);
//                hqlCount.append( " FROM ").append(hqlFrom);
//            }
//
//            if ( MSFSharedUtils.paramNotNull(hqlWhere.toString()) ) {
//                hqlSelect.append(" WHERE ").append(hqlWhere);
//                hqlCount.append( " WHERE ").append(hqlWhere);
//            }
//
//            //Get total record count
//            if ( pagingValues.executeRecordCount ) {
//                //Create a count query, using where clause if not null
//                Query queryCount = session.createQuery(hqlCount.toString());
//                //Bind parameter values to where clause
//                for ( int i=0 ; i<whereBindings.size() ; i++ ) {
//                    Object value = whereBindings.get(i);
//                    queryCount.setParameter("p"+i, value);
//                }
//                //Execute query that returns a single value
//                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
//                Object objResult = queryCount.uniqueResult();
//                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
//                pagingValues.totalRecordCount = ((Long) objResult).intValue();
//                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
//            }
//
//            //Add order clause from columnOrders otherwise apply a custom order by
//            if ( MSFSharedUtils.paramNotNull(hqlOrder) ) {
//                hqlSelect.append(" ORDER BY ").append(hqlOrder);
//            }
//
//            //Create query
//            Query query = session.createQuery(hqlSelect.toString());
//
//            //Bind parameter values to where clause
//            for ( int i=0 ; i<whereBindings.size() ; i++ ) {
//                Object value = whereBindings.get(i);
//                query.setParameter("p"+i, value);
//            }
//
//            //Apply paging
//            if (pagingValues.start > 0) {
//                query.setFirstResult(pagingValues.start);
//            }
//            if (pagingValues.offsetLimit > 0) {
//                query.setMaxResults(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
//            }
//
//            //Execute query and convert to BaseModel list
//            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
//            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list = query.list();
//            Iterator<Map<String, Object>> iter = list.iterator();
//            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");
//
//            TimingInfo millisBeginConvertListToBM = SmrmfUtils.startTiming(logger);
//            while ( iter.hasNext() ) {
//                Map<String, Object> map = (Map<String, Object>) iter.next();
//                String idValue = HibernateUtils.getIdValueAsString(idAttrNames, map);
//                BaseModel bm = new BaseModel();
//
//                //bm.setProperties(map);
//                for ( int i=0 ; i<columnAttributes.length ; i++ ) {
//                    Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
//                            map.get(columnAttributes[i].getName()), columnAttributes[i].getType());
//                    bm.set(columnAttributes[i].getName(), baseModelValue);
//                }
//
//                bm.set(TableDef.ID_PROPERTY_NAME, idValue);
//                result.add(bm);
//            }
//            SmrmfUtils.endTiming(logger, millisBeginConvertListToBM, "ConvertListToBM");
//
//            retval = new BasePagingLoadResult<BaseModel>(result, pagingValues.start, pagingValues.totalRecordCount);
//
//        }
//        catch (Exception ex) {
//            //Return operation exception
//            throw MSFServerUtils.getOperationException("getListCustomSelect()", ex, logger);
//        }
//        finally {
//            //Always remember to close Session
//           // tm.closeSession();
//        }
//
//        SmrmfUtils.endTiming(logger, millisBeginMethod, "Method");
//
//        return retval;
//
//    }
//
//    public static BaseModel readGenericObject(
//            String className, BaseModel object, 
//            ColumnAttribute[] tableAttributes, String associationAttrName, String filterAttrName) throws MSFException {
//
//        BaseModel result = null;
// //       TransactionManager tm = new TransactionManager();
//
//        try {
//
//            //Get Hibernate session
//  //          Session session = tm.getSession();
//
//            //Convert BaseModel to Dao
//            Object obj = ReflectionUtils.convertBaseModelToObject(className, object);
//
//            //If an associationAttrName is present, this means we must return the Dao 
//            //associated to main object (for example used with the LOV)
//            if ( MSFSharedUtils.paramNotNull(associationAttrName) ) {
//                String nameToUpperCase = MSFSharedUtils.checkCase(associationAttrName);
//                Method assocMethod = ReflectionUtils.findMethod(obj, "get" + nameToUpperCase, ReflectionUtils.EMPTY_TYPES);
//                if ( assocMethod!=null ) {
//                    obj = ReflectionUtils.getProperty(associationAttrName, obj);
//                    className = assocMethod.getReturnType().getName();
//                }
//            }
//
//            if ( MSFSharedUtils.paramNull(filterAttrName) ) {
//
//                //Look for object by Id
//
//                //Get Dao ID and check if it is not null
//                Object idValue = obj!=null ? HibernateUtils.getObjectIdValue(obj) : null;
//                if ( idValue==null ) {
//                    MSFException ex = MSFServerUtils.getValidationException(null, new MSFErrorMessage(null, null, MSFErrorMessage.ERRCODE_ID_NULL, null), logger);
//                    throw ex;
//                }
//
//                BaseModel bm = ReflectionUtils.convertObjectToBaseModel(obj, tableAttributes);
//                result = reloadObjectById(className, bm, tableAttributes);
////                //Get Dao
////                //Object dao = readGenericObjectById(className, idValue, false);
////                Object dao = session.get(className, (Serializable)idValue);
////
////                //Convert Dao to BaseModel
////                result = ReflectionUtils.convertObjectToBaseModel(dao, tableAttributes);
//
//            } else {
//
//                //Look for object using a filter on onother attribute
//
//                //Get filter value and check if it is not null
//                Object filterValue = ReflectionUtils.getProperty(filterAttrName, obj);
//                if ( filterValue==null ) {
//                    MSFException ex = MSFServerUtils.getValidationException(null, new MSFErrorMessage(null, null, MSFErrorMessage.ERRCODE_ID_NULL, null), logger);
//                    throw ex;
//                }
//
//                //Get Dao
//
//                //Object dao = readGenericObjectById(className, idValue, false);
//                String hql =
//                    "SELECT m " +
//                    "  FROM " + className + " m " +
//                    " WHERE m." + filterAttrName +" = :filter_value ";
//   //             Query query = session.createQuery(hql);
//    //            query.setParameter("filter_value", filterValue);
//
//                //Get object from query that must return only one record
//   //             Object dao = query.uniqueResult();
//
//                //Convert Dao to BaseModel
//    //            result = ReflectionUtils.convertObjectToBaseModel(dao, tableAttributes);
//
//            }
//
//
//        }
//        catch (Exception ex) {
//            //Return operation exception
//            throw MSFServerUtils.getOperationException("readGenericObject()", ex, logger);
//        }
//        finally {
//            //Remember to close Session
//    //        tm.closeSession();
//        }
//        return result;
//    }
//
//    public static Object readGenericObjectById(
//            String className, Object idValue, boolean clone, boolean deep) throws MSFException {
//
//        Object result = null;
//    //    TransactionManager tm = new TransactionManager();
//
//        try {
//
//            //Get Hibernate session
//  //          Session session = tm.getSession();
//
//            //Get object with given ID
//            //We use a custom HQL query to perform (if necessary) a fetch of associated objects in one step
//            //result = session.get(className, (Serializable)id);
//            PersistentClass pc = getPersistentClass(className);
//            String idName = getIdentifierPropertyName(pc);
//
//            String hql =
//                "SELECT m " +
//                "  FROM " + className + " m " +
//                "";
//            if ( deep ) {
//                @SuppressWarnings("unchecked")
//                Iterator<Property> iterator = pc.getPropertyIterator();
//                while ( iterator.hasNext() ) {
//                    Property property = iterator.next();
//                    String propertyName = property.getName();
//                    Value propertyValue = property.getValue();
//                    if ( propertyValue!=null && propertyValue instanceof ToOne ) {
//                        hql += "  left outer join fetch m." + propertyName + " as a_" + propertyName;
//                    }
//                }
//            }
//            hql +=
//                " WHERE m." + idName +" = :id_value ";
////            Query query = session.createQuery(hql);
////            query.setParameter("id_value", idValue);
////
////            //Get object from query that must return only one record
////            result = query.uniqueResult();
////
////            if ( clone ) {
////                Object clonedResult = BeanCopyUtils.clone(result);
////                result = clonedResult;
////            }
//
//        }
//        catch (Exception ex) {
//            //Return operation exception
//            throw MSFServerUtils.getOperationException("readGenericObjectById()", ex, logger);
//        }
//        finally {
//            //Remember to close Session
//           // tm.closeSession();
//        }
//        return result;
//    }
//
//    public static BaseModel reloadObjectById(String className, BaseModel bm, ColumnAttribute[] tableAttributes) {
//
//        BaseModel result = null;
//        String[] idAttrNames  = getObjectIdAttrNames(className);
//        IColumnFilter filters = getIdValueAsFilter(idAttrNames, bm.getProperties());
//
//        PagingLoadResult<BaseModel> plr = getListGenericObjectsMapWithParameters(
//                className, 
//                tableAttributes, 
//                filters, 
//                null, 
//                null);
//
//        if (plr != null) {
//            List<BaseModel> lbm = plr.getData();
//            if (lbm != null) {
//                if (lbm.size() > 0) {
//                    result = lbm.get(0);
//                }
//            }
//        }
//
//        return result;
//    }

    /**
     * Perform an INSERT / UPDATE / DELETE operation on a persistent object.
     * The steps done from the procedure are the following:
     *   1) read object
     *   2) clone object before doing changes
     *   3) update or create object from base model
     *   4) check object consistency (we can add check INSERT on an existing object with same PK)
     *   5) insert history
     *   6) save/update/delete object
     *   
     * @param className
     * @param genericObject
     * @param actionDatabase
     * @param user
     * @return BaseModel
     * @throws MSFException
     */
    public static BaseModel activityOnGenericObject(
            String className, 
            BaseModel genericObject, 
            ActionDatabase actionDatabase, 
            ColumnAttribute[] tableAttributes, 
            MSFSysm0100BM user,
            Boolean reloadData) throws MSFException {

        return activityOnGenericObject(
                className, 
                genericObject, 
                actionDatabase, 
                tableAttributes, 
                user,
                reloadData,
                false);

    }

    public static BaseModel activityOnGenericObject(
            String className, 
            BaseModel genericObject, 
            ActionDatabase actionDatabase, 
            ColumnAttribute[] tableAttributes, 
            MSFSysm0100BM user,
            Boolean reloadData,
            Boolean noHistory) throws MSFException {

        TimingInfo millisBeginMethod = SmrmfUtils.startTiming(logger);

        //Long result = new Long(1);
        BaseModel result    = null;
        Object oldDao      = null;
        Object newDao      = null;
        Object detachedDao = null;
     //   TransactionManager tm = new TransactionManager();

        try {

            //Get Hibernate session and start a new transaction
        //    Session session = tm.getSession();
       //     tm.initTransaction();

            // 1) Convert BaseModel to DAO to get its ID and read current persistent object
//            TimingInfo millisBeginConvertBMToObj = SmrmfUtils.startTiming(logger);
//            Object tmpDao = ReflectionUtils.convertBaseModelToObject(className, genericObject);
//            SmrmfUtils.endTiming(logger, millisBeginConvertBMToObj, "ConvertBMToObj");
//            Object idValue = HibernateUtils.getObjectIdValue(tmpDao);
//            if ( idValue!=null ) {
//                TimingInfo millisBeginGetOldDao = SmrmfUtils.startTiming(logger);
//           //     oldDao = session.get(className, (Serializable)idValue);
//           //     session.flush();
//                SmrmfUtils.endTiming(logger, millisBeginGetOldDao, "GetOldDao");
//            }
//
//            // 2), 3) clone object to have a non-persistent copy to store in History and update values
//            //    INSERT: simply take the object created from base model
//            //    UPDATE: create a detached copy, update values in persistent copy
//            //    DELETE: create a detached copy, no need to update values in persistent copy to delete
//            switch (actionDatabase) {
//            case INSERT:
//                detachedDao = tmpDao;
//                newDao      = tmpDao;
//                break;
//            case UPDATE:
//                TimingInfo millisBeginCloneDaoUpd = SmrmfUtils.startTiming(logger);
//                detachedDao = BeanCopyUtils.clone(oldDao, className);
//                SmrmfUtils.endTiming(logger, millisBeginCloneDaoUpd, "CloneDaoUpd");
//                newDao      = oldDao;
//                TimingInfo millisBeginUpdateDaoFromBM = SmrmfUtils.startTiming(logger);
//                ReflectionUtils.updatePersistentObjectFromBaseModel(newDao, tmpDao, className, genericObject);
//                SmrmfUtils.endTiming(logger, millisBeginUpdateDaoFromBM, "UpdateDaoFromBM");
//                break;
//            case DELETE:
//                TimingInfo millisBeginCloneDaoDel = SmrmfUtils.startTiming(logger);
//                detachedDao = BeanCopyUtils.clone(oldDao, className);
//                SmrmfUtils.endTiming(logger, millisBeginCloneDaoDel, "CloneDaoDel");
//                newDao      = oldDao;
//                break;
//            }
//
//            // 4) Perform validation on DAO instance. In case of errors exit with an MSFValidationException
//            TimingInfo millisBeginCheckDao = SmrmfUtils.startTiming(logger);
//            if ( actionDatabase==ActionDatabase.INSERT || actionDatabase==ActionDatabase.UPDATE || actionDatabase==ActionDatabase.DELETE ) {
//                List<MSFErrorMessage> errlist = new ArrayList<MSFErrorMessage>();
//                checkPersistentObjectConsistency(oldDao, newDao, tmpDao, actionDatabase, errlist);
//                if ( errlist!=null && errlist.size()>0 ) {
//                    //Return operation exception
//                    throw MSFServerUtils.getValidationException("activityOnGenericObject()", errlist, logger);
//                }
//            }
//            SmrmfUtils.endTiming(logger, millisBeginCheckDao, "CheckDao");
//
//            //Set username on DAO, if possible
//            ReflectionUtils.setUsername(user, newDao);
//
//            // 5) Perform requested operation on DAO
//            TimingInfo millisBeginSaveUpdDelDao = SmrmfUtils.startTiming(logger);
//            switch (actionDatabase) {
//            case INSERT: 
//           //     session.save(newDao); 
//            //    session.flush();
//                break;
//            case UPDATE: 
//            //    session.update(newDao); 
//            //    session.flush();
//                break;
//            case DELETE: 
//             //   session.delete(newDao); 
//             //   session.flush();
//                break;
//            }
//            SmrmfUtils.endTiming(logger, millisBeginSaveUpdDelDao, "SaveUpdDelDao");
//
//            // 6) Insert detachedDao in History
//            if (noHistory==null || !noHistory) {
//                TimingInfo millisBeginHistoryDao = SmrmfUtils.startTiming(logger);
//                insertHistoryUserActivity(user, className, actionDatabase, detachedDao, true);
//                SmrmfUtils.endTiming(logger, millisBeginHistoryDao, "HistoryDao");
//            }
//
//            //Commit transaction
//       //     tm.commitTransaction();
//
//            //Convert the object saved into Basemodel 
//            TimingInfo millisBeginConvertDaoToBM = SmrmfUtils.startTiming(logger);
//            result = ReflectionUtils.convertObjectToBaseModel(newDao, tableAttributes);
//            SmrmfUtils.endTiming(logger, millisBeginConvertDaoToBM, "ConvertDaoToBM");
//
//            //Reload saved object, if necessary
//            if (reloadData!=null && reloadData && ActionDatabase.DELETE != actionDatabase) {
//                TimingInfo millisBeginReloadDao = SmrmfUtils.startTiming(logger);
//                BaseModel bm = reloadObjectById(className, result, tableAttributes);
//                SmrmfUtils.endTiming(logger, millisBeginReloadDao, "ReloadDao");
//                if ( bm!=null ) {
//                    result = bm;
//                }
//            }
        }
        catch (Exception ex) {
            //Rollback transaction and return operation exception
      //      tm.rollbackTransaction();
            throw MSFServerUtils.getOperationException("activityOnGenericObject()", ex, logger);
        }
        finally {
            //Always remember to close Session
        //    tm.closeSession();
        }

        SmrmfUtils.endTiming(logger, millisBeginMethod, "Method");

        return result;
    }
    
    
    /**
     * 
     * @param user
     * @param currentMethod
     * @param objectName
     * @param typeActivity
     */
    public static void tracerUserActivity(
            MSFSysm0100BM user,
            String currentMethod,
            String objectName,
            String typeActivity){
    	 
    	HashMap<String, String> msfGlobals = MSFServerUtils.getLocalidedMessages(RemoteServiceUtil.getThreadLocalConfig(), RemoteServiceUtil.getThreadLocalRequest()); 

        boolean traceEnabled = "true".equals(msfGlobals.get("PayGen.TraceUserActivity"));   //Globals.TRACE_USER_ACTIVITY
        if ( !traceEnabled ) return;

        TimingInfo millisBeginMethod = SmrmfUtils.startTiming(logger);
 
        try {
 
            SysIfSysm0100VO admUser = new SysIfSysm0100VO();
            
            admUser.setUsrId(user.getUsrId());
            
            
            admUser.setDpobCd(user.getDpobCd());
            admUser.setUsrDivCd(user.getUsrDivCd());
            

            AdmTraceUser admTraceUser = new AdmTraceUser( admUser, 
									                      new Date(), 
									                      currentMethod, 
									                      objectName, 
									                      typeActivity, 
									                      "", 
									                      "");
            
            
            // TODO 로그 인서트 부분 처리 
           
            
        }
        catch (Exception ex) {
            //Rollback transaction and return operation exception
            throw MSFServerUtils.getOperationException("tracerUserActivity()", ex, logger);
        }
        finally {
          
        }

        SmrmfUtils.endTiming(logger, millisBeginMethod, "Method");

    }
    
//TODO 차후 히스토리 추가..을 위해 수정 
    public static void insertHistoryUserActivity(
            MSFSysm0100BM user,
            String objectName,
            ActionDatabase actionDatabase,
            Object dao,
            boolean isDaoDetached){
//TODO 이부분도 수정.
//        int historizationType = MSFServerUtils.isDaoHistorizable(objectName);
//
//        if ( historizationType<=0 ) {
//            logger.debug("insertHistory, dao '"+objectName+"' must not be inserted in DataHistory");
//            return;
//        }

        if ( logger.isDebugEnabled() ) {
            logger.debug("INI.insertHistoryUserActivity(user="+user+",objectName="+objectName+",actionDatabase="+actionDatabase+",dao="+dao+",isDaoDetached="+isDaoDetached+")");
        }

     //   TransactionManager tm = new TransactionManager();
        Object detachedDao = null;
        Blob dataStored  = null;

        try {

            //Get Hibernate session and start a new transaction
          //  Session session = tm.getSession();
         //   tm.initTransaction();

            //In case of a FULL historization, we must store in the table also current Object as a Blob
            //In case of a LITE historization, current Object can be null
//TODO 이부분도 확인  
//            if ( historizationType==MSFConfiguration.HISTORIZABLE_DAO_FULL ) {
//                //If dao is already detached, use it.
//                //otherwise, in case of INSERT simply create a detached copy
//                //           in case of UPDATE or DELETE take current values from database and get a detached copy
//                if ( isDaoDetached ) {
//                    detachedDao = dao;
//                } else if ( actionDatabase==ActionDatabase.INSERT ) {
//                    detachedDao = BeanCopyUtils.clone(dao);
//                } else {
//                    //Read current values of Dao and create a detached copy to store in History
//                    //Object obj = ReflectionUtils.convertBaseModelToObject(objectName, dataObject);
//                    Object id = HibernateUtils.getObjectIdValue(dao);
//                    //Object dao = readGenericObjectById(objectName, id, true, true);
//               //     Object oldDao = session.get(objectName, (Serializable)id);
//               //     detachedDao = BeanCopyUtils.clone(oldDao);
//                }
//                dataStored  = HibernateUtils.getBlobFromObject(detachedDao);
//            } else {
//                //In case of LITE historization, we must get only the primary key that is already present
//                //in the dao, also if is not detached
//                detachedDao = dao;
//                dataStored   = null;
//            }

            //Create new History record, serializing Dao in the Blob attribute
            SysIfSysm0100VO admUser = new SysIfSysm0100VO();
            admUser.setUsrId(user.getUsrId());

 //           String idValue   = HibernateUtils.getObjectIdValueAsString(detachedDao);
 //           String tableName = HibernateUtils.getPersistentClassTableName(objectName);

//            AdmDataHistory admDataHistory = new AdmDataHistory(
//            		admUser
//                   ,new Date(System.currentTimeMillis())
//                   ,actionDatabase.toString()
//                   ,tableName
//                   ,objectName
//                   ,dataStored
//                   ,idValue);

            //Persist history record
          //  session.save(admDataHistory); 
          //  session.flush();

            //Commit transaction
          //  tm.commitTransaction();
        }
        catch (Throwable ex) {
            //Rollback transaction and return operation exception
          //  tm.rollbackTransaction();
            throw MSFServerUtils.getOperationException("insertHistoryUserActivity()", ex, logger);
        }
        finally {
            //Remember to close Session
          //  tm.closeSession();
        }

        if ( logger.isDebugEnabled() ) {
            logger.debug("END.insertHistoryUserActivity(user="+user+",objectName="+objectName+",actionDatabase="+actionDatabase+",dao="+dao+",isDaoDetached="+isDaoDetached+")");
        }
    }

    public static List<Object> getListHistoryObjects(
            String objectName,
            Object obj){

        if ( logger.isDebugEnabled() ) {
            logger.debug("INI.getHistoryObjects(objectName="+objectName+",obj="+obj+")");
        }

        List<Object> retval = new ArrayList<Object>();
      //  Session session = null;
      //  TransactionManager tm = new TransactionManager();

        try {

            //Get Hibernate session and start a new transaction
        //    session = tm.getSession();

            //Object obj = ReflectionUtils.convertBaseModelToObject(objectName, dataObject);
            //Object id = HibernateUtils.getObjectIdValue(obj);
          //  String idValue = getObjectIdValueAsString(obj);
          //  boolean isIdSearch = MSFSharedUtils.paramNotNull(idValue);

//            String hql = 
//                "SELECT h " +
//                "  FROM " + AdmDataHistory.class.getName() + " h " +
//                " WHERE h.daoName   = :dao_name " +
//                (isIdSearch ? " AND h.primaryKey = :id_value " : "") +
//                "ORDER BY h.datetime DESC, h.primaryKey " +
//                "";
//            Query query = session.createQuery(hql);
//            query.setString("dao_name", objectName);
//            if ( isIdSearch ) {
//                query.setString("id_value",  idValue);
//            }
//
//            //Get list of History records
//            @SuppressWarnings("unchecked")
//            List<AdmDataHistory> list = query.list();
//
//            for (AdmDataHistory admDataHistory : list) {
//
//                //Extract dao instance from data stored. Dao is an instance detached from Hibernate
//                Blob blob = admDataHistory.getDataStored();
//                Object dao = getObjectFromBlob(blob);
//                DataHistoryBM dataHistoryBM = BeanCopyUtils.getDataHistoryBMFromAdmDataHistory(admDataHistory, dao);
//                retval.add(dataHistoryBM);
//
//            }

        }
        catch (Exception ex) {
            throw MSFServerUtils.getOperationException("getListHistoryObjects()", ex, logger);
        }
        finally {
            //Always remember to close Session
       //     tm.closeSession();
        }

        if ( logger.isDebugEnabled() ) {
            logger.debug("END.getHistoryObjects(objectName="+objectName+",obj="+obj+")");
        }

        return retval;
    }

    @SuppressWarnings("unchecked")
    public static void checkPersistentObjectConsistency(Object oldObject, Object newObject, Object detachedObject, ActionDatabase actionDatabase, List<MSFErrorMessage> errlist) {

        //Check if the Object is a persistent class. Exit in case it is not a persistent class.
//        PersistentClass pc = getPersistentClass(detachedObject.getClass().getName());
//        if ( pc == null ) {
//            return;
//        }
//
//        //Check Identifier.
//        addErrorToList(null, errlist, checkIdentifierPropertyNull(null, pc, newObject, actionDatabase));
//
//        //Check unique in case of INSERT
//        if ( actionDatabase==ActionDatabase.INSERT && oldObject!=null ) {
//            String idValue   = HibernateUtils.getObjectIdValueAsString(detachedObject);
//            MSFErrorMessage err = new MSFErrorMessage(null, idValue, MSFErrorMessage.ERRCODE_DUPLICATE_KEY, null);
//            addErrorToList(null, errlist, err);
//        }
//
//        //Check found in case of UPDATE or DELETE
//        if ( (actionDatabase==ActionDatabase.UPDATE || actionDatabase==ActionDatabase.DELETE) && oldObject==null ) {
//            String idValue   = HibernateUtils.getObjectIdValueAsString(detachedObject);
//            MSFErrorMessage err = new MSFErrorMessage(null, idValue, MSFErrorMessage.ERRCODE_NOT_FOUND, null);
//            addErrorToList(null, errlist, err);
//        }
//
//        //Check Properties, only in case of INSERT or UPDATE and no errors fount till now.
//        if ( (actionDatabase!=ActionDatabase.INSERT && actionDatabase!=ActionDatabase.UPDATE) || 
//             (errlist!=null && errlist.size()>0) ) {
//            return;
//        }
//
//        //Check properties, only in case of INSERT or UPDATE
//        Iterator<Property> iterator = pc.getPropertyIterator();
//        while ( iterator.hasNext() ) {
//            Property property = iterator.next();
//            Object value = getPropertyValue(property, newObject);
//            String propertyName = property.getName();
//            if ( value==null ) {
//                //If value is null check if attribute is mandatory
//                boolean required = isAttributeRequired(property);
//                if ( required ) {
//                    MSFErrorMessage err = new MSFErrorMessage(property.getName(), null, MSFErrorMessage.ERRCODE_NULL, null);
//                    addErrorToList(null, errlist, err);
//                }
//            } else {
//                //If value is not-null check if it is an association to another persistent class
//                //If it is an association, associated entity ID must be filled
//                PersistentClass fkpc = getPersistentClass(value.getClass().getName());
//                if ( fkpc!=null ) {
//                    addErrorToList(null, errlist, checkIdentifierPropertyNull(propertyName, fkpc, value, ActionDatabase.UPDATE));
//                } else {
//                    //Check Value Length
//                    addErrorToList(null, errlist, checkPropertyLength(property, value));
//
//                    //If value is not-null and it is not a persistent class, check other constraints
//                    //int propertyLength = getPropertyLength(property);
//                    //int valueLength = value.toString().length();
//                    //if ( valueLength > propertyLength ) {
//                    //    MSFErrorMessage err = new MSFErrorMessage(property.getName(), MSFErrorMessage.ERRCODE_TOO_LARGE, null);
//                    //    addErrorToList(null, errlist, err);
//                    //}
//                    //TODO: ...
//                }
//            }
//        }

    }

    public static void addErrorToList(String prefix, List<MSFErrorMessage> errlist, MSFErrorMessage err) {
        if ( errlist!=null && err!=null ) {
            if ( MSFSharedUtils.paramNotNull(err.attributeName) && MSFSharedUtils.paramNotNull(prefix) ) {
                err.attributeName = prefix + TableDef.SEPARATOR_CLIENT + err.attributeName;
            }
            errlist.add(err);
        }
    }
 

    public static BaseModel getIdValueAsBaseModel(String idName, Object idValue, boolean isComposite) {
        BaseModel retval = null;
        try {
           // if ( !isComposite ) {
                retval = new ComparableBaseModel();
                retval.set(idName, idValue);
           // } else {
            	//TODO 이부분 확인 필요 HI 이용함.
               // retval = ReflectionUtils.convertObjectToBaseModel(idValue);
           // }
        } catch (Exception ex) {
            logger.error("EXCEPTION: "+ex, ex);
        }
        return retval;
    }

    public static String getIdValueAsString(String[] idAttrNames, Map<String,Object> values) {
        String retval = null;
        try {
            Map<String, Object> idMap = new HashMap<String, Object>();
            for ( int i=0 ; i<idAttrNames.length ; i++ ) {
                String key   = idAttrNames[i];
                Object value = values.get(key);
                idMap.put(key, value);
            }
            retval = ReflectionUtils.convertMapToString(idMap);
        } catch (Exception ex) {
            logger.error("EXCEPTION: "+ex, ex);
        }
        return retval;
    }

    public static IColumnFilter getIdValueAsFilter(String[] idAttrNames, Map<String,Object> values) {
        ListColumnFilter retval = new ListColumnFilter();
        try {
            for ( int i=0 ; i<idAttrNames.length ; i++ ) {
                String key   = idAttrNames[i];
                Object value = values.get(key);
                retval.addFilter(new SimpleColumnFilter(key, (Serializable) value, SimpleColumnFilter.OPERATOR_EQUALS));
            }
        } catch (Exception ex) {
            logger.error("EXCEPTION: "+ex, ex);
        }
        return retval;
    }
 

    public static Object getObjectFromBlob(Blob blob) {

        if ( blob == null ) {
            return null;
        }

        Object obj = null;
        try {
            InputStream bis = blob.getBinaryStream();
            obj = MSFServerUtils.unzipObject(bis);
            bis.close();
        } catch(Exception ex) {
            logger.error("EXCEPTION getObjectFromBlob: "+ex);
        }
        return obj;
    }
}
