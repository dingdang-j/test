package org.lop.command.impl;

import org.lop.command.Command;
import org.lop.command.light.Light;

public class LightOnCommand implements Command {

	Light light;

	public LightOnCommand( Light light ) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.on();
	}

}