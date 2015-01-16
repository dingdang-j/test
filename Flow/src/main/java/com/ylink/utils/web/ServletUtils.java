package com.ylink.utils.web;

import javax.servlet.http.HttpServletResponse;

import com.google.common.net.HttpHeaders;

/**
 * ServletUtils
 * 
 * @author 潘瑞峥
 * @date 2012-10-9
 */
public class ServletUtils {

	/** Content Type定义 */
	public static final long ONE_YEAR_SECONDS = 60 * 60 * 24 * 365;
	public static final String TEXT_TYPE = "text/plain";
	public static final String JSON_TYPE = "application/json";
	public static final String XML_TYPE = "text/xml";
	public static final String HTML_TYPE = "text/html";
	public static final String JS_TYPE = "text/javascript";
	public static final String EXCEL_TYPE = "application/vnd.ms-excel";

	/**
	 * 设置客户端缓存过期时间的Header.
	 */
	public static void setExpiresHeader( HttpServletResponse response, long expiresSeconds ) {
		// Http 1.0 header, set a fix expires date.
		response.setDateHeader( HttpHeaders.EXPIRES, System.currentTimeMillis() + expiresSeconds * 1000 );
		// Http 1.1 header, set a time after now.
		response.setHeader( HttpHeaders.CACHE_CONTROL, "private, max-age=" + expiresSeconds );
	}

	/**
	 * 设置LastModified Header.
	 */
	public static void setLastModifiedHeader( HttpServletResponse response, long lastModifiedDate ) {
		response.setDateHeader( HttpHeaders.LAST_MODIFIED, lastModifiedDate );
	}

	/**
	 * 设置Etag Header.
	 */
	public static void setEtag( HttpServletResponse response, String etag ) {
		response.setHeader( HttpHeaders.ETAG, etag );
	}

	/**
	 * 设置禁止客户端缓存的Header.
	 */
	public static void setNoCacheHeader( HttpServletResponse response ) {
		// Http 1.0 header
		response.setDateHeader( HttpHeaders.EXPIRES, 1L );
		response.addHeader( HttpHeaders.PRAGMA, "no-cache" );
		// Http 1.1 header
		response.setHeader( HttpHeaders.CACHE_CONTROL, "no-cache, no-store, max-age=0" );
	}

}