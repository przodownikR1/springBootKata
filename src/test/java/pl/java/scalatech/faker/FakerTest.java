package pl.java.scalatech.faker;

import java.util.Locale;

import org.junit.Test;

import com.github.javafaker.Faker;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FakerTest {
    
    @Test
    public void shouldFakerWork(){
        Faker faker = new Faker();
        log.info("{}",faker.address().city());
        log.info("{}",faker.address().country());
        log.info("{}",faker.address().latitude());
        log.info("{}",faker.address().longitude());
        log.info("{}",faker.address().firstName());
        log.info("{}",faker.address().lastName());
        log.info("{}",faker.address().streetName());
        log.info("{}",faker.address().streetAddressNumber());
        log.info("{}",faker.address().zipCode());
        log.info("====================");
        log.info("{}",faker.business().creditCardExpiry());
        log.info("{}",faker.business().creditCardNumber());
        log.info("{}",faker.business().creditCardType());
        log.info("====================");
        log.info("{}",faker.code().isbn13());
        log.info("{}",faker.code().isbn10());
        log.info("====================");
        log.info("{}",faker.lorem().sentence());
        log.info("{}",faker.lorem().sentences(1));
        log.info("{}",faker.lorem().paragraph(1));
        log.info("{}",faker.lorem().words(4));
        log.info("{}",faker.lorem().word());
        log.info("====================");
        log.info("{}",faker.company().name());
        log.info("====================");
        log.info("{}",faker.country().iso());
        log.info("{}",faker.country().name());
        log.info("====================");
        log.info("{}",faker.internet().avatar());
        log.info("{}",faker.internet().emailAddress());
        log.info("{}",faker.internet().image());
        log.info("{}",faker.internet().url());
        log.info("{}",faker.internet().image(200, 200, false, "przodownik"));
        log.info("====================");
        log.info("{}",faker.phoneNumber().phoneNumber());
        log.info("====================");
        log.info("{}",faker.numerify("3434##4444"));
        
    }
    
}
