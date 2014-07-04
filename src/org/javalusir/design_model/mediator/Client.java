package org.javalusir.design_model.mediator;

public class Client {

	public static void main(String[] args) {

		   // 生成中介者 并注入到各个Colleague对象中
		   Mediator mediator = new Mediator();
		   Colleague colleague1 = new User(mediator);
		   Colleague colleague2 = new User(mediator);
		   Colleague colleague3 = new User(mediator);
		   // 注册对象到中介
		   mediator.addColleague(colleague1);
		   mediator.addColleague(colleague2);
		   mediator.addColleague(colleague3);
		   colleague1.setMediator(mediator);
		   colleague2.setMediator(mediator);
		   colleague3.setMediator(mediator);
		   // Colleague1 触发行为
		   colleague1.sendMessage("嗨，大家好！");
		   System.out.println();
		   // Colleague2 触发行为
		   colleague2.sendMessage("很高兴见到你！");
		   System.out.println();
		   // Colleague3 触发行为
		   colleague3.sendMessage("我们一起玩游戏吧！");
		   System.out.println();

	}
}
