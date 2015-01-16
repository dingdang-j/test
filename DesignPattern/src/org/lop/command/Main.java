package org.lop.command;

import org.lop.command.impl.LightOnCommand;
import org.lop.command.light.Light;

public class Main {

	public static void main( String[] args ) {
		SimpleRemoteControl remote = new SimpleRemoteControl();
		Light light = new Light();
		LightOnCommand lightOn = new LightOnCommand( light );

		remote.setCommand( lightOn );
		remote.buttonWasPressed();
	}

}