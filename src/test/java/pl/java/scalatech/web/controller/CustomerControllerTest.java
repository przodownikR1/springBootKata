package pl.java.scalatech.web.controller;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import pl.java.scalatech.domain.Customer;
import pl.java.scalatech.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers=CustomerController.class) //without starting a full HTTP server
public class CustomerControllerTest {
    
    @MockBean
    private CustomerRepository customerRepository;
    
    @Autowired
    MockMvc mockMvc;
    
    @Test
    public void shouldBootstap() throws Exception{
        given(customerRepository.findOne(any(Long.class))).willReturn(Customer.builder().firstName("slawek").lastName("borowiec").build());
        mockMvc.perform(get("/customer/1").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

}
