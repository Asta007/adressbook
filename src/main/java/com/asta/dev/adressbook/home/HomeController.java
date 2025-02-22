package com.asta.dev.adressbook.home;

import com.asta.dev.adressbook.contact.ContactEntity;
import com.asta.dev.adressbook.contact.services.ContactService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController {

    private final ContactService contactService;

    public HomeController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("")
    public String home(){
        return "Welcome home";
    }
}
