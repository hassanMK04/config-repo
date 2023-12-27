package net.hassanel.customerservice.dtos;

import lombok.Getter;
import lombok.Setter;


public class CustomerResponseDTO {
    private Long Id;
    private String firstName;
    private String lastName;
    private String email;

    public CustomerResponseDTO() {
    }

    public CustomerResponseDTO(Long id, String firstName, String lastName, String email) {
        Id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
