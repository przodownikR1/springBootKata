package pl.java.scalatech.bean;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreatorJsonExample {
    public int id;
    public String name;

    @JsonCreator
    public CreatorJsonExample(@JsonProperty("name") String name, @JsonProperty("id") int id) {
        this.id = id;
        this.name = name;
    }
}