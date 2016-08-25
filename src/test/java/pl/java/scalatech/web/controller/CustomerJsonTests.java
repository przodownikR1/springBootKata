package pl.java.scalatech.web.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import pl.java.scalatech.domain.Customer;

@RunWith(SpringRunner.class)
@JsonTest
public class CustomerJsonTests {

    private JacksonTester<Customer> json;

    @Test
    @Ignore
    public void serializeJson() throws IOException {
        Customer customer = new Customer(1l, "przodownik", "pracy");

        assertThat(this.json.write(customer))
            .extractingJsonPathStringValue("pracy")
            .isEqualTo("przodownik");
    }

}