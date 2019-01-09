package serviceApiImpl;


import dto.ContactDto;
import entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ContactRepository;
import serviceApi.ContactService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<ContactDto> getAllContactDTO() {
        List<ContactDto> listContactDto = new ArrayList<>();
        contactRepository.findAll().forEach(contact -> {
            listContactDto.add(contact.toContactDto());
        });
        return listContactDto;
    }

    @Override
    public ContactDto addNewContactDTO(ContactDto contactDto) {
        Contact contact = new Contact();
        contact.updateContactDto(contactDto);
        return  contactRepository.save(contact).toContactDto();
    }

    @Override
    public ContactDto getContactDTO(Integer id) {

        if(contactRepository.findById(id).isPresent()){
            return contactRepository.findById(id).get().toContactDto();
        }
        return null;
    }

    @Override
    public ContactDto editContactDTO(ContactDto contactDto, Integer id) {
        Optional<Contact> dbContact = contactRepository.findById(id);

        if (dbContact.isPresent()) {
            Contact contact = dbContact.get();

            contact.setFirstName(contactDto.getFirstNameDto());
            contact.setLastName(contactDto.getLastNameDto());
            contact.setNumberPhone(contactDto.getNumberPhoneDto());
            return contactRepository.save(contact).toContactDto();

        } else {
            return null;
        }
    }

    @Override
    public List <ContactDto> getDetailDTO(Integer userId, Integer contactId) {
        List <ContactDto> listContactDto = new ArrayList <>();
        contactRepository.findByIdAndAccount( userId, contactId ).forEach( contact -> {
            listContactDto.add( contact.toContactDto() );
        });
        return listContactDto;

    }

}
