/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.server.utils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ComparableBaseModel;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BaseModelData;

public class ReflectionUtils {

    private static final  Logger logger = LoggerFactory.getLogger(ReflectionUtils.class);

    public static final Class<?>[] EMPTY_TYPES = new Class[]{};
    public static final Object[]   EMPTY_VALUES = new Object[]{};
    public static final Class<?>[] STRING_TYPES = new Class[]{String.class};

    /**
     * Il medoto sotto riportato permette di creare un oggetto partendo da una
     * stringa <code>classe</code> e di popolarlo con i valori, relativi ai vari
     * attributi, contenuti nella <code>hashMap</code>. 
     *
     * @param className	classe in formato <code>string</code> da instanziare
     * @param hashMap	mappa dei <code>metodi<code> : <code>valori<code> da settare
     * @return ritorna un oggetto con i valori inseriti
     *
     * @exception IllegalAccessException	se non ci sono i permessi adeguati per
     * 				accedere ai metodi o alle propriet&agrave; della classe
     * @exception InstantiationException	se ci sono errori nella creazione 
     * 				della nuova instanza
     * @exception ClassNotFoundException	se la classe non esiste
     */
    public static Object convertBaseModelToObject(String className, BaseModel baseModel) {
        Object object = null;
        try {
            Map<String, Object> hashMap = baseModel.getProperties();
            object = (Object) Class.forName(className).newInstance();
            Set<Entry<String, Object>> entrySet = hashMap.entrySet();
            Iterator<Entry<String, Object>> iter = entrySet.iterator();
            while (iter.hasNext()) {
                Entry<String, Object> entry = iter.next();
                String key   = entry.getKey();
                Object value = entry.getValue();
                setProperty(key, object, value);
            }
        } catch (Exception ex) {
            throw MSFServerUtils.getOperationException("convertBaseModelToObject()", ex, logger);
        }

        return object;
    }

    public static void updatePersistentObjectFromBaseModel(Object object, Object detachedObject, String className, BaseModel baseModel) {
        if ( object==null || detachedObject==null || baseModel==null ) {
            return;
        }

        try {

            //Class<?> objectClass = object.getClass();
           // String objectClassName = className!=null ? className : objectClass.getName();
           // PersistentClass pc = HibernateUtils.getPersistentClass(objectClassName);
            Map<String, Object> hashMap = baseModel.getProperties();
            Set<Entry<String, Object>> entrySet = hashMap.entrySet();
            Iterator<Entry<String, Object>> iter = entrySet.iterator();

            while (iter.hasNext()) {

                Entry<String, Object> entry = iter.next();
                String key   = entry.getKey();
                //Object value = entry.getValue();

                String name = MSFSharedUtils.vv(key);
                String propertyName = MSFSharedUtils.getToken(name,1);
                String propertyNameToUpperCase = MSFSharedUtils.checkCase(propertyName);
                int countOccorrenze = MSFSharedUtils.occorrenze(name, TableDef.SEPARATOR_CLIENT);
                Object oldValue = getProperty(propertyName, object);
                Object newValue = getProperty(propertyName, detachedObject);

//                if (countOccorrenze > 2) {

                    //if property is complex, then we must check if it is an associated Dao.
                    //Skip if we can not find it in the PersistentClass
                    //Property property = pc.getProperty(propertyName);
//                    Property property = HibernateUtils.getProperty(pc, propertyName);
//                    if ( property!=null ) {
//                        Value propertyValue = property.getValue();
//                        if ( propertyValue!=null && propertyValue instanceof ToOne ) {
//                            //if it is an associated dao we can not update its identifier but we must create a new instance with new identifier!
//                            Method propertyGetterMethod = ReflectionUtils.findMethod(objectClass, "get"+propertyNameToUpperCase, ReflectionUtils.EMPTY_TYPES);
//                            String fkObjectTypeName = propertyGetterMethod.getReturnType().getName();
//                            PersistentClass fkpc = HibernateUtils.getPersistentClass(fkObjectTypeName);
//                            if ( fkpc!=null ) {
//                                Property fkIdProperty = fkpc.getIdentifierProperty();
//                                Object oldFkIdValue = HibernateUtils.getPropertyValue(fkIdProperty, oldValue);
//                                Object newFkIdValue = HibernateUtils.getPropertyValue(fkIdProperty, newValue);
//    
//                                //Check if ID of associated object is different. If it is different update object
//                                if ( !MSFSharedUtils.objectEquals(oldFkIdValue, newFkIdValue) ) {
//                                    setProperty(propertyName, object, newValue);
//                                }
//                            }
//                        } else {
//                            //it is not an association, update it without problems
//                            if ( !MSFSharedUtils.objectEquals(oldValue, newValue) ) {
//                                setProperty(propertyName, object, newValue);
//                            }
 //                       }
 //                   }

//                } else {

                    //if property is simple, update it without problems
                    if ( !MSFSharedUtils.objectEquals(oldValue, newValue) ) {
                        setProperty(propertyName, object, newValue);
                    }

 //               }

            }
        } catch (Exception ex) {
            throw MSFServerUtils.getOperationException("updatePersistentObjectFromBaseModel()", ex, logger);
        }
    }

