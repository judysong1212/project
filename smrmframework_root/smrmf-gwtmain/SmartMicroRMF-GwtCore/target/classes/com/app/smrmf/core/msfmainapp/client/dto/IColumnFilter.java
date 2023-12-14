/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.dto;

import java.io.Serializable;

public interface IColumnFilter extends Serializable {

    public String getOperator();

    public boolean checkCorrectOperator();

}
