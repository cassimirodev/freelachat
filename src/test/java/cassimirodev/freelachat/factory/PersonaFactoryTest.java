package cassimirodev.freelachat.factory;

import cassimirodev.freelachat.config.FakerConfig;
import cassimirodev.freelachat.factory.PersonaFactory;
import cassimirodev.freelachat.model.Persona;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@SpringBootTest
public class PersonaFactoryTest {

    private final PersonaFactory factory;

    public PersonaFactoryTest(PersonaFactory factory) {
        this.factory = factory;
    }

    @Test
    public void  itCanCreateAPersona() {


        Persona persona = factory.createRandomPersona();

        assertNotNull(persona);
        assertNotNull(persona.getName());
        assertNotNull(persona.getType());
        assertNotNull(persona.getSystemPrompt());

    }

    @Test
    public void itShouldCreateDifferentPersonas() {

        Set<String> resultants = new HashSet<>();


        for (int i = 0; i < 100; i++) {
            Persona persona = factory.createRandomPersona();
            resultants.add(persona.getName());
        }

        assertTrue(resultants.size() > 1);
    }


}
