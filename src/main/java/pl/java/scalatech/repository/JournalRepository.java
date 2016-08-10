package pl.java.scalatech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.scalatech.domain.Journal;

public interface JournalRepository extends JpaRepository<Journal, Long> {

}