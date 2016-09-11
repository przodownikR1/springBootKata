package pl.java.scalatech.web.controller;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import pl.java.scalatech.domain.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
///@Sql("/init-test.sql")
public class CustomerApplicationIntegrationTests {

	@Autowired
	private TestRestTemplate template;

	@Test
	public void randomPort() {
		Customer customer = template.getForObject("/customer/1", Customer.class);
		Assertions.assertThat(customer.getFirstName()).isEqualTo("slawek");
	}
}