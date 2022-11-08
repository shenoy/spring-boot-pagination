package dev.shenoy.jpapaging.data;

import com.github.javafaker.Faker;
import dev.shenoy.jpapaging.model.Address;
import dev.shenoy.jpapaging.model.Person;
import dev.shenoy.jpapaging.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class SampleDataLoader implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(SampleDataLoader.class);

    private final PersonRepository personRepository;
    private final Faker faker;

    public SampleDataLoader(PersonRepository personRepository, Faker faker) {
        this.personRepository = personRepository;
        this.faker = faker;
    }


    @Override
    public void run(String... args) throws Exception {
        logger.info("Loading sample data....");

        List<Person> people = IntStream.rangeClosed(1,100).mapToObj(i -> new Person(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.phoneNumber().cellPhone(),
                faker.internet().emailAddress(),
                new Address(
                        faker.address().streetAddress(),
                        faker.address().city(),
                        faker.address().state(),
                        faker.address().zipCode()
                )
                ))
                .collect(Collectors.toList());

        personRepository.saveAll(people);

    }
}
