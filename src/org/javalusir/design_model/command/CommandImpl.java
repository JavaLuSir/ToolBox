package org.javalusir.design_model.command;

/**
 * command design model 
 * @author JavaLuSir
 *
 */
public class CommandImpl implements Command{

	private Receiver receicer;
	
	public CommandImpl(Receiver receiver){
		this.receicer=receiver;
	}
	@Override
	public void execute() {
		receicer.action();
	}
	
	public Receiver getReceicer() {
		return receicer;
	}
	public void setReceicer(Receiver receicer) {
		this.receicer = receicer;
	}

}
