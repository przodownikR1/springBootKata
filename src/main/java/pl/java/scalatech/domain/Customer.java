package pl.java.scalatech.domain;

import java.util.List;

import org.assertj.core.util.Lists;
import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Data
public class Customer {

    @Id
    private String id;  
    private String firstName;
    private String lastName;
    List<Address> addresses = Lists.newArrayList();
}