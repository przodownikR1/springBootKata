package pl.java.scalatech.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {

    @Id
    private Long id;
    
    private String name;
    
    private String owner;
    
    private BigDecimal payment;
}
