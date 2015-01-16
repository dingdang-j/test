package org.lop.modules.utils;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.lang3.SystemUtils;
import org.lop.db.jdbc.dao.CreateTablesDao;
import org.lop.db.jdbc.service.CallOptionService;
import org.lop.modules.bean.CallOptionBean;
import org.lop.modules.constant.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 初始化.
 * 
 * @author 潘瑞峥
 * @date 2013-5-12
 */
public final class InitLoader {

	private static final Logger logger = LoggerFactory.getLogger( InitLoader.class );

	/**
	 * init.
	 */
	public static void init() {

		/* 读取配置文件. */
		Configuration configuration;
		try {
			configuration = new PropertiesConfiguration( Constant.JDBC_CONFIG_PATH );
			Constant.jdbcDriver = configuration.getString( "jdbc.driver" );
			Constant.jdbcUrl = configuration.getString( "jdbc.url" );
			Constant.jdbcUsername = configuration.getString( "jdbc.username" );
			Constant.jdbcPassword = configuration.getString( "jdbc.password" );
		} catch ( ConfigurationException e ) {
			logger.error( "读取jdbc配置文件{}失败", Constant.JDBC_CONFIG_PATH );
			e.printStackTrace();
		}

		/* 读取创建表sql. */
		Constant.createTablesSql = readJarFile( Constant.CREATE_TABLES_SQL_PATH );

		/* 初始化表. */
		CreateTablesDao createTablesDao = new CreateTablesDao();
		createTablesDao.initTables();
		logger.info( "初始化SQL:\n{}", Constant.createTablesSql );

		/* 加载呼叫程序选项. */
		CallOptionService callOptionService = new CallOptionService();
		List<CallOptionBean> beans = callOptionService.find();
		if ( CollectionUtils.isNotEmpty( beans ) ) {
			for ( CallOptionBean bean : beans ) {
				Constant.comboBoxModel.addElement( bean );
			}
		}
	}

	/**
	 * 读取jar里的文件.
	 * 
	 * @param entryName
	 * @return
	 */
	@SuppressWarnings( "resource" )
	public static String readJarFile( String entryName ) {
		StringBuilder sql = new StringBuilder();
		File file = new File( SystemUtils.USER_DIR, SystemUtils.JAVA_CLASS_PATH );
		InputStream inputStream = null;
		try {
			JarFile jarFile = new JarFile( file );
			JarEntry entry = jarFile.getJarEntry( entryName );
			inputStream = jarFile.getInputStream( entry );
			List<String> lines = IOUtils.readLines( inputStream, CharEncoding.UTF_8 );
			if ( CollectionUtils.isNotEmpty( lines ) ) {
				for ( String line : lines ) {
					sql.append( line ).append( SystemUtils.LINE_SEPARATOR );
				}
			}
		} catch ( Exception e ) {
		} finally {
			IOUtils.closeQuietly( inputStream );
		}
		return sql.toString();
	}

}