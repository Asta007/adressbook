package com.asta.dev.adressbook.contact;

import com.asta.dev.adressbook.contact.services.ContactService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("contact")
public class ContactController {

    private ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping()
    public ResponseEntity<List<ContactEntity>> findAll() {
        Optional<List<ContactEntity>> contacts = contactService.findAll();
        return new ResponseEntity<>(contacts.get(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ContactEntity> findById(@PathVariable long id) {
        Optional<ContactEntity> contact = contactService.findById(id);
        return new ResponseEntity<>(contact.get(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ContactEntity> create(@RequestBody @Valid ContactEntity contact) {
        contactService.save(contact);
        return new ResponseEntity<>(contact, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<ContactEntity> update(@RequestBody ContactEntity contact) {
        contactService.update(contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public HttpStatus delete(@PathVariable long id) {
        contactService.delete(id);
        return HttpStatus.OK;
    }

}
