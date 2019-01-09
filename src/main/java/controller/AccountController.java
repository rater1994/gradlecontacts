package controller;

import dto.AccountDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public interface AccountController {

    @GetMapping("/list")
    List <AccountDto> getAllAccounts();

    @PostMapping("/add")
    ResponseEntity <String> addAccount(@RequestBody AccountDto accountDto);

    @PutMapping("/edit/{id}")
    ResponseEntity <String> editAccount(@RequestBody AccountDto accountDto, @PathVariable Integer id);

    @GetMapping("/find/{id}")
    AccountDto findAccount(@PathVariable Integer id);

    @DeleteMapping("/delete/{id}")
    ResponseEntity <String> deleteAccount(@PathVariable Integer id);

    @GetMapping("/login/{username}/{password}")
    ResponseEntity <String> login(@PathVariable String username, @PathVariable String password);


}
