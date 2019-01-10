package controllerImpl;


import controller.ContactsController;
import dto.AccountDto;
import dto.ContactDto;
import entity.Account;
import entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import repository.ContactRepository;
import serviceApi.ContactService;

import java.util.List;

@RestController
public class ContactControllerImpl implements ContactsController {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ContactService contactService;

    public ContactControllerImpl(ContactRepository contactRepository, ContactService contactService) {
    this.contactRepository = contactRepository;
    this.contactService = contactService;
    }

    @Override
    public List<ContactDto> getContacts() {
        return contactService.getAllContactDTO();
    }

    @Override
    public ContactDto addContact(@RequestBody ContactDto contactDto) {
        return contactService.addNewContactDTO(contactDto);
    }

    @Override
    public ContactDto getContact(@PathVariable Integer id) {
            return contactService.getContactDTO(id);
    }

    @Override
    public ContactDto editContact(@RequestBody ContactDto contactDto, @PathVariable Integer id) {
       return contactService.editContactDTO(contactDto, id);
    }

    @Override
    public List <ContactDto> getDetail(@PathVariable Integer accountId) {
        return contactService.getDetailDTO(accountId );
    }

    @Override
    public List <ContactDto> getAllContacts(@PathVariable Integer id) {
        return contactService.getAllContactsDTO( id );
    }

}
