/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

public class ListColumnFilter implements IColumnFilter ,IsSerializable {

    private static final long serialVersionUID = 1L;

    public static final String OPERATOR_AND = "AND";
    public static final String OPERATOR_OR  = "OR";

    public static final String[] AVAILABLE_OPERATORS = {
         OPERATOR_AND
        ,OPERATOR_OR 
    };

    private List<IColumnFilter> filterList;
    private String operator;

    public ListColumnFilter() {
        this(new ArrayList<IColumnFilter>(), OPERATOR_AND);
    }

    public ListColumnFilter(String operator) {
        this(new ArrayList<IColumnFilter>(), operator);
    }

    public ListColumnFilter(List<IColumnFilter> value, String operator) {
        this.filterList = value;
        this.operator = operator;
    }

    public void addFilter(IColumnFilter filter) {
        this.filterList.add(filter);
    }

    public List<IColumnFilter> getFilterList() {
        return filterList;
    }
    public void setFilterList(List<IColumnFilter> filterList) {
        this.filterList = filterList;
    }

    public String getOperator() {
        return operator;
    }
    public void setOperator(String operator) {
        this.operator = operator;
    }

    public boolean checkCorrectOperator() {
        return Arrays.asList(ListColumnFilter.AVAILABLE_OPERATORS).contains(operator);
    }

    @Override
    public String toString() {
        return "("+operator+" "+filterList+")";
    }
}
