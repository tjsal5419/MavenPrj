package test_aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {

	public static void main(String[] args) {
		
		/*���ü��� �޾Ƽ� DI���ִ� ����*/
		ApplicationContext context = new ClassPathXmlApplicationContext("test_aop/aop-context.xml");
		
		Calc c = (Calc) context.getBean("calc");
		
		c.set(4, 5);
		int add = c.add();
		int sub = c.sub();
		
		System.out.println("��:"+add+"��:"+sub);
	}

}
