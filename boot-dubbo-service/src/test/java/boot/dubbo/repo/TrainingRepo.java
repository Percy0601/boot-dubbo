package boot.dubbo.repo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import boot.ApplicationBootstrap;
import boot.dubbo.infrastructure.entity.User;
import boot.dubbo.infrastructure.repo.ComplexQueryRepo;
import boot.dubbo.infrastructure.repo.UserRepo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationBootstrap.class)
public class TrainingRepo {
	@Autowired
	UserRepo userRepo;
	@Autowired
	ComplexQueryRepo complexQueryRepo;
	
	@Test
	public void testMybatis() {
		List<User> users = complexQueryRepo.findUsersLike("");
		System.out.println("==========================:" + (users.size()));
	}
}
