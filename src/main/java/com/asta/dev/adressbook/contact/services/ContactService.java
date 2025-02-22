package com.asta.dev.adressbook.contact.services;

import com.asta.dev.adressbook.contact.ContactEntity;
import com.asta.dev.adressbook.contact.ContactRepository;
import com.asta.dev.adressbook.contact.exceptions.ContactAlreadyExist;
import com.asta.dev.adressbook.contact.exceptions.ContactNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService implements IContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Optional<List<ContactEntity>> findAll() {
        List<ContactEntity> contacts = contactRepository.findAll();
        return Optional.of(contacts);
    }

//    @Override
//    public Optional<ContactEntity> findById(Long id) {
//        Optional<ContactEntity> contact = contactRepository.findById(id);
//        return contact;
//    }

    @Override
    public Optional<ContactEntity> findById(Long id) {
        if (contactRepository.findById(id).isPresent()){
            return Optional.of(contactRepository.findById(id).get());
        }
        throw new ContactNotFoundException("the contact can not be found");
    }

    @Override
    public ContactEntity save(ContactEntity contact) {
        if (contactRepository.findByEmail(contact.getEmail()).isPresent()){
            throw new ContactAlreadyExist("This Contact already exists");
        }
        contactRepository.save(contact);
        return contact;
    }

    @Override
    public Optional<ContactEntity> update(ContactEntity contact) {
        return contactRepository.findById(contact.getId())
                .map( updatedContact -> {
                    // update contact
                    updatedContact.setFirstName(contact.getFirstName());
                    updatedContact.setLastName(contact.getLastName());
                    updatedContact.setEmail(contact.getEmail());
                    updatedContact.setPhoneNumber(contact.getPhoneNumber());
                    updatedContact.setAddress(contact.getAddress());
                    updatedContact.setDateOfBirth(contact.getDateOfBirth());

                    //Check the email
                    Optional<ContactEntity> sameEmailContact = contactRepository.findByEmail(contact.getEmail());
                    if(sameEmailContact.isPresent() && !sameEmailContact.get().getId().equals(contact.getId())){
                        throw new ContactAlreadyExist("This Contact already exists");
                    }
                    contactRepository.save(updatedContact);
                    return Optional.of(updatedContact);
                })
                .orElseThrow( () -> new ContactNotFoundException("the contact can not be found"));
    }

    @Override
    public boolean delete(Long id) {
        if (contactRepository.findById(id).isPresent()){
            contactRepository.deleteById(id);
            return true;
        }
        throw new ContactNotFoundException("The contact you are deleting is not found");
    }
}