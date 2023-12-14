/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.app.smrmf.core.resources.client.model;

import java.util.Date;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.util.DateWrapper;

public class Stock extends BaseModel {

  public Stock() {
  }

  public Stock(String name, Long open, Long change, Long pctChange, Long pctChange1 ) {
    set("name", name);
    set("open", open);
    set("change", change);
    set("percentChange", pctChange);
    set("pctChange1", pctChange1);
  //  set("date", date);
  // set("industry", industry);
   // set("split", new Boolean(Math.random() > .5));
   // set("type", getType());
  }

  public Stock(String name, String symbol, double open, double last) {
    set("name", name);
    set("symbol", symbol);
    set("open", open);
    set("last", last);
    set("date", new DateWrapper().addDays(-(int)(Math.random() * 100)).asDate());
    set("change", last - open);
    set("split", new Boolean(Math.random() > .5));
    set("type", getType());
  }

  public double getChange() {
    return getLast() - getOpen();
  }

  public String getIndustry() {
    return get("industry");
  }

  public double getLast() {
	  Long open = (Long) get("last");
    return open.longValue() ;
  }

  public Date getLastTrans() {
    return (Date) get("date");
  }

  public String getName() {
    return (String) get("name");
  }

  public double getOpen() {
	  Long open = (Long) get("open");
    return open.longValue();
  }

  public double getPercentChange() {
    return getChange() / getOpen();
  }

  public String getSymbol() {
    return (String) get("symbol");
  }

  public void setIndustry(String industry) {
    set("industry", industry);
  }

  public String toString() {
    return getName();
  }

  private String getType() {
    double r = Math.random();
    if (r <= .25) {
      return "Auto";
    } else if (r > .25 && r <= .50) {
      return "Media";
    } else if (r > .5 && r <= .75) {
      return "Medical";
    } else {
      return "Tech";
    }
  }

}
