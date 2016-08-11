package pl.java.scalatech.web.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.test.context.junit4.SpringRunner;

import pl.java.scalatech.domain.Customer;

@RunWith(SpringRunner.class)
@JsonTest
public class CustomerJsonTests {

    private JacksonTester<Customer> json;

    @Test
    public void serialize() throws IOException {
        Customer c = new Customer("slawek","borowiec");

        JsonContent<Customer> write = this.json.write(c);
        System.out.println(write.getJson());

     }

    @Test
    public void deserialize() throws IOException {
        String content = "{\"firstName\":\"slawek\",\"lastName\":\"borowiec\"}";

        assertThat(this.json.parse(content)).isEqualTo(new Customer("slawek","borowiec"));

    }
}