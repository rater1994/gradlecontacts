package repository;

import dto.AccountDto;
import dto.ContactDto;
import entity.Account;
import entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

 List<Contact> findAllByAccount(Account account);

}

