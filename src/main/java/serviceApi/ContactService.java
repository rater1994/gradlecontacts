package serviceApi;

import dto.ContactDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface ContactService {

   List<ContactDto> getAllContactDTO();

   ContactDto addNewContactDTO(@RequestBody ContactDto contactDto);

   ContactDto getContactDTO(@PathVariable Integer id);

   ContactDto editContactDTO(@RequestBody ContactDto contactDto, @PathVariable Integer id);

   List<ContactDto> getDetailDTO(@PathVariable Integer userId, @PathVariable Integer contactId);


}
