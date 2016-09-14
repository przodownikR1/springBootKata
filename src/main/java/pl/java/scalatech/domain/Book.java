package pl.java.scalatech.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    
    
    private String name;
    
    private String author;
    
    private String isbn;
    
    @OneToMany
    @JoinColumn(name="bookId")
    private List<Customer> customers = Lists.newArrayList(); //owner

}
