package pl.java.scalatech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.scalatech.domain.Invoice;

public interface InvoiceRepo extends JpaRepository<Invoice, Long>{

}