    public static void setProperty(String name, Object target, Object value) {

        if ( target==null || MSFSharedUtils.paramNull(name) ) {
            return;
        }

        Object obj = target;
        name = MSFSharedUtils.vv(name);
        String nameToUpperCase = MSFSharedUtils.checkCase(MSFSharedUtils.getToken(name,1));
        int countOccorrenze = MSFSharedUtils.occorrenze(name, TableDef.SEPARATOR_CLIENT);

        //se occorrenze > 2 navighiamo in cascata l'associazione, 
        //creando le istanze degli oggetti associati nel caso in cui questi fossero null
        if (countOccorrenze>2) {
            Method getterMethod = null;
            Object retval = null;
            getterMethod = findMethod(obj, "get" + nameToUpperCase, EMPTY_TYPES);
            if (getterMethod != null) {
                retval = invokeMethod(target, getterMethod, EMPTY_VALUES);
                if (retval == null && value != null) {
                    try {
                        Class<?> getterType = getterMethod.getReturnType();
                        if ( !"java.lang".equals(getterType.getPackage().getName()) ) {
                            retval = (Object) getterMethod.getReturnType().newInstance();
                        }
                    } catch (Exception ex) {
                        logger.error("EXCEPTION: "+ex, ex);
                    }
                }
            }
            if (retval!=null) {
                setProperty(name.substring(MSFSharedUtils.instr(name, TableDef.SEPARATOR_CLIENT, 0, 2)+1), retval, value);
                value = retval;
            }
        }

        //Now we invoke the setter on the object, we do not have an association to another Dao 
        invokeSetter(nameToUpperCase, obj, value);

    }

