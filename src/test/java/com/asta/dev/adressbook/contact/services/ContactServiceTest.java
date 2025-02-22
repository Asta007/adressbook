package com.asta.dev.adressbook.contact.services;

import com.asta.dev.adressbook.contact.ContactEntity;
import com.asta.dev.adressbook.contact.ContactRepository;
import com.asta.dev.adressbook.contact.exceptions.ContactNotFoundException;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ContactServiceTest {

    @InjectMocks
    private ContactService contactService;

    @Mock
    private ContactRepository contactRepository;

    private List <ContactEntity> mockContacts ;

    @BeforeEach
    public void mocking() {
        ContactEntity contact1 = new ContactEntity();
        contact1.setId(1L);
        contact1.setEmail("email");
        contact1.setFirstName("firstname");
        contact1.setLastName("lastname");
        contact1.setAddress("address");
        contact1.setDateOfBirth("1988-03-18");

        ContactEntity contact2 = new ContactEntity();
        contact2.setId(2L);
        contact2.setEmail("email2");
        contact2.setFirstName("firstname2");
        contact2.setLastName("lastname2");
        contact2.setAddress("address2");
        contact2.setDateOfBirth("1988-03-18");

        mockContacts = List.of(contact1, contact2);
    }

    @Test
    void findAll() {
        when(contactRepository.findAll()).thenReturn(mockContacts);
        assertTrue(contactService.findAll().isPresent());
        assertEquals(2, mockContacts.size());
    }

    @Test
    void findByIdOk() {
        // Arrange ( mock )
        when(contactRepository.findById(any())).thenReturn(Optional.of(mockContacts.get(0)));

        // Act
        Optional<ContactEntity> contactById = contactService.findById(1L);

        // Assert
        assertTrue(contactById.isPresent());
        assertEquals("firstname", contactById.get().getFirstName());
    }

    @Test
    void findByIdKo() {
        Long id = 999999999L;
        // Arrange ( mock )
        when(contactRepository.findById(any())).thenReturn(Optional.empty());
        when(contactRepository.findById(id)).thenReturn(Optional.empty());

        // Act
        Optional<ContactEntity> contactById = contactRepository.findById(0L);
        ContactNotFoundException exception = assertThrows(ContactNotFoundException.class, () ->
                contactService.findById(id)
        );

        // Assert
        assertFalse(contactById.isPresent());
    }

    @Test
    void findByEmailOk() {
        // Arrange ( mock )
        when(contactRepository.findByEmail(anyString())).thenReturn(Optional.of(mockContacts.get(0)));

        // Act
        Optional<ContactEntity> contactByEmail = contactRepository.findByEmail("email");

        // Assert
        assertTrue(contactByEmail.isPresent());
        assertEquals("firstname", contactByEmail.get().getFirstName());
        assertEquals("lastname", contactByEmail.get().getLastName());
        assertEquals("address", contactByEmail.get().getAddress());
        assertEquals("email", contactByEmail.get().getEmail());
        assertEquals("1988-03-18", contactByEmail.get().getDateOfBirth());
    }

    @Test
    void findByEmailKo() {
        when(contactRepository.findByEmail(anyString())).thenReturn(Optional.empty());

        // Act
        Optional<ContactEntity> contactByEmail = contactRepository.findByEmail("email3");

        // Assert
        assertFalse(contactByEmail.isPresent());
    }

    @Test
    void saveOk() {
        when(contactRepository.findByEmail(anyString())).thenReturn(Optional.empty());
        ContactEntity contacttosave = new ContactEntity();
        contacttosave.setEmail("email");
        contacttosave.setFirstName("firstname");
        contacttosave.setLastName("lastname");
        contacttosave.setAddress("address");
        contacttosave.setDateOfBirth("1988-03-18");
        Optional<ContactEntity> savedcontact = Optional.of(contactService.save(contacttosave));
        assertTrue(savedcontact.isPresent());
    }
    @Test
    @Disabled
    void saveKo() {
        Optional<ContactEntity> contactEntity = Optional.of(new ContactEntity());
        when(contactRepository.findByEmail(anyString())).thenReturn(contactEntity);
        ContactEntity contacttosave = new ContactEntity();
//        contacttosave.setId(1L);
        contacttosave.setEmail("email");
        contacttosave.setFirstName("firstname");
        contacttosave.setLastName("lastname");
        contacttosave.setAddress("address");
        contacttosave.setDateOfBirth("1988-03-18");
        ContactEntity savedcontact = contactService.save(contacttosave);
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}