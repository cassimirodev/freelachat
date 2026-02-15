package cassimirodev.freelachat.factory;


import cassimirodev.freelachat.component.PersonalityPersonaPromptTemplate;
import cassimirodev.freelachat.config.FakerConfig;
import cassimirodev.freelachat.enums.PersonaType;
import cassimirodev.freelachat.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonaFactory {

    @Autowired
    private FakerConfig faker;


    public Persona createRandomPersona() {
        PersonaType type = PersonaType.getRandomPersonality();
        String systemPrompt = PersonalityPersonaPromptTemplate.getPersonalityPromptToPersona(type);

        Persona persona = new Persona();

        persona.setName(faker.data().name().fullName());
        persona.setType(type);
        persona.setSystemPrompt(systemPrompt);

        return persona;
    }


}
