/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.dto;

import java.io.Serializable;
import java.util.Arrays;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * 
 * DataFilterDef Class represents a filter that is applied to a data set
 * and is used to create a where clause on the server side.
 * Different operators are provided to generate different restrictions (LIKE, ILIKE, GREATER_THAN, ....)
 *
 */
public class SimpleColumnFilter extends BaseModel implements IColumnFilter ,IsSerializable {

    private static final long serialVersionUID = 1L;

    public static final String ATTR_ATTRIBUTE        = "attribute";
    public static final String ATTR_VALUE            = "value";
    public static final String ATTR_OPERATOR         = "operator";

    public static final String OPERATOR_EQUALS       = "eq";
    public static final String OPERATOR_NOT_EQUALS   = "ne";
    public static final String OPERATOR_LIKE         = "ll";
    public static final String OPERATOR_ILIKE        = "il";
    public static final String OPERATOR_GREATER_THAN = "gt";
    public static final String OPERATOR_LESS_THAN    = "lt";
    public static final String OPERATOR_IN           = "in";
    public static final String OPERATOR_IS_NULL      = "nu";
    public static final String OPERATOR_IS_NOT_NULL  = "nn";

    public static final String[] AVAILABLE_OPERATORS = {
         OPERATOR_EQUALS      
        ,OPERATOR_NOT_EQUALS  
        ,OPERATOR_LIKE        
        ,OPERATOR_ILIKE       
        ,OPERATOR_GREATER_THAN
        ,OPERATOR_LESS_THAN   
        ,OPERATOR_IN          
        ,OPERATOR_IS_NULL     
        ,OPERATOR_IS_NOT_NULL 
    };

    public SimpleColumnFilter() {
        super();
    }

    public SimpleColumnFilter(String attribute, Serializable value, String operator) {
        super();
        setAttribute(attribute);
        setValue(    value);
        setOperator( operator);
    }

    /*
    public static boolean paramNotNull(Object obj) {
        return obj!=null && obj.toString().trim().length()>0;
    }

    public String getRestriction() {
        if ( paramNotNull(attribute) && paramNotNull(value) ) {
            StringBuffer sql = new StringBuffer();
            //Column name
            sql.append(attribute);
            //Operator
            switch (operator) {
                case OPERATOR_IN:
                    sql.append(" IN ");
                    break;
                case OPERATOR_LIKE:
                case OPERATOR_ILIKE:
                    sql.append(" LIKE ");
                    break;
                case OPERATOR_NOT_EQUALS:
                    sql.append(" != ");
                    break;
                default:
                    sql.append(" = ");
                    break;
            }
            //Value
            if (        type==CLASS_DATE ) {
                sql.append("to_date('"+value+"','"+DATE_FORMAT+"') ");
            } else if ( type==CLASS_DATE ) {
                sql.append("to_date('"+value+"','"+DATETIME_FORMAT+"') ");
            } else if ( type==CLASS_INTEGER || type==CLASS_LONG || type==CLASS_DOUBLE || type==CLASS_FLOAT ) {
                sql.append(value+" ");
            } else {
                sql.append("'"+value+"' ");
            }
            return sql.toString();
        }
        return null;
    }
    */

    public String getAttribute() {
        return get(ATTR_ATTRIBUTE);
    }
    public void setAttribute(String attribute) {
        set(ATTR_ATTRIBUTE, attribute);
    }

    public Serializable getValue() {
        if (get(ATTR_VALUE) instanceof DynamicFilterValue) {
            DynamicFilterValue dfv = (DynamicFilterValue)get(ATTR_VALUE);
            if (dfv != null) {
                return dfv.getValue();
            }
        }
        return get(ATTR_VALUE);
    }
    public void setValue(Serializable value) {
        set(ATTR_VALUE,     value);
    }

    public String getOperator() {
        return get(ATTR_OPERATOR);
    }
    public void setOperator(String operator) {
        set(ATTR_OPERATOR,  operator);
    }

    public boolean checkCorrectOperator() {
        return Arrays.asList(SimpleColumnFilter.AVAILABLE_OPERATORS).contains(getOperator());
    }

    @Override
    public String toString() {
        return "("+getAttribute()+" "+getOperator()+" "+getValue()+")";
    }
}
