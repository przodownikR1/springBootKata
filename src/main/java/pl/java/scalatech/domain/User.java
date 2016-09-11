package pl.java.scalatech.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable {
  @GeneratedValue
  @Id
  private Long id;

  private String email;

  private String name;

  private String github;
}