package com.main.easyFix.appuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
  Optional<AppUser> findById(Long id);
  Optional<AppUser> findByEmail(String email);
  List<AppUser> findAll();

  @Transactional
  @Modifying
  @Query("UPDATE AppUser a " + "SET a.enabled = TRUE WHERE a.email = ?1")
  int enableAppUser(String email);
}