    /**
     * Checks if the object must be transformed to a different type to match the type of the setter.
     * TIMESTAMP <--> DATE
     * DOUBLE    <--> LONG
     * ...
     * @param setterName
     * @param target
     * @param value
     * @return
     */
    public static void invokeSetter(String attrNameToUpperCase, Object target, Object value) {

        if ( target==null || MSFSharedUtils.paramNull(attrNameToUpperCase) ) {
            logger.debug("invokeSetter, target or attrName are null: target='"+target+"'  attrName='"+attrNameToUpperCase+"'");
            return;
        }

        try {
            //Extract getter and setter methods from target object
            String getterName = "get" + attrNameToUpperCase;
            String setterName = "set" + attrNameToUpperCase;
            Method getterMethod = findMethod(target, getterName, EMPTY_TYPES);
            if ( getterMethod==null ) {
                logger.debug("invokeSetter, getterMethod for attribute '"+attrNameToUpperCase+"' not found in class '"+target+"'.");
                return;
            }
            Class<?> getterType = getterMethod.getReturnType();
            Method setterMethod = findMethod(target, setterName, new Class[]{getterType});
            if ( setterMethod==null ) {
                logger.debug("invokeSetter, setterMethod for attribute '"+attrNameToUpperCase+"' of type '"+getterType+"' not found in class '"+target+"'.");
                return;
            }

            //In case value is null, set it and exit.
            if ( value==null ) {
                invokeMethod(target, setterMethod, new Object[]{null});
                return;
            }

            //Get type of setter and value
            Class<?> valueType = value.getClass();

            //We check if we are filling an associated object (value is a BaseModel)
            if ( valueType!=getterType && valueType==BaseModel.class ) {
                String mapKey   = attrNameToUpperCase.substring(0, 1).toLowerCase() + attrNameToUpperCase.substring(1);
                Object mapValue = ((BaseModel) value).get(mapKey);
                if ( mapValue!=null ) {
                    value = mapValue;
                }
            }

            //Now we must check if we need to convert value to match exactly type of setter
            if ( valueType != getterType ) {

                if (        valueType==java.lang.Boolean.class && getterType==java.lang.String.class ) {
                    //Value is Boolean, attribute is String (will be converted to "1" or "0")
                    value = MSFSharedUtils.convertBooleanToString((java.lang.Boolean)value);
                } else if ( valueType==java.lang.String.class && getterType==java.lang.Boolean.class ) {
                    //Value is String, attribute is Boolean (will be converted from "1" or "0")
                    value = MSFSharedUtils.convertStringToBoolean((java.lang.String)value);
                } else if ( valueType==java.lang.Boolean.class && getterType==java.lang.Long.class ) {
                    //Value is Boolean, attribute is Long (will be converted to "1" or "0")
                    value = MSFSharedUtils.convertBooleanToLong((java.lang.Boolean)value);
                } else if ( valueType==java.lang.Long.class && getterType==java.lang.Boolean.class ) {
                    //Value is Long, attribute is Boolean (will be converted from "1" or "0")
                    value = MSFSharedUtils.convertLongToBoolean((java.lang.Long)value);
                } else if ( valueType==java.sql.Timestamp.class && getterType==java.util.Date.class ) {
                    //Value is Timestamp, attribute is Date
                    value = MSFSharedUtils.convertTimestampToDate((java.sql.Timestamp)value);
                } else if ( valueType==java.util.Date.class && getterType==java.sql.Timestamp.class ) {
                    //Value is Date, attribute is Timestamp
                    value = MSFSharedUtils.convertDateToTimestamp((java.util.Date)value);
                } else if ( valueType==java.lang.Long.class && getterType==java.lang.Double.class ) {
                    //Value is Long, attribute is Double
                    value = MSFSharedUtils.convertLongToDouble((java.lang.Long)value);
                } else if ( valueType==java.lang.Double.class && getterType==java.lang.Long.class ) {
                    //Value is Double, attribute is Long
                    value = MSFSharedUtils.convertDoubleToLong((java.lang.Double)value);
                } else if ( valueType==java.lang.String.class && getterType==java.lang.Double.class ) {
                    //Value is String, attribute is Double
                    value = MSFSharedUtils.convertStringToDouble((java.lang.String)value);
                } else if ( valueType==java.lang.String.class && getterType==java.lang.Long.class ) {
                    //Value is String, attribute is Long
                    value = MSFSharedUtils.convertStringToLong((java.lang.String)value);
                } else if (                                      getterType==java.lang.String.class ) {
                    //Value is Object, attribute is String
                    value = MSFSharedUtils.convertObjectToString(value);
                }

            }

            //A the end invoke setter with the value
            invokeMethod(target, setterMethod, new Object[]{value});

        } catch (Exception ex) {
            logger.error("EXCEPTION: "+ex, ex);
        }
    }

