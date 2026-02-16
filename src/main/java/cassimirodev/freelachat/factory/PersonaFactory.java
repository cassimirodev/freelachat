package cassimirodev.freelachat.factory;


import cassimirodev.freelachat.component.PersonalityPersonaPromptTemplate;
import cassimirodev.freelachat.config.FakerConfig;
import cassimirodev.freelachat.enums.PersonaType;
import cassimirodev.freelachat.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonaFactory {

    private final FakerConfig faker;
    private final PersonalityPersonaPromptTemplate personaPromptTemplate;

    public PersonaFactory(FakerConfig faker, PersonalityPersonaPromptTemplate personaPromptTemplate) {
        this.faker = faker;
        this.personaPromptTemplate = personaPromptTemplate;
    }

    public Persona createRandomPersona() {
        PersonaType type = PersonaType.getRandomPersonality();
        String systemPrompt = personaPromptTemplate.getPersonalityPromptToPersona(type);

        Persona persona = new Persona();

        persona.setName(faker.data().name().fullName());
        persona.setType(type);
        persona.setSystemPrompt(systemPrompt);

        return persona;
    }


}
