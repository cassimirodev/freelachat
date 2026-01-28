package cassimirodev.freelachat.repository;

import cassimirodev.freelachat.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
