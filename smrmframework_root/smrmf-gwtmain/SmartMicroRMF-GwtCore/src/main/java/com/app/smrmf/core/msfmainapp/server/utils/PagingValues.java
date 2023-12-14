/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.server.utils;

import java.util.List;

import com.app.smrmf.core.msfmainapp.client.dto.ColumnOrder;

public class PagingValues {

    public int start = -1;
    public int offsetLimit = -1;
    public int totalRecordCount = 0;
    public boolean executeRecordCount = true;
    public boolean pageExecute = true;    //카운트처리는 하고 페이지 처리를 하지 않을경우 false; 카운트처리도하고 페이지처리를 할때는 true
    public List<ColumnOrder> columnOrders = null;

    public PagingValues() {
    }

    public PagingValues(int start, int offsetLimit, int totalRecordCount, boolean executeRecordCount, boolean pageExecute, List<ColumnOrder> columnOrders) {
        this.start = start;
        this.offsetLimit = offsetLimit;
        this.totalRecordCount = totalRecordCount;
        this.executeRecordCount = executeRecordCount;
        this.pageExecute = pageExecute;
        this.columnOrders = columnOrders;
    }

}
