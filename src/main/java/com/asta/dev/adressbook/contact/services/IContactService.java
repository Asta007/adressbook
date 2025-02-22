package com.asta.dev.adressbook.contact.services;

import com.asta.dev.adressbook.contact.ContactEntity;

import java.util.List;
import java.util.Optional;

public interface IContactService {
    public Optional<List<ContactEntity>> findAll();
    public Optional<ContactEntity> findById(Long id);
    public ContactEntity save(ContactEntity contact);
    public Optional<ContactEntity> update(ContactEntity contact);
    public boolean delete(Long id);
}
