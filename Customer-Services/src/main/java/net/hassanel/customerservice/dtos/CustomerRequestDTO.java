package net.hassanel.customerservice.dtos;

import lombok.Getter;
import lombok.Setter;


public class CustomerRequestDTO {
    private Long Id;
    private String firstName;
    private String lastName;
    private String email;

    public CustomerRequestDTO() {
    }

    public CustomerRequestDTO(Long id, String firstName, String lastName, String email) {
        Id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return Id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}
