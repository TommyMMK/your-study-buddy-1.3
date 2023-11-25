package th.mfu.repository;

import org.springframework.data.repository.CrudRepository;

import th.mfu.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{
    boolean existsByEmail(String email);

    User findByEmail(String email);

    User findByPassword(String password);
}
