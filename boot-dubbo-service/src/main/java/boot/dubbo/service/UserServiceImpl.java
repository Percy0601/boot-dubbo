package boot.dubbo.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import boot.dubbo.api.User;
import boot.dubbo.api.UserService;

import com.alibaba.dubbo.config.annotation.Service;

@Service(protocol = { "rest" })
@Path("user")
public class UserServiceImpl implements UserService {

	@Override
	@GET
	@Path("findAll")
	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		User user = new User();
		user.setId(1);
		user.setName("Percy Mutils");
		users.add(user);
		return users;
	}

}
