package cassimirodev.freelachat.enums;

import cassimirodev.freelachat.factory.PersonaFactory;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class PersonaTypeTest {


    /**
     * Testa se os valores correspondem aos indices do enum.
     */
    @Test
    void arrayShouldHaveCorrectIndex() {
        PersonaType[] values = PersonaType.values();

        assertEquals(5, values.length);
        assertEquals(PersonaType.BRAVA, values[0]);
        assertEquals(PersonaType.CALMA, values[1]);
        assertEquals(PersonaType.IMPACIENTE, values[2]);
        assertEquals(PersonaType.EXPERIENTE, values[3]);
        assertEquals(PersonaType.ANSIOSA, values[4]);
    }

    /**
     * Testa se o metodo retorna os valores do enum corretamente
     */
    @RepeatedTest(100)
    void shouldReturnOnlyEnumValues() {
        PersonaFactory factory = new PersonaFactory(null, null);
        PersonaType result = factory.getRandomPersonaType();

        boolean isValid = result == PersonaType.BRAVA ||
                result == PersonaType.CALMA ||
                result == PersonaType.IMPACIENTE ||
                result == PersonaType.EXPERIENTE ||
                result == PersonaType.ANSIOSA;

        assertTrue(isValid);
    }

    /**
     * Testa se o metodo realmente retorna os valores aleatoriamente
     */
    @Test
    void shouldReturnARandomPersonalityDifferentEveryTime() {
        PersonaFactory factory = new PersonaFactory(null, null);
        Set<PersonaType> resultants = new HashSet<>();

        for (int i = 0; i < 100; i++) {
            PersonaType tipo = factory.getRandomPersonaType();
            resultants.add(tipo);
        }

        assertTrue(resultants.size() > 1);
    }
}
