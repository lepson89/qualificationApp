package com.qualification.app.repository;

import com.qualification.app.model.SimpleRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimpleRequestRepository extends JpaRepository<SimpleRequest, Long> {
}
