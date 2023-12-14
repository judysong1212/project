/*
 * Copyright yysvip.tistory.com.,LTD.
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information
 * of yysvip.tistory.com.,LTD. ("Confidential Information").
 */
package com.ext.dao; 

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibatis.sqlmap.client.SqlMapClient;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * <pre>
 * com.ext.dao 
 *    |_ OtherAbstractDAO.java
 * 
 * </pre>
 * @date : Dec 15, 2015 10:22:07 PM
 * @version : 
 * @author : leeheuisung
 */
/** 

 * 여러 DB를 참조해야 하는 경우 상속되는 클래스.

 * 

 * 기존 DAO의 경우 EgovAbstractDAO를 extends하도록 되어 있으나

 * 다른 DB를 참조해야 하는 경우 현재 클래스와 같이 sqlMapClient가 아닌 

 * 다른 sqlMapClient를 지정하는 클래스를 통해 접근한다.

 *

 */
public class OtherAbstractDAO  extends EgovAbstractDAO {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	 /**

     * DB별 sqlMapClient 지정

     */ 
	
    @Resource(name = "otherSqlMapClient")
    public void setSuperSqlMapClient(SqlMapClient sqlMapClient) {

        super.setSuperSqlMapClient(sqlMapClient);

    }


}