    public static Object getProperty(String name, Object target) {
        Object retval = null;
        Method getterMethod = null;
        Object obj = target;
        name = MSFSharedUtils.vv(name);
        int countOccorrenze = MSFSharedUtils.occorrenze(name, TableDef.SEPARATOR_CLIENT);
        for ( int i=1 ; obj!=null && i<countOccorrenze ; i++ ) {
            String nameToUpperCase = MSFSharedUtils.checkCase(MSFSharedUtils.getToken(name,i));
            getterMethod = findMethod(obj, "get" + nameToUpperCase, EMPTY_TYPES);
            if (getterMethod != null) {
                retval = invokeMethod(obj, getterMethod, EMPTY_VALUES);
                obj = retval;
            } else {
                retval = null;
                obj = retval;
            }
        }
        return retval;
    }

    public static Method findMethod(Class<?> targetClass, String methodName, Class<?>[] methodTypes) {
        try {
            if ( targetClass!=null ) {
                Method method = targetClass.getMethod(methodName, methodTypes);
                return method;
            }
        } catch (Exception ex) {
            logger.debug("Method '"+methodName+"' not found in class '"+targetClass+"': "+ex);
            logger.debug("EXCEPTION: "+ex, ex);
        }
        return null;
    }

    public static Method findMethod(Object target, String methodName, Class<?>[] methodTypes) {
        try {
            if ( target!=null ) {  
            	Method  method   = target.getClass().getDeclaredMethod(methodName, methodTypes);
                return method;
            }
        } catch (Exception ex) {
            logger.debug("Method '"+methodName+"' not found in class '"+target+"': "+ex);
            logger.debug("EXCEPTION: "+ex, ex);
        }
        return null;
    }

    public static Object invokeMethod(Object target, Method method, Object[] methodValues) {
        try {
            Object retval = method.invoke(target, methodValues);
            return retval;
        } catch (Exception ex) {
            logger.error("EXCEPTION: "+ex, ex);
        }
        return null;
    }

    public static Object invokeMethod(Object target, String methodName, Class<?>[] methodTypes, Object[] methodValues) {
        try {
            Method method = findMethod(target, methodName, methodTypes);
            if ( method!=null ) {
                Object retval = method.invoke(target, methodValues);
                return retval;
            }
        } catch (Exception ex) {
            logger.error("EXCEPTION: "+ex, ex);
        }
        return null;
    }

    public static Object invokeStaticMethod(String className, String methodName, Object[] paramValues, Class<?>[] paramTypes) {
        Object retval = null;
        try {
            Class<?> clazz = Class.forName(className);
            Method method = clazz.getMethod(methodName, paramTypes);
            retval = method.invoke(clazz, paramValues);
        } catch (Exception ex) {
            logger.error("EXCEPTION: "+ex, ex);
        }
        return retval;
    }

    public static Class<?> getClass(String aClass) {
        Class<?> c = null;
        try {
            c = Class.forName(MSFSharedUtils.checkCase(aClass));
        } catch (ClassNotFoundException ex) {
            logger.error("EXCEPTION: "+ex, ex);
        }
        return c;
    }

    public static void setUsername(MSFSysm0100BM user, Object target) {

        if ( target==null || user==null || MSFSharedUtils.paramNull(user.getUsrNm()) ) {
            return;
        }

        String username = user.getUsrNm();
        if ( target instanceof BaseModelData ) {
            ((BaseModelData)target).set("muser", username);
        } else {
            Method setterMethod = findMethod(target, "setMuser", STRING_TYPES);
            if ( setterMethod!=null ) {
                invokeMethod(target, setterMethod, new String[]{username});
            }
        }

    }

