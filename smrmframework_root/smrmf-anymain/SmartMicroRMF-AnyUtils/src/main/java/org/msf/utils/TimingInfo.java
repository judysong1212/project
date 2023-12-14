/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package org.msf.utils;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimingInfo {

	private static final Logger logger = LoggerFactory.getLogger(SmrmfUtils.class);
	
    public long millis;
    public String id;

    public TimingInfo(long millis, String id) {
        this.millis = millis;
        this.id = id;
    }
    
    
 

}
