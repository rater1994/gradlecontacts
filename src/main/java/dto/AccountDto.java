package dto;

import java.util.ArrayList;
import java.util.List;

public class AccountDto {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String deleteFlag;
    private String role;


    private List <ContactDto> contactDtoList = new ArrayList <>();


    public List <ContactDto> getContactDtoList() {
        return contactDtoList;
    }

    public void setContactDtoList(List <ContactDto> contactDtoList) {
        this.contactDtoList = contactDtoList;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

