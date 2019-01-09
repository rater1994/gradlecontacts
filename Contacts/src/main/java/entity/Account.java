package entity;


import accountDto.AccountDto;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@SQLDelete(sql = "UPDATE users SET delete_flag = 'DELETED' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "delete_flag <> 'DELETED'")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "email")
    private String email;


    public Account() {
    }

    public Account(Account account) {
        this.id = account.getId();
        this.username = account.getUsername();
        this.password = account.getPassword();

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

    public AccountDto toAccountDto() {
        AccountDto accountDto = new AccountDto();

        accountDto.setId( this.id );
        accountDto.setUsername( this.username );
        accountDto.setPassword( this.password );
        accountDto.setEmail( this.email );
        return accountDto;
    }

    public void updateAccountDto(AccountDto accountDto) {
        this.id = accountDto.getId();
        this.username = accountDto.getUsername();
        this.password = accountDto.getPassword();
        this.email = accountDto.getEmail();
    }
}
