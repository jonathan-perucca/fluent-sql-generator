package fluent;

import fluent.generator.sql.Sql;
import fluent.generator.sql.impl.SqlGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        String query = SqlGenerator.sql() // static constructor for generator
                                .select("user.*")
                                .from("User user")
                                    .join("UserSettings userSettings")
                                .where()
                                    .element("userSettings.monitor").isEqualTo("John")
                                    .and()
                                    .element("userSettings.enablePref").isNotNull()
                                .build();
        System.out.println(query);
    }

    @Bean
    public Sql sql() {
        return SqlGenerator.sql();
    }
}


