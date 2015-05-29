/*
 * Copyright 1999-2011 Alibaba Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package boot.dubbo.normal.client;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import boot.dubbo.api.User;
import boot.dubbo.api.UserService;

public class DemoConsumer {

	@Test
	public void test() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "classpath:/META-INF/spring/applicationContext-dubbo.xml" });
		ctx.start();

		System.out.println(ctx.getStartupDate());
		UserService userService = ctx.getBean("userService", UserService.class);
		while (true) {
			List<User> users = userService.findAll();
			User u = new User();
			Random r = new Random();
			u.setName("gsadg" + r.nextInt());
			String v = userService.create(u);
			System.out.println("返回结果：" + v + "size:" + users.size() );
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// try {
		// System.in.read();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
	}
}