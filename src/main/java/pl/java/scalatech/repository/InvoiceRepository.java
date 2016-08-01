package pl.java.scalatech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import pl.java.scalatech.domain.Invoice;

@RepositoryRestResource(collectionResourceRel="invoices", path="invoices")
public interface InvoiceRepository extends JpaRepository<Invoice, Long>{

}
