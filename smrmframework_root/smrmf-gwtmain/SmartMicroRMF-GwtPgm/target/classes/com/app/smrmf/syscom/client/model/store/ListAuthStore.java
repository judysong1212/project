/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.app.smrmf.syscom.client.model.store;

import java.util.HashMap;

import com.app.smrmf.core.msfmainapp.client.model.model.MSFListStore;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.store.ListStore;

public class ListAuthStore   extends MSFListStore {


  private String coKey;
  private ListStore<BaseModel> listStore = new ListStore<BaseModel>(); ;
  private boolean succ;
  private boolean fail;
  private HashMap<String, Object> mapStore = new HashMap<String, Object>();
 	  
  public ListAuthStore() {
	 
  }
   
  public ListAuthStore(String coKey, ListStore<BaseModel> listStore, boolean succ, boolean fail,HashMap<String, Object> mapStore) {
    this.coKey = coKey;
    this.listStore = listStore;
    this.succ = succ;
    this.fail = fail;
    this.mapStore = mapStore;
  }

/**
 * Comment : 
 * @fn String getCoKey()
 * @brief date:2016 Feb 21, 2016 user:leeheuisung
 * @return the coKey get
 */
public String getCoKey() {
	return coKey;
}

/**
 * Comment : 
 *@fn void setCoKey(String coKey)
 *@brief date:2016 Feb 21, 2016 user:leeheuisung
 *@param coKey the coKey to set
 */
public void setCoKey(String coKey) {
	this.coKey = coKey;
}

/**
 * Comment : 
 * @fn ListStore<BaseModel> getListStore()
 * @brief date:2016 Feb 21, 2016 user:leeheuisung
 * @return the listStore get
 */
public ListStore<BaseModel> getListStore() {
	return listStore;
}

/**
 * Comment : 
 *@fn void setListStore(ListStore<BaseModel> listStore)
 *@brief date:2016 Feb 21, 2016 user:leeheuisung
 *@param listStore the listStore to set
 */
public void setListStore(ListStore<BaseModel> listStore) {
	this.listStore = listStore;
}

/**
 * Comment : 
 * @fn boolean isSucc()
 * @brief date:2016 Feb 21, 2016 user:leeheuisung
 * @return the succ get
 */
public boolean isSucc() {
	return succ;
}

/**
 * Comment : 
 *@fn void setSucc(boolean succ)
 *@brief date:2016 Feb 21, 2016 user:leeheuisung
 *@param succ the succ to set
 */
public void setSucc(boolean succ) {
	this.succ = succ;
}

/**
 * Comment : 
 * @fn boolean isFail()
 * @brief date:2016 Feb 21, 2016 user:leeheuisung
 * @return the fail get
 */
public boolean isFail() {
	return fail;
}

/**
 * Comment : 
 *@fn void setFail(boolean fail)
 *@brief date:2016 Feb 21, 2016 user:leeheuisung
 *@param fail the fail to set
 */
public void setFail(boolean fail) {
	this.fail = fail;
}

/**
 * Comment : 
 * @fn HashMap<String,Object> getMapStore()
 * @brief date:2016 Feb 21, 2016 user:leeheuisung
 * @return the mapStore get
 */
public HashMap<String, Object> getMapStore() {
	return mapStore;
}

/**
 * Comment : 
 *@fn void setMapStore(HashMap<String,Object> mapStore)
 *@brief date:2016 Feb 21, 2016 user:leeheuisung
 *@param mapStore the mapStore to set
 */
public void setMapStore(HashMap<String, Object> mapStore) {
	this.mapStore = mapStore;
}
 

}
