package serviceApiImpl;


import dto.AccountDto;
import dto.ContactDto;
import entity.Account;
import entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import repository.AccountRepository;
import repository.ContactRepository;
import serviceApi.AccountService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ContactRepository contactRepository;

    String admin = "admin";
    String user = "user";
    String activated = "activated";

    @Override
    public List <AccountDto> getAllAccountsDto() {
        List <AccountDto> list = new ArrayList <>();

        accountRepository.findAll().forEach( account -> list.add( account.toAccountDto() ) );
        return list;
    }

    @Override
    public ResponseEntity <String> addAccountDTO(AccountDto accountDto) {
        Account account = new Account();

        if (accountRepository.existsByUsername( accountDto.getUsername() )) {
            return new ResponseEntity <>( "Username already exist!", HttpStatus.BAD_REQUEST );
        } else {
            if (accountDto.getRole().equalsIgnoreCase( admin )) {
                accountDto.setRole( admin.toUpperCase() );
            } else {
                accountDto.setRole( user.toUpperCase() );
            }

            accountDto.setDeleteFlag( activated.toUpperCase() );
            account.updateAccountDto( accountDto );
            accountRepository.save( account ).toAccountDto();
            return new ResponseEntity <>( "Account was created", HttpStatus.OK );
        }

    }

    @Override
    public ResponseEntity <String> editAccountDTO(AccountDto accountDto, Integer id) {
        Optional <Account> dbAccount = accountRepository.findById( id );
        if (dbAccount.isPresent()) {
            Account account = dbAccount.get();
            account.setUsername( accountDto.getUsername() );
            account.setPassword( accountDto.getPassword() );
            account.setRole( accountDto.getRole() );
            account.setDeleteFlag( accountDto.getDeleteFlag() );
            accountRepository.save( account ).toAccountDto();
            return new ResponseEntity <>( "The account was edited!", HttpStatus.OK );
        }
        return new ResponseEntity <>( "The user not found", HttpStatus.BAD_REQUEST );
    }

    @Override
    public AccountDto findAccountDTO(Integer id) {
        Optional <Account> accountOptional = accountRepository.findById( id );
        Account account = accountOptional.get();

        return account.toAccountDto();
    }

    @Override
    public ResponseEntity <String> deleteAccountDTO(Integer id) {
        Optional <Account> byId = accountRepository.findById( id );
        if (byId.isPresent()) {
            accountRepository.deleteById( id );
            return new ResponseEntity <>( "Account was succesfull deleted", HttpStatus.OK );
        } else {
            return new ResponseEntity <>( "Account was not found", HttpStatus.BAD_REQUEST );
        }
    }

    @Override
    public ResponseEntity <String> loginDto(String username, String password) {
        boolean findByIdDb = accountRepository.existsByUsername( username );
        boolean findByPasswordDb = accountRepository.existsByPassword( password );

        if (findByIdDb && findByPasswordDb) {
            return new ResponseEntity <>( "Successful login", HttpStatus.OK );
        } else {
            return new ResponseEntity <>( "Invalid credentials!", HttpStatus.BAD_REQUEST );
        }
    }
}
