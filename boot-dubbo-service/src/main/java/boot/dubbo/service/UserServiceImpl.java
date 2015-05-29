package boot.dubbo.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;

import boot.dubbo.api.User;
import boot.dubbo.api.UserService;
import boot.dubbo.infrastructure.repo.UserRepo;

import com.alibaba.dubbo.config.annotation.Service;

@Service(protocol = { "rest", "dubbo" })
@Path("user")
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;

	@Override
	@GET
	@Path("findAll")
	public List<User> findAll() {
		List<boot.dubbo.infrastructure.entity.User> users1 = userRepo.findAll();
		List<User> users = new ArrayList<User>();
		User user = new User();
		user.setId(1);
		user.setName("Percy Mutils");
		users.add(user);
		for (boot.dubbo.infrastructure.entity.User u : users1) {
			User ut = new User();
			ut.setId(u.getId());
			ut.setName(u.getUsername());
			users.add(ut);
		}
		return users;
	}

	@Override
	@POST
	@Path("create")
	public String create(@BeanParam User user) {
		System.out.println(user.getName());
		return "ksadjfsdf";
	}

}
