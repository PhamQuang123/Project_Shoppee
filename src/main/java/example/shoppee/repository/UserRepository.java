package example.shoppee.repository;

import example.shoppee.model.entity.User;
import jakarta.persistence.PreRemove;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
