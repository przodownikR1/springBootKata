package pl.java.scalatech.json;

import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.bean.Address;
import pl.java.scalatech.bean.CreatorJsonExample;
import pl.java.scalatech.bean.Item;
import pl.java.scalatech.bean.Person;
import pl.java.scalatech.bean.User;
@RunWith(SpringRunner.class)
@JsonTest
@DataJpaTest
@Slf4j
public class JsonSimpleTest {
    @Autowired
    private ObjectMapper objectMapper;
    
    @Test
    public void shouldSerializationTest() throws JsonProcessingException{
        User user = new User(1, "Przodownik",newArrayList());
        Item i1 = new Item(1, "tv", user);
        Item i2 = new Item(2, "bike", user);
        user.addItem(i1);
        user.addItem(i2);
        
       log.info("user: {}",objectMapper.writeValueAsString(user)); 
       log.info("item1 : {}",objectMapper.writeValueAsString(i1)); 
    }
    @Test
    public void shouldCreateUser() throws JsonProcessingException{
        Address homeAddress = new Address(12345, "Stenhammer Drive");
        Address workAddress = new Address(7986, "Market Street");
        List<Address> addressList = new ArrayList<>();
        addressList.add(homeAddress);
        addressList.add(workAddress);
        Person person = new Person("Sawyer", "Bootstrapper", 23, addressList);
       
        String value = objectMapper.writeValueAsString(person);
        log.info("{}",value);
        
    }
    
    
    @Test
    public void shouldCreateJsonWork()
      throws JsonProcessingException, IOException {
        String json = "{\"id\":2,\"name\":\"przodownik\"}";     
        CreatorJsonExample bean = objectMapper.readerFor(CreatorJsonExample.class).readValue(json);
        assertEquals("przodownik", bean.name);
    }
}
