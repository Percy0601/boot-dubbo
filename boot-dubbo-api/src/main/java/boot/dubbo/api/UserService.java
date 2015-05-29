package boot.dubbo.api;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("user")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public interface UserService {
	/**
	 * 获取所有用户
	 * 
	 * @return所有用户
	 */
    @GET
    @Path("findAll")
	List<User> findAll();

    @GET
    @Path("create")
	String create(@BeanParam User user);
}
