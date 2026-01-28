package cassimirodev.freelachat.repository;

import cassimirodev.freelachat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
