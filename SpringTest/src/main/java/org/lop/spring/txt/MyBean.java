package org.lop.spring.txt;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.core.io.Resource;

public class MyBean {

	private Resource content;

	public Resource getContent() {
		return content;
	}

	public void setContent( Resource content ) {
		this.content = content;
	}

	@Override
	public String toString() {
		try {
			return String.format( "content: %s", FileUtils.readFileToString( content.getFile() ) );
		} catch ( IOException e ) {
		}
		return null;
	}

}