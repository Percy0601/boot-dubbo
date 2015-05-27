package boot.dubbo.web;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import boot.dubbo.api.User;
import boot.dubbo.api.UserService;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Application.class)
//@WebAppConfiguration
public class TrainingTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "classpath:/META-INF/spring/applicationContext.xml" });
		ctx.start();

		System.out.println(ctx.getStartupDate());
		UserService userService = ctx.getBean("userService", UserService.class);
		while (true) {
			List<User> users = userService.findAll();
			System.out.println("返回结果：" + "size:" + users.size());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
