package controller;

import dto.AccountDto;
import dto.ContactDto;
import entity.Account;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/contact")
public interface ContactsController {

    @GetMapping("/list")
    List <ContactDto> getContacts();

    @PostMapping("/add")
    ContactDto addContact(@RequestBody ContactDto contactDto);

    @GetMapping("/get/{id}")
    ContactDto getContact(@PathVariable Integer id);

    @PutMapping("/edit/{id}")
    ContactDto editContact(@RequestBody ContactDto contactDto, @PathVariable Integer id);

    @GetMapping("/detail/{accountId}")
    List <ContactDto> getDetail(@PathVariable Integer accountId);

    @GetMapping("/all/{id}")
    List<ContactDto> getAllContacts(@PathVariable Integer id);
}
