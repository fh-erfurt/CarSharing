package main.repository;

import main.model.TestModel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class TestModelConfig {
    @Bean
    CommandLineRunner commandLineRunner (
            TestModelRepository repository
    ) {
        return args -> {
            TestModel modelA = new TestModel(
                    1L,
                    "John",
                    "john.info@gmail.com",
                    LocalDate.of(1990, AUGUST, 18)
            );

            TestModel modelB = new TestModel(
                    "Jane",
                    "jane.info@gmail.com",
                    LocalDate.of(1996, MAY, 20)
            );

            repository.saveAll(
                    List.of(modelA, modelB)
            );
        };
    }
}
