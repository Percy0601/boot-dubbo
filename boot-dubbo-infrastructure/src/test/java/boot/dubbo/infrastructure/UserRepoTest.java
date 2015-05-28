package boot.dubbo.infrastructure;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import boot.dubbo.infrastructure.ApplicationBootstrap;
import boot.dubbo.infrastructure.entity.User;
import boot.dubbo.infrastructure.repo.ComplexQueryRepo;
import boot.dubbo.infrastructure.repo.UserRepo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationBootstrap.class)
//@TransactionConfiguration(defaultRollback = false)
public class UserRepoTest {
	
	@Autowired
	UserRepo userRepo;
	@Autowired
	ComplexQueryRepo complexQueryRepo;
	
	@Test
	public void test() {
		Random r = new Random();
		User user = new User();
		user.setPassword(UUID.randomUUID().toString());
		user.setUsername("admin" + r.nextInt());
		userRepo.save(user);
		System.out.println("==========================:" + (userRepo.findAll().size()));
	}

	@Test
	public void testMybatis() {
		List<User> users = complexQueryRepo.findUsersLike("");
		System.out.println("==========================:" + (users.size()));
	}
}
