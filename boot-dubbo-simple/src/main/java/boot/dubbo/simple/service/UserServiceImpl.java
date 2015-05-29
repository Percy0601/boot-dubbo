package boot.dubbo.simple.service;

import java.util.ArrayList;
import java.util.List;

import boot.dubbo.api.User;
import boot.dubbo.api.UserService;

import com.alibaba.dubbo.config.annotation.Service;

@Service(protocol = { "dubbo" })
public class UserServiceImpl implements UserService {

	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		User user = new User();
		user.setId(1);
		user.setName("Percy Mutils");
		users.add(user);
		return users;
	}

	@Override
	public String create(User user) {
		return "userId:123df";
	}

}
