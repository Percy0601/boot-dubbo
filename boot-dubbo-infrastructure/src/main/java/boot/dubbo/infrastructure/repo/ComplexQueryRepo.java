package boot.dubbo.infrastructure.repo;

import java.util.List;

import boot.dubbo.infrastructure.entity.User;

/**
 * 综合复杂查询<br>
 * 
 * 
 * @author percy
 *
 */
public interface ComplexQueryRepo {

	List<User> findUsersLike(String name);

}
