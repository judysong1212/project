/*
 * FrEDProject - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2009-2011, EDP Progetti S.r.l., Bolzano IT
 * 
 * http://fredproject.edp-progetti.it/license
 *
 */
package com.app.smrmf.core.msfmainapp.server.utils;


public class BeanCopyUtils {

    public static Object clone(Object obj) throws Exception {
        return clone(obj, null);
    }

    public static Object clone(Object obj, String className) throws Exception {
        if ( obj == null ) {
            return null;
        }

        if (className==null) {
            className = obj.getClass().getName();
        }
//        PersistentClass pc = HibernateUtils.getPersistentClass(className);
        Object clonedResult = Class.forName(className).newInstance();

        //Set id
//        Property idProperty = pc.getIdentifierProperty();
//        Object idValue = HibernateUtils.getPropertyValue(idProperty, obj);
//        ReflectionUtils.setProperty(idProperty.getName(), clonedResult, idValue);
//
//        //Set all other properties, with associations (only ids)
//        @SuppressWarnings("unchecked")
//        Iterator<Property> iterator = pc.getPropertyIterator();
//        while ( iterator.hasNext() ) {
//            Property property = iterator.next();
//            String propertyName = property.getName();
//            Value propertyValue = property.getValue();
//            String propertyNameToUpperCase = FrEDProjectSharedUtils.checkCase(propertyName);
//            if ( propertyValue!=null && propertyValue instanceof KeyValue ) { 
//                if ( !(propertyValue instanceof ToOne) ) {
//                    Object simpleObjectValue = ReflectionUtils.getProperty(propertyName, obj);
//                    ReflectionUtils.setProperty(propertyName, clonedResult, simpleObjectValue);
//                } else {
//                    Object fkObjectValue = ReflectionUtils.getProperty(propertyName, obj);
//                    if ( fkObjectValue!=null ) {
//                        //String fkObjectTypeName = fkObjectValue.getClass().getName();
//                        //fkObjectTypeName = fkObjectTypeName.substring(0, fkObjectTypeName.indexOf("_$$_"));
//                        Method propertyGetterMethod = ReflectionUtils.findMethod(clonedResult, "get"+propertyNameToUpperCase, ReflectionUtils.EMPTY_TYPES);
//                        String fkObjectTypeName = propertyGetterMethod.getReturnType().getName();
//                        PersistentClass fkpc = HibernateUtils.getPersistentClass(fkObjectTypeName);
//                        if ( fkpc!=null ) {
//                            Property fkIdProperty = fkpc.getIdentifierProperty();
//                            Object fkIdValue = HibernateUtils.getPropertyValue(fkIdProperty, fkObjectValue);
//                            Object fkClonedObject = Class.forName(fkObjectTypeName).newInstance();
//                            ReflectionUtils.setProperty(fkIdProperty.getName(), fkClonedObject, fkIdValue);
//                            ReflectionUtils.setProperty(propertyName, clonedResult, fkClonedObject);
//                        }
//                    }
//                }
//            }
//
//        }
        return clonedResult;
    }

//    public static UtenteBM getUtenteBMFromAdmUtenti(AdmUtenti admUtenti) {
//        UtenteBM utenteBM = null;
//        if ( admUtenti!=null ) {
//            utenteBM = new UtenteBM(
//                    admUtenti.getIdentnr(), 
//                    admUtenti.getUsername(), 
//                    admUtenti.getPassword(),
//                    admUtenti.getEmail(), 
//                    admUtenti.getCognome(), 
//                    admUtenti.getNome(), 
//                    admUtenti.getTitolo()
//            );
//        }
//        return utenteBM;
//    }
//
//    public static DataHistoryBM getDataHistoryBMFromAdmDataHistory(AdmDataHistory admDataHistory, Object pojo) {
//        DataHistoryBM dataHistoryBM = null;
//        if ( admDataHistory!=null ) {
//            UtenteBM utenteBM = getUtenteBMFromAdmUtenti(admDataHistory.getAdmUtenti());
//            dataHistoryBM = new DataHistoryBM(
//                    admDataHistory.getId()
//                   ,utenteBM
//                   ,admDataHistory.getDatetime()
//                   ,admDataHistory.getActivityOnDb()
//                   ,admDataHistory.getTableName()
//                   ,admDataHistory.getPojoName()
//                   ,pojo
//                   ,admDataHistory.getPrimaryKey());
//        }
//        return dataHistoryBM;
//    }

}
