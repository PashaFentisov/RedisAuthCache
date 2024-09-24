package core.redisauthcache.repository;

import core.redisauthcache.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u left join fetch u.role WHERE u.username = :username")
    Optional<User> findByUsername(@Param("username") String username);

    boolean existsByEmail(@Param("email") String email);
}