package com.ylink.utils.web;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 本地静态内容获取Servlet.
 * 
 * eg.static-content?contentPath=/xx/xx/xx.js(以WEB-INF/views之后的路径)
 * 
 * @author 潘瑞峥
 * @date 2012-10-10
 */
public class StaticContentServlet extends HttpServlet {

	private static final long serialVersionUID = 8986791009587571884L;

	/** 设置该路径以下为可访问目录，防止采用该方法去任意读取文件 */
	private static final String VIEWS_PATH = "WEB-INF/views";

	private MimetypesFileTypeMap mimetypesFileTypeMap;

	@Override
	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		// 取得参数
		String contentPath = request.getParameter( "contentPath" );
		if ( StringUtils.isBlank( contentPath ) ) {
			response.sendError( HttpServletResponse.SC_BAD_REQUEST, "contentPath parameter is required." );
			return;
		}

		// 获取请求内容的基本信息.
		ContentInfo contentInfo = getContentInfo( contentPath );

		// 设置Etag/过期时间
		ServletUtils.setExpiresHeader( response, ServletUtils.ONE_YEAR_SECONDS );
		ServletUtils.setLastModifiedHeader( response, contentInfo.lastModified );
		ServletUtils.setEtag( response, contentInfo.etag );

		// 设置MIME类型
		response.setContentType( contentInfo.mimeType );

		// 构造OutputStream
		OutputStream output;
		// 使用普通outputstream, 设置content-length.
		response.setContentLength( contentInfo.length );
		output = response.getOutputStream();

		// 高效读取文件内容并输出,然后关闭input file
		FileUtils.copyFile( contentInfo.file, output );
		output.flush();
	}

	@Override
	public void init() throws ServletException {
		// 默认缺少一些必要的.
		mimetypesFileTypeMap = new MimetypesFileTypeMap();
		mimetypesFileTypeMap.addMimeTypes( "text/css css" );
		mimetypesFileTypeMap.addMimeTypes( "application/x-javascript js" );
	}

	/**
	 * 创建Content基本信息.
	 */
	private ContentInfo getContentInfo( String contentPath ) {
		ContentInfo contentInfo = new ContentInfo();

		String realFilePath = getServletContext().getRealPath( VIEWS_PATH + contentPath );
		File file = new File( realFilePath );

		contentInfo.file = file;
		contentInfo.contentPath = contentPath;
		contentInfo.fileName = file.getName();
		contentInfo.length = ( int ) file.length();

		contentInfo.lastModified = file.lastModified();
		contentInfo.etag = "W/\"" + contentInfo.lastModified + "\"";
		contentInfo.mimeType = mimetypesFileTypeMap.getContentType( contentInfo.fileName );

		return contentInfo;
	}

	/**
	 * 定义Content的基本信息.
	 */
	static class ContentInfo {
		protected String contentPath;
		protected File file;
		protected String fileName;
		protected int length;
		protected String mimeType;
		protected long lastModified;
		protected String etag;
	}

}