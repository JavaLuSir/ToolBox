package org.javalusir.design_model.command;

/**
 * Command Pattern 
 * @author JavaLuSir
 *
 */
public class Invoker {
	private Command command;
	
	public void runCommand(){
		command.execute();
	}

	public Command getCommand() {
		return command;
	}
	public void setCommand(Command command) {
		this.command = command;
	}
}
