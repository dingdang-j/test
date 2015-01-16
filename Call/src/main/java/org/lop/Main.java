package org.lop;

import java.io.IOException;

import org.lop.frame.CallFrame;
import org.lop.modules.utils.InitLoader;

public class Main {

	public static void main( String[] args ) throws IOException {
		InitLoader.init();
		CallFrame.init();
	}

}