package com.main.easyFix.parts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface PartRepository extends JpaRepository<Part, Integer> {
  Optional<Part> findById(int id);
  List<Part> findAll();
}
