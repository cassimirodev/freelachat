package cassimirodev.freelachat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import net.datafaker.Faker;

import java.util.Locale;

@Configuration
public class FakerConfig {

    @Bean
    public Faker data() {
        return new Faker(new Locale("pt", "BR"));
    }
}
