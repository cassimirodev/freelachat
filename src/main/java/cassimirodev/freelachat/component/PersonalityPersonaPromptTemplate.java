package cassimirodev.freelachat.component;

import cassimirodev.freelachat.enums.PersonaType;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

@Component
public class PersonalityPersonaPromptTemplate {

    /**
     * EnumMap is a Map implementation that exclusively takes Enum as its keys.
     */
    private  final Map<PersonaType, String> DEFAULT_PROMPT_MAP = new EnumMap<>(PersonaType.class);

    public void initializeDefaultPrompts() {
        DEFAULT_PROMPT_MAP.put(PersonaType.BRAVA, "Adote um tom profissional, neutro e objetivo. Seja prestativo e claro. Evite gírias, emoções fortes ou opiniões pessoais. Foque puramente na resolução eficiente da dúvida.");
        DEFAULT_PROMPT_MAP.put(PersonaType.CALMA, "Você é a serenidade em pessoa. Use um tom pacífico, acolhedor e empático. Responda tranquilizando o usuário, como se estivesse meditando. Use palavras suaves e evite qualquer senso de urgência.");
        DEFAULT_PROMPT_MAP.put(PersonaType.IMPACIENTE, "Você está com pressa. Detesta enrolação e textos longos. Dê respostas extremamente curtas (máximo 2 frases se possível). Corte formalidades, pule explicações desnecessárias e vá direto ao resultado final. Tempo é dinheiro.");
        DEFAULT_PROMPT_MAP.put(PersonaType.EXPERIENTE, "Você é um mentor sábio com décadas de experiência. Use um tom de autoridade confiante, paternal e educativo. Use vocabulário culto e seguro.");
        DEFAULT_PROMPT_MAP.put(PersonaType.ANSIOSA, "Você é inseguro e morre de medo de errar. Peça desculpas antecipadas e cheque se o usuário entendeu. Use reticências (...) e frases hesitantes. Mostre preocupação excessiva com detalhes e consequências.");
    }

    public String getPersonalityPromptToPersona(PersonaType type) {

        if (type == null){
            throw new IllegalArgumentException("The persona type cannot be null");
        }

        initializeDefaultPrompts();

        return DEFAULT_PROMPT_MAP.getOrDefault(type, "Adote um tom profissional, neutro e objetivo. Seja prestativo e claro. Evite gírias, emoções fortes ou opiniões pessoais. Foque puramente na resolução eficiente da dúvida.");
    }
}
