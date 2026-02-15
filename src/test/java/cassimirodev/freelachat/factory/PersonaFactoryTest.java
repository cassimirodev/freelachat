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

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class PersonaFactoryTest {

    @Mock
    private FakerConfig faker;

    @InjectMocks
    private PersonaFactory factory;

    @Test
    public void  itCanCreateAPersona() {

        when(faker.data()).thenReturn(new Faker());

        Persona persona = factory.createRandomPersona();

        assertNotNull(persona);
        assertNotNull(persona.getName());
        assertNotNull(persona.getType());
        assertNotNull(persona.getSystemPrompt());

    }

    @Test
    public void itShouldCreateDifferentPersonas() {

        Set<Persona> resultants = new HashSet<>();

        when(faker.data()).thenReturn(new Faker());

        for (int i = 0; i < 100; i++) {
            Persona persona = factory.createRandomPersona();
            resultants.add(persona);
        }
    }


}
