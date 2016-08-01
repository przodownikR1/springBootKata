package pl.java.scalatech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import pl.java.scalatech.domain.User;
@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long>{

}
