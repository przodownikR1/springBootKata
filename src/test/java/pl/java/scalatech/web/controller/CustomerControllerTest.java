package pl.java.scalatech.web.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.Customer;
import pl.java.scalatech.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
@Slf4j
public class CustomerControllerTest {

    @Autowired
    private MockMvc mvc;
    
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    public CustomerRepository customerRepository;

    @Test
    // @formatter:off
    public void shouldRetrieveCustomer() throws Exception {
        given(customerRepository.findOne(1L)).willReturn(new Customer(1l,"slawek", "borowiec"));
        mvc.perform(get("/customer/{id}", 1L)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk()) //status().is2xxSuccessful())
                .andExpect(jsonPath("$.firstName", is("slawek")))
                .andExpect(jsonPath("$.lastName", is("borowiec")))
                .andExpect(content()
                .json("{'id':1,'firstName':'slawek','lastName':'borowiec'}"));
    }
   // @formatter:on

    @Test
    @Ignore
    public void keyCodeThrownException() throws Exception {
        doThrow(Exception.class).when(customerRepository).findByFirstNameLike("pawel");
        mvc.perform(get("/customer/firstname/pawel")).andExpect(status().is5xxServerError());
        verify(customerRepository, times(1)).findByFirstNameLike("pawel");
    }

    @Test
    //TODO
    @Ignore
    // @formatter:off
    public void shouldSaveCustomer() throws Exception {
        Customer retCustomer = new Customer(2l, "slawek", "borowiec");
        given(this.customerRepository.save(new Customer("mike", "tyson"))).willReturn(retCustomer);
        String customerJson = "{ \"id\": \"2\",\"firstName\": \"slawek\", \"lastName\": \"borowiec\" }";
        mvc.perform(post("/customer/")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON)
                .content(customerJson)
        ).andExpect(status()
                .isCreated())
                 .andExpect(header().string("Location", notNullValue()))
                .andExpect(jsonPath("$.id")
                .isNotEmpty())
                .andExpect(jsonPath("$.lastName").value("borowiec"));
    }
 // @formatter:on
    @Test
    public void shouldMarshallerWork() throws JsonProcessingException{
        Customer customerResult = new Customer(2l,"slawek","borowiec");
        log.info("customer marshaller test : {}",objectMapper.writeValueAsString(customerResult));
    }
    
    
    @Test
    @Ignore
    // @formatter:off
    public void shouldSaveCustomerMarshall() throws Exception {
        Customer retCustomer = new Customer(2l, "slawek", "borowiec");
        given(customerRepository.save(new Customer("mike", "tyson"))).willReturn(retCustomer);
        Customer customerResult = new Customer(2l,"slawek","borowiec");
        mvc.perform(post("/customer/")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(customerResult))
        ).andExpect(status()
                .isCreated())
                .andExpect(jsonPath("$.id")
                .isNotEmpty())
                .andExpect(jsonPath("$.lastName").value("borowiec"));
    }
 // @formatter:on
}