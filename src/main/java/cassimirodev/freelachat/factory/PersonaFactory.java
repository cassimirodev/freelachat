package cassimirodev.freelachat.factory;


import cassimirodev.freelachat.component.PersonalityPersonaPromptTemplate;
import cassimirodev.freelachat.config.FakerConfig;
import cassimirodev.freelachat.enums.PersonaType;
import cassimirodev.freelachat.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PersonaFactory {

    private final FakerConfig faker;
    private final PersonalityPersonaPromptTemplate personaPromptTemplate;
    private final Random random = new Random();


    public PersonaFactory(FakerConfig faker, PersonalityPersonaPromptTemplate personaPromptTemplate) {
        this.faker = faker;
        this.personaPromptTemplate = personaPromptTemplate;
    }

    public PersonaType getRandomPersonaType () {
        PersonaType[] types = PersonaType.values();
        PersonaType selectedType = types[random.nextInt(types.length)];

        return selectedType;
    }

    public Persona createRandomPersona() {
        PersonaType typeGenerated = getRandomPersonaType();
        String systemPrompt = personaPromptTemplate.getPersonalityPromptToPersona(typeGenerated);

        Persona persona = new Persona();

        persona.setName(faker.data().name().fullName());
        persona.setType(typeGenerated);
        persona.setSystemPrompt(systemPrompt);

        return persona;
    }


}
