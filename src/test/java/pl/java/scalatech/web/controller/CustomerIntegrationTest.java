package pl.java.scalatech.web.controller;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willReturn;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.Customer;
import pl.java.scalatech.repository.CustomerRepository;
import org.json.*;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Slf4j
public class CustomerIntegrationTest {

      @Rule
      public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/generated-snippets");
      
        @Autowired
        private TestRestTemplate restTemplate;

        @MockBean
        private CustomerRepository customerRepository;

        @Before
        public void setup() {
            given(this.customerRepository.findByFirstName("slawek")).willReturn(Lists.newArrayList(new Customer("slawek", "borowiec")));
        }

        @Test
        public void test() {
           ResponseEntity<String> result =  this.restTemplate.getForEntity("/customer/firstname/{firstName}", String.class, "slawek");
           log.info("+++  {}",result.getBody());
        }
        @Test
        public void test2() {
           ResponseEntity<Customer> result =  this.restTemplate.getForEntity("/customer/{id}", Customer.class, 1l);
           log.info("+++  {}",result.getBody());
        }

    
}
