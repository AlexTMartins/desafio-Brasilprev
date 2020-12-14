package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alex.challenge.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findUserByNameAndDocument(String name, String doc);
}