    public static void convertObjectListToBaseModelList(List<BaseModel> retval, Collection<Object> list, String objectClassName, ColumnAttribute[] baseModelColumns) {
        if ( retval==null || list==null ) {
            return;
        }
        Iterator<Object> iter = list.iterator();
        int objIdx = -1;
        while ( iter.hasNext() ) {
            Object objDB = (Object) iter.next();
            //If we had some aliases, query returned an array of associated objects. We need only the main object (normally is the first but we can not be sure).
            if ( objDB!=null && objDB instanceof Object[] ) {
                Object[] ents = (Object[])objDB;
                //If objIdx>=0, this means that we already know the correct position of the main object in the array
                if ( objIdx>=0 && objIdx<ents.length ) {
                    objDB = ents[objIdx];
                } else {
                    for ( int i=0 ; i<ents.length ; i++ ) {
                        if ( ents[i]!=null && ents[i].getClass().getName().equals(objectClassName) ) {
                            objDB = ents[i];
                            objIdx = i;
                            break;
                        }
                    }
                }
            }
            if ( objDB!=null ) {
                BaseModel bm = ReflectionUtils.convertObjectToBaseModel(objDB, baseModelColumns);
                retval.add(bm);
            }
        }
    }

    public static void convertObjectArrayListToBaseModelList(List<BaseModel> retval, Collection<Object> list, String objectClassName, ColumnAttribute[] baseModelColumns) {
        if ( retval==null || list==null || baseModelColumns==null ) {
            return;
        }
        Iterator<Object> iter = list.iterator();
        while ( iter.hasNext() ) {
            Object objDB = (Object) iter.next();
            //Each row is an array of Objects. Each Object is the value for the BaseModel
            if ( objDB!=null && objDB instanceof Object[] ) {
                BaseModel bm = ReflectionUtils.convertObjectArrayToBaseModel((Object[])objDB, baseModelColumns);
                retval.add(bm);
            }
        }
    }

    public static void convertObjectWithFormulaListToBaseModelList(List<BaseModel> retval, Collection<Object> list, String objectClassName, ColumnAttribute[] baseModelColumns) {
        if ( retval==null || list==null || baseModelColumns==null ) {
            return;
        }
        List<ColumnAttribute> formulaColumns = new ArrayList<ColumnAttribute>();
        for ( int i=0 ; i<baseModelColumns.length ; i++ ) {
            if ( baseModelColumns[i].getValueIdx()>0 ) {
                formulaColumns.add(baseModelColumns[i]);
            }
        }
        Iterator<Object> iter = list.iterator();
        while ( iter.hasNext() ) {
            Object objDB = (Object) iter.next();
            //Each row is an array of Objects.
            if ( objDB!=null ) {
                if ( objDB instanceof Object[] ) {
                    Object[] values = (Object[]) objDB;
                    //First Object is the main Dao
                    Object dao = values[0];
                    BaseModel bm = ReflectionUtils.convertObjectToBaseModel(dao, baseModelColumns);
                    //Other values are bound to formula columns
                    for ( int i=0 ; i<formulaColumns.size() ; i++ ) {
                        ColumnAttribute formulaAttribute = formulaColumns.get(i);
                        if ( formulaAttribute!=null && formulaAttribute.getValueIdx()<values.length ) {
                            Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(values[formulaAttribute.getValueIdx()], formulaAttribute.getType());
                            bm.set(formulaAttribute.getName(), baseModelValue);
                        }
                    }
                    retval.add(bm);
                } else {
                    //ObjDB is the Dao
                    BaseModel bm = ReflectionUtils.convertObjectToBaseModel(objDB, baseModelColumns);
                    retval.add(bm);
                }
            }
        }
    }

    public static void convertMapListToBaseModelList(List<BaseModel> result, Collection<Map<String, Object>> list, String[] idAttrNames, ColumnAttribute[] tableAttributes) {
        if ( result==null || list==null || tableAttributes==null ) {
            return;
        }
        Iterator<Map<String, Object>> iter = list.iterator();
        while ( iter.hasNext() ) {
            Map<String, Object> map = (Map<String, Object>) iter.next();
            String idValue = GenericDaoUtils.getIdValueAsString(idAttrNames, map);
            BaseModel bm = new BaseModel();

            //bm.setProperties(map);
            for ( int i=0 ; i<tableAttributes.length ; i++ ) {
                Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
                        map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
                bm.set(tableAttributes[i].getName(), baseModelValue);
            }

            bm.set(TableDef.ID_PROPERTY_NAME, idValue);
            result.add(bm);
        }
    }

