package org.lop.modules.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.h2.util.StringUtils;

/**
 * 工具.
 * 
 * @author 潘瑞峥
 * @date 2013-5-8
 */
public class UUIDUtils {

	/**
	 * 生成UUID.
	 * 
	 * @return
	 */
	public static String uuid() {
		return StringUtils.replaceAll( UUID.randomUUID().toString(), "-", "" );
	}

	/**
	 * 返回yyyyMMdd的当前日期.
	 * 
	 * @return
	 */
	public static String getDate() {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat( "yyyyMMdd" );
		return format.format( date );
	}

	public static void main( String[] args ) {
		System.out.println( uuid() );
		System.out.println( uuid() );
		System.out.println( uuid() );
		System.out.println( uuid() );
		System.out.println( uuid() );
	}

}