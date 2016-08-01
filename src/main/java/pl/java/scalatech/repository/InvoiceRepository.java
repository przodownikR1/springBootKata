package pl.java.scalatech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.scalatech.domain.Customer;
import pl.java.scalatech.domain.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long>{

}
