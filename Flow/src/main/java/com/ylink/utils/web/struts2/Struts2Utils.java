package com.ylink.utils.web.struts2;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ylink.utils.web.ServletUtils;

/**
 * Struts2Utils
 * 
 * @author 潘瑞峥
 * @date 2012-10-9
 */
public class Struts2Utils {

	/** header 常量定义 */
	private static final String HEADER_ENCODING = "encoding";
	private static final String HEADER_NOCACHE = "no-cache";
	private static final String DEFAULT_ENCODING = "UTF-8";
	private static final boolean DEFAULT_NOCACHE = true;

	private static ObjectMapper mapper = new ObjectMapper();

	/**
	 * 直接输出JSON,使用Jackson转换Java对象.
	 * 
	 * @param data
	 */
	public static void renderJson( final Object data, final String... headers ) {
		HttpServletResponse response = initResponseHeader( ServletUtils.JSON_TYPE, headers );
		try {
			mapper.writeValue( response.getWriter(), data );
		} catch ( IOException e ) {
			throw new IllegalArgumentException( e );
		}
	}

	/**
	 * 分析并设置contentType与headers.
	 */
	private static HttpServletResponse initResponseHeader( final String contentType, final String... headers ) {
		// 分析headers参数
		String encoding = DEFAULT_ENCODING;
		boolean noCache = DEFAULT_NOCACHE;
		for ( String header : headers ) {
			String headerName = StringUtils.substringBefore( header, ":" );
			String headerValue = StringUtils.substringAfter( header, ":" );

			if ( StringUtils.equalsIgnoreCase( headerName, HEADER_ENCODING ) ) {
				encoding = headerValue;
			} else if ( StringUtils.equalsIgnoreCase( headerName, HEADER_NOCACHE ) ) {
				noCache = Boolean.parseBoolean( headerValue );
			} else {
				throw new IllegalArgumentException( headerName + "不是一个合法的header类型" );
			}
		}

		HttpServletResponse response = ServletActionContext.getResponse();

		// 设置headers参数
		String fullContentType = contentType + ";charset=" + encoding;
		response.setContentType( fullContentType );
		if ( noCache ) {
			ServletUtils.setNoCacheHeader( response );
		}

		return response;
	}

}