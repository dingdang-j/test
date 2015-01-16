package org.lop.modules.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.lop.modules.constant.Constant;
import org.lop.modules.utils.CustomRowProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DAO Support.
 * 
 * @author 潘瑞峥
 * @date 2013-5-8
 */
public class SimpleDao {

	public Logger logger = LoggerFactory.getLogger( this.getClass() );

	private Connection connection;

	static {
		DbUtils.loadDriver( Constant.jdbcDriver );
	}

	/**
	 * 连接.
	 * 
	 * @return
	 * @throws SQLException
	 */
	private Connection getConnection() throws SQLException {
		connection = DriverManager.getConnection( Constant.jdbcUrl, Constant.jdbcUsername, Constant.jdbcPassword );
		// 关闭自动提交，异常时可回滚.
		connection.setAutoCommit( false );
		return connection;
	}

	/**
	 * 查询.
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<Map<String, Object>> query( final String sql, final Object... params ) {
		List<Map<String, Object>> result = null;
		try {
			connection = getConnection();
			QueryRunner runner = new QueryRunner();
			ResultSetHandler<List<Map<String, Object>>> handler = new MapListHandler();

			result = ( List<Map<String, Object>> ) runner.query( connection, sql, handler, params );
		} catch ( SQLException e ) {
			DbUtils.printStackTrace( e );
		} finally {
			DbUtils.closeQuietly( connection );
		}
		return result;
	}

	/**
	 * 查询.
	 * 
	 * @param clazz
	 * @param sql
	 * @param params
	 * @return
	 */
	public <T> List<T> query( final Class<T> clazz, final String sql, final Object... params ) {
		List<T> result = null;
		try {
			connection = getConnection();
			QueryRunner runner = new QueryRunner();
			BeanListHandler<T> handler = new BeanListHandler<T>( clazz, new CustomRowProcessor() );

			result = ( List<T> ) runner.query( connection, sql, handler, params );
		} catch ( SQLException e ) {
			DbUtils.printStackTrace( e );
		} finally {
			DbUtils.closeQuietly( connection );
		}
		return result;
	}

	/**
	 * 保存.
	 * 
	 * @param sql
	 * @param params
	 */
	public void save( final String sql, final Object... params ) {
		try {
			connection = getConnection();
			QueryRunner runner = new QueryRunner();
			runner.update( connection, sql, params );
			connection.commit();
		} catch ( SQLException e ) {
			try {
				DbUtils.rollback( connection );
			} catch ( SQLException ex ) {
			}
			// DbUtils.printStackTrace( e );
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly( connection );
		}
	}

}