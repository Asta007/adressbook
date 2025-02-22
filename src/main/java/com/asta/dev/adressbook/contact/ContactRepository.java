package com.asta.dev.adressbook.contact;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactRepository extends JpaRepository<ContactEntity,Long> {
    Optional<ContactEntity> findByEmail(String email);
}
