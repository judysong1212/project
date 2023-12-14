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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnOrder;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.server.vo.system.AdmDataHistory;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.MSFDaoConstants;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
//import com.app.smrmf.core.msfmainapp.server.hibernate.TransactionManager;

public class DataHistoryCustomServiceImpl  implements MSFDaoConstants, MSFConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(DataHistoryCustomServiceImpl.class);

    public DataHistoryCustomServiceImpl() {
    }

    public PagingLoadResult<BaseModel> getList(ServiceParameters serviceParameters) throws MSFException {

        String method = MSFConfiguration.CUSTOM_SERVICE_DATA_HISTORY_LIST;
        PagingLoadResult<BaseModel> retval = null;
        List<BaseModel> result = new ArrayList<BaseModel>();
    //    TransactionManager tm = new TransactionManager();

        try {

            //Sysm0100VO          user             = serviceParameters.getUser();
            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
            String            clsName         = serviceParameters.getClsName();

            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
            String idValue = (String)MSFServerUtils.getFilterValue(columnFilters, "primaryKey");

            //Get Hibernate session
       //     Session session = tm.getSession();

            boolean isIdSearch = MSFSharedUtils.paramNotNull(idValue);

            String hql = 
                "SELECT h " +
                "  FROM " + AdmDataHistory.class.getName() + " h " +
                " WHERE h.daoName   = :dao_name " +
                (isIdSearch ? " AND h.primaryKey = :id_value " : "") +
                "ORDER BY h.datetime, h.primaryKey " +
                "";
      //      Query query = session.createQuery(hql);
//            query.setString("dao_name", daoName);
//            if ( isIdSearch ) {
//                query.setString("id_value",  idValue);
//            }

            //Get list of History records
         //   @SuppressWarnings("unchecked")
         //   List<AdmDataHistory> list = query.list();

//            for (AdmDataHistory admDataHistory : list) {
//
//                //Extract dao instance from data stored. Dao is an instance detached from Hibernate
//                Blob blob = admDataHistory.getDataStored();
//                Object dao = HibernateUtils.getObjectFromBlob(blob);
//                DataHistoryBM dataHistoryBM = BeanCopyUtils.getDataHistoryBMFromAdmDataHistory(admDataHistory, dao);
//                //BaseModel bm = new BaseModel();
//                //ReflectionUtils.flattenBaseModel(dataHistoryBM, bm, null);
//                BaseModel bm = ReflectionUtils.flattenDataHistoryBM(dataHistoryBM, tableAttributes);
//                result.add(bm);
//
//            }
//
//            pagingValues.totalRecordCount = list!=null ? list.size() : 0;
//            retval = new BasePagingLoadResult<BaseModel>(result, pagingValues.start, pagingValues.totalRecordCount);

        } catch (Exception ex) {
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        } finally {
            //Remember to close Session
        //    tm.closeSession();
        }

        return retval;
    }

    /**
     * Restituisce in baseModel con la user e la data di inserimento / variazione
     *                              
     * @param serviceParameters
     * @return
     * @throws MSFException
     */
    public BaseModel getSummaryInfo(ServiceParameters serviceParameters) throws MSFException {
        String method = MSFConfiguration.CUSTOM_SERVICE_DATA_HISTORY_SUMMARY_INFO;
        BaseModel result  = null;
       
      //  TransactionManager tm = new TransactionManager();

        try {

            //Sysm0100VO          user             = serviceParameters.getUser();
            result = (BaseModel) serviceParameters.getDataObjects().get(0);;
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            String            clsName         = serviceParameters.getClsName();
            String idValue = (String)MSFServerUtils.getFilterValue(columnFilters, "primaryKey");

            //Get Hibernate session
        //    Session session = tm.getSession();

            boolean isIdSearch = MSFSharedUtils.paramNotNull(idValue);
            if (isIdSearch) {
                String hqlInsert = 
                    " SELECT u." + ATTR_AdmUtenti_username  + 
                    "       ,h."  + ATTR_AdmDataHistory_datetime +
                    "   FROM " + CLASS_AdmDataHistory + " h " +
                    "   left outer join h."+ ATTR_AdmDataHistory_admUser + " as u " +
                    "  WHERE h.daoName   = :dao_name " +
                    "    AND h.primaryKey = :id_value "  +
                    "    AND h." + ATTR_AdmDataHistory_activityOnDb + " = '" + ActionDatabase.INSERT +"'" ;

                String hqlUpdate = 
                    " SELECT u." + ATTR_AdmUtenti_username  + 
                    "       ,h."  + ATTR_AdmDataHistory_datetime +
                    "   FROM " + CLASS_AdmDataHistory + " h " +
                    "   left outer join h."+ ATTR_AdmDataHistory_admUser + " as u " +
                    "  WHERE h.daoName   = :dao_name " +
                    "    AND h.primaryKey = :id_value  " +
                    "    AND h." + ATTR_AdmDataHistory_activityOnDb + " = '" + ActionDatabase.UPDATE +"'" +
                    "    AND h." + ATTR_AdmDataHistory_datetime + " = ( " +
                    "                SELECT MAX(h1."+ ATTR_AdmDataHistory_datetime + ")" +
                    "                  FROM " + CLASS_AdmDataHistory + " h1 " +
                    "                 WHERE h.daoName   = h1.daoName " +
                    "                   AND h.primaryKey = h1.primaryKey  " +
                    "                   AND h1." + ATTR_AdmDataHistory_activityOnDb + " = '" + ActionDatabase.UPDATE +"'" +
                    "    )" +
                    "";

//                Query query = session.createQuery(hqlInsert);
//                query.setString("dao_name", daoName);
//                query.setString("id_value",  idValue);
//                
//                Object[] obj = (Object[]) query.uniqueResult();
//                if (obj != null){
//                   result.set(DATA_HISTORY_USER_INSERT, (String)obj[0]);
//                   result.set(DATA_HISTORY_DATE_INSERT, (Date)obj[1]);
//                }
//                
//                query = session.createQuery(hqlUpdate);
//                query.setString("dao_name", daoName);
//                query.setString("id_value",  idValue);

//                obj = (Object[]) query.uniqueResult();
//                if (obj != null){
//                   result.set(DATA_HISTORY_USER_UPDATE, (String)obj[0]);
//                   result.set(DATA_HISTORY_DATE_UPDATE, (Date)obj[1]);
//                }
            }
        }
        catch (Exception ex) {
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        } finally {
            //Remember to close Session
         //   tm.closeSession();
        }

        return result;
    }

}