    public static BaseModel convertObjectToBaseModel(Object obj, ColumnAttribute[] tableAttributes) {
        if ( obj==null || tableAttributes==null || tableAttributes.length==0 ) {
            return null;
        }

        //Create return BaseModel. We flatten all nested objects
        BaseModel retval = new BaseModel();
        retval.setAllowNestedValues(false);
        for (ColumnAttribute columnAttribute : tableAttributes) {
            //Formula columns must be skipped
            if ( MSFSharedUtils.paramNull(columnAttribute.getFormula()) ) {
                String attrName     = columnAttribute.getName();
                String daoAttrName = columnAttribute.getName();
                //String bmAttrName   = columnAttribute.getName();
                int separatorIdx = attrName.indexOf(TableDef.SEPARATOR_CLIENT);
                int type = columnAttribute.getType();
                if ( columnAttribute.isSkipJoin() && separatorIdx>0 && separatorIdx<attrName.length()-1 ) {
                    //bmAttrName   = attrName.substring(0, separatorIdx);
                    daoAttrName = attrName.substring(separatorIdx+1);
                }
                Object objectValue = ReflectionUtils.getProperty(daoAttrName, obj);
                Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(objectValue, type);
                retval.set(attrName, baseModelValue);
            }
        }
        //Set value of PK in an attribute that has a fixed property name
        //BaseModel id = HibernateUtils.getObjectIdValueAsBaseModel(obj);
        //TODO 확인 필요 함....차후에 프로퍼티 키값임.
       // String id = GenericDaoUtils.getObjectIdValueAsString(obj);
       // retval.set(TableDef.ID_PROPERTY_NAME, id);

        return retval;
    }

    public static BaseModel convertObjectToBaseModel(Object obj) {
        if ( obj==null ) {
            return null;
        }

        //Create return BaseModel. We flatten all nested objects
        BaseModel retval = new ComparableBaseModel();
        retval.setAllowNestedValues(false);

        //Iterate through the methods of the bean, from which values are to be copied
        //Only Serializable attributes are copied into BaseModel
        String fromBeanName = obj.getClass().getName();
        Method[] fromBeanMethods = obj.getClass().getMethods();
        for (int i = 0; i < fromBeanMethods.length; i++) {
            String methodName = fromBeanMethods[i].getName();
            if (methodName.startsWith("get") && !methodName.equals("getClass")) {
                try {
                    Method fromBeanMethod = fromBeanMethods[i];
                    Class<?>[] parameterTypes = fromBeanMethod.getParameterTypes();
                    if ( parameterTypes==null || parameterTypes.length==0 ) {
//                        String name = methodName.substring(3);
                        String name = methodName.substring(3,4).toLowerCase() + methodName.substring(4);
                        Object value = fromBeanMethod.invoke(obj, EMPTY_VALUES);
                        if ( value instanceof Serializable ) {
                            retval.set(name, value);
                        }
                    }
                } catch (Exception ex) {
                    logger.debug("convertObjectToBaseModel("+fromBeanName+"), EXCEPTION: "+ex);
                }
            }
        }

        return retval;
    }

