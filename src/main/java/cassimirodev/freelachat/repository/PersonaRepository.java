package cassimirodev.freelachat.repository;

import cassimirodev.freelachat.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
