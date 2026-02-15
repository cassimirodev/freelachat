package cassimirodev.freelachat.enums;

import java.util.List;
import java.util.Random;

public enum PersonaType {
    BRAVA,
    CALMA,
    IMPACIENTE,
    EXPERIENTE,
    ANSIOSA;

    static final PersonaType[] values = PersonaType.values();
    private static final Random random = new Random();

    /*
      O random é uma classe que gera números aleatórios. Combinado com o nextInt(), ele vai gerar um numero aleatório entre 0 e a quantidade passada por values.length.
     */
    public static PersonaType getRandomPersonality() {
        return values[random.nextInt(values.length)];
    }
}