    public static String convertObjectToString(Object obj) {
        if ( obj==null ) {
            return null;
        }

        //Create return StringBuffer. We flatten all nested objects
        StringBuffer retval = new StringBuffer();

        //Iterate through the methods of the bean, from which values are to be copied
        //Only Serializable attributes are copied into BaseModel
        //We put methods sorted by attribute names to get always the same String representation
        TreeMap<String, String> sortedValues = new TreeMap<String, String>();
        String fromBeanName = obj.getClass().getName();
        Method[] fromBeanMethods = obj.getClass().getMethods();
        for (int i = 0; i < fromBeanMethods.length; i++) {
            String methodName = fromBeanMethods[i].getName();
            if (methodName.startsWith("get") && !methodName.equals("getClass")) {
                try {
                    Method fromBeanMethod = fromBeanMethods[i];
                    Class<?>[] parameterTypes = fromBeanMethod.getParameterTypes();
                    if ( parameterTypes==null || parameterTypes.length==0 ) {
                        String name = methodName.substring(3,4).toLowerCase() + methodName.substring(4);
                        Object value = fromBeanMethod.invoke(obj, EMPTY_VALUES);
                        if ( value instanceof Serializable ) {
                            String valueAsString = MSFServerUtils.getObjectAsString(name, value);
                            sortedValues.put(name, valueAsString);
                        }
                    }
                } catch (Exception ex) {
                    logger.debug("convertObjectToString("+fromBeanName+"), EXCEPTION: "+ex);
                }
            }
        }

        //Now extract values in sorted order
        if ( sortedValues!=null && sortedValues.values()!=null && sortedValues.values().iterator()!=null ) {
            Collection<String> values = sortedValues.values();
            Iterator<String> iterator = values.iterator();
            while (iterator.hasNext()) {
                String value = iterator.next();
                retval.append( (retval.length()>0?",":"") + value );
            }
        }

        return retval.toString();
    }

    public static String convertMapToString(Map<String, Object> map) {
        if ( map==null ) {
            return null;
        }

        //Create return StringBuffer. We flatten all nested objects
        StringBuffer retval = new StringBuffer();

        //Iterate through the entries of the map, from which values are to be copied
        //We put values sorted by key names to get always the same String representation
        TreeMap<String, String> sortedValues = new TreeMap<String, String>();
        Iterator<String> keyIter = map.keySet().iterator();
        while (keyIter.hasNext()) {
            String key = keyIter.next();
            Object value = map.get(key);
            if ( value instanceof Serializable ) {
                String valueAsString = MSFServerUtils.getObjectAsString(key, value);
                sortedValues.put(key, valueAsString);
            }
        }

        //Now extract values in sorted order
        if ( sortedValues!=null && sortedValues.values()!=null && sortedValues.values().iterator()!=null ) {
            Collection<String> values = sortedValues.values();
            Iterator<String> iterator = values.iterator();
            while (iterator.hasNext()) {
                String value = iterator.next();
                retval.append( (retval.length()>0?",":"") + value );
            }
        }

        return retval.toString();
    }

    public static BaseModel convertObjectArrayToBaseModel(Object[] values, ColumnAttribute[] tableAttributes) {
        if ( values==null || tableAttributes==null ) {
            return null;
        }
        //Check if ents.size is same as baseModelColumns.size
        if ( values.length != tableAttributes.length ) {
            logger.error("ObjectArray has different size than BaseModel: values.length="+values.length+"  tableAttributes="+tableAttributes.length);
            return null;
        }

        //Create return BaseModel. We flatten all nested objects
        BaseModel retval = new BaseModel();
        retval.setAllowNestedValues(false);
        for (int i=0 ; i<tableAttributes.length ; i++) {
            String name = tableAttributes[i].getName();
            int type = tableAttributes[i].getType();
            Object objectValue = values[i];
            Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(objectValue, type);
            retval.set(name, baseModelValue);
        }
        return retval;
    }

    public static void flattenBaseModel(HashMap<String, Object> map, BaseModel bmTo, String prefix) {
        if ( map==null || bmTo==null ) {
            return;
        }

        //Create return BaseModel. We flatten all nested objects
        bmTo.setAllowNestedValues(false);

        Iterator<String> keyIter = map.keySet().iterator();
        while (keyIter.hasNext()) {
            String key = keyIter.next();
            Object value = map.get(key);
            String bmkey = prefix!=null ? prefix+TableDef.SEPARATOR_CLIENT+key : key;
            if (        value instanceof BaseModel ) {
                flattenBaseModel((BaseModel)value, bmTo, bmkey);
            } else if ( value instanceof Serializable ) {
                bmTo.set(bmkey, value);
            }
        }

    }

