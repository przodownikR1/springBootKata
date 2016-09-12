package pl.java.scalatech.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Customer {

    @Id @GeneratedValue
    private String id;  
    private String firstName;
    private String lastName;
    public Customer(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }

}