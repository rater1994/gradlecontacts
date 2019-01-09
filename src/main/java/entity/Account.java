package entity;


import dto.AccountDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_username")
    private Integer id;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Email")
    private String email;

    @Column(name = "DeleteFlag")
    private String deleteFlag;

    @Column(name = "Role")
    private String role;

    @OneToMany(cascade = CascadeType.ALL)
    private List <Contact> contacts;


    public List <Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List <Contact> contacts) {
        this.contacts = contacts;
    }

    public Account(Account account) {
        this.id = account.getId();
        this.username = account.getUsername();
        this.password = account.getPassword();
        this.email = account.getEmail();
        this.deleteFlag = account.getDeleteFlag();
        this.role = account.getRole();
    }

    public Account() {
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public AccountDto toAccountDto() {
        AccountDto accountDto = new AccountDto();

        accountDto.setId( this.id );
        accountDto.setUsername( this.username );
        accountDto.setPassword( this.password );
        accountDto.setEmail( this.email );
        accountDto.setDeleteFlag( this.deleteFlag );
        accountDto.setRole( this.role );
        return accountDto;
    }

    public void updateAccountDto(AccountDto accountDto) {
        this.id = accountDto.getId();
        this.username = accountDto.getUsername();
        this.password = accountDto.getPassword();
        this.email = accountDto.getEmail();
        this.deleteFlag = accountDto.getDeleteFlag();
        this.role = accountDto.getRole();
    }
}
