package boot.dubbo.infrastructure.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import boot.dubbo.infrastructure.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
