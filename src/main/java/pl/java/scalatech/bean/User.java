package pl.java.scalatech.bean;

import java.util.List;

import org.assertj.core.util.Lists;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User {
    public int id;
    public String name;
    @JsonBackReference
    public List<Item> userItems = Lists.newArrayList();
    
    public void addItem(Item item){
        this.userItems.add(item);
    }
}