    public static void flattenBaseModel(BaseModel bmFrom, BaseModel bmTo, String prefix) {
        if ( bmFrom==null || bmTo==null ) {
            return;
        }

        //Create return BaseModel. We flatten all nested objects
        bmTo.setAllowNestedValues(false);

        Map<String, Object> map = bmFrom.getProperties();
        Iterator<String> keyIter = map.keySet().iterator();
        while (keyIter.hasNext()) {
            String key = keyIter.next();
            Object value = map.get(key);
            String bmkey = prefix!=null ? prefix+TableDef.SEPARATOR_CLIENT+key : key;
            if (        value instanceof BaseModel ) {
                flattenBaseModel((BaseModel)value, bmTo, bmkey);
            } else if ( value instanceof Serializable ) {
                bmTo.set(bmkey, value);
            }
        }

    }

    public static BaseModel flattenDataHistoryBM(BaseModel bmDataHistory, ColumnAttribute[] tableAttributes) {
        if ( bmDataHistory==null ) {
            return null;
        }

        //Create return BaseModel. We flatten all nested objects
        BaseModel bm = new BaseModel();
        bm.setAllowNestedValues(false);

        Map<String, Object> map = bmDataHistory.getProperties();
        Iterator<String> keyIter = map.keySet().iterator();
        while (keyIter.hasNext()) {
            final String key = keyIter.next();
            final Object value = map.get(key);
            if (        "user".equals(key) ) {
                //Map<String, Object> userMap = ((BaseModel)value).getProperties();
                //Iterator<String> keyUserIter = userMap.keySet().iterator();
                //while (keyUserIter.hasNext()) {
                //    String userKey   = keyUserIter.next();
                //    Object userValue = userMap.get(key);
                //    bm.set("user"+TableDef.SEPARATOR_CLIENT+userKey, userValue);
                //}
                MSFSysm0100BM user = (MSFSysm0100BM) value;
                flattenBaseModel(user.getProperties(), bm, "user");
            } else if ( "dataStored".equals(key) ) {
                Object ds = new Object() {
                    public Object dataStored = value;
                    public Object getDataStored() {
                        return this.dataStored;
                    }
                };
                BaseModel dataStored = convertObjectToBaseModel(ds, tableAttributes);
                flattenBaseModel(dataStored, bm, null);
            } else {
                bm.set(key, value);
            }
        }

        return bm;
    }
    
	public static Map ConverObjectToMap(Object obj){
        try {
            //Field[] fields = obj.getClass().getFields(); //private field는 나오지 않음.
            Field[] fields = obj.getClass().getDeclaredFields();
            Map resultMap = new HashMap();
            for(int i=0; i<=fields.length-1;i++){
                fields[i].setAccessible(true);
                resultMap.put(fields[i].getName(), fields[i].get(obj));
            }
            return resultMap;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
	
	
	public static Object convertMapToObject(Map map, Object objClass){
        String keyAttribute = null;
        String setMethodString = "set";
        String methodString = null;
        Iterator itr = map.keySet().iterator();
        while(itr.hasNext()){
            keyAttribute = (String) itr.next();
            methodString = setMethodString+keyAttribute.substring(0,1).toUpperCase()+keyAttribute.substring(1);
            try {
                Method[] methods = objClass.getClass().getDeclaredMethods();
                for(int i=0;i<=methods.length-1;i++){
                    if(methodString.equals(methods[i].getName())){
                        System.out.println("invoke : "+methodString);
                        methods[i].invoke(objClass, map.get(keyAttribute));
                    }
                }
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return objClass;
    }


}
