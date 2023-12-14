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

import com.extjs.gxt.ui.client.Style.SortDir;

public class ColumnOrder implements Serializable, Comparable<ColumnOrder> {

    private static final long serialVersionUID = 1L;

    public static final String[] AVAILABLE_ORIENTATIONS = {
         SortDir.ASC.name()
        ,SortDir.DESC.name()
    };

    private int orderPosition;
    private String attributeName;
    private String orientation = SortDir.ASC.name();

    public ColumnOrder() {
    }

    public ColumnOrder(String attributeName, String orientation, int orderPosition) {
        this.attributeName = attributeName;
        this.orientation = orientation;
        this.setOrderPosition(orderPosition);
    }


    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getAttributeName() {
        return attributeName;
    }
    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public boolean checkCorrectOrientation() {
        return Arrays.asList(ColumnOrder.AVAILABLE_ORIENTATIONS).contains(orientation);
    }

    @Override
    public String toString() {
        return attributeName + " " + orientation;
    }
    
    public int compareTo(ColumnOrder columnOrder) {
        if (getOrderPosition() < columnOrder.getOrderPosition()) {
            return -1;
        } else if (getOrderPosition() == columnOrder.getOrderPosition()) {
            return 0; 
        } else {
            return 1; 
        }
    }

    public void setOrderPosition(int orderPosition) {
        this.orderPosition = orderPosition;
    }

    public int getOrderPosition() {
        return orderPosition;
    }

}
