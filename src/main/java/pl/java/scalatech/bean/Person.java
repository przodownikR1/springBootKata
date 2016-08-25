package pl.java.scalatech.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
@Data
@JsonPropertyOrder({ "name", "age","lastName","addressList" })
public class Person {

    private String name;
    private String lastName;
    private int age;
    private List<Address> addressList;

    //@JsonCreator
    public Person(@JsonProperty("name") String name,
                  @JsonProperty("lastName") String lastName,
                  @JsonProperty("age") int age,
                  @JsonProperty("addressList") List<Address> addressList) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.addressList = addressList;
    }

    // getters and setters

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("name: ")
                .append(this.name).append("\n")
                .append("lastName: ")
                .append(this.lastName).append("\n")
                .append("age: ")
                .append(this.age).append("\n");

        for (Address address: this.addressList) {
            stringBuilder.append(address.toString());
        }

        return stringBuilder.toString();
    }
}