package org.msf.exterms.xls.imp.impl;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapExecutor;

public class MsfExcelServiceDAO  extends SqlMapClientDaoSupport { 

    protected Log log = LogFactory.getLog(this.getClass());
    private SqlMapClient sqlMapClient = null;

    public MsfExcelServiceDAO(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
        super.setSqlMapClient(sqlMapClient);
    }

    /**
     * 엑셀서비스의 배치업로드를 실행한다.
     * @param queryId
     *        <code>String</code>
     * @param list
     *        <code>List&lt;Object&gt;</code>
     * @return
     */
    public Integer batchInsert(final String queryId, final List<Object> list) {
        return (Integer) getSqlMapClientTemplate().execute(
            new SqlMapClientCallback<Object>() {

                public Object doInSqlMapClient(SqlMapExecutor executor)
                        throws SQLException {

                    executor.startBatch();

                    for (Iterator<Object> itr = list.iterator(); itr.hasNext();) {
                      //  System.out.println("list.size() : "+itr.next().toString() +", i : " +itr.next());

                        executor.insert(queryId, itr.next());
                    }

                    return executor.executeBatch();
                }
            });
    }

    /**
     * 엑셀서비스의 배치업로드를 실행한다. 업로드할 엑셀의 시작 위치를 정하여 지정한 셀부터
     * 업로드한다.
     * @param queryId
     *        <code>String</code>
     * @param list
     *        <code>List&lt;Object&gt;</code>
     * @param start
     *        <code>int</code>
     * @return
     */
    public Integer batchInsert(final String queryId, final List<Object> list,
            final int start) {
        return (Integer) getSqlMapClientTemplate().execute(
            new SqlMapClientCallback<Object>() {

                public Object doInSqlMapClient(SqlMapExecutor executor)
                        throws SQLException {

                    executor.startBatch();

                    for (int i = start; i < list.size(); i++) {
                        executor.insert(queryId, list.get(i));
                    }

                    return executor.executeBatch();
                }
            });
    }
    
    
    /**
     * 엑셀서비스의 배치업로드를 실행한다.
     * @param queryId
     *        <code>String</code>
     * @param list
     *        <code>List&lt;Object&gt;</code>
     * @return
     */
    public Integer batchUpdate(final String queryId, final List<Object> list) {
        return (Integer) getSqlMapClientTemplate().execute(
            new SqlMapClientCallback<Object>() {

                public Object doInSqlMapClient(SqlMapExecutor executor)
                        throws SQLException {

                    executor.startBatch();

                    for (Iterator<Object> itr = list.iterator(); itr.hasNext();) {
                        executor.update(queryId, itr.next());
                    }

                    return executor.executeBatch();
                }
            });
    }

    /**
     * 엑셀서비스의 배치업로드를 실행한다. 업로드할 엑셀의 시작 위치를 정하여 지정한 셀부터
     * 업로드한다.
     * @param queryId
     *        <code>String</code>
     * @param list
     *        <code>List&lt;Object&gt;</code>
     * @param start
     *        <code>int</code>
     * @return
     */
    public Integer batchUpdate(final String queryId, final List<Object> list,
            final int start) {
        return (Integer) getSqlMapClientTemplate().execute(
            new SqlMapClientCallback<Object>() {

                public Object doInSqlMapClient(SqlMapExecutor executor)
                        throws SQLException {

                    executor.startBatch();

                    for (int i = start; i < list.size(); i++) {
                        executor.update(queryId, list.get(i));
                    }

                    return executor.executeBatch();
                }
            });
    }
    
    /**
     * 엑셀서비스의 배치업로드를 실행한다.
     * @param queryId
     *        <code>String</code>
     * @param list
     *        <code>List&lt;Object&gt;</code>
     * @return
     */
    public Integer batchDelete(final String queryId, final List<Object> list) {
        return (Integer) getSqlMapClientTemplate().execute(
            new SqlMapClientCallback<Object>() {

                public Object doInSqlMapClient(SqlMapExecutor executor)
                        throws SQLException {

                    executor.startBatch();

                    for (Iterator<Object> itr = list.iterator(); itr.hasNext();) {
                        executor.delete(queryId, itr.next());
                    }

                    return executor.executeBatch();
                }
            });
    }

    /**
     * 엑셀서비스의 배치업로드를 실행한다. 업로드할 엑셀의 시작 위치를 정하여 지정한 셀부터
     * 업로드한다.
     * @param queryId
     *        <code>String</code>
     * @param list
     *        <code>List&lt;Object&gt;</code>
     * @param start
     *        <code>int</code>
     * @return
     */
    public Integer batchDelete(final String queryId, final List<Object> list,
            final int start) {
        return (Integer) getSqlMapClientTemplate().execute(
            new SqlMapClientCallback<Object>() {

                public Object doInSqlMapClient(SqlMapExecutor executor)
                        throws SQLException {

                    executor.startBatch();

                    for (int i = start; i < list.size(); i++) {
                        executor.delete(queryId, list.get(i));
                    }

                    return executor.executeBatch();
                }
            });
    }
